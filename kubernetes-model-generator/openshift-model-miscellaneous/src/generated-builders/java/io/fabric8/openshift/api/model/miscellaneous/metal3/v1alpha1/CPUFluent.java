package io.fabric8.openshift.api.model.miscellaneous.metal3.v1alpha1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import java.lang.Double;
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
public class CPUFluent<A extends io.fabric8.openshift.api.model.miscellaneous.metal3.v1alpha1.CPUFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String arch;
  private Double clockMegahertz;
  private Integer count;
  private List<String> flags = new ArrayList<String>();
  private String model;

  public CPUFluent() {
  }
  
  public CPUFluent(CPU instance) {
    this.copyInstance(instance);
  }

  public A addAllToFlags(Collection<String> items) {
    if (this.flags == null) {
      this.flags = new ArrayList();
    }
    for (String item : items) {
      this.flags.add(item);
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
  
  public A addToFlags(String... items) {
    if (this.flags == null) {
      this.flags = new ArrayList();
    }
    for (String item : items) {
      this.flags.add(item);
    }
    return (A) this;
  }
  
  public A addToFlags(int index,String item) {
    if (this.flags == null) {
      this.flags = new ArrayList();
    }
    this.flags.add(index, item);
    return (A) this;
  }
  
  protected void copyInstance(CPU instance) {
    instance = instance != null ? instance : new CPU();
    if (instance != null) {
        this.withArch(instance.getArch());
        this.withClockMegahertz(instance.getClockMegahertz());
        this.withCount(instance.getCount());
        this.withFlags(instance.getFlags());
        this.withModel(instance.getModel());
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
    CPUFluent that = (CPUFluent) o;
    if (!(Objects.equals(arch, that.arch))) {
      return false;
    }
    if (!(Objects.equals(clockMegahertz, that.clockMegahertz))) {
      return false;
    }
    if (!(Objects.equals(count, that.count))) {
      return false;
    }
    if (!(Objects.equals(flags, that.flags))) {
      return false;
    }
    if (!(Objects.equals(model, that.model))) {
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
  
  public String getArch() {
    return this.arch;
  }
  
  public Double getClockMegahertz() {
    return this.clockMegahertz;
  }
  
  public Integer getCount() {
    return this.count;
  }
  
  public String getFirstFlag() {
    return this.flags.get(0);
  }
  
  public String getFlag(int index) {
    return this.flags.get(index);
  }
  
  public List<String> getFlags() {
    return this.flags;
  }
  
  public String getLastFlag() {
    return this.flags.get(flags.size() - 1);
  }
  
  public String getMatchingFlag(Predicate<String> predicate) {
      for (String item : flags) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public String getModel() {
    return this.model;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasArch() {
    return this.arch != null;
  }
  
  public boolean hasClockMegahertz() {
    return this.clockMegahertz != null;
  }
  
  public boolean hasCount() {
    return this.count != null;
  }
  
  public boolean hasFlags() {
    return this.flags != null && !(this.flags.isEmpty());
  }
  
  public boolean hasMatchingFlag(Predicate<String> predicate) {
      for (String item : flags) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasModel() {
    return this.model != null;
  }
  
  public int hashCode() {
    return Objects.hash(arch, clockMegahertz, count, flags, model, additionalProperties);
  }
  
  public A removeAllFromFlags(Collection<String> items) {
    if (this.flags == null) {
      return (A) this;
    }
    for (String item : items) {
      this.flags.remove(item);
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
  
  public A removeFromFlags(String... items) {
    if (this.flags == null) {
      return (A) this;
    }
    for (String item : items) {
      this.flags.remove(item);
    }
    return (A) this;
  }
  
  public A setToFlags(int index,String item) {
    if (this.flags == null) {
      this.flags = new ArrayList();
    }
    this.flags.set(index, item);
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(arch == null)) {
        sb.append("arch:");
        sb.append(arch);
        sb.append(",");
    }
    if (!(clockMegahertz == null)) {
        sb.append("clockMegahertz:");
        sb.append(clockMegahertz);
        sb.append(",");
    }
    if (!(count == null)) {
        sb.append("count:");
        sb.append(count);
        sb.append(",");
    }
    if (!(flags == null) && !(flags.isEmpty())) {
        sb.append("flags:");
        sb.append(flags);
        sb.append(",");
    }
    if (!(model == null)) {
        sb.append("model:");
        sb.append(model);
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
  
  public A withArch(String arch) {
    this.arch = arch;
    return (A) this;
  }
  
  public A withClockMegahertz(Double clockMegahertz) {
    this.clockMegahertz = clockMegahertz;
    return (A) this;
  }
  
  public A withCount(Integer count) {
    this.count = count;
    return (A) this;
  }
  
  public A withFlags(List<String> flags) {
    if (flags != null) {
        this.flags = new ArrayList();
        for (String item : flags) {
          this.addToFlags(item);
        }
    } else {
      this.flags = null;
    }
    return (A) this;
  }
  
  public A withFlags(String... flags) {
    if (this.flags != null) {
        this.flags.clear();
        _visitables.remove("flags");
    }
    if (flags != null) {
      for (String item : flags) {
        this.addToFlags(item);
      }
    }
    return (A) this;
  }
  
  public A withModel(String model) {
    this.model = model;
    return (A) this;
  }
  
}