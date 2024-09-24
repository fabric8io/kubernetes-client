
package io.fabric8.openshift.api.model.machineconfiguration.v1;

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
    "autoSizingReserved",
    "kubeletConfig",
    "logLevel",
    "machineConfigPoolSelector",
    "tlsSecurityProfile"
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
public class KubeletConfigSpec implements Editable<KubeletConfigSpecBuilder> , KubernetesResource
{

    @JsonProperty("autoSizingReserved")
    private Boolean autoSizingReserved;
    @JsonProperty("kubeletConfig")
    @JsonDeserialize(using = io.fabric8.kubernetes.internal.KubernetesDeserializer.class)
    private Object kubeletConfig;
    @JsonProperty("logLevel")
    private Integer logLevel;
    @JsonProperty("machineConfigPoolSelector")
    private KubeletConfigSpecMachineConfigPoolSelector machineConfigPoolSelector;
    @JsonProperty("tlsSecurityProfile")
    private KubeletConfigSpecTlsSecurityProfile tlsSecurityProfile;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public KubeletConfigSpec() {
    }

    public KubeletConfigSpec(Boolean autoSizingReserved, Object kubeletConfig, Integer logLevel, KubeletConfigSpecMachineConfigPoolSelector machineConfigPoolSelector, KubeletConfigSpecTlsSecurityProfile tlsSecurityProfile) {
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
    public Object getKubeletConfig() {
        return kubeletConfig;
    }

    @JsonProperty("kubeletConfig")
    @JsonDeserialize(using = io.fabric8.kubernetes.internal.KubernetesDeserializer.class)
    public void setKubeletConfig(Object kubeletConfig) {
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
    public KubeletConfigSpecMachineConfigPoolSelector getMachineConfigPoolSelector() {
        return machineConfigPoolSelector;
    }

    @JsonProperty("machineConfigPoolSelector")
    public void setMachineConfigPoolSelector(KubeletConfigSpecMachineConfigPoolSelector machineConfigPoolSelector) {
        this.machineConfigPoolSelector = machineConfigPoolSelector;
    }

    @JsonProperty("tlsSecurityProfile")
    public KubeletConfigSpecTlsSecurityProfile getTlsSecurityProfile() {
        return tlsSecurityProfile;
    }

    @JsonProperty("tlsSecurityProfile")
    public void setTlsSecurityProfile(KubeletConfigSpecTlsSecurityProfile tlsSecurityProfile) {
        this.tlsSecurityProfile = tlsSecurityProfile;
    }

    @JsonIgnore
    public KubeletConfigSpecBuilder edit() {
        return new KubeletConfigSpecBuilder(this);
    }

    @JsonIgnore
    public KubeletConfigSpecBuilder toBuilder() {
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
