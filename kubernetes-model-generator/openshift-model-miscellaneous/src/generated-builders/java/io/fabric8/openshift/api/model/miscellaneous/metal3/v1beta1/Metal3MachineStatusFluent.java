package io.fabric8.openshift.api.model.miscellaneous.metal3.v1beta1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import io.fabric8.kubernetes.api.model.ObjectReference;
import io.fabric8.kubernetes.api.model.ObjectReferenceBuilder;
import io.fabric8.kubernetes.api.model.ObjectReferenceFluent;
import io.fabric8.kubernetes.api.model.SecretReference;
import io.fabric8.kubernetes.api.model.clusterapi.core.v1beta1.Condition;
import io.fabric8.kubernetes.api.model.clusterapi.core.v1beta1.MachineAddress;
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
public class Metal3MachineStatusFluent<A extends io.fabric8.openshift.api.model.miscellaneous.metal3.v1beta1.Metal3MachineStatusFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private List<MachineAddress> addresses = new ArrayList<MachineAddress>();
  private List<Condition> conditions = new ArrayList<Condition>();
  private String failureMessage;
  private String failureReason;
  private String lastUpdated;
  private SecretReference metaData;
  private SecretReference networkData;
  private String phase;
  private Boolean ready;
  private ObjectReferenceBuilder renderedData;
  private SecretReference userData;
  private Metal3MachineV1Beta2StatusBuilder v1beta2;

  public Metal3MachineStatusFluent() {
  }
  
  public Metal3MachineStatusFluent(Metal3MachineStatus instance) {
    this.copyInstance(instance);
  }

  public A addAllToAddresses(Collection<MachineAddress> items) {
    if (this.addresses == null) {
      this.addresses = new ArrayList();
    }
    for (MachineAddress item : items) {
      this.addresses.add(item);
    }
    return (A) this;
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
  
  public A addNewAddress(String address,String type) {
    return (A) this.addToAddresses(new MachineAddress(address, type));
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
  
  public A addToAddresses(MachineAddress... items) {
    if (this.addresses == null) {
      this.addresses = new ArrayList();
    }
    for (MachineAddress item : items) {
      this.addresses.add(item);
    }
    return (A) this;
  }
  
  public A addToAddresses(int index,MachineAddress item) {
    if (this.addresses == null) {
      this.addresses = new ArrayList();
    }
    this.addresses.add(index, item);
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
  
  public ObjectReference buildRenderedData() {
    return this.renderedData != null ? this.renderedData.build() : null;
  }
  
  public Metal3MachineV1Beta2Status buildV1beta2() {
    return this.v1beta2 != null ? this.v1beta2.build() : null;
  }
  
  protected void copyInstance(Metal3MachineStatus instance) {
    instance = instance != null ? instance : new Metal3MachineStatus();
    if (instance != null) {
        this.withAddresses(instance.getAddresses());
        this.withConditions(instance.getConditions());
        this.withFailureMessage(instance.getFailureMessage());
        this.withFailureReason(instance.getFailureReason());
        this.withLastUpdated(instance.getLastUpdated());
        this.withMetaData(instance.getMetaData());
        this.withNetworkData(instance.getNetworkData());
        this.withPhase(instance.getPhase());
        this.withReady(instance.getReady());
        this.withRenderedData(instance.getRenderedData());
        this.withUserData(instance.getUserData());
        this.withV1beta2(instance.getV1beta2());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public RenderedDataNested<A> editOrNewRenderedData() {
    return this.withNewRenderedDataLike(Optional.ofNullable(this.buildRenderedData()).orElse(new ObjectReferenceBuilder().build()));
  }
  
  public RenderedDataNested<A> editOrNewRenderedDataLike(ObjectReference item) {
    return this.withNewRenderedDataLike(Optional.ofNullable(this.buildRenderedData()).orElse(item));
  }
  
  public V1beta2Nested<A> editOrNewV1beta2() {
    return this.withNewV1beta2Like(Optional.ofNullable(this.buildV1beta2()).orElse(new Metal3MachineV1Beta2StatusBuilder().build()));
  }
  
  public V1beta2Nested<A> editOrNewV1beta2Like(Metal3MachineV1Beta2Status item) {
    return this.withNewV1beta2Like(Optional.ofNullable(this.buildV1beta2()).orElse(item));
  }
  
  public RenderedDataNested<A> editRenderedData() {
    return this.withNewRenderedDataLike(Optional.ofNullable(this.buildRenderedData()).orElse(null));
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
    Metal3MachineStatusFluent that = (Metal3MachineStatusFluent) o;
    if (!(Objects.equals(addresses, that.addresses))) {
      return false;
    }
    if (!(Objects.equals(conditions, that.conditions))) {
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
    if (!(Objects.equals(metaData, that.metaData))) {
      return false;
    }
    if (!(Objects.equals(networkData, that.networkData))) {
      return false;
    }
    if (!(Objects.equals(phase, that.phase))) {
      return false;
    }
    if (!(Objects.equals(ready, that.ready))) {
      return false;
    }
    if (!(Objects.equals(renderedData, that.renderedData))) {
      return false;
    }
    if (!(Objects.equals(userData, that.userData))) {
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
  
  public MachineAddress getAddress(int index) {
    return this.addresses.get(index);
  }
  
  public List<MachineAddress> getAddresses() {
    return this.addresses;
  }
  
  public Condition getCondition(int index) {
    return this.conditions.get(index);
  }
  
  public List<Condition> getConditions() {
    return this.conditions;
  }
  
  public String getFailureMessage() {
    return this.failureMessage;
  }
  
  public String getFailureReason() {
    return this.failureReason;
  }
  
  public MachineAddress getFirstAddress() {
    return this.addresses.get(0);
  }
  
  public Condition getFirstCondition() {
    return this.conditions.get(0);
  }
  
  public MachineAddress getLastAddress() {
    return this.addresses.get(addresses.size() - 1);
  }
  
  public Condition getLastCondition() {
    return this.conditions.get(conditions.size() - 1);
  }
  
  public String getLastUpdated() {
    return this.lastUpdated;
  }
  
  public MachineAddress getMatchingAddress(Predicate<MachineAddress> predicate) {
      for (MachineAddress item : addresses) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public Condition getMatchingCondition(Predicate<Condition> predicate) {
      for (Condition item : conditions) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public SecretReference getMetaData() {
    return this.metaData;
  }
  
  public SecretReference getNetworkData() {
    return this.networkData;
  }
  
  public String getPhase() {
    return this.phase;
  }
  
  public Boolean getReady() {
    return this.ready;
  }
  
  public SecretReference getUserData() {
    return this.userData;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasAddresses() {
    return this.addresses != null && !(this.addresses.isEmpty());
  }
  
  public boolean hasConditions() {
    return this.conditions != null && !(this.conditions.isEmpty());
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
  
  public boolean hasMatchingAddress(Predicate<MachineAddress> predicate) {
      for (MachineAddress item : addresses) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingCondition(Predicate<Condition> predicate) {
      for (Condition item : conditions) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMetaData() {
    return this.metaData != null;
  }
  
  public boolean hasNetworkData() {
    return this.networkData != null;
  }
  
  public boolean hasPhase() {
    return this.phase != null;
  }
  
  public boolean hasReady() {
    return this.ready != null;
  }
  
  public boolean hasRenderedData() {
    return this.renderedData != null;
  }
  
  public boolean hasUserData() {
    return this.userData != null;
  }
  
  public boolean hasV1beta2() {
    return this.v1beta2 != null;
  }
  
  public int hashCode() {
    return Objects.hash(addresses, conditions, failureMessage, failureReason, lastUpdated, metaData, networkData, phase, ready, renderedData, userData, v1beta2, additionalProperties);
  }
  
  public A removeAllFromAddresses(Collection<MachineAddress> items) {
    if (this.addresses == null) {
      return (A) this;
    }
    for (MachineAddress item : items) {
      this.addresses.remove(item);
    }
    return (A) this;
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
  
  public A removeFromAddresses(MachineAddress... items) {
    if (this.addresses == null) {
      return (A) this;
    }
    for (MachineAddress item : items) {
      this.addresses.remove(item);
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
  
  public A setToAddresses(int index,MachineAddress item) {
    if (this.addresses == null) {
      this.addresses = new ArrayList();
    }
    this.addresses.set(index, item);
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
    if (!(addresses == null) && !(addresses.isEmpty())) {
        sb.append("addresses:");
        sb.append(addresses);
        sb.append(",");
    }
    if (!(conditions == null) && !(conditions.isEmpty())) {
        sb.append("conditions:");
        sb.append(conditions);
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
    if (!(metaData == null)) {
        sb.append("metaData:");
        sb.append(metaData);
        sb.append(",");
    }
    if (!(networkData == null)) {
        sb.append("networkData:");
        sb.append(networkData);
        sb.append(",");
    }
    if (!(phase == null)) {
        sb.append("phase:");
        sb.append(phase);
        sb.append(",");
    }
    if (!(ready == null)) {
        sb.append("ready:");
        sb.append(ready);
        sb.append(",");
    }
    if (!(renderedData == null)) {
        sb.append("renderedData:");
        sb.append(renderedData);
        sb.append(",");
    }
    if (!(userData == null)) {
        sb.append("userData:");
        sb.append(userData);
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
  
  public A withAddresses(List<MachineAddress> addresses) {
    if (addresses != null) {
        this.addresses = new ArrayList();
        for (MachineAddress item : addresses) {
          this.addToAddresses(item);
        }
    } else {
      this.addresses = null;
    }
    return (A) this;
  }
  
  public A withAddresses(MachineAddress... addresses) {
    if (this.addresses != null) {
        this.addresses.clear();
        _visitables.remove("addresses");
    }
    if (addresses != null) {
      for (MachineAddress item : addresses) {
        this.addToAddresses(item);
      }
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
  
  public A withMetaData(SecretReference metaData) {
    this.metaData = metaData;
    return (A) this;
  }
  
  public A withNetworkData(SecretReference networkData) {
    this.networkData = networkData;
    return (A) this;
  }
  
  public A withNewMetaData(String name,String namespace) {
    return (A) this.withMetaData(new SecretReference(name, namespace));
  }
  
  public A withNewNetworkData(String name,String namespace) {
    return (A) this.withNetworkData(new SecretReference(name, namespace));
  }
  
  public RenderedDataNested<A> withNewRenderedData() {
    return new RenderedDataNested(null);
  }
  
  public RenderedDataNested<A> withNewRenderedDataLike(ObjectReference item) {
    return new RenderedDataNested(item);
  }
  
  public A withNewUserData(String name,String namespace) {
    return (A) this.withUserData(new SecretReference(name, namespace));
  }
  
  public V1beta2Nested<A> withNewV1beta2() {
    return new V1beta2Nested(null);
  }
  
  public V1beta2Nested<A> withNewV1beta2Like(Metal3MachineV1Beta2Status item) {
    return new V1beta2Nested(item);
  }
  
  public A withPhase(String phase) {
    this.phase = phase;
    return (A) this;
  }
  
  public A withReady() {
    return withReady(true);
  }
  
  public A withReady(Boolean ready) {
    this.ready = ready;
    return (A) this;
  }
  
  public A withRenderedData(ObjectReference renderedData) {
    this._visitables.remove("renderedData");
    if (renderedData != null) {
        this.renderedData = new ObjectReferenceBuilder(renderedData);
        this._visitables.get("renderedData").add(this.renderedData);
    } else {
        this.renderedData = null;
        this._visitables.get("renderedData").remove(this.renderedData);
    }
    return (A) this;
  }
  
  public A withUserData(SecretReference userData) {
    this.userData = userData;
    return (A) this;
  }
  
  public A withV1beta2(Metal3MachineV1Beta2Status v1beta2) {
    this._visitables.remove("v1beta2");
    if (v1beta2 != null) {
        this.v1beta2 = new Metal3MachineV1Beta2StatusBuilder(v1beta2);
        this._visitables.get("v1beta2").add(this.v1beta2);
    } else {
        this.v1beta2 = null;
        this._visitables.get("v1beta2").remove(this.v1beta2);
    }
    return (A) this;
  }
  public class RenderedDataNested<N> extends ObjectReferenceFluent<RenderedDataNested<N>> implements Nested<N>{
  
    ObjectReferenceBuilder builder;
  
    RenderedDataNested(ObjectReference item) {
      this.builder = new ObjectReferenceBuilder(this, item);
    }
  
    public N and() {
      return (N) Metal3MachineStatusFluent.this.withRenderedData(builder.build());
    }
    
    public N endRenderedData() {
      return and();
    }
    
  }
  public class V1beta2Nested<N> extends Metal3MachineV1Beta2StatusFluent<V1beta2Nested<N>> implements Nested<N>{
  
    Metal3MachineV1Beta2StatusBuilder builder;
  
    V1beta2Nested(Metal3MachineV1Beta2Status item) {
      this.builder = new Metal3MachineV1Beta2StatusBuilder(this, item);
    }
  
    public N and() {
      return (N) Metal3MachineStatusFluent.this.withV1beta2(builder.build());
    }
    
    public N endV1beta2() {
      return and();
    }
    
  }
}