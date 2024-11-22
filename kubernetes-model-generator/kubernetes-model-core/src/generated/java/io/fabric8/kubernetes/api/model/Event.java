
package io.fabric8.kubernetes.api.model;

import java.util.LinkedHashMap;
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
import io.fabric8.kubernetes.model.annotation.Group;
import io.fabric8.kubernetes.model.annotation.Version;
import io.sundr.builder.annotations.Buildable;
import io.sundr.transform.annotations.TemplateTransformation;
import io.sundr.transform.annotations.TemplateTransformations;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

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
@ToString
@EqualsAndHashCode
@Accessors(prefix = {
    "_",
    ""
})
@Buildable(editableEnabled = false, validationEnabled = false, generateBuilderPackage = false, lazyCollectionInitEnabled = false, builderPackage = "io.fabric8.kubernetes.api.builder")
@TemplateTransformations({
    @TemplateTransformation(value = "/manifest.vm", outputPath = "META-INF/services/io.fabric8.kubernetes.api.model.KubernetesResource", gather = true)
})
@Version("v1")
@Group("")
@Generated("io.fabric8.kubernetes.schema.generator.model.ModelGenerator")
public class Event implements Editable<EventBuilder> , HasMetadata, Namespaced
{

    @JsonProperty("action")
    private String action;
    /**
     * 
     * (Required)
     * 
     */
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
    /**
     * 
     * (Required)
     * 
     */
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
     * 
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

    @JsonProperty("action")
    public String getAction() {
        return action;
    }

    @JsonProperty("action")
    public void setAction(String action) {
        this.action = action;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("apiVersion")
    public String getApiVersion() {
        return apiVersion;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("apiVersion")
    public void setApiVersion(String apiVersion) {
        this.apiVersion = apiVersion;
    }

    @JsonProperty("count")
    public Integer getCount() {
        return count;
    }

    @JsonProperty("count")
    public void setCount(Integer count) {
        this.count = count;
    }

    @JsonProperty("eventTime")
    public MicroTime getEventTime() {
        return eventTime;
    }

    @JsonProperty("eventTime")
    public void setEventTime(MicroTime eventTime) {
        this.eventTime = eventTime;
    }

    @JsonProperty("firstTimestamp")
    public String getFirstTimestamp() {
        return firstTimestamp;
    }

    @JsonProperty("firstTimestamp")
    public void setFirstTimestamp(String firstTimestamp) {
        this.firstTimestamp = firstTimestamp;
    }

    @JsonProperty("involvedObject")
    public ObjectReference getInvolvedObject() {
        return involvedObject;
    }

    @JsonProperty("involvedObject")
    public void setInvolvedObject(ObjectReference involvedObject) {
        this.involvedObject = involvedObject;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("kind")
    public String getKind() {
        return kind;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("kind")
    public void setKind(String kind) {
        this.kind = kind;
    }

    @JsonProperty("lastTimestamp")
    public String getLastTimestamp() {
        return lastTimestamp;
    }

    @JsonProperty("lastTimestamp")
    public void setLastTimestamp(String lastTimestamp) {
        this.lastTimestamp = lastTimestamp;
    }

    @JsonProperty("message")
    public String getMessage() {
        return message;
    }

    @JsonProperty("message")
    public void setMessage(String message) {
        this.message = message;
    }

    @JsonProperty("metadata")
    public ObjectMeta getMetadata() {
        return metadata;
    }

    @JsonProperty("metadata")
    public void setMetadata(ObjectMeta metadata) {
        this.metadata = metadata;
    }

    @JsonProperty("reason")
    public String getReason() {
        return reason;
    }

    @JsonProperty("reason")
    public void setReason(String reason) {
        this.reason = reason;
    }

    @JsonProperty("related")
    public ObjectReference getRelated() {
        return related;
    }

    @JsonProperty("related")
    public void setRelated(ObjectReference related) {
        this.related = related;
    }

    @JsonProperty("reportingComponent")
    public String getReportingComponent() {
        return reportingComponent;
    }

    @JsonProperty("reportingComponent")
    public void setReportingComponent(String reportingComponent) {
        this.reportingComponent = reportingComponent;
    }

    @JsonProperty("reportingInstance")
    public String getReportingInstance() {
        return reportingInstance;
    }

    @JsonProperty("reportingInstance")
    public void setReportingInstance(String reportingInstance) {
        this.reportingInstance = reportingInstance;
    }

    @JsonProperty("series")
    public EventSeries getSeries() {
        return series;
    }

    @JsonProperty("series")
    public void setSeries(EventSeries series) {
        this.series = series;
    }

    @JsonProperty("source")
    public EventSource getSource() {
        return source;
    }

    @JsonProperty("source")
    public void setSource(EventSource source) {
        this.source = source;
    }

    @JsonProperty("type")
    public String getType() {
        return type;
    }

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
