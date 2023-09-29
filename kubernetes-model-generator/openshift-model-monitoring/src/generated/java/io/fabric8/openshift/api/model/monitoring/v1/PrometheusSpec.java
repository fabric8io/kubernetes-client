
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
    "apiVersion",
    "kind",
    "metadata",
    "additionalAlertManagerConfigs",
    "additionalAlertRelabelConfigs",
    "additionalArgs",
    "additionalScrapeConfigs",
    "affinity",
    "alerting",
    "allowOverlappingBlocks",
    "apiserverConfig",
    "arbitraryFSAccessThroughSMs",
    "baseImage",
    "bodySizeLimit",
    "configMaps",
    "containers",
    "disableCompaction",
    "enableAdminAPI",
    "enableFeatures",
    "enableRemoteWriteReceiver",
    "enforcedBodySizeLimit",
    "enforcedKeepDroppedTargets",
    "enforcedLabelLimit",
    "enforcedLabelNameLengthLimit",
    "enforcedLabelValueLengthLimit",
    "enforcedNamespaceLabel",
    "enforcedSampleLimit",
    "enforcedTargetLimit",
    "evaluationInterval",
    "excludedFromEnforcement",
    "exemplars",
    "externalLabels",
    "externalUrl",
    "hostAliases",
    "hostNetwork",
    "ignoreNamespaceSelectors",
    "image",
    "imagePullPolicy",
    "imagePullSecrets",
    "initContainers",
    "keepDroppedTargets",
    "labelLimit",
    "labelNameLengthLimit",
    "labelValueLengthLimit",
    "listenLocal",
    "logFormat",
    "logLevel",
    "minReadySeconds",
    "nodeSelector",
    "overrideHonorLabels",
    "overrideHonorTimestamps",
    "paused",
    "podMetadata",
    "podMonitorNamespaceSelector",
    "podMonitorSelector",
    "podTargetLabels",
    "portName",
    "priorityClassName",
    "probeNamespaceSelector",
    "probeSelector",
    "prometheusExternalLabelName",
    "prometheusRulesExcludedFromEnforce",
    "query",
    "queryLogFile",
    "remoteRead",
    "remoteWrite",
    "replicaExternalLabelName",
    "replicas",
    "resources",
    "retention",
    "retentionSize",
    "routePrefix",
    "ruleNamespaceSelector",
    "ruleSelector",
    "rules",
    "sampleLimit",
    "scrapeConfigNamespaceSelector",
    "scrapeConfigSelector",
    "scrapeInterval",
    "scrapeTimeout",
    "secrets",
    "securityContext",
    "serviceAccountName",
    "serviceMonitorNamespaceSelector",
    "serviceMonitorSelector",
    "sha",
    "shards",
    "storage",
    "tag",
    "targetLimit",
    "thanos",
    "tolerations",
    "topologySpreadConstraints",
    "tracingConfig",
    "tsdb",
    "version",
    "volumeMounts",
    "volumes",
    "walCompression",
    "web"
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
public class PrometheusSpec implements Editable<PrometheusSpecBuilder> , KubernetesResource
{

    @JsonProperty("additionalAlertManagerConfigs")
    private SecretKeySelector additionalAlertManagerConfigs;
    @JsonProperty("additionalAlertRelabelConfigs")
    private SecretKeySelector additionalAlertRelabelConfigs;
    @JsonProperty("additionalArgs")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<Argument> additionalArgs = new ArrayList<Argument>();
    @JsonProperty("additionalScrapeConfigs")
    private SecretKeySelector additionalScrapeConfigs;
    @JsonProperty("affinity")
    private Affinity affinity;
    @JsonProperty("alerting")
    private AlertingSpec alerting;
    @JsonProperty("allowOverlappingBlocks")
    private Boolean allowOverlappingBlocks;
    @JsonProperty("apiserverConfig")
    private APIServerConfig apiserverConfig;
    @JsonProperty("arbitraryFSAccessThroughSMs")
    private ArbitraryFSAccessThroughSMsConfig arbitraryFSAccessThroughSMs;
    @JsonProperty("baseImage")
    private java.lang.String baseImage;
    @JsonProperty("bodySizeLimit")
    private java.lang.String bodySizeLimit;
    @JsonProperty("configMaps")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<java.lang.String> configMaps = new ArrayList<java.lang.String>();
    @JsonProperty("containers")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<io.fabric8.kubernetes.api.model.Container> containers = new ArrayList<io.fabric8.kubernetes.api.model.Container>();
    @JsonProperty("disableCompaction")
    private Boolean disableCompaction;
    @JsonProperty("enableAdminAPI")
    private Boolean enableAdminAPI;
    @JsonProperty("enableFeatures")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<java.lang.String> enableFeatures = new ArrayList<java.lang.String>();
    @JsonProperty("enableRemoteWriteReceiver")
    private Boolean enableRemoteWriteReceiver;
    @JsonProperty("enforcedBodySizeLimit")
    private java.lang.String enforcedBodySizeLimit;
    @JsonProperty("enforcedKeepDroppedTargets")
    private Long enforcedKeepDroppedTargets;
    @JsonProperty("enforcedLabelLimit")
    private Long enforcedLabelLimit;
    @JsonProperty("enforcedLabelNameLengthLimit")
    private Long enforcedLabelNameLengthLimit;
    @JsonProperty("enforcedLabelValueLengthLimit")
    private Long enforcedLabelValueLengthLimit;
    @JsonProperty("enforcedNamespaceLabel")
    private java.lang.String enforcedNamespaceLabel;
    @JsonProperty("enforcedSampleLimit")
    private Long enforcedSampleLimit;
    @JsonProperty("enforcedTargetLimit")
    private Long enforcedTargetLimit;
    @JsonProperty("evaluationInterval")
    private java.lang.String evaluationInterval;
    @JsonProperty("excludedFromEnforcement")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<io.fabric8.openshift.api.model.monitoring.v1.ObjectReference> excludedFromEnforcement = new ArrayList<io.fabric8.openshift.api.model.monitoring.v1.ObjectReference>();
    @JsonProperty("exemplars")
    private Exemplars exemplars;
    @JsonProperty("externalLabels")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Map<String, String> externalLabels = new LinkedHashMap<String, String>();
    @JsonProperty("externalUrl")
    private java.lang.String externalUrl;
    @JsonProperty("hostAliases")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<HostAlias> hostAliases = new ArrayList<HostAlias>();
    @JsonProperty("hostNetwork")
    private Boolean hostNetwork;
    @JsonProperty("ignoreNamespaceSelectors")
    private Boolean ignoreNamespaceSelectors;
    @JsonProperty("image")
    private java.lang.String image;
    @JsonProperty("imagePullPolicy")
    private java.lang.String imagePullPolicy;
    @JsonProperty("imagePullSecrets")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<io.fabric8.kubernetes.api.model.LocalObjectReference> imagePullSecrets = new ArrayList<io.fabric8.kubernetes.api.model.LocalObjectReference>();
    @JsonProperty("initContainers")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<io.fabric8.kubernetes.api.model.Container> initContainers = new ArrayList<io.fabric8.kubernetes.api.model.Container>();
    @JsonProperty("keepDroppedTargets")
    private Long keepDroppedTargets;
    @JsonProperty("labelLimit")
    private Long labelLimit;
    @JsonProperty("labelNameLengthLimit")
    private Long labelNameLengthLimit;
    @JsonProperty("labelValueLengthLimit")
    private Long labelValueLengthLimit;
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
    @JsonProperty("overrideHonorLabels")
    private Boolean overrideHonorLabels;
    @JsonProperty("overrideHonorTimestamps")
    private Boolean overrideHonorTimestamps;
    @JsonProperty("paused")
    private Boolean paused;
    @JsonProperty("podMetadata")
    private EmbeddedObjectMetadata podMetadata;
    @JsonProperty("podMonitorNamespaceSelector")
    private io.fabric8.kubernetes.api.model.LabelSelector podMonitorNamespaceSelector;
    @JsonProperty("podMonitorSelector")
    private io.fabric8.kubernetes.api.model.LabelSelector podMonitorSelector;
    @JsonProperty("podTargetLabels")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<java.lang.String> podTargetLabels = new ArrayList<java.lang.String>();
    @JsonProperty("portName")
    private java.lang.String portName;
    @JsonProperty("priorityClassName")
    private java.lang.String priorityClassName;
    @JsonProperty("probeNamespaceSelector")
    private io.fabric8.kubernetes.api.model.LabelSelector probeNamespaceSelector;
    @JsonProperty("probeSelector")
    private io.fabric8.kubernetes.api.model.LabelSelector probeSelector;
    @JsonProperty("prometheusExternalLabelName")
    private java.lang.String prometheusExternalLabelName;
    @JsonProperty("prometheusRulesExcludedFromEnforce")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<PrometheusRuleExcludeConfig> prometheusRulesExcludedFromEnforce = new ArrayList<PrometheusRuleExcludeConfig>();
    @JsonProperty("query")
    private QuerySpec query;
    @JsonProperty("queryLogFile")
    private java.lang.String queryLogFile;
    @JsonProperty("remoteRead")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<RemoteReadSpec> remoteRead = new ArrayList<RemoteReadSpec>();
    @JsonProperty("remoteWrite")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<RemoteWriteSpec> remoteWrite = new ArrayList<RemoteWriteSpec>();
    @JsonProperty("replicaExternalLabelName")
    private java.lang.String replicaExternalLabelName;
    @JsonProperty("replicas")
    private Integer replicas;
    @JsonProperty("resources")
    private io.fabric8.kubernetes.api.model.ResourceRequirements resources;
    @JsonProperty("retention")
    private java.lang.String retention;
    @JsonProperty("retentionSize")
    private java.lang.String retentionSize;
    @JsonProperty("routePrefix")
    private java.lang.String routePrefix;
    @JsonProperty("ruleNamespaceSelector")
    private io.fabric8.kubernetes.api.model.LabelSelector ruleNamespaceSelector;
    @JsonProperty("ruleSelector")
    private io.fabric8.kubernetes.api.model.LabelSelector ruleSelector;
    @JsonProperty("rules")
    private Rules rules;
    @JsonProperty("sampleLimit")
    private Long sampleLimit;
    @JsonProperty("scrapeConfigNamespaceSelector")
    private io.fabric8.kubernetes.api.model.LabelSelector scrapeConfigNamespaceSelector;
    @JsonProperty("scrapeConfigSelector")
    private io.fabric8.kubernetes.api.model.LabelSelector scrapeConfigSelector;
    @JsonProperty("scrapeInterval")
    private java.lang.String scrapeInterval;
    @JsonProperty("scrapeTimeout")
    private java.lang.String scrapeTimeout;
    @JsonProperty("secrets")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<java.lang.String> secrets = new ArrayList<java.lang.String>();
    @JsonProperty("securityContext")
    private PodSecurityContext securityContext;
    @JsonProperty("serviceAccountName")
    private java.lang.String serviceAccountName;
    @JsonProperty("serviceMonitorNamespaceSelector")
    private io.fabric8.kubernetes.api.model.LabelSelector serviceMonitorNamespaceSelector;
    @JsonProperty("serviceMonitorSelector")
    private io.fabric8.kubernetes.api.model.LabelSelector serviceMonitorSelector;
    @JsonProperty("sha")
    private java.lang.String sha;
    @JsonProperty("shards")
    private Integer shards;
    @JsonProperty("storage")
    private StorageSpec storage;
    @JsonProperty("tag")
    private java.lang.String tag;
    @JsonProperty("targetLimit")
    private Long targetLimit;
    @JsonProperty("thanos")
    private ThanosSpec thanos;
    @JsonProperty("tolerations")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<Toleration> tolerations = new ArrayList<Toleration>();
    @JsonProperty("topologySpreadConstraints")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<TopologySpreadConstraint> topologySpreadConstraints = new ArrayList<TopologySpreadConstraint>();
    @JsonProperty("tracingConfig")
    private PrometheusTracingConfig tracingConfig;
    @JsonProperty("tsdb")
    private TSDBSpec tsdb;
    @JsonProperty("version")
    private java.lang.String version;
    @JsonProperty("volumeMounts")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<VolumeMount> volumeMounts = new ArrayList<VolumeMount>();
    @JsonProperty("volumes")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<Volume> volumes = new ArrayList<Volume>();
    @JsonProperty("walCompression")
    private Boolean walCompression;
    @JsonProperty("web")
    private PrometheusWebSpec web;
    @JsonIgnore
    private Map<java.lang.String, Object> additionalProperties = new LinkedHashMap<java.lang.String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public PrometheusSpec() {
    }

    public PrometheusSpec(SecretKeySelector additionalAlertManagerConfigs, SecretKeySelector additionalAlertRelabelConfigs, List<Argument> additionalArgs, SecretKeySelector additionalScrapeConfigs, Affinity affinity, AlertingSpec alerting, Boolean allowOverlappingBlocks, APIServerConfig apiserverConfig, ArbitraryFSAccessThroughSMsConfig arbitraryFSAccessThroughSMs, java.lang.String baseImage, java.lang.String bodySizeLimit, List<java.lang.String> configMaps, List<io.fabric8.kubernetes.api.model.Container> containers, Boolean disableCompaction, Boolean enableAdminAPI, List<java.lang.String> enableFeatures, Boolean enableRemoteWriteReceiver, java.lang.String enforcedBodySizeLimit, Long enforcedKeepDroppedTargets, Long enforcedLabelLimit, Long enforcedLabelNameLengthLimit, Long enforcedLabelValueLengthLimit, java.lang.String enforcedNamespaceLabel, Long enforcedSampleLimit, Long enforcedTargetLimit, java.lang.String evaluationInterval, List<io.fabric8.openshift.api.model.monitoring.v1.ObjectReference> excludedFromEnforcement, Exemplars exemplars, Map<String, String> externalLabels, java.lang.String externalUrl, List<HostAlias> hostAliases, Boolean hostNetwork, Boolean ignoreNamespaceSelectors, java.lang.String image, java.lang.String imagePullPolicy, List<io.fabric8.kubernetes.api.model.LocalObjectReference> imagePullSecrets, List<io.fabric8.kubernetes.api.model.Container> initContainers, Long keepDroppedTargets, Long labelLimit, Long labelNameLengthLimit, Long labelValueLengthLimit, Boolean listenLocal, java.lang.String logFormat, java.lang.String logLevel, Integer minReadySeconds, Map<String, String> nodeSelector, Boolean overrideHonorLabels, Boolean overrideHonorTimestamps, Boolean paused, EmbeddedObjectMetadata podMetadata, io.fabric8.kubernetes.api.model.LabelSelector podMonitorNamespaceSelector, io.fabric8.kubernetes.api.model.LabelSelector podMonitorSelector, List<java.lang.String> podTargetLabels, java.lang.String portName, java.lang.String priorityClassName, io.fabric8.kubernetes.api.model.LabelSelector probeNamespaceSelector, io.fabric8.kubernetes.api.model.LabelSelector probeSelector, java.lang.String prometheusExternalLabelName, List<PrometheusRuleExcludeConfig> prometheusRulesExcludedFromEnforce, QuerySpec query, java.lang.String queryLogFile, List<RemoteReadSpec> remoteRead, List<RemoteWriteSpec> remoteWrite, java.lang.String replicaExternalLabelName, Integer replicas, io.fabric8.kubernetes.api.model.ResourceRequirements resources, java.lang.String retention, java.lang.String retentionSize, java.lang.String routePrefix, io.fabric8.kubernetes.api.model.LabelSelector ruleNamespaceSelector, io.fabric8.kubernetes.api.model.LabelSelector ruleSelector, Rules rules, Long sampleLimit, io.fabric8.kubernetes.api.model.LabelSelector scrapeConfigNamespaceSelector, io.fabric8.kubernetes.api.model.LabelSelector scrapeConfigSelector, java.lang.String scrapeInterval, java.lang.String scrapeTimeout, List<java.lang.String> secrets, PodSecurityContext securityContext, java.lang.String serviceAccountName, io.fabric8.kubernetes.api.model.LabelSelector serviceMonitorNamespaceSelector, io.fabric8.kubernetes.api.model.LabelSelector serviceMonitorSelector, java.lang.String sha, Integer shards, StorageSpec storage, java.lang.String tag, Long targetLimit, ThanosSpec thanos, List<Toleration> tolerations, List<TopologySpreadConstraint> topologySpreadConstraints, PrometheusTracingConfig tracingConfig, TSDBSpec tsdb, java.lang.String version, List<VolumeMount> volumeMounts, List<Volume> volumes, Boolean walCompression, PrometheusWebSpec web) {
        super();
        this.additionalAlertManagerConfigs = additionalAlertManagerConfigs;
        this.additionalAlertRelabelConfigs = additionalAlertRelabelConfigs;
        this.additionalArgs = additionalArgs;
        this.additionalScrapeConfigs = additionalScrapeConfigs;
        this.affinity = affinity;
        this.alerting = alerting;
        this.allowOverlappingBlocks = allowOverlappingBlocks;
        this.apiserverConfig = apiserverConfig;
        this.arbitraryFSAccessThroughSMs = arbitraryFSAccessThroughSMs;
        this.baseImage = baseImage;
        this.bodySizeLimit = bodySizeLimit;
        this.configMaps = configMaps;
        this.containers = containers;
        this.disableCompaction = disableCompaction;
        this.enableAdminAPI = enableAdminAPI;
        this.enableFeatures = enableFeatures;
        this.enableRemoteWriteReceiver = enableRemoteWriteReceiver;
        this.enforcedBodySizeLimit = enforcedBodySizeLimit;
        this.enforcedKeepDroppedTargets = enforcedKeepDroppedTargets;
        this.enforcedLabelLimit = enforcedLabelLimit;
        this.enforcedLabelNameLengthLimit = enforcedLabelNameLengthLimit;
        this.enforcedLabelValueLengthLimit = enforcedLabelValueLengthLimit;
        this.enforcedNamespaceLabel = enforcedNamespaceLabel;
        this.enforcedSampleLimit = enforcedSampleLimit;
        this.enforcedTargetLimit = enforcedTargetLimit;
        this.evaluationInterval = evaluationInterval;
        this.excludedFromEnforcement = excludedFromEnforcement;
        this.exemplars = exemplars;
        this.externalLabels = externalLabels;
        this.externalUrl = externalUrl;
        this.hostAliases = hostAliases;
        this.hostNetwork = hostNetwork;
        this.ignoreNamespaceSelectors = ignoreNamespaceSelectors;
        this.image = image;
        this.imagePullPolicy = imagePullPolicy;
        this.imagePullSecrets = imagePullSecrets;
        this.initContainers = initContainers;
        this.keepDroppedTargets = keepDroppedTargets;
        this.labelLimit = labelLimit;
        this.labelNameLengthLimit = labelNameLengthLimit;
        this.labelValueLengthLimit = labelValueLengthLimit;
        this.listenLocal = listenLocal;
        this.logFormat = logFormat;
        this.logLevel = logLevel;
        this.minReadySeconds = minReadySeconds;
        this.nodeSelector = nodeSelector;
        this.overrideHonorLabels = overrideHonorLabels;
        this.overrideHonorTimestamps = overrideHonorTimestamps;
        this.paused = paused;
        this.podMetadata = podMetadata;
        this.podMonitorNamespaceSelector = podMonitorNamespaceSelector;
        this.podMonitorSelector = podMonitorSelector;
        this.podTargetLabels = podTargetLabels;
        this.portName = portName;
        this.priorityClassName = priorityClassName;
        this.probeNamespaceSelector = probeNamespaceSelector;
        this.probeSelector = probeSelector;
        this.prometheusExternalLabelName = prometheusExternalLabelName;
        this.prometheusRulesExcludedFromEnforce = prometheusRulesExcludedFromEnforce;
        this.query = query;
        this.queryLogFile = queryLogFile;
        this.remoteRead = remoteRead;
        this.remoteWrite = remoteWrite;
        this.replicaExternalLabelName = replicaExternalLabelName;
        this.replicas = replicas;
        this.resources = resources;
        this.retention = retention;
        this.retentionSize = retentionSize;
        this.routePrefix = routePrefix;
        this.ruleNamespaceSelector = ruleNamespaceSelector;
        this.ruleSelector = ruleSelector;
        this.rules = rules;
        this.sampleLimit = sampleLimit;
        this.scrapeConfigNamespaceSelector = scrapeConfigNamespaceSelector;
        this.scrapeConfigSelector = scrapeConfigSelector;
        this.scrapeInterval = scrapeInterval;
        this.scrapeTimeout = scrapeTimeout;
        this.secrets = secrets;
        this.securityContext = securityContext;
        this.serviceAccountName = serviceAccountName;
        this.serviceMonitorNamespaceSelector = serviceMonitorNamespaceSelector;
        this.serviceMonitorSelector = serviceMonitorSelector;
        this.sha = sha;
        this.shards = shards;
        this.storage = storage;
        this.tag = tag;
        this.targetLimit = targetLimit;
        this.thanos = thanos;
        this.tolerations = tolerations;
        this.topologySpreadConstraints = topologySpreadConstraints;
        this.tracingConfig = tracingConfig;
        this.tsdb = tsdb;
        this.version = version;
        this.volumeMounts = volumeMounts;
        this.volumes = volumes;
        this.walCompression = walCompression;
        this.web = web;
    }

    @JsonProperty("additionalAlertManagerConfigs")
    public SecretKeySelector getAdditionalAlertManagerConfigs() {
        return additionalAlertManagerConfigs;
    }

    @JsonProperty("additionalAlertManagerConfigs")
    public void setAdditionalAlertManagerConfigs(SecretKeySelector additionalAlertManagerConfigs) {
        this.additionalAlertManagerConfigs = additionalAlertManagerConfigs;
    }

    @JsonProperty("additionalAlertRelabelConfigs")
    public SecretKeySelector getAdditionalAlertRelabelConfigs() {
        return additionalAlertRelabelConfigs;
    }

    @JsonProperty("additionalAlertRelabelConfigs")
    public void setAdditionalAlertRelabelConfigs(SecretKeySelector additionalAlertRelabelConfigs) {
        this.additionalAlertRelabelConfigs = additionalAlertRelabelConfigs;
    }

    @JsonProperty("additionalArgs")
    public List<Argument> getAdditionalArgs() {
        return additionalArgs;
    }

    @JsonProperty("additionalArgs")
    public void setAdditionalArgs(List<Argument> additionalArgs) {
        this.additionalArgs = additionalArgs;
    }

    @JsonProperty("additionalScrapeConfigs")
    public SecretKeySelector getAdditionalScrapeConfigs() {
        return additionalScrapeConfigs;
    }

    @JsonProperty("additionalScrapeConfigs")
    public void setAdditionalScrapeConfigs(SecretKeySelector additionalScrapeConfigs) {
        this.additionalScrapeConfigs = additionalScrapeConfigs;
    }

    @JsonProperty("affinity")
    public Affinity getAffinity() {
        return affinity;
    }

    @JsonProperty("affinity")
    public void setAffinity(Affinity affinity) {
        this.affinity = affinity;
    }

    @JsonProperty("alerting")
    public AlertingSpec getAlerting() {
        return alerting;
    }

    @JsonProperty("alerting")
    public void setAlerting(AlertingSpec alerting) {
        this.alerting = alerting;
    }

    @JsonProperty("allowOverlappingBlocks")
    public Boolean getAllowOverlappingBlocks() {
        return allowOverlappingBlocks;
    }

    @JsonProperty("allowOverlappingBlocks")
    public void setAllowOverlappingBlocks(Boolean allowOverlappingBlocks) {
        this.allowOverlappingBlocks = allowOverlappingBlocks;
    }

    @JsonProperty("apiserverConfig")
    public APIServerConfig getApiserverConfig() {
        return apiserverConfig;
    }

    @JsonProperty("apiserverConfig")
    public void setApiserverConfig(APIServerConfig apiserverConfig) {
        this.apiserverConfig = apiserverConfig;
    }

    @JsonProperty("arbitraryFSAccessThroughSMs")
    public ArbitraryFSAccessThroughSMsConfig getArbitraryFSAccessThroughSMs() {
        return arbitraryFSAccessThroughSMs;
    }

    @JsonProperty("arbitraryFSAccessThroughSMs")
    public void setArbitraryFSAccessThroughSMs(ArbitraryFSAccessThroughSMsConfig arbitraryFSAccessThroughSMs) {
        this.arbitraryFSAccessThroughSMs = arbitraryFSAccessThroughSMs;
    }

    @JsonProperty("baseImage")
    public java.lang.String getBaseImage() {
        return baseImage;
    }

    @JsonProperty("baseImage")
    public void setBaseImage(java.lang.String baseImage) {
        this.baseImage = baseImage;
    }

    @JsonProperty("bodySizeLimit")
    public java.lang.String getBodySizeLimit() {
        return bodySizeLimit;
    }

    @JsonProperty("bodySizeLimit")
    public void setBodySizeLimit(java.lang.String bodySizeLimit) {
        this.bodySizeLimit = bodySizeLimit;
    }

    @JsonProperty("configMaps")
    public List<java.lang.String> getConfigMaps() {
        return configMaps;
    }

    @JsonProperty("configMaps")
    public void setConfigMaps(List<java.lang.String> configMaps) {
        this.configMaps = configMaps;
    }

    @JsonProperty("containers")
    public List<io.fabric8.kubernetes.api.model.Container> getContainers() {
        return containers;
    }

    @JsonProperty("containers")
    public void setContainers(List<io.fabric8.kubernetes.api.model.Container> containers) {
        this.containers = containers;
    }

    @JsonProperty("disableCompaction")
    public Boolean getDisableCompaction() {
        return disableCompaction;
    }

    @JsonProperty("disableCompaction")
    public void setDisableCompaction(Boolean disableCompaction) {
        this.disableCompaction = disableCompaction;
    }

    @JsonProperty("enableAdminAPI")
    public Boolean getEnableAdminAPI() {
        return enableAdminAPI;
    }

    @JsonProperty("enableAdminAPI")
    public void setEnableAdminAPI(Boolean enableAdminAPI) {
        this.enableAdminAPI = enableAdminAPI;
    }

    @JsonProperty("enableFeatures")
    public List<java.lang.String> getEnableFeatures() {
        return enableFeatures;
    }

    @JsonProperty("enableFeatures")
    public void setEnableFeatures(List<java.lang.String> enableFeatures) {
        this.enableFeatures = enableFeatures;
    }

    @JsonProperty("enableRemoteWriteReceiver")
    public Boolean getEnableRemoteWriteReceiver() {
        return enableRemoteWriteReceiver;
    }

    @JsonProperty("enableRemoteWriteReceiver")
    public void setEnableRemoteWriteReceiver(Boolean enableRemoteWriteReceiver) {
        this.enableRemoteWriteReceiver = enableRemoteWriteReceiver;
    }

    @JsonProperty("enforcedBodySizeLimit")
    public java.lang.String getEnforcedBodySizeLimit() {
        return enforcedBodySizeLimit;
    }

    @JsonProperty("enforcedBodySizeLimit")
    public void setEnforcedBodySizeLimit(java.lang.String enforcedBodySizeLimit) {
        this.enforcedBodySizeLimit = enforcedBodySizeLimit;
    }

    @JsonProperty("enforcedKeepDroppedTargets")
    public Long getEnforcedKeepDroppedTargets() {
        return enforcedKeepDroppedTargets;
    }

    @JsonProperty("enforcedKeepDroppedTargets")
    public void setEnforcedKeepDroppedTargets(Long enforcedKeepDroppedTargets) {
        this.enforcedKeepDroppedTargets = enforcedKeepDroppedTargets;
    }

    @JsonProperty("enforcedLabelLimit")
    public Long getEnforcedLabelLimit() {
        return enforcedLabelLimit;
    }

    @JsonProperty("enforcedLabelLimit")
    public void setEnforcedLabelLimit(Long enforcedLabelLimit) {
        this.enforcedLabelLimit = enforcedLabelLimit;
    }

    @JsonProperty("enforcedLabelNameLengthLimit")
    public Long getEnforcedLabelNameLengthLimit() {
        return enforcedLabelNameLengthLimit;
    }

    @JsonProperty("enforcedLabelNameLengthLimit")
    public void setEnforcedLabelNameLengthLimit(Long enforcedLabelNameLengthLimit) {
        this.enforcedLabelNameLengthLimit = enforcedLabelNameLengthLimit;
    }

    @JsonProperty("enforcedLabelValueLengthLimit")
    public Long getEnforcedLabelValueLengthLimit() {
        return enforcedLabelValueLengthLimit;
    }

    @JsonProperty("enforcedLabelValueLengthLimit")
    public void setEnforcedLabelValueLengthLimit(Long enforcedLabelValueLengthLimit) {
        this.enforcedLabelValueLengthLimit = enforcedLabelValueLengthLimit;
    }

    @JsonProperty("enforcedNamespaceLabel")
    public java.lang.String getEnforcedNamespaceLabel() {
        return enforcedNamespaceLabel;
    }

    @JsonProperty("enforcedNamespaceLabel")
    public void setEnforcedNamespaceLabel(java.lang.String enforcedNamespaceLabel) {
        this.enforcedNamespaceLabel = enforcedNamespaceLabel;
    }

    @JsonProperty("enforcedSampleLimit")
    public Long getEnforcedSampleLimit() {
        return enforcedSampleLimit;
    }

    @JsonProperty("enforcedSampleLimit")
    public void setEnforcedSampleLimit(Long enforcedSampleLimit) {
        this.enforcedSampleLimit = enforcedSampleLimit;
    }

    @JsonProperty("enforcedTargetLimit")
    public Long getEnforcedTargetLimit() {
        return enforcedTargetLimit;
    }

    @JsonProperty("enforcedTargetLimit")
    public void setEnforcedTargetLimit(Long enforcedTargetLimit) {
        this.enforcedTargetLimit = enforcedTargetLimit;
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

    @JsonProperty("exemplars")
    public Exemplars getExemplars() {
        return exemplars;
    }

    @JsonProperty("exemplars")
    public void setExemplars(Exemplars exemplars) {
        this.exemplars = exemplars;
    }

    @JsonProperty("externalLabels")
    public Map<String, String> getExternalLabels() {
        return externalLabels;
    }

    @JsonProperty("externalLabels")
    public void setExternalLabels(Map<String, String> externalLabels) {
        this.externalLabels = externalLabels;
    }

    @JsonProperty("externalUrl")
    public java.lang.String getExternalUrl() {
        return externalUrl;
    }

    @JsonProperty("externalUrl")
    public void setExternalUrl(java.lang.String externalUrl) {
        this.externalUrl = externalUrl;
    }

    @JsonProperty("hostAliases")
    public List<HostAlias> getHostAliases() {
        return hostAliases;
    }

    @JsonProperty("hostAliases")
    public void setHostAliases(List<HostAlias> hostAliases) {
        this.hostAliases = hostAliases;
    }

    @JsonProperty("hostNetwork")
    public Boolean getHostNetwork() {
        return hostNetwork;
    }

    @JsonProperty("hostNetwork")
    public void setHostNetwork(Boolean hostNetwork) {
        this.hostNetwork = hostNetwork;
    }

    @JsonProperty("ignoreNamespaceSelectors")
    public Boolean getIgnoreNamespaceSelectors() {
        return ignoreNamespaceSelectors;
    }

    @JsonProperty("ignoreNamespaceSelectors")
    public void setIgnoreNamespaceSelectors(Boolean ignoreNamespaceSelectors) {
        this.ignoreNamespaceSelectors = ignoreNamespaceSelectors;
    }

    @JsonProperty("image")
    public java.lang.String getImage() {
        return image;
    }

    @JsonProperty("image")
    public void setImage(java.lang.String image) {
        this.image = image;
    }

    @JsonProperty("imagePullPolicy")
    public java.lang.String getImagePullPolicy() {
        return imagePullPolicy;
    }

    @JsonProperty("imagePullPolicy")
    public void setImagePullPolicy(java.lang.String imagePullPolicy) {
        this.imagePullPolicy = imagePullPolicy;
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

    @JsonProperty("keepDroppedTargets")
    public Long getKeepDroppedTargets() {
        return keepDroppedTargets;
    }

    @JsonProperty("keepDroppedTargets")
    public void setKeepDroppedTargets(Long keepDroppedTargets) {
        this.keepDroppedTargets = keepDroppedTargets;
    }

    @JsonProperty("labelLimit")
    public Long getLabelLimit() {
        return labelLimit;
    }

    @JsonProperty("labelLimit")
    public void setLabelLimit(Long labelLimit) {
        this.labelLimit = labelLimit;
    }

    @JsonProperty("labelNameLengthLimit")
    public Long getLabelNameLengthLimit() {
        return labelNameLengthLimit;
    }

    @JsonProperty("labelNameLengthLimit")
    public void setLabelNameLengthLimit(Long labelNameLengthLimit) {
        this.labelNameLengthLimit = labelNameLengthLimit;
    }

    @JsonProperty("labelValueLengthLimit")
    public Long getLabelValueLengthLimit() {
        return labelValueLengthLimit;
    }

    @JsonProperty("labelValueLengthLimit")
    public void setLabelValueLengthLimit(Long labelValueLengthLimit) {
        this.labelValueLengthLimit = labelValueLengthLimit;
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

    @JsonProperty("overrideHonorLabels")
    public Boolean getOverrideHonorLabels() {
        return overrideHonorLabels;
    }

    @JsonProperty("overrideHonorLabels")
    public void setOverrideHonorLabels(Boolean overrideHonorLabels) {
        this.overrideHonorLabels = overrideHonorLabels;
    }

    @JsonProperty("overrideHonorTimestamps")
    public Boolean getOverrideHonorTimestamps() {
        return overrideHonorTimestamps;
    }

    @JsonProperty("overrideHonorTimestamps")
    public void setOverrideHonorTimestamps(Boolean overrideHonorTimestamps) {
        this.overrideHonorTimestamps = overrideHonorTimestamps;
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

    @JsonProperty("podMonitorNamespaceSelector")
    public io.fabric8.kubernetes.api.model.LabelSelector getPodMonitorNamespaceSelector() {
        return podMonitorNamespaceSelector;
    }

    @JsonProperty("podMonitorNamespaceSelector")
    public void setPodMonitorNamespaceSelector(io.fabric8.kubernetes.api.model.LabelSelector podMonitorNamespaceSelector) {
        this.podMonitorNamespaceSelector = podMonitorNamespaceSelector;
    }

    @JsonProperty("podMonitorSelector")
    public io.fabric8.kubernetes.api.model.LabelSelector getPodMonitorSelector() {
        return podMonitorSelector;
    }

    @JsonProperty("podMonitorSelector")
    public void setPodMonitorSelector(io.fabric8.kubernetes.api.model.LabelSelector podMonitorSelector) {
        this.podMonitorSelector = podMonitorSelector;
    }

    @JsonProperty("podTargetLabels")
    public List<java.lang.String> getPodTargetLabels() {
        return podTargetLabels;
    }

    @JsonProperty("podTargetLabels")
    public void setPodTargetLabels(List<java.lang.String> podTargetLabels) {
        this.podTargetLabels = podTargetLabels;
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

    @JsonProperty("probeNamespaceSelector")
    public io.fabric8.kubernetes.api.model.LabelSelector getProbeNamespaceSelector() {
        return probeNamespaceSelector;
    }

    @JsonProperty("probeNamespaceSelector")
    public void setProbeNamespaceSelector(io.fabric8.kubernetes.api.model.LabelSelector probeNamespaceSelector) {
        this.probeNamespaceSelector = probeNamespaceSelector;
    }

    @JsonProperty("probeSelector")
    public io.fabric8.kubernetes.api.model.LabelSelector getProbeSelector() {
        return probeSelector;
    }

    @JsonProperty("probeSelector")
    public void setProbeSelector(io.fabric8.kubernetes.api.model.LabelSelector probeSelector) {
        this.probeSelector = probeSelector;
    }

    @JsonProperty("prometheusExternalLabelName")
    public java.lang.String getPrometheusExternalLabelName() {
        return prometheusExternalLabelName;
    }

    @JsonProperty("prometheusExternalLabelName")
    public void setPrometheusExternalLabelName(java.lang.String prometheusExternalLabelName) {
        this.prometheusExternalLabelName = prometheusExternalLabelName;
    }

    @JsonProperty("prometheusRulesExcludedFromEnforce")
    public List<PrometheusRuleExcludeConfig> getPrometheusRulesExcludedFromEnforce() {
        return prometheusRulesExcludedFromEnforce;
    }

    @JsonProperty("prometheusRulesExcludedFromEnforce")
    public void setPrometheusRulesExcludedFromEnforce(List<PrometheusRuleExcludeConfig> prometheusRulesExcludedFromEnforce) {
        this.prometheusRulesExcludedFromEnforce = prometheusRulesExcludedFromEnforce;
    }

    @JsonProperty("query")
    public QuerySpec getQuery() {
        return query;
    }

    @JsonProperty("query")
    public void setQuery(QuerySpec query) {
        this.query = query;
    }

    @JsonProperty("queryLogFile")
    public java.lang.String getQueryLogFile() {
        return queryLogFile;
    }

    @JsonProperty("queryLogFile")
    public void setQueryLogFile(java.lang.String queryLogFile) {
        this.queryLogFile = queryLogFile;
    }

    @JsonProperty("remoteRead")
    public List<RemoteReadSpec> getRemoteRead() {
        return remoteRead;
    }

    @JsonProperty("remoteRead")
    public void setRemoteRead(List<RemoteReadSpec> remoteRead) {
        this.remoteRead = remoteRead;
    }

    @JsonProperty("remoteWrite")
    public List<RemoteWriteSpec> getRemoteWrite() {
        return remoteWrite;
    }

    @JsonProperty("remoteWrite")
    public void setRemoteWrite(List<RemoteWriteSpec> remoteWrite) {
        this.remoteWrite = remoteWrite;
    }

    @JsonProperty("replicaExternalLabelName")
    public java.lang.String getReplicaExternalLabelName() {
        return replicaExternalLabelName;
    }

    @JsonProperty("replicaExternalLabelName")
    public void setReplicaExternalLabelName(java.lang.String replicaExternalLabelName) {
        this.replicaExternalLabelName = replicaExternalLabelName;
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

    @JsonProperty("retentionSize")
    public java.lang.String getRetentionSize() {
        return retentionSize;
    }

    @JsonProperty("retentionSize")
    public void setRetentionSize(java.lang.String retentionSize) {
        this.retentionSize = retentionSize;
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

    @JsonProperty("rules")
    public Rules getRules() {
        return rules;
    }

    @JsonProperty("rules")
    public void setRules(Rules rules) {
        this.rules = rules;
    }

    @JsonProperty("sampleLimit")
    public Long getSampleLimit() {
        return sampleLimit;
    }

    @JsonProperty("sampleLimit")
    public void setSampleLimit(Long sampleLimit) {
        this.sampleLimit = sampleLimit;
    }

    @JsonProperty("scrapeConfigNamespaceSelector")
    public io.fabric8.kubernetes.api.model.LabelSelector getScrapeConfigNamespaceSelector() {
        return scrapeConfigNamespaceSelector;
    }

    @JsonProperty("scrapeConfigNamespaceSelector")
    public void setScrapeConfigNamespaceSelector(io.fabric8.kubernetes.api.model.LabelSelector scrapeConfigNamespaceSelector) {
        this.scrapeConfigNamespaceSelector = scrapeConfigNamespaceSelector;
    }

    @JsonProperty("scrapeConfigSelector")
    public io.fabric8.kubernetes.api.model.LabelSelector getScrapeConfigSelector() {
        return scrapeConfigSelector;
    }

    @JsonProperty("scrapeConfigSelector")
    public void setScrapeConfigSelector(io.fabric8.kubernetes.api.model.LabelSelector scrapeConfigSelector) {
        this.scrapeConfigSelector = scrapeConfigSelector;
    }

    @JsonProperty("scrapeInterval")
    public java.lang.String getScrapeInterval() {
        return scrapeInterval;
    }

    @JsonProperty("scrapeInterval")
    public void setScrapeInterval(java.lang.String scrapeInterval) {
        this.scrapeInterval = scrapeInterval;
    }

    @JsonProperty("scrapeTimeout")
    public java.lang.String getScrapeTimeout() {
        return scrapeTimeout;
    }

    @JsonProperty("scrapeTimeout")
    public void setScrapeTimeout(java.lang.String scrapeTimeout) {
        this.scrapeTimeout = scrapeTimeout;
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

    @JsonProperty("serviceMonitorNamespaceSelector")
    public io.fabric8.kubernetes.api.model.LabelSelector getServiceMonitorNamespaceSelector() {
        return serviceMonitorNamespaceSelector;
    }

    @JsonProperty("serviceMonitorNamespaceSelector")
    public void setServiceMonitorNamespaceSelector(io.fabric8.kubernetes.api.model.LabelSelector serviceMonitorNamespaceSelector) {
        this.serviceMonitorNamespaceSelector = serviceMonitorNamespaceSelector;
    }

    @JsonProperty("serviceMonitorSelector")
    public io.fabric8.kubernetes.api.model.LabelSelector getServiceMonitorSelector() {
        return serviceMonitorSelector;
    }

    @JsonProperty("serviceMonitorSelector")
    public void setServiceMonitorSelector(io.fabric8.kubernetes.api.model.LabelSelector serviceMonitorSelector) {
        this.serviceMonitorSelector = serviceMonitorSelector;
    }

    @JsonProperty("sha")
    public java.lang.String getSha() {
        return sha;
    }

    @JsonProperty("sha")
    public void setSha(java.lang.String sha) {
        this.sha = sha;
    }

    @JsonProperty("shards")
    public Integer getShards() {
        return shards;
    }

    @JsonProperty("shards")
    public void setShards(Integer shards) {
        this.shards = shards;
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

    @JsonProperty("targetLimit")
    public Long getTargetLimit() {
        return targetLimit;
    }

    @JsonProperty("targetLimit")
    public void setTargetLimit(Long targetLimit) {
        this.targetLimit = targetLimit;
    }

    @JsonProperty("thanos")
    public ThanosSpec getThanos() {
        return thanos;
    }

    @JsonProperty("thanos")
    public void setThanos(ThanosSpec thanos) {
        this.thanos = thanos;
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
    public PrometheusTracingConfig getTracingConfig() {
        return tracingConfig;
    }

    @JsonProperty("tracingConfig")
    public void setTracingConfig(PrometheusTracingConfig tracingConfig) {
        this.tracingConfig = tracingConfig;
    }

    @JsonProperty("tsdb")
    public TSDBSpec getTsdb() {
        return tsdb;
    }

    @JsonProperty("tsdb")
    public void setTsdb(TSDBSpec tsdb) {
        this.tsdb = tsdb;
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

    @JsonProperty("walCompression")
    public Boolean getWalCompression() {
        return walCompression;
    }

    @JsonProperty("walCompression")
    public void setWalCompression(Boolean walCompression) {
        this.walCompression = walCompression;
    }

    @JsonProperty("web")
    public PrometheusWebSpec getWeb() {
        return web;
    }

    @JsonProperty("web")
    public void setWeb(PrometheusWebSpec web) {
        this.web = web;
    }

    @JsonIgnore
    public PrometheusSpecBuilder edit() {
        return new PrometheusSpecBuilder(this);
    }

    @JsonIgnore
    public PrometheusSpecBuilder toBuilder() {
        return edit();
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
