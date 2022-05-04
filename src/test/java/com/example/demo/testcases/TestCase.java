package com.example.demo.testcases;

import com.alibaba.fastjson.JSONObject;
import com.example.demo.utils.HttpClients;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class TestCase {
    @BeforeMethod
    public void setUp() {

    }
    @AfterMethod
    public void tearDown() {
    }
    //Correct username and correct password,test passes
    @Test
    public void loginTestPass() throws IOException {
        Map<String,Object> body = new HashMap<>();
        body.put("user_name","xf49");
        body.put("password","123456");
        String result = HttpClients.post(null,"http://localhost:8080/user/login",new JSONObject(body));
        Assert.assertEquals(result.length(),32);

    }
    //Correct username but incorrect password,test failes
    @Test
    public void loginTestFail() throws IOException {
        Map<String,Object> body = new HashMap<>();
        body.put("user_name","xf49777");
        body.put("password","123456");
        String result = HttpClients.post(null,"http://localhost:8080/user/login",new JSONObject(body));
        Assert.assertEquals(result,"Incorrect username or password,please try again");
    }
}
