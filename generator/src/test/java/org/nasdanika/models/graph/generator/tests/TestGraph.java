package org.nasdanika.models.graph.generator.tests;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import java.util.Map.Entry;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.junit.jupiter.api.Test;
import org.nasdanika.common.Context;
import org.nasdanika.common.Diagnostic;
import org.nasdanika.common.DiagramGenerator;
import org.nasdanika.common.ExecutionException;
import org.nasdanika.common.Mapper;
import org.nasdanika.common.MutableContext;
import org.nasdanika.common.NasdanikaException;
import org.nasdanika.common.PrintStreamProgressMonitor;
import org.nasdanika.common.ProgressMonitor;
import org.nasdanika.common.Transformer;
import org.nasdanika.diagramgenerator.plantuml.PlantUMLDiagramGenerator;
import org.nasdanika.drawio.model.ModelElement;
import org.nasdanika.drawio.model.Page;
import org.nasdanika.graph.Connection;
import org.nasdanika.graph.Element;
import org.nasdanika.graph.emf.EObjectGraphFactory;
import org.nasdanika.graph.emf.EObjectNode;
import org.nasdanika.graph.model.DocumentedNamedGraph;
import org.nasdanika.graph.model.DocumentedNamedGraphElement;
import org.nasdanika.graph.model.ModelPackage;
import org.nasdanika.graph.model.util.GraphDrawioFactory;
import org.nasdanika.graph.model.util.GraphPropertySetterFeatureMapper;
import org.nasdanika.graph.processor.NopEndpointProcessorConfigFactory;
import org.nasdanika.graph.processor.ProcessorConfig;
import org.nasdanika.graph.processor.ProcessorInfo;
import org.nasdanika.graph.processor.emf.EObjectNodeProcessorReflectiveFactory;
import org.nasdanika.html.model.app.Label;
import org.nasdanika.html.model.app.Link;
import org.nasdanika.html.model.app.gen.ActionSiteGenerator;
import org.nasdanika.html.model.app.graph.WidgetFactory;
import org.nasdanika.html.model.app.graph.emf.EObjectReflectiveProcessorFactoryProvider;
import org.nasdanika.models.graph.processors.doc.GraphNodeProcessorFactory;
import org.nasdanika.ncore.NamedElement;
import org.nasdanika.ncore.NcorePackage;
import org.nasdanika.persistence.Marked;

public class TestGraph {
	
	@Test
	public void testLoadGraphDocument() throws Exception {
		ProgressMonitor progressMonitor = new PrintStreamProgressMonitor();
		Context context = Context.EMPTY_CONTEXT;
		ResourceSet resourceSet = org.nasdanika.html.model.app.gen.Util.createResourceSet(context, progressMonitor);
		URI diagramURI = URI.createFileURI(new File("graph.drawio").getCanonicalPath());
		Resource diagramModel = resourceSet.getResource(diagramURI, true);
		
		GraphDrawioFactory<DocumentedNamedGraph<DocumentedNamedGraphElement>, DocumentedNamedGraphElement> graphDrawioFactory = new GraphDrawioFactory<>() {
			@Override
			protected Mapper<EObject, EObject> getMapper(int phase, int pass) {
				GraphDrawioFactory<DocumentedNamedGraph<DocumentedNamedGraphElement>, DocumentedNamedGraphElement> self = this; 
				
				return new GraphPropertySetterFeatureMapper() {

					@Override
					protected Setter<EObject, EObject> getFeatureSetter(
							EObject source, 
							ConfigType configType,
							ConfigSubType configSubType, 
							EStructuralFeature feature,
							BiConsumer<String, EObject> featureNameValidator) {
						
						if (feature instanceof EReference && ((EReference) feature).isContainment())  {							
							return phase == 0 ? super.getFeatureSetter(source, configType, configSubType, feature, featureNameValidator) : null;					
						}
						
						return phase == 0 ? null : super.getFeatureSetter(source, configType, configSubType, feature, featureNameValidator);					
					}

					@Override
					protected boolean isTopLevelPage(Page page) {
						return self.isTopLevelPage(page);
					}

					@Override
					protected boolean isPageElement(ModelElement drawioModelElement) {
						return self.isPageElement(drawioModelElement);
					}

					@Override
					protected EClassifier getType(String type, EObject context) {
						return self.getType(type, context instanceof Marked ? (Marked) context : null);
					}

					@Override
					protected URI getBaseURI(ModelElement source) {
						return self.getBaseURI(source);
					}
					
				};		
			}
		};
		
		Transformer<EObject,EObject> graphFactory = new Transformer<>(graphDrawioFactory);
		Collection<EObject> diagramModelContents = new ArrayList<>();
		diagramModel.getAllContents().forEachRemaining(e -> {
			if (e instanceof org.nasdanika.drawio.model.Document
					|| e instanceof org.nasdanika.drawio.model.Page
					|| e instanceof org.nasdanika.drawio.model.ModelElement) {
				diagramModelContents.add(e);
//				System.out.println(e);
			}
		});
		Map<EObject, EObject> graphElements = graphFactory.transform(diagramModelContents, false, progressMonitor);
		System.out.println(graphElements.size());
		
		URI graphURI = URI.createFileURI(new File("target/graph.xmi").getCanonicalPath());
		Resource graphResource = resourceSet.createResource(graphURI);
		diagramModel.getContents().stream().map(graphElements::get).forEach(ge -> {
			if (ge instanceof NamedElement) {
				NamedElement nge = (NamedElement) ge;
				if (org.nasdanika.common.Util.isBlank(nge.getName())) {
					nge.setName("Test Graph");
				}
			}
			graphResource.getContents().add(ge);
		});
		graphResource.save(null);		
	}
	
	@Test
	public void testGenerateGraphDoc() throws Exception {
		ProgressMonitor progressMonitor = new PrintStreamProgressMonitor();
		MutableContext context = Context.EMPTY_CONTEXT.fork();
		context.register(DiagramGenerator.class, new PlantUMLDiagramGenerator());
		ResourceSet resourceSet = org.nasdanika.html.model.app.gen.Util.createResourceSet(context, progressMonitor);
		resourceSet.getPackageRegistry().put(ModelPackage.eNS_URI, ModelPackage.eINSTANCE);
		resourceSet.getPackageRegistry().put(NcorePackage.eNS_URI, NcorePackage.eINSTANCE);
		
		URI flowURI = URI.createFileURI(new File("target/graph.xmi").getCanonicalPath());
		Resource graphResource = resourceSet.getResource(flowURI, true);
		
		Transformer<EObject,Element> graphFactory = new Transformer<>(new EObjectGraphFactory());
		Map<EObject, Element> graph = graphFactory.transform(graphResource.getContents(), false, progressMonitor);

		NopEndpointProcessorConfigFactory<WidgetFactory> configFactory = new NopEndpointProcessorConfigFactory<>() {
			
			@Override
			protected boolean isPassThrough(Connection connection) {
				return false;
			}
			
		};
		
		Transformer<Element,ProcessorConfig> processorConfigTransformer = new Transformer<>(configFactory);				
		Map<Element, ProcessorConfig> configs = processorConfigTransformer.transform(graph.values(), false, progressMonitor);
		
		Consumer<Diagnostic> diagnosticConsumer = d -> d.dump(System.out, 0);
		GraphNodeProcessorFactory graphNodeProcessorFactory = new GraphNodeProcessorFactory(context, null);		
		
		EObjectNodeProcessorReflectiveFactory<WidgetFactory, WidgetFactory> eObjectNodeProcessorReflectiveFactory = new EObjectNodeProcessorReflectiveFactory<>(graphNodeProcessorFactory);
		EObjectReflectiveProcessorFactoryProvider eObjectReflectiveProcessorFactoryProvider = new EObjectReflectiveProcessorFactoryProvider(eObjectNodeProcessorReflectiveFactory);
		Map<Element, ProcessorInfo<Object>> registry = eObjectReflectiveProcessorFactoryProvider.getFactory().createProcessors(configs.values(), false, progressMonitor);
		
		WidgetFactory graphProcessor = null;
		Collection<Throwable> resolveFailures = new ArrayList<>();		
		URI baseActionURI = URI.createURI("local://flow.models.nasdanika.org/demo/");
		
		Map<EObject, URI> uriMap = Map.ofEntries(
				Map.entry(EcorePackage.eINSTANCE, URI.createURI("https://ecore.models.nasdanika.org/")),			
				Map.entry(NcorePackage.eINSTANCE, URI.createURI("https://ncore.models.nasdanika.org/")),			
				Map.entry(ModelPackage.eINSTANCE, URI.createURI("https://graph.models.nasdanika.org/")),			
				Map.entry(graphResource.getContents().get(0), baseActionURI)				
			);
		
		for (EObject topLevel: uriMap.keySet()) {
			for (Entry<Element, ProcessorInfo<Object>> re: registry.entrySet()) {
				Element element = re.getKey();
				if (element instanceof EObjectNode) {
					EObjectNode eObjNode = (EObjectNode) element;
					EObject target = eObjNode.get();
					if (target == topLevel) {
						ProcessorInfo<Object> info = re.getValue();
						Object processor = info.getProcessor();
						if (processor instanceof WidgetFactory) {
							WidgetFactory widgetFactoryNodeProcessor = (WidgetFactory) processor;
							widgetFactoryNodeProcessor.resolve(uriMap.get(topLevel), progressMonitor);
							
							if (topLevel == graphResource.getContents().get(0)) { 							
								graphProcessor = widgetFactoryNodeProcessor;
							}
						}
					}
				}
			}			
		}
		
		if (!resolveFailures.isEmpty()) {
			NasdanikaException ne = new NasdanikaException("Theres's been " + resolveFailures.size() +  " failures during URI resolution: " + resolveFailures);
			for (Throwable failure: resolveFailures) {
				ne.addSuppressed(failure);
			}
			throw ne;
		}								
		
		ResourceSet actionModelsResourceSet = new ResourceSetImpl();
		actionModelsResourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put(Resource.Factory.Registry.DEFAULT_EXTENSION, new XMIResourceFactoryImpl());
		
		File actionModelsDir = new File("target\\action-models\\");
		actionModelsDir.mkdirs();
		
		File output = new File(actionModelsDir, "graph-actions.xmi");
		Resource actionModelResource = actionModelsResourceSet.createResource(URI.createFileURI(output.getAbsolutePath()));
		Collection<Label> labels = graphProcessor.createLabelsSupplier().call(progressMonitor, diagnosticConsumer);
		for (Label label: labels) {
			if (label instanceof Link) {
				Link link = (Link) label;
				String location = link.getLocation();
				if (!org.nasdanika.common.Util.isBlank(location)) {
					URI uri = URI.createURI(location);
					if (!uri.isRelative()) {
						link.setLocation("${base-uri}" + uri.deresolve(baseActionURI, true, true, true).toString());
					}
				}
			}
		}
						
		actionModelResource.getContents().addAll(labels);
		actionModelResource.save(null);
				
		String rootActionResource = "graph-actions.yml";
		URI rootActionURI = URI.createFileURI(new File(rootActionResource).getAbsolutePath());//.appendFragment("/");
		
		String pageTemplateResource = "page-template.yml";
		URI pageTemplateURI = URI.createFileURI(new File(pageTemplateResource).getAbsolutePath());//.appendFragment("/");
		
		String siteMapDomain = "https://graph.models.nasdanika.org/demo";		
		ActionSiteGenerator actionSiteGenerator = new ActionSiteGenerator() {
			
			protected boolean isDeleteOutputPath(String path) {
				return !"CNAME".equals(path);				
			};
			
		};		
		
		Map<String, Collection<String>> errors = actionSiteGenerator.generate(rootActionURI, pageTemplateURI, siteMapDomain, new File("../docs/demo"), new File("target/graph-doc-site-work-dir"), true);
				
		int errorCount = 0;
		for (Entry<String, Collection<String>> ee: errors.entrySet()) {
			System.err.println(ee.getKey());
			for (String error: ee.getValue()) {
				System.err.println("\t" + error);
				++errorCount;
			}
		}
		
		System.out.println("There are " + errorCount + " site errors");
		
		if (errors.size() != 6) {
			throw new ExecutionException("There are problems with pages: " + errorCount);
		}		
		
	}
	
}
