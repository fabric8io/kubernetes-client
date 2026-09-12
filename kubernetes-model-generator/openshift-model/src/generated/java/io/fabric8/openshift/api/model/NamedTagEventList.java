
package io.fabric8.openshift.api.model;

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
 * NamedTagEventList relates a tag to its image history.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "conditions",
    "items",
    "tag"
})
@Buildable(editableEnabled = false, validationEnabled = false, generateBuilderPackage = false, lazyCollectionInitEnabled = false, builderPackage = "io.fabric8.kubernetes.api.builder", refs = {
    @BuildableReference(ObjectMeta.class),
    @BuildableReference(LabelSelector.class),
    @BuildableReference(Container.class),
    @BuildableReference(PodTemplateSpec.class),
    @BuildableReference(ResourceRequirements.class),
    @BuildableReference(IntOrString.class),
    @BuildableReference(ObjectReference.class),
    @BuildableReference(io.fabric8.kubernetes.api.model.LocalObjectReference.class),
    @BuildableReference(PersistentVolumeClaim.class),
    @BuildableReference(EnvVar.class),
    @BuildableReference(ContainerPort.class),
    @BuildableReference(Volume.class),
    @BuildableReference(VolumeMount.class)
})
@Generated("io.fabric8.kubernetes.schema.generator.model.ModelGenerator")
public class NamedTagEventList implements Editable<NamedTagEventListBuilder>, KubernetesResource
{

    @JsonProperty("conditions")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<TagEventCondition> conditions = new ArrayList<>();
    @JsonProperty("items")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<TagEvent> items = new ArrayList<>();
    @JsonProperty("tag")
    private String tag;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public NamedTagEventList() {
    }

    public NamedTagEventList(List<TagEventCondition> conditions, List<TagEvent> items, String tag) {
        super();
        this.conditions = conditions;
        this.items = items;
        this.tag = tag;
    }

    /**
     * conditions is an array of conditions that apply to the tag event list.
     */
    @JsonProperty("conditions")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<TagEventCondition> getConditions() {
        return conditions;
    }

    /**
     * conditions is an array of conditions that apply to the tag event list.
     */
    @JsonProperty("conditions")
    public void setConditions(List<TagEventCondition> conditions) {
        this.conditions = conditions;
    }

    /**
     * Standard object's metadata.
     */
    @JsonProperty("items")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<TagEvent> getItems() {
        return items;
    }

    /**
     * Standard object's metadata.
     */
    @JsonProperty("items")
    public void setItems(List<TagEvent> items) {
        this.items = items;
    }

    /**
     * tag is the tag for which the history is recorded
     */
    @JsonProperty("tag")
    public String getTag() {
        return tag;
    }

    /**
     * tag is the tag for which the history is recorded
     */
    @JsonProperty("tag")
    public void setTag(String tag) {
        this.tag = tag;
    }

    @JsonIgnore
    public NamedTagEventListBuilder edit() {
        return new NamedTagEventListBuilder(this);
    }

    @JsonIgnore
    public NamedTagEventListBuilder toBuilder() {
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
        if (!(o instanceof NamedTagEventList)) {
            return false;
        }
        NamedTagEventList other = (NamedTagEventList) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$conditions = this.getConditions();
        Object other$conditions = other.getConditions();
        if (this$conditions == null ? other$conditions != null : !this$conditions.equals(other$conditions)) {
            return false;
        }
        Object this$items = this.getItems();
        Object other$items = other.getItems();
        if (this$items == null ? other$items != null : !this$items.equals(other$items)) {
            return false;
        }
        Object this$tag = this.getTag();
        Object other$tag = other.getTag();
        if (this$tag == null ? other$tag != null : !this$tag.equals(other$tag)) {
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
        return other instanceof NamedTagEventList;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $conditions = this.getConditions();
        result = result * prime + ($conditions == null ? 43 : $conditions.hashCode());
        Object $items = this.getItems();
        result = result * prime + ($items == null ? 43 : $items.hashCode());
        Object $tag = this.getTag();
        result = result * prime + ($tag == null ? 43 : $tag.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "NamedTagEventList(" + "conditions=" + this.getConditions() + ", items=" + this.getItems() + ", tag=" + this.getTag() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
