package io.fabric8.openshift.api.model;

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
public class RouteHTTPHeadersFluent<A extends io.fabric8.openshift.api.model.RouteHTTPHeadersFluent<A>> extends BaseFluent<A>{

  private RouteHTTPHeaderActionsBuilder actions;
  private Map<String,Object> additionalProperties;

  public RouteHTTPHeadersFluent() {
  }
  
  public RouteHTTPHeadersFluent(RouteHTTPHeaders instance) {
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
  
  public RouteHTTPHeaderActions buildActions() {
    return this.actions != null ? this.actions.build() : null;
  }
  
  protected void copyInstance(RouteHTTPHeaders instance) {
    instance = instance != null ? instance : new RouteHTTPHeaders();
    if (instance != null) {
        this.withActions(instance.getActions());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public ActionsNested<A> editActions() {
    return this.withNewActionsLike(Optional.ofNullable(this.buildActions()).orElse(null));
  }
  
  public ActionsNested<A> editOrNewActions() {
    return this.withNewActionsLike(Optional.ofNullable(this.buildActions()).orElse(new RouteHTTPHeaderActionsBuilder().build()));
  }
  
  public ActionsNested<A> editOrNewActionsLike(RouteHTTPHeaderActions item) {
    return this.withNewActionsLike(Optional.ofNullable(this.buildActions()).orElse(item));
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
    RouteHTTPHeadersFluent that = (RouteHTTPHeadersFluent) o;
    if (!(Objects.equals(actions, that.actions))) {
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
  
  public boolean hasActions() {
    return this.actions != null;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public int hashCode() {
    return Objects.hash(actions, additionalProperties);
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
    if (!(actions == null)) {
        sb.append("actions:");
        sb.append(actions);
        sb.append(",");
    }
    if (!(additionalProperties == null) && !(additionalProperties.isEmpty())) {
        sb.append("additionalProperties:");
        sb.append(additionalProperties);
    }
    sb.append("}");
    return sb.toString();
  }
  
  public A withActions(RouteHTTPHeaderActions actions) {
    this._visitables.remove("actions");
    if (actions != null) {
        this.actions = new RouteHTTPHeaderActionsBuilder(actions);
        this._visitables.get("actions").add(this.actions);
    } else {
        this.actions = null;
        this._visitables.get("actions").remove(this.actions);
    }
    return (A) this;
  }
  
  public <K,V>A withAdditionalProperties(Map<String,Object> additionalProperties) {
    if (additionalProperties == null) {
      this.additionalProperties = null;
    } else {
      this.additionalProperties = new LinkedHashMap(additionalProperties);
    }
    return (A) this;
  }
  
  public ActionsNested<A> withNewActions() {
    return new ActionsNested(null);
  }
  
  public ActionsNested<A> withNewActionsLike(RouteHTTPHeaderActions item) {
    return new ActionsNested(item);
  }
  public class ActionsNested<N> extends RouteHTTPHeaderActionsFluent<ActionsNested<N>> implements Nested<N>{
  
    RouteHTTPHeaderActionsBuilder builder;
  
    ActionsNested(RouteHTTPHeaderActions item) {
      this.builder = new RouteHTTPHeaderActionsBuilder(this, item);
    }
  
    public N and() {
      return (N) RouteHTTPHeadersFluent.this.withActions(builder.build());
    }
    
    public N endActions() {
      return and();
    }
    
  }
}