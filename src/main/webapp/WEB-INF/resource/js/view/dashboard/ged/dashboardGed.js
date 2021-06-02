
$(function() {

	// 세가지 차트에 쓸 데이터 가져오기
	fChartData();
	
});

function fChartData(){
	
	//let todayDate = new Date();
	
	//let today = todayDate.toLocaleDateString();
	
	var resultCallback = function(data) {
		fProductTopChart(data.chartData.productDTOList);
		
		fCompanyTopChart(data.chartData.companyDTOList);
		
		fSalesLineChart(data.chartData.profitDTOList);
	};
	
	callAjax("/dashboard/ged/chart", "post", "json", true, null, resultCallback);
	
}

function fSalesLineChart(data){
	
	var profit = new Array();
	profit = data;
    
    var options = {
      series: [{
        name: "수익금액",
        data: [10, 41, 35, 51, 49, 62, 69, 91, 148]
    }],
      chart: {
      height: 350,
      type: 'line',
      zoom: {
        enabled: false
      }
    },
    dataLabels: {
      enabled: false
    },
    stroke: {
      curve: 'straight'
    },
    grid: {
      row: {
        colors: ['#f3f3f3', 'transparent'], // takes an array which will be repeated on columns
        opacity: 0.5
      },
    },
    xaxis: {
      categories: ['Jan', 'Feb', 'Mar', 'Apr', 'May', 'Jun', 'Jul', 'Aug', 'Sep'],
    }
    };

	options.series[0].data = [];
	options.xaxis.categories = [];
    
	for(var i = 0; i< profit.length; i++){
		options.series[0].data.push(profit[i].month_profit);
		options.xaxis.categories.push(profit[i].order_date);
	}
	
	
    var chart = new ApexCharts(document.querySelector("#salesLineChart"), options);
    chart.render();
}

function fProductTopChart(data){
	
	var product = new Array();
	
	product = data;
	
	var unstsearch = true;
	//차트 옵션
	var options = {
            series: [],
            chart: {
            width: 430,
            type: 'pie',
            toolbar: {
                show: true,
                offsetX: 0,
                offsetY: 0,
                tools: {
                  download: true | '<i class="fas fa-cloud-download-alt" width="20"></i>',
                  selection: true,
                  zoom: true,
                  zoomin: true,
                  zoomout: true,
                  pan: true,
                  reset: true | '<i class="fas fa-redo-alt" width="20"></i>',
                  customIcons: []
                },
                export: {
                  csv: {
                    filename: undefined,
                    columnDelimiter: ',',
                    headerCategory: 'category',
                    headerValue: 'value',
                    dateFormatter(timestamp) {
                      return new Date(timestamp).toDateString()
                    }
                  }
                },
                autoSelected: 'zoom' 
              },
	
          },
          labels: [],
          };
	
	var chart;
	
	options.series = [];
	options.labels = [];
	
	for(var i = 0; i< product.length; i++){
		options.series.push(product[i].profit_price);
		options.labels.push(product[i].pro_name);
	}
	
	// div 비운 뒤 에이펙스 차트 렌더링
	//document.querySelector("#chart").innerHTML = ' ';
	chart = new ApexCharts(document.querySelector("#chart"), options);
	chart.render();
	
}

function fCompanyTopChart(data) {

	var company = new Array();
	
	company = data;
	
    var options = {
      series: [{
    	  name:'매출액',
      data: [44, 55, 41, 67, 22, 43, 21, 33, 45, 31, 87, 65, 35]
    }],
    chart: {
      height: 350,
      type: 'bar',
    },
    plotOptions: {
      bar: {
        columnWidth: '50%',
        endingShape: 'rounded'  
      }
    },
    dataLabels: {
      enabled: false
    },
    stroke: {
      width: 2
    },
    
    grid: {
      row: {
        colors: ['#fff', '#f2f2f2']
      }
    },
    xaxis: {
      labels: {
        rotate: -45
      },
      categories: ['Apples', 'Oranges', 'Strawberries', 'Pineapples', 'Mangoes', 'Bananas',
        'Blackberries', 'Pears', 'Watermelons', 'Cherries', 'Pomegranates', 'Tangerines', 'Papayas'
      ],
      tickPlacement: 'on'
    },
    fill: {
      type: 'gradient',
      gradient: {
        shade: 'light',
        type: "horizontal",
        shadeIntensity: 0.25,
        gradientToColors: undefined,
        inverseColors: true,
        opacityFrom: 0.85,
        opacityTo: 0.85,
        stops: [50, 0, 100]
      },
    },
    toolbar: {
        show: true,
        offsetX: 0,
        offsetY: 0,
        tools: {
          download: true | '<i class="fas fa-cloud-download-alt" width="20"></i>',
          selection: true,
          zoom: true,
          zoomin: true,
          zoomout: true,
          pan: true,
          reset: true | '<i class="fas fa-redo-alt" width="20"></i>',
          customIcons: []
        },
        export: {
          csv: {
            filename: undefined,
            columnDelimiter: ',',
            headerCategory: 'category',
            headerValue: 'value',
            dateFormatter(timestamp) {
              return new Date(timestamp).toDateString()
            }
          }
        },
        autoSelected: 'zoom' 
      },
    };

	options.series[0].data = [];
	options.xaxis.categories = [];
	
	for(var i = 0; i< company.length; i++){
		options.series[0].data.push(company[i].sales_price);
		options.xaxis.categories.push(company[i].user_company);
	}
	
	
    var chart = new ApexCharts(document.querySelector("#companyChart"), options);
    chart.render();
}


