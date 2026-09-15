
package io.fabric8.tekton.resolution.v1beta1;

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
import io.fabric8.tekton.v1.RefSource;
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;

/**
 * ResolutionRequestStatusFields are the ResolutionRequest-specific fields for the status subresource.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "data",
    "refSource",
    "source"
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
public class ResolutionRequestStatusFields implements Editable<ResolutionRequestStatusFieldsBuilder>, KubernetesResource
{

    @JsonProperty("data")
    private String data;
    @JsonProperty("refSource")
    private RefSource refSource;
    @JsonProperty("source")
    private RefSource source;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public ResolutionRequestStatusFields() {
    }

    public ResolutionRequestStatusFields(String data, RefSource refSource, RefSource source) {
        super();
        this.data = data;
        this.refSource = refSource;
        this.source = source;
    }

    /**
     * Data is a string representation of the resolved content of the requested resource in-lined into the ResolutionRequest object.
     */
    @JsonProperty("data")
    public String getData() {
        return data;
    }

    /**
     * Data is a string representation of the resolved content of the requested resource in-lined into the ResolutionRequest object.
     */
    @JsonProperty("data")
    public void setData(String data) {
        this.data = data;
    }

    /**
     * ResolutionRequestStatusFields are the ResolutionRequest-specific fields for the status subresource.
     */
    @JsonProperty("refSource")
    public RefSource getRefSource() {
        return refSource;
    }

    /**
     * ResolutionRequestStatusFields are the ResolutionRequest-specific fields for the status subresource.
     */
    @JsonProperty("refSource")
    public void setRefSource(RefSource refSource) {
        this.refSource = refSource;
    }

    /**
     * ResolutionRequestStatusFields are the ResolutionRequest-specific fields for the status subresource.
     */
    @JsonProperty("source")
    public RefSource getSource() {
        return source;
    }

    /**
     * ResolutionRequestStatusFields are the ResolutionRequest-specific fields for the status subresource.
     */
    @JsonProperty("source")
    public void setSource(RefSource source) {
        this.source = source;
    }

    @JsonIgnore
    public ResolutionRequestStatusFieldsBuilder edit() {
        return new ResolutionRequestStatusFieldsBuilder(this);
    }

    @JsonIgnore
    public ResolutionRequestStatusFieldsBuilder toBuilder() {
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
        if (!(o instanceof ResolutionRequestStatusFields)) {
            return false;
        }
        ResolutionRequestStatusFields other = (ResolutionRequestStatusFields) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$data = this.getData();
        Object other$data = other.getData();
        if (this$data == null ? other$data != null : !this$data.equals(other$data)) {
            return false;
        }
        Object this$refSource = this.getRefSource();
        Object other$refSource = other.getRefSource();
        if (this$refSource == null ? other$refSource != null : !this$refSource.equals(other$refSource)) {
            return false;
        }
        Object this$source = this.getSource();
        Object other$source = other.getSource();
        if (this$source == null ? other$source != null : !this$source.equals(other$source)) {
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
        return other instanceof ResolutionRequestStatusFields;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $data = this.getData();
        result = result * prime + ($data == null ? 43 : $data.hashCode());
        Object $refSource = this.getRefSource();
        result = result * prime + ($refSource == null ? 43 : $refSource.hashCode());
        Object $source = this.getSource();
        result = result * prime + ($source == null ? 43 : $source.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "ResolutionRequestStatusFields(" + "data=" + this.getData() + ", refSource=" + this.getRefSource() + ", source=" + this.getSource() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
