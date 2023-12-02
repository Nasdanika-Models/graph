/**
 */
package org.nasdanika.models.graph.processors.doc;

import org.nasdanika.graph.model.DocumentedNamedSubGraph;

public interface DocumentedNamedSubGraphNodeProcessorMixIn<T extends DocumentedNamedSubGraph<?>> extends DocumentedNamedGraphElementNodeProcessorMixIn<T>, SubGraphNodeProcessorMixIn<T> {
	
} 
