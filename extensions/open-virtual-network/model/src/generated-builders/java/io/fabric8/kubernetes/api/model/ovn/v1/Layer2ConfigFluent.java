package io.fabric8.kubernetes.api.model.ovn.v1;

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
public class Layer2ConfigFluent<A extends io.fabric8.kubernetes.api.model.ovn.v1.Layer2ConfigFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String ipamLifecycle;
  private List<String> joinSubnets = new ArrayList<String>();
  private Integer mtu;
  private String role;
  private List<String> subnets = new ArrayList<String>();

  public Layer2ConfigFluent() {
  }
  
  public Layer2ConfigFluent(Layer2Config instance) {
    this.copyInstance(instance);
  }

  public A addAllToJoinSubnets(Collection<String> items) {
    if (this.joinSubnets == null) {
      this.joinSubnets = new ArrayList();
    }
    for (String item : items) {
      this.joinSubnets.add(item);
    }
    return (A) this;
  }
  
  public A addAllToSubnets(Collection<String> items) {
    if (this.subnets == null) {
      this.subnets = new ArrayList();
    }
    for (String item : items) {
      this.subnets.add(item);
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
  
  public A addToJoinSubnets(String... items) {
    if (this.joinSubnets == null) {
      this.joinSubnets = new ArrayList();
    }
    for (String item : items) {
      this.joinSubnets.add(item);
    }
    return (A) this;
  }
  
  public A addToJoinSubnets(int index,String item) {
    if (this.joinSubnets == null) {
      this.joinSubnets = new ArrayList();
    }
    this.joinSubnets.add(index, item);
    return (A) this;
  }
  
  public A addToSubnets(String... items) {
    if (this.subnets == null) {
      this.subnets = new ArrayList();
    }
    for (String item : items) {
      this.subnets.add(item);
    }
    return (A) this;
  }
  
  public A addToSubnets(int index,String item) {
    if (this.subnets == null) {
      this.subnets = new ArrayList();
    }
    this.subnets.add(index, item);
    return (A) this;
  }
  
  protected void copyInstance(Layer2Config instance) {
    instance = instance != null ? instance : new Layer2Config();
    if (instance != null) {
        this.withIpamLifecycle(instance.getIpamLifecycle());
        this.withJoinSubnets(instance.getJoinSubnets());
        this.withMtu(instance.getMtu());
        this.withRole(instance.getRole());
        this.withSubnets(instance.getSubnets());
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
    Layer2ConfigFluent that = (Layer2ConfigFluent) o;
    if (!(Objects.equals(ipamLifecycle, that.ipamLifecycle))) {
      return false;
    }
    if (!(Objects.equals(joinSubnets, that.joinSubnets))) {
      return false;
    }
    if (!(Objects.equals(mtu, that.mtu))) {
      return false;
    }
    if (!(Objects.equals(role, that.role))) {
      return false;
    }
    if (!(Objects.equals(subnets, that.subnets))) {
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
  
  public String getFirstJoinSubnet() {
    return this.joinSubnets.get(0);
  }
  
  public String getFirstSubnet() {
    return this.subnets.get(0);
  }
  
  public String getIpamLifecycle() {
    return this.ipamLifecycle;
  }
  
  public String getJoinSubnet(int index) {
    return this.joinSubnets.get(index);
  }
  
  public List<String> getJoinSubnets() {
    return this.joinSubnets;
  }
  
  public String getLastJoinSubnet() {
    return this.joinSubnets.get(joinSubnets.size() - 1);
  }
  
  public String getLastSubnet() {
    return this.subnets.get(subnets.size() - 1);
  }
  
  public String getMatchingJoinSubnet(Predicate<String> predicate) {
      for (String item : joinSubnets) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public String getMatchingSubnet(Predicate<String> predicate) {
      for (String item : subnets) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public Integer getMtu() {
    return this.mtu;
  }
  
  public String getRole() {
    return this.role;
  }
  
  public String getSubnet(int index) {
    return this.subnets.get(index);
  }
  
  public List<String> getSubnets() {
    return this.subnets;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasIpamLifecycle() {
    return this.ipamLifecycle != null;
  }
  
  public boolean hasJoinSubnets() {
    return this.joinSubnets != null && !(this.joinSubnets.isEmpty());
  }
  
  public boolean hasMatchingJoinSubnet(Predicate<String> predicate) {
      for (String item : joinSubnets) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingSubnet(Predicate<String> predicate) {
      for (String item : subnets) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMtu() {
    return this.mtu != null;
  }
  
  public boolean hasRole() {
    return this.role != null;
  }
  
  public boolean hasSubnets() {
    return this.subnets != null && !(this.subnets.isEmpty());
  }
  
  public int hashCode() {
    return Objects.hash(ipamLifecycle, joinSubnets, mtu, role, subnets, additionalProperties);
  }
  
  public A removeAllFromJoinSubnets(Collection<String> items) {
    if (this.joinSubnets == null) {
      return (A) this;
    }
    for (String item : items) {
      this.joinSubnets.remove(item);
    }
    return (A) this;
  }
  
  public A removeAllFromSubnets(Collection<String> items) {
    if (this.subnets == null) {
      return (A) this;
    }
    for (String item : items) {
      this.subnets.remove(item);
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
  
  public A removeFromJoinSubnets(String... items) {
    if (this.joinSubnets == null) {
      return (A) this;
    }
    for (String item : items) {
      this.joinSubnets.remove(item);
    }
    return (A) this;
  }
  
  public A removeFromSubnets(String... items) {
    if (this.subnets == null) {
      return (A) this;
    }
    for (String item : items) {
      this.subnets.remove(item);
    }
    return (A) this;
  }
  
  public A setToJoinSubnets(int index,String item) {
    if (this.joinSubnets == null) {
      this.joinSubnets = new ArrayList();
    }
    this.joinSubnets.set(index, item);
    return (A) this;
  }
  
  public A setToSubnets(int index,String item) {
    if (this.subnets == null) {
      this.subnets = new ArrayList();
    }
    this.subnets.set(index, item);
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(ipamLifecycle == null)) {
        sb.append("ipamLifecycle:");
        sb.append(ipamLifecycle);
        sb.append(",");
    }
    if (!(joinSubnets == null) && !(joinSubnets.isEmpty())) {
        sb.append("joinSubnets:");
        sb.append(joinSubnets);
        sb.append(",");
    }
    if (!(mtu == null)) {
        sb.append("mtu:");
        sb.append(mtu);
        sb.append(",");
    }
    if (!(role == null)) {
        sb.append("role:");
        sb.append(role);
        sb.append(",");
    }
    if (!(subnets == null) && !(subnets.isEmpty())) {
        sb.append("subnets:");
        sb.append(subnets);
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
  
  public A withIpamLifecycle(String ipamLifecycle) {
    this.ipamLifecycle = ipamLifecycle;
    return (A) this;
  }
  
  public A withJoinSubnets(List<String> joinSubnets) {
    if (joinSubnets != null) {
        this.joinSubnets = new ArrayList();
        for (String item : joinSubnets) {
          this.addToJoinSubnets(item);
        }
    } else {
      this.joinSubnets = null;
    }
    return (A) this;
  }
  
  public A withJoinSubnets(String... joinSubnets) {
    if (this.joinSubnets != null) {
        this.joinSubnets.clear();
        _visitables.remove("joinSubnets");
    }
    if (joinSubnets != null) {
      for (String item : joinSubnets) {
        this.addToJoinSubnets(item);
      }
    }
    return (A) this;
  }
  
  public A withMtu(Integer mtu) {
    this.mtu = mtu;
    return (A) this;
  }
  
  public A withRole(String role) {
    this.role = role;
    return (A) this;
  }
  
  public A withSubnets(List<String> subnets) {
    if (subnets != null) {
        this.subnets = new ArrayList();
        for (String item : subnets) {
          this.addToSubnets(item);
        }
    } else {
      this.subnets = null;
    }
    return (A) this;
  }
  
  public A withSubnets(String... subnets) {
    if (this.subnets != null) {
        this.subnets.clear();
        _visitables.remove("subnets");
    }
    if (subnets != null) {
      for (String item : subnets) {
        this.addToSubnets(item);
      }
    }
    return (A) this;
  }
  
}