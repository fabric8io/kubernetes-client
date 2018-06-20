# Service Catalog Java API
---

## Features

- Java DSL that provides access to Service Catalog resources
- Mock Service Catalog API Server for integration testing
- Works on top of the fabric8 kubernetes-client

## Usage

Throughout the usage section code samples will be provided. The code samples are going to use the following naming conventions:

- `sc` The Service Catalog client instance
- `kc` The Fabric8 Kubernetes client instance


### Configuring the client

There are two ways of creating an instance of the service catalog client.
- adapting from an existing instance of `KubernetesClient`
- manual configuration and instanctiation

#### Adapting

When the Service Catalog API is provided by the same API server as the Kubernetes API (both APIs are proxied together), you can easily adapt an existing 
`KubernetesClient` instance.

    KubernetesClient kc = new DefaultKubernetesClient();
    ServiceCatalogClient sc = kc.adapt(ServiceCatalogClient.class);
    
This approach is pretty easy, but it can only work if the topology requirements explained above are satisfied. If not, the client needs to be configured manually.

#### Manual Configuration

To manually instantiate the client, you just needs to create a configuration object, that specifies at least the url of the service catalog api server and a way to authenticate to it.
These may be specified:


- explicitly
    - via the `io.fabric8io.kubernetes.client.Config` DSL
- implicitly
    - using system properties
    - using env variables
    - using `~/.kube/confg`
    

##### Using the Config DSL

      import io.fabric8.kubernetes.client.Config;
      import io.fabric8.kubernetes.client.ConfigBuilder;
      
      ...
      
      Config config = new ConfigBuilder().withMasterUrl("https://url.to.servica.catalog.api.server")
          .withOautToken("sometoken")
          .build();
          
      ServiceCatalogClient sc = new DefaultServiceCatalogClient(config);
      

### Manipulating Resources

#### Cluster Service Broker

In order to create an existing Cluster Service Broker given a broker URL:
    
      ClusterServiceBroker broker = sc.clusterServiceBrokers().createNew()
          .withNewMetadata()
          .withName("mybroker")
          .endMetadata()
          .withNewSpec()
          .withURL("http://url.to.service.broker")
          .endSpec()
          .done();

To list all available service brokers:

      ClusterServiceBrokerList list = sc.clusterServiceBrokers().list();
      list.getItems().stream()
          .map(b->b.getMetadata().getName())
          .forEach(System.out::println);
          
         
To remove an existing broker:

      if(sc.clusterServiceBrokers().withName("mybroker").delete()) {
          System.out.println("Broker successfully deleted!");


#### Cluster Service Class

To list all available cluster service classes:

      ClusterServiceClassList list = sc.clusterServiceClasses().list();
      list.getItems().stream()
          .map(b -> b.getSpec().getClusterServiceBrokerName() + " " + b.getSpec().getExternalName())
          .forEach(System.out::println);


To list all classes of a particular broker (say "mybroker"):

      ClusterServiceClassList list = sc.clusterServiceClasses()
                                           .withField("spec.clusterServiceBrokerName", "mybroker")
                                           .list();
      list.getItems().stream()
          .map(b -> b.getSpec().getClusterServiceBrokerName() + " " + b.getSpec().getExternalName())
          .forEach(System.out::println);


#### Cluster Service Plans

      In the same spirit listing all cluster service plans:

      ClusterServicePlanList list = sc.clusterServicePlans().list();
      list.getItems().stream()
          .map(b -> b.getSpec().getClusterServiceBrokerName() + 
                    " " + 
                    b.getSpec().getExternalName() +
                    " " +
                    b.getSpec().getClusterServiceClassRef()
          .forEach(System.out::println);
 
 
#### Creating a Service Instance / Provisioning a Service

To provision a service of a particular class and plan:

        sc.serviceInstnaces().inNamespace("myns").createNew()
                .withNewMetadata()
                .withName("myserivce")
                .endMetadata()
                .withNewSpec()
                .withClusterServiceClassExternalName("myclass")
                .withClusterServicePlanExternalName("default")
                .endSpec()
                .build());


The service can be removed at any time:


        if (sc.serviceInstnaces().inNamespace("myns").withName("myservice").delete()) {
            System.out.println("Service was successfully deleted!");
        }
        
        
#### Creating a Service Binding

        ServiceBinding binding = sc.serviceBindings().inNamespace("iocanel").createNew()
            .withNewMetadata()
            .withName("mybinding")
            .endMetadata()
            .withNewSpec()
            .withNewServiceInstanceRef("myservice")
            .withSecretName("mysercret")
            .endSpec()
            .done();

### Using the Mock Server

The mock server module is built on top of [fabric8's mock web server](https://github.com/fabric8io/mockwebserver) which uses [okhttp](https://github.com/square/okhttp/tree/master/mockwebserver) under the hood.
To use it in your project:

    <dependency>
        <groupId>me.snowdrop</groupId>
        <artifactId>servicecatalog-mock</artifactId>
        <version>${servicecatalog.version}</version>
    </dependency>
    
The idea is simple, you create a Service Catalog API Mock Webserver instance and then you can get an instance of the client that is preconfigured to point at the mock server.
With the mock server you can either:

- use the mock server in crud mode
- set the expectations

#### CRUD mode
In this mode the server will use an in-memory backend in order to provide crud like functionality.
This way you can `create` resources using the client and the mock server will `remember` them and use them as a result in follow up `read`, `update` or `delete` operations.

It's the simplest possible way to do mock testing without messing with expectations.

The enable crud mode:

        @Rule
        public ServiceCatalogServer server = new ServiceCatalogServer(true, true); //arguments -> https:true, crud:true

The lifecycle of the server will be managed by junit (and thus the use of @org.junit.Rule).
From the server instance you can grab a client instance:

        ServiceCatalogClient client = server.getServiceCatalogClient();
                 
and with the client you can perform operations and assertions:

        assertNull("No resources have been created yet", client.clusterServiceBrokers().withName("broker1").get());
        
The above will be initially true as no resources have been created. But let's add a couple of resources:

    client.clusterServiceBrokers().createNew()
          .withNewMetadata()
              .withName("broker1")
          .endMetadata()
          .withNewSpec()
              .withUrl("https://url.to.broker1")
          .endSpec()
          .done();
          
         
     //And now it should be 'visible'    
     assertNotNull("ClusterServiceBroker was just created, but not foudn", client.clusterServiceBrokers().withName("broker1").get());
        

#### Setting expectations
For more sophisticated tests, you can set expectations, by using an EasyMock/Mockito/YouNameIt-like DSL.

    server.expect().get().withPath("/apis/servicecatalog.k8s.io/v1beta1/clusterservicebrokers/broker1").andReturn(200, broker1).onace();
    assertEquals(client.clusterServiceBrokers().get("broker1"), broker1);
  
For more details, please check the [iternal unit tests](https://github.com/snowdrop/service-catalog-java-api/tree/master/tests/src/test/java/me/snowdrop/servicecatalog/test).
