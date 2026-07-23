package io.fabric8.openshift.api.model.machine.v1beta1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import io.fabric8.kubernetes.api.model.NodeAddress;
import io.fabric8.kubernetes.api.model.ObjectReference;
import io.fabric8.kubernetes.api.model.ObjectReferenceBuilder;
import io.fabric8.kubernetes.api.model.ObjectReferenceFluent;
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
import java.util.Optional;
import java.util.function.Predicate;

/**
 * Generated
 */
@SuppressWarnings("unchecked")
public class MachineStatusFluent<A extends io.fabric8.openshift.api.model.machine.v1beta1.MachineStatusFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private List<NodeAddress> addresses = new ArrayList<NodeAddress>();
  private String authoritativeAPI;
  private ArrayList<ConditionBuilder> conditions = new ArrayList<ConditionBuilder>();
  private String errorMessage;
  private String errorReason;
  private LastOperationBuilder lastOperation;
  private String lastUpdated;
  private ObjectReferenceBuilder nodeRef;
  private String phase;
  private Object providerStatus;
  private Long synchronizedGeneration;

  public MachineStatusFluent() {
  }
  
  public MachineStatusFluent(MachineStatus instance) {
    this.copyInstance(instance);
  }

  public A addAllToAddresses(Collection<NodeAddress> items) {
    if (this.addresses == null) {
      this.addresses = new ArrayList();
    }
    for (NodeAddress item : items) {
      this.addresses.add(item);
    }
    return (A) this;
  }
  
  public A addAllToConditions(Collection<Condition> items) {
    if (this.conditions == null) {
      this.conditions = new ArrayList();
    }
    for (Condition item : items) {
        ConditionBuilder builder = new ConditionBuilder(item);
        _visitables.get("conditions").add(builder);
        this.conditions.add(builder);
    }
    return (A) this;
  }
  
  public A addNewAddress(String address,String type) {
    return (A) this.addToAddresses(new NodeAddress(address, type));
  }
  
  public ConditionsNested<A> addNewCondition() {
    return new ConditionsNested(-1, null);
  }
  
  public ConditionsNested<A> addNewConditionLike(Condition item) {
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
  
  public A addToAddresses(NodeAddress... items) {
    if (this.addresses == null) {
      this.addresses = new ArrayList();
    }
    for (NodeAddress item : items) {
      this.addresses.add(item);
    }
    return (A) this;
  }
  
  public A addToAddresses(int index,NodeAddress item) {
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
        ConditionBuilder builder = new ConditionBuilder(item);
        _visitables.get("conditions").add(builder);
        this.conditions.add(builder);
    }
    return (A) this;
  }
  
  public A addToConditions(int index,Condition item) {
    if (this.conditions == null) {
      this.conditions = new ArrayList();
    }
    ConditionBuilder builder = new ConditionBuilder(item);
    if (index < 0 || index >= conditions.size()) {
        _visitables.get("conditions").add(builder);
        conditions.add(builder);
    } else {
        _visitables.get("conditions").add(builder);
        conditions.add(index, builder);
    }
    return (A) this;
  }
  
  public Condition buildCondition(int index) {
    return this.conditions.get(index).build();
  }
  
  public List<Condition> buildConditions() {
    return this.conditions != null ? build(conditions) : null;
  }
  
  public Condition buildFirstCondition() {
    return this.conditions.get(0).build();
  }
  
  public Condition buildLastCondition() {
    return this.conditions.get(conditions.size() - 1).build();
  }
  
  public LastOperation buildLastOperation() {
    return this.lastOperation != null ? this.lastOperation.build() : null;
  }
  
  public Condition buildMatchingCondition(Predicate<ConditionBuilder> predicate) {
      for (ConditionBuilder item : conditions) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public ObjectReference buildNodeRef() {
    return this.nodeRef != null ? this.nodeRef.build() : null;
  }
  
  protected void copyInstance(MachineStatus instance) {
    instance = instance != null ? instance : new MachineStatus();
    if (instance != null) {
        this.withAddresses(instance.getAddresses());
        this.withAuthoritativeAPI(instance.getAuthoritativeAPI());
        this.withConditions(instance.getConditions());
        this.withErrorMessage(instance.getErrorMessage());
        this.withErrorReason(instance.getErrorReason());
        this.withLastOperation(instance.getLastOperation());
        this.withLastUpdated(instance.getLastUpdated());
        this.withNodeRef(instance.getNodeRef());
        this.withPhase(instance.getPhase());
        this.withProviderStatus(instance.getProviderStatus());
        this.withSynchronizedGeneration(instance.getSynchronizedGeneration());
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
  
  public LastOperationNested<A> editLastOperation() {
    return this.withNewLastOperationLike(Optional.ofNullable(this.buildLastOperation()).orElse(null));
  }
  
  public ConditionsNested<A> editMatchingCondition(Predicate<ConditionBuilder> predicate) {
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
  
  public NodeRefNested<A> editNodeRef() {
    return this.withNewNodeRefLike(Optional.ofNullable(this.buildNodeRef()).orElse(null));
  }
  
  public LastOperationNested<A> editOrNewLastOperation() {
    return this.withNewLastOperationLike(Optional.ofNullable(this.buildLastOperation()).orElse(new LastOperationBuilder().build()));
  }
  
  public LastOperationNested<A> editOrNewLastOperationLike(LastOperation item) {
    return this.withNewLastOperationLike(Optional.ofNullable(this.buildLastOperation()).orElse(item));
  }
  
  public NodeRefNested<A> editOrNewNodeRef() {
    return this.withNewNodeRefLike(Optional.ofNullable(this.buildNodeRef()).orElse(new ObjectReferenceBuilder().build()));
  }
  
  public NodeRefNested<A> editOrNewNodeRefLike(ObjectReference item) {
    return this.withNewNodeRefLike(Optional.ofNullable(this.buildNodeRef()).orElse(item));
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
    MachineStatusFluent that = (MachineStatusFluent) o;
    if (!(Objects.equals(addresses, that.addresses))) {
      return false;
    }
    if (!(Objects.equals(authoritativeAPI, that.authoritativeAPI))) {
      return false;
    }
    if (!(Objects.equals(conditions, that.conditions))) {
      return false;
    }
    if (!(Objects.equals(errorMessage, that.errorMessage))) {
      return false;
    }
    if (!(Objects.equals(errorReason, that.errorReason))) {
      return false;
    }
    if (!(Objects.equals(lastOperation, that.lastOperation))) {
      return false;
    }
    if (!(Objects.equals(lastUpdated, that.lastUpdated))) {
      return false;
    }
    if (!(Objects.equals(nodeRef, that.nodeRef))) {
      return false;
    }
    if (!(Objects.equals(phase, that.phase))) {
      return false;
    }
    if (!(Objects.equals(providerStatus, that.providerStatus))) {
      return false;
    }
    if (!(Objects.equals(synchronizedGeneration, that.synchronizedGeneration))) {
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
  
  public NodeAddress getAddress(int index) {
    return this.addresses.get(index);
  }
  
  public List<NodeAddress> getAddresses() {
    return this.addresses;
  }
  
  public String getAuthoritativeAPI() {
    return this.authoritativeAPI;
  }
  
  public String getErrorMessage() {
    return this.errorMessage;
  }
  
  public String getErrorReason() {
    return this.errorReason;
  }
  
  public NodeAddress getFirstAddress() {
    return this.addresses.get(0);
  }
  
  public NodeAddress getLastAddress() {
    return this.addresses.get(addresses.size() - 1);
  }
  
  public String getLastUpdated() {
    return this.lastUpdated;
  }
  
  public NodeAddress getMatchingAddress(Predicate<NodeAddress> predicate) {
      for (NodeAddress item : addresses) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public String getPhase() {
    return this.phase;
  }
  
  public Object getProviderStatus() {
    return this.providerStatus;
  }
  
  public Long getSynchronizedGeneration() {
    return this.synchronizedGeneration;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasAddresses() {
    return this.addresses != null && !(this.addresses.isEmpty());
  }
  
  public boolean hasAuthoritativeAPI() {
    return this.authoritativeAPI != null;
  }
  
  public boolean hasConditions() {
    return this.conditions != null && !(this.conditions.isEmpty());
  }
  
  public boolean hasErrorMessage() {
    return this.errorMessage != null;
  }
  
  public boolean hasErrorReason() {
    return this.errorReason != null;
  }
  
  public boolean hasLastOperation() {
    return this.lastOperation != null;
  }
  
  public boolean hasLastUpdated() {
    return this.lastUpdated != null;
  }
  
  public boolean hasMatchingAddress(Predicate<NodeAddress> predicate) {
      for (NodeAddress item : addresses) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingCondition(Predicate<ConditionBuilder> predicate) {
      for (ConditionBuilder item : conditions) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasNodeRef() {
    return this.nodeRef != null;
  }
  
  public boolean hasPhase() {
    return this.phase != null;
  }
  
  public boolean hasProviderStatus() {
    return this.providerStatus != null;
  }
  
  public boolean hasSynchronizedGeneration() {
    return this.synchronizedGeneration != null;
  }
  
  public int hashCode() {
    return Objects.hash(addresses, authoritativeAPI, conditions, errorMessage, errorReason, lastOperation, lastUpdated, nodeRef, phase, providerStatus, synchronizedGeneration, additionalProperties);
  }
  
  public A removeAllFromAddresses(Collection<NodeAddress> items) {
    if (this.addresses == null) {
      return (A) this;
    }
    for (NodeAddress item : items) {
      this.addresses.remove(item);
    }
    return (A) this;
  }
  
  public A removeAllFromConditions(Collection<Condition> items) {
    if (this.conditions == null) {
      return (A) this;
    }
    for (Condition item : items) {
        ConditionBuilder builder = new ConditionBuilder(item);
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
  
  public A removeFromAddresses(NodeAddress... items) {
    if (this.addresses == null) {
      return (A) this;
    }
    for (NodeAddress item : items) {
      this.addresses.remove(item);
    }
    return (A) this;
  }
  
  public A removeFromConditions(Condition... items) {
    if (this.conditions == null) {
      return (A) this;
    }
    for (Condition item : items) {
        ConditionBuilder builder = new ConditionBuilder(item);
        _visitables.get("conditions").remove(builder);
        this.conditions.remove(builder);
    }
    return (A) this;
  }
  
  public A removeMatchingFromConditions(Predicate<ConditionBuilder> predicate) {
    if (conditions == null) {
      return (A) this;
    }
    Iterator<ConditionBuilder> each = conditions.iterator();
    List visitables = _visitables.get("conditions");
    while (each.hasNext()) {
        ConditionBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public ConditionsNested<A> setNewConditionLike(int index,Condition item) {
    return new ConditionsNested(index, item);
  }
  
  public A setToAddresses(int index,NodeAddress item) {
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
    ConditionBuilder builder = new ConditionBuilder(item);
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
    if (!(addresses == null) && !(addresses.isEmpty())) {
        sb.append("addresses:");
        sb.append(addresses);
        sb.append(",");
    }
    if (!(authoritativeAPI == null)) {
        sb.append("authoritativeAPI:");
        sb.append(authoritativeAPI);
        sb.append(",");
    }
    if (!(conditions == null) && !(conditions.isEmpty())) {
        sb.append("conditions:");
        sb.append(conditions);
        sb.append(",");
    }
    if (!(errorMessage == null)) {
        sb.append("errorMessage:");
        sb.append(errorMessage);
        sb.append(",");
    }
    if (!(errorReason == null)) {
        sb.append("errorReason:");
        sb.append(errorReason);
        sb.append(",");
    }
    if (!(lastOperation == null)) {
        sb.append("lastOperation:");
        sb.append(lastOperation);
        sb.append(",");
    }
    if (!(lastUpdated == null)) {
        sb.append("lastUpdated:");
        sb.append(lastUpdated);
        sb.append(",");
    }
    if (!(nodeRef == null)) {
        sb.append("nodeRef:");
        sb.append(nodeRef);
        sb.append(",");
    }
    if (!(phase == null)) {
        sb.append("phase:");
        sb.append(phase);
        sb.append(",");
    }
    if (!(providerStatus == null)) {
        sb.append("providerStatus:");
        sb.append(providerStatus);
        sb.append(",");
    }
    if (!(synchronizedGeneration == null)) {
        sb.append("synchronizedGeneration:");
        sb.append(synchronizedGeneration);
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
  
  public A withAddresses(List<NodeAddress> addresses) {
    if (addresses != null) {
        this.addresses = new ArrayList();
        for (NodeAddress item : addresses) {
          this.addToAddresses(item);
        }
    } else {
      this.addresses = null;
    }
    return (A) this;
  }
  
  public A withAddresses(NodeAddress... addresses) {
    if (this.addresses != null) {
        this.addresses.clear();
        _visitables.remove("addresses");
    }
    if (addresses != null) {
      for (NodeAddress item : addresses) {
        this.addToAddresses(item);
      }
    }
    return (A) this;
  }
  
  public A withAuthoritativeAPI(String authoritativeAPI) {
    this.authoritativeAPI = authoritativeAPI;
    return (A) this;
  }
  
  public A withConditions(List<Condition> conditions) {
    if (this.conditions != null) {
      this._visitables.get("conditions").clear();
    }
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
  
  public A withErrorMessage(String errorMessage) {
    this.errorMessage = errorMessage;
    return (A) this;
  }
  
  public A withErrorReason(String errorReason) {
    this.errorReason = errorReason;
    return (A) this;
  }
  
  public A withLastOperation(LastOperation lastOperation) {
    this._visitables.remove("lastOperation");
    if (lastOperation != null) {
        this.lastOperation = new LastOperationBuilder(lastOperation);
        this._visitables.get("lastOperation").add(this.lastOperation);
    } else {
        this.lastOperation = null;
        this._visitables.get("lastOperation").remove(this.lastOperation);
    }
    return (A) this;
  }
  
  public A withLastUpdated(String lastUpdated) {
    this.lastUpdated = lastUpdated;
    return (A) this;
  }
  
  public LastOperationNested<A> withNewLastOperation() {
    return new LastOperationNested(null);
  }
  
  public A withNewLastOperation(String description,String lastUpdated,String state,String type) {
    return (A) this.withLastOperation(new LastOperation(description, lastUpdated, state, type));
  }
  
  public LastOperationNested<A> withNewLastOperationLike(LastOperation item) {
    return new LastOperationNested(item);
  }
  
  public NodeRefNested<A> withNewNodeRef() {
    return new NodeRefNested(null);
  }
  
  public NodeRefNested<A> withNewNodeRefLike(ObjectReference item) {
    return new NodeRefNested(item);
  }
  
  public A withNodeRef(ObjectReference nodeRef) {
    this._visitables.remove("nodeRef");
    if (nodeRef != null) {
        this.nodeRef = new ObjectReferenceBuilder(nodeRef);
        this._visitables.get("nodeRef").add(this.nodeRef);
    } else {
        this.nodeRef = null;
        this._visitables.get("nodeRef").remove(this.nodeRef);
    }
    return (A) this;
  }
  
  public A withPhase(String phase) {
    this.phase = phase;
    return (A) this;
  }
  
  public A withProviderStatus(Object providerStatus) {
    this.providerStatus = providerStatus;
    return (A) this;
  }
  
  public A withSynchronizedGeneration(Long synchronizedGeneration) {
    this.synchronizedGeneration = synchronizedGeneration;
    return (A) this;
  }
  public class ConditionsNested<N> extends ConditionFluent<ConditionsNested<N>> implements Nested<N>{
  
    ConditionBuilder builder;
    int index;
  
    ConditionsNested(int index,Condition item) {
      this.index = index;
      this.builder = new ConditionBuilder(this, item);
    }
  
    public N and() {
      return (N) MachineStatusFluent.this.setToConditions(index, builder.build());
    }
    
    public N endCondition() {
      return and();
    }
    
  }
  public class LastOperationNested<N> extends LastOperationFluent<LastOperationNested<N>> implements Nested<N>{
  
    LastOperationBuilder builder;
  
    LastOperationNested(LastOperation item) {
      this.builder = new LastOperationBuilder(this, item);
    }
  
    public N and() {
      return (N) MachineStatusFluent.this.withLastOperation(builder.build());
    }
    
    public N endLastOperation() {
      return and();
    }
    
  }
  public class NodeRefNested<N> extends ObjectReferenceFluent<NodeRefNested<N>> implements Nested<N>{
  
    ObjectReferenceBuilder builder;
  
    NodeRefNested(ObjectReference item) {
      this.builder = new ObjectReferenceBuilder(this, item);
    }
  
    public N and() {
      return (N) MachineStatusFluent.this.withNodeRef(builder.build());
    }
    
    public N endNodeRef() {
      return and();
    }
    
  }
}