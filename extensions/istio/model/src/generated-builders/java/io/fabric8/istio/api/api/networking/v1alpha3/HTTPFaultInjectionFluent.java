package io.fabric8.istio.api.api.networking.v1alpha3;

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
public class HTTPFaultInjectionFluent<A extends io.fabric8.istio.api.api.networking.v1alpha3.HTTPFaultInjectionFluent<A>> extends BaseFluent<A>{

  private HTTPFaultInjectionAbortBuilder abort;
  private Map<String,Object> additionalProperties;
  private HTTPFaultInjectionDelayBuilder delay;

  public HTTPFaultInjectionFluent() {
  }
  
  public HTTPFaultInjectionFluent(HTTPFaultInjection instance) {
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
  
  public HTTPFaultInjectionAbort buildAbort() {
    return this.abort != null ? this.abort.build() : null;
  }
  
  public HTTPFaultInjectionDelay buildDelay() {
    return this.delay != null ? this.delay.build() : null;
  }
  
  protected void copyInstance(HTTPFaultInjection instance) {
    instance = instance != null ? instance : new HTTPFaultInjection();
    if (instance != null) {
        this.withAbort(instance.getAbort());
        this.withDelay(instance.getDelay());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public AbortNested<A> editAbort() {
    return this.withNewAbortLike(Optional.ofNullable(this.buildAbort()).orElse(null));
  }
  
  public DelayNested<A> editDelay() {
    return this.withNewDelayLike(Optional.ofNullable(this.buildDelay()).orElse(null));
  }
  
  public AbortNested<A> editOrNewAbort() {
    return this.withNewAbortLike(Optional.ofNullable(this.buildAbort()).orElse(new HTTPFaultInjectionAbortBuilder().build()));
  }
  
  public AbortNested<A> editOrNewAbortLike(HTTPFaultInjectionAbort item) {
    return this.withNewAbortLike(Optional.ofNullable(this.buildAbort()).orElse(item));
  }
  
  public DelayNested<A> editOrNewDelay() {
    return this.withNewDelayLike(Optional.ofNullable(this.buildDelay()).orElse(new HTTPFaultInjectionDelayBuilder().build()));
  }
  
  public DelayNested<A> editOrNewDelayLike(HTTPFaultInjectionDelay item) {
    return this.withNewDelayLike(Optional.ofNullable(this.buildDelay()).orElse(item));
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
    HTTPFaultInjectionFluent that = (HTTPFaultInjectionFluent) o;
    if (!(Objects.equals(abort, that.abort))) {
      return false;
    }
    if (!(Objects.equals(delay, that.delay))) {
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
  
  public boolean hasAbort() {
    return this.abort != null;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasDelay() {
    return this.delay != null;
  }
  
  public int hashCode() {
    return Objects.hash(abort, delay, additionalProperties);
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
    if (!(abort == null)) {
        sb.append("abort:");
        sb.append(abort);
        sb.append(",");
    }
    if (!(delay == null)) {
        sb.append("delay:");
        sb.append(delay);
        sb.append(",");
    }
    if (!(additionalProperties == null) && !(additionalProperties.isEmpty())) {
        sb.append("additionalProperties:");
        sb.append(additionalProperties);
    }
    sb.append("}");
    return sb.toString();
  }
  
  public A withAbort(HTTPFaultInjectionAbort abort) {
    this._visitables.remove("abort");
    if (abort != null) {
        this.abort = new HTTPFaultInjectionAbortBuilder(abort);
        this._visitables.get("abort").add(this.abort);
    } else {
        this.abort = null;
        this._visitables.get("abort").remove(this.abort);
    }
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
  
  public A withDelay(HTTPFaultInjectionDelay delay) {
    this._visitables.remove("delay");
    if (delay != null) {
        this.delay = new HTTPFaultInjectionDelayBuilder(delay);
        this._visitables.get("delay").add(this.delay);
    } else {
        this.delay = null;
        this._visitables.get("delay").remove(this.delay);
    }
    return (A) this;
  }
  
  public AbortNested<A> withNewAbort() {
    return new AbortNested(null);
  }
  
  public AbortNested<A> withNewAbortLike(HTTPFaultInjectionAbort item) {
    return new AbortNested(item);
  }
  
  public DelayNested<A> withNewDelay() {
    return new DelayNested(null);
  }
  
  public DelayNested<A> withNewDelayLike(HTTPFaultInjectionDelay item) {
    return new DelayNested(item);
  }
  public class AbortNested<N> extends HTTPFaultInjectionAbortFluent<AbortNested<N>> implements Nested<N>{
  
    HTTPFaultInjectionAbortBuilder builder;
  
    AbortNested(HTTPFaultInjectionAbort item) {
      this.builder = new HTTPFaultInjectionAbortBuilder(this, item);
    }
  
    public N and() {
      return (N) HTTPFaultInjectionFluent.this.withAbort(builder.build());
    }
    
    public N endAbort() {
      return and();
    }
    
  }
  public class DelayNested<N> extends HTTPFaultInjectionDelayFluent<DelayNested<N>> implements Nested<N>{
  
    HTTPFaultInjectionDelayBuilder builder;
  
    DelayNested(HTTPFaultInjectionDelay item) {
      this.builder = new HTTPFaultInjectionDelayBuilder(this, item);
    }
  
    public N and() {
      return (N) HTTPFaultInjectionFluent.this.withDelay(builder.build());
    }
    
    public N endDelay() {
      return and();
    }
    
  }
}