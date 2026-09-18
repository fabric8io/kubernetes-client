
package io.fabric8.openshift.api.model;

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
 * BuildStatus contains the status of a build
 */
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
@Buildable(editableEnabled = false, validationEnabled = false, generateBuilderPackage = false, lazyCollectionInitEnabled = false, builderPackage = "io.fabric8.kubernetes.api.builder", refs = {
    @BuildableReference(ObjectMeta.class),
    @BuildableReference(LabelSelector.class),
    @BuildableReference(Container.class),
    @BuildableReference(PodTemplateSpec.class),
    @BuildableReference(ResourceRequirements.class),
    @BuildableReference(IntOrString.class),
    @BuildableReference(ObjectReference.class),
    @BuildableReference(io.fabric8.kubernetes.api.model.LocalObjectReference.class),
    @BuildableReference(PersistentVolumeClaim.class),
    @BuildableReference(EnvVar.class),
    @BuildableReference(ContainerPort.class),
    @BuildableReference(Volume.class),
    @BuildableReference(VolumeMount.class)
})
@Generated("io.fabric8.kubernetes.schema.generator.model.ModelGenerator")
public class BuildStatus implements Editable<BuildStatusBuilder>, KubernetesResource
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

    /**
     * cancelled describes if a cancel event was triggered for the build.
     */
    @JsonProperty("cancelled")
    public Boolean getCancelled() {
        return cancelled;
    }

    /**
     * cancelled describes if a cancel event was triggered for the build.
     */
    @JsonProperty("cancelled")
    public void setCancelled(Boolean cancelled) {
        this.cancelled = cancelled;
    }

    /**
     * BuildStatus contains the status of a build
     */
    @JsonProperty("completionTimestamp")
    public String getCompletionTimestamp() {
        return completionTimestamp;
    }

    /**
     * BuildStatus contains the status of a build
     */
    @JsonProperty("completionTimestamp")
    public void setCompletionTimestamp(String completionTimestamp) {
        this.completionTimestamp = completionTimestamp;
    }

    /**
     * conditions represents the latest available observations of a build's current state.
     */
    @JsonProperty("conditions")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<BuildCondition> getConditions() {
        return conditions;
    }

    /**
     * conditions represents the latest available observations of a build's current state.
     */
    @JsonProperty("conditions")
    public void setConditions(List<BuildCondition> conditions) {
        this.conditions = conditions;
    }

    /**
     * BuildStatus contains the status of a build
     */
    @JsonProperty("config")
    public ObjectReference getConfig() {
        return config;
    }

    /**
     * BuildStatus contains the status of a build
     */
    @JsonProperty("config")
    public void setConfig(ObjectReference config) {
        this.config = config;
    }

    /**
     * duration contains time.Duration object describing build time.
     */
    @JsonProperty("duration")
    public Long getDuration() {
        return duration;
    }

    /**
     * duration contains time.Duration object describing build time.
     */
    @JsonProperty("duration")
    public void setDuration(Long duration) {
        this.duration = duration;
    }

    /**
     * logSnippet is the last few lines of the build log.  This value is only set for builds that failed.
     */
    @JsonProperty("logSnippet")
    public String getLogSnippet() {
        return logSnippet;
    }

    /**
     * logSnippet is the last few lines of the build log.  This value is only set for builds that failed.
     */
    @JsonProperty("logSnippet")
    public void setLogSnippet(String logSnippet) {
        this.logSnippet = logSnippet;
    }

    /**
     * message is a human-readable message indicating details about why the build has this status.
     */
    @JsonProperty("message")
    public String getMessage() {
        return message;
    }

    /**
     * message is a human-readable message indicating details about why the build has this status.
     */
    @JsonProperty("message")
    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * BuildStatus contains the status of a build
     */
    @JsonProperty("output")
    public BuildStatusOutput getOutput() {
        return output;
    }

    /**
     * BuildStatus contains the status of a build
     */
    @JsonProperty("output")
    public void setOutput(BuildStatusOutput output) {
        this.output = output;
    }

    /**
     * outputDockerImageReference contains a reference to the container image that will be built by this build. Its value is computed from Build.Spec.Output.To, and should include the registry address, so that it can be used to push and pull the image.
     */
    @JsonProperty("outputDockerImageReference")
    public String getOutputDockerImageReference() {
        return outputDockerImageReference;
    }

    /**
     * outputDockerImageReference contains a reference to the container image that will be built by this build. Its value is computed from Build.Spec.Output.To, and should include the registry address, so that it can be used to push and pull the image.
     */
    @JsonProperty("outputDockerImageReference")
    public void setOutputDockerImageReference(String outputDockerImageReference) {
        this.outputDockerImageReference = outputDockerImageReference;
    }

    /**
     * phase is the point in the build lifecycle. Possible values are "New", "Pending", "Running", "Complete", "Failed", "Error", and "Cancelled".
     */
    @JsonProperty("phase")
    public String getPhase() {
        return phase;
    }

    /**
     * phase is the point in the build lifecycle. Possible values are "New", "Pending", "Running", "Complete", "Failed", "Error", and "Cancelled".
     */
    @JsonProperty("phase")
    public void setPhase(String phase) {
        this.phase = phase;
    }

    /**
     * reason is a brief CamelCase string that describes any failure and is meant for machine parsing and tidy display in the CLI.
     */
    @JsonProperty("reason")
    public String getReason() {
        return reason;
    }

    /**
     * reason is a brief CamelCase string that describes any failure and is meant for machine parsing and tidy display in the CLI.
     */
    @JsonProperty("reason")
    public void setReason(String reason) {
        this.reason = reason;
    }

    /**
     * stages contains details about each stage that occurs during the build including start time, duration (in milliseconds), and the steps that occured within each stage.
     */
    @JsonProperty("stages")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<StageInfo> getStages() {
        return stages;
    }

    /**
     * stages contains details about each stage that occurs during the build including start time, duration (in milliseconds), and the steps that occured within each stage.
     */
    @JsonProperty("stages")
    public void setStages(List<StageInfo> stages) {
        this.stages = stages;
    }

    /**
     * BuildStatus contains the status of a build
     */
    @JsonProperty("startTimestamp")
    public String getStartTimestamp() {
        return startTimestamp;
    }

    /**
     * BuildStatus contains the status of a build
     */
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
        if (!(o instanceof BuildStatus)) {
            return false;
        }
        BuildStatus other = (BuildStatus) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$cancelled = this.getCancelled();
        Object other$cancelled = other.getCancelled();
        if (this$cancelled == null ? other$cancelled != null : !this$cancelled.equals(other$cancelled)) {
            return false;
        }
        Object this$completionTimestamp = this.getCompletionTimestamp();
        Object other$completionTimestamp = other.getCompletionTimestamp();
        if (this$completionTimestamp == null ? other$completionTimestamp != null : !this$completionTimestamp.equals(other$completionTimestamp)) {
            return false;
        }
        Object this$conditions = this.getConditions();
        Object other$conditions = other.getConditions();
        if (this$conditions == null ? other$conditions != null : !this$conditions.equals(other$conditions)) {
            return false;
        }
        Object this$config = this.getConfig();
        Object other$config = other.getConfig();
        if (this$config == null ? other$config != null : !this$config.equals(other$config)) {
            return false;
        }
        Object this$duration = this.getDuration();
        Object other$duration = other.getDuration();
        if (this$duration == null ? other$duration != null : !this$duration.equals(other$duration)) {
            return false;
        }
        Object this$logSnippet = this.getLogSnippet();
        Object other$logSnippet = other.getLogSnippet();
        if (this$logSnippet == null ? other$logSnippet != null : !this$logSnippet.equals(other$logSnippet)) {
            return false;
        }
        Object this$message = this.getMessage();
        Object other$message = other.getMessage();
        if (this$message == null ? other$message != null : !this$message.equals(other$message)) {
            return false;
        }
        Object this$output = this.getOutput();
        Object other$output = other.getOutput();
        if (this$output == null ? other$output != null : !this$output.equals(other$output)) {
            return false;
        }
        Object this$outputDockerImageReference = this.getOutputDockerImageReference();
        Object other$outputDockerImageReference = other.getOutputDockerImageReference();
        if (this$outputDockerImageReference == null ? other$outputDockerImageReference != null : !this$outputDockerImageReference.equals(other$outputDockerImageReference)) {
            return false;
        }
        Object this$phase = this.getPhase();
        Object other$phase = other.getPhase();
        if (this$phase == null ? other$phase != null : !this$phase.equals(other$phase)) {
            return false;
        }
        Object this$reason = this.getReason();
        Object other$reason = other.getReason();
        if (this$reason == null ? other$reason != null : !this$reason.equals(other$reason)) {
            return false;
        }
        Object this$stages = this.getStages();
        Object other$stages = other.getStages();
        if (this$stages == null ? other$stages != null : !this$stages.equals(other$stages)) {
            return false;
        }
        Object this$startTimestamp = this.getStartTimestamp();
        Object other$startTimestamp = other.getStartTimestamp();
        if (this$startTimestamp == null ? other$startTimestamp != null : !this$startTimestamp.equals(other$startTimestamp)) {
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
        return other instanceof BuildStatus;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $cancelled = this.getCancelled();
        result = result * prime + ($cancelled == null ? 43 : $cancelled.hashCode());
        Object $completionTimestamp = this.getCompletionTimestamp();
        result = result * prime + ($completionTimestamp == null ? 43 : $completionTimestamp.hashCode());
        Object $conditions = this.getConditions();
        result = result * prime + ($conditions == null ? 43 : $conditions.hashCode());
        Object $config = this.getConfig();
        result = result * prime + ($config == null ? 43 : $config.hashCode());
        Object $duration = this.getDuration();
        result = result * prime + ($duration == null ? 43 : $duration.hashCode());
        Object $logSnippet = this.getLogSnippet();
        result = result * prime + ($logSnippet == null ? 43 : $logSnippet.hashCode());
        Object $message = this.getMessage();
        result = result * prime + ($message == null ? 43 : $message.hashCode());
        Object $output = this.getOutput();
        result = result * prime + ($output == null ? 43 : $output.hashCode());
        Object $outputDockerImageReference = this.getOutputDockerImageReference();
        result = result * prime + ($outputDockerImageReference == null ? 43 : $outputDockerImageReference.hashCode());
        Object $phase = this.getPhase();
        result = result * prime + ($phase == null ? 43 : $phase.hashCode());
        Object $reason = this.getReason();
        result = result * prime + ($reason == null ? 43 : $reason.hashCode());
        Object $stages = this.getStages();
        result = result * prime + ($stages == null ? 43 : $stages.hashCode());
        Object $startTimestamp = this.getStartTimestamp();
        result = result * prime + ($startTimestamp == null ? 43 : $startTimestamp.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "BuildStatus(" + "cancelled=" + this.getCancelled() + ", completionTimestamp=" + this.getCompletionTimestamp() + ", conditions=" + this.getConditions() + ", config=" + this.getConfig() + ", duration=" + this.getDuration() + ", logSnippet=" + this.getLogSnippet() + ", message=" + this.getMessage() + ", output=" + this.getOutput() + ", outputDockerImageReference=" + this.getOutputDockerImageReference() + ", phase=" + this.getPhase() + ", reason=" + this.getReason() + ", stages=" + this.getStages() + ", startTimestamp=" + this.getStartTimestamp() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
