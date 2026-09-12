
package io.fabric8.openshift.api.model.operatorhub.v1;

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
 * Components tracks the resources that compose an operator.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "labelSelector",
    "refs"
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
public class Components implements Editable<ComponentsBuilder>, KubernetesResource
{

    @JsonProperty("labelSelector")
    private LabelSelector labelSelector;
    @JsonProperty("refs")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<RichReference> refs = new ArrayList<>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public Components() {
    }

    public Components(LabelSelector labelSelector, List<RichReference> refs) {
        super();
        this.labelSelector = labelSelector;
        this.refs = refs;
    }

    /**
     * Components tracks the resources that compose an operator.
     */
    @JsonProperty("labelSelector")
    public LabelSelector getLabelSelector() {
        return labelSelector;
    }

    /**
     * Components tracks the resources that compose an operator.
     */
    @JsonProperty("labelSelector")
    public void setLabelSelector(LabelSelector labelSelector) {
        this.labelSelector = labelSelector;
    }

    /**
     * Refs are a set of references to the operator's component resources, selected with LabelSelector.
     */
    @JsonProperty("refs")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<RichReference> getRefs() {
        return refs;
    }

    /**
     * Refs are a set of references to the operator's component resources, selected with LabelSelector.
     */
    @JsonProperty("refs")
    public void setRefs(List<RichReference> refs) {
        this.refs = refs;
    }

    @JsonIgnore
    public ComponentsBuilder edit() {
        return new ComponentsBuilder(this);
    }

    @JsonIgnore
    public ComponentsBuilder toBuilder() {
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
        if (!(o instanceof Components)) {
            return false;
        }
        Components other = (Components) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$labelSelector = this.getLabelSelector();
        Object other$labelSelector = other.getLabelSelector();
        if (this$labelSelector == null ? other$labelSelector != null : !this$labelSelector.equals(other$labelSelector)) {
            return false;
        }
        Object this$refs = this.getRefs();
        Object other$refs = other.getRefs();
        if (this$refs == null ? other$refs != null : !this$refs.equals(other$refs)) {
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
        return other instanceof Components;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $labelSelector = this.getLabelSelector();
        result = result * prime + ($labelSelector == null ? 43 : $labelSelector.hashCode());
        Object $refs = this.getRefs();
        result = result * prime + ($refs == null ? 43 : $refs.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "Components(" + "labelSelector=" + this.getLabelSelector() + ", refs=" + this.getRefs() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
