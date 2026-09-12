
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
    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof LifecyclePolicy)) {
            return false;
        }
        LifecyclePolicy other = (LifecyclePolicy) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$action = this.getAction();
        Object other$action = other.getAction();
        if (this$action == null ? other$action != null : !this$action.equals(other$action)) {
            return false;
        }
        Object this$event = this.getEvent();
        Object other$event = other.getEvent();
        if (this$event == null ? other$event != null : !this$event.equals(other$event)) {
            return false;
        }
        Object this$events = this.getEvents();
        Object other$events = other.getEvents();
        if (this$events == null ? other$events != null : !this$events.equals(other$events)) {
            return false;
        }
        Object this$exitCode = this.getExitCode();
        Object other$exitCode = other.getExitCode();
        if (this$exitCode == null ? other$exitCode != null : !this$exitCode.equals(other$exitCode)) {
            return false;
        }
        Object this$timeout = this.getTimeout();
        Object other$timeout = other.getTimeout();
        if (this$timeout == null ? other$timeout != null : !this$timeout.equals(other$timeout)) {
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
        return other instanceof LifecyclePolicy;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $action = this.getAction();
        result = result * prime + ($action == null ? 43 : $action.hashCode());
        Object $event = this.getEvent();
        result = result * prime + ($event == null ? 43 : $event.hashCode());
        Object $events = this.getEvents();
        result = result * prime + ($events == null ? 43 : $events.hashCode());
        Object $exitCode = this.getExitCode();
        result = result * prime + ($exitCode == null ? 43 : $exitCode.hashCode());
        Object $timeout = this.getTimeout();
        result = result * prime + ($timeout == null ? 43 : $timeout.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "LifecyclePolicy(" + "action=" + this.getAction() + ", event=" + this.getEvent() + ", events=" + this.getEvents() + ", exitCode=" + this.getExitCode() + ", timeout=" + this.getTimeout() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
