package com.example.demo;


import cn.afterturn.easypoi.excel.entity.ExportParams;
import com.example.demo.util.EasyPoiUtils;
import com.example.demo.util.UserEntity;
import org.junit.jupiter.api.Test;

import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.util.*;


@SpringBootTest
class DemoApplicationTests {


	@Test
	void contextLoads() {
        List<UserEntity> list = new ArrayList<>();
        int i = 0;
        while (i < 10) {
            UserEntity user = new UserEntity();
            user.setId(i + 1);
            user.setAge(20 + i);
            user.setEmail("abc@163.com");
            user.setName("张三" + i);
            user.setSex(i % 2 == 0 ? 1 : 2);
            user.setTime(new Date());
            list.add(user);
            i++;
        }
        try {
            EasyPoiUtils.exportExcel(UserEntity.class,list,"src/main/resources/excel/","user.xls");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    void test2() {
        List<Map<String, Object>> list = new ArrayList<>();
        for (int n = 1; n < 4; n++) {
            ExportParams exportParams = new ExportParams("用户信息" + n, "用户信息" + n);
            Object entity = UserEntity.class;
            List<UserEntity> data = new ArrayList<>();
            int i = 0;
            while (i < 10) {
                UserEntity user = new UserEntity();
                user.setId(i * n + 1);
                user.setAge(20 + i);
                user.setEmail("abc@163.com");
                user.setName("张三" + i * n);
                user.setSex(i % 2 == 0 ? 1 : 2);
                user.setTime(new Date());
                data.add(user);
                i++;
            }
            // 构建map
            Map<String, Object> map = new HashMap<>();
            map.put("title", exportParams);
            map.put("entity", entity);
            map.put("data", data);
            list.add(map);
        }
        try {
            EasyPoiUtils.exportExcel(list, "src/main/resources/excel/", "user1.xls");
        } catch (IOException e) {
            e.printStackTrace();
        }

	}
}
