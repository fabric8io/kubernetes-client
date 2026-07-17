package io.fabric8.openshift.api.model.config.v1;

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
public class AuditFluent<A extends io.fabric8.openshift.api.model.config.v1.AuditFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private ArrayList<AuditCustomRuleBuilder> customRules = new ArrayList<AuditCustomRuleBuilder>();
  private String profile;

  public AuditFluent() {
  }
  
  public AuditFluent(Audit instance) {
    this.copyInstance(instance);
  }

  public A addAllToCustomRules(Collection<AuditCustomRule> items) {
    if (this.customRules == null) {
      this.customRules = new ArrayList();
    }
    for (AuditCustomRule item : items) {
        AuditCustomRuleBuilder builder = new AuditCustomRuleBuilder(item);
        _visitables.get("customRules").add(builder);
        this.customRules.add(builder);
    }
    return (A) this;
  }
  
  public CustomRulesNested<A> addNewCustomRule() {
    return new CustomRulesNested(-1, null);
  }
  
  public A addNewCustomRule(String group,String profile) {
    return (A) this.addToCustomRules(new AuditCustomRule(group, profile));
  }
  
  public CustomRulesNested<A> addNewCustomRuleLike(AuditCustomRule item) {
    return new CustomRulesNested(-1, item);
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
  
  public A addToCustomRules(AuditCustomRule... items) {
    if (this.customRules == null) {
      this.customRules = new ArrayList();
    }
    for (AuditCustomRule item : items) {
        AuditCustomRuleBuilder builder = new AuditCustomRuleBuilder(item);
        _visitables.get("customRules").add(builder);
        this.customRules.add(builder);
    }
    return (A) this;
  }
  
  public A addToCustomRules(int index,AuditCustomRule item) {
    if (this.customRules == null) {
      this.customRules = new ArrayList();
    }
    AuditCustomRuleBuilder builder = new AuditCustomRuleBuilder(item);
    if (index < 0 || index >= customRules.size()) {
        _visitables.get("customRules").add(builder);
        customRules.add(builder);
    } else {
        _visitables.get("customRules").add(builder);
        customRules.add(index, builder);
    }
    return (A) this;
  }
  
  public AuditCustomRule buildCustomRule(int index) {
    return this.customRules.get(index).build();
  }
  
  public List<AuditCustomRule> buildCustomRules() {
    return this.customRules != null ? build(customRules) : null;
  }
  
  public AuditCustomRule buildFirstCustomRule() {
    return this.customRules.get(0).build();
  }
  
  public AuditCustomRule buildLastCustomRule() {
    return this.customRules.get(customRules.size() - 1).build();
  }
  
  public AuditCustomRule buildMatchingCustomRule(Predicate<AuditCustomRuleBuilder> predicate) {
      for (AuditCustomRuleBuilder item : customRules) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  protected void copyInstance(Audit instance) {
    instance = instance != null ? instance : new Audit();
    if (instance != null) {
        this.withCustomRules(instance.getCustomRules());
        this.withProfile(instance.getProfile());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public CustomRulesNested<A> editCustomRule(int index) {
    if (customRules.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "customRules"));
    }
    return this.setNewCustomRuleLike(index, this.buildCustomRule(index));
  }
  
  public CustomRulesNested<A> editFirstCustomRule() {
    if (customRules.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "customRules"));
    }
    return this.setNewCustomRuleLike(0, this.buildCustomRule(0));
  }
  
  public CustomRulesNested<A> editLastCustomRule() {
    int index = customRules.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "customRules"));
    }
    return this.setNewCustomRuleLike(index, this.buildCustomRule(index));
  }
  
  public CustomRulesNested<A> editMatchingCustomRule(Predicate<AuditCustomRuleBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < customRules.size();i++) {
      if (predicate.test(customRules.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "customRules"));
    }
    return this.setNewCustomRuleLike(index, this.buildCustomRule(index));
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
    AuditFluent that = (AuditFluent) o;
    if (!(Objects.equals(customRules, that.customRules))) {
      return false;
    }
    if (!(Objects.equals(profile, that.profile))) {
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
  
  public String getProfile() {
    return this.profile;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasCustomRules() {
    return this.customRules != null && !(this.customRules.isEmpty());
  }
  
  public boolean hasMatchingCustomRule(Predicate<AuditCustomRuleBuilder> predicate) {
      for (AuditCustomRuleBuilder item : customRules) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasProfile() {
    return this.profile != null;
  }
  
  public int hashCode() {
    return Objects.hash(customRules, profile, additionalProperties);
  }
  
  public A removeAllFromCustomRules(Collection<AuditCustomRule> items) {
    if (this.customRules == null) {
      return (A) this;
    }
    for (AuditCustomRule item : items) {
        AuditCustomRuleBuilder builder = new AuditCustomRuleBuilder(item);
        _visitables.get("customRules").remove(builder);
        this.customRules.remove(builder);
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
  
  public A removeFromCustomRules(AuditCustomRule... items) {
    if (this.customRules == null) {
      return (A) this;
    }
    for (AuditCustomRule item : items) {
        AuditCustomRuleBuilder builder = new AuditCustomRuleBuilder(item);
        _visitables.get("customRules").remove(builder);
        this.customRules.remove(builder);
    }
    return (A) this;
  }
  
  public A removeMatchingFromCustomRules(Predicate<AuditCustomRuleBuilder> predicate) {
    if (customRules == null) {
      return (A) this;
    }
    Iterator<AuditCustomRuleBuilder> each = customRules.iterator();
    List visitables = _visitables.get("customRules");
    while (each.hasNext()) {
        AuditCustomRuleBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public CustomRulesNested<A> setNewCustomRuleLike(int index,AuditCustomRule item) {
    return new CustomRulesNested(index, item);
  }
  
  public A setToCustomRules(int index,AuditCustomRule item) {
    if (this.customRules == null) {
      this.customRules = new ArrayList();
    }
    AuditCustomRuleBuilder builder = new AuditCustomRuleBuilder(item);
    if (index < 0 || index >= customRules.size()) {
        _visitables.get("customRules").add(builder);
        customRules.add(builder);
    } else {
        _visitables.get("customRules").add(builder);
        customRules.set(index, builder);
    }
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(customRules == null) && !(customRules.isEmpty())) {
        sb.append("customRules:");
        sb.append(customRules);
        sb.append(",");
    }
    if (!(profile == null)) {
        sb.append("profile:");
        sb.append(profile);
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
  
  public A withCustomRules(List<AuditCustomRule> customRules) {
    if (this.customRules != null) {
      this._visitables.get("customRules").clear();
    }
    if (customRules != null) {
        this.customRules = new ArrayList();
        for (AuditCustomRule item : customRules) {
          this.addToCustomRules(item);
        }
    } else {
      this.customRules = null;
    }
    return (A) this;
  }
  
  public A withCustomRules(AuditCustomRule... customRules) {
    if (this.customRules != null) {
        this.customRules.clear();
        _visitables.remove("customRules");
    }
    if (customRules != null) {
      for (AuditCustomRule item : customRules) {
        this.addToCustomRules(item);
      }
    }
    return (A) this;
  }
  
  public A withProfile(String profile) {
    this.profile = profile;
    return (A) this;
  }
  public class CustomRulesNested<N> extends AuditCustomRuleFluent<CustomRulesNested<N>> implements Nested<N>{
  
    AuditCustomRuleBuilder builder;
    int index;
  
    CustomRulesNested(int index,AuditCustomRule item) {
      this.index = index;
      this.builder = new AuditCustomRuleBuilder(this, item);
    }
  
    public N and() {
      return (N) AuditFluent.this.setToCustomRules(index, builder.build());
    }
    
    public N endCustomRule() {
      return and();
    }
    
  }
}