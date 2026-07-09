package io.fabric8.kubernetes.api.model.authorization.v1beta1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import java.lang.Boolean;
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
public class SubjectRulesReviewStatusFluent<A extends io.fabric8.kubernetes.api.model.authorization.v1beta1.SubjectRulesReviewStatusFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String evaluationError;
  private Boolean incomplete;
  private ArrayList<NonResourceRuleBuilder> nonResourceRules = new ArrayList<NonResourceRuleBuilder>();
  private ArrayList<ResourceRuleBuilder> resourceRules = new ArrayList<ResourceRuleBuilder>();

  public SubjectRulesReviewStatusFluent() {
  }
  
  public SubjectRulesReviewStatusFluent(SubjectRulesReviewStatus instance) {
    this.copyInstance(instance);
  }

  public A addAllToNonResourceRules(Collection<NonResourceRule> items) {
    if (this.nonResourceRules == null) {
      this.nonResourceRules = new ArrayList();
    }
    for (NonResourceRule item : items) {
        NonResourceRuleBuilder builder = new NonResourceRuleBuilder(item);
        _visitables.get("nonResourceRules").add(builder);
        this.nonResourceRules.add(builder);
    }
    return (A) this;
  }
  
  public A addAllToResourceRules(Collection<ResourceRule> items) {
    if (this.resourceRules == null) {
      this.resourceRules = new ArrayList();
    }
    for (ResourceRule item : items) {
        ResourceRuleBuilder builder = new ResourceRuleBuilder(item);
        _visitables.get("resourceRules").add(builder);
        this.resourceRules.add(builder);
    }
    return (A) this;
  }
  
  public NonResourceRulesNested<A> addNewNonResourceRule() {
    return new NonResourceRulesNested(-1, null);
  }
  
  public NonResourceRulesNested<A> addNewNonResourceRuleLike(NonResourceRule item) {
    return new NonResourceRulesNested(-1, item);
  }
  
  public ResourceRulesNested<A> addNewResourceRule() {
    return new ResourceRulesNested(-1, null);
  }
  
  public ResourceRulesNested<A> addNewResourceRuleLike(ResourceRule item) {
    return new ResourceRulesNested(-1, item);
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
  
  public A addToNonResourceRules(NonResourceRule... items) {
    if (this.nonResourceRules == null) {
      this.nonResourceRules = new ArrayList();
    }
    for (NonResourceRule item : items) {
        NonResourceRuleBuilder builder = new NonResourceRuleBuilder(item);
        _visitables.get("nonResourceRules").add(builder);
        this.nonResourceRules.add(builder);
    }
    return (A) this;
  }
  
  public A addToNonResourceRules(int index,NonResourceRule item) {
    if (this.nonResourceRules == null) {
      this.nonResourceRules = new ArrayList();
    }
    NonResourceRuleBuilder builder = new NonResourceRuleBuilder(item);
    if (index < 0 || index >= nonResourceRules.size()) {
        _visitables.get("nonResourceRules").add(builder);
        nonResourceRules.add(builder);
    } else {
        _visitables.get("nonResourceRules").add(builder);
        nonResourceRules.add(index, builder);
    }
    return (A) this;
  }
  
  public A addToResourceRules(ResourceRule... items) {
    if (this.resourceRules == null) {
      this.resourceRules = new ArrayList();
    }
    for (ResourceRule item : items) {
        ResourceRuleBuilder builder = new ResourceRuleBuilder(item);
        _visitables.get("resourceRules").add(builder);
        this.resourceRules.add(builder);
    }
    return (A) this;
  }
  
  public A addToResourceRules(int index,ResourceRule item) {
    if (this.resourceRules == null) {
      this.resourceRules = new ArrayList();
    }
    ResourceRuleBuilder builder = new ResourceRuleBuilder(item);
    if (index < 0 || index >= resourceRules.size()) {
        _visitables.get("resourceRules").add(builder);
        resourceRules.add(builder);
    } else {
        _visitables.get("resourceRules").add(builder);
        resourceRules.add(index, builder);
    }
    return (A) this;
  }
  
  public NonResourceRule buildFirstNonResourceRule() {
    return this.nonResourceRules.get(0).build();
  }
  
  public ResourceRule buildFirstResourceRule() {
    return this.resourceRules.get(0).build();
  }
  
  public NonResourceRule buildLastNonResourceRule() {
    return this.nonResourceRules.get(nonResourceRules.size() - 1).build();
  }
  
  public ResourceRule buildLastResourceRule() {
    return this.resourceRules.get(resourceRules.size() - 1).build();
  }
  
  public NonResourceRule buildMatchingNonResourceRule(Predicate<NonResourceRuleBuilder> predicate) {
      for (NonResourceRuleBuilder item : nonResourceRules) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public ResourceRule buildMatchingResourceRule(Predicate<ResourceRuleBuilder> predicate) {
      for (ResourceRuleBuilder item : resourceRules) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public NonResourceRule buildNonResourceRule(int index) {
    return this.nonResourceRules.get(index).build();
  }
  
  public List<NonResourceRule> buildNonResourceRules() {
    return this.nonResourceRules != null ? build(nonResourceRules) : null;
  }
  
  public ResourceRule buildResourceRule(int index) {
    return this.resourceRules.get(index).build();
  }
  
  public List<ResourceRule> buildResourceRules() {
    return this.resourceRules != null ? build(resourceRules) : null;
  }
  
  protected void copyInstance(SubjectRulesReviewStatus instance) {
    instance = instance != null ? instance : new SubjectRulesReviewStatus();
    if (instance != null) {
        this.withEvaluationError(instance.getEvaluationError());
        this.withIncomplete(instance.getIncomplete());
        this.withNonResourceRules(instance.getNonResourceRules());
        this.withResourceRules(instance.getResourceRules());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public NonResourceRulesNested<A> editFirstNonResourceRule() {
    if (nonResourceRules.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "nonResourceRules"));
    }
    return this.setNewNonResourceRuleLike(0, this.buildNonResourceRule(0));
  }
  
  public ResourceRulesNested<A> editFirstResourceRule() {
    if (resourceRules.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "resourceRules"));
    }
    return this.setNewResourceRuleLike(0, this.buildResourceRule(0));
  }
  
  public NonResourceRulesNested<A> editLastNonResourceRule() {
    int index = nonResourceRules.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "nonResourceRules"));
    }
    return this.setNewNonResourceRuleLike(index, this.buildNonResourceRule(index));
  }
  
  public ResourceRulesNested<A> editLastResourceRule() {
    int index = resourceRules.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "resourceRules"));
    }
    return this.setNewResourceRuleLike(index, this.buildResourceRule(index));
  }
  
  public NonResourceRulesNested<A> editMatchingNonResourceRule(Predicate<NonResourceRuleBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < nonResourceRules.size();i++) {
      if (predicate.test(nonResourceRules.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "nonResourceRules"));
    }
    return this.setNewNonResourceRuleLike(index, this.buildNonResourceRule(index));
  }
  
  public ResourceRulesNested<A> editMatchingResourceRule(Predicate<ResourceRuleBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < resourceRules.size();i++) {
      if (predicate.test(resourceRules.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "resourceRules"));
    }
    return this.setNewResourceRuleLike(index, this.buildResourceRule(index));
  }
  
  public NonResourceRulesNested<A> editNonResourceRule(int index) {
    if (nonResourceRules.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "nonResourceRules"));
    }
    return this.setNewNonResourceRuleLike(index, this.buildNonResourceRule(index));
  }
  
  public ResourceRulesNested<A> editResourceRule(int index) {
    if (resourceRules.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "resourceRules"));
    }
    return this.setNewResourceRuleLike(index, this.buildResourceRule(index));
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
    SubjectRulesReviewStatusFluent that = (SubjectRulesReviewStatusFluent) o;
    if (!(Objects.equals(evaluationError, that.evaluationError))) {
      return false;
    }
    if (!(Objects.equals(incomplete, that.incomplete))) {
      return false;
    }
    if (!(Objects.equals(nonResourceRules, that.nonResourceRules))) {
      return false;
    }
    if (!(Objects.equals(resourceRules, that.resourceRules))) {
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
  
  public String getEvaluationError() {
    return this.evaluationError;
  }
  
  public Boolean getIncomplete() {
    return this.incomplete;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasEvaluationError() {
    return this.evaluationError != null;
  }
  
  public boolean hasIncomplete() {
    return this.incomplete != null;
  }
  
  public boolean hasMatchingNonResourceRule(Predicate<NonResourceRuleBuilder> predicate) {
      for (NonResourceRuleBuilder item : nonResourceRules) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingResourceRule(Predicate<ResourceRuleBuilder> predicate) {
      for (ResourceRuleBuilder item : resourceRules) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasNonResourceRules() {
    return this.nonResourceRules != null && !(this.nonResourceRules.isEmpty());
  }
  
  public boolean hasResourceRules() {
    return this.resourceRules != null && !(this.resourceRules.isEmpty());
  }
  
  public int hashCode() {
    return Objects.hash(evaluationError, incomplete, nonResourceRules, resourceRules, additionalProperties);
  }
  
  public A removeAllFromNonResourceRules(Collection<NonResourceRule> items) {
    if (this.nonResourceRules == null) {
      return (A) this;
    }
    for (NonResourceRule item : items) {
        NonResourceRuleBuilder builder = new NonResourceRuleBuilder(item);
        _visitables.get("nonResourceRules").remove(builder);
        this.nonResourceRules.remove(builder);
    }
    return (A) this;
  }
  
  public A removeAllFromResourceRules(Collection<ResourceRule> items) {
    if (this.resourceRules == null) {
      return (A) this;
    }
    for (ResourceRule item : items) {
        ResourceRuleBuilder builder = new ResourceRuleBuilder(item);
        _visitables.get("resourceRules").remove(builder);
        this.resourceRules.remove(builder);
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
  
  public A removeFromNonResourceRules(NonResourceRule... items) {
    if (this.nonResourceRules == null) {
      return (A) this;
    }
    for (NonResourceRule item : items) {
        NonResourceRuleBuilder builder = new NonResourceRuleBuilder(item);
        _visitables.get("nonResourceRules").remove(builder);
        this.nonResourceRules.remove(builder);
    }
    return (A) this;
  }
  
  public A removeFromResourceRules(ResourceRule... items) {
    if (this.resourceRules == null) {
      return (A) this;
    }
    for (ResourceRule item : items) {
        ResourceRuleBuilder builder = new ResourceRuleBuilder(item);
        _visitables.get("resourceRules").remove(builder);
        this.resourceRules.remove(builder);
    }
    return (A) this;
  }
  
  public A removeMatchingFromNonResourceRules(Predicate<NonResourceRuleBuilder> predicate) {
    if (nonResourceRules == null) {
      return (A) this;
    }
    Iterator<NonResourceRuleBuilder> each = nonResourceRules.iterator();
    List visitables = _visitables.get("nonResourceRules");
    while (each.hasNext()) {
        NonResourceRuleBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public A removeMatchingFromResourceRules(Predicate<ResourceRuleBuilder> predicate) {
    if (resourceRules == null) {
      return (A) this;
    }
    Iterator<ResourceRuleBuilder> each = resourceRules.iterator();
    List visitables = _visitables.get("resourceRules");
    while (each.hasNext()) {
        ResourceRuleBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public NonResourceRulesNested<A> setNewNonResourceRuleLike(int index,NonResourceRule item) {
    return new NonResourceRulesNested(index, item);
  }
  
  public ResourceRulesNested<A> setNewResourceRuleLike(int index,ResourceRule item) {
    return new ResourceRulesNested(index, item);
  }
  
  public A setToNonResourceRules(int index,NonResourceRule item) {
    if (this.nonResourceRules == null) {
      this.nonResourceRules = new ArrayList();
    }
    NonResourceRuleBuilder builder = new NonResourceRuleBuilder(item);
    if (index < 0 || index >= nonResourceRules.size()) {
        _visitables.get("nonResourceRules").add(builder);
        nonResourceRules.add(builder);
    } else {
        _visitables.get("nonResourceRules").add(builder);
        nonResourceRules.set(index, builder);
    }
    return (A) this;
  }
  
  public A setToResourceRules(int index,ResourceRule item) {
    if (this.resourceRules == null) {
      this.resourceRules = new ArrayList();
    }
    ResourceRuleBuilder builder = new ResourceRuleBuilder(item);
    if (index < 0 || index >= resourceRules.size()) {
        _visitables.get("resourceRules").add(builder);
        resourceRules.add(builder);
    } else {
        _visitables.get("resourceRules").add(builder);
        resourceRules.set(index, builder);
    }
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(evaluationError == null)) {
        sb.append("evaluationError:");
        sb.append(evaluationError);
        sb.append(",");
    }
    if (!(incomplete == null)) {
        sb.append("incomplete:");
        sb.append(incomplete);
        sb.append(",");
    }
    if (!(nonResourceRules == null) && !(nonResourceRules.isEmpty())) {
        sb.append("nonResourceRules:");
        sb.append(nonResourceRules);
        sb.append(",");
    }
    if (!(resourceRules == null) && !(resourceRules.isEmpty())) {
        sb.append("resourceRules:");
        sb.append(resourceRules);
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
  
  public A withEvaluationError(String evaluationError) {
    this.evaluationError = evaluationError;
    return (A) this;
  }
  
  public A withIncomplete() {
    return withIncomplete(true);
  }
  
  public A withIncomplete(Boolean incomplete) {
    this.incomplete = incomplete;
    return (A) this;
  }
  
  public A withNonResourceRules(List<NonResourceRule> nonResourceRules) {
    if (this.nonResourceRules != null) {
      this._visitables.get("nonResourceRules").clear();
    }
    if (nonResourceRules != null) {
        this.nonResourceRules = new ArrayList();
        for (NonResourceRule item : nonResourceRules) {
          this.addToNonResourceRules(item);
        }
    } else {
      this.nonResourceRules = null;
    }
    return (A) this;
  }
  
  public A withNonResourceRules(NonResourceRule... nonResourceRules) {
    if (this.nonResourceRules != null) {
        this.nonResourceRules.clear();
        _visitables.remove("nonResourceRules");
    }
    if (nonResourceRules != null) {
      for (NonResourceRule item : nonResourceRules) {
        this.addToNonResourceRules(item);
      }
    }
    return (A) this;
  }
  
  public A withResourceRules(List<ResourceRule> resourceRules) {
    if (this.resourceRules != null) {
      this._visitables.get("resourceRules").clear();
    }
    if (resourceRules != null) {
        this.resourceRules = new ArrayList();
        for (ResourceRule item : resourceRules) {
          this.addToResourceRules(item);
        }
    } else {
      this.resourceRules = null;
    }
    return (A) this;
  }
  
  public A withResourceRules(ResourceRule... resourceRules) {
    if (this.resourceRules != null) {
        this.resourceRules.clear();
        _visitables.remove("resourceRules");
    }
    if (resourceRules != null) {
      for (ResourceRule item : resourceRules) {
        this.addToResourceRules(item);
      }
    }
    return (A) this;
  }
  public class NonResourceRulesNested<N> extends NonResourceRuleFluent<NonResourceRulesNested<N>> implements Nested<N>{
  
    NonResourceRuleBuilder builder;
    int index;
  
    NonResourceRulesNested(int index,NonResourceRule item) {
      this.index = index;
      this.builder = new NonResourceRuleBuilder(this, item);
    }
  
    public N and() {
      return (N) SubjectRulesReviewStatusFluent.this.setToNonResourceRules(index, builder.build());
    }
    
    public N endNonResourceRule() {
      return and();
    }
    
  }
  public class ResourceRulesNested<N> extends ResourceRuleFluent<ResourceRulesNested<N>> implements Nested<N>{
  
    ResourceRuleBuilder builder;
    int index;
  
    ResourceRulesNested(int index,ResourceRule item) {
      this.index = index;
      this.builder = new ResourceRuleBuilder(this, item);
    }
  
    public N and() {
      return (N) SubjectRulesReviewStatusFluent.this.setToResourceRules(index, builder.build());
    }
    
    public N endResourceRule() {
      return and();
    }
    
  }
}