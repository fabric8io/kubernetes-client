package io.fabric8.kubernetes.api.model.admissionregistration.v1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import io.fabric8.kubernetes.api.model.LabelSelector;
import io.fabric8.kubernetes.api.model.LabelSelectorBuilder;
import io.fabric8.kubernetes.api.model.LabelSelectorFluent;
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
public class MutatingWebhookFluent<A extends io.fabric8.kubernetes.api.model.admissionregistration.v1.MutatingWebhookFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private List<String> admissionReviewVersions = new ArrayList<String>();
  private WebhookClientConfigBuilder clientConfig;
  private String failurePolicy;
  private ArrayList<MatchConditionBuilder> matchConditions = new ArrayList<MatchConditionBuilder>();
  private String matchPolicy;
  private String name;
  private LabelSelectorBuilder namespaceSelector;
  private LabelSelectorBuilder objectSelector;
  private String reinvocationPolicy;
  private ArrayList<RuleWithOperationsBuilder> rules = new ArrayList<RuleWithOperationsBuilder>();
  private String sideEffects;
  private Integer timeoutSeconds;

  public MutatingWebhookFluent() {
  }
  
  public MutatingWebhookFluent(MutatingWebhook instance) {
    this.copyInstance(instance);
  }

  public A addAllToAdmissionReviewVersions(Collection<String> items) {
    if (this.admissionReviewVersions == null) {
      this.admissionReviewVersions = new ArrayList();
    }
    for (String item : items) {
      this.admissionReviewVersions.add(item);
    }
    return (A) this;
  }
  
  public A addAllToMatchConditions(Collection<MatchCondition> items) {
    if (this.matchConditions == null) {
      this.matchConditions = new ArrayList();
    }
    for (MatchCondition item : items) {
        MatchConditionBuilder builder = new MatchConditionBuilder(item);
        _visitables.get("matchConditions").add(builder);
        this.matchConditions.add(builder);
    }
    return (A) this;
  }
  
  public A addAllToRules(Collection<RuleWithOperations> items) {
    if (this.rules == null) {
      this.rules = new ArrayList();
    }
    for (RuleWithOperations item : items) {
        RuleWithOperationsBuilder builder = new RuleWithOperationsBuilder(item);
        _visitables.get("rules").add(builder);
        this.rules.add(builder);
    }
    return (A) this;
  }
  
  public MatchConditionsNested<A> addNewMatchCondition() {
    return new MatchConditionsNested(-1, null);
  }
  
  public A addNewMatchCondition(String expression,String name) {
    return (A) this.addToMatchConditions(new MatchCondition(expression, name));
  }
  
  public MatchConditionsNested<A> addNewMatchConditionLike(MatchCondition item) {
    return new MatchConditionsNested(-1, item);
  }
  
  public RulesNested<A> addNewRule() {
    return new RulesNested(-1, null);
  }
  
  public RulesNested<A> addNewRuleLike(RuleWithOperations item) {
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
  
  public A addToAdmissionReviewVersions(String... items) {
    if (this.admissionReviewVersions == null) {
      this.admissionReviewVersions = new ArrayList();
    }
    for (String item : items) {
      this.admissionReviewVersions.add(item);
    }
    return (A) this;
  }
  
  public A addToAdmissionReviewVersions(int index,String item) {
    if (this.admissionReviewVersions == null) {
      this.admissionReviewVersions = new ArrayList();
    }
    this.admissionReviewVersions.add(index, item);
    return (A) this;
  }
  
  public A addToMatchConditions(MatchCondition... items) {
    if (this.matchConditions == null) {
      this.matchConditions = new ArrayList();
    }
    for (MatchCondition item : items) {
        MatchConditionBuilder builder = new MatchConditionBuilder(item);
        _visitables.get("matchConditions").add(builder);
        this.matchConditions.add(builder);
    }
    return (A) this;
  }
  
  public A addToMatchConditions(int index,MatchCondition item) {
    if (this.matchConditions == null) {
      this.matchConditions = new ArrayList();
    }
    MatchConditionBuilder builder = new MatchConditionBuilder(item);
    if (index < 0 || index >= matchConditions.size()) {
        _visitables.get("matchConditions").add(builder);
        matchConditions.add(builder);
    } else {
        _visitables.get("matchConditions").add(builder);
        matchConditions.add(index, builder);
    }
    return (A) this;
  }
  
  public A addToRules(RuleWithOperations... items) {
    if (this.rules == null) {
      this.rules = new ArrayList();
    }
    for (RuleWithOperations item : items) {
        RuleWithOperationsBuilder builder = new RuleWithOperationsBuilder(item);
        _visitables.get("rules").add(builder);
        this.rules.add(builder);
    }
    return (A) this;
  }
  
  public A addToRules(int index,RuleWithOperations item) {
    if (this.rules == null) {
      this.rules = new ArrayList();
    }
    RuleWithOperationsBuilder builder = new RuleWithOperationsBuilder(item);
    if (index < 0 || index >= rules.size()) {
        _visitables.get("rules").add(builder);
        rules.add(builder);
    } else {
        _visitables.get("rules").add(builder);
        rules.add(index, builder);
    }
    return (A) this;
  }
  
  public WebhookClientConfig buildClientConfig() {
    return this.clientConfig != null ? this.clientConfig.build() : null;
  }
  
  public MatchCondition buildFirstMatchCondition() {
    return this.matchConditions.get(0).build();
  }
  
  public RuleWithOperations buildFirstRule() {
    return this.rules.get(0).build();
  }
  
  public MatchCondition buildLastMatchCondition() {
    return this.matchConditions.get(matchConditions.size() - 1).build();
  }
  
  public RuleWithOperations buildLastRule() {
    return this.rules.get(rules.size() - 1).build();
  }
  
  public MatchCondition buildMatchCondition(int index) {
    return this.matchConditions.get(index).build();
  }
  
  public List<MatchCondition> buildMatchConditions() {
    return this.matchConditions != null ? build(matchConditions) : null;
  }
  
  public MatchCondition buildMatchingMatchCondition(Predicate<MatchConditionBuilder> predicate) {
      for (MatchConditionBuilder item : matchConditions) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public RuleWithOperations buildMatchingRule(Predicate<RuleWithOperationsBuilder> predicate) {
      for (RuleWithOperationsBuilder item : rules) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public LabelSelector buildNamespaceSelector() {
    return this.namespaceSelector != null ? this.namespaceSelector.build() : null;
  }
  
  public LabelSelector buildObjectSelector() {
    return this.objectSelector != null ? this.objectSelector.build() : null;
  }
  
  public RuleWithOperations buildRule(int index) {
    return this.rules.get(index).build();
  }
  
  public List<RuleWithOperations> buildRules() {
    return this.rules != null ? build(rules) : null;
  }
  
  protected void copyInstance(MutatingWebhook instance) {
    instance = instance != null ? instance : new MutatingWebhook();
    if (instance != null) {
        this.withAdmissionReviewVersions(instance.getAdmissionReviewVersions());
        this.withClientConfig(instance.getClientConfig());
        this.withFailurePolicy(instance.getFailurePolicy());
        this.withMatchConditions(instance.getMatchConditions());
        this.withMatchPolicy(instance.getMatchPolicy());
        this.withName(instance.getName());
        this.withNamespaceSelector(instance.getNamespaceSelector());
        this.withObjectSelector(instance.getObjectSelector());
        this.withReinvocationPolicy(instance.getReinvocationPolicy());
        this.withRules(instance.getRules());
        this.withSideEffects(instance.getSideEffects());
        this.withTimeoutSeconds(instance.getTimeoutSeconds());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public ClientConfigNested<A> editClientConfig() {
    return this.withNewClientConfigLike(Optional.ofNullable(this.buildClientConfig()).orElse(null));
  }
  
  public MatchConditionsNested<A> editFirstMatchCondition() {
    if (matchConditions.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "matchConditions"));
    }
    return this.setNewMatchConditionLike(0, this.buildMatchCondition(0));
  }
  
  public RulesNested<A> editFirstRule() {
    if (rules.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "rules"));
    }
    return this.setNewRuleLike(0, this.buildRule(0));
  }
  
  public MatchConditionsNested<A> editLastMatchCondition() {
    int index = matchConditions.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "matchConditions"));
    }
    return this.setNewMatchConditionLike(index, this.buildMatchCondition(index));
  }
  
  public RulesNested<A> editLastRule() {
    int index = rules.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "rules"));
    }
    return this.setNewRuleLike(index, this.buildRule(index));
  }
  
  public MatchConditionsNested<A> editMatchCondition(int index) {
    if (matchConditions.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "matchConditions"));
    }
    return this.setNewMatchConditionLike(index, this.buildMatchCondition(index));
  }
  
  public MatchConditionsNested<A> editMatchingMatchCondition(Predicate<MatchConditionBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < matchConditions.size();i++) {
      if (predicate.test(matchConditions.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "matchConditions"));
    }
    return this.setNewMatchConditionLike(index, this.buildMatchCondition(index));
  }
  
  public RulesNested<A> editMatchingRule(Predicate<RuleWithOperationsBuilder> predicate) {
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
  
  public NamespaceSelectorNested<A> editNamespaceSelector() {
    return this.withNewNamespaceSelectorLike(Optional.ofNullable(this.buildNamespaceSelector()).orElse(null));
  }
  
  public ObjectSelectorNested<A> editObjectSelector() {
    return this.withNewObjectSelectorLike(Optional.ofNullable(this.buildObjectSelector()).orElse(null));
  }
  
  public ClientConfigNested<A> editOrNewClientConfig() {
    return this.withNewClientConfigLike(Optional.ofNullable(this.buildClientConfig()).orElse(new WebhookClientConfigBuilder().build()));
  }
  
  public ClientConfigNested<A> editOrNewClientConfigLike(WebhookClientConfig item) {
    return this.withNewClientConfigLike(Optional.ofNullable(this.buildClientConfig()).orElse(item));
  }
  
  public NamespaceSelectorNested<A> editOrNewNamespaceSelector() {
    return this.withNewNamespaceSelectorLike(Optional.ofNullable(this.buildNamespaceSelector()).orElse(new LabelSelectorBuilder().build()));
  }
  
  public NamespaceSelectorNested<A> editOrNewNamespaceSelectorLike(LabelSelector item) {
    return this.withNewNamespaceSelectorLike(Optional.ofNullable(this.buildNamespaceSelector()).orElse(item));
  }
  
  public ObjectSelectorNested<A> editOrNewObjectSelector() {
    return this.withNewObjectSelectorLike(Optional.ofNullable(this.buildObjectSelector()).orElse(new LabelSelectorBuilder().build()));
  }
  
  public ObjectSelectorNested<A> editOrNewObjectSelectorLike(LabelSelector item) {
    return this.withNewObjectSelectorLike(Optional.ofNullable(this.buildObjectSelector()).orElse(item));
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
    MutatingWebhookFluent that = (MutatingWebhookFluent) o;
    if (!(Objects.equals(admissionReviewVersions, that.admissionReviewVersions))) {
      return false;
    }
    if (!(Objects.equals(clientConfig, that.clientConfig))) {
      return false;
    }
    if (!(Objects.equals(failurePolicy, that.failurePolicy))) {
      return false;
    }
    if (!(Objects.equals(matchConditions, that.matchConditions))) {
      return false;
    }
    if (!(Objects.equals(matchPolicy, that.matchPolicy))) {
      return false;
    }
    if (!(Objects.equals(name, that.name))) {
      return false;
    }
    if (!(Objects.equals(namespaceSelector, that.namespaceSelector))) {
      return false;
    }
    if (!(Objects.equals(objectSelector, that.objectSelector))) {
      return false;
    }
    if (!(Objects.equals(reinvocationPolicy, that.reinvocationPolicy))) {
      return false;
    }
    if (!(Objects.equals(rules, that.rules))) {
      return false;
    }
    if (!(Objects.equals(sideEffects, that.sideEffects))) {
      return false;
    }
    if (!(Objects.equals(timeoutSeconds, that.timeoutSeconds))) {
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
  
  public String getAdmissionReviewVersion(int index) {
    return this.admissionReviewVersions.get(index);
  }
  
  public List<String> getAdmissionReviewVersions() {
    return this.admissionReviewVersions;
  }
  
  public String getFailurePolicy() {
    return this.failurePolicy;
  }
  
  public String getFirstAdmissionReviewVersion() {
    return this.admissionReviewVersions.get(0);
  }
  
  public String getLastAdmissionReviewVersion() {
    return this.admissionReviewVersions.get(admissionReviewVersions.size() - 1);
  }
  
  public String getMatchPolicy() {
    return this.matchPolicy;
  }
  
  public String getMatchingAdmissionReviewVersion(Predicate<String> predicate) {
      for (String item : admissionReviewVersions) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public String getName() {
    return this.name;
  }
  
  public String getReinvocationPolicy() {
    return this.reinvocationPolicy;
  }
  
  public String getSideEffects() {
    return this.sideEffects;
  }
  
  public Integer getTimeoutSeconds() {
    return this.timeoutSeconds;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasAdmissionReviewVersions() {
    return this.admissionReviewVersions != null && !(this.admissionReviewVersions.isEmpty());
  }
  
  public boolean hasClientConfig() {
    return this.clientConfig != null;
  }
  
  public boolean hasFailurePolicy() {
    return this.failurePolicy != null;
  }
  
  public boolean hasMatchConditions() {
    return this.matchConditions != null && !(this.matchConditions.isEmpty());
  }
  
  public boolean hasMatchPolicy() {
    return this.matchPolicy != null;
  }
  
  public boolean hasMatchingAdmissionReviewVersion(Predicate<String> predicate) {
      for (String item : admissionReviewVersions) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingMatchCondition(Predicate<MatchConditionBuilder> predicate) {
      for (MatchConditionBuilder item : matchConditions) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingRule(Predicate<RuleWithOperationsBuilder> predicate) {
      for (RuleWithOperationsBuilder item : rules) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasName() {
    return this.name != null;
  }
  
  public boolean hasNamespaceSelector() {
    return this.namespaceSelector != null;
  }
  
  public boolean hasObjectSelector() {
    return this.objectSelector != null;
  }
  
  public boolean hasReinvocationPolicy() {
    return this.reinvocationPolicy != null;
  }
  
  public boolean hasRules() {
    return this.rules != null && !(this.rules.isEmpty());
  }
  
  public boolean hasSideEffects() {
    return this.sideEffects != null;
  }
  
  public boolean hasTimeoutSeconds() {
    return this.timeoutSeconds != null;
  }
  
  public int hashCode() {
    return Objects.hash(admissionReviewVersions, clientConfig, failurePolicy, matchConditions, matchPolicy, name, namespaceSelector, objectSelector, reinvocationPolicy, rules, sideEffects, timeoutSeconds, additionalProperties);
  }
  
  public A removeAllFromAdmissionReviewVersions(Collection<String> items) {
    if (this.admissionReviewVersions == null) {
      return (A) this;
    }
    for (String item : items) {
      this.admissionReviewVersions.remove(item);
    }
    return (A) this;
  }
  
  public A removeAllFromMatchConditions(Collection<MatchCondition> items) {
    if (this.matchConditions == null) {
      return (A) this;
    }
    for (MatchCondition item : items) {
        MatchConditionBuilder builder = new MatchConditionBuilder(item);
        _visitables.get("matchConditions").remove(builder);
        this.matchConditions.remove(builder);
    }
    return (A) this;
  }
  
  public A removeAllFromRules(Collection<RuleWithOperations> items) {
    if (this.rules == null) {
      return (A) this;
    }
    for (RuleWithOperations item : items) {
        RuleWithOperationsBuilder builder = new RuleWithOperationsBuilder(item);
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
  
  public A removeFromAdmissionReviewVersions(String... items) {
    if (this.admissionReviewVersions == null) {
      return (A) this;
    }
    for (String item : items) {
      this.admissionReviewVersions.remove(item);
    }
    return (A) this;
  }
  
  public A removeFromMatchConditions(MatchCondition... items) {
    if (this.matchConditions == null) {
      return (A) this;
    }
    for (MatchCondition item : items) {
        MatchConditionBuilder builder = new MatchConditionBuilder(item);
        _visitables.get("matchConditions").remove(builder);
        this.matchConditions.remove(builder);
    }
    return (A) this;
  }
  
  public A removeFromRules(RuleWithOperations... items) {
    if (this.rules == null) {
      return (A) this;
    }
    for (RuleWithOperations item : items) {
        RuleWithOperationsBuilder builder = new RuleWithOperationsBuilder(item);
        _visitables.get("rules").remove(builder);
        this.rules.remove(builder);
    }
    return (A) this;
  }
  
  public A removeMatchingFromMatchConditions(Predicate<MatchConditionBuilder> predicate) {
    if (matchConditions == null) {
      return (A) this;
    }
    Iterator<MatchConditionBuilder> each = matchConditions.iterator();
    List visitables = _visitables.get("matchConditions");
    while (each.hasNext()) {
        MatchConditionBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public A removeMatchingFromRules(Predicate<RuleWithOperationsBuilder> predicate) {
    if (rules == null) {
      return (A) this;
    }
    Iterator<RuleWithOperationsBuilder> each = rules.iterator();
    List visitables = _visitables.get("rules");
    while (each.hasNext()) {
        RuleWithOperationsBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public MatchConditionsNested<A> setNewMatchConditionLike(int index,MatchCondition item) {
    return new MatchConditionsNested(index, item);
  }
  
  public RulesNested<A> setNewRuleLike(int index,RuleWithOperations item) {
    return new RulesNested(index, item);
  }
  
  public A setToAdmissionReviewVersions(int index,String item) {
    if (this.admissionReviewVersions == null) {
      this.admissionReviewVersions = new ArrayList();
    }
    this.admissionReviewVersions.set(index, item);
    return (A) this;
  }
  
  public A setToMatchConditions(int index,MatchCondition item) {
    if (this.matchConditions == null) {
      this.matchConditions = new ArrayList();
    }
    MatchConditionBuilder builder = new MatchConditionBuilder(item);
    if (index < 0 || index >= matchConditions.size()) {
        _visitables.get("matchConditions").add(builder);
        matchConditions.add(builder);
    } else {
        _visitables.get("matchConditions").add(builder);
        matchConditions.set(index, builder);
    }
    return (A) this;
  }
  
  public A setToRules(int index,RuleWithOperations item) {
    if (this.rules == null) {
      this.rules = new ArrayList();
    }
    RuleWithOperationsBuilder builder = new RuleWithOperationsBuilder(item);
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
    if (!(admissionReviewVersions == null) && !(admissionReviewVersions.isEmpty())) {
        sb.append("admissionReviewVersions:");
        sb.append(admissionReviewVersions);
        sb.append(",");
    }
    if (!(clientConfig == null)) {
        sb.append("clientConfig:");
        sb.append(clientConfig);
        sb.append(",");
    }
    if (!(failurePolicy == null)) {
        sb.append("failurePolicy:");
        sb.append(failurePolicy);
        sb.append(",");
    }
    if (!(matchConditions == null) && !(matchConditions.isEmpty())) {
        sb.append("matchConditions:");
        sb.append(matchConditions);
        sb.append(",");
    }
    if (!(matchPolicy == null)) {
        sb.append("matchPolicy:");
        sb.append(matchPolicy);
        sb.append(",");
    }
    if (!(name == null)) {
        sb.append("name:");
        sb.append(name);
        sb.append(",");
    }
    if (!(namespaceSelector == null)) {
        sb.append("namespaceSelector:");
        sb.append(namespaceSelector);
        sb.append(",");
    }
    if (!(objectSelector == null)) {
        sb.append("objectSelector:");
        sb.append(objectSelector);
        sb.append(",");
    }
    if (!(reinvocationPolicy == null)) {
        sb.append("reinvocationPolicy:");
        sb.append(reinvocationPolicy);
        sb.append(",");
    }
    if (!(rules == null) && !(rules.isEmpty())) {
        sb.append("rules:");
        sb.append(rules);
        sb.append(",");
    }
    if (!(sideEffects == null)) {
        sb.append("sideEffects:");
        sb.append(sideEffects);
        sb.append(",");
    }
    if (!(timeoutSeconds == null)) {
        sb.append("timeoutSeconds:");
        sb.append(timeoutSeconds);
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
  
  public A withAdmissionReviewVersions(List<String> admissionReviewVersions) {
    if (admissionReviewVersions != null) {
        this.admissionReviewVersions = new ArrayList();
        for (String item : admissionReviewVersions) {
          this.addToAdmissionReviewVersions(item);
        }
    } else {
      this.admissionReviewVersions = null;
    }
    return (A) this;
  }
  
  public A withAdmissionReviewVersions(String... admissionReviewVersions) {
    if (this.admissionReviewVersions != null) {
        this.admissionReviewVersions.clear();
        _visitables.remove("admissionReviewVersions");
    }
    if (admissionReviewVersions != null) {
      for (String item : admissionReviewVersions) {
        this.addToAdmissionReviewVersions(item);
      }
    }
    return (A) this;
  }
  
  public A withClientConfig(WebhookClientConfig clientConfig) {
    this._visitables.remove("clientConfig");
    if (clientConfig != null) {
        this.clientConfig = new WebhookClientConfigBuilder(clientConfig);
        this._visitables.get("clientConfig").add(this.clientConfig);
    } else {
        this.clientConfig = null;
        this._visitables.get("clientConfig").remove(this.clientConfig);
    }
    return (A) this;
  }
  
  public A withFailurePolicy(String failurePolicy) {
    this.failurePolicy = failurePolicy;
    return (A) this;
  }
  
  public A withMatchConditions(List<MatchCondition> matchConditions) {
    if (this.matchConditions != null) {
      this._visitables.get("matchConditions").clear();
    }
    if (matchConditions != null) {
        this.matchConditions = new ArrayList();
        for (MatchCondition item : matchConditions) {
          this.addToMatchConditions(item);
        }
    } else {
      this.matchConditions = null;
    }
    return (A) this;
  }
  
  public A withMatchConditions(MatchCondition... matchConditions) {
    if (this.matchConditions != null) {
        this.matchConditions.clear();
        _visitables.remove("matchConditions");
    }
    if (matchConditions != null) {
      for (MatchCondition item : matchConditions) {
        this.addToMatchConditions(item);
      }
    }
    return (A) this;
  }
  
  public A withMatchPolicy(String matchPolicy) {
    this.matchPolicy = matchPolicy;
    return (A) this;
  }
  
  public A withName(String name) {
    this.name = name;
    return (A) this;
  }
  
  public A withNamespaceSelector(LabelSelector namespaceSelector) {
    this._visitables.remove("namespaceSelector");
    if (namespaceSelector != null) {
        this.namespaceSelector = new LabelSelectorBuilder(namespaceSelector);
        this._visitables.get("namespaceSelector").add(this.namespaceSelector);
    } else {
        this.namespaceSelector = null;
        this._visitables.get("namespaceSelector").remove(this.namespaceSelector);
    }
    return (A) this;
  }
  
  public ClientConfigNested<A> withNewClientConfig() {
    return new ClientConfigNested(null);
  }
  
  public ClientConfigNested<A> withNewClientConfigLike(WebhookClientConfig item) {
    return new ClientConfigNested(item);
  }
  
  public NamespaceSelectorNested<A> withNewNamespaceSelector() {
    return new NamespaceSelectorNested(null);
  }
  
  public NamespaceSelectorNested<A> withNewNamespaceSelectorLike(LabelSelector item) {
    return new NamespaceSelectorNested(item);
  }
  
  public ObjectSelectorNested<A> withNewObjectSelector() {
    return new ObjectSelectorNested(null);
  }
  
  public ObjectSelectorNested<A> withNewObjectSelectorLike(LabelSelector item) {
    return new ObjectSelectorNested(item);
  }
  
  public A withObjectSelector(LabelSelector objectSelector) {
    this._visitables.remove("objectSelector");
    if (objectSelector != null) {
        this.objectSelector = new LabelSelectorBuilder(objectSelector);
        this._visitables.get("objectSelector").add(this.objectSelector);
    } else {
        this.objectSelector = null;
        this._visitables.get("objectSelector").remove(this.objectSelector);
    }
    return (A) this;
  }
  
  public A withReinvocationPolicy(String reinvocationPolicy) {
    this.reinvocationPolicy = reinvocationPolicy;
    return (A) this;
  }
  
  public A withRules(List<RuleWithOperations> rules) {
    if (this.rules != null) {
      this._visitables.get("rules").clear();
    }
    if (rules != null) {
        this.rules = new ArrayList();
        for (RuleWithOperations item : rules) {
          this.addToRules(item);
        }
    } else {
      this.rules = null;
    }
    return (A) this;
  }
  
  public A withRules(RuleWithOperations... rules) {
    if (this.rules != null) {
        this.rules.clear();
        _visitables.remove("rules");
    }
    if (rules != null) {
      for (RuleWithOperations item : rules) {
        this.addToRules(item);
      }
    }
    return (A) this;
  }
  
  public A withSideEffects(String sideEffects) {
    this.sideEffects = sideEffects;
    return (A) this;
  }
  
  public A withTimeoutSeconds(Integer timeoutSeconds) {
    this.timeoutSeconds = timeoutSeconds;
    return (A) this;
  }
  public class ClientConfigNested<N> extends WebhookClientConfigFluent<ClientConfigNested<N>> implements Nested<N>{
  
    WebhookClientConfigBuilder builder;
  
    ClientConfigNested(WebhookClientConfig item) {
      this.builder = new WebhookClientConfigBuilder(this, item);
    }
  
    public N and() {
      return (N) MutatingWebhookFluent.this.withClientConfig(builder.build());
    }
    
    public N endClientConfig() {
      return and();
    }
    
  }
  public class MatchConditionsNested<N> extends MatchConditionFluent<MatchConditionsNested<N>> implements Nested<N>{
  
    MatchConditionBuilder builder;
    int index;
  
    MatchConditionsNested(int index,MatchCondition item) {
      this.index = index;
      this.builder = new MatchConditionBuilder(this, item);
    }
  
    public N and() {
      return (N) MutatingWebhookFluent.this.setToMatchConditions(index, builder.build());
    }
    
    public N endMatchCondition() {
      return and();
    }
    
  }
  public class NamespaceSelectorNested<N> extends LabelSelectorFluent<NamespaceSelectorNested<N>> implements Nested<N>{
  
    LabelSelectorBuilder builder;
  
    NamespaceSelectorNested(LabelSelector item) {
      this.builder = new LabelSelectorBuilder(this, item);
    }
  
    public N and() {
      return (N) MutatingWebhookFluent.this.withNamespaceSelector(builder.build());
    }
    
    public N endNamespaceSelector() {
      return and();
    }
    
  }
  public class ObjectSelectorNested<N> extends LabelSelectorFluent<ObjectSelectorNested<N>> implements Nested<N>{
  
    LabelSelectorBuilder builder;
  
    ObjectSelectorNested(LabelSelector item) {
      this.builder = new LabelSelectorBuilder(this, item);
    }
  
    public N and() {
      return (N) MutatingWebhookFluent.this.withObjectSelector(builder.build());
    }
    
    public N endObjectSelector() {
      return and();
    }
    
  }
  public class RulesNested<N> extends RuleWithOperationsFluent<RulesNested<N>> implements Nested<N>{
  
    RuleWithOperationsBuilder builder;
    int index;
  
    RulesNested(int index,RuleWithOperations item) {
      this.index = index;
      this.builder = new RuleWithOperationsBuilder(this, item);
    }
  
    public N and() {
      return (N) MutatingWebhookFluent.this.setToRules(index, builder.build());
    }
    
    public N endRule() {
      return and();
    }
    
  }
}