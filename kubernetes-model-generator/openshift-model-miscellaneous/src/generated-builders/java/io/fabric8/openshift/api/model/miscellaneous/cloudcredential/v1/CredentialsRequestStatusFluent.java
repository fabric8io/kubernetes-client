package io.fabric8.openshift.api.model.miscellaneous.cloudcredential.v1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import java.lang.Boolean;
import java.lang.Long;
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
public class CredentialsRequestStatusFluent<A extends io.fabric8.openshift.api.model.miscellaneous.cloudcredential.v1.CredentialsRequestStatusFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private ArrayList<CredentialsRequestConditionBuilder> conditions = new ArrayList<CredentialsRequestConditionBuilder>();
  private String lastSyncCloudCredsSecretResourceVersion;
  private Long lastSyncGeneration;
  private String lastSyncInfrastructureResourceVersion;
  private String lastSyncTimestamp;
  private Object providerStatus;
  private Boolean provisioned;

  public CredentialsRequestStatusFluent() {
  }
  
  public CredentialsRequestStatusFluent(CredentialsRequestStatus instance) {
    this.copyInstance(instance);
  }

  public A addAllToConditions(Collection<CredentialsRequestCondition> items) {
    if (this.conditions == null) {
      this.conditions = new ArrayList();
    }
    for (CredentialsRequestCondition item : items) {
        CredentialsRequestConditionBuilder builder = new CredentialsRequestConditionBuilder(item);
        _visitables.get("conditions").add(builder);
        this.conditions.add(builder);
    }
    return (A) this;
  }
  
  public ConditionsNested<A> addNewCondition() {
    return new ConditionsNested(-1, null);
  }
  
  public ConditionsNested<A> addNewConditionLike(CredentialsRequestCondition item) {
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
  
  public A addToConditions(CredentialsRequestCondition... items) {
    if (this.conditions == null) {
      this.conditions = new ArrayList();
    }
    for (CredentialsRequestCondition item : items) {
        CredentialsRequestConditionBuilder builder = new CredentialsRequestConditionBuilder(item);
        _visitables.get("conditions").add(builder);
        this.conditions.add(builder);
    }
    return (A) this;
  }
  
  public A addToConditions(int index,CredentialsRequestCondition item) {
    if (this.conditions == null) {
      this.conditions = new ArrayList();
    }
    CredentialsRequestConditionBuilder builder = new CredentialsRequestConditionBuilder(item);
    if (index < 0 || index >= conditions.size()) {
        _visitables.get("conditions").add(builder);
        conditions.add(builder);
    } else {
        _visitables.get("conditions").add(builder);
        conditions.add(index, builder);
    }
    return (A) this;
  }
  
  public CredentialsRequestCondition buildCondition(int index) {
    return this.conditions.get(index).build();
  }
  
  public List<CredentialsRequestCondition> buildConditions() {
    return this.conditions != null ? build(conditions) : null;
  }
  
  public CredentialsRequestCondition buildFirstCondition() {
    return this.conditions.get(0).build();
  }
  
  public CredentialsRequestCondition buildLastCondition() {
    return this.conditions.get(conditions.size() - 1).build();
  }
  
  public CredentialsRequestCondition buildMatchingCondition(Predicate<CredentialsRequestConditionBuilder> predicate) {
      for (CredentialsRequestConditionBuilder item : conditions) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  protected void copyInstance(CredentialsRequestStatus instance) {
    instance = instance != null ? instance : new CredentialsRequestStatus();
    if (instance != null) {
        this.withConditions(instance.getConditions());
        this.withLastSyncCloudCredsSecretResourceVersion(instance.getLastSyncCloudCredsSecretResourceVersion());
        this.withLastSyncGeneration(instance.getLastSyncGeneration());
        this.withLastSyncInfrastructureResourceVersion(instance.getLastSyncInfrastructureResourceVersion());
        this.withLastSyncTimestamp(instance.getLastSyncTimestamp());
        this.withProviderStatus(instance.getProviderStatus());
        this.withProvisioned(instance.getProvisioned());
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
  
  public ConditionsNested<A> editMatchingCondition(Predicate<CredentialsRequestConditionBuilder> predicate) {
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
    CredentialsRequestStatusFluent that = (CredentialsRequestStatusFluent) o;
    if (!(Objects.equals(conditions, that.conditions))) {
      return false;
    }
    if (!(Objects.equals(lastSyncCloudCredsSecretResourceVersion, that.lastSyncCloudCredsSecretResourceVersion))) {
      return false;
    }
    if (!(Objects.equals(lastSyncGeneration, that.lastSyncGeneration))) {
      return false;
    }
    if (!(Objects.equals(lastSyncInfrastructureResourceVersion, that.lastSyncInfrastructureResourceVersion))) {
      return false;
    }
    if (!(Objects.equals(lastSyncTimestamp, that.lastSyncTimestamp))) {
      return false;
    }
    if (!(Objects.equals(providerStatus, that.providerStatus))) {
      return false;
    }
    if (!(Objects.equals(provisioned, that.provisioned))) {
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
  
  public String getLastSyncCloudCredsSecretResourceVersion() {
    return this.lastSyncCloudCredsSecretResourceVersion;
  }
  
  public Long getLastSyncGeneration() {
    return this.lastSyncGeneration;
  }
  
  public String getLastSyncInfrastructureResourceVersion() {
    return this.lastSyncInfrastructureResourceVersion;
  }
  
  public String getLastSyncTimestamp() {
    return this.lastSyncTimestamp;
  }
  
  public Object getProviderStatus() {
    return this.providerStatus;
  }
  
  public Boolean getProvisioned() {
    return this.provisioned;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasConditions() {
    return this.conditions != null && !(this.conditions.isEmpty());
  }
  
  public boolean hasLastSyncCloudCredsSecretResourceVersion() {
    return this.lastSyncCloudCredsSecretResourceVersion != null;
  }
  
  public boolean hasLastSyncGeneration() {
    return this.lastSyncGeneration != null;
  }
  
  public boolean hasLastSyncInfrastructureResourceVersion() {
    return this.lastSyncInfrastructureResourceVersion != null;
  }
  
  public boolean hasLastSyncTimestamp() {
    return this.lastSyncTimestamp != null;
  }
  
  public boolean hasMatchingCondition(Predicate<CredentialsRequestConditionBuilder> predicate) {
      for (CredentialsRequestConditionBuilder item : conditions) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasProviderStatus() {
    return this.providerStatus != null;
  }
  
  public boolean hasProvisioned() {
    return this.provisioned != null;
  }
  
  public int hashCode() {
    return Objects.hash(conditions, lastSyncCloudCredsSecretResourceVersion, lastSyncGeneration, lastSyncInfrastructureResourceVersion, lastSyncTimestamp, providerStatus, provisioned, additionalProperties);
  }
  
  public A removeAllFromConditions(Collection<CredentialsRequestCondition> items) {
    if (this.conditions == null) {
      return (A) this;
    }
    for (CredentialsRequestCondition item : items) {
        CredentialsRequestConditionBuilder builder = new CredentialsRequestConditionBuilder(item);
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
  
  public A removeFromConditions(CredentialsRequestCondition... items) {
    if (this.conditions == null) {
      return (A) this;
    }
    for (CredentialsRequestCondition item : items) {
        CredentialsRequestConditionBuilder builder = new CredentialsRequestConditionBuilder(item);
        _visitables.get("conditions").remove(builder);
        this.conditions.remove(builder);
    }
    return (A) this;
  }
  
  public A removeMatchingFromConditions(Predicate<CredentialsRequestConditionBuilder> predicate) {
    if (conditions == null) {
      return (A) this;
    }
    Iterator<CredentialsRequestConditionBuilder> each = conditions.iterator();
    List visitables = _visitables.get("conditions");
    while (each.hasNext()) {
        CredentialsRequestConditionBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public ConditionsNested<A> setNewConditionLike(int index,CredentialsRequestCondition item) {
    return new ConditionsNested(index, item);
  }
  
  public A setToConditions(int index,CredentialsRequestCondition item) {
    if (this.conditions == null) {
      this.conditions = new ArrayList();
    }
    CredentialsRequestConditionBuilder builder = new CredentialsRequestConditionBuilder(item);
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
    if (!(lastSyncCloudCredsSecretResourceVersion == null)) {
        sb.append("lastSyncCloudCredsSecretResourceVersion:");
        sb.append(lastSyncCloudCredsSecretResourceVersion);
        sb.append(",");
    }
    if (!(lastSyncGeneration == null)) {
        sb.append("lastSyncGeneration:");
        sb.append(lastSyncGeneration);
        sb.append(",");
    }
    if (!(lastSyncInfrastructureResourceVersion == null)) {
        sb.append("lastSyncInfrastructureResourceVersion:");
        sb.append(lastSyncInfrastructureResourceVersion);
        sb.append(",");
    }
    if (!(lastSyncTimestamp == null)) {
        sb.append("lastSyncTimestamp:");
        sb.append(lastSyncTimestamp);
        sb.append(",");
    }
    if (!(providerStatus == null)) {
        sb.append("providerStatus:");
        sb.append(providerStatus);
        sb.append(",");
    }
    if (!(provisioned == null)) {
        sb.append("provisioned:");
        sb.append(provisioned);
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
  
  public A withConditions(List<CredentialsRequestCondition> conditions) {
    if (this.conditions != null) {
      this._visitables.get("conditions").clear();
    }
    if (conditions != null) {
        this.conditions = new ArrayList();
        for (CredentialsRequestCondition item : conditions) {
          this.addToConditions(item);
        }
    } else {
      this.conditions = null;
    }
    return (A) this;
  }
  
  public A withConditions(CredentialsRequestCondition... conditions) {
    if (this.conditions != null) {
        this.conditions.clear();
        _visitables.remove("conditions");
    }
    if (conditions != null) {
      for (CredentialsRequestCondition item : conditions) {
        this.addToConditions(item);
      }
    }
    return (A) this;
  }
  
  public A withLastSyncCloudCredsSecretResourceVersion(String lastSyncCloudCredsSecretResourceVersion) {
    this.lastSyncCloudCredsSecretResourceVersion = lastSyncCloudCredsSecretResourceVersion;
    return (A) this;
  }
  
  public A withLastSyncGeneration(Long lastSyncGeneration) {
    this.lastSyncGeneration = lastSyncGeneration;
    return (A) this;
  }
  
  public A withLastSyncInfrastructureResourceVersion(String lastSyncInfrastructureResourceVersion) {
    this.lastSyncInfrastructureResourceVersion = lastSyncInfrastructureResourceVersion;
    return (A) this;
  }
  
  public A withLastSyncTimestamp(String lastSyncTimestamp) {
    this.lastSyncTimestamp = lastSyncTimestamp;
    return (A) this;
  }
  
  public A withProviderStatus(Object providerStatus) {
    this.providerStatus = providerStatus;
    return (A) this;
  }
  
  public A withProvisioned() {
    return withProvisioned(true);
  }
  
  public A withProvisioned(Boolean provisioned) {
    this.provisioned = provisioned;
    return (A) this;
  }
  public class ConditionsNested<N> extends CredentialsRequestConditionFluent<ConditionsNested<N>> implements Nested<N>{
  
    CredentialsRequestConditionBuilder builder;
    int index;
  
    ConditionsNested(int index,CredentialsRequestCondition item) {
      this.index = index;
      this.builder = new CredentialsRequestConditionBuilder(this, item);
    }
  
    public N and() {
      return (N) CredentialsRequestStatusFluent.this.setToConditions(index, builder.build());
    }
    
    public N endCondition() {
      return and();
    }
    
  }
}