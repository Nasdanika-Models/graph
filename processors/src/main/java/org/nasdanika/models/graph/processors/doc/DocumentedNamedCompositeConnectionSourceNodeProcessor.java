package org.nasdanika.models.graph.processors.doc;

import org.eclipse.emf.ecore.EObject;
import org.nasdanika.common.Context;
import org.nasdanika.common.ProgressMonitor;
import org.nasdanika.graph.model.DocumentedNamedCompositeConnectionSource;
import org.nasdanika.graph.processor.NodeProcessorConfig;
import org.nasdanika.models.app.Action;
import org.nasdanika.models.app.graph.WidgetFactory;

public class DocumentedNamedCompositeConnectionSourceNodeProcessor<T extends DocumentedNamedCompositeConnectionSource<?,?>> extends DocumentedNamedSubGraphNodeProcessor<T> implements DocumentedNamedCompositeConnectionSourceNodeProcessorMixIn<T> {

	public DocumentedNamedCompositeConnectionSourceNodeProcessor(
		NodeProcessorConfig<WidgetFactory, WidgetFactory> config, 
		Context context,
		java.util.function.BiFunction<EObject, ProgressMonitor, Action> prototypeProvider) {
		super(config, context, prototypeProvider);
	}
	
	// CompositeConnectionSource - outgoingConnections?

}
