package com.voyage.dao;

import org.joda.time.LocalTime;
import org.joda.time.Minutes;
import org.springframework.data.neo4j.annotation.EndNode;
import org.springframework.data.neo4j.annotation.GraphId;
import org.springframework.data.neo4j.annotation.RelationshipEntity;
import org.springframework.data.neo4j.annotation.StartNode;

@RelationshipEntity
public class RouteLeg {

	@GraphId
	private Long id;

	private String trainNumber;

	@StartNode
	private RailwayStation from;

	@EndNode
	private RailwayStation to;
	
	
	private LocalTime arrivalTime;
	
	private LocalTime departureTime;
	
	private double distance;
	
	private int day;
	
	private String trainType;

	public Minutes getHaltTime() {
		return Minutes.minutesBetween(departureTime, arrivalTime);
	}

	public String getTrainNumber() {
		return trainNumber;
	}

	public void setTrainNumber(String trainNumber) {
		this.trainNumber = trainNumber;
	}

	public double getDistance() {
		return distance;
	}

	public void setDistance(double distance) {
		this.distance = distance;
	}

	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		this.day = day;
	}

	public String getTrainType() {
		return trainType;
	}

	public void setTrainType(String trainType) {
		this.trainType = trainType;
	}

	public RailwayStation getFrom() {
		return from;
	}

	public void setFrom(RailwayStation from) {
		this.from = from;
	}

	public RailwayStation getTo() {
		return to;
	}

	public void setTo(RailwayStation to) {
		this.to = to;
	}
}
