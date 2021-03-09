package com.klxx.api.bdmap.pojo.vo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.klxx.api.bdmap.pojo.ro.PlaceExportRo;
import lombok.Data;

import java.util.Objects;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class PlaceDetailVo {

    private String name;

    private LngLat location;

    private String address;

    private String province;

    private String city;

    private String area;

    private String telephone;

    private Integer detail;

    private  PlaceDetailInfoVo detail_info;


    public PlaceExportRo toExportRo() {

        PlaceExportRo ro = new PlaceExportRo()
            .setName(name)
            .setProvince(province)
            .setCity(city)
            .setArea(area)
            .setAddress(address)
            .setTelephone(telephone);
        if (Objects.nonNull(detail_info)) {
            ro.setRating(detail_info.getOverall_rating());
            ro.setCommentNum(detail_info.getComment_num());
        }
        return ro;
    }

}
