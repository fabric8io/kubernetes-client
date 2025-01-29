
package io.fabric8.chaosmesh.v1alpha1;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Generated;
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
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

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
@ToString
@EqualsAndHashCode
@Accessors(prefix = {
    "_",
    ""
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

    @JsonProperty("annotationSelectors")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public Map<String, String> getAnnotationSelectors() {
        return annotationSelectors;
    }

    @JsonProperty("annotationSelectors")
    public void setAnnotationSelectors(Map<String, String> annotationSelectors) {
        this.annotationSelectors = annotationSelectors;
    }

    @JsonProperty("fieldSelectors")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public Map<String, String> getFieldSelectors() {
        return fieldSelectors;
    }

    @JsonProperty("fieldSelectors")
    public void setFieldSelectors(Map<String, String> fieldSelectors) {
        this.fieldSelectors = fieldSelectors;
    }

    @JsonProperty("labelSelectors")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public Map<String, String> getLabelSelectors() {
        return labelSelectors;
    }

    @JsonProperty("labelSelectors")
    public void setLabelSelectors(Map<String, String> labelSelectors) {
        this.labelSelectors = labelSelectors;
    }

    @JsonProperty("namespaces")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getNamespaces() {
        return namespaces;
    }

    @JsonProperty("namespaces")
    public void setNamespaces(List<String> namespaces) {
        this.namespaces = namespaces;
    }

    @JsonProperty("nodeSelectors")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public Map<String, String> getNodeSelectors() {
        return nodeSelectors;
    }

    @JsonProperty("nodeSelectors")
    public void setNodeSelectors(Map<String, String> nodeSelectors) {
        this.nodeSelectors = nodeSelectors;
    }

    @JsonProperty("nodes")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getNodes() {
        return nodes;
    }

    @JsonProperty("nodes")
    public void setNodes(List<String> nodes) {
        this.nodes = nodes;
    }

    @JsonProperty("podPhaseSelectors")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getPodPhaseSelectors() {
        return podPhaseSelectors;
    }

    @JsonProperty("podPhaseSelectors")
    public void setPodPhaseSelectors(List<String> podPhaseSelectors) {
        this.podPhaseSelectors = podPhaseSelectors;
    }

    @JsonProperty("pods")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public Map<String, List<String>> getPods() {
        return pods;
    }

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

}
