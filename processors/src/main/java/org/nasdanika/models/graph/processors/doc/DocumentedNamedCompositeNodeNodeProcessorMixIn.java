/**
 */
package org.nasdanika.models.graph.processors.doc;

import org.nasdanika.graph.model.DocumentedNamedCompositeNode;

public interface DocumentedNamedCompositeNodeNodeProcessorMixIn<T extends DocumentedNamedCompositeNode<?, ?>> extends CompositeNodeNodeProcessorMixIn<T>, DocumentedNamedNodeNodeProcessorMixIn<T> {
	
} 
