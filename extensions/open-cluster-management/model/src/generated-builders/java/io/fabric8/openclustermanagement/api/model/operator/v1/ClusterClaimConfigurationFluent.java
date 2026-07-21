package io.fabric8.openclustermanagement.api.model.operator.v1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import java.lang.Integer;
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
public class ClusterClaimConfigurationFluent<A extends io.fabric8.openclustermanagement.api.model.operator.v1.ClusterClaimConfigurationFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private Integer maxCustomClusterClaims;
  private List<String> reservedClusterClaimSuffixes = new ArrayList<String>();

  public ClusterClaimConfigurationFluent() {
  }
  
  public ClusterClaimConfigurationFluent(ClusterClaimConfiguration instance) {
    this.copyInstance(instance);
  }

  public A addAllToReservedClusterClaimSuffixes(Collection<String> items) {
    if (this.reservedClusterClaimSuffixes == null) {
      this.reservedClusterClaimSuffixes = new ArrayList();
    }
    for (String item : items) {
      this.reservedClusterClaimSuffixes.add(item);
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
  
  public A addToReservedClusterClaimSuffixes(String... items) {
    if (this.reservedClusterClaimSuffixes == null) {
      this.reservedClusterClaimSuffixes = new ArrayList();
    }
    for (String item : items) {
      this.reservedClusterClaimSuffixes.add(item);
    }
    return (A) this;
  }
  
  public A addToReservedClusterClaimSuffixes(int index,String item) {
    if (this.reservedClusterClaimSuffixes == null) {
      this.reservedClusterClaimSuffixes = new ArrayList();
    }
    this.reservedClusterClaimSuffixes.add(index, item);
    return (A) this;
  }
  
  protected void copyInstance(ClusterClaimConfiguration instance) {
    instance = instance != null ? instance : new ClusterClaimConfiguration();
    if (instance != null) {
        this.withMaxCustomClusterClaims(instance.getMaxCustomClusterClaims());
        this.withReservedClusterClaimSuffixes(instance.getReservedClusterClaimSuffixes());
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
    ClusterClaimConfigurationFluent that = (ClusterClaimConfigurationFluent) o;
    if (!(Objects.equals(maxCustomClusterClaims, that.maxCustomClusterClaims))) {
      return false;
    }
    if (!(Objects.equals(reservedClusterClaimSuffixes, that.reservedClusterClaimSuffixes))) {
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
  
  public String getFirstReservedClusterClaimSuffix() {
    return this.reservedClusterClaimSuffixes.get(0);
  }
  
  public String getLastReservedClusterClaimSuffix() {
    return this.reservedClusterClaimSuffixes.get(reservedClusterClaimSuffixes.size() - 1);
  }
  
  public String getMatchingReservedClusterClaimSuffix(Predicate<String> predicate) {
      for (String item : reservedClusterClaimSuffixes) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public Integer getMaxCustomClusterClaims() {
    return this.maxCustomClusterClaims;
  }
  
  public String getReservedClusterClaimSuffix(int index) {
    return this.reservedClusterClaimSuffixes.get(index);
  }
  
  public List<String> getReservedClusterClaimSuffixes() {
    return this.reservedClusterClaimSuffixes;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasMatchingReservedClusterClaimSuffix(Predicate<String> predicate) {
      for (String item : reservedClusterClaimSuffixes) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMaxCustomClusterClaims() {
    return this.maxCustomClusterClaims != null;
  }
  
  public boolean hasReservedClusterClaimSuffixes() {
    return this.reservedClusterClaimSuffixes != null && !(this.reservedClusterClaimSuffixes.isEmpty());
  }
  
  public int hashCode() {
    return Objects.hash(maxCustomClusterClaims, reservedClusterClaimSuffixes, additionalProperties);
  }
  
  public A removeAllFromReservedClusterClaimSuffixes(Collection<String> items) {
    if (this.reservedClusterClaimSuffixes == null) {
      return (A) this;
    }
    for (String item : items) {
      this.reservedClusterClaimSuffixes.remove(item);
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
  
  public A removeFromReservedClusterClaimSuffixes(String... items) {
    if (this.reservedClusterClaimSuffixes == null) {
      return (A) this;
    }
    for (String item : items) {
      this.reservedClusterClaimSuffixes.remove(item);
    }
    return (A) this;
  }
  
  public A setToReservedClusterClaimSuffixes(int index,String item) {
    if (this.reservedClusterClaimSuffixes == null) {
      this.reservedClusterClaimSuffixes = new ArrayList();
    }
    this.reservedClusterClaimSuffixes.set(index, item);
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(maxCustomClusterClaims == null)) {
        sb.append("maxCustomClusterClaims:");
        sb.append(maxCustomClusterClaims);
        sb.append(",");
    }
    if (!(reservedClusterClaimSuffixes == null) && !(reservedClusterClaimSuffixes.isEmpty())) {
        sb.append("reservedClusterClaimSuffixes:");
        sb.append(reservedClusterClaimSuffixes);
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
  
  public A withMaxCustomClusterClaims(Integer maxCustomClusterClaims) {
    this.maxCustomClusterClaims = maxCustomClusterClaims;
    return (A) this;
  }
  
  public A withReservedClusterClaimSuffixes(List<String> reservedClusterClaimSuffixes) {
    if (reservedClusterClaimSuffixes != null) {
        this.reservedClusterClaimSuffixes = new ArrayList();
        for (String item : reservedClusterClaimSuffixes) {
          this.addToReservedClusterClaimSuffixes(item);
        }
    } else {
      this.reservedClusterClaimSuffixes = null;
    }
    return (A) this;
  }
  
  public A withReservedClusterClaimSuffixes(String... reservedClusterClaimSuffixes) {
    if (this.reservedClusterClaimSuffixes != null) {
        this.reservedClusterClaimSuffixes.clear();
        _visitables.remove("reservedClusterClaimSuffixes");
    }
    if (reservedClusterClaimSuffixes != null) {
      for (String item : reservedClusterClaimSuffixes) {
        this.addToReservedClusterClaimSuffixes(item);
      }
    }
    return (A) this;
  }
  
}