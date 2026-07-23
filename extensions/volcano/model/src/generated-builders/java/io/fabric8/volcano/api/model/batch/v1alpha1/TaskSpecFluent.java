package io.fabric8.volcano.api.model.batch.v1alpha1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import io.fabric8.kubernetes.api.model.PodTemplateSpec;
import io.fabric8.kubernetes.api.model.PodTemplateSpecBuilder;
import io.fabric8.kubernetes.api.model.PodTemplateSpecFluent;
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
public class TaskSpecFluent<A extends io.fabric8.volcano.api.model.batch.v1alpha1.TaskSpecFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private DependsOnBuilder dependsOn;
  private Integer maxRetry;
  private Integer minAvailable;
  private String name;
  private ArrayList<LifecyclePolicyBuilder> policies = new ArrayList<LifecyclePolicyBuilder>();
  private Integer replicas;
  private PodTemplateSpecBuilder template;
  private String topologyPolicy;

  public TaskSpecFluent() {
  }
  
  public TaskSpecFluent(TaskSpec instance) {
    this.copyInstance(instance);
  }

  public A addAllToPolicies(Collection<LifecyclePolicy> items) {
    if (this.policies == null) {
      this.policies = new ArrayList();
    }
    for (LifecyclePolicy item : items) {
        LifecyclePolicyBuilder builder = new LifecyclePolicyBuilder(item);
        _visitables.get("policies").add(builder);
        this.policies.add(builder);
    }
    return (A) this;
  }
  
  public PoliciesNested<A> addNewPolicy() {
    return new PoliciesNested(-1, null);
  }
  
  public PoliciesNested<A> addNewPolicyLike(LifecyclePolicy item) {
    return new PoliciesNested(-1, item);
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
  
  public A addToPolicies(LifecyclePolicy... items) {
    if (this.policies == null) {
      this.policies = new ArrayList();
    }
    for (LifecyclePolicy item : items) {
        LifecyclePolicyBuilder builder = new LifecyclePolicyBuilder(item);
        _visitables.get("policies").add(builder);
        this.policies.add(builder);
    }
    return (A) this;
  }
  
  public A addToPolicies(int index,LifecyclePolicy item) {
    if (this.policies == null) {
      this.policies = new ArrayList();
    }
    LifecyclePolicyBuilder builder = new LifecyclePolicyBuilder(item);
    if (index < 0 || index >= policies.size()) {
        _visitables.get("policies").add(builder);
        policies.add(builder);
    } else {
        _visitables.get("policies").add(builder);
        policies.add(index, builder);
    }
    return (A) this;
  }
  
  public DependsOn buildDependsOn() {
    return this.dependsOn != null ? this.dependsOn.build() : null;
  }
  
  public LifecyclePolicy buildFirstPolicy() {
    return this.policies.get(0).build();
  }
  
  public LifecyclePolicy buildLastPolicy() {
    return this.policies.get(policies.size() - 1).build();
  }
  
  public LifecyclePolicy buildMatchingPolicy(Predicate<LifecyclePolicyBuilder> predicate) {
      for (LifecyclePolicyBuilder item : policies) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public List<LifecyclePolicy> buildPolicies() {
    return this.policies != null ? build(policies) : null;
  }
  
  public LifecyclePolicy buildPolicy(int index) {
    return this.policies.get(index).build();
  }
  
  public PodTemplateSpec buildTemplate() {
    return this.template != null ? this.template.build() : null;
  }
  
  protected void copyInstance(TaskSpec instance) {
    instance = instance != null ? instance : new TaskSpec();
    if (instance != null) {
        this.withDependsOn(instance.getDependsOn());
        this.withMaxRetry(instance.getMaxRetry());
        this.withMinAvailable(instance.getMinAvailable());
        this.withName(instance.getName());
        this.withPolicies(instance.getPolicies());
        this.withReplicas(instance.getReplicas());
        this.withTemplate(instance.getTemplate());
        this.withTopologyPolicy(instance.getTopologyPolicy());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public DependsOnNested<A> editDependsOn() {
    return this.withNewDependsOnLike(Optional.ofNullable(this.buildDependsOn()).orElse(null));
  }
  
  public PoliciesNested<A> editFirstPolicy() {
    if (policies.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "policies"));
    }
    return this.setNewPolicyLike(0, this.buildPolicy(0));
  }
  
  public PoliciesNested<A> editLastPolicy() {
    int index = policies.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "policies"));
    }
    return this.setNewPolicyLike(index, this.buildPolicy(index));
  }
  
  public PoliciesNested<A> editMatchingPolicy(Predicate<LifecyclePolicyBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < policies.size();i++) {
      if (predicate.test(policies.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "policies"));
    }
    return this.setNewPolicyLike(index, this.buildPolicy(index));
  }
  
  public DependsOnNested<A> editOrNewDependsOn() {
    return this.withNewDependsOnLike(Optional.ofNullable(this.buildDependsOn()).orElse(new DependsOnBuilder().build()));
  }
  
  public DependsOnNested<A> editOrNewDependsOnLike(DependsOn item) {
    return this.withNewDependsOnLike(Optional.ofNullable(this.buildDependsOn()).orElse(item));
  }
  
  public TemplateNested<A> editOrNewTemplate() {
    return this.withNewTemplateLike(Optional.ofNullable(this.buildTemplate()).orElse(new PodTemplateSpecBuilder().build()));
  }
  
  public TemplateNested<A> editOrNewTemplateLike(PodTemplateSpec item) {
    return this.withNewTemplateLike(Optional.ofNullable(this.buildTemplate()).orElse(item));
  }
  
  public PoliciesNested<A> editPolicy(int index) {
    if (policies.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "policies"));
    }
    return this.setNewPolicyLike(index, this.buildPolicy(index));
  }
  
  public TemplateNested<A> editTemplate() {
    return this.withNewTemplateLike(Optional.ofNullable(this.buildTemplate()).orElse(null));
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
    TaskSpecFluent that = (TaskSpecFluent) o;
    if (!(Objects.equals(dependsOn, that.dependsOn))) {
      return false;
    }
    if (!(Objects.equals(maxRetry, that.maxRetry))) {
      return false;
    }
    if (!(Objects.equals(minAvailable, that.minAvailable))) {
      return false;
    }
    if (!(Objects.equals(name, that.name))) {
      return false;
    }
    if (!(Objects.equals(policies, that.policies))) {
      return false;
    }
    if (!(Objects.equals(replicas, that.replicas))) {
      return false;
    }
    if (!(Objects.equals(template, that.template))) {
      return false;
    }
    if (!(Objects.equals(topologyPolicy, that.topologyPolicy))) {
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
  
  public Integer getMaxRetry() {
    return this.maxRetry;
  }
  
  public Integer getMinAvailable() {
    return this.minAvailable;
  }
  
  public String getName() {
    return this.name;
  }
  
  public Integer getReplicas() {
    return this.replicas;
  }
  
  public String getTopologyPolicy() {
    return this.topologyPolicy;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasDependsOn() {
    return this.dependsOn != null;
  }
  
  public boolean hasMatchingPolicy(Predicate<LifecyclePolicyBuilder> predicate) {
      for (LifecyclePolicyBuilder item : policies) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMaxRetry() {
    return this.maxRetry != null;
  }
  
  public boolean hasMinAvailable() {
    return this.minAvailable != null;
  }
  
  public boolean hasName() {
    return this.name != null;
  }
  
  public boolean hasPolicies() {
    return this.policies != null && !(this.policies.isEmpty());
  }
  
  public boolean hasReplicas() {
    return this.replicas != null;
  }
  
  public boolean hasTemplate() {
    return this.template != null;
  }
  
  public boolean hasTopologyPolicy() {
    return this.topologyPolicy != null;
  }
  
  public int hashCode() {
    return Objects.hash(dependsOn, maxRetry, minAvailable, name, policies, replicas, template, topologyPolicy, additionalProperties);
  }
  
  public A removeAllFromPolicies(Collection<LifecyclePolicy> items) {
    if (this.policies == null) {
      return (A) this;
    }
    for (LifecyclePolicy item : items) {
        LifecyclePolicyBuilder builder = new LifecyclePolicyBuilder(item);
        _visitables.get("policies").remove(builder);
        this.policies.remove(builder);
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
  
  public A removeFromPolicies(LifecyclePolicy... items) {
    if (this.policies == null) {
      return (A) this;
    }
    for (LifecyclePolicy item : items) {
        LifecyclePolicyBuilder builder = new LifecyclePolicyBuilder(item);
        _visitables.get("policies").remove(builder);
        this.policies.remove(builder);
    }
    return (A) this;
  }
  
  public A removeMatchingFromPolicies(Predicate<LifecyclePolicyBuilder> predicate) {
    if (policies == null) {
      return (A) this;
    }
    Iterator<LifecyclePolicyBuilder> each = policies.iterator();
    List visitables = _visitables.get("policies");
    while (each.hasNext()) {
        LifecyclePolicyBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public PoliciesNested<A> setNewPolicyLike(int index,LifecyclePolicy item) {
    return new PoliciesNested(index, item);
  }
  
  public A setToPolicies(int index,LifecyclePolicy item) {
    if (this.policies == null) {
      this.policies = new ArrayList();
    }
    LifecyclePolicyBuilder builder = new LifecyclePolicyBuilder(item);
    if (index < 0 || index >= policies.size()) {
        _visitables.get("policies").add(builder);
        policies.add(builder);
    } else {
        _visitables.get("policies").add(builder);
        policies.set(index, builder);
    }
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(dependsOn == null)) {
        sb.append("dependsOn:");
        sb.append(dependsOn);
        sb.append(",");
    }
    if (!(maxRetry == null)) {
        sb.append("maxRetry:");
        sb.append(maxRetry);
        sb.append(",");
    }
    if (!(minAvailable == null)) {
        sb.append("minAvailable:");
        sb.append(minAvailable);
        sb.append(",");
    }
    if (!(name == null)) {
        sb.append("name:");
        sb.append(name);
        sb.append(",");
    }
    if (!(policies == null) && !(policies.isEmpty())) {
        sb.append("policies:");
        sb.append(policies);
        sb.append(",");
    }
    if (!(replicas == null)) {
        sb.append("replicas:");
        sb.append(replicas);
        sb.append(",");
    }
    if (!(template == null)) {
        sb.append("template:");
        sb.append(template);
        sb.append(",");
    }
    if (!(topologyPolicy == null)) {
        sb.append("topologyPolicy:");
        sb.append(topologyPolicy);
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
  
  public A withDependsOn(DependsOn dependsOn) {
    this._visitables.remove("dependsOn");
    if (dependsOn != null) {
        this.dependsOn = new DependsOnBuilder(dependsOn);
        this._visitables.get("dependsOn").add(this.dependsOn);
    } else {
        this.dependsOn = null;
        this._visitables.get("dependsOn").remove(this.dependsOn);
    }
    return (A) this;
  }
  
  public A withMaxRetry(Integer maxRetry) {
    this.maxRetry = maxRetry;
    return (A) this;
  }
  
  public A withMinAvailable(Integer minAvailable) {
    this.minAvailable = minAvailable;
    return (A) this;
  }
  
  public A withName(String name) {
    this.name = name;
    return (A) this;
  }
  
  public DependsOnNested<A> withNewDependsOn() {
    return new DependsOnNested(null);
  }
  
  public DependsOnNested<A> withNewDependsOnLike(DependsOn item) {
    return new DependsOnNested(item);
  }
  
  public TemplateNested<A> withNewTemplate() {
    return new TemplateNested(null);
  }
  
  public TemplateNested<A> withNewTemplateLike(PodTemplateSpec item) {
    return new TemplateNested(item);
  }
  
  public A withPolicies(List<LifecyclePolicy> policies) {
    if (this.policies != null) {
      this._visitables.get("policies").clear();
    }
    if (policies != null) {
        this.policies = new ArrayList();
        for (LifecyclePolicy item : policies) {
          this.addToPolicies(item);
        }
    } else {
      this.policies = null;
    }
    return (A) this;
  }
  
  public A withPolicies(LifecyclePolicy... policies) {
    if (this.policies != null) {
        this.policies.clear();
        _visitables.remove("policies");
    }
    if (policies != null) {
      for (LifecyclePolicy item : policies) {
        this.addToPolicies(item);
      }
    }
    return (A) this;
  }
  
  public A withReplicas(Integer replicas) {
    this.replicas = replicas;
    return (A) this;
  }
  
  public A withTemplate(PodTemplateSpec template) {
    this._visitables.remove("template");
    if (template != null) {
        this.template = new PodTemplateSpecBuilder(template);
        this._visitables.get("template").add(this.template);
    } else {
        this.template = null;
        this._visitables.get("template").remove(this.template);
    }
    return (A) this;
  }
  
  public A withTopologyPolicy(String topologyPolicy) {
    this.topologyPolicy = topologyPolicy;
    return (A) this;
  }
  public class DependsOnNested<N> extends DependsOnFluent<DependsOnNested<N>> implements Nested<N>{
  
    DependsOnBuilder builder;
  
    DependsOnNested(DependsOn item) {
      this.builder = new DependsOnBuilder(this, item);
    }
  
    public N and() {
      return (N) TaskSpecFluent.this.withDependsOn(builder.build());
    }
    
    public N endDependsOn() {
      return and();
    }
    
  }
  public class PoliciesNested<N> extends LifecyclePolicyFluent<PoliciesNested<N>> implements Nested<N>{
  
    LifecyclePolicyBuilder builder;
    int index;
  
    PoliciesNested(int index,LifecyclePolicy item) {
      this.index = index;
      this.builder = new LifecyclePolicyBuilder(this, item);
    }
  
    public N and() {
      return (N) TaskSpecFluent.this.setToPolicies(index, builder.build());
    }
    
    public N endPolicy() {
      return and();
    }
    
  }
  public class TemplateNested<N> extends PodTemplateSpecFluent<TemplateNested<N>> implements Nested<N>{
  
    PodTemplateSpecBuilder builder;
  
    TemplateNested(PodTemplateSpec item) {
      this.builder = new PodTemplateSpecBuilder(this, item);
    }
  
    public N and() {
      return (N) TaskSpecFluent.this.withTemplate(builder.build());
    }
    
    public N endTemplate() {
      return and();
    }
    
  }
}