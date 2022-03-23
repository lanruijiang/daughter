package org.daughter.base;

import com.alibaba.fastjson.JSON;

import java.util.HashMap;
import java.util.Map;

public class TestJSON
{
    public static void main(String[] args) {
        Map<String,Object> map = new HashMap<>();
        map.put( "error" , 0 );
        map.put( "data" , "[{url:/editorimages/164751232176567e4dfaf-9c4c-48c2-ba72-f09cd5fbf779500.jpg}]" );
        String v = JSON.toJSONString(map);
        System.out.println(v);
    }
}
