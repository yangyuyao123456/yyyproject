package com.yyy.student.common;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.io.Serializable;

/**
 * @description:  响应类
 * @author: yuyao.yang
 * @create: 2020/6/12 1:26
 **/
@Data
@Slf4j
public class Response implements Serializable {
    /**
     * 错误码
     */
    String code;
    /**
     * 错误信息
     */
    String message;
    /**
     * 返回对象
     */
    Object data;

    /**
     * @Author: yuyao.yang
     * @Description:  成功返回公共响应
     * @Date: 1:39 2020/6/12
     * @Param: [response]
     * @return: com.yyy.student.common.Response
     **/
    public static Response successReturn(Response response){
        log.info("成功返回");
        response.setCode("0");
        response.setMessage("成功");
        return response;
    }
    /**
     * @Author: yuyao.yang
     * @Description:  失败返回公共响应
     * @Date: 1:39 2020/6/12
     * @Param: [response]
     * @return: com.yyy.student.common.Response
     **/
    public static Response failReturn(Response response){
        log.info("失败返回");
        response.setCode("1");
        response.setMessage("失败");
        return response;
    }

    /**
     * @Author: yuyao.yang
     * @Description:  增删改响应的公共方法
     * @Date: 1:44 2020/6/12
     * @Param: [i]
     * @return: com.yyy.student.common.Response
     **/
    public static Response commonReturn(Integer i){
        return 1 == i? successReturn(new Response()):failReturn(new Response());
    }
}
