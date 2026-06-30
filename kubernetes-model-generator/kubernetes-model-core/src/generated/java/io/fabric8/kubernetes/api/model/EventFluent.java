package io.fabric8.kubernetes.api.model;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import java.lang.Integer;
import java.lang.Object;
import java.lang.String;
import java.lang.StringBuilder;
import java.lang.SuppressWarnings;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

/**
 * Generated
 */
@SuppressWarnings("unchecked")
public class EventFluent<A extends io.fabric8.kubernetes.api.model.EventFluent<A>> extends BaseFluent<A>{

  private String action;
  private Map<String,Object> additionalProperties;
  private String apiVersion;
  private Integer count;
  private MicroTimeBuilder eventTime;
  private String firstTimestamp;
  private ObjectReferenceBuilder involvedObject;
  private String kind;
  private String lastTimestamp;
  private String message;
  private ObjectMetaBuilder metadata;
  private String reason;
  private ObjectReferenceBuilder related;
  private String reportingComponent;
  private String reportingInstance;
  private EventSeriesBuilder series;
  private EventSourceBuilder source;
  private String type;

  public EventFluent() {
  }
  
  public EventFluent(Event instance) {
    this.copyInstance(instance);
  }

  public A addToAdditionalProperties(Map<String,Object> map) {
    if (this.additionalProperties == null && map != null) {
      this.additionalProperties = new LinkedHashMap();
    }
    if (map != null) {
      this.additionalProperties.putAll(map);
    }
    return (A) this;
  }
  
  public A addToAdditionalProperties(String key,Object value) {
    if (this.additionalProperties == null && key != null && value != null) {
      this.additionalProperties = new LinkedHashMap();
    }
    if (key != null && value != null) {
      this.additionalProperties.put(key, value);
    }
    return (A) this;
  }
  
  public MicroTime buildEventTime() {
    return this.eventTime != null ? this.eventTime.build() : null;
  }
  
  public ObjectReference buildInvolvedObject() {
    return this.involvedObject != null ? this.involvedObject.build() : null;
  }
  
  public ObjectMeta buildMetadata() {
    return this.metadata != null ? this.metadata.build() : null;
  }
  
  public ObjectReference buildRelated() {
    return this.related != null ? this.related.build() : null;
  }
  
  public EventSeries buildSeries() {
    return this.series != null ? this.series.build() : null;
  }
  
  public EventSource buildSource() {
    return this.source != null ? this.source.build() : null;
  }
  
  protected void copyInstance(Event instance) {
    instance = instance != null ? instance : new Event();
    if (instance != null) {
        this.withAction(instance.getAction());
        this.withApiVersion(instance.getApiVersion());
        this.withCount(instance.getCount());
        this.withEventTime(instance.getEventTime());
        this.withFirstTimestamp(instance.getFirstTimestamp());
        this.withInvolvedObject(instance.getInvolvedObject());
        this.withKind(instance.getKind());
        this.withLastTimestamp(instance.getLastTimestamp());
        this.withMessage(instance.getMessage());
        this.withMetadata(instance.getMetadata());
        this.withReason(instance.getReason());
        this.withRelated(instance.getRelated());
        this.withReportingComponent(instance.getReportingComponent());
        this.withReportingInstance(instance.getReportingInstance());
        this.withSeries(instance.getSeries());
        this.withSource(instance.getSource());
        this.withType(instance.getType());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public EventTimeNested<A> editEventTime() {
    return this.withNewEventTimeLike(Optional.ofNullable(this.buildEventTime()).orElse(null));
  }
  
  public InvolvedObjectNested<A> editInvolvedObject() {
    return this.withNewInvolvedObjectLike(Optional.ofNullable(this.buildInvolvedObject()).orElse(null));
  }
  
  public MetadataNested<A> editMetadata() {
    return this.withNewMetadataLike(Optional.ofNullable(this.buildMetadata()).orElse(null));
  }
  
  public EventTimeNested<A> editOrNewEventTime() {
    return this.withNewEventTimeLike(Optional.ofNullable(this.buildEventTime()).orElse(new MicroTimeBuilder().build()));
  }
  
  public EventTimeNested<A> editOrNewEventTimeLike(MicroTime item) {
    return this.withNewEventTimeLike(Optional.ofNullable(this.buildEventTime()).orElse(item));
  }
  
  public InvolvedObjectNested<A> editOrNewInvolvedObject() {
    return this.withNewInvolvedObjectLike(Optional.ofNullable(this.buildInvolvedObject()).orElse(new ObjectReferenceBuilder().build()));
  }
  
  public InvolvedObjectNested<A> editOrNewInvolvedObjectLike(ObjectReference item) {
    return this.withNewInvolvedObjectLike(Optional.ofNullable(this.buildInvolvedObject()).orElse(item));
  }
  
  public MetadataNested<A> editOrNewMetadata() {
    return this.withNewMetadataLike(Optional.ofNullable(this.buildMetadata()).orElse(new ObjectMetaBuilder().build()));
  }
  
  public MetadataNested<A> editOrNewMetadataLike(ObjectMeta item) {
    return this.withNewMetadataLike(Optional.ofNullable(this.buildMetadata()).orElse(item));
  }
  
  public RelatedNested<A> editOrNewRelated() {
    return this.withNewRelatedLike(Optional.ofNullable(this.buildRelated()).orElse(new ObjectReferenceBuilder().build()));
  }
  
  public RelatedNested<A> editOrNewRelatedLike(ObjectReference item) {
    return this.withNewRelatedLike(Optional.ofNullable(this.buildRelated()).orElse(item));
  }
  
  public SeriesNested<A> editOrNewSeries() {
    return this.withNewSeriesLike(Optional.ofNullable(this.buildSeries()).orElse(new EventSeriesBuilder().build()));
  }
  
  public SeriesNested<A> editOrNewSeriesLike(EventSeries item) {
    return this.withNewSeriesLike(Optional.ofNullable(this.buildSeries()).orElse(item));
  }
  
  public SourceNested<A> editOrNewSource() {
    return this.withNewSourceLike(Optional.ofNullable(this.buildSource()).orElse(new EventSourceBuilder().build()));
  }
  
  public SourceNested<A> editOrNewSourceLike(EventSource item) {
    return this.withNewSourceLike(Optional.ofNullable(this.buildSource()).orElse(item));
  }
  
  public RelatedNested<A> editRelated() {
    return this.withNewRelatedLike(Optional.ofNullable(this.buildRelated()).orElse(null));
  }
  
  public SeriesNested<A> editSeries() {
    return this.withNewSeriesLike(Optional.ofNullable(this.buildSeries()).orElse(null));
  }
  
  public SourceNested<A> editSource() {
    return this.withNewSourceLike(Optional.ofNullable(this.buildSource()).orElse(null));
  }
  
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || this.getClass() != o.getClass()) {
      return false;
    }
    if (!(super.equals(o))) {
      return false;
    }
    EventFluent that = (EventFluent) o;
    if (!(Objects.equals(action, that.action))) {
      return false;
    }
    if (!(Objects.equals(apiVersion, that.apiVersion))) {
      return false;
    }
    if (!(Objects.equals(count, that.count))) {
      return false;
    }
    if (!(Objects.equals(eventTime, that.eventTime))) {
      return false;
    }
    if (!(Objects.equals(firstTimestamp, that.firstTimestamp))) {
      return false;
    }
    if (!(Objects.equals(involvedObject, that.involvedObject))) {
      return false;
    }
    if (!(Objects.equals(kind, that.kind))) {
      return false;
    }
    if (!(Objects.equals(lastTimestamp, that.lastTimestamp))) {
      return false;
    }
    if (!(Objects.equals(message, that.message))) {
      return false;
    }
    if (!(Objects.equals(metadata, that.metadata))) {
      return false;
    }
    if (!(Objects.equals(reason, that.reason))) {
      return false;
    }
    if (!(Objects.equals(related, that.related))) {
      return false;
    }
    if (!(Objects.equals(reportingComponent, that.reportingComponent))) {
      return false;
    }
    if (!(Objects.equals(reportingInstance, that.reportingInstance))) {
      return false;
    }
    if (!(Objects.equals(series, that.series))) {
      return false;
    }
    if (!(Objects.equals(source, that.source))) {
      return false;
    }
    if (!(Objects.equals(type, that.type))) {
      return false;
    }
    if (!(Objects.equals(additionalProperties, that.additionalProperties))) {
      return false;
    }
    return true;
  }
  
  public String getAction() {
    return this.action;
  }
  
  public Map<String,Object> getAdditionalProperties() {
    return this.additionalProperties;
  }
  
  public String getApiVersion() {
    return this.apiVersion;
  }
  
  public Integer getCount() {
    return this.count;
  }
  
  public String getFirstTimestamp() {
    return this.firstTimestamp;
  }
  
  public String getKind() {
    return this.kind;
  }
  
  public String getLastTimestamp() {
    return this.lastTimestamp;
  }
  
  public String getMessage() {
    return this.message;
  }
  
  public String getReason() {
    return this.reason;
  }
  
  public String getReportingComponent() {
    return this.reportingComponent;
  }
  
  public String getReportingInstance() {
    return this.reportingInstance;
  }
  
  public String getType() {
    return this.type;
  }
  
  public boolean hasAction() {
    return this.action != null;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasApiVersion() {
    return this.apiVersion != null;
  }
  
  public boolean hasCount() {
    return this.count != null;
  }
  
  public boolean hasEventTime() {
    return this.eventTime != null;
  }
  
  public boolean hasFirstTimestamp() {
    return this.firstTimestamp != null;
  }
  
  public boolean hasInvolvedObject() {
    return this.involvedObject != null;
  }
  
  public boolean hasKind() {
    return this.kind != null;
  }
  
  public boolean hasLastTimestamp() {
    return this.lastTimestamp != null;
  }
  
  public boolean hasMessage() {
    return this.message != null;
  }
  
  public boolean hasMetadata() {
    return this.metadata != null;
  }
  
  public boolean hasReason() {
    return this.reason != null;
  }
  
  public boolean hasRelated() {
    return this.related != null;
  }
  
  public boolean hasReportingComponent() {
    return this.reportingComponent != null;
  }
  
  public boolean hasReportingInstance() {
    return this.reportingInstance != null;
  }
  
  public boolean hasSeries() {
    return this.series != null;
  }
  
  public boolean hasSource() {
    return this.source != null;
  }
  
  public boolean hasType() {
    return this.type != null;
  }
  
  public int hashCode() {
    return Objects.hash(action, apiVersion, count, eventTime, firstTimestamp, involvedObject, kind, lastTimestamp, message, metadata, reason, related, reportingComponent, reportingInstance, series, source, type, additionalProperties);
  }
  
  public A removeFromAdditionalProperties(String key) {
    if (this.additionalProperties == null) {
      return (A) this;
    }
    if (key != null && this.additionalProperties != null) {
      this.additionalProperties.remove(key);
    }
    return (A) this;
  }
  
  public A removeFromAdditionalProperties(Map<String,Object> map) {
    if (this.additionalProperties == null) {
      return (A) this;
    }
    if (map != null) {
      for (Object key : map.keySet()) {
        if (this.additionalProperties != null) {
          this.additionalProperties.remove(key);
        }
      }
    }
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(action == null)) {
        sb.append("action:");
        sb.append(action);
        sb.append(",");
    }
    if (!(apiVersion == null)) {
        sb.append("apiVersion:");
        sb.append(apiVersion);
        sb.append(",");
    }
    if (!(count == null)) {
        sb.append("count:");
        sb.append(count);
        sb.append(",");
    }
    if (!(eventTime == null)) {
        sb.append("eventTime:");
        sb.append(eventTime);
        sb.append(",");
    }
    if (!(firstTimestamp == null)) {
        sb.append("firstTimestamp:");
        sb.append(firstTimestamp);
        sb.append(",");
    }
    if (!(involvedObject == null)) {
        sb.append("involvedObject:");
        sb.append(involvedObject);
        sb.append(",");
    }
    if (!(kind == null)) {
        sb.append("kind:");
        sb.append(kind);
        sb.append(",");
    }
    if (!(lastTimestamp == null)) {
        sb.append("lastTimestamp:");
        sb.append(lastTimestamp);
        sb.append(",");
    }
    if (!(message == null)) {
        sb.append("message:");
        sb.append(message);
        sb.append(",");
    }
    if (!(metadata == null)) {
        sb.append("metadata:");
        sb.append(metadata);
        sb.append(",");
    }
    if (!(reason == null)) {
        sb.append("reason:");
        sb.append(reason);
        sb.append(",");
    }
    if (!(related == null)) {
        sb.append("related:");
        sb.append(related);
        sb.append(",");
    }
    if (!(reportingComponent == null)) {
        sb.append("reportingComponent:");
        sb.append(reportingComponent);
        sb.append(",");
    }
    if (!(reportingInstance == null)) {
        sb.append("reportingInstance:");
        sb.append(reportingInstance);
        sb.append(",");
    }
    if (!(series == null)) {
        sb.append("series:");
        sb.append(series);
        sb.append(",");
    }
    if (!(source == null)) {
        sb.append("source:");
        sb.append(source);
        sb.append(",");
    }
    if (!(type == null)) {
        sb.append("type:");
        sb.append(type);
        sb.append(",");
    }
    if (!(additionalProperties == null) && !(additionalProperties.isEmpty())) {
        sb.append("additionalProperties:");
        sb.append(additionalProperties);
    }
    sb.append("}");
    return sb.toString();
  }
  
  public A withAction(String action) {
    this.action = action;
    return (A) this;
  }
  
  public <K,V>A withAdditionalProperties(Map<String,Object> additionalProperties) {
    if (additionalProperties == null) {
      this.additionalProperties = null;
    } else {
      this.additionalProperties = new LinkedHashMap(additionalProperties);
    }
    return (A) this;
  }
  
  public A withApiVersion(String apiVersion) {
    this.apiVersion = apiVersion;
    return (A) this;
  }
  
  public A withCount(Integer count) {
    this.count = count;
    return (A) this;
  }
  
  public A withEventTime(MicroTime eventTime) {
    this._visitables.remove("eventTime");
    if (eventTime != null) {
        this.eventTime = new MicroTimeBuilder(eventTime);
        this._visitables.get("eventTime").add(this.eventTime);
    } else {
        this.eventTime = null;
        this._visitables.get("eventTime").remove(this.eventTime);
    }
    return (A) this;
  }
  
  public A withFirstTimestamp(String firstTimestamp) {
    this.firstTimestamp = firstTimestamp;
    return (A) this;
  }
  
  public A withInvolvedObject(ObjectReference involvedObject) {
    this._visitables.remove("involvedObject");
    if (involvedObject != null) {
        this.involvedObject = new ObjectReferenceBuilder(involvedObject);
        this._visitables.get("involvedObject").add(this.involvedObject);
    } else {
        this.involvedObject = null;
        this._visitables.get("involvedObject").remove(this.involvedObject);
    }
    return (A) this;
  }
  
  public A withKind(String kind) {
    this.kind = kind;
    return (A) this;
  }
  
  public A withLastTimestamp(String lastTimestamp) {
    this.lastTimestamp = lastTimestamp;
    return (A) this;
  }
  
  public A withMessage(String message) {
    this.message = message;
    return (A) this;
  }
  
  public A withMetadata(ObjectMeta metadata) {
    this._visitables.remove("metadata");
    if (metadata != null) {
        this.metadata = new ObjectMetaBuilder(metadata);
        this._visitables.get("metadata").add(this.metadata);
    } else {
        this.metadata = null;
        this._visitables.get("metadata").remove(this.metadata);
    }
    return (A) this;
  }
  
  public EventTimeNested<A> withNewEventTime() {
    return new EventTimeNested(null);
  }
  
  public A withNewEventTime(String time) {
    return (A) this.withEventTime(new MicroTime(time));
  }
  
  public EventTimeNested<A> withNewEventTimeLike(MicroTime item) {
    return new EventTimeNested(item);
  }
  
  public InvolvedObjectNested<A> withNewInvolvedObject() {
    return new InvolvedObjectNested(null);
  }
  
  public InvolvedObjectNested<A> withNewInvolvedObjectLike(ObjectReference item) {
    return new InvolvedObjectNested(item);
  }
  
  public MetadataNested<A> withNewMetadata() {
    return new MetadataNested(null);
  }
  
  public MetadataNested<A> withNewMetadataLike(ObjectMeta item) {
    return new MetadataNested(item);
  }
  
  public RelatedNested<A> withNewRelated() {
    return new RelatedNested(null);
  }
  
  public RelatedNested<A> withNewRelatedLike(ObjectReference item) {
    return new RelatedNested(item);
  }
  
  public SeriesNested<A> withNewSeries() {
    return new SeriesNested(null);
  }
  
  public SeriesNested<A> withNewSeriesLike(EventSeries item) {
    return new SeriesNested(item);
  }
  
  public SourceNested<A> withNewSource() {
    return new SourceNested(null);
  }
  
  public A withNewSource(String component,String host) {
    return (A) this.withSource(new EventSource(component, host));
  }
  
  public SourceNested<A> withNewSourceLike(EventSource item) {
    return new SourceNested(item);
  }
  
  public A withReason(String reason) {
    this.reason = reason;
    return (A) this;
  }
  
  public A withRelated(ObjectReference related) {
    this._visitables.remove("related");
    if (related != null) {
        this.related = new ObjectReferenceBuilder(related);
        this._visitables.get("related").add(this.related);
    } else {
        this.related = null;
        this._visitables.get("related").remove(this.related);
    }
    return (A) this;
  }
  
  public A withReportingComponent(String reportingComponent) {
    this.reportingComponent = reportingComponent;
    return (A) this;
  }
  
  public A withReportingInstance(String reportingInstance) {
    this.reportingInstance = reportingInstance;
    return (A) this;
  }
  
  public A withSeries(EventSeries series) {
    this._visitables.remove("series");
    if (series != null) {
        this.series = new EventSeriesBuilder(series);
        this._visitables.get("series").add(this.series);
    } else {
        this.series = null;
        this._visitables.get("series").remove(this.series);
    }
    return (A) this;
  }
  
  public A withSource(EventSource source) {
    this._visitables.remove("source");
    if (source != null) {
        this.source = new EventSourceBuilder(source);
        this._visitables.get("source").add(this.source);
    } else {
        this.source = null;
        this._visitables.get("source").remove(this.source);
    }
    return (A) this;
  }
  
  public A withType(String type) {
    this.type = type;
    return (A) this;
  }
  public class EventTimeNested<N> extends MicroTimeFluent<EventTimeNested<N>> implements Nested<N>{
  
    MicroTimeBuilder builder;
  
    EventTimeNested(MicroTime item) {
      this.builder = new MicroTimeBuilder(this, item);
    }
  
    public N and() {
      return (N) EventFluent.this.withEventTime(builder.build());
    }
    
    public N endEventTime() {
      return and();
    }
    
  }
  public class InvolvedObjectNested<N> extends ObjectReferenceFluent<InvolvedObjectNested<N>> implements Nested<N>{
  
    ObjectReferenceBuilder builder;
  
    InvolvedObjectNested(ObjectReference item) {
      this.builder = new ObjectReferenceBuilder(this, item);
    }
  
    public N and() {
      return (N) EventFluent.this.withInvolvedObject(builder.build());
    }
    
    public N endInvolvedObject() {
      return and();
    }
    
  }
  public class MetadataNested<N> extends ObjectMetaFluent<MetadataNested<N>> implements Nested<N>{
  
    ObjectMetaBuilder builder;
  
    MetadataNested(ObjectMeta item) {
      this.builder = new ObjectMetaBuilder(this, item);
    }
  
    public N and() {
      return (N) EventFluent.this.withMetadata(builder.build());
    }
    
    public N endMetadata() {
      return and();
    }
    
  }
  public class RelatedNested<N> extends ObjectReferenceFluent<RelatedNested<N>> implements Nested<N>{
  
    ObjectReferenceBuilder builder;
  
    RelatedNested(ObjectReference item) {
      this.builder = new ObjectReferenceBuilder(this, item);
    }
  
    public N and() {
      return (N) EventFluent.this.withRelated(builder.build());
    }
    
    public N endRelated() {
      return and();
    }
    
  }
  public class SeriesNested<N> extends EventSeriesFluent<SeriesNested<N>> implements Nested<N>{
  
    EventSeriesBuilder builder;
  
    SeriesNested(EventSeries item) {
      this.builder = new EventSeriesBuilder(this, item);
    }
  
    public N and() {
      return (N) EventFluent.this.withSeries(builder.build());
    }
    
    public N endSeries() {
      return and();
    }
    
  }
  public class SourceNested<N> extends EventSourceFluent<SourceNested<N>> implements Nested<N>{
  
    EventSourceBuilder builder;
  
    SourceNested(EventSource item) {
      this.builder = new EventSourceBuilder(this, item);
    }
  
    public N and() {
      return (N) EventFluent.this.withSource(builder.build());
    }
    
    public N endSource() {
      return and();
    }
    
  }
}