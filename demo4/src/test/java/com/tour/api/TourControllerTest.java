package com.tour.api;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ActiveProfiles("h2")
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class TourControllerTest {
    @Autowired
    private TestRestTemplate testRestTemplate;

    private MockMvc mockMvc;

    @MockBean
    TourController tourController;

    @Before
    public void setup() {
        mockMvc = MockMvcBuilders.standaloneSetup(tourController).build();
    }

    @Test
    public void 프로그램_정보_및_테마_수정_오류() throws Exception {
        final String url = "/program/theme/1";
        mockMvc.perform(put(url).contentType(MediaType.APPLICATION_JSON_UTF8).content(getSampleData())).andExpect(status().isOk());
    }

    public String getSampleData() {
        return "{\n" +
                "\"programName\":\"aaa\",\n" +
                "\"theme\":\"bbb\",\n" +
                "\"serviceArea\":\"ccc\",\n" +
                "\"programTitle\":\"ddd\",\n" +
                "\"programDetail\":\"eee\"\n" +
                "}";
    }
}
