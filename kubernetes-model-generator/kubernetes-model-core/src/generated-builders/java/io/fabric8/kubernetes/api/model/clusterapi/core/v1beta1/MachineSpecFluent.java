package io.fabric8.kubernetes.api.model.clusterapi.core.v1beta1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import io.fabric8.kubernetes.api.model.Duration;
import io.fabric8.kubernetes.api.model.ObjectReference;
import io.fabric8.kubernetes.api.model.ObjectReferenceBuilder;
import io.fabric8.kubernetes.api.model.ObjectReferenceFluent;
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
public class MachineSpecFluent<A extends io.fabric8.kubernetes.api.model.clusterapi.core.v1beta1.MachineSpecFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private BootstrapBuilder bootstrap;
  private String clusterName;
  private String failureDomain;
  private ObjectReferenceBuilder infrastructureRef;
  private Duration nodeDeletionTimeout;
  private Duration nodeDrainTimeout;
  private Duration nodeVolumeDetachTimeout;
  private String providerID;
  private ArrayList<MachineReadinessGateBuilder> readinessGates = new ArrayList<MachineReadinessGateBuilder>();
  private ArrayList<MachineTaintBuilder> taints = new ArrayList<MachineTaintBuilder>();
  private String version;

  public MachineSpecFluent() {
  }
  
  public MachineSpecFluent(MachineSpec instance) {
    this.copyInstance(instance);
  }

  public A addAllToReadinessGates(Collection<MachineReadinessGate> items) {
    if (this.readinessGates == null) {
      this.readinessGates = new ArrayList();
    }
    for (MachineReadinessGate item : items) {
        MachineReadinessGateBuilder builder = new MachineReadinessGateBuilder(item);
        _visitables.get("readinessGates").add(builder);
        this.readinessGates.add(builder);
    }
    return (A) this;
  }
  
  public A addAllToTaints(Collection<MachineTaint> items) {
    if (this.taints == null) {
      this.taints = new ArrayList();
    }
    for (MachineTaint item : items) {
        MachineTaintBuilder builder = new MachineTaintBuilder(item);
        _visitables.get("taints").add(builder);
        this.taints.add(builder);
    }
    return (A) this;
  }
  
  public ReadinessGatesNested<A> addNewReadinessGate() {
    return new ReadinessGatesNested(-1, null);
  }
  
  public A addNewReadinessGate(String conditionType,String polarity) {
    return (A) this.addToReadinessGates(new MachineReadinessGate(conditionType, polarity));
  }
  
  public ReadinessGatesNested<A> addNewReadinessGateLike(MachineReadinessGate item) {
    return new ReadinessGatesNested(-1, item);
  }
  
  public TaintsNested<A> addNewTaint() {
    return new TaintsNested(-1, null);
  }
  
  public A addNewTaint(String effect,String key,String propagation,String value) {
    return (A) this.addToTaints(new MachineTaint(effect, key, propagation, value));
  }
  
  public TaintsNested<A> addNewTaintLike(MachineTaint item) {
    return new TaintsNested(-1, item);
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
  
  public A addToReadinessGates(MachineReadinessGate... items) {
    if (this.readinessGates == null) {
      this.readinessGates = new ArrayList();
    }
    for (MachineReadinessGate item : items) {
        MachineReadinessGateBuilder builder = new MachineReadinessGateBuilder(item);
        _visitables.get("readinessGates").add(builder);
        this.readinessGates.add(builder);
    }
    return (A) this;
  }
  
  public A addToReadinessGates(int index,MachineReadinessGate item) {
    if (this.readinessGates == null) {
      this.readinessGates = new ArrayList();
    }
    MachineReadinessGateBuilder builder = new MachineReadinessGateBuilder(item);
    if (index < 0 || index >= readinessGates.size()) {
        _visitables.get("readinessGates").add(builder);
        readinessGates.add(builder);
    } else {
        _visitables.get("readinessGates").add(builder);
        readinessGates.add(index, builder);
    }
    return (A) this;
  }
  
  public A addToTaints(MachineTaint... items) {
    if (this.taints == null) {
      this.taints = new ArrayList();
    }
    for (MachineTaint item : items) {
        MachineTaintBuilder builder = new MachineTaintBuilder(item);
        _visitables.get("taints").add(builder);
        this.taints.add(builder);
    }
    return (A) this;
  }
  
  public A addToTaints(int index,MachineTaint item) {
    if (this.taints == null) {
      this.taints = new ArrayList();
    }
    MachineTaintBuilder builder = new MachineTaintBuilder(item);
    if (index < 0 || index >= taints.size()) {
        _visitables.get("taints").add(builder);
        taints.add(builder);
    } else {
        _visitables.get("taints").add(builder);
        taints.add(index, builder);
    }
    return (A) this;
  }
  
  public Bootstrap buildBootstrap() {
    return this.bootstrap != null ? this.bootstrap.build() : null;
  }
  
  public MachineReadinessGate buildFirstReadinessGate() {
    return this.readinessGates.get(0).build();
  }
  
  public MachineTaint buildFirstTaint() {
    return this.taints.get(0).build();
  }
  
  public ObjectReference buildInfrastructureRef() {
    return this.infrastructureRef != null ? this.infrastructureRef.build() : null;
  }
  
  public MachineReadinessGate buildLastReadinessGate() {
    return this.readinessGates.get(readinessGates.size() - 1).build();
  }
  
  public MachineTaint buildLastTaint() {
    return this.taints.get(taints.size() - 1).build();
  }
  
  public MachineReadinessGate buildMatchingReadinessGate(Predicate<MachineReadinessGateBuilder> predicate) {
      for (MachineReadinessGateBuilder item : readinessGates) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public MachineTaint buildMatchingTaint(Predicate<MachineTaintBuilder> predicate) {
      for (MachineTaintBuilder item : taints) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public MachineReadinessGate buildReadinessGate(int index) {
    return this.readinessGates.get(index).build();
  }
  
  public List<MachineReadinessGate> buildReadinessGates() {
    return this.readinessGates != null ? build(readinessGates) : null;
  }
  
  public MachineTaint buildTaint(int index) {
    return this.taints.get(index).build();
  }
  
  public List<MachineTaint> buildTaints() {
    return this.taints != null ? build(taints) : null;
  }
  
  protected void copyInstance(MachineSpec instance) {
    instance = instance != null ? instance : new MachineSpec();
    if (instance != null) {
        this.withBootstrap(instance.getBootstrap());
        this.withClusterName(instance.getClusterName());
        this.withFailureDomain(instance.getFailureDomain());
        this.withInfrastructureRef(instance.getInfrastructureRef());
        this.withNodeDeletionTimeout(instance.getNodeDeletionTimeout());
        this.withNodeDrainTimeout(instance.getNodeDrainTimeout());
        this.withNodeVolumeDetachTimeout(instance.getNodeVolumeDetachTimeout());
        this.withProviderID(instance.getProviderID());
        this.withReadinessGates(instance.getReadinessGates());
        this.withTaints(instance.getTaints());
        this.withVersion(instance.getVersion());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public BootstrapNested<A> editBootstrap() {
    return this.withNewBootstrapLike(Optional.ofNullable(this.buildBootstrap()).orElse(null));
  }
  
  public ReadinessGatesNested<A> editFirstReadinessGate() {
    if (readinessGates.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "readinessGates"));
    }
    return this.setNewReadinessGateLike(0, this.buildReadinessGate(0));
  }
  
  public TaintsNested<A> editFirstTaint() {
    if (taints.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "taints"));
    }
    return this.setNewTaintLike(0, this.buildTaint(0));
  }
  
  public InfrastructureRefNested<A> editInfrastructureRef() {
    return this.withNewInfrastructureRefLike(Optional.ofNullable(this.buildInfrastructureRef()).orElse(null));
  }
  
  public ReadinessGatesNested<A> editLastReadinessGate() {
    int index = readinessGates.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "readinessGates"));
    }
    return this.setNewReadinessGateLike(index, this.buildReadinessGate(index));
  }
  
  public TaintsNested<A> editLastTaint() {
    int index = taints.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "taints"));
    }
    return this.setNewTaintLike(index, this.buildTaint(index));
  }
  
  public ReadinessGatesNested<A> editMatchingReadinessGate(Predicate<MachineReadinessGateBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < readinessGates.size();i++) {
      if (predicate.test(readinessGates.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "readinessGates"));
    }
    return this.setNewReadinessGateLike(index, this.buildReadinessGate(index));
  }
  
  public TaintsNested<A> editMatchingTaint(Predicate<MachineTaintBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < taints.size();i++) {
      if (predicate.test(taints.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "taints"));
    }
    return this.setNewTaintLike(index, this.buildTaint(index));
  }
  
  public BootstrapNested<A> editOrNewBootstrap() {
    return this.withNewBootstrapLike(Optional.ofNullable(this.buildBootstrap()).orElse(new BootstrapBuilder().build()));
  }
  
  public BootstrapNested<A> editOrNewBootstrapLike(Bootstrap item) {
    return this.withNewBootstrapLike(Optional.ofNullable(this.buildBootstrap()).orElse(item));
  }
  
  public InfrastructureRefNested<A> editOrNewInfrastructureRef() {
    return this.withNewInfrastructureRefLike(Optional.ofNullable(this.buildInfrastructureRef()).orElse(new ObjectReferenceBuilder().build()));
  }
  
  public InfrastructureRefNested<A> editOrNewInfrastructureRefLike(ObjectReference item) {
    return this.withNewInfrastructureRefLike(Optional.ofNullable(this.buildInfrastructureRef()).orElse(item));
  }
  
  public ReadinessGatesNested<A> editReadinessGate(int index) {
    if (readinessGates.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "readinessGates"));
    }
    return this.setNewReadinessGateLike(index, this.buildReadinessGate(index));
  }
  
  public TaintsNested<A> editTaint(int index) {
    if (taints.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "taints"));
    }
    return this.setNewTaintLike(index, this.buildTaint(index));
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
    MachineSpecFluent that = (MachineSpecFluent) o;
    if (!(Objects.equals(bootstrap, that.bootstrap))) {
      return false;
    }
    if (!(Objects.equals(clusterName, that.clusterName))) {
      return false;
    }
    if (!(Objects.equals(failureDomain, that.failureDomain))) {
      return false;
    }
    if (!(Objects.equals(infrastructureRef, that.infrastructureRef))) {
      return false;
    }
    if (!(Objects.equals(nodeDeletionTimeout, that.nodeDeletionTimeout))) {
      return false;
    }
    if (!(Objects.equals(nodeDrainTimeout, that.nodeDrainTimeout))) {
      return false;
    }
    if (!(Objects.equals(nodeVolumeDetachTimeout, that.nodeVolumeDetachTimeout))) {
      return false;
    }
    if (!(Objects.equals(providerID, that.providerID))) {
      return false;
    }
    if (!(Objects.equals(readinessGates, that.readinessGates))) {
      return false;
    }
    if (!(Objects.equals(taints, that.taints))) {
      return false;
    }
    if (!(Objects.equals(version, that.version))) {
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
  
  public String getClusterName() {
    return this.clusterName;
  }
  
  public String getFailureDomain() {
    return this.failureDomain;
  }
  
  public Duration getNodeDeletionTimeout() {
    return this.nodeDeletionTimeout;
  }
  
  public Duration getNodeDrainTimeout() {
    return this.nodeDrainTimeout;
  }
  
  public Duration getNodeVolumeDetachTimeout() {
    return this.nodeVolumeDetachTimeout;
  }
  
  public String getProviderID() {
    return this.providerID;
  }
  
  public String getVersion() {
    return this.version;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasBootstrap() {
    return this.bootstrap != null;
  }
  
  public boolean hasClusterName() {
    return this.clusterName != null;
  }
  
  public boolean hasFailureDomain() {
    return this.failureDomain != null;
  }
  
  public boolean hasInfrastructureRef() {
    return this.infrastructureRef != null;
  }
  
  public boolean hasMatchingReadinessGate(Predicate<MachineReadinessGateBuilder> predicate) {
      for (MachineReadinessGateBuilder item : readinessGates) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingTaint(Predicate<MachineTaintBuilder> predicate) {
      for (MachineTaintBuilder item : taints) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasNodeDeletionTimeout() {
    return this.nodeDeletionTimeout != null;
  }
  
  public boolean hasNodeDrainTimeout() {
    return this.nodeDrainTimeout != null;
  }
  
  public boolean hasNodeVolumeDetachTimeout() {
    return this.nodeVolumeDetachTimeout != null;
  }
  
  public boolean hasProviderID() {
    return this.providerID != null;
  }
  
  public boolean hasReadinessGates() {
    return this.readinessGates != null && !(this.readinessGates.isEmpty());
  }
  
  public boolean hasTaints() {
    return this.taints != null && !(this.taints.isEmpty());
  }
  
  public boolean hasVersion() {
    return this.version != null;
  }
  
  public int hashCode() {
    return Objects.hash(bootstrap, clusterName, failureDomain, infrastructureRef, nodeDeletionTimeout, nodeDrainTimeout, nodeVolumeDetachTimeout, providerID, readinessGates, taints, version, additionalProperties);
  }
  
  public A removeAllFromReadinessGates(Collection<MachineReadinessGate> items) {
    if (this.readinessGates == null) {
      return (A) this;
    }
    for (MachineReadinessGate item : items) {
        MachineReadinessGateBuilder builder = new MachineReadinessGateBuilder(item);
        _visitables.get("readinessGates").remove(builder);
        this.readinessGates.remove(builder);
    }
    return (A) this;
  }
  
  public A removeAllFromTaints(Collection<MachineTaint> items) {
    if (this.taints == null) {
      return (A) this;
    }
    for (MachineTaint item : items) {
        MachineTaintBuilder builder = new MachineTaintBuilder(item);
        _visitables.get("taints").remove(builder);
        this.taints.remove(builder);
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
  
  public A removeFromReadinessGates(MachineReadinessGate... items) {
    if (this.readinessGates == null) {
      return (A) this;
    }
    for (MachineReadinessGate item : items) {
        MachineReadinessGateBuilder builder = new MachineReadinessGateBuilder(item);
        _visitables.get("readinessGates").remove(builder);
        this.readinessGates.remove(builder);
    }
    return (A) this;
  }
  
  public A removeFromTaints(MachineTaint... items) {
    if (this.taints == null) {
      return (A) this;
    }
    for (MachineTaint item : items) {
        MachineTaintBuilder builder = new MachineTaintBuilder(item);
        _visitables.get("taints").remove(builder);
        this.taints.remove(builder);
    }
    return (A) this;
  }
  
  public A removeMatchingFromReadinessGates(Predicate<MachineReadinessGateBuilder> predicate) {
    if (readinessGates == null) {
      return (A) this;
    }
    Iterator<MachineReadinessGateBuilder> each = readinessGates.iterator();
    List visitables = _visitables.get("readinessGates");
    while (each.hasNext()) {
        MachineReadinessGateBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public A removeMatchingFromTaints(Predicate<MachineTaintBuilder> predicate) {
    if (taints == null) {
      return (A) this;
    }
    Iterator<MachineTaintBuilder> each = taints.iterator();
    List visitables = _visitables.get("taints");
    while (each.hasNext()) {
        MachineTaintBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public ReadinessGatesNested<A> setNewReadinessGateLike(int index,MachineReadinessGate item) {
    return new ReadinessGatesNested(index, item);
  }
  
  public TaintsNested<A> setNewTaintLike(int index,MachineTaint item) {
    return new TaintsNested(index, item);
  }
  
  public A setToReadinessGates(int index,MachineReadinessGate item) {
    if (this.readinessGates == null) {
      this.readinessGates = new ArrayList();
    }
    MachineReadinessGateBuilder builder = new MachineReadinessGateBuilder(item);
    if (index < 0 || index >= readinessGates.size()) {
        _visitables.get("readinessGates").add(builder);
        readinessGates.add(builder);
    } else {
        _visitables.get("readinessGates").add(builder);
        readinessGates.set(index, builder);
    }
    return (A) this;
  }
  
  public A setToTaints(int index,MachineTaint item) {
    if (this.taints == null) {
      this.taints = new ArrayList();
    }
    MachineTaintBuilder builder = new MachineTaintBuilder(item);
    if (index < 0 || index >= taints.size()) {
        _visitables.get("taints").add(builder);
        taints.add(builder);
    } else {
        _visitables.get("taints").add(builder);
        taints.set(index, builder);
    }
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(bootstrap == null)) {
        sb.append("bootstrap:");
        sb.append(bootstrap);
        sb.append(",");
    }
    if (!(clusterName == null)) {
        sb.append("clusterName:");
        sb.append(clusterName);
        sb.append(",");
    }
    if (!(failureDomain == null)) {
        sb.append("failureDomain:");
        sb.append(failureDomain);
        sb.append(",");
    }
    if (!(infrastructureRef == null)) {
        sb.append("infrastructureRef:");
        sb.append(infrastructureRef);
        sb.append(",");
    }
    if (!(nodeDeletionTimeout == null)) {
        sb.append("nodeDeletionTimeout:");
        sb.append(nodeDeletionTimeout);
        sb.append(",");
    }
    if (!(nodeDrainTimeout == null)) {
        sb.append("nodeDrainTimeout:");
        sb.append(nodeDrainTimeout);
        sb.append(",");
    }
    if (!(nodeVolumeDetachTimeout == null)) {
        sb.append("nodeVolumeDetachTimeout:");
        sb.append(nodeVolumeDetachTimeout);
        sb.append(",");
    }
    if (!(providerID == null)) {
        sb.append("providerID:");
        sb.append(providerID);
        sb.append(",");
    }
    if (!(readinessGates == null) && !(readinessGates.isEmpty())) {
        sb.append("readinessGates:");
        sb.append(readinessGates);
        sb.append(",");
    }
    if (!(taints == null) && !(taints.isEmpty())) {
        sb.append("taints:");
        sb.append(taints);
        sb.append(",");
    }
    if (!(version == null)) {
        sb.append("version:");
        sb.append(version);
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
  
  public A withBootstrap(Bootstrap bootstrap) {
    this._visitables.remove("bootstrap");
    if (bootstrap != null) {
        this.bootstrap = new BootstrapBuilder(bootstrap);
        this._visitables.get("bootstrap").add(this.bootstrap);
    } else {
        this.bootstrap = null;
        this._visitables.get("bootstrap").remove(this.bootstrap);
    }
    return (A) this;
  }
  
  public A withClusterName(String clusterName) {
    this.clusterName = clusterName;
    return (A) this;
  }
  
  public A withFailureDomain(String failureDomain) {
    this.failureDomain = failureDomain;
    return (A) this;
  }
  
  public A withInfrastructureRef(ObjectReference infrastructureRef) {
    this._visitables.remove("infrastructureRef");
    if (infrastructureRef != null) {
        this.infrastructureRef = new ObjectReferenceBuilder(infrastructureRef);
        this._visitables.get("infrastructureRef").add(this.infrastructureRef);
    } else {
        this.infrastructureRef = null;
        this._visitables.get("infrastructureRef").remove(this.infrastructureRef);
    }
    return (A) this;
  }
  
  public BootstrapNested<A> withNewBootstrap() {
    return new BootstrapNested(null);
  }
  
  public BootstrapNested<A> withNewBootstrapLike(Bootstrap item) {
    return new BootstrapNested(item);
  }
  
  public InfrastructureRefNested<A> withNewInfrastructureRef() {
    return new InfrastructureRefNested(null);
  }
  
  public InfrastructureRefNested<A> withNewInfrastructureRefLike(ObjectReference item) {
    return new InfrastructureRefNested(item);
  }
  
  public A withNodeDeletionTimeout(Duration nodeDeletionTimeout) {
    this.nodeDeletionTimeout = nodeDeletionTimeout;
    return (A) this;
  }
  
  public A withNodeDrainTimeout(Duration nodeDrainTimeout) {
    this.nodeDrainTimeout = nodeDrainTimeout;
    return (A) this;
  }
  
  public A withNodeVolumeDetachTimeout(Duration nodeVolumeDetachTimeout) {
    this.nodeVolumeDetachTimeout = nodeVolumeDetachTimeout;
    return (A) this;
  }
  
  public A withProviderID(String providerID) {
    this.providerID = providerID;
    return (A) this;
  }
  
  public A withReadinessGates(List<MachineReadinessGate> readinessGates) {
    if (this.readinessGates != null) {
      this._visitables.get("readinessGates").clear();
    }
    if (readinessGates != null) {
        this.readinessGates = new ArrayList();
        for (MachineReadinessGate item : readinessGates) {
          this.addToReadinessGates(item);
        }
    } else {
      this.readinessGates = null;
    }
    return (A) this;
  }
  
  public A withReadinessGates(MachineReadinessGate... readinessGates) {
    if (this.readinessGates != null) {
        this.readinessGates.clear();
        _visitables.remove("readinessGates");
    }
    if (readinessGates != null) {
      for (MachineReadinessGate item : readinessGates) {
        this.addToReadinessGates(item);
      }
    }
    return (A) this;
  }
  
  public A withTaints(List<MachineTaint> taints) {
    if (this.taints != null) {
      this._visitables.get("taints").clear();
    }
    if (taints != null) {
        this.taints = new ArrayList();
        for (MachineTaint item : taints) {
          this.addToTaints(item);
        }
    } else {
      this.taints = null;
    }
    return (A) this;
  }
  
  public A withTaints(MachineTaint... taints) {
    if (this.taints != null) {
        this.taints.clear();
        _visitables.remove("taints");
    }
    if (taints != null) {
      for (MachineTaint item : taints) {
        this.addToTaints(item);
      }
    }
    return (A) this;
  }
  
  public A withVersion(String version) {
    this.version = version;
    return (A) this;
  }
  public class BootstrapNested<N> extends BootstrapFluent<BootstrapNested<N>> implements Nested<N>{
  
    BootstrapBuilder builder;
  
    BootstrapNested(Bootstrap item) {
      this.builder = new BootstrapBuilder(this, item);
    }
  
    public N and() {
      return (N) MachineSpecFluent.this.withBootstrap(builder.build());
    }
    
    public N endBootstrap() {
      return and();
    }
    
  }
  public class InfrastructureRefNested<N> extends ObjectReferenceFluent<InfrastructureRefNested<N>> implements Nested<N>{
  
    ObjectReferenceBuilder builder;
  
    InfrastructureRefNested(ObjectReference item) {
      this.builder = new ObjectReferenceBuilder(this, item);
    }
  
    public N and() {
      return (N) MachineSpecFluent.this.withInfrastructureRef(builder.build());
    }
    
    public N endInfrastructureRef() {
      return and();
    }
    
  }
  public class ReadinessGatesNested<N> extends MachineReadinessGateFluent<ReadinessGatesNested<N>> implements Nested<N>{
  
    MachineReadinessGateBuilder builder;
    int index;
  
    ReadinessGatesNested(int index,MachineReadinessGate item) {
      this.index = index;
      this.builder = new MachineReadinessGateBuilder(this, item);
    }
  
    public N and() {
      return (N) MachineSpecFluent.this.setToReadinessGates(index, builder.build());
    }
    
    public N endReadinessGate() {
      return and();
    }
    
  }
  public class TaintsNested<N> extends MachineTaintFluent<TaintsNested<N>> implements Nested<N>{
  
    MachineTaintBuilder builder;
    int index;
  
    TaintsNested(int index,MachineTaint item) {
      this.index = index;
      this.builder = new MachineTaintBuilder(this, item);
    }
  
    public N and() {
      return (N) MachineSpecFluent.this.setToTaints(index, builder.build());
    }
    
    public N endTaint() {
      return and();
    }
    
  }
}