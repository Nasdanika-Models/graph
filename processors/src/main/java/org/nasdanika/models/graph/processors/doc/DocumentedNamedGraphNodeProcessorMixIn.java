/**
 */
package org.nasdanika.models.graph.processors.doc;

import org.nasdanika.graph.model.DocumentedNamedGraph;
import org.nasdanika.models.ncore.processors.doc.DocumentedNamedElementNodeProcessorMixIn;

public interface DocumentedNamedGraphNodeProcessorMixIn<T extends DocumentedNamedGraph<?>> extends GraphNodeProcessorMixIn<T>, DocumentedNamedElementNodeProcessorMixIn<T> {
	
}
