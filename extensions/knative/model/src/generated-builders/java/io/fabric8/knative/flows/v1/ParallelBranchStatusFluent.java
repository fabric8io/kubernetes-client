package io.fabric8.knative.flows.v1;

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
public class ParallelBranchStatusFluent<A extends io.fabric8.knative.flows.v1.ParallelBranchStatusFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private ParallelChannelStatusBuilder filterChannelStatus;
  private ParallelSubscriptionStatusBuilder filterSubscriptionStatus;
  private ParallelSubscriptionStatusBuilder subscriberSubscriptionStatus;

  public ParallelBranchStatusFluent() {
  }
  
  public ParallelBranchStatusFluent(ParallelBranchStatus instance) {
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
  
  public ParallelChannelStatus buildFilterChannelStatus() {
    return this.filterChannelStatus != null ? this.filterChannelStatus.build() : null;
  }
  
  public ParallelSubscriptionStatus buildFilterSubscriptionStatus() {
    return this.filterSubscriptionStatus != null ? this.filterSubscriptionStatus.build() : null;
  }
  
  public ParallelSubscriptionStatus buildSubscriberSubscriptionStatus() {
    return this.subscriberSubscriptionStatus != null ? this.subscriberSubscriptionStatus.build() : null;
  }
  
  protected void copyInstance(ParallelBranchStatus instance) {
    instance = instance != null ? instance : new ParallelBranchStatus();
    if (instance != null) {
        this.withFilterChannelStatus(instance.getFilterChannelStatus());
        this.withFilterSubscriptionStatus(instance.getFilterSubscriptionStatus());
        this.withSubscriberSubscriptionStatus(instance.getSubscriberSubscriptionStatus());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public FilterChannelStatusNested<A> editFilterChannelStatus() {
    return this.withNewFilterChannelStatusLike(Optional.ofNullable(this.buildFilterChannelStatus()).orElse(null));
  }
  
  public FilterSubscriptionStatusNested<A> editFilterSubscriptionStatus() {
    return this.withNewFilterSubscriptionStatusLike(Optional.ofNullable(this.buildFilterSubscriptionStatus()).orElse(null));
  }
  
  public FilterChannelStatusNested<A> editOrNewFilterChannelStatus() {
    return this.withNewFilterChannelStatusLike(Optional.ofNullable(this.buildFilterChannelStatus()).orElse(new ParallelChannelStatusBuilder().build()));
  }
  
  public FilterChannelStatusNested<A> editOrNewFilterChannelStatusLike(ParallelChannelStatus item) {
    return this.withNewFilterChannelStatusLike(Optional.ofNullable(this.buildFilterChannelStatus()).orElse(item));
  }
  
  public FilterSubscriptionStatusNested<A> editOrNewFilterSubscriptionStatus() {
    return this.withNewFilterSubscriptionStatusLike(Optional.ofNullable(this.buildFilterSubscriptionStatus()).orElse(new ParallelSubscriptionStatusBuilder().build()));
  }
  
  public FilterSubscriptionStatusNested<A> editOrNewFilterSubscriptionStatusLike(ParallelSubscriptionStatus item) {
    return this.withNewFilterSubscriptionStatusLike(Optional.ofNullable(this.buildFilterSubscriptionStatus()).orElse(item));
  }
  
  public SubscriberSubscriptionStatusNested<A> editOrNewSubscriberSubscriptionStatus() {
    return this.withNewSubscriberSubscriptionStatusLike(Optional.ofNullable(this.buildSubscriberSubscriptionStatus()).orElse(new ParallelSubscriptionStatusBuilder().build()));
  }
  
  public SubscriberSubscriptionStatusNested<A> editOrNewSubscriberSubscriptionStatusLike(ParallelSubscriptionStatus item) {
    return this.withNewSubscriberSubscriptionStatusLike(Optional.ofNullable(this.buildSubscriberSubscriptionStatus()).orElse(item));
  }
  
  public SubscriberSubscriptionStatusNested<A> editSubscriberSubscriptionStatus() {
    return this.withNewSubscriberSubscriptionStatusLike(Optional.ofNullable(this.buildSubscriberSubscriptionStatus()).orElse(null));
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
    ParallelBranchStatusFluent that = (ParallelBranchStatusFluent) o;
    if (!(Objects.equals(filterChannelStatus, that.filterChannelStatus))) {
      return false;
    }
    if (!(Objects.equals(filterSubscriptionStatus, that.filterSubscriptionStatus))) {
      return false;
    }
    if (!(Objects.equals(subscriberSubscriptionStatus, that.subscriberSubscriptionStatus))) {
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
  
  public boolean hasFilterChannelStatus() {
    return this.filterChannelStatus != null;
  }
  
  public boolean hasFilterSubscriptionStatus() {
    return this.filterSubscriptionStatus != null;
  }
  
  public boolean hasSubscriberSubscriptionStatus() {
    return this.subscriberSubscriptionStatus != null;
  }
  
  public int hashCode() {
    return Objects.hash(filterChannelStatus, filterSubscriptionStatus, subscriberSubscriptionStatus, additionalProperties);
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
    if (!(filterChannelStatus == null)) {
        sb.append("filterChannelStatus:");
        sb.append(filterChannelStatus);
        sb.append(",");
    }
    if (!(filterSubscriptionStatus == null)) {
        sb.append("filterSubscriptionStatus:");
        sb.append(filterSubscriptionStatus);
        sb.append(",");
    }
    if (!(subscriberSubscriptionStatus == null)) {
        sb.append("subscriberSubscriptionStatus:");
        sb.append(subscriberSubscriptionStatus);
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
  
  public A withFilterChannelStatus(ParallelChannelStatus filterChannelStatus) {
    this._visitables.remove("filterChannelStatus");
    if (filterChannelStatus != null) {
        this.filterChannelStatus = new ParallelChannelStatusBuilder(filterChannelStatus);
        this._visitables.get("filterChannelStatus").add(this.filterChannelStatus);
    } else {
        this.filterChannelStatus = null;
        this._visitables.get("filterChannelStatus").remove(this.filterChannelStatus);
    }
    return (A) this;
  }
  
  public A withFilterSubscriptionStatus(ParallelSubscriptionStatus filterSubscriptionStatus) {
    this._visitables.remove("filterSubscriptionStatus");
    if (filterSubscriptionStatus != null) {
        this.filterSubscriptionStatus = new ParallelSubscriptionStatusBuilder(filterSubscriptionStatus);
        this._visitables.get("filterSubscriptionStatus").add(this.filterSubscriptionStatus);
    } else {
        this.filterSubscriptionStatus = null;
        this._visitables.get("filterSubscriptionStatus").remove(this.filterSubscriptionStatus);
    }
    return (A) this;
  }
  
  public FilterChannelStatusNested<A> withNewFilterChannelStatus() {
    return new FilterChannelStatusNested(null);
  }
  
  public FilterChannelStatusNested<A> withNewFilterChannelStatusLike(ParallelChannelStatus item) {
    return new FilterChannelStatusNested(item);
  }
  
  public FilterSubscriptionStatusNested<A> withNewFilterSubscriptionStatus() {
    return new FilterSubscriptionStatusNested(null);
  }
  
  public FilterSubscriptionStatusNested<A> withNewFilterSubscriptionStatusLike(ParallelSubscriptionStatus item) {
    return new FilterSubscriptionStatusNested(item);
  }
  
  public SubscriberSubscriptionStatusNested<A> withNewSubscriberSubscriptionStatus() {
    return new SubscriberSubscriptionStatusNested(null);
  }
  
  public SubscriberSubscriptionStatusNested<A> withNewSubscriberSubscriptionStatusLike(ParallelSubscriptionStatus item) {
    return new SubscriberSubscriptionStatusNested(item);
  }
  
  public A withSubscriberSubscriptionStatus(ParallelSubscriptionStatus subscriberSubscriptionStatus) {
    this._visitables.remove("subscriberSubscriptionStatus");
    if (subscriberSubscriptionStatus != null) {
        this.subscriberSubscriptionStatus = new ParallelSubscriptionStatusBuilder(subscriberSubscriptionStatus);
        this._visitables.get("subscriberSubscriptionStatus").add(this.subscriberSubscriptionStatus);
    } else {
        this.subscriberSubscriptionStatus = null;
        this._visitables.get("subscriberSubscriptionStatus").remove(this.subscriberSubscriptionStatus);
    }
    return (A) this;
  }
  public class FilterChannelStatusNested<N> extends ParallelChannelStatusFluent<FilterChannelStatusNested<N>> implements Nested<N>{
  
    ParallelChannelStatusBuilder builder;
  
    FilterChannelStatusNested(ParallelChannelStatus item) {
      this.builder = new ParallelChannelStatusBuilder(this, item);
    }
  
    public N and() {
      return (N) ParallelBranchStatusFluent.this.withFilterChannelStatus(builder.build());
    }
    
    public N endFilterChannelStatus() {
      return and();
    }
    
  }
  public class FilterSubscriptionStatusNested<N> extends ParallelSubscriptionStatusFluent<FilterSubscriptionStatusNested<N>> implements Nested<N>{
  
    ParallelSubscriptionStatusBuilder builder;
  
    FilterSubscriptionStatusNested(ParallelSubscriptionStatus item) {
      this.builder = new ParallelSubscriptionStatusBuilder(this, item);
    }
  
    public N and() {
      return (N) ParallelBranchStatusFluent.this.withFilterSubscriptionStatus(builder.build());
    }
    
    public N endFilterSubscriptionStatus() {
      return and();
    }
    
  }
  public class SubscriberSubscriptionStatusNested<N> extends ParallelSubscriptionStatusFluent<SubscriberSubscriptionStatusNested<N>> implements Nested<N>{
  
    ParallelSubscriptionStatusBuilder builder;
  
    SubscriberSubscriptionStatusNested(ParallelSubscriptionStatus item) {
      this.builder = new ParallelSubscriptionStatusBuilder(this, item);
    }
  
    public N and() {
      return (N) ParallelBranchStatusFluent.this.withSubscriberSubscriptionStatus(builder.build());
    }
    
    public N endSubscriberSubscriptionStatus() {
      return and();
    }
    
  }
}