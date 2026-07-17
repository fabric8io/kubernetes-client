package io.fabric8.openshift.api.model.config.v1;

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
public class ImageStatusFluent<A extends io.fabric8.openshift.api.model.config.v1.ImageStatusFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private List<String> externalRegistryHostnames = new ArrayList<String>();
  private String imageStreamImportMode;
  private String internalRegistryHostname;

  public ImageStatusFluent() {
  }
  
  public ImageStatusFluent(ImageStatus instance) {
    this.copyInstance(instance);
  }

  public A addAllToExternalRegistryHostnames(Collection<String> items) {
    if (this.externalRegistryHostnames == null) {
      this.externalRegistryHostnames = new ArrayList();
    }
    for (String item : items) {
      this.externalRegistryHostnames.add(item);
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
  
  public A addToExternalRegistryHostnames(String... items) {
    if (this.externalRegistryHostnames == null) {
      this.externalRegistryHostnames = new ArrayList();
    }
    for (String item : items) {
      this.externalRegistryHostnames.add(item);
    }
    return (A) this;
  }
  
  public A addToExternalRegistryHostnames(int index,String item) {
    if (this.externalRegistryHostnames == null) {
      this.externalRegistryHostnames = new ArrayList();
    }
    this.externalRegistryHostnames.add(index, item);
    return (A) this;
  }
  
  protected void copyInstance(ImageStatus instance) {
    instance = instance != null ? instance : new ImageStatus();
    if (instance != null) {
        this.withExternalRegistryHostnames(instance.getExternalRegistryHostnames());
        this.withImageStreamImportMode(instance.getImageStreamImportMode());
        this.withInternalRegistryHostname(instance.getInternalRegistryHostname());
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
    ImageStatusFluent that = (ImageStatusFluent) o;
    if (!(Objects.equals(externalRegistryHostnames, that.externalRegistryHostnames))) {
      return false;
    }
    if (!(Objects.equals(imageStreamImportMode, that.imageStreamImportMode))) {
      return false;
    }
    if (!(Objects.equals(internalRegistryHostname, that.internalRegistryHostname))) {
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
  
  public String getExternalRegistryHostname(int index) {
    return this.externalRegistryHostnames.get(index);
  }
  
  public List<String> getExternalRegistryHostnames() {
    return this.externalRegistryHostnames;
  }
  
  public String getFirstExternalRegistryHostname() {
    return this.externalRegistryHostnames.get(0);
  }
  
  public String getImageStreamImportMode() {
    return this.imageStreamImportMode;
  }
  
  public String getInternalRegistryHostname() {
    return this.internalRegistryHostname;
  }
  
  public String getLastExternalRegistryHostname() {
    return this.externalRegistryHostnames.get(externalRegistryHostnames.size() - 1);
  }
  
  public String getMatchingExternalRegistryHostname(Predicate<String> predicate) {
      for (String item : externalRegistryHostnames) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasExternalRegistryHostnames() {
    return this.externalRegistryHostnames != null && !(this.externalRegistryHostnames.isEmpty());
  }
  
  public boolean hasImageStreamImportMode() {
    return this.imageStreamImportMode != null;
  }
  
  public boolean hasInternalRegistryHostname() {
    return this.internalRegistryHostname != null;
  }
  
  public boolean hasMatchingExternalRegistryHostname(Predicate<String> predicate) {
      for (String item : externalRegistryHostnames) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public int hashCode() {
    return Objects.hash(externalRegistryHostnames, imageStreamImportMode, internalRegistryHostname, additionalProperties);
  }
  
  public A removeAllFromExternalRegistryHostnames(Collection<String> items) {
    if (this.externalRegistryHostnames == null) {
      return (A) this;
    }
    for (String item : items) {
      this.externalRegistryHostnames.remove(item);
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
  
  public A removeFromExternalRegistryHostnames(String... items) {
    if (this.externalRegistryHostnames == null) {
      return (A) this;
    }
    for (String item : items) {
      this.externalRegistryHostnames.remove(item);
    }
    return (A) this;
  }
  
  public A setToExternalRegistryHostnames(int index,String item) {
    if (this.externalRegistryHostnames == null) {
      this.externalRegistryHostnames = new ArrayList();
    }
    this.externalRegistryHostnames.set(index, item);
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(externalRegistryHostnames == null) && !(externalRegistryHostnames.isEmpty())) {
        sb.append("externalRegistryHostnames:");
        sb.append(externalRegistryHostnames);
        sb.append(",");
    }
    if (!(imageStreamImportMode == null)) {
        sb.append("imageStreamImportMode:");
        sb.append(imageStreamImportMode);
        sb.append(",");
    }
    if (!(internalRegistryHostname == null)) {
        sb.append("internalRegistryHostname:");
        sb.append(internalRegistryHostname);
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
  
  public A withExternalRegistryHostnames(List<String> externalRegistryHostnames) {
    if (externalRegistryHostnames != null) {
        this.externalRegistryHostnames = new ArrayList();
        for (String item : externalRegistryHostnames) {
          this.addToExternalRegistryHostnames(item);
        }
    } else {
      this.externalRegistryHostnames = null;
    }
    return (A) this;
  }
  
  public A withExternalRegistryHostnames(String... externalRegistryHostnames) {
    if (this.externalRegistryHostnames != null) {
        this.externalRegistryHostnames.clear();
        _visitables.remove("externalRegistryHostnames");
    }
    if (externalRegistryHostnames != null) {
      for (String item : externalRegistryHostnames) {
        this.addToExternalRegistryHostnames(item);
      }
    }
    return (A) this;
  }
  
  public A withImageStreamImportMode(String imageStreamImportMode) {
    this.imageStreamImportMode = imageStreamImportMode;
    return (A) this;
  }
  
  public A withInternalRegistryHostname(String internalRegistryHostname) {
    this.internalRegistryHostname = internalRegistryHostname;
    return (A) this;
  }
  
}