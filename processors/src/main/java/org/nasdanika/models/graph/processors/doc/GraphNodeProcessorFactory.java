package org.nasdanika.models.graph.processors.doc;

import java.util.function.BiConsumer;

import org.eclipse.emf.common.util.URI;
import org.nasdanika.common.Context;
import org.nasdanika.common.ProgressMonitor;
import org.nasdanika.graph.Element;
import org.nasdanika.graph.emf.EObjectNode;
import org.nasdanika.graph.model.CompositeConnectionSource;
import org.nasdanika.graph.model.CompositeConnectionTarget;
import org.nasdanika.graph.model.CompositeNode;
import org.nasdanika.graph.model.Connection;
import org.nasdanika.graph.model.ConnectionSource;
import org.nasdanika.graph.model.ConnectionTarget;
import org.nasdanika.graph.model.DocumentedNamedCompositeConnectionSource;
import org.nasdanika.graph.model.DocumentedNamedCompositeConnectionTarget;
import org.nasdanika.graph.model.DocumentedNamedCompositeNode;
import org.nasdanika.graph.model.DocumentedNamedConnection;
import org.nasdanika.graph.model.DocumentedNamedConnectionTarget;
import org.nasdanika.graph.model.DocumentedNamedGraph;
import org.nasdanika.graph.model.DocumentedNamedGraphElement;
import org.nasdanika.graph.model.DocumentedNamedNode;
import org.nasdanika.graph.model.DocumentedNamedSubGraph;
import org.nasdanika.graph.model.DocumentedNamedTunnel;
import org.nasdanika.graph.model.Graph;
import org.nasdanika.graph.model.GraphElement;
import org.nasdanika.graph.model.Node;
import org.nasdanika.graph.model.SubGraph;
import org.nasdanika.graph.model.Tunnel;
import org.nasdanika.graph.model.impl.DocumentedNamedConnectionSourceImpl;
import org.nasdanika.graph.processor.NodeProcessorConfig;
import org.nasdanika.graph.processor.ProcessorInfo;
import org.nasdanika.graph.processor.emf.EObjectNodeProcessor;
import org.nasdanika.html.model.app.Action;
import org.nasdanika.html.model.app.AppFactory;
import org.nasdanika.html.model.app.graph.WidgetFactory;
import org.nasdanika.ncore.util.NcoreUtil;

/**
 * Node processor factory to use with {@link EObjectReflectiveProcessorFactory} to generate graph documentation.
 * @author Pavel
 *
 */
public class GraphNodeProcessorFactory {
			
	private Context context;
	private java.util.function.BiFunction<URI, ProgressMonitor, Action> prototypeProvider;

	protected java.util.function.Function<ProgressMonitor, Action> getPrototypeProvider(NodeProcessorConfig<WidgetFactory, WidgetFactory> config) {
		return progressMonitor -> {
			if (prototypeProvider != null) {
				for (URI identifier: NcoreUtil.getIdentifiers(((EObjectNode) config.getElement()).get())) {
					Action prototype = prototypeProvider.apply(identifier, progressMonitor);
					if (prototype != null) {
						return prototype;
					}				
				}			
			}
			return AppFactory.eINSTANCE.createAction();
		};		
	}
	
	/**
	 * 
	 * @param context
	 * @param reflectiveFactories Objects with annotated methods for creating processors. 
	 */
	public GraphNodeProcessorFactory(
			Context context, 
			java.util.function.BiFunction<URI, ProgressMonitor, Action> prototypeProvider)  {
		this.context = context;
		this.prototypeProvider = prototypeProvider;
	}
	
	//	Graph.java	
	@EObjectNodeProcessor(type = org.nasdanika.graph.model.Graph.class)
	public Object createGraphNodeProcessor(
			NodeProcessorConfig<WidgetFactory, WidgetFactory> config, 
			boolean parallel, 
			BiConsumer<Element,BiConsumer<ProcessorInfo<Object>,ProgressMonitor>> infoProvider,
			ProgressMonitor progressMonitor) {
		
		return new GraphNodeProcessor<Graph<?>>(config, context, getPrototypeProvider(config));
	}
	
	//	DocumentedNamedGraph.java
	@EObjectNodeProcessor(type = org.nasdanika.graph.model.DocumentedNamedGraph.class)
	public Object createDocumentedNamedGraphNodeProcessor(
			NodeProcessorConfig<WidgetFactory, WidgetFactory> config, 
			boolean parallel, 
			BiConsumer<Element,BiConsumer<ProcessorInfo<Object>,ProgressMonitor>> infoProvider,
			ProgressMonitor progressMonitor) {
		
		return new DocumentedNamedGraphNodeProcessor<DocumentedNamedGraph<?>>(config, context, getPrototypeProvider(config));
	}
	
	//	CompositeConnectionSource.java
	@EObjectNodeProcessor(type = org.nasdanika.graph.model.CompositeConnectionSource.class)
	public Object createCompositeConnectionSourceNodeProcessor(
			NodeProcessorConfig<WidgetFactory, WidgetFactory> config, 
			boolean parallel, 
			BiConsumer<Element,BiConsumer<ProcessorInfo<Object>,ProgressMonitor>> infoProvider,
			ProgressMonitor progressMonitor) {
		
		return new CompositeConnectionSourceNodeProcessor<CompositeConnectionSource<?,?>>(config, context, getPrototypeProvider(config));
	}
	
	//	CompositeConnectionTarget.java
	@EObjectNodeProcessor(type = org.nasdanika.graph.model.CompositeConnectionTarget.class)
	public Object createCompositeConnectionTargetNodeProcessor(
			NodeProcessorConfig<WidgetFactory, WidgetFactory> config, 
			boolean parallel, 
			BiConsumer<Element,BiConsumer<ProcessorInfo<Object>,ProgressMonitor>> infoProvider,
			ProgressMonitor progressMonitor) {
		
		return new CompositeConnectionTargetNodeProcessor<CompositeConnectionTarget<?,?>>(config, context, getPrototypeProvider(config));
	}
	
	//	DocumentedNamedCompositeConnectionSource.java
	@EObjectNodeProcessor(type = org.nasdanika.graph.model.DocumentedNamedCompositeConnectionSource.class)
	public Object createDocumentedNamedCompositeConnectionSourceNodeProcessor(
			NodeProcessorConfig<WidgetFactory, WidgetFactory> config, 
			boolean parallel, 
			BiConsumer<Element,BiConsumer<ProcessorInfo<Object>,ProgressMonitor>> infoProvider,
			ProgressMonitor progressMonitor) {
		
		return new DocumentedNamedCompositeConnectionSourceNodeProcessor<DocumentedNamedCompositeConnectionSource<?, ?>>(config, context, getPrototypeProvider(config));
	}
	
	//	DocumentedNamedCompositeConnectionTarget.java
	@EObjectNodeProcessor(type = org.nasdanika.graph.model.DocumentedNamedCompositeConnectionTarget.class)
	public Object createDocumentedNamedCompositeConnectionTargetNodeProcessor(
			NodeProcessorConfig<WidgetFactory, WidgetFactory> config, 
			boolean parallel, 
			BiConsumer<Element,BiConsumer<ProcessorInfo<Object>,ProgressMonitor>> infoProvider,
			ProgressMonitor progressMonitor) {
		
		return new DocumentedNamedCompositeConnectionTargetNodeProcessor<DocumentedNamedCompositeConnectionTarget<?, ?>>(config, context, getPrototypeProvider(config));
	}
	
	//	SubGraph.java
	@EObjectNodeProcessor(type = org.nasdanika.graph.model.SubGraph.class)
	public Object createSubGraphNodeProcessor(
			NodeProcessorConfig<WidgetFactory, WidgetFactory> config, 
			boolean parallel, 
			BiConsumer<Element,BiConsumer<ProcessorInfo<Object>,ProgressMonitor>> infoProvider,
			ProgressMonitor progressMonitor) {
		
		return new SubGraphNodeProcessor<SubGraph<?>>(config, context, getPrototypeProvider(config));
	}
	
	//	DocumentedNamedSubGraph.java
	@EObjectNodeProcessor(type = org.nasdanika.graph.model.DocumentedNamedSubGraph.class)
	public Object createDocumentedNamedSubGraphNodeProcessor(
			NodeProcessorConfig<WidgetFactory, WidgetFactory> config, 
			boolean parallel, 
			BiConsumer<Element,BiConsumer<ProcessorInfo<Object>,ProgressMonitor>> infoProvider,
			ProgressMonitor progressMonitor) {
		
		return new DocumentedNamedSubGraphNodeProcessor<DocumentedNamedSubGraph<?>>(config, context, getPrototypeProvider(config));
	}
	
	//	GraphElement.java
	@EObjectNodeProcessor(type = org.nasdanika.graph.model.GraphElement.class)
	public Object createGraphElementNodeProcessor(
			NodeProcessorConfig<WidgetFactory, WidgetFactory> config, 
			boolean parallel, 
			BiConsumer<Element,BiConsumer<ProcessorInfo<Object>,ProgressMonitor>> infoProvider,
			ProgressMonitor progressMonitor) {
		
		return new GraphElementNodeProcessor<GraphElement>(config, context, getPrototypeProvider(config));
	}
	
	//	DocumentedNamedGraphElement.java
	@EObjectNodeProcessor(type = org.nasdanika.graph.model.DocumentedNamedGraphElement.class)
	public Object createDocumentedNamedGraphElementNodeProcessor(
			NodeProcessorConfig<WidgetFactory, WidgetFactory> config, 
			boolean parallel, 
			BiConsumer<Element,BiConsumer<ProcessorInfo<Object>,ProgressMonitor>> infoProvider,
			ProgressMonitor progressMonitor) {
		
		return new DocumentedNamedGraphElementNodeProcessor<DocumentedNamedGraphElement>(config, context, getPrototypeProvider(config));
	}
	
	//	ConnectionSource.java
	@EObjectNodeProcessor(type = org.nasdanika.graph.model.ConnectionSource.class)
	public Object createConnectionSourceNodeProcessor(
			NodeProcessorConfig<WidgetFactory, WidgetFactory> config, 
			boolean parallel, 
			BiConsumer<Element,BiConsumer<ProcessorInfo<Object>,ProgressMonitor>> infoProvider,
			ProgressMonitor progressMonitor) {
		
		return new ConnectionSourceNodeProcessor<ConnectionSource<?>>(config, context, getPrototypeProvider(config));
	}
	
	//	DocumentedNamedConnectionSource.java
	@EObjectNodeProcessor(type = org.nasdanika.graph.model.DocumentedNamedConnectionSource.class)
	public Object createDocumentedNamedConnectionSourceNodeProcessor(
			NodeProcessorConfig<WidgetFactory, WidgetFactory> config, 
			boolean parallel, 
			BiConsumer<Element,BiConsumer<ProcessorInfo<Object>,ProgressMonitor>> infoProvider,
			ProgressMonitor progressMonitor) {
		
		return new DocumentedNamedConnectionSourceNodeProcessor<DocumentedNamedConnectionSourceImpl<?>>(config, context, getPrototypeProvider(config));
	}
	
	//	ConnectionTarget.java
	@EObjectNodeProcessor(type = org.nasdanika.graph.model.ConnectionTarget.class)
	public Object createConnectionTargetNodeProcessor(
			NodeProcessorConfig<WidgetFactory, WidgetFactory> config, 
			boolean parallel, 
			BiConsumer<Element,BiConsumer<ProcessorInfo<Object>,ProgressMonitor>> infoProvider,
			ProgressMonitor progressMonitor) {
		
		return new ConnectionTargetNodeProcessor<ConnectionTarget<?>>(config, context, getPrototypeProvider(config));
	}
	
	//	DocumentedNamedConnectionTarget.java
	@EObjectNodeProcessor(type = org.nasdanika.graph.model.DocumentedNamedConnectionTarget.class)
	public Object createDocumentedNamedConnectionTargetNodeProcessor(
			NodeProcessorConfig<WidgetFactory, WidgetFactory> config, 
			boolean parallel, 
			BiConsumer<Element,BiConsumer<ProcessorInfo<Object>,ProgressMonitor>> infoProvider,
			ProgressMonitor progressMonitor) {
		
		return new DocumentedNamedConnectionTargetNodeProcessor<DocumentedNamedConnectionTarget<?>>(config, context, getPrototypeProvider(config));
	}
	
	//	Node.java
	@EObjectNodeProcessor(type = org.nasdanika.graph.model.Node.class)
	public Object createNodeNodeProcessor(
			NodeProcessorConfig<WidgetFactory, WidgetFactory> config, 
			boolean parallel, 
			BiConsumer<Element,BiConsumer<ProcessorInfo<Object>,ProgressMonitor>> infoProvider,
			ProgressMonitor progressMonitor) {
		
		return new NodeNodeProcessor<Node<?>>(config, context, getPrototypeProvider(config));
	}
	
	//	DocumentedNamedNode.java
	@EObjectNodeProcessor(type = org.nasdanika.graph.model.DocumentedNamedNode.class)
	public Object createDocumentedNamedNodeNodeProcessor(
			NodeProcessorConfig<WidgetFactory, WidgetFactory> config, 
			boolean parallel, 
			BiConsumer<Element,BiConsumer<ProcessorInfo<Object>,ProgressMonitor>> infoProvider,
			ProgressMonitor progressMonitor) {
		
		return new DocumentedNamedNodeNodeProcessor<DocumentedNamedNode<?>>(config, context, getPrototypeProvider(config));
	}
	
	//	CompositeNode.java
	@EObjectNodeProcessor(type = org.nasdanika.graph.model.CompositeNode.class)
	public Object createCompositeNodeNodeProcessor(
			NodeProcessorConfig<WidgetFactory, WidgetFactory> config, 
			boolean parallel, 
			BiConsumer<Element,BiConsumer<ProcessorInfo<Object>,ProgressMonitor>> infoProvider,
			ProgressMonitor progressMonitor) {
		
		return new CompositeNodeNodeProcessor<CompositeNode<?, ?>>(config, context, getPrototypeProvider(config));
	}
	
	//	DocumentedNamedCompositeNode.java
	@EObjectNodeProcessor(type = org.nasdanika.graph.model.DocumentedNamedCompositeNode.class)
	public Object createDocumentedNamedCompositeNodeNodeProcessor(
			NodeProcessorConfig<WidgetFactory, WidgetFactory> config, 
			boolean parallel, 
			BiConsumer<Element,BiConsumer<ProcessorInfo<Object>,ProgressMonitor>> infoProvider,
			ProgressMonitor progressMonitor) {
		
		return new DocumentedNamedCompositeNodeNodeProcessor<DocumentedNamedCompositeNode<?, ?>>(config, context, getPrototypeProvider(config));
	}
	
	//	Connection.java
	@EObjectNodeProcessor(type = org.nasdanika.graph.model.Connection.class)
	public Object createConnectionNodeProcessor(
			NodeProcessorConfig<WidgetFactory, WidgetFactory> config, 
			boolean parallel, 
			BiConsumer<Element,BiConsumer<ProcessorInfo<Object>,ProgressMonitor>> infoProvider,
			ProgressMonitor progressMonitor) {
		
		return new ConnectionNodeProcessor<Connection<?>>(config, context, getPrototypeProvider(config));
	}
	
	//	DocumentedNamedConnection.java
	@EObjectNodeProcessor(type = org.nasdanika.graph.model.DocumentedNamedConnection.class)
	public Object createDocumentedNamedConnectionNodeProcessor(
			NodeProcessorConfig<WidgetFactory, WidgetFactory> config, 
			boolean parallel, 
			BiConsumer<Element,BiConsumer<ProcessorInfo<Object>,ProgressMonitor>> infoProvider,
			ProgressMonitor progressMonitor) {
		
		return new DocumentedNamedConnectionNodeProcessor<DocumentedNamedConnection<?>>(config, context, getPrototypeProvider(config));
	}
	
	//	Tunnel.java
	@EObjectNodeProcessor(type = org.nasdanika.graph.model.Tunnel.class)
	public Object createTunnelNodeProcessor(
			NodeProcessorConfig<WidgetFactory, WidgetFactory> config, 
			boolean parallel, 
			BiConsumer<Element,BiConsumer<ProcessorInfo<Object>,ProgressMonitor>> infoProvider,
			ProgressMonitor progressMonitor) {
		
		return new TunnelNodeProcessor<Tunnel<?,?>>(config, context, getPrototypeProvider(config));
	}
	
	//	DocumentedNamedTunnel.java
	@EObjectNodeProcessor(type = org.nasdanika.graph.model.DocumentedNamedTunnel.class)
	public Object createDocumentedNamedTunnelNodeProcessor(
			NodeProcessorConfig<WidgetFactory, WidgetFactory> config, 
			boolean parallel, 
			BiConsumer<Element,BiConsumer<ProcessorInfo<Object>,ProgressMonitor>> infoProvider,
			ProgressMonitor progressMonitor) {
		
		return new DocumentedNamedTunnelNodeProcessor<DocumentedNamedTunnel<?, ?>>(config, context, getPrototypeProvider(config));
	}
	
}
