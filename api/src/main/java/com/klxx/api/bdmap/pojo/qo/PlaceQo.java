package com.klxx.api.bdmap.pojo.qo;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class PlaceQo {

     private String ak;

     private String region;

     private Integer scope;

    /**
     * 	json或xml
     */
    private String output;

     private String query;

     private Integer page_size;

     private Integer page_num;


    public PlaceQo() {
        ak = "XqELjhLFAZUl0YM1aFMvXjgqRVLhWBzC";
        scope = 2;
        output = "json";
        page_size = 1000;
        page_num = 0;
    }
}
