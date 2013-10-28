package com.voyage.dao;

import org.joda.time.LocalTime;
import org.joda.time.Minutes;
import org.springframework.data.neo4j.annotation.GraphId;
import org.springframework.data.neo4j.annotation.NodeEntity;

@NodeEntity
public class RouteLeg {

	@GraphId 
    private Long routeLegId;
	
	private String trainNumber;

	private RailwayStation from;

	private RailwayStation to;
	private LocalTime arrivalTime;
	private LocalTime departureTime;
	private double distance;
	private int day;
	private String trainType;

	public Minutes getHaltTime() {
		return Minutes.minutesBetween(departureTime, arrivalTime);
	}
}
