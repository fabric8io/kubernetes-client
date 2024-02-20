
package io.fabric8.kubernetes.api.model;

import java.util.LinkedHashMap;
import java.util.Map;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
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

@Generated("jsonschema2pojo")
public class ValidationSchema {

    private APIGroup aPIGroup;
    private APIGroupList aPIGroupList;
    private KubernetesList baseKubernetesList;
    private Binding binding;
    private ComponentStatusList componentStatusList;
    private ConfigMap configMap;
    private ConfigMapList configMapList;
    private ContainerStatus containerStatus;
    private ControllerRevision controllerRevision;
    private ControllerRevisionList controllerRevisionList;
    private CreateOptions createOptions;
    private DaemonSet daemonSet;
    private DaemonSetList daemonSetList;
    private DeleteOptions deleteOptions;
    private Deployment deployment;
    private DeploymentList deploymentList;
    private EndpointPort endpointPort;
    private Endpoints endpoints;
    private EndpointsList endpointsList;
    private EnvVar envVar;
    private GetOptions getOptions;
    private Info info;
    private LimitRangeList limitRangeList;
    private ListOptions listOptions;
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
    private PodList podList;
    private PodTemplateList podTemplateList;
    private Quantity quantity;
    private ReplicaSet replicaSet;
    private ReplicaSetList replicaSetList;
    private ReplicationControllerList replicationControllerList;
    private ResourceQuota resourceQuota;
    private ResourceQuotaList resourceQuotaList;
    private RootPaths rootPaths;
    private Secret secret;
    private SecretList secretList;
    private ServiceAccount serviceAccount;
    private ServiceAccountList serviceAccountList;
    private ServiceList serviceList;
    private StatefulSet statefulSet;
    private StatefulSetList statefulSetList;
    private Status status;
    private String time;
    private Toleration toleration;
    private TypeMeta typeMeta;
    private UpdateOptions updateOptions;
    @JsonIgnore
    private Map<java.lang.String, Object> additionalProperties = new LinkedHashMap<java.lang.String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public ValidationSchema() {
    }

    public ValidationSchema(APIGroup aPIGroup, APIGroupList aPIGroupList, KubernetesList baseKubernetesList, Binding binding, ComponentStatusList componentStatusList, ConfigMap configMap, ConfigMapList configMapList, ContainerStatus containerStatus, ControllerRevision controllerRevision, ControllerRevisionList controllerRevisionList, CreateOptions createOptions, DaemonSet daemonSet, DaemonSetList daemonSetList, DeleteOptions deleteOptions, Deployment deployment, DeploymentList deploymentList, EndpointPort endpointPort, Endpoints endpoints, EndpointsList endpointsList, EnvVar envVar, GetOptions getOptions, Info info, LimitRangeList limitRangeList, ListOptions listOptions, Namespace namespace, NamespaceList namespaceList, Node node, NodeList nodeList, ObjectMeta objectMeta, Patch patch, PatchOptions patchOptions, PersistentVolume persistentVolume, PersistentVolumeClaim persistentVolumeClaim, PersistentVolumeClaimList persistentVolumeClaimList, PersistentVolumeList persistentVolumeList, PodList podList, PodTemplateList podTemplateList, Quantity quantity, ReplicaSet replicaSet, ReplicaSetList replicaSetList, ReplicationControllerList replicationControllerList, ResourceQuota resourceQuota, ResourceQuotaList resourceQuotaList, RootPaths rootPaths, Secret secret, SecretList secretList, ServiceAccount serviceAccount, ServiceAccountList serviceAccountList, ServiceList serviceList, StatefulSet statefulSet, StatefulSetList statefulSetList, Status status, String time, Toleration toleration, TypeMeta typeMeta, UpdateOptions updateOptions) {
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
    public KubernetesList getBaseKubernetesList() {
        return baseKubernetesList;
    }

    @JsonProperty("BaseKubernetesList")
    public void setBaseKubernetesList(KubernetesList baseKubernetesList) {
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
