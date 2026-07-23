package io.fabric8.openshift.api.model.insights.v1alpha2;

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
public class GatherersFluent<A extends io.fabric8.openshift.api.model.insights.v1alpha2.GatherersFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private CustomBuilder custom;
  private String mode;

  public GatherersFluent() {
  }
  
  public GatherersFluent(Gatherers instance) {
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
  
  public Custom buildCustom() {
    return this.custom != null ? this.custom.build() : null;
  }
  
  protected void copyInstance(Gatherers instance) {
    instance = instance != null ? instance : new Gatherers();
    if (instance != null) {
        this.withCustom(instance.getCustom());
        this.withMode(instance.getMode());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public CustomNested<A> editCustom() {
    return this.withNewCustomLike(Optional.ofNullable(this.buildCustom()).orElse(null));
  }
  
  public CustomNested<A> editOrNewCustom() {
    return this.withNewCustomLike(Optional.ofNullable(this.buildCustom()).orElse(new CustomBuilder().build()));
  }
  
  public CustomNested<A> editOrNewCustomLike(Custom item) {
    return this.withNewCustomLike(Optional.ofNullable(this.buildCustom()).orElse(item));
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
    GatherersFluent that = (GatherersFluent) o;
    if (!(Objects.equals(custom, that.custom))) {
      return false;
    }
    if (!(Objects.equals(mode, that.mode))) {
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
  
  public String getMode() {
    return this.mode;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasCustom() {
    return this.custom != null;
  }
  
  public boolean hasMode() {
    return this.mode != null;
  }
  
  public int hashCode() {
    return Objects.hash(custom, mode, additionalProperties);
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
    if (!(custom == null)) {
        sb.append("custom:");
        sb.append(custom);
        sb.append(",");
    }
    if (!(mode == null)) {
        sb.append("mode:");
        sb.append(mode);
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
  
  public A withCustom(Custom custom) {
    this._visitables.remove("custom");
    if (custom != null) {
        this.custom = new CustomBuilder(custom);
        this._visitables.get("custom").add(this.custom);
    } else {
        this.custom = null;
        this._visitables.get("custom").remove(this.custom);
    }
    return (A) this;
  }
  
  public A withMode(String mode) {
    this.mode = mode;
    return (A) this;
  }
  
  public CustomNested<A> withNewCustom() {
    return new CustomNested(null);
  }
  
  public CustomNested<A> withNewCustomLike(Custom item) {
    return new CustomNested(item);
  }
  public class CustomNested<N> extends CustomFluent<CustomNested<N>> implements Nested<N>{
  
    CustomBuilder builder;
  
    CustomNested(Custom item) {
      this.builder = new CustomBuilder(this, item);
    }
  
    public N and() {
      return (N) GatherersFluent.this.withCustom(builder.build());
    }
    
    public N endCustom() {
      return and();
    }
    
  }
}