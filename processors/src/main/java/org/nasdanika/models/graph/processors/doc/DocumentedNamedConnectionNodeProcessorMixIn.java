/**
 */
package org.nasdanika.models.graph.processors.doc;

import org.nasdanika.graph.model.DocumentedNamedConnection;
import org.nasdanika.models.ncore.processors.doc.DocumentedNamedStringIdentityNodeProcessorMixIn;

public interface DocumentedNamedConnectionNodeProcessorMixIn<T extends DocumentedNamedConnection<?>> extends ConnectionNodeProcessorMixIn<T>, DocumentedNamedStringIdentityNodeProcessorMixIn<T> {
	
} 
