let roleLib = {
    prefix: "http://localhost:8080/",
    queryParams: {
        limit: 0,
        offset: 0,
        keyword: null,
        status: null
    },
    load() {
        let arr = [];
        let p = new Promise(function (resolve, reject) {
            $.ajax({
                url: functionLib.prefix + '/role/listajax',
                type: "get",
                success: function (data) {
                    arr = data;
                    resolve(arr)
                }
            });
        })
        p.then(function (res) {
            var setting = {
                data: {
                    key: {
                        title: "name"
                    },
                    simpleData: {//使用简单json数据构造节点数据
                        enable: true,
                        idKey: "id",
                        rootPid: 0
                    }
                },
                check: {//使用ztree勾选效果
                    enable: true
                },
                view: {
                    showLine: true,
                },
                callback: {
                    beforeEditName: functionLib.editNode,
                    beforeRemove : functionLib.removeNode,
                },
                edit: {
                    showRemoveBtn: true,
                    showRenameBtn: true,
                    enable: true
                }
            };
            $.ajax({
                url: functionLib.prefix + '/function/listajax.action',
                type: 'get',
                dataType: 'json',
                success: function (data) {
                    let tree = $.fn.zTree.init($("#functionTree"), setting, data);
                    tree.expandAll(true)
                    $.each(res, function (index, val) {
                        let node = tree.getNodeByParam("id", val);
                        tree.checkNode(node, true, false)
                    });
                },
                error: function (msg) {
                    alert('树加载异常!');
                }
            });
            // 点击保存
            $('#save').click(function () {

            });
            // resolve(1);
        })
    },
    editNode(treeId, treeNode, newName, isCancel) {
        collegeWindos("修改权限", "#addWindow", treeNode)
    },
    removeNode(treeId, treeNode) {
        // confrimWindow("是否删除该权限", treeNode)
        return false;
    },
}