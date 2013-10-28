package com.voyage.model;

import java.io.File;
import java.io.IOException;

import org.neo4j.gis.spatial.SimplePointLayer;
import org.neo4j.gis.spatial.SpatialDatabaseService;
import org.neo4j.gis.spatial.encoders.SimplePointEncoder;
import org.neo4j.kernel.EmbeddedGraphDatabase;
import org.neo4j.kernel.impl.util.FileUtils;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.neo4j.repository.GraphRepository;

import com.vividsolutions.jts.geom.Point;
import com.voyage.dao.RailwayStation;
import com.voyage.database.DatabaseManager;

//http://code.google.com/p/project-ds/source/browse/trunk/SpatialDatabases_proj/src/spatialtests/Neo4JExample.java?spec=svn146&r=146

public class BonVoyageService {

	public static ClassPathXmlApplicationContext context;

	// Circle circle = new Circle(-73.99171, 40.738868, 0.01);
	// Point location = new Point(-73.99171, 40.738868);
	// NearQuery query = NearQuery.near(location).maxDistance(new Distance(10,
	// Metrics.MILES));

	public BonVoyageService() throws IOException {
		// clean up
		FileUtils.deleteRecursively(new File("/tmp/graph.db"));

		// loadData();
	}

//	public void initData() {
//		RailwayStation station = new RailwayStation("SBC");
//		station.setCoordinate(10, 10);
//		addRailwayStation(station);
//	}

	

	// public List<RailwayStation> getNearByStations(Coordinate location) {
	// // stationLayer.getSpatialDatabase().
	// List<GeoPipeFlow> results =
	// stationLayer.findClosestPointsTo(location, 10.0);
	// // results.get(0).getRecord().getGeomNode().get
	// }

	public static void main(String[] args) throws IOException {
//		BonVoyageService b = new BonVoyageService();
//		RailwayStation a = b.getRailwayStation("SBC");
//		System.out.println(a);
	}
}
