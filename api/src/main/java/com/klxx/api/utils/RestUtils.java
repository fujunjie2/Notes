package com.klxx.api.utils;

import org.springframework.web.client.RestTemplate;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class RestUtils {

    private static RestTemplate restTemplate = new RestTemplate();

    /**
     *
     * @param api 接口地址, ? 结尾
     * @param qo   请求参数
     * @param responseType  返回类型
     * @param <T> 返回类型
     * @return
     */
    public static  <T> T getForObjectText(String api, Object qo, Class<T> responseType) {
        String query = transferToQuery(qo);

        String body = restTemplate.getForObject( api + query, String.class);
        System.out.println(JacksonUtils.toJsonString(body));
        try {
            return JacksonUtils.convertToSimple(body, responseType);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }









    private static String transferToQuery(Object qo) {
        Class clazz = qo.getClass();

        Field[] fields = clazz.getDeclaredFields();
        List<String> paramList = new ArrayList<>(fields.length);

        for(Field field : fields) {
            boolean accessible = field.isAccessible();
            try {
                field.setAccessible(true);
                StringBuilder sb = new StringBuilder();
                Object f = field.get(qo);
                if (Objects.nonNull(f)) {
                    sb.append(field.getName()).append("=").append(field.get(qo));
                    paramList.add(sb.toString());
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } finally {
                field.setAccessible(accessible);
            }
        }

        return paramList.stream().collect(Collectors.joining("&"));
    }


}
