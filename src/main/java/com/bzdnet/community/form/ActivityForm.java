package com.bzdnet.community.form;

import lombok.Data;

/**
 * @author yu.shigui@rongzer.com
 * @date 2020/3/6 14:42
 **/
@Data
public class ActivityForm extends PageForm {

    private int loadMode; //加载方式，0: 刷新，1:加载更多
    private int type;
    private long referenceId;//参考ID，如果加载方式为刷新，则加载大于此ID的数据，如果为加载更多，则加载小于此ID的数据

}
