
package io.fabric8.tekton.v1alpha1;

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
 * RunStatus defines the observed state of Run
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "annotations",
    "completionTime",
    "conditions",
    "extraFields",
    "observedGeneration",
    "results",
    "retriesStatus",
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
public class RunStatus implements Editable<RunStatusBuilder>, KubernetesResource
{

    @JsonProperty("annotations")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Map<String, String> annotations = new LinkedHashMap<>();
    @JsonProperty("completionTime")
    private String completionTime;
    @JsonProperty("conditions")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<Condition> conditions = new ArrayList<>();
    @JsonProperty("extraFields")
    @JsonDeserialize(using = io.fabric8.kubernetes.internal.KubernetesDeserializer.class)
    private Object extraFields;
    @JsonProperty("observedGeneration")
    private Long observedGeneration;
    @JsonProperty("results")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<RunResult> results = new ArrayList<>();
    @JsonProperty("retriesStatus")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<io.fabric8.tekton.v1alpha1.RunStatus> retriesStatus = new ArrayList<>();
    @JsonProperty("startTime")
    private String startTime;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public RunStatus() {
    }

    public RunStatus(Map<String, String> annotations, String completionTime, List<Condition> conditions, Object extraFields, Long observedGeneration, List<RunResult> results, List<io.fabric8.tekton.v1alpha1.RunStatus> retriesStatus, String startTime) {
        super();
        this.annotations = annotations;
        this.completionTime = completionTime;
        this.conditions = conditions;
        this.extraFields = extraFields;
        this.observedGeneration = observedGeneration;
        this.results = results;
        this.retriesStatus = retriesStatus;
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
     * RunStatus defines the observed state of Run
     */
    @JsonProperty("completionTime")
    public String getCompletionTime() {
        return completionTime;
    }

    /**
     * RunStatus defines the observed state of Run
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
     * RunStatus defines the observed state of Run
     */
    @JsonProperty("extraFields")
    public Object getExtraFields() {
        return extraFields;
    }

    /**
     * RunStatus defines the observed state of Run
     */
    @JsonProperty("extraFields")
    @JsonDeserialize(using = io.fabric8.kubernetes.internal.KubernetesDeserializer.class)
    public void setExtraFields(Object extraFields) {
        this.extraFields = extraFields;
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
     * Results reports any output result values to be consumed by later tasks in a pipeline.
     */
    @JsonProperty("results")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<RunResult> getResults() {
        return results;
    }

    /**
     * Results reports any output result values to be consumed by later tasks in a pipeline.
     */
    @JsonProperty("results")
    public void setResults(List<RunResult> results) {
        this.results = results;
    }

    /**
     * RetriesStatus contains the history of RunStatus, in case of a retry.
     */
    @JsonProperty("retriesStatus")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<io.fabric8.tekton.v1alpha1.RunStatus> getRetriesStatus() {
        return retriesStatus;
    }

    /**
     * RetriesStatus contains the history of RunStatus, in case of a retry.
     */
    @JsonProperty("retriesStatus")
    public void setRetriesStatus(List<io.fabric8.tekton.v1alpha1.RunStatus> retriesStatus) {
        this.retriesStatus = retriesStatus;
    }

    /**
     * RunStatus defines the observed state of Run
     */
    @JsonProperty("startTime")
    public String getStartTime() {
        return startTime;
    }

    /**
     * RunStatus defines the observed state of Run
     */
    @JsonProperty("startTime")
    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    @JsonIgnore
    public RunStatusBuilder edit() {
        return new RunStatusBuilder(this);
    }

    @JsonIgnore
    public RunStatusBuilder toBuilder() {
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
        if (!(o instanceof RunStatus)) {
            return false;
        }
        RunStatus other = (RunStatus) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$annotations = this.getAnnotations();
        Object other$annotations = other.getAnnotations();
        if (this$annotations == null ? other$annotations != null : !this$annotations.equals(other$annotations)) {
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
        Object this$extraFields = this.getExtraFields();
        Object other$extraFields = other.getExtraFields();
        if (this$extraFields == null ? other$extraFields != null : !this$extraFields.equals(other$extraFields)) {
            return false;
        }
        Object this$observedGeneration = this.getObservedGeneration();
        Object other$observedGeneration = other.getObservedGeneration();
        if (this$observedGeneration == null ? other$observedGeneration != null : !this$observedGeneration.equals(other$observedGeneration)) {
            return false;
        }
        Object this$results = this.getResults();
        Object other$results = other.getResults();
        if (this$results == null ? other$results != null : !this$results.equals(other$results)) {
            return false;
        }
        Object this$retriesStatus = this.getRetriesStatus();
        Object other$retriesStatus = other.getRetriesStatus();
        if (this$retriesStatus == null ? other$retriesStatus != null : !this$retriesStatus.equals(other$retriesStatus)) {
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
        return other instanceof RunStatus;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $annotations = this.getAnnotations();
        result = result * prime + ($annotations == null ? 43 : $annotations.hashCode());
        Object $completionTime = this.getCompletionTime();
        result = result * prime + ($completionTime == null ? 43 : $completionTime.hashCode());
        Object $conditions = this.getConditions();
        result = result * prime + ($conditions == null ? 43 : $conditions.hashCode());
        Object $extraFields = this.getExtraFields();
        result = result * prime + ($extraFields == null ? 43 : $extraFields.hashCode());
        Object $observedGeneration = this.getObservedGeneration();
        result = result * prime + ($observedGeneration == null ? 43 : $observedGeneration.hashCode());
        Object $results = this.getResults();
        result = result * prime + ($results == null ? 43 : $results.hashCode());
        Object $retriesStatus = this.getRetriesStatus();
        result = result * prime + ($retriesStatus == null ? 43 : $retriesStatus.hashCode());
        Object $startTime = this.getStartTime();
        result = result * prime + ($startTime == null ? 43 : $startTime.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "RunStatus(" + "annotations=" + this.getAnnotations() + ", completionTime=" + this.getCompletionTime() + ", conditions=" + this.getConditions() + ", extraFields=" + this.getExtraFields() + ", observedGeneration=" + this.getObservedGeneration() + ", results=" + this.getResults() + ", retriesStatus=" + this.getRetriesStatus() + ", startTime=" + this.getStartTime() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
