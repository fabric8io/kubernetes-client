package io.fabric8.kubernetes.api.model.flowcontrol.v1beta3;

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
public class FlowSchemaSpecFluent<A extends io.fabric8.kubernetes.api.model.flowcontrol.v1beta3.FlowSchemaSpecFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private FlowDistinguisherMethodBuilder distinguisherMethod;
  private Integer matchingPrecedence;
  private PriorityLevelConfigurationReferenceBuilder priorityLevelConfiguration;
  private ArrayList<PolicyRulesWithSubjectsBuilder> rules = new ArrayList<PolicyRulesWithSubjectsBuilder>();

  public FlowSchemaSpecFluent() {
  }
  
  public FlowSchemaSpecFluent(FlowSchemaSpec instance) {
    this.copyInstance(instance);
  }

  public A addAllToRules(Collection<PolicyRulesWithSubjects> items) {
    if (this.rules == null) {
      this.rules = new ArrayList();
    }
    for (PolicyRulesWithSubjects item : items) {
        PolicyRulesWithSubjectsBuilder builder = new PolicyRulesWithSubjectsBuilder(item);
        _visitables.get("rules").add(builder);
        this.rules.add(builder);
    }
    return (A) this;
  }
  
  public RulesNested<A> addNewRule() {
    return new RulesNested(-1, null);
  }
  
  public RulesNested<A> addNewRuleLike(PolicyRulesWithSubjects item) {
    return new RulesNested(-1, item);
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
  
  public A addToRules(PolicyRulesWithSubjects... items) {
    if (this.rules == null) {
      this.rules = new ArrayList();
    }
    for (PolicyRulesWithSubjects item : items) {
        PolicyRulesWithSubjectsBuilder builder = new PolicyRulesWithSubjectsBuilder(item);
        _visitables.get("rules").add(builder);
        this.rules.add(builder);
    }
    return (A) this;
  }
  
  public A addToRules(int index,PolicyRulesWithSubjects item) {
    if (this.rules == null) {
      this.rules = new ArrayList();
    }
    PolicyRulesWithSubjectsBuilder builder = new PolicyRulesWithSubjectsBuilder(item);
    if (index < 0 || index >= rules.size()) {
        _visitables.get("rules").add(builder);
        rules.add(builder);
    } else {
        _visitables.get("rules").add(builder);
        rules.add(index, builder);
    }
    return (A) this;
  }
  
  public FlowDistinguisherMethod buildDistinguisherMethod() {
    return this.distinguisherMethod != null ? this.distinguisherMethod.build() : null;
  }
  
  public PolicyRulesWithSubjects buildFirstRule() {
    return this.rules.get(0).build();
  }
  
  public PolicyRulesWithSubjects buildLastRule() {
    return this.rules.get(rules.size() - 1).build();
  }
  
  public PolicyRulesWithSubjects buildMatchingRule(Predicate<PolicyRulesWithSubjectsBuilder> predicate) {
      for (PolicyRulesWithSubjectsBuilder item : rules) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public PriorityLevelConfigurationReference buildPriorityLevelConfiguration() {
    return this.priorityLevelConfiguration != null ? this.priorityLevelConfiguration.build() : null;
  }
  
  public PolicyRulesWithSubjects buildRule(int index) {
    return this.rules.get(index).build();
  }
  
  public List<PolicyRulesWithSubjects> buildRules() {
    return this.rules != null ? build(rules) : null;
  }
  
  protected void copyInstance(FlowSchemaSpec instance) {
    instance = instance != null ? instance : new FlowSchemaSpec();
    if (instance != null) {
        this.withDistinguisherMethod(instance.getDistinguisherMethod());
        this.withMatchingPrecedence(instance.getMatchingPrecedence());
        this.withPriorityLevelConfiguration(instance.getPriorityLevelConfiguration());
        this.withRules(instance.getRules());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public DistinguisherMethodNested<A> editDistinguisherMethod() {
    return this.withNewDistinguisherMethodLike(Optional.ofNullable(this.buildDistinguisherMethod()).orElse(null));
  }
  
  public RulesNested<A> editFirstRule() {
    if (rules.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "rules"));
    }
    return this.setNewRuleLike(0, this.buildRule(0));
  }
  
  public RulesNested<A> editLastRule() {
    int index = rules.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "rules"));
    }
    return this.setNewRuleLike(index, this.buildRule(index));
  }
  
  public RulesNested<A> editMatchingRule(Predicate<PolicyRulesWithSubjectsBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < rules.size();i++) {
      if (predicate.test(rules.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "rules"));
    }
    return this.setNewRuleLike(index, this.buildRule(index));
  }
  
  public DistinguisherMethodNested<A> editOrNewDistinguisherMethod() {
    return this.withNewDistinguisherMethodLike(Optional.ofNullable(this.buildDistinguisherMethod()).orElse(new FlowDistinguisherMethodBuilder().build()));
  }
  
  public DistinguisherMethodNested<A> editOrNewDistinguisherMethodLike(FlowDistinguisherMethod item) {
    return this.withNewDistinguisherMethodLike(Optional.ofNullable(this.buildDistinguisherMethod()).orElse(item));
  }
  
  public PriorityLevelConfigurationNested<A> editOrNewPriorityLevelConfiguration() {
    return this.withNewPriorityLevelConfigurationLike(Optional.ofNullable(this.buildPriorityLevelConfiguration()).orElse(new PriorityLevelConfigurationReferenceBuilder().build()));
  }
  
  public PriorityLevelConfigurationNested<A> editOrNewPriorityLevelConfigurationLike(PriorityLevelConfigurationReference item) {
    return this.withNewPriorityLevelConfigurationLike(Optional.ofNullable(this.buildPriorityLevelConfiguration()).orElse(item));
  }
  
  public PriorityLevelConfigurationNested<A> editPriorityLevelConfiguration() {
    return this.withNewPriorityLevelConfigurationLike(Optional.ofNullable(this.buildPriorityLevelConfiguration()).orElse(null));
  }
  
  public RulesNested<A> editRule(int index) {
    if (rules.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "rules"));
    }
    return this.setNewRuleLike(index, this.buildRule(index));
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
    FlowSchemaSpecFluent that = (FlowSchemaSpecFluent) o;
    if (!(Objects.equals(distinguisherMethod, that.distinguisherMethod))) {
      return false;
    }
    if (!(Objects.equals(matchingPrecedence, that.matchingPrecedence))) {
      return false;
    }
    if (!(Objects.equals(priorityLevelConfiguration, that.priorityLevelConfiguration))) {
      return false;
    }
    if (!(Objects.equals(rules, that.rules))) {
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
  
  public Integer getMatchingPrecedence() {
    return this.matchingPrecedence;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasDistinguisherMethod() {
    return this.distinguisherMethod != null;
  }
  
  public boolean hasMatchingPrecedence() {
    return this.matchingPrecedence != null;
  }
  
  public boolean hasMatchingRule(Predicate<PolicyRulesWithSubjectsBuilder> predicate) {
      for (PolicyRulesWithSubjectsBuilder item : rules) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasPriorityLevelConfiguration() {
    return this.priorityLevelConfiguration != null;
  }
  
  public boolean hasRules() {
    return this.rules != null && !(this.rules.isEmpty());
  }
  
  public int hashCode() {
    return Objects.hash(distinguisherMethod, matchingPrecedence, priorityLevelConfiguration, rules, additionalProperties);
  }
  
  public A removeAllFromRules(Collection<PolicyRulesWithSubjects> items) {
    if (this.rules == null) {
      return (A) this;
    }
    for (PolicyRulesWithSubjects item : items) {
        PolicyRulesWithSubjectsBuilder builder = new PolicyRulesWithSubjectsBuilder(item);
        _visitables.get("rules").remove(builder);
        this.rules.remove(builder);
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
  
  public A removeFromRules(PolicyRulesWithSubjects... items) {
    if (this.rules == null) {
      return (A) this;
    }
    for (PolicyRulesWithSubjects item : items) {
        PolicyRulesWithSubjectsBuilder builder = new PolicyRulesWithSubjectsBuilder(item);
        _visitables.get("rules").remove(builder);
        this.rules.remove(builder);
    }
    return (A) this;
  }
  
  public A removeMatchingFromRules(Predicate<PolicyRulesWithSubjectsBuilder> predicate) {
    if (rules == null) {
      return (A) this;
    }
    Iterator<PolicyRulesWithSubjectsBuilder> each = rules.iterator();
    List visitables = _visitables.get("rules");
    while (each.hasNext()) {
        PolicyRulesWithSubjectsBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public RulesNested<A> setNewRuleLike(int index,PolicyRulesWithSubjects item) {
    return new RulesNested(index, item);
  }
  
  public A setToRules(int index,PolicyRulesWithSubjects item) {
    if (this.rules == null) {
      this.rules = new ArrayList();
    }
    PolicyRulesWithSubjectsBuilder builder = new PolicyRulesWithSubjectsBuilder(item);
    if (index < 0 || index >= rules.size()) {
        _visitables.get("rules").add(builder);
        rules.add(builder);
    } else {
        _visitables.get("rules").add(builder);
        rules.set(index, builder);
    }
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(distinguisherMethod == null)) {
        sb.append("distinguisherMethod:");
        sb.append(distinguisherMethod);
        sb.append(",");
    }
    if (!(matchingPrecedence == null)) {
        sb.append("matchingPrecedence:");
        sb.append(matchingPrecedence);
        sb.append(",");
    }
    if (!(priorityLevelConfiguration == null)) {
        sb.append("priorityLevelConfiguration:");
        sb.append(priorityLevelConfiguration);
        sb.append(",");
    }
    if (!(rules == null) && !(rules.isEmpty())) {
        sb.append("rules:");
        sb.append(rules);
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
  
  public A withDistinguisherMethod(FlowDistinguisherMethod distinguisherMethod) {
    this._visitables.remove("distinguisherMethod");
    if (distinguisherMethod != null) {
        this.distinguisherMethod = new FlowDistinguisherMethodBuilder(distinguisherMethod);
        this._visitables.get("distinguisherMethod").add(this.distinguisherMethod);
    } else {
        this.distinguisherMethod = null;
        this._visitables.get("distinguisherMethod").remove(this.distinguisherMethod);
    }
    return (A) this;
  }
  
  public A withMatchingPrecedence(Integer matchingPrecedence) {
    this.matchingPrecedence = matchingPrecedence;
    return (A) this;
  }
  
  public DistinguisherMethodNested<A> withNewDistinguisherMethod() {
    return new DistinguisherMethodNested(null);
  }
  
  public A withNewDistinguisherMethod(String type) {
    return (A) this.withDistinguisherMethod(new FlowDistinguisherMethod(type));
  }
  
  public DistinguisherMethodNested<A> withNewDistinguisherMethodLike(FlowDistinguisherMethod item) {
    return new DistinguisherMethodNested(item);
  }
  
  public PriorityLevelConfigurationNested<A> withNewPriorityLevelConfiguration() {
    return new PriorityLevelConfigurationNested(null);
  }
  
  public A withNewPriorityLevelConfiguration(String name) {
    return (A) this.withPriorityLevelConfiguration(new PriorityLevelConfigurationReference(name));
  }
  
  public PriorityLevelConfigurationNested<A> withNewPriorityLevelConfigurationLike(PriorityLevelConfigurationReference item) {
    return new PriorityLevelConfigurationNested(item);
  }
  
  public A withPriorityLevelConfiguration(PriorityLevelConfigurationReference priorityLevelConfiguration) {
    this._visitables.remove("priorityLevelConfiguration");
    if (priorityLevelConfiguration != null) {
        this.priorityLevelConfiguration = new PriorityLevelConfigurationReferenceBuilder(priorityLevelConfiguration);
        this._visitables.get("priorityLevelConfiguration").add(this.priorityLevelConfiguration);
    } else {
        this.priorityLevelConfiguration = null;
        this._visitables.get("priorityLevelConfiguration").remove(this.priorityLevelConfiguration);
    }
    return (A) this;
  }
  
  public A withRules(List<PolicyRulesWithSubjects> rules) {
    if (this.rules != null) {
      this._visitables.get("rules").clear();
    }
    if (rules != null) {
        this.rules = new ArrayList();
        for (PolicyRulesWithSubjects item : rules) {
          this.addToRules(item);
        }
    } else {
      this.rules = null;
    }
    return (A) this;
  }
  
  public A withRules(PolicyRulesWithSubjects... rules) {
    if (this.rules != null) {
        this.rules.clear();
        _visitables.remove("rules");
    }
    if (rules != null) {
      for (PolicyRulesWithSubjects item : rules) {
        this.addToRules(item);
      }
    }
    return (A) this;
  }
  public class DistinguisherMethodNested<N> extends FlowDistinguisherMethodFluent<DistinguisherMethodNested<N>> implements Nested<N>{
  
    FlowDistinguisherMethodBuilder builder;
  
    DistinguisherMethodNested(FlowDistinguisherMethod item) {
      this.builder = new FlowDistinguisherMethodBuilder(this, item);
    }
  
    public N and() {
      return (N) FlowSchemaSpecFluent.this.withDistinguisherMethod(builder.build());
    }
    
    public N endDistinguisherMethod() {
      return and();
    }
    
  }
  public class PriorityLevelConfigurationNested<N> extends PriorityLevelConfigurationReferenceFluent<PriorityLevelConfigurationNested<N>> implements Nested<N>{
  
    PriorityLevelConfigurationReferenceBuilder builder;
  
    PriorityLevelConfigurationNested(PriorityLevelConfigurationReference item) {
      this.builder = new PriorityLevelConfigurationReferenceBuilder(this, item);
    }
  
    public N and() {
      return (N) FlowSchemaSpecFluent.this.withPriorityLevelConfiguration(builder.build());
    }
    
    public N endPriorityLevelConfiguration() {
      return and();
    }
    
  }
  public class RulesNested<N> extends PolicyRulesWithSubjectsFluent<RulesNested<N>> implements Nested<N>{
  
    PolicyRulesWithSubjectsBuilder builder;
    int index;
  
    RulesNested(int index,PolicyRulesWithSubjects item) {
      this.index = index;
      this.builder = new PolicyRulesWithSubjectsBuilder(this, item);
    }
  
    public N and() {
      return (N) FlowSchemaSpecFluent.this.setToRules(index, builder.build());
    }
    
    public N endRule() {
      return and();
    }
    
  }
}