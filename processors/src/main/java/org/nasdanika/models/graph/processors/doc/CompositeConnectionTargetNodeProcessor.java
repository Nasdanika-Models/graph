package org.nasdanika.models.graph.processors.doc;

import org.nasdanika.common.Context;
import org.nasdanika.common.ProgressMonitor;
import org.nasdanika.graph.model.CompositeConnectionTarget;
import org.nasdanika.graph.model.Connection;
import org.nasdanika.graph.model.GraphElement;
import org.nasdanika.graph.processor.NodeProcessorConfig;
import org.nasdanika.html.model.app.Action;
import org.nasdanika.html.model.app.graph.WidgetFactory;

public class CompositeConnectionTargetNodeProcessor<T extends CompositeConnectionTarget<?,?>> extends SubGraphNodeProcessor<T> implements CompositeConnectionTargetNodeProcessorMixIn<GraphElement, Connection<?>> {

	public CompositeConnectionTargetNodeProcessor(
		NodeProcessorConfig<WidgetFactory, WidgetFactory> config, 
		Context context,
		java.util.function.Function<ProgressMonitor, Action> prototypeProvider) {
		super(config, context, prototypeProvider);
	}

	// ConnectionTarget.incomingConnections
	
}
