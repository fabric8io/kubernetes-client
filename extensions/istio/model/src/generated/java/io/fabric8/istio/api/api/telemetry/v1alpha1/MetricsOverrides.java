
package io.fabric8.istio.api.api.telemetry.v1alpha1;

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
 * MetricsOverrides defines custom metric generation behavior for an individual metric or the set of all standard metrics.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "disabled",
    "match",
    "tagOverrides"
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
public class MetricsOverrides implements Editable<MetricsOverridesBuilder>, KubernetesResource
{

    @JsonProperty("disabled")
    private Boolean disabled;
    @JsonProperty("match")
    private MetricSelector match;
    @JsonProperty("tagOverrides")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Map<String, MetricsOverridesTagOverride> tagOverrides = new LinkedHashMap<>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public MetricsOverrides() {
    }

    public MetricsOverrides(Boolean disabled, MetricSelector match, Map<String, MetricsOverridesTagOverride> tagOverrides) {
        super();
        this.disabled = disabled;
        this.match = match;
        this.tagOverrides = tagOverrides;
    }

    /**
     * MetricsOverrides defines custom metric generation behavior for an individual metric or the set of all standard metrics.
     */
    @JsonProperty("disabled")
    public Boolean getDisabled() {
        return disabled;
    }

    /**
     * MetricsOverrides defines custom metric generation behavior for an individual metric or the set of all standard metrics.
     */
    @JsonProperty("disabled")
    public void setDisabled(Boolean disabled) {
        this.disabled = disabled;
    }

    /**
     * MetricsOverrides defines custom metric generation behavior for an individual metric or the set of all standard metrics.
     */
    @JsonProperty("match")
    public MetricSelector getMatch() {
        return match;
    }

    /**
     * MetricsOverrides defines custom metric generation behavior for an individual metric or the set of all standard metrics.
     */
    @JsonProperty("match")
    public void setMatch(MetricSelector match) {
        this.match = match;
    }

    /**
     * Optional. Collection of tag names and tag expressions to override in the selected metric(s). The key in the map is the name of the tag. The value in the map is the operation to perform on the the tag. WARNING: some providers may not support adding/removing tags. See also: https://istio.io/latest/docs/reference/config/metrics/#labels
     */
    @JsonProperty("tagOverrides")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public Map<String, MetricsOverridesTagOverride> getTagOverrides() {
        return tagOverrides;
    }

    /**
     * Optional. Collection of tag names and tag expressions to override in the selected metric(s). The key in the map is the name of the tag. The value in the map is the operation to perform on the the tag. WARNING: some providers may not support adding/removing tags. See also: https://istio.io/latest/docs/reference/config/metrics/#labels
     */
    @JsonProperty("tagOverrides")
    public void setTagOverrides(Map<String, MetricsOverridesTagOverride> tagOverrides) {
        this.tagOverrides = tagOverrides;
    }

    @JsonIgnore
    public MetricsOverridesBuilder edit() {
        return new MetricsOverridesBuilder(this);
    }

    @JsonIgnore
    public MetricsOverridesBuilder toBuilder() {
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
        if (!(o instanceof MetricsOverrides)) {
            return false;
        }
        MetricsOverrides other = (MetricsOverrides) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$disabled = this.getDisabled();
        Object other$disabled = other.getDisabled();
        if (this$disabled == null ? other$disabled != null : !this$disabled.equals(other$disabled)) {
            return false;
        }
        Object this$match = this.getMatch();
        Object other$match = other.getMatch();
        if (this$match == null ? other$match != null : !this$match.equals(other$match)) {
            return false;
        }
        Object this$tagOverrides = this.getTagOverrides();
        Object other$tagOverrides = other.getTagOverrides();
        if (this$tagOverrides == null ? other$tagOverrides != null : !this$tagOverrides.equals(other$tagOverrides)) {
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
        return other instanceof MetricsOverrides;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $disabled = this.getDisabled();
        result = result * prime + ($disabled == null ? 43 : $disabled.hashCode());
        Object $match = this.getMatch();
        result = result * prime + ($match == null ? 43 : $match.hashCode());
        Object $tagOverrides = this.getTagOverrides();
        result = result * prime + ($tagOverrides == null ? 43 : $tagOverrides.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "MetricsOverrides(" + "disabled=" + this.getDisabled() + ", match=" + this.getMatch() + ", tagOverrides=" + this.getTagOverrides() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
