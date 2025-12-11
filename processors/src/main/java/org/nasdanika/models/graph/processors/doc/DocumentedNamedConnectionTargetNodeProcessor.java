package org.nasdanika.models.graph.processors.doc;

import org.eclipse.emf.ecore.EObject;
import org.nasdanika.common.Context;
import org.nasdanika.common.ProgressMonitor;
import org.nasdanika.graph.model.DocumentedNamedConnectionTarget;
import org.nasdanika.graph.processor.NodeProcessorConfig;
import org.nasdanika.models.app.Action;
import org.nasdanika.models.app.graph.WidgetFactory;

public class DocumentedNamedConnectionTargetNodeProcessor<T extends DocumentedNamedConnectionTarget<?>> extends ConnectionTargetNodeProcessor<T> implements DocumentedNamedConnectionTargetNodeProcessorMixIn<T> {

	public DocumentedNamedConnectionTargetNodeProcessor(
		NodeProcessorConfig<WidgetFactory, WidgetFactory, Object> config, 
		Context context,
		java.util.function.BiFunction<EObject, ProgressMonitor, Action> prototypeProvider) {
		super(config, context, prototypeProvider);
	}

	// DocumentedNamedGraphElement - from EObjectNodeProcessor?
	
}
