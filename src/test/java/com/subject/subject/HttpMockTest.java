package com.subject.subject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

/**
 * @title: HttpMockTest
 * @description:
 * @author: zhangfan
 * @data: 2018年05月26日 17:37
 */

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class HttpMockTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void test() throws Exception{

        mockMvc.perform(get("/t")).andDo(print()).andExpect(status().isOk());

    }
}
