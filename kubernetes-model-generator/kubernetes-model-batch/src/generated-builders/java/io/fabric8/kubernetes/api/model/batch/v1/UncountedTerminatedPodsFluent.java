package io.fabric8.kubernetes.api.model.batch.v1;

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
public class UncountedTerminatedPodsFluent<A extends io.fabric8.kubernetes.api.model.batch.v1.UncountedTerminatedPodsFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private List<String> failed = new ArrayList<String>();
  private List<String> succeeded = new ArrayList<String>();

  public UncountedTerminatedPodsFluent() {
  }
  
  public UncountedTerminatedPodsFluent(UncountedTerminatedPods instance) {
    this.copyInstance(instance);
  }

  public A addAllToFailed(Collection<String> items) {
    if (this.failed == null) {
      this.failed = new ArrayList();
    }
    for (String item : items) {
      this.failed.add(item);
    }
    return (A) this;
  }
  
  public A addAllToSucceeded(Collection<String> items) {
    if (this.succeeded == null) {
      this.succeeded = new ArrayList();
    }
    for (String item : items) {
      this.succeeded.add(item);
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
  
  public A addToFailed(String... items) {
    if (this.failed == null) {
      this.failed = new ArrayList();
    }
    for (String item : items) {
      this.failed.add(item);
    }
    return (A) this;
  }
  
  public A addToFailed(int index,String item) {
    if (this.failed == null) {
      this.failed = new ArrayList();
    }
    this.failed.add(index, item);
    return (A) this;
  }
  
  public A addToSucceeded(String... items) {
    if (this.succeeded == null) {
      this.succeeded = new ArrayList();
    }
    for (String item : items) {
      this.succeeded.add(item);
    }
    return (A) this;
  }
  
  public A addToSucceeded(int index,String item) {
    if (this.succeeded == null) {
      this.succeeded = new ArrayList();
    }
    this.succeeded.add(index, item);
    return (A) this;
  }
  
  protected void copyInstance(UncountedTerminatedPods instance) {
    instance = instance != null ? instance : new UncountedTerminatedPods();
    if (instance != null) {
        this.withFailed(instance.getFailed());
        this.withSucceeded(instance.getSucceeded());
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
    UncountedTerminatedPodsFluent that = (UncountedTerminatedPodsFluent) o;
    if (!(Objects.equals(failed, that.failed))) {
      return false;
    }
    if (!(Objects.equals(succeeded, that.succeeded))) {
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
  
  public List<String> getFailed() {
    return this.failed;
  }
  
  public String getFailed(int index) {
    return this.failed.get(index);
  }
  
  public String getFirstFailed() {
    return this.failed.get(0);
  }
  
  public String getFirstSucceeded() {
    return this.succeeded.get(0);
  }
  
  public String getLastFailed() {
    return this.failed.get(failed.size() - 1);
  }
  
  public String getLastSucceeded() {
    return this.succeeded.get(succeeded.size() - 1);
  }
  
  public String getMatchingFailed(Predicate<String> predicate) {
      for (String item : failed) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public String getMatchingSucceeded(Predicate<String> predicate) {
      for (String item : succeeded) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public List<String> getSucceeded() {
    return this.succeeded;
  }
  
  public String getSucceeded(int index) {
    return this.succeeded.get(index);
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasFailed() {
    return this.failed != null && !(this.failed.isEmpty());
  }
  
  public boolean hasMatchingFailed(Predicate<String> predicate) {
      for (String item : failed) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingSucceeded(Predicate<String> predicate) {
      for (String item : succeeded) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasSucceeded() {
    return this.succeeded != null && !(this.succeeded.isEmpty());
  }
  
  public int hashCode() {
    return Objects.hash(failed, succeeded, additionalProperties);
  }
  
  public A removeAllFromFailed(Collection<String> items) {
    if (this.failed == null) {
      return (A) this;
    }
    for (String item : items) {
      this.failed.remove(item);
    }
    return (A) this;
  }
  
  public A removeAllFromSucceeded(Collection<String> items) {
    if (this.succeeded == null) {
      return (A) this;
    }
    for (String item : items) {
      this.succeeded.remove(item);
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
  
  public A removeFromFailed(String... items) {
    if (this.failed == null) {
      return (A) this;
    }
    for (String item : items) {
      this.failed.remove(item);
    }
    return (A) this;
  }
  
  public A removeFromSucceeded(String... items) {
    if (this.succeeded == null) {
      return (A) this;
    }
    for (String item : items) {
      this.succeeded.remove(item);
    }
    return (A) this;
  }
  
  public A setToFailed(int index,String item) {
    if (this.failed == null) {
      this.failed = new ArrayList();
    }
    this.failed.set(index, item);
    return (A) this;
  }
  
  public A setToSucceeded(int index,String item) {
    if (this.succeeded == null) {
      this.succeeded = new ArrayList();
    }
    this.succeeded.set(index, item);
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(failed == null) && !(failed.isEmpty())) {
        sb.append("failed:");
        sb.append(failed);
        sb.append(",");
    }
    if (!(succeeded == null) && !(succeeded.isEmpty())) {
        sb.append("succeeded:");
        sb.append(succeeded);
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
  
  public A withFailed(List<String> failed) {
    if (failed != null) {
        this.failed = new ArrayList();
        for (String item : failed) {
          this.addToFailed(item);
        }
    } else {
      this.failed = null;
    }
    return (A) this;
  }
  
  public A withFailed(String... failed) {
    if (this.failed != null) {
        this.failed.clear();
        _visitables.remove("failed");
    }
    if (failed != null) {
      for (String item : failed) {
        this.addToFailed(item);
      }
    }
    return (A) this;
  }
  
  public A withSucceeded(List<String> succeeded) {
    if (succeeded != null) {
        this.succeeded = new ArrayList();
        for (String item : succeeded) {
          this.addToSucceeded(item);
        }
    } else {
      this.succeeded = null;
    }
    return (A) this;
  }
  
  public A withSucceeded(String... succeeded) {
    if (this.succeeded != null) {
        this.succeeded.clear();
        _visitables.remove("succeeded");
    }
    if (succeeded != null) {
      for (String item : succeeded) {
        this.addToSucceeded(item);
      }
    }
    return (A) this;
  }
  
}