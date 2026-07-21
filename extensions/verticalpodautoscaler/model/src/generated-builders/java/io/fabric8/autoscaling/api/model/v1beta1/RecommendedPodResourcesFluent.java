package io.fabric8.autoscaling.api.model.v1beta1;

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
public class RecommendedPodResourcesFluent<A extends io.fabric8.autoscaling.api.model.v1beta1.RecommendedPodResourcesFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private ArrayList<RecommendedContainerResourcesBuilder> containerRecommendations = new ArrayList<RecommendedContainerResourcesBuilder>();

  public RecommendedPodResourcesFluent() {
  }
  
  public RecommendedPodResourcesFluent(RecommendedPodResources instance) {
    this.copyInstance(instance);
  }

  public A addAllToContainerRecommendations(Collection<RecommendedContainerResources> items) {
    if (this.containerRecommendations == null) {
      this.containerRecommendations = new ArrayList();
    }
    for (RecommendedContainerResources item : items) {
        RecommendedContainerResourcesBuilder builder = new RecommendedContainerResourcesBuilder(item);
        _visitables.get("containerRecommendations").add(builder);
        this.containerRecommendations.add(builder);
    }
    return (A) this;
  }
  
  public ContainerRecommendationsNested<A> addNewContainerRecommendation() {
    return new ContainerRecommendationsNested(-1, null);
  }
  
  public ContainerRecommendationsNested<A> addNewContainerRecommendationLike(RecommendedContainerResources item) {
    return new ContainerRecommendationsNested(-1, item);
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
  
  public A addToContainerRecommendations(RecommendedContainerResources... items) {
    if (this.containerRecommendations == null) {
      this.containerRecommendations = new ArrayList();
    }
    for (RecommendedContainerResources item : items) {
        RecommendedContainerResourcesBuilder builder = new RecommendedContainerResourcesBuilder(item);
        _visitables.get("containerRecommendations").add(builder);
        this.containerRecommendations.add(builder);
    }
    return (A) this;
  }
  
  public A addToContainerRecommendations(int index,RecommendedContainerResources item) {
    if (this.containerRecommendations == null) {
      this.containerRecommendations = new ArrayList();
    }
    RecommendedContainerResourcesBuilder builder = new RecommendedContainerResourcesBuilder(item);
    if (index < 0 || index >= containerRecommendations.size()) {
        _visitables.get("containerRecommendations").add(builder);
        containerRecommendations.add(builder);
    } else {
        _visitables.get("containerRecommendations").add(builder);
        containerRecommendations.add(index, builder);
    }
    return (A) this;
  }
  
  public RecommendedContainerResources buildContainerRecommendation(int index) {
    return this.containerRecommendations.get(index).build();
  }
  
  public List<RecommendedContainerResources> buildContainerRecommendations() {
    return this.containerRecommendations != null ? build(containerRecommendations) : null;
  }
  
  public RecommendedContainerResources buildFirstContainerRecommendation() {
    return this.containerRecommendations.get(0).build();
  }
  
  public RecommendedContainerResources buildLastContainerRecommendation() {
    return this.containerRecommendations.get(containerRecommendations.size() - 1).build();
  }
  
  public RecommendedContainerResources buildMatchingContainerRecommendation(Predicate<RecommendedContainerResourcesBuilder> predicate) {
      for (RecommendedContainerResourcesBuilder item : containerRecommendations) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  protected void copyInstance(RecommendedPodResources instance) {
    instance = instance != null ? instance : new RecommendedPodResources();
    if (instance != null) {
        this.withContainerRecommendations(instance.getContainerRecommendations());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public ContainerRecommendationsNested<A> editContainerRecommendation(int index) {
    if (containerRecommendations.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "containerRecommendations"));
    }
    return this.setNewContainerRecommendationLike(index, this.buildContainerRecommendation(index));
  }
  
  public ContainerRecommendationsNested<A> editFirstContainerRecommendation() {
    if (containerRecommendations.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "containerRecommendations"));
    }
    return this.setNewContainerRecommendationLike(0, this.buildContainerRecommendation(0));
  }
  
  public ContainerRecommendationsNested<A> editLastContainerRecommendation() {
    int index = containerRecommendations.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "containerRecommendations"));
    }
    return this.setNewContainerRecommendationLike(index, this.buildContainerRecommendation(index));
  }
  
  public ContainerRecommendationsNested<A> editMatchingContainerRecommendation(Predicate<RecommendedContainerResourcesBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < containerRecommendations.size();i++) {
      if (predicate.test(containerRecommendations.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "containerRecommendations"));
    }
    return this.setNewContainerRecommendationLike(index, this.buildContainerRecommendation(index));
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
    RecommendedPodResourcesFluent that = (RecommendedPodResourcesFluent) o;
    if (!(Objects.equals(containerRecommendations, that.containerRecommendations))) {
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
  
  public boolean hasContainerRecommendations() {
    return this.containerRecommendations != null && !(this.containerRecommendations.isEmpty());
  }
  
  public boolean hasMatchingContainerRecommendation(Predicate<RecommendedContainerResourcesBuilder> predicate) {
      for (RecommendedContainerResourcesBuilder item : containerRecommendations) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public int hashCode() {
    return Objects.hash(containerRecommendations, additionalProperties);
  }
  
  public A removeAllFromContainerRecommendations(Collection<RecommendedContainerResources> items) {
    if (this.containerRecommendations == null) {
      return (A) this;
    }
    for (RecommendedContainerResources item : items) {
        RecommendedContainerResourcesBuilder builder = new RecommendedContainerResourcesBuilder(item);
        _visitables.get("containerRecommendations").remove(builder);
        this.containerRecommendations.remove(builder);
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
  
  public A removeFromContainerRecommendations(RecommendedContainerResources... items) {
    if (this.containerRecommendations == null) {
      return (A) this;
    }
    for (RecommendedContainerResources item : items) {
        RecommendedContainerResourcesBuilder builder = new RecommendedContainerResourcesBuilder(item);
        _visitables.get("containerRecommendations").remove(builder);
        this.containerRecommendations.remove(builder);
    }
    return (A) this;
  }
  
  public A removeMatchingFromContainerRecommendations(Predicate<RecommendedContainerResourcesBuilder> predicate) {
    if (containerRecommendations == null) {
      return (A) this;
    }
    Iterator<RecommendedContainerResourcesBuilder> each = containerRecommendations.iterator();
    List visitables = _visitables.get("containerRecommendations");
    while (each.hasNext()) {
        RecommendedContainerResourcesBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public ContainerRecommendationsNested<A> setNewContainerRecommendationLike(int index,RecommendedContainerResources item) {
    return new ContainerRecommendationsNested(index, item);
  }
  
  public A setToContainerRecommendations(int index,RecommendedContainerResources item) {
    if (this.containerRecommendations == null) {
      this.containerRecommendations = new ArrayList();
    }
    RecommendedContainerResourcesBuilder builder = new RecommendedContainerResourcesBuilder(item);
    if (index < 0 || index >= containerRecommendations.size()) {
        _visitables.get("containerRecommendations").add(builder);
        containerRecommendations.add(builder);
    } else {
        _visitables.get("containerRecommendations").add(builder);
        containerRecommendations.set(index, builder);
    }
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(containerRecommendations == null) && !(containerRecommendations.isEmpty())) {
        sb.append("containerRecommendations:");
        sb.append(containerRecommendations);
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
  
  public A withContainerRecommendations(List<RecommendedContainerResources> containerRecommendations) {
    if (this.containerRecommendations != null) {
      this._visitables.get("containerRecommendations").clear();
    }
    if (containerRecommendations != null) {
        this.containerRecommendations = new ArrayList();
        for (RecommendedContainerResources item : containerRecommendations) {
          this.addToContainerRecommendations(item);
        }
    } else {
      this.containerRecommendations = null;
    }
    return (A) this;
  }
  
  public A withContainerRecommendations(RecommendedContainerResources... containerRecommendations) {
    if (this.containerRecommendations != null) {
        this.containerRecommendations.clear();
        _visitables.remove("containerRecommendations");
    }
    if (containerRecommendations != null) {
      for (RecommendedContainerResources item : containerRecommendations) {
        this.addToContainerRecommendations(item);
      }
    }
    return (A) this;
  }
  public class ContainerRecommendationsNested<N> extends RecommendedContainerResourcesFluent<ContainerRecommendationsNested<N>> implements Nested<N>{
  
    RecommendedContainerResourcesBuilder builder;
    int index;
  
    ContainerRecommendationsNested(int index,RecommendedContainerResources item) {
      this.index = index;
      this.builder = new RecommendedContainerResourcesBuilder(this, item);
    }
  
    public N and() {
      return (N) RecommendedPodResourcesFluent.this.setToContainerRecommendations(index, builder.build());
    }
    
    public N endContainerRecommendation() {
      return and();
    }
    
  }
}