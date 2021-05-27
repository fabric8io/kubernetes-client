
package io.fabric8.openshift.api.model.monitoring.v1;

import java.util.ArrayList;
import java.util.HashMap;
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
import io.fabric8.kubernetes.api.model.IntOrString;
import io.fabric8.kubernetes.api.model.KubernetesResource;
import io.fabric8.kubernetes.api.model.LocalObjectReference;
import io.fabric8.kubernetes.api.model.ObjectMeta;
import io.fabric8.kubernetes.api.model.ObjectReference;
import io.fabric8.kubernetes.api.model.PersistentVolumeClaim;
import io.fabric8.kubernetes.api.model.PodTemplateSpec;
import io.fabric8.kubernetes.api.model.ResourceRequirements;
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "apiVersion",
    "kind",
    "metadata",
    "jobLabel",
    "namespaceSelector",
    "podMetricsEndpoints",
    "podTargetLabels",
    "sampleLimit",
    "selector",
    "targetLimit"
})
@ToString
@EqualsAndHashCode
@Buildable(editableEnabled = false, validationEnabled = false, generateBuilderPackage = false, lazyCollectionInitEnabled = false, builderPackage = "io.fabric8.kubernetes.api.builder", refs = {
    @BuildableReference(ObjectMeta.class),
    @BuildableReference(io.fabric8.kubernetes.api.model.LabelSelector.class),
    @BuildableReference(Container.class),
    @BuildableReference(PodTemplateSpec.class),
    @BuildableReference(ResourceRequirements.class),
    @BuildableReference(IntOrString.class),
    @BuildableReference(ObjectReference.class),
    @BuildableReference(LocalObjectReference.class),
    @BuildableReference(PersistentVolumeClaim.class)
})
public class PodMonitorSpec implements KubernetesResource
{

    @JsonProperty("jobLabel")
    private String jobLabel;
    @JsonProperty("namespaceSelector")
    private NamespaceSelector namespaceSelector;
    @JsonProperty("podMetricsEndpoints")
    private List<PodMetricsEndpoint> podMetricsEndpoints = new ArrayList<PodMetricsEndpoint>();
    @JsonProperty("podTargetLabels")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> podTargetLabels = new ArrayList<String>();
    @JsonProperty("sampleLimit")
    private Long sampleLimit;
    @JsonProperty("selector")
    private io.fabric8.kubernetes.api.model.LabelSelector selector;
    @JsonProperty("targetLimit")
    private Long targetLimit;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public PodMonitorSpec() {
    }

    /**
     * 
     * @param jobLabel
     * @param podTargetLabels
     * @param sampleLimit
     * @param targetLimit
     * @param namespaceSelector
     * @param podMetricsEndpoints
     * @param selector
     */
    public PodMonitorSpec(String jobLabel, NamespaceSelector namespaceSelector, List<PodMetricsEndpoint> podMetricsEndpoints, List<String> podTargetLabels, Long sampleLimit, io.fabric8.kubernetes.api.model.LabelSelector selector, Long targetLimit) {
        super();
        this.jobLabel = jobLabel;
        this.namespaceSelector = namespaceSelector;
        this.podMetricsEndpoints = podMetricsEndpoints;
        this.podTargetLabels = podTargetLabels;
        this.sampleLimit = sampleLimit;
        this.selector = selector;
        this.targetLimit = targetLimit;
    }

    @JsonProperty("jobLabel")
    public String getJobLabel() {
        return jobLabel;
    }

    @JsonProperty("jobLabel")
    public void setJobLabel(String jobLabel) {
        this.jobLabel = jobLabel;
    }

    @JsonProperty("namespaceSelector")
    public NamespaceSelector getNamespaceSelector() {
        return namespaceSelector;
    }

    @JsonProperty("namespaceSelector")
    public void setNamespaceSelector(NamespaceSelector namespaceSelector) {
        this.namespaceSelector = namespaceSelector;
    }

    @JsonProperty("podMetricsEndpoints")
    public List<PodMetricsEndpoint> getPodMetricsEndpoints() {
        return podMetricsEndpoints;
    }

    @JsonProperty("podMetricsEndpoints")
    public void setPodMetricsEndpoints(List<PodMetricsEndpoint> podMetricsEndpoints) {
        this.podMetricsEndpoints = podMetricsEndpoints;
    }

    @JsonProperty("podTargetLabels")
    public List<String> getPodTargetLabels() {
        return podTargetLabels;
    }

    @JsonProperty("podTargetLabels")
    public void setPodTargetLabels(List<String> podTargetLabels) {
        this.podTargetLabels = podTargetLabels;
    }

    @JsonProperty("sampleLimit")
    public Long getSampleLimit() {
        return sampleLimit;
    }

    @JsonProperty("sampleLimit")
    public void setSampleLimit(Long sampleLimit) {
        this.sampleLimit = sampleLimit;
    }

    @JsonProperty("selector")
    public io.fabric8.kubernetes.api.model.LabelSelector getSelector() {
        return selector;
    }

    @JsonProperty("selector")
    public void setSelector(io.fabric8.kubernetes.api.model.LabelSelector selector) {
        this.selector = selector;
    }

    @JsonProperty("targetLimit")
    public Long getTargetLimit() {
        return targetLimit;
    }

    @JsonProperty("targetLimit")
    public void setTargetLimit(Long targetLimit) {
        this.targetLimit = targetLimit;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
