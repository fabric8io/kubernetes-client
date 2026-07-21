package io.fabric8.istio.api.api.networking.v1alpha3;

import io.fabric8.istio.api.api.type.v1beta1.WorkloadSelector;
import io.fabric8.istio.api.api.type.v1beta1.WorkloadSelectorBuilder;
import io.fabric8.istio.api.api.type.v1beta1.WorkloadSelectorFluent;
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
import java.util.Optional;
import java.util.function.Predicate;

/**
 * Generated
 */
@SuppressWarnings("unchecked")
public class DestinationRuleFluent<A extends io.fabric8.istio.api.api.networking.v1alpha3.DestinationRuleFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private List<String> exportTo = new ArrayList<String>();
  private String host;
  private ArrayList<SubsetBuilder> subsets = new ArrayList<SubsetBuilder>();
  private TrafficPolicyBuilder trafficPolicy;
  private WorkloadSelectorBuilder workloadSelector;

  public DestinationRuleFluent() {
  }
  
  public DestinationRuleFluent(DestinationRule instance) {
    this.copyInstance(instance);
  }

  public A addAllToExportTo(Collection<String> items) {
    if (this.exportTo == null) {
      this.exportTo = new ArrayList();
    }
    for (String item : items) {
      this.exportTo.add(item);
    }
    return (A) this;
  }
  
  public A addAllToSubsets(Collection<Subset> items) {
    if (this.subsets == null) {
      this.subsets = new ArrayList();
    }
    for (Subset item : items) {
        SubsetBuilder builder = new SubsetBuilder(item);
        _visitables.get("subsets").add(builder);
        this.subsets.add(builder);
    }
    return (A) this;
  }
  
  public SubsetsNested<A> addNewSubset() {
    return new SubsetsNested(-1, null);
  }
  
  public SubsetsNested<A> addNewSubsetLike(Subset item) {
    return new SubsetsNested(-1, item);
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
  
  public A addToExportTo(String... items) {
    if (this.exportTo == null) {
      this.exportTo = new ArrayList();
    }
    for (String item : items) {
      this.exportTo.add(item);
    }
    return (A) this;
  }
  
  public A addToExportTo(int index,String item) {
    if (this.exportTo == null) {
      this.exportTo = new ArrayList();
    }
    this.exportTo.add(index, item);
    return (A) this;
  }
  
  public A addToSubsets(Subset... items) {
    if (this.subsets == null) {
      this.subsets = new ArrayList();
    }
    for (Subset item : items) {
        SubsetBuilder builder = new SubsetBuilder(item);
        _visitables.get("subsets").add(builder);
        this.subsets.add(builder);
    }
    return (A) this;
  }
  
  public A addToSubsets(int index,Subset item) {
    if (this.subsets == null) {
      this.subsets = new ArrayList();
    }
    SubsetBuilder builder = new SubsetBuilder(item);
    if (index < 0 || index >= subsets.size()) {
        _visitables.get("subsets").add(builder);
        subsets.add(builder);
    } else {
        _visitables.get("subsets").add(builder);
        subsets.add(index, builder);
    }
    return (A) this;
  }
  
  public Subset buildFirstSubset() {
    return this.subsets.get(0).build();
  }
  
  public Subset buildLastSubset() {
    return this.subsets.get(subsets.size() - 1).build();
  }
  
  public Subset buildMatchingSubset(Predicate<SubsetBuilder> predicate) {
      for (SubsetBuilder item : subsets) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public Subset buildSubset(int index) {
    return this.subsets.get(index).build();
  }
  
  public List<Subset> buildSubsets() {
    return this.subsets != null ? build(subsets) : null;
  }
  
  public TrafficPolicy buildTrafficPolicy() {
    return this.trafficPolicy != null ? this.trafficPolicy.build() : null;
  }
  
  public WorkloadSelector buildWorkloadSelector() {
    return this.workloadSelector != null ? this.workloadSelector.build() : null;
  }
  
  protected void copyInstance(DestinationRule instance) {
    instance = instance != null ? instance : new DestinationRule();
    if (instance != null) {
        this.withExportTo(instance.getExportTo());
        this.withHost(instance.getHost());
        this.withSubsets(instance.getSubsets());
        this.withTrafficPolicy(instance.getTrafficPolicy());
        this.withWorkloadSelector(instance.getWorkloadSelector());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public SubsetsNested<A> editFirstSubset() {
    if (subsets.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "subsets"));
    }
    return this.setNewSubsetLike(0, this.buildSubset(0));
  }
  
  public SubsetsNested<A> editLastSubset() {
    int index = subsets.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "subsets"));
    }
    return this.setNewSubsetLike(index, this.buildSubset(index));
  }
  
  public SubsetsNested<A> editMatchingSubset(Predicate<SubsetBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < subsets.size();i++) {
      if (predicate.test(subsets.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "subsets"));
    }
    return this.setNewSubsetLike(index, this.buildSubset(index));
  }
  
  public TrafficPolicyNested<A> editOrNewTrafficPolicy() {
    return this.withNewTrafficPolicyLike(Optional.ofNullable(this.buildTrafficPolicy()).orElse(new TrafficPolicyBuilder().build()));
  }
  
  public TrafficPolicyNested<A> editOrNewTrafficPolicyLike(TrafficPolicy item) {
    return this.withNewTrafficPolicyLike(Optional.ofNullable(this.buildTrafficPolicy()).orElse(item));
  }
  
  public WorkloadSelectorNested<A> editOrNewWorkloadSelector() {
    return this.withNewWorkloadSelectorLike(Optional.ofNullable(this.buildWorkloadSelector()).orElse(new WorkloadSelectorBuilder().build()));
  }
  
  public WorkloadSelectorNested<A> editOrNewWorkloadSelectorLike(WorkloadSelector item) {
    return this.withNewWorkloadSelectorLike(Optional.ofNullable(this.buildWorkloadSelector()).orElse(item));
  }
  
  public SubsetsNested<A> editSubset(int index) {
    if (subsets.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "subsets"));
    }
    return this.setNewSubsetLike(index, this.buildSubset(index));
  }
  
  public TrafficPolicyNested<A> editTrafficPolicy() {
    return this.withNewTrafficPolicyLike(Optional.ofNullable(this.buildTrafficPolicy()).orElse(null));
  }
  
  public WorkloadSelectorNested<A> editWorkloadSelector() {
    return this.withNewWorkloadSelectorLike(Optional.ofNullable(this.buildWorkloadSelector()).orElse(null));
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
    DestinationRuleFluent that = (DestinationRuleFluent) o;
    if (!(Objects.equals(exportTo, that.exportTo))) {
      return false;
    }
    if (!(Objects.equals(host, that.host))) {
      return false;
    }
    if (!(Objects.equals(subsets, that.subsets))) {
      return false;
    }
    if (!(Objects.equals(trafficPolicy, that.trafficPolicy))) {
      return false;
    }
    if (!(Objects.equals(workloadSelector, that.workloadSelector))) {
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
  
  public List<String> getExportTo() {
    return this.exportTo;
  }
  
  public String getExportTo(int index) {
    return this.exportTo.get(index);
  }
  
  public String getFirstExportTo() {
    return this.exportTo.get(0);
  }
  
  public String getHost() {
    return this.host;
  }
  
  public String getLastExportTo() {
    return this.exportTo.get(exportTo.size() - 1);
  }
  
  public String getMatchingExportTo(Predicate<String> predicate) {
      for (String item : exportTo) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasExportTo() {
    return this.exportTo != null && !(this.exportTo.isEmpty());
  }
  
  public boolean hasHost() {
    return this.host != null;
  }
  
  public boolean hasMatchingExportTo(Predicate<String> predicate) {
      for (String item : exportTo) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingSubset(Predicate<SubsetBuilder> predicate) {
      for (SubsetBuilder item : subsets) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasSubsets() {
    return this.subsets != null && !(this.subsets.isEmpty());
  }
  
  public boolean hasTrafficPolicy() {
    return this.trafficPolicy != null;
  }
  
  public boolean hasWorkloadSelector() {
    return this.workloadSelector != null;
  }
  
  public int hashCode() {
    return Objects.hash(exportTo, host, subsets, trafficPolicy, workloadSelector, additionalProperties);
  }
  
  public A removeAllFromExportTo(Collection<String> items) {
    if (this.exportTo == null) {
      return (A) this;
    }
    for (String item : items) {
      this.exportTo.remove(item);
    }
    return (A) this;
  }
  
  public A removeAllFromSubsets(Collection<Subset> items) {
    if (this.subsets == null) {
      return (A) this;
    }
    for (Subset item : items) {
        SubsetBuilder builder = new SubsetBuilder(item);
        _visitables.get("subsets").remove(builder);
        this.subsets.remove(builder);
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
  
  public A removeFromExportTo(String... items) {
    if (this.exportTo == null) {
      return (A) this;
    }
    for (String item : items) {
      this.exportTo.remove(item);
    }
    return (A) this;
  }
  
  public A removeFromSubsets(Subset... items) {
    if (this.subsets == null) {
      return (A) this;
    }
    for (Subset item : items) {
        SubsetBuilder builder = new SubsetBuilder(item);
        _visitables.get("subsets").remove(builder);
        this.subsets.remove(builder);
    }
    return (A) this;
  }
  
  public A removeMatchingFromSubsets(Predicate<SubsetBuilder> predicate) {
    if (subsets == null) {
      return (A) this;
    }
    Iterator<SubsetBuilder> each = subsets.iterator();
    List visitables = _visitables.get("subsets");
    while (each.hasNext()) {
        SubsetBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public SubsetsNested<A> setNewSubsetLike(int index,Subset item) {
    return new SubsetsNested(index, item);
  }
  
  public A setToExportTo(int index,String item) {
    if (this.exportTo == null) {
      this.exportTo = new ArrayList();
    }
    this.exportTo.set(index, item);
    return (A) this;
  }
  
  public A setToSubsets(int index,Subset item) {
    if (this.subsets == null) {
      this.subsets = new ArrayList();
    }
    SubsetBuilder builder = new SubsetBuilder(item);
    if (index < 0 || index >= subsets.size()) {
        _visitables.get("subsets").add(builder);
        subsets.add(builder);
    } else {
        _visitables.get("subsets").add(builder);
        subsets.set(index, builder);
    }
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(exportTo == null) && !(exportTo.isEmpty())) {
        sb.append("exportTo:");
        sb.append(exportTo);
        sb.append(",");
    }
    if (!(host == null)) {
        sb.append("host:");
        sb.append(host);
        sb.append(",");
    }
    if (!(subsets == null) && !(subsets.isEmpty())) {
        sb.append("subsets:");
        sb.append(subsets);
        sb.append(",");
    }
    if (!(trafficPolicy == null)) {
        sb.append("trafficPolicy:");
        sb.append(trafficPolicy);
        sb.append(",");
    }
    if (!(workloadSelector == null)) {
        sb.append("workloadSelector:");
        sb.append(workloadSelector);
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
  
  public A withExportTo(List<String> exportTo) {
    if (exportTo != null) {
        this.exportTo = new ArrayList();
        for (String item : exportTo) {
          this.addToExportTo(item);
        }
    } else {
      this.exportTo = null;
    }
    return (A) this;
  }
  
  public A withExportTo(String... exportTo) {
    if (this.exportTo != null) {
        this.exportTo.clear();
        _visitables.remove("exportTo");
    }
    if (exportTo != null) {
      for (String item : exportTo) {
        this.addToExportTo(item);
      }
    }
    return (A) this;
  }
  
  public A withHost(String host) {
    this.host = host;
    return (A) this;
  }
  
  public TrafficPolicyNested<A> withNewTrafficPolicy() {
    return new TrafficPolicyNested(null);
  }
  
  public TrafficPolicyNested<A> withNewTrafficPolicyLike(TrafficPolicy item) {
    return new TrafficPolicyNested(item);
  }
  
  public WorkloadSelectorNested<A> withNewWorkloadSelector() {
    return new WorkloadSelectorNested(null);
  }
  
  public WorkloadSelectorNested<A> withNewWorkloadSelectorLike(WorkloadSelector item) {
    return new WorkloadSelectorNested(item);
  }
  
  public A withSubsets(List<Subset> subsets) {
    if (this.subsets != null) {
      this._visitables.get("subsets").clear();
    }
    if (subsets != null) {
        this.subsets = new ArrayList();
        for (Subset item : subsets) {
          this.addToSubsets(item);
        }
    } else {
      this.subsets = null;
    }
    return (A) this;
  }
  
  public A withSubsets(Subset... subsets) {
    if (this.subsets != null) {
        this.subsets.clear();
        _visitables.remove("subsets");
    }
    if (subsets != null) {
      for (Subset item : subsets) {
        this.addToSubsets(item);
      }
    }
    return (A) this;
  }
  
  public A withTrafficPolicy(TrafficPolicy trafficPolicy) {
    this._visitables.remove("trafficPolicy");
    if (trafficPolicy != null) {
        this.trafficPolicy = new TrafficPolicyBuilder(trafficPolicy);
        this._visitables.get("trafficPolicy").add(this.trafficPolicy);
    } else {
        this.trafficPolicy = null;
        this._visitables.get("trafficPolicy").remove(this.trafficPolicy);
    }
    return (A) this;
  }
  
  public A withWorkloadSelector(WorkloadSelector workloadSelector) {
    this._visitables.remove("workloadSelector");
    if (workloadSelector != null) {
        this.workloadSelector = new WorkloadSelectorBuilder(workloadSelector);
        this._visitables.get("workloadSelector").add(this.workloadSelector);
    } else {
        this.workloadSelector = null;
        this._visitables.get("workloadSelector").remove(this.workloadSelector);
    }
    return (A) this;
  }
  public class SubsetsNested<N> extends SubsetFluent<SubsetsNested<N>> implements Nested<N>{
  
    SubsetBuilder builder;
    int index;
  
    SubsetsNested(int index,Subset item) {
      this.index = index;
      this.builder = new SubsetBuilder(this, item);
    }
  
    public N and() {
      return (N) DestinationRuleFluent.this.setToSubsets(index, builder.build());
    }
    
    public N endSubset() {
      return and();
    }
    
  }
  public class TrafficPolicyNested<N> extends TrafficPolicyFluent<TrafficPolicyNested<N>> implements Nested<N>{
  
    TrafficPolicyBuilder builder;
  
    TrafficPolicyNested(TrafficPolicy item) {
      this.builder = new TrafficPolicyBuilder(this, item);
    }
  
    public N and() {
      return (N) DestinationRuleFluent.this.withTrafficPolicy(builder.build());
    }
    
    public N endTrafficPolicy() {
      return and();
    }
    
  }
  public class WorkloadSelectorNested<N> extends WorkloadSelectorFluent<WorkloadSelectorNested<N>> implements Nested<N>{
  
    WorkloadSelectorBuilder builder;
  
    WorkloadSelectorNested(WorkloadSelector item) {
      this.builder = new WorkloadSelectorBuilder(this, item);
    }
  
    public N and() {
      return (N) DestinationRuleFluent.this.withWorkloadSelector(builder.build());
    }
    
    public N endWorkloadSelector() {
      return and();
    }
    
  }
}