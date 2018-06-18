# Service Catalog Java API
---

## Features

- Java DSL that provides access to Service Catalog resources
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
