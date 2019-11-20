let functionLib = {
    prefix: "http://localhost:8080/",
    queryParams: {
        limit: 0,
        offset: 0,
        keyword: null,
        status: null
    },
    load() {
        let that = this;
        layui.use('table', function () {
            let table = layui.table;
            table.render({
                elem: '#exampleTable',//指定表格元素
                url: functionLib.prefix + '/function/pageQuery',  //请求路径
                toolbar: "#toolbarDemo"
                , skin: 'line ' //表格风格 line （行边框风格）row （列边框风格）nob （无边框风格）
                , even: true    //隔行换色
                , page: true  //开启分页
                , limits: [10, 20, 50]  //每页条数的选择项，默认：[10,20,30,40,50,60,70,80,90]。
                , limit: 15 //每页默认显示的数量
                , method: 'get',  //提交方式
                loading: true,
                request: {
                    pageName: 'offset' //页码的参数名称，默认：page
                },
                parseData: function (res) { //res 即为原始返回的数据
                    return {
                        "code": 0,
                        "msg": "",
                        "count": res.realTotal, //解析数据长度
                        "data": res.records //解析数据列表
                    };
                },
                cols: [[
                    {
                        type: "checkbox"
                    }, {
                        field: 'id', //json对应的key
                        title: 'ID',   //列名
                    },
                    {
                        field: 'name',
                        title: '名称',
                    },
                    {
                        field: 'description',
                        title: '描述',
                    },
                    {
                        field: 'generatemenu',
                        title: '是否生成菜单',
                    },
                    {
                        field: 'zindex',
                        title: '优先级',
                    },
                    {
                        field: 'page',
                        title: '路径',
                    }
                ]]
            });
        });
    }
}