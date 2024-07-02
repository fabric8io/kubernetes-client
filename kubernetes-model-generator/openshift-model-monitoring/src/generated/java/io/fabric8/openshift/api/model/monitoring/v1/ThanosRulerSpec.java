
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
import io.fabric8.kubernetes.api.model.VolumeMount;
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;
import lombok.EqualsAndHashCode;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "additionalArgs",
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
    "imagePullPolicy",
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
    "tracingConfigFile",
    "version",
    "volumeMounts",
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
public class ThanosRulerSpec implements Editable<ThanosRulerSpecBuilder> , KubernetesResource
{

    @JsonProperty("additionalArgs")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<Argument> additionalArgs = new ArrayList<Argument>();
    @JsonProperty("affinity")
    private Affinity affinity;
    @JsonProperty("alertDropLabels")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> alertDropLabels = new ArrayList<String>();
    @JsonProperty("alertQueryUrl")
    private String alertQueryUrl;
    @JsonProperty("alertRelabelConfigFile")
    private String alertRelabelConfigFile;
    @JsonProperty("alertRelabelConfigs")
    private SecretKeySelector alertRelabelConfigs;
    @JsonProperty("alertmanagersConfig")
    private SecretKeySelector alertmanagersConfig;
    @JsonProperty("alertmanagersUrl")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> alertmanagersUrl = new ArrayList<String>();
    @JsonProperty("containers")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<io.fabric8.kubernetes.api.model.Container> containers = new ArrayList<io.fabric8.kubernetes.api.model.Container>();
    @JsonProperty("enforcedNamespaceLabel")
    private String enforcedNamespaceLabel;
    @JsonProperty("evaluationInterval")
    private String evaluationInterval;
    @JsonProperty("excludedFromEnforcement")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<io.fabric8.openshift.api.model.monitoring.v1.ObjectReference> excludedFromEnforcement = new ArrayList<io.fabric8.openshift.api.model.monitoring.v1.ObjectReference>();
    @JsonProperty("externalPrefix")
    private String externalPrefix;
    @JsonProperty("grpcServerTlsConfig")
    private TLSConfig grpcServerTlsConfig;
    @JsonProperty("hostAliases")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<HostAlias> hostAliases = new ArrayList<HostAlias>();
    @JsonProperty("image")
    private String image;
    @JsonProperty("imagePullPolicy")
    private String imagePullPolicy;
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
    private String logFormat;
    @JsonProperty("logLevel")
    private String logLevel;
    @JsonProperty("minReadySeconds")
    private Integer minReadySeconds;
    @JsonProperty("nodeSelector")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Map<String, String> nodeSelector = new LinkedHashMap<String, String>();
    @JsonProperty("objectStorageConfig")
    private SecretKeySelector objectStorageConfig;
    @JsonProperty("objectStorageConfigFile")
    private String objectStorageConfigFile;
    @JsonProperty("paused")
    private Boolean paused;
    @JsonProperty("podMetadata")
    private EmbeddedObjectMetadata podMetadata;
    @JsonProperty("portName")
    private String portName;
    @JsonProperty("priorityClassName")
    private String priorityClassName;
    @JsonProperty("prometheusRulesExcludedFromEnforce")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<PrometheusRuleExcludeConfig> prometheusRulesExcludedFromEnforce = new ArrayList<PrometheusRuleExcludeConfig>();
    @JsonProperty("queryConfig")
    private SecretKeySelector queryConfig;
    @JsonProperty("queryEndpoints")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> queryEndpoints = new ArrayList<String>();
    @JsonProperty("replicas")
    private Integer replicas;
    @JsonProperty("resources")
    private io.fabric8.kubernetes.api.model.ResourceRequirements resources;
    @JsonProperty("retention")
    private String retention;
    @JsonProperty("routePrefix")
    private String routePrefix;
    @JsonProperty("ruleNamespaceSelector")
    private io.fabric8.kubernetes.api.model.LabelSelector ruleNamespaceSelector;
    @JsonProperty("ruleSelector")
    private io.fabric8.kubernetes.api.model.LabelSelector ruleSelector;
    @JsonProperty("securityContext")
    private PodSecurityContext securityContext;
    @JsonProperty("serviceAccountName")
    private String serviceAccountName;
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
    @JsonProperty("tracingConfigFile")
    private String tracingConfigFile;
    @JsonProperty("version")
    private String version;
    @JsonProperty("volumeMounts")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<VolumeMount> volumeMounts = new ArrayList<VolumeMount>();
    @JsonProperty("volumes")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<Volume> volumes = new ArrayList<Volume>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public ThanosRulerSpec() {
    }

    public ThanosRulerSpec(List<Argument> additionalArgs, Affinity affinity, List<String> alertDropLabels, String alertQueryUrl, String alertRelabelConfigFile, SecretKeySelector alertRelabelConfigs, SecretKeySelector alertmanagersConfig, List<String> alertmanagersUrl, List<io.fabric8.kubernetes.api.model.Container> containers, String enforcedNamespaceLabel, String evaluationInterval, List<io.fabric8.openshift.api.model.monitoring.v1.ObjectReference> excludedFromEnforcement, String externalPrefix, TLSConfig grpcServerTlsConfig, List<HostAlias> hostAliases, String image, String imagePullPolicy, List<io.fabric8.kubernetes.api.model.LocalObjectReference> imagePullSecrets, List<io.fabric8.kubernetes.api.model.Container> initContainers, Map<String, String> labels, Boolean listenLocal, String logFormat, String logLevel, Integer minReadySeconds, Map<String, String> nodeSelector, SecretKeySelector objectStorageConfig, String objectStorageConfigFile, Boolean paused, EmbeddedObjectMetadata podMetadata, String portName, String priorityClassName, List<PrometheusRuleExcludeConfig> prometheusRulesExcludedFromEnforce, SecretKeySelector queryConfig, List<String> queryEndpoints, Integer replicas, io.fabric8.kubernetes.api.model.ResourceRequirements resources, String retention, String routePrefix, io.fabric8.kubernetes.api.model.LabelSelector ruleNamespaceSelector, io.fabric8.kubernetes.api.model.LabelSelector ruleSelector, PodSecurityContext securityContext, String serviceAccountName, StorageSpec storage, List<Toleration> tolerations, List<TopologySpreadConstraint> topologySpreadConstraints, SecretKeySelector tracingConfig, String tracingConfigFile, String version, List<VolumeMount> volumeMounts, List<Volume> volumes) {
        super();
        this.additionalArgs = additionalArgs;
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
        this.imagePullPolicy = imagePullPolicy;
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
        this.tracingConfigFile = tracingConfigFile;
        this.version = version;
        this.volumeMounts = volumeMounts;
        this.volumes = volumes;
    }

    @JsonProperty("additionalArgs")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<Argument> getAdditionalArgs() {
        return additionalArgs;
    }

    @JsonProperty("additionalArgs")
    public void setAdditionalArgs(List<Argument> additionalArgs) {
        this.additionalArgs = additionalArgs;
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
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getAlertDropLabels() {
        return alertDropLabels;
    }

    @JsonProperty("alertDropLabels")
    public void setAlertDropLabels(List<String> alertDropLabels) {
        this.alertDropLabels = alertDropLabels;
    }

    @JsonProperty("alertQueryUrl")
    public String getAlertQueryUrl() {
        return alertQueryUrl;
    }

    @JsonProperty("alertQueryUrl")
    public void setAlertQueryUrl(String alertQueryUrl) {
        this.alertQueryUrl = alertQueryUrl;
    }

    @JsonProperty("alertRelabelConfigFile")
    public String getAlertRelabelConfigFile() {
        return alertRelabelConfigFile;
    }

    @JsonProperty("alertRelabelConfigFile")
    public void setAlertRelabelConfigFile(String alertRelabelConfigFile) {
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
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getAlertmanagersUrl() {
        return alertmanagersUrl;
    }

    @JsonProperty("alertmanagersUrl")
    public void setAlertmanagersUrl(List<String> alertmanagersUrl) {
        this.alertmanagersUrl = alertmanagersUrl;
    }

    @JsonProperty("containers")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<io.fabric8.kubernetes.api.model.Container> getContainers() {
        return containers;
    }

    @JsonProperty("containers")
    public void setContainers(List<io.fabric8.kubernetes.api.model.Container> containers) {
        this.containers = containers;
    }

    @JsonProperty("enforcedNamespaceLabel")
    public String getEnforcedNamespaceLabel() {
        return enforcedNamespaceLabel;
    }

    @JsonProperty("enforcedNamespaceLabel")
    public void setEnforcedNamespaceLabel(String enforcedNamespaceLabel) {
        this.enforcedNamespaceLabel = enforcedNamespaceLabel;
    }

    @JsonProperty("evaluationInterval")
    public String getEvaluationInterval() {
        return evaluationInterval;
    }

    @JsonProperty("evaluationInterval")
    public void setEvaluationInterval(String evaluationInterval) {
        this.evaluationInterval = evaluationInterval;
    }

    @JsonProperty("excludedFromEnforcement")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<io.fabric8.openshift.api.model.monitoring.v1.ObjectReference> getExcludedFromEnforcement() {
        return excludedFromEnforcement;
    }

    @JsonProperty("excludedFromEnforcement")
    public void setExcludedFromEnforcement(List<io.fabric8.openshift.api.model.monitoring.v1.ObjectReference> excludedFromEnforcement) {
        this.excludedFromEnforcement = excludedFromEnforcement;
    }

    @JsonProperty("externalPrefix")
    public String getExternalPrefix() {
        return externalPrefix;
    }

    @JsonProperty("externalPrefix")
    public void setExternalPrefix(String externalPrefix) {
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
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<HostAlias> getHostAliases() {
        return hostAliases;
    }

    @JsonProperty("hostAliases")
    public void setHostAliases(List<HostAlias> hostAliases) {
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
    public List<io.fabric8.kubernetes.api.model.LocalObjectReference> getImagePullSecrets() {
        return imagePullSecrets;
    }

    @JsonProperty("imagePullSecrets")
    public void setImagePullSecrets(List<io.fabric8.kubernetes.api.model.LocalObjectReference> imagePullSecrets) {
        this.imagePullSecrets = imagePullSecrets;
    }

    @JsonProperty("initContainers")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<io.fabric8.kubernetes.api.model.Container> getInitContainers() {
        return initContainers;
    }

    @JsonProperty("initContainers")
    public void setInitContainers(List<io.fabric8.kubernetes.api.model.Container> initContainers) {
        this.initContainers = initContainers;
    }

    @JsonProperty("labels")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
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

    @JsonProperty("objectStorageConfig")
    public SecretKeySelector getObjectStorageConfig() {
        return objectStorageConfig;
    }

    @JsonProperty("objectStorageConfig")
    public void setObjectStorageConfig(SecretKeySelector objectStorageConfig) {
        this.objectStorageConfig = objectStorageConfig;
    }

    @JsonProperty("objectStorageConfigFile")
    public String getObjectStorageConfigFile() {
        return objectStorageConfigFile;
    }

    @JsonProperty("objectStorageConfigFile")
    public void setObjectStorageConfigFile(String objectStorageConfigFile) {
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

    @JsonProperty("prometheusRulesExcludedFromEnforce")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
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
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getQueryEndpoints() {
        return queryEndpoints;
    }

    @JsonProperty("queryEndpoints")
    public void setQueryEndpoints(List<String> queryEndpoints) {
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
    public String getServiceAccountName() {
        return serviceAccountName;
    }

    @JsonProperty("serviceAccountName")
    public void setServiceAccountName(String serviceAccountName) {
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
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<Toleration> getTolerations() {
        return tolerations;
    }

    @JsonProperty("tolerations")
    public void setTolerations(List<Toleration> tolerations) {
        this.tolerations = tolerations;
    }

    @JsonProperty("topologySpreadConstraints")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
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

    @JsonProperty("tracingConfigFile")
    public String getTracingConfigFile() {
        return tracingConfigFile;
    }

    @JsonProperty("tracingConfigFile")
    public void setTracingConfigFile(String tracingConfigFile) {
        this.tracingConfigFile = tracingConfigFile;
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
    public List<VolumeMount> getVolumeMounts() {
        return volumeMounts;
    }

    @JsonProperty("volumeMounts")
    public void setVolumeMounts(List<VolumeMount> volumeMounts) {
        this.volumeMounts = volumeMounts;
    }

    @JsonProperty("volumes")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<Volume> getVolumes() {
        return volumes;
    }

    @JsonProperty("volumes")
    public void setVolumes(List<Volume> volumes) {
        this.volumes = volumes;
    }

    @JsonIgnore
    public ThanosRulerSpecBuilder edit() {
        return new ThanosRulerSpecBuilder(this);
    }

    @JsonIgnore
    public ThanosRulerSpecBuilder toBuilder() {
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

}
