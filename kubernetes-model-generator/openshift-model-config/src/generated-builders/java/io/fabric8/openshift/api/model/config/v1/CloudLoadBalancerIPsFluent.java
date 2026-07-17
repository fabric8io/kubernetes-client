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
public class CloudLoadBalancerIPsFluent<A extends io.fabric8.openshift.api.model.config.v1.CloudLoadBalancerIPsFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private List<String> apiIntLoadBalancerIPs = new ArrayList<String>();
  private List<String> apiLoadBalancerIPs = new ArrayList<String>();
  private List<String> ingressLoadBalancerIPs = new ArrayList<String>();

  public CloudLoadBalancerIPsFluent() {
  }
  
  public CloudLoadBalancerIPsFluent(CloudLoadBalancerIPs instance) {
    this.copyInstance(instance);
  }

  public A addAllToApiIntLoadBalancerIPs(Collection<String> items) {
    if (this.apiIntLoadBalancerIPs == null) {
      this.apiIntLoadBalancerIPs = new ArrayList();
    }
    for (String item : items) {
      this.apiIntLoadBalancerIPs.add(item);
    }
    return (A) this;
  }
  
  public A addAllToApiLoadBalancerIPs(Collection<String> items) {
    if (this.apiLoadBalancerIPs == null) {
      this.apiLoadBalancerIPs = new ArrayList();
    }
    for (String item : items) {
      this.apiLoadBalancerIPs.add(item);
    }
    return (A) this;
  }
  
  public A addAllToIngressLoadBalancerIPs(Collection<String> items) {
    if (this.ingressLoadBalancerIPs == null) {
      this.ingressLoadBalancerIPs = new ArrayList();
    }
    for (String item : items) {
      this.ingressLoadBalancerIPs.add(item);
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
  
  public A addToApiIntLoadBalancerIPs(String... items) {
    if (this.apiIntLoadBalancerIPs == null) {
      this.apiIntLoadBalancerIPs = new ArrayList();
    }
    for (String item : items) {
      this.apiIntLoadBalancerIPs.add(item);
    }
    return (A) this;
  }
  
  public A addToApiIntLoadBalancerIPs(int index,String item) {
    if (this.apiIntLoadBalancerIPs == null) {
      this.apiIntLoadBalancerIPs = new ArrayList();
    }
    this.apiIntLoadBalancerIPs.add(index, item);
    return (A) this;
  }
  
  public A addToApiLoadBalancerIPs(String... items) {
    if (this.apiLoadBalancerIPs == null) {
      this.apiLoadBalancerIPs = new ArrayList();
    }
    for (String item : items) {
      this.apiLoadBalancerIPs.add(item);
    }
    return (A) this;
  }
  
  public A addToApiLoadBalancerIPs(int index,String item) {
    if (this.apiLoadBalancerIPs == null) {
      this.apiLoadBalancerIPs = new ArrayList();
    }
    this.apiLoadBalancerIPs.add(index, item);
    return (A) this;
  }
  
  public A addToIngressLoadBalancerIPs(String... items) {
    if (this.ingressLoadBalancerIPs == null) {
      this.ingressLoadBalancerIPs = new ArrayList();
    }
    for (String item : items) {
      this.ingressLoadBalancerIPs.add(item);
    }
    return (A) this;
  }
  
  public A addToIngressLoadBalancerIPs(int index,String item) {
    if (this.ingressLoadBalancerIPs == null) {
      this.ingressLoadBalancerIPs = new ArrayList();
    }
    this.ingressLoadBalancerIPs.add(index, item);
    return (A) this;
  }
  
  protected void copyInstance(CloudLoadBalancerIPs instance) {
    instance = instance != null ? instance : new CloudLoadBalancerIPs();
    if (instance != null) {
        this.withApiIntLoadBalancerIPs(instance.getApiIntLoadBalancerIPs());
        this.withApiLoadBalancerIPs(instance.getApiLoadBalancerIPs());
        this.withIngressLoadBalancerIPs(instance.getIngressLoadBalancerIPs());
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
    CloudLoadBalancerIPsFluent that = (CloudLoadBalancerIPsFluent) o;
    if (!(Objects.equals(apiIntLoadBalancerIPs, that.apiIntLoadBalancerIPs))) {
      return false;
    }
    if (!(Objects.equals(apiLoadBalancerIPs, that.apiLoadBalancerIPs))) {
      return false;
    }
    if (!(Objects.equals(ingressLoadBalancerIPs, that.ingressLoadBalancerIPs))) {
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
  
  public String getApiIntLoadBalancerIP(int index) {
    return this.apiIntLoadBalancerIPs.get(index);
  }
  
  public List<String> getApiIntLoadBalancerIPs() {
    return this.apiIntLoadBalancerIPs;
  }
  
  public String getApiLoadBalancerIP(int index) {
    return this.apiLoadBalancerIPs.get(index);
  }
  
  public List<String> getApiLoadBalancerIPs() {
    return this.apiLoadBalancerIPs;
  }
  
  public String getFirstApiIntLoadBalancerIP() {
    return this.apiIntLoadBalancerIPs.get(0);
  }
  
  public String getFirstApiLoadBalancerIP() {
    return this.apiLoadBalancerIPs.get(0);
  }
  
  public String getFirstIngressLoadBalancerIP() {
    return this.ingressLoadBalancerIPs.get(0);
  }
  
  public String getIngressLoadBalancerIP(int index) {
    return this.ingressLoadBalancerIPs.get(index);
  }
  
  public List<String> getIngressLoadBalancerIPs() {
    return this.ingressLoadBalancerIPs;
  }
  
  public String getLastApiIntLoadBalancerIP() {
    return this.apiIntLoadBalancerIPs.get(apiIntLoadBalancerIPs.size() - 1);
  }
  
  public String getLastApiLoadBalancerIP() {
    return this.apiLoadBalancerIPs.get(apiLoadBalancerIPs.size() - 1);
  }
  
  public String getLastIngressLoadBalancerIP() {
    return this.ingressLoadBalancerIPs.get(ingressLoadBalancerIPs.size() - 1);
  }
  
  public String getMatchingApiIntLoadBalancerIP(Predicate<String> predicate) {
      for (String item : apiIntLoadBalancerIPs) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public String getMatchingApiLoadBalancerIP(Predicate<String> predicate) {
      for (String item : apiLoadBalancerIPs) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public String getMatchingIngressLoadBalancerIP(Predicate<String> predicate) {
      for (String item : ingressLoadBalancerIPs) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasApiIntLoadBalancerIPs() {
    return this.apiIntLoadBalancerIPs != null && !(this.apiIntLoadBalancerIPs.isEmpty());
  }
  
  public boolean hasApiLoadBalancerIPs() {
    return this.apiLoadBalancerIPs != null && !(this.apiLoadBalancerIPs.isEmpty());
  }
  
  public boolean hasIngressLoadBalancerIPs() {
    return this.ingressLoadBalancerIPs != null && !(this.ingressLoadBalancerIPs.isEmpty());
  }
  
  public boolean hasMatchingApiIntLoadBalancerIP(Predicate<String> predicate) {
      for (String item : apiIntLoadBalancerIPs) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingApiLoadBalancerIP(Predicate<String> predicate) {
      for (String item : apiLoadBalancerIPs) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingIngressLoadBalancerIP(Predicate<String> predicate) {
      for (String item : ingressLoadBalancerIPs) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public int hashCode() {
    return Objects.hash(apiIntLoadBalancerIPs, apiLoadBalancerIPs, ingressLoadBalancerIPs, additionalProperties);
  }
  
  public A removeAllFromApiIntLoadBalancerIPs(Collection<String> items) {
    if (this.apiIntLoadBalancerIPs == null) {
      return (A) this;
    }
    for (String item : items) {
      this.apiIntLoadBalancerIPs.remove(item);
    }
    return (A) this;
  }
  
  public A removeAllFromApiLoadBalancerIPs(Collection<String> items) {
    if (this.apiLoadBalancerIPs == null) {
      return (A) this;
    }
    for (String item : items) {
      this.apiLoadBalancerIPs.remove(item);
    }
    return (A) this;
  }
  
  public A removeAllFromIngressLoadBalancerIPs(Collection<String> items) {
    if (this.ingressLoadBalancerIPs == null) {
      return (A) this;
    }
    for (String item : items) {
      this.ingressLoadBalancerIPs.remove(item);
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
  
  public A removeFromApiIntLoadBalancerIPs(String... items) {
    if (this.apiIntLoadBalancerIPs == null) {
      return (A) this;
    }
    for (String item : items) {
      this.apiIntLoadBalancerIPs.remove(item);
    }
    return (A) this;
  }
  
  public A removeFromApiLoadBalancerIPs(String... items) {
    if (this.apiLoadBalancerIPs == null) {
      return (A) this;
    }
    for (String item : items) {
      this.apiLoadBalancerIPs.remove(item);
    }
    return (A) this;
  }
  
  public A removeFromIngressLoadBalancerIPs(String... items) {
    if (this.ingressLoadBalancerIPs == null) {
      return (A) this;
    }
    for (String item : items) {
      this.ingressLoadBalancerIPs.remove(item);
    }
    return (A) this;
  }
  
  public A setToApiIntLoadBalancerIPs(int index,String item) {
    if (this.apiIntLoadBalancerIPs == null) {
      this.apiIntLoadBalancerIPs = new ArrayList();
    }
    this.apiIntLoadBalancerIPs.set(index, item);
    return (A) this;
  }
  
  public A setToApiLoadBalancerIPs(int index,String item) {
    if (this.apiLoadBalancerIPs == null) {
      this.apiLoadBalancerIPs = new ArrayList();
    }
    this.apiLoadBalancerIPs.set(index, item);
    return (A) this;
  }
  
  public A setToIngressLoadBalancerIPs(int index,String item) {
    if (this.ingressLoadBalancerIPs == null) {
      this.ingressLoadBalancerIPs = new ArrayList();
    }
    this.ingressLoadBalancerIPs.set(index, item);
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(apiIntLoadBalancerIPs == null) && !(apiIntLoadBalancerIPs.isEmpty())) {
        sb.append("apiIntLoadBalancerIPs:");
        sb.append(apiIntLoadBalancerIPs);
        sb.append(",");
    }
    if (!(apiLoadBalancerIPs == null) && !(apiLoadBalancerIPs.isEmpty())) {
        sb.append("apiLoadBalancerIPs:");
        sb.append(apiLoadBalancerIPs);
        sb.append(",");
    }
    if (!(ingressLoadBalancerIPs == null) && !(ingressLoadBalancerIPs.isEmpty())) {
        sb.append("ingressLoadBalancerIPs:");
        sb.append(ingressLoadBalancerIPs);
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
  
  public A withApiIntLoadBalancerIPs(List<String> apiIntLoadBalancerIPs) {
    if (apiIntLoadBalancerIPs != null) {
        this.apiIntLoadBalancerIPs = new ArrayList();
        for (String item : apiIntLoadBalancerIPs) {
          this.addToApiIntLoadBalancerIPs(item);
        }
    } else {
      this.apiIntLoadBalancerIPs = null;
    }
    return (A) this;
  }
  
  public A withApiIntLoadBalancerIPs(String... apiIntLoadBalancerIPs) {
    if (this.apiIntLoadBalancerIPs != null) {
        this.apiIntLoadBalancerIPs.clear();
        _visitables.remove("apiIntLoadBalancerIPs");
    }
    if (apiIntLoadBalancerIPs != null) {
      for (String item : apiIntLoadBalancerIPs) {
        this.addToApiIntLoadBalancerIPs(item);
      }
    }
    return (A) this;
  }
  
  public A withApiLoadBalancerIPs(List<String> apiLoadBalancerIPs) {
    if (apiLoadBalancerIPs != null) {
        this.apiLoadBalancerIPs = new ArrayList();
        for (String item : apiLoadBalancerIPs) {
          this.addToApiLoadBalancerIPs(item);
        }
    } else {
      this.apiLoadBalancerIPs = null;
    }
    return (A) this;
  }
  
  public A withApiLoadBalancerIPs(String... apiLoadBalancerIPs) {
    if (this.apiLoadBalancerIPs != null) {
        this.apiLoadBalancerIPs.clear();
        _visitables.remove("apiLoadBalancerIPs");
    }
    if (apiLoadBalancerIPs != null) {
      for (String item : apiLoadBalancerIPs) {
        this.addToApiLoadBalancerIPs(item);
      }
    }
    return (A) this;
  }
  
  public A withIngressLoadBalancerIPs(List<String> ingressLoadBalancerIPs) {
    if (ingressLoadBalancerIPs != null) {
        this.ingressLoadBalancerIPs = new ArrayList();
        for (String item : ingressLoadBalancerIPs) {
          this.addToIngressLoadBalancerIPs(item);
        }
    } else {
      this.ingressLoadBalancerIPs = null;
    }
    return (A) this;
  }
  
  public A withIngressLoadBalancerIPs(String... ingressLoadBalancerIPs) {
    if (this.ingressLoadBalancerIPs != null) {
        this.ingressLoadBalancerIPs.clear();
        _visitables.remove("ingressLoadBalancerIPs");
    }
    if (ingressLoadBalancerIPs != null) {
      for (String item : ingressLoadBalancerIPs) {
        this.addToIngressLoadBalancerIPs(item);
      }
    }
    return (A) this;
  }
  
}