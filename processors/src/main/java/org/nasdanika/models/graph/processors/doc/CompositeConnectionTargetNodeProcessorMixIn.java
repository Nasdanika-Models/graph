/**
 */
package org.nasdanika.models.graph.processors.doc;

import org.nasdanika.graph.model.CompositeConnectionTarget;

public interface CompositeConnectionTargetNodeProcessorMixIn<T extends CompositeConnectionTarget<?,?>> extends SubGraphNodeProcessorMixIn<T>, ConnectionTargetNodeProcessorMixIn<T> {
	
} 
