/**
 */
package org.nasdanika.models.graph.processors.doc;

import org.nasdanika.graph.model.DocumentedNamedConnectionTarget;

public interface DocumentedNamedConnectionTargetNodeProcessorMixIn<Т extends DocumentedNamedConnectionTarget<?>> extends ConnectionTargetNodeProcessorMixIn<Т>, DocumentedNamedGraphElementNodeProcessorMixIn<Т> {
	
} 
