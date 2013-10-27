package com.voyage.dao;

import org.springframework.data.neo4j.annotation.GraphId;
import org.springframework.data.neo4j.annotation.Indexed;
import org.springframework.data.neo4j.annotation.NodeEntity;

import com.vividsolutions.jts.geom.Coordinate;


@NodeEntity
public class RailwayStation {
    
    @GraphId 
    private Long nodeId;

    @Indexed
    private String stationCode;
    
    private String stationName;

	private Coordinate coordinate;
	
    
    
    public RailwayStation() {
        //empty
    }
    
    public RailwayStation(String stationCode) {
        this.setStationCode(stationCode);
    }
    
    public String getStationCode() {
        return stationCode;
    }

    public void setStationCode(String stationCode) {
        this.stationCode = stationCode;
    }

	public String getStationName() {
		return stationName;
	}

	public void setStationName(String stationName) {
		this.stationName = stationName;
	}

	public Coordinate getCoordinate() {
		return coordinate;
	}

	public void setCoordinate(double lat, double lon) {
		coordinate = new Coordinate(lat, lon);
	}

	public void setCoordinate(Coordinate coordinate) {
		this.coordinate = coordinate;
	}
    
}
