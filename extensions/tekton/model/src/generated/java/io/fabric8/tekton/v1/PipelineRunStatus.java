
package io.fabric8.tekton.v1;

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
import io.fabric8.knative.pkg.apis.Condition;
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
 * PipelineRunStatus defines the observed state of PipelineRun
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "annotations",
    "childReferences",
    "completionTime",
    "conditions",
    "finallyStartTime",
    "observedGeneration",
    "pipelineSpec",
    "provenance",
    "results",
    "skippedTasks",
    "spanContext",
    "startTime"
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
public class PipelineRunStatus implements Editable<PipelineRunStatusBuilder>, KubernetesResource
{

    @JsonProperty("annotations")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Map<String, String> annotations = new LinkedHashMap<>();
    @JsonProperty("childReferences")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<ChildStatusReference> childReferences = new ArrayList<>();
    @JsonProperty("completionTime")
    private String completionTime;
    @JsonProperty("conditions")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<Condition> conditions = new ArrayList<>();
    @JsonProperty("finallyStartTime")
    private String finallyStartTime;
    @JsonProperty("observedGeneration")
    private Long observedGeneration;
    @JsonProperty("pipelineSpec")
    private PipelineSpec pipelineSpec;
    @JsonProperty("provenance")
    private Provenance provenance;
    @JsonProperty("results")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<PipelineRunResult> results = new ArrayList<>();
    @JsonProperty("skippedTasks")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<SkippedTask> skippedTasks = new ArrayList<>();
    @JsonProperty("spanContext")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Map<String, String> spanContext = new LinkedHashMap<>();
    @JsonProperty("startTime")
    private String startTime;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public PipelineRunStatus() {
    }

    public PipelineRunStatus(Map<String, String> annotations, List<ChildStatusReference> childReferences, String completionTime, List<Condition> conditions, String finallyStartTime, Long observedGeneration, PipelineSpec pipelineSpec, Provenance provenance, List<PipelineRunResult> results, List<SkippedTask> skippedTasks, Map<String, String> spanContext, String startTime) {
        super();
        this.annotations = annotations;
        this.childReferences = childReferences;
        this.completionTime = completionTime;
        this.conditions = conditions;
        this.finallyStartTime = finallyStartTime;
        this.observedGeneration = observedGeneration;
        this.pipelineSpec = pipelineSpec;
        this.provenance = provenance;
        this.results = results;
        this.skippedTasks = skippedTasks;
        this.spanContext = spanContext;
        this.startTime = startTime;
    }

    /**
     * Annotations is additional Status fields for the Resource to save some additional State as well as convey more information to the user. This is roughly akin to Annotations on any k8s resource, just the reconciler conveying richer information outwards.
     */
    @JsonProperty("annotations")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public Map<String, String> getAnnotations() {
        return annotations;
    }

    /**
     * Annotations is additional Status fields for the Resource to save some additional State as well as convey more information to the user. This is roughly akin to Annotations on any k8s resource, just the reconciler conveying richer information outwards.
     */
    @JsonProperty("annotations")
    public void setAnnotations(Map<String, String> annotations) {
        this.annotations = annotations;
    }

    /**
     * list of TaskRun and Run names, PipelineTask names, and API versions/kinds for children of this PipelineRun.
     */
    @JsonProperty("childReferences")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<ChildStatusReference> getChildReferences() {
        return childReferences;
    }

    /**
     * list of TaskRun and Run names, PipelineTask names, and API versions/kinds for children of this PipelineRun.
     */
    @JsonProperty("childReferences")
    public void setChildReferences(List<ChildStatusReference> childReferences) {
        this.childReferences = childReferences;
    }

    /**
     * PipelineRunStatus defines the observed state of PipelineRun
     */
    @JsonProperty("completionTime")
    public String getCompletionTime() {
        return completionTime;
    }

    /**
     * PipelineRunStatus defines the observed state of PipelineRun
     */
    @JsonProperty("completionTime")
    public void setCompletionTime(String completionTime) {
        this.completionTime = completionTime;
    }

    /**
     * Conditions the latest available observations of a resource's current state.
     */
    @JsonProperty("conditions")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<Condition> getConditions() {
        return conditions;
    }

    /**
     * Conditions the latest available observations of a resource's current state.
     */
    @JsonProperty("conditions")
    public void setConditions(List<Condition> conditions) {
        this.conditions = conditions;
    }

    /**
     * PipelineRunStatus defines the observed state of PipelineRun
     */
    @JsonProperty("finallyStartTime")
    public String getFinallyStartTime() {
        return finallyStartTime;
    }

    /**
     * PipelineRunStatus defines the observed state of PipelineRun
     */
    @JsonProperty("finallyStartTime")
    public void setFinallyStartTime(String finallyStartTime) {
        this.finallyStartTime = finallyStartTime;
    }

    /**
     * ObservedGeneration is the 'Generation' of the Service that was last processed by the controller.
     */
    @JsonProperty("observedGeneration")
    public Long getObservedGeneration() {
        return observedGeneration;
    }

    /**
     * ObservedGeneration is the 'Generation' of the Service that was last processed by the controller.
     */
    @JsonProperty("observedGeneration")
    public void setObservedGeneration(Long observedGeneration) {
        this.observedGeneration = observedGeneration;
    }

    /**
     * PipelineRunStatus defines the observed state of PipelineRun
     */
    @JsonProperty("pipelineSpec")
    public PipelineSpec getPipelineSpec() {
        return pipelineSpec;
    }

    /**
     * PipelineRunStatus defines the observed state of PipelineRun
     */
    @JsonProperty("pipelineSpec")
    public void setPipelineSpec(PipelineSpec pipelineSpec) {
        this.pipelineSpec = pipelineSpec;
    }

    /**
     * PipelineRunStatus defines the observed state of PipelineRun
     */
    @JsonProperty("provenance")
    public Provenance getProvenance() {
        return provenance;
    }

    /**
     * PipelineRunStatus defines the observed state of PipelineRun
     */
    @JsonProperty("provenance")
    public void setProvenance(Provenance provenance) {
        this.provenance = provenance;
    }

    /**
     * Results are the list of results written out by the pipeline task's containers
     */
    @JsonProperty("results")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<PipelineRunResult> getResults() {
        return results;
    }

    /**
     * Results are the list of results written out by the pipeline task's containers
     */
    @JsonProperty("results")
    public void setResults(List<PipelineRunResult> results) {
        this.results = results;
    }

    /**
     * list of tasks that were skipped due to when expressions evaluating to false
     */
    @JsonProperty("skippedTasks")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<SkippedTask> getSkippedTasks() {
        return skippedTasks;
    }

    /**
     * list of tasks that were skipped due to when expressions evaluating to false
     */
    @JsonProperty("skippedTasks")
    public void setSkippedTasks(List<SkippedTask> skippedTasks) {
        this.skippedTasks = skippedTasks;
    }

    /**
     * SpanContext contains tracing span context fields
     */
    @JsonProperty("spanContext")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public Map<String, String> getSpanContext() {
        return spanContext;
    }

    /**
     * SpanContext contains tracing span context fields
     */
    @JsonProperty("spanContext")
    public void setSpanContext(Map<String, String> spanContext) {
        this.spanContext = spanContext;
    }

    /**
     * PipelineRunStatus defines the observed state of PipelineRun
     */
    @JsonProperty("startTime")
    public String getStartTime() {
        return startTime;
    }

    /**
     * PipelineRunStatus defines the observed state of PipelineRun
     */
    @JsonProperty("startTime")
    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    @JsonIgnore
    public PipelineRunStatusBuilder edit() {
        return new PipelineRunStatusBuilder(this);
    }

    @JsonIgnore
    public PipelineRunStatusBuilder toBuilder() {
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
        if (!(o instanceof PipelineRunStatus)) {
            return false;
        }
        PipelineRunStatus other = (PipelineRunStatus) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$annotations = this.getAnnotations();
        Object other$annotations = other.getAnnotations();
        if (this$annotations == null ? other$annotations != null : !this$annotations.equals(other$annotations)) {
            return false;
        }
        Object this$childReferences = this.getChildReferences();
        Object other$childReferences = other.getChildReferences();
        if (this$childReferences == null ? other$childReferences != null : !this$childReferences.equals(other$childReferences)) {
            return false;
        }
        Object this$completionTime = this.getCompletionTime();
        Object other$completionTime = other.getCompletionTime();
        if (this$completionTime == null ? other$completionTime != null : !this$completionTime.equals(other$completionTime)) {
            return false;
        }
        Object this$conditions = this.getConditions();
        Object other$conditions = other.getConditions();
        if (this$conditions == null ? other$conditions != null : !this$conditions.equals(other$conditions)) {
            return false;
        }
        Object this$finallyStartTime = this.getFinallyStartTime();
        Object other$finallyStartTime = other.getFinallyStartTime();
        if (this$finallyStartTime == null ? other$finallyStartTime != null : !this$finallyStartTime.equals(other$finallyStartTime)) {
            return false;
        }
        Object this$observedGeneration = this.getObservedGeneration();
        Object other$observedGeneration = other.getObservedGeneration();
        if (this$observedGeneration == null ? other$observedGeneration != null : !this$observedGeneration.equals(other$observedGeneration)) {
            return false;
        }
        Object this$pipelineSpec = this.getPipelineSpec();
        Object other$pipelineSpec = other.getPipelineSpec();
        if (this$pipelineSpec == null ? other$pipelineSpec != null : !this$pipelineSpec.equals(other$pipelineSpec)) {
            return false;
        }
        Object this$provenance = this.getProvenance();
        Object other$provenance = other.getProvenance();
        if (this$provenance == null ? other$provenance != null : !this$provenance.equals(other$provenance)) {
            return false;
        }
        Object this$results = this.getResults();
        Object other$results = other.getResults();
        if (this$results == null ? other$results != null : !this$results.equals(other$results)) {
            return false;
        }
        Object this$skippedTasks = this.getSkippedTasks();
        Object other$skippedTasks = other.getSkippedTasks();
        if (this$skippedTasks == null ? other$skippedTasks != null : !this$skippedTasks.equals(other$skippedTasks)) {
            return false;
        }
        Object this$spanContext = this.getSpanContext();
        Object other$spanContext = other.getSpanContext();
        if (this$spanContext == null ? other$spanContext != null : !this$spanContext.equals(other$spanContext)) {
            return false;
        }
        Object this$startTime = this.getStartTime();
        Object other$startTime = other.getStartTime();
        if (this$startTime == null ? other$startTime != null : !this$startTime.equals(other$startTime)) {
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
        return other instanceof PipelineRunStatus;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $annotations = this.getAnnotations();
        result = result * prime + ($annotations == null ? 43 : $annotations.hashCode());
        Object $childReferences = this.getChildReferences();
        result = result * prime + ($childReferences == null ? 43 : $childReferences.hashCode());
        Object $completionTime = this.getCompletionTime();
        result = result * prime + ($completionTime == null ? 43 : $completionTime.hashCode());
        Object $conditions = this.getConditions();
        result = result * prime + ($conditions == null ? 43 : $conditions.hashCode());
        Object $finallyStartTime = this.getFinallyStartTime();
        result = result * prime + ($finallyStartTime == null ? 43 : $finallyStartTime.hashCode());
        Object $observedGeneration = this.getObservedGeneration();
        result = result * prime + ($observedGeneration == null ? 43 : $observedGeneration.hashCode());
        Object $pipelineSpec = this.getPipelineSpec();
        result = result * prime + ($pipelineSpec == null ? 43 : $pipelineSpec.hashCode());
        Object $provenance = this.getProvenance();
        result = result * prime + ($provenance == null ? 43 : $provenance.hashCode());
        Object $results = this.getResults();
        result = result * prime + ($results == null ? 43 : $results.hashCode());
        Object $skippedTasks = this.getSkippedTasks();
        result = result * prime + ($skippedTasks == null ? 43 : $skippedTasks.hashCode());
        Object $spanContext = this.getSpanContext();
        result = result * prime + ($spanContext == null ? 43 : $spanContext.hashCode());
        Object $startTime = this.getStartTime();
        result = result * prime + ($startTime == null ? 43 : $startTime.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "PipelineRunStatus(" + "annotations=" + this.getAnnotations() + ", childReferences=" + this.getChildReferences() + ", completionTime=" + this.getCompletionTime() + ", conditions=" + this.getConditions() + ", finallyStartTime=" + this.getFinallyStartTime() + ", observedGeneration=" + this.getObservedGeneration() + ", pipelineSpec=" + this.getPipelineSpec() + ", provenance=" + this.getProvenance() + ", results=" + this.getResults() + ", skippedTasks=" + this.getSkippedTasks() + ", spanContext=" + this.getSpanContext() + ", startTime=" + this.getStartTime() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
