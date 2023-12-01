/**
 */
package org.nasdanika.models.graph.processors.doc;

import org.nasdanika.graph.model.Connection;

public interface DocumentedNamedConnectionSourceNodeProcessorMixIn<C extends Connection<?>> extends DocumentedNamedGraphElementNodeProcessorMixIn, ConnectionSourceNodeProcessorMixIn<C> {
	
} 
