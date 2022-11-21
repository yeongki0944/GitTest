package com.todo;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Controller
public class testcontroller {

    @GetMapping("/api/quiz")
    @ResponseBody
    @CrossOrigin(origins = "http://localhost:3000")
    public ArrayList test() {
        ArrayList<Map<String, String>> list = new ArrayList<>();
        //{ { key: 1, title: 'test1', status: '작성중', qcnt: 10, author: '김재훈', date: '2021-08-01' }, { key: 2, title: 'test2', status: '사용가능', qcnt: 10, author: '김재이', date: '2021-08-01' } }
        Map<String, String> map = new HashMap<>();
        map.put("key", "1");
        map.put("title", "test1");
        map.put("status", "작성중");
        map.put("qcnt", "10");
        map.put("author", "김재훈");
        map.put("date", "2021-08-01");
        list.add(map);
        map = new HashMap<>();
        map.put("key", "2");
        map.put("title", "test22");
        map.put("status", "사용가능");
        map.put("qcnt", "10");
        map.put("author", "김재이");
        map.put("date", "2021-08-01");
        list.add(map);
        return list;
    }
}
