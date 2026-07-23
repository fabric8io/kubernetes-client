package io.fabric8.volcano.api.model.flow.v1alpha1;

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
import java.util.function.Predicate;

/**
 * Generated
 */
@SuppressWarnings("unchecked")
public class JobFlowSpecFluent<A extends io.fabric8.volcano.api.model.flow.v1alpha1.JobFlowSpecFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private ArrayList<FlowBuilder> flows = new ArrayList<FlowBuilder>();
  private String jobRetainPolicy;

  public JobFlowSpecFluent() {
  }
  
  public JobFlowSpecFluent(JobFlowSpec instance) {
    this.copyInstance(instance);
  }

  public A addAllToFlows(Collection<Flow> items) {
    if (this.flows == null) {
      this.flows = new ArrayList();
    }
    for (Flow item : items) {
        FlowBuilder builder = new FlowBuilder(item);
        _visitables.get("flows").add(builder);
        this.flows.add(builder);
    }
    return (A) this;
  }
  
  public FlowsNested<A> addNewFlow() {
    return new FlowsNested(-1, null);
  }
  
  public FlowsNested<A> addNewFlowLike(Flow item) {
    return new FlowsNested(-1, item);
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
  
  public A addToFlows(Flow... items) {
    if (this.flows == null) {
      this.flows = new ArrayList();
    }
    for (Flow item : items) {
        FlowBuilder builder = new FlowBuilder(item);
        _visitables.get("flows").add(builder);
        this.flows.add(builder);
    }
    return (A) this;
  }
  
  public A addToFlows(int index,Flow item) {
    if (this.flows == null) {
      this.flows = new ArrayList();
    }
    FlowBuilder builder = new FlowBuilder(item);
    if (index < 0 || index >= flows.size()) {
        _visitables.get("flows").add(builder);
        flows.add(builder);
    } else {
        _visitables.get("flows").add(builder);
        flows.add(index, builder);
    }
    return (A) this;
  }
  
  public Flow buildFirstFlow() {
    return this.flows.get(0).build();
  }
  
  public Flow buildFlow(int index) {
    return this.flows.get(index).build();
  }
  
  public List<Flow> buildFlows() {
    return this.flows != null ? build(flows) : null;
  }
  
  public Flow buildLastFlow() {
    return this.flows.get(flows.size() - 1).build();
  }
  
  public Flow buildMatchingFlow(Predicate<FlowBuilder> predicate) {
      for (FlowBuilder item : flows) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  protected void copyInstance(JobFlowSpec instance) {
    instance = instance != null ? instance : new JobFlowSpec();
    if (instance != null) {
        this.withFlows(instance.getFlows());
        this.withJobRetainPolicy(instance.getJobRetainPolicy());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public FlowsNested<A> editFirstFlow() {
    if (flows.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "flows"));
    }
    return this.setNewFlowLike(0, this.buildFlow(0));
  }
  
  public FlowsNested<A> editFlow(int index) {
    if (flows.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "flows"));
    }
    return this.setNewFlowLike(index, this.buildFlow(index));
  }
  
  public FlowsNested<A> editLastFlow() {
    int index = flows.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "flows"));
    }
    return this.setNewFlowLike(index, this.buildFlow(index));
  }
  
  public FlowsNested<A> editMatchingFlow(Predicate<FlowBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < flows.size();i++) {
      if (predicate.test(flows.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "flows"));
    }
    return this.setNewFlowLike(index, this.buildFlow(index));
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
    JobFlowSpecFluent that = (JobFlowSpecFluent) o;
    if (!(Objects.equals(flows, that.flows))) {
      return false;
    }
    if (!(Objects.equals(jobRetainPolicy, that.jobRetainPolicy))) {
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
  
  public String getJobRetainPolicy() {
    return this.jobRetainPolicy;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasFlows() {
    return this.flows != null && !(this.flows.isEmpty());
  }
  
  public boolean hasJobRetainPolicy() {
    return this.jobRetainPolicy != null;
  }
  
  public boolean hasMatchingFlow(Predicate<FlowBuilder> predicate) {
      for (FlowBuilder item : flows) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public int hashCode() {
    return Objects.hash(flows, jobRetainPolicy, additionalProperties);
  }
  
  public A removeAllFromFlows(Collection<Flow> items) {
    if (this.flows == null) {
      return (A) this;
    }
    for (Flow item : items) {
        FlowBuilder builder = new FlowBuilder(item);
        _visitables.get("flows").remove(builder);
        this.flows.remove(builder);
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
  
  public A removeFromFlows(Flow... items) {
    if (this.flows == null) {
      return (A) this;
    }
    for (Flow item : items) {
        FlowBuilder builder = new FlowBuilder(item);
        _visitables.get("flows").remove(builder);
        this.flows.remove(builder);
    }
    return (A) this;
  }
  
  public A removeMatchingFromFlows(Predicate<FlowBuilder> predicate) {
    if (flows == null) {
      return (A) this;
    }
    Iterator<FlowBuilder> each = flows.iterator();
    List visitables = _visitables.get("flows");
    while (each.hasNext()) {
        FlowBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public FlowsNested<A> setNewFlowLike(int index,Flow item) {
    return new FlowsNested(index, item);
  }
  
  public A setToFlows(int index,Flow item) {
    if (this.flows == null) {
      this.flows = new ArrayList();
    }
    FlowBuilder builder = new FlowBuilder(item);
    if (index < 0 || index >= flows.size()) {
        _visitables.get("flows").add(builder);
        flows.add(builder);
    } else {
        _visitables.get("flows").add(builder);
        flows.set(index, builder);
    }
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(flows == null) && !(flows.isEmpty())) {
        sb.append("flows:");
        sb.append(flows);
        sb.append(",");
    }
    if (!(jobRetainPolicy == null)) {
        sb.append("jobRetainPolicy:");
        sb.append(jobRetainPolicy);
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
  
  public A withFlows(List<Flow> flows) {
    if (this.flows != null) {
      this._visitables.get("flows").clear();
    }
    if (flows != null) {
        this.flows = new ArrayList();
        for (Flow item : flows) {
          this.addToFlows(item);
        }
    } else {
      this.flows = null;
    }
    return (A) this;
  }
  
  public A withFlows(Flow... flows) {
    if (this.flows != null) {
        this.flows.clear();
        _visitables.remove("flows");
    }
    if (flows != null) {
      for (Flow item : flows) {
        this.addToFlows(item);
      }
    }
    return (A) this;
  }
  
  public A withJobRetainPolicy(String jobRetainPolicy) {
    this.jobRetainPolicy = jobRetainPolicy;
    return (A) this;
  }
  public class FlowsNested<N> extends FlowFluent<FlowsNested<N>> implements Nested<N>{
  
    FlowBuilder builder;
    int index;
  
    FlowsNested(int index,Flow item) {
      this.index = index;
      this.builder = new FlowBuilder(this, item);
    }
  
    public N and() {
      return (N) JobFlowSpecFluent.this.setToFlows(index, builder.build());
    }
    
    public N endFlow() {
      return and();
    }
    
  }
}