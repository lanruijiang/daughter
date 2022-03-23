package org.daughter.base;

import org.daughter.base.model.Users;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.TreeMap;

@RestController
@RequestMapping("/getJson")
public class TestJsonDemo {

    @RequestMapping("/getMapJson")
    public Map<String , Object> getMapJson(){
        Map<String , Object> map = new TreeMap<>();
        Users users = new Users( 1,"xiaoming" );
        map.put( "users" , users );
        map.put( "num" , 10 );
        return  map;
    }
}
