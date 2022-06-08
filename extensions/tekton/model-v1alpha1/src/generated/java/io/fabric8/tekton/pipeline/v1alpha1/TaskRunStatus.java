
package io.fabric8.tekton.pipeline.v1alpha1;

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
import io.fabric8.knative.internal.pkg.apis.Condition;
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
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "apiVersion",
    "kind",
    "metadata",
    "cloudEvents",
    "completionTime",
    "conditions",
    "observedGeneration",
    "podName",
    "resourcesResult",
    "retriesStatus",
    "sidecars",
    "startTime",
    "steps"
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
public class TaskRunStatus implements KubernetesResource
{

    @JsonProperty("cloudEvents")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<CloudEventDelivery> cloudEvents = new ArrayList<CloudEventDelivery>();
    @JsonProperty("completionTime")
    private String completionTime;
    @JsonProperty("conditions")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<Condition> conditions = new ArrayList<Condition>();
    @JsonProperty("observedGeneration")
    private Long observedGeneration;
    @JsonProperty("podName")
    private String podName;
    @JsonProperty("resourcesResult")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<PipelineResourceResult> resourcesResult = new ArrayList<PipelineResourceResult>();
    @JsonProperty("retriesStatus")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<TaskRunStatus> retriesStatus = new ArrayList<TaskRunStatus>();
    @JsonProperty("sidecars")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<SidecarState> sidecars = new ArrayList<SidecarState>();
    @JsonProperty("startTime")
    private String startTime;
    @JsonProperty("steps")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<StepState> steps = new ArrayList<StepState>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public TaskRunStatus() {
    }

    /**
     * 
     * @param cloudEvents
     * @param completionTime
     * @param sidecars
     * @param retriesStatus
     * @param podName
     * @param startTime
     * @param conditions
     * @param resourcesResult
     * @param steps
     * @param observedGeneration
     */
    public TaskRunStatus(List<CloudEventDelivery> cloudEvents, String completionTime, List<Condition> conditions, Long observedGeneration, String podName, List<PipelineResourceResult> resourcesResult, List<TaskRunStatus> retriesStatus, List<SidecarState> sidecars, String startTime, List<StepState> steps) {
        super();
        this.cloudEvents = cloudEvents;
        this.completionTime = completionTime;
        this.conditions = conditions;
        this.observedGeneration = observedGeneration;
        this.podName = podName;
        this.resourcesResult = resourcesResult;
        this.retriesStatus = retriesStatus;
        this.sidecars = sidecars;
        this.startTime = startTime;
        this.steps = steps;
    }

    @JsonProperty("cloudEvents")
    public List<CloudEventDelivery> getCloudEvents() {
        return cloudEvents;
    }

    @JsonProperty("cloudEvents")
    public void setCloudEvents(List<CloudEventDelivery> cloudEvents) {
        this.cloudEvents = cloudEvents;
    }

    @JsonProperty("completionTime")
    public String getCompletionTime() {
        return completionTime;
    }

    @JsonProperty("completionTime")
    public void setCompletionTime(String completionTime) {
        this.completionTime = completionTime;
    }

    @JsonProperty("conditions")
    public List<Condition> getConditions() {
        return conditions;
    }

    @JsonProperty("conditions")
    public void setConditions(List<Condition> conditions) {
        this.conditions = conditions;
    }

    @JsonProperty("observedGeneration")
    public Long getObservedGeneration() {
        return observedGeneration;
    }

    @JsonProperty("observedGeneration")
    public void setObservedGeneration(Long observedGeneration) {
        this.observedGeneration = observedGeneration;
    }

    @JsonProperty("podName")
    public String getPodName() {
        return podName;
    }

    @JsonProperty("podName")
    public void setPodName(String podName) {
        this.podName = podName;
    }

    @JsonProperty("resourcesResult")
    public List<PipelineResourceResult> getResourcesResult() {
        return resourcesResult;
    }

    @JsonProperty("resourcesResult")
    public void setResourcesResult(List<PipelineResourceResult> resourcesResult) {
        this.resourcesResult = resourcesResult;
    }

    @JsonProperty("retriesStatus")
    public List<TaskRunStatus> getRetriesStatus() {
        return retriesStatus;
    }

    @JsonProperty("retriesStatus")
    public void setRetriesStatus(List<TaskRunStatus> retriesStatus) {
        this.retriesStatus = retriesStatus;
    }

    @JsonProperty("sidecars")
    public List<SidecarState> getSidecars() {
        return sidecars;
    }

    @JsonProperty("sidecars")
    public void setSidecars(List<SidecarState> sidecars) {
        this.sidecars = sidecars;
    }

    @JsonProperty("startTime")
    public String getStartTime() {
        return startTime;
    }

    @JsonProperty("startTime")
    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    @JsonProperty("steps")
    public List<StepState> getSteps() {
        return steps;
    }

    @JsonProperty("steps")
    public void setSteps(List<StepState> steps) {
        this.steps = steps;
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
