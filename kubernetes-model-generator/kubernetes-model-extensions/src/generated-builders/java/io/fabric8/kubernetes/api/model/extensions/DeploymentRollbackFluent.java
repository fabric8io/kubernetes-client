package io.fabric8.kubernetes.api.model.extensions;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import java.lang.Long;
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
public class DeploymentRollbackFluent<A extends io.fabric8.kubernetes.api.model.extensions.DeploymentRollbackFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String apiVersion;
  private String kind;
  private String name;
  private RollbackConfigBuilder rollbackTo;
  private Map<String,String> updatedAnnotations;

  public DeploymentRollbackFluent() {
  }
  
  public DeploymentRollbackFluent(DeploymentRollback instance) {
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
  
  public A addToUpdatedAnnotations(Map<String,String> map) {
    if (this.updatedAnnotations == null && map != null) {
      this.updatedAnnotations = new LinkedHashMap();
    }
    if (map != null) {
      this.updatedAnnotations.putAll(map);
    }
    return (A) this;
  }
  
  public A addToUpdatedAnnotations(String key,String value) {
    if (this.updatedAnnotations == null && key != null && value != null) {
      this.updatedAnnotations = new LinkedHashMap();
    }
    if (key != null && value != null) {
      this.updatedAnnotations.put(key, value);
    }
    return (A) this;
  }
  
  public RollbackConfig buildRollbackTo() {
    return this.rollbackTo != null ? this.rollbackTo.build() : null;
  }
  
  protected void copyInstance(DeploymentRollback instance) {
    instance = instance != null ? instance : new DeploymentRollback();
    if (instance != null) {
        this.withApiVersion(instance.getApiVersion());
        this.withKind(instance.getKind());
        this.withName(instance.getName());
        this.withRollbackTo(instance.getRollbackTo());
        this.withUpdatedAnnotations(instance.getUpdatedAnnotations());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public RollbackToNested<A> editOrNewRollbackTo() {
    return this.withNewRollbackToLike(Optional.ofNullable(this.buildRollbackTo()).orElse(new RollbackConfigBuilder().build()));
  }
  
  public RollbackToNested<A> editOrNewRollbackToLike(RollbackConfig item) {
    return this.withNewRollbackToLike(Optional.ofNullable(this.buildRollbackTo()).orElse(item));
  }
  
  public RollbackToNested<A> editRollbackTo() {
    return this.withNewRollbackToLike(Optional.ofNullable(this.buildRollbackTo()).orElse(null));
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
    DeploymentRollbackFluent that = (DeploymentRollbackFluent) o;
    if (!(Objects.equals(apiVersion, that.apiVersion))) {
      return false;
    }
    if (!(Objects.equals(kind, that.kind))) {
      return false;
    }
    if (!(Objects.equals(name, that.name))) {
      return false;
    }
    if (!(Objects.equals(rollbackTo, that.rollbackTo))) {
      return false;
    }
    if (!(Objects.equals(updatedAnnotations, that.updatedAnnotations))) {
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
  
  public String getApiVersion() {
    return this.apiVersion;
  }
  
  public String getKind() {
    return this.kind;
  }
  
  public String getName() {
    return this.name;
  }
  
  public Map<String,String> getUpdatedAnnotations() {
    return this.updatedAnnotations;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasApiVersion() {
    return this.apiVersion != null;
  }
  
  public boolean hasKind() {
    return this.kind != null;
  }
  
  public boolean hasName() {
    return this.name != null;
  }
  
  public boolean hasRollbackTo() {
    return this.rollbackTo != null;
  }
  
  public boolean hasUpdatedAnnotations() {
    return this.updatedAnnotations != null;
  }
  
  public int hashCode() {
    return Objects.hash(apiVersion, kind, name, rollbackTo, updatedAnnotations, additionalProperties);
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
  
  public A removeFromUpdatedAnnotations(String key) {
    if (this.updatedAnnotations == null) {
      return (A) this;
    }
    if (key != null && this.updatedAnnotations != null) {
      this.updatedAnnotations.remove(key);
    }
    return (A) this;
  }
  
  public A removeFromUpdatedAnnotations(Map<String,String> map) {
    if (this.updatedAnnotations == null) {
      return (A) this;
    }
    if (map != null) {
      for (Object key : map.keySet()) {
        if (this.updatedAnnotations != null) {
          this.updatedAnnotations.remove(key);
        }
      }
    }
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(apiVersion == null)) {
        sb.append("apiVersion:");
        sb.append(apiVersion);
        sb.append(",");
    }
    if (!(kind == null)) {
        sb.append("kind:");
        sb.append(kind);
        sb.append(",");
    }
    if (!(name == null)) {
        sb.append("name:");
        sb.append(name);
        sb.append(",");
    }
    if (!(rollbackTo == null)) {
        sb.append("rollbackTo:");
        sb.append(rollbackTo);
        sb.append(",");
    }
    if (!(updatedAnnotations == null) && !(updatedAnnotations.isEmpty())) {
        sb.append("updatedAnnotations:");
        sb.append(updatedAnnotations);
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
  
  public A withApiVersion(String apiVersion) {
    this.apiVersion = apiVersion;
    return (A) this;
  }
  
  public A withKind(String kind) {
    this.kind = kind;
    return (A) this;
  }
  
  public A withName(String name) {
    this.name = name;
    return (A) this;
  }
  
  public RollbackToNested<A> withNewRollbackTo() {
    return new RollbackToNested(null);
  }
  
  public A withNewRollbackTo(Long revision) {
    return (A) this.withRollbackTo(new RollbackConfig(revision));
  }
  
  public RollbackToNested<A> withNewRollbackToLike(RollbackConfig item) {
    return new RollbackToNested(item);
  }
  
  public A withRollbackTo(RollbackConfig rollbackTo) {
    this._visitables.remove("rollbackTo");
    if (rollbackTo != null) {
        this.rollbackTo = new RollbackConfigBuilder(rollbackTo);
        this._visitables.get("rollbackTo").add(this.rollbackTo);
    } else {
        this.rollbackTo = null;
        this._visitables.get("rollbackTo").remove(this.rollbackTo);
    }
    return (A) this;
  }
  
  public <K,V>A withUpdatedAnnotations(Map<String,String> updatedAnnotations) {
    if (updatedAnnotations == null) {
      this.updatedAnnotations = null;
    } else {
      this.updatedAnnotations = new LinkedHashMap(updatedAnnotations);
    }
    return (A) this;
  }
  public class RollbackToNested<N> extends RollbackConfigFluent<RollbackToNested<N>> implements Nested<N>{
  
    RollbackConfigBuilder builder;
  
    RollbackToNested(RollbackConfig item) {
      this.builder = new RollbackConfigBuilder(this, item);
    }
  
    public N and() {
      return (N) DeploymentRollbackFluent.this.withRollbackTo(builder.build());
    }
    
    public N endRollbackTo() {
      return and();
    }
    
  }
}