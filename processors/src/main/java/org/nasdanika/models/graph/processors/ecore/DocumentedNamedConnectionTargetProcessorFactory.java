package org.nasdanika.models.graph.processors.ecore;

import java.util.function.BiConsumer;

import org.eclipse.emf.ecore.EObject;
import org.nasdanika.common.Context;
import org.nasdanika.common.ProgressMonitor;
import org.nasdanika.graph.processor.NodeProcessorConfig;
import org.nasdanika.models.app.Action;
import org.nasdanika.models.app.Label;
import org.nasdanika.models.app.graph.WidgetFactory;
import org.nasdanika.models.ecore.graph.processors.EClassNodeProcessor;
import org.nasdanika.models.ecore.graph.processors.EClassifierNodeProcessorFactory;

@EClassifierNodeProcessorFactory(classifierID = org.nasdanika.graph.model.ModelPackage.DOCUMENTED_NAMED_CONNECTION_TARGET)
public class DocumentedNamedConnectionTargetProcessorFactory {

	private Context context;

	public DocumentedNamedConnectionTargetProcessorFactory(Context context) {
		this.context = context;
	}
	
	@EClassifierNodeProcessorFactory(
			label = "Documented Named Connection Target",
			description = "Connection target with a name and documentation",
			documentation = """
					[Connection target](../ConnectionTarget/index.html) with a name and documentation
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
	
} 
