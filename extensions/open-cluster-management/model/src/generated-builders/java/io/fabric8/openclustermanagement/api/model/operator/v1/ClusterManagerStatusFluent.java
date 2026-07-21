package io.fabric8.openclustermanagement.api.model.operator.v1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import io.fabric8.kubernetes.api.model.Condition;
import java.lang.Long;
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
public class ClusterManagerStatusFluent<A extends io.fabric8.openclustermanagement.api.model.operator.v1.ClusterManagerStatusFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private List<Condition> conditions = new ArrayList<Condition>();
  private ArrayList<GenerationStatusBuilder> generations = new ArrayList<GenerationStatusBuilder>();
  private Long observedGeneration;
  private ArrayList<RelatedResourceMetaBuilder> relatedResources = new ArrayList<RelatedResourceMetaBuilder>();

  public ClusterManagerStatusFluent() {
  }
  
  public ClusterManagerStatusFluent(ClusterManagerStatus instance) {
    this.copyInstance(instance);
  }

  public A addAllToConditions(Collection<Condition> items) {
    if (this.conditions == null) {
      this.conditions = new ArrayList();
    }
    for (Condition item : items) {
      this.conditions.add(item);
    }
    return (A) this;
  }
  
  public A addAllToGenerations(Collection<GenerationStatus> items) {
    if (this.generations == null) {
      this.generations = new ArrayList();
    }
    for (GenerationStatus item : items) {
        GenerationStatusBuilder builder = new GenerationStatusBuilder(item);
        _visitables.get("generations").add(builder);
        this.generations.add(builder);
    }
    return (A) this;
  }
  
  public A addAllToRelatedResources(Collection<RelatedResourceMeta> items) {
    if (this.relatedResources == null) {
      this.relatedResources = new ArrayList();
    }
    for (RelatedResourceMeta item : items) {
        RelatedResourceMetaBuilder builder = new RelatedResourceMetaBuilder(item);
        _visitables.get("relatedResources").add(builder);
        this.relatedResources.add(builder);
    }
    return (A) this;
  }
  
  public GenerationsNested<A> addNewGeneration() {
    return new GenerationsNested(-1, null);
  }
  
  public GenerationsNested<A> addNewGenerationLike(GenerationStatus item) {
    return new GenerationsNested(-1, item);
  }
  
  public RelatedResourcesNested<A> addNewRelatedResource() {
    return new RelatedResourcesNested(-1, null);
  }
  
  public A addNewRelatedResource(String group,String name,String namespace,String resource,String version) {
    return (A) this.addToRelatedResources(new RelatedResourceMeta(group, name, namespace, resource, version));
  }
  
  public RelatedResourcesNested<A> addNewRelatedResourceLike(RelatedResourceMeta item) {
    return new RelatedResourcesNested(-1, item);
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
  
  public A addToConditions(Condition... items) {
    if (this.conditions == null) {
      this.conditions = new ArrayList();
    }
    for (Condition item : items) {
      this.conditions.add(item);
    }
    return (A) this;
  }
  
  public A addToConditions(int index,Condition item) {
    if (this.conditions == null) {
      this.conditions = new ArrayList();
    }
    this.conditions.add(index, item);
    return (A) this;
  }
  
  public A addToGenerations(GenerationStatus... items) {
    if (this.generations == null) {
      this.generations = new ArrayList();
    }
    for (GenerationStatus item : items) {
        GenerationStatusBuilder builder = new GenerationStatusBuilder(item);
        _visitables.get("generations").add(builder);
        this.generations.add(builder);
    }
    return (A) this;
  }
  
  public A addToGenerations(int index,GenerationStatus item) {
    if (this.generations == null) {
      this.generations = new ArrayList();
    }
    GenerationStatusBuilder builder = new GenerationStatusBuilder(item);
    if (index < 0 || index >= generations.size()) {
        _visitables.get("generations").add(builder);
        generations.add(builder);
    } else {
        _visitables.get("generations").add(builder);
        generations.add(index, builder);
    }
    return (A) this;
  }
  
  public A addToRelatedResources(RelatedResourceMeta... items) {
    if (this.relatedResources == null) {
      this.relatedResources = new ArrayList();
    }
    for (RelatedResourceMeta item : items) {
        RelatedResourceMetaBuilder builder = new RelatedResourceMetaBuilder(item);
        _visitables.get("relatedResources").add(builder);
        this.relatedResources.add(builder);
    }
    return (A) this;
  }
  
  public A addToRelatedResources(int index,RelatedResourceMeta item) {
    if (this.relatedResources == null) {
      this.relatedResources = new ArrayList();
    }
    RelatedResourceMetaBuilder builder = new RelatedResourceMetaBuilder(item);
    if (index < 0 || index >= relatedResources.size()) {
        _visitables.get("relatedResources").add(builder);
        relatedResources.add(builder);
    } else {
        _visitables.get("relatedResources").add(builder);
        relatedResources.add(index, builder);
    }
    return (A) this;
  }
  
  public GenerationStatus buildFirstGeneration() {
    return this.generations.get(0).build();
  }
  
  public RelatedResourceMeta buildFirstRelatedResource() {
    return this.relatedResources.get(0).build();
  }
  
  public GenerationStatus buildGeneration(int index) {
    return this.generations.get(index).build();
  }
  
  public List<GenerationStatus> buildGenerations() {
    return this.generations != null ? build(generations) : null;
  }
  
  public GenerationStatus buildLastGeneration() {
    return this.generations.get(generations.size() - 1).build();
  }
  
  public RelatedResourceMeta buildLastRelatedResource() {
    return this.relatedResources.get(relatedResources.size() - 1).build();
  }
  
  public GenerationStatus buildMatchingGeneration(Predicate<GenerationStatusBuilder> predicate) {
      for (GenerationStatusBuilder item : generations) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public RelatedResourceMeta buildMatchingRelatedResource(Predicate<RelatedResourceMetaBuilder> predicate) {
      for (RelatedResourceMetaBuilder item : relatedResources) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public RelatedResourceMeta buildRelatedResource(int index) {
    return this.relatedResources.get(index).build();
  }
  
  public List<RelatedResourceMeta> buildRelatedResources() {
    return this.relatedResources != null ? build(relatedResources) : null;
  }
  
  protected void copyInstance(ClusterManagerStatus instance) {
    instance = instance != null ? instance : new ClusterManagerStatus();
    if (instance != null) {
        this.withConditions(instance.getConditions());
        this.withGenerations(instance.getGenerations());
        this.withObservedGeneration(instance.getObservedGeneration());
        this.withRelatedResources(instance.getRelatedResources());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public GenerationsNested<A> editFirstGeneration() {
    if (generations.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "generations"));
    }
    return this.setNewGenerationLike(0, this.buildGeneration(0));
  }
  
  public RelatedResourcesNested<A> editFirstRelatedResource() {
    if (relatedResources.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "relatedResources"));
    }
    return this.setNewRelatedResourceLike(0, this.buildRelatedResource(0));
  }
  
  public GenerationsNested<A> editGeneration(int index) {
    if (generations.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "generations"));
    }
    return this.setNewGenerationLike(index, this.buildGeneration(index));
  }
  
  public GenerationsNested<A> editLastGeneration() {
    int index = generations.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "generations"));
    }
    return this.setNewGenerationLike(index, this.buildGeneration(index));
  }
  
  public RelatedResourcesNested<A> editLastRelatedResource() {
    int index = relatedResources.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "relatedResources"));
    }
    return this.setNewRelatedResourceLike(index, this.buildRelatedResource(index));
  }
  
  public GenerationsNested<A> editMatchingGeneration(Predicate<GenerationStatusBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < generations.size();i++) {
      if (predicate.test(generations.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "generations"));
    }
    return this.setNewGenerationLike(index, this.buildGeneration(index));
  }
  
  public RelatedResourcesNested<A> editMatchingRelatedResource(Predicate<RelatedResourceMetaBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < relatedResources.size();i++) {
      if (predicate.test(relatedResources.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "relatedResources"));
    }
    return this.setNewRelatedResourceLike(index, this.buildRelatedResource(index));
  }
  
  public RelatedResourcesNested<A> editRelatedResource(int index) {
    if (relatedResources.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "relatedResources"));
    }
    return this.setNewRelatedResourceLike(index, this.buildRelatedResource(index));
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
    ClusterManagerStatusFluent that = (ClusterManagerStatusFluent) o;
    if (!(Objects.equals(conditions, that.conditions))) {
      return false;
    }
    if (!(Objects.equals(generations, that.generations))) {
      return false;
    }
    if (!(Objects.equals(observedGeneration, that.observedGeneration))) {
      return false;
    }
    if (!(Objects.equals(relatedResources, that.relatedResources))) {
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
  
  public Condition getCondition(int index) {
    return this.conditions.get(index);
  }
  
  public List<Condition> getConditions() {
    return this.conditions;
  }
  
  public Condition getFirstCondition() {
    return this.conditions.get(0);
  }
  
  public Condition getLastCondition() {
    return this.conditions.get(conditions.size() - 1);
  }
  
  public Condition getMatchingCondition(Predicate<Condition> predicate) {
      for (Condition item : conditions) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public Long getObservedGeneration() {
    return this.observedGeneration;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasConditions() {
    return this.conditions != null && !(this.conditions.isEmpty());
  }
  
  public boolean hasGenerations() {
    return this.generations != null && !(this.generations.isEmpty());
  }
  
  public boolean hasMatchingCondition(Predicate<Condition> predicate) {
      for (Condition item : conditions) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingGeneration(Predicate<GenerationStatusBuilder> predicate) {
      for (GenerationStatusBuilder item : generations) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingRelatedResource(Predicate<RelatedResourceMetaBuilder> predicate) {
      for (RelatedResourceMetaBuilder item : relatedResources) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasObservedGeneration() {
    return this.observedGeneration != null;
  }
  
  public boolean hasRelatedResources() {
    return this.relatedResources != null && !(this.relatedResources.isEmpty());
  }
  
  public int hashCode() {
    return Objects.hash(conditions, generations, observedGeneration, relatedResources, additionalProperties);
  }
  
  public A removeAllFromConditions(Collection<Condition> items) {
    if (this.conditions == null) {
      return (A) this;
    }
    for (Condition item : items) {
      this.conditions.remove(item);
    }
    return (A) this;
  }
  
  public A removeAllFromGenerations(Collection<GenerationStatus> items) {
    if (this.generations == null) {
      return (A) this;
    }
    for (GenerationStatus item : items) {
        GenerationStatusBuilder builder = new GenerationStatusBuilder(item);
        _visitables.get("generations").remove(builder);
        this.generations.remove(builder);
    }
    return (A) this;
  }
  
  public A removeAllFromRelatedResources(Collection<RelatedResourceMeta> items) {
    if (this.relatedResources == null) {
      return (A) this;
    }
    for (RelatedResourceMeta item : items) {
        RelatedResourceMetaBuilder builder = new RelatedResourceMetaBuilder(item);
        _visitables.get("relatedResources").remove(builder);
        this.relatedResources.remove(builder);
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
  
  public A removeFromConditions(Condition... items) {
    if (this.conditions == null) {
      return (A) this;
    }
    for (Condition item : items) {
      this.conditions.remove(item);
    }
    return (A) this;
  }
  
  public A removeFromGenerations(GenerationStatus... items) {
    if (this.generations == null) {
      return (A) this;
    }
    for (GenerationStatus item : items) {
        GenerationStatusBuilder builder = new GenerationStatusBuilder(item);
        _visitables.get("generations").remove(builder);
        this.generations.remove(builder);
    }
    return (A) this;
  }
  
  public A removeFromRelatedResources(RelatedResourceMeta... items) {
    if (this.relatedResources == null) {
      return (A) this;
    }
    for (RelatedResourceMeta item : items) {
        RelatedResourceMetaBuilder builder = new RelatedResourceMetaBuilder(item);
        _visitables.get("relatedResources").remove(builder);
        this.relatedResources.remove(builder);
    }
    return (A) this;
  }
  
  public A removeMatchingFromGenerations(Predicate<GenerationStatusBuilder> predicate) {
    if (generations == null) {
      return (A) this;
    }
    Iterator<GenerationStatusBuilder> each = generations.iterator();
    List visitables = _visitables.get("generations");
    while (each.hasNext()) {
        GenerationStatusBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public A removeMatchingFromRelatedResources(Predicate<RelatedResourceMetaBuilder> predicate) {
    if (relatedResources == null) {
      return (A) this;
    }
    Iterator<RelatedResourceMetaBuilder> each = relatedResources.iterator();
    List visitables = _visitables.get("relatedResources");
    while (each.hasNext()) {
        RelatedResourceMetaBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public GenerationsNested<A> setNewGenerationLike(int index,GenerationStatus item) {
    return new GenerationsNested(index, item);
  }
  
  public RelatedResourcesNested<A> setNewRelatedResourceLike(int index,RelatedResourceMeta item) {
    return new RelatedResourcesNested(index, item);
  }
  
  public A setToConditions(int index,Condition item) {
    if (this.conditions == null) {
      this.conditions = new ArrayList();
    }
    this.conditions.set(index, item);
    return (A) this;
  }
  
  public A setToGenerations(int index,GenerationStatus item) {
    if (this.generations == null) {
      this.generations = new ArrayList();
    }
    GenerationStatusBuilder builder = new GenerationStatusBuilder(item);
    if (index < 0 || index >= generations.size()) {
        _visitables.get("generations").add(builder);
        generations.add(builder);
    } else {
        _visitables.get("generations").add(builder);
        generations.set(index, builder);
    }
    return (A) this;
  }
  
  public A setToRelatedResources(int index,RelatedResourceMeta item) {
    if (this.relatedResources == null) {
      this.relatedResources = new ArrayList();
    }
    RelatedResourceMetaBuilder builder = new RelatedResourceMetaBuilder(item);
    if (index < 0 || index >= relatedResources.size()) {
        _visitables.get("relatedResources").add(builder);
        relatedResources.add(builder);
    } else {
        _visitables.get("relatedResources").add(builder);
        relatedResources.set(index, builder);
    }
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(conditions == null) && !(conditions.isEmpty())) {
        sb.append("conditions:");
        sb.append(conditions);
        sb.append(",");
    }
    if (!(generations == null) && !(generations.isEmpty())) {
        sb.append("generations:");
        sb.append(generations);
        sb.append(",");
    }
    if (!(observedGeneration == null)) {
        sb.append("observedGeneration:");
        sb.append(observedGeneration);
        sb.append(",");
    }
    if (!(relatedResources == null) && !(relatedResources.isEmpty())) {
        sb.append("relatedResources:");
        sb.append(relatedResources);
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
  
  public A withConditions(List<Condition> conditions) {
    if (conditions != null) {
        this.conditions = new ArrayList();
        for (Condition item : conditions) {
          this.addToConditions(item);
        }
    } else {
      this.conditions = null;
    }
    return (A) this;
  }
  
  public A withConditions(Condition... conditions) {
    if (this.conditions != null) {
        this.conditions.clear();
        _visitables.remove("conditions");
    }
    if (conditions != null) {
      for (Condition item : conditions) {
        this.addToConditions(item);
      }
    }
    return (A) this;
  }
  
  public A withGenerations(List<GenerationStatus> generations) {
    if (this.generations != null) {
      this._visitables.get("generations").clear();
    }
    if (generations != null) {
        this.generations = new ArrayList();
        for (GenerationStatus item : generations) {
          this.addToGenerations(item);
        }
    } else {
      this.generations = null;
    }
    return (A) this;
  }
  
  public A withGenerations(GenerationStatus... generations) {
    if (this.generations != null) {
        this.generations.clear();
        _visitables.remove("generations");
    }
    if (generations != null) {
      for (GenerationStatus item : generations) {
        this.addToGenerations(item);
      }
    }
    return (A) this;
  }
  
  public A withObservedGeneration(Long observedGeneration) {
    this.observedGeneration = observedGeneration;
    return (A) this;
  }
  
  public A withRelatedResources(List<RelatedResourceMeta> relatedResources) {
    if (this.relatedResources != null) {
      this._visitables.get("relatedResources").clear();
    }
    if (relatedResources != null) {
        this.relatedResources = new ArrayList();
        for (RelatedResourceMeta item : relatedResources) {
          this.addToRelatedResources(item);
        }
    } else {
      this.relatedResources = null;
    }
    return (A) this;
  }
  
  public A withRelatedResources(RelatedResourceMeta... relatedResources) {
    if (this.relatedResources != null) {
        this.relatedResources.clear();
        _visitables.remove("relatedResources");
    }
    if (relatedResources != null) {
      for (RelatedResourceMeta item : relatedResources) {
        this.addToRelatedResources(item);
      }
    }
    return (A) this;
  }
  public class GenerationsNested<N> extends GenerationStatusFluent<GenerationsNested<N>> implements Nested<N>{
  
    GenerationStatusBuilder builder;
    int index;
  
    GenerationsNested(int index,GenerationStatus item) {
      this.index = index;
      this.builder = new GenerationStatusBuilder(this, item);
    }
  
    public N and() {
      return (N) ClusterManagerStatusFluent.this.setToGenerations(index, builder.build());
    }
    
    public N endGeneration() {
      return and();
    }
    
  }
  public class RelatedResourcesNested<N> extends RelatedResourceMetaFluent<RelatedResourcesNested<N>> implements Nested<N>{
  
    RelatedResourceMetaBuilder builder;
    int index;
  
    RelatedResourcesNested(int index,RelatedResourceMeta item) {
      this.index = index;
      this.builder = new RelatedResourceMetaBuilder(this, item);
    }
  
    public N and() {
      return (N) ClusterManagerStatusFluent.this.setToRelatedResources(index, builder.build());
    }
    
    public N endRelatedResource() {
      return and();
    }
    
  }
}