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

@EClassifierNodeProcessorFactory(classifierID = org.nasdanika.graph.model.ModelPackage.CONNECTION)
public class ConnectionProcessorFactory {

	private Context context;

	public ConnectionProcessorFactory(Context context) {
		this.context = context;
	}
	
	@EClassifierNodeProcessorFactory(
			// label = "...",
			description = "Connections are contained by their source and uniquiely identified in the source by a string id",
			documentation = """
					Connections are contained by their source and uniquiely identified in the source by a string id. 
					This allows to implement connection inheritance behaviors such as overriding (replacing), adding, or removing.
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
			classID = org.nasdanika.graph.model.ModelPackage.CONNECTION,
			featureID = org.nasdanika.graph.model.ModelPackage.CONNECTION__TARGET,
			description = "Connection target",
			documentation = """
					Connection target
					"""
	)
	public EAttributeNodeProcessor createTargetProcessor(
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

	@EStructuralFeatureNodeProcessorFactory(
			nsURI = org.nasdanika.graph.model.ModelPackage.eNS_URI,
			classID = org.nasdanika.graph.model.ModelPackage.CONNECTION,
			featureID = org.nasdanika.graph.model.ModelPackage.CONNECTION__BIDIRECTIONAL,
			description = "Indicates that the connection is bidirectional",
			documentation = """
					Indicates that the connection is bidirectional
					"""
	)
	public EAttributeNodeProcessor createBidirectionalProcessor(
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
