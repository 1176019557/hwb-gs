/**
 * 初始化党建详情对话框
 */
var SysNoticeInfoDlg = {
    sysNoticeInfoData : {}
};

/**
 * 清除数据
 */
SysNoticeInfoDlg.clearData = function() {
    this.sysNoticeInfoData = {};
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
SysNoticeInfoDlg.set = function(key, val) {
    this.sysNoticeInfoData[key] = (typeof val == "undefined") ? $("#" + key).val() : val;
    return this;
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
SysNoticeInfoDlg.get = function(key) {
    return $("#" + key).val();
}

/**
 * 关闭此对话框
 */
SysNoticeInfoDlg.close = function() {
    parent.layer.close(window.parent.SysNotice.layerIndex);
}

/**
 * 收集数据
 */
SysNoticeInfoDlg.collectData = function() {
    this
    .set('id')
    .set('title')
    .set('type')
    .set('content')
    .set('createtime')
    .set('creater');
}

/**
 * 提交添加
 */
SysNoticeInfoDlg.addSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/sysNotice/add", function(data){
        Feng.success("添加成功!");
        window.parent.SysNotice.table.refresh();
        SysNoticeInfoDlg.close();
    },function(data){
        Feng.error("添加失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.sysNoticeInfoData);
    ajax.start();
}

/**
 * 提交修改
 */
SysNoticeInfoDlg.editSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/sysNotice/update", function(data){
        Feng.success("修改成功!");
        window.parent.SysNotice.table.refresh();
        SysNoticeInfoDlg.close();
    },function(data){
        Feng.error("修改失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.sysNoticeInfoData);
    ajax.start();
}

$(function() {

});
