package io.fabric8.kubernetes.api.model.events.v1beta1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import io.fabric8.kubernetes.api.model.EventSource;
import io.fabric8.kubernetes.api.model.MicroTime;
import io.fabric8.kubernetes.api.model.ObjectMeta;
import io.fabric8.kubernetes.api.model.ObjectMetaBuilder;
import io.fabric8.kubernetes.api.model.ObjectMetaFluent;
import io.fabric8.kubernetes.api.model.ObjectReference;
import io.fabric8.kubernetes.api.model.ObjectReferenceBuilder;
import io.fabric8.kubernetes.api.model.ObjectReferenceFluent;
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
public class EventFluent<A extends io.fabric8.kubernetes.api.model.events.v1beta1.EventFluent<A>> extends BaseFluent<A>{

  private String action;
  private Map<String,Object> additionalProperties;
  private String apiVersion;
  private Integer deprecatedCount;
  private String deprecatedFirstTimestamp;
  private String deprecatedLastTimestamp;
  private EventSource deprecatedSource;
  private MicroTime eventTime;
  private String kind;
  private ObjectMetaBuilder metadata;
  private String note;
  private String reason;
  private ObjectReferenceBuilder regarding;
  private ObjectReferenceBuilder related;
  private String reportingController;
  private String reportingInstance;
  private EventSeriesBuilder series;
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
  
  public ObjectMeta buildMetadata() {
    return this.metadata != null ? this.metadata.build() : null;
  }
  
  public ObjectReference buildRegarding() {
    return this.regarding != null ? this.regarding.build() : null;
  }
  
  public ObjectReference buildRelated() {
    return this.related != null ? this.related.build() : null;
  }
  
  public EventSeries buildSeries() {
    return this.series != null ? this.series.build() : null;
  }
  
  protected void copyInstance(Event instance) {
    instance = instance != null ? instance : new Event();
    if (instance != null) {
        this.withAction(instance.getAction());
        this.withApiVersion(instance.getApiVersion());
        this.withDeprecatedCount(instance.getDeprecatedCount());
        this.withDeprecatedFirstTimestamp(instance.getDeprecatedFirstTimestamp());
        this.withDeprecatedLastTimestamp(instance.getDeprecatedLastTimestamp());
        this.withDeprecatedSource(instance.getDeprecatedSource());
        this.withEventTime(instance.getEventTime());
        this.withKind(instance.getKind());
        this.withMetadata(instance.getMetadata());
        this.withNote(instance.getNote());
        this.withReason(instance.getReason());
        this.withRegarding(instance.getRegarding());
        this.withRelated(instance.getRelated());
        this.withReportingController(instance.getReportingController());
        this.withReportingInstance(instance.getReportingInstance());
        this.withSeries(instance.getSeries());
        this.withType(instance.getType());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public MetadataNested<A> editMetadata() {
    return this.withNewMetadataLike(Optional.ofNullable(this.buildMetadata()).orElse(null));
  }
  
  public MetadataNested<A> editOrNewMetadata() {
    return this.withNewMetadataLike(Optional.ofNullable(this.buildMetadata()).orElse(new ObjectMetaBuilder().build()));
  }
  
  public MetadataNested<A> editOrNewMetadataLike(ObjectMeta item) {
    return this.withNewMetadataLike(Optional.ofNullable(this.buildMetadata()).orElse(item));
  }
  
  public RegardingNested<A> editOrNewRegarding() {
    return this.withNewRegardingLike(Optional.ofNullable(this.buildRegarding()).orElse(new ObjectReferenceBuilder().build()));
  }
  
  public RegardingNested<A> editOrNewRegardingLike(ObjectReference item) {
    return this.withNewRegardingLike(Optional.ofNullable(this.buildRegarding()).orElse(item));
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
  
  public RegardingNested<A> editRegarding() {
    return this.withNewRegardingLike(Optional.ofNullable(this.buildRegarding()).orElse(null));
  }
  
  public RelatedNested<A> editRelated() {
    return this.withNewRelatedLike(Optional.ofNullable(this.buildRelated()).orElse(null));
  }
  
  public SeriesNested<A> editSeries() {
    return this.withNewSeriesLike(Optional.ofNullable(this.buildSeries()).orElse(null));
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
    if (!(Objects.equals(deprecatedCount, that.deprecatedCount))) {
      return false;
    }
    if (!(Objects.equals(deprecatedFirstTimestamp, that.deprecatedFirstTimestamp))) {
      return false;
    }
    if (!(Objects.equals(deprecatedLastTimestamp, that.deprecatedLastTimestamp))) {
      return false;
    }
    if (!(Objects.equals(deprecatedSource, that.deprecatedSource))) {
      return false;
    }
    if (!(Objects.equals(eventTime, that.eventTime))) {
      return false;
    }
    if (!(Objects.equals(kind, that.kind))) {
      return false;
    }
    if (!(Objects.equals(metadata, that.metadata))) {
      return false;
    }
    if (!(Objects.equals(note, that.note))) {
      return false;
    }
    if (!(Objects.equals(reason, that.reason))) {
      return false;
    }
    if (!(Objects.equals(regarding, that.regarding))) {
      return false;
    }
    if (!(Objects.equals(related, that.related))) {
      return false;
    }
    if (!(Objects.equals(reportingController, that.reportingController))) {
      return false;
    }
    if (!(Objects.equals(reportingInstance, that.reportingInstance))) {
      return false;
    }
    if (!(Objects.equals(series, that.series))) {
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
  
  public Integer getDeprecatedCount() {
    return this.deprecatedCount;
  }
  
  public String getDeprecatedFirstTimestamp() {
    return this.deprecatedFirstTimestamp;
  }
  
  public String getDeprecatedLastTimestamp() {
    return this.deprecatedLastTimestamp;
  }
  
  public EventSource getDeprecatedSource() {
    return this.deprecatedSource;
  }
  
  public MicroTime getEventTime() {
    return this.eventTime;
  }
  
  public String getKind() {
    return this.kind;
  }
  
  public String getNote() {
    return this.note;
  }
  
  public String getReason() {
    return this.reason;
  }
  
  public String getReportingController() {
    return this.reportingController;
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
  
  public boolean hasDeprecatedCount() {
    return this.deprecatedCount != null;
  }
  
  public boolean hasDeprecatedFirstTimestamp() {
    return this.deprecatedFirstTimestamp != null;
  }
  
  public boolean hasDeprecatedLastTimestamp() {
    return this.deprecatedLastTimestamp != null;
  }
  
  public boolean hasDeprecatedSource() {
    return this.deprecatedSource != null;
  }
  
  public boolean hasEventTime() {
    return this.eventTime != null;
  }
  
  public boolean hasKind() {
    return this.kind != null;
  }
  
  public boolean hasMetadata() {
    return this.metadata != null;
  }
  
  public boolean hasNote() {
    return this.note != null;
  }
  
  public boolean hasReason() {
    return this.reason != null;
  }
  
  public boolean hasRegarding() {
    return this.regarding != null;
  }
  
  public boolean hasRelated() {
    return this.related != null;
  }
  
  public boolean hasReportingController() {
    return this.reportingController != null;
  }
  
  public boolean hasReportingInstance() {
    return this.reportingInstance != null;
  }
  
  public boolean hasSeries() {
    return this.series != null;
  }
  
  public boolean hasType() {
    return this.type != null;
  }
  
  public int hashCode() {
    return Objects.hash(action, apiVersion, deprecatedCount, deprecatedFirstTimestamp, deprecatedLastTimestamp, deprecatedSource, eventTime, kind, metadata, note, reason, regarding, related, reportingController, reportingInstance, series, type, additionalProperties);
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
    if (!(deprecatedCount == null)) {
        sb.append("deprecatedCount:");
        sb.append(deprecatedCount);
        sb.append(",");
    }
    if (!(deprecatedFirstTimestamp == null)) {
        sb.append("deprecatedFirstTimestamp:");
        sb.append(deprecatedFirstTimestamp);
        sb.append(",");
    }
    if (!(deprecatedLastTimestamp == null)) {
        sb.append("deprecatedLastTimestamp:");
        sb.append(deprecatedLastTimestamp);
        sb.append(",");
    }
    if (!(deprecatedSource == null)) {
        sb.append("deprecatedSource:");
        sb.append(deprecatedSource);
        sb.append(",");
    }
    if (!(eventTime == null)) {
        sb.append("eventTime:");
        sb.append(eventTime);
        sb.append(",");
    }
    if (!(kind == null)) {
        sb.append("kind:");
        sb.append(kind);
        sb.append(",");
    }
    if (!(metadata == null)) {
        sb.append("metadata:");
        sb.append(metadata);
        sb.append(",");
    }
    if (!(note == null)) {
        sb.append("note:");
        sb.append(note);
        sb.append(",");
    }
    if (!(reason == null)) {
        sb.append("reason:");
        sb.append(reason);
        sb.append(",");
    }
    if (!(regarding == null)) {
        sb.append("regarding:");
        sb.append(regarding);
        sb.append(",");
    }
    if (!(related == null)) {
        sb.append("related:");
        sb.append(related);
        sb.append(",");
    }
    if (!(reportingController == null)) {
        sb.append("reportingController:");
        sb.append(reportingController);
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
  
  public A withDeprecatedCount(Integer deprecatedCount) {
    this.deprecatedCount = deprecatedCount;
    return (A) this;
  }
  
  public A withDeprecatedFirstTimestamp(String deprecatedFirstTimestamp) {
    this.deprecatedFirstTimestamp = deprecatedFirstTimestamp;
    return (A) this;
  }
  
  public A withDeprecatedLastTimestamp(String deprecatedLastTimestamp) {
    this.deprecatedLastTimestamp = deprecatedLastTimestamp;
    return (A) this;
  }
  
  public A withDeprecatedSource(EventSource deprecatedSource) {
    this.deprecatedSource = deprecatedSource;
    return (A) this;
  }
  
  public A withEventTime(MicroTime eventTime) {
    this.eventTime = eventTime;
    return (A) this;
  }
  
  public A withKind(String kind) {
    this.kind = kind;
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
  
  public A withNewDeprecatedSource(String component,String host) {
    return (A) this.withDeprecatedSource(new EventSource(component, host));
  }
  
  public A withNewEventTime(String time) {
    return (A) this.withEventTime(new MicroTime(time));
  }
  
  public MetadataNested<A> withNewMetadata() {
    return new MetadataNested(null);
  }
  
  public MetadataNested<A> withNewMetadataLike(ObjectMeta item) {
    return new MetadataNested(item);
  }
  
  public RegardingNested<A> withNewRegarding() {
    return new RegardingNested(null);
  }
  
  public RegardingNested<A> withNewRegardingLike(ObjectReference item) {
    return new RegardingNested(item);
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
  
  public A withNote(String note) {
    this.note = note;
    return (A) this;
  }
  
  public A withReason(String reason) {
    this.reason = reason;
    return (A) this;
  }
  
  public A withRegarding(ObjectReference regarding) {
    this._visitables.remove("regarding");
    if (regarding != null) {
        this.regarding = new ObjectReferenceBuilder(regarding);
        this._visitables.get("regarding").add(this.regarding);
    } else {
        this.regarding = null;
        this._visitables.get("regarding").remove(this.regarding);
    }
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
  
  public A withReportingController(String reportingController) {
    this.reportingController = reportingController;
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
  
  public A withType(String type) {
    this.type = type;
    return (A) this;
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
  public class RegardingNested<N> extends ObjectReferenceFluent<RegardingNested<N>> implements Nested<N>{
  
    ObjectReferenceBuilder builder;
  
    RegardingNested(ObjectReference item) {
      this.builder = new ObjectReferenceBuilder(this, item);
    }
  
    public N and() {
      return (N) EventFluent.this.withRegarding(builder.build());
    }
    
    public N endRegarding() {
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
}