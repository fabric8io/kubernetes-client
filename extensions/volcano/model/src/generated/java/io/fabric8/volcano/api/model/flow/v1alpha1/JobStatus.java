
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

@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "endTimestamp",
    "name",
    "restartCount",
    "runningHistories",
    "startTimestamp",
    "state"
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
public class JobStatus implements Editable<JobStatusBuilder>, KubernetesResource
{

    @JsonProperty("endTimestamp")
    private String endTimestamp;
    @JsonProperty("name")
    private String name;
    @JsonProperty("restartCount")
    private Integer restartCount;
    @JsonProperty("runningHistories")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<JobRunningHistory> runningHistories = new ArrayList<>();
    @JsonProperty("startTimestamp")
    private String startTimestamp;
    @JsonProperty("state")
    private String state;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public JobStatus() {
    }

    public JobStatus(String endTimestamp, String name, Integer restartCount, List<JobRunningHistory> runningHistories, String startTimestamp, String state) {
        super();
        this.endTimestamp = endTimestamp;
        this.name = name;
        this.restartCount = restartCount;
        this.runningHistories = runningHistories;
        this.startTimestamp = startTimestamp;
        this.state = state;
    }

    @JsonProperty("endTimestamp")
    public String getEndTimestamp() {
        return endTimestamp;
    }

    @JsonProperty("endTimestamp")
    public void setEndTimestamp(String endTimestamp) {
        this.endTimestamp = endTimestamp;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("restartCount")
    public Integer getRestartCount() {
        return restartCount;
    }

    @JsonProperty("restartCount")
    public void setRestartCount(Integer restartCount) {
        this.restartCount = restartCount;
    }

    @JsonProperty("runningHistories")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<JobRunningHistory> getRunningHistories() {
        return runningHistories;
    }

    @JsonProperty("runningHistories")
    public void setRunningHistories(List<JobRunningHistory> runningHistories) {
        this.runningHistories = runningHistories;
    }

    @JsonProperty("startTimestamp")
    public String getStartTimestamp() {
        return startTimestamp;
    }

    @JsonProperty("startTimestamp")
    public void setStartTimestamp(String startTimestamp) {
        this.startTimestamp = startTimestamp;
    }

    @JsonProperty("state")
    public String getState() {
        return state;
    }

    @JsonProperty("state")
    public void setState(String state) {
        this.state = state;
    }

    @JsonIgnore
    public JobStatusBuilder edit() {
        return new JobStatusBuilder(this);
    }

    @JsonIgnore
    public JobStatusBuilder toBuilder() {
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
        if (!(o instanceof JobStatus)) {
            return false;
        }
        JobStatus other = (JobStatus) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$endTimestamp = this.getEndTimestamp();
        Object other$endTimestamp = other.getEndTimestamp();
        if (this$endTimestamp == null ? other$endTimestamp != null : !this$endTimestamp.equals(other$endTimestamp)) {
            return false;
        }
        Object this$name = this.getName();
        Object other$name = other.getName();
        if (this$name == null ? other$name != null : !this$name.equals(other$name)) {
            return false;
        }
        Object this$restartCount = this.getRestartCount();
        Object other$restartCount = other.getRestartCount();
        if (this$restartCount == null ? other$restartCount != null : !this$restartCount.equals(other$restartCount)) {
            return false;
        }
        Object this$runningHistories = this.getRunningHistories();
        Object other$runningHistories = other.getRunningHistories();
        if (this$runningHistories == null ? other$runningHistories != null : !this$runningHistories.equals(other$runningHistories)) {
            return false;
        }
        Object this$startTimestamp = this.getStartTimestamp();
        Object other$startTimestamp = other.getStartTimestamp();
        if (this$startTimestamp == null ? other$startTimestamp != null : !this$startTimestamp.equals(other$startTimestamp)) {
            return false;
        }
        Object this$state = this.getState();
        Object other$state = other.getState();
        if (this$state == null ? other$state != null : !this$state.equals(other$state)) {
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
        return other instanceof JobStatus;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $endTimestamp = this.getEndTimestamp();
        result = result * prime + ($endTimestamp == null ? 43 : $endTimestamp.hashCode());
        Object $name = this.getName();
        result = result * prime + ($name == null ? 43 : $name.hashCode());
        Object $restartCount = this.getRestartCount();
        result = result * prime + ($restartCount == null ? 43 : $restartCount.hashCode());
        Object $runningHistories = this.getRunningHistories();
        result = result * prime + ($runningHistories == null ? 43 : $runningHistories.hashCode());
        Object $startTimestamp = this.getStartTimestamp();
        result = result * prime + ($startTimestamp == null ? 43 : $startTimestamp.hashCode());
        Object $state = this.getState();
        result = result * prime + ($state == null ? 43 : $state.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "JobStatus(" + "endTimestamp=" + this.getEndTimestamp() + ", name=" + this.getName() + ", restartCount=" + this.getRestartCount() + ", runningHistories=" + this.getRunningHistories() + ", startTimestamp=" + this.getStartTimestamp() + ", state=" + this.getState() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
