/**
 */
package org.nasdanika.models.graph.processors.doc;

import org.nasdanika.graph.model.Connection;

public interface NodeNodeProcessorMixIn<C extends Connection<?>> extends ConnectionSourceNodeProcessorMixIn<C>, ConnectionTargetNodeProcessorMixIn<C> {
	
} 
