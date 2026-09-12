
package io.fabric8.tekton.triggers.v1beta1;

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
 * EventListenerBinding refers to a particular TriggerBinding or ClusterTriggerBinding resource.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "kind",
    "apiversion",
    "name",
    "ref",
    "value"
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
public class TriggerSpecBinding implements Editable<TriggerSpecBindingBuilder>, KubernetesResource
{

    @JsonProperty("apiversion")
    private String apiversion;
    @JsonProperty("kind")
    private String kind;
    @JsonProperty("name")
    private String name;
    @JsonProperty("ref")
    private String ref;
    @JsonProperty("value")
    private String value;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public TriggerSpecBinding() {
    }

    public TriggerSpecBinding(String apiversion, String kind, String name, String ref, String value) {
        super();
        this.apiversion = apiversion;
        this.kind = kind;
        this.name = name;
        this.ref = ref;
        this.value = value;
    }

    /**
     * APIVersion of the binding ref
     */
    @JsonProperty("apiversion")
    public String getApiversion() {
        return apiversion;
    }

    /**
     * APIVersion of the binding ref
     */
    @JsonProperty("apiversion")
    public void setApiversion(String apiversion) {
        this.apiversion = apiversion;
    }

    /**
     * Kind can only be provided if Ref is also provided. Defaults to TriggerBinding
     */
    @JsonProperty("kind")
    public String getKind() {
        return kind;
    }

    /**
     * Kind can only be provided if Ref is also provided. Defaults to TriggerBinding
     */
    @JsonProperty("kind")
    public void setKind(String kind) {
        this.kind = kind;
    }

    /**
     * Name is the name of the binding param Mutually exclusive with Ref
     */
    @JsonProperty("name")
    public String getName() {
        return name;
    }

    /**
     * Name is the name of the binding param Mutually exclusive with Ref
     */
    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Ref is a reference to a TriggerBinding kind. Mutually exclusive with Name
     */
    @JsonProperty("ref")
    public String getRef() {
        return ref;
    }

    /**
     * Ref is a reference to a TriggerBinding kind. Mutually exclusive with Name
     */
    @JsonProperty("ref")
    public void setRef(String ref) {
        this.ref = ref;
    }

    /**
     * Value is the value of the binding param. Can contain JSONPath Has to be pointer since "" is a valid value Required if Name is also specified.
     */
    @JsonProperty("value")
    public String getValue() {
        return value;
    }

    /**
     * Value is the value of the binding param. Can contain JSONPath Has to be pointer since "" is a valid value Required if Name is also specified.
     */
    @JsonProperty("value")
    public void setValue(String value) {
        this.value = value;
    }

    @JsonIgnore
    public TriggerSpecBindingBuilder edit() {
        return new TriggerSpecBindingBuilder(this);
    }

    @JsonIgnore
    public TriggerSpecBindingBuilder toBuilder() {
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
        if (!(o instanceof TriggerSpecBinding)) {
            return false;
        }
        TriggerSpecBinding other = (TriggerSpecBinding) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$apiversion = this.getApiversion();
        Object other$apiversion = other.getApiversion();
        if (this$apiversion == null ? other$apiversion != null : !this$apiversion.equals(other$apiversion)) {
            return false;
        }
        Object this$kind = this.getKind();
        Object other$kind = other.getKind();
        if (this$kind == null ? other$kind != null : !this$kind.equals(other$kind)) {
            return false;
        }
        Object this$name = this.getName();
        Object other$name = other.getName();
        if (this$name == null ? other$name != null : !this$name.equals(other$name)) {
            return false;
        }
        Object this$ref = this.getRef();
        Object other$ref = other.getRef();
        if (this$ref == null ? other$ref != null : !this$ref.equals(other$ref)) {
            return false;
        }
        Object this$value = this.getValue();
        Object other$value = other.getValue();
        if (this$value == null ? other$value != null : !this$value.equals(other$value)) {
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
        return other instanceof TriggerSpecBinding;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $apiversion = this.getApiversion();
        result = result * prime + ($apiversion == null ? 43 : $apiversion.hashCode());
        Object $kind = this.getKind();
        result = result * prime + ($kind == null ? 43 : $kind.hashCode());
        Object $name = this.getName();
        result = result * prime + ($name == null ? 43 : $name.hashCode());
        Object $ref = this.getRef();
        result = result * prime + ($ref == null ? 43 : $ref.hashCode());
        Object $value = this.getValue();
        result = result * prime + ($value == null ? 43 : $value.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "TriggerSpecBinding(" + "apiversion=" + this.getApiversion() + ", kind=" + this.getKind() + ", name=" + this.getName() + ", ref=" + this.getRef() + ", value=" + this.getValue() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
