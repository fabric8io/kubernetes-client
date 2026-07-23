package io.fabric8.kubernetes.api.model;

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
public class UpdateOptionsFluent<A extends io.fabric8.kubernetes.api.model.UpdateOptionsFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String apiVersion;
  private List<String> dryRun = new ArrayList<String>();
  private String fieldManager;
  private String fieldValidation;
  private String kind;

  public UpdateOptionsFluent() {
  }
  
  public UpdateOptionsFluent(UpdateOptions instance) {
    this.copyInstance(instance);
  }

  public A addAllToDryRun(Collection<String> items) {
    if (this.dryRun == null) {
      this.dryRun = new ArrayList();
    }
    for (String item : items) {
      this.dryRun.add(item);
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
  
  public A addToDryRun(String... items) {
    if (this.dryRun == null) {
      this.dryRun = new ArrayList();
    }
    for (String item : items) {
      this.dryRun.add(item);
    }
    return (A) this;
  }
  
  public A addToDryRun(int index,String item) {
    if (this.dryRun == null) {
      this.dryRun = new ArrayList();
    }
    this.dryRun.add(index, item);
    return (A) this;
  }
  
  protected void copyInstance(UpdateOptions instance) {
    instance = instance != null ? instance : new UpdateOptions();
    if (instance != null) {
        this.withApiVersion(instance.getApiVersion());
        this.withDryRun(instance.getDryRun());
        this.withFieldManager(instance.getFieldManager());
        this.withFieldValidation(instance.getFieldValidation());
        this.withKind(instance.getKind());
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
    UpdateOptionsFluent that = (UpdateOptionsFluent) o;
    if (!(Objects.equals(apiVersion, that.apiVersion))) {
      return false;
    }
    if (!(Objects.equals(dryRun, that.dryRun))) {
      return false;
    }
    if (!(Objects.equals(fieldManager, that.fieldManager))) {
      return false;
    }
    if (!(Objects.equals(fieldValidation, that.fieldValidation))) {
      return false;
    }
    if (!(Objects.equals(kind, that.kind))) {
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
  
  public String getApiVersion() {
    return this.apiVersion;
  }
  
  public List<String> getDryRun() {
    return this.dryRun;
  }
  
  public String getDryRun(int index) {
    return this.dryRun.get(index);
  }
  
  public String getFieldManager() {
    return this.fieldManager;
  }
  
  public String getFieldValidation() {
    return this.fieldValidation;
  }
  
  public String getFirstDryRun() {
    return this.dryRun.get(0);
  }
  
  public String getKind() {
    return this.kind;
  }
  
  public String getLastDryRun() {
    return this.dryRun.get(dryRun.size() - 1);
  }
  
  public String getMatchingDryRun(Predicate<String> predicate) {
      for (String item : dryRun) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasApiVersion() {
    return this.apiVersion != null;
  }
  
  public boolean hasDryRun() {
    return this.dryRun != null && !(this.dryRun.isEmpty());
  }
  
  public boolean hasFieldManager() {
    return this.fieldManager != null;
  }
  
  public boolean hasFieldValidation() {
    return this.fieldValidation != null;
  }
  
  public boolean hasKind() {
    return this.kind != null;
  }
  
  public boolean hasMatchingDryRun(Predicate<String> predicate) {
      for (String item : dryRun) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public int hashCode() {
    return Objects.hash(apiVersion, dryRun, fieldManager, fieldValidation, kind, additionalProperties);
  }
  
  public A removeAllFromDryRun(Collection<String> items) {
    if (this.dryRun == null) {
      return (A) this;
    }
    for (String item : items) {
      this.dryRun.remove(item);
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
  
  public A removeFromDryRun(String... items) {
    if (this.dryRun == null) {
      return (A) this;
    }
    for (String item : items) {
      this.dryRun.remove(item);
    }
    return (A) this;
  }
  
  public A setToDryRun(int index,String item) {
    if (this.dryRun == null) {
      this.dryRun = new ArrayList();
    }
    this.dryRun.set(index, item);
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(apiVersion == null)) {
        sb.append("apiVersion:");
        sb.append(apiVersion);
        sb.append(",");
    }
    if (!(dryRun == null) && !(dryRun.isEmpty())) {
        sb.append("dryRun:");
        sb.append(dryRun);
        sb.append(",");
    }
    if (!(fieldManager == null)) {
        sb.append("fieldManager:");
        sb.append(fieldManager);
        sb.append(",");
    }
    if (!(fieldValidation == null)) {
        sb.append("fieldValidation:");
        sb.append(fieldValidation);
        sb.append(",");
    }
    if (!(kind == null)) {
        sb.append("kind:");
        sb.append(kind);
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
  
  public A withApiVersion(String apiVersion) {
    this.apiVersion = apiVersion;
    return (A) this;
  }
  
  public A withDryRun(List<String> dryRun) {
    if (dryRun != null) {
        this.dryRun = new ArrayList();
        for (String item : dryRun) {
          this.addToDryRun(item);
        }
    } else {
      this.dryRun = null;
    }
    return (A) this;
  }
  
  public A withDryRun(String... dryRun) {
    if (this.dryRun != null) {
        this.dryRun.clear();
        _visitables.remove("dryRun");
    }
    if (dryRun != null) {
      for (String item : dryRun) {
        this.addToDryRun(item);
      }
    }
    return (A) this;
  }
  
  public A withFieldManager(String fieldManager) {
    this.fieldManager = fieldManager;
    return (A) this;
  }
  
  public A withFieldValidation(String fieldValidation) {
    this.fieldValidation = fieldValidation;
    return (A) this;
  }
  
  public A withKind(String kind) {
    this.kind = kind;
    return (A) this;
  }
  
}