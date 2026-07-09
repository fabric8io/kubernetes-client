package io.fabric8.kubernetes.api.model.apiextensions.v1;

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
public class ConversionRequestFluent<A extends io.fabric8.kubernetes.api.model.apiextensions.v1.ConversionRequestFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String desiredAPIVersion;
  private List<Object> objects = new ArrayList<Object>();
  private String uid;

  public ConversionRequestFluent() {
  }
  
  public ConversionRequestFluent(ConversionRequest instance) {
    this.copyInstance(instance);
  }

  public A addAllToObjects(Collection<Object> items) {
    if (this.objects == null) {
      this.objects = new ArrayList();
    }
    for (Object item : items) {
      this.objects.add(item);
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
  
  public A addToObjects(Object... items) {
    if (this.objects == null) {
      this.objects = new ArrayList();
    }
    for (Object item : items) {
      this.objects.add(item);
    }
    return (A) this;
  }
  
  public A addToObjects(int index,Object item) {
    if (this.objects == null) {
      this.objects = new ArrayList();
    }
    this.objects.add(index, item);
    return (A) this;
  }
  
  protected void copyInstance(ConversionRequest instance) {
    instance = instance != null ? instance : new ConversionRequest();
    if (instance != null) {
        this.withDesiredAPIVersion(instance.getDesiredAPIVersion());
        this.withObjects(instance.getObjects());
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
    ConversionRequestFluent that = (ConversionRequestFluent) o;
    if (!(Objects.equals(desiredAPIVersion, that.desiredAPIVersion))) {
      return false;
    }
    if (!(Objects.equals(objects, that.objects))) {
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
  
  public String getDesiredAPIVersion() {
    return this.desiredAPIVersion;
  }
  
  public Object getFirstObject() {
    return this.objects.get(0);
  }
  
  public Object getLastObject() {
    return this.objects.get(objects.size() - 1);
  }
  
  public Object getMatchingObject(Predicate<Object> predicate) {
      for (Object item : objects) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public Object getObject(int index) {
    return this.objects.get(index);
  }
  
  public List<Object> getObjects() {
    return this.objects;
  }
  
  public String getUid() {
    return this.uid;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasDesiredAPIVersion() {
    return this.desiredAPIVersion != null;
  }
  
  public boolean hasMatchingObject(Predicate<Object> predicate) {
      for (Object item : objects) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasObjects() {
    return this.objects != null && !(this.objects.isEmpty());
  }
  
  public boolean hasUid() {
    return this.uid != null;
  }
  
  public int hashCode() {
    return Objects.hash(desiredAPIVersion, objects, uid, additionalProperties);
  }
  
  public A removeAllFromObjects(Collection<Object> items) {
    if (this.objects == null) {
      return (A) this;
    }
    for (Object item : items) {
      this.objects.remove(item);
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
  
  public A removeFromObjects(Object... items) {
    if (this.objects == null) {
      return (A) this;
    }
    for (Object item : items) {
      this.objects.remove(item);
    }
    return (A) this;
  }
  
  public A setToObjects(int index,Object item) {
    if (this.objects == null) {
      this.objects = new ArrayList();
    }
    this.objects.set(index, item);
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(desiredAPIVersion == null)) {
        sb.append("desiredAPIVersion:");
        sb.append(desiredAPIVersion);
        sb.append(",");
    }
    if (!(objects == null) && !(objects.isEmpty())) {
        sb.append("objects:");
        sb.append(objects);
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
  
  public A withDesiredAPIVersion(String desiredAPIVersion) {
    this.desiredAPIVersion = desiredAPIVersion;
    return (A) this;
  }
  
  public A withObjects(List<Object> objects) {
    if (objects != null) {
        this.objects = new ArrayList();
        for (Object item : objects) {
          this.addToObjects(item);
        }
    } else {
      this.objects = null;
    }
    return (A) this;
  }
  
  public A withObjects(Object... objects) {
    if (this.objects != null) {
        this.objects.clear();
        _visitables.remove("objects");
    }
    if (objects != null) {
      for (Object item : objects) {
        this.addToObjects(item);
      }
    }
    return (A) this;
  }
  
  public A withUid(String uid) {
    this.uid = uid;
    return (A) this;
  }
  
}