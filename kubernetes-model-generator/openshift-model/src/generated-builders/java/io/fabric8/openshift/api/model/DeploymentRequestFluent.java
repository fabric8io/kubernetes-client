package io.fabric8.openshift.api.model;

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
public class DeploymentRequestFluent<A extends io.fabric8.openshift.api.model.DeploymentRequestFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String apiVersion;
  private List<String> excludeTriggers = new ArrayList<String>();
  private Boolean force;
  private String kind;
  private Boolean latest;
  private String name;

  public DeploymentRequestFluent() {
  }
  
  public DeploymentRequestFluent(DeploymentRequest instance) {
    this.copyInstance(instance);
  }

  public A addAllToExcludeTriggers(Collection<String> items) {
    if (this.excludeTriggers == null) {
      this.excludeTriggers = new ArrayList();
    }
    for (String item : items) {
      this.excludeTriggers.add(item);
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
  
  public A addToExcludeTriggers(String... items) {
    if (this.excludeTriggers == null) {
      this.excludeTriggers = new ArrayList();
    }
    for (String item : items) {
      this.excludeTriggers.add(item);
    }
    return (A) this;
  }
  
  public A addToExcludeTriggers(int index,String item) {
    if (this.excludeTriggers == null) {
      this.excludeTriggers = new ArrayList();
    }
    this.excludeTriggers.add(index, item);
    return (A) this;
  }
  
  protected void copyInstance(DeploymentRequest instance) {
    instance = instance != null ? instance : new DeploymentRequest();
    if (instance != null) {
        this.withApiVersion(instance.getApiVersion());
        this.withExcludeTriggers(instance.getExcludeTriggers());
        this.withForce(instance.getForce());
        this.withKind(instance.getKind());
        this.withLatest(instance.getLatest());
        this.withName(instance.getName());
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
    DeploymentRequestFluent that = (DeploymentRequestFluent) o;
    if (!(Objects.equals(apiVersion, that.apiVersion))) {
      return false;
    }
    if (!(Objects.equals(excludeTriggers, that.excludeTriggers))) {
      return false;
    }
    if (!(Objects.equals(force, that.force))) {
      return false;
    }
    if (!(Objects.equals(kind, that.kind))) {
      return false;
    }
    if (!(Objects.equals(latest, that.latest))) {
      return false;
    }
    if (!(Objects.equals(name, that.name))) {
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
  
  public String getExcludeTrigger(int index) {
    return this.excludeTriggers.get(index);
  }
  
  public List<String> getExcludeTriggers() {
    return this.excludeTriggers;
  }
  
  public String getFirstExcludeTrigger() {
    return this.excludeTriggers.get(0);
  }
  
  public Boolean getForce() {
    return this.force;
  }
  
  public String getKind() {
    return this.kind;
  }
  
  public String getLastExcludeTrigger() {
    return this.excludeTriggers.get(excludeTriggers.size() - 1);
  }
  
  public Boolean getLatest() {
    return this.latest;
  }
  
  public String getMatchingExcludeTrigger(Predicate<String> predicate) {
      for (String item : excludeTriggers) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public String getName() {
    return this.name;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasApiVersion() {
    return this.apiVersion != null;
  }
  
  public boolean hasExcludeTriggers() {
    return this.excludeTriggers != null && !(this.excludeTriggers.isEmpty());
  }
  
  public boolean hasForce() {
    return this.force != null;
  }
  
  public boolean hasKind() {
    return this.kind != null;
  }
  
  public boolean hasLatest() {
    return this.latest != null;
  }
  
  public boolean hasMatchingExcludeTrigger(Predicate<String> predicate) {
      for (String item : excludeTriggers) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasName() {
    return this.name != null;
  }
  
  public int hashCode() {
    return Objects.hash(apiVersion, excludeTriggers, force, kind, latest, name, additionalProperties);
  }
  
  public A removeAllFromExcludeTriggers(Collection<String> items) {
    if (this.excludeTriggers == null) {
      return (A) this;
    }
    for (String item : items) {
      this.excludeTriggers.remove(item);
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
  
  public A removeFromExcludeTriggers(String... items) {
    if (this.excludeTriggers == null) {
      return (A) this;
    }
    for (String item : items) {
      this.excludeTriggers.remove(item);
    }
    return (A) this;
  }
  
  public A setToExcludeTriggers(int index,String item) {
    if (this.excludeTriggers == null) {
      this.excludeTriggers = new ArrayList();
    }
    this.excludeTriggers.set(index, item);
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
    if (!(excludeTriggers == null) && !(excludeTriggers.isEmpty())) {
        sb.append("excludeTriggers:");
        sb.append(excludeTriggers);
        sb.append(",");
    }
    if (!(force == null)) {
        sb.append("force:");
        sb.append(force);
        sb.append(",");
    }
    if (!(kind == null)) {
        sb.append("kind:");
        sb.append(kind);
        sb.append(",");
    }
    if (!(latest == null)) {
        sb.append("latest:");
        sb.append(latest);
        sb.append(",");
    }
    if (!(name == null)) {
        sb.append("name:");
        sb.append(name);
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
  
  public A withExcludeTriggers(List<String> excludeTriggers) {
    if (excludeTriggers != null) {
        this.excludeTriggers = new ArrayList();
        for (String item : excludeTriggers) {
          this.addToExcludeTriggers(item);
        }
    } else {
      this.excludeTriggers = null;
    }
    return (A) this;
  }
  
  public A withExcludeTriggers(String... excludeTriggers) {
    if (this.excludeTriggers != null) {
        this.excludeTriggers.clear();
        _visitables.remove("excludeTriggers");
    }
    if (excludeTriggers != null) {
      for (String item : excludeTriggers) {
        this.addToExcludeTriggers(item);
      }
    }
    return (A) this;
  }
  
  public A withForce() {
    return withForce(true);
  }
  
  public A withForce(Boolean force) {
    this.force = force;
    return (A) this;
  }
  
  public A withKind(String kind) {
    this.kind = kind;
    return (A) this;
  }
  
  public A withLatest() {
    return withLatest(true);
  }
  
  public A withLatest(Boolean latest) {
    this.latest = latest;
    return (A) this;
  }
  
  public A withName(String name) {
    this.name = name;
    return (A) this;
  }
  
}