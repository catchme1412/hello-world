package com.voyage.web.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.voyage.service.google.map.GoogleMapQueryResult;
import com.voyage.service.google.map.GoogleMapServiceProvider;
import com.voyage.util.FileUtils;

@Controller
@RequestMapping("/init")
public class DataLoadController {

	@RequestMapping(method = RequestMethod.GET)
	public String printWelcome(ModelMap model) throws IOException {

		// try {
		// BonVoyageService b = new BonVoyageService();
		// b.initData();
		// System.out.println(b.getRailwayStation("SBC").getStationCode());
		// } catch (IOException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }
		// RailwayStation railwayStation = new RailwayStation("SBC");
		// objA.save(railwayStation);
		// GraphRepository<RailwayStation> stationRepo =
		// objA.getTemplate().repositoryFor(RailwayStation.class);
		// RailwayStation retrievedMovie =
		// stationRepo.findByPropertyValue("stationCode", "SBC");
		// System.out.println(retrievedMovie.getStationCode());
		loadIntialData();
		System.out.println("FFFFFFFFFFFFFFFFFFFFFFFFFFFF");
		return "hello";

	}

	private void loadIntialData() throws IOException {

		InputStream files = FileUtils.loadAsResource("trains.csv");
		BufferedReader br = new BufferedReader(new InputStreamReader(files, "UTF-8"));
		String strLine;
		//skip the first line
		br.readLine();
		while ((strLine = br.readLine()) != null) {
			System.out.println(strLine);
			String[] a = strLine.split("\t");
			System.out.println("TrainNo:" + a[0].trim());
			System.out.println("Name:" + a[1].trim());
			System.out.println("Loc:" + a[2].trim());
			GoogleMapQueryResult r = new GoogleMapServiceProvider().getGeocode(a[2].trim());
			System.out.println("LAT:" + r.getResults().get(0).getGeometry().getLocation().getLat());
			System.out.println("LNG:" + r.getResults().get(0).getGeometry().getLocation().getLng());
		}
		System.out.println(files);
	}
}
