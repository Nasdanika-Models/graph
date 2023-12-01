package org.nasdanika.models.graph.processors.doc;

import org.nasdanika.common.Context;
import org.nasdanika.common.ProgressMonitor;
import org.nasdanika.graph.model.Connection;
import org.nasdanika.graph.model.DocumentedNamedConnectionTarget;
import org.nasdanika.graph.processor.NodeProcessorConfig;
import org.nasdanika.html.model.app.Action;
import org.nasdanika.html.model.app.graph.WidgetFactory;

public class DocumentedNamedConnectionTargetNodeProcessor<T extends DocumentedNamedConnectionTarget<?>> extends ConnectionTargetNodeProcessor<T> implements DocumentedNamedConnectionTargetNodeProcessorMixIn<Connection<?>> {

	public DocumentedNamedConnectionTargetNodeProcessor(
		NodeProcessorConfig<WidgetFactory, WidgetFactory> config, 
		Context context,
		java.util.function.Function<ProgressMonitor, Action> prototypeProvider) {
		super(config, context, prototypeProvider);
	}

	// DocumentedNamedGraphElement - from EObjectNodeProcessor?
	
}
