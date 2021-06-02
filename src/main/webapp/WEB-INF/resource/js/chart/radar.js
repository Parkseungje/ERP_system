/**
 * 방사형 차트
 * 
 * 사용 예 )
 *	var h = 500;
 *	var maxValue = 1600;
 *	var levels = 8;
 *	var radarData = [
 *			  [
 *				{axis:"(FAQ)되묻기 트레이닝"  , value:350},
 *				{axis:"미응답 질문트레이닝"    , value:1200},
 *				{axis:"Q&A 교정트레이닝"     , value:500},
 *				{axis:"ChatLog 교정트레이닝" , value:250},
 *				{axis:"STT 교정트레이닝"     , value:400},
 *			  ]
 *			];		
 *	
 *	var radarConfig = {
 *	  h: h,
 *	  maxValue: maxValue,
 *	  levels: levels,
 *	  ExtraWidthX: 300
 *	}
 *
 *	RadarChart.draw("#chartRadar", radarData, radarConfig);	
 */
var RadarChart = {
  draw: function(id, labels, d, options){
  var cfg = {
	 radius: 3,
	 w: undefined,
	 h: 250,
	 factor: 1,
	 factorLegend: .85,
	 levels: 3,
	 maxValue: 0,
	 radians: 2 * Math.PI,
	 opacityArea: 0.5,
	 ToRight: 5,
	 TranslateX: 90,
	 TranslateY: 30,
	 ExtraWidthX: 150,
	 ExtraWidthY: 80,
	 color: d3.scale.category10(),
	};
	
	if('undefined' !== typeof options){
	  for(var i in options){
		if('undefined' !== typeof options[i]){
		  cfg[i] = options[i];
		}
	  }
	}
	cfg.w = cfg.h; // 가로 세로를 동일하게 설정. 비율을 동일하게 맞추지 않으면 그래프가 약간씩 틀어짐.
	cfg.maxValue = Math.max(cfg.maxValue, d3.max(d, function(i){return d3.max(i.map(function(o){return o.value;}))}));
	
	// max value 기준으로 그래프 Level을 알맞게 조정
	var maxValue = cfg.maxValue;
	var levels = Math.ceil(maxValue/d[0].length);
	var normalizedMaxValue = (Math.ceil(maxValue/levels)+2) * levels;
	var normalizedLevels = parseInt(normalizedMaxValue/levels);	
	cfg.maxValue = normalizedMaxValue;
	cfg.levels   = normalizedLevels;
	
	var allAxis = (d[0].map(function(i, j){return i.axis}));
	var total = allAxis.length;
	var radius = cfg.factor*Math.min(cfg.w/2, cfg.h/2);
	var Format = d3.format(cfg.format==undefined ? '' : cfg.format); // format 을 % 로 넣으면 비율로 표현
	d3.select('#'+id).select("svg").remove();
	
	var g = d3.select('#'+id)
			.append("svg")
			.attr("width", cfg.w+cfg.ExtraWidthX)
			.attr("height", cfg.h+cfg.ExtraWidthY)
			.append("g")
			.attr("transform", "translate(" + cfg.TranslateX + "," + cfg.TranslateY + ")");

	var tooltip;
	
	// 둘레 선
	//Circular segments
	for(var j=0; j<cfg.levels-1; j++){
	  var levelFactor = cfg.factor*radius*((j+1)/cfg.levels);
	  g.selectAll(".levels")
	   .data(allAxis)
	   .enter()
	   .append("svg:line")
	   .attr("x1", function(d, i){return levelFactor*(1-cfg.factor*Math.sin(i*cfg.radians/total));})
	   .attr("y1", function(d, i){return levelFactor*(1-cfg.factor*Math.cos(i*cfg.radians/total));})
	   .attr("x2", function(d, i){return levelFactor*(1-cfg.factor*Math.sin((i+1)*cfg.radians/total));})
	   .attr("y2", function(d, i){return levelFactor*(1-cfg.factor*Math.cos((i+1)*cfg.radians/total));})
	   .attr("class", "line")
	   .style("stroke", "grey")
	   .style("stroke-opacity", "0.75")
	   .style("stroke-width", "0.3px")
	   .attr("transform", "translate(" + (cfg.w/2-levelFactor) + ", " + (cfg.h/2-levelFactor) + ")");
	}
	
	// 축 레벨 값
	//Text indicating at what % each level is
	for(var j=0; j<cfg.levels; j++){
	  var levelFactor = cfg.factor*radius*((j+1)/cfg.levels);
	  g.selectAll(".levels")
	   .data([1]) //dummy data
	   .enter()
	   .append("svg:text")
	   .attr("x", function(d){return levelFactor*(1-cfg.factor*Math.sin(0));})
	   .attr("y", function(d){return levelFactor*(1-cfg.factor*Math.cos(0));})
	   .attr("class", "legend")
	   .style("font-family", "sans-serif")
	   .style("font-size", "10px")
	   .attr("transform", "translate(" + (cfg.w/2-levelFactor + cfg.ToRight) + ", " + (cfg.h/2-levelFactor) + ")")
	   .attr("fill", "#737373")
	   .text(parseInt(Format((j+1)*cfg.maxValue/cfg.levels)));
	}
	
	series = 0;

	var axis = g.selectAll(".axis")
			.data(allAxis)
			.enter()
			.append("g")
			.attr("class", "axis");
	
	// 축
	axis.append("line")
		.attr("x1", cfg.w/2)
		.attr("y1", cfg.h/2)
		.attr("x2", function(d, i){return cfg.w/2*(1-cfg.factor*Math.sin(i*cfg.radians/total));})
		.attr("y2", function(d, i){return cfg.h/2*(1-cfg.factor*Math.cos(i*cfg.radians/total));})
		.attr("class", "line")
		.style("stroke", "grey")
		.style("stroke-width", "1px");

	// 라벨 명
	axis.append("text")
		.attr("class", "legend")
		.text(function(d){return d})
		.style("font-family", "sans-serif")
		.style("font-size", "11px")
		.attr("text-anchor", "middle")
		.attr("dy", "1.5em")
		.attr("transform", function(d, i){return "translate(0, -10)"})
		.attr("x", function(d, i){return cfg.w/2*(1-cfg.factorLegend*Math.sin(i*cfg.radians/total))-60*Math.sin(i*cfg.radians/total);})
		.attr("y", function(d, i){return cfg.h/2*(1-Math.cos(i*cfg.radians/total))-20*Math.cos(i*cfg.radians/total);});

	// 데이터 표시 영역
	d.forEach(function(y, x){
	  dataValues = [];
	  g.selectAll(".nodes")
		.data(y, function(j, i){
		  dataValues.push([
			cfg.w/2*(1-(parseFloat(Math.max(j.value, 0))/cfg.maxValue)*cfg.factor*Math.sin(i*cfg.radians/total)), 
			cfg.h/2*(1-(parseFloat(Math.max(j.value, 0))/cfg.maxValue)*cfg.factor*Math.cos(i*cfg.radians/total))
		  ]);
		});
	  dataValues.push(dataValues[0]);
	  
	  // 데이터 영역 외곽선
	  g.selectAll(".area")
					 .data([dataValues])
					 .enter()
					 .append("polygon")
					 .attr("class", "radar-chart-serie"+series)
					 .style("stroke-width", "2px")
					 .style("stroke", cfg.color(series))
					 .attr("points",function(d) {
						 var str="";
						 for(var pti=0;pti<d.length;pti++){
							 str=str+d[pti][0]+","+d[pti][1]+" ";
						 }
						 return str;
					  })
					 .style("fill", function(j, i){return cfg.color(series)})
					 .style("fill-opacity", cfg.opacityArea)
					 .on('mouseover', function (d){
										z = "polygon."+d3.select(this).attr("class");
										g.selectAll("polygon")
										 .transition(200)
										 .style("fill-opacity", 0.1); 
										g.selectAll(z)
										 .transition(200)
										 .style("fill-opacity", .7);
									  })
					 .on('mouseout', function(){
										g.selectAll("polygon")
										 .transition(200)
										 .style("fill-opacity", cfg.opacityArea);
					 });
	  series++;
	});
	series=0;

	d.forEach(function(y, x){
	  // 데이터 영역 점
	  g.selectAll(".nodes")
		.data(y).enter()
		.append("svg:circle")
		.attr("class", "radar-chart-serie"+series)
		.attr('r', cfg.radius)
		.attr("alt", function(j){return Math.max(j.value, 0)})
		.attr("cx", function(j, i){
		  dataValues.push([
			cfg.w/2*(1-(parseFloat(Math.max(j.value, 0))/cfg.maxValue)*cfg.factor*Math.sin(i*cfg.radians/total)), 
			cfg.h/2*(1-(parseFloat(Math.max(j.value, 0))/cfg.maxValue)*cfg.factor*Math.cos(i*cfg.radians/total))
		]);
		return cfg.w/2*(1-(Math.max(j.value, 0)/cfg.maxValue)*cfg.factor*Math.sin(i*cfg.radians/total));
		})
		.attr("cy", function(j, i){
		  return cfg.h/2*(1-(Math.max(j.value, 0)/cfg.maxValue)*cfg.factor*Math.cos(i*cfg.radians/total));
		})
		.attr("data-id", function(j){return j.axis})
		.style("fill", cfg.color(series)).style("fill-opacity", .9);
		/* 툴팁 임시 제거
		.on('mouseover', function (d){
					newX =  parseFloat(d3.select(this).attr('cx')) - 10;
					newY =  parseFloat(d3.select(this).attr('cy')) - 5;
					
					tooltip
						.attr('x', newX)
						.attr('y', newY)
						.text(Format(d.value))
						.transition(200)
						.style('opacity', 1);
						
					z = "polygon."+d3.select(this).attr("class");
					g.selectAll("polygon")
						.transition(200)
						.style("fill-opacity", 0.1); 
					g.selectAll(z)
						.transition(200)
						.style("fill-opacity", .7);
				  })
		.on('mouseout', function(){
					tooltip
						.transition(200)
						.style('opacity', 0);
					g.selectAll("polygon")
						.transition(200)
						.style("fill-opacity", cfg.opacityArea);
				  })
		.append("svg:title")
		.text(function(j){return Math.max(j.value, 0)});
		*/
	  
	  // 데이터 값 표시
	  var circle = g.selectAll("circle")[0];
	  var offset = d[0].length * x;
	  var valColors = ['#d81e1e', '#850ee6'];
	  y.forEach(function(v,i) {
		  var _x = parseFloat(d3.select(circle[offset+i]).attr('cx')) - 10;
		  var _y = parseFloat(d3.select(circle[offset+i]).attr('cy')) - 5;
		  g.append('svg:text')
		  .attr('x', _x)
		  .attr('y', _y)
		  .text(v.value)
		  .attr('fill',valColors[x])
		  .style('opacity', 1)
		  .style('font-family', 'sans-serif')
		  .style('font-size', '12px');	  
	  });
	  	
	  series++;
	});
	//Tooltip
	/* 툴팁 임시 제거
	tooltip = g.append('text')
			   .style('opacity', 0)
			   .style('font-family', 'sans-serif')
			   .style('font-size', '23px');
	*/		   
	
	
	var w = cfg.w;
	var h = cfg.h;
	
	// 하단 라벨 표시
	if ( !labels ) {
		return;
	}

	var svg = d3.select('#'+id)
		.selectAll('svg')
		.append('svg')
		.attr("width", w+300)
		.attr("height", h+300);
	
	// 라벨
	var lblXDiff = 50;
	svg.selectAll('text').data(labels).enter().append("text")
		.attr("x", function(d,i){ return w/4+d.length*5+i*d.length*16; })
		.attr("y", h+70)
		.attr("font-size", "12px")
		.attr("fill", "#404040")
		.text(function(d){ return d; })
		.on('mouseover', function (d,i){
			$(this).css({'font-weight':'bold','cursor':'pointer'});
			z = "polygon."+d3.select(this).attr("class");
			g.selectAll("polygon")
			 .transition(200)
			 .style("fill-opacity", 0.1); 
			g.selectAll('.radar-chart-serie'+i)
			 .transition(200)
			 .style("fill-opacity", 0.7);
						  })
		.on('mouseout', function(){
			$(this).css({'font-weight':'normal','cursor':'none'});
			g.selectAll("polygon")
			 .transition(200)
			 .style("fill-opacity", cfg.opacityArea);
		});		
	
	// 라벨 왼쪽 박스
	svg.selectAll('line').data(labels).enter().append("line")
		.attr("class", "c3-legend-item-tile")
		.attr("x1", function(d,i){ return w/4+d.length*5-10+i*d.length*16; })
		.attr("x2", function(d,i){ return w/4+d.length*5-10+i*d.length*16; })
		.attr("y1", h+60)
		.attr("y2", h+70)
		.attr("stroke-width", "10")
		.attr("style", function(d,i){ return "stroke: "+cfg.color(i)+"; pointer-events: none;"; })
		.text(function(d){ return d; });
	
  }
};
