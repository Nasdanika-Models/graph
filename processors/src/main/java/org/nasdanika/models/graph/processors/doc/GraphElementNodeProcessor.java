package org.nasdanika.models.graph.processors.doc;

import org.nasdanika.common.Context;
import org.nasdanika.common.ProgressMonitor;
import org.nasdanika.graph.model.GraphElement;
import org.nasdanika.graph.processor.NodeProcessorConfig;
import org.nasdanika.html.model.app.Action;
import org.nasdanika.html.model.app.graph.WidgetFactory;

public class GraphElementNodeProcessor<T extends GraphElement> extends NodeProcessorBase<T> implements GraphElementNodeProcessorMixIn {
			
	public GraphElementNodeProcessor(
			NodeProcessorConfig<WidgetFactory, WidgetFactory> config, 
			Context context,
			java.util.function.Function<ProgressMonitor, Action> prototypeProvider) {
		super(config, context, prototypeProvider);
	}	
		
}
