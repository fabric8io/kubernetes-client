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
public class DeploymentConfigRollbackFluent<A extends io.fabric8.openshift.api.model.DeploymentConfigRollbackFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String apiVersion;
  private String kind;
  private String name;
  private DeploymentConfigRollbackSpecBuilder spec;
  private Map<String,String> updatedAnnotations;

  public DeploymentConfigRollbackFluent() {
  }
  
  public DeploymentConfigRollbackFluent(DeploymentConfigRollback instance) {
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
  
  public DeploymentConfigRollbackSpec buildSpec() {
    return this.spec != null ? this.spec.build() : null;
  }
  
  protected void copyInstance(DeploymentConfigRollback instance) {
    instance = instance != null ? instance : new DeploymentConfigRollback();
    if (instance != null) {
        this.withApiVersion(instance.getApiVersion());
        this.withKind(instance.getKind());
        this.withName(instance.getName());
        this.withSpec(instance.getSpec());
        this.withUpdatedAnnotations(instance.getUpdatedAnnotations());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public SpecNested<A> editOrNewSpec() {
    return this.withNewSpecLike(Optional.ofNullable(this.buildSpec()).orElse(new DeploymentConfigRollbackSpecBuilder().build()));
  }
  
  public SpecNested<A> editOrNewSpecLike(DeploymentConfigRollbackSpec item) {
    return this.withNewSpecLike(Optional.ofNullable(this.buildSpec()).orElse(item));
  }
  
  public SpecNested<A> editSpec() {
    return this.withNewSpecLike(Optional.ofNullable(this.buildSpec()).orElse(null));
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
    DeploymentConfigRollbackFluent that = (DeploymentConfigRollbackFluent) o;
    if (!(Objects.equals(apiVersion, that.apiVersion))) {
      return false;
    }
    if (!(Objects.equals(kind, that.kind))) {
      return false;
    }
    if (!(Objects.equals(name, that.name))) {
      return false;
    }
    if (!(Objects.equals(spec, that.spec))) {
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
  
  public boolean hasSpec() {
    return this.spec != null;
  }
  
  public boolean hasUpdatedAnnotations() {
    return this.updatedAnnotations != null;
  }
  
  public int hashCode() {
    return Objects.hash(apiVersion, kind, name, spec, updatedAnnotations, additionalProperties);
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
    if (!(spec == null)) {
        sb.append("spec:");
        sb.append(spec);
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
  
  public SpecNested<A> withNewSpec() {
    return new SpecNested(null);
  }
  
  public SpecNested<A> withNewSpecLike(DeploymentConfigRollbackSpec item) {
    return new SpecNested(item);
  }
  
  public A withSpec(DeploymentConfigRollbackSpec spec) {
    this._visitables.remove("spec");
    if (spec != null) {
        this.spec = new DeploymentConfigRollbackSpecBuilder(spec);
        this._visitables.get("spec").add(this.spec);
    } else {
        this.spec = null;
        this._visitables.get("spec").remove(this.spec);
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
  public class SpecNested<N> extends DeploymentConfigRollbackSpecFluent<SpecNested<N>> implements Nested<N>{
  
    DeploymentConfigRollbackSpecBuilder builder;
  
    SpecNested(DeploymentConfigRollbackSpec item) {
      this.builder = new DeploymentConfigRollbackSpecBuilder(this, item);
    }
  
    public N and() {
      return (N) DeploymentConfigRollbackFluent.this.withSpec(builder.build());
    }
    
    public N endSpec() {
      return and();
    }
    
  }
}