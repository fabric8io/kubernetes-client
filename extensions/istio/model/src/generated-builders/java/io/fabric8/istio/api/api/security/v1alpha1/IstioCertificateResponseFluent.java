package io.fabric8.istio.api.api.security.v1alpha1;

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
public class IstioCertificateResponseFluent<A extends io.fabric8.istio.api.api.security.v1alpha1.IstioCertificateResponseFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private List<String> certChain = new ArrayList<String>();

  public IstioCertificateResponseFluent() {
  }
  
  public IstioCertificateResponseFluent(IstioCertificateResponse instance) {
    this.copyInstance(instance);
  }

  public A addAllToCertChain(Collection<String> items) {
    if (this.certChain == null) {
      this.certChain = new ArrayList();
    }
    for (String item : items) {
      this.certChain.add(item);
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
  
  public A addToCertChain(String... items) {
    if (this.certChain == null) {
      this.certChain = new ArrayList();
    }
    for (String item : items) {
      this.certChain.add(item);
    }
    return (A) this;
  }
  
  public A addToCertChain(int index,String item) {
    if (this.certChain == null) {
      this.certChain = new ArrayList();
    }
    this.certChain.add(index, item);
    return (A) this;
  }
  
  protected void copyInstance(IstioCertificateResponse instance) {
    instance = instance != null ? instance : new IstioCertificateResponse();
    if (instance != null) {
        this.withCertChain(instance.getCertChain());
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
    IstioCertificateResponseFluent that = (IstioCertificateResponseFluent) o;
    if (!(Objects.equals(certChain, that.certChain))) {
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
  
  public List<String> getCertChain() {
    return this.certChain;
  }
  
  public String getCertChain(int index) {
    return this.certChain.get(index);
  }
  
  public String getFirstCertChain() {
    return this.certChain.get(0);
  }
  
  public String getLastCertChain() {
    return this.certChain.get(certChain.size() - 1);
  }
  
  public String getMatchingCertChain(Predicate<String> predicate) {
      for (String item : certChain) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasCertChain() {
    return this.certChain != null && !(this.certChain.isEmpty());
  }
  
  public boolean hasMatchingCertChain(Predicate<String> predicate) {
      for (String item : certChain) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public int hashCode() {
    return Objects.hash(certChain, additionalProperties);
  }
  
  public A removeAllFromCertChain(Collection<String> items) {
    if (this.certChain == null) {
      return (A) this;
    }
    for (String item : items) {
      this.certChain.remove(item);
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
  
  public A removeFromCertChain(String... items) {
    if (this.certChain == null) {
      return (A) this;
    }
    for (String item : items) {
      this.certChain.remove(item);
    }
    return (A) this;
  }
  
  public A setToCertChain(int index,String item) {
    if (this.certChain == null) {
      this.certChain = new ArrayList();
    }
    this.certChain.set(index, item);
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(certChain == null) && !(certChain.isEmpty())) {
        sb.append("certChain:");
        sb.append(certChain);
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
  
  public A withCertChain(List<String> certChain) {
    if (certChain != null) {
        this.certChain = new ArrayList();
        for (String item : certChain) {
          this.addToCertChain(item);
        }
    } else {
      this.certChain = null;
    }
    return (A) this;
  }
  
  public A withCertChain(String... certChain) {
    if (this.certChain != null) {
        this.certChain.clear();
        _visitables.remove("certChain");
    }
    if (certChain != null) {
      for (String item : certChain) {
        this.addToCertChain(item);
      }
    }
    return (A) this;
  }
  
}