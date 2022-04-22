package com.wsh.spoc.utils;

import java.io.Serializable;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * 统一返回类
 *
 * @author wjh
 */
@ToString
@EqualsAndHashCode
public class R<T> implements Serializable {
    private static final long serialVersionUID = 1L;
    private int code;
    private String msg;
    private T data;

    public R(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public static R<Void> success() {
        return success("操作成功");
    }

    public static <T> R<T> success(T data) {
        return success("操作成功", data);
    }

    public static R<Void> success(String msg) {
        return success(msg, null);
    }


    public static <T> R<T> success(String msg, T data) {
        return new R(200, msg, data);
    }

    public Boolean isSuccess() {
        return 200 == this.code;
    }

    public static R<Void> error() {
        return error("操作失败");
    }

    public static R<Void> error(String msg) {
        return error(msg, null);
    }

    public static <T> R<T> error(String msg, T data) {
        return new R(500, msg, data);
    }

    public static R<Void> error(int code, String msg) {
        return new R(code, msg, (Object)null);
    }

    public int getCode() {
        return this.code;
    }

    public String getMsg() {
        return this.msg;
    }

    public T getData() {
        return this.data;
    }

    public R<T> setCode(int code) {
        this.code = code;
        return this;
    }

    public R<T> setMsg(String msg) {
        this.msg = msg;
        return this;
    }

    public R<T> setData(T data) {
        this.data = data;
        return this;
    }


    public R(int code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }
}
