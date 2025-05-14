
package io.fabric8.volcano.api.model.batch.v1alpha1;

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
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * LifecyclePolicy specifies the lifecycle and error handling of task and job.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "action",
    "event",
    "events",
    "exitCode",
    "timeout"
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
public class LifecyclePolicy implements Editable<LifecyclePolicyBuilder>, KubernetesResource
{

    @JsonProperty("action")
    private String action;
    @JsonProperty("event")
    private String event;
    @JsonProperty("events")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> events = new ArrayList<>();
    @JsonProperty("exitCode")
    private Integer exitCode;
    @JsonProperty("timeout")
    private Duration timeout;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public LifecyclePolicy() {
    }

    public LifecyclePolicy(String action, String event, List<String> events, Integer exitCode, Duration timeout) {
        super();
        this.action = action;
        this.event = event;
        this.events = events;
        this.exitCode = exitCode;
        this.timeout = timeout;
    }

    /**
     * The action that will be taken to the PodGroup according to Event. One of "Restart", "None". Default to None.
     */
    @JsonProperty("action")
    public String getAction() {
        return action;
    }

    /**
     * The action that will be taken to the PodGroup according to Event. One of "Restart", "None". Default to None.
     */
    @JsonProperty("action")
    public void setAction(String action) {
        this.action = action;
    }

    /**
     * The Event recorded by scheduler; the controller takes actions according to this Event.
     */
    @JsonProperty("event")
    public String getEvent() {
        return event;
    }

    /**
     * The Event recorded by scheduler; the controller takes actions according to this Event.
     */
    @JsonProperty("event")
    public void setEvent(String event) {
        this.event = event;
    }

    /**
     * The Events recorded by scheduler; the controller takes actions according to this Events.
     */
    @JsonProperty("events")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getEvents() {
        return events;
    }

    /**
     * The Events recorded by scheduler; the controller takes actions according to this Events.
     */
    @JsonProperty("events")
    public void setEvents(List<String> events) {
        this.events = events;
    }

    /**
     * The exit code of the pod container, controller will take action according to this code. Note: only one of `Event` or `ExitCode` can be specified.
     */
    @JsonProperty("exitCode")
    public Integer getExitCode() {
        return exitCode;
    }

    /**
     * The exit code of the pod container, controller will take action according to this code. Note: only one of `Event` or `ExitCode` can be specified.
     */
    @JsonProperty("exitCode")
    public void setExitCode(Integer exitCode) {
        this.exitCode = exitCode;
    }

    /**
     * LifecyclePolicy specifies the lifecycle and error handling of task and job.
     */
    @JsonProperty("timeout")
    public Duration getTimeout() {
        return timeout;
    }

    /**
     * LifecyclePolicy specifies the lifecycle and error handling of task and job.
     */
    @JsonProperty("timeout")
    public void setTimeout(Duration timeout) {
        this.timeout = timeout;
    }

    @JsonIgnore
    public LifecyclePolicyBuilder edit() {
        return new LifecyclePolicyBuilder(this);
    }

    @JsonIgnore
    public LifecyclePolicyBuilder toBuilder() {
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

}
