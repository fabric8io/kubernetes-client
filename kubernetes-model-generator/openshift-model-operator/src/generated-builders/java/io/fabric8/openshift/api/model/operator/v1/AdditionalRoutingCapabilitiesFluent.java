package io.fabric8.openshift.api.model.operator.v1;

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
public class AdditionalRoutingCapabilitiesFluent<A extends io.fabric8.openshift.api.model.operator.v1.AdditionalRoutingCapabilitiesFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private List<String> providers = new ArrayList<String>();

  public AdditionalRoutingCapabilitiesFluent() {
  }
  
  public AdditionalRoutingCapabilitiesFluent(AdditionalRoutingCapabilities instance) {
    this.copyInstance(instance);
  }

  public A addAllToProviders(Collection<String> items) {
    if (this.providers == null) {
      this.providers = new ArrayList();
    }
    for (String item : items) {
      this.providers.add(item);
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
  
  public A addToProviders(String... items) {
    if (this.providers == null) {
      this.providers = new ArrayList();
    }
    for (String item : items) {
      this.providers.add(item);
    }
    return (A) this;
  }
  
  public A addToProviders(int index,String item) {
    if (this.providers == null) {
      this.providers = new ArrayList();
    }
    this.providers.add(index, item);
    return (A) this;
  }
  
  protected void copyInstance(AdditionalRoutingCapabilities instance) {
    instance = instance != null ? instance : new AdditionalRoutingCapabilities();
    if (instance != null) {
        this.withProviders(instance.getProviders());
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
    AdditionalRoutingCapabilitiesFluent that = (AdditionalRoutingCapabilitiesFluent) o;
    if (!(Objects.equals(providers, that.providers))) {
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
  
  public String getFirstProvider() {
    return this.providers.get(0);
  }
  
  public String getLastProvider() {
    return this.providers.get(providers.size() - 1);
  }
  
  public String getMatchingProvider(Predicate<String> predicate) {
      for (String item : providers) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public String getProvider(int index) {
    return this.providers.get(index);
  }
  
  public List<String> getProviders() {
    return this.providers;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasMatchingProvider(Predicate<String> predicate) {
      for (String item : providers) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasProviders() {
    return this.providers != null && !(this.providers.isEmpty());
  }
  
  public int hashCode() {
    return Objects.hash(providers, additionalProperties);
  }
  
  public A removeAllFromProviders(Collection<String> items) {
    if (this.providers == null) {
      return (A) this;
    }
    for (String item : items) {
      this.providers.remove(item);
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
  
  public A removeFromProviders(String... items) {
    if (this.providers == null) {
      return (A) this;
    }
    for (String item : items) {
      this.providers.remove(item);
    }
    return (A) this;
  }
  
  public A setToProviders(int index,String item) {
    if (this.providers == null) {
      this.providers = new ArrayList();
    }
    this.providers.set(index, item);
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(providers == null) && !(providers.isEmpty())) {
        sb.append("providers:");
        sb.append(providers);
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
  
  public A withProviders(List<String> providers) {
    if (providers != null) {
        this.providers = new ArrayList();
        for (String item : providers) {
          this.addToProviders(item);
        }
    } else {
      this.providers = null;
    }
    return (A) this;
  }
  
  public A withProviders(String... providers) {
    if (this.providers != null) {
        this.providers.clear();
        _visitables.remove("providers");
    }
    if (providers != null) {
      for (String item : providers) {
        this.addToProviders(item);
      }
    }
    return (A) this;
  }
  
}