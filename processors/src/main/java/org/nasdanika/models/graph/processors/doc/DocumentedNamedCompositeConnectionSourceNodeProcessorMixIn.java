/**
 */
package org.nasdanika.models.graph.processors.doc;

import org.nasdanika.graph.model.DocumentedNamedCompositeConnectionSource;

public interface DocumentedNamedCompositeConnectionSourceNodeProcessorMixIn<T extends DocumentedNamedCompositeConnectionSource<?,?>> extends DocumentedNamedSubGraphNodeProcessorMixIn<T>, CompositeConnectionSourceNodeProcessorMixIn<T> {
	
} 
