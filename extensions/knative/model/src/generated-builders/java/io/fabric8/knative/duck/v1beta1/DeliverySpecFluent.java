package io.fabric8.knative.duck.v1beta1;

import io.fabric8.knative.duck.v1.Destination;
import io.fabric8.knative.duck.v1.DestinationBuilder;
import io.fabric8.knative.duck.v1.DestinationFluent;
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
public class DeliverySpecFluent<A extends io.fabric8.knative.duck.v1beta1.DeliverySpecFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String backoffDelay;
  private String backoffPolicy;
  private DestinationBuilder deadLetterSink;
  private Integer retry;
  private String timeout;

  public DeliverySpecFluent() {
  }
  
  public DeliverySpecFluent(DeliverySpec instance) {
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
  
  public Destination buildDeadLetterSink() {
    return this.deadLetterSink != null ? this.deadLetterSink.build() : null;
  }
  
  protected void copyInstance(DeliverySpec instance) {
    instance = instance != null ? instance : new DeliverySpec();
    if (instance != null) {
        this.withBackoffDelay(instance.getBackoffDelay());
        this.withBackoffPolicy(instance.getBackoffPolicy());
        this.withDeadLetterSink(instance.getDeadLetterSink());
        this.withRetry(instance.getRetry());
        this.withTimeout(instance.getTimeout());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public DeadLetterSinkNested<A> editDeadLetterSink() {
    return this.withNewDeadLetterSinkLike(Optional.ofNullable(this.buildDeadLetterSink()).orElse(null));
  }
  
  public DeadLetterSinkNested<A> editOrNewDeadLetterSink() {
    return this.withNewDeadLetterSinkLike(Optional.ofNullable(this.buildDeadLetterSink()).orElse(new DestinationBuilder().build()));
  }
  
  public DeadLetterSinkNested<A> editOrNewDeadLetterSinkLike(Destination item) {
    return this.withNewDeadLetterSinkLike(Optional.ofNullable(this.buildDeadLetterSink()).orElse(item));
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
    DeliverySpecFluent that = (DeliverySpecFluent) o;
    if (!(Objects.equals(backoffDelay, that.backoffDelay))) {
      return false;
    }
    if (!(Objects.equals(backoffPolicy, that.backoffPolicy))) {
      return false;
    }
    if (!(Objects.equals(deadLetterSink, that.deadLetterSink))) {
      return false;
    }
    if (!(Objects.equals(retry, that.retry))) {
      return false;
    }
    if (!(Objects.equals(timeout, that.timeout))) {
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
  
  public String getBackoffDelay() {
    return this.backoffDelay;
  }
  
  public String getBackoffPolicy() {
    return this.backoffPolicy;
  }
  
  public Integer getRetry() {
    return this.retry;
  }
  
  public String getTimeout() {
    return this.timeout;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasBackoffDelay() {
    return this.backoffDelay != null;
  }
  
  public boolean hasBackoffPolicy() {
    return this.backoffPolicy != null;
  }
  
  public boolean hasDeadLetterSink() {
    return this.deadLetterSink != null;
  }
  
  public boolean hasRetry() {
    return this.retry != null;
  }
  
  public boolean hasTimeout() {
    return this.timeout != null;
  }
  
  public int hashCode() {
    return Objects.hash(backoffDelay, backoffPolicy, deadLetterSink, retry, timeout, additionalProperties);
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
    if (!(backoffDelay == null)) {
        sb.append("backoffDelay:");
        sb.append(backoffDelay);
        sb.append(",");
    }
    if (!(backoffPolicy == null)) {
        sb.append("backoffPolicy:");
        sb.append(backoffPolicy);
        sb.append(",");
    }
    if (!(deadLetterSink == null)) {
        sb.append("deadLetterSink:");
        sb.append(deadLetterSink);
        sb.append(",");
    }
    if (!(retry == null)) {
        sb.append("retry:");
        sb.append(retry);
        sb.append(",");
    }
    if (!(timeout == null)) {
        sb.append("timeout:");
        sb.append(timeout);
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
  
  public A withBackoffDelay(String backoffDelay) {
    this.backoffDelay = backoffDelay;
    return (A) this;
  }
  
  public A withBackoffPolicy(String backoffPolicy) {
    this.backoffPolicy = backoffPolicy;
    return (A) this;
  }
  
  public A withDeadLetterSink(Destination deadLetterSink) {
    this._visitables.remove("deadLetterSink");
    if (deadLetterSink != null) {
        this.deadLetterSink = new DestinationBuilder(deadLetterSink);
        this._visitables.get("deadLetterSink").add(this.deadLetterSink);
    } else {
        this.deadLetterSink = null;
        this._visitables.get("deadLetterSink").remove(this.deadLetterSink);
    }
    return (A) this;
  }
  
  public DeadLetterSinkNested<A> withNewDeadLetterSink() {
    return new DeadLetterSinkNested(null);
  }
  
  public DeadLetterSinkNested<A> withNewDeadLetterSinkLike(Destination item) {
    return new DeadLetterSinkNested(item);
  }
  
  public A withRetry(Integer retry) {
    this.retry = retry;
    return (A) this;
  }
  
  public A withTimeout(String timeout) {
    this.timeout = timeout;
    return (A) this;
  }
  public class DeadLetterSinkNested<N> extends DestinationFluent<DeadLetterSinkNested<N>> implements Nested<N>{
  
    DestinationBuilder builder;
  
    DeadLetterSinkNested(Destination item) {
      this.builder = new DestinationBuilder(this, item);
    }
  
    public N and() {
      return (N) DeliverySpecFluent.this.withDeadLetterSink(builder.build());
    }
    
    public N endDeadLetterSink() {
      return and();
    }
    
  }
}