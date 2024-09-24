
package io.fabric8.openshift.api.model.monitoring.v1;

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
import io.fabric8.kubernetes.api.model.Sysctl;
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

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
    "sysctls",
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
public class ThanosRulerSpecSecurityContext implements Editable<ThanosRulerSpecSecurityContextBuilder> , KubernetesResource
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
    private ThanosRulerSpecSCSeLinuxOptions seLinuxOptions;
    @JsonProperty("seccompProfile")
    private ThanosRulerSpecSCSeccompProfile seccompProfile;
    @JsonProperty("supplementalGroups")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<Long> supplementalGroups = new ArrayList<>();
    @JsonProperty("sysctls")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<Sysctl> sysctls = new ArrayList<>();
    @JsonProperty("windowsOptions")
    private ThanosRulerSpecSCWindowsOptions windowsOptions;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public ThanosRulerSpecSecurityContext() {
    }

    public ThanosRulerSpecSecurityContext(Long fsGroup, String fsGroupChangePolicy, Long runAsGroup, Boolean runAsNonRoot, Long runAsUser, ThanosRulerSpecSCSeLinuxOptions seLinuxOptions, ThanosRulerSpecSCSeccompProfile seccompProfile, List<Long> supplementalGroups, List<Sysctl> sysctls, ThanosRulerSpecSCWindowsOptions windowsOptions) {
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
        this.windowsOptions = windowsOptions;
    }

    @JsonProperty("fsGroup")
    public Long getFsGroup() {
        return fsGroup;
    }

    @JsonProperty("fsGroup")
    public void setFsGroup(Long fsGroup) {
        this.fsGroup = fsGroup;
    }

    @JsonProperty("fsGroupChangePolicy")
    public String getFsGroupChangePolicy() {
        return fsGroupChangePolicy;
    }

    @JsonProperty("fsGroupChangePolicy")
    public void setFsGroupChangePolicy(String fsGroupChangePolicy) {
        this.fsGroupChangePolicy = fsGroupChangePolicy;
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
    public ThanosRulerSpecSCSeLinuxOptions getSeLinuxOptions() {
        return seLinuxOptions;
    }

    @JsonProperty("seLinuxOptions")
    public void setSeLinuxOptions(ThanosRulerSpecSCSeLinuxOptions seLinuxOptions) {
        this.seLinuxOptions = seLinuxOptions;
    }

    @JsonProperty("seccompProfile")
    public ThanosRulerSpecSCSeccompProfile getSeccompProfile() {
        return seccompProfile;
    }

    @JsonProperty("seccompProfile")
    public void setSeccompProfile(ThanosRulerSpecSCSeccompProfile seccompProfile) {
        this.seccompProfile = seccompProfile;
    }

    @JsonProperty("supplementalGroups")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<Long> getSupplementalGroups() {
        return supplementalGroups;
    }

    @JsonProperty("supplementalGroups")
    public void setSupplementalGroups(List<Long> supplementalGroups) {
        this.supplementalGroups = supplementalGroups;
    }

    @JsonProperty("sysctls")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<Sysctl> getSysctls() {
        return sysctls;
    }

    @JsonProperty("sysctls")
    public void setSysctls(List<Sysctl> sysctls) {
        this.sysctls = sysctls;
    }

    @JsonProperty("windowsOptions")
    public ThanosRulerSpecSCWindowsOptions getWindowsOptions() {
        return windowsOptions;
    }

    @JsonProperty("windowsOptions")
    public void setWindowsOptions(ThanosRulerSpecSCWindowsOptions windowsOptions) {
        this.windowsOptions = windowsOptions;
    }

    @JsonIgnore
    public ThanosRulerSpecSecurityContextBuilder edit() {
        return new ThanosRulerSpecSecurityContextBuilder(this);
    }

    @JsonIgnore
    public ThanosRulerSpecSecurityContextBuilder toBuilder() {
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
