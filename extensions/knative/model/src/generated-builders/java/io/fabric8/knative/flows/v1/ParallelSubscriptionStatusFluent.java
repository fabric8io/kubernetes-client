package io.fabric8.knative.flows.v1;

import io.fabric8.knative.pkg.apis.Condition;
import io.fabric8.knative.pkg.apis.ConditionBuilder;
import io.fabric8.knative.pkg.apis.ConditionFluent;
import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import io.fabric8.kubernetes.api.model.ObjectReference;
import io.fabric8.kubernetes.api.model.ObjectReferenceBuilder;
import io.fabric8.kubernetes.api.model.ObjectReferenceFluent;
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
public class ParallelSubscriptionStatusFluent<A extends io.fabric8.knative.flows.v1.ParallelSubscriptionStatusFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private ConditionBuilder ready;
  private ObjectReferenceBuilder subscription;

  public ParallelSubscriptionStatusFluent() {
  }
  
  public ParallelSubscriptionStatusFluent(ParallelSubscriptionStatus instance) {
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
  
  public Condition buildReady() {
    return this.ready != null ? this.ready.build() : null;
  }
  
  public ObjectReference buildSubscription() {
    return this.subscription != null ? this.subscription.build() : null;
  }
  
  protected void copyInstance(ParallelSubscriptionStatus instance) {
    instance = instance != null ? instance : new ParallelSubscriptionStatus();
    if (instance != null) {
        this.withReady(instance.getReady());
        this.withSubscription(instance.getSubscription());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public ReadyNested<A> editOrNewReady() {
    return this.withNewReadyLike(Optional.ofNullable(this.buildReady()).orElse(new ConditionBuilder().build()));
  }
  
  public ReadyNested<A> editOrNewReadyLike(Condition item) {
    return this.withNewReadyLike(Optional.ofNullable(this.buildReady()).orElse(item));
  }
  
  public SubscriptionNested<A> editOrNewSubscription() {
    return this.withNewSubscriptionLike(Optional.ofNullable(this.buildSubscription()).orElse(new ObjectReferenceBuilder().build()));
  }
  
  public SubscriptionNested<A> editOrNewSubscriptionLike(ObjectReference item) {
    return this.withNewSubscriptionLike(Optional.ofNullable(this.buildSubscription()).orElse(item));
  }
  
  public ReadyNested<A> editReady() {
    return this.withNewReadyLike(Optional.ofNullable(this.buildReady()).orElse(null));
  }
  
  public SubscriptionNested<A> editSubscription() {
    return this.withNewSubscriptionLike(Optional.ofNullable(this.buildSubscription()).orElse(null));
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
    ParallelSubscriptionStatusFluent that = (ParallelSubscriptionStatusFluent) o;
    if (!(Objects.equals(ready, that.ready))) {
      return false;
    }
    if (!(Objects.equals(subscription, that.subscription))) {
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
  
  public boolean hasReady() {
    return this.ready != null;
  }
  
  public boolean hasSubscription() {
    return this.subscription != null;
  }
  
  public int hashCode() {
    return Objects.hash(ready, subscription, additionalProperties);
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
    if (!(ready == null)) {
        sb.append("ready:");
        sb.append(ready);
        sb.append(",");
    }
    if (!(subscription == null)) {
        sb.append("subscription:");
        sb.append(subscription);
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
  
  public ReadyNested<A> withNewReady() {
    return new ReadyNested(null);
  }
  
  public ReadyNested<A> withNewReadyLike(Condition item) {
    return new ReadyNested(item);
  }
  
  public SubscriptionNested<A> withNewSubscription() {
    return new SubscriptionNested(null);
  }
  
  public SubscriptionNested<A> withNewSubscriptionLike(ObjectReference item) {
    return new SubscriptionNested(item);
  }
  
  public A withReady(Condition ready) {
    this._visitables.remove("ready");
    if (ready != null) {
        this.ready = new ConditionBuilder(ready);
        this._visitables.get("ready").add(this.ready);
    } else {
        this.ready = null;
        this._visitables.get("ready").remove(this.ready);
    }
    return (A) this;
  }
  
  public A withSubscription(ObjectReference subscription) {
    this._visitables.remove("subscription");
    if (subscription != null) {
        this.subscription = new ObjectReferenceBuilder(subscription);
        this._visitables.get("subscription").add(this.subscription);
    } else {
        this.subscription = null;
        this._visitables.get("subscription").remove(this.subscription);
    }
    return (A) this;
  }
  public class ReadyNested<N> extends ConditionFluent<ReadyNested<N>> implements Nested<N>{
  
    ConditionBuilder builder;
  
    ReadyNested(Condition item) {
      this.builder = new ConditionBuilder(this, item);
    }
  
    public N and() {
      return (N) ParallelSubscriptionStatusFluent.this.withReady(builder.build());
    }
    
    public N endReady() {
      return and();
    }
    
  }
  public class SubscriptionNested<N> extends ObjectReferenceFluent<SubscriptionNested<N>> implements Nested<N>{
  
    ObjectReferenceBuilder builder;
  
    SubscriptionNested(ObjectReference item) {
      this.builder = new ObjectReferenceBuilder(this, item);
    }
  
    public N and() {
      return (N) ParallelSubscriptionStatusFluent.this.withSubscription(builder.build());
    }
    
    public N endSubscription() {
      return and();
    }
    
  }
}