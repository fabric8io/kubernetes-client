package io.fabric8.kubernetes.api.model.discovery.v1;

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
public class EndpointHintsFluent<A extends io.fabric8.kubernetes.api.model.discovery.v1.EndpointHintsFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private ArrayList<ForNodeBuilder> forNodes = new ArrayList<ForNodeBuilder>();
  private ArrayList<ForZoneBuilder> forZones = new ArrayList<ForZoneBuilder>();

  public EndpointHintsFluent() {
  }
  
  public EndpointHintsFluent(EndpointHints instance) {
    this.copyInstance(instance);
  }

  public A addAllToForNodes(Collection<ForNode> items) {
    if (this.forNodes == null) {
      this.forNodes = new ArrayList();
    }
    for (ForNode item : items) {
        ForNodeBuilder builder = new ForNodeBuilder(item);
        _visitables.get("forNodes").add(builder);
        this.forNodes.add(builder);
    }
    return (A) this;
  }
  
  public A addAllToForZones(Collection<ForZone> items) {
    if (this.forZones == null) {
      this.forZones = new ArrayList();
    }
    for (ForZone item : items) {
        ForZoneBuilder builder = new ForZoneBuilder(item);
        _visitables.get("forZones").add(builder);
        this.forZones.add(builder);
    }
    return (A) this;
  }
  
  public ForNodesNested<A> addNewForNode() {
    return new ForNodesNested(-1, null);
  }
  
  public A addNewForNode(String name) {
    return (A) this.addToForNodes(new ForNode(name));
  }
  
  public ForNodesNested<A> addNewForNodeLike(ForNode item) {
    return new ForNodesNested(-1, item);
  }
  
  public ForZonesNested<A> addNewForZone() {
    return new ForZonesNested(-1, null);
  }
  
  public A addNewForZone(String name) {
    return (A) this.addToForZones(new ForZone(name));
  }
  
  public ForZonesNested<A> addNewForZoneLike(ForZone item) {
    return new ForZonesNested(-1, item);
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
  
  public A addToForNodes(ForNode... items) {
    if (this.forNodes == null) {
      this.forNodes = new ArrayList();
    }
    for (ForNode item : items) {
        ForNodeBuilder builder = new ForNodeBuilder(item);
        _visitables.get("forNodes").add(builder);
        this.forNodes.add(builder);
    }
    return (A) this;
  }
  
  public A addToForNodes(int index,ForNode item) {
    if (this.forNodes == null) {
      this.forNodes = new ArrayList();
    }
    ForNodeBuilder builder = new ForNodeBuilder(item);
    if (index < 0 || index >= forNodes.size()) {
        _visitables.get("forNodes").add(builder);
        forNodes.add(builder);
    } else {
        _visitables.get("forNodes").add(builder);
        forNodes.add(index, builder);
    }
    return (A) this;
  }
  
  public A addToForZones(ForZone... items) {
    if (this.forZones == null) {
      this.forZones = new ArrayList();
    }
    for (ForZone item : items) {
        ForZoneBuilder builder = new ForZoneBuilder(item);
        _visitables.get("forZones").add(builder);
        this.forZones.add(builder);
    }
    return (A) this;
  }
  
  public A addToForZones(int index,ForZone item) {
    if (this.forZones == null) {
      this.forZones = new ArrayList();
    }
    ForZoneBuilder builder = new ForZoneBuilder(item);
    if (index < 0 || index >= forZones.size()) {
        _visitables.get("forZones").add(builder);
        forZones.add(builder);
    } else {
        _visitables.get("forZones").add(builder);
        forZones.add(index, builder);
    }
    return (A) this;
  }
  
  public ForNode buildFirstForNode() {
    return this.forNodes.get(0).build();
  }
  
  public ForZone buildFirstForZone() {
    return this.forZones.get(0).build();
  }
  
  public ForNode buildForNode(int index) {
    return this.forNodes.get(index).build();
  }
  
  public List<ForNode> buildForNodes() {
    return this.forNodes != null ? build(forNodes) : null;
  }
  
  public ForZone buildForZone(int index) {
    return this.forZones.get(index).build();
  }
  
  public List<ForZone> buildForZones() {
    return this.forZones != null ? build(forZones) : null;
  }
  
  public ForNode buildLastForNode() {
    return this.forNodes.get(forNodes.size() - 1).build();
  }
  
  public ForZone buildLastForZone() {
    return this.forZones.get(forZones.size() - 1).build();
  }
  
  public ForNode buildMatchingForNode(Predicate<ForNodeBuilder> predicate) {
      for (ForNodeBuilder item : forNodes) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public ForZone buildMatchingForZone(Predicate<ForZoneBuilder> predicate) {
      for (ForZoneBuilder item : forZones) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  protected void copyInstance(EndpointHints instance) {
    instance = instance != null ? instance : new EndpointHints();
    if (instance != null) {
        this.withForNodes(instance.getForNodes());
        this.withForZones(instance.getForZones());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public ForNodesNested<A> editFirstForNode() {
    if (forNodes.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "forNodes"));
    }
    return this.setNewForNodeLike(0, this.buildForNode(0));
  }
  
  public ForZonesNested<A> editFirstForZone() {
    if (forZones.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "forZones"));
    }
    return this.setNewForZoneLike(0, this.buildForZone(0));
  }
  
  public ForNodesNested<A> editForNode(int index) {
    if (forNodes.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "forNodes"));
    }
    return this.setNewForNodeLike(index, this.buildForNode(index));
  }
  
  public ForZonesNested<A> editForZone(int index) {
    if (forZones.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "forZones"));
    }
    return this.setNewForZoneLike(index, this.buildForZone(index));
  }
  
  public ForNodesNested<A> editLastForNode() {
    int index = forNodes.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "forNodes"));
    }
    return this.setNewForNodeLike(index, this.buildForNode(index));
  }
  
  public ForZonesNested<A> editLastForZone() {
    int index = forZones.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "forZones"));
    }
    return this.setNewForZoneLike(index, this.buildForZone(index));
  }
  
  public ForNodesNested<A> editMatchingForNode(Predicate<ForNodeBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < forNodes.size();i++) {
      if (predicate.test(forNodes.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "forNodes"));
    }
    return this.setNewForNodeLike(index, this.buildForNode(index));
  }
  
  public ForZonesNested<A> editMatchingForZone(Predicate<ForZoneBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < forZones.size();i++) {
      if (predicate.test(forZones.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "forZones"));
    }
    return this.setNewForZoneLike(index, this.buildForZone(index));
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
    EndpointHintsFluent that = (EndpointHintsFluent) o;
    if (!(Objects.equals(forNodes, that.forNodes))) {
      return false;
    }
    if (!(Objects.equals(forZones, that.forZones))) {
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
  
  public boolean hasForNodes() {
    return this.forNodes != null && !(this.forNodes.isEmpty());
  }
  
  public boolean hasForZones() {
    return this.forZones != null && !(this.forZones.isEmpty());
  }
  
  public boolean hasMatchingForNode(Predicate<ForNodeBuilder> predicate) {
      for (ForNodeBuilder item : forNodes) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingForZone(Predicate<ForZoneBuilder> predicate) {
      for (ForZoneBuilder item : forZones) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public int hashCode() {
    return Objects.hash(forNodes, forZones, additionalProperties);
  }
  
  public A removeAllFromForNodes(Collection<ForNode> items) {
    if (this.forNodes == null) {
      return (A) this;
    }
    for (ForNode item : items) {
        ForNodeBuilder builder = new ForNodeBuilder(item);
        _visitables.get("forNodes").remove(builder);
        this.forNodes.remove(builder);
    }
    return (A) this;
  }
  
  public A removeAllFromForZones(Collection<ForZone> items) {
    if (this.forZones == null) {
      return (A) this;
    }
    for (ForZone item : items) {
        ForZoneBuilder builder = new ForZoneBuilder(item);
        _visitables.get("forZones").remove(builder);
        this.forZones.remove(builder);
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
  
  public A removeFromForNodes(ForNode... items) {
    if (this.forNodes == null) {
      return (A) this;
    }
    for (ForNode item : items) {
        ForNodeBuilder builder = new ForNodeBuilder(item);
        _visitables.get("forNodes").remove(builder);
        this.forNodes.remove(builder);
    }
    return (A) this;
  }
  
  public A removeFromForZones(ForZone... items) {
    if (this.forZones == null) {
      return (A) this;
    }
    for (ForZone item : items) {
        ForZoneBuilder builder = new ForZoneBuilder(item);
        _visitables.get("forZones").remove(builder);
        this.forZones.remove(builder);
    }
    return (A) this;
  }
  
  public A removeMatchingFromForNodes(Predicate<ForNodeBuilder> predicate) {
    if (forNodes == null) {
      return (A) this;
    }
    Iterator<ForNodeBuilder> each = forNodes.iterator();
    List visitables = _visitables.get("forNodes");
    while (each.hasNext()) {
        ForNodeBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public A removeMatchingFromForZones(Predicate<ForZoneBuilder> predicate) {
    if (forZones == null) {
      return (A) this;
    }
    Iterator<ForZoneBuilder> each = forZones.iterator();
    List visitables = _visitables.get("forZones");
    while (each.hasNext()) {
        ForZoneBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public ForNodesNested<A> setNewForNodeLike(int index,ForNode item) {
    return new ForNodesNested(index, item);
  }
  
  public ForZonesNested<A> setNewForZoneLike(int index,ForZone item) {
    return new ForZonesNested(index, item);
  }
  
  public A setToForNodes(int index,ForNode item) {
    if (this.forNodes == null) {
      this.forNodes = new ArrayList();
    }
    ForNodeBuilder builder = new ForNodeBuilder(item);
    if (index < 0 || index >= forNodes.size()) {
        _visitables.get("forNodes").add(builder);
        forNodes.add(builder);
    } else {
        _visitables.get("forNodes").add(builder);
        forNodes.set(index, builder);
    }
    return (A) this;
  }
  
  public A setToForZones(int index,ForZone item) {
    if (this.forZones == null) {
      this.forZones = new ArrayList();
    }
    ForZoneBuilder builder = new ForZoneBuilder(item);
    if (index < 0 || index >= forZones.size()) {
        _visitables.get("forZones").add(builder);
        forZones.add(builder);
    } else {
        _visitables.get("forZones").add(builder);
        forZones.set(index, builder);
    }
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(forNodes == null) && !(forNodes.isEmpty())) {
        sb.append("forNodes:");
        sb.append(forNodes);
        sb.append(",");
    }
    if (!(forZones == null) && !(forZones.isEmpty())) {
        sb.append("forZones:");
        sb.append(forZones);
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
  
  public A withForNodes(List<ForNode> forNodes) {
    if (this.forNodes != null) {
      this._visitables.get("forNodes").clear();
    }
    if (forNodes != null) {
        this.forNodes = new ArrayList();
        for (ForNode item : forNodes) {
          this.addToForNodes(item);
        }
    } else {
      this.forNodes = null;
    }
    return (A) this;
  }
  
  public A withForNodes(ForNode... forNodes) {
    if (this.forNodes != null) {
        this.forNodes.clear();
        _visitables.remove("forNodes");
    }
    if (forNodes != null) {
      for (ForNode item : forNodes) {
        this.addToForNodes(item);
      }
    }
    return (A) this;
  }
  
  public A withForZones(List<ForZone> forZones) {
    if (this.forZones != null) {
      this._visitables.get("forZones").clear();
    }
    if (forZones != null) {
        this.forZones = new ArrayList();
        for (ForZone item : forZones) {
          this.addToForZones(item);
        }
    } else {
      this.forZones = null;
    }
    return (A) this;
  }
  
  public A withForZones(ForZone... forZones) {
    if (this.forZones != null) {
        this.forZones.clear();
        _visitables.remove("forZones");
    }
    if (forZones != null) {
      for (ForZone item : forZones) {
        this.addToForZones(item);
      }
    }
    return (A) this;
  }
  public class ForNodesNested<N> extends ForNodeFluent<ForNodesNested<N>> implements Nested<N>{
  
    ForNodeBuilder builder;
    int index;
  
    ForNodesNested(int index,ForNode item) {
      this.index = index;
      this.builder = new ForNodeBuilder(this, item);
    }
  
    public N and() {
      return (N) EndpointHintsFluent.this.setToForNodes(index, builder.build());
    }
    
    public N endForNode() {
      return and();
    }
    
  }
  public class ForZonesNested<N> extends ForZoneFluent<ForZonesNested<N>> implements Nested<N>{
  
    ForZoneBuilder builder;
    int index;
  
    ForZonesNested(int index,ForZone item) {
      this.index = index;
      this.builder = new ForZoneBuilder(this, item);
    }
  
    public N and() {
      return (N) EndpointHintsFluent.this.setToForZones(index, builder.build());
    }
    
    public N endForZone() {
      return and();
    }
    
  }
}