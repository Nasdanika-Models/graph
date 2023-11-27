package org.nasdanika.models.graph.processors.doc;

import java.util.Collection;
import java.util.Map;

import org.eclipse.emf.ecore.EReference;
import org.nasdanika.common.Context;
import org.nasdanika.common.ProgressMonitor;
import org.nasdanika.graph.emf.EReferenceConnection;
import org.nasdanika.graph.model.Connection;
import org.nasdanika.graph.processor.NodeProcessorConfig;
import org.nasdanika.html.model.app.Action;
import org.nasdanika.html.model.app.Label;
import org.nasdanika.html.model.app.graph.WidgetFactory;
import org.nasdanika.html.model.app.graph.emf.EObjectNodeProcessor;

public class ConnectionNodeProcessor<T extends Connection<?>> extends EObjectNodeProcessor<T> {

	public ConnectionNodeProcessor(
		NodeProcessorConfig<WidgetFactory, WidgetFactory> config, 
		Context context,
		java.util.function.Function<ProgressMonitor, Action> prototypeProvider) {
		super(config, context, prototypeProvider);
	}

	/**
	 * Suppressing default behavior, explicit specification of how to build.
	 */	
	@Override
	protected void addReferenceChildren(
			EReference eReference, 
			Collection<Label> labels, 
			Map<EReferenceConnection, Collection<Label>> outgoingLabels, 
			ProgressMonitor progressMonitor) {
	}


}
