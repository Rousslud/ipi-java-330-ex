package com.ipiecoles.java.java330.controller;

import com.ipiecoles.java.java330.service.CommercialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/commercials")
public class CommercialController {

    @Autowired
    CommercialService commercialService;

    @RequestMapping(
            value = "/{id}",
            method = RequestMethod.POST
    )
    public String enregistre(@RequestParam("id") Long id) {

        return null;
    }
}