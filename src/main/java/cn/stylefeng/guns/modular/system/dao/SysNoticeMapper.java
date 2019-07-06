package cn.stylefeng.guns.modular.system.dao;

import cn.stylefeng.guns.modular.system.model.SysNotice;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 通知表 Mapper 接口
 * </p>
 *
 * @author hwb
 * @since 2019-05-15
 */
public interface SysNoticeMapper extends BaseMapper<SysNotice> {

    /**
     * 获取通知列表
     */
    List<Map<String, Object>> list(@Param("condition") String condition);
}
