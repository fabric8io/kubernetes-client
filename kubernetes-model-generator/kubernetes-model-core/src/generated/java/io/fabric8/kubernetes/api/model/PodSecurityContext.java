
package io.fabric8.kubernetes.api.model;

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
import io.sundr.builder.annotations.Buildable;

/**
 * PodSecurityContext holds pod-level security attributes and common container settings. Some fields are also present in container.securityContext.  Field values of container.securityContext take precedence over field values of PodSecurityContext.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "appArmorProfile",
    "fsGroup",
    "fsGroupChangePolicy",
    "runAsGroup",
    "runAsNonRoot",
    "runAsUser",
    "seLinuxChangePolicy",
    "seLinuxOptions",
    "seccompProfile",
    "supplementalGroups",
    "supplementalGroupsPolicy",
    "sysctls",
    "windowsOptions"
})
@Buildable(editableEnabled = false, validationEnabled = false, generateBuilderPackage = false, lazyCollectionInitEnabled = false, builderPackage = "io.fabric8.kubernetes.api.builder")
@Generated("io.fabric8.kubernetes.schema.generator.model.ModelGenerator")
public class PodSecurityContext implements Editable<PodSecurityContextBuilder>, KubernetesResource
{

    @JsonProperty("appArmorProfile")
    private AppArmorProfile appArmorProfile;
    @JsonProperty("fsGroup")
    private Long fsGroup;
    @JsonProperty("fsGroupChangePolicy")
    private String fsGroupChangePolicy;
    @JsonProperty("runAsGroup")
    private Long runAsGroup;
    @JsonProperty("runAsNonRoot")
    private Boolean runAsNonRoot;
    @JsonProperty("runAsUser")
    private Long runAsUser;
    @JsonProperty("seLinuxChangePolicy")
    private String seLinuxChangePolicy;
    @JsonProperty("seLinuxOptions")
    private SELinuxOptions seLinuxOptions;
    @JsonProperty("seccompProfile")
    private SeccompProfile seccompProfile;
    @JsonProperty("supplementalGroups")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<Long> supplementalGroups = new ArrayList<>();
    @JsonProperty("supplementalGroupsPolicy")
    private String supplementalGroupsPolicy;
    @JsonProperty("sysctls")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<Sysctl> sysctls = new ArrayList<>();
    @JsonProperty("windowsOptions")
    private WindowsSecurityContextOptions windowsOptions;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public PodSecurityContext() {
    }

    public PodSecurityContext(AppArmorProfile appArmorProfile, Long fsGroup, String fsGroupChangePolicy, Long runAsGroup, Boolean runAsNonRoot, Long runAsUser, String seLinuxChangePolicy, SELinuxOptions seLinuxOptions, SeccompProfile seccompProfile, List<Long> supplementalGroups, String supplementalGroupsPolicy, List<Sysctl> sysctls, WindowsSecurityContextOptions windowsOptions) {
        super();
        this.appArmorProfile = appArmorProfile;
        this.fsGroup = fsGroup;
        this.fsGroupChangePolicy = fsGroupChangePolicy;
        this.runAsGroup = runAsGroup;
        this.runAsNonRoot = runAsNonRoot;
        this.runAsUser = runAsUser;
        this.seLinuxChangePolicy = seLinuxChangePolicy;
        this.seLinuxOptions = seLinuxOptions;
        this.seccompProfile = seccompProfile;
        this.supplementalGroups = supplementalGroups;
        this.supplementalGroupsPolicy = supplementalGroupsPolicy;
        this.sysctls = sysctls;
        this.windowsOptions = windowsOptions;
    }

    /**
     * PodSecurityContext holds pod-level security attributes and common container settings. Some fields are also present in container.securityContext.  Field values of container.securityContext take precedence over field values of PodSecurityContext.
     */
    @JsonProperty("appArmorProfile")
    public AppArmorProfile getAppArmorProfile() {
        return appArmorProfile;
    }

    /**
     * PodSecurityContext holds pod-level security attributes and common container settings. Some fields are also present in container.securityContext.  Field values of container.securityContext take precedence over field values of PodSecurityContext.
     */
    @JsonProperty("appArmorProfile")
    public void setAppArmorProfile(AppArmorProfile appArmorProfile) {
        this.appArmorProfile = appArmorProfile;
    }

    /**
     * A special supplemental group that applies to all containers in a pod. Some volume types allow the Kubelet to change the ownership of that volume to be owned by the pod:<br><p> <br><p> 1. The owning GID will be the FSGroup 2. The setgid bit is set (new files created in the volume will be owned by FSGroup) 3. The permission bits are OR'd with rw-rw----<br><p> <br><p> If unset, the Kubelet will not modify the ownership and permissions of any volume. Note that this field cannot be set when spec.os.name is windows.
     */
    @JsonProperty("fsGroup")
    public Long getFsGroup() {
        return fsGroup;
    }

    /**
     * A special supplemental group that applies to all containers in a pod. Some volume types allow the Kubelet to change the ownership of that volume to be owned by the pod:<br><p> <br><p> 1. The owning GID will be the FSGroup 2. The setgid bit is set (new files created in the volume will be owned by FSGroup) 3. The permission bits are OR'd with rw-rw----<br><p> <br><p> If unset, the Kubelet will not modify the ownership and permissions of any volume. Note that this field cannot be set when spec.os.name is windows.
     */
    @JsonProperty("fsGroup")
    public void setFsGroup(Long fsGroup) {
        this.fsGroup = fsGroup;
    }

    /**
     * fsGroupChangePolicy defines behavior of changing ownership and permission of the volume before being exposed inside Pod. This field will only apply to volume types which support fsGroup based ownership(and permissions). It will have no effect on ephemeral volume types such as: secret, configmaps and emptydir. Valid values are "OnRootMismatch" and "Always". If not specified, "Always" is used. Note that this field cannot be set when spec.os.name is windows.
     */
    @JsonProperty("fsGroupChangePolicy")
    public String getFsGroupChangePolicy() {
        return fsGroupChangePolicy;
    }

    /**
     * fsGroupChangePolicy defines behavior of changing ownership and permission of the volume before being exposed inside Pod. This field will only apply to volume types which support fsGroup based ownership(and permissions). It will have no effect on ephemeral volume types such as: secret, configmaps and emptydir. Valid values are "OnRootMismatch" and "Always". If not specified, "Always" is used. Note that this field cannot be set when spec.os.name is windows.
     */
    @JsonProperty("fsGroupChangePolicy")
    public void setFsGroupChangePolicy(String fsGroupChangePolicy) {
        this.fsGroupChangePolicy = fsGroupChangePolicy;
    }

    /**
     * The GID to run the entrypoint of the container process. Uses runtime default if unset. May also be set in SecurityContext.  If set in both SecurityContext and PodSecurityContext, the value specified in SecurityContext takes precedence for that container. Note that this field cannot be set when spec.os.name is windows.
     */
    @JsonProperty("runAsGroup")
    public Long getRunAsGroup() {
        return runAsGroup;
    }

    /**
     * The GID to run the entrypoint of the container process. Uses runtime default if unset. May also be set in SecurityContext.  If set in both SecurityContext and PodSecurityContext, the value specified in SecurityContext takes precedence for that container. Note that this field cannot be set when spec.os.name is windows.
     */
    @JsonProperty("runAsGroup")
    public void setRunAsGroup(Long runAsGroup) {
        this.runAsGroup = runAsGroup;
    }

    /**
     * Indicates that the container must run as a non-root user. If true, the Kubelet will validate the image at runtime to ensure that it does not run as UID 0 (root) and fail to start the container if it does. If unset or false, no such validation will be performed. May also be set in SecurityContext.  If set in both SecurityContext and PodSecurityContext, the value specified in SecurityContext takes precedence.
     */
    @JsonProperty("runAsNonRoot")
    public Boolean getRunAsNonRoot() {
        return runAsNonRoot;
    }

    /**
     * Indicates that the container must run as a non-root user. If true, the Kubelet will validate the image at runtime to ensure that it does not run as UID 0 (root) and fail to start the container if it does. If unset or false, no such validation will be performed. May also be set in SecurityContext.  If set in both SecurityContext and PodSecurityContext, the value specified in SecurityContext takes precedence.
     */
    @JsonProperty("runAsNonRoot")
    public void setRunAsNonRoot(Boolean runAsNonRoot) {
        this.runAsNonRoot = runAsNonRoot;
    }

    /**
     * The UID to run the entrypoint of the container process. Defaults to user specified in image metadata if unspecified. May also be set in SecurityContext.  If set in both SecurityContext and PodSecurityContext, the value specified in SecurityContext takes precedence for that container. Note that this field cannot be set when spec.os.name is windows.
     */
    @JsonProperty("runAsUser")
    public Long getRunAsUser() {
        return runAsUser;
    }

    /**
     * The UID to run the entrypoint of the container process. Defaults to user specified in image metadata if unspecified. May also be set in SecurityContext.  If set in both SecurityContext and PodSecurityContext, the value specified in SecurityContext takes precedence for that container. Note that this field cannot be set when spec.os.name is windows.
     */
    @JsonProperty("runAsUser")
    public void setRunAsUser(Long runAsUser) {
        this.runAsUser = runAsUser;
    }

    /**
     * seLinuxChangePolicy defines how the container's SELinux label is applied to all volumes used by the Pod. It has no effect on nodes that do not support SELinux or to volumes does not support SELinux. Valid values are "MountOption" and "Recursive".<br><p> <br><p> "Recursive" means relabeling of all files on all Pod volumes by the container runtime. This may be slow for large volumes, but allows mixing privileged and unprivileged Pods sharing the same volume on the same node.<br><p> <br><p> "MountOption" mounts all eligible Pod volumes with `-o context` mount option. This requires all Pods that share the same volume to use the same SELinux label. It is not possible to share the same volume among privileged and unprivileged Pods. Eligible volumes are in-tree FibreChannel and iSCSI volumes, and all CSI volumes whose CSI driver announces SELinux support by setting spec.seLinuxMount: true in their CSIDriver instance. Other volumes are always re-labelled recursively.<br><p> <br><p> If not specified, "MountOption" is used.<br><p> <br><p> This field affects only Pods that have SELinux label set, either in PodSecurityContext or in SecurityContext of all containers.<br><p> <br><p> All Pods that use the same volume should use the same seLinuxChangePolicy, otherwise some pods can get stuck in ContainerCreating state. Note that this field cannot be set when spec.os.name is windows.
     */
    @JsonProperty("seLinuxChangePolicy")
    public String getSeLinuxChangePolicy() {
        return seLinuxChangePolicy;
    }

    /**
     * seLinuxChangePolicy defines how the container's SELinux label is applied to all volumes used by the Pod. It has no effect on nodes that do not support SELinux or to volumes does not support SELinux. Valid values are "MountOption" and "Recursive".<br><p> <br><p> "Recursive" means relabeling of all files on all Pod volumes by the container runtime. This may be slow for large volumes, but allows mixing privileged and unprivileged Pods sharing the same volume on the same node.<br><p> <br><p> "MountOption" mounts all eligible Pod volumes with `-o context` mount option. This requires all Pods that share the same volume to use the same SELinux label. It is not possible to share the same volume among privileged and unprivileged Pods. Eligible volumes are in-tree FibreChannel and iSCSI volumes, and all CSI volumes whose CSI driver announces SELinux support by setting spec.seLinuxMount: true in their CSIDriver instance. Other volumes are always re-labelled recursively.<br><p> <br><p> If not specified, "MountOption" is used.<br><p> <br><p> This field affects only Pods that have SELinux label set, either in PodSecurityContext or in SecurityContext of all containers.<br><p> <br><p> All Pods that use the same volume should use the same seLinuxChangePolicy, otherwise some pods can get stuck in ContainerCreating state. Note that this field cannot be set when spec.os.name is windows.
     */
    @JsonProperty("seLinuxChangePolicy")
    public void setSeLinuxChangePolicy(String seLinuxChangePolicy) {
        this.seLinuxChangePolicy = seLinuxChangePolicy;
    }

    /**
     * PodSecurityContext holds pod-level security attributes and common container settings. Some fields are also present in container.securityContext.  Field values of container.securityContext take precedence over field values of PodSecurityContext.
     */
    @JsonProperty("seLinuxOptions")
    public SELinuxOptions getSeLinuxOptions() {
        return seLinuxOptions;
    }

    /**
     * PodSecurityContext holds pod-level security attributes and common container settings. Some fields are also present in container.securityContext.  Field values of container.securityContext take precedence over field values of PodSecurityContext.
     */
    @JsonProperty("seLinuxOptions")
    public void setSeLinuxOptions(SELinuxOptions seLinuxOptions) {
        this.seLinuxOptions = seLinuxOptions;
    }

    /**
     * PodSecurityContext holds pod-level security attributes and common container settings. Some fields are also present in container.securityContext.  Field values of container.securityContext take precedence over field values of PodSecurityContext.
     */
    @JsonProperty("seccompProfile")
    public SeccompProfile getSeccompProfile() {
        return seccompProfile;
    }

    /**
     * PodSecurityContext holds pod-level security attributes and common container settings. Some fields are also present in container.securityContext.  Field values of container.securityContext take precedence over field values of PodSecurityContext.
     */
    @JsonProperty("seccompProfile")
    public void setSeccompProfile(SeccompProfile seccompProfile) {
        this.seccompProfile = seccompProfile;
    }

    /**
     * A list of groups applied to the first process run in each container, in addition to the container's primary GID and fsGroup (if specified).  If the SupplementalGroupsPolicy feature is enabled, the supplementalGroupsPolicy field determines whether these are in addition to or instead of any group memberships defined in the container image. If unspecified, no additional groups are added, though group memberships defined in the container image may still be used, depending on the supplementalGroupsPolicy field. Note that this field cannot be set when spec.os.name is windows.
     */
    @JsonProperty("supplementalGroups")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<Long> getSupplementalGroups() {
        return supplementalGroups;
    }

    /**
     * A list of groups applied to the first process run in each container, in addition to the container's primary GID and fsGroup (if specified).  If the SupplementalGroupsPolicy feature is enabled, the supplementalGroupsPolicy field determines whether these are in addition to or instead of any group memberships defined in the container image. If unspecified, no additional groups are added, though group memberships defined in the container image may still be used, depending on the supplementalGroupsPolicy field. Note that this field cannot be set when spec.os.name is windows.
     */
    @JsonProperty("supplementalGroups")
    public void setSupplementalGroups(List<Long> supplementalGroups) {
        this.supplementalGroups = supplementalGroups;
    }

    /**
     * Defines how supplemental groups of the first container processes are calculated. Valid values are "Merge" and "Strict". If not specified, "Merge" is used. (Alpha) Using the field requires the SupplementalGroupsPolicy feature gate to be enabled and the container runtime must implement support for this feature. Note that this field cannot be set when spec.os.name is windows.
     */
    @JsonProperty("supplementalGroupsPolicy")
    public String getSupplementalGroupsPolicy() {
        return supplementalGroupsPolicy;
    }

    /**
     * Defines how supplemental groups of the first container processes are calculated. Valid values are "Merge" and "Strict". If not specified, "Merge" is used. (Alpha) Using the field requires the SupplementalGroupsPolicy feature gate to be enabled and the container runtime must implement support for this feature. Note that this field cannot be set when spec.os.name is windows.
     */
    @JsonProperty("supplementalGroupsPolicy")
    public void setSupplementalGroupsPolicy(String supplementalGroupsPolicy) {
        this.supplementalGroupsPolicy = supplementalGroupsPolicy;
    }

    /**
     * Sysctls hold a list of namespaced sysctls used for the pod. Pods with unsupported sysctls (by the container runtime) might fail to launch. Note that this field cannot be set when spec.os.name is windows.
     */
    @JsonProperty("sysctls")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<Sysctl> getSysctls() {
        return sysctls;
    }

    /**
     * Sysctls hold a list of namespaced sysctls used for the pod. Pods with unsupported sysctls (by the container runtime) might fail to launch. Note that this field cannot be set when spec.os.name is windows.
     */
    @JsonProperty("sysctls")
    public void setSysctls(List<Sysctl> sysctls) {
        this.sysctls = sysctls;
    }

    /**
     * PodSecurityContext holds pod-level security attributes and common container settings. Some fields are also present in container.securityContext.  Field values of container.securityContext take precedence over field values of PodSecurityContext.
     */
    @JsonProperty("windowsOptions")
    public WindowsSecurityContextOptions getWindowsOptions() {
        return windowsOptions;
    }

    /**
     * PodSecurityContext holds pod-level security attributes and common container settings. Some fields are also present in container.securityContext.  Field values of container.securityContext take precedence over field values of PodSecurityContext.
     */
    @JsonProperty("windowsOptions")
    public void setWindowsOptions(WindowsSecurityContextOptions windowsOptions) {
        this.windowsOptions = windowsOptions;
    }

    @JsonIgnore
    public PodSecurityContextBuilder edit() {
        return new PodSecurityContextBuilder(this);
    }

    @JsonIgnore
    public PodSecurityContextBuilder toBuilder() {
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
        if (!(o instanceof PodSecurityContext)) {
            return false;
        }
        PodSecurityContext other = (PodSecurityContext) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$appArmorProfile = this.getAppArmorProfile();
        Object other$appArmorProfile = other.getAppArmorProfile();
        if (this$appArmorProfile == null ? other$appArmorProfile != null : !this$appArmorProfile.equals(other$appArmorProfile)) {
            return false;
        }
        Object this$fsGroup = this.getFsGroup();
        Object other$fsGroup = other.getFsGroup();
        if (this$fsGroup == null ? other$fsGroup != null : !this$fsGroup.equals(other$fsGroup)) {
            return false;
        }
        Object this$fsGroupChangePolicy = this.getFsGroupChangePolicy();
        Object other$fsGroupChangePolicy = other.getFsGroupChangePolicy();
        if (this$fsGroupChangePolicy == null ? other$fsGroupChangePolicy != null : !this$fsGroupChangePolicy.equals(other$fsGroupChangePolicy)) {
            return false;
        }
        Object this$runAsGroup = this.getRunAsGroup();
        Object other$runAsGroup = other.getRunAsGroup();
        if (this$runAsGroup == null ? other$runAsGroup != null : !this$runAsGroup.equals(other$runAsGroup)) {
            return false;
        }
        Object this$runAsNonRoot = this.getRunAsNonRoot();
        Object other$runAsNonRoot = other.getRunAsNonRoot();
        if (this$runAsNonRoot == null ? other$runAsNonRoot != null : !this$runAsNonRoot.equals(other$runAsNonRoot)) {
            return false;
        }
        Object this$runAsUser = this.getRunAsUser();
        Object other$runAsUser = other.getRunAsUser();
        if (this$runAsUser == null ? other$runAsUser != null : !this$runAsUser.equals(other$runAsUser)) {
            return false;
        }
        Object this$seLinuxChangePolicy = this.getSeLinuxChangePolicy();
        Object other$seLinuxChangePolicy = other.getSeLinuxChangePolicy();
        if (this$seLinuxChangePolicy == null ? other$seLinuxChangePolicy != null : !this$seLinuxChangePolicy.equals(other$seLinuxChangePolicy)) {
            return false;
        }
        Object this$seLinuxOptions = this.getSeLinuxOptions();
        Object other$seLinuxOptions = other.getSeLinuxOptions();
        if (this$seLinuxOptions == null ? other$seLinuxOptions != null : !this$seLinuxOptions.equals(other$seLinuxOptions)) {
            return false;
        }
        Object this$seccompProfile = this.getSeccompProfile();
        Object other$seccompProfile = other.getSeccompProfile();
        if (this$seccompProfile == null ? other$seccompProfile != null : !this$seccompProfile.equals(other$seccompProfile)) {
            return false;
        }
        Object this$supplementalGroups = this.getSupplementalGroups();
        Object other$supplementalGroups = other.getSupplementalGroups();
        if (this$supplementalGroups == null ? other$supplementalGroups != null : !this$supplementalGroups.equals(other$supplementalGroups)) {
            return false;
        }
        Object this$supplementalGroupsPolicy = this.getSupplementalGroupsPolicy();
        Object other$supplementalGroupsPolicy = other.getSupplementalGroupsPolicy();
        if (this$supplementalGroupsPolicy == null ? other$supplementalGroupsPolicy != null : !this$supplementalGroupsPolicy.equals(other$supplementalGroupsPolicy)) {
            return false;
        }
        Object this$sysctls = this.getSysctls();
        Object other$sysctls = other.getSysctls();
        if (this$sysctls == null ? other$sysctls != null : !this$sysctls.equals(other$sysctls)) {
            return false;
        }
        Object this$windowsOptions = this.getWindowsOptions();
        Object other$windowsOptions = other.getWindowsOptions();
        if (this$windowsOptions == null ? other$windowsOptions != null : !this$windowsOptions.equals(other$windowsOptions)) {
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
        return other instanceof PodSecurityContext;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $appArmorProfile = this.getAppArmorProfile();
        result = result * prime + ($appArmorProfile == null ? 43 : $appArmorProfile.hashCode());
        Object $fsGroup = this.getFsGroup();
        result = result * prime + ($fsGroup == null ? 43 : $fsGroup.hashCode());
        Object $fsGroupChangePolicy = this.getFsGroupChangePolicy();
        result = result * prime + ($fsGroupChangePolicy == null ? 43 : $fsGroupChangePolicy.hashCode());
        Object $runAsGroup = this.getRunAsGroup();
        result = result * prime + ($runAsGroup == null ? 43 : $runAsGroup.hashCode());
        Object $runAsNonRoot = this.getRunAsNonRoot();
        result = result * prime + ($runAsNonRoot == null ? 43 : $runAsNonRoot.hashCode());
        Object $runAsUser = this.getRunAsUser();
        result = result * prime + ($runAsUser == null ? 43 : $runAsUser.hashCode());
        Object $seLinuxChangePolicy = this.getSeLinuxChangePolicy();
        result = result * prime + ($seLinuxChangePolicy == null ? 43 : $seLinuxChangePolicy.hashCode());
        Object $seLinuxOptions = this.getSeLinuxOptions();
        result = result * prime + ($seLinuxOptions == null ? 43 : $seLinuxOptions.hashCode());
        Object $seccompProfile = this.getSeccompProfile();
        result = result * prime + ($seccompProfile == null ? 43 : $seccompProfile.hashCode());
        Object $supplementalGroups = this.getSupplementalGroups();
        result = result * prime + ($supplementalGroups == null ? 43 : $supplementalGroups.hashCode());
        Object $supplementalGroupsPolicy = this.getSupplementalGroupsPolicy();
        result = result * prime + ($supplementalGroupsPolicy == null ? 43 : $supplementalGroupsPolicy.hashCode());
        Object $sysctls = this.getSysctls();
        result = result * prime + ($sysctls == null ? 43 : $sysctls.hashCode());
        Object $windowsOptions = this.getWindowsOptions();
        result = result * prime + ($windowsOptions == null ? 43 : $windowsOptions.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "PodSecurityContext(" + "appArmorProfile=" + this.getAppArmorProfile() + ", fsGroup=" + this.getFsGroup() + ", fsGroupChangePolicy=" + this.getFsGroupChangePolicy() + ", runAsGroup=" + this.getRunAsGroup() + ", runAsNonRoot=" + this.getRunAsNonRoot() + ", runAsUser=" + this.getRunAsUser() + ", seLinuxChangePolicy=" + this.getSeLinuxChangePolicy() + ", seLinuxOptions=" + this.getSeLinuxOptions() + ", seccompProfile=" + this.getSeccompProfile() + ", supplementalGroups=" + this.getSupplementalGroups() + ", supplementalGroupsPolicy=" + this.getSupplementalGroupsPolicy() + ", sysctls=" + this.getSysctls() + ", windowsOptions=" + this.getWindowsOptions() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
