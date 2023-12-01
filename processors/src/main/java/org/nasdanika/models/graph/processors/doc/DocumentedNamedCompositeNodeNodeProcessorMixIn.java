/**
 */
package org.nasdanika.models.graph.processors.doc;

import org.nasdanika.graph.model.Connection;
import org.nasdanika.graph.model.GraphElement;

public interface DocumentedNamedCompositeNodeNodeProcessorMixIn<E extends GraphElement, C extends Connection<?>> extends CompositeNodeNodeProcessorMixIn<E, C>, DocumentedNamedNodeNodeProcessorMixIn<C> {
	
} 
