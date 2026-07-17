package io.fabric8.openshift.api.model.operatorhub.packages.v1;

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
public class ChannelEntryFluent<A extends io.fabric8.openshift.api.model.operatorhub.packages.v1.ChannelEntryFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private DeprecationBuilder deprecation;
  private String name;
  private String version;

  public ChannelEntryFluent() {
  }
  
  public ChannelEntryFluent(ChannelEntry instance) {
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
  
  public Deprecation buildDeprecation() {
    return this.deprecation != null ? this.deprecation.build() : null;
  }
  
  protected void copyInstance(ChannelEntry instance) {
    instance = instance != null ? instance : new ChannelEntry();
    if (instance != null) {
        this.withDeprecation(instance.getDeprecation());
        this.withName(instance.getName());
        this.withVersion(instance.getVersion());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public DeprecationNested<A> editDeprecation() {
    return this.withNewDeprecationLike(Optional.ofNullable(this.buildDeprecation()).orElse(null));
  }
  
  public DeprecationNested<A> editOrNewDeprecation() {
    return this.withNewDeprecationLike(Optional.ofNullable(this.buildDeprecation()).orElse(new DeprecationBuilder().build()));
  }
  
  public DeprecationNested<A> editOrNewDeprecationLike(Deprecation item) {
    return this.withNewDeprecationLike(Optional.ofNullable(this.buildDeprecation()).orElse(item));
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
    ChannelEntryFluent that = (ChannelEntryFluent) o;
    if (!(Objects.equals(deprecation, that.deprecation))) {
      return false;
    }
    if (!(Objects.equals(name, that.name))) {
      return false;
    }
    if (!(Objects.equals(version, that.version))) {
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
  
  public String getVersion() {
    return this.version;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasDeprecation() {
    return this.deprecation != null;
  }
  
  public boolean hasName() {
    return this.name != null;
  }
  
  public boolean hasVersion() {
    return this.version != null;
  }
  
  public int hashCode() {
    return Objects.hash(deprecation, name, version, additionalProperties);
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
    if (!(deprecation == null)) {
        sb.append("deprecation:");
        sb.append(deprecation);
        sb.append(",");
    }
    if (!(name == null)) {
        sb.append("name:");
        sb.append(name);
        sb.append(",");
    }
    if (!(version == null)) {
        sb.append("version:");
        sb.append(version);
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
  
  public A withDeprecation(Deprecation deprecation) {
    this._visitables.remove("deprecation");
    if (deprecation != null) {
        this.deprecation = new DeprecationBuilder(deprecation);
        this._visitables.get("deprecation").add(this.deprecation);
    } else {
        this.deprecation = null;
        this._visitables.get("deprecation").remove(this.deprecation);
    }
    return (A) this;
  }
  
  public A withName(String name) {
    this.name = name;
    return (A) this;
  }
  
  public DeprecationNested<A> withNewDeprecation() {
    return new DeprecationNested(null);
  }
  
  public A withNewDeprecation(String message) {
    return (A) this.withDeprecation(new Deprecation(message));
  }
  
  public DeprecationNested<A> withNewDeprecationLike(Deprecation item) {
    return new DeprecationNested(item);
  }
  
  public A withVersion(String version) {
    this.version = version;
    return (A) this;
  }
  public class DeprecationNested<N> extends DeprecationFluent<DeprecationNested<N>> implements Nested<N>{
  
    DeprecationBuilder builder;
  
    DeprecationNested(Deprecation item) {
      this.builder = new DeprecationBuilder(this, item);
    }
  
    public N and() {
      return (N) ChannelEntryFluent.this.withDeprecation(builder.build());
    }
    
    public N endDeprecation() {
      return and();
    }
    
  }
}