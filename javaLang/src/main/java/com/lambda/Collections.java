package com.lambda;

import java.util.*;
import java.util.stream.Collectors;

public class Collections {


    /**
     *  map<Integer, List>中, List 排序后 的第一项, 组成新 map
     */
    public void pickMapList() {

        Map<Integer, List<User>> userMap = new HashMap<>();

        List<User> userList1 = new ArrayList<>();
        userList1.add(new User(1,10,"二狗"));
        userList1.add(new User(5,15,"三渣"));
        userList1.add(new User(7,20,"四妹"));

        userMap.put(1, userList1);

        List<User> userList2 = new ArrayList<>();
        userList1.add(new User(2,10,"二狗1"));
        userList1.add(new User(6,15,"三渣1"));
        userList1.add(new User(8,20,"四妹1"));

        userMap.put(2, userList2);

        List<User> userList3 = new ArrayList<>();
        userList1.add(new User(3,10,"二狗2"));
        userList1.add(new User(4,15,"三渣2"));
        userList1.add(new User(9,20,"四妹2"));

        userMap.put(3, userList3);


        Map<Integer, User> pic = userMap.entrySet().stream().collect(Collectors.toMap(e -> e.getKey(), a ->
            a.getValue().stream().sorted(Comparator.comparing(User::getAge)).findFirst().get()
        ));

        List<Integer> sortedSet = pic.keySet().stream().sorted(Comparator.comparing(e -> pic.get(e).getAge())).collect(Collectors.toList());
    }
}
