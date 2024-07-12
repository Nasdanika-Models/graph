var searchDocuments = {"demo/graph/glossary.html":{"action-uuid":"4cc96f24-dcfd-41d5-ae37-d72fde4884ff","title":"Glossary","content":"Clear Identifier(s) Hide UUID {{data.value.name}} {{data.value[0].value}} {{item.value}}"},"demo/graph/index.html":{"action-uuid":"2438d371-9e05-4abc-a139-534f59b6f700","title":"My Graph","content":" Node 1.1 Composite Node 1 Node 2.1 Composite Node 2 Connection A Sub-Node 1.1.2 Node 1.1 Composite Node 1 Node 2.1 Composite Node 2 Connection A Sub-Node 1.1.2"},"references/eClassifiers/ConnectionSource/index.html":{"action-uuid":"32e5fd86-a6b2-49f5-ae17-e2ee4bae4c63","title":"Connection Source","content":"Source of connections uniquely identified by string ids. It provides support for graph inheritance - replacing (overriding), adding, or removing connections."},"references/eClassifiers/DocumentedNamedConnectionSource/index.html":{"action-uuid":"6975596f-c328-4a19-80de-f57357ef83aa","title":"Documented Named Connection Source","content":"Connection source with a name and documentation"},"references/eClassifiers/ConnectionTarget/inheritance.html":{"path":"Connection Target/Inheritance","action-uuid":"4b3c8b4e-9e29-4d00-baea-dea8a9794b73","title":"Inheritance","content":"Supertypes Subtypes  "},"references/eClassifiers/DocumentedNamedCompositeConnectionTarget/index.html":{"action-uuid":"57e04139-c039-45d4-a182-8fe0ee57081e","title":"Documented Named Composite Connection Target","content":"Composite connection target with a name and documentation"},"references/eClassifiers/DocumentedNamedConnection/index.html":{"action-uuid":"f419d35a-efbb-4776-b2ae-57cbae5dcfa9","title":"Documented Named Connection","content":"Connection with a name and documentation"},"references/eClassifiers/Tunnel/inheritance.html":{"path":"Tunnel/Inheritance","action-uuid":"6dcd31b4-895d-4017-b7c9-565b49faeb28","title":"Inheritance","content":"Supertypes Subtypes  "},"references/eClassifiers/Tunnel/references/eStructuralFeatures/connections/index.html":{"path":"Tunnel/References/connections","action-uuid":"619ab1b4-a935-4b8d-a5b2-e63ddc30e9e5","title":"connections","content":"Connections in this tunnel"},"references/eClassifiers/CompositeNode/index.html":{"action-uuid":"3a15e944-e920-4a45-ae79-806542202f09","title":"Composite Node","content":"Node which is also a sub-graph. I.e. it may contain other graph elements."},"references/eClassifiers/DocumentedNamedNode/inheritance.html":{"path":"Documented Named Node/Inheritance","action-uuid":"a2021ce1-c090-4cee-a527-9e86c753cdf8","title":"Inheritance","content":"Supertypes Subtypes  "},"references/eClassifiers/DocumentedNamedGraphElement/inheritance.html":{"path":"Documented Named Graph Element/Inheritance","action-uuid":"c6fdeed9-8ded-4738-a2fd-ae06ee8599a8","title":"Inheritance","content":"Supertypes Subtypes  "},"references/eClassifiers/DocumentedNamedSubGraph/index.html":{"action-uuid":"730bd1d7-db62-414a-bf08-97dd0b015839","title":"Documented Named Sub-Graph","content":"Sub-graph with a name and documentation"},"index.html":{"action-uuid":"0ac7b6e0-4cd4-4d5e-ac16-af4e9854e985","title":"Graph Model","content":"Nasdanika graph model provides base classes (building blocks) for graph-like models such as process/flow and architecture models. The below diagram shows some of the model classes: Graph is a container of graph elements: Connection source - source and container of connections Connection target Sub-graph - both graph element and graph, allows to nest graphs Node is both connection source and connection target. I.e. it may have both outgoing and incoming connections. Then there are Composite flavors of connection source, connection target and node - they are also sub-graphs, i.e. may contain other graph elements. There is an aggregate connection - Tunnel. Not shown on the diagram are Documented Named flavors of the above classes, including Documented Named Composite flavors. Adapting to graph Graph model elements can be adapted to Graph interfaces with org.nasdanika.graph.model.adapters.GraphAdapterFactory as shown below: GraphAdapterFactory graphAdapterFactory = new GraphAdapterFactory();  \nTransformer&lt;EObject,ElementAdapter&lt;?&gt;&gt; graphFactory = new Transformer&lt;&gt;(graphAdapterFactory); // Reflective creation\nProgressMonitor progressMonitor = new PrintStreamProgressMonitor();\nMap&lt;EObject, ElementAdapter&lt;?&gt;&gt; registry = graphFactory.transform(Collections.singleton(graph), false, progressMonitor);\n Once you have a graph you may create processors on top of it. elements Graph Graph Element Sub-Graph Connection Source Connection Target Node target Connection Tunnel Composite Connection Source Composite Connection Target Composite Node connections outgoing connections"},"references/eClassifiers/ConnectionTarget/references/eStructuralFeatures/incomingConnections/index.html":{"path":"Connection Target/References/incomingConnections","action-uuid":"fc4102e3-37bb-42b7-8f64-33f2c84a1ed3","title":"incomingConnections","content":"Incoming connections"},"references/eClassifiers/Graph/references/eStructuralFeatures/elements/index.html":{"path":"Graph/References/elements","action-uuid":"6d464e89-75bd-4d1f-9b5d-0cd04f4f6181","title":"elements","content":"Graph elements uniquely identified by a string. This allows to implement graph inheritance - deriving a graph from another graph by removing, adding and replacing graph elements similar to how inheritance works in object-oriented languages."},"references/eClassifiers/DocumentedNamedGraphElement/index.html":{"action-uuid":"3ebfa385-5d99-4546-b0bf-dc8f41cb9d19","title":"Documented Named Graph Element","content":"Gaph element with a name and documentation"},"references/eClassifiers/CompositeConnectionTarget/index.html":{"action-uuid":"1cdf4952-e5a5-4ae1-9bf3-453ffdba711c","title":"Composite Connection Target","content":"Connection target which is also as sub-graph, i.e. it may contain other graph elements"},"references/eClassifiers/DocumentedNamedCompositeConnectionSource/index.html":{"action-uuid":"181570e0-9ee9-4f40-911f-050df0cc5629","title":"Documented Named Composite Connection Source","content":"Composite connection source with a name and documentation"},"references/eClassifiers/DocumentedNamedCompositeConnectionTarget/inheritance.html":{"path":"Documented Named Composite Connection Target/Inheritance","action-uuid":"097ceb65-a532-4963-b246-97c804a409e0","title":"Inheritance","content":"Supertypes "},"demo/living-beings/index.html":{"action-uuid":"cfbf4e89-1def-4bd4-b20e-9cb88352992d","title":"LIVING BEINGS","content":" Mammal Insect Bird Fish Bacteria Fungi Flower Ant Dolphin Lion Elephant Cat Giraffe Dog Donkey Leopard Horse Zebra Gazelle Bee Hornet Fly Termite Mantis Ladybug Butterfly Flea Mosquito Spider Bumblebee Eagle Pigeon Hawk Falcon Sparrow Stork Flamingo Penguin Owl Albatross Pelican Swallow Perch Mackerel Tuna Shark Whale Bass Eel Ray Trout Catfish Streptococcus Echericia Colli Lactobacyllus Helicobacter Bifidobacterium Staphyllococcus Zygomycota Script Writing Ascomycota Basidiomycota Mushroom Lichen Bread Mold Yeast Zygospore Truffle Chytrid Philadendron Dahlia Petunia Cactus Tulip Lilac Dandelion Poppy Gerbera Orchid Gladiola Rose LIVING BEINGS Tree Organisation Oak Birch Silverfern Personal Development Pine Lime Chestnut Beech Poplar Willow Acacia Mammal Insect Bird Fish Bacteria Fungi Flower Ant Dolphin Lion Elephant Cat Giraffe Dog Donkey Leopard Horse Zebra Gazelle Bee Hornet Fly Termite Mantis Ladybug Butterfly Flea Mosquito Spider Bumblebee Eagle Pigeon Hawk Falcon Sparrow Stork Flamingo Penguin Owl Albatross Pelican Swallow Perch Mackerel Tuna Shark Whale Bass Eel Ray Trout Catfish Streptococcus Echericia Colli Lactobacyllus Helicobacter Bifidobacterium Staphyllococcus Zygomycota Script Writing Ascomycota Basidiomycota Mushroom Lichen Bread Mold Yeast Zygospore Truffle Chytrid Philadendron Dahlia Petunia Cactus Tulip Lilac Dandelion Poppy Gerbera Orchid Gladiola Rose LIVING BEINGS Tree Organisation Oak Birch Silverfern Personal Development Pine Lime Chestnut Beech Poplar Willow Acacia"},"demo/living-beings/glossary.html":{"action-uuid":"bf256875-83c4-4d94-bd32-d439811df6eb","title":"Glossary","content":"Clear Identifier(s) Hide UUID {{data.value.name}} {{data.value[0].value}} {{item.value}}"},"references/eClassifiers/DocumentedNamedConnectionTarget/inheritance.html":{"path":"Documented Named Connection Target/Inheritance","action-uuid":"71e31efd-9f7a-4347-8c7c-be780b13f9e0","title":"Inheritance","content":"Supertypes Subtypes  "},"references/eClassifiers/CompositeConnectionSource/inheritance.html":{"path":"Composite Connection Source/Inheritance","action-uuid":"4bdb7e4a-b780-4051-9dd4-dd157c6bb104","title":"Inheritance","content":"Supertypes Subtypes  "},"references/eClassifiers/Node/index.html":{"action-uuid":"1080213f-65a3-4907-8b11-f13b43cb9406","title":"Node","content":"Node is both connection source and target. I.e. it may have both incoming and outgoing connections."},"references/eClassifiers/DocumentedNamedGraph/index.html":{"action-uuid":"2968c10a-370f-4c33-94b2-e45ee1527459","title":"Documented Named Graph","content":"Graph with a name and documentation"},"references/eClassifiers/DocumentedNamedTunnel/inheritance.html":{"path":"Documented Named Tunnel/Inheritance","action-uuid":"37969c04-3ac1-476c-b52f-85f55e3b9b2b","title":"Inheritance","content":"Supertypes "},"references/eClassifiers/Tunnel/index.html":{"action-uuid":"45fd9bb1-6f52-448d-bc4f-9e303f5f1fff","title":"Tunnel","content":"Tunnel is a connection which logically groups (aggregates) other connections. For example, two composite nodes may have a tunnel connection which groups connections between their child elements. A real life example is a VPN tunnel between two networks."},"references/eClassifiers/Node/inheritance.html":{"path":"Node/Inheritance","action-uuid":"f9bcbeeb-6a1a-4397-b419-c4d1159697ef","title":"Inheritance","content":"Supertypes Subtypes  "},"references/eClassifiers/DocumentedNamedGraph/inheritance.html":{"path":"Documented Named Graph/Inheritance","action-uuid":"16da2b95-5339-4901-9d7b-6cb4aa2768b3","title":"Inheritance","content":"Supertypes "},"references/eClassifiers/DocumentedNamedConnectionTarget/index.html":{"action-uuid":"ebb4697a-e201-43df-b4e9-f547168fce97","title":"Documented Named Connection Target","content":"Connection target with a name and documentation"},"references/eClassifiers/Graph/inheritance.html":{"path":"Graph/Inheritance","action-uuid":"6ac8a811-85a5-4a2c-9642-9b00d0606b40","title":"Inheritance","content":"Subtypes "},"references/eClassifiers/CompositeConnectionTarget/inheritance.html":{"path":"Composite Connection Target/Inheritance","action-uuid":"c6a09b48-b461-456c-8183-77ad47ec603a","title":"Inheritance","content":"Supertypes "},"references/eClassifiers/ConnectionTarget/index.html":{"action-uuid":"e7cd5d96-2d8c-4e0d-ab47-9aade4e5c564","title":"Connection Target","content":"A graph element which can have incoming connections"},"references/eClassifiers/GraphElement/inheritance.html":{"path":"Graph Element/Inheritance","action-uuid":"daf2c78e-0459-4544-b973-87542d4dea07","title":"Inheritance","content":"Supertypes Subtypes  "},"references/eClassifiers/Connection/inheritance.html":{"path":"Connection/Inheritance","action-uuid":"e196b67f-73e3-42de-8276-a5777545c88a","title":"Inheritance","content":"Supertypes Subtypes  "},"references/eClassifiers/DocumentedNamedCompositeNode/inheritance.html":{"path":"Documented Named Composite Node/Inheritance","action-uuid":"b9243faf-9a7f-4e92-8b24-64420b2c7ee9","title":"Inheritance","content":"Supertypes "},"references/eClassifiers/Connection/references/eStructuralFeatures/bidirectional/index.html":{"path":"Connection/Attributes/bidirectional","action-uuid":"13154ed3-3a2f-43d5-ab3a-7d58322d529a","title":"bidirectional","content":"Indicates that the connection is bidirectional"},"references/eClassifiers/SubGraph/inheritance.html":{"path":"Sub-graph/Inheritance","action-uuid":"10e3cd80-320a-4ae9-b113-227d63301be5","title":"Inheritance","content":"Supertypes Subtypes  "},"references/eClassifiers/Connection/references/eStructuralFeatures/target/index.html":{"path":"Connection/References/target","action-uuid":"eecb2771-d84e-450d-851d-762affc6a559","title":"target","content":"Connection target"},"references/eClassifiers/CompositeNode/inheritance.html":{"path":"Composite Node/Inheritance","action-uuid":"32d99baf-6d78-458f-a9fc-416262b47634","title":"Inheritance","content":"Supertypes Subtypes  "},"references/eClassifiers/ConnectionSource/inheritance.html":{"path":"Connection Source/Inheritance","action-uuid":"fe455115-deec-4592-bfa0-bea0c296ebbb","title":"Inheritance","content":"Supertypes Subtypes  "},"references/eClassifiers/DocumentedNamedCompositeNode/index.html":{"action-uuid":"8274857e-aea6-4437-a802-fee5b5ccc6a0","title":"Documented Named Composite Node","content":"Composite node with a name and documentation"},"references/eClassifiers/DocumentedNamedNode/index.html":{"action-uuid":"06b6122c-de72-4d4b-bc83-a65fe33f7d56","title":"Documented Named Node","content":"Node with a name and documentation"},"references/eClassifiers/SubGraph/index.html":{"action-uuid":"196d5e16-58c3-4d47-9413-7de8c0e23a8e","title":"Sub-graph","content":"A graph element which is also a graph, i.e. it may contain other graph elements."},"references/eClassifiers/GraphElement/index.html":{"action-uuid":"17fb506c-31bd-494b-9f22-d12f3c201286","title":"Graph Element","content":"Graph element uniquely identified in the containing graph by a string identifier (key). This allows to implement graph inheritance - deriving a graph from another graph by removing, adding and replacing graph elements similar to how inheritance works in object-oriented languages."},"references/eClassifiers/Graph/index.html":{"action-uuid":"23a28465-4ae8-44be-b16d-27771690a17d","title":"Graph","content":"Graph is a container of graph elements uniquely identified by a string. This allows to implement graph inheritance - deriving a graph from another graph by removing, adding and replacing graph elements similar to how inheritance works in object-oriented languages."},"demo/graph/search.html":{"action-uuid":"dbf24b34-ec5c-4c4a-b984-23db41c0dc78","title":"Search","content":"Clear"},"references/eClassifiers/CompositeConnectionSource/index.html":{"action-uuid":"ec052efd-3414-4e64-8117-bacf3c16afc0","title":"Composite Connection Source","content":"Connection source which is also a sub-graph. I.e. it may contain other graph elements."},"glossary.html":{"action-uuid":"013523f6-7c99-4773-bb0a-928e9fa34f74","title":"Glossary","content":"Clear Identifier(s) Hide UUID {{data.value.name}} {{data.value[0].value}} {{item.value}}"},"references/eClassifiers/ConnectionSource/references/eStructuralFeatures/outgoingConnections/index.html":{"path":"Connection Source/References/outgoingConnections","action-uuid":"cee205e0-052a-4d1d-b995-f61cd3611e42","title":"outgoingConnections","content":"Outgoing connections uniquely identified by a string to support graph inheritance"},"demo/living-beings/search.html":{"action-uuid":"3ee36050-229e-40d9-bcb7-ce1a247e1060","title":"Search","content":"Clear"},"references/eClassifiers/DocumentedNamedTunnel/index.html":{"action-uuid":"f4f08c13-211f-4be0-93d1-2df2d9d50832","title":"Documented Named Tunnel","content":"Tunnel with a name and documentation"},"references/eClassifiers/Connection/index.html":{"action-uuid":"e5d5f6d1-7d3c-4dd3-a986-8d9d57c23249","title":"Connection","content":"Connections are contained by their source and uniquiely identified in the source by a string id. This allows to implement connection inheritance behaviors such as overriding (replacing), adding, or removing."},"references/eClassifiers/DocumentedNamedSubGraph/inheritance.html":{"path":"Documented Named Sub-Graph/Inheritance","action-uuid":"32945d5c-8530-409d-a974-1c90d69e1b13","title":"Inheritance","content":"Supertypes Subtypes  "},"references/eClassifiers/DocumentedNamedCompositeConnectionSource/inheritance.html":{"path":"Documented Named Composite Connection Source/Inheritance","action-uuid":"e886ae8b-c4c9-4142-911d-ba0cbac32c57","title":"Inheritance","content":"Supertypes "},"references/eClassifiers/DocumentedNamedConnectionSource/inheritance.html":{"path":"Documented Named Connection Source/Inheritance","action-uuid":"8f6d9994-afd6-465b-9105-e79aeb133cf9","title":"Inheritance","content":"Supertypes Subtypes  "},"references/eClassifiers/DocumentedNamedConnection/inheritance.html":{"path":"Documented Named Connection/Inheritance","action-uuid":"124704b5-7b0d-4385-b86d-ee13e07f57ad","title":"Inheritance","content":"Supertypes Subtypes  "}}