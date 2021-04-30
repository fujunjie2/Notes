package com.knight.springboot.load.loadspecificclass.LoadInterface;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class LoadBeanOfInterfaces {


    /**
     *  注入 实现了 Tag 的 bean
     * @param tags
     */

    @Autowired
    public void loadTags(List<Tag> tags) {
        System.out.println(tags.size());
    }
}
