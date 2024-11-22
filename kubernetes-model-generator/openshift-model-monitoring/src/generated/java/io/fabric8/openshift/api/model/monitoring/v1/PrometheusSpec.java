
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
import io.fabric8.kubernetes.api.model.Container;
import io.fabric8.kubernetes.api.model.ContainerPort;
import io.fabric8.kubernetes.api.model.EnvVar;
import io.fabric8.kubernetes.api.model.IntOrString;
import io.fabric8.kubernetes.api.model.KubernetesResource;
import io.fabric8.kubernetes.api.model.LabelSelector;
import io.fabric8.kubernetes.api.model.LocalObjectReference;
import io.fabric8.kubernetes.api.model.ObjectMeta;
import io.fabric8.kubernetes.api.model.ObjectReference;
import io.fabric8.kubernetes.api.model.PersistentVolumeClaim;
import io.fabric8.kubernetes.api.model.PodSecurityContext;
import io.fabric8.kubernetes.api.model.PodTemplateSpec;
import io.fabric8.kubernetes.api.model.ResourceRequirements;
import io.fabric8.kubernetes.api.model.SecretKeySelector;
import io.fabric8.kubernetes.api.model.Toleration;
import io.fabric8.kubernetes.api.model.Volume;
import io.fabric8.kubernetes.api.model.VolumeMount;
import io.fabric8.kubernetes.api.model.apps.StatefulSetPersistentVolumeClaimRetentionPolicy;
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
    "automountServiceAccountToken",
    "baseImage",
    "bodySizeLimit",
    "configMaps",
    "containers",
    "disableCompaction",
    "dnsConfig",
    "dnsPolicy",
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
    "otlp",
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
    "remoteWriteReceiverMessageVersions",
    "replicaExternalLabelName",
    "replicas",
    "resources",
    "retention",
    "retentionSize",
    "routePrefix",
    "ruleNamespaceSelector",
    "ruleQueryOffset",
    "ruleSelector",
    "rules",
    "runtime",
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
    "serviceDiscoveryRole",
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
    @BuildableReference(PersistentVolumeClaim.class),
    @BuildableReference(EnvVar.class),
    @BuildableReference(ContainerPort.class),
    @BuildableReference(Volume.class),
    @BuildableReference(VolumeMount.class)
})
@Generated("io.fabric8.kubernetes.schema.generator.model.ModelGenerator")
public class PrometheusSpec implements Editable<PrometheusSpecBuilder> , KubernetesResource
{

    @JsonProperty("additionalAlertManagerConfigs")
    private SecretKeySelector additionalAlertManagerConfigs;
    @JsonProperty("additionalAlertRelabelConfigs")
    private SecretKeySelector additionalAlertRelabelConfigs;
    @JsonProperty("additionalArgs")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<Argument> additionalArgs = new ArrayList<>();
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
    @JsonProperty("automountServiceAccountToken")
    private Boolean automountServiceAccountToken;
    @JsonProperty("baseImage")
    private String baseImage;
    @JsonProperty("bodySizeLimit")
    private String bodySizeLimit;
    @JsonProperty("configMaps")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> configMaps = new ArrayList<>();
    @JsonProperty("containers")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<Container> containers = new ArrayList<>();
    @JsonProperty("disableCompaction")
    private Boolean disableCompaction;
    @JsonProperty("dnsConfig")
    private PodDNSConfig dnsConfig;
    @JsonProperty("dnsPolicy")
    private String dnsPolicy;
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
    private List<ObjectReference> excludedFromEnforcement = new ArrayList<>();
    @JsonProperty("exemplars")
    private Exemplars exemplars;
    @JsonProperty("externalLabels")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Map<String, String> externalLabels = new LinkedHashMap<>();
    @JsonProperty("externalUrl")
    private String externalUrl;
    @JsonProperty("hostAliases")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<HostAlias> hostAliases = new ArrayList<>();
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
    private List<LocalObjectReference> imagePullSecrets = new ArrayList<>();
    @JsonProperty("initContainers")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<Container> initContainers = new ArrayList<>();
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
    private Long minReadySeconds;
    @JsonProperty("nodeSelector")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Map<String, String> nodeSelector = new LinkedHashMap<>();
    @JsonProperty("otlp")
    private OTLPConfig otlp;
    @JsonProperty("overrideHonorLabels")
    private Boolean overrideHonorLabels;
    @JsonProperty("overrideHonorTimestamps")
    private Boolean overrideHonorTimestamps;
    @JsonProperty("paused")
    private Boolean paused;
    @JsonProperty("persistentVolumeClaimRetentionPolicy")
    private StatefulSetPersistentVolumeClaimRetentionPolicy persistentVolumeClaimRetentionPolicy;
    @JsonProperty("podMetadata")
    private EmbeddedObjectMetadata podMetadata;
    @JsonProperty("podMonitorNamespaceSelector")
    private LabelSelector podMonitorNamespaceSelector;
    @JsonProperty("podMonitorSelector")
    private LabelSelector podMonitorSelector;
    @JsonProperty("podTargetLabels")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> podTargetLabels = new ArrayList<>();
    @JsonProperty("portName")
    private String portName;
    @JsonProperty("priorityClassName")
    private String priorityClassName;
    @JsonProperty("probeNamespaceSelector")
    private LabelSelector probeNamespaceSelector;
    @JsonProperty("probeSelector")
    private LabelSelector probeSelector;
    @JsonProperty("prometheusExternalLabelName")
    private String prometheusExternalLabelName;
    @JsonProperty("prometheusRulesExcludedFromEnforce")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<PrometheusRuleExcludeConfig> prometheusRulesExcludedFromEnforce = new ArrayList<>();
    @JsonProperty("query")
    private QuerySpec query;
    @JsonProperty("queryLogFile")
    private String queryLogFile;
    @JsonProperty("reloadStrategy")
    private String reloadStrategy;
    @JsonProperty("remoteRead")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<RemoteReadSpec> remoteRead = new ArrayList<>();
    @JsonProperty("remoteWrite")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<RemoteWriteSpec> remoteWrite = new ArrayList<>();
    @JsonProperty("remoteWriteReceiverMessageVersions")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> remoteWriteReceiverMessageVersions = new ArrayList<>();
    @JsonProperty("replicaExternalLabelName")
    private String replicaExternalLabelName;
    @JsonProperty("replicas")
    private Integer replicas;
    @JsonProperty("resources")
    private ResourceRequirements resources;
    @JsonProperty("retention")
    private String retention;
    @JsonProperty("retentionSize")
    private String retentionSize;
    @JsonProperty("routePrefix")
    private String routePrefix;
    @JsonProperty("ruleNamespaceSelector")
    private LabelSelector ruleNamespaceSelector;
    @JsonProperty("ruleQueryOffset")
    private String ruleQueryOffset;
    @JsonProperty("ruleSelector")
    private LabelSelector ruleSelector;
    @JsonProperty("rules")
    private Rules rules;
    @JsonProperty("runtime")
    private RuntimeConfig runtime;
    @JsonProperty("sampleLimit")
    private Long sampleLimit;
    @JsonProperty("scrapeClasses")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<ScrapeClass> scrapeClasses = new ArrayList<>();
    @JsonProperty("scrapeConfigNamespaceSelector")
    private LabelSelector scrapeConfigNamespaceSelector;
    @JsonProperty("scrapeConfigSelector")
    private LabelSelector scrapeConfigSelector;
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
    private PodSecurityContext securityContext;
    @JsonProperty("serviceAccountName")
    private String serviceAccountName;
    @JsonProperty("serviceDiscoveryRole")
    private String serviceDiscoveryRole;
    @JsonProperty("serviceMonitorNamespaceSelector")
    private LabelSelector serviceMonitorNamespaceSelector;
    @JsonProperty("serviceMonitorSelector")
    private LabelSelector serviceMonitorSelector;
    @JsonProperty("sha")
    private String sha;
    @JsonProperty("shards")
    private Integer shards;
    @JsonProperty("storage")
    private StorageSpec storage;
    @JsonProperty("tag")
    private String tag;
    @JsonProperty("targetLimit")
    private Long targetLimit;
    @JsonProperty("thanos")
    private ThanosSpec thanos;
    @JsonProperty("tolerations")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<Toleration> tolerations = new ArrayList<>();
    @JsonProperty("topologySpreadConstraints")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<TopologySpreadConstraint> topologySpreadConstraints = new ArrayList<>();
    @JsonProperty("tracingConfig")
    private PrometheusTracingConfig tracingConfig;
    @JsonProperty("tsdb")
    private TSDBSpec tsdb;
    @JsonProperty("version")
    private String version;
    @JsonProperty("volumeMounts")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<VolumeMount> volumeMounts = new ArrayList<>();
    @JsonProperty("volumes")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<Volume> volumes = new ArrayList<>();
    @JsonProperty("walCompression")
    private Boolean walCompression;
    @JsonProperty("web")
    private PrometheusWebSpec web;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public PrometheusSpec() {
    }

    public PrometheusSpec(SecretKeySelector additionalAlertManagerConfigs, SecretKeySelector additionalAlertRelabelConfigs, List<Argument> additionalArgs, SecretKeySelector additionalScrapeConfigs, Affinity affinity, AlertingSpec alerting, Boolean allowOverlappingBlocks, APIServerConfig apiserverConfig, ArbitraryFSAccessThroughSMsConfig arbitraryFSAccessThroughSMs, Boolean automountServiceAccountToken, String baseImage, String bodySizeLimit, List<String> configMaps, List<Container> containers, Boolean disableCompaction, PodDNSConfig dnsConfig, String dnsPolicy, Boolean enableAdminAPI, List<String> enableFeatures, Boolean enableRemoteWriteReceiver, String enforcedBodySizeLimit, Long enforcedKeepDroppedTargets, Long enforcedLabelLimit, Long enforcedLabelNameLengthLimit, Long enforcedLabelValueLengthLimit, String enforcedNamespaceLabel, Long enforcedSampleLimit, Long enforcedTargetLimit, String evaluationInterval, List<ObjectReference> excludedFromEnforcement, Exemplars exemplars, Map<String, String> externalLabels, String externalUrl, List<HostAlias> hostAliases, Boolean hostNetwork, Boolean ignoreNamespaceSelectors, String image, String imagePullPolicy, List<LocalObjectReference> imagePullSecrets, List<Container> initContainers, Long keepDroppedTargets, Long labelLimit, Long labelNameLengthLimit, Long labelValueLengthLimit, Boolean listenLocal, String logFormat, String logLevel, Integer maximumStartupDurationSeconds, Long minReadySeconds, Map<String, String> nodeSelector, OTLPConfig otlp, Boolean overrideHonorLabels, Boolean overrideHonorTimestamps, Boolean paused, StatefulSetPersistentVolumeClaimRetentionPolicy persistentVolumeClaimRetentionPolicy, EmbeddedObjectMetadata podMetadata, LabelSelector podMonitorNamespaceSelector, LabelSelector podMonitorSelector, List<String> podTargetLabels, String portName, String priorityClassName, LabelSelector probeNamespaceSelector, LabelSelector probeSelector, String prometheusExternalLabelName, List<PrometheusRuleExcludeConfig> prometheusRulesExcludedFromEnforce, QuerySpec query, String queryLogFile, String reloadStrategy, List<RemoteReadSpec> remoteRead, List<RemoteWriteSpec> remoteWrite, List<String> remoteWriteReceiverMessageVersions, String replicaExternalLabelName, Integer replicas, ResourceRequirements resources, String retention, String retentionSize, String routePrefix, LabelSelector ruleNamespaceSelector, String ruleQueryOffset, LabelSelector ruleSelector, Rules rules, RuntimeConfig runtime, Long sampleLimit, List<ScrapeClass> scrapeClasses, LabelSelector scrapeConfigNamespaceSelector, LabelSelector scrapeConfigSelector, String scrapeInterval, List<String> scrapeProtocols, String scrapeTimeout, List<String> secrets, PodSecurityContext securityContext, String serviceAccountName, String serviceDiscoveryRole, LabelSelector serviceMonitorNamespaceSelector, LabelSelector serviceMonitorSelector, String sha, Integer shards, StorageSpec storage, String tag, Long targetLimit, ThanosSpec thanos, List<Toleration> tolerations, List<TopologySpreadConstraint> topologySpreadConstraints, PrometheusTracingConfig tracingConfig, TSDBSpec tsdb, String version, List<VolumeMount> volumeMounts, List<Volume> volumes, Boolean walCompression, PrometheusWebSpec web) {
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
        this.automountServiceAccountToken = automountServiceAccountToken;
        this.baseImage = baseImage;
        this.bodySizeLimit = bodySizeLimit;
        this.configMaps = configMaps;
        this.containers = containers;
        this.disableCompaction = disableCompaction;
        this.dnsConfig = dnsConfig;
        this.dnsPolicy = dnsPolicy;
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
        this.otlp = otlp;
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
        this.remoteWriteReceiverMessageVersions = remoteWriteReceiverMessageVersions;
        this.replicaExternalLabelName = replicaExternalLabelName;
        this.replicas = replicas;
        this.resources = resources;
        this.retention = retention;
        this.retentionSize = retentionSize;
        this.routePrefix = routePrefix;
        this.ruleNamespaceSelector = ruleNamespaceSelector;
        this.ruleQueryOffset = ruleQueryOffset;
        this.ruleSelector = ruleSelector;
        this.rules = rules;
        this.runtime = runtime;
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
        this.serviceDiscoveryRole = serviceDiscoveryRole;
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
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
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
    public List<Container> getContainers() {
        return containers;
    }

    @JsonProperty("containers")
    public void setContainers(List<Container> containers) {
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

    @JsonProperty("dnsConfig")
    public PodDNSConfig getDnsConfig() {
        return dnsConfig;
    }

    @JsonProperty("dnsConfig")
    public void setDnsConfig(PodDNSConfig dnsConfig) {
        this.dnsConfig = dnsConfig;
    }

    @JsonProperty("dnsPolicy")
    public String getDnsPolicy() {
        return dnsPolicy;
    }

    @JsonProperty("dnsPolicy")
    public void setDnsPolicy(String dnsPolicy) {
        this.dnsPolicy = dnsPolicy;
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
    public List<ObjectReference> getExcludedFromEnforcement() {
        return excludedFromEnforcement;
    }

    @JsonProperty("excludedFromEnforcement")
    public void setExcludedFromEnforcement(List<ObjectReference> excludedFromEnforcement) {
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
    public List<LocalObjectReference> getImagePullSecrets() {
        return imagePullSecrets;
    }

    @JsonProperty("imagePullSecrets")
    public void setImagePullSecrets(List<LocalObjectReference> imagePullSecrets) {
        this.imagePullSecrets = imagePullSecrets;
    }

    @JsonProperty("initContainers")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<Container> getInitContainers() {
        return initContainers;
    }

    @JsonProperty("initContainers")
    public void setInitContainers(List<Container> initContainers) {
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
    public Long getMinReadySeconds() {
        return minReadySeconds;
    }

    @JsonProperty("minReadySeconds")
    public void setMinReadySeconds(Long minReadySeconds) {
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

    @JsonProperty("otlp")
    public OTLPConfig getOtlp() {
        return otlp;
    }

    @JsonProperty("otlp")
    public void setOtlp(OTLPConfig otlp) {
        this.otlp = otlp;
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
    public StatefulSetPersistentVolumeClaimRetentionPolicy getPersistentVolumeClaimRetentionPolicy() {
        return persistentVolumeClaimRetentionPolicy;
    }

    @JsonProperty("persistentVolumeClaimRetentionPolicy")
    public void setPersistentVolumeClaimRetentionPolicy(StatefulSetPersistentVolumeClaimRetentionPolicy persistentVolumeClaimRetentionPolicy) {
        this.persistentVolumeClaimRetentionPolicy = persistentVolumeClaimRetentionPolicy;
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
    public LabelSelector getPodMonitorNamespaceSelector() {
        return podMonitorNamespaceSelector;
    }

    @JsonProperty("podMonitorNamespaceSelector")
    public void setPodMonitorNamespaceSelector(LabelSelector podMonitorNamespaceSelector) {
        this.podMonitorNamespaceSelector = podMonitorNamespaceSelector;
    }

    @JsonProperty("podMonitorSelector")
    public LabelSelector getPodMonitorSelector() {
        return podMonitorSelector;
    }

    @JsonProperty("podMonitorSelector")
    public void setPodMonitorSelector(LabelSelector podMonitorSelector) {
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
    public LabelSelector getProbeNamespaceSelector() {
        return probeNamespaceSelector;
    }

    @JsonProperty("probeNamespaceSelector")
    public void setProbeNamespaceSelector(LabelSelector probeNamespaceSelector) {
        this.probeNamespaceSelector = probeNamespaceSelector;
    }

    @JsonProperty("probeSelector")
    public LabelSelector getProbeSelector() {
        return probeSelector;
    }

    @JsonProperty("probeSelector")
    public void setProbeSelector(LabelSelector probeSelector) {
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
    public List<RemoteReadSpec> getRemoteRead() {
        return remoteRead;
    }

    @JsonProperty("remoteRead")
    public void setRemoteRead(List<RemoteReadSpec> remoteRead) {
        this.remoteRead = remoteRead;
    }

    @JsonProperty("remoteWrite")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<RemoteWriteSpec> getRemoteWrite() {
        return remoteWrite;
    }

    @JsonProperty("remoteWrite")
    public void setRemoteWrite(List<RemoteWriteSpec> remoteWrite) {
        this.remoteWrite = remoteWrite;
    }

    @JsonProperty("remoteWriteReceiverMessageVersions")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getRemoteWriteReceiverMessageVersions() {
        return remoteWriteReceiverMessageVersions;
    }

    @JsonProperty("remoteWriteReceiverMessageVersions")
    public void setRemoteWriteReceiverMessageVersions(List<String> remoteWriteReceiverMessageVersions) {
        this.remoteWriteReceiverMessageVersions = remoteWriteReceiverMessageVersions;
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
    public ResourceRequirements getResources() {
        return resources;
    }

    @JsonProperty("resources")
    public void setResources(ResourceRequirements resources) {
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
    public LabelSelector getRuleNamespaceSelector() {
        return ruleNamespaceSelector;
    }

    @JsonProperty("ruleNamespaceSelector")
    public void setRuleNamespaceSelector(LabelSelector ruleNamespaceSelector) {
        this.ruleNamespaceSelector = ruleNamespaceSelector;
    }

    @JsonProperty("ruleQueryOffset")
    public String getRuleQueryOffset() {
        return ruleQueryOffset;
    }

    @JsonProperty("ruleQueryOffset")
    public void setRuleQueryOffset(String ruleQueryOffset) {
        this.ruleQueryOffset = ruleQueryOffset;
    }

    @JsonProperty("ruleSelector")
    public LabelSelector getRuleSelector() {
        return ruleSelector;
    }

    @JsonProperty("ruleSelector")
    public void setRuleSelector(LabelSelector ruleSelector) {
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

    @JsonProperty("runtime")
    public RuntimeConfig getRuntime() {
        return runtime;
    }

    @JsonProperty("runtime")
    public void setRuntime(RuntimeConfig runtime) {
        this.runtime = runtime;
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
    public List<ScrapeClass> getScrapeClasses() {
        return scrapeClasses;
    }

    @JsonProperty("scrapeClasses")
    public void setScrapeClasses(List<ScrapeClass> scrapeClasses) {
        this.scrapeClasses = scrapeClasses;
    }

    @JsonProperty("scrapeConfigNamespaceSelector")
    public LabelSelector getScrapeConfigNamespaceSelector() {
        return scrapeConfigNamespaceSelector;
    }

    @JsonProperty("scrapeConfigNamespaceSelector")
    public void setScrapeConfigNamespaceSelector(LabelSelector scrapeConfigNamespaceSelector) {
        this.scrapeConfigNamespaceSelector = scrapeConfigNamespaceSelector;
    }

    @JsonProperty("scrapeConfigSelector")
    public LabelSelector getScrapeConfigSelector() {
        return scrapeConfigSelector;
    }

    @JsonProperty("scrapeConfigSelector")
    public void setScrapeConfigSelector(LabelSelector scrapeConfigSelector) {
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

    @JsonProperty("serviceDiscoveryRole")
    public String getServiceDiscoveryRole() {
        return serviceDiscoveryRole;
    }

    @JsonProperty("serviceDiscoveryRole")
    public void setServiceDiscoveryRole(String serviceDiscoveryRole) {
        this.serviceDiscoveryRole = serviceDiscoveryRole;
    }

    @JsonProperty("serviceMonitorNamespaceSelector")
    public LabelSelector getServiceMonitorNamespaceSelector() {
        return serviceMonitorNamespaceSelector;
    }

    @JsonProperty("serviceMonitorNamespaceSelector")
    public void setServiceMonitorNamespaceSelector(LabelSelector serviceMonitorNamespaceSelector) {
        this.serviceMonitorNamespaceSelector = serviceMonitorNamespaceSelector;
    }

    @JsonProperty("serviceMonitorSelector")
    public LabelSelector getServiceMonitorSelector() {
        return serviceMonitorSelector;
    }

    @JsonProperty("serviceMonitorSelector")
    public void setServiceMonitorSelector(LabelSelector serviceMonitorSelector) {
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
    public StorageSpec getStorage() {
        return storage;
    }

    @JsonProperty("storage")
    public void setStorage(StorageSpec storage) {
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
    public ThanosSpec getThanos() {
        return thanos;
    }

    @JsonProperty("thanos")
    public void setThanos(ThanosSpec thanos) {
        this.thanos = thanos;
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
