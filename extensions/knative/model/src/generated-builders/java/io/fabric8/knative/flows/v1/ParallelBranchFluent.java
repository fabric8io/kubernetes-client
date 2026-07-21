package io.fabric8.knative.flows.v1;

import io.fabric8.knative.duck.v1.DeliverySpec;
import io.fabric8.knative.duck.v1.DeliverySpecBuilder;
import io.fabric8.knative.duck.v1.DeliverySpecFluent;
import io.fabric8.knative.duck.v1.Destination;
import io.fabric8.knative.duck.v1.DestinationBuilder;
import io.fabric8.knative.duck.v1.DestinationFluent;
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
public class ParallelBranchFluent<A extends io.fabric8.knative.flows.v1.ParallelBranchFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private DeliverySpecBuilder delivery;
  private DestinationBuilder filter;
  private DestinationBuilder reply;
  private DestinationBuilder subscriber;

  public ParallelBranchFluent() {
  }
  
  public ParallelBranchFluent(ParallelBranch instance) {
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
  
  public DeliverySpec buildDelivery() {
    return this.delivery != null ? this.delivery.build() : null;
  }
  
  public Destination buildFilter() {
    return this.filter != null ? this.filter.build() : null;
  }
  
  public Destination buildReply() {
    return this.reply != null ? this.reply.build() : null;
  }
  
  public Destination buildSubscriber() {
    return this.subscriber != null ? this.subscriber.build() : null;
  }
  
  protected void copyInstance(ParallelBranch instance) {
    instance = instance != null ? instance : new ParallelBranch();
    if (instance != null) {
        this.withDelivery(instance.getDelivery());
        this.withFilter(instance.getFilter());
        this.withReply(instance.getReply());
        this.withSubscriber(instance.getSubscriber());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public DeliveryNested<A> editDelivery() {
    return this.withNewDeliveryLike(Optional.ofNullable(this.buildDelivery()).orElse(null));
  }
  
  public FilterNested<A> editFilter() {
    return this.withNewFilterLike(Optional.ofNullable(this.buildFilter()).orElse(null));
  }
  
  public DeliveryNested<A> editOrNewDelivery() {
    return this.withNewDeliveryLike(Optional.ofNullable(this.buildDelivery()).orElse(new DeliverySpecBuilder().build()));
  }
  
  public DeliveryNested<A> editOrNewDeliveryLike(DeliverySpec item) {
    return this.withNewDeliveryLike(Optional.ofNullable(this.buildDelivery()).orElse(item));
  }
  
  public FilterNested<A> editOrNewFilter() {
    return this.withNewFilterLike(Optional.ofNullable(this.buildFilter()).orElse(new DestinationBuilder().build()));
  }
  
  public FilterNested<A> editOrNewFilterLike(Destination item) {
    return this.withNewFilterLike(Optional.ofNullable(this.buildFilter()).orElse(item));
  }
  
  public ReplyNested<A> editOrNewReply() {
    return this.withNewReplyLike(Optional.ofNullable(this.buildReply()).orElse(new DestinationBuilder().build()));
  }
  
  public ReplyNested<A> editOrNewReplyLike(Destination item) {
    return this.withNewReplyLike(Optional.ofNullable(this.buildReply()).orElse(item));
  }
  
  public SubscriberNested<A> editOrNewSubscriber() {
    return this.withNewSubscriberLike(Optional.ofNullable(this.buildSubscriber()).orElse(new DestinationBuilder().build()));
  }
  
  public SubscriberNested<A> editOrNewSubscriberLike(Destination item) {
    return this.withNewSubscriberLike(Optional.ofNullable(this.buildSubscriber()).orElse(item));
  }
  
  public ReplyNested<A> editReply() {
    return this.withNewReplyLike(Optional.ofNullable(this.buildReply()).orElse(null));
  }
  
  public SubscriberNested<A> editSubscriber() {
    return this.withNewSubscriberLike(Optional.ofNullable(this.buildSubscriber()).orElse(null));
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
    ParallelBranchFluent that = (ParallelBranchFluent) o;
    if (!(Objects.equals(delivery, that.delivery))) {
      return false;
    }
    if (!(Objects.equals(filter, that.filter))) {
      return false;
    }
    if (!(Objects.equals(reply, that.reply))) {
      return false;
    }
    if (!(Objects.equals(subscriber, that.subscriber))) {
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
  
  public boolean hasDelivery() {
    return this.delivery != null;
  }
  
  public boolean hasFilter() {
    return this.filter != null;
  }
  
  public boolean hasReply() {
    return this.reply != null;
  }
  
  public boolean hasSubscriber() {
    return this.subscriber != null;
  }
  
  public int hashCode() {
    return Objects.hash(delivery, filter, reply, subscriber, additionalProperties);
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
    if (!(delivery == null)) {
        sb.append("delivery:");
        sb.append(delivery);
        sb.append(",");
    }
    if (!(filter == null)) {
        sb.append("filter:");
        sb.append(filter);
        sb.append(",");
    }
    if (!(reply == null)) {
        sb.append("reply:");
        sb.append(reply);
        sb.append(",");
    }
    if (!(subscriber == null)) {
        sb.append("subscriber:");
        sb.append(subscriber);
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
  
  public A withDelivery(DeliverySpec delivery) {
    this._visitables.remove("delivery");
    if (delivery != null) {
        this.delivery = new DeliverySpecBuilder(delivery);
        this._visitables.get("delivery").add(this.delivery);
    } else {
        this.delivery = null;
        this._visitables.get("delivery").remove(this.delivery);
    }
    return (A) this;
  }
  
  public A withFilter(Destination filter) {
    this._visitables.remove("filter");
    if (filter != null) {
        this.filter = new DestinationBuilder(filter);
        this._visitables.get("filter").add(this.filter);
    } else {
        this.filter = null;
        this._visitables.get("filter").remove(this.filter);
    }
    return (A) this;
  }
  
  public DeliveryNested<A> withNewDelivery() {
    return new DeliveryNested(null);
  }
  
  public DeliveryNested<A> withNewDeliveryLike(DeliverySpec item) {
    return new DeliveryNested(item);
  }
  
  public FilterNested<A> withNewFilter() {
    return new FilterNested(null);
  }
  
  public FilterNested<A> withNewFilterLike(Destination item) {
    return new FilterNested(item);
  }
  
  public ReplyNested<A> withNewReply() {
    return new ReplyNested(null);
  }
  
  public ReplyNested<A> withNewReplyLike(Destination item) {
    return new ReplyNested(item);
  }
  
  public SubscriberNested<A> withNewSubscriber() {
    return new SubscriberNested(null);
  }
  
  public SubscriberNested<A> withNewSubscriberLike(Destination item) {
    return new SubscriberNested(item);
  }
  
  public A withReply(Destination reply) {
    this._visitables.remove("reply");
    if (reply != null) {
        this.reply = new DestinationBuilder(reply);
        this._visitables.get("reply").add(this.reply);
    } else {
        this.reply = null;
        this._visitables.get("reply").remove(this.reply);
    }
    return (A) this;
  }
  
  public A withSubscriber(Destination subscriber) {
    this._visitables.remove("subscriber");
    if (subscriber != null) {
        this.subscriber = new DestinationBuilder(subscriber);
        this._visitables.get("subscriber").add(this.subscriber);
    } else {
        this.subscriber = null;
        this._visitables.get("subscriber").remove(this.subscriber);
    }
    return (A) this;
  }
  public class DeliveryNested<N> extends DeliverySpecFluent<DeliveryNested<N>> implements Nested<N>{
  
    DeliverySpecBuilder builder;
  
    DeliveryNested(DeliverySpec item) {
      this.builder = new DeliverySpecBuilder(this, item);
    }
  
    public N and() {
      return (N) ParallelBranchFluent.this.withDelivery(builder.build());
    }
    
    public N endDelivery() {
      return and();
    }
    
  }
  public class FilterNested<N> extends DestinationFluent<FilterNested<N>> implements Nested<N>{
  
    DestinationBuilder builder;
  
    FilterNested(Destination item) {
      this.builder = new DestinationBuilder(this, item);
    }
  
    public N and() {
      return (N) ParallelBranchFluent.this.withFilter(builder.build());
    }
    
    public N endFilter() {
      return and();
    }
    
  }
  public class ReplyNested<N> extends DestinationFluent<ReplyNested<N>> implements Nested<N>{
  
    DestinationBuilder builder;
  
    ReplyNested(Destination item) {
      this.builder = new DestinationBuilder(this, item);
    }
  
    public N and() {
      return (N) ParallelBranchFluent.this.withReply(builder.build());
    }
    
    public N endReply() {
      return and();
    }
    
  }
  public class SubscriberNested<N> extends DestinationFluent<SubscriberNested<N>> implements Nested<N>{
  
    DestinationBuilder builder;
  
    SubscriberNested(Destination item) {
      this.builder = new DestinationBuilder(this, item);
    }
  
    public N and() {
      return (N) ParallelBranchFluent.this.withSubscriber(builder.build());
    }
    
    public N endSubscriber() {
      return and();
    }
    
  }
}