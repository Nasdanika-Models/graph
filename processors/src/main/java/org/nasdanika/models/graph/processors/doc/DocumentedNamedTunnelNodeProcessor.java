package org.nasdanika.models.graph.processors.doc;

import org.nasdanika.common.Context;
import org.nasdanika.common.ProgressMonitor;
import org.nasdanika.graph.model.DocumentedNamedTunnel;
import org.nasdanika.graph.processor.NodeProcessorConfig;
import org.nasdanika.models.app.Action;
import org.nasdanika.models.app.graph.WidgetFactory;

public class DocumentedNamedTunnelNodeProcessor<T extends DocumentedNamedTunnel<?,?>> extends TunnelNodeProcessor<T> implements DocumentedNamedTunnelNodeProcessorMixIn<T> {

	public DocumentedNamedTunnelNodeProcessor(
		NodeProcessorConfig<WidgetFactory, WidgetFactory> config, 
		Context context,
		java.util.function.Function<ProgressMonitor, Action> prototypeProvider) {
		super(config, context, prototypeProvider);
	}
	
	// DocumentedNamedConnection - documented named string identity - handled by the EObjectNodeProcessor

}
