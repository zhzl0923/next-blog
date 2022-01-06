package com.example.nextblog.utils;

import com.example.nextblog.admin.model.dto.Result;

public class ResponseUtil {

    public static <T> Result<T> success(T data, String message) {
        Result<T> result = new Result<>();
        result.setCode(200);
        result.setMessage(message);
        result.setData(data);
        return result;
    }

    public static <T> Result<T> fail(T data, String message) {
        Result<T> result = new Result<>();
        result.setCode(400);
        result.setMessage(message);
        result.setData(data);
        return result;
    }

    public static <T> Result<T> error(T data, String message) {
        Result<T> result = new Result<>();
        result.setCode(500);
        result.setMessage(message);
        result.setData(data);
        return result;
    }
}
