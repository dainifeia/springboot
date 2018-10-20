package com.aididi.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * @author xuzexiang
 * @Date: 2018/7/25 0025
 * @Description:
 */
@RestController
public class IndexController {

    @RequestMapping("/index")
    public String index(Locale locale, Model model){
        model.addAttribute("greeting","hello");
        Date data = new Date();
        DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG,DateFormat.LONG,locale);
        String formatDate = dateFormat.format(data);
        model.addAttribute("currentTime",formatDate);
        return "index";

    }

}
