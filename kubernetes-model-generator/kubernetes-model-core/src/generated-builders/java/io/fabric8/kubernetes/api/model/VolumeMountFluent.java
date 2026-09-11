package io.fabric8.kubernetes.api.model;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import java.lang.Boolean;
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
public class VolumeMountFluent<A extends io.fabric8.kubernetes.api.model.VolumeMountFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private List<String> bindMountOptions = new ArrayList<String>();
  private String mountPath;
  private String mountPropagation;
  private String name;
  private Boolean readOnly;
  private String recursiveReadOnly;
  private String subPath;
  private String subPathExpr;

  public VolumeMountFluent() {
  }
  
  public VolumeMountFluent(VolumeMount instance) {
    this.copyInstance(instance);
  }

  public A addAllToBindMountOptions(Collection<String> items) {
    if (this.bindMountOptions == null) {
      this.bindMountOptions = new ArrayList();
    }
    for (String item : items) {
      this.bindMountOptions.add(item);
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
  
  public A addToBindMountOptions(String... items) {
    if (this.bindMountOptions == null) {
      this.bindMountOptions = new ArrayList();
    }
    for (String item : items) {
      this.bindMountOptions.add(item);
    }
    return (A) this;
  }
  
  public A addToBindMountOptions(int index,String item) {
    if (this.bindMountOptions == null) {
      this.bindMountOptions = new ArrayList();
    }
    this.bindMountOptions.add(index, item);
    return (A) this;
  }
  
  protected void copyInstance(VolumeMount instance) {
    instance = instance != null ? instance : new VolumeMount();
    if (instance != null) {
        this.withBindMountOptions(instance.getBindMountOptions());
        this.withMountPath(instance.getMountPath());
        this.withMountPropagation(instance.getMountPropagation());
        this.withName(instance.getName());
        this.withReadOnly(instance.getReadOnly());
        this.withRecursiveReadOnly(instance.getRecursiveReadOnly());
        this.withSubPath(instance.getSubPath());
        this.withSubPathExpr(instance.getSubPathExpr());
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
    VolumeMountFluent that = (VolumeMountFluent) o;
    if (!(Objects.equals(bindMountOptions, that.bindMountOptions))) {
      return false;
    }
    if (!(Objects.equals(mountPath, that.mountPath))) {
      return false;
    }
    if (!(Objects.equals(mountPropagation, that.mountPropagation))) {
      return false;
    }
    if (!(Objects.equals(name, that.name))) {
      return false;
    }
    if (!(Objects.equals(readOnly, that.readOnly))) {
      return false;
    }
    if (!(Objects.equals(recursiveReadOnly, that.recursiveReadOnly))) {
      return false;
    }
    if (!(Objects.equals(subPath, that.subPath))) {
      return false;
    }
    if (!(Objects.equals(subPathExpr, that.subPathExpr))) {
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
  
  public String getBindMountOption(int index) {
    return this.bindMountOptions.get(index);
  }
  
  public List<String> getBindMountOptions() {
    return this.bindMountOptions;
  }
  
  public String getFirstBindMountOption() {
    return this.bindMountOptions.get(0);
  }
  
  public String getLastBindMountOption() {
    return this.bindMountOptions.get(bindMountOptions.size() - 1);
  }
  
  public String getMatchingBindMountOption(Predicate<String> predicate) {
      for (String item : bindMountOptions) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public String getMountPath() {
    return this.mountPath;
  }
  
  public String getMountPropagation() {
    return this.mountPropagation;
  }
  
  public String getName() {
    return this.name;
  }
  
  public Boolean getReadOnly() {
    return this.readOnly;
  }
  
  public String getRecursiveReadOnly() {
    return this.recursiveReadOnly;
  }
  
  public String getSubPath() {
    return this.subPath;
  }
  
  public String getSubPathExpr() {
    return this.subPathExpr;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasBindMountOptions() {
    return this.bindMountOptions != null && !(this.bindMountOptions.isEmpty());
  }
  
  public boolean hasMatchingBindMountOption(Predicate<String> predicate) {
      for (String item : bindMountOptions) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMountPath() {
    return this.mountPath != null;
  }
  
  public boolean hasMountPropagation() {
    return this.mountPropagation != null;
  }
  
  public boolean hasName() {
    return this.name != null;
  }
  
  public boolean hasReadOnly() {
    return this.readOnly != null;
  }
  
  public boolean hasRecursiveReadOnly() {
    return this.recursiveReadOnly != null;
  }
  
  public boolean hasSubPath() {
    return this.subPath != null;
  }
  
  public boolean hasSubPathExpr() {
    return this.subPathExpr != null;
  }
  
  public int hashCode() {
    return Objects.hash(bindMountOptions, mountPath, mountPropagation, name, readOnly, recursiveReadOnly, subPath, subPathExpr, additionalProperties);
  }
  
  public A removeAllFromBindMountOptions(Collection<String> items) {
    if (this.bindMountOptions == null) {
      return (A) this;
    }
    for (String item : items) {
      this.bindMountOptions.remove(item);
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
  
  public A removeFromBindMountOptions(String... items) {
    if (this.bindMountOptions == null) {
      return (A) this;
    }
    for (String item : items) {
      this.bindMountOptions.remove(item);
    }
    return (A) this;
  }
  
  public A setToBindMountOptions(int index,String item) {
    if (this.bindMountOptions == null) {
      this.bindMountOptions = new ArrayList();
    }
    this.bindMountOptions.set(index, item);
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(bindMountOptions == null) && !(bindMountOptions.isEmpty())) {
        sb.append("bindMountOptions:");
        sb.append(bindMountOptions);
        sb.append(",");
    }
    if (!(mountPath == null)) {
        sb.append("mountPath:");
        sb.append(mountPath);
        sb.append(",");
    }
    if (!(mountPropagation == null)) {
        sb.append("mountPropagation:");
        sb.append(mountPropagation);
        sb.append(",");
    }
    if (!(name == null)) {
        sb.append("name:");
        sb.append(name);
        sb.append(",");
    }
    if (!(readOnly == null)) {
        sb.append("readOnly:");
        sb.append(readOnly);
        sb.append(",");
    }
    if (!(recursiveReadOnly == null)) {
        sb.append("recursiveReadOnly:");
        sb.append(recursiveReadOnly);
        sb.append(",");
    }
    if (!(subPath == null)) {
        sb.append("subPath:");
        sb.append(subPath);
        sb.append(",");
    }
    if (!(subPathExpr == null)) {
        sb.append("subPathExpr:");
        sb.append(subPathExpr);
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
  
  public A withBindMountOptions(List<String> bindMountOptions) {
    if (bindMountOptions != null) {
        this.bindMountOptions = new ArrayList();
        for (String item : bindMountOptions) {
          this.addToBindMountOptions(item);
        }
    } else {
      this.bindMountOptions = null;
    }
    return (A) this;
  }
  
  public A withBindMountOptions(String... bindMountOptions) {
    if (this.bindMountOptions != null) {
        this.bindMountOptions.clear();
        _visitables.remove("bindMountOptions");
    }
    if (bindMountOptions != null) {
      for (String item : bindMountOptions) {
        this.addToBindMountOptions(item);
      }
    }
    return (A) this;
  }
  
  public A withMountPath(String mountPath) {
    this.mountPath = mountPath;
    return (A) this;
  }
  
  public A withMountPropagation(String mountPropagation) {
    this.mountPropagation = mountPropagation;
    return (A) this;
  }
  
  public A withName(String name) {
    this.name = name;
    return (A) this;
  }
  
  public A withReadOnly() {
    return withReadOnly(true);
  }
  
  public A withReadOnly(Boolean readOnly) {
    this.readOnly = readOnly;
    return (A) this;
  }
  
  public A withRecursiveReadOnly(String recursiveReadOnly) {
    this.recursiveReadOnly = recursiveReadOnly;
    return (A) this;
  }
  
  public A withSubPath(String subPath) {
    this.subPath = subPath;
    return (A) this;
  }
  
  public A withSubPathExpr(String subPathExpr) {
    this.subPathExpr = subPathExpr;
    return (A) this;
  }
  
}