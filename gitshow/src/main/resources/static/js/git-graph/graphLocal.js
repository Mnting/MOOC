
// 使用图表的DIV区域，不同图表需要更换ID，否则只会显示一个图表
var myChart = echarts.init(document.getElementById('sunif'));

// 指定图表的配置项和数据
var option = {
    legend: {
        // padding:[0,50,0,0],   //可设定图例[距上方距离，距右方距离，距下方距离，距左方距离]
    },
    grid: [{
        left: '5%',
        bottom: '10%',
        top: '10%',
        right: '5%'
    }],
    xAxis: {
        type: 'time',
        show: false,
    },
    yAxis: {
        type: 'value',
        min: 5,
        max: 15,
        splitNumber: 1,
        show: false,
    },
    series: [{
        name: 'dev',
        showAllSymbol: true,//标注所有数据点,
        animation:true,//false: hover圆点不缩放 .true:hover圆点默认缩放
        data:[
            //辅线与基线的symbolSize是互斥的，不能同时为0或8
            {
                value:['2019-11-1 00:00:00', 10],
                symbolSize: 0

            },
            {
                value:['2019-11-1 12:00:00' , 15],
                symbolSize: 0

            },
            {
                value:['2019-11-2 00:00:00' , 15],
                symbolSize: 8

            },
            {
                value:['2019-11-3 00:00:00' , 15],
                symbolSize: 0

            },
            {
                value:['2019-11-3 12:00:00' , 15],
                symbolSize: 0

            },
            {
                value:['2019-11-4 00:00:00' , 10],
                symbolSize: 0

            },
            // {
            //     value:['2019-11-5 00:00:00' , 10],
            //     symbolSize: 8

            // },
            // {
            //     value:['2019-11-6 00:00:00' , 10],
            //     symbolSize: 8

            // },
            {
                value:['2019-11-9 00:00:00', 10],
                symbolSize: 0

            },
            {
                value:['2019-11-9 12:00:00' , 5],
                symbolSize: 0

            },
            {
                value:['2019-11-10 00:00:00' , 5],
                symbolSize: 8

            },
            {
                value:['2019-11-11 00:00:00' , 5],
                symbolSize: 0

            },
            {
                value:['2019-11-11 12:00:00' , 5],
                symbolSize: 0

            },
            {
                value:['2019-11-12 00:00:00' , 10],
                symbolSize: 0

            },
        ],
        type: 'line'
    },
        {
            name: 'master',
            symbolSize:8,//拐点大小
            animation:true,//false: hover圆点不缩放 .true:hover圆点默认缩放
            data:[
                {
                    value:['2019-11-1 00:00:00' , 10],symbolSize: 8

                },
                {
                    value:['2019-11-2 00:00:00' , 10],symbolSize: 0

                },
                {
                    value:['2019-11-3 00:00:00' , 10],symbolSize: 8

                },
                {
                    value:['2019-11-4 00:00:00' , 10],symbolSize: 8

                },
                {
                    value:['2019-11-5 00:00:00' , 10],symbolSize: 8

                },
                {
                    value:['2019-11-6 00:00:00' , 10],symbolSize: 8

                },
                {
                    value:['2019-11-7 00:00:00' , 10],symbolSize: 8

                },
                {
                    value:['2019-11-8 00:00:00' , 10],symbolSize: 8

                },{
                    value:['2019-11-9 00:00:00' , 10],symbolSize: 8

                },
                {
                    value:['2019-11-10 00:00:00' , 10],symbolSize: 0

                },
                {
                    value:['2019-11-11 00:00:00' , 10],symbolSize: 8

                },
                {
                    value:['2019-11-12 00:00:00' , 10],symbolSize: 8

                },
            ],
            type: 'line'
        },
    ]
};


// 自适应配置
myChart.setOption(option);
window.addEventListener("resize", function () {
    myChart.resize();
});