
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
import io.fabric8.openshift.api.model.monitoring.v1.PrometheusTracingConfig;
import io.fabric8.openshift.api.model.monitoring.v1.PrometheusWebSpec;
import io.fabric8.openshift.api.model.monitoring.v1.RemoteWriteSpec;
import io.fabric8.openshift.api.model.monitoring.v1.RuntimeConfig;
import io.fabric8.openshift.api.model.monitoring.v1.ScrapeClass;
import io.fabric8.openshift.api.model.monitoring.v1.StorageSpec;
import io.fabric8.openshift.api.model.monitoring.v1.TSDBSpec;
import io.fabric8.openshift.api.model.monitoring.v1.TopologySpreadConstraint;
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

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
    "scrapeClasses",
    "scrapeClassicHistograms",
    "scrapeConfigNamespaceSelector",
    "scrapeConfigSelector",
    "scrapeFailureLogFile",
    "scrapeInterval",
    "scrapeProtocols",
    "scrapeTimeout",
    "secrets",
    "securityContext",
    "serviceAccountName",
    "serviceDiscoveryRole",
    "serviceMonitorNamespaceSelector",
    "serviceMonitorSelector",
    "serviceName",
    "shards",
    "storage",
    "targetLimit",
    "terminationGracePeriodSeconds",
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
     */
    public PrometheusAgentSpec() {
    }

    public PrometheusAgentSpec(List<Argument> additionalArgs, SecretKeySelector additionalScrapeConfigs, Affinity affinity, APIServerConfig apiserverConfig, ArbitraryFSAccessThroughSMsConfig arbitraryFSAccessThroughSMs, Boolean automountServiceAccountToken, String bodySizeLimit, List<String> configMaps, List<Container> containers, Boolean convertClassicHistogramsToNHCB, PodDNSConfig dnsConfig, String dnsPolicy, List<String> enableFeatures, Boolean enableOTLPReceiver, Boolean enableRemoteWriteReceiver, Boolean enableServiceLinks, String enforcedBodySizeLimit, Long enforcedKeepDroppedTargets, Long enforcedLabelLimit, Long enforcedLabelNameLengthLimit, Long enforcedLabelValueLengthLimit, String enforcedNamespaceLabel, Long enforcedSampleLimit, Long enforcedTargetLimit, List<ObjectReference> excludedFromEnforcement, Map<String, String> externalLabels, String externalUrl, List<HostAlias> hostAliases, Boolean hostNetwork, Boolean hostUsers, Boolean ignoreNamespaceSelectors, String image, String imagePullPolicy, List<LocalObjectReference> imagePullSecrets, List<Container> initContainers, Long keepDroppedTargets, Long labelLimit, Long labelNameLengthLimit, Long labelValueLengthLimit, Boolean listenLocal, String logFormat, String logLevel, Integer maximumStartupDurationSeconds, Integer minReadySeconds, String mode, String nameEscapingScheme, String nameValidationScheme, Map<String, String> nodeSelector, OTLPConfig otlp, Boolean overrideHonorLabels, Boolean overrideHonorTimestamps, Boolean paused, StatefulSetPersistentVolumeClaimRetentionPolicy persistentVolumeClaimRetentionPolicy, EmbeddedObjectMetadata podMetadata, LabelSelector podMonitorNamespaceSelector, LabelSelector podMonitorSelector, List<String> podTargetLabels, String portName, String priorityClassName, LabelSelector probeNamespaceSelector, LabelSelector probeSelector, String prometheusExternalLabelName, String reloadStrategy, List<RemoteWriteSpec> remoteWrite, List<String> remoteWriteReceiverMessageVersions, String replicaExternalLabelName, Integer replicas, ResourceRequirements resources, String routePrefix, RuntimeConfig runtime, Long sampleLimit, List<ScrapeClass> scrapeClasses, Boolean scrapeClassicHistograms, LabelSelector scrapeConfigNamespaceSelector, LabelSelector scrapeConfigSelector, String scrapeFailureLogFile, String scrapeInterval, List<String> scrapeProtocols, String scrapeTimeout, List<String> secrets, PodSecurityContext securityContext, String serviceAccountName, String serviceDiscoveryRole, LabelSelector serviceMonitorNamespaceSelector, LabelSelector serviceMonitorSelector, String serviceName, Integer shards, StorageSpec storage, Long targetLimit, Long terminationGracePeriodSeconds, List<Toleration> tolerations, List<TopologySpreadConstraint> topologySpreadConstraints, PrometheusTracingConfig tracingConfig, TSDBSpec tsdb, String version, List<VolumeMount> volumeMounts, List<Volume> volumes, Boolean walCompression, PrometheusWebSpec web) {
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
        this.scrapeClasses = scrapeClasses;
        this.scrapeClassicHistograms = scrapeClassicHistograms;
        this.scrapeConfigNamespaceSelector = scrapeConfigNamespaceSelector;
        this.scrapeConfigSelector = scrapeConfigSelector;
        this.scrapeFailureLogFile = scrapeFailureLogFile;
        this.scrapeInterval = scrapeInterval;
        this.scrapeProtocols = scrapeProtocols;
        this.scrapeTimeout = scrapeTimeout;
        this.secrets = secrets;
        this.securityContext = securityContext;
        this.serviceAccountName = serviceAccountName;
        this.serviceDiscoveryRole = serviceDiscoveryRole;
        this.serviceMonitorNamespaceSelector = serviceMonitorNamespaceSelector;
        this.serviceMonitorSelector = serviceMonitorSelector;
        this.serviceName = serviceName;
        this.shards = shards;
        this.storage = storage;
        this.targetLimit = targetLimit;
        this.terminationGracePeriodSeconds = terminationGracePeriodSeconds;
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

    /**
     * AdditionalArgs allows setting additional arguments for the 'prometheus' container.<br><p> <br><p> It is intended for e.g. activating hidden flags which are not supported by the dedicated configuration options yet. The arguments are passed as-is to the Prometheus container which may cause issues if they are invalid or not supported by the given Prometheus version.<br><p> <br><p> In case of an argument conflict (e.g. an argument which is already set by the operator itself) or when providing an invalid argument, the reconciliation will fail and an error will be logged.
     */
    @JsonProperty("additionalArgs")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<Argument> getAdditionalArgs() {
        return additionalArgs;
    }

    /**
     * AdditionalArgs allows setting additional arguments for the 'prometheus' container.<br><p> <br><p> It is intended for e.g. activating hidden flags which are not supported by the dedicated configuration options yet. The arguments are passed as-is to the Prometheus container which may cause issues if they are invalid or not supported by the given Prometheus version.<br><p> <br><p> In case of an argument conflict (e.g. an argument which is already set by the operator itself) or when providing an invalid argument, the reconciliation will fail and an error will be logged.
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
     * AutomountServiceAccountToken indicates whether a service account token should be automatically mounted in the pod. If the field isn't set, the operator mounts the service account token by default.<br><p> <br><p> &#42;&#42;Warning:&#42;&#42; be aware that by default, Prometheus requires the service account token for Kubernetes service discovery. It is possible to use strategic merge patch to project the service account token into the 'prometheus' container.
     */
    @JsonProperty("automountServiceAccountToken")
    public Boolean getAutomountServiceAccountToken() {
        return automountServiceAccountToken;
    }

    /**
     * AutomountServiceAccountToken indicates whether a service account token should be automatically mounted in the pod. If the field isn't set, the operator mounts the service account token by default.<br><p> <br><p> &#42;&#42;Warning:&#42;&#42; be aware that by default, Prometheus requires the service account token for Kubernetes service discovery. It is possible to use strategic merge patch to project the service account token into the 'prometheus' container.
     */
    @JsonProperty("automountServiceAccountToken")
    public void setAutomountServiceAccountToken(Boolean automountServiceAccountToken) {
        this.automountServiceAccountToken = automountServiceAccountToken;
    }

    /**
     * BodySizeLimit defines per-scrape on response body size. Only valid in Prometheus versions 2.45.0 and newer.<br><p> <br><p> Note that the global limit only applies to scrape objects that don't specify an explicit limit value. If you want to enforce a maximum limit for all scrape objects, refer to enforcedBodySizeLimit.
     */
    @JsonProperty("bodySizeLimit")
    public String getBodySizeLimit() {
        return bodySizeLimit;
    }

    /**
     * BodySizeLimit defines per-scrape on response body size. Only valid in Prometheus versions 2.45.0 and newer.<br><p> <br><p> Note that the global limit only applies to scrape objects that don't specify an explicit limit value. If you want to enforce a maximum limit for all scrape objects, refer to enforcedBodySizeLimit.
     */
    @JsonProperty("bodySizeLimit")
    public void setBodySizeLimit(String bodySizeLimit) {
        this.bodySizeLimit = bodySizeLimit;
    }

    /**
     * ConfigMaps is a list of ConfigMaps in the same namespace as the Prometheus object, which shall be mounted into the Prometheus Pods. Each ConfigMap is added to the StatefulSet definition as a volume named `configmap-&lt;configmap-name&gt;`. The ConfigMaps are mounted into /etc/prometheus/configmaps/&lt;configmap-name&gt; in the 'prometheus' container.
     */
    @JsonProperty("configMaps")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getConfigMaps() {
        return configMaps;
    }

    /**
     * ConfigMaps is a list of ConfigMaps in the same namespace as the Prometheus object, which shall be mounted into the Prometheus Pods. Each ConfigMap is added to the StatefulSet definition as a volume named `configmap-&lt;configmap-name&gt;`. The ConfigMaps are mounted into /etc/prometheus/configmaps/&lt;configmap-name&gt; in the 'prometheus' container.
     */
    @JsonProperty("configMaps")
    public void setConfigMaps(List<String> configMaps) {
        this.configMaps = configMaps;
    }

    /**
     * Containers allows injecting additional containers or modifying operator generated containers. This can be used to allow adding an authentication proxy to the Pods or to change the behavior of an operator generated container. Containers described here modify an operator generated container if they share the same name and modifications are done via a strategic merge patch.<br><p> <br><p> The names of containers managed by the operator are: &#42; `prometheus` &#42; `config-reloader` &#42; `thanos-sidecar`<br><p> <br><p> Overriding containers is entirely outside the scope of what the maintainers will support and by doing so, you accept that this behaviour may break at any time without notice.
     */
    @JsonProperty("containers")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<Container> getContainers() {
        return containers;
    }

    /**
     * Containers allows injecting additional containers or modifying operator generated containers. This can be used to allow adding an authentication proxy to the Pods or to change the behavior of an operator generated container. Containers described here modify an operator generated container if they share the same name and modifications are done via a strategic merge patch.<br><p> <br><p> The names of containers managed by the operator are: &#42; `prometheus` &#42; `config-reloader` &#42; `thanos-sidecar`<br><p> <br><p> Overriding containers is entirely outside the scope of what the maintainers will support and by doing so, you accept that this behaviour may break at any time without notice.
     */
    @JsonProperty("containers")
    public void setContainers(List<Container> containers) {
        this.containers = containers;
    }

    /**
     * Whether to convert all scraped classic histograms into a native histogram with custom buckets.<br><p> <br><p> It requires Prometheus &gt;= v3.4.0.
     */
    @JsonProperty("convertClassicHistogramsToNHCB")
    public Boolean getConvertClassicHistogramsToNHCB() {
        return convertClassicHistogramsToNHCB;
    }

    /**
     * Whether to convert all scraped classic histograms into a native histogram with custom buckets.<br><p> <br><p> It requires Prometheus &gt;= v3.4.0.
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
     * Defines the DNS policy for the pods.
     */
    @JsonProperty("dnsPolicy")
    public String getDnsPolicy() {
        return dnsPolicy;
    }

    /**
     * Defines the DNS policy for the pods.
     */
    @JsonProperty("dnsPolicy")
    public void setDnsPolicy(String dnsPolicy) {
        this.dnsPolicy = dnsPolicy;
    }

    /**
     * Enable access to Prometheus feature flags. By default, no features are enabled.<br><p> <br><p> Enabling features which are disabled by default is entirely outside the scope of what the maintainers will support and by doing so, you accept that this behaviour may break at any time without notice.<br><p> <br><p> For more information see https://prometheus.io/docs/prometheus/latest/feature_flags/
     */
    @JsonProperty("enableFeatures")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getEnableFeatures() {
        return enableFeatures;
    }

    /**
     * Enable access to Prometheus feature flags. By default, no features are enabled.<br><p> <br><p> Enabling features which are disabled by default is entirely outside the scope of what the maintainers will support and by doing so, you accept that this behaviour may break at any time without notice.<br><p> <br><p> For more information see https://prometheus.io/docs/prometheus/latest/feature_flags/
     */
    @JsonProperty("enableFeatures")
    public void setEnableFeatures(List<String> enableFeatures) {
        this.enableFeatures = enableFeatures;
    }

    /**
     * Enable Prometheus to be used as a receiver for the OTLP Metrics protocol.<br><p> <br><p> Note that the OTLP receiver endpoint is automatically enabled if `.spec.otlpConfig` is defined.<br><p> <br><p> It requires Prometheus &gt;= v2.47.0.
     */
    @JsonProperty("enableOTLPReceiver")
    public Boolean getEnableOTLPReceiver() {
        return enableOTLPReceiver;
    }

    /**
     * Enable Prometheus to be used as a receiver for the OTLP Metrics protocol.<br><p> <br><p> Note that the OTLP receiver endpoint is automatically enabled if `.spec.otlpConfig` is defined.<br><p> <br><p> It requires Prometheus &gt;= v2.47.0.
     */
    @JsonProperty("enableOTLPReceiver")
    public void setEnableOTLPReceiver(Boolean enableOTLPReceiver) {
        this.enableOTLPReceiver = enableOTLPReceiver;
    }

    /**
     * Enable Prometheus to be used as a receiver for the Prometheus remote write protocol.<br><p> <br><p> WARNING: This is not considered an efficient way of ingesting samples. Use it with caution for specific low-volume use cases. It is not suitable for replacing the ingestion via scraping and turning Prometheus into a push-based metrics collection system. For more information see https://prometheus.io/docs/prometheus/latest/querying/api/#remote-write-receiver<br><p> <br><p> It requires Prometheus &gt;= v2.33.0.
     */
    @JsonProperty("enableRemoteWriteReceiver")
    public Boolean getEnableRemoteWriteReceiver() {
        return enableRemoteWriteReceiver;
    }

    /**
     * Enable Prometheus to be used as a receiver for the Prometheus remote write protocol.<br><p> <br><p> WARNING: This is not considered an efficient way of ingesting samples. Use it with caution for specific low-volume use cases. It is not suitable for replacing the ingestion via scraping and turning Prometheus into a push-based metrics collection system. For more information see https://prometheus.io/docs/prometheus/latest/querying/api/#remote-write-receiver<br><p> <br><p> It requires Prometheus &gt;= v2.33.0.
     */
    @JsonProperty("enableRemoteWriteReceiver")
    public void setEnableRemoteWriteReceiver(Boolean enableRemoteWriteReceiver) {
        this.enableRemoteWriteReceiver = enableRemoteWriteReceiver;
    }

    /**
     * Indicates whether information about services should be injected into pod's environment variables
     */
    @JsonProperty("enableServiceLinks")
    public Boolean getEnableServiceLinks() {
        return enableServiceLinks;
    }

    /**
     * Indicates whether information about services should be injected into pod's environment variables
     */
    @JsonProperty("enableServiceLinks")
    public void setEnableServiceLinks(Boolean enableServiceLinks) {
        this.enableServiceLinks = enableServiceLinks;
    }

    /**
     * When defined, enforcedBodySizeLimit specifies a global limit on the size of uncompressed response body that will be accepted by Prometheus. Targets responding with a body larger than this many bytes will cause the scrape to fail.<br><p> <br><p> It requires Prometheus &gt;= v2.28.0.<br><p> <br><p> When both `enforcedBodySizeLimit` and `bodySizeLimit` are defined and greater than zero, the following rules apply: &#42; Scrape objects without a defined bodySizeLimit value will inherit the global bodySizeLimit value (Prometheus &gt;= 2.45.0) or the enforcedBodySizeLimit value (Prometheus &lt; v2.45.0).<br><p>   If Prometheus version is &gt;= 2.45.0 and the `enforcedBodySizeLimit` is greater than the `bodySizeLimit`, the `bodySizeLimit` will be set to `enforcedBodySizeLimit`.<br><p> &#42; Scrape objects with a bodySizeLimit value less than or equal to enforcedBodySizeLimit keep their specific value. &#42; Scrape objects with a bodySizeLimit value greater than enforcedBodySizeLimit are set to enforcedBodySizeLimit.
     */
    @JsonProperty("enforcedBodySizeLimit")
    public String getEnforcedBodySizeLimit() {
        return enforcedBodySizeLimit;
    }

    /**
     * When defined, enforcedBodySizeLimit specifies a global limit on the size of uncompressed response body that will be accepted by Prometheus. Targets responding with a body larger than this many bytes will cause the scrape to fail.<br><p> <br><p> It requires Prometheus &gt;= v2.28.0.<br><p> <br><p> When both `enforcedBodySizeLimit` and `bodySizeLimit` are defined and greater than zero, the following rules apply: &#42; Scrape objects without a defined bodySizeLimit value will inherit the global bodySizeLimit value (Prometheus &gt;= 2.45.0) or the enforcedBodySizeLimit value (Prometheus &lt; v2.45.0).<br><p>   If Prometheus version is &gt;= 2.45.0 and the `enforcedBodySizeLimit` is greater than the `bodySizeLimit`, the `bodySizeLimit` will be set to `enforcedBodySizeLimit`.<br><p> &#42; Scrape objects with a bodySizeLimit value less than or equal to enforcedBodySizeLimit keep their specific value. &#42; Scrape objects with a bodySizeLimit value greater than enforcedBodySizeLimit are set to enforcedBodySizeLimit.
     */
    @JsonProperty("enforcedBodySizeLimit")
    public void setEnforcedBodySizeLimit(String enforcedBodySizeLimit) {
        this.enforcedBodySizeLimit = enforcedBodySizeLimit;
    }

    /**
     * When defined, enforcedKeepDroppedTargets specifies a global limit on the number of targets dropped by relabeling that will be kept in memory. The value overrides any `spec.keepDroppedTargets` set by ServiceMonitor, PodMonitor, Probe objects unless `spec.keepDroppedTargets` is greater than zero and less than `spec.enforcedKeepDroppedTargets`.<br><p> <br><p> It requires Prometheus &gt;= v2.47.0.<br><p> <br><p> When both `enforcedKeepDroppedTargets` and `keepDroppedTargets` are defined and greater than zero, the following rules apply: &#42; Scrape objects without a defined keepDroppedTargets value will inherit the global keepDroppedTargets value (Prometheus &gt;= 2.45.0) or the enforcedKeepDroppedTargets value (Prometheus &lt; v2.45.0).<br><p>   If Prometheus version is &gt;= 2.45.0 and the `enforcedKeepDroppedTargets` is greater than the `keepDroppedTargets`, the `keepDroppedTargets` will be set to `enforcedKeepDroppedTargets`.<br><p> &#42; Scrape objects with a keepDroppedTargets value less than or equal to enforcedKeepDroppedTargets keep their specific value. &#42; Scrape objects with a keepDroppedTargets value greater than enforcedKeepDroppedTargets are set to enforcedKeepDroppedTargets.
     */
    @JsonProperty("enforcedKeepDroppedTargets")
    public Long getEnforcedKeepDroppedTargets() {
        return enforcedKeepDroppedTargets;
    }

    /**
     * When defined, enforcedKeepDroppedTargets specifies a global limit on the number of targets dropped by relabeling that will be kept in memory. The value overrides any `spec.keepDroppedTargets` set by ServiceMonitor, PodMonitor, Probe objects unless `spec.keepDroppedTargets` is greater than zero and less than `spec.enforcedKeepDroppedTargets`.<br><p> <br><p> It requires Prometheus &gt;= v2.47.0.<br><p> <br><p> When both `enforcedKeepDroppedTargets` and `keepDroppedTargets` are defined and greater than zero, the following rules apply: &#42; Scrape objects without a defined keepDroppedTargets value will inherit the global keepDroppedTargets value (Prometheus &gt;= 2.45.0) or the enforcedKeepDroppedTargets value (Prometheus &lt; v2.45.0).<br><p>   If Prometheus version is &gt;= 2.45.0 and the `enforcedKeepDroppedTargets` is greater than the `keepDroppedTargets`, the `keepDroppedTargets` will be set to `enforcedKeepDroppedTargets`.<br><p> &#42; Scrape objects with a keepDroppedTargets value less than or equal to enforcedKeepDroppedTargets keep their specific value. &#42; Scrape objects with a keepDroppedTargets value greater than enforcedKeepDroppedTargets are set to enforcedKeepDroppedTargets.
     */
    @JsonProperty("enforcedKeepDroppedTargets")
    public void setEnforcedKeepDroppedTargets(Long enforcedKeepDroppedTargets) {
        this.enforcedKeepDroppedTargets = enforcedKeepDroppedTargets;
    }

    /**
     * When defined, enforcedLabelLimit specifies a global limit on the number of labels per sample. The value overrides any `spec.labelLimit` set by ServiceMonitor, PodMonitor, Probe objects unless `spec.labelLimit` is greater than zero and less than `spec.enforcedLabelLimit`.<br><p> <br><p> It requires Prometheus &gt;= v2.27.0.<br><p> <br><p> When both `enforcedLabelLimit` and `labelLimit` are defined and greater than zero, the following rules apply: &#42; Scrape objects without a defined labelLimit value will inherit the global labelLimit value (Prometheus &gt;= 2.45.0) or the enforcedLabelLimit value (Prometheus &lt; v2.45.0).<br><p>   If Prometheus version is &gt;= 2.45.0 and the `enforcedLabelLimit` is greater than the `labelLimit`, the `labelLimit` will be set to `enforcedLabelLimit`.<br><p> &#42; Scrape objects with a labelLimit value less than or equal to enforcedLabelLimit keep their specific value. &#42; Scrape objects with a labelLimit value greater than enforcedLabelLimit are set to enforcedLabelLimit.
     */
    @JsonProperty("enforcedLabelLimit")
    public Long getEnforcedLabelLimit() {
        return enforcedLabelLimit;
    }

    /**
     * When defined, enforcedLabelLimit specifies a global limit on the number of labels per sample. The value overrides any `spec.labelLimit` set by ServiceMonitor, PodMonitor, Probe objects unless `spec.labelLimit` is greater than zero and less than `spec.enforcedLabelLimit`.<br><p> <br><p> It requires Prometheus &gt;= v2.27.0.<br><p> <br><p> When both `enforcedLabelLimit` and `labelLimit` are defined and greater than zero, the following rules apply: &#42; Scrape objects without a defined labelLimit value will inherit the global labelLimit value (Prometheus &gt;= 2.45.0) or the enforcedLabelLimit value (Prometheus &lt; v2.45.0).<br><p>   If Prometheus version is &gt;= 2.45.0 and the `enforcedLabelLimit` is greater than the `labelLimit`, the `labelLimit` will be set to `enforcedLabelLimit`.<br><p> &#42; Scrape objects with a labelLimit value less than or equal to enforcedLabelLimit keep their specific value. &#42; Scrape objects with a labelLimit value greater than enforcedLabelLimit are set to enforcedLabelLimit.
     */
    @JsonProperty("enforcedLabelLimit")
    public void setEnforcedLabelLimit(Long enforcedLabelLimit) {
        this.enforcedLabelLimit = enforcedLabelLimit;
    }

    /**
     * When defined, enforcedLabelNameLengthLimit specifies a global limit on the length of labels name per sample. The value overrides any `spec.labelNameLengthLimit` set by ServiceMonitor, PodMonitor, Probe objects unless `spec.labelNameLengthLimit` is greater than zero and less than `spec.enforcedLabelNameLengthLimit`.<br><p> <br><p> It requires Prometheus &gt;= v2.27.0.<br><p> <br><p> When both `enforcedLabelNameLengthLimit` and `labelNameLengthLimit` are defined and greater than zero, the following rules apply: &#42; Scrape objects without a defined labelNameLengthLimit value will inherit the global labelNameLengthLimit value (Prometheus &gt;= 2.45.0) or the enforcedLabelNameLengthLimit value (Prometheus &lt; v2.45.0).<br><p>   If Prometheus version is &gt;= 2.45.0 and the `enforcedLabelNameLengthLimit` is greater than the `labelNameLengthLimit`, the `labelNameLengthLimit` will be set to `enforcedLabelNameLengthLimit`.<br><p> &#42; Scrape objects with a labelNameLengthLimit value less than or equal to enforcedLabelNameLengthLimit keep their specific value. &#42; Scrape objects with a labelNameLengthLimit value greater than enforcedLabelNameLengthLimit are set to enforcedLabelNameLengthLimit.
     */
    @JsonProperty("enforcedLabelNameLengthLimit")
    public Long getEnforcedLabelNameLengthLimit() {
        return enforcedLabelNameLengthLimit;
    }

    /**
     * When defined, enforcedLabelNameLengthLimit specifies a global limit on the length of labels name per sample. The value overrides any `spec.labelNameLengthLimit` set by ServiceMonitor, PodMonitor, Probe objects unless `spec.labelNameLengthLimit` is greater than zero and less than `spec.enforcedLabelNameLengthLimit`.<br><p> <br><p> It requires Prometheus &gt;= v2.27.0.<br><p> <br><p> When both `enforcedLabelNameLengthLimit` and `labelNameLengthLimit` are defined and greater than zero, the following rules apply: &#42; Scrape objects without a defined labelNameLengthLimit value will inherit the global labelNameLengthLimit value (Prometheus &gt;= 2.45.0) or the enforcedLabelNameLengthLimit value (Prometheus &lt; v2.45.0).<br><p>   If Prometheus version is &gt;= 2.45.0 and the `enforcedLabelNameLengthLimit` is greater than the `labelNameLengthLimit`, the `labelNameLengthLimit` will be set to `enforcedLabelNameLengthLimit`.<br><p> &#42; Scrape objects with a labelNameLengthLimit value less than or equal to enforcedLabelNameLengthLimit keep their specific value. &#42; Scrape objects with a labelNameLengthLimit value greater than enforcedLabelNameLengthLimit are set to enforcedLabelNameLengthLimit.
     */
    @JsonProperty("enforcedLabelNameLengthLimit")
    public void setEnforcedLabelNameLengthLimit(Long enforcedLabelNameLengthLimit) {
        this.enforcedLabelNameLengthLimit = enforcedLabelNameLengthLimit;
    }

    /**
     * When not null, enforcedLabelValueLengthLimit defines a global limit on the length of labels value per sample. The value overrides any `spec.labelValueLengthLimit` set by ServiceMonitor, PodMonitor, Probe objects unless `spec.labelValueLengthLimit` is greater than zero and less than `spec.enforcedLabelValueLengthLimit`.<br><p> <br><p> It requires Prometheus &gt;= v2.27.0.<br><p> <br><p> When both `enforcedLabelValueLengthLimit` and `labelValueLengthLimit` are defined and greater than zero, the following rules apply: &#42; Scrape objects without a defined labelValueLengthLimit value will inherit the global labelValueLengthLimit value (Prometheus &gt;= 2.45.0) or the enforcedLabelValueLengthLimit value (Prometheus &lt; v2.45.0).<br><p>   If Prometheus version is &gt;= 2.45.0 and the `enforcedLabelValueLengthLimit` is greater than the `labelValueLengthLimit`, the `labelValueLengthLimit` will be set to `enforcedLabelValueLengthLimit`.<br><p> &#42; Scrape objects with a labelValueLengthLimit value less than or equal to enforcedLabelValueLengthLimit keep their specific value. &#42; Scrape objects with a labelValueLengthLimit value greater than enforcedLabelValueLengthLimit are set to enforcedLabelValueLengthLimit.
     */
    @JsonProperty("enforcedLabelValueLengthLimit")
    public Long getEnforcedLabelValueLengthLimit() {
        return enforcedLabelValueLengthLimit;
    }

    /**
     * When not null, enforcedLabelValueLengthLimit defines a global limit on the length of labels value per sample. The value overrides any `spec.labelValueLengthLimit` set by ServiceMonitor, PodMonitor, Probe objects unless `spec.labelValueLengthLimit` is greater than zero and less than `spec.enforcedLabelValueLengthLimit`.<br><p> <br><p> It requires Prometheus &gt;= v2.27.0.<br><p> <br><p> When both `enforcedLabelValueLengthLimit` and `labelValueLengthLimit` are defined and greater than zero, the following rules apply: &#42; Scrape objects without a defined labelValueLengthLimit value will inherit the global labelValueLengthLimit value (Prometheus &gt;= 2.45.0) or the enforcedLabelValueLengthLimit value (Prometheus &lt; v2.45.0).<br><p>   If Prometheus version is &gt;= 2.45.0 and the `enforcedLabelValueLengthLimit` is greater than the `labelValueLengthLimit`, the `labelValueLengthLimit` will be set to `enforcedLabelValueLengthLimit`.<br><p> &#42; Scrape objects with a labelValueLengthLimit value less than or equal to enforcedLabelValueLengthLimit keep their specific value. &#42; Scrape objects with a labelValueLengthLimit value greater than enforcedLabelValueLengthLimit are set to enforcedLabelValueLengthLimit.
     */
    @JsonProperty("enforcedLabelValueLengthLimit")
    public void setEnforcedLabelValueLengthLimit(Long enforcedLabelValueLengthLimit) {
        this.enforcedLabelValueLengthLimit = enforcedLabelValueLengthLimit;
    }

    /**
     * When not empty, a label will be added to:<br><p> <br><p> 1. All metrics scraped from `ServiceMonitor`, `PodMonitor`, `Probe` and `ScrapeConfig` objects. 2. All metrics generated from recording rules defined in `PrometheusRule` objects. 3. All alerts generated from alerting rules defined in `PrometheusRule` objects. 4. All vector selectors of PromQL expressions defined in `PrometheusRule` objects.<br><p> <br><p> The label will not added for objects referenced in `spec.excludedFromEnforcement`.<br><p> <br><p> The label's name is this field's value. The label's value is the namespace of the `ServiceMonitor`, `PodMonitor`, `Probe`, `PrometheusRule` or `ScrapeConfig` object.
     */
    @JsonProperty("enforcedNamespaceLabel")
    public String getEnforcedNamespaceLabel() {
        return enforcedNamespaceLabel;
    }

    /**
     * When not empty, a label will be added to:<br><p> <br><p> 1. All metrics scraped from `ServiceMonitor`, `PodMonitor`, `Probe` and `ScrapeConfig` objects. 2. All metrics generated from recording rules defined in `PrometheusRule` objects. 3. All alerts generated from alerting rules defined in `PrometheusRule` objects. 4. All vector selectors of PromQL expressions defined in `PrometheusRule` objects.<br><p> <br><p> The label will not added for objects referenced in `spec.excludedFromEnforcement`.<br><p> <br><p> The label's name is this field's value. The label's value is the namespace of the `ServiceMonitor`, `PodMonitor`, `Probe`, `PrometheusRule` or `ScrapeConfig` object.
     */
    @JsonProperty("enforcedNamespaceLabel")
    public void setEnforcedNamespaceLabel(String enforcedNamespaceLabel) {
        this.enforcedNamespaceLabel = enforcedNamespaceLabel;
    }

    /**
     * When defined, enforcedSampleLimit specifies a global limit on the number of scraped samples that will be accepted. This overrides any `spec.sampleLimit` set by ServiceMonitor, PodMonitor, Probe objects unless `spec.sampleLimit` is greater than zero and less than `spec.enforcedSampleLimit`.<br><p> <br><p> It is meant to be used by admins to keep the overall number of samples/series under a desired limit.<br><p> <br><p> When both `enforcedSampleLimit` and `sampleLimit` are defined and greater than zero, the following rules apply: &#42; Scrape objects without a defined sampleLimit value will inherit the global sampleLimit value (Prometheus &gt;= 2.45.0) or the enforcedSampleLimit value (Prometheus &lt; v2.45.0).<br><p>   If Prometheus version is &gt;= 2.45.0 and the `enforcedSampleLimit` is greater than the `sampleLimit`, the `sampleLimit` will be set to `enforcedSampleLimit`.<br><p> &#42; Scrape objects with a sampleLimit value less than or equal to enforcedSampleLimit keep their specific value. &#42; Scrape objects with a sampleLimit value greater than enforcedSampleLimit are set to enforcedSampleLimit.
     */
    @JsonProperty("enforcedSampleLimit")
    public Long getEnforcedSampleLimit() {
        return enforcedSampleLimit;
    }

    /**
     * When defined, enforcedSampleLimit specifies a global limit on the number of scraped samples that will be accepted. This overrides any `spec.sampleLimit` set by ServiceMonitor, PodMonitor, Probe objects unless `spec.sampleLimit` is greater than zero and less than `spec.enforcedSampleLimit`.<br><p> <br><p> It is meant to be used by admins to keep the overall number of samples/series under a desired limit.<br><p> <br><p> When both `enforcedSampleLimit` and `sampleLimit` are defined and greater than zero, the following rules apply: &#42; Scrape objects without a defined sampleLimit value will inherit the global sampleLimit value (Prometheus &gt;= 2.45.0) or the enforcedSampleLimit value (Prometheus &lt; v2.45.0).<br><p>   If Prometheus version is &gt;= 2.45.0 and the `enforcedSampleLimit` is greater than the `sampleLimit`, the `sampleLimit` will be set to `enforcedSampleLimit`.<br><p> &#42; Scrape objects with a sampleLimit value less than or equal to enforcedSampleLimit keep their specific value. &#42; Scrape objects with a sampleLimit value greater than enforcedSampleLimit are set to enforcedSampleLimit.
     */
    @JsonProperty("enforcedSampleLimit")
    public void setEnforcedSampleLimit(Long enforcedSampleLimit) {
        this.enforcedSampleLimit = enforcedSampleLimit;
    }

    /**
     * When defined, enforcedTargetLimit specifies a global limit on the number of scraped targets. The value overrides any `spec.targetLimit` set by ServiceMonitor, PodMonitor, Probe objects unless `spec.targetLimit` is greater than zero and less than `spec.enforcedTargetLimit`.<br><p> <br><p> It is meant to be used by admins to to keep the overall number of targets under a desired limit.<br><p> <br><p> When both `enforcedTargetLimit` and `targetLimit` are defined and greater than zero, the following rules apply: &#42; Scrape objects without a defined targetLimit value will inherit the global targetLimit value (Prometheus &gt;= 2.45.0) or the enforcedTargetLimit value (Prometheus &lt; v2.45.0).<br><p>   If Prometheus version is &gt;= 2.45.0 and the `enforcedTargetLimit` is greater than the `targetLimit`, the `targetLimit` will be set to `enforcedTargetLimit`.<br><p> &#42; Scrape objects with a targetLimit value less than or equal to enforcedTargetLimit keep their specific value. &#42; Scrape objects with a targetLimit value greater than enforcedTargetLimit are set to enforcedTargetLimit.
     */
    @JsonProperty("enforcedTargetLimit")
    public Long getEnforcedTargetLimit() {
        return enforcedTargetLimit;
    }

    /**
     * When defined, enforcedTargetLimit specifies a global limit on the number of scraped targets. The value overrides any `spec.targetLimit` set by ServiceMonitor, PodMonitor, Probe objects unless `spec.targetLimit` is greater than zero and less than `spec.enforcedTargetLimit`.<br><p> <br><p> It is meant to be used by admins to to keep the overall number of targets under a desired limit.<br><p> <br><p> When both `enforcedTargetLimit` and `targetLimit` are defined and greater than zero, the following rules apply: &#42; Scrape objects without a defined targetLimit value will inherit the global targetLimit value (Prometheus &gt;= 2.45.0) or the enforcedTargetLimit value (Prometheus &lt; v2.45.0).<br><p>   If Prometheus version is &gt;= 2.45.0 and the `enforcedTargetLimit` is greater than the `targetLimit`, the `targetLimit` will be set to `enforcedTargetLimit`.<br><p> &#42; Scrape objects with a targetLimit value less than or equal to enforcedTargetLimit keep their specific value. &#42; Scrape objects with a targetLimit value greater than enforcedTargetLimit are set to enforcedTargetLimit.
     */
    @JsonProperty("enforcedTargetLimit")
    public void setEnforcedTargetLimit(Long enforcedTargetLimit) {
        this.enforcedTargetLimit = enforcedTargetLimit;
    }

    /**
     * List of references to PodMonitor, ServiceMonitor, Probe and PrometheusRule objects to be excluded from enforcing a namespace label of origin.<br><p> <br><p> It is only applicable if `spec.enforcedNamespaceLabel` set to true.
     */
    @JsonProperty("excludedFromEnforcement")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<ObjectReference> getExcludedFromEnforcement() {
        return excludedFromEnforcement;
    }

    /**
     * List of references to PodMonitor, ServiceMonitor, Probe and PrometheusRule objects to be excluded from enforcing a namespace label of origin.<br><p> <br><p> It is only applicable if `spec.enforcedNamespaceLabel` set to true.
     */
    @JsonProperty("excludedFromEnforcement")
    public void setExcludedFromEnforcement(List<ObjectReference> excludedFromEnforcement) {
        this.excludedFromEnforcement = excludedFromEnforcement;
    }

    /**
     * The labels to add to any time series or alerts when communicating with external systems (federation, remote storage, Alertmanager). Labels defined by `spec.replicaExternalLabelName` and `spec.prometheusExternalLabelName` take precedence over this list.
     */
    @JsonProperty("externalLabels")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public Map<String, String> getExternalLabels() {
        return externalLabels;
    }

    /**
     * The labels to add to any time series or alerts when communicating with external systems (federation, remote storage, Alertmanager). Labels defined by `spec.replicaExternalLabelName` and `spec.prometheusExternalLabelName` take precedence over this list.
     */
    @JsonProperty("externalLabels")
    public void setExternalLabels(Map<String, String> externalLabels) {
        this.externalLabels = externalLabels;
    }

    /**
     * The external URL under which the Prometheus service is externally available. This is necessary to generate correct URLs (for instance if Prometheus is accessible behind an Ingress resource).
     */
    @JsonProperty("externalUrl")
    public String getExternalUrl() {
        return externalUrl;
    }

    /**
     * The external URL under which the Prometheus service is externally available. This is necessary to generate correct URLs (for instance if Prometheus is accessible behind an Ingress resource).
     */
    @JsonProperty("externalUrl")
    public void setExternalUrl(String externalUrl) {
        this.externalUrl = externalUrl;
    }

    /**
     * Optional list of hosts and IPs that will be injected into the Pod's hosts file if specified.
     */
    @JsonProperty("hostAliases")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<HostAlias> getHostAliases() {
        return hostAliases;
    }

    /**
     * Optional list of hosts and IPs that will be injected into the Pod's hosts file if specified.
     */
    @JsonProperty("hostAliases")
    public void setHostAliases(List<HostAlias> hostAliases) {
        this.hostAliases = hostAliases;
    }

    /**
     * Use the host's network namespace if true.<br><p> <br><p> Make sure to understand the security implications if you want to enable it (https://kubernetes.io/docs/concepts/configuration/overview/ ).<br><p> <br><p> When hostNetwork is enabled, this will set the DNS policy to `ClusterFirstWithHostNet` automatically (unless `.spec.DNSPolicy` is set to a different value).
     */
    @JsonProperty("hostNetwork")
    public Boolean getHostNetwork() {
        return hostNetwork;
    }

    /**
     * Use the host's network namespace if true.<br><p> <br><p> Make sure to understand the security implications if you want to enable it (https://kubernetes.io/docs/concepts/configuration/overview/ ).<br><p> <br><p> When hostNetwork is enabled, this will set the DNS policy to `ClusterFirstWithHostNet` automatically (unless `.spec.DNSPolicy` is set to a different value).
     */
    @JsonProperty("hostNetwork")
    public void setHostNetwork(Boolean hostNetwork) {
        this.hostNetwork = hostNetwork;
    }

    /**
     * HostUsers supports the user space in Kubernetes.<br><p> <br><p> More info: https://kubernetes.io/docs/tasks/configure-pod-container/user-namespaces/<br><p> <br><p> The feature requires at least Kubernetes 1.28 with the `UserNamespacesSupport` feature gate enabled. Starting Kubernetes 1.33, the feature is enabled by default.
     */
    @JsonProperty("hostUsers")
    public Boolean getHostUsers() {
        return hostUsers;
    }

    /**
     * HostUsers supports the user space in Kubernetes.<br><p> <br><p> More info: https://kubernetes.io/docs/tasks/configure-pod-container/user-namespaces/<br><p> <br><p> The feature requires at least Kubernetes 1.28 with the `UserNamespacesSupport` feature gate enabled. Starting Kubernetes 1.33, the feature is enabled by default.
     */
    @JsonProperty("hostUsers")
    public void setHostUsers(Boolean hostUsers) {
        this.hostUsers = hostUsers;
    }

    /**
     * When true, `spec.namespaceSelector` from all PodMonitor, ServiceMonitor and Probe objects will be ignored. They will only discover targets within the namespace of the PodMonitor, ServiceMonitor and Probe object.
     */
    @JsonProperty("ignoreNamespaceSelectors")
    public Boolean getIgnoreNamespaceSelectors() {
        return ignoreNamespaceSelectors;
    }

    /**
     * When true, `spec.namespaceSelector` from all PodMonitor, ServiceMonitor and Probe objects will be ignored. They will only discover targets within the namespace of the PodMonitor, ServiceMonitor and Probe object.
     */
    @JsonProperty("ignoreNamespaceSelectors")
    public void setIgnoreNamespaceSelectors(Boolean ignoreNamespaceSelectors) {
        this.ignoreNamespaceSelectors = ignoreNamespaceSelectors;
    }

    /**
     * Container image name for Prometheus. If specified, it takes precedence over the `spec.baseImage`, `spec.tag` and `spec.sha` fields.<br><p> <br><p> Specifying `spec.version` is still necessary to ensure the Prometheus Operator knows which version of Prometheus is being configured.<br><p> <br><p> If neither `spec.image` nor `spec.baseImage` are defined, the operator will use the latest upstream version of Prometheus available at the time when the operator was released.
     */
    @JsonProperty("image")
    public String getImage() {
        return image;
    }

    /**
     * Container image name for Prometheus. If specified, it takes precedence over the `spec.baseImage`, `spec.tag` and `spec.sha` fields.<br><p> <br><p> Specifying `spec.version` is still necessary to ensure the Prometheus Operator knows which version of Prometheus is being configured.<br><p> <br><p> If neither `spec.image` nor `spec.baseImage` are defined, the operator will use the latest upstream version of Prometheus available at the time when the operator was released.
     */
    @JsonProperty("image")
    public void setImage(String image) {
        this.image = image;
    }

    /**
     * Image pull policy for the 'prometheus', 'init-config-reloader' and 'config-reloader' containers. See https://kubernetes.io/docs/concepts/containers/images/#image-pull-policy for more details.<br><p> <br><p> Possible enum values:<br><p>  - `"Always"` means that kubelet always attempts to pull the latest image. Container will fail If the pull fails.<br><p>  - `"IfNotPresent"` means that kubelet pulls if the image isn't present on disk. Container will fail if the image isn't present and the pull fails.<br><p>  - `"Never"` means that kubelet never pulls an image, but only uses a local image. Container will fail if the image isn't present
     */
    @JsonProperty("imagePullPolicy")
    public String getImagePullPolicy() {
        return imagePullPolicy;
    }

    /**
     * Image pull policy for the 'prometheus', 'init-config-reloader' and 'config-reloader' containers. See https://kubernetes.io/docs/concepts/containers/images/#image-pull-policy for more details.<br><p> <br><p> Possible enum values:<br><p>  - `"Always"` means that kubelet always attempts to pull the latest image. Container will fail If the pull fails.<br><p>  - `"IfNotPresent"` means that kubelet pulls if the image isn't present on disk. Container will fail if the image isn't present and the pull fails.<br><p>  - `"Never"` means that kubelet never pulls an image, but only uses a local image. Container will fail if the image isn't present
     */
    @JsonProperty("imagePullPolicy")
    public void setImagePullPolicy(String imagePullPolicy) {
        this.imagePullPolicy = imagePullPolicy;
    }

    /**
     * An optional list of references to Secrets in the same namespace to use for pulling images from registries. See http://kubernetes.io/docs/user-guide/images#specifying-imagepullsecrets-on-a-pod
     */
    @JsonProperty("imagePullSecrets")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<LocalObjectReference> getImagePullSecrets() {
        return imagePullSecrets;
    }

    /**
     * An optional list of references to Secrets in the same namespace to use for pulling images from registries. See http://kubernetes.io/docs/user-guide/images#specifying-imagepullsecrets-on-a-pod
     */
    @JsonProperty("imagePullSecrets")
    public void setImagePullSecrets(List<LocalObjectReference> imagePullSecrets) {
        this.imagePullSecrets = imagePullSecrets;
    }

    /**
     * InitContainers allows injecting initContainers to the Pod definition. Those can be used to e.g.  fetch secrets for injection into the Prometheus configuration from external sources. Any errors during the execution of an initContainer will lead to a restart of the Pod. More info: https://kubernetes.io/docs/concepts/workloads/pods/init-containers/ InitContainers described here modify an operator generated init containers if they share the same name and modifications are done via a strategic merge patch.<br><p> <br><p> The names of init container name managed by the operator are: &#42; `init-config-reloader`.<br><p> <br><p> Overriding init containers is entirely outside the scope of what the maintainers will support and by doing so, you accept that this behaviour may break at any time without notice.
     */
    @JsonProperty("initContainers")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<Container> getInitContainers() {
        return initContainers;
    }

    /**
     * InitContainers allows injecting initContainers to the Pod definition. Those can be used to e.g.  fetch secrets for injection into the Prometheus configuration from external sources. Any errors during the execution of an initContainer will lead to a restart of the Pod. More info: https://kubernetes.io/docs/concepts/workloads/pods/init-containers/ InitContainers described here modify an operator generated init containers if they share the same name and modifications are done via a strategic merge patch.<br><p> <br><p> The names of init container name managed by the operator are: &#42; `init-config-reloader`.<br><p> <br><p> Overriding init containers is entirely outside the scope of what the maintainers will support and by doing so, you accept that this behaviour may break at any time without notice.
     */
    @JsonProperty("initContainers")
    public void setInitContainers(List<Container> initContainers) {
        this.initContainers = initContainers;
    }

    /**
     * Per-scrape limit on the number of targets dropped by relabeling that will be kept in memory. 0 means no limit.<br><p> <br><p> It requires Prometheus &gt;= v2.47.0.<br><p> <br><p> Note that the global limit only applies to scrape objects that don't specify an explicit limit value. If you want to enforce a maximum limit for all scrape objects, refer to enforcedKeepDroppedTargets.
     */
    @JsonProperty("keepDroppedTargets")
    public Long getKeepDroppedTargets() {
        return keepDroppedTargets;
    }

    /**
     * Per-scrape limit on the number of targets dropped by relabeling that will be kept in memory. 0 means no limit.<br><p> <br><p> It requires Prometheus &gt;= v2.47.0.<br><p> <br><p> Note that the global limit only applies to scrape objects that don't specify an explicit limit value. If you want to enforce a maximum limit for all scrape objects, refer to enforcedKeepDroppedTargets.
     */
    @JsonProperty("keepDroppedTargets")
    public void setKeepDroppedTargets(Long keepDroppedTargets) {
        this.keepDroppedTargets = keepDroppedTargets;
    }

    /**
     * Per-scrape limit on number of labels that will be accepted for a sample. Only valid in Prometheus versions 2.45.0 and newer.<br><p> <br><p> Note that the global limit only applies to scrape objects that don't specify an explicit limit value. If you want to enforce a maximum limit for all scrape objects, refer to enforcedLabelLimit.
     */
    @JsonProperty("labelLimit")
    public Long getLabelLimit() {
        return labelLimit;
    }

    /**
     * Per-scrape limit on number of labels that will be accepted for a sample. Only valid in Prometheus versions 2.45.0 and newer.<br><p> <br><p> Note that the global limit only applies to scrape objects that don't specify an explicit limit value. If you want to enforce a maximum limit for all scrape objects, refer to enforcedLabelLimit.
     */
    @JsonProperty("labelLimit")
    public void setLabelLimit(Long labelLimit) {
        this.labelLimit = labelLimit;
    }

    /**
     * Per-scrape limit on length of labels name that will be accepted for a sample. Only valid in Prometheus versions 2.45.0 and newer.<br><p> <br><p> Note that the global limit only applies to scrape objects that don't specify an explicit limit value. If you want to enforce a maximum limit for all scrape objects, refer to enforcedLabelNameLengthLimit.
     */
    @JsonProperty("labelNameLengthLimit")
    public Long getLabelNameLengthLimit() {
        return labelNameLengthLimit;
    }

    /**
     * Per-scrape limit on length of labels name that will be accepted for a sample. Only valid in Prometheus versions 2.45.0 and newer.<br><p> <br><p> Note that the global limit only applies to scrape objects that don't specify an explicit limit value. If you want to enforce a maximum limit for all scrape objects, refer to enforcedLabelNameLengthLimit.
     */
    @JsonProperty("labelNameLengthLimit")
    public void setLabelNameLengthLimit(Long labelNameLengthLimit) {
        this.labelNameLengthLimit = labelNameLengthLimit;
    }

    /**
     * Per-scrape limit on length of labels value that will be accepted for a sample. Only valid in Prometheus versions 2.45.0 and newer.<br><p> <br><p> Note that the global limit only applies to scrape objects that don't specify an explicit limit value. If you want to enforce a maximum limit for all scrape objects, refer to enforcedLabelValueLengthLimit.
     */
    @JsonProperty("labelValueLengthLimit")
    public Long getLabelValueLengthLimit() {
        return labelValueLengthLimit;
    }

    /**
     * Per-scrape limit on length of labels value that will be accepted for a sample. Only valid in Prometheus versions 2.45.0 and newer.<br><p> <br><p> Note that the global limit only applies to scrape objects that don't specify an explicit limit value. If you want to enforce a maximum limit for all scrape objects, refer to enforcedLabelValueLengthLimit.
     */
    @JsonProperty("labelValueLengthLimit")
    public void setLabelValueLengthLimit(Long labelValueLengthLimit) {
        this.labelValueLengthLimit = labelValueLengthLimit;
    }

    /**
     * When true, the Prometheus server listens on the loopback address instead of the Pod IP's address.
     */
    @JsonProperty("listenLocal")
    public Boolean getListenLocal() {
        return listenLocal;
    }

    /**
     * When true, the Prometheus server listens on the loopback address instead of the Pod IP's address.
     */
    @JsonProperty("listenLocal")
    public void setListenLocal(Boolean listenLocal) {
        this.listenLocal = listenLocal;
    }

    /**
     * Log format for Log level for Prometheus and the config-reloader sidecar.
     */
    @JsonProperty("logFormat")
    public String getLogFormat() {
        return logFormat;
    }

    /**
     * Log format for Log level for Prometheus and the config-reloader sidecar.
     */
    @JsonProperty("logFormat")
    public void setLogFormat(String logFormat) {
        this.logFormat = logFormat;
    }

    /**
     * Log level for Prometheus and the config-reloader sidecar.
     */
    @JsonProperty("logLevel")
    public String getLogLevel() {
        return logLevel;
    }

    /**
     * Log level for Prometheus and the config-reloader sidecar.
     */
    @JsonProperty("logLevel")
    public void setLogLevel(String logLevel) {
        this.logLevel = logLevel;
    }

    /**
     * Defines the maximum time that the `prometheus` container's startup probe will wait before being considered failed. The startup probe will return success after the WAL replay is complete. If set, the value should be greater than 60 (seconds). Otherwise it will be equal to 600 seconds (15 minutes).
     */
    @JsonProperty("maximumStartupDurationSeconds")
    public Integer getMaximumStartupDurationSeconds() {
        return maximumStartupDurationSeconds;
    }

    /**
     * Defines the maximum time that the `prometheus` container's startup probe will wait before being considered failed. The startup probe will return success after the WAL replay is complete. If set, the value should be greater than 60 (seconds). Otherwise it will be equal to 600 seconds (15 minutes).
     */
    @JsonProperty("maximumStartupDurationSeconds")
    public void setMaximumStartupDurationSeconds(Integer maximumStartupDurationSeconds) {
        this.maximumStartupDurationSeconds = maximumStartupDurationSeconds;
    }

    /**
     * Minimum number of seconds for which a newly created Pod should be ready without any of its container crashing for it to be considered available.<br><p> <br><p> If unset, pods will be considered available as soon as they are ready.
     */
    @JsonProperty("minReadySeconds")
    public Integer getMinReadySeconds() {
        return minReadySeconds;
    }

    /**
     * Minimum number of seconds for which a newly created Pod should be ready without any of its container crashing for it to be considered available.<br><p> <br><p> If unset, pods will be considered available as soon as they are ready.
     */
    @JsonProperty("minReadySeconds")
    public void setMinReadySeconds(Integer minReadySeconds) {
        this.minReadySeconds = minReadySeconds;
    }

    /**
     * Mode defines how the Prometheus operator deploys the PrometheusAgent pod(s).<br><p> <br><p> (Alpha) Using this field requires the `PrometheusAgentDaemonSet` feature gate to be enabled.
     */
    @JsonProperty("mode")
    public String getMode() {
        return mode;
    }

    /**
     * Mode defines how the Prometheus operator deploys the PrometheusAgent pod(s).<br><p> <br><p> (Alpha) Using this field requires the `PrometheusAgentDaemonSet` feature gate to be enabled.
     */
    @JsonProperty("mode")
    public void setMode(String mode) {
        this.mode = mode;
    }

    /**
     * Specifies the character escaping scheme that will be requested when scraping for metric and label names that do not conform to the legacy Prometheus character set.<br><p> <br><p> It requires Prometheus &gt;= v3.4.0.
     */
    @JsonProperty("nameEscapingScheme")
    public String getNameEscapingScheme() {
        return nameEscapingScheme;
    }

    /**
     * Specifies the character escaping scheme that will be requested when scraping for metric and label names that do not conform to the legacy Prometheus character set.<br><p> <br><p> It requires Prometheus &gt;= v3.4.0.
     */
    @JsonProperty("nameEscapingScheme")
    public void setNameEscapingScheme(String nameEscapingScheme) {
        this.nameEscapingScheme = nameEscapingScheme;
    }

    /**
     * Specifies the validation scheme for metric and label names.<br><p> <br><p> It requires Prometheus &gt;= v2.55.0.
     */
    @JsonProperty("nameValidationScheme")
    public String getNameValidationScheme() {
        return nameValidationScheme;
    }

    /**
     * Specifies the validation scheme for metric and label names.<br><p> <br><p> It requires Prometheus &gt;= v2.55.0.
     */
    @JsonProperty("nameValidationScheme")
    public void setNameValidationScheme(String nameValidationScheme) {
        this.nameValidationScheme = nameValidationScheme;
    }

    /**
     * Defines on which Nodes the Pods are scheduled.
     */
    @JsonProperty("nodeSelector")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public Map<String, String> getNodeSelector() {
        return nodeSelector;
    }

    /**
     * Defines on which Nodes the Pods are scheduled.
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
     * When true, Prometheus resolves label conflicts by renaming the labels in the scraped data<br><p>  to "exported_" for all targets created from ServiceMonitor, PodMonitor and<br><p> ScrapeConfig objects. Otherwise the HonorLabels field of the service or pod monitor applies. In practice,`overrideHonorLaels:true` enforces `honorLabels:false` for all ServiceMonitor, PodMonitor and ScrapeConfig objects.
     */
    @JsonProperty("overrideHonorLabels")
    public Boolean getOverrideHonorLabels() {
        return overrideHonorLabels;
    }

    /**
     * When true, Prometheus resolves label conflicts by renaming the labels in the scraped data<br><p>  to "exported_" for all targets created from ServiceMonitor, PodMonitor and<br><p> ScrapeConfig objects. Otherwise the HonorLabels field of the service or pod monitor applies. In practice,`overrideHonorLaels:true` enforces `honorLabels:false` for all ServiceMonitor, PodMonitor and ScrapeConfig objects.
     */
    @JsonProperty("overrideHonorLabels")
    public void setOverrideHonorLabels(Boolean overrideHonorLabels) {
        this.overrideHonorLabels = overrideHonorLabels;
    }

    /**
     * When true, Prometheus ignores the timestamps for all the targets created from service and pod monitors. Otherwise the HonorTimestamps field of the service or pod monitor applies.
     */
    @JsonProperty("overrideHonorTimestamps")
    public Boolean getOverrideHonorTimestamps() {
        return overrideHonorTimestamps;
    }

    /**
     * When true, Prometheus ignores the timestamps for all the targets created from service and pod monitors. Otherwise the HonorTimestamps field of the service or pod monitor applies.
     */
    @JsonProperty("overrideHonorTimestamps")
    public void setOverrideHonorTimestamps(Boolean overrideHonorTimestamps) {
        this.overrideHonorTimestamps = overrideHonorTimestamps;
    }

    /**
     * When a Prometheus deployment is paused, no actions except for deletion will be performed on the underlying objects.
     */
    @JsonProperty("paused")
    public Boolean getPaused() {
        return paused;
    }

    /**
     * When a Prometheus deployment is paused, no actions except for deletion will be performed on the underlying objects.
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
     * PodTargetLabels are appended to the `spec.podTargetLabels` field of all PodMonitor and ServiceMonitor objects.
     */
    @JsonProperty("podTargetLabels")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getPodTargetLabels() {
        return podTargetLabels;
    }

    /**
     * PodTargetLabels are appended to the `spec.podTargetLabels` field of all PodMonitor and ServiceMonitor objects.
     */
    @JsonProperty("podTargetLabels")
    public void setPodTargetLabels(List<String> podTargetLabels) {
        this.podTargetLabels = podTargetLabels;
    }

    /**
     * Port name used for the pods and governing service. Default: "web"
     */
    @JsonProperty("portName")
    public String getPortName() {
        return portName;
    }

    /**
     * Port name used for the pods and governing service. Default: "web"
     */
    @JsonProperty("portName")
    public void setPortName(String portName) {
        this.portName = portName;
    }

    /**
     * Priority class assigned to the Pods.
     */
    @JsonProperty("priorityClassName")
    public String getPriorityClassName() {
        return priorityClassName;
    }

    /**
     * Priority class assigned to the Pods.
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
     * Name of Prometheus external label used to denote the Prometheus instance name. The external label will _not_ be added when the field is set to the empty string (`""`).<br><p> <br><p> Default: "prometheus"
     */
    @JsonProperty("prometheusExternalLabelName")
    public String getPrometheusExternalLabelName() {
        return prometheusExternalLabelName;
    }

    /**
     * Name of Prometheus external label used to denote the Prometheus instance name. The external label will _not_ be added when the field is set to the empty string (`""`).<br><p> <br><p> Default: "prometheus"
     */
    @JsonProperty("prometheusExternalLabelName")
    public void setPrometheusExternalLabelName(String prometheusExternalLabelName) {
        this.prometheusExternalLabelName = prometheusExternalLabelName;
    }

    /**
     * Defines the strategy used to reload the Prometheus configuration. If not specified, the configuration is reloaded using the /-/reload HTTP endpoint.
     */
    @JsonProperty("reloadStrategy")
    public String getReloadStrategy() {
        return reloadStrategy;
    }

    /**
     * Defines the strategy used to reload the Prometheus configuration. If not specified, the configuration is reloaded using the /-/reload HTTP endpoint.
     */
    @JsonProperty("reloadStrategy")
    public void setReloadStrategy(String reloadStrategy) {
        this.reloadStrategy = reloadStrategy;
    }

    /**
     * Defines the list of remote write configurations.
     */
    @JsonProperty("remoteWrite")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<RemoteWriteSpec> getRemoteWrite() {
        return remoteWrite;
    }

    /**
     * Defines the list of remote write configurations.
     */
    @JsonProperty("remoteWrite")
    public void setRemoteWrite(List<RemoteWriteSpec> remoteWrite) {
        this.remoteWrite = remoteWrite;
    }

    /**
     * List of the protobuf message versions to accept when receiving the remote writes.<br><p> <br><p> It requires Prometheus &gt;= v2.54.0.
     */
    @JsonProperty("remoteWriteReceiverMessageVersions")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getRemoteWriteReceiverMessageVersions() {
        return remoteWriteReceiverMessageVersions;
    }

    /**
     * List of the protobuf message versions to accept when receiving the remote writes.<br><p> <br><p> It requires Prometheus &gt;= v2.54.0.
     */
    @JsonProperty("remoteWriteReceiverMessageVersions")
    public void setRemoteWriteReceiverMessageVersions(List<String> remoteWriteReceiverMessageVersions) {
        this.remoteWriteReceiverMessageVersions = remoteWriteReceiverMessageVersions;
    }

    /**
     * Name of Prometheus external label used to denote the replica name. The external label will _not_ be added when the field is set to the empty string (`""`).<br><p> <br><p> Default: "prometheus_replica"
     */
    @JsonProperty("replicaExternalLabelName")
    public String getReplicaExternalLabelName() {
        return replicaExternalLabelName;
    }

    /**
     * Name of Prometheus external label used to denote the replica name. The external label will _not_ be added when the field is set to the empty string (`""`).<br><p> <br><p> Default: "prometheus_replica"
     */
    @JsonProperty("replicaExternalLabelName")
    public void setReplicaExternalLabelName(String replicaExternalLabelName) {
        this.replicaExternalLabelName = replicaExternalLabelName;
    }

    /**
     * Number of replicas of each shard to deploy for a Prometheus deployment. `spec.replicas` multiplied by `spec.shards` is the total number of Pods created.<br><p> <br><p> Default: 1
     */
    @JsonProperty("replicas")
    public Integer getReplicas() {
        return replicas;
    }

    /**
     * Number of replicas of each shard to deploy for a Prometheus deployment. `spec.replicas` multiplied by `spec.shards` is the total number of Pods created.<br><p> <br><p> Default: 1
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
     * The route prefix Prometheus registers HTTP handlers for.<br><p> <br><p> This is useful when using `spec.externalURL`, and a proxy is rewriting HTTP routes of a request, and the actual ExternalURL is still true, but the server serves requests under a different route prefix. For example for use with `kubectl proxy`.
     */
    @JsonProperty("routePrefix")
    public String getRoutePrefix() {
        return routePrefix;
    }

    /**
     * The route prefix Prometheus registers HTTP handlers for.<br><p> <br><p> This is useful when using `spec.externalURL`, and a proxy is rewriting HTTP routes of a request, and the actual ExternalURL is still true, but the server serves requests under a different route prefix. For example for use with `kubectl proxy`.
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
     * SampleLimit defines per-scrape limit on number of scraped samples that will be accepted. Only valid in Prometheus versions 2.45.0 and newer.<br><p> <br><p> Note that the global limit only applies to scrape objects that don't specify an explicit limit value. If you want to enforce a maximum limit for all scrape objects, refer to enforcedSampleLimit.
     */
    @JsonProperty("sampleLimit")
    public Long getSampleLimit() {
        return sampleLimit;
    }

    /**
     * SampleLimit defines per-scrape limit on number of scraped samples that will be accepted. Only valid in Prometheus versions 2.45.0 and newer.<br><p> <br><p> Note that the global limit only applies to scrape objects that don't specify an explicit limit value. If you want to enforce a maximum limit for all scrape objects, refer to enforcedSampleLimit.
     */
    @JsonProperty("sampleLimit")
    public void setSampleLimit(Long sampleLimit) {
        this.sampleLimit = sampleLimit;
    }

    /**
     * List of scrape classes to expose to scraping objects such as PodMonitors, ServiceMonitors, Probes and ScrapeConfigs.<br><p> <br><p> This is an &#42;experimental feature&#42;, it may change in any upcoming release in a breaking way.
     */
    @JsonProperty("scrapeClasses")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<ScrapeClass> getScrapeClasses() {
        return scrapeClasses;
    }

    /**
     * List of scrape classes to expose to scraping objects such as PodMonitors, ServiceMonitors, Probes and ScrapeConfigs.<br><p> <br><p> This is an &#42;experimental feature&#42;, it may change in any upcoming release in a breaking way.
     */
    @JsonProperty("scrapeClasses")
    public void setScrapeClasses(List<ScrapeClass> scrapeClasses) {
        this.scrapeClasses = scrapeClasses;
    }

    /**
     * Whether to scrape a classic histogram that is also exposed as a native histogram.<br><p> <br><p> Notice: `scrapeClassicHistograms` corresponds to the `always_scrape_classic_histograms` field in the Prometheus configuration.<br><p> <br><p> It requires Prometheus &gt;= v3.5.0.
     */
    @JsonProperty("scrapeClassicHistograms")
    public Boolean getScrapeClassicHistograms() {
        return scrapeClassicHistograms;
    }

    /**
     * Whether to scrape a classic histogram that is also exposed as a native histogram.<br><p> <br><p> Notice: `scrapeClassicHistograms` corresponds to the `always_scrape_classic_histograms` field in the Prometheus configuration.<br><p> <br><p> It requires Prometheus &gt;= v3.5.0.
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
     * File to which scrape failures are logged. Reloading the configuration will reopen the file.<br><p> <br><p> If the filename has an empty path, e.g. 'file.log', The Prometheus Pods will mount the file into an emptyDir volume at `/var/log/prometheus`. If a full path is provided, e.g. '/var/log/prometheus/file.log', you must mount a volume in the specified directory and it must be writable. It requires Prometheus &gt;= v2.55.0.
     */
    @JsonProperty("scrapeFailureLogFile")
    public String getScrapeFailureLogFile() {
        return scrapeFailureLogFile;
    }

    /**
     * File to which scrape failures are logged. Reloading the configuration will reopen the file.<br><p> <br><p> If the filename has an empty path, e.g. 'file.log', The Prometheus Pods will mount the file into an emptyDir volume at `/var/log/prometheus`. If a full path is provided, e.g. '/var/log/prometheus/file.log', you must mount a volume in the specified directory and it must be writable. It requires Prometheus &gt;= v2.55.0.
     */
    @JsonProperty("scrapeFailureLogFile")
    public void setScrapeFailureLogFile(String scrapeFailureLogFile) {
        this.scrapeFailureLogFile = scrapeFailureLogFile;
    }

    /**
     * Interval between consecutive scrapes.<br><p> <br><p> Default: "30s"
     */
    @JsonProperty("scrapeInterval")
    public String getScrapeInterval() {
        return scrapeInterval;
    }

    /**
     * Interval between consecutive scrapes.<br><p> <br><p> Default: "30s"
     */
    @JsonProperty("scrapeInterval")
    public void setScrapeInterval(String scrapeInterval) {
        this.scrapeInterval = scrapeInterval;
    }

    /**
     * The protocols to negotiate during a scrape. It tells clients the protocols supported by Prometheus in order of preference (from most to least preferred).<br><p> <br><p> If unset, Prometheus uses its default value.<br><p> <br><p> It requires Prometheus &gt;= v2.49.0.<br><p> <br><p> `PrometheusText1.0.0` requires Prometheus &gt;= v3.0.0.
     */
    @JsonProperty("scrapeProtocols")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getScrapeProtocols() {
        return scrapeProtocols;
    }

    /**
     * The protocols to negotiate during a scrape. It tells clients the protocols supported by Prometheus in order of preference (from most to least preferred).<br><p> <br><p> If unset, Prometheus uses its default value.<br><p> <br><p> It requires Prometheus &gt;= v2.49.0.<br><p> <br><p> `PrometheusText1.0.0` requires Prometheus &gt;= v3.0.0.
     */
    @JsonProperty("scrapeProtocols")
    public void setScrapeProtocols(List<String> scrapeProtocols) {
        this.scrapeProtocols = scrapeProtocols;
    }

    /**
     * Number of seconds to wait until a scrape request times out. The value cannot be greater than the scrape interval otherwise the operator will reject the resource.
     */
    @JsonProperty("scrapeTimeout")
    public String getScrapeTimeout() {
        return scrapeTimeout;
    }

    /**
     * Number of seconds to wait until a scrape request times out. The value cannot be greater than the scrape interval otherwise the operator will reject the resource.
     */
    @JsonProperty("scrapeTimeout")
    public void setScrapeTimeout(String scrapeTimeout) {
        this.scrapeTimeout = scrapeTimeout;
    }

    /**
     * Secrets is a list of Secrets in the same namespace as the Prometheus object, which shall be mounted into the Prometheus Pods. Each Secret is added to the StatefulSet definition as a volume named `secret-&lt;secret-name&gt;`. The Secrets are mounted into /etc/prometheus/secrets/&lt;secret-name&gt; in the 'prometheus' container.
     */
    @JsonProperty("secrets")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getSecrets() {
        return secrets;
    }

    /**
     * Secrets is a list of Secrets in the same namespace as the Prometheus object, which shall be mounted into the Prometheus Pods. Each Secret is added to the StatefulSet definition as a volume named `secret-&lt;secret-name&gt;`. The Secrets are mounted into /etc/prometheus/secrets/&lt;secret-name&gt; in the 'prometheus' container.
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
     * ServiceAccountName is the name of the ServiceAccount to use to run the Prometheus Pods.
     */
    @JsonProperty("serviceAccountName")
    public String getServiceAccountName() {
        return serviceAccountName;
    }

    /**
     * ServiceAccountName is the name of the ServiceAccount to use to run the Prometheus Pods.
     */
    @JsonProperty("serviceAccountName")
    public void setServiceAccountName(String serviceAccountName) {
        this.serviceAccountName = serviceAccountName;
    }

    /**
     * Defines the service discovery role used to discover targets from `ServiceMonitor` objects and Alertmanager endpoints.<br><p> <br><p> If set, the value should be either "Endpoints" or "EndpointSlice". If unset, the operator assumes the "Endpoints" role.
     */
    @JsonProperty("serviceDiscoveryRole")
    public String getServiceDiscoveryRole() {
        return serviceDiscoveryRole;
    }

    /**
     * Defines the service discovery role used to discover targets from `ServiceMonitor` objects and Alertmanager endpoints.<br><p> <br><p> If set, the value should be either "Endpoints" or "EndpointSlice". If unset, the operator assumes the "Endpoints" role.
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
     * The name of the service name used by the underlying StatefulSet(s) as the governing service. If defined, the Service  must be created before the Prometheus/PrometheusAgent resource in the same namespace and it must define a selector that matches the pod labels. If empty, the operator will create and manage a headless service named `prometheus-operated` for Prometheus resources, or `prometheus-agent-operated` for PrometheusAgent resources. When deploying multiple Prometheus/PrometheusAgent resources in the same namespace, it is recommended to specify a different value for each. See https://kubernetes.io/docs/concepts/workloads/controllers/statefulset/#stable-network-id for more details.
     */
    @JsonProperty("serviceName")
    public String getServiceName() {
        return serviceName;
    }

    /**
     * The name of the service name used by the underlying StatefulSet(s) as the governing service. If defined, the Service  must be created before the Prometheus/PrometheusAgent resource in the same namespace and it must define a selector that matches the pod labels. If empty, the operator will create and manage a headless service named `prometheus-operated` for Prometheus resources, or `prometheus-agent-operated` for PrometheusAgent resources. When deploying multiple Prometheus/PrometheusAgent resources in the same namespace, it is recommended to specify a different value for each. See https://kubernetes.io/docs/concepts/workloads/controllers/statefulset/#stable-network-id for more details.
     */
    @JsonProperty("serviceName")
    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    /**
     * Number of shards to distribute the scraped targets onto.<br><p> <br><p> `spec.replicas` multiplied by `spec.shards` is the total number of Pods being created.<br><p> <br><p> When not defined, the operator assumes only one shard.<br><p> <br><p> Note that scaling down shards will not reshard data onto the remaining instances, it must be manually moved. Increasing shards will not reshard data either but it will continue to be available from the same instances. To query globally, use either &#42; Thanos sidecar + querier for query federation and Thanos Ruler for rules. &#42; Remote-write to send metrics to a central location.<br><p> <br><p> By default, the sharding of targets is performed on: &#42; The `__address__` target's metadata label for PodMonitor, ServiceMonitor and ScrapeConfig resources. &#42; The `__param_target__` label for Probe resources.<br><p> <br><p> Users can define their own sharding implementation by setting the `__tmp_hash` label during the target discovery with relabeling configuration (either in the monitoring resources or via scrape class).<br><p> <br><p> You can also disable sharding on a specific target by setting the `__tmp_disable_sharding` label with relabeling configuration. When the label value isn't empty, all Prometheus shards will scrape the target.
     */
    @JsonProperty("shards")
    public Integer getShards() {
        return shards;
    }

    /**
     * Number of shards to distribute the scraped targets onto.<br><p> <br><p> `spec.replicas` multiplied by `spec.shards` is the total number of Pods being created.<br><p> <br><p> When not defined, the operator assumes only one shard.<br><p> <br><p> Note that scaling down shards will not reshard data onto the remaining instances, it must be manually moved. Increasing shards will not reshard data either but it will continue to be available from the same instances. To query globally, use either &#42; Thanos sidecar + querier for query federation and Thanos Ruler for rules. &#42; Remote-write to send metrics to a central location.<br><p> <br><p> By default, the sharding of targets is performed on: &#42; The `__address__` target's metadata label for PodMonitor, ServiceMonitor and ScrapeConfig resources. &#42; The `__param_target__` label for Probe resources.<br><p> <br><p> Users can define their own sharding implementation by setting the `__tmp_hash` label during the target discovery with relabeling configuration (either in the monitoring resources or via scrape class).<br><p> <br><p> You can also disable sharding on a specific target by setting the `__tmp_disable_sharding` label with relabeling configuration. When the label value isn't empty, all Prometheus shards will scrape the target.
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
     * TargetLimit defines a limit on the number of scraped targets that will be accepted. Only valid in Prometheus versions 2.45.0 and newer.<br><p> <br><p> Note that the global limit only applies to scrape objects that don't specify an explicit limit value. If you want to enforce a maximum limit for all scrape objects, refer to enforcedTargetLimit.
     */
    @JsonProperty("targetLimit")
    public Long getTargetLimit() {
        return targetLimit;
    }

    /**
     * TargetLimit defines a limit on the number of scraped targets that will be accepted. Only valid in Prometheus versions 2.45.0 and newer.<br><p> <br><p> Note that the global limit only applies to scrape objects that don't specify an explicit limit value. If you want to enforce a maximum limit for all scrape objects, refer to enforcedTargetLimit.
     */
    @JsonProperty("targetLimit")
    public void setTargetLimit(Long targetLimit) {
        this.targetLimit = targetLimit;
    }

    /**
     * Optional duration in seconds the pod needs to terminate gracefully. Value must be non-negative integer. The value zero indicates stop immediately via the kill signal (no opportunity to shut down) which may lead to data corruption.<br><p> <br><p> Defaults to 600 seconds.
     */
    @JsonProperty("terminationGracePeriodSeconds")
    public Long getTerminationGracePeriodSeconds() {
        return terminationGracePeriodSeconds;
    }

    /**
     * Optional duration in seconds the pod needs to terminate gracefully. Value must be non-negative integer. The value zero indicates stop immediately via the kill signal (no opportunity to shut down) which may lead to data corruption.<br><p> <br><p> Defaults to 600 seconds.
     */
    @JsonProperty("terminationGracePeriodSeconds")
    public void setTerminationGracePeriodSeconds(Long terminationGracePeriodSeconds) {
        this.terminationGracePeriodSeconds = terminationGracePeriodSeconds;
    }

    /**
     * Defines the Pods' tolerations if specified.
     */
    @JsonProperty("tolerations")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<Toleration> getTolerations() {
        return tolerations;
    }

    /**
     * Defines the Pods' tolerations if specified.
     */
    @JsonProperty("tolerations")
    public void setTolerations(List<Toleration> tolerations) {
        this.tolerations = tolerations;
    }

    /**
     * Defines the pod's topology spread constraints if specified.
     */
    @JsonProperty("topologySpreadConstraints")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<TopologySpreadConstraint> getTopologySpreadConstraints() {
        return topologySpreadConstraints;
    }

    /**
     * Defines the pod's topology spread constraints if specified.
     */
    @JsonProperty("topologySpreadConstraints")
    public void setTopologySpreadConstraints(List<TopologySpreadConstraint> topologySpreadConstraints) {
        this.topologySpreadConstraints = topologySpreadConstraints;
    }

    /**
     * PrometheusAgentSpec is a specification of the desired behavior of the Prometheus agent. More info: https://github.com/kubernetes/community/blob/master/contributors/devel/sig-architecture/api-conventions.md#spec-and-status
     */
    @JsonProperty("tracingConfig")
    public PrometheusTracingConfig getTracingConfig() {
        return tracingConfig;
    }

    /**
     * PrometheusAgentSpec is a specification of the desired behavior of the Prometheus agent. More info: https://github.com/kubernetes/community/blob/master/contributors/devel/sig-architecture/api-conventions.md#spec-and-status
     */
    @JsonProperty("tracingConfig")
    public void setTracingConfig(PrometheusTracingConfig tracingConfig) {
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
     * Version of Prometheus being deployed. The operator uses this information to generate the Prometheus StatefulSet + configuration files.<br><p> <br><p> If not specified, the operator assumes the latest upstream version of Prometheus available at the time when the version of the operator was released.
     */
    @JsonProperty("version")
    public String getVersion() {
        return version;
    }

    /**
     * Version of Prometheus being deployed. The operator uses this information to generate the Prometheus StatefulSet + configuration files.<br><p> <br><p> If not specified, the operator assumes the latest upstream version of Prometheus available at the time when the version of the operator was released.
     */
    @JsonProperty("version")
    public void setVersion(String version) {
        this.version = version;
    }

    /**
     * VolumeMounts allows the configuration of additional VolumeMounts.<br><p> <br><p> VolumeMounts will be appended to other VolumeMounts in the 'prometheus' container, that are generated as a result of StorageSpec objects.
     */
    @JsonProperty("volumeMounts")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<VolumeMount> getVolumeMounts() {
        return volumeMounts;
    }

    /**
     * VolumeMounts allows the configuration of additional VolumeMounts.<br><p> <br><p> VolumeMounts will be appended to other VolumeMounts in the 'prometheus' container, that are generated as a result of StorageSpec objects.
     */
    @JsonProperty("volumeMounts")
    public void setVolumeMounts(List<VolumeMount> volumeMounts) {
        this.volumeMounts = volumeMounts;
    }

    /**
     * Volumes allows the configuration of additional volumes on the output StatefulSet definition. Volumes specified will be appended to other volumes that are generated as a result of StorageSpec objects.
     */
    @JsonProperty("volumes")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<Volume> getVolumes() {
        return volumes;
    }

    /**
     * Volumes allows the configuration of additional volumes on the output StatefulSet definition. Volumes specified will be appended to other volumes that are generated as a result of StorageSpec objects.
     */
    @JsonProperty("volumes")
    public void setVolumes(List<Volume> volumes) {
        this.volumes = volumes;
    }

    /**
     * Configures compression of the write-ahead log (WAL) using Snappy.<br><p> <br><p> WAL compression is enabled by default for Prometheus &gt;= 2.20.0<br><p> <br><p> Requires Prometheus v2.11.0 and above.
     */
    @JsonProperty("walCompression")
    public Boolean getWalCompression() {
        return walCompression;
    }

    /**
     * Configures compression of the write-ahead log (WAL) using Snappy.<br><p> <br><p> WAL compression is enabled by default for Prometheus &gt;= 2.20.0<br><p> <br><p> Requires Prometheus v2.11.0 and above.
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

}
