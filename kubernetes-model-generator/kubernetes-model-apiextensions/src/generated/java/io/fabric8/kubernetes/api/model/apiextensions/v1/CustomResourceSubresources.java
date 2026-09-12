
package io.fabric8.kubernetes.api.model.apiextensions.v1;

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
 * CustomResourceSubresources defines the status and scale subresources for CustomResources.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "scale",
    "status"
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
public class CustomResourceSubresources implements Editable<CustomResourceSubresourcesBuilder>, KubernetesResource
{

    @JsonProperty("scale")
    private CustomResourceSubresourceScale scale;
    @JsonProperty("status")
    private CustomResourceSubresourceStatus status;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public CustomResourceSubresources() {
    }

    public CustomResourceSubresources(CustomResourceSubresourceScale scale, CustomResourceSubresourceStatus status) {
        super();
        this.scale = scale;
        this.status = status;
    }

    /**
     * CustomResourceSubresources defines the status and scale subresources for CustomResources.
     */
    @JsonProperty("scale")
    public CustomResourceSubresourceScale getScale() {
        return scale;
    }

    /**
     * CustomResourceSubresources defines the status and scale subresources for CustomResources.
     */
    @JsonProperty("scale")
    public void setScale(CustomResourceSubresourceScale scale) {
        this.scale = scale;
    }

    /**
     * CustomResourceSubresources defines the status and scale subresources for CustomResources.
     */
    @JsonProperty("status")
    public CustomResourceSubresourceStatus getStatus() {
        return status;
    }

    /**
     * CustomResourceSubresources defines the status and scale subresources for CustomResources.
     */
    @JsonProperty("status")
    public void setStatus(CustomResourceSubresourceStatus status) {
        this.status = status;
    }

    @JsonIgnore
    public CustomResourceSubresourcesBuilder edit() {
        return new CustomResourceSubresourcesBuilder(this);
    }

    @JsonIgnore
    public CustomResourceSubresourcesBuilder toBuilder() {
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
        if (!(o instanceof CustomResourceSubresources)) {
            return false;
        }
        CustomResourceSubresources other = (CustomResourceSubresources) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$scale = this.getScale();
        Object other$scale = other.getScale();
        if (this$scale == null ? other$scale != null : !this$scale.equals(other$scale)) {
            return false;
        }
        Object this$status = this.getStatus();
        Object other$status = other.getStatus();
        if (this$status == null ? other$status != null : !this$status.equals(other$status)) {
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
        return other instanceof CustomResourceSubresources;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $scale = this.getScale();
        result = result * prime + ($scale == null ? 43 : $scale.hashCode());
        Object $status = this.getStatus();
        result = result * prime + ($status == null ? 43 : $status.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "CustomResourceSubresources(" + "scale=" + this.getScale() + ", status=" + this.getStatus() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
