package io.fabric8.tekton.v1beta1;

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
public class CloudEventDeliveryFluent<A extends io.fabric8.tekton.v1beta1.CloudEventDeliveryFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private CloudEventDeliveryStateBuilder status;
  private String target;

  public CloudEventDeliveryFluent() {
  }
  
  public CloudEventDeliveryFluent(CloudEventDelivery instance) {
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
  
  public CloudEventDeliveryState buildStatus() {
    return this.status != null ? this.status.build() : null;
  }
  
  protected void copyInstance(CloudEventDelivery instance) {
    instance = instance != null ? instance : new CloudEventDelivery();
    if (instance != null) {
        this.withStatus(instance.getStatus());
        this.withTarget(instance.getTarget());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public StatusNested<A> editOrNewStatus() {
    return this.withNewStatusLike(Optional.ofNullable(this.buildStatus()).orElse(new CloudEventDeliveryStateBuilder().build()));
  }
  
  public StatusNested<A> editOrNewStatusLike(CloudEventDeliveryState item) {
    return this.withNewStatusLike(Optional.ofNullable(this.buildStatus()).orElse(item));
  }
  
  public StatusNested<A> editStatus() {
    return this.withNewStatusLike(Optional.ofNullable(this.buildStatus()).orElse(null));
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
    CloudEventDeliveryFluent that = (CloudEventDeliveryFluent) o;
    if (!(Objects.equals(status, that.status))) {
      return false;
    }
    if (!(Objects.equals(target, that.target))) {
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
  
  public String getTarget() {
    return this.target;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasStatus() {
    return this.status != null;
  }
  
  public boolean hasTarget() {
    return this.target != null;
  }
  
  public int hashCode() {
    return Objects.hash(status, target, additionalProperties);
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
    if (!(status == null)) {
        sb.append("status:");
        sb.append(status);
        sb.append(",");
    }
    if (!(target == null)) {
        sb.append("target:");
        sb.append(target);
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
  
  public StatusNested<A> withNewStatus() {
    return new StatusNested(null);
  }
  
  public A withNewStatus(String condition,String message,Integer retryCount,String sentAt) {
    return (A) this.withStatus(new CloudEventDeliveryState(condition, message, retryCount, sentAt));
  }
  
  public StatusNested<A> withNewStatusLike(CloudEventDeliveryState item) {
    return new StatusNested(item);
  }
  
  public A withStatus(CloudEventDeliveryState status) {
    this._visitables.remove("status");
    if (status != null) {
        this.status = new CloudEventDeliveryStateBuilder(status);
        this._visitables.get("status").add(this.status);
    } else {
        this.status = null;
        this._visitables.get("status").remove(this.status);
    }
    return (A) this;
  }
  
  public A withTarget(String target) {
    this.target = target;
    return (A) this;
  }
  public class StatusNested<N> extends CloudEventDeliveryStateFluent<StatusNested<N>> implements Nested<N>{
  
    CloudEventDeliveryStateBuilder builder;
  
    StatusNested(CloudEventDeliveryState item) {
      this.builder = new CloudEventDeliveryStateBuilder(this, item);
    }
  
    public N and() {
      return (N) CloudEventDeliveryFluent.this.withStatus(builder.build());
    }
    
    public N endStatus() {
      return and();
    }
    
  }
}