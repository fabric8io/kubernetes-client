package io.fabric8.openshift.api.model.miscellaneous.metal3.v1beta1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import io.fabric8.kubernetes.api.model.clusterapi.core.v1beta1.Condition;
import io.fabric8.kubernetes.api.model.clusterapi.core.v1beta1.FailureDomainSpec;
import java.lang.Boolean;
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
import java.util.Optional;
import java.util.function.Predicate;

/**
 * Generated
 */
@SuppressWarnings("unchecked")
public class Metal3ClusterStatusFluent<A extends io.fabric8.openshift.api.model.miscellaneous.metal3.v1beta1.Metal3ClusterStatusFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private List<Condition> conditions = new ArrayList<Condition>();
  private Map<String,FailureDomainSpec> failureDomains;
  private String failureMessage;
  private String failureReason;
  private String lastUpdated;
  private Boolean ready;
  private Metal3ClusterV1Beta2StatusBuilder v1beta2;

  public Metal3ClusterStatusFluent() {
  }
  
  public Metal3ClusterStatusFluent(Metal3ClusterStatus instance) {
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
  
  public A addToFailureDomains(Map<String,FailureDomainSpec> map) {
    if (this.failureDomains == null && map != null) {
      this.failureDomains = new LinkedHashMap();
    }
    if (map != null) {
      this.failureDomains.putAll(map);
    }
    return (A) this;
  }
  
  public A addToFailureDomains(String key,FailureDomainSpec value) {
    if (this.failureDomains == null && key != null && value != null) {
      this.failureDomains = new LinkedHashMap();
    }
    if (key != null && value != null) {
      this.failureDomains.put(key, value);
    }
    return (A) this;
  }
  
  public Metal3ClusterV1Beta2Status buildV1beta2() {
    return this.v1beta2 != null ? this.v1beta2.build() : null;
  }
  
  protected void copyInstance(Metal3ClusterStatus instance) {
    instance = instance != null ? instance : new Metal3ClusterStatus();
    if (instance != null) {
        this.withConditions(instance.getConditions());
        this.withFailureDomains(instance.getFailureDomains());
        this.withFailureMessage(instance.getFailureMessage());
        this.withFailureReason(instance.getFailureReason());
        this.withLastUpdated(instance.getLastUpdated());
        this.withReady(instance.getReady());
        this.withV1beta2(instance.getV1beta2());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public V1beta2Nested<A> editOrNewV1beta2() {
    return this.withNewV1beta2Like(Optional.ofNullable(this.buildV1beta2()).orElse(new Metal3ClusterV1Beta2StatusBuilder().build()));
  }
  
  public V1beta2Nested<A> editOrNewV1beta2Like(Metal3ClusterV1Beta2Status item) {
    return this.withNewV1beta2Like(Optional.ofNullable(this.buildV1beta2()).orElse(item));
  }
  
  public V1beta2Nested<A> editV1beta2() {
    return this.withNewV1beta2Like(Optional.ofNullable(this.buildV1beta2()).orElse(null));
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
    Metal3ClusterStatusFluent that = (Metal3ClusterStatusFluent) o;
    if (!(Objects.equals(conditions, that.conditions))) {
      return false;
    }
    if (!(Objects.equals(failureDomains, that.failureDomains))) {
      return false;
    }
    if (!(Objects.equals(failureMessage, that.failureMessage))) {
      return false;
    }
    if (!(Objects.equals(failureReason, that.failureReason))) {
      return false;
    }
    if (!(Objects.equals(lastUpdated, that.lastUpdated))) {
      return false;
    }
    if (!(Objects.equals(ready, that.ready))) {
      return false;
    }
    if (!(Objects.equals(v1beta2, that.v1beta2))) {
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
  
  public Condition getCondition(int index) {
    return this.conditions.get(index);
  }
  
  public List<Condition> getConditions() {
    return this.conditions;
  }
  
  public Map<String,FailureDomainSpec> getFailureDomains() {
    return this.failureDomains;
  }
  
  public String getFailureMessage() {
    return this.failureMessage;
  }
  
  public String getFailureReason() {
    return this.failureReason;
  }
  
  public Condition getFirstCondition() {
    return this.conditions.get(0);
  }
  
  public Condition getLastCondition() {
    return this.conditions.get(conditions.size() - 1);
  }
  
  public String getLastUpdated() {
    return this.lastUpdated;
  }
  
  public Condition getMatchingCondition(Predicate<Condition> predicate) {
      for (Condition item : conditions) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public Boolean getReady() {
    return this.ready;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasConditions() {
    return this.conditions != null && !(this.conditions.isEmpty());
  }
  
  public boolean hasFailureDomains() {
    return this.failureDomains != null;
  }
  
  public boolean hasFailureMessage() {
    return this.failureMessage != null;
  }
  
  public boolean hasFailureReason() {
    return this.failureReason != null;
  }
  
  public boolean hasLastUpdated() {
    return this.lastUpdated != null;
  }
  
  public boolean hasMatchingCondition(Predicate<Condition> predicate) {
      for (Condition item : conditions) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasReady() {
    return this.ready != null;
  }
  
  public boolean hasV1beta2() {
    return this.v1beta2 != null;
  }
  
  public int hashCode() {
    return Objects.hash(conditions, failureDomains, failureMessage, failureReason, lastUpdated, ready, v1beta2, additionalProperties);
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
  
  public A removeFromFailureDomains(String key) {
    if (this.failureDomains == null) {
      return (A) this;
    }
    if (key != null && this.failureDomains != null) {
      this.failureDomains.remove(key);
    }
    return (A) this;
  }
  
  public A removeFromFailureDomains(Map<String,FailureDomainSpec> map) {
    if (this.failureDomains == null) {
      return (A) this;
    }
    if (map != null) {
      for (Object key : map.keySet()) {
        if (this.failureDomains != null) {
          this.failureDomains.remove(key);
        }
      }
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
    if (!(conditions == null) && !(conditions.isEmpty())) {
        sb.append("conditions:");
        sb.append(conditions);
        sb.append(",");
    }
    if (!(failureDomains == null) && !(failureDomains.isEmpty())) {
        sb.append("failureDomains:");
        sb.append(failureDomains);
        sb.append(",");
    }
    if (!(failureMessage == null)) {
        sb.append("failureMessage:");
        sb.append(failureMessage);
        sb.append(",");
    }
    if (!(failureReason == null)) {
        sb.append("failureReason:");
        sb.append(failureReason);
        sb.append(",");
    }
    if (!(lastUpdated == null)) {
        sb.append("lastUpdated:");
        sb.append(lastUpdated);
        sb.append(",");
    }
    if (!(ready == null)) {
        sb.append("ready:");
        sb.append(ready);
        sb.append(",");
    }
    if (!(v1beta2 == null)) {
        sb.append("v1beta2:");
        sb.append(v1beta2);
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
  
  public <K,V>A withFailureDomains(Map<String,FailureDomainSpec> failureDomains) {
    if (failureDomains == null) {
      this.failureDomains = null;
    } else {
      this.failureDomains = new LinkedHashMap(failureDomains);
    }
    return (A) this;
  }
  
  public A withFailureMessage(String failureMessage) {
    this.failureMessage = failureMessage;
    return (A) this;
  }
  
  public A withFailureReason(String failureReason) {
    this.failureReason = failureReason;
    return (A) this;
  }
  
  public A withLastUpdated(String lastUpdated) {
    this.lastUpdated = lastUpdated;
    return (A) this;
  }
  
  public V1beta2Nested<A> withNewV1beta2() {
    return new V1beta2Nested(null);
  }
  
  public V1beta2Nested<A> withNewV1beta2Like(Metal3ClusterV1Beta2Status item) {
    return new V1beta2Nested(item);
  }
  
  public A withReady() {
    return withReady(true);
  }
  
  public A withReady(Boolean ready) {
    this.ready = ready;
    return (A) this;
  }
  
  public A withV1beta2(Metal3ClusterV1Beta2Status v1beta2) {
    this._visitables.remove("v1beta2");
    if (v1beta2 != null) {
        this.v1beta2 = new Metal3ClusterV1Beta2StatusBuilder(v1beta2);
        this._visitables.get("v1beta2").add(this.v1beta2);
    } else {
        this.v1beta2 = null;
        this._visitables.get("v1beta2").remove(this.v1beta2);
    }
    return (A) this;
  }
  public class V1beta2Nested<N> extends Metal3ClusterV1Beta2StatusFluent<V1beta2Nested<N>> implements Nested<N>{
  
    Metal3ClusterV1Beta2StatusBuilder builder;
  
    V1beta2Nested(Metal3ClusterV1Beta2Status item) {
      this.builder = new Metal3ClusterV1Beta2StatusBuilder(this, item);
    }
  
    public N and() {
      return (N) Metal3ClusterStatusFluent.this.withV1beta2(builder.build());
    }
    
    public N endV1beta2() {
      return and();
    }
    
  }
}