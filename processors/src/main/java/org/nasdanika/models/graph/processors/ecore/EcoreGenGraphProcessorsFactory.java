package org.nasdanika.models.graph.processors.ecore;

import java.util.function.BiConsumer;

import org.nasdanika.common.Context;
import org.nasdanika.common.ProgressMonitor;
import org.nasdanika.common.Reflector.Factory;
import org.nasdanika.graph.processor.NodeProcessorConfig;
import org.nasdanika.html.model.app.Action;
import org.nasdanika.html.model.app.Label;
import org.nasdanika.html.model.app.graph.WidgetFactory;
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
			actionPrototype = """
                    app-action:
                        text: Param
                        icon: fas fa-user					
					""",
			description = "A model of a family",
			documentation =  """
				Family model is used to demonstrate different Nasdanika technologies such as:
				
				* Generating of metamodel (Ecore) documentation like this one
				* Loading of models from MS Excel and Drawio diagrams
				* Generation of HTML sites from loaded models		
				
				The model was created to mimic the model from [Eclipse Sirius Basic Family](https://wiki.eclipse.org/Sirius/Tutorials/BasicFamily) tutorial. 
				This site uses fee icons from [Icons8](https://icons8.com/) and quotes [Wikipedia](https://www.wikipedia.org/) articles.
				
				The diagram below is interactive:
				
				 * Hover the mouse pointer over the shapes and connections to see tooltips
				 * Click on the shapes and connections to navigate to the pages of the respective model elements.
				   
				Click on the diagram to make it fullscreen. Then you may click on the pencil icon to edit it in the browser. 				 				
				
				```drawio-resource
				family.drawio
				```
						
				"""
	)
	public EPackageNodeProcessor createEPackageProcessor(
			NodeProcessorConfig<WidgetFactory, WidgetFactory> config, 
			java.util.function.Function<ProgressMonitor, Action> prototypeProvider,
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
