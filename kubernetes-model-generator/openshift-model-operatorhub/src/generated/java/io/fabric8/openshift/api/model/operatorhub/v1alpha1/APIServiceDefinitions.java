
package io.fabric8.openshift.api.model.operatorhub.v1alpha1;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
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
 * APIServiceDefinitions declares all of the extension apis managed or required by an operator being ran by ClusterServiceVersion.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "owned",
    "required"
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
public class APIServiceDefinitions implements Editable<APIServiceDefinitionsBuilder>, KubernetesResource
{

    @JsonProperty("owned")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<APIServiceDescription> owned = new ArrayList<>();
    @JsonProperty("required")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<APIServiceDescription> required = new ArrayList<>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public APIServiceDefinitions() {
    }

    public APIServiceDefinitions(List<APIServiceDescription> owned, List<APIServiceDescription> required) {
        super();
        this.owned = owned;
        this.required = required;
    }

    /**
     * APIServiceDefinitions declares all of the extension apis managed or required by an operator being ran by ClusterServiceVersion.
     */
    @JsonProperty("owned")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<APIServiceDescription> getOwned() {
        return owned;
    }

    /**
     * APIServiceDefinitions declares all of the extension apis managed or required by an operator being ran by ClusterServiceVersion.
     */
    @JsonProperty("owned")
    public void setOwned(List<APIServiceDescription> owned) {
        this.owned = owned;
    }

    /**
     * APIServiceDefinitions declares all of the extension apis managed or required by an operator being ran by ClusterServiceVersion.
     */
    @JsonProperty("required")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<APIServiceDescription> getRequired() {
        return required;
    }

    /**
     * APIServiceDefinitions declares all of the extension apis managed or required by an operator being ran by ClusterServiceVersion.
     */
    @JsonProperty("required")
    public void setRequired(List<APIServiceDescription> required) {
        this.required = required;
    }

    @JsonIgnore
    public APIServiceDefinitionsBuilder edit() {
        return new APIServiceDefinitionsBuilder(this);
    }

    @JsonIgnore
    public APIServiceDefinitionsBuilder toBuilder() {
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
        if (!(o instanceof APIServiceDefinitions)) {
            return false;
        }
        APIServiceDefinitions other = (APIServiceDefinitions) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$owned = this.getOwned();
        Object other$owned = other.getOwned();
        if (this$owned == null ? other$owned != null : !this$owned.equals(other$owned)) {
            return false;
        }
        Object this$required = this.getRequired();
        Object other$required = other.getRequired();
        if (this$required == null ? other$required != null : !this$required.equals(other$required)) {
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
        return other instanceof APIServiceDefinitions;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $owned = this.getOwned();
        result = result * prime + ($owned == null ? 43 : $owned.hashCode());
        Object $required = this.getRequired();
        result = result * prime + ($required == null ? 43 : $required.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "APIServiceDefinitions(" + "owned=" + this.getOwned() + ", required=" + this.getRequired() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
