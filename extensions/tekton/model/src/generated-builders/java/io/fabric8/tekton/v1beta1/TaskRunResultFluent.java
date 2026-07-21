package io.fabric8.tekton.v1beta1;

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
public class TaskRunResultFluent<A extends io.fabric8.tekton.v1beta1.TaskRunResultFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String name;
  private String type;
  private ParamValueBuilder value;

  public TaskRunResultFluent() {
  }
  
  public TaskRunResultFluent(TaskRunResult instance) {
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
  
  public ParamValue buildValue() {
    return this.value != null ? this.value.build() : null;
  }
  
  protected void copyInstance(TaskRunResult instance) {
    instance = instance != null ? instance : new TaskRunResult();
    if (instance != null) {
        this.withName(instance.getName());
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
    TaskRunResultFluent that = (TaskRunResultFluent) o;
    if (!(Objects.equals(name, that.name))) {
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
  
  public String getName() {
    return this.name;
  }
  
  public String getType() {
    return this.type;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasName() {
    return this.name != null;
  }
  
  public boolean hasType() {
    return this.type != null;
  }
  
  public boolean hasValue() {
    return this.value != null;
  }
  
  public int hashCode() {
    return Objects.hash(name, type, value, additionalProperties);
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
      return (N) TaskRunResultFluent.this.withValue(builder.build());
    }
    
    public N endValue() {
      return and();
    }
    
  }
}