//package com.voyage.service.google.map;
//
//import junit.framework.TestCase;
//
//
//public class GoogleMapServiceProviderTest extends TestCase {
//
//    private GoogleMapServiceProvider service;
//
//    @Override
//    protected void setUp() throws Exception {
//        service = new GoogleMapServiceProvider();
//        super.setUp();
//    }
//
//    public void testGetGeocode() {
//        GoogleMapQueryResult r = service.getGeocode("Bangalore+Cantt");
//        System.out.println(r.getResults().get(0).getGeometry().getLocation().getLat());
//    }
//
//}
