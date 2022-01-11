package com.example.nextblog.model.dto;

import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
public class UpdateTag {
    @NotNull(message = "id错误")
    @Min(value = 1, message = "id错误")
    private Integer id;

    @NotEmpty(message = "请填写标签")
    private String tagName;
}
