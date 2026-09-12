
package io.fabric8.openshift.api.model;

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
import io.fabric8.kubernetes.api.model.HasMetadata;
import io.fabric8.kubernetes.api.model.IntOrString;
import io.fabric8.kubernetes.api.model.LabelSelector;
import io.fabric8.kubernetes.api.model.ObjectMeta;
import io.fabric8.kubernetes.api.model.ObjectReference;
import io.fabric8.kubernetes.api.model.PersistentVolumeClaim;
import io.fabric8.kubernetes.api.model.PodTemplateSpec;
import io.fabric8.kubernetes.api.model.ResourceRequirements;
import io.fabric8.kubernetes.api.model.Volume;
import io.fabric8.kubernetes.api.model.VolumeMount;
import io.fabric8.kubernetes.model.annotation.Group;
import io.fabric8.kubernetes.model.annotation.Version;
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;

/**
 * SecurityContextConstraints governs the ability to make requests that affect the SecurityContext that will be applied to a container. For historical reasons SCC was exposed under the core Kubernetes API group. That exposure is deprecated and will be removed in a future release - users should instead use the security.openshift.io group to manage SecurityContextConstraints.<br><p> <br><p> Compatibility level 1: Stable within a major release for a minimum of 12 months or 3 minor releases (whichever is longer).
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "apiVersion",
    "kind",
    "metadata",
    "allowHostDirVolumePlugin",
    "allowHostIPC",
    "allowHostNetwork",
    "allowHostPID",
    "allowHostPorts",
    "allowPrivilegeEscalation",
    "allowPrivilegedContainer",
    "allowedCapabilities",
    "allowedFlexVolumes",
    "allowedUnsafeSysctls",
    "defaultAddCapabilities",
    "defaultAllowPrivilegeEscalation",
    "forbiddenSysctls",
    "fsGroup",
    "groups",
    "priority",
    "readOnlyRootFilesystem",
    "requiredDropCapabilities",
    "runAsUser",
    "seLinuxContext",
    "seccompProfiles",
    "supplementalGroups",
    "userNamespaceLevel",
    "users",
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
    @BuildableReference(io.fabric8.kubernetes.api.model.LocalObjectReference.class),
    @BuildableReference(PersistentVolumeClaim.class),
    @BuildableReference(EnvVar.class),
    @BuildableReference(ContainerPort.class),
    @BuildableReference(Volume.class),
    @BuildableReference(VolumeMount.class)
})
@Version("v1")
@Group("security.openshift.io")
@Generated("io.fabric8.kubernetes.schema.generator.model.ModelGenerator")
public class SecurityContextConstraints implements Editable<SecurityContextConstraintsBuilder>, HasMetadata
{

    @JsonProperty("allowHostDirVolumePlugin")
    private Boolean allowHostDirVolumePlugin;
    @JsonProperty("allowHostIPC")
    private Boolean allowHostIPC;
    @JsonProperty("allowHostNetwork")
    private Boolean allowHostNetwork;
    @JsonProperty("allowHostPID")
    private Boolean allowHostPID;
    @JsonProperty("allowHostPorts")
    private Boolean allowHostPorts;
    @JsonProperty("allowPrivilegeEscalation")
    private Boolean allowPrivilegeEscalation;
    @JsonProperty("allowPrivilegedContainer")
    private Boolean allowPrivilegedContainer;
    @JsonProperty("allowedCapabilities")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> allowedCapabilities = new ArrayList<>();
    @JsonProperty("allowedFlexVolumes")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<AllowedFlexVolume> allowedFlexVolumes = new ArrayList<>();
    @JsonProperty("allowedUnsafeSysctls")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> allowedUnsafeSysctls = new ArrayList<>();
    @JsonProperty("apiVersion")
    private String apiVersion = "security.openshift.io/v1";
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
    @JsonProperty("groups")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> groups = new ArrayList<>();
    @JsonProperty("kind")
    private String kind = "SecurityContextConstraints";
    @JsonProperty("metadata")
    private ObjectMeta metadata;
    @JsonProperty("priority")
    private Integer priority;
    @JsonProperty("readOnlyRootFilesystem")
    private Boolean readOnlyRootFilesystem;
    @JsonProperty("requiredDropCapabilities")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> requiredDropCapabilities = new ArrayList<>();
    @JsonProperty("runAsUser")
    private RunAsUserStrategyOptions runAsUser;
    @JsonProperty("seLinuxContext")
    private SELinuxContextStrategyOptions seLinuxContext;
    @JsonProperty("seccompProfiles")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> seccompProfiles = new ArrayList<>();
    @JsonProperty("supplementalGroups")
    private SupplementalGroupsStrategyOptions supplementalGroups;
    @JsonProperty("userNamespaceLevel")
    private String userNamespaceLevel;
    @JsonProperty("users")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> users = new ArrayList<>();
    @JsonProperty("volumes")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> volumes = new ArrayList<>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public SecurityContextConstraints() {
    }

    public SecurityContextConstraints(Boolean allowHostDirVolumePlugin, Boolean allowHostIPC, Boolean allowHostNetwork, Boolean allowHostPID, Boolean allowHostPorts, Boolean allowPrivilegeEscalation, Boolean allowPrivilegedContainer, List<String> allowedCapabilities, List<AllowedFlexVolume> allowedFlexVolumes, List<String> allowedUnsafeSysctls, String apiVersion, List<String> defaultAddCapabilities, Boolean defaultAllowPrivilegeEscalation, List<String> forbiddenSysctls, FSGroupStrategyOptions fsGroup, List<String> groups, String kind, ObjectMeta metadata, Integer priority, Boolean readOnlyRootFilesystem, List<String> requiredDropCapabilities, RunAsUserStrategyOptions runAsUser, SELinuxContextStrategyOptions seLinuxContext, List<String> seccompProfiles, SupplementalGroupsStrategyOptions supplementalGroups, String userNamespaceLevel, List<String> users, List<String> volumes) {
        super();
        this.allowHostDirVolumePlugin = allowHostDirVolumePlugin;
        this.allowHostIPC = allowHostIPC;
        this.allowHostNetwork = allowHostNetwork;
        this.allowHostPID = allowHostPID;
        this.allowHostPorts = allowHostPorts;
        this.allowPrivilegeEscalation = allowPrivilegeEscalation;
        this.allowPrivilegedContainer = allowPrivilegedContainer;
        this.allowedCapabilities = allowedCapabilities;
        this.allowedFlexVolumes = allowedFlexVolumes;
        this.allowedUnsafeSysctls = allowedUnsafeSysctls;
        this.apiVersion = apiVersion;
        this.defaultAddCapabilities = defaultAddCapabilities;
        this.defaultAllowPrivilegeEscalation = defaultAllowPrivilegeEscalation;
        this.forbiddenSysctls = forbiddenSysctls;
        this.fsGroup = fsGroup;
        this.groups = groups;
        this.kind = kind;
        this.metadata = metadata;
        this.priority = priority;
        this.readOnlyRootFilesystem = readOnlyRootFilesystem;
        this.requiredDropCapabilities = requiredDropCapabilities;
        this.runAsUser = runAsUser;
        this.seLinuxContext = seLinuxContext;
        this.seccompProfiles = seccompProfiles;
        this.supplementalGroups = supplementalGroups;
        this.userNamespaceLevel = userNamespaceLevel;
        this.users = users;
        this.volumes = volumes;
    }

    /**
     * allowHostDirVolumePlugin determines if the policy allow containers to use the HostDir volume plugin
     */
    @JsonProperty("allowHostDirVolumePlugin")
    public Boolean getAllowHostDirVolumePlugin() {
        return allowHostDirVolumePlugin;
    }

    /**
     * allowHostDirVolumePlugin determines if the policy allow containers to use the HostDir volume plugin
     */
    @JsonProperty("allowHostDirVolumePlugin")
    public void setAllowHostDirVolumePlugin(Boolean allowHostDirVolumePlugin) {
        this.allowHostDirVolumePlugin = allowHostDirVolumePlugin;
    }

    /**
     * allowHostIPC determines if the policy allows host ipc in the containers.
     */
    @JsonProperty("allowHostIPC")
    public Boolean getAllowHostIPC() {
        return allowHostIPC;
    }

    /**
     * allowHostIPC determines if the policy allows host ipc in the containers.
     */
    @JsonProperty("allowHostIPC")
    public void setAllowHostIPC(Boolean allowHostIPC) {
        this.allowHostIPC = allowHostIPC;
    }

    /**
     * allowHostNetwork determines if the policy allows the use of HostNetwork in the pod spec.
     */
    @JsonProperty("allowHostNetwork")
    public Boolean getAllowHostNetwork() {
        return allowHostNetwork;
    }

    /**
     * allowHostNetwork determines if the policy allows the use of HostNetwork in the pod spec.
     */
    @JsonProperty("allowHostNetwork")
    public void setAllowHostNetwork(Boolean allowHostNetwork) {
        this.allowHostNetwork = allowHostNetwork;
    }

    /**
     * allowHostPID determines if the policy allows host pid in the containers.
     */
    @JsonProperty("allowHostPID")
    public Boolean getAllowHostPID() {
        return allowHostPID;
    }

    /**
     * allowHostPID determines if the policy allows host pid in the containers.
     */
    @JsonProperty("allowHostPID")
    public void setAllowHostPID(Boolean allowHostPID) {
        this.allowHostPID = allowHostPID;
    }

    /**
     * allowHostPorts determines if the policy allows host ports in the containers.
     */
    @JsonProperty("allowHostPorts")
    public Boolean getAllowHostPorts() {
        return allowHostPorts;
    }

    /**
     * allowHostPorts determines if the policy allows host ports in the containers.
     */
    @JsonProperty("allowHostPorts")
    public void setAllowHostPorts(Boolean allowHostPorts) {
        this.allowHostPorts = allowHostPorts;
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
     * allowPrivilegedContainer determines if a container can request to be run as privileged.
     */
    @JsonProperty("allowPrivilegedContainer")
    public Boolean getAllowPrivilegedContainer() {
        return allowPrivilegedContainer;
    }

    /**
     * allowPrivilegedContainer determines if a container can request to be run as privileged.
     */
    @JsonProperty("allowPrivilegedContainer")
    public void setAllowPrivilegedContainer(Boolean allowPrivilegedContainer) {
        this.allowPrivilegedContainer = allowPrivilegedContainer;
    }

    /**
     * allowedCapabilities is a list of capabilities that can be requested to add to the container. Capabilities in this field maybe added at the pod author's discretion. You must not list a capability in both AllowedCapabilities and RequiredDropCapabilities. To allow all capabilities you may use '&#42;'.
     */
    @JsonProperty("allowedCapabilities")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getAllowedCapabilities() {
        return allowedCapabilities;
    }

    /**
     * allowedCapabilities is a list of capabilities that can be requested to add to the container. Capabilities in this field maybe added at the pod author's discretion. You must not list a capability in both AllowedCapabilities and RequiredDropCapabilities. To allow all capabilities you may use '&#42;'.
     */
    @JsonProperty("allowedCapabilities")
    public void setAllowedCapabilities(List<String> allowedCapabilities) {
        this.allowedCapabilities = allowedCapabilities;
    }

    /**
     * allowedFlexVolumes is a whitelist of allowed Flexvolumes.  Empty or nil indicates that all Flexvolumes may be used.  This parameter is effective only when the usage of the Flexvolumes is allowed in the "Volumes" field.
     */
    @JsonProperty("allowedFlexVolumes")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<AllowedFlexVolume> getAllowedFlexVolumes() {
        return allowedFlexVolumes;
    }

    /**
     * allowedFlexVolumes is a whitelist of allowed Flexvolumes.  Empty or nil indicates that all Flexvolumes may be used.  This parameter is effective only when the usage of the Flexvolumes is allowed in the "Volumes" field.
     */
    @JsonProperty("allowedFlexVolumes")
    public void setAllowedFlexVolumes(List<AllowedFlexVolume> allowedFlexVolumes) {
        this.allowedFlexVolumes = allowedFlexVolumes;
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
     * APIVersion defines the versioned schema of this representation of an object. Servers should convert recognized schemas to the latest internal value, and may reject unrecognized values. More info: https://git.k8s.io/community/contributors/devel/sig-architecture/api-conventions.md#resources
     */
    @JsonProperty("apiVersion")
    public String getApiVersion() {
        return apiVersion;
    }

    /**
     * APIVersion defines the versioned schema of this representation of an object. Servers should convert recognized schemas to the latest internal value, and may reject unrecognized values. More info: https://git.k8s.io/community/contributors/devel/sig-architecture/api-conventions.md#resources
     */
    @JsonProperty("apiVersion")
    public void setApiVersion(String apiVersion) {
        this.apiVersion = apiVersion;
    }

    /**
     * defaultAddCapabilities is the default set of capabilities that will be added to the container unless the pod spec specifically drops the capability.  You may not list a capabiility in both DefaultAddCapabilities and RequiredDropCapabilities.
     */
    @JsonProperty("defaultAddCapabilities")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getDefaultAddCapabilities() {
        return defaultAddCapabilities;
    }

    /**
     * defaultAddCapabilities is the default set of capabilities that will be added to the container unless the pod spec specifically drops the capability.  You may not list a capabiility in both DefaultAddCapabilities and RequiredDropCapabilities.
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
     * SecurityContextConstraints governs the ability to make requests that affect the SecurityContext that will be applied to a container. For historical reasons SCC was exposed under the core Kubernetes API group. That exposure is deprecated and will be removed in a future release - users should instead use the security.openshift.io group to manage SecurityContextConstraints.<br><p> <br><p> Compatibility level 1: Stable within a major release for a minimum of 12 months or 3 minor releases (whichever is longer).
     */
    @JsonProperty("fsGroup")
    public FSGroupStrategyOptions getFsGroup() {
        return fsGroup;
    }

    /**
     * SecurityContextConstraints governs the ability to make requests that affect the SecurityContext that will be applied to a container. For historical reasons SCC was exposed under the core Kubernetes API group. That exposure is deprecated and will be removed in a future release - users should instead use the security.openshift.io group to manage SecurityContextConstraints.<br><p> <br><p> Compatibility level 1: Stable within a major release for a minimum of 12 months or 3 minor releases (whichever is longer).
     */
    @JsonProperty("fsGroup")
    public void setFsGroup(FSGroupStrategyOptions fsGroup) {
        this.fsGroup = fsGroup;
    }

    /**
     * The groups that have permission to use this security context constraints
     */
    @JsonProperty("groups")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getGroups() {
        return groups;
    }

    /**
     * The groups that have permission to use this security context constraints
     */
    @JsonProperty("groups")
    public void setGroups(List<String> groups) {
        this.groups = groups;
    }

    /**
     * Kind is a string value representing the REST resource this object represents. Servers may infer this from the endpoint the client submits requests to. Cannot be updated. In CamelCase. More info: https://git.k8s.io/community/contributors/devel/sig-architecture/api-conventions.md#types-kinds
     */
    @JsonProperty("kind")
    public String getKind() {
        return kind;
    }

    /**
     * Kind is a string value representing the REST resource this object represents. Servers may infer this from the endpoint the client submits requests to. Cannot be updated. In CamelCase. More info: https://git.k8s.io/community/contributors/devel/sig-architecture/api-conventions.md#types-kinds
     */
    @JsonProperty("kind")
    public void setKind(String kind) {
        this.kind = kind;
    }

    /**
     * SecurityContextConstraints governs the ability to make requests that affect the SecurityContext that will be applied to a container. For historical reasons SCC was exposed under the core Kubernetes API group. That exposure is deprecated and will be removed in a future release - users should instead use the security.openshift.io group to manage SecurityContextConstraints.<br><p> <br><p> Compatibility level 1: Stable within a major release for a minimum of 12 months or 3 minor releases (whichever is longer).
     */
    @JsonProperty("metadata")
    public ObjectMeta getMetadata() {
        return metadata;
    }

    /**
     * SecurityContextConstraints governs the ability to make requests that affect the SecurityContext that will be applied to a container. For historical reasons SCC was exposed under the core Kubernetes API group. That exposure is deprecated and will be removed in a future release - users should instead use the security.openshift.io group to manage SecurityContextConstraints.<br><p> <br><p> Compatibility level 1: Stable within a major release for a minimum of 12 months or 3 minor releases (whichever is longer).
     */
    @JsonProperty("metadata")
    public void setMetadata(ObjectMeta metadata) {
        this.metadata = metadata;
    }

    /**
     * priority influences the sort order of SCCs when evaluating which SCCs to try first for a given pod request based on access in the Users and Groups fields.  The higher the int, the higher priority. An unset value is considered a 0 priority. If scores for multiple SCCs are equal they will be sorted from most restrictive to least restrictive. If both priorities and restrictions are equal the SCCs will be sorted by name.
     */
    @JsonProperty("priority")
    public Integer getPriority() {
        return priority;
    }

    /**
     * priority influences the sort order of SCCs when evaluating which SCCs to try first for a given pod request based on access in the Users and Groups fields.  The higher the int, the higher priority. An unset value is considered a 0 priority. If scores for multiple SCCs are equal they will be sorted from most restrictive to least restrictive. If both priorities and restrictions are equal the SCCs will be sorted by name.
     */
    @JsonProperty("priority")
    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    /**
     * readOnlyRootFilesystem when set to true will force containers to run with a read only root file system.  If the container specifically requests to run with a non-read only root file system the SCC should deny the pod. If set to false the container may run with a read only root file system if it wishes but it will not be forced to.
     */
    @JsonProperty("readOnlyRootFilesystem")
    public Boolean getReadOnlyRootFilesystem() {
        return readOnlyRootFilesystem;
    }

    /**
     * readOnlyRootFilesystem when set to true will force containers to run with a read only root file system.  If the container specifically requests to run with a non-read only root file system the SCC should deny the pod. If set to false the container may run with a read only root file system if it wishes but it will not be forced to.
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
     * SecurityContextConstraints governs the ability to make requests that affect the SecurityContext that will be applied to a container. For historical reasons SCC was exposed under the core Kubernetes API group. That exposure is deprecated and will be removed in a future release - users should instead use the security.openshift.io group to manage SecurityContextConstraints.<br><p> <br><p> Compatibility level 1: Stable within a major release for a minimum of 12 months or 3 minor releases (whichever is longer).
     */
    @JsonProperty("runAsUser")
    public RunAsUserStrategyOptions getRunAsUser() {
        return runAsUser;
    }

    /**
     * SecurityContextConstraints governs the ability to make requests that affect the SecurityContext that will be applied to a container. For historical reasons SCC was exposed under the core Kubernetes API group. That exposure is deprecated and will be removed in a future release - users should instead use the security.openshift.io group to manage SecurityContextConstraints.<br><p> <br><p> Compatibility level 1: Stable within a major release for a minimum of 12 months or 3 minor releases (whichever is longer).
     */
    @JsonProperty("runAsUser")
    public void setRunAsUser(RunAsUserStrategyOptions runAsUser) {
        this.runAsUser = runAsUser;
    }

    /**
     * SecurityContextConstraints governs the ability to make requests that affect the SecurityContext that will be applied to a container. For historical reasons SCC was exposed under the core Kubernetes API group. That exposure is deprecated and will be removed in a future release - users should instead use the security.openshift.io group to manage SecurityContextConstraints.<br><p> <br><p> Compatibility level 1: Stable within a major release for a minimum of 12 months or 3 minor releases (whichever is longer).
     */
    @JsonProperty("seLinuxContext")
    public SELinuxContextStrategyOptions getSeLinuxContext() {
        return seLinuxContext;
    }

    /**
     * SecurityContextConstraints governs the ability to make requests that affect the SecurityContext that will be applied to a container. For historical reasons SCC was exposed under the core Kubernetes API group. That exposure is deprecated and will be removed in a future release - users should instead use the security.openshift.io group to manage SecurityContextConstraints.<br><p> <br><p> Compatibility level 1: Stable within a major release for a minimum of 12 months or 3 minor releases (whichever is longer).
     */
    @JsonProperty("seLinuxContext")
    public void setSeLinuxContext(SELinuxContextStrategyOptions seLinuxContext) {
        this.seLinuxContext = seLinuxContext;
    }

    /**
     * seccompProfiles lists the allowed profiles that may be set for the pod or container's seccomp annotations.  An unset (nil) or empty value means that no profiles may be specifid by the pod or container.	The wildcard '&#42;' may be used to allow all profiles.  When used to generate a value for a pod the first non-wildcard profile will be used as the default.
     */
    @JsonProperty("seccompProfiles")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getSeccompProfiles() {
        return seccompProfiles;
    }

    /**
     * seccompProfiles lists the allowed profiles that may be set for the pod or container's seccomp annotations.  An unset (nil) or empty value means that no profiles may be specifid by the pod or container.	The wildcard '&#42;' may be used to allow all profiles.  When used to generate a value for a pod the first non-wildcard profile will be used as the default.
     */
    @JsonProperty("seccompProfiles")
    public void setSeccompProfiles(List<String> seccompProfiles) {
        this.seccompProfiles = seccompProfiles;
    }

    /**
     * SecurityContextConstraints governs the ability to make requests that affect the SecurityContext that will be applied to a container. For historical reasons SCC was exposed under the core Kubernetes API group. That exposure is deprecated and will be removed in a future release - users should instead use the security.openshift.io group to manage SecurityContextConstraints.<br><p> <br><p> Compatibility level 1: Stable within a major release for a minimum of 12 months or 3 minor releases (whichever is longer).
     */
    @JsonProperty("supplementalGroups")
    public SupplementalGroupsStrategyOptions getSupplementalGroups() {
        return supplementalGroups;
    }

    /**
     * SecurityContextConstraints governs the ability to make requests that affect the SecurityContext that will be applied to a container. For historical reasons SCC was exposed under the core Kubernetes API group. That exposure is deprecated and will be removed in a future release - users should instead use the security.openshift.io group to manage SecurityContextConstraints.<br><p> <br><p> Compatibility level 1: Stable within a major release for a minimum of 12 months or 3 minor releases (whichever is longer).
     */
    @JsonProperty("supplementalGroups")
    public void setSupplementalGroups(SupplementalGroupsStrategyOptions supplementalGroups) {
        this.supplementalGroups = supplementalGroups;
    }

    /**
     * userNamespaceLevel determines if the policy allows host users in containers. Valid values are "AllowHostLevel", "RequirePodLevel", and omitted. When "AllowHostLevel" is set, a pod author may set `hostUsers` to either `true` or `false`. When "RequirePodLevel" is set, a pod author must set `hostUsers` to `false`. When omitted, the default value is "AllowHostLevel".
     */
    @JsonProperty("userNamespaceLevel")
    public String getUserNamespaceLevel() {
        return userNamespaceLevel;
    }

    /**
     * userNamespaceLevel determines if the policy allows host users in containers. Valid values are "AllowHostLevel", "RequirePodLevel", and omitted. When "AllowHostLevel" is set, a pod author may set `hostUsers` to either `true` or `false`. When "RequirePodLevel" is set, a pod author must set `hostUsers` to `false`. When omitted, the default value is "AllowHostLevel".
     */
    @JsonProperty("userNamespaceLevel")
    public void setUserNamespaceLevel(String userNamespaceLevel) {
        this.userNamespaceLevel = userNamespaceLevel;
    }

    /**
     * The users who have permissions to use this security context constraints
     */
    @JsonProperty("users")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getUsers() {
        return users;
    }

    /**
     * The users who have permissions to use this security context constraints
     */
    @JsonProperty("users")
    public void setUsers(List<String> users) {
        this.users = users;
    }

    /**
     * volumes is a white list of allowed volume plugins.  FSType corresponds directly with the field names of a VolumeSource (azureFile, configMap, emptyDir).  To allow all volumes you may use "&#42;". To allow no volumes, set to ["none"].
     */
    @JsonProperty("volumes")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getVolumes() {
        return volumes;
    }

    /**
     * volumes is a white list of allowed volume plugins.  FSType corresponds directly with the field names of a VolumeSource (azureFile, configMap, emptyDir).  To allow all volumes you may use "&#42;". To allow no volumes, set to ["none"].
     */
    @JsonProperty("volumes")
    public void setVolumes(List<String> volumes) {
        this.volumes = volumes;
    }

    @JsonIgnore
    public SecurityContextConstraintsBuilder edit() {
        return new SecurityContextConstraintsBuilder(this);
    }

    @JsonIgnore
    public SecurityContextConstraintsBuilder toBuilder() {
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
        if (!(o instanceof SecurityContextConstraints)) {
            return false;
        }
        SecurityContextConstraints other = (SecurityContextConstraints) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$allowHostDirVolumePlugin = this.getAllowHostDirVolumePlugin();
        Object other$allowHostDirVolumePlugin = other.getAllowHostDirVolumePlugin();
        if (this$allowHostDirVolumePlugin == null ? other$allowHostDirVolumePlugin != null : !this$allowHostDirVolumePlugin.equals(other$allowHostDirVolumePlugin)) {
            return false;
        }
        Object this$allowHostIPC = this.getAllowHostIPC();
        Object other$allowHostIPC = other.getAllowHostIPC();
        if (this$allowHostIPC == null ? other$allowHostIPC != null : !this$allowHostIPC.equals(other$allowHostIPC)) {
            return false;
        }
        Object this$allowHostNetwork = this.getAllowHostNetwork();
        Object other$allowHostNetwork = other.getAllowHostNetwork();
        if (this$allowHostNetwork == null ? other$allowHostNetwork != null : !this$allowHostNetwork.equals(other$allowHostNetwork)) {
            return false;
        }
        Object this$allowHostPID = this.getAllowHostPID();
        Object other$allowHostPID = other.getAllowHostPID();
        if (this$allowHostPID == null ? other$allowHostPID != null : !this$allowHostPID.equals(other$allowHostPID)) {
            return false;
        }
        Object this$allowHostPorts = this.getAllowHostPorts();
        Object other$allowHostPorts = other.getAllowHostPorts();
        if (this$allowHostPorts == null ? other$allowHostPorts != null : !this$allowHostPorts.equals(other$allowHostPorts)) {
            return false;
        }
        Object this$allowPrivilegeEscalation = this.getAllowPrivilegeEscalation();
        Object other$allowPrivilegeEscalation = other.getAllowPrivilegeEscalation();
        if (this$allowPrivilegeEscalation == null ? other$allowPrivilegeEscalation != null : !this$allowPrivilegeEscalation.equals(other$allowPrivilegeEscalation)) {
            return false;
        }
        Object this$allowPrivilegedContainer = this.getAllowPrivilegedContainer();
        Object other$allowPrivilegedContainer = other.getAllowPrivilegedContainer();
        if (this$allowPrivilegedContainer == null ? other$allowPrivilegedContainer != null : !this$allowPrivilegedContainer.equals(other$allowPrivilegedContainer)) {
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
        Object this$allowedUnsafeSysctls = this.getAllowedUnsafeSysctls();
        Object other$allowedUnsafeSysctls = other.getAllowedUnsafeSysctls();
        if (this$allowedUnsafeSysctls == null ? other$allowedUnsafeSysctls != null : !this$allowedUnsafeSysctls.equals(other$allowedUnsafeSysctls)) {
            return false;
        }
        Object this$apiVersion = this.getApiVersion();
        Object other$apiVersion = other.getApiVersion();
        if (this$apiVersion == null ? other$apiVersion != null : !this$apiVersion.equals(other$apiVersion)) {
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
        Object this$groups = this.getGroups();
        Object other$groups = other.getGroups();
        if (this$groups == null ? other$groups != null : !this$groups.equals(other$groups)) {
            return false;
        }
        Object this$kind = this.getKind();
        Object other$kind = other.getKind();
        if (this$kind == null ? other$kind != null : !this$kind.equals(other$kind)) {
            return false;
        }
        Object this$metadata = this.getMetadata();
        Object other$metadata = other.getMetadata();
        if (this$metadata == null ? other$metadata != null : !this$metadata.equals(other$metadata)) {
            return false;
        }
        Object this$priority = this.getPriority();
        Object other$priority = other.getPriority();
        if (this$priority == null ? other$priority != null : !this$priority.equals(other$priority)) {
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
        Object this$runAsUser = this.getRunAsUser();
        Object other$runAsUser = other.getRunAsUser();
        if (this$runAsUser == null ? other$runAsUser != null : !this$runAsUser.equals(other$runAsUser)) {
            return false;
        }
        Object this$seLinuxContext = this.getSeLinuxContext();
        Object other$seLinuxContext = other.getSeLinuxContext();
        if (this$seLinuxContext == null ? other$seLinuxContext != null : !this$seLinuxContext.equals(other$seLinuxContext)) {
            return false;
        }
        Object this$seccompProfiles = this.getSeccompProfiles();
        Object other$seccompProfiles = other.getSeccompProfiles();
        if (this$seccompProfiles == null ? other$seccompProfiles != null : !this$seccompProfiles.equals(other$seccompProfiles)) {
            return false;
        }
        Object this$supplementalGroups = this.getSupplementalGroups();
        Object other$supplementalGroups = other.getSupplementalGroups();
        if (this$supplementalGroups == null ? other$supplementalGroups != null : !this$supplementalGroups.equals(other$supplementalGroups)) {
            return false;
        }
        Object this$userNamespaceLevel = this.getUserNamespaceLevel();
        Object other$userNamespaceLevel = other.getUserNamespaceLevel();
        if (this$userNamespaceLevel == null ? other$userNamespaceLevel != null : !this$userNamespaceLevel.equals(other$userNamespaceLevel)) {
            return false;
        }
        Object this$users = this.getUsers();
        Object other$users = other.getUsers();
        if (this$users == null ? other$users != null : !this$users.equals(other$users)) {
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
        return other instanceof SecurityContextConstraints;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $allowHostDirVolumePlugin = this.getAllowHostDirVolumePlugin();
        result = result * prime + ($allowHostDirVolumePlugin == null ? 43 : $allowHostDirVolumePlugin.hashCode());
        Object $allowHostIPC = this.getAllowHostIPC();
        result = result * prime + ($allowHostIPC == null ? 43 : $allowHostIPC.hashCode());
        Object $allowHostNetwork = this.getAllowHostNetwork();
        result = result * prime + ($allowHostNetwork == null ? 43 : $allowHostNetwork.hashCode());
        Object $allowHostPID = this.getAllowHostPID();
        result = result * prime + ($allowHostPID == null ? 43 : $allowHostPID.hashCode());
        Object $allowHostPorts = this.getAllowHostPorts();
        result = result * prime + ($allowHostPorts == null ? 43 : $allowHostPorts.hashCode());
        Object $allowPrivilegeEscalation = this.getAllowPrivilegeEscalation();
        result = result * prime + ($allowPrivilegeEscalation == null ? 43 : $allowPrivilegeEscalation.hashCode());
        Object $allowPrivilegedContainer = this.getAllowPrivilegedContainer();
        result = result * prime + ($allowPrivilegedContainer == null ? 43 : $allowPrivilegedContainer.hashCode());
        Object $allowedCapabilities = this.getAllowedCapabilities();
        result = result * prime + ($allowedCapabilities == null ? 43 : $allowedCapabilities.hashCode());
        Object $allowedFlexVolumes = this.getAllowedFlexVolumes();
        result = result * prime + ($allowedFlexVolumes == null ? 43 : $allowedFlexVolumes.hashCode());
        Object $allowedUnsafeSysctls = this.getAllowedUnsafeSysctls();
        result = result * prime + ($allowedUnsafeSysctls == null ? 43 : $allowedUnsafeSysctls.hashCode());
        Object $apiVersion = this.getApiVersion();
        result = result * prime + ($apiVersion == null ? 43 : $apiVersion.hashCode());
        Object $defaultAddCapabilities = this.getDefaultAddCapabilities();
        result = result * prime + ($defaultAddCapabilities == null ? 43 : $defaultAddCapabilities.hashCode());
        Object $defaultAllowPrivilegeEscalation = this.getDefaultAllowPrivilegeEscalation();
        result = result * prime + ($defaultAllowPrivilegeEscalation == null ? 43 : $defaultAllowPrivilegeEscalation.hashCode());
        Object $forbiddenSysctls = this.getForbiddenSysctls();
        result = result * prime + ($forbiddenSysctls == null ? 43 : $forbiddenSysctls.hashCode());
        Object $fsGroup = this.getFsGroup();
        result = result * prime + ($fsGroup == null ? 43 : $fsGroup.hashCode());
        Object $groups = this.getGroups();
        result = result * prime + ($groups == null ? 43 : $groups.hashCode());
        Object $kind = this.getKind();
        result = result * prime + ($kind == null ? 43 : $kind.hashCode());
        Object $metadata = this.getMetadata();
        result = result * prime + ($metadata == null ? 43 : $metadata.hashCode());
        Object $priority = this.getPriority();
        result = result * prime + ($priority == null ? 43 : $priority.hashCode());
        Object $readOnlyRootFilesystem = this.getReadOnlyRootFilesystem();
        result = result * prime + ($readOnlyRootFilesystem == null ? 43 : $readOnlyRootFilesystem.hashCode());
        Object $requiredDropCapabilities = this.getRequiredDropCapabilities();
        result = result * prime + ($requiredDropCapabilities == null ? 43 : $requiredDropCapabilities.hashCode());
        Object $runAsUser = this.getRunAsUser();
        result = result * prime + ($runAsUser == null ? 43 : $runAsUser.hashCode());
        Object $seLinuxContext = this.getSeLinuxContext();
        result = result * prime + ($seLinuxContext == null ? 43 : $seLinuxContext.hashCode());
        Object $seccompProfiles = this.getSeccompProfiles();
        result = result * prime + ($seccompProfiles == null ? 43 : $seccompProfiles.hashCode());
        Object $supplementalGroups = this.getSupplementalGroups();
        result = result * prime + ($supplementalGroups == null ? 43 : $supplementalGroups.hashCode());
        Object $userNamespaceLevel = this.getUserNamespaceLevel();
        result = result * prime + ($userNamespaceLevel == null ? 43 : $userNamespaceLevel.hashCode());
        Object $users = this.getUsers();
        result = result * prime + ($users == null ? 43 : $users.hashCode());
        Object $volumes = this.getVolumes();
        result = result * prime + ($volumes == null ? 43 : $volumes.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "SecurityContextConstraints(" + "allowHostDirVolumePlugin=" + this.getAllowHostDirVolumePlugin() + ", allowHostIPC=" + this.getAllowHostIPC() + ", allowHostNetwork=" + this.getAllowHostNetwork() + ", allowHostPID=" + this.getAllowHostPID() + ", allowHostPorts=" + this.getAllowHostPorts() + ", allowPrivilegeEscalation=" + this.getAllowPrivilegeEscalation() + ", allowPrivilegedContainer=" + this.getAllowPrivilegedContainer() + ", allowedCapabilities=" + this.getAllowedCapabilities() + ", allowedFlexVolumes=" + this.getAllowedFlexVolumes() + ", allowedUnsafeSysctls=" + this.getAllowedUnsafeSysctls() + ", apiVersion=" + this.getApiVersion() + ", defaultAddCapabilities=" + this.getDefaultAddCapabilities() + ", defaultAllowPrivilegeEscalation=" + this.getDefaultAllowPrivilegeEscalation() + ", forbiddenSysctls=" + this.getForbiddenSysctls() + ", fsGroup=" + this.getFsGroup() + ", groups=" + this.getGroups() + ", kind=" + this.getKind() + ", metadata=" + this.getMetadata() + ", priority=" + this.getPriority() + ", readOnlyRootFilesystem=" + this.getReadOnlyRootFilesystem() + ", requiredDropCapabilities=" + this.getRequiredDropCapabilities() + ", runAsUser=" + this.getRunAsUser() + ", seLinuxContext=" + this.getSeLinuxContext() + ", seccompProfiles=" + this.getSeccompProfiles() + ", supplementalGroups=" + this.getSupplementalGroups() + ", userNamespaceLevel=" + this.getUserNamespaceLevel() + ", users=" + this.getUsers() + ", volumes=" + this.getVolumes() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
