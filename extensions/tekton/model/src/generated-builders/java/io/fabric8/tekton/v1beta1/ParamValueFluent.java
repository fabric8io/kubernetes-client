package io.fabric8.tekton.v1beta1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import java.lang.Object;
import java.lang.String;
import java.lang.StringBuilder;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Predicate;

/**
 * Generated
 */
@SuppressWarnings("unchecked")
public class ParamValueFluent<A extends io.fabric8.tekton.v1beta1.ParamValueFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private List<String> arrayVal;
  private Map<String,String> objectVal;
  private String stringVal;
  private String type;

  public ParamValueFluent() {
  }
  
  public ParamValueFluent(ParamValue instance) {
    this.copyInstance(instance);
  }

  public A addAllToArrayVal(Collection<String> items) {
    if (this.arrayVal == null) {
      this.arrayVal = new ArrayList();
    }
    for (String item : items) {
      this.arrayVal.add(item);
    }
    return (A) this;
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
  
  public A addToArrayVal(String... items) {
    if (this.arrayVal == null) {
      this.arrayVal = new ArrayList();
    }
    for (String item : items) {
      this.arrayVal.add(item);
    }
    return (A) this;
  }
  
  public A addToArrayVal(int index,String item) {
    if (this.arrayVal == null) {
      this.arrayVal = new ArrayList();
    }
    this.arrayVal.add(index, item);
    return (A) this;
  }
  
  public A addToObjectVal(Map<String,String> map) {
    if (this.objectVal == null && map != null) {
      this.objectVal = new LinkedHashMap();
    }
    if (map != null) {
      this.objectVal.putAll(map);
    }
    return (A) this;
  }
  
  public A addToObjectVal(String key,String value) {
    if (this.objectVal == null && key != null && value != null) {
      this.objectVal = new LinkedHashMap();
    }
    if (key != null && value != null) {
      this.objectVal.put(key, value);
    }
    return (A) this;
  }
  
  protected void copyInstance(ParamValue instance) {
    instance = instance != null ? instance : new ParamValue();
    if (instance != null) {
        this.withArrayVal(instance.getArrayVal());
        this.withObjectVal(instance.getObjectVal());
        this.withStringVal(instance.getStringVal());
        this.withType(instance.getType());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
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
    ParamValueFluent that = (ParamValueFluent) o;
    if (!(Objects.equals(arrayVal, that.arrayVal))) {
      return false;
    }
    if (!(Objects.equals(objectVal, that.objectVal))) {
      return false;
    }
    if (!(Objects.equals(stringVal, that.stringVal))) {
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
  
  public List<String> getArrayVal() {
    return this.arrayVal;
  }
  
  public String getArrayVal(int index) {
    return this.arrayVal.get(index);
  }
  
  public String getFirstArrayVal() {
    return this.arrayVal.get(0);
  }
  
  public String getLastArrayVal() {
    return this.arrayVal.get(arrayVal.size() - 1);
  }
  
  public String getMatchingArrayVal(Predicate<String> predicate) {
      for (String item : arrayVal) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public Map<String,String> getObjectVal() {
    return this.objectVal;
  }
  
  public String getStringVal() {
    return this.stringVal;
  }
  
  public String getType() {
    return this.type;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasArrayVal() {
    return this.arrayVal != null && !(this.arrayVal.isEmpty());
  }
  
  public boolean hasMatchingArrayVal(Predicate<String> predicate) {
      for (String item : arrayVal) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasObjectVal() {
    return this.objectVal != null;
  }
  
  public boolean hasStringVal() {
    return this.stringVal != null;
  }
  
  public boolean hasType() {
    return this.type != null;
  }
  
  public int hashCode() {
    return Objects.hash(arrayVal, objectVal, stringVal, type, additionalProperties);
  }
  
  public A removeAllFromArrayVal(Collection<String> items) {
    if (this.arrayVal == null) {
      return (A) this;
    }
    for (String item : items) {
      this.arrayVal.remove(item);
    }
    return (A) this;
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
  
  public A removeFromArrayVal(String... items) {
    if (this.arrayVal == null) {
      return (A) this;
    }
    for (String item : items) {
      this.arrayVal.remove(item);
    }
    return (A) this;
  }
  
  public A removeFromObjectVal(String key) {
    if (this.objectVal == null) {
      return (A) this;
    }
    if (key != null && this.objectVal != null) {
      this.objectVal.remove(key);
    }
    return (A) this;
  }
  
  public A removeFromObjectVal(Map<String,String> map) {
    if (this.objectVal == null) {
      return (A) this;
    }
    if (map != null) {
      for (Object key : map.keySet()) {
        if (this.objectVal != null) {
          this.objectVal.remove(key);
        }
      }
    }
    return (A) this;
  }
  
  public A setToArrayVal(int index,String item) {
    if (this.arrayVal == null) {
      this.arrayVal = new ArrayList();
    }
    this.arrayVal.set(index, item);
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(arrayVal == null) && !(arrayVal.isEmpty())) {
        sb.append("arrayVal:");
        sb.append(arrayVal);
        sb.append(",");
    }
    if (!(objectVal == null) && !(objectVal.isEmpty())) {
        sb.append("objectVal:");
        sb.append(objectVal);
        sb.append(",");
    }
    if (!(stringVal == null)) {
        sb.append("stringVal:");
        sb.append(stringVal);
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
  
  public A withArrayVal(List<String> arrayVal) {
    if (arrayVal != null) {
        this.arrayVal = new ArrayList();
        for (String item : arrayVal) {
          this.addToArrayVal(item);
        }
    } else {
      this.arrayVal = null;
    }
    return (A) this;
  }
  
  public A withArrayVal(String... arrayVal) {
    if (this.arrayVal != null) {
        this.arrayVal.clear();
        _visitables.remove("arrayVal");
    }
    if (arrayVal != null) {
      for (String item : arrayVal) {
        this.addToArrayVal(item);
      }
    }
    return (A) this;
  }
  
  public <K,V>A withObjectVal(Map<String,String> objectVal) {
    if (objectVal == null) {
      this.objectVal = null;
    } else {
      this.objectVal = new LinkedHashMap(objectVal);
    }
    return (A) this;
  }
  
  public A withStringVal(String stringVal) {
    this.stringVal = stringVal;
    return (A) this;
  }
  
  public A withType(String type) {
    this.type = type;
    return (A) this;
  }
  
}