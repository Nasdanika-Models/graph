package org.nasdanika.models.graph.processors.doc;

import org.nasdanika.common.Context;
import org.nasdanika.common.ProgressMonitor;
import org.nasdanika.graph.model.DocumentedNamedCompositeNode;
import org.nasdanika.graph.processor.NodeProcessorConfig;
import org.nasdanika.html.model.app.Action;
import org.nasdanika.html.model.app.graph.WidgetFactory;

public class DocumentedNamedCompositeNodeNodeProcessor<T extends DocumentedNamedCompositeNode<?,?>> extends CompositeNodeNodeProcessor<T> {

	public DocumentedNamedCompositeNodeNodeProcessor(
		NodeProcessorConfig<WidgetFactory, WidgetFactory> config, 
		Context context,
		java.util.function.Function<ProgressMonitor, Action> prototypeProvider) {
		super(config, context, prototypeProvider);
	}
	
	// DocumentedNamedNode - handled by EObjectNodeProcessor?

}
