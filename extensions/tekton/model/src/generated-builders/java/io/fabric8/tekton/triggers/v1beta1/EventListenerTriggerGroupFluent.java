package io.fabric8.tekton.triggers.v1beta1;

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
public class EventListenerTriggerGroupFluent<A extends io.fabric8.tekton.triggers.v1beta1.EventListenerTriggerGroupFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private ArrayList<TriggerInterceptorBuilder> interceptors = new ArrayList<TriggerInterceptorBuilder>();
  private String name;
  private EventListenerTriggerSelectorBuilder triggerSelector;

  public EventListenerTriggerGroupFluent() {
  }
  
  public EventListenerTriggerGroupFluent(EventListenerTriggerGroup instance) {
    this.copyInstance(instance);
  }

  public A addAllToInterceptors(Collection<TriggerInterceptor> items) {
    if (this.interceptors == null) {
      this.interceptors = new ArrayList();
    }
    for (TriggerInterceptor item : items) {
        TriggerInterceptorBuilder builder = new TriggerInterceptorBuilder(item);
        _visitables.get("interceptors").add(builder);
        this.interceptors.add(builder);
    }
    return (A) this;
  }
  
  public InterceptorsNested<A> addNewInterceptor() {
    return new InterceptorsNested(-1, null);
  }
  
  public InterceptorsNested<A> addNewInterceptorLike(TriggerInterceptor item) {
    return new InterceptorsNested(-1, item);
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
  
  public A addToInterceptors(TriggerInterceptor... items) {
    if (this.interceptors == null) {
      this.interceptors = new ArrayList();
    }
    for (TriggerInterceptor item : items) {
        TriggerInterceptorBuilder builder = new TriggerInterceptorBuilder(item);
        _visitables.get("interceptors").add(builder);
        this.interceptors.add(builder);
    }
    return (A) this;
  }
  
  public A addToInterceptors(int index,TriggerInterceptor item) {
    if (this.interceptors == null) {
      this.interceptors = new ArrayList();
    }
    TriggerInterceptorBuilder builder = new TriggerInterceptorBuilder(item);
    if (index < 0 || index >= interceptors.size()) {
        _visitables.get("interceptors").add(builder);
        interceptors.add(builder);
    } else {
        _visitables.get("interceptors").add(builder);
        interceptors.add(index, builder);
    }
    return (A) this;
  }
  
  public TriggerInterceptor buildFirstInterceptor() {
    return this.interceptors.get(0).build();
  }
  
  public TriggerInterceptor buildInterceptor(int index) {
    return this.interceptors.get(index).build();
  }
  
  public List<TriggerInterceptor> buildInterceptors() {
    return this.interceptors != null ? build(interceptors) : null;
  }
  
  public TriggerInterceptor buildLastInterceptor() {
    return this.interceptors.get(interceptors.size() - 1).build();
  }
  
  public TriggerInterceptor buildMatchingInterceptor(Predicate<TriggerInterceptorBuilder> predicate) {
      for (TriggerInterceptorBuilder item : interceptors) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public EventListenerTriggerSelector buildTriggerSelector() {
    return this.triggerSelector != null ? this.triggerSelector.build() : null;
  }
  
  protected void copyInstance(EventListenerTriggerGroup instance) {
    instance = instance != null ? instance : new EventListenerTriggerGroup();
    if (instance != null) {
        this.withInterceptors(instance.getInterceptors());
        this.withName(instance.getName());
        this.withTriggerSelector(instance.getTriggerSelector());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public InterceptorsNested<A> editFirstInterceptor() {
    if (interceptors.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "interceptors"));
    }
    return this.setNewInterceptorLike(0, this.buildInterceptor(0));
  }
  
  public InterceptorsNested<A> editInterceptor(int index) {
    if (interceptors.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "interceptors"));
    }
    return this.setNewInterceptorLike(index, this.buildInterceptor(index));
  }
  
  public InterceptorsNested<A> editLastInterceptor() {
    int index = interceptors.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "interceptors"));
    }
    return this.setNewInterceptorLike(index, this.buildInterceptor(index));
  }
  
  public InterceptorsNested<A> editMatchingInterceptor(Predicate<TriggerInterceptorBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < interceptors.size();i++) {
      if (predicate.test(interceptors.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "interceptors"));
    }
    return this.setNewInterceptorLike(index, this.buildInterceptor(index));
  }
  
  public TriggerSelectorNested<A> editOrNewTriggerSelector() {
    return this.withNewTriggerSelectorLike(Optional.ofNullable(this.buildTriggerSelector()).orElse(new EventListenerTriggerSelectorBuilder().build()));
  }
  
  public TriggerSelectorNested<A> editOrNewTriggerSelectorLike(EventListenerTriggerSelector item) {
    return this.withNewTriggerSelectorLike(Optional.ofNullable(this.buildTriggerSelector()).orElse(item));
  }
  
  public TriggerSelectorNested<A> editTriggerSelector() {
    return this.withNewTriggerSelectorLike(Optional.ofNullable(this.buildTriggerSelector()).orElse(null));
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
    EventListenerTriggerGroupFluent that = (EventListenerTriggerGroupFluent) o;
    if (!(Objects.equals(interceptors, that.interceptors))) {
      return false;
    }
    if (!(Objects.equals(name, that.name))) {
      return false;
    }
    if (!(Objects.equals(triggerSelector, that.triggerSelector))) {
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
  
  public String getName() {
    return this.name;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasInterceptors() {
    return this.interceptors != null && !(this.interceptors.isEmpty());
  }
  
  public boolean hasMatchingInterceptor(Predicate<TriggerInterceptorBuilder> predicate) {
      for (TriggerInterceptorBuilder item : interceptors) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasName() {
    return this.name != null;
  }
  
  public boolean hasTriggerSelector() {
    return this.triggerSelector != null;
  }
  
  public int hashCode() {
    return Objects.hash(interceptors, name, triggerSelector, additionalProperties);
  }
  
  public A removeAllFromInterceptors(Collection<TriggerInterceptor> items) {
    if (this.interceptors == null) {
      return (A) this;
    }
    for (TriggerInterceptor item : items) {
        TriggerInterceptorBuilder builder = new TriggerInterceptorBuilder(item);
        _visitables.get("interceptors").remove(builder);
        this.interceptors.remove(builder);
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
  
  public A removeFromInterceptors(TriggerInterceptor... items) {
    if (this.interceptors == null) {
      return (A) this;
    }
    for (TriggerInterceptor item : items) {
        TriggerInterceptorBuilder builder = new TriggerInterceptorBuilder(item);
        _visitables.get("interceptors").remove(builder);
        this.interceptors.remove(builder);
    }
    return (A) this;
  }
  
  public A removeMatchingFromInterceptors(Predicate<TriggerInterceptorBuilder> predicate) {
    if (interceptors == null) {
      return (A) this;
    }
    Iterator<TriggerInterceptorBuilder> each = interceptors.iterator();
    List visitables = _visitables.get("interceptors");
    while (each.hasNext()) {
        TriggerInterceptorBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public InterceptorsNested<A> setNewInterceptorLike(int index,TriggerInterceptor item) {
    return new InterceptorsNested(index, item);
  }
  
  public A setToInterceptors(int index,TriggerInterceptor item) {
    if (this.interceptors == null) {
      this.interceptors = new ArrayList();
    }
    TriggerInterceptorBuilder builder = new TriggerInterceptorBuilder(item);
    if (index < 0 || index >= interceptors.size()) {
        _visitables.get("interceptors").add(builder);
        interceptors.add(builder);
    } else {
        _visitables.get("interceptors").add(builder);
        interceptors.set(index, builder);
    }
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(interceptors == null) && !(interceptors.isEmpty())) {
        sb.append("interceptors:");
        sb.append(interceptors);
        sb.append(",");
    }
    if (!(name == null)) {
        sb.append("name:");
        sb.append(name);
        sb.append(",");
    }
    if (!(triggerSelector == null)) {
        sb.append("triggerSelector:");
        sb.append(triggerSelector);
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
  
  public A withInterceptors(List<TriggerInterceptor> interceptors) {
    if (this.interceptors != null) {
      this._visitables.get("interceptors").clear();
    }
    if (interceptors != null) {
        this.interceptors = new ArrayList();
        for (TriggerInterceptor item : interceptors) {
          this.addToInterceptors(item);
        }
    } else {
      this.interceptors = null;
    }
    return (A) this;
  }
  
  public A withInterceptors(TriggerInterceptor... interceptors) {
    if (this.interceptors != null) {
        this.interceptors.clear();
        _visitables.remove("interceptors");
    }
    if (interceptors != null) {
      for (TriggerInterceptor item : interceptors) {
        this.addToInterceptors(item);
      }
    }
    return (A) this;
  }
  
  public A withName(String name) {
    this.name = name;
    return (A) this;
  }
  
  public TriggerSelectorNested<A> withNewTriggerSelector() {
    return new TriggerSelectorNested(null);
  }
  
  public TriggerSelectorNested<A> withNewTriggerSelectorLike(EventListenerTriggerSelector item) {
    return new TriggerSelectorNested(item);
  }
  
  public A withTriggerSelector(EventListenerTriggerSelector triggerSelector) {
    this._visitables.remove("triggerSelector");
    if (triggerSelector != null) {
        this.triggerSelector = new EventListenerTriggerSelectorBuilder(triggerSelector);
        this._visitables.get("triggerSelector").add(this.triggerSelector);
    } else {
        this.triggerSelector = null;
        this._visitables.get("triggerSelector").remove(this.triggerSelector);
    }
    return (A) this;
  }
  public class InterceptorsNested<N> extends TriggerInterceptorFluent<InterceptorsNested<N>> implements Nested<N>{
  
    TriggerInterceptorBuilder builder;
    int index;
  
    InterceptorsNested(int index,TriggerInterceptor item) {
      this.index = index;
      this.builder = new TriggerInterceptorBuilder(this, item);
    }
  
    public N and() {
      return (N) EventListenerTriggerGroupFluent.this.setToInterceptors(index, builder.build());
    }
    
    public N endInterceptor() {
      return and();
    }
    
  }
  public class TriggerSelectorNested<N> extends EventListenerTriggerSelectorFluent<TriggerSelectorNested<N>> implements Nested<N>{
  
    EventListenerTriggerSelectorBuilder builder;
  
    TriggerSelectorNested(EventListenerTriggerSelector item) {
      this.builder = new EventListenerTriggerSelectorBuilder(this, item);
    }
  
    public N and() {
      return (N) EventListenerTriggerGroupFluent.this.withTriggerSelector(builder.build());
    }
    
    public N endTriggerSelector() {
      return and();
    }
    
  }
}