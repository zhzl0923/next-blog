package com.example.nextblog.model.vo;

import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

@Data
public class Result<T> implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private int code;

    private String message;

    private T data;
}
