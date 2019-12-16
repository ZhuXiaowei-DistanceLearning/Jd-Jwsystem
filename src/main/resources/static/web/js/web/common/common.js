function selectAjaxData(id, url, layFilter, data) {
    $.ajax({
        type: "get",
        url: url,
        data: data,
        success: function (data) {
            $("select[name=" + id + "]").empty();
            $.each(data, function (index, item) {
                $("select[name=" + id + "]").append("<option value='" + item.id + "'>" + item.name + "</option>")
            });
            layui.use('form', function () {
                var form = layui.form;
                form.render("select", layFilter)
                let dataFrom = form.val("fromTest", data == null ? [] : data);
            })
        },
        error: function (data) {
        }
    })
}

function layerFormCustom(emptyData, data) {
    layui.use('form', function () {
        var form = layui.form;
        let dataFrom = form.val("fromTest", data == null ? emptyData : data);
    });
}

function ajaxSuccess(index, data) {
    layui.table.reload('exampleTable')
    layer.alert(data.msg)
}