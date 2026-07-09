package io.fabric8.kubernetes.api.model.resource.v1beta1;

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
public class DeviceConstraintFluent<A extends io.fabric8.kubernetes.api.model.resource.v1beta1.DeviceConstraintFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String distinctAttribute;
  private String matchAttribute;
  private List<String> requests = new ArrayList<String>();

  public DeviceConstraintFluent() {
  }
  
  public DeviceConstraintFluent(DeviceConstraint instance) {
    this.copyInstance(instance);
  }

  public A addAllToRequests(Collection<String> items) {
    if (this.requests == null) {
      this.requests = new ArrayList();
    }
    for (String item : items) {
      this.requests.add(item);
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
  
  public A addToRequests(String... items) {
    if (this.requests == null) {
      this.requests = new ArrayList();
    }
    for (String item : items) {
      this.requests.add(item);
    }
    return (A) this;
  }
  
  public A addToRequests(int index,String item) {
    if (this.requests == null) {
      this.requests = new ArrayList();
    }
    this.requests.add(index, item);
    return (A) this;
  }
  
  protected void copyInstance(DeviceConstraint instance) {
    instance = instance != null ? instance : new DeviceConstraint();
    if (instance != null) {
        this.withDistinctAttribute(instance.getDistinctAttribute());
        this.withMatchAttribute(instance.getMatchAttribute());
        this.withRequests(instance.getRequests());
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
    DeviceConstraintFluent that = (DeviceConstraintFluent) o;
    if (!(Objects.equals(distinctAttribute, that.distinctAttribute))) {
      return false;
    }
    if (!(Objects.equals(matchAttribute, that.matchAttribute))) {
      return false;
    }
    if (!(Objects.equals(requests, that.requests))) {
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
  
  public String getDistinctAttribute() {
    return this.distinctAttribute;
  }
  
  public String getFirstRequest() {
    return this.requests.get(0);
  }
  
  public String getLastRequest() {
    return this.requests.get(requests.size() - 1);
  }
  
  public String getMatchAttribute() {
    return this.matchAttribute;
  }
  
  public String getMatchingRequest(Predicate<String> predicate) {
      for (String item : requests) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public String getRequest(int index) {
    return this.requests.get(index);
  }
  
  public List<String> getRequests() {
    return this.requests;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasDistinctAttribute() {
    return this.distinctAttribute != null;
  }
  
  public boolean hasMatchAttribute() {
    return this.matchAttribute != null;
  }
  
  public boolean hasMatchingRequest(Predicate<String> predicate) {
      for (String item : requests) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasRequests() {
    return this.requests != null && !(this.requests.isEmpty());
  }
  
  public int hashCode() {
    return Objects.hash(distinctAttribute, matchAttribute, requests, additionalProperties);
  }
  
  public A removeAllFromRequests(Collection<String> items) {
    if (this.requests == null) {
      return (A) this;
    }
    for (String item : items) {
      this.requests.remove(item);
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
  
  public A removeFromRequests(String... items) {
    if (this.requests == null) {
      return (A) this;
    }
    for (String item : items) {
      this.requests.remove(item);
    }
    return (A) this;
  }
  
  public A setToRequests(int index,String item) {
    if (this.requests == null) {
      this.requests = new ArrayList();
    }
    this.requests.set(index, item);
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(distinctAttribute == null)) {
        sb.append("distinctAttribute:");
        sb.append(distinctAttribute);
        sb.append(",");
    }
    if (!(matchAttribute == null)) {
        sb.append("matchAttribute:");
        sb.append(matchAttribute);
        sb.append(",");
    }
    if (!(requests == null) && !(requests.isEmpty())) {
        sb.append("requests:");
        sb.append(requests);
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
  
  public A withDistinctAttribute(String distinctAttribute) {
    this.distinctAttribute = distinctAttribute;
    return (A) this;
  }
  
  public A withMatchAttribute(String matchAttribute) {
    this.matchAttribute = matchAttribute;
    return (A) this;
  }
  
  public A withRequests(List<String> requests) {
    if (requests != null) {
        this.requests = new ArrayList();
        for (String item : requests) {
          this.addToRequests(item);
        }
    } else {
      this.requests = null;
    }
    return (A) this;
  }
  
  public A withRequests(String... requests) {
    if (this.requests != null) {
        this.requests.clear();
        _visitables.remove("requests");
    }
    if (requests != null) {
      for (String item : requests) {
        this.addToRequests(item);
      }
    }
    return (A) this;
  }
  
}