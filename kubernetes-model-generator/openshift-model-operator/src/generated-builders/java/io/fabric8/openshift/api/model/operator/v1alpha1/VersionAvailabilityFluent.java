package io.fabric8.openshift.api.model.operator.v1alpha1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import java.lang.Integer;
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
public class VersionAvailabilityFluent<A extends io.fabric8.openshift.api.model.operator.v1alpha1.VersionAvailabilityFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private List<String> errors = new ArrayList<String>();
  private ArrayList<GenerationHistoryBuilder> generations = new ArrayList<GenerationHistoryBuilder>();
  private Integer readyReplicas;
  private Integer updatedReplicas;
  private String version;

  public VersionAvailabilityFluent() {
  }
  
  public VersionAvailabilityFluent(VersionAvailability instance) {
    this.copyInstance(instance);
  }

  public A addAllToErrors(Collection<String> items) {
    if (this.errors == null) {
      this.errors = new ArrayList();
    }
    for (String item : items) {
      this.errors.add(item);
    }
    return (A) this;
  }
  
  public A addAllToGenerations(Collection<GenerationHistory> items) {
    if (this.generations == null) {
      this.generations = new ArrayList();
    }
    for (GenerationHistory item : items) {
        GenerationHistoryBuilder builder = new GenerationHistoryBuilder(item);
        _visitables.get("generations").add(builder);
        this.generations.add(builder);
    }
    return (A) this;
  }
  
  public GenerationsNested<A> addNewGeneration() {
    return new GenerationsNested(-1, null);
  }
  
  public A addNewGeneration(String group,Long lastGeneration,String name,String namespace,String resource) {
    return (A) this.addToGenerations(new GenerationHistory(group, lastGeneration, name, namespace, resource));
  }
  
  public GenerationsNested<A> addNewGenerationLike(GenerationHistory item) {
    return new GenerationsNested(-1, item);
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
  
  public A addToErrors(String... items) {
    if (this.errors == null) {
      this.errors = new ArrayList();
    }
    for (String item : items) {
      this.errors.add(item);
    }
    return (A) this;
  }
  
  public A addToErrors(int index,String item) {
    if (this.errors == null) {
      this.errors = new ArrayList();
    }
    this.errors.add(index, item);
    return (A) this;
  }
  
  public A addToGenerations(GenerationHistory... items) {
    if (this.generations == null) {
      this.generations = new ArrayList();
    }
    for (GenerationHistory item : items) {
        GenerationHistoryBuilder builder = new GenerationHistoryBuilder(item);
        _visitables.get("generations").add(builder);
        this.generations.add(builder);
    }
    return (A) this;
  }
  
  public A addToGenerations(int index,GenerationHistory item) {
    if (this.generations == null) {
      this.generations = new ArrayList();
    }
    GenerationHistoryBuilder builder = new GenerationHistoryBuilder(item);
    if (index < 0 || index >= generations.size()) {
        _visitables.get("generations").add(builder);
        generations.add(builder);
    } else {
        _visitables.get("generations").add(builder);
        generations.add(index, builder);
    }
    return (A) this;
  }
  
  public GenerationHistory buildFirstGeneration() {
    return this.generations.get(0).build();
  }
  
  public GenerationHistory buildGeneration(int index) {
    return this.generations.get(index).build();
  }
  
  public List<GenerationHistory> buildGenerations() {
    return this.generations != null ? build(generations) : null;
  }
  
  public GenerationHistory buildLastGeneration() {
    return this.generations.get(generations.size() - 1).build();
  }
  
  public GenerationHistory buildMatchingGeneration(Predicate<GenerationHistoryBuilder> predicate) {
      for (GenerationHistoryBuilder item : generations) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  protected void copyInstance(VersionAvailability instance) {
    instance = instance != null ? instance : new VersionAvailability();
    if (instance != null) {
        this.withErrors(instance.getErrors());
        this.withGenerations(instance.getGenerations());
        this.withReadyReplicas(instance.getReadyReplicas());
        this.withUpdatedReplicas(instance.getUpdatedReplicas());
        this.withVersion(instance.getVersion());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public GenerationsNested<A> editFirstGeneration() {
    if (generations.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "generations"));
    }
    return this.setNewGenerationLike(0, this.buildGeneration(0));
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
  
  public GenerationsNested<A> editMatchingGeneration(Predicate<GenerationHistoryBuilder> predicate) {
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
    VersionAvailabilityFluent that = (VersionAvailabilityFluent) o;
    if (!(Objects.equals(errors, that.errors))) {
      return false;
    }
    if (!(Objects.equals(generations, that.generations))) {
      return false;
    }
    if (!(Objects.equals(readyReplicas, that.readyReplicas))) {
      return false;
    }
    if (!(Objects.equals(updatedReplicas, that.updatedReplicas))) {
      return false;
    }
    if (!(Objects.equals(version, that.version))) {
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
  
  public String getError(int index) {
    return this.errors.get(index);
  }
  
  public List<String> getErrors() {
    return this.errors;
  }
  
  public String getFirstError() {
    return this.errors.get(0);
  }
  
  public String getLastError() {
    return this.errors.get(errors.size() - 1);
  }
  
  public String getMatchingError(Predicate<String> predicate) {
      for (String item : errors) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public Integer getReadyReplicas() {
    return this.readyReplicas;
  }
  
  public Integer getUpdatedReplicas() {
    return this.updatedReplicas;
  }
  
  public String getVersion() {
    return this.version;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasErrors() {
    return this.errors != null && !(this.errors.isEmpty());
  }
  
  public boolean hasGenerations() {
    return this.generations != null && !(this.generations.isEmpty());
  }
  
  public boolean hasMatchingError(Predicate<String> predicate) {
      for (String item : errors) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingGeneration(Predicate<GenerationHistoryBuilder> predicate) {
      for (GenerationHistoryBuilder item : generations) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasReadyReplicas() {
    return this.readyReplicas != null;
  }
  
  public boolean hasUpdatedReplicas() {
    return this.updatedReplicas != null;
  }
  
  public boolean hasVersion() {
    return this.version != null;
  }
  
  public int hashCode() {
    return Objects.hash(errors, generations, readyReplicas, updatedReplicas, version, additionalProperties);
  }
  
  public A removeAllFromErrors(Collection<String> items) {
    if (this.errors == null) {
      return (A) this;
    }
    for (String item : items) {
      this.errors.remove(item);
    }
    return (A) this;
  }
  
  public A removeAllFromGenerations(Collection<GenerationHistory> items) {
    if (this.generations == null) {
      return (A) this;
    }
    for (GenerationHistory item : items) {
        GenerationHistoryBuilder builder = new GenerationHistoryBuilder(item);
        _visitables.get("generations").remove(builder);
        this.generations.remove(builder);
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
  
  public A removeFromErrors(String... items) {
    if (this.errors == null) {
      return (A) this;
    }
    for (String item : items) {
      this.errors.remove(item);
    }
    return (A) this;
  }
  
  public A removeFromGenerations(GenerationHistory... items) {
    if (this.generations == null) {
      return (A) this;
    }
    for (GenerationHistory item : items) {
        GenerationHistoryBuilder builder = new GenerationHistoryBuilder(item);
        _visitables.get("generations").remove(builder);
        this.generations.remove(builder);
    }
    return (A) this;
  }
  
  public A removeMatchingFromGenerations(Predicate<GenerationHistoryBuilder> predicate) {
    if (generations == null) {
      return (A) this;
    }
    Iterator<GenerationHistoryBuilder> each = generations.iterator();
    List visitables = _visitables.get("generations");
    while (each.hasNext()) {
        GenerationHistoryBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public GenerationsNested<A> setNewGenerationLike(int index,GenerationHistory item) {
    return new GenerationsNested(index, item);
  }
  
  public A setToErrors(int index,String item) {
    if (this.errors == null) {
      this.errors = new ArrayList();
    }
    this.errors.set(index, item);
    return (A) this;
  }
  
  public A setToGenerations(int index,GenerationHistory item) {
    if (this.generations == null) {
      this.generations = new ArrayList();
    }
    GenerationHistoryBuilder builder = new GenerationHistoryBuilder(item);
    if (index < 0 || index >= generations.size()) {
        _visitables.get("generations").add(builder);
        generations.add(builder);
    } else {
        _visitables.get("generations").add(builder);
        generations.set(index, builder);
    }
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(errors == null) && !(errors.isEmpty())) {
        sb.append("errors:");
        sb.append(errors);
        sb.append(",");
    }
    if (!(generations == null) && !(generations.isEmpty())) {
        sb.append("generations:");
        sb.append(generations);
        sb.append(",");
    }
    if (!(readyReplicas == null)) {
        sb.append("readyReplicas:");
        sb.append(readyReplicas);
        sb.append(",");
    }
    if (!(updatedReplicas == null)) {
        sb.append("updatedReplicas:");
        sb.append(updatedReplicas);
        sb.append(",");
    }
    if (!(version == null)) {
        sb.append("version:");
        sb.append(version);
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
  
  public A withErrors(List<String> errors) {
    if (errors != null) {
        this.errors = new ArrayList();
        for (String item : errors) {
          this.addToErrors(item);
        }
    } else {
      this.errors = null;
    }
    return (A) this;
  }
  
  public A withErrors(String... errors) {
    if (this.errors != null) {
        this.errors.clear();
        _visitables.remove("errors");
    }
    if (errors != null) {
      for (String item : errors) {
        this.addToErrors(item);
      }
    }
    return (A) this;
  }
  
  public A withGenerations(List<GenerationHistory> generations) {
    if (this.generations != null) {
      this._visitables.get("generations").clear();
    }
    if (generations != null) {
        this.generations = new ArrayList();
        for (GenerationHistory item : generations) {
          this.addToGenerations(item);
        }
    } else {
      this.generations = null;
    }
    return (A) this;
  }
  
  public A withGenerations(GenerationHistory... generations) {
    if (this.generations != null) {
        this.generations.clear();
        _visitables.remove("generations");
    }
    if (generations != null) {
      for (GenerationHistory item : generations) {
        this.addToGenerations(item);
      }
    }
    return (A) this;
  }
  
  public A withReadyReplicas(Integer readyReplicas) {
    this.readyReplicas = readyReplicas;
    return (A) this;
  }
  
  public A withUpdatedReplicas(Integer updatedReplicas) {
    this.updatedReplicas = updatedReplicas;
    return (A) this;
  }
  
  public A withVersion(String version) {
    this.version = version;
    return (A) this;
  }
  public class GenerationsNested<N> extends GenerationHistoryFluent<GenerationsNested<N>> implements Nested<N>{
  
    GenerationHistoryBuilder builder;
    int index;
  
    GenerationsNested(int index,GenerationHistory item) {
      this.index = index;
      this.builder = new GenerationHistoryBuilder(this, item);
    }
  
    public N and() {
      return (N) VersionAvailabilityFluent.this.setToGenerations(index, builder.build());
    }
    
    public N endGeneration() {
      return and();
    }
    
  }
}