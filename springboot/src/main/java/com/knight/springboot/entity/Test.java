package com.knight.springboot.entity;

import com.baomidou.mybatisplus.annotation.IEnum;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.knight.springboot.mybatis.ColumnAppend;
import com.knight.springboot.mybatis.ColumnTransfer;
import lombok.Data;

@Data
@ColumnTransfer
public class Test {

    @TableId(type = IdType.AUTO)
    private Integer id;

    private StatusEnum status;


    @ColumnAppend("_pwd")
    private String password;


    public enum StatusEnum implements IEnum<String> {
        VALID("valid"),
        INVALID("Invalid");

        private String value;

        StatusEnum (String value) {
            this.value = value;
        }

        @Override
        public String getValue() {
            return value;
        }

        public String get() {
            return this.name();
        }
    }

    public static void main(String[] args) {
        System.out.println(StatusEnum.INVALID.get());
    }
}
