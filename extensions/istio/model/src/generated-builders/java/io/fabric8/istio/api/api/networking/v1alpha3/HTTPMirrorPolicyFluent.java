package io.fabric8.istio.api.api.networking.v1alpha3;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import java.lang.Double;
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
public class HTTPMirrorPolicyFluent<A extends io.fabric8.istio.api.api.networking.v1alpha3.HTTPMirrorPolicyFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private DestinationBuilder destination;
  private PercentBuilder percentage;

  public HTTPMirrorPolicyFluent() {
  }
  
  public HTTPMirrorPolicyFluent(HTTPMirrorPolicy instance) {
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
  
  public Percent buildPercentage() {
    return this.percentage != null ? this.percentage.build() : null;
  }
  
  protected void copyInstance(HTTPMirrorPolicy instance) {
    instance = instance != null ? instance : new HTTPMirrorPolicy();
    if (instance != null) {
        this.withDestination(instance.getDestination());
        this.withPercentage(instance.getPercentage());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public DestinationNested<A> editDestination() {
    return this.withNewDestinationLike(Optional.ofNullable(this.buildDestination()).orElse(null));
  }
  
  public DestinationNested<A> editOrNewDestination() {
    return this.withNewDestinationLike(Optional.ofNullable(this.buildDestination()).orElse(new DestinationBuilder().build()));
  }
  
  public DestinationNested<A> editOrNewDestinationLike(Destination item) {
    return this.withNewDestinationLike(Optional.ofNullable(this.buildDestination()).orElse(item));
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
    HTTPMirrorPolicyFluent that = (HTTPMirrorPolicyFluent) o;
    if (!(Objects.equals(destination, that.destination))) {
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
  
  public boolean hasDestination() {
    return this.destination != null;
  }
  
  public boolean hasPercentage() {
    return this.percentage != null;
  }
  
  public int hashCode() {
    return Objects.hash(destination, percentage, additionalProperties);
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
  
  public DestinationNested<A> withNewDestination() {
    return new DestinationNested(null);
  }
  
  public DestinationNested<A> withNewDestinationLike(Destination item) {
    return new DestinationNested(item);
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
  public class DestinationNested<N> extends DestinationFluent<DestinationNested<N>> implements Nested<N>{
  
    DestinationBuilder builder;
  
    DestinationNested(Destination item) {
      this.builder = new DestinationBuilder(this, item);
    }
  
    public N and() {
      return (N) HTTPMirrorPolicyFluent.this.withDestination(builder.build());
    }
    
    public N endDestination() {
      return and();
    }
    
  }
  public class PercentageNested<N> extends PercentFluent<PercentageNested<N>> implements Nested<N>{
  
    PercentBuilder builder;
  
    PercentageNested(Percent item) {
      this.builder = new PercentBuilder(this, item);
    }
  
    public N and() {
      return (N) HTTPMirrorPolicyFluent.this.withPercentage(builder.build());
    }
    
    public N endPercentage() {
      return and();
    }
    
  }
}