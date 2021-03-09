package com.klxx.api.bdmap.pojo.ro;


import cn.afterturn.easypoi.excel.annotation.Excel;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class PlaceExportRo {

    @Excel(name = "店名")
    private String name;

    @Excel(name = "省")
    private String province;

    @Excel(name = "市")
    private String city;

    @Excel(name = "县")
    private String area;

    @Excel(name = "地址")
    private String address;

    @Excel(name = "标签")
    private String tag;

    @Excel(name = "评分")
    private String rating;

    @Excel(name = "评价数")
    private String commentNum;

    @Excel(name = "联系方式")
    private String telephone;


}
