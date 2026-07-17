package io.fabric8.openshift.api.model.config.v1;

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
public class ClusterConditionFluent<A extends io.fabric8.openshift.api.model.config.v1.ClusterConditionFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private PromQLClusterConditionBuilder promql;
  private String type;

  public ClusterConditionFluent() {
  }
  
  public ClusterConditionFluent(ClusterCondition instance) {
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
  
  public PromQLClusterCondition buildPromql() {
    return this.promql != null ? this.promql.build() : null;
  }
  
  protected void copyInstance(ClusterCondition instance) {
    instance = instance != null ? instance : new ClusterCondition();
    if (instance != null) {
        this.withPromql(instance.getPromql());
        this.withType(instance.getType());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public PromqlNested<A> editOrNewPromql() {
    return this.withNewPromqlLike(Optional.ofNullable(this.buildPromql()).orElse(new PromQLClusterConditionBuilder().build()));
  }
  
  public PromqlNested<A> editOrNewPromqlLike(PromQLClusterCondition item) {
    return this.withNewPromqlLike(Optional.ofNullable(this.buildPromql()).orElse(item));
  }
  
  public PromqlNested<A> editPromql() {
    return this.withNewPromqlLike(Optional.ofNullable(this.buildPromql()).orElse(null));
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
    ClusterConditionFluent that = (ClusterConditionFluent) o;
    if (!(Objects.equals(promql, that.promql))) {
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
  
  public boolean hasPromql() {
    return this.promql != null;
  }
  
  public boolean hasType() {
    return this.type != null;
  }
  
  public int hashCode() {
    return Objects.hash(promql, type, additionalProperties);
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
    if (!(promql == null)) {
        sb.append("promql:");
        sb.append(promql);
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
  
  public PromqlNested<A> withNewPromql() {
    return new PromqlNested(null);
  }
  
  public A withNewPromql(String promql) {
    return (A) this.withPromql(new PromQLClusterCondition(promql));
  }
  
  public PromqlNested<A> withNewPromqlLike(PromQLClusterCondition item) {
    return new PromqlNested(item);
  }
  
  public A withPromql(PromQLClusterCondition promql) {
    this._visitables.remove("promql");
    if (promql != null) {
        this.promql = new PromQLClusterConditionBuilder(promql);
        this._visitables.get("promql").add(this.promql);
    } else {
        this.promql = null;
        this._visitables.get("promql").remove(this.promql);
    }
    return (A) this;
  }
  
  public A withType(String type) {
    this.type = type;
    return (A) this;
  }
  public class PromqlNested<N> extends PromQLClusterConditionFluent<PromqlNested<N>> implements Nested<N>{
  
    PromQLClusterConditionBuilder builder;
  
    PromqlNested(PromQLClusterCondition item) {
      this.builder = new PromQLClusterConditionBuilder(this, item);
    }
  
    public N and() {
      return (N) ClusterConditionFluent.this.withPromql(builder.build());
    }
    
    public N endPromql() {
      return and();
    }
    
  }
}