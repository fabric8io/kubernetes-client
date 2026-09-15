
package io.fabric8.kubernetes.api.model.events.v1beta1;

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

/**
 * Event is a report of an event somewhere in the cluster. It generally denotes some state change in the system. Events have a limited retention time and triggers and messages may evolve with time.  Event consumers should not rely on the timing of an event with a given Reason reflecting a consistent underlying trigger, or the continued existence of events with that Reason.  Events should be treated as informative, best-effort, supplemental data.
 */
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
@Version("v1beta1")
@Group("events.k8s.io")
@Generated("io.fabric8.kubernetes.schema.generator.model.ModelGenerator")
public class Event implements Editable<EventBuilder>, HasMetadata, Namespaced
{

    @JsonProperty("action")
    private String action;
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

    /**
     * action is what action was taken/failed regarding to the regarding object. It is machine-readable. This field can have at most 128 characters.
     */
    @JsonProperty("action")
    public String getAction() {
        return action;
    }

    /**
     * action is what action was taken/failed regarding to the regarding object. It is machine-readable. This field can have at most 128 characters.
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
     * deprecatedCount is the deprecated field assuring backward compatibility with core.v1 Event type.
     */
    @JsonProperty("deprecatedCount")
    public Integer getDeprecatedCount() {
        return deprecatedCount;
    }

    /**
     * deprecatedCount is the deprecated field assuring backward compatibility with core.v1 Event type.
     */
    @JsonProperty("deprecatedCount")
    public void setDeprecatedCount(Integer deprecatedCount) {
        this.deprecatedCount = deprecatedCount;
    }

    /**
     * Event is a report of an event somewhere in the cluster. It generally denotes some state change in the system. Events have a limited retention time and triggers and messages may evolve with time.  Event consumers should not rely on the timing of an event with a given Reason reflecting a consistent underlying trigger, or the continued existence of events with that Reason.  Events should be treated as informative, best-effort, supplemental data.
     */
    @JsonProperty("deprecatedFirstTimestamp")
    public String getDeprecatedFirstTimestamp() {
        return deprecatedFirstTimestamp;
    }

    /**
     * Event is a report of an event somewhere in the cluster. It generally denotes some state change in the system. Events have a limited retention time and triggers and messages may evolve with time.  Event consumers should not rely on the timing of an event with a given Reason reflecting a consistent underlying trigger, or the continued existence of events with that Reason.  Events should be treated as informative, best-effort, supplemental data.
     */
    @JsonProperty("deprecatedFirstTimestamp")
    public void setDeprecatedFirstTimestamp(String deprecatedFirstTimestamp) {
        this.deprecatedFirstTimestamp = deprecatedFirstTimestamp;
    }

    /**
     * Event is a report of an event somewhere in the cluster. It generally denotes some state change in the system. Events have a limited retention time and triggers and messages may evolve with time.  Event consumers should not rely on the timing of an event with a given Reason reflecting a consistent underlying trigger, or the continued existence of events with that Reason.  Events should be treated as informative, best-effort, supplemental data.
     */
    @JsonProperty("deprecatedLastTimestamp")
    public String getDeprecatedLastTimestamp() {
        return deprecatedLastTimestamp;
    }

    /**
     * Event is a report of an event somewhere in the cluster. It generally denotes some state change in the system. Events have a limited retention time and triggers and messages may evolve with time.  Event consumers should not rely on the timing of an event with a given Reason reflecting a consistent underlying trigger, or the continued existence of events with that Reason.  Events should be treated as informative, best-effort, supplemental data.
     */
    @JsonProperty("deprecatedLastTimestamp")
    public void setDeprecatedLastTimestamp(String deprecatedLastTimestamp) {
        this.deprecatedLastTimestamp = deprecatedLastTimestamp;
    }

    /**
     * Event is a report of an event somewhere in the cluster. It generally denotes some state change in the system. Events have a limited retention time and triggers and messages may evolve with time.  Event consumers should not rely on the timing of an event with a given Reason reflecting a consistent underlying trigger, or the continued existence of events with that Reason.  Events should be treated as informative, best-effort, supplemental data.
     */
    @JsonProperty("deprecatedSource")
    public EventSource getDeprecatedSource() {
        return deprecatedSource;
    }

    /**
     * Event is a report of an event somewhere in the cluster. It generally denotes some state change in the system. Events have a limited retention time and triggers and messages may evolve with time.  Event consumers should not rely on the timing of an event with a given Reason reflecting a consistent underlying trigger, or the continued existence of events with that Reason.  Events should be treated as informative, best-effort, supplemental data.
     */
    @JsonProperty("deprecatedSource")
    public void setDeprecatedSource(EventSource deprecatedSource) {
        this.deprecatedSource = deprecatedSource;
    }

    /**
     * Event is a report of an event somewhere in the cluster. It generally denotes some state change in the system. Events have a limited retention time and triggers and messages may evolve with time.  Event consumers should not rely on the timing of an event with a given Reason reflecting a consistent underlying trigger, or the continued existence of events with that Reason.  Events should be treated as informative, best-effort, supplemental data.
     */
    @JsonProperty("eventTime")
    public MicroTime getEventTime() {
        return eventTime;
    }

    /**
     * Event is a report of an event somewhere in the cluster. It generally denotes some state change in the system. Events have a limited retention time and triggers and messages may evolve with time.  Event consumers should not rely on the timing of an event with a given Reason reflecting a consistent underlying trigger, or the continued existence of events with that Reason.  Events should be treated as informative, best-effort, supplemental data.
     */
    @JsonProperty("eventTime")
    public void setEventTime(MicroTime eventTime) {
        this.eventTime = eventTime;
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
     * Event is a report of an event somewhere in the cluster. It generally denotes some state change in the system. Events have a limited retention time and triggers and messages may evolve with time.  Event consumers should not rely on the timing of an event with a given Reason reflecting a consistent underlying trigger, or the continued existence of events with that Reason.  Events should be treated as informative, best-effort, supplemental data.
     */
    @JsonProperty("metadata")
    public ObjectMeta getMetadata() {
        return metadata;
    }

    /**
     * Event is a report of an event somewhere in the cluster. It generally denotes some state change in the system. Events have a limited retention time and triggers and messages may evolve with time.  Event consumers should not rely on the timing of an event with a given Reason reflecting a consistent underlying trigger, or the continued existence of events with that Reason.  Events should be treated as informative, best-effort, supplemental data.
     */
    @JsonProperty("metadata")
    public void setMetadata(ObjectMeta metadata) {
        this.metadata = metadata;
    }

    /**
     * note is a human-readable description of the status of this operation. Maximal length of the note is 1kB, but libraries should be prepared to handle values up to 64kB.
     */
    @JsonProperty("note")
    public String getNote() {
        return note;
    }

    /**
     * note is a human-readable description of the status of this operation. Maximal length of the note is 1kB, but libraries should be prepared to handle values up to 64kB.
     */
    @JsonProperty("note")
    public void setNote(String note) {
        this.note = note;
    }

    /**
     * reason is why the action was taken. It is human-readable. This field can have at most 128 characters.
     */
    @JsonProperty("reason")
    public String getReason() {
        return reason;
    }

    /**
     * reason is why the action was taken. It is human-readable. This field can have at most 128 characters.
     */
    @JsonProperty("reason")
    public void setReason(String reason) {
        this.reason = reason;
    }

    /**
     * Event is a report of an event somewhere in the cluster. It generally denotes some state change in the system. Events have a limited retention time and triggers and messages may evolve with time.  Event consumers should not rely on the timing of an event with a given Reason reflecting a consistent underlying trigger, or the continued existence of events with that Reason.  Events should be treated as informative, best-effort, supplemental data.
     */
    @JsonProperty("regarding")
    public ObjectReference getRegarding() {
        return regarding;
    }

    /**
     * Event is a report of an event somewhere in the cluster. It generally denotes some state change in the system. Events have a limited retention time and triggers and messages may evolve with time.  Event consumers should not rely on the timing of an event with a given Reason reflecting a consistent underlying trigger, or the continued existence of events with that Reason.  Events should be treated as informative, best-effort, supplemental data.
     */
    @JsonProperty("regarding")
    public void setRegarding(ObjectReference regarding) {
        this.regarding = regarding;
    }

    /**
     * Event is a report of an event somewhere in the cluster. It generally denotes some state change in the system. Events have a limited retention time and triggers and messages may evolve with time.  Event consumers should not rely on the timing of an event with a given Reason reflecting a consistent underlying trigger, or the continued existence of events with that Reason.  Events should be treated as informative, best-effort, supplemental data.
     */
    @JsonProperty("related")
    public ObjectReference getRelated() {
        return related;
    }

    /**
     * Event is a report of an event somewhere in the cluster. It generally denotes some state change in the system. Events have a limited retention time and triggers and messages may evolve with time.  Event consumers should not rely on the timing of an event with a given Reason reflecting a consistent underlying trigger, or the continued existence of events with that Reason.  Events should be treated as informative, best-effort, supplemental data.
     */
    @JsonProperty("related")
    public void setRelated(ObjectReference related) {
        this.related = related;
    }

    /**
     * reportingController is the name of the controller that emitted this Event, e.g. `kubernetes.io/kubelet`. This field cannot be empty for new Events.
     */
    @JsonProperty("reportingController")
    public String getReportingController() {
        return reportingController;
    }

    /**
     * reportingController is the name of the controller that emitted this Event, e.g. `kubernetes.io/kubelet`. This field cannot be empty for new Events.
     */
    @JsonProperty("reportingController")
    public void setReportingController(String reportingController) {
        this.reportingController = reportingController;
    }

    /**
     * reportingInstance is the ID of the controller instance, e.g. `kubelet-xyzf`. This field cannot be empty for new Events and it can have at most 128 characters.
     */
    @JsonProperty("reportingInstance")
    public String getReportingInstance() {
        return reportingInstance;
    }

    /**
     * reportingInstance is the ID of the controller instance, e.g. `kubelet-xyzf`. This field cannot be empty for new Events and it can have at most 128 characters.
     */
    @JsonProperty("reportingInstance")
    public void setReportingInstance(String reportingInstance) {
        this.reportingInstance = reportingInstance;
    }

    /**
     * Event is a report of an event somewhere in the cluster. It generally denotes some state change in the system. Events have a limited retention time and triggers and messages may evolve with time.  Event consumers should not rely on the timing of an event with a given Reason reflecting a consistent underlying trigger, or the continued existence of events with that Reason.  Events should be treated as informative, best-effort, supplemental data.
     */
    @JsonProperty("series")
    public EventSeries getSeries() {
        return series;
    }

    /**
     * Event is a report of an event somewhere in the cluster. It generally denotes some state change in the system. Events have a limited retention time and triggers and messages may evolve with time.  Event consumers should not rely on the timing of an event with a given Reason reflecting a consistent underlying trigger, or the continued existence of events with that Reason.  Events should be treated as informative, best-effort, supplemental data.
     */
    @JsonProperty("series")
    public void setSeries(EventSeries series) {
        this.series = series;
    }

    /**
     * type is the type of this event (Normal, Warning), new types could be added in the future. It is machine-readable.
     */
    @JsonProperty("type")
    public String getType() {
        return type;
    }

    /**
     * type is the type of this event (Normal, Warning), new types could be added in the future. It is machine-readable.
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
        Object this$deprecatedCount = this.getDeprecatedCount();
        Object other$deprecatedCount = other.getDeprecatedCount();
        if (this$deprecatedCount == null ? other$deprecatedCount != null : !this$deprecatedCount.equals(other$deprecatedCount)) {
            return false;
        }
        Object this$deprecatedFirstTimestamp = this.getDeprecatedFirstTimestamp();
        Object other$deprecatedFirstTimestamp = other.getDeprecatedFirstTimestamp();
        if (this$deprecatedFirstTimestamp == null ? other$deprecatedFirstTimestamp != null : !this$deprecatedFirstTimestamp.equals(other$deprecatedFirstTimestamp)) {
            return false;
        }
        Object this$deprecatedLastTimestamp = this.getDeprecatedLastTimestamp();
        Object other$deprecatedLastTimestamp = other.getDeprecatedLastTimestamp();
        if (this$deprecatedLastTimestamp == null ? other$deprecatedLastTimestamp != null : !this$deprecatedLastTimestamp.equals(other$deprecatedLastTimestamp)) {
            return false;
        }
        Object this$deprecatedSource = this.getDeprecatedSource();
        Object other$deprecatedSource = other.getDeprecatedSource();
        if (this$deprecatedSource == null ? other$deprecatedSource != null : !this$deprecatedSource.equals(other$deprecatedSource)) {
            return false;
        }
        Object this$eventTime = this.getEventTime();
        Object other$eventTime = other.getEventTime();
        if (this$eventTime == null ? other$eventTime != null : !this$eventTime.equals(other$eventTime)) {
            return false;
        }
        Object this$kind = this.getKind();
        Object other$kind = other.getKind();
        if (this$kind == null ? other$kind != null : !this$kind.equals(other$kind)) {
            return false;
        }
        Object this$metadata = this.getMetadata();
        Object other$metadata = other.getMetadata();
        if (this$metadata == null ? other$metadata != null : !this$metadata.equals(other$metadata)) {
            return false;
        }
        Object this$note = this.getNote();
        Object other$note = other.getNote();
        if (this$note == null ? other$note != null : !this$note.equals(other$note)) {
            return false;
        }
        Object this$reason = this.getReason();
        Object other$reason = other.getReason();
        if (this$reason == null ? other$reason != null : !this$reason.equals(other$reason)) {
            return false;
        }
        Object this$regarding = this.getRegarding();
        Object other$regarding = other.getRegarding();
        if (this$regarding == null ? other$regarding != null : !this$regarding.equals(other$regarding)) {
            return false;
        }
        Object this$related = this.getRelated();
        Object other$related = other.getRelated();
        if (this$related == null ? other$related != null : !this$related.equals(other$related)) {
            return false;
        }
        Object this$reportingController = this.getReportingController();
        Object other$reportingController = other.getReportingController();
        if (this$reportingController == null ? other$reportingController != null : !this$reportingController.equals(other$reportingController)) {
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
        Object $deprecatedCount = this.getDeprecatedCount();
        result = result * prime + ($deprecatedCount == null ? 43 : $deprecatedCount.hashCode());
        Object $deprecatedFirstTimestamp = this.getDeprecatedFirstTimestamp();
        result = result * prime + ($deprecatedFirstTimestamp == null ? 43 : $deprecatedFirstTimestamp.hashCode());
        Object $deprecatedLastTimestamp = this.getDeprecatedLastTimestamp();
        result = result * prime + ($deprecatedLastTimestamp == null ? 43 : $deprecatedLastTimestamp.hashCode());
        Object $deprecatedSource = this.getDeprecatedSource();
        result = result * prime + ($deprecatedSource == null ? 43 : $deprecatedSource.hashCode());
        Object $eventTime = this.getEventTime();
        result = result * prime + ($eventTime == null ? 43 : $eventTime.hashCode());
        Object $kind = this.getKind();
        result = result * prime + ($kind == null ? 43 : $kind.hashCode());
        Object $metadata = this.getMetadata();
        result = result * prime + ($metadata == null ? 43 : $metadata.hashCode());
        Object $note = this.getNote();
        result = result * prime + ($note == null ? 43 : $note.hashCode());
        Object $reason = this.getReason();
        result = result * prime + ($reason == null ? 43 : $reason.hashCode());
        Object $regarding = this.getRegarding();
        result = result * prime + ($regarding == null ? 43 : $regarding.hashCode());
        Object $related = this.getRelated();
        result = result * prime + ($related == null ? 43 : $related.hashCode());
        Object $reportingController = this.getReportingController();
        result = result * prime + ($reportingController == null ? 43 : $reportingController.hashCode());
        Object $reportingInstance = this.getReportingInstance();
        result = result * prime + ($reportingInstance == null ? 43 : $reportingInstance.hashCode());
        Object $series = this.getSeries();
        result = result * prime + ($series == null ? 43 : $series.hashCode());
        Object $type = this.getType();
        result = result * prime + ($type == null ? 43 : $type.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "Event(" + "action=" + this.getAction() + ", apiVersion=" + this.getApiVersion() + ", deprecatedCount=" + this.getDeprecatedCount() + ", deprecatedFirstTimestamp=" + this.getDeprecatedFirstTimestamp() + ", deprecatedLastTimestamp=" + this.getDeprecatedLastTimestamp() + ", deprecatedSource=" + this.getDeprecatedSource() + ", eventTime=" + this.getEventTime() + ", kind=" + this.getKind() + ", metadata=" + this.getMetadata() + ", note=" + this.getNote() + ", reason=" + this.getReason() + ", regarding=" + this.getRegarding() + ", related=" + this.getRelated() + ", reportingController=" + this.getReportingController() + ", reportingInstance=" + this.getReportingInstance() + ", series=" + this.getSeries() + ", type=" + this.getType() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
