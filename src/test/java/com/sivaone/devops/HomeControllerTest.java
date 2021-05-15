package com.sivaone.devops;

import com.sivaone.devops.usecase.GetGreetingUsecase;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.CoreMatchers.containsStringIgnoringCase;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest()
class HomeControllerTest {

    @Autowired
    private MockMvc mvc;
    @MockBean
    private GetGreetingUsecase getGreetingUsecase;

    @Test
    public void shouldReturnHelloDevops() throws Exception {
        final String name = "devops1";
        when(getGreetingUsecase.greet(eq(name)))
                .thenReturn("Hello " + name);

        mvc.perform(get("/")
                .queryParam("name", name))
                .andExpect(status().isOk())
                .andExpect(content().string(containsStringIgnoringCase("Hello " + name)));
    }
}