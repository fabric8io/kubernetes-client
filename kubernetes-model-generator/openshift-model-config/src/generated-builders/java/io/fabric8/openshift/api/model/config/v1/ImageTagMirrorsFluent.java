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
public class ImageTagMirrorsFluent<A extends io.fabric8.openshift.api.model.config.v1.ImageTagMirrorsFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String mirrorSourcePolicy;
  private List<String> mirrors = new ArrayList<String>();
  private String source;

  public ImageTagMirrorsFluent() {
  }
  
  public ImageTagMirrorsFluent(ImageTagMirrors instance) {
    this.copyInstance(instance);
  }

  public A addAllToMirrors(Collection<String> items) {
    if (this.mirrors == null) {
      this.mirrors = new ArrayList();
    }
    for (String item : items) {
      this.mirrors.add(item);
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
  
  public A addToMirrors(String... items) {
    if (this.mirrors == null) {
      this.mirrors = new ArrayList();
    }
    for (String item : items) {
      this.mirrors.add(item);
    }
    return (A) this;
  }
  
  public A addToMirrors(int index,String item) {
    if (this.mirrors == null) {
      this.mirrors = new ArrayList();
    }
    this.mirrors.add(index, item);
    return (A) this;
  }
  
  protected void copyInstance(ImageTagMirrors instance) {
    instance = instance != null ? instance : new ImageTagMirrors();
    if (instance != null) {
        this.withMirrorSourcePolicy(instance.getMirrorSourcePolicy());
        this.withMirrors(instance.getMirrors());
        this.withSource(instance.getSource());
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
    ImageTagMirrorsFluent that = (ImageTagMirrorsFluent) o;
    if (!(Objects.equals(mirrorSourcePolicy, that.mirrorSourcePolicy))) {
      return false;
    }
    if (!(Objects.equals(mirrors, that.mirrors))) {
      return false;
    }
    if (!(Objects.equals(source, that.source))) {
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
  
  public String getFirstMirror() {
    return this.mirrors.get(0);
  }
  
  public String getLastMirror() {
    return this.mirrors.get(mirrors.size() - 1);
  }
  
  public String getMatchingMirror(Predicate<String> predicate) {
      for (String item : mirrors) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public String getMirror(int index) {
    return this.mirrors.get(index);
  }
  
  public String getMirrorSourcePolicy() {
    return this.mirrorSourcePolicy;
  }
  
  public List<String> getMirrors() {
    return this.mirrors;
  }
  
  public String getSource() {
    return this.source;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasMatchingMirror(Predicate<String> predicate) {
      for (String item : mirrors) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMirrorSourcePolicy() {
    return this.mirrorSourcePolicy != null;
  }
  
  public boolean hasMirrors() {
    return this.mirrors != null && !(this.mirrors.isEmpty());
  }
  
  public boolean hasSource() {
    return this.source != null;
  }
  
  public int hashCode() {
    return Objects.hash(mirrorSourcePolicy, mirrors, source, additionalProperties);
  }
  
  public A removeAllFromMirrors(Collection<String> items) {
    if (this.mirrors == null) {
      return (A) this;
    }
    for (String item : items) {
      this.mirrors.remove(item);
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
  
  public A removeFromMirrors(String... items) {
    if (this.mirrors == null) {
      return (A) this;
    }
    for (String item : items) {
      this.mirrors.remove(item);
    }
    return (A) this;
  }
  
  public A setToMirrors(int index,String item) {
    if (this.mirrors == null) {
      this.mirrors = new ArrayList();
    }
    this.mirrors.set(index, item);
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(mirrorSourcePolicy == null)) {
        sb.append("mirrorSourcePolicy:");
        sb.append(mirrorSourcePolicy);
        sb.append(",");
    }
    if (!(mirrors == null) && !(mirrors.isEmpty())) {
        sb.append("mirrors:");
        sb.append(mirrors);
        sb.append(",");
    }
    if (!(source == null)) {
        sb.append("source:");
        sb.append(source);
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
  
  public A withMirrorSourcePolicy(String mirrorSourcePolicy) {
    this.mirrorSourcePolicy = mirrorSourcePolicy;
    return (A) this;
  }
  
  public A withMirrors(List<String> mirrors) {
    if (mirrors != null) {
        this.mirrors = new ArrayList();
        for (String item : mirrors) {
          this.addToMirrors(item);
        }
    } else {
      this.mirrors = null;
    }
    return (A) this;
  }
  
  public A withMirrors(String... mirrors) {
    if (this.mirrors != null) {
        this.mirrors.clear();
        _visitables.remove("mirrors");
    }
    if (mirrors != null) {
      for (String item : mirrors) {
        this.addToMirrors(item);
      }
    }
    return (A) this;
  }
  
  public A withSource(String source) {
    this.source = source;
    return (A) this;
  }
  
}