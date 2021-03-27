package com;

import java.util.*;

public class Action {

    /**
     * 对任意一个Map<String, Object>, 其 key 为 String,
     * 其 value 为 Map<String, Object> Object[] Number String 中的任意一种,
     * 显然叶子节点是 value 类型为 Number 或 String的节点,
     * 将 Map 转为多条字符串, 每条字符串表达其中一个叶子节点,
     * 比如:
     * {"a":{"b":["v",2,{"c":0}]},"d":[1,null,3]}
     * 将转化为以下这些字符串
     * a.b[0] = v
     * a.b[1] = 2
     * a.b[2].c = 0
     * d[0] = 1
     * d[1] = null
     * d[2] = 3
     *
     * @return 所有的字符串
     */
    public static void main(String[] args) {

        // {"a":{"b":["v",2,{"c":0}]},"d":[1,null,3]}
        Map<String, Object> c = new HashMap<>();

        c.put("c", 0);

        Object[] list1 = new Object[]{"v", 2, c};
        Object[] list2 = new Object[]{1, null, 3};

        Map<String, Object> b = new HashMap<>();
        b.put("b", list1);

        Map<String, Object> m = new HashMap<>();

        m.put("a", b);
        m.put("d", list2);

        Set<String> set =  showMap(m);

        set.forEach(e -> System.out.println(e));

    }

    public static Set<String> showMap(Map<String, Object> map) {
        HashSet<String> strings = new HashSet<>();
        for (String s : map.keySet()) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(s);
            Object obj = map.get(s);
            if (obj instanceof String || obj instanceof Number){
                stringBuilder.append(" = ").append(obj);
                strings.add(stringBuilder.toString());
            }else if(obj.getClass().isArray()){
                showArray(strings, stringBuilder, (Object[]) obj);
            }else {
                showMap(strings,stringBuilder,(Map<String, Object>) obj);
            }
        }
        return strings;
    }

    private static void showArray(HashSet<String> strings, StringBuilder stringBuilder, Object[] obj) {
        Object[] objects = obj;
        String str;
        for (int i = 0; i < objects.length; i++) {
            str = stringBuilder.toString();
            stringBuilder.append("[").append(i).append("]");
            Object object = objects[i];
            if (object instanceof String || object instanceof Number || object == null){
                stringBuilder.append(" = ").append(object);
                strings.add(stringBuilder.toString());
            }else if (object instanceof Map){
                showMap(strings, stringBuilder, (Map<String, Object>) object);
            }else {
                showArray(strings,stringBuilder,(Object[]) object);
            }
            stringBuilder=new StringBuilder(str);
        }
    }

    private static void showMap(HashSet<String> strings, StringBuilder stringBuilder, Map<String, Object> hashMap) {
        for (String ss : hashMap.keySet()) {
            stringBuilder.append(".").append(ss);
            Object object = hashMap.get(ss);
            if (object instanceof String || object instanceof Number){
                stringBuilder.append(" = ").append(object);
                strings.add(stringBuilder.toString());
            }else if (object instanceof Object[]){
                showArray(strings,stringBuilder,(Object[]) object);
            }else{
                showMap(strings,stringBuilder,(Map<String, Object>) object);
            }
        }
    }
}



//    public static void showMap(Map<String, Object> m) {

//        for (Map.Entry<String, Object> each : m.entrySet()) {
//            System.out.println(each.getKey());
//        }
//    }

//    public static List<String> parse(Object obj) {
//        if (obj.getClass().isArray()) {
//            Object[] o = (Object[]) obj;
//            List<String> t = new ArrayList<>();
//            int c = 0;
//            for (Object k : o) {
//                if (k instanceof Number || k instanceof String) {
//                    t.add("[" + c + "]");
//                } else {
//                    parse(k);
//                }
//                c++;
//            }
//        } else if (obj instanceof Map) {
//            return parse(obj);
//        } else if (obj instanceof Number || obj instanceof String) {
//            List<String> x = new ArrayList<>();
//            x.add("=" + obj);
//            return x;
//        }
//    }
//
//    public static List<String> join(String prefix, List<String> arr) {
//        for (int i = 0; i < arr.size(); i++) {
//            arr.set(i, prefix + arr.get(i));
//        }
//        return arr;
//    }


//}


