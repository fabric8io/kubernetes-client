package io.fabric8.kubernetes.api.model.flowcontrol.v1beta1;

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
public class LimitResponseFluent<A extends io.fabric8.kubernetes.api.model.flowcontrol.v1beta1.LimitResponseFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private QueuingConfigurationBuilder queuing;
  private String type;

  public LimitResponseFluent() {
  }
  
  public LimitResponseFluent(LimitResponse instance) {
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
  
  public QueuingConfiguration buildQueuing() {
    return this.queuing != null ? this.queuing.build() : null;
  }
  
  protected void copyInstance(LimitResponse instance) {
    instance = instance != null ? instance : new LimitResponse();
    if (instance != null) {
        this.withQueuing(instance.getQueuing());
        this.withType(instance.getType());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public QueuingNested<A> editOrNewQueuing() {
    return this.withNewQueuingLike(Optional.ofNullable(this.buildQueuing()).orElse(new QueuingConfigurationBuilder().build()));
  }
  
  public QueuingNested<A> editOrNewQueuingLike(QueuingConfiguration item) {
    return this.withNewQueuingLike(Optional.ofNullable(this.buildQueuing()).orElse(item));
  }
  
  public QueuingNested<A> editQueuing() {
    return this.withNewQueuingLike(Optional.ofNullable(this.buildQueuing()).orElse(null));
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
    LimitResponseFluent that = (LimitResponseFluent) o;
    if (!(Objects.equals(queuing, that.queuing))) {
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
  
  public Map<String,Object> getAdditionalProperties() {
    return this.additionalProperties;
  }
  
  public String getType() {
    return this.type;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasQueuing() {
    return this.queuing != null;
  }
  
  public boolean hasType() {
    return this.type != null;
  }
  
  public int hashCode() {
    return Objects.hash(queuing, type, additionalProperties);
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
    if (!(queuing == null)) {
        sb.append("queuing:");
        sb.append(queuing);
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
  
  public <K,V>A withAdditionalProperties(Map<String,Object> additionalProperties) {
    if (additionalProperties == null) {
      this.additionalProperties = null;
    } else {
      this.additionalProperties = new LinkedHashMap(additionalProperties);
    }
    return (A) this;
  }
  
  public QueuingNested<A> withNewQueuing() {
    return new QueuingNested(null);
  }
  
  public A withNewQueuing(Integer handSize,Integer queueLengthLimit,Integer queues) {
    return (A) this.withQueuing(new QueuingConfiguration(handSize, queueLengthLimit, queues));
  }
  
  public QueuingNested<A> withNewQueuingLike(QueuingConfiguration item) {
    return new QueuingNested(item);
  }
  
  public A withQueuing(QueuingConfiguration queuing) {
    this._visitables.remove("queuing");
    if (queuing != null) {
        this.queuing = new QueuingConfigurationBuilder(queuing);
        this._visitables.get("queuing").add(this.queuing);
    } else {
        this.queuing = null;
        this._visitables.get("queuing").remove(this.queuing);
    }
    return (A) this;
  }
  
  public A withType(String type) {
    this.type = type;
    return (A) this;
  }
  public class QueuingNested<N> extends QueuingConfigurationFluent<QueuingNested<N>> implements Nested<N>{
  
    QueuingConfigurationBuilder builder;
  
    QueuingNested(QueuingConfiguration item) {
      this.builder = new QueuingConfigurationBuilder(this, item);
    }
  
    public N and() {
      return (N) LimitResponseFluent.this.withQueuing(builder.build());
    }
    
    public N endQueuing() {
      return and();
    }
    
  }
}