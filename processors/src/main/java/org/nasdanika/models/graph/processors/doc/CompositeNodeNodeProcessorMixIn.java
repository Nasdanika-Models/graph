/**
 */
package org.nasdanika.models.graph.processors.doc;

import org.nasdanika.graph.model.CompositeNode;

public interface CompositeNodeNodeProcessorMixIn<T extends CompositeNode<?,?>> extends SubGraphNodeProcessorMixIn<T>, NodeNodeProcessorMixIn<T> {
	
} 
