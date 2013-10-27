package com.voyage.web.controller;

import org.neo4j.gis.spatial.EditableLayer;
import org.neo4j.gis.spatial.EditableLayerImpl;
import org.neo4j.gis.spatial.SpatialDatabaseService;
import org.neo4j.gis.spatial.encoders.SimplePointEncoder;
import org.neo4j.kernel.EmbeddedGraphDatabase;
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

	//FileUtils.deleteRecursively(new File("accessingdataneo4j.db"));
	
    @RequestMapping(method = RequestMethod.GET)
    public String printWelcome(ModelMap model) {

        model.addAttribute("message", "Spring 3 MVC Hello World");
        System.out.println("CONTROLLER CALLED");

        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        EmbeddedGraphDatabase embeddedGraphDatabase = (EmbeddedGraphDatabase) context.getBean("graphDatabaseService");
        DatabaseManager database = (DatabaseManager) context.getBean("databaseManager");
        SpatialDatabaseService spatialDb = new SpatialDatabaseService(embeddedGraphDatabase);
        EditableLayer stationLayer = (EditableLayer) spatialDb.getOrCreateLayer("stationLayer", SimplePointEncoder.class, EditableLayerImpl.class, "lon:lat");
        RailwayStation railwayStation = new RailwayStation("SBC");
        database.save(railwayStation);
        System.out.println(database.getTemplate());
        return "hello";

    }
}
