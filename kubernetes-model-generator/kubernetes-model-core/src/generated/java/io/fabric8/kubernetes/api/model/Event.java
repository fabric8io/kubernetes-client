
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
import io.fabric8.kubernetes.model.annotation.Group;
import io.fabric8.kubernetes.model.annotation.Version;
import io.sundr.builder.annotations.Buildable;

/**
 * Event is a report of an event somewhere in the cluster.  Events have a limited retention time and triggers and messages may evolve with time.  Event consumers should not rely on the timing of an event with a given Reason reflecting a consistent underlying trigger, or the continued existence of events with that Reason.  Events should be treated as informative, best-effort, supplemental data.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "apiVersion",
    "kind",
    "metadata",
    "action",
    "count",
    "eventTime",
    "firstTimestamp",
    "involvedObject",
    "lastTimestamp",
    "message",
    "reason",
    "related",
    "reportingComponent",
    "reportingInstance",
    "series",
    "source",
    "type"
})
@Buildable(editableEnabled = false, validationEnabled = false, generateBuilderPackage = false, lazyCollectionInitEnabled = false, builderPackage = "io.fabric8.kubernetes.api.builder")
@Version("v1")
@Group("")
@Generated("io.fabric8.kubernetes.schema.generator.model.ModelGenerator")
public class Event implements Editable<EventBuilder>, HasMetadata, Namespaced
{

    @JsonProperty("action")
    private String action;
    @JsonProperty("apiVersion")
    private String apiVersion = "v1";
    @JsonProperty("count")
    private Integer count;
    @JsonProperty("eventTime")
    private MicroTime eventTime;
    @JsonProperty("firstTimestamp")
    private String firstTimestamp;
    @JsonProperty("involvedObject")
    private ObjectReference involvedObject;
    @JsonProperty("kind")
    private String kind = "Event";
    @JsonProperty("lastTimestamp")
    private String lastTimestamp;
    @JsonProperty("message")
    private String message;
    @JsonProperty("metadata")
    private ObjectMeta metadata;
    @JsonProperty("reason")
    private String reason;
    @JsonProperty("related")
    private ObjectReference related;
    @JsonProperty("reportingComponent")
    private String reportingComponent;
    @JsonProperty("reportingInstance")
    private String reportingInstance;
    @JsonProperty("series")
    private EventSeries series;
    @JsonProperty("source")
    private EventSource source;
    @JsonProperty("type")
    private String type;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public Event() {
    }

    public Event(String action, String apiVersion, Integer count, MicroTime eventTime, String firstTimestamp, ObjectReference involvedObject, String kind, String lastTimestamp, String message, ObjectMeta metadata, String reason, ObjectReference related, String reportingComponent, String reportingInstance, EventSeries series, EventSource source, String type) {
        super();
        this.action = action;
        this.apiVersion = apiVersion;
        this.count = count;
        this.eventTime = eventTime;
        this.firstTimestamp = firstTimestamp;
        this.involvedObject = involvedObject;
        this.kind = kind;
        this.lastTimestamp = lastTimestamp;
        this.message = message;
        this.metadata = metadata;
        this.reason = reason;
        this.related = related;
        this.reportingComponent = reportingComponent;
        this.reportingInstance = reportingInstance;
        this.series = series;
        this.source = source;
        this.type = type;
    }

    /**
     * What action was taken/failed regarding to the Regarding object.
     */
    @JsonProperty("action")
    public String getAction() {
        return action;
    }

    /**
     * What action was taken/failed regarding to the Regarding object.
     */
    @JsonProperty("action")
    public void setAction(String action) {
        this.action = action;
    }

    /**
     * APIVersion defines the versioned schema of this representation of an object. Servers should convert recognized schemas to the latest internal value, and may reject unrecognized values. More info: https://git.k8s.io/community/contributors/devel/sig-architecture/api-conventions.md#resources
     */
    @JsonProperty("apiVersion")
    public String getApiVersion() {
        return apiVersion;
    }

    /**
     * APIVersion defines the versioned schema of this representation of an object. Servers should convert recognized schemas to the latest internal value, and may reject unrecognized values. More info: https://git.k8s.io/community/contributors/devel/sig-architecture/api-conventions.md#resources
     */
    @JsonProperty("apiVersion")
    public void setApiVersion(String apiVersion) {
        this.apiVersion = apiVersion;
    }

    /**
     * The number of times this event has occurred.
     */
    @JsonProperty("count")
    public Integer getCount() {
        return count;
    }

    /**
     * The number of times this event has occurred.
     */
    @JsonProperty("count")
    public void setCount(Integer count) {
        this.count = count;
    }

    /**
     * Event is a report of an event somewhere in the cluster.  Events have a limited retention time and triggers and messages may evolve with time.  Event consumers should not rely on the timing of an event with a given Reason reflecting a consistent underlying trigger, or the continued existence of events with that Reason.  Events should be treated as informative, best-effort, supplemental data.
     */
    @JsonProperty("eventTime")
    public MicroTime getEventTime() {
        return eventTime;
    }

    /**
     * Event is a report of an event somewhere in the cluster.  Events have a limited retention time and triggers and messages may evolve with time.  Event consumers should not rely on the timing of an event with a given Reason reflecting a consistent underlying trigger, or the continued existence of events with that Reason.  Events should be treated as informative, best-effort, supplemental data.
     */
    @JsonProperty("eventTime")
    public void setEventTime(MicroTime eventTime) {
        this.eventTime = eventTime;
    }

    /**
     * Event is a report of an event somewhere in the cluster.  Events have a limited retention time and triggers and messages may evolve with time.  Event consumers should not rely on the timing of an event with a given Reason reflecting a consistent underlying trigger, or the continued existence of events with that Reason.  Events should be treated as informative, best-effort, supplemental data.
     */
    @JsonProperty("firstTimestamp")
    public String getFirstTimestamp() {
        return firstTimestamp;
    }

    /**
     * Event is a report of an event somewhere in the cluster.  Events have a limited retention time and triggers and messages may evolve with time.  Event consumers should not rely on the timing of an event with a given Reason reflecting a consistent underlying trigger, or the continued existence of events with that Reason.  Events should be treated as informative, best-effort, supplemental data.
     */
    @JsonProperty("firstTimestamp")
    public void setFirstTimestamp(String firstTimestamp) {
        this.firstTimestamp = firstTimestamp;
    }

    /**
     * Event is a report of an event somewhere in the cluster.  Events have a limited retention time and triggers and messages may evolve with time.  Event consumers should not rely on the timing of an event with a given Reason reflecting a consistent underlying trigger, or the continued existence of events with that Reason.  Events should be treated as informative, best-effort, supplemental data.
     */
    @JsonProperty("involvedObject")
    public ObjectReference getInvolvedObject() {
        return involvedObject;
    }

    /**
     * Event is a report of an event somewhere in the cluster.  Events have a limited retention time and triggers and messages may evolve with time.  Event consumers should not rely on the timing of an event with a given Reason reflecting a consistent underlying trigger, or the continued existence of events with that Reason.  Events should be treated as informative, best-effort, supplemental data.
     */
    @JsonProperty("involvedObject")
    public void setInvolvedObject(ObjectReference involvedObject) {
        this.involvedObject = involvedObject;
    }

    /**
     * Kind is a string value representing the REST resource this object represents. Servers may infer this from the endpoint the client submits requests to. Cannot be updated. In CamelCase. More info: https://git.k8s.io/community/contributors/devel/sig-architecture/api-conventions.md#types-kinds
     */
    @JsonProperty("kind")
    public String getKind() {
        return kind;
    }

    /**
     * Kind is a string value representing the REST resource this object represents. Servers may infer this from the endpoint the client submits requests to. Cannot be updated. In CamelCase. More info: https://git.k8s.io/community/contributors/devel/sig-architecture/api-conventions.md#types-kinds
     */
    @JsonProperty("kind")
    public void setKind(String kind) {
        this.kind = kind;
    }

    /**
     * Event is a report of an event somewhere in the cluster.  Events have a limited retention time and triggers and messages may evolve with time.  Event consumers should not rely on the timing of an event with a given Reason reflecting a consistent underlying trigger, or the continued existence of events with that Reason.  Events should be treated as informative, best-effort, supplemental data.
     */
    @JsonProperty("lastTimestamp")
    public String getLastTimestamp() {
        return lastTimestamp;
    }

    /**
     * Event is a report of an event somewhere in the cluster.  Events have a limited retention time and triggers and messages may evolve with time.  Event consumers should not rely on the timing of an event with a given Reason reflecting a consistent underlying trigger, or the continued existence of events with that Reason.  Events should be treated as informative, best-effort, supplemental data.
     */
    @JsonProperty("lastTimestamp")
    public void setLastTimestamp(String lastTimestamp) {
        this.lastTimestamp = lastTimestamp;
    }

    /**
     * A human-readable description of the status of this operation.
     */
    @JsonProperty("message")
    public String getMessage() {
        return message;
    }

    /**
     * A human-readable description of the status of this operation.
     */
    @JsonProperty("message")
    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * Event is a report of an event somewhere in the cluster.  Events have a limited retention time and triggers and messages may evolve with time.  Event consumers should not rely on the timing of an event with a given Reason reflecting a consistent underlying trigger, or the continued existence of events with that Reason.  Events should be treated as informative, best-effort, supplemental data.
     */
    @JsonProperty("metadata")
    public ObjectMeta getMetadata() {
        return metadata;
    }

    /**
     * Event is a report of an event somewhere in the cluster.  Events have a limited retention time and triggers and messages may evolve with time.  Event consumers should not rely on the timing of an event with a given Reason reflecting a consistent underlying trigger, or the continued existence of events with that Reason.  Events should be treated as informative, best-effort, supplemental data.
     */
    @JsonProperty("metadata")
    public void setMetadata(ObjectMeta metadata) {
        this.metadata = metadata;
    }

    /**
     * This should be a short, machine understandable string that gives the reason for the transition into the object's current status.
     */
    @JsonProperty("reason")
    public String getReason() {
        return reason;
    }

    /**
     * This should be a short, machine understandable string that gives the reason for the transition into the object's current status.
     */
    @JsonProperty("reason")
    public void setReason(String reason) {
        this.reason = reason;
    }

    /**
     * Event is a report of an event somewhere in the cluster.  Events have a limited retention time and triggers and messages may evolve with time.  Event consumers should not rely on the timing of an event with a given Reason reflecting a consistent underlying trigger, or the continued existence of events with that Reason.  Events should be treated as informative, best-effort, supplemental data.
     */
    @JsonProperty("related")
    public ObjectReference getRelated() {
        return related;
    }

    /**
     * Event is a report of an event somewhere in the cluster.  Events have a limited retention time and triggers and messages may evolve with time.  Event consumers should not rely on the timing of an event with a given Reason reflecting a consistent underlying trigger, or the continued existence of events with that Reason.  Events should be treated as informative, best-effort, supplemental data.
     */
    @JsonProperty("related")
    public void setRelated(ObjectReference related) {
        this.related = related;
    }

    /**
     * Name of the controller that emitted this Event, e.g. `kubernetes.io/kubelet`.
     */
    @JsonProperty("reportingComponent")
    public String getReportingComponent() {
        return reportingComponent;
    }

    /**
     * Name of the controller that emitted this Event, e.g. `kubernetes.io/kubelet`.
     */
    @JsonProperty("reportingComponent")
    public void setReportingComponent(String reportingComponent) {
        this.reportingComponent = reportingComponent;
    }

    /**
     * ID of the controller instance, e.g. `kubelet-xyzf`.
     */
    @JsonProperty("reportingInstance")
    public String getReportingInstance() {
        return reportingInstance;
    }

    /**
     * ID of the controller instance, e.g. `kubelet-xyzf`.
     */
    @JsonProperty("reportingInstance")
    public void setReportingInstance(String reportingInstance) {
        this.reportingInstance = reportingInstance;
    }

    /**
     * Event is a report of an event somewhere in the cluster.  Events have a limited retention time and triggers and messages may evolve with time.  Event consumers should not rely on the timing of an event with a given Reason reflecting a consistent underlying trigger, or the continued existence of events with that Reason.  Events should be treated as informative, best-effort, supplemental data.
     */
    @JsonProperty("series")
    public EventSeries getSeries() {
        return series;
    }

    /**
     * Event is a report of an event somewhere in the cluster.  Events have a limited retention time and triggers and messages may evolve with time.  Event consumers should not rely on the timing of an event with a given Reason reflecting a consistent underlying trigger, or the continued existence of events with that Reason.  Events should be treated as informative, best-effort, supplemental data.
     */
    @JsonProperty("series")
    public void setSeries(EventSeries series) {
        this.series = series;
    }

    /**
     * Event is a report of an event somewhere in the cluster.  Events have a limited retention time and triggers and messages may evolve with time.  Event consumers should not rely on the timing of an event with a given Reason reflecting a consistent underlying trigger, or the continued existence of events with that Reason.  Events should be treated as informative, best-effort, supplemental data.
     */
    @JsonProperty("source")
    public EventSource getSource() {
        return source;
    }

    /**
     * Event is a report of an event somewhere in the cluster.  Events have a limited retention time and triggers and messages may evolve with time.  Event consumers should not rely on the timing of an event with a given Reason reflecting a consistent underlying trigger, or the continued existence of events with that Reason.  Events should be treated as informative, best-effort, supplemental data.
     */
    @JsonProperty("source")
    public void setSource(EventSource source) {
        this.source = source;
    }

    /**
     * Type of this event (Normal, Warning), new types could be added in the future
     */
    @JsonProperty("type")
    public String getType() {
        return type;
    }

    /**
     * Type of this event (Normal, Warning), new types could be added in the future
     */
    @JsonProperty("type")
    public void setType(String type) {
        this.type = type;
    }

    @JsonIgnore
    public EventBuilder edit() {
        return new EventBuilder(this);
    }

    @JsonIgnore
    public EventBuilder toBuilder() {
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
        if (!(o instanceof Event)) {
            return false;
        }
        Event other = (Event) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$action = this.getAction();
        Object other$action = other.getAction();
        if (this$action == null ? other$action != null : !this$action.equals(other$action)) {
            return false;
        }
        Object this$apiVersion = this.getApiVersion();
        Object other$apiVersion = other.getApiVersion();
        if (this$apiVersion == null ? other$apiVersion != null : !this$apiVersion.equals(other$apiVersion)) {
            return false;
        }
        Object this$count = this.getCount();
        Object other$count = other.getCount();
        if (this$count == null ? other$count != null : !this$count.equals(other$count)) {
            return false;
        }
        Object this$eventTime = this.getEventTime();
        Object other$eventTime = other.getEventTime();
        if (this$eventTime == null ? other$eventTime != null : !this$eventTime.equals(other$eventTime)) {
            return false;
        }
        Object this$firstTimestamp = this.getFirstTimestamp();
        Object other$firstTimestamp = other.getFirstTimestamp();
        if (this$firstTimestamp == null ? other$firstTimestamp != null : !this$firstTimestamp.equals(other$firstTimestamp)) {
            return false;
        }
        Object this$involvedObject = this.getInvolvedObject();
        Object other$involvedObject = other.getInvolvedObject();
        if (this$involvedObject == null ? other$involvedObject != null : !this$involvedObject.equals(other$involvedObject)) {
            return false;
        }
        Object this$kind = this.getKind();
        Object other$kind = other.getKind();
        if (this$kind == null ? other$kind != null : !this$kind.equals(other$kind)) {
            return false;
        }
        Object this$lastTimestamp = this.getLastTimestamp();
        Object other$lastTimestamp = other.getLastTimestamp();
        if (this$lastTimestamp == null ? other$lastTimestamp != null : !this$lastTimestamp.equals(other$lastTimestamp)) {
            return false;
        }
        Object this$message = this.getMessage();
        Object other$message = other.getMessage();
        if (this$message == null ? other$message != null : !this$message.equals(other$message)) {
            return false;
        }
        Object this$metadata = this.getMetadata();
        Object other$metadata = other.getMetadata();
        if (this$metadata == null ? other$metadata != null : !this$metadata.equals(other$metadata)) {
            return false;
        }
        Object this$reason = this.getReason();
        Object other$reason = other.getReason();
        if (this$reason == null ? other$reason != null : !this$reason.equals(other$reason)) {
            return false;
        }
        Object this$related = this.getRelated();
        Object other$related = other.getRelated();
        if (this$related == null ? other$related != null : !this$related.equals(other$related)) {
            return false;
        }
        Object this$reportingComponent = this.getReportingComponent();
        Object other$reportingComponent = other.getReportingComponent();
        if (this$reportingComponent == null ? other$reportingComponent != null : !this$reportingComponent.equals(other$reportingComponent)) {
            return false;
        }
        Object this$reportingInstance = this.getReportingInstance();
        Object other$reportingInstance = other.getReportingInstance();
        if (this$reportingInstance == null ? other$reportingInstance != null : !this$reportingInstance.equals(other$reportingInstance)) {
            return false;
        }
        Object this$series = this.getSeries();
        Object other$series = other.getSeries();
        if (this$series == null ? other$series != null : !this$series.equals(other$series)) {
            return false;
        }
        Object this$source = this.getSource();
        Object other$source = other.getSource();
        if (this$source == null ? other$source != null : !this$source.equals(other$source)) {
            return false;
        }
        Object this$type = this.getType();
        Object other$type = other.getType();
        if (this$type == null ? other$type != null : !this$type.equals(other$type)) {
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
        return other instanceof Event;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $action = this.getAction();
        result = result * prime + ($action == null ? 43 : $action.hashCode());
        Object $apiVersion = this.getApiVersion();
        result = result * prime + ($apiVersion == null ? 43 : $apiVersion.hashCode());
        Object $count = this.getCount();
        result = result * prime + ($count == null ? 43 : $count.hashCode());
        Object $eventTime = this.getEventTime();
        result = result * prime + ($eventTime == null ? 43 : $eventTime.hashCode());
        Object $firstTimestamp = this.getFirstTimestamp();
        result = result * prime + ($firstTimestamp == null ? 43 : $firstTimestamp.hashCode());
        Object $involvedObject = this.getInvolvedObject();
        result = result * prime + ($involvedObject == null ? 43 : $involvedObject.hashCode());
        Object $kind = this.getKind();
        result = result * prime + ($kind == null ? 43 : $kind.hashCode());
        Object $lastTimestamp = this.getLastTimestamp();
        result = result * prime + ($lastTimestamp == null ? 43 : $lastTimestamp.hashCode());
        Object $message = this.getMessage();
        result = result * prime + ($message == null ? 43 : $message.hashCode());
        Object $metadata = this.getMetadata();
        result = result * prime + ($metadata == null ? 43 : $metadata.hashCode());
        Object $reason = this.getReason();
        result = result * prime + ($reason == null ? 43 : $reason.hashCode());
        Object $related = this.getRelated();
        result = result * prime + ($related == null ? 43 : $related.hashCode());
        Object $reportingComponent = this.getReportingComponent();
        result = result * prime + ($reportingComponent == null ? 43 : $reportingComponent.hashCode());
        Object $reportingInstance = this.getReportingInstance();
        result = result * prime + ($reportingInstance == null ? 43 : $reportingInstance.hashCode());
        Object $series = this.getSeries();
        result = result * prime + ($series == null ? 43 : $series.hashCode());
        Object $source = this.getSource();
        result = result * prime + ($source == null ? 43 : $source.hashCode());
        Object $type = this.getType();
        result = result * prime + ($type == null ? 43 : $type.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "Event(" + "action=" + this.getAction() + ", apiVersion=" + this.getApiVersion() + ", count=" + this.getCount() + ", eventTime=" + this.getEventTime() + ", firstTimestamp=" + this.getFirstTimestamp() + ", involvedObject=" + this.getInvolvedObject() + ", kind=" + this.getKind() + ", lastTimestamp=" + this.getLastTimestamp() + ", message=" + this.getMessage() + ", metadata=" + this.getMetadata() + ", reason=" + this.getReason() + ", related=" + this.getRelated() + ", reportingComponent=" + this.getReportingComponent() + ", reportingInstance=" + this.getReportingInstance() + ", series=" + this.getSeries() + ", source=" + this.getSource() + ", type=" + this.getType() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
