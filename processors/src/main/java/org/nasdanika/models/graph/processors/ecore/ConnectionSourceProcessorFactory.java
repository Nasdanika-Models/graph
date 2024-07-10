package org.nasdanika.models.graph.processors.ecore;

import java.util.function.BiConsumer;

import org.nasdanika.common.Context;
import org.nasdanika.common.ProgressMonitor;
import org.nasdanika.graph.processor.NodeProcessorConfig;
import org.nasdanika.html.model.app.Action;
import org.nasdanika.html.model.app.Label;
import org.nasdanika.html.model.app.graph.WidgetFactory;
import org.nasdanika.models.ecore.graph.processors.EAttributeNodeProcessor;
import org.nasdanika.models.ecore.graph.processors.EClassNodeProcessor;
import org.nasdanika.models.ecore.graph.processors.EClassifierNodeProcessorFactory;
import org.nasdanika.models.ecore.graph.processors.EStructuralFeatureNodeProcessorFactory;

@EClassifierNodeProcessorFactory(classifierID = org.nasdanika.graph.model.ModelPackage.CONNECTION_SOURCE)
public class ConnectionSourceProcessorFactory {

	private Context context;

	public ConnectionSourceProcessorFactory(Context context) {
		this.context = context;
	}
	
	@EClassifierNodeProcessorFactory(
			// label = "...",
			description = "Source of connections uniquely identified by string ids",
			documentation = """
					Source of connections uniquely identified by string ids. 
					It provides support for graph inheritance - replacing (overriding), adding, or removing connections.
					"""
//			icon = "..."
	)
	public EClassNodeProcessor createEClassNodeProcessor(
			NodeProcessorConfig<WidgetFactory, WidgetFactory> config, 
			java.util.function.Function<ProgressMonitor, Action> prototypeProvider,
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
			classID = org.nasdanika.graph.model.ModelPackage.CONNECTION_SOURCE,
			featureID = org.nasdanika.graph.model.ModelPackage.CONNECTION_SOURCE__OUTGOING_CONNECTIONS,
			description = "Outgoing connections uniquely identified by a string to support graph inheritance",
			documentation = """
					Outgoing connections uniquely identified by a string to support graph inheritance
					"""
	)
	public EAttributeNodeProcessor createOutgoingConnectionsProcessor(
			NodeProcessorConfig<WidgetFactory, WidgetFactory> config, 
			java.util.function.Function<ProgressMonitor, Action> prototypeProvider,
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
