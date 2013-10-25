package com.voyage.web.controller;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.voyage.dao.RailwayStation;
import com.voyage.database.DatabaseManager;

@Controller
@RequestMapping("/home")
public class HomeController {

    @RequestMapping(method = RequestMethod.GET)
    public String printWelcome(ModelMap model) {

        model.addAttribute("message", "Spring 3 MVC Hello World");
        System.out.println("CONTROLLER CALLED");

        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        DatabaseManager objA = (DatabaseManager) context.getBean("databaseManager");
        RailwayStation railwayStation = new RailwayStation("SBC");
        objA.save(railwayStation);
        System.out.println(objA.getTemplate());
        return "hello";

    }
}
