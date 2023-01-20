package co.develhope.swagger2.controllers;

import co.develhope.swagger2.entities.ArithmeticOperation;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/math")
public class MathController {

    @GetMapping("/")
    public String welcomeMathMessage(){
        return "welcome to the math";
    }

    @GetMapping("/division-info")
    public ArithmeticOperation division (){
        String [] strings = {"Divisione per 1", "divisione per 0"};
        return new ArithmeticOperation("divisione", 0, "dividendo/divisore=risultato", strings);
    }

    @GetMapping(value= "/multiplication")
    public int getMultiplication(@RequestParam(required = true) int operand1, @RequestParam(required = true) int operand2){
        return operand1 * operand2;
    }

    @GetMapping(value = "/square/{n}")
    @ApiOperation(value = "Execute a square of a given number", notes = "Gives back to the user the result of multiplication of the given number times itself")
    public int getSquare(@ApiParam(value = "The number that needs to be squared") @PathVariable() int n){
        return n * n;
    }
}