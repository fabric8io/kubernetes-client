
package io.fabric8.certmanager.api.model.acme.v1;

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
import io.fabric8.kubernetes.api.model.SELinuxOptions;
import io.fabric8.kubernetes.api.model.SeccompProfile;
import io.fabric8.kubernetes.api.model.Sysctl;
import io.fabric8.kubernetes.api.model.Volume;
import io.fabric8.kubernetes.api.model.VolumeMount;
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;

@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "fsGroup",
    "fsGroupChangePolicy",
    "runAsGroup",
    "runAsNonRoot",
    "runAsUser",
    "seLinuxOptions",
    "seccompProfile",
    "supplementalGroups",
    "sysctls"
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
public class ACMEChallengeSolverHTTP01IngressPodSecurityContext implements Editable<ACMEChallengeSolverHTTP01IngressPodSecurityContextBuilder>, KubernetesResource
{

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
    @JsonProperty("seLinuxOptions")
    private SELinuxOptions seLinuxOptions;
    @JsonProperty("seccompProfile")
    private SeccompProfile seccompProfile;
    @JsonProperty("supplementalGroups")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<Long> supplementalGroups = new ArrayList<>();
    @JsonProperty("sysctls")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<Sysctl> sysctls = new ArrayList<>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public ACMEChallengeSolverHTTP01IngressPodSecurityContext() {
    }

    public ACMEChallengeSolverHTTP01IngressPodSecurityContext(Long fsGroup, String fsGroupChangePolicy, Long runAsGroup, Boolean runAsNonRoot, Long runAsUser, SELinuxOptions seLinuxOptions, SeccompProfile seccompProfile, List<Long> supplementalGroups, List<Sysctl> sysctls) {
        super();
        this.fsGroup = fsGroup;
        this.fsGroupChangePolicy = fsGroupChangePolicy;
        this.runAsGroup = runAsGroup;
        this.runAsNonRoot = runAsNonRoot;
        this.runAsUser = runAsUser;
        this.seLinuxOptions = seLinuxOptions;
        this.seccompProfile = seccompProfile;
        this.supplementalGroups = supplementalGroups;
        this.sysctls = sysctls;
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

    @JsonProperty("seLinuxOptions")
    public SELinuxOptions getSeLinuxOptions() {
        return seLinuxOptions;
    }

    @JsonProperty("seLinuxOptions")
    public void setSeLinuxOptions(SELinuxOptions seLinuxOptions) {
        this.seLinuxOptions = seLinuxOptions;
    }

    @JsonProperty("seccompProfile")
    public SeccompProfile getSeccompProfile() {
        return seccompProfile;
    }

    @JsonProperty("seccompProfile")
    public void setSeccompProfile(SeccompProfile seccompProfile) {
        this.seccompProfile = seccompProfile;
    }

    /**
     * A list of groups applied to the first process run in each container, in addition to the container's primary GID, the fsGroup (if specified), and group memberships defined in the container image for the uid of the container process. If unspecified, no additional groups are added to any container. Note that group memberships defined in the container image for the uid of the container process are still effective, even if they are not included in this list. Note that this field cannot be set when spec.os.name is windows.
     */
    @JsonProperty("supplementalGroups")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<Long> getSupplementalGroups() {
        return supplementalGroups;
    }

    /**
     * A list of groups applied to the first process run in each container, in addition to the container's primary GID, the fsGroup (if specified), and group memberships defined in the container image for the uid of the container process. If unspecified, no additional groups are added to any container. Note that group memberships defined in the container image for the uid of the container process are still effective, even if they are not included in this list. Note that this field cannot be set when spec.os.name is windows.
     */
    @JsonProperty("supplementalGroups")
    public void setSupplementalGroups(List<Long> supplementalGroups) {
        this.supplementalGroups = supplementalGroups;
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

    @JsonIgnore
    public ACMEChallengeSolverHTTP01IngressPodSecurityContextBuilder edit() {
        return new ACMEChallengeSolverHTTP01IngressPodSecurityContextBuilder(this);
    }

    @JsonIgnore
    public ACMEChallengeSolverHTTP01IngressPodSecurityContextBuilder toBuilder() {
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
        if (!(o instanceof ACMEChallengeSolverHTTP01IngressPodSecurityContext)) {
            return false;
        }
        ACMEChallengeSolverHTTP01IngressPodSecurityContext other = (ACMEChallengeSolverHTTP01IngressPodSecurityContext) o;
        if (!other.canEqual(this)) {
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
        Object this$sysctls = this.getSysctls();
        Object other$sysctls = other.getSysctls();
        if (this$sysctls == null ? other$sysctls != null : !this$sysctls.equals(other$sysctls)) {
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
        return other instanceof ACMEChallengeSolverHTTP01IngressPodSecurityContext;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
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
        Object $seLinuxOptions = this.getSeLinuxOptions();
        result = result * prime + ($seLinuxOptions == null ? 43 : $seLinuxOptions.hashCode());
        Object $seccompProfile = this.getSeccompProfile();
        result = result * prime + ($seccompProfile == null ? 43 : $seccompProfile.hashCode());
        Object $supplementalGroups = this.getSupplementalGroups();
        result = result * prime + ($supplementalGroups == null ? 43 : $supplementalGroups.hashCode());
        Object $sysctls = this.getSysctls();
        result = result * prime + ($sysctls == null ? 43 : $sysctls.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "ACMEChallengeSolverHTTP01IngressPodSecurityContext(" + "fsGroup=" + this.getFsGroup() + ", fsGroupChangePolicy=" + this.getFsGroupChangePolicy() + ", runAsGroup=" + this.getRunAsGroup() + ", runAsNonRoot=" + this.getRunAsNonRoot() + ", runAsUser=" + this.getRunAsUser() + ", seLinuxOptions=" + this.getSeLinuxOptions() + ", seccompProfile=" + this.getSeccompProfile() + ", supplementalGroups=" + this.getSupplementalGroups() + ", sysctls=" + this.getSysctls() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
