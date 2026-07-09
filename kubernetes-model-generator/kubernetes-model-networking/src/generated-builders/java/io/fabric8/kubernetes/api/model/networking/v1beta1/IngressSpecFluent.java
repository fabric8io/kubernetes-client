package io.fabric8.kubernetes.api.model.networking.v1beta1;

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
public class IngressSpecFluent<A extends io.fabric8.kubernetes.api.model.networking.v1beta1.IngressSpecFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private IngressBackendBuilder backend;
  private String ingressClassName;
  private ArrayList<IngressRuleBuilder> rules = new ArrayList<IngressRuleBuilder>();
  private ArrayList<IngressTLSBuilder> tls = new ArrayList<IngressTLSBuilder>();

  public IngressSpecFluent() {
  }
  
  public IngressSpecFluent(IngressSpec instance) {
    this.copyInstance(instance);
  }

  public A addAllToRules(Collection<IngressRule> items) {
    if (this.rules == null) {
      this.rules = new ArrayList();
    }
    for (IngressRule item : items) {
        IngressRuleBuilder builder = new IngressRuleBuilder(item);
        _visitables.get("rules").add(builder);
        this.rules.add(builder);
    }
    return (A) this;
  }
  
  public A addAllToTls(Collection<IngressTLS> items) {
    if (this.tls == null) {
      this.tls = new ArrayList();
    }
    for (IngressTLS item : items) {
        IngressTLSBuilder builder = new IngressTLSBuilder(item);
        _visitables.get("tls").add(builder);
        this.tls.add(builder);
    }
    return (A) this;
  }
  
  public RulesNested<A> addNewRule() {
    return new RulesNested(-1, null);
  }
  
  public RulesNested<A> addNewRuleLike(IngressRule item) {
    return new RulesNested(-1, item);
  }
  
  public TlsNested<A> addNewTl() {
    return new TlsNested(-1, null);
  }
  
  public TlsNested<A> addNewTlLike(IngressTLS item) {
    return new TlsNested(-1, item);
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
  
  public A addToRules(IngressRule... items) {
    if (this.rules == null) {
      this.rules = new ArrayList();
    }
    for (IngressRule item : items) {
        IngressRuleBuilder builder = new IngressRuleBuilder(item);
        _visitables.get("rules").add(builder);
        this.rules.add(builder);
    }
    return (A) this;
  }
  
  public A addToRules(int index,IngressRule item) {
    if (this.rules == null) {
      this.rules = new ArrayList();
    }
    IngressRuleBuilder builder = new IngressRuleBuilder(item);
    if (index < 0 || index >= rules.size()) {
        _visitables.get("rules").add(builder);
        rules.add(builder);
    } else {
        _visitables.get("rules").add(builder);
        rules.add(index, builder);
    }
    return (A) this;
  }
  
  public A addToTls(IngressTLS... items) {
    if (this.tls == null) {
      this.tls = new ArrayList();
    }
    for (IngressTLS item : items) {
        IngressTLSBuilder builder = new IngressTLSBuilder(item);
        _visitables.get("tls").add(builder);
        this.tls.add(builder);
    }
    return (A) this;
  }
  
  public A addToTls(int index,IngressTLS item) {
    if (this.tls == null) {
      this.tls = new ArrayList();
    }
    IngressTLSBuilder builder = new IngressTLSBuilder(item);
    if (index < 0 || index >= tls.size()) {
        _visitables.get("tls").add(builder);
        tls.add(builder);
    } else {
        _visitables.get("tls").add(builder);
        tls.add(index, builder);
    }
    return (A) this;
  }
  
  public IngressBackend buildBackend() {
    return this.backend != null ? this.backend.build() : null;
  }
  
  public IngressRule buildFirstRule() {
    return this.rules.get(0).build();
  }
  
  public IngressTLS buildFirstTl() {
    return this.tls.get(0).build();
  }
  
  public IngressRule buildLastRule() {
    return this.rules.get(rules.size() - 1).build();
  }
  
  public IngressTLS buildLastTl() {
    return this.tls.get(tls.size() - 1).build();
  }
  
  public IngressRule buildMatchingRule(Predicate<IngressRuleBuilder> predicate) {
      for (IngressRuleBuilder item : rules) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public IngressTLS buildMatchingTl(Predicate<IngressTLSBuilder> predicate) {
      for (IngressTLSBuilder item : tls) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public IngressRule buildRule(int index) {
    return this.rules.get(index).build();
  }
  
  public List<IngressRule> buildRules() {
    return this.rules != null ? build(rules) : null;
  }
  
  public IngressTLS buildTl(int index) {
    return this.tls.get(index).build();
  }
  
  public List<IngressTLS> buildTls() {
    return this.tls != null ? build(tls) : null;
  }
  
  protected void copyInstance(IngressSpec instance) {
    instance = instance != null ? instance : new IngressSpec();
    if (instance != null) {
        this.withBackend(instance.getBackend());
        this.withIngressClassName(instance.getIngressClassName());
        this.withRules(instance.getRules());
        this.withTls(instance.getTls());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public BackendNested<A> editBackend() {
    return this.withNewBackendLike(Optional.ofNullable(this.buildBackend()).orElse(null));
  }
  
  public RulesNested<A> editFirstRule() {
    if (rules.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "rules"));
    }
    return this.setNewRuleLike(0, this.buildRule(0));
  }
  
  public TlsNested<A> editFirstTl() {
    if (tls.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "tls"));
    }
    return this.setNewTlLike(0, this.buildTl(0));
  }
  
  public RulesNested<A> editLastRule() {
    int index = rules.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "rules"));
    }
    return this.setNewRuleLike(index, this.buildRule(index));
  }
  
  public TlsNested<A> editLastTl() {
    int index = tls.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "tls"));
    }
    return this.setNewTlLike(index, this.buildTl(index));
  }
  
  public RulesNested<A> editMatchingRule(Predicate<IngressRuleBuilder> predicate) {
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
  
  public TlsNested<A> editMatchingTl(Predicate<IngressTLSBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < tls.size();i++) {
      if (predicate.test(tls.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "tls"));
    }
    return this.setNewTlLike(index, this.buildTl(index));
  }
  
  public BackendNested<A> editOrNewBackend() {
    return this.withNewBackendLike(Optional.ofNullable(this.buildBackend()).orElse(new IngressBackendBuilder().build()));
  }
  
  public BackendNested<A> editOrNewBackendLike(IngressBackend item) {
    return this.withNewBackendLike(Optional.ofNullable(this.buildBackend()).orElse(item));
  }
  
  public RulesNested<A> editRule(int index) {
    if (rules.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "rules"));
    }
    return this.setNewRuleLike(index, this.buildRule(index));
  }
  
  public TlsNested<A> editTl(int index) {
    if (tls.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "tls"));
    }
    return this.setNewTlLike(index, this.buildTl(index));
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
    IngressSpecFluent that = (IngressSpecFluent) o;
    if (!(Objects.equals(backend, that.backend))) {
      return false;
    }
    if (!(Objects.equals(ingressClassName, that.ingressClassName))) {
      return false;
    }
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
  
  public String getIngressClassName() {
    return this.ingressClassName;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasBackend() {
    return this.backend != null;
  }
  
  public boolean hasIngressClassName() {
    return this.ingressClassName != null;
  }
  
  public boolean hasMatchingRule(Predicate<IngressRuleBuilder> predicate) {
      for (IngressRuleBuilder item : rules) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingTl(Predicate<IngressTLSBuilder> predicate) {
      for (IngressTLSBuilder item : tls) {
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
    return this.tls != null && !(this.tls.isEmpty());
  }
  
  public int hashCode() {
    return Objects.hash(backend, ingressClassName, rules, tls, additionalProperties);
  }
  
  public A removeAllFromRules(Collection<IngressRule> items) {
    if (this.rules == null) {
      return (A) this;
    }
    for (IngressRule item : items) {
        IngressRuleBuilder builder = new IngressRuleBuilder(item);
        _visitables.get("rules").remove(builder);
        this.rules.remove(builder);
    }
    return (A) this;
  }
  
  public A removeAllFromTls(Collection<IngressTLS> items) {
    if (this.tls == null) {
      return (A) this;
    }
    for (IngressTLS item : items) {
        IngressTLSBuilder builder = new IngressTLSBuilder(item);
        _visitables.get("tls").remove(builder);
        this.tls.remove(builder);
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
  
  public A removeFromRules(IngressRule... items) {
    if (this.rules == null) {
      return (A) this;
    }
    for (IngressRule item : items) {
        IngressRuleBuilder builder = new IngressRuleBuilder(item);
        _visitables.get("rules").remove(builder);
        this.rules.remove(builder);
    }
    return (A) this;
  }
  
  public A removeFromTls(IngressTLS... items) {
    if (this.tls == null) {
      return (A) this;
    }
    for (IngressTLS item : items) {
        IngressTLSBuilder builder = new IngressTLSBuilder(item);
        _visitables.get("tls").remove(builder);
        this.tls.remove(builder);
    }
    return (A) this;
  }
  
  public A removeMatchingFromRules(Predicate<IngressRuleBuilder> predicate) {
    if (rules == null) {
      return (A) this;
    }
    Iterator<IngressRuleBuilder> each = rules.iterator();
    List visitables = _visitables.get("rules");
    while (each.hasNext()) {
        IngressRuleBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public A removeMatchingFromTls(Predicate<IngressTLSBuilder> predicate) {
    if (tls == null) {
      return (A) this;
    }
    Iterator<IngressTLSBuilder> each = tls.iterator();
    List visitables = _visitables.get("tls");
    while (each.hasNext()) {
        IngressTLSBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public RulesNested<A> setNewRuleLike(int index,IngressRule item) {
    return new RulesNested(index, item);
  }
  
  public TlsNested<A> setNewTlLike(int index,IngressTLS item) {
    return new TlsNested(index, item);
  }
  
  public A setToRules(int index,IngressRule item) {
    if (this.rules == null) {
      this.rules = new ArrayList();
    }
    IngressRuleBuilder builder = new IngressRuleBuilder(item);
    if (index < 0 || index >= rules.size()) {
        _visitables.get("rules").add(builder);
        rules.add(builder);
    } else {
        _visitables.get("rules").add(builder);
        rules.set(index, builder);
    }
    return (A) this;
  }
  
  public A setToTls(int index,IngressTLS item) {
    if (this.tls == null) {
      this.tls = new ArrayList();
    }
    IngressTLSBuilder builder = new IngressTLSBuilder(item);
    if (index < 0 || index >= tls.size()) {
        _visitables.get("tls").add(builder);
        tls.add(builder);
    } else {
        _visitables.get("tls").add(builder);
        tls.set(index, builder);
    }
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(backend == null)) {
        sb.append("backend:");
        sb.append(backend);
        sb.append(",");
    }
    if (!(ingressClassName == null)) {
        sb.append("ingressClassName:");
        sb.append(ingressClassName);
        sb.append(",");
    }
    if (!(rules == null) && !(rules.isEmpty())) {
        sb.append("rules:");
        sb.append(rules);
        sb.append(",");
    }
    if (!(tls == null) && !(tls.isEmpty())) {
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
  
  public A withBackend(IngressBackend backend) {
    this._visitables.remove("backend");
    if (backend != null) {
        this.backend = new IngressBackendBuilder(backend);
        this._visitables.get("backend").add(this.backend);
    } else {
        this.backend = null;
        this._visitables.get("backend").remove(this.backend);
    }
    return (A) this;
  }
  
  public A withIngressClassName(String ingressClassName) {
    this.ingressClassName = ingressClassName;
    return (A) this;
  }
  
  public BackendNested<A> withNewBackend() {
    return new BackendNested(null);
  }
  
  public BackendNested<A> withNewBackendLike(IngressBackend item) {
    return new BackendNested(item);
  }
  
  public A withRules(List<IngressRule> rules) {
    if (this.rules != null) {
      this._visitables.get("rules").clear();
    }
    if (rules != null) {
        this.rules = new ArrayList();
        for (IngressRule item : rules) {
          this.addToRules(item);
        }
    } else {
      this.rules = null;
    }
    return (A) this;
  }
  
  public A withRules(IngressRule... rules) {
    if (this.rules != null) {
        this.rules.clear();
        _visitables.remove("rules");
    }
    if (rules != null) {
      for (IngressRule item : rules) {
        this.addToRules(item);
      }
    }
    return (A) this;
  }
  
  public A withTls(List<IngressTLS> tls) {
    if (this.tls != null) {
      this._visitables.get("tls").clear();
    }
    if (tls != null) {
        this.tls = new ArrayList();
        for (IngressTLS item : tls) {
          this.addToTls(item);
        }
    } else {
      this.tls = null;
    }
    return (A) this;
  }
  
  public A withTls(IngressTLS... tls) {
    if (this.tls != null) {
        this.tls.clear();
        _visitables.remove("tls");
    }
    if (tls != null) {
      for (IngressTLS item : tls) {
        this.addToTls(item);
      }
    }
    return (A) this;
  }
  public class BackendNested<N> extends IngressBackendFluent<BackendNested<N>> implements Nested<N>{
  
    IngressBackendBuilder builder;
  
    BackendNested(IngressBackend item) {
      this.builder = new IngressBackendBuilder(this, item);
    }
  
    public N and() {
      return (N) IngressSpecFluent.this.withBackend(builder.build());
    }
    
    public N endBackend() {
      return and();
    }
    
  }
  public class RulesNested<N> extends IngressRuleFluent<RulesNested<N>> implements Nested<N>{
  
    IngressRuleBuilder builder;
    int index;
  
    RulesNested(int index,IngressRule item) {
      this.index = index;
      this.builder = new IngressRuleBuilder(this, item);
    }
  
    public N and() {
      return (N) IngressSpecFluent.this.setToRules(index, builder.build());
    }
    
    public N endRule() {
      return and();
    }
    
  }
  public class TlsNested<N> extends IngressTLSFluent<TlsNested<N>> implements Nested<N>{
  
    IngressTLSBuilder builder;
    int index;
  
    TlsNested(int index,IngressTLS item) {
      this.index = index;
      this.builder = new IngressTLSBuilder(this, item);
    }
  
    public N and() {
      return (N) IngressSpecFluent.this.setToTls(index, builder.build());
    }
    
    public N endTl() {
      return and();
    }
    
  }
}