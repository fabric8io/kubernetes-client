package io.fabric8.openshift.api.model.operatorhub.v1alpha1;

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
public class SpecDescriptorFluent<A extends io.fabric8.openshift.api.model.operatorhub.v1alpha1.SpecDescriptorFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String description;
  private String displayName;
  private String path;
  private String value;
  private List<String> xDescriptors = new ArrayList<String>();

  public SpecDescriptorFluent() {
  }
  
  public SpecDescriptorFluent(SpecDescriptor instance) {
    this.copyInstance(instance);
  }

  public A addAllToXDescriptors(Collection<String> items) {
    if (this.xDescriptors == null) {
      this.xDescriptors = new ArrayList();
    }
    for (String item : items) {
      this.xDescriptors.add(item);
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
  
  public A addToXDescriptors(String... items) {
    if (this.xDescriptors == null) {
      this.xDescriptors = new ArrayList();
    }
    for (String item : items) {
      this.xDescriptors.add(item);
    }
    return (A) this;
  }
  
  public A addToXDescriptors(int index,String item) {
    if (this.xDescriptors == null) {
      this.xDescriptors = new ArrayList();
    }
    this.xDescriptors.add(index, item);
    return (A) this;
  }
  
  protected void copyInstance(SpecDescriptor instance) {
    instance = instance != null ? instance : new SpecDescriptor();
    if (instance != null) {
        this.withDescription(instance.getDescription());
        this.withDisplayName(instance.getDisplayName());
        this.withPath(instance.getPath());
        this.withValue(instance.getValue());
        this.withXDescriptors(instance.getXDescriptors());
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
    SpecDescriptorFluent that = (SpecDescriptorFluent) o;
    if (!(Objects.equals(description, that.description))) {
      return false;
    }
    if (!(Objects.equals(displayName, that.displayName))) {
      return false;
    }
    if (!(Objects.equals(path, that.path))) {
      return false;
    }
    if (!(Objects.equals(value, that.value))) {
      return false;
    }
    if (!(Objects.equals(xDescriptors, that.xDescriptors))) {
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
  
  public String getDisplayName() {
    return this.displayName;
  }
  
  public String getFirstXDescriptor() {
    return this.xDescriptors.get(0);
  }
  
  public String getLastXDescriptor() {
    return this.xDescriptors.get(xDescriptors.size() - 1);
  }
  
  public String getMatchingXDescriptor(Predicate<String> predicate) {
      for (String item : xDescriptors) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public String getPath() {
    return this.path;
  }
  
  public String getValue() {
    return this.value;
  }
  
  public String getXDescriptor(int index) {
    return this.xDescriptors.get(index);
  }
  
  public List<String> getXDescriptors() {
    return this.xDescriptors;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasDescription() {
    return this.description != null;
  }
  
  public boolean hasDisplayName() {
    return this.displayName != null;
  }
  
  public boolean hasMatchingXDescriptor(Predicate<String> predicate) {
      for (String item : xDescriptors) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasPath() {
    return this.path != null;
  }
  
  public boolean hasValue() {
    return this.value != null;
  }
  
  public boolean hasXDescriptors() {
    return this.xDescriptors != null && !(this.xDescriptors.isEmpty());
  }
  
  public int hashCode() {
    return Objects.hash(description, displayName, path, value, xDescriptors, additionalProperties);
  }
  
  public A removeAllFromXDescriptors(Collection<String> items) {
    if (this.xDescriptors == null) {
      return (A) this;
    }
    for (String item : items) {
      this.xDescriptors.remove(item);
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
  
  public A removeFromXDescriptors(String... items) {
    if (this.xDescriptors == null) {
      return (A) this;
    }
    for (String item : items) {
      this.xDescriptors.remove(item);
    }
    return (A) this;
  }
  
  public A setToXDescriptors(int index,String item) {
    if (this.xDescriptors == null) {
      this.xDescriptors = new ArrayList();
    }
    this.xDescriptors.set(index, item);
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
    if (!(displayName == null)) {
        sb.append("displayName:");
        sb.append(displayName);
        sb.append(",");
    }
    if (!(path == null)) {
        sb.append("path:");
        sb.append(path);
        sb.append(",");
    }
    if (!(value == null)) {
        sb.append("value:");
        sb.append(value);
        sb.append(",");
    }
    if (!(xDescriptors == null) && !(xDescriptors.isEmpty())) {
        sb.append("xDescriptors:");
        sb.append(xDescriptors);
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
  
  public A withDisplayName(String displayName) {
    this.displayName = displayName;
    return (A) this;
  }
  
  public A withPath(String path) {
    this.path = path;
    return (A) this;
  }
  
  public A withValue(String value) {
    this.value = value;
    return (A) this;
  }
  
  public A withXDescriptors(List<String> xDescriptors) {
    if (xDescriptors != null) {
        this.xDescriptors = new ArrayList();
        for (String item : xDescriptors) {
          this.addToXDescriptors(item);
        }
    } else {
      this.xDescriptors = null;
    }
    return (A) this;
  }
  
  public A withXDescriptors(String... xDescriptors) {
    if (this.xDescriptors != null) {
        this.xDescriptors.clear();
        _visitables.remove("xDescriptors");
    }
    if (xDescriptors != null) {
      for (String item : xDescriptors) {
        this.addToXDescriptors(item);
      }
    }
    return (A) this;
  }
  
}