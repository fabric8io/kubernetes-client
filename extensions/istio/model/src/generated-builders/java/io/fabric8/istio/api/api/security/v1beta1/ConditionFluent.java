package io.fabric8.istio.api.api.security.v1beta1;

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
public class ConditionFluent<A extends io.fabric8.istio.api.api.security.v1beta1.ConditionFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String key;
  private List<String> notValues = new ArrayList<String>();
  private List<String> values = new ArrayList<String>();

  public ConditionFluent() {
  }
  
  public ConditionFluent(Condition instance) {
    this.copyInstance(instance);
  }

  public A addAllToNotValues(Collection<String> items) {
    if (this.notValues == null) {
      this.notValues = new ArrayList();
    }
    for (String item : items) {
      this.notValues.add(item);
    }
    return (A) this;
  }
  
  public A addAllToValues(Collection<String> items) {
    if (this.values == null) {
      this.values = new ArrayList();
    }
    for (String item : items) {
      this.values.add(item);
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
  
  public A addToNotValues(String... items) {
    if (this.notValues == null) {
      this.notValues = new ArrayList();
    }
    for (String item : items) {
      this.notValues.add(item);
    }
    return (A) this;
  }
  
  public A addToNotValues(int index,String item) {
    if (this.notValues == null) {
      this.notValues = new ArrayList();
    }
    this.notValues.add(index, item);
    return (A) this;
  }
  
  public A addToValues(String... items) {
    if (this.values == null) {
      this.values = new ArrayList();
    }
    for (String item : items) {
      this.values.add(item);
    }
    return (A) this;
  }
  
  public A addToValues(int index,String item) {
    if (this.values == null) {
      this.values = new ArrayList();
    }
    this.values.add(index, item);
    return (A) this;
  }
  
  protected void copyInstance(Condition instance) {
    instance = instance != null ? instance : new Condition();
    if (instance != null) {
        this.withKey(instance.getKey());
        this.withNotValues(instance.getNotValues());
        this.withValues(instance.getValues());
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
    ConditionFluent that = (ConditionFluent) o;
    if (!(Objects.equals(key, that.key))) {
      return false;
    }
    if (!(Objects.equals(notValues, that.notValues))) {
      return false;
    }
    if (!(Objects.equals(values, that.values))) {
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
  
  public String getFirstNotValue() {
    return this.notValues.get(0);
  }
  
  public String getFirstValue() {
    return this.values.get(0);
  }
  
  public String getKey() {
    return this.key;
  }
  
  public String getLastNotValue() {
    return this.notValues.get(notValues.size() - 1);
  }
  
  public String getLastValue() {
    return this.values.get(values.size() - 1);
  }
  
  public String getMatchingNotValue(Predicate<String> predicate) {
      for (String item : notValues) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public String getMatchingValue(Predicate<String> predicate) {
      for (String item : values) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public String getNotValue(int index) {
    return this.notValues.get(index);
  }
  
  public List<String> getNotValues() {
    return this.notValues;
  }
  
  public String getValue(int index) {
    return this.values.get(index);
  }
  
  public List<String> getValues() {
    return this.values;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasKey() {
    return this.key != null;
  }
  
  public boolean hasMatchingNotValue(Predicate<String> predicate) {
      for (String item : notValues) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingValue(Predicate<String> predicate) {
      for (String item : values) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasNotValues() {
    return this.notValues != null && !(this.notValues.isEmpty());
  }
  
  public boolean hasValues() {
    return this.values != null && !(this.values.isEmpty());
  }
  
  public int hashCode() {
    return Objects.hash(key, notValues, values, additionalProperties);
  }
  
  public A removeAllFromNotValues(Collection<String> items) {
    if (this.notValues == null) {
      return (A) this;
    }
    for (String item : items) {
      this.notValues.remove(item);
    }
    return (A) this;
  }
  
  public A removeAllFromValues(Collection<String> items) {
    if (this.values == null) {
      return (A) this;
    }
    for (String item : items) {
      this.values.remove(item);
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
  
  public A removeFromNotValues(String... items) {
    if (this.notValues == null) {
      return (A) this;
    }
    for (String item : items) {
      this.notValues.remove(item);
    }
    return (A) this;
  }
  
  public A removeFromValues(String... items) {
    if (this.values == null) {
      return (A) this;
    }
    for (String item : items) {
      this.values.remove(item);
    }
    return (A) this;
  }
  
  public A setToNotValues(int index,String item) {
    if (this.notValues == null) {
      this.notValues = new ArrayList();
    }
    this.notValues.set(index, item);
    return (A) this;
  }
  
  public A setToValues(int index,String item) {
    if (this.values == null) {
      this.values = new ArrayList();
    }
    this.values.set(index, item);
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(key == null)) {
        sb.append("key:");
        sb.append(key);
        sb.append(",");
    }
    if (!(notValues == null) && !(notValues.isEmpty())) {
        sb.append("notValues:");
        sb.append(notValues);
        sb.append(",");
    }
    if (!(values == null) && !(values.isEmpty())) {
        sb.append("values:");
        sb.append(values);
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
  
  public A withKey(String key) {
    this.key = key;
    return (A) this;
  }
  
  public A withNotValues(List<String> notValues) {
    if (notValues != null) {
        this.notValues = new ArrayList();
        for (String item : notValues) {
          this.addToNotValues(item);
        }
    } else {
      this.notValues = null;
    }
    return (A) this;
  }
  
  public A withNotValues(String... notValues) {
    if (this.notValues != null) {
        this.notValues.clear();
        _visitables.remove("notValues");
    }
    if (notValues != null) {
      for (String item : notValues) {
        this.addToNotValues(item);
      }
    }
    return (A) this;
  }
  
  public A withValues(List<String> values) {
    if (values != null) {
        this.values = new ArrayList();
        for (String item : values) {
          this.addToValues(item);
        }
    } else {
      this.values = null;
    }
    return (A) this;
  }
  
  public A withValues(String... values) {
    if (this.values != null) {
        this.values.clear();
        _visitables.remove("values");
    }
    if (values != null) {
      for (String item : values) {
        this.addToValues(item);
      }
    }
    return (A) this;
  }
  
}