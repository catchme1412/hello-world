package com.voyage.rail.core.domain;

import java.util.Collection;
import java.util.HashSet;

import org.joda.time.LocalTime;
import org.springframework.data.neo4j.annotation.GraphId;
import org.springframework.data.neo4j.annotation.Indexed;
import org.springframework.data.neo4j.annotation.NodeEntity;
import org.springframework.data.neo4j.annotation.RelatedToVia;

@NodeEntity
public class RailwayStation {

    @GraphId
    Long nodeId;
    
    @Indexed(unique = true)
    private
    String stationCode;
    
    private String stationName;
    
    @RelatedToVia
    private  Collection<RouteLeg> routes;
    
    public RailwayStation() {
        routes = new HashSet<RouteLeg>();
    }

    
    public String getStationName() {
        return stationName;
    }

    public void setStationName(String stationName) {
        this.stationName = stationName;
    }

    public String getStationCode() {
        return stationCode;
    }

    public void setStationCode(String stationCode) {
        this.stationCode = stationCode;
    }

    @Override
    public String toString() {
        return String.format("[%s]", getStationCode());
    }
    
    @Override
    public boolean equals(Object obj) {
        return stationCode.equals(((RailwayStation)obj).getStationCode());
    }
    
    @Override
    public int hashCode() {
        return stationCode.hashCode();
    }

    public Iterable<RouteLeg> getRoutes() {
        return routes;
    }

    public RouteLeg addRoute(RouteLeg route, String roleName) {
        routes.add(route);
        return route;
    }
    
    public RouteLeg addRoute(RailwayStation to, String trainNumber, LocalTime arrivalTime, LocalTime departureTime, double distance) {
        RouteLeg r = new RouteLeg();
        r.setFrom(this);
        r.setTo(to);
        r.setTrainNumber(trainNumber);
        r.setArrivalTime(arrivalTime);
        r.setDepartureTime(departureTime);
        r.setDistance(distance);
        return addRoute(r, "ROUTE");
    }
}
