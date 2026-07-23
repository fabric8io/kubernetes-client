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
public class CAIssuerFluent<A extends io.fabric8.certmanager.api.model.v1.CAIssuerFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private List<String> crlDistributionPoints = new ArrayList<String>();
  private List<String> issuingCertificateURLs = new ArrayList<String>();
  private List<String> ocspServers = new ArrayList<String>();
  private String secretName;

  public CAIssuerFluent() {
  }
  
  public CAIssuerFluent(CAIssuer instance) {
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
  
  public A addAllToIssuingCertificateURLs(Collection<String> items) {
    if (this.issuingCertificateURLs == null) {
      this.issuingCertificateURLs = new ArrayList();
    }
    for (String item : items) {
      this.issuingCertificateURLs.add(item);
    }
    return (A) this;
  }
  
  public A addAllToOcspServers(Collection<String> items) {
    if (this.ocspServers == null) {
      this.ocspServers = new ArrayList();
    }
    for (String item : items) {
      this.ocspServers.add(item);
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
  
  public A addToIssuingCertificateURLs(String... items) {
    if (this.issuingCertificateURLs == null) {
      this.issuingCertificateURLs = new ArrayList();
    }
    for (String item : items) {
      this.issuingCertificateURLs.add(item);
    }
    return (A) this;
  }
  
  public A addToIssuingCertificateURLs(int index,String item) {
    if (this.issuingCertificateURLs == null) {
      this.issuingCertificateURLs = new ArrayList();
    }
    this.issuingCertificateURLs.add(index, item);
    return (A) this;
  }
  
  public A addToOcspServers(String... items) {
    if (this.ocspServers == null) {
      this.ocspServers = new ArrayList();
    }
    for (String item : items) {
      this.ocspServers.add(item);
    }
    return (A) this;
  }
  
  public A addToOcspServers(int index,String item) {
    if (this.ocspServers == null) {
      this.ocspServers = new ArrayList();
    }
    this.ocspServers.add(index, item);
    return (A) this;
  }
  
  protected void copyInstance(CAIssuer instance) {
    instance = instance != null ? instance : new CAIssuer();
    if (instance != null) {
        this.withCrlDistributionPoints(instance.getCrlDistributionPoints());
        this.withIssuingCertificateURLs(instance.getIssuingCertificateURLs());
        this.withOcspServers(instance.getOcspServers());
        this.withSecretName(instance.getSecretName());
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
    CAIssuerFluent that = (CAIssuerFluent) o;
    if (!(Objects.equals(crlDistributionPoints, that.crlDistributionPoints))) {
      return false;
    }
    if (!(Objects.equals(issuingCertificateURLs, that.issuingCertificateURLs))) {
      return false;
    }
    if (!(Objects.equals(ocspServers, that.ocspServers))) {
      return false;
    }
    if (!(Objects.equals(secretName, that.secretName))) {
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
  
  public String getFirstIssuingCertificateURL() {
    return this.issuingCertificateURLs.get(0);
  }
  
  public String getFirstOcspServer() {
    return this.ocspServers.get(0);
  }
  
  public String getIssuingCertificateURL(int index) {
    return this.issuingCertificateURLs.get(index);
  }
  
  public List<String> getIssuingCertificateURLs() {
    return this.issuingCertificateURLs;
  }
  
  public String getLastCrlDistributionPoint() {
    return this.crlDistributionPoints.get(crlDistributionPoints.size() - 1);
  }
  
  public String getLastIssuingCertificateURL() {
    return this.issuingCertificateURLs.get(issuingCertificateURLs.size() - 1);
  }
  
  public String getLastOcspServer() {
    return this.ocspServers.get(ocspServers.size() - 1);
  }
  
  public String getMatchingCrlDistributionPoint(Predicate<String> predicate) {
      for (String item : crlDistributionPoints) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public String getMatchingIssuingCertificateURL(Predicate<String> predicate) {
      for (String item : issuingCertificateURLs) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public String getMatchingOcspServer(Predicate<String> predicate) {
      for (String item : ocspServers) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public String getOcspServer(int index) {
    return this.ocspServers.get(index);
  }
  
  public List<String> getOcspServers() {
    return this.ocspServers;
  }
  
  public String getSecretName() {
    return this.secretName;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasCrlDistributionPoints() {
    return this.crlDistributionPoints != null && !(this.crlDistributionPoints.isEmpty());
  }
  
  public boolean hasIssuingCertificateURLs() {
    return this.issuingCertificateURLs != null && !(this.issuingCertificateURLs.isEmpty());
  }
  
  public boolean hasMatchingCrlDistributionPoint(Predicate<String> predicate) {
      for (String item : crlDistributionPoints) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingIssuingCertificateURL(Predicate<String> predicate) {
      for (String item : issuingCertificateURLs) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingOcspServer(Predicate<String> predicate) {
      for (String item : ocspServers) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasOcspServers() {
    return this.ocspServers != null && !(this.ocspServers.isEmpty());
  }
  
  public boolean hasSecretName() {
    return this.secretName != null;
  }
  
  public int hashCode() {
    return Objects.hash(crlDistributionPoints, issuingCertificateURLs, ocspServers, secretName, additionalProperties);
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
  
  public A removeAllFromIssuingCertificateURLs(Collection<String> items) {
    if (this.issuingCertificateURLs == null) {
      return (A) this;
    }
    for (String item : items) {
      this.issuingCertificateURLs.remove(item);
    }
    return (A) this;
  }
  
  public A removeAllFromOcspServers(Collection<String> items) {
    if (this.ocspServers == null) {
      return (A) this;
    }
    for (String item : items) {
      this.ocspServers.remove(item);
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
  
  public A removeFromIssuingCertificateURLs(String... items) {
    if (this.issuingCertificateURLs == null) {
      return (A) this;
    }
    for (String item : items) {
      this.issuingCertificateURLs.remove(item);
    }
    return (A) this;
  }
  
  public A removeFromOcspServers(String... items) {
    if (this.ocspServers == null) {
      return (A) this;
    }
    for (String item : items) {
      this.ocspServers.remove(item);
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
  
  public A setToIssuingCertificateURLs(int index,String item) {
    if (this.issuingCertificateURLs == null) {
      this.issuingCertificateURLs = new ArrayList();
    }
    this.issuingCertificateURLs.set(index, item);
    return (A) this;
  }
  
  public A setToOcspServers(int index,String item) {
    if (this.ocspServers == null) {
      this.ocspServers = new ArrayList();
    }
    this.ocspServers.set(index, item);
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
    if (!(issuingCertificateURLs == null) && !(issuingCertificateURLs.isEmpty())) {
        sb.append("issuingCertificateURLs:");
        sb.append(issuingCertificateURLs);
        sb.append(",");
    }
    if (!(ocspServers == null) && !(ocspServers.isEmpty())) {
        sb.append("ocspServers:");
        sb.append(ocspServers);
        sb.append(",");
    }
    if (!(secretName == null)) {
        sb.append("secretName:");
        sb.append(secretName);
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
  
  public A withIssuingCertificateURLs(List<String> issuingCertificateURLs) {
    if (issuingCertificateURLs != null) {
        this.issuingCertificateURLs = new ArrayList();
        for (String item : issuingCertificateURLs) {
          this.addToIssuingCertificateURLs(item);
        }
    } else {
      this.issuingCertificateURLs = null;
    }
    return (A) this;
  }
  
  public A withIssuingCertificateURLs(String... issuingCertificateURLs) {
    if (this.issuingCertificateURLs != null) {
        this.issuingCertificateURLs.clear();
        _visitables.remove("issuingCertificateURLs");
    }
    if (issuingCertificateURLs != null) {
      for (String item : issuingCertificateURLs) {
        this.addToIssuingCertificateURLs(item);
      }
    }
    return (A) this;
  }
  
  public A withOcspServers(List<String> ocspServers) {
    if (ocspServers != null) {
        this.ocspServers = new ArrayList();
        for (String item : ocspServers) {
          this.addToOcspServers(item);
        }
    } else {
      this.ocspServers = null;
    }
    return (A) this;
  }
  
  public A withOcspServers(String... ocspServers) {
    if (this.ocspServers != null) {
        this.ocspServers.clear();
        _visitables.remove("ocspServers");
    }
    if (ocspServers != null) {
      for (String item : ocspServers) {
        this.addToOcspServers(item);
      }
    }
    return (A) this;
  }
  
  public A withSecretName(String secretName) {
    this.secretName = secretName;
    return (A) this;
  }
  
}