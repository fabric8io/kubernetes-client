
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
    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof PodSecurityPolicySpec)) {
            return false;
        }
        PodSecurityPolicySpec other = (PodSecurityPolicySpec) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$allowPrivilegeEscalation = this.getAllowPrivilegeEscalation();
        Object other$allowPrivilegeEscalation = other.getAllowPrivilegeEscalation();
        if (this$allowPrivilegeEscalation == null ? other$allowPrivilegeEscalation != null : !this$allowPrivilegeEscalation.equals(other$allowPrivilegeEscalation)) {
            return false;
        }
        Object this$allowedCSIDrivers = this.getAllowedCSIDrivers();
        Object other$allowedCSIDrivers = other.getAllowedCSIDrivers();
        if (this$allowedCSIDrivers == null ? other$allowedCSIDrivers != null : !this$allowedCSIDrivers.equals(other$allowedCSIDrivers)) {
            return false;
        }
        Object this$allowedCapabilities = this.getAllowedCapabilities();
        Object other$allowedCapabilities = other.getAllowedCapabilities();
        if (this$allowedCapabilities == null ? other$allowedCapabilities != null : !this$allowedCapabilities.equals(other$allowedCapabilities)) {
            return false;
        }
        Object this$allowedFlexVolumes = this.getAllowedFlexVolumes();
        Object other$allowedFlexVolumes = other.getAllowedFlexVolumes();
        if (this$allowedFlexVolumes == null ? other$allowedFlexVolumes != null : !this$allowedFlexVolumes.equals(other$allowedFlexVolumes)) {
            return false;
        }
        Object this$allowedHostPaths = this.getAllowedHostPaths();
        Object other$allowedHostPaths = other.getAllowedHostPaths();
        if (this$allowedHostPaths == null ? other$allowedHostPaths != null : !this$allowedHostPaths.equals(other$allowedHostPaths)) {
            return false;
        }
        Object this$allowedProcMountTypes = this.getAllowedProcMountTypes();
        Object other$allowedProcMountTypes = other.getAllowedProcMountTypes();
        if (this$allowedProcMountTypes == null ? other$allowedProcMountTypes != null : !this$allowedProcMountTypes.equals(other$allowedProcMountTypes)) {
            return false;
        }
        Object this$allowedUnsafeSysctls = this.getAllowedUnsafeSysctls();
        Object other$allowedUnsafeSysctls = other.getAllowedUnsafeSysctls();
        if (this$allowedUnsafeSysctls == null ? other$allowedUnsafeSysctls != null : !this$allowedUnsafeSysctls.equals(other$allowedUnsafeSysctls)) {
            return false;
        }
        Object this$defaultAddCapabilities = this.getDefaultAddCapabilities();
        Object other$defaultAddCapabilities = other.getDefaultAddCapabilities();
        if (this$defaultAddCapabilities == null ? other$defaultAddCapabilities != null : !this$defaultAddCapabilities.equals(other$defaultAddCapabilities)) {
            return false;
        }
        Object this$defaultAllowPrivilegeEscalation = this.getDefaultAllowPrivilegeEscalation();
        Object other$defaultAllowPrivilegeEscalation = other.getDefaultAllowPrivilegeEscalation();
        if (this$defaultAllowPrivilegeEscalation == null ? other$defaultAllowPrivilegeEscalation != null : !this$defaultAllowPrivilegeEscalation.equals(other$defaultAllowPrivilegeEscalation)) {
            return false;
        }
        Object this$forbiddenSysctls = this.getForbiddenSysctls();
        Object other$forbiddenSysctls = other.getForbiddenSysctls();
        if (this$forbiddenSysctls == null ? other$forbiddenSysctls != null : !this$forbiddenSysctls.equals(other$forbiddenSysctls)) {
            return false;
        }
        Object this$fsGroup = this.getFsGroup();
        Object other$fsGroup = other.getFsGroup();
        if (this$fsGroup == null ? other$fsGroup != null : !this$fsGroup.equals(other$fsGroup)) {
            return false;
        }
        Object this$hostIPC = this.getHostIPC();
        Object other$hostIPC = other.getHostIPC();
        if (this$hostIPC == null ? other$hostIPC != null : !this$hostIPC.equals(other$hostIPC)) {
            return false;
        }
        Object this$hostNetwork = this.getHostNetwork();
        Object other$hostNetwork = other.getHostNetwork();
        if (this$hostNetwork == null ? other$hostNetwork != null : !this$hostNetwork.equals(other$hostNetwork)) {
            return false;
        }
        Object this$hostPID = this.getHostPID();
        Object other$hostPID = other.getHostPID();
        if (this$hostPID == null ? other$hostPID != null : !this$hostPID.equals(other$hostPID)) {
            return false;
        }
        Object this$hostPorts = this.getHostPorts();
        Object other$hostPorts = other.getHostPorts();
        if (this$hostPorts == null ? other$hostPorts != null : !this$hostPorts.equals(other$hostPorts)) {
            return false;
        }
        Object this$privileged = this.getPrivileged();
        Object other$privileged = other.getPrivileged();
        if (this$privileged == null ? other$privileged != null : !this$privileged.equals(other$privileged)) {
            return false;
        }
        Object this$readOnlyRootFilesystem = this.getReadOnlyRootFilesystem();
        Object other$readOnlyRootFilesystem = other.getReadOnlyRootFilesystem();
        if (this$readOnlyRootFilesystem == null ? other$readOnlyRootFilesystem != null : !this$readOnlyRootFilesystem.equals(other$readOnlyRootFilesystem)) {
            return false;
        }
        Object this$requiredDropCapabilities = this.getRequiredDropCapabilities();
        Object other$requiredDropCapabilities = other.getRequiredDropCapabilities();
        if (this$requiredDropCapabilities == null ? other$requiredDropCapabilities != null : !this$requiredDropCapabilities.equals(other$requiredDropCapabilities)) {
            return false;
        }
        Object this$runAsGroup = this.getRunAsGroup();
        Object other$runAsGroup = other.getRunAsGroup();
        if (this$runAsGroup == null ? other$runAsGroup != null : !this$runAsGroup.equals(other$runAsGroup)) {
            return false;
        }
        Object this$runAsUser = this.getRunAsUser();
        Object other$runAsUser = other.getRunAsUser();
        if (this$runAsUser == null ? other$runAsUser != null : !this$runAsUser.equals(other$runAsUser)) {
            return false;
        }
        Object this$runtimeClass = this.getRuntimeClass();
        Object other$runtimeClass = other.getRuntimeClass();
        if (this$runtimeClass == null ? other$runtimeClass != null : !this$runtimeClass.equals(other$runtimeClass)) {
            return false;
        }
        Object this$seLinux = this.getSeLinux();
        Object other$seLinux = other.getSeLinux();
        if (this$seLinux == null ? other$seLinux != null : !this$seLinux.equals(other$seLinux)) {
            return false;
        }
        Object this$supplementalGroups = this.getSupplementalGroups();
        Object other$supplementalGroups = other.getSupplementalGroups();
        if (this$supplementalGroups == null ? other$supplementalGroups != null : !this$supplementalGroups.equals(other$supplementalGroups)) {
            return false;
        }
        Object this$volumes = this.getVolumes();
        Object other$volumes = other.getVolumes();
        if (this$volumes == null ? other$volumes != null : !this$volumes.equals(other$volumes)) {
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
        return other instanceof PodSecurityPolicySpec;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $allowPrivilegeEscalation = this.getAllowPrivilegeEscalation();
        result = result * prime + ($allowPrivilegeEscalation == null ? 43 : $allowPrivilegeEscalation.hashCode());
        Object $allowedCSIDrivers = this.getAllowedCSIDrivers();
        result = result * prime + ($allowedCSIDrivers == null ? 43 : $allowedCSIDrivers.hashCode());
        Object $allowedCapabilities = this.getAllowedCapabilities();
        result = result * prime + ($allowedCapabilities == null ? 43 : $allowedCapabilities.hashCode());
        Object $allowedFlexVolumes = this.getAllowedFlexVolumes();
        result = result * prime + ($allowedFlexVolumes == null ? 43 : $allowedFlexVolumes.hashCode());
        Object $allowedHostPaths = this.getAllowedHostPaths();
        result = result * prime + ($allowedHostPaths == null ? 43 : $allowedHostPaths.hashCode());
        Object $allowedProcMountTypes = this.getAllowedProcMountTypes();
        result = result * prime + ($allowedProcMountTypes == null ? 43 : $allowedProcMountTypes.hashCode());
        Object $allowedUnsafeSysctls = this.getAllowedUnsafeSysctls();
        result = result * prime + ($allowedUnsafeSysctls == null ? 43 : $allowedUnsafeSysctls.hashCode());
        Object $defaultAddCapabilities = this.getDefaultAddCapabilities();
        result = result * prime + ($defaultAddCapabilities == null ? 43 : $defaultAddCapabilities.hashCode());
        Object $defaultAllowPrivilegeEscalation = this.getDefaultAllowPrivilegeEscalation();
        result = result * prime + ($defaultAllowPrivilegeEscalation == null ? 43 : $defaultAllowPrivilegeEscalation.hashCode());
        Object $forbiddenSysctls = this.getForbiddenSysctls();
        result = result * prime + ($forbiddenSysctls == null ? 43 : $forbiddenSysctls.hashCode());
        Object $fsGroup = this.getFsGroup();
        result = result * prime + ($fsGroup == null ? 43 : $fsGroup.hashCode());
        Object $hostIPC = this.getHostIPC();
        result = result * prime + ($hostIPC == null ? 43 : $hostIPC.hashCode());
        Object $hostNetwork = this.getHostNetwork();
        result = result * prime + ($hostNetwork == null ? 43 : $hostNetwork.hashCode());
        Object $hostPID = this.getHostPID();
        result = result * prime + ($hostPID == null ? 43 : $hostPID.hashCode());
        Object $hostPorts = this.getHostPorts();
        result = result * prime + ($hostPorts == null ? 43 : $hostPorts.hashCode());
        Object $privileged = this.getPrivileged();
        result = result * prime + ($privileged == null ? 43 : $privileged.hashCode());
        Object $readOnlyRootFilesystem = this.getReadOnlyRootFilesystem();
        result = result * prime + ($readOnlyRootFilesystem == null ? 43 : $readOnlyRootFilesystem.hashCode());
        Object $requiredDropCapabilities = this.getRequiredDropCapabilities();
        result = result * prime + ($requiredDropCapabilities == null ? 43 : $requiredDropCapabilities.hashCode());
        Object $runAsGroup = this.getRunAsGroup();
        result = result * prime + ($runAsGroup == null ? 43 : $runAsGroup.hashCode());
        Object $runAsUser = this.getRunAsUser();
        result = result * prime + ($runAsUser == null ? 43 : $runAsUser.hashCode());
        Object $runtimeClass = this.getRuntimeClass();
        result = result * prime + ($runtimeClass == null ? 43 : $runtimeClass.hashCode());
        Object $seLinux = this.getSeLinux();
        result = result * prime + ($seLinux == null ? 43 : $seLinux.hashCode());
        Object $supplementalGroups = this.getSupplementalGroups();
        result = result * prime + ($supplementalGroups == null ? 43 : $supplementalGroups.hashCode());
        Object $volumes = this.getVolumes();
        result = result * prime + ($volumes == null ? 43 : $volumes.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "PodSecurityPolicySpec(" + "allowPrivilegeEscalation=" + this.getAllowPrivilegeEscalation() + ", allowedCSIDrivers=" + this.getAllowedCSIDrivers() + ", allowedCapabilities=" + this.getAllowedCapabilities() + ", allowedFlexVolumes=" + this.getAllowedFlexVolumes() + ", allowedHostPaths=" + this.getAllowedHostPaths() + ", allowedProcMountTypes=" + this.getAllowedProcMountTypes() + ", allowedUnsafeSysctls=" + this.getAllowedUnsafeSysctls() + ", defaultAddCapabilities=" + this.getDefaultAddCapabilities() + ", defaultAllowPrivilegeEscalation=" + this.getDefaultAllowPrivilegeEscalation() + ", forbiddenSysctls=" + this.getForbiddenSysctls() + ", fsGroup=" + this.getFsGroup() + ", hostIPC=" + this.getHostIPC() + ", hostNetwork=" + this.getHostNetwork() + ", hostPID=" + this.getHostPID() + ", hostPorts=" + this.getHostPorts() + ", privileged=" + this.getPrivileged() + ", readOnlyRootFilesystem=" + this.getReadOnlyRootFilesystem() + ", requiredDropCapabilities=" + this.getRequiredDropCapabilities() + ", runAsGroup=" + this.getRunAsGroup() + ", runAsUser=" + this.getRunAsUser() + ", runtimeClass=" + this.getRuntimeClass() + ", seLinux=" + this.getSeLinux() + ", supplementalGroups=" + this.getSupplementalGroups() + ", volumes=" + this.getVolumes() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
