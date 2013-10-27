package com.voyage.model;

import java.io.File;
import java.io.IOException;

import org.neo4j.gis.spatial.SimplePointLayer;
import org.neo4j.gis.spatial.SpatialDatabaseService;
import org.neo4j.gis.spatial.encoders.SimplePointEncoder;
import org.neo4j.kernel.EmbeddedGraphDatabase;
import org.neo4j.kernel.impl.util.FileUtils;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.neo4j.repository.GraphRepository;

import com.vividsolutions.jts.geom.Point;
import com.voyage.dao.RailwayStation;
import com.voyage.database.DatabaseManager;

//http://code.google.com/p/project-ds/source/browse/trunk/SpatialDatabases_proj/src/spatialtests/Neo4JExample.java?spec=svn146&r=146

public class BonVoyageService {

	private SimplePointLayer stationLayer;
	private EmbeddedGraphDatabase embeddedGraphDatabase;
	private DatabaseManager databaseManager;
	private SpatialDatabaseService spatialDb;

	// Circle circle = new Circle(-73.99171, 40.738868, 0.01);
	// Point location = new Point(-73.99171, 40.738868);
	// NearQuery query = NearQuery.near(location).maxDistance(new Distance(10,
	// Metrics.MILES));

	public BonVoyageService() throws IOException {
		//clean up
		FileUtils.deleteRecursively(new File("/tmp/graph.db"));
		
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		embeddedGraphDatabase = (EmbeddedGraphDatabase) context.getBean("graphDatabaseService");
		databaseManager = (DatabaseManager) context.getBean("databaseManager");
		spatialDb = new SpatialDatabaseService(embeddedGraphDatabase);
		stationLayer = (SimplePointLayer) spatialDb.getOrCreateLayer("stationLayer", SimplePointEncoder.class,
				SimplePointLayer.class, "lon:lat");

	}

	public void addRailwayStation(RailwayStation station) {
		// Node node =
		// databaseManager.getTemplate().getPersistentState(station);
		Point node = stationLayer.getGeometryFactory().createPoint(station.getCoordinate());
		node.setUserData(station);// ?
	}

	public RailwayStation getRailwayStation(String stationCode) {
		GraphRepository<RailwayStation> stationRepo = databaseManager.getTemplate().repositoryFor(RailwayStation.class);
		RailwayStation retrievedMovie = stationRepo.findByPropertyValue("stationCode", stationCode);
		return retrievedMovie;
	}
	// public List<RailwayStation> getNearByStations(Coordinate location) {
	// // stationLayer.getSpatialDatabase().
	// List<GeoPipeFlow> results =
	// stationLayer.findClosestPointsTo(location, 10.0);
	// // results.get(0).getRecord().getGeomNode().get
	// }
}
