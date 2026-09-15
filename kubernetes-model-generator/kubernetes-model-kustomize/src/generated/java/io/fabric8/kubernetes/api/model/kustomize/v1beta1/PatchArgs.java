
package io.fabric8.kubernetes.api.model.kustomize.v1beta1;

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

@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "allowKindChange",
    "allowNameChange"
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
public class PatchArgs implements Editable<PatchArgsBuilder>, KubernetesResource
{

    @JsonProperty("allowKindChange")
    private Boolean allowKindChange;
    @JsonProperty("allowNameChange")
    private Boolean allowNameChange;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public PatchArgs() {
    }

    public PatchArgs(Boolean allowKindChange, Boolean allowNameChange) {
        super();
        this.allowKindChange = allowKindChange;
        this.allowNameChange = allowNameChange;
    }

    @JsonProperty("allowKindChange")
    public Boolean getAllowKindChange() {
        return allowKindChange;
    }

    @JsonProperty("allowKindChange")
    public void setAllowKindChange(Boolean allowKindChange) {
        this.allowKindChange = allowKindChange;
    }

    @JsonProperty("allowNameChange")
    public Boolean getAllowNameChange() {
        return allowNameChange;
    }

    @JsonProperty("allowNameChange")
    public void setAllowNameChange(Boolean allowNameChange) {
        this.allowNameChange = allowNameChange;
    }

    @JsonIgnore
    public PatchArgsBuilder edit() {
        return new PatchArgsBuilder(this);
    }

    @JsonIgnore
    public PatchArgsBuilder toBuilder() {
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
        if (!(o instanceof PatchArgs)) {
            return false;
        }
        PatchArgs other = (PatchArgs) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$allowKindChange = this.getAllowKindChange();
        Object other$allowKindChange = other.getAllowKindChange();
        if (this$allowKindChange == null ? other$allowKindChange != null : !this$allowKindChange.equals(other$allowKindChange)) {
            return false;
        }
        Object this$allowNameChange = this.getAllowNameChange();
        Object other$allowNameChange = other.getAllowNameChange();
        if (this$allowNameChange == null ? other$allowNameChange != null : !this$allowNameChange.equals(other$allowNameChange)) {
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
        return other instanceof PatchArgs;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $allowKindChange = this.getAllowKindChange();
        result = result * prime + ($allowKindChange == null ? 43 : $allowKindChange.hashCode());
        Object $allowNameChange = this.getAllowNameChange();
        result = result * prime + ($allowNameChange == null ? 43 : $allowNameChange.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "PatchArgs(" + "allowKindChange=" + this.getAllowKindChange() + ", allowNameChange=" + this.getAllowNameChange() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
