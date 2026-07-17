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
public class RegistrySourcesFluent<A extends io.fabric8.openshift.api.model.config.v1.RegistrySourcesFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private List<String> allowedRegistries = new ArrayList<String>();
  private List<String> blockedRegistries = new ArrayList<String>();
  private List<String> containerRuntimeSearchRegistries = new ArrayList<String>();
  private List<String> insecureRegistries = new ArrayList<String>();

  public RegistrySourcesFluent() {
  }
  
  public RegistrySourcesFluent(RegistrySources instance) {
    this.copyInstance(instance);
  }

  public A addAllToAllowedRegistries(Collection<String> items) {
    if (this.allowedRegistries == null) {
      this.allowedRegistries = new ArrayList();
    }
    for (String item : items) {
      this.allowedRegistries.add(item);
    }
    return (A) this;
  }
  
  public A addAllToBlockedRegistries(Collection<String> items) {
    if (this.blockedRegistries == null) {
      this.blockedRegistries = new ArrayList();
    }
    for (String item : items) {
      this.blockedRegistries.add(item);
    }
    return (A) this;
  }
  
  public A addAllToContainerRuntimeSearchRegistries(Collection<String> items) {
    if (this.containerRuntimeSearchRegistries == null) {
      this.containerRuntimeSearchRegistries = new ArrayList();
    }
    for (String item : items) {
      this.containerRuntimeSearchRegistries.add(item);
    }
    return (A) this;
  }
  
  public A addAllToInsecureRegistries(Collection<String> items) {
    if (this.insecureRegistries == null) {
      this.insecureRegistries = new ArrayList();
    }
    for (String item : items) {
      this.insecureRegistries.add(item);
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
  
  public A addToAllowedRegistries(String... items) {
    if (this.allowedRegistries == null) {
      this.allowedRegistries = new ArrayList();
    }
    for (String item : items) {
      this.allowedRegistries.add(item);
    }
    return (A) this;
  }
  
  public A addToAllowedRegistries(int index,String item) {
    if (this.allowedRegistries == null) {
      this.allowedRegistries = new ArrayList();
    }
    this.allowedRegistries.add(index, item);
    return (A) this;
  }
  
  public A addToBlockedRegistries(String... items) {
    if (this.blockedRegistries == null) {
      this.blockedRegistries = new ArrayList();
    }
    for (String item : items) {
      this.blockedRegistries.add(item);
    }
    return (A) this;
  }
  
  public A addToBlockedRegistries(int index,String item) {
    if (this.blockedRegistries == null) {
      this.blockedRegistries = new ArrayList();
    }
    this.blockedRegistries.add(index, item);
    return (A) this;
  }
  
  public A addToContainerRuntimeSearchRegistries(String... items) {
    if (this.containerRuntimeSearchRegistries == null) {
      this.containerRuntimeSearchRegistries = new ArrayList();
    }
    for (String item : items) {
      this.containerRuntimeSearchRegistries.add(item);
    }
    return (A) this;
  }
  
  public A addToContainerRuntimeSearchRegistries(int index,String item) {
    if (this.containerRuntimeSearchRegistries == null) {
      this.containerRuntimeSearchRegistries = new ArrayList();
    }
    this.containerRuntimeSearchRegistries.add(index, item);
    return (A) this;
  }
  
  public A addToInsecureRegistries(String... items) {
    if (this.insecureRegistries == null) {
      this.insecureRegistries = new ArrayList();
    }
    for (String item : items) {
      this.insecureRegistries.add(item);
    }
    return (A) this;
  }
  
  public A addToInsecureRegistries(int index,String item) {
    if (this.insecureRegistries == null) {
      this.insecureRegistries = new ArrayList();
    }
    this.insecureRegistries.add(index, item);
    return (A) this;
  }
  
  protected void copyInstance(RegistrySources instance) {
    instance = instance != null ? instance : new RegistrySources();
    if (instance != null) {
        this.withAllowedRegistries(instance.getAllowedRegistries());
        this.withBlockedRegistries(instance.getBlockedRegistries());
        this.withContainerRuntimeSearchRegistries(instance.getContainerRuntimeSearchRegistries());
        this.withInsecureRegistries(instance.getInsecureRegistries());
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
    RegistrySourcesFluent that = (RegistrySourcesFluent) o;
    if (!(Objects.equals(allowedRegistries, that.allowedRegistries))) {
      return false;
    }
    if (!(Objects.equals(blockedRegistries, that.blockedRegistries))) {
      return false;
    }
    if (!(Objects.equals(containerRuntimeSearchRegistries, that.containerRuntimeSearchRegistries))) {
      return false;
    }
    if (!(Objects.equals(insecureRegistries, that.insecureRegistries))) {
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
  
  public List<String> getAllowedRegistries() {
    return this.allowedRegistries;
  }
  
  public String getAllowedRegistry(int index) {
    return this.allowedRegistries.get(index);
  }
  
  public List<String> getBlockedRegistries() {
    return this.blockedRegistries;
  }
  
  public String getBlockedRegistry(int index) {
    return this.blockedRegistries.get(index);
  }
  
  public List<String> getContainerRuntimeSearchRegistries() {
    return this.containerRuntimeSearchRegistries;
  }
  
  public String getContainerRuntimeSearchRegistry(int index) {
    return this.containerRuntimeSearchRegistries.get(index);
  }
  
  public String getFirstAllowedRegistry() {
    return this.allowedRegistries.get(0);
  }
  
  public String getFirstBlockedRegistry() {
    return this.blockedRegistries.get(0);
  }
  
  public String getFirstContainerRuntimeSearchRegistry() {
    return this.containerRuntimeSearchRegistries.get(0);
  }
  
  public String getFirstInsecureRegistry() {
    return this.insecureRegistries.get(0);
  }
  
  public List<String> getInsecureRegistries() {
    return this.insecureRegistries;
  }
  
  public String getInsecureRegistry(int index) {
    return this.insecureRegistries.get(index);
  }
  
  public String getLastAllowedRegistry() {
    return this.allowedRegistries.get(allowedRegistries.size() - 1);
  }
  
  public String getLastBlockedRegistry() {
    return this.blockedRegistries.get(blockedRegistries.size() - 1);
  }
  
  public String getLastContainerRuntimeSearchRegistry() {
    return this.containerRuntimeSearchRegistries.get(containerRuntimeSearchRegistries.size() - 1);
  }
  
  public String getLastInsecureRegistry() {
    return this.insecureRegistries.get(insecureRegistries.size() - 1);
  }
  
  public String getMatchingAllowedRegistry(Predicate<String> predicate) {
      for (String item : allowedRegistries) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public String getMatchingBlockedRegistry(Predicate<String> predicate) {
      for (String item : blockedRegistries) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public String getMatchingContainerRuntimeSearchRegistry(Predicate<String> predicate) {
      for (String item : containerRuntimeSearchRegistries) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public String getMatchingInsecureRegistry(Predicate<String> predicate) {
      for (String item : insecureRegistries) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasAllowedRegistries() {
    return this.allowedRegistries != null && !(this.allowedRegistries.isEmpty());
  }
  
  public boolean hasBlockedRegistries() {
    return this.blockedRegistries != null && !(this.blockedRegistries.isEmpty());
  }
  
  public boolean hasContainerRuntimeSearchRegistries() {
    return this.containerRuntimeSearchRegistries != null && !(this.containerRuntimeSearchRegistries.isEmpty());
  }
  
  public boolean hasInsecureRegistries() {
    return this.insecureRegistries != null && !(this.insecureRegistries.isEmpty());
  }
  
  public boolean hasMatchingAllowedRegistry(Predicate<String> predicate) {
      for (String item : allowedRegistries) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingBlockedRegistry(Predicate<String> predicate) {
      for (String item : blockedRegistries) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingContainerRuntimeSearchRegistry(Predicate<String> predicate) {
      for (String item : containerRuntimeSearchRegistries) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingInsecureRegistry(Predicate<String> predicate) {
      for (String item : insecureRegistries) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public int hashCode() {
    return Objects.hash(allowedRegistries, blockedRegistries, containerRuntimeSearchRegistries, insecureRegistries, additionalProperties);
  }
  
  public A removeAllFromAllowedRegistries(Collection<String> items) {
    if (this.allowedRegistries == null) {
      return (A) this;
    }
    for (String item : items) {
      this.allowedRegistries.remove(item);
    }
    return (A) this;
  }
  
  public A removeAllFromBlockedRegistries(Collection<String> items) {
    if (this.blockedRegistries == null) {
      return (A) this;
    }
    for (String item : items) {
      this.blockedRegistries.remove(item);
    }
    return (A) this;
  }
  
  public A removeAllFromContainerRuntimeSearchRegistries(Collection<String> items) {
    if (this.containerRuntimeSearchRegistries == null) {
      return (A) this;
    }
    for (String item : items) {
      this.containerRuntimeSearchRegistries.remove(item);
    }
    return (A) this;
  }
  
  public A removeAllFromInsecureRegistries(Collection<String> items) {
    if (this.insecureRegistries == null) {
      return (A) this;
    }
    for (String item : items) {
      this.insecureRegistries.remove(item);
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
  
  public A removeFromAllowedRegistries(String... items) {
    if (this.allowedRegistries == null) {
      return (A) this;
    }
    for (String item : items) {
      this.allowedRegistries.remove(item);
    }
    return (A) this;
  }
  
  public A removeFromBlockedRegistries(String... items) {
    if (this.blockedRegistries == null) {
      return (A) this;
    }
    for (String item : items) {
      this.blockedRegistries.remove(item);
    }
    return (A) this;
  }
  
  public A removeFromContainerRuntimeSearchRegistries(String... items) {
    if (this.containerRuntimeSearchRegistries == null) {
      return (A) this;
    }
    for (String item : items) {
      this.containerRuntimeSearchRegistries.remove(item);
    }
    return (A) this;
  }
  
  public A removeFromInsecureRegistries(String... items) {
    if (this.insecureRegistries == null) {
      return (A) this;
    }
    for (String item : items) {
      this.insecureRegistries.remove(item);
    }
    return (A) this;
  }
  
  public A setToAllowedRegistries(int index,String item) {
    if (this.allowedRegistries == null) {
      this.allowedRegistries = new ArrayList();
    }
    this.allowedRegistries.set(index, item);
    return (A) this;
  }
  
  public A setToBlockedRegistries(int index,String item) {
    if (this.blockedRegistries == null) {
      this.blockedRegistries = new ArrayList();
    }
    this.blockedRegistries.set(index, item);
    return (A) this;
  }
  
  public A setToContainerRuntimeSearchRegistries(int index,String item) {
    if (this.containerRuntimeSearchRegistries == null) {
      this.containerRuntimeSearchRegistries = new ArrayList();
    }
    this.containerRuntimeSearchRegistries.set(index, item);
    return (A) this;
  }
  
  public A setToInsecureRegistries(int index,String item) {
    if (this.insecureRegistries == null) {
      this.insecureRegistries = new ArrayList();
    }
    this.insecureRegistries.set(index, item);
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(allowedRegistries == null) && !(allowedRegistries.isEmpty())) {
        sb.append("allowedRegistries:");
        sb.append(allowedRegistries);
        sb.append(",");
    }
    if (!(blockedRegistries == null) && !(blockedRegistries.isEmpty())) {
        sb.append("blockedRegistries:");
        sb.append(blockedRegistries);
        sb.append(",");
    }
    if (!(containerRuntimeSearchRegistries == null) && !(containerRuntimeSearchRegistries.isEmpty())) {
        sb.append("containerRuntimeSearchRegistries:");
        sb.append(containerRuntimeSearchRegistries);
        sb.append(",");
    }
    if (!(insecureRegistries == null) && !(insecureRegistries.isEmpty())) {
        sb.append("insecureRegistries:");
        sb.append(insecureRegistries);
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
  
  public A withAllowedRegistries(List<String> allowedRegistries) {
    if (allowedRegistries != null) {
        this.allowedRegistries = new ArrayList();
        for (String item : allowedRegistries) {
          this.addToAllowedRegistries(item);
        }
    } else {
      this.allowedRegistries = null;
    }
    return (A) this;
  }
  
  public A withAllowedRegistries(String... allowedRegistries) {
    if (this.allowedRegistries != null) {
        this.allowedRegistries.clear();
        _visitables.remove("allowedRegistries");
    }
    if (allowedRegistries != null) {
      for (String item : allowedRegistries) {
        this.addToAllowedRegistries(item);
      }
    }
    return (A) this;
  }
  
  public A withBlockedRegistries(List<String> blockedRegistries) {
    if (blockedRegistries != null) {
        this.blockedRegistries = new ArrayList();
        for (String item : blockedRegistries) {
          this.addToBlockedRegistries(item);
        }
    } else {
      this.blockedRegistries = null;
    }
    return (A) this;
  }
  
  public A withBlockedRegistries(String... blockedRegistries) {
    if (this.blockedRegistries != null) {
        this.blockedRegistries.clear();
        _visitables.remove("blockedRegistries");
    }
    if (blockedRegistries != null) {
      for (String item : blockedRegistries) {
        this.addToBlockedRegistries(item);
      }
    }
    return (A) this;
  }
  
  public A withContainerRuntimeSearchRegistries(List<String> containerRuntimeSearchRegistries) {
    if (containerRuntimeSearchRegistries != null) {
        this.containerRuntimeSearchRegistries = new ArrayList();
        for (String item : containerRuntimeSearchRegistries) {
          this.addToContainerRuntimeSearchRegistries(item);
        }
    } else {
      this.containerRuntimeSearchRegistries = null;
    }
    return (A) this;
  }
  
  public A withContainerRuntimeSearchRegistries(String... containerRuntimeSearchRegistries) {
    if (this.containerRuntimeSearchRegistries != null) {
        this.containerRuntimeSearchRegistries.clear();
        _visitables.remove("containerRuntimeSearchRegistries");
    }
    if (containerRuntimeSearchRegistries != null) {
      for (String item : containerRuntimeSearchRegistries) {
        this.addToContainerRuntimeSearchRegistries(item);
      }
    }
    return (A) this;
  }
  
  public A withInsecureRegistries(List<String> insecureRegistries) {
    if (insecureRegistries != null) {
        this.insecureRegistries = new ArrayList();
        for (String item : insecureRegistries) {
          this.addToInsecureRegistries(item);
        }
    } else {
      this.insecureRegistries = null;
    }
    return (A) this;
  }
  
  public A withInsecureRegistries(String... insecureRegistries) {
    if (this.insecureRegistries != null) {
        this.insecureRegistries.clear();
        _visitables.remove("insecureRegistries");
    }
    if (insecureRegistries != null) {
      for (String item : insecureRegistries) {
        this.addToInsecureRegistries(item);
      }
    }
    return (A) this;
  }
  
}