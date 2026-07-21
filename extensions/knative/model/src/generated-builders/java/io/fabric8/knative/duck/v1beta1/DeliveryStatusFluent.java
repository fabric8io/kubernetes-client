package io.fabric8.knative.duck.v1beta1;

import io.fabric8.knative.duck.v1.KReference;
import io.fabric8.knative.duck.v1.KReferenceBuilder;
import io.fabric8.knative.duck.v1.KReferenceFluent;
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
public class DeliveryStatusFluent<A extends io.fabric8.knative.duck.v1beta1.DeliveryStatusFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private KReferenceBuilder deadLetterChannel;

  public DeliveryStatusFluent() {
  }
  
  public DeliveryStatusFluent(DeliveryStatus instance) {
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
  
  public KReference buildDeadLetterChannel() {
    return this.deadLetterChannel != null ? this.deadLetterChannel.build() : null;
  }
  
  protected void copyInstance(DeliveryStatus instance) {
    instance = instance != null ? instance : new DeliveryStatus();
    if (instance != null) {
        this.withDeadLetterChannel(instance.getDeadLetterChannel());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public DeadLetterChannelNested<A> editDeadLetterChannel() {
    return this.withNewDeadLetterChannelLike(Optional.ofNullable(this.buildDeadLetterChannel()).orElse(null));
  }
  
  public DeadLetterChannelNested<A> editOrNewDeadLetterChannel() {
    return this.withNewDeadLetterChannelLike(Optional.ofNullable(this.buildDeadLetterChannel()).orElse(new KReferenceBuilder().build()));
  }
  
  public DeadLetterChannelNested<A> editOrNewDeadLetterChannelLike(KReference item) {
    return this.withNewDeadLetterChannelLike(Optional.ofNullable(this.buildDeadLetterChannel()).orElse(item));
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
    DeliveryStatusFluent that = (DeliveryStatusFluent) o;
    if (!(Objects.equals(deadLetterChannel, that.deadLetterChannel))) {
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
  
  public boolean hasDeadLetterChannel() {
    return this.deadLetterChannel != null;
  }
  
  public int hashCode() {
    return Objects.hash(deadLetterChannel, additionalProperties);
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
    if (!(deadLetterChannel == null)) {
        sb.append("deadLetterChannel:");
        sb.append(deadLetterChannel);
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
  
  public A withDeadLetterChannel(KReference deadLetterChannel) {
    this._visitables.remove("deadLetterChannel");
    if (deadLetterChannel != null) {
        this.deadLetterChannel = new KReferenceBuilder(deadLetterChannel);
        this._visitables.get("deadLetterChannel").add(this.deadLetterChannel);
    } else {
        this.deadLetterChannel = null;
        this._visitables.get("deadLetterChannel").remove(this.deadLetterChannel);
    }
    return (A) this;
  }
  
  public DeadLetterChannelNested<A> withNewDeadLetterChannel() {
    return new DeadLetterChannelNested(null);
  }
  
  public DeadLetterChannelNested<A> withNewDeadLetterChannelLike(KReference item) {
    return new DeadLetterChannelNested(item);
  }
  public class DeadLetterChannelNested<N> extends KReferenceFluent<DeadLetterChannelNested<N>> implements Nested<N>{
  
    KReferenceBuilder builder;
  
    DeadLetterChannelNested(KReference item) {
      this.builder = new KReferenceBuilder(this, item);
    }
  
    public N and() {
      return (N) DeliveryStatusFluent.this.withDeadLetterChannel(builder.build());
    }
    
    public N endDeadLetterChannel() {
      return and();
    }
    
  }
}