
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
import io.fabric8.kubernetes.api.builder.Editable;
import io.sundr.builder.annotations.Buildable;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
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
@Accessors(prefix = {
    "_",
    ""
})
@Buildable(editableEnabled = false, validationEnabled = false, generateBuilderPackage = false, lazyCollectionInitEnabled = false, builderPackage = "io.fabric8.kubernetes.api.builder")
@Generated("io.fabric8.kubernetes.schema.generator.model.ModelGenerator")
public class PodSpec implements Editable<PodSpecBuilder> , KubernetesResource
{

    @JsonProperty("activeDeadlineSeconds")
    private Long activeDeadlineSeconds;
    @JsonProperty("affinity")
    private Affinity affinity;
    @JsonProperty("automountServiceAccountToken")
    private Boolean automountServiceAccountToken;
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
     * 
     */
    public PodSpec() {
    }

    public PodSpec(Long activeDeadlineSeconds, Affinity affinity, Boolean automountServiceAccountToken, List<Container> containers, PodDNSConfig dnsConfig, String dnsPolicy, Boolean enableServiceLinks, List<EphemeralContainer> ephemeralContainers, List<HostAlias> hostAliases, Boolean hostIPC, Boolean hostNetwork, Boolean hostPID, Boolean hostUsers, String hostname, List<LocalObjectReference> imagePullSecrets, List<Container> initContainers, String nodeName, Map<String, String> nodeSelector, PodOS os, Map<String, Quantity> overhead, String preemptionPolicy, Integer priority, String priorityClassName, List<PodReadinessGate> readinessGates, List<PodResourceClaim> resourceClaims, String restartPolicy, String runtimeClassName, String schedulerName, List<PodSchedulingGate> schedulingGates, PodSecurityContext securityContext, String serviceAccount, String serviceAccountName, Boolean setHostnameAsFQDN, Boolean shareProcessNamespace, String subdomain, Long terminationGracePeriodSeconds, List<Toleration> tolerations, List<TopologySpreadConstraint> topologySpreadConstraints, List<Volume> volumes) {
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

    @JsonProperty("enableServiceLinks")
    public Boolean getEnableServiceLinks() {
        return enableServiceLinks;
    }

    @JsonProperty("enableServiceLinks")
    public void setEnableServiceLinks(Boolean enableServiceLinks) {
        this.enableServiceLinks = enableServiceLinks;
    }

    @JsonProperty("ephemeralContainers")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<EphemeralContainer> getEphemeralContainers() {
        return ephemeralContainers;
    }

    @JsonProperty("ephemeralContainers")
    public void setEphemeralContainers(List<EphemeralContainer> ephemeralContainers) {
        this.ephemeralContainers = ephemeralContainers;
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
    public String getHostname() {
        return hostname;
    }

    @JsonProperty("hostname")
    public void setHostname(String hostname) {
        this.hostname = hostname;
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

    @JsonProperty("nodeName")
    public String getNodeName() {
        return nodeName;
    }

    @JsonProperty("nodeName")
    public void setNodeName(String nodeName) {
        this.nodeName = nodeName;
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

    @JsonProperty("os")
    public PodOS getOs() {
        return os;
    }

    @JsonProperty("os")
    public void setOs(PodOS os) {
        this.os = os;
    }

    @JsonProperty("overhead")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public Map<String, Quantity> getOverhead() {
        return overhead;
    }

    @JsonProperty("overhead")
    public void setOverhead(Map<String, Quantity> overhead) {
        this.overhead = overhead;
    }

    @JsonProperty("preemptionPolicy")
    public String getPreemptionPolicy() {
        return preemptionPolicy;
    }

    @JsonProperty("preemptionPolicy")
    public void setPreemptionPolicy(String preemptionPolicy) {
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
    public String getPriorityClassName() {
        return priorityClassName;
    }

    @JsonProperty("priorityClassName")
    public void setPriorityClassName(String priorityClassName) {
        this.priorityClassName = priorityClassName;
    }

    @JsonProperty("readinessGates")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<PodReadinessGate> getReadinessGates() {
        return readinessGates;
    }

    @JsonProperty("readinessGates")
    public void setReadinessGates(List<PodReadinessGate> readinessGates) {
        this.readinessGates = readinessGates;
    }

    @JsonProperty("resourceClaims")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<PodResourceClaim> getResourceClaims() {
        return resourceClaims;
    }

    @JsonProperty("resourceClaims")
    public void setResourceClaims(List<PodResourceClaim> resourceClaims) {
        this.resourceClaims = resourceClaims;
    }

    @JsonProperty("restartPolicy")
    public String getRestartPolicy() {
        return restartPolicy;
    }

    @JsonProperty("restartPolicy")
    public void setRestartPolicy(String restartPolicy) {
        this.restartPolicy = restartPolicy;
    }

    @JsonProperty("runtimeClassName")
    public String getRuntimeClassName() {
        return runtimeClassName;
    }

    @JsonProperty("runtimeClassName")
    public void setRuntimeClassName(String runtimeClassName) {
        this.runtimeClassName = runtimeClassName;
    }

    @JsonProperty("schedulerName")
    public String getSchedulerName() {
        return schedulerName;
    }

    @JsonProperty("schedulerName")
    public void setSchedulerName(String schedulerName) {
        this.schedulerName = schedulerName;
    }

    @JsonProperty("schedulingGates")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
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
    public String getServiceAccount() {
        return serviceAccount;
    }

    @JsonProperty("serviceAccount")
    public void setServiceAccount(String serviceAccount) {
        this.serviceAccount = serviceAccount;
    }

    @JsonProperty("serviceAccountName")
    public String getServiceAccountName() {
        return serviceAccountName;
    }

    @JsonProperty("serviceAccountName")
    public void setServiceAccountName(String serviceAccountName) {
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
    public String getSubdomain() {
        return subdomain;
    }

    @JsonProperty("subdomain")
    public void setSubdomain(String subdomain) {
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

    @JsonProperty("volumes")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<Volume> getVolumes() {
        return volumes;
    }

    @JsonProperty("volumes")
    public void setVolumes(List<Volume> volumes) {
        this.volumes = volumes;
    }

    @JsonIgnore
    public PodSpecBuilder edit() {
        return new PodSpecBuilder(this);
    }

    @JsonIgnore
    public PodSpecBuilder toBuilder() {
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
