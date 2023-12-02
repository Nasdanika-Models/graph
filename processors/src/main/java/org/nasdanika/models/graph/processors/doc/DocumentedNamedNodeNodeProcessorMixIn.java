/**
 */
package org.nasdanika.models.graph.processors.doc;

import org.nasdanika.graph.model.DocumentedNamedNode;

public interface DocumentedNamedNodeNodeProcessorMixIn<T extends DocumentedNamedNode<?>> extends NodeNodeProcessorMixIn<T>, DocumentedNamedConnectionSourceNodeProcessorMixIn<T>, DocumentedNamedConnectionTargetNodeProcessorMixIn<T> {
	
} 
