package io.fabric8.kubernetes.api.model.rbac;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import io.fabric8.kubernetes.api.model.ObjectMeta;
import io.fabric8.kubernetes.api.model.ObjectMetaBuilder;
import io.fabric8.kubernetes.api.model.ObjectMetaFluent;
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
public class ClusterRoleFluent<A extends io.fabric8.kubernetes.api.model.rbac.ClusterRoleFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private AggregationRuleBuilder aggregationRule;
  private String apiVersion;
  private String kind;
  private ObjectMetaBuilder metadata;
  private ArrayList<PolicyRuleBuilder> rules = new ArrayList<PolicyRuleBuilder>();

  public ClusterRoleFluent() {
  }
  
  public ClusterRoleFluent(ClusterRole instance) {
    this.copyInstance(instance);
  }

  public A addAllToRules(Collection<PolicyRule> items) {
    if (this.rules == null) {
      this.rules = new ArrayList();
    }
    for (PolicyRule item : items) {
        PolicyRuleBuilder builder = new PolicyRuleBuilder(item);
        _visitables.get("rules").add(builder);
        this.rules.add(builder);
    }
    return (A) this;
  }
  
  public RulesNested<A> addNewRule() {
    return new RulesNested(-1, null);
  }
  
  public RulesNested<A> addNewRuleLike(PolicyRule item) {
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
  
  public A addToRules(PolicyRule... items) {
    if (this.rules == null) {
      this.rules = new ArrayList();
    }
    for (PolicyRule item : items) {
        PolicyRuleBuilder builder = new PolicyRuleBuilder(item);
        _visitables.get("rules").add(builder);
        this.rules.add(builder);
    }
    return (A) this;
  }
  
  public A addToRules(int index,PolicyRule item) {
    if (this.rules == null) {
      this.rules = new ArrayList();
    }
    PolicyRuleBuilder builder = new PolicyRuleBuilder(item);
    if (index < 0 || index >= rules.size()) {
        _visitables.get("rules").add(builder);
        rules.add(builder);
    } else {
        _visitables.get("rules").add(builder);
        rules.add(index, builder);
    }
    return (A) this;
  }
  
  public AggregationRule buildAggregationRule() {
    return this.aggregationRule != null ? this.aggregationRule.build() : null;
  }
  
  public PolicyRule buildFirstRule() {
    return this.rules.get(0).build();
  }
  
  public PolicyRule buildLastRule() {
    return this.rules.get(rules.size() - 1).build();
  }
  
  public PolicyRule buildMatchingRule(Predicate<PolicyRuleBuilder> predicate) {
      for (PolicyRuleBuilder item : rules) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public ObjectMeta buildMetadata() {
    return this.metadata != null ? this.metadata.build() : null;
  }
  
  public PolicyRule buildRule(int index) {
    return this.rules.get(index).build();
  }
  
  public List<PolicyRule> buildRules() {
    return this.rules != null ? build(rules) : null;
  }
  
  protected void copyInstance(ClusterRole instance) {
    instance = instance != null ? instance : new ClusterRole();
    if (instance != null) {
        this.withAggregationRule(instance.getAggregationRule());
        this.withApiVersion(instance.getApiVersion());
        this.withKind(instance.getKind());
        this.withMetadata(instance.getMetadata());
        this.withRules(instance.getRules());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public AggregationRuleNested<A> editAggregationRule() {
    return this.withNewAggregationRuleLike(Optional.ofNullable(this.buildAggregationRule()).orElse(null));
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
  
  public RulesNested<A> editMatchingRule(Predicate<PolicyRuleBuilder> predicate) {
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
  
  public MetadataNested<A> editMetadata() {
    return this.withNewMetadataLike(Optional.ofNullable(this.buildMetadata()).orElse(null));
  }
  
  public AggregationRuleNested<A> editOrNewAggregationRule() {
    return this.withNewAggregationRuleLike(Optional.ofNullable(this.buildAggregationRule()).orElse(new AggregationRuleBuilder().build()));
  }
  
  public AggregationRuleNested<A> editOrNewAggregationRuleLike(AggregationRule item) {
    return this.withNewAggregationRuleLike(Optional.ofNullable(this.buildAggregationRule()).orElse(item));
  }
  
  public MetadataNested<A> editOrNewMetadata() {
    return this.withNewMetadataLike(Optional.ofNullable(this.buildMetadata()).orElse(new ObjectMetaBuilder().build()));
  }
  
  public MetadataNested<A> editOrNewMetadataLike(ObjectMeta item) {
    return this.withNewMetadataLike(Optional.ofNullable(this.buildMetadata()).orElse(item));
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
    ClusterRoleFluent that = (ClusterRoleFluent) o;
    if (!(Objects.equals(aggregationRule, that.aggregationRule))) {
      return false;
    }
    if (!(Objects.equals(apiVersion, that.apiVersion))) {
      return false;
    }
    if (!(Objects.equals(kind, that.kind))) {
      return false;
    }
    if (!(Objects.equals(metadata, that.metadata))) {
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
  
  public String getApiVersion() {
    return this.apiVersion;
  }
  
  public String getKind() {
    return this.kind;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasAggregationRule() {
    return this.aggregationRule != null;
  }
  
  public boolean hasApiVersion() {
    return this.apiVersion != null;
  }
  
  public boolean hasKind() {
    return this.kind != null;
  }
  
  public boolean hasMatchingRule(Predicate<PolicyRuleBuilder> predicate) {
      for (PolicyRuleBuilder item : rules) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMetadata() {
    return this.metadata != null;
  }
  
  public boolean hasRules() {
    return this.rules != null && !(this.rules.isEmpty());
  }
  
  public int hashCode() {
    return Objects.hash(aggregationRule, apiVersion, kind, metadata, rules, additionalProperties);
  }
  
  public A removeAllFromRules(Collection<PolicyRule> items) {
    if (this.rules == null) {
      return (A) this;
    }
    for (PolicyRule item : items) {
        PolicyRuleBuilder builder = new PolicyRuleBuilder(item);
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
  
  public A removeFromRules(PolicyRule... items) {
    if (this.rules == null) {
      return (A) this;
    }
    for (PolicyRule item : items) {
        PolicyRuleBuilder builder = new PolicyRuleBuilder(item);
        _visitables.get("rules").remove(builder);
        this.rules.remove(builder);
    }
    return (A) this;
  }
  
  public A removeMatchingFromRules(Predicate<PolicyRuleBuilder> predicate) {
    if (rules == null) {
      return (A) this;
    }
    Iterator<PolicyRuleBuilder> each = rules.iterator();
    List visitables = _visitables.get("rules");
    while (each.hasNext()) {
        PolicyRuleBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public RulesNested<A> setNewRuleLike(int index,PolicyRule item) {
    return new RulesNested(index, item);
  }
  
  public A setToRules(int index,PolicyRule item) {
    if (this.rules == null) {
      this.rules = new ArrayList();
    }
    PolicyRuleBuilder builder = new PolicyRuleBuilder(item);
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
    if (!(aggregationRule == null)) {
        sb.append("aggregationRule:");
        sb.append(aggregationRule);
        sb.append(",");
    }
    if (!(apiVersion == null)) {
        sb.append("apiVersion:");
        sb.append(apiVersion);
        sb.append(",");
    }
    if (!(kind == null)) {
        sb.append("kind:");
        sb.append(kind);
        sb.append(",");
    }
    if (!(metadata == null)) {
        sb.append("metadata:");
        sb.append(metadata);
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
  
  public A withAggregationRule(AggregationRule aggregationRule) {
    this._visitables.remove("aggregationRule");
    if (aggregationRule != null) {
        this.aggregationRule = new AggregationRuleBuilder(aggregationRule);
        this._visitables.get("aggregationRule").add(this.aggregationRule);
    } else {
        this.aggregationRule = null;
        this._visitables.get("aggregationRule").remove(this.aggregationRule);
    }
    return (A) this;
  }
  
  public A withApiVersion(String apiVersion) {
    this.apiVersion = apiVersion;
    return (A) this;
  }
  
  public A withKind(String kind) {
    this.kind = kind;
    return (A) this;
  }
  
  public A withMetadata(ObjectMeta metadata) {
    this._visitables.remove("metadata");
    if (metadata != null) {
        this.metadata = new ObjectMetaBuilder(metadata);
        this._visitables.get("metadata").add(this.metadata);
    } else {
        this.metadata = null;
        this._visitables.get("metadata").remove(this.metadata);
    }
    return (A) this;
  }
  
  public AggregationRuleNested<A> withNewAggregationRule() {
    return new AggregationRuleNested(null);
  }
  
  public AggregationRuleNested<A> withNewAggregationRuleLike(AggregationRule item) {
    return new AggregationRuleNested(item);
  }
  
  public MetadataNested<A> withNewMetadata() {
    return new MetadataNested(null);
  }
  
  public MetadataNested<A> withNewMetadataLike(ObjectMeta item) {
    return new MetadataNested(item);
  }
  
  public A withRules(List<PolicyRule> rules) {
    if (this.rules != null) {
      this._visitables.get("rules").clear();
    }
    if (rules != null) {
        this.rules = new ArrayList();
        for (PolicyRule item : rules) {
          this.addToRules(item);
        }
    } else {
      this.rules = null;
    }
    return (A) this;
  }
  
  public A withRules(PolicyRule... rules) {
    if (this.rules != null) {
        this.rules.clear();
        _visitables.remove("rules");
    }
    if (rules != null) {
      for (PolicyRule item : rules) {
        this.addToRules(item);
      }
    }
    return (A) this;
  }
  public class AggregationRuleNested<N> extends AggregationRuleFluent<AggregationRuleNested<N>> implements Nested<N>{
  
    AggregationRuleBuilder builder;
  
    AggregationRuleNested(AggregationRule item) {
      this.builder = new AggregationRuleBuilder(this, item);
    }
  
    public N and() {
      return (N) ClusterRoleFluent.this.withAggregationRule(builder.build());
    }
    
    public N endAggregationRule() {
      return and();
    }
    
  }
  public class MetadataNested<N> extends ObjectMetaFluent<MetadataNested<N>> implements Nested<N>{
  
    ObjectMetaBuilder builder;
  
    MetadataNested(ObjectMeta item) {
      this.builder = new ObjectMetaBuilder(this, item);
    }
  
    public N and() {
      return (N) ClusterRoleFluent.this.withMetadata(builder.build());
    }
    
    public N endMetadata() {
      return and();
    }
    
  }
  public class RulesNested<N> extends PolicyRuleFluent<RulesNested<N>> implements Nested<N>{
  
    PolicyRuleBuilder builder;
    int index;
  
    RulesNested(int index,PolicyRule item) {
      this.index = index;
      this.builder = new PolicyRuleBuilder(this, item);
    }
  
    public N and() {
      return (N) ClusterRoleFluent.this.setToRules(index, builder.build());
    }
    
    public N endRule() {
      return and();
    }
    
  }
}