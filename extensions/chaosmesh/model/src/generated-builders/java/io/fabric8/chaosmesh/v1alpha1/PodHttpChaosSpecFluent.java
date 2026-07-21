package io.fabric8.chaosmesh.v1alpha1;

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
public class PodHttpChaosSpecFluent<A extends io.fabric8.chaosmesh.v1alpha1.PodHttpChaosSpecFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private ArrayList<PodHttpChaosRuleBuilder> rules = new ArrayList<PodHttpChaosRuleBuilder>();
  private PodHttpChaosTLSBuilder tls;

  public PodHttpChaosSpecFluent() {
  }
  
  public PodHttpChaosSpecFluent(PodHttpChaosSpec instance) {
    this.copyInstance(instance);
  }

  public A addAllToRules(Collection<PodHttpChaosRule> items) {
    if (this.rules == null) {
      this.rules = new ArrayList();
    }
    for (PodHttpChaosRule item : items) {
        PodHttpChaosRuleBuilder builder = new PodHttpChaosRuleBuilder(item);
        _visitables.get("rules").add(builder);
        this.rules.add(builder);
    }
    return (A) this;
  }
  
  public RulesNested<A> addNewRule() {
    return new RulesNested(-1, null);
  }
  
  public RulesNested<A> addNewRuleLike(PodHttpChaosRule item) {
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
  
  public A addToRules(PodHttpChaosRule... items) {
    if (this.rules == null) {
      this.rules = new ArrayList();
    }
    for (PodHttpChaosRule item : items) {
        PodHttpChaosRuleBuilder builder = new PodHttpChaosRuleBuilder(item);
        _visitables.get("rules").add(builder);
        this.rules.add(builder);
    }
    return (A) this;
  }
  
  public A addToRules(int index,PodHttpChaosRule item) {
    if (this.rules == null) {
      this.rules = new ArrayList();
    }
    PodHttpChaosRuleBuilder builder = new PodHttpChaosRuleBuilder(item);
    if (index < 0 || index >= rules.size()) {
        _visitables.get("rules").add(builder);
        rules.add(builder);
    } else {
        _visitables.get("rules").add(builder);
        rules.add(index, builder);
    }
    return (A) this;
  }
  
  public PodHttpChaosRule buildFirstRule() {
    return this.rules.get(0).build();
  }
  
  public PodHttpChaosRule buildLastRule() {
    return this.rules.get(rules.size() - 1).build();
  }
  
  public PodHttpChaosRule buildMatchingRule(Predicate<PodHttpChaosRuleBuilder> predicate) {
      for (PodHttpChaosRuleBuilder item : rules) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public PodHttpChaosRule buildRule(int index) {
    return this.rules.get(index).build();
  }
  
  public List<PodHttpChaosRule> buildRules() {
    return this.rules != null ? build(rules) : null;
  }
  
  public PodHttpChaosTLS buildTls() {
    return this.tls != null ? this.tls.build() : null;
  }
  
  protected void copyInstance(PodHttpChaosSpec instance) {
    instance = instance != null ? instance : new PodHttpChaosSpec();
    if (instance != null) {
        this.withRules(instance.getRules());
        this.withTls(instance.getTls());
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
  
  public RulesNested<A> editMatchingRule(Predicate<PodHttpChaosRuleBuilder> predicate) {
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
  
  public TlsNested<A> editOrNewTls() {
    return this.withNewTlsLike(Optional.ofNullable(this.buildTls()).orElse(new PodHttpChaosTLSBuilder().build()));
  }
  
  public TlsNested<A> editOrNewTlsLike(PodHttpChaosTLS item) {
    return this.withNewTlsLike(Optional.ofNullable(this.buildTls()).orElse(item));
  }
  
  public RulesNested<A> editRule(int index) {
    if (rules.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "rules"));
    }
    return this.setNewRuleLike(index, this.buildRule(index));
  }
  
  public TlsNested<A> editTls() {
    return this.withNewTlsLike(Optional.ofNullable(this.buildTls()).orElse(null));
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
    PodHttpChaosSpecFluent that = (PodHttpChaosSpecFluent) o;
    if (!(Objects.equals(rules, that.rules))) {
      return false;
    }
    if (!(Objects.equals(tls, that.tls))) {
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
  
  public boolean hasMatchingRule(Predicate<PodHttpChaosRuleBuilder> predicate) {
      for (PodHttpChaosRuleBuilder item : rules) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasRules() {
    return this.rules != null && !(this.rules.isEmpty());
  }
  
  public boolean hasTls() {
    return this.tls != null;
  }
  
  public int hashCode() {
    return Objects.hash(rules, tls, additionalProperties);
  }
  
  public A removeAllFromRules(Collection<PodHttpChaosRule> items) {
    if (this.rules == null) {
      return (A) this;
    }
    for (PodHttpChaosRule item : items) {
        PodHttpChaosRuleBuilder builder = new PodHttpChaosRuleBuilder(item);
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
  
  public A removeFromRules(PodHttpChaosRule... items) {
    if (this.rules == null) {
      return (A) this;
    }
    for (PodHttpChaosRule item : items) {
        PodHttpChaosRuleBuilder builder = new PodHttpChaosRuleBuilder(item);
        _visitables.get("rules").remove(builder);
        this.rules.remove(builder);
    }
    return (A) this;
  }
  
  public A removeMatchingFromRules(Predicate<PodHttpChaosRuleBuilder> predicate) {
    if (rules == null) {
      return (A) this;
    }
    Iterator<PodHttpChaosRuleBuilder> each = rules.iterator();
    List visitables = _visitables.get("rules");
    while (each.hasNext()) {
        PodHttpChaosRuleBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public RulesNested<A> setNewRuleLike(int index,PodHttpChaosRule item) {
    return new RulesNested(index, item);
  }
  
  public A setToRules(int index,PodHttpChaosRule item) {
    if (this.rules == null) {
      this.rules = new ArrayList();
    }
    PodHttpChaosRuleBuilder builder = new PodHttpChaosRuleBuilder(item);
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
    if (!(tls == null)) {
        sb.append("tls:");
        sb.append(tls);
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
  
  public TlsNested<A> withNewTls() {
    return new TlsNested(null);
  }
  
  public A withNewTls(String caName,String certName,String keyName,String secretName,String secretNamespace) {
    return (A) this.withTls(new PodHttpChaosTLS(caName, certName, keyName, secretName, secretNamespace));
  }
  
  public TlsNested<A> withNewTlsLike(PodHttpChaosTLS item) {
    return new TlsNested(item);
  }
  
  public A withRules(List<PodHttpChaosRule> rules) {
    if (this.rules != null) {
      this._visitables.get("rules").clear();
    }
    if (rules != null) {
        this.rules = new ArrayList();
        for (PodHttpChaosRule item : rules) {
          this.addToRules(item);
        }
    } else {
      this.rules = null;
    }
    return (A) this;
  }
  
  public A withRules(PodHttpChaosRule... rules) {
    if (this.rules != null) {
        this.rules.clear();
        _visitables.remove("rules");
    }
    if (rules != null) {
      for (PodHttpChaosRule item : rules) {
        this.addToRules(item);
      }
    }
    return (A) this;
  }
  
  public A withTls(PodHttpChaosTLS tls) {
    this._visitables.remove("tls");
    if (tls != null) {
        this.tls = new PodHttpChaosTLSBuilder(tls);
        this._visitables.get("tls").add(this.tls);
    } else {
        this.tls = null;
        this._visitables.get("tls").remove(this.tls);
    }
    return (A) this;
  }
  public class RulesNested<N> extends PodHttpChaosRuleFluent<RulesNested<N>> implements Nested<N>{
  
    PodHttpChaosRuleBuilder builder;
    int index;
  
    RulesNested(int index,PodHttpChaosRule item) {
      this.index = index;
      this.builder = new PodHttpChaosRuleBuilder(this, item);
    }
  
    public N and() {
      return (N) PodHttpChaosSpecFluent.this.setToRules(index, builder.build());
    }
    
    public N endRule() {
      return and();
    }
    
  }
  public class TlsNested<N> extends PodHttpChaosTLSFluent<TlsNested<N>> implements Nested<N>{
  
    PodHttpChaosTLSBuilder builder;
  
    TlsNested(PodHttpChaosTLS item) {
      this.builder = new PodHttpChaosTLSBuilder(this, item);
    }
  
    public N and() {
      return (N) PodHttpChaosSpecFluent.this.withTls(builder.build());
    }
    
    public N endTls() {
      return and();
    }
    
  }
}