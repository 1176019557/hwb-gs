/**
 * 党建管理初始化
 */
var SysNotice = {
    id: "party_building_table",	//表格id
    seItem: null,		//选中的条目
    table: null,
    layerIndex: -1
};

/**
 * 初始化表格的列
 */
SysNotice.initColumn = function () {
    return [
        {field: 'selectItem', radio: true},
            {title: '主键', field: 'id', visible: true, align: 'center', valign: 'middle'},
            {title: '标题', field: 'title', visible: true, align: 'center', valign: 'middle'},
            {title: '类型', field: 'type', visible: true, align: 'center', valign: 'middle'},
            {title: '内容', field: 'content', visible: true, align: 'center', valign: 'middle'},
            {title: '创建时间', field: 'createtime', visible: true, align: 'center', valign: 'middle'},
            {title: '创建人', field: 'creater', visible: true, align: 'center', valign: 'middle'}
    ];
};

/**
 * 检查是否选中
 */
SysNotice.check = function () {
    var selected = $('#' + this.id).bootstrapTable('getSelections');
    if(selected.length == 0){
        Feng.info("请先选中表格中的某一记录！");
        return false;
    }else{
        SysNotice.seItem = selected[0];
        return true;
    }
};

/**
 * 点击添加党建
 */
SysNotice.openAddSysNotice = function () {
    var index = layer.open({
        type: 2,
        title: '添加党建',
        area: ['800px', '420px'], //宽高
        fix: false, //不固定
        maxmin: true,
        content: Feng.ctxPath + '/sysNotice/sysNotice_add'
    });
    this.layerIndex = index;
};

/**
 * 打开查看党建详情
 */
SysNotice.openSysNoticeDetail = function () {
    if (this.check()) {
        var index = layer.open({
            type: 2,
            title: '党建详情',
            area: ['800px', '420px'], //宽高
            fix: false, //不固定
            maxmin: true,
            content: Feng.ctxPath + '/sysNotice/sysNotice_update/' + SysNotice.seItem.id
        });
        this.layerIndex = index;
    }
};

/**
 * 删除党建
 */
SysNotice.delete = function () {
    if (this.check()) {
        var ajax = new $ax(Feng.ctxPath + "/sysNotice/delete", function (data) {
            Feng.success("删除成功!");
            SysNotice.table.refresh();
        }, function (data) {
            Feng.error("删除失败!" + data.responseJSON.message + "!");
        });
        ajax.set("sysNoticeId",this.seItem.id);
        ajax.start();
    }
};

/**
 * 查询党建列表
 */
SysNotice.search = function () {
    var queryData = {};
    queryData['condition'] = $("#condition").val();
    SysNotice.table.refresh({query: queryData});
};

$(function () {
    var defaultColunms = SysNotice.initColumn();
    var table = new BSTable(SysNotice.id, "/sysNotice/list", defaultColunms);
    table.setPaginationType("client");
    SysNotice.table = table.init();
});
