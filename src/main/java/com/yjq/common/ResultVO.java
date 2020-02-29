package com.yjq.common;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName ResultVO
 * @Author GDMZ_jqyang@outlook.com
 * @Description 返回数据包装类
 * @Date 2020/2/11 0:22
 * @Version 1.0
 */
public class ResultVO implements Serializable {

    private static final long serialVersionUID = 1725159680599612404L;

    /**
     * 返回msg，object，以及token
     * 返回的code为默认
     * @param message
     * @param data
     * @param jwtToken
     * @return
     */
    public final static Map<String, Object> success(String message, Object data, String jwtToken, Boolean success) {
        Map<String, Object> map = new HashMap<>();
        map.put("code", ResultEnum.SUCCESS.getCode());
        map.put("message", message);
        map.put("success",success);
        map.put("data", data);
        return map;
    }


    /**
     * 返回默认的信息
     * @return
     */
    public final static  Map<String, Object> success() {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("code", ResultEnum.SUCCESS.getCode());
        map.put("message", ResultEnum.SUCCESS.getMessage());
        map.put("data", null);
        map.put("success",true);
        return map;
    }
    public final static  Map<String, Object> success(Object data) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("code", ResultEnum.SUCCESS.getCode());
        map.put("message", ResultEnum.SUCCESS.getMessage());
        map.put("data", data);
        map.put("success",true);
        return map;
    }

    public final static  Map<String, Object> failure(int code, String message,Object data) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("code", code);
        map.put("message", message);
        map.put("data", data);
        map.put("success",false);
        return map;
    }

    public final static  Map<String, Object> failure(int code, String message) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("code", code);
        map.put("message", message);
        map.put("data", null);
        map.put("success",false);
        return map;
    }
    public final static  Map<String, Object> failure() {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("code", ResultEnum.FAILURE.getCode());
        map.put("message", ResultEnum.FAILURE.getMessage());
        map.put("data", null);
        map.put("success",false);
        return map;
    }

    public final static  Map<String, Object> failure(ResultEnum respCode, Object data, Boolean success) {
        return getStringObjectMap(respCode, data,success);
    }

    public final static  Map<String, Object> failure(ResultEnum respCode, Boolean success) {
        return getStringObjectMap(respCode,success);
    }

    /*
     * 成功返回特定的状态码和信息
     * */
    public final static  Map<String, Object> result(ResultEnum respCode, Object data, Boolean success) {
        return getStringObjectMap(respCode, data,success);
    }

    private static  Map<String, Object> getStringObjectMap(ResultEnum respCode, Object data, Boolean success) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("code", respCode.getCode());
        map.put("message", respCode.getMessage());
        map.put("data", data);
        map.put("success",success);
        return map;
    }

    /*
     * 成功返回特定的状态码和信息
     * */
    public final static  Map<String, Object> result(ResultEnum respCode, Boolean success) {
        return getStringObjectMap(respCode,success);
    }

    private static Map<String, Object> getStringObjectMap(ResultEnum respCode, Boolean success) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("code", respCode.getCode());
        map.put("message", respCode.getMessage());
        map.put("data", null);
        map.put("success",success);
        return map;
    }

    /*
     * 成功返回特定的状态码和信息
     * */
    public final static Map<String, Object> result(ResultEnum respCode, String jwtToken, Boolean success) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("jwtToken",jwtToken);
        map.put("code", respCode.getCode());
        map.put("message", respCode.getMessage());
        map.put("data", null);
        map.put("success",success);
        return map;
    }


}
