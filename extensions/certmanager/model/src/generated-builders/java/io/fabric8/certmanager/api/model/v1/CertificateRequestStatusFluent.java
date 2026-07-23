package io.fabric8.certmanager.api.model.v1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import java.lang.Object;
import java.lang.RuntimeException;
import java.lang.String;
import java.lang.StringBuilder;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Predicate;

/**
 * Generated
 */
@SuppressWarnings("unchecked")
public class CertificateRequestStatusFluent<A extends io.fabric8.certmanager.api.model.v1.CertificateRequestStatusFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String ca;
  private String certificate;
  private ArrayList<CertificateRequestConditionBuilder> conditions = new ArrayList<CertificateRequestConditionBuilder>();
  private String failureTime;

  public CertificateRequestStatusFluent() {
  }
  
  public CertificateRequestStatusFluent(CertificateRequestStatus instance) {
    this.copyInstance(instance);
  }

  public A addAllToConditions(Collection<CertificateRequestCondition> items) {
    if (this.conditions == null) {
      this.conditions = new ArrayList();
    }
    for (CertificateRequestCondition item : items) {
        CertificateRequestConditionBuilder builder = new CertificateRequestConditionBuilder(item);
        _visitables.get("conditions").add(builder);
        this.conditions.add(builder);
    }
    return (A) this;
  }
  
  public ConditionsNested<A> addNewCondition() {
    return new ConditionsNested(-1, null);
  }
  
  public A addNewCondition(String lastTransitionTime,String message,String reason,String status,String type) {
    return (A) this.addToConditions(new CertificateRequestCondition(lastTransitionTime, message, reason, status, type));
  }
  
  public ConditionsNested<A> addNewConditionLike(CertificateRequestCondition item) {
    return new ConditionsNested(-1, item);
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
  
  public A addToConditions(CertificateRequestCondition... items) {
    if (this.conditions == null) {
      this.conditions = new ArrayList();
    }
    for (CertificateRequestCondition item : items) {
        CertificateRequestConditionBuilder builder = new CertificateRequestConditionBuilder(item);
        _visitables.get("conditions").add(builder);
        this.conditions.add(builder);
    }
    return (A) this;
  }
  
  public A addToConditions(int index,CertificateRequestCondition item) {
    if (this.conditions == null) {
      this.conditions = new ArrayList();
    }
    CertificateRequestConditionBuilder builder = new CertificateRequestConditionBuilder(item);
    if (index < 0 || index >= conditions.size()) {
        _visitables.get("conditions").add(builder);
        conditions.add(builder);
    } else {
        _visitables.get("conditions").add(builder);
        conditions.add(index, builder);
    }
    return (A) this;
  }
  
  public CertificateRequestCondition buildCondition(int index) {
    return this.conditions.get(index).build();
  }
  
  public List<CertificateRequestCondition> buildConditions() {
    return this.conditions != null ? build(conditions) : null;
  }
  
  public CertificateRequestCondition buildFirstCondition() {
    return this.conditions.get(0).build();
  }
  
  public CertificateRequestCondition buildLastCondition() {
    return this.conditions.get(conditions.size() - 1).build();
  }
  
  public CertificateRequestCondition buildMatchingCondition(Predicate<CertificateRequestConditionBuilder> predicate) {
      for (CertificateRequestConditionBuilder item : conditions) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  protected void copyInstance(CertificateRequestStatus instance) {
    instance = instance != null ? instance : new CertificateRequestStatus();
    if (instance != null) {
        this.withCa(instance.getCa());
        this.withCertificate(instance.getCertificate());
        this.withConditions(instance.getConditions());
        this.withFailureTime(instance.getFailureTime());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public ConditionsNested<A> editCondition(int index) {
    if (conditions.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "conditions"));
    }
    return this.setNewConditionLike(index, this.buildCondition(index));
  }
  
  public ConditionsNested<A> editFirstCondition() {
    if (conditions.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "conditions"));
    }
    return this.setNewConditionLike(0, this.buildCondition(0));
  }
  
  public ConditionsNested<A> editLastCondition() {
    int index = conditions.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "conditions"));
    }
    return this.setNewConditionLike(index, this.buildCondition(index));
  }
  
  public ConditionsNested<A> editMatchingCondition(Predicate<CertificateRequestConditionBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < conditions.size();i++) {
      if (predicate.test(conditions.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "conditions"));
    }
    return this.setNewConditionLike(index, this.buildCondition(index));
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
    CertificateRequestStatusFluent that = (CertificateRequestStatusFluent) o;
    if (!(Objects.equals(ca, that.ca))) {
      return false;
    }
    if (!(Objects.equals(certificate, that.certificate))) {
      return false;
    }
    if (!(Objects.equals(conditions, that.conditions))) {
      return false;
    }
    if (!(Objects.equals(failureTime, that.failureTime))) {
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
  
  public String getCa() {
    return this.ca;
  }
  
  public String getCertificate() {
    return this.certificate;
  }
  
  public String getFailureTime() {
    return this.failureTime;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasCa() {
    return this.ca != null;
  }
  
  public boolean hasCertificate() {
    return this.certificate != null;
  }
  
  public boolean hasConditions() {
    return this.conditions != null && !(this.conditions.isEmpty());
  }
  
  public boolean hasFailureTime() {
    return this.failureTime != null;
  }
  
  public boolean hasMatchingCondition(Predicate<CertificateRequestConditionBuilder> predicate) {
      for (CertificateRequestConditionBuilder item : conditions) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public int hashCode() {
    return Objects.hash(ca, certificate, conditions, failureTime, additionalProperties);
  }
  
  public A removeAllFromConditions(Collection<CertificateRequestCondition> items) {
    if (this.conditions == null) {
      return (A) this;
    }
    for (CertificateRequestCondition item : items) {
        CertificateRequestConditionBuilder builder = new CertificateRequestConditionBuilder(item);
        _visitables.get("conditions").remove(builder);
        this.conditions.remove(builder);
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
  
  public A removeFromConditions(CertificateRequestCondition... items) {
    if (this.conditions == null) {
      return (A) this;
    }
    for (CertificateRequestCondition item : items) {
        CertificateRequestConditionBuilder builder = new CertificateRequestConditionBuilder(item);
        _visitables.get("conditions").remove(builder);
        this.conditions.remove(builder);
    }
    return (A) this;
  }
  
  public A removeMatchingFromConditions(Predicate<CertificateRequestConditionBuilder> predicate) {
    if (conditions == null) {
      return (A) this;
    }
    Iterator<CertificateRequestConditionBuilder> each = conditions.iterator();
    List visitables = _visitables.get("conditions");
    while (each.hasNext()) {
        CertificateRequestConditionBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public ConditionsNested<A> setNewConditionLike(int index,CertificateRequestCondition item) {
    return new ConditionsNested(index, item);
  }
  
  public A setToConditions(int index,CertificateRequestCondition item) {
    if (this.conditions == null) {
      this.conditions = new ArrayList();
    }
    CertificateRequestConditionBuilder builder = new CertificateRequestConditionBuilder(item);
    if (index < 0 || index >= conditions.size()) {
        _visitables.get("conditions").add(builder);
        conditions.add(builder);
    } else {
        _visitables.get("conditions").add(builder);
        conditions.set(index, builder);
    }
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(ca == null)) {
        sb.append("ca:");
        sb.append(ca);
        sb.append(",");
    }
    if (!(certificate == null)) {
        sb.append("certificate:");
        sb.append(certificate);
        sb.append(",");
    }
    if (!(conditions == null) && !(conditions.isEmpty())) {
        sb.append("conditions:");
        sb.append(conditions);
        sb.append(",");
    }
    if (!(failureTime == null)) {
        sb.append("failureTime:");
        sb.append(failureTime);
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
  
  public A withCa(String ca) {
    this.ca = ca;
    return (A) this;
  }
  
  public A withCertificate(String certificate) {
    this.certificate = certificate;
    return (A) this;
  }
  
  public A withConditions(List<CertificateRequestCondition> conditions) {
    if (this.conditions != null) {
      this._visitables.get("conditions").clear();
    }
    if (conditions != null) {
        this.conditions = new ArrayList();
        for (CertificateRequestCondition item : conditions) {
          this.addToConditions(item);
        }
    } else {
      this.conditions = null;
    }
    return (A) this;
  }
  
  public A withConditions(CertificateRequestCondition... conditions) {
    if (this.conditions != null) {
        this.conditions.clear();
        _visitables.remove("conditions");
    }
    if (conditions != null) {
      for (CertificateRequestCondition item : conditions) {
        this.addToConditions(item);
      }
    }
    return (A) this;
  }
  
  public A withFailureTime(String failureTime) {
    this.failureTime = failureTime;
    return (A) this;
  }
  public class ConditionsNested<N> extends CertificateRequestConditionFluent<ConditionsNested<N>> implements Nested<N>{
  
    CertificateRequestConditionBuilder builder;
    int index;
  
    ConditionsNested(int index,CertificateRequestCondition item) {
      this.index = index;
      this.builder = new CertificateRequestConditionBuilder(this, item);
    }
  
    public N and() {
      return (N) CertificateRequestStatusFluent.this.setToConditions(index, builder.build());
    }
    
    public N endCondition() {
      return and();
    }
    
  }
}