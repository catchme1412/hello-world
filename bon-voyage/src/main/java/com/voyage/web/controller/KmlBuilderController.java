package com.voyage.web.controller;

import java.io.IOException;
import java.io.PrintStream;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/map")
public class KmlBuilderController {

	private static final String MIME_APPLICATION_VND_GOOGLE_EARTH_KML_XML = "application/vnd.google-earth.kml+xml";

	@RequestMapping(method = RequestMethod.GET)
	
	public @ResponseBody void buildMap(ModelMap model, HttpServletResponse response) {
		try {
			response.setContentType(MIME_APPLICATION_VND_GOOGLE_EARTH_KML_XML);
			PrintStream ps = new PrintStream(response.getOutputStream() );
			ps.println(KML_LINE_START);
			ps.println(String.format("%f,%f,2300", 10.0f, 10.0f));
			ps.println(String.format("%f,%f,2300", 15f, 10f));
			ps.println(KML_LINE_END);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	public static final String KML_LINE_START = "<?xml version='1.0' encoding='UTF-8'?>"
			+ "<kml xmlns='http://www.opengis.net/kml/2.2'>"
			+ "<Document>"
			+ "<name>Paths</name>"
			+ "<description>Route computed using Neo4j, a graph database that knows the Djkstra and A* shortest path algorithms.</description>"
			+ "<Style id='whiteLineGreenPoly'>" + "<LineStyle>" + "<color>ffffffff</color>" + "<width>3</width>"
			+ "</LineStyle>" + "<PolyStyle>" + "<color>ffffffff</color>" + "</PolyStyle>" + "</Style>" + "<Placemark>"
			+ "<name>Absolute Extruded</name>"
			+ "<description>Transparent green wall with yellow outlines</description>"
			+ "<styleUrl>whiteLineGreenPoly</styleUrl>" + "<LineString>" + "<extrude>0</extrude>"
			+ "<tessellate>1</tessellate>" + "<altitudeMode>clampToGround</altitudeMode>" + "<coordinates>";

	// Emit coordinate lon,lat,altitude triplets "here". e.g
	// -115.0001,49.878,2300

	public static final String KML_LINE_END = "</coordinates>" + "</LineString>" + "</Placemark>" + "</Document>"
			+ "</kml>";

}
