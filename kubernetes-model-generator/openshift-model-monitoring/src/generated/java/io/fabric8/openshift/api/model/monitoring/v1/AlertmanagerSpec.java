
package io.fabric8.openshift.api.model.monitoring.v1;

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
import io.fabric8.kubernetes.api.model.Toleration;
import io.fabric8.kubernetes.api.model.TopologySpreadConstraint;
import io.fabric8.kubernetes.api.model.Volume;
import io.fabric8.kubernetes.api.model.VolumeMount;
import io.fabric8.kubernetes.api.model.apps.StatefulSetPersistentVolumeClaimRetentionPolicy;
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;

/**
 * AlertmanagerSpec is a specification of the desired behavior of the Alertmanager cluster. More info: https://github.com/kubernetes/community/blob/master/contributors/devel/sig-architecture/api-conventions.md#spec-and-status
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "additionalArgs",
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
    "clusterTLS",
    "configMaps",
    "configSecret",
    "containers",
    "dnsConfig",
    "dnsPolicy",
    "enableFeatures",
    "enableServiceLinks",
    "externalUrl",
    "forceEnableClusterMode",
    "hostAliases",
    "hostNetwork",
    "hostUsers",
    "image",
    "imagePullPolicy",
    "imagePullSecrets",
    "initContainers",
    "limits",
    "listenLocal",
    "logFormat",
    "logLevel",
    "minReadySeconds",
    "nodeSelector",
    "paused",
    "persistentVolumeClaimRetentionPolicy",
    "podManagementPolicy",
    "podMetadata",
    "portName",
    "priorityClassName",
    "replicas",
    "resources",
    "retention",
    "routePrefix",
    "schedulerName",
    "secrets",
    "securityContext",
    "serviceAccountName",
    "serviceName",
    "sha",
    "storage",
    "tag",
    "terminationGracePeriodSeconds",
    "tolerations",
    "topologySpreadConstraints",
    "updateStrategy",
    "version",
    "volumeMounts",
    "volumes",
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
public class AlertmanagerSpec implements Editable<AlertmanagerSpecBuilder>, KubernetesResource
{

    @JsonProperty("additionalArgs")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<Argument> additionalArgs = new ArrayList<>();
    @JsonProperty("additionalPeers")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> additionalPeers = new ArrayList<>();
    @JsonProperty("affinity")
    private Affinity affinity;
    @JsonProperty("alertmanagerConfigMatcherStrategy")
    private AlertmanagerConfigMatcherStrategy alertmanagerConfigMatcherStrategy;
    @JsonProperty("alertmanagerConfigNamespaceSelector")
    private LabelSelector alertmanagerConfigNamespaceSelector;
    @JsonProperty("alertmanagerConfigSelector")
    private LabelSelector alertmanagerConfigSelector;
    @JsonProperty("alertmanagerConfiguration")
    private AlertmanagerConfiguration alertmanagerConfiguration;
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
    @JsonProperty("clusterTLS")
    private ClusterTLSConfig clusterTLS;
    @JsonProperty("configMaps")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> configMaps = new ArrayList<>();
    @JsonProperty("configSecret")
    private String configSecret;
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
    @JsonProperty("enableServiceLinks")
    private Boolean enableServiceLinks;
    @JsonProperty("externalUrl")
    private String externalUrl;
    @JsonProperty("forceEnableClusterMode")
    private Boolean forceEnableClusterMode;
    @JsonProperty("hostAliases")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<HostAlias> hostAliases = new ArrayList<>();
    @JsonProperty("hostNetwork")
    private Boolean hostNetwork;
    @JsonProperty("hostUsers")
    private Boolean hostUsers;
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
    @JsonProperty("limits")
    private AlertmanagerLimitsSpec limits;
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
    @JsonProperty("persistentVolumeClaimRetentionPolicy")
    private StatefulSetPersistentVolumeClaimRetentionPolicy persistentVolumeClaimRetentionPolicy;
    @JsonProperty("podManagementPolicy")
    private String podManagementPolicy;
    @JsonProperty("podMetadata")
    private EmbeddedObjectMetadata podMetadata;
    @JsonProperty("portName")
    private String portName;
    @JsonProperty("priorityClassName")
    private String priorityClassName;
    @JsonProperty("replicas")
    private Integer replicas;
    @JsonProperty("resources")
    private ResourceRequirements resources;
    @JsonProperty("retention")
    private String retention;
    @JsonProperty("routePrefix")
    private String routePrefix;
    @JsonProperty("schedulerName")
    private String schedulerName;
    @JsonProperty("secrets")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> secrets = new ArrayList<>();
    @JsonProperty("securityContext")
    private PodSecurityContext securityContext;
    @JsonProperty("serviceAccountName")
    private String serviceAccountName;
    @JsonProperty("serviceName")
    private String serviceName;
    @JsonProperty("sha")
    private String sha;
    @JsonProperty("storage")
    private StorageSpec storage;
    @JsonProperty("tag")
    private String tag;
    @JsonProperty("terminationGracePeriodSeconds")
    private Long terminationGracePeriodSeconds;
    @JsonProperty("tolerations")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<Toleration> tolerations = new ArrayList<>();
    @JsonProperty("topologySpreadConstraints")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<TopologySpreadConstraint> topologySpreadConstraints = new ArrayList<>();
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
    @JsonProperty("web")
    private AlertmanagerWebSpec web;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public AlertmanagerSpec() {
    }

    public AlertmanagerSpec(List<Argument> additionalArgs, List<String> additionalPeers, Affinity affinity, AlertmanagerConfigMatcherStrategy alertmanagerConfigMatcherStrategy, LabelSelector alertmanagerConfigNamespaceSelector, LabelSelector alertmanagerConfigSelector, AlertmanagerConfiguration alertmanagerConfiguration, Boolean automountServiceAccountToken, String baseImage, String clusterAdvertiseAddress, String clusterGossipInterval, String clusterLabel, String clusterPeerTimeout, String clusterPushpullInterval, ClusterTLSConfig clusterTLS, List<String> configMaps, String configSecret, List<Container> containers, PodDNSConfig dnsConfig, String dnsPolicy, List<String> enableFeatures, Boolean enableServiceLinks, String externalUrl, Boolean forceEnableClusterMode, List<HostAlias> hostAliases, Boolean hostNetwork, Boolean hostUsers, String image, String imagePullPolicy, List<LocalObjectReference> imagePullSecrets, List<Container> initContainers, AlertmanagerLimitsSpec limits, Boolean listenLocal, String logFormat, String logLevel, Integer minReadySeconds, Map<String, String> nodeSelector, Boolean paused, StatefulSetPersistentVolumeClaimRetentionPolicy persistentVolumeClaimRetentionPolicy, String podManagementPolicy, EmbeddedObjectMetadata podMetadata, String portName, String priorityClassName, Integer replicas, ResourceRequirements resources, String retention, String routePrefix, String schedulerName, List<String> secrets, PodSecurityContext securityContext, String serviceAccountName, String serviceName, String sha, StorageSpec storage, String tag, Long terminationGracePeriodSeconds, List<Toleration> tolerations, List<TopologySpreadConstraint> topologySpreadConstraints, StatefulSetUpdateStrategy updateStrategy, String version, List<VolumeMount> volumeMounts, List<Volume> volumes, AlertmanagerWebSpec web) {
        super();
        this.additionalArgs = additionalArgs;
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
        this.clusterTLS = clusterTLS;
        this.configMaps = configMaps;
        this.configSecret = configSecret;
        this.containers = containers;
        this.dnsConfig = dnsConfig;
        this.dnsPolicy = dnsPolicy;
        this.enableFeatures = enableFeatures;
        this.enableServiceLinks = enableServiceLinks;
        this.externalUrl = externalUrl;
        this.forceEnableClusterMode = forceEnableClusterMode;
        this.hostAliases = hostAliases;
        this.hostNetwork = hostNetwork;
        this.hostUsers = hostUsers;
        this.image = image;
        this.imagePullPolicy = imagePullPolicy;
        this.imagePullSecrets = imagePullSecrets;
        this.initContainers = initContainers;
        this.limits = limits;
        this.listenLocal = listenLocal;
        this.logFormat = logFormat;
        this.logLevel = logLevel;
        this.minReadySeconds = minReadySeconds;
        this.nodeSelector = nodeSelector;
        this.paused = paused;
        this.persistentVolumeClaimRetentionPolicy = persistentVolumeClaimRetentionPolicy;
        this.podManagementPolicy = podManagementPolicy;
        this.podMetadata = podMetadata;
        this.portName = portName;
        this.priorityClassName = priorityClassName;
        this.replicas = replicas;
        this.resources = resources;
        this.retention = retention;
        this.routePrefix = routePrefix;
        this.schedulerName = schedulerName;
        this.secrets = secrets;
        this.securityContext = securityContext;
        this.serviceAccountName = serviceAccountName;
        this.serviceName = serviceName;
        this.sha = sha;
        this.storage = storage;
        this.tag = tag;
        this.terminationGracePeriodSeconds = terminationGracePeriodSeconds;
        this.tolerations = tolerations;
        this.topologySpreadConstraints = topologySpreadConstraints;
        this.updateStrategy = updateStrategy;
        this.version = version;
        this.volumeMounts = volumeMounts;
        this.volumes = volumes;
        this.web = web;
    }

    /**
     * additionalArgs allows setting additional arguments for the 'Alertmanager' container. It is intended for e.g. activating hidden flags which are not supported by the dedicated configuration options yet. The arguments are passed as-is to the Alertmanager container which may cause issues if they are invalid or not supported by the given Alertmanager version.
     */
    @JsonProperty("additionalArgs")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<Argument> getAdditionalArgs() {
        return additionalArgs;
    }

    /**
     * additionalArgs allows setting additional arguments for the 'Alertmanager' container. It is intended for e.g. activating hidden flags which are not supported by the dedicated configuration options yet. The arguments are passed as-is to the Alertmanager container which may cause issues if they are invalid or not supported by the given Alertmanager version.
     */
    @JsonProperty("additionalArgs")
    public void setAdditionalArgs(List<Argument> additionalArgs) {
        this.additionalArgs = additionalArgs;
    }

    /**
     * additionalPeers allows injecting a set of additional Alertmanagers to peer with to form a highly available cluster.
     */
    @JsonProperty("additionalPeers")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getAdditionalPeers() {
        return additionalPeers;
    }

    /**
     * additionalPeers allows injecting a set of additional Alertmanagers to peer with to form a highly available cluster.
     */
    @JsonProperty("additionalPeers")
    public void setAdditionalPeers(List<String> additionalPeers) {
        this.additionalPeers = additionalPeers;
    }

    /**
     * AlertmanagerSpec is a specification of the desired behavior of the Alertmanager cluster. More info: https://github.com/kubernetes/community/blob/master/contributors/devel/sig-architecture/api-conventions.md#spec-and-status
     */
    @JsonProperty("affinity")
    public Affinity getAffinity() {
        return affinity;
    }

    /**
     * AlertmanagerSpec is a specification of the desired behavior of the Alertmanager cluster. More info: https://github.com/kubernetes/community/blob/master/contributors/devel/sig-architecture/api-conventions.md#spec-and-status
     */
    @JsonProperty("affinity")
    public void setAffinity(Affinity affinity) {
        this.affinity = affinity;
    }

    /**
     * AlertmanagerSpec is a specification of the desired behavior of the Alertmanager cluster. More info: https://github.com/kubernetes/community/blob/master/contributors/devel/sig-architecture/api-conventions.md#spec-and-status
     */
    @JsonProperty("alertmanagerConfigMatcherStrategy")
    public AlertmanagerConfigMatcherStrategy getAlertmanagerConfigMatcherStrategy() {
        return alertmanagerConfigMatcherStrategy;
    }

    /**
     * AlertmanagerSpec is a specification of the desired behavior of the Alertmanager cluster. More info: https://github.com/kubernetes/community/blob/master/contributors/devel/sig-architecture/api-conventions.md#spec-and-status
     */
    @JsonProperty("alertmanagerConfigMatcherStrategy")
    public void setAlertmanagerConfigMatcherStrategy(AlertmanagerConfigMatcherStrategy alertmanagerConfigMatcherStrategy) {
        this.alertmanagerConfigMatcherStrategy = alertmanagerConfigMatcherStrategy;
    }

    /**
     * AlertmanagerSpec is a specification of the desired behavior of the Alertmanager cluster. More info: https://github.com/kubernetes/community/blob/master/contributors/devel/sig-architecture/api-conventions.md#spec-and-status
     */
    @JsonProperty("alertmanagerConfigNamespaceSelector")
    public LabelSelector getAlertmanagerConfigNamespaceSelector() {
        return alertmanagerConfigNamespaceSelector;
    }

    /**
     * AlertmanagerSpec is a specification of the desired behavior of the Alertmanager cluster. More info: https://github.com/kubernetes/community/blob/master/contributors/devel/sig-architecture/api-conventions.md#spec-and-status
     */
    @JsonProperty("alertmanagerConfigNamespaceSelector")
    public void setAlertmanagerConfigNamespaceSelector(LabelSelector alertmanagerConfigNamespaceSelector) {
        this.alertmanagerConfigNamespaceSelector = alertmanagerConfigNamespaceSelector;
    }

    /**
     * AlertmanagerSpec is a specification of the desired behavior of the Alertmanager cluster. More info: https://github.com/kubernetes/community/blob/master/contributors/devel/sig-architecture/api-conventions.md#spec-and-status
     */
    @JsonProperty("alertmanagerConfigSelector")
    public LabelSelector getAlertmanagerConfigSelector() {
        return alertmanagerConfigSelector;
    }

    /**
     * AlertmanagerSpec is a specification of the desired behavior of the Alertmanager cluster. More info: https://github.com/kubernetes/community/blob/master/contributors/devel/sig-architecture/api-conventions.md#spec-and-status
     */
    @JsonProperty("alertmanagerConfigSelector")
    public void setAlertmanagerConfigSelector(LabelSelector alertmanagerConfigSelector) {
        this.alertmanagerConfigSelector = alertmanagerConfigSelector;
    }

    /**
     * AlertmanagerSpec is a specification of the desired behavior of the Alertmanager cluster. More info: https://github.com/kubernetes/community/blob/master/contributors/devel/sig-architecture/api-conventions.md#spec-and-status
     */
    @JsonProperty("alertmanagerConfiguration")
    public AlertmanagerConfiguration getAlertmanagerConfiguration() {
        return alertmanagerConfiguration;
    }

    /**
     * AlertmanagerSpec is a specification of the desired behavior of the Alertmanager cluster. More info: https://github.com/kubernetes/community/blob/master/contributors/devel/sig-architecture/api-conventions.md#spec-and-status
     */
    @JsonProperty("alertmanagerConfiguration")
    public void setAlertmanagerConfiguration(AlertmanagerConfiguration alertmanagerConfiguration) {
        this.alertmanagerConfiguration = alertmanagerConfiguration;
    }

    /**
     * automountServiceAccountToken defines whether a service account token should be automatically mounted in the pod. If the service account has `automountServiceAccountToken: true`, set the field to `false` to opt out of automounting API credentials.
     */
    @JsonProperty("automountServiceAccountToken")
    public Boolean getAutomountServiceAccountToken() {
        return automountServiceAccountToken;
    }

    /**
     * automountServiceAccountToken defines whether a service account token should be automatically mounted in the pod. If the service account has `automountServiceAccountToken: true`, set the field to `false` to opt out of automounting API credentials.
     */
    @JsonProperty("automountServiceAccountToken")
    public void setAutomountServiceAccountToken(Boolean automountServiceAccountToken) {
        this.automountServiceAccountToken = automountServiceAccountToken;
    }

    /**
     * baseImage that is used to deploy pods, without tag. Deprecated: use 'image' instead.
     */
    @JsonProperty("baseImage")
    public String getBaseImage() {
        return baseImage;
    }

    /**
     * baseImage that is used to deploy pods, without tag. Deprecated: use 'image' instead.
     */
    @JsonProperty("baseImage")
    public void setBaseImage(String baseImage) {
        this.baseImage = baseImage;
    }

    /**
     * clusterAdvertiseAddress defines the explicit address to advertise in cluster. Needs to be provided for non RFC1918 [1] (public) addresses. [1] RFC1918: https://tools.ietf.org/html/rfc1918
     */
    @JsonProperty("clusterAdvertiseAddress")
    public String getClusterAdvertiseAddress() {
        return clusterAdvertiseAddress;
    }

    /**
     * clusterAdvertiseAddress defines the explicit address to advertise in cluster. Needs to be provided for non RFC1918 [1] (public) addresses. [1] RFC1918: https://tools.ietf.org/html/rfc1918
     */
    @JsonProperty("clusterAdvertiseAddress")
    public void setClusterAdvertiseAddress(String clusterAdvertiseAddress) {
        this.clusterAdvertiseAddress = clusterAdvertiseAddress;
    }

    /**
     * clusterGossipInterval defines the interval between gossip attempts.
     */
    @JsonProperty("clusterGossipInterval")
    public String getClusterGossipInterval() {
        return clusterGossipInterval;
    }

    /**
     * clusterGossipInterval defines the interval between gossip attempts.
     */
    @JsonProperty("clusterGossipInterval")
    public void setClusterGossipInterval(String clusterGossipInterval) {
        this.clusterGossipInterval = clusterGossipInterval;
    }

    /**
     * clusterLabel defines the identifier that uniquely identifies the Alertmanager cluster. You should only set it when the Alertmanager cluster includes Alertmanager instances which are external to this Alertmanager resource. In practice, the addresses of the external instances are provided via the `.spec.additionalPeers` field.
     */
    @JsonProperty("clusterLabel")
    public String getClusterLabel() {
        return clusterLabel;
    }

    /**
     * clusterLabel defines the identifier that uniquely identifies the Alertmanager cluster. You should only set it when the Alertmanager cluster includes Alertmanager instances which are external to this Alertmanager resource. In practice, the addresses of the external instances are provided via the `.spec.additionalPeers` field.
     */
    @JsonProperty("clusterLabel")
    public void setClusterLabel(String clusterLabel) {
        this.clusterLabel = clusterLabel;
    }

    /**
     * clusterPeerTimeout defines the timeout for cluster peering.
     */
    @JsonProperty("clusterPeerTimeout")
    public String getClusterPeerTimeout() {
        return clusterPeerTimeout;
    }

    /**
     * clusterPeerTimeout defines the timeout for cluster peering.
     */
    @JsonProperty("clusterPeerTimeout")
    public void setClusterPeerTimeout(String clusterPeerTimeout) {
        this.clusterPeerTimeout = clusterPeerTimeout;
    }

    /**
     * clusterPushpullInterval defines the interval between pushpull attempts.
     */
    @JsonProperty("clusterPushpullInterval")
    public String getClusterPushpullInterval() {
        return clusterPushpullInterval;
    }

    /**
     * clusterPushpullInterval defines the interval between pushpull attempts.
     */
    @JsonProperty("clusterPushpullInterval")
    public void setClusterPushpullInterval(String clusterPushpullInterval) {
        this.clusterPushpullInterval = clusterPushpullInterval;
    }

    /**
     * AlertmanagerSpec is a specification of the desired behavior of the Alertmanager cluster. More info: https://github.com/kubernetes/community/blob/master/contributors/devel/sig-architecture/api-conventions.md#spec-and-status
     */
    @JsonProperty("clusterTLS")
    public ClusterTLSConfig getClusterTLS() {
        return clusterTLS;
    }

    /**
     * AlertmanagerSpec is a specification of the desired behavior of the Alertmanager cluster. More info: https://github.com/kubernetes/community/blob/master/contributors/devel/sig-architecture/api-conventions.md#spec-and-status
     */
    @JsonProperty("clusterTLS")
    public void setClusterTLS(ClusterTLSConfig clusterTLS) {
        this.clusterTLS = clusterTLS;
    }

    /**
     * configMaps defines a list of ConfigMaps in the same namespace as the Alertmanager object, which shall be mounted into the Alertmanager Pods. Each ConfigMap is added to the StatefulSet definition as a volume named `configmap-&lt;configmap-name&gt;`. The ConfigMaps are mounted into `/etc/alertmanager/configmaps/&lt;configmap-name&gt;` in the 'alertmanager' container.
     */
    @JsonProperty("configMaps")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getConfigMaps() {
        return configMaps;
    }

    /**
     * configMaps defines a list of ConfigMaps in the same namespace as the Alertmanager object, which shall be mounted into the Alertmanager Pods. Each ConfigMap is added to the StatefulSet definition as a volume named `configmap-&lt;configmap-name&gt;`. The ConfigMaps are mounted into `/etc/alertmanager/configmaps/&lt;configmap-name&gt;` in the 'alertmanager' container.
     */
    @JsonProperty("configMaps")
    public void setConfigMaps(List<String> configMaps) {
        this.configMaps = configMaps;
    }

    /**
     * configSecret defines the name of a Kubernetes Secret in the same namespace as the Alertmanager object, which contains the configuration for this Alertmanager instance. If empty, it defaults to `alertmanager-&lt;alertmanager-name&gt;`.<br><p> <br><p> The Alertmanager configuration should be available under the `alertmanager.yaml` key. Additional keys from the original secret are copied to the generated secret and mounted into the `/etc/alertmanager/config` directory in the `alertmanager` container.<br><p> <br><p> If either the secret or the `alertmanager.yaml` key is missing, the operator provisions a minimal Alertmanager configuration with one empty receiver (effectively dropping alert notifications).
     */
    @JsonProperty("configSecret")
    public String getConfigSecret() {
        return configSecret;
    }

    /**
     * configSecret defines the name of a Kubernetes Secret in the same namespace as the Alertmanager object, which contains the configuration for this Alertmanager instance. If empty, it defaults to `alertmanager-&lt;alertmanager-name&gt;`.<br><p> <br><p> The Alertmanager configuration should be available under the `alertmanager.yaml` key. Additional keys from the original secret are copied to the generated secret and mounted into the `/etc/alertmanager/config` directory in the `alertmanager` container.<br><p> <br><p> If either the secret or the `alertmanager.yaml` key is missing, the operator provisions a minimal Alertmanager configuration with one empty receiver (effectively dropping alert notifications).
     */
    @JsonProperty("configSecret")
    public void setConfigSecret(String configSecret) {
        this.configSecret = configSecret;
    }

    /**
     * containers allows injecting additional containers or modifying operator generated containers. This can be used to allow adding an authentication proxy to the Pods or to change the behavior of an operator generated container. Containers described here modify an operator generated container if they share the same name and modifications are done via a strategic merge patch.<br><p> <br><p> The names of containers managed by the operator are: &#42; `alertmanager` &#42; `config-reloader` &#42; `thanos-sidecar`<br><p> <br><p> Overriding containers which are managed by the operator require careful testing, especially when upgrading to a new version of the operator.
     */
    @JsonProperty("containers")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<Container> getContainers() {
        return containers;
    }

    /**
     * containers allows injecting additional containers or modifying operator generated containers. This can be used to allow adding an authentication proxy to the Pods or to change the behavior of an operator generated container. Containers described here modify an operator generated container if they share the same name and modifications are done via a strategic merge patch.<br><p> <br><p> The names of containers managed by the operator are: &#42; `alertmanager` &#42; `config-reloader` &#42; `thanos-sidecar`<br><p> <br><p> Overriding containers which are managed by the operator require careful testing, especially when upgrading to a new version of the operator.
     */
    @JsonProperty("containers")
    public void setContainers(List<Container> containers) {
        this.containers = containers;
    }

    /**
     * AlertmanagerSpec is a specification of the desired behavior of the Alertmanager cluster. More info: https://github.com/kubernetes/community/blob/master/contributors/devel/sig-architecture/api-conventions.md#spec-and-status
     */
    @JsonProperty("dnsConfig")
    public PodDNSConfig getDnsConfig() {
        return dnsConfig;
    }

    /**
     * AlertmanagerSpec is a specification of the desired behavior of the Alertmanager cluster. More info: https://github.com/kubernetes/community/blob/master/contributors/devel/sig-architecture/api-conventions.md#spec-and-status
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
     * enableFeatures defines the Alertmanager's feature flags. By default, no features are enabled. Enabling features which are disabled by default is entirely outside the scope of what the maintainers will support and by doing so, you accept that this behaviour may break at any time without notice.<br><p> <br><p> It requires Alertmanager &gt;= 0.27.0.
     */
    @JsonProperty("enableFeatures")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getEnableFeatures() {
        return enableFeatures;
    }

    /**
     * enableFeatures defines the Alertmanager's feature flags. By default, no features are enabled. Enabling features which are disabled by default is entirely outside the scope of what the maintainers will support and by doing so, you accept that this behaviour may break at any time without notice.<br><p> <br><p> It requires Alertmanager &gt;= 0.27.0.
     */
    @JsonProperty("enableFeatures")
    public void setEnableFeatures(List<String> enableFeatures) {
        this.enableFeatures = enableFeatures;
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
     * externalUrl defines the URL used to access the Alertmanager web service. This is necessary to generate correct URLs. This is necessary if Alertmanager is not served from root of a DNS name.
     */
    @JsonProperty("externalUrl")
    public String getExternalUrl() {
        return externalUrl;
    }

    /**
     * externalUrl defines the URL used to access the Alertmanager web service. This is necessary to generate correct URLs. This is necessary if Alertmanager is not served from root of a DNS name.
     */
    @JsonProperty("externalUrl")
    public void setExternalUrl(String externalUrl) {
        this.externalUrl = externalUrl;
    }

    /**
     * forceEnableClusterMode ensures Alertmanager does not deactivate the cluster mode when running with a single replica. Use case is e.g. spanning an Alertmanager cluster across Kubernetes clusters with a single replica in each.
     */
    @JsonProperty("forceEnableClusterMode")
    public Boolean getForceEnableClusterMode() {
        return forceEnableClusterMode;
    }

    /**
     * forceEnableClusterMode ensures Alertmanager does not deactivate the cluster mode when running with a single replica. Use case is e.g. spanning an Alertmanager cluster across Kubernetes clusters with a single replica in each.
     */
    @JsonProperty("forceEnableClusterMode")
    public void setForceEnableClusterMode(Boolean forceEnableClusterMode) {
        this.forceEnableClusterMode = forceEnableClusterMode;
    }

    /**
     * hostAliases Pods configuration
     */
    @JsonProperty("hostAliases")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<HostAlias> getHostAliases() {
        return hostAliases;
    }

    /**
     * hostAliases Pods configuration
     */
    @JsonProperty("hostAliases")
    public void setHostAliases(List<HostAlias> hostAliases) {
        this.hostAliases = hostAliases;
    }

    /**
     * hostNetwork controls whether the pod may use the node network namespace.<br><p> <br><p> Make sure to understand the security implications if you want to enable it (https://kubernetes.io/docs/concepts/configuration/overview/).<br><p> <br><p> When hostNetwork is enabled, this will set the DNS policy to `ClusterFirstWithHostNet` automatically (unless `.spec.dnsPolicy` is set to a different value).
     */
    @JsonProperty("hostNetwork")
    public Boolean getHostNetwork() {
        return hostNetwork;
    }

    /**
     * hostNetwork controls whether the pod may use the node network namespace.<br><p> <br><p> Make sure to understand the security implications if you want to enable it (https://kubernetes.io/docs/concepts/configuration/overview/).<br><p> <br><p> When hostNetwork is enabled, this will set the DNS policy to `ClusterFirstWithHostNet` automatically (unless `.spec.dnsPolicy` is set to a different value).
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
     * image if specified has precedence over baseImage, tag and sha combinations. Specifying the version is still necessary to ensure the Prometheus Operator knows what version of Alertmanager is being configured.
     */
    @JsonProperty("image")
    public String getImage() {
        return image;
    }

    /**
     * image if specified has precedence over baseImage, tag and sha combinations. Specifying the version is still necessary to ensure the Prometheus Operator knows what version of Alertmanager is being configured.
     */
    @JsonProperty("image")
    public void setImage(String image) {
        this.image = image;
    }

    /**
     * imagePullPolicy for the 'alertmanager', 'init-config-reloader' and 'config-reloader' containers. See https://kubernetes.io/docs/concepts/containers/images/#image-pull-policy for more details.<br><p> <br><p> Possible enum values:<br><p>  - `"Always"` means that kubelet always attempts to pull the latest image. Container will fail If the pull fails.<br><p>  - `"IfNotPresent"` means that kubelet pulls if the image isn't present on disk. Container will fail if the image isn't present and the pull fails.<br><p>  - `"Never"` means that kubelet never pulls an image, but only uses a local image. Container will fail if the image isn't present
     */
    @JsonProperty("imagePullPolicy")
    public String getImagePullPolicy() {
        return imagePullPolicy;
    }

    /**
     * imagePullPolicy for the 'alertmanager', 'init-config-reloader' and 'config-reloader' containers. See https://kubernetes.io/docs/concepts/containers/images/#image-pull-policy for more details.<br><p> <br><p> Possible enum values:<br><p>  - `"Always"` means that kubelet always attempts to pull the latest image. Container will fail If the pull fails.<br><p>  - `"IfNotPresent"` means that kubelet pulls if the image isn't present on disk. Container will fail if the image isn't present and the pull fails.<br><p>  - `"Never"` means that kubelet never pulls an image, but only uses a local image. Container will fail if the image isn't present
     */
    @JsonProperty("imagePullPolicy")
    public void setImagePullPolicy(String imagePullPolicy) {
        this.imagePullPolicy = imagePullPolicy;
    }

    /**
     * imagePullSecrets An optional list of references to secrets in the same namespace to use for pulling prometheus and alertmanager images from registries see https://kubernetes.io/docs/tasks/configure-pod-container/pull-image-private-registry/
     */
    @JsonProperty("imagePullSecrets")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<LocalObjectReference> getImagePullSecrets() {
        return imagePullSecrets;
    }

    /**
     * imagePullSecrets An optional list of references to secrets in the same namespace to use for pulling prometheus and alertmanager images from registries see https://kubernetes.io/docs/tasks/configure-pod-container/pull-image-private-registry/
     */
    @JsonProperty("imagePullSecrets")
    public void setImagePullSecrets(List<LocalObjectReference> imagePullSecrets) {
        this.imagePullSecrets = imagePullSecrets;
    }

    /**
     * initContainers allows injecting initContainers to the Pod definition. Those can be used to e.g.  fetch secrets for injection into the Prometheus configuration from external sources. Any errors during the execution of an initContainer will lead to a restart of the Pod. More info: https://kubernetes.io/docs/concepts/workloads/pods/init-containers/ InitContainers described here modify an operator generated init containers if they share the same name and modifications are done via a strategic merge patch.<br><p> <br><p> The names of init container name managed by the operator are: &#42; `init-config-reloader`.<br><p> <br><p> Overriding init containers which are managed by the operator require careful testing, especially when upgrading to a new version of the operator.
     */
    @JsonProperty("initContainers")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<Container> getInitContainers() {
        return initContainers;
    }

    /**
     * initContainers allows injecting initContainers to the Pod definition. Those can be used to e.g.  fetch secrets for injection into the Prometheus configuration from external sources. Any errors during the execution of an initContainer will lead to a restart of the Pod. More info: https://kubernetes.io/docs/concepts/workloads/pods/init-containers/ InitContainers described here modify an operator generated init containers if they share the same name and modifications are done via a strategic merge patch.<br><p> <br><p> The names of init container name managed by the operator are: &#42; `init-config-reloader`.<br><p> <br><p> Overriding init containers which are managed by the operator require careful testing, especially when upgrading to a new version of the operator.
     */
    @JsonProperty("initContainers")
    public void setInitContainers(List<Container> initContainers) {
        this.initContainers = initContainers;
    }

    /**
     * AlertmanagerSpec is a specification of the desired behavior of the Alertmanager cluster. More info: https://github.com/kubernetes/community/blob/master/contributors/devel/sig-architecture/api-conventions.md#spec-and-status
     */
    @JsonProperty("limits")
    public AlertmanagerLimitsSpec getLimits() {
        return limits;
    }

    /**
     * AlertmanagerSpec is a specification of the desired behavior of the Alertmanager cluster. More info: https://github.com/kubernetes/community/blob/master/contributors/devel/sig-architecture/api-conventions.md#spec-and-status
     */
    @JsonProperty("limits")
    public void setLimits(AlertmanagerLimitsSpec limits) {
        this.limits = limits;
    }

    /**
     * listenLocal defines the Alertmanager server listen on loopback, so that it does not bind against the Pod IP. Note this is only for the Alertmanager UI, not the gossip communication.
     */
    @JsonProperty("listenLocal")
    public Boolean getListenLocal() {
        return listenLocal;
    }

    /**
     * listenLocal defines the Alertmanager server listen on loopback, so that it does not bind against the Pod IP. Note this is only for the Alertmanager UI, not the gossip communication.
     */
    @JsonProperty("listenLocal")
    public void setListenLocal(Boolean listenLocal) {
        this.listenLocal = listenLocal;
    }

    /**
     * logFormat for Alertmanager to be configured with.
     */
    @JsonProperty("logFormat")
    public String getLogFormat() {
        return logFormat;
    }

    /**
     * logFormat for Alertmanager to be configured with.
     */
    @JsonProperty("logFormat")
    public void setLogFormat(String logFormat) {
        this.logFormat = logFormat;
    }

    /**
     * logLevel for Alertmanager to be configured with.
     */
    @JsonProperty("logLevel")
    public String getLogLevel() {
        return logLevel;
    }

    /**
     * logLevel for Alertmanager to be configured with.
     */
    @JsonProperty("logLevel")
    public void setLogLevel(String logLevel) {
        this.logLevel = logLevel;
    }

    /**
     * minReadySeconds defines the minimum number of seconds for which a newly created pod should be ready without any of its container crashing for it to be considered available.<br><p> <br><p> If unset, pods will be considered available as soon as they are ready.<br><p> <br><p> When the Alertmanager version is greater than or equal to v0.30.0, the duration is also used to delay the first flush of the aggregation groups. This delay helps ensuring that all alerts have been resent by the Prometheus instances to Alertmanager after a roll-out. It is possible to override this behavior passing a custom value via `.spec.additionalArgs`.
     */
    @JsonProperty("minReadySeconds")
    public Integer getMinReadySeconds() {
        return minReadySeconds;
    }

    /**
     * minReadySeconds defines the minimum number of seconds for which a newly created pod should be ready without any of its container crashing for it to be considered available.<br><p> <br><p> If unset, pods will be considered available as soon as they are ready.<br><p> <br><p> When the Alertmanager version is greater than or equal to v0.30.0, the duration is also used to delay the first flush of the aggregation groups. This delay helps ensuring that all alerts have been resent by the Prometheus instances to Alertmanager after a roll-out. It is possible to override this behavior passing a custom value via `.spec.additionalArgs`.
     */
    @JsonProperty("minReadySeconds")
    public void setMinReadySeconds(Integer minReadySeconds) {
        this.minReadySeconds = minReadySeconds;
    }

    /**
     * nodeSelector defines which Nodes the Pods are scheduled on.
     */
    @JsonProperty("nodeSelector")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public Map<String, String> getNodeSelector() {
        return nodeSelector;
    }

    /**
     * nodeSelector defines which Nodes the Pods are scheduled on.
     */
    @JsonProperty("nodeSelector")
    public void setNodeSelector(Map<String, String> nodeSelector) {
        this.nodeSelector = nodeSelector;
    }

    /**
     * paused if set to true all actions on the underlying managed objects are not going to be performed, except for delete actions.
     */
    @JsonProperty("paused")
    public Boolean getPaused() {
        return paused;
    }

    /**
     * paused if set to true all actions on the underlying managed objects are not going to be performed, except for delete actions.
     */
    @JsonProperty("paused")
    public void setPaused(Boolean paused) {
        this.paused = paused;
    }

    /**
     * AlertmanagerSpec is a specification of the desired behavior of the Alertmanager cluster. More info: https://github.com/kubernetes/community/blob/master/contributors/devel/sig-architecture/api-conventions.md#spec-and-status
     */
    @JsonProperty("persistentVolumeClaimRetentionPolicy")
    public StatefulSetPersistentVolumeClaimRetentionPolicy getPersistentVolumeClaimRetentionPolicy() {
        return persistentVolumeClaimRetentionPolicy;
    }

    /**
     * AlertmanagerSpec is a specification of the desired behavior of the Alertmanager cluster. More info: https://github.com/kubernetes/community/blob/master/contributors/devel/sig-architecture/api-conventions.md#spec-and-status
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
     * AlertmanagerSpec is a specification of the desired behavior of the Alertmanager cluster. More info: https://github.com/kubernetes/community/blob/master/contributors/devel/sig-architecture/api-conventions.md#spec-and-status
     */
    @JsonProperty("podMetadata")
    public EmbeddedObjectMetadata getPodMetadata() {
        return podMetadata;
    }

    /**
     * AlertmanagerSpec is a specification of the desired behavior of the Alertmanager cluster. More info: https://github.com/kubernetes/community/blob/master/contributors/devel/sig-architecture/api-conventions.md#spec-and-status
     */
    @JsonProperty("podMetadata")
    public void setPodMetadata(EmbeddedObjectMetadata podMetadata) {
        this.podMetadata = podMetadata;
    }

    /**
     * portName defines the port's name for the pods and governing service. Defaults to `web`.
     */
    @JsonProperty("portName")
    public String getPortName() {
        return portName;
    }

    /**
     * portName defines the port's name for the pods and governing service. Defaults to `web`.
     */
    @JsonProperty("portName")
    public void setPortName(String portName) {
        this.portName = portName;
    }

    /**
     * priorityClassName assigned to the Pods
     */
    @JsonProperty("priorityClassName")
    public String getPriorityClassName() {
        return priorityClassName;
    }

    /**
     * priorityClassName assigned to the Pods
     */
    @JsonProperty("priorityClassName")
    public void setPriorityClassName(String priorityClassName) {
        this.priorityClassName = priorityClassName;
    }

    /**
     * replicas defines the expected size of the alertmanager cluster. The controller will eventually make the size of the running cluster equal to the expected size.
     */
    @JsonProperty("replicas")
    public Integer getReplicas() {
        return replicas;
    }

    /**
     * replicas defines the expected size of the alertmanager cluster. The controller will eventually make the size of the running cluster equal to the expected size.
     */
    @JsonProperty("replicas")
    public void setReplicas(Integer replicas) {
        this.replicas = replicas;
    }

    /**
     * AlertmanagerSpec is a specification of the desired behavior of the Alertmanager cluster. More info: https://github.com/kubernetes/community/blob/master/contributors/devel/sig-architecture/api-conventions.md#spec-and-status
     */
    @JsonProperty("resources")
    public ResourceRequirements getResources() {
        return resources;
    }

    /**
     * AlertmanagerSpec is a specification of the desired behavior of the Alertmanager cluster. More info: https://github.com/kubernetes/community/blob/master/contributors/devel/sig-architecture/api-conventions.md#spec-and-status
     */
    @JsonProperty("resources")
    public void setResources(ResourceRequirements resources) {
        this.resources = resources;
    }

    /**
     * retention defines the time duration Alertmanager shall retain data for. Default is '120h', and must match the regular expression `[0-9]+(ms|s|m|h)` (milliseconds seconds minutes hours).
     */
    @JsonProperty("retention")
    public String getRetention() {
        return retention;
    }

    /**
     * retention defines the time duration Alertmanager shall retain data for. Default is '120h', and must match the regular expression `[0-9]+(ms|s|m|h)` (milliseconds seconds minutes hours).
     */
    @JsonProperty("retention")
    public void setRetention(String retention) {
        this.retention = retention;
    }

    /**
     * routePrefix Alertmanager registers HTTP handlers for. This is useful, if using ExternalURL and a proxy is rewriting HTTP routes of a request, and the actual ExternalURL is still true, but the server serves requests under a different route prefix. For example for use with `kubectl proxy`.
     */
    @JsonProperty("routePrefix")
    public String getRoutePrefix() {
        return routePrefix;
    }

    /**
     * routePrefix Alertmanager registers HTTP handlers for. This is useful, if using ExternalURL and a proxy is rewriting HTTP routes of a request, and the actual ExternalURL is still true, but the server serves requests under a different route prefix. For example for use with `kubectl proxy`.
     */
    @JsonProperty("routePrefix")
    public void setRoutePrefix(String routePrefix) {
        this.routePrefix = routePrefix;
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
     * secrets is a list of Secrets in the same namespace as the Alertmanager object, which shall be mounted into the Alertmanager Pods. Each Secret is added to the StatefulSet definition as a volume named `secret-&lt;secret-name&gt;`. The Secrets are mounted into `/etc/alertmanager/secrets/&lt;secret-name&gt;` in the 'alertmanager' container.
     */
    @JsonProperty("secrets")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getSecrets() {
        return secrets;
    }

    /**
     * secrets is a list of Secrets in the same namespace as the Alertmanager object, which shall be mounted into the Alertmanager Pods. Each Secret is added to the StatefulSet definition as a volume named `secret-&lt;secret-name&gt;`. The Secrets are mounted into `/etc/alertmanager/secrets/&lt;secret-name&gt;` in the 'alertmanager' container.
     */
    @JsonProperty("secrets")
    public void setSecrets(List<String> secrets) {
        this.secrets = secrets;
    }

    /**
     * AlertmanagerSpec is a specification of the desired behavior of the Alertmanager cluster. More info: https://github.com/kubernetes/community/blob/master/contributors/devel/sig-architecture/api-conventions.md#spec-and-status
     */
    @JsonProperty("securityContext")
    public PodSecurityContext getSecurityContext() {
        return securityContext;
    }

    /**
     * AlertmanagerSpec is a specification of the desired behavior of the Alertmanager cluster. More info: https://github.com/kubernetes/community/blob/master/contributors/devel/sig-architecture/api-conventions.md#spec-and-status
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
     * serviceName defines the service name used by the underlying StatefulSet(s) as the governing service. If defined, the Service  must be created before the Alertmanager resource in the same namespace and it must define a selector that matches the pod labels. If empty, the operator will create and manage a headless service named `alertmanager-operated` for Alertmanager resources. When deploying multiple Alertmanager resources in the same namespace, it is recommended to specify a different value for each. See https://kubernetes.io/docs/concepts/workloads/controllers/statefulset/#stable-network-id for more details.
     */
    @JsonProperty("serviceName")
    public String getServiceName() {
        return serviceName;
    }

    /**
     * serviceName defines the service name used by the underlying StatefulSet(s) as the governing service. If defined, the Service  must be created before the Alertmanager resource in the same namespace and it must define a selector that matches the pod labels. If empty, the operator will create and manage a headless service named `alertmanager-operated` for Alertmanager resources. When deploying multiple Alertmanager resources in the same namespace, it is recommended to specify a different value for each. See https://kubernetes.io/docs/concepts/workloads/controllers/statefulset/#stable-network-id for more details.
     */
    @JsonProperty("serviceName")
    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    /**
     * sha of Alertmanager container image to be deployed. Defaults to the value of `version`. Similar to a tag, but the SHA explicitly deploys an immutable container image. Version and Tag are ignored if SHA is set. Deprecated: use 'image' instead. The image digest can be specified as part of the image URL.
     */
    @JsonProperty("sha")
    public String getSha() {
        return sha;
    }

    /**
     * sha of Alertmanager container image to be deployed. Defaults to the value of `version`. Similar to a tag, but the SHA explicitly deploys an immutable container image. Version and Tag are ignored if SHA is set. Deprecated: use 'image' instead. The image digest can be specified as part of the image URL.
     */
    @JsonProperty("sha")
    public void setSha(String sha) {
        this.sha = sha;
    }

    /**
     * AlertmanagerSpec is a specification of the desired behavior of the Alertmanager cluster. More info: https://github.com/kubernetes/community/blob/master/contributors/devel/sig-architecture/api-conventions.md#spec-and-status
     */
    @JsonProperty("storage")
    public StorageSpec getStorage() {
        return storage;
    }

    /**
     * AlertmanagerSpec is a specification of the desired behavior of the Alertmanager cluster. More info: https://github.com/kubernetes/community/blob/master/contributors/devel/sig-architecture/api-conventions.md#spec-and-status
     */
    @JsonProperty("storage")
    public void setStorage(StorageSpec storage) {
        this.storage = storage;
    }

    /**
     * tag of Alertmanager container image to be deployed. Defaults to the value of `version`. Version is ignored if Tag is set. Deprecated: use 'image' instead. The image tag can be specified as part of the image URL.
     */
    @JsonProperty("tag")
    public String getTag() {
        return tag;
    }

    /**
     * tag of Alertmanager container image to be deployed. Defaults to the value of `version`. Version is ignored if Tag is set. Deprecated: use 'image' instead. The image tag can be specified as part of the image URL.
     */
    @JsonProperty("tag")
    public void setTag(String tag) {
        this.tag = tag;
    }

    /**
     * terminationGracePeriodSeconds defines the Optional duration in seconds the pod needs to terminate gracefully. Value must be non-negative integer. The value zero indicates stop immediately via the kill signal (no opportunity to shut down) which may lead to data corruption.<br><p> <br><p> Defaults to 120 seconds.
     */
    @JsonProperty("terminationGracePeriodSeconds")
    public Long getTerminationGracePeriodSeconds() {
        return terminationGracePeriodSeconds;
    }

    /**
     * terminationGracePeriodSeconds defines the Optional duration in seconds the pod needs to terminate gracefully. Value must be non-negative integer. The value zero indicates stop immediately via the kill signal (no opportunity to shut down) which may lead to data corruption.<br><p> <br><p> Defaults to 120 seconds.
     */
    @JsonProperty("terminationGracePeriodSeconds")
    public void setTerminationGracePeriodSeconds(Long terminationGracePeriodSeconds) {
        this.terminationGracePeriodSeconds = terminationGracePeriodSeconds;
    }

    /**
     * tolerations defines the pod's tolerations.
     */
    @JsonProperty("tolerations")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<Toleration> getTolerations() {
        return tolerations;
    }

    /**
     * tolerations defines the pod's tolerations.
     */
    @JsonProperty("tolerations")
    public void setTolerations(List<Toleration> tolerations) {
        this.tolerations = tolerations;
    }

    /**
     * topologySpreadConstraints defines the Pod's topology spread constraints.
     */
    @JsonProperty("topologySpreadConstraints")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<TopologySpreadConstraint> getTopologySpreadConstraints() {
        return topologySpreadConstraints;
    }

    /**
     * topologySpreadConstraints defines the Pod's topology spread constraints.
     */
    @JsonProperty("topologySpreadConstraints")
    public void setTopologySpreadConstraints(List<TopologySpreadConstraint> topologySpreadConstraints) {
        this.topologySpreadConstraints = topologySpreadConstraints;
    }

    /**
     * AlertmanagerSpec is a specification of the desired behavior of the Alertmanager cluster. More info: https://github.com/kubernetes/community/blob/master/contributors/devel/sig-architecture/api-conventions.md#spec-and-status
     */
    @JsonProperty("updateStrategy")
    public StatefulSetUpdateStrategy getUpdateStrategy() {
        return updateStrategy;
    }

    /**
     * AlertmanagerSpec is a specification of the desired behavior of the Alertmanager cluster. More info: https://github.com/kubernetes/community/blob/master/contributors/devel/sig-architecture/api-conventions.md#spec-and-status
     */
    @JsonProperty("updateStrategy")
    public void setUpdateStrategy(StatefulSetUpdateStrategy updateStrategy) {
        this.updateStrategy = updateStrategy;
    }

    /**
     * version the cluster should be on.
     */
    @JsonProperty("version")
    public String getVersion() {
        return version;
    }

    /**
     * version the cluster should be on.
     */
    @JsonProperty("version")
    public void setVersion(String version) {
        this.version = version;
    }

    /**
     * volumeMounts allows configuration of additional VolumeMounts on the output StatefulSet definition. VolumeMounts specified will be appended to other VolumeMounts in the alertmanager container, that are generated as a result of StorageSpec objects.
     */
    @JsonProperty("volumeMounts")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<VolumeMount> getVolumeMounts() {
        return volumeMounts;
    }

    /**
     * volumeMounts allows configuration of additional VolumeMounts on the output StatefulSet definition. VolumeMounts specified will be appended to other VolumeMounts in the alertmanager container, that are generated as a result of StorageSpec objects.
     */
    @JsonProperty("volumeMounts")
    public void setVolumeMounts(List<VolumeMount> volumeMounts) {
        this.volumeMounts = volumeMounts;
    }

    /**
     * volumes allows configuration of additional volumes on the output StatefulSet definition. Volumes specified will be appended to other volumes that are generated as a result of StorageSpec objects.
     */
    @JsonProperty("volumes")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<Volume> getVolumes() {
        return volumes;
    }

    /**
     * volumes allows configuration of additional volumes on the output StatefulSet definition. Volumes specified will be appended to other volumes that are generated as a result of StorageSpec objects.
     */
    @JsonProperty("volumes")
    public void setVolumes(List<Volume> volumes) {
        this.volumes = volumes;
    }

    /**
     * AlertmanagerSpec is a specification of the desired behavior of the Alertmanager cluster. More info: https://github.com/kubernetes/community/blob/master/contributors/devel/sig-architecture/api-conventions.md#spec-and-status
     */
    @JsonProperty("web")
    public AlertmanagerWebSpec getWeb() {
        return web;
    }

    /**
     * AlertmanagerSpec is a specification of the desired behavior of the Alertmanager cluster. More info: https://github.com/kubernetes/community/blob/master/contributors/devel/sig-architecture/api-conventions.md#spec-and-status
     */
    @JsonProperty("web")
    public void setWeb(AlertmanagerWebSpec web) {
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
        if (!(o instanceof AlertmanagerSpec)) {
            return false;
        }
        AlertmanagerSpec other = (AlertmanagerSpec) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$additionalArgs = this.getAdditionalArgs();
        Object other$additionalArgs = other.getAdditionalArgs();
        if (this$additionalArgs == null ? other$additionalArgs != null : !this$additionalArgs.equals(other$additionalArgs)) {
            return false;
        }
        Object this$additionalPeers = this.getAdditionalPeers();
        Object other$additionalPeers = other.getAdditionalPeers();
        if (this$additionalPeers == null ? other$additionalPeers != null : !this$additionalPeers.equals(other$additionalPeers)) {
            return false;
        }
        Object this$affinity = this.getAffinity();
        Object other$affinity = other.getAffinity();
        if (this$affinity == null ? other$affinity != null : !this$affinity.equals(other$affinity)) {
            return false;
        }
        Object this$alertmanagerConfigMatcherStrategy = this.getAlertmanagerConfigMatcherStrategy();
        Object other$alertmanagerConfigMatcherStrategy = other.getAlertmanagerConfigMatcherStrategy();
        if (this$alertmanagerConfigMatcherStrategy == null ? other$alertmanagerConfigMatcherStrategy != null : !this$alertmanagerConfigMatcherStrategy.equals(other$alertmanagerConfigMatcherStrategy)) {
            return false;
        }
        Object this$alertmanagerConfigNamespaceSelector = this.getAlertmanagerConfigNamespaceSelector();
        Object other$alertmanagerConfigNamespaceSelector = other.getAlertmanagerConfigNamespaceSelector();
        if (this$alertmanagerConfigNamespaceSelector == null ? other$alertmanagerConfigNamespaceSelector != null : !this$alertmanagerConfigNamespaceSelector.equals(other$alertmanagerConfigNamespaceSelector)) {
            return false;
        }
        Object this$alertmanagerConfigSelector = this.getAlertmanagerConfigSelector();
        Object other$alertmanagerConfigSelector = other.getAlertmanagerConfigSelector();
        if (this$alertmanagerConfigSelector == null ? other$alertmanagerConfigSelector != null : !this$alertmanagerConfigSelector.equals(other$alertmanagerConfigSelector)) {
            return false;
        }
        Object this$alertmanagerConfiguration = this.getAlertmanagerConfiguration();
        Object other$alertmanagerConfiguration = other.getAlertmanagerConfiguration();
        if (this$alertmanagerConfiguration == null ? other$alertmanagerConfiguration != null : !this$alertmanagerConfiguration.equals(other$alertmanagerConfiguration)) {
            return false;
        }
        Object this$automountServiceAccountToken = this.getAutomountServiceAccountToken();
        Object other$automountServiceAccountToken = other.getAutomountServiceAccountToken();
        if (this$automountServiceAccountToken == null ? other$automountServiceAccountToken != null : !this$automountServiceAccountToken.equals(other$automountServiceAccountToken)) {
            return false;
        }
        Object this$baseImage = this.getBaseImage();
        Object other$baseImage = other.getBaseImage();
        if (this$baseImage == null ? other$baseImage != null : !this$baseImage.equals(other$baseImage)) {
            return false;
        }
        Object this$clusterAdvertiseAddress = this.getClusterAdvertiseAddress();
        Object other$clusterAdvertiseAddress = other.getClusterAdvertiseAddress();
        if (this$clusterAdvertiseAddress == null ? other$clusterAdvertiseAddress != null : !this$clusterAdvertiseAddress.equals(other$clusterAdvertiseAddress)) {
            return false;
        }
        Object this$clusterGossipInterval = this.getClusterGossipInterval();
        Object other$clusterGossipInterval = other.getClusterGossipInterval();
        if (this$clusterGossipInterval == null ? other$clusterGossipInterval != null : !this$clusterGossipInterval.equals(other$clusterGossipInterval)) {
            return false;
        }
        Object this$clusterLabel = this.getClusterLabel();
        Object other$clusterLabel = other.getClusterLabel();
        if (this$clusterLabel == null ? other$clusterLabel != null : !this$clusterLabel.equals(other$clusterLabel)) {
            return false;
        }
        Object this$clusterPeerTimeout = this.getClusterPeerTimeout();
        Object other$clusterPeerTimeout = other.getClusterPeerTimeout();
        if (this$clusterPeerTimeout == null ? other$clusterPeerTimeout != null : !this$clusterPeerTimeout.equals(other$clusterPeerTimeout)) {
            return false;
        }
        Object this$clusterPushpullInterval = this.getClusterPushpullInterval();
        Object other$clusterPushpullInterval = other.getClusterPushpullInterval();
        if (this$clusterPushpullInterval == null ? other$clusterPushpullInterval != null : !this$clusterPushpullInterval.equals(other$clusterPushpullInterval)) {
            return false;
        }
        Object this$clusterTLS = this.getClusterTLS();
        Object other$clusterTLS = other.getClusterTLS();
        if (this$clusterTLS == null ? other$clusterTLS != null : !this$clusterTLS.equals(other$clusterTLS)) {
            return false;
        }
        Object this$configMaps = this.getConfigMaps();
        Object other$configMaps = other.getConfigMaps();
        if (this$configMaps == null ? other$configMaps != null : !this$configMaps.equals(other$configMaps)) {
            return false;
        }
        Object this$configSecret = this.getConfigSecret();
        Object other$configSecret = other.getConfigSecret();
        if (this$configSecret == null ? other$configSecret != null : !this$configSecret.equals(other$configSecret)) {
            return false;
        }
        Object this$containers = this.getContainers();
        Object other$containers = other.getContainers();
        if (this$containers == null ? other$containers != null : !this$containers.equals(other$containers)) {
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
        Object this$enableServiceLinks = this.getEnableServiceLinks();
        Object other$enableServiceLinks = other.getEnableServiceLinks();
        if (this$enableServiceLinks == null ? other$enableServiceLinks != null : !this$enableServiceLinks.equals(other$enableServiceLinks)) {
            return false;
        }
        Object this$externalUrl = this.getExternalUrl();
        Object other$externalUrl = other.getExternalUrl();
        if (this$externalUrl == null ? other$externalUrl != null : !this$externalUrl.equals(other$externalUrl)) {
            return false;
        }
        Object this$forceEnableClusterMode = this.getForceEnableClusterMode();
        Object other$forceEnableClusterMode = other.getForceEnableClusterMode();
        if (this$forceEnableClusterMode == null ? other$forceEnableClusterMode != null : !this$forceEnableClusterMode.equals(other$forceEnableClusterMode)) {
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
        Object this$limits = this.getLimits();
        Object other$limits = other.getLimits();
        if (this$limits == null ? other$limits != null : !this$limits.equals(other$limits)) {
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
        Object this$minReadySeconds = this.getMinReadySeconds();
        Object other$minReadySeconds = other.getMinReadySeconds();
        if (this$minReadySeconds == null ? other$minReadySeconds != null : !this$minReadySeconds.equals(other$minReadySeconds)) {
            return false;
        }
        Object this$nodeSelector = this.getNodeSelector();
        Object other$nodeSelector = other.getNodeSelector();
        if (this$nodeSelector == null ? other$nodeSelector != null : !this$nodeSelector.equals(other$nodeSelector)) {
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
        Object this$retention = this.getRetention();
        Object other$retention = other.getRetention();
        if (this$retention == null ? other$retention != null : !this$retention.equals(other$retention)) {
            return false;
        }
        Object this$routePrefix = this.getRoutePrefix();
        Object other$routePrefix = other.getRoutePrefix();
        if (this$routePrefix == null ? other$routePrefix != null : !this$routePrefix.equals(other$routePrefix)) {
            return false;
        }
        Object this$schedulerName = this.getSchedulerName();
        Object other$schedulerName = other.getSchedulerName();
        if (this$schedulerName == null ? other$schedulerName != null : !this$schedulerName.equals(other$schedulerName)) {
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
        Object this$serviceName = this.getServiceName();
        Object other$serviceName = other.getServiceName();
        if (this$serviceName == null ? other$serviceName != null : !this$serviceName.equals(other$serviceName)) {
            return false;
        }
        Object this$sha = this.getSha();
        Object other$sha = other.getSha();
        if (this$sha == null ? other$sha != null : !this$sha.equals(other$sha)) {
            return false;
        }
        Object this$storage = this.getStorage();
        Object other$storage = other.getStorage();
        if (this$storage == null ? other$storage != null : !this$storage.equals(other$storage)) {
            return false;
        }
        Object this$tag = this.getTag();
        Object other$tag = other.getTag();
        if (this$tag == null ? other$tag != null : !this$tag.equals(other$tag)) {
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
        return other instanceof AlertmanagerSpec;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $additionalArgs = this.getAdditionalArgs();
        result = result * prime + ($additionalArgs == null ? 43 : $additionalArgs.hashCode());
        Object $additionalPeers = this.getAdditionalPeers();
        result = result * prime + ($additionalPeers == null ? 43 : $additionalPeers.hashCode());
        Object $affinity = this.getAffinity();
        result = result * prime + ($affinity == null ? 43 : $affinity.hashCode());
        Object $alertmanagerConfigMatcherStrategy = this.getAlertmanagerConfigMatcherStrategy();
        result = result * prime + ($alertmanagerConfigMatcherStrategy == null ? 43 : $alertmanagerConfigMatcherStrategy.hashCode());
        Object $alertmanagerConfigNamespaceSelector = this.getAlertmanagerConfigNamespaceSelector();
        result = result * prime + ($alertmanagerConfigNamespaceSelector == null ? 43 : $alertmanagerConfigNamespaceSelector.hashCode());
        Object $alertmanagerConfigSelector = this.getAlertmanagerConfigSelector();
        result = result * prime + ($alertmanagerConfigSelector == null ? 43 : $alertmanagerConfigSelector.hashCode());
        Object $alertmanagerConfiguration = this.getAlertmanagerConfiguration();
        result = result * prime + ($alertmanagerConfiguration == null ? 43 : $alertmanagerConfiguration.hashCode());
        Object $automountServiceAccountToken = this.getAutomountServiceAccountToken();
        result = result * prime + ($automountServiceAccountToken == null ? 43 : $automountServiceAccountToken.hashCode());
        Object $baseImage = this.getBaseImage();
        result = result * prime + ($baseImage == null ? 43 : $baseImage.hashCode());
        Object $clusterAdvertiseAddress = this.getClusterAdvertiseAddress();
        result = result * prime + ($clusterAdvertiseAddress == null ? 43 : $clusterAdvertiseAddress.hashCode());
        Object $clusterGossipInterval = this.getClusterGossipInterval();
        result = result * prime + ($clusterGossipInterval == null ? 43 : $clusterGossipInterval.hashCode());
        Object $clusterLabel = this.getClusterLabel();
        result = result * prime + ($clusterLabel == null ? 43 : $clusterLabel.hashCode());
        Object $clusterPeerTimeout = this.getClusterPeerTimeout();
        result = result * prime + ($clusterPeerTimeout == null ? 43 : $clusterPeerTimeout.hashCode());
        Object $clusterPushpullInterval = this.getClusterPushpullInterval();
        result = result * prime + ($clusterPushpullInterval == null ? 43 : $clusterPushpullInterval.hashCode());
        Object $clusterTLS = this.getClusterTLS();
        result = result * prime + ($clusterTLS == null ? 43 : $clusterTLS.hashCode());
        Object $configMaps = this.getConfigMaps();
        result = result * prime + ($configMaps == null ? 43 : $configMaps.hashCode());
        Object $configSecret = this.getConfigSecret();
        result = result * prime + ($configSecret == null ? 43 : $configSecret.hashCode());
        Object $containers = this.getContainers();
        result = result * prime + ($containers == null ? 43 : $containers.hashCode());
        Object $dnsConfig = this.getDnsConfig();
        result = result * prime + ($dnsConfig == null ? 43 : $dnsConfig.hashCode());
        Object $dnsPolicy = this.getDnsPolicy();
        result = result * prime + ($dnsPolicy == null ? 43 : $dnsPolicy.hashCode());
        Object $enableFeatures = this.getEnableFeatures();
        result = result * prime + ($enableFeatures == null ? 43 : $enableFeatures.hashCode());
        Object $enableServiceLinks = this.getEnableServiceLinks();
        result = result * prime + ($enableServiceLinks == null ? 43 : $enableServiceLinks.hashCode());
        Object $externalUrl = this.getExternalUrl();
        result = result * prime + ($externalUrl == null ? 43 : $externalUrl.hashCode());
        Object $forceEnableClusterMode = this.getForceEnableClusterMode();
        result = result * prime + ($forceEnableClusterMode == null ? 43 : $forceEnableClusterMode.hashCode());
        Object $hostAliases = this.getHostAliases();
        result = result * prime + ($hostAliases == null ? 43 : $hostAliases.hashCode());
        Object $hostNetwork = this.getHostNetwork();
        result = result * prime + ($hostNetwork == null ? 43 : $hostNetwork.hashCode());
        Object $hostUsers = this.getHostUsers();
        result = result * prime + ($hostUsers == null ? 43 : $hostUsers.hashCode());
        Object $image = this.getImage();
        result = result * prime + ($image == null ? 43 : $image.hashCode());
        Object $imagePullPolicy = this.getImagePullPolicy();
        result = result * prime + ($imagePullPolicy == null ? 43 : $imagePullPolicy.hashCode());
        Object $imagePullSecrets = this.getImagePullSecrets();
        result = result * prime + ($imagePullSecrets == null ? 43 : $imagePullSecrets.hashCode());
        Object $initContainers = this.getInitContainers();
        result = result * prime + ($initContainers == null ? 43 : $initContainers.hashCode());
        Object $limits = this.getLimits();
        result = result * prime + ($limits == null ? 43 : $limits.hashCode());
        Object $listenLocal = this.getListenLocal();
        result = result * prime + ($listenLocal == null ? 43 : $listenLocal.hashCode());
        Object $logFormat = this.getLogFormat();
        result = result * prime + ($logFormat == null ? 43 : $logFormat.hashCode());
        Object $logLevel = this.getLogLevel();
        result = result * prime + ($logLevel == null ? 43 : $logLevel.hashCode());
        Object $minReadySeconds = this.getMinReadySeconds();
        result = result * prime + ($minReadySeconds == null ? 43 : $minReadySeconds.hashCode());
        Object $nodeSelector = this.getNodeSelector();
        result = result * prime + ($nodeSelector == null ? 43 : $nodeSelector.hashCode());
        Object $paused = this.getPaused();
        result = result * prime + ($paused == null ? 43 : $paused.hashCode());
        Object $persistentVolumeClaimRetentionPolicy = this.getPersistentVolumeClaimRetentionPolicy();
        result = result * prime + ($persistentVolumeClaimRetentionPolicy == null ? 43 : $persistentVolumeClaimRetentionPolicy.hashCode());
        Object $podManagementPolicy = this.getPodManagementPolicy();
        result = result * prime + ($podManagementPolicy == null ? 43 : $podManagementPolicy.hashCode());
        Object $podMetadata = this.getPodMetadata();
        result = result * prime + ($podMetadata == null ? 43 : $podMetadata.hashCode());
        Object $portName = this.getPortName();
        result = result * prime + ($portName == null ? 43 : $portName.hashCode());
        Object $priorityClassName = this.getPriorityClassName();
        result = result * prime + ($priorityClassName == null ? 43 : $priorityClassName.hashCode());
        Object $replicas = this.getReplicas();
        result = result * prime + ($replicas == null ? 43 : $replicas.hashCode());
        Object $resources = this.getResources();
        result = result * prime + ($resources == null ? 43 : $resources.hashCode());
        Object $retention = this.getRetention();
        result = result * prime + ($retention == null ? 43 : $retention.hashCode());
        Object $routePrefix = this.getRoutePrefix();
        result = result * prime + ($routePrefix == null ? 43 : $routePrefix.hashCode());
        Object $schedulerName = this.getSchedulerName();
        result = result * prime + ($schedulerName == null ? 43 : $schedulerName.hashCode());
        Object $secrets = this.getSecrets();
        result = result * prime + ($secrets == null ? 43 : $secrets.hashCode());
        Object $securityContext = this.getSecurityContext();
        result = result * prime + ($securityContext == null ? 43 : $securityContext.hashCode());
        Object $serviceAccountName = this.getServiceAccountName();
        result = result * prime + ($serviceAccountName == null ? 43 : $serviceAccountName.hashCode());
        Object $serviceName = this.getServiceName();
        result = result * prime + ($serviceName == null ? 43 : $serviceName.hashCode());
        Object $sha = this.getSha();
        result = result * prime + ($sha == null ? 43 : $sha.hashCode());
        Object $storage = this.getStorage();
        result = result * prime + ($storage == null ? 43 : $storage.hashCode());
        Object $tag = this.getTag();
        result = result * prime + ($tag == null ? 43 : $tag.hashCode());
        Object $terminationGracePeriodSeconds = this.getTerminationGracePeriodSeconds();
        result = result * prime + ($terminationGracePeriodSeconds == null ? 43 : $terminationGracePeriodSeconds.hashCode());
        Object $tolerations = this.getTolerations();
        result = result * prime + ($tolerations == null ? 43 : $tolerations.hashCode());
        Object $topologySpreadConstraints = this.getTopologySpreadConstraints();
        result = result * prime + ($topologySpreadConstraints == null ? 43 : $topologySpreadConstraints.hashCode());
        Object $updateStrategy = this.getUpdateStrategy();
        result = result * prime + ($updateStrategy == null ? 43 : $updateStrategy.hashCode());
        Object $version = this.getVersion();
        result = result * prime + ($version == null ? 43 : $version.hashCode());
        Object $volumeMounts = this.getVolumeMounts();
        result = result * prime + ($volumeMounts == null ? 43 : $volumeMounts.hashCode());
        Object $volumes = this.getVolumes();
        result = result * prime + ($volumes == null ? 43 : $volumes.hashCode());
        Object $web = this.getWeb();
        result = result * prime + ($web == null ? 43 : $web.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "AlertmanagerSpec(" + "additionalArgs=" + this.getAdditionalArgs() + ", additionalPeers=" + this.getAdditionalPeers() + ", affinity=" + this.getAffinity() + ", alertmanagerConfigMatcherStrategy=" + this.getAlertmanagerConfigMatcherStrategy() + ", alertmanagerConfigNamespaceSelector=" + this.getAlertmanagerConfigNamespaceSelector() + ", alertmanagerConfigSelector=" + this.getAlertmanagerConfigSelector() + ", alertmanagerConfiguration=" + this.getAlertmanagerConfiguration() + ", automountServiceAccountToken=" + this.getAutomountServiceAccountToken() + ", baseImage=" + this.getBaseImage() + ", clusterAdvertiseAddress=" + this.getClusterAdvertiseAddress() + ", clusterGossipInterval=" + this.getClusterGossipInterval() + ", clusterLabel=" + this.getClusterLabel() + ", clusterPeerTimeout=" + this.getClusterPeerTimeout() + ", clusterPushpullInterval=" + this.getClusterPushpullInterval() + ", clusterTLS=" + this.getClusterTLS() + ", configMaps=" + this.getConfigMaps() + ", configSecret=" + this.getConfigSecret() + ", containers=" + this.getContainers() + ", dnsConfig=" + this.getDnsConfig() + ", dnsPolicy=" + this.getDnsPolicy() + ", enableFeatures=" + this.getEnableFeatures() + ", enableServiceLinks=" + this.getEnableServiceLinks() + ", externalUrl=" + this.getExternalUrl() + ", forceEnableClusterMode=" + this.getForceEnableClusterMode() + ", hostAliases=" + this.getHostAliases() + ", hostNetwork=" + this.getHostNetwork() + ", hostUsers=" + this.getHostUsers() + ", image=" + this.getImage() + ", imagePullPolicy=" + this.getImagePullPolicy() + ", imagePullSecrets=" + this.getImagePullSecrets() + ", initContainers=" + this.getInitContainers() + ", limits=" + this.getLimits() + ", listenLocal=" + this.getListenLocal() + ", logFormat=" + this.getLogFormat() + ", logLevel=" + this.getLogLevel() + ", minReadySeconds=" + this.getMinReadySeconds() + ", nodeSelector=" + this.getNodeSelector() + ", paused=" + this.getPaused() + ", persistentVolumeClaimRetentionPolicy=" + this.getPersistentVolumeClaimRetentionPolicy() + ", podManagementPolicy=" + this.getPodManagementPolicy() + ", podMetadata=" + this.getPodMetadata() + ", portName=" + this.getPortName() + ", priorityClassName=" + this.getPriorityClassName() + ", replicas=" + this.getReplicas() + ", resources=" + this.getResources() + ", retention=" + this.getRetention() + ", routePrefix=" + this.getRoutePrefix() + ", schedulerName=" + this.getSchedulerName() + ", secrets=" + this.getSecrets() + ", securityContext=" + this.getSecurityContext() + ", serviceAccountName=" + this.getServiceAccountName() + ", serviceName=" + this.getServiceName() + ", sha=" + this.getSha() + ", storage=" + this.getStorage() + ", tag=" + this.getTag() + ", terminationGracePeriodSeconds=" + this.getTerminationGracePeriodSeconds() + ", tolerations=" + this.getTolerations() + ", topologySpreadConstraints=" + this.getTopologySpreadConstraints() + ", updateStrategy=" + this.getUpdateStrategy() + ", version=" + this.getVersion() + ", volumeMounts=" + this.getVolumeMounts() + ", volumes=" + this.getVolumes() + ", web=" + this.getWeb() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
