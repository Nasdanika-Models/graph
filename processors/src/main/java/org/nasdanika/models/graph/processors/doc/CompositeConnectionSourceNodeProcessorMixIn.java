/**
 */
package org.nasdanika.models.graph.processors.doc;

import org.nasdanika.graph.model.CompositeConnectionSource;

public interface CompositeConnectionSourceNodeProcessorMixIn<T extends CompositeConnectionSource<?,?>> extends SubGraphNodeProcessorMixIn<T>, ConnectionSourceNodeProcessorMixIn<T> {
	
} 
