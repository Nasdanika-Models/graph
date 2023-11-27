module org.nasdanika.models.graph.processors {
		
	requires transitive org.nasdanika.graph.model;
	requires transitive org.nasdanika.models.ecore.graph;
	
	exports org.nasdanika.models.graph.processors.ecore;
	opens org.nasdanika.models.graph.processors.ecore; // For loading resources
	
	exports org.nasdanika.models.graph.processors.doc;
	opens org.nasdanika.models.graph.processors.doc; // For loading resources
	
}
