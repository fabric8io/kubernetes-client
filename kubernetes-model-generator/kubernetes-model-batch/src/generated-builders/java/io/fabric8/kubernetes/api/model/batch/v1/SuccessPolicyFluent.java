package io.fabric8.kubernetes.api.model.batch.v1;

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
import java.util.function.Predicate;

/**
 * Generated
 */
@SuppressWarnings("unchecked")
public class SuccessPolicyFluent<A extends io.fabric8.kubernetes.api.model.batch.v1.SuccessPolicyFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private ArrayList<SuccessPolicyRuleBuilder> rules = new ArrayList<SuccessPolicyRuleBuilder>();

  public SuccessPolicyFluent() {
  }
  
  public SuccessPolicyFluent(SuccessPolicy instance) {
    this.copyInstance(instance);
  }

  public A addAllToRules(Collection<SuccessPolicyRule> items) {
    if (this.rules == null) {
      this.rules = new ArrayList();
    }
    for (SuccessPolicyRule item : items) {
        SuccessPolicyRuleBuilder builder = new SuccessPolicyRuleBuilder(item);
        _visitables.get("rules").add(builder);
        this.rules.add(builder);
    }
    return (A) this;
  }
  
  public RulesNested<A> addNewRule() {
    return new RulesNested(-1, null);
  }
  
  public A addNewRule(Integer succeededCount,String succeededIndexes) {
    return (A) this.addToRules(new SuccessPolicyRule(succeededCount, succeededIndexes));
  }
  
  public RulesNested<A> addNewRuleLike(SuccessPolicyRule item) {
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
  
  public A addToRules(SuccessPolicyRule... items) {
    if (this.rules == null) {
      this.rules = new ArrayList();
    }
    for (SuccessPolicyRule item : items) {
        SuccessPolicyRuleBuilder builder = new SuccessPolicyRuleBuilder(item);
        _visitables.get("rules").add(builder);
        this.rules.add(builder);
    }
    return (A) this;
  }
  
  public A addToRules(int index,SuccessPolicyRule item) {
    if (this.rules == null) {
      this.rules = new ArrayList();
    }
    SuccessPolicyRuleBuilder builder = new SuccessPolicyRuleBuilder(item);
    if (index < 0 || index >= rules.size()) {
        _visitables.get("rules").add(builder);
        rules.add(builder);
    } else {
        _visitables.get("rules").add(builder);
        rules.add(index, builder);
    }
    return (A) this;
  }
  
  public SuccessPolicyRule buildFirstRule() {
    return this.rules.get(0).build();
  }
  
  public SuccessPolicyRule buildLastRule() {
    return this.rules.get(rules.size() - 1).build();
  }
  
  public SuccessPolicyRule buildMatchingRule(Predicate<SuccessPolicyRuleBuilder> predicate) {
      for (SuccessPolicyRuleBuilder item : rules) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public SuccessPolicyRule buildRule(int index) {
    return this.rules.get(index).build();
  }
  
  public List<SuccessPolicyRule> buildRules() {
    return this.rules != null ? build(rules) : null;
  }
  
  protected void copyInstance(SuccessPolicy instance) {
    instance = instance != null ? instance : new SuccessPolicy();
    if (instance != null) {
        this.withRules(instance.getRules());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
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
  
  public RulesNested<A> editMatchingRule(Predicate<SuccessPolicyRuleBuilder> predicate) {
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
    SuccessPolicyFluent that = (SuccessPolicyFluent) o;
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
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasMatchingRule(Predicate<SuccessPolicyRuleBuilder> predicate) {
      for (SuccessPolicyRuleBuilder item : rules) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasRules() {
    return this.rules != null && !(this.rules.isEmpty());
  }
  
  public int hashCode() {
    return Objects.hash(rules, additionalProperties);
  }
  
  public A removeAllFromRules(Collection<SuccessPolicyRule> items) {
    if (this.rules == null) {
      return (A) this;
    }
    for (SuccessPolicyRule item : items) {
        SuccessPolicyRuleBuilder builder = new SuccessPolicyRuleBuilder(item);
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
  
  public A removeFromRules(SuccessPolicyRule... items) {
    if (this.rules == null) {
      return (A) this;
    }
    for (SuccessPolicyRule item : items) {
        SuccessPolicyRuleBuilder builder = new SuccessPolicyRuleBuilder(item);
        _visitables.get("rules").remove(builder);
        this.rules.remove(builder);
    }
    return (A) this;
  }
  
  public A removeMatchingFromRules(Predicate<SuccessPolicyRuleBuilder> predicate) {
    if (rules == null) {
      return (A) this;
    }
    Iterator<SuccessPolicyRuleBuilder> each = rules.iterator();
    List visitables = _visitables.get("rules");
    while (each.hasNext()) {
        SuccessPolicyRuleBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public RulesNested<A> setNewRuleLike(int index,SuccessPolicyRule item) {
    return new RulesNested(index, item);
  }
  
  public A setToRules(int index,SuccessPolicyRule item) {
    if (this.rules == null) {
      this.rules = new ArrayList();
    }
    SuccessPolicyRuleBuilder builder = new SuccessPolicyRuleBuilder(item);
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
  
  public A withRules(List<SuccessPolicyRule> rules) {
    if (this.rules != null) {
      this._visitables.get("rules").clear();
    }
    if (rules != null) {
        this.rules = new ArrayList();
        for (SuccessPolicyRule item : rules) {
          this.addToRules(item);
        }
    } else {
      this.rules = null;
    }
    return (A) this;
  }
  
  public A withRules(SuccessPolicyRule... rules) {
    if (this.rules != null) {
        this.rules.clear();
        _visitables.remove("rules");
    }
    if (rules != null) {
      for (SuccessPolicyRule item : rules) {
        this.addToRules(item);
      }
    }
    return (A) this;
  }
  public class RulesNested<N> extends SuccessPolicyRuleFluent<RulesNested<N>> implements Nested<N>{
  
    SuccessPolicyRuleBuilder builder;
    int index;
  
    RulesNested(int index,SuccessPolicyRule item) {
      this.index = index;
      this.builder = new SuccessPolicyRuleBuilder(this, item);
    }
  
    public N and() {
      return (N) SuccessPolicyFluent.this.setToRules(index, builder.build());
    }
    
    public N endRule() {
      return and();
    }
    
  }
}