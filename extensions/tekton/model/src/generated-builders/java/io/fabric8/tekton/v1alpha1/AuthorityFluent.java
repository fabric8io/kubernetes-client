package io.fabric8.tekton.v1alpha1;

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
public class AuthorityFluent<A extends io.fabric8.tekton.v1alpha1.AuthorityFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private KeyRefBuilder key;
  private String name;

  public AuthorityFluent() {
  }
  
  public AuthorityFluent(Authority instance) {
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
  
  public KeyRef buildKey() {
    return this.key != null ? this.key.build() : null;
  }
  
  protected void copyInstance(Authority instance) {
    instance = instance != null ? instance : new Authority();
    if (instance != null) {
        this.withKey(instance.getKey());
        this.withName(instance.getName());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public KeyNested<A> editKey() {
    return this.withNewKeyLike(Optional.ofNullable(this.buildKey()).orElse(null));
  }
  
  public KeyNested<A> editOrNewKey() {
    return this.withNewKeyLike(Optional.ofNullable(this.buildKey()).orElse(new KeyRefBuilder().build()));
  }
  
  public KeyNested<A> editOrNewKeyLike(KeyRef item) {
    return this.withNewKeyLike(Optional.ofNullable(this.buildKey()).orElse(item));
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
    AuthorityFluent that = (AuthorityFluent) o;
    if (!(Objects.equals(key, that.key))) {
      return false;
    }
    if (!(Objects.equals(name, that.name))) {
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
  
  public boolean hasKey() {
    return this.key != null;
  }
  
  public boolean hasName() {
    return this.name != null;
  }
  
  public int hashCode() {
    return Objects.hash(key, name, additionalProperties);
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
    if (!(key == null)) {
        sb.append("key:");
        sb.append(key);
        sb.append(",");
    }
    if (!(name == null)) {
        sb.append("name:");
        sb.append(name);
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
  
  public A withKey(KeyRef key) {
    this._visitables.remove("key");
    if (key != null) {
        this.key = new KeyRefBuilder(key);
        this._visitables.get("key").add(this.key);
    } else {
        this.key = null;
        this._visitables.get("key").remove(this.key);
    }
    return (A) this;
  }
  
  public A withName(String name) {
    this.name = name;
    return (A) this;
  }
  
  public KeyNested<A> withNewKey() {
    return new KeyNested(null);
  }
  
  public KeyNested<A> withNewKeyLike(KeyRef item) {
    return new KeyNested(item);
  }
  public class KeyNested<N> extends KeyRefFluent<KeyNested<N>> implements Nested<N>{
  
    KeyRefBuilder builder;
  
    KeyNested(KeyRef item) {
      this.builder = new KeyRefBuilder(this, item);
    }
  
    public N and() {
      return (N) AuthorityFluent.this.withKey(builder.build());
    }
    
    public N endKey() {
      return and();
    }
    
  }
}