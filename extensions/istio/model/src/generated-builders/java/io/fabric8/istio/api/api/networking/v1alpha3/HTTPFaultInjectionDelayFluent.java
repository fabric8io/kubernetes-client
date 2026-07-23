package io.fabric8.istio.api.api.networking.v1alpha3;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Double;
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
public class HTTPFaultInjectionDelayFluent<A extends io.fabric8.istio.api.api.networking.v1alpha3.HTTPFaultInjectionDelayFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private VisitableBuilder<? extends IsHTTPFaultInjectionDelayHttpDelayType,?> httpDelayType;
  private Integer percent;
  private PercentBuilder percentage;

  public HTTPFaultInjectionDelayFluent() {
  }
  
  public HTTPFaultInjectionDelayFluent(HTTPFaultInjectionDelay instance) {
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
  
  public IsHTTPFaultInjectionDelayHttpDelayType buildHttpDelayType() {
    return this.httpDelayType != null ? this.httpDelayType.build() : null;
  }
  
  public Percent buildPercentage() {
    return this.percentage != null ? this.percentage.build() : null;
  }
  
  protected static <T>VisitableBuilder<T,?> builder(Object item) {
    switch (item.getClass().getName()) {
      case "HTTPFaultInjectionDelayExponentialDelay":
    
          return (VisitableBuilder<T,?>) new HTTPFaultInjectionDelayExponentialDelayBuilder((HTTPFaultInjectionDelayExponentialDelay) item);
    
      case "HTTPFaultInjectionDelayFixedDelay":
    
          return (VisitableBuilder<T,?>) new HTTPFaultInjectionDelayFixedDelayBuilder((HTTPFaultInjectionDelayFixedDelay) item);
    
      default:
    
          return (VisitableBuilder<T,?>) builderOf(item);
    
    }
  }
  
  protected void copyInstance(HTTPFaultInjectionDelay instance) {
    instance = instance != null ? instance : new HTTPFaultInjectionDelay();
    if (instance != null) {
        this.withHttpDelayType(instance.getHttpDelayType());
        this.withPercent(instance.getPercent());
        this.withPercentage(instance.getPercentage());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public PercentageNested<A> editOrNewPercentage() {
    return this.withNewPercentageLike(Optional.ofNullable(this.buildPercentage()).orElse(new PercentBuilder().build()));
  }
  
  public PercentageNested<A> editOrNewPercentageLike(Percent item) {
    return this.withNewPercentageLike(Optional.ofNullable(this.buildPercentage()).orElse(item));
  }
  
  public PercentageNested<A> editPercentage() {
    return this.withNewPercentageLike(Optional.ofNullable(this.buildPercentage()).orElse(null));
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
    HTTPFaultInjectionDelayFluent that = (HTTPFaultInjectionDelayFluent) o;
    if (!(Objects.equals(httpDelayType, that.httpDelayType))) {
      return false;
    }
    if (!(Objects.equals(percent, that.percent))) {
      return false;
    }
    if (!(Objects.equals(percentage, that.percentage))) {
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
  
  public Integer getPercent() {
    return this.percent;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasHttpDelayType() {
    return this.httpDelayType != null;
  }
  
  public boolean hasPercent() {
    return this.percent != null;
  }
  
  public boolean hasPercentage() {
    return this.percentage != null;
  }
  
  public int hashCode() {
    return Objects.hash(httpDelayType, percent, percentage, additionalProperties);
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
    if (!(httpDelayType == null)) {
        sb.append("httpDelayType:");
        sb.append(httpDelayType);
        sb.append(",");
    }
    if (!(percent == null)) {
        sb.append("percent:");
        sb.append(percent);
        sb.append(",");
    }
    if (!(percentage == null)) {
        sb.append("percentage:");
        sb.append(percentage);
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
  
  public A withHttpDelayType(IsHTTPFaultInjectionDelayHttpDelayType httpDelayType) {
    if (httpDelayType == null) {
        this.httpDelayType = null;
        this._visitables.remove("httpDelayType");
        return (A) this;
    } else {
        VisitableBuilder<? extends IsHTTPFaultInjectionDelayHttpDelayType,?> builder = builder(httpDelayType);
        this._visitables.get("httpDelayType").clear();
        this._visitables.get("httpDelayType").add(builder);
        this.httpDelayType = builder;
        return (A) this;
    }
  }
  
  public HTTPFaultInjectionDelayExponentialDelayHttpTypeNested<A> withNewHTTPFaultInjectionDelayExponentialDelayHttpType() {
    return new HTTPFaultInjectionDelayExponentialDelayHttpTypeNested(null);
  }
  
  public A withNewHTTPFaultInjectionDelayExponentialDelayHttpType(String exponentialDelay) {
    return (A) this.withHttpDelayType(new HTTPFaultInjectionDelayExponentialDelay(exponentialDelay));
  }
  
  public HTTPFaultInjectionDelayExponentialDelayHttpTypeNested<A> withNewHTTPFaultInjectionDelayExponentialDelayHttpTypeLike(HTTPFaultInjectionDelayExponentialDelay item) {
    return new HTTPFaultInjectionDelayExponentialDelayHttpTypeNested(item);
  }
  
  public HTTPFaultInjectionDelayFixedDelayHttpTypeNested<A> withNewHTTPFaultInjectionDelayFixedDelayHttpType() {
    return new HTTPFaultInjectionDelayFixedDelayHttpTypeNested(null);
  }
  
  public A withNewHTTPFaultInjectionDelayFixedDelayHttpType(String fixedDelay) {
    return (A) this.withHttpDelayType(new HTTPFaultInjectionDelayFixedDelay(fixedDelay));
  }
  
  public HTTPFaultInjectionDelayFixedDelayHttpTypeNested<A> withNewHTTPFaultInjectionDelayFixedDelayHttpTypeLike(HTTPFaultInjectionDelayFixedDelay item) {
    return new HTTPFaultInjectionDelayFixedDelayHttpTypeNested(item);
  }
  
  public PercentageNested<A> withNewPercentage() {
    return new PercentageNested(null);
  }
  
  public A withNewPercentage(Double value) {
    return (A) this.withPercentage(new Percent(value));
  }
  
  public PercentageNested<A> withNewPercentageLike(Percent item) {
    return new PercentageNested(item);
  }
  
  public A withPercent(Integer percent) {
    this.percent = percent;
    return (A) this;
  }
  
  public A withPercentage(Percent percentage) {
    this._visitables.remove("percentage");
    if (percentage != null) {
        this.percentage = new PercentBuilder(percentage);
        this._visitables.get("percentage").add(this.percentage);
    } else {
        this.percentage = null;
        this._visitables.get("percentage").remove(this.percentage);
    }
    return (A) this;
  }
  public class HTTPFaultInjectionDelayExponentialDelayHttpTypeNested<N> extends HTTPFaultInjectionDelayExponentialDelayFluent<HTTPFaultInjectionDelayExponentialDelayHttpTypeNested<N>> implements Nested<N>{
  
    HTTPFaultInjectionDelayExponentialDelayBuilder builder;
  
    HTTPFaultInjectionDelayExponentialDelayHttpTypeNested(HTTPFaultInjectionDelayExponentialDelay item) {
      this.builder = new HTTPFaultInjectionDelayExponentialDelayBuilder(this, item);
    }
  
    public N and() {
      return (N) HTTPFaultInjectionDelayFluent.this.withHttpDelayType(builder.build());
    }
    
    public N endHTTPFaultInjectionDelayExponentialDelayHttpType() {
      return and();
    }
    
  }
  public class HTTPFaultInjectionDelayFixedDelayHttpTypeNested<N> extends HTTPFaultInjectionDelayFixedDelayFluent<HTTPFaultInjectionDelayFixedDelayHttpTypeNested<N>> implements Nested<N>{
  
    HTTPFaultInjectionDelayFixedDelayBuilder builder;
  
    HTTPFaultInjectionDelayFixedDelayHttpTypeNested(HTTPFaultInjectionDelayFixedDelay item) {
      this.builder = new HTTPFaultInjectionDelayFixedDelayBuilder(this, item);
    }
  
    public N and() {
      return (N) HTTPFaultInjectionDelayFluent.this.withHttpDelayType(builder.build());
    }
    
    public N endHTTPFaultInjectionDelayFixedDelayHttpType() {
      return and();
    }
    
  }
  public class PercentageNested<N> extends PercentFluent<PercentageNested<N>> implements Nested<N>{
  
    PercentBuilder builder;
  
    PercentageNested(Percent item) {
      this.builder = new PercentBuilder(this, item);
    }
  
    public N and() {
      return (N) HTTPFaultInjectionDelayFluent.this.withPercentage(builder.build());
    }
    
    public N endPercentage() {
      return and();
    }
    
  }
}