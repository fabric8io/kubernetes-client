
package io.fabric8.chaosmesh.v1alpha1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.fabric8.kubernetes.api.model.Container;
import io.fabric8.kubernetes.api.model.ContainerPort;
import io.fabric8.kubernetes.api.model.EnvVar;
import io.fabric8.kubernetes.api.model.IntOrString;
import io.fabric8.kubernetes.api.model.KubernetesResource;
import io.fabric8.kubernetes.api.model.LabelSelector;
import io.fabric8.kubernetes.api.model.LabelSelectorRequirement;
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
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "apiVersion",
    "kind",
    "metadata",
    "annotationSelectors",
    "expressionSelectors",
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
@Setter
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
public class SelectorSpec implements KubernetesResource
{

    @JsonProperty("annotationSelectors")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Map<String, String> annotationSelectors = new LinkedHashMap<String, String>();
    @JsonProperty("expressionSelectors")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<LabelSelectorRequirement> expressionSelectors = new ArrayList<LabelSelectorRequirement>();
    @JsonProperty("fieldSelectors")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Map<String, String> fieldSelectors = new LinkedHashMap<String, String>();
    @JsonProperty("labelSelectors")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Map<String, String> labelSelectors = new LinkedHashMap<String, String>();
    @JsonProperty("namespaces")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<java.lang.String> namespaces = new ArrayList<java.lang.String>();
    @JsonProperty("nodeSelectors")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Map<String, String> nodeSelectors = new LinkedHashMap<String, String>();
    @JsonProperty("nodes")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<java.lang.String> nodes = new ArrayList<java.lang.String>();
    @JsonProperty("podPhaseSelectors")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<java.lang.String> podPhaseSelectors = new ArrayList<java.lang.String>();
    @JsonProperty("pods")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Map<String, List<String>> pods = new LinkedHashMap<String, List<String>>();
    @JsonIgnore
    private Map<java.lang.String, Object> additionalProperties = new HashMap<java.lang.String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public SelectorSpec() {
    }

    /**
     * 
     * @param podPhaseSelectors
     * @param expressionSelectors
     * @param fieldSelectors
     * @param nodes
     * @param labelSelectors
     * @param pods
     * @param annotationSelectors
     * @param namespaces
     * @param nodeSelectors
     */
    public SelectorSpec(Map<String, String> annotationSelectors, List<LabelSelectorRequirement> expressionSelectors, Map<String, String> fieldSelectors, Map<String, String> labelSelectors, List<java.lang.String> namespaces, Map<String, String> nodeSelectors, List<java.lang.String> nodes, List<java.lang.String> podPhaseSelectors, Map<String, List<String>> pods) {
        super();
        this.annotationSelectors = annotationSelectors;
        this.expressionSelectors = expressionSelectors;
        this.fieldSelectors = fieldSelectors;
        this.labelSelectors = labelSelectors;
        this.namespaces = namespaces;
        this.nodeSelectors = nodeSelectors;
        this.nodes = nodes;
        this.podPhaseSelectors = podPhaseSelectors;
        this.pods = pods;
    }

    @JsonProperty("annotationSelectors")
    public Map<String, String> getAnnotationSelectors() {
        return annotationSelectors;
    }

    @JsonProperty("annotationSelectors")
    public void setAnnotationSelectors(Map<String, String> annotationSelectors) {
        this.annotationSelectors = annotationSelectors;
    }

    @JsonProperty("expressionSelectors")
    public List<LabelSelectorRequirement> getExpressionSelectors() {
        return expressionSelectors;
    }

    @JsonProperty("expressionSelectors")
    public void setExpressionSelectors(List<LabelSelectorRequirement> expressionSelectors) {
        this.expressionSelectors = expressionSelectors;
    }

    @JsonProperty("fieldSelectors")
    public Map<String, String> getFieldSelectors() {
        return fieldSelectors;
    }

    @JsonProperty("fieldSelectors")
    public void setFieldSelectors(Map<String, String> fieldSelectors) {
        this.fieldSelectors = fieldSelectors;
    }

    @JsonProperty("labelSelectors")
    public Map<String, String> getLabelSelectors() {
        return labelSelectors;
    }

    @JsonProperty("labelSelectors")
    public void setLabelSelectors(Map<String, String> labelSelectors) {
        this.labelSelectors = labelSelectors;
    }

    @JsonProperty("namespaces")
    public List<java.lang.String> getNamespaces() {
        return namespaces;
    }

    @JsonProperty("namespaces")
    public void setNamespaces(List<java.lang.String> namespaces) {
        this.namespaces = namespaces;
    }

    @JsonProperty("nodeSelectors")
    public Map<String, String> getNodeSelectors() {
        return nodeSelectors;
    }

    @JsonProperty("nodeSelectors")
    public void setNodeSelectors(Map<String, String> nodeSelectors) {
        this.nodeSelectors = nodeSelectors;
    }

    @JsonProperty("nodes")
    public List<java.lang.String> getNodes() {
        return nodes;
    }

    @JsonProperty("nodes")
    public void setNodes(List<java.lang.String> nodes) {
        this.nodes = nodes;
    }

    @JsonProperty("podPhaseSelectors")
    public List<java.lang.String> getPodPhaseSelectors() {
        return podPhaseSelectors;
    }

    @JsonProperty("podPhaseSelectors")
    public void setPodPhaseSelectors(List<java.lang.String> podPhaseSelectors) {
        this.podPhaseSelectors = podPhaseSelectors;
    }

    @JsonProperty("pods")
    public Map<String, List<String>> getPods() {
        return pods;
    }

    @JsonProperty("pods")
    public void setPods(Map<String, List<String>> pods) {
        this.pods = pods;
    }

    @JsonAnyGetter
    public Map<java.lang.String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(java.lang.String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
