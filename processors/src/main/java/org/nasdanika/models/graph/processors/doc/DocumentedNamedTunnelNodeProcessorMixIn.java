/**
 */
package org.nasdanika.models.graph.processors.doc;

import org.nasdanika.graph.model.Connection;
import org.nasdanika.graph.model.ConnectionTarget;

public interface DocumentedNamedTunnelNodeProcessorMixIn<T extends ConnectionTarget<?>, C extends Connection<?>> extends TunnelNodeProcessorMixIn<T, C>, DocumentedNamedConnectionNodeProcessorMixIn<T> {

} 
