
package io.fabric8.kubernetes.api.model;

import java.util.LinkedHashMap;
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
import io.sundr.builder.annotations.Buildable;

/**
 * Lifecycle describes actions that the management system should take in response to container lifecycle events. For the PostStart and PreStop lifecycle handlers, management of the container blocks until the action is complete, unless the container process fails, in which case the handler is aborted.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "postStart",
    "preStop",
    "stopSignal"
})
@Buildable(editableEnabled = false, validationEnabled = false, generateBuilderPackage = false, lazyCollectionInitEnabled = false, builderPackage = "io.fabric8.kubernetes.api.builder")
@Generated("io.fabric8.kubernetes.schema.generator.model.ModelGenerator")
public class Lifecycle implements Editable<LifecycleBuilder>, KubernetesResource
{

    @JsonProperty("postStart")
    private LifecycleHandler postStart;
    @JsonProperty("preStop")
    private LifecycleHandler preStop;
    @JsonProperty("stopSignal")
    private String stopSignal;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public Lifecycle() {
    }

    public Lifecycle(LifecycleHandler postStart, LifecycleHandler preStop, String stopSignal) {
        super();
        this.postStart = postStart;
        this.preStop = preStop;
        this.stopSignal = stopSignal;
    }

    /**
     * Lifecycle describes actions that the management system should take in response to container lifecycle events. For the PostStart and PreStop lifecycle handlers, management of the container blocks until the action is complete, unless the container process fails, in which case the handler is aborted.
     */
    @JsonProperty("postStart")
    public LifecycleHandler getPostStart() {
        return postStart;
    }

    /**
     * Lifecycle describes actions that the management system should take in response to container lifecycle events. For the PostStart and PreStop lifecycle handlers, management of the container blocks until the action is complete, unless the container process fails, in which case the handler is aborted.
     */
    @JsonProperty("postStart")
    public void setPostStart(LifecycleHandler postStart) {
        this.postStart = postStart;
    }

    /**
     * Lifecycle describes actions that the management system should take in response to container lifecycle events. For the PostStart and PreStop lifecycle handlers, management of the container blocks until the action is complete, unless the container process fails, in which case the handler is aborted.
     */
    @JsonProperty("preStop")
    public LifecycleHandler getPreStop() {
        return preStop;
    }

    /**
     * Lifecycle describes actions that the management system should take in response to container lifecycle events. For the PostStart and PreStop lifecycle handlers, management of the container blocks until the action is complete, unless the container process fails, in which case the handler is aborted.
     */
    @JsonProperty("preStop")
    public void setPreStop(LifecycleHandler preStop) {
        this.preStop = preStop;
    }

    /**
     * StopSignal defines which signal will be sent to a container when it is being stopped. If not specified, the default is defined by the container runtime in use. StopSignal can only be set for Pods with a non-empty .spec.os.name
     */
    @JsonProperty("stopSignal")
    public String getStopSignal() {
        return stopSignal;
    }

    /**
     * StopSignal defines which signal will be sent to a container when it is being stopped. If not specified, the default is defined by the container runtime in use. StopSignal can only be set for Pods with a non-empty .spec.os.name
     */
    @JsonProperty("stopSignal")
    public void setStopSignal(String stopSignal) {
        this.stopSignal = stopSignal;
    }

    @JsonIgnore
    public LifecycleBuilder edit() {
        return new LifecycleBuilder(this);
    }

    @JsonIgnore
    public LifecycleBuilder toBuilder() {
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
        if (!(o instanceof Lifecycle)) {
            return false;
        }
        Lifecycle other = (Lifecycle) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$postStart = this.getPostStart();
        Object other$postStart = other.getPostStart();
        if (this$postStart == null ? other$postStart != null : !this$postStart.equals(other$postStart)) {
            return false;
        }
        Object this$preStop = this.getPreStop();
        Object other$preStop = other.getPreStop();
        if (this$preStop == null ? other$preStop != null : !this$preStop.equals(other$preStop)) {
            return false;
        }
        Object this$stopSignal = this.getStopSignal();
        Object other$stopSignal = other.getStopSignal();
        if (this$stopSignal == null ? other$stopSignal != null : !this$stopSignal.equals(other$stopSignal)) {
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
        return other instanceof Lifecycle;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $postStart = this.getPostStart();
        result = result * prime + ($postStart == null ? 43 : $postStart.hashCode());
        Object $preStop = this.getPreStop();
        result = result * prime + ($preStop == null ? 43 : $preStop.hashCode());
        Object $stopSignal = this.getStopSignal();
        result = result * prime + ($stopSignal == null ? 43 : $stopSignal.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "Lifecycle(" + "postStart=" + this.getPostStart() + ", preStop=" + this.getPreStop() + ", stopSignal=" + this.getStopSignal() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
