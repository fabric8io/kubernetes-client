
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
 * CorruptSpec defines detail of a corrupt action
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "correlation",
    "corrupt"
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
public class CorruptSpec implements Editable<CorruptSpecBuilder>, KubernetesResource
{

    @JsonProperty("correlation")
    private String correlation;
    @JsonProperty("corrupt")
    private String corrupt;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public CorruptSpec() {
    }

    public CorruptSpec(String correlation, String corrupt) {
        super();
        this.correlation = correlation;
        this.corrupt = corrupt;
    }

    /**
     * CorruptSpec defines detail of a corrupt action
     */
    @JsonProperty("correlation")
    public String getCorrelation() {
        return correlation;
    }

    /**
     * CorruptSpec defines detail of a corrupt action
     */
    @JsonProperty("correlation")
    public void setCorrelation(String correlation) {
        this.correlation = correlation;
    }

    /**
     * CorruptSpec defines detail of a corrupt action
     */
    @JsonProperty("corrupt")
    public String getCorrupt() {
        return corrupt;
    }

    /**
     * CorruptSpec defines detail of a corrupt action
     */
    @JsonProperty("corrupt")
    public void setCorrupt(String corrupt) {
        this.corrupt = corrupt;
    }

    @JsonIgnore
    public CorruptSpecBuilder edit() {
        return new CorruptSpecBuilder(this);
    }

    @JsonIgnore
    public CorruptSpecBuilder toBuilder() {
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
        if (!(o instanceof CorruptSpec)) {
            return false;
        }
        CorruptSpec other = (CorruptSpec) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$correlation = this.getCorrelation();
        Object other$correlation = other.getCorrelation();
        if (this$correlation == null ? other$correlation != null : !this$correlation.equals(other$correlation)) {
            return false;
        }
        Object this$corrupt = this.getCorrupt();
        Object other$corrupt = other.getCorrupt();
        if (this$corrupt == null ? other$corrupt != null : !this$corrupt.equals(other$corrupt)) {
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
        return other instanceof CorruptSpec;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $correlation = this.getCorrelation();
        result = result * prime + ($correlation == null ? 43 : $correlation.hashCode());
        Object $corrupt = this.getCorrupt();
        result = result * prime + ($corrupt == null ? 43 : $corrupt.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "CorruptSpec(" + "correlation=" + this.getCorrelation() + ", corrupt=" + this.getCorrupt() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
