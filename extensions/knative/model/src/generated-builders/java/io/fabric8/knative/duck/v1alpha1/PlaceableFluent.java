package io.fabric8.knative.duck.v1alpha1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
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
import java.util.function.Predicate;

/**
 * Generated
 */
@SuppressWarnings("unchecked")
public class PlaceableFluent<A extends io.fabric8.knative.duck.v1alpha1.PlaceableFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private Integer maxAllowedVReplicas;
  private ArrayList<PlacementBuilder> placements = new ArrayList<PlacementBuilder>();

  public PlaceableFluent() {
  }
  
  public PlaceableFluent(Placeable instance) {
    this.copyInstance(instance);
  }

  public A addAllToPlacements(Collection<Placement> items) {
    if (this.placements == null) {
      this.placements = new ArrayList();
    }
    for (Placement item : items) {
        PlacementBuilder builder = new PlacementBuilder(item);
        _visitables.get("placements").add(builder);
        this.placements.add(builder);
    }
    return (A) this;
  }
  
  public PlacementsNested<A> addNewPlacement() {
    return new PlacementsNested(-1, null);
  }
  
  public A addNewPlacement(String podName,Integer vreplicas) {
    return (A) this.addToPlacements(new Placement(podName, vreplicas));
  }
  
  public PlacementsNested<A> addNewPlacementLike(Placement item) {
    return new PlacementsNested(-1, item);
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
  
  public A addToPlacements(Placement... items) {
    if (this.placements == null) {
      this.placements = new ArrayList();
    }
    for (Placement item : items) {
        PlacementBuilder builder = new PlacementBuilder(item);
        _visitables.get("placements").add(builder);
        this.placements.add(builder);
    }
    return (A) this;
  }
  
  public A addToPlacements(int index,Placement item) {
    if (this.placements == null) {
      this.placements = new ArrayList();
    }
    PlacementBuilder builder = new PlacementBuilder(item);
    if (index < 0 || index >= placements.size()) {
        _visitables.get("placements").add(builder);
        placements.add(builder);
    } else {
        _visitables.get("placements").add(builder);
        placements.add(index, builder);
    }
    return (A) this;
  }
  
  public Placement buildFirstPlacement() {
    return this.placements.get(0).build();
  }
  
  public Placement buildLastPlacement() {
    return this.placements.get(placements.size() - 1).build();
  }
  
  public Placement buildMatchingPlacement(Predicate<PlacementBuilder> predicate) {
      for (PlacementBuilder item : placements) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public Placement buildPlacement(int index) {
    return this.placements.get(index).build();
  }
  
  public List<Placement> buildPlacements() {
    return this.placements != null ? build(placements) : null;
  }
  
  protected void copyInstance(Placeable instance) {
    instance = instance != null ? instance : new Placeable();
    if (instance != null) {
        this.withMaxAllowedVReplicas(instance.getMaxAllowedVReplicas());
        this.withPlacements(instance.getPlacements());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public PlacementsNested<A> editFirstPlacement() {
    if (placements.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "placements"));
    }
    return this.setNewPlacementLike(0, this.buildPlacement(0));
  }
  
  public PlacementsNested<A> editLastPlacement() {
    int index = placements.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "placements"));
    }
    return this.setNewPlacementLike(index, this.buildPlacement(index));
  }
  
  public PlacementsNested<A> editMatchingPlacement(Predicate<PlacementBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < placements.size();i++) {
      if (predicate.test(placements.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "placements"));
    }
    return this.setNewPlacementLike(index, this.buildPlacement(index));
  }
  
  public PlacementsNested<A> editPlacement(int index) {
    if (placements.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "placements"));
    }
    return this.setNewPlacementLike(index, this.buildPlacement(index));
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
    PlaceableFluent that = (PlaceableFluent) o;
    if (!(Objects.equals(maxAllowedVReplicas, that.maxAllowedVReplicas))) {
      return false;
    }
    if (!(Objects.equals(placements, that.placements))) {
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
  
  public Integer getMaxAllowedVReplicas() {
    return this.maxAllowedVReplicas;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasMatchingPlacement(Predicate<PlacementBuilder> predicate) {
      for (PlacementBuilder item : placements) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMaxAllowedVReplicas() {
    return this.maxAllowedVReplicas != null;
  }
  
  public boolean hasPlacements() {
    return this.placements != null && !(this.placements.isEmpty());
  }
  
  public int hashCode() {
    return Objects.hash(maxAllowedVReplicas, placements, additionalProperties);
  }
  
  public A removeAllFromPlacements(Collection<Placement> items) {
    if (this.placements == null) {
      return (A) this;
    }
    for (Placement item : items) {
        PlacementBuilder builder = new PlacementBuilder(item);
        _visitables.get("placements").remove(builder);
        this.placements.remove(builder);
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
  
  public A removeFromPlacements(Placement... items) {
    if (this.placements == null) {
      return (A) this;
    }
    for (Placement item : items) {
        PlacementBuilder builder = new PlacementBuilder(item);
        _visitables.get("placements").remove(builder);
        this.placements.remove(builder);
    }
    return (A) this;
  }
  
  public A removeMatchingFromPlacements(Predicate<PlacementBuilder> predicate) {
    if (placements == null) {
      return (A) this;
    }
    Iterator<PlacementBuilder> each = placements.iterator();
    List visitables = _visitables.get("placements");
    while (each.hasNext()) {
        PlacementBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public PlacementsNested<A> setNewPlacementLike(int index,Placement item) {
    return new PlacementsNested(index, item);
  }
  
  public A setToPlacements(int index,Placement item) {
    if (this.placements == null) {
      this.placements = new ArrayList();
    }
    PlacementBuilder builder = new PlacementBuilder(item);
    if (index < 0 || index >= placements.size()) {
        _visitables.get("placements").add(builder);
        placements.add(builder);
    } else {
        _visitables.get("placements").add(builder);
        placements.set(index, builder);
    }
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(maxAllowedVReplicas == null)) {
        sb.append("maxAllowedVReplicas:");
        sb.append(maxAllowedVReplicas);
        sb.append(",");
    }
    if (!(placements == null) && !(placements.isEmpty())) {
        sb.append("placements:");
        sb.append(placements);
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
  
  public A withMaxAllowedVReplicas(Integer maxAllowedVReplicas) {
    this.maxAllowedVReplicas = maxAllowedVReplicas;
    return (A) this;
  }
  
  public A withPlacements(List<Placement> placements) {
    if (this.placements != null) {
      this._visitables.get("placements").clear();
    }
    if (placements != null) {
        this.placements = new ArrayList();
        for (Placement item : placements) {
          this.addToPlacements(item);
        }
    } else {
      this.placements = null;
    }
    return (A) this;
  }
  
  public A withPlacements(Placement... placements) {
    if (this.placements != null) {
        this.placements.clear();
        _visitables.remove("placements");
    }
    if (placements != null) {
      for (Placement item : placements) {
        this.addToPlacements(item);
      }
    }
    return (A) this;
  }
  public class PlacementsNested<N> extends PlacementFluent<PlacementsNested<N>> implements Nested<N>{
  
    PlacementBuilder builder;
    int index;
  
    PlacementsNested(int index,Placement item) {
      this.index = index;
      this.builder = new PlacementBuilder(this, item);
    }
  
    public N and() {
      return (N) PlaceableFluent.this.setToPlacements(index, builder.build());
    }
    
    public N endPlacement() {
      return and();
    }
    
  }
}