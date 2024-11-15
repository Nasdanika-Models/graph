package org.nasdanika.models.graph.generator.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.util.Collection;
import java.util.Map;
import java.util.Map.Entry;
import java.util.function.Consumer;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.URIHandlerImpl;
import org.junit.jupiter.api.Test;
import org.nasdanika.capability.CapabilityLoader;
import org.nasdanika.capability.ServiceCapabilityFactory;
import org.nasdanika.capability.ServiceCapabilityFactory.Requirement;
import org.nasdanika.capability.emf.ResourceSetRequirement;
import org.nasdanika.common.Context;
import org.nasdanika.common.DefaultConverter;
import org.nasdanika.common.Diagnostic;
import org.nasdanika.common.ExecutionException;
import org.nasdanika.common.MutableContext;
import org.nasdanika.common.PrintStreamProgressMonitor;
import org.nasdanika.common.ProgressMonitor;
import org.nasdanika.graph.model.DocumentedNamedGraph;
import org.nasdanika.graph.model.DocumentedNamedSubGraph;
import org.nasdanika.graph.model.GraphElement;
import org.nasdanika.models.app.gen.AppSiteGenerator;
import org.nasdanika.models.graph.processors.doc.GraphHtmlAppGenerator;
import org.nasdanika.models.graph.processors.doc.GraphNodeProcessorFactory;

public class TestGraph {
	
	@Test
	public void testGenerateGraphSite() throws Exception {
		CapabilityLoader capabilityLoader = new CapabilityLoader();
		ProgressMonitor progressMonitor = new PrintStreamProgressMonitor();
		Requirement<ResourceSetRequirement, ResourceSet> requirement = ServiceCapabilityFactory.createRequirement(ResourceSet.class);		
		ResourceSet resourceSet = capabilityLoader.loadOne(requirement, progressMonitor);
		
		File graphDiagramFile = new File("graph.drawio").getCanonicalFile();
		Resource graphResource = resourceSet.getResource(URI.createFileURI(graphDiagramFile.getAbsolutePath()), true);
		
		// Generating an action model
		MutableContext context = Context.EMPTY_CONTEXT.fork();
		
		Consumer<Diagnostic> diagnosticConsumer = d -> d.dump(System.out, 0);		
		
		File actionModelsDir = new File("target\\action-models\\");
		actionModelsDir.mkdirs();
								
		File output = new File(actionModelsDir, "graph-actions.xmi");
		
		GraphHtmlAppGenerator htmlAppGenerator = new GraphHtmlAppGenerator(
				graphResource.getContents().get(0),
				new GraphNodeProcessorFactory(context, null));
		
		htmlAppGenerator.generateHtmlAppModel(
				diagnosticConsumer, 
				output,
				progressMonitor);
				
		// Generating a web site
		String rootActionResource = "graph-actions.yml";
		URI rootActionURI = URI.createFileURI(new File(rootActionResource).getAbsolutePath());
		
		String pageTemplateResource = "page-template.yml";
		URI pageTemplateURI = URI.createFileURI(new File(pageTemplateResource).getAbsolutePath());
		
		String siteMapDomain = "https://graph.models.nasdanika.org/demo/graph";		
		AppSiteGenerator actionSiteGenerator = new AppSiteGenerator() {
			
			protected boolean isDeleteOutputPath(String path) {
				return !"CNAME".equals(path);				
			};
			
		};		
		
		Map<String, Collection<String>> errors = actionSiteGenerator.generate(
				rootActionURI, 
				pageTemplateURI, 
				siteMapDomain, 
				new File("../docs/demo/graph"),  
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
		
		if (errorCount != 9) {
			throw new ExecutionException("There are problems with pages: " + errorCount);
		}		
		
	}
	
	@Test
	public void testGenerateLivingBeingsSite() throws Exception {
		CapabilityLoader capabilityLoader = new CapabilityLoader();
		ProgressMonitor progressMonitor = new PrintStreamProgressMonitor();
		Requirement<ResourceSetRequirement, ResourceSet> requirement = ServiceCapabilityFactory.createRequirement(ResourceSet.class);		
		ResourceSet resourceSet = capabilityLoader.loadOne(requirement, progressMonitor);
		
		// To load resources from classpath
		resourceSet.getURIConverter().getURIHandlers().add(0, new URIHandlerImpl() {

			@Override
			public boolean canHandle(URI uri) {
				return uri != null && org.nasdanika.common.Util.CLASSPATH_SCHEME.equals(uri.scheme());
			}

			@Override
			public InputStream createInputStream(URI uri, Map<?, ?> options) throws IOException {
				return DefaultConverter.INSTANCE.toInputStream(uri);
			}
			
		});
		
		URI baseURI = URI.createURI("living-beings/").resolve(org.nasdanika.common.Util.createClassURI(getClass()));
		URI resourceURI = URI.createURI("living-beings.drawio").resolve(baseURI);	
		Resource livingBeingsResource = resourceSet.getResource(resourceURI, true);
		
		DocumentedNamedGraph<?> livingBeings = (DocumentedNamedGraph<?>) livingBeingsResource.getContents().get(0);
		
		// Asserting clockwise order
		assertEquals("bird", ((GraphElement) livingBeings.getElements().get(0)).getId());
		assertEquals("fish", ((GraphElement) livingBeings.getElements().get(1)).getId());
		
		DocumentedNamedSubGraph<?> bacteria = (DocumentedNamedSubGraph<?>) livingBeings.getElements().get(2);
		assertEquals("bacteria", bacteria.getId());
		
		assertEquals("streptococcus", ( bacteria.getElements().get(0)).getId());
		assertEquals("staphyllococcus", ((GraphElement) bacteria.getElements().get(5)).getId());
		
		// Generating an action model
		MutableContext context = Context.EMPTY_CONTEXT.fork();
		
		Consumer<Diagnostic> diagnosticConsumer = d -> d.dump(System.out, 0);		
		
		File actionModelsDir = new File("target\\action-models\\");
		actionModelsDir.mkdirs();
								
		File output = new File(actionModelsDir, "living-beings-actions.xmi");
		
		GraphHtmlAppGenerator htmlAppGenerator = new GraphHtmlAppGenerator(
				livingBeingsResource.getContents().get(0),
				new GraphNodeProcessorFactory(context, null));
		
		htmlAppGenerator.generateHtmlAppModel(
				diagnosticConsumer, 
				output,
				progressMonitor);
				
		// Generating a web site
		
		// Writing root action spec for relative resolution of the generated actions.
		File rootActionFile = new File("target/action-models/living-beings-root-action.yml");
		Files.write(
				rootActionFile.toPath(), 
				DefaultConverter.INSTANCE.toByteArray(getClass().getResource("living-beings/actions.yml")));
		
		URI rootActionURI = URI.createFileURI(rootActionFile.getCanonicalFile().getAbsolutePath());	
		URI pageTemplateURI = URI.createURI("page-template.yml").resolve(baseURI);
		String siteMapDomain = "https://graph.models.nasdanika.org/demo/living-beings";		
		AppSiteGenerator actionSiteGenerator = new AppSiteGenerator() {
			
			protected boolean isDeleteOutputPath(String path) {
				return !"CNAME".equals(path);				
			};
			
		};		
		
		Map<String, Collection<String>> errors = actionSiteGenerator.generate(
				rootActionURI, 
				pageTemplateURI, 
				siteMapDomain, 
				new File("../docs/demo/living-beings"),  
				new File("target/living-beings-doc-site-work-dir"), 
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
		
		if (errorCount != 9) {
			throw new ExecutionException("There are problems with pages: " + errorCount);
		}		
		
	}
		
}
