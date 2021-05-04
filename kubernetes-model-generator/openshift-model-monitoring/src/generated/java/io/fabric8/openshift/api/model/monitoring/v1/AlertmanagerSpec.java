
package io.fabric8.openshift.api.model.monitoring.v1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.fabric8.kubernetes.api.model.Affinity;
import io.fabric8.kubernetes.api.model.IntOrString;
import io.fabric8.kubernetes.api.model.KubernetesResource;
import io.fabric8.kubernetes.api.model.LabelSelector;
import io.fabric8.kubernetes.api.model.ObjectMeta;
import io.fabric8.kubernetes.api.model.ObjectReference;
import io.fabric8.kubernetes.api.model.PersistentVolumeClaim;
import io.fabric8.kubernetes.api.model.PodSecurityContext;
import io.fabric8.kubernetes.api.model.PodTemplateSpec;
import io.fabric8.kubernetes.api.model.Toleration;
import io.fabric8.kubernetes.api.model.Volume;
import io.fabric8.kubernetes.api.model.VolumeMount;
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "apiVersion",
    "kind",
    "metadata",
    "additionalPeers",
    "affinity",
    "baseImage",
    "clusterAdvertiseAddress",
    "configMaps",
    "configSecret",
    "containers",
    "externalUrl",
    "image",
    "imagePullSecrets",
    "initContainers",
    "listenLocal",
    "logFormat",
    "logLevel",
    "nodeSelector",
    "paused",
    "podMetadata",
    "portName",
    "priorityClassName",
    "replicas",
    "resources",
    "retention",
    "routePrefix",
    "secrets",
    "securityContext",
    "serviceAccountName",
    "sha",
    "storage",
    "tag",
    "tolerations",
    "version",
    "volumeMounts",
    "volumes"
})
@ToString
@EqualsAndHashCode
@Buildable(editableEnabled = false, validationEnabled = false, generateBuilderPackage = false, lazyCollectionInitEnabled = false, builderPackage = "io.fabric8.kubernetes.api.builder", refs = {
    @BuildableReference(ObjectMeta.class),
    @BuildableReference(LabelSelector.class),
    @BuildableReference(io.fabric8.kubernetes.api.model.Container.class),
    @BuildableReference(PodTemplateSpec.class),
    @BuildableReference(io.fabric8.kubernetes.api.model.ResourceRequirements.class),
    @BuildableReference(IntOrString.class),
    @BuildableReference(ObjectReference.class),
    @BuildableReference(io.fabric8.kubernetes.api.model.LocalObjectReference.class),
    @BuildableReference(PersistentVolumeClaim.class)
})
public class AlertmanagerSpec implements KubernetesResource
{

    @JsonProperty("additionalPeers")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<java.lang.String> additionalPeers = new ArrayList<java.lang.String>();
    @JsonProperty("affinity")
    private Affinity affinity;
    @JsonProperty("baseImage")
    private java.lang.String baseImage;
    @JsonProperty("clusterAdvertiseAddress")
    private java.lang.String clusterAdvertiseAddress;
    @JsonProperty("configMaps")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<java.lang.String> configMaps = new ArrayList<java.lang.String>();
    @JsonProperty("configSecret")
    private java.lang.String configSecret;
    @JsonProperty("containers")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<io.fabric8.kubernetes.api.model.Container> containers = new ArrayList<io.fabric8.kubernetes.api.model.Container>();
    @JsonProperty("externalUrl")
    private java.lang.String externalUrl;
    @JsonProperty("image")
    private java.lang.String image;
    @JsonProperty("imagePullSecrets")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<io.fabric8.kubernetes.api.model.LocalObjectReference> imagePullSecrets = new ArrayList<io.fabric8.kubernetes.api.model.LocalObjectReference>();
    @JsonProperty("initContainers")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<io.fabric8.kubernetes.api.model.Container> initContainers = new ArrayList<io.fabric8.kubernetes.api.model.Container>();
    @JsonProperty("listenLocal")
    private Boolean listenLocal;
    @JsonProperty("logFormat")
    private java.lang.String logFormat;
    @JsonProperty("logLevel")
    private java.lang.String logLevel;
    @JsonProperty("nodeSelector")
    private Map<String, String> nodeSelector;
    @JsonProperty("paused")
    private Boolean paused;
    @JsonProperty("podMetadata")
    private EmbeddedObjectMetadata podMetadata;
    @JsonProperty("portName")
    private java.lang.String portName;
    @JsonProperty("priorityClassName")
    private java.lang.String priorityClassName;
    @JsonProperty("replicas")
    private Integer replicas;
    @JsonProperty("resources")
    private io.fabric8.kubernetes.api.model.ResourceRequirements resources;
    @JsonProperty("retention")
    private java.lang.String retention;
    @JsonProperty("routePrefix")
    private java.lang.String routePrefix;
    @JsonProperty("secrets")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<java.lang.String> secrets = new ArrayList<java.lang.String>();
    @JsonProperty("securityContext")
    private PodSecurityContext securityContext;
    @JsonProperty("serviceAccountName")
    private java.lang.String serviceAccountName;
    @JsonProperty("sha")
    private java.lang.String sha;
    @JsonProperty("storage")
    private StorageSpec storage;
    @JsonProperty("tag")
    private java.lang.String tag;
    @JsonProperty("tolerations")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<Toleration> tolerations = new ArrayList<Toleration>();
    @JsonProperty("version")
    private java.lang.String version;
    @JsonProperty("volumeMounts")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<VolumeMount> volumeMounts = new ArrayList<VolumeMount>();
    @JsonProperty("volumes")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<Volume> volumes = new ArrayList<Volume>();
    @JsonIgnore
    private Map<java.lang.String, Object> additionalProperties = new HashMap<java.lang.String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public AlertmanagerSpec() {
    }

    /**
     * 
     * @param paused
     * @param serviceAccountName
     * @param imagePullSecrets
     * @param baseImage
     * @param priorityClassName
     * @param portName
     * @param securityContext
     * @param storage
     * @param nodeSelector
     * @param volumeMounts
     * @param tolerations
     * @param logLevel
     * @param tag
     * @param configSecret
     * @param retention
     * @param externalUrl
     * @param image
     * @param replicas
     * @param volumes
     * @param resources
     * @param listenLocal
     * @param secrets
     * @param sha
     * @param version
     * @param clusterAdvertiseAddress
     * @param logFormat
     * @param configMaps
     * @param routePrefix
     * @param additionalPeers
     * @param containers
     * @param podMetadata
     * @param initContainers
     * @param affinity
     */
    public AlertmanagerSpec(List<java.lang.String> additionalPeers, Affinity affinity, java.lang.String baseImage, java.lang.String clusterAdvertiseAddress, List<java.lang.String> configMaps, java.lang.String configSecret, List<io.fabric8.kubernetes.api.model.Container> containers, java.lang.String externalUrl, java.lang.String image, List<io.fabric8.kubernetes.api.model.LocalObjectReference> imagePullSecrets, List<io.fabric8.kubernetes.api.model.Container> initContainers, Boolean listenLocal, java.lang.String logFormat, java.lang.String logLevel, Map<String, String> nodeSelector, Boolean paused, EmbeddedObjectMetadata podMetadata, java.lang.String portName, java.lang.String priorityClassName, Integer replicas, io.fabric8.kubernetes.api.model.ResourceRequirements resources, java.lang.String retention, java.lang.String routePrefix, List<java.lang.String> secrets, PodSecurityContext securityContext, java.lang.String serviceAccountName, java.lang.String sha, StorageSpec storage, java.lang.String tag, List<Toleration> tolerations, java.lang.String version, List<VolumeMount> volumeMounts, List<Volume> volumes) {
        super();
        this.additionalPeers = additionalPeers;
        this.affinity = affinity;
        this.baseImage = baseImage;
        this.clusterAdvertiseAddress = clusterAdvertiseAddress;
        this.configMaps = configMaps;
        this.configSecret = configSecret;
        this.containers = containers;
        this.externalUrl = externalUrl;
        this.image = image;
        this.imagePullSecrets = imagePullSecrets;
        this.initContainers = initContainers;
        this.listenLocal = listenLocal;
        this.logFormat = logFormat;
        this.logLevel = logLevel;
        this.nodeSelector = nodeSelector;
        this.paused = paused;
        this.podMetadata = podMetadata;
        this.portName = portName;
        this.priorityClassName = priorityClassName;
        this.replicas = replicas;
        this.resources = resources;
        this.retention = retention;
        this.routePrefix = routePrefix;
        this.secrets = secrets;
        this.securityContext = securityContext;
        this.serviceAccountName = serviceAccountName;
        this.sha = sha;
        this.storage = storage;
        this.tag = tag;
        this.tolerations = tolerations;
        this.version = version;
        this.volumeMounts = volumeMounts;
        this.volumes = volumes;
    }

    @JsonProperty("additionalPeers")
    public List<java.lang.String> getAdditionalPeers() {
        return additionalPeers;
    }

    @JsonProperty("additionalPeers")
    public void setAdditionalPeers(List<java.lang.String> additionalPeers) {
        this.additionalPeers = additionalPeers;
    }

    @JsonProperty("affinity")
    public Affinity getAffinity() {
        return affinity;
    }

    @JsonProperty("affinity")
    public void setAffinity(Affinity affinity) {
        this.affinity = affinity;
    }

    @JsonProperty("baseImage")
    public java.lang.String getBaseImage() {
        return baseImage;
    }

    @JsonProperty("baseImage")
    public void setBaseImage(java.lang.String baseImage) {
        this.baseImage = baseImage;
    }

    @JsonProperty("clusterAdvertiseAddress")
    public java.lang.String getClusterAdvertiseAddress() {
        return clusterAdvertiseAddress;
    }

    @JsonProperty("clusterAdvertiseAddress")
    public void setClusterAdvertiseAddress(java.lang.String clusterAdvertiseAddress) {
        this.clusterAdvertiseAddress = clusterAdvertiseAddress;
    }

    @JsonProperty("configMaps")
    public List<java.lang.String> getConfigMaps() {
        return configMaps;
    }

    @JsonProperty("configMaps")
    public void setConfigMaps(List<java.lang.String> configMaps) {
        this.configMaps = configMaps;
    }

    @JsonProperty("configSecret")
    public java.lang.String getConfigSecret() {
        return configSecret;
    }

    @JsonProperty("configSecret")
    public void setConfigSecret(java.lang.String configSecret) {
        this.configSecret = configSecret;
    }

    @JsonProperty("containers")
    public List<io.fabric8.kubernetes.api.model.Container> getContainers() {
        return containers;
    }

    @JsonProperty("containers")
    public void setContainers(List<io.fabric8.kubernetes.api.model.Container> containers) {
        this.containers = containers;
    }

    @JsonProperty("externalUrl")
    public java.lang.String getExternalUrl() {
        return externalUrl;
    }

    @JsonProperty("externalUrl")
    public void setExternalUrl(java.lang.String externalUrl) {
        this.externalUrl = externalUrl;
    }

    @JsonProperty("image")
    public java.lang.String getImage() {
        return image;
    }

    @JsonProperty("image")
    public void setImage(java.lang.String image) {
        this.image = image;
    }

    @JsonProperty("imagePullSecrets")
    public List<io.fabric8.kubernetes.api.model.LocalObjectReference> getImagePullSecrets() {
        return imagePullSecrets;
    }

    @JsonProperty("imagePullSecrets")
    public void setImagePullSecrets(List<io.fabric8.kubernetes.api.model.LocalObjectReference> imagePullSecrets) {
        this.imagePullSecrets = imagePullSecrets;
    }

    @JsonProperty("initContainers")
    public List<io.fabric8.kubernetes.api.model.Container> getInitContainers() {
        return initContainers;
    }

    @JsonProperty("initContainers")
    public void setInitContainers(List<io.fabric8.kubernetes.api.model.Container> initContainers) {
        this.initContainers = initContainers;
    }

    @JsonProperty("listenLocal")
    public Boolean getListenLocal() {
        return listenLocal;
    }

    @JsonProperty("listenLocal")
    public void setListenLocal(Boolean listenLocal) {
        this.listenLocal = listenLocal;
    }

    @JsonProperty("logFormat")
    public java.lang.String getLogFormat() {
        return logFormat;
    }

    @JsonProperty("logFormat")
    public void setLogFormat(java.lang.String logFormat) {
        this.logFormat = logFormat;
    }

    @JsonProperty("logLevel")
    public java.lang.String getLogLevel() {
        return logLevel;
    }

    @JsonProperty("logLevel")
    public void setLogLevel(java.lang.String logLevel) {
        this.logLevel = logLevel;
    }

    @JsonProperty("nodeSelector")
    public Map<String, String> getNodeSelector() {
        return nodeSelector;
    }

    @JsonProperty("nodeSelector")
    public void setNodeSelector(Map<String, String> nodeSelector) {
        this.nodeSelector = nodeSelector;
    }

    @JsonProperty("paused")
    public Boolean getPaused() {
        return paused;
    }

    @JsonProperty("paused")
    public void setPaused(Boolean paused) {
        this.paused = paused;
    }

    @JsonProperty("podMetadata")
    public EmbeddedObjectMetadata getPodMetadata() {
        return podMetadata;
    }

    @JsonProperty("podMetadata")
    public void setPodMetadata(EmbeddedObjectMetadata podMetadata) {
        this.podMetadata = podMetadata;
    }

    @JsonProperty("portName")
    public java.lang.String getPortName() {
        return portName;
    }

    @JsonProperty("portName")
    public void setPortName(java.lang.String portName) {
        this.portName = portName;
    }

    @JsonProperty("priorityClassName")
    public java.lang.String getPriorityClassName() {
        return priorityClassName;
    }

    @JsonProperty("priorityClassName")
    public void setPriorityClassName(java.lang.String priorityClassName) {
        this.priorityClassName = priorityClassName;
    }

    @JsonProperty("replicas")
    public Integer getReplicas() {
        return replicas;
    }

    @JsonProperty("replicas")
    public void setReplicas(Integer replicas) {
        this.replicas = replicas;
    }

    @JsonProperty("resources")
    public io.fabric8.kubernetes.api.model.ResourceRequirements getResources() {
        return resources;
    }

    @JsonProperty("resources")
    public void setResources(io.fabric8.kubernetes.api.model.ResourceRequirements resources) {
        this.resources = resources;
    }

    @JsonProperty("retention")
    public java.lang.String getRetention() {
        return retention;
    }

    @JsonProperty("retention")
    public void setRetention(java.lang.String retention) {
        this.retention = retention;
    }

    @JsonProperty("routePrefix")
    public java.lang.String getRoutePrefix() {
        return routePrefix;
    }

    @JsonProperty("routePrefix")
    public void setRoutePrefix(java.lang.String routePrefix) {
        this.routePrefix = routePrefix;
    }

    @JsonProperty("secrets")
    public List<java.lang.String> getSecrets() {
        return secrets;
    }

    @JsonProperty("secrets")
    public void setSecrets(List<java.lang.String> secrets) {
        this.secrets = secrets;
    }

    @JsonProperty("securityContext")
    public PodSecurityContext getSecurityContext() {
        return securityContext;
    }

    @JsonProperty("securityContext")
    public void setSecurityContext(PodSecurityContext securityContext) {
        this.securityContext = securityContext;
    }

    @JsonProperty("serviceAccountName")
    public java.lang.String getServiceAccountName() {
        return serviceAccountName;
    }

    @JsonProperty("serviceAccountName")
    public void setServiceAccountName(java.lang.String serviceAccountName) {
        this.serviceAccountName = serviceAccountName;
    }

    @JsonProperty("sha")
    public java.lang.String getSha() {
        return sha;
    }

    @JsonProperty("sha")
    public void setSha(java.lang.String sha) {
        this.sha = sha;
    }

    @JsonProperty("storage")
    public StorageSpec getStorage() {
        return storage;
    }

    @JsonProperty("storage")
    public void setStorage(StorageSpec storage) {
        this.storage = storage;
    }

    @JsonProperty("tag")
    public java.lang.String getTag() {
        return tag;
    }

    @JsonProperty("tag")
    public void setTag(java.lang.String tag) {
        this.tag = tag;
    }

    @JsonProperty("tolerations")
    public List<Toleration> getTolerations() {
        return tolerations;
    }

    @JsonProperty("tolerations")
    public void setTolerations(List<Toleration> tolerations) {
        this.tolerations = tolerations;
    }

    @JsonProperty("version")
    public java.lang.String getVersion() {
        return version;
    }

    @JsonProperty("version")
    public void setVersion(java.lang.String version) {
        this.version = version;
    }

    @JsonProperty("volumeMounts")
    public List<VolumeMount> getVolumeMounts() {
        return volumeMounts;
    }

    @JsonProperty("volumeMounts")
    public void setVolumeMounts(List<VolumeMount> volumeMounts) {
        this.volumeMounts = volumeMounts;
    }

    @JsonProperty("volumes")
    public List<Volume> getVolumes() {
        return volumes;
    }

    @JsonProperty("volumes")
    public void setVolumes(List<Volume> volumes) {
        this.volumes = volumes;
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
