package io.fabric8.kubernetes.api.model.apiextensions.v1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.model.Status;
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
public class ConversionResponseFluent<A extends io.fabric8.kubernetes.api.model.apiextensions.v1.ConversionResponseFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private List<Object> convertedObjects = new ArrayList<Object>();
  private Status result;
  private String uid;

  public ConversionResponseFluent() {
  }
  
  public ConversionResponseFluent(ConversionResponse instance) {
    this.copyInstance(instance);
  }

  public A addAllToConvertedObjects(Collection<Object> items) {
    if (this.convertedObjects == null) {
      this.convertedObjects = new ArrayList();
    }
    for (Object item : items) {
      this.convertedObjects.add(item);
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
  
  public A addToConvertedObjects(Object... items) {
    if (this.convertedObjects == null) {
      this.convertedObjects = new ArrayList();
    }
    for (Object item : items) {
      this.convertedObjects.add(item);
    }
    return (A) this;
  }
  
  public A addToConvertedObjects(int index,Object item) {
    if (this.convertedObjects == null) {
      this.convertedObjects = new ArrayList();
    }
    this.convertedObjects.add(index, item);
    return (A) this;
  }
  
  protected void copyInstance(ConversionResponse instance) {
    instance = instance != null ? instance : new ConversionResponse();
    if (instance != null) {
        this.withConvertedObjects(instance.getConvertedObjects());
        this.withResult(instance.getResult());
        this.withUid(instance.getUid());
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
    ConversionResponseFluent that = (ConversionResponseFluent) o;
    if (!(Objects.equals(convertedObjects, that.convertedObjects))) {
      return false;
    }
    if (!(Objects.equals(result, that.result))) {
      return false;
    }
    if (!(Objects.equals(uid, that.uid))) {
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
  
  public Object getConvertedObject(int index) {
    return this.convertedObjects.get(index);
  }
  
  public List<Object> getConvertedObjects() {
    return this.convertedObjects;
  }
  
  public Object getFirstConvertedObject() {
    return this.convertedObjects.get(0);
  }
  
  public Object getLastConvertedObject() {
    return this.convertedObjects.get(convertedObjects.size() - 1);
  }
  
  public Object getMatchingConvertedObject(Predicate<Object> predicate) {
      for (Object item : convertedObjects) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public Status getResult() {
    return this.result;
  }
  
  public String getUid() {
    return this.uid;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasConvertedObjects() {
    return this.convertedObjects != null && !(this.convertedObjects.isEmpty());
  }
  
  public boolean hasMatchingConvertedObject(Predicate<Object> predicate) {
      for (Object item : convertedObjects) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasResult() {
    return this.result != null;
  }
  
  public boolean hasUid() {
    return this.uid != null;
  }
  
  public int hashCode() {
    return Objects.hash(convertedObjects, result, uid, additionalProperties);
  }
  
  public A removeAllFromConvertedObjects(Collection<Object> items) {
    if (this.convertedObjects == null) {
      return (A) this;
    }
    for (Object item : items) {
      this.convertedObjects.remove(item);
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
  
  public A removeFromConvertedObjects(Object... items) {
    if (this.convertedObjects == null) {
      return (A) this;
    }
    for (Object item : items) {
      this.convertedObjects.remove(item);
    }
    return (A) this;
  }
  
  public A setToConvertedObjects(int index,Object item) {
    if (this.convertedObjects == null) {
      this.convertedObjects = new ArrayList();
    }
    this.convertedObjects.set(index, item);
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(convertedObjects == null) && !(convertedObjects.isEmpty())) {
        sb.append("convertedObjects:");
        sb.append(convertedObjects);
        sb.append(",");
    }
    if (!(result == null)) {
        sb.append("result:");
        sb.append(result);
        sb.append(",");
    }
    if (!(uid == null)) {
        sb.append("uid:");
        sb.append(uid);
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
  
  public A withConvertedObjects(List<Object> convertedObjects) {
    if (convertedObjects != null) {
        this.convertedObjects = new ArrayList();
        for (Object item : convertedObjects) {
          this.addToConvertedObjects(item);
        }
    } else {
      this.convertedObjects = null;
    }
    return (A) this;
  }
  
  public A withConvertedObjects(Object... convertedObjects) {
    if (this.convertedObjects != null) {
        this.convertedObjects.clear();
        _visitables.remove("convertedObjects");
    }
    if (convertedObjects != null) {
      for (Object item : convertedObjects) {
        this.addToConvertedObjects(item);
      }
    }
    return (A) this;
  }
  
  public A withResult(Status result) {
    this.result = result;
    return (A) this;
  }
  
  public A withUid(String uid) {
    this.uid = uid;
    return (A) this;
  }
  
}