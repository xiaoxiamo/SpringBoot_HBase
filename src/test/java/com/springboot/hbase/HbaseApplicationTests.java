package com.springboot.hbase;

import com.springboot.hbase.service.HBaseService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.Map;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
class HBaseApplicationTests {
    @Resource
    private HBaseService hbaseService;

    //测试创建表
    @Test
    public void testCreateTable() {
        hbaseService.creatTable("test_base", Arrays.asList("a", "back"));
    }

    //测试加入数据
    @Test
    public void testPutData() {
        hbaseService.putData("test_base", "000001", "a", new String[]{
                "project_id", "varName", "coefs", "pvalues", "tvalues",
                "create_time"}, new String[]{"40866", "mob_3", "0.9416",
                "0.0000", "12.2293", "null"});
        hbaseService.putData("test_base", "000002", "a", new String[]{
                "project_id", "varName", "coefs", "pvalues", "tvalues",
                "create_time"}, new String[]{"40866", "idno_prov", "0.9317",
                "0.0000", "9.8679", "null"});
        hbaseService.putData("test_base", "000003", "a", new String[]{
                "project_id", "varName", "coefs", "pvalues", "tvalues",
                "create_time"}, new String[]{"40866", "education", "0.8984",
                "0.0000", "25.5649", "null"});
    }

    //测试遍历全表
    @Test
    public void testGetResultScanner() {
        Map<String, Map<String, String>> result2 = hbaseService.getResultScanner("test_base");
        System.out.println("-----遍历查询全表内容-----");
        result2.forEach((k, value) -> {
            System.out.println(k + "--->" + value);
        });
    }

}
