package com.erudio.api_rest_person.cotrollers;

import com.erudio.api_rest_person.exceptions.UnsupportedMathOperationException;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

import static com.erudio.api_rest_person.converters.NumberConverter.*;

@RestController
public class MathController {

    private final AtomicLong  counter = new AtomicLong();

    @RequestMapping(value = "/sum/{numberOne}/{numberTwo}", method=RequestMethod.GET)
    public Double sum(
            @PathVariable(value = "numberOne") String numberOne,
            @PathVariable(value = "numberTwo") String numberTwo)  throws Exception {

        if(!isNumeric(numberOne) || !isNumeric(numberTwo)){
            throw new UnsupportedMathOperationException("Please, insert a numeric value!");
        }
        return math.sum(convertToDouble(numberOne), convertToDouble(numberTwo));
    }
}
