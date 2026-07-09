package io.fabric8.kubernetes.api.model.apps;

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
public class StatefulSetUpdateStrategyFluent<A extends io.fabric8.kubernetes.api.model.apps.StatefulSetUpdateStrategyFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private RollingUpdateStatefulSetStrategyBuilder rollingUpdate;
  private String type;

  public StatefulSetUpdateStrategyFluent() {
  }
  
  public StatefulSetUpdateStrategyFluent(StatefulSetUpdateStrategy instance) {
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
  
  public RollingUpdateStatefulSetStrategy buildRollingUpdate() {
    return this.rollingUpdate != null ? this.rollingUpdate.build() : null;
  }
  
  protected void copyInstance(StatefulSetUpdateStrategy instance) {
    instance = instance != null ? instance : new StatefulSetUpdateStrategy();
    if (instance != null) {
        this.withRollingUpdate(instance.getRollingUpdate());
        this.withType(instance.getType());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public RollingUpdateNested<A> editOrNewRollingUpdate() {
    return this.withNewRollingUpdateLike(Optional.ofNullable(this.buildRollingUpdate()).orElse(new RollingUpdateStatefulSetStrategyBuilder().build()));
  }
  
  public RollingUpdateNested<A> editOrNewRollingUpdateLike(RollingUpdateStatefulSetStrategy item) {
    return this.withNewRollingUpdateLike(Optional.ofNullable(this.buildRollingUpdate()).orElse(item));
  }
  
  public RollingUpdateNested<A> editRollingUpdate() {
    return this.withNewRollingUpdateLike(Optional.ofNullable(this.buildRollingUpdate()).orElse(null));
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
    StatefulSetUpdateStrategyFluent that = (StatefulSetUpdateStrategyFluent) o;
    if (!(Objects.equals(rollingUpdate, that.rollingUpdate))) {
      return false;
    }
    if (!(Objects.equals(type, that.type))) {
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
  
  public String getType() {
    return this.type;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasRollingUpdate() {
    return this.rollingUpdate != null;
  }
  
  public boolean hasType() {
    return this.type != null;
  }
  
  public int hashCode() {
    return Objects.hash(rollingUpdate, type, additionalProperties);
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
    if (!(rollingUpdate == null)) {
        sb.append("rollingUpdate:");
        sb.append(rollingUpdate);
        sb.append(",");
    }
    if (!(type == null)) {
        sb.append("type:");
        sb.append(type);
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
  
  public RollingUpdateNested<A> withNewRollingUpdate() {
    return new RollingUpdateNested(null);
  }
  
  public RollingUpdateNested<A> withNewRollingUpdateLike(RollingUpdateStatefulSetStrategy item) {
    return new RollingUpdateNested(item);
  }
  
  public A withRollingUpdate(RollingUpdateStatefulSetStrategy rollingUpdate) {
    this._visitables.remove("rollingUpdate");
    if (rollingUpdate != null) {
        this.rollingUpdate = new RollingUpdateStatefulSetStrategyBuilder(rollingUpdate);
        this._visitables.get("rollingUpdate").add(this.rollingUpdate);
    } else {
        this.rollingUpdate = null;
        this._visitables.get("rollingUpdate").remove(this.rollingUpdate);
    }
    return (A) this;
  }
  
  public A withType(String type) {
    this.type = type;
    return (A) this;
  }
  public class RollingUpdateNested<N> extends RollingUpdateStatefulSetStrategyFluent<RollingUpdateNested<N>> implements Nested<N>{
  
    RollingUpdateStatefulSetStrategyBuilder builder;
  
    RollingUpdateNested(RollingUpdateStatefulSetStrategy item) {
      this.builder = new RollingUpdateStatefulSetStrategyBuilder(this, item);
    }
  
    public N and() {
      return (N) StatefulSetUpdateStrategyFluent.this.withRollingUpdate(builder.build());
    }
    
    public N endRollingUpdate() {
      return and();
    }
    
  }
}