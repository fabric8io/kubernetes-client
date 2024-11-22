
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
public class BuildStatus implements Editable<BuildStatusBuilder> , KubernetesResource
{

    @JsonProperty("cancelled")
    private Boolean cancelled;
    @JsonProperty("completionTimestamp")
    private String completionTimestamp;
    @JsonProperty("conditions")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<BuildCondition> conditions = new ArrayList<>();
    @JsonProperty("config")
    private ObjectReference config;
    @JsonProperty("duration")
    private Long duration;
    @JsonProperty("logSnippet")
    private String logSnippet;
    @JsonProperty("message")
    private String message;
    @JsonProperty("output")
    private BuildStatusOutput output;
    @JsonProperty("outputDockerImageReference")
    private String outputDockerImageReference;
    @JsonProperty("phase")
    private String phase;
    @JsonProperty("reason")
    private String reason;
    @JsonProperty("stages")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<StageInfo> stages = new ArrayList<>();
    @JsonProperty("startTimestamp")
    private String startTimestamp;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public BuildStatus() {
    }

    public BuildStatus(Boolean cancelled, String completionTimestamp, List<BuildCondition> conditions, ObjectReference config, Long duration, String logSnippet, String message, BuildStatusOutput output, String outputDockerImageReference, String phase, String reason, List<StageInfo> stages, String startTimestamp) {
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
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<BuildCondition> getConditions() {
        return conditions;
    }

    @JsonProperty("conditions")
    public void setConditions(List<BuildCondition> conditions) {
        this.conditions = conditions;
    }

    @JsonProperty("config")
    public ObjectReference getConfig() {
        return config;
    }

    @JsonProperty("config")
    public void setConfig(ObjectReference config) {
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
    public String getLogSnippet() {
        return logSnippet;
    }

    @JsonProperty("logSnippet")
    public void setLogSnippet(String logSnippet) {
        this.logSnippet = logSnippet;
    }

    @JsonProperty("message")
    public String getMessage() {
        return message;
    }

    @JsonProperty("message")
    public void setMessage(String message) {
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
    public String getOutputDockerImageReference() {
        return outputDockerImageReference;
    }

    @JsonProperty("outputDockerImageReference")
    public void setOutputDockerImageReference(String outputDockerImageReference) {
        this.outputDockerImageReference = outputDockerImageReference;
    }

    @JsonProperty("phase")
    public String getPhase() {
        return phase;
    }

    @JsonProperty("phase")
    public void setPhase(String phase) {
        this.phase = phase;
    }

    @JsonProperty("reason")
    public String getReason() {
        return reason;
    }

    @JsonProperty("reason")
    public void setReason(String reason) {
        this.reason = reason;
    }

    @JsonProperty("stages")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
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

    @JsonIgnore
    public BuildStatusBuilder edit() {
        return new BuildStatusBuilder(this);
    }

    @JsonIgnore
    public BuildStatusBuilder toBuilder() {
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
