
package io.fabric8.kubernetes.api.model.events.v1beta1;

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
import io.fabric8.kubernetes.api.model.Container;
import io.fabric8.kubernetes.api.model.ContainerPort;
import io.fabric8.kubernetes.api.model.EnvVar;
import io.fabric8.kubernetes.api.model.EventSource;
import io.fabric8.kubernetes.api.model.HasMetadata;
import io.fabric8.kubernetes.api.model.IntOrString;
import io.fabric8.kubernetes.api.model.LabelSelector;
import io.fabric8.kubernetes.api.model.LocalObjectReference;
import io.fabric8.kubernetes.api.model.MicroTime;
import io.fabric8.kubernetes.api.model.Namespaced;
import io.fabric8.kubernetes.api.model.ObjectMeta;
import io.fabric8.kubernetes.api.model.ObjectReference;
import io.fabric8.kubernetes.api.model.PersistentVolumeClaim;
import io.fabric8.kubernetes.api.model.PodTemplateSpec;
import io.fabric8.kubernetes.api.model.ResourceRequirements;
import io.fabric8.kubernetes.api.model.Volume;
import io.fabric8.kubernetes.api.model.VolumeMount;
import io.fabric8.kubernetes.model.annotation.Group;
import io.fabric8.kubernetes.model.annotation.Version;
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;
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
    "deprecatedCount",
    "deprecatedFirstTimestamp",
    "deprecatedLastTimestamp",
    "deprecatedSource",
    "eventTime",
    "note",
    "reason",
    "regarding",
    "related",
    "reportingController",
    "reportingInstance",
    "series",
    "type"
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
@TemplateTransformations({
    @TemplateTransformation(value = "/manifest.vm", outputPath = "META-INF/services/io.fabric8.kubernetes.api.model.KubernetesResource", gather = true)
})
@Version("v1beta1")
@Group("events.k8s.io")
@Generated("jsonschema2pojo")
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
    private String apiVersion = "events.k8s.io/v1beta1";
    @JsonProperty("deprecatedCount")
    private Integer deprecatedCount;
    @JsonProperty("deprecatedFirstTimestamp")
    private String deprecatedFirstTimestamp;
    @JsonProperty("deprecatedLastTimestamp")
    private String deprecatedLastTimestamp;
    @JsonProperty("deprecatedSource")
    private EventSource deprecatedSource;
    @JsonProperty("eventTime")
    private MicroTime eventTime;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("kind")
    private String kind = "Event";
    @JsonProperty("metadata")
    private ObjectMeta metadata;
    @JsonProperty("note")
    private String note;
    @JsonProperty("reason")
    private String reason;
    @JsonProperty("regarding")
    private ObjectReference regarding;
    @JsonProperty("related")
    private ObjectReference related;
    @JsonProperty("reportingController")
    private String reportingController;
    @JsonProperty("reportingInstance")
    private String reportingInstance;
    @JsonProperty("series")
    private EventSeries series;
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

    public Event(String action, String apiVersion, Integer deprecatedCount, String deprecatedFirstTimestamp, String deprecatedLastTimestamp, EventSource deprecatedSource, MicroTime eventTime, String kind, ObjectMeta metadata, String note, String reason, ObjectReference regarding, ObjectReference related, String reportingController, String reportingInstance, EventSeries series, String type) {
        super();
        this.action = action;
        this.apiVersion = apiVersion;
        this.deprecatedCount = deprecatedCount;
        this.deprecatedFirstTimestamp = deprecatedFirstTimestamp;
        this.deprecatedLastTimestamp = deprecatedLastTimestamp;
        this.deprecatedSource = deprecatedSource;
        this.eventTime = eventTime;
        this.kind = kind;
        this.metadata = metadata;
        this.note = note;
        this.reason = reason;
        this.regarding = regarding;
        this.related = related;
        this.reportingController = reportingController;
        this.reportingInstance = reportingInstance;
        this.series = series;
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

    @JsonProperty("deprecatedCount")
    public Integer getDeprecatedCount() {
        return deprecatedCount;
    }

    @JsonProperty("deprecatedCount")
    public void setDeprecatedCount(Integer deprecatedCount) {
        this.deprecatedCount = deprecatedCount;
    }

    @JsonProperty("deprecatedFirstTimestamp")
    public String getDeprecatedFirstTimestamp() {
        return deprecatedFirstTimestamp;
    }

    @JsonProperty("deprecatedFirstTimestamp")
    public void setDeprecatedFirstTimestamp(String deprecatedFirstTimestamp) {
        this.deprecatedFirstTimestamp = deprecatedFirstTimestamp;
    }

    @JsonProperty("deprecatedLastTimestamp")
    public String getDeprecatedLastTimestamp() {
        return deprecatedLastTimestamp;
    }

    @JsonProperty("deprecatedLastTimestamp")
    public void setDeprecatedLastTimestamp(String deprecatedLastTimestamp) {
        this.deprecatedLastTimestamp = deprecatedLastTimestamp;
    }

    @JsonProperty("deprecatedSource")
    public EventSource getDeprecatedSource() {
        return deprecatedSource;
    }

    @JsonProperty("deprecatedSource")
    public void setDeprecatedSource(EventSource deprecatedSource) {
        this.deprecatedSource = deprecatedSource;
    }

    @JsonProperty("eventTime")
    public MicroTime getEventTime() {
        return eventTime;
    }

    @JsonProperty("eventTime")
    public void setEventTime(MicroTime eventTime) {
        this.eventTime = eventTime;
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

    @JsonProperty("metadata")
    public ObjectMeta getMetadata() {
        return metadata;
    }

    @JsonProperty("metadata")
    public void setMetadata(ObjectMeta metadata) {
        this.metadata = metadata;
    }

    @JsonProperty("note")
    public String getNote() {
        return note;
    }

    @JsonProperty("note")
    public void setNote(String note) {
        this.note = note;
    }

    @JsonProperty("reason")
    public String getReason() {
        return reason;
    }

    @JsonProperty("reason")
    public void setReason(String reason) {
        this.reason = reason;
    }

    @JsonProperty("regarding")
    public ObjectReference getRegarding() {
        return regarding;
    }

    @JsonProperty("regarding")
    public void setRegarding(ObjectReference regarding) {
        this.regarding = regarding;
    }

    @JsonProperty("related")
    public ObjectReference getRelated() {
        return related;
    }

    @JsonProperty("related")
    public void setRelated(ObjectReference related) {
        this.related = related;
    }

    @JsonProperty("reportingController")
    public String getReportingController() {
        return reportingController;
    }

    @JsonProperty("reportingController")
    public void setReportingController(String reportingController) {
        this.reportingController = reportingController;
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
