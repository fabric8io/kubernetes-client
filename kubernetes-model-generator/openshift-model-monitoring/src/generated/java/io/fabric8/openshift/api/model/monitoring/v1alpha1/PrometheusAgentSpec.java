
package io.fabric8.openshift.api.model.monitoring.v1alpha1;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.processing.Generated;
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
import io.fabric8.kubernetes.api.model.PersistentVolumeClaim;
import io.fabric8.kubernetes.api.model.PodSecurityContext;
import io.fabric8.kubernetes.api.model.PodTemplateSpec;
import io.fabric8.kubernetes.api.model.ResourceRequirements;
import io.fabric8.kubernetes.api.model.SecretKeySelector;
import io.fabric8.kubernetes.api.model.Toleration;
import io.fabric8.kubernetes.api.model.Volume;
import io.fabric8.kubernetes.api.model.VolumeMount;
import io.fabric8.kubernetes.api.model.apps.StatefulSetPersistentVolumeClaimRetentionPolicy;
import io.fabric8.openshift.api.model.monitoring.v1.APIServerConfig;
import io.fabric8.openshift.api.model.monitoring.v1.ArbitraryFSAccessThroughSMsConfig;
import io.fabric8.openshift.api.model.monitoring.v1.Argument;
import io.fabric8.openshift.api.model.monitoring.v1.EmbeddedObjectMetadata;
import io.fabric8.openshift.api.model.monitoring.v1.HostAlias;
import io.fabric8.openshift.api.model.monitoring.v1.OTLPConfig;
import io.fabric8.openshift.api.model.monitoring.v1.ObjectReference;
import io.fabric8.openshift.api.model.monitoring.v1.PodDNSConfig;
import io.fabric8.openshift.api.model.monitoring.v1.PrometheusWebSpec;
import io.fabric8.openshift.api.model.monitoring.v1.RemoteWriteSpec;
import io.fabric8.openshift.api.model.monitoring.v1.RuntimeConfig;
import io.fabric8.openshift.api.model.monitoring.v1.ScrapeClass;
import io.fabric8.openshift.api.model.monitoring.v1.ShardingStrategy;
import io.fabric8.openshift.api.model.monitoring.v1.StatefulSetUpdateStrategy;
import io.fabric8.openshift.api.model.monitoring.v1.StorageSpec;
import io.fabric8.openshift.api.model.monitoring.v1.TSDBSpec;
import io.fabric8.openshift.api.model.monitoring.v1.TopologySpreadConstraint;
import io.fabric8.openshift.api.model.monitoring.v1.TracingConfig;
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;

/**
 * PrometheusAgentSpec is a specification of the desired behavior of the Prometheus agent. More info: https://github.com/kubernetes/community/blob/master/contributors/devel/sig-architecture/api-conventions.md#spec-and-status
 */
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
    "convertClassicHistogramsToNHCB",
    "dnsConfig",
    "dnsPolicy",
    "enableFeatures",
    "enableOTLPReceiver",
    "enableRemoteWriteReceiver",
    "enableServiceLinks",
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
    "hostUsers",
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
    "mode",
    "nameEscapingScheme",
    "nameValidationScheme",
    "nodeSelector",
    "otlp",
    "overrideHonorLabels",
    "overrideHonorTimestamps",
    "paused",
    "persistentVolumeClaimRetentionPolicy",
    "podManagementPolicy",
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
    "runtime",
    "sampleLimit",
    "schedulerName",
    "scrapeClasses",
    "scrapeClassicHistograms",
    "scrapeConfigNamespaceSelector",
    "scrapeConfigSelector",
    "scrapeFailureLogFile",
    "scrapeInterval",
    "scrapeNativeHistograms",
    "scrapeProtocols",
    "scrapeTimeout",
    "secrets",
    "securityContext",
    "serviceAccountName",
    "serviceDiscoveryRole",
    "serviceMonitorNamespaceSelector",
    "serviceMonitorSelector",
    "serviceName",
    "shardingStrategy",
    "shards",
    "storage",
    "targetLimit",
    "terminationGracePeriodSeconds",
    "tolerations",
    "topologySpreadConstraints",
    "tracingConfig",
    "tsdb",
    "updateStrategy",
    "version",
    "volumeMounts",
    "volumes",
    "walCompression",
    "web"
})
@Buildable(editableEnabled = false, validationEnabled = false, generateBuilderPackage = false, lazyCollectionInitEnabled = false, builderPackage = "io.fabric8.kubernetes.api.builder", refs = {
    @BuildableReference(ObjectMeta.class),
    @BuildableReference(LabelSelector.class),
    @BuildableReference(Container.class),
    @BuildableReference(PodTemplateSpec.class),
    @BuildableReference(ResourceRequirements.class),
    @BuildableReference(IntOrString.class),
    @BuildableReference(io.fabric8.kubernetes.api.model.ObjectReference.class),
    @BuildableReference(LocalObjectReference.class),
    @BuildableReference(PersistentVolumeClaim.class),
    @BuildableReference(EnvVar.class),
    @BuildableReference(ContainerPort.class),
    @BuildableReference(Volume.class),
    @BuildableReference(VolumeMount.class)
})
@Generated("io.fabric8.kubernetes.schema.generator.model.ModelGenerator")
public class PrometheusAgentSpec implements Editable<PrometheusAgentSpecBuilder>, KubernetesResource
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
    @JsonProperty("convertClassicHistogramsToNHCB")
    private Boolean convertClassicHistogramsToNHCB;
    @JsonProperty("dnsConfig")
    private PodDNSConfig dnsConfig;
    @JsonProperty("dnsPolicy")
    private String dnsPolicy;
    @JsonProperty("enableFeatures")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> enableFeatures = new ArrayList<>();
    @JsonProperty("enableOTLPReceiver")
    private Boolean enableOTLPReceiver;
    @JsonProperty("enableRemoteWriteReceiver")
    private Boolean enableRemoteWriteReceiver;
    @JsonProperty("enableServiceLinks")
    private Boolean enableServiceLinks;
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
    @JsonProperty("hostUsers")
    private Boolean hostUsers;
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
    private Integer minReadySeconds;
    @JsonProperty("mode")
    private String mode;
    @JsonProperty("nameEscapingScheme")
    private String nameEscapingScheme;
    @JsonProperty("nameValidationScheme")
    private String nameValidationScheme;
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
    @JsonProperty("podManagementPolicy")
    private String podManagementPolicy;
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
    @JsonProperty("runtime")
    private RuntimeConfig runtime;
    @JsonProperty("sampleLimit")
    private Long sampleLimit;
    @JsonProperty("schedulerName")
    private String schedulerName;
    @JsonProperty("scrapeClasses")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<ScrapeClass> scrapeClasses = new ArrayList<>();
    @JsonProperty("scrapeClassicHistograms")
    private Boolean scrapeClassicHistograms;
    @JsonProperty("scrapeConfigNamespaceSelector")
    private LabelSelector scrapeConfigNamespaceSelector;
    @JsonProperty("scrapeConfigSelector")
    private LabelSelector scrapeConfigSelector;
    @JsonProperty("scrapeFailureLogFile")
    private String scrapeFailureLogFile;
    @JsonProperty("scrapeInterval")
    private String scrapeInterval;
    @JsonProperty("scrapeNativeHistograms")
    private Boolean scrapeNativeHistograms;
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
    @JsonProperty("serviceName")
    private String serviceName;
    @JsonProperty("shardingStrategy")
    private ShardingStrategy shardingStrategy;
    @JsonProperty("shards")
    private Integer shards;
    @JsonProperty("storage")
    private StorageSpec storage;
    @JsonProperty("targetLimit")
    private Long targetLimit;
    @JsonProperty("terminationGracePeriodSeconds")
    private Long terminationGracePeriodSeconds;
    @JsonProperty("tolerations")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<Toleration> tolerations = new ArrayList<>();
    @JsonProperty("topologySpreadConstraints")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<TopologySpreadConstraint> topologySpreadConstraints = new ArrayList<>();
    @JsonProperty("tracingConfig")
    private TracingConfig tracingConfig;
    @JsonProperty("tsdb")
    private TSDBSpec tsdb;
    @JsonProperty("updateStrategy")
    private StatefulSetUpdateStrategy updateStrategy;
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
     */
    public PrometheusAgentSpec() {
    }

    public PrometheusAgentSpec(List<Argument> additionalArgs, SecretKeySelector additionalScrapeConfigs, Affinity affinity, APIServerConfig apiserverConfig, ArbitraryFSAccessThroughSMsConfig arbitraryFSAccessThroughSMs, Boolean automountServiceAccountToken, String bodySizeLimit, List<String> configMaps, List<Container> containers, Boolean convertClassicHistogramsToNHCB, PodDNSConfig dnsConfig, String dnsPolicy, List<String> enableFeatures, Boolean enableOTLPReceiver, Boolean enableRemoteWriteReceiver, Boolean enableServiceLinks, String enforcedBodySizeLimit, Long enforcedKeepDroppedTargets, Long enforcedLabelLimit, Long enforcedLabelNameLengthLimit, Long enforcedLabelValueLengthLimit, String enforcedNamespaceLabel, Long enforcedSampleLimit, Long enforcedTargetLimit, List<ObjectReference> excludedFromEnforcement, Map<String, String> externalLabels, String externalUrl, List<HostAlias> hostAliases, Boolean hostNetwork, Boolean hostUsers, Boolean ignoreNamespaceSelectors, String image, String imagePullPolicy, List<LocalObjectReference> imagePullSecrets, List<Container> initContainers, Long keepDroppedTargets, Long labelLimit, Long labelNameLengthLimit, Long labelValueLengthLimit, Boolean listenLocal, String logFormat, String logLevel, Integer maximumStartupDurationSeconds, Integer minReadySeconds, String mode, String nameEscapingScheme, String nameValidationScheme, Map<String, String> nodeSelector, OTLPConfig otlp, Boolean overrideHonorLabels, Boolean overrideHonorTimestamps, Boolean paused, StatefulSetPersistentVolumeClaimRetentionPolicy persistentVolumeClaimRetentionPolicy, String podManagementPolicy, EmbeddedObjectMetadata podMetadata, LabelSelector podMonitorNamespaceSelector, LabelSelector podMonitorSelector, List<String> podTargetLabels, String portName, String priorityClassName, LabelSelector probeNamespaceSelector, LabelSelector probeSelector, String prometheusExternalLabelName, String reloadStrategy, List<RemoteWriteSpec> remoteWrite, List<String> remoteWriteReceiverMessageVersions, String replicaExternalLabelName, Integer replicas, ResourceRequirements resources, String routePrefix, RuntimeConfig runtime, Long sampleLimit, String schedulerName, List<ScrapeClass> scrapeClasses, Boolean scrapeClassicHistograms, LabelSelector scrapeConfigNamespaceSelector, LabelSelector scrapeConfigSelector, String scrapeFailureLogFile, String scrapeInterval, Boolean scrapeNativeHistograms, List<String> scrapeProtocols, String scrapeTimeout, List<String> secrets, PodSecurityContext securityContext, String serviceAccountName, String serviceDiscoveryRole, LabelSelector serviceMonitorNamespaceSelector, LabelSelector serviceMonitorSelector, String serviceName, ShardingStrategy shardingStrategy, Integer shards, StorageSpec storage, Long targetLimit, Long terminationGracePeriodSeconds, List<Toleration> tolerations, List<TopologySpreadConstraint> topologySpreadConstraints, TracingConfig tracingConfig, TSDBSpec tsdb, StatefulSetUpdateStrategy updateStrategy, String version, List<VolumeMount> volumeMounts, List<Volume> volumes, Boolean walCompression, PrometheusWebSpec web) {
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
        this.convertClassicHistogramsToNHCB = convertClassicHistogramsToNHCB;
        this.dnsConfig = dnsConfig;
        this.dnsPolicy = dnsPolicy;
        this.enableFeatures = enableFeatures;
        this.enableOTLPReceiver = enableOTLPReceiver;
        this.enableRemoteWriteReceiver = enableRemoteWriteReceiver;
        this.enableServiceLinks = enableServiceLinks;
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
        this.hostUsers = hostUsers;
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
        this.mode = mode;
        this.nameEscapingScheme = nameEscapingScheme;
        this.nameValidationScheme = nameValidationScheme;
        this.nodeSelector = nodeSelector;
        this.otlp = otlp;
        this.overrideHonorLabels = overrideHonorLabels;
        this.overrideHonorTimestamps = overrideHonorTimestamps;
        this.paused = paused;
        this.persistentVolumeClaimRetentionPolicy = persistentVolumeClaimRetentionPolicy;
        this.podManagementPolicy = podManagementPolicy;
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
        this.runtime = runtime;
        this.sampleLimit = sampleLimit;
        this.schedulerName = schedulerName;
        this.scrapeClasses = scrapeClasses;
        this.scrapeClassicHistograms = scrapeClassicHistograms;
        this.scrapeConfigNamespaceSelector = scrapeConfigNamespaceSelector;
        this.scrapeConfigSelector = scrapeConfigSelector;
        this.scrapeFailureLogFile = scrapeFailureLogFile;
        this.scrapeInterval = scrapeInterval;
        this.scrapeNativeHistograms = scrapeNativeHistograms;
        this.scrapeProtocols = scrapeProtocols;
        this.scrapeTimeout = scrapeTimeout;
        this.secrets = secrets;
        this.securityContext = securityContext;
        this.serviceAccountName = serviceAccountName;
        this.serviceDiscoveryRole = serviceDiscoveryRole;
        this.serviceMonitorNamespaceSelector = serviceMonitorNamespaceSelector;
        this.serviceMonitorSelector = serviceMonitorSelector;
        this.serviceName = serviceName;
        this.shardingStrategy = shardingStrategy;
        this.shards = shards;
        this.storage = storage;
        this.targetLimit = targetLimit;
        this.terminationGracePeriodSeconds = terminationGracePeriodSeconds;
        this.tolerations = tolerations;
        this.topologySpreadConstraints = topologySpreadConstraints;
        this.tracingConfig = tracingConfig;
        this.tsdb = tsdb;
        this.updateStrategy = updateStrategy;
        this.version = version;
        this.volumeMounts = volumeMounts;
        this.volumes = volumes;
        this.walCompression = walCompression;
        this.web = web;
    }

    /**
     * additionalArgs allows setting additional arguments for the 'prometheus' container.<br><p> <br><p> It is intended for e.g. activating hidden flags which are not supported by the dedicated configuration options yet. The arguments are passed as-is to the Prometheus container which may cause issues if they are invalid or not supported by the given Prometheus version.<br><p> <br><p> In case of an argument conflict (e.g. an argument which is already set by the operator itself) or when providing an invalid argument, the reconciliation will fail and an error will be logged.
     */
    @JsonProperty("additionalArgs")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<Argument> getAdditionalArgs() {
        return additionalArgs;
    }

    /**
     * additionalArgs allows setting additional arguments for the 'prometheus' container.<br><p> <br><p> It is intended for e.g. activating hidden flags which are not supported by the dedicated configuration options yet. The arguments are passed as-is to the Prometheus container which may cause issues if they are invalid or not supported by the given Prometheus version.<br><p> <br><p> In case of an argument conflict (e.g. an argument which is already set by the operator itself) or when providing an invalid argument, the reconciliation will fail and an error will be logged.
     */
    @JsonProperty("additionalArgs")
    public void setAdditionalArgs(List<Argument> additionalArgs) {
        this.additionalArgs = additionalArgs;
    }

    /**
     * PrometheusAgentSpec is a specification of the desired behavior of the Prometheus agent. More info: https://github.com/kubernetes/community/blob/master/contributors/devel/sig-architecture/api-conventions.md#spec-and-status
     */
    @JsonProperty("additionalScrapeConfigs")
    public SecretKeySelector getAdditionalScrapeConfigs() {
        return additionalScrapeConfigs;
    }

    /**
     * PrometheusAgentSpec is a specification of the desired behavior of the Prometheus agent. More info: https://github.com/kubernetes/community/blob/master/contributors/devel/sig-architecture/api-conventions.md#spec-and-status
     */
    @JsonProperty("additionalScrapeConfigs")
    public void setAdditionalScrapeConfigs(SecretKeySelector additionalScrapeConfigs) {
        this.additionalScrapeConfigs = additionalScrapeConfigs;
    }

    /**
     * PrometheusAgentSpec is a specification of the desired behavior of the Prometheus agent. More info: https://github.com/kubernetes/community/blob/master/contributors/devel/sig-architecture/api-conventions.md#spec-and-status
     */
    @JsonProperty("affinity")
    public Affinity getAffinity() {
        return affinity;
    }

    /**
     * PrometheusAgentSpec is a specification of the desired behavior of the Prometheus agent. More info: https://github.com/kubernetes/community/blob/master/contributors/devel/sig-architecture/api-conventions.md#spec-and-status
     */
    @JsonProperty("affinity")
    public void setAffinity(Affinity affinity) {
        this.affinity = affinity;
    }

    /**
     * PrometheusAgentSpec is a specification of the desired behavior of the Prometheus agent. More info: https://github.com/kubernetes/community/blob/master/contributors/devel/sig-architecture/api-conventions.md#spec-and-status
     */
    @JsonProperty("apiserverConfig")
    public APIServerConfig getApiserverConfig() {
        return apiserverConfig;
    }

    /**
     * PrometheusAgentSpec is a specification of the desired behavior of the Prometheus agent. More info: https://github.com/kubernetes/community/blob/master/contributors/devel/sig-architecture/api-conventions.md#spec-and-status
     */
    @JsonProperty("apiserverConfig")
    public void setApiserverConfig(APIServerConfig apiserverConfig) {
        this.apiserverConfig = apiserverConfig;
    }

    /**
     * PrometheusAgentSpec is a specification of the desired behavior of the Prometheus agent. More info: https://github.com/kubernetes/community/blob/master/contributors/devel/sig-architecture/api-conventions.md#spec-and-status
     */
    @JsonProperty("arbitraryFSAccessThroughSMs")
    public ArbitraryFSAccessThroughSMsConfig getArbitraryFSAccessThroughSMs() {
        return arbitraryFSAccessThroughSMs;
    }

    /**
     * PrometheusAgentSpec is a specification of the desired behavior of the Prometheus agent. More info: https://github.com/kubernetes/community/blob/master/contributors/devel/sig-architecture/api-conventions.md#spec-and-status
     */
    @JsonProperty("arbitraryFSAccessThroughSMs")
    public void setArbitraryFSAccessThroughSMs(ArbitraryFSAccessThroughSMsConfig arbitraryFSAccessThroughSMs) {
        this.arbitraryFSAccessThroughSMs = arbitraryFSAccessThroughSMs;
    }

    /**
     * automountServiceAccountToken defines whether a service account token should be automatically mounted in the pod. If the field isn't set, the operator mounts the service account token by default.<br><p> <br><p> &#42;&#42;Warning:&#42;&#42; be aware that by default, Prometheus requires the service account token for Kubernetes service discovery. It is possible to use strategic merge patch to project the service account token into the 'prometheus' container.
     */
    @JsonProperty("automountServiceAccountToken")
    public Boolean getAutomountServiceAccountToken() {
        return automountServiceAccountToken;
    }

    /**
     * automountServiceAccountToken defines whether a service account token should be automatically mounted in the pod. If the field isn't set, the operator mounts the service account token by default.<br><p> <br><p> &#42;&#42;Warning:&#42;&#42; be aware that by default, Prometheus requires the service account token for Kubernetes service discovery. It is possible to use strategic merge patch to project the service account token into the 'prometheus' container.
     */
    @JsonProperty("automountServiceAccountToken")
    public void setAutomountServiceAccountToken(Boolean automountServiceAccountToken) {
        this.automountServiceAccountToken = automountServiceAccountToken;
    }

    /**
     * bodySizeLimit defines per-scrape on response body size. Only valid in Prometheus versions 2.45.0 and newer.<br><p> <br><p> Note that the global limit only applies to scrape objects that don't specify an explicit limit value. If you want to enforce a maximum limit for all scrape objects, refer to enforcedBodySizeLimit.
     */
    @JsonProperty("bodySizeLimit")
    public String getBodySizeLimit() {
        return bodySizeLimit;
    }

    /**
     * bodySizeLimit defines per-scrape on response body size. Only valid in Prometheus versions 2.45.0 and newer.<br><p> <br><p> Note that the global limit only applies to scrape objects that don't specify an explicit limit value. If you want to enforce a maximum limit for all scrape objects, refer to enforcedBodySizeLimit.
     */
    @JsonProperty("bodySizeLimit")
    public void setBodySizeLimit(String bodySizeLimit) {
        this.bodySizeLimit = bodySizeLimit;
    }

    /**
     * configMaps defines a list of ConfigMaps in the same namespace as the Prometheus object, which shall be mounted into the Prometheus Pods. Each ConfigMap is added to the StatefulSet definition as a volume named `configmap-&lt;configmap-name&gt;`. The ConfigMaps are mounted into /etc/prometheus/configmaps/&lt;configmap-name&gt; in the 'prometheus' container.
     */
    @JsonProperty("configMaps")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getConfigMaps() {
        return configMaps;
    }

    /**
     * configMaps defines a list of ConfigMaps in the same namespace as the Prometheus object, which shall be mounted into the Prometheus Pods. Each ConfigMap is added to the StatefulSet definition as a volume named `configmap-&lt;configmap-name&gt;`. The ConfigMaps are mounted into /etc/prometheus/configmaps/&lt;configmap-name&gt; in the 'prometheus' container.
     */
    @JsonProperty("configMaps")
    public void setConfigMaps(List<String> configMaps) {
        this.configMaps = configMaps;
    }

    /**
     * containers allows injecting additional containers or modifying operator generated containers. This can be used to allow adding an authentication proxy to the Pods or to change the behavior of an operator generated container. Containers described here modify an operator generated container if they share the same name and modifications are done via a strategic merge patch.<br><p> <br><p> The names of containers managed by the operator are: &#42; `prometheus` &#42; `config-reloader` &#42; `thanos-sidecar`<br><p> <br><p> Overriding containers which are managed by the operator require careful testing, especially when upgrading to a new version of the operator.
     */
    @JsonProperty("containers")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<Container> getContainers() {
        return containers;
    }

    /**
     * containers allows injecting additional containers or modifying operator generated containers. This can be used to allow adding an authentication proxy to the Pods or to change the behavior of an operator generated container. Containers described here modify an operator generated container if they share the same name and modifications are done via a strategic merge patch.<br><p> <br><p> The names of containers managed by the operator are: &#42; `prometheus` &#42; `config-reloader` &#42; `thanos-sidecar`<br><p> <br><p> Overriding containers which are managed by the operator require careful testing, especially when upgrading to a new version of the operator.
     */
    @JsonProperty("containers")
    public void setContainers(List<Container> containers) {
        this.containers = containers;
    }

    /**
     * convertClassicHistogramsToNHCB defines whether to convert all scraped classic histograms into a native histogram with custom buckets.<br><p> <br><p> It requires Prometheus &gt;= v3.4.0.
     */
    @JsonProperty("convertClassicHistogramsToNHCB")
    public Boolean getConvertClassicHistogramsToNHCB() {
        return convertClassicHistogramsToNHCB;
    }

    /**
     * convertClassicHistogramsToNHCB defines whether to convert all scraped classic histograms into a native histogram with custom buckets.<br><p> <br><p> It requires Prometheus &gt;= v3.4.0.
     */
    @JsonProperty("convertClassicHistogramsToNHCB")
    public void setConvertClassicHistogramsToNHCB(Boolean convertClassicHistogramsToNHCB) {
        this.convertClassicHistogramsToNHCB = convertClassicHistogramsToNHCB;
    }

    /**
     * PrometheusAgentSpec is a specification of the desired behavior of the Prometheus agent. More info: https://github.com/kubernetes/community/blob/master/contributors/devel/sig-architecture/api-conventions.md#spec-and-status
     */
    @JsonProperty("dnsConfig")
    public PodDNSConfig getDnsConfig() {
        return dnsConfig;
    }

    /**
     * PrometheusAgentSpec is a specification of the desired behavior of the Prometheus agent. More info: https://github.com/kubernetes/community/blob/master/contributors/devel/sig-architecture/api-conventions.md#spec-and-status
     */
    @JsonProperty("dnsConfig")
    public void setDnsConfig(PodDNSConfig dnsConfig) {
        this.dnsConfig = dnsConfig;
    }

    /**
     * dnsPolicy defines the DNS policy for the pods.
     */
    @JsonProperty("dnsPolicy")
    public String getDnsPolicy() {
        return dnsPolicy;
    }

    /**
     * dnsPolicy defines the DNS policy for the pods.
     */
    @JsonProperty("dnsPolicy")
    public void setDnsPolicy(String dnsPolicy) {
        this.dnsPolicy = dnsPolicy;
    }

    /**
     * enableFeatures enables access to Prometheus feature flags. By default, no features are enabled.<br><p> <br><p> Enabling features which are disabled by default is entirely outside the scope of what the maintainers will support and by doing so, you accept that this behaviour may break at any time without notice.<br><p> <br><p> For more information see https://prometheus.io/docs/prometheus/latest/feature_flags/
     */
    @JsonProperty("enableFeatures")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getEnableFeatures() {
        return enableFeatures;
    }

    /**
     * enableFeatures enables access to Prometheus feature flags. By default, no features are enabled.<br><p> <br><p> Enabling features which are disabled by default is entirely outside the scope of what the maintainers will support and by doing so, you accept that this behaviour may break at any time without notice.<br><p> <br><p> For more information see https://prometheus.io/docs/prometheus/latest/feature_flags/
     */
    @JsonProperty("enableFeatures")
    public void setEnableFeatures(List<String> enableFeatures) {
        this.enableFeatures = enableFeatures;
    }

    /**
     * enableOTLPReceiver defines the Prometheus to be used as a receiver for the OTLP Metrics protocol.<br><p> <br><p> Note that the OTLP receiver endpoint is automatically enabled if `.spec.otlpConfig` is defined.<br><p> <br><p> It requires Prometheus &gt;= v2.47.0.
     */
    @JsonProperty("enableOTLPReceiver")
    public Boolean getEnableOTLPReceiver() {
        return enableOTLPReceiver;
    }

    /**
     * enableOTLPReceiver defines the Prometheus to be used as a receiver for the OTLP Metrics protocol.<br><p> <br><p> Note that the OTLP receiver endpoint is automatically enabled if `.spec.otlpConfig` is defined.<br><p> <br><p> It requires Prometheus &gt;= v2.47.0.
     */
    @JsonProperty("enableOTLPReceiver")
    public void setEnableOTLPReceiver(Boolean enableOTLPReceiver) {
        this.enableOTLPReceiver = enableOTLPReceiver;
    }

    /**
     * enableRemoteWriteReceiver defines the Prometheus to be used as a receiver for the Prometheus remote write protocol.<br><p> <br><p> WARNING: This is not considered an efficient way of ingesting samples. Use it with caution for specific low-volume use cases. It is not suitable for replacing the ingestion via scraping and turning Prometheus into a push-based metrics collection system. For more information see https://prometheus.io/docs/prometheus/latest/querying/api/#remote-write-receiver<br><p> <br><p> It requires Prometheus &gt;= v2.33.0.
     */
    @JsonProperty("enableRemoteWriteReceiver")
    public Boolean getEnableRemoteWriteReceiver() {
        return enableRemoteWriteReceiver;
    }

    /**
     * enableRemoteWriteReceiver defines the Prometheus to be used as a receiver for the Prometheus remote write protocol.<br><p> <br><p> WARNING: This is not considered an efficient way of ingesting samples. Use it with caution for specific low-volume use cases. It is not suitable for replacing the ingestion via scraping and turning Prometheus into a push-based metrics collection system. For more information see https://prometheus.io/docs/prometheus/latest/querying/api/#remote-write-receiver<br><p> <br><p> It requires Prometheus &gt;= v2.33.0.
     */
    @JsonProperty("enableRemoteWriteReceiver")
    public void setEnableRemoteWriteReceiver(Boolean enableRemoteWriteReceiver) {
        this.enableRemoteWriteReceiver = enableRemoteWriteReceiver;
    }

    /**
     * enableServiceLinks defines whether information about services should be injected into pod's environment variables
     */
    @JsonProperty("enableServiceLinks")
    public Boolean getEnableServiceLinks() {
        return enableServiceLinks;
    }

    /**
     * enableServiceLinks defines whether information about services should be injected into pod's environment variables
     */
    @JsonProperty("enableServiceLinks")
    public void setEnableServiceLinks(Boolean enableServiceLinks) {
        this.enableServiceLinks = enableServiceLinks;
    }

    /**
     * enforcedBodySizeLimit when defined specifies a global limit on the size of uncompressed response body that will be accepted by Prometheus. Targets responding with a body larger than this many bytes will cause the scrape to fail.<br><p> <br><p> It requires Prometheus &gt;= v2.28.0.<br><p> <br><p> When both `enforcedBodySizeLimit` and `bodySizeLimit` are defined and greater than zero, the following rules apply: &#42; Scrape objects without a defined bodySizeLimit value will inherit the global bodySizeLimit value (Prometheus &gt;= 2.45.0) or the enforcedBodySizeLimit value (Prometheus &lt; v2.45.0).<br><p>   If Prometheus version is &gt;= 2.45.0 and the `enforcedBodySizeLimit` is greater than the `bodySizeLimit`, the `bodySizeLimit` will be set to `enforcedBodySizeLimit`.<br><p> &#42; Scrape objects with a bodySizeLimit value less than or equal to enforcedBodySizeLimit keep their specific value. &#42; Scrape objects with a bodySizeLimit value greater than enforcedBodySizeLimit are set to enforcedBodySizeLimit.
     */
    @JsonProperty("enforcedBodySizeLimit")
    public String getEnforcedBodySizeLimit() {
        return enforcedBodySizeLimit;
    }

    /**
     * enforcedBodySizeLimit when defined specifies a global limit on the size of uncompressed response body that will be accepted by Prometheus. Targets responding with a body larger than this many bytes will cause the scrape to fail.<br><p> <br><p> It requires Prometheus &gt;= v2.28.0.<br><p> <br><p> When both `enforcedBodySizeLimit` and `bodySizeLimit` are defined and greater than zero, the following rules apply: &#42; Scrape objects without a defined bodySizeLimit value will inherit the global bodySizeLimit value (Prometheus &gt;= 2.45.0) or the enforcedBodySizeLimit value (Prometheus &lt; v2.45.0).<br><p>   If Prometheus version is &gt;= 2.45.0 and the `enforcedBodySizeLimit` is greater than the `bodySizeLimit`, the `bodySizeLimit` will be set to `enforcedBodySizeLimit`.<br><p> &#42; Scrape objects with a bodySizeLimit value less than or equal to enforcedBodySizeLimit keep their specific value. &#42; Scrape objects with a bodySizeLimit value greater than enforcedBodySizeLimit are set to enforcedBodySizeLimit.
     */
    @JsonProperty("enforcedBodySizeLimit")
    public void setEnforcedBodySizeLimit(String enforcedBodySizeLimit) {
        this.enforcedBodySizeLimit = enforcedBodySizeLimit;
    }

    /**
     * enforcedKeepDroppedTargets when defined specifies a global limit on the number of targets dropped by relabeling that will be kept in memory. The value overrides any `spec.keepDroppedTargets` set by ServiceMonitor, PodMonitor, Probe objects unless `spec.keepDroppedTargets` is greater than zero and less than `spec.enforcedKeepDroppedTargets`.<br><p> <br><p> It requires Prometheus &gt;= v2.47.0.<br><p> <br><p> When both `enforcedKeepDroppedTargets` and `keepDroppedTargets` are defined and greater than zero, the following rules apply: &#42; Scrape objects without a defined keepDroppedTargets value will inherit the global keepDroppedTargets value (Prometheus &gt;= 2.45.0) or the enforcedKeepDroppedTargets value (Prometheus &lt; v2.45.0).<br><p>   If Prometheus version is &gt;= 2.45.0 and the `enforcedKeepDroppedTargets` is greater than the `keepDroppedTargets`, the `keepDroppedTargets` will be set to `enforcedKeepDroppedTargets`.<br><p> &#42; Scrape objects with a keepDroppedTargets value less than or equal to enforcedKeepDroppedTargets keep their specific value. &#42; Scrape objects with a keepDroppedTargets value greater than enforcedKeepDroppedTargets are set to enforcedKeepDroppedTargets.
     */
    @JsonProperty("enforcedKeepDroppedTargets")
    public Long getEnforcedKeepDroppedTargets() {
        return enforcedKeepDroppedTargets;
    }

    /**
     * enforcedKeepDroppedTargets when defined specifies a global limit on the number of targets dropped by relabeling that will be kept in memory. The value overrides any `spec.keepDroppedTargets` set by ServiceMonitor, PodMonitor, Probe objects unless `spec.keepDroppedTargets` is greater than zero and less than `spec.enforcedKeepDroppedTargets`.<br><p> <br><p> It requires Prometheus &gt;= v2.47.0.<br><p> <br><p> When both `enforcedKeepDroppedTargets` and `keepDroppedTargets` are defined and greater than zero, the following rules apply: &#42; Scrape objects without a defined keepDroppedTargets value will inherit the global keepDroppedTargets value (Prometheus &gt;= 2.45.0) or the enforcedKeepDroppedTargets value (Prometheus &lt; v2.45.0).<br><p>   If Prometheus version is &gt;= 2.45.0 and the `enforcedKeepDroppedTargets` is greater than the `keepDroppedTargets`, the `keepDroppedTargets` will be set to `enforcedKeepDroppedTargets`.<br><p> &#42; Scrape objects with a keepDroppedTargets value less than or equal to enforcedKeepDroppedTargets keep their specific value. &#42; Scrape objects with a keepDroppedTargets value greater than enforcedKeepDroppedTargets are set to enforcedKeepDroppedTargets.
     */
    @JsonProperty("enforcedKeepDroppedTargets")
    public void setEnforcedKeepDroppedTargets(Long enforcedKeepDroppedTargets) {
        this.enforcedKeepDroppedTargets = enforcedKeepDroppedTargets;
    }

    /**
     * enforcedLabelLimit when defined specifies a global limit on the number of labels per sample. The value overrides any `spec.labelLimit` set by ServiceMonitor, PodMonitor, Probe objects unless `spec.labelLimit` is greater than zero and less than `spec.enforcedLabelLimit`.<br><p> <br><p> It requires Prometheus &gt;= v2.27.0.<br><p> <br><p> When both `enforcedLabelLimit` and `labelLimit` are defined and greater than zero, the following rules apply: &#42; Scrape objects without a defined labelLimit value will inherit the global labelLimit value (Prometheus &gt;= 2.45.0) or the enforcedLabelLimit value (Prometheus &lt; v2.45.0).<br><p>   If Prometheus version is &gt;= 2.45.0 and the `enforcedLabelLimit` is greater than the `labelLimit`, the `labelLimit` will be set to `enforcedLabelLimit`.<br><p> &#42; Scrape objects with a labelLimit value less than or equal to enforcedLabelLimit keep their specific value. &#42; Scrape objects with a labelLimit value greater than enforcedLabelLimit are set to enforcedLabelLimit.
     */
    @JsonProperty("enforcedLabelLimit")
    public Long getEnforcedLabelLimit() {
        return enforcedLabelLimit;
    }

    /**
     * enforcedLabelLimit when defined specifies a global limit on the number of labels per sample. The value overrides any `spec.labelLimit` set by ServiceMonitor, PodMonitor, Probe objects unless `spec.labelLimit` is greater than zero and less than `spec.enforcedLabelLimit`.<br><p> <br><p> It requires Prometheus &gt;= v2.27.0.<br><p> <br><p> When both `enforcedLabelLimit` and `labelLimit` are defined and greater than zero, the following rules apply: &#42; Scrape objects without a defined labelLimit value will inherit the global labelLimit value (Prometheus &gt;= 2.45.0) or the enforcedLabelLimit value (Prometheus &lt; v2.45.0).<br><p>   If Prometheus version is &gt;= 2.45.0 and the `enforcedLabelLimit` is greater than the `labelLimit`, the `labelLimit` will be set to `enforcedLabelLimit`.<br><p> &#42; Scrape objects with a labelLimit value less than or equal to enforcedLabelLimit keep their specific value. &#42; Scrape objects with a labelLimit value greater than enforcedLabelLimit are set to enforcedLabelLimit.
     */
    @JsonProperty("enforcedLabelLimit")
    public void setEnforcedLabelLimit(Long enforcedLabelLimit) {
        this.enforcedLabelLimit = enforcedLabelLimit;
    }

    /**
     * enforcedLabelNameLengthLimit when defined specifies a global limit on the length of labels name per sample. The value overrides any `spec.labelNameLengthLimit` set by ServiceMonitor, PodMonitor, Probe objects unless `spec.labelNameLengthLimit` is greater than zero and less than `spec.enforcedLabelNameLengthLimit`.<br><p> <br><p> It requires Prometheus &gt;= v2.27.0.<br><p> <br><p> When both `enforcedLabelNameLengthLimit` and `labelNameLengthLimit` are defined and greater than zero, the following rules apply: &#42; Scrape objects without a defined labelNameLengthLimit value will inherit the global labelNameLengthLimit value (Prometheus &gt;= 2.45.0) or the enforcedLabelNameLengthLimit value (Prometheus &lt; v2.45.0).<br><p>   If Prometheus version is &gt;= 2.45.0 and the `enforcedLabelNameLengthLimit` is greater than the `labelNameLengthLimit`, the `labelNameLengthLimit` will be set to `enforcedLabelNameLengthLimit`.<br><p> &#42; Scrape objects with a labelNameLengthLimit value less than or equal to enforcedLabelNameLengthLimit keep their specific value. &#42; Scrape objects with a labelNameLengthLimit value greater than enforcedLabelNameLengthLimit are set to enforcedLabelNameLengthLimit.
     */
    @JsonProperty("enforcedLabelNameLengthLimit")
    public Long getEnforcedLabelNameLengthLimit() {
        return enforcedLabelNameLengthLimit;
    }

    /**
     * enforcedLabelNameLengthLimit when defined specifies a global limit on the length of labels name per sample. The value overrides any `spec.labelNameLengthLimit` set by ServiceMonitor, PodMonitor, Probe objects unless `spec.labelNameLengthLimit` is greater than zero and less than `spec.enforcedLabelNameLengthLimit`.<br><p> <br><p> It requires Prometheus &gt;= v2.27.0.<br><p> <br><p> When both `enforcedLabelNameLengthLimit` and `labelNameLengthLimit` are defined and greater than zero, the following rules apply: &#42; Scrape objects without a defined labelNameLengthLimit value will inherit the global labelNameLengthLimit value (Prometheus &gt;= 2.45.0) or the enforcedLabelNameLengthLimit value (Prometheus &lt; v2.45.0).<br><p>   If Prometheus version is &gt;= 2.45.0 and the `enforcedLabelNameLengthLimit` is greater than the `labelNameLengthLimit`, the `labelNameLengthLimit` will be set to `enforcedLabelNameLengthLimit`.<br><p> &#42; Scrape objects with a labelNameLengthLimit value less than or equal to enforcedLabelNameLengthLimit keep their specific value. &#42; Scrape objects with a labelNameLengthLimit value greater than enforcedLabelNameLengthLimit are set to enforcedLabelNameLengthLimit.
     */
    @JsonProperty("enforcedLabelNameLengthLimit")
    public void setEnforcedLabelNameLengthLimit(Long enforcedLabelNameLengthLimit) {
        this.enforcedLabelNameLengthLimit = enforcedLabelNameLengthLimit;
    }

    /**
     * enforcedLabelValueLengthLimit when not null defines a global limit on the length of labels value per sample. The value overrides any `spec.labelValueLengthLimit` set by ServiceMonitor, PodMonitor, Probe objects unless `spec.labelValueLengthLimit` is greater than zero and less than `spec.enforcedLabelValueLengthLimit`.<br><p> <br><p> It requires Prometheus &gt;= v2.27.0.<br><p> <br><p> When both `enforcedLabelValueLengthLimit` and `labelValueLengthLimit` are defined and greater than zero, the following rules apply: &#42; Scrape objects without a defined labelValueLengthLimit value will inherit the global labelValueLengthLimit value (Prometheus &gt;= 2.45.0) or the enforcedLabelValueLengthLimit value (Prometheus &lt; v2.45.0).<br><p>   If Prometheus version is &gt;= 2.45.0 and the `enforcedLabelValueLengthLimit` is greater than the `labelValueLengthLimit`, the `labelValueLengthLimit` will be set to `enforcedLabelValueLengthLimit`.<br><p> &#42; Scrape objects with a labelValueLengthLimit value less than or equal to enforcedLabelValueLengthLimit keep their specific value. &#42; Scrape objects with a labelValueLengthLimit value greater than enforcedLabelValueLengthLimit are set to enforcedLabelValueLengthLimit.
     */
    @JsonProperty("enforcedLabelValueLengthLimit")
    public Long getEnforcedLabelValueLengthLimit() {
        return enforcedLabelValueLengthLimit;
    }

    /**
     * enforcedLabelValueLengthLimit when not null defines a global limit on the length of labels value per sample. The value overrides any `spec.labelValueLengthLimit` set by ServiceMonitor, PodMonitor, Probe objects unless `spec.labelValueLengthLimit` is greater than zero and less than `spec.enforcedLabelValueLengthLimit`.<br><p> <br><p> It requires Prometheus &gt;= v2.27.0.<br><p> <br><p> When both `enforcedLabelValueLengthLimit` and `labelValueLengthLimit` are defined and greater than zero, the following rules apply: &#42; Scrape objects without a defined labelValueLengthLimit value will inherit the global labelValueLengthLimit value (Prometheus &gt;= 2.45.0) or the enforcedLabelValueLengthLimit value (Prometheus &lt; v2.45.0).<br><p>   If Prometheus version is &gt;= 2.45.0 and the `enforcedLabelValueLengthLimit` is greater than the `labelValueLengthLimit`, the `labelValueLengthLimit` will be set to `enforcedLabelValueLengthLimit`.<br><p> &#42; Scrape objects with a labelValueLengthLimit value less than or equal to enforcedLabelValueLengthLimit keep their specific value. &#42; Scrape objects with a labelValueLengthLimit value greater than enforcedLabelValueLengthLimit are set to enforcedLabelValueLengthLimit.
     */
    @JsonProperty("enforcedLabelValueLengthLimit")
    public void setEnforcedLabelValueLengthLimit(Long enforcedLabelValueLengthLimit) {
        this.enforcedLabelValueLengthLimit = enforcedLabelValueLengthLimit;
    }

    /**
     * enforcedNamespaceLabel when not empty, a label will be added to:<br><p> <br><p> 1. All metrics scraped from `ServiceMonitor`, `PodMonitor`, `Probe` and `ScrapeConfig` objects. 2. All metrics generated from recording rules defined in `PrometheusRule` objects. 3. All alerts generated from alerting rules defined in `PrometheusRule` objects. 4. All vector selectors of PromQL expressions defined in `PrometheusRule` objects.<br><p> <br><p> The label will not added for objects referenced in `spec.excludedFromEnforcement`.<br><p> <br><p> The label's name is this field's value. The label's value is the namespace of the `ServiceMonitor`, `PodMonitor`, `Probe`, `PrometheusRule` or `ScrapeConfig` object.
     */
    @JsonProperty("enforcedNamespaceLabel")
    public String getEnforcedNamespaceLabel() {
        return enforcedNamespaceLabel;
    }

    /**
     * enforcedNamespaceLabel when not empty, a label will be added to:<br><p> <br><p> 1. All metrics scraped from `ServiceMonitor`, `PodMonitor`, `Probe` and `ScrapeConfig` objects. 2. All metrics generated from recording rules defined in `PrometheusRule` objects. 3. All alerts generated from alerting rules defined in `PrometheusRule` objects. 4. All vector selectors of PromQL expressions defined in `PrometheusRule` objects.<br><p> <br><p> The label will not added for objects referenced in `spec.excludedFromEnforcement`.<br><p> <br><p> The label's name is this field's value. The label's value is the namespace of the `ServiceMonitor`, `PodMonitor`, `Probe`, `PrometheusRule` or `ScrapeConfig` object.
     */
    @JsonProperty("enforcedNamespaceLabel")
    public void setEnforcedNamespaceLabel(String enforcedNamespaceLabel) {
        this.enforcedNamespaceLabel = enforcedNamespaceLabel;
    }

    /**
     * enforcedSampleLimit when defined specifies a global limit on the number of scraped samples that will be accepted. This overrides any `spec.sampleLimit` set by ServiceMonitor, PodMonitor, Probe objects unless `spec.sampleLimit` is greater than zero and less than `spec.enforcedSampleLimit`.<br><p> <br><p> It is meant to be used by admins to keep the overall number of samples/series under a desired limit.<br><p> <br><p> When both `enforcedSampleLimit` and `sampleLimit` are defined and greater than zero, the following rules apply: &#42; Scrape objects without a defined sampleLimit value will inherit the global sampleLimit value (Prometheus &gt;= 2.45.0) or the enforcedSampleLimit value (Prometheus &lt; v2.45.0).<br><p>   If Prometheus version is &gt;= 2.45.0 and the `enforcedSampleLimit` is greater than the `sampleLimit`, the `sampleLimit` will be set to `enforcedSampleLimit`.<br><p> &#42; Scrape objects with a sampleLimit value less than or equal to enforcedSampleLimit keep their specific value. &#42; Scrape objects with a sampleLimit value greater than enforcedSampleLimit are set to enforcedSampleLimit.
     */
    @JsonProperty("enforcedSampleLimit")
    public Long getEnforcedSampleLimit() {
        return enforcedSampleLimit;
    }

    /**
     * enforcedSampleLimit when defined specifies a global limit on the number of scraped samples that will be accepted. This overrides any `spec.sampleLimit` set by ServiceMonitor, PodMonitor, Probe objects unless `spec.sampleLimit` is greater than zero and less than `spec.enforcedSampleLimit`.<br><p> <br><p> It is meant to be used by admins to keep the overall number of samples/series under a desired limit.<br><p> <br><p> When both `enforcedSampleLimit` and `sampleLimit` are defined and greater than zero, the following rules apply: &#42; Scrape objects without a defined sampleLimit value will inherit the global sampleLimit value (Prometheus &gt;= 2.45.0) or the enforcedSampleLimit value (Prometheus &lt; v2.45.0).<br><p>   If Prometheus version is &gt;= 2.45.0 and the `enforcedSampleLimit` is greater than the `sampleLimit`, the `sampleLimit` will be set to `enforcedSampleLimit`.<br><p> &#42; Scrape objects with a sampleLimit value less than or equal to enforcedSampleLimit keep their specific value. &#42; Scrape objects with a sampleLimit value greater than enforcedSampleLimit are set to enforcedSampleLimit.
     */
    @JsonProperty("enforcedSampleLimit")
    public void setEnforcedSampleLimit(Long enforcedSampleLimit) {
        this.enforcedSampleLimit = enforcedSampleLimit;
    }

    /**
     * enforcedTargetLimit when defined specifies a global limit on the number of scraped targets. The value overrides any `spec.targetLimit` set by ServiceMonitor, PodMonitor, Probe objects unless `spec.targetLimit` is greater than zero and less than `spec.enforcedTargetLimit`.<br><p> <br><p> It is meant to be used by admins to to keep the overall number of targets under a desired limit.<br><p> <br><p> When both `enforcedTargetLimit` and `targetLimit` are defined and greater than zero, the following rules apply: &#42; Scrape objects without a defined targetLimit value will inherit the global targetLimit value (Prometheus &gt;= 2.45.0) or the enforcedTargetLimit value (Prometheus &lt; v2.45.0).<br><p>   If Prometheus version is &gt;= 2.45.0 and the `enforcedTargetLimit` is greater than the `targetLimit`, the `targetLimit` will be set to `enforcedTargetLimit`.<br><p> &#42; Scrape objects with a targetLimit value less than or equal to enforcedTargetLimit keep their specific value. &#42; Scrape objects with a targetLimit value greater than enforcedTargetLimit are set to enforcedTargetLimit.
     */
    @JsonProperty("enforcedTargetLimit")
    public Long getEnforcedTargetLimit() {
        return enforcedTargetLimit;
    }

    /**
     * enforcedTargetLimit when defined specifies a global limit on the number of scraped targets. The value overrides any `spec.targetLimit` set by ServiceMonitor, PodMonitor, Probe objects unless `spec.targetLimit` is greater than zero and less than `spec.enforcedTargetLimit`.<br><p> <br><p> It is meant to be used by admins to to keep the overall number of targets under a desired limit.<br><p> <br><p> When both `enforcedTargetLimit` and `targetLimit` are defined and greater than zero, the following rules apply: &#42; Scrape objects without a defined targetLimit value will inherit the global targetLimit value (Prometheus &gt;= 2.45.0) or the enforcedTargetLimit value (Prometheus &lt; v2.45.0).<br><p>   If Prometheus version is &gt;= 2.45.0 and the `enforcedTargetLimit` is greater than the `targetLimit`, the `targetLimit` will be set to `enforcedTargetLimit`.<br><p> &#42; Scrape objects with a targetLimit value less than or equal to enforcedTargetLimit keep their specific value. &#42; Scrape objects with a targetLimit value greater than enforcedTargetLimit are set to enforcedTargetLimit.
     */
    @JsonProperty("enforcedTargetLimit")
    public void setEnforcedTargetLimit(Long enforcedTargetLimit) {
        this.enforcedTargetLimit = enforcedTargetLimit;
    }

    /**
     * excludedFromEnforcement defines the list of references to PodMonitor, ServiceMonitor, Probe and PrometheusRule objects to be excluded from enforcing a namespace label of origin.<br><p> <br><p> It is only applicable if `spec.enforcedNamespaceLabel` set to true.
     */
    @JsonProperty("excludedFromEnforcement")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<ObjectReference> getExcludedFromEnforcement() {
        return excludedFromEnforcement;
    }

    /**
     * excludedFromEnforcement defines the list of references to PodMonitor, ServiceMonitor, Probe and PrometheusRule objects to be excluded from enforcing a namespace label of origin.<br><p> <br><p> It is only applicable if `spec.enforcedNamespaceLabel` set to true.
     */
    @JsonProperty("excludedFromEnforcement")
    public void setExcludedFromEnforcement(List<ObjectReference> excludedFromEnforcement) {
        this.excludedFromEnforcement = excludedFromEnforcement;
    }

    /**
     * externalLabels defines the labels to add to any time series or alerts when communicating with external systems (federation, remote storage, Alertmanager). Labels defined by `spec.replicaExternalLabelName` and `spec.prometheusExternalLabelName` take precedence over this list.
     */
    @JsonProperty("externalLabels")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public Map<String, String> getExternalLabels() {
        return externalLabels;
    }

    /**
     * externalLabels defines the labels to add to any time series or alerts when communicating with external systems (federation, remote storage, Alertmanager). Labels defined by `spec.replicaExternalLabelName` and `spec.prometheusExternalLabelName` take precedence over this list.
     */
    @JsonProperty("externalLabels")
    public void setExternalLabels(Map<String, String> externalLabels) {
        this.externalLabels = externalLabels;
    }

    /**
     * externalUrl defines the external URL under which the Prometheus service is externally available. This is necessary to generate correct URLs (for instance if Prometheus is accessible behind an Ingress resource).
     */
    @JsonProperty("externalUrl")
    public String getExternalUrl() {
        return externalUrl;
    }

    /**
     * externalUrl defines the external URL under which the Prometheus service is externally available. This is necessary to generate correct URLs (for instance if Prometheus is accessible behind an Ingress resource).
     */
    @JsonProperty("externalUrl")
    public void setExternalUrl(String externalUrl) {
        this.externalUrl = externalUrl;
    }

    /**
     * hostAliases defines the optional list of hosts and IPs that will be injected into the Pod's hosts file if specified.
     */
    @JsonProperty("hostAliases")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<HostAlias> getHostAliases() {
        return hostAliases;
    }

    /**
     * hostAliases defines the optional list of hosts and IPs that will be injected into the Pod's hosts file if specified.
     */
    @JsonProperty("hostAliases")
    public void setHostAliases(List<HostAlias> hostAliases) {
        this.hostAliases = hostAliases;
    }

    /**
     * hostNetwork defines the host's network namespace if true.<br><p> <br><p> Make sure to understand the security implications if you want to enable it (https://kubernetes.io/docs/concepts/configuration/overview/ ).<br><p> <br><p> When hostNetwork is enabled, this will set the DNS policy to `ClusterFirstWithHostNet` automatically (unless `.spec.DNSPolicy` is set to a different value).
     */
    @JsonProperty("hostNetwork")
    public Boolean getHostNetwork() {
        return hostNetwork;
    }

    /**
     * hostNetwork defines the host's network namespace if true.<br><p> <br><p> Make sure to understand the security implications if you want to enable it (https://kubernetes.io/docs/concepts/configuration/overview/ ).<br><p> <br><p> When hostNetwork is enabled, this will set the DNS policy to `ClusterFirstWithHostNet` automatically (unless `.spec.DNSPolicy` is set to a different value).
     */
    @JsonProperty("hostNetwork")
    public void setHostNetwork(Boolean hostNetwork) {
        this.hostNetwork = hostNetwork;
    }

    /**
     * hostUsers supports the user space in Kubernetes.<br><p> <br><p> More info: https://kubernetes.io/docs/tasks/configure-pod-container/user-namespaces/<br><p> <br><p> The feature requires at least Kubernetes 1.28 with the `UserNamespacesSupport` feature gate enabled. Starting Kubernetes 1.33, the feature is enabled by default.
     */
    @JsonProperty("hostUsers")
    public Boolean getHostUsers() {
        return hostUsers;
    }

    /**
     * hostUsers supports the user space in Kubernetes.<br><p> <br><p> More info: https://kubernetes.io/docs/tasks/configure-pod-container/user-namespaces/<br><p> <br><p> The feature requires at least Kubernetes 1.28 with the `UserNamespacesSupport` feature gate enabled. Starting Kubernetes 1.33, the feature is enabled by default.
     */
    @JsonProperty("hostUsers")
    public void setHostUsers(Boolean hostUsers) {
        this.hostUsers = hostUsers;
    }

    /**
     * ignoreNamespaceSelectors when true, `spec.namespaceSelector` from all PodMonitor, ServiceMonitor and Probe objects will be ignored. They will only discover targets within the namespace of the PodMonitor, ServiceMonitor and Probe object.
     */
    @JsonProperty("ignoreNamespaceSelectors")
    public Boolean getIgnoreNamespaceSelectors() {
        return ignoreNamespaceSelectors;
    }

    /**
     * ignoreNamespaceSelectors when true, `spec.namespaceSelector` from all PodMonitor, ServiceMonitor and Probe objects will be ignored. They will only discover targets within the namespace of the PodMonitor, ServiceMonitor and Probe object.
     */
    @JsonProperty("ignoreNamespaceSelectors")
    public void setIgnoreNamespaceSelectors(Boolean ignoreNamespaceSelectors) {
        this.ignoreNamespaceSelectors = ignoreNamespaceSelectors;
    }

    /**
     * image defines the container image name for Prometheus. If specified, it takes precedence over the `spec.baseImage`, `spec.tag` and `spec.sha` fields.<br><p> <br><p> Specifying `spec.version` is still necessary to ensure the Prometheus Operator knows which version of Prometheus is being configured.<br><p> <br><p> If neither `spec.image` nor `spec.baseImage` are defined, the operator will use the latest upstream version of Prometheus available at the time when the operator was released.
     */
    @JsonProperty("image")
    public String getImage() {
        return image;
    }

    /**
     * image defines the container image name for Prometheus. If specified, it takes precedence over the `spec.baseImage`, `spec.tag` and `spec.sha` fields.<br><p> <br><p> Specifying `spec.version` is still necessary to ensure the Prometheus Operator knows which version of Prometheus is being configured.<br><p> <br><p> If neither `spec.image` nor `spec.baseImage` are defined, the operator will use the latest upstream version of Prometheus available at the time when the operator was released.
     */
    @JsonProperty("image")
    public void setImage(String image) {
        this.image = image;
    }

    /**
     * imagePullPolicy defines the image pull policy for the 'prometheus', 'init-config-reloader' and 'config-reloader' containers. See https://kubernetes.io/docs/concepts/containers/images/#image-pull-policy for more details.<br><p> <br><p> Possible enum values:<br><p>  - `"Always"` means that kubelet always attempts to pull the latest image. Container will fail If the pull fails.<br><p>  - `"IfNotPresent"` means that kubelet pulls if the image isn't present on disk. Container will fail if the image isn't present and the pull fails.<br><p>  - `"Never"` means that kubelet never pulls an image, but only uses a local image. Container will fail if the image isn't present
     */
    @JsonProperty("imagePullPolicy")
    public String getImagePullPolicy() {
        return imagePullPolicy;
    }

    /**
     * imagePullPolicy defines the image pull policy for the 'prometheus', 'init-config-reloader' and 'config-reloader' containers. See https://kubernetes.io/docs/concepts/containers/images/#image-pull-policy for more details.<br><p> <br><p> Possible enum values:<br><p>  - `"Always"` means that kubelet always attempts to pull the latest image. Container will fail If the pull fails.<br><p>  - `"IfNotPresent"` means that kubelet pulls if the image isn't present on disk. Container will fail if the image isn't present and the pull fails.<br><p>  - `"Never"` means that kubelet never pulls an image, but only uses a local image. Container will fail if the image isn't present
     */
    @JsonProperty("imagePullPolicy")
    public void setImagePullPolicy(String imagePullPolicy) {
        this.imagePullPolicy = imagePullPolicy;
    }

    /**
     * imagePullSecrets defines an optional list of references to Secrets in the same namespace to use for pulling images from registries. See http://kubernetes.io/docs/user-guide/images#specifying-imagepullsecrets-on-a-pod
     */
    @JsonProperty("imagePullSecrets")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<LocalObjectReference> getImagePullSecrets() {
        return imagePullSecrets;
    }

    /**
     * imagePullSecrets defines an optional list of references to Secrets in the same namespace to use for pulling images from registries. See http://kubernetes.io/docs/user-guide/images#specifying-imagepullsecrets-on-a-pod
     */
    @JsonProperty("imagePullSecrets")
    public void setImagePullSecrets(List<LocalObjectReference> imagePullSecrets) {
        this.imagePullSecrets = imagePullSecrets;
    }

    /**
     * initContainers allows injecting initContainers to the Pod definition. Those can be used to e.g. fetch secrets for injection into the Prometheus configuration from external sources. Any errors during the execution of an initContainer will lead to a restart of the Pod. More info: https://kubernetes.io/docs/concepts/workloads/pods/init-containers/ InitContainers described here modify an operator generated init containers if they share the same name and modifications are done via a strategic merge patch.<br><p> <br><p> The names of init container name managed by the operator are: &#42; `init-config-reloader`.<br><p> <br><p> Overriding init containers which are managed by the operator require careful testing, especially when upgrading to a new version of the operator.
     */
    @JsonProperty("initContainers")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<Container> getInitContainers() {
        return initContainers;
    }

    /**
     * initContainers allows injecting initContainers to the Pod definition. Those can be used to e.g. fetch secrets for injection into the Prometheus configuration from external sources. Any errors during the execution of an initContainer will lead to a restart of the Pod. More info: https://kubernetes.io/docs/concepts/workloads/pods/init-containers/ InitContainers described here modify an operator generated init containers if they share the same name and modifications are done via a strategic merge patch.<br><p> <br><p> The names of init container name managed by the operator are: &#42; `init-config-reloader`.<br><p> <br><p> Overriding init containers which are managed by the operator require careful testing, especially when upgrading to a new version of the operator.
     */
    @JsonProperty("initContainers")
    public void setInitContainers(List<Container> initContainers) {
        this.initContainers = initContainers;
    }

    /**
     * keepDroppedTargets defines the per-scrape limit on the number of targets dropped by relabeling that will be kept in memory. 0 means no limit.<br><p> <br><p> It requires Prometheus &gt;= v2.47.0.<br><p> <br><p> Note that the global limit only applies to scrape objects that don't specify an explicit limit value. If you want to enforce a maximum limit for all scrape objects, refer to enforcedKeepDroppedTargets.
     */
    @JsonProperty("keepDroppedTargets")
    public Long getKeepDroppedTargets() {
        return keepDroppedTargets;
    }

    /**
     * keepDroppedTargets defines the per-scrape limit on the number of targets dropped by relabeling that will be kept in memory. 0 means no limit.<br><p> <br><p> It requires Prometheus &gt;= v2.47.0.<br><p> <br><p> Note that the global limit only applies to scrape objects that don't specify an explicit limit value. If you want to enforce a maximum limit for all scrape objects, refer to enforcedKeepDroppedTargets.
     */
    @JsonProperty("keepDroppedTargets")
    public void setKeepDroppedTargets(Long keepDroppedTargets) {
        this.keepDroppedTargets = keepDroppedTargets;
    }

    /**
     * labelLimit defines per-scrape limit on number of labels that will be accepted for a sample. Only valid in Prometheus versions 2.45.0 and newer.<br><p> <br><p> Note that the global limit only applies to scrape objects that don't specify an explicit limit value. If you want to enforce a maximum limit for all scrape objects, refer to enforcedLabelLimit.
     */
    @JsonProperty("labelLimit")
    public Long getLabelLimit() {
        return labelLimit;
    }

    /**
     * labelLimit defines per-scrape limit on number of labels that will be accepted for a sample. Only valid in Prometheus versions 2.45.0 and newer.<br><p> <br><p> Note that the global limit only applies to scrape objects that don't specify an explicit limit value. If you want to enforce a maximum limit for all scrape objects, refer to enforcedLabelLimit.
     */
    @JsonProperty("labelLimit")
    public void setLabelLimit(Long labelLimit) {
        this.labelLimit = labelLimit;
    }

    /**
     * labelNameLengthLimit defines the per-scrape limit on length of labels name that will be accepted for a sample. Only valid in Prometheus versions 2.45.0 and newer.<br><p> <br><p> Note that the global limit only applies to scrape objects that don't specify an explicit limit value. If you want to enforce a maximum limit for all scrape objects, refer to enforcedLabelNameLengthLimit.
     */
    @JsonProperty("labelNameLengthLimit")
    public Long getLabelNameLengthLimit() {
        return labelNameLengthLimit;
    }

    /**
     * labelNameLengthLimit defines the per-scrape limit on length of labels name that will be accepted for a sample. Only valid in Prometheus versions 2.45.0 and newer.<br><p> <br><p> Note that the global limit only applies to scrape objects that don't specify an explicit limit value. If you want to enforce a maximum limit for all scrape objects, refer to enforcedLabelNameLengthLimit.
     */
    @JsonProperty("labelNameLengthLimit")
    public void setLabelNameLengthLimit(Long labelNameLengthLimit) {
        this.labelNameLengthLimit = labelNameLengthLimit;
    }

    /**
     * labelValueLengthLimit defines the per-scrape limit on length of labels value that will be accepted for a sample. Only valid in Prometheus versions 2.45.0 and newer.<br><p> <br><p> Note that the global limit only applies to scrape objects that don't specify an explicit limit value. If you want to enforce a maximum limit for all scrape objects, refer to enforcedLabelValueLengthLimit.
     */
    @JsonProperty("labelValueLengthLimit")
    public Long getLabelValueLengthLimit() {
        return labelValueLengthLimit;
    }

    /**
     * labelValueLengthLimit defines the per-scrape limit on length of labels value that will be accepted for a sample. Only valid in Prometheus versions 2.45.0 and newer.<br><p> <br><p> Note that the global limit only applies to scrape objects that don't specify an explicit limit value. If you want to enforce a maximum limit for all scrape objects, refer to enforcedLabelValueLengthLimit.
     */
    @JsonProperty("labelValueLengthLimit")
    public void setLabelValueLengthLimit(Long labelValueLengthLimit) {
        this.labelValueLengthLimit = labelValueLengthLimit;
    }

    /**
     * listenLocal when true, the Prometheus server listens on the loopback address instead of the Pod IP's address.
     */
    @JsonProperty("listenLocal")
    public Boolean getListenLocal() {
        return listenLocal;
    }

    /**
     * listenLocal when true, the Prometheus server listens on the loopback address instead of the Pod IP's address.
     */
    @JsonProperty("listenLocal")
    public void setListenLocal(Boolean listenLocal) {
        this.listenLocal = listenLocal;
    }

    /**
     * logFormat for Log level for Prometheus and the config-reloader sidecar.
     */
    @JsonProperty("logFormat")
    public String getLogFormat() {
        return logFormat;
    }

    /**
     * logFormat for Log level for Prometheus and the config-reloader sidecar.
     */
    @JsonProperty("logFormat")
    public void setLogFormat(String logFormat) {
        this.logFormat = logFormat;
    }

    /**
     * logLevel for Prometheus and the config-reloader sidecar.
     */
    @JsonProperty("logLevel")
    public String getLogLevel() {
        return logLevel;
    }

    /**
     * logLevel for Prometheus and the config-reloader sidecar.
     */
    @JsonProperty("logLevel")
    public void setLogLevel(String logLevel) {
        this.logLevel = logLevel;
    }

    /**
     * maximumStartupDurationSeconds defines the maximum time that the `prometheus` container's startup probe will wait before being considered failed. The startup probe will return success after the WAL replay is complete. If set, the value should be greater than 60 (seconds). Otherwise it will be equal to 900 seconds (15 minutes).
     */
    @JsonProperty("maximumStartupDurationSeconds")
    public Integer getMaximumStartupDurationSeconds() {
        return maximumStartupDurationSeconds;
    }

    /**
     * maximumStartupDurationSeconds defines the maximum time that the `prometheus` container's startup probe will wait before being considered failed. The startup probe will return success after the WAL replay is complete. If set, the value should be greater than 60 (seconds). Otherwise it will be equal to 900 seconds (15 minutes).
     */
    @JsonProperty("maximumStartupDurationSeconds")
    public void setMaximumStartupDurationSeconds(Integer maximumStartupDurationSeconds) {
        this.maximumStartupDurationSeconds = maximumStartupDurationSeconds;
    }

    /**
     * minReadySeconds defines the minimum number of seconds for which a newly created Pod should be ready without any of its container crashing for it to be considered available.<br><p> <br><p> If unset, pods will be considered available as soon as they are ready.
     */
    @JsonProperty("minReadySeconds")
    public Integer getMinReadySeconds() {
        return minReadySeconds;
    }

    /**
     * minReadySeconds defines the minimum number of seconds for which a newly created Pod should be ready without any of its container crashing for it to be considered available.<br><p> <br><p> If unset, pods will be considered available as soon as they are ready.
     */
    @JsonProperty("minReadySeconds")
    public void setMinReadySeconds(Integer minReadySeconds) {
        this.minReadySeconds = minReadySeconds;
    }

    /**
     * mode defines how the Prometheus operator deploys the PrometheusAgent pod(s).<br><p> <br><p> (Alpha) Using this field requires the `PrometheusAgentDaemonSet` feature gate to be enabled.
     */
    @JsonProperty("mode")
    public String getMode() {
        return mode;
    }

    /**
     * mode defines how the Prometheus operator deploys the PrometheusAgent pod(s).<br><p> <br><p> (Alpha) Using this field requires the `PrometheusAgentDaemonSet` feature gate to be enabled.
     */
    @JsonProperty("mode")
    public void setMode(String mode) {
        this.mode = mode;
    }

    /**
     * nameEscapingScheme defines the character escaping scheme that will be requested when scraping for metric and label names that do not conform to the legacy Prometheus character set.<br><p> <br><p> It requires Prometheus &gt;= v3.4.0.
     */
    @JsonProperty("nameEscapingScheme")
    public String getNameEscapingScheme() {
        return nameEscapingScheme;
    }

    /**
     * nameEscapingScheme defines the character escaping scheme that will be requested when scraping for metric and label names that do not conform to the legacy Prometheus character set.<br><p> <br><p> It requires Prometheus &gt;= v3.4.0.
     */
    @JsonProperty("nameEscapingScheme")
    public void setNameEscapingScheme(String nameEscapingScheme) {
        this.nameEscapingScheme = nameEscapingScheme;
    }

    /**
     * nameValidationScheme defines the validation scheme for metric and label names.<br><p> <br><p> It requires Prometheus &gt;= v2.55.0.
     */
    @JsonProperty("nameValidationScheme")
    public String getNameValidationScheme() {
        return nameValidationScheme;
    }

    /**
     * nameValidationScheme defines the validation scheme for metric and label names.<br><p> <br><p> It requires Prometheus &gt;= v2.55.0.
     */
    @JsonProperty("nameValidationScheme")
    public void setNameValidationScheme(String nameValidationScheme) {
        this.nameValidationScheme = nameValidationScheme;
    }

    /**
     * nodeSelector defines on which Nodes the Pods are scheduled.
     */
    @JsonProperty("nodeSelector")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public Map<String, String> getNodeSelector() {
        return nodeSelector;
    }

    /**
     * nodeSelector defines on which Nodes the Pods are scheduled.
     */
    @JsonProperty("nodeSelector")
    public void setNodeSelector(Map<String, String> nodeSelector) {
        this.nodeSelector = nodeSelector;
    }

    /**
     * PrometheusAgentSpec is a specification of the desired behavior of the Prometheus agent. More info: https://github.com/kubernetes/community/blob/master/contributors/devel/sig-architecture/api-conventions.md#spec-and-status
     */
    @JsonProperty("otlp")
    public OTLPConfig getOtlp() {
        return otlp;
    }

    /**
     * PrometheusAgentSpec is a specification of the desired behavior of the Prometheus agent. More info: https://github.com/kubernetes/community/blob/master/contributors/devel/sig-architecture/api-conventions.md#spec-and-status
     */
    @JsonProperty("otlp")
    public void setOtlp(OTLPConfig otlp) {
        this.otlp = otlp;
    }

    /**
     * overrideHonorLabels when true, Prometheus resolves label conflicts by renaming the labels in the scraped data<br><p>  to "exported_" for all targets created from ServiceMonitor, PodMonitor and<br><p> ScrapeConfig objects. Otherwise the HonorLabels field of the service or pod monitor applies. In practice,`OverrideHonorLabels:true` enforces `honorLabels:false` for all ServiceMonitor, PodMonitor and ScrapeConfig objects.
     */
    @JsonProperty("overrideHonorLabels")
    public Boolean getOverrideHonorLabels() {
        return overrideHonorLabels;
    }

    /**
     * overrideHonorLabels when true, Prometheus resolves label conflicts by renaming the labels in the scraped data<br><p>  to "exported_" for all targets created from ServiceMonitor, PodMonitor and<br><p> ScrapeConfig objects. Otherwise the HonorLabels field of the service or pod monitor applies. In practice,`OverrideHonorLabels:true` enforces `honorLabels:false` for all ServiceMonitor, PodMonitor and ScrapeConfig objects.
     */
    @JsonProperty("overrideHonorLabels")
    public void setOverrideHonorLabels(Boolean overrideHonorLabels) {
        this.overrideHonorLabels = overrideHonorLabels;
    }

    /**
     * overrideHonorTimestamps when true, Prometheus ignores the timestamps for all the targets created from service and pod monitors. Otherwise the HonorTimestamps field of the service or pod monitor applies.
     */
    @JsonProperty("overrideHonorTimestamps")
    public Boolean getOverrideHonorTimestamps() {
        return overrideHonorTimestamps;
    }

    /**
     * overrideHonorTimestamps when true, Prometheus ignores the timestamps for all the targets created from service and pod monitors. Otherwise the HonorTimestamps field of the service or pod monitor applies.
     */
    @JsonProperty("overrideHonorTimestamps")
    public void setOverrideHonorTimestamps(Boolean overrideHonorTimestamps) {
        this.overrideHonorTimestamps = overrideHonorTimestamps;
    }

    /**
     * paused defines when a Prometheus deployment is paused, no actions except for deletion will be performed on the underlying objects.
     */
    @JsonProperty("paused")
    public Boolean getPaused() {
        return paused;
    }

    /**
     * paused defines when a Prometheus deployment is paused, no actions except for deletion will be performed on the underlying objects.
     */
    @JsonProperty("paused")
    public void setPaused(Boolean paused) {
        this.paused = paused;
    }

    /**
     * PrometheusAgentSpec is a specification of the desired behavior of the Prometheus agent. More info: https://github.com/kubernetes/community/blob/master/contributors/devel/sig-architecture/api-conventions.md#spec-and-status
     */
    @JsonProperty("persistentVolumeClaimRetentionPolicy")
    public StatefulSetPersistentVolumeClaimRetentionPolicy getPersistentVolumeClaimRetentionPolicy() {
        return persistentVolumeClaimRetentionPolicy;
    }

    /**
     * PrometheusAgentSpec is a specification of the desired behavior of the Prometheus agent. More info: https://github.com/kubernetes/community/blob/master/contributors/devel/sig-architecture/api-conventions.md#spec-and-status
     */
    @JsonProperty("persistentVolumeClaimRetentionPolicy")
    public void setPersistentVolumeClaimRetentionPolicy(StatefulSetPersistentVolumeClaimRetentionPolicy persistentVolumeClaimRetentionPolicy) {
        this.persistentVolumeClaimRetentionPolicy = persistentVolumeClaimRetentionPolicy;
    }

    /**
     * podManagementPolicy defines the policy for creating/deleting pods when scaling up and down.<br><p> <br><p> Unlike the default StatefulSet behavior, the default policy is `Parallel` to avoid manual intervention in case a pod gets stuck during a rollout.<br><p> <br><p> Note that updating this value implies the recreation of the StatefulSet which incurs a service outage.
     */
    @JsonProperty("podManagementPolicy")
    public String getPodManagementPolicy() {
        return podManagementPolicy;
    }

    /**
     * podManagementPolicy defines the policy for creating/deleting pods when scaling up and down.<br><p> <br><p> Unlike the default StatefulSet behavior, the default policy is `Parallel` to avoid manual intervention in case a pod gets stuck during a rollout.<br><p> <br><p> Note that updating this value implies the recreation of the StatefulSet which incurs a service outage.
     */
    @JsonProperty("podManagementPolicy")
    public void setPodManagementPolicy(String podManagementPolicy) {
        this.podManagementPolicy = podManagementPolicy;
    }

    /**
     * PrometheusAgentSpec is a specification of the desired behavior of the Prometheus agent. More info: https://github.com/kubernetes/community/blob/master/contributors/devel/sig-architecture/api-conventions.md#spec-and-status
     */
    @JsonProperty("podMetadata")
    public EmbeddedObjectMetadata getPodMetadata() {
        return podMetadata;
    }

    /**
     * PrometheusAgentSpec is a specification of the desired behavior of the Prometheus agent. More info: https://github.com/kubernetes/community/blob/master/contributors/devel/sig-architecture/api-conventions.md#spec-and-status
     */
    @JsonProperty("podMetadata")
    public void setPodMetadata(EmbeddedObjectMetadata podMetadata) {
        this.podMetadata = podMetadata;
    }

    /**
     * PrometheusAgentSpec is a specification of the desired behavior of the Prometheus agent. More info: https://github.com/kubernetes/community/blob/master/contributors/devel/sig-architecture/api-conventions.md#spec-and-status
     */
    @JsonProperty("podMonitorNamespaceSelector")
    public LabelSelector getPodMonitorNamespaceSelector() {
        return podMonitorNamespaceSelector;
    }

    /**
     * PrometheusAgentSpec is a specification of the desired behavior of the Prometheus agent. More info: https://github.com/kubernetes/community/blob/master/contributors/devel/sig-architecture/api-conventions.md#spec-and-status
     */
    @JsonProperty("podMonitorNamespaceSelector")
    public void setPodMonitorNamespaceSelector(LabelSelector podMonitorNamespaceSelector) {
        this.podMonitorNamespaceSelector = podMonitorNamespaceSelector;
    }

    /**
     * PrometheusAgentSpec is a specification of the desired behavior of the Prometheus agent. More info: https://github.com/kubernetes/community/blob/master/contributors/devel/sig-architecture/api-conventions.md#spec-and-status
     */
    @JsonProperty("podMonitorSelector")
    public LabelSelector getPodMonitorSelector() {
        return podMonitorSelector;
    }

    /**
     * PrometheusAgentSpec is a specification of the desired behavior of the Prometheus agent. More info: https://github.com/kubernetes/community/blob/master/contributors/devel/sig-architecture/api-conventions.md#spec-and-status
     */
    @JsonProperty("podMonitorSelector")
    public void setPodMonitorSelector(LabelSelector podMonitorSelector) {
        this.podMonitorSelector = podMonitorSelector;
    }

    /**
     * podTargetLabels are appended to the `spec.podTargetLabels` field of all PodMonitor and ServiceMonitor objects.
     */
    @JsonProperty("podTargetLabels")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getPodTargetLabels() {
        return podTargetLabels;
    }

    /**
     * podTargetLabels are appended to the `spec.podTargetLabels` field of all PodMonitor and ServiceMonitor objects.
     */
    @JsonProperty("podTargetLabels")
    public void setPodTargetLabels(List<String> podTargetLabels) {
        this.podTargetLabels = podTargetLabels;
    }

    /**
     * portName used for the pods and governing service. Default: "web"
     */
    @JsonProperty("portName")
    public String getPortName() {
        return portName;
    }

    /**
     * portName used for the pods and governing service. Default: "web"
     */
    @JsonProperty("portName")
    public void setPortName(String portName) {
        this.portName = portName;
    }

    /**
     * priorityClassName assigned to the Pods.
     */
    @JsonProperty("priorityClassName")
    public String getPriorityClassName() {
        return priorityClassName;
    }

    /**
     * priorityClassName assigned to the Pods.
     */
    @JsonProperty("priorityClassName")
    public void setPriorityClassName(String priorityClassName) {
        this.priorityClassName = priorityClassName;
    }

    /**
     * PrometheusAgentSpec is a specification of the desired behavior of the Prometheus agent. More info: https://github.com/kubernetes/community/blob/master/contributors/devel/sig-architecture/api-conventions.md#spec-and-status
     */
    @JsonProperty("probeNamespaceSelector")
    public LabelSelector getProbeNamespaceSelector() {
        return probeNamespaceSelector;
    }

    /**
     * PrometheusAgentSpec is a specification of the desired behavior of the Prometheus agent. More info: https://github.com/kubernetes/community/blob/master/contributors/devel/sig-architecture/api-conventions.md#spec-and-status
     */
    @JsonProperty("probeNamespaceSelector")
    public void setProbeNamespaceSelector(LabelSelector probeNamespaceSelector) {
        this.probeNamespaceSelector = probeNamespaceSelector;
    }

    /**
     * PrometheusAgentSpec is a specification of the desired behavior of the Prometheus agent. More info: https://github.com/kubernetes/community/blob/master/contributors/devel/sig-architecture/api-conventions.md#spec-and-status
     */
    @JsonProperty("probeSelector")
    public LabelSelector getProbeSelector() {
        return probeSelector;
    }

    /**
     * PrometheusAgentSpec is a specification of the desired behavior of the Prometheus agent. More info: https://github.com/kubernetes/community/blob/master/contributors/devel/sig-architecture/api-conventions.md#spec-and-status
     */
    @JsonProperty("probeSelector")
    public void setProbeSelector(LabelSelector probeSelector) {
        this.probeSelector = probeSelector;
    }

    /**
     * prometheusExternalLabelName defines the name of Prometheus external label used to denote the Prometheus instance name. The external label will _not_ be added when the field is set to the empty string (`""`).<br><p> <br><p> Default: "prometheus"
     */
    @JsonProperty("prometheusExternalLabelName")
    public String getPrometheusExternalLabelName() {
        return prometheusExternalLabelName;
    }

    /**
     * prometheusExternalLabelName defines the name of Prometheus external label used to denote the Prometheus instance name. The external label will _not_ be added when the field is set to the empty string (`""`).<br><p> <br><p> Default: "prometheus"
     */
    @JsonProperty("prometheusExternalLabelName")
    public void setPrometheusExternalLabelName(String prometheusExternalLabelName) {
        this.prometheusExternalLabelName = prometheusExternalLabelName;
    }

    /**
     * reloadStrategy defines the strategy used to reload the Prometheus configuration. If not specified, the configuration is reloaded using the /-/reload HTTP endpoint.
     */
    @JsonProperty("reloadStrategy")
    public String getReloadStrategy() {
        return reloadStrategy;
    }

    /**
     * reloadStrategy defines the strategy used to reload the Prometheus configuration. If not specified, the configuration is reloaded using the /-/reload HTTP endpoint.
     */
    @JsonProperty("reloadStrategy")
    public void setReloadStrategy(String reloadStrategy) {
        this.reloadStrategy = reloadStrategy;
    }

    /**
     * remoteWrite defines the list of remote write configurations.
     */
    @JsonProperty("remoteWrite")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<RemoteWriteSpec> getRemoteWrite() {
        return remoteWrite;
    }

    /**
     * remoteWrite defines the list of remote write configurations.
     */
    @JsonProperty("remoteWrite")
    public void setRemoteWrite(List<RemoteWriteSpec> remoteWrite) {
        this.remoteWrite = remoteWrite;
    }

    /**
     * remoteWriteReceiverMessageVersions list of the protobuf message versions to accept when receiving the remote writes.<br><p> <br><p> It requires Prometheus &gt;= v2.54.0.
     */
    @JsonProperty("remoteWriteReceiverMessageVersions")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getRemoteWriteReceiverMessageVersions() {
        return remoteWriteReceiverMessageVersions;
    }

    /**
     * remoteWriteReceiverMessageVersions list of the protobuf message versions to accept when receiving the remote writes.<br><p> <br><p> It requires Prometheus &gt;= v2.54.0.
     */
    @JsonProperty("remoteWriteReceiverMessageVersions")
    public void setRemoteWriteReceiverMessageVersions(List<String> remoteWriteReceiverMessageVersions) {
        this.remoteWriteReceiverMessageVersions = remoteWriteReceiverMessageVersions;
    }

    /**
     * replicaExternalLabelName defines the name of Prometheus external label used to denote the replica name. The external label will _not_ be added when the field is set to the empty string (`""`).<br><p> <br><p> Default: "prometheus_replica"
     */
    @JsonProperty("replicaExternalLabelName")
    public String getReplicaExternalLabelName() {
        return replicaExternalLabelName;
    }

    /**
     * replicaExternalLabelName defines the name of Prometheus external label used to denote the replica name. The external label will _not_ be added when the field is set to the empty string (`""`).<br><p> <br><p> Default: "prometheus_replica"
     */
    @JsonProperty("replicaExternalLabelName")
    public void setReplicaExternalLabelName(String replicaExternalLabelName) {
        this.replicaExternalLabelName = replicaExternalLabelName;
    }

    /**
     * replicas defines the number of replicas of each shard to deploy for a Prometheus deployment. `spec.replicas` multiplied by `spec.shards` is the total number of Pods created.<br><p> <br><p> Default: 1
     */
    @JsonProperty("replicas")
    public Integer getReplicas() {
        return replicas;
    }

    /**
     * replicas defines the number of replicas of each shard to deploy for a Prometheus deployment. `spec.replicas` multiplied by `spec.shards` is the total number of Pods created.<br><p> <br><p> Default: 1
     */
    @JsonProperty("replicas")
    public void setReplicas(Integer replicas) {
        this.replicas = replicas;
    }

    /**
     * PrometheusAgentSpec is a specification of the desired behavior of the Prometheus agent. More info: https://github.com/kubernetes/community/blob/master/contributors/devel/sig-architecture/api-conventions.md#spec-and-status
     */
    @JsonProperty("resources")
    public ResourceRequirements getResources() {
        return resources;
    }

    /**
     * PrometheusAgentSpec is a specification of the desired behavior of the Prometheus agent. More info: https://github.com/kubernetes/community/blob/master/contributors/devel/sig-architecture/api-conventions.md#spec-and-status
     */
    @JsonProperty("resources")
    public void setResources(ResourceRequirements resources) {
        this.resources = resources;
    }

    /**
     * routePrefix defines the route prefix Prometheus registers HTTP handlers for.<br><p> <br><p> This is useful when using `spec.externalURL`, and a proxy is rewriting HTTP routes of a request, and the actual ExternalURL is still true, but the server serves requests under a different route prefix. For example for use with `kubectl proxy`.
     */
    @JsonProperty("routePrefix")
    public String getRoutePrefix() {
        return routePrefix;
    }

    /**
     * routePrefix defines the route prefix Prometheus registers HTTP handlers for.<br><p> <br><p> This is useful when using `spec.externalURL`, and a proxy is rewriting HTTP routes of a request, and the actual ExternalURL is still true, but the server serves requests under a different route prefix. For example for use with `kubectl proxy`.
     */
    @JsonProperty("routePrefix")
    public void setRoutePrefix(String routePrefix) {
        this.routePrefix = routePrefix;
    }

    /**
     * PrometheusAgentSpec is a specification of the desired behavior of the Prometheus agent. More info: https://github.com/kubernetes/community/blob/master/contributors/devel/sig-architecture/api-conventions.md#spec-and-status
     */
    @JsonProperty("runtime")
    public RuntimeConfig getRuntime() {
        return runtime;
    }

    /**
     * PrometheusAgentSpec is a specification of the desired behavior of the Prometheus agent. More info: https://github.com/kubernetes/community/blob/master/contributors/devel/sig-architecture/api-conventions.md#spec-and-status
     */
    @JsonProperty("runtime")
    public void setRuntime(RuntimeConfig runtime) {
        this.runtime = runtime;
    }

    /**
     * sampleLimit defines per-scrape limit on number of scraped samples that will be accepted. Only valid in Prometheus versions 2.45.0 and newer.<br><p> <br><p> Note that the global limit only applies to scrape objects that don't specify an explicit limit value. If you want to enforce a maximum limit for all scrape objects, refer to enforcedSampleLimit.
     */
    @JsonProperty("sampleLimit")
    public Long getSampleLimit() {
        return sampleLimit;
    }

    /**
     * sampleLimit defines per-scrape limit on number of scraped samples that will be accepted. Only valid in Prometheus versions 2.45.0 and newer.<br><p> <br><p> Note that the global limit only applies to scrape objects that don't specify an explicit limit value. If you want to enforce a maximum limit for all scrape objects, refer to enforcedSampleLimit.
     */
    @JsonProperty("sampleLimit")
    public void setSampleLimit(Long sampleLimit) {
        this.sampleLimit = sampleLimit;
    }

    /**
     * schedulerName defines the scheduler to use for Pod scheduling. If not specified, the default scheduler is used.
     */
    @JsonProperty("schedulerName")
    public String getSchedulerName() {
        return schedulerName;
    }

    /**
     * schedulerName defines the scheduler to use for Pod scheduling. If not specified, the default scheduler is used.
     */
    @JsonProperty("schedulerName")
    public void setSchedulerName(String schedulerName) {
        this.schedulerName = schedulerName;
    }

    /**
     * scrapeClasses defines the list of scrape classes to expose to scraping objects such as PodMonitors, ServiceMonitors, Probes and ScrapeConfigs.<br><p> <br><p> This is an &#42;experimental feature&#42;, it may change in any upcoming release in a breaking way.
     */
    @JsonProperty("scrapeClasses")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<ScrapeClass> getScrapeClasses() {
        return scrapeClasses;
    }

    /**
     * scrapeClasses defines the list of scrape classes to expose to scraping objects such as PodMonitors, ServiceMonitors, Probes and ScrapeConfigs.<br><p> <br><p> This is an &#42;experimental feature&#42;, it may change in any upcoming release in a breaking way.
     */
    @JsonProperty("scrapeClasses")
    public void setScrapeClasses(List<ScrapeClass> scrapeClasses) {
        this.scrapeClasses = scrapeClasses;
    }

    /**
     * scrapeClassicHistograms defines whether to scrape a classic histogram that is also exposed as a native histogram.<br><p> <br><p> Notice: `scrapeClassicHistograms` corresponds to the `always_scrape_classic_histograms` field in the Prometheus configuration.<br><p> <br><p> It requires Prometheus &gt;= v3.5.0.
     */
    @JsonProperty("scrapeClassicHistograms")
    public Boolean getScrapeClassicHistograms() {
        return scrapeClassicHistograms;
    }

    /**
     * scrapeClassicHistograms defines whether to scrape a classic histogram that is also exposed as a native histogram.<br><p> <br><p> Notice: `scrapeClassicHistograms` corresponds to the `always_scrape_classic_histograms` field in the Prometheus configuration.<br><p> <br><p> It requires Prometheus &gt;= v3.5.0.
     */
    @JsonProperty("scrapeClassicHistograms")
    public void setScrapeClassicHistograms(Boolean scrapeClassicHistograms) {
        this.scrapeClassicHistograms = scrapeClassicHistograms;
    }

    /**
     * PrometheusAgentSpec is a specification of the desired behavior of the Prometheus agent. More info: https://github.com/kubernetes/community/blob/master/contributors/devel/sig-architecture/api-conventions.md#spec-and-status
     */
    @JsonProperty("scrapeConfigNamespaceSelector")
    public LabelSelector getScrapeConfigNamespaceSelector() {
        return scrapeConfigNamespaceSelector;
    }

    /**
     * PrometheusAgentSpec is a specification of the desired behavior of the Prometheus agent. More info: https://github.com/kubernetes/community/blob/master/contributors/devel/sig-architecture/api-conventions.md#spec-and-status
     */
    @JsonProperty("scrapeConfigNamespaceSelector")
    public void setScrapeConfigNamespaceSelector(LabelSelector scrapeConfigNamespaceSelector) {
        this.scrapeConfigNamespaceSelector = scrapeConfigNamespaceSelector;
    }

    /**
     * PrometheusAgentSpec is a specification of the desired behavior of the Prometheus agent. More info: https://github.com/kubernetes/community/blob/master/contributors/devel/sig-architecture/api-conventions.md#spec-and-status
     */
    @JsonProperty("scrapeConfigSelector")
    public LabelSelector getScrapeConfigSelector() {
        return scrapeConfigSelector;
    }

    /**
     * PrometheusAgentSpec is a specification of the desired behavior of the Prometheus agent. More info: https://github.com/kubernetes/community/blob/master/contributors/devel/sig-architecture/api-conventions.md#spec-and-status
     */
    @JsonProperty("scrapeConfigSelector")
    public void setScrapeConfigSelector(LabelSelector scrapeConfigSelector) {
        this.scrapeConfigSelector = scrapeConfigSelector;
    }

    /**
     * scrapeFailureLogFile defines the file to which scrape failures are logged. Reloading the configuration will reopen the file.<br><p> <br><p> If the filename has an empty path, e.g. 'file.log', The Prometheus Pods will mount the file into an emptyDir volume at `/var/log/prometheus`. If a full path is provided, e.g. '/var/log/prometheus/file.log', you must mount a volume in the specified directory and it must be writable. It requires Prometheus &gt;= v2.55.0.
     */
    @JsonProperty("scrapeFailureLogFile")
    public String getScrapeFailureLogFile() {
        return scrapeFailureLogFile;
    }

    /**
     * scrapeFailureLogFile defines the file to which scrape failures are logged. Reloading the configuration will reopen the file.<br><p> <br><p> If the filename has an empty path, e.g. 'file.log', The Prometheus Pods will mount the file into an emptyDir volume at `/var/log/prometheus`. If a full path is provided, e.g. '/var/log/prometheus/file.log', you must mount a volume in the specified directory and it must be writable. It requires Prometheus &gt;= v2.55.0.
     */
    @JsonProperty("scrapeFailureLogFile")
    public void setScrapeFailureLogFile(String scrapeFailureLogFile) {
        this.scrapeFailureLogFile = scrapeFailureLogFile;
    }

    /**
     * scrapeInterval defines interval between consecutive scrapes.<br><p> <br><p> Default: "30s"
     */
    @JsonProperty("scrapeInterval")
    public String getScrapeInterval() {
        return scrapeInterval;
    }

    /**
     * scrapeInterval defines interval between consecutive scrapes.<br><p> <br><p> Default: "30s"
     */
    @JsonProperty("scrapeInterval")
    public void setScrapeInterval(String scrapeInterval) {
        this.scrapeInterval = scrapeInterval;
    }

    /**
     * scrapeNativeHistograms defines whether to enable scraping of native histograms. It requires Prometheus &gt;= v3.8.0.
     */
    @JsonProperty("scrapeNativeHistograms")
    public Boolean getScrapeNativeHistograms() {
        return scrapeNativeHistograms;
    }

    /**
     * scrapeNativeHistograms defines whether to enable scraping of native histograms. It requires Prometheus &gt;= v3.8.0.
     */
    @JsonProperty("scrapeNativeHistograms")
    public void setScrapeNativeHistograms(Boolean scrapeNativeHistograms) {
        this.scrapeNativeHistograms = scrapeNativeHistograms;
    }

    /**
     * scrapeProtocols defines the protocols to negotiate during a scrape. It tells clients the protocols supported by Prometheus in order of preference (from most to least preferred).<br><p> <br><p> If unset, Prometheus uses its default value.<br><p> <br><p> It requires Prometheus &gt;= v2.49.0.<br><p> <br><p> `PrometheusText1.0.0` requires Prometheus &gt;= v3.0.0.
     */
    @JsonProperty("scrapeProtocols")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getScrapeProtocols() {
        return scrapeProtocols;
    }

    /**
     * scrapeProtocols defines the protocols to negotiate during a scrape. It tells clients the protocols supported by Prometheus in order of preference (from most to least preferred).<br><p> <br><p> If unset, Prometheus uses its default value.<br><p> <br><p> It requires Prometheus &gt;= v2.49.0.<br><p> <br><p> `PrometheusText1.0.0` requires Prometheus &gt;= v3.0.0.
     */
    @JsonProperty("scrapeProtocols")
    public void setScrapeProtocols(List<String> scrapeProtocols) {
        this.scrapeProtocols = scrapeProtocols;
    }

    /**
     * scrapeTimeout defines the number of seconds to wait until a scrape request times out. The value cannot be greater than the scrape interval otherwise the operator will reject the resource.
     */
    @JsonProperty("scrapeTimeout")
    public String getScrapeTimeout() {
        return scrapeTimeout;
    }

    /**
     * scrapeTimeout defines the number of seconds to wait until a scrape request times out. The value cannot be greater than the scrape interval otherwise the operator will reject the resource.
     */
    @JsonProperty("scrapeTimeout")
    public void setScrapeTimeout(String scrapeTimeout) {
        this.scrapeTimeout = scrapeTimeout;
    }

    /**
     * secrets defines a list of Secrets in the same namespace as the Prometheus object, which shall be mounted into the Prometheus Pods. Each Secret is added to the StatefulSet definition as a volume named `secret-&lt;secret-name&gt;`. The Secrets are mounted into /etc/prometheus/secrets/&lt;secret-name&gt; in the 'prometheus' container.
     */
    @JsonProperty("secrets")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getSecrets() {
        return secrets;
    }

    /**
     * secrets defines a list of Secrets in the same namespace as the Prometheus object, which shall be mounted into the Prometheus Pods. Each Secret is added to the StatefulSet definition as a volume named `secret-&lt;secret-name&gt;`. The Secrets are mounted into /etc/prometheus/secrets/&lt;secret-name&gt; in the 'prometheus' container.
     */
    @JsonProperty("secrets")
    public void setSecrets(List<String> secrets) {
        this.secrets = secrets;
    }

    /**
     * PrometheusAgentSpec is a specification of the desired behavior of the Prometheus agent. More info: https://github.com/kubernetes/community/blob/master/contributors/devel/sig-architecture/api-conventions.md#spec-and-status
     */
    @JsonProperty("securityContext")
    public PodSecurityContext getSecurityContext() {
        return securityContext;
    }

    /**
     * PrometheusAgentSpec is a specification of the desired behavior of the Prometheus agent. More info: https://github.com/kubernetes/community/blob/master/contributors/devel/sig-architecture/api-conventions.md#spec-and-status
     */
    @JsonProperty("securityContext")
    public void setSecurityContext(PodSecurityContext securityContext) {
        this.securityContext = securityContext;
    }

    /**
     * serviceAccountName is the name of the ServiceAccount to use to run the Prometheus Pods.
     */
    @JsonProperty("serviceAccountName")
    public String getServiceAccountName() {
        return serviceAccountName;
    }

    /**
     * serviceAccountName is the name of the ServiceAccount to use to run the Prometheus Pods.
     */
    @JsonProperty("serviceAccountName")
    public void setServiceAccountName(String serviceAccountName) {
        this.serviceAccountName = serviceAccountName;
    }

    /**
     * serviceDiscoveryRole defines the service discovery role used to discover targets from `ServiceMonitor` objects and Alertmanager endpoints.<br><p> <br><p> If set, the value should be either "Endpoints" or "EndpointSlice". If unset, the operator assumes the "Endpoints" role.
     */
    @JsonProperty("serviceDiscoveryRole")
    public String getServiceDiscoveryRole() {
        return serviceDiscoveryRole;
    }

    /**
     * serviceDiscoveryRole defines the service discovery role used to discover targets from `ServiceMonitor` objects and Alertmanager endpoints.<br><p> <br><p> If set, the value should be either "Endpoints" or "EndpointSlice". If unset, the operator assumes the "Endpoints" role.
     */
    @JsonProperty("serviceDiscoveryRole")
    public void setServiceDiscoveryRole(String serviceDiscoveryRole) {
        this.serviceDiscoveryRole = serviceDiscoveryRole;
    }

    /**
     * PrometheusAgentSpec is a specification of the desired behavior of the Prometheus agent. More info: https://github.com/kubernetes/community/blob/master/contributors/devel/sig-architecture/api-conventions.md#spec-and-status
     */
    @JsonProperty("serviceMonitorNamespaceSelector")
    public LabelSelector getServiceMonitorNamespaceSelector() {
        return serviceMonitorNamespaceSelector;
    }

    /**
     * PrometheusAgentSpec is a specification of the desired behavior of the Prometheus agent. More info: https://github.com/kubernetes/community/blob/master/contributors/devel/sig-architecture/api-conventions.md#spec-and-status
     */
    @JsonProperty("serviceMonitorNamespaceSelector")
    public void setServiceMonitorNamespaceSelector(LabelSelector serviceMonitorNamespaceSelector) {
        this.serviceMonitorNamespaceSelector = serviceMonitorNamespaceSelector;
    }

    /**
     * PrometheusAgentSpec is a specification of the desired behavior of the Prometheus agent. More info: https://github.com/kubernetes/community/blob/master/contributors/devel/sig-architecture/api-conventions.md#spec-and-status
     */
    @JsonProperty("serviceMonitorSelector")
    public LabelSelector getServiceMonitorSelector() {
        return serviceMonitorSelector;
    }

    /**
     * PrometheusAgentSpec is a specification of the desired behavior of the Prometheus agent. More info: https://github.com/kubernetes/community/blob/master/contributors/devel/sig-architecture/api-conventions.md#spec-and-status
     */
    @JsonProperty("serviceMonitorSelector")
    public void setServiceMonitorSelector(LabelSelector serviceMonitorSelector) {
        this.serviceMonitorSelector = serviceMonitorSelector;
    }

    /**
     * serviceName defines the name of the service name used by the underlying StatefulSet(s) as the governing service. If defined, the Service  must be created before the Prometheus/PrometheusAgent resource in the same namespace and it must define a selector that matches the pod labels. If empty, the operator will create and manage a headless service named `prometheus-operated` for Prometheus resources, or `prometheus-agent-operated` for PrometheusAgent resources. When deploying multiple Prometheus/PrometheusAgent resources in the same namespace, it is recommended to specify a different value for each. See https://kubernetes.io/docs/concepts/workloads/controllers/statefulset/#stable-network-id for more details.
     */
    @JsonProperty("serviceName")
    public String getServiceName() {
        return serviceName;
    }

    /**
     * serviceName defines the name of the service name used by the underlying StatefulSet(s) as the governing service. If defined, the Service  must be created before the Prometheus/PrometheusAgent resource in the same namespace and it must define a selector that matches the pod labels. If empty, the operator will create and manage a headless service named `prometheus-operated` for Prometheus resources, or `prometheus-agent-operated` for PrometheusAgent resources. When deploying multiple Prometheus/PrometheusAgent resources in the same namespace, it is recommended to specify a different value for each. See https://kubernetes.io/docs/concepts/workloads/controllers/statefulset/#stable-network-id for more details.
     */
    @JsonProperty("serviceName")
    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    /**
     * PrometheusAgentSpec is a specification of the desired behavior of the Prometheus agent. More info: https://github.com/kubernetes/community/blob/master/contributors/devel/sig-architecture/api-conventions.md#spec-and-status
     */
    @JsonProperty("shardingStrategy")
    public ShardingStrategy getShardingStrategy() {
        return shardingStrategy;
    }

    /**
     * PrometheusAgentSpec is a specification of the desired behavior of the Prometheus agent. More info: https://github.com/kubernetes/community/blob/master/contributors/devel/sig-architecture/api-conventions.md#spec-and-status
     */
    @JsonProperty("shardingStrategy")
    public void setShardingStrategy(ShardingStrategy shardingStrategy) {
        this.shardingStrategy = shardingStrategy;
    }

    /**
     * shards defines the number of shards to distribute the scraped targets onto.<br><p> <br><p> `spec.replicas` multiplied by `spec.shards` is the total number of Pods being created.<br><p> <br><p> When not defined, the operator assumes only one shard.<br><p> <br><p> Note that scaling down shards will not reshard data onto the remaining instances, it must be manually moved. Increasing shards will not reshard data either but it will continue to be available from the same instances. To query globally, use either &#42; Thanos sidecar + querier for query federation and Thanos Ruler for rules. &#42; Remote-write to send metrics to a central location.<br><p> <br><p> By default, the sharding of targets is performed on: &#42; The `__address__` target's metadata label for PodMonitor, ServiceMonitor and ScrapeConfig resources. &#42; The `__param_target__` label for Probe resources.<br><p> <br><p> Users can define their own sharding implementation by setting the `__tmp_hash` label during the target discovery with relabeling configuration (either in the monitoring resources or via scrape class).<br><p> <br><p> You can also disable sharding on a specific target by setting the `__tmp_disable_sharding` label with relabeling configuration. When the label value isn't empty, all Prometheus shards will scrape the target.
     */
    @JsonProperty("shards")
    public Integer getShards() {
        return shards;
    }

    /**
     * shards defines the number of shards to distribute the scraped targets onto.<br><p> <br><p> `spec.replicas` multiplied by `spec.shards` is the total number of Pods being created.<br><p> <br><p> When not defined, the operator assumes only one shard.<br><p> <br><p> Note that scaling down shards will not reshard data onto the remaining instances, it must be manually moved. Increasing shards will not reshard data either but it will continue to be available from the same instances. To query globally, use either &#42; Thanos sidecar + querier for query federation and Thanos Ruler for rules. &#42; Remote-write to send metrics to a central location.<br><p> <br><p> By default, the sharding of targets is performed on: &#42; The `__address__` target's metadata label for PodMonitor, ServiceMonitor and ScrapeConfig resources. &#42; The `__param_target__` label for Probe resources.<br><p> <br><p> Users can define their own sharding implementation by setting the `__tmp_hash` label during the target discovery with relabeling configuration (either in the monitoring resources or via scrape class).<br><p> <br><p> You can also disable sharding on a specific target by setting the `__tmp_disable_sharding` label with relabeling configuration. When the label value isn't empty, all Prometheus shards will scrape the target.
     */
    @JsonProperty("shards")
    public void setShards(Integer shards) {
        this.shards = shards;
    }

    /**
     * PrometheusAgentSpec is a specification of the desired behavior of the Prometheus agent. More info: https://github.com/kubernetes/community/blob/master/contributors/devel/sig-architecture/api-conventions.md#spec-and-status
     */
    @JsonProperty("storage")
    public StorageSpec getStorage() {
        return storage;
    }

    /**
     * PrometheusAgentSpec is a specification of the desired behavior of the Prometheus agent. More info: https://github.com/kubernetes/community/blob/master/contributors/devel/sig-architecture/api-conventions.md#spec-and-status
     */
    @JsonProperty("storage")
    public void setStorage(StorageSpec storage) {
        this.storage = storage;
    }

    /**
     * targetLimit defines a limit on the number of scraped targets that will be accepted. Only valid in Prometheus versions 2.45.0 and newer.<br><p> <br><p> Note that the global limit only applies to scrape objects that don't specify an explicit limit value. If you want to enforce a maximum limit for all scrape objects, refer to enforcedTargetLimit.
     */
    @JsonProperty("targetLimit")
    public Long getTargetLimit() {
        return targetLimit;
    }

    /**
     * targetLimit defines a limit on the number of scraped targets that will be accepted. Only valid in Prometheus versions 2.45.0 and newer.<br><p> <br><p> Note that the global limit only applies to scrape objects that don't specify an explicit limit value. If you want to enforce a maximum limit for all scrape objects, refer to enforcedTargetLimit.
     */
    @JsonProperty("targetLimit")
    public void setTargetLimit(Long targetLimit) {
        this.targetLimit = targetLimit;
    }

    /**
     * terminationGracePeriodSeconds defines the optional duration in seconds the pod needs to terminate gracefully. Value must be non-negative integer. The value zero indicates stop immediately via the kill signal (no opportunity to shut down) which may lead to data corruption.<br><p> <br><p> Defaults to 600 seconds.
     */
    @JsonProperty("terminationGracePeriodSeconds")
    public Long getTerminationGracePeriodSeconds() {
        return terminationGracePeriodSeconds;
    }

    /**
     * terminationGracePeriodSeconds defines the optional duration in seconds the pod needs to terminate gracefully. Value must be non-negative integer. The value zero indicates stop immediately via the kill signal (no opportunity to shut down) which may lead to data corruption.<br><p> <br><p> Defaults to 600 seconds.
     */
    @JsonProperty("terminationGracePeriodSeconds")
    public void setTerminationGracePeriodSeconds(Long terminationGracePeriodSeconds) {
        this.terminationGracePeriodSeconds = terminationGracePeriodSeconds;
    }

    /**
     * tolerations defines the Pods' tolerations if specified.
     */
    @JsonProperty("tolerations")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<Toleration> getTolerations() {
        return tolerations;
    }

    /**
     * tolerations defines the Pods' tolerations if specified.
     */
    @JsonProperty("tolerations")
    public void setTolerations(List<Toleration> tolerations) {
        this.tolerations = tolerations;
    }

    /**
     * topologySpreadConstraints defines the pod's topology spread constraints if specified.
     */
    @JsonProperty("topologySpreadConstraints")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<TopologySpreadConstraint> getTopologySpreadConstraints() {
        return topologySpreadConstraints;
    }

    /**
     * topologySpreadConstraints defines the pod's topology spread constraints if specified.
     */
    @JsonProperty("topologySpreadConstraints")
    public void setTopologySpreadConstraints(List<TopologySpreadConstraint> topologySpreadConstraints) {
        this.topologySpreadConstraints = topologySpreadConstraints;
    }

    /**
     * PrometheusAgentSpec is a specification of the desired behavior of the Prometheus agent. More info: https://github.com/kubernetes/community/blob/master/contributors/devel/sig-architecture/api-conventions.md#spec-and-status
     */
    @JsonProperty("tracingConfig")
    public TracingConfig getTracingConfig() {
        return tracingConfig;
    }

    /**
     * PrometheusAgentSpec is a specification of the desired behavior of the Prometheus agent. More info: https://github.com/kubernetes/community/blob/master/contributors/devel/sig-architecture/api-conventions.md#spec-and-status
     */
    @JsonProperty("tracingConfig")
    public void setTracingConfig(TracingConfig tracingConfig) {
        this.tracingConfig = tracingConfig;
    }

    /**
     * PrometheusAgentSpec is a specification of the desired behavior of the Prometheus agent. More info: https://github.com/kubernetes/community/blob/master/contributors/devel/sig-architecture/api-conventions.md#spec-and-status
     */
    @JsonProperty("tsdb")
    public TSDBSpec getTsdb() {
        return tsdb;
    }

    /**
     * PrometheusAgentSpec is a specification of the desired behavior of the Prometheus agent. More info: https://github.com/kubernetes/community/blob/master/contributors/devel/sig-architecture/api-conventions.md#spec-and-status
     */
    @JsonProperty("tsdb")
    public void setTsdb(TSDBSpec tsdb) {
        this.tsdb = tsdb;
    }

    /**
     * PrometheusAgentSpec is a specification of the desired behavior of the Prometheus agent. More info: https://github.com/kubernetes/community/blob/master/contributors/devel/sig-architecture/api-conventions.md#spec-and-status
     */
    @JsonProperty("updateStrategy")
    public StatefulSetUpdateStrategy getUpdateStrategy() {
        return updateStrategy;
    }

    /**
     * PrometheusAgentSpec is a specification of the desired behavior of the Prometheus agent. More info: https://github.com/kubernetes/community/blob/master/contributors/devel/sig-architecture/api-conventions.md#spec-and-status
     */
    @JsonProperty("updateStrategy")
    public void setUpdateStrategy(StatefulSetUpdateStrategy updateStrategy) {
        this.updateStrategy = updateStrategy;
    }

    /**
     * version of Prometheus being deployed. The operator uses this information to generate the Prometheus StatefulSet + configuration files.<br><p> <br><p> If not specified, the operator assumes the latest upstream version of Prometheus available at the time when the version of the operator was released.
     */
    @JsonProperty("version")
    public String getVersion() {
        return version;
    }

    /**
     * version of Prometheus being deployed. The operator uses this information to generate the Prometheus StatefulSet + configuration files.<br><p> <br><p> If not specified, the operator assumes the latest upstream version of Prometheus available at the time when the version of the operator was released.
     */
    @JsonProperty("version")
    public void setVersion(String version) {
        this.version = version;
    }

    /**
     * volumeMounts allows the configuration of additional VolumeMounts.<br><p> <br><p> VolumeMounts will be appended to other VolumeMounts in the 'prometheus' container, that are generated as a result of StorageSpec objects.
     */
    @JsonProperty("volumeMounts")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<VolumeMount> getVolumeMounts() {
        return volumeMounts;
    }

    /**
     * volumeMounts allows the configuration of additional VolumeMounts.<br><p> <br><p> VolumeMounts will be appended to other VolumeMounts in the 'prometheus' container, that are generated as a result of StorageSpec objects.
     */
    @JsonProperty("volumeMounts")
    public void setVolumeMounts(List<VolumeMount> volumeMounts) {
        this.volumeMounts = volumeMounts;
    }

    /**
     * volumes allows the configuration of additional volumes on the output StatefulSet definition. Volumes specified will be appended to other volumes that are generated as a result of StorageSpec objects.
     */
    @JsonProperty("volumes")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<Volume> getVolumes() {
        return volumes;
    }

    /**
     * volumes allows the configuration of additional volumes on the output StatefulSet definition. Volumes specified will be appended to other volumes that are generated as a result of StorageSpec objects.
     */
    @JsonProperty("volumes")
    public void setVolumes(List<Volume> volumes) {
        this.volumes = volumes;
    }

    /**
     * walCompression defines the compression of the write-ahead log (WAL) using Snappy.<br><p> <br><p> WAL compression is enabled by default for Prometheus &gt;= 2.20.0<br><p> <br><p> Requires Prometheus v2.11.0 and above.
     */
    @JsonProperty("walCompression")
    public Boolean getWalCompression() {
        return walCompression;
    }

    /**
     * walCompression defines the compression of the write-ahead log (WAL) using Snappy.<br><p> <br><p> WAL compression is enabled by default for Prometheus &gt;= 2.20.0<br><p> <br><p> Requires Prometheus v2.11.0 and above.
     */
    @JsonProperty("walCompression")
    public void setWalCompression(Boolean walCompression) {
        this.walCompression = walCompression;
    }

    /**
     * PrometheusAgentSpec is a specification of the desired behavior of the Prometheus agent. More info: https://github.com/kubernetes/community/blob/master/contributors/devel/sig-architecture/api-conventions.md#spec-and-status
     */
    @JsonProperty("web")
    public PrometheusWebSpec getWeb() {
        return web;
    }

    /**
     * PrometheusAgentSpec is a specification of the desired behavior of the Prometheus agent. More info: https://github.com/kubernetes/community/blob/master/contributors/devel/sig-architecture/api-conventions.md#spec-and-status
     */
    @JsonProperty("web")
    public void setWeb(PrometheusWebSpec web) {
        this.web = web;
    }

    @JsonIgnore
    public PrometheusAgentSpecBuilder edit() {
        return new PrometheusAgentSpecBuilder(this);
    }

    @JsonIgnore
    public PrometheusAgentSpecBuilder toBuilder() {
        return edit();
    }

    @JsonAnyGetter
    @JsonIgnore
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
    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof PrometheusAgentSpec)) {
            return false;
        }
        PrometheusAgentSpec other = (PrometheusAgentSpec) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$additionalArgs = this.getAdditionalArgs();
        Object other$additionalArgs = other.getAdditionalArgs();
        if (this$additionalArgs == null ? other$additionalArgs != null : !this$additionalArgs.equals(other$additionalArgs)) {
            return false;
        }
        Object this$additionalScrapeConfigs = this.getAdditionalScrapeConfigs();
        Object other$additionalScrapeConfigs = other.getAdditionalScrapeConfigs();
        if (this$additionalScrapeConfigs == null ? other$additionalScrapeConfigs != null : !this$additionalScrapeConfigs.equals(other$additionalScrapeConfigs)) {
            return false;
        }
        Object this$affinity = this.getAffinity();
        Object other$affinity = other.getAffinity();
        if (this$affinity == null ? other$affinity != null : !this$affinity.equals(other$affinity)) {
            return false;
        }
        Object this$apiserverConfig = this.getApiserverConfig();
        Object other$apiserverConfig = other.getApiserverConfig();
        if (this$apiserverConfig == null ? other$apiserverConfig != null : !this$apiserverConfig.equals(other$apiserverConfig)) {
            return false;
        }
        Object this$arbitraryFSAccessThroughSMs = this.getArbitraryFSAccessThroughSMs();
        Object other$arbitraryFSAccessThroughSMs = other.getArbitraryFSAccessThroughSMs();
        if (this$arbitraryFSAccessThroughSMs == null ? other$arbitraryFSAccessThroughSMs != null : !this$arbitraryFSAccessThroughSMs.equals(other$arbitraryFSAccessThroughSMs)) {
            return false;
        }
        Object this$automountServiceAccountToken = this.getAutomountServiceAccountToken();
        Object other$automountServiceAccountToken = other.getAutomountServiceAccountToken();
        if (this$automountServiceAccountToken == null ? other$automountServiceAccountToken != null : !this$automountServiceAccountToken.equals(other$automountServiceAccountToken)) {
            return false;
        }
        Object this$bodySizeLimit = this.getBodySizeLimit();
        Object other$bodySizeLimit = other.getBodySizeLimit();
        if (this$bodySizeLimit == null ? other$bodySizeLimit != null : !this$bodySizeLimit.equals(other$bodySizeLimit)) {
            return false;
        }
        Object this$configMaps = this.getConfigMaps();
        Object other$configMaps = other.getConfigMaps();
        if (this$configMaps == null ? other$configMaps != null : !this$configMaps.equals(other$configMaps)) {
            return false;
        }
        Object this$containers = this.getContainers();
        Object other$containers = other.getContainers();
        if (this$containers == null ? other$containers != null : !this$containers.equals(other$containers)) {
            return false;
        }
        Object this$convertClassicHistogramsToNHCB = this.getConvertClassicHistogramsToNHCB();
        Object other$convertClassicHistogramsToNHCB = other.getConvertClassicHistogramsToNHCB();
        if (this$convertClassicHistogramsToNHCB == null ? other$convertClassicHistogramsToNHCB != null : !this$convertClassicHistogramsToNHCB.equals(other$convertClassicHistogramsToNHCB)) {
            return false;
        }
        Object this$dnsConfig = this.getDnsConfig();
        Object other$dnsConfig = other.getDnsConfig();
        if (this$dnsConfig == null ? other$dnsConfig != null : !this$dnsConfig.equals(other$dnsConfig)) {
            return false;
        }
        Object this$dnsPolicy = this.getDnsPolicy();
        Object other$dnsPolicy = other.getDnsPolicy();
        if (this$dnsPolicy == null ? other$dnsPolicy != null : !this$dnsPolicy.equals(other$dnsPolicy)) {
            return false;
        }
        Object this$enableFeatures = this.getEnableFeatures();
        Object other$enableFeatures = other.getEnableFeatures();
        if (this$enableFeatures == null ? other$enableFeatures != null : !this$enableFeatures.equals(other$enableFeatures)) {
            return false;
        }
        Object this$enableOTLPReceiver = this.getEnableOTLPReceiver();
        Object other$enableOTLPReceiver = other.getEnableOTLPReceiver();
        if (this$enableOTLPReceiver == null ? other$enableOTLPReceiver != null : !this$enableOTLPReceiver.equals(other$enableOTLPReceiver)) {
            return false;
        }
        Object this$enableRemoteWriteReceiver = this.getEnableRemoteWriteReceiver();
        Object other$enableRemoteWriteReceiver = other.getEnableRemoteWriteReceiver();
        if (this$enableRemoteWriteReceiver == null ? other$enableRemoteWriteReceiver != null : !this$enableRemoteWriteReceiver.equals(other$enableRemoteWriteReceiver)) {
            return false;
        }
        Object this$enableServiceLinks = this.getEnableServiceLinks();
        Object other$enableServiceLinks = other.getEnableServiceLinks();
        if (this$enableServiceLinks == null ? other$enableServiceLinks != null : !this$enableServiceLinks.equals(other$enableServiceLinks)) {
            return false;
        }
        Object this$enforcedBodySizeLimit = this.getEnforcedBodySizeLimit();
        Object other$enforcedBodySizeLimit = other.getEnforcedBodySizeLimit();
        if (this$enforcedBodySizeLimit == null ? other$enforcedBodySizeLimit != null : !this$enforcedBodySizeLimit.equals(other$enforcedBodySizeLimit)) {
            return false;
        }
        Object this$enforcedKeepDroppedTargets = this.getEnforcedKeepDroppedTargets();
        Object other$enforcedKeepDroppedTargets = other.getEnforcedKeepDroppedTargets();
        if (this$enforcedKeepDroppedTargets == null ? other$enforcedKeepDroppedTargets != null : !this$enforcedKeepDroppedTargets.equals(other$enforcedKeepDroppedTargets)) {
            return false;
        }
        Object this$enforcedLabelLimit = this.getEnforcedLabelLimit();
        Object other$enforcedLabelLimit = other.getEnforcedLabelLimit();
        if (this$enforcedLabelLimit == null ? other$enforcedLabelLimit != null : !this$enforcedLabelLimit.equals(other$enforcedLabelLimit)) {
            return false;
        }
        Object this$enforcedLabelNameLengthLimit = this.getEnforcedLabelNameLengthLimit();
        Object other$enforcedLabelNameLengthLimit = other.getEnforcedLabelNameLengthLimit();
        if (this$enforcedLabelNameLengthLimit == null ? other$enforcedLabelNameLengthLimit != null : !this$enforcedLabelNameLengthLimit.equals(other$enforcedLabelNameLengthLimit)) {
            return false;
        }
        Object this$enforcedLabelValueLengthLimit = this.getEnforcedLabelValueLengthLimit();
        Object other$enforcedLabelValueLengthLimit = other.getEnforcedLabelValueLengthLimit();
        if (this$enforcedLabelValueLengthLimit == null ? other$enforcedLabelValueLengthLimit != null : !this$enforcedLabelValueLengthLimit.equals(other$enforcedLabelValueLengthLimit)) {
            return false;
        }
        Object this$enforcedNamespaceLabel = this.getEnforcedNamespaceLabel();
        Object other$enforcedNamespaceLabel = other.getEnforcedNamespaceLabel();
        if (this$enforcedNamespaceLabel == null ? other$enforcedNamespaceLabel != null : !this$enforcedNamespaceLabel.equals(other$enforcedNamespaceLabel)) {
            return false;
        }
        Object this$enforcedSampleLimit = this.getEnforcedSampleLimit();
        Object other$enforcedSampleLimit = other.getEnforcedSampleLimit();
        if (this$enforcedSampleLimit == null ? other$enforcedSampleLimit != null : !this$enforcedSampleLimit.equals(other$enforcedSampleLimit)) {
            return false;
        }
        Object this$enforcedTargetLimit = this.getEnforcedTargetLimit();
        Object other$enforcedTargetLimit = other.getEnforcedTargetLimit();
        if (this$enforcedTargetLimit == null ? other$enforcedTargetLimit != null : !this$enforcedTargetLimit.equals(other$enforcedTargetLimit)) {
            return false;
        }
        Object this$excludedFromEnforcement = this.getExcludedFromEnforcement();
        Object other$excludedFromEnforcement = other.getExcludedFromEnforcement();
        if (this$excludedFromEnforcement == null ? other$excludedFromEnforcement != null : !this$excludedFromEnforcement.equals(other$excludedFromEnforcement)) {
            return false;
        }
        Object this$externalLabels = this.getExternalLabels();
        Object other$externalLabels = other.getExternalLabels();
        if (this$externalLabels == null ? other$externalLabels != null : !this$externalLabels.equals(other$externalLabels)) {
            return false;
        }
        Object this$externalUrl = this.getExternalUrl();
        Object other$externalUrl = other.getExternalUrl();
        if (this$externalUrl == null ? other$externalUrl != null : !this$externalUrl.equals(other$externalUrl)) {
            return false;
        }
        Object this$hostAliases = this.getHostAliases();
        Object other$hostAliases = other.getHostAliases();
        if (this$hostAliases == null ? other$hostAliases != null : !this$hostAliases.equals(other$hostAliases)) {
            return false;
        }
        Object this$hostNetwork = this.getHostNetwork();
        Object other$hostNetwork = other.getHostNetwork();
        if (this$hostNetwork == null ? other$hostNetwork != null : !this$hostNetwork.equals(other$hostNetwork)) {
            return false;
        }
        Object this$hostUsers = this.getHostUsers();
        Object other$hostUsers = other.getHostUsers();
        if (this$hostUsers == null ? other$hostUsers != null : !this$hostUsers.equals(other$hostUsers)) {
            return false;
        }
        Object this$ignoreNamespaceSelectors = this.getIgnoreNamespaceSelectors();
        Object other$ignoreNamespaceSelectors = other.getIgnoreNamespaceSelectors();
        if (this$ignoreNamespaceSelectors == null ? other$ignoreNamespaceSelectors != null : !this$ignoreNamespaceSelectors.equals(other$ignoreNamespaceSelectors)) {
            return false;
        }
        Object this$image = this.getImage();
        Object other$image = other.getImage();
        if (this$image == null ? other$image != null : !this$image.equals(other$image)) {
            return false;
        }
        Object this$imagePullPolicy = this.getImagePullPolicy();
        Object other$imagePullPolicy = other.getImagePullPolicy();
        if (this$imagePullPolicy == null ? other$imagePullPolicy != null : !this$imagePullPolicy.equals(other$imagePullPolicy)) {
            return false;
        }
        Object this$imagePullSecrets = this.getImagePullSecrets();
        Object other$imagePullSecrets = other.getImagePullSecrets();
        if (this$imagePullSecrets == null ? other$imagePullSecrets != null : !this$imagePullSecrets.equals(other$imagePullSecrets)) {
            return false;
        }
        Object this$initContainers = this.getInitContainers();
        Object other$initContainers = other.getInitContainers();
        if (this$initContainers == null ? other$initContainers != null : !this$initContainers.equals(other$initContainers)) {
            return false;
        }
        Object this$keepDroppedTargets = this.getKeepDroppedTargets();
        Object other$keepDroppedTargets = other.getKeepDroppedTargets();
        if (this$keepDroppedTargets == null ? other$keepDroppedTargets != null : !this$keepDroppedTargets.equals(other$keepDroppedTargets)) {
            return false;
        }
        Object this$labelLimit = this.getLabelLimit();
        Object other$labelLimit = other.getLabelLimit();
        if (this$labelLimit == null ? other$labelLimit != null : !this$labelLimit.equals(other$labelLimit)) {
            return false;
        }
        Object this$labelNameLengthLimit = this.getLabelNameLengthLimit();
        Object other$labelNameLengthLimit = other.getLabelNameLengthLimit();
        if (this$labelNameLengthLimit == null ? other$labelNameLengthLimit != null : !this$labelNameLengthLimit.equals(other$labelNameLengthLimit)) {
            return false;
        }
        Object this$labelValueLengthLimit = this.getLabelValueLengthLimit();
        Object other$labelValueLengthLimit = other.getLabelValueLengthLimit();
        if (this$labelValueLengthLimit == null ? other$labelValueLengthLimit != null : !this$labelValueLengthLimit.equals(other$labelValueLengthLimit)) {
            return false;
        }
        Object this$listenLocal = this.getListenLocal();
        Object other$listenLocal = other.getListenLocal();
        if (this$listenLocal == null ? other$listenLocal != null : !this$listenLocal.equals(other$listenLocal)) {
            return false;
        }
        Object this$logFormat = this.getLogFormat();
        Object other$logFormat = other.getLogFormat();
        if (this$logFormat == null ? other$logFormat != null : !this$logFormat.equals(other$logFormat)) {
            return false;
        }
        Object this$logLevel = this.getLogLevel();
        Object other$logLevel = other.getLogLevel();
        if (this$logLevel == null ? other$logLevel != null : !this$logLevel.equals(other$logLevel)) {
            return false;
        }
        Object this$maximumStartupDurationSeconds = this.getMaximumStartupDurationSeconds();
        Object other$maximumStartupDurationSeconds = other.getMaximumStartupDurationSeconds();
        if (this$maximumStartupDurationSeconds == null ? other$maximumStartupDurationSeconds != null : !this$maximumStartupDurationSeconds.equals(other$maximumStartupDurationSeconds)) {
            return false;
        }
        Object this$minReadySeconds = this.getMinReadySeconds();
        Object other$minReadySeconds = other.getMinReadySeconds();
        if (this$minReadySeconds == null ? other$minReadySeconds != null : !this$minReadySeconds.equals(other$minReadySeconds)) {
            return false;
        }
        Object this$mode = this.getMode();
        Object other$mode = other.getMode();
        if (this$mode == null ? other$mode != null : !this$mode.equals(other$mode)) {
            return false;
        }
        Object this$nameEscapingScheme = this.getNameEscapingScheme();
        Object other$nameEscapingScheme = other.getNameEscapingScheme();
        if (this$nameEscapingScheme == null ? other$nameEscapingScheme != null : !this$nameEscapingScheme.equals(other$nameEscapingScheme)) {
            return false;
        }
        Object this$nameValidationScheme = this.getNameValidationScheme();
        Object other$nameValidationScheme = other.getNameValidationScheme();
        if (this$nameValidationScheme == null ? other$nameValidationScheme != null : !this$nameValidationScheme.equals(other$nameValidationScheme)) {
            return false;
        }
        Object this$nodeSelector = this.getNodeSelector();
        Object other$nodeSelector = other.getNodeSelector();
        if (this$nodeSelector == null ? other$nodeSelector != null : !this$nodeSelector.equals(other$nodeSelector)) {
            return false;
        }
        Object this$otlp = this.getOtlp();
        Object other$otlp = other.getOtlp();
        if (this$otlp == null ? other$otlp != null : !this$otlp.equals(other$otlp)) {
            return false;
        }
        Object this$overrideHonorLabels = this.getOverrideHonorLabels();
        Object other$overrideHonorLabels = other.getOverrideHonorLabels();
        if (this$overrideHonorLabels == null ? other$overrideHonorLabels != null : !this$overrideHonorLabels.equals(other$overrideHonorLabels)) {
            return false;
        }
        Object this$overrideHonorTimestamps = this.getOverrideHonorTimestamps();
        Object other$overrideHonorTimestamps = other.getOverrideHonorTimestamps();
        if (this$overrideHonorTimestamps == null ? other$overrideHonorTimestamps != null : !this$overrideHonorTimestamps.equals(other$overrideHonorTimestamps)) {
            return false;
        }
        Object this$paused = this.getPaused();
        Object other$paused = other.getPaused();
        if (this$paused == null ? other$paused != null : !this$paused.equals(other$paused)) {
            return false;
        }
        Object this$persistentVolumeClaimRetentionPolicy = this.getPersistentVolumeClaimRetentionPolicy();
        Object other$persistentVolumeClaimRetentionPolicy = other.getPersistentVolumeClaimRetentionPolicy();
        if (this$persistentVolumeClaimRetentionPolicy == null ? other$persistentVolumeClaimRetentionPolicy != null : !this$persistentVolumeClaimRetentionPolicy.equals(other$persistentVolumeClaimRetentionPolicy)) {
            return false;
        }
        Object this$podManagementPolicy = this.getPodManagementPolicy();
        Object other$podManagementPolicy = other.getPodManagementPolicy();
        if (this$podManagementPolicy == null ? other$podManagementPolicy != null : !this$podManagementPolicy.equals(other$podManagementPolicy)) {
            return false;
        }
        Object this$podMetadata = this.getPodMetadata();
        Object other$podMetadata = other.getPodMetadata();
        if (this$podMetadata == null ? other$podMetadata != null : !this$podMetadata.equals(other$podMetadata)) {
            return false;
        }
        Object this$podMonitorNamespaceSelector = this.getPodMonitorNamespaceSelector();
        Object other$podMonitorNamespaceSelector = other.getPodMonitorNamespaceSelector();
        if (this$podMonitorNamespaceSelector == null ? other$podMonitorNamespaceSelector != null : !this$podMonitorNamespaceSelector.equals(other$podMonitorNamespaceSelector)) {
            return false;
        }
        Object this$podMonitorSelector = this.getPodMonitorSelector();
        Object other$podMonitorSelector = other.getPodMonitorSelector();
        if (this$podMonitorSelector == null ? other$podMonitorSelector != null : !this$podMonitorSelector.equals(other$podMonitorSelector)) {
            return false;
        }
        Object this$podTargetLabels = this.getPodTargetLabels();
        Object other$podTargetLabels = other.getPodTargetLabels();
        if (this$podTargetLabels == null ? other$podTargetLabels != null : !this$podTargetLabels.equals(other$podTargetLabels)) {
            return false;
        }
        Object this$portName = this.getPortName();
        Object other$portName = other.getPortName();
        if (this$portName == null ? other$portName != null : !this$portName.equals(other$portName)) {
            return false;
        }
        Object this$priorityClassName = this.getPriorityClassName();
        Object other$priorityClassName = other.getPriorityClassName();
        if (this$priorityClassName == null ? other$priorityClassName != null : !this$priorityClassName.equals(other$priorityClassName)) {
            return false;
        }
        Object this$probeNamespaceSelector = this.getProbeNamespaceSelector();
        Object other$probeNamespaceSelector = other.getProbeNamespaceSelector();
        if (this$probeNamespaceSelector == null ? other$probeNamespaceSelector != null : !this$probeNamespaceSelector.equals(other$probeNamespaceSelector)) {
            return false;
        }
        Object this$probeSelector = this.getProbeSelector();
        Object other$probeSelector = other.getProbeSelector();
        if (this$probeSelector == null ? other$probeSelector != null : !this$probeSelector.equals(other$probeSelector)) {
            return false;
        }
        Object this$prometheusExternalLabelName = this.getPrometheusExternalLabelName();
        Object other$prometheusExternalLabelName = other.getPrometheusExternalLabelName();
        if (this$prometheusExternalLabelName == null ? other$prometheusExternalLabelName != null : !this$prometheusExternalLabelName.equals(other$prometheusExternalLabelName)) {
            return false;
        }
        Object this$reloadStrategy = this.getReloadStrategy();
        Object other$reloadStrategy = other.getReloadStrategy();
        if (this$reloadStrategy == null ? other$reloadStrategy != null : !this$reloadStrategy.equals(other$reloadStrategy)) {
            return false;
        }
        Object this$remoteWrite = this.getRemoteWrite();
        Object other$remoteWrite = other.getRemoteWrite();
        if (this$remoteWrite == null ? other$remoteWrite != null : !this$remoteWrite.equals(other$remoteWrite)) {
            return false;
        }
        Object this$remoteWriteReceiverMessageVersions = this.getRemoteWriteReceiverMessageVersions();
        Object other$remoteWriteReceiverMessageVersions = other.getRemoteWriteReceiverMessageVersions();
        if (this$remoteWriteReceiverMessageVersions == null ? other$remoteWriteReceiverMessageVersions != null : !this$remoteWriteReceiverMessageVersions.equals(other$remoteWriteReceiverMessageVersions)) {
            return false;
        }
        Object this$replicaExternalLabelName = this.getReplicaExternalLabelName();
        Object other$replicaExternalLabelName = other.getReplicaExternalLabelName();
        if (this$replicaExternalLabelName == null ? other$replicaExternalLabelName != null : !this$replicaExternalLabelName.equals(other$replicaExternalLabelName)) {
            return false;
        }
        Object this$replicas = this.getReplicas();
        Object other$replicas = other.getReplicas();
        if (this$replicas == null ? other$replicas != null : !this$replicas.equals(other$replicas)) {
            return false;
        }
        Object this$resources = this.getResources();
        Object other$resources = other.getResources();
        if (this$resources == null ? other$resources != null : !this$resources.equals(other$resources)) {
            return false;
        }
        Object this$routePrefix = this.getRoutePrefix();
        Object other$routePrefix = other.getRoutePrefix();
        if (this$routePrefix == null ? other$routePrefix != null : !this$routePrefix.equals(other$routePrefix)) {
            return false;
        }
        Object this$runtime = this.getRuntime();
        Object other$runtime = other.getRuntime();
        if (this$runtime == null ? other$runtime != null : !this$runtime.equals(other$runtime)) {
            return false;
        }
        Object this$sampleLimit = this.getSampleLimit();
        Object other$sampleLimit = other.getSampleLimit();
        if (this$sampleLimit == null ? other$sampleLimit != null : !this$sampleLimit.equals(other$sampleLimit)) {
            return false;
        }
        Object this$schedulerName = this.getSchedulerName();
        Object other$schedulerName = other.getSchedulerName();
        if (this$schedulerName == null ? other$schedulerName != null : !this$schedulerName.equals(other$schedulerName)) {
            return false;
        }
        Object this$scrapeClasses = this.getScrapeClasses();
        Object other$scrapeClasses = other.getScrapeClasses();
        if (this$scrapeClasses == null ? other$scrapeClasses != null : !this$scrapeClasses.equals(other$scrapeClasses)) {
            return false;
        }
        Object this$scrapeClassicHistograms = this.getScrapeClassicHistograms();
        Object other$scrapeClassicHistograms = other.getScrapeClassicHistograms();
        if (this$scrapeClassicHistograms == null ? other$scrapeClassicHistograms != null : !this$scrapeClassicHistograms.equals(other$scrapeClassicHistograms)) {
            return false;
        }
        Object this$scrapeConfigNamespaceSelector = this.getScrapeConfigNamespaceSelector();
        Object other$scrapeConfigNamespaceSelector = other.getScrapeConfigNamespaceSelector();
        if (this$scrapeConfigNamespaceSelector == null ? other$scrapeConfigNamespaceSelector != null : !this$scrapeConfigNamespaceSelector.equals(other$scrapeConfigNamespaceSelector)) {
            return false;
        }
        Object this$scrapeConfigSelector = this.getScrapeConfigSelector();
        Object other$scrapeConfigSelector = other.getScrapeConfigSelector();
        if (this$scrapeConfigSelector == null ? other$scrapeConfigSelector != null : !this$scrapeConfigSelector.equals(other$scrapeConfigSelector)) {
            return false;
        }
        Object this$scrapeFailureLogFile = this.getScrapeFailureLogFile();
        Object other$scrapeFailureLogFile = other.getScrapeFailureLogFile();
        if (this$scrapeFailureLogFile == null ? other$scrapeFailureLogFile != null : !this$scrapeFailureLogFile.equals(other$scrapeFailureLogFile)) {
            return false;
        }
        Object this$scrapeInterval = this.getScrapeInterval();
        Object other$scrapeInterval = other.getScrapeInterval();
        if (this$scrapeInterval == null ? other$scrapeInterval != null : !this$scrapeInterval.equals(other$scrapeInterval)) {
            return false;
        }
        Object this$scrapeNativeHistograms = this.getScrapeNativeHistograms();
        Object other$scrapeNativeHistograms = other.getScrapeNativeHistograms();
        if (this$scrapeNativeHistograms == null ? other$scrapeNativeHistograms != null : !this$scrapeNativeHistograms.equals(other$scrapeNativeHistograms)) {
            return false;
        }
        Object this$scrapeProtocols = this.getScrapeProtocols();
        Object other$scrapeProtocols = other.getScrapeProtocols();
        if (this$scrapeProtocols == null ? other$scrapeProtocols != null : !this$scrapeProtocols.equals(other$scrapeProtocols)) {
            return false;
        }
        Object this$scrapeTimeout = this.getScrapeTimeout();
        Object other$scrapeTimeout = other.getScrapeTimeout();
        if (this$scrapeTimeout == null ? other$scrapeTimeout != null : !this$scrapeTimeout.equals(other$scrapeTimeout)) {
            return false;
        }
        Object this$secrets = this.getSecrets();
        Object other$secrets = other.getSecrets();
        if (this$secrets == null ? other$secrets != null : !this$secrets.equals(other$secrets)) {
            return false;
        }
        Object this$securityContext = this.getSecurityContext();
        Object other$securityContext = other.getSecurityContext();
        if (this$securityContext == null ? other$securityContext != null : !this$securityContext.equals(other$securityContext)) {
            return false;
        }
        Object this$serviceAccountName = this.getServiceAccountName();
        Object other$serviceAccountName = other.getServiceAccountName();
        if (this$serviceAccountName == null ? other$serviceAccountName != null : !this$serviceAccountName.equals(other$serviceAccountName)) {
            return false;
        }
        Object this$serviceDiscoveryRole = this.getServiceDiscoveryRole();
        Object other$serviceDiscoveryRole = other.getServiceDiscoveryRole();
        if (this$serviceDiscoveryRole == null ? other$serviceDiscoveryRole != null : !this$serviceDiscoveryRole.equals(other$serviceDiscoveryRole)) {
            return false;
        }
        Object this$serviceMonitorNamespaceSelector = this.getServiceMonitorNamespaceSelector();
        Object other$serviceMonitorNamespaceSelector = other.getServiceMonitorNamespaceSelector();
        if (this$serviceMonitorNamespaceSelector == null ? other$serviceMonitorNamespaceSelector != null : !this$serviceMonitorNamespaceSelector.equals(other$serviceMonitorNamespaceSelector)) {
            return false;
        }
        Object this$serviceMonitorSelector = this.getServiceMonitorSelector();
        Object other$serviceMonitorSelector = other.getServiceMonitorSelector();
        if (this$serviceMonitorSelector == null ? other$serviceMonitorSelector != null : !this$serviceMonitorSelector.equals(other$serviceMonitorSelector)) {
            return false;
        }
        Object this$serviceName = this.getServiceName();
        Object other$serviceName = other.getServiceName();
        if (this$serviceName == null ? other$serviceName != null : !this$serviceName.equals(other$serviceName)) {
            return false;
        }
        Object this$shardingStrategy = this.getShardingStrategy();
        Object other$shardingStrategy = other.getShardingStrategy();
        if (this$shardingStrategy == null ? other$shardingStrategy != null : !this$shardingStrategy.equals(other$shardingStrategy)) {
            return false;
        }
        Object this$shards = this.getShards();
        Object other$shards = other.getShards();
        if (this$shards == null ? other$shards != null : !this$shards.equals(other$shards)) {
            return false;
        }
        Object this$storage = this.getStorage();
        Object other$storage = other.getStorage();
        if (this$storage == null ? other$storage != null : !this$storage.equals(other$storage)) {
            return false;
        }
        Object this$targetLimit = this.getTargetLimit();
        Object other$targetLimit = other.getTargetLimit();
        if (this$targetLimit == null ? other$targetLimit != null : !this$targetLimit.equals(other$targetLimit)) {
            return false;
        }
        Object this$terminationGracePeriodSeconds = this.getTerminationGracePeriodSeconds();
        Object other$terminationGracePeriodSeconds = other.getTerminationGracePeriodSeconds();
        if (this$terminationGracePeriodSeconds == null ? other$terminationGracePeriodSeconds != null : !this$terminationGracePeriodSeconds.equals(other$terminationGracePeriodSeconds)) {
            return false;
        }
        Object this$tolerations = this.getTolerations();
        Object other$tolerations = other.getTolerations();
        if (this$tolerations == null ? other$tolerations != null : !this$tolerations.equals(other$tolerations)) {
            return false;
        }
        Object this$topologySpreadConstraints = this.getTopologySpreadConstraints();
        Object other$topologySpreadConstraints = other.getTopologySpreadConstraints();
        if (this$topologySpreadConstraints == null ? other$topologySpreadConstraints != null : !this$topologySpreadConstraints.equals(other$topologySpreadConstraints)) {
            return false;
        }
        Object this$tracingConfig = this.getTracingConfig();
        Object other$tracingConfig = other.getTracingConfig();
        if (this$tracingConfig == null ? other$tracingConfig != null : !this$tracingConfig.equals(other$tracingConfig)) {
            return false;
        }
        Object this$tsdb = this.getTsdb();
        Object other$tsdb = other.getTsdb();
        if (this$tsdb == null ? other$tsdb != null : !this$tsdb.equals(other$tsdb)) {
            return false;
        }
        Object this$updateStrategy = this.getUpdateStrategy();
        Object other$updateStrategy = other.getUpdateStrategy();
        if (this$updateStrategy == null ? other$updateStrategy != null : !this$updateStrategy.equals(other$updateStrategy)) {
            return false;
        }
        Object this$version = this.getVersion();
        Object other$version = other.getVersion();
        if (this$version == null ? other$version != null : !this$version.equals(other$version)) {
            return false;
        }
        Object this$volumeMounts = this.getVolumeMounts();
        Object other$volumeMounts = other.getVolumeMounts();
        if (this$volumeMounts == null ? other$volumeMounts != null : !this$volumeMounts.equals(other$volumeMounts)) {
            return false;
        }
        Object this$volumes = this.getVolumes();
        Object other$volumes = other.getVolumes();
        if (this$volumes == null ? other$volumes != null : !this$volumes.equals(other$volumes)) {
            return false;
        }
        Object this$walCompression = this.getWalCompression();
        Object other$walCompression = other.getWalCompression();
        if (this$walCompression == null ? other$walCompression != null : !this$walCompression.equals(other$walCompression)) {
            return false;
        }
        Object this$web = this.getWeb();
        Object other$web = other.getWeb();
        if (this$web == null ? other$web != null : !this$web.equals(other$web)) {
            return false;
        }
        Object this$additionalProperties = this.getAdditionalProperties();
        Object other$additionalProperties = other.getAdditionalProperties();
        if (this$additionalProperties == null ? other$additionalProperties != null : !this$additionalProperties.equals(other$additionalProperties)) {
            return false;
        }
        return true;
    }

    protected boolean canEqual(Object other) {
        return other instanceof PrometheusAgentSpec;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $additionalArgs = this.getAdditionalArgs();
        result = result * prime + ($additionalArgs == null ? 43 : $additionalArgs.hashCode());
        Object $additionalScrapeConfigs = this.getAdditionalScrapeConfigs();
        result = result * prime + ($additionalScrapeConfigs == null ? 43 : $additionalScrapeConfigs.hashCode());
        Object $affinity = this.getAffinity();
        result = result * prime + ($affinity == null ? 43 : $affinity.hashCode());
        Object $apiserverConfig = this.getApiserverConfig();
        result = result * prime + ($apiserverConfig == null ? 43 : $apiserverConfig.hashCode());
        Object $arbitraryFSAccessThroughSMs = this.getArbitraryFSAccessThroughSMs();
        result = result * prime + ($arbitraryFSAccessThroughSMs == null ? 43 : $arbitraryFSAccessThroughSMs.hashCode());
        Object $automountServiceAccountToken = this.getAutomountServiceAccountToken();
        result = result * prime + ($automountServiceAccountToken == null ? 43 : $automountServiceAccountToken.hashCode());
        Object $bodySizeLimit = this.getBodySizeLimit();
        result = result * prime + ($bodySizeLimit == null ? 43 : $bodySizeLimit.hashCode());
        Object $configMaps = this.getConfigMaps();
        result = result * prime + ($configMaps == null ? 43 : $configMaps.hashCode());
        Object $containers = this.getContainers();
        result = result * prime + ($containers == null ? 43 : $containers.hashCode());
        Object $convertClassicHistogramsToNHCB = this.getConvertClassicHistogramsToNHCB();
        result = result * prime + ($convertClassicHistogramsToNHCB == null ? 43 : $convertClassicHistogramsToNHCB.hashCode());
        Object $dnsConfig = this.getDnsConfig();
        result = result * prime + ($dnsConfig == null ? 43 : $dnsConfig.hashCode());
        Object $dnsPolicy = this.getDnsPolicy();
        result = result * prime + ($dnsPolicy == null ? 43 : $dnsPolicy.hashCode());
        Object $enableFeatures = this.getEnableFeatures();
        result = result * prime + ($enableFeatures == null ? 43 : $enableFeatures.hashCode());
        Object $enableOTLPReceiver = this.getEnableOTLPReceiver();
        result = result * prime + ($enableOTLPReceiver == null ? 43 : $enableOTLPReceiver.hashCode());
        Object $enableRemoteWriteReceiver = this.getEnableRemoteWriteReceiver();
        result = result * prime + ($enableRemoteWriteReceiver == null ? 43 : $enableRemoteWriteReceiver.hashCode());
        Object $enableServiceLinks = this.getEnableServiceLinks();
        result = result * prime + ($enableServiceLinks == null ? 43 : $enableServiceLinks.hashCode());
        Object $enforcedBodySizeLimit = this.getEnforcedBodySizeLimit();
        result = result * prime + ($enforcedBodySizeLimit == null ? 43 : $enforcedBodySizeLimit.hashCode());
        Object $enforcedKeepDroppedTargets = this.getEnforcedKeepDroppedTargets();
        result = result * prime + ($enforcedKeepDroppedTargets == null ? 43 : $enforcedKeepDroppedTargets.hashCode());
        Object $enforcedLabelLimit = this.getEnforcedLabelLimit();
        result = result * prime + ($enforcedLabelLimit == null ? 43 : $enforcedLabelLimit.hashCode());
        Object $enforcedLabelNameLengthLimit = this.getEnforcedLabelNameLengthLimit();
        result = result * prime + ($enforcedLabelNameLengthLimit == null ? 43 : $enforcedLabelNameLengthLimit.hashCode());
        Object $enforcedLabelValueLengthLimit = this.getEnforcedLabelValueLengthLimit();
        result = result * prime + ($enforcedLabelValueLengthLimit == null ? 43 : $enforcedLabelValueLengthLimit.hashCode());
        Object $enforcedNamespaceLabel = this.getEnforcedNamespaceLabel();
        result = result * prime + ($enforcedNamespaceLabel == null ? 43 : $enforcedNamespaceLabel.hashCode());
        Object $enforcedSampleLimit = this.getEnforcedSampleLimit();
        result = result * prime + ($enforcedSampleLimit == null ? 43 : $enforcedSampleLimit.hashCode());
        Object $enforcedTargetLimit = this.getEnforcedTargetLimit();
        result = result * prime + ($enforcedTargetLimit == null ? 43 : $enforcedTargetLimit.hashCode());
        Object $excludedFromEnforcement = this.getExcludedFromEnforcement();
        result = result * prime + ($excludedFromEnforcement == null ? 43 : $excludedFromEnforcement.hashCode());
        Object $externalLabels = this.getExternalLabels();
        result = result * prime + ($externalLabels == null ? 43 : $externalLabels.hashCode());
        Object $externalUrl = this.getExternalUrl();
        result = result * prime + ($externalUrl == null ? 43 : $externalUrl.hashCode());
        Object $hostAliases = this.getHostAliases();
        result = result * prime + ($hostAliases == null ? 43 : $hostAliases.hashCode());
        Object $hostNetwork = this.getHostNetwork();
        result = result * prime + ($hostNetwork == null ? 43 : $hostNetwork.hashCode());
        Object $hostUsers = this.getHostUsers();
        result = result * prime + ($hostUsers == null ? 43 : $hostUsers.hashCode());
        Object $ignoreNamespaceSelectors = this.getIgnoreNamespaceSelectors();
        result = result * prime + ($ignoreNamespaceSelectors == null ? 43 : $ignoreNamespaceSelectors.hashCode());
        Object $image = this.getImage();
        result = result * prime + ($image == null ? 43 : $image.hashCode());
        Object $imagePullPolicy = this.getImagePullPolicy();
        result = result * prime + ($imagePullPolicy == null ? 43 : $imagePullPolicy.hashCode());
        Object $imagePullSecrets = this.getImagePullSecrets();
        result = result * prime + ($imagePullSecrets == null ? 43 : $imagePullSecrets.hashCode());
        Object $initContainers = this.getInitContainers();
        result = result * prime + ($initContainers == null ? 43 : $initContainers.hashCode());
        Object $keepDroppedTargets = this.getKeepDroppedTargets();
        result = result * prime + ($keepDroppedTargets == null ? 43 : $keepDroppedTargets.hashCode());
        Object $labelLimit = this.getLabelLimit();
        result = result * prime + ($labelLimit == null ? 43 : $labelLimit.hashCode());
        Object $labelNameLengthLimit = this.getLabelNameLengthLimit();
        result = result * prime + ($labelNameLengthLimit == null ? 43 : $labelNameLengthLimit.hashCode());
        Object $labelValueLengthLimit = this.getLabelValueLengthLimit();
        result = result * prime + ($labelValueLengthLimit == null ? 43 : $labelValueLengthLimit.hashCode());
        Object $listenLocal = this.getListenLocal();
        result = result * prime + ($listenLocal == null ? 43 : $listenLocal.hashCode());
        Object $logFormat = this.getLogFormat();
        result = result * prime + ($logFormat == null ? 43 : $logFormat.hashCode());
        Object $logLevel = this.getLogLevel();
        result = result * prime + ($logLevel == null ? 43 : $logLevel.hashCode());
        Object $maximumStartupDurationSeconds = this.getMaximumStartupDurationSeconds();
        result = result * prime + ($maximumStartupDurationSeconds == null ? 43 : $maximumStartupDurationSeconds.hashCode());
        Object $minReadySeconds = this.getMinReadySeconds();
        result = result * prime + ($minReadySeconds == null ? 43 : $minReadySeconds.hashCode());
        Object $mode = this.getMode();
        result = result * prime + ($mode == null ? 43 : $mode.hashCode());
        Object $nameEscapingScheme = this.getNameEscapingScheme();
        result = result * prime + ($nameEscapingScheme == null ? 43 : $nameEscapingScheme.hashCode());
        Object $nameValidationScheme = this.getNameValidationScheme();
        result = result * prime + ($nameValidationScheme == null ? 43 : $nameValidationScheme.hashCode());
        Object $nodeSelector = this.getNodeSelector();
        result = result * prime + ($nodeSelector == null ? 43 : $nodeSelector.hashCode());
        Object $otlp = this.getOtlp();
        result = result * prime + ($otlp == null ? 43 : $otlp.hashCode());
        Object $overrideHonorLabels = this.getOverrideHonorLabels();
        result = result * prime + ($overrideHonorLabels == null ? 43 : $overrideHonorLabels.hashCode());
        Object $overrideHonorTimestamps = this.getOverrideHonorTimestamps();
        result = result * prime + ($overrideHonorTimestamps == null ? 43 : $overrideHonorTimestamps.hashCode());
        Object $paused = this.getPaused();
        result = result * prime + ($paused == null ? 43 : $paused.hashCode());
        Object $persistentVolumeClaimRetentionPolicy = this.getPersistentVolumeClaimRetentionPolicy();
        result = result * prime + ($persistentVolumeClaimRetentionPolicy == null ? 43 : $persistentVolumeClaimRetentionPolicy.hashCode());
        Object $podManagementPolicy = this.getPodManagementPolicy();
        result = result * prime + ($podManagementPolicy == null ? 43 : $podManagementPolicy.hashCode());
        Object $podMetadata = this.getPodMetadata();
        result = result * prime + ($podMetadata == null ? 43 : $podMetadata.hashCode());
        Object $podMonitorNamespaceSelector = this.getPodMonitorNamespaceSelector();
        result = result * prime + ($podMonitorNamespaceSelector == null ? 43 : $podMonitorNamespaceSelector.hashCode());
        Object $podMonitorSelector = this.getPodMonitorSelector();
        result = result * prime + ($podMonitorSelector == null ? 43 : $podMonitorSelector.hashCode());
        Object $podTargetLabels = this.getPodTargetLabels();
        result = result * prime + ($podTargetLabels == null ? 43 : $podTargetLabels.hashCode());
        Object $portName = this.getPortName();
        result = result * prime + ($portName == null ? 43 : $portName.hashCode());
        Object $priorityClassName = this.getPriorityClassName();
        result = result * prime + ($priorityClassName == null ? 43 : $priorityClassName.hashCode());
        Object $probeNamespaceSelector = this.getProbeNamespaceSelector();
        result = result * prime + ($probeNamespaceSelector == null ? 43 : $probeNamespaceSelector.hashCode());
        Object $probeSelector = this.getProbeSelector();
        result = result * prime + ($probeSelector == null ? 43 : $probeSelector.hashCode());
        Object $prometheusExternalLabelName = this.getPrometheusExternalLabelName();
        result = result * prime + ($prometheusExternalLabelName == null ? 43 : $prometheusExternalLabelName.hashCode());
        Object $reloadStrategy = this.getReloadStrategy();
        result = result * prime + ($reloadStrategy == null ? 43 : $reloadStrategy.hashCode());
        Object $remoteWrite = this.getRemoteWrite();
        result = result * prime + ($remoteWrite == null ? 43 : $remoteWrite.hashCode());
        Object $remoteWriteReceiverMessageVersions = this.getRemoteWriteReceiverMessageVersions();
        result = result * prime + ($remoteWriteReceiverMessageVersions == null ? 43 : $remoteWriteReceiverMessageVersions.hashCode());
        Object $replicaExternalLabelName = this.getReplicaExternalLabelName();
        result = result * prime + ($replicaExternalLabelName == null ? 43 : $replicaExternalLabelName.hashCode());
        Object $replicas = this.getReplicas();
        result = result * prime + ($replicas == null ? 43 : $replicas.hashCode());
        Object $resources = this.getResources();
        result = result * prime + ($resources == null ? 43 : $resources.hashCode());
        Object $routePrefix = this.getRoutePrefix();
        result = result * prime + ($routePrefix == null ? 43 : $routePrefix.hashCode());
        Object $runtime = this.getRuntime();
        result = result * prime + ($runtime == null ? 43 : $runtime.hashCode());
        Object $sampleLimit = this.getSampleLimit();
        result = result * prime + ($sampleLimit == null ? 43 : $sampleLimit.hashCode());
        Object $schedulerName = this.getSchedulerName();
        result = result * prime + ($schedulerName == null ? 43 : $schedulerName.hashCode());
        Object $scrapeClasses = this.getScrapeClasses();
        result = result * prime + ($scrapeClasses == null ? 43 : $scrapeClasses.hashCode());
        Object $scrapeClassicHistograms = this.getScrapeClassicHistograms();
        result = result * prime + ($scrapeClassicHistograms == null ? 43 : $scrapeClassicHistograms.hashCode());
        Object $scrapeConfigNamespaceSelector = this.getScrapeConfigNamespaceSelector();
        result = result * prime + ($scrapeConfigNamespaceSelector == null ? 43 : $scrapeConfigNamespaceSelector.hashCode());
        Object $scrapeConfigSelector = this.getScrapeConfigSelector();
        result = result * prime + ($scrapeConfigSelector == null ? 43 : $scrapeConfigSelector.hashCode());
        Object $scrapeFailureLogFile = this.getScrapeFailureLogFile();
        result = result * prime + ($scrapeFailureLogFile == null ? 43 : $scrapeFailureLogFile.hashCode());
        Object $scrapeInterval = this.getScrapeInterval();
        result = result * prime + ($scrapeInterval == null ? 43 : $scrapeInterval.hashCode());
        Object $scrapeNativeHistograms = this.getScrapeNativeHistograms();
        result = result * prime + ($scrapeNativeHistograms == null ? 43 : $scrapeNativeHistograms.hashCode());
        Object $scrapeProtocols = this.getScrapeProtocols();
        result = result * prime + ($scrapeProtocols == null ? 43 : $scrapeProtocols.hashCode());
        Object $scrapeTimeout = this.getScrapeTimeout();
        result = result * prime + ($scrapeTimeout == null ? 43 : $scrapeTimeout.hashCode());
        Object $secrets = this.getSecrets();
        result = result * prime + ($secrets == null ? 43 : $secrets.hashCode());
        Object $securityContext = this.getSecurityContext();
        result = result * prime + ($securityContext == null ? 43 : $securityContext.hashCode());
        Object $serviceAccountName = this.getServiceAccountName();
        result = result * prime + ($serviceAccountName == null ? 43 : $serviceAccountName.hashCode());
        Object $serviceDiscoveryRole = this.getServiceDiscoveryRole();
        result = result * prime + ($serviceDiscoveryRole == null ? 43 : $serviceDiscoveryRole.hashCode());
        Object $serviceMonitorNamespaceSelector = this.getServiceMonitorNamespaceSelector();
        result = result * prime + ($serviceMonitorNamespaceSelector == null ? 43 : $serviceMonitorNamespaceSelector.hashCode());
        Object $serviceMonitorSelector = this.getServiceMonitorSelector();
        result = result * prime + ($serviceMonitorSelector == null ? 43 : $serviceMonitorSelector.hashCode());
        Object $serviceName = this.getServiceName();
        result = result * prime + ($serviceName == null ? 43 : $serviceName.hashCode());
        Object $shardingStrategy = this.getShardingStrategy();
        result = result * prime + ($shardingStrategy == null ? 43 : $shardingStrategy.hashCode());
        Object $shards = this.getShards();
        result = result * prime + ($shards == null ? 43 : $shards.hashCode());
        Object $storage = this.getStorage();
        result = result * prime + ($storage == null ? 43 : $storage.hashCode());
        Object $targetLimit = this.getTargetLimit();
        result = result * prime + ($targetLimit == null ? 43 : $targetLimit.hashCode());
        Object $terminationGracePeriodSeconds = this.getTerminationGracePeriodSeconds();
        result = result * prime + ($terminationGracePeriodSeconds == null ? 43 : $terminationGracePeriodSeconds.hashCode());
        Object $tolerations = this.getTolerations();
        result = result * prime + ($tolerations == null ? 43 : $tolerations.hashCode());
        Object $topologySpreadConstraints = this.getTopologySpreadConstraints();
        result = result * prime + ($topologySpreadConstraints == null ? 43 : $topologySpreadConstraints.hashCode());
        Object $tracingConfig = this.getTracingConfig();
        result = result * prime + ($tracingConfig == null ? 43 : $tracingConfig.hashCode());
        Object $tsdb = this.getTsdb();
        result = result * prime + ($tsdb == null ? 43 : $tsdb.hashCode());
        Object $updateStrategy = this.getUpdateStrategy();
        result = result * prime + ($updateStrategy == null ? 43 : $updateStrategy.hashCode());
        Object $version = this.getVersion();
        result = result * prime + ($version == null ? 43 : $version.hashCode());
        Object $volumeMounts = this.getVolumeMounts();
        result = result * prime + ($volumeMounts == null ? 43 : $volumeMounts.hashCode());
        Object $volumes = this.getVolumes();
        result = result * prime + ($volumes == null ? 43 : $volumes.hashCode());
        Object $walCompression = this.getWalCompression();
        result = result * prime + ($walCompression == null ? 43 : $walCompression.hashCode());
        Object $web = this.getWeb();
        result = result * prime + ($web == null ? 43 : $web.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "PrometheusAgentSpec(" + "additionalArgs=" + this.getAdditionalArgs() + ", additionalScrapeConfigs=" + this.getAdditionalScrapeConfigs() + ", affinity=" + this.getAffinity() + ", apiserverConfig=" + this.getApiserverConfig() + ", arbitraryFSAccessThroughSMs=" + this.getArbitraryFSAccessThroughSMs() + ", automountServiceAccountToken=" + this.getAutomountServiceAccountToken() + ", bodySizeLimit=" + this.getBodySizeLimit() + ", configMaps=" + this.getConfigMaps() + ", containers=" + this.getContainers() + ", convertClassicHistogramsToNHCB=" + this.getConvertClassicHistogramsToNHCB() + ", dnsConfig=" + this.getDnsConfig() + ", dnsPolicy=" + this.getDnsPolicy() + ", enableFeatures=" + this.getEnableFeatures() + ", enableOTLPReceiver=" + this.getEnableOTLPReceiver() + ", enableRemoteWriteReceiver=" + this.getEnableRemoteWriteReceiver() + ", enableServiceLinks=" + this.getEnableServiceLinks() + ", enforcedBodySizeLimit=" + this.getEnforcedBodySizeLimit() + ", enforcedKeepDroppedTargets=" + this.getEnforcedKeepDroppedTargets() + ", enforcedLabelLimit=" + this.getEnforcedLabelLimit() + ", enforcedLabelNameLengthLimit=" + this.getEnforcedLabelNameLengthLimit() + ", enforcedLabelValueLengthLimit=" + this.getEnforcedLabelValueLengthLimit() + ", enforcedNamespaceLabel=" + this.getEnforcedNamespaceLabel() + ", enforcedSampleLimit=" + this.getEnforcedSampleLimit() + ", enforcedTargetLimit=" + this.getEnforcedTargetLimit() + ", excludedFromEnforcement=" + this.getExcludedFromEnforcement() + ", externalLabels=" + this.getExternalLabels() + ", externalUrl=" + this.getExternalUrl() + ", hostAliases=" + this.getHostAliases() + ", hostNetwork=" + this.getHostNetwork() + ", hostUsers=" + this.getHostUsers() + ", ignoreNamespaceSelectors=" + this.getIgnoreNamespaceSelectors() + ", image=" + this.getImage() + ", imagePullPolicy=" + this.getImagePullPolicy() + ", imagePullSecrets=" + this.getImagePullSecrets() + ", initContainers=" + this.getInitContainers() + ", keepDroppedTargets=" + this.getKeepDroppedTargets() + ", labelLimit=" + this.getLabelLimit() + ", labelNameLengthLimit=" + this.getLabelNameLengthLimit() + ", labelValueLengthLimit=" + this.getLabelValueLengthLimit() + ", listenLocal=" + this.getListenLocal() + ", logFormat=" + this.getLogFormat() + ", logLevel=" + this.getLogLevel() + ", maximumStartupDurationSeconds=" + this.getMaximumStartupDurationSeconds() + ", minReadySeconds=" + this.getMinReadySeconds() + ", mode=" + this.getMode() + ", nameEscapingScheme=" + this.getNameEscapingScheme() + ", nameValidationScheme=" + this.getNameValidationScheme() + ", nodeSelector=" + this.getNodeSelector() + ", otlp=" + this.getOtlp() + ", overrideHonorLabels=" + this.getOverrideHonorLabels() + ", overrideHonorTimestamps=" + this.getOverrideHonorTimestamps() + ", paused=" + this.getPaused() + ", persistentVolumeClaimRetentionPolicy=" + this.getPersistentVolumeClaimRetentionPolicy() + ", podManagementPolicy=" + this.getPodManagementPolicy() + ", podMetadata=" + this.getPodMetadata() + ", podMonitorNamespaceSelector=" + this.getPodMonitorNamespaceSelector() + ", podMonitorSelector=" + this.getPodMonitorSelector() + ", podTargetLabels=" + this.getPodTargetLabels() + ", portName=" + this.getPortName() + ", priorityClassName=" + this.getPriorityClassName() + ", probeNamespaceSelector=" + this.getProbeNamespaceSelector() + ", probeSelector=" + this.getProbeSelector() + ", prometheusExternalLabelName=" + this.getPrometheusExternalLabelName() + ", reloadStrategy=" + this.getReloadStrategy() + ", remoteWrite=" + this.getRemoteWrite() + ", remoteWriteReceiverMessageVersions=" + this.getRemoteWriteReceiverMessageVersions() + ", replicaExternalLabelName=" + this.getReplicaExternalLabelName() + ", replicas=" + this.getReplicas() + ", resources=" + this.getResources() + ", routePrefix=" + this.getRoutePrefix() + ", runtime=" + this.getRuntime() + ", sampleLimit=" + this.getSampleLimit() + ", schedulerName=" + this.getSchedulerName() + ", scrapeClasses=" + this.getScrapeClasses() + ", scrapeClassicHistograms=" + this.getScrapeClassicHistograms() + ", scrapeConfigNamespaceSelector=" + this.getScrapeConfigNamespaceSelector() + ", scrapeConfigSelector=" + this.getScrapeConfigSelector() + ", scrapeFailureLogFile=" + this.getScrapeFailureLogFile() + ", scrapeInterval=" + this.getScrapeInterval() + ", scrapeNativeHistograms=" + this.getScrapeNativeHistograms() + ", scrapeProtocols=" + this.getScrapeProtocols() + ", scrapeTimeout=" + this.getScrapeTimeout() + ", secrets=" + this.getSecrets() + ", securityContext=" + this.getSecurityContext() + ", serviceAccountName=" + this.getServiceAccountName() + ", serviceDiscoveryRole=" + this.getServiceDiscoveryRole() + ", serviceMonitorNamespaceSelector=" + this.getServiceMonitorNamespaceSelector() + ", serviceMonitorSelector=" + this.getServiceMonitorSelector() + ", serviceName=" + this.getServiceName() + ", shardingStrategy=" + this.getShardingStrategy() + ", shards=" + this.getShards() + ", storage=" + this.getStorage() + ", targetLimit=" + this.getTargetLimit() + ", terminationGracePeriodSeconds=" + this.getTerminationGracePeriodSeconds() + ", tolerations=" + this.getTolerations() + ", topologySpreadConstraints=" + this.getTopologySpreadConstraints() + ", tracingConfig=" + this.getTracingConfig() + ", tsdb=" + this.getTsdb() + ", updateStrategy=" + this.getUpdateStrategy() + ", version=" + this.getVersion() + ", volumeMounts=" + this.getVolumeMounts() + ", volumes=" + this.getVolumes() + ", walCompression=" + this.getWalCompression() + ", web=" + this.getWeb() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
