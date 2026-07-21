package io.fabric8.knative.eventing.v1;

import io.fabric8.knative.duck.v1.DeliverySpec;
import io.fabric8.knative.duck.v1.DeliverySpecBuilder;
import io.fabric8.knative.duck.v1.DeliverySpecFluent;
import io.fabric8.knative.duck.v1.Destination;
import io.fabric8.knative.duck.v1.DestinationBuilder;
import io.fabric8.knative.duck.v1.DestinationFluent;
import io.fabric8.knative.duck.v1.KReference;
import io.fabric8.knative.duck.v1.KReferenceBuilder;
import io.fabric8.knative.duck.v1.KReferenceFluent;
import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import java.lang.Object;
import java.lang.RuntimeException;
import java.lang.String;
import java.lang.StringBuilder;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Predicate;

/**
 * Generated
 */
@SuppressWarnings("unchecked")
public class TriggerSpecFluent<A extends io.fabric8.knative.eventing.v1.TriggerSpecFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String broker;
  private KReferenceBuilder brokerRef;
  private DeliverySpecBuilder delivery;
  private TriggerFilterBuilder filter;
  private ArrayList<SubscriptionsAPIFilterBuilder> filters = new ArrayList<SubscriptionsAPIFilterBuilder>();
  private DestinationBuilder subscriber;

  public TriggerSpecFluent() {
  }
  
  public TriggerSpecFluent(TriggerSpec instance) {
    this.copyInstance(instance);
  }

  public A addAllToFilters(Collection<SubscriptionsAPIFilter> items) {
    if (this.filters == null) {
      this.filters = new ArrayList();
    }
    for (SubscriptionsAPIFilter item : items) {
        SubscriptionsAPIFilterBuilder builder = new SubscriptionsAPIFilterBuilder(item);
        _visitables.get("filters").add(builder);
        this.filters.add(builder);
    }
    return (A) this;
  }
  
  public FiltersNested<A> addNewFilter() {
    return new FiltersNested(-1, null);
  }
  
  public FiltersNested<A> addNewFilterLike(SubscriptionsAPIFilter item) {
    return new FiltersNested(-1, item);
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
  
  public A addToFilters(SubscriptionsAPIFilter... items) {
    if (this.filters == null) {
      this.filters = new ArrayList();
    }
    for (SubscriptionsAPIFilter item : items) {
        SubscriptionsAPIFilterBuilder builder = new SubscriptionsAPIFilterBuilder(item);
        _visitables.get("filters").add(builder);
        this.filters.add(builder);
    }
    return (A) this;
  }
  
  public A addToFilters(int index,SubscriptionsAPIFilter item) {
    if (this.filters == null) {
      this.filters = new ArrayList();
    }
    SubscriptionsAPIFilterBuilder builder = new SubscriptionsAPIFilterBuilder(item);
    if (index < 0 || index >= filters.size()) {
        _visitables.get("filters").add(builder);
        filters.add(builder);
    } else {
        _visitables.get("filters").add(builder);
        filters.add(index, builder);
    }
    return (A) this;
  }
  
  public KReference buildBrokerRef() {
    return this.brokerRef != null ? this.brokerRef.build() : null;
  }
  
  public DeliverySpec buildDelivery() {
    return this.delivery != null ? this.delivery.build() : null;
  }
  
  public TriggerFilter buildFilter() {
    return this.filter != null ? this.filter.build() : null;
  }
  
  public SubscriptionsAPIFilter buildFilter(int index) {
    return this.filters.get(index).build();
  }
  
  public List<SubscriptionsAPIFilter> buildFilters() {
    return this.filters != null ? build(filters) : null;
  }
  
  public SubscriptionsAPIFilter buildFirstFilter() {
    return this.filters.get(0).build();
  }
  
  public SubscriptionsAPIFilter buildLastFilter() {
    return this.filters.get(filters.size() - 1).build();
  }
  
  public SubscriptionsAPIFilter buildMatchingFilter(Predicate<SubscriptionsAPIFilterBuilder> predicate) {
      for (SubscriptionsAPIFilterBuilder item : filters) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public Destination buildSubscriber() {
    return this.subscriber != null ? this.subscriber.build() : null;
  }
  
  protected void copyInstance(TriggerSpec instance) {
    instance = instance != null ? instance : new TriggerSpec();
    if (instance != null) {
        this.withBroker(instance.getBroker());
        this.withBrokerRef(instance.getBrokerRef());
        this.withDelivery(instance.getDelivery());
        this.withFilter(instance.getFilter());
        this.withFilters(instance.getFilters());
        this.withSubscriber(instance.getSubscriber());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public BrokerRefNested<A> editBrokerRef() {
    return this.withNewBrokerRefLike(Optional.ofNullable(this.buildBrokerRef()).orElse(null));
  }
  
  public DeliveryNested<A> editDelivery() {
    return this.withNewDeliveryLike(Optional.ofNullable(this.buildDelivery()).orElse(null));
  }
  
  public FilterNested<A> editFilter() {
    return this.withNewFilterLike(Optional.ofNullable(this.buildFilter()).orElse(null));
  }
  
  public FiltersNested<A> editFilter(int index) {
    if (filters.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "filters"));
    }
    return this.setNewFilterLike(index, this.buildFilter(index));
  }
  
  public FiltersNested<A> editFirstFilter() {
    if (filters.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "filters"));
    }
    return this.setNewFilterLike(0, this.buildFilter(0));
  }
  
  public FiltersNested<A> editLastFilter() {
    int index = filters.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "filters"));
    }
    return this.setNewFilterLike(index, this.buildFilter(index));
  }
  
  public FiltersNested<A> editMatchingFilter(Predicate<SubscriptionsAPIFilterBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < filters.size();i++) {
      if (predicate.test(filters.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "filters"));
    }
    return this.setNewFilterLike(index, this.buildFilter(index));
  }
  
  public BrokerRefNested<A> editOrNewBrokerRef() {
    return this.withNewBrokerRefLike(Optional.ofNullable(this.buildBrokerRef()).orElse(new KReferenceBuilder().build()));
  }
  
  public BrokerRefNested<A> editOrNewBrokerRefLike(KReference item) {
    return this.withNewBrokerRefLike(Optional.ofNullable(this.buildBrokerRef()).orElse(item));
  }
  
  public DeliveryNested<A> editOrNewDelivery() {
    return this.withNewDeliveryLike(Optional.ofNullable(this.buildDelivery()).orElse(new DeliverySpecBuilder().build()));
  }
  
  public DeliveryNested<A> editOrNewDeliveryLike(DeliverySpec item) {
    return this.withNewDeliveryLike(Optional.ofNullable(this.buildDelivery()).orElse(item));
  }
  
  public FilterNested<A> editOrNewFilter() {
    return this.withNewFilterLike(Optional.ofNullable(this.buildFilter()).orElse(new TriggerFilterBuilder().build()));
  }
  
  public FilterNested<A> editOrNewFilterLike(TriggerFilter item) {
    return this.withNewFilterLike(Optional.ofNullable(this.buildFilter()).orElse(item));
  }
  
  public SubscriberNested<A> editOrNewSubscriber() {
    return this.withNewSubscriberLike(Optional.ofNullable(this.buildSubscriber()).orElse(new DestinationBuilder().build()));
  }
  
  public SubscriberNested<A> editOrNewSubscriberLike(Destination item) {
    return this.withNewSubscriberLike(Optional.ofNullable(this.buildSubscriber()).orElse(item));
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
    TriggerSpecFluent that = (TriggerSpecFluent) o;
    if (!(Objects.equals(broker, that.broker))) {
      return false;
    }
    if (!(Objects.equals(brokerRef, that.brokerRef))) {
      return false;
    }
    if (!(Objects.equals(delivery, that.delivery))) {
      return false;
    }
    if (!(Objects.equals(filter, that.filter))) {
      return false;
    }
    if (!(Objects.equals(filters, that.filters))) {
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
  
  public String getBroker() {
    return this.broker;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasBroker() {
    return this.broker != null;
  }
  
  public boolean hasBrokerRef() {
    return this.brokerRef != null;
  }
  
  public boolean hasDelivery() {
    return this.delivery != null;
  }
  
  public boolean hasFilter() {
    return this.filter != null;
  }
  
  public boolean hasFilters() {
    return this.filters != null && !(this.filters.isEmpty());
  }
  
  public boolean hasMatchingFilter(Predicate<SubscriptionsAPIFilterBuilder> predicate) {
      for (SubscriptionsAPIFilterBuilder item : filters) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasSubscriber() {
    return this.subscriber != null;
  }
  
  public int hashCode() {
    return Objects.hash(broker, brokerRef, delivery, filter, filters, subscriber, additionalProperties);
  }
  
  public A removeAllFromFilters(Collection<SubscriptionsAPIFilter> items) {
    if (this.filters == null) {
      return (A) this;
    }
    for (SubscriptionsAPIFilter item : items) {
        SubscriptionsAPIFilterBuilder builder = new SubscriptionsAPIFilterBuilder(item);
        _visitables.get("filters").remove(builder);
        this.filters.remove(builder);
    }
    return (A) this;
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
  
  public A removeFromFilters(SubscriptionsAPIFilter... items) {
    if (this.filters == null) {
      return (A) this;
    }
    for (SubscriptionsAPIFilter item : items) {
        SubscriptionsAPIFilterBuilder builder = new SubscriptionsAPIFilterBuilder(item);
        _visitables.get("filters").remove(builder);
        this.filters.remove(builder);
    }
    return (A) this;
  }
  
  public A removeMatchingFromFilters(Predicate<SubscriptionsAPIFilterBuilder> predicate) {
    if (filters == null) {
      return (A) this;
    }
    Iterator<SubscriptionsAPIFilterBuilder> each = filters.iterator();
    List visitables = _visitables.get("filters");
    while (each.hasNext()) {
        SubscriptionsAPIFilterBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public FiltersNested<A> setNewFilterLike(int index,SubscriptionsAPIFilter item) {
    return new FiltersNested(index, item);
  }
  
  public A setToFilters(int index,SubscriptionsAPIFilter item) {
    if (this.filters == null) {
      this.filters = new ArrayList();
    }
    SubscriptionsAPIFilterBuilder builder = new SubscriptionsAPIFilterBuilder(item);
    if (index < 0 || index >= filters.size()) {
        _visitables.get("filters").add(builder);
        filters.add(builder);
    } else {
        _visitables.get("filters").add(builder);
        filters.set(index, builder);
    }
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(broker == null)) {
        sb.append("broker:");
        sb.append(broker);
        sb.append(",");
    }
    if (!(brokerRef == null)) {
        sb.append("brokerRef:");
        sb.append(brokerRef);
        sb.append(",");
    }
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
    if (!(filters == null) && !(filters.isEmpty())) {
        sb.append("filters:");
        sb.append(filters);
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
  
  public A withBroker(String broker) {
    this.broker = broker;
    return (A) this;
  }
  
  public A withBrokerRef(KReference brokerRef) {
    this._visitables.remove("brokerRef");
    if (brokerRef != null) {
        this.brokerRef = new KReferenceBuilder(brokerRef);
        this._visitables.get("brokerRef").add(this.brokerRef);
    } else {
        this.brokerRef = null;
        this._visitables.get("brokerRef").remove(this.brokerRef);
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
  
  public A withFilter(TriggerFilter filter) {
    this._visitables.remove("filter");
    if (filter != null) {
        this.filter = new TriggerFilterBuilder(filter);
        this._visitables.get("filter").add(this.filter);
    } else {
        this.filter = null;
        this._visitables.get("filter").remove(this.filter);
    }
    return (A) this;
  }
  
  public A withFilters(List<SubscriptionsAPIFilter> filters) {
    if (this.filters != null) {
      this._visitables.get("filters").clear();
    }
    if (filters != null) {
        this.filters = new ArrayList();
        for (SubscriptionsAPIFilter item : filters) {
          this.addToFilters(item);
        }
    } else {
      this.filters = null;
    }
    return (A) this;
  }
  
  public A withFilters(SubscriptionsAPIFilter... filters) {
    if (this.filters != null) {
        this.filters.clear();
        _visitables.remove("filters");
    }
    if (filters != null) {
      for (SubscriptionsAPIFilter item : filters) {
        this.addToFilters(item);
      }
    }
    return (A) this;
  }
  
  public BrokerRefNested<A> withNewBrokerRef() {
    return new BrokerRefNested(null);
  }
  
  public BrokerRefNested<A> withNewBrokerRefLike(KReference item) {
    return new BrokerRefNested(item);
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
  
  public FilterNested<A> withNewFilterLike(TriggerFilter item) {
    return new FilterNested(item);
  }
  
  public SubscriberNested<A> withNewSubscriber() {
    return new SubscriberNested(null);
  }
  
  public SubscriberNested<A> withNewSubscriberLike(Destination item) {
    return new SubscriberNested(item);
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
  public class BrokerRefNested<N> extends KReferenceFluent<BrokerRefNested<N>> implements Nested<N>{
  
    KReferenceBuilder builder;
  
    BrokerRefNested(KReference item) {
      this.builder = new KReferenceBuilder(this, item);
    }
  
    public N and() {
      return (N) TriggerSpecFluent.this.withBrokerRef(builder.build());
    }
    
    public N endBrokerRef() {
      return and();
    }
    
  }
  public class DeliveryNested<N> extends DeliverySpecFluent<DeliveryNested<N>> implements Nested<N>{
  
    DeliverySpecBuilder builder;
  
    DeliveryNested(DeliverySpec item) {
      this.builder = new DeliverySpecBuilder(this, item);
    }
  
    public N and() {
      return (N) TriggerSpecFluent.this.withDelivery(builder.build());
    }
    
    public N endDelivery() {
      return and();
    }
    
  }
  public class FilterNested<N> extends TriggerFilterFluent<FilterNested<N>> implements Nested<N>{
  
    TriggerFilterBuilder builder;
  
    FilterNested(TriggerFilter item) {
      this.builder = new TriggerFilterBuilder(this, item);
    }
  
    public N and() {
      return (N) TriggerSpecFluent.this.withFilter(builder.build());
    }
    
    public N endFilter() {
      return and();
    }
    
  }
  public class FiltersNested<N> extends SubscriptionsAPIFilterFluent<FiltersNested<N>> implements Nested<N>{
  
    SubscriptionsAPIFilterBuilder builder;
    int index;
  
    FiltersNested(int index,SubscriptionsAPIFilter item) {
      this.index = index;
      this.builder = new SubscriptionsAPIFilterBuilder(this, item);
    }
  
    public N and() {
      return (N) TriggerSpecFluent.this.setToFilters(index, builder.build());
    }
    
    public N endFilter() {
      return and();
    }
    
  }
  public class SubscriberNested<N> extends DestinationFluent<SubscriberNested<N>> implements Nested<N>{
  
    DestinationBuilder builder;
  
    SubscriberNested(Destination item) {
      this.builder = new DestinationBuilder(this, item);
    }
  
    public N and() {
      return (N) TriggerSpecFluent.this.withSubscriber(builder.build());
    }
    
    public N endSubscriber() {
      return and();
    }
    
  }
}