package io.fabric8.openshift.api.model.monitoring.v1alpha1;

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
public class FileSDConfigFluent<A extends io.fabric8.openshift.api.model.monitoring.v1alpha1.FileSDConfigFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private List<String> files = new ArrayList<String>();
  private String refreshInterval;

  public FileSDConfigFluent() {
  }
  
  public FileSDConfigFluent(FileSDConfig instance) {
    this.copyInstance(instance);
  }

  public A addAllToFiles(Collection<String> items) {
    if (this.files == null) {
      this.files = new ArrayList();
    }
    for (String item : items) {
      this.files.add(item);
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
  
  public A addToFiles(String... items) {
    if (this.files == null) {
      this.files = new ArrayList();
    }
    for (String item : items) {
      this.files.add(item);
    }
    return (A) this;
  }
  
  public A addToFiles(int index,String item) {
    if (this.files == null) {
      this.files = new ArrayList();
    }
    this.files.add(index, item);
    return (A) this;
  }
  
  protected void copyInstance(FileSDConfig instance) {
    instance = instance != null ? instance : new FileSDConfig();
    if (instance != null) {
        this.withFiles(instance.getFiles());
        this.withRefreshInterval(instance.getRefreshInterval());
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
    FileSDConfigFluent that = (FileSDConfigFluent) o;
    if (!(Objects.equals(files, that.files))) {
      return false;
    }
    if (!(Objects.equals(refreshInterval, that.refreshInterval))) {
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
  
  public String getFile(int index) {
    return this.files.get(index);
  }
  
  public List<String> getFiles() {
    return this.files;
  }
  
  public String getFirstFile() {
    return this.files.get(0);
  }
  
  public String getLastFile() {
    return this.files.get(files.size() - 1);
  }
  
  public String getMatchingFile(Predicate<String> predicate) {
      for (String item : files) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public String getRefreshInterval() {
    return this.refreshInterval;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasFiles() {
    return this.files != null && !(this.files.isEmpty());
  }
  
  public boolean hasMatchingFile(Predicate<String> predicate) {
      for (String item : files) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasRefreshInterval() {
    return this.refreshInterval != null;
  }
  
  public int hashCode() {
    return Objects.hash(files, refreshInterval, additionalProperties);
  }
  
  public A removeAllFromFiles(Collection<String> items) {
    if (this.files == null) {
      return (A) this;
    }
    for (String item : items) {
      this.files.remove(item);
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
  
  public A removeFromFiles(String... items) {
    if (this.files == null) {
      return (A) this;
    }
    for (String item : items) {
      this.files.remove(item);
    }
    return (A) this;
  }
  
  public A setToFiles(int index,String item) {
    if (this.files == null) {
      this.files = new ArrayList();
    }
    this.files.set(index, item);
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(files == null) && !(files.isEmpty())) {
        sb.append("files:");
        sb.append(files);
        sb.append(",");
    }
    if (!(refreshInterval == null)) {
        sb.append("refreshInterval:");
        sb.append(refreshInterval);
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
  
  public A withFiles(List<String> files) {
    if (files != null) {
        this.files = new ArrayList();
        for (String item : files) {
          this.addToFiles(item);
        }
    } else {
      this.files = null;
    }
    return (A) this;
  }
  
  public A withFiles(String... files) {
    if (this.files != null) {
        this.files.clear();
        _visitables.remove("files");
    }
    if (files != null) {
      for (String item : files) {
        this.addToFiles(item);
      }
    }
    return (A) this;
  }
  
  public A withRefreshInterval(String refreshInterval) {
    this.refreshInterval = refreshInterval;
    return (A) this;
  }
  
}