module org.nasdanika.models.graph.processors {
		
	requires transitive org.nasdanika.graph.model;
	requires transitive org.nasdanika.models.ecore.graph;
	
	exports org.nasdanika.models.graph.processors;
	opens org.nasdanika.models.graph.processors; // For loading resources
	
}
