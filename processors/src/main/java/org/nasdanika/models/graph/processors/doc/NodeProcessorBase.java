package org.nasdanika.models.graph.processors.doc;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.nasdanika.common.Context;
import org.nasdanika.common.ProgressMonitor;
import org.nasdanika.common.Util;
import org.nasdanika.graph.emf.EReferenceConnection;
import org.nasdanika.graph.model.ModelPackage;
import org.nasdanika.graph.processor.NodeProcessorConfig;
import org.nasdanika.html.model.app.Action;
import org.nasdanika.html.model.app.Label;
import org.nasdanika.html.model.app.graph.WidgetFactory;
import org.nasdanika.html.model.app.graph.emf.EObjectNodeProcessor;
import org.nasdanika.html.model.app.graph.emf.OutgoingReferenceBuilder;
import org.nasdanika.ncore.NamedElement;

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
			value=ModelPackage.GRAPH__ELEMENTS,
			classID = ModelPackage.GRAPH,
			nsURI = ModelPackage.eNS_URI)
	public void buildElementsOutgoingReference(
			EReference eReference,
			List<Entry<EReferenceConnection, WidgetFactory>> referenceOutgoingEndpoints, 
			Collection<Label> labels,
			Map<EReferenceConnection, Collection<Label>> outgoingLabels, 
			ProgressMonitor progressMonitor) {

		List<Entry<EReferenceConnection, Collection<Label>>> sorted = outgoingLabels.entrySet().stream()
				.sorted(this::compareElements)
				.toList();		
				
		for (Label tLabel: labels) {
			for (Entry<EReferenceConnection, Collection<Label>> re: sorted) { 
				tLabel.getChildren().addAll(re.getValue());
			}
		}
	}

	protected int compareElements(Entry<EReferenceConnection, Collection<Label>> a, Entry<EReferenceConnection, Collection<Label>> b) {
		EObject aObj = a.getKey().getTarget().get();
		EObject bObj = b.getKey().getTarget().get();
		
		if (aObj instanceof NamedElement) {
			String aName = ((NamedElement) aObj).getName();
			if (!Util.isBlank(aName)) {
				if (bObj instanceof NamedElement) {
					String bName = ((NamedElement) bObj).getName();
					if (!Util.isBlank(bName)) {
						return aName.compareTo(bName);
					}
				}
				return -1;
			}
		} 
		
		if (bObj instanceof NamedElement) {
			return 1;
		}
		
		return aObj.hashCode() - bObj.hashCode();
	}	

}
