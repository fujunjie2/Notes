package com.klxx.api.bdmap.pojo.vo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class PlaceApiVo {

    private Integer status;

    private String message;

    private String result_type;

    private Integer total;

    private List<PlaceDetailVo> results;
}
