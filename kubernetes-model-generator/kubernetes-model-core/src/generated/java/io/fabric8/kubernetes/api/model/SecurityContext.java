
package io.fabric8.kubernetes.api.model;

import java.util.LinkedHashMap;
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
    "allowPrivilegeEscalation",
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
@ToString
@EqualsAndHashCode
@Setter
@Accessors(prefix = {
    "_",
    ""
})
@Buildable(editableEnabled = false, validationEnabled = false, generateBuilderPackage = true, lazyCollectionInitEnabled = false, builderPackage = "io.fabric8.kubernetes.api.builder")
@Generated("jsonschema2pojo")
public class SecurityContext implements KubernetesResource
{

    @JsonProperty("allowPrivilegeEscalation")
    private Boolean allowPrivilegeEscalation;
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
     * 
     */
    public SecurityContext() {
    }

    public SecurityContext(Boolean allowPrivilegeEscalation, Capabilities capabilities, Boolean privileged, String procMount, Boolean readOnlyRootFilesystem, Long runAsGroup, Boolean runAsNonRoot, Long runAsUser, SELinuxOptions seLinuxOptions, SeccompProfile seccompProfile, WindowsSecurityContextOptions windowsOptions) {
        super();
        this.allowPrivilegeEscalation = allowPrivilegeEscalation;
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

    @JsonProperty("allowPrivilegeEscalation")
    public Boolean getAllowPrivilegeEscalation() {
        return allowPrivilegeEscalation;
    }

    @JsonProperty("allowPrivilegeEscalation")
    public void setAllowPrivilegeEscalation(Boolean allowPrivilegeEscalation) {
        this.allowPrivilegeEscalation = allowPrivilegeEscalation;
    }

    @JsonProperty("capabilities")
    public Capabilities getCapabilities() {
        return capabilities;
    }

    @JsonProperty("capabilities")
    public void setCapabilities(Capabilities capabilities) {
        this.capabilities = capabilities;
    }

    @JsonProperty("privileged")
    public Boolean getPrivileged() {
        return privileged;
    }

    @JsonProperty("privileged")
    public void setPrivileged(Boolean privileged) {
        this.privileged = privileged;
    }

    @JsonProperty("procMount")
    public String getProcMount() {
        return procMount;
    }

    @JsonProperty("procMount")
    public void setProcMount(String procMount) {
        this.procMount = procMount;
    }

    @JsonProperty("readOnlyRootFilesystem")
    public Boolean getReadOnlyRootFilesystem() {
        return readOnlyRootFilesystem;
    }

    @JsonProperty("readOnlyRootFilesystem")
    public void setReadOnlyRootFilesystem(Boolean readOnlyRootFilesystem) {
        this.readOnlyRootFilesystem = readOnlyRootFilesystem;
    }

    @JsonProperty("runAsGroup")
    public Long getRunAsGroup() {
        return runAsGroup;
    }

    @JsonProperty("runAsGroup")
    public void setRunAsGroup(Long runAsGroup) {
        this.runAsGroup = runAsGroup;
    }

    @JsonProperty("runAsNonRoot")
    public Boolean getRunAsNonRoot() {
        return runAsNonRoot;
    }

    @JsonProperty("runAsNonRoot")
    public void setRunAsNonRoot(Boolean runAsNonRoot) {
        this.runAsNonRoot = runAsNonRoot;
    }

    @JsonProperty("runAsUser")
    public Long getRunAsUser() {
        return runAsUser;
    }

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

    @JsonProperty("windowsOptions")
    public WindowsSecurityContextOptions getWindowsOptions() {
        return windowsOptions;
    }

    @JsonProperty("windowsOptions")
    public void setWindowsOptions(WindowsSecurityContextOptions windowsOptions) {
        this.windowsOptions = windowsOptions;
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
