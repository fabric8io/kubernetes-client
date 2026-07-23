package io.fabric8.openclustermanagement.api.model.apps.v1;

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
public class AllowDenyItemFluent<A extends io.fabric8.openclustermanagement.api.model.apps.v1.AllowDenyItemFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String apiVersion;
  private List<String> kinds = new ArrayList<String>();

  public AllowDenyItemFluent() {
  }
  
  public AllowDenyItemFluent(AllowDenyItem instance) {
    this.copyInstance(instance);
  }

  public A addAllToKinds(Collection<String> items) {
    if (this.kinds == null) {
      this.kinds = new ArrayList();
    }
    for (String item : items) {
      this.kinds.add(item);
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
  
  public A addToKinds(String... items) {
    if (this.kinds == null) {
      this.kinds = new ArrayList();
    }
    for (String item : items) {
      this.kinds.add(item);
    }
    return (A) this;
  }
  
  public A addToKinds(int index,String item) {
    if (this.kinds == null) {
      this.kinds = new ArrayList();
    }
    this.kinds.add(index, item);
    return (A) this;
  }
  
  protected void copyInstance(AllowDenyItem instance) {
    instance = instance != null ? instance : new AllowDenyItem();
    if (instance != null) {
        this.withApiVersion(instance.getApiVersion());
        this.withKinds(instance.getKinds());
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
    AllowDenyItemFluent that = (AllowDenyItemFluent) o;
    if (!(Objects.equals(apiVersion, that.apiVersion))) {
      return false;
    }
    if (!(Objects.equals(kinds, that.kinds))) {
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
  
  public String getFirstKind() {
    return this.kinds.get(0);
  }
  
  public String getKind(int index) {
    return this.kinds.get(index);
  }
  
  public List<String> getKinds() {
    return this.kinds;
  }
  
  public String getLastKind() {
    return this.kinds.get(kinds.size() - 1);
  }
  
  public String getMatchingKind(Predicate<String> predicate) {
      for (String item : kinds) {
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
  
  public boolean hasKinds() {
    return this.kinds != null && !(this.kinds.isEmpty());
  }
  
  public boolean hasMatchingKind(Predicate<String> predicate) {
      for (String item : kinds) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public int hashCode() {
    return Objects.hash(apiVersion, kinds, additionalProperties);
  }
  
  public A removeAllFromKinds(Collection<String> items) {
    if (this.kinds == null) {
      return (A) this;
    }
    for (String item : items) {
      this.kinds.remove(item);
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
  
  public A removeFromKinds(String... items) {
    if (this.kinds == null) {
      return (A) this;
    }
    for (String item : items) {
      this.kinds.remove(item);
    }
    return (A) this;
  }
  
  public A setToKinds(int index,String item) {
    if (this.kinds == null) {
      this.kinds = new ArrayList();
    }
    this.kinds.set(index, item);
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
    if (!(kinds == null) && !(kinds.isEmpty())) {
        sb.append("kinds:");
        sb.append(kinds);
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
  
  public A withKinds(List<String> kinds) {
    if (kinds != null) {
        this.kinds = new ArrayList();
        for (String item : kinds) {
          this.addToKinds(item);
        }
    } else {
      this.kinds = null;
    }
    return (A) this;
  }
  
  public A withKinds(String... kinds) {
    if (this.kinds != null) {
        this.kinds.clear();
        _visitables.remove("kinds");
    }
    if (kinds != null) {
      for (String item : kinds) {
        this.addToKinds(item);
      }
    }
    return (A) this;
  }
  
}