
package io.fabric8.openshift.api.model;

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
import io.fabric8.kubernetes.api.model.HasMetadata;
import io.fabric8.kubernetes.api.model.IntOrString;
import io.fabric8.kubernetes.api.model.LabelSelector;
import io.fabric8.kubernetes.api.model.LocalObjectReference;
import io.fabric8.kubernetes.api.model.ObjectReference;
import io.fabric8.kubernetes.api.model.PersistentVolumeClaim;
import io.fabric8.kubernetes.api.model.PodTemplateSpec;
import io.fabric8.kubernetes.api.model.ResourceRequirements;
import io.fabric8.kubernetes.model.annotation.Group;
import io.fabric8.kubernetes.model.annotation.Version;
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;
import io.sundr.transform.annotations.TemplateTransformation;
import io.sundr.transform.annotations.TemplateTransformations;
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
    "users",
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
    @BuildableReference(io.fabric8.kubernetes.api.model.ObjectMeta.class),
    @BuildableReference(LabelSelector.class),
    @BuildableReference(Container.class),
    @BuildableReference(PodTemplateSpec.class),
    @BuildableReference(ResourceRequirements.class),
    @BuildableReference(IntOrString.class),
    @BuildableReference(ObjectReference.class),
    @BuildableReference(LocalObjectReference.class),
    @BuildableReference(PersistentVolumeClaim.class)
})
@TemplateTransformations({
    @TemplateTransformation(value = "/manifest.vm", outputPath = "META-INF/services/io.fabric8.kubernetes.api.model.KubernetesResource", gather = true)
})
@Version("v1")
@Group("security.openshift.io")
@Generated("jsonschema2pojo")
public class SecurityContextConstraints implements HasMetadata
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
    private List<String> allowedCapabilities = new ArrayList<String>();
    @JsonProperty("allowedFlexVolumes")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<AllowedFlexVolume> allowedFlexVolumes = new ArrayList<AllowedFlexVolume>();
    @JsonProperty("allowedUnsafeSysctls")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> allowedUnsafeSysctls = new ArrayList<String>();
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("apiVersion")
    private String apiVersion = "security.openshift.io/v1";
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
    @JsonProperty("groups")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> groups = new ArrayList<String>();
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("kind")
    private String kind = "SecurityContextConstraints";
    @JsonProperty("metadata")
    private io.fabric8.kubernetes.api.model.ObjectMeta metadata;
    @JsonProperty("priority")
    private Integer priority;
    @JsonProperty("readOnlyRootFilesystem")
    private Boolean readOnlyRootFilesystem;
    @JsonProperty("requiredDropCapabilities")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> requiredDropCapabilities = new ArrayList<String>();
    @JsonProperty("runAsUser")
    private RunAsUserStrategyOptions runAsUser;
    @JsonProperty("seLinuxContext")
    private SELinuxContextStrategyOptions seLinuxContext;
    @JsonProperty("seccompProfiles")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> seccompProfiles = new ArrayList<String>();
    @JsonProperty("supplementalGroups")
    private SupplementalGroupsStrategyOptions supplementalGroups;
    @JsonProperty("users")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> users = new ArrayList<String>();
    @JsonProperty("volumes")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> volumes = new ArrayList<String>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public SecurityContextConstraints() {
    }

    public SecurityContextConstraints(Boolean allowHostDirVolumePlugin, Boolean allowHostIPC, Boolean allowHostNetwork, Boolean allowHostPID, Boolean allowHostPorts, Boolean allowPrivilegeEscalation, Boolean allowPrivilegedContainer, List<String> allowedCapabilities, List<AllowedFlexVolume> allowedFlexVolumes, List<String> allowedUnsafeSysctls, String apiVersion, List<String> defaultAddCapabilities, Boolean defaultAllowPrivilegeEscalation, List<String> forbiddenSysctls, FSGroupStrategyOptions fsGroup, List<String> groups, String kind, io.fabric8.kubernetes.api.model.ObjectMeta metadata, Integer priority, Boolean readOnlyRootFilesystem, List<String> requiredDropCapabilities, RunAsUserStrategyOptions runAsUser, SELinuxContextStrategyOptions seLinuxContext, List<String> seccompProfiles, SupplementalGroupsStrategyOptions supplementalGroups, List<String> users, List<String> volumes) {
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
        this.users = users;
        this.volumes = volumes;
    }

    @JsonProperty("allowHostDirVolumePlugin")
    public Boolean getAllowHostDirVolumePlugin() {
        return allowHostDirVolumePlugin;
    }

    @JsonProperty("allowHostDirVolumePlugin")
    public void setAllowHostDirVolumePlugin(Boolean allowHostDirVolumePlugin) {
        this.allowHostDirVolumePlugin = allowHostDirVolumePlugin;
    }

    @JsonProperty("allowHostIPC")
    public Boolean getAllowHostIPC() {
        return allowHostIPC;
    }

    @JsonProperty("allowHostIPC")
    public void setAllowHostIPC(Boolean allowHostIPC) {
        this.allowHostIPC = allowHostIPC;
    }

    @JsonProperty("allowHostNetwork")
    public Boolean getAllowHostNetwork() {
        return allowHostNetwork;
    }

    @JsonProperty("allowHostNetwork")
    public void setAllowHostNetwork(Boolean allowHostNetwork) {
        this.allowHostNetwork = allowHostNetwork;
    }

    @JsonProperty("allowHostPID")
    public Boolean getAllowHostPID() {
        return allowHostPID;
    }

    @JsonProperty("allowHostPID")
    public void setAllowHostPID(Boolean allowHostPID) {
        this.allowHostPID = allowHostPID;
    }

    @JsonProperty("allowHostPorts")
    public Boolean getAllowHostPorts() {
        return allowHostPorts;
    }

    @JsonProperty("allowHostPorts")
    public void setAllowHostPorts(Boolean allowHostPorts) {
        this.allowHostPorts = allowHostPorts;
    }

    @JsonProperty("allowPrivilegeEscalation")
    public Boolean getAllowPrivilegeEscalation() {
        return allowPrivilegeEscalation;
    }

    @JsonProperty("allowPrivilegeEscalation")
    public void setAllowPrivilegeEscalation(Boolean allowPrivilegeEscalation) {
        this.allowPrivilegeEscalation = allowPrivilegeEscalation;
    }

    @JsonProperty("allowPrivilegedContainer")
    public Boolean getAllowPrivilegedContainer() {
        return allowPrivilegedContainer;
    }

    @JsonProperty("allowPrivilegedContainer")
    public void setAllowPrivilegedContainer(Boolean allowPrivilegedContainer) {
        this.allowPrivilegedContainer = allowPrivilegedContainer;
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

    @JsonProperty("allowedUnsafeSysctls")
    public List<String> getAllowedUnsafeSysctls() {
        return allowedUnsafeSysctls;
    }

    @JsonProperty("allowedUnsafeSysctls")
    public void setAllowedUnsafeSysctls(List<String> allowedUnsafeSysctls) {
        this.allowedUnsafeSysctls = allowedUnsafeSysctls;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("apiVersion")
    public String getApiVersion() {
        return apiVersion;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("apiVersion")
    public void setApiVersion(String apiVersion) {
        this.apiVersion = apiVersion;
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

    @JsonProperty("groups")
    public List<String> getGroups() {
        return groups;
    }

    @JsonProperty("groups")
    public void setGroups(List<String> groups) {
        this.groups = groups;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("kind")
    public String getKind() {
        return kind;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("kind")
    public void setKind(String kind) {
        this.kind = kind;
    }

    @JsonProperty("metadata")
    public io.fabric8.kubernetes.api.model.ObjectMeta getMetadata() {
        return metadata;
    }

    @JsonProperty("metadata")
    public void setMetadata(io.fabric8.kubernetes.api.model.ObjectMeta metadata) {
        this.metadata = metadata;
    }

    @JsonProperty("priority")
    public Integer getPriority() {
        return priority;
    }

    @JsonProperty("priority")
    public void setPriority(Integer priority) {
        this.priority = priority;
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

    @JsonProperty("runAsUser")
    public RunAsUserStrategyOptions getRunAsUser() {
        return runAsUser;
    }

    @JsonProperty("runAsUser")
    public void setRunAsUser(RunAsUserStrategyOptions runAsUser) {
        this.runAsUser = runAsUser;
    }

    @JsonProperty("seLinuxContext")
    public SELinuxContextStrategyOptions getSeLinuxContext() {
        return seLinuxContext;
    }

    @JsonProperty("seLinuxContext")
    public void setSeLinuxContext(SELinuxContextStrategyOptions seLinuxContext) {
        this.seLinuxContext = seLinuxContext;
    }

    @JsonProperty("seccompProfiles")
    public List<String> getSeccompProfiles() {
        return seccompProfiles;
    }

    @JsonProperty("seccompProfiles")
    public void setSeccompProfiles(List<String> seccompProfiles) {
        this.seccompProfiles = seccompProfiles;
    }

    @JsonProperty("supplementalGroups")
    public SupplementalGroupsStrategyOptions getSupplementalGroups() {
        return supplementalGroups;
    }

    @JsonProperty("supplementalGroups")
    public void setSupplementalGroups(SupplementalGroupsStrategyOptions supplementalGroups) {
        this.supplementalGroups = supplementalGroups;
    }

    @JsonProperty("users")
    public List<String> getUsers() {
        return users;
    }

    @JsonProperty("users")
    public void setUsers(List<String> users) {
        this.users = users;
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
