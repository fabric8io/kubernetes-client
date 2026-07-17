package io.fabric8.openshift.api.model.operator.v1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.openshift.api.model.config.v1.ConfigMapNameReference;
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
public class ClientTLSFluent<A extends io.fabric8.openshift.api.model.operator.v1.ClientTLSFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private List<String> allowedSubjectPatterns = new ArrayList<String>();
  private ConfigMapNameReference clientCA;
  private String clientCertificatePolicy;

  public ClientTLSFluent() {
  }
  
  public ClientTLSFluent(ClientTLS instance) {
    this.copyInstance(instance);
  }

  public A addAllToAllowedSubjectPatterns(Collection<String> items) {
    if (this.allowedSubjectPatterns == null) {
      this.allowedSubjectPatterns = new ArrayList();
    }
    for (String item : items) {
      this.allowedSubjectPatterns.add(item);
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
  
  public A addToAllowedSubjectPatterns(String... items) {
    if (this.allowedSubjectPatterns == null) {
      this.allowedSubjectPatterns = new ArrayList();
    }
    for (String item : items) {
      this.allowedSubjectPatterns.add(item);
    }
    return (A) this;
  }
  
  public A addToAllowedSubjectPatterns(int index,String item) {
    if (this.allowedSubjectPatterns == null) {
      this.allowedSubjectPatterns = new ArrayList();
    }
    this.allowedSubjectPatterns.add(index, item);
    return (A) this;
  }
  
  protected void copyInstance(ClientTLS instance) {
    instance = instance != null ? instance : new ClientTLS();
    if (instance != null) {
        this.withAllowedSubjectPatterns(instance.getAllowedSubjectPatterns());
        this.withClientCA(instance.getClientCA());
        this.withClientCertificatePolicy(instance.getClientCertificatePolicy());
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
    ClientTLSFluent that = (ClientTLSFluent) o;
    if (!(Objects.equals(allowedSubjectPatterns, that.allowedSubjectPatterns))) {
      return false;
    }
    if (!(Objects.equals(clientCA, that.clientCA))) {
      return false;
    }
    if (!(Objects.equals(clientCertificatePolicy, that.clientCertificatePolicy))) {
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
  
  public String getAllowedSubjectPattern(int index) {
    return this.allowedSubjectPatterns.get(index);
  }
  
  public List<String> getAllowedSubjectPatterns() {
    return this.allowedSubjectPatterns;
  }
  
  public ConfigMapNameReference getClientCA() {
    return this.clientCA;
  }
  
  public String getClientCertificatePolicy() {
    return this.clientCertificatePolicy;
  }
  
  public String getFirstAllowedSubjectPattern() {
    return this.allowedSubjectPatterns.get(0);
  }
  
  public String getLastAllowedSubjectPattern() {
    return this.allowedSubjectPatterns.get(allowedSubjectPatterns.size() - 1);
  }
  
  public String getMatchingAllowedSubjectPattern(Predicate<String> predicate) {
      for (String item : allowedSubjectPatterns) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasAllowedSubjectPatterns() {
    return this.allowedSubjectPatterns != null && !(this.allowedSubjectPatterns.isEmpty());
  }
  
  public boolean hasClientCA() {
    return this.clientCA != null;
  }
  
  public boolean hasClientCertificatePolicy() {
    return this.clientCertificatePolicy != null;
  }
  
  public boolean hasMatchingAllowedSubjectPattern(Predicate<String> predicate) {
      for (String item : allowedSubjectPatterns) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public int hashCode() {
    return Objects.hash(allowedSubjectPatterns, clientCA, clientCertificatePolicy, additionalProperties);
  }
  
  public A removeAllFromAllowedSubjectPatterns(Collection<String> items) {
    if (this.allowedSubjectPatterns == null) {
      return (A) this;
    }
    for (String item : items) {
      this.allowedSubjectPatterns.remove(item);
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
  
  public A removeFromAllowedSubjectPatterns(String... items) {
    if (this.allowedSubjectPatterns == null) {
      return (A) this;
    }
    for (String item : items) {
      this.allowedSubjectPatterns.remove(item);
    }
    return (A) this;
  }
  
  public A setToAllowedSubjectPatterns(int index,String item) {
    if (this.allowedSubjectPatterns == null) {
      this.allowedSubjectPatterns = new ArrayList();
    }
    this.allowedSubjectPatterns.set(index, item);
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(allowedSubjectPatterns == null) && !(allowedSubjectPatterns.isEmpty())) {
        sb.append("allowedSubjectPatterns:");
        sb.append(allowedSubjectPatterns);
        sb.append(",");
    }
    if (!(clientCA == null)) {
        sb.append("clientCA:");
        sb.append(clientCA);
        sb.append(",");
    }
    if (!(clientCertificatePolicy == null)) {
        sb.append("clientCertificatePolicy:");
        sb.append(clientCertificatePolicy);
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
  
  public A withAllowedSubjectPatterns(List<String> allowedSubjectPatterns) {
    if (allowedSubjectPatterns != null) {
        this.allowedSubjectPatterns = new ArrayList();
        for (String item : allowedSubjectPatterns) {
          this.addToAllowedSubjectPatterns(item);
        }
    } else {
      this.allowedSubjectPatterns = null;
    }
    return (A) this;
  }
  
  public A withAllowedSubjectPatterns(String... allowedSubjectPatterns) {
    if (this.allowedSubjectPatterns != null) {
        this.allowedSubjectPatterns.clear();
        _visitables.remove("allowedSubjectPatterns");
    }
    if (allowedSubjectPatterns != null) {
      for (String item : allowedSubjectPatterns) {
        this.addToAllowedSubjectPatterns(item);
      }
    }
    return (A) this;
  }
  
  public A withClientCA(ConfigMapNameReference clientCA) {
    this.clientCA = clientCA;
    return (A) this;
  }
  
  public A withClientCertificatePolicy(String clientCertificatePolicy) {
    this.clientCertificatePolicy = clientCertificatePolicy;
    return (A) this;
  }
  
  public A withNewClientCA(String name) {
    return (A) this.withClientCA(new ConfigMapNameReference(name));
  }
  
}