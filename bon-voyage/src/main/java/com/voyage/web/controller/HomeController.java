package com.voyage.web.controller;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.neo4j.repository.GraphRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.voyage.dao.RailwayStation;
import com.voyage.database.DatabaseManager;

@Controller
@RequestMapping("/home")
public class HomeController {

	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody 
	public String printWelcome(ModelMap model, HttpServletRequest req) {

		model.addAttribute("message", "Spring 3 MVC Hello World");
		System.out.println("CONTROLLER CALLED");
		DatabaseManager objA = null;
		//
		ServletContext application = req.getServletContext();
		if (application.getAttribute("databaseManager") == null) {
			ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
			 objA = (DatabaseManager) context.getBean("databaseManager");
			 application.setAttribute("databaseManager", objA);
		} else {
			objA = (DatabaseManager) application.getAttribute("databaseManager");
		}
		
		// DatabaseManager objA = new DatabaseManager();
		RailwayStation railwayStation = new RailwayStation("SBC");
		objA.addRailwayStation(railwayStation);
		GraphRepository<RailwayStation> stationRepo = objA.getTemplate().repositoryFor(RailwayStation.class);
		RailwayStation retrievedMovie = objA.getRailwayStation("SBC");
		System.out.println(retrievedMovie.getStationCode());
		return "hello";

	}

	private void loadIntialData(ModelMap model) {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

		DatabaseManager databaseManager = (DatabaseManager) context.getBean("databaseManager");

	}
}
