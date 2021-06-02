

$(function() {
	
	fChartData();
	fBarData();
	
	
});

function fChartData(){
	
	//let todayDate = new Date();
	
	//let today = todayDate.toLocaleDateString();
	
	var resultCallback = function(data) {
		fapexChart(data.chartData.gListobj);
	};
	
	callAjax("/dashboard/scm/chart", "post", "json", true, null, resultCallback);
}
function fapexChart(data){
	
	
	/*var profit = new Array();
	profit = data.gListobj;*/
	
	
	var options = {
			
		chart: {
		        height: 350,
		        type: 'treemap',
		        events: {
		        	click: function(event, chartContext, config) {
		        	     // console.log(chartContext, config);
		        	//alert(config.dataPointIndex);
		        		if (config.dataPointIndex == 0){
		        		//alert("금일 수주내역 입니다.");
		        		location.href = "/scm/dailyOrderHistory.do";
		        		}else if(config.dataPointIndex == 1) {
		        		//alert("금일 반품 신청 건수입니다.");
		        		location.href = "/scm/refundInfo.do";
		        		
		        		}else if(config.dataPointIndex == 2) {
		        		//alert("금일 1:1문의답변입니다.");
		        		location.href = "/sti/inquiry.do";
		        		}else if(config.dataPointIndex == 3) {
		        		//alert("배송지시서입니다.");
		        		location.href = "/scm/UserInfo.do";
		        		}else if(config.dataPointIndex == 4) {
		        		//alert("발주지시서입니다");
		        		location.href = "/scm/shippingDirection.do";
		        		}else if(config.dataPointIndex == 5) {
		        		//alert("반품지시서입니다");
		        		location.href = "/scm/purchaseDir";	
		        		
		        		}
		        	}
		        	
		        }	
		        	
		      },
        series: [
        {
          data: [
            {
              x: '금일 수주내역 건수',
              y: data[0].orderdate
              
            },
            {
              x: '미응답 반품 신청 건수',
              y: data[1].orderdate
            },
            {
              x: '미응답 1:1문의답변',
              y: data[2].orderdate
            },
            {
              x: '미승인 유저 건수',
              y: data[5].orderdate
              },
            {
              x: '대기 중 배송지시서',
              y: data[3].orderdate
            },
            {
              x: '미승인 발주지시서',
              y: data[4].orderdate
            }
            
            
          ]
        }
      ],
        legend: {
        show: false
      },
      
      
        dataLabels: {
          enabled: true,
          style: {
        	  fontFamily: 'Helvetica, Arial, sans-serif',
        	  fontSize: '15px'
          },
          formatter: function(text, op) {
            return [text, op.value]
          }
        }
      };

      var chart = new ApexCharts(document.querySelector("#responsive-chart"), options);
      chart.render();
    
}

function fBarData(){
	
	//let todayDate = new Date();
	
	//let today = todayDate.toLocaleDateString();
	
	var resultCallback = function(data) {
		fapexBarChart(data.barData.bListobj);
	};
	
	callAjax("/dashboard/scm/bar", "post", "json", true, null, resultCallback);
}


function fapexBarChart(data) {


var profit = new Array();
profit = data;

//console.log(profit[0].pro_no);

var options = {
         series: [{
         name: 'ORDERS',
         data: [0, 55, 41, 67, 22, 43, 21, 33, 45, 31, 87, 65, 35]
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
         enabled: true
       },
       stroke: {
         width: 2
       },
       title: {
           text: 'study 제품 누적 판매 현황',
           fontSize: '30px'
        	   
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
       }
       }; 

		options.series[0].data = [];
		options.xaxis.categories = [];

		for(var i = 0; i< profit.length; i++){
			options.series[0].data.push(profit[i].order_qty);
			options.xaxis.categories.push(profit[i].pro_no);
		}


       var chart = new ApexCharts(document.querySelector("#chart3"), options);
       chart.render();
	}
