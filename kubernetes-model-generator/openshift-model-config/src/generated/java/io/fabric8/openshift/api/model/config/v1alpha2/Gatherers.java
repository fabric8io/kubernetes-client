
package io.fabric8.openshift.api.model.config.v1alpha2;

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
    "custom",
    "mode"
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
public class Gatherers implements Editable<GatherersBuilder>, KubernetesResource
{

    @JsonProperty("custom")
    private Custom custom;
    @JsonProperty("mode")
    private String mode;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public Gatherers() {
    }

    public Gatherers(Custom custom, String mode) {
        super();
        this.custom = custom;
        this.mode = mode;
    }

    @JsonProperty("custom")
    public Custom getCustom() {
        return custom;
    }

    @JsonProperty("custom")
    public void setCustom(Custom custom) {
        this.custom = custom;
    }

    /**
     * mode is a required field that specifies the mode for gatherers. Allowed values are All, None, and Custom. When set to All, all gatherers wil run and gather data. When set to None, all gatherers will be disabled and no data will be gathered. When set to Custom, the custom configuration from the custom field will be applied.
     */
    @JsonProperty("mode")
    public String getMode() {
        return mode;
    }

    /**
     * mode is a required field that specifies the mode for gatherers. Allowed values are All, None, and Custom. When set to All, all gatherers wil run and gather data. When set to None, all gatherers will be disabled and no data will be gathered. When set to Custom, the custom configuration from the custom field will be applied.
     */
    @JsonProperty("mode")
    public void setMode(String mode) {
        this.mode = mode;
    }

    @JsonIgnore
    public GatherersBuilder edit() {
        return new GatherersBuilder(this);
    }

    @JsonIgnore
    public GatherersBuilder toBuilder() {
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
        if (!(o instanceof Gatherers)) {
            return false;
        }
        Gatherers other = (Gatherers) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$custom = this.getCustom();
        Object other$custom = other.getCustom();
        if (this$custom == null ? other$custom != null : !this$custom.equals(other$custom)) {
            return false;
        }
        Object this$mode = this.getMode();
        Object other$mode = other.getMode();
        if (this$mode == null ? other$mode != null : !this$mode.equals(other$mode)) {
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
        return other instanceof Gatherers;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $custom = this.getCustom();
        result = result * prime + ($custom == null ? 43 : $custom.hashCode());
        Object $mode = this.getMode();
        result = result * prime + ($mode == null ? 43 : $mode.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "Gatherers(" + "custom=" + this.getCustom() + ", mode=" + this.getMode() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
