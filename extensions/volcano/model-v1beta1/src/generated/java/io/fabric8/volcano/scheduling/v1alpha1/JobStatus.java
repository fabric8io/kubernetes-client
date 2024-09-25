package io.fabric8.volcano.scheduling.v1alpha1;

import io.fabric8.volcano.scheduling.v1alpha1.builder.JobStatusBuilder;
import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.fabric8.kubernetes.api.builder.Editable;
import io.fabric8.kubernetes.api.model.*;
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;
import lombok.EqualsAndHashCode;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

import javax.annotation.Generated;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @Author: mf
 * @Date: 2024/7/4  下午5:17
 * @FileName：JobStatus
 * @Description:
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "apiVersion",
        "kind",
        "metadata",
        "inqueue",
        "pending",
        "running",
        "state",
        "unknown"
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
@Generated("jsonschema2pojo")
public class JobStatus implements Editable<JobStatusBuilder>, KubernetesResource {

    @JsonProperty("inqueue")
    private Integer inqueue;
    @JsonProperty("pending")
    private Integer pending;
    @JsonProperty("running")
    private Integer running;
    @JsonProperty("state")
    private String state;
    @JsonProperty("unknown")
    private Integer unknown;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     *
     */
    public JobStatus() {
    }

    public JobStatus(Integer inqueue, Integer pending, Integer running, String state, Integer unknown) {
        super();
        this.inqueue = inqueue;
        this.pending = pending;
        this.running = running;
        this.state = state;
        this.unknown = unknown;
    }

    @JsonProperty("inqueue")
    public Integer getInqueue() {
        return inqueue;
    }

    @JsonProperty("inqueue")
    public void setInqueue(Integer inqueue) {
        this.inqueue = inqueue;
    }

    @JsonProperty("pending")
    public Integer getPending() {
        return pending;
    }

    @JsonProperty("pending")
    public void setPending(Integer pending) {
        this.pending = pending;
    }

    @JsonProperty("running")
    public Integer getRunning() {
        return running;
    }

    @JsonProperty("running")
    public void setRunning(Integer running) {
        this.running = running;
    }

    @JsonProperty("state")
    public String getState() {
        return state;
    }

    @JsonProperty("state")
    public void setState(String state) {
        this.state = state;
    }

    @JsonProperty("unknown")
    public Integer getUnknown() {
        return unknown;
    }

    @JsonProperty("unknown")
    public void setUnknown(Integer unknown) {
        this.unknown = unknown;
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

}
