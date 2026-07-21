package io.fabric8.istio.api.api.networking.v1alpha3;

import io.fabric8.istio.api.api.type.v1beta1.PolicyTargetReference;
import io.fabric8.istio.api.api.type.v1beta1.PolicyTargetReferenceBuilder;
import io.fabric8.istio.api.api.type.v1beta1.PolicyTargetReferenceFluent;
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
import java.util.Optional;
import java.util.function.Predicate;

/**
 * Generated
 */
@SuppressWarnings("unchecked")
public class EnvoyFilterFluent<A extends io.fabric8.istio.api.api.networking.v1alpha3.EnvoyFilterFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private ArrayList<EnvoyFilterEnvoyConfigObjectPatchBuilder> configPatches = new ArrayList<EnvoyFilterEnvoyConfigObjectPatchBuilder>();
  private Integer priority;
  private ArrayList<PolicyTargetReferenceBuilder> targetRefs = new ArrayList<PolicyTargetReferenceBuilder>();
  private WorkloadSelectorBuilder workloadSelector;

  public EnvoyFilterFluent() {
  }
  
  public EnvoyFilterFluent(EnvoyFilter instance) {
    this.copyInstance(instance);
  }

  public A addAllToConfigPatches(Collection<EnvoyFilterEnvoyConfigObjectPatch> items) {
    if (this.configPatches == null) {
      this.configPatches = new ArrayList();
    }
    for (EnvoyFilterEnvoyConfigObjectPatch item : items) {
        EnvoyFilterEnvoyConfigObjectPatchBuilder builder = new EnvoyFilterEnvoyConfigObjectPatchBuilder(item);
        _visitables.get("configPatches").add(builder);
        this.configPatches.add(builder);
    }
    return (A) this;
  }
  
  public A addAllToTargetRefs(Collection<PolicyTargetReference> items) {
    if (this.targetRefs == null) {
      this.targetRefs = new ArrayList();
    }
    for (PolicyTargetReference item : items) {
        PolicyTargetReferenceBuilder builder = new PolicyTargetReferenceBuilder(item);
        _visitables.get("targetRefs").add(builder);
        this.targetRefs.add(builder);
    }
    return (A) this;
  }
  
  public ConfigPatchesNested<A> addNewConfigPatch() {
    return new ConfigPatchesNested(-1, null);
  }
  
  public ConfigPatchesNested<A> addNewConfigPatchLike(EnvoyFilterEnvoyConfigObjectPatch item) {
    return new ConfigPatchesNested(-1, item);
  }
  
  public TargetRefsNested<A> addNewTargetRef() {
    return new TargetRefsNested(-1, null);
  }
  
  public A addNewTargetRef(String group,String kind,String name,String namespace) {
    return (A) this.addToTargetRefs(new PolicyTargetReference(group, kind, name, namespace));
  }
  
  public TargetRefsNested<A> addNewTargetRefLike(PolicyTargetReference item) {
    return new TargetRefsNested(-1, item);
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
  
  public A addToConfigPatches(EnvoyFilterEnvoyConfigObjectPatch... items) {
    if (this.configPatches == null) {
      this.configPatches = new ArrayList();
    }
    for (EnvoyFilterEnvoyConfigObjectPatch item : items) {
        EnvoyFilterEnvoyConfigObjectPatchBuilder builder = new EnvoyFilterEnvoyConfigObjectPatchBuilder(item);
        _visitables.get("configPatches").add(builder);
        this.configPatches.add(builder);
    }
    return (A) this;
  }
  
  public A addToConfigPatches(int index,EnvoyFilterEnvoyConfigObjectPatch item) {
    if (this.configPatches == null) {
      this.configPatches = new ArrayList();
    }
    EnvoyFilterEnvoyConfigObjectPatchBuilder builder = new EnvoyFilterEnvoyConfigObjectPatchBuilder(item);
    if (index < 0 || index >= configPatches.size()) {
        _visitables.get("configPatches").add(builder);
        configPatches.add(builder);
    } else {
        _visitables.get("configPatches").add(builder);
        configPatches.add(index, builder);
    }
    return (A) this;
  }
  
  public A addToTargetRefs(PolicyTargetReference... items) {
    if (this.targetRefs == null) {
      this.targetRefs = new ArrayList();
    }
    for (PolicyTargetReference item : items) {
        PolicyTargetReferenceBuilder builder = new PolicyTargetReferenceBuilder(item);
        _visitables.get("targetRefs").add(builder);
        this.targetRefs.add(builder);
    }
    return (A) this;
  }
  
  public A addToTargetRefs(int index,PolicyTargetReference item) {
    if (this.targetRefs == null) {
      this.targetRefs = new ArrayList();
    }
    PolicyTargetReferenceBuilder builder = new PolicyTargetReferenceBuilder(item);
    if (index < 0 || index >= targetRefs.size()) {
        _visitables.get("targetRefs").add(builder);
        targetRefs.add(builder);
    } else {
        _visitables.get("targetRefs").add(builder);
        targetRefs.add(index, builder);
    }
    return (A) this;
  }
  
  public EnvoyFilterEnvoyConfigObjectPatch buildConfigPatch(int index) {
    return this.configPatches.get(index).build();
  }
  
  public List<EnvoyFilterEnvoyConfigObjectPatch> buildConfigPatches() {
    return this.configPatches != null ? build(configPatches) : null;
  }
  
  public EnvoyFilterEnvoyConfigObjectPatch buildFirstConfigPatch() {
    return this.configPatches.get(0).build();
  }
  
  public PolicyTargetReference buildFirstTargetRef() {
    return this.targetRefs.get(0).build();
  }
  
  public EnvoyFilterEnvoyConfigObjectPatch buildLastConfigPatch() {
    return this.configPatches.get(configPatches.size() - 1).build();
  }
  
  public PolicyTargetReference buildLastTargetRef() {
    return this.targetRefs.get(targetRefs.size() - 1).build();
  }
  
  public EnvoyFilterEnvoyConfigObjectPatch buildMatchingConfigPatch(Predicate<EnvoyFilterEnvoyConfigObjectPatchBuilder> predicate) {
      for (EnvoyFilterEnvoyConfigObjectPatchBuilder item : configPatches) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public PolicyTargetReference buildMatchingTargetRef(Predicate<PolicyTargetReferenceBuilder> predicate) {
      for (PolicyTargetReferenceBuilder item : targetRefs) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public PolicyTargetReference buildTargetRef(int index) {
    return this.targetRefs.get(index).build();
  }
  
  public List<PolicyTargetReference> buildTargetRefs() {
    return this.targetRefs != null ? build(targetRefs) : null;
  }
  
  public WorkloadSelector buildWorkloadSelector() {
    return this.workloadSelector != null ? this.workloadSelector.build() : null;
  }
  
  protected void copyInstance(EnvoyFilter instance) {
    instance = instance != null ? instance : new EnvoyFilter();
    if (instance != null) {
        this.withConfigPatches(instance.getConfigPatches());
        this.withPriority(instance.getPriority());
        this.withTargetRefs(instance.getTargetRefs());
        this.withWorkloadSelector(instance.getWorkloadSelector());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public ConfigPatchesNested<A> editConfigPatch(int index) {
    if (configPatches.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "configPatches"));
    }
    return this.setNewConfigPatchLike(index, this.buildConfigPatch(index));
  }
  
  public ConfigPatchesNested<A> editFirstConfigPatch() {
    if (configPatches.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "configPatches"));
    }
    return this.setNewConfigPatchLike(0, this.buildConfigPatch(0));
  }
  
  public TargetRefsNested<A> editFirstTargetRef() {
    if (targetRefs.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "targetRefs"));
    }
    return this.setNewTargetRefLike(0, this.buildTargetRef(0));
  }
  
  public ConfigPatchesNested<A> editLastConfigPatch() {
    int index = configPatches.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "configPatches"));
    }
    return this.setNewConfigPatchLike(index, this.buildConfigPatch(index));
  }
  
  public TargetRefsNested<A> editLastTargetRef() {
    int index = targetRefs.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "targetRefs"));
    }
    return this.setNewTargetRefLike(index, this.buildTargetRef(index));
  }
  
  public ConfigPatchesNested<A> editMatchingConfigPatch(Predicate<EnvoyFilterEnvoyConfigObjectPatchBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < configPatches.size();i++) {
      if (predicate.test(configPatches.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "configPatches"));
    }
    return this.setNewConfigPatchLike(index, this.buildConfigPatch(index));
  }
  
  public TargetRefsNested<A> editMatchingTargetRef(Predicate<PolicyTargetReferenceBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < targetRefs.size();i++) {
      if (predicate.test(targetRefs.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "targetRefs"));
    }
    return this.setNewTargetRefLike(index, this.buildTargetRef(index));
  }
  
  public WorkloadSelectorNested<A> editOrNewWorkloadSelector() {
    return this.withNewWorkloadSelectorLike(Optional.ofNullable(this.buildWorkloadSelector()).orElse(new WorkloadSelectorBuilder().build()));
  }
  
  public WorkloadSelectorNested<A> editOrNewWorkloadSelectorLike(WorkloadSelector item) {
    return this.withNewWorkloadSelectorLike(Optional.ofNullable(this.buildWorkloadSelector()).orElse(item));
  }
  
  public TargetRefsNested<A> editTargetRef(int index) {
    if (targetRefs.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "targetRefs"));
    }
    return this.setNewTargetRefLike(index, this.buildTargetRef(index));
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
    EnvoyFilterFluent that = (EnvoyFilterFluent) o;
    if (!(Objects.equals(configPatches, that.configPatches))) {
      return false;
    }
    if (!(Objects.equals(priority, that.priority))) {
      return false;
    }
    if (!(Objects.equals(targetRefs, that.targetRefs))) {
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
  
  public Integer getPriority() {
    return this.priority;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasConfigPatches() {
    return this.configPatches != null && !(this.configPatches.isEmpty());
  }
  
  public boolean hasMatchingConfigPatch(Predicate<EnvoyFilterEnvoyConfigObjectPatchBuilder> predicate) {
      for (EnvoyFilterEnvoyConfigObjectPatchBuilder item : configPatches) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingTargetRef(Predicate<PolicyTargetReferenceBuilder> predicate) {
      for (PolicyTargetReferenceBuilder item : targetRefs) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasPriority() {
    return this.priority != null;
  }
  
  public boolean hasTargetRefs() {
    return this.targetRefs != null && !(this.targetRefs.isEmpty());
  }
  
  public boolean hasWorkloadSelector() {
    return this.workloadSelector != null;
  }
  
  public int hashCode() {
    return Objects.hash(configPatches, priority, targetRefs, workloadSelector, additionalProperties);
  }
  
  public A removeAllFromConfigPatches(Collection<EnvoyFilterEnvoyConfigObjectPatch> items) {
    if (this.configPatches == null) {
      return (A) this;
    }
    for (EnvoyFilterEnvoyConfigObjectPatch item : items) {
        EnvoyFilterEnvoyConfigObjectPatchBuilder builder = new EnvoyFilterEnvoyConfigObjectPatchBuilder(item);
        _visitables.get("configPatches").remove(builder);
        this.configPatches.remove(builder);
    }
    return (A) this;
  }
  
  public A removeAllFromTargetRefs(Collection<PolicyTargetReference> items) {
    if (this.targetRefs == null) {
      return (A) this;
    }
    for (PolicyTargetReference item : items) {
        PolicyTargetReferenceBuilder builder = new PolicyTargetReferenceBuilder(item);
        _visitables.get("targetRefs").remove(builder);
        this.targetRefs.remove(builder);
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
  
  public A removeFromConfigPatches(EnvoyFilterEnvoyConfigObjectPatch... items) {
    if (this.configPatches == null) {
      return (A) this;
    }
    for (EnvoyFilterEnvoyConfigObjectPatch item : items) {
        EnvoyFilterEnvoyConfigObjectPatchBuilder builder = new EnvoyFilterEnvoyConfigObjectPatchBuilder(item);
        _visitables.get("configPatches").remove(builder);
        this.configPatches.remove(builder);
    }
    return (A) this;
  }
  
  public A removeFromTargetRefs(PolicyTargetReference... items) {
    if (this.targetRefs == null) {
      return (A) this;
    }
    for (PolicyTargetReference item : items) {
        PolicyTargetReferenceBuilder builder = new PolicyTargetReferenceBuilder(item);
        _visitables.get("targetRefs").remove(builder);
        this.targetRefs.remove(builder);
    }
    return (A) this;
  }
  
  public A removeMatchingFromConfigPatches(Predicate<EnvoyFilterEnvoyConfigObjectPatchBuilder> predicate) {
    if (configPatches == null) {
      return (A) this;
    }
    Iterator<EnvoyFilterEnvoyConfigObjectPatchBuilder> each = configPatches.iterator();
    List visitables = _visitables.get("configPatches");
    while (each.hasNext()) {
        EnvoyFilterEnvoyConfigObjectPatchBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public A removeMatchingFromTargetRefs(Predicate<PolicyTargetReferenceBuilder> predicate) {
    if (targetRefs == null) {
      return (A) this;
    }
    Iterator<PolicyTargetReferenceBuilder> each = targetRefs.iterator();
    List visitables = _visitables.get("targetRefs");
    while (each.hasNext()) {
        PolicyTargetReferenceBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public ConfigPatchesNested<A> setNewConfigPatchLike(int index,EnvoyFilterEnvoyConfigObjectPatch item) {
    return new ConfigPatchesNested(index, item);
  }
  
  public TargetRefsNested<A> setNewTargetRefLike(int index,PolicyTargetReference item) {
    return new TargetRefsNested(index, item);
  }
  
  public A setToConfigPatches(int index,EnvoyFilterEnvoyConfigObjectPatch item) {
    if (this.configPatches == null) {
      this.configPatches = new ArrayList();
    }
    EnvoyFilterEnvoyConfigObjectPatchBuilder builder = new EnvoyFilterEnvoyConfigObjectPatchBuilder(item);
    if (index < 0 || index >= configPatches.size()) {
        _visitables.get("configPatches").add(builder);
        configPatches.add(builder);
    } else {
        _visitables.get("configPatches").add(builder);
        configPatches.set(index, builder);
    }
    return (A) this;
  }
  
  public A setToTargetRefs(int index,PolicyTargetReference item) {
    if (this.targetRefs == null) {
      this.targetRefs = new ArrayList();
    }
    PolicyTargetReferenceBuilder builder = new PolicyTargetReferenceBuilder(item);
    if (index < 0 || index >= targetRefs.size()) {
        _visitables.get("targetRefs").add(builder);
        targetRefs.add(builder);
    } else {
        _visitables.get("targetRefs").add(builder);
        targetRefs.set(index, builder);
    }
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(configPatches == null) && !(configPatches.isEmpty())) {
        sb.append("configPatches:");
        sb.append(configPatches);
        sb.append(",");
    }
    if (!(priority == null)) {
        sb.append("priority:");
        sb.append(priority);
        sb.append(",");
    }
    if (!(targetRefs == null) && !(targetRefs.isEmpty())) {
        sb.append("targetRefs:");
        sb.append(targetRefs);
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
  
  public A withConfigPatches(List<EnvoyFilterEnvoyConfigObjectPatch> configPatches) {
    if (this.configPatches != null) {
      this._visitables.get("configPatches").clear();
    }
    if (configPatches != null) {
        this.configPatches = new ArrayList();
        for (EnvoyFilterEnvoyConfigObjectPatch item : configPatches) {
          this.addToConfigPatches(item);
        }
    } else {
      this.configPatches = null;
    }
    return (A) this;
  }
  
  public A withConfigPatches(EnvoyFilterEnvoyConfigObjectPatch... configPatches) {
    if (this.configPatches != null) {
        this.configPatches.clear();
        _visitables.remove("configPatches");
    }
    if (configPatches != null) {
      for (EnvoyFilterEnvoyConfigObjectPatch item : configPatches) {
        this.addToConfigPatches(item);
      }
    }
    return (A) this;
  }
  
  public WorkloadSelectorNested<A> withNewWorkloadSelector() {
    return new WorkloadSelectorNested(null);
  }
  
  public WorkloadSelectorNested<A> withNewWorkloadSelectorLike(WorkloadSelector item) {
    return new WorkloadSelectorNested(item);
  }
  
  public A withPriority(Integer priority) {
    this.priority = priority;
    return (A) this;
  }
  
  public A withTargetRefs(List<PolicyTargetReference> targetRefs) {
    if (this.targetRefs != null) {
      this._visitables.get("targetRefs").clear();
    }
    if (targetRefs != null) {
        this.targetRefs = new ArrayList();
        for (PolicyTargetReference item : targetRefs) {
          this.addToTargetRefs(item);
        }
    } else {
      this.targetRefs = null;
    }
    return (A) this;
  }
  
  public A withTargetRefs(PolicyTargetReference... targetRefs) {
    if (this.targetRefs != null) {
        this.targetRefs.clear();
        _visitables.remove("targetRefs");
    }
    if (targetRefs != null) {
      for (PolicyTargetReference item : targetRefs) {
        this.addToTargetRefs(item);
      }
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
  public class ConfigPatchesNested<N> extends EnvoyFilterEnvoyConfigObjectPatchFluent<ConfigPatchesNested<N>> implements Nested<N>{
  
    EnvoyFilterEnvoyConfigObjectPatchBuilder builder;
    int index;
  
    ConfigPatchesNested(int index,EnvoyFilterEnvoyConfigObjectPatch item) {
      this.index = index;
      this.builder = new EnvoyFilterEnvoyConfigObjectPatchBuilder(this, item);
    }
  
    public N and() {
      return (N) EnvoyFilterFluent.this.setToConfigPatches(index, builder.build());
    }
    
    public N endConfigPatch() {
      return and();
    }
    
  }
  public class TargetRefsNested<N> extends PolicyTargetReferenceFluent<TargetRefsNested<N>> implements Nested<N>{
  
    PolicyTargetReferenceBuilder builder;
    int index;
  
    TargetRefsNested(int index,PolicyTargetReference item) {
      this.index = index;
      this.builder = new PolicyTargetReferenceBuilder(this, item);
    }
  
    public N and() {
      return (N) EnvoyFilterFluent.this.setToTargetRefs(index, builder.build());
    }
    
    public N endTargetRef() {
      return and();
    }
    
  }
  public class WorkloadSelectorNested<N> extends WorkloadSelectorFluent<WorkloadSelectorNested<N>> implements Nested<N>{
  
    WorkloadSelectorBuilder builder;
  
    WorkloadSelectorNested(WorkloadSelector item) {
      this.builder = new WorkloadSelectorBuilder(this, item);
    }
  
    public N and() {
      return (N) EnvoyFilterFluent.this.withWorkloadSelector(builder.build());
    }
    
    public N endWorkloadSelector() {
      return and();
    }
    
  }
}