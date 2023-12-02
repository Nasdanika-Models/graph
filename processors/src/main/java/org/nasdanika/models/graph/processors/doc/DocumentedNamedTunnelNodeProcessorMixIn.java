/**
 */
package org.nasdanika.models.graph.processors.doc;

import org.nasdanika.graph.model.DocumentedNamedTunnel;

public interface DocumentedNamedTunnelNodeProcessorMixIn<T extends DocumentedNamedTunnel<?,?>> extends TunnelNodeProcessorMixIn<T>, DocumentedNamedConnectionNodeProcessorMixIn<T> {

} 
