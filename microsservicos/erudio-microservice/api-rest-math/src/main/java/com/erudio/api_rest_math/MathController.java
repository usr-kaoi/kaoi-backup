package com.erudio.api_rest_math;

import com.erudio.api_rest_math.exceptions.UnsupportedMathOperationException;
import com.erudio.api_rest_math.math.SimpleMath;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import static com.erudio.api_rest_math.converters.NumberConverter.*;

@RestController
public class MathController {

    private SimpleMath math = new SimpleMath();

    @RequestMapping(value = "/sum/{numberOne}/{numberTwo}", method=RequestMethod.GET)
    public Double sum(
            @PathVariable(value = "numberOne") String numberOne,
            @PathVariable(value = "numberTwo") String numberTwo)  throws Exception {

        if(!isNumeric(numberOne) || !isNumeric(numberTwo)){
            throw new UnsupportedMathOperationException("Please, insert a numeric value!");
        }
        return math.sum(convertToDouble(numberOne), convertToDouble(numberTwo));
    }

    @RequestMapping(value = "/difference/{numberOne}/{numberTwo}", method=RequestMethod.GET)
    public Double difference(
            @PathVariable(value = "numberOne") String numberOne,
            @PathVariable(value = "numberTwo") String numberTwo)  throws Exception {

        if(!isNumeric(numberOne) || !isNumeric(numberTwo)){
            throw new UnsupportedMathOperationException("Please, insert a numeric value!");
        }
        return math.difference(convertToDouble(numberOne), convertToDouble(numberTwo));
    }

    @RequestMapping(value = "/product/{numberOne}/{numberTwo}", method=RequestMethod.GET)
    public Double product(
            @PathVariable(value = "numberOne") String numberOne,
            @PathVariable(value = "numberTwo") String numberTwo)  throws Exception {

        if(!isNumeric(numberOne) || !isNumeric(numberTwo)){
            throw new UnsupportedMathOperationException("Please, insert a numeric value!");
        }
        return math.product(convertToDouble(numberOne), convertToDouble(numberTwo));
    }

    @RequestMapping(value = "/quotient/{numberOne}/{numberTwo}", method=RequestMethod.GET)
    public Double quotient (
            @PathVariable(value = "numberOne") String numberOne,
            @PathVariable(value = "numberTwo") String numberTwo)  throws Exception {

        if(!isNumeric(numberOne) || !isNumeric(numberTwo)){
            throw new UnsupportedMathOperationException("Please, insert a numeric value!");
        }
        return math.quotient(convertToDouble(numberOne), convertToDouble(numberTwo));
    }

    @RequestMapping(value = "/avarage/{numberOne}/{numberTwo}", method=RequestMethod.GET)
    public Double avarage(
            @PathVariable(value = "numberOne") String numberOne,
            @PathVariable(value = "numberTwo") String numberTwo)  throws Exception {

        if(!isNumeric(numberOne) || !isNumeric(numberTwo)){
            throw new UnsupportedMathOperationException("Please, insert a numeric value!");
        }
        return math.avarage((convertToDouble(numberOne)), convertToDouble(numberTwo));
    }

    @RequestMapping(value = "/root/{number}", method=RequestMethod.GET)
    public Double root( @PathVariable(value = "number") String number) throws Exception {

        if(!isNumeric(number)){
            throw new UnsupportedMathOperationException("Please, insert a numeric value!");
        }
        return math.root(convertToDouble(number));
    }
}
