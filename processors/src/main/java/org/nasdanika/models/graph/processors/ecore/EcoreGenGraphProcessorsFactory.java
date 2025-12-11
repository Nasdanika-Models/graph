package org.nasdanika.models.graph.processors.ecore;

import java.util.function.BiConsumer;

import org.eclipse.emf.ecore.EObject;
import org.nasdanika.common.Context;
import org.nasdanika.common.ProgressMonitor;
import org.nasdanika.common.Reflector.Factory;
import org.nasdanika.graph.processor.NodeProcessorConfig;
import org.nasdanika.models.app.Action;
import org.nasdanika.models.app.Label;
import org.nasdanika.models.app.graph.WidgetFactory;
import org.nasdanika.models.ecore.graph.processors.EPackageNodeProcessor;
import org.nasdanika.models.ecore.graph.processors.EPackageNodeProcessorFactory;

@EPackageNodeProcessorFactory(nsURI = org.nasdanika.graph.model.ModelPackage.eNS_URI)
public class EcoreGenGraphProcessorsFactory {

	private Context context;
	
	@Factory
	public final CompositeConnectionSourceProcessorFactory compositeConnectionSourceProcessorFactory;
	
	@Factory
	public final CompositeConnectionTargetProcessorFactory compositeConnectionTargetProcessorFactory;
	
	@Factory
	public final CompositeNodeProcessorFactory compositeNodeProcessorFactory;
	
	@Factory
	public final ConnectionProcessorFactory connectionProcessorFactory;
	
	@Factory
	public final ConnectionSourceProcessorFactory connectionSourceProcessorFactory;
	
	@Factory
	public final ConnectionTargetProcessorFactory connectionTargetProcessorFactory;
	
	@Factory
	public final DocumentedNamedCompositeConnectionSourceProcessorFactory documentedNamedCompositeConnectionSourceProcessorFactory;
	
	@Factory
	public final DocumentedNamedCompositeConnectionTargetProcessorFactory documentedNamedCompositeConnectionTargetProcessorFactory;
	
	@Factory
	public final DocumentedNamedCompositeNodeProcessorFactory documentedNamedCompositeNodeProcessorFactory;
	
	@Factory
	public final DocumentedNamedConnectionProcessorFactory documentedNamedConnectionProcessorFactory;
	
	@Factory
	public final DocumentedNamedConnectionSourceProcessorFactory documentedNamedConnectionSourceProcessorFactory;
	
	@Factory
	public final DocumentedNamedConnectionTargetProcessorFactory documentedNamedConnectionTargetProcessorFactory;
	
	@Factory
	public final DocumentedNamedGraphProcessorFactory documentedNamedGraphProcessorFactory;
	
	@Factory
	public final DocumentedNamedGraphElementProcessorFactory documentedNamedGraphElementProcessorFactory;
	
	@Factory
	public final DocumentedNamedNodeProcessorFactory documentedNamedNodeProcessorFactory;
	
	@Factory
	public final DocumentedNamedSubGraphProcessorFactory documentedNamedSubGraphProcessorFactory;
	
	@Factory
	public final DocumentedNamedTunnelProcessorFactory documentedNamedTunnelProcessorFactory;
	
	@Factory
	public final GraphProcessorFactory graphProcessorFactory;
	
	@Factory
	public final GraphElementProcessorFactory graphElementProcessorFactory;
	
	@Factory
	public final NodeProcessorFactory nodeProcessorProcessorFactory;
	
	@Factory
	public final SubGraphProcessorFactory subGraphProcessorFactory;
	
	@Factory
	public final TunnelProcessorFactory tunnelProcessorFactory;	
	
	public EcoreGenGraphProcessorsFactory(Context context) {
		this.context = context;
		
		compositeConnectionSourceProcessorFactory = new CompositeConnectionSourceProcessorFactory(context);
		compositeConnectionTargetProcessorFactory = new CompositeConnectionTargetProcessorFactory(context);
		compositeNodeProcessorFactory = new CompositeNodeProcessorFactory(context);
		connectionProcessorFactory = new ConnectionProcessorFactory(context);
		connectionSourceProcessorFactory = new ConnectionSourceProcessorFactory(context);
		connectionTargetProcessorFactory = new ConnectionTargetProcessorFactory(context);
		documentedNamedCompositeConnectionSourceProcessorFactory = new DocumentedNamedCompositeConnectionSourceProcessorFactory(context);
		documentedNamedCompositeConnectionTargetProcessorFactory = new DocumentedNamedCompositeConnectionTargetProcessorFactory(context);
		documentedNamedCompositeNodeProcessorFactory = new DocumentedNamedCompositeNodeProcessorFactory(context);
		documentedNamedConnectionProcessorFactory = new DocumentedNamedConnectionProcessorFactory(context);
		documentedNamedConnectionSourceProcessorFactory = new DocumentedNamedConnectionSourceProcessorFactory(context);
		documentedNamedConnectionTargetProcessorFactory = new DocumentedNamedConnectionTargetProcessorFactory(context);
		documentedNamedGraphProcessorFactory = new DocumentedNamedGraphProcessorFactory(context);
		documentedNamedGraphElementProcessorFactory = new DocumentedNamedGraphElementProcessorFactory(context);
		documentedNamedNodeProcessorFactory = new DocumentedNamedNodeProcessorFactory(context);
		documentedNamedSubGraphProcessorFactory = new DocumentedNamedSubGraphProcessorFactory(context);
		documentedNamedTunnelProcessorFactory = new DocumentedNamedTunnelProcessorFactory(context);
		graphProcessorFactory = new GraphProcessorFactory(context);
		graphElementProcessorFactory = new GraphElementProcessorFactory(context);
		nodeProcessorProcessorFactory = new NodeProcessorFactory(context);
		subGraphProcessorFactory = new SubGraphProcessorFactory(context);
		tunnelProcessorFactory = new TunnelProcessorFactory(context);	
	}
	
	@EPackageNodeProcessorFactory(
			label = "Graph Model",
			description = "Base classes for graph-like models",
			actionPrototype = """
            app-action:
              content:
                content-markdown:
                  source:
                    content-resource:
                      location: graph.md
			"""
	)
	public EPackageNodeProcessor createEPackageProcessor(
			NodeProcessorConfig<WidgetFactory, WidgetFactory, Object> config, 
			java.util.function.BiFunction<EObject, ProgressMonitor, Action> prototypeProvider,
			BiConsumer<Label, ProgressMonitor> labelConfigurator,
			ProgressMonitor progressMonitor) {		
		return new EPackageNodeProcessor(config, context, prototypeProvider) {
			
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
