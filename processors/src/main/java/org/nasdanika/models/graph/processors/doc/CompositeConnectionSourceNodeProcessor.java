package org.nasdanika.models.graph.processors.doc;

import org.nasdanika.common.Context;
import org.nasdanika.common.ProgressMonitor;
import org.nasdanika.graph.model.CompositeConnectionSource;
import org.nasdanika.graph.processor.NodeProcessorConfig;
import org.nasdanika.models.app.Action;
import org.nasdanika.models.app.graph.WidgetFactory;

public class CompositeConnectionSourceNodeProcessor<T extends CompositeConnectionSource<?,?>> extends SubGraphNodeProcessor<T> implements CompositeConnectionSourceNodeProcessorMixIn<T> {

	public CompositeConnectionSourceNodeProcessor(
		NodeProcessorConfig<WidgetFactory, WidgetFactory> config, 
		Context context,
		java.util.function.Function<ProgressMonitor, Action> prototypeProvider) {
		super(config, context, prototypeProvider);
	}
	
	// ConnectionSource.outgoingConnections

}
