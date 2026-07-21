package io.fabric8.tekton.v1;

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
public class TaskResultFluent<A extends io.fabric8.tekton.v1.TaskResultFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String description;
  private String name;
  private Map<String,PropertySpec> properties;
  private String type;
  private ParamValueBuilder value;

  public TaskResultFluent() {
  }
  
  public TaskResultFluent(TaskResult instance) {
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
  
  public A addToProperties(Map<String,PropertySpec> map) {
    if (this.properties == null && map != null) {
      this.properties = new LinkedHashMap();
    }
    if (map != null) {
      this.properties.putAll(map);
    }
    return (A) this;
  }
  
  public A addToProperties(String key,PropertySpec value) {
    if (this.properties == null && key != null && value != null) {
      this.properties = new LinkedHashMap();
    }
    if (key != null && value != null) {
      this.properties.put(key, value);
    }
    return (A) this;
  }
  
  public ParamValue buildValue() {
    return this.value != null ? this.value.build() : null;
  }
  
  protected void copyInstance(TaskResult instance) {
    instance = instance != null ? instance : new TaskResult();
    if (instance != null) {
        this.withDescription(instance.getDescription());
        this.withName(instance.getName());
        this.withProperties(instance.getProperties());
        this.withType(instance.getType());
        this.withValue(instance.getValue());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public ValueNested<A> editOrNewValue() {
    return this.withNewValueLike(Optional.ofNullable(this.buildValue()).orElse(new ParamValueBuilder().build()));
  }
  
  public ValueNested<A> editOrNewValueLike(ParamValue item) {
    return this.withNewValueLike(Optional.ofNullable(this.buildValue()).orElse(item));
  }
  
  public ValueNested<A> editValue() {
    return this.withNewValueLike(Optional.ofNullable(this.buildValue()).orElse(null));
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
    TaskResultFluent that = (TaskResultFluent) o;
    if (!(Objects.equals(description, that.description))) {
      return false;
    }
    if (!(Objects.equals(name, that.name))) {
      return false;
    }
    if (!(Objects.equals(properties, that.properties))) {
      return false;
    }
    if (!(Objects.equals(type, that.type))) {
      return false;
    }
    if (!(Objects.equals(value, that.value))) {
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
  
  public String getDescription() {
    return this.description;
  }
  
  public String getName() {
    return this.name;
  }
  
  public Map<String,PropertySpec> getProperties() {
    return this.properties;
  }
  
  public String getType() {
    return this.type;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasDescription() {
    return this.description != null;
  }
  
  public boolean hasName() {
    return this.name != null;
  }
  
  public boolean hasProperties() {
    return this.properties != null;
  }
  
  public boolean hasType() {
    return this.type != null;
  }
  
  public boolean hasValue() {
    return this.value != null;
  }
  
  public int hashCode() {
    return Objects.hash(description, name, properties, type, value, additionalProperties);
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
  
  public A removeFromProperties(String key) {
    if (this.properties == null) {
      return (A) this;
    }
    if (key != null && this.properties != null) {
      this.properties.remove(key);
    }
    return (A) this;
  }
  
  public A removeFromProperties(Map<String,PropertySpec> map) {
    if (this.properties == null) {
      return (A) this;
    }
    if (map != null) {
      for (Object key : map.keySet()) {
        if (this.properties != null) {
          this.properties.remove(key);
        }
      }
    }
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(description == null)) {
        sb.append("description:");
        sb.append(description);
        sb.append(",");
    }
    if (!(name == null)) {
        sb.append("name:");
        sb.append(name);
        sb.append(",");
    }
    if (!(properties == null) && !(properties.isEmpty())) {
        sb.append("properties:");
        sb.append(properties);
        sb.append(",");
    }
    if (!(type == null)) {
        sb.append("type:");
        sb.append(type);
        sb.append(",");
    }
    if (!(value == null)) {
        sb.append("value:");
        sb.append(value);
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
  
  public A withDescription(String description) {
    this.description = description;
    return (A) this;
  }
  
  public A withName(String name) {
    this.name = name;
    return (A) this;
  }
  
  public ValueNested<A> withNewValue() {
    return new ValueNested(null);
  }
  
  public A withNewValue(String stringVal) {
    return (A) this.withValue(new ParamValue(stringVal));
  }
  
  public ValueNested<A> withNewValueLike(ParamValue item) {
    return new ValueNested(item);
  }
  
  public <K,V>A withProperties(Map<String,PropertySpec> properties) {
    if (properties == null) {
      this.properties = null;
    } else {
      this.properties = new LinkedHashMap(properties);
    }
    return (A) this;
  }
  
  public A withType(String type) {
    this.type = type;
    return (A) this;
  }
  
  public A withValue(ParamValue value) {
    this._visitables.remove("value");
    if (value != null) {
        this.value = new ParamValueBuilder(value);
        this._visitables.get("value").add(this.value);
    } else {
        this.value = null;
        this._visitables.get("value").remove(this.value);
    }
    return (A) this;
  }
  public class ValueNested<N> extends ParamValueFluent<ValueNested<N>> implements Nested<N>{
  
    ParamValueBuilder builder;
  
    ValueNested(ParamValue item) {
      this.builder = new ParamValueBuilder(this, item);
    }
  
    public N and() {
      return (N) TaskResultFluent.this.withValue(builder.build());
    }
    
    public N endValue() {
      return and();
    }
    
  }
}