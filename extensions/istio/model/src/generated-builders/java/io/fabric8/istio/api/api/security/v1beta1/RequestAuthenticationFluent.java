package io.fabric8.istio.api.api.security.v1beta1;

import io.fabric8.istio.api.api.type.v1beta1.PolicyTargetReference;
import io.fabric8.istio.api.api.type.v1beta1.PolicyTargetReferenceBuilder;
import io.fabric8.istio.api.api.type.v1beta1.PolicyTargetReferenceFluent;
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
public class RequestAuthenticationFluent<A extends io.fabric8.istio.api.api.security.v1beta1.RequestAuthenticationFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private ArrayList<JWTRuleBuilder> jwtRules = new ArrayList<JWTRuleBuilder>();
  private WorkloadSelectorBuilder selector;
  private PolicyTargetReferenceBuilder targetRef;
  private ArrayList<PolicyTargetReferenceBuilder> targetRefs = new ArrayList<PolicyTargetReferenceBuilder>();

  public RequestAuthenticationFluent() {
  }
  
  public RequestAuthenticationFluent(RequestAuthentication instance) {
    this.copyInstance(instance);
  }

  public A addAllToJwtRules(Collection<JWTRule> items) {
    if (this.jwtRules == null) {
      this.jwtRules = new ArrayList();
    }
    for (JWTRule item : items) {
        JWTRuleBuilder builder = new JWTRuleBuilder(item);
        _visitables.get("jwtRules").add(builder);
        this.jwtRules.add(builder);
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
  
  public JwtRulesNested<A> addNewJwtRule() {
    return new JwtRulesNested(-1, null);
  }
  
  public JwtRulesNested<A> addNewJwtRuleLike(JWTRule item) {
    return new JwtRulesNested(-1, item);
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
  
  public A addToJwtRules(JWTRule... items) {
    if (this.jwtRules == null) {
      this.jwtRules = new ArrayList();
    }
    for (JWTRule item : items) {
        JWTRuleBuilder builder = new JWTRuleBuilder(item);
        _visitables.get("jwtRules").add(builder);
        this.jwtRules.add(builder);
    }
    return (A) this;
  }
  
  public A addToJwtRules(int index,JWTRule item) {
    if (this.jwtRules == null) {
      this.jwtRules = new ArrayList();
    }
    JWTRuleBuilder builder = new JWTRuleBuilder(item);
    if (index < 0 || index >= jwtRules.size()) {
        _visitables.get("jwtRules").add(builder);
        jwtRules.add(builder);
    } else {
        _visitables.get("jwtRules").add(builder);
        jwtRules.add(index, builder);
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
  
  public JWTRule buildFirstJwtRule() {
    return this.jwtRules.get(0).build();
  }
  
  public PolicyTargetReference buildFirstTargetRef() {
    return this.targetRefs.get(0).build();
  }
  
  public JWTRule buildJwtRule(int index) {
    return this.jwtRules.get(index).build();
  }
  
  public List<JWTRule> buildJwtRules() {
    return this.jwtRules != null ? build(jwtRules) : null;
  }
  
  public JWTRule buildLastJwtRule() {
    return this.jwtRules.get(jwtRules.size() - 1).build();
  }
  
  public PolicyTargetReference buildLastTargetRef() {
    return this.targetRefs.get(targetRefs.size() - 1).build();
  }
  
  public JWTRule buildMatchingJwtRule(Predicate<JWTRuleBuilder> predicate) {
      for (JWTRuleBuilder item : jwtRules) {
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
  
  public PolicyTargetReference buildTargetRef() {
    return this.targetRef != null ? this.targetRef.build() : null;
  }
  
  public PolicyTargetReference buildTargetRef(int index) {
    return this.targetRefs.get(index).build();
  }
  
  public List<PolicyTargetReference> buildTargetRefs() {
    return this.targetRefs != null ? build(targetRefs) : null;
  }
  
  protected void copyInstance(RequestAuthentication instance) {
    instance = instance != null ? instance : new RequestAuthentication();
    if (instance != null) {
        this.withJwtRules(instance.getJwtRules());
        this.withSelector(instance.getSelector());
        this.withTargetRef(instance.getTargetRef());
        this.withTargetRefs(instance.getTargetRefs());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public JwtRulesNested<A> editFirstJwtRule() {
    if (jwtRules.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "jwtRules"));
    }
    return this.setNewJwtRuleLike(0, this.buildJwtRule(0));
  }
  
  public TargetRefsNested<A> editFirstTargetRef() {
    if (targetRefs.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "targetRefs"));
    }
    return this.setNewTargetRefLike(0, this.buildTargetRef(0));
  }
  
  public JwtRulesNested<A> editJwtRule(int index) {
    if (jwtRules.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "jwtRules"));
    }
    return this.setNewJwtRuleLike(index, this.buildJwtRule(index));
  }
  
  public JwtRulesNested<A> editLastJwtRule() {
    int index = jwtRules.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "jwtRules"));
    }
    return this.setNewJwtRuleLike(index, this.buildJwtRule(index));
  }
  
  public TargetRefsNested<A> editLastTargetRef() {
    int index = targetRefs.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "targetRefs"));
    }
    return this.setNewTargetRefLike(index, this.buildTargetRef(index));
  }
  
  public JwtRulesNested<A> editMatchingJwtRule(Predicate<JWTRuleBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < jwtRules.size();i++) {
      if (predicate.test(jwtRules.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "jwtRules"));
    }
    return this.setNewJwtRuleLike(index, this.buildJwtRule(index));
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
    RequestAuthenticationFluent that = (RequestAuthenticationFluent) o;
    if (!(Objects.equals(jwtRules, that.jwtRules))) {
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
  
  public Map<String,Object> getAdditionalProperties() {
    return this.additionalProperties;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasJwtRules() {
    return this.jwtRules != null && !(this.jwtRules.isEmpty());
  }
  
  public boolean hasMatchingJwtRule(Predicate<JWTRuleBuilder> predicate) {
      for (JWTRuleBuilder item : jwtRules) {
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
    return Objects.hash(jwtRules, selector, targetRef, targetRefs, additionalProperties);
  }
  
  public A removeAllFromJwtRules(Collection<JWTRule> items) {
    if (this.jwtRules == null) {
      return (A) this;
    }
    for (JWTRule item : items) {
        JWTRuleBuilder builder = new JWTRuleBuilder(item);
        _visitables.get("jwtRules").remove(builder);
        this.jwtRules.remove(builder);
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
  
  public A removeFromJwtRules(JWTRule... items) {
    if (this.jwtRules == null) {
      return (A) this;
    }
    for (JWTRule item : items) {
        JWTRuleBuilder builder = new JWTRuleBuilder(item);
        _visitables.get("jwtRules").remove(builder);
        this.jwtRules.remove(builder);
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
  
  public A removeMatchingFromJwtRules(Predicate<JWTRuleBuilder> predicate) {
    if (jwtRules == null) {
      return (A) this;
    }
    Iterator<JWTRuleBuilder> each = jwtRules.iterator();
    List visitables = _visitables.get("jwtRules");
    while (each.hasNext()) {
        JWTRuleBuilder builder = each.next();
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
  
  public JwtRulesNested<A> setNewJwtRuleLike(int index,JWTRule item) {
    return new JwtRulesNested(index, item);
  }
  
  public TargetRefsNested<A> setNewTargetRefLike(int index,PolicyTargetReference item) {
    return new TargetRefsNested(index, item);
  }
  
  public A setToJwtRules(int index,JWTRule item) {
    if (this.jwtRules == null) {
      this.jwtRules = new ArrayList();
    }
    JWTRuleBuilder builder = new JWTRuleBuilder(item);
    if (index < 0 || index >= jwtRules.size()) {
        _visitables.get("jwtRules").add(builder);
        jwtRules.add(builder);
    } else {
        _visitables.get("jwtRules").add(builder);
        jwtRules.set(index, builder);
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
    if (!(jwtRules == null) && !(jwtRules.isEmpty())) {
        sb.append("jwtRules:");
        sb.append(jwtRules);
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
  
  public <K,V>A withAdditionalProperties(Map<String,Object> additionalProperties) {
    if (additionalProperties == null) {
      this.additionalProperties = null;
    } else {
      this.additionalProperties = new LinkedHashMap(additionalProperties);
    }
    return (A) this;
  }
  
  public A withJwtRules(List<JWTRule> jwtRules) {
    if (this.jwtRules != null) {
      this._visitables.get("jwtRules").clear();
    }
    if (jwtRules != null) {
        this.jwtRules = new ArrayList();
        for (JWTRule item : jwtRules) {
          this.addToJwtRules(item);
        }
    } else {
      this.jwtRules = null;
    }
    return (A) this;
  }
  
  public A withJwtRules(JWTRule... jwtRules) {
    if (this.jwtRules != null) {
        this.jwtRules.clear();
        _visitables.remove("jwtRules");
    }
    if (jwtRules != null) {
      for (JWTRule item : jwtRules) {
        this.addToJwtRules(item);
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
  
  public TargetRefNested<A> withNewTargetRef() {
    return new TargetRefNested(null);
  }
  
  public A withNewTargetRef(String group,String kind,String name,String namespace) {
    return (A) this.withTargetRef(new PolicyTargetReference(group, kind, name, namespace));
  }
  
  public TargetRefNested<A> withNewTargetRefLike(PolicyTargetReference item) {
    return new TargetRefNested(item);
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
  public class JwtRulesNested<N> extends JWTRuleFluent<JwtRulesNested<N>> implements Nested<N>{
  
    JWTRuleBuilder builder;
    int index;
  
    JwtRulesNested(int index,JWTRule item) {
      this.index = index;
      this.builder = new JWTRuleBuilder(this, item);
    }
  
    public N and() {
      return (N) RequestAuthenticationFluent.this.setToJwtRules(index, builder.build());
    }
    
    public N endJwtRule() {
      return and();
    }
    
  }
  public class SelectorNested<N> extends WorkloadSelectorFluent<SelectorNested<N>> implements Nested<N>{
  
    WorkloadSelectorBuilder builder;
  
    SelectorNested(WorkloadSelector item) {
      this.builder = new WorkloadSelectorBuilder(this, item);
    }
  
    public N and() {
      return (N) RequestAuthenticationFluent.this.withSelector(builder.build());
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
      return (N) RequestAuthenticationFluent.this.withTargetRef(builder.build());
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
      return (N) RequestAuthenticationFluent.this.setToTargetRefs(index, builder.build());
    }
    
    public N endTargetRef() {
      return and();
    }
    
  }
}