
package io.fabric8.volcano.api.model.flow.v1alpha1;

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
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * JobFlowStatus defines the observed state of JobFlow
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "completedJobs",
    "conditions",
    "failedJobs",
    "jobStatusList",
    "pendingJobs",
    "runningJobs",
    "state",
    "terminatedJobs",
    "unKnowJobs"
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
public class JobFlowStatus implements Editable<JobFlowStatusBuilder>, KubernetesResource
{

    @JsonProperty("completedJobs")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> completedJobs = new ArrayList<>();
    @JsonProperty("conditions")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Map<String, Condition> conditions = new LinkedHashMap<>();
    @JsonProperty("failedJobs")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> failedJobs = new ArrayList<>();
    @JsonProperty("jobStatusList")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<JobStatus> jobStatusList = new ArrayList<>();
    @JsonProperty("pendingJobs")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> pendingJobs = new ArrayList<>();
    @JsonProperty("runningJobs")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> runningJobs = new ArrayList<>();
    @JsonProperty("state")
    private State state;
    @JsonProperty("terminatedJobs")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> terminatedJobs = new ArrayList<>();
    @JsonProperty("unKnowJobs")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> unKnowJobs = new ArrayList<>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public JobFlowStatus() {
    }

    public JobFlowStatus(List<String> completedJobs, Map<String, Condition> conditions, List<String> failedJobs, List<JobStatus> jobStatusList, List<String> pendingJobs, List<String> runningJobs, State state, List<String> terminatedJobs, List<String> unKnowJobs) {
        super();
        this.completedJobs = completedJobs;
        this.conditions = conditions;
        this.failedJobs = failedJobs;
        this.jobStatusList = jobStatusList;
        this.pendingJobs = pendingJobs;
        this.runningJobs = runningJobs;
        this.state = state;
        this.terminatedJobs = terminatedJobs;
        this.unKnowJobs = unKnowJobs;
    }

    /**
     * JobFlowStatus defines the observed state of JobFlow
     */
    @JsonProperty("completedJobs")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getCompletedJobs() {
        return completedJobs;
    }

    /**
     * JobFlowStatus defines the observed state of JobFlow
     */
    @JsonProperty("completedJobs")
    public void setCompletedJobs(List<String> completedJobs) {
        this.completedJobs = completedJobs;
    }

    /**
     * JobFlowStatus defines the observed state of JobFlow
     */
    @JsonProperty("conditions")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public Map<String, Condition> getConditions() {
        return conditions;
    }

    /**
     * JobFlowStatus defines the observed state of JobFlow
     */
    @JsonProperty("conditions")
    public void setConditions(Map<String, Condition> conditions) {
        this.conditions = conditions;
    }

    /**
     * JobFlowStatus defines the observed state of JobFlow
     */
    @JsonProperty("failedJobs")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getFailedJobs() {
        return failedJobs;
    }

    /**
     * JobFlowStatus defines the observed state of JobFlow
     */
    @JsonProperty("failedJobs")
    public void setFailedJobs(List<String> failedJobs) {
        this.failedJobs = failedJobs;
    }

    /**
     * JobFlowStatus defines the observed state of JobFlow
     */
    @JsonProperty("jobStatusList")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<JobStatus> getJobStatusList() {
        return jobStatusList;
    }

    /**
     * JobFlowStatus defines the observed state of JobFlow
     */
    @JsonProperty("jobStatusList")
    public void setJobStatusList(List<JobStatus> jobStatusList) {
        this.jobStatusList = jobStatusList;
    }

    /**
     * INSERT ADDITIONAL STATUS FIELD - define observed state of cluster Important: Run "make" to regenerate code after modifying this file
     */
    @JsonProperty("pendingJobs")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getPendingJobs() {
        return pendingJobs;
    }

    /**
     * INSERT ADDITIONAL STATUS FIELD - define observed state of cluster Important: Run "make" to regenerate code after modifying this file
     */
    @JsonProperty("pendingJobs")
    public void setPendingJobs(List<String> pendingJobs) {
        this.pendingJobs = pendingJobs;
    }

    /**
     * JobFlowStatus defines the observed state of JobFlow
     */
    @JsonProperty("runningJobs")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getRunningJobs() {
        return runningJobs;
    }

    /**
     * JobFlowStatus defines the observed state of JobFlow
     */
    @JsonProperty("runningJobs")
    public void setRunningJobs(List<String> runningJobs) {
        this.runningJobs = runningJobs;
    }

    /**
     * JobFlowStatus defines the observed state of JobFlow
     */
    @JsonProperty("state")
    public State getState() {
        return state;
    }

    /**
     * JobFlowStatus defines the observed state of JobFlow
     */
    @JsonProperty("state")
    public void setState(State state) {
        this.state = state;
    }

    /**
     * JobFlowStatus defines the observed state of JobFlow
     */
    @JsonProperty("terminatedJobs")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getTerminatedJobs() {
        return terminatedJobs;
    }

    /**
     * JobFlowStatus defines the observed state of JobFlow
     */
    @JsonProperty("terminatedJobs")
    public void setTerminatedJobs(List<String> terminatedJobs) {
        this.terminatedJobs = terminatedJobs;
    }

    /**
     * JobFlowStatus defines the observed state of JobFlow
     */
    @JsonProperty("unKnowJobs")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getUnKnowJobs() {
        return unKnowJobs;
    }

    /**
     * JobFlowStatus defines the observed state of JobFlow
     */
    @JsonProperty("unKnowJobs")
    public void setUnKnowJobs(List<String> unKnowJobs) {
        this.unKnowJobs = unKnowJobs;
    }

    @JsonIgnore
    public JobFlowStatusBuilder edit() {
        return new JobFlowStatusBuilder(this);
    }

    @JsonIgnore
    public JobFlowStatusBuilder toBuilder() {
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
