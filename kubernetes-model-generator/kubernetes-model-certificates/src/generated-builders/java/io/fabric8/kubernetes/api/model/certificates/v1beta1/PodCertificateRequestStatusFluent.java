package io.fabric8.kubernetes.api.model.certificates.v1beta1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.model.Condition;
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
public class PodCertificateRequestStatusFluent<A extends io.fabric8.kubernetes.api.model.certificates.v1beta1.PodCertificateRequestStatusFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String beginRefreshAt;
  private String certificateChain;
  private List<Condition> conditions = new ArrayList<Condition>();
  private String notAfter;
  private String notBefore;

  public PodCertificateRequestStatusFluent() {
  }
  
  public PodCertificateRequestStatusFluent(PodCertificateRequestStatus instance) {
    this.copyInstance(instance);
  }

  public A addAllToConditions(Collection<Condition> items) {
    if (this.conditions == null) {
      this.conditions = new ArrayList();
    }
    for (Condition item : items) {
      this.conditions.add(item);
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
  
  public A addToConditions(Condition... items) {
    if (this.conditions == null) {
      this.conditions = new ArrayList();
    }
    for (Condition item : items) {
      this.conditions.add(item);
    }
    return (A) this;
  }
  
  public A addToConditions(int index,Condition item) {
    if (this.conditions == null) {
      this.conditions = new ArrayList();
    }
    this.conditions.add(index, item);
    return (A) this;
  }
  
  protected void copyInstance(PodCertificateRequestStatus instance) {
    instance = instance != null ? instance : new PodCertificateRequestStatus();
    if (instance != null) {
        this.withBeginRefreshAt(instance.getBeginRefreshAt());
        this.withCertificateChain(instance.getCertificateChain());
        this.withConditions(instance.getConditions());
        this.withNotAfter(instance.getNotAfter());
        this.withNotBefore(instance.getNotBefore());
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
    PodCertificateRequestStatusFluent that = (PodCertificateRequestStatusFluent) o;
    if (!(Objects.equals(beginRefreshAt, that.beginRefreshAt))) {
      return false;
    }
    if (!(Objects.equals(certificateChain, that.certificateChain))) {
      return false;
    }
    if (!(Objects.equals(conditions, that.conditions))) {
      return false;
    }
    if (!(Objects.equals(notAfter, that.notAfter))) {
      return false;
    }
    if (!(Objects.equals(notBefore, that.notBefore))) {
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
  
  public String getBeginRefreshAt() {
    return this.beginRefreshAt;
  }
  
  public String getCertificateChain() {
    return this.certificateChain;
  }
  
  public Condition getCondition(int index) {
    return this.conditions.get(index);
  }
  
  public List<Condition> getConditions() {
    return this.conditions;
  }
  
  public Condition getFirstCondition() {
    return this.conditions.get(0);
  }
  
  public Condition getLastCondition() {
    return this.conditions.get(conditions.size() - 1);
  }
  
  public Condition getMatchingCondition(Predicate<Condition> predicate) {
      for (Condition item : conditions) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public String getNotAfter() {
    return this.notAfter;
  }
  
  public String getNotBefore() {
    return this.notBefore;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasBeginRefreshAt() {
    return this.beginRefreshAt != null;
  }
  
  public boolean hasCertificateChain() {
    return this.certificateChain != null;
  }
  
  public boolean hasConditions() {
    return this.conditions != null && !(this.conditions.isEmpty());
  }
  
  public boolean hasMatchingCondition(Predicate<Condition> predicate) {
      for (Condition item : conditions) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasNotAfter() {
    return this.notAfter != null;
  }
  
  public boolean hasNotBefore() {
    return this.notBefore != null;
  }
  
  public int hashCode() {
    return Objects.hash(beginRefreshAt, certificateChain, conditions, notAfter, notBefore, additionalProperties);
  }
  
  public A removeAllFromConditions(Collection<Condition> items) {
    if (this.conditions == null) {
      return (A) this;
    }
    for (Condition item : items) {
      this.conditions.remove(item);
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
  
  public A removeFromConditions(Condition... items) {
    if (this.conditions == null) {
      return (A) this;
    }
    for (Condition item : items) {
      this.conditions.remove(item);
    }
    return (A) this;
  }
  
  public A setToConditions(int index,Condition item) {
    if (this.conditions == null) {
      this.conditions = new ArrayList();
    }
    this.conditions.set(index, item);
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(beginRefreshAt == null)) {
        sb.append("beginRefreshAt:");
        sb.append(beginRefreshAt);
        sb.append(",");
    }
    if (!(certificateChain == null)) {
        sb.append("certificateChain:");
        sb.append(certificateChain);
        sb.append(",");
    }
    if (!(conditions == null) && !(conditions.isEmpty())) {
        sb.append("conditions:");
        sb.append(conditions);
        sb.append(",");
    }
    if (!(notAfter == null)) {
        sb.append("notAfter:");
        sb.append(notAfter);
        sb.append(",");
    }
    if (!(notBefore == null)) {
        sb.append("notBefore:");
        sb.append(notBefore);
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
  
  public A withBeginRefreshAt(String beginRefreshAt) {
    this.beginRefreshAt = beginRefreshAt;
    return (A) this;
  }
  
  public A withCertificateChain(String certificateChain) {
    this.certificateChain = certificateChain;
    return (A) this;
  }
  
  public A withConditions(List<Condition> conditions) {
    if (conditions != null) {
        this.conditions = new ArrayList();
        for (Condition item : conditions) {
          this.addToConditions(item);
        }
    } else {
      this.conditions = null;
    }
    return (A) this;
  }
  
  public A withConditions(Condition... conditions) {
    if (this.conditions != null) {
        this.conditions.clear();
        _visitables.remove("conditions");
    }
    if (conditions != null) {
      for (Condition item : conditions) {
        this.addToConditions(item);
      }
    }
    return (A) this;
  }
  
  public A withNotAfter(String notAfter) {
    this.notAfter = notAfter;
    return (A) this;
  }
  
  public A withNotBefore(String notBefore) {
    this.notBefore = notBefore;
    return (A) this;
  }
  
}