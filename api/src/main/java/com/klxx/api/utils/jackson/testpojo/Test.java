package com.klxx.api.utils.jackson.testpojo;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.klxx.api.utils.JacksonUtils;

public class Test {

    /**
     * 1: 对于简单的转化, mapper.readValue(body, tClass), 最外层json有的字段, tClass必须有对应,
     */

//    private static final String beanHasListBean =
//        "{\"status\": 0, " +
//         "\"results\": " +
//             "[" +
//                 "{" +
//                    "\"name\": \"东单篮球场\", " +
//                    "\"address\": \"崇文门内大街108号\", " +
//                    "\"location\": {\"lat\": 34.3434}" +
//                 "}" +
//             "]" +
//         "}";
    private static final String beanHasListBean = "{\"status\": 0, \"results\": [{\"name\": \"东单篮球场\", \"address\": \"崇文门内大街108号\", \"location\": {\"lat\": 34.3434}}]}";


    public static void main(String[] args) throws Exception{
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        VoBean<BeanHasListBean> rst = JacksonUtils.convertToSimple(beanHasListBean, VoBean.class);

        System.out.println(rst);
    }
}
