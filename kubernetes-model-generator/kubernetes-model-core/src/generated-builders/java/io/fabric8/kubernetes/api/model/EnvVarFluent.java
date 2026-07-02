package io.fabric8.kubernetes.api.model;

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
public class EnvVarFluent<A extends io.fabric8.kubernetes.api.model.EnvVarFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String name;
  private String value;
  private EnvVarSourceBuilder valueFrom;

  public EnvVarFluent() {
  }
  
  public EnvVarFluent(EnvVar instance) {
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
  
  public EnvVarSource buildValueFrom() {
    return this.valueFrom != null ? this.valueFrom.build() : null;
  }
  
  protected void copyInstance(EnvVar instance) {
    instance = instance != null ? instance : new EnvVar();
    if (instance != null) {
        this.withName(instance.getName());
        this.withValue(instance.getValue());
        this.withValueFrom(instance.getValueFrom());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public ValueFromNested<A> editOrNewValueFrom() {
    return this.withNewValueFromLike(Optional.ofNullable(this.buildValueFrom()).orElse(new EnvVarSourceBuilder().build()));
  }
  
  public ValueFromNested<A> editOrNewValueFromLike(EnvVarSource item) {
    return this.withNewValueFromLike(Optional.ofNullable(this.buildValueFrom()).orElse(item));
  }
  
  public ValueFromNested<A> editValueFrom() {
    return this.withNewValueFromLike(Optional.ofNullable(this.buildValueFrom()).orElse(null));
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
    EnvVarFluent that = (EnvVarFluent) o;
    if (!(Objects.equals(name, that.name))) {
      return false;
    }
    if (!(Objects.equals(value, that.value))) {
      return false;
    }
    if (!(Objects.equals(valueFrom, that.valueFrom))) {
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
  
  public String getValue() {
    return this.value;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasName() {
    return this.name != null;
  }
  
  public boolean hasValue() {
    return this.value != null;
  }
  
  public boolean hasValueFrom() {
    return this.valueFrom != null;
  }
  
  public int hashCode() {
    return Objects.hash(name, value, valueFrom, additionalProperties);
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
    if (!(name == null)) {
        sb.append("name:");
        sb.append(name);
        sb.append(",");
    }
    if (!(value == null)) {
        sb.append("value:");
        sb.append(value);
        sb.append(",");
    }
    if (!(valueFrom == null)) {
        sb.append("valueFrom:");
        sb.append(valueFrom);
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
  
  public A withName(String name) {
    this.name = name;
    return (A) this;
  }
  
  public ValueFromNested<A> withNewValueFrom() {
    return new ValueFromNested(null);
  }
  
  public ValueFromNested<A> withNewValueFromLike(EnvVarSource item) {
    return new ValueFromNested(item);
  }
  
  public A withValue(String value) {
    this.value = value;
    return (A) this;
  }
  
  public A withValueFrom(EnvVarSource valueFrom) {
    this._visitables.remove("valueFrom");
    if (valueFrom != null) {
        this.valueFrom = new EnvVarSourceBuilder(valueFrom);
        this._visitables.get("valueFrom").add(this.valueFrom);
    } else {
        this.valueFrom = null;
        this._visitables.get("valueFrom").remove(this.valueFrom);
    }
    return (A) this;
  }
  public class ValueFromNested<N> extends EnvVarSourceFluent<ValueFromNested<N>> implements Nested<N>{
  
    EnvVarSourceBuilder builder;
  
    ValueFromNested(EnvVarSource item) {
      this.builder = new EnvVarSourceBuilder(this, item);
    }
  
    public N and() {
      return (N) EnvVarFluent.this.withValueFrom(builder.build());
    }
    
    public N endValueFrom() {
      return and();
    }
    
  }
}