
package io.fabric8.chaosmesh.v1alpha1;

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
import io.fabric8.kubernetes.api.model.ObjectReference;
import io.fabric8.kubernetes.api.model.PersistentVolumeClaim;
import io.fabric8.kubernetes.api.model.PodTemplateSpec;
import io.fabric8.kubernetes.api.model.ResourceRequirements;
import io.fabric8.kubernetes.api.model.Volume;
import io.fabric8.kubernetes.api.model.VolumeMount;
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;

/**
 * JVMStressSpec is the specification for stress
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "cpuCount",
    "memType"
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
public class JVMStressCfgSpec implements Editable<JVMStressCfgSpecBuilder>, KubernetesResource
{

    @JsonProperty("cpuCount")
    private Integer cpuCount;
    @JsonProperty("memType")
    private String memType;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public JVMStressCfgSpec() {
    }

    public JVMStressCfgSpec(Integer cpuCount, String memType) {
        super();
        this.cpuCount = cpuCount;
        this.memType = memType;
    }

    /**
     * the CPU core number needs to use, only set it when action is stress
     */
    @JsonProperty("cpuCount")
    public Integer getCpuCount() {
        return cpuCount;
    }

    /**
     * the CPU core number needs to use, only set it when action is stress
     */
    @JsonProperty("cpuCount")
    public void setCpuCount(Integer cpuCount) {
        this.cpuCount = cpuCount;
    }

    /**
     * the memory type needs to locate, only set it when action is stress, the value can be 'stack' or 'heap'
     */
    @JsonProperty("memType")
    public String getMemType() {
        return memType;
    }

    /**
     * the memory type needs to locate, only set it when action is stress, the value can be 'stack' or 'heap'
     */
    @JsonProperty("memType")
    public void setMemType(String memType) {
        this.memType = memType;
    }

    @JsonIgnore
    public JVMStressCfgSpecBuilder edit() {
        return new JVMStressCfgSpecBuilder(this);
    }

    @JsonIgnore
    public JVMStressCfgSpecBuilder toBuilder() {
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
        if (!(o instanceof JVMStressCfgSpec)) {
            return false;
        }
        JVMStressCfgSpec other = (JVMStressCfgSpec) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$cpuCount = this.getCpuCount();
        Object other$cpuCount = other.getCpuCount();
        if (this$cpuCount == null ? other$cpuCount != null : !this$cpuCount.equals(other$cpuCount)) {
            return false;
        }
        Object this$memType = this.getMemType();
        Object other$memType = other.getMemType();
        if (this$memType == null ? other$memType != null : !this$memType.equals(other$memType)) {
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
        return other instanceof JVMStressCfgSpec;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $cpuCount = this.getCpuCount();
        result = result * prime + ($cpuCount == null ? 43 : $cpuCount.hashCode());
        Object $memType = this.getMemType();
        result = result * prime + ($memType == null ? 43 : $memType.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "JVMStressCfgSpec(" + "cpuCount=" + this.getCpuCount() + ", memType=" + this.getMemType() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
