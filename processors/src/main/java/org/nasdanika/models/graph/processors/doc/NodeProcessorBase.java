package org.nasdanika.models.graph.processors.doc;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.nasdanika.common.Context;
import org.nasdanika.common.ProgressMonitor;
import org.nasdanika.graph.emf.EReferenceConnection;
import org.nasdanika.graph.model.ModelPackage;
import org.nasdanika.graph.processor.NodeProcessorConfig;
import org.nasdanika.html.model.app.Action;
import org.nasdanika.html.model.app.Label;
import org.nasdanika.html.model.app.graph.WidgetFactory;
import org.nasdanika.html.model.app.graph.emf.EObjectNodeProcessor;
import org.nasdanika.html.model.app.graph.emf.OutgoingReferenceBuilder;

/**
 * Base class with common functionality
 * @param <T>
 */
public class NodeProcessorBase<T extends EObject> extends EObjectNodeProcessor<T> {
	
	public NodeProcessorBase(
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
		
	@OutgoingReferenceBuilder(
			nsURI = ModelPackage.eNS_URI,
			classID = ModelPackage.GRAPH,
			referenceID = ModelPackage.GRAPH__ELEMENTS)
	public void buildElementsOutgoingReference(
			EReference eReference,
			List<Entry<EReferenceConnection, WidgetFactory>> referenceOutgoingEndpoints, 
			Collection<Label> labels,
			Map<EReferenceConnection, Collection<Label>> outgoingLabels, 
			ProgressMonitor progressMonitor) {
		
		for (Label tLabel: labels) {
			for (Collection<Label> re: outgoingLabels.values()) { 
				tLabel.getChildren().addAll(re);
			}
		}		
	}

}
