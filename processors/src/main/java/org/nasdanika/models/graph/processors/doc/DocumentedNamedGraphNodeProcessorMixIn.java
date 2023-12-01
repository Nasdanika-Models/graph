/**
 */
package org.nasdanika.models.graph.processors.doc;

import org.nasdanika.graph.model.GraphElement;
import org.nasdanika.models.ncore.processors.doc.DocumentedNamedElementNodeProcessorMixIn;

public interface DocumentedNamedGraphNodeProcessorMixIn<E extends GraphElement> extends GraphNodeProcessorMixIn<E>, DocumentedNamedElementNodeProcessorMixIn {
	
}
