package io.fabric8.kubernetes.api.model.gatewayapi.v1alpha2;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import io.fabric8.kubernetes.api.model.gatewayapi.v1.ParentReference;
import io.fabric8.kubernetes.api.model.gatewayapi.v1.ParentReferenceBuilder;
import io.fabric8.kubernetes.api.model.gatewayapi.v1.ParentReferenceFluent;
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
public class UDPRouteSpecFluent<A extends io.fabric8.kubernetes.api.model.gatewayapi.v1alpha2.UDPRouteSpecFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private ArrayList<ParentReferenceBuilder> parentRefs = new ArrayList<ParentReferenceBuilder>();
  private ArrayList<UDPRouteRuleBuilder> rules = new ArrayList<UDPRouteRuleBuilder>();
  private String useDefaultGateways;

  public UDPRouteSpecFluent() {
  }
  
  public UDPRouteSpecFluent(UDPRouteSpec instance) {
    this.copyInstance(instance);
  }

  public A addAllToParentRefs(Collection<ParentReference> items) {
    if (this.parentRefs == null) {
      this.parentRefs = new ArrayList();
    }
    for (ParentReference item : items) {
        ParentReferenceBuilder builder = new ParentReferenceBuilder(item);
        _visitables.get("parentRefs").add(builder);
        this.parentRefs.add(builder);
    }
    return (A) this;
  }
  
  public A addAllToRules(Collection<UDPRouteRule> items) {
    if (this.rules == null) {
      this.rules = new ArrayList();
    }
    for (UDPRouteRule item : items) {
        UDPRouteRuleBuilder builder = new UDPRouteRuleBuilder(item);
        _visitables.get("rules").add(builder);
        this.rules.add(builder);
    }
    return (A) this;
  }
  
  public ParentRefsNested<A> addNewParentRef() {
    return new ParentRefsNested(-1, null);
  }
  
  public ParentRefsNested<A> addNewParentRefLike(ParentReference item) {
    return new ParentRefsNested(-1, item);
  }
  
  public RulesNested<A> addNewRule() {
    return new RulesNested(-1, null);
  }
  
  public RulesNested<A> addNewRuleLike(UDPRouteRule item) {
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
  
  public A addToParentRefs(ParentReference... items) {
    if (this.parentRefs == null) {
      this.parentRefs = new ArrayList();
    }
    for (ParentReference item : items) {
        ParentReferenceBuilder builder = new ParentReferenceBuilder(item);
        _visitables.get("parentRefs").add(builder);
        this.parentRefs.add(builder);
    }
    return (A) this;
  }
  
  public A addToParentRefs(int index,ParentReference item) {
    if (this.parentRefs == null) {
      this.parentRefs = new ArrayList();
    }
    ParentReferenceBuilder builder = new ParentReferenceBuilder(item);
    if (index < 0 || index >= parentRefs.size()) {
        _visitables.get("parentRefs").add(builder);
        parentRefs.add(builder);
    } else {
        _visitables.get("parentRefs").add(builder);
        parentRefs.add(index, builder);
    }
    return (A) this;
  }
  
  public A addToRules(UDPRouteRule... items) {
    if (this.rules == null) {
      this.rules = new ArrayList();
    }
    for (UDPRouteRule item : items) {
        UDPRouteRuleBuilder builder = new UDPRouteRuleBuilder(item);
        _visitables.get("rules").add(builder);
        this.rules.add(builder);
    }
    return (A) this;
  }
  
  public A addToRules(int index,UDPRouteRule item) {
    if (this.rules == null) {
      this.rules = new ArrayList();
    }
    UDPRouteRuleBuilder builder = new UDPRouteRuleBuilder(item);
    if (index < 0 || index >= rules.size()) {
        _visitables.get("rules").add(builder);
        rules.add(builder);
    } else {
        _visitables.get("rules").add(builder);
        rules.add(index, builder);
    }
    return (A) this;
  }
  
  public ParentReference buildFirstParentRef() {
    return this.parentRefs.get(0).build();
  }
  
  public UDPRouteRule buildFirstRule() {
    return this.rules.get(0).build();
  }
  
  public ParentReference buildLastParentRef() {
    return this.parentRefs.get(parentRefs.size() - 1).build();
  }
  
  public UDPRouteRule buildLastRule() {
    return this.rules.get(rules.size() - 1).build();
  }
  
  public ParentReference buildMatchingParentRef(Predicate<ParentReferenceBuilder> predicate) {
      for (ParentReferenceBuilder item : parentRefs) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public UDPRouteRule buildMatchingRule(Predicate<UDPRouteRuleBuilder> predicate) {
      for (UDPRouteRuleBuilder item : rules) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public ParentReference buildParentRef(int index) {
    return this.parentRefs.get(index).build();
  }
  
  public List<ParentReference> buildParentRefs() {
    return this.parentRefs != null ? build(parentRefs) : null;
  }
  
  public UDPRouteRule buildRule(int index) {
    return this.rules.get(index).build();
  }
  
  public List<UDPRouteRule> buildRules() {
    return this.rules != null ? build(rules) : null;
  }
  
  protected void copyInstance(UDPRouteSpec instance) {
    instance = instance != null ? instance : new UDPRouteSpec();
    if (instance != null) {
        this.withParentRefs(instance.getParentRefs());
        this.withRules(instance.getRules());
        this.withUseDefaultGateways(instance.getUseDefaultGateways());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public ParentRefsNested<A> editFirstParentRef() {
    if (parentRefs.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "parentRefs"));
    }
    return this.setNewParentRefLike(0, this.buildParentRef(0));
  }
  
  public RulesNested<A> editFirstRule() {
    if (rules.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "rules"));
    }
    return this.setNewRuleLike(0, this.buildRule(0));
  }
  
  public ParentRefsNested<A> editLastParentRef() {
    int index = parentRefs.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "parentRefs"));
    }
    return this.setNewParentRefLike(index, this.buildParentRef(index));
  }
  
  public RulesNested<A> editLastRule() {
    int index = rules.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "rules"));
    }
    return this.setNewRuleLike(index, this.buildRule(index));
  }
  
  public ParentRefsNested<A> editMatchingParentRef(Predicate<ParentReferenceBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < parentRefs.size();i++) {
      if (predicate.test(parentRefs.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "parentRefs"));
    }
    return this.setNewParentRefLike(index, this.buildParentRef(index));
  }
  
  public RulesNested<A> editMatchingRule(Predicate<UDPRouteRuleBuilder> predicate) {
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
  
  public ParentRefsNested<A> editParentRef(int index) {
    if (parentRefs.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "parentRefs"));
    }
    return this.setNewParentRefLike(index, this.buildParentRef(index));
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
    UDPRouteSpecFluent that = (UDPRouteSpecFluent) o;
    if (!(Objects.equals(parentRefs, that.parentRefs))) {
      return false;
    }
    if (!(Objects.equals(rules, that.rules))) {
      return false;
    }
    if (!(Objects.equals(useDefaultGateways, that.useDefaultGateways))) {
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
  
  public String getUseDefaultGateways() {
    return this.useDefaultGateways;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasMatchingParentRef(Predicate<ParentReferenceBuilder> predicate) {
      for (ParentReferenceBuilder item : parentRefs) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingRule(Predicate<UDPRouteRuleBuilder> predicate) {
      for (UDPRouteRuleBuilder item : rules) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasParentRefs() {
    return this.parentRefs != null && !(this.parentRefs.isEmpty());
  }
  
  public boolean hasRules() {
    return this.rules != null && !(this.rules.isEmpty());
  }
  
  public boolean hasUseDefaultGateways() {
    return this.useDefaultGateways != null;
  }
  
  public int hashCode() {
    return Objects.hash(parentRefs, rules, useDefaultGateways, additionalProperties);
  }
  
  public A removeAllFromParentRefs(Collection<ParentReference> items) {
    if (this.parentRefs == null) {
      return (A) this;
    }
    for (ParentReference item : items) {
        ParentReferenceBuilder builder = new ParentReferenceBuilder(item);
        _visitables.get("parentRefs").remove(builder);
        this.parentRefs.remove(builder);
    }
    return (A) this;
  }
  
  public A removeAllFromRules(Collection<UDPRouteRule> items) {
    if (this.rules == null) {
      return (A) this;
    }
    for (UDPRouteRule item : items) {
        UDPRouteRuleBuilder builder = new UDPRouteRuleBuilder(item);
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
  
  public A removeFromParentRefs(ParentReference... items) {
    if (this.parentRefs == null) {
      return (A) this;
    }
    for (ParentReference item : items) {
        ParentReferenceBuilder builder = new ParentReferenceBuilder(item);
        _visitables.get("parentRefs").remove(builder);
        this.parentRefs.remove(builder);
    }
    return (A) this;
  }
  
  public A removeFromRules(UDPRouteRule... items) {
    if (this.rules == null) {
      return (A) this;
    }
    for (UDPRouteRule item : items) {
        UDPRouteRuleBuilder builder = new UDPRouteRuleBuilder(item);
        _visitables.get("rules").remove(builder);
        this.rules.remove(builder);
    }
    return (A) this;
  }
  
  public A removeMatchingFromParentRefs(Predicate<ParentReferenceBuilder> predicate) {
    if (parentRefs == null) {
      return (A) this;
    }
    Iterator<ParentReferenceBuilder> each = parentRefs.iterator();
    List visitables = _visitables.get("parentRefs");
    while (each.hasNext()) {
        ParentReferenceBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public A removeMatchingFromRules(Predicate<UDPRouteRuleBuilder> predicate) {
    if (rules == null) {
      return (A) this;
    }
    Iterator<UDPRouteRuleBuilder> each = rules.iterator();
    List visitables = _visitables.get("rules");
    while (each.hasNext()) {
        UDPRouteRuleBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public ParentRefsNested<A> setNewParentRefLike(int index,ParentReference item) {
    return new ParentRefsNested(index, item);
  }
  
  public RulesNested<A> setNewRuleLike(int index,UDPRouteRule item) {
    return new RulesNested(index, item);
  }
  
  public A setToParentRefs(int index,ParentReference item) {
    if (this.parentRefs == null) {
      this.parentRefs = new ArrayList();
    }
    ParentReferenceBuilder builder = new ParentReferenceBuilder(item);
    if (index < 0 || index >= parentRefs.size()) {
        _visitables.get("parentRefs").add(builder);
        parentRefs.add(builder);
    } else {
        _visitables.get("parentRefs").add(builder);
        parentRefs.set(index, builder);
    }
    return (A) this;
  }
  
  public A setToRules(int index,UDPRouteRule item) {
    if (this.rules == null) {
      this.rules = new ArrayList();
    }
    UDPRouteRuleBuilder builder = new UDPRouteRuleBuilder(item);
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
    if (!(parentRefs == null) && !(parentRefs.isEmpty())) {
        sb.append("parentRefs:");
        sb.append(parentRefs);
        sb.append(",");
    }
    if (!(rules == null) && !(rules.isEmpty())) {
        sb.append("rules:");
        sb.append(rules);
        sb.append(",");
    }
    if (!(useDefaultGateways == null)) {
        sb.append("useDefaultGateways:");
        sb.append(useDefaultGateways);
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
  
  public A withParentRefs(List<ParentReference> parentRefs) {
    if (this.parentRefs != null) {
      this._visitables.get("parentRefs").clear();
    }
    if (parentRefs != null) {
        this.parentRefs = new ArrayList();
        for (ParentReference item : parentRefs) {
          this.addToParentRefs(item);
        }
    } else {
      this.parentRefs = null;
    }
    return (A) this;
  }
  
  public A withParentRefs(ParentReference... parentRefs) {
    if (this.parentRefs != null) {
        this.parentRefs.clear();
        _visitables.remove("parentRefs");
    }
    if (parentRefs != null) {
      for (ParentReference item : parentRefs) {
        this.addToParentRefs(item);
      }
    }
    return (A) this;
  }
  
  public A withRules(List<UDPRouteRule> rules) {
    if (this.rules != null) {
      this._visitables.get("rules").clear();
    }
    if (rules != null) {
        this.rules = new ArrayList();
        for (UDPRouteRule item : rules) {
          this.addToRules(item);
        }
    } else {
      this.rules = null;
    }
    return (A) this;
  }
  
  public A withRules(UDPRouteRule... rules) {
    if (this.rules != null) {
        this.rules.clear();
        _visitables.remove("rules");
    }
    if (rules != null) {
      for (UDPRouteRule item : rules) {
        this.addToRules(item);
      }
    }
    return (A) this;
  }
  
  public A withUseDefaultGateways(String useDefaultGateways) {
    this.useDefaultGateways = useDefaultGateways;
    return (A) this;
  }
  public class ParentRefsNested<N> extends ParentReferenceFluent<ParentRefsNested<N>> implements Nested<N>{
  
    ParentReferenceBuilder builder;
    int index;
  
    ParentRefsNested(int index,ParentReference item) {
      this.index = index;
      this.builder = new ParentReferenceBuilder(this, item);
    }
  
    public N and() {
      return (N) UDPRouteSpecFluent.this.setToParentRefs(index, builder.build());
    }
    
    public N endParentRef() {
      return and();
    }
    
  }
  public class RulesNested<N> extends UDPRouteRuleFluent<RulesNested<N>> implements Nested<N>{
  
    UDPRouteRuleBuilder builder;
    int index;
  
    RulesNested(int index,UDPRouteRule item) {
      this.index = index;
      this.builder = new UDPRouteRuleBuilder(this, item);
    }
  
    public N and() {
      return (N) UDPRouteSpecFluent.this.setToRules(index, builder.build());
    }
    
    public N endRule() {
      return and();
    }
    
  }
}