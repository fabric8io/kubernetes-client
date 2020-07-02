# Fabric8 Kubernetes Java Client Cheat Sheet

This document contains common usages of different resources using Fabric8 Kubernetes Client. 

## Table of Contents
* [Initializing Kubernetes Client](#initializing-kubernetes-client)

* [Kubernetes Client DSL Usage](#kubernetes-client-dsl-usage)
  * [Pods](#pods)
  * [Service](#service)
  * [Deployment](#deployment)
  * [ReplicaSet](#replicaset)
  * [ReplicationController](#replicationcontroller)
  * [ConfigMap](#configmap)
  * [Secret](#secret)
  * [Job](#job)
  * [CronJob](#cronjob)
  * [Namespace](#namespace)
  * [ServiceAccount](#serviceaccount)
  * [Ingress](#ingress)
  * [StatefulSet](#statefulset)
  * [DaemonSet](#daemonset)
  * [PersistentVolumeClaim](#persistentvolumeclaim)
  * [PersistentVolume](#persistentvolume)
  * [NetworkPolicy](#networkpolicy)
  * [PodDisruptionBudget](#poddisruptionbudget)
  * [Top/Metrics](#fetching-metrics)
  * [Generic Resource API](#resource-api)
  * [Generic ResourceList API](#resourcelist-api)
  * [CustomResourceDefinition](#customresourcedefinition)
  * [CustomResource Typed API](#customresource-typed-api)
  * [CustomResource Typeless API](#customresource-typeless-api)
  * [SharedInformers](#sharedinformers)
  * [List Options](#list-options)
  * [Delete Options](#delete-options)
  * [Watch Options](#watch-options)

* [OpenShift Client DSL Usage](#openshift-client-dsl-usage)  
  * [Initializing OpenShift Client](#initializing-openshift-client)
  * [DeploymentConfig](#deploymentconfig)
  * [BuildConfig](#buildconfig)
  * [Route](#route)
  * [Project](#project)
  * [ImageStream](#imagestream)

* [Tekton Client](#tekton-client)
  * [Initializing Tekton Client](#initializing-tekton-client)
  * [Tekton Client DSL Usage](#tekton-client-dsl-usage)

* [Knative Client](#knative-client)
  * [Initializing Knative Client](#initializing-knative-client)
  * [Knative Client DSL Usage](#knative-client-dsl-usage)

### Initializing Kubernetes Client
Typically, we create Kubernetes Client like this:
```
try (final KubernetesClient client = new DefaultKubernetesClient()) {
  // Do stuff with client
}
```
This would pick up default settings, reading your `kubeconfig` file from `~/.kube/config` directory or whatever is defined inside `KUBECONFIG` environment variable. But if you want to customize creation of client, you can also pass a `Config` object inside `DefaultKubernetesClient` like this:
```
Config kubeConfig = new ConfigBuilder()
  .withMasterUrl("https://192.168.42.20:8443/")
  .build()
try (final KubernetesClient client = new DefaultKubernetesClient(config)) {
  // Do stuff with client
}
```
### Kubernetes Client DSL Usage
This section contains DSL usage for all the supported resources inside Kubernetes Client library. Although, it's the same for most of the resources. But still, we've added it:

#### Pods
`Pods` are available in our dsl via the `client.pods()`. Here are some of the common usages of `Pod` resource:
- Loading a `Pod` from a `yaml` file into `Pod` object:
```
Pod myPod = client.pods().load(new FileInputStream("some-pod.yml")).get();
```
- Listing all `Pod` objects in some specific namespace:
```
PodList podList = client.pods().inNamespace("default").list();
```
- List all `Pod` objects in all namespaces:
```
PodList podList = client.pods().inAnyNamespace().list();
```
- List `Pod` objects containing some labels:
```
PodList podList = client.pods().inNamespace("default").withLabel("foo", "bar").list();
```
- Get `Pod` from server with some specific name:
```
Pod myPod = client.pods().inNamespace("default").withName("nginx-pod").get();
```
- Create a `Pod`:
```
Pod aPod = new PodBuilder().withNewMetadata().withName("demo-pod1").endMetadata()
    .withNewSpec()
    .addNewContainer()
    .withName("nginx")
    .withImage("nginx:1.7.9")
    .addNewPort().withContainerPort(80).endPort()
    .endContainer()
    .endSpec()
    .build();
Pod createdPod = client.pods().inNamespace("default").create(aPod);
```
- Create or Replace some `Pod` with some existing object:
```
client.pods().inNamespace("default").createOrReplace(aPod);
```
- Create or Replace some `Pod` on the fly with `Builder`:
```
client.pods().inNamespace("default").createOrReplaceWithNew()
    .withNewMetadata().withName("demo-pod1").endMetadata()
    .withNewSpec()
    .addNewContainer()
    .withName("nginx")
    .withImage("nginx:1.7.9")
    .addNewPort().withContainerPort(80).endPort()
    .endContainer()
    .endSpec()
    .done();
```
- Edit a `Pod` object:
```
client.pods().inNamespace("default").withName("nginx").edit()
    .editOrNewMetadata().addToLabels("new","label").endMetadata().done()
```
- Get logs for `Pod` object:
```
String log = client.pods().inNamespace("default").withName("test-pod").getLog();
```
- Watch logs for `Pod`:
```
LogWatch watch = client.pods().inNamespace(namespace).withName(podName).tailingLines(10).watchLog(System.out);
```
- Delete a `Pod`:
```
Boolean isDeleted = client.pods().inNamespace("default").withName("nginx").delete();
```
- Delete multiple `Pod` objects:
```
Boolean isDeleted = client.pods().inNamespace("default").delete(pod1, pod2);
```
- Wait until a `Pod` is ready:
```
Pod pod = client.pods().inNamespace("default").withName("nginx").waitUntilReady(5, TimeUnit.MINUTES);
```
- Wait until `Pod` meets some specific condition:
```
Pod pod = client.pods().inNamespace("default").withName("nginx").waitUntilCondition(pod -> pod.getStatus().getPhase().equals("Succeeded"), 1, TimeUnit.MINUTES)
```
- Port Forward a `Pod`
```
int containerPort =  client.pods().inNamespace("default").withName("testpod").get().getSpec().getContainers().get(0).getPorts().get(0).getContainerPort();
LocalPortForward portForward = client.pods().inNamespace("default").withName("testpod").portForward(containerPort, 8080);
```
- Watching `Pod`:
```
final CountDownLatch deleteLatch = new CountDownLatch(1);
Watch watch = client.pods().withName("pod1").watch(new Watcher<Pod>() {
   @Override
   public void eventReceived(Action action, Pod resource) {
     switch (action) {
       case DELETED:
         deleteLatch.countDown();
       }
    }

    @Override
    public void onClose(KubernetesClientException cause) { }
});
deleteLatch.await(10, TimeUnit.MINUTES)
```
- Upload file into a `Pod`
```
    client.pods().inNamespace(currentNamespace).withName(pod1.getMetadata().getName())
      .file("/tmp/toBeUploaded").upload(tmpFile.toPath());
```
- Read file from a `Pod`
```
    try (InputStream is = client.pods().inNamespace(currentNamespace).withName(pod1.getMetadata().getName()).file("/msg").read())  {
      String result = new BufferedReader(new InputStreamReader(is)).lines().collect(Collectors.joining("\n"));
    }
```
- Using Kubernetes Client from within a `Pod`
When trying to access Kubernetes API from within a `Pod` authentication is done a bit differently as compared to when being done on your system. If you checkout [documentation](https://kubernetes.io/docs/tasks/access-application-cluster/access-cluster/#accessing-the-api-from-a-pod). Client authenticates by reading `ServiceAccount` from `/var/run/secrets/kubernetes.io/serviceaccount/` and reads environment variables like `KUBERNETES_SERVICE_HOST` and `KUBERNETES_SERVICE_PORT` for apiServer URL. You don't have to worry about all this when using Fabric8 Kubernetes Client. You can simply use it like this and client will take care of everything:
```
// reads serviceaccount from mounted volume and gets apiServer url from environment variables itself.
KubernetesClient client = new DefaultKubernetesClient();
```
You can also checkout a demo example here: [kubernetes-client-inside-pod](https://github.com/rohanKanojia/kubernetes-client-inside-pod)


#### Service
`Service` is available in Kubernetes client API via `client.services()`. Here are some common usages of `Service`:
- Loading a `Service` from yaml:
```
Service aService = client.services().load(new FileInputStream("service.yml")).get();
```
- Get a `Service` from API server:
```
Service service = client.services().inNamespace("default").withName("some-service").get();
```
- Create a `Service`:
```
Service createdSvc = client.services().inNamespace("default").create(svc);
```
- Create or Replace existing `Service`:
```
Service createdSvc = client.services().inNamespace("default").createOrReplace(svc);
```
- Create Or Replace existing `Service` using Builders:
```
Service createdSvc = client.services().inNamespace("default").createOrReplaceWithNew()
    .withNewMetadata().withName("svc2").endMetadata()
    .withNewSpec().withType("ExternalName").withExternalName("my.database.example.com")
    .addNewPort().withName("80").withProtocol("TCP").withPort(80).endPort()
    .endSpec()
    .withNewStatus()
    .withNewLoadBalancer()
    .addNewIngress()
    .withIp("146.148.47.155")
    .endIngress()
    .endLoadBalancer()
    .endStatus()
    .done();
```
- List all `Service` objects in some specific namespace:
```
ServiceList svcList = client.services().inNamespace("default").list();
```
- List all `Service` objects in any namespace:
```
ServiceList svcList = client.services().inAnyNamespace().list();
```
- List `Service` objects with some specific labels:
```
ServiceList svcList = client.services().inNamespace("default").withLabel("foo", "bar").list();
```
- Delete a `Service`:
```
Boolean isDeleted = client.services().inNamespace("default").withName("some-svc").delete();
```
- Watching a `Service`:
```
client.services().inNamespace("default").watch(new Watcher<Service>() {
    @Override
    public void eventReceived(Action action, Service resource) {
      // Perform something depending upon action
    }

    @Override
    public void onClose(KubernetesClientException cause) {

    }
});
```

#### Deployment
`Deployment` is available in Kubernetes-Client API via `client.apps().deployment()`. Here are some of the common usages of `Deployment`:
- Loading a `Deployment` from yaml into object:
```
Deployment aDeployment = client.apps().deployments().load(new FileInputStream("test-deployments.yml")).get();
```
- Get a `Deployment` from API server:
```
Deployment deploy = client.apps().deployments().inNamespace("default").withName("deploy-1").get();
```
- Create a `Deployment`:
```
Deployment deployment1 = new DeploymentBuilder()
   .withNewMetadata()
      .withName("deployment1")
      .addToLabels("test", "deployment")
   .endMetadata()
   .withNewSpec()
      .withReplicas(1)
      .withNewTemplate()
        .withNewMetadata()
        .addToLabels("app", "httpd")
        .endMetadata()
        .withNewSpec()
          .addNewContainer()
             .withName("busybox")
             .withImage("busybox")
             .withCommand("sleep","36000")
          .endContainer()
        .endSpec()
      .endTemplate()
      .withNewSelector()
        .addToMatchLabels("app","httpd")
      .endSelector()
   .endSpec()
 .build();

client.apps().deployments().inNamespace("default").create(deployment1);
```
- Create or Replace an existing `Deployment`:
```
Deployment createdDeployment = client.apps().deployments().inNamespace("default").createOrReplace(deployObj);
```
- Create or Replace an existing `Deployment` using builders:
```
client.apps().deployments().inNamespace("default").createOrReplaceWithNew()
   .withNewMetadata()
      .withName("deployment1")
      .addToLabels("test", "deployment")
   .endMetadata()
   .withNewSpec()
      .withReplicas(1)
      .withNewTemplate()
        .withNewMetadata()
        .addToLabels("app", "httpd")
        .endMetadata()
        .withNewSpec()
          .addNewContainer()
             .withName("busybox")
             .withImage("busybox")
             .withCommand("sleep","36000")
          .endContainer()
        .endSpec()
      .endTemplate()
      .withNewSelector()
        .addToMatchLabels("app","httpd")
      .endSelector()
   .endSpec()
 .done();
```
- List `Deployment` objects in some specific namespace:
```
DeploymentList aDeploymentList = client.apps().deployments().inNamespace("default").list();
```
- List `Deployment` objects in any namespace:
```
DeploymentList aDeploymentList = client.apps().deployments().inAnyNamespace().list();
```
- List `Deployment` objects with some specific labels:
```
DeploymentList aDeployList = client.apps().deployments().inNamespace("default").withLabel("foo", "bar").list();
```
- Editing a `Deployment`:
```
// Scales Deployment to 2 replicas
Deployment updatedDeploy = client.apps().deployments().inNamespace("default")
      .withName("deployment1").edit()
      .editSpec().withReplicas(2).endSpec().done();
```
- Update single container image inside `Deployment`:
```
Deployment updatedDeployment = client.apps().deployments().inNamespace("default").withName("ngix-controller")
			.rolling().updateImage("docker.io/nginx:latest");
```
- Update multiple container images inside `Deployment`:
```
Map<String, String> containerToImageMap = new HashMap<>();
containerToImageMap.put("nginx", "nginx:perl");
containerToImageMap.put("sidecar", "someImage:someVersion");
Deployment updatedDeployment = client.apps().deployments()
      .inNamespace("default")
      .withName("nginx-deployment")
      .rolling()
      .updateImage(containerToImageMap);

```
- Rollout restart a `Deployment`:
```
Deployment deployment = client.apps().deployments()
      .inNamespace("default")
      .withName("nginx-deployment")
      .rolling()
      .restart();
```
- Pause Rollout of a `Deployment`:
```
Deployment deployment = client.apps().deployments()
      .inNamespace("default")
      .withName("nginx-deployment")
      .rolling()
      .pause();
```
- Resume Rollout of a `Deployment`:
```
Deployment deployment = client.apps().deployments()
      .inNamespace("default")
      .withName("nginx-deployment")
      .rolling()
      .resume();
```
- Undo Rollout of a `Deployment`:
```
Deployment deployment = client.apps().deployments()
      .inNamespace("default")
      .withName("nginx-deployment")
      .rolling()
      .undo();
```
- Deleting a `Deployment`:
```
Boolean isDeleted = client.apps().deployments().inNamespace("default").withName("foo").delete();
```
- Watching a `Deployment`:
```
client.apps().deployments().inNamespace("default").watch(new Watcher<Deployment>() {
  @Override
  public void eventReceived(Action action, Deployment resource) {
    // Do stuff depending upon action
  }

  @Override
  public void onClose(KubernetesClientException cause) {

  }
});
```
- Scale a `Deployment`:
```
client.apps().deployments().inNamespace("default").withName("nginx-deployment").scale(1);
```
- Get `Deployment` logs:
```
client.apps().deployments().inNamespace("default").withName("nginx").watchLog(System.out);
```

#### ReplicaSet

`ReplicaSet` is available in Kubernetes Client using `client.apps().replicaSets()`. Here are some of the common examples of how to use `ReplicaSet` with Kubernetes Client api:
- Load a `ReplicaSet` object from yaml:
```
ReplicaSet replicaSet = client.apps().replicaSets().inNamespace("default")
  .load(new FileInputStream("test-replicaset.yml")).get();
```
- Get a `ReplicaSet` from API server:
```
ReplicaSet rs = client.apps().replicaSets().inNamespace("default").withName("rs1").get();
```
- Create a `ReplicaSet`:
```
ReplicaSet replicaset1 = new ReplicaSetBuilder()
      .withNewMetadata()
      .withName("replicaset1")
      .addToLabels("app", "guestbook")
      .addToLabels("tier", "frontend")
      .endMetadata()
      .withNewSpec()
      .withReplicas(1)
      .withNewSelector()
      .withMatchLabels(Collections.singletonMap("tier", "frontend"))
      .endSelector()
      .withNewTemplate()
      .withNewMetadata()
      .addToLabels("app", "guestbook")
      .addToLabels("tier", "frontend")
      .endMetadata()
      .withNewSpec()
      .addNewContainer()
      .withName("busybox")
      .withImage("busybox")
      .withCommand("sleep","36000")
      .withNewResources()
      .withRequests(requests)
      .endResources()
      .withEnv(envVarList)
      .endContainer()
      .endSpec()
      .endTemplate()
      .endSpec()
      .build();

client.apps().replicaSets().inNamespace("default").create(replicaset1);
```
- Create or Replace an existing `ReplicaSet`:
```
ReplicaSet rs = client.apps().replicaSets().inNamespace("default").createOrReplace(replicaSet);
```
- Create or Replace `ReplicaSet` with new builders:
```
ReplicaSet rs = client.apps().replicaSets().inNamespace("default").createOrReplaceWithNew()
        .withNewMetadata()
        .withName("replicaset1")
        .addToLabels("app", "guestbook")
        .addToLabels("tier", "frontend")
        .endMetadata()
        .withNewSpec()
        .withReplicas(1)
        .withNewSelector()
        .withMatchLabels(Collections.singletonMap("tier", "frontend"))
        .endSelector()
        .withNewTemplate()
        .withNewMetadata()
        .addToLabels("app", "guestbook")
        .addToLabels("tier", "frontend")
        .endMetadata()
        .withNewSpec()
        .addNewContainer()
        .withName("busybox")
        .withImage("busybox")
        .withCommand("sleep","36000")
        .withNewResources()
        .withRequests(requests)
        .endResources()
        .withEnv(envVarList)
        .endContainer()
        .endSpec()
        .endTemplate()
        .endSpec()
        .done();
```
- List `ReplicaSet` objects in some namespace:
```
ReplicaSetList rsList = client.apps().replicaSets().inNamespace("default").list();
```
- List `ReplicaSet` objects in any namespace:
```
ReplicaSetList rsList = client.apps().replicaSets().inAnyNamespace().list();
```
- List `ReplicaSet` objects in some namespace with some labels:
```
ReplicaSetList rsList = client.apps().replicaSets().inNamespace("default").withLabel("foo", "bar").list(); 
```
- Delete `ReplicaSet`:
```
Boolean isDeleted = client.apps().replicaSets().inNamespace("default").withName("rs1").delete();
```
- Watch `ReplicaSet`:
```
client.apps().replicaSets().inNamespace("default").watch(new Watcher<ReplicaSet>() {
   @Override
   public void eventReceived(Action action, ReplicaSet resource) {
     // Do some stuff depending upon action type
   }

   @Override
   public void onClose(KubernetesClientException cause) {

   }
});
```
- Scale `ReplicaSet`
```
// Scale to 3 replicas
client.apps().replicaSets().inNamespace("default").withName("nginx-rs").scale(3);
```
- Update Image in `ReplicaSet`
```
ReplicaSet replicaSet = client.apps().replicaSets()
            .inNamespace("default")
            .withName("soaktestrs")
            .rolling()
            .updateImage("nickchase/soaktest");
```
- Update multiple Images in `ReplicaSet`:
```
Map<String, String> containerToImageMap = new HashMap<>();
containerToImageMap.put("c1", "image1");
containerToImageMap.put("c2", "image2");
ReplicaSet replicaSet = client.apps().replicaSets()
            .inNamespace("default")
            .withName("soaktestrs")
            .rolling()
            .updateImage(containerToImageMap);
```

### ReplicationController

`ReplicationController` resource is available in Kubernetes API using the `client.replicationControllers()`. Here are some of the examples of it's common usage:
- Load `ReplicationController` object from yaml:
```
ReplicationController aReplicationController = client.replicationControllers().inNamespace("default")
      .load(new FileInputStream("/test-replicationcontroller.yml")).get();
```
- Get `ReplicationController` object from API server:
```
ReplicationController rc = client.replicationControllers().inNamespace("default").withName("nginx-controller").get();
```
- Create `ReplicationController` object:
```
ReplicationController rc1 = new ReplicationControllerBuilder()
  .withNewMetadata().withName("nginx-controller").addToLabels("server", "nginx").endMetadata()
  .withNewSpec().withReplicas(3)
  .withNewTemplate()
  .withNewMetadata().addToLabels("server", "nginx").endMetadata()
  .withNewSpec()
  .addNewContainer().withName("nginx").withImage("nginx")
  .addNewPort().withContainerPort(80).endPort()
  .endContainer()
  .endSpec()
  .endTemplate()
  .endSpec().build();

ReplicationController rc = client.replicationControllers().inNamespace("default").create(rc1);
```
- Create or Replace an existing `ReplicationController`:
```
ReplicationController rc = client.replicationControllers().inNamespace("default").createOrReplace(rc1);
``` 
- Create or Replace with builder:
```
ReplicationController rc = client.replicationControllers().inNamespace("default").createOrReplaceWithNew()
  .withNewMetadata().withName("nginx-controller").addToLabels("server", "nginx").endMetadata()
  .withNewSpec().withReplicas(3)
  .withNewTemplate()
  .withNewMetadata().addToLabels("server", "nginx").endMetadata()
  .withNewSpec()
  .addNewContainer().withName("nginx").withImage("nginx")
  .addNewPort().withContainerPort(80).endPort()
  .endContainer()
  .endSpec()
  .endTemplate()
  .endSpec().done();
```
- List `ReplicationController` object in some namespace:
```
ReplicationControllerList rcList = client.replicationControllers().inNamespace("default").list();
```
- List `ReplicationController` objects in any namespace:
```
ReplicationControllerList rcList = client.replicationControllers().inAnyNamespace("default").list();
```
- List `ReplicationController` objects in some namespace with some label:
```
ReplicationControllerList rcList = client.replicationControllers().inNamespace("default").withLabel("foo", "bar").list();
```
- Delete `ReplicationController`:
```
Boolean isDeleted = client.replicationControlers().inNamespace("default").withName("nginx-controller").delete();
```
- Watch `ReplicationController` in some specific namespace:
```
client.replicationControllers().inNamespace(currentNamespace).watch(new Watcher<ReplicationController>() {
  @Override
  public void eventReceived(Action action, ReplicationController resource) {
    // Do something depending upon action type    
  }

  @Override
  public void onClose(KubernetesClientException cause) {

  }
});
```
- Scale `ReplicationController`:
```
ReplicationController rc = client.replicationControllers().inNamespace("default").withName("nginx-controller").scale(2);
```
- Update image in `ReplicationController`:
```
ReplicationController rc = client.replicationControllers()
       .inNamespace("default")
       .withName("nginx")
       .rolling()
       .updateImage("nginx:latest");
```
- Update multiple images in `ReplicationController`:
```
Map<String, String> containerToImageMap = new HashMap<>();
containerToImageMap.put("c1", "image1");
containerToImageMap.put("c2", "image2");
ReplicationController rc = client.replicationControllers()
       .inNamespace("default")
       .withName("nginx")
       .rolling()
       .updateImage(controllerToImageMap);
```

### ConfigMap
`ConfigMap` resource is available in Kubernetes Client api via the `client.configMaps()`. Here are some examples of common usage:
- Load `ConfigMap` object from yaml:
```
ConfigMap configMap = client.configMaps().load(new FileInputStream("configmap1.yml")).get();
```
- Get `ConfigMap` from API server:
```
ConfigMap configMap = client.configMaps().inNamespace("default").withName("configmap1").get();
```
- Create `ConfigMap`:
```
ConfigMap configMap1 = new ConfigMapBuilder()
      .withNewMetadata().withName("configmap1").endMetadata()
      .addToData("1", "one")
      .addToData("2", "two")
      .addToData("3", "three")
      .build();
ConfigMap configMap = client.configMaps().inNamespace("default").create(configMap1);
```
- Create or Replace some existing `ConfigMap`:
```
ConfigMap configMap = client.configMaps().inNamespace("default").createOrReplace(configMap1);
```
- Create or Replace some `ConfigMap` with builders:
```
ConfigMap configMap = client.configMaps().inNamespace("default").createOrReplaceWithNew()
      .withNewMetadata().withName("configmap1").endMetadata()
      .addToData("1", "one")
      .addToData("2", "two")
      .addToData("3", "three")
      .done();
```
- List `ConfigMap` objects in some namespace:
```
ConfigMapList configMapList = client.configMaps().inNamespace("default").list();
```
- List `ConfigMap` objects in any namespace:
```
ConfigMapList configMapList = client.configMaps().inAnyNamespace().list();
```
- List `ConfigMap` objects in some namespace with some labels:
```
ConfigMapList configMapList = client.configMaps().inNamespace("default").withLabel("foo", "bar").list();
```
- Delete `ConfigMap`:
```
Boolean isDeleted = client.configMaps().inNamespace("default").withName("configmap1").delete();
```
- Watch `ConfigMap`:
```
client.configMaps().inNamespace("default").watch(new Watcher<ConfigMap>() {
  @Override
  public void eventReceived(Action action, ConfigMap resource) {
    // Do something depending upon action type    
  }

  @Override
  public void onClose(KubernetesClientException cause) {

  }
});
```
- Update `ConfigMap`:
```
ConfigMap configMap1 = client.configMaps().inNamespace(currentNamespace).withName("configmap1").edit()
      .addToData("4", "four").done();
```

### Secret

`Secret` resource is available in Kubernetes Client api via `client.secrets()`. Here are some of the examples of it's common usages:
- Load `Secret` from yaml:
```
Secret aSecret = client.secrets().inNamespace("default").load(new FileInputStream("test-secret.yml")).get();
```
- Get a `Secret` from API server:
```
Secret secret = client.secrets().inNamespace("default").withName("secret1").get()
```
- Create a `Secret`:
```
Secret secret1 = new SecretBuilder()
      .withNewMetadata().withName("secret1").endMetadata()
      .addToData("username", "guccifer")
      .addToData("password", "shadowgovernment")
      .build();
Secret secretCreated = client.secrets().inNamespace("default").create(secret1);
```
- Create or Replace an existing `Secret`:
```
Secret createdSecret = client.secrets().inNamespace("default").createOrReplace(secret1);
```
- Create or Replace `Secret` with builder:
```
Secret createdSecret = client.secrets().inNamespace("default").createOrReplaceWithNew()
      .withNewMetadata().withName("secret1").endMetadata()
      .addToData("username", "guccifer")
      .addToData("password", "shadowgovernment")
      .done();
```
- List `Secret` resources in some namespace:
```
SecretList secretList = client.secrets().inNamespace("default").list();
```
- List `Secret` resources in any namespace:
```
SecretList secretList = client.secrets().inAnyNamespace().list();
```
- List `Secret` resources in some namespace with some label:
```
SecretList secretList = client.secrets().inNamespace("default").withLabel("foo", "bar").list();
```
- Edit `Secret`:
```
Secret secret1 = client.secrets().inNamespace(currentNamespace).withName("secret1").edit()
      .withType("Opaque")
      .done();
```
- Delete `Secret`:
```
Boolean isDeleted = client.secrets().inNamespace("default").withName("secret1").delete();
```
- Watch `Secret`:
```
    client.secrets().inNamespace("default").watch(new Watcher<Secret>() {
      @Override
      public void eventReceived(Action action, Secret resource) {
        // Do something depending upon action type
      }

      @Override
      public void onClose(KubernetesClientException cause) {

      }
    });
```

### Job
`Job` resource is available in Kubernetes Client API via `client.batch().jobs()`. Here are some of the examples of common usage:
- Loading a `Job` from yaml:
```
Job job = client.batch().jobs().load(new FileInputStream("sample-job.yml")).get();
```
- Get a `Job` resource with some name from API server:
```
Job job = client.batch().jobs().inNamespace("default").withName("pi").get();
```
- Create `Job`:
```
final Job job = new JobBuilder()
    .withApiVersion("batch/v1")
    .withNewMetadata()
    .withName("pi")
    .withLabels(Collections.singletonMap("label1", "maximum-length-of-63-characters"))
    .withAnnotations(Collections.singletonMap("annotation1", "some-very-long-annotation"))
    .endMetadata()
    .withNewSpec()
    .withNewTemplate()
    .withNewSpec()
    .addNewContainer()
    .withName("pi")
    .withImage("perl")
    .withArgs("perl", "-Mbignum=bpi", "-wle", "print bpi(2000)")
    .endContainer()
    .withRestartPolicy("Never")
    .endSpec()
    .endTemplate()
    .endSpec()
    .build();

client.batch().jobs().inNamespace("default").create(job);
```
- Create or Replace an existing `Job`:
```
Job job = client.batch().jobs().inNamespace("default").createOrReplace(job);
```
- Create or Replace an existing `Job` with builder:
```
Job job = client.batch().jobs().inNamespace("default").createOrReplaceWithNew()
    .withApiVersion("batch/v1")
    .withNewMetadata()
    .withName("pi")
    .withLabels(Collections.singletonMap("label1", "maximum-length-of-63-characters"))
    .withAnnotations(Collections.singletonMap("annotation1", "some-very-long-annotation"))
    .endMetadata()
    .withNewSpec()
    .withNewTemplate()
    .withNewSpec()
    .addNewContainer()
    .withName("pi")
    .withImage("perl")
    .withArgs("perl", "-Mbignum=bpi", "-wle", "print bpi(2000)")
    .endContainer()
    .withRestartPolicy("Never")
    .endSpec()
    .endTemplate()
    .endSpec()
    .done();
```
- List `Job` in some namespace:
```
JobList jobList = client.batch().jobs().inNamespace("default").list();
```
- List `Job` in any namespace:
```
JobList jobList = client.batch().jobs().inAnyNamespace().list();
```
- List `Job` resources in some namespace with some labels:
```
JobList jobList = client.batch().jobs().inNamespace("default").withLabel("foo", "bar").list();
```
- Delete `Job`:
```
Boolean isDeleted = client.batch().jobs().inNamespace("default").withName("pi").delete();
```
- Watch `Job`:
```
  client.batch().jobs().inNamespace("default").watch(new Watcher<Job>() {
    @Override
    public void eventReceived(Action action, Job resource) {
      // Do something depending upon action 
    }

    @Override
    public void onClose(KubernetesClientException cause) {

    }
  })
```

### CronJob
`CronJob` resource is available in Kubernetes Client api via `client.batch().cronjobs()`. Here are some of the examples of its usages:
- Load `CronJob` from yaml:
```
CronJob cronJob = client.batch().cronjobs().load(new FileInputStream("cronjob.yml")).get();
```
- Get a `CronJob` from Kubernetes API server:
```
CronJob aCronJob = client.batch().cronjobs().inNamespace("default").withName("some-cj").get();
```
- Create `CronJob`:
```
CronJob cronJob1 = new CronJobBuilder()
    .withApiVersion("batch/v1beta1")
    .withNewMetadata()
    .withName("hello")
    .withLabels(Collections.singletonMap("foo", "bar"))
    .endMetadata()
    .withNewSpec()
    .withSchedule("*/1 * * * *")
    .withNewJobTemplate()
    .withNewSpec()
    .withNewTemplate()
    .withNewSpec()
    .addNewContainer()
    .withName("hello")
    .withImage("busybox")
    .withArgs("/bin/sh", "-c", "date; echo Hello from Kubernetes")
    .endContainer()
    .withRestartPolicy("OnFailure")
    .endSpec()
    .endTemplate()
    .endSpec()
    .endJobTemplate()
    .endSpec()
    .build();

cronJob1 = client.batch().cronjobs().inNamespace("default").create(cronJob1);
```
- Create or Replace an existing `CronJob`:
```
CronJob cronJob = client.batch().cronjobs().inNamespace("default").createOrReplace(cronJob1);
```
- Create or Replace `CronJob` with builders:
```
CronJob cronJob = client.batch().cronjobs().inNamespace("default").createOrReplaceWithNew()
    .withApiVersion("batch/v1beta1")
    .withNewMetadata()
    .withName("hello")
    .withLabels(Collections.singletonMap("foo", "bar"))
    .endMetadata()
    .withNewSpec()
    .withSchedule("*/1 * * * *")
    .withNewJobTemplate()
    .withNewSpec()
    .withNewTemplate()
    .withNewSpec()
    .addNewContainer()
    .withName("hello")
    .withImage("busybox")
    .withArgs("/bin/sh", "-c", "date; echo Hello from Kubernetes")
    .endContainer()
    .withRestartPolicy("OnFailure")
    .endSpec()
    .endTemplate()
    .endSpec()
    .endJobTemplate()
    .endSpec()
    .done();
```
- List some `CronJob` objects in some namespace:
```
CronJobList cronJobList = client.batch().cronjobs().inNamespace("default").list()
```
- List some `CronJob` objects in any namespace:
```
CronJobList cronJobList = client.batch().cronjobs().inAnyNamespace().list();
```
- List some `CronJob` objects in some namespace with some label:
```
CronJobList cronJobList = client.batch().cronjobs().inNamespace("default").withLabel("foo", "bar").list();
```
- Edit/Update `CronJob`:
```
CronJob cronJob1 = client.batch().cronjobs().inNamespace("default").withName(cronJob1.getMetadata().getName())
      .edit()
      .editSpec()
      .withSchedule("*/1 * * * *")
      .endSpec()
      .done();
```
- Delete `CronJob`:
```
Boolean isDeleted = client.batch().cronjobs().inNamespace("default").withName("pi").delete();
```

### Namespace
`Namespace` is available in Kubernetes Client API via `client.namespaces()`. Here are some of the common usages:
- Load `Namespace` from yaml:
```
Namespace namespace = client.namespaces().load(new FileInputStream("namespace-test.yml")).get();
```
- Get `Namespace` from Kubernetes API server:
```
Namespace namespace = client.namespaces().withName("namespace1").get();
```
- List `Namespace` objects:
```
NamespaceList namespaceList = client.namespaces().list();
```
- List `Namespace` objects with some labels:
```
NamespaceList namespaceList = client.namespaces().withLabel("key1", "value1").list();
```
- Delete `Namespace` objects:
```
Boolean isDeleted = client.namespaces().withName("ns1").delete();
```

### ServiceAccount
`ServiceAccount` resource is available in Kubernetes Client API via `client.serviceAccounts()`. Here are some examples of it's usage:
- Load `ServiceAccount` from yaml:
```
ServiceAccount svcAccount = client.serviceAccounts().inNamespace("default")
  .load(new FileInputStream("sa.yml")).get();
```
- Get `ServiceAccount` from Kubernetes API server:
```
ServiceAccount sa = client.serviceAccounts().inNamespace("default").withName("sa-ribbon").get();
```
- Create `ServiceAccount`:
```
ServiceAccount serviceAccount1 = new ServiceAccountBuilder()
  .withNewMetadata().withName("serviceaccount1").endMetadata()
  .withAutomountServiceAccountToken(false)
  .build();

client.serviceAccounts().inNamespace("default").create(serviceAccount1);
```
- Create or Replace `ServiceAccount`:
```
ServiceAccount serviceAccount = client.serviceAccounts().inNamespace("default").createOrReplace(serviceAccount1);
```
- Create or Replace `ServiceAccount` with builders:
```
ServiceAccount serviceAccount = client.serviceAccounts().inNamespace("default").createOrReplaceWithNew()
  .withNewMetadata().withName("serviceaccount1").endMetadata()
  .withAutomountServiceAccountToken(false)
  .done();
```
- List `ServiceAccount` in some specific namespace:
```
ServiceAccountList svcAccountList = client.serviceAccounts().inNamespace("default").list();
```
- List `ServiceAccount` in some namespace with labels:
```
ServiceAccountList saList = client.serviceAccounts().inNamespace("default").withLabel("foo", "bar").list();
```
- Update/Edit `ServiceAccount`:
```
ServiceAccount serviceAccount1 = client.serviceAccounts().inNamespace("default").withName("serviceaccount1").edit()
  .addNewSecret().withName("default-token-uudp").endSecret()
  .addNewImagePullSecret().withName("myregistrykey").endImagePullSecret()
  .done();
```
- Delete `ServiceAccount`:
```
Boolean bDeleted = client.serviceAccounts().inNamespace("default").withName("serviceaccount1").delete();
```

### Ingress
`Ingress` resource is available in Kubernetes Client API via `client.network().ingress()`. Here are some examples regarding its usage:
- Load `Ingress` from yaml:
```
Ingress ingress = client.network().ingress().load(new FileInputStream("ingress.yml")).get();
```
- Get `Ingress` from Kubernetes API server:
```
Ingress ingress = client.network().ingress().inNamespace("default").withName("ingress1").get();
```
- Create `Ingress`:
```
Ingress ingress = new IngressBuilder()
  .withNewMetadata().withName("test-ingress").addToAnnotations("nginx.ingress.kubernetes.io/rewrite-target", "/").endMetadata()
  .withNewSpec()
  .addNewRule()
  .withNewHttp()
  .addNewPath()
  .withPath("/testPath").withNewBackend().withServiceName("test").withServicePort(new IntOrString(80)).endBackend()
  .endPath()
  .endHttp()
  .endRule()
  .endSpec()
  .build();
client.network().ingress().inNamespace("default").create(ingress);
```
- Create or Replace `Ingress`:
```
Ingress igx = client.network().ingress().inNamespace("default").createOrReplace(ingress);
```
- Create or Replace `Ingress` with Builders:
```
Ingress igx = client.network().ingress().inNamespace("default").createOrReplaceWithNew()
  .withNewMetadata().withName("test-ingress").addToAnnotations("nginx.ingress.kubernetes.io/rewrite-target", "/").endMetadata()
  .withNewSpec()
  .addNewRule()
  .withNewHttp()
  .addNewPath()
  .withPath("/testPath").withNewBackend().withServiceName("test").withServicePort(new IntOrString(80)).endBackend()
  .endPath()
  .endHttp()
  .endRule()
  .endSpec()
  .done();
```
- List `Ingress` in some namespace:
```
IngressList ingressList = client.network().ingress().inNamespace("default").list();
```
- List `Ingress` in any namespace:
```
IngressList ingressList = client.network().ingress().inAnyNamespace().list();
```
- List `Ingress` with some label in any namespace:
```
IngressList ingressList = client.network().ingress().inNamespace("default").withLabel("foo", "bar").list();
```
- Delete `Ingress`:
```
Boolean isDeleted = client.network().ingress().inNamespace("default").withName("ingress1").delete();
```

### StatefulSet

`StatefulSet` resource is available in Kubernetes API via `client.apps().statefulsets()`. Here are some examples of its common usages:
- Load `StatefulSet` from yaml:
```
StatefulSet aStatefulSet = client.apps().statefulSets()
  .load(new FileInputStream("test-statefulset.yml")).get();
```
- Get a `StatefulSet` from Kubernetes API server:
```
StatefulSet ss1 = client.apps().statefulSets().inNamespace("default").withName("ss1").get();
```
- Create a `StatefulSet`:
```
StatefulSet ss1 = new StatefulSetBuilder()
      .withNewMetadata().withName("ss1").endMetadata()
      .withNewSpec()
      .withReplicas(2)
      .withNewSelector().withMatchLabels(Collections.singletonMap("app", "nginx")).endSelector()
      .withNewTemplate()
      .withNewMetadata()
      .addToLabels("app", "nginx")
      .endMetadata()
      .withNewSpec()
      .addNewContainer()
      .withName("nginx")
      .withImage("nginx")
      .addNewPort()
      .withContainerPort(80)
      .withName("web")
      .endPort()
      .addNewVolumeMount()
      .withName("www")
      .withMountPath("/usr/share/nginx/html")
      .endVolumeMount()
      .endContainer()
      .endSpec()
      .endTemplate()
      .addNewVolumeClaimTemplate()
      .withNewMetadata()
      .withName("www")
      .endMetadata()
      .withNewSpec()
      .addToAccessModes("ReadWriteOnce")
      .withNewResources()
      .withRequests(Collections.singletonMap("storage", new Quantity("1Gi")))
      .endResources()
      .endSpec()
      .endVolumeClaimTemplate()
      .endSpec()
      .build();

StatefulSet ss = client.apps().statefulSets().inNamespace("default").create(ss1);
```
- Create or Replace an existing `StatefulSet`:
```
StatefulSet ss = client.apps().statefulSets().inNamespace("default").createOrReplace(ss1);
```
- List `StatefulSet` in some particular namespace:
```
StatefulSetList statefulSetList = client.apps().statefulSets().inNamespace("default").list();
```
- List `StatefulSet` in any namespace:
```
StatefulSetList statefulSetList = client.apps().statefulSets().inAnyNamespace().list();
```
- List `StatefulSet` in some namespace with label:
```
StatefulSetList statefulSetList = client.apps().statefulSets().inNamespace("default").withLabel("foo", "bar").list();
```
- Delete `StatefulSet`:
```
Boolean bDeleted = client.apps().statefulSets().inNamespace("default").withName("ss1").delete();
```
- Scale `StatefulSet`:
```
client.apps().statefulSets().inNamespace("default").withName("ss1").scale(2);
```
- Watch `StatefulSet`:
```
client.apps().statefulSets().inNamespace("default").withName("ss1").watch(new Watcher<StatefulSet>() {
  @Override
  public void eventReceived(Action action, StatefulSet resource) {
    // Do something on action type
  }

  @Override
  public void onClose(KubernetesClientException cause) {

  }
})
```
- Update Image in `StatefulSet`:
```
StatefulSet statefulSet = client.apps().statefulSets()
      .inNamespace("default")
      .withName("web")
      .rolling()
      .updateImage("nginx:1.19");
```
- Updated multiple containers in `StatefulSet`:
```
Map<String, String> containerToImageMap = new HashMap<>();
containerToImageMap("container1", "nginx:1.9");
containerToImageMap("container2", "busybox:latest");
Statefulset statefulSet = client.apps().statefulSets()
      .inNamespace("default")
      .withName("web")
      .rolling()
      .updateImage(params);
```
- Restart Rollout for `StatefulSet`:
```
StatefulSet ss = client.apps().statefulSets()
        .inNamespace("default")
        .withName("web")
        .rolling()
        .restart();
```
- Pause Rollout for `StatefulSet`:
```
StatefulSet ss = client.apps().statefulSets()
         .inNamespace("default")
         .withName("web")
         .rolling()
         .pause();
```
- Resume Rollout for `StatefulSet`:
```
StatefulSet ss = client.apps().statefulSets()
         .inNamespace("default")
         .withName("web")
         .rolling()
         .resume();
```
- Undo Rollout for `StatefulSet`:
```
StatefulSet ss = client.apps().statefulSets()
     .inNamespace("default")
     .withName("web")
     .rolling()
     .undo();
```

### DaemonSet
`DaemonSet` resource is available in Kubernetes Client API via `client.apps().daemonSets()`. Here are some examples of its common usage:
- Load `DaemonSet` from yaml:
```
DaemonSet ds = client.apps().daemonSets().load(new FileInputStream("daemonset.yaml")).get();
```
- Get `DaemonSet` from Kubernetes API server:
```
DaemonSet ds = client.apps().daemonSets().inNamespace("default").withName("ds1").get();
```
- Create `DaemonSet`:
```
DaemonSet ds = new DaemonSetBuilder()
  .withNewMetadata().withName("fluentd-elasticsearch").addToLabels("k8s-app", "fluentd-logging").endMetadata()
  .withNewSpec()
  .withNewSelector()
  .addToMatchLabels("name", "fluentd-elasticsearch")
  .endSelector()
  .withNewTemplate()
  .withNewSpec()
  .addNewToleration().withKey("node-role.kubernetes.io/master").withEffect("NoSchedule").endToleration()
  .addNewContainer()
  .withName("fluentd-elasticsearch").withImage("quay.io/fluentd_elasticsearch/fluentd:v2.5.2")
  .withNewResources()
  .addToLimits(Collections.singletonMap("memory", new Quantity("200Mi")))
  .addToRequests(Collections.singletonMap("cpu", new Quantity("100m")))
  .endResources()
  .addNewVolumeMount().withName("varlog").withMountPath("/var/log").endVolumeMount()
  .endContainer()
  .withTerminationGracePeriodSeconds(30l)
  .addNewVolume()
  .withName("varlog").withNewHostPath().withPath("/var/log").endHostPath()
  .endVolume()
  .endSpec()
  .endTemplate()
  .endSpec()
  .build();
ds = client.apps().daemonSets().inNamespace("default").create(ds);
```
- Create or Replace existing `DaemonSet`:
```
DaemonSet ds = client.apps().daemonSets().inNamespace("default").createOrReplace(ds);
```
- List `DaemonSet` in some namespace:
```
DaemonSetList dsList = client.apps().daemonSets().inNamespace("default").list();
```
- List `DaemonSet` in any namespace:
```
DaemonSetList dsList = client.apps().daemonSets().inAnyNamespace().list();
```
- List `DaemonSet` with some label:
```
DaemonSetList dsList = client.apps().daemonSets().inNamespace("default").withLabel("foo", "bar").list();
```
- Delete `DaemonSet`:
```
Boolean isDeleted = client.apps().daemonSets().inNamespace("default").withName("ds1").delete();
```
- Watch `DaemonSet`:
```
client.apps().daemonSets().inNamespace("default").watch(new Watcher<DaemonSet>() {
  @Override
  public void eventReceived(Action action, DaemonSet resource) {
    // Do something depending upon action type
  }

  @Override
  public void onClose(KubernetesClientException cause) {

  }
});
```

### PersistentVolumeClaim
`PersistentVolumeClaim` is available in Kubernetes Client API via `client.persistentVolumeClaims()`. Here are some examples of it's common usage:
- Load a `PersistentVolumeClaim` from yaml:
```
PersistentVolumeClaim pvc = client.persistentVolumeClaims().load(new FileInputStream("pvc.yaml")).get();
```
- Get a `PersistentVolumeClaim` object from Kubernetes API server:
```
PersistentVolumeClaim pvc = client.persistentVolumeClaims().inNamespace("default").withName("test-pv-claim").get();
```
- Create `PersistentVolumeClaim`:
```
PersistentVolumeClaim persistentVolumeClaim = new PersistentVolumeClaimBuilder()
  .withNewMetadata().withName("test-pv-claim").endMetadata()
  .withNewSpec()
  .withStorageClassName("my-local-storage")
  .withAccessModes("ReadWriteOnce")
  .withNewResources()
  .addToRequests("storage", new Quantity("500Gi"))
  .endResources()
  .endSpec()
  .build();

client.persistentVolumeClaims().inNamespace("default").create(persistentVolumeClaim);
```
- Create or Replace an existing `PersistentVolumeClaim`:
```
PersistentVolumeClaim pvc = client.persistentVolumeClaims().inNamespace("default").createOrReplace(pvcToCreate);
```
- Create or Replace an existing `PersistentVolumeClaim` with builders:
```
PersistentVolumeClaim pvc = client.persistentVolumeClaims().inNamespace("default").createOrReplaceWithNew()
  .withNewMetadata().withName("test-pv-claim").endMetadata()
  .withNewSpec()
  .withStorageClassName("my-local-storage")
  .withAccessModes("ReadWriteOnce")
  .withNewResources()
  .addToRequests("storage", new Quantity("500Gi"))
  .endResources()
  .endSpec()
  .done();
```
- List `PersistentVolumeClaim` objects in a particular namespace:
```
PersistentVolumeClaimList pvcList = client.persistentVolumeClaims().inNamespace("default").list();
```
- List `PersistentVolumeClaim` objects in any namespace:
```
PersistentVolumeClaimList pvcList = client.persistentVolumeClaims().inAnyNamespace().list();
```
- List `PersistentVolumeClaim` objects in some namespace with some labels:
```
PersistentVolumeClaimList pvcList = client.persistentVolumeClaims().inNamespace("default").withLabel("foo", "bar").list();
```
- Delete `PersistentVolumeClaim`:
```
Boolean isDeleted = client.persistentVolumeClaims().inNamespace("default").withName("test-pv-claim").delete();
```

### PersistentVolume
`PersistentVolume` resource is available in Kubernetes Client API via `client.persistentVolumes()`. Here are some of the examples of it's common usage:
- Load a `PersistentVolume` from yaml:
```
PersistentVolume pv = client.persistentVolumes().load(new FileInputStream("pv.yaml")).get();
```
- Get a `PersistentVolume` from Kubernetes API server:
```
PersistentVolume pv = client.persistentVolumes().withName("test-local-pv").get();
```
- Create `PersistentVolume`:
```
PersistentVolume pv = new PersistentVolumeBuilder()
  .withNewMetadata().withName("test-local-pv").endMetadata()
  .withNewSpec()
  .addToCapacity(Collections.singletonMap("storage", new Quantity("500Gi")))
  .withAccessModes("ReadWriteOnce")
  .withPersistentVolumeReclaimPolicy("Retain")
  .withStorageClassName("my-local-storage")
  .withNewLocal()
  .withPath("/mnt/disks/vol1")
  .endLocal()
  .withNewNodeAffinity()
  .withNewRequired()
  .addNewNodeSelectorTerm()
  .withMatchExpressions(Arrays.asList(new NodeSelectorRequirementBuilder()
    .withKey("kubernetes.io/hostname")
    .withOperator("In")
    .withValues("my-node")
    .build()
  ))
  .endNodeSelectorTerm()
  .endRequired()
  .endNodeAffinity()
  .endSpec()
  .build();

PersistentVolume pvCreated = client.persistentVolumes().create(pv)
```
- Create or Replace `PersistentVolume`:
```
PersistentVolume pv = client.persistentVolumes().createOrReplace(pvToCreate);
```
- List `PersistentVolume`:
```
PersistentVolumeList pvList = client.persistentVolumes().list();
```
- List `PersistentVolume` with some labels:
```
PersistentVolumeList pvList = client.persistentVolumes().withLabel("foo", "bar").list();
```
- Delete `PersistentVolume`:
```
Boolean isDeleted = client.persistentVolumes().withName("test-local-pv").delete();
```

### NetworkPolicy
`NetworkPolicy` is available in Kubernetes Client API via `client.network().networkPolicies()`. Here are some examples of it's common usages:
- Load a `NetworkPolicy` from yaml:
```
NetworkPolicy loadedNetworkPolicy = client.network().networkPolicies()
  .load(new FileInputStream("/test-networkpolicy.yml")).get();
```
- Get `NetworkPolicy` from Kubernetes API server:
```
NetworkPolicy getNetworkPolicy = client.network().networkPolicies()
  .withName("networkpolicy").get();
```
- Create `NetworkPolicy`:
```
NetworkPolicy networkPolicy = new NetworkPolicyBuilder()
      .withNewMetadata()
      .withName("networkpolicy")
      .addToLabels("foo","bar")
      .endMetadata()
      .withNewSpec()
      .withNewPodSelector()
      .addToMatchLabels("role","db")
      .endPodSelector()
      .addToIngress(0,
        new NetworkPolicyIngressRuleBuilder()
        .addToFrom(0, new NetworkPolicyPeerBuilder().withNewPodSelector()
          .addToMatchLabels("role","frontend").endPodSelector()
          .build()
        ).addToFrom(1, new NetworkPolicyPeerBuilder().withNewNamespaceSelector()
          .addToMatchLabels("project","myproject").endNamespaceSelector()
            .build()
        )
        .addToPorts(0,new NetworkPolicyPortBuilder().withPort(new IntOrString(6379))
          .withProtocol("TCP").build())
        .build()
      )
      .endSpec()
      .build();

NetworkPolicy npCreated = client.network().networkPolicies().create(networkPolicy);
```
- Create or Replace some existing `NetworkPolicy`:
```
NetworkPolicy npCreated = client.network().networkPolicies().createOrReplace(networkPolicy);
```
- List `NetworkPolicy`:
```
NetworkPolicyList networkPolicyList = client.network().networkPolicies().list();
```
- List with labels `NetworkPolicy`:
```
NetworkPolicyList networkPolicyList = client.network().networkPolicies()
  .withLabels(Collections.singletonMap("foo","bar")).list();
```
- Delete `NetworkPolicy`:
```
Boolean deleted = client.network().networkPolicies().withName("np-test").delete();
```

### PodDisruptionBudget
`PodDisruptionBudget` is available in Kubernetes Client API via `client.policy().podDisruptionBudget()`. Here are some of the examples of its usage:
- Load `PodDisruptionBudget` from yaml:
```
PodDisruptionBudget pdb = client.policy().podDisruptionBudget().load(new FileInputStream("/test-pdb.yml")).get();
```
- Get `PodDisruptionBudget` from Kubernetes API server:
```
PodDisruptionBudget podDisruptionBudget = client.policy().podDisruptionBudget().inNamespace("default").withName("poddisruptionbudget1").get();
```
- Create `PodDisruptionBudget`:
```
PodDisruptionBudget podDisruptionBudget = new PodDisruptionBudgetBuilder()
    .withNewMetadata().withName("zk-pkb").endMetadata()
    .withNewSpec()
    .withMaxUnavailable(new IntOrString("1%"))
    .withNewSelector()
    .withMatchLabels(Collections.singletonMap("app", "zookeeper"))
    .endSelector()
    .endSpec()
    .build();

client.policy().podDisruptionBudget().inNamespace("default").create(podDisruptionBudget);
```
- Create or Replace `PodDisruptionBudget`:
```
PodDisruptionBudget pdb = client.policy().podDisruptionBudget().inNamespace("default").createOrReplace(podDisruptionBudgetObj);
```
- List `PodDisruptionBudget` in some namespace:
```
PodDisruptionBudgetList podDisruptionBudgetList = client.policy().podDisruptionBudget().inNamespace("default").list();
```
- List `PodDisruptionBudget` in any namespace:
```
PodDisruptionBudgetList pdbList = client.policy().podDisruptionBudget().inAnyNamespace().list();
```
- List `PodDisruptionBudget` with labels:
```
PodDisruptionBudgetList pdbList = client.policy().podDisruptionBudget().inNamespace("default").withLabel("foo", "bar").list();
```
- Delete `PodDisruptionBudget`:
```
Boolean deleted = client.policy().podDisruptionBudget().inNamespace("default").withName("poddisruptionbudget1").delete();
```

### Fetching Metrics
Kubernetes Client also supports fetching metrics from API server if metrics are enabled on it. You can access metrics via `client.top()`. Here are some examples of its usage:
- Get `NodeMetrics` for all nodes:
```
NodeMetricsList nodeMetricList = client.top().nodes().metrics();
```
- Get `NodeMetrics` for some specific nodes:
```
NodeMetrics nodeMetric = client.top().nodes().metrics("minikube");
```
- Get `PodMetrics` for all pods in all namespaces:
```
PodMetricsList podMetricsList = client.top().pods().metrics();
```
- Get `PodMetrics` for all pods in some specific namespace:
```
PodMetricsList podMetricsList = client.top().pods().metrics("default");
```
- Get `PodMetrics` for a particular pod:
```
PodMetrics podMetrics = client.top().pods().metrics("default", "nginx-pod");
```

### Resource API
Kubernetes Client also offers a generic API to handle different kind of Kubernetes resources. Most of the Kubernetes resources in Kubernetes Model are extending a class named `HasMetadata`. Resource API can work with any kind of Kubernetes Resource which extends this class. Here are some examples it it's usage:
- Get a Kubernetes Resource from Kubernetes API server:
```
Pod pod = client.resource(pod1).inNamespace("default").get();
```
- Create or Replace a Kubernetes Resource:
```
Pod pod1 = new PodBuilder()
  .withNewMetadata().withName("resource-pod-" + RandomStringUtils.randomAlphanumeric(6).toLowerCase(Locale.ROOT)).endMetadata()
  .withNewSpec()
  .addNewContainer().withName("nginx").withImage("nginx").endContainer()
  .endSpec()
  .build();

client.resource(pod1).inNamespace("default").createOrReplace();
```
- Create And Wait until resource is ready:
```
Pod p = client.resource(pod1).createOrReplaceAnd().waitUntilReady(10, TimeUnit.SECONDS);
```
- Delete a Kubernetes Resource:
```
Boolean isDeleted = client.resource(pod1).inNamespace("default").delete();
```

### ResourceList API
Just like generic Kubernetes Resource API, Kubernetes client also provides a generic API to deal with Kubernetes List. Here are some examples of its usage:
- Create or Replace a list of Kubernetes resources:
```
Service service =  new ServiceBuilder()
  .withNewMetadata().withName("my-service").endMetadata()
  .withNewSpec()
  .addToSelector("app", "Myapp")
  .addNewPort().withProtocol("TCP").withPort(80).withTargetPort(new IntOrString(9376)).endPort()
  .endSpec()
  .build();


ConfigMap configMap = new ConfigMapBuilder()
  .withNewMetadata().withName("my-configmap").endMetadata()
  .addToData(Collections.singletonMap("app", "Myapp"))
  .build();

KubernetesList list = new KubernetesListBuilder().withItems(deployment, service, configMap).build();

// Create them for the first time
client.resourceList(list).inNamespace("default").createOrReplace();
```
- Create or Replace with delete existing resources before creation:
```
KubernetesList list = new KubernetesListBuilder().withItems(updatedService, updatedConfigMap).build();
client.resourceList(list).inNamespace("default").deletingExisting().createOrReplace();
```
- Delete a list of items:
```
Boolean deleted = client.resourceList(new PodListBuilder().withItems(pod1, pod2, pod3).build()).inNamespace("default").delete();
```

### CustomResourceDefinition
`CustomResourceDefinition` which are like templates for `CustomResource` objects in Kubernetes API are available in Kubernetes Client API via `client.customResourceDefinitions()`. Here are some examples of it's common usage:
- Load a `CustomResourceDefinition` from yaml:
```
CustomResourceDefinition customResourceDefinition = client.customResourceDefinitions().load(new FileInputStream("/sparkapplication-crd.yml")).get();
```
- Get a `CustomResourceDefinition` from Kubernetes APIServer
```
CustomResourceDefinition crd = client.customResourceDefinitions().withName("sparkclusters.radanalytics.io").get();
```
- Create `CustomResourceDefinition`:
```

CustomResourceDefinition customResourceDefinition = new CustomResourceDefinitionBuilder()
      .withApiVersion("apiextensions.k8s.io/v1beta1")
      .withNewMetadata().withName("sparkclusters.radanalytics.io")
      .endMetadata()
      .withNewSpec()
      .withNewNames()
      .withKind("SparkCluster")
      .withPlural("sparkclusters")
      .endNames()
      .withGroup("radanalytics.io")
      .withVersion("v1")
      .withScope("Namespaced")
      .withNewValidation()
      .withNewOpenAPIV3SchemaLike(readSchema())
      .endOpenAPIV3Schema()
      .endValidation()
      .endSpec()
      .build();

CustomResourceDefinition crd = client.customResourceDefinitions().createOrReplace(customResourceDefinition);
```
- Create or Replace some `CustomResourceDefinition`:
```
CustomResourceDefinition crd = client.customResourceDefinitions().createOrReplace(customResourceDefinition);
```
- List `CustomResourceDefinition`:
```
CustomResourceDefinitionList crdList = client.customResourceDefinitions().list();
```
- Delete `CustomResourceDefinition`:
```
Boolean deleted = client.customResourceDefinitions().withName("sparkclusters.radanalytics.io").delete();
```

### CustomResource Typed API
CustomResources are available in Kubernetes API via the `client.customResources(...)`. In order to use typed API, you need to provide POJOs for your Custom Resource which client can use for serialization/deserialization. `client.customResources(...)` take things like `CustomResourceDefinitionContext` for locating the CustomResources, `CustomResource` class, it's list class etc. It returns an instance of a client which you can use for your `CustomResource` related operations. In order to get some idea of how POJOs should look like. Here's an example of POJO for `CronTab` CustomResource specified in [Kubernetes CustomResource docs](https://kubernetes.io/docs/tasks/access-kubernetes-api/custom-resources/custom-resource-definitions/)
*my-crontab.yml*
```
apiVersion: "stable.example.com/v1"
kind: CronTab
metadata:
  name: my-new-cron-object
spec:
  cronSpec: "* * * * */5"
  image: my-awesome-cron-image
```
For a CustomResource like this one, we should have a `CronTab` java class like this:
```
/**
 * Copyright (C) 2015 Red Hat, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.fabric8.kubernetes.client.mock.crd;

import io.fabric8.kubernetes.api.model.Namespaced;
import io.fabric8.kubernetes.api.model.ObjectMeta;
import io.fabric8.kubernetes.client.CustomResource;

public class CronTab extends CustomResource implements Namespaced {
    private CronTabSpec spec;
    private CronTabStatus status;

    @Override
    public ObjectMeta getMetadata() {
        return super.getMetadata();
    }

    public CronTabSpec getSpec() {
        return spec;
    }

    public void setSpec(CronTabSpec spec) {
        this.spec = spec;
    }

    public CronTabStatus getStatus() {
        return status;
    }

    public void setStatus(CronTabStatus status) {
        this.status = status;
    }

    @Override
    public String getApiVersion() {
        return "stable.example.com/v1";
    }

    @Override
    public String toString() {
        return "CronTab{"+
                "apiVersion='" + getApiVersion() + "'" +
                ", metadata=" + getMetadata() +
                ", spec=" + spec +
                ", status=" + status +
                "}";
    }
}
```
You can find other helper classes related to `CronTab` in our [tests](https://github.com/fabric8io/kubernetes-client/tree/master/kubernetes-tests/src/test/java/io/fabric8/kubernetes/client/mock/crd). For now, we can proceed with it's common usage examples:

- Get Instance of client for our `CustomResource`:
```
// Alternatively use CustomResourceDefinitionContext.fromCrd(crd) if you already have a CustomResourceDefinition
CustomResourceDefinitionContext context = new CustomResourceDefinitionContext.Builder()
      .withGroup("stable.example.com)
      .withVersion("v1")
      .withScope("Namespaced")
      .withName("crontabs.stable.example.com)
      .withPlural("crontabs")
      .withKind("CronTab")
      .build()
MixedOperation<CronTab, CronTabList, DoneableCronTab, Resource<CronTab, DoneableCronTab>> cronTabClient = client
  .customResources(cronTabCrd, CronTab.class, CronTabList.class, DoneableCronTab.class);
```
- Register your `CustomResource` to `KubernetesDeserializer`:
```
KubernetesDeserializer.registerCustomKind("stable.example.com/v1", "CronTab", CronTab.class);
```
- Get `CustomResource` from Kubernetes APIServer:
```
CronTab ct = cronTabClient.inNamespace("default").withName("my-second-cron-object").get();
```
- Create `CustomResource`:
```
cronTabClient.inNamespace("default").create(cronTab1);
```
- List `CustomResource`:
```
CronTabList cronTabList = cronTabClient.inNamespace("default").list();
```
- Delete `CustomResource`:
```
Boolean isDeleted = cronTabClient.inNamespace("default").withName("my-third-cron-object").delete();
```
- Update Status of `CustomResource`:
```
cronTabClient.inNamespace("default").updateStatus(updatedCronTab);
``` 
- Watch `CustomResource`, (*note:* You need to register your `CustomResource` to `KubernetesDeserializer` otherwise you won't be able to use watch):
```
cronTabClient.inNamespace("default").watch(new Watcher<CronTab>() {
  @Override
  public void eventReceived(Action action, CronTab resource) {
    // Do something depending upon action type
  }

  @Override
  public void onClose(KubernetesClientException cause) {

  }
});
```

### CustomResource Typeless API
Although, you should be using Typed API since it's type-safe. But it can get a bit compilcated to maintain your `CustomResource` POJOs and sometimes people don't even have them. Kubernetes Client also provides a typeless/raw API to handle your `CustomResource` objects in form of HashMaps. In order to use it, you need to provide it with a `CustomResourceDefinitionContext`, which carries necessary information about `CustomResource`. Here is an example on how to create one:
- Create `CustomResourceDefinitionContext`:
```
CustomResourceDefinitionContext customResourceDefinitionContext = new CustomResourceDefinitionContext.Builder()
      .withName("animals.jungle.example.com")
      .withGroup("jungle.example.com")
      .withVersion("v1")
      .withPlural("animals")
      .withScope("Namespaced")
      .build();
```
Once you have built it, you can pass it to typeless DSL as argument `client.customResource(customResourceDefinitionContext)`. With this in place, you can do your standard `CustomResource` operations, but you would have to deal with Serialization/Deserialization part yourself. You can convert HashMap to some `JSON` object using JSON parsing libraries available on internet.
- Load a `CustomResource` from yaml:
```
Map<String, Object> customResource = client.customResource(crdContext).load(new FileInputStream("cr.yaml"));
```
- Get a `CustomResource` from Kubernetes API server:
```
Map<String, Object> customResourceObject = client.customResource(customResourceDefinitionContext).get(currentNamespace, "otter");
```
- Create a `CustomResource`:
```
// Create via file
Map<String, Object> object = client.customResource(customResourceDefinitionContext).create(currentNamespace, new FileInputStream("test-rawcustomresource.yml"));

// Create via raw JSON string

String rawJsonCustomResourceObj = "{\"apiVersion\":\"jungle.example.com/v1\"," +
  "\"kind\":\"Animal\",\"metadata\": {\"name\": \"walrus\"}," +
  "\"spec\": {\"image\": \"my-awesome-walrus-image\"}}";
Map<String, Object> object = client.customResource(customResourceDefinitionContext).create(currentNamespace, rawJsonCustomResourceObj);
```
- List `CustomResource`:
```
Map<String, Object> list = client.customResource(customResourceDefinitionContext).list(currentNamespace);
```
- List `CustomResource` with labels:
```
Map<String, Object> list = client.customResource(customResourceDefinitionContext).list(currentNamespace, Collections.singletonMap("foo", "bar"));
```
- Update `CustomResource`:
```
Map<String, Object> object = client.customResource(customResourceDefinitionContext).get(currentNamespace, "walrus");
((HashMap<String, Object>)object.get("spec")).put("image", "my-updated-awesome-walrus-image");
object = client.customResource(customResourceDefinitionContext).edit(currentNamespace, "walrus", new ObjectMapper().writeValueAsString(object));
```
- Delete `CustomResource`:
```
client.customResource(customResourceDefinitionContext).delete(currentNamespace, "otter");
```
- Update Status of `CustomResource`:
```
Map<String, Object> result = client.customResource(customResourceDefinitionContext).updateStatus("ns1", "example-hello", objectAsJsonString);
```
- Watch `CustomResource`:
```

  final CountDownLatch closeLatch = new CountDownLatch(1);
  client.customResource(crdContext).watch(namespace, new Watcher<String>() {
    @Override
    public void eventReceived(Action action, String resource) {
      logger.info("{}: {}", action, resource);
    }

    @Override
    public void onClose(KubernetesClientException e) {
      logger.debug("Watcher onClose");
      closeLatch.countDown();
      if (e != null) {
        logger.error(e.getMessage(), e);
      }
    }
  });
  closeLatch.await(10, TimeUnit.MINUTES);
```

### SharedInformers
Kubernetes Client also provides `SharedInformer` support in order to stay updated to events happening to your resource inside Kubernetes. It's implementation is just list and watch operations after a certain interval of time. Here are some of the common usages:
- Get `SharedInformerFactory`:
```
SharedInformerFactory sharedInformerFactory = client.informers();
```
- Create `SharedIndexInformer` for some Kubernetes Resource(requires resource's class, resource's list class, and resync period(when to check with server again while watching something):
```
SharedIndexInformer<Pod> podInformer = sharedInformerFactory.sharedIndexInformerFor(Pod.class, PodList.class, 30 * 1000L);
podInformer.addEventHandler(new ResourceEventHandler<Pod>() {
  @Override
  public void onAdd(Pod pod) {
    logger.info("{} pod added", pod.getMetadata().getName());
  }

  @Override
  public void onUpdate(Pod oldPod, Pod newPod) {
    logger.info("{} pod updated", oldPod.getMetadata().getName());
  }

  @Override
  public void onDelete(Pod pod, boolean deletedFinalStateUnknown) {
    logger.info("{} pod deleted", pod.getMetadata().getName());
  }
});
```
- Create `SharedIndexInformer` for some Custom Resource(in our case, `Dummy` resource provided in our [examples](https://github.com/fabric8io/kubernetes-client/tree/master/kubernetes-examples/src/main/java/io/fabric8/kubernetes/examples/crds):
```
SharedIndexInformer<Dummy> dummyInformer = sharedInformerFactory.sharedIndexInformerForCustomResource(crdContext, Dummy.class, DummyList.class, 1 * 60 * 1000);
dummyInformer.addEventHandler(new ResourceEventHandler<Dummy>() {
  @Override
  public void onAdd(Dummy pod) {
    System.out.printf("%s dummy added\n", pod.getMetadata().getName());
  }

  @Override
  public void onUpdate(Dummy oldPod, Dummy newPod) {
    System.out.printf("%s dummy updated\n", oldPod.getMetadata().getName());
  }

  @Override
  public void onDelete(Dummy pod, boolean deletedFinalStateUnknown) {
    System.out.printf("%s dummy deleted \n", pod.getMetadata().getName());
  }
});

```
- Create namespaced `SharedIndexInformer` (informers specific to a particular `Namespace`):
```
SharedInformerFactory sharedInformerFactory = client.informers();
SharedIndexInformer<Pod> podInformer = sharedInformerFactory.sharedIndexInformerFor(
        Pod.class,
        PodList.class,
        new OperationContext().withNamespace("default"),
        30 * 1000L);
logger.info("Informer factory initialized.");

podInformer.addEventHandler(new ResourceEventHandler<Pod>() {
    @Override
    public void onAdd(Pod pod) {
        logger.info("Pod " + pod.getMetadata().getName() + " got added");
    }

    @Override
    public void onUpdate(Pod oldPod, Pod newPod) {
        logger.info("Pod " + oldPod.getMetadata().getName() + " got updated");
    }

    @Override
    public void onDelete(Pod pod, boolean deletedFinalStateUnknown) {
        logger.info("Pod " + pod.getMetadata().getName() + " got deleted");
    }
});
```
- Start all registered informers:
```
sharedInformerFactory.startAllRegisteredInformers();
```
- Stop all registered informers:
```
sharedInformerFactory.stopAllRegisteredInformers();
```

### List Options
There are various options provided by Kubernetes Client API when it comes to listing resources. Here are some of the common examples provided:
- List with pagination, comes with limit and continue parameters. The continue option should be set when retrieving more results from the server. Since this value is server defined, clients may only use the continue value from a previous query result with identical query parameters (except for the value of continue) and the server may reject a continue value it does not recognize.
```
PodList podList = client.pods().inNamespace("myproject").list(5, null);

podList = client.pods().inNamespace("myproject").list(5, podList.getMetadata().getContinue());
```
- List resources containing some specific Label:
```
PodList podList = client.pods().inNamespace("default").withLabel("foo", "bar").list();
```
- List resources containing a set of labels:
```
PodList podList = client.pods().inNamespace("default").withLabels(Collections.singletonMap("foo", "bar")).list();
```
- List resources without Label:
```
PodList podList = client.pods().inNamespace("default").withoutLabel("foo", "bar").list();
```
- List resources without a set of Labels:
```
PodList podList = client.pods().inNamespace("default").withoutLabels(Collections.singletonMap("foo", "bar")).list();
```
- List resources with labels in:
```
PodList podList = client.pods().inNamespace("default").withLabelIn("foo", "bar").list();
```
- List resources with labels not in:
```
PodList podList =client.pods().inNamespace("default").withLabelNotIn("foo", "bar").list();
```
- List resources with field:
```
PodList podList = client.pods().inNamespace("default").withField("foo", "bar").list();
```
- List resources with fields:
```
PodList podList = client.pods().inNamespace("default").withFields(Collections.singletonMap("foo", "bar")).list();
```
- List resources without field:
```
PodList podList = client.pods().inNamespace("default").withoutField("foo", "bar").list();
```
- List resources without fields:
```
PodList podList = client.pods().inNamespace("default").withoutFields(Collections.singletonMap("foo", "bar")).list();
```
- List resources with `ListOptions`:
```
PodList podList = client.pods().inNamespace("default").list(new ListOptionsBuilder()
  .withLimit(1L)
  .withContinue(null)
  .build());
```

### Delete Options
Kubernetes Client also provides way to delete dependents of some Kubernetes resource. Here are some examples:
- Providing `cascading()` in order to either delete dependent resources or leave them orphan. By default it is `true` meaning it would delete dependent resources too.
```
Boolean isDeleted = client.apps().deployments().inNamespace("default").withName("nginx-deploy").cascading(true).delete();
```
- Providing `propagationPolicy(..)` to specify how deletion should be performed:
```
Boolean isDeleted = client.apps().deployments().inNamespace("default").withName("nginx-deploy").withPropagationPolicy("Foreground").delete();
```
- Specifying grace period for deletion:
```
Boolean isDeleted = client.apps().deployments().inNamespace("ns1").withName("mydeployment").withPropagationPolicy(DeletionPropagation.FOREGROUND).withGracePeriod(10).delete();
```

### Watch Options
Kubernetes Client provides namely three different ways of using `Watch`:
- Plain `Watch` without any arguments:
```
client.pods().inNamespace(namespace).watch(new Watcher<Pod>() {
    @Override
    public void eventReceived(Action action, Pod pod) {
        logger.log(Level.INFO, action.name() + " " + pod.getMetadata().getName());
        switch (action.name()) {
            case "ADDED":
                logger.log(Level.INFO, pod.getMetadata().getName() + "got added");
                break;
            case "DELETED":
                logger.log(Level.INFO, pod.getMetadata().getName() + "got deleted");
                break;
            case "MODIFIED":
                logger.log(Level.INFO, pod.getMetadata().getName() + "got modified");
                break;
            default:
                logger.log(Level.SEVERE, "Unrecognized event: " + action.name());
        }
    }

    @Override
    public void onClose(KubernetesClientException e) {
        logger.log(Level.INFO, "Closed");
        isWatchClosed.countDown();
    }
});

// Wait till watch gets closed
isWatchClosed.await();
```
- _Deprecated_ : Watching with `resourceVersion` provided:
```
String resourceVersion = "20012";
client.pods().inNamespace(namespace).watch(resourceVersion, new Watcher<Pod>() {
    @Override
    public void eventReceived(Action action, Pod pod) {
        logger.log(Level.INFO, action.name() + " " + pod.getMetadata().getName());
        switch (action.name()) {
            case "ADDED":
                logger.log(Level.INFO, pod.getMetadata().getName() + "got added");
                break;
            case "DELETED":
                logger.log(Level.INFO, pod.getMetadata().getName() + "got deleted");
                break;
            case "MODIFIED":
                logger.log(Level.INFO, pod.getMetadata().getName() + "got modified");
                break;
            default:
                logger.log(Level.SEVERE, "Unrecognized event: " + action.name());
        }
    }

    @Override
    public void onClose(KubernetesClientException e) {
        logger.log(Level.INFO, "Closed");
        isWatchClosed.countDown();
    }
});

// Wait till watch gets closed
isWatchClosed.await();
} catch (InterruptedException interruptedException) {
logger.log(Level.INFO, "Thread Interrupted!");
Thread.currentThread().interrupt();
}
```
- Watching with `ListOptions` object:
```
client.pods().watch(new ListOptionsBuilder().withTimeoutSeconds(30L).build(), new Watcher<Pod>() {
  @Override
  public void eventReceived(Action action, Pod resource) { }

  @Override
  public void onClose(KubernetesClientException cause) { }
});
```

### OpenShift Client DSL Usage

Fabric8 Kubernetes Client also has an extension for OpenShift. It is pretty much the same as Kubernetes Client but has support for some additional OpenShift resources.

#### Initializing OpenShift Client:
Initializing OpenShift client is the same as Kubernetes Client. Yo
```
try (final OpenShiftClient client = new DefaultOpenShiftClient()) {
  // Do stuff with client
}
```
This would pick up default settings, reading your `kubeconfig` file from `~/.kube/config` directory or whatever is defined inside `KUBECONFIG` environment variable. But if you want to customize creation of client, you can also pass a `Config` object inside `DefaultKubernetesClient` like this:
```
Config kubeConfig = new ConfigBuilder()
            .withMasterUrl("https://api.ci-ln-3sbdl1b-d5d6b.origin-ci-int-aws.dev.examplecloud.com:6443")
            .withOauthToken("xxxxxxxx-41oafKI6iU637-xxxxxxxxxxxxx")
            .build())) {
try (final OpenShiftClient client = new DefaultOpenShiftClient(config)) {
  // Do stuff with client
}
```
You can also create `OpenShiftClient` from an existing instance of `KubernetesClient`. There is a method called `adapt(..)` for this. Here is an example:
```
KubernetesClient client = new DefaultKubernetesClient();
OpenShiftClient openShiftClient = client.adapt(OpenShiftClient.class);
```

#### DeploymentConfig
`DeploymentConfig` is available in OpenShift client via `client.deploymentConfigs()`. Here are some examples of its common usage:
- Load `DeploymentConfig` from yaml:
```
DeploymentConfig deploymentConfig = client.deploymentConfigs().inNamespace(currentNamespace)
  .load(new FileInputStream("test-deploymentconfig.yml")).get();
```
- Get `DeploymentConfig` from OpenShift API server:
```
DeploymentConfig dc = client.deploymentConfigs().inNamespace(currentNamespace).withName("deploymentconfig1").get();
```
- Create `DeploymentConfig`:
```
DeploymentConfig dc = new DeploymentConfigBuilder()
      .withNewMetadata().withName("deploymentconfig1").endMetadata()
      .withNewSpec()
      .withReplicas(2)
      .withNewTemplate()
      .withNewMetadata()
      .addToLabels("app", "database")
      .endMetadata()
      .withNewSpec()
      .addNewContainer()
      .withName("mysql")
      .withImage("openshift/mysql-55-centos7")
      .endContainer()
      .endSpec()
      .endTemplate()
      .endSpec()
      .build();

DeploymentConfig dcCreated = client.deploymentConfigs().inNamespace("default").create(dc);
```
- Create or Replace an existing `DeploymentConfig`:
```
DeploymentConfig dc = client.deploymentConfigs().inNamespace("default").createOrReplace(dcToCreate);
```
- List `DeploymentConfig` in some namespace:
```
DeploymentConfigList aDeploymentConfigList = client.deploymentConfigs().inNamespace("default").list();
```
- List `DeploymentConfig` in any namespace:
```
DeploymentConfigList dcList = client.deploymentConfigs().inAnyNamespace().list();
```
- List `DeploymentConfig` in some namespace with some label:
```
DeploymentConfigList dcList = client.deploymentConfigs().inNamespace("default").withLabel("foo", "bar").list();
```
- Update `DeploymentConfig`:
```
DeploymentConfig deploymentConfig1 = client.deploymentConfigs().inNamespace(currentNamespace).withName("deploymentconfig1").edit()
  .editSpec().withReplicas(3).endSpec().done();
```
- Delete `DeploymentConfig`:
```
Boolean bDeleted = client.deploymentConfigs().inNamespace("default").withName("deploymentconfig1").delete();
```
- Watch `DeploymentConfig`:
```
client.deploymentConfigs().inNamespace("default").watch(new Watcher<DeploymentConfig>() {
  @Override
  public void eventReceived(Action action, DeploymentConfig resource) {
    // Do something depending upon action    
  }

  @Override
  public void onClose(KubernetesClientException cause) {

  }
});
```

#### BuildConfig
`BuildConfig` resource is available in OpenShift Client via `client.buildConfigs()`. Here are some examples of it's common uses:
- Load `BuildConfig` from yaml:
```
BuildConfig aBuildConfig = client.buildConfigs().inNamespace(currentNamespace)
  .load(new FileInputStream("/test-buildconfig.yml")).get();
```
- Get `BuildConfig` from OpenShift API server:
```
BuildConfig bc = client.buildConfigs().inNamespace(currentNamespace).withName("bc1").get();
```
- Create `BuildConfig`:
```
BuildConfig buildConfig1 = new BuildConfigBuilder()
  .withNewMetadata().withName("bc1").endMetadata()
  .withNewSpec()
  .addNewTrigger()
  .withType("GitHub")
  .withNewGithub()
  .withSecret("secret101")
  .endGithub()
  .endTrigger()
  .addNewTrigger()
  .withType("Generic")
  .withNewGeneric()
  .withSecret("secret101")
  .endGeneric()
  .endTrigger()
  .addNewTrigger()
  .withType("ImageChange")
  .endTrigger()
  .withNewSource()
  .withType("Git")
  .withNewGit()
  .withUri("https://github.com/openshift/ruby-hello-world")
  .endGit()
  .withDockerfile("FROM openshift/ruby-22-centos7\\nUSER example")
  .endSource()
  .withNewStrategy()
  .withType("Source")
  .withNewSourceStrategy()
  .withNewFrom()
  .withKind("ImageStreamTag")
  .withName("origin-ruby-sample:latest")
  .endFrom()
  .endSourceStrategy()
  .endStrategy()
  .withNewOutput()
  .withNewTo()
  .withKind("ImageStreamTag")
  .withName("origin-ruby-sample:latest")
  .endTo()
  .endOutput()
  .withNewPostCommit()
  .withScript("bundle exec rake test")
  .endPostCommit()
  .endSpec()
  .build();

client.buildConfigs().inNamespace("default").create(buildConfig1);
```
- Create or Replace `BuildConfig`:
```
BuildConfig bc = client.buildConfigs().inNamespace("default").create(buildConfig1);
```
- List `BuildConfig` in some namespace:
```
BuildConfigList bcList = client.buildConfigs().inNamespace("default").list();
```
- List `BuildConfig` in any namespace:
```
BuildConfigList bcList = client.buildConfigs().inNamespace("default").list();
```
- List `BuildConfig` in some namespace with some label:
```
BuildConfigList bcList = client.buildConfigs().inNamespace("default").withLabel("foo", "bar").list();
```
- Delete `BuildConfig`:
```
Boolean bDeleted = client.buildConfigs().inNamespace("default").withName("bc1").delete();
```
- Watch `BuildConfig`:
```
client.buildConfigs().inNamespace("default").watch(new Watcher<BuildConfig>() {
  @Override
  public void eventReceived(Action action, BuildConfig resource) {
    // Do something depending upon action type    
  }

  @Override
  public void onClose(KubernetesClientException cause) {

  }
});
```

#### Route
`Route` resource is available in OpenShift client API via `client.routes()`. Here are some examples of its common usage:
- Load `Route` from yaml:
```
Route aRoute = client.routes().inNamespace("default").load(new FileInputStream("test-route.yml")).get();
```
- Get `Route` from OpenShift API server:
```
Route route1 = client.routes().inNamespace("default").withName("route1").get();
```
- Create `Route`:
```
Route route1 = new RouteBuilder()
      .withNewMetadata().withName("route1").endMetadata()
      .withNewSpec().withHost("www.example.com").withNewTo().withKind("Service").withName("service-name1").endTo().endSpec()
      .build();

client.routes().inNamespace("defalt").create(route1);
```
- Create or Replace `Route`:
```
Route route = client.routes().inNamespace("default").createOrReplace(route1);
```
- List `Route` in some namespace:
```
RouteList aRouteList = client.routes().inNamespace("default").list();
```
- List `Route` in any namespace:
```
RouteList aRouteList = client.routes().inAnyNamespace().list();
```
- List `Route` in some namespace with some label:
```
RouteList routeList = client.routes().inNamespace("default").withLabel("foo", "bar").list();
```
- Delete `Route`:
```
boolean bDeleted = client.routes().inNamespace("default").withName("route1").delete();
```

#### Project
OpenShift `Project` resource can be found in OpenShift Client API via `client.projects()`. Here are some examples of its usage:
- Get `Project`:
```
Project myProject = client.projects().withName("default").get();
```
- Create `Project`
```
ProjectRequest request = client.projectrequests().createNew().withNewMetadata().withName("thisisatest").endMetadata().withDescription("Fabric8").withDisplayName("Fabric8).done();
```
- List `Project`
```
ProjectList projectList = client.projects().list();
```
- Delete `Project`:
```
Boolean isDeleted = client.projects().withName("default").delete();
```

#### ImageStream
`ImageStream` resource is available in OpenShift client via `client.imageStreams()`. Here are some examples of its common usage:
- Load `ImageStream` from yaml:
```
ImageStream aImageStream = client.imageStreams()
  .load(new FileInputStream("test-imagestream.yml")).get();
```
- Get `ImageStream` from OpenShift API Server:
```
ImageStream is =client.imageStreams().inNamespace("default").withName("example-camel-cdi").get();
```
- Create `ImageStream`:
```
ImageStream imageStream1 = new ImageStreamBuilder()
      .withNewMetadata()
      .withName("example-camel-cdi")
      .endMetadata()
      .withNewSpec()
      .addNewTag()
      .withName("latest")
      .endTag()
      .withDockerImageRepository("fabric8/example-camel-cdi")
      .endSpec()
      .withNewStatus().withDockerImageRepository("").endStatus()
      .build();

client.imageStreams().inNamespace("default").create(imageStream1);
```
- Create or Replace `ImageStream`:
```
ImageStream is = client.imageStreams().inNamespace("default").createOrReplace(imageStream1);
```
- List `ImageStream` in some namespace:
```
ImageStreamList aImageStreamList = client.imageStreams().inNamespace("default").list();
```
- List `ImageStream` in any namespace:
```
ImageStreamList isList = client.imageStreams().inAnyNamespace().list();
```
- List `ImageStream` in some namespace with some labels:
```
ImageStreamList isList = client.imageStreams().inNamespace("default").withLabel("foo", "bar").list();
```
- Delete `ImageStream`:
```
Boolean bDeleted = client.imageStreams().inNamespace("default").withName("example-camel-cdi").delete();
```

### Tekton Client
Fabric8 Kubernetes Client also has an extension for Tekton. 
It is pretty much the same as Kubernetes Client but has support for some additional Tekton resources.

#### Initializing Tekton Client
Initializing Tekton client is the same as Kubernetes Client. You
```
try (final TektonClient client = new DefaultTektonClient()) {
  // Do stuff with client
}
```
This would pick up default settings, reading your `kubeconfig` file from `~/.kube/config` directory or whatever is defined inside `KUBECONFIG` environment variable.
But if you want to customize creation of client, you can also pass a `Config` object inside `DefaultTektonClient`.
You can also create `TektonClient` from an existing instance of `KubernetesClient`. 
There is a method called `adapt(..)` for this.
Here is an example:
```
KubernetesClient client = new DefaultKubernetesClient();
TektonClient tektonClient = client.adapt(TektonClient.class);
```

#### Tekton Client DSL Usage
The Tekton client supports CRD API version `tekton.dev/v1alpha1` as well as `tekton.dev/v1beta1`.
`tekton.dev/v1alpha1` includes the CRDs  `Pipeline`, `PipelineRun`, `PipelineResource`, `Task`, `TaskRun`, `Condition` and `ClusterTask`.
All `tekton.dev/v1alpha1` resources are available using the DSL `tektonClient.v1alpha1()`.
`tekton.dev/v1beta1` includes the CRDs  `Pipeline`, `PipelineRun`, `Task`, `TaskRun` and `ClusterTask`.
All `tekton.dev/v1beta1` resources are available using the DSL `tektonClient.v1beta1()`.

The usage of the resources follows the same pattern as for K8s resources like Pods or Deployments.
Here are some common examples:

- Listing all `PipelineRun` objects in some specific namespace:
```
PipelineRunList list = tektonClient.v1beta1().pipelineRuns().inNamespace("default").list();
```
- Create a `PipelineRun`:
```
PipelineRun pipelineRun = new PipelineRunBuilder()
        .withNewMetadata().withName("demo-run-1").endMetadata()
        .withNewSpec()
        .withNewPipelineRef().withName("demo-pipeline").endPipelineRef()
        .addNewParam().withName("greeting").withNewValue("Hello World!").endParam()
        .endSpec()
        .build();

tektonClient.v1beta1().pipelineRuns().inNamespace("default").create(pipelineRun);
```

### Knative Client
Fabric8 Kubernetes Client also has an extension for Knative.
It is pretty much the same as Kubernetes Client but has support for some additional Knative resources.

#### Initializing Knative Client
Initializing Knative client is the same as Kubernetes Client. 
```
try (final KnativeClient client = new DefaultKnativeClient()) {
  // Do stuff with client
}
```
This would pick up default settings, reading your `kubeconfig` file from `~/.kube/config` directory or whatever is defined inside `KUBECONFIG` environment variable.
But if you want to customize creation of client, you can also pass a `Config` object inside `DefaultKnativeClient`.
You can also create `KnativeClient` from an existing instance of `KubernetesClient`. 
There is a method called `adapt(..)` for this.
Here is an example:
```
KubernetesClient client = new DefaultKubernetesClient();
KnativeClient knativeClient = client.adapt(KnativeClient.class);
```

#### Knative Client DSL Usage
The usage of the resources follows the same pattern as for K8s resources like Pods or Deployments.
Here are some common examples:

- Listing all `Service` objects in some specific namespace:
```
ServiceList list = knativeClient.services().inNamespace("default").list();
```
- Create a `Service`:
```
try (KnativeClient kn = new DefaultKnativeClient()) {
    // Create Service object
    Service service = new ServiceBuilder()
            .withNewMetadata().withName("helloworld-go").endMetadata()
            .withNewSpec()
            .withNewTemplate()
            .withNewSpec()
            .addToContainers(new ContainerBuilder()
                    .withImage("gcr.io/knative-samples/helloworld-go")
                    .addNewEnv().withName("TARGET").withValue("Go Sample V1").endEnv()
                    .build())
            .endSpec()
            .endTemplate()
            .endSpec()
            .build();

    // Apply it onto Kubernetes Server
    kn.services().inNamespace("default").createOrReplace(service);
}
```
