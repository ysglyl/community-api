package com.bzdnet.community.controller;


import com.bzdnet.community.vo.ResultVO;

public class BaseController {

    /**
     * 获取处理成功的响应内容
     *
     * @return
     */
    protected ResultVO success() {
        return new ResultVO(200);
    }

    /**
     * 获取处理成功的响应内容
     *
     * @param data
     * @return
     */
    protected ResultVO success(Object data) {
        return new ResultVO(200, null, data);
    }

    /**
     * 获取处理失败的响应内容
     *
     * @return
     */
    protected ResultVO fail() {
        return new ResultVO(400, "处理失败");
    }

    protected ResultVO fail(String msg) {
        return new ResultVO(400, msg);
    }

    /**
     * 自定义返回结果
     *
     * @param code
     * @param msg
     * @param data
     * @return
     */
    protected ResultVO custom(int code, String msg, Object data) {
        return new ResultVO(code, msg, data);
    }

}
