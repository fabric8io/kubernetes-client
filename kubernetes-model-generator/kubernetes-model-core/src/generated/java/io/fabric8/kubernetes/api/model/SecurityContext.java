
package io.fabric8.kubernetes.api.model;

import java.util.LinkedHashMap;
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
 * SecurityContext holds security configuration that will be applied to a container. Some fields are present in both SecurityContext and PodSecurityContext.  When both are set, the values in SecurityContext take precedence.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "allowPrivilegeEscalation",
    "appArmorProfile",
    "capabilities",
    "privileged",
    "procMount",
    "readOnlyRootFilesystem",
    "runAsGroup",
    "runAsNonRoot",
    "runAsUser",
    "seLinuxOptions",
    "seccompProfile",
    "windowsOptions"
})
@Buildable(editableEnabled = false, validationEnabled = false, generateBuilderPackage = false, lazyCollectionInitEnabled = false, builderPackage = "io.fabric8.kubernetes.api.builder")
@Generated("io.fabric8.kubernetes.schema.generator.model.ModelGenerator")
public class SecurityContext implements Editable<SecurityContextBuilder>, KubernetesResource
{

    @JsonProperty("allowPrivilegeEscalation")
    private Boolean allowPrivilegeEscalation;
    @JsonProperty("appArmorProfile")
    private AppArmorProfile appArmorProfile;
    @JsonProperty("capabilities")
    private Capabilities capabilities;
    @JsonProperty("privileged")
    private Boolean privileged;
    @JsonProperty("procMount")
    private String procMount;
    @JsonProperty("readOnlyRootFilesystem")
    private Boolean readOnlyRootFilesystem;
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
    @JsonProperty("windowsOptions")
    private WindowsSecurityContextOptions windowsOptions;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public SecurityContext() {
    }

    public SecurityContext(Boolean allowPrivilegeEscalation, AppArmorProfile appArmorProfile, Capabilities capabilities, Boolean privileged, String procMount, Boolean readOnlyRootFilesystem, Long runAsGroup, Boolean runAsNonRoot, Long runAsUser, SELinuxOptions seLinuxOptions, SeccompProfile seccompProfile, WindowsSecurityContextOptions windowsOptions) {
        super();
        this.allowPrivilegeEscalation = allowPrivilegeEscalation;
        this.appArmorProfile = appArmorProfile;
        this.capabilities = capabilities;
        this.privileged = privileged;
        this.procMount = procMount;
        this.readOnlyRootFilesystem = readOnlyRootFilesystem;
        this.runAsGroup = runAsGroup;
        this.runAsNonRoot = runAsNonRoot;
        this.runAsUser = runAsUser;
        this.seLinuxOptions = seLinuxOptions;
        this.seccompProfile = seccompProfile;
        this.windowsOptions = windowsOptions;
    }

    /**
     * AllowPrivilegeEscalation controls whether a process can gain more privileges than its parent process. This bool directly controls if the no_new_privs flag will be set on the container process. AllowPrivilegeEscalation is true always when the container is: 1) run as Privileged 2) has CAP_SYS_ADMIN Note that this field cannot be set when spec.os.name is windows.
     */
    @JsonProperty("allowPrivilegeEscalation")
    public Boolean getAllowPrivilegeEscalation() {
        return allowPrivilegeEscalation;
    }

    /**
     * AllowPrivilegeEscalation controls whether a process can gain more privileges than its parent process. This bool directly controls if the no_new_privs flag will be set on the container process. AllowPrivilegeEscalation is true always when the container is: 1) run as Privileged 2) has CAP_SYS_ADMIN Note that this field cannot be set when spec.os.name is windows.
     */
    @JsonProperty("allowPrivilegeEscalation")
    public void setAllowPrivilegeEscalation(Boolean allowPrivilegeEscalation) {
        this.allowPrivilegeEscalation = allowPrivilegeEscalation;
    }

    /**
     * SecurityContext holds security configuration that will be applied to a container. Some fields are present in both SecurityContext and PodSecurityContext.  When both are set, the values in SecurityContext take precedence.
     */
    @JsonProperty("appArmorProfile")
    public AppArmorProfile getAppArmorProfile() {
        return appArmorProfile;
    }

    /**
     * SecurityContext holds security configuration that will be applied to a container. Some fields are present in both SecurityContext and PodSecurityContext.  When both are set, the values in SecurityContext take precedence.
     */
    @JsonProperty("appArmorProfile")
    public void setAppArmorProfile(AppArmorProfile appArmorProfile) {
        this.appArmorProfile = appArmorProfile;
    }

    /**
     * SecurityContext holds security configuration that will be applied to a container. Some fields are present in both SecurityContext and PodSecurityContext.  When both are set, the values in SecurityContext take precedence.
     */
    @JsonProperty("capabilities")
    public Capabilities getCapabilities() {
        return capabilities;
    }

    /**
     * SecurityContext holds security configuration that will be applied to a container. Some fields are present in both SecurityContext and PodSecurityContext.  When both are set, the values in SecurityContext take precedence.
     */
    @JsonProperty("capabilities")
    public void setCapabilities(Capabilities capabilities) {
        this.capabilities = capabilities;
    }

    /**
     * Run container in privileged mode. Processes in privileged containers are essentially equivalent to root on the host. Defaults to false. Note that this field cannot be set when spec.os.name is windows.
     */
    @JsonProperty("privileged")
    public Boolean getPrivileged() {
        return privileged;
    }

    /**
     * Run container in privileged mode. Processes in privileged containers are essentially equivalent to root on the host. Defaults to false. Note that this field cannot be set when spec.os.name is windows.
     */
    @JsonProperty("privileged")
    public void setPrivileged(Boolean privileged) {
        this.privileged = privileged;
    }

    /**
     * procMount denotes the type of proc mount to use for the containers. The default value is Default which uses the container runtime defaults for readonly paths and masked paths. Note that this field cannot be set when spec.os.name is windows.
     */
    @JsonProperty("procMount")
    public String getProcMount() {
        return procMount;
    }

    /**
     * procMount denotes the type of proc mount to use for the containers. The default value is Default which uses the container runtime defaults for readonly paths and masked paths. Note that this field cannot be set when spec.os.name is windows.
     */
    @JsonProperty("procMount")
    public void setProcMount(String procMount) {
        this.procMount = procMount;
    }

    /**
     * Whether this container has a read-only root filesystem. Default is false. Note that this field cannot be set when spec.os.name is windows.
     */
    @JsonProperty("readOnlyRootFilesystem")
    public Boolean getReadOnlyRootFilesystem() {
        return readOnlyRootFilesystem;
    }

    /**
     * Whether this container has a read-only root filesystem. Default is false. Note that this field cannot be set when spec.os.name is windows.
     */
    @JsonProperty("readOnlyRootFilesystem")
    public void setReadOnlyRootFilesystem(Boolean readOnlyRootFilesystem) {
        this.readOnlyRootFilesystem = readOnlyRootFilesystem;
    }

    /**
     * The GID to run the entrypoint of the container process. Uses runtime default if unset. May also be set in PodSecurityContext.  If set in both SecurityContext and PodSecurityContext, the value specified in SecurityContext takes precedence. Note that this field cannot be set when spec.os.name is windows.
     */
    @JsonProperty("runAsGroup")
    public Long getRunAsGroup() {
        return runAsGroup;
    }

    /**
     * The GID to run the entrypoint of the container process. Uses runtime default if unset. May also be set in PodSecurityContext.  If set in both SecurityContext and PodSecurityContext, the value specified in SecurityContext takes precedence. Note that this field cannot be set when spec.os.name is windows.
     */
    @JsonProperty("runAsGroup")
    public void setRunAsGroup(Long runAsGroup) {
        this.runAsGroup = runAsGroup;
    }

    /**
     * Indicates that the container must run as a non-root user. If true, the Kubelet will validate the image at runtime to ensure that it does not run as UID 0 (root) and fail to start the container if it does. If unset or false, no such validation will be performed. May also be set in PodSecurityContext.  If set in both SecurityContext and PodSecurityContext, the value specified in SecurityContext takes precedence.
     */
    @JsonProperty("runAsNonRoot")
    public Boolean getRunAsNonRoot() {
        return runAsNonRoot;
    }

    /**
     * Indicates that the container must run as a non-root user. If true, the Kubelet will validate the image at runtime to ensure that it does not run as UID 0 (root) and fail to start the container if it does. If unset or false, no such validation will be performed. May also be set in PodSecurityContext.  If set in both SecurityContext and PodSecurityContext, the value specified in SecurityContext takes precedence.
     */
    @JsonProperty("runAsNonRoot")
    public void setRunAsNonRoot(Boolean runAsNonRoot) {
        this.runAsNonRoot = runAsNonRoot;
    }

    /**
     * The UID to run the entrypoint of the container process. Defaults to user specified in image metadata if unspecified. May also be set in PodSecurityContext.  If set in both SecurityContext and PodSecurityContext, the value specified in SecurityContext takes precedence. Note that this field cannot be set when spec.os.name is windows.
     */
    @JsonProperty("runAsUser")
    public Long getRunAsUser() {
        return runAsUser;
    }

    /**
     * The UID to run the entrypoint of the container process. Defaults to user specified in image metadata if unspecified. May also be set in PodSecurityContext.  If set in both SecurityContext and PodSecurityContext, the value specified in SecurityContext takes precedence. Note that this field cannot be set when spec.os.name is windows.
     */
    @JsonProperty("runAsUser")
    public void setRunAsUser(Long runAsUser) {
        this.runAsUser = runAsUser;
    }

    /**
     * SecurityContext holds security configuration that will be applied to a container. Some fields are present in both SecurityContext and PodSecurityContext.  When both are set, the values in SecurityContext take precedence.
     */
    @JsonProperty("seLinuxOptions")
    public SELinuxOptions getSeLinuxOptions() {
        return seLinuxOptions;
    }

    /**
     * SecurityContext holds security configuration that will be applied to a container. Some fields are present in both SecurityContext and PodSecurityContext.  When both are set, the values in SecurityContext take precedence.
     */
    @JsonProperty("seLinuxOptions")
    public void setSeLinuxOptions(SELinuxOptions seLinuxOptions) {
        this.seLinuxOptions = seLinuxOptions;
    }

    /**
     * SecurityContext holds security configuration that will be applied to a container. Some fields are present in both SecurityContext and PodSecurityContext.  When both are set, the values in SecurityContext take precedence.
     */
    @JsonProperty("seccompProfile")
    public SeccompProfile getSeccompProfile() {
        return seccompProfile;
    }

    /**
     * SecurityContext holds security configuration that will be applied to a container. Some fields are present in both SecurityContext and PodSecurityContext.  When both are set, the values in SecurityContext take precedence.
     */
    @JsonProperty("seccompProfile")
    public void setSeccompProfile(SeccompProfile seccompProfile) {
        this.seccompProfile = seccompProfile;
    }

    /**
     * SecurityContext holds security configuration that will be applied to a container. Some fields are present in both SecurityContext and PodSecurityContext.  When both are set, the values in SecurityContext take precedence.
     */
    @JsonProperty("windowsOptions")
    public WindowsSecurityContextOptions getWindowsOptions() {
        return windowsOptions;
    }

    /**
     * SecurityContext holds security configuration that will be applied to a container. Some fields are present in both SecurityContext and PodSecurityContext.  When both are set, the values in SecurityContext take precedence.
     */
    @JsonProperty("windowsOptions")
    public void setWindowsOptions(WindowsSecurityContextOptions windowsOptions) {
        this.windowsOptions = windowsOptions;
    }

    @JsonIgnore
    public SecurityContextBuilder edit() {
        return new SecurityContextBuilder(this);
    }

    @JsonIgnore
    public SecurityContextBuilder toBuilder() {
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
        if (!(o instanceof SecurityContext)) {
            return false;
        }
        SecurityContext other = (SecurityContext) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$allowPrivilegeEscalation = this.getAllowPrivilegeEscalation();
        Object other$allowPrivilegeEscalation = other.getAllowPrivilegeEscalation();
        if (this$allowPrivilegeEscalation == null ? other$allowPrivilegeEscalation != null : !this$allowPrivilegeEscalation.equals(other$allowPrivilegeEscalation)) {
            return false;
        }
        Object this$appArmorProfile = this.getAppArmorProfile();
        Object other$appArmorProfile = other.getAppArmorProfile();
        if (this$appArmorProfile == null ? other$appArmorProfile != null : !this$appArmorProfile.equals(other$appArmorProfile)) {
            return false;
        }
        Object this$capabilities = this.getCapabilities();
        Object other$capabilities = other.getCapabilities();
        if (this$capabilities == null ? other$capabilities != null : !this$capabilities.equals(other$capabilities)) {
            return false;
        }
        Object this$privileged = this.getPrivileged();
        Object other$privileged = other.getPrivileged();
        if (this$privileged == null ? other$privileged != null : !this$privileged.equals(other$privileged)) {
            return false;
        }
        Object this$procMount = this.getProcMount();
        Object other$procMount = other.getProcMount();
        if (this$procMount == null ? other$procMount != null : !this$procMount.equals(other$procMount)) {
            return false;
        }
        Object this$readOnlyRootFilesystem = this.getReadOnlyRootFilesystem();
        Object other$readOnlyRootFilesystem = other.getReadOnlyRootFilesystem();
        if (this$readOnlyRootFilesystem == null ? other$readOnlyRootFilesystem != null : !this$readOnlyRootFilesystem.equals(other$readOnlyRootFilesystem)) {
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
        return other instanceof SecurityContext;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $allowPrivilegeEscalation = this.getAllowPrivilegeEscalation();
        result = result * prime + ($allowPrivilegeEscalation == null ? 43 : $allowPrivilegeEscalation.hashCode());
        Object $appArmorProfile = this.getAppArmorProfile();
        result = result * prime + ($appArmorProfile == null ? 43 : $appArmorProfile.hashCode());
        Object $capabilities = this.getCapabilities();
        result = result * prime + ($capabilities == null ? 43 : $capabilities.hashCode());
        Object $privileged = this.getPrivileged();
        result = result * prime + ($privileged == null ? 43 : $privileged.hashCode());
        Object $procMount = this.getProcMount();
        result = result * prime + ($procMount == null ? 43 : $procMount.hashCode());
        Object $readOnlyRootFilesystem = this.getReadOnlyRootFilesystem();
        result = result * prime + ($readOnlyRootFilesystem == null ? 43 : $readOnlyRootFilesystem.hashCode());
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
        Object $windowsOptions = this.getWindowsOptions();
        result = result * prime + ($windowsOptions == null ? 43 : $windowsOptions.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "SecurityContext(" + "allowPrivilegeEscalation=" + this.getAllowPrivilegeEscalation() + ", appArmorProfile=" + this.getAppArmorProfile() + ", capabilities=" + this.getCapabilities() + ", privileged=" + this.getPrivileged() + ", procMount=" + this.getProcMount() + ", readOnlyRootFilesystem=" + this.getReadOnlyRootFilesystem() + ", runAsGroup=" + this.getRunAsGroup() + ", runAsNonRoot=" + this.getRunAsNonRoot() + ", runAsUser=" + this.getRunAsUser() + ", seLinuxOptions=" + this.getSeLinuxOptions() + ", seccompProfile=" + this.getSeccompProfile() + ", windowsOptions=" + this.getWindowsOptions() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
