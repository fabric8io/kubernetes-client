
package io.fabric8.kubernetes.api.model.batch.v1;

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
import io.fabric8.kubernetes.api.model.Container;
import io.fabric8.kubernetes.api.model.IntOrString;
import io.fabric8.kubernetes.api.model.KubernetesResource;
import io.fabric8.kubernetes.api.model.LabelSelector;
import io.fabric8.kubernetes.api.model.LocalObjectReference;
import io.fabric8.kubernetes.api.model.ObjectMeta;
import io.fabric8.kubernetes.api.model.ObjectReference;
import io.fabric8.kubernetes.api.model.PersistentVolumeClaim;
import io.fabric8.kubernetes.api.model.PodTemplateSpec;
import io.fabric8.kubernetes.api.model.ResourceRequirements;
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
    "active",
    "completedIndexes",
    "completionTime",
    "conditions",
    "failed",
    "ready",
    "startTime",
    "succeeded",
    "uncountedTerminatedPods"
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
    @BuildableReference(PersistentVolumeClaim.class)
})
@Generated("jsonschema2pojo")
public class JobStatus implements KubernetesResource
{

    @JsonProperty("active")
    private Integer active;
    @JsonProperty("completedIndexes")
    private java.lang.String completedIndexes;
    @JsonProperty("completionTime")
    private String completionTime;
    @JsonProperty("conditions")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<JobCondition> conditions = new ArrayList<JobCondition>();
    @JsonProperty("failed")
    private Integer failed;
    @JsonProperty("ready")
    private Integer ready;
    @JsonProperty("startTime")
    private String startTime;
    @JsonProperty("succeeded")
    private Integer succeeded;
    @JsonProperty("uncountedTerminatedPods")
    private UncountedTerminatedPods uncountedTerminatedPods;
    @JsonIgnore
    private Map<java.lang.String, Object> additionalProperties = new LinkedHashMap<java.lang.String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public JobStatus() {
    }

    public JobStatus(Integer active, java.lang.String completedIndexes, String completionTime, List<JobCondition> conditions, Integer failed, Integer ready, String startTime, Integer succeeded, UncountedTerminatedPods uncountedTerminatedPods) {
        super();
        this.active = active;
        this.completedIndexes = completedIndexes;
        this.completionTime = completionTime;
        this.conditions = conditions;
        this.failed = failed;
        this.ready = ready;
        this.startTime = startTime;
        this.succeeded = succeeded;
        this.uncountedTerminatedPods = uncountedTerminatedPods;
    }

    @JsonProperty("active")
    public Integer getActive() {
        return active;
    }

    @JsonProperty("active")
    public void setActive(Integer active) {
        this.active = active;
    }

    @JsonProperty("completedIndexes")
    public java.lang.String getCompletedIndexes() {
        return completedIndexes;
    }

    @JsonProperty("completedIndexes")
    public void setCompletedIndexes(java.lang.String completedIndexes) {
        this.completedIndexes = completedIndexes;
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
    public List<JobCondition> getConditions() {
        return conditions;
    }

    @JsonProperty("conditions")
    public void setConditions(List<JobCondition> conditions) {
        this.conditions = conditions;
    }

    @JsonProperty("failed")
    public Integer getFailed() {
        return failed;
    }

    @JsonProperty("failed")
    public void setFailed(Integer failed) {
        this.failed = failed;
    }

    @JsonProperty("ready")
    public Integer getReady() {
        return ready;
    }

    @JsonProperty("ready")
    public void setReady(Integer ready) {
        this.ready = ready;
    }

    @JsonProperty("startTime")
    public String getStartTime() {
        return startTime;
    }

    @JsonProperty("startTime")
    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    @JsonProperty("succeeded")
    public Integer getSucceeded() {
        return succeeded;
    }

    @JsonProperty("succeeded")
    public void setSucceeded(Integer succeeded) {
        this.succeeded = succeeded;
    }

    @JsonProperty("uncountedTerminatedPods")
    public UncountedTerminatedPods getUncountedTerminatedPods() {
        return uncountedTerminatedPods;
    }

    @JsonProperty("uncountedTerminatedPods")
    public void setUncountedTerminatedPods(UncountedTerminatedPods uncountedTerminatedPods) {
        this.uncountedTerminatedPods = uncountedTerminatedPods;
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
