package com.neusoft.managerservice;



import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.fastjson.JSONObject;
import com.neusoft.interfaces.AttrService;

import com.neusoft.javabean.po.BaseCatalog1;
import com.neusoft.javabean.po.BaseCatalog2;
import com.neusoft.managerservice.serviceimpl.AttrServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ManagerServiceApplicationTests {

    @Reference
    AttrService attrService;


    @Test
    public void getCatalogJSON() throws IOException {
        List<BaseCatalog1> baseCatalog1s = attrService.selectAllCatalog();
        JSONObject jsonObject = new JSONObject();
        HashMap<String, List<BaseCatalog2>> map = new HashMap<>();
        for (BaseCatalog1 baseCatalog1 : baseCatalog1s) {
            Long catalog1Id = baseCatalog1.getId();
            List<BaseCatalog2> catalog2List = baseCatalog1.getCatalog2List();
            jsonObject.put(catalog1Id.toString(),catalog2List);
        }
        String jsonString = jsonObject.toJSONString();
        File file = new File("D:\\IDEA_Project\\guli201904\\manager-service\\src\\main\\resources\\static\\catalog.json");

        if(!file.exists()){
            file.createNewFile();
        }
        FileOutputStream stream = new FileOutputStream(file);
        stream.write(jsonString.getBytes("utf-8"));
        stream.close();
    }


    @Test
    public void contextLoads() {
    }
}