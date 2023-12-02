/**
 */
package org.nasdanika.models.graph.processors.doc;

import org.nasdanika.graph.model.Node;

public interface NodeNodeProcessorMixIn<T extends Node<?>> extends ConnectionSourceNodeProcessorMixIn<T>, ConnectionTargetNodeProcessorMixIn<T> {
	
} 
