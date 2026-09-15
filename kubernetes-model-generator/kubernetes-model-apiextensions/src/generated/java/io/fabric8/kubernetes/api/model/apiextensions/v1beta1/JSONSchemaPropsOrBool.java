
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
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
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

@JsonSerialize(using = io.fabric8.kubernetes.api.model.apiextensions.v1beta1.JSONSchemaPropsOrBoolSerDe.Serializer.class)
@JsonDeserialize(using = io.fabric8.kubernetes.api.model.apiextensions.v1beta1.JSONSchemaPropsOrBoolSerDe.Deserializer.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "Allows",
    "Schema"
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
public class JSONSchemaPropsOrBool implements Editable<JSONSchemaPropsOrBoolBuilder>, KubernetesResource
{

    @JsonProperty("Allows")
    private Boolean allows;
    @JsonProperty("Schema")
    private JSONSchemaProps schema;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public JSONSchemaPropsOrBool() {
    }

    public JSONSchemaPropsOrBool(Boolean allows, JSONSchemaProps schema) {
        super();
        this.allows = allows;
        this.schema = schema;
    }

    @JsonProperty("Allows")
    public Boolean getAllows() {
        return allows;
    }

    @JsonProperty("Allows")
    public void setAllows(Boolean allows) {
        this.allows = allows;
    }

    @JsonProperty("Schema")
    public JSONSchemaProps getSchema() {
        return schema;
    }

    @JsonProperty("Schema")
    public void setSchema(JSONSchemaProps schema) {
        this.schema = schema;
    }

    @JsonIgnore
    public JSONSchemaPropsOrBoolBuilder edit() {
        return new JSONSchemaPropsOrBoolBuilder(this);
    }

    @JsonIgnore
    public JSONSchemaPropsOrBoolBuilder toBuilder() {
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
        if (!(o instanceof JSONSchemaPropsOrBool)) {
            return false;
        }
        JSONSchemaPropsOrBool other = (JSONSchemaPropsOrBool) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$allows = this.getAllows();
        Object other$allows = other.getAllows();
        if (this$allows == null ? other$allows != null : !this$allows.equals(other$allows)) {
            return false;
        }
        Object this$schema = this.getSchema();
        Object other$schema = other.getSchema();
        if (this$schema == null ? other$schema != null : !this$schema.equals(other$schema)) {
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
        return other instanceof JSONSchemaPropsOrBool;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $allows = this.getAllows();
        result = result * prime + ($allows == null ? 43 : $allows.hashCode());
        Object $schema = this.getSchema();
        result = result * prime + ($schema == null ? 43 : $schema.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "JSONSchemaPropsOrBool(" + "allows=" + this.getAllows() + ", schema=" + this.getSchema() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
