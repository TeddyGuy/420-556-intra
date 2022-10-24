package com.medi._420556intra.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.medi._420556intra.payload.response.ResultingIntegerDto;
import com.medi._420556intra.service.MathService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class MathControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    MathService mathService;

    @Test
    void addBadRequest() throws Exception {

        //Act & Assert
        mockMvc.perform(post("/api/math/add")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"a\":\"blah blah\",\"b\":7}"))
                .andExpect(status().isBadRequest());
    }

    @Test
    void addDecimal() throws Exception {
        //Arrange

        String expected = new ObjectMapper().writeValueAsString(new ResultingIntegerDto(12));

        when(mathService.add(anyInt(), anyInt())).thenReturn(12);

        //Act & Assert
        String actual = mockMvc.perform(post("/api/math/add")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"a\":5.3,\"b\":7}"))
                .andExpect(status().isOk()).andReturn().getResponse().getContentAsString();

        assertThat(actual).isNotBlank().isEqualTo(expected);
    }

    @Test
    void addHappyDay() throws Exception {
        //Arrange

        String expected = new ObjectMapper().writeValueAsString(new ResultingIntegerDto(51));

        when(mathService.add(anyInt(), anyInt())).thenReturn(51);

        //Act & Assert
        String actual = mockMvc.perform(post("/api/math/add")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"a\":11,\"b\":40}"))
                .andExpect(status().isOk()).andReturn().getResponse().getContentAsString();

        assertThat(actual).isNotBlank().isEqualTo(expected);
    }

    @Test
    void subtractBadRequest() throws Exception {

        //Act & Assert
        mockMvc.perform(post("/api/math/subtract")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"a\":\"blah blah\",\"b\":7}"))
                .andExpect(status().isBadRequest());
    }

    @Test
    void subtractDecimal() throws Exception {
        //Arrange

        String expected = new ObjectMapper().writeValueAsString(new ResultingIntegerDto(1));

        when(mathService.subtract(anyInt(), anyInt())).thenReturn(1);

        //Act & Assert
        String actual = mockMvc.perform(post("/api/math/subtract")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"a\":8.3,\"b\":7}"))
                .andExpect(status().isOk()).andReturn().getResponse().getContentAsString();

        assertThat(actual).isNotBlank().isEqualTo(expected);
    }

    @Test
    void subtractHappyDay() throws Exception {
        //Arrange

        String expected = new ObjectMapper().writeValueAsString(new ResultingIntegerDto(-29));

        when(mathService.subtract(anyInt(), anyInt())).thenReturn(-29);

        //Act & Assert
        String actual = mockMvc.perform(post("/api/math/subtract")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"a\":11,\"b\":40}"))
                .andExpect(status().isOk()).andReturn().getResponse().getContentAsString();

        assertThat(actual).isNotBlank().isEqualTo(expected);
    }
}
