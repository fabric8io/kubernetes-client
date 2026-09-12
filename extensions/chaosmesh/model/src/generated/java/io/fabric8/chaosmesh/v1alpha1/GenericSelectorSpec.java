
package io.fabric8.chaosmesh.v1alpha1;

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
 * GenericSelectorSpec defines some selectors to select objects.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "annotationSelectors",
    "fieldSelectors",
    "labelSelectors",
    "namespaces"
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
public class GenericSelectorSpec implements Editable<GenericSelectorSpecBuilder>, KubernetesResource
{

    @JsonProperty("annotationSelectors")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Map<String, String> annotationSelectors = new LinkedHashMap<>();
    @JsonProperty("fieldSelectors")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Map<String, String> fieldSelectors = new LinkedHashMap<>();
    @JsonProperty("labelSelectors")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Map<String, String> labelSelectors = new LinkedHashMap<>();
    @JsonProperty("namespaces")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> namespaces = new ArrayList<>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public GenericSelectorSpec() {
    }

    public GenericSelectorSpec(Map<String, String> annotationSelectors, Map<String, String> fieldSelectors, Map<String, String> labelSelectors, List<String> namespaces) {
        super();
        this.annotationSelectors = annotationSelectors;
        this.fieldSelectors = fieldSelectors;
        this.labelSelectors = labelSelectors;
        this.namespaces = namespaces;
    }

    /**
     * Map of string keys and values that can be used to select objects. A selector based on annotations.
     */
    @JsonProperty("annotationSelectors")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public Map<String, String> getAnnotationSelectors() {
        return annotationSelectors;
    }

    /**
     * Map of string keys and values that can be used to select objects. A selector based on annotations.
     */
    @JsonProperty("annotationSelectors")
    public void setAnnotationSelectors(Map<String, String> annotationSelectors) {
        this.annotationSelectors = annotationSelectors;
    }

    /**
     * Map of string keys and values that can be used to select objects. A selector based on fields.
     */
    @JsonProperty("fieldSelectors")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public Map<String, String> getFieldSelectors() {
        return fieldSelectors;
    }

    /**
     * Map of string keys and values that can be used to select objects. A selector based on fields.
     */
    @JsonProperty("fieldSelectors")
    public void setFieldSelectors(Map<String, String> fieldSelectors) {
        this.fieldSelectors = fieldSelectors;
    }

    /**
     * Map of string keys and values that can be used to select objects. A selector based on labels.
     */
    @JsonProperty("labelSelectors")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public Map<String, String> getLabelSelectors() {
        return labelSelectors;
    }

    /**
     * Map of string keys and values that can be used to select objects. A selector based on labels.
     */
    @JsonProperty("labelSelectors")
    public void setLabelSelectors(Map<String, String> labelSelectors) {
        this.labelSelectors = labelSelectors;
    }

    /**
     * Namespaces is a set of namespace to which objects belong.
     */
    @JsonProperty("namespaces")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getNamespaces() {
        return namespaces;
    }

    /**
     * Namespaces is a set of namespace to which objects belong.
     */
    @JsonProperty("namespaces")
    public void setNamespaces(List<String> namespaces) {
        this.namespaces = namespaces;
    }

    @JsonIgnore
    public GenericSelectorSpecBuilder edit() {
        return new GenericSelectorSpecBuilder(this);
    }

    @JsonIgnore
    public GenericSelectorSpecBuilder toBuilder() {
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
        if (!(o instanceof GenericSelectorSpec)) {
            return false;
        }
        GenericSelectorSpec other = (GenericSelectorSpec) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$annotationSelectors = this.getAnnotationSelectors();
        Object other$annotationSelectors = other.getAnnotationSelectors();
        if (this$annotationSelectors == null ? other$annotationSelectors != null : !this$annotationSelectors.equals(other$annotationSelectors)) {
            return false;
        }
        Object this$fieldSelectors = this.getFieldSelectors();
        Object other$fieldSelectors = other.getFieldSelectors();
        if (this$fieldSelectors == null ? other$fieldSelectors != null : !this$fieldSelectors.equals(other$fieldSelectors)) {
            return false;
        }
        Object this$labelSelectors = this.getLabelSelectors();
        Object other$labelSelectors = other.getLabelSelectors();
        if (this$labelSelectors == null ? other$labelSelectors != null : !this$labelSelectors.equals(other$labelSelectors)) {
            return false;
        }
        Object this$namespaces = this.getNamespaces();
        Object other$namespaces = other.getNamespaces();
        if (this$namespaces == null ? other$namespaces != null : !this$namespaces.equals(other$namespaces)) {
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
        return other instanceof GenericSelectorSpec;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $annotationSelectors = this.getAnnotationSelectors();
        result = result * prime + ($annotationSelectors == null ? 43 : $annotationSelectors.hashCode());
        Object $fieldSelectors = this.getFieldSelectors();
        result = result * prime + ($fieldSelectors == null ? 43 : $fieldSelectors.hashCode());
        Object $labelSelectors = this.getLabelSelectors();
        result = result * prime + ($labelSelectors == null ? 43 : $labelSelectors.hashCode());
        Object $namespaces = this.getNamespaces();
        result = result * prime + ($namespaces == null ? 43 : $namespaces.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "GenericSelectorSpec(" + "annotationSelectors=" + this.getAnnotationSelectors() + ", fieldSelectors=" + this.getFieldSelectors() + ", labelSelectors=" + this.getLabelSelectors() + ", namespaces=" + this.getNamespaces() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
