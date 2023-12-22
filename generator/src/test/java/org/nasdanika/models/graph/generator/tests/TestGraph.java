package org.nasdanika.models.graph.generator.tests;

import java.io.File;
import java.util.Collection;
import java.util.Map;
import java.util.Map.Entry;
import java.util.function.Consumer;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.junit.jupiter.api.Test;
import org.nasdanika.common.Context;
import org.nasdanika.common.Diagnostic;
import org.nasdanika.common.DiagramGenerator;
import org.nasdanika.common.ExecutionException;
import org.nasdanika.common.MutableContext;
import org.nasdanika.common.PrintStreamProgressMonitor;
import org.nasdanika.common.ProgressMonitor;
import org.nasdanika.diagramgenerator.plantuml.PlantUMLDiagramGenerator;
import org.nasdanika.graph.model.util.GraphDrawioResourceFactory;
import org.nasdanika.html.model.app.gen.ActionSiteGenerator;
import org.nasdanika.models.graph.processors.doc.GraphActionGenerator;
import org.nasdanika.models.graph.processors.doc.GraphNodeProcessorFactory;

public class TestGraph {
	
	@Test
	public void testGenerateGraphSite() throws Exception {
		ResourceSet resourceSet = new ResourceSetImpl();
		resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("drawio", new GraphDrawioResourceFactory(uri -> resourceSet.getEObject(uri, true)));
		File graphDiagramFile = new File("graph.drawio").getCanonicalFile();
		Resource graphResource = resourceSet.getResource(URI.createFileURI(graphDiagramFile.getAbsolutePath()), true);
		
		// Generating an action model
		ProgressMonitor progressMonitor = new PrintStreamProgressMonitor();
		MutableContext context = Context.EMPTY_CONTEXT.fork();
		context.register(DiagramGenerator.class, new PlantUMLDiagramGenerator());
		
		Consumer<Diagnostic> diagnosticConsumer = d -> d.dump(System.out, 0);		
		
		File actionModelsDir = new File("target\\action-models\\");
		actionModelsDir.mkdirs();
								
		File output = new File(actionModelsDir, "graph-actions.xmi");
		
		GraphActionGenerator actionGenerator = new GraphActionGenerator(
				graphResource.getContents().get(0),
				new GraphNodeProcessorFactory(context, null));
		
		actionGenerator.generateActionModel(
				diagnosticConsumer, 
				output,
				progressMonitor);
				
		// Generating a web site
		String rootActionResource = "graph-actions.yml";
		URI rootActionURI = URI.createFileURI(new File(rootActionResource).getAbsolutePath());
		
		String pageTemplateResource = "page-template.yml";
		URI pageTemplateURI = URI.createFileURI(new File(pageTemplateResource).getAbsolutePath());
		
		String siteMapDomain = "https://graph.models.nasdanika.org/demo";		
		ActionSiteGenerator actionSiteGenerator = new ActionSiteGenerator() {
			
			protected boolean isDeleteOutputPath(String path) {
				return !"CNAME".equals(path);				
			};
			
		};		
		
		Map<String, Collection<String>> errors = actionSiteGenerator.generate(
				rootActionURI, 
				pageTemplateURI, 
				siteMapDomain, 
				new File("../docs/demo"),  
				new File("target/graph-doc-site-work-dir"), 
				true);
				
		int errorCount = 0;
		for (Entry<String, Collection<String>> ee: errors.entrySet()) {
			System.err.println(ee.getKey());
			for (String error: ee.getValue()) {
				System.err.println("\t" + error);
				++errorCount;
			}
		}
		
		System.out.println("There are " + errorCount + " site errors");
		
		if (errors.size() != 9) {
			throw new ExecutionException("There are problems with pages: " + errorCount);
		}		
		
	}
		
}
