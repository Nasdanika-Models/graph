/**
 */
package org.nasdanika.models.graph.processors.doc;

import org.nasdanika.graph.model.DocumentedNamedGraphElement;
import org.nasdanika.models.ncore.processors.doc.DocumentedNamedStringIdentityNodeProcessorMixIn;

public interface DocumentedNamedGraphElementNodeProcessorMixIn<T extends DocumentedNamedGraphElement> extends GraphElementNodeProcessorMixIn<T>, DocumentedNamedStringIdentityNodeProcessorMixIn<T> {
	
} 
