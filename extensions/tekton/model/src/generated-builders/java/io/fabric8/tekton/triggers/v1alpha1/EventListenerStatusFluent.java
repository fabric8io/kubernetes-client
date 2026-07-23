package io.fabric8.tekton.triggers.v1alpha1;

import io.fabric8.knative.duck.v1alpha1.Addressable;
import io.fabric8.knative.pkg.apis.Condition;
import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import java.lang.Long;
import java.lang.Object;
import java.lang.String;
import java.lang.StringBuilder;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collection;
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
public class EventListenerStatusFluent<A extends io.fabric8.tekton.triggers.v1alpha1.EventListenerStatusFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private Addressable address;
  private List<Addressable> addresses = new ArrayList<Addressable>();
  private Map<String,String> annotations;
  private List<Condition> conditions = new ArrayList<Condition>();
  private EventListenerConfigBuilder configuration;
  private Long observedGeneration;

  public EventListenerStatusFluent() {
  }
  
  public EventListenerStatusFluent(EventListenerStatus instance) {
    this.copyInstance(instance);
  }

  public A addAllToAddresses(Collection<Addressable> items) {
    if (this.addresses == null) {
      this.addresses = new ArrayList();
    }
    for (Addressable item : items) {
      this.addresses.add(item);
    }
    return (A) this;
  }
  
  public A addAllToConditions(Collection<Condition> items) {
    if (this.conditions == null) {
      this.conditions = new ArrayList();
    }
    for (Condition item : items) {
      this.conditions.add(item);
    }
    return (A) this;
  }
  
  public A addNewAddress(String cACerts,String hostname,String name,String url) {
    return (A) this.addToAddresses(new Addressable(cACerts, hostname, name, url));
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
  
  public A addToAddresses(Addressable... items) {
    if (this.addresses == null) {
      this.addresses = new ArrayList();
    }
    for (Addressable item : items) {
      this.addresses.add(item);
    }
    return (A) this;
  }
  
  public A addToAddresses(int index,Addressable item) {
    if (this.addresses == null) {
      this.addresses = new ArrayList();
    }
    this.addresses.add(index, item);
    return (A) this;
  }
  
  public A addToAnnotations(Map<String,String> map) {
    if (this.annotations == null && map != null) {
      this.annotations = new LinkedHashMap();
    }
    if (map != null) {
      this.annotations.putAll(map);
    }
    return (A) this;
  }
  
  public A addToAnnotations(String key,String value) {
    if (this.annotations == null && key != null && value != null) {
      this.annotations = new LinkedHashMap();
    }
    if (key != null && value != null) {
      this.annotations.put(key, value);
    }
    return (A) this;
  }
  
  public A addToConditions(Condition... items) {
    if (this.conditions == null) {
      this.conditions = new ArrayList();
    }
    for (Condition item : items) {
      this.conditions.add(item);
    }
    return (A) this;
  }
  
  public A addToConditions(int index,Condition item) {
    if (this.conditions == null) {
      this.conditions = new ArrayList();
    }
    this.conditions.add(index, item);
    return (A) this;
  }
  
  public EventListenerConfig buildConfiguration() {
    return this.configuration != null ? this.configuration.build() : null;
  }
  
  protected void copyInstance(EventListenerStatus instance) {
    instance = instance != null ? instance : new EventListenerStatus();
    if (instance != null) {
        this.withAddress(instance.getAddress());
        this.withAddresses(instance.getAddresses());
        this.withAnnotations(instance.getAnnotations());
        this.withConditions(instance.getConditions());
        this.withConfiguration(instance.getConfiguration());
        this.withObservedGeneration(instance.getObservedGeneration());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public ConfigurationNested<A> editConfiguration() {
    return this.withNewConfigurationLike(Optional.ofNullable(this.buildConfiguration()).orElse(null));
  }
  
  public ConfigurationNested<A> editOrNewConfiguration() {
    return this.withNewConfigurationLike(Optional.ofNullable(this.buildConfiguration()).orElse(new EventListenerConfigBuilder().build()));
  }
  
  public ConfigurationNested<A> editOrNewConfigurationLike(EventListenerConfig item) {
    return this.withNewConfigurationLike(Optional.ofNullable(this.buildConfiguration()).orElse(item));
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
    EventListenerStatusFluent that = (EventListenerStatusFluent) o;
    if (!(Objects.equals(address, that.address))) {
      return false;
    }
    if (!(Objects.equals(addresses, that.addresses))) {
      return false;
    }
    if (!(Objects.equals(annotations, that.annotations))) {
      return false;
    }
    if (!(Objects.equals(conditions, that.conditions))) {
      return false;
    }
    if (!(Objects.equals(configuration, that.configuration))) {
      return false;
    }
    if (!(Objects.equals(observedGeneration, that.observedGeneration))) {
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
  
  public Addressable getAddress() {
    return this.address;
  }
  
  public Addressable getAddress(int index) {
    return this.addresses.get(index);
  }
  
  public List<Addressable> getAddresses() {
    return this.addresses;
  }
  
  public Map<String,String> getAnnotations() {
    return this.annotations;
  }
  
  public Condition getCondition(int index) {
    return this.conditions.get(index);
  }
  
  public List<Condition> getConditions() {
    return this.conditions;
  }
  
  public Addressable getFirstAddress() {
    return this.addresses.get(0);
  }
  
  public Condition getFirstCondition() {
    return this.conditions.get(0);
  }
  
  public Addressable getLastAddress() {
    return this.addresses.get(addresses.size() - 1);
  }
  
  public Condition getLastCondition() {
    return this.conditions.get(conditions.size() - 1);
  }
  
  public Addressable getMatchingAddress(Predicate<Addressable> predicate) {
      for (Addressable item : addresses) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public Condition getMatchingCondition(Predicate<Condition> predicate) {
      for (Condition item : conditions) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public Long getObservedGeneration() {
    return this.observedGeneration;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasAddress() {
    return this.address != null;
  }
  
  public boolean hasAddresses() {
    return this.addresses != null && !(this.addresses.isEmpty());
  }
  
  public boolean hasAnnotations() {
    return this.annotations != null;
  }
  
  public boolean hasConditions() {
    return this.conditions != null && !(this.conditions.isEmpty());
  }
  
  public boolean hasConfiguration() {
    return this.configuration != null;
  }
  
  public boolean hasMatchingAddress(Predicate<Addressable> predicate) {
      for (Addressable item : addresses) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingCondition(Predicate<Condition> predicate) {
      for (Condition item : conditions) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasObservedGeneration() {
    return this.observedGeneration != null;
  }
  
  public int hashCode() {
    return Objects.hash(address, addresses, annotations, conditions, configuration, observedGeneration, additionalProperties);
  }
  
  public A removeAllFromAddresses(Collection<Addressable> items) {
    if (this.addresses == null) {
      return (A) this;
    }
    for (Addressable item : items) {
      this.addresses.remove(item);
    }
    return (A) this;
  }
  
  public A removeAllFromConditions(Collection<Condition> items) {
    if (this.conditions == null) {
      return (A) this;
    }
    for (Condition item : items) {
      this.conditions.remove(item);
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
  
  public A removeFromAddresses(Addressable... items) {
    if (this.addresses == null) {
      return (A) this;
    }
    for (Addressable item : items) {
      this.addresses.remove(item);
    }
    return (A) this;
  }
  
  public A removeFromAnnotations(String key) {
    if (this.annotations == null) {
      return (A) this;
    }
    if (key != null && this.annotations != null) {
      this.annotations.remove(key);
    }
    return (A) this;
  }
  
  public A removeFromAnnotations(Map<String,String> map) {
    if (this.annotations == null) {
      return (A) this;
    }
    if (map != null) {
      for (Object key : map.keySet()) {
        if (this.annotations != null) {
          this.annotations.remove(key);
        }
      }
    }
    return (A) this;
  }
  
  public A removeFromConditions(Condition... items) {
    if (this.conditions == null) {
      return (A) this;
    }
    for (Condition item : items) {
      this.conditions.remove(item);
    }
    return (A) this;
  }
  
  public A setToAddresses(int index,Addressable item) {
    if (this.addresses == null) {
      this.addresses = new ArrayList();
    }
    this.addresses.set(index, item);
    return (A) this;
  }
  
  public A setToConditions(int index,Condition item) {
    if (this.conditions == null) {
      this.conditions = new ArrayList();
    }
    this.conditions.set(index, item);
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(address == null)) {
        sb.append("address:");
        sb.append(address);
        sb.append(",");
    }
    if (!(addresses == null) && !(addresses.isEmpty())) {
        sb.append("addresses:");
        sb.append(addresses);
        sb.append(",");
    }
    if (!(annotations == null) && !(annotations.isEmpty())) {
        sb.append("annotations:");
        sb.append(annotations);
        sb.append(",");
    }
    if (!(conditions == null) && !(conditions.isEmpty())) {
        sb.append("conditions:");
        sb.append(conditions);
        sb.append(",");
    }
    if (!(configuration == null)) {
        sb.append("configuration:");
        sb.append(configuration);
        sb.append(",");
    }
    if (!(observedGeneration == null)) {
        sb.append("observedGeneration:");
        sb.append(observedGeneration);
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
  
  public A withAddress(Addressable address) {
    this.address = address;
    return (A) this;
  }
  
  public A withAddresses(List<Addressable> addresses) {
    if (addresses != null) {
        this.addresses = new ArrayList();
        for (Addressable item : addresses) {
          this.addToAddresses(item);
        }
    } else {
      this.addresses = null;
    }
    return (A) this;
  }
  
  public A withAddresses(Addressable... addresses) {
    if (this.addresses != null) {
        this.addresses.clear();
        _visitables.remove("addresses");
    }
    if (addresses != null) {
      for (Addressable item : addresses) {
        this.addToAddresses(item);
      }
    }
    return (A) this;
  }
  
  public <K,V>A withAnnotations(Map<String,String> annotations) {
    if (annotations == null) {
      this.annotations = null;
    } else {
      this.annotations = new LinkedHashMap(annotations);
    }
    return (A) this;
  }
  
  public A withConditions(List<Condition> conditions) {
    if (conditions != null) {
        this.conditions = new ArrayList();
        for (Condition item : conditions) {
          this.addToConditions(item);
        }
    } else {
      this.conditions = null;
    }
    return (A) this;
  }
  
  public A withConditions(Condition... conditions) {
    if (this.conditions != null) {
        this.conditions.clear();
        _visitables.remove("conditions");
    }
    if (conditions != null) {
      for (Condition item : conditions) {
        this.addToConditions(item);
      }
    }
    return (A) this;
  }
  
  public A withConfiguration(EventListenerConfig configuration) {
    this._visitables.remove("configuration");
    if (configuration != null) {
        this.configuration = new EventListenerConfigBuilder(configuration);
        this._visitables.get("configuration").add(this.configuration);
    } else {
        this.configuration = null;
        this._visitables.get("configuration").remove(this.configuration);
    }
    return (A) this;
  }
  
  public A withNewAddress(String cACerts,String hostname,String name,String url) {
    return (A) this.withAddress(new Addressable(cACerts, hostname, name, url));
  }
  
  public ConfigurationNested<A> withNewConfiguration() {
    return new ConfigurationNested(null);
  }
  
  public A withNewConfiguration(String generatedName) {
    return (A) this.withConfiguration(new EventListenerConfig(generatedName));
  }
  
  public ConfigurationNested<A> withNewConfigurationLike(EventListenerConfig item) {
    return new ConfigurationNested(item);
  }
  
  public A withObservedGeneration(Long observedGeneration) {
    this.observedGeneration = observedGeneration;
    return (A) this;
  }
  public class ConfigurationNested<N> extends EventListenerConfigFluent<ConfigurationNested<N>> implements Nested<N>{
  
    EventListenerConfigBuilder builder;
  
    ConfigurationNested(EventListenerConfig item) {
      this.builder = new EventListenerConfigBuilder(this, item);
    }
  
    public N and() {
      return (N) EventListenerStatusFluent.this.withConfiguration(builder.build());
    }
    
    public N endConfiguration() {
      return and();
    }
    
  }
}