
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
import io.fabric8.kubernetes.api.model.Affinity;
import io.fabric8.kubernetes.api.model.IntOrString;
import io.fabric8.kubernetes.api.model.KubernetesResource;
import io.fabric8.kubernetes.api.model.ObjectMeta;
import io.fabric8.kubernetes.api.model.PersistentVolumeClaim;
import io.fabric8.kubernetes.api.model.PodSecurityContext;
import io.fabric8.kubernetes.api.model.PodTemplateSpec;
import io.fabric8.kubernetes.api.model.SecretKeySelector;
import io.fabric8.kubernetes.api.model.Toleration;
import io.fabric8.kubernetes.api.model.TopologySpreadConstraint;
import io.fabric8.kubernetes.api.model.Volume;
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
    "affinity",
    "alertDropLabels",
    "alertQueryUrl",
    "alertRelabelConfigFile",
    "alertRelabelConfigs",
    "alertmanagersConfig",
    "alertmanagersUrl",
    "containers",
    "enforcedNamespaceLabel",
    "evaluationInterval",
    "excludedFromEnforcement",
    "externalPrefix",
    "grpcServerTlsConfig",
    "hostAliases",
    "image",
    "imagePullSecrets",
    "initContainers",
    "labels",
    "listenLocal",
    "logFormat",
    "logLevel",
    "minReadySeconds",
    "nodeSelector",
    "objectStorageConfig",
    "objectStorageConfigFile",
    "paused",
    "podMetadata",
    "portName",
    "priorityClassName",
    "prometheusRulesExcludedFromEnforce",
    "queryConfig",
    "queryEndpoints",
    "replicas",
    "resources",
    "retention",
    "routePrefix",
    "ruleNamespaceSelector",
    "ruleSelector",
    "securityContext",
    "serviceAccountName",
    "storage",
    "tolerations",
    "topologySpreadConstraints",
    "tracingConfig",
    "volumes"
})
@ToString
@EqualsAndHashCode
@Setter
@Accessors(prefix = {
    "_",
    ""
})
@Buildable(editableEnabled = false, validationEnabled = false, generateBuilderPackage = false, lazyCollectionInitEnabled = false, builderPackage = "io.fabric8.kubernetes.api.builder", refs = {
    @BuildableReference(ObjectMeta.class),
    @BuildableReference(io.fabric8.kubernetes.api.model.LabelSelector.class),
    @BuildableReference(io.fabric8.kubernetes.api.model.Container.class),
    @BuildableReference(PodTemplateSpec.class),
    @BuildableReference(io.fabric8.kubernetes.api.model.ResourceRequirements.class),
    @BuildableReference(IntOrString.class),
    @BuildableReference(io.fabric8.kubernetes.api.model.ObjectReference.class),
    @BuildableReference(io.fabric8.kubernetes.api.model.LocalObjectReference.class),
    @BuildableReference(PersistentVolumeClaim.class)
})
@Generated("jsonschema2pojo")
public class ThanosRulerSpec implements KubernetesResource
{

    @JsonProperty("affinity")
    private Affinity affinity;
    @JsonProperty("alertDropLabels")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<java.lang.String> alertDropLabels = new ArrayList<java.lang.String>();
    @JsonProperty("alertQueryUrl")
    private java.lang.String alertQueryUrl;
    @JsonProperty("alertRelabelConfigFile")
    private java.lang.String alertRelabelConfigFile;
    @JsonProperty("alertRelabelConfigs")
    private SecretKeySelector alertRelabelConfigs;
    @JsonProperty("alertmanagersConfig")
    private SecretKeySelector alertmanagersConfig;
    @JsonProperty("alertmanagersUrl")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<java.lang.String> alertmanagersUrl = new ArrayList<java.lang.String>();
    @JsonProperty("containers")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<io.fabric8.kubernetes.api.model.Container> containers = new ArrayList<io.fabric8.kubernetes.api.model.Container>();
    @JsonProperty("enforcedNamespaceLabel")
    private java.lang.String enforcedNamespaceLabel;
    @JsonProperty("evaluationInterval")
    private java.lang.String evaluationInterval;
    @JsonProperty("excludedFromEnforcement")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<io.fabric8.openshift.api.model.monitoring.v1.ObjectReference> excludedFromEnforcement = new ArrayList<io.fabric8.openshift.api.model.monitoring.v1.ObjectReference>();
    @JsonProperty("externalPrefix")
    private java.lang.String externalPrefix;
    @JsonProperty("grpcServerTlsConfig")
    private TLSConfig grpcServerTlsConfig;
    @JsonProperty("hostAliases")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<HostAlias> hostAliases = new ArrayList<HostAlias>();
    @JsonProperty("image")
    private java.lang.String image;
    @JsonProperty("imagePullSecrets")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<io.fabric8.kubernetes.api.model.LocalObjectReference> imagePullSecrets = new ArrayList<io.fabric8.kubernetes.api.model.LocalObjectReference>();
    @JsonProperty("initContainers")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<io.fabric8.kubernetes.api.model.Container> initContainers = new ArrayList<io.fabric8.kubernetes.api.model.Container>();
    @JsonProperty("labels")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Map<String, String> labels = new LinkedHashMap<String, String>();
    @JsonProperty("listenLocal")
    private Boolean listenLocal;
    @JsonProperty("logFormat")
    private java.lang.String logFormat;
    @JsonProperty("logLevel")
    private java.lang.String logLevel;
    @JsonProperty("minReadySeconds")
    private Integer minReadySeconds;
    @JsonProperty("nodeSelector")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Map<String, String> nodeSelector = new LinkedHashMap<String, String>();
    @JsonProperty("objectStorageConfig")
    private SecretKeySelector objectStorageConfig;
    @JsonProperty("objectStorageConfigFile")
    private java.lang.String objectStorageConfigFile;
    @JsonProperty("paused")
    private Boolean paused;
    @JsonProperty("podMetadata")
    private EmbeddedObjectMetadata podMetadata;
    @JsonProperty("portName")
    private java.lang.String portName;
    @JsonProperty("priorityClassName")
    private java.lang.String priorityClassName;
    @JsonProperty("prometheusRulesExcludedFromEnforce")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<PrometheusRuleExcludeConfig> prometheusRulesExcludedFromEnforce = new ArrayList<PrometheusRuleExcludeConfig>();
    @JsonProperty("queryConfig")
    private SecretKeySelector queryConfig;
    @JsonProperty("queryEndpoints")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<java.lang.String> queryEndpoints = new ArrayList<java.lang.String>();
    @JsonProperty("replicas")
    private Integer replicas;
    @JsonProperty("resources")
    private io.fabric8.kubernetes.api.model.ResourceRequirements resources;
    @JsonProperty("retention")
    private java.lang.String retention;
    @JsonProperty("routePrefix")
    private java.lang.String routePrefix;
    @JsonProperty("ruleNamespaceSelector")
    private io.fabric8.kubernetes.api.model.LabelSelector ruleNamespaceSelector;
    @JsonProperty("ruleSelector")
    private io.fabric8.kubernetes.api.model.LabelSelector ruleSelector;
    @JsonProperty("securityContext")
    private PodSecurityContext securityContext;
    @JsonProperty("serviceAccountName")
    private java.lang.String serviceAccountName;
    @JsonProperty("storage")
    private StorageSpec storage;
    @JsonProperty("tolerations")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<Toleration> tolerations = new ArrayList<Toleration>();
    @JsonProperty("topologySpreadConstraints")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<TopologySpreadConstraint> topologySpreadConstraints = new ArrayList<TopologySpreadConstraint>();
    @JsonProperty("tracingConfig")
    private SecretKeySelector tracingConfig;
    @JsonProperty("volumes")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<Volume> volumes = new ArrayList<Volume>();
    @JsonIgnore
    private Map<java.lang.String, Object> additionalProperties = new LinkedHashMap<java.lang.String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public ThanosRulerSpec() {
    }

    public ThanosRulerSpec(Affinity affinity, List<java.lang.String> alertDropLabels, java.lang.String alertQueryUrl, java.lang.String alertRelabelConfigFile, SecretKeySelector alertRelabelConfigs, SecretKeySelector alertmanagersConfig, List<java.lang.String> alertmanagersUrl, List<io.fabric8.kubernetes.api.model.Container> containers, java.lang.String enforcedNamespaceLabel, java.lang.String evaluationInterval, List<io.fabric8.openshift.api.model.monitoring.v1.ObjectReference> excludedFromEnforcement, java.lang.String externalPrefix, TLSConfig grpcServerTlsConfig, List<HostAlias> hostAliases, java.lang.String image, List<io.fabric8.kubernetes.api.model.LocalObjectReference> imagePullSecrets, List<io.fabric8.kubernetes.api.model.Container> initContainers, Map<String, String> labels, Boolean listenLocal, java.lang.String logFormat, java.lang.String logLevel, Integer minReadySeconds, Map<String, String> nodeSelector, SecretKeySelector objectStorageConfig, java.lang.String objectStorageConfigFile, Boolean paused, EmbeddedObjectMetadata podMetadata, java.lang.String portName, java.lang.String priorityClassName, List<PrometheusRuleExcludeConfig> prometheusRulesExcludedFromEnforce, SecretKeySelector queryConfig, List<java.lang.String> queryEndpoints, Integer replicas, io.fabric8.kubernetes.api.model.ResourceRequirements resources, java.lang.String retention, java.lang.String routePrefix, io.fabric8.kubernetes.api.model.LabelSelector ruleNamespaceSelector, io.fabric8.kubernetes.api.model.LabelSelector ruleSelector, PodSecurityContext securityContext, java.lang.String serviceAccountName, StorageSpec storage, List<Toleration> tolerations, List<TopologySpreadConstraint> topologySpreadConstraints, SecretKeySelector tracingConfig, List<Volume> volumes) {
        super();
        this.affinity = affinity;
        this.alertDropLabels = alertDropLabels;
        this.alertQueryUrl = alertQueryUrl;
        this.alertRelabelConfigFile = alertRelabelConfigFile;
        this.alertRelabelConfigs = alertRelabelConfigs;
        this.alertmanagersConfig = alertmanagersConfig;
        this.alertmanagersUrl = alertmanagersUrl;
        this.containers = containers;
        this.enforcedNamespaceLabel = enforcedNamespaceLabel;
        this.evaluationInterval = evaluationInterval;
        this.excludedFromEnforcement = excludedFromEnforcement;
        this.externalPrefix = externalPrefix;
        this.grpcServerTlsConfig = grpcServerTlsConfig;
        this.hostAliases = hostAliases;
        this.image = image;
        this.imagePullSecrets = imagePullSecrets;
        this.initContainers = initContainers;
        this.labels = labels;
        this.listenLocal = listenLocal;
        this.logFormat = logFormat;
        this.logLevel = logLevel;
        this.minReadySeconds = minReadySeconds;
        this.nodeSelector = nodeSelector;
        this.objectStorageConfig = objectStorageConfig;
        this.objectStorageConfigFile = objectStorageConfigFile;
        this.paused = paused;
        this.podMetadata = podMetadata;
        this.portName = portName;
        this.priorityClassName = priorityClassName;
        this.prometheusRulesExcludedFromEnforce = prometheusRulesExcludedFromEnforce;
        this.queryConfig = queryConfig;
        this.queryEndpoints = queryEndpoints;
        this.replicas = replicas;
        this.resources = resources;
        this.retention = retention;
        this.routePrefix = routePrefix;
        this.ruleNamespaceSelector = ruleNamespaceSelector;
        this.ruleSelector = ruleSelector;
        this.securityContext = securityContext;
        this.serviceAccountName = serviceAccountName;
        this.storage = storage;
        this.tolerations = tolerations;
        this.topologySpreadConstraints = topologySpreadConstraints;
        this.tracingConfig = tracingConfig;
        this.volumes = volumes;
    }

    @JsonProperty("affinity")
    public Affinity getAffinity() {
        return affinity;
    }

    @JsonProperty("affinity")
    public void setAffinity(Affinity affinity) {
        this.affinity = affinity;
    }

    @JsonProperty("alertDropLabels")
    public List<java.lang.String> getAlertDropLabels() {
        return alertDropLabels;
    }

    @JsonProperty("alertDropLabels")
    public void setAlertDropLabels(List<java.lang.String> alertDropLabels) {
        this.alertDropLabels = alertDropLabels;
    }

    @JsonProperty("alertQueryUrl")
    public java.lang.String getAlertQueryUrl() {
        return alertQueryUrl;
    }

    @JsonProperty("alertQueryUrl")
    public void setAlertQueryUrl(java.lang.String alertQueryUrl) {
        this.alertQueryUrl = alertQueryUrl;
    }

    @JsonProperty("alertRelabelConfigFile")
    public java.lang.String getAlertRelabelConfigFile() {
        return alertRelabelConfigFile;
    }

    @JsonProperty("alertRelabelConfigFile")
    public void setAlertRelabelConfigFile(java.lang.String alertRelabelConfigFile) {
        this.alertRelabelConfigFile = alertRelabelConfigFile;
    }

    @JsonProperty("alertRelabelConfigs")
    public SecretKeySelector getAlertRelabelConfigs() {
        return alertRelabelConfigs;
    }

    @JsonProperty("alertRelabelConfigs")
    public void setAlertRelabelConfigs(SecretKeySelector alertRelabelConfigs) {
        this.alertRelabelConfigs = alertRelabelConfigs;
    }

    @JsonProperty("alertmanagersConfig")
    public SecretKeySelector getAlertmanagersConfig() {
        return alertmanagersConfig;
    }

    @JsonProperty("alertmanagersConfig")
    public void setAlertmanagersConfig(SecretKeySelector alertmanagersConfig) {
        this.alertmanagersConfig = alertmanagersConfig;
    }

    @JsonProperty("alertmanagersUrl")
    public List<java.lang.String> getAlertmanagersUrl() {
        return alertmanagersUrl;
    }

    @JsonProperty("alertmanagersUrl")
    public void setAlertmanagersUrl(List<java.lang.String> alertmanagersUrl) {
        this.alertmanagersUrl = alertmanagersUrl;
    }

    @JsonProperty("containers")
    public List<io.fabric8.kubernetes.api.model.Container> getContainers() {
        return containers;
    }

    @JsonProperty("containers")
    public void setContainers(List<io.fabric8.kubernetes.api.model.Container> containers) {
        this.containers = containers;
    }

    @JsonProperty("enforcedNamespaceLabel")
    public java.lang.String getEnforcedNamespaceLabel() {
        return enforcedNamespaceLabel;
    }

    @JsonProperty("enforcedNamespaceLabel")
    public void setEnforcedNamespaceLabel(java.lang.String enforcedNamespaceLabel) {
        this.enforcedNamespaceLabel = enforcedNamespaceLabel;
    }

    @JsonProperty("evaluationInterval")
    public java.lang.String getEvaluationInterval() {
        return evaluationInterval;
    }

    @JsonProperty("evaluationInterval")
    public void setEvaluationInterval(java.lang.String evaluationInterval) {
        this.evaluationInterval = evaluationInterval;
    }

    @JsonProperty("excludedFromEnforcement")
    public List<io.fabric8.openshift.api.model.monitoring.v1.ObjectReference> getExcludedFromEnforcement() {
        return excludedFromEnforcement;
    }

    @JsonProperty("excludedFromEnforcement")
    public void setExcludedFromEnforcement(List<io.fabric8.openshift.api.model.monitoring.v1.ObjectReference> excludedFromEnforcement) {
        this.excludedFromEnforcement = excludedFromEnforcement;
    }

    @JsonProperty("externalPrefix")
    public java.lang.String getExternalPrefix() {
        return externalPrefix;
    }

    @JsonProperty("externalPrefix")
    public void setExternalPrefix(java.lang.String externalPrefix) {
        this.externalPrefix = externalPrefix;
    }

    @JsonProperty("grpcServerTlsConfig")
    public TLSConfig getGrpcServerTlsConfig() {
        return grpcServerTlsConfig;
    }

    @JsonProperty("grpcServerTlsConfig")
    public void setGrpcServerTlsConfig(TLSConfig grpcServerTlsConfig) {
        this.grpcServerTlsConfig = grpcServerTlsConfig;
    }

    @JsonProperty("hostAliases")
    public List<HostAlias> getHostAliases() {
        return hostAliases;
    }

    @JsonProperty("hostAliases")
    public void setHostAliases(List<HostAlias> hostAliases) {
        this.hostAliases = hostAliases;
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

    @JsonProperty("labels")
    public Map<String, String> getLabels() {
        return labels;
    }

    @JsonProperty("labels")
    public void setLabels(Map<String, String> labels) {
        this.labels = labels;
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

    @JsonProperty("minReadySeconds")
    public Integer getMinReadySeconds() {
        return minReadySeconds;
    }

    @JsonProperty("minReadySeconds")
    public void setMinReadySeconds(Integer minReadySeconds) {
        this.minReadySeconds = minReadySeconds;
    }

    @JsonProperty("nodeSelector")
    public Map<String, String> getNodeSelector() {
        return nodeSelector;
    }

    @JsonProperty("nodeSelector")
    public void setNodeSelector(Map<String, String> nodeSelector) {
        this.nodeSelector = nodeSelector;
    }

    @JsonProperty("objectStorageConfig")
    public SecretKeySelector getObjectStorageConfig() {
        return objectStorageConfig;
    }

    @JsonProperty("objectStorageConfig")
    public void setObjectStorageConfig(SecretKeySelector objectStorageConfig) {
        this.objectStorageConfig = objectStorageConfig;
    }

    @JsonProperty("objectStorageConfigFile")
    public java.lang.String getObjectStorageConfigFile() {
        return objectStorageConfigFile;
    }

    @JsonProperty("objectStorageConfigFile")
    public void setObjectStorageConfigFile(java.lang.String objectStorageConfigFile) {
        this.objectStorageConfigFile = objectStorageConfigFile;
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

    @JsonProperty("prometheusRulesExcludedFromEnforce")
    public List<PrometheusRuleExcludeConfig> getPrometheusRulesExcludedFromEnforce() {
        return prometheusRulesExcludedFromEnforce;
    }

    @JsonProperty("prometheusRulesExcludedFromEnforce")
    public void setPrometheusRulesExcludedFromEnforce(List<PrometheusRuleExcludeConfig> prometheusRulesExcludedFromEnforce) {
        this.prometheusRulesExcludedFromEnforce = prometheusRulesExcludedFromEnforce;
    }

    @JsonProperty("queryConfig")
    public SecretKeySelector getQueryConfig() {
        return queryConfig;
    }

    @JsonProperty("queryConfig")
    public void setQueryConfig(SecretKeySelector queryConfig) {
        this.queryConfig = queryConfig;
    }

    @JsonProperty("queryEndpoints")
    public List<java.lang.String> getQueryEndpoints() {
        return queryEndpoints;
    }

    @JsonProperty("queryEndpoints")
    public void setQueryEndpoints(List<java.lang.String> queryEndpoints) {
        this.queryEndpoints = queryEndpoints;
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

    @JsonProperty("ruleNamespaceSelector")
    public io.fabric8.kubernetes.api.model.LabelSelector getRuleNamespaceSelector() {
        return ruleNamespaceSelector;
    }

    @JsonProperty("ruleNamespaceSelector")
    public void setRuleNamespaceSelector(io.fabric8.kubernetes.api.model.LabelSelector ruleNamespaceSelector) {
        this.ruleNamespaceSelector = ruleNamespaceSelector;
    }

    @JsonProperty("ruleSelector")
    public io.fabric8.kubernetes.api.model.LabelSelector getRuleSelector() {
        return ruleSelector;
    }

    @JsonProperty("ruleSelector")
    public void setRuleSelector(io.fabric8.kubernetes.api.model.LabelSelector ruleSelector) {
        this.ruleSelector = ruleSelector;
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

    @JsonProperty("storage")
    public StorageSpec getStorage() {
        return storage;
    }

    @JsonProperty("storage")
    public void setStorage(StorageSpec storage) {
        this.storage = storage;
    }

    @JsonProperty("tolerations")
    public List<Toleration> getTolerations() {
        return tolerations;
    }

    @JsonProperty("tolerations")
    public void setTolerations(List<Toleration> tolerations) {
        this.tolerations = tolerations;
    }

    @JsonProperty("topologySpreadConstraints")
    public List<TopologySpreadConstraint> getTopologySpreadConstraints() {
        return topologySpreadConstraints;
    }

    @JsonProperty("topologySpreadConstraints")
    public void setTopologySpreadConstraints(List<TopologySpreadConstraint> topologySpreadConstraints) {
        this.topologySpreadConstraints = topologySpreadConstraints;
    }

    @JsonProperty("tracingConfig")
    public SecretKeySelector getTracingConfig() {
        return tracingConfig;
    }

    @JsonProperty("tracingConfig")
    public void setTracingConfig(SecretKeySelector tracingConfig) {
        this.tracingConfig = tracingConfig;
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
