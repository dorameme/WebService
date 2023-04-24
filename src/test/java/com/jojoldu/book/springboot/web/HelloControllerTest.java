package com.jojoldu.book.springboot.web;

import com.jojoldu.book.springboot.web.HelloController;
import junit.framework.TestCase;
import org.junit.Test;//1
import org.junit.runner.RunWith;//2
import org.springframework.beans.factory.annotation.Autowired;//3
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;//4
import org.springframework.test.context.junit4.SpringRunner;//5
import org.springframework.test.web.servlet.MockMvc;//6
import org.springframework.test.web.servlet.ResultActions;//7
import org.springframework.test.web.servlet.ResultMatcher;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner.class)
@WebMvcTest(controllers = HelloController.class)
public class HelloControllerTest {
    @Autowired
    private MockMvc mvc;//web API를 테스트 할 때 사용
    @Test
    public void testHello() throws Exception{
        String hello="hello";
        mvc.perform(get("/hello"))//http get 요청을 함
            .andExpect(status().isOk())//200인지 확인
            .andExpect(content().string(hello));//"hello"인지 확인
    }
    @Test
    public  void helloDto가_리턴() throws Exception{
        String name="hello";
        int amount=1000;
        mvc.perform(
                        get("/hello/dto")
                                .param("name", name)
                                .param("amount", String.valueOf(amount)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name", is(name)))
                .andExpect(jsonPath("$.amount", is(amount)));
    }
}