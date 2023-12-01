/**
 */
package org.nasdanika.models.graph.processors.doc;

import org.nasdanika.graph.model.Connection;
import org.nasdanika.graph.model.GraphElement;

public interface CompositeConnectionSourceNodeProcessorMixIn<E extends GraphElement, C extends Connection<?>> extends SubGraphNodeProcessorMixIn<E>, ConnectionSourceNodeProcessorMixIn<C> {
	
} 
