
package io.fabric8.volcano.api.model.flow.v1alpha1;

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
    "endTimestamp",
    "name",
    "restartCount",
    "runningHistories",
    "startTimestamp",
    "state"
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
public class JobStatus implements Editable<JobStatusBuilder> , KubernetesResource
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
     * 
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
