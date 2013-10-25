package com.voyage.dao;

import org.springframework.data.neo4j.annotation.GraphId;
import org.springframework.data.neo4j.annotation.Indexed;
import org.springframework.data.neo4j.annotation.NodeEntity;

@NodeEntity
public class RailwayStation {
    
    @GraphId 
    private Long nodeId;

    private String stationName;
    
    @Indexed
    private String stationCode;
    
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

    
}
