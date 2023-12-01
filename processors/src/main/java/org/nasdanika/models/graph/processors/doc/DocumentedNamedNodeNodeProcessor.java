package org.nasdanika.models.graph.processors.doc;

import org.nasdanika.common.Context;
import org.nasdanika.common.ProgressMonitor;
import org.nasdanika.graph.model.Connection;
import org.nasdanika.graph.model.DocumentedNamedNode;
import org.nasdanika.graph.processor.NodeProcessorConfig;
import org.nasdanika.html.model.app.Action;
import org.nasdanika.html.model.app.graph.WidgetFactory;

public class DocumentedNamedNodeNodeProcessor<T extends DocumentedNamedNode<?>> extends NodeNodeProcessor<T> implements DocumentedNamedNodeNodeProcessorMixIn<Connection<?>> {

	public DocumentedNamedNodeNodeProcessor(
		NodeProcessorConfig<WidgetFactory, WidgetFactory> config, 
		Context context,
		java.util.function.Function<ProgressMonitor, Action> prototypeProvider) {
		super(config, context, prototypeProvider);
	}
	
	// DocumentedNamedConnectionSource - outgoingConnections, documented named string identity - handled by EObjectNodeProcessor?
	// DocumentedNamedConnectionTarget - incomingConnections

}
