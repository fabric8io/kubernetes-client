package io.fabric8.kubernetes.api.model.kustomize.v1beta1;

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
public class LegacySortOptionsFluent<A extends io.fabric8.kubernetes.api.model.kustomize.v1beta1.LegacySortOptionsFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private List<String> orderFirst = new ArrayList<String>();
  private List<String> orderLast = new ArrayList<String>();

  public LegacySortOptionsFluent() {
  }
  
  public LegacySortOptionsFluent(LegacySortOptions instance) {
    this.copyInstance(instance);
  }

  public A addAllToOrderFirst(Collection<String> items) {
    if (this.orderFirst == null) {
      this.orderFirst = new ArrayList();
    }
    for (String item : items) {
      this.orderFirst.add(item);
    }
    return (A) this;
  }
  
  public A addAllToOrderLast(Collection<String> items) {
    if (this.orderLast == null) {
      this.orderLast = new ArrayList();
    }
    for (String item : items) {
      this.orderLast.add(item);
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
  
  public A addToOrderFirst(String... items) {
    if (this.orderFirst == null) {
      this.orderFirst = new ArrayList();
    }
    for (String item : items) {
      this.orderFirst.add(item);
    }
    return (A) this;
  }
  
  public A addToOrderFirst(int index,String item) {
    if (this.orderFirst == null) {
      this.orderFirst = new ArrayList();
    }
    this.orderFirst.add(index, item);
    return (A) this;
  }
  
  public A addToOrderLast(String... items) {
    if (this.orderLast == null) {
      this.orderLast = new ArrayList();
    }
    for (String item : items) {
      this.orderLast.add(item);
    }
    return (A) this;
  }
  
  public A addToOrderLast(int index,String item) {
    if (this.orderLast == null) {
      this.orderLast = new ArrayList();
    }
    this.orderLast.add(index, item);
    return (A) this;
  }
  
  protected void copyInstance(LegacySortOptions instance) {
    instance = instance != null ? instance : new LegacySortOptions();
    if (instance != null) {
        this.withOrderFirst(instance.getOrderFirst());
        this.withOrderLast(instance.getOrderLast());
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
    LegacySortOptionsFluent that = (LegacySortOptionsFluent) o;
    if (!(Objects.equals(orderFirst, that.orderFirst))) {
      return false;
    }
    if (!(Objects.equals(orderLast, that.orderLast))) {
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
  
  public String getFirstOrderFirst() {
    return this.orderFirst.get(0);
  }
  
  public String getFirstOrderLast() {
    return this.orderLast.get(0);
  }
  
  public String getLastOrderFirst() {
    return this.orderFirst.get(orderFirst.size() - 1);
  }
  
  public String getLastOrderLast() {
    return this.orderLast.get(orderLast.size() - 1);
  }
  
  public String getMatchingOrderFirst(Predicate<String> predicate) {
      for (String item : orderFirst) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public String getMatchingOrderLast(Predicate<String> predicate) {
      for (String item : orderLast) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public List<String> getOrderFirst() {
    return this.orderFirst;
  }
  
  public String getOrderFirst(int index) {
    return this.orderFirst.get(index);
  }
  
  public List<String> getOrderLast() {
    return this.orderLast;
  }
  
  public String getOrderLast(int index) {
    return this.orderLast.get(index);
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasMatchingOrderFirst(Predicate<String> predicate) {
      for (String item : orderFirst) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingOrderLast(Predicate<String> predicate) {
      for (String item : orderLast) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasOrderFirst() {
    return this.orderFirst != null && !(this.orderFirst.isEmpty());
  }
  
  public boolean hasOrderLast() {
    return this.orderLast != null && !(this.orderLast.isEmpty());
  }
  
  public int hashCode() {
    return Objects.hash(orderFirst, orderLast, additionalProperties);
  }
  
  public A removeAllFromOrderFirst(Collection<String> items) {
    if (this.orderFirst == null) {
      return (A) this;
    }
    for (String item : items) {
      this.orderFirst.remove(item);
    }
    return (A) this;
  }
  
  public A removeAllFromOrderLast(Collection<String> items) {
    if (this.orderLast == null) {
      return (A) this;
    }
    for (String item : items) {
      this.orderLast.remove(item);
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
  
  public A removeFromOrderFirst(String... items) {
    if (this.orderFirst == null) {
      return (A) this;
    }
    for (String item : items) {
      this.orderFirst.remove(item);
    }
    return (A) this;
  }
  
  public A removeFromOrderLast(String... items) {
    if (this.orderLast == null) {
      return (A) this;
    }
    for (String item : items) {
      this.orderLast.remove(item);
    }
    return (A) this;
  }
  
  public A setToOrderFirst(int index,String item) {
    if (this.orderFirst == null) {
      this.orderFirst = new ArrayList();
    }
    this.orderFirst.set(index, item);
    return (A) this;
  }
  
  public A setToOrderLast(int index,String item) {
    if (this.orderLast == null) {
      this.orderLast = new ArrayList();
    }
    this.orderLast.set(index, item);
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(orderFirst == null) && !(orderFirst.isEmpty())) {
        sb.append("orderFirst:");
        sb.append(orderFirst);
        sb.append(",");
    }
    if (!(orderLast == null) && !(orderLast.isEmpty())) {
        sb.append("orderLast:");
        sb.append(orderLast);
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
  
  public A withOrderFirst(List<String> orderFirst) {
    if (orderFirst != null) {
        this.orderFirst = new ArrayList();
        for (String item : orderFirst) {
          this.addToOrderFirst(item);
        }
    } else {
      this.orderFirst = null;
    }
    return (A) this;
  }
  
  public A withOrderFirst(String... orderFirst) {
    if (this.orderFirst != null) {
        this.orderFirst.clear();
        _visitables.remove("orderFirst");
    }
    if (orderFirst != null) {
      for (String item : orderFirst) {
        this.addToOrderFirst(item);
      }
    }
    return (A) this;
  }
  
  public A withOrderLast(List<String> orderLast) {
    if (orderLast != null) {
        this.orderLast = new ArrayList();
        for (String item : orderLast) {
          this.addToOrderLast(item);
        }
    } else {
      this.orderLast = null;
    }
    return (A) this;
  }
  
  public A withOrderLast(String... orderLast) {
    if (this.orderLast != null) {
        this.orderLast.clear();
        _visitables.remove("orderLast");
    }
    if (orderLast != null) {
      for (String item : orderLast) {
        this.addToOrderLast(item);
      }
    }
    return (A) this;
  }
  
}