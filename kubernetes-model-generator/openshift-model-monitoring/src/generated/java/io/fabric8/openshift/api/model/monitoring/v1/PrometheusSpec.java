
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
    "maximumStartupDurationSeconds",
    "minReadySeconds",
    "nodeSelector",
    "overrideHonorLabels",
    "overrideHonorTimestamps",
    "paused",
    "persistentVolumeClaimRetentionPolicy",
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
    "reloadStrategy",
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
    "scrapeClasses",
    "scrapeConfigNamespaceSelector",
    "scrapeConfigSelector",
    "scrapeInterval",
    "scrapeProtocols",
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
public class PrometheusSpec implements Editable<PrometheusSpecBuilder> , KubernetesResource
{

    @JsonProperty("additionalAlertManagerConfigs")
    private PrometheusSpecAdditionalAlertManagerConfigs additionalAlertManagerConfigs;
    @JsonProperty("additionalAlertRelabelConfigs")
    private PrometheusSpecAdditionalAlertRelabelConfigs additionalAlertRelabelConfigs;
    @JsonProperty("additionalArgs")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<PrometheusSpecAdditionalArgs> additionalArgs = new ArrayList<>();
    @JsonProperty("additionalScrapeConfigs")
    private PrometheusSpecAdditionalScrapeConfigs additionalScrapeConfigs;
    @JsonProperty("affinity")
    private PrometheusSpecAffinity affinity;
    @JsonProperty("alerting")
    private PrometheusSpecAlerting alerting;
    @JsonProperty("allowOverlappingBlocks")
    private Boolean allowOverlappingBlocks;
    @JsonProperty("apiserverConfig")
    private PrometheusSpecApiserverConfig apiserverConfig;
    @JsonProperty("arbitraryFSAccessThroughSMs")
    private PrometheusSpecArbitraryFSAccessThroughSMs arbitraryFSAccessThroughSMs;
    @JsonProperty("baseImage")
    private String baseImage;
    @JsonProperty("bodySizeLimit")
    private String bodySizeLimit;
    @JsonProperty("configMaps")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> configMaps = new ArrayList<>();
    @JsonProperty("containers")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<PrometheusSpecContainers> containers = new ArrayList<>();
    @JsonProperty("disableCompaction")
    private Boolean disableCompaction;
    @JsonProperty("enableAdminAPI")
    private Boolean enableAdminAPI;
    @JsonProperty("enableFeatures")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> enableFeatures = new ArrayList<>();
    @JsonProperty("enableRemoteWriteReceiver")
    private Boolean enableRemoteWriteReceiver;
    @JsonProperty("enforcedBodySizeLimit")
    private String enforcedBodySizeLimit;
    @JsonProperty("enforcedKeepDroppedTargets")
    private Long enforcedKeepDroppedTargets;
    @JsonProperty("enforcedLabelLimit")
    private Long enforcedLabelLimit;
    @JsonProperty("enforcedLabelNameLengthLimit")
    private Long enforcedLabelNameLengthLimit;
    @JsonProperty("enforcedLabelValueLengthLimit")
    private Long enforcedLabelValueLengthLimit;
    @JsonProperty("enforcedNamespaceLabel")
    private String enforcedNamespaceLabel;
    @JsonProperty("enforcedSampleLimit")
    private Long enforcedSampleLimit;
    @JsonProperty("enforcedTargetLimit")
    private Long enforcedTargetLimit;
    @JsonProperty("evaluationInterval")
    private String evaluationInterval;
    @JsonProperty("excludedFromEnforcement")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<PrometheusSpecExcludedFromEnforcement> excludedFromEnforcement = new ArrayList<>();
    @JsonProperty("exemplars")
    private PrometheusSpecExemplars exemplars;
    @JsonProperty("externalLabels")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Map<String, String> externalLabels = new LinkedHashMap<>();
    @JsonProperty("externalUrl")
    private String externalUrl;
    @JsonProperty("hostAliases")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<PrometheusSpecHostAliases> hostAliases = new ArrayList<>();
    @JsonProperty("hostNetwork")
    private Boolean hostNetwork;
    @JsonProperty("ignoreNamespaceSelectors")
    private Boolean ignoreNamespaceSelectors;
    @JsonProperty("image")
    private String image;
    @JsonProperty("imagePullPolicy")
    private String imagePullPolicy;
    @JsonProperty("imagePullSecrets")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<PrometheusSpecImagePullSecrets> imagePullSecrets = new ArrayList<>();
    @JsonProperty("initContainers")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<PrometheusSpecInitContainers> initContainers = new ArrayList<>();
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
    private String logFormat;
    @JsonProperty("logLevel")
    private String logLevel;
    @JsonProperty("maximumStartupDurationSeconds")
    private Integer maximumStartupDurationSeconds;
    @JsonProperty("minReadySeconds")
    private Integer minReadySeconds;
    @JsonProperty("nodeSelector")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Map<String, String> nodeSelector = new LinkedHashMap<>();
    @JsonProperty("overrideHonorLabels")
    private Boolean overrideHonorLabels;
    @JsonProperty("overrideHonorTimestamps")
    private Boolean overrideHonorTimestamps;
    @JsonProperty("paused")
    private Boolean paused;
    @JsonProperty("persistentVolumeClaimRetentionPolicy")
    private PrometheusSpecPersistentVolumeClaimRetentionPolicy persistentVolumeClaimRetentionPolicy;
    @JsonProperty("podMetadata")
    private PrometheusSpecPodMetadata podMetadata;
    @JsonProperty("podMonitorNamespaceSelector")
    private PrometheusSpecPodMonitorNamespaceSelector podMonitorNamespaceSelector;
    @JsonProperty("podMonitorSelector")
    private PrometheusSpecPodMonitorSelector podMonitorSelector;
    @JsonProperty("podTargetLabels")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> podTargetLabels = new ArrayList<>();
    @JsonProperty("portName")
    private String portName;
    @JsonProperty("priorityClassName")
    private String priorityClassName;
    @JsonProperty("probeNamespaceSelector")
    private PrometheusSpecProbeNamespaceSelector probeNamespaceSelector;
    @JsonProperty("probeSelector")
    private PrometheusSpecProbeSelector probeSelector;
    @JsonProperty("prometheusExternalLabelName")
    private String prometheusExternalLabelName;
    @JsonProperty("prometheusRulesExcludedFromEnforce")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<PrometheusSpecPrometheusRulesExcludedFromEnforce> prometheusRulesExcludedFromEnforce = new ArrayList<>();
    @JsonProperty("query")
    private PrometheusSpecQuery query;
    @JsonProperty("queryLogFile")
    private String queryLogFile;
    @JsonProperty("reloadStrategy")
    private String reloadStrategy;
    @JsonProperty("remoteRead")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<PrometheusSpecRemoteRead> remoteRead = new ArrayList<>();
    @JsonProperty("remoteWrite")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<PrometheusSpecRemoteWrite> remoteWrite = new ArrayList<>();
    @JsonProperty("replicaExternalLabelName")
    private String replicaExternalLabelName;
    @JsonProperty("replicas")
    private Integer replicas;
    @JsonProperty("resources")
    private PrometheusSpecResources resources;
    @JsonProperty("retention")
    private String retention;
    @JsonProperty("retentionSize")
    private String retentionSize;
    @JsonProperty("routePrefix")
    private String routePrefix;
    @JsonProperty("ruleNamespaceSelector")
    private PrometheusSpecRuleNamespaceSelector ruleNamespaceSelector;
    @JsonProperty("ruleSelector")
    private PrometheusSpecRuleSelector ruleSelector;
    @JsonProperty("rules")
    private PrometheusSpecRules rules;
    @JsonProperty("sampleLimit")
    private Long sampleLimit;
    @JsonProperty("scrapeClasses")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<PrometheusSpecScrapeClasses> scrapeClasses = new ArrayList<>();
    @JsonProperty("scrapeConfigNamespaceSelector")
    private PrometheusSpecScrapeConfigNamespaceSelector scrapeConfigNamespaceSelector;
    @JsonProperty("scrapeConfigSelector")
    private PrometheusSpecScrapeConfigSelector scrapeConfigSelector;
    @JsonProperty("scrapeInterval")
    private String scrapeInterval;
    @JsonProperty("scrapeProtocols")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> scrapeProtocols = new ArrayList<>();
    @JsonProperty("scrapeTimeout")
    private String scrapeTimeout;
    @JsonProperty("secrets")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> secrets = new ArrayList<>();
    @JsonProperty("securityContext")
    private PrometheusSpecSecurityContext securityContext;
    @JsonProperty("serviceAccountName")
    private String serviceAccountName;
    @JsonProperty("serviceMonitorNamespaceSelector")
    private PrometheusSpecServiceMonitorNamespaceSelector serviceMonitorNamespaceSelector;
    @JsonProperty("serviceMonitorSelector")
    private PrometheusSpecServiceMonitorSelector serviceMonitorSelector;
    @JsonProperty("sha")
    private String sha;
    @JsonProperty("shards")
    private Integer shards;
    @JsonProperty("storage")
    private PrometheusSpecStorage storage;
    @JsonProperty("tag")
    private String tag;
    @JsonProperty("targetLimit")
    private Long targetLimit;
    @JsonProperty("thanos")
    private PrometheusSpecThanos thanos;
    @JsonProperty("tolerations")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<PrometheusSpecTolerations> tolerations = new ArrayList<>();
    @JsonProperty("topologySpreadConstraints")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<PrometheusSpecTopologySpreadConstraints> topologySpreadConstraints = new ArrayList<>();
    @JsonProperty("tracingConfig")
    private PrometheusSpecTracingConfig tracingConfig;
    @JsonProperty("tsdb")
    private PrometheusSpecTsdb tsdb;
    @JsonProperty("version")
    private String version;
    @JsonProperty("volumeMounts")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<PrometheusSpecVolumeMounts> volumeMounts = new ArrayList<>();
    @JsonProperty("volumes")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<PrometheusSpecVolumes> volumes = new ArrayList<>();
    @JsonProperty("walCompression")
    private Boolean walCompression;
    @JsonProperty("web")
    private PrometheusSpecWeb web;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public PrometheusSpec() {
    }

    public PrometheusSpec(PrometheusSpecAdditionalAlertManagerConfigs additionalAlertManagerConfigs, PrometheusSpecAdditionalAlertRelabelConfigs additionalAlertRelabelConfigs, List<PrometheusSpecAdditionalArgs> additionalArgs, PrometheusSpecAdditionalScrapeConfigs additionalScrapeConfigs, PrometheusSpecAffinity affinity, PrometheusSpecAlerting alerting, Boolean allowOverlappingBlocks, PrometheusSpecApiserverConfig apiserverConfig, PrometheusSpecArbitraryFSAccessThroughSMs arbitraryFSAccessThroughSMs, String baseImage, String bodySizeLimit, List<String> configMaps, List<PrometheusSpecContainers> containers, Boolean disableCompaction, Boolean enableAdminAPI, List<String> enableFeatures, Boolean enableRemoteWriteReceiver, String enforcedBodySizeLimit, Long enforcedKeepDroppedTargets, Long enforcedLabelLimit, Long enforcedLabelNameLengthLimit, Long enforcedLabelValueLengthLimit, String enforcedNamespaceLabel, Long enforcedSampleLimit, Long enforcedTargetLimit, String evaluationInterval, List<PrometheusSpecExcludedFromEnforcement> excludedFromEnforcement, PrometheusSpecExemplars exemplars, Map<String, String> externalLabels, String externalUrl, List<PrometheusSpecHostAliases> hostAliases, Boolean hostNetwork, Boolean ignoreNamespaceSelectors, String image, String imagePullPolicy, List<PrometheusSpecImagePullSecrets> imagePullSecrets, List<PrometheusSpecInitContainers> initContainers, Long keepDroppedTargets, Long labelLimit, Long labelNameLengthLimit, Long labelValueLengthLimit, Boolean listenLocal, String logFormat, String logLevel, Integer maximumStartupDurationSeconds, Integer minReadySeconds, Map<String, String> nodeSelector, Boolean overrideHonorLabels, Boolean overrideHonorTimestamps, Boolean paused, PrometheusSpecPersistentVolumeClaimRetentionPolicy persistentVolumeClaimRetentionPolicy, PrometheusSpecPodMetadata podMetadata, PrometheusSpecPodMonitorNamespaceSelector podMonitorNamespaceSelector, PrometheusSpecPodMonitorSelector podMonitorSelector, List<String> podTargetLabels, String portName, String priorityClassName, PrometheusSpecProbeNamespaceSelector probeNamespaceSelector, PrometheusSpecProbeSelector probeSelector, String prometheusExternalLabelName, List<PrometheusSpecPrometheusRulesExcludedFromEnforce> prometheusRulesExcludedFromEnforce, PrometheusSpecQuery query, String queryLogFile, String reloadStrategy, List<PrometheusSpecRemoteRead> remoteRead, List<PrometheusSpecRemoteWrite> remoteWrite, String replicaExternalLabelName, Integer replicas, PrometheusSpecResources resources, String retention, String retentionSize, String routePrefix, PrometheusSpecRuleNamespaceSelector ruleNamespaceSelector, PrometheusSpecRuleSelector ruleSelector, PrometheusSpecRules rules, Long sampleLimit, List<PrometheusSpecScrapeClasses> scrapeClasses, PrometheusSpecScrapeConfigNamespaceSelector scrapeConfigNamespaceSelector, PrometheusSpecScrapeConfigSelector scrapeConfigSelector, String scrapeInterval, List<String> scrapeProtocols, String scrapeTimeout, List<String> secrets, PrometheusSpecSecurityContext securityContext, String serviceAccountName, PrometheusSpecServiceMonitorNamespaceSelector serviceMonitorNamespaceSelector, PrometheusSpecServiceMonitorSelector serviceMonitorSelector, String sha, Integer shards, PrometheusSpecStorage storage, String tag, Long targetLimit, PrometheusSpecThanos thanos, List<PrometheusSpecTolerations> tolerations, List<PrometheusSpecTopologySpreadConstraints> topologySpreadConstraints, PrometheusSpecTracingConfig tracingConfig, PrometheusSpecTsdb tsdb, String version, List<PrometheusSpecVolumeMounts> volumeMounts, List<PrometheusSpecVolumes> volumes, Boolean walCompression, PrometheusSpecWeb web) {
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
        this.maximumStartupDurationSeconds = maximumStartupDurationSeconds;
        this.minReadySeconds = minReadySeconds;
        this.nodeSelector = nodeSelector;
        this.overrideHonorLabels = overrideHonorLabels;
        this.overrideHonorTimestamps = overrideHonorTimestamps;
        this.paused = paused;
        this.persistentVolumeClaimRetentionPolicy = persistentVolumeClaimRetentionPolicy;
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
        this.reloadStrategy = reloadStrategy;
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
        this.scrapeClasses = scrapeClasses;
        this.scrapeConfigNamespaceSelector = scrapeConfigNamespaceSelector;
        this.scrapeConfigSelector = scrapeConfigSelector;
        this.scrapeInterval = scrapeInterval;
        this.scrapeProtocols = scrapeProtocols;
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
    public PrometheusSpecAdditionalAlertManagerConfigs getAdditionalAlertManagerConfigs() {
        return additionalAlertManagerConfigs;
    }

    @JsonProperty("additionalAlertManagerConfigs")
    public void setAdditionalAlertManagerConfigs(PrometheusSpecAdditionalAlertManagerConfigs additionalAlertManagerConfigs) {
        this.additionalAlertManagerConfigs = additionalAlertManagerConfigs;
    }

    @JsonProperty("additionalAlertRelabelConfigs")
    public PrometheusSpecAdditionalAlertRelabelConfigs getAdditionalAlertRelabelConfigs() {
        return additionalAlertRelabelConfigs;
    }

    @JsonProperty("additionalAlertRelabelConfigs")
    public void setAdditionalAlertRelabelConfigs(PrometheusSpecAdditionalAlertRelabelConfigs additionalAlertRelabelConfigs) {
        this.additionalAlertRelabelConfigs = additionalAlertRelabelConfigs;
    }

    @JsonProperty("additionalArgs")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<PrometheusSpecAdditionalArgs> getAdditionalArgs() {
        return additionalArgs;
    }

    @JsonProperty("additionalArgs")
    public void setAdditionalArgs(List<PrometheusSpecAdditionalArgs> additionalArgs) {
        this.additionalArgs = additionalArgs;
    }

    @JsonProperty("additionalScrapeConfigs")
    public PrometheusSpecAdditionalScrapeConfigs getAdditionalScrapeConfigs() {
        return additionalScrapeConfigs;
    }

    @JsonProperty("additionalScrapeConfigs")
    public void setAdditionalScrapeConfigs(PrometheusSpecAdditionalScrapeConfigs additionalScrapeConfigs) {
        this.additionalScrapeConfigs = additionalScrapeConfigs;
    }

    @JsonProperty("affinity")
    public PrometheusSpecAffinity getAffinity() {
        return affinity;
    }

    @JsonProperty("affinity")
    public void setAffinity(PrometheusSpecAffinity affinity) {
        this.affinity = affinity;
    }

    @JsonProperty("alerting")
    public PrometheusSpecAlerting getAlerting() {
        return alerting;
    }

    @JsonProperty("alerting")
    public void setAlerting(PrometheusSpecAlerting alerting) {
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
    public PrometheusSpecApiserverConfig getApiserverConfig() {
        return apiserverConfig;
    }

    @JsonProperty("apiserverConfig")
    public void setApiserverConfig(PrometheusSpecApiserverConfig apiserverConfig) {
        this.apiserverConfig = apiserverConfig;
    }

    @JsonProperty("arbitraryFSAccessThroughSMs")
    public PrometheusSpecArbitraryFSAccessThroughSMs getArbitraryFSAccessThroughSMs() {
        return arbitraryFSAccessThroughSMs;
    }

    @JsonProperty("arbitraryFSAccessThroughSMs")
    public void setArbitraryFSAccessThroughSMs(PrometheusSpecArbitraryFSAccessThroughSMs arbitraryFSAccessThroughSMs) {
        this.arbitraryFSAccessThroughSMs = arbitraryFSAccessThroughSMs;
    }

    @JsonProperty("baseImage")
    public String getBaseImage() {
        return baseImage;
    }

    @JsonProperty("baseImage")
    public void setBaseImage(String baseImage) {
        this.baseImage = baseImage;
    }

    @JsonProperty("bodySizeLimit")
    public String getBodySizeLimit() {
        return bodySizeLimit;
    }

    @JsonProperty("bodySizeLimit")
    public void setBodySizeLimit(String bodySizeLimit) {
        this.bodySizeLimit = bodySizeLimit;
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

    @JsonProperty("containers")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<PrometheusSpecContainers> getContainers() {
        return containers;
    }

    @JsonProperty("containers")
    public void setContainers(List<PrometheusSpecContainers> containers) {
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
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getEnableFeatures() {
        return enableFeatures;
    }

    @JsonProperty("enableFeatures")
    public void setEnableFeatures(List<String> enableFeatures) {
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
    public String getEnforcedBodySizeLimit() {
        return enforcedBodySizeLimit;
    }

    @JsonProperty("enforcedBodySizeLimit")
    public void setEnforcedBodySizeLimit(String enforcedBodySizeLimit) {
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
    public String getEnforcedNamespaceLabel() {
        return enforcedNamespaceLabel;
    }

    @JsonProperty("enforcedNamespaceLabel")
    public void setEnforcedNamespaceLabel(String enforcedNamespaceLabel) {
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
    public String getEvaluationInterval() {
        return evaluationInterval;
    }

    @JsonProperty("evaluationInterval")
    public void setEvaluationInterval(String evaluationInterval) {
        this.evaluationInterval = evaluationInterval;
    }

    @JsonProperty("excludedFromEnforcement")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<PrometheusSpecExcludedFromEnforcement> getExcludedFromEnforcement() {
        return excludedFromEnforcement;
    }

    @JsonProperty("excludedFromEnforcement")
    public void setExcludedFromEnforcement(List<PrometheusSpecExcludedFromEnforcement> excludedFromEnforcement) {
        this.excludedFromEnforcement = excludedFromEnforcement;
    }

    @JsonProperty("exemplars")
    public PrometheusSpecExemplars getExemplars() {
        return exemplars;
    }

    @JsonProperty("exemplars")
    public void setExemplars(PrometheusSpecExemplars exemplars) {
        this.exemplars = exemplars;
    }

    @JsonProperty("externalLabels")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public Map<String, String> getExternalLabels() {
        return externalLabels;
    }

    @JsonProperty("externalLabels")
    public void setExternalLabels(Map<String, String> externalLabels) {
        this.externalLabels = externalLabels;
    }

    @JsonProperty("externalUrl")
    public String getExternalUrl() {
        return externalUrl;
    }

    @JsonProperty("externalUrl")
    public void setExternalUrl(String externalUrl) {
        this.externalUrl = externalUrl;
    }

    @JsonProperty("hostAliases")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<PrometheusSpecHostAliases> getHostAliases() {
        return hostAliases;
    }

    @JsonProperty("hostAliases")
    public void setHostAliases(List<PrometheusSpecHostAliases> hostAliases) {
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
    public List<PrometheusSpecImagePullSecrets> getImagePullSecrets() {
        return imagePullSecrets;
    }

    @JsonProperty("imagePullSecrets")
    public void setImagePullSecrets(List<PrometheusSpecImagePullSecrets> imagePullSecrets) {
        this.imagePullSecrets = imagePullSecrets;
    }

    @JsonProperty("initContainers")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<PrometheusSpecInitContainers> getInitContainers() {
        return initContainers;
    }

    @JsonProperty("initContainers")
    public void setInitContainers(List<PrometheusSpecInitContainers> initContainers) {
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

    @JsonProperty("maximumStartupDurationSeconds")
    public Integer getMaximumStartupDurationSeconds() {
        return maximumStartupDurationSeconds;
    }

    @JsonProperty("maximumStartupDurationSeconds")
    public void setMaximumStartupDurationSeconds(Integer maximumStartupDurationSeconds) {
        this.maximumStartupDurationSeconds = maximumStartupDurationSeconds;
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

    @JsonProperty("persistentVolumeClaimRetentionPolicy")
    public PrometheusSpecPersistentVolumeClaimRetentionPolicy getPersistentVolumeClaimRetentionPolicy() {
        return persistentVolumeClaimRetentionPolicy;
    }

    @JsonProperty("persistentVolumeClaimRetentionPolicy")
    public void setPersistentVolumeClaimRetentionPolicy(PrometheusSpecPersistentVolumeClaimRetentionPolicy persistentVolumeClaimRetentionPolicy) {
        this.persistentVolumeClaimRetentionPolicy = persistentVolumeClaimRetentionPolicy;
    }

    @JsonProperty("podMetadata")
    public PrometheusSpecPodMetadata getPodMetadata() {
        return podMetadata;
    }

    @JsonProperty("podMetadata")
    public void setPodMetadata(PrometheusSpecPodMetadata podMetadata) {
        this.podMetadata = podMetadata;
    }

    @JsonProperty("podMonitorNamespaceSelector")
    public PrometheusSpecPodMonitorNamespaceSelector getPodMonitorNamespaceSelector() {
        return podMonitorNamespaceSelector;
    }

    @JsonProperty("podMonitorNamespaceSelector")
    public void setPodMonitorNamespaceSelector(PrometheusSpecPodMonitorNamespaceSelector podMonitorNamespaceSelector) {
        this.podMonitorNamespaceSelector = podMonitorNamespaceSelector;
    }

    @JsonProperty("podMonitorSelector")
    public PrometheusSpecPodMonitorSelector getPodMonitorSelector() {
        return podMonitorSelector;
    }

    @JsonProperty("podMonitorSelector")
    public void setPodMonitorSelector(PrometheusSpecPodMonitorSelector podMonitorSelector) {
        this.podMonitorSelector = podMonitorSelector;
    }

    @JsonProperty("podTargetLabels")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getPodTargetLabels() {
        return podTargetLabels;
    }

    @JsonProperty("podTargetLabels")
    public void setPodTargetLabels(List<String> podTargetLabels) {
        this.podTargetLabels = podTargetLabels;
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

    @JsonProperty("probeNamespaceSelector")
    public PrometheusSpecProbeNamespaceSelector getProbeNamespaceSelector() {
        return probeNamespaceSelector;
    }

    @JsonProperty("probeNamespaceSelector")
    public void setProbeNamespaceSelector(PrometheusSpecProbeNamespaceSelector probeNamespaceSelector) {
        this.probeNamespaceSelector = probeNamespaceSelector;
    }

    @JsonProperty("probeSelector")
    public PrometheusSpecProbeSelector getProbeSelector() {
        return probeSelector;
    }

    @JsonProperty("probeSelector")
    public void setProbeSelector(PrometheusSpecProbeSelector probeSelector) {
        this.probeSelector = probeSelector;
    }

    @JsonProperty("prometheusExternalLabelName")
    public String getPrometheusExternalLabelName() {
        return prometheusExternalLabelName;
    }

    @JsonProperty("prometheusExternalLabelName")
    public void setPrometheusExternalLabelName(String prometheusExternalLabelName) {
        this.prometheusExternalLabelName = prometheusExternalLabelName;
    }

    @JsonProperty("prometheusRulesExcludedFromEnforce")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<PrometheusSpecPrometheusRulesExcludedFromEnforce> getPrometheusRulesExcludedFromEnforce() {
        return prometheusRulesExcludedFromEnforce;
    }

    @JsonProperty("prometheusRulesExcludedFromEnforce")
    public void setPrometheusRulesExcludedFromEnforce(List<PrometheusSpecPrometheusRulesExcludedFromEnforce> prometheusRulesExcludedFromEnforce) {
        this.prometheusRulesExcludedFromEnforce = prometheusRulesExcludedFromEnforce;
    }

    @JsonProperty("query")
    public PrometheusSpecQuery getQuery() {
        return query;
    }

    @JsonProperty("query")
    public void setQuery(PrometheusSpecQuery query) {
        this.query = query;
    }

    @JsonProperty("queryLogFile")
    public String getQueryLogFile() {
        return queryLogFile;
    }

    @JsonProperty("queryLogFile")
    public void setQueryLogFile(String queryLogFile) {
        this.queryLogFile = queryLogFile;
    }

    @JsonProperty("reloadStrategy")
    public String getReloadStrategy() {
        return reloadStrategy;
    }

    @JsonProperty("reloadStrategy")
    public void setReloadStrategy(String reloadStrategy) {
        this.reloadStrategy = reloadStrategy;
    }

    @JsonProperty("remoteRead")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<PrometheusSpecRemoteRead> getRemoteRead() {
        return remoteRead;
    }

    @JsonProperty("remoteRead")
    public void setRemoteRead(List<PrometheusSpecRemoteRead> remoteRead) {
        this.remoteRead = remoteRead;
    }

    @JsonProperty("remoteWrite")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<PrometheusSpecRemoteWrite> getRemoteWrite() {
        return remoteWrite;
    }

    @JsonProperty("remoteWrite")
    public void setRemoteWrite(List<PrometheusSpecRemoteWrite> remoteWrite) {
        this.remoteWrite = remoteWrite;
    }

    @JsonProperty("replicaExternalLabelName")
    public String getReplicaExternalLabelName() {
        return replicaExternalLabelName;
    }

    @JsonProperty("replicaExternalLabelName")
    public void setReplicaExternalLabelName(String replicaExternalLabelName) {
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
    public PrometheusSpecResources getResources() {
        return resources;
    }

    @JsonProperty("resources")
    public void setResources(PrometheusSpecResources resources) {
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

    @JsonProperty("retentionSize")
    public String getRetentionSize() {
        return retentionSize;
    }

    @JsonProperty("retentionSize")
    public void setRetentionSize(String retentionSize) {
        this.retentionSize = retentionSize;
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
    public PrometheusSpecRuleNamespaceSelector getRuleNamespaceSelector() {
        return ruleNamespaceSelector;
    }

    @JsonProperty("ruleNamespaceSelector")
    public void setRuleNamespaceSelector(PrometheusSpecRuleNamespaceSelector ruleNamespaceSelector) {
        this.ruleNamespaceSelector = ruleNamespaceSelector;
    }

    @JsonProperty("ruleSelector")
    public PrometheusSpecRuleSelector getRuleSelector() {
        return ruleSelector;
    }

    @JsonProperty("ruleSelector")
    public void setRuleSelector(PrometheusSpecRuleSelector ruleSelector) {
        this.ruleSelector = ruleSelector;
    }

    @JsonProperty("rules")
    public PrometheusSpecRules getRules() {
        return rules;
    }

    @JsonProperty("rules")
    public void setRules(PrometheusSpecRules rules) {
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

    @JsonProperty("scrapeClasses")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<PrometheusSpecScrapeClasses> getScrapeClasses() {
        return scrapeClasses;
    }

    @JsonProperty("scrapeClasses")
    public void setScrapeClasses(List<PrometheusSpecScrapeClasses> scrapeClasses) {
        this.scrapeClasses = scrapeClasses;
    }

    @JsonProperty("scrapeConfigNamespaceSelector")
    public PrometheusSpecScrapeConfigNamespaceSelector getScrapeConfigNamespaceSelector() {
        return scrapeConfigNamespaceSelector;
    }

    @JsonProperty("scrapeConfigNamespaceSelector")
    public void setScrapeConfigNamespaceSelector(PrometheusSpecScrapeConfigNamespaceSelector scrapeConfigNamespaceSelector) {
        this.scrapeConfigNamespaceSelector = scrapeConfigNamespaceSelector;
    }

    @JsonProperty("scrapeConfigSelector")
    public PrometheusSpecScrapeConfigSelector getScrapeConfigSelector() {
        return scrapeConfigSelector;
    }

    @JsonProperty("scrapeConfigSelector")
    public void setScrapeConfigSelector(PrometheusSpecScrapeConfigSelector scrapeConfigSelector) {
        this.scrapeConfigSelector = scrapeConfigSelector;
    }

    @JsonProperty("scrapeInterval")
    public String getScrapeInterval() {
        return scrapeInterval;
    }

    @JsonProperty("scrapeInterval")
    public void setScrapeInterval(String scrapeInterval) {
        this.scrapeInterval = scrapeInterval;
    }

    @JsonProperty("scrapeProtocols")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getScrapeProtocols() {
        return scrapeProtocols;
    }

    @JsonProperty("scrapeProtocols")
    public void setScrapeProtocols(List<String> scrapeProtocols) {
        this.scrapeProtocols = scrapeProtocols;
    }

    @JsonProperty("scrapeTimeout")
    public String getScrapeTimeout() {
        return scrapeTimeout;
    }

    @JsonProperty("scrapeTimeout")
    public void setScrapeTimeout(String scrapeTimeout) {
        this.scrapeTimeout = scrapeTimeout;
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
    public PrometheusSpecSecurityContext getSecurityContext() {
        return securityContext;
    }

    @JsonProperty("securityContext")
    public void setSecurityContext(PrometheusSpecSecurityContext securityContext) {
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

    @JsonProperty("serviceMonitorNamespaceSelector")
    public PrometheusSpecServiceMonitorNamespaceSelector getServiceMonitorNamespaceSelector() {
        return serviceMonitorNamespaceSelector;
    }

    @JsonProperty("serviceMonitorNamespaceSelector")
    public void setServiceMonitorNamespaceSelector(PrometheusSpecServiceMonitorNamespaceSelector serviceMonitorNamespaceSelector) {
        this.serviceMonitorNamespaceSelector = serviceMonitorNamespaceSelector;
    }

    @JsonProperty("serviceMonitorSelector")
    public PrometheusSpecServiceMonitorSelector getServiceMonitorSelector() {
        return serviceMonitorSelector;
    }

    @JsonProperty("serviceMonitorSelector")
    public void setServiceMonitorSelector(PrometheusSpecServiceMonitorSelector serviceMonitorSelector) {
        this.serviceMonitorSelector = serviceMonitorSelector;
    }

    @JsonProperty("sha")
    public String getSha() {
        return sha;
    }

    @JsonProperty("sha")
    public void setSha(String sha) {
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
    public PrometheusSpecStorage getStorage() {
        return storage;
    }

    @JsonProperty("storage")
    public void setStorage(PrometheusSpecStorage storage) {
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

    @JsonProperty("targetLimit")
    public Long getTargetLimit() {
        return targetLimit;
    }

    @JsonProperty("targetLimit")
    public void setTargetLimit(Long targetLimit) {
        this.targetLimit = targetLimit;
    }

    @JsonProperty("thanos")
    public PrometheusSpecThanos getThanos() {
        return thanos;
    }

    @JsonProperty("thanos")
    public void setThanos(PrometheusSpecThanos thanos) {
        this.thanos = thanos;
    }

    @JsonProperty("tolerations")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<PrometheusSpecTolerations> getTolerations() {
        return tolerations;
    }

    @JsonProperty("tolerations")
    public void setTolerations(List<PrometheusSpecTolerations> tolerations) {
        this.tolerations = tolerations;
    }

    @JsonProperty("topologySpreadConstraints")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<PrometheusSpecTopologySpreadConstraints> getTopologySpreadConstraints() {
        return topologySpreadConstraints;
    }

    @JsonProperty("topologySpreadConstraints")
    public void setTopologySpreadConstraints(List<PrometheusSpecTopologySpreadConstraints> topologySpreadConstraints) {
        this.topologySpreadConstraints = topologySpreadConstraints;
    }

    @JsonProperty("tracingConfig")
    public PrometheusSpecTracingConfig getTracingConfig() {
        return tracingConfig;
    }

    @JsonProperty("tracingConfig")
    public void setTracingConfig(PrometheusSpecTracingConfig tracingConfig) {
        this.tracingConfig = tracingConfig;
    }

    @JsonProperty("tsdb")
    public PrometheusSpecTsdb getTsdb() {
        return tsdb;
    }

    @JsonProperty("tsdb")
    public void setTsdb(PrometheusSpecTsdb tsdb) {
        this.tsdb = tsdb;
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
    public List<PrometheusSpecVolumeMounts> getVolumeMounts() {
        return volumeMounts;
    }

    @JsonProperty("volumeMounts")
    public void setVolumeMounts(List<PrometheusSpecVolumeMounts> volumeMounts) {
        this.volumeMounts = volumeMounts;
    }

    @JsonProperty("volumes")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<PrometheusSpecVolumes> getVolumes() {
        return volumes;
    }

    @JsonProperty("volumes")
    public void setVolumes(List<PrometheusSpecVolumes> volumes) {
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
    public PrometheusSpecWeb getWeb() {
        return web;
    }

    @JsonProperty("web")
    public void setWeb(PrometheusSpecWeb web) {
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
