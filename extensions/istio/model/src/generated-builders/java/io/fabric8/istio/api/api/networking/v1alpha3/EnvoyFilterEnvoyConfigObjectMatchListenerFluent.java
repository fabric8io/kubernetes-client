package io.fabric8.istio.api.api.networking.v1alpha3;

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
public class EnvoyFilterEnvoyConfigObjectMatchListenerFluent<A extends io.fabric8.istio.api.api.networking.v1alpha3.EnvoyFilterEnvoyConfigObjectMatchListenerFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private EnvoyFilterListenerMatchBuilder listener;

  public EnvoyFilterEnvoyConfigObjectMatchListenerFluent() {
  }
  
  public EnvoyFilterEnvoyConfigObjectMatchListenerFluent(EnvoyFilterEnvoyConfigObjectMatchListener instance) {
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
  
  public EnvoyFilterListenerMatch buildListener() {
    return this.listener != null ? this.listener.build() : null;
  }
  
  protected void copyInstance(EnvoyFilterEnvoyConfigObjectMatchListener instance) {
    instance = instance != null ? instance : new EnvoyFilterEnvoyConfigObjectMatchListener();
    if (instance != null) {
        this.withListener(instance.getListener());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public ListenerNested<A> editListener() {
    return this.withNewListenerLike(Optional.ofNullable(this.buildListener()).orElse(null));
  }
  
  public ListenerNested<A> editOrNewListener() {
    return this.withNewListenerLike(Optional.ofNullable(this.buildListener()).orElse(new EnvoyFilterListenerMatchBuilder().build()));
  }
  
  public ListenerNested<A> editOrNewListenerLike(EnvoyFilterListenerMatch item) {
    return this.withNewListenerLike(Optional.ofNullable(this.buildListener()).orElse(item));
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
    EnvoyFilterEnvoyConfigObjectMatchListenerFluent that = (EnvoyFilterEnvoyConfigObjectMatchListenerFluent) o;
    if (!(Objects.equals(listener, that.listener))) {
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
  
  public boolean hasListener() {
    return this.listener != null;
  }
  
  public int hashCode() {
    return Objects.hash(listener, additionalProperties);
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
    if (!(listener == null)) {
        sb.append("listener:");
        sb.append(listener);
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
  
  public A withListener(EnvoyFilterListenerMatch listener) {
    this._visitables.remove("listener");
    if (listener != null) {
        this.listener = new EnvoyFilterListenerMatchBuilder(listener);
        this._visitables.get("listener").add(this.listener);
    } else {
        this.listener = null;
        this._visitables.get("listener").remove(this.listener);
    }
    return (A) this;
  }
  
  public ListenerNested<A> withNewListener() {
    return new ListenerNested(null);
  }
  
  public ListenerNested<A> withNewListenerLike(EnvoyFilterListenerMatch item) {
    return new ListenerNested(item);
  }
  public class ListenerNested<N> extends EnvoyFilterListenerMatchFluent<ListenerNested<N>> implements Nested<N>{
  
    EnvoyFilterListenerMatchBuilder builder;
  
    ListenerNested(EnvoyFilterListenerMatch item) {
      this.builder = new EnvoyFilterListenerMatchBuilder(this, item);
    }
  
    public N and() {
      return (N) EnvoyFilterEnvoyConfigObjectMatchListenerFluent.this.withListener(builder.build());
    }
    
    public N endListener() {
      return and();
    }
    
  }
}