
package io.fabric8.openshift.api.model;

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
    "cancelled",
    "completionTimestamp",
    "conditions",
    "config",
    "duration",
    "logSnippet",
    "message",
    "output",
    "outputDockerImageReference",
    "phase",
    "reason",
    "stages",
    "startTimestamp"
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
    @BuildableReference(io.fabric8.kubernetes.api.model.ObjectReference.class),
    @BuildableReference(LocalObjectReference.class),
    @BuildableReference(PersistentVolumeClaim.class)
})
@Generated("jsonschema2pojo")
public class BuildStatus implements KubernetesResource
{

    @JsonProperty("cancelled")
    private Boolean cancelled;
    @JsonProperty("completionTimestamp")
    private String completionTimestamp;
    @JsonProperty("conditions")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<BuildCondition> conditions = new ArrayList<BuildCondition>();
    @JsonProperty("config")
    private io.fabric8.kubernetes.api.model.ObjectReference config;
    @JsonProperty("duration")
    private Long duration;
    @JsonProperty("logSnippet")
    private java.lang.String logSnippet;
    @JsonProperty("message")
    private java.lang.String message;
    @JsonProperty("output")
    private BuildStatusOutput output;
    @JsonProperty("outputDockerImageReference")
    private java.lang.String outputDockerImageReference;
    @JsonProperty("phase")
    private java.lang.String phase;
    @JsonProperty("reason")
    private java.lang.String reason;
    @JsonProperty("stages")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<StageInfo> stages = new ArrayList<StageInfo>();
    @JsonProperty("startTimestamp")
    private String startTimestamp;
    @JsonIgnore
    private Map<java.lang.String, Object> additionalProperties = new LinkedHashMap<java.lang.String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public BuildStatus() {
    }

    public BuildStatus(Boolean cancelled, String completionTimestamp, List<BuildCondition> conditions, io.fabric8.kubernetes.api.model.ObjectReference config, Long duration, java.lang.String logSnippet, java.lang.String message, BuildStatusOutput output, java.lang.String outputDockerImageReference, java.lang.String phase, java.lang.String reason, List<StageInfo> stages, String startTimestamp) {
        super();
        this.cancelled = cancelled;
        this.completionTimestamp = completionTimestamp;
        this.conditions = conditions;
        this.config = config;
        this.duration = duration;
        this.logSnippet = logSnippet;
        this.message = message;
        this.output = output;
        this.outputDockerImageReference = outputDockerImageReference;
        this.phase = phase;
        this.reason = reason;
        this.stages = stages;
        this.startTimestamp = startTimestamp;
    }

    @JsonProperty("cancelled")
    public Boolean getCancelled() {
        return cancelled;
    }

    @JsonProperty("cancelled")
    public void setCancelled(Boolean cancelled) {
        this.cancelled = cancelled;
    }

    @JsonProperty("completionTimestamp")
    public String getCompletionTimestamp() {
        return completionTimestamp;
    }

    @JsonProperty("completionTimestamp")
    public void setCompletionTimestamp(String completionTimestamp) {
        this.completionTimestamp = completionTimestamp;
    }

    @JsonProperty("conditions")
    public List<BuildCondition> getConditions() {
        return conditions;
    }

    @JsonProperty("conditions")
    public void setConditions(List<BuildCondition> conditions) {
        this.conditions = conditions;
    }

    @JsonProperty("config")
    public io.fabric8.kubernetes.api.model.ObjectReference getConfig() {
        return config;
    }

    @JsonProperty("config")
    public void setConfig(io.fabric8.kubernetes.api.model.ObjectReference config) {
        this.config = config;
    }

    @JsonProperty("duration")
    public Long getDuration() {
        return duration;
    }

    @JsonProperty("duration")
    public void setDuration(Long duration) {
        this.duration = duration;
    }

    @JsonProperty("logSnippet")
    public java.lang.String getLogSnippet() {
        return logSnippet;
    }

    @JsonProperty("logSnippet")
    public void setLogSnippet(java.lang.String logSnippet) {
        this.logSnippet = logSnippet;
    }

    @JsonProperty("message")
    public java.lang.String getMessage() {
        return message;
    }

    @JsonProperty("message")
    public void setMessage(java.lang.String message) {
        this.message = message;
    }

    @JsonProperty("output")
    public BuildStatusOutput getOutput() {
        return output;
    }

    @JsonProperty("output")
    public void setOutput(BuildStatusOutput output) {
        this.output = output;
    }

    @JsonProperty("outputDockerImageReference")
    public java.lang.String getOutputDockerImageReference() {
        return outputDockerImageReference;
    }

    @JsonProperty("outputDockerImageReference")
    public void setOutputDockerImageReference(java.lang.String outputDockerImageReference) {
        this.outputDockerImageReference = outputDockerImageReference;
    }

    @JsonProperty("phase")
    public java.lang.String getPhase() {
        return phase;
    }

    @JsonProperty("phase")
    public void setPhase(java.lang.String phase) {
        this.phase = phase;
    }

    @JsonProperty("reason")
    public java.lang.String getReason() {
        return reason;
    }

    @JsonProperty("reason")
    public void setReason(java.lang.String reason) {
        this.reason = reason;
    }

    @JsonProperty("stages")
    public List<StageInfo> getStages() {
        return stages;
    }

    @JsonProperty("stages")
    public void setStages(List<StageInfo> stages) {
        this.stages = stages;
    }

    @JsonProperty("startTimestamp")
    public String getStartTimestamp() {
        return startTimestamp;
    }

    @JsonProperty("startTimestamp")
    public void setStartTimestamp(String startTimestamp) {
        this.startTimestamp = startTimestamp;
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
