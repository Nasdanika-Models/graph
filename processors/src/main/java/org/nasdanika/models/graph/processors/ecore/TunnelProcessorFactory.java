/**
 */
package org.nasdanika.models.graph.processors.ecore;

import java.util.function.BiConsumer;

import org.eclipse.emf.ecore.EObject;
import org.nasdanika.common.Context;
import org.nasdanika.common.ProgressMonitor;
import org.nasdanika.graph.processor.NodeProcessorConfig;
import org.nasdanika.models.app.Action;
import org.nasdanika.models.app.Label;
import org.nasdanika.models.app.graph.WidgetFactory;
import org.nasdanika.models.ecore.graph.processors.EAttributeNodeProcessor;
import org.nasdanika.models.ecore.graph.processors.EClassNodeProcessor;
import org.nasdanika.models.ecore.graph.processors.EClassifierNodeProcessorFactory;
import org.nasdanika.models.ecore.graph.processors.EStructuralFeatureNodeProcessorFactory;

@EClassifierNodeProcessorFactory(classifierID = org.nasdanika.graph.model.ModelPackage.TUNNEL)
public class TunnelProcessorFactory {

	private Context context;

	public TunnelProcessorFactory(Context context) {
		this.context = context;
	}
	
	@EClassifierNodeProcessorFactory(
			// label = "...",
			description = "A connection which logically groups other connections",
			documentation = """
					Tunnel is a connection which logically groups (aggregates) other connections. 
					For example, two composite nodes may have a tunnel connection which groups connections between their child elements. 
					A real life example is a VPN tunnel between two networks.
					"""
//			icon = "..."
	)
	public EClassNodeProcessor createEClassNodeProcessor(
			NodeProcessorConfig<WidgetFactory, WidgetFactory, Object> config, 
			java.util.function.BiFunction<EObject, ProgressMonitor, Action> prototypeProvider,
			BiConsumer<Label, ProgressMonitor> labelConfigurator,
			ProgressMonitor progressMonitor) {		
		return new EClassNodeProcessor(config, context, prototypeProvider) {
			
			@Override
			public void configureLabel(Object source, Label label, ProgressMonitor progressMonitor) {
				super.configureLabel(source, label, progressMonitor);
				if (labelConfigurator != null) {
					labelConfigurator.accept(label, progressMonitor);
				}
			}
						
		};
	}	
	
	@EStructuralFeatureNodeProcessorFactory(
			nsURI = org.nasdanika.graph.model.ModelPackage.eNS_URI,
			classID = org.nasdanika.graph.model.ModelPackage.TUNNEL,
			featureID = org.nasdanika.graph.model.ModelPackage.TUNNEL__CONNECTIONS,
			description = "Connections in this tunnel",
			documentation = """
					Connections in this tunnel
					"""
	)
	public EAttributeNodeProcessor createConnectionsProcessor(
			NodeProcessorConfig<WidgetFactory, WidgetFactory, Object> config, 
			java.util.function.BiFunction<EObject, ProgressMonitor, Action> prototypeProvider,
			BiConsumer<Label, ProgressMonitor> labelConfigurator,
			ProgressMonitor progressMonitor) {		
		return new EAttributeNodeProcessor(config, context, prototypeProvider) {
			
			@Override
			public void configureLabel(Object source, Label label, ProgressMonitor progressMonitor) {
				super.configureLabel(source, label, progressMonitor);
				if (labelConfigurator != null) {
					labelConfigurator.accept(label, progressMonitor);
				}
			}
			
		};
	}	
	
} 
