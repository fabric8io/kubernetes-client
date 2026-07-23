package io.fabric8.openclustermanagement.api.model.observability.v1beta2;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import java.lang.Boolean;
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
public class OpenTelemetryCollectionSpecFluent<A extends io.fabric8.openclustermanagement.api.model.observability.v1beta2.OpenTelemetryCollectionSpecFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private OpenTelemetryCollectorSpecBuilder collector;
  private InstrumentationSpecBuilder instrumentation;

  public OpenTelemetryCollectionSpecFluent() {
  }
  
  public OpenTelemetryCollectionSpecFluent(OpenTelemetryCollectionSpec instance) {
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
  
  public OpenTelemetryCollectorSpec buildCollector() {
    return this.collector != null ? this.collector.build() : null;
  }
  
  public InstrumentationSpec buildInstrumentation() {
    return this.instrumentation != null ? this.instrumentation.build() : null;
  }
  
  protected void copyInstance(OpenTelemetryCollectionSpec instance) {
    instance = instance != null ? instance : new OpenTelemetryCollectionSpec();
    if (instance != null) {
        this.withCollector(instance.getCollector());
        this.withInstrumentation(instance.getInstrumentation());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public CollectorNested<A> editCollector() {
    return this.withNewCollectorLike(Optional.ofNullable(this.buildCollector()).orElse(null));
  }
  
  public InstrumentationNested<A> editInstrumentation() {
    return this.withNewInstrumentationLike(Optional.ofNullable(this.buildInstrumentation()).orElse(null));
  }
  
  public CollectorNested<A> editOrNewCollector() {
    return this.withNewCollectorLike(Optional.ofNullable(this.buildCollector()).orElse(new OpenTelemetryCollectorSpecBuilder().build()));
  }
  
  public CollectorNested<A> editOrNewCollectorLike(OpenTelemetryCollectorSpec item) {
    return this.withNewCollectorLike(Optional.ofNullable(this.buildCollector()).orElse(item));
  }
  
  public InstrumentationNested<A> editOrNewInstrumentation() {
    return this.withNewInstrumentationLike(Optional.ofNullable(this.buildInstrumentation()).orElse(new InstrumentationSpecBuilder().build()));
  }
  
  public InstrumentationNested<A> editOrNewInstrumentationLike(InstrumentationSpec item) {
    return this.withNewInstrumentationLike(Optional.ofNullable(this.buildInstrumentation()).orElse(item));
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
    OpenTelemetryCollectionSpecFluent that = (OpenTelemetryCollectionSpecFluent) o;
    if (!(Objects.equals(collector, that.collector))) {
      return false;
    }
    if (!(Objects.equals(instrumentation, that.instrumentation))) {
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
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasCollector() {
    return this.collector != null;
  }
  
  public boolean hasInstrumentation() {
    return this.instrumentation != null;
  }
  
  public int hashCode() {
    return Objects.hash(collector, instrumentation, additionalProperties);
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
    if (!(collector == null)) {
        sb.append("collector:");
        sb.append(collector);
        sb.append(",");
    }
    if (!(instrumentation == null)) {
        sb.append("instrumentation:");
        sb.append(instrumentation);
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
  
  public A withCollector(OpenTelemetryCollectorSpec collector) {
    this._visitables.remove("collector");
    if (collector != null) {
        this.collector = new OpenTelemetryCollectorSpecBuilder(collector);
        this._visitables.get("collector").add(this.collector);
    } else {
        this.collector = null;
        this._visitables.get("collector").remove(this.collector);
    }
    return (A) this;
  }
  
  public A withInstrumentation(InstrumentationSpec instrumentation) {
    this._visitables.remove("instrumentation");
    if (instrumentation != null) {
        this.instrumentation = new InstrumentationSpecBuilder(instrumentation);
        this._visitables.get("instrumentation").add(this.instrumentation);
    } else {
        this.instrumentation = null;
        this._visitables.get("instrumentation").remove(this.instrumentation);
    }
    return (A) this;
  }
  
  public CollectorNested<A> withNewCollector() {
    return new CollectorNested(null);
  }
  
  public A withNewCollector(Boolean enabled) {
    return (A) this.withCollector(new OpenTelemetryCollectorSpec(enabled));
  }
  
  public CollectorNested<A> withNewCollectorLike(OpenTelemetryCollectorSpec item) {
    return new CollectorNested(item);
  }
  
  public InstrumentationNested<A> withNewInstrumentation() {
    return new InstrumentationNested(null);
  }
  
  public A withNewInstrumentation(Boolean enabled) {
    return (A) this.withInstrumentation(new InstrumentationSpec(enabled));
  }
  
  public InstrumentationNested<A> withNewInstrumentationLike(InstrumentationSpec item) {
    return new InstrumentationNested(item);
  }
  public class CollectorNested<N> extends OpenTelemetryCollectorSpecFluent<CollectorNested<N>> implements Nested<N>{
  
    OpenTelemetryCollectorSpecBuilder builder;
  
    CollectorNested(OpenTelemetryCollectorSpec item) {
      this.builder = new OpenTelemetryCollectorSpecBuilder(this, item);
    }
  
    public N and() {
      return (N) OpenTelemetryCollectionSpecFluent.this.withCollector(builder.build());
    }
    
    public N endCollector() {
      return and();
    }
    
  }
  public class InstrumentationNested<N> extends InstrumentationSpecFluent<InstrumentationNested<N>> implements Nested<N>{
  
    InstrumentationSpecBuilder builder;
  
    InstrumentationNested(InstrumentationSpec item) {
      this.builder = new InstrumentationSpecBuilder(this, item);
    }
  
    public N and() {
      return (N) OpenTelemetryCollectionSpecFluent.this.withInstrumentation(builder.build());
    }
    
    public N endInstrumentation() {
      return and();
    }
    
  }
}