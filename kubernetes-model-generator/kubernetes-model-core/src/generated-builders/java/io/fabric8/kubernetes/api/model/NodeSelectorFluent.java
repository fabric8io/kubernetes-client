package io.fabric8.kubernetes.api.model;

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
public class NodeSelectorFluent<A extends io.fabric8.kubernetes.api.model.NodeSelectorFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private ArrayList<NodeSelectorTermBuilder> nodeSelectorTerms = new ArrayList<NodeSelectorTermBuilder>();

  public NodeSelectorFluent() {
  }
  
  public NodeSelectorFluent(NodeSelector instance) {
    this.copyInstance(instance);
  }

  public A addAllToNodeSelectorTerms(Collection<NodeSelectorTerm> items) {
    if (this.nodeSelectorTerms == null) {
      this.nodeSelectorTerms = new ArrayList();
    }
    for (NodeSelectorTerm item : items) {
        NodeSelectorTermBuilder builder = new NodeSelectorTermBuilder(item);
        _visitables.get("nodeSelectorTerms").add(builder);
        this.nodeSelectorTerms.add(builder);
    }
    return (A) this;
  }
  
  public NodeSelectorTermsNested<A> addNewNodeSelectorTerm() {
    return new NodeSelectorTermsNested(-1, null);
  }
  
  public NodeSelectorTermsNested<A> addNewNodeSelectorTermLike(NodeSelectorTerm item) {
    return new NodeSelectorTermsNested(-1, item);
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
  
  public A addToNodeSelectorTerms(NodeSelectorTerm... items) {
    if (this.nodeSelectorTerms == null) {
      this.nodeSelectorTerms = new ArrayList();
    }
    for (NodeSelectorTerm item : items) {
        NodeSelectorTermBuilder builder = new NodeSelectorTermBuilder(item);
        _visitables.get("nodeSelectorTerms").add(builder);
        this.nodeSelectorTerms.add(builder);
    }
    return (A) this;
  }
  
  public A addToNodeSelectorTerms(int index,NodeSelectorTerm item) {
    if (this.nodeSelectorTerms == null) {
      this.nodeSelectorTerms = new ArrayList();
    }
    NodeSelectorTermBuilder builder = new NodeSelectorTermBuilder(item);
    if (index < 0 || index >= nodeSelectorTerms.size()) {
        _visitables.get("nodeSelectorTerms").add(builder);
        nodeSelectorTerms.add(builder);
    } else {
        _visitables.get("nodeSelectorTerms").add(builder);
        nodeSelectorTerms.add(index, builder);
    }
    return (A) this;
  }
  
  public NodeSelectorTerm buildFirstNodeSelectorTerm() {
    return this.nodeSelectorTerms.get(0).build();
  }
  
  public NodeSelectorTerm buildLastNodeSelectorTerm() {
    return this.nodeSelectorTerms.get(nodeSelectorTerms.size() - 1).build();
  }
  
  public NodeSelectorTerm buildMatchingNodeSelectorTerm(Predicate<NodeSelectorTermBuilder> predicate) {
      for (NodeSelectorTermBuilder item : nodeSelectorTerms) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public NodeSelectorTerm buildNodeSelectorTerm(int index) {
    return this.nodeSelectorTerms.get(index).build();
  }
  
  public List<NodeSelectorTerm> buildNodeSelectorTerms() {
    return this.nodeSelectorTerms != null ? build(nodeSelectorTerms) : null;
  }
  
  protected void copyInstance(NodeSelector instance) {
    instance = instance != null ? instance : new NodeSelector();
    if (instance != null) {
        this.withNodeSelectorTerms(instance.getNodeSelectorTerms());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public NodeSelectorTermsNested<A> editFirstNodeSelectorTerm() {
    if (nodeSelectorTerms.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "nodeSelectorTerms"));
    }
    return this.setNewNodeSelectorTermLike(0, this.buildNodeSelectorTerm(0));
  }
  
  public NodeSelectorTermsNested<A> editLastNodeSelectorTerm() {
    int index = nodeSelectorTerms.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "nodeSelectorTerms"));
    }
    return this.setNewNodeSelectorTermLike(index, this.buildNodeSelectorTerm(index));
  }
  
  public NodeSelectorTermsNested<A> editMatchingNodeSelectorTerm(Predicate<NodeSelectorTermBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < nodeSelectorTerms.size();i++) {
      if (predicate.test(nodeSelectorTerms.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "nodeSelectorTerms"));
    }
    return this.setNewNodeSelectorTermLike(index, this.buildNodeSelectorTerm(index));
  }
  
  public NodeSelectorTermsNested<A> editNodeSelectorTerm(int index) {
    if (nodeSelectorTerms.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "nodeSelectorTerms"));
    }
    return this.setNewNodeSelectorTermLike(index, this.buildNodeSelectorTerm(index));
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
    NodeSelectorFluent that = (NodeSelectorFluent) o;
    if (!(Objects.equals(nodeSelectorTerms, that.nodeSelectorTerms))) {
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
  
  public boolean hasMatchingNodeSelectorTerm(Predicate<NodeSelectorTermBuilder> predicate) {
      for (NodeSelectorTermBuilder item : nodeSelectorTerms) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasNodeSelectorTerms() {
    return this.nodeSelectorTerms != null && !(this.nodeSelectorTerms.isEmpty());
  }
  
  public int hashCode() {
    return Objects.hash(nodeSelectorTerms, additionalProperties);
  }
  
  public A removeAllFromNodeSelectorTerms(Collection<NodeSelectorTerm> items) {
    if (this.nodeSelectorTerms == null) {
      return (A) this;
    }
    for (NodeSelectorTerm item : items) {
        NodeSelectorTermBuilder builder = new NodeSelectorTermBuilder(item);
        _visitables.get("nodeSelectorTerms").remove(builder);
        this.nodeSelectorTerms.remove(builder);
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
  
  public A removeFromNodeSelectorTerms(NodeSelectorTerm... items) {
    if (this.nodeSelectorTerms == null) {
      return (A) this;
    }
    for (NodeSelectorTerm item : items) {
        NodeSelectorTermBuilder builder = new NodeSelectorTermBuilder(item);
        _visitables.get("nodeSelectorTerms").remove(builder);
        this.nodeSelectorTerms.remove(builder);
    }
    return (A) this;
  }
  
  public A removeMatchingFromNodeSelectorTerms(Predicate<NodeSelectorTermBuilder> predicate) {
    if (nodeSelectorTerms == null) {
      return (A) this;
    }
    Iterator<NodeSelectorTermBuilder> each = nodeSelectorTerms.iterator();
    List visitables = _visitables.get("nodeSelectorTerms");
    while (each.hasNext()) {
        NodeSelectorTermBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public NodeSelectorTermsNested<A> setNewNodeSelectorTermLike(int index,NodeSelectorTerm item) {
    return new NodeSelectorTermsNested(index, item);
  }
  
  public A setToNodeSelectorTerms(int index,NodeSelectorTerm item) {
    if (this.nodeSelectorTerms == null) {
      this.nodeSelectorTerms = new ArrayList();
    }
    NodeSelectorTermBuilder builder = new NodeSelectorTermBuilder(item);
    if (index < 0 || index >= nodeSelectorTerms.size()) {
        _visitables.get("nodeSelectorTerms").add(builder);
        nodeSelectorTerms.add(builder);
    } else {
        _visitables.get("nodeSelectorTerms").add(builder);
        nodeSelectorTerms.set(index, builder);
    }
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(nodeSelectorTerms == null) && !(nodeSelectorTerms.isEmpty())) {
        sb.append("nodeSelectorTerms:");
        sb.append(nodeSelectorTerms);
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
  
  public A withNodeSelectorTerms(List<NodeSelectorTerm> nodeSelectorTerms) {
    if (this.nodeSelectorTerms != null) {
      this._visitables.get("nodeSelectorTerms").clear();
    }
    if (nodeSelectorTerms != null) {
        this.nodeSelectorTerms = new ArrayList();
        for (NodeSelectorTerm item : nodeSelectorTerms) {
          this.addToNodeSelectorTerms(item);
        }
    } else {
      this.nodeSelectorTerms = null;
    }
    return (A) this;
  }
  
  public A withNodeSelectorTerms(NodeSelectorTerm... nodeSelectorTerms) {
    if (this.nodeSelectorTerms != null) {
        this.nodeSelectorTerms.clear();
        _visitables.remove("nodeSelectorTerms");
    }
    if (nodeSelectorTerms != null) {
      for (NodeSelectorTerm item : nodeSelectorTerms) {
        this.addToNodeSelectorTerms(item);
      }
    }
    return (A) this;
  }
  public class NodeSelectorTermsNested<N> extends NodeSelectorTermFluent<NodeSelectorTermsNested<N>> implements Nested<N>{
  
    NodeSelectorTermBuilder builder;
    int index;
  
    NodeSelectorTermsNested(int index,NodeSelectorTerm item) {
      this.index = index;
      this.builder = new NodeSelectorTermBuilder(this, item);
    }
  
    public N and() {
      return (N) NodeSelectorFluent.this.setToNodeSelectorTerms(index, builder.build());
    }
    
    public N endNodeSelectorTerm() {
      return and();
    }
    
  }
}