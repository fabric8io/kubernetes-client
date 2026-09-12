
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
 * PodSelectorSpec defines the some selectors to select objects. If the all selectors are empty, all objects will be used in chaos experiment.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "annotationSelectors",
    "fieldSelectors",
    "labelSelectors",
    "namespaces",
    "nodeSelectors",
    "nodes",
    "podPhaseSelectors",
    "pods"
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
public class PodSelectorSpec implements Editable<PodSelectorSpecBuilder>, KubernetesResource
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
    @JsonProperty("nodeSelectors")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Map<String, String> nodeSelectors = new LinkedHashMap<>();
    @JsonProperty("nodes")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> nodes = new ArrayList<>();
    @JsonProperty("podPhaseSelectors")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> podPhaseSelectors = new ArrayList<>();
    @JsonProperty("pods")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Map<String, List<String>> pods = new LinkedHashMap<>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public PodSelectorSpec() {
    }

    public PodSelectorSpec(Map<String, String> annotationSelectors, Map<String, String> fieldSelectors, Map<String, String> labelSelectors, List<String> namespaces, Map<String, String> nodeSelectors, List<String> nodes, List<String> podPhaseSelectors, Map<String, List<String>> pods) {
        super();
        this.annotationSelectors = annotationSelectors;
        this.fieldSelectors = fieldSelectors;
        this.labelSelectors = labelSelectors;
        this.namespaces = namespaces;
        this.nodeSelectors = nodeSelectors;
        this.nodes = nodes;
        this.podPhaseSelectors = podPhaseSelectors;
        this.pods = pods;
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

    /**
     * Map of string keys and values that can be used to select nodes. Selector which must match a node's labels, and objects must belong to these selected nodes.
     */
    @JsonProperty("nodeSelectors")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public Map<String, String> getNodeSelectors() {
        return nodeSelectors;
    }

    /**
     * Map of string keys and values that can be used to select nodes. Selector which must match a node's labels, and objects must belong to these selected nodes.
     */
    @JsonProperty("nodeSelectors")
    public void setNodeSelectors(Map<String, String> nodeSelectors) {
        this.nodeSelectors = nodeSelectors;
    }

    /**
     * Nodes is a set of node name and objects must belong to these nodes.
     */
    @JsonProperty("nodes")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getNodes() {
        return nodes;
    }

    /**
     * Nodes is a set of node name and objects must belong to these nodes.
     */
    @JsonProperty("nodes")
    public void setNodes(List<String> nodes) {
        this.nodes = nodes;
    }

    /**
     * PodPhaseSelectors is a set of condition of a pod at the current time. supported value: Pending / Running / Succeeded / Failed / Unknown
     */
    @JsonProperty("podPhaseSelectors")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getPodPhaseSelectors() {
        return podPhaseSelectors;
    }

    /**
     * PodPhaseSelectors is a set of condition of a pod at the current time. supported value: Pending / Running / Succeeded / Failed / Unknown
     */
    @JsonProperty("podPhaseSelectors")
    public void setPodPhaseSelectors(List<String> podPhaseSelectors) {
        this.podPhaseSelectors = podPhaseSelectors;
    }

    /**
     * Pods is a map of string keys and a set values that used to select pods. The key defines the namespace which pods belong, and the each values is a set of pod names.
     */
    @JsonProperty("pods")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public Map<String, List<String>> getPods() {
        return pods;
    }

    /**
     * Pods is a map of string keys and a set values that used to select pods. The key defines the namespace which pods belong, and the each values is a set of pod names.
     */
    @JsonProperty("pods")
    public void setPods(Map<String, List<String>> pods) {
        this.pods = pods;
    }

    @JsonIgnore
    public PodSelectorSpecBuilder edit() {
        return new PodSelectorSpecBuilder(this);
    }

    @JsonIgnore
    public PodSelectorSpecBuilder toBuilder() {
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
        if (!(o instanceof PodSelectorSpec)) {
            return false;
        }
        PodSelectorSpec other = (PodSelectorSpec) o;
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
        Object this$nodeSelectors = this.getNodeSelectors();
        Object other$nodeSelectors = other.getNodeSelectors();
        if (this$nodeSelectors == null ? other$nodeSelectors != null : !this$nodeSelectors.equals(other$nodeSelectors)) {
            return false;
        }
        Object this$nodes = this.getNodes();
        Object other$nodes = other.getNodes();
        if (this$nodes == null ? other$nodes != null : !this$nodes.equals(other$nodes)) {
            return false;
        }
        Object this$podPhaseSelectors = this.getPodPhaseSelectors();
        Object other$podPhaseSelectors = other.getPodPhaseSelectors();
        if (this$podPhaseSelectors == null ? other$podPhaseSelectors != null : !this$podPhaseSelectors.equals(other$podPhaseSelectors)) {
            return false;
        }
        Object this$pods = this.getPods();
        Object other$pods = other.getPods();
        if (this$pods == null ? other$pods != null : !this$pods.equals(other$pods)) {
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
        return other instanceof PodSelectorSpec;
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
        Object $nodeSelectors = this.getNodeSelectors();
        result = result * prime + ($nodeSelectors == null ? 43 : $nodeSelectors.hashCode());
        Object $nodes = this.getNodes();
        result = result * prime + ($nodes == null ? 43 : $nodes.hashCode());
        Object $podPhaseSelectors = this.getPodPhaseSelectors();
        result = result * prime + ($podPhaseSelectors == null ? 43 : $podPhaseSelectors.hashCode());
        Object $pods = this.getPods();
        result = result * prime + ($pods == null ? 43 : $pods.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "PodSelectorSpec(" + "annotationSelectors=" + this.getAnnotationSelectors() + ", fieldSelectors=" + this.getFieldSelectors() + ", labelSelectors=" + this.getLabelSelectors() + ", namespaces=" + this.getNamespaces() + ", nodeSelectors=" + this.getNodeSelectors() + ", nodes=" + this.getNodes() + ", podPhaseSelectors=" + this.getPodPhaseSelectors() + ", pods=" + this.getPods() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
