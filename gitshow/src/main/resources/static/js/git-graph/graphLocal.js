
// 使用图表的DIV区域，不同图表需要更换ID，否则只会显示一个图表
var myChart = echarts.init(document.getElementById('sunif'));

// 指定图表的配置项和数据
var option = {
    /* title: {
        text: '实时在线用户',

        textStyle: {
        fontWeight: 'normal',              //标题颜色
            color: '#FFF'
        },
    }, */

    tooltip: {
        trigger: 'axis'
    },
    legend: {
        data:['微信认证','短信认证','临时放行'],
        textStyle: {
            fontWeight: 'normal',              //标题颜色
            color: '#FFF'
        }
    },
    grid: {
        left: '3%',
        right: '4%',
        bottom: '3%',
        containLabel: true
    },
    xAxis: {
        type: 'category',
        boundaryGap: false,
        data: ['16:10','16:15','16:20','16:25','16:30','16:35','16:40']
    },
    yAxis: {
        type: 'value'
    },
    series: [
        {
            name:'微信认证',
            type:'line',
            stack: '总量',
            data:[120, 132, 101, 134, 90, 230, 210],
            lineStyle: {
                normal:{
                    color:'#fff'
                }
            }
        },
        {
            name:'短信认证',
            type:'line',
            stack: '总量',
            data:[220, 182, 191, 234, 290, 330, 310],
            lineStyle: {
                normal:{
                    color:'green'
                }
            }
        },
        {
            name:'临时放行',
            type:'line',
            stack: '总量',
            data:[150, 232, 201, 154, 190, 330, 410],
            lineStyle: {
                normal:{
                    color:'yellow'
                }
            }
        }
    ],
    textStyle: {
        fontWeight: 'normal',              //标题颜色
        color: '#FFF'
    }
};

// 自适应配置
myChart.setOption(option);
window.addEventListener("resize", function () {
    myChart.resize();
});