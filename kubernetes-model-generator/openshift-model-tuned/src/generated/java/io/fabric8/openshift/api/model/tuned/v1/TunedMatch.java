
package io.fabric8.openshift.api.model.tuned.v1;

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
 * Rules governing application of a Tuned profile.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "label",
    "match",
    "type",
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
public class TunedMatch implements Editable<TunedMatchBuilder>, KubernetesResource
{

    @JsonProperty("label")
    private String label;
    @JsonProperty("match")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<io.fabric8.openshift.api.model.tuned.v1.TunedMatch> match = new ArrayList<>();
    @JsonProperty("type")
    private String type;
    @JsonProperty("value")
    private String value;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public TunedMatch() {
    }

    public TunedMatch(String label, List<io.fabric8.openshift.api.model.tuned.v1.TunedMatch> match, String type, String value) {
        super();
        this.label = label;
        this.match = match;
        this.type = type;
        this.value = value;
    }

    /**
     * Node or Pod label name.
     */
    @JsonProperty("label")
    public String getLabel() {
        return label;
    }

    /**
     * Node or Pod label name.
     */
    @JsonProperty("label")
    public void setLabel(String label) {
        this.label = label;
    }

    /**
     * Additional rules governing application of the tuned profile connected by logical AND operator.
     */
    @JsonProperty("match")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<io.fabric8.openshift.api.model.tuned.v1.TunedMatch> getMatch() {
        return match;
    }

    /**
     * Additional rules governing application of the tuned profile connected by logical AND operator.
     */
    @JsonProperty("match")
    public void setMatch(List<io.fabric8.openshift.api.model.tuned.v1.TunedMatch> match) {
        this.match = match;
    }

    /**
     * Match type: [node/pod]. If omitted, "node" is assumed.
     */
    @JsonProperty("type")
    public String getType() {
        return type;
    }

    /**
     * Match type: [node/pod]. If omitted, "node" is assumed.
     */
    @JsonProperty("type")
    public void setType(String type) {
        this.type = type;
    }

    /**
     * Node or Pod label value. If omitted, the presence of label name is enough to match.
     */
    @JsonProperty("value")
    public String getValue() {
        return value;
    }

    /**
     * Node or Pod label value. If omitted, the presence of label name is enough to match.
     */
    @JsonProperty("value")
    public void setValue(String value) {
        this.value = value;
    }

    @JsonIgnore
    public TunedMatchBuilder edit() {
        return new TunedMatchBuilder(this);
    }

    @JsonIgnore
    public TunedMatchBuilder toBuilder() {
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
        if (!(o instanceof TunedMatch)) {
            return false;
        }
        TunedMatch other = (TunedMatch) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$label = this.getLabel();
        Object other$label = other.getLabel();
        if (this$label == null ? other$label != null : !this$label.equals(other$label)) {
            return false;
        }
        Object this$match = this.getMatch();
        Object other$match = other.getMatch();
        if (this$match == null ? other$match != null : !this$match.equals(other$match)) {
            return false;
        }
        Object this$type = this.getType();
        Object other$type = other.getType();
        if (this$type == null ? other$type != null : !this$type.equals(other$type)) {
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
        return other instanceof TunedMatch;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $label = this.getLabel();
        result = result * prime + ($label == null ? 43 : $label.hashCode());
        Object $match = this.getMatch();
        result = result * prime + ($match == null ? 43 : $match.hashCode());
        Object $type = this.getType();
        result = result * prime + ($type == null ? 43 : $type.hashCode());
        Object $value = this.getValue();
        result = result * prime + ($value == null ? 43 : $value.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "TunedMatch(" + "label=" + this.getLabel() + ", match=" + this.getMatch() + ", type=" + this.getType() + ", value=" + this.getValue() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
