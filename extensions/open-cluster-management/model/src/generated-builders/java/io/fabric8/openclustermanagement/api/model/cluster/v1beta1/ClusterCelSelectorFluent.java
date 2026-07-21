package io.fabric8.openclustermanagement.api.model.cluster.v1beta1;

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
public class ClusterCelSelectorFluent<A extends io.fabric8.openclustermanagement.api.model.cluster.v1beta1.ClusterCelSelectorFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private List<String> celExpressions = new ArrayList<String>();

  public ClusterCelSelectorFluent() {
  }
  
  public ClusterCelSelectorFluent(ClusterCelSelector instance) {
    this.copyInstance(instance);
  }

  public A addAllToCelExpressions(Collection<String> items) {
    if (this.celExpressions == null) {
      this.celExpressions = new ArrayList();
    }
    for (String item : items) {
      this.celExpressions.add(item);
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
  
  public A addToCelExpressions(String... items) {
    if (this.celExpressions == null) {
      this.celExpressions = new ArrayList();
    }
    for (String item : items) {
      this.celExpressions.add(item);
    }
    return (A) this;
  }
  
  public A addToCelExpressions(int index,String item) {
    if (this.celExpressions == null) {
      this.celExpressions = new ArrayList();
    }
    this.celExpressions.add(index, item);
    return (A) this;
  }
  
  protected void copyInstance(ClusterCelSelector instance) {
    instance = instance != null ? instance : new ClusterCelSelector();
    if (instance != null) {
        this.withCelExpressions(instance.getCelExpressions());
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
    ClusterCelSelectorFluent that = (ClusterCelSelectorFluent) o;
    if (!(Objects.equals(celExpressions, that.celExpressions))) {
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
  
  public String getCelExpression(int index) {
    return this.celExpressions.get(index);
  }
  
  public List<String> getCelExpressions() {
    return this.celExpressions;
  }
  
  public String getFirstCelExpression() {
    return this.celExpressions.get(0);
  }
  
  public String getLastCelExpression() {
    return this.celExpressions.get(celExpressions.size() - 1);
  }
  
  public String getMatchingCelExpression(Predicate<String> predicate) {
      for (String item : celExpressions) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasCelExpressions() {
    return this.celExpressions != null && !(this.celExpressions.isEmpty());
  }
  
  public boolean hasMatchingCelExpression(Predicate<String> predicate) {
      for (String item : celExpressions) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public int hashCode() {
    return Objects.hash(celExpressions, additionalProperties);
  }
  
  public A removeAllFromCelExpressions(Collection<String> items) {
    if (this.celExpressions == null) {
      return (A) this;
    }
    for (String item : items) {
      this.celExpressions.remove(item);
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
  
  public A removeFromCelExpressions(String... items) {
    if (this.celExpressions == null) {
      return (A) this;
    }
    for (String item : items) {
      this.celExpressions.remove(item);
    }
    return (A) this;
  }
  
  public A setToCelExpressions(int index,String item) {
    if (this.celExpressions == null) {
      this.celExpressions = new ArrayList();
    }
    this.celExpressions.set(index, item);
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(celExpressions == null) && !(celExpressions.isEmpty())) {
        sb.append("celExpressions:");
        sb.append(celExpressions);
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
  
  public A withCelExpressions(List<String> celExpressions) {
    if (celExpressions != null) {
        this.celExpressions = new ArrayList();
        for (String item : celExpressions) {
          this.addToCelExpressions(item);
        }
    } else {
      this.celExpressions = null;
    }
    return (A) this;
  }
  
  public A withCelExpressions(String... celExpressions) {
    if (this.celExpressions != null) {
        this.celExpressions.clear();
        _visitables.remove("celExpressions");
    }
    if (celExpressions != null) {
      for (String item : celExpressions) {
        this.addToCelExpressions(item);
      }
    }
    return (A) this;
  }
  
}