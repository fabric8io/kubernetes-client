package io.fabric8.knative.sources.v1beta2;

import io.fabric8.knative.duck.v1.CloudEventOverrides;
import io.fabric8.knative.duck.v1.CloudEventOverridesBuilder;
import io.fabric8.knative.duck.v1.CloudEventOverridesFluent;
import io.fabric8.knative.duck.v1.Destination;
import io.fabric8.knative.duck.v1.DestinationBuilder;
import io.fabric8.knative.duck.v1.DestinationFluent;
import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
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
public class PingSourceSpecFluent<A extends io.fabric8.knative.sources.v1beta2.PingSourceSpecFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private CloudEventOverridesBuilder ceOverrides;
  private String contentType;
  private String data;
  private String dataBase64;
  private String schedule;
  private DestinationBuilder sink;
  private String timezone;

  public PingSourceSpecFluent() {
  }
  
  public PingSourceSpecFluent(PingSourceSpec instance) {
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
  
  public CloudEventOverrides buildCeOverrides() {
    return this.ceOverrides != null ? this.ceOverrides.build() : null;
  }
  
  public Destination buildSink() {
    return this.sink != null ? this.sink.build() : null;
  }
  
  protected void copyInstance(PingSourceSpec instance) {
    instance = instance != null ? instance : new PingSourceSpec();
    if (instance != null) {
        this.withCeOverrides(instance.getCeOverrides());
        this.withContentType(instance.getContentType());
        this.withData(instance.getData());
        this.withDataBase64(instance.getDataBase64());
        this.withSchedule(instance.getSchedule());
        this.withSink(instance.getSink());
        this.withTimezone(instance.getTimezone());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public CeOverridesNested<A> editCeOverrides() {
    return this.withNewCeOverridesLike(Optional.ofNullable(this.buildCeOverrides()).orElse(null));
  }
  
  public CeOverridesNested<A> editOrNewCeOverrides() {
    return this.withNewCeOverridesLike(Optional.ofNullable(this.buildCeOverrides()).orElse(new CloudEventOverridesBuilder().build()));
  }
  
  public CeOverridesNested<A> editOrNewCeOverridesLike(CloudEventOverrides item) {
    return this.withNewCeOverridesLike(Optional.ofNullable(this.buildCeOverrides()).orElse(item));
  }
  
  public SinkNested<A> editOrNewSink() {
    return this.withNewSinkLike(Optional.ofNullable(this.buildSink()).orElse(new DestinationBuilder().build()));
  }
  
  public SinkNested<A> editOrNewSinkLike(Destination item) {
    return this.withNewSinkLike(Optional.ofNullable(this.buildSink()).orElse(item));
  }
  
  public SinkNested<A> editSink() {
    return this.withNewSinkLike(Optional.ofNullable(this.buildSink()).orElse(null));
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
    PingSourceSpecFluent that = (PingSourceSpecFluent) o;
    if (!(Objects.equals(ceOverrides, that.ceOverrides))) {
      return false;
    }
    if (!(Objects.equals(contentType, that.contentType))) {
      return false;
    }
    if (!(Objects.equals(data, that.data))) {
      return false;
    }
    if (!(Objects.equals(dataBase64, that.dataBase64))) {
      return false;
    }
    if (!(Objects.equals(schedule, that.schedule))) {
      return false;
    }
    if (!(Objects.equals(sink, that.sink))) {
      return false;
    }
    if (!(Objects.equals(timezone, that.timezone))) {
      return false;
    }
    if (!(Objects.equals(additionalProperties, that.additionalProperties))) {
      return false;
    }
    return true;
  }
  
  public Map<String,Object> getAdditionalProperties() {
    return this.additionalProperties;
  }
  
  public String getContentType() {
    return this.contentType;
  }
  
  public String getData() {
    return this.data;
  }
  
  public String getDataBase64() {
    return this.dataBase64;
  }
  
  public String getSchedule() {
    return this.schedule;
  }
  
  public String getTimezone() {
    return this.timezone;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasCeOverrides() {
    return this.ceOverrides != null;
  }
  
  public boolean hasContentType() {
    return this.contentType != null;
  }
  
  public boolean hasData() {
    return this.data != null;
  }
  
  public boolean hasDataBase64() {
    return this.dataBase64 != null;
  }
  
  public boolean hasSchedule() {
    return this.schedule != null;
  }
  
  public boolean hasSink() {
    return this.sink != null;
  }
  
  public boolean hasTimezone() {
    return this.timezone != null;
  }
  
  public int hashCode() {
    return Objects.hash(ceOverrides, contentType, data, dataBase64, schedule, sink, timezone, additionalProperties);
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
    if (!(ceOverrides == null)) {
        sb.append("ceOverrides:");
        sb.append(ceOverrides);
        sb.append(",");
    }
    if (!(contentType == null)) {
        sb.append("contentType:");
        sb.append(contentType);
        sb.append(",");
    }
    if (!(data == null)) {
        sb.append("data:");
        sb.append(data);
        sb.append(",");
    }
    if (!(dataBase64 == null)) {
        sb.append("dataBase64:");
        sb.append(dataBase64);
        sb.append(",");
    }
    if (!(schedule == null)) {
        sb.append("schedule:");
        sb.append(schedule);
        sb.append(",");
    }
    if (!(sink == null)) {
        sb.append("sink:");
        sb.append(sink);
        sb.append(",");
    }
    if (!(timezone == null)) {
        sb.append("timezone:");
        sb.append(timezone);
        sb.append(",");
    }
    if (!(additionalProperties == null) && !(additionalProperties.isEmpty())) {
        sb.append("additionalProperties:");
        sb.append(additionalProperties);
    }
    sb.append("}");
    return sb.toString();
  }
  
  public <K,V>A withAdditionalProperties(Map<String,Object> additionalProperties) {
    if (additionalProperties == null) {
      this.additionalProperties = null;
    } else {
      this.additionalProperties = new LinkedHashMap(additionalProperties);
    }
    return (A) this;
  }
  
  public A withCeOverrides(CloudEventOverrides ceOverrides) {
    this._visitables.remove("ceOverrides");
    if (ceOverrides != null) {
        this.ceOverrides = new CloudEventOverridesBuilder(ceOverrides);
        this._visitables.get("ceOverrides").add(this.ceOverrides);
    } else {
        this.ceOverrides = null;
        this._visitables.get("ceOverrides").remove(this.ceOverrides);
    }
    return (A) this;
  }
  
  public A withContentType(String contentType) {
    this.contentType = contentType;
    return (A) this;
  }
  
  public A withData(String data) {
    this.data = data;
    return (A) this;
  }
  
  public A withDataBase64(String dataBase64) {
    this.dataBase64 = dataBase64;
    return (A) this;
  }
  
  public CeOverridesNested<A> withNewCeOverrides() {
    return new CeOverridesNested(null);
  }
  
  public CeOverridesNested<A> withNewCeOverridesLike(CloudEventOverrides item) {
    return new CeOverridesNested(item);
  }
  
  public SinkNested<A> withNewSink() {
    return new SinkNested(null);
  }
  
  public SinkNested<A> withNewSinkLike(Destination item) {
    return new SinkNested(item);
  }
  
  public A withSchedule(String schedule) {
    this.schedule = schedule;
    return (A) this;
  }
  
  public A withSink(Destination sink) {
    this._visitables.remove("sink");
    if (sink != null) {
        this.sink = new DestinationBuilder(sink);
        this._visitables.get("sink").add(this.sink);
    } else {
        this.sink = null;
        this._visitables.get("sink").remove(this.sink);
    }
    return (A) this;
  }
  
  public A withTimezone(String timezone) {
    this.timezone = timezone;
    return (A) this;
  }
  public class CeOverridesNested<N> extends CloudEventOverridesFluent<CeOverridesNested<N>> implements Nested<N>{
  
    CloudEventOverridesBuilder builder;
  
    CeOverridesNested(CloudEventOverrides item) {
      this.builder = new CloudEventOverridesBuilder(this, item);
    }
  
    public N and() {
      return (N) PingSourceSpecFluent.this.withCeOverrides(builder.build());
    }
    
    public N endCeOverrides() {
      return and();
    }
    
  }
  public class SinkNested<N> extends DestinationFluent<SinkNested<N>> implements Nested<N>{
  
    DestinationBuilder builder;
  
    SinkNested(Destination item) {
      this.builder = new DestinationBuilder(this, item);
    }
  
    public N and() {
      return (N) PingSourceSpecFluent.this.withSink(builder.build());
    }
    
    public N endSink() {
      return and();
    }
    
  }
}