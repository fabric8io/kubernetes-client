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
public class HTTPFaultInjectionAbortFluent<A extends io.fabric8.istio.api.api.networking.v1alpha3.HTTPFaultInjectionAbortFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private VisitableBuilder<? extends IsHTTPFaultInjectionAbortErrorType,?> errorType;
  private PercentBuilder percentage;

  public HTTPFaultInjectionAbortFluent() {
  }
  
  public HTTPFaultInjectionAbortFluent(HTTPFaultInjectionAbort instance) {
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
  
  public IsHTTPFaultInjectionAbortErrorType buildErrorType() {
    return this.errorType != null ? this.errorType.build() : null;
  }
  
  public Percent buildPercentage() {
    return this.percentage != null ? this.percentage.build() : null;
  }
  
  protected static <T>VisitableBuilder<T,?> builder(Object item) {
    switch (item.getClass().getName()) {
      case "HTTPFaultInjectionAbortGrpcStatus":
    
          return (VisitableBuilder<T,?>) new HTTPFaultInjectionAbortGrpcStatusBuilder((HTTPFaultInjectionAbortGrpcStatus) item);
    
      case "HTTPFaultInjectionAbortHttpStatus":
    
          return (VisitableBuilder<T,?>) new HTTPFaultInjectionAbortHttpStatusBuilder((HTTPFaultInjectionAbortHttpStatus) item);
    
      case "HTTPFaultInjectionAbortHttp2Error":
    
          return (VisitableBuilder<T,?>) new HTTPFaultInjectionAbortHttp2ErrorBuilder((HTTPFaultInjectionAbortHttp2Error) item);
    
      default:
    
          return (VisitableBuilder<T,?>) builderOf(item);
    
    }
  }
  
  protected void copyInstance(HTTPFaultInjectionAbort instance) {
    instance = instance != null ? instance : new HTTPFaultInjectionAbort();
    if (instance != null) {
        this.withErrorType(instance.getErrorType());
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
    HTTPFaultInjectionAbortFluent that = (HTTPFaultInjectionAbortFluent) o;
    if (!(Objects.equals(errorType, that.errorType))) {
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
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasErrorType() {
    return this.errorType != null;
  }
  
  public boolean hasPercentage() {
    return this.percentage != null;
  }
  
  public int hashCode() {
    return Objects.hash(errorType, percentage, additionalProperties);
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
    if (!(errorType == null)) {
        sb.append("errorType:");
        sb.append(errorType);
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
  
  public A withErrorType(IsHTTPFaultInjectionAbortErrorType errorType) {
    if (errorType == null) {
        this.errorType = null;
        this._visitables.remove("errorType");
        return (A) this;
    } else {
        VisitableBuilder<? extends IsHTTPFaultInjectionAbortErrorType,?> builder = builder(errorType);
        this._visitables.get("errorType").clear();
        this._visitables.get("errorType").add(builder);
        this.errorType = builder;
        return (A) this;
    }
  }
  
  public HTTPFaultInjectionAbortGrpcStatusErrorTypeNested<A> withNewHTTPFaultInjectionAbortGrpcStatusErrorType() {
    return new HTTPFaultInjectionAbortGrpcStatusErrorTypeNested(null);
  }
  
  public A withNewHTTPFaultInjectionAbortGrpcStatusErrorType(String grpcStatus) {
    return (A) this.withErrorType(new HTTPFaultInjectionAbortGrpcStatus(grpcStatus));
  }
  
  public HTTPFaultInjectionAbortGrpcStatusErrorTypeNested<A> withNewHTTPFaultInjectionAbortGrpcStatusErrorTypeLike(HTTPFaultInjectionAbortGrpcStatus item) {
    return new HTTPFaultInjectionAbortGrpcStatusErrorTypeNested(item);
  }
  
  public HTTPFaultInjectionAbortHttp2ErrorTypeNested<A> withNewHTTPFaultInjectionAbortHttp2ErrorType() {
    return new HTTPFaultInjectionAbortHttp2ErrorTypeNested(null);
  }
  
  public A withNewHTTPFaultInjectionAbortHttp2ErrorType(String http2Error) {
    return (A) this.withErrorType(new HTTPFaultInjectionAbortHttp2Error(http2Error));
  }
  
  public HTTPFaultInjectionAbortHttp2ErrorTypeNested<A> withNewHTTPFaultInjectionAbortHttp2ErrorTypeLike(HTTPFaultInjectionAbortHttp2Error item) {
    return new HTTPFaultInjectionAbortHttp2ErrorTypeNested(item);
  }
  
  public HTTPFaultInjectionAbortHttpStatusErrorTypeNested<A> withNewHTTPFaultInjectionAbortHttpStatusErrorType() {
    return new HTTPFaultInjectionAbortHttpStatusErrorTypeNested(null);
  }
  
  public A withNewHTTPFaultInjectionAbortHttpStatusErrorType(Integer httpStatus) {
    return (A) this.withErrorType(new HTTPFaultInjectionAbortHttpStatus(httpStatus));
  }
  
  public HTTPFaultInjectionAbortHttpStatusErrorTypeNested<A> withNewHTTPFaultInjectionAbortHttpStatusErrorTypeLike(HTTPFaultInjectionAbortHttpStatus item) {
    return new HTTPFaultInjectionAbortHttpStatusErrorTypeNested(item);
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
  public class HTTPFaultInjectionAbortGrpcStatusErrorTypeNested<N> extends HTTPFaultInjectionAbortGrpcStatusFluent<HTTPFaultInjectionAbortGrpcStatusErrorTypeNested<N>> implements Nested<N>{
  
    HTTPFaultInjectionAbortGrpcStatusBuilder builder;
  
    HTTPFaultInjectionAbortGrpcStatusErrorTypeNested(HTTPFaultInjectionAbortGrpcStatus item) {
      this.builder = new HTTPFaultInjectionAbortGrpcStatusBuilder(this, item);
    }
  
    public N and() {
      return (N) HTTPFaultInjectionAbortFluent.this.withErrorType(builder.build());
    }
    
    public N endHTTPFaultInjectionAbortGrpcStatusErrorType() {
      return and();
    }
    
  }
  public class HTTPFaultInjectionAbortHttp2ErrorTypeNested<N> extends HTTPFaultInjectionAbortHttp2ErrorFluent<HTTPFaultInjectionAbortHttp2ErrorTypeNested<N>> implements Nested<N>{
  
    HTTPFaultInjectionAbortHttp2ErrorBuilder builder;
  
    HTTPFaultInjectionAbortHttp2ErrorTypeNested(HTTPFaultInjectionAbortHttp2Error item) {
      this.builder = new HTTPFaultInjectionAbortHttp2ErrorBuilder(this, item);
    }
  
    public N and() {
      return (N) HTTPFaultInjectionAbortFluent.this.withErrorType(builder.build());
    }
    
    public N endHTTPFaultInjectionAbortHttp2ErrorType() {
      return and();
    }
    
  }
  public class HTTPFaultInjectionAbortHttpStatusErrorTypeNested<N> extends HTTPFaultInjectionAbortHttpStatusFluent<HTTPFaultInjectionAbortHttpStatusErrorTypeNested<N>> implements Nested<N>{
  
    HTTPFaultInjectionAbortHttpStatusBuilder builder;
  
    HTTPFaultInjectionAbortHttpStatusErrorTypeNested(HTTPFaultInjectionAbortHttpStatus item) {
      this.builder = new HTTPFaultInjectionAbortHttpStatusBuilder(this, item);
    }
  
    public N and() {
      return (N) HTTPFaultInjectionAbortFluent.this.withErrorType(builder.build());
    }
    
    public N endHTTPFaultInjectionAbortHttpStatusErrorType() {
      return and();
    }
    
  }
  public class PercentageNested<N> extends PercentFluent<PercentageNested<N>> implements Nested<N>{
  
    PercentBuilder builder;
  
    PercentageNested(Percent item) {
      this.builder = new PercentBuilder(this, item);
    }
  
    public N and() {
      return (N) HTTPFaultInjectionAbortFluent.this.withPercentage(builder.build());
    }
    
    public N endPercentage() {
      return and();
    }
    
  }
}