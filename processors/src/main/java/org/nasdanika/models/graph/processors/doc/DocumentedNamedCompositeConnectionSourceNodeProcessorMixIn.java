/**
 */
package org.nasdanika.models.graph.processors.doc;

import org.nasdanika.graph.model.Connection;
import org.nasdanika.graph.model.GraphElement;

public interface DocumentedNamedCompositeConnectionSourceNodeProcessorMixIn<E extends GraphElement, C extends Connection<?>> extends DocumentedNamedSubGraphNodeProcessorMixIn<E>, CompositeConnectionSourceNodeProcessorMixIn<E, C> {
	
} 
