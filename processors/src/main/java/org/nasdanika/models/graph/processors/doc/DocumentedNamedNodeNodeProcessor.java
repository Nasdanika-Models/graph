package org.nasdanika.models.graph.processors.doc;

import org.eclipse.emf.ecore.EObject;
import org.nasdanika.common.Context;
import org.nasdanika.common.ProgressMonitor;
import org.nasdanika.graph.model.DocumentedNamedNode;
import org.nasdanika.graph.processor.NodeProcessorConfig;
import org.nasdanika.models.app.Action;
import org.nasdanika.models.app.graph.WidgetFactory;

public class DocumentedNamedNodeNodeProcessor<T extends DocumentedNamedNode<?>> extends NodeNodeProcessor<T> implements DocumentedNamedNodeNodeProcessorMixIn<T> {

	public DocumentedNamedNodeNodeProcessor(
		NodeProcessorConfig<WidgetFactory, WidgetFactory, Object> config, 
		Context context,
		java.util.function.BiFunction<EObject, ProgressMonitor, Action> prototypeProvider) {
		super(config, context, prototypeProvider);
	}
	
	// DocumentedNamedConnectionSource - outgoingConnections, documented named string identity - handled by EObjectNodeProcessor?
	// DocumentedNamedConnectionTarget - incomingConnections

}
