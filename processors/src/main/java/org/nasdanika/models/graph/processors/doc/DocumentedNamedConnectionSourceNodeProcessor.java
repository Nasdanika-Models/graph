package org.nasdanika.models.graph.processors.doc;

import org.nasdanika.common.Context;
import org.nasdanika.common.ProgressMonitor;
import org.nasdanika.graph.model.DocumentedNamedConnectionSource;
import org.nasdanika.graph.processor.NodeProcessorConfig;
import org.nasdanika.models.app.Action;
import org.nasdanika.models.app.graph.WidgetFactory;

public class DocumentedNamedConnectionSourceNodeProcessor<T extends DocumentedNamedConnectionSource<?>> extends DocumentedNamedGraphElementNodeProcessor<T> implements DocumentedNamedConnectionSourceNodeProcessorMixIn<T> {

	public DocumentedNamedConnectionSourceNodeProcessor(
		NodeProcessorConfig<WidgetFactory, WidgetFactory> config, 
		Context context,
		java.util.function.Function<ProgressMonitor, Action> prototypeProvider) {
		super(config, context, prototypeProvider);
	}
	
	// ConnectionSource.outgoingConnections

}
