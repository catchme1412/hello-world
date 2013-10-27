package com.voyage.model;

import java.util.HashMap;
import java.util.Map;

import org.neo4j.graphdb.Node;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.neo4j.template.Neo4jOperations;
import org.springframework.transaction.annotation.Transactional;


@Transactional
public class SampleTest {

	@Autowired
	Neo4jOperations template;

	public void testSimpleCreate() {
		// template.

		Map<String, Object> obj = new HashMap<String, Object>();
		obj.put("key1", "test1");
		obj.put("key2", "test2");
		Node create = template.createNode(obj);
		System.out.println("Id: " + create.getId());

		Node read = template.getNode(create.getId());
		// Throws exception (noted below)

		System.out.println("name: " + read.getProperty("key1"));
	}

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
//
//		DatabaseManager objA = (DatabaseManager) context.getBean("databaseManager");
//		System.out.println(objA.getTemplate());
	}
	// @Test
	// public void testCreateCustomModel() throws Exception {
	// RailwayStation railwayStation = new RailwayStation("SBC");
	//
	// RailwayStation sbc = template.save(railwayStation);
	// GraphRepository<RailwayStation> stationRepo =
	// template.repositoryFor(RailwayStation.class);
	// RailwayStation retrievedMovie =
	// stationRepo.findByPropertyValue("stationCode", "SBC");
	// assertEquals("retrieved movie matches persisted one",
	// sbc.getStationCode(), retrievedMovie.getStationCode());
	// // assertEqual("retrieved movie title matches", "Forrest Gump",
	// retrievedMovie.getTitle());
	// }

}
