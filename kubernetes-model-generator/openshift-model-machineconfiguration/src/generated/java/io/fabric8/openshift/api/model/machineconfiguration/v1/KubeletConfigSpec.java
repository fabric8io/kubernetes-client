
package io.fabric8.openshift.api.model.machineconfiguration.v1;

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
import io.fabric8.kubernetes.api.model.Container;
import io.fabric8.kubernetes.api.model.ContainerPort;
import io.fabric8.kubernetes.api.model.EnvVar;
import io.fabric8.kubernetes.api.model.IntOrString;
import io.fabric8.kubernetes.api.model.KubernetesResource;
import io.fabric8.kubernetes.api.model.LabelSelector;
import io.fabric8.kubernetes.api.model.LocalObjectReference;
import io.fabric8.kubernetes.api.model.ObjectMeta;
import io.fabric8.kubernetes.api.model.PersistentVolumeClaim;
import io.fabric8.kubernetes.api.model.PodTemplateSpec;
import io.fabric8.kubernetes.api.model.ResourceRequirements;
import io.fabric8.kubernetes.api.model.Volume;
import io.fabric8.kubernetes.api.model.VolumeMount;
import io.fabric8.openshift.api.model.config.v1.TLSSecurityProfile;
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;

/**
 * KubeletConfigSpec defines the desired state of KubeletConfig
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "autoSizingReserved",
    "kubeletConfig",
    "logLevel",
    "machineConfigPoolSelector",
    "tlsSecurityProfile"
})
@Buildable(editableEnabled = false, validationEnabled = false, generateBuilderPackage = false, lazyCollectionInitEnabled = false, builderPackage = "io.fabric8.kubernetes.api.builder", refs = {
    @BuildableReference(ObjectMeta.class),
    @BuildableReference(LabelSelector.class),
    @BuildableReference(Container.class),
    @BuildableReference(PodTemplateSpec.class),
    @BuildableReference(ResourceRequirements.class),
    @BuildableReference(IntOrString.class),
    @BuildableReference(io.fabric8.kubernetes.api.model.ObjectReference.class),
    @BuildableReference(LocalObjectReference.class),
    @BuildableReference(PersistentVolumeClaim.class),
    @BuildableReference(EnvVar.class),
    @BuildableReference(ContainerPort.class),
    @BuildableReference(Volume.class),
    @BuildableReference(VolumeMount.class)
})
@Generated("io.fabric8.kubernetes.schema.generator.model.ModelGenerator")
public class KubeletConfigSpec implements Editable<KubeletConfigSpecBuilder>, KubernetesResource
{

    @JsonProperty("autoSizingReserved")
    private Boolean autoSizingReserved;
    @JsonProperty("kubeletConfig")
    @JsonDeserialize(using = io.fabric8.kubernetes.internal.KubernetesDeserializer.class)
    private Object kubeletConfig;
    @JsonProperty("logLevel")
    private Integer logLevel;
    @JsonProperty("machineConfigPoolSelector")
    private LabelSelector machineConfigPoolSelector;
    @JsonProperty("tlsSecurityProfile")
    private TLSSecurityProfile tlsSecurityProfile;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public KubeletConfigSpec() {
    }

    public KubeletConfigSpec(Boolean autoSizingReserved, Object kubeletConfig, Integer logLevel, LabelSelector machineConfigPoolSelector, TLSSecurityProfile tlsSecurityProfile) {
        super();
        this.autoSizingReserved = autoSizingReserved;
        this.kubeletConfig = kubeletConfig;
        this.logLevel = logLevel;
        this.machineConfigPoolSelector = machineConfigPoolSelector;
        this.tlsSecurityProfile = tlsSecurityProfile;
    }

    /**
     * KubeletConfigSpec defines the desired state of KubeletConfig
     */
    @JsonProperty("autoSizingReserved")
    public Boolean getAutoSizingReserved() {
        return autoSizingReserved;
    }

    /**
     * KubeletConfigSpec defines the desired state of KubeletConfig
     */
    @JsonProperty("autoSizingReserved")
    public void setAutoSizingReserved(Boolean autoSizingReserved) {
        this.autoSizingReserved = autoSizingReserved;
    }

    /**
     * KubeletConfigSpec defines the desired state of KubeletConfig
     */
    @JsonProperty("kubeletConfig")
    public Object getKubeletConfig() {
        return kubeletConfig;
    }

    /**
     * KubeletConfigSpec defines the desired state of KubeletConfig
     */
    @JsonProperty("kubeletConfig")
    @JsonDeserialize(using = io.fabric8.kubernetes.internal.KubernetesDeserializer.class)
    public void setKubeletConfig(Object kubeletConfig) {
        this.kubeletConfig = kubeletConfig;
    }

    /**
     * KubeletConfigSpec defines the desired state of KubeletConfig
     */
    @JsonProperty("logLevel")
    public Integer getLogLevel() {
        return logLevel;
    }

    /**
     * KubeletConfigSpec defines the desired state of KubeletConfig
     */
    @JsonProperty("logLevel")
    public void setLogLevel(Integer logLevel) {
        this.logLevel = logLevel;
    }

    /**
     * KubeletConfigSpec defines the desired state of KubeletConfig
     */
    @JsonProperty("machineConfigPoolSelector")
    public LabelSelector getMachineConfigPoolSelector() {
        return machineConfigPoolSelector;
    }

    /**
     * KubeletConfigSpec defines the desired state of KubeletConfig
     */
    @JsonProperty("machineConfigPoolSelector")
    public void setMachineConfigPoolSelector(LabelSelector machineConfigPoolSelector) {
        this.machineConfigPoolSelector = machineConfigPoolSelector;
    }

    /**
     * KubeletConfigSpec defines the desired state of KubeletConfig
     */
    @JsonProperty("tlsSecurityProfile")
    public TLSSecurityProfile getTlsSecurityProfile() {
        return tlsSecurityProfile;
    }

    /**
     * KubeletConfigSpec defines the desired state of KubeletConfig
     */
    @JsonProperty("tlsSecurityProfile")
    public void setTlsSecurityProfile(TLSSecurityProfile tlsSecurityProfile) {
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
        if (!(o instanceof KubeletConfigSpec)) {
            return false;
        }
        KubeletConfigSpec other = (KubeletConfigSpec) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$autoSizingReserved = this.getAutoSizingReserved();
        Object other$autoSizingReserved = other.getAutoSizingReserved();
        if (this$autoSizingReserved == null ? other$autoSizingReserved != null : !this$autoSizingReserved.equals(other$autoSizingReserved)) {
            return false;
        }
        Object this$kubeletConfig = this.getKubeletConfig();
        Object other$kubeletConfig = other.getKubeletConfig();
        if (this$kubeletConfig == null ? other$kubeletConfig != null : !this$kubeletConfig.equals(other$kubeletConfig)) {
            return false;
        }
        Object this$logLevel = this.getLogLevel();
        Object other$logLevel = other.getLogLevel();
        if (this$logLevel == null ? other$logLevel != null : !this$logLevel.equals(other$logLevel)) {
            return false;
        }
        Object this$machineConfigPoolSelector = this.getMachineConfigPoolSelector();
        Object other$machineConfigPoolSelector = other.getMachineConfigPoolSelector();
        if (this$machineConfigPoolSelector == null ? other$machineConfigPoolSelector != null : !this$machineConfigPoolSelector.equals(other$machineConfigPoolSelector)) {
            return false;
        }
        Object this$tlsSecurityProfile = this.getTlsSecurityProfile();
        Object other$tlsSecurityProfile = other.getTlsSecurityProfile();
        if (this$tlsSecurityProfile == null ? other$tlsSecurityProfile != null : !this$tlsSecurityProfile.equals(other$tlsSecurityProfile)) {
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
        return other instanceof KubeletConfigSpec;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $autoSizingReserved = this.getAutoSizingReserved();
        result = result * prime + ($autoSizingReserved == null ? 43 : $autoSizingReserved.hashCode());
        Object $kubeletConfig = this.getKubeletConfig();
        result = result * prime + ($kubeletConfig == null ? 43 : $kubeletConfig.hashCode());
        Object $logLevel = this.getLogLevel();
        result = result * prime + ($logLevel == null ? 43 : $logLevel.hashCode());
        Object $machineConfigPoolSelector = this.getMachineConfigPoolSelector();
        result = result * prime + ($machineConfigPoolSelector == null ? 43 : $machineConfigPoolSelector.hashCode());
        Object $tlsSecurityProfile = this.getTlsSecurityProfile();
        result = result * prime + ($tlsSecurityProfile == null ? 43 : $tlsSecurityProfile.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "KubeletConfigSpec(" + "autoSizingReserved=" + this.getAutoSizingReserved() + ", kubeletConfig=" + this.getKubeletConfig() + ", logLevel=" + this.getLogLevel() + ", machineConfigPoolSelector=" + this.getMachineConfigPoolSelector() + ", tlsSecurityProfile=" + this.getTlsSecurityProfile() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
