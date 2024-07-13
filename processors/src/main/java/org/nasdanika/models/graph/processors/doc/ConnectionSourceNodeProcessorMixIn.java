/**
 */
package org.nasdanika.models.graph.processors.doc;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EReference;
import org.nasdanika.common.ProgressMonitor;
import org.nasdanika.graph.emf.EReferenceConnection;
import org.nasdanika.graph.model.ConnectionSource;
import org.nasdanika.graph.model.ModelPackage;
import org.nasdanika.html.model.app.Action;
import org.nasdanika.html.model.app.Label;
import org.nasdanika.html.model.app.graph.WidgetFactory;
import org.nasdanika.html.model.app.graph.emf.OutgoingReferenceBuilder;

public interface ConnectionSourceNodeProcessorMixIn<T extends ConnectionSource<?>> extends GraphElementNodeProcessorMixIn<T> {
	
	@OutgoingReferenceBuilder(
			nsURI = ModelPackage.eNS_URI,
			classID = ModelPackage.CONNECTION_SOURCE,
			referenceID = ModelPackage.CONNECTION_SOURCE__OUTGOING_CONNECTIONS)
	default void buildOutgoingConnectionsOutgoingReference(
			EReference eReference,
			List<Entry<EReferenceConnection, WidgetFactory>> referenceOutgoingEndpoints, 
			Collection<Label> labels,
			Map<EReferenceConnection, Collection<Label>> outgoingLabels, 
			ProgressMonitor progressMonitor) {
		
		for (Label tLabel: labels) {
			if (tLabel instanceof Action) {
				EList<Action> tLabelAnonymous = ((Action) tLabel).getAnonymous();
				outgoingLabels
					.values()
					.stream()
					.flatMap(Collection::stream)
					.filter(Action.class::isInstance)
					.map(Action.class::cast)
					.forEach(tLabelAnonymous::add);
			}
		}		
	}	

} 
