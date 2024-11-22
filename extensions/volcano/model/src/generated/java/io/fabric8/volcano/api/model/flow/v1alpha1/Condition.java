
package io.fabric8.volcano.api.model.flow.v1alpha1;

import java.util.LinkedHashMap;
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
import io.fabric8.kubernetes.api.model.Duration;
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
import io.fabric8.volcano.api.model.batch.v1alpha1.TaskState;
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "createTime",
    "phase",
    "runningDuration",
    "taskStatusCount"
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
public class Condition implements Editable<ConditionBuilder> , KubernetesResource
{

    @JsonProperty("createTime")
    private String createTime;
    @JsonProperty("phase")
    private String phase;
    @JsonProperty("runningDuration")
    private Duration runningDuration;
    @JsonProperty("taskStatusCount")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Map<String, TaskState> taskStatusCount = new LinkedHashMap<>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public Condition() {
    }

    public Condition(String createTime, String phase, Duration runningDuration, Map<String, TaskState> taskStatusCount) {
        super();
        this.createTime = createTime;
        this.phase = phase;
        this.runningDuration = runningDuration;
        this.taskStatusCount = taskStatusCount;
    }

    @JsonProperty("createTime")
    public String getCreateTime() {
        return createTime;
    }

    @JsonProperty("createTime")
    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    @JsonProperty("phase")
    public String getPhase() {
        return phase;
    }

    @JsonProperty("phase")
    public void setPhase(String phase) {
        this.phase = phase;
    }

    @JsonProperty("runningDuration")
    public Duration getRunningDuration() {
        return runningDuration;
    }

    @JsonProperty("runningDuration")
    public void setRunningDuration(Duration runningDuration) {
        this.runningDuration = runningDuration;
    }

    @JsonProperty("taskStatusCount")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public Map<String, TaskState> getTaskStatusCount() {
        return taskStatusCount;
    }

    @JsonProperty("taskStatusCount")
    public void setTaskStatusCount(Map<String, TaskState> taskStatusCount) {
        this.taskStatusCount = taskStatusCount;
    }

    @JsonIgnore
    public ConditionBuilder edit() {
        return new ConditionBuilder(this);
    }

    @JsonIgnore
    public ConditionBuilder toBuilder() {
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
