package ch.bbzbl.m254;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;

import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.junit.jupiter.api.Assertions.assertTrue;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class DemoApplicationTests {

    @Autowired
    private MockMvc mvcpost;

    @Autowired
    private MockMvc mvcget;

    @Test
    public void postTest() throws Exception {

        MvcResult result = mvcpost.perform(post("/hello").contentType(MediaType.TEXT_PLAIN).content("Leonardo"))
                .andExpect(status().isOk()).andReturn();

        String insertedString = result.getResponse().getContentAsString();

        System.out.println(insertedString);

        assertTrue(insertedString.equals("Hello Leonardo!"));
    }

    @Test
    public void getTest() throws Exception {

        MvcResult result = mvcget.perform(get("/hello").contentType(MediaType.TEXT_PLAIN))
                .andExpect(status().isOk()).andReturn();

        String insertedString = result.getResponse().getContentAsString();

        System.out.println(insertedString);

        assertTrue(insertedString.equals("Hello World!"));
    }
}
