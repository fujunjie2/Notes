package com.klxx.api.bdmap.pojo.vo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class PlaceDetailInfoVo {

    private String tag;

    private LngLat navi_location;

    private String type;

    private String detail_url;

    private String overall_rating;

    private String image_num;

    private String comment_num;

}
