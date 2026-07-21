package io.fabric8.volcano.api.model.scheduling.v1beta1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.model.Quantity;
import java.lang.Integer;
import java.lang.Object;
import java.lang.String;
import java.lang.StringBuilder;
import java.lang.SuppressWarnings;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

/**
 * Generated
 */
@SuppressWarnings("unchecked")
public class PodGroupSpecFluent<A extends io.fabric8.volcano.api.model.scheduling.v1beta1.PodGroupSpecFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private Integer minMember;
  private Map<String,Quantity> minResources;
  private Map<String,Integer> minTaskMember;
  private String priorityClassName;
  private String queue;

  public PodGroupSpecFluent() {
  }
  
  public PodGroupSpecFluent(PodGroupSpec instance) {
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
  
  public A addToMinResources(Map<String,Quantity> map) {
    if (this.minResources == null && map != null) {
      this.minResources = new LinkedHashMap();
    }
    if (map != null) {
      this.minResources.putAll(map);
    }
    return (A) this;
  }
  
  public A addToMinResources(String key,Quantity value) {
    if (this.minResources == null && key != null && value != null) {
      this.minResources = new LinkedHashMap();
    }
    if (key != null && value != null) {
      this.minResources.put(key, value);
    }
    return (A) this;
  }
  
  public A addToMinTaskMember(Map<String,Integer> map) {
    if (this.minTaskMember == null && map != null) {
      this.minTaskMember = new LinkedHashMap();
    }
    if (map != null) {
      this.minTaskMember.putAll(map);
    }
    return (A) this;
  }
  
  public A addToMinTaskMember(String key,Integer value) {
    if (this.minTaskMember == null && key != null && value != null) {
      this.minTaskMember = new LinkedHashMap();
    }
    if (key != null && value != null) {
      this.minTaskMember.put(key, value);
    }
    return (A) this;
  }
  
  protected void copyInstance(PodGroupSpec instance) {
    instance = instance != null ? instance : new PodGroupSpec();
    if (instance != null) {
        this.withMinMember(instance.getMinMember());
        this.withMinResources(instance.getMinResources());
        this.withMinTaskMember(instance.getMinTaskMember());
        this.withPriorityClassName(instance.getPriorityClassName());
        this.withQueue(instance.getQueue());
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
    PodGroupSpecFluent that = (PodGroupSpecFluent) o;
    if (!(Objects.equals(minMember, that.minMember))) {
      return false;
    }
    if (!(Objects.equals(minResources, that.minResources))) {
      return false;
    }
    if (!(Objects.equals(minTaskMember, that.minTaskMember))) {
      return false;
    }
    if (!(Objects.equals(priorityClassName, that.priorityClassName))) {
      return false;
    }
    if (!(Objects.equals(queue, that.queue))) {
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
  
  public Integer getMinMember() {
    return this.minMember;
  }
  
  public Map<String,Quantity> getMinResources() {
    return this.minResources;
  }
  
  public Map<String,Integer> getMinTaskMember() {
    return this.minTaskMember;
  }
  
  public String getPriorityClassName() {
    return this.priorityClassName;
  }
  
  public String getQueue() {
    return this.queue;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasMinMember() {
    return this.minMember != null;
  }
  
  public boolean hasMinResources() {
    return this.minResources != null;
  }
  
  public boolean hasMinTaskMember() {
    return this.minTaskMember != null;
  }
  
  public boolean hasPriorityClassName() {
    return this.priorityClassName != null;
  }
  
  public boolean hasQueue() {
    return this.queue != null;
  }
  
  public int hashCode() {
    return Objects.hash(minMember, minResources, minTaskMember, priorityClassName, queue, additionalProperties);
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
  
  public A removeFromMinResources(String key) {
    if (this.minResources == null) {
      return (A) this;
    }
    if (key != null && this.minResources != null) {
      this.minResources.remove(key);
    }
    return (A) this;
  }
  
  public A removeFromMinResources(Map<String,Quantity> map) {
    if (this.minResources == null) {
      return (A) this;
    }
    if (map != null) {
      for (Object key : map.keySet()) {
        if (this.minResources != null) {
          this.minResources.remove(key);
        }
      }
    }
    return (A) this;
  }
  
  public A removeFromMinTaskMember(String key) {
    if (this.minTaskMember == null) {
      return (A) this;
    }
    if (key != null && this.minTaskMember != null) {
      this.minTaskMember.remove(key);
    }
    return (A) this;
  }
  
  public A removeFromMinTaskMember(Map<String,Integer> map) {
    if (this.minTaskMember == null) {
      return (A) this;
    }
    if (map != null) {
      for (Object key : map.keySet()) {
        if (this.minTaskMember != null) {
          this.minTaskMember.remove(key);
        }
      }
    }
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(minMember == null)) {
        sb.append("minMember:");
        sb.append(minMember);
        sb.append(",");
    }
    if (!(minResources == null) && !(minResources.isEmpty())) {
        sb.append("minResources:");
        sb.append(minResources);
        sb.append(",");
    }
    if (!(minTaskMember == null) && !(minTaskMember.isEmpty())) {
        sb.append("minTaskMember:");
        sb.append(minTaskMember);
        sb.append(",");
    }
    if (!(priorityClassName == null)) {
        sb.append("priorityClassName:");
        sb.append(priorityClassName);
        sb.append(",");
    }
    if (!(queue == null)) {
        sb.append("queue:");
        sb.append(queue);
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
  
  public A withMinMember(Integer minMember) {
    this.minMember = minMember;
    return (A) this;
  }
  
  public <K,V>A withMinResources(Map<String,Quantity> minResources) {
    if (minResources == null) {
      this.minResources = null;
    } else {
      this.minResources = new LinkedHashMap(minResources);
    }
    return (A) this;
  }
  
  public <K,V>A withMinTaskMember(Map<String,Integer> minTaskMember) {
    if (minTaskMember == null) {
      this.minTaskMember = null;
    } else {
      this.minTaskMember = new LinkedHashMap(minTaskMember);
    }
    return (A) this;
  }
  
  public A withPriorityClassName(String priorityClassName) {
    this.priorityClassName = priorityClassName;
    return (A) this;
  }
  
  public A withQueue(String queue) {
    this.queue = queue;
    return (A) this;
  }
  
}