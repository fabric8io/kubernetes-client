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
public class BareMetalPlatformSpecFluent<A extends io.fabric8.openshift.api.model.config.v1.BareMetalPlatformSpecFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private List<String> apiServerInternalIPs = new ArrayList<String>();
  private List<String> ingressIPs = new ArrayList<String>();
  private List<String> machineNetworks = new ArrayList<String>();

  public BareMetalPlatformSpecFluent() {
  }
  
  public BareMetalPlatformSpecFluent(BareMetalPlatformSpec instance) {
    this.copyInstance(instance);
  }

  public A addAllToApiServerInternalIPs(Collection<String> items) {
    if (this.apiServerInternalIPs == null) {
      this.apiServerInternalIPs = new ArrayList();
    }
    for (String item : items) {
      this.apiServerInternalIPs.add(item);
    }
    return (A) this;
  }
  
  public A addAllToIngressIPs(Collection<String> items) {
    if (this.ingressIPs == null) {
      this.ingressIPs = new ArrayList();
    }
    for (String item : items) {
      this.ingressIPs.add(item);
    }
    return (A) this;
  }
  
  public A addAllToMachineNetworks(Collection<String> items) {
    if (this.machineNetworks == null) {
      this.machineNetworks = new ArrayList();
    }
    for (String item : items) {
      this.machineNetworks.add(item);
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
  
  public A addToApiServerInternalIPs(String... items) {
    if (this.apiServerInternalIPs == null) {
      this.apiServerInternalIPs = new ArrayList();
    }
    for (String item : items) {
      this.apiServerInternalIPs.add(item);
    }
    return (A) this;
  }
  
  public A addToApiServerInternalIPs(int index,String item) {
    if (this.apiServerInternalIPs == null) {
      this.apiServerInternalIPs = new ArrayList();
    }
    this.apiServerInternalIPs.add(index, item);
    return (A) this;
  }
  
  public A addToIngressIPs(String... items) {
    if (this.ingressIPs == null) {
      this.ingressIPs = new ArrayList();
    }
    for (String item : items) {
      this.ingressIPs.add(item);
    }
    return (A) this;
  }
  
  public A addToIngressIPs(int index,String item) {
    if (this.ingressIPs == null) {
      this.ingressIPs = new ArrayList();
    }
    this.ingressIPs.add(index, item);
    return (A) this;
  }
  
  public A addToMachineNetworks(String... items) {
    if (this.machineNetworks == null) {
      this.machineNetworks = new ArrayList();
    }
    for (String item : items) {
      this.machineNetworks.add(item);
    }
    return (A) this;
  }
  
  public A addToMachineNetworks(int index,String item) {
    if (this.machineNetworks == null) {
      this.machineNetworks = new ArrayList();
    }
    this.machineNetworks.add(index, item);
    return (A) this;
  }
  
  protected void copyInstance(BareMetalPlatformSpec instance) {
    instance = instance != null ? instance : new BareMetalPlatformSpec();
    if (instance != null) {
        this.withApiServerInternalIPs(instance.getApiServerInternalIPs());
        this.withIngressIPs(instance.getIngressIPs());
        this.withMachineNetworks(instance.getMachineNetworks());
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
    BareMetalPlatformSpecFluent that = (BareMetalPlatformSpecFluent) o;
    if (!(Objects.equals(apiServerInternalIPs, that.apiServerInternalIPs))) {
      return false;
    }
    if (!(Objects.equals(ingressIPs, that.ingressIPs))) {
      return false;
    }
    if (!(Objects.equals(machineNetworks, that.machineNetworks))) {
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
  
  public String getApiServerInternalIP(int index) {
    return this.apiServerInternalIPs.get(index);
  }
  
  public List<String> getApiServerInternalIPs() {
    return this.apiServerInternalIPs;
  }
  
  public String getFirstApiServerInternalIP() {
    return this.apiServerInternalIPs.get(0);
  }
  
  public String getFirstIngressIP() {
    return this.ingressIPs.get(0);
  }
  
  public String getFirstMachineNetwork() {
    return this.machineNetworks.get(0);
  }
  
  public String getIngressIP(int index) {
    return this.ingressIPs.get(index);
  }
  
  public List<String> getIngressIPs() {
    return this.ingressIPs;
  }
  
  public String getLastApiServerInternalIP() {
    return this.apiServerInternalIPs.get(apiServerInternalIPs.size() - 1);
  }
  
  public String getLastIngressIP() {
    return this.ingressIPs.get(ingressIPs.size() - 1);
  }
  
  public String getLastMachineNetwork() {
    return this.machineNetworks.get(machineNetworks.size() - 1);
  }
  
  public String getMachineNetwork(int index) {
    return this.machineNetworks.get(index);
  }
  
  public List<String> getMachineNetworks() {
    return this.machineNetworks;
  }
  
  public String getMatchingApiServerInternalIP(Predicate<String> predicate) {
      for (String item : apiServerInternalIPs) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public String getMatchingIngressIP(Predicate<String> predicate) {
      for (String item : ingressIPs) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public String getMatchingMachineNetwork(Predicate<String> predicate) {
      for (String item : machineNetworks) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasApiServerInternalIPs() {
    return this.apiServerInternalIPs != null && !(this.apiServerInternalIPs.isEmpty());
  }
  
  public boolean hasIngressIPs() {
    return this.ingressIPs != null && !(this.ingressIPs.isEmpty());
  }
  
  public boolean hasMachineNetworks() {
    return this.machineNetworks != null && !(this.machineNetworks.isEmpty());
  }
  
  public boolean hasMatchingApiServerInternalIP(Predicate<String> predicate) {
      for (String item : apiServerInternalIPs) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingIngressIP(Predicate<String> predicate) {
      for (String item : ingressIPs) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingMachineNetwork(Predicate<String> predicate) {
      for (String item : machineNetworks) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public int hashCode() {
    return Objects.hash(apiServerInternalIPs, ingressIPs, machineNetworks, additionalProperties);
  }
  
  public A removeAllFromApiServerInternalIPs(Collection<String> items) {
    if (this.apiServerInternalIPs == null) {
      return (A) this;
    }
    for (String item : items) {
      this.apiServerInternalIPs.remove(item);
    }
    return (A) this;
  }
  
  public A removeAllFromIngressIPs(Collection<String> items) {
    if (this.ingressIPs == null) {
      return (A) this;
    }
    for (String item : items) {
      this.ingressIPs.remove(item);
    }
    return (A) this;
  }
  
  public A removeAllFromMachineNetworks(Collection<String> items) {
    if (this.machineNetworks == null) {
      return (A) this;
    }
    for (String item : items) {
      this.machineNetworks.remove(item);
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
  
  public A removeFromApiServerInternalIPs(String... items) {
    if (this.apiServerInternalIPs == null) {
      return (A) this;
    }
    for (String item : items) {
      this.apiServerInternalIPs.remove(item);
    }
    return (A) this;
  }
  
  public A removeFromIngressIPs(String... items) {
    if (this.ingressIPs == null) {
      return (A) this;
    }
    for (String item : items) {
      this.ingressIPs.remove(item);
    }
    return (A) this;
  }
  
  public A removeFromMachineNetworks(String... items) {
    if (this.machineNetworks == null) {
      return (A) this;
    }
    for (String item : items) {
      this.machineNetworks.remove(item);
    }
    return (A) this;
  }
  
  public A setToApiServerInternalIPs(int index,String item) {
    if (this.apiServerInternalIPs == null) {
      this.apiServerInternalIPs = new ArrayList();
    }
    this.apiServerInternalIPs.set(index, item);
    return (A) this;
  }
  
  public A setToIngressIPs(int index,String item) {
    if (this.ingressIPs == null) {
      this.ingressIPs = new ArrayList();
    }
    this.ingressIPs.set(index, item);
    return (A) this;
  }
  
  public A setToMachineNetworks(int index,String item) {
    if (this.machineNetworks == null) {
      this.machineNetworks = new ArrayList();
    }
    this.machineNetworks.set(index, item);
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(apiServerInternalIPs == null) && !(apiServerInternalIPs.isEmpty())) {
        sb.append("apiServerInternalIPs:");
        sb.append(apiServerInternalIPs);
        sb.append(",");
    }
    if (!(ingressIPs == null) && !(ingressIPs.isEmpty())) {
        sb.append("ingressIPs:");
        sb.append(ingressIPs);
        sb.append(",");
    }
    if (!(machineNetworks == null) && !(machineNetworks.isEmpty())) {
        sb.append("machineNetworks:");
        sb.append(machineNetworks);
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
  
  public A withApiServerInternalIPs(List<String> apiServerInternalIPs) {
    if (apiServerInternalIPs != null) {
        this.apiServerInternalIPs = new ArrayList();
        for (String item : apiServerInternalIPs) {
          this.addToApiServerInternalIPs(item);
        }
    } else {
      this.apiServerInternalIPs = null;
    }
    return (A) this;
  }
  
  public A withApiServerInternalIPs(String... apiServerInternalIPs) {
    if (this.apiServerInternalIPs != null) {
        this.apiServerInternalIPs.clear();
        _visitables.remove("apiServerInternalIPs");
    }
    if (apiServerInternalIPs != null) {
      for (String item : apiServerInternalIPs) {
        this.addToApiServerInternalIPs(item);
      }
    }
    return (A) this;
  }
  
  public A withIngressIPs(List<String> ingressIPs) {
    if (ingressIPs != null) {
        this.ingressIPs = new ArrayList();
        for (String item : ingressIPs) {
          this.addToIngressIPs(item);
        }
    } else {
      this.ingressIPs = null;
    }
    return (A) this;
  }
  
  public A withIngressIPs(String... ingressIPs) {
    if (this.ingressIPs != null) {
        this.ingressIPs.clear();
        _visitables.remove("ingressIPs");
    }
    if (ingressIPs != null) {
      for (String item : ingressIPs) {
        this.addToIngressIPs(item);
      }
    }
    return (A) this;
  }
  
  public A withMachineNetworks(List<String> machineNetworks) {
    if (machineNetworks != null) {
        this.machineNetworks = new ArrayList();
        for (String item : machineNetworks) {
          this.addToMachineNetworks(item);
        }
    } else {
      this.machineNetworks = null;
    }
    return (A) this;
  }
  
  public A withMachineNetworks(String... machineNetworks) {
    if (this.machineNetworks != null) {
        this.machineNetworks.clear();
        _visitables.remove("machineNetworks");
    }
    if (machineNetworks != null) {
      for (String item : machineNetworks) {
        this.addToMachineNetworks(item);
      }
    }
    return (A) this;
  }
  
}