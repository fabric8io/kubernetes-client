package io.fabric8.knative.internal.networking.v1alpha1;

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
public class IngressTLSFluent<A extends io.fabric8.knative.internal.networking.v1alpha1.IngressTLSFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private List<String> hosts = new ArrayList<String>();
  private String secretName;
  private String secretNamespace;

  public IngressTLSFluent() {
  }
  
  public IngressTLSFluent(IngressTLS instance) {
    this.copyInstance(instance);
  }

  public A addAllToHosts(Collection<String> items) {
    if (this.hosts == null) {
      this.hosts = new ArrayList();
    }
    for (String item : items) {
      this.hosts.add(item);
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
  
  public A addToHosts(String... items) {
    if (this.hosts == null) {
      this.hosts = new ArrayList();
    }
    for (String item : items) {
      this.hosts.add(item);
    }
    return (A) this;
  }
  
  public A addToHosts(int index,String item) {
    if (this.hosts == null) {
      this.hosts = new ArrayList();
    }
    this.hosts.add(index, item);
    return (A) this;
  }
  
  protected void copyInstance(IngressTLS instance) {
    instance = instance != null ? instance : new IngressTLS();
    if (instance != null) {
        this.withHosts(instance.getHosts());
        this.withSecretName(instance.getSecretName());
        this.withSecretNamespace(instance.getSecretNamespace());
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
    IngressTLSFluent that = (IngressTLSFluent) o;
    if (!(Objects.equals(hosts, that.hosts))) {
      return false;
    }
    if (!(Objects.equals(secretName, that.secretName))) {
      return false;
    }
    if (!(Objects.equals(secretNamespace, that.secretNamespace))) {
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
  
  public String getFirstHost() {
    return this.hosts.get(0);
  }
  
  public String getHost(int index) {
    return this.hosts.get(index);
  }
  
  public List<String> getHosts() {
    return this.hosts;
  }
  
  public String getLastHost() {
    return this.hosts.get(hosts.size() - 1);
  }
  
  public String getMatchingHost(Predicate<String> predicate) {
      for (String item : hosts) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public String getSecretName() {
    return this.secretName;
  }
  
  public String getSecretNamespace() {
    return this.secretNamespace;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasHosts() {
    return this.hosts != null && !(this.hosts.isEmpty());
  }
  
  public boolean hasMatchingHost(Predicate<String> predicate) {
      for (String item : hosts) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasSecretName() {
    return this.secretName != null;
  }
  
  public boolean hasSecretNamespace() {
    return this.secretNamespace != null;
  }
  
  public int hashCode() {
    return Objects.hash(hosts, secretName, secretNamespace, additionalProperties);
  }
  
  public A removeAllFromHosts(Collection<String> items) {
    if (this.hosts == null) {
      return (A) this;
    }
    for (String item : items) {
      this.hosts.remove(item);
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
  
  public A removeFromHosts(String... items) {
    if (this.hosts == null) {
      return (A) this;
    }
    for (String item : items) {
      this.hosts.remove(item);
    }
    return (A) this;
  }
  
  public A setToHosts(int index,String item) {
    if (this.hosts == null) {
      this.hosts = new ArrayList();
    }
    this.hosts.set(index, item);
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(hosts == null) && !(hosts.isEmpty())) {
        sb.append("hosts:");
        sb.append(hosts);
        sb.append(",");
    }
    if (!(secretName == null)) {
        sb.append("secretName:");
        sb.append(secretName);
        sb.append(",");
    }
    if (!(secretNamespace == null)) {
        sb.append("secretNamespace:");
        sb.append(secretNamespace);
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
  
  public A withHosts(List<String> hosts) {
    if (hosts != null) {
        this.hosts = new ArrayList();
        for (String item : hosts) {
          this.addToHosts(item);
        }
    } else {
      this.hosts = null;
    }
    return (A) this;
  }
  
  public A withHosts(String... hosts) {
    if (this.hosts != null) {
        this.hosts.clear();
        _visitables.remove("hosts");
    }
    if (hosts != null) {
      for (String item : hosts) {
        this.addToHosts(item);
      }
    }
    return (A) this;
  }
  
  public A withSecretName(String secretName) {
    this.secretName = secretName;
    return (A) this;
  }
  
  public A withSecretNamespace(String secretNamespace) {
    this.secretNamespace = secretNamespace;
    return (A) this;
  }
  
}