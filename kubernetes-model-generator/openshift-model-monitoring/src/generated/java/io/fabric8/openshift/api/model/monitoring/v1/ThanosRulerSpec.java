
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
import io.fabric8.kubernetes.api.model.SecretKeySelector;
import io.fabric8.kubernetes.api.model.Toleration;
import io.fabric8.kubernetes.api.model.TopologySpreadConstraint;
import io.fabric8.kubernetes.api.model.Volume;
import io.fabric8.kubernetes.api.model.VolumeMount;
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;

/**
 * ThanosRulerSpec is a specification of the desired behavior of the ThanosRuler. More info: https://github.com/kubernetes/community/blob/master/contributors/devel/sig-architecture/api-conventions.md#spec-and-status
 */
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
    "dnsConfig",
    "dnsPolicy",
    "enableFeatures",
    "enableServiceLinks",
    "enforcedNamespaceLabel",
    "evaluationInterval",
    "excludedFromEnforcement",
    "externalPrefix",
    "grpcServerTlsConfig",
    "hostAliases",
    "hostUsers",
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
    "podManagementPolicy",
    "podMetadata",
    "portName",
    "priorityClassName",
    "prometheusRulesExcludedFromEnforce",
    "queryConfig",
    "queryEndpoints",
    "remoteWrite",
    "replicas",
    "resendDelay",
    "resources",
    "retention",
    "routePrefix",
    "ruleConcurrentEval",
    "ruleGracePeriod",
    "ruleNamespaceSelector",
    "ruleOutageTolerance",
    "ruleQueryOffset",
    "ruleSelector",
    "schedulerName",
    "securityContext",
    "serviceAccountName",
    "serviceName",
    "storage",
    "terminationGracePeriodSeconds",
    "tolerations",
    "topologySpreadConstraints",
    "tracingConfig",
    "tracingConfigFile",
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
public class ThanosRulerSpec implements Editable<ThanosRulerSpecBuilder>, KubernetesResource
{

    @JsonProperty("additionalArgs")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<Argument> additionalArgs = new ArrayList<>();
    @JsonProperty("affinity")
    private Affinity affinity;
    @JsonProperty("alertDropLabels")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> alertDropLabels = new ArrayList<>();
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
    private List<String> alertmanagersUrl = new ArrayList<>();
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
    @JsonProperty("enforcedNamespaceLabel")
    private String enforcedNamespaceLabel;
    @JsonProperty("evaluationInterval")
    private String evaluationInterval;
    @JsonProperty("excludedFromEnforcement")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<ObjectReference> excludedFromEnforcement = new ArrayList<>();
    @JsonProperty("externalPrefix")
    private String externalPrefix;
    @JsonProperty("grpcServerTlsConfig")
    private GRPCServerTLSConfig grpcServerTlsConfig;
    @JsonProperty("hostAliases")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<HostAlias> hostAliases = new ArrayList<>();
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
    @JsonProperty("labels")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Map<String, String> labels = new LinkedHashMap<>();
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
    @JsonProperty("objectStorageConfig")
    private SecretKeySelector objectStorageConfig;
    @JsonProperty("objectStorageConfigFile")
    private String objectStorageConfigFile;
    @JsonProperty("paused")
    private Boolean paused;
    @JsonProperty("podManagementPolicy")
    private String podManagementPolicy;
    @JsonProperty("podMetadata")
    private EmbeddedObjectMetadata podMetadata;
    @JsonProperty("portName")
    private String portName;
    @JsonProperty("priorityClassName")
    private String priorityClassName;
    @JsonProperty("prometheusRulesExcludedFromEnforce")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<PrometheusRuleExcludeConfig> prometheusRulesExcludedFromEnforce = new ArrayList<>();
    @JsonProperty("queryConfig")
    private SecretKeySelector queryConfig;
    @JsonProperty("queryEndpoints")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> queryEndpoints = new ArrayList<>();
    @JsonProperty("remoteWrite")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<RemoteWriteSpec> remoteWrite = new ArrayList<>();
    @JsonProperty("replicas")
    private Integer replicas;
    @JsonProperty("resendDelay")
    private String resendDelay;
    @JsonProperty("resources")
    private ResourceRequirements resources;
    @JsonProperty("retention")
    private String retention;
    @JsonProperty("routePrefix")
    private String routePrefix;
    @JsonProperty("ruleConcurrentEval")
    private Integer ruleConcurrentEval;
    @JsonProperty("ruleGracePeriod")
    private String ruleGracePeriod;
    @JsonProperty("ruleNamespaceSelector")
    private LabelSelector ruleNamespaceSelector;
    @JsonProperty("ruleOutageTolerance")
    private String ruleOutageTolerance;
    @JsonProperty("ruleQueryOffset")
    private String ruleQueryOffset;
    @JsonProperty("ruleSelector")
    private LabelSelector ruleSelector;
    @JsonProperty("schedulerName")
    private String schedulerName;
    @JsonProperty("securityContext")
    private PodSecurityContext securityContext;
    @JsonProperty("serviceAccountName")
    private String serviceAccountName;
    @JsonProperty("serviceName")
    private String serviceName;
    @JsonProperty("storage")
    private StorageSpec storage;
    @JsonProperty("terminationGracePeriodSeconds")
    private Long terminationGracePeriodSeconds;
    @JsonProperty("tolerations")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<Toleration> tolerations = new ArrayList<>();
    @JsonProperty("topologySpreadConstraints")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<TopologySpreadConstraint> topologySpreadConstraints = new ArrayList<>();
    @JsonProperty("tracingConfig")
    private SecretKeySelector tracingConfig;
    @JsonProperty("tracingConfigFile")
    private String tracingConfigFile;
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
    private ThanosRulerWebSpec web;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public ThanosRulerSpec() {
    }

    public ThanosRulerSpec(List<Argument> additionalArgs, Affinity affinity, List<String> alertDropLabels, String alertQueryUrl, String alertRelabelConfigFile, SecretKeySelector alertRelabelConfigs, SecretKeySelector alertmanagersConfig, List<String> alertmanagersUrl, List<Container> containers, PodDNSConfig dnsConfig, String dnsPolicy, List<String> enableFeatures, Boolean enableServiceLinks, String enforcedNamespaceLabel, String evaluationInterval, List<ObjectReference> excludedFromEnforcement, String externalPrefix, GRPCServerTLSConfig grpcServerTlsConfig, List<HostAlias> hostAliases, Boolean hostUsers, String image, String imagePullPolicy, List<LocalObjectReference> imagePullSecrets, List<Container> initContainers, Map<String, String> labels, Boolean listenLocal, String logFormat, String logLevel, Integer minReadySeconds, Map<String, String> nodeSelector, SecretKeySelector objectStorageConfig, String objectStorageConfigFile, Boolean paused, String podManagementPolicy, EmbeddedObjectMetadata podMetadata, String portName, String priorityClassName, List<PrometheusRuleExcludeConfig> prometheusRulesExcludedFromEnforce, SecretKeySelector queryConfig, List<String> queryEndpoints, List<RemoteWriteSpec> remoteWrite, Integer replicas, String resendDelay, ResourceRequirements resources, String retention, String routePrefix, Integer ruleConcurrentEval, String ruleGracePeriod, LabelSelector ruleNamespaceSelector, String ruleOutageTolerance, String ruleQueryOffset, LabelSelector ruleSelector, String schedulerName, PodSecurityContext securityContext, String serviceAccountName, String serviceName, StorageSpec storage, Long terminationGracePeriodSeconds, List<Toleration> tolerations, List<TopologySpreadConstraint> topologySpreadConstraints, SecretKeySelector tracingConfig, String tracingConfigFile, StatefulSetUpdateStrategy updateStrategy, String version, List<VolumeMount> volumeMounts, List<Volume> volumes, ThanosRulerWebSpec web) {
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
        this.dnsConfig = dnsConfig;
        this.dnsPolicy = dnsPolicy;
        this.enableFeatures = enableFeatures;
        this.enableServiceLinks = enableServiceLinks;
        this.enforcedNamespaceLabel = enforcedNamespaceLabel;
        this.evaluationInterval = evaluationInterval;
        this.excludedFromEnforcement = excludedFromEnforcement;
        this.externalPrefix = externalPrefix;
        this.grpcServerTlsConfig = grpcServerTlsConfig;
        this.hostAliases = hostAliases;
        this.hostUsers = hostUsers;
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
        this.podManagementPolicy = podManagementPolicy;
        this.podMetadata = podMetadata;
        this.portName = portName;
        this.priorityClassName = priorityClassName;
        this.prometheusRulesExcludedFromEnforce = prometheusRulesExcludedFromEnforce;
        this.queryConfig = queryConfig;
        this.queryEndpoints = queryEndpoints;
        this.remoteWrite = remoteWrite;
        this.replicas = replicas;
        this.resendDelay = resendDelay;
        this.resources = resources;
        this.retention = retention;
        this.routePrefix = routePrefix;
        this.ruleConcurrentEval = ruleConcurrentEval;
        this.ruleGracePeriod = ruleGracePeriod;
        this.ruleNamespaceSelector = ruleNamespaceSelector;
        this.ruleOutageTolerance = ruleOutageTolerance;
        this.ruleQueryOffset = ruleQueryOffset;
        this.ruleSelector = ruleSelector;
        this.schedulerName = schedulerName;
        this.securityContext = securityContext;
        this.serviceAccountName = serviceAccountName;
        this.serviceName = serviceName;
        this.storage = storage;
        this.terminationGracePeriodSeconds = terminationGracePeriodSeconds;
        this.tolerations = tolerations;
        this.topologySpreadConstraints = topologySpreadConstraints;
        this.tracingConfig = tracingConfig;
        this.tracingConfigFile = tracingConfigFile;
        this.updateStrategy = updateStrategy;
        this.version = version;
        this.volumeMounts = volumeMounts;
        this.volumes = volumes;
        this.web = web;
    }

    /**
     * additionalArgs defines how to add additional arguments for the ThanosRuler container. It is intended for e.g. activating hidden flags which are not supported by the dedicated configuration options yet. The arguments are passed as-is to the ThanosRuler container which may cause issues if they are invalid or not supported by the given ThanosRuler version. In case of an argument conflict (e.g. an argument which is already set by the operator itself) or when providing an invalid argument the reconciliation will fail and an error will be logged.
     */
    @JsonProperty("additionalArgs")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<Argument> getAdditionalArgs() {
        return additionalArgs;
    }

    /**
     * additionalArgs defines how to add additional arguments for the ThanosRuler container. It is intended for e.g. activating hidden flags which are not supported by the dedicated configuration options yet. The arguments are passed as-is to the ThanosRuler container which may cause issues if they are invalid or not supported by the given ThanosRuler version. In case of an argument conflict (e.g. an argument which is already set by the operator itself) or when providing an invalid argument the reconciliation will fail and an error will be logged.
     */
    @JsonProperty("additionalArgs")
    public void setAdditionalArgs(List<Argument> additionalArgs) {
        this.additionalArgs = additionalArgs;
    }

    /**
     * ThanosRulerSpec is a specification of the desired behavior of the ThanosRuler. More info: https://github.com/kubernetes/community/blob/master/contributors/devel/sig-architecture/api-conventions.md#spec-and-status
     */
    @JsonProperty("affinity")
    public Affinity getAffinity() {
        return affinity;
    }

    /**
     * ThanosRulerSpec is a specification of the desired behavior of the ThanosRuler. More info: https://github.com/kubernetes/community/blob/master/contributors/devel/sig-architecture/api-conventions.md#spec-and-status
     */
    @JsonProperty("affinity")
    public void setAffinity(Affinity affinity) {
        this.affinity = affinity;
    }

    /**
     * alertDropLabels defines the label names which should be dropped in Thanos Ruler alerts.<br><p> <br><p> The replica label `thanos_ruler_replica` will always be dropped from the alerts.
     */
    @JsonProperty("alertDropLabels")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getAlertDropLabels() {
        return alertDropLabels;
    }

    /**
     * alertDropLabels defines the label names which should be dropped in Thanos Ruler alerts.<br><p> <br><p> The replica label `thanos_ruler_replica` will always be dropped from the alerts.
     */
    @JsonProperty("alertDropLabels")
    public void setAlertDropLabels(List<String> alertDropLabels) {
        this.alertDropLabels = alertDropLabels;
    }

    /**
     * alertQueryUrl defines how Thanos Ruler will set in the 'Source' field of all alerts. Maps to the '--alert.query-url' CLI arg.
     */
    @JsonProperty("alertQueryUrl")
    public String getAlertQueryUrl() {
        return alertQueryUrl;
    }

    /**
     * alertQueryUrl defines how Thanos Ruler will set in the 'Source' field of all alerts. Maps to the '--alert.query-url' CLI arg.
     */
    @JsonProperty("alertQueryUrl")
    public void setAlertQueryUrl(String alertQueryUrl) {
        this.alertQueryUrl = alertQueryUrl;
    }

    /**
     * alertRelabelConfigFile defines the path to the alert relabeling configuration file.<br><p> <br><p> Alert relabel configuration must have the form as specified in the official Prometheus documentation: https://prometheus.io/docs/prometheus/latest/configuration/configuration/#alert_relabel_configs<br><p> <br><p> The operator performs no validation of the configuration file.<br><p> <br><p> This field takes precedence over `alertRelabelConfig`.
     */
    @JsonProperty("alertRelabelConfigFile")
    public String getAlertRelabelConfigFile() {
        return alertRelabelConfigFile;
    }

    /**
     * alertRelabelConfigFile defines the path to the alert relabeling configuration file.<br><p> <br><p> Alert relabel configuration must have the form as specified in the official Prometheus documentation: https://prometheus.io/docs/prometheus/latest/configuration/configuration/#alert_relabel_configs<br><p> <br><p> The operator performs no validation of the configuration file.<br><p> <br><p> This field takes precedence over `alertRelabelConfig`.
     */
    @JsonProperty("alertRelabelConfigFile")
    public void setAlertRelabelConfigFile(String alertRelabelConfigFile) {
        this.alertRelabelConfigFile = alertRelabelConfigFile;
    }

    /**
     * ThanosRulerSpec is a specification of the desired behavior of the ThanosRuler. More info: https://github.com/kubernetes/community/blob/master/contributors/devel/sig-architecture/api-conventions.md#spec-and-status
     */
    @JsonProperty("alertRelabelConfigs")
    public SecretKeySelector getAlertRelabelConfigs() {
        return alertRelabelConfigs;
    }

    /**
     * ThanosRulerSpec is a specification of the desired behavior of the ThanosRuler. More info: https://github.com/kubernetes/community/blob/master/contributors/devel/sig-architecture/api-conventions.md#spec-and-status
     */
    @JsonProperty("alertRelabelConfigs")
    public void setAlertRelabelConfigs(SecretKeySelector alertRelabelConfigs) {
        this.alertRelabelConfigs = alertRelabelConfigs;
    }

    /**
     * ThanosRulerSpec is a specification of the desired behavior of the ThanosRuler. More info: https://github.com/kubernetes/community/blob/master/contributors/devel/sig-architecture/api-conventions.md#spec-and-status
     */
    @JsonProperty("alertmanagersConfig")
    public SecretKeySelector getAlertmanagersConfig() {
        return alertmanagersConfig;
    }

    /**
     * ThanosRulerSpec is a specification of the desired behavior of the ThanosRuler. More info: https://github.com/kubernetes/community/blob/master/contributors/devel/sig-architecture/api-conventions.md#spec-and-status
     */
    @JsonProperty("alertmanagersConfig")
    public void setAlertmanagersConfig(SecretKeySelector alertmanagersConfig) {
        this.alertmanagersConfig = alertmanagersConfig;
    }

    /**
     * alertmanagersUrl defines the list of Alertmanager endpoints to send alerts to.<br><p> <br><p> For Thanos &gt;= v0.10.0, it is recommended to use `alertmanagersConfig` instead.<br><p> <br><p> `alertmanagersConfig` takes precedence over this field.
     */
    @JsonProperty("alertmanagersUrl")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getAlertmanagersUrl() {
        return alertmanagersUrl;
    }

    /**
     * alertmanagersUrl defines the list of Alertmanager endpoints to send alerts to.<br><p> <br><p> For Thanos &gt;= v0.10.0, it is recommended to use `alertmanagersConfig` instead.<br><p> <br><p> `alertmanagersConfig` takes precedence over this field.
     */
    @JsonProperty("alertmanagersUrl")
    public void setAlertmanagersUrl(List<String> alertmanagersUrl) {
        this.alertmanagersUrl = alertmanagersUrl;
    }

    /**
     * containers allows injecting additional containers or modifying operator generated containers. This can be used to allow adding an authentication proxy to the Pods or to change the behavior of an operator generated container. Containers described here modify an operator generated container if they share the same name and modifications are done via a strategic merge patch.<br><p> <br><p> The names of containers managed by the operator are: &#42; `thanos-ruler` &#42; `config-reloader`<br><p> <br><p> Overriding containers which are managed by the operator require careful testing, especially when upgrading to a new version of the operator.
     */
    @JsonProperty("containers")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<Container> getContainers() {
        return containers;
    }

    /**
     * containers allows injecting additional containers or modifying operator generated containers. This can be used to allow adding an authentication proxy to the Pods or to change the behavior of an operator generated container. Containers described here modify an operator generated container if they share the same name and modifications are done via a strategic merge patch.<br><p> <br><p> The names of containers managed by the operator are: &#42; `thanos-ruler` &#42; `config-reloader`<br><p> <br><p> Overriding containers which are managed by the operator require careful testing, especially when upgrading to a new version of the operator.
     */
    @JsonProperty("containers")
    public void setContainers(List<Container> containers) {
        this.containers = containers;
    }

    /**
     * ThanosRulerSpec is a specification of the desired behavior of the ThanosRuler. More info: https://github.com/kubernetes/community/blob/master/contributors/devel/sig-architecture/api-conventions.md#spec-and-status
     */
    @JsonProperty("dnsConfig")
    public PodDNSConfig getDnsConfig() {
        return dnsConfig;
    }

    /**
     * ThanosRulerSpec is a specification of the desired behavior of the ThanosRuler. More info: https://github.com/kubernetes/community/blob/master/contributors/devel/sig-architecture/api-conventions.md#spec-and-status
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
     * enableFeatures defines how to setup Thanos Ruler feature flags. By default, no features are enabled.<br><p> <br><p> Enabling features which are disabled by default is entirely outside the scope of what the maintainers will support and by doing so, you accept that this behaviour may break at any time without notice.<br><p> <br><p> For more information see https://thanos.io/tip/components/rule.md/<br><p> <br><p> It requires Thanos &gt;= 0.39.0.
     */
    @JsonProperty("enableFeatures")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getEnableFeatures() {
        return enableFeatures;
    }

    /**
     * enableFeatures defines how to setup Thanos Ruler feature flags. By default, no features are enabled.<br><p> <br><p> Enabling features which are disabled by default is entirely outside the scope of what the maintainers will support and by doing so, you accept that this behaviour may break at any time without notice.<br><p> <br><p> For more information see https://thanos.io/tip/components/rule.md/<br><p> <br><p> It requires Thanos &gt;= 0.39.0.
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
     * enforcedNamespaceLabel enforces adding a namespace label of origin for each alert and metric that is user created. The label value will always be the namespace of the object that is being created.
     */
    @JsonProperty("enforcedNamespaceLabel")
    public String getEnforcedNamespaceLabel() {
        return enforcedNamespaceLabel;
    }

    /**
     * enforcedNamespaceLabel enforces adding a namespace label of origin for each alert and metric that is user created. The label value will always be the namespace of the object that is being created.
     */
    @JsonProperty("enforcedNamespaceLabel")
    public void setEnforcedNamespaceLabel(String enforcedNamespaceLabel) {
        this.enforcedNamespaceLabel = enforcedNamespaceLabel;
    }

    /**
     * evaluationInterval defines the interval between consecutive evaluations.
     */
    @JsonProperty("evaluationInterval")
    public String getEvaluationInterval() {
        return evaluationInterval;
    }

    /**
     * evaluationInterval defines the interval between consecutive evaluations.
     */
    @JsonProperty("evaluationInterval")
    public void setEvaluationInterval(String evaluationInterval) {
        this.evaluationInterval = evaluationInterval;
    }

    /**
     * excludedFromEnforcement defines the list of references to PrometheusRule objects to be excluded from enforcing a namespace label of origin. Applies only if enforcedNamespaceLabel set to true.
     */
    @JsonProperty("excludedFromEnforcement")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<ObjectReference> getExcludedFromEnforcement() {
        return excludedFromEnforcement;
    }

    /**
     * excludedFromEnforcement defines the list of references to PrometheusRule objects to be excluded from enforcing a namespace label of origin. Applies only if enforcedNamespaceLabel set to true.
     */
    @JsonProperty("excludedFromEnforcement")
    public void setExcludedFromEnforcement(List<ObjectReference> excludedFromEnforcement) {
        this.excludedFromEnforcement = excludedFromEnforcement;
    }

    /**
     * externalPrefix defines the Thanos Ruler instances will be available under. This is necessary to generate correct URLs. This is necessary if Thanos Ruler is not served from root of a DNS name.
     */
    @JsonProperty("externalPrefix")
    public String getExternalPrefix() {
        return externalPrefix;
    }

    /**
     * externalPrefix defines the Thanos Ruler instances will be available under. This is necessary to generate correct URLs. This is necessary if Thanos Ruler is not served from root of a DNS name.
     */
    @JsonProperty("externalPrefix")
    public void setExternalPrefix(String externalPrefix) {
        this.externalPrefix = externalPrefix;
    }

    /**
     * ThanosRulerSpec is a specification of the desired behavior of the ThanosRuler. More info: https://github.com/kubernetes/community/blob/master/contributors/devel/sig-architecture/api-conventions.md#spec-and-status
     */
    @JsonProperty("grpcServerTlsConfig")
    public GRPCServerTLSConfig getGrpcServerTlsConfig() {
        return grpcServerTlsConfig;
    }

    /**
     * ThanosRulerSpec is a specification of the desired behavior of the ThanosRuler. More info: https://github.com/kubernetes/community/blob/master/contributors/devel/sig-architecture/api-conventions.md#spec-and-status
     */
    @JsonProperty("grpcServerTlsConfig")
    public void setGrpcServerTlsConfig(GRPCServerTLSConfig grpcServerTlsConfig) {
        this.grpcServerTlsConfig = grpcServerTlsConfig;
    }

    /**
     * hostAliases defines pods' hostAliases configuration
     */
    @JsonProperty("hostAliases")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<HostAlias> getHostAliases() {
        return hostAliases;
    }

    /**
     * hostAliases defines pods' hostAliases configuration
     */
    @JsonProperty("hostAliases")
    public void setHostAliases(List<HostAlias> hostAliases) {
        this.hostAliases = hostAliases;
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
     * image defines Thanos container image URL.
     */
    @JsonProperty("image")
    public String getImage() {
        return image;
    }

    /**
     * image defines Thanos container image URL.
     */
    @JsonProperty("image")
    public void setImage(String image) {
        this.image = image;
    }

    /**
     * imagePullPolicy defines for the 'thanos', 'init-config-reloader' and 'config-reloader' containers. See https://kubernetes.io/docs/concepts/containers/images/#image-pull-policy for more details.<br><p> <br><p> Possible enum values:<br><p>  - `"Always"` means that kubelet always attempts to pull the latest image. Container will fail If the pull fails.<br><p>  - `"IfNotPresent"` means that kubelet pulls if the image isn't present on disk. Container will fail if the image isn't present and the pull fails.<br><p>  - `"Never"` means that kubelet never pulls an image, but only uses a local image. Container will fail if the image isn't present
     */
    @JsonProperty("imagePullPolicy")
    public String getImagePullPolicy() {
        return imagePullPolicy;
    }

    /**
     * imagePullPolicy defines for the 'thanos', 'init-config-reloader' and 'config-reloader' containers. See https://kubernetes.io/docs/concepts/containers/images/#image-pull-policy for more details.<br><p> <br><p> Possible enum values:<br><p>  - `"Always"` means that kubelet always attempts to pull the latest image. Container will fail If the pull fails.<br><p>  - `"IfNotPresent"` means that kubelet pulls if the image isn't present on disk. Container will fail if the image isn't present and the pull fails.<br><p>  - `"Never"` means that kubelet never pulls an image, but only uses a local image. Container will fail if the image isn't present
     */
    @JsonProperty("imagePullPolicy")
    public void setImagePullPolicy(String imagePullPolicy) {
        this.imagePullPolicy = imagePullPolicy;
    }

    /**
     * imagePullSecrets defines an optional list of references to secrets in the same namespace to use for pulling thanos images from registries see http://kubernetes.io/docs/user-guide/images#specifying-imagepullsecrets-on-a-pod
     */
    @JsonProperty("imagePullSecrets")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<LocalObjectReference> getImagePullSecrets() {
        return imagePullSecrets;
    }

    /**
     * imagePullSecrets defines an optional list of references to secrets in the same namespace to use for pulling thanos images from registries see http://kubernetes.io/docs/user-guide/images#specifying-imagepullsecrets-on-a-pod
     */
    @JsonProperty("imagePullSecrets")
    public void setImagePullSecrets(List<LocalObjectReference> imagePullSecrets) {
        this.imagePullSecrets = imagePullSecrets;
    }

    /**
     * initContainers allows injecting initContainers to the Pod definition. Those can be used to e.g. fetch secrets for injection into the configuration from external sources. Any errors during the execution of an initContainer will lead to a restart of the Pod. More info: https://kubernetes.io/docs/concepts/workloads/pods/init-containers/
     */
    @JsonProperty("initContainers")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<Container> getInitContainers() {
        return initContainers;
    }

    /**
     * initContainers allows injecting initContainers to the Pod definition. Those can be used to e.g. fetch secrets for injection into the configuration from external sources. Any errors during the execution of an initContainer will lead to a restart of the Pod. More info: https://kubernetes.io/docs/concepts/workloads/pods/init-containers/
     */
    @JsonProperty("initContainers")
    public void setInitContainers(List<Container> initContainers) {
        this.initContainers = initContainers;
    }

    /**
     * labels defines the external label pairs of the ThanosRuler resource.<br><p> <br><p> A default replica label `thanos_ruler_replica` will be always added as a label with the value of the pod's name.
     */
    @JsonProperty("labels")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public Map<String, String> getLabels() {
        return labels;
    }

    /**
     * labels defines the external label pairs of the ThanosRuler resource.<br><p> <br><p> A default replica label `thanos_ruler_replica` will be always added as a label with the value of the pod's name.
     */
    @JsonProperty("labels")
    public void setLabels(Map<String, String> labels) {
        this.labels = labels;
    }

    /**
     * listenLocal defines the Thanos ruler listen on loopback, so that it does not bind against the Pod IP.
     */
    @JsonProperty("listenLocal")
    public Boolean getListenLocal() {
        return listenLocal;
    }

    /**
     * listenLocal defines the Thanos ruler listen on loopback, so that it does not bind against the Pod IP.
     */
    @JsonProperty("listenLocal")
    public void setListenLocal(Boolean listenLocal) {
        this.listenLocal = listenLocal;
    }

    /**
     * logFormat for ThanosRuler to be configured with.
     */
    @JsonProperty("logFormat")
    public String getLogFormat() {
        return logFormat;
    }

    /**
     * logFormat for ThanosRuler to be configured with.
     */
    @JsonProperty("logFormat")
    public void setLogFormat(String logFormat) {
        this.logFormat = logFormat;
    }

    /**
     * logLevel for ThanosRuler to be configured with.
     */
    @JsonProperty("logLevel")
    public String getLogLevel() {
        return logLevel;
    }

    /**
     * logLevel for ThanosRuler to be configured with.
     */
    @JsonProperty("logLevel")
    public void setLogLevel(String logLevel) {
        this.logLevel = logLevel;
    }

    /**
     * minReadySeconds defines the minimum number of seconds for which a newly created pod should be ready without any of its container crashing for it to be considered available.<br><p> <br><p> If unset, pods will be considered available as soon as they are ready.
     */
    @JsonProperty("minReadySeconds")
    public Integer getMinReadySeconds() {
        return minReadySeconds;
    }

    /**
     * minReadySeconds defines the minimum number of seconds for which a newly created pod should be ready without any of its container crashing for it to be considered available.<br><p> <br><p> If unset, pods will be considered available as soon as they are ready.
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
     * ThanosRulerSpec is a specification of the desired behavior of the ThanosRuler. More info: https://github.com/kubernetes/community/blob/master/contributors/devel/sig-architecture/api-conventions.md#spec-and-status
     */
    @JsonProperty("objectStorageConfig")
    public SecretKeySelector getObjectStorageConfig() {
        return objectStorageConfig;
    }

    /**
     * ThanosRulerSpec is a specification of the desired behavior of the ThanosRuler. More info: https://github.com/kubernetes/community/blob/master/contributors/devel/sig-architecture/api-conventions.md#spec-and-status
     */
    @JsonProperty("objectStorageConfig")
    public void setObjectStorageConfig(SecretKeySelector objectStorageConfig) {
        this.objectStorageConfig = objectStorageConfig;
    }

    /**
     * objectStorageConfigFile defines the path of the object storage configuration file.<br><p> <br><p> The configuration format is defined at https://thanos.io/tip/thanos/storage.md/#configuring-access-to-object-storage<br><p> <br><p> The operator performs no validation of the configuration file.<br><p> <br><p> This field takes precedence over `objectStorageConfig`.
     */
    @JsonProperty("objectStorageConfigFile")
    public String getObjectStorageConfigFile() {
        return objectStorageConfigFile;
    }

    /**
     * objectStorageConfigFile defines the path of the object storage configuration file.<br><p> <br><p> The configuration format is defined at https://thanos.io/tip/thanos/storage.md/#configuring-access-to-object-storage<br><p> <br><p> The operator performs no validation of the configuration file.<br><p> <br><p> This field takes precedence over `objectStorageConfig`.
     */
    @JsonProperty("objectStorageConfigFile")
    public void setObjectStorageConfigFile(String objectStorageConfigFile) {
        this.objectStorageConfigFile = objectStorageConfigFile;
    }

    /**
     * paused defines when a ThanosRuler deployment is paused, no actions except for deletion will be performed on the underlying objects.
     */
    @JsonProperty("paused")
    public Boolean getPaused() {
        return paused;
    }

    /**
     * paused defines when a ThanosRuler deployment is paused, no actions except for deletion will be performed on the underlying objects.
     */
    @JsonProperty("paused")
    public void setPaused(Boolean paused) {
        this.paused = paused;
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
     * ThanosRulerSpec is a specification of the desired behavior of the ThanosRuler. More info: https://github.com/kubernetes/community/blob/master/contributors/devel/sig-architecture/api-conventions.md#spec-and-status
     */
    @JsonProperty("podMetadata")
    public EmbeddedObjectMetadata getPodMetadata() {
        return podMetadata;
    }

    /**
     * ThanosRulerSpec is a specification of the desired behavior of the ThanosRuler. More info: https://github.com/kubernetes/community/blob/master/contributors/devel/sig-architecture/api-conventions.md#spec-and-status
     */
    @JsonProperty("podMetadata")
    public void setPodMetadata(EmbeddedObjectMetadata podMetadata) {
        this.podMetadata = podMetadata;
    }

    /**
     * portName defines the port name used for the pods and governing service. Defaults to `web`.
     */
    @JsonProperty("portName")
    public String getPortName() {
        return portName;
    }

    /**
     * portName defines the port name used for the pods and governing service. Defaults to `web`.
     */
    @JsonProperty("portName")
    public void setPortName(String portName) {
        this.portName = portName;
    }

    /**
     * priorityClassName defines the priority class assigned to the Pods
     */
    @JsonProperty("priorityClassName")
    public String getPriorityClassName() {
        return priorityClassName;
    }

    /**
     * priorityClassName defines the priority class assigned to the Pods
     */
    @JsonProperty("priorityClassName")
    public void setPriorityClassName(String priorityClassName) {
        this.priorityClassName = priorityClassName;
    }

    /**
     * prometheusRulesExcludedFromEnforce defines a list of Prometheus rules to be excluded from enforcing of adding namespace labels. Works only if enforcedNamespaceLabel set to true. Make sure both ruleNamespace and ruleName are set for each pair Deprecated: use excludedFromEnforcement instead.
     */
    @JsonProperty("prometheusRulesExcludedFromEnforce")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<PrometheusRuleExcludeConfig> getPrometheusRulesExcludedFromEnforce() {
        return prometheusRulesExcludedFromEnforce;
    }

    /**
     * prometheusRulesExcludedFromEnforce defines a list of Prometheus rules to be excluded from enforcing of adding namespace labels. Works only if enforcedNamespaceLabel set to true. Make sure both ruleNamespace and ruleName are set for each pair Deprecated: use excludedFromEnforcement instead.
     */
    @JsonProperty("prometheusRulesExcludedFromEnforce")
    public void setPrometheusRulesExcludedFromEnforce(List<PrometheusRuleExcludeConfig> prometheusRulesExcludedFromEnforce) {
        this.prometheusRulesExcludedFromEnforce = prometheusRulesExcludedFromEnforce;
    }

    /**
     * ThanosRulerSpec is a specification of the desired behavior of the ThanosRuler. More info: https://github.com/kubernetes/community/blob/master/contributors/devel/sig-architecture/api-conventions.md#spec-and-status
     */
    @JsonProperty("queryConfig")
    public SecretKeySelector getQueryConfig() {
        return queryConfig;
    }

    /**
     * ThanosRulerSpec is a specification of the desired behavior of the ThanosRuler. More info: https://github.com/kubernetes/community/blob/master/contributors/devel/sig-architecture/api-conventions.md#spec-and-status
     */
    @JsonProperty("queryConfig")
    public void setQueryConfig(SecretKeySelector queryConfig) {
        this.queryConfig = queryConfig;
    }

    /**
     * queryEndpoints defines the list of Thanos Query endpoints from which to query metrics.<br><p> <br><p> For Thanos &gt;= v0.11.0, it is recommended to use `queryConfig` instead.<br><p> <br><p> `queryConfig` takes precedence over this field.
     */
    @JsonProperty("queryEndpoints")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getQueryEndpoints() {
        return queryEndpoints;
    }

    /**
     * queryEndpoints defines the list of Thanos Query endpoints from which to query metrics.<br><p> <br><p> For Thanos &gt;= v0.11.0, it is recommended to use `queryConfig` instead.<br><p> <br><p> `queryConfig` takes precedence over this field.
     */
    @JsonProperty("queryEndpoints")
    public void setQueryEndpoints(List<String> queryEndpoints) {
        this.queryEndpoints = queryEndpoints;
    }

    /**
     * remoteWrite defines the list of remote write configurations.<br><p> <br><p> When the list isn't empty, the ruler is configured with stateless mode.<br><p> <br><p> It requires Thanos &gt;= 0.24.0.
     */
    @JsonProperty("remoteWrite")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<RemoteWriteSpec> getRemoteWrite() {
        return remoteWrite;
    }

    /**
     * remoteWrite defines the list of remote write configurations.<br><p> <br><p> When the list isn't empty, the ruler is configured with stateless mode.<br><p> <br><p> It requires Thanos &gt;= 0.24.0.
     */
    @JsonProperty("remoteWrite")
    public void setRemoteWrite(List<RemoteWriteSpec> remoteWrite) {
        this.remoteWrite = remoteWrite;
    }

    /**
     * replicas defines the number of thanos ruler instances to deploy.
     */
    @JsonProperty("replicas")
    public Integer getReplicas() {
        return replicas;
    }

    /**
     * replicas defines the number of thanos ruler instances to deploy.
     */
    @JsonProperty("replicas")
    public void setReplicas(Integer replicas) {
        this.replicas = replicas;
    }

    /**
     * resendDelay defines the minimum amount of time to wait before resending an alert to Alertmanager.
     */
    @JsonProperty("resendDelay")
    public String getResendDelay() {
        return resendDelay;
    }

    /**
     * resendDelay defines the minimum amount of time to wait before resending an alert to Alertmanager.
     */
    @JsonProperty("resendDelay")
    public void setResendDelay(String resendDelay) {
        this.resendDelay = resendDelay;
    }

    /**
     * ThanosRulerSpec is a specification of the desired behavior of the ThanosRuler. More info: https://github.com/kubernetes/community/blob/master/contributors/devel/sig-architecture/api-conventions.md#spec-and-status
     */
    @JsonProperty("resources")
    public ResourceRequirements getResources() {
        return resources;
    }

    /**
     * ThanosRulerSpec is a specification of the desired behavior of the ThanosRuler. More info: https://github.com/kubernetes/community/blob/master/contributors/devel/sig-architecture/api-conventions.md#spec-and-status
     */
    @JsonProperty("resources")
    public void setResources(ResourceRequirements resources) {
        this.resources = resources;
    }

    /**
     * retention defines the time duration ThanosRuler shall retain data for. Default is '24h', and must match the regular expression `[0-9]+(ms|s|m|h|d|w|y)` (milliseconds seconds minutes hours days weeks years).<br><p> <br><p> The field has no effect when remote-write is configured since the Ruler operates in stateless mode.
     */
    @JsonProperty("retention")
    public String getRetention() {
        return retention;
    }

    /**
     * retention defines the time duration ThanosRuler shall retain data for. Default is '24h', and must match the regular expression `[0-9]+(ms|s|m|h|d|w|y)` (milliseconds seconds minutes hours days weeks years).<br><p> <br><p> The field has no effect when remote-write is configured since the Ruler operates in stateless mode.
     */
    @JsonProperty("retention")
    public void setRetention(String retention) {
        this.retention = retention;
    }

    /**
     * routePrefix defines the route prefix ThanosRuler registers HTTP handlers for. This allows thanos UI to be served on a sub-path.
     */
    @JsonProperty("routePrefix")
    public String getRoutePrefix() {
        return routePrefix;
    }

    /**
     * routePrefix defines the route prefix ThanosRuler registers HTTP handlers for. This allows thanos UI to be served on a sub-path.
     */
    @JsonProperty("routePrefix")
    public void setRoutePrefix(String routePrefix) {
        this.routePrefix = routePrefix;
    }

    /**
     * ruleConcurrentEval defines how many rules can be evaluated concurrently. It requires Thanos &gt;= v0.37.0.
     */
    @JsonProperty("ruleConcurrentEval")
    public Integer getRuleConcurrentEval() {
        return ruleConcurrentEval;
    }

    /**
     * ruleConcurrentEval defines how many rules can be evaluated concurrently. It requires Thanos &gt;= v0.37.0.
     */
    @JsonProperty("ruleConcurrentEval")
    public void setRuleConcurrentEval(Integer ruleConcurrentEval) {
        this.ruleConcurrentEval = ruleConcurrentEval;
    }

    /**
     * ruleGracePeriod defines the minimum duration between alert and restored "for" state. This is maintained only for alerts with configured "for" time greater than grace period. It requires Thanos &gt;= v0.30.0.
     */
    @JsonProperty("ruleGracePeriod")
    public String getRuleGracePeriod() {
        return ruleGracePeriod;
    }

    /**
     * ruleGracePeriod defines the minimum duration between alert and restored "for" state. This is maintained only for alerts with configured "for" time greater than grace period. It requires Thanos &gt;= v0.30.0.
     */
    @JsonProperty("ruleGracePeriod")
    public void setRuleGracePeriod(String ruleGracePeriod) {
        this.ruleGracePeriod = ruleGracePeriod;
    }

    /**
     * ThanosRulerSpec is a specification of the desired behavior of the ThanosRuler. More info: https://github.com/kubernetes/community/blob/master/contributors/devel/sig-architecture/api-conventions.md#spec-and-status
     */
    @JsonProperty("ruleNamespaceSelector")
    public LabelSelector getRuleNamespaceSelector() {
        return ruleNamespaceSelector;
    }

    /**
     * ThanosRulerSpec is a specification of the desired behavior of the ThanosRuler. More info: https://github.com/kubernetes/community/blob/master/contributors/devel/sig-architecture/api-conventions.md#spec-and-status
     */
    @JsonProperty("ruleNamespaceSelector")
    public void setRuleNamespaceSelector(LabelSelector ruleNamespaceSelector) {
        this.ruleNamespaceSelector = ruleNamespaceSelector;
    }

    /**
     * ruleOutageTolerance defines the max time to tolerate prometheus outage for restoring "for" state of alert. It requires Thanos &gt;= v0.30.0.
     */
    @JsonProperty("ruleOutageTolerance")
    public String getRuleOutageTolerance() {
        return ruleOutageTolerance;
    }

    /**
     * ruleOutageTolerance defines the max time to tolerate prometheus outage for restoring "for" state of alert. It requires Thanos &gt;= v0.30.0.
     */
    @JsonProperty("ruleOutageTolerance")
    public void setRuleOutageTolerance(String ruleOutageTolerance) {
        this.ruleOutageTolerance = ruleOutageTolerance;
    }

    /**
     * ruleQueryOffset defines the default rule group's query offset duration to use. It requires Thanos &gt;= v0.38.0.
     */
    @JsonProperty("ruleQueryOffset")
    public String getRuleQueryOffset() {
        return ruleQueryOffset;
    }

    /**
     * ruleQueryOffset defines the default rule group's query offset duration to use. It requires Thanos &gt;= v0.38.0.
     */
    @JsonProperty("ruleQueryOffset")
    public void setRuleQueryOffset(String ruleQueryOffset) {
        this.ruleQueryOffset = ruleQueryOffset;
    }

    /**
     * ThanosRulerSpec is a specification of the desired behavior of the ThanosRuler. More info: https://github.com/kubernetes/community/blob/master/contributors/devel/sig-architecture/api-conventions.md#spec-and-status
     */
    @JsonProperty("ruleSelector")
    public LabelSelector getRuleSelector() {
        return ruleSelector;
    }

    /**
     * ThanosRulerSpec is a specification of the desired behavior of the ThanosRuler. More info: https://github.com/kubernetes/community/blob/master/contributors/devel/sig-architecture/api-conventions.md#spec-and-status
     */
    @JsonProperty("ruleSelector")
    public void setRuleSelector(LabelSelector ruleSelector) {
        this.ruleSelector = ruleSelector;
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
     * ThanosRulerSpec is a specification of the desired behavior of the ThanosRuler. More info: https://github.com/kubernetes/community/blob/master/contributors/devel/sig-architecture/api-conventions.md#spec-and-status
     */
    @JsonProperty("securityContext")
    public PodSecurityContext getSecurityContext() {
        return securityContext;
    }

    /**
     * ThanosRulerSpec is a specification of the desired behavior of the ThanosRuler. More info: https://github.com/kubernetes/community/blob/master/contributors/devel/sig-architecture/api-conventions.md#spec-and-status
     */
    @JsonProperty("securityContext")
    public void setSecurityContext(PodSecurityContext securityContext) {
        this.securityContext = securityContext;
    }

    /**
     * serviceAccountName defines the name of the ServiceAccount to use to run the Thanos Ruler Pods.
     */
    @JsonProperty("serviceAccountName")
    public String getServiceAccountName() {
        return serviceAccountName;
    }

    /**
     * serviceAccountName defines the name of the ServiceAccount to use to run the Thanos Ruler Pods.
     */
    @JsonProperty("serviceAccountName")
    public void setServiceAccountName(String serviceAccountName) {
        this.serviceAccountName = serviceAccountName;
    }

    /**
     * serviceName defines the name of the service name used by the underlying StatefulSet(s) as the governing service. If defined, the Service  must be created before the ThanosRuler resource in the same namespace and it must define a selector that matches the pod labels. If empty, the operator will create and manage a headless service named `thanos-ruler-operated` for ThanosRuler resources. When deploying multiple ThanosRuler resources in the same namespace, it is recommended to specify a different value for each. See https://kubernetes.io/docs/concepts/workloads/controllers/statefulset/#stable-network-id for more details.
     */
    @JsonProperty("serviceName")
    public String getServiceName() {
        return serviceName;
    }

    /**
     * serviceName defines the name of the service name used by the underlying StatefulSet(s) as the governing service. If defined, the Service  must be created before the ThanosRuler resource in the same namespace and it must define a selector that matches the pod labels. If empty, the operator will create and manage a headless service named `thanos-ruler-operated` for ThanosRuler resources. When deploying multiple ThanosRuler resources in the same namespace, it is recommended to specify a different value for each. See https://kubernetes.io/docs/concepts/workloads/controllers/statefulset/#stable-network-id for more details.
     */
    @JsonProperty("serviceName")
    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    /**
     * ThanosRulerSpec is a specification of the desired behavior of the ThanosRuler. More info: https://github.com/kubernetes/community/blob/master/contributors/devel/sig-architecture/api-conventions.md#spec-and-status
     */
    @JsonProperty("storage")
    public StorageSpec getStorage() {
        return storage;
    }

    /**
     * ThanosRulerSpec is a specification of the desired behavior of the ThanosRuler. More info: https://github.com/kubernetes/community/blob/master/contributors/devel/sig-architecture/api-conventions.md#spec-and-status
     */
    @JsonProperty("storage")
    public void setStorage(StorageSpec storage) {
        this.storage = storage;
    }

    /**
     * terminationGracePeriodSeconds defines the optional duration in seconds the pod needs to terminate gracefully. Value must be non-negative integer. The value zero indicates stop immediately via the kill signal (no opportunity to shut down) which may lead to data corruption.<br><p> <br><p> Defaults to 120 seconds.
     */
    @JsonProperty("terminationGracePeriodSeconds")
    public Long getTerminationGracePeriodSeconds() {
        return terminationGracePeriodSeconds;
    }

    /**
     * terminationGracePeriodSeconds defines the optional duration in seconds the pod needs to terminate gracefully. Value must be non-negative integer. The value zero indicates stop immediately via the kill signal (no opportunity to shut down) which may lead to data corruption.<br><p> <br><p> Defaults to 120 seconds.
     */
    @JsonProperty("terminationGracePeriodSeconds")
    public void setTerminationGracePeriodSeconds(Long terminationGracePeriodSeconds) {
        this.terminationGracePeriodSeconds = terminationGracePeriodSeconds;
    }

    /**
     * tolerations defines when specified, the pod's tolerations.
     */
    @JsonProperty("tolerations")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<Toleration> getTolerations() {
        return tolerations;
    }

    /**
     * tolerations defines when specified, the pod's tolerations.
     */
    @JsonProperty("tolerations")
    public void setTolerations(List<Toleration> tolerations) {
        this.tolerations = tolerations;
    }

    /**
     * topologySpreadConstraints defines the pod's topology spread constraints.
     */
    @JsonProperty("topologySpreadConstraints")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<TopologySpreadConstraint> getTopologySpreadConstraints() {
        return topologySpreadConstraints;
    }

    /**
     * topologySpreadConstraints defines the pod's topology spread constraints.
     */
    @JsonProperty("topologySpreadConstraints")
    public void setTopologySpreadConstraints(List<TopologySpreadConstraint> topologySpreadConstraints) {
        this.topologySpreadConstraints = topologySpreadConstraints;
    }

    /**
     * ThanosRulerSpec is a specification of the desired behavior of the ThanosRuler. More info: https://github.com/kubernetes/community/blob/master/contributors/devel/sig-architecture/api-conventions.md#spec-and-status
     */
    @JsonProperty("tracingConfig")
    public SecretKeySelector getTracingConfig() {
        return tracingConfig;
    }

    /**
     * ThanosRulerSpec is a specification of the desired behavior of the ThanosRuler. More info: https://github.com/kubernetes/community/blob/master/contributors/devel/sig-architecture/api-conventions.md#spec-and-status
     */
    @JsonProperty("tracingConfig")
    public void setTracingConfig(SecretKeySelector tracingConfig) {
        this.tracingConfig = tracingConfig;
    }

    /**
     * tracingConfigFile defines the path of the tracing configuration file.<br><p> <br><p> The configuration format is defined at https://thanos.io/tip/thanos/tracing.md/#configuration<br><p> <br><p> This is an &#42;experimental feature&#42;, it may change in any upcoming release in a breaking way.<br><p> <br><p> The operator performs no validation of the configuration file.<br><p> <br><p> This field takes precedence over `tracingConfig`.
     */
    @JsonProperty("tracingConfigFile")
    public String getTracingConfigFile() {
        return tracingConfigFile;
    }

    /**
     * tracingConfigFile defines the path of the tracing configuration file.<br><p> <br><p> The configuration format is defined at https://thanos.io/tip/thanos/tracing.md/#configuration<br><p> <br><p> This is an &#42;experimental feature&#42;, it may change in any upcoming release in a breaking way.<br><p> <br><p> The operator performs no validation of the configuration file.<br><p> <br><p> This field takes precedence over `tracingConfig`.
     */
    @JsonProperty("tracingConfigFile")
    public void setTracingConfigFile(String tracingConfigFile) {
        this.tracingConfigFile = tracingConfigFile;
    }

    /**
     * ThanosRulerSpec is a specification of the desired behavior of the ThanosRuler. More info: https://github.com/kubernetes/community/blob/master/contributors/devel/sig-architecture/api-conventions.md#spec-and-status
     */
    @JsonProperty("updateStrategy")
    public StatefulSetUpdateStrategy getUpdateStrategy() {
        return updateStrategy;
    }

    /**
     * ThanosRulerSpec is a specification of the desired behavior of the ThanosRuler. More info: https://github.com/kubernetes/community/blob/master/contributors/devel/sig-architecture/api-conventions.md#spec-and-status
     */
    @JsonProperty("updateStrategy")
    public void setUpdateStrategy(StatefulSetUpdateStrategy updateStrategy) {
        this.updateStrategy = updateStrategy;
    }

    /**
     * version of Thanos to be deployed.
     */
    @JsonProperty("version")
    public String getVersion() {
        return version;
    }

    /**
     * version of Thanos to be deployed.
     */
    @JsonProperty("version")
    public void setVersion(String version) {
        this.version = version;
    }

    /**
     * volumeMounts defines how the configuration of additional VolumeMounts on the output StatefulSet definition. VolumeMounts specified will be appended to other VolumeMounts in the ruler container, that are generated as a result of StorageSpec objects.
     */
    @JsonProperty("volumeMounts")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<VolumeMount> getVolumeMounts() {
        return volumeMounts;
    }

    /**
     * volumeMounts defines how the configuration of additional VolumeMounts on the output StatefulSet definition. VolumeMounts specified will be appended to other VolumeMounts in the ruler container, that are generated as a result of StorageSpec objects.
     */
    @JsonProperty("volumeMounts")
    public void setVolumeMounts(List<VolumeMount> volumeMounts) {
        this.volumeMounts = volumeMounts;
    }

    /**
     * volumes defines how configuration of additional volumes on the output StatefulSet definition. Volumes specified will be appended to other volumes that are generated as a result of StorageSpec objects.
     */
    @JsonProperty("volumes")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<Volume> getVolumes() {
        return volumes;
    }

    /**
     * volumes defines how configuration of additional volumes on the output StatefulSet definition. Volumes specified will be appended to other volumes that are generated as a result of StorageSpec objects.
     */
    @JsonProperty("volumes")
    public void setVolumes(List<Volume> volumes) {
        this.volumes = volumes;
    }

    /**
     * ThanosRulerSpec is a specification of the desired behavior of the ThanosRuler. More info: https://github.com/kubernetes/community/blob/master/contributors/devel/sig-architecture/api-conventions.md#spec-and-status
     */
    @JsonProperty("web")
    public ThanosRulerWebSpec getWeb() {
        return web;
    }

    /**
     * ThanosRulerSpec is a specification of the desired behavior of the ThanosRuler. More info: https://github.com/kubernetes/community/blob/master/contributors/devel/sig-architecture/api-conventions.md#spec-and-status
     */
    @JsonProperty("web")
    public void setWeb(ThanosRulerWebSpec web) {
        this.web = web;
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
        if (!(o instanceof ThanosRulerSpec)) {
            return false;
        }
        ThanosRulerSpec other = (ThanosRulerSpec) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$additionalArgs = this.getAdditionalArgs();
        Object other$additionalArgs = other.getAdditionalArgs();
        if (this$additionalArgs == null ? other$additionalArgs != null : !this$additionalArgs.equals(other$additionalArgs)) {
            return false;
        }
        Object this$affinity = this.getAffinity();
        Object other$affinity = other.getAffinity();
        if (this$affinity == null ? other$affinity != null : !this$affinity.equals(other$affinity)) {
            return false;
        }
        Object this$alertDropLabels = this.getAlertDropLabels();
        Object other$alertDropLabels = other.getAlertDropLabels();
        if (this$alertDropLabels == null ? other$alertDropLabels != null : !this$alertDropLabels.equals(other$alertDropLabels)) {
            return false;
        }
        Object this$alertQueryUrl = this.getAlertQueryUrl();
        Object other$alertQueryUrl = other.getAlertQueryUrl();
        if (this$alertQueryUrl == null ? other$alertQueryUrl != null : !this$alertQueryUrl.equals(other$alertQueryUrl)) {
            return false;
        }
        Object this$alertRelabelConfigFile = this.getAlertRelabelConfigFile();
        Object other$alertRelabelConfigFile = other.getAlertRelabelConfigFile();
        if (this$alertRelabelConfigFile == null ? other$alertRelabelConfigFile != null : !this$alertRelabelConfigFile.equals(other$alertRelabelConfigFile)) {
            return false;
        }
        Object this$alertRelabelConfigs = this.getAlertRelabelConfigs();
        Object other$alertRelabelConfigs = other.getAlertRelabelConfigs();
        if (this$alertRelabelConfigs == null ? other$alertRelabelConfigs != null : !this$alertRelabelConfigs.equals(other$alertRelabelConfigs)) {
            return false;
        }
        Object this$alertmanagersConfig = this.getAlertmanagersConfig();
        Object other$alertmanagersConfig = other.getAlertmanagersConfig();
        if (this$alertmanagersConfig == null ? other$alertmanagersConfig != null : !this$alertmanagersConfig.equals(other$alertmanagersConfig)) {
            return false;
        }
        Object this$alertmanagersUrl = this.getAlertmanagersUrl();
        Object other$alertmanagersUrl = other.getAlertmanagersUrl();
        if (this$alertmanagersUrl == null ? other$alertmanagersUrl != null : !this$alertmanagersUrl.equals(other$alertmanagersUrl)) {
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
        Object this$enforcedNamespaceLabel = this.getEnforcedNamespaceLabel();
        Object other$enforcedNamespaceLabel = other.getEnforcedNamespaceLabel();
        if (this$enforcedNamespaceLabel == null ? other$enforcedNamespaceLabel != null : !this$enforcedNamespaceLabel.equals(other$enforcedNamespaceLabel)) {
            return false;
        }
        Object this$evaluationInterval = this.getEvaluationInterval();
        Object other$evaluationInterval = other.getEvaluationInterval();
        if (this$evaluationInterval == null ? other$evaluationInterval != null : !this$evaluationInterval.equals(other$evaluationInterval)) {
            return false;
        }
        Object this$excludedFromEnforcement = this.getExcludedFromEnforcement();
        Object other$excludedFromEnforcement = other.getExcludedFromEnforcement();
        if (this$excludedFromEnforcement == null ? other$excludedFromEnforcement != null : !this$excludedFromEnforcement.equals(other$excludedFromEnforcement)) {
            return false;
        }
        Object this$externalPrefix = this.getExternalPrefix();
        Object other$externalPrefix = other.getExternalPrefix();
        if (this$externalPrefix == null ? other$externalPrefix != null : !this$externalPrefix.equals(other$externalPrefix)) {
            return false;
        }
        Object this$grpcServerTlsConfig = this.getGrpcServerTlsConfig();
        Object other$grpcServerTlsConfig = other.getGrpcServerTlsConfig();
        if (this$grpcServerTlsConfig == null ? other$grpcServerTlsConfig != null : !this$grpcServerTlsConfig.equals(other$grpcServerTlsConfig)) {
            return false;
        }
        Object this$hostAliases = this.getHostAliases();
        Object other$hostAliases = other.getHostAliases();
        if (this$hostAliases == null ? other$hostAliases != null : !this$hostAliases.equals(other$hostAliases)) {
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
        Object this$labels = this.getLabels();
        Object other$labels = other.getLabels();
        if (this$labels == null ? other$labels != null : !this$labels.equals(other$labels)) {
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
        Object this$objectStorageConfig = this.getObjectStorageConfig();
        Object other$objectStorageConfig = other.getObjectStorageConfig();
        if (this$objectStorageConfig == null ? other$objectStorageConfig != null : !this$objectStorageConfig.equals(other$objectStorageConfig)) {
            return false;
        }
        Object this$objectStorageConfigFile = this.getObjectStorageConfigFile();
        Object other$objectStorageConfigFile = other.getObjectStorageConfigFile();
        if (this$objectStorageConfigFile == null ? other$objectStorageConfigFile != null : !this$objectStorageConfigFile.equals(other$objectStorageConfigFile)) {
            return false;
        }
        Object this$paused = this.getPaused();
        Object other$paused = other.getPaused();
        if (this$paused == null ? other$paused != null : !this$paused.equals(other$paused)) {
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
        Object this$prometheusRulesExcludedFromEnforce = this.getPrometheusRulesExcludedFromEnforce();
        Object other$prometheusRulesExcludedFromEnforce = other.getPrometheusRulesExcludedFromEnforce();
        if (this$prometheusRulesExcludedFromEnforce == null ? other$prometheusRulesExcludedFromEnforce != null : !this$prometheusRulesExcludedFromEnforce.equals(other$prometheusRulesExcludedFromEnforce)) {
            return false;
        }
        Object this$queryConfig = this.getQueryConfig();
        Object other$queryConfig = other.getQueryConfig();
        if (this$queryConfig == null ? other$queryConfig != null : !this$queryConfig.equals(other$queryConfig)) {
            return false;
        }
        Object this$queryEndpoints = this.getQueryEndpoints();
        Object other$queryEndpoints = other.getQueryEndpoints();
        if (this$queryEndpoints == null ? other$queryEndpoints != null : !this$queryEndpoints.equals(other$queryEndpoints)) {
            return false;
        }
        Object this$remoteWrite = this.getRemoteWrite();
        Object other$remoteWrite = other.getRemoteWrite();
        if (this$remoteWrite == null ? other$remoteWrite != null : !this$remoteWrite.equals(other$remoteWrite)) {
            return false;
        }
        Object this$replicas = this.getReplicas();
        Object other$replicas = other.getReplicas();
        if (this$replicas == null ? other$replicas != null : !this$replicas.equals(other$replicas)) {
            return false;
        }
        Object this$resendDelay = this.getResendDelay();
        Object other$resendDelay = other.getResendDelay();
        if (this$resendDelay == null ? other$resendDelay != null : !this$resendDelay.equals(other$resendDelay)) {
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
        Object this$ruleConcurrentEval = this.getRuleConcurrentEval();
        Object other$ruleConcurrentEval = other.getRuleConcurrentEval();
        if (this$ruleConcurrentEval == null ? other$ruleConcurrentEval != null : !this$ruleConcurrentEval.equals(other$ruleConcurrentEval)) {
            return false;
        }
        Object this$ruleGracePeriod = this.getRuleGracePeriod();
        Object other$ruleGracePeriod = other.getRuleGracePeriod();
        if (this$ruleGracePeriod == null ? other$ruleGracePeriod != null : !this$ruleGracePeriod.equals(other$ruleGracePeriod)) {
            return false;
        }
        Object this$ruleNamespaceSelector = this.getRuleNamespaceSelector();
        Object other$ruleNamespaceSelector = other.getRuleNamespaceSelector();
        if (this$ruleNamespaceSelector == null ? other$ruleNamespaceSelector != null : !this$ruleNamespaceSelector.equals(other$ruleNamespaceSelector)) {
            return false;
        }
        Object this$ruleOutageTolerance = this.getRuleOutageTolerance();
        Object other$ruleOutageTolerance = other.getRuleOutageTolerance();
        if (this$ruleOutageTolerance == null ? other$ruleOutageTolerance != null : !this$ruleOutageTolerance.equals(other$ruleOutageTolerance)) {
            return false;
        }
        Object this$ruleQueryOffset = this.getRuleQueryOffset();
        Object other$ruleQueryOffset = other.getRuleQueryOffset();
        if (this$ruleQueryOffset == null ? other$ruleQueryOffset != null : !this$ruleQueryOffset.equals(other$ruleQueryOffset)) {
            return false;
        }
        Object this$ruleSelector = this.getRuleSelector();
        Object other$ruleSelector = other.getRuleSelector();
        if (this$ruleSelector == null ? other$ruleSelector != null : !this$ruleSelector.equals(other$ruleSelector)) {
            return false;
        }
        Object this$schedulerName = this.getSchedulerName();
        Object other$schedulerName = other.getSchedulerName();
        if (this$schedulerName == null ? other$schedulerName != null : !this$schedulerName.equals(other$schedulerName)) {
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
        Object this$storage = this.getStorage();
        Object other$storage = other.getStorage();
        if (this$storage == null ? other$storage != null : !this$storage.equals(other$storage)) {
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
        Object this$tracingConfigFile = this.getTracingConfigFile();
        Object other$tracingConfigFile = other.getTracingConfigFile();
        if (this$tracingConfigFile == null ? other$tracingConfigFile != null : !this$tracingConfigFile.equals(other$tracingConfigFile)) {
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
        return other instanceof ThanosRulerSpec;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $additionalArgs = this.getAdditionalArgs();
        result = result * prime + ($additionalArgs == null ? 43 : $additionalArgs.hashCode());
        Object $affinity = this.getAffinity();
        result = result * prime + ($affinity == null ? 43 : $affinity.hashCode());
        Object $alertDropLabels = this.getAlertDropLabels();
        result = result * prime + ($alertDropLabels == null ? 43 : $alertDropLabels.hashCode());
        Object $alertQueryUrl = this.getAlertQueryUrl();
        result = result * prime + ($alertQueryUrl == null ? 43 : $alertQueryUrl.hashCode());
        Object $alertRelabelConfigFile = this.getAlertRelabelConfigFile();
        result = result * prime + ($alertRelabelConfigFile == null ? 43 : $alertRelabelConfigFile.hashCode());
        Object $alertRelabelConfigs = this.getAlertRelabelConfigs();
        result = result * prime + ($alertRelabelConfigs == null ? 43 : $alertRelabelConfigs.hashCode());
        Object $alertmanagersConfig = this.getAlertmanagersConfig();
        result = result * prime + ($alertmanagersConfig == null ? 43 : $alertmanagersConfig.hashCode());
        Object $alertmanagersUrl = this.getAlertmanagersUrl();
        result = result * prime + ($alertmanagersUrl == null ? 43 : $alertmanagersUrl.hashCode());
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
        Object $enforcedNamespaceLabel = this.getEnforcedNamespaceLabel();
        result = result * prime + ($enforcedNamespaceLabel == null ? 43 : $enforcedNamespaceLabel.hashCode());
        Object $evaluationInterval = this.getEvaluationInterval();
        result = result * prime + ($evaluationInterval == null ? 43 : $evaluationInterval.hashCode());
        Object $excludedFromEnforcement = this.getExcludedFromEnforcement();
        result = result * prime + ($excludedFromEnforcement == null ? 43 : $excludedFromEnforcement.hashCode());
        Object $externalPrefix = this.getExternalPrefix();
        result = result * prime + ($externalPrefix == null ? 43 : $externalPrefix.hashCode());
        Object $grpcServerTlsConfig = this.getGrpcServerTlsConfig();
        result = result * prime + ($grpcServerTlsConfig == null ? 43 : $grpcServerTlsConfig.hashCode());
        Object $hostAliases = this.getHostAliases();
        result = result * prime + ($hostAliases == null ? 43 : $hostAliases.hashCode());
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
        Object $labels = this.getLabels();
        result = result * prime + ($labels == null ? 43 : $labels.hashCode());
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
        Object $objectStorageConfig = this.getObjectStorageConfig();
        result = result * prime + ($objectStorageConfig == null ? 43 : $objectStorageConfig.hashCode());
        Object $objectStorageConfigFile = this.getObjectStorageConfigFile();
        result = result * prime + ($objectStorageConfigFile == null ? 43 : $objectStorageConfigFile.hashCode());
        Object $paused = this.getPaused();
        result = result * prime + ($paused == null ? 43 : $paused.hashCode());
        Object $podManagementPolicy = this.getPodManagementPolicy();
        result = result * prime + ($podManagementPolicy == null ? 43 : $podManagementPolicy.hashCode());
        Object $podMetadata = this.getPodMetadata();
        result = result * prime + ($podMetadata == null ? 43 : $podMetadata.hashCode());
        Object $portName = this.getPortName();
        result = result * prime + ($portName == null ? 43 : $portName.hashCode());
        Object $priorityClassName = this.getPriorityClassName();
        result = result * prime + ($priorityClassName == null ? 43 : $priorityClassName.hashCode());
        Object $prometheusRulesExcludedFromEnforce = this.getPrometheusRulesExcludedFromEnforce();
        result = result * prime + ($prometheusRulesExcludedFromEnforce == null ? 43 : $prometheusRulesExcludedFromEnforce.hashCode());
        Object $queryConfig = this.getQueryConfig();
        result = result * prime + ($queryConfig == null ? 43 : $queryConfig.hashCode());
        Object $queryEndpoints = this.getQueryEndpoints();
        result = result * prime + ($queryEndpoints == null ? 43 : $queryEndpoints.hashCode());
        Object $remoteWrite = this.getRemoteWrite();
        result = result * prime + ($remoteWrite == null ? 43 : $remoteWrite.hashCode());
        Object $replicas = this.getReplicas();
        result = result * prime + ($replicas == null ? 43 : $replicas.hashCode());
        Object $resendDelay = this.getResendDelay();
        result = result * prime + ($resendDelay == null ? 43 : $resendDelay.hashCode());
        Object $resources = this.getResources();
        result = result * prime + ($resources == null ? 43 : $resources.hashCode());
        Object $retention = this.getRetention();
        result = result * prime + ($retention == null ? 43 : $retention.hashCode());
        Object $routePrefix = this.getRoutePrefix();
        result = result * prime + ($routePrefix == null ? 43 : $routePrefix.hashCode());
        Object $ruleConcurrentEval = this.getRuleConcurrentEval();
        result = result * prime + ($ruleConcurrentEval == null ? 43 : $ruleConcurrentEval.hashCode());
        Object $ruleGracePeriod = this.getRuleGracePeriod();
        result = result * prime + ($ruleGracePeriod == null ? 43 : $ruleGracePeriod.hashCode());
        Object $ruleNamespaceSelector = this.getRuleNamespaceSelector();
        result = result * prime + ($ruleNamespaceSelector == null ? 43 : $ruleNamespaceSelector.hashCode());
        Object $ruleOutageTolerance = this.getRuleOutageTolerance();
        result = result * prime + ($ruleOutageTolerance == null ? 43 : $ruleOutageTolerance.hashCode());
        Object $ruleQueryOffset = this.getRuleQueryOffset();
        result = result * prime + ($ruleQueryOffset == null ? 43 : $ruleQueryOffset.hashCode());
        Object $ruleSelector = this.getRuleSelector();
        result = result * prime + ($ruleSelector == null ? 43 : $ruleSelector.hashCode());
        Object $schedulerName = this.getSchedulerName();
        result = result * prime + ($schedulerName == null ? 43 : $schedulerName.hashCode());
        Object $securityContext = this.getSecurityContext();
        result = result * prime + ($securityContext == null ? 43 : $securityContext.hashCode());
        Object $serviceAccountName = this.getServiceAccountName();
        result = result * prime + ($serviceAccountName == null ? 43 : $serviceAccountName.hashCode());
        Object $serviceName = this.getServiceName();
        result = result * prime + ($serviceName == null ? 43 : $serviceName.hashCode());
        Object $storage = this.getStorage();
        result = result * prime + ($storage == null ? 43 : $storage.hashCode());
        Object $terminationGracePeriodSeconds = this.getTerminationGracePeriodSeconds();
        result = result * prime + ($terminationGracePeriodSeconds == null ? 43 : $terminationGracePeriodSeconds.hashCode());
        Object $tolerations = this.getTolerations();
        result = result * prime + ($tolerations == null ? 43 : $tolerations.hashCode());
        Object $topologySpreadConstraints = this.getTopologySpreadConstraints();
        result = result * prime + ($topologySpreadConstraints == null ? 43 : $topologySpreadConstraints.hashCode());
        Object $tracingConfig = this.getTracingConfig();
        result = result * prime + ($tracingConfig == null ? 43 : $tracingConfig.hashCode());
        Object $tracingConfigFile = this.getTracingConfigFile();
        result = result * prime + ($tracingConfigFile == null ? 43 : $tracingConfigFile.hashCode());
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
        return "ThanosRulerSpec(" + "additionalArgs=" + this.getAdditionalArgs() + ", affinity=" + this.getAffinity() + ", alertDropLabels=" + this.getAlertDropLabels() + ", alertQueryUrl=" + this.getAlertQueryUrl() + ", alertRelabelConfigFile=" + this.getAlertRelabelConfigFile() + ", alertRelabelConfigs=" + this.getAlertRelabelConfigs() + ", alertmanagersConfig=" + this.getAlertmanagersConfig() + ", alertmanagersUrl=" + this.getAlertmanagersUrl() + ", containers=" + this.getContainers() + ", dnsConfig=" + this.getDnsConfig() + ", dnsPolicy=" + this.getDnsPolicy() + ", enableFeatures=" + this.getEnableFeatures() + ", enableServiceLinks=" + this.getEnableServiceLinks() + ", enforcedNamespaceLabel=" + this.getEnforcedNamespaceLabel() + ", evaluationInterval=" + this.getEvaluationInterval() + ", excludedFromEnforcement=" + this.getExcludedFromEnforcement() + ", externalPrefix=" + this.getExternalPrefix() + ", grpcServerTlsConfig=" + this.getGrpcServerTlsConfig() + ", hostAliases=" + this.getHostAliases() + ", hostUsers=" + this.getHostUsers() + ", image=" + this.getImage() + ", imagePullPolicy=" + this.getImagePullPolicy() + ", imagePullSecrets=" + this.getImagePullSecrets() + ", initContainers=" + this.getInitContainers() + ", labels=" + this.getLabels() + ", listenLocal=" + this.getListenLocal() + ", logFormat=" + this.getLogFormat() + ", logLevel=" + this.getLogLevel() + ", minReadySeconds=" + this.getMinReadySeconds() + ", nodeSelector=" + this.getNodeSelector() + ", objectStorageConfig=" + this.getObjectStorageConfig() + ", objectStorageConfigFile=" + this.getObjectStorageConfigFile() + ", paused=" + this.getPaused() + ", podManagementPolicy=" + this.getPodManagementPolicy() + ", podMetadata=" + this.getPodMetadata() + ", portName=" + this.getPortName() + ", priorityClassName=" + this.getPriorityClassName() + ", prometheusRulesExcludedFromEnforce=" + this.getPrometheusRulesExcludedFromEnforce() + ", queryConfig=" + this.getQueryConfig() + ", queryEndpoints=" + this.getQueryEndpoints() + ", remoteWrite=" + this.getRemoteWrite() + ", replicas=" + this.getReplicas() + ", resendDelay=" + this.getResendDelay() + ", resources=" + this.getResources() + ", retention=" + this.getRetention() + ", routePrefix=" + this.getRoutePrefix() + ", ruleConcurrentEval=" + this.getRuleConcurrentEval() + ", ruleGracePeriod=" + this.getRuleGracePeriod() + ", ruleNamespaceSelector=" + this.getRuleNamespaceSelector() + ", ruleOutageTolerance=" + this.getRuleOutageTolerance() + ", ruleQueryOffset=" + this.getRuleQueryOffset() + ", ruleSelector=" + this.getRuleSelector() + ", schedulerName=" + this.getSchedulerName() + ", securityContext=" + this.getSecurityContext() + ", serviceAccountName=" + this.getServiceAccountName() + ", serviceName=" + this.getServiceName() + ", storage=" + this.getStorage() + ", terminationGracePeriodSeconds=" + this.getTerminationGracePeriodSeconds() + ", tolerations=" + this.getTolerations() + ", topologySpreadConstraints=" + this.getTopologySpreadConstraints() + ", tracingConfig=" + this.getTracingConfig() + ", tracingConfigFile=" + this.getTracingConfigFile() + ", updateStrategy=" + this.getUpdateStrategy() + ", version=" + this.getVersion() + ", volumeMounts=" + this.getVolumeMounts() + ", volumes=" + this.getVolumes() + ", web=" + this.getWeb() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
