package com.example.M2ChallengeMercierSydney.controller;

import com.example.M2ChallengeMercierSydney.model.Month;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

@RestController
public class MonthController {

    private static List<Month> monthList = new ArrayList<>(Arrays.asList(
            new Month(1, "January"),
            new Month(2, "February"),
            new Month(3, "March"),
            new Month(4, "April"),
            new Month(5, "May"),
            new Month(6, "June"),
            new Month(7, "July"),
            new Month(8, "August"),
            new Month(9, "September"),
            new Month(10, "October"),
            new Month(11, "November"),
            new Month(12, "December")
    ));

    @RequestMapping(value = "/month/{monthNumber}", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public Month convertMonth(@PathVariable int monthNumber) {
        Month foundMonth = null;

        for (Month month : monthList) {
            if (month.getNumber() == monthNumber) {
                foundMonth = month;
                break;
            }
        }

        if (foundMonth == null) {
            throw new IllegalArgumentException("Month number is out of valid range.");
        }

        return foundMonth;
    }

    @RequestMapping(value = "/randomMonth", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public Month getRandomMonth() {
        Random random = new Random();

        Month randomMonth = monthList.get(random.nextInt(monthList.size()));
        return randomMonth;
    }
}
