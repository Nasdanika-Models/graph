/**
 */
package org.nasdanika.models.graph.processors.doc;

import org.nasdanika.graph.model.ConnectionTarget;
import org.nasdanika.models.ncore.processors.doc.DocumentedNamedStringIdentityNodeProcessorMixIn;

public interface DocumentedNamedConnectionNodeProcessorMixIn<T extends ConnectionTarget<?>> extends ConnectionNodeProcessorMixIn<T>, DocumentedNamedStringIdentityNodeProcessorMixIn {
	
} 
