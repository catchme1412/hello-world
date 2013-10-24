package com.voyage.database;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.neo4j.template.Neo4jOperations;

public class DatabaseManager {

	@Autowired
	private Neo4jOperations template;

	public Neo4jOperations getTemplate() {
		return template;
	}

	public void setTemplate(Neo4jOperations template) {
		this.template = template;
	}
	
	
	
}
