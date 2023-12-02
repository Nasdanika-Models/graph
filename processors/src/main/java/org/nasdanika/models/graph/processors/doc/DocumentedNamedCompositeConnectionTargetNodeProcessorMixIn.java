/**
 */
package org.nasdanika.models.graph.processors.doc;

import org.nasdanika.graph.model.DocumentedNamedCompositeConnectionTarget;

public interface DocumentedNamedCompositeConnectionTargetNodeProcessorMixIn<T extends DocumentedNamedCompositeConnectionTarget<?,?>> extends DocumentedNamedSubGraphNodeProcessorMixIn<T>, DocumentedNamedConnectionTargetNodeProcessorMixIn<T> {
	
} 
