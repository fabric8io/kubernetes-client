package io.fabric8.certmanager.api.model.v1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import java.lang.Integer;
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
public class CertificateStatusFluent<A extends io.fabric8.certmanager.api.model.v1.CertificateStatusFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private ArrayList<CertificateConditionBuilder> conditions = new ArrayList<CertificateConditionBuilder>();
  private Integer failedIssuanceAttempts;
  private String lastFailureTime;
  private String nextPrivateKeySecretName;
  private String notAfter;
  private String notBefore;
  private String renewalTime;
  private Integer revision;

  public CertificateStatusFluent() {
  }
  
  public CertificateStatusFluent(CertificateStatus instance) {
    this.copyInstance(instance);
  }

  public A addAllToConditions(Collection<CertificateCondition> items) {
    if (this.conditions == null) {
      this.conditions = new ArrayList();
    }
    for (CertificateCondition item : items) {
        CertificateConditionBuilder builder = new CertificateConditionBuilder(item);
        _visitables.get("conditions").add(builder);
        this.conditions.add(builder);
    }
    return (A) this;
  }
  
  public ConditionsNested<A> addNewCondition() {
    return new ConditionsNested(-1, null);
  }
  
  public ConditionsNested<A> addNewConditionLike(CertificateCondition item) {
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
  
  public A addToConditions(CertificateCondition... items) {
    if (this.conditions == null) {
      this.conditions = new ArrayList();
    }
    for (CertificateCondition item : items) {
        CertificateConditionBuilder builder = new CertificateConditionBuilder(item);
        _visitables.get("conditions").add(builder);
        this.conditions.add(builder);
    }
    return (A) this;
  }
  
  public A addToConditions(int index,CertificateCondition item) {
    if (this.conditions == null) {
      this.conditions = new ArrayList();
    }
    CertificateConditionBuilder builder = new CertificateConditionBuilder(item);
    if (index < 0 || index >= conditions.size()) {
        _visitables.get("conditions").add(builder);
        conditions.add(builder);
    } else {
        _visitables.get("conditions").add(builder);
        conditions.add(index, builder);
    }
    return (A) this;
  }
  
  public CertificateCondition buildCondition(int index) {
    return this.conditions.get(index).build();
  }
  
  public List<CertificateCondition> buildConditions() {
    return this.conditions != null ? build(conditions) : null;
  }
  
  public CertificateCondition buildFirstCondition() {
    return this.conditions.get(0).build();
  }
  
  public CertificateCondition buildLastCondition() {
    return this.conditions.get(conditions.size() - 1).build();
  }
  
  public CertificateCondition buildMatchingCondition(Predicate<CertificateConditionBuilder> predicate) {
      for (CertificateConditionBuilder item : conditions) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  protected void copyInstance(CertificateStatus instance) {
    instance = instance != null ? instance : new CertificateStatus();
    if (instance != null) {
        this.withConditions(instance.getConditions());
        this.withFailedIssuanceAttempts(instance.getFailedIssuanceAttempts());
        this.withLastFailureTime(instance.getLastFailureTime());
        this.withNextPrivateKeySecretName(instance.getNextPrivateKeySecretName());
        this.withNotAfter(instance.getNotAfter());
        this.withNotBefore(instance.getNotBefore());
        this.withRenewalTime(instance.getRenewalTime());
        this.withRevision(instance.getRevision());
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
  
  public ConditionsNested<A> editMatchingCondition(Predicate<CertificateConditionBuilder> predicate) {
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
    CertificateStatusFluent that = (CertificateStatusFluent) o;
    if (!(Objects.equals(conditions, that.conditions))) {
      return false;
    }
    if (!(Objects.equals(failedIssuanceAttempts, that.failedIssuanceAttempts))) {
      return false;
    }
    if (!(Objects.equals(lastFailureTime, that.lastFailureTime))) {
      return false;
    }
    if (!(Objects.equals(nextPrivateKeySecretName, that.nextPrivateKeySecretName))) {
      return false;
    }
    if (!(Objects.equals(notAfter, that.notAfter))) {
      return false;
    }
    if (!(Objects.equals(notBefore, that.notBefore))) {
      return false;
    }
    if (!(Objects.equals(renewalTime, that.renewalTime))) {
      return false;
    }
    if (!(Objects.equals(revision, that.revision))) {
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
  
  public Integer getFailedIssuanceAttempts() {
    return this.failedIssuanceAttempts;
  }
  
  public String getLastFailureTime() {
    return this.lastFailureTime;
  }
  
  public String getNextPrivateKeySecretName() {
    return this.nextPrivateKeySecretName;
  }
  
  public String getNotAfter() {
    return this.notAfter;
  }
  
  public String getNotBefore() {
    return this.notBefore;
  }
  
  public String getRenewalTime() {
    return this.renewalTime;
  }
  
  public Integer getRevision() {
    return this.revision;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasConditions() {
    return this.conditions != null && !(this.conditions.isEmpty());
  }
  
  public boolean hasFailedIssuanceAttempts() {
    return this.failedIssuanceAttempts != null;
  }
  
  public boolean hasLastFailureTime() {
    return this.lastFailureTime != null;
  }
  
  public boolean hasMatchingCondition(Predicate<CertificateConditionBuilder> predicate) {
      for (CertificateConditionBuilder item : conditions) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasNextPrivateKeySecretName() {
    return this.nextPrivateKeySecretName != null;
  }
  
  public boolean hasNotAfter() {
    return this.notAfter != null;
  }
  
  public boolean hasNotBefore() {
    return this.notBefore != null;
  }
  
  public boolean hasRenewalTime() {
    return this.renewalTime != null;
  }
  
  public boolean hasRevision() {
    return this.revision != null;
  }
  
  public int hashCode() {
    return Objects.hash(conditions, failedIssuanceAttempts, lastFailureTime, nextPrivateKeySecretName, notAfter, notBefore, renewalTime, revision, additionalProperties);
  }
  
  public A removeAllFromConditions(Collection<CertificateCondition> items) {
    if (this.conditions == null) {
      return (A) this;
    }
    for (CertificateCondition item : items) {
        CertificateConditionBuilder builder = new CertificateConditionBuilder(item);
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
  
  public A removeFromConditions(CertificateCondition... items) {
    if (this.conditions == null) {
      return (A) this;
    }
    for (CertificateCondition item : items) {
        CertificateConditionBuilder builder = new CertificateConditionBuilder(item);
        _visitables.get("conditions").remove(builder);
        this.conditions.remove(builder);
    }
    return (A) this;
  }
  
  public A removeMatchingFromConditions(Predicate<CertificateConditionBuilder> predicate) {
    if (conditions == null) {
      return (A) this;
    }
    Iterator<CertificateConditionBuilder> each = conditions.iterator();
    List visitables = _visitables.get("conditions");
    while (each.hasNext()) {
        CertificateConditionBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public ConditionsNested<A> setNewConditionLike(int index,CertificateCondition item) {
    return new ConditionsNested(index, item);
  }
  
  public A setToConditions(int index,CertificateCondition item) {
    if (this.conditions == null) {
      this.conditions = new ArrayList();
    }
    CertificateConditionBuilder builder = new CertificateConditionBuilder(item);
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
    if (!(conditions == null) && !(conditions.isEmpty())) {
        sb.append("conditions:");
        sb.append(conditions);
        sb.append(",");
    }
    if (!(failedIssuanceAttempts == null)) {
        sb.append("failedIssuanceAttempts:");
        sb.append(failedIssuanceAttempts);
        sb.append(",");
    }
    if (!(lastFailureTime == null)) {
        sb.append("lastFailureTime:");
        sb.append(lastFailureTime);
        sb.append(",");
    }
    if (!(nextPrivateKeySecretName == null)) {
        sb.append("nextPrivateKeySecretName:");
        sb.append(nextPrivateKeySecretName);
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
    if (!(renewalTime == null)) {
        sb.append("renewalTime:");
        sb.append(renewalTime);
        sb.append(",");
    }
    if (!(revision == null)) {
        sb.append("revision:");
        sb.append(revision);
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
  
  public A withConditions(List<CertificateCondition> conditions) {
    if (this.conditions != null) {
      this._visitables.get("conditions").clear();
    }
    if (conditions != null) {
        this.conditions = new ArrayList();
        for (CertificateCondition item : conditions) {
          this.addToConditions(item);
        }
    } else {
      this.conditions = null;
    }
    return (A) this;
  }
  
  public A withConditions(CertificateCondition... conditions) {
    if (this.conditions != null) {
        this.conditions.clear();
        _visitables.remove("conditions");
    }
    if (conditions != null) {
      for (CertificateCondition item : conditions) {
        this.addToConditions(item);
      }
    }
    return (A) this;
  }
  
  public A withFailedIssuanceAttempts(Integer failedIssuanceAttempts) {
    this.failedIssuanceAttempts = failedIssuanceAttempts;
    return (A) this;
  }
  
  public A withLastFailureTime(String lastFailureTime) {
    this.lastFailureTime = lastFailureTime;
    return (A) this;
  }
  
  public A withNextPrivateKeySecretName(String nextPrivateKeySecretName) {
    this.nextPrivateKeySecretName = nextPrivateKeySecretName;
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
  
  public A withRenewalTime(String renewalTime) {
    this.renewalTime = renewalTime;
    return (A) this;
  }
  
  public A withRevision(Integer revision) {
    this.revision = revision;
    return (A) this;
  }
  public class ConditionsNested<N> extends CertificateConditionFluent<ConditionsNested<N>> implements Nested<N>{
  
    CertificateConditionBuilder builder;
    int index;
  
    ConditionsNested(int index,CertificateCondition item) {
      this.index = index;
      this.builder = new CertificateConditionBuilder(this, item);
    }
  
    public N and() {
      return (N) CertificateStatusFluent.this.setToConditions(index, builder.build());
    }
    
    public N endCondition() {
      return and();
    }
    
  }
}