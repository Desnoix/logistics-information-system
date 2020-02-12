package com.yjq.common;

/**
 * @ClassName ResultEnum
 * @Author GDMZ_jqyang@outlook.com
 * @Description 返回的错误码枚举类
 * @Date 2020/2/11 0:15
 * @Version 1.0
 */
public enum  ResultEnum {

    SUCCESS(101, "成功"),
    FAILURE(102, "失败"),
    USER_NEED_AUTHORITIES(201, "用户未登录"),
    USER_LOGIN_FAILED(202, "用户账号或密码错误"),
    USER_LOGIN_SUCCESS(203, "用户登录成功"),
    USER_NO_ACCESS(204, "用户无权访问"),
    USER_LOGOUT_SUCCESS(205, "用户登出成功"),
    TOKEN_IS_BLACKLIST(206, "此token为黑名单"),
    LOGIN_IS_OVERDUE(207, "登录已失效"),
    ;

    private Integer code;

    private String message;

    ResultEnum(Integer code, String message) {
        this.code = code;
        this.message = message;

    }


    public static ResultEnum parse(int code){
        ResultEnum[] values = values();
        for (ResultEnum value : values) {
            if(value.getCode() == code){
                return value;
            }
        }
        throw  new RuntimeException("Unknown code of ResultEnum");
    }

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
