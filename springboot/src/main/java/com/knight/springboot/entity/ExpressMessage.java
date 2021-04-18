package com.knight.springboot.entity;


import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;


@TableName("t_express_message")
@Data
public class ExpressMessage {

    private Integer id;

    private String express;

    private String note;

    private String consignee;

    private String phone;

    private String destination;

    private String courier_number;

    private String createDate;

    private String uploadDate;

    private String batch;
}
