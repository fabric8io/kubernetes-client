
package io.fabric8.openshift.api.model.machineconfig.v1;

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
import io.fabric8.kubernetes.api.model.Container;
import io.fabric8.kubernetes.api.model.IntOrString;
import io.fabric8.kubernetes.api.model.KubernetesResource;
import io.fabric8.kubernetes.api.model.LocalObjectReference;
import io.fabric8.kubernetes.api.model.ObjectMeta;
import io.fabric8.kubernetes.api.model.ObjectReference;
import io.fabric8.kubernetes.api.model.PersistentVolumeClaim;
import io.fabric8.kubernetes.api.model.PodTemplateSpec;
import io.fabric8.kubernetes.api.model.ResourceRequirements;
import io.fabric8.openshift.api.model.config.v1.TLSSecurityProfile;
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
    "autoSizingReserved",
    "kubeletConfig",
    "logLevel",
    "machineConfigPoolSelector",
    "tlsSecurityProfile"
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
    @BuildableReference(io.fabric8.kubernetes.api.model.LabelSelector.class),
    @BuildableReference(Container.class),
    @BuildableReference(PodTemplateSpec.class),
    @BuildableReference(ResourceRequirements.class),
    @BuildableReference(IntOrString.class),
    @BuildableReference(ObjectReference.class),
    @BuildableReference(LocalObjectReference.class),
    @BuildableReference(PersistentVolumeClaim.class)
})
@Generated("jsonschema2pojo")
public class KubeletConfigSpec implements KubernetesResource
{

    @JsonProperty("autoSizingReserved")
    private Boolean autoSizingReserved;
    @JsonProperty("kubeletConfig")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Map<String, Object> kubeletConfig = new LinkedHashMap<String, Object>();
    @JsonProperty("logLevel")
    private Integer logLevel;
    @JsonProperty("machineConfigPoolSelector")
    private io.fabric8.kubernetes.api.model.LabelSelector machineConfigPoolSelector;
    @JsonProperty("tlsSecurityProfile")
    private TLSSecurityProfile tlsSecurityProfile;
    @JsonIgnore
    private Map<java.lang.String, java.lang.Object> additionalProperties = new LinkedHashMap<java.lang.String, java.lang.Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public KubeletConfigSpec() {
    }

    public KubeletConfigSpec(Boolean autoSizingReserved, Map<String, Object> kubeletConfig, Integer logLevel, io.fabric8.kubernetes.api.model.LabelSelector machineConfigPoolSelector, TLSSecurityProfile tlsSecurityProfile) {
        super();
        this.autoSizingReserved = autoSizingReserved;
        this.kubeletConfig = kubeletConfig;
        this.logLevel = logLevel;
        this.machineConfigPoolSelector = machineConfigPoolSelector;
        this.tlsSecurityProfile = tlsSecurityProfile;
    }

    @JsonProperty("autoSizingReserved")
    public Boolean getAutoSizingReserved() {
        return autoSizingReserved;
    }

    @JsonProperty("autoSizingReserved")
    public void setAutoSizingReserved(Boolean autoSizingReserved) {
        this.autoSizingReserved = autoSizingReserved;
    }

    @JsonProperty("kubeletConfig")
    public Map<String, Object> getKubeletConfig() {
        return kubeletConfig;
    }

    @JsonProperty("kubeletConfig")
    public void setKubeletConfig(Map<String, Object> kubeletConfig) {
        this.kubeletConfig = kubeletConfig;
    }

    @JsonProperty("logLevel")
    public Integer getLogLevel() {
        return logLevel;
    }

    @JsonProperty("logLevel")
    public void setLogLevel(Integer logLevel) {
        this.logLevel = logLevel;
    }

    @JsonProperty("machineConfigPoolSelector")
    public io.fabric8.kubernetes.api.model.LabelSelector getMachineConfigPoolSelector() {
        return machineConfigPoolSelector;
    }

    @JsonProperty("machineConfigPoolSelector")
    public void setMachineConfigPoolSelector(io.fabric8.kubernetes.api.model.LabelSelector machineConfigPoolSelector) {
        this.machineConfigPoolSelector = machineConfigPoolSelector;
    }

    @JsonProperty("tlsSecurityProfile")
    public TLSSecurityProfile getTlsSecurityProfile() {
        return tlsSecurityProfile;
    }

    @JsonProperty("tlsSecurityProfile")
    public void setTlsSecurityProfile(TLSSecurityProfile tlsSecurityProfile) {
        this.tlsSecurityProfile = tlsSecurityProfile;
    }

    @JsonAnyGetter
    public Map<java.lang.String, java.lang.Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(java.lang.String name, java.lang.Object value) {
        this.additionalProperties.put(name, value);
    }

}
