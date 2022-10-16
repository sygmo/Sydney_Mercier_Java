package com.example.M2ChallengeMercierSydney.controller;

import com.example.M2ChallengeMercierSydney.model.MathSolution;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@WebMvcTest(MathController.class)
public class MathControllerTest {

    @Autowired
    private MockMvc mockMvc;
    private ObjectMapper mapper = new ObjectMapper();

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void shouldCorrectlyAddNumbers() throws Exception {
        MathSolution inputMath = new MathSolution();
        inputMath.setOperand1(5);
        inputMath.setOperand2(7);

        String inputJson = mapper.writeValueAsString(inputMath);

        MathSolution outputMath = new MathSolution(5, 7, "add", 12);
        String outputJson = mapper.writeValueAsString(outputMath);

        mockMvc.perform(
                post("/add")
                        .content(inputJson)
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isCreated())
                .andExpect(content().json(outputJson));
    }

    @Test
    public void shouldReturn422IfAddOperandIsMissing() throws Exception {
        MathSolution inputMath = new MathSolution();
        inputMath.setOperand1(10);

        String inputJson = mapper.writeValueAsString(inputMath);

        mockMvc.perform(
                post("/add")
                        .content(inputJson)
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isUnprocessableEntity());
    }

    @Test
    public void shouldCorrectlySubtractNumbers() throws Exception {
        MathSolution inputMath = new MathSolution();
        inputMath.setOperand1(30);
        inputMath.setOperand2(17);

        String inputJson = mapper.writeValueAsString(inputMath);

        MathSolution outputMath = new MathSolution(30, 17, "subtract", 13);
        String outputJson = mapper.writeValueAsString(outputMath);

        mockMvc.perform(
                        post("/subtract")
                                .content(inputJson)
                                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isCreated())
                .andExpect(content().json(outputJson));
    }

    @Test
    public void shouldReturn422IfSubtractOperandIsMissing() throws Exception {
        MathSolution inputMath = new MathSolution();
        inputMath.setOperand2(15);

        String inputJson = mapper.writeValueAsString(inputMath);

        mockMvc.perform(
                        post("/subtract")
                                .content(inputJson)
                                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isUnprocessableEntity());
    }

    @Test
    public void shouldCorrectlyMultiplyNumbers() throws Exception {
        MathSolution inputMath = new MathSolution();
        inputMath.setOperand1(20);
        inputMath.setOperand2(3);

        String inputJson = mapper.writeValueAsString(inputMath);

        MathSolution outputMath = new MathSolution(20, 3, "multiply", 60);
        String outputJson = mapper.writeValueAsString(outputMath);

        mockMvc.perform(
                        post("/multiply")
                                .content(inputJson)
                                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isCreated())
                .andExpect(content().json(outputJson));
    }

    @Test
    public void shouldReturn422IfMultiplyOperandIsMissing() throws Exception {
        MathSolution inputMath = new MathSolution();
        inputMath.setOperand1(12);

        String inputJson = mapper.writeValueAsString(inputMath);

        mockMvc.perform(
                        post("/multiply")
                                .content(inputJson)
                                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isUnprocessableEntity());
    }

    @Test
    public void shouldCorrectlyDivideNumbers() throws Exception {
        MathSolution inputMath = new MathSolution();
        inputMath.setOperand1(75);
        inputMath.setOperand2(5);

        String inputJson = mapper.writeValueAsString(inputMath);

        MathSolution outputMath = new MathSolution(75, 5, "divide", 15);
        String outputJson = mapper.writeValueAsString(outputMath);

        mockMvc.perform(
                        post("/divide")
                                .content(inputJson)
                                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isCreated())
                .andExpect(content().json(outputJson));
    }

    @Test
    public void shouldReturn422IfDivideOperandIsMissing() throws Exception {
        MathSolution inputMath = new MathSolution();
        inputMath.setOperand2(18);

        String inputJson = mapper.writeValueAsString(inputMath);

        mockMvc.perform(
                        post("/divide")
                                .content(inputJson)
                                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isUnprocessableEntity());
    }

    @Test
    public void shouldReturn422IfDivideByZero() throws Exception {
        MathSolution inputMath = new MathSolution();
        inputMath.setOperand1(6);
        inputMath.setOperand2(0);

        String inputJson = mapper.writeValueAsString(inputMath);

        mockMvc.perform(
                        post("/divide")
                                .content(inputJson)
                                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isUnprocessableEntity());
    }
}