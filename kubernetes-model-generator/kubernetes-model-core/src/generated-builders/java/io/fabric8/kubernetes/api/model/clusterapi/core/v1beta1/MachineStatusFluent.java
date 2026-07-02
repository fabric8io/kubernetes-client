package io.fabric8.kubernetes.api.model.clusterapi.core.v1beta1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import io.fabric8.kubernetes.api.model.NodeSystemInfo;
import io.fabric8.kubernetes.api.model.NodeSystemInfoBuilder;
import io.fabric8.kubernetes.api.model.NodeSystemInfoFluent;
import io.fabric8.kubernetes.api.model.ObjectReference;
import io.fabric8.kubernetes.api.model.ObjectReferenceBuilder;
import io.fabric8.kubernetes.api.model.ObjectReferenceFluent;
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
import java.util.Optional;
import java.util.function.Predicate;

/**
 * Generated
 */
@SuppressWarnings("unchecked")
public class MachineStatusFluent<A extends io.fabric8.kubernetes.api.model.clusterapi.core.v1beta1.MachineStatusFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private ArrayList<MachineAddressBuilder> addresses = new ArrayList<MachineAddressBuilder>();
  private Boolean bootstrapReady;
  private String certificatesExpiryDate;
  private ArrayList<ConditionBuilder> conditions = new ArrayList<ConditionBuilder>();
  private MachineDeletionStatusBuilder deletion;
  private String failureMessage;
  private String failureReason;
  private Boolean infrastructureReady;
  private String lastUpdated;
  private NodeSystemInfoBuilder nodeInfo;
  private ObjectReferenceBuilder nodeRef;
  private Long observedGeneration;
  private String phase;
  private MachineV1Beta2StatusBuilder v1beta2;

  public MachineStatusFluent() {
  }
  
  public MachineStatusFluent(MachineStatus instance) {
    this.copyInstance(instance);
  }

  public A addAllToAddresses(Collection<MachineAddress> items) {
    if (this.addresses == null) {
      this.addresses = new ArrayList();
    }
    for (MachineAddress item : items) {
        MachineAddressBuilder builder = new MachineAddressBuilder(item);
        _visitables.get("addresses").add(builder);
        this.addresses.add(builder);
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
  
  public AddressesNested<A> addNewAddress() {
    return new AddressesNested(-1, null);
  }
  
  public A addNewAddress(String address,String type) {
    return (A) this.addToAddresses(new MachineAddress(address, type));
  }
  
  public AddressesNested<A> addNewAddressLike(MachineAddress item) {
    return new AddressesNested(-1, item);
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
  
  public A addToAddresses(MachineAddress... items) {
    if (this.addresses == null) {
      this.addresses = new ArrayList();
    }
    for (MachineAddress item : items) {
        MachineAddressBuilder builder = new MachineAddressBuilder(item);
        _visitables.get("addresses").add(builder);
        this.addresses.add(builder);
    }
    return (A) this;
  }
  
  public A addToAddresses(int index,MachineAddress item) {
    if (this.addresses == null) {
      this.addresses = new ArrayList();
    }
    MachineAddressBuilder builder = new MachineAddressBuilder(item);
    if (index < 0 || index >= addresses.size()) {
        _visitables.get("addresses").add(builder);
        addresses.add(builder);
    } else {
        _visitables.get("addresses").add(builder);
        addresses.add(index, builder);
    }
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
  
  public MachineAddress buildAddress(int index) {
    return this.addresses.get(index).build();
  }
  
  public List<MachineAddress> buildAddresses() {
    return this.addresses != null ? build(addresses) : null;
  }
  
  public Condition buildCondition(int index) {
    return this.conditions.get(index).build();
  }
  
  public List<Condition> buildConditions() {
    return this.conditions != null ? build(conditions) : null;
  }
  
  public MachineDeletionStatus buildDeletion() {
    return this.deletion != null ? this.deletion.build() : null;
  }
  
  public MachineAddress buildFirstAddress() {
    return this.addresses.get(0).build();
  }
  
  public Condition buildFirstCondition() {
    return this.conditions.get(0).build();
  }
  
  public MachineAddress buildLastAddress() {
    return this.addresses.get(addresses.size() - 1).build();
  }
  
  public Condition buildLastCondition() {
    return this.conditions.get(conditions.size() - 1).build();
  }
  
  public MachineAddress buildMatchingAddress(Predicate<MachineAddressBuilder> predicate) {
      for (MachineAddressBuilder item : addresses) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public Condition buildMatchingCondition(Predicate<ConditionBuilder> predicate) {
      for (ConditionBuilder item : conditions) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public NodeSystemInfo buildNodeInfo() {
    return this.nodeInfo != null ? this.nodeInfo.build() : null;
  }
  
  public ObjectReference buildNodeRef() {
    return this.nodeRef != null ? this.nodeRef.build() : null;
  }
  
  public MachineV1Beta2Status buildV1beta2() {
    return this.v1beta2 != null ? this.v1beta2.build() : null;
  }
  
  protected void copyInstance(MachineStatus instance) {
    instance = instance != null ? instance : new MachineStatus();
    if (instance != null) {
        this.withAddresses(instance.getAddresses());
        this.withBootstrapReady(instance.getBootstrapReady());
        this.withCertificatesExpiryDate(instance.getCertificatesExpiryDate());
        this.withConditions(instance.getConditions());
        this.withDeletion(instance.getDeletion());
        this.withFailureMessage(instance.getFailureMessage());
        this.withFailureReason(instance.getFailureReason());
        this.withInfrastructureReady(instance.getInfrastructureReady());
        this.withLastUpdated(instance.getLastUpdated());
        this.withNodeInfo(instance.getNodeInfo());
        this.withNodeRef(instance.getNodeRef());
        this.withObservedGeneration(instance.getObservedGeneration());
        this.withPhase(instance.getPhase());
        this.withV1beta2(instance.getV1beta2());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public AddressesNested<A> editAddress(int index) {
    if (addresses.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "addresses"));
    }
    return this.setNewAddressLike(index, this.buildAddress(index));
  }
  
  public ConditionsNested<A> editCondition(int index) {
    if (conditions.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "conditions"));
    }
    return this.setNewConditionLike(index, this.buildCondition(index));
  }
  
  public DeletionNested<A> editDeletion() {
    return this.withNewDeletionLike(Optional.ofNullable(this.buildDeletion()).orElse(null));
  }
  
  public AddressesNested<A> editFirstAddress() {
    if (addresses.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "addresses"));
    }
    return this.setNewAddressLike(0, this.buildAddress(0));
  }
  
  public ConditionsNested<A> editFirstCondition() {
    if (conditions.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "conditions"));
    }
    return this.setNewConditionLike(0, this.buildCondition(0));
  }
  
  public AddressesNested<A> editLastAddress() {
    int index = addresses.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "addresses"));
    }
    return this.setNewAddressLike(index, this.buildAddress(index));
  }
  
  public ConditionsNested<A> editLastCondition() {
    int index = conditions.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "conditions"));
    }
    return this.setNewConditionLike(index, this.buildCondition(index));
  }
  
  public AddressesNested<A> editMatchingAddress(Predicate<MachineAddressBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < addresses.size();i++) {
      if (predicate.test(addresses.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "addresses"));
    }
    return this.setNewAddressLike(index, this.buildAddress(index));
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
  
  public NodeInfoNested<A> editNodeInfo() {
    return this.withNewNodeInfoLike(Optional.ofNullable(this.buildNodeInfo()).orElse(null));
  }
  
  public NodeRefNested<A> editNodeRef() {
    return this.withNewNodeRefLike(Optional.ofNullable(this.buildNodeRef()).orElse(null));
  }
  
  public DeletionNested<A> editOrNewDeletion() {
    return this.withNewDeletionLike(Optional.ofNullable(this.buildDeletion()).orElse(new MachineDeletionStatusBuilder().build()));
  }
  
  public DeletionNested<A> editOrNewDeletionLike(MachineDeletionStatus item) {
    return this.withNewDeletionLike(Optional.ofNullable(this.buildDeletion()).orElse(item));
  }
  
  public NodeInfoNested<A> editOrNewNodeInfo() {
    return this.withNewNodeInfoLike(Optional.ofNullable(this.buildNodeInfo()).orElse(new NodeSystemInfoBuilder().build()));
  }
  
  public NodeInfoNested<A> editOrNewNodeInfoLike(NodeSystemInfo item) {
    return this.withNewNodeInfoLike(Optional.ofNullable(this.buildNodeInfo()).orElse(item));
  }
  
  public NodeRefNested<A> editOrNewNodeRef() {
    return this.withNewNodeRefLike(Optional.ofNullable(this.buildNodeRef()).orElse(new ObjectReferenceBuilder().build()));
  }
  
  public NodeRefNested<A> editOrNewNodeRefLike(ObjectReference item) {
    return this.withNewNodeRefLike(Optional.ofNullable(this.buildNodeRef()).orElse(item));
  }
  
  public V1beta2Nested<A> editOrNewV1beta2() {
    return this.withNewV1beta2Like(Optional.ofNullable(this.buildV1beta2()).orElse(new MachineV1Beta2StatusBuilder().build()));
  }
  
  public V1beta2Nested<A> editOrNewV1beta2Like(MachineV1Beta2Status item) {
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
    MachineStatusFluent that = (MachineStatusFluent) o;
    if (!(Objects.equals(addresses, that.addresses))) {
      return false;
    }
    if (!(Objects.equals(bootstrapReady, that.bootstrapReady))) {
      return false;
    }
    if (!(Objects.equals(certificatesExpiryDate, that.certificatesExpiryDate))) {
      return false;
    }
    if (!(Objects.equals(conditions, that.conditions))) {
      return false;
    }
    if (!(Objects.equals(deletion, that.deletion))) {
      return false;
    }
    if (!(Objects.equals(failureMessage, that.failureMessage))) {
      return false;
    }
    if (!(Objects.equals(failureReason, that.failureReason))) {
      return false;
    }
    if (!(Objects.equals(infrastructureReady, that.infrastructureReady))) {
      return false;
    }
    if (!(Objects.equals(lastUpdated, that.lastUpdated))) {
      return false;
    }
    if (!(Objects.equals(nodeInfo, that.nodeInfo))) {
      return false;
    }
    if (!(Objects.equals(nodeRef, that.nodeRef))) {
      return false;
    }
    if (!(Objects.equals(observedGeneration, that.observedGeneration))) {
      return false;
    }
    if (!(Objects.equals(phase, that.phase))) {
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
  
  public Boolean getBootstrapReady() {
    return this.bootstrapReady;
  }
  
  public String getCertificatesExpiryDate() {
    return this.certificatesExpiryDate;
  }
  
  public String getFailureMessage() {
    return this.failureMessage;
  }
  
  public String getFailureReason() {
    return this.failureReason;
  }
  
  public Boolean getInfrastructureReady() {
    return this.infrastructureReady;
  }
  
  public String getLastUpdated() {
    return this.lastUpdated;
  }
  
  public Long getObservedGeneration() {
    return this.observedGeneration;
  }
  
  public String getPhase() {
    return this.phase;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasAddresses() {
    return this.addresses != null && !(this.addresses.isEmpty());
  }
  
  public boolean hasBootstrapReady() {
    return this.bootstrapReady != null;
  }
  
  public boolean hasCertificatesExpiryDate() {
    return this.certificatesExpiryDate != null;
  }
  
  public boolean hasConditions() {
    return this.conditions != null && !(this.conditions.isEmpty());
  }
  
  public boolean hasDeletion() {
    return this.deletion != null;
  }
  
  public boolean hasFailureMessage() {
    return this.failureMessage != null;
  }
  
  public boolean hasFailureReason() {
    return this.failureReason != null;
  }
  
  public boolean hasInfrastructureReady() {
    return this.infrastructureReady != null;
  }
  
  public boolean hasLastUpdated() {
    return this.lastUpdated != null;
  }
  
  public boolean hasMatchingAddress(Predicate<MachineAddressBuilder> predicate) {
      for (MachineAddressBuilder item : addresses) {
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
  
  public boolean hasNodeInfo() {
    return this.nodeInfo != null;
  }
  
  public boolean hasNodeRef() {
    return this.nodeRef != null;
  }
  
  public boolean hasObservedGeneration() {
    return this.observedGeneration != null;
  }
  
  public boolean hasPhase() {
    return this.phase != null;
  }
  
  public boolean hasV1beta2() {
    return this.v1beta2 != null;
  }
  
  public int hashCode() {
    return Objects.hash(addresses, bootstrapReady, certificatesExpiryDate, conditions, deletion, failureMessage, failureReason, infrastructureReady, lastUpdated, nodeInfo, nodeRef, observedGeneration, phase, v1beta2, additionalProperties);
  }
  
  public A removeAllFromAddresses(Collection<MachineAddress> items) {
    if (this.addresses == null) {
      return (A) this;
    }
    for (MachineAddress item : items) {
        MachineAddressBuilder builder = new MachineAddressBuilder(item);
        _visitables.get("addresses").remove(builder);
        this.addresses.remove(builder);
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
  
  public A removeFromAddresses(MachineAddress... items) {
    if (this.addresses == null) {
      return (A) this;
    }
    for (MachineAddress item : items) {
        MachineAddressBuilder builder = new MachineAddressBuilder(item);
        _visitables.get("addresses").remove(builder);
        this.addresses.remove(builder);
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
  
  public A removeMatchingFromAddresses(Predicate<MachineAddressBuilder> predicate) {
    if (addresses == null) {
      return (A) this;
    }
    Iterator<MachineAddressBuilder> each = addresses.iterator();
    List visitables = _visitables.get("addresses");
    while (each.hasNext()) {
        MachineAddressBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
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
  
  public AddressesNested<A> setNewAddressLike(int index,MachineAddress item) {
    return new AddressesNested(index, item);
  }
  
  public ConditionsNested<A> setNewConditionLike(int index,Condition item) {
    return new ConditionsNested(index, item);
  }
  
  public A setToAddresses(int index,MachineAddress item) {
    if (this.addresses == null) {
      this.addresses = new ArrayList();
    }
    MachineAddressBuilder builder = new MachineAddressBuilder(item);
    if (index < 0 || index >= addresses.size()) {
        _visitables.get("addresses").add(builder);
        addresses.add(builder);
    } else {
        _visitables.get("addresses").add(builder);
        addresses.set(index, builder);
    }
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
    if (!(bootstrapReady == null)) {
        sb.append("bootstrapReady:");
        sb.append(bootstrapReady);
        sb.append(",");
    }
    if (!(certificatesExpiryDate == null)) {
        sb.append("certificatesExpiryDate:");
        sb.append(certificatesExpiryDate);
        sb.append(",");
    }
    if (!(conditions == null) && !(conditions.isEmpty())) {
        sb.append("conditions:");
        sb.append(conditions);
        sb.append(",");
    }
    if (!(deletion == null)) {
        sb.append("deletion:");
        sb.append(deletion);
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
    if (!(infrastructureReady == null)) {
        sb.append("infrastructureReady:");
        sb.append(infrastructureReady);
        sb.append(",");
    }
    if (!(lastUpdated == null)) {
        sb.append("lastUpdated:");
        sb.append(lastUpdated);
        sb.append(",");
    }
    if (!(nodeInfo == null)) {
        sb.append("nodeInfo:");
        sb.append(nodeInfo);
        sb.append(",");
    }
    if (!(nodeRef == null)) {
        sb.append("nodeRef:");
        sb.append(nodeRef);
        sb.append(",");
    }
    if (!(observedGeneration == null)) {
        sb.append("observedGeneration:");
        sb.append(observedGeneration);
        sb.append(",");
    }
    if (!(phase == null)) {
        sb.append("phase:");
        sb.append(phase);
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
    if (this.addresses != null) {
      this._visitables.get("addresses").clear();
    }
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
  
  public A withBootstrapReady() {
    return withBootstrapReady(true);
  }
  
  public A withBootstrapReady(Boolean bootstrapReady) {
    this.bootstrapReady = bootstrapReady;
    return (A) this;
  }
  
  public A withCertificatesExpiryDate(String certificatesExpiryDate) {
    this.certificatesExpiryDate = certificatesExpiryDate;
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
  
  public A withDeletion(MachineDeletionStatus deletion) {
    this._visitables.remove("deletion");
    if (deletion != null) {
        this.deletion = new MachineDeletionStatusBuilder(deletion);
        this._visitables.get("deletion").add(this.deletion);
    } else {
        this.deletion = null;
        this._visitables.get("deletion").remove(this.deletion);
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
  
  public A withInfrastructureReady() {
    return withInfrastructureReady(true);
  }
  
  public A withInfrastructureReady(Boolean infrastructureReady) {
    this.infrastructureReady = infrastructureReady;
    return (A) this;
  }
  
  public A withLastUpdated(String lastUpdated) {
    this.lastUpdated = lastUpdated;
    return (A) this;
  }
  
  public DeletionNested<A> withNewDeletion() {
    return new DeletionNested(null);
  }
  
  public A withNewDeletion(String nodeDrainStartTime,String waitForNodeVolumeDetachStartTime) {
    return (A) this.withDeletion(new MachineDeletionStatus(nodeDrainStartTime, waitForNodeVolumeDetachStartTime));
  }
  
  public DeletionNested<A> withNewDeletionLike(MachineDeletionStatus item) {
    return new DeletionNested(item);
  }
  
  public NodeInfoNested<A> withNewNodeInfo() {
    return new NodeInfoNested(null);
  }
  
  public NodeInfoNested<A> withNewNodeInfoLike(NodeSystemInfo item) {
    return new NodeInfoNested(item);
  }
  
  public NodeRefNested<A> withNewNodeRef() {
    return new NodeRefNested(null);
  }
  
  public NodeRefNested<A> withNewNodeRefLike(ObjectReference item) {
    return new NodeRefNested(item);
  }
  
  public V1beta2Nested<A> withNewV1beta2() {
    return new V1beta2Nested(null);
  }
  
  public V1beta2Nested<A> withNewV1beta2Like(MachineV1Beta2Status item) {
    return new V1beta2Nested(item);
  }
  
  public A withNodeInfo(NodeSystemInfo nodeInfo) {
    this._visitables.remove("nodeInfo");
    if (nodeInfo != null) {
        this.nodeInfo = new NodeSystemInfoBuilder(nodeInfo);
        this._visitables.get("nodeInfo").add(this.nodeInfo);
    } else {
        this.nodeInfo = null;
        this._visitables.get("nodeInfo").remove(this.nodeInfo);
    }
    return (A) this;
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
  
  public A withObservedGeneration(Long observedGeneration) {
    this.observedGeneration = observedGeneration;
    return (A) this;
  }
  
  public A withPhase(String phase) {
    this.phase = phase;
    return (A) this;
  }
  
  public A withV1beta2(MachineV1Beta2Status v1beta2) {
    this._visitables.remove("v1beta2");
    if (v1beta2 != null) {
        this.v1beta2 = new MachineV1Beta2StatusBuilder(v1beta2);
        this._visitables.get("v1beta2").add(this.v1beta2);
    } else {
        this.v1beta2 = null;
        this._visitables.get("v1beta2").remove(this.v1beta2);
    }
    return (A) this;
  }
  public class AddressesNested<N> extends MachineAddressFluent<AddressesNested<N>> implements Nested<N>{
  
    MachineAddressBuilder builder;
    int index;
  
    AddressesNested(int index,MachineAddress item) {
      this.index = index;
      this.builder = new MachineAddressBuilder(this, item);
    }
  
    public N and() {
      return (N) MachineStatusFluent.this.setToAddresses(index, builder.build());
    }
    
    public N endAddress() {
      return and();
    }
    
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
  public class DeletionNested<N> extends MachineDeletionStatusFluent<DeletionNested<N>> implements Nested<N>{
  
    MachineDeletionStatusBuilder builder;
  
    DeletionNested(MachineDeletionStatus item) {
      this.builder = new MachineDeletionStatusBuilder(this, item);
    }
  
    public N and() {
      return (N) MachineStatusFluent.this.withDeletion(builder.build());
    }
    
    public N endDeletion() {
      return and();
    }
    
  }
  public class NodeInfoNested<N> extends NodeSystemInfoFluent<NodeInfoNested<N>> implements Nested<N>{
  
    NodeSystemInfoBuilder builder;
  
    NodeInfoNested(NodeSystemInfo item) {
      this.builder = new NodeSystemInfoBuilder(this, item);
    }
  
    public N and() {
      return (N) MachineStatusFluent.this.withNodeInfo(builder.build());
    }
    
    public N endNodeInfo() {
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
  public class V1beta2Nested<N> extends MachineV1Beta2StatusFluent<V1beta2Nested<N>> implements Nested<N>{
  
    MachineV1Beta2StatusBuilder builder;
  
    V1beta2Nested(MachineV1Beta2Status item) {
      this.builder = new MachineV1Beta2StatusBuilder(this, item);
    }
  
    public N and() {
      return (N) MachineStatusFluent.this.withV1beta2(builder.build());
    }
    
    public N endV1beta2() {
      return and();
    }
    
  }
}