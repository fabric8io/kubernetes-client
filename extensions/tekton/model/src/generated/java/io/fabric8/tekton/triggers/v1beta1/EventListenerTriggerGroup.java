
package io.fabric8.tekton.triggers.v1beta1;

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

/**
 * EventListenerTriggerGroup defines a group of Triggers that share a common set of interceptors
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "interceptors",
    "name",
    "triggerSelector"
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
public class EventListenerTriggerGroup implements Editable<EventListenerTriggerGroupBuilder>, KubernetesResource
{

    @JsonProperty("interceptors")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<TriggerInterceptor> interceptors = new ArrayList<>();
    @JsonProperty("name")
    private String name;
    @JsonProperty("triggerSelector")
    private EventListenerTriggerSelector triggerSelector;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public EventListenerTriggerGroup() {
    }

    public EventListenerTriggerGroup(List<TriggerInterceptor> interceptors, String name, EventListenerTriggerSelector triggerSelector) {
        super();
        this.interceptors = interceptors;
        this.name = name;
        this.triggerSelector = triggerSelector;
    }

    /**
     * EventListenerTriggerGroup defines a group of Triggers that share a common set of interceptors
     */
    @JsonProperty("interceptors")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<TriggerInterceptor> getInterceptors() {
        return interceptors;
    }

    /**
     * EventListenerTriggerGroup defines a group of Triggers that share a common set of interceptors
     */
    @JsonProperty("interceptors")
    public void setInterceptors(List<TriggerInterceptor> interceptors) {
        this.interceptors = interceptors;
    }

    /**
     * EventListenerTriggerGroup defines a group of Triggers that share a common set of interceptors
     */
    @JsonProperty("name")
    public String getName() {
        return name;
    }

    /**
     * EventListenerTriggerGroup defines a group of Triggers that share a common set of interceptors
     */
    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    /**
     * EventListenerTriggerGroup defines a group of Triggers that share a common set of interceptors
     */
    @JsonProperty("triggerSelector")
    public EventListenerTriggerSelector getTriggerSelector() {
        return triggerSelector;
    }

    /**
     * EventListenerTriggerGroup defines a group of Triggers that share a common set of interceptors
     */
    @JsonProperty("triggerSelector")
    public void setTriggerSelector(EventListenerTriggerSelector triggerSelector) {
        this.triggerSelector = triggerSelector;
    }

    @JsonIgnore
    public EventListenerTriggerGroupBuilder edit() {
        return new EventListenerTriggerGroupBuilder(this);
    }

    @JsonIgnore
    public EventListenerTriggerGroupBuilder toBuilder() {
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
        if (!(o instanceof EventListenerTriggerGroup)) {
            return false;
        }
        EventListenerTriggerGroup other = (EventListenerTriggerGroup) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$interceptors = this.getInterceptors();
        Object other$interceptors = other.getInterceptors();
        if (this$interceptors == null ? other$interceptors != null : !this$interceptors.equals(other$interceptors)) {
            return false;
        }
        Object this$name = this.getName();
        Object other$name = other.getName();
        if (this$name == null ? other$name != null : !this$name.equals(other$name)) {
            return false;
        }
        Object this$triggerSelector = this.getTriggerSelector();
        Object other$triggerSelector = other.getTriggerSelector();
        if (this$triggerSelector == null ? other$triggerSelector != null : !this$triggerSelector.equals(other$triggerSelector)) {
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
        return other instanceof EventListenerTriggerGroup;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $interceptors = this.getInterceptors();
        result = result * prime + ($interceptors == null ? 43 : $interceptors.hashCode());
        Object $name = this.getName();
        result = result * prime + ($name == null ? 43 : $name.hashCode());
        Object $triggerSelector = this.getTriggerSelector();
        result = result * prime + ($triggerSelector == null ? 43 : $triggerSelector.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "EventListenerTriggerGroup(" + "interceptors=" + this.getInterceptors() + ", name=" + this.getName() + ", triggerSelector=" + this.getTriggerSelector() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
