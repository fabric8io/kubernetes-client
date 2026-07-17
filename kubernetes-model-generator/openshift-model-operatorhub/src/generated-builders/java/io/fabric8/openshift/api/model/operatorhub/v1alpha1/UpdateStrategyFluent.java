package io.fabric8.openshift.api.model.operatorhub.v1alpha1;

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
public class UpdateStrategyFluent<A extends io.fabric8.openshift.api.model.operatorhub.v1alpha1.UpdateStrategyFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private RegistryPollBuilder registryPoll;

  public UpdateStrategyFluent() {
  }
  
  public UpdateStrategyFluent(UpdateStrategy instance) {
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
  
  public RegistryPoll buildRegistryPoll() {
    return this.registryPoll != null ? this.registryPoll.build() : null;
  }
  
  protected void copyInstance(UpdateStrategy instance) {
    instance = instance != null ? instance : new UpdateStrategy();
    if (instance != null) {
        this.withRegistryPoll(instance.getRegistryPoll());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public RegistryPollNested<A> editOrNewRegistryPoll() {
    return this.withNewRegistryPollLike(Optional.ofNullable(this.buildRegistryPoll()).orElse(new RegistryPollBuilder().build()));
  }
  
  public RegistryPollNested<A> editOrNewRegistryPollLike(RegistryPoll item) {
    return this.withNewRegistryPollLike(Optional.ofNullable(this.buildRegistryPoll()).orElse(item));
  }
  
  public RegistryPollNested<A> editRegistryPoll() {
    return this.withNewRegistryPollLike(Optional.ofNullable(this.buildRegistryPoll()).orElse(null));
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
    UpdateStrategyFluent that = (UpdateStrategyFluent) o;
    if (!(Objects.equals(registryPoll, that.registryPoll))) {
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
  
  public boolean hasRegistryPoll() {
    return this.registryPoll != null;
  }
  
  public int hashCode() {
    return Objects.hash(registryPoll, additionalProperties);
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
    if (!(registryPoll == null)) {
        sb.append("registryPoll:");
        sb.append(registryPoll);
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
  
  public RegistryPollNested<A> withNewRegistryPoll() {
    return new RegistryPollNested(null);
  }
  
  public A withNewRegistryPoll(String interval) {
    return (A) this.withRegistryPoll(new RegistryPoll(interval));
  }
  
  public RegistryPollNested<A> withNewRegistryPollLike(RegistryPoll item) {
    return new RegistryPollNested(item);
  }
  
  public A withRegistryPoll(RegistryPoll registryPoll) {
    this._visitables.remove("registryPoll");
    if (registryPoll != null) {
        this.registryPoll = new RegistryPollBuilder(registryPoll);
        this._visitables.get("registryPoll").add(this.registryPoll);
    } else {
        this.registryPoll = null;
        this._visitables.get("registryPoll").remove(this.registryPoll);
    }
    return (A) this;
  }
  public class RegistryPollNested<N> extends RegistryPollFluent<RegistryPollNested<N>> implements Nested<N>{
  
    RegistryPollBuilder builder;
  
    RegistryPollNested(RegistryPoll item) {
      this.builder = new RegistryPollBuilder(this, item);
    }
  
    public N and() {
      return (N) UpdateStrategyFluent.this.withRegistryPoll(builder.build());
    }
    
    public N endRegistryPoll() {
      return and();
    }
    
  }
}