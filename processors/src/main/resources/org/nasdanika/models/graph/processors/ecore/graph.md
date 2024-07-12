Nasdanika graph model provides base classes (building blocks) for graph-like models such as process/flow and [architecture](https://architecture.models.nasdanika.org/) models.

The model can also be used AS-IS. 
[Living Beings](demo/living-beings/index.html) ([source](https://github.com/Nasdanika-Models/graph/blob/main/generator/src/test/java/org/nasdanika/models/graph/generator/tests/TestGraph.java#L107)) demonstrated mapping of a [Drawio](https://www.drawio.com/) diagram to this model and generation of HTML documentation.
The mapping process is explained in the [Beyond Diagrams](https://leanpub.com/beyond-diagrams) book. 

The below diagram shows some of the model classes:

```drawio-resource
graph.drawio
```

[Graph](references/eClassifiers/Graph/index.html) is a container of [graph elements](references/eClassifiers/GraphElement/index.html):

* [Connection source](references/eClassifiers/ConnectionSource/index.html) - source and container of [connections](references/eClassifiers/Connection/index.html)
* [Connection target](references/eClassifiers/ConnectionTarget/index.html)
* [Sub-graph](references/eClassifiers/SubGraph/index.html) - both graph element and graph, allows to nest graphs

[Node](references/eClassifiers/Node/index.html) is both connection source and connection target. 
I.e. it may have both outgoing and incoming connections.

Then there are ``Composite`` flavors of connection source, connection target and node - they are also sub-graphs, i.e. may contain other graph elements.
There is an aggregate connection - [Tunnel](references/eClassifiers/Tunnel/index.html).

Not shown on the diagram are ``Documented Named`` flavors of the above classes, including ``Documented Named Composite`` flavors.

## Adapting to graph

Graph model elements can be adapted to [Graph](https://docs.nasdanika.org/core/graph/index.html) interfaces with ``org.nasdanika.graph.model.adapters.GraphAdapterFactory`` as shown below:

```java
GraphAdapterFactory graphAdapterFactory = new GraphAdapterFactory();  
Transformer<EObject,ElementAdapter<?>> graphFactory = new Transformer<>(graphAdapterFactory); // Reflective creation
ProgressMonitor progressMonitor = new PrintStreamProgressMonitor();
Map<EObject, ElementAdapter<?>> registry = graphFactory.transform(Collections.singleton(graph), false, progressMonitor);
```

Once you have a graph you may create processors on top of it.

## See Also

* [Graph](https://docs.nasdanika.org/core/graph/index.html)
* [Drawio](https://docs.nasdanika.org/core/drawio/index.html)
* [Connecting the dots](https://medium.com/nasdanika/connecting-the-dots-94a733c61059)
* [Executable (computational) graphs & diagrams](https://medium.com/nasdanika/executable-computational-graphs-diagrams-1eeffc80976d)
* [Beyond Diagrams](https://leanpub.com/beyond-diagrams)