
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
import io.fabric8.kubernetes.api.model.version.Info;
import io.sundr.builder.annotations.Buildable;
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
    "APIResource",
    "APIResourceList",
    "APIService",
    "APIServiceList",
    "BaseKubernetesList",
    "Binding",
    "ComponentStatus",
    "ComponentStatusList",
    "Condition",
    "Config",
    "ConfigMap",
    "ConfigMapList",
    "ContainerStatus",
    "CreateOptions",
    "DeleteOptions",
    "EndpointPort",
    "Endpoints",
    "EndpointsList",
    "EnvVar",
    "Event",
    "EventList",
    "EventSeries",
    "EventSource",
    "GetOptions",
    "GroupKind",
    "GroupVersionKind",
    "GroupVersionResource",
    "Info",
    "LimitRangeList",
    "ListOptions",
    "MicroTime",
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
    "PodExecOptions",
    "PodList",
    "PodTemplateList",
    "Quantity",
    "ReplicationControllerList",
    "ResourceQuota",
    "ResourceQuotaList",
    "RootPaths",
    "Secret",
    "SecretList",
    "ServiceAccount",
    "ServiceAccountList",
    "ServiceList",
    "Status",
    "Time",
    "Toleration",
    "TopologySelectorTerm",
    "TypeMeta",
    "UpdateOptions",
    "WatchEvent"
})
@ToString
@EqualsAndHashCode
@Setter
@Accessors(prefix = {
    "_",
    ""
})
@Buildable(editableEnabled = false, validationEnabled = false, generateBuilderPackage = true, lazyCollectionInitEnabled = false, builderPackage = "io.fabric8.kubernetes.api.builder")
public class ValidationSchema {

    @JsonProperty("APIGroup")
    private APIGroup aPIGroup;
    @JsonProperty("APIGroupList")
    private APIGroupList aPIGroupList;
    @JsonProperty("APIResource")
    private APIResource aPIResource;
    @JsonProperty("APIResourceList")
    private APIResourceList aPIResourceList;
    @JsonProperty("APIService")
    private APIService aPIService;
    @JsonProperty("APIServiceList")
    private APIServiceList aPIServiceList;
    @JsonProperty("BaseKubernetesList")
    private BaseKubernetesList baseKubernetesList;
    @JsonProperty("Binding")
    private Binding binding;
    @JsonProperty("ComponentStatus")
    private ComponentStatus componentStatus;
    @JsonProperty("ComponentStatusList")
    private ComponentStatusList componentStatusList;
    @JsonProperty("Condition")
    private Condition condition;
    @JsonProperty("Config")
    private Config config;
    @JsonProperty("ConfigMap")
    private ConfigMap configMap;
    @JsonProperty("ConfigMapList")
    private ConfigMapList configMapList;
    @JsonProperty("ContainerStatus")
    private ContainerStatus containerStatus;
    @JsonProperty("CreateOptions")
    private CreateOptions createOptions;
    @JsonProperty("DeleteOptions")
    private DeleteOptions deleteOptions;
    @JsonProperty("EndpointPort")
    private EndpointPort endpointPort;
    @JsonProperty("Endpoints")
    private Endpoints endpoints;
    @JsonProperty("EndpointsList")
    private EndpointsList endpointsList;
    @JsonProperty("EnvVar")
    private EnvVar envVar;
    @JsonProperty("Event")
    private Event event;
    @JsonProperty("EventList")
    private EventList eventList;
    @JsonProperty("EventSeries")
    private EventSeries eventSeries;
    @JsonProperty("EventSource")
    private EventSource eventSource;
    @JsonProperty("GetOptions")
    private GetOptions getOptions;
    @JsonProperty("GroupKind")
    private GroupKind groupKind;
    @JsonProperty("GroupVersionKind")
    private GroupVersionKind groupVersionKind;
    @JsonProperty("GroupVersionResource")
    private GroupVersionResource groupVersionResource;
    @JsonProperty("Info")
    private Info info;
    @JsonProperty("LimitRangeList")
    private LimitRangeList limitRangeList;
    @JsonProperty("ListOptions")
    private ListOptions listOptions;
    @JsonProperty("MicroTime")
    private MicroTime microTime;
    @JsonProperty("Namespace")
    private Namespace namespace;
    @JsonProperty("NamespaceList")
    private NamespaceList namespaceList;
    @JsonProperty("Node")
    private Node node;
    @JsonProperty("NodeList")
    private NodeList nodeList;
    @JsonProperty("ObjectMeta")
    private ObjectMeta objectMeta;
    @JsonProperty("Patch")
    private Patch patch;
    @JsonProperty("PatchOptions")
    private PatchOptions patchOptions;
    @JsonProperty("PersistentVolume")
    private PersistentVolume persistentVolume;
    @JsonProperty("PersistentVolumeClaim")
    private PersistentVolumeClaim persistentVolumeClaim;
    @JsonProperty("PersistentVolumeClaimList")
    private PersistentVolumeClaimList persistentVolumeClaimList;
    @JsonProperty("PersistentVolumeList")
    private PersistentVolumeList persistentVolumeList;
    @JsonProperty("PodExecOptions")
    private PodExecOptions podExecOptions;
    @JsonProperty("PodList")
    private PodList podList;
    @JsonProperty("PodTemplateList")
    private PodTemplateList podTemplateList;
    @JsonProperty("Quantity")
    private Quantity quantity;
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
    @JsonProperty("Status")
    private Status status;
    @JsonProperty("Time")
    private String time;
    @JsonProperty("Toleration")
    private Toleration toleration;
    @JsonProperty("TopologySelectorTerm")
    private TopologySelectorTerm topologySelectorTerm;
    @JsonProperty("TypeMeta")
    private TypeMeta typeMeta;
    @JsonProperty("UpdateOptions")
    private UpdateOptions updateOptions;
    @JsonProperty("WatchEvent")
    private WatchEvent watchEvent;
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
     * @param eventList
     * @param binding
     * @param namespaceList
     * @param patch
     * @param serviceAccountList
     * @param persistentVolume
     * @param resourceQuota
     * @param watchEvent
     * @param secretList
     * @param info
     * @param deleteOptions
     * @param groupKind
     * @param groupVersionResource
     * @param limitRangeList
     * @param toleration
     * @param aPIResourceList
     * @param nodeList
     * @param groupVersionKind
     * @param node
     * @param condition
     * @param configMap
     * @param getOptions
     * @param eventSeries
     * @param persistentVolumeClaimList
     * @param status
     * @param replicationControllerList
     * @param eventSource
     * @param baseKubernetesList
     * @param updateOptions
     * @param componentStatus
     * @param podList
     * @param secret
     * @param aPIService
     * @param persistentVolumeList
     * @param rootPaths
     * @param event
     * @param containerStatus
     * @param aPIServiceList
     * @param endpointsList
     * @param patchOptions
     * @param endpoints
     * @param quantity
     * @param envVar
     * @param microTime
     * @param podExecOptions
     * @param serviceAccount
     * @param aPIResource
     * @param resourceQuotaList
     * @param topologySelectorTerm
     * @param createOptions
     * @param podTemplateList
     * @param aPIGroup
     * @param typeMeta
     * @param objectMeta
     * @param namespace
     * @param serviceList
     * @param componentStatusList
     * @param persistentVolumeClaim
     * @param time
     * @param endpointPort
     * @param config
     */
    public ValidationSchema(APIGroup aPIGroup, APIGroupList aPIGroupList, APIResource aPIResource, APIResourceList aPIResourceList, APIService aPIService, APIServiceList aPIServiceList, BaseKubernetesList baseKubernetesList, Binding binding, ComponentStatus componentStatus, ComponentStatusList componentStatusList, Condition condition, Config config, ConfigMap configMap, ConfigMapList configMapList, ContainerStatus containerStatus, CreateOptions createOptions, DeleteOptions deleteOptions, EndpointPort endpointPort, Endpoints endpoints, EndpointsList endpointsList, EnvVar envVar, Event event, EventList eventList, EventSeries eventSeries, EventSource eventSource, GetOptions getOptions, GroupKind groupKind, GroupVersionKind groupVersionKind, GroupVersionResource groupVersionResource, Info info, LimitRangeList limitRangeList, ListOptions listOptions, MicroTime microTime, Namespace namespace, NamespaceList namespaceList, Node node, NodeList nodeList, ObjectMeta objectMeta, Patch patch, PatchOptions patchOptions, PersistentVolume persistentVolume, PersistentVolumeClaim persistentVolumeClaim, PersistentVolumeClaimList persistentVolumeClaimList, PersistentVolumeList persistentVolumeList, PodExecOptions podExecOptions, PodList podList, PodTemplateList podTemplateList, Quantity quantity, ReplicationControllerList replicationControllerList, ResourceQuota resourceQuota, ResourceQuotaList resourceQuotaList, RootPaths rootPaths, Secret secret, SecretList secretList, ServiceAccount serviceAccount, ServiceAccountList serviceAccountList, ServiceList serviceList, Status status, String time, Toleration toleration, TopologySelectorTerm topologySelectorTerm, TypeMeta typeMeta, UpdateOptions updateOptions, WatchEvent watchEvent) {
        super();
        this.aPIGroup = aPIGroup;
        this.aPIGroupList = aPIGroupList;
        this.aPIResource = aPIResource;
        this.aPIResourceList = aPIResourceList;
        this.aPIService = aPIService;
        this.aPIServiceList = aPIServiceList;
        this.baseKubernetesList = baseKubernetesList;
        this.binding = binding;
        this.componentStatus = componentStatus;
        this.componentStatusList = componentStatusList;
        this.condition = condition;
        this.config = config;
        this.configMap = configMap;
        this.configMapList = configMapList;
        this.containerStatus = containerStatus;
        this.createOptions = createOptions;
        this.deleteOptions = deleteOptions;
        this.endpointPort = endpointPort;
        this.endpoints = endpoints;
        this.endpointsList = endpointsList;
        this.envVar = envVar;
        this.event = event;
        this.eventList = eventList;
        this.eventSeries = eventSeries;
        this.eventSource = eventSource;
        this.getOptions = getOptions;
        this.groupKind = groupKind;
        this.groupVersionKind = groupVersionKind;
        this.groupVersionResource = groupVersionResource;
        this.info = info;
        this.limitRangeList = limitRangeList;
        this.listOptions = listOptions;
        this.microTime = microTime;
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
        this.podExecOptions = podExecOptions;
        this.podList = podList;
        this.podTemplateList = podTemplateList;
        this.quantity = quantity;
        this.replicationControllerList = replicationControllerList;
        this.resourceQuota = resourceQuota;
        this.resourceQuotaList = resourceQuotaList;
        this.rootPaths = rootPaths;
        this.secret = secret;
        this.secretList = secretList;
        this.serviceAccount = serviceAccount;
        this.serviceAccountList = serviceAccountList;
        this.serviceList = serviceList;
        this.status = status;
        this.time = time;
        this.toleration = toleration;
        this.topologySelectorTerm = topologySelectorTerm;
        this.typeMeta = typeMeta;
        this.updateOptions = updateOptions;
        this.watchEvent = watchEvent;
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

    @JsonProperty("APIResource")
    public APIResource getAPIResource() {
        return aPIResource;
    }

    @JsonProperty("APIResource")
    public void setAPIResource(APIResource aPIResource) {
        this.aPIResource = aPIResource;
    }

    @JsonProperty("APIResourceList")
    public APIResourceList getAPIResourceList() {
        return aPIResourceList;
    }

    @JsonProperty("APIResourceList")
    public void setAPIResourceList(APIResourceList aPIResourceList) {
        this.aPIResourceList = aPIResourceList;
    }

    @JsonProperty("APIService")
    public APIService getAPIService() {
        return aPIService;
    }

    @JsonProperty("APIService")
    public void setAPIService(APIService aPIService) {
        this.aPIService = aPIService;
    }

    @JsonProperty("APIServiceList")
    public APIServiceList getAPIServiceList() {
        return aPIServiceList;
    }

    @JsonProperty("APIServiceList")
    public void setAPIServiceList(APIServiceList aPIServiceList) {
        this.aPIServiceList = aPIServiceList;
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

    @JsonProperty("ComponentStatus")
    public ComponentStatus getComponentStatus() {
        return componentStatus;
    }

    @JsonProperty("ComponentStatus")
    public void setComponentStatus(ComponentStatus componentStatus) {
        this.componentStatus = componentStatus;
    }

    @JsonProperty("ComponentStatusList")
    public ComponentStatusList getComponentStatusList() {
        return componentStatusList;
    }

    @JsonProperty("ComponentStatusList")
    public void setComponentStatusList(ComponentStatusList componentStatusList) {
        this.componentStatusList = componentStatusList;
    }

    @JsonProperty("Condition")
    public Condition getCondition() {
        return condition;
    }

    @JsonProperty("Condition")
    public void setCondition(Condition condition) {
        this.condition = condition;
    }

    @JsonProperty("Config")
    public Config getConfig() {
        return config;
    }

    @JsonProperty("Config")
    public void setConfig(Config config) {
        this.config = config;
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

    @JsonProperty("CreateOptions")
    public CreateOptions getCreateOptions() {
        return createOptions;
    }

    @JsonProperty("CreateOptions")
    public void setCreateOptions(CreateOptions createOptions) {
        this.createOptions = createOptions;
    }

    @JsonProperty("DeleteOptions")
    public DeleteOptions getDeleteOptions() {
        return deleteOptions;
    }

    @JsonProperty("DeleteOptions")
    public void setDeleteOptions(DeleteOptions deleteOptions) {
        this.deleteOptions = deleteOptions;
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

    @JsonProperty("Event")
    public Event getEvent() {
        return event;
    }

    @JsonProperty("Event")
    public void setEvent(Event event) {
        this.event = event;
    }

    @JsonProperty("EventList")
    public EventList getEventList() {
        return eventList;
    }

    @JsonProperty("EventList")
    public void setEventList(EventList eventList) {
        this.eventList = eventList;
    }

    @JsonProperty("EventSeries")
    public EventSeries getEventSeries() {
        return eventSeries;
    }

    @JsonProperty("EventSeries")
    public void setEventSeries(EventSeries eventSeries) {
        this.eventSeries = eventSeries;
    }

    @JsonProperty("EventSource")
    public EventSource getEventSource() {
        return eventSource;
    }

    @JsonProperty("EventSource")
    public void setEventSource(EventSource eventSource) {
        this.eventSource = eventSource;
    }

    @JsonProperty("GetOptions")
    public GetOptions getGetOptions() {
        return getOptions;
    }

    @JsonProperty("GetOptions")
    public void setGetOptions(GetOptions getOptions) {
        this.getOptions = getOptions;
    }

    @JsonProperty("GroupKind")
    public GroupKind getGroupKind() {
        return groupKind;
    }

    @JsonProperty("GroupKind")
    public void setGroupKind(GroupKind groupKind) {
        this.groupKind = groupKind;
    }

    @JsonProperty("GroupVersionKind")
    public GroupVersionKind getGroupVersionKind() {
        return groupVersionKind;
    }

    @JsonProperty("GroupVersionKind")
    public void setGroupVersionKind(GroupVersionKind groupVersionKind) {
        this.groupVersionKind = groupVersionKind;
    }

    @JsonProperty("GroupVersionResource")
    public GroupVersionResource getGroupVersionResource() {
        return groupVersionResource;
    }

    @JsonProperty("GroupVersionResource")
    public void setGroupVersionResource(GroupVersionResource groupVersionResource) {
        this.groupVersionResource = groupVersionResource;
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

    @JsonProperty("MicroTime")
    public MicroTime getMicroTime() {
        return microTime;
    }

    @JsonProperty("MicroTime")
    public void setMicroTime(MicroTime microTime) {
        this.microTime = microTime;
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
    public ObjectMeta getObjectMeta() {
        return objectMeta;
    }

    @JsonProperty("ObjectMeta")
    public void setObjectMeta(ObjectMeta objectMeta) {
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
    public PersistentVolumeClaim getPersistentVolumeClaim() {
        return persistentVolumeClaim;
    }

    @JsonProperty("PersistentVolumeClaim")
    public void setPersistentVolumeClaim(PersistentVolumeClaim persistentVolumeClaim) {
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

    @JsonProperty("PodExecOptions")
    public PodExecOptions getPodExecOptions() {
        return podExecOptions;
    }

    @JsonProperty("PodExecOptions")
    public void setPodExecOptions(PodExecOptions podExecOptions) {
        this.podExecOptions = podExecOptions;
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

    @JsonProperty("TopologySelectorTerm")
    public TopologySelectorTerm getTopologySelectorTerm() {
        return topologySelectorTerm;
    }

    @JsonProperty("TopologySelectorTerm")
    public void setTopologySelectorTerm(TopologySelectorTerm topologySelectorTerm) {
        this.topologySelectorTerm = topologySelectorTerm;
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

    @JsonProperty("WatchEvent")
    public WatchEvent getWatchEvent() {
        return watchEvent;
    }

    @JsonProperty("WatchEvent")
    public void setWatchEvent(WatchEvent watchEvent) {
        this.watchEvent = watchEvent;
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
