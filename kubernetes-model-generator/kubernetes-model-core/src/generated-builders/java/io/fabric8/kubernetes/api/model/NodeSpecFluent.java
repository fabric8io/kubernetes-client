package io.fabric8.kubernetes.api.model;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import java.lang.Boolean;
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
public class NodeSpecFluent<A extends io.fabric8.kubernetes.api.model.NodeSpecFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private NodeConfigSourceBuilder configSource;
  private String externalID;
  private String podCIDR;
  private List<String> podCIDRs = new ArrayList<String>();
  private String providerID;
  private ArrayList<TaintBuilder> taints = new ArrayList<TaintBuilder>();
  private Boolean unschedulable;

  public NodeSpecFluent() {
  }
  
  public NodeSpecFluent(NodeSpec instance) {
    this.copyInstance(instance);
  }

  public A addAllToPodCIDRs(Collection<String> items) {
    if (this.podCIDRs == null) {
      this.podCIDRs = new ArrayList();
    }
    for (String item : items) {
      this.podCIDRs.add(item);
    }
    return (A) this;
  }
  
  public A addAllToTaints(Collection<Taint> items) {
    if (this.taints == null) {
      this.taints = new ArrayList();
    }
    for (Taint item : items) {
        TaintBuilder builder = new TaintBuilder(item);
        _visitables.get("taints").add(builder);
        this.taints.add(builder);
    }
    return (A) this;
  }
  
  public TaintsNested<A> addNewTaint() {
    return new TaintsNested(-1, null);
  }
  
  public A addNewTaint(String effect,String key,String timeAdded,String value) {
    return (A) this.addToTaints(new Taint(effect, key, timeAdded, value));
  }
  
  public TaintsNested<A> addNewTaintLike(Taint item) {
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
  
  public A addToPodCIDRs(String... items) {
    if (this.podCIDRs == null) {
      this.podCIDRs = new ArrayList();
    }
    for (String item : items) {
      this.podCIDRs.add(item);
    }
    return (A) this;
  }
  
  public A addToPodCIDRs(int index,String item) {
    if (this.podCIDRs == null) {
      this.podCIDRs = new ArrayList();
    }
    this.podCIDRs.add(index, item);
    return (A) this;
  }
  
  public A addToTaints(Taint... items) {
    if (this.taints == null) {
      this.taints = new ArrayList();
    }
    for (Taint item : items) {
        TaintBuilder builder = new TaintBuilder(item);
        _visitables.get("taints").add(builder);
        this.taints.add(builder);
    }
    return (A) this;
  }
  
  public A addToTaints(int index,Taint item) {
    if (this.taints == null) {
      this.taints = new ArrayList();
    }
    TaintBuilder builder = new TaintBuilder(item);
    if (index < 0 || index >= taints.size()) {
        _visitables.get("taints").add(builder);
        taints.add(builder);
    } else {
        _visitables.get("taints").add(builder);
        taints.add(index, builder);
    }
    return (A) this;
  }
  
  public NodeConfigSource buildConfigSource() {
    return this.configSource != null ? this.configSource.build() : null;
  }
  
  public Taint buildFirstTaint() {
    return this.taints.get(0).build();
  }
  
  public Taint buildLastTaint() {
    return this.taints.get(taints.size() - 1).build();
  }
  
  public Taint buildMatchingTaint(Predicate<TaintBuilder> predicate) {
      for (TaintBuilder item : taints) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public Taint buildTaint(int index) {
    return this.taints.get(index).build();
  }
  
  public List<Taint> buildTaints() {
    return this.taints != null ? build(taints) : null;
  }
  
  protected void copyInstance(NodeSpec instance) {
    instance = instance != null ? instance : new NodeSpec();
    if (instance != null) {
        this.withConfigSource(instance.getConfigSource());
        this.withExternalID(instance.getExternalID());
        this.withPodCIDR(instance.getPodCIDR());
        this.withPodCIDRs(instance.getPodCIDRs());
        this.withProviderID(instance.getProviderID());
        this.withTaints(instance.getTaints());
        this.withUnschedulable(instance.getUnschedulable());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public ConfigSourceNested<A> editConfigSource() {
    return this.withNewConfigSourceLike(Optional.ofNullable(this.buildConfigSource()).orElse(null));
  }
  
  public TaintsNested<A> editFirstTaint() {
    if (taints.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "taints"));
    }
    return this.setNewTaintLike(0, this.buildTaint(0));
  }
  
  public TaintsNested<A> editLastTaint() {
    int index = taints.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "taints"));
    }
    return this.setNewTaintLike(index, this.buildTaint(index));
  }
  
  public TaintsNested<A> editMatchingTaint(Predicate<TaintBuilder> predicate) {
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
  
  public ConfigSourceNested<A> editOrNewConfigSource() {
    return this.withNewConfigSourceLike(Optional.ofNullable(this.buildConfigSource()).orElse(new NodeConfigSourceBuilder().build()));
  }
  
  public ConfigSourceNested<A> editOrNewConfigSourceLike(NodeConfigSource item) {
    return this.withNewConfigSourceLike(Optional.ofNullable(this.buildConfigSource()).orElse(item));
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
    NodeSpecFluent that = (NodeSpecFluent) o;
    if (!(Objects.equals(configSource, that.configSource))) {
      return false;
    }
    if (!(Objects.equals(externalID, that.externalID))) {
      return false;
    }
    if (!(Objects.equals(podCIDR, that.podCIDR))) {
      return false;
    }
    if (!(Objects.equals(podCIDRs, that.podCIDRs))) {
      return false;
    }
    if (!(Objects.equals(providerID, that.providerID))) {
      return false;
    }
    if (!(Objects.equals(taints, that.taints))) {
      return false;
    }
    if (!(Objects.equals(unschedulable, that.unschedulable))) {
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
  
  public String getExternalID() {
    return this.externalID;
  }
  
  public String getFirstPodCIDR() {
    return this.podCIDRs.get(0);
  }
  
  public String getLastPodCIDR() {
    return this.podCIDRs.get(podCIDRs.size() - 1);
  }
  
  public String getMatchingPodCIDR(Predicate<String> predicate) {
      for (String item : podCIDRs) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public String getPodCIDR() {
    return this.podCIDR;
  }
  
  public String getPodCIDR(int index) {
    return this.podCIDRs.get(index);
  }
  
  public List<String> getPodCIDRs() {
    return this.podCIDRs;
  }
  
  public String getProviderID() {
    return this.providerID;
  }
  
  public Boolean getUnschedulable() {
    return this.unschedulable;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasConfigSource() {
    return this.configSource != null;
  }
  
  public boolean hasExternalID() {
    return this.externalID != null;
  }
  
  public boolean hasMatchingPodCIDR(Predicate<String> predicate) {
      for (String item : podCIDRs) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingTaint(Predicate<TaintBuilder> predicate) {
      for (TaintBuilder item : taints) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasPodCIDR() {
    return this.podCIDR != null;
  }
  
  public boolean hasPodCIDRs() {
    return this.podCIDRs != null && !(this.podCIDRs.isEmpty());
  }
  
  public boolean hasProviderID() {
    return this.providerID != null;
  }
  
  public boolean hasTaints() {
    return this.taints != null && !(this.taints.isEmpty());
  }
  
  public boolean hasUnschedulable() {
    return this.unschedulable != null;
  }
  
  public int hashCode() {
    return Objects.hash(configSource, externalID, podCIDR, podCIDRs, providerID, taints, unschedulable, additionalProperties);
  }
  
  public A removeAllFromPodCIDRs(Collection<String> items) {
    if (this.podCIDRs == null) {
      return (A) this;
    }
    for (String item : items) {
      this.podCIDRs.remove(item);
    }
    return (A) this;
  }
  
  public A removeAllFromTaints(Collection<Taint> items) {
    if (this.taints == null) {
      return (A) this;
    }
    for (Taint item : items) {
        TaintBuilder builder = new TaintBuilder(item);
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
  
  public A removeFromPodCIDRs(String... items) {
    if (this.podCIDRs == null) {
      return (A) this;
    }
    for (String item : items) {
      this.podCIDRs.remove(item);
    }
    return (A) this;
  }
  
  public A removeFromTaints(Taint... items) {
    if (this.taints == null) {
      return (A) this;
    }
    for (Taint item : items) {
        TaintBuilder builder = new TaintBuilder(item);
        _visitables.get("taints").remove(builder);
        this.taints.remove(builder);
    }
    return (A) this;
  }
  
  public A removeMatchingFromTaints(Predicate<TaintBuilder> predicate) {
    if (taints == null) {
      return (A) this;
    }
    Iterator<TaintBuilder> each = taints.iterator();
    List visitables = _visitables.get("taints");
    while (each.hasNext()) {
        TaintBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public TaintsNested<A> setNewTaintLike(int index,Taint item) {
    return new TaintsNested(index, item);
  }
  
  public A setToPodCIDRs(int index,String item) {
    if (this.podCIDRs == null) {
      this.podCIDRs = new ArrayList();
    }
    this.podCIDRs.set(index, item);
    return (A) this;
  }
  
  public A setToTaints(int index,Taint item) {
    if (this.taints == null) {
      this.taints = new ArrayList();
    }
    TaintBuilder builder = new TaintBuilder(item);
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
    if (!(configSource == null)) {
        sb.append("configSource:");
        sb.append(configSource);
        sb.append(",");
    }
    if (!(externalID == null)) {
        sb.append("externalID:");
        sb.append(externalID);
        sb.append(",");
    }
    if (!(podCIDR == null)) {
        sb.append("podCIDR:");
        sb.append(podCIDR);
        sb.append(",");
    }
    if (!(podCIDRs == null) && !(podCIDRs.isEmpty())) {
        sb.append("podCIDRs:");
        sb.append(podCIDRs);
        sb.append(",");
    }
    if (!(providerID == null)) {
        sb.append("providerID:");
        sb.append(providerID);
        sb.append(",");
    }
    if (!(taints == null) && !(taints.isEmpty())) {
        sb.append("taints:");
        sb.append(taints);
        sb.append(",");
    }
    if (!(unschedulable == null)) {
        sb.append("unschedulable:");
        sb.append(unschedulable);
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
  
  public A withConfigSource(NodeConfigSource configSource) {
    this._visitables.remove("configSource");
    if (configSource != null) {
        this.configSource = new NodeConfigSourceBuilder(configSource);
        this._visitables.get("configSource").add(this.configSource);
    } else {
        this.configSource = null;
        this._visitables.get("configSource").remove(this.configSource);
    }
    return (A) this;
  }
  
  public A withExternalID(String externalID) {
    this.externalID = externalID;
    return (A) this;
  }
  
  public ConfigSourceNested<A> withNewConfigSource() {
    return new ConfigSourceNested(null);
  }
  
  public ConfigSourceNested<A> withNewConfigSourceLike(NodeConfigSource item) {
    return new ConfigSourceNested(item);
  }
  
  public A withPodCIDR(String podCIDR) {
    this.podCIDR = podCIDR;
    return (A) this;
  }
  
  public A withPodCIDRs(List<String> podCIDRs) {
    if (podCIDRs != null) {
        this.podCIDRs = new ArrayList();
        for (String item : podCIDRs) {
          this.addToPodCIDRs(item);
        }
    } else {
      this.podCIDRs = null;
    }
    return (A) this;
  }
  
  public A withPodCIDRs(String... podCIDRs) {
    if (this.podCIDRs != null) {
        this.podCIDRs.clear();
        _visitables.remove("podCIDRs");
    }
    if (podCIDRs != null) {
      for (String item : podCIDRs) {
        this.addToPodCIDRs(item);
      }
    }
    return (A) this;
  }
  
  public A withProviderID(String providerID) {
    this.providerID = providerID;
    return (A) this;
  }
  
  public A withTaints(List<Taint> taints) {
    if (this.taints != null) {
      this._visitables.get("taints").clear();
    }
    if (taints != null) {
        this.taints = new ArrayList();
        for (Taint item : taints) {
          this.addToTaints(item);
        }
    } else {
      this.taints = null;
    }
    return (A) this;
  }
  
  public A withTaints(Taint... taints) {
    if (this.taints != null) {
        this.taints.clear();
        _visitables.remove("taints");
    }
    if (taints != null) {
      for (Taint item : taints) {
        this.addToTaints(item);
      }
    }
    return (A) this;
  }
  
  public A withUnschedulable() {
    return withUnschedulable(true);
  }
  
  public A withUnschedulable(Boolean unschedulable) {
    this.unschedulable = unschedulable;
    return (A) this;
  }
  public class ConfigSourceNested<N> extends NodeConfigSourceFluent<ConfigSourceNested<N>> implements Nested<N>{
  
    NodeConfigSourceBuilder builder;
  
    ConfigSourceNested(NodeConfigSource item) {
      this.builder = new NodeConfigSourceBuilder(this, item);
    }
  
    public N and() {
      return (N) NodeSpecFluent.this.withConfigSource(builder.build());
    }
    
    public N endConfigSource() {
      return and();
    }
    
  }
  public class TaintsNested<N> extends TaintFluent<TaintsNested<N>> implements Nested<N>{
  
    TaintBuilder builder;
    int index;
  
    TaintsNested(int index,Taint item) {
      this.index = index;
      this.builder = new TaintBuilder(this, item);
    }
  
    public N and() {
      return (N) NodeSpecFluent.this.setToTaints(index, builder.build());
    }
    
    public N endTaint() {
      return and();
    }
    
  }
}