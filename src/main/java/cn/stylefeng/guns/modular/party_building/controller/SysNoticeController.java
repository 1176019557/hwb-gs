package cn.stylefeng.guns.modular.party_building.controller;

import cn.stylefeng.roses.core.base.controller.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.beans.factory.annotation.Autowired;
import cn.stylefeng.guns.core.log.LogObjectHolder;
import org.springframework.web.bind.annotation.RequestParam;
import cn.stylefeng.guns.modular.system.model.SysNotice;
import cn.stylefeng.guns.modular.party_building.service.ISysNoticeService;

/**
 * 党建控制器
 *
 * @author hwb
 * @Date 2019-05-15 15:21:57
 */
@Controller
@RequestMapping("/sysNotice")
public class SysNoticeController extends BaseController {

    private String PREFIX = "/party_building/sysNotice/";

    @Autowired
    private ISysNoticeService sysNoticeService;

    /**
     * 跳转到党建首页
     */
    @RequestMapping("")
    public String index() {
        return PREFIX + "sysNotice.html";
    }

    /**
     * 跳转到添加党建
     */
    @RequestMapping("/sysNotice_add")
    public String sysNoticeAdd() {
        return PREFIX + "sysNotice_add.html";
    }

    /**
     * 跳转到修改党建
     */
    @RequestMapping("/sysNotice_update/{sysNoticeId}")
    public String sysNoticeUpdate(@PathVariable Integer sysNoticeId, Model model) {
        SysNotice sysNotice = sysNoticeService.selectById(sysNoticeId);
        model.addAttribute("item",sysNotice);
        LogObjectHolder.me().set(sysNotice);
        return PREFIX + "sysNotice_edit.html";
    }

    /**
     * 获取党建列表
     */
    @RequestMapping(value = "/list")
    @ResponseBody
    public Object list(String condition) {
        return sysNoticeService.selectList(null);
    }

    /**
     * 新增党建
     */
    @RequestMapping(value = "/add")
    @ResponseBody
    public Object add(SysNotice sysNotice) {
        sysNoticeService.insert(sysNotice);
        return SUCCESS_TIP;
    }

    /**
     * 删除党建
     */
    @RequestMapping(value = "/delete")
    @ResponseBody
    public Object delete(@RequestParam Integer sysNoticeId) {
        sysNoticeService.deleteById(sysNoticeId);
        return SUCCESS_TIP;
    }

    /**
     * 修改党建
     */
    @RequestMapping(value = "/update")
    @ResponseBody
    public Object update(SysNotice sysNotice) {
        sysNoticeService.updateById(sysNotice);
        return SUCCESS_TIP;
    }

    /**
     * 党建详情
     */
    @RequestMapping(value = "/detail/{sysNoticeId}")
    @ResponseBody
    public Object detail(@PathVariable("sysNoticeId") Integer sysNoticeId) {
        return sysNoticeService.selectById(sysNoticeId);
    }
}
