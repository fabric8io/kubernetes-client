
package io.fabric8.kubernetes.api.model.apiextensions.v1beta1;

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
 * CustomResourceValidation is a list of validation methods for CustomResources.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "openAPIV3Schema"
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
public class CustomResourceValidation implements Editable<CustomResourceValidationBuilder>, KubernetesResource
{

    @JsonProperty("openAPIV3Schema")
    private JSONSchemaProps openAPIV3Schema;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public CustomResourceValidation() {
    }

    public CustomResourceValidation(JSONSchemaProps openAPIV3Schema) {
        super();
        this.openAPIV3Schema = openAPIV3Schema;
    }

    /**
     * CustomResourceValidation is a list of validation methods for CustomResources.
     */
    @JsonProperty("openAPIV3Schema")
    public JSONSchemaProps getOpenAPIV3Schema() {
        return openAPIV3Schema;
    }

    /**
     * CustomResourceValidation is a list of validation methods for CustomResources.
     */
    @JsonProperty("openAPIV3Schema")
    public void setOpenAPIV3Schema(JSONSchemaProps openAPIV3Schema) {
        this.openAPIV3Schema = openAPIV3Schema;
    }

    @JsonIgnore
    public CustomResourceValidationBuilder edit() {
        return new CustomResourceValidationBuilder(this);
    }

    @JsonIgnore
    public CustomResourceValidationBuilder toBuilder() {
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
        if (!(o instanceof CustomResourceValidation)) {
            return false;
        }
        CustomResourceValidation other = (CustomResourceValidation) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$openAPIV3Schema = this.getOpenAPIV3Schema();
        Object other$openAPIV3Schema = other.getOpenAPIV3Schema();
        if (this$openAPIV3Schema == null ? other$openAPIV3Schema != null : !this$openAPIV3Schema.equals(other$openAPIV3Schema)) {
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
        return other instanceof CustomResourceValidation;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $openAPIV3Schema = this.getOpenAPIV3Schema();
        result = result * prime + ($openAPIV3Schema == null ? 43 : $openAPIV3Schema.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "CustomResourceValidation(" + "openAPIV3Schema=" + this.getOpenAPIV3Schema() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
