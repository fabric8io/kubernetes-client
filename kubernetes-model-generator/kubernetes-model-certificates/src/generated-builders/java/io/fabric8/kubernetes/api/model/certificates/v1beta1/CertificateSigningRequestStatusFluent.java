package io.fabric8.kubernetes.api.model.certificates.v1beta1;

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
public class CertificateSigningRequestStatusFluent<A extends io.fabric8.kubernetes.api.model.certificates.v1beta1.CertificateSigningRequestStatusFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String certificate;
  private ArrayList<CertificateSigningRequestConditionBuilder> conditions = new ArrayList<CertificateSigningRequestConditionBuilder>();

  public CertificateSigningRequestStatusFluent() {
  }
  
  public CertificateSigningRequestStatusFluent(CertificateSigningRequestStatus instance) {
    this.copyInstance(instance);
  }

  public A addAllToConditions(Collection<CertificateSigningRequestCondition> items) {
    if (this.conditions == null) {
      this.conditions = new ArrayList();
    }
    for (CertificateSigningRequestCondition item : items) {
        CertificateSigningRequestConditionBuilder builder = new CertificateSigningRequestConditionBuilder(item);
        _visitables.get("conditions").add(builder);
        this.conditions.add(builder);
    }
    return (A) this;
  }
  
  public ConditionsNested<A> addNewCondition() {
    return new ConditionsNested(-1, null);
  }
  
  public ConditionsNested<A> addNewConditionLike(CertificateSigningRequestCondition item) {
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
  
  public A addToConditions(CertificateSigningRequestCondition... items) {
    if (this.conditions == null) {
      this.conditions = new ArrayList();
    }
    for (CertificateSigningRequestCondition item : items) {
        CertificateSigningRequestConditionBuilder builder = new CertificateSigningRequestConditionBuilder(item);
        _visitables.get("conditions").add(builder);
        this.conditions.add(builder);
    }
    return (A) this;
  }
  
  public A addToConditions(int index,CertificateSigningRequestCondition item) {
    if (this.conditions == null) {
      this.conditions = new ArrayList();
    }
    CertificateSigningRequestConditionBuilder builder = new CertificateSigningRequestConditionBuilder(item);
    if (index < 0 || index >= conditions.size()) {
        _visitables.get("conditions").add(builder);
        conditions.add(builder);
    } else {
        _visitables.get("conditions").add(builder);
        conditions.add(index, builder);
    }
    return (A) this;
  }
  
  public CertificateSigningRequestCondition buildCondition(int index) {
    return this.conditions.get(index).build();
  }
  
  public List<CertificateSigningRequestCondition> buildConditions() {
    return this.conditions != null ? build(conditions) : null;
  }
  
  public CertificateSigningRequestCondition buildFirstCondition() {
    return this.conditions.get(0).build();
  }
  
  public CertificateSigningRequestCondition buildLastCondition() {
    return this.conditions.get(conditions.size() - 1).build();
  }
  
  public CertificateSigningRequestCondition buildMatchingCondition(Predicate<CertificateSigningRequestConditionBuilder> predicate) {
      for (CertificateSigningRequestConditionBuilder item : conditions) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  protected void copyInstance(CertificateSigningRequestStatus instance) {
    instance = instance != null ? instance : new CertificateSigningRequestStatus();
    if (instance != null) {
        this.withCertificate(instance.getCertificate());
        this.withConditions(instance.getConditions());
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
  
  public ConditionsNested<A> editMatchingCondition(Predicate<CertificateSigningRequestConditionBuilder> predicate) {
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
    CertificateSigningRequestStatusFluent that = (CertificateSigningRequestStatusFluent) o;
    if (!(Objects.equals(certificate, that.certificate))) {
      return false;
    }
    if (!(Objects.equals(conditions, that.conditions))) {
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
  
  public String getCertificate() {
    return this.certificate;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasCertificate() {
    return this.certificate != null;
  }
  
  public boolean hasConditions() {
    return this.conditions != null && !(this.conditions.isEmpty());
  }
  
  public boolean hasMatchingCondition(Predicate<CertificateSigningRequestConditionBuilder> predicate) {
      for (CertificateSigningRequestConditionBuilder item : conditions) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public int hashCode() {
    return Objects.hash(certificate, conditions, additionalProperties);
  }
  
  public A removeAllFromConditions(Collection<CertificateSigningRequestCondition> items) {
    if (this.conditions == null) {
      return (A) this;
    }
    for (CertificateSigningRequestCondition item : items) {
        CertificateSigningRequestConditionBuilder builder = new CertificateSigningRequestConditionBuilder(item);
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
  
  public A removeFromConditions(CertificateSigningRequestCondition... items) {
    if (this.conditions == null) {
      return (A) this;
    }
    for (CertificateSigningRequestCondition item : items) {
        CertificateSigningRequestConditionBuilder builder = new CertificateSigningRequestConditionBuilder(item);
        _visitables.get("conditions").remove(builder);
        this.conditions.remove(builder);
    }
    return (A) this;
  }
  
  public A removeMatchingFromConditions(Predicate<CertificateSigningRequestConditionBuilder> predicate) {
    if (conditions == null) {
      return (A) this;
    }
    Iterator<CertificateSigningRequestConditionBuilder> each = conditions.iterator();
    List visitables = _visitables.get("conditions");
    while (each.hasNext()) {
        CertificateSigningRequestConditionBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public ConditionsNested<A> setNewConditionLike(int index,CertificateSigningRequestCondition item) {
    return new ConditionsNested(index, item);
  }
  
  public A setToConditions(int index,CertificateSigningRequestCondition item) {
    if (this.conditions == null) {
      this.conditions = new ArrayList();
    }
    CertificateSigningRequestConditionBuilder builder = new CertificateSigningRequestConditionBuilder(item);
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
  
  public A withCertificate(String certificate) {
    this.certificate = certificate;
    return (A) this;
  }
  
  public A withConditions(List<CertificateSigningRequestCondition> conditions) {
    if (this.conditions != null) {
      this._visitables.get("conditions").clear();
    }
    if (conditions != null) {
        this.conditions = new ArrayList();
        for (CertificateSigningRequestCondition item : conditions) {
          this.addToConditions(item);
        }
    } else {
      this.conditions = null;
    }
    return (A) this;
  }
  
  public A withConditions(CertificateSigningRequestCondition... conditions) {
    if (this.conditions != null) {
        this.conditions.clear();
        _visitables.remove("conditions");
    }
    if (conditions != null) {
      for (CertificateSigningRequestCondition item : conditions) {
        this.addToConditions(item);
      }
    }
    return (A) this;
  }
  public class ConditionsNested<N> extends CertificateSigningRequestConditionFluent<ConditionsNested<N>> implements Nested<N>{
  
    CertificateSigningRequestConditionBuilder builder;
    int index;
  
    ConditionsNested(int index,CertificateSigningRequestCondition item) {
      this.index = index;
      this.builder = new CertificateSigningRequestConditionBuilder(this, item);
    }
  
    public N and() {
      return (N) CertificateSigningRequestStatusFluent.this.setToConditions(index, builder.build());
    }
    
    public N endCondition() {
      return and();
    }
    
  }
}