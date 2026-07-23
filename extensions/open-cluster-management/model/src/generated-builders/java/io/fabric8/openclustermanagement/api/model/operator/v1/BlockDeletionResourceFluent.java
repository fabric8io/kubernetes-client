package io.fabric8.openclustermanagement.api.model.operator.v1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.model.GroupVersionKind;
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
public class BlockDeletionResourceFluent<A extends io.fabric8.openclustermanagement.api.model.operator.v1.BlockDeletionResourceFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private Integer exceptionTotal;
  private GroupVersionKind gVK;
  private Map<String,String> labelExceptions;
  private String name;
  private List<String> nameExceptions = new ArrayList<String>();

  public BlockDeletionResourceFluent() {
  }
  
  public BlockDeletionResourceFluent(BlockDeletionResource instance) {
    this.copyInstance(instance);
  }

  public A addAllToNameExceptions(Collection<String> items) {
    if (this.nameExceptions == null) {
      this.nameExceptions = new ArrayList();
    }
    for (String item : items) {
      this.nameExceptions.add(item);
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
  
  public A addToLabelExceptions(Map<String,String> map) {
    if (this.labelExceptions == null && map != null) {
      this.labelExceptions = new LinkedHashMap();
    }
    if (map != null) {
      this.labelExceptions.putAll(map);
    }
    return (A) this;
  }
  
  public A addToLabelExceptions(String key,String value) {
    if (this.labelExceptions == null && key != null && value != null) {
      this.labelExceptions = new LinkedHashMap();
    }
    if (key != null && value != null) {
      this.labelExceptions.put(key, value);
    }
    return (A) this;
  }
  
  public A addToNameExceptions(String... items) {
    if (this.nameExceptions == null) {
      this.nameExceptions = new ArrayList();
    }
    for (String item : items) {
      this.nameExceptions.add(item);
    }
    return (A) this;
  }
  
  public A addToNameExceptions(int index,String item) {
    if (this.nameExceptions == null) {
      this.nameExceptions = new ArrayList();
    }
    this.nameExceptions.add(index, item);
    return (A) this;
  }
  
  protected void copyInstance(BlockDeletionResource instance) {
    instance = instance != null ? instance : new BlockDeletionResource();
    if (instance != null) {
        this.withExceptionTotal(instance.getExceptionTotal());
        this.withGVK(instance.getGVK());
        this.withLabelExceptions(instance.getLabelExceptions());
        this.withName(instance.getName());
        this.withNameExceptions(instance.getNameExceptions());
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
    BlockDeletionResourceFluent that = (BlockDeletionResourceFluent) o;
    if (!(Objects.equals(exceptionTotal, that.exceptionTotal))) {
      return false;
    }
    if (!(Objects.equals(gVK, that.gVK))) {
      return false;
    }
    if (!(Objects.equals(labelExceptions, that.labelExceptions))) {
      return false;
    }
    if (!(Objects.equals(name, that.name))) {
      return false;
    }
    if (!(Objects.equals(nameExceptions, that.nameExceptions))) {
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
  
  public Integer getExceptionTotal() {
    return this.exceptionTotal;
  }
  
  public String getFirstNameException() {
    return this.nameExceptions.get(0);
  }
  
  public GroupVersionKind getGVK() {
    return this.gVK;
  }
  
  public Map<String,String> getLabelExceptions() {
    return this.labelExceptions;
  }
  
  public String getLastNameException() {
    return this.nameExceptions.get(nameExceptions.size() - 1);
  }
  
  public String getMatchingNameException(Predicate<String> predicate) {
      for (String item : nameExceptions) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public String getName() {
    return this.name;
  }
  
  public String getNameException(int index) {
    return this.nameExceptions.get(index);
  }
  
  public List<String> getNameExceptions() {
    return this.nameExceptions;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasExceptionTotal() {
    return this.exceptionTotal != null;
  }
  
  public boolean hasGVK() {
    return this.gVK != null;
  }
  
  public boolean hasLabelExceptions() {
    return this.labelExceptions != null;
  }
  
  public boolean hasMatchingNameException(Predicate<String> predicate) {
      for (String item : nameExceptions) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasName() {
    return this.name != null;
  }
  
  public boolean hasNameExceptions() {
    return this.nameExceptions != null && !(this.nameExceptions.isEmpty());
  }
  
  public int hashCode() {
    return Objects.hash(exceptionTotal, gVK, labelExceptions, name, nameExceptions, additionalProperties);
  }
  
  public A removeAllFromNameExceptions(Collection<String> items) {
    if (this.nameExceptions == null) {
      return (A) this;
    }
    for (String item : items) {
      this.nameExceptions.remove(item);
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
  
  public A removeFromLabelExceptions(String key) {
    if (this.labelExceptions == null) {
      return (A) this;
    }
    if (key != null && this.labelExceptions != null) {
      this.labelExceptions.remove(key);
    }
    return (A) this;
  }
  
  public A removeFromLabelExceptions(Map<String,String> map) {
    if (this.labelExceptions == null) {
      return (A) this;
    }
    if (map != null) {
      for (Object key : map.keySet()) {
        if (this.labelExceptions != null) {
          this.labelExceptions.remove(key);
        }
      }
    }
    return (A) this;
  }
  
  public A removeFromNameExceptions(String... items) {
    if (this.nameExceptions == null) {
      return (A) this;
    }
    for (String item : items) {
      this.nameExceptions.remove(item);
    }
    return (A) this;
  }
  
  public A setToNameExceptions(int index,String item) {
    if (this.nameExceptions == null) {
      this.nameExceptions = new ArrayList();
    }
    this.nameExceptions.set(index, item);
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(exceptionTotal == null)) {
        sb.append("exceptionTotal:");
        sb.append(exceptionTotal);
        sb.append(",");
    }
    if (!(gVK == null)) {
        sb.append("gVK:");
        sb.append(gVK);
        sb.append(",");
    }
    if (!(labelExceptions == null) && !(labelExceptions.isEmpty())) {
        sb.append("labelExceptions:");
        sb.append(labelExceptions);
        sb.append(",");
    }
    if (!(name == null)) {
        sb.append("name:");
        sb.append(name);
        sb.append(",");
    }
    if (!(nameExceptions == null) && !(nameExceptions.isEmpty())) {
        sb.append("nameExceptions:");
        sb.append(nameExceptions);
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
  
  public A withExceptionTotal(Integer exceptionTotal) {
    this.exceptionTotal = exceptionTotal;
    return (A) this;
  }
  
  public A withGVK(GroupVersionKind gVK) {
    this.gVK = gVK;
    return (A) this;
  }
  
  public <K,V>A withLabelExceptions(Map<String,String> labelExceptions) {
    if (labelExceptions == null) {
      this.labelExceptions = null;
    } else {
      this.labelExceptions = new LinkedHashMap(labelExceptions);
    }
    return (A) this;
  }
  
  public A withName(String name) {
    this.name = name;
    return (A) this;
  }
  
  public A withNameExceptions(List<String> nameExceptions) {
    if (nameExceptions != null) {
        this.nameExceptions = new ArrayList();
        for (String item : nameExceptions) {
          this.addToNameExceptions(item);
        }
    } else {
      this.nameExceptions = null;
    }
    return (A) this;
  }
  
  public A withNameExceptions(String... nameExceptions) {
    if (this.nameExceptions != null) {
        this.nameExceptions.clear();
        _visitables.remove("nameExceptions");
    }
    if (nameExceptions != null) {
      for (String item : nameExceptions) {
        this.addToNameExceptions(item);
      }
    }
    return (A) this;
  }
  
  public A withNewGVK(String group,String kind,String version) {
    return (A) this.withGVK(new GroupVersionKind(group, kind, version));
  }
  
}