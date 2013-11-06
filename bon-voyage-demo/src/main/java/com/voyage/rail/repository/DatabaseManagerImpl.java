package com.voyage.rail.repository;

import java.util.ArrayList;
import java.util.List;

import org.neo4j.gis.spatial.SimplePointLayer;
import org.neo4j.gis.spatial.SpatialDatabaseService;
import org.neo4j.gis.spatial.encoders.SimplePointEncoder;
import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.Path;
import org.neo4j.graphdb.traversal.TraversalDescription;
import org.neo4j.graphdb.traversal.Traverser;
import org.neo4j.kernel.EmbeddedGraphDatabase;
import org.neo4j.kernel.Traversal;
import org.neo4j.kernel.Uniqueness;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.neo4j.template.Neo4jOperations;
import org.springframework.transaction.annotation.Transactional;

import com.voyage.rail.core.domain.RailwayStation;
import com.voyage.rail.core.domain.RouteLeg;

@Transactional
public class DatabaseManagerImpl implements InitializingBean, DatabaseManager {

	@Autowired
	private RailwayStationRepository railwayStationRepository;

	@Autowired
	private EmbeddedGraphDatabase graphDatabaseService;

	private SpatialDatabaseService spatialDb;

	private SimplePointLayer stationLayer;

	@Autowired
	Neo4jOperations template;

	@Override
	public void addRailwayStation(RailwayStation station) {
		template.save(station);
		stationLayer.add(station.getCoordinate());
	}

	public void addRouteLeg(RouteLeg leg) {
		template.save(leg);
	}

	@Override
	public RailwayStation getRailwayStation(String stationCode) {
		return railwayStationRepository.findByStationCode(stationCode);

	}

	@Override
	public void afterPropertiesSet() throws Exception {
		spatialDb = new SpatialDatabaseService(graphDatabaseService);
		stationLayer = (SimplePointLayer) spatialDb.getOrCreateLayer("stationLayer", SimplePointEncoder.class,
				SimplePointLayer.class, "lon:lat");

	}

	@Override
	public Neo4jOperations getTemplate() {
		return template;
	}

	@Override
	public List<Path> getAllPathsFrom(RailwayStation from) {
		List<Path> legs = new ArrayList<Path>();
		TraversalDescription traversal = Traversal.description().uniqueness(Uniqueness.RELATIONSHIP_GLOBAL);

		Traverser t = traversal.traverse(template.getNode(from.getId()));
		for (Path position : t) {
			legs.add(position);
		}

		return legs;
	}

	
	@Override
	public List<RouteLeg> getRouteLeg(RailwayStation from, RailwayStation to) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Need to be implemented");
	}
	
	public Node getNode(RailwayStation station) {
		return template.getNode(station.getId());
	}

	@Override
	public List<Path> getAllSimplePath(Node from, Node to) {
		// TODO Auto-generated method stub
		return null;
	}

}
