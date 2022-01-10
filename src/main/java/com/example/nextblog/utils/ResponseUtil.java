package com.example.nextblog.utils;

import com.example.nextblog.model.vo.Result;

import java.util.HashMap;

public class ResponseUtil {

    public static <T> Result<T> success(T data, String message) {
        Result<T> result = new Result<>();
        result.setCode(200);
        result.setMessage(message);
        result.setData(data);
        return result;
    }

    public static Result<Object> success(String message) {
        Result<Object> result = new Result<>();
        result.setCode(200);
        result.setMessage(message);
        result.setData(new HashMap<>());
        return result;
    }

    public static Result<Object> fail(String message) {
        Result<Object> result = new Result<>();
        result.setCode(400);
        result.setMessage(message);
        result.setData(new HashMap<>());
        return result;
    }

    public static Result<Object> error(String message) {
        Result<Object> result = new Result<>();
        result.setCode(500);
        result.setMessage(message);
        result.setData(new HashMap<>());
        return result;
    }
}
