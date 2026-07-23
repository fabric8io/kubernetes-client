package io.fabric8.openshift.api.model.operator.network.v1;

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
public class RedirectConfigFluent<A extends io.fabric8.openshift.api.model.operator.network.v1.RedirectConfigFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String fallbackIP;
  private ArrayList<L4RedirectRuleBuilder> redirectRules = new ArrayList<L4RedirectRuleBuilder>();

  public RedirectConfigFluent() {
  }
  
  public RedirectConfigFluent(RedirectConfig instance) {
    this.copyInstance(instance);
  }

  public A addAllToRedirectRules(Collection<L4RedirectRule> items) {
    if (this.redirectRules == null) {
      this.redirectRules = new ArrayList();
    }
    for (L4RedirectRule item : items) {
        L4RedirectRuleBuilder builder = new L4RedirectRuleBuilder(item);
        _visitables.get("redirectRules").add(builder);
        this.redirectRules.add(builder);
    }
    return (A) this;
  }
  
  public RedirectRulesNested<A> addNewRedirectRule() {
    return new RedirectRulesNested(-1, null);
  }
  
  public A addNewRedirectRule(String destinationIP,Integer port,String protocol,Integer targetPort) {
    return (A) this.addToRedirectRules(new L4RedirectRule(destinationIP, port, protocol, targetPort));
  }
  
  public RedirectRulesNested<A> addNewRedirectRuleLike(L4RedirectRule item) {
    return new RedirectRulesNested(-1, item);
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
  
  public A addToRedirectRules(L4RedirectRule... items) {
    if (this.redirectRules == null) {
      this.redirectRules = new ArrayList();
    }
    for (L4RedirectRule item : items) {
        L4RedirectRuleBuilder builder = new L4RedirectRuleBuilder(item);
        _visitables.get("redirectRules").add(builder);
        this.redirectRules.add(builder);
    }
    return (A) this;
  }
  
  public A addToRedirectRules(int index,L4RedirectRule item) {
    if (this.redirectRules == null) {
      this.redirectRules = new ArrayList();
    }
    L4RedirectRuleBuilder builder = new L4RedirectRuleBuilder(item);
    if (index < 0 || index >= redirectRules.size()) {
        _visitables.get("redirectRules").add(builder);
        redirectRules.add(builder);
    } else {
        _visitables.get("redirectRules").add(builder);
        redirectRules.add(index, builder);
    }
    return (A) this;
  }
  
  public L4RedirectRule buildFirstRedirectRule() {
    return this.redirectRules.get(0).build();
  }
  
  public L4RedirectRule buildLastRedirectRule() {
    return this.redirectRules.get(redirectRules.size() - 1).build();
  }
  
  public L4RedirectRule buildMatchingRedirectRule(Predicate<L4RedirectRuleBuilder> predicate) {
      for (L4RedirectRuleBuilder item : redirectRules) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public L4RedirectRule buildRedirectRule(int index) {
    return this.redirectRules.get(index).build();
  }
  
  public List<L4RedirectRule> buildRedirectRules() {
    return this.redirectRules != null ? build(redirectRules) : null;
  }
  
  protected void copyInstance(RedirectConfig instance) {
    instance = instance != null ? instance : new RedirectConfig();
    if (instance != null) {
        this.withFallbackIP(instance.getFallbackIP());
        this.withRedirectRules(instance.getRedirectRules());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public RedirectRulesNested<A> editFirstRedirectRule() {
    if (redirectRules.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "redirectRules"));
    }
    return this.setNewRedirectRuleLike(0, this.buildRedirectRule(0));
  }
  
  public RedirectRulesNested<A> editLastRedirectRule() {
    int index = redirectRules.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "redirectRules"));
    }
    return this.setNewRedirectRuleLike(index, this.buildRedirectRule(index));
  }
  
  public RedirectRulesNested<A> editMatchingRedirectRule(Predicate<L4RedirectRuleBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < redirectRules.size();i++) {
      if (predicate.test(redirectRules.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "redirectRules"));
    }
    return this.setNewRedirectRuleLike(index, this.buildRedirectRule(index));
  }
  
  public RedirectRulesNested<A> editRedirectRule(int index) {
    if (redirectRules.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "redirectRules"));
    }
    return this.setNewRedirectRuleLike(index, this.buildRedirectRule(index));
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
    RedirectConfigFluent that = (RedirectConfigFluent) o;
    if (!(Objects.equals(fallbackIP, that.fallbackIP))) {
      return false;
    }
    if (!(Objects.equals(redirectRules, that.redirectRules))) {
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
  
  public String getFallbackIP() {
    return this.fallbackIP;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasFallbackIP() {
    return this.fallbackIP != null;
  }
  
  public boolean hasMatchingRedirectRule(Predicate<L4RedirectRuleBuilder> predicate) {
      for (L4RedirectRuleBuilder item : redirectRules) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasRedirectRules() {
    return this.redirectRules != null && !(this.redirectRules.isEmpty());
  }
  
  public int hashCode() {
    return Objects.hash(fallbackIP, redirectRules, additionalProperties);
  }
  
  public A removeAllFromRedirectRules(Collection<L4RedirectRule> items) {
    if (this.redirectRules == null) {
      return (A) this;
    }
    for (L4RedirectRule item : items) {
        L4RedirectRuleBuilder builder = new L4RedirectRuleBuilder(item);
        _visitables.get("redirectRules").remove(builder);
        this.redirectRules.remove(builder);
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
  
  public A removeFromRedirectRules(L4RedirectRule... items) {
    if (this.redirectRules == null) {
      return (A) this;
    }
    for (L4RedirectRule item : items) {
        L4RedirectRuleBuilder builder = new L4RedirectRuleBuilder(item);
        _visitables.get("redirectRules").remove(builder);
        this.redirectRules.remove(builder);
    }
    return (A) this;
  }
  
  public A removeMatchingFromRedirectRules(Predicate<L4RedirectRuleBuilder> predicate) {
    if (redirectRules == null) {
      return (A) this;
    }
    Iterator<L4RedirectRuleBuilder> each = redirectRules.iterator();
    List visitables = _visitables.get("redirectRules");
    while (each.hasNext()) {
        L4RedirectRuleBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public RedirectRulesNested<A> setNewRedirectRuleLike(int index,L4RedirectRule item) {
    return new RedirectRulesNested(index, item);
  }
  
  public A setToRedirectRules(int index,L4RedirectRule item) {
    if (this.redirectRules == null) {
      this.redirectRules = new ArrayList();
    }
    L4RedirectRuleBuilder builder = new L4RedirectRuleBuilder(item);
    if (index < 0 || index >= redirectRules.size()) {
        _visitables.get("redirectRules").add(builder);
        redirectRules.add(builder);
    } else {
        _visitables.get("redirectRules").add(builder);
        redirectRules.set(index, builder);
    }
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(fallbackIP == null)) {
        sb.append("fallbackIP:");
        sb.append(fallbackIP);
        sb.append(",");
    }
    if (!(redirectRules == null) && !(redirectRules.isEmpty())) {
        sb.append("redirectRules:");
        sb.append(redirectRules);
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
  
  public A withFallbackIP(String fallbackIP) {
    this.fallbackIP = fallbackIP;
    return (A) this;
  }
  
  public A withRedirectRules(List<L4RedirectRule> redirectRules) {
    if (this.redirectRules != null) {
      this._visitables.get("redirectRules").clear();
    }
    if (redirectRules != null) {
        this.redirectRules = new ArrayList();
        for (L4RedirectRule item : redirectRules) {
          this.addToRedirectRules(item);
        }
    } else {
      this.redirectRules = null;
    }
    return (A) this;
  }
  
  public A withRedirectRules(L4RedirectRule... redirectRules) {
    if (this.redirectRules != null) {
        this.redirectRules.clear();
        _visitables.remove("redirectRules");
    }
    if (redirectRules != null) {
      for (L4RedirectRule item : redirectRules) {
        this.addToRedirectRules(item);
      }
    }
    return (A) this;
  }
  public class RedirectRulesNested<N> extends L4RedirectRuleFluent<RedirectRulesNested<N>> implements Nested<N>{
  
    L4RedirectRuleBuilder builder;
    int index;
  
    RedirectRulesNested(int index,L4RedirectRule item) {
      this.index = index;
      this.builder = new L4RedirectRuleBuilder(this, item);
    }
  
    public N and() {
      return (N) RedirectConfigFluent.this.setToRedirectRules(index, builder.build());
    }
    
    public N endRedirectRule() {
      return and();
    }
    
  }
}