package org.nasdanika.models.graph.processors.doc;

import org.nasdanika.common.Context;
import org.nasdanika.common.ProgressMonitor;
import org.nasdanika.graph.model.ConnectionTarget;
import org.nasdanika.graph.model.DocumentedNamedConnection;
import org.nasdanika.graph.processor.NodeProcessorConfig;
import org.nasdanika.html.model.app.Action;
import org.nasdanika.html.model.app.graph.WidgetFactory;

public class DocumentedNamedConnectionNodeProcessor<T extends DocumentedNamedConnection<?>> extends ConnectionNodeProcessor<T> implements DocumentedNamedConnectionNodeProcessorMixIn<ConnectionTarget<?>> {

	public DocumentedNamedConnectionNodeProcessor(
		NodeProcessorConfig<WidgetFactory, WidgetFactory> config, 
		Context context,
		java.util.function.Function<ProgressMonitor, Action> prototypeProvider) {
		super(config, context, prototypeProvider);
	}
	
	// DocumentedNamedStringIdentity - handled by EObjectNodeProcessor?

}
