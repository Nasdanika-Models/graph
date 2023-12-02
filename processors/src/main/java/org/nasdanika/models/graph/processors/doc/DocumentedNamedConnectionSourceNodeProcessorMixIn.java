/**
 */
package org.nasdanika.models.graph.processors.doc;

import org.nasdanika.graph.model.DocumentedNamedConnectionSource;

public interface DocumentedNamedConnectionSourceNodeProcessorMixIn<T extends DocumentedNamedConnectionSource<?>> extends DocumentedNamedGraphElementNodeProcessorMixIn<T>, ConnectionSourceNodeProcessorMixIn<T> {
	
} 
