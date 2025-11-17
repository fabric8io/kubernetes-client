
package io.fabric8.knative.serving.v1;

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
import io.fabric8.kubernetes.api.model.EphemeralContainer;
import io.fabric8.kubernetes.api.model.HostAlias;
import io.fabric8.kubernetes.api.model.IntOrString;
import io.fabric8.kubernetes.api.model.KubernetesResource;
import io.fabric8.kubernetes.api.model.LabelSelector;
import io.fabric8.kubernetes.api.model.LocalObjectReference;
import io.fabric8.kubernetes.api.model.ObjectMeta;
import io.fabric8.kubernetes.api.model.ObjectReference;
import io.fabric8.kubernetes.api.model.PersistentVolumeClaim;
import io.fabric8.kubernetes.api.model.PodDNSConfig;
import io.fabric8.kubernetes.api.model.PodOS;
import io.fabric8.kubernetes.api.model.PodReadinessGate;
import io.fabric8.kubernetes.api.model.PodResourceClaim;
import io.fabric8.kubernetes.api.model.PodSchedulingGate;
import io.fabric8.kubernetes.api.model.PodSecurityContext;
import io.fabric8.kubernetes.api.model.PodTemplateSpec;
import io.fabric8.kubernetes.api.model.Quantity;
import io.fabric8.kubernetes.api.model.ResourceRequirements;
import io.fabric8.kubernetes.api.model.Toleration;
import io.fabric8.kubernetes.api.model.TopologySpreadConstraint;
import io.fabric8.kubernetes.api.model.Volume;
import io.fabric8.kubernetes.api.model.VolumeMount;
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * RevisionSpec holds the desired state of the Revision (from the client).
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "activeDeadlineSeconds",
    "affinity",
    "automountServiceAccountToken",
    "containerConcurrency",
    "containers",
    "dnsConfig",
    "dnsPolicy",
    "enableServiceLinks",
    "ephemeralContainers",
    "hostAliases",
    "hostIPC",
    "hostNetwork",
    "hostPID",
    "hostUsers",
    "hostname",
    "hostnameOverride",
    "idleTimeoutSeconds",
    "imagePullSecrets",
    "initContainers",
    "nodeName",
    "nodeSelector",
    "os",
    "overhead",
    "preemptionPolicy",
    "priority",
    "priorityClassName",
    "readinessGates",
    "resourceClaims",
    "resources",
    "responseStartTimeoutSeconds",
    "restartPolicy",
    "runtimeClassName",
    "schedulerName",
    "schedulingGates",
    "securityContext",
    "serviceAccount",
    "serviceAccountName",
    "setHostnameAsFQDN",
    "shareProcessNamespace",
    "subdomain",
    "terminationGracePeriodSeconds",
    "timeoutSeconds",
    "tolerations",
    "topologySpreadConstraints",
    "volumes"
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
public class RevisionSpec implements Editable<RevisionSpecBuilder>, KubernetesResource
{

    @JsonProperty("activeDeadlineSeconds")
    private Long activeDeadlineSeconds;
    @JsonProperty("affinity")
    private Affinity affinity;
    @JsonProperty("automountServiceAccountToken")
    private Boolean automountServiceAccountToken;
    @JsonProperty("containerConcurrency")
    private Long containerConcurrency;
    @JsonProperty("containers")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<Container> containers = new ArrayList<>();
    @JsonProperty("dnsConfig")
    private PodDNSConfig dnsConfig;
    @JsonProperty("dnsPolicy")
    private String dnsPolicy;
    @JsonProperty("enableServiceLinks")
    private Boolean enableServiceLinks;
    @JsonProperty("ephemeralContainers")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<EphemeralContainer> ephemeralContainers = new ArrayList<>();
    @JsonProperty("hostAliases")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<HostAlias> hostAliases = new ArrayList<>();
    @JsonProperty("hostIPC")
    private Boolean hostIPC;
    @JsonProperty("hostNetwork")
    private Boolean hostNetwork;
    @JsonProperty("hostPID")
    private Boolean hostPID;
    @JsonProperty("hostUsers")
    private Boolean hostUsers;
    @JsonProperty("hostname")
    private String hostname;
    @JsonProperty("hostnameOverride")
    private String hostnameOverride;
    @JsonProperty("idleTimeoutSeconds")
    private Long idleTimeoutSeconds;
    @JsonProperty("imagePullSecrets")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<LocalObjectReference> imagePullSecrets = new ArrayList<>();
    @JsonProperty("initContainers")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<Container> initContainers = new ArrayList<>();
    @JsonProperty("nodeName")
    private String nodeName;
    @JsonProperty("nodeSelector")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Map<String, String> nodeSelector = new LinkedHashMap<>();
    @JsonProperty("os")
    private PodOS os;
    @JsonProperty("overhead")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Map<String, Quantity> overhead = new LinkedHashMap<>();
    @JsonProperty("preemptionPolicy")
    private String preemptionPolicy;
    @JsonProperty("priority")
    private Integer priority;
    @JsonProperty("priorityClassName")
    private String priorityClassName;
    @JsonProperty("readinessGates")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<PodReadinessGate> readinessGates = new ArrayList<>();
    @JsonProperty("resourceClaims")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<PodResourceClaim> resourceClaims = new ArrayList<>();
    @JsonProperty("resources")
    private ResourceRequirements resources;
    @JsonProperty("responseStartTimeoutSeconds")
    private Long responseStartTimeoutSeconds;
    @JsonProperty("restartPolicy")
    private String restartPolicy;
    @JsonProperty("runtimeClassName")
    private String runtimeClassName;
    @JsonProperty("schedulerName")
    private String schedulerName;
    @JsonProperty("schedulingGates")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<PodSchedulingGate> schedulingGates = new ArrayList<>();
    @JsonProperty("securityContext")
    private PodSecurityContext securityContext;
    @JsonProperty("serviceAccount")
    private String serviceAccount;
    @JsonProperty("serviceAccountName")
    private String serviceAccountName;
    @JsonProperty("setHostnameAsFQDN")
    private Boolean setHostnameAsFQDN;
    @JsonProperty("shareProcessNamespace")
    private Boolean shareProcessNamespace;
    @JsonProperty("subdomain")
    private String subdomain;
    @JsonProperty("terminationGracePeriodSeconds")
    private Long terminationGracePeriodSeconds;
    @JsonProperty("timeoutSeconds")
    private Long timeoutSeconds;
    @JsonProperty("tolerations")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<Toleration> tolerations = new ArrayList<>();
    @JsonProperty("topologySpreadConstraints")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<TopologySpreadConstraint> topologySpreadConstraints = new ArrayList<>();
    @JsonProperty("volumes")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<Volume> volumes = new ArrayList<>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public RevisionSpec() {
    }

    public RevisionSpec(Long activeDeadlineSeconds, Affinity affinity, Boolean automountServiceAccountToken, Long containerConcurrency, List<Container> containers, PodDNSConfig dnsConfig, String dnsPolicy, Boolean enableServiceLinks, List<EphemeralContainer> ephemeralContainers, List<HostAlias> hostAliases, Boolean hostIPC, Boolean hostNetwork, Boolean hostPID, Boolean hostUsers, String hostname, String hostnameOverride, Long idleTimeoutSeconds, List<LocalObjectReference> imagePullSecrets, List<Container> initContainers, String nodeName, Map<String, String> nodeSelector, PodOS os, Map<String, Quantity> overhead, String preemptionPolicy, Integer priority, String priorityClassName, List<PodReadinessGate> readinessGates, List<PodResourceClaim> resourceClaims, ResourceRequirements resources, Long responseStartTimeoutSeconds, String restartPolicy, String runtimeClassName, String schedulerName, List<PodSchedulingGate> schedulingGates, PodSecurityContext securityContext, String serviceAccount, String serviceAccountName, Boolean setHostnameAsFQDN, Boolean shareProcessNamespace, String subdomain, Long terminationGracePeriodSeconds, Long timeoutSeconds, List<Toleration> tolerations, List<TopologySpreadConstraint> topologySpreadConstraints, List<Volume> volumes) {
        super();
        this.activeDeadlineSeconds = activeDeadlineSeconds;
        this.affinity = affinity;
        this.automountServiceAccountToken = automountServiceAccountToken;
        this.containerConcurrency = containerConcurrency;
        this.containers = containers;
        this.dnsConfig = dnsConfig;
        this.dnsPolicy = dnsPolicy;
        this.enableServiceLinks = enableServiceLinks;
        this.ephemeralContainers = ephemeralContainers;
        this.hostAliases = hostAliases;
        this.hostIPC = hostIPC;
        this.hostNetwork = hostNetwork;
        this.hostPID = hostPID;
        this.hostUsers = hostUsers;
        this.hostname = hostname;
        this.hostnameOverride = hostnameOverride;
        this.idleTimeoutSeconds = idleTimeoutSeconds;
        this.imagePullSecrets = imagePullSecrets;
        this.initContainers = initContainers;
        this.nodeName = nodeName;
        this.nodeSelector = nodeSelector;
        this.os = os;
        this.overhead = overhead;
        this.preemptionPolicy = preemptionPolicy;
        this.priority = priority;
        this.priorityClassName = priorityClassName;
        this.readinessGates = readinessGates;
        this.resourceClaims = resourceClaims;
        this.resources = resources;
        this.responseStartTimeoutSeconds = responseStartTimeoutSeconds;
        this.restartPolicy = restartPolicy;
        this.runtimeClassName = runtimeClassName;
        this.schedulerName = schedulerName;
        this.schedulingGates = schedulingGates;
        this.securityContext = securityContext;
        this.serviceAccount = serviceAccount;
        this.serviceAccountName = serviceAccountName;
        this.setHostnameAsFQDN = setHostnameAsFQDN;
        this.shareProcessNamespace = shareProcessNamespace;
        this.subdomain = subdomain;
        this.terminationGracePeriodSeconds = terminationGracePeriodSeconds;
        this.timeoutSeconds = timeoutSeconds;
        this.tolerations = tolerations;
        this.topologySpreadConstraints = topologySpreadConstraints;
        this.volumes = volumes;
    }

    /**
     * Optional duration in seconds the pod may be active on the node relative to StartTime before the system will actively try to mark it failed and kill associated containers. Value must be a positive integer.
     */
    @JsonProperty("activeDeadlineSeconds")
    public Long getActiveDeadlineSeconds() {
        return activeDeadlineSeconds;
    }

    /**
     * Optional duration in seconds the pod may be active on the node relative to StartTime before the system will actively try to mark it failed and kill associated containers. Value must be a positive integer.
     */
    @JsonProperty("activeDeadlineSeconds")
    public void setActiveDeadlineSeconds(Long activeDeadlineSeconds) {
        this.activeDeadlineSeconds = activeDeadlineSeconds;
    }

    /**
     * RevisionSpec holds the desired state of the Revision (from the client).
     */
    @JsonProperty("affinity")
    public Affinity getAffinity() {
        return affinity;
    }

    /**
     * RevisionSpec holds the desired state of the Revision (from the client).
     */
    @JsonProperty("affinity")
    public void setAffinity(Affinity affinity) {
        this.affinity = affinity;
    }

    /**
     * AutomountServiceAccountToken indicates whether a service account token should be automatically mounted.
     */
    @JsonProperty("automountServiceAccountToken")
    public Boolean getAutomountServiceAccountToken() {
        return automountServiceAccountToken;
    }

    /**
     * AutomountServiceAccountToken indicates whether a service account token should be automatically mounted.
     */
    @JsonProperty("automountServiceAccountToken")
    public void setAutomountServiceAccountToken(Boolean automountServiceAccountToken) {
        this.automountServiceAccountToken = automountServiceAccountToken;
    }

    /**
     * ContainerConcurrency specifies the maximum allowed in-flight (concurrent) requests per container of the Revision.  Defaults to `0` which means concurrency to the application is not limited, and the system decides the target concurrency for the autoscaler.
     */
    @JsonProperty("containerConcurrency")
    public Long getContainerConcurrency() {
        return containerConcurrency;
    }

    /**
     * ContainerConcurrency specifies the maximum allowed in-flight (concurrent) requests per container of the Revision.  Defaults to `0` which means concurrency to the application is not limited, and the system decides the target concurrency for the autoscaler.
     */
    @JsonProperty("containerConcurrency")
    public void setContainerConcurrency(Long containerConcurrency) {
        this.containerConcurrency = containerConcurrency;
    }

    /**
     * List of containers belonging to the pod. Containers cannot currently be added or removed. There must be at least one container in a Pod. Cannot be updated.
     */
    @JsonProperty("containers")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<Container> getContainers() {
        return containers;
    }

    /**
     * List of containers belonging to the pod. Containers cannot currently be added or removed. There must be at least one container in a Pod. Cannot be updated.
     */
    @JsonProperty("containers")
    public void setContainers(List<Container> containers) {
        this.containers = containers;
    }

    /**
     * RevisionSpec holds the desired state of the Revision (from the client).
     */
    @JsonProperty("dnsConfig")
    public PodDNSConfig getDnsConfig() {
        return dnsConfig;
    }

    /**
     * RevisionSpec holds the desired state of the Revision (from the client).
     */
    @JsonProperty("dnsConfig")
    public void setDnsConfig(PodDNSConfig dnsConfig) {
        this.dnsConfig = dnsConfig;
    }

    /**
     * Set DNS policy for the pod. Defaults to "ClusterFirst". Valid values are 'ClusterFirstWithHostNet', 'ClusterFirst', 'Default' or 'None'. DNS parameters given in DNSConfig will be merged with the policy selected with DNSPolicy. To have DNS options set along with hostNetwork, you have to specify DNS policy explicitly to 'ClusterFirstWithHostNet'.
     */
    @JsonProperty("dnsPolicy")
    public String getDnsPolicy() {
        return dnsPolicy;
    }

    /**
     * Set DNS policy for the pod. Defaults to "ClusterFirst". Valid values are 'ClusterFirstWithHostNet', 'ClusterFirst', 'Default' or 'None'. DNS parameters given in DNSConfig will be merged with the policy selected with DNSPolicy. To have DNS options set along with hostNetwork, you have to specify DNS policy explicitly to 'ClusterFirstWithHostNet'.
     */
    @JsonProperty("dnsPolicy")
    public void setDnsPolicy(String dnsPolicy) {
        this.dnsPolicy = dnsPolicy;
    }

    /**
     * EnableServiceLinks indicates whether information about services should be injected into pod's environment variables, matching the syntax of Docker links. Optional: Defaults to true.
     */
    @JsonProperty("enableServiceLinks")
    public Boolean getEnableServiceLinks() {
        return enableServiceLinks;
    }

    /**
     * EnableServiceLinks indicates whether information about services should be injected into pod's environment variables, matching the syntax of Docker links. Optional: Defaults to true.
     */
    @JsonProperty("enableServiceLinks")
    public void setEnableServiceLinks(Boolean enableServiceLinks) {
        this.enableServiceLinks = enableServiceLinks;
    }

    /**
     * List of ephemeral containers run in this pod. Ephemeral containers may be run in an existing pod to perform user-initiated actions such as debugging. This list cannot be specified when creating a pod, and it cannot be modified by updating the pod spec. In order to add an ephemeral container to an existing pod, use the pod's ephemeralcontainers subresource.
     */
    @JsonProperty("ephemeralContainers")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<EphemeralContainer> getEphemeralContainers() {
        return ephemeralContainers;
    }

    /**
     * List of ephemeral containers run in this pod. Ephemeral containers may be run in an existing pod to perform user-initiated actions such as debugging. This list cannot be specified when creating a pod, and it cannot be modified by updating the pod spec. In order to add an ephemeral container to an existing pod, use the pod's ephemeralcontainers subresource.
     */
    @JsonProperty("ephemeralContainers")
    public void setEphemeralContainers(List<EphemeralContainer> ephemeralContainers) {
        this.ephemeralContainers = ephemeralContainers;
    }

    /**
     * HostAliases is an optional list of hosts and IPs that will be injected into the pod's hosts file if specified.
     */
    @JsonProperty("hostAliases")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<HostAlias> getHostAliases() {
        return hostAliases;
    }

    /**
     * HostAliases is an optional list of hosts and IPs that will be injected into the pod's hosts file if specified.
     */
    @JsonProperty("hostAliases")
    public void setHostAliases(List<HostAlias> hostAliases) {
        this.hostAliases = hostAliases;
    }

    /**
     * Use the host's ipc namespace. Optional: Default to false.
     */
    @JsonProperty("hostIPC")
    public Boolean getHostIPC() {
        return hostIPC;
    }

    /**
     * Use the host's ipc namespace. Optional: Default to false.
     */
    @JsonProperty("hostIPC")
    public void setHostIPC(Boolean hostIPC) {
        this.hostIPC = hostIPC;
    }

    /**
     * Host networking requested for this pod. Use the host's network namespace. When using HostNetwork you should specify ports so the scheduler is aware. When `hostNetwork` is true, specified `hostPort` fields in port definitions must match `containerPort`, and unspecified `hostPort` fields in port definitions are defaulted to match `containerPort`. Default to false.
     */
    @JsonProperty("hostNetwork")
    public Boolean getHostNetwork() {
        return hostNetwork;
    }

    /**
     * Host networking requested for this pod. Use the host's network namespace. When using HostNetwork you should specify ports so the scheduler is aware. When `hostNetwork` is true, specified `hostPort` fields in port definitions must match `containerPort`, and unspecified `hostPort` fields in port definitions are defaulted to match `containerPort`. Default to false.
     */
    @JsonProperty("hostNetwork")
    public void setHostNetwork(Boolean hostNetwork) {
        this.hostNetwork = hostNetwork;
    }

    /**
     * Use the host's pid namespace. Optional: Default to false.
     */
    @JsonProperty("hostPID")
    public Boolean getHostPID() {
        return hostPID;
    }

    /**
     * Use the host's pid namespace. Optional: Default to false.
     */
    @JsonProperty("hostPID")
    public void setHostPID(Boolean hostPID) {
        this.hostPID = hostPID;
    }

    /**
     * Use the host's user namespace. Optional: Default to true. If set to true or not present, the pod will be run in the host user namespace, useful for when the pod needs a feature only available to the host user namespace, such as loading a kernel module with CAP_SYS_MODULE. When set to false, a new userns is created for the pod. Setting false is useful for mitigating container breakout vulnerabilities even allowing users to run their containers as root without actually having root privileges on the host. This field is alpha-level and is only honored by servers that enable the UserNamespacesSupport feature.
     */
    @JsonProperty("hostUsers")
    public Boolean getHostUsers() {
        return hostUsers;
    }

    /**
     * Use the host's user namespace. Optional: Default to true. If set to true or not present, the pod will be run in the host user namespace, useful for when the pod needs a feature only available to the host user namespace, such as loading a kernel module with CAP_SYS_MODULE. When set to false, a new userns is created for the pod. Setting false is useful for mitigating container breakout vulnerabilities even allowing users to run their containers as root without actually having root privileges on the host. This field is alpha-level and is only honored by servers that enable the UserNamespacesSupport feature.
     */
    @JsonProperty("hostUsers")
    public void setHostUsers(Boolean hostUsers) {
        this.hostUsers = hostUsers;
    }

    /**
     * Specifies the hostname of the Pod If not specified, the pod's hostname will be set to a system-defined value.
     */
    @JsonProperty("hostname")
    public String getHostname() {
        return hostname;
    }

    /**
     * Specifies the hostname of the Pod If not specified, the pod's hostname will be set to a system-defined value.
     */
    @JsonProperty("hostname")
    public void setHostname(String hostname) {
        this.hostname = hostname;
    }

    /**
     * HostnameOverride specifies an explicit override for the pod's hostname as perceived by the pod. This field only specifies the pod's hostname and does not affect its DNS records. When this field is set to a non-empty string: - It takes precedence over the values set in `hostname` and `subdomain`. - The Pod's hostname will be set to this value. - `setHostnameAsFQDN` must be nil or set to false. - `hostNetwork` must be set to false.<br><p> <br><p> This field must be a valid DNS subdomain as defined in RFC 1123 and contain at most 64 characters. Requires the HostnameOverride feature gate to be enabled.
     */
    @JsonProperty("hostnameOverride")
    public String getHostnameOverride() {
        return hostnameOverride;
    }

    /**
     * HostnameOverride specifies an explicit override for the pod's hostname as perceived by the pod. This field only specifies the pod's hostname and does not affect its DNS records. When this field is set to a non-empty string: - It takes precedence over the values set in `hostname` and `subdomain`. - The Pod's hostname will be set to this value. - `setHostnameAsFQDN` must be nil or set to false. - `hostNetwork` must be set to false.<br><p> <br><p> This field must be a valid DNS subdomain as defined in RFC 1123 and contain at most 64 characters. Requires the HostnameOverride feature gate to be enabled.
     */
    @JsonProperty("hostnameOverride")
    public void setHostnameOverride(String hostnameOverride) {
        this.hostnameOverride = hostnameOverride;
    }

    /**
     * IdleTimeoutSeconds is the maximum duration in seconds a request will be allowed to stay open while not receiving any bytes from the user's application. If unspecified, a system default will be provided.
     */
    @JsonProperty("idleTimeoutSeconds")
    public Long getIdleTimeoutSeconds() {
        return idleTimeoutSeconds;
    }

    /**
     * IdleTimeoutSeconds is the maximum duration in seconds a request will be allowed to stay open while not receiving any bytes from the user's application. If unspecified, a system default will be provided.
     */
    @JsonProperty("idleTimeoutSeconds")
    public void setIdleTimeoutSeconds(Long idleTimeoutSeconds) {
        this.idleTimeoutSeconds = idleTimeoutSeconds;
    }

    /**
     * ImagePullSecrets is an optional list of references to secrets in the same namespace to use for pulling any of the images used by this PodSpec. If specified, these secrets will be passed to individual puller implementations for them to use. More info: https://kubernetes.io/docs/concepts/containers/images#specifying-imagepullsecrets-on-a-pod
     */
    @JsonProperty("imagePullSecrets")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<LocalObjectReference> getImagePullSecrets() {
        return imagePullSecrets;
    }

    /**
     * ImagePullSecrets is an optional list of references to secrets in the same namespace to use for pulling any of the images used by this PodSpec. If specified, these secrets will be passed to individual puller implementations for them to use. More info: https://kubernetes.io/docs/concepts/containers/images#specifying-imagepullsecrets-on-a-pod
     */
    @JsonProperty("imagePullSecrets")
    public void setImagePullSecrets(List<LocalObjectReference> imagePullSecrets) {
        this.imagePullSecrets = imagePullSecrets;
    }

    /**
     * List of initialization containers belonging to the pod. Init containers are executed in order prior to containers being started. If any init container fails, the pod is considered to have failed and is handled according to its restartPolicy. The name for an init container or normal container must be unique among all containers. Init containers may not have Lifecycle actions, Readiness probes, Liveness probes, or Startup probes. The resourceRequirements of an init container are taken into account during scheduling by finding the highest request/limit for each resource type, and then using the max of that value or the sum of the normal containers. Limits are applied to init containers in a similar fashion. Init containers cannot currently be added or removed. Cannot be updated. More info: https://kubernetes.io/docs/concepts/workloads/pods/init-containers/
     */
    @JsonProperty("initContainers")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<Container> getInitContainers() {
        return initContainers;
    }

    /**
     * List of initialization containers belonging to the pod. Init containers are executed in order prior to containers being started. If any init container fails, the pod is considered to have failed and is handled according to its restartPolicy. The name for an init container or normal container must be unique among all containers. Init containers may not have Lifecycle actions, Readiness probes, Liveness probes, or Startup probes. The resourceRequirements of an init container are taken into account during scheduling by finding the highest request/limit for each resource type, and then using the max of that value or the sum of the normal containers. Limits are applied to init containers in a similar fashion. Init containers cannot currently be added or removed. Cannot be updated. More info: https://kubernetes.io/docs/concepts/workloads/pods/init-containers/
     */
    @JsonProperty("initContainers")
    public void setInitContainers(List<Container> initContainers) {
        this.initContainers = initContainers;
    }

    /**
     * NodeName indicates in which node this pod is scheduled. If empty, this pod is a candidate for scheduling by the scheduler defined in schedulerName. Once this field is set, the kubelet for this node becomes responsible for the lifecycle of this pod. This field should not be used to express a desire for the pod to be scheduled on a specific node. https://kubernetes.io/docs/concepts/scheduling-eviction/assign-pod-node/#nodename
     */
    @JsonProperty("nodeName")
    public String getNodeName() {
        return nodeName;
    }

    /**
     * NodeName indicates in which node this pod is scheduled. If empty, this pod is a candidate for scheduling by the scheduler defined in schedulerName. Once this field is set, the kubelet for this node becomes responsible for the lifecycle of this pod. This field should not be used to express a desire for the pod to be scheduled on a specific node. https://kubernetes.io/docs/concepts/scheduling-eviction/assign-pod-node/#nodename
     */
    @JsonProperty("nodeName")
    public void setNodeName(String nodeName) {
        this.nodeName = nodeName;
    }

    /**
     * NodeSelector is a selector which must be true for the pod to fit on a node. Selector which must match a node's labels for the pod to be scheduled on that node. More info: https://kubernetes.io/docs/concepts/configuration/assign-pod-node/
     */
    @JsonProperty("nodeSelector")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public Map<String, String> getNodeSelector() {
        return nodeSelector;
    }

    /**
     * NodeSelector is a selector which must be true for the pod to fit on a node. Selector which must match a node's labels for the pod to be scheduled on that node. More info: https://kubernetes.io/docs/concepts/configuration/assign-pod-node/
     */
    @JsonProperty("nodeSelector")
    public void setNodeSelector(Map<String, String> nodeSelector) {
        this.nodeSelector = nodeSelector;
    }

    /**
     * RevisionSpec holds the desired state of the Revision (from the client).
     */
    @JsonProperty("os")
    public PodOS getOs() {
        return os;
    }

    /**
     * RevisionSpec holds the desired state of the Revision (from the client).
     */
    @JsonProperty("os")
    public void setOs(PodOS os) {
        this.os = os;
    }

    /**
     * Overhead represents the resource overhead associated with running a pod for a given RuntimeClass. This field will be autopopulated at admission time by the RuntimeClass admission controller. If the RuntimeClass admission controller is enabled, overhead must not be set in Pod create requests. The RuntimeClass admission controller will reject Pod create requests which have the overhead already set. If RuntimeClass is configured and selected in the PodSpec, Overhead will be set to the value defined in the corresponding RuntimeClass, otherwise it will remain unset and treated as zero. More info: https://git.k8s.io/enhancements/keps/sig-node/688-pod-overhead/README.md
     */
    @JsonProperty("overhead")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public Map<String, Quantity> getOverhead() {
        return overhead;
    }

    /**
     * Overhead represents the resource overhead associated with running a pod for a given RuntimeClass. This field will be autopopulated at admission time by the RuntimeClass admission controller. If the RuntimeClass admission controller is enabled, overhead must not be set in Pod create requests. The RuntimeClass admission controller will reject Pod create requests which have the overhead already set. If RuntimeClass is configured and selected in the PodSpec, Overhead will be set to the value defined in the corresponding RuntimeClass, otherwise it will remain unset and treated as zero. More info: https://git.k8s.io/enhancements/keps/sig-node/688-pod-overhead/README.md
     */
    @JsonProperty("overhead")
    public void setOverhead(Map<String, Quantity> overhead) {
        this.overhead = overhead;
    }

    /**
     * PreemptionPolicy is the Policy for preempting pods with lower priority. One of Never, PreemptLowerPriority. Defaults to PreemptLowerPriority if unset.
     */
    @JsonProperty("preemptionPolicy")
    public String getPreemptionPolicy() {
        return preemptionPolicy;
    }

    /**
     * PreemptionPolicy is the Policy for preempting pods with lower priority. One of Never, PreemptLowerPriority. Defaults to PreemptLowerPriority if unset.
     */
    @JsonProperty("preemptionPolicy")
    public void setPreemptionPolicy(String preemptionPolicy) {
        this.preemptionPolicy = preemptionPolicy;
    }

    /**
     * The priority value. Various system components use this field to find the priority of the pod. When Priority Admission Controller is enabled, it prevents users from setting this field. The admission controller populates this field from PriorityClassName. The higher the value, the higher the priority.
     */
    @JsonProperty("priority")
    public Integer getPriority() {
        return priority;
    }

    /**
     * The priority value. Various system components use this field to find the priority of the pod. When Priority Admission Controller is enabled, it prevents users from setting this field. The admission controller populates this field from PriorityClassName. The higher the value, the higher the priority.
     */
    @JsonProperty("priority")
    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    /**
     * If specified, indicates the pod's priority. "system-node-critical" and "system-cluster-critical" are two special keywords which indicate the highest priorities with the former being the highest priority. Any other name must be defined by creating a PriorityClass object with that name. If not specified, the pod priority will be default or zero if there is no default.
     */
    @JsonProperty("priorityClassName")
    public String getPriorityClassName() {
        return priorityClassName;
    }

    /**
     * If specified, indicates the pod's priority. "system-node-critical" and "system-cluster-critical" are two special keywords which indicate the highest priorities with the former being the highest priority. Any other name must be defined by creating a PriorityClass object with that name. If not specified, the pod priority will be default or zero if there is no default.
     */
    @JsonProperty("priorityClassName")
    public void setPriorityClassName(String priorityClassName) {
        this.priorityClassName = priorityClassName;
    }

    /**
     * If specified, all readiness gates will be evaluated for pod readiness. A pod is ready when all its containers are ready AND all conditions specified in the readiness gates have status equal to "True" More info: https://git.k8s.io/enhancements/keps/sig-network/580-pod-readiness-gates
     */
    @JsonProperty("readinessGates")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<PodReadinessGate> getReadinessGates() {
        return readinessGates;
    }

    /**
     * If specified, all readiness gates will be evaluated for pod readiness. A pod is ready when all its containers are ready AND all conditions specified in the readiness gates have status equal to "True" More info: https://git.k8s.io/enhancements/keps/sig-network/580-pod-readiness-gates
     */
    @JsonProperty("readinessGates")
    public void setReadinessGates(List<PodReadinessGate> readinessGates) {
        this.readinessGates = readinessGates;
    }

    /**
     * ResourceClaims defines which ResourceClaims must be allocated and reserved before the Pod is allowed to start. The resources will be made available to those containers which consume them by name.<br><p> <br><p> This is an alpha field and requires enabling the DynamicResourceAllocation feature gate.<br><p> <br><p> This field is immutable.
     */
    @JsonProperty("resourceClaims")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<PodResourceClaim> getResourceClaims() {
        return resourceClaims;
    }

    /**
     * ResourceClaims defines which ResourceClaims must be allocated and reserved before the Pod is allowed to start. The resources will be made available to those containers which consume them by name.<br><p> <br><p> This is an alpha field and requires enabling the DynamicResourceAllocation feature gate.<br><p> <br><p> This field is immutable.
     */
    @JsonProperty("resourceClaims")
    public void setResourceClaims(List<PodResourceClaim> resourceClaims) {
        this.resourceClaims = resourceClaims;
    }

    /**
     * RevisionSpec holds the desired state of the Revision (from the client).
     */
    @JsonProperty("resources")
    public ResourceRequirements getResources() {
        return resources;
    }

    /**
     * RevisionSpec holds the desired state of the Revision (from the client).
     */
    @JsonProperty("resources")
    public void setResources(ResourceRequirements resources) {
        this.resources = resources;
    }

    /**
     * ResponseStartTimeoutSeconds is the maximum duration in seconds that the request routing layer will wait for a request delivered to a container to begin sending any network traffic.
     */
    @JsonProperty("responseStartTimeoutSeconds")
    public Long getResponseStartTimeoutSeconds() {
        return responseStartTimeoutSeconds;
    }

    /**
     * ResponseStartTimeoutSeconds is the maximum duration in seconds that the request routing layer will wait for a request delivered to a container to begin sending any network traffic.
     */
    @JsonProperty("responseStartTimeoutSeconds")
    public void setResponseStartTimeoutSeconds(Long responseStartTimeoutSeconds) {
        this.responseStartTimeoutSeconds = responseStartTimeoutSeconds;
    }

    /**
     * Restart policy for all containers within the pod. One of Always, OnFailure, Never. In some contexts, only a subset of those values may be permitted. Default to Always. More info: https://kubernetes.io/docs/concepts/workloads/pods/pod-lifecycle/#restart-policy
     */
    @JsonProperty("restartPolicy")
    public String getRestartPolicy() {
        return restartPolicy;
    }

    /**
     * Restart policy for all containers within the pod. One of Always, OnFailure, Never. In some contexts, only a subset of those values may be permitted. Default to Always. More info: https://kubernetes.io/docs/concepts/workloads/pods/pod-lifecycle/#restart-policy
     */
    @JsonProperty("restartPolicy")
    public void setRestartPolicy(String restartPolicy) {
        this.restartPolicy = restartPolicy;
    }

    /**
     * RuntimeClassName refers to a RuntimeClass object in the node.k8s.io group, which should be used to run this pod.  If no RuntimeClass resource matches the named class, the pod will not be run. If unset or empty, the "legacy" RuntimeClass will be used, which is an implicit class with an empty definition that uses the default runtime handler. More info: https://git.k8s.io/enhancements/keps/sig-node/585-runtime-class
     */
    @JsonProperty("runtimeClassName")
    public String getRuntimeClassName() {
        return runtimeClassName;
    }

    /**
     * RuntimeClassName refers to a RuntimeClass object in the node.k8s.io group, which should be used to run this pod.  If no RuntimeClass resource matches the named class, the pod will not be run. If unset or empty, the "legacy" RuntimeClass will be used, which is an implicit class with an empty definition that uses the default runtime handler. More info: https://git.k8s.io/enhancements/keps/sig-node/585-runtime-class
     */
    @JsonProperty("runtimeClassName")
    public void setRuntimeClassName(String runtimeClassName) {
        this.runtimeClassName = runtimeClassName;
    }

    /**
     * If specified, the pod will be dispatched by specified scheduler. If not specified, the pod will be dispatched by default scheduler.
     */
    @JsonProperty("schedulerName")
    public String getSchedulerName() {
        return schedulerName;
    }

    /**
     * If specified, the pod will be dispatched by specified scheduler. If not specified, the pod will be dispatched by default scheduler.
     */
    @JsonProperty("schedulerName")
    public void setSchedulerName(String schedulerName) {
        this.schedulerName = schedulerName;
    }

    /**
     * SchedulingGates is an opaque list of values that if specified will block scheduling the pod. If schedulingGates is not empty, the pod will stay in the SchedulingGated state and the scheduler will not attempt to schedule the pod.<br><p> <br><p> SchedulingGates can only be set at pod creation time, and be removed only afterwards.
     */
    @JsonProperty("schedulingGates")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<PodSchedulingGate> getSchedulingGates() {
        return schedulingGates;
    }

    /**
     * SchedulingGates is an opaque list of values that if specified will block scheduling the pod. If schedulingGates is not empty, the pod will stay in the SchedulingGated state and the scheduler will not attempt to schedule the pod.<br><p> <br><p> SchedulingGates can only be set at pod creation time, and be removed only afterwards.
     */
    @JsonProperty("schedulingGates")
    public void setSchedulingGates(List<PodSchedulingGate> schedulingGates) {
        this.schedulingGates = schedulingGates;
    }

    /**
     * RevisionSpec holds the desired state of the Revision (from the client).
     */
    @JsonProperty("securityContext")
    public PodSecurityContext getSecurityContext() {
        return securityContext;
    }

    /**
     * RevisionSpec holds the desired state of the Revision (from the client).
     */
    @JsonProperty("securityContext")
    public void setSecurityContext(PodSecurityContext securityContext) {
        this.securityContext = securityContext;
    }

    /**
     * DeprecatedServiceAccount is a deprecated alias for ServiceAccountName. Deprecated: Use serviceAccountName instead.
     */
    @JsonProperty("serviceAccount")
    public String getServiceAccount() {
        return serviceAccount;
    }

    /**
     * DeprecatedServiceAccount is a deprecated alias for ServiceAccountName. Deprecated: Use serviceAccountName instead.
     */
    @JsonProperty("serviceAccount")
    public void setServiceAccount(String serviceAccount) {
        this.serviceAccount = serviceAccount;
    }

    /**
     * ServiceAccountName is the name of the ServiceAccount to use to run this pod. More info: https://kubernetes.io/docs/tasks/configure-pod-container/configure-service-account/
     */
    @JsonProperty("serviceAccountName")
    public String getServiceAccountName() {
        return serviceAccountName;
    }

    /**
     * ServiceAccountName is the name of the ServiceAccount to use to run this pod. More info: https://kubernetes.io/docs/tasks/configure-pod-container/configure-service-account/
     */
    @JsonProperty("serviceAccountName")
    public void setServiceAccountName(String serviceAccountName) {
        this.serviceAccountName = serviceAccountName;
    }

    /**
     * If true the pod's hostname will be configured as the pod's FQDN, rather than the leaf name (the default). In Linux containers, this means setting the FQDN in the hostname field of the kernel (the nodename field of struct utsname). In Windows containers, this means setting the registry value of hostname for the registry key HKEY_LOCAL_MACHINE\\SYSTEM\\CurrentControlSet\\Services\\Tcpip\\Parameters to FQDN. If a pod does not have FQDN, this has no effect. Default to false.
     */
    @JsonProperty("setHostnameAsFQDN")
    public Boolean getSetHostnameAsFQDN() {
        return setHostnameAsFQDN;
    }

    /**
     * If true the pod's hostname will be configured as the pod's FQDN, rather than the leaf name (the default). In Linux containers, this means setting the FQDN in the hostname field of the kernel (the nodename field of struct utsname). In Windows containers, this means setting the registry value of hostname for the registry key HKEY_LOCAL_MACHINE\\SYSTEM\\CurrentControlSet\\Services\\Tcpip\\Parameters to FQDN. If a pod does not have FQDN, this has no effect. Default to false.
     */
    @JsonProperty("setHostnameAsFQDN")
    public void setSetHostnameAsFQDN(Boolean setHostnameAsFQDN) {
        this.setHostnameAsFQDN = setHostnameAsFQDN;
    }

    /**
     * Share a single process namespace between all of the containers in a pod. When this is set containers will be able to view and signal processes from other containers in the same pod, and the first process in each container will not be assigned PID 1. HostPID and ShareProcessNamespace cannot both be set. Optional: Default to false.
     */
    @JsonProperty("shareProcessNamespace")
    public Boolean getShareProcessNamespace() {
        return shareProcessNamespace;
    }

    /**
     * Share a single process namespace between all of the containers in a pod. When this is set containers will be able to view and signal processes from other containers in the same pod, and the first process in each container will not be assigned PID 1. HostPID and ShareProcessNamespace cannot both be set. Optional: Default to false.
     */
    @JsonProperty("shareProcessNamespace")
    public void setShareProcessNamespace(Boolean shareProcessNamespace) {
        this.shareProcessNamespace = shareProcessNamespace;
    }

    /**
     * If specified, the fully qualified Pod hostname will be "&lt;hostname&gt;.&lt;subdomain&gt;.&lt;pod namespace&gt;.svc.&lt;cluster domain&gt;". If not specified, the pod will not have a domainname at all.
     */
    @JsonProperty("subdomain")
    public String getSubdomain() {
        return subdomain;
    }

    /**
     * If specified, the fully qualified Pod hostname will be "&lt;hostname&gt;.&lt;subdomain&gt;.&lt;pod namespace&gt;.svc.&lt;cluster domain&gt;". If not specified, the pod will not have a domainname at all.
     */
    @JsonProperty("subdomain")
    public void setSubdomain(String subdomain) {
        this.subdomain = subdomain;
    }

    /**
     * Optional duration in seconds the pod needs to terminate gracefully. May be decreased in delete request. Value must be non-negative integer. The value zero indicates stop immediately via the kill signal (no opportunity to shut down). If this value is nil, the default grace period will be used instead. The grace period is the duration in seconds after the processes running in the pod are sent a termination signal and the time when the processes are forcibly halted with a kill signal. Set this value longer than the expected cleanup time for your process. Defaults to 30 seconds.
     */
    @JsonProperty("terminationGracePeriodSeconds")
    public Long getTerminationGracePeriodSeconds() {
        return terminationGracePeriodSeconds;
    }

    /**
     * Optional duration in seconds the pod needs to terminate gracefully. May be decreased in delete request. Value must be non-negative integer. The value zero indicates stop immediately via the kill signal (no opportunity to shut down). If this value is nil, the default grace period will be used instead. The grace period is the duration in seconds after the processes running in the pod are sent a termination signal and the time when the processes are forcibly halted with a kill signal. Set this value longer than the expected cleanup time for your process. Defaults to 30 seconds.
     */
    @JsonProperty("terminationGracePeriodSeconds")
    public void setTerminationGracePeriodSeconds(Long terminationGracePeriodSeconds) {
        this.terminationGracePeriodSeconds = terminationGracePeriodSeconds;
    }

    /**
     * TimeoutSeconds is the maximum duration in seconds that the request instance is allowed to respond to a request. If unspecified, a system default will be provided.
     */
    @JsonProperty("timeoutSeconds")
    public Long getTimeoutSeconds() {
        return timeoutSeconds;
    }

    /**
     * TimeoutSeconds is the maximum duration in seconds that the request instance is allowed to respond to a request. If unspecified, a system default will be provided.
     */
    @JsonProperty("timeoutSeconds")
    public void setTimeoutSeconds(Long timeoutSeconds) {
        this.timeoutSeconds = timeoutSeconds;
    }

    /**
     * If specified, the pod's tolerations.
     */
    @JsonProperty("tolerations")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<Toleration> getTolerations() {
        return tolerations;
    }

    /**
     * If specified, the pod's tolerations.
     */
    @JsonProperty("tolerations")
    public void setTolerations(List<Toleration> tolerations) {
        this.tolerations = tolerations;
    }

    /**
     * TopologySpreadConstraints describes how a group of pods ought to spread across topology domains. Scheduler will schedule pods in a way which abides by the constraints. All topologySpreadConstraints are ANDed.
     */
    @JsonProperty("topologySpreadConstraints")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<TopologySpreadConstraint> getTopologySpreadConstraints() {
        return topologySpreadConstraints;
    }

    /**
     * TopologySpreadConstraints describes how a group of pods ought to spread across topology domains. Scheduler will schedule pods in a way which abides by the constraints. All topologySpreadConstraints are ANDed.
     */
    @JsonProperty("topologySpreadConstraints")
    public void setTopologySpreadConstraints(List<TopologySpreadConstraint> topologySpreadConstraints) {
        this.topologySpreadConstraints = topologySpreadConstraints;
    }

    /**
     * List of volumes that can be mounted by containers belonging to the pod. More info: https://kubernetes.io/docs/concepts/storage/volumes
     */
    @JsonProperty("volumes")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<Volume> getVolumes() {
        return volumes;
    }

    /**
     * List of volumes that can be mounted by containers belonging to the pod. More info: https://kubernetes.io/docs/concepts/storage/volumes
     */
    @JsonProperty("volumes")
    public void setVolumes(List<Volume> volumes) {
        this.volumes = volumes;
    }

    @JsonIgnore
    public RevisionSpecBuilder edit() {
        return new RevisionSpecBuilder(this);
    }

    @JsonIgnore
    public RevisionSpecBuilder toBuilder() {
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
