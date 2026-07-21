package io.fabric8.certmanager.api.model.v1;

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
public class SelfSignedIssuerFluent<A extends io.fabric8.certmanager.api.model.v1.SelfSignedIssuerFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private List<String> crlDistributionPoints = new ArrayList<String>();

  public SelfSignedIssuerFluent() {
  }
  
  public SelfSignedIssuerFluent(SelfSignedIssuer instance) {
    this.copyInstance(instance);
  }

  public A addAllToCrlDistributionPoints(Collection<String> items) {
    if (this.crlDistributionPoints == null) {
      this.crlDistributionPoints = new ArrayList();
    }
    for (String item : items) {
      this.crlDistributionPoints.add(item);
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
  
  public A addToCrlDistributionPoints(String... items) {
    if (this.crlDistributionPoints == null) {
      this.crlDistributionPoints = new ArrayList();
    }
    for (String item : items) {
      this.crlDistributionPoints.add(item);
    }
    return (A) this;
  }
  
  public A addToCrlDistributionPoints(int index,String item) {
    if (this.crlDistributionPoints == null) {
      this.crlDistributionPoints = new ArrayList();
    }
    this.crlDistributionPoints.add(index, item);
    return (A) this;
  }
  
  protected void copyInstance(SelfSignedIssuer instance) {
    instance = instance != null ? instance : new SelfSignedIssuer();
    if (instance != null) {
        this.withCrlDistributionPoints(instance.getCrlDistributionPoints());
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
    SelfSignedIssuerFluent that = (SelfSignedIssuerFluent) o;
    if (!(Objects.equals(crlDistributionPoints, that.crlDistributionPoints))) {
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
  
  public String getCrlDistributionPoint(int index) {
    return this.crlDistributionPoints.get(index);
  }
  
  public List<String> getCrlDistributionPoints() {
    return this.crlDistributionPoints;
  }
  
  public String getFirstCrlDistributionPoint() {
    return this.crlDistributionPoints.get(0);
  }
  
  public String getLastCrlDistributionPoint() {
    return this.crlDistributionPoints.get(crlDistributionPoints.size() - 1);
  }
  
  public String getMatchingCrlDistributionPoint(Predicate<String> predicate) {
      for (String item : crlDistributionPoints) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasCrlDistributionPoints() {
    return this.crlDistributionPoints != null && !(this.crlDistributionPoints.isEmpty());
  }
  
  public boolean hasMatchingCrlDistributionPoint(Predicate<String> predicate) {
      for (String item : crlDistributionPoints) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public int hashCode() {
    return Objects.hash(crlDistributionPoints, additionalProperties);
  }
  
  public A removeAllFromCrlDistributionPoints(Collection<String> items) {
    if (this.crlDistributionPoints == null) {
      return (A) this;
    }
    for (String item : items) {
      this.crlDistributionPoints.remove(item);
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
  
  public A removeFromCrlDistributionPoints(String... items) {
    if (this.crlDistributionPoints == null) {
      return (A) this;
    }
    for (String item : items) {
      this.crlDistributionPoints.remove(item);
    }
    return (A) this;
  }
  
  public A setToCrlDistributionPoints(int index,String item) {
    if (this.crlDistributionPoints == null) {
      this.crlDistributionPoints = new ArrayList();
    }
    this.crlDistributionPoints.set(index, item);
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(crlDistributionPoints == null) && !(crlDistributionPoints.isEmpty())) {
        sb.append("crlDistributionPoints:");
        sb.append(crlDistributionPoints);
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
  
  public A withCrlDistributionPoints(List<String> crlDistributionPoints) {
    if (crlDistributionPoints != null) {
        this.crlDistributionPoints = new ArrayList();
        for (String item : crlDistributionPoints) {
          this.addToCrlDistributionPoints(item);
        }
    } else {
      this.crlDistributionPoints = null;
    }
    return (A) this;
  }
  
  public A withCrlDistributionPoints(String... crlDistributionPoints) {
    if (this.crlDistributionPoints != null) {
        this.crlDistributionPoints.clear();
        _visitables.remove("crlDistributionPoints");
    }
    if (crlDistributionPoints != null) {
      for (String item : crlDistributionPoints) {
        this.addToCrlDistributionPoints(item);
      }
    }
    return (A) this;
  }
  
}