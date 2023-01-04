package com.cutti.api_diso;

import com.cutti.api_diso.exceptions.UnsupportedMathOperationException;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class MathController {

    private static final String template = "Hello, %s!";
    private static final AtomicLong counter = new AtomicLong();


    @RequestMapping(value = "/sum/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public Double sum(@PathVariable(value = "numberOne") String numberOne,
                      @PathVariable(value = "numberTwo") String numberTwo) {

        if (!isNumeric(numberOne) || !isNumeric(numberTwo)) {
            throw new UnsupportedMathOperationException("Please set a numeric value!");

        }

        return convertToDouble(numberOne) + convertToDouble(numberTwo);
    }

    @RequestMapping(value = "/sub/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public Double sub(@PathVariable(value = "numberOne") String numberOne,
                      @PathVariable(value = "numberTwo") String numberTwo) {

        if (!isNumeric(numberOne) || !isNumeric(numberTwo)) {
            throw new UnsupportedMathOperationException("Please set a numeric value!");

        }

        return convertToDouble(numberOne) - convertToDouble(numberTwo);
    }

    @RequestMapping(value = "/mult/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public Double mult(@PathVariable(value = "numberOne") String numberOne,
                      @PathVariable(value = "numberTwo") String numberTwo) {

        if (!isNumeric(numberOne) || !isNumeric(numberTwo)) {
            throw new UnsupportedMathOperationException("Please set a numeric value!");

        }

        return convertToDouble(numberOne) * convertToDouble(numberTwo);
    }

    @RequestMapping(value = "/half/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public Double half(@PathVariable(value = "numberOne") String numberOne,
                      @PathVariable(value = "numberTwo") String numberTwo) {

        if (!isNumeric(numberOne) || !isNumeric(numberTwo)) {
            throw new UnsupportedMathOperationException("Please set a numeric value!");

        }

        return convertToDouble(numberOne) / convertToDouble(numberTwo);
    }

    private Double convertToDouble(String strNumber) {

       if (strNumber == null) return 0D;

       String number = strNumber.replaceAll(",", ".");

       if (isNumeric(number)) return Double.parseDouble(number);

       return 0D;
    }

    private boolean isNumeric(String strNumber) {
        if (strNumber == null) return false;
        String number = strNumber.replaceAll(",", ".");
        return number.matches("[-+]?[0-9]*\\.?[0-9]+");
    }

}
