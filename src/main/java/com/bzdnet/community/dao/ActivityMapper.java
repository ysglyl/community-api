package com.bzdnet.community.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.bzdnet.community.form.ActivityForm;
import com.bzdnet.community.model.ActivityModel;

import java.util.List;

/**
 * @author yu.shigui@rongzer.com
 * @date 2020/3/4 16:26
 **/
public interface ActivityMapper extends BaseMapper<ActivityModel> {

    IPage<ActivityModel> loadListByUserId(Page<ActivityModel> page, ActivityForm form);

}
