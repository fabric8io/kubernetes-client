
package io.fabric8.openshift.api.model.monitoring.v1;

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
import io.fabric8.kubernetes.api.builder.Editable;
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
import lombok.ToString;
import lombok.experimental.Accessors;

@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
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
public class AlertmanagerSpecCSecurityContext implements Editable<AlertmanagerSpecCSecurityContextBuilder> , KubernetesResource
{

    @JsonProperty("allowPrivilegeEscalation")
    private Boolean allowPrivilegeEscalation;
    @JsonProperty("capabilities")
    private AlertmanagerSpecCSCCapabilities capabilities;
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
    private AlertmanagerSpecCSCSeLinuxOptions seLinuxOptions;
    @JsonProperty("seccompProfile")
    private AlertmanagerSpecCSCSeccompProfile seccompProfile;
    @JsonProperty("windowsOptions")
    private AlertmanagerSpecCSCWindowsOptions windowsOptions;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public AlertmanagerSpecCSecurityContext() {
    }

    public AlertmanagerSpecCSecurityContext(Boolean allowPrivilegeEscalation, AlertmanagerSpecCSCCapabilities capabilities, Boolean privileged, String procMount, Boolean readOnlyRootFilesystem, Long runAsGroup, Boolean runAsNonRoot, Long runAsUser, AlertmanagerSpecCSCSeLinuxOptions seLinuxOptions, AlertmanagerSpecCSCSeccompProfile seccompProfile, AlertmanagerSpecCSCWindowsOptions windowsOptions) {
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
    public AlertmanagerSpecCSCCapabilities getCapabilities() {
        return capabilities;
    }

    @JsonProperty("capabilities")
    public void setCapabilities(AlertmanagerSpecCSCCapabilities capabilities) {
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
    public AlertmanagerSpecCSCSeLinuxOptions getSeLinuxOptions() {
        return seLinuxOptions;
    }

    @JsonProperty("seLinuxOptions")
    public void setSeLinuxOptions(AlertmanagerSpecCSCSeLinuxOptions seLinuxOptions) {
        this.seLinuxOptions = seLinuxOptions;
    }

    @JsonProperty("seccompProfile")
    public AlertmanagerSpecCSCSeccompProfile getSeccompProfile() {
        return seccompProfile;
    }

    @JsonProperty("seccompProfile")
    public void setSeccompProfile(AlertmanagerSpecCSCSeccompProfile seccompProfile) {
        this.seccompProfile = seccompProfile;
    }

    @JsonProperty("windowsOptions")
    public AlertmanagerSpecCSCWindowsOptions getWindowsOptions() {
        return windowsOptions;
    }

    @JsonProperty("windowsOptions")
    public void setWindowsOptions(AlertmanagerSpecCSCWindowsOptions windowsOptions) {
        this.windowsOptions = windowsOptions;
    }

    @JsonIgnore
    public AlertmanagerSpecCSecurityContextBuilder edit() {
        return new AlertmanagerSpecCSecurityContextBuilder(this);
    }

    @JsonIgnore
    public AlertmanagerSpecCSecurityContextBuilder toBuilder() {
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
