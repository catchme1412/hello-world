package com.voyage.database;

import java.io.Serializable;

import org.springframework.data.neo4j.template.Neo4jOperations;

import com.voyage.dao.RailwayStation;
import com.voyage.dao.RouteLeg;

public interface DatabaseManager extends Serializable {

	public abstract Neo4jOperations getTemplate();

	public abstract void save(Object entity);

	public abstract void addRailwayStation(RailwayStation station);

	public abstract RailwayStation getRailwayStation(String stationCode);
	
	public void addRouteLeg(RouteLeg leg);
	
	public RouteLeg getRouteLeg(String from, String to);
	
	public RouteLeg getRouteLeg(RailwayStation from, RailwayStation to);

	public abstract void forceClean();

}