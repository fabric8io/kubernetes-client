
package io.fabric8.kubernetes.api.model;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.fabric8.kubernetes.api.model.Container;
import io.fabric8.kubernetes.api.model.IntOrString;
import io.fabric8.kubernetes.api.model.LabelSelector;
import io.fabric8.kubernetes.api.model.LocalObjectReference;
import io.fabric8.kubernetes.api.model.ObjectReference;
import io.fabric8.kubernetes.api.model.PodTemplateSpec;
import io.fabric8.kubernetes.api.model.ResourceRequirements;
import io.fabric8.kubernetes.api.model.apps.ControllerRevision;
import io.fabric8.kubernetes.api.model.apps.ControllerRevisionList;
import io.fabric8.kubernetes.api.model.apps.DaemonSet;
import io.fabric8.kubernetes.api.model.apps.DaemonSetList;
import io.fabric8.kubernetes.api.model.apps.Deployment;
import io.fabric8.kubernetes.api.model.apps.DeploymentList;
import io.fabric8.kubernetes.api.model.apps.ReplicaSet;
import io.fabric8.kubernetes.api.model.apps.ReplicaSetList;
import io.fabric8.kubernetes.api.model.apps.StatefulSet;
import io.fabric8.kubernetes.api.model.apps.StatefulSetList;
import io.fabric8.kubernetes.api.model.version.Info;
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;
import lombok.EqualsAndHashCode;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "apiVersion",
    "kind",
    "metadata",
    "APIGroup",
    "APIGroupList",
    "BaseKubernetesList",
    "Binding",
    "ComponentStatusList",
    "ConfigMap",
    "ConfigMapList",
    "ContainerStatus",
    "ControllerRevision",
    "ControllerRevisionList",
    "CreateOptions",
    "DaemonSet",
    "DaemonSetList",
    "DeleteOptions",
    "Deployment",
    "DeploymentList",
    "EndpointPort",
    "Endpoints",
    "EndpointsList",
    "EnvVar",
    "GetOptions",
    "Info",
    "LimitRangeList",
    "ListOptions",
    "Namespace",
    "NamespaceList",
    "Node",
    "NodeList",
    "ObjectMeta",
    "Patch",
    "PatchOptions",
    "PersistentVolume",
    "PersistentVolumeClaim",
    "PersistentVolumeClaimList",
    "PersistentVolumeList",
    "PodList",
    "PodTemplateList",
    "Quantity",
    "ReplicaSet",
    "ReplicaSetList",
    "ReplicationControllerList",
    "ResourceQuota",
    "ResourceQuotaList",
    "RootPaths",
    "Secret",
    "SecretList",
    "ServiceAccount",
    "ServiceAccountList",
    "ServiceList",
    "StatefulSet",
    "StatefulSetList",
    "Status",
    "Time",
    "Toleration",
    "TypeMeta",
    "UpdateOptions"
})
@ToString
@EqualsAndHashCode
@Setter
@Accessors(prefix = {
    "_",
    ""
})
@Buildable(editableEnabled = false, validationEnabled = false, generateBuilderPackage = false, lazyCollectionInitEnabled = false, builderPackage = "io.fabric8.kubernetes.api.builder", refs = {
    @BuildableReference(io.fabric8.kubernetes.api.model.ObjectMeta.class),
    @BuildableReference(LabelSelector.class),
    @BuildableReference(Container.class),
    @BuildableReference(PodTemplateSpec.class),
    @BuildableReference(ResourceRequirements.class),
    @BuildableReference(IntOrString.class),
    @BuildableReference(ObjectReference.class),
    @BuildableReference(LocalObjectReference.class),
    @BuildableReference(io.fabric8.kubernetes.api.model.PersistentVolumeClaim.class)
})
public class ValidationSchema {

    @JsonProperty("APIGroup")
    private APIGroup aPIGroup;
    @JsonProperty("APIGroupList")
    private APIGroupList aPIGroupList;
    @JsonProperty("BaseKubernetesList")
    private BaseKubernetesList baseKubernetesList;
    @JsonProperty("Binding")
    private Binding binding;
    @JsonProperty("ComponentStatusList")
    private ComponentStatusList componentStatusList;
    @JsonProperty("ConfigMap")
    private ConfigMap configMap;
    @JsonProperty("ConfigMapList")
    private ConfigMapList configMapList;
    @JsonProperty("ContainerStatus")
    private ContainerStatus containerStatus;
    @JsonProperty("ControllerRevision")
    private ControllerRevision controllerRevision;
    @JsonProperty("ControllerRevisionList")
    private ControllerRevisionList controllerRevisionList;
    @JsonProperty("CreateOptions")
    private CreateOptions createOptions;
    @JsonProperty("DaemonSet")
    private DaemonSet daemonSet;
    @JsonProperty("DaemonSetList")
    private DaemonSetList daemonSetList;
    @JsonProperty("DeleteOptions")
    private DeleteOptions deleteOptions;
    @JsonProperty("Deployment")
    private Deployment deployment;
    @JsonProperty("DeploymentList")
    private DeploymentList deploymentList;
    @JsonProperty("EndpointPort")
    private EndpointPort endpointPort;
    @JsonProperty("Endpoints")
    private Endpoints endpoints;
    @JsonProperty("EndpointsList")
    private EndpointsList endpointsList;
    @JsonProperty("EnvVar")
    private EnvVar envVar;
    @JsonProperty("GetOptions")
    private GetOptions getOptions;
    @JsonProperty("Info")
    private Info info;
    @JsonProperty("LimitRangeList")
    private LimitRangeList limitRangeList;
    @JsonProperty("ListOptions")
    private ListOptions listOptions;
    @JsonProperty("Namespace")
    private Namespace namespace;
    @JsonProperty("NamespaceList")
    private NamespaceList namespaceList;
    @JsonProperty("Node")
    private Node node;
    @JsonProperty("NodeList")
    private NodeList nodeList;
    @JsonProperty("ObjectMeta")
    private io.fabric8.kubernetes.api.model.ObjectMeta objectMeta;
    @JsonProperty("Patch")
    private Patch patch;
    @JsonProperty("PatchOptions")
    private PatchOptions patchOptions;
    @JsonProperty("PersistentVolume")
    private PersistentVolume persistentVolume;
    @JsonProperty("PersistentVolumeClaim")
    private io.fabric8.kubernetes.api.model.PersistentVolumeClaim persistentVolumeClaim;
    @JsonProperty("PersistentVolumeClaimList")
    private PersistentVolumeClaimList persistentVolumeClaimList;
    @JsonProperty("PersistentVolumeList")
    private PersistentVolumeList persistentVolumeList;
    @JsonProperty("PodList")
    private PodList podList;
    @JsonProperty("PodTemplateList")
    private PodTemplateList podTemplateList;
    @JsonProperty("Quantity")
    private Quantity quantity;
    @JsonProperty("ReplicaSet")
    private ReplicaSet replicaSet;
    @JsonProperty("ReplicaSetList")
    private ReplicaSetList replicaSetList;
    @JsonProperty("ReplicationControllerList")
    private ReplicationControllerList replicationControllerList;
    @JsonProperty("ResourceQuota")
    private ResourceQuota resourceQuota;
    @JsonProperty("ResourceQuotaList")
    private ResourceQuotaList resourceQuotaList;
    @JsonProperty("RootPaths")
    private RootPaths rootPaths;
    @JsonProperty("Secret")
    private Secret secret;
    @JsonProperty("SecretList")
    private SecretList secretList;
    @JsonProperty("ServiceAccount")
    private ServiceAccount serviceAccount;
    @JsonProperty("ServiceAccountList")
    private ServiceAccountList serviceAccountList;
    @JsonProperty("ServiceList")
    private ServiceList serviceList;
    @JsonProperty("StatefulSet")
    private StatefulSet statefulSet;
    @JsonProperty("StatefulSetList")
    private StatefulSetList statefulSetList;
    @JsonProperty("Status")
    private Status status;
    @JsonProperty("Time")
    private String time;
    @JsonProperty("Toleration")
    private Toleration toleration;
    @JsonProperty("TypeMeta")
    private TypeMeta typeMeta;
    @JsonProperty("UpdateOptions")
    private UpdateOptions updateOptions;
    @JsonIgnore
    private Map<java.lang.String, Object> additionalProperties = new HashMap<java.lang.String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public ValidationSchema() {
    }

    /**
     * 
     * @param listOptions
     * @param aPIGroupList
     * @param configMapList
     * @param binding
     * @param daemonSet
     * @param daemonSetList
     * @param namespaceList
     * @param patch
     * @param serviceAccountList
     * @param persistentVolume
     * @param resourceQuota
     * @param secretList
     * @param info
     * @param deleteOptions
     * @param limitRangeList
     * @param deploymentList
     * @param toleration
     * @param replicaSet
     * @param nodeList
     * @param node
     * @param configMap
     * @param getOptions
     * @param persistentVolumeClaimList
     * @param status
     * @param replicationControllerList
     * @param baseKubernetesList
     * @param statefulSetList
     * @param updateOptions
     * @param podList
     * @param secret
     * @param controllerRevisionList
     * @param persistentVolumeList
     * @param rootPaths
     * @param containerStatus
     * @param replicaSetList
     * @param deployment
     * @param endpointsList
     * @param patchOptions
     * @param endpoints
     * @param quantity
     * @param envVar
     * @param serviceAccount
     * @param resourceQuotaList
     * @param createOptions
     * @param podTemplateList
     * @param aPIGroup
     * @param typeMeta
     * @param statefulSet
     * @param objectMeta
     * @param namespace
     * @param serviceList
     * @param controllerRevision
     * @param componentStatusList
     * @param persistentVolumeClaim
     * @param time
     * @param endpointPort
     */
    public ValidationSchema(APIGroup aPIGroup, APIGroupList aPIGroupList, BaseKubernetesList baseKubernetesList, Binding binding, ComponentStatusList componentStatusList, ConfigMap configMap, ConfigMapList configMapList, ContainerStatus containerStatus, ControllerRevision controllerRevision, ControllerRevisionList controllerRevisionList, CreateOptions createOptions, DaemonSet daemonSet, DaemonSetList daemonSetList, DeleteOptions deleteOptions, Deployment deployment, DeploymentList deploymentList, EndpointPort endpointPort, Endpoints endpoints, EndpointsList endpointsList, EnvVar envVar, GetOptions getOptions, Info info, LimitRangeList limitRangeList, ListOptions listOptions, Namespace namespace, NamespaceList namespaceList, Node node, NodeList nodeList, io.fabric8.kubernetes.api.model.ObjectMeta objectMeta, Patch patch, PatchOptions patchOptions, PersistentVolume persistentVolume, io.fabric8.kubernetes.api.model.PersistentVolumeClaim persistentVolumeClaim, PersistentVolumeClaimList persistentVolumeClaimList, PersistentVolumeList persistentVolumeList, PodList podList, PodTemplateList podTemplateList, Quantity quantity, ReplicaSet replicaSet, ReplicaSetList replicaSetList, ReplicationControllerList replicationControllerList, ResourceQuota resourceQuota, ResourceQuotaList resourceQuotaList, RootPaths rootPaths, Secret secret, SecretList secretList, ServiceAccount serviceAccount, ServiceAccountList serviceAccountList, ServiceList serviceList, StatefulSet statefulSet, StatefulSetList statefulSetList, Status status, String time, Toleration toleration, TypeMeta typeMeta, UpdateOptions updateOptions) {
        super();
        this.aPIGroup = aPIGroup;
        this.aPIGroupList = aPIGroupList;
        this.baseKubernetesList = baseKubernetesList;
        this.binding = binding;
        this.componentStatusList = componentStatusList;
        this.configMap = configMap;
        this.configMapList = configMapList;
        this.containerStatus = containerStatus;
        this.controllerRevision = controllerRevision;
        this.controllerRevisionList = controllerRevisionList;
        this.createOptions = createOptions;
        this.daemonSet = daemonSet;
        this.daemonSetList = daemonSetList;
        this.deleteOptions = deleteOptions;
        this.deployment = deployment;
        this.deploymentList = deploymentList;
        this.endpointPort = endpointPort;
        this.endpoints = endpoints;
        this.endpointsList = endpointsList;
        this.envVar = envVar;
        this.getOptions = getOptions;
        this.info = info;
        this.limitRangeList = limitRangeList;
        this.listOptions = listOptions;
        this.namespace = namespace;
        this.namespaceList = namespaceList;
        this.node = node;
        this.nodeList = nodeList;
        this.objectMeta = objectMeta;
        this.patch = patch;
        this.patchOptions = patchOptions;
        this.persistentVolume = persistentVolume;
        this.persistentVolumeClaim = persistentVolumeClaim;
        this.persistentVolumeClaimList = persistentVolumeClaimList;
        this.persistentVolumeList = persistentVolumeList;
        this.podList = podList;
        this.podTemplateList = podTemplateList;
        this.quantity = quantity;
        this.replicaSet = replicaSet;
        this.replicaSetList = replicaSetList;
        this.replicationControllerList = replicationControllerList;
        this.resourceQuota = resourceQuota;
        this.resourceQuotaList = resourceQuotaList;
        this.rootPaths = rootPaths;
        this.secret = secret;
        this.secretList = secretList;
        this.serviceAccount = serviceAccount;
        this.serviceAccountList = serviceAccountList;
        this.serviceList = serviceList;
        this.statefulSet = statefulSet;
        this.statefulSetList = statefulSetList;
        this.status = status;
        this.time = time;
        this.toleration = toleration;
        this.typeMeta = typeMeta;
        this.updateOptions = updateOptions;
    }

    @JsonProperty("APIGroup")
    public APIGroup getAPIGroup() {
        return aPIGroup;
    }

    @JsonProperty("APIGroup")
    public void setAPIGroup(APIGroup aPIGroup) {
        this.aPIGroup = aPIGroup;
    }

    @JsonProperty("APIGroupList")
    public APIGroupList getAPIGroupList() {
        return aPIGroupList;
    }

    @JsonProperty("APIGroupList")
    public void setAPIGroupList(APIGroupList aPIGroupList) {
        this.aPIGroupList = aPIGroupList;
    }

    @JsonProperty("BaseKubernetesList")
    public BaseKubernetesList getBaseKubernetesList() {
        return baseKubernetesList;
    }

    @JsonProperty("BaseKubernetesList")
    public void setBaseKubernetesList(BaseKubernetesList baseKubernetesList) {
        this.baseKubernetesList = baseKubernetesList;
    }

    @JsonProperty("Binding")
    public Binding getBinding() {
        return binding;
    }

    @JsonProperty("Binding")
    public void setBinding(Binding binding) {
        this.binding = binding;
    }

    @JsonProperty("ComponentStatusList")
    public ComponentStatusList getComponentStatusList() {
        return componentStatusList;
    }

    @JsonProperty("ComponentStatusList")
    public void setComponentStatusList(ComponentStatusList componentStatusList) {
        this.componentStatusList = componentStatusList;
    }

    @JsonProperty("ConfigMap")
    public ConfigMap getConfigMap() {
        return configMap;
    }

    @JsonProperty("ConfigMap")
    public void setConfigMap(ConfigMap configMap) {
        this.configMap = configMap;
    }

    @JsonProperty("ConfigMapList")
    public ConfigMapList getConfigMapList() {
        return configMapList;
    }

    @JsonProperty("ConfigMapList")
    public void setConfigMapList(ConfigMapList configMapList) {
        this.configMapList = configMapList;
    }

    @JsonProperty("ContainerStatus")
    public ContainerStatus getContainerStatus() {
        return containerStatus;
    }

    @JsonProperty("ContainerStatus")
    public void setContainerStatus(ContainerStatus containerStatus) {
        this.containerStatus = containerStatus;
    }

    @JsonProperty("ControllerRevision")
    public ControllerRevision getControllerRevision() {
        return controllerRevision;
    }

    @JsonProperty("ControllerRevision")
    public void setControllerRevision(ControllerRevision controllerRevision) {
        this.controllerRevision = controllerRevision;
    }

    @JsonProperty("ControllerRevisionList")
    public ControllerRevisionList getControllerRevisionList() {
        return controllerRevisionList;
    }

    @JsonProperty("ControllerRevisionList")
    public void setControllerRevisionList(ControllerRevisionList controllerRevisionList) {
        this.controllerRevisionList = controllerRevisionList;
    }

    @JsonProperty("CreateOptions")
    public CreateOptions getCreateOptions() {
        return createOptions;
    }

    @JsonProperty("CreateOptions")
    public void setCreateOptions(CreateOptions createOptions) {
        this.createOptions = createOptions;
    }

    @JsonProperty("DaemonSet")
    public DaemonSet getDaemonSet() {
        return daemonSet;
    }

    @JsonProperty("DaemonSet")
    public void setDaemonSet(DaemonSet daemonSet) {
        this.daemonSet = daemonSet;
    }

    @JsonProperty("DaemonSetList")
    public DaemonSetList getDaemonSetList() {
        return daemonSetList;
    }

    @JsonProperty("DaemonSetList")
    public void setDaemonSetList(DaemonSetList daemonSetList) {
        this.daemonSetList = daemonSetList;
    }

    @JsonProperty("DeleteOptions")
    public DeleteOptions getDeleteOptions() {
        return deleteOptions;
    }

    @JsonProperty("DeleteOptions")
    public void setDeleteOptions(DeleteOptions deleteOptions) {
        this.deleteOptions = deleteOptions;
    }

    @JsonProperty("Deployment")
    public Deployment getDeployment() {
        return deployment;
    }

    @JsonProperty("Deployment")
    public void setDeployment(Deployment deployment) {
        this.deployment = deployment;
    }

    @JsonProperty("DeploymentList")
    public DeploymentList getDeploymentList() {
        return deploymentList;
    }

    @JsonProperty("DeploymentList")
    public void setDeploymentList(DeploymentList deploymentList) {
        this.deploymentList = deploymentList;
    }

    @JsonProperty("EndpointPort")
    public EndpointPort getEndpointPort() {
        return endpointPort;
    }

    @JsonProperty("EndpointPort")
    public void setEndpointPort(EndpointPort endpointPort) {
        this.endpointPort = endpointPort;
    }

    @JsonProperty("Endpoints")
    public Endpoints getEndpoints() {
        return endpoints;
    }

    @JsonProperty("Endpoints")
    public void setEndpoints(Endpoints endpoints) {
        this.endpoints = endpoints;
    }

    @JsonProperty("EndpointsList")
    public EndpointsList getEndpointsList() {
        return endpointsList;
    }

    @JsonProperty("EndpointsList")
    public void setEndpointsList(EndpointsList endpointsList) {
        this.endpointsList = endpointsList;
    }

    @JsonProperty("EnvVar")
    public EnvVar getEnvVar() {
        return envVar;
    }

    @JsonProperty("EnvVar")
    public void setEnvVar(EnvVar envVar) {
        this.envVar = envVar;
    }

    @JsonProperty("GetOptions")
    public GetOptions getGetOptions() {
        return getOptions;
    }

    @JsonProperty("GetOptions")
    public void setGetOptions(GetOptions getOptions) {
        this.getOptions = getOptions;
    }

    @JsonProperty("Info")
    public Info getInfo() {
        return info;
    }

    @JsonProperty("Info")
    public void setInfo(Info info) {
        this.info = info;
    }

    @JsonProperty("LimitRangeList")
    public LimitRangeList getLimitRangeList() {
        return limitRangeList;
    }

    @JsonProperty("LimitRangeList")
    public void setLimitRangeList(LimitRangeList limitRangeList) {
        this.limitRangeList = limitRangeList;
    }

    @JsonProperty("ListOptions")
    public ListOptions getListOptions() {
        return listOptions;
    }

    @JsonProperty("ListOptions")
    public void setListOptions(ListOptions listOptions) {
        this.listOptions = listOptions;
    }

    @JsonProperty("Namespace")
    public Namespace getNamespace() {
        return namespace;
    }

    @JsonProperty("Namespace")
    public void setNamespace(Namespace namespace) {
        this.namespace = namespace;
    }

    @JsonProperty("NamespaceList")
    public NamespaceList getNamespaceList() {
        return namespaceList;
    }

    @JsonProperty("NamespaceList")
    public void setNamespaceList(NamespaceList namespaceList) {
        this.namespaceList = namespaceList;
    }

    @JsonProperty("Node")
    public Node getNode() {
        return node;
    }

    @JsonProperty("Node")
    public void setNode(Node node) {
        this.node = node;
    }

    @JsonProperty("NodeList")
    public NodeList getNodeList() {
        return nodeList;
    }

    @JsonProperty("NodeList")
    public void setNodeList(NodeList nodeList) {
        this.nodeList = nodeList;
    }

    @JsonProperty("ObjectMeta")
    public io.fabric8.kubernetes.api.model.ObjectMeta getObjectMeta() {
        return objectMeta;
    }

    @JsonProperty("ObjectMeta")
    public void setObjectMeta(io.fabric8.kubernetes.api.model.ObjectMeta objectMeta) {
        this.objectMeta = objectMeta;
    }

    @JsonProperty("Patch")
    public Patch getPatch() {
        return patch;
    }

    @JsonProperty("Patch")
    public void setPatch(Patch patch) {
        this.patch = patch;
    }

    @JsonProperty("PatchOptions")
    public PatchOptions getPatchOptions() {
        return patchOptions;
    }

    @JsonProperty("PatchOptions")
    public void setPatchOptions(PatchOptions patchOptions) {
        this.patchOptions = patchOptions;
    }

    @JsonProperty("PersistentVolume")
    public PersistentVolume getPersistentVolume() {
        return persistentVolume;
    }

    @JsonProperty("PersistentVolume")
    public void setPersistentVolume(PersistentVolume persistentVolume) {
        this.persistentVolume = persistentVolume;
    }

    @JsonProperty("PersistentVolumeClaim")
    public io.fabric8.kubernetes.api.model.PersistentVolumeClaim getPersistentVolumeClaim() {
        return persistentVolumeClaim;
    }

    @JsonProperty("PersistentVolumeClaim")
    public void setPersistentVolumeClaim(io.fabric8.kubernetes.api.model.PersistentVolumeClaim persistentVolumeClaim) {
        this.persistentVolumeClaim = persistentVolumeClaim;
    }

    @JsonProperty("PersistentVolumeClaimList")
    public PersistentVolumeClaimList getPersistentVolumeClaimList() {
        return persistentVolumeClaimList;
    }

    @JsonProperty("PersistentVolumeClaimList")
    public void setPersistentVolumeClaimList(PersistentVolumeClaimList persistentVolumeClaimList) {
        this.persistentVolumeClaimList = persistentVolumeClaimList;
    }

    @JsonProperty("PersistentVolumeList")
    public PersistentVolumeList getPersistentVolumeList() {
        return persistentVolumeList;
    }

    @JsonProperty("PersistentVolumeList")
    public void setPersistentVolumeList(PersistentVolumeList persistentVolumeList) {
        this.persistentVolumeList = persistentVolumeList;
    }

    @JsonProperty("PodList")
    public PodList getPodList() {
        return podList;
    }

    @JsonProperty("PodList")
    public void setPodList(PodList podList) {
        this.podList = podList;
    }

    @JsonProperty("PodTemplateList")
    public PodTemplateList getPodTemplateList() {
        return podTemplateList;
    }

    @JsonProperty("PodTemplateList")
    public void setPodTemplateList(PodTemplateList podTemplateList) {
        this.podTemplateList = podTemplateList;
    }

    @JsonProperty("Quantity")
    public Quantity getQuantity() {
        return quantity;
    }

    @JsonProperty("Quantity")
    public void setQuantity(Quantity quantity) {
        this.quantity = quantity;
    }

    @JsonProperty("ReplicaSet")
    public ReplicaSet getReplicaSet() {
        return replicaSet;
    }

    @JsonProperty("ReplicaSet")
    public void setReplicaSet(ReplicaSet replicaSet) {
        this.replicaSet = replicaSet;
    }

    @JsonProperty("ReplicaSetList")
    public ReplicaSetList getReplicaSetList() {
        return replicaSetList;
    }

    @JsonProperty("ReplicaSetList")
    public void setReplicaSetList(ReplicaSetList replicaSetList) {
        this.replicaSetList = replicaSetList;
    }

    @JsonProperty("ReplicationControllerList")
    public ReplicationControllerList getReplicationControllerList() {
        return replicationControllerList;
    }

    @JsonProperty("ReplicationControllerList")
    public void setReplicationControllerList(ReplicationControllerList replicationControllerList) {
        this.replicationControllerList = replicationControllerList;
    }

    @JsonProperty("ResourceQuota")
    public ResourceQuota getResourceQuota() {
        return resourceQuota;
    }

    @JsonProperty("ResourceQuota")
    public void setResourceQuota(ResourceQuota resourceQuota) {
        this.resourceQuota = resourceQuota;
    }

    @JsonProperty("ResourceQuotaList")
    public ResourceQuotaList getResourceQuotaList() {
        return resourceQuotaList;
    }

    @JsonProperty("ResourceQuotaList")
    public void setResourceQuotaList(ResourceQuotaList resourceQuotaList) {
        this.resourceQuotaList = resourceQuotaList;
    }

    @JsonProperty("RootPaths")
    public RootPaths getRootPaths() {
        return rootPaths;
    }

    @JsonProperty("RootPaths")
    public void setRootPaths(RootPaths rootPaths) {
        this.rootPaths = rootPaths;
    }

    @JsonProperty("Secret")
    public Secret getSecret() {
        return secret;
    }

    @JsonProperty("Secret")
    public void setSecret(Secret secret) {
        this.secret = secret;
    }

    @JsonProperty("SecretList")
    public SecretList getSecretList() {
        return secretList;
    }

    @JsonProperty("SecretList")
    public void setSecretList(SecretList secretList) {
        this.secretList = secretList;
    }

    @JsonProperty("ServiceAccount")
    public ServiceAccount getServiceAccount() {
        return serviceAccount;
    }

    @JsonProperty("ServiceAccount")
    public void setServiceAccount(ServiceAccount serviceAccount) {
        this.serviceAccount = serviceAccount;
    }

    @JsonProperty("ServiceAccountList")
    public ServiceAccountList getServiceAccountList() {
        return serviceAccountList;
    }

    @JsonProperty("ServiceAccountList")
    public void setServiceAccountList(ServiceAccountList serviceAccountList) {
        this.serviceAccountList = serviceAccountList;
    }

    @JsonProperty("ServiceList")
    public ServiceList getServiceList() {
        return serviceList;
    }

    @JsonProperty("ServiceList")
    public void setServiceList(ServiceList serviceList) {
        this.serviceList = serviceList;
    }

    @JsonProperty("StatefulSet")
    public StatefulSet getStatefulSet() {
        return statefulSet;
    }

    @JsonProperty("StatefulSet")
    public void setStatefulSet(StatefulSet statefulSet) {
        this.statefulSet = statefulSet;
    }

    @JsonProperty("StatefulSetList")
    public StatefulSetList getStatefulSetList() {
        return statefulSetList;
    }

    @JsonProperty("StatefulSetList")
    public void setStatefulSetList(StatefulSetList statefulSetList) {
        this.statefulSetList = statefulSetList;
    }

    @JsonProperty("Status")
    public Status getStatus() {
        return status;
    }

    @JsonProperty("Status")
    public void setStatus(Status status) {
        this.status = status;
    }

    @JsonProperty("Time")
    public String getTime() {
        return time;
    }

    @JsonProperty("Time")
    public void setTime(String time) {
        this.time = time;
    }

    @JsonProperty("Toleration")
    public Toleration getToleration() {
        return toleration;
    }

    @JsonProperty("Toleration")
    public void setToleration(Toleration toleration) {
        this.toleration = toleration;
    }

    @JsonProperty("TypeMeta")
    public TypeMeta getTypeMeta() {
        return typeMeta;
    }

    @JsonProperty("TypeMeta")
    public void setTypeMeta(TypeMeta typeMeta) {
        this.typeMeta = typeMeta;
    }

    @JsonProperty("UpdateOptions")
    public UpdateOptions getUpdateOptions() {
        return updateOptions;
    }

    @JsonProperty("UpdateOptions")
    public void setUpdateOptions(UpdateOptions updateOptions) {
        this.updateOptions = updateOptions;
    }

    @JsonAnyGetter
    public Map<java.lang.String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(java.lang.String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
