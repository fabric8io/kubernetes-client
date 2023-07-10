
package io.fabric8.kubernetes.api.model;

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
import io.sundr.builder.annotations.Buildable;
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
    "activeDeadlineSeconds",
    "affinity",
    "automountServiceAccountToken",
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
    "tolerations",
    "topologySpreadConstraints",
    "volumes"
})
@ToString
@EqualsAndHashCode
@Setter
@Accessors(prefix = {
    "_",
    ""
})
@Buildable(editableEnabled = false, validationEnabled = false, generateBuilderPackage = true, lazyCollectionInitEnabled = false, builderPackage = "io.fabric8.kubernetes.api.builder")
@Generated("jsonschema2pojo")
public class PodSpec implements KubernetesResource
{

    @JsonProperty("activeDeadlineSeconds")
    private Long activeDeadlineSeconds;
    @JsonProperty("affinity")
    private Affinity affinity;
    @JsonProperty("automountServiceAccountToken")
    private Boolean automountServiceAccountToken;
    @JsonProperty("containers")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<Container> containers = new ArrayList<Container>();
    @JsonProperty("dnsConfig")
    private PodDNSConfig dnsConfig;
    @JsonProperty("dnsPolicy")
    private java.lang.String dnsPolicy;
    @JsonProperty("enableServiceLinks")
    private Boolean enableServiceLinks;
    @JsonProperty("ephemeralContainers")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<EphemeralContainer> ephemeralContainers = new ArrayList<EphemeralContainer>();
    @JsonProperty("hostAliases")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<HostAlias> hostAliases = new ArrayList<HostAlias>();
    @JsonProperty("hostIPC")
    private Boolean hostIPC;
    @JsonProperty("hostNetwork")
    private Boolean hostNetwork;
    @JsonProperty("hostPID")
    private Boolean hostPID;
    @JsonProperty("hostUsers")
    private Boolean hostUsers;
    @JsonProperty("hostname")
    private java.lang.String hostname;
    @JsonProperty("imagePullSecrets")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<LocalObjectReference> imagePullSecrets = new ArrayList<LocalObjectReference>();
    @JsonProperty("initContainers")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<Container> initContainers = new ArrayList<Container>();
    @JsonProperty("nodeName")
    private java.lang.String nodeName;
    @JsonProperty("nodeSelector")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Map<String, String> nodeSelector = new LinkedHashMap<String, String>();
    @JsonProperty("os")
    private PodOS os;
    @JsonProperty("overhead")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Map<String, Quantity> overhead = new LinkedHashMap<String, Quantity>();
    @JsonProperty("preemptionPolicy")
    private java.lang.String preemptionPolicy;
    @JsonProperty("priority")
    private Integer priority;
    @JsonProperty("priorityClassName")
    private java.lang.String priorityClassName;
    @JsonProperty("readinessGates")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<PodReadinessGate> readinessGates = new ArrayList<PodReadinessGate>();
    @JsonProperty("resourceClaims")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<PodResourceClaim> resourceClaims = new ArrayList<PodResourceClaim>();
    @JsonProperty("restartPolicy")
    private java.lang.String restartPolicy;
    @JsonProperty("runtimeClassName")
    private java.lang.String runtimeClassName;
    @JsonProperty("schedulerName")
    private java.lang.String schedulerName;
    @JsonProperty("schedulingGates")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<PodSchedulingGate> schedulingGates = new ArrayList<PodSchedulingGate>();
    @JsonProperty("securityContext")
    private PodSecurityContext securityContext;
    @JsonProperty("serviceAccount")
    private java.lang.String serviceAccount;
    @JsonProperty("serviceAccountName")
    private java.lang.String serviceAccountName;
    @JsonProperty("setHostnameAsFQDN")
    private Boolean setHostnameAsFQDN;
    @JsonProperty("shareProcessNamespace")
    private Boolean shareProcessNamespace;
    @JsonProperty("subdomain")
    private java.lang.String subdomain;
    @JsonProperty("terminationGracePeriodSeconds")
    private Long terminationGracePeriodSeconds;
    @JsonProperty("tolerations")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<Toleration> tolerations = new ArrayList<Toleration>();
    @JsonProperty("topologySpreadConstraints")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<TopologySpreadConstraint> topologySpreadConstraints = new ArrayList<TopologySpreadConstraint>();
    @JsonProperty("volumes")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<Volume> volumes = new ArrayList<Volume>();
    @JsonIgnore
    private Map<java.lang.String, Object> additionalProperties = new LinkedHashMap<java.lang.String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public PodSpec() {
    }

    public PodSpec(Long activeDeadlineSeconds, Affinity affinity, Boolean automountServiceAccountToken, List<Container> containers, PodDNSConfig dnsConfig, java.lang.String dnsPolicy, Boolean enableServiceLinks, List<EphemeralContainer> ephemeralContainers, List<HostAlias> hostAliases, Boolean hostIPC, Boolean hostNetwork, Boolean hostPID, Boolean hostUsers, java.lang.String hostname, List<LocalObjectReference> imagePullSecrets, List<Container> initContainers, java.lang.String nodeName, Map<String, String> nodeSelector, PodOS os, Map<String, Quantity> overhead, java.lang.String preemptionPolicy, Integer priority, java.lang.String priorityClassName, List<PodReadinessGate> readinessGates, List<PodResourceClaim> resourceClaims, java.lang.String restartPolicy, java.lang.String runtimeClassName, java.lang.String schedulerName, List<PodSchedulingGate> schedulingGates, PodSecurityContext securityContext, java.lang.String serviceAccount, java.lang.String serviceAccountName, Boolean setHostnameAsFQDN, Boolean shareProcessNamespace, java.lang.String subdomain, Long terminationGracePeriodSeconds, List<Toleration> tolerations, List<TopologySpreadConstraint> topologySpreadConstraints, List<Volume> volumes) {
        super();
        this.activeDeadlineSeconds = activeDeadlineSeconds;
        this.affinity = affinity;
        this.automountServiceAccountToken = automountServiceAccountToken;
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
        this.tolerations = tolerations;
        this.topologySpreadConstraints = topologySpreadConstraints;
        this.volumes = volumes;
    }

    @JsonProperty("activeDeadlineSeconds")
    public Long getActiveDeadlineSeconds() {
        return activeDeadlineSeconds;
    }

    @JsonProperty("activeDeadlineSeconds")
    public void setActiveDeadlineSeconds(Long activeDeadlineSeconds) {
        this.activeDeadlineSeconds = activeDeadlineSeconds;
    }

    @JsonProperty("affinity")
    public Affinity getAffinity() {
        return affinity;
    }

    @JsonProperty("affinity")
    public void setAffinity(Affinity affinity) {
        this.affinity = affinity;
    }

    @JsonProperty("automountServiceAccountToken")
    public Boolean getAutomountServiceAccountToken() {
        return automountServiceAccountToken;
    }

    @JsonProperty("automountServiceAccountToken")
    public void setAutomountServiceAccountToken(Boolean automountServiceAccountToken) {
        this.automountServiceAccountToken = automountServiceAccountToken;
    }

    @JsonProperty("containers")
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
    public java.lang.String getDnsPolicy() {
        return dnsPolicy;
    }

    @JsonProperty("dnsPolicy")
    public void setDnsPolicy(java.lang.String dnsPolicy) {
        this.dnsPolicy = dnsPolicy;
    }

    @JsonProperty("enableServiceLinks")
    public Boolean getEnableServiceLinks() {
        return enableServiceLinks;
    }

    @JsonProperty("enableServiceLinks")
    public void setEnableServiceLinks(Boolean enableServiceLinks) {
        this.enableServiceLinks = enableServiceLinks;
    }

    @JsonProperty("ephemeralContainers")
    public List<EphemeralContainer> getEphemeralContainers() {
        return ephemeralContainers;
    }

    @JsonProperty("ephemeralContainers")
    public void setEphemeralContainers(List<EphemeralContainer> ephemeralContainers) {
        this.ephemeralContainers = ephemeralContainers;
    }

    @JsonProperty("hostAliases")
    public List<HostAlias> getHostAliases() {
        return hostAliases;
    }

    @JsonProperty("hostAliases")
    public void setHostAliases(List<HostAlias> hostAliases) {
        this.hostAliases = hostAliases;
    }

    @JsonProperty("hostIPC")
    public Boolean getHostIPC() {
        return hostIPC;
    }

    @JsonProperty("hostIPC")
    public void setHostIPC(Boolean hostIPC) {
        this.hostIPC = hostIPC;
    }

    @JsonProperty("hostNetwork")
    public Boolean getHostNetwork() {
        return hostNetwork;
    }

    @JsonProperty("hostNetwork")
    public void setHostNetwork(Boolean hostNetwork) {
        this.hostNetwork = hostNetwork;
    }

    @JsonProperty("hostPID")
    public Boolean getHostPID() {
        return hostPID;
    }

    @JsonProperty("hostPID")
    public void setHostPID(Boolean hostPID) {
        this.hostPID = hostPID;
    }

    @JsonProperty("hostUsers")
    public Boolean getHostUsers() {
        return hostUsers;
    }

    @JsonProperty("hostUsers")
    public void setHostUsers(Boolean hostUsers) {
        this.hostUsers = hostUsers;
    }

    @JsonProperty("hostname")
    public java.lang.String getHostname() {
        return hostname;
    }

    @JsonProperty("hostname")
    public void setHostname(java.lang.String hostname) {
        this.hostname = hostname;
    }

    @JsonProperty("imagePullSecrets")
    public List<LocalObjectReference> getImagePullSecrets() {
        return imagePullSecrets;
    }

    @JsonProperty("imagePullSecrets")
    public void setImagePullSecrets(List<LocalObjectReference> imagePullSecrets) {
        this.imagePullSecrets = imagePullSecrets;
    }

    @JsonProperty("initContainers")
    public List<Container> getInitContainers() {
        return initContainers;
    }

    @JsonProperty("initContainers")
    public void setInitContainers(List<Container> initContainers) {
        this.initContainers = initContainers;
    }

    @JsonProperty("nodeName")
    public java.lang.String getNodeName() {
        return nodeName;
    }

    @JsonProperty("nodeName")
    public void setNodeName(java.lang.String nodeName) {
        this.nodeName = nodeName;
    }

    @JsonProperty("nodeSelector")
    public Map<String, String> getNodeSelector() {
        return nodeSelector;
    }

    @JsonProperty("nodeSelector")
    public void setNodeSelector(Map<String, String> nodeSelector) {
        this.nodeSelector = nodeSelector;
    }

    @JsonProperty("os")
    public PodOS getOs() {
        return os;
    }

    @JsonProperty("os")
    public void setOs(PodOS os) {
        this.os = os;
    }

    @JsonProperty("overhead")
    public Map<String, Quantity> getOverhead() {
        return overhead;
    }

    @JsonProperty("overhead")
    public void setOverhead(Map<String, Quantity> overhead) {
        this.overhead = overhead;
    }

    @JsonProperty("preemptionPolicy")
    public java.lang.String getPreemptionPolicy() {
        return preemptionPolicy;
    }

    @JsonProperty("preemptionPolicy")
    public void setPreemptionPolicy(java.lang.String preemptionPolicy) {
        this.preemptionPolicy = preemptionPolicy;
    }

    @JsonProperty("priority")
    public Integer getPriority() {
        return priority;
    }

    @JsonProperty("priority")
    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    @JsonProperty("priorityClassName")
    public java.lang.String getPriorityClassName() {
        return priorityClassName;
    }

    @JsonProperty("priorityClassName")
    public void setPriorityClassName(java.lang.String priorityClassName) {
        this.priorityClassName = priorityClassName;
    }

    @JsonProperty("readinessGates")
    public List<PodReadinessGate> getReadinessGates() {
        return readinessGates;
    }

    @JsonProperty("readinessGates")
    public void setReadinessGates(List<PodReadinessGate> readinessGates) {
        this.readinessGates = readinessGates;
    }

    @JsonProperty("resourceClaims")
    public List<PodResourceClaim> getResourceClaims() {
        return resourceClaims;
    }

    @JsonProperty("resourceClaims")
    public void setResourceClaims(List<PodResourceClaim> resourceClaims) {
        this.resourceClaims = resourceClaims;
    }

    @JsonProperty("restartPolicy")
    public java.lang.String getRestartPolicy() {
        return restartPolicy;
    }

    @JsonProperty("restartPolicy")
    public void setRestartPolicy(java.lang.String restartPolicy) {
        this.restartPolicy = restartPolicy;
    }

    @JsonProperty("runtimeClassName")
    public java.lang.String getRuntimeClassName() {
        return runtimeClassName;
    }

    @JsonProperty("runtimeClassName")
    public void setRuntimeClassName(java.lang.String runtimeClassName) {
        this.runtimeClassName = runtimeClassName;
    }

    @JsonProperty("schedulerName")
    public java.lang.String getSchedulerName() {
        return schedulerName;
    }

    @JsonProperty("schedulerName")
    public void setSchedulerName(java.lang.String schedulerName) {
        this.schedulerName = schedulerName;
    }

    @JsonProperty("schedulingGates")
    public List<PodSchedulingGate> getSchedulingGates() {
        return schedulingGates;
    }

    @JsonProperty("schedulingGates")
    public void setSchedulingGates(List<PodSchedulingGate> schedulingGates) {
        this.schedulingGates = schedulingGates;
    }

    @JsonProperty("securityContext")
    public PodSecurityContext getSecurityContext() {
        return securityContext;
    }

    @JsonProperty("securityContext")
    public void setSecurityContext(PodSecurityContext securityContext) {
        this.securityContext = securityContext;
    }

    @JsonProperty("serviceAccount")
    public java.lang.String getServiceAccount() {
        return serviceAccount;
    }

    @JsonProperty("serviceAccount")
    public void setServiceAccount(java.lang.String serviceAccount) {
        this.serviceAccount = serviceAccount;
    }

    @JsonProperty("serviceAccountName")
    public java.lang.String getServiceAccountName() {
        return serviceAccountName;
    }

    @JsonProperty("serviceAccountName")
    public void setServiceAccountName(java.lang.String serviceAccountName) {
        this.serviceAccountName = serviceAccountName;
    }

    @JsonProperty("setHostnameAsFQDN")
    public Boolean getSetHostnameAsFQDN() {
        return setHostnameAsFQDN;
    }

    @JsonProperty("setHostnameAsFQDN")
    public void setSetHostnameAsFQDN(Boolean setHostnameAsFQDN) {
        this.setHostnameAsFQDN = setHostnameAsFQDN;
    }

    @JsonProperty("shareProcessNamespace")
    public Boolean getShareProcessNamespace() {
        return shareProcessNamespace;
    }

    @JsonProperty("shareProcessNamespace")
    public void setShareProcessNamespace(Boolean shareProcessNamespace) {
        this.shareProcessNamespace = shareProcessNamespace;
    }

    @JsonProperty("subdomain")
    public java.lang.String getSubdomain() {
        return subdomain;
    }

    @JsonProperty("subdomain")
    public void setSubdomain(java.lang.String subdomain) {
        this.subdomain = subdomain;
    }

    @JsonProperty("terminationGracePeriodSeconds")
    public Long getTerminationGracePeriodSeconds() {
        return terminationGracePeriodSeconds;
    }

    @JsonProperty("terminationGracePeriodSeconds")
    public void setTerminationGracePeriodSeconds(Long terminationGracePeriodSeconds) {
        this.terminationGracePeriodSeconds = terminationGracePeriodSeconds;
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

    @JsonProperty("volumes")
    public List<Volume> getVolumes() {
        return volumes;
    }

    @JsonProperty("volumes")
    public void setVolumes(List<Volume> volumes) {
        this.volumes = volumes;
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
