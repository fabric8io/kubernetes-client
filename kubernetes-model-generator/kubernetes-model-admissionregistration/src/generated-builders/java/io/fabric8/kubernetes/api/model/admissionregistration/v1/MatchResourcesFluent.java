package io.fabric8.kubernetes.api.model.admissionregistration.v1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import io.fabric8.kubernetes.api.model.LabelSelector;
import io.fabric8.kubernetes.api.model.LabelSelectorBuilder;
import io.fabric8.kubernetes.api.model.LabelSelectorFluent;
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
public class MatchResourcesFluent<A extends io.fabric8.kubernetes.api.model.admissionregistration.v1.MatchResourcesFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private ArrayList<NamedRuleWithOperationsBuilder> excludeResourceRules = new ArrayList<NamedRuleWithOperationsBuilder>();
  private String matchPolicy;
  private LabelSelectorBuilder namespaceSelector;
  private LabelSelectorBuilder objectSelector;
  private ArrayList<NamedRuleWithOperationsBuilder> resourceRules = new ArrayList<NamedRuleWithOperationsBuilder>();

  public MatchResourcesFluent() {
  }
  
  public MatchResourcesFluent(MatchResources instance) {
    this.copyInstance(instance);
  }

  public A addAllToExcludeResourceRules(Collection<NamedRuleWithOperations> items) {
    if (this.excludeResourceRules == null) {
      this.excludeResourceRules = new ArrayList();
    }
    for (NamedRuleWithOperations item : items) {
        NamedRuleWithOperationsBuilder builder = new NamedRuleWithOperationsBuilder(item);
        _visitables.get("excludeResourceRules").add(builder);
        this.excludeResourceRules.add(builder);
    }
    return (A) this;
  }
  
  public A addAllToResourceRules(Collection<NamedRuleWithOperations> items) {
    if (this.resourceRules == null) {
      this.resourceRules = new ArrayList();
    }
    for (NamedRuleWithOperations item : items) {
        NamedRuleWithOperationsBuilder builder = new NamedRuleWithOperationsBuilder(item);
        _visitables.get("resourceRules").add(builder);
        this.resourceRules.add(builder);
    }
    return (A) this;
  }
  
  public ExcludeResourceRulesNested<A> addNewExcludeResourceRule() {
    return new ExcludeResourceRulesNested(-1, null);
  }
  
  public ExcludeResourceRulesNested<A> addNewExcludeResourceRuleLike(NamedRuleWithOperations item) {
    return new ExcludeResourceRulesNested(-1, item);
  }
  
  public ResourceRulesNested<A> addNewResourceRule() {
    return new ResourceRulesNested(-1, null);
  }
  
  public ResourceRulesNested<A> addNewResourceRuleLike(NamedRuleWithOperations item) {
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
  
  public A addToExcludeResourceRules(NamedRuleWithOperations... items) {
    if (this.excludeResourceRules == null) {
      this.excludeResourceRules = new ArrayList();
    }
    for (NamedRuleWithOperations item : items) {
        NamedRuleWithOperationsBuilder builder = new NamedRuleWithOperationsBuilder(item);
        _visitables.get("excludeResourceRules").add(builder);
        this.excludeResourceRules.add(builder);
    }
    return (A) this;
  }
  
  public A addToExcludeResourceRules(int index,NamedRuleWithOperations item) {
    if (this.excludeResourceRules == null) {
      this.excludeResourceRules = new ArrayList();
    }
    NamedRuleWithOperationsBuilder builder = new NamedRuleWithOperationsBuilder(item);
    if (index < 0 || index >= excludeResourceRules.size()) {
        _visitables.get("excludeResourceRules").add(builder);
        excludeResourceRules.add(builder);
    } else {
        _visitables.get("excludeResourceRules").add(builder);
        excludeResourceRules.add(index, builder);
    }
    return (A) this;
  }
  
  public A addToResourceRules(NamedRuleWithOperations... items) {
    if (this.resourceRules == null) {
      this.resourceRules = new ArrayList();
    }
    for (NamedRuleWithOperations item : items) {
        NamedRuleWithOperationsBuilder builder = new NamedRuleWithOperationsBuilder(item);
        _visitables.get("resourceRules").add(builder);
        this.resourceRules.add(builder);
    }
    return (A) this;
  }
  
  public A addToResourceRules(int index,NamedRuleWithOperations item) {
    if (this.resourceRules == null) {
      this.resourceRules = new ArrayList();
    }
    NamedRuleWithOperationsBuilder builder = new NamedRuleWithOperationsBuilder(item);
    if (index < 0 || index >= resourceRules.size()) {
        _visitables.get("resourceRules").add(builder);
        resourceRules.add(builder);
    } else {
        _visitables.get("resourceRules").add(builder);
        resourceRules.add(index, builder);
    }
    return (A) this;
  }
  
  public NamedRuleWithOperations buildExcludeResourceRule(int index) {
    return this.excludeResourceRules.get(index).build();
  }
  
  public List<NamedRuleWithOperations> buildExcludeResourceRules() {
    return this.excludeResourceRules != null ? build(excludeResourceRules) : null;
  }
  
  public NamedRuleWithOperations buildFirstExcludeResourceRule() {
    return this.excludeResourceRules.get(0).build();
  }
  
  public NamedRuleWithOperations buildFirstResourceRule() {
    return this.resourceRules.get(0).build();
  }
  
  public NamedRuleWithOperations buildLastExcludeResourceRule() {
    return this.excludeResourceRules.get(excludeResourceRules.size() - 1).build();
  }
  
  public NamedRuleWithOperations buildLastResourceRule() {
    return this.resourceRules.get(resourceRules.size() - 1).build();
  }
  
  public NamedRuleWithOperations buildMatchingExcludeResourceRule(Predicate<NamedRuleWithOperationsBuilder> predicate) {
      for (NamedRuleWithOperationsBuilder item : excludeResourceRules) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public NamedRuleWithOperations buildMatchingResourceRule(Predicate<NamedRuleWithOperationsBuilder> predicate) {
      for (NamedRuleWithOperationsBuilder item : resourceRules) {
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
  
  public NamedRuleWithOperations buildResourceRule(int index) {
    return this.resourceRules.get(index).build();
  }
  
  public List<NamedRuleWithOperations> buildResourceRules() {
    return this.resourceRules != null ? build(resourceRules) : null;
  }
  
  protected void copyInstance(MatchResources instance) {
    instance = instance != null ? instance : new MatchResources();
    if (instance != null) {
        this.withExcludeResourceRules(instance.getExcludeResourceRules());
        this.withMatchPolicy(instance.getMatchPolicy());
        this.withNamespaceSelector(instance.getNamespaceSelector());
        this.withObjectSelector(instance.getObjectSelector());
        this.withResourceRules(instance.getResourceRules());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public ExcludeResourceRulesNested<A> editExcludeResourceRule(int index) {
    if (excludeResourceRules.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "excludeResourceRules"));
    }
    return this.setNewExcludeResourceRuleLike(index, this.buildExcludeResourceRule(index));
  }
  
  public ExcludeResourceRulesNested<A> editFirstExcludeResourceRule() {
    if (excludeResourceRules.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "excludeResourceRules"));
    }
    return this.setNewExcludeResourceRuleLike(0, this.buildExcludeResourceRule(0));
  }
  
  public ResourceRulesNested<A> editFirstResourceRule() {
    if (resourceRules.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "resourceRules"));
    }
    return this.setNewResourceRuleLike(0, this.buildResourceRule(0));
  }
  
  public ExcludeResourceRulesNested<A> editLastExcludeResourceRule() {
    int index = excludeResourceRules.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "excludeResourceRules"));
    }
    return this.setNewExcludeResourceRuleLike(index, this.buildExcludeResourceRule(index));
  }
  
  public ResourceRulesNested<A> editLastResourceRule() {
    int index = resourceRules.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "resourceRules"));
    }
    return this.setNewResourceRuleLike(index, this.buildResourceRule(index));
  }
  
  public ExcludeResourceRulesNested<A> editMatchingExcludeResourceRule(Predicate<NamedRuleWithOperationsBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < excludeResourceRules.size();i++) {
      if (predicate.test(excludeResourceRules.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "excludeResourceRules"));
    }
    return this.setNewExcludeResourceRuleLike(index, this.buildExcludeResourceRule(index));
  }
  
  public ResourceRulesNested<A> editMatchingResourceRule(Predicate<NamedRuleWithOperationsBuilder> predicate) {
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
  
  public NamespaceSelectorNested<A> editNamespaceSelector() {
    return this.withNewNamespaceSelectorLike(Optional.ofNullable(this.buildNamespaceSelector()).orElse(null));
  }
  
  public ObjectSelectorNested<A> editObjectSelector() {
    return this.withNewObjectSelectorLike(Optional.ofNullable(this.buildObjectSelector()).orElse(null));
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
    MatchResourcesFluent that = (MatchResourcesFluent) o;
    if (!(Objects.equals(excludeResourceRules, that.excludeResourceRules))) {
      return false;
    }
    if (!(Objects.equals(matchPolicy, that.matchPolicy))) {
      return false;
    }
    if (!(Objects.equals(namespaceSelector, that.namespaceSelector))) {
      return false;
    }
    if (!(Objects.equals(objectSelector, that.objectSelector))) {
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
  
  public String getMatchPolicy() {
    return this.matchPolicy;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasExcludeResourceRules() {
    return this.excludeResourceRules != null && !(this.excludeResourceRules.isEmpty());
  }
  
  public boolean hasMatchPolicy() {
    return this.matchPolicy != null;
  }
  
  public boolean hasMatchingExcludeResourceRule(Predicate<NamedRuleWithOperationsBuilder> predicate) {
      for (NamedRuleWithOperationsBuilder item : excludeResourceRules) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingResourceRule(Predicate<NamedRuleWithOperationsBuilder> predicate) {
      for (NamedRuleWithOperationsBuilder item : resourceRules) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasNamespaceSelector() {
    return this.namespaceSelector != null;
  }
  
  public boolean hasObjectSelector() {
    return this.objectSelector != null;
  }
  
  public boolean hasResourceRules() {
    return this.resourceRules != null && !(this.resourceRules.isEmpty());
  }
  
  public int hashCode() {
    return Objects.hash(excludeResourceRules, matchPolicy, namespaceSelector, objectSelector, resourceRules, additionalProperties);
  }
  
  public A removeAllFromExcludeResourceRules(Collection<NamedRuleWithOperations> items) {
    if (this.excludeResourceRules == null) {
      return (A) this;
    }
    for (NamedRuleWithOperations item : items) {
        NamedRuleWithOperationsBuilder builder = new NamedRuleWithOperationsBuilder(item);
        _visitables.get("excludeResourceRules").remove(builder);
        this.excludeResourceRules.remove(builder);
    }
    return (A) this;
  }
  
  public A removeAllFromResourceRules(Collection<NamedRuleWithOperations> items) {
    if (this.resourceRules == null) {
      return (A) this;
    }
    for (NamedRuleWithOperations item : items) {
        NamedRuleWithOperationsBuilder builder = new NamedRuleWithOperationsBuilder(item);
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
  
  public A removeFromExcludeResourceRules(NamedRuleWithOperations... items) {
    if (this.excludeResourceRules == null) {
      return (A) this;
    }
    for (NamedRuleWithOperations item : items) {
        NamedRuleWithOperationsBuilder builder = new NamedRuleWithOperationsBuilder(item);
        _visitables.get("excludeResourceRules").remove(builder);
        this.excludeResourceRules.remove(builder);
    }
    return (A) this;
  }
  
  public A removeFromResourceRules(NamedRuleWithOperations... items) {
    if (this.resourceRules == null) {
      return (A) this;
    }
    for (NamedRuleWithOperations item : items) {
        NamedRuleWithOperationsBuilder builder = new NamedRuleWithOperationsBuilder(item);
        _visitables.get("resourceRules").remove(builder);
        this.resourceRules.remove(builder);
    }
    return (A) this;
  }
  
  public A removeMatchingFromExcludeResourceRules(Predicate<NamedRuleWithOperationsBuilder> predicate) {
    if (excludeResourceRules == null) {
      return (A) this;
    }
    Iterator<NamedRuleWithOperationsBuilder> each = excludeResourceRules.iterator();
    List visitables = _visitables.get("excludeResourceRules");
    while (each.hasNext()) {
        NamedRuleWithOperationsBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public A removeMatchingFromResourceRules(Predicate<NamedRuleWithOperationsBuilder> predicate) {
    if (resourceRules == null) {
      return (A) this;
    }
    Iterator<NamedRuleWithOperationsBuilder> each = resourceRules.iterator();
    List visitables = _visitables.get("resourceRules");
    while (each.hasNext()) {
        NamedRuleWithOperationsBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public ExcludeResourceRulesNested<A> setNewExcludeResourceRuleLike(int index,NamedRuleWithOperations item) {
    return new ExcludeResourceRulesNested(index, item);
  }
  
  public ResourceRulesNested<A> setNewResourceRuleLike(int index,NamedRuleWithOperations item) {
    return new ResourceRulesNested(index, item);
  }
  
  public A setToExcludeResourceRules(int index,NamedRuleWithOperations item) {
    if (this.excludeResourceRules == null) {
      this.excludeResourceRules = new ArrayList();
    }
    NamedRuleWithOperationsBuilder builder = new NamedRuleWithOperationsBuilder(item);
    if (index < 0 || index >= excludeResourceRules.size()) {
        _visitables.get("excludeResourceRules").add(builder);
        excludeResourceRules.add(builder);
    } else {
        _visitables.get("excludeResourceRules").add(builder);
        excludeResourceRules.set(index, builder);
    }
    return (A) this;
  }
  
  public A setToResourceRules(int index,NamedRuleWithOperations item) {
    if (this.resourceRules == null) {
      this.resourceRules = new ArrayList();
    }
    NamedRuleWithOperationsBuilder builder = new NamedRuleWithOperationsBuilder(item);
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
    if (!(excludeResourceRules == null) && !(excludeResourceRules.isEmpty())) {
        sb.append("excludeResourceRules:");
        sb.append(excludeResourceRules);
        sb.append(",");
    }
    if (!(matchPolicy == null)) {
        sb.append("matchPolicy:");
        sb.append(matchPolicy);
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
  
  public A withExcludeResourceRules(List<NamedRuleWithOperations> excludeResourceRules) {
    if (this.excludeResourceRules != null) {
      this._visitables.get("excludeResourceRules").clear();
    }
    if (excludeResourceRules != null) {
        this.excludeResourceRules = new ArrayList();
        for (NamedRuleWithOperations item : excludeResourceRules) {
          this.addToExcludeResourceRules(item);
        }
    } else {
      this.excludeResourceRules = null;
    }
    return (A) this;
  }
  
  public A withExcludeResourceRules(NamedRuleWithOperations... excludeResourceRules) {
    if (this.excludeResourceRules != null) {
        this.excludeResourceRules.clear();
        _visitables.remove("excludeResourceRules");
    }
    if (excludeResourceRules != null) {
      for (NamedRuleWithOperations item : excludeResourceRules) {
        this.addToExcludeResourceRules(item);
      }
    }
    return (A) this;
  }
  
  public A withMatchPolicy(String matchPolicy) {
    this.matchPolicy = matchPolicy;
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
  
  public A withResourceRules(List<NamedRuleWithOperations> resourceRules) {
    if (this.resourceRules != null) {
      this._visitables.get("resourceRules").clear();
    }
    if (resourceRules != null) {
        this.resourceRules = new ArrayList();
        for (NamedRuleWithOperations item : resourceRules) {
          this.addToResourceRules(item);
        }
    } else {
      this.resourceRules = null;
    }
    return (A) this;
  }
  
  public A withResourceRules(NamedRuleWithOperations... resourceRules) {
    if (this.resourceRules != null) {
        this.resourceRules.clear();
        _visitables.remove("resourceRules");
    }
    if (resourceRules != null) {
      for (NamedRuleWithOperations item : resourceRules) {
        this.addToResourceRules(item);
      }
    }
    return (A) this;
  }
  public class ExcludeResourceRulesNested<N> extends NamedRuleWithOperationsFluent<ExcludeResourceRulesNested<N>> implements Nested<N>{
  
    NamedRuleWithOperationsBuilder builder;
    int index;
  
    ExcludeResourceRulesNested(int index,NamedRuleWithOperations item) {
      this.index = index;
      this.builder = new NamedRuleWithOperationsBuilder(this, item);
    }
  
    public N and() {
      return (N) MatchResourcesFluent.this.setToExcludeResourceRules(index, builder.build());
    }
    
    public N endExcludeResourceRule() {
      return and();
    }
    
  }
  public class NamespaceSelectorNested<N> extends LabelSelectorFluent<NamespaceSelectorNested<N>> implements Nested<N>{
  
    LabelSelectorBuilder builder;
  
    NamespaceSelectorNested(LabelSelector item) {
      this.builder = new LabelSelectorBuilder(this, item);
    }
  
    public N and() {
      return (N) MatchResourcesFluent.this.withNamespaceSelector(builder.build());
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
      return (N) MatchResourcesFluent.this.withObjectSelector(builder.build());
    }
    
    public N endObjectSelector() {
      return and();
    }
    
  }
  public class ResourceRulesNested<N> extends NamedRuleWithOperationsFluent<ResourceRulesNested<N>> implements Nested<N>{
  
    NamedRuleWithOperationsBuilder builder;
    int index;
  
    ResourceRulesNested(int index,NamedRuleWithOperations item) {
      this.index = index;
      this.builder = new NamedRuleWithOperationsBuilder(this, item);
    }
  
    public N and() {
      return (N) MatchResourcesFluent.this.setToResourceRules(index, builder.build());
    }
    
    public N endResourceRule() {
      return and();
    }
    
  }
}