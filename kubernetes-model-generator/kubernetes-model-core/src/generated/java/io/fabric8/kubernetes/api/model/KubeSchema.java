
package io.fabric8.kubernetes.api.model;

import java.util.LinkedHashMap;
import java.util.Map;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.fabric8.kubernetes.api.model.version.Info;

@Generated("jsonschema2pojo")
public class KubeSchema {

    private APIGroup aPIGroup;
    private APIGroupList aPIGroupList;
    private APIResource aPIResource;
    private APIResourceList aPIResourceList;
    private APIService aPIService;
    private APIServiceList aPIServiceList;
    private Binding binding;
    private ComponentStatus componentStatus;
    private ComponentStatusList componentStatusList;
    private Condition condition;
    private Config config;
    private ConfigMap configMap;
    private ConfigMapList configMapList;
    private ContainerStatus containerStatus;
    private CreateOptions createOptions;
    private DeleteOptions deleteOptions;
    private EndpointPort endpointPort;
    private Endpoints endpoints;
    private EndpointsList endpointsList;
    private EnvVar envVar;
    private Event event;
    private EventList eventList;
    private EventSeries eventSeries;
    private EventSource eventSource;
    private GetOptions getOptions;
    private GroupKind groupKind;
    private GroupVersionKind groupVersionKind;
    private GroupVersionResource groupVersionResource;
    private Info info;
    private KubernetesList kubernetesList;
    private LimitRangeList limitRangeList;
    private ListOptions listOptions;
    private MicroTime microTime;
    private Namespace namespace;
    private NamespaceList namespaceList;
    private Node node;
    private NodeList nodeList;
    private ObjectMeta objectMeta;
    private Patch patch;
    private PatchOptions patchOptions;
    private PersistentVolume persistentVolume;
    private PersistentVolumeClaim persistentVolumeClaim;
    private PersistentVolumeClaimList persistentVolumeClaimList;
    private PersistentVolumeList persistentVolumeList;
    private PodExecOptions podExecOptions;
    private PodList podList;
    private PodTemplateList podTemplateList;
    private Quantity quantity;
    private ReplicationControllerList replicationControllerList;
    private ResourceQuota resourceQuota;
    private ResourceQuotaList resourceQuotaList;
    private RootPaths rootPaths;
    private Secret secret;
    private SecretList secretList;
    private ServiceAccount serviceAccount;
    private ServiceAccountList serviceAccountList;
    private ServiceList serviceList;
    private Status status;
    private String time;
    private Toleration toleration;
    private TopologySelectorTerm topologySelectorTerm;
    private TypeMeta typeMeta;
    private UpdateOptions updateOptions;
    private WatchEvent watchEvent;
    @JsonIgnore
    private Map<java.lang.String, Object> additionalProperties = new LinkedHashMap<java.lang.String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public KubeSchema() {
    }

    public KubeSchema(APIGroup aPIGroup, APIGroupList aPIGroupList, APIResource aPIResource, APIResourceList aPIResourceList, APIService aPIService, APIServiceList aPIServiceList, Binding binding, ComponentStatus componentStatus, ComponentStatusList componentStatusList, Condition condition, Config config, ConfigMap configMap, ConfigMapList configMapList, ContainerStatus containerStatus, CreateOptions createOptions, DeleteOptions deleteOptions, EndpointPort endpointPort, Endpoints endpoints, EndpointsList endpointsList, EnvVar envVar, Event event, EventList eventList, EventSeries eventSeries, EventSource eventSource, GetOptions getOptions, GroupKind groupKind, GroupVersionKind groupVersionKind, GroupVersionResource groupVersionResource, Info info, KubernetesList kubernetesList, LimitRangeList limitRangeList, ListOptions listOptions, MicroTime microTime, Namespace namespace, NamespaceList namespaceList, Node node, NodeList nodeList, ObjectMeta objectMeta, Patch patch, PatchOptions patchOptions, PersistentVolume persistentVolume, PersistentVolumeClaim persistentVolumeClaim, PersistentVolumeClaimList persistentVolumeClaimList, PersistentVolumeList persistentVolumeList, PodExecOptions podExecOptions, PodList podList, PodTemplateList podTemplateList, Quantity quantity, ReplicationControllerList replicationControllerList, ResourceQuota resourceQuota, ResourceQuotaList resourceQuotaList, RootPaths rootPaths, Secret secret, SecretList secretList, ServiceAccount serviceAccount, ServiceAccountList serviceAccountList, ServiceList serviceList, Status status, String time, Toleration toleration, TopologySelectorTerm topologySelectorTerm, TypeMeta typeMeta, UpdateOptions updateOptions, WatchEvent watchEvent) {
        super();
        this.aPIGroup = aPIGroup;
        this.aPIGroupList = aPIGroupList;
        this.aPIResource = aPIResource;
        this.aPIResourceList = aPIResourceList;
        this.aPIService = aPIService;
        this.aPIServiceList = aPIServiceList;
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
        this.kubernetesList = kubernetesList;
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

    @JsonProperty("KubernetesList")
    public KubernetesList getKubernetesList() {
        return kubernetesList;
    }

    @JsonProperty("KubernetesList")
    public void setKubernetesList(KubernetesList kubernetesList) {
        this.kubernetesList = kubernetesList;
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

    public void setAdditionalProperties(Map<java.lang.String, Object> additionalProperties) {
        this.additionalProperties = additionalProperties;
    }

}
