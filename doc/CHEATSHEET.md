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
  * [EndpointSlice](#endpointslice)
  * [PersistentVolumeClaim](#persistentvolumeclaim)
  * [PersistentVolume](#persistentvolume)
  * [NetworkPolicy](#networkpolicy)
  * [PodDisruptionBudget](#poddisruptionbudget)
  * [SelfSubjectAccessReview](#selfsubjectaccessreview)
  * [SubjectAccessReview](#subjectaccessreview)
  * [LocalSubjectAccessReview](#localsubjectaccessreview)
  * [SelfSubjectRulesReview](#selfsubjectrulesreview)
  * [ClusterRole](#clusterrole)
  * [ClusterRoleBinding](#clusterrolebinding)
  * [Role](#role)
  * [RoleBinding](#rolebinding)
  * [Top/Metrics](#fetching-metrics)
  * [Generic Resource API](#resource-api)
  * [Generic ResourceList API](#resourcelist-api)
  * [CustomResourceDefinition](#customresourcedefinition)
  * [Resource Typed API](#resource-typed-api)
  * [Resource Typeless API](#resource-typeless-api)
  * [Resource Typed API vs. Resource Typeless API](#resource-typed-api-vs-resource-typeless-api)
  * [CertificateSigningRequest](#certificatesigningrequest)
  * [SharedInformers](#sharedinformers)
  * [List Options](#list-options)
  * [Delete Options](#delete-options)
  * [Watch Options](#watch-options)
  * [Log Options](#log-options)
  * [Serializing to yaml](#serializing-to-yaml)
  * [Running a Pod](#running-a-pod)
  * [Server Side Apply](#server-side-apply)

* [OpenShift Client DSL Usage](#openshift-client-dsl-usage)  
  * [Initializing OpenShift Client](#initializing-openshift-client)
  * [DeploymentConfig](#deploymentconfig)
  * [BuildConfig](#buildconfig)
  * [Route](#route)
  * [Project](#project)
  * [ImageStream](#imagestream)
  * [CatalogSource](#catalogsource)
  * [PrometheusRule](#prometheusrule)
  * [ServiceMonitor](#servicemonitor)
  * [ClusterResourceQuota](#clusterresourcequota)
  * [ClusterVersion](#clusterversion)
  * [EgressNetworkPolicy](#egressnetworkpolicy)

* [Tekton Client](#tekton-client)
  * [Initializing Tekton Client](#initializing-tekton-client)
  * [Tekton Client DSL Usage](#tekton-client-dsl-usage)

* [Knative Client](#knative-client)
  * [Initializing Knative Client](#initializing-knative-client)
  * [Knative Client DSL Usage](#knative-client-dsl-usage)
* [Logging](#Logging)
  
### Initializing Kubernetes Client
Typically, we create Kubernetes Client like this:
```
try (final KubernetesClient client = new KubernetesClientBuilder().build()) {
  // Do stuff with client
}
```
This would pick up default settings, reading your `kubeconfig` file from `~/.kube/config` directory or whatever is defined inside `KUBECONFIG` environment variable. But if you want to customize creation of client, you can also pass a `Config` object inside the builder like this:
```
Config kubeConfig = new ConfigBuilder()
  .withMasterUrl("https://192.168.42.20:8443/")
  .build()
try (final KubernetesClient client = new KubernetesClientBuilder().withConfig(kubeConfig).build()) {
  // Do stuff with client
}
```
### Kubernetes Client DSL Usage
This section contains DSL usage for all the supported resources inside Kubernetes Client library. Although, it's the same for most of the resources. But still, we've added it:

#### Pods
`Pods` are available in our dsl via the `client.pods()`. Here are some of the common usages of `Pod` resource:
- Loading a `Pod` from a `yaml` file into `Pod` object:
```java
Pod myPod = client.pods().load(new FileInputStream("some-pod.yml")).item();
```
- Listing all `Pod` objects in some specific namespace:
```java
PodList podList = client.pods().inNamespace("default").list();
```
- List all `Pod` objects in all namespaces:
```java
PodList podList = client.pods().inAnyNamespace().list();
```
- List `Pod` objects containing some labels:
```java
PodList podList = client.pods().inNamespace("default").withLabel("foo", "bar").list();
```
- Get `Pod` from server with some specific name:
```java
Pod myPod = client.pods().inNamespace("default").withName("nginx-pod").get();
```
- Create a `Pod`:
```java
Pod aPod = new PodBuilder().withNewMetadata().withName("demo-pod1").endMetadata()
    .withNewSpec()
    .addNewContainer()
    .withName("nginx")
    .withImage("nginx:1.7.9")
    .addNewPort().withContainerPort(80).endPort()
    .endContainer()
    .endSpec()
    .build();
Pod createdPod = client.pods().inNamespace("default").resource(aPod).create();
```
- Apply a `Pod` to Kubernetes Cluster with some existing object:
```java
client.pods().inNamespace("default").resource(pod).serverSideApply();
```
- Edit a `Pod` object:
```java
client.pods().inNamespace("default").withName("nginx").edit(
  p -> new PodBuilder(p).editOrNewMetadata().addToLabels("new","label").endMetadata().build()
);
```
- Get logs for `Pod` object:
```java
String log = client.pods().inNamespace("default").withName("test-pod").getLog();
```
- Watch logs for `Pod`:
```java
LogWatch watch = client.pods().inNamespace(namespace).withName(podName).tailingLines(10).watchLog(System.out);
```
- Delete a `Pod`:
```java
client.pods().inNamespace("default").withName("nginx").delete();
```
- Delete multiple `Pod` objects:
```java
client.resourceList(pod1, pod2).inNamespace("default").delete();
```
- Wait until a `Pod` is ready:
```java
Pod pod = client.pods().inNamespace("default").withName("nginx").waitUntilReady(5, TimeUnit.MINUTES);
```
- Wait until `Pod` meets some specific condition:
```java
Pod pod = client.pods().inNamespace("default").withName("nginx").waitUntilCondition(pod -> pod.getStatus().getPhase().equals("Succeeded"), 1, TimeUnit.MINUTES);
```
- Port Forward a `Pod`
```java
int containerPort =  client.pods().inNamespace("default").withName("testpod").get().getSpec().getContainers().get(0).getPorts().get(0).getContainerPort();
LocalPortForward portForward = client.pods().inNamespace("default").withName("testpod").portForward(containerPort, 8080);
```
- Watching `Pod`:
```java
final CountDownLatch deleteLatch = new CountDownLatch(1);
Watch podWatch = client.pods().withName("pod1").watch(new Watcher<>() {
    @Override
    public void eventReceived(Action action, Pod resource) {
      switch (action) {
        case DELETED:
          deleteLatch.countDown();
      }
    }

    @Override
    public void onClose(WatcherException e) { }
});
deleteLatch.await(10, TimeUnit.MINUTES);
```
- Upload file into a `Pod`
```java
    client.pods().inNamespace(currentNamespace).withName(pod1.getMetadata().getName())
      .file("/tmp/toBeUploaded").upload(tmpFile.toPath());
```
- Read file from a `Pod`
```java
    try (InputStream is = client.pods().inNamespace(currentNamespace).withName(pod1.getMetadata().getName()).file("/msg").read())  {
      String result = new BufferedReader(new InputStreamReader(is)).lines().collect(Collectors.joining("\n"));
    }
```
- Add ephemeral container to a `Pod`
```java
PodResource resource = client.pods().withName("pod1");
resource.ephemeralContainers()
  .edit(p -> new PodBuilder(p)
    .editSpec()
    .addNewEphemeralContainer()
    .withName("debugger")
    .withImage("busybox")
    .withCommand("sleep", "36000")
    .endEphemeralContainer()
    .endSpec()
    .build());

resource.waitUntilCondition(p -> p.getStatus()
	.getEphemeralContainerStatuses()
	.stream()
	.filter(s -> s.getName().equals("debugger"))
	.anyMatch(s -> s.getState().getRunning() != null), 2, TimeUnit.MINUTES);
ByteArrayOutputStream out = new ByteArrayOutputStream();
try (ExecWatch watch = resource.inContainer("debugger")
  .writingOutput(out)
  .exec("sh", "-c", "echo 'hello world!'")) {
  assertEquals(0, watch.exitCode().join());
  assertEquals("hello world!\n", out.toString());
}
```
- Using Kubernetes Client from within a `Pod`
When trying to access Kubernetes API from within a `Pod` authentication is done a bit differently as compared to when being done on your system. If you checkout [documentation](https://kubernetes.io/docs/tasks/access-application-cluster/access-cluster/#accessing-the-api-from-a-pod). Client authenticates by reading `ServiceAccount` from `/var/run/secrets/kubernetes.io/serviceaccount/` and reads environment variables like `KUBERNETES_SERVICE_HOST` and `KUBERNETES_SERVICE_PORT` for apiServer URL. You don't have to worry about all this when using Fabric8 Kubernetes Client. You can simply use it like this and client will take care of everything:
```
// reads serviceaccount from mounted volume and gets apiServer url from environment variables itself.
KubernetesClient client = new KubernetesClientBuilder().build();
```
You can also checkout a demo example here: [kubernetes-client-inside-pod](https://github.com/rohanKanojia/kubernetes-client-inside-pod)


#### Service
`Service` is available in Kubernetes client API via `client.services()`. Here are some common usages of `Service`:
- Loading a `Service` from yaml:
```java
Service aService = client.services().load(new FileInputStream("service.yml")).item();
```
- Get a `Service` from API server:
```java
Service service = client.services().inNamespace("default").withName("some-service").get();
```
- Create a `Service`:
```java
Service createdSvc = client.services().inNamespace("default").resource(svc).create();
```
- Apply a `Service` object onto Kubernetes Cluster:
```java
Service createdSvc = client.services().inNamespace("default").resource(svc).serverSideApply();
```
- List all `Service` objects in some specific namespace:
```java
ServiceList svcList = client.services().inNamespace("default").list();
```
- List all `Service` objects in any namespace:
```java
ServiceList svcList = client.services().inAnyNamespace().list();
```
- List `Service` objects with some specific labels:
```java
ServiceList svcList = client.services().inNamespace("default").withLabel("foo", "bar").list();
```
- Delete a `Service`:
```java
client.services().inNamespace("default").withName("some-svc").delete();
```
- Watching a `Service`:
```java
client.services().inNamespace("default").watch(new Watcher<>() {
	@Override
	public void eventReceived(Action action, Service resource) {
		// Perform something depending upon action
	}

	@Override
	public void onClose(WatcherException cause) {

	}
});
```

#### Deployment
`Deployment` is available in Kubernetes-Client API via `client.apps().deployment()`. Here are some of the common usages of `Deployment`:
- Loading a `Deployment` from yaml into object:
```java
Deployment aDeployment = client.apps().deployments().load(new FileInputStream("test-deployments.yml")).item();
```
- Get a `Deployment` from API server:
```java
Deployment deploy = client.apps().deployments().inNamespace("default").withName("deploy-1").get();
```
- Create a `Deployment`:
```java
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

client.apps().deployments().inNamespace("default").resource(deployment1).create();
```
- Apply a `Deployment` object onto Kubernetes Cluster:
```java
Deployment createdDeployment = client.apps().deployments().inNamespace("default").resource(deployObj).serverSideApply();
```
- List `Deployment` objects in some specific namespace:
```java
DeploymentList aDeploymentList = client.apps().deployments().inNamespace("default").list();
```
- List `Deployment` objects in any namespace:
```java
DeploymentList aDeploymentList = client.apps().deployments().inAnyNamespace().list();
```
- List `Deployment` objects with some specific labels:
```java
DeploymentList aDeployList = client.apps().deployments().inNamespace("default").withLabel("foo", "bar").list();
```
- Editing a `Deployment`:
```java
// Scales Deployment to 2 replicas
Deployment updatedDeploy = client.apps().deployments().inNamespace("default")
  .withName("deployment1").edit(
    d -> new DeploymentBuilder(d).editSpec().withReplicas(2).endSpec().build()
  );
```
- Update single container image inside `Deployment`:
```java
Deployment updatedDeployment = client.apps()
  .deployments()
  .inNamespace("default")
  .withName("ngix-controller")
  .updateImage("docker.io/nginx:latest");
```
- Update multiple container images inside `Deployment`:
```java
Map<String, String> containerToImageMap = new HashMap<>();
containerToImageMap.put("nginx", "nginx:perl");
containerToImageMap.put("sidecar", "someImage:someVersion");
Deployment updatedDeployment = client.apps().deployments()
      .inNamespace("default")
      .withName("nginx-deployment")
      .updateImage(containerToImageMap);

```
- Rollout restart a `Deployment`:
```java
Deployment deployment = client.apps().deployments()
      .inNamespace("default")
      .withName("nginx-deployment")
      .rolling()
      .restart();
```
- Pause Rollout of a `Deployment`:
```java
Deployment deployment = client.apps().deployments()
      .inNamespace("default")
      .withName("nginx-deployment")
      .rolling()
      .pause();
```
- Resume Rollout of a `Deployment`:
```java
Deployment deployment = client.apps().deployments()
      .inNamespace("default")
      .withName("nginx-deployment")
      .rolling()
      .resume();
```
- Undo Rollout of a `Deployment`:
```java
Deployment deployment = client.apps().deployments()
      .inNamespace("default")
      .withName("nginx-deployment")
      .rolling()
      .undo();
```
- Deleting a `Deployment`:
```java
client.apps().deployments().inNamespace("default").withName("foo").delete();
```
- Watching a `Deployment`:
```java
client.apps().deployments().inNamespace("default").watch(new Watcher<>() {
	@Override
	public void eventReceived(Action action, Deployment resource) {
		// Do stuff depending upon action
	}

	@Override
	public void onClose(WatcherException cause) {

	}
});
```
- Scale a `Deployment`:
```java
client.apps().deployments().inNamespace("default").withName("nginx-deployment").scale(1);
```
- Get `Deployment` logs:
```java
client.apps().deployments().inNamespace("default").withName("nginx").watchLog(System.out);
```

#### ReplicaSet

`ReplicaSet` is available in Kubernetes Client using `client.apps().replicaSets()`. Here are some of the common examples of how to use `ReplicaSet` with Kubernetes Client api:
- Load a `ReplicaSet` object from yaml:
```java
ReplicaSet replicaSet = client.apps().replicaSets().inNamespace("default")
  .load(new FileInputStream("test-replicaset.yml")).item();
```
- Get a `ReplicaSet` from API server:
```java
ReplicaSet rs = client.apps().replicaSets().inNamespace("default").withName("rs1").get();
```
- Create a `ReplicaSet`:
```java
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

client.apps().replicaSets().inNamespace("default").resources(replicaset1).create();
```
- Apply an existing `ReplicaSet`:
```java
ReplicaSet rs = client.apps().replicaSets().inNamespace("default").resource(replicaSet).serverSideApply();
```
- List `ReplicaSet` objects in some namespace:
```java
ReplicaSetList rsList = client.apps().replicaSets().inNamespace("default").list();
```
- List `ReplicaSet` objects in any namespace:
```java
ReplicaSetList rsList = client.apps().replicaSets().inAnyNamespace().list();
```
- List `ReplicaSet` objects in some namespace with some labels:
```java
ReplicaSetList rsList = client.apps().replicaSets().inNamespace("default").withLabel("foo", "bar").list(); 
```
- Delete `ReplicaSet`:
```java
client.apps().replicaSets().inNamespace("default").withName("rs1").delete();
```
- Watch `ReplicaSet`:
```java
client.apps().replicaSets().inNamespace("default").watch(new Watcher<>() {
	@Override
	public void eventReceived(Action action, ReplicaSet resource) {
		// Do some stuff depending upon action type
	}

	@Override
	public void onClose(WatcherException e) {

	}
});
```
- Scale `ReplicaSet`
```java
// Scale to 3 replicas
client.apps().replicaSets().inNamespace("default").withName("nginx-rs").scale(3);
```
- Update Image in `ReplicaSet`
```java
ReplicaSet replicaSet = client.apps().replicaSets()
        .inNamespace("default")
        .withName("soaktestrs")
        .updateImage("nickchase/soaktest");
```
- Update multiple Images in `ReplicaSet`:
```java
Map<String, String> containerToImageMap = new HashMap<>();
containerToImageMap.put("c1", "image1");
containerToImageMap.put("c2", "image2");
ReplicaSet replicaSet = client.apps().replicaSets()
            .inNamespace("default")
            .withName("soaktestrs")
            .updateImage(containerToImageMap);
```

### ReplicationController

`ReplicationController` resource is available in Kubernetes API using the `client.replicationControllers()`. Here are some of the examples of it's common usage:
- Load `ReplicationController` object from yaml:
```java
ReplicationController aReplicationController = client.replicationControllers().inNamespace("default")
      .load(new FileInputStream("/test-replicationcontroller.yml")).item();
```
- Get `ReplicationController` object from API server:
```java
ReplicationController rc = client.replicationControllers().inNamespace("default").withName("nginx-controller").get();
```
- Create `ReplicationController` object:
```java
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

ReplicationController rc = client.replicationControllers().inNamespace("default").resource(rc1).create();
```
- Apply `ReplicationController` object onto Kubernetes Cluster:
```java
ReplicationController rc = client.replicationControllers().inNamespace("default").resource(rc1).serverSideApply();
``` 
- List `ReplicationController` object in some namespace:
```java
ReplicationControllerList rcList = client.replicationControllers().inNamespace("default").list();
```
- List `ReplicationController` objects in any namespace:
```java
ReplicationControllerList rcList = client.replicationControllers().inAnyNamespace("default").list();
```
- List `ReplicationController` objects in some namespace with some label:
```java
ReplicationControllerList rcList = client.replicationControllers().inNamespace("default").withLabel("foo", "bar").list();
```
- Delete `ReplicationController`:
```java
client.replicationControlers().inNamespace("default").withName("nginx-controller").delete();
```
- Watch `ReplicationController` in some specific namespace:
```java
client.replicationControllers().inNamespace(currentNamespace).watch(new Watcher<>() {
  @Override
  public void eventReceived(Action action, ReplicationController resource) {
    // Do something depending upon action type    
  }

  @Override
  public void onClose(WatcherException cause) {

  }
});
```
- Scale `ReplicationController`:
```
ReplicationController rc = client.replicationControllers().inNamespace("default").withName("nginx-controller").scale(2);
```
- Update image in `ReplicationController`:
```java
ReplicationController rc = client.replicationControllers()
       .inNamespace("default")
       .withName("nginx")
       .updateImage("nginx:latest");
```
- Update multiple images in `ReplicationController`:
```java
Map<String, String> containerToImageMap = new HashMap<>();
containerToImageMap.put("c1", "image1");
containerToImageMap.put("c2", "image2");
ReplicationController rc = client.replicationControllers()
       .inNamespace("default")
       .withName("nginx")
       .updateImage(controllerToImageMap);
```

### ConfigMap
`ConfigMap` resource is available in Kubernetes Client api via the `client.configMaps()`. Here are some examples of common usage:
- Load `ConfigMap` object from yaml:
```java
ConfigMap configMap = client.configMaps().load(new FileInputStream("configmap1.yml")).item();
```
- Get `ConfigMap` from API server:
```java
ConfigMap configMap = client.configMaps().inNamespace("default").withName("configmap1").get();
```
- Create `ConfigMap`:
```java
ConfigMap configMap1 = new ConfigMapBuilder()
      .withNewMetadata().withName("configmap1").endMetadata()
      .addToData("1", "one")
      .addToData("2", "two")
      .addToData("3", "three")
      .build();
ConfigMap configMap = client.configMaps().inNamespace("default").resource(configMap1).create();
```
- Apply a `ConfigMap` object onto Kubernetes Cluster:
```java
ConfigMap configMap = client.configMaps().inNamespace("default").resource(configMap1).serverSideApply();
```
- List `ConfigMap` objects in some namespace:
```java
ConfigMapList configMapList = client.configMaps().inNamespace("default").list();
```
- List `ConfigMap` objects in any namespace:
```java
ConfigMapList configMapList = client.configMaps().inAnyNamespace().list();
```
- List `ConfigMap` objects in some namespace with some labels:
```java
ConfigMapList configMapList = client.configMaps().inNamespace("default").withLabel("foo", "bar").list();
```
- Delete `ConfigMap`:
```java
client.configMaps().inNamespace("default").withName("configmap1").delete();
```
- Watch `ConfigMap`:
```java
client.configMaps().inNamespace("default").watch(new Watcher<>() {
  @Override
  public void eventReceived(Action action, ConfigMap resource) {
    // Do something depending upon action type    
  }

  @Override
  public void onClose(WatcherException cause) {

  }
});
```
- Update `ConfigMap`:
```java
ConfigMap configMap1 = client.configMaps().inNamespace(currentNamespace).withName("configmap1").edit(
  c -> new ConfigMapBuilder(c).addToData("4", "four").build()
);
```

### Secret

`Secret` resource is available in Kubernetes Client api via `client.secrets()`. Here are some of the examples of it's common usages:
- Load `Secret` from yaml:
```java
Secret aSecret = client.secrets().inNamespace("default").load(new FileInputStream("test-secret.yml")).item();
```
- Get a `Secret` from API server:
```java
Secret secret = client.secrets().inNamespace("default").withName("secret1").get()
```
- Create a `Secret`:
```java
Secret secret1 = new SecretBuilder()
      .withNewMetadata().withName("secret1").endMetadata()
      .addToData("username", "guccifer")
      .addToData("password", "shadowgovernment")
      .build();
Secret secretCreated = client.secrets().inNamespace("default").resource(secret1).create();
```
- Apply a `Secret` onto Kubernetes Cluster:
```java
Secret createdSecret = client.secrets().inNamespace("default").resource(secret1).serverSideApply();
```
- List `Secret` resources in some namespace:
```java
SecretList secretList = client.secrets().inNamespace("default").list();
```
- List `Secret` resources in any namespace:
```java
SecretList secretList = client.secrets().inAnyNamespace().list();
```
- List `Secret` resources in some namespace with some label:
```java
SecretList secretList = client.secrets().inNamespace("default").withLabel("foo", "bar").list();
```
- Edit `Secret`:
```java
Secret secret1 = client.secrets().inNamespace(currentNamespace).withName("secret1").edit(
  s -> new SecretBuilder(s).withType("Opaque").build()
);
```
- Delete `Secret`:
```java
client.secrets().inNamespace("default").withName("secret1").delete();
```
- Watch `Secret`:
```java
client.secrets().inNamespace("default").watch(new Watcher<>() {
  @Override
  public void eventReceived(Action action, Secret resource) {
    // Do something depending upon action type
  }

  @Override
  public void onClose(WatcherException cause) {

  }
});
```

### Job
`Job` resource is available in Kubernetes Client API via `client.batch().jobs()`. Here are some of the examples of common usage:
- Loading a `Job` from yaml:
```java
Job job = client.batch().jobs().load(new FileInputStream("sample-job.yml")).item();
```
- Get a `Job` resource with some name from API server:
```java
Job job = client.batch().jobs().inNamespace("default").withName("pi").get();
```
- Create `Job`:
```java
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

client.batch().jobs().inNamespace("default").resource(job).create();
```
- Apply `Job` onto Kubernetes Cluster:
```java
Job job = client.batch().v1().jobs().inNamespace("default").resource(job1).serverSideApply();
```
- List `Job` in some namespace:
```java
JobList jobList = client.batch().jobs().inNamespace("default").list();
```
- List `Job` in any namespace:
```java
JobList jobList = client.batch().jobs().inAnyNamespace().list();
```
- List `Job` resources in some namespace with some labels:
```java
JobList jobList = client.batch().jobs().inNamespace("default").withLabel("foo", "bar").list();
```
- Delete `Job`:
```java
client.batch().jobs().inNamespace("default").withName("pi").delete();
```
- Watch `Job`:
```java
client.batch().jobs().inNamespace("default").watch(new Watcher<>() {
    @Override
    public void eventReceived(Action action, Job resource) {
      // Do something depending upon action 
    }

    @Override
    public void onClose(WatcherException cause) {

    }
});
```

### CronJob
`CronJob` resource is available in Kubernetes Client api via `client.batch().cronjobs()`. Here are some of the examples of its usages:
- Load `CronJob` from yaml:
```java
CronJob cronJob = client.batch().cronjobs().load(new FileInputStream("cronjob.yml")).item();
```
- Get a `CronJob` from Kubernetes API server:
```java
CronJob aCronJob = client.batch().cronjobs().inNamespace("default").withName("some-cj").get();
```
- Create `CronJob`:
```java
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

cronJob1 = client.batch().cronjobs().inNamespace("default").resource(cronJob1).create();
```
- Apply `CronJob` onto Kubernetes Cluster:
```java
CronJob cronJob = client.batch().v1().cronjobs().inNamespace("default").resource(cronJob1).serverSideApply();
```
- List some `CronJob` objects in some namespace:
```java
CronJobList cronJobList = client.batch().cronjobs().inNamespace("default").list()
```
- List some `CronJob` objects in any namespace:
```java
CronJobList cronJobList = client.batch().cronjobs().inAnyNamespace().list();
```
- List some `CronJob` objects in some namespace with some label:
```java
CronJobList cronJobList = client.batch().cronjobs().inNamespace("default").withLabel("foo", "bar").list();
```
- Edit/Update `CronJob`:
```java
CronJob cronJob1 = client.batch().cronjobs().inNamespace("default").withName(cronJob1.getMetadata().getName()).edit(
  cj -> new CronJobBuilder(cj).editSpec().withSchedule("*/1 * * * *").endSpec().build()
);
```
- Delete `CronJob`:
```java
client.batch().cronjobs().inNamespace("default").withName("pi").delete();
```

### Namespace
`Namespace` is available in Kubernetes Client API via `client.namespaces()`. Here are some of the common usages:
- Load `Namespace` from yaml:
```java
Namespace namespace = client.namespaces().load(new FileInputStream("namespace-test.yml")).item();
```
- Get `Namespace` from Kubernetes API server:
```java
Namespace namespace = client.namespaces().withName("namespace1").get();
```
- List `Namespace` objects:
```java
NamespaceList namespaceList = client.namespaces().list();
```
- List `Namespace` objects with some labels:
```java
NamespaceList namespaceList = client.namespaces().withLabel("key1", "value1").list();
```
- Delete `Namespace` objects:
```java
client.namespaces().withName("ns1").delete();
```

### ServiceAccount
`ServiceAccount` resource is available in Kubernetes Client API via `client.serviceAccounts()`. Here are some examples of it's usage:
- Load `ServiceAccount` from yaml:
```java
ServiceAccount svcAccount = client.serviceAccounts().inNamespace("default")
  .load(new FileInputStream("sa.yml")).item();
```
- Get `ServiceAccount` from Kubernetes API server:
```java
ServiceAccount sa = client.serviceAccounts().inNamespace("default").withName("sa-ribbon").get();
```
- Create `ServiceAccount`:
```java
ServiceAccount serviceAccount1 = new ServiceAccountBuilder()
  .withNewMetadata().withName("serviceaccount1").endMetadata()
  .withAutomountServiceAccountToken(false)
  .build();

client.serviceAccounts().inNamespace("default").resource(serviceAccount1).create();
```
- Apply `ServiceAccount` onto Kubernetes cluster:
```java
ServiceAccount serviceAccount = client.serviceAccounts().inNamespace("default").resource(serviceAccount1).serverSideApply();
```
- List `ServiceAccount` in some specific namespace:
```java
ServiceAccountList svcAccountList = client.serviceAccounts().inNamespace("default").list();
```
- List `ServiceAccount` in some namespace with labels:
```java
ServiceAccountList saList = client.serviceAccounts().inNamespace("default").withLabel("foo", "bar").list();
```
- Update/Edit `ServiceAccount`:
```java
ServiceAccount serviceAccount1 = client.serviceAccounts().inNamespace("default").withName("serviceaccount1").edit(
  sa -> new ServiceAccountBuilder(sa).addNewSecret().withName("default-token-uudp").endSecret()
  .addNewImagePullSecret().withName("myregistrykey").endImagePullSecret()
  .build();
);
```
- Delete `ServiceAccount`:
```java
client.serviceAccounts().inNamespace("default").withName("serviceaccount1").delete();
```

### Ingress
`Ingress` resource is available in Kubernetes Client API via `client.network().v1().ingress()`. Here are some examples regarding its usage:
- Load `Ingress` from yaml:
```java
Ingress ingress = client.network().v1().ingress().load(new FileInputStream("ingress.yml")).item();
```
- Get `Ingress` from Kubernetes API server:
```java
Ingress ingress = client.network().v1().ingress().inNamespace("default").withName("ingress1").get();
```
- Create `Ingress`:
```java
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
client.network().v1().ingress().inNamespace("default").resource(ingress).create();
```
- Apply `Ingress` onto Kubernetes Cluster:
```java
Ingress igx = client.network().v1().ingresses().inNamespace("default").resource(ingress).serverSideApply();
```
- List `Ingress` in some namespace:
```java
IngressList ingressList = client.network().v1().ingress().inNamespace("default").list();
```
- List `Ingress` in any namespace:
```java
IngressList ingressList = client.network().v1().ingress().inAnyNamespace().list();
```
- List `Ingress` with some label in any namespace:
```java
IngressList ingressList = client.network().v1().ingress().inNamespace("default").withLabel("foo", "bar").list();
```
- Delete `Ingress`:
```java
client.network().v1().ingress().inNamespace("default").withName("ingress1").delete();
```

### StatefulSet

`StatefulSet` resource is available in Kubernetes API via `client.apps().statefulsets()`. Here are some examples of its common usages:
- Load `StatefulSet` from yaml:
```java
StatefulSet aStatefulSet = client.apps().statefulSets()
  .load(new FileInputStream("test-statefulset.yml")).item();
```
- Get a `StatefulSet` from Kubernetes API server:
```java
StatefulSet ss1 = client.apps().statefulSets().inNamespace("default").withName("ss1").get();
```
- Create a `StatefulSet`:
```java
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

StatefulSet ss = client.apps().statefulSets().inNamespace("default").resource(ss1).create();
```
- Apply `StatefulSet` onto Kubernetes Cluster:
```java
StatefulSet ss = client.apps().statefulSets().inNamespace("default").resource(ss1).serverSideApply();
```
- List `StatefulSet` in some particular namespace:
```java
StatefulSetList statefulSetList = client.apps().statefulSets().inNamespace("default").list();
```
- List `StatefulSet` in any namespace:
```java
StatefulSetList statefulSetList = client.apps().statefulSets().inAnyNamespace().list();
```
- List `StatefulSet` in some namespace with label:
```java
StatefulSetList statefulSetList = client.apps().statefulSets().inNamespace("default").withLabel("foo", "bar").list();
```
- Delete `StatefulSet`:
```java
client.apps().statefulSets().inNamespace("default").withName("ss1").delete();
```
- Scale `StatefulSet`:
```java
client.apps().statefulSets().inNamespace("default").withName("ss1").scale(2);
```
- Watch `StatefulSet`:
```java
client.apps().statefulSets().inNamespace("default").withName("ss1").watch(new Watcher<>() {
  @Override
  public void eventReceived(Action action, StatefulSet resource) {
    // Do something on action type
  }

  @Override
  public void onClose(WatcherException cause) {

  }
})
```
- Update Image in `StatefulSet`:
```java
StatefulSet statefulSet = client.apps().statefulSets()
      .inNamespace("default")
      .withName("web")
      .updateImage("nginx:1.19");
```
- Updated multiple containers in `StatefulSet`:
```java
Map<String, String> containerToImageMap = new HashMap<>();
containerToImageMap("container1", "nginx:1.9");
containerToImageMap("container2", "busybox:latest");
Statefulset statefulSet = client.apps().statefulSets()
      .inNamespace("default")
      .withName("web")
      .updateImage(params);
```
- Restart Rollout for `StatefulSet`:
```java
StatefulSet ss = client.apps().statefulSets()
        .inNamespace("default")
        .withName("web")
        .rolling()
        .restart();
```
- Pause Rollout for `StatefulSet`:
```java
StatefulSet ss = client.apps().statefulSets()
         .inNamespace("default")
         .withName("web")
         .rolling()
         .pause();
```
- Resume Rollout for `StatefulSet`:
```java
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
```java
DaemonSet ds = client.apps().daemonSets().load(new FileInputStream("daemonset.yaml")).item();
```
- Get `DaemonSet` from Kubernetes API server:
```java
DaemonSet ds = client.apps().daemonSets().inNamespace("default").withName("ds1").get();
```
- Create `DaemonSet`:
```java
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
ds = client.apps().daemonSets().inNamespace("default").resource(ds).create();
```
- Apply a `DaemonSet` onto Kubernetes Cluster:
```java
DaemonSet ds = client.apps().daemonSets().inNamespace("default").resource(ds1).serverSideApply();
```
- List `DaemonSet` in some namespace:
```java
DaemonSetList dsList = client.apps().daemonSets().inNamespace("default").list();
```
- List `DaemonSet` in any namespace:
```java
DaemonSetList dsList = client.apps().daemonSets().inAnyNamespace().list();
```
- List `DaemonSet` with some label:
```java
DaemonSetList dsList = client.apps().daemonSets().inNamespace("default").withLabel("foo", "bar").list();
```
- Delete `DaemonSet`:
```java
client.apps().daemonSets().inNamespace("default").withName("ds1").delete();
```
- Watch `DaemonSet`:
```java
client.apps().daemonSets().inNamespace("default").watch(new Watcher<>() {
  @Override
  public void eventReceived(Action action, DaemonSet resource) {
    // Do something depending upon action type
  }

  @Override
  public void onClose(WatcherException cause) {

  }
});
```

#### EndpointSlice
`EndpointSlice` resource is available in Kubernetes Client API via `client.discovery().v1().endpointSlices()`. Here are some examples of its common usage:
- Load `EndpointSlice` from yaml:
```java
EndpointSlice es = client.discovery().v1().endpointSlices().load(getClass().getResourceAsStream("/endpointslice.yml")).item();
```
- Get `EndpointSlice` from Kubernetes API server:
```java
EndpointSlice esFromServer = client.discovery().v1().endpointSlices().inNamespace("default").withName("es1").get();
```
- Create `EndpointSlice`:
```java
EndpointSlice esToCreate = new EndpointSliceBuilder()
  .withNewMetadata()
  .withName(name)
  .addToLabels("kubernetes.io/service-name", "example")
  .endMetadata()
  .withAddressType("IPv4")
  .addNewPort()
  .withName("http")
  .withPort(80)
  .endPort()
  .addNewEndpoint()
  .withAddresses("10.1.2.3")
  .withNewConditions().withReady(true).endConditions()
  .withHostname("pod-1")
  .addToTopology("kubernetes.io/hostname", "node-1")
  .addToTopology("topology.kubernetes.io/zone", "us-west2-a")
  .endEndpoint()
  .build();
esToCreate = client.discovery().v1().endpointSlices().inNamespace("ns1").resource(esToCreate).create();
```
- Apply `EndpointSlice` onto Kubernetes Cluster:
```java
EndpointSlice es = client.discovery().v1().endpointSlices().inNamespace("ns1").resource(endpointSlice).serverSideApply();
```
- List `EndpointSlice` in some namespace:
```java
EndpointSliceList esList = client.discovery().v1().endpointSlices().inNamespace("default").list();
```
- List `EndpointSlice` in any namespace:
```java
EndpointSliceList esList = client.discovery().v1().endpointSlices().inAnyNamespace().list();
```
- List `EndpointSlice` with some label:
```java
EndpointSliceList esList = client.discovery().v1().endpointSlices().inNamespace("default").withLabel("foo", "bar").list();
```
- Delete `EndpointSlice`:
```java
client.discovery().v1().endpointSlices().inNamespace("default").withName("test-es").delete();
```
- Watch `EndpointSlice`:
```java
client.discovery().v1().endpointSlices().inNamespace("default").watch(new Watcher<>() {
  @Override
  public void eventReceived(Action action, EndpointSlice resource) {
    
  }

  @Override
  public void onClose(WatcherException cause) {

  }
});
```

### PersistentVolumeClaim
`PersistentVolumeClaim` is available in Kubernetes Client API via `client.persistentVolumeClaims()`. Here are some examples of it's common usage:
- Load a `PersistentVolumeClaim` from yaml:
```java
PersistentVolumeClaim pvc = client.persistentVolumeClaims().load(new FileInputStream("pvc.yaml")).item();
```
- Get a `PersistentVolumeClaim` object from Kubernetes API server:
```java
PersistentVolumeClaim pvc = client.persistentVolumeClaims().inNamespace("default").withName("test-pv-claim").get();
```
- Create `PersistentVolumeClaim`:
```java
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

client.persistentVolumeClaims().inNamespace("default").resource(persistentVolumeClaim).item();
```
- Apply `PersistentVolumeClaim` onto Kubernetes Cluster:
```java
PersistentVolumeClaim pvc = client.persistentVolumeClaims().inNamespace("default").resource(pvcToCreate).serverSideApply();
```
- List `PersistentVolumeClaim` objects in a particular namespace:
```java
PersistentVolumeClaimList pvcList = client.persistentVolumeClaims().inNamespace("default").list();
```
- List `PersistentVolumeClaim` objects in any namespace:
```java
PersistentVolumeClaimList pvcList = client.persistentVolumeClaims().inAnyNamespace().list();
```
- List `PersistentVolumeClaim` objects in some namespace with some labels:
```java
PersistentVolumeClaimList pvcList = client.persistentVolumeClaims().inNamespace("default").withLabel("foo", "bar").list();
```
- Delete `PersistentVolumeClaim`:
```java
client.persistentVolumeClaims().inNamespace("default").withName("test-pv-claim").delete();
```

### PersistentVolume
`PersistentVolume` resource is available in Kubernetes Client API via `client.persistentVolumes()`. Here are some of the examples of it's common usage:
- Load a `PersistentVolume` from yaml:
```java
PersistentVolume pv = client.persistentVolumes().load(new FileInputStream("pv.yaml")).item();
```
- Get a `PersistentVolume` from Kubernetes API server:
```java
PersistentVolume pv = client.persistentVolumes().withName("test-local-pv").get();
```
- Create `PersistentVolume`:
```java
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

PersistentVolume pvCreated = client.persistentVolumes().resource(pv).create();
```
- Apply `PersistentVolume` onto Kubernetes Cluster:
```java
PersistentVolume pv = client.persistentVolumes().resource(pvToCreate).serverSideApply();
```
- List `PersistentVolume`:
```java
PersistentVolumeList pvList = client.persistentVolumes().list();
```
- List `PersistentVolume` with some labels:
```java
PersistentVolumeList pvList = client.persistentVolumes().withLabel("foo", "bar").list();
```
- Delete `PersistentVolume`:
```java
client.persistentVolumes().withName("test-local-pv").delete();
```

### NetworkPolicy
`NetworkPolicy` is available in Kubernetes Client API via `client.network().networkPolicies()`. Here are some examples of it's common usages:
- Load a `NetworkPolicy` from yaml:
```java
NetworkPolicy loadedNetworkPolicy = client.network().networkPolicies()
  .load(new FileInputStream("/test-networkpolicy.yml")).item();
```
- Get `NetworkPolicy` from Kubernetes API server:
```java
NetworkPolicy getNetworkPolicy = client.network().networkPolicies()
  .withName("networkpolicy").get();
```
- Create `NetworkPolicy`:
```java
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

NetworkPolicy npCreated = client.network().networkPolicies().resource(networkPolicy).create();
```
- Apply `NetworkPolicy` onto Kubernetes Cluster:
```java
NetworkPolicy npCreated = client.network().networkPolicies().resource(networkPolicy).serverSideApply();
```
- List `NetworkPolicy`:
```java
NetworkPolicyList networkPolicyList = client.network().networkPolicies().list();
```
- List with labels `NetworkPolicy`:
```java
NetworkPolicyList networkPolicyList = client.network().networkPolicies()
  .withLabels(Collections.singletonMap("foo","bar")).list();
```
- Delete `NetworkPolicy`:
```java
client.network().networkPolicies().withName("np-test").delete();
```

### PodDisruptionBudget
`PodDisruptionBudget` is available in Kubernetes Client API via `client.policy().v1().podDisruptionBudget()`. Here are some of the examples of its usage:
- Load `PodDisruptionBudget` from yaml:
```java
PodDisruptionBudget pdb = client.policy().v1().podDisruptionBudget().load(new FileInputStream("/test-pdb.yml")).item();
```
- Get `PodDisruptionBudget` from Kubernetes API server:
```java
PodDisruptionBudget podDisruptionBudget = client.policy().v1().podDisruptionBudget().inNamespace("default").withName("poddisruptionbudget1").get();
```
- Create `PodDisruptionBudget`:
```java
PodDisruptionBudget podDisruptionBudget = new PodDisruptionBudgetBuilder()
    .withNewMetadata().withName("zk-pkb").endMetadata()
    .withNewSpec()
    .withMaxUnavailable(new IntOrString("1%"))
    .withNewSelector()
    .withMatchLabels(Collections.singletonMap("app", "zookeeper"))
    .endSelector()
    .endSpec()
    .build();

client.policy().v1().podDisruptionBudget().inNamespace("default").resource(podDisruptionBudget).create();
```
- Apply `PodDisruptionBudget` onto Kubernetes Cluster:
```java
PodDisruptionBudget pdb = client.policy().v1().podDisruptionBudget().inNamespace("default").resource(podDisruptionBudgetObj).serverSideApply();
```
- List `PodDisruptionBudget` in some namespace:
```java
PodDisruptionBudgetList podDisruptionBudgetList = client.policy().v1().podDisruptionBudget().inNamespace("default").list();
```
- List `PodDisruptionBudget` in any namespace:
```java
PodDisruptionBudgetList pdbList =client.policy().v1().podDisruptionBudget().inAnyNamespace().list();
```
- List `PodDisruptionBudget` with labels:
```java
PodDisruptionBudgetList pdbList = client.policy().v1().podDisruptionBudget().inNamespace("default").withLabel("foo", "bar").list();
```
- Delete `PodDisruptionBudget`:
```java
client.policy().v1().podDisruptionBudget().inNamespace("default").withName("poddisruptionbudget1").delete();
```

### SelfSubjectAccessReview
- Create `SelfSubjectAccessReview`(equivalent of `kubectl auth can-i create deployments --namespace dev`):
```java
try (KubernetesClient client = new KubernetesClientBuilder().build()) {
    SelfSubjectAccessReview ssar = new SelfSubjectAccessReviewBuilder()
            .withNewSpec()
            .withNewResourceAttributes()
            .withGroup("apps")
            .withResource("deployments")
            .withVerb("create")
            .withNamespace("dev")
            .endResourceAttributes()
            .endSpec()
            .build();

    ssar = client.authorization().v1().selfSubjectAccessReview().create(ssar);

    System.out.println("Allowed: "+  ssar.getStatus().getAllowed());
}
```

### SubjectAccessReview
- Create `SubjectAccessReview`:
```java
try (KubernetesClient client = new KubernetesClientBuilder().build()) {
    SubjectAccessReview sar = new SubjectAccessReviewBuilder()
            .withNewSpec()
            .withNewResourceAttributes()
            .withGroup("apps")
            .withResource("deployments")
            .withVerb("create")
            .withNamespace("default")
            .endResourceAttributes()
            .withUser("kubeadmin")
            .endSpec()
            .build();

    sar = client.authorization().v1().subjectAccessReview().create(sar);

    System.out.println("Allowed: "+  sar.getStatus().getAllowed());
}
```
### LocalSubjectAccessReview
- Create `LocalSubjectAccessReview`:
```java
try (KubernetesClient client = new KubernetesClientBuilder().build()) {
    LocalSubjectAccessReview lsar = new LocalSubjectAccessReviewBuilder()
            .withNewMetadata().withNamespace("default").endMetadata()
            .withNewSpec()
            .withUser("foo")
            .withNewResourceAttributes()
            .withNamespace("default")
            .withVerb("get")
            .withGroup("apps")
            .withResource("pods")
            .endResourceAttributes()
            .endSpec()
            .build();
     lsar = client.authorization().v1().localSubjectAccessReview().inNamespace("default").create(lsar);
     System.out.println(lsar.getStatus().getAllowed());
}
```

### SelfSubjectRulesReview
- Create `SelfSubjectRulesReview`:
```java
try (KubernetesClient client = new KubernetesClientBuilder().build()) {
    SelfSubjectRulesReview selfSubjectRulesReview = new SelfSubjectRulesReviewBuilder()
            .withNewMetadata().withName("foo").endMetadata()
            .withNewSpec()
            .withNamespace("default")
            .endSpec()
            .build();

    selfSubjectRulesReview = client.authorization().v1().selfSubjectRulesReview().create(selfSubjectRulesReview);
    System.out.println(selfSubjectRulesReview.getStatus().getIncomplete());
    System.out.println("non resource rules: " + selfSubjectRulesReview.getStatus().getNonResourceRules().size());
    System.out.println("resource rules: " + selfSubjectRulesReview.getStatus().getResourceRules().size());
}
```

### ClusterRole
`ClusterRole` is available in Kubernetes Client API via `client.rbac().clusterRoles()`. Here are some of the common usages:
- Load `ClusterRole` from yaml:
```java
ClusterRole clusterRole = client.rbac().clusterRoles().load(new FileInputStream("clusterroles-test.yml")).item();
```
- Get `ClusterRole` from Kubernetes API server:
```java
ClusterRole clusterRole = client.rbac().clusterRoles().withName("clusterrole1").get();
```
- List `ClusterRole` objects:
```java
ClusterRoleList clusterRoleList = client.rbac().clusterRoles().list();
```
- List `ClusterRole` objects with some labels:
```java
ClusterRoleList clusterRoleList = client.rbac().clusterRoles().withLabel("key1", "value1").list();
```
- Delete `ClusterRole` objects:
```java
client.rbac().clusterRoles().withName("clusterrole1").delete();
```

### ClusterRoleBinding
`ClusterRoleBinding` is available in Kubernetes Client API via `client.rbac().clusterRoleBindings()`. Here are some of the common usages:
- Load `ClusterRoleBinding` from yaml:
```java
ClusterRoleBinding clusterRoleBinding = client.rbac().clusterRoleBindings().load(new FileInputStream("clusterrolebinding-test.yml")).item();
```
- Create `ClusterRoleBinding` from Kubernetes API server:
```java
List<Subject> subjects = new ArrayList<>();
    Subject subject = new Subject();
    subject.setKind("ServiceAccount");
    subject.setName("serviceaccountname");
    subject.setNamespace("default");
    subjects.add(subject);
    RoleRef roleRef = new RoleRef();
    roleRef.setApiGroup("rbac.authorization.k8s.io");
    roleRef.setKind("ClusterRole");
    roleRef.setName("clusterrolename");
ClusterRoleBinding clusterRoleBindingCreated = new ClusterRoleBindingBuilder()
            .withNewMetadata().withName("clusterrolebindingname").withNamespace("default").endMetadata()
            .withRoleRef(roleRef)
            .addAllToSubjects(subjects)
            .build();
ClusterRoleBinding clusterRoleBinding = client.rbac().clusterRoleBindings().resource(clusterRoleBindingCreated).create();
```
- Get `ClusterRoleBinding` from Kubernetes API server:
```java
ClusterRoleBinding clusterRoleBinding = client.rbac().clusterRoleBindings().withName("clusterrolebindingname").get();
```
- List `ClusterRoleBinding` objects:
```java
ClusterRoleBindingList clusterRoleBindingList = client.rbac().clusterRoleBindings().list();
```
- List `ClusterRoleBinding` objects with some labels:
```java
ClusterRoleBindingList clusterRoleBindingList = client.rbac().clusterRoleBindings().withLabel("key1", "value1").list();
```
- Delete `ClusterRoleBinding` objects:
```java
client.rbac().clusterRoleBindings().withName("clusterrolebindingname").delete();
```

### Role
`Role` is available in Kubernetes Client API via `client.rbac().roles()`. Here are some of the common usages:
- Load `Role` from yaml:
```java
Role role = client.rbac().roles().load(new FileInputStream("role-test.yml")).item();
```
- Create `Role` from Kubernetes API server:
```java
List<PolicyRule> policyRuleList = new ArrayList<>();
    PolicyRule endpoints = new PolicyRule();
    endpoints.setApiGroups(Arrays.asList(""));
    endpoints.setResources(Arrays.asList("endpoints"));
    endpoints.setVerbs(Arrays.asList("get", "list", "watch", "create", "update", "patch"));
    policyRuleList.add(endpoints);
Role roleCreated = new RoleBuilder()
            .withNewMetadata().withName("rolename").withNamespace("default").endMetadata()
            .addAllToRules(policyRuleList)
            .build();
Role role = client.rbac().roles().resource(roleCreated).create();
```
- Get `Role` from Kubernetes API server:
```java
Role role = client.rbac().roles().inNamespace("default").withName("rolename").get();
```
- List `Role` objects:
```java
RoleList roleList = client.rbac().roles().inNamespace("default").list();
```
- List `Role` objects with some labels:
```java
RoleList roleList = client.rbac().roles().inNamespace("default").withLabel("key1", "value1").list();
```
- Delete `Role` objects:
```java
client.rbac().roles().withName("rolename").delete();
```

### RoleBinding
`RoleBinding` is available in Kubernetes Client API via `client.rbac().roleBindings()`. Here are some of the common usages:
- Load `RoleBinding` from yaml:
```java
RoleBinding roleBinding = client.rbac().roleBindings().load(new FileInputStream("rolebinding-test.yml")).item();
```
- Create `RoleBinding` from Kubernetes API server:
```java
List<Subject> subjects = new ArrayList<>();
    Subject subject = new Subject();
    subject.setNamespace("default");
    subject.setKind("ServiceAccount");
    subject.setName("servicecccountname");
    subjects.add(subject);
    RoleRef roleRef = new RoleRef();
    roleRef.setName("rolename");
    roleRef.setKind("Role");
    roleRef.setApiGroup("rbac.authorization.k8s.io");
RoleBinding roleBindingToCreate = new RoleBindingBuilder()
            .withNewMetadata().withName("rolename").withNamespace("default").endMetadata()
            .addAllToSubjects(subjects)
            .withRoleRef(roleRef)
            .build();
RoleBinding roleBinding = client.rbac().roleBindings().resource(roleBindingToCreate).create();
```
- Get `RoleBinding` from Kubernetes API server:
```java
RoleBinding roleBinding = client.rbac().roleBindings().inNamespace("default").withName("rolename").get();
```
- List `RoleBinding` objects:
```java
RoleBindingList roleBindingList = client.rbac().roleBindings().inNamespace("default").list();
```
- List `RoleBinding` objects with some labels:
```java
RoleBindingList roleBindingList = client.rbac().roleBindings().inNamespace("default").withLabel("key1", "value1").list();
```
- Delete `RoleBinding` objects:
```java
client.rbac().roleBindings().inNamespace("default").withName("rolename").delete();
```

### Fetching Metrics
Kubernetes Client also supports fetching metrics from API server if metrics are enabled on it. You can access metrics via `client.top()`. Here are some examples of its usage:
- Get `NodeMetrics` for all nodes:
```java
NodeMetricsList nodeMetricList = client.top().nodes().metrics();
```
- Get `NodeMetrics` for some specific nodes:
```java
NodeMetrics nodeMetric = client.top().nodes().withName("minikube").metric();
```
- Get `PodMetrics` for all pods in all namespaces:
```java
PodMetricsList podMetricsList = client.top().pods().metrics();
```
- Get `PodMetrics` for all pods in some specific namespace:
```java
PodMetricsList podMetricsList = client.top().pods().inNamespace("default").metrics();
```
- Get `PodMetrics` for a particular pod:
```java
PodMetrics podMetrics = client.top().pods().metrics("default", "nginx-pod");
```

### Resource API
Kubernetes Client also offers a generic API to handle different kind of Kubernetes resources. Most of the Kubernetes resources in Kubernetes Model are extending a class named `HasMetadata`. Resource API can work with any kind of Kubernetes Resource which extends this class. Here are some examples it it's usage:
- Get a Kubernetes Resource from Kubernetes API server:
```
Pod pod = client.resource(pod1).inNamespace("default").get();
```
- Apply a Kubernetes resource onto Kubernetes Cluster (Server Side Apply) :
```java
Pod pod1 = new PodBuilder()
  .withNewMetadata().withName("resource-pod-" + RandomStringUtils.randomAlphanumeric(6).toLowerCase(Locale.ROOT)).endMetadata()
  .withNewSpec()
  .addNewContainer().withName("nginx").withImage("nginx").endContainer()
  .endSpec()
  .build();

client.resource(pod1).inNamespace("default").serverSideApply();
```
- Apply a Kubernetes resource And Wait until resource is ready:
```java
pod1 = client.resource(pod1).serverSideApply();
Pod p = client.pods().resource(pod1).waitUntilReady(10, TimeUnit.SECONDS);
```
- Delete a Kubernetes Resource:
```java
client.resource(pod1).inNamespace("default").delete();
```

### ResourceList API
Just like generic Kubernetes Resource API, Kubernetes client also provides a generic API to deal with Kubernetes List. Here are some examples of its usage:
- Apply a list of Kubernetes resources onto Kubernetes Cluster:
```java
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

// Apply
client.resourceList(list).inNamespace("default").serverSideApply();
```
- Delete a list of items:
```java
client.resourceList(new PodListBuilder().withItems(pod1, pod2, pod3).build()).inNamespace("default").delete();
```

### CustomResourceDefinition
`CustomResourceDefinition` which are like templates for `CustomResource` objects in Kubernetes API are available in Kubernetes Client API via `client.apiextensions().v1beta1().customResourceDefinitions()` or `client.apiextensions().v1().customResourceDefinitions()`. Here are some examples of it's common usage:
- Load a `CustomResourceDefinition` from yaml:
```java
CustomResourceDefinition customResourceDefinition = client.apiextensions().v1().customResourceDefinitions().load(new FileInputStream("/sparkapplication-crd.yml")).item();
```
- Get a `CustomResourceDefinition` from Kubernetes APIServer
```java
CustomResourceDefinition crd = client.apiextensions().v1().customResourceDefinitions().withName("sparkclusters.radanalytics.io").get();
```
- Create `CustomResourceDefinition`:
```java
CustomResourceDefinition customResourceDefinition = new CustomResourceDefinitionBuilder()
      .withApiVersion("apiextensions.k8s.io/v1")
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

CustomResourceDefinition crd = client.apiextensions().v1().customResourceDefinitions().resource(customResourceDefinition).create();
```
- Apply some `CustomResourceDefinition`:
```java
CustomResourceDefinition crd = client.apiextensions().v1().customResourceDefinitions().resource(customResourceDefinition).serverSideApply();
```
- List `CustomResourceDefinition`:
```java
CustomResourceDefinitionList crdList = client.apiextensions().v1().customResourceDefinitions().list();
```
- Delete `CustomResourceDefinition`:
```java
client.apiextensions().v1().customResourceDefinitions().withName("sparkclusters.radanalytics.io").delete();
```

### Resource Typed API
Any resource, custom or built-in, is available in Kubernetes API via the `client.resources(Class)` method. In order to use typed API, you need to provide POJOs for your custom resource which client can use for serialization/deserialization. The base class `CustomResource` class, it's list class, etc. provide a good starting point for your custom resource.  The resources method returns an instance of a client which you can use for your operations. In order to get some idea of how POJOs should look like. Here's an example of POJO for `CronTab` CustomResource specified in [Kubernetes CustomResource docs](https://kubernetes.io/docs/tasks/access-kubernetes-api/custom-resources/custom-resource-definitions/)

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

**Note:** Please make sure that your CustomResource POJO is implementing `Namespaced` interface if it's a namespaced resource. Otherwise it would be considered a Cluster scoped resource.
```java
package io.fabric8.kubernetes.client.mock.crd;

import io.fabric8.kubernetes.api.model.Namespaced;
import io.fabric8.kubernetes.client.CustomResource;
import io.fabric8.kubernetes.model.annotation.Group;
import io.fabric8.kubernetes.model.annotation.Version;

@Version("v1")
@Group("stable.example.com")
public class CronTab extends CustomResource<CronTabSpec, CronTabStatus> implements Namespaced {
}
```

**Note:** Null values in your custom resource will be omitted by default by the client or when directly using KubernetesSerialization, or the static Serialization methods.  If you have a situation where a null value
must be present in the serialized form, then mark the field with @JsonInclude(value = Include.ALWAYS).

You can find other helper classes related to `CronTab` in our [tests](https://github.com/fabric8io/kubernetes-client/tree/master/kubernetes-tests/src/test/java/io/fabric8/kubernetes/client/mock/crd). For now, we can proceed with it's common usage examples:

- Get Instance of client for our `CustomResource`:
```java
MixedOperation<CronTab, KubernetesResourceList<CronTab>, Resource<CronTab>> cronTabClient = client.resources(CronTab.class);
```
- Get `CustomResource` from Kubernetes APIServer:
```java
CronTab ct = cronTabClient.inNamespace("default").withName("my-second-cron-object").get();
```
- Create `CustomResource`:
```java
cronTabClient.inNamespace("default").create(cronTab1);
```
- List `CustomResource`:
```java
CronTabList cronTabList = cronTabClient.inNamespace("default").list();
```
- Delete `CustomResource`:
```java
cronTabClient.inNamespace("default").withName("my-third-cron-object").delete();
```
- Replace Status of `CustomResource`:
```java
cronTabClient.inNamespace("default").resource(updatedCronTab).updateStatus();
```
- Patch Status of `CustomResource`:
```java
// does not require a full instance of the updatedCronTab, will produce a json merge patch based upon what is set in updatedCronTab
cronTabClient.inNamespace("default").resource(updatedCronTab).patchStatus();
```
- Edit Status of `CustomResource`:
```java
// generates a json patch between the passed in cronTab and the updated result.  Typically you will use a builder to construct a copy from the current and make modifications
cronTabClient.inNamespace("default").resource(cronTab1).editStatus(cronTab->updatedCronTab);
``` 
- Watch `CustomResource`:
```java
cronTabClient.inNamespace("default").watch(new Watcher<>() {
   @Override
   public void eventReceived(Action action, CronTab resource) {
        
   }

   @Override
   public void onClose(WatcherException cause) {

   }
});
```

### Resource Typeless API
If you don't need or want to use a strongly typed client, the Kubernetes Client also provides a typeless/raw API to handle your resources in form of GenericKubernetesResource.  GenericKubernetesResource implements HasMetadata and provides the rest of its fields via a map. In most circumstances the client can infer the necessary details about your type from the api server, this includes:

* client.genericKuberetesResources(apiVersion, kind) - to perform operations generically
* client.resource(resource) - if you already constructed an instance of your GenericKubernetesResource
* any of the load and related methods - if you have the yaml/json of a resource, but there is no class defined for deserializing it.

In some circumstances, such as an error with the logic automatically inferring the type details or when trying to use built-in mock support for the implicit generic scenario, you will need to use you will need to provide a `ResourceDefinitionContext`, which carries necessary information about the resource.  Here is an example on how to create one:
- Create `ResourceDefinitionContext`:
```java
ResourceDefinitionContext resourceDefinitionContext = new ResourceDefinitionContext.Builder()
      .withGroup("jungle.example.com")
      .withVersion("v1")
      .withPlural("animals")
      .withNamespaced(true)
      .build();
```
Once you have built it, you instead use `client.genericKubernetesResources(resourceDefinitionContext)` as your api entry point.

Explicit usage examples:

- Load a resource from yaml:
```java
GenericKubernetesResource customResource = client.genericKubernetesResources(context).load(new FileInputStream("cr.yaml")).item();
```
- Get a resource from Kubernetes API server:
```java
GenericKubernetesResource customResourceObject = client.genericKubernetesResources(resourceDefinitionContext).inNamespace(currentNamespace).withName("otter").get();
```
- Create a resource:
```java
// Create via file
GenericKubernetesResource object = client.genericKubernetesResources(resourceDefinitionContext).inNamespace(currentNamespace).load(new FileInputStream("test-rawcustomresource.yml")).create();

// Create via raw JSON string

String rawJsonCustomResourceObj = "{\"apiVersion\":\"jungle.example.com/v1\"," +
  "\"kind\":\"Animal\",\"metadata\": {\"name\": \"walrus\"}," +
  "\"spec\": {\"image\": \"my-awesome-walrus-image\"}}";
GenericKubernetesResource object = client.genericKubernetesResources(resourceDefinitionContext).inNamespace(currentNamespace).load(rawJsonCustomResourceObj).create();
```
- List `CustomResource`:
```java
GenericKubernetesResourceList list = client.genericKubernetesResources(resourceDefinitionContext).inNamespace(currentNamespace).list();
```
- List `CustomResource` with labels:
```java
GenericKubernetesResourceList list = client.genericKubernetesResources(resourceDefinitionContext).inNamespace(currentNamespace).withLabels(Collections.singletonMap("foo", "bar")).list();
```
- Update `CustomResource`:
```java
GenericKubernetesResource walrus = client.genericKubernetesResources(resourceDefinitionContext).inNamespace(currentNamespace).withName("walrus").get();
Map<String, Object> spec = (Map<String, Object>) walrus.getAdditionalProperties().get("spec");
spec.put("image", "my-updated-awesome-walrus-image");
walrus.getAdditionalProperties().put("spec", spec);
client.genericKubernetesResources(resourceDefinitionContext).inNamespace(currentNamespace).resource(walrus).update()
```
- Delete `CustomResource`:
```java
client.genericKubernetesResources(resourceDefinitionContext).inNamespace(currentNamespace).withName("otter").delete();
```
- Replace Status of `CustomResource`:
```java
GenericKubernetesResource result = client.genericKubernetesResources(resourceDefinitionContext).inNamespace("ns1").resource(objectAsGenericKubernetesResource).updateStatus();
```
- Watch `CustomResource`:
```java

final CountDownLatch closeLatch = new CountDownLatch(1);
client.genericKubernetesResources(crdContext).inNamespace(namespace).watch(new Watcher<>() {
    @Override
    public void eventReceived(Action action, GenericKubernetesResource resource) {
        logger.info("{}: {}", action, resource);
    }

    @Override
    public void onClose(WatcherException e) {
        logger.debug("Watcher onClose");
        closeLatch.countDown();
        if (e != null) {
            logger.error(e.getMessage(), e);
        }
    }
});
closeLatch.await(10, TimeUnit.MINUTES);
```

### Resource Typed API vs. Resource Typeless API
Following examples demonstrate how to define the same context for custom resources in two different ways by example of the spark operator.

Resource Typed API:
```
@Group("sparkoperator.k8s.io")
@Plural("sparkapps")
@Version("v1beta2")
@Kind("SparkApplication")
public class SparkOperatorResource extends GenericKubernetesResource implements Namespaced { ... }
```

Usage with Resource Typed API by `SparkOperatorResource`
```
kubernetesClient.resources(SparkOperatorResource.class).inNamespace("myNamespace")...
```

Resource Typeless API:
```
public static ResourceDefinitionContext getResourceDefinitionContext() {
    return new ResourceDefinitionContext.Builder()
            .withGroup("sparkoperator.k8s.io")
            .withPlural("sparkapps")
            .withVersion("v1beta2")
            .withKind("SparkApplication")
            .withNamespaced(true)
            .build();
}
```

Usage with Resource Typeless API:
```
kubernetesClient.genericKubernetesResources(getResourceDefinitionContext()).inNamespace("myNamespace")...
```

### CertificateSigningRequest
Kubernetes Client provides using `CertificateSigningRequest` via the `client.certificates().v1().certificateSigningRequests()` DSL interface. Here is an example of creating `CertificateSigningRequest` using Fabric8 Kubernetes Client:
- Create `CertificateSigningRequest`:
```
try (KubernetesClient client = new KubernetesClientBuilder().build()) {
    CertificateSigningRequest csr = new CertificateSigningRequestBuilder()
            .withNewMetadata().withName("test-k8s-csr").endMetadata()
            .withNewSpec()
            .addNewGroup("system:authenticated")
            .withRequest("LS0tLS1CRUdJTiBDRVJUSUZJQ0FURSBSRVFVRVNULS0tLS0KTUlJRWJqQ0NBbFlDQVFBd0tURVBNQTBHQTFVRUF3d0dhMmxrYjI1bk1SWXdGQVlEVlFRS0RBMWtZWFJoTFdWdQpaMmx1WldWeU1JSUNJakFOQmdrcWhraUc5dzBCQVFFRkFBT0NBZzhBTUlJQ0NnS0NBZ0VBc2dVZXl0S0F6ZDkyClN1S2pZL1RqbmRsZ0lkSFVVYWFxbHJIVW1nbTloKzY2RTJCNGs0TSt6Q0tOQmovemlMdWV6NFNUeHJ6SFk3RlUKNGUxWElBU3lMS0dmRGNPaks5NThURThwcXBRM21VdlpWMmxnK25BTVF5dlZUYWdZSmFId2JWUzVlNHgvRmpKcQoxTWpQZ1VoSGFXeEdIYTQrQnZYQU9Kdk5BdnV4alpZaVJET251dGxHVzloQkRKRlhoUk5jOGFKNnFiZWVBWnNiCmozWUFMaUcydWp1VmhoTUVRNEJxdFVHVGZCMzBQNGhRK2t2bWVKc2ZUU3Vsb2xiWFdIdVZGWnh1d0FJek5RbmQKMTd4VHd2cU04OGZFb3ZJazBJV0ZCWTk2aHRvaUVNdThZUms4SEZ6QkJralhsZGlkbVNNSHkwK0plcFRONmdQTQpEYVVsd1cxS0lCcW9TbnZNcjY4cFRVWEVhZVRjc040anMxTUIwK3FwR0JBS1puWWVxM0JmMkxVVFBNaG1VZ2VVCmFUTFlqODI2WVorZjJrOWJ1cngwK1NOSmVZbWoxVTl0N3A2YWM0dDIzZHVYQ1BzYkNrUFNKeGtrU3dudUlVVzkKdmJVVGtJNGtVMlFVMnE0NzRaMW1uMlkvejF2TEdQdEpsTDFYUVFVNEdsb2hrQkVkM1BsUTRtOGU1WGZSRkV6ZgpYZnhMRXFRczFTeEg1ekhjcnVaOWxJdnBkeEw5Tkc5WlR6M0tmT0tIbCtSUzdxMGdKaExac0RubUJKNXZab3p4CldXci9IRW9PamFYbGh0VitDN3M4TUg5Y0lKZENZNnpjcFVrZis1NmZ0Z1FuN0YrT1RYdDI0UVJQYWNFZnRFOTkKVERPb2luTGtOMm1kckxiMTgxQUZNUWJ0bTFLc1k2MENBd0VBQWFBQU1BMEdDU3FHU0liM0RRRUJDd1VBQTRJQwpBUUNQYU1WdDd4YWhkZlF1L1BySFVTTW5LK2I0SlJScEdEYlpWUXk4aUtkSmdHM0VrYnNBZ21qQmN4Q1IvL2t1CkVhU0plSGNWK20xVlFUTEp1ZFU3ZHFUeFBLOVFCNlB2aHlBbCttNnFaQkt1Q25VM1BKc2k5azBYSE5GWXBqRmYKVFNwTlpJSnRuanVEQWVtT05kcjJYMm1rODZmSmpWTEUvYnA1KzM5dFBkN0xjL3dZR2JoRU0xcExtUGpQK0Z6eQpzZnBiYW5PcmZFSG5NMmlsRFpGZURVSEpYL3F5Ykt1RC9BRmdoZk1Ua0x3ODNLNkNRdCtDQm05djRCeEtCS2xqCkdBWEQyUEhUTWlzektUbGpBM3czYUphanZzU0FwQXFCWnFocjB3QzdOb1dYM1h6S0p3ck9MaWVxemo3SXlpUGEKTEI5SmJveFpOQTdBSU5ucEdsa1hDZlRGT2RManZtQkVRQXV5Ym9wLzdqV2RiSzJHRkZKS2UwdlVlbWNUeGdHVwp5c0ZyV2pqMUlvdVBVNFZ6ck82QVBVQnZCZUFtdU1Bbm9yVng5emc4akhlT1pkd2RWdFRnOUwrK0VnWjlxK0htCjVtUlJGVHlZOWo4WVVvd2J6TzRlRUZnaVN0di84T1p0YmtOeDFROWFQWHJ3VUV1Q1I0SUthWG0wNlJUYXJOYXUKTWFsbk5oZm9WYi9Bc1R5d1ArNlc1dGErcTBpckR5cnVkZk5pRkFWbkRMZEU5a2hWZzVrU0lPRzhYbEZUMklwSQpkdVNpcUl0NlNUTlY3UmdaRzBGTFN5akxoc3laWnY2bitpUzl3Ky9OOFpoUzgvalViUUVidG1VTnNJU3Z5WS9JCmZqcHNZQUdleExvVW5mN2pDaUhkbTVhSnJ5SU1kdmZ2akJsMDhIVk5nWG1McVE9PQotLS0tLUVORCBDRVJUSUZJQ0FURSBSRVFVRVNULS0tLS0K")
            .addNewUsage("client auth")
            .endSpec()
            .build();

    client.certificates().v1().certificateSigningRequests().resource(csr).create();
}
```
- Approve a `CertificateSigningRequest`:
```java
    CertificateSigningRequestCondition csrCondition = new CertificateSigningRequestConditionBuilder()
            .withType("Approved")
            .withStatus("True")
            .withReason("Approved ViaRESTApi")
            .withMessage("Approved by REST API /approval endpoint.")
            .build();
    client.certificates().v1().certificateSigningRequests().withName("test-k8s-csr").approve(csrCondition);
```
- Deny a `CertificateSigningRequest`:
```java
    CertificateSigningRequestCondition csrCondition = new CertificateSigningRequestConditionBuilder()
            .withType("Denied")
            .withStatus("True")
            .withReason("Denied ViaRESTApi")
            .withMessage("Denied by REST API /approval endpoint.")
            .build();
  client.certificates().v1().certificateSigningRequests().withName("test-k8s-csr").deny(csrCondition);
```

### SharedInformers
Kubernetes Client also provides `SharedInformer` support in order to stay updated to events happening to your resource inside Kubernetes. Its implementation is simply list and watch operations after a certain interval of time. Here are some of the common usages:
- Get `SharedInformerFactory`:
```java
SharedInformerFactory sharedInformerFactory = client.informers();
```
- Create `SharedIndexInformer` for some Kubernetes Resource(requires resource's class and resync period (emits a dummy update event on that interval so that the handler can act again).  By default it watches in all namespaces.:
```java
SharedIndexInformer<Pod> podInformer = sharedInformerFactory.sharedIndexInformerFor(Pod.class, 30 * 1000L);
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
- Create `SharedIndexInformer` for some Custom Resource(in our case, `Dummy` resource provided in our [examples](https://github.com/fabric8io/kubernetes-client/tree/master/kubernetes-examples/src/main/java/io/fabric8/kubernetes/examples/crds). By default it watches in all namespaces.
```java
SharedIndexInformer<Dummy> dummyInformer = sharedInformerFactory.sharedIndexInformerFor(Dummy.class, 60 * 1000L);
dummyInformer.addEventHandler(new ResourceEventHandler<Dummy>() {
  @Override
  public void onAdd(Dummy dummy) {
    System.out.printf("%s dummy added\n", dummy.getMetadata().getName());
  }

  @Override
  public void onUpdate(Dummy oldDummy, Dummy newDummy) {
    System.out.printf("%s dummy updated\n", oldDummy.getMetadata().getName());
  }

  @Override
  public void onDelete(Dummy dummy, boolean deletedFinalStateUnknown) {
    System.out.printf("%s dummy deleted \n", dummy.getMetadata().getName());
  }
});
```
- Start all registered informers:
```java
sharedInformerFactory.startAllRegisteredInformers();
```
- Stop all registered informers:
```java
sharedInformerFactory.stopAllRegisteredInformers();
```

You are not limited to just creating cluster wide informers, if you want to be informed about a particular context then use the Informable interface and inform methods.

- Create namespaced `SharedIndexInformer` (informers specific to a particular `Namespace`):
```java
SharedIndexInformer<Pod> podInformer = client.pods().inNamespace("default").inform(new ResourceEventHandler<>() {
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
},  30 * 1000L);

logger.info("Informer initialized.");
```
- Create Namespaced Informer for a Custom Resource(**Note:** Your CustomResource POJO must implement `Namespaced` interface like the one used in this example: [Dummy.java](https://github.com/fabric8io/kubernetes-client/blob/main/kubernetes-examples/src/main/java/io/fabric8/kubernetes/examples/crds/Dummy.java))
You should have your CustomResource type POJO annotated with group, version fields with respect to your CRD:
```java
import io.fabric8.kubernetes.api.model.KubernetesResource;
import io.fabric8.kubernetes.api.model.Namespaced;
import io.fabric8.kubernetes.client.CustomResource;
import io.fabric8.kubernetes.model.annotation.Group;
import io.fabric8.kubernetes.model.annotation.Version;
import io.fabric8.kubernetes.model.annotation.Plural;

@Version("demo.fabric8.io")
@Group("v1")
public class Dummy extends CustomResource<DummySpec, KubernetesResource> implements Namespaced { }
```
Then you should be able to use it like this:
```java
SharedIndexInformer<Dummy> dummyInformer = client.resources(Dummy.class).inNamespace("default").inform(new ResourceEventHandler<>() {
    @Override
    public void onAdd(Dummy dummy) {
        System.out.printf("%s dummy added\n", dummy.getMetadata().getName());
    }

    @Override
    public void onUpdate(Dummy oldDummy, Dummy newDummy) {
        System.out.printf("%s dummy updated\n", oldDummy.getMetadata().getName());
    }

    @Override
    public void onDelete(Dummy dummy, boolean deletedFinalStateUnknown) {
        System.out.printf("%s dummy deleted \n", dummy.getMetadata().getName());
    }
},  60 * 1000L);
```
When using the inform methods the informers will already be started/running.

### List Options
There are various options provided by Kubernetes Client API when it comes to listing resources. Here are some of the common examples provided:
- List with pagination, comes with limit and continue parameters. The continue option should be set when retrieving more results from the server. Since this value is server defined, clients may only use the continue value from a previous query result with identical query parameters (except for the value of continue) and the server may reject a continue value it does not recognize.
```java
PodList podList = client.pods().inNamespace("myproject").list(new ListOptionsBuilder().withLimit(5L).build());

podList = client.pods().inNamespace("myproject").list(new ListOptionsBuilder().withLimit(5L)
		.withContinue(podList.getMetadata().getContinue())
		.build());
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
```java
client.apps().deployments().inNamespace("default").withName("nginx-deploy").cascading(true).delete();
```
- Providing `propagationPolicy(..)` to specify how deletion should be performed:
```java
client.apps().deployments().inNamespace("default").withName("nginx-deploy").withPropagationPolicy(DeletionPropagation.FOREGROUND).delete();
```
- Specifying grace period for deletion:
```java
client.apps().deployments().inNamespace("ns1").withName("mydeployment").withPropagationPolicy(DeletionPropagation.FOREGROUND).withGracePeriod(10).delete();
```

### Watch Options
Kubernetes Client provides namely three different ways of using `Watch`:
- Plain `Watch` without any arguments:
```java
client.pods().inNamespace(namespace).watch(new Watcher<>() {
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
    public void onClose(WatcherException e) {
        logger.log(Level.INFO, "Closed");
        isWatchClosed.countDown();
    }
});

// Wait till watch gets closed
isWatchClosed.await();
```
- _Deprecated_ : Watching with `resourceVersion` provided:
```java
String resourceVersion = "20012";
client.pods().inNamespace(namespace).watch(resourceVersion, new Watcher<>() {
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
    public void onClose(WatcherException e) {
        logger.log(Level.INFO, "Closed");
        isWatchClosed.countDown();
    }
});

// Wait till watch gets closed
isWatchClosed.await();
```
- Watching with `ListOptions` object:
```java
client.pods().watch(new ListOptionsBuilder().withTimeoutSeconds(30L).build(), new Watcher<>() {
  @Override
  public void eventReceived(Action action, Pod resource) { }

  @Override
  public void onClose(WatcherException cause) { }
});
```

### Log Options
- Get logs with pretty output:
```java
client.pods().inNamespace("test").withName("foo").withPrettyOutput().getLog();
```
- Get logs of a specific container:
```java
client.pods().inNamespace("test").withName("foo").inContainer("container1").getLog();
```
- Get logs for the previous instance of the container in a pod if it exists:
```java
client.pods().inNamespace("test").withName("foo").terminated().getLog();
```
- Only return logs after a specific date (RFC3339):
```java
client.pods().inNamespace("test").withName("foo").sinceTime("2020-09-10T12:53:30.154148788Z").getLog();
```
- Get logs after a duration of seconds:
```java
client.pods().inNamespace("test").withName("foo").sinceSeconds(10).getLog();
```
- Get logs lines of recent log file to display.
```java
client.pods().inNamespace("test").withName("foo").tailingLines(10).getLog();
```
- Configure Maximum bytes of logs to return. Defaults to no limit.
```java
client.pods().inNamespace("test").withName("foo").limitBytes(102).getLog();
```
- Include timestamps on each line in the log output
```java
client.pods().inNamespace("test").withName("foo").usingTimestamps().getLog();
```

#### Serializing to yaml
Resources can be exported to a YAML String via the `Serialization` class:
```java
Pod myPod;

String myPodAsYaml = Serialization.asYaml(myPod);
```

#### Running a Pod
Kubernetes Client also provides mechanism similar to `kubectl run` in which you can spin a `Pod` just by specifying it's image and name:
- Running a `Pod` by just providing image and name:
```java
try (KubernetesClient client = new KubernetesClientBuilder().build()) {
    client.run().inNamespace("default")
            .withName("hazelcast")
            .withImage("hazelcast/hazelcast:3.12.9")
            .done();
}
```
- You can also provide slighly complex configuration with `withGeneratorConfig` method in which you can specify labels, environment variables, ports etc:
```java
try (KubernetesClient client = new KubernetesClientBuilder().build()) {
    client.run().inNamespace("default")
					.withNewRunConfig()
					.withName("nginx")
					.withImage("nginx:latest")
					.withLabels(Collections.singletonMap("foo", "bar"))
					.withEnv(Collections.singletonMap("KUBERNETES_TEST", "fabric8"))
					.done();}
```

#### Server Side Apply

Basic usage of server side apply is available via Patchable.  At it's simplest you just need to call:

```java
client.services().withName("name").patch(PatchContext.of(PatchType.SERVER_SIDE_APPLY), service);
```

For any create or update.  This can be a good alternative to using createOrReplace as it is always a single api call and does not issue a replace/PUT which can be problematic.

If the resources may be created or modified by something other than a fabric8 patch, you will need to force your modifications:

```java
client.services().withName("name").patch(new PatchContext.Builder().withPatchType(PatchType.SERVER_SIDE_APPLY).withForce(true).build(), service);
```

Please consult the Kubernetes server side apply documentation if you want to do more detailed field management or want to understand the full semantics of how the patches are merged.

### OpenShift Client DSL Usage

Fabric8 Kubernetes Client also has an extension for OpenShift. It is pretty much the same as Kubernetes Client but has support for some additional OpenShift resources.

#### Initializing OpenShift Client:
Initializing OpenShift client is the same as Kubernetes Client. You use
```java
try (final OpenShiftClient client = new KubernetesClientBuilder().build().adapt(OpenShiftClient.class)) {
  // Do stuff with client
}
```
This would pick up default settings, reading your `kubeconfig` file from `~/.kube/config` directory or whatever is defined inside `KUBECONFIG` environment variable. But if you want to customize creation of client, you can also pass a `Config` object inside the builder like this:
```java
Config kubeConfig = new ConfigBuilder()
            .withMasterUrl("https://api.ci-ln-3sbdl1b-d5d6b.origin-ci-int-aws.dev.examplecloud.com:6443")
            .withOauthToken("xxxxxxxx-41oafKI6iU637-xxxxxxxxxxxxx")
            .build())) {
try (final OpenShiftClient client = new KubernetesClientBuilder().withConfig(kubeConfig).build().adapt(OpenShiftClient.class)) {
  // Do stuff with client
}
```

#### DeploymentConfig
`DeploymentConfig` is available in OpenShift client via `client.deploymentConfigs()`. Here are some examples of its common usage:
- Load `DeploymentConfig` from yaml:
```java
DeploymentConfig deploymentConfig = client.deploymentConfigs().inNamespace(currentNamespace)
  .load(new FileInputStream("test-deploymentconfig.yml")).item();
```
- Get `DeploymentConfig` from OpenShift API server:
```java
DeploymentConfig dc = client.deploymentConfigs().inNamespace(currentNamespace).withName("deploymentconfig1").get();
```
- Create `DeploymentConfig`:
```java
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

DeploymentConfig dcCreated = client.deploymentConfigs().inNamespace("default").resource(dc).create();
```
- Apply an existing `DeploymentConfig` onto OpenShift Cluster:
```java
DeploymentConfig dc = client.deploymentConfigs().inNamespace("default").resource(dcToCreate).serverSideApply();
```
- List `DeploymentConfig` in some namespace:
```java
DeploymentConfigList aDeploymentConfigList = client.deploymentConfigs().inNamespace("default").list();
```
- List `DeploymentConfig` in any namespace:
```java
DeploymentConfigList dcList = client.deploymentConfigs().inAnyNamespace().list();
```
- List `DeploymentConfig` in some namespace with some label:
```java
DeploymentConfigList dcList = client.deploymentConfigs().inNamespace("default").withLabel("foo", "bar").list();
```
- Update `DeploymentConfig`:
```java
DeploymentConfig deploymentConfig1 = client.deploymentConfigs().inNamespace(currentNamespace).withName("deploymentconfig1").edit(
  dc -> new DeploymentConfigBuilder(dc).editSpec().withReplicas(3).endSpec().build()
);
```
- Delete `DeploymentConfig`:
```java
client.deploymentConfigs().inNamespace("default").withName("deploymentconfig1").delete();
```
- Watch `DeploymentConfig`:
```java
client.deploymentConfigs().inNamespace("default").watch(new Watcher<>() {
  @Override
  public void eventReceived(Action action, DeploymentConfig resource) {
    // Do something depending upon action    
  }

  @Override
  public void onClose(WatcherException cause) {

  }
});
```

#### BuildConfig
`BuildConfig` resource is available in OpenShift Client via `client.buildConfigs()`. Here are some examples of it's common uses:
- Load `BuildConfig` from yaml:
```java
BuildConfig aBuildConfig = client.buildConfigs().inNamespace(currentNamespace)
  .load(new FileInputStream("/test-buildconfig.yml")).item();
```
- Get `BuildConfig` from OpenShift API server:
```java
BuildConfig bc = client.buildConfigs().inNamespace(currentNamespace).withName("bc1").get();
```
- Create `BuildConfig`:
```java
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

client.buildConfigs().inNamespace("default").resource(buildConfig1).create();
```
- List `BuildConfig` in some namespace:
```java
BuildConfigList bcList = client.buildConfigs().inNamespace("default").list();
```
- List `BuildConfig` in any namespace:
```java
BuildConfigList bcList = client.buildConfigs().inNamespace("default").list();
```
- List `BuildConfig` in some namespace with some label:
```java
BuildConfigList bcList = client.buildConfigs().inNamespace("default").withLabel("foo", "bar").list();
```
- Delete `BuildConfig`:
```java
client.buildConfigs().inNamespace("default").withName("bc1").delete();
```
- Watch `BuildConfig`:
```java
client.buildConfigs().inNamespace("default").watch(new Watcher<>() {
  @Override
  public void eventReceived(Action action, BuildConfig resource) {
    // Do something depending upon action type    
  }

  @Override
  public void onClose(WatcherException cause) {

  }
});
```

#### Route
`Route` resource is available in OpenShift client API via `client.routes()`. Here are some examples of its common usage:
- Load `Route` from yaml:
```java
Route aRoute = client.routes().inNamespace("default").load(new FileInputStream("test-route.yml")).item();
```
- Get `Route` from OpenShift API server:
```java
Route route1 = client.routes().inNamespace("default").withName("route1").get();
```
- Create `Route`:
```java
Route route1 = new RouteBuilder()
      .withNewMetadata().withName("route1").endMetadata()
      .withNewSpec().withHost("www.example.com").withNewTo().withKind("Service").withName("service-name1").endTo().endSpec()
      .build();

client.routes().inNamespace("defalt").resource(route1).create();
```
- Apply `Route` onto OpenShift Cluster:
```java
Route route = client.routes().inNamespace("default").resource(route1).serverSideApply();
```
- List `Route` in some namespace:
```java
RouteList aRouteList = client.routes().inNamespace("default").list();
```
- List `Route` in any namespace:
```java
RouteList aRouteList = client.routes().inAnyNamespace().list();
```
- List `Route` in some namespace with some label:
```java
RouteList routeList = client.routes().inNamespace("default").withLabel("foo", "bar").list();
```
- Delete `Route`:
```java
client.routes().inNamespace("default").withName("route1").delete();
```

#### Project
OpenShift `Project` resource can be found in OpenShift Client API via `client.projects()`. Here are some examples of its usage:
- Get `Project`:
```java
Project myProject = client.projects().withName("default").get();
```
- Create `Project`
```java
ProjectRequest request = client.projectrequests().create(
  new ProjectRequestBuilder().withNewMetadata().withName("thisisatest").endMetadata()
  .withDescription("Fabric8").withDisplayName("Fabric8).build()
);
```
- List `Project`
```java
ProjectList projectList = client.projects().list();
```
- Delete `Project`:
```java
client.projects().withName("default").delete();
```

#### ImageStream
`ImageStream` resource is available in OpenShift client via `client.imageStreams()`. Here are some examples of its common usage:
- Load `ImageStream` from yaml:
```java
ImageStream aImageStream = client.imageStreams()
  .load(new FileInputStream("test-imagestream.yml")).item();
```
- Get `ImageStream` from OpenShift API Server:
```java
ImageStream is =client.imageStreams().inNamespace("default").withName("example-camel-cdi").get();
```
- Create `ImageStream`:
```java
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

client.imageStreams().inNamespace("default").resource(imageStream1).create();
```
- Apply `ImageStream` onto OpenShift Cluster:
```java
ImageStream is = client.imageStreams().inNamespace("default").resource(imageStream1).create();
```
- List `ImageStream` in some namespace:
```java
ImageStreamList aImageStreamList = client.imageStreams().inNamespace("default").list();
```
- List `ImageStream` in any namespace:
```java
ImageStreamList isList = client.imageStreams().inAnyNamespace().list();
```
- List `ImageStream` in some namespace with some labels:
```java
ImageStreamList isList = client.imageStreams().inNamespace("default").withLabel("foo", "bar").list();
```
- Delete `ImageStream`:
```java
client.imageStreams().inNamespace("default").withName("example-camel-cdi").delete();
```
#### CatalogSource
`CatalogSource` is available for usage in OpenShift Client via `client.operatorHub().catalogSources()`. Here are some common examples of it's usage:
- Load `CatalogSource` from YAML:
```java
CatalogSource cs = client.operatorHub().catalogSources()
  .load(new FileInputStream("/test-catalogsource.yml").item();
```
- Create `CatalogSource`:
```java
CatalogSource cs = new CatalogSourceBuilder()
  .withNewMetadata().withName("foo").endMetadata()
  .withNewSpec()
  .withSourceType("Foo")
  .withImage("nginx:latest")
  .withDisplayName("Foo Bar")
  .withPublisher("Fabric8")
  .endSpec()
  .build();
client.operatorHub().catalogSources().inNamespace("default").resource(cs).create();
```
- List `CatalogSource` in some namespace:
```java
CatalogSourceList csList = client.operatorHub().catalogSources().inNamespace("ns1").list();
```
- List `CatalogSource` in any namespace:
```java
CatalogSourceList csList = client.operatorHub().catalogSources().inAnyNamespace().list();
```
- List `CatalogSource` in some namespace with some labels:
```java
CatalogSourceList csList = client.operatorHub().catalogSources().inNamespace("default").withLabel("foo", "bar").list();
```
- Delete `CatalogSource`:
```java
client.operatorHub().catalogSources().inNamespace("default").withName("foo").delete();
```

#### PrometheusRule
`PrometheusRule` is available for usage in OpenShift Client via `client.monitoring().prometheusRules()`. Here are some common examples of it's usage:
- Load `PrometheusRule` from YAML:
```java
PrometheusRule prometheusRule = client.monitoring().prometheusRules()
  .load(new FileInputStream("/test-prometheusrule.yml").item();
```
- Create `PrometheusRule`:
```java
PrometheusRule prometheusRule = new PrometheusRuleBuilder()
    .withNewMetadata().withName("foo").endMetadata()
    .withNewSpec()
    .addNewGroup()
    .withName("./example-rules")
    .addNewRule()
    .withAlert("ExampleAlert")
    .withNewExpr().withStrVal("vector(1)").endExpr()
    .endRule()
    .endGroup()
    .endSpec()
    .build();
client.monitoring().prometheusRules().inNamespace("default").resource(prometheusRule).create();
```
- List `PrometheusRule` in some namespace:
```java
PrometheusRuleList prList = client.monitoring().prometheusRules().inNamespace("ns1").list();
```
- List `PrometheusRule` in any namespace:
```java
PrometheusRuleList prList = client.monitoring().prometheusRules().inAnyNamespace().list();
```
- List `PrometheusRule` in some namespace with some labels:
```java
PrometheusRuleList prList = client.monitoring().prometheusRules().inNamespace("default").withLabel("foo", "bar").list();
```
- Delete `PrometheusRule`:
```java
client.monitoring().prometheusRules().inNamespace("default").withName("foo").delete();
```

#### ServiceMonitor
`ServiceMonitor` is available for usage in OpenShift Client via `client.monitoring().serviceMonitors()`. Here are some common examples of it's usage:
- Load `ServiceMonitor` from YAML:
```java
ServiceMonitor serviceMonitor = client.monitoring().serviceMonitors()
  .load(new FileInputStream("/test-servicemonitor.yml").item();
```
- Create `ServiceMonitor`:
```java
ServiceMonitor serviceMonitor = new ServiceMonitorBuilder()
    .withNewMetadata()
    .withName("foo")
    .addToLabels("prometheus", "frontend")
    .endMetadata()
    .withNewSpec()
    .withNewNamespaceSelector().withAny(true).endNamespaceSelector()
    .withNewSelector()
    .addToMatchLabels("prometheus", "frontend")
    .endSelector()
    .addNewEndpoint()
    .withPort("http-metric")
    .withInterval("15s")
    .endEndpoint()
    .endSpec()
    .build();

client.monitoring().serviceMonitors().inNamespace("default").resource(serviceMonitor).create();
```
- List `ServiceMonitor` in some namespace:
```java
ServiceMonitorList serviceMonitorList = client.monitoring().serviceMonitors().inNamespace("ns1").list();
```
- List `ServiceMonitor` in any namespace:
```java
ServiceMonitorList serviceMonitorList = client.monitoring().serviceMonitors().inAnyNamespace().list();
```
- List `ServiceMonitor` in some namespace with some labels:
```java
ServiceMonitorList serviceMonitorList = client.monitoring().catalogSources().inNamespace("default").withLabel("foo", "bar").list();
```
- Delete `ServiceMonitor`:
```java
client.operatorHub().monitoring().inNamespace("default").withName("foo").delete();
```

#### ClusterResourceQuota
- Create `ClusterResourceQuota`:
```java
try (OpenShiftClient client = new KubernetesClientBuilder().build().adapt(OpenShiftClient.class)) {
    Map<String, Quantity> hard = new HashMap<>();
    hard.put("pods", new Quantity("10"));
    hard.put("secrets", new Quantity("20"));
    ClusterResourceQuota acrq = new ClusterResourceQuotaBuilder()
            .withNewMetadata().withName("foo").endMetadata()
            .withNewSpec()
            .withNewSelector()
            .addToAnnotations("openshift.io/requester", "foo-user")
            .endSelector()
            .withQuota(new ResourceQuotaSpecBuilder()
                    .withHard(hard)
                    .build())
            .endSpec()
            .build();

    client.quotas().clusterResourceQuotas().resource(acrq).create();
}
```
- List `ClusterResourceQuota` from server:
```java
ClusterResourceQuotaList clusterResourceQuotaList = client.quotas().clusterResourceQuotas().list();
```
- Delete `ClusterResourceQuota`:
```java
client.quotas().clusterResourceQuotas().withName("foo").delete();
```

#### ClusterVersion
- Fetch Cluster Version:
```java
try (OpenShiftClient client = new KubernetesClientBuilder().build().adapt(OpenShiftClient.class)) {
    ClusterVersion clusterVersion = client.config().clusterVersions().withName("version").get();
    System.out.println("Cluster Version: " + clusterVersion.getStatus().getDesired().getVersion());
}
```

### EgressNetworkPolicy
`EgressNetworkPolicy` is available for usage in OpenShift Client via `client..egressNetworkPolicys()`. Here are some common examples of it's usage:
- Load `EgressNetworkPolicy` from YAML:
```java
EgressNetworkPolicy egressNetworkPolicy = client.egressNetworkPolicies()
  .load(new FileInputStream("/test-enp.yml").item();
```
- Create `EgressNetworkPolicy`:
```java
try (OpenShiftClient client = new KubernetesClientBuilder().build().adapt(OpenShiftClient.class)) {
    EgressNetworkPolicy enp = new EgressNetworkPolicyBuilder()
            .withNewMetadata()
            .withName("foo")
            .withNamespace("default")
            .endMetadata()
            .withNewSpec()
            .addNewEgress()
            .withType("Allow")
            .withNewTo()
            .withCidrSelector("1.2.3.0/24")
            .endTo()
            .endEgress()
            .addNewEgress()
            .withType("Allow")
            .withNewTo()
            .withDnsName("www.foo.com")
            .endTo()
            .endEgress()
            .endSpec()
            .build();
    client.egressNetworkPolicies().inNamespace("default").resource(enp).create();
}
```
- List `EgressNetworkPolicy` in some namespace:
```java
EgressNetworkPolicyList egressNetworkPolicyList = client.egressNetworkPolicies().inNamespace("default").list();
```
- List `EgressNetworkPolicy` in any namespace:
```java
EgressNetworkPolicyList egressNetworkPolicyList = client.egressNetworkPolicies().inAnyNamespace().list();
```
- List `EgressNetworkPolicy` in some namespace with some labels:
```java
EgressNetworkPolicyList egressNetworkPolicyList = client.egressNetworkPolicies().inNamespace("default").withLabel("foo", "bar").list();
```
- Delete `EgressNetworkPolicy`:
```java
client.egressNetworkPolicies().inNamespace("default").withName("foo").delete();
```

### Tekton Client
Fabric8 Kubernetes Client also has an extension for Tekton. 
It is pretty much the same as Kubernetes Client but has support for some additional Tekton resources.

#### Initializing Tekton Client
Initializing Tekton client is the same as Kubernetes Client. You
```java
try (final TektonClient client = new KubernetesClientBuilder().build().adapt(TektonClient.class)) {
  // Do stuff with client
}
```
This would pick up default settings, reading your `kubeconfig` file from `~/.kube/config` directory or whatever is defined inside `KUBECONFIG` environment variable.
But if you want to customize creation of client, you can also pass a `Config` object inside the builder.

#### Tekton Client DSL Usage
The Tekton client supports CRD API version `tekton.dev/v1`, `tekton.dev/v1alpha1` as well as `tekton.dev/v1beta1`.
`tekton.dev/v1alpha1` includes the CRDs  `Pipeline`, `PipelineRun`, `PipelineResource`, `Task`, `TaskRun`, `Condition` and `ClusterTask`.
All `tekton.dev/v1alpha1` resources are available using the DSL `tektonClient.v1alpha1()`.
`tekton.dev/v1beta1` includes the CRDs  `Pipeline`, `PipelineRun`, `Task`, `TaskRun` and `ClusterTask`.
All `tekton.dev/v1beta1` resources are available using the DSL `tektonClient.v1beta1()`.
In addition to the Tekton Pipelines CRDs, the client also supports Tekton Triggers. 
`TriggerTemplate`, `TriggerBinding`, `EventListener` and `ClusterTriggerBinding` are available using the DSL `tektonClient.v1alpha1()`.

The usage of the resources follows the same pattern as for K8s resources like Pods or Deployments.
Here are some common examples:

- Listing all `PipelineRun` objects in some specific namespace:
```java
PipelineRunList list = tektonClient.v1().pipelineRuns().inNamespace("default").list();
```
- Create a `PipelineRun`:
```java
PipelineRun pipelineRun = new PipelineRunBuilder()
    .withNewMetadata().withName("demo-run-1").endMetadata()
    .withNewSpec()
    .withNewPipelineRef().withName("demo-pipeline").endPipelineRef()
    .addNewParam().withName("greeting").withNewValue("Hello World!").endParam()
    .endSpec()
    .build();

tektonClient.v1().pipelineRuns().inNamespace("default").resource(pipelineRun).create();
```

### Knative Client
Fabric8 Kubernetes Client also has an extension for Knative.
It is pretty much the same as Kubernetes Client but has support for some additional Knative resources.

#### Initializing Knative Client
Initializing Knative client is the same as Kubernetes Client. 
```
try (final KnativeClient client = new KubernetesClientBuilder().build().adapt(KnativeClient.class)) {
  // Do stuff with client
}
```
This would pick up default settings, reading your `kubeconfig` file from `~/.kube/config` directory or whatever is defined inside `KUBECONFIG` environment variable.
But if you want to customize creation of client, you can also pass a `Config` object inside the builder.

#### Knative Client DSL Usage
The usage of the resources follows the same pattern as for K8s resources like Pods or Deployments.
Here are some common examples:

- Listing all `Service` objects in some specific namespace:
```java
ServiceList list = knativeClient.services().inNamespace("default").list();
```
- Apply a `Service`:
```java
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
    kn.services().inNamespace("default").resource(service).serverSideApply();
}
```

#### Logging
Using logging-interceptor:

- Configure OkHTTP logging:
- Set logging level to trace in my simplelogger.properties file:
```properties
 org.slf4j.simpleLogger.defaultLogLevel=trace
```

