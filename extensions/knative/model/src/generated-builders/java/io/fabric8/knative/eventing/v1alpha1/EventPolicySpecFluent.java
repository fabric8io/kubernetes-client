package io.fabric8.knative.eventing.v1alpha1;

import io.fabric8.knative.eventing.v1.SubscriptionsAPIFilter;
import io.fabric8.knative.eventing.v1.SubscriptionsAPIFilterBuilder;
import io.fabric8.knative.eventing.v1.SubscriptionsAPIFilterFluent;
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
import java.util.function.Predicate;

/**
 * Generated
 */
@SuppressWarnings("unchecked")
public class EventPolicySpecFluent<A extends io.fabric8.knative.eventing.v1alpha1.EventPolicySpecFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private ArrayList<SubscriptionsAPIFilterBuilder> filters = new ArrayList<SubscriptionsAPIFilterBuilder>();
  private ArrayList<EventPolicySpecFromBuilder> from = new ArrayList<EventPolicySpecFromBuilder>();
  private ArrayList<EventPolicySpecToBuilder> to = new ArrayList<EventPolicySpecToBuilder>();

  public EventPolicySpecFluent() {
  }
  
  public EventPolicySpecFluent(EventPolicySpec instance) {
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
  
  public A addAllToFrom(Collection<EventPolicySpecFrom> items) {
    if (this.from == null) {
      this.from = new ArrayList();
    }
    for (EventPolicySpecFrom item : items) {
        EventPolicySpecFromBuilder builder = new EventPolicySpecFromBuilder(item);
        _visitables.get("from").add(builder);
        this.from.add(builder);
    }
    return (A) this;
  }
  
  public A addAllToTo(Collection<EventPolicySpecTo> items) {
    if (this.to == null) {
      this.to = new ArrayList();
    }
    for (EventPolicySpecTo item : items) {
        EventPolicySpecToBuilder builder = new EventPolicySpecToBuilder(item);
        _visitables.get("to").add(builder);
        this.to.add(builder);
    }
    return (A) this;
  }
  
  public FiltersNested<A> addNewFilter() {
    return new FiltersNested(-1, null);
  }
  
  public FiltersNested<A> addNewFilterLike(SubscriptionsAPIFilter item) {
    return new FiltersNested(-1, item);
  }
  
  public FromNested<A> addNewFrom() {
    return new FromNested(-1, null);
  }
  
  public FromNested<A> addNewFromLike(EventPolicySpecFrom item) {
    return new FromNested(-1, item);
  }
  
  public ToNested<A> addNewTo() {
    return new ToNested(-1, null);
  }
  
  public ToNested<A> addNewToLike(EventPolicySpecTo item) {
    return new ToNested(-1, item);
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
  
  public A addToFrom(EventPolicySpecFrom... items) {
    if (this.from == null) {
      this.from = new ArrayList();
    }
    for (EventPolicySpecFrom item : items) {
        EventPolicySpecFromBuilder builder = new EventPolicySpecFromBuilder(item);
        _visitables.get("from").add(builder);
        this.from.add(builder);
    }
    return (A) this;
  }
  
  public A addToFrom(int index,EventPolicySpecFrom item) {
    if (this.from == null) {
      this.from = new ArrayList();
    }
    EventPolicySpecFromBuilder builder = new EventPolicySpecFromBuilder(item);
    if (index < 0 || index >= from.size()) {
        _visitables.get("from").add(builder);
        from.add(builder);
    } else {
        _visitables.get("from").add(builder);
        from.add(index, builder);
    }
    return (A) this;
  }
  
  public A addToTo(EventPolicySpecTo... items) {
    if (this.to == null) {
      this.to = new ArrayList();
    }
    for (EventPolicySpecTo item : items) {
        EventPolicySpecToBuilder builder = new EventPolicySpecToBuilder(item);
        _visitables.get("to").add(builder);
        this.to.add(builder);
    }
    return (A) this;
  }
  
  public A addToTo(int index,EventPolicySpecTo item) {
    if (this.to == null) {
      this.to = new ArrayList();
    }
    EventPolicySpecToBuilder builder = new EventPolicySpecToBuilder(item);
    if (index < 0 || index >= to.size()) {
        _visitables.get("to").add(builder);
        to.add(builder);
    } else {
        _visitables.get("to").add(builder);
        to.add(index, builder);
    }
    return (A) this;
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
  
  public EventPolicySpecFrom buildFirstFrom() {
    return this.from.get(0).build();
  }
  
  public EventPolicySpecTo buildFirstTo() {
    return this.to.get(0).build();
  }
  
  public List<EventPolicySpecFrom> buildFrom() {
    return this.from != null ? build(from) : null;
  }
  
  public EventPolicySpecFrom buildFrom(int index) {
    return this.from.get(index).build();
  }
  
  public SubscriptionsAPIFilter buildLastFilter() {
    return this.filters.get(filters.size() - 1).build();
  }
  
  public EventPolicySpecFrom buildLastFrom() {
    return this.from.get(from.size() - 1).build();
  }
  
  public EventPolicySpecTo buildLastTo() {
    return this.to.get(to.size() - 1).build();
  }
  
  public SubscriptionsAPIFilter buildMatchingFilter(Predicate<SubscriptionsAPIFilterBuilder> predicate) {
      for (SubscriptionsAPIFilterBuilder item : filters) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public EventPolicySpecFrom buildMatchingFrom(Predicate<EventPolicySpecFromBuilder> predicate) {
      for (EventPolicySpecFromBuilder item : from) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public EventPolicySpecTo buildMatchingTo(Predicate<EventPolicySpecToBuilder> predicate) {
      for (EventPolicySpecToBuilder item : to) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public List<EventPolicySpecTo> buildTo() {
    return this.to != null ? build(to) : null;
  }
  
  public EventPolicySpecTo buildTo(int index) {
    return this.to.get(index).build();
  }
  
  protected void copyInstance(EventPolicySpec instance) {
    instance = instance != null ? instance : new EventPolicySpec();
    if (instance != null) {
        this.withFilters(instance.getFilters());
        this.withFrom(instance.getFrom());
        this.withTo(instance.getTo());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
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
  
  public FromNested<A> editFirstFrom() {
    if (from.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "from"));
    }
    return this.setNewFromLike(0, this.buildFrom(0));
  }
  
  public ToNested<A> editFirstTo() {
    if (to.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "to"));
    }
    return this.setNewToLike(0, this.buildTo(0));
  }
  
  public FromNested<A> editFrom(int index) {
    if (from.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "from"));
    }
    return this.setNewFromLike(index, this.buildFrom(index));
  }
  
  public FiltersNested<A> editLastFilter() {
    int index = filters.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "filters"));
    }
    return this.setNewFilterLike(index, this.buildFilter(index));
  }
  
  public FromNested<A> editLastFrom() {
    int index = from.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "from"));
    }
    return this.setNewFromLike(index, this.buildFrom(index));
  }
  
  public ToNested<A> editLastTo() {
    int index = to.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "to"));
    }
    return this.setNewToLike(index, this.buildTo(index));
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
  
  public FromNested<A> editMatchingFrom(Predicate<EventPolicySpecFromBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < from.size();i++) {
      if (predicate.test(from.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "from"));
    }
    return this.setNewFromLike(index, this.buildFrom(index));
  }
  
  public ToNested<A> editMatchingTo(Predicate<EventPolicySpecToBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < to.size();i++) {
      if (predicate.test(to.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "to"));
    }
    return this.setNewToLike(index, this.buildTo(index));
  }
  
  public ToNested<A> editTo(int index) {
    if (to.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "to"));
    }
    return this.setNewToLike(index, this.buildTo(index));
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
    EventPolicySpecFluent that = (EventPolicySpecFluent) o;
    if (!(Objects.equals(filters, that.filters))) {
      return false;
    }
    if (!(Objects.equals(from, that.from))) {
      return false;
    }
    if (!(Objects.equals(to, that.to))) {
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
  
  public boolean hasFilters() {
    return this.filters != null && !(this.filters.isEmpty());
  }
  
  public boolean hasFrom() {
    return this.from != null && !(this.from.isEmpty());
  }
  
  public boolean hasMatchingFilter(Predicate<SubscriptionsAPIFilterBuilder> predicate) {
      for (SubscriptionsAPIFilterBuilder item : filters) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingFrom(Predicate<EventPolicySpecFromBuilder> predicate) {
      for (EventPolicySpecFromBuilder item : from) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingTo(Predicate<EventPolicySpecToBuilder> predicate) {
      for (EventPolicySpecToBuilder item : to) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasTo() {
    return this.to != null && !(this.to.isEmpty());
  }
  
  public int hashCode() {
    return Objects.hash(filters, from, to, additionalProperties);
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
  
  public A removeAllFromFrom(Collection<EventPolicySpecFrom> items) {
    if (this.from == null) {
      return (A) this;
    }
    for (EventPolicySpecFrom item : items) {
        EventPolicySpecFromBuilder builder = new EventPolicySpecFromBuilder(item);
        _visitables.get("from").remove(builder);
        this.from.remove(builder);
    }
    return (A) this;
  }
  
  public A removeAllFromTo(Collection<EventPolicySpecTo> items) {
    if (this.to == null) {
      return (A) this;
    }
    for (EventPolicySpecTo item : items) {
        EventPolicySpecToBuilder builder = new EventPolicySpecToBuilder(item);
        _visitables.get("to").remove(builder);
        this.to.remove(builder);
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
  
  public A removeFromFrom(EventPolicySpecFrom... items) {
    if (this.from == null) {
      return (A) this;
    }
    for (EventPolicySpecFrom item : items) {
        EventPolicySpecFromBuilder builder = new EventPolicySpecFromBuilder(item);
        _visitables.get("from").remove(builder);
        this.from.remove(builder);
    }
    return (A) this;
  }
  
  public A removeFromTo(EventPolicySpecTo... items) {
    if (this.to == null) {
      return (A) this;
    }
    for (EventPolicySpecTo item : items) {
        EventPolicySpecToBuilder builder = new EventPolicySpecToBuilder(item);
        _visitables.get("to").remove(builder);
        this.to.remove(builder);
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
  
  public A removeMatchingFromFrom(Predicate<EventPolicySpecFromBuilder> predicate) {
    if (from == null) {
      return (A) this;
    }
    Iterator<EventPolicySpecFromBuilder> each = from.iterator();
    List visitables = _visitables.get("from");
    while (each.hasNext()) {
        EventPolicySpecFromBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public A removeMatchingFromTo(Predicate<EventPolicySpecToBuilder> predicate) {
    if (to == null) {
      return (A) this;
    }
    Iterator<EventPolicySpecToBuilder> each = to.iterator();
    List visitables = _visitables.get("to");
    while (each.hasNext()) {
        EventPolicySpecToBuilder builder = each.next();
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
  
  public FromNested<A> setNewFromLike(int index,EventPolicySpecFrom item) {
    return new FromNested(index, item);
  }
  
  public ToNested<A> setNewToLike(int index,EventPolicySpecTo item) {
    return new ToNested(index, item);
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
  
  public A setToFrom(int index,EventPolicySpecFrom item) {
    if (this.from == null) {
      this.from = new ArrayList();
    }
    EventPolicySpecFromBuilder builder = new EventPolicySpecFromBuilder(item);
    if (index < 0 || index >= from.size()) {
        _visitables.get("from").add(builder);
        from.add(builder);
    } else {
        _visitables.get("from").add(builder);
        from.set(index, builder);
    }
    return (A) this;
  }
  
  public A setToTo(int index,EventPolicySpecTo item) {
    if (this.to == null) {
      this.to = new ArrayList();
    }
    EventPolicySpecToBuilder builder = new EventPolicySpecToBuilder(item);
    if (index < 0 || index >= to.size()) {
        _visitables.get("to").add(builder);
        to.add(builder);
    } else {
        _visitables.get("to").add(builder);
        to.set(index, builder);
    }
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(filters == null) && !(filters.isEmpty())) {
        sb.append("filters:");
        sb.append(filters);
        sb.append(",");
    }
    if (!(from == null) && !(from.isEmpty())) {
        sb.append("from:");
        sb.append(from);
        sb.append(",");
    }
    if (!(to == null) && !(to.isEmpty())) {
        sb.append("to:");
        sb.append(to);
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
  
  public A withFrom(List<EventPolicySpecFrom> from) {
    if (this.from != null) {
      this._visitables.get("from").clear();
    }
    if (from != null) {
        this.from = new ArrayList();
        for (EventPolicySpecFrom item : from) {
          this.addToFrom(item);
        }
    } else {
      this.from = null;
    }
    return (A) this;
  }
  
  public A withFrom(EventPolicySpecFrom... from) {
    if (this.from != null) {
        this.from.clear();
        _visitables.remove("from");
    }
    if (from != null) {
      for (EventPolicySpecFrom item : from) {
        this.addToFrom(item);
      }
    }
    return (A) this;
  }
  
  public A withTo(List<EventPolicySpecTo> to) {
    if (this.to != null) {
      this._visitables.get("to").clear();
    }
    if (to != null) {
        this.to = new ArrayList();
        for (EventPolicySpecTo item : to) {
          this.addToTo(item);
        }
    } else {
      this.to = null;
    }
    return (A) this;
  }
  
  public A withTo(EventPolicySpecTo... to) {
    if (this.to != null) {
        this.to.clear();
        _visitables.remove("to");
    }
    if (to != null) {
      for (EventPolicySpecTo item : to) {
        this.addToTo(item);
      }
    }
    return (A) this;
  }
  public class FiltersNested<N> extends SubscriptionsAPIFilterFluent<FiltersNested<N>> implements Nested<N>{
  
    SubscriptionsAPIFilterBuilder builder;
    int index;
  
    FiltersNested(int index,SubscriptionsAPIFilter item) {
      this.index = index;
      this.builder = new SubscriptionsAPIFilterBuilder(this, item);
    }
  
    public N and() {
      return (N) EventPolicySpecFluent.this.setToFilters(index, builder.build());
    }
    
    public N endFilter() {
      return and();
    }
    
  }
  public class FromNested<N> extends EventPolicySpecFromFluent<FromNested<N>> implements Nested<N>{
  
    EventPolicySpecFromBuilder builder;
    int index;
  
    FromNested(int index,EventPolicySpecFrom item) {
      this.index = index;
      this.builder = new EventPolicySpecFromBuilder(this, item);
    }
  
    public N and() {
      return (N) EventPolicySpecFluent.this.setToFrom(index, builder.build());
    }
    
    public N endFrom() {
      return and();
    }
    
  }
  public class ToNested<N> extends EventPolicySpecToFluent<ToNested<N>> implements Nested<N>{
  
    EventPolicySpecToBuilder builder;
    int index;
  
    ToNested(int index,EventPolicySpecTo item) {
      this.index = index;
      this.builder = new EventPolicySpecToBuilder(this, item);
    }
  
    public N and() {
      return (N) EventPolicySpecFluent.this.setToTo(index, builder.build());
    }
    
    public N endTo() {
      return and();
    }
    
  }
}