package io.fabric8.kubernetes.api.model.batch.v1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import java.lang.Integer;
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
public class PodFailurePolicyOnExitCodesRequirementFluent<A extends io.fabric8.kubernetes.api.model.batch.v1.PodFailurePolicyOnExitCodesRequirementFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String containerName;
  private String operator;
  private List<Integer> values = new ArrayList<Integer>();

  public PodFailurePolicyOnExitCodesRequirementFluent() {
  }
  
  public PodFailurePolicyOnExitCodesRequirementFluent(PodFailurePolicyOnExitCodesRequirement instance) {
    this.copyInstance(instance);
  }

  public A addAllToValues(Collection<Integer> items) {
    if (this.values == null) {
      this.values = new ArrayList();
    }
    for (Integer item : items) {
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
  
  public A addToValues(Integer... items) {
    if (this.values == null) {
      this.values = new ArrayList();
    }
    for (Integer item : items) {
      this.values.add(item);
    }
    return (A) this;
  }
  
  public A addToValues(int index,Integer item) {
    if (this.values == null) {
      this.values = new ArrayList();
    }
    this.values.add(index, item);
    return (A) this;
  }
  
  protected void copyInstance(PodFailurePolicyOnExitCodesRequirement instance) {
    instance = instance != null ? instance : new PodFailurePolicyOnExitCodesRequirement();
    if (instance != null) {
        this.withContainerName(instance.getContainerName());
        this.withOperator(instance.getOperator());
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
    PodFailurePolicyOnExitCodesRequirementFluent that = (PodFailurePolicyOnExitCodesRequirementFluent) o;
    if (!(Objects.equals(containerName, that.containerName))) {
      return false;
    }
    if (!(Objects.equals(operator, that.operator))) {
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
  
  public String getContainerName() {
    return this.containerName;
  }
  
  public Integer getFirstValue() {
    return this.values.get(0);
  }
  
  public Integer getLastValue() {
    return this.values.get(values.size() - 1);
  }
  
  public Integer getMatchingValue(Predicate<Integer> predicate) {
      for (Integer item : values) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public String getOperator() {
    return this.operator;
  }
  
  public Integer getValue(int index) {
    return this.values.get(index);
  }
  
  public List<Integer> getValues() {
    return this.values;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasContainerName() {
    return this.containerName != null;
  }
  
  public boolean hasMatchingValue(Predicate<Integer> predicate) {
      for (Integer item : values) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasOperator() {
    return this.operator != null;
  }
  
  public boolean hasValues() {
    return this.values != null && !(this.values.isEmpty());
  }
  
  public int hashCode() {
    return Objects.hash(containerName, operator, values, additionalProperties);
  }
  
  public A removeAllFromValues(Collection<Integer> items) {
    if (this.values == null) {
      return (A) this;
    }
    for (Integer item : items) {
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
  
  public A removeFromValues(Integer... items) {
    if (this.values == null) {
      return (A) this;
    }
    for (Integer item : items) {
      this.values.remove(item);
    }
    return (A) this;
  }
  
  public A setToValues(int index,Integer item) {
    if (this.values == null) {
      this.values = new ArrayList();
    }
    this.values.set(index, item);
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(containerName == null)) {
        sb.append("containerName:");
        sb.append(containerName);
        sb.append(",");
    }
    if (!(operator == null)) {
        sb.append("operator:");
        sb.append(operator);
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
  
  public A withContainerName(String containerName) {
    this.containerName = containerName;
    return (A) this;
  }
  
  public A withOperator(String operator) {
    this.operator = operator;
    return (A) this;
  }
  
  public A withValues(List<Integer> values) {
    if (values != null) {
        this.values = new ArrayList();
        for (Integer item : values) {
          this.addToValues(item);
        }
    } else {
      this.values = null;
    }
    return (A) this;
  }
  
  public A withValues(Integer... values) {
    if (this.values != null) {
        this.values.clear();
        _visitables.remove("values");
    }
    if (values != null) {
      for (Integer item : values) {
        this.addToValues(item);
      }
    }
    return (A) this;
  }
  
}