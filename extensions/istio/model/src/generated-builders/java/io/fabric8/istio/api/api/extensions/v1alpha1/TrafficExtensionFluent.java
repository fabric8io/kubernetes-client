package io.fabric8.istio.api.api.extensions.v1alpha1;

import io.fabric8.istio.api.api.type.v1beta1.PolicyTargetReference;
import io.fabric8.istio.api.api.type.v1beta1.PolicyTargetReferenceBuilder;
import io.fabric8.istio.api.api.type.v1beta1.PolicyTargetReferenceFluent;
import io.fabric8.istio.api.api.type.v1beta1.WorkloadSelector;
import io.fabric8.istio.api.api.type.v1beta1.WorkloadSelectorBuilder;
import io.fabric8.istio.api.api.type.v1beta1.WorkloadSelectorFluent;
import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import io.fabric8.kubernetes.api.builder.VisitableBuilder;
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
public class TrafficExtensionFluent<A extends io.fabric8.istio.api.api.extensions.v1alpha1.TrafficExtensionFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private VisitableBuilder<? extends IsTrafficExtensionFilterConfig,?> filterConfig;
  private ArrayList<TrafficSelectorBuilder> match = new ArrayList<TrafficSelectorBuilder>();
  private TrafficExtensionExecutionPhase phase;
  private Integer priority;
  private WorkloadSelectorBuilder selector;
  private ArrayList<PolicyTargetReferenceBuilder> targetRefs = new ArrayList<PolicyTargetReferenceBuilder>();

  public TrafficExtensionFluent() {
  }
  
  public TrafficExtensionFluent(TrafficExtension instance) {
    this.copyInstance(instance);
  }

  public A addAllToMatch(Collection<TrafficSelector> items) {
    if (this.match == null) {
      this.match = new ArrayList();
    }
    for (TrafficSelector item : items) {
        TrafficSelectorBuilder builder = new TrafficSelectorBuilder(item);
        _visitables.get("match").add(builder);
        this.match.add(builder);
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
  
  public MatchNested<A> addNewMatch() {
    return new MatchNested(-1, null);
  }
  
  public MatchNested<A> addNewMatchLike(TrafficSelector item) {
    return new MatchNested(-1, item);
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
  
  public A addToMatch(TrafficSelector... items) {
    if (this.match == null) {
      this.match = new ArrayList();
    }
    for (TrafficSelector item : items) {
        TrafficSelectorBuilder builder = new TrafficSelectorBuilder(item);
        _visitables.get("match").add(builder);
        this.match.add(builder);
    }
    return (A) this;
  }
  
  public A addToMatch(int index,TrafficSelector item) {
    if (this.match == null) {
      this.match = new ArrayList();
    }
    TrafficSelectorBuilder builder = new TrafficSelectorBuilder(item);
    if (index < 0 || index >= match.size()) {
        _visitables.get("match").add(builder);
        match.add(builder);
    } else {
        _visitables.get("match").add(builder);
        match.add(index, builder);
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
  
  public IsTrafficExtensionFilterConfig buildFilterConfig() {
    return this.filterConfig != null ? this.filterConfig.build() : null;
  }
  
  public TrafficSelector buildFirstMatch() {
    return this.match.get(0).build();
  }
  
  public PolicyTargetReference buildFirstTargetRef() {
    return this.targetRefs.get(0).build();
  }
  
  public TrafficSelector buildLastMatch() {
    return this.match.get(match.size() - 1).build();
  }
  
  public PolicyTargetReference buildLastTargetRef() {
    return this.targetRefs.get(targetRefs.size() - 1).build();
  }
  
  public List<TrafficSelector> buildMatch() {
    return this.match != null ? build(match) : null;
  }
  
  public TrafficSelector buildMatch(int index) {
    return this.match.get(index).build();
  }
  
  public TrafficSelector buildMatchingMatch(Predicate<TrafficSelectorBuilder> predicate) {
      for (TrafficSelectorBuilder item : match) {
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
  
  public WorkloadSelector buildSelector() {
    return this.selector != null ? this.selector.build() : null;
  }
  
  public PolicyTargetReference buildTargetRef(int index) {
    return this.targetRefs.get(index).build();
  }
  
  public List<PolicyTargetReference> buildTargetRefs() {
    return this.targetRefs != null ? build(targetRefs) : null;
  }
  
  protected static <T>VisitableBuilder<T,?> builder(Object item) {
    switch (item.getClass().getName()) {
      case "TrafficExtensionLua":
    
          return (VisitableBuilder<T,?>) new TrafficExtensionLuaBuilder((TrafficExtensionLua) item);
    
      case "TrafficExtensionWasm":
    
          return (VisitableBuilder<T,?>) new TrafficExtensionWasmBuilder((TrafficExtensionWasm) item);
    
      default:
    
          return (VisitableBuilder<T,?>) builderOf(item);
    
    }
  }
  
  protected void copyInstance(TrafficExtension instance) {
    instance = instance != null ? instance : new TrafficExtension();
    if (instance != null) {
        this.withFilterConfig(instance.getFilterConfig());
        this.withMatch(instance.getMatch());
        this.withPhase(instance.getPhase());
        this.withPriority(instance.getPriority());
        this.withSelector(instance.getSelector());
        this.withTargetRefs(instance.getTargetRefs());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public MatchNested<A> editFirstMatch() {
    if (match.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "match"));
    }
    return this.setNewMatchLike(0, this.buildMatch(0));
  }
  
  public TargetRefsNested<A> editFirstTargetRef() {
    if (targetRefs.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "targetRefs"));
    }
    return this.setNewTargetRefLike(0, this.buildTargetRef(0));
  }
  
  public MatchNested<A> editLastMatch() {
    int index = match.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "match"));
    }
    return this.setNewMatchLike(index, this.buildMatch(index));
  }
  
  public TargetRefsNested<A> editLastTargetRef() {
    int index = targetRefs.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "targetRefs"));
    }
    return this.setNewTargetRefLike(index, this.buildTargetRef(index));
  }
  
  public MatchNested<A> editMatch(int index) {
    if (match.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "match"));
    }
    return this.setNewMatchLike(index, this.buildMatch(index));
  }
  
  public MatchNested<A> editMatchingMatch(Predicate<TrafficSelectorBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < match.size();i++) {
      if (predicate.test(match.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "match"));
    }
    return this.setNewMatchLike(index, this.buildMatch(index));
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
  
  public SelectorNested<A> editOrNewSelector() {
    return this.withNewSelectorLike(Optional.ofNullable(this.buildSelector()).orElse(new WorkloadSelectorBuilder().build()));
  }
  
  public SelectorNested<A> editOrNewSelectorLike(WorkloadSelector item) {
    return this.withNewSelectorLike(Optional.ofNullable(this.buildSelector()).orElse(item));
  }
  
  public SelectorNested<A> editSelector() {
    return this.withNewSelectorLike(Optional.ofNullable(this.buildSelector()).orElse(null));
  }
  
  public TargetRefsNested<A> editTargetRef(int index) {
    if (targetRefs.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "targetRefs"));
    }
    return this.setNewTargetRefLike(index, this.buildTargetRef(index));
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
    TrafficExtensionFluent that = (TrafficExtensionFluent) o;
    if (!(Objects.equals(filterConfig, that.filterConfig))) {
      return false;
    }
    if (!(Objects.equals(match, that.match))) {
      return false;
    }
    if (!(Objects.equals(phase, that.phase))) {
      return false;
    }
    if (!(Objects.equals(priority, that.priority))) {
      return false;
    }
    if (!(Objects.equals(selector, that.selector))) {
      return false;
    }
    if (!(Objects.equals(targetRefs, that.targetRefs))) {
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
  
  public TrafficExtensionExecutionPhase getPhase() {
    return this.phase;
  }
  
  public Integer getPriority() {
    return this.priority;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasFilterConfig() {
    return this.filterConfig != null;
  }
  
  public boolean hasMatch() {
    return this.match != null && !(this.match.isEmpty());
  }
  
  public boolean hasMatchingMatch(Predicate<TrafficSelectorBuilder> predicate) {
      for (TrafficSelectorBuilder item : match) {
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
  
  public boolean hasPhase() {
    return this.phase != null;
  }
  
  public boolean hasPriority() {
    return this.priority != null;
  }
  
  public boolean hasSelector() {
    return this.selector != null;
  }
  
  public boolean hasTargetRefs() {
    return this.targetRefs != null && !(this.targetRefs.isEmpty());
  }
  
  public int hashCode() {
    return Objects.hash(filterConfig, match, phase, priority, selector, targetRefs, additionalProperties);
  }
  
  public A removeAllFromMatch(Collection<TrafficSelector> items) {
    if (this.match == null) {
      return (A) this;
    }
    for (TrafficSelector item : items) {
        TrafficSelectorBuilder builder = new TrafficSelectorBuilder(item);
        _visitables.get("match").remove(builder);
        this.match.remove(builder);
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
  
  public A removeFromMatch(TrafficSelector... items) {
    if (this.match == null) {
      return (A) this;
    }
    for (TrafficSelector item : items) {
        TrafficSelectorBuilder builder = new TrafficSelectorBuilder(item);
        _visitables.get("match").remove(builder);
        this.match.remove(builder);
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
  
  public A removeMatchingFromMatch(Predicate<TrafficSelectorBuilder> predicate) {
    if (match == null) {
      return (A) this;
    }
    Iterator<TrafficSelectorBuilder> each = match.iterator();
    List visitables = _visitables.get("match");
    while (each.hasNext()) {
        TrafficSelectorBuilder builder = each.next();
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
  
  public MatchNested<A> setNewMatchLike(int index,TrafficSelector item) {
    return new MatchNested(index, item);
  }
  
  public TargetRefsNested<A> setNewTargetRefLike(int index,PolicyTargetReference item) {
    return new TargetRefsNested(index, item);
  }
  
  public A setToMatch(int index,TrafficSelector item) {
    if (this.match == null) {
      this.match = new ArrayList();
    }
    TrafficSelectorBuilder builder = new TrafficSelectorBuilder(item);
    if (index < 0 || index >= match.size()) {
        _visitables.get("match").add(builder);
        match.add(builder);
    } else {
        _visitables.get("match").add(builder);
        match.set(index, builder);
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
    if (!(filterConfig == null)) {
        sb.append("filterConfig:");
        sb.append(filterConfig);
        sb.append(",");
    }
    if (!(match == null) && !(match.isEmpty())) {
        sb.append("match:");
        sb.append(match);
        sb.append(",");
    }
    if (!(phase == null)) {
        sb.append("phase:");
        sb.append(phase);
        sb.append(",");
    }
    if (!(priority == null)) {
        sb.append("priority:");
        sb.append(priority);
        sb.append(",");
    }
    if (!(selector == null)) {
        sb.append("selector:");
        sb.append(selector);
        sb.append(",");
    }
    if (!(targetRefs == null) && !(targetRefs.isEmpty())) {
        sb.append("targetRefs:");
        sb.append(targetRefs);
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
  
  public A withFilterConfig(IsTrafficExtensionFilterConfig filterConfig) {
    if (filterConfig == null) {
        this.filterConfig = null;
        this._visitables.remove("filterConfig");
        return (A) this;
    } else {
        VisitableBuilder<? extends IsTrafficExtensionFilterConfig,?> builder = builder(filterConfig);
        this._visitables.get("filterConfig").clear();
        this._visitables.get("filterConfig").add(builder);
        this.filterConfig = builder;
        return (A) this;
    }
  }
  
  public A withMatch(List<TrafficSelector> match) {
    if (this.match != null) {
      this._visitables.get("match").clear();
    }
    if (match != null) {
        this.match = new ArrayList();
        for (TrafficSelector item : match) {
          this.addToMatch(item);
        }
    } else {
      this.match = null;
    }
    return (A) this;
  }
  
  public A withMatch(TrafficSelector... match) {
    if (this.match != null) {
        this.match.clear();
        _visitables.remove("match");
    }
    if (match != null) {
      for (TrafficSelector item : match) {
        this.addToMatch(item);
      }
    }
    return (A) this;
  }
  
  public SelectorNested<A> withNewSelector() {
    return new SelectorNested(null);
  }
  
  public SelectorNested<A> withNewSelectorLike(WorkloadSelector item) {
    return new SelectorNested(item);
  }
  
  public TrafficExtensionLuaFilterConfigNested<A> withNewTrafficExtensionLuaFilterConfig() {
    return new TrafficExtensionLuaFilterConfigNested(null);
  }
  
  public TrafficExtensionLuaFilterConfigNested<A> withNewTrafficExtensionLuaFilterConfigLike(TrafficExtensionLua item) {
    return new TrafficExtensionLuaFilterConfigNested(item);
  }
  
  public TrafficExtensionWasmFilterConfigNested<A> withNewTrafficExtensionWasmFilterConfig() {
    return new TrafficExtensionWasmFilterConfigNested(null);
  }
  
  public TrafficExtensionWasmFilterConfigNested<A> withNewTrafficExtensionWasmFilterConfigLike(TrafficExtensionWasm item) {
    return new TrafficExtensionWasmFilterConfigNested(item);
  }
  
  public A withPhase(TrafficExtensionExecutionPhase phase) {
    this.phase = phase;
    return (A) this;
  }
  
  public A withPriority(Integer priority) {
    this.priority = priority;
    return (A) this;
  }
  
  public A withSelector(WorkloadSelector selector) {
    this._visitables.remove("selector");
    if (selector != null) {
        this.selector = new WorkloadSelectorBuilder(selector);
        this._visitables.get("selector").add(this.selector);
    } else {
        this.selector = null;
        this._visitables.get("selector").remove(this.selector);
    }
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
  public class MatchNested<N> extends TrafficSelectorFluent<MatchNested<N>> implements Nested<N>{
  
    TrafficSelectorBuilder builder;
    int index;
  
    MatchNested(int index,TrafficSelector item) {
      this.index = index;
      this.builder = new TrafficSelectorBuilder(this, item);
    }
  
    public N and() {
      return (N) TrafficExtensionFluent.this.setToMatch(index, builder.build());
    }
    
    public N endMatch() {
      return and();
    }
    
  }
  public class SelectorNested<N> extends WorkloadSelectorFluent<SelectorNested<N>> implements Nested<N>{
  
    WorkloadSelectorBuilder builder;
  
    SelectorNested(WorkloadSelector item) {
      this.builder = new WorkloadSelectorBuilder(this, item);
    }
  
    public N and() {
      return (N) TrafficExtensionFluent.this.withSelector(builder.build());
    }
    
    public N endSelector() {
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
      return (N) TrafficExtensionFluent.this.setToTargetRefs(index, builder.build());
    }
    
    public N endTargetRef() {
      return and();
    }
    
  }
  public class TrafficExtensionLuaFilterConfigNested<N> extends TrafficExtensionLuaFluent<TrafficExtensionLuaFilterConfigNested<N>> implements Nested<N>{
  
    TrafficExtensionLuaBuilder builder;
  
    TrafficExtensionLuaFilterConfigNested(TrafficExtensionLua item) {
      this.builder = new TrafficExtensionLuaBuilder(this, item);
    }
  
    public N and() {
      return (N) TrafficExtensionFluent.this.withFilterConfig(builder.build());
    }
    
    public N endTrafficExtensionLuaFilterConfig() {
      return and();
    }
    
  }
  public class TrafficExtensionWasmFilterConfigNested<N> extends TrafficExtensionWasmFluent<TrafficExtensionWasmFilterConfigNested<N>> implements Nested<N>{
  
    TrafficExtensionWasmBuilder builder;
  
    TrafficExtensionWasmFilterConfigNested(TrafficExtensionWasm item) {
      this.builder = new TrafficExtensionWasmBuilder(this, item);
    }
  
    public N and() {
      return (N) TrafficExtensionFluent.this.withFilterConfig(builder.build());
    }
    
    public N endTrafficExtensionWasmFilterConfig() {
      return and();
    }
    
  }
}