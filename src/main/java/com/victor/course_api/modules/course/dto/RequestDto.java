package com.victor.course_api.modules.course.dto;


import com.victor.course_api.modules.course.enums.ActiveEnum;
import lombok.Data;

@Data
public class RequestDto {

    private String name;

    private String category;

    private ActiveEnum Active;
}
