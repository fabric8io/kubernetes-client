
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
 * EventSeries contain information on series of events, i.e. thing that was/is happening continuously for some time.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "count",
    "lastObservedTime"
})
@Buildable(editableEnabled = false, validationEnabled = false, generateBuilderPackage = false, lazyCollectionInitEnabled = false, builderPackage = "io.fabric8.kubernetes.api.builder")
@Generated("io.fabric8.kubernetes.schema.generator.model.ModelGenerator")
public class EventSeries implements Editable<EventSeriesBuilder>, KubernetesResource
{

    @JsonProperty("count")
    private Integer count;
    @JsonProperty("lastObservedTime")
    private MicroTime lastObservedTime;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public EventSeries() {
    }

    public EventSeries(Integer count, MicroTime lastObservedTime) {
        super();
        this.count = count;
        this.lastObservedTime = lastObservedTime;
    }

    /**
     * Number of occurrences in this series up to the last heartbeat time
     */
    @JsonProperty("count")
    public Integer getCount() {
        return count;
    }

    /**
     * Number of occurrences in this series up to the last heartbeat time
     */
    @JsonProperty("count")
    public void setCount(Integer count) {
        this.count = count;
    }

    /**
     * EventSeries contain information on series of events, i.e. thing that was/is happening continuously for some time.
     */
    @JsonProperty("lastObservedTime")
    public MicroTime getLastObservedTime() {
        return lastObservedTime;
    }

    /**
     * EventSeries contain information on series of events, i.e. thing that was/is happening continuously for some time.
     */
    @JsonProperty("lastObservedTime")
    public void setLastObservedTime(MicroTime lastObservedTime) {
        this.lastObservedTime = lastObservedTime;
    }

    @JsonIgnore
    public EventSeriesBuilder edit() {
        return new EventSeriesBuilder(this);
    }

    @JsonIgnore
    public EventSeriesBuilder toBuilder() {
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
        if (!(o instanceof EventSeries)) {
            return false;
        }
        EventSeries other = (EventSeries) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$count = this.getCount();
        Object other$count = other.getCount();
        if (this$count == null ? other$count != null : !this$count.equals(other$count)) {
            return false;
        }
        Object this$lastObservedTime = this.getLastObservedTime();
        Object other$lastObservedTime = other.getLastObservedTime();
        if (this$lastObservedTime == null ? other$lastObservedTime != null : !this$lastObservedTime.equals(other$lastObservedTime)) {
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
        return other instanceof EventSeries;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $count = this.getCount();
        result = result * prime + ($count == null ? 43 : $count.hashCode());
        Object $lastObservedTime = this.getLastObservedTime();
        result = result * prime + ($lastObservedTime == null ? 43 : $lastObservedTime.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "EventSeries(" + "count=" + this.getCount() + ", lastObservedTime=" + this.getLastObservedTime() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
