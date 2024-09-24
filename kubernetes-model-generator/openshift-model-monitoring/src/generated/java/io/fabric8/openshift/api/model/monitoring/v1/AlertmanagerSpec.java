
package io.fabric8.openshift.api.model.monitoring.v1;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.fabric8.kubernetes.api.builder.Editable;
import io.fabric8.kubernetes.api.model.Container;
import io.fabric8.kubernetes.api.model.IntOrString;
import io.fabric8.kubernetes.api.model.KubernetesResource;
import io.fabric8.kubernetes.api.model.LabelSelector;
import io.fabric8.kubernetes.api.model.LocalObjectReference;
import io.fabric8.kubernetes.api.model.ObjectMeta;
import io.fabric8.kubernetes.api.model.ObjectReference;
import io.fabric8.kubernetes.api.model.PersistentVolumeClaim;
import io.fabric8.kubernetes.api.model.PodTemplateSpec;
import io.fabric8.kubernetes.api.model.ResourceRequirements;
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "additionalPeers",
    "affinity",
    "alertmanagerConfigMatcherStrategy",
    "alertmanagerConfigNamespaceSelector",
    "alertmanagerConfigSelector",
    "alertmanagerConfiguration",
    "automountServiceAccountToken",
    "baseImage",
    "clusterAdvertiseAddress",
    "clusterGossipInterval",
    "clusterLabel",
    "clusterPeerTimeout",
    "clusterPushpullInterval",
    "configMaps",
    "configSecret",
    "containers",
    "enableFeatures",
    "externalUrl",
    "forceEnableClusterMode",
    "hostAliases",
    "image",
    "imagePullPolicy",
    "imagePullSecrets",
    "initContainers",
    "listenLocal",
    "logFormat",
    "logLevel",
    "minReadySeconds",
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
    "topologySpreadConstraints",
    "version",
    "volumeMounts",
    "volumes",
    "web"
})
@ToString
@EqualsAndHashCode
@Accessors(prefix = {
    "_",
    ""
})
@Buildable(editableEnabled = false, validationEnabled = false, generateBuilderPackage = false, lazyCollectionInitEnabled = false, builderPackage = "io.fabric8.kubernetes.api.builder", refs = {
    @BuildableReference(ObjectMeta.class),
    @BuildableReference(LabelSelector.class),
    @BuildableReference(Container.class),
    @BuildableReference(PodTemplateSpec.class),
    @BuildableReference(ResourceRequirements.class),
    @BuildableReference(IntOrString.class),
    @BuildableReference(ObjectReference.class),
    @BuildableReference(LocalObjectReference.class),
    @BuildableReference(PersistentVolumeClaim.class)
})
@Generated("jsonschema2pojo")
public class AlertmanagerSpec implements Editable<AlertmanagerSpecBuilder> , KubernetesResource
{

    @JsonProperty("additionalPeers")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> additionalPeers = new ArrayList<>();
    @JsonProperty("affinity")
    private AlertmanagerSpecAffinity affinity;
    @JsonProperty("alertmanagerConfigMatcherStrategy")
    private AlertmanagerSpecAlertmanagerConfigMatcherStrategy alertmanagerConfigMatcherStrategy;
    @JsonProperty("alertmanagerConfigNamespaceSelector")
    private AlertmanagerSpecAlertmanagerConfigNamespaceSelector alertmanagerConfigNamespaceSelector;
    @JsonProperty("alertmanagerConfigSelector")
    private AlertmanagerSpecAlertmanagerConfigSelector alertmanagerConfigSelector;
    @JsonProperty("alertmanagerConfiguration")
    private AlertmanagerSpecAlertmanagerConfiguration alertmanagerConfiguration;
    @JsonProperty("automountServiceAccountToken")
    private Boolean automountServiceAccountToken;
    @JsonProperty("baseImage")
    private String baseImage;
    @JsonProperty("clusterAdvertiseAddress")
    private String clusterAdvertiseAddress;
    @JsonProperty("clusterGossipInterval")
    private String clusterGossipInterval;
    @JsonProperty("clusterLabel")
    private String clusterLabel;
    @JsonProperty("clusterPeerTimeout")
    private String clusterPeerTimeout;
    @JsonProperty("clusterPushpullInterval")
    private String clusterPushpullInterval;
    @JsonProperty("configMaps")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> configMaps = new ArrayList<>();
    @JsonProperty("configSecret")
    private String configSecret;
    @JsonProperty("containers")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<AlertmanagerSpecContainers> containers = new ArrayList<>();
    @JsonProperty("enableFeatures")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> enableFeatures = new ArrayList<>();
    @JsonProperty("externalUrl")
    private String externalUrl;
    @JsonProperty("forceEnableClusterMode")
    private Boolean forceEnableClusterMode;
    @JsonProperty("hostAliases")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<AlertmanagerSpecHostAliases> hostAliases = new ArrayList<>();
    @JsonProperty("image")
    private String image;
    @JsonProperty("imagePullPolicy")
    private String imagePullPolicy;
    @JsonProperty("imagePullSecrets")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<AlertmanagerSpecImagePullSecrets> imagePullSecrets = new ArrayList<>();
    @JsonProperty("initContainers")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<AlertmanagerSpecInitContainers> initContainers = new ArrayList<>();
    @JsonProperty("listenLocal")
    private Boolean listenLocal;
    @JsonProperty("logFormat")
    private String logFormat;
    @JsonProperty("logLevel")
    private String logLevel;
    @JsonProperty("minReadySeconds")
    private Integer minReadySeconds;
    @JsonProperty("nodeSelector")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Map<String, String> nodeSelector = new LinkedHashMap<>();
    @JsonProperty("paused")
    private Boolean paused;
    @JsonProperty("podMetadata")
    private AlertmanagerSpecPodMetadata podMetadata;
    @JsonProperty("portName")
    private String portName;
    @JsonProperty("priorityClassName")
    private String priorityClassName;
    @JsonProperty("replicas")
    private Integer replicas;
    @JsonProperty("resources")
    private AlertmanagerSpecResources resources;
    @JsonProperty("retention")
    private String retention;
    @JsonProperty("routePrefix")
    private String routePrefix;
    @JsonProperty("secrets")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> secrets = new ArrayList<>();
    @JsonProperty("securityContext")
    private AlertmanagerSpecSecurityContext securityContext;
    @JsonProperty("serviceAccountName")
    private String serviceAccountName;
    @JsonProperty("sha")
    private String sha;
    @JsonProperty("storage")
    private AlertmanagerSpecStorage storage;
    @JsonProperty("tag")
    private String tag;
    @JsonProperty("tolerations")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<AlertmanagerSpecTolerations> tolerations = new ArrayList<>();
    @JsonProperty("topologySpreadConstraints")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<AlertmanagerSpecTopologySpreadConstraints> topologySpreadConstraints = new ArrayList<>();
    @JsonProperty("version")
    private String version;
    @JsonProperty("volumeMounts")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<AlertmanagerSpecVolumeMounts> volumeMounts = new ArrayList<>();
    @JsonProperty("volumes")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<AlertmanagerSpecVolumes> volumes = new ArrayList<>();
    @JsonProperty("web")
    private AlertmanagerSpecWeb web;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public AlertmanagerSpec() {
    }

    public AlertmanagerSpec(List<String> additionalPeers, AlertmanagerSpecAffinity affinity, AlertmanagerSpecAlertmanagerConfigMatcherStrategy alertmanagerConfigMatcherStrategy, AlertmanagerSpecAlertmanagerConfigNamespaceSelector alertmanagerConfigNamespaceSelector, AlertmanagerSpecAlertmanagerConfigSelector alertmanagerConfigSelector, AlertmanagerSpecAlertmanagerConfiguration alertmanagerConfiguration, Boolean automountServiceAccountToken, String baseImage, String clusterAdvertiseAddress, String clusterGossipInterval, String clusterLabel, String clusterPeerTimeout, String clusterPushpullInterval, List<String> configMaps, String configSecret, List<AlertmanagerSpecContainers> containers, List<String> enableFeatures, String externalUrl, Boolean forceEnableClusterMode, List<AlertmanagerSpecHostAliases> hostAliases, String image, String imagePullPolicy, List<AlertmanagerSpecImagePullSecrets> imagePullSecrets, List<AlertmanagerSpecInitContainers> initContainers, Boolean listenLocal, String logFormat, String logLevel, Integer minReadySeconds, Map<String, String> nodeSelector, Boolean paused, AlertmanagerSpecPodMetadata podMetadata, String portName, String priorityClassName, Integer replicas, AlertmanagerSpecResources resources, String retention, String routePrefix, List<String> secrets, AlertmanagerSpecSecurityContext securityContext, String serviceAccountName, String sha, AlertmanagerSpecStorage storage, String tag, List<AlertmanagerSpecTolerations> tolerations, List<AlertmanagerSpecTopologySpreadConstraints> topologySpreadConstraints, String version, List<AlertmanagerSpecVolumeMounts> volumeMounts, List<AlertmanagerSpecVolumes> volumes, AlertmanagerSpecWeb web) {
        super();
        this.additionalPeers = additionalPeers;
        this.affinity = affinity;
        this.alertmanagerConfigMatcherStrategy = alertmanagerConfigMatcherStrategy;
        this.alertmanagerConfigNamespaceSelector = alertmanagerConfigNamespaceSelector;
        this.alertmanagerConfigSelector = alertmanagerConfigSelector;
        this.alertmanagerConfiguration = alertmanagerConfiguration;
        this.automountServiceAccountToken = automountServiceAccountToken;
        this.baseImage = baseImage;
        this.clusterAdvertiseAddress = clusterAdvertiseAddress;
        this.clusterGossipInterval = clusterGossipInterval;
        this.clusterLabel = clusterLabel;
        this.clusterPeerTimeout = clusterPeerTimeout;
        this.clusterPushpullInterval = clusterPushpullInterval;
        this.configMaps = configMaps;
        this.configSecret = configSecret;
        this.containers = containers;
        this.enableFeatures = enableFeatures;
        this.externalUrl = externalUrl;
        this.forceEnableClusterMode = forceEnableClusterMode;
        this.hostAliases = hostAliases;
        this.image = image;
        this.imagePullPolicy = imagePullPolicy;
        this.imagePullSecrets = imagePullSecrets;
        this.initContainers = initContainers;
        this.listenLocal = listenLocal;
        this.logFormat = logFormat;
        this.logLevel = logLevel;
        this.minReadySeconds = minReadySeconds;
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
        this.topologySpreadConstraints = topologySpreadConstraints;
        this.version = version;
        this.volumeMounts = volumeMounts;
        this.volumes = volumes;
        this.web = web;
    }

    @JsonProperty("additionalPeers")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getAdditionalPeers() {
        return additionalPeers;
    }

    @JsonProperty("additionalPeers")
    public void setAdditionalPeers(List<String> additionalPeers) {
        this.additionalPeers = additionalPeers;
    }

    @JsonProperty("affinity")
    public AlertmanagerSpecAffinity getAffinity() {
        return affinity;
    }

    @JsonProperty("affinity")
    public void setAffinity(AlertmanagerSpecAffinity affinity) {
        this.affinity = affinity;
    }

    @JsonProperty("alertmanagerConfigMatcherStrategy")
    public AlertmanagerSpecAlertmanagerConfigMatcherStrategy getAlertmanagerConfigMatcherStrategy() {
        return alertmanagerConfigMatcherStrategy;
    }

    @JsonProperty("alertmanagerConfigMatcherStrategy")
    public void setAlertmanagerConfigMatcherStrategy(AlertmanagerSpecAlertmanagerConfigMatcherStrategy alertmanagerConfigMatcherStrategy) {
        this.alertmanagerConfigMatcherStrategy = alertmanagerConfigMatcherStrategy;
    }

    @JsonProperty("alertmanagerConfigNamespaceSelector")
    public AlertmanagerSpecAlertmanagerConfigNamespaceSelector getAlertmanagerConfigNamespaceSelector() {
        return alertmanagerConfigNamespaceSelector;
    }

    @JsonProperty("alertmanagerConfigNamespaceSelector")
    public void setAlertmanagerConfigNamespaceSelector(AlertmanagerSpecAlertmanagerConfigNamespaceSelector alertmanagerConfigNamespaceSelector) {
        this.alertmanagerConfigNamespaceSelector = alertmanagerConfigNamespaceSelector;
    }

    @JsonProperty("alertmanagerConfigSelector")
    public AlertmanagerSpecAlertmanagerConfigSelector getAlertmanagerConfigSelector() {
        return alertmanagerConfigSelector;
    }

    @JsonProperty("alertmanagerConfigSelector")
    public void setAlertmanagerConfigSelector(AlertmanagerSpecAlertmanagerConfigSelector alertmanagerConfigSelector) {
        this.alertmanagerConfigSelector = alertmanagerConfigSelector;
    }

    @JsonProperty("alertmanagerConfiguration")
    public AlertmanagerSpecAlertmanagerConfiguration getAlertmanagerConfiguration() {
        return alertmanagerConfiguration;
    }

    @JsonProperty("alertmanagerConfiguration")
    public void setAlertmanagerConfiguration(AlertmanagerSpecAlertmanagerConfiguration alertmanagerConfiguration) {
        this.alertmanagerConfiguration = alertmanagerConfiguration;
    }

    @JsonProperty("automountServiceAccountToken")
    public Boolean getAutomountServiceAccountToken() {
        return automountServiceAccountToken;
    }

    @JsonProperty("automountServiceAccountToken")
    public void setAutomountServiceAccountToken(Boolean automountServiceAccountToken) {
        this.automountServiceAccountToken = automountServiceAccountToken;
    }

    @JsonProperty("baseImage")
    public String getBaseImage() {
        return baseImage;
    }

    @JsonProperty("baseImage")
    public void setBaseImage(String baseImage) {
        this.baseImage = baseImage;
    }

    @JsonProperty("clusterAdvertiseAddress")
    public String getClusterAdvertiseAddress() {
        return clusterAdvertiseAddress;
    }

    @JsonProperty("clusterAdvertiseAddress")
    public void setClusterAdvertiseAddress(String clusterAdvertiseAddress) {
        this.clusterAdvertiseAddress = clusterAdvertiseAddress;
    }

    @JsonProperty("clusterGossipInterval")
    public String getClusterGossipInterval() {
        return clusterGossipInterval;
    }

    @JsonProperty("clusterGossipInterval")
    public void setClusterGossipInterval(String clusterGossipInterval) {
        this.clusterGossipInterval = clusterGossipInterval;
    }

    @JsonProperty("clusterLabel")
    public String getClusterLabel() {
        return clusterLabel;
    }

    @JsonProperty("clusterLabel")
    public void setClusterLabel(String clusterLabel) {
        this.clusterLabel = clusterLabel;
    }

    @JsonProperty("clusterPeerTimeout")
    public String getClusterPeerTimeout() {
        return clusterPeerTimeout;
    }

    @JsonProperty("clusterPeerTimeout")
    public void setClusterPeerTimeout(String clusterPeerTimeout) {
        this.clusterPeerTimeout = clusterPeerTimeout;
    }

    @JsonProperty("clusterPushpullInterval")
    public String getClusterPushpullInterval() {
        return clusterPushpullInterval;
    }

    @JsonProperty("clusterPushpullInterval")
    public void setClusterPushpullInterval(String clusterPushpullInterval) {
        this.clusterPushpullInterval = clusterPushpullInterval;
    }

    @JsonProperty("configMaps")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getConfigMaps() {
        return configMaps;
    }

    @JsonProperty("configMaps")
    public void setConfigMaps(List<String> configMaps) {
        this.configMaps = configMaps;
    }

    @JsonProperty("configSecret")
    public String getConfigSecret() {
        return configSecret;
    }

    @JsonProperty("configSecret")
    public void setConfigSecret(String configSecret) {
        this.configSecret = configSecret;
    }

    @JsonProperty("containers")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<AlertmanagerSpecContainers> getContainers() {
        return containers;
    }

    @JsonProperty("containers")
    public void setContainers(List<AlertmanagerSpecContainers> containers) {
        this.containers = containers;
    }

    @JsonProperty("enableFeatures")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getEnableFeatures() {
        return enableFeatures;
    }

    @JsonProperty("enableFeatures")
    public void setEnableFeatures(List<String> enableFeatures) {
        this.enableFeatures = enableFeatures;
    }

    @JsonProperty("externalUrl")
    public String getExternalUrl() {
        return externalUrl;
    }

    @JsonProperty("externalUrl")
    public void setExternalUrl(String externalUrl) {
        this.externalUrl = externalUrl;
    }

    @JsonProperty("forceEnableClusterMode")
    public Boolean getForceEnableClusterMode() {
        return forceEnableClusterMode;
    }

    @JsonProperty("forceEnableClusterMode")
    public void setForceEnableClusterMode(Boolean forceEnableClusterMode) {
        this.forceEnableClusterMode = forceEnableClusterMode;
    }

    @JsonProperty("hostAliases")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<AlertmanagerSpecHostAliases> getHostAliases() {
        return hostAliases;
    }

    @JsonProperty("hostAliases")
    public void setHostAliases(List<AlertmanagerSpecHostAliases> hostAliases) {
        this.hostAliases = hostAliases;
    }

    @JsonProperty("image")
    public String getImage() {
        return image;
    }

    @JsonProperty("image")
    public void setImage(String image) {
        this.image = image;
    }

    @JsonProperty("imagePullPolicy")
    public String getImagePullPolicy() {
        return imagePullPolicy;
    }

    @JsonProperty("imagePullPolicy")
    public void setImagePullPolicy(String imagePullPolicy) {
        this.imagePullPolicy = imagePullPolicy;
    }

    @JsonProperty("imagePullSecrets")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<AlertmanagerSpecImagePullSecrets> getImagePullSecrets() {
        return imagePullSecrets;
    }

    @JsonProperty("imagePullSecrets")
    public void setImagePullSecrets(List<AlertmanagerSpecImagePullSecrets> imagePullSecrets) {
        this.imagePullSecrets = imagePullSecrets;
    }

    @JsonProperty("initContainers")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<AlertmanagerSpecInitContainers> getInitContainers() {
        return initContainers;
    }

    @JsonProperty("initContainers")
    public void setInitContainers(List<AlertmanagerSpecInitContainers> initContainers) {
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
    public String getLogFormat() {
        return logFormat;
    }

    @JsonProperty("logFormat")
    public void setLogFormat(String logFormat) {
        this.logFormat = logFormat;
    }

    @JsonProperty("logLevel")
    public String getLogLevel() {
        return logLevel;
    }

    @JsonProperty("logLevel")
    public void setLogLevel(String logLevel) {
        this.logLevel = logLevel;
    }

    @JsonProperty("minReadySeconds")
    public Integer getMinReadySeconds() {
        return minReadySeconds;
    }

    @JsonProperty("minReadySeconds")
    public void setMinReadySeconds(Integer minReadySeconds) {
        this.minReadySeconds = minReadySeconds;
    }

    @JsonProperty("nodeSelector")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
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
    public AlertmanagerSpecPodMetadata getPodMetadata() {
        return podMetadata;
    }

    @JsonProperty("podMetadata")
    public void setPodMetadata(AlertmanagerSpecPodMetadata podMetadata) {
        this.podMetadata = podMetadata;
    }

    @JsonProperty("portName")
    public String getPortName() {
        return portName;
    }

    @JsonProperty("portName")
    public void setPortName(String portName) {
        this.portName = portName;
    }

    @JsonProperty("priorityClassName")
    public String getPriorityClassName() {
        return priorityClassName;
    }

    @JsonProperty("priorityClassName")
    public void setPriorityClassName(String priorityClassName) {
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
    public AlertmanagerSpecResources getResources() {
        return resources;
    }

    @JsonProperty("resources")
    public void setResources(AlertmanagerSpecResources resources) {
        this.resources = resources;
    }

    @JsonProperty("retention")
    public String getRetention() {
        return retention;
    }

    @JsonProperty("retention")
    public void setRetention(String retention) {
        this.retention = retention;
    }

    @JsonProperty("routePrefix")
    public String getRoutePrefix() {
        return routePrefix;
    }

    @JsonProperty("routePrefix")
    public void setRoutePrefix(String routePrefix) {
        this.routePrefix = routePrefix;
    }

    @JsonProperty("secrets")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getSecrets() {
        return secrets;
    }

    @JsonProperty("secrets")
    public void setSecrets(List<String> secrets) {
        this.secrets = secrets;
    }

    @JsonProperty("securityContext")
    public AlertmanagerSpecSecurityContext getSecurityContext() {
        return securityContext;
    }

    @JsonProperty("securityContext")
    public void setSecurityContext(AlertmanagerSpecSecurityContext securityContext) {
        this.securityContext = securityContext;
    }

    @JsonProperty("serviceAccountName")
    public String getServiceAccountName() {
        return serviceAccountName;
    }

    @JsonProperty("serviceAccountName")
    public void setServiceAccountName(String serviceAccountName) {
        this.serviceAccountName = serviceAccountName;
    }

    @JsonProperty("sha")
    public String getSha() {
        return sha;
    }

    @JsonProperty("sha")
    public void setSha(String sha) {
        this.sha = sha;
    }

    @JsonProperty("storage")
    public AlertmanagerSpecStorage getStorage() {
        return storage;
    }

    @JsonProperty("storage")
    public void setStorage(AlertmanagerSpecStorage storage) {
        this.storage = storage;
    }

    @JsonProperty("tag")
    public String getTag() {
        return tag;
    }

    @JsonProperty("tag")
    public void setTag(String tag) {
        this.tag = tag;
    }

    @JsonProperty("tolerations")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<AlertmanagerSpecTolerations> getTolerations() {
        return tolerations;
    }

    @JsonProperty("tolerations")
    public void setTolerations(List<AlertmanagerSpecTolerations> tolerations) {
        this.tolerations = tolerations;
    }

    @JsonProperty("topologySpreadConstraints")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<AlertmanagerSpecTopologySpreadConstraints> getTopologySpreadConstraints() {
        return topologySpreadConstraints;
    }

    @JsonProperty("topologySpreadConstraints")
    public void setTopologySpreadConstraints(List<AlertmanagerSpecTopologySpreadConstraints> topologySpreadConstraints) {
        this.topologySpreadConstraints = topologySpreadConstraints;
    }

    @JsonProperty("version")
    public String getVersion() {
        return version;
    }

    @JsonProperty("version")
    public void setVersion(String version) {
        this.version = version;
    }

    @JsonProperty("volumeMounts")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<AlertmanagerSpecVolumeMounts> getVolumeMounts() {
        return volumeMounts;
    }

    @JsonProperty("volumeMounts")
    public void setVolumeMounts(List<AlertmanagerSpecVolumeMounts> volumeMounts) {
        this.volumeMounts = volumeMounts;
    }

    @JsonProperty("volumes")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<AlertmanagerSpecVolumes> getVolumes() {
        return volumes;
    }

    @JsonProperty("volumes")
    public void setVolumes(List<AlertmanagerSpecVolumes> volumes) {
        this.volumes = volumes;
    }

    @JsonProperty("web")
    public AlertmanagerSpecWeb getWeb() {
        return web;
    }

    @JsonProperty("web")
    public void setWeb(AlertmanagerSpecWeb web) {
        this.web = web;
    }

    @JsonIgnore
    public AlertmanagerSpecBuilder edit() {
        return new AlertmanagerSpecBuilder(this);
    }

    @JsonIgnore
    public AlertmanagerSpecBuilder toBuilder() {
        return edit();
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    public void setAdditionalProperties(Map<String, Object> additionalProperties) {
        this.additionalProperties = additionalProperties;
    }

}
