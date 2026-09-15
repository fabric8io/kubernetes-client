
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
 * EventSource contains information for an event.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "component",
    "host"
})
@Buildable(editableEnabled = false, validationEnabled = false, generateBuilderPackage = false, lazyCollectionInitEnabled = false, builderPackage = "io.fabric8.kubernetes.api.builder")
@Generated("io.fabric8.kubernetes.schema.generator.model.ModelGenerator")
public class EventSource implements Editable<EventSourceBuilder>, KubernetesResource
{

    @JsonProperty("component")
    private String component;
    @JsonProperty("host")
    private String host;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public EventSource() {
    }

    public EventSource(String component, String host) {
        super();
        this.component = component;
        this.host = host;
    }

    /**
     * Component from which the event is generated.
     */
    @JsonProperty("component")
    public String getComponent() {
        return component;
    }

    /**
     * Component from which the event is generated.
     */
    @JsonProperty("component")
    public void setComponent(String component) {
        this.component = component;
    }

    /**
     * Node name on which the event is generated.
     */
    @JsonProperty("host")
    public String getHost() {
        return host;
    }

    /**
     * Node name on which the event is generated.
     */
    @JsonProperty("host")
    public void setHost(String host) {
        this.host = host;
    }

    @JsonIgnore
    public EventSourceBuilder edit() {
        return new EventSourceBuilder(this);
    }

    @JsonIgnore
    public EventSourceBuilder toBuilder() {
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
        if (!(o instanceof EventSource)) {
            return false;
        }
        EventSource other = (EventSource) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$component = this.getComponent();
        Object other$component = other.getComponent();
        if (this$component == null ? other$component != null : !this$component.equals(other$component)) {
            return false;
        }
        Object this$host = this.getHost();
        Object other$host = other.getHost();
        if (this$host == null ? other$host != null : !this$host.equals(other$host)) {
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
        return other instanceof EventSource;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $component = this.getComponent();
        result = result * prime + ($component == null ? 43 : $component.hashCode());
        Object $host = this.getHost();
        result = result * prime + ($host == null ? 43 : $host.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "EventSource(" + "component=" + this.getComponent() + ", host=" + this.getHost() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
