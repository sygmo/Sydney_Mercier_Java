package com.example.M2ChallengeMercierSydney.controller;

import com.example.M2ChallengeMercierSydney.model.MathSolution;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class MathController {

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public MathSolution add(@RequestBody MathSolution mathSolution) {
        if (mathSolution.getOperand1() == null || mathSolution.getOperand2() == null) {
            throw new IllegalArgumentException("Operand is missing.");
        }
        return new MathSolution(mathSolution.getOperand1(), mathSolution.getOperand2(), "add", mathSolution.getOperand1() + mathSolution.getOperand2());
    }

    @RequestMapping(value = "/subtract", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public MathSolution subtract(@RequestBody MathSolution mathSolution) {
        if (mathSolution.getOperand1() == null || mathSolution.getOperand2() == null) {
            throw new IllegalArgumentException("Operand is missing.");
        }
        return new MathSolution(mathSolution.getOperand1(), mathSolution.getOperand2(), "subtract", mathSolution.getOperand1() - mathSolution.getOperand2());
    }

    @RequestMapping(value = "/multiply", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public MathSolution multiply(@RequestBody MathSolution mathSolution) {
        if (mathSolution.getOperand1() == null || mathSolution.getOperand2() == null) {
            throw new IllegalArgumentException("Operand is missing.");
        }
        return new MathSolution(mathSolution.getOperand1(), mathSolution.getOperand2(), "multiply", mathSolution.getOperand1() * mathSolution.getOperand2());
    }

    @RequestMapping(value = "/divide", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public MathSolution divide(@RequestBody MathSolution mathSolution) {
        if (mathSolution.getOperand1() == null || mathSolution.getOperand2() == null || mathSolution.getOperand2() == 0) {
            throw new IllegalArgumentException("Operand is missing.");
        }
        return new MathSolution(mathSolution.getOperand1(), mathSolution.getOperand2(), "divide", mathSolution.getOperand1() / mathSolution.getOperand2());
    }

}
