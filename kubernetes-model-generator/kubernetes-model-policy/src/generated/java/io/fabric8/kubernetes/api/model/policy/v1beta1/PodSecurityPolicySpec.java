
package io.fabric8.kubernetes.api.model.policy.v1beta1;

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
import io.fabric8.kubernetes.api.model.Container;
import io.fabric8.kubernetes.api.model.IntOrString;
import io.fabric8.kubernetes.api.model.KubernetesResource;
import io.fabric8.kubernetes.api.model.LabelSelector;
import io.fabric8.kubernetes.api.model.LocalObjectReference;
import io.fabric8.kubernetes.api.model.ObjectMeta;
import io.fabric8.kubernetes.api.model.ObjectReference;
import io.fabric8.kubernetes.api.model.PersistentVolumeClaim;
import io.fabric8.kubernetes.api.model.PodTemplateSpec;
import io.fabric8.kubernetes.api.model.ResourceRequirements;
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;
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
@Setter
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
    @BuildableReference(PersistentVolumeClaim.class)
})
@Generated("jsonschema2pojo")
public class PodSecurityPolicySpec implements KubernetesResource
{

    @JsonProperty("allowPrivilegeEscalation")
    private Boolean allowPrivilegeEscalation;
    @JsonProperty("allowedCSIDrivers")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<AllowedCSIDriver> allowedCSIDrivers = new ArrayList<AllowedCSIDriver>();
    @JsonProperty("allowedCapabilities")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> allowedCapabilities = new ArrayList<String>();
    @JsonProperty("allowedFlexVolumes")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<AllowedFlexVolume> allowedFlexVolumes = new ArrayList<AllowedFlexVolume>();
    @JsonProperty("allowedHostPaths")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<AllowedHostPath> allowedHostPaths = new ArrayList<AllowedHostPath>();
    @JsonProperty("allowedProcMountTypes")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> allowedProcMountTypes = new ArrayList<String>();
    @JsonProperty("allowedUnsafeSysctls")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> allowedUnsafeSysctls = new ArrayList<String>();
    @JsonProperty("defaultAddCapabilities")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> defaultAddCapabilities = new ArrayList<String>();
    @JsonProperty("defaultAllowPrivilegeEscalation")
    private Boolean defaultAllowPrivilegeEscalation;
    @JsonProperty("forbiddenSysctls")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> forbiddenSysctls = new ArrayList<String>();
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
    private List<HostPortRange> hostPorts = new ArrayList<HostPortRange>();
    @JsonProperty("privileged")
    private Boolean privileged;
    @JsonProperty("readOnlyRootFilesystem")
    private Boolean readOnlyRootFilesystem;
    @JsonProperty("requiredDropCapabilities")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> requiredDropCapabilities = new ArrayList<String>();
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
    private List<String> volumes = new ArrayList<String>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
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

    @JsonProperty("allowPrivilegeEscalation")
    public Boolean getAllowPrivilegeEscalation() {
        return allowPrivilegeEscalation;
    }

    @JsonProperty("allowPrivilegeEscalation")
    public void setAllowPrivilegeEscalation(Boolean allowPrivilegeEscalation) {
        this.allowPrivilegeEscalation = allowPrivilegeEscalation;
    }

    @JsonProperty("allowedCSIDrivers")
    public List<AllowedCSIDriver> getAllowedCSIDrivers() {
        return allowedCSIDrivers;
    }

    @JsonProperty("allowedCSIDrivers")
    public void setAllowedCSIDrivers(List<AllowedCSIDriver> allowedCSIDrivers) {
        this.allowedCSIDrivers = allowedCSIDrivers;
    }

    @JsonProperty("allowedCapabilities")
    public List<String> getAllowedCapabilities() {
        return allowedCapabilities;
    }

    @JsonProperty("allowedCapabilities")
    public void setAllowedCapabilities(List<String> allowedCapabilities) {
        this.allowedCapabilities = allowedCapabilities;
    }

    @JsonProperty("allowedFlexVolumes")
    public List<AllowedFlexVolume> getAllowedFlexVolumes() {
        return allowedFlexVolumes;
    }

    @JsonProperty("allowedFlexVolumes")
    public void setAllowedFlexVolumes(List<AllowedFlexVolume> allowedFlexVolumes) {
        this.allowedFlexVolumes = allowedFlexVolumes;
    }

    @JsonProperty("allowedHostPaths")
    public List<AllowedHostPath> getAllowedHostPaths() {
        return allowedHostPaths;
    }

    @JsonProperty("allowedHostPaths")
    public void setAllowedHostPaths(List<AllowedHostPath> allowedHostPaths) {
        this.allowedHostPaths = allowedHostPaths;
    }

    @JsonProperty("allowedProcMountTypes")
    public List<String> getAllowedProcMountTypes() {
        return allowedProcMountTypes;
    }

    @JsonProperty("allowedProcMountTypes")
    public void setAllowedProcMountTypes(List<String> allowedProcMountTypes) {
        this.allowedProcMountTypes = allowedProcMountTypes;
    }

    @JsonProperty("allowedUnsafeSysctls")
    public List<String> getAllowedUnsafeSysctls() {
        return allowedUnsafeSysctls;
    }

    @JsonProperty("allowedUnsafeSysctls")
    public void setAllowedUnsafeSysctls(List<String> allowedUnsafeSysctls) {
        this.allowedUnsafeSysctls = allowedUnsafeSysctls;
    }

    @JsonProperty("defaultAddCapabilities")
    public List<String> getDefaultAddCapabilities() {
        return defaultAddCapabilities;
    }

    @JsonProperty("defaultAddCapabilities")
    public void setDefaultAddCapabilities(List<String> defaultAddCapabilities) {
        this.defaultAddCapabilities = defaultAddCapabilities;
    }

    @JsonProperty("defaultAllowPrivilegeEscalation")
    public Boolean getDefaultAllowPrivilegeEscalation() {
        return defaultAllowPrivilegeEscalation;
    }

    @JsonProperty("defaultAllowPrivilegeEscalation")
    public void setDefaultAllowPrivilegeEscalation(Boolean defaultAllowPrivilegeEscalation) {
        this.defaultAllowPrivilegeEscalation = defaultAllowPrivilegeEscalation;
    }

    @JsonProperty("forbiddenSysctls")
    public List<String> getForbiddenSysctls() {
        return forbiddenSysctls;
    }

    @JsonProperty("forbiddenSysctls")
    public void setForbiddenSysctls(List<String> forbiddenSysctls) {
        this.forbiddenSysctls = forbiddenSysctls;
    }

    @JsonProperty("fsGroup")
    public FSGroupStrategyOptions getFsGroup() {
        return fsGroup;
    }

    @JsonProperty("fsGroup")
    public void setFsGroup(FSGroupStrategyOptions fsGroup) {
        this.fsGroup = fsGroup;
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

    @JsonProperty("hostPorts")
    public List<HostPortRange> getHostPorts() {
        return hostPorts;
    }

    @JsonProperty("hostPorts")
    public void setHostPorts(List<HostPortRange> hostPorts) {
        this.hostPorts = hostPorts;
    }

    @JsonProperty("privileged")
    public Boolean getPrivileged() {
        return privileged;
    }

    @JsonProperty("privileged")
    public void setPrivileged(Boolean privileged) {
        this.privileged = privileged;
    }

    @JsonProperty("readOnlyRootFilesystem")
    public Boolean getReadOnlyRootFilesystem() {
        return readOnlyRootFilesystem;
    }

    @JsonProperty("readOnlyRootFilesystem")
    public void setReadOnlyRootFilesystem(Boolean readOnlyRootFilesystem) {
        this.readOnlyRootFilesystem = readOnlyRootFilesystem;
    }

    @JsonProperty("requiredDropCapabilities")
    public List<String> getRequiredDropCapabilities() {
        return requiredDropCapabilities;
    }

    @JsonProperty("requiredDropCapabilities")
    public void setRequiredDropCapabilities(List<String> requiredDropCapabilities) {
        this.requiredDropCapabilities = requiredDropCapabilities;
    }

    @JsonProperty("runAsGroup")
    public RunAsGroupStrategyOptions getRunAsGroup() {
        return runAsGroup;
    }

    @JsonProperty("runAsGroup")
    public void setRunAsGroup(RunAsGroupStrategyOptions runAsGroup) {
        this.runAsGroup = runAsGroup;
    }

    @JsonProperty("runAsUser")
    public RunAsUserStrategyOptions getRunAsUser() {
        return runAsUser;
    }

    @JsonProperty("runAsUser")
    public void setRunAsUser(RunAsUserStrategyOptions runAsUser) {
        this.runAsUser = runAsUser;
    }

    @JsonProperty("runtimeClass")
    public RuntimeClassStrategyOptions getRuntimeClass() {
        return runtimeClass;
    }

    @JsonProperty("runtimeClass")
    public void setRuntimeClass(RuntimeClassStrategyOptions runtimeClass) {
        this.runtimeClass = runtimeClass;
    }

    @JsonProperty("seLinux")
    public SELinuxStrategyOptions getSeLinux() {
        return seLinux;
    }

    @JsonProperty("seLinux")
    public void setSeLinux(SELinuxStrategyOptions seLinux) {
        this.seLinux = seLinux;
    }

    @JsonProperty("supplementalGroups")
    public SupplementalGroupsStrategyOptions getSupplementalGroups() {
        return supplementalGroups;
    }

    @JsonProperty("supplementalGroups")
    public void setSupplementalGroups(SupplementalGroupsStrategyOptions supplementalGroups) {
        this.supplementalGroups = supplementalGroups;
    }

    @JsonProperty("volumes")
    public List<String> getVolumes() {
        return volumes;
    }

    @JsonProperty("volumes")
    public void setVolumes(List<String> volumes) {
        this.volumes = volumes;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
