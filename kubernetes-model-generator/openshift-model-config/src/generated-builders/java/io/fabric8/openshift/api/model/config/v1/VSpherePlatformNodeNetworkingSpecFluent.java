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
public class VSpherePlatformNodeNetworkingSpecFluent<A extends io.fabric8.openshift.api.model.config.v1.VSpherePlatformNodeNetworkingSpecFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private List<String> excludeNetworkSubnetCidr = new ArrayList<String>();
  private String network;
  private List<String> networkSubnetCidr = new ArrayList<String>();

  public VSpherePlatformNodeNetworkingSpecFluent() {
  }
  
  public VSpherePlatformNodeNetworkingSpecFluent(VSpherePlatformNodeNetworkingSpec instance) {
    this.copyInstance(instance);
  }

  public A addAllToExcludeNetworkSubnetCidr(Collection<String> items) {
    if (this.excludeNetworkSubnetCidr == null) {
      this.excludeNetworkSubnetCidr = new ArrayList();
    }
    for (String item : items) {
      this.excludeNetworkSubnetCidr.add(item);
    }
    return (A) this;
  }
  
  public A addAllToNetworkSubnetCidr(Collection<String> items) {
    if (this.networkSubnetCidr == null) {
      this.networkSubnetCidr = new ArrayList();
    }
    for (String item : items) {
      this.networkSubnetCidr.add(item);
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
  
  public A addToExcludeNetworkSubnetCidr(String... items) {
    if (this.excludeNetworkSubnetCidr == null) {
      this.excludeNetworkSubnetCidr = new ArrayList();
    }
    for (String item : items) {
      this.excludeNetworkSubnetCidr.add(item);
    }
    return (A) this;
  }
  
  public A addToExcludeNetworkSubnetCidr(int index,String item) {
    if (this.excludeNetworkSubnetCidr == null) {
      this.excludeNetworkSubnetCidr = new ArrayList();
    }
    this.excludeNetworkSubnetCidr.add(index, item);
    return (A) this;
  }
  
  public A addToNetworkSubnetCidr(String... items) {
    if (this.networkSubnetCidr == null) {
      this.networkSubnetCidr = new ArrayList();
    }
    for (String item : items) {
      this.networkSubnetCidr.add(item);
    }
    return (A) this;
  }
  
  public A addToNetworkSubnetCidr(int index,String item) {
    if (this.networkSubnetCidr == null) {
      this.networkSubnetCidr = new ArrayList();
    }
    this.networkSubnetCidr.add(index, item);
    return (A) this;
  }
  
  protected void copyInstance(VSpherePlatformNodeNetworkingSpec instance) {
    instance = instance != null ? instance : new VSpherePlatformNodeNetworkingSpec();
    if (instance != null) {
        this.withExcludeNetworkSubnetCidr(instance.getExcludeNetworkSubnetCidr());
        this.withNetwork(instance.getNetwork());
        this.withNetworkSubnetCidr(instance.getNetworkSubnetCidr());
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
    VSpherePlatformNodeNetworkingSpecFluent that = (VSpherePlatformNodeNetworkingSpecFluent) o;
    if (!(Objects.equals(excludeNetworkSubnetCidr, that.excludeNetworkSubnetCidr))) {
      return false;
    }
    if (!(Objects.equals(network, that.network))) {
      return false;
    }
    if (!(Objects.equals(networkSubnetCidr, that.networkSubnetCidr))) {
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
  
  public List<String> getExcludeNetworkSubnetCidr() {
    return this.excludeNetworkSubnetCidr;
  }
  
  public String getExcludeNetworkSubnetCidr(int index) {
    return this.excludeNetworkSubnetCidr.get(index);
  }
  
  public String getFirstExcludeNetworkSubnetCidr() {
    return this.excludeNetworkSubnetCidr.get(0);
  }
  
  public String getFirstNetworkSubnetCidr() {
    return this.networkSubnetCidr.get(0);
  }
  
  public String getLastExcludeNetworkSubnetCidr() {
    return this.excludeNetworkSubnetCidr.get(excludeNetworkSubnetCidr.size() - 1);
  }
  
  public String getLastNetworkSubnetCidr() {
    return this.networkSubnetCidr.get(networkSubnetCidr.size() - 1);
  }
  
  public String getMatchingExcludeNetworkSubnetCidr(Predicate<String> predicate) {
      for (String item : excludeNetworkSubnetCidr) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public String getMatchingNetworkSubnetCidr(Predicate<String> predicate) {
      for (String item : networkSubnetCidr) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public String getNetwork() {
    return this.network;
  }
  
  public List<String> getNetworkSubnetCidr() {
    return this.networkSubnetCidr;
  }
  
  public String getNetworkSubnetCidr(int index) {
    return this.networkSubnetCidr.get(index);
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasExcludeNetworkSubnetCidr() {
    return this.excludeNetworkSubnetCidr != null && !(this.excludeNetworkSubnetCidr.isEmpty());
  }
  
  public boolean hasMatchingExcludeNetworkSubnetCidr(Predicate<String> predicate) {
      for (String item : excludeNetworkSubnetCidr) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingNetworkSubnetCidr(Predicate<String> predicate) {
      for (String item : networkSubnetCidr) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasNetwork() {
    return this.network != null;
  }
  
  public boolean hasNetworkSubnetCidr() {
    return this.networkSubnetCidr != null && !(this.networkSubnetCidr.isEmpty());
  }
  
  public int hashCode() {
    return Objects.hash(excludeNetworkSubnetCidr, network, networkSubnetCidr, additionalProperties);
  }
  
  public A removeAllFromExcludeNetworkSubnetCidr(Collection<String> items) {
    if (this.excludeNetworkSubnetCidr == null) {
      return (A) this;
    }
    for (String item : items) {
      this.excludeNetworkSubnetCidr.remove(item);
    }
    return (A) this;
  }
  
  public A removeAllFromNetworkSubnetCidr(Collection<String> items) {
    if (this.networkSubnetCidr == null) {
      return (A) this;
    }
    for (String item : items) {
      this.networkSubnetCidr.remove(item);
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
  
  public A removeFromExcludeNetworkSubnetCidr(String... items) {
    if (this.excludeNetworkSubnetCidr == null) {
      return (A) this;
    }
    for (String item : items) {
      this.excludeNetworkSubnetCidr.remove(item);
    }
    return (A) this;
  }
  
  public A removeFromNetworkSubnetCidr(String... items) {
    if (this.networkSubnetCidr == null) {
      return (A) this;
    }
    for (String item : items) {
      this.networkSubnetCidr.remove(item);
    }
    return (A) this;
  }
  
  public A setToExcludeNetworkSubnetCidr(int index,String item) {
    if (this.excludeNetworkSubnetCidr == null) {
      this.excludeNetworkSubnetCidr = new ArrayList();
    }
    this.excludeNetworkSubnetCidr.set(index, item);
    return (A) this;
  }
  
  public A setToNetworkSubnetCidr(int index,String item) {
    if (this.networkSubnetCidr == null) {
      this.networkSubnetCidr = new ArrayList();
    }
    this.networkSubnetCidr.set(index, item);
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(excludeNetworkSubnetCidr == null) && !(excludeNetworkSubnetCidr.isEmpty())) {
        sb.append("excludeNetworkSubnetCidr:");
        sb.append(excludeNetworkSubnetCidr);
        sb.append(",");
    }
    if (!(network == null)) {
        sb.append("network:");
        sb.append(network);
        sb.append(",");
    }
    if (!(networkSubnetCidr == null) && !(networkSubnetCidr.isEmpty())) {
        sb.append("networkSubnetCidr:");
        sb.append(networkSubnetCidr);
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
  
  public A withExcludeNetworkSubnetCidr(List<String> excludeNetworkSubnetCidr) {
    if (excludeNetworkSubnetCidr != null) {
        this.excludeNetworkSubnetCidr = new ArrayList();
        for (String item : excludeNetworkSubnetCidr) {
          this.addToExcludeNetworkSubnetCidr(item);
        }
    } else {
      this.excludeNetworkSubnetCidr = null;
    }
    return (A) this;
  }
  
  public A withExcludeNetworkSubnetCidr(String... excludeNetworkSubnetCidr) {
    if (this.excludeNetworkSubnetCidr != null) {
        this.excludeNetworkSubnetCidr.clear();
        _visitables.remove("excludeNetworkSubnetCidr");
    }
    if (excludeNetworkSubnetCidr != null) {
      for (String item : excludeNetworkSubnetCidr) {
        this.addToExcludeNetworkSubnetCidr(item);
      }
    }
    return (A) this;
  }
  
  public A withNetwork(String network) {
    this.network = network;
    return (A) this;
  }
  
  public A withNetworkSubnetCidr(List<String> networkSubnetCidr) {
    if (networkSubnetCidr != null) {
        this.networkSubnetCidr = new ArrayList();
        for (String item : networkSubnetCidr) {
          this.addToNetworkSubnetCidr(item);
        }
    } else {
      this.networkSubnetCidr = null;
    }
    return (A) this;
  }
  
  public A withNetworkSubnetCidr(String... networkSubnetCidr) {
    if (this.networkSubnetCidr != null) {
        this.networkSubnetCidr.clear();
        _visitables.remove("networkSubnetCidr");
    }
    if (networkSubnetCidr != null) {
      for (String item : networkSubnetCidr) {
        this.addToNetworkSubnetCidr(item);
      }
    }
    return (A) this;
  }
  
}