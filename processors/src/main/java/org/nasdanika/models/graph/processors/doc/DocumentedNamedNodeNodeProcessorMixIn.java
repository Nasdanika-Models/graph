/**
 */
package org.nasdanika.models.graph.processors.doc;

import org.nasdanika.graph.model.Connection;

public interface DocumentedNamedNodeNodeProcessorMixIn<C extends Connection<?>> extends NodeNodeProcessorMixIn<C>, DocumentedNamedConnectionSourceNodeProcessorMixIn<C>, DocumentedNamedConnectionTargetNodeProcessorMixIn<C> {
	
} 
