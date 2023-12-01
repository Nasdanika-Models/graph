/**
 */
package org.nasdanika.models.graph.processors.doc;

import org.nasdanika.graph.model.Connection;

public interface DocumentedNamedConnectionTargetNodeProcessorMixIn<C extends Connection<?>> extends ConnectionTargetNodeProcessorMixIn<C>, DocumentedNamedGraphElementNodeProcessorMixIn {
	
} 
