package io.fabric8.istio.api.api.networking.v1alpha3;

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
public class HTTPRouteDestinationFluent<A extends io.fabric8.istio.api.api.networking.v1alpha3.HTTPRouteDestinationFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private DestinationBuilder destination;
  private HeadersBuilder headers;
  private Integer weight;

  public HTTPRouteDestinationFluent() {
  }
  
  public HTTPRouteDestinationFluent(HTTPRouteDestination instance) {
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
  
  public Destination buildDestination() {
    return this.destination != null ? this.destination.build() : null;
  }
  
  public Headers buildHeaders() {
    return this.headers != null ? this.headers.build() : null;
  }
  
  protected void copyInstance(HTTPRouteDestination instance) {
    instance = instance != null ? instance : new HTTPRouteDestination();
    if (instance != null) {
        this.withDestination(instance.getDestination());
        this.withHeaders(instance.getHeaders());
        this.withWeight(instance.getWeight());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public DestinationNested<A> editDestination() {
    return this.withNewDestinationLike(Optional.ofNullable(this.buildDestination()).orElse(null));
  }
  
  public HeadersNested<A> editHeaders() {
    return this.withNewHeadersLike(Optional.ofNullable(this.buildHeaders()).orElse(null));
  }
  
  public DestinationNested<A> editOrNewDestination() {
    return this.withNewDestinationLike(Optional.ofNullable(this.buildDestination()).orElse(new DestinationBuilder().build()));
  }
  
  public DestinationNested<A> editOrNewDestinationLike(Destination item) {
    return this.withNewDestinationLike(Optional.ofNullable(this.buildDestination()).orElse(item));
  }
  
  public HeadersNested<A> editOrNewHeaders() {
    return this.withNewHeadersLike(Optional.ofNullable(this.buildHeaders()).orElse(new HeadersBuilder().build()));
  }
  
  public HeadersNested<A> editOrNewHeadersLike(Headers item) {
    return this.withNewHeadersLike(Optional.ofNullable(this.buildHeaders()).orElse(item));
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
    HTTPRouteDestinationFluent that = (HTTPRouteDestinationFluent) o;
    if (!(Objects.equals(destination, that.destination))) {
      return false;
    }
    if (!(Objects.equals(headers, that.headers))) {
      return false;
    }
    if (!(Objects.equals(weight, that.weight))) {
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
  
  public Integer getWeight() {
    return this.weight;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasDestination() {
    return this.destination != null;
  }
  
  public boolean hasHeaders() {
    return this.headers != null;
  }
  
  public boolean hasWeight() {
    return this.weight != null;
  }
  
  public int hashCode() {
    return Objects.hash(destination, headers, weight, additionalProperties);
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
    if (!(destination == null)) {
        sb.append("destination:");
        sb.append(destination);
        sb.append(",");
    }
    if (!(headers == null)) {
        sb.append("headers:");
        sb.append(headers);
        sb.append(",");
    }
    if (!(weight == null)) {
        sb.append("weight:");
        sb.append(weight);
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
  
  public A withDestination(Destination destination) {
    this._visitables.remove("destination");
    if (destination != null) {
        this.destination = new DestinationBuilder(destination);
        this._visitables.get("destination").add(this.destination);
    } else {
        this.destination = null;
        this._visitables.get("destination").remove(this.destination);
    }
    return (A) this;
  }
  
  public A withHeaders(Headers headers) {
    this._visitables.remove("headers");
    if (headers != null) {
        this.headers = new HeadersBuilder(headers);
        this._visitables.get("headers").add(this.headers);
    } else {
        this.headers = null;
        this._visitables.get("headers").remove(this.headers);
    }
    return (A) this;
  }
  
  public DestinationNested<A> withNewDestination() {
    return new DestinationNested(null);
  }
  
  public DestinationNested<A> withNewDestinationLike(Destination item) {
    return new DestinationNested(item);
  }
  
  public HeadersNested<A> withNewHeaders() {
    return new HeadersNested(null);
  }
  
  public HeadersNested<A> withNewHeadersLike(Headers item) {
    return new HeadersNested(item);
  }
  
  public A withWeight(Integer weight) {
    this.weight = weight;
    return (A) this;
  }
  public class DestinationNested<N> extends DestinationFluent<DestinationNested<N>> implements Nested<N>{
  
    DestinationBuilder builder;
  
    DestinationNested(Destination item) {
      this.builder = new DestinationBuilder(this, item);
    }
  
    public N and() {
      return (N) HTTPRouteDestinationFluent.this.withDestination(builder.build());
    }
    
    public N endDestination() {
      return and();
    }
    
  }
  public class HeadersNested<N> extends HeadersFluent<HeadersNested<N>> implements Nested<N>{
  
    HeadersBuilder builder;
  
    HeadersNested(Headers item) {
      this.builder = new HeadersBuilder(this, item);
    }
  
    public N and() {
      return (N) HTTPRouteDestinationFluent.this.withHeaders(builder.build());
    }
    
    public N endHeaders() {
      return and();
    }
    
  }
}