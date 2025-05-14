
package io.fabric8.kubernetes.api.model.extensions;

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
import io.fabric8.kubernetes.api.model.PodTemplateSpec;
import io.fabric8.kubernetes.api.model.ResourceRequirements;
import io.fabric8.kubernetes.api.model.Volume;
import io.fabric8.kubernetes.api.model.VolumeMount;
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * PodSecurityPolicySpec defines the policy enforced. Deprecated: use PodSecurityPolicySpec from policy API Group instead.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "allowPrivilegeEscalation",
    "allowedCSIDrivers",
    "allowedCapabilities",
    "allowedFlexVolumes",
    "allowedHostPaths",
    "allowedProcMountTypes",
    "allowedUnsafeSysctls",
    "defaultAddCapabilities",
    "defaultAllowPrivilegeEscalation",
    "forbiddenSysctls",
    "fsGroup",
    "hostIPC",
    "hostNetwork",
    "hostPID",
    "hostPorts",
    "privileged",
    "readOnlyRootFilesystem",
    "requiredDropCapabilities",
    "runAsGroup",
    "runAsUser",
    "runtimeClass",
    "seLinux",
    "supplementalGroups",
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
public class PodSecurityPolicySpec implements Editable<PodSecurityPolicySpecBuilder>, KubernetesResource
{

    @JsonProperty("allowPrivilegeEscalation")
    private Boolean allowPrivilegeEscalation;
    @JsonProperty("allowedCSIDrivers")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<AllowedCSIDriver> allowedCSIDrivers = new ArrayList<>();
    @JsonProperty("allowedCapabilities")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> allowedCapabilities = new ArrayList<>();
    @JsonProperty("allowedFlexVolumes")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<AllowedFlexVolume> allowedFlexVolumes = new ArrayList<>();
    @JsonProperty("allowedHostPaths")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<AllowedHostPath> allowedHostPaths = new ArrayList<>();
    @JsonProperty("allowedProcMountTypes")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> allowedProcMountTypes = new ArrayList<>();
    @JsonProperty("allowedUnsafeSysctls")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> allowedUnsafeSysctls = new ArrayList<>();
    @JsonProperty("defaultAddCapabilities")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> defaultAddCapabilities = new ArrayList<>();
    @JsonProperty("defaultAllowPrivilegeEscalation")
    private Boolean defaultAllowPrivilegeEscalation;
    @JsonProperty("forbiddenSysctls")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> forbiddenSysctls = new ArrayList<>();
    @JsonProperty("fsGroup")
    private FSGroupStrategyOptions fsGroup;
    @JsonProperty("hostIPC")
    private Boolean hostIPC;
    @JsonProperty("hostNetwork")
    private Boolean hostNetwork;
    @JsonProperty("hostPID")
    private Boolean hostPID;
    @JsonProperty("hostPorts")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<HostPortRange> hostPorts = new ArrayList<>();
    @JsonProperty("privileged")
    private Boolean privileged;
    @JsonProperty("readOnlyRootFilesystem")
    private Boolean readOnlyRootFilesystem;
    @JsonProperty("requiredDropCapabilities")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> requiredDropCapabilities = new ArrayList<>();
    @JsonProperty("runAsGroup")
    private RunAsGroupStrategyOptions runAsGroup;
    @JsonProperty("runAsUser")
    private RunAsUserStrategyOptions runAsUser;
    @JsonProperty("runtimeClass")
    private RuntimeClassStrategyOptions runtimeClass;
    @JsonProperty("seLinux")
    private SELinuxStrategyOptions seLinux;
    @JsonProperty("supplementalGroups")
    private SupplementalGroupsStrategyOptions supplementalGroups;
    @JsonProperty("volumes")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> volumes = new ArrayList<>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public PodSecurityPolicySpec() {
    }

    public PodSecurityPolicySpec(Boolean allowPrivilegeEscalation, List<AllowedCSIDriver> allowedCSIDrivers, List<String> allowedCapabilities, List<AllowedFlexVolume> allowedFlexVolumes, List<AllowedHostPath> allowedHostPaths, List<String> allowedProcMountTypes, List<String> allowedUnsafeSysctls, List<String> defaultAddCapabilities, Boolean defaultAllowPrivilegeEscalation, List<String> forbiddenSysctls, FSGroupStrategyOptions fsGroup, Boolean hostIPC, Boolean hostNetwork, Boolean hostPID, List<HostPortRange> hostPorts, Boolean privileged, Boolean readOnlyRootFilesystem, List<String> requiredDropCapabilities, RunAsGroupStrategyOptions runAsGroup, RunAsUserStrategyOptions runAsUser, RuntimeClassStrategyOptions runtimeClass, SELinuxStrategyOptions seLinux, SupplementalGroupsStrategyOptions supplementalGroups, List<String> volumes) {
        super();
        this.allowPrivilegeEscalation = allowPrivilegeEscalation;
        this.allowedCSIDrivers = allowedCSIDrivers;
        this.allowedCapabilities = allowedCapabilities;
        this.allowedFlexVolumes = allowedFlexVolumes;
        this.allowedHostPaths = allowedHostPaths;
        this.allowedProcMountTypes = allowedProcMountTypes;
        this.allowedUnsafeSysctls = allowedUnsafeSysctls;
        this.defaultAddCapabilities = defaultAddCapabilities;
        this.defaultAllowPrivilegeEscalation = defaultAllowPrivilegeEscalation;
        this.forbiddenSysctls = forbiddenSysctls;
        this.fsGroup = fsGroup;
        this.hostIPC = hostIPC;
        this.hostNetwork = hostNetwork;
        this.hostPID = hostPID;
        this.hostPorts = hostPorts;
        this.privileged = privileged;
        this.readOnlyRootFilesystem = readOnlyRootFilesystem;
        this.requiredDropCapabilities = requiredDropCapabilities;
        this.runAsGroup = runAsGroup;
        this.runAsUser = runAsUser;
        this.runtimeClass = runtimeClass;
        this.seLinux = seLinux;
        this.supplementalGroups = supplementalGroups;
        this.volumes = volumes;
    }

    /**
     * allowPrivilegeEscalation determines if a pod can request to allow privilege escalation. If unspecified, defaults to true.
     */
    @JsonProperty("allowPrivilegeEscalation")
    public Boolean getAllowPrivilegeEscalation() {
        return allowPrivilegeEscalation;
    }

    /**
     * allowPrivilegeEscalation determines if a pod can request to allow privilege escalation. If unspecified, defaults to true.
     */
    @JsonProperty("allowPrivilegeEscalation")
    public void setAllowPrivilegeEscalation(Boolean allowPrivilegeEscalation) {
        this.allowPrivilegeEscalation = allowPrivilegeEscalation;
    }

    /**
     * AllowedCSIDrivers is a whitelist of inline CSI drivers that must be explicitly set to be embedded within a pod spec. An empty value indicates that any CSI driver can be used for inline ephemeral volumes.
     */
    @JsonProperty("allowedCSIDrivers")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<AllowedCSIDriver> getAllowedCSIDrivers() {
        return allowedCSIDrivers;
    }

    /**
     * AllowedCSIDrivers is a whitelist of inline CSI drivers that must be explicitly set to be embedded within a pod spec. An empty value indicates that any CSI driver can be used for inline ephemeral volumes.
     */
    @JsonProperty("allowedCSIDrivers")
    public void setAllowedCSIDrivers(List<AllowedCSIDriver> allowedCSIDrivers) {
        this.allowedCSIDrivers = allowedCSIDrivers;
    }

    /**
     * allowedCapabilities is a list of capabilities that can be requested to add to the container. Capabilities in this field may be added at the pod author's discretion. You must not list a capability in both allowedCapabilities and requiredDropCapabilities.
     */
    @JsonProperty("allowedCapabilities")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getAllowedCapabilities() {
        return allowedCapabilities;
    }

    /**
     * allowedCapabilities is a list of capabilities that can be requested to add to the container. Capabilities in this field may be added at the pod author's discretion. You must not list a capability in both allowedCapabilities and requiredDropCapabilities.
     */
    @JsonProperty("allowedCapabilities")
    public void setAllowedCapabilities(List<String> allowedCapabilities) {
        this.allowedCapabilities = allowedCapabilities;
    }

    /**
     * allowedFlexVolumes is a whitelist of allowed Flexvolumes.  Empty or nil indicates that all Flexvolumes may be used.  This parameter is effective only when the usage of the Flexvolumes is allowed in the "volumes" field.
     */
    @JsonProperty("allowedFlexVolumes")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<AllowedFlexVolume> getAllowedFlexVolumes() {
        return allowedFlexVolumes;
    }

    /**
     * allowedFlexVolumes is a whitelist of allowed Flexvolumes.  Empty or nil indicates that all Flexvolumes may be used.  This parameter is effective only when the usage of the Flexvolumes is allowed in the "volumes" field.
     */
    @JsonProperty("allowedFlexVolumes")
    public void setAllowedFlexVolumes(List<AllowedFlexVolume> allowedFlexVolumes) {
        this.allowedFlexVolumes = allowedFlexVolumes;
    }

    /**
     * allowedHostPaths is a white list of allowed host paths. Empty indicates that all host paths may be used.
     */
    @JsonProperty("allowedHostPaths")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<AllowedHostPath> getAllowedHostPaths() {
        return allowedHostPaths;
    }

    /**
     * allowedHostPaths is a white list of allowed host paths. Empty indicates that all host paths may be used.
     */
    @JsonProperty("allowedHostPaths")
    public void setAllowedHostPaths(List<AllowedHostPath> allowedHostPaths) {
        this.allowedHostPaths = allowedHostPaths;
    }

    /**
     * AllowedProcMountTypes is a whitelist of allowed ProcMountTypes. Empty or nil indicates that only the DefaultProcMountType may be used. This requires the ProcMountType feature flag to be enabled.
     */
    @JsonProperty("allowedProcMountTypes")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getAllowedProcMountTypes() {
        return allowedProcMountTypes;
    }

    /**
     * AllowedProcMountTypes is a whitelist of allowed ProcMountTypes. Empty or nil indicates that only the DefaultProcMountType may be used. This requires the ProcMountType feature flag to be enabled.
     */
    @JsonProperty("allowedProcMountTypes")
    public void setAllowedProcMountTypes(List<String> allowedProcMountTypes) {
        this.allowedProcMountTypes = allowedProcMountTypes;
    }

    /**
     * allowedUnsafeSysctls is a list of explicitly allowed unsafe sysctls, defaults to none. Each entry is either a plain sysctl name or ends in "&#42;" in which case it is considered as a prefix of allowed sysctls. Single &#42; means all unsafe sysctls are allowed. Kubelet has to whitelist all allowed unsafe sysctls explicitly to avoid rejection.<br><p> <br><p> Examples: e.g. "foo/&#42;" allows "foo/bar", "foo/baz", etc. e.g. "foo.&#42;" allows "foo.bar", "foo.baz", etc.
     */
    @JsonProperty("allowedUnsafeSysctls")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getAllowedUnsafeSysctls() {
        return allowedUnsafeSysctls;
    }

    /**
     * allowedUnsafeSysctls is a list of explicitly allowed unsafe sysctls, defaults to none. Each entry is either a plain sysctl name or ends in "&#42;" in which case it is considered as a prefix of allowed sysctls. Single &#42; means all unsafe sysctls are allowed. Kubelet has to whitelist all allowed unsafe sysctls explicitly to avoid rejection.<br><p> <br><p> Examples: e.g. "foo/&#42;" allows "foo/bar", "foo/baz", etc. e.g. "foo.&#42;" allows "foo.bar", "foo.baz", etc.
     */
    @JsonProperty("allowedUnsafeSysctls")
    public void setAllowedUnsafeSysctls(List<String> allowedUnsafeSysctls) {
        this.allowedUnsafeSysctls = allowedUnsafeSysctls;
    }

    /**
     * defaultAddCapabilities is the default set of capabilities that will be added to the container unless the pod spec specifically drops the capability.  You may not list a capability in both defaultAddCapabilities and requiredDropCapabilities. Capabilities added here are implicitly allowed, and need not be included in the allowedCapabilities list.
     */
    @JsonProperty("defaultAddCapabilities")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getDefaultAddCapabilities() {
        return defaultAddCapabilities;
    }

    /**
     * defaultAddCapabilities is the default set of capabilities that will be added to the container unless the pod spec specifically drops the capability.  You may not list a capability in both defaultAddCapabilities and requiredDropCapabilities. Capabilities added here are implicitly allowed, and need not be included in the allowedCapabilities list.
     */
    @JsonProperty("defaultAddCapabilities")
    public void setDefaultAddCapabilities(List<String> defaultAddCapabilities) {
        this.defaultAddCapabilities = defaultAddCapabilities;
    }

    /**
     * defaultAllowPrivilegeEscalation controls the default setting for whether a process can gain more privileges than its parent process.
     */
    @JsonProperty("defaultAllowPrivilegeEscalation")
    public Boolean getDefaultAllowPrivilegeEscalation() {
        return defaultAllowPrivilegeEscalation;
    }

    /**
     * defaultAllowPrivilegeEscalation controls the default setting for whether a process can gain more privileges than its parent process.
     */
    @JsonProperty("defaultAllowPrivilegeEscalation")
    public void setDefaultAllowPrivilegeEscalation(Boolean defaultAllowPrivilegeEscalation) {
        this.defaultAllowPrivilegeEscalation = defaultAllowPrivilegeEscalation;
    }

    /**
     * forbiddenSysctls is a list of explicitly forbidden sysctls, defaults to none. Each entry is either a plain sysctl name or ends in "&#42;" in which case it is considered as a prefix of forbidden sysctls. Single &#42; means all sysctls are forbidden.<br><p> <br><p> Examples: e.g. "foo/&#42;" forbids "foo/bar", "foo/baz", etc. e.g. "foo.&#42;" forbids "foo.bar", "foo.baz", etc.
     */
    @JsonProperty("forbiddenSysctls")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getForbiddenSysctls() {
        return forbiddenSysctls;
    }

    /**
     * forbiddenSysctls is a list of explicitly forbidden sysctls, defaults to none. Each entry is either a plain sysctl name or ends in "&#42;" in which case it is considered as a prefix of forbidden sysctls. Single &#42; means all sysctls are forbidden.<br><p> <br><p> Examples: e.g. "foo/&#42;" forbids "foo/bar", "foo/baz", etc. e.g. "foo.&#42;" forbids "foo.bar", "foo.baz", etc.
     */
    @JsonProperty("forbiddenSysctls")
    public void setForbiddenSysctls(List<String> forbiddenSysctls) {
        this.forbiddenSysctls = forbiddenSysctls;
    }

    /**
     * PodSecurityPolicySpec defines the policy enforced. Deprecated: use PodSecurityPolicySpec from policy API Group instead.
     */
    @JsonProperty("fsGroup")
    public FSGroupStrategyOptions getFsGroup() {
        return fsGroup;
    }

    /**
     * PodSecurityPolicySpec defines the policy enforced. Deprecated: use PodSecurityPolicySpec from policy API Group instead.
     */
    @JsonProperty("fsGroup")
    public void setFsGroup(FSGroupStrategyOptions fsGroup) {
        this.fsGroup = fsGroup;
    }

    /**
     * hostIPC determines if the policy allows the use of HostIPC in the pod spec.
     */
    @JsonProperty("hostIPC")
    public Boolean getHostIPC() {
        return hostIPC;
    }

    /**
     * hostIPC determines if the policy allows the use of HostIPC in the pod spec.
     */
    @JsonProperty("hostIPC")
    public void setHostIPC(Boolean hostIPC) {
        this.hostIPC = hostIPC;
    }

    /**
     * hostNetwork determines if the policy allows the use of HostNetwork in the pod spec.
     */
    @JsonProperty("hostNetwork")
    public Boolean getHostNetwork() {
        return hostNetwork;
    }

    /**
     * hostNetwork determines if the policy allows the use of HostNetwork in the pod spec.
     */
    @JsonProperty("hostNetwork")
    public void setHostNetwork(Boolean hostNetwork) {
        this.hostNetwork = hostNetwork;
    }

    /**
     * hostPID determines if the policy allows the use of HostPID in the pod spec.
     */
    @JsonProperty("hostPID")
    public Boolean getHostPID() {
        return hostPID;
    }

    /**
     * hostPID determines if the policy allows the use of HostPID in the pod spec.
     */
    @JsonProperty("hostPID")
    public void setHostPID(Boolean hostPID) {
        this.hostPID = hostPID;
    }

    /**
     * hostPorts determines which host port ranges are allowed to be exposed.
     */
    @JsonProperty("hostPorts")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<HostPortRange> getHostPorts() {
        return hostPorts;
    }

    /**
     * hostPorts determines which host port ranges are allowed to be exposed.
     */
    @JsonProperty("hostPorts")
    public void setHostPorts(List<HostPortRange> hostPorts) {
        this.hostPorts = hostPorts;
    }

    /**
     * privileged determines if a pod can request to be run as privileged.
     */
    @JsonProperty("privileged")
    public Boolean getPrivileged() {
        return privileged;
    }

    /**
     * privileged determines if a pod can request to be run as privileged.
     */
    @JsonProperty("privileged")
    public void setPrivileged(Boolean privileged) {
        this.privileged = privileged;
    }

    /**
     * readOnlyRootFilesystem when set to true will force containers to run with a read only root file system.  If the container specifically requests to run with a non-read only root file system the PSP should deny the pod. If set to false the container may run with a read only root file system if it wishes but it will not be forced to.
     */
    @JsonProperty("readOnlyRootFilesystem")
    public Boolean getReadOnlyRootFilesystem() {
        return readOnlyRootFilesystem;
    }

    /**
     * readOnlyRootFilesystem when set to true will force containers to run with a read only root file system.  If the container specifically requests to run with a non-read only root file system the PSP should deny the pod. If set to false the container may run with a read only root file system if it wishes but it will not be forced to.
     */
    @JsonProperty("readOnlyRootFilesystem")
    public void setReadOnlyRootFilesystem(Boolean readOnlyRootFilesystem) {
        this.readOnlyRootFilesystem = readOnlyRootFilesystem;
    }

    /**
     * requiredDropCapabilities are the capabilities that will be dropped from the container.  These are required to be dropped and cannot be added.
     */
    @JsonProperty("requiredDropCapabilities")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getRequiredDropCapabilities() {
        return requiredDropCapabilities;
    }

    /**
     * requiredDropCapabilities are the capabilities that will be dropped from the container.  These are required to be dropped and cannot be added.
     */
    @JsonProperty("requiredDropCapabilities")
    public void setRequiredDropCapabilities(List<String> requiredDropCapabilities) {
        this.requiredDropCapabilities = requiredDropCapabilities;
    }

    /**
     * PodSecurityPolicySpec defines the policy enforced. Deprecated: use PodSecurityPolicySpec from policy API Group instead.
     */
    @JsonProperty("runAsGroup")
    public RunAsGroupStrategyOptions getRunAsGroup() {
        return runAsGroup;
    }

    /**
     * PodSecurityPolicySpec defines the policy enforced. Deprecated: use PodSecurityPolicySpec from policy API Group instead.
     */
    @JsonProperty("runAsGroup")
    public void setRunAsGroup(RunAsGroupStrategyOptions runAsGroup) {
        this.runAsGroup = runAsGroup;
    }

    /**
     * PodSecurityPolicySpec defines the policy enforced. Deprecated: use PodSecurityPolicySpec from policy API Group instead.
     */
    @JsonProperty("runAsUser")
    public RunAsUserStrategyOptions getRunAsUser() {
        return runAsUser;
    }

    /**
     * PodSecurityPolicySpec defines the policy enforced. Deprecated: use PodSecurityPolicySpec from policy API Group instead.
     */
    @JsonProperty("runAsUser")
    public void setRunAsUser(RunAsUserStrategyOptions runAsUser) {
        this.runAsUser = runAsUser;
    }

    /**
     * PodSecurityPolicySpec defines the policy enforced. Deprecated: use PodSecurityPolicySpec from policy API Group instead.
     */
    @JsonProperty("runtimeClass")
    public RuntimeClassStrategyOptions getRuntimeClass() {
        return runtimeClass;
    }

    /**
     * PodSecurityPolicySpec defines the policy enforced. Deprecated: use PodSecurityPolicySpec from policy API Group instead.
     */
    @JsonProperty("runtimeClass")
    public void setRuntimeClass(RuntimeClassStrategyOptions runtimeClass) {
        this.runtimeClass = runtimeClass;
    }

    /**
     * PodSecurityPolicySpec defines the policy enforced. Deprecated: use PodSecurityPolicySpec from policy API Group instead.
     */
    @JsonProperty("seLinux")
    public SELinuxStrategyOptions getSeLinux() {
        return seLinux;
    }

    /**
     * PodSecurityPolicySpec defines the policy enforced. Deprecated: use PodSecurityPolicySpec from policy API Group instead.
     */
    @JsonProperty("seLinux")
    public void setSeLinux(SELinuxStrategyOptions seLinux) {
        this.seLinux = seLinux;
    }

    /**
     * PodSecurityPolicySpec defines the policy enforced. Deprecated: use PodSecurityPolicySpec from policy API Group instead.
     */
    @JsonProperty("supplementalGroups")
    public SupplementalGroupsStrategyOptions getSupplementalGroups() {
        return supplementalGroups;
    }

    /**
     * PodSecurityPolicySpec defines the policy enforced. Deprecated: use PodSecurityPolicySpec from policy API Group instead.
     */
    @JsonProperty("supplementalGroups")
    public void setSupplementalGroups(SupplementalGroupsStrategyOptions supplementalGroups) {
        this.supplementalGroups = supplementalGroups;
    }

    /**
     * volumes is a white list of allowed volume plugins. Empty indicates that no volumes may be used. To allow all volumes you may use '&#42;'.
     */
    @JsonProperty("volumes")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getVolumes() {
        return volumes;
    }

    /**
     * volumes is a white list of allowed volume plugins. Empty indicates that no volumes may be used. To allow all volumes you may use '&#42;'.
     */
    @JsonProperty("volumes")
    public void setVolumes(List<String> volumes) {
        this.volumes = volumes;
    }

    @JsonIgnore
    public PodSecurityPolicySpecBuilder edit() {
        return new PodSecurityPolicySpecBuilder(this);
    }

    @JsonIgnore
    public PodSecurityPolicySpecBuilder toBuilder() {
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
