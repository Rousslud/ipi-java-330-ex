package com.ipiecoles.java.java330.controller;

import com.ipiecoles.java.java330.service.CommercialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestBody;
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
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE,
            produces = MediaType.TEXT_HTML_VALUE
    )
    public String enregistre(@RequestParam("id") Long id, @RequestBody MultiValueMap<String,String> map) {

        return null;
    }
}