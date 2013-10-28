package com.voyage.database;

import java.io.IOException;

import org.neo4j.gis.spatial.SimplePointLayer;
import org.neo4j.gis.spatial.SpatialDatabaseService;
import org.neo4j.gis.spatial.encoders.SimplePointEncoder;
import org.neo4j.kernel.EmbeddedGraphDatabase;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.neo4j.repository.GraphRepository;
import org.springframework.data.neo4j.template.Neo4jOperations;
import org.springframework.transaction.annotation.Transactional;

import com.vividsolutions.jts.geom.Point;
import com.voyage.dao.RailwayStation;
import com.voyage.dao.RouteLeg;

@Transactional
public class DatabaseManagerImpl implements InitializingBean, DatabaseManager {

	@Autowired
	private Neo4jOperations template;
	@Autowired
	private EmbeddedGraphDatabase graphDatabaseService;

	private SpatialDatabaseService spatialDb;

	private SimplePointLayer stationLayer;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.voyage.database.DatabaseManager#getTemplate()
	 */
	@Override
	public Neo4jOperations getTemplate() {
		return template;
	}

	public void setTemplate(Neo4jOperations template) {
		this.template = template;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.voyage.database.DatabaseManager#save(java.lang.Object)
	 */
	@Override
	public void save(Object entity) {

		this.template.save(entity);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.voyage.database.DatabaseManager#addRailwayStation(com.voyage.dao.
	 * RailwayStation)
	 */
	@Override
	public void addRailwayStation(RailwayStation station) {
		if (getRailwayStation(station.getStationCode()) == null) {
			template.save(station);
		} else {

		}
		Point node = stationLayer.getGeometryFactory().createPoint(station.getCoordinate());
		// Node node =
		// databaseManager.getTemplate().getPersistentState(station);
		// UniqueFactory<Node> factory = new
		// UniqueFactory.UniqueNodeFactory(graphDatabaseService, "UserNodes") {
		// @Override
		// protected void initialize(Node created, Map<String, Object>
		// properties) {
		// created.setProperty("stationCode", properties.get("stationCode"));
		// }
		// };
		//
		// factory.getOrCreate("stationCode", station);
		// node.setUserData(station);// ?
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.voyage.database.DatabaseManager#getRailwayStation(java.lang.String)
	 */
	@Override
	public RailwayStation getRailwayStation(String stationCode) {
		GraphRepository<RailwayStation> stationRepo = template.repositoryFor(RailwayStation.class);
		RailwayStation retrievedMovie = stationRepo.findByPropertyValue("stationCode", stationCode);
		return retrievedMovie;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.voyage.database.DatabaseManager#forceClean()
	 */
	@Override
	public void forceClean() {
		try {
			Runtime.getRuntime().exec("rm -rf /tmp/graph*");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		spatialDb = new SpatialDatabaseService(graphDatabaseService);
		// TODO Auto-generated method stub
		stationLayer = (SimplePointLayer) spatialDb.getOrCreateLayer("stationLayer", SimplePointEncoder.class,
				SimplePointLayer.class, "lon:lat");

	}

	@Override
	public void addRouteLeg(RouteLeg leg) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public RouteLeg getRouteLeg(String from, String to) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public RouteLeg getRouteLeg(RailwayStation from, RailwayStation to) {

		GraphRepository<RouteLeg> stationRepo = template.repositoryFor(RouteLeg.class);
//		RailwayStation retrievedMovie = stationRepo.findByPropertyValue("stationCode", stationCode);
		return null;
	
		// TODO Auto-generated method stub
	}
}
