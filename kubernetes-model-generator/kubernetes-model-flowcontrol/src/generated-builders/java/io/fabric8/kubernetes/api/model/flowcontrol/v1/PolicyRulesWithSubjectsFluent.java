package io.fabric8.kubernetes.api.model.flowcontrol.v1;

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
public class PolicyRulesWithSubjectsFluent<A extends io.fabric8.kubernetes.api.model.flowcontrol.v1.PolicyRulesWithSubjectsFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private ArrayList<NonResourcePolicyRuleBuilder> nonResourceRules = new ArrayList<NonResourcePolicyRuleBuilder>();
  private ArrayList<ResourcePolicyRuleBuilder> resourceRules = new ArrayList<ResourcePolicyRuleBuilder>();
  private ArrayList<SubjectBuilder> subjects = new ArrayList<SubjectBuilder>();

  public PolicyRulesWithSubjectsFluent() {
  }
  
  public PolicyRulesWithSubjectsFluent(PolicyRulesWithSubjects instance) {
    this.copyInstance(instance);
  }

  public A addAllToNonResourceRules(Collection<NonResourcePolicyRule> items) {
    if (this.nonResourceRules == null) {
      this.nonResourceRules = new ArrayList();
    }
    for (NonResourcePolicyRule item : items) {
        NonResourcePolicyRuleBuilder builder = new NonResourcePolicyRuleBuilder(item);
        _visitables.get("nonResourceRules").add(builder);
        this.nonResourceRules.add(builder);
    }
    return (A) this;
  }
  
  public A addAllToResourceRules(Collection<ResourcePolicyRule> items) {
    if (this.resourceRules == null) {
      this.resourceRules = new ArrayList();
    }
    for (ResourcePolicyRule item : items) {
        ResourcePolicyRuleBuilder builder = new ResourcePolicyRuleBuilder(item);
        _visitables.get("resourceRules").add(builder);
        this.resourceRules.add(builder);
    }
    return (A) this;
  }
  
  public A addAllToSubjects(Collection<Subject> items) {
    if (this.subjects == null) {
      this.subjects = new ArrayList();
    }
    for (Subject item : items) {
        SubjectBuilder builder = new SubjectBuilder(item);
        _visitables.get("subjects").add(builder);
        this.subjects.add(builder);
    }
    return (A) this;
  }
  
  public NonResourceRulesNested<A> addNewNonResourceRule() {
    return new NonResourceRulesNested(-1, null);
  }
  
  public NonResourceRulesNested<A> addNewNonResourceRuleLike(NonResourcePolicyRule item) {
    return new NonResourceRulesNested(-1, item);
  }
  
  public ResourceRulesNested<A> addNewResourceRule() {
    return new ResourceRulesNested(-1, null);
  }
  
  public ResourceRulesNested<A> addNewResourceRuleLike(ResourcePolicyRule item) {
    return new ResourceRulesNested(-1, item);
  }
  
  public SubjectsNested<A> addNewSubject() {
    return new SubjectsNested(-1, null);
  }
  
  public SubjectsNested<A> addNewSubjectLike(Subject item) {
    return new SubjectsNested(-1, item);
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
  
  public A addToNonResourceRules(NonResourcePolicyRule... items) {
    if (this.nonResourceRules == null) {
      this.nonResourceRules = new ArrayList();
    }
    for (NonResourcePolicyRule item : items) {
        NonResourcePolicyRuleBuilder builder = new NonResourcePolicyRuleBuilder(item);
        _visitables.get("nonResourceRules").add(builder);
        this.nonResourceRules.add(builder);
    }
    return (A) this;
  }
  
  public A addToNonResourceRules(int index,NonResourcePolicyRule item) {
    if (this.nonResourceRules == null) {
      this.nonResourceRules = new ArrayList();
    }
    NonResourcePolicyRuleBuilder builder = new NonResourcePolicyRuleBuilder(item);
    if (index < 0 || index >= nonResourceRules.size()) {
        _visitables.get("nonResourceRules").add(builder);
        nonResourceRules.add(builder);
    } else {
        _visitables.get("nonResourceRules").add(builder);
        nonResourceRules.add(index, builder);
    }
    return (A) this;
  }
  
  public A addToResourceRules(ResourcePolicyRule... items) {
    if (this.resourceRules == null) {
      this.resourceRules = new ArrayList();
    }
    for (ResourcePolicyRule item : items) {
        ResourcePolicyRuleBuilder builder = new ResourcePolicyRuleBuilder(item);
        _visitables.get("resourceRules").add(builder);
        this.resourceRules.add(builder);
    }
    return (A) this;
  }
  
  public A addToResourceRules(int index,ResourcePolicyRule item) {
    if (this.resourceRules == null) {
      this.resourceRules = new ArrayList();
    }
    ResourcePolicyRuleBuilder builder = new ResourcePolicyRuleBuilder(item);
    if (index < 0 || index >= resourceRules.size()) {
        _visitables.get("resourceRules").add(builder);
        resourceRules.add(builder);
    } else {
        _visitables.get("resourceRules").add(builder);
        resourceRules.add(index, builder);
    }
    return (A) this;
  }
  
  public A addToSubjects(Subject... items) {
    if (this.subjects == null) {
      this.subjects = new ArrayList();
    }
    for (Subject item : items) {
        SubjectBuilder builder = new SubjectBuilder(item);
        _visitables.get("subjects").add(builder);
        this.subjects.add(builder);
    }
    return (A) this;
  }
  
  public A addToSubjects(int index,Subject item) {
    if (this.subjects == null) {
      this.subjects = new ArrayList();
    }
    SubjectBuilder builder = new SubjectBuilder(item);
    if (index < 0 || index >= subjects.size()) {
        _visitables.get("subjects").add(builder);
        subjects.add(builder);
    } else {
        _visitables.get("subjects").add(builder);
        subjects.add(index, builder);
    }
    return (A) this;
  }
  
  public NonResourcePolicyRule buildFirstNonResourceRule() {
    return this.nonResourceRules.get(0).build();
  }
  
  public ResourcePolicyRule buildFirstResourceRule() {
    return this.resourceRules.get(0).build();
  }
  
  public Subject buildFirstSubject() {
    return this.subjects.get(0).build();
  }
  
  public NonResourcePolicyRule buildLastNonResourceRule() {
    return this.nonResourceRules.get(nonResourceRules.size() - 1).build();
  }
  
  public ResourcePolicyRule buildLastResourceRule() {
    return this.resourceRules.get(resourceRules.size() - 1).build();
  }
  
  public Subject buildLastSubject() {
    return this.subjects.get(subjects.size() - 1).build();
  }
  
  public NonResourcePolicyRule buildMatchingNonResourceRule(Predicate<NonResourcePolicyRuleBuilder> predicate) {
      for (NonResourcePolicyRuleBuilder item : nonResourceRules) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public ResourcePolicyRule buildMatchingResourceRule(Predicate<ResourcePolicyRuleBuilder> predicate) {
      for (ResourcePolicyRuleBuilder item : resourceRules) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public Subject buildMatchingSubject(Predicate<SubjectBuilder> predicate) {
      for (SubjectBuilder item : subjects) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public NonResourcePolicyRule buildNonResourceRule(int index) {
    return this.nonResourceRules.get(index).build();
  }
  
  public List<NonResourcePolicyRule> buildNonResourceRules() {
    return this.nonResourceRules != null ? build(nonResourceRules) : null;
  }
  
  public ResourcePolicyRule buildResourceRule(int index) {
    return this.resourceRules.get(index).build();
  }
  
  public List<ResourcePolicyRule> buildResourceRules() {
    return this.resourceRules != null ? build(resourceRules) : null;
  }
  
  public Subject buildSubject(int index) {
    return this.subjects.get(index).build();
  }
  
  public List<Subject> buildSubjects() {
    return this.subjects != null ? build(subjects) : null;
  }
  
  protected void copyInstance(PolicyRulesWithSubjects instance) {
    instance = instance != null ? instance : new PolicyRulesWithSubjects();
    if (instance != null) {
        this.withNonResourceRules(instance.getNonResourceRules());
        this.withResourceRules(instance.getResourceRules());
        this.withSubjects(instance.getSubjects());
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
  
  public SubjectsNested<A> editFirstSubject() {
    if (subjects.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "subjects"));
    }
    return this.setNewSubjectLike(0, this.buildSubject(0));
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
  
  public SubjectsNested<A> editLastSubject() {
    int index = subjects.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "subjects"));
    }
    return this.setNewSubjectLike(index, this.buildSubject(index));
  }
  
  public NonResourceRulesNested<A> editMatchingNonResourceRule(Predicate<NonResourcePolicyRuleBuilder> predicate) {
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
  
  public ResourceRulesNested<A> editMatchingResourceRule(Predicate<ResourcePolicyRuleBuilder> predicate) {
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
  
  public SubjectsNested<A> editMatchingSubject(Predicate<SubjectBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < subjects.size();i++) {
      if (predicate.test(subjects.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "subjects"));
    }
    return this.setNewSubjectLike(index, this.buildSubject(index));
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
  
  public SubjectsNested<A> editSubject(int index) {
    if (subjects.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "subjects"));
    }
    return this.setNewSubjectLike(index, this.buildSubject(index));
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
    PolicyRulesWithSubjectsFluent that = (PolicyRulesWithSubjectsFluent) o;
    if (!(Objects.equals(nonResourceRules, that.nonResourceRules))) {
      return false;
    }
    if (!(Objects.equals(resourceRules, that.resourceRules))) {
      return false;
    }
    if (!(Objects.equals(subjects, that.subjects))) {
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
  
  public boolean hasMatchingNonResourceRule(Predicate<NonResourcePolicyRuleBuilder> predicate) {
      for (NonResourcePolicyRuleBuilder item : nonResourceRules) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingResourceRule(Predicate<ResourcePolicyRuleBuilder> predicate) {
      for (ResourcePolicyRuleBuilder item : resourceRules) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingSubject(Predicate<SubjectBuilder> predicate) {
      for (SubjectBuilder item : subjects) {
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
  
  public boolean hasSubjects() {
    return this.subjects != null && !(this.subjects.isEmpty());
  }
  
  public int hashCode() {
    return Objects.hash(nonResourceRules, resourceRules, subjects, additionalProperties);
  }
  
  public A removeAllFromNonResourceRules(Collection<NonResourcePolicyRule> items) {
    if (this.nonResourceRules == null) {
      return (A) this;
    }
    for (NonResourcePolicyRule item : items) {
        NonResourcePolicyRuleBuilder builder = new NonResourcePolicyRuleBuilder(item);
        _visitables.get("nonResourceRules").remove(builder);
        this.nonResourceRules.remove(builder);
    }
    return (A) this;
  }
  
  public A removeAllFromResourceRules(Collection<ResourcePolicyRule> items) {
    if (this.resourceRules == null) {
      return (A) this;
    }
    for (ResourcePolicyRule item : items) {
        ResourcePolicyRuleBuilder builder = new ResourcePolicyRuleBuilder(item);
        _visitables.get("resourceRules").remove(builder);
        this.resourceRules.remove(builder);
    }
    return (A) this;
  }
  
  public A removeAllFromSubjects(Collection<Subject> items) {
    if (this.subjects == null) {
      return (A) this;
    }
    for (Subject item : items) {
        SubjectBuilder builder = new SubjectBuilder(item);
        _visitables.get("subjects").remove(builder);
        this.subjects.remove(builder);
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
  
  public A removeFromNonResourceRules(NonResourcePolicyRule... items) {
    if (this.nonResourceRules == null) {
      return (A) this;
    }
    for (NonResourcePolicyRule item : items) {
        NonResourcePolicyRuleBuilder builder = new NonResourcePolicyRuleBuilder(item);
        _visitables.get("nonResourceRules").remove(builder);
        this.nonResourceRules.remove(builder);
    }
    return (A) this;
  }
  
  public A removeFromResourceRules(ResourcePolicyRule... items) {
    if (this.resourceRules == null) {
      return (A) this;
    }
    for (ResourcePolicyRule item : items) {
        ResourcePolicyRuleBuilder builder = new ResourcePolicyRuleBuilder(item);
        _visitables.get("resourceRules").remove(builder);
        this.resourceRules.remove(builder);
    }
    return (A) this;
  }
  
  public A removeFromSubjects(Subject... items) {
    if (this.subjects == null) {
      return (A) this;
    }
    for (Subject item : items) {
        SubjectBuilder builder = new SubjectBuilder(item);
        _visitables.get("subjects").remove(builder);
        this.subjects.remove(builder);
    }
    return (A) this;
  }
  
  public A removeMatchingFromNonResourceRules(Predicate<NonResourcePolicyRuleBuilder> predicate) {
    if (nonResourceRules == null) {
      return (A) this;
    }
    Iterator<NonResourcePolicyRuleBuilder> each = nonResourceRules.iterator();
    List visitables = _visitables.get("nonResourceRules");
    while (each.hasNext()) {
        NonResourcePolicyRuleBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public A removeMatchingFromResourceRules(Predicate<ResourcePolicyRuleBuilder> predicate) {
    if (resourceRules == null) {
      return (A) this;
    }
    Iterator<ResourcePolicyRuleBuilder> each = resourceRules.iterator();
    List visitables = _visitables.get("resourceRules");
    while (each.hasNext()) {
        ResourcePolicyRuleBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public A removeMatchingFromSubjects(Predicate<SubjectBuilder> predicate) {
    if (subjects == null) {
      return (A) this;
    }
    Iterator<SubjectBuilder> each = subjects.iterator();
    List visitables = _visitables.get("subjects");
    while (each.hasNext()) {
        SubjectBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public NonResourceRulesNested<A> setNewNonResourceRuleLike(int index,NonResourcePolicyRule item) {
    return new NonResourceRulesNested(index, item);
  }
  
  public ResourceRulesNested<A> setNewResourceRuleLike(int index,ResourcePolicyRule item) {
    return new ResourceRulesNested(index, item);
  }
  
  public SubjectsNested<A> setNewSubjectLike(int index,Subject item) {
    return new SubjectsNested(index, item);
  }
  
  public A setToNonResourceRules(int index,NonResourcePolicyRule item) {
    if (this.nonResourceRules == null) {
      this.nonResourceRules = new ArrayList();
    }
    NonResourcePolicyRuleBuilder builder = new NonResourcePolicyRuleBuilder(item);
    if (index < 0 || index >= nonResourceRules.size()) {
        _visitables.get("nonResourceRules").add(builder);
        nonResourceRules.add(builder);
    } else {
        _visitables.get("nonResourceRules").add(builder);
        nonResourceRules.set(index, builder);
    }
    return (A) this;
  }
  
  public A setToResourceRules(int index,ResourcePolicyRule item) {
    if (this.resourceRules == null) {
      this.resourceRules = new ArrayList();
    }
    ResourcePolicyRuleBuilder builder = new ResourcePolicyRuleBuilder(item);
    if (index < 0 || index >= resourceRules.size()) {
        _visitables.get("resourceRules").add(builder);
        resourceRules.add(builder);
    } else {
        _visitables.get("resourceRules").add(builder);
        resourceRules.set(index, builder);
    }
    return (A) this;
  }
  
  public A setToSubjects(int index,Subject item) {
    if (this.subjects == null) {
      this.subjects = new ArrayList();
    }
    SubjectBuilder builder = new SubjectBuilder(item);
    if (index < 0 || index >= subjects.size()) {
        _visitables.get("subjects").add(builder);
        subjects.add(builder);
    } else {
        _visitables.get("subjects").add(builder);
        subjects.set(index, builder);
    }
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
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
    if (!(subjects == null) && !(subjects.isEmpty())) {
        sb.append("subjects:");
        sb.append(subjects);
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
  
  public A withNonResourceRules(List<NonResourcePolicyRule> nonResourceRules) {
    if (this.nonResourceRules != null) {
      this._visitables.get("nonResourceRules").clear();
    }
    if (nonResourceRules != null) {
        this.nonResourceRules = new ArrayList();
        for (NonResourcePolicyRule item : nonResourceRules) {
          this.addToNonResourceRules(item);
        }
    } else {
      this.nonResourceRules = null;
    }
    return (A) this;
  }
  
  public A withNonResourceRules(NonResourcePolicyRule... nonResourceRules) {
    if (this.nonResourceRules != null) {
        this.nonResourceRules.clear();
        _visitables.remove("nonResourceRules");
    }
    if (nonResourceRules != null) {
      for (NonResourcePolicyRule item : nonResourceRules) {
        this.addToNonResourceRules(item);
      }
    }
    return (A) this;
  }
  
  public A withResourceRules(List<ResourcePolicyRule> resourceRules) {
    if (this.resourceRules != null) {
      this._visitables.get("resourceRules").clear();
    }
    if (resourceRules != null) {
        this.resourceRules = new ArrayList();
        for (ResourcePolicyRule item : resourceRules) {
          this.addToResourceRules(item);
        }
    } else {
      this.resourceRules = null;
    }
    return (A) this;
  }
  
  public A withResourceRules(ResourcePolicyRule... resourceRules) {
    if (this.resourceRules != null) {
        this.resourceRules.clear();
        _visitables.remove("resourceRules");
    }
    if (resourceRules != null) {
      for (ResourcePolicyRule item : resourceRules) {
        this.addToResourceRules(item);
      }
    }
    return (A) this;
  }
  
  public A withSubjects(List<Subject> subjects) {
    if (this.subjects != null) {
      this._visitables.get("subjects").clear();
    }
    if (subjects != null) {
        this.subjects = new ArrayList();
        for (Subject item : subjects) {
          this.addToSubjects(item);
        }
    } else {
      this.subjects = null;
    }
    return (A) this;
  }
  
  public A withSubjects(Subject... subjects) {
    if (this.subjects != null) {
        this.subjects.clear();
        _visitables.remove("subjects");
    }
    if (subjects != null) {
      for (Subject item : subjects) {
        this.addToSubjects(item);
      }
    }
    return (A) this;
  }
  public class NonResourceRulesNested<N> extends NonResourcePolicyRuleFluent<NonResourceRulesNested<N>> implements Nested<N>{
  
    NonResourcePolicyRuleBuilder builder;
    int index;
  
    NonResourceRulesNested(int index,NonResourcePolicyRule item) {
      this.index = index;
      this.builder = new NonResourcePolicyRuleBuilder(this, item);
    }
  
    public N and() {
      return (N) PolicyRulesWithSubjectsFluent.this.setToNonResourceRules(index, builder.build());
    }
    
    public N endNonResourceRule() {
      return and();
    }
    
  }
  public class ResourceRulesNested<N> extends ResourcePolicyRuleFluent<ResourceRulesNested<N>> implements Nested<N>{
  
    ResourcePolicyRuleBuilder builder;
    int index;
  
    ResourceRulesNested(int index,ResourcePolicyRule item) {
      this.index = index;
      this.builder = new ResourcePolicyRuleBuilder(this, item);
    }
  
    public N and() {
      return (N) PolicyRulesWithSubjectsFluent.this.setToResourceRules(index, builder.build());
    }
    
    public N endResourceRule() {
      return and();
    }
    
  }
  public class SubjectsNested<N> extends SubjectFluent<SubjectsNested<N>> implements Nested<N>{
  
    SubjectBuilder builder;
    int index;
  
    SubjectsNested(int index,Subject item) {
      this.index = index;
      this.builder = new SubjectBuilder(this, item);
    }
  
    public N and() {
      return (N) PolicyRulesWithSubjectsFluent.this.setToSubjects(index, builder.build());
    }
    
    public N endSubject() {
      return and();
    }
    
  }
}