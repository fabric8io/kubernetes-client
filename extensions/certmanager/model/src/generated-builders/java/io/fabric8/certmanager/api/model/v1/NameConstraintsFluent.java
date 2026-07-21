package io.fabric8.certmanager.api.model.v1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import java.lang.Boolean;
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
public class NameConstraintsFluent<A extends io.fabric8.certmanager.api.model.v1.NameConstraintsFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private Boolean critical;
  private NameConstraintItemBuilder excluded;
  private NameConstraintItemBuilder permitted;

  public NameConstraintsFluent() {
  }
  
  public NameConstraintsFluent(NameConstraints instance) {
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
  
  public NameConstraintItem buildExcluded() {
    return this.excluded != null ? this.excluded.build() : null;
  }
  
  public NameConstraintItem buildPermitted() {
    return this.permitted != null ? this.permitted.build() : null;
  }
  
  protected void copyInstance(NameConstraints instance) {
    instance = instance != null ? instance : new NameConstraints();
    if (instance != null) {
        this.withCritical(instance.getCritical());
        this.withExcluded(instance.getExcluded());
        this.withPermitted(instance.getPermitted());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public ExcludedNested<A> editExcluded() {
    return this.withNewExcludedLike(Optional.ofNullable(this.buildExcluded()).orElse(null));
  }
  
  public ExcludedNested<A> editOrNewExcluded() {
    return this.withNewExcludedLike(Optional.ofNullable(this.buildExcluded()).orElse(new NameConstraintItemBuilder().build()));
  }
  
  public ExcludedNested<A> editOrNewExcludedLike(NameConstraintItem item) {
    return this.withNewExcludedLike(Optional.ofNullable(this.buildExcluded()).orElse(item));
  }
  
  public PermittedNested<A> editOrNewPermitted() {
    return this.withNewPermittedLike(Optional.ofNullable(this.buildPermitted()).orElse(new NameConstraintItemBuilder().build()));
  }
  
  public PermittedNested<A> editOrNewPermittedLike(NameConstraintItem item) {
    return this.withNewPermittedLike(Optional.ofNullable(this.buildPermitted()).orElse(item));
  }
  
  public PermittedNested<A> editPermitted() {
    return this.withNewPermittedLike(Optional.ofNullable(this.buildPermitted()).orElse(null));
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
    NameConstraintsFluent that = (NameConstraintsFluent) o;
    if (!(Objects.equals(critical, that.critical))) {
      return false;
    }
    if (!(Objects.equals(excluded, that.excluded))) {
      return false;
    }
    if (!(Objects.equals(permitted, that.permitted))) {
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
  
  public Boolean getCritical() {
    return this.critical;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasCritical() {
    return this.critical != null;
  }
  
  public boolean hasExcluded() {
    return this.excluded != null;
  }
  
  public boolean hasPermitted() {
    return this.permitted != null;
  }
  
  public int hashCode() {
    return Objects.hash(critical, excluded, permitted, additionalProperties);
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
    if (!(critical == null)) {
        sb.append("critical:");
        sb.append(critical);
        sb.append(",");
    }
    if (!(excluded == null)) {
        sb.append("excluded:");
        sb.append(excluded);
        sb.append(",");
    }
    if (!(permitted == null)) {
        sb.append("permitted:");
        sb.append(permitted);
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
  
  public A withCritical() {
    return withCritical(true);
  }
  
  public A withCritical(Boolean critical) {
    this.critical = critical;
    return (A) this;
  }
  
  public A withExcluded(NameConstraintItem excluded) {
    this._visitables.remove("excluded");
    if (excluded != null) {
        this.excluded = new NameConstraintItemBuilder(excluded);
        this._visitables.get("excluded").add(this.excluded);
    } else {
        this.excluded = null;
        this._visitables.get("excluded").remove(this.excluded);
    }
    return (A) this;
  }
  
  public ExcludedNested<A> withNewExcluded() {
    return new ExcludedNested(null);
  }
  
  public ExcludedNested<A> withNewExcludedLike(NameConstraintItem item) {
    return new ExcludedNested(item);
  }
  
  public PermittedNested<A> withNewPermitted() {
    return new PermittedNested(null);
  }
  
  public PermittedNested<A> withNewPermittedLike(NameConstraintItem item) {
    return new PermittedNested(item);
  }
  
  public A withPermitted(NameConstraintItem permitted) {
    this._visitables.remove("permitted");
    if (permitted != null) {
        this.permitted = new NameConstraintItemBuilder(permitted);
        this._visitables.get("permitted").add(this.permitted);
    } else {
        this.permitted = null;
        this._visitables.get("permitted").remove(this.permitted);
    }
    return (A) this;
  }
  public class ExcludedNested<N> extends NameConstraintItemFluent<ExcludedNested<N>> implements Nested<N>{
  
    NameConstraintItemBuilder builder;
  
    ExcludedNested(NameConstraintItem item) {
      this.builder = new NameConstraintItemBuilder(this, item);
    }
  
    public N and() {
      return (N) NameConstraintsFluent.this.withExcluded(builder.build());
    }
    
    public N endExcluded() {
      return and();
    }
    
  }
  public class PermittedNested<N> extends NameConstraintItemFluent<PermittedNested<N>> implements Nested<N>{
  
    NameConstraintItemBuilder builder;
  
    PermittedNested(NameConstraintItem item) {
      this.builder = new NameConstraintItemBuilder(this, item);
    }
  
    public N and() {
      return (N) NameConstraintsFluent.this.withPermitted(builder.build());
    }
    
    public N endPermitted() {
      return and();
    }
    
  }
}