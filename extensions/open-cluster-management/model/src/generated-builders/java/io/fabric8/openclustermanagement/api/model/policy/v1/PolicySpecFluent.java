package io.fabric8.openclustermanagement.api.model.policy.v1;

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
public class PolicySpecFluent<A extends io.fabric8.openclustermanagement.api.model.policy.v1.PolicySpecFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private Boolean copyPolicyMetadata;
  private ArrayList<PolicyDependencyBuilder> dependencies = new ArrayList<PolicyDependencyBuilder>();
  private Boolean disabled;
  private HubTemplateOptionsBuilder hubTemplateOptions;
  private ArrayList<PolicyTemplateBuilder> policyTemplates = new ArrayList<PolicyTemplateBuilder>();
  private String remediationAction;

  public PolicySpecFluent() {
  }
  
  public PolicySpecFluent(PolicySpec instance) {
    this.copyInstance(instance);
  }

  public A addAllToDependencies(Collection<PolicyDependency> items) {
    if (this.dependencies == null) {
      this.dependencies = new ArrayList();
    }
    for (PolicyDependency item : items) {
        PolicyDependencyBuilder builder = new PolicyDependencyBuilder(item);
        _visitables.get("dependencies").add(builder);
        this.dependencies.add(builder);
    }
    return (A) this;
  }
  
  public A addAllToPolicyTemplates(Collection<PolicyTemplate> items) {
    if (this.policyTemplates == null) {
      this.policyTemplates = new ArrayList();
    }
    for (PolicyTemplate item : items) {
        PolicyTemplateBuilder builder = new PolicyTemplateBuilder(item);
        _visitables.get("policyTemplates").add(builder);
        this.policyTemplates.add(builder);
    }
    return (A) this;
  }
  
  public DependenciesNested<A> addNewDependency() {
    return new DependenciesNested(-1, null);
  }
  
  public A addNewDependency(String apiVersion,String compliance,String kind,String name,String namespace) {
    return (A) this.addToDependencies(new PolicyDependency(apiVersion, compliance, kind, name, namespace));
  }
  
  public DependenciesNested<A> addNewDependencyLike(PolicyDependency item) {
    return new DependenciesNested(-1, item);
  }
  
  public PolicyTemplatesNested<A> addNewPolicyTemplate() {
    return new PolicyTemplatesNested(-1, null);
  }
  
  public PolicyTemplatesNested<A> addNewPolicyTemplateLike(PolicyTemplate item) {
    return new PolicyTemplatesNested(-1, item);
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
  
  public A addToDependencies(PolicyDependency... items) {
    if (this.dependencies == null) {
      this.dependencies = new ArrayList();
    }
    for (PolicyDependency item : items) {
        PolicyDependencyBuilder builder = new PolicyDependencyBuilder(item);
        _visitables.get("dependencies").add(builder);
        this.dependencies.add(builder);
    }
    return (A) this;
  }
  
  public A addToDependencies(int index,PolicyDependency item) {
    if (this.dependencies == null) {
      this.dependencies = new ArrayList();
    }
    PolicyDependencyBuilder builder = new PolicyDependencyBuilder(item);
    if (index < 0 || index >= dependencies.size()) {
        _visitables.get("dependencies").add(builder);
        dependencies.add(builder);
    } else {
        _visitables.get("dependencies").add(builder);
        dependencies.add(index, builder);
    }
    return (A) this;
  }
  
  public A addToPolicyTemplates(PolicyTemplate... items) {
    if (this.policyTemplates == null) {
      this.policyTemplates = new ArrayList();
    }
    for (PolicyTemplate item : items) {
        PolicyTemplateBuilder builder = new PolicyTemplateBuilder(item);
        _visitables.get("policyTemplates").add(builder);
        this.policyTemplates.add(builder);
    }
    return (A) this;
  }
  
  public A addToPolicyTemplates(int index,PolicyTemplate item) {
    if (this.policyTemplates == null) {
      this.policyTemplates = new ArrayList();
    }
    PolicyTemplateBuilder builder = new PolicyTemplateBuilder(item);
    if (index < 0 || index >= policyTemplates.size()) {
        _visitables.get("policyTemplates").add(builder);
        policyTemplates.add(builder);
    } else {
        _visitables.get("policyTemplates").add(builder);
        policyTemplates.add(index, builder);
    }
    return (A) this;
  }
  
  public List<PolicyDependency> buildDependencies() {
    return this.dependencies != null ? build(dependencies) : null;
  }
  
  public PolicyDependency buildDependency(int index) {
    return this.dependencies.get(index).build();
  }
  
  public PolicyDependency buildFirstDependency() {
    return this.dependencies.get(0).build();
  }
  
  public PolicyTemplate buildFirstPolicyTemplate() {
    return this.policyTemplates.get(0).build();
  }
  
  public HubTemplateOptions buildHubTemplateOptions() {
    return this.hubTemplateOptions != null ? this.hubTemplateOptions.build() : null;
  }
  
  public PolicyDependency buildLastDependency() {
    return this.dependencies.get(dependencies.size() - 1).build();
  }
  
  public PolicyTemplate buildLastPolicyTemplate() {
    return this.policyTemplates.get(policyTemplates.size() - 1).build();
  }
  
  public PolicyDependency buildMatchingDependency(Predicate<PolicyDependencyBuilder> predicate) {
      for (PolicyDependencyBuilder item : dependencies) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public PolicyTemplate buildMatchingPolicyTemplate(Predicate<PolicyTemplateBuilder> predicate) {
      for (PolicyTemplateBuilder item : policyTemplates) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public PolicyTemplate buildPolicyTemplate(int index) {
    return this.policyTemplates.get(index).build();
  }
  
  public List<PolicyTemplate> buildPolicyTemplates() {
    return this.policyTemplates != null ? build(policyTemplates) : null;
  }
  
  protected void copyInstance(PolicySpec instance) {
    instance = instance != null ? instance : new PolicySpec();
    if (instance != null) {
        this.withCopyPolicyMetadata(instance.getCopyPolicyMetadata());
        this.withDependencies(instance.getDependencies());
        this.withDisabled(instance.getDisabled());
        this.withHubTemplateOptions(instance.getHubTemplateOptions());
        this.withPolicyTemplates(instance.getPolicyTemplates());
        this.withRemediationAction(instance.getRemediationAction());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public DependenciesNested<A> editDependency(int index) {
    if (dependencies.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "dependencies"));
    }
    return this.setNewDependencyLike(index, this.buildDependency(index));
  }
  
  public DependenciesNested<A> editFirstDependency() {
    if (dependencies.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "dependencies"));
    }
    return this.setNewDependencyLike(0, this.buildDependency(0));
  }
  
  public PolicyTemplatesNested<A> editFirstPolicyTemplate() {
    if (policyTemplates.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "policyTemplates"));
    }
    return this.setNewPolicyTemplateLike(0, this.buildPolicyTemplate(0));
  }
  
  public HubTemplateOptionsNested<A> editHubTemplateOptions() {
    return this.withNewHubTemplateOptionsLike(Optional.ofNullable(this.buildHubTemplateOptions()).orElse(null));
  }
  
  public DependenciesNested<A> editLastDependency() {
    int index = dependencies.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "dependencies"));
    }
    return this.setNewDependencyLike(index, this.buildDependency(index));
  }
  
  public PolicyTemplatesNested<A> editLastPolicyTemplate() {
    int index = policyTemplates.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "policyTemplates"));
    }
    return this.setNewPolicyTemplateLike(index, this.buildPolicyTemplate(index));
  }
  
  public DependenciesNested<A> editMatchingDependency(Predicate<PolicyDependencyBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < dependencies.size();i++) {
      if (predicate.test(dependencies.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "dependencies"));
    }
    return this.setNewDependencyLike(index, this.buildDependency(index));
  }
  
  public PolicyTemplatesNested<A> editMatchingPolicyTemplate(Predicate<PolicyTemplateBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < policyTemplates.size();i++) {
      if (predicate.test(policyTemplates.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "policyTemplates"));
    }
    return this.setNewPolicyTemplateLike(index, this.buildPolicyTemplate(index));
  }
  
  public HubTemplateOptionsNested<A> editOrNewHubTemplateOptions() {
    return this.withNewHubTemplateOptionsLike(Optional.ofNullable(this.buildHubTemplateOptions()).orElse(new HubTemplateOptionsBuilder().build()));
  }
  
  public HubTemplateOptionsNested<A> editOrNewHubTemplateOptionsLike(HubTemplateOptions item) {
    return this.withNewHubTemplateOptionsLike(Optional.ofNullable(this.buildHubTemplateOptions()).orElse(item));
  }
  
  public PolicyTemplatesNested<A> editPolicyTemplate(int index) {
    if (policyTemplates.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "policyTemplates"));
    }
    return this.setNewPolicyTemplateLike(index, this.buildPolicyTemplate(index));
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
    PolicySpecFluent that = (PolicySpecFluent) o;
    if (!(Objects.equals(copyPolicyMetadata, that.copyPolicyMetadata))) {
      return false;
    }
    if (!(Objects.equals(dependencies, that.dependencies))) {
      return false;
    }
    if (!(Objects.equals(disabled, that.disabled))) {
      return false;
    }
    if (!(Objects.equals(hubTemplateOptions, that.hubTemplateOptions))) {
      return false;
    }
    if (!(Objects.equals(policyTemplates, that.policyTemplates))) {
      return false;
    }
    if (!(Objects.equals(remediationAction, that.remediationAction))) {
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
  
  public Boolean getCopyPolicyMetadata() {
    return this.copyPolicyMetadata;
  }
  
  public Boolean getDisabled() {
    return this.disabled;
  }
  
  public String getRemediationAction() {
    return this.remediationAction;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasCopyPolicyMetadata() {
    return this.copyPolicyMetadata != null;
  }
  
  public boolean hasDependencies() {
    return this.dependencies != null && !(this.dependencies.isEmpty());
  }
  
  public boolean hasDisabled() {
    return this.disabled != null;
  }
  
  public boolean hasHubTemplateOptions() {
    return this.hubTemplateOptions != null;
  }
  
  public boolean hasMatchingDependency(Predicate<PolicyDependencyBuilder> predicate) {
      for (PolicyDependencyBuilder item : dependencies) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingPolicyTemplate(Predicate<PolicyTemplateBuilder> predicate) {
      for (PolicyTemplateBuilder item : policyTemplates) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasPolicyTemplates() {
    return this.policyTemplates != null && !(this.policyTemplates.isEmpty());
  }
  
  public boolean hasRemediationAction() {
    return this.remediationAction != null;
  }
  
  public int hashCode() {
    return Objects.hash(copyPolicyMetadata, dependencies, disabled, hubTemplateOptions, policyTemplates, remediationAction, additionalProperties);
  }
  
  public A removeAllFromDependencies(Collection<PolicyDependency> items) {
    if (this.dependencies == null) {
      return (A) this;
    }
    for (PolicyDependency item : items) {
        PolicyDependencyBuilder builder = new PolicyDependencyBuilder(item);
        _visitables.get("dependencies").remove(builder);
        this.dependencies.remove(builder);
    }
    return (A) this;
  }
  
  public A removeAllFromPolicyTemplates(Collection<PolicyTemplate> items) {
    if (this.policyTemplates == null) {
      return (A) this;
    }
    for (PolicyTemplate item : items) {
        PolicyTemplateBuilder builder = new PolicyTemplateBuilder(item);
        _visitables.get("policyTemplates").remove(builder);
        this.policyTemplates.remove(builder);
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
  
  public A removeFromDependencies(PolicyDependency... items) {
    if (this.dependencies == null) {
      return (A) this;
    }
    for (PolicyDependency item : items) {
        PolicyDependencyBuilder builder = new PolicyDependencyBuilder(item);
        _visitables.get("dependencies").remove(builder);
        this.dependencies.remove(builder);
    }
    return (A) this;
  }
  
  public A removeFromPolicyTemplates(PolicyTemplate... items) {
    if (this.policyTemplates == null) {
      return (A) this;
    }
    for (PolicyTemplate item : items) {
        PolicyTemplateBuilder builder = new PolicyTemplateBuilder(item);
        _visitables.get("policyTemplates").remove(builder);
        this.policyTemplates.remove(builder);
    }
    return (A) this;
  }
  
  public A removeMatchingFromDependencies(Predicate<PolicyDependencyBuilder> predicate) {
    if (dependencies == null) {
      return (A) this;
    }
    Iterator<PolicyDependencyBuilder> each = dependencies.iterator();
    List visitables = _visitables.get("dependencies");
    while (each.hasNext()) {
        PolicyDependencyBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public A removeMatchingFromPolicyTemplates(Predicate<PolicyTemplateBuilder> predicate) {
    if (policyTemplates == null) {
      return (A) this;
    }
    Iterator<PolicyTemplateBuilder> each = policyTemplates.iterator();
    List visitables = _visitables.get("policyTemplates");
    while (each.hasNext()) {
        PolicyTemplateBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public DependenciesNested<A> setNewDependencyLike(int index,PolicyDependency item) {
    return new DependenciesNested(index, item);
  }
  
  public PolicyTemplatesNested<A> setNewPolicyTemplateLike(int index,PolicyTemplate item) {
    return new PolicyTemplatesNested(index, item);
  }
  
  public A setToDependencies(int index,PolicyDependency item) {
    if (this.dependencies == null) {
      this.dependencies = new ArrayList();
    }
    PolicyDependencyBuilder builder = new PolicyDependencyBuilder(item);
    if (index < 0 || index >= dependencies.size()) {
        _visitables.get("dependencies").add(builder);
        dependencies.add(builder);
    } else {
        _visitables.get("dependencies").add(builder);
        dependencies.set(index, builder);
    }
    return (A) this;
  }
  
  public A setToPolicyTemplates(int index,PolicyTemplate item) {
    if (this.policyTemplates == null) {
      this.policyTemplates = new ArrayList();
    }
    PolicyTemplateBuilder builder = new PolicyTemplateBuilder(item);
    if (index < 0 || index >= policyTemplates.size()) {
        _visitables.get("policyTemplates").add(builder);
        policyTemplates.add(builder);
    } else {
        _visitables.get("policyTemplates").add(builder);
        policyTemplates.set(index, builder);
    }
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(copyPolicyMetadata == null)) {
        sb.append("copyPolicyMetadata:");
        sb.append(copyPolicyMetadata);
        sb.append(",");
    }
    if (!(dependencies == null) && !(dependencies.isEmpty())) {
        sb.append("dependencies:");
        sb.append(dependencies);
        sb.append(",");
    }
    if (!(disabled == null)) {
        sb.append("disabled:");
        sb.append(disabled);
        sb.append(",");
    }
    if (!(hubTemplateOptions == null)) {
        sb.append("hubTemplateOptions:");
        sb.append(hubTemplateOptions);
        sb.append(",");
    }
    if (!(policyTemplates == null) && !(policyTemplates.isEmpty())) {
        sb.append("policyTemplates:");
        sb.append(policyTemplates);
        sb.append(",");
    }
    if (!(remediationAction == null)) {
        sb.append("remediationAction:");
        sb.append(remediationAction);
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
  
  public A withCopyPolicyMetadata() {
    return withCopyPolicyMetadata(true);
  }
  
  public A withCopyPolicyMetadata(Boolean copyPolicyMetadata) {
    this.copyPolicyMetadata = copyPolicyMetadata;
    return (A) this;
  }
  
  public A withDependencies(List<PolicyDependency> dependencies) {
    if (this.dependencies != null) {
      this._visitables.get("dependencies").clear();
    }
    if (dependencies != null) {
        this.dependencies = new ArrayList();
        for (PolicyDependency item : dependencies) {
          this.addToDependencies(item);
        }
    } else {
      this.dependencies = null;
    }
    return (A) this;
  }
  
  public A withDependencies(PolicyDependency... dependencies) {
    if (this.dependencies != null) {
        this.dependencies.clear();
        _visitables.remove("dependencies");
    }
    if (dependencies != null) {
      for (PolicyDependency item : dependencies) {
        this.addToDependencies(item);
      }
    }
    return (A) this;
  }
  
  public A withDisabled() {
    return withDisabled(true);
  }
  
  public A withDisabled(Boolean disabled) {
    this.disabled = disabled;
    return (A) this;
  }
  
  public A withHubTemplateOptions(HubTemplateOptions hubTemplateOptions) {
    this._visitables.remove("hubTemplateOptions");
    if (hubTemplateOptions != null) {
        this.hubTemplateOptions = new HubTemplateOptionsBuilder(hubTemplateOptions);
        this._visitables.get("hubTemplateOptions").add(this.hubTemplateOptions);
    } else {
        this.hubTemplateOptions = null;
        this._visitables.get("hubTemplateOptions").remove(this.hubTemplateOptions);
    }
    return (A) this;
  }
  
  public HubTemplateOptionsNested<A> withNewHubTemplateOptions() {
    return new HubTemplateOptionsNested(null);
  }
  
  public A withNewHubTemplateOptions(String serviceAccountName) {
    return (A) this.withHubTemplateOptions(new HubTemplateOptions(serviceAccountName));
  }
  
  public HubTemplateOptionsNested<A> withNewHubTemplateOptionsLike(HubTemplateOptions item) {
    return new HubTemplateOptionsNested(item);
  }
  
  public A withPolicyTemplates(List<PolicyTemplate> policyTemplates) {
    if (this.policyTemplates != null) {
      this._visitables.get("policyTemplates").clear();
    }
    if (policyTemplates != null) {
        this.policyTemplates = new ArrayList();
        for (PolicyTemplate item : policyTemplates) {
          this.addToPolicyTemplates(item);
        }
    } else {
      this.policyTemplates = null;
    }
    return (A) this;
  }
  
  public A withPolicyTemplates(PolicyTemplate... policyTemplates) {
    if (this.policyTemplates != null) {
        this.policyTemplates.clear();
        _visitables.remove("policyTemplates");
    }
    if (policyTemplates != null) {
      for (PolicyTemplate item : policyTemplates) {
        this.addToPolicyTemplates(item);
      }
    }
    return (A) this;
  }
  
  public A withRemediationAction(String remediationAction) {
    this.remediationAction = remediationAction;
    return (A) this;
  }
  public class DependenciesNested<N> extends PolicyDependencyFluent<DependenciesNested<N>> implements Nested<N>{
  
    PolicyDependencyBuilder builder;
    int index;
  
    DependenciesNested(int index,PolicyDependency item) {
      this.index = index;
      this.builder = new PolicyDependencyBuilder(this, item);
    }
  
    public N and() {
      return (N) PolicySpecFluent.this.setToDependencies(index, builder.build());
    }
    
    public N endDependency() {
      return and();
    }
    
  }
  public class HubTemplateOptionsNested<N> extends HubTemplateOptionsFluent<HubTemplateOptionsNested<N>> implements Nested<N>{
  
    HubTemplateOptionsBuilder builder;
  
    HubTemplateOptionsNested(HubTemplateOptions item) {
      this.builder = new HubTemplateOptionsBuilder(this, item);
    }
  
    public N and() {
      return (N) PolicySpecFluent.this.withHubTemplateOptions(builder.build());
    }
    
    public N endHubTemplateOptions() {
      return and();
    }
    
  }
  public class PolicyTemplatesNested<N> extends PolicyTemplateFluent<PolicyTemplatesNested<N>> implements Nested<N>{
  
    PolicyTemplateBuilder builder;
    int index;
  
    PolicyTemplatesNested(int index,PolicyTemplate item) {
      this.index = index;
      this.builder = new PolicyTemplateBuilder(this, item);
    }
  
    public N and() {
      return (N) PolicySpecFluent.this.setToPolicyTemplates(index, builder.build());
    }
    
    public N endPolicyTemplate() {
      return and();
    }
    
  }
}