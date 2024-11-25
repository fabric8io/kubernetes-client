
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
    "additionalArgs",
    "additionalScrapeConfigs",
    "affinity",
    "apiserverConfig",
    "arbitraryFSAccessThroughSMs",
    "automountServiceAccountToken",
    "bodySizeLimit",
    "configMaps",
    "containers",
    "dnsConfig",
    "dnsPolicy",
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
    "excludedFromEnforcement",
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
    "reloadStrategy",
    "remoteWrite",
    "remoteWriteReceiverMessageVersions",
    "replicaExternalLabelName",
    "replicas",
    "resources",
    "routePrefix",
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
    "shards",
    "storage",
    "targetLimit",
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
public class CommonPrometheusFields implements Editable<CommonPrometheusFieldsBuilder>, KubernetesResource
{

    @JsonProperty("additionalArgs")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<Argument> additionalArgs = new ArrayList<>();
    @JsonProperty("additionalScrapeConfigs")
    private SecretKeySelector additionalScrapeConfigs;
    @JsonProperty("affinity")
    private Affinity affinity;
    @JsonProperty("apiserverConfig")
    private APIServerConfig apiserverConfig;
    @JsonProperty("arbitraryFSAccessThroughSMs")
    private ArbitraryFSAccessThroughSMsConfig arbitraryFSAccessThroughSMs;
    @JsonProperty("automountServiceAccountToken")
    private Boolean automountServiceAccountToken;
    @JsonProperty("bodySizeLimit")
    private String bodySizeLimit;
    @JsonProperty("configMaps")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> configMaps = new ArrayList<>();
    @JsonProperty("containers")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<Container> containers = new ArrayList<>();
    @JsonProperty("dnsConfig")
    private PodDNSConfig dnsConfig;
    @JsonProperty("dnsPolicy")
    private String dnsPolicy;
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
    @JsonProperty("excludedFromEnforcement")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<ObjectReference> excludedFromEnforcement = new ArrayList<>();
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
    @JsonProperty("reloadStrategy")
    private String reloadStrategy;
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
    @JsonProperty("routePrefix")
    private String routePrefix;
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
    @JsonProperty("shards")
    private Integer shards;
    @JsonProperty("storage")
    private StorageSpec storage;
    @JsonProperty("targetLimit")
    private Long targetLimit;
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
    public CommonPrometheusFields() {
    }

    public CommonPrometheusFields(List<Argument> additionalArgs, SecretKeySelector additionalScrapeConfigs, Affinity affinity, APIServerConfig apiserverConfig, ArbitraryFSAccessThroughSMsConfig arbitraryFSAccessThroughSMs, Boolean automountServiceAccountToken, String bodySizeLimit, List<String> configMaps, List<Container> containers, PodDNSConfig dnsConfig, String dnsPolicy, List<String> enableFeatures, Boolean enableRemoteWriteReceiver, String enforcedBodySizeLimit, Long enforcedKeepDroppedTargets, Long enforcedLabelLimit, Long enforcedLabelNameLengthLimit, Long enforcedLabelValueLengthLimit, String enforcedNamespaceLabel, Long enforcedSampleLimit, Long enforcedTargetLimit, List<ObjectReference> excludedFromEnforcement, Map<String, String> externalLabels, String externalUrl, List<HostAlias> hostAliases, Boolean hostNetwork, Boolean ignoreNamespaceSelectors, String image, String imagePullPolicy, List<LocalObjectReference> imagePullSecrets, List<Container> initContainers, Long keepDroppedTargets, Long labelLimit, Long labelNameLengthLimit, Long labelValueLengthLimit, Boolean listenLocal, String logFormat, String logLevel, Integer maximumStartupDurationSeconds, Long minReadySeconds, Map<String, String> nodeSelector, OTLPConfig otlp, Boolean overrideHonorLabels, Boolean overrideHonorTimestamps, Boolean paused, StatefulSetPersistentVolumeClaimRetentionPolicy persistentVolumeClaimRetentionPolicy, EmbeddedObjectMetadata podMetadata, LabelSelector podMonitorNamespaceSelector, LabelSelector podMonitorSelector, List<String> podTargetLabels, String portName, String priorityClassName, LabelSelector probeNamespaceSelector, LabelSelector probeSelector, String prometheusExternalLabelName, String reloadStrategy, List<RemoteWriteSpec> remoteWrite, List<String> remoteWriteReceiverMessageVersions, String replicaExternalLabelName, Integer replicas, ResourceRequirements resources, String routePrefix, Long sampleLimit, List<ScrapeClass> scrapeClasses, LabelSelector scrapeConfigNamespaceSelector, LabelSelector scrapeConfigSelector, String scrapeInterval, List<String> scrapeProtocols, String scrapeTimeout, List<String> secrets, PodSecurityContext securityContext, String serviceAccountName, String serviceDiscoveryRole, LabelSelector serviceMonitorNamespaceSelector, LabelSelector serviceMonitorSelector, Integer shards, StorageSpec storage, Long targetLimit, List<Toleration> tolerations, List<TopologySpreadConstraint> topologySpreadConstraints, PrometheusTracingConfig tracingConfig, TSDBSpec tsdb, String version, List<VolumeMount> volumeMounts, List<Volume> volumes, Boolean walCompression, PrometheusWebSpec web) {
        super();
        this.additionalArgs = additionalArgs;
        this.additionalScrapeConfigs = additionalScrapeConfigs;
        this.affinity = affinity;
        this.apiserverConfig = apiserverConfig;
        this.arbitraryFSAccessThroughSMs = arbitraryFSAccessThroughSMs;
        this.automountServiceAccountToken = automountServiceAccountToken;
        this.bodySizeLimit = bodySizeLimit;
        this.configMaps = configMaps;
        this.containers = containers;
        this.dnsConfig = dnsConfig;
        this.dnsPolicy = dnsPolicy;
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
        this.excludedFromEnforcement = excludedFromEnforcement;
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
        this.reloadStrategy = reloadStrategy;
        this.remoteWrite = remoteWrite;
        this.remoteWriteReceiverMessageVersions = remoteWriteReceiverMessageVersions;
        this.replicaExternalLabelName = replicaExternalLabelName;
        this.replicas = replicas;
        this.resources = resources;
        this.routePrefix = routePrefix;
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
        this.shards = shards;
        this.storage = storage;
        this.targetLimit = targetLimit;
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

    @JsonProperty("excludedFromEnforcement")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<ObjectReference> getExcludedFromEnforcement() {
        return excludedFromEnforcement;
    }

    @JsonProperty("excludedFromEnforcement")
    public void setExcludedFromEnforcement(List<ObjectReference> excludedFromEnforcement) {
        this.excludedFromEnforcement = excludedFromEnforcement;
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

    @JsonProperty("reloadStrategy")
    public String getReloadStrategy() {
        return reloadStrategy;
    }

    @JsonProperty("reloadStrategy")
    public void setReloadStrategy(String reloadStrategy) {
        this.reloadStrategy = reloadStrategy;
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

    @JsonProperty("routePrefix")
    public String getRoutePrefix() {
        return routePrefix;
    }

    @JsonProperty("routePrefix")
    public void setRoutePrefix(String routePrefix) {
        this.routePrefix = routePrefix;
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

    @JsonProperty("targetLimit")
    public Long getTargetLimit() {
        return targetLimit;
    }

    @JsonProperty("targetLimit")
    public void setTargetLimit(Long targetLimit) {
        this.targetLimit = targetLimit;
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
    public CommonPrometheusFieldsBuilder edit() {
        return new CommonPrometheusFieldsBuilder(this);
    }

    @JsonIgnore
    public CommonPrometheusFieldsBuilder toBuilder() {
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
