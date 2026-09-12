
package io.fabric8.openshift.api.model.operator.v1;

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
 * IngressControllerHTTPHeaderActionUnion specifies an action to take on an HTTP header.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "set",
    "type"
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
public class IngressControllerHTTPHeaderActionUnion implements Editable<IngressControllerHTTPHeaderActionUnionBuilder>, KubernetesResource
{

    @JsonProperty("set")
    private IngressControllerSetHTTPHeader set;
    @JsonProperty("type")
    private String type;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public IngressControllerHTTPHeaderActionUnion() {
    }

    public IngressControllerHTTPHeaderActionUnion(IngressControllerSetHTTPHeader set, String type) {
        super();
        this.set = set;
        this.type = type;
    }

    /**
     * IngressControllerHTTPHeaderActionUnion specifies an action to take on an HTTP header.
     */
    @JsonProperty("set")
    public IngressControllerSetHTTPHeader getSet() {
        return set;
    }

    /**
     * IngressControllerHTTPHeaderActionUnion specifies an action to take on an HTTP header.
     */
    @JsonProperty("set")
    public void setSet(IngressControllerSetHTTPHeader set) {
        this.set = set;
    }

    /**
     * type defines the type of the action to be applied on the header. Possible values are Set or Delete. Set allows you to set HTTP request and response headers. Delete allows you to delete HTTP request and response headers.
     */
    @JsonProperty("type")
    public String getType() {
        return type;
    }

    /**
     * type defines the type of the action to be applied on the header. Possible values are Set or Delete. Set allows you to set HTTP request and response headers. Delete allows you to delete HTTP request and response headers.
     */
    @JsonProperty("type")
    public void setType(String type) {
        this.type = type;
    }

    @JsonIgnore
    public IngressControllerHTTPHeaderActionUnionBuilder edit() {
        return new IngressControllerHTTPHeaderActionUnionBuilder(this);
    }

    @JsonIgnore
    public IngressControllerHTTPHeaderActionUnionBuilder toBuilder() {
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
        if (!(o instanceof IngressControllerHTTPHeaderActionUnion)) {
            return false;
        }
        IngressControllerHTTPHeaderActionUnion other = (IngressControllerHTTPHeaderActionUnion) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$set = this.getSet();
        Object other$set = other.getSet();
        if (this$set == null ? other$set != null : !this$set.equals(other$set)) {
            return false;
        }
        Object this$type = this.getType();
        Object other$type = other.getType();
        if (this$type == null ? other$type != null : !this$type.equals(other$type)) {
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
        return other instanceof IngressControllerHTTPHeaderActionUnion;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $set = this.getSet();
        result = result * prime + ($set == null ? 43 : $set.hashCode());
        Object $type = this.getType();
        result = result * prime + ($type == null ? 43 : $type.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "IngressControllerHTTPHeaderActionUnion(" + "set=" + this.getSet() + ", type=" + this.getType() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
