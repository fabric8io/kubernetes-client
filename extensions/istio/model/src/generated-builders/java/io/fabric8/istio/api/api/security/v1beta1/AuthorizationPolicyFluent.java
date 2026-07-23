package io.fabric8.istio.api.api.security.v1beta1;

import io.fabric8.istio.api.api.type.v1beta1.PolicyTargetReference;
import io.fabric8.istio.api.api.type.v1beta1.PolicyTargetReferenceBuilder;
import io.fabric8.istio.api.api.type.v1beta1.PolicyTargetReferenceFluent;
import io.fabric8.istio.api.api.type.v1beta1.WorkloadSelector;
import io.fabric8.istio.api.api.type.v1beta1.WorkloadSelectorBuilder;
import io.fabric8.istio.api.api.type.v1beta1.WorkloadSelectorFluent;
import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import io.fabric8.kubernetes.api.builder.VisitableBuilder;
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
public class AuthorizationPolicyFluent<A extends io.fabric8.istio.api.api.security.v1beta1.AuthorizationPolicyFluent<A>> extends BaseFluent<A>{

  private AuthorizationPolicyAction action;
  private VisitableBuilder<? extends IsAuthorizationPolicyActionDetail,?> actionDetail;
  private Map<String,Object> additionalProperties;
  private ArrayList<RuleBuilder> rules = new ArrayList<RuleBuilder>();
  private WorkloadSelectorBuilder selector;
  private PolicyTargetReferenceBuilder targetRef;
  private ArrayList<PolicyTargetReferenceBuilder> targetRefs = new ArrayList<PolicyTargetReferenceBuilder>();

  public AuthorizationPolicyFluent() {
  }
  
  public AuthorizationPolicyFluent(AuthorizationPolicy instance) {
    this.copyInstance(instance);
  }

  public A addAllToRules(Collection<Rule> items) {
    if (this.rules == null) {
      this.rules = new ArrayList();
    }
    for (Rule item : items) {
        RuleBuilder builder = new RuleBuilder(item);
        _visitables.get("rules").add(builder);
        this.rules.add(builder);
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
  
  public RulesNested<A> addNewRule() {
    return new RulesNested(-1, null);
  }
  
  public RulesNested<A> addNewRuleLike(Rule item) {
    return new RulesNested(-1, item);
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
  
  public A addToRules(Rule... items) {
    if (this.rules == null) {
      this.rules = new ArrayList();
    }
    for (Rule item : items) {
        RuleBuilder builder = new RuleBuilder(item);
        _visitables.get("rules").add(builder);
        this.rules.add(builder);
    }
    return (A) this;
  }
  
  public A addToRules(int index,Rule item) {
    if (this.rules == null) {
      this.rules = new ArrayList();
    }
    RuleBuilder builder = new RuleBuilder(item);
    if (index < 0 || index >= rules.size()) {
        _visitables.get("rules").add(builder);
        rules.add(builder);
    } else {
        _visitables.get("rules").add(builder);
        rules.add(index, builder);
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
  
  public IsAuthorizationPolicyActionDetail buildActionDetail() {
    return this.actionDetail != null ? this.actionDetail.build() : null;
  }
  
  public Rule buildFirstRule() {
    return this.rules.get(0).build();
  }
  
  public PolicyTargetReference buildFirstTargetRef() {
    return this.targetRefs.get(0).build();
  }
  
  public Rule buildLastRule() {
    return this.rules.get(rules.size() - 1).build();
  }
  
  public PolicyTargetReference buildLastTargetRef() {
    return this.targetRefs.get(targetRefs.size() - 1).build();
  }
  
  public Rule buildMatchingRule(Predicate<RuleBuilder> predicate) {
      for (RuleBuilder item : rules) {
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
  
  public Rule buildRule(int index) {
    return this.rules.get(index).build();
  }
  
  public List<Rule> buildRules() {
    return this.rules != null ? build(rules) : null;
  }
  
  public WorkloadSelector buildSelector() {
    return this.selector != null ? this.selector.build() : null;
  }
  
  public PolicyTargetReference buildTargetRef() {
    return this.targetRef != null ? this.targetRef.build() : null;
  }
  
  public PolicyTargetReference buildTargetRef(int index) {
    return this.targetRefs.get(index).build();
  }
  
  public List<PolicyTargetReference> buildTargetRefs() {
    return this.targetRefs != null ? build(targetRefs) : null;
  }
  
  protected static <T>VisitableBuilder<T,?> builder(Object item) {
    switch (item.getClass().getName()) {
      case "AuthorizationPolicyProvider":
    
          return (VisitableBuilder<T,?>) new AuthorizationPolicyProviderBuilder((AuthorizationPolicyProvider) item);
    
      default:
    
          return (VisitableBuilder<T,?>) builderOf(item);
    
    }
  }
  
  protected void copyInstance(AuthorizationPolicy instance) {
    instance = instance != null ? instance : new AuthorizationPolicy();
    if (instance != null) {
        this.withActionDetail(instance.getActionDetail());
        this.withAction(instance.getAction());
        this.withRules(instance.getRules());
        this.withSelector(instance.getSelector());
        this.withTargetRef(instance.getTargetRef());
        this.withTargetRefs(instance.getTargetRefs());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public RulesNested<A> editFirstRule() {
    if (rules.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "rules"));
    }
    return this.setNewRuleLike(0, this.buildRule(0));
  }
  
  public TargetRefsNested<A> editFirstTargetRef() {
    if (targetRefs.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "targetRefs"));
    }
    return this.setNewTargetRefLike(0, this.buildTargetRef(0));
  }
  
  public RulesNested<A> editLastRule() {
    int index = rules.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "rules"));
    }
    return this.setNewRuleLike(index, this.buildRule(index));
  }
  
  public TargetRefsNested<A> editLastTargetRef() {
    int index = targetRefs.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "targetRefs"));
    }
    return this.setNewTargetRefLike(index, this.buildTargetRef(index));
  }
  
  public RulesNested<A> editMatchingRule(Predicate<RuleBuilder> predicate) {
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
  
  public TargetRefNested<A> editOrNewTargetRef() {
    return this.withNewTargetRefLike(Optional.ofNullable(this.buildTargetRef()).orElse(new PolicyTargetReferenceBuilder().build()));
  }
  
  public TargetRefNested<A> editOrNewTargetRefLike(PolicyTargetReference item) {
    return this.withNewTargetRefLike(Optional.ofNullable(this.buildTargetRef()).orElse(item));
  }
  
  public RulesNested<A> editRule(int index) {
    if (rules.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "rules"));
    }
    return this.setNewRuleLike(index, this.buildRule(index));
  }
  
  public SelectorNested<A> editSelector() {
    return this.withNewSelectorLike(Optional.ofNullable(this.buildSelector()).orElse(null));
  }
  
  public TargetRefNested<A> editTargetRef() {
    return this.withNewTargetRefLike(Optional.ofNullable(this.buildTargetRef()).orElse(null));
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
    AuthorizationPolicyFluent that = (AuthorizationPolicyFluent) o;
    if (!(Objects.equals(actionDetail, that.actionDetail))) {
      return false;
    }
    if (!(Objects.equals(action, that.action))) {
      return false;
    }
    if (!(Objects.equals(rules, that.rules))) {
      return false;
    }
    if (!(Objects.equals(selector, that.selector))) {
      return false;
    }
    if (!(Objects.equals(targetRef, that.targetRef))) {
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
  
  public AuthorizationPolicyAction getAction() {
    return this.action;
  }
  
  public Map<String,Object> getAdditionalProperties() {
    return this.additionalProperties;
  }
  
  public boolean hasAction() {
    return this.action != null;
  }
  
  public boolean hasActionDetail() {
    return this.actionDetail != null;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasMatchingRule(Predicate<RuleBuilder> predicate) {
      for (RuleBuilder item : rules) {
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
  
  public boolean hasRules() {
    return this.rules != null && !(this.rules.isEmpty());
  }
  
  public boolean hasSelector() {
    return this.selector != null;
  }
  
  public boolean hasTargetRef() {
    return this.targetRef != null;
  }
  
  public boolean hasTargetRefs() {
    return this.targetRefs != null && !(this.targetRefs.isEmpty());
  }
  
  public int hashCode() {
    return Objects.hash(actionDetail, action, rules, selector, targetRef, targetRefs, additionalProperties);
  }
  
  public A removeAllFromRules(Collection<Rule> items) {
    if (this.rules == null) {
      return (A) this;
    }
    for (Rule item : items) {
        RuleBuilder builder = new RuleBuilder(item);
        _visitables.get("rules").remove(builder);
        this.rules.remove(builder);
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
  
  public A removeFromRules(Rule... items) {
    if (this.rules == null) {
      return (A) this;
    }
    for (Rule item : items) {
        RuleBuilder builder = new RuleBuilder(item);
        _visitables.get("rules").remove(builder);
        this.rules.remove(builder);
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
  
  public A removeMatchingFromRules(Predicate<RuleBuilder> predicate) {
    if (rules == null) {
      return (A) this;
    }
    Iterator<RuleBuilder> each = rules.iterator();
    List visitables = _visitables.get("rules");
    while (each.hasNext()) {
        RuleBuilder builder = each.next();
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
  
  public RulesNested<A> setNewRuleLike(int index,Rule item) {
    return new RulesNested(index, item);
  }
  
  public TargetRefsNested<A> setNewTargetRefLike(int index,PolicyTargetReference item) {
    return new TargetRefsNested(index, item);
  }
  
  public A setToRules(int index,Rule item) {
    if (this.rules == null) {
      this.rules = new ArrayList();
    }
    RuleBuilder builder = new RuleBuilder(item);
    if (index < 0 || index >= rules.size()) {
        _visitables.get("rules").add(builder);
        rules.add(builder);
    } else {
        _visitables.get("rules").add(builder);
        rules.set(index, builder);
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
    if (!(actionDetail == null)) {
        sb.append("actionDetail:");
        sb.append(actionDetail);
        sb.append(",");
    }
    if (!(action == null)) {
        sb.append("action:");
        sb.append(action);
        sb.append(",");
    }
    if (!(rules == null) && !(rules.isEmpty())) {
        sb.append("rules:");
        sb.append(rules);
        sb.append(",");
    }
    if (!(selector == null)) {
        sb.append("selector:");
        sb.append(selector);
        sb.append(",");
    }
    if (!(targetRef == null)) {
        sb.append("targetRef:");
        sb.append(targetRef);
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
  
  public A withAction(AuthorizationPolicyAction action) {
    this.action = action;
    return (A) this;
  }
  
  public A withActionDetail(IsAuthorizationPolicyActionDetail actionDetail) {
    if (actionDetail == null) {
        this.actionDetail = null;
        this._visitables.remove("actionDetail");
        return (A) this;
    } else {
        VisitableBuilder<? extends IsAuthorizationPolicyActionDetail,?> builder = builder(actionDetail);
        this._visitables.get("actionDetail").clear();
        this._visitables.get("actionDetail").add(builder);
        this.actionDetail = builder;
        return (A) this;
    }
  }
  
  public <K,V>A withAdditionalProperties(Map<String,Object> additionalProperties) {
    if (additionalProperties == null) {
      this.additionalProperties = null;
    } else {
      this.additionalProperties = new LinkedHashMap(additionalProperties);
    }
    return (A) this;
  }
  
  public AuthorizationPolicyProviderActionDetailNested<A> withNewAuthorizationPolicyProviderActionDetail() {
    return new AuthorizationPolicyProviderActionDetailNested(null);
  }
  
  public AuthorizationPolicyProviderActionDetailNested<A> withNewAuthorizationPolicyProviderActionDetailLike(AuthorizationPolicyProvider item) {
    return new AuthorizationPolicyProviderActionDetailNested(item);
  }
  
  public SelectorNested<A> withNewSelector() {
    return new SelectorNested(null);
  }
  
  public SelectorNested<A> withNewSelectorLike(WorkloadSelector item) {
    return new SelectorNested(item);
  }
  
  public TargetRefNested<A> withNewTargetRef() {
    return new TargetRefNested(null);
  }
  
  public A withNewTargetRef(String group,String kind,String name,String namespace) {
    return (A) this.withTargetRef(new PolicyTargetReference(group, kind, name, namespace));
  }
  
  public TargetRefNested<A> withNewTargetRefLike(PolicyTargetReference item) {
    return new TargetRefNested(item);
  }
  
  public A withRules(List<Rule> rules) {
    if (this.rules != null) {
      this._visitables.get("rules").clear();
    }
    if (rules != null) {
        this.rules = new ArrayList();
        for (Rule item : rules) {
          this.addToRules(item);
        }
    } else {
      this.rules = null;
    }
    return (A) this;
  }
  
  public A withRules(Rule... rules) {
    if (this.rules != null) {
        this.rules.clear();
        _visitables.remove("rules");
    }
    if (rules != null) {
      for (Rule item : rules) {
        this.addToRules(item);
      }
    }
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
  
  public A withTargetRef(PolicyTargetReference targetRef) {
    this._visitables.remove("targetRef");
    if (targetRef != null) {
        this.targetRef = new PolicyTargetReferenceBuilder(targetRef);
        this._visitables.get("targetRef").add(this.targetRef);
    } else {
        this.targetRef = null;
        this._visitables.get("targetRef").remove(this.targetRef);
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
  public class AuthorizationPolicyProviderActionDetailNested<N> extends AuthorizationPolicyProviderFluent<AuthorizationPolicyProviderActionDetailNested<N>> implements Nested<N>{
  
    AuthorizationPolicyProviderBuilder builder;
  
    AuthorizationPolicyProviderActionDetailNested(AuthorizationPolicyProvider item) {
      this.builder = new AuthorizationPolicyProviderBuilder(this, item);
    }
  
    public N and() {
      return (N) AuthorizationPolicyFluent.this.withActionDetail(builder.build());
    }
    
    public N endAuthorizationPolicyProviderActionDetail() {
      return and();
    }
    
  }
  public class RulesNested<N> extends RuleFluent<RulesNested<N>> implements Nested<N>{
  
    RuleBuilder builder;
    int index;
  
    RulesNested(int index,Rule item) {
      this.index = index;
      this.builder = new RuleBuilder(this, item);
    }
  
    public N and() {
      return (N) AuthorizationPolicyFluent.this.setToRules(index, builder.build());
    }
    
    public N endRule() {
      return and();
    }
    
  }
  public class SelectorNested<N> extends WorkloadSelectorFluent<SelectorNested<N>> implements Nested<N>{
  
    WorkloadSelectorBuilder builder;
  
    SelectorNested(WorkloadSelector item) {
      this.builder = new WorkloadSelectorBuilder(this, item);
    }
  
    public N and() {
      return (N) AuthorizationPolicyFluent.this.withSelector(builder.build());
    }
    
    public N endSelector() {
      return and();
    }
    
  }
  public class TargetRefNested<N> extends PolicyTargetReferenceFluent<TargetRefNested<N>> implements Nested<N>{
  
    PolicyTargetReferenceBuilder builder;
  
    TargetRefNested(PolicyTargetReference item) {
      this.builder = new PolicyTargetReferenceBuilder(this, item);
    }
  
    public N and() {
      return (N) AuthorizationPolicyFluent.this.withTargetRef(builder.build());
    }
    
    public N endTargetRef() {
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
      return (N) AuthorizationPolicyFluent.this.setToTargetRefs(index, builder.build());
    }
    
    public N endTargetRef() {
      return and();
    }
    
  }
}