package com.jiaron.mall.common;

/**
 * 描述:
 *
 * @author caoXB
 * @date 2020/3/13 18:31
 */
public enum ResultCode implements IErrorCode {
    SUCCESS(200, "请求成功"),
    FAILED(500, "请求失败"),
    VALIDATE_FAILED(404, "参数检验失败"),
    UNAUTHORIZED(401, "暂未登录或token已经过期"),
    FORBIDDEN(403, "没有相关权限");
    private long code;
    private String message;

    private ResultCode(long code, String message) {
        this.code = code;
        this.message = message;
    }

    public long getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
