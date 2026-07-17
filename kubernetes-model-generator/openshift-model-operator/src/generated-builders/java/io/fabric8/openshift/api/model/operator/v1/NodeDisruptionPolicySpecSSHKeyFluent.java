package io.fabric8.openshift.api.model.operator.v1;

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
public class NodeDisruptionPolicySpecSSHKeyFluent<A extends io.fabric8.openshift.api.model.operator.v1.NodeDisruptionPolicySpecSSHKeyFluent<A>> extends BaseFluent<A>{

  private ArrayList<NodeDisruptionPolicySpecActionBuilder> actions = new ArrayList<NodeDisruptionPolicySpecActionBuilder>();
  private Map<String,Object> additionalProperties;

  public NodeDisruptionPolicySpecSSHKeyFluent() {
  }
  
  public NodeDisruptionPolicySpecSSHKeyFluent(NodeDisruptionPolicySpecSSHKey instance) {
    this.copyInstance(instance);
  }

  public A addAllToActions(Collection<NodeDisruptionPolicySpecAction> items) {
    if (this.actions == null) {
      this.actions = new ArrayList();
    }
    for (NodeDisruptionPolicySpecAction item : items) {
        NodeDisruptionPolicySpecActionBuilder builder = new NodeDisruptionPolicySpecActionBuilder(item);
        _visitables.get("actions").add(builder);
        this.actions.add(builder);
    }
    return (A) this;
  }
  
  public ActionsNested<A> addNewAction() {
    return new ActionsNested(-1, null);
  }
  
  public ActionsNested<A> addNewActionLike(NodeDisruptionPolicySpecAction item) {
    return new ActionsNested(-1, item);
  }
  
  public A addToActions(NodeDisruptionPolicySpecAction... items) {
    if (this.actions == null) {
      this.actions = new ArrayList();
    }
    for (NodeDisruptionPolicySpecAction item : items) {
        NodeDisruptionPolicySpecActionBuilder builder = new NodeDisruptionPolicySpecActionBuilder(item);
        _visitables.get("actions").add(builder);
        this.actions.add(builder);
    }
    return (A) this;
  }
  
  public A addToActions(int index,NodeDisruptionPolicySpecAction item) {
    if (this.actions == null) {
      this.actions = new ArrayList();
    }
    NodeDisruptionPolicySpecActionBuilder builder = new NodeDisruptionPolicySpecActionBuilder(item);
    if (index < 0 || index >= actions.size()) {
        _visitables.get("actions").add(builder);
        actions.add(builder);
    } else {
        _visitables.get("actions").add(builder);
        actions.add(index, builder);
    }
    return (A) this;
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
  
  public NodeDisruptionPolicySpecAction buildAction(int index) {
    return this.actions.get(index).build();
  }
  
  public List<NodeDisruptionPolicySpecAction> buildActions() {
    return this.actions != null ? build(actions) : null;
  }
  
  public NodeDisruptionPolicySpecAction buildFirstAction() {
    return this.actions.get(0).build();
  }
  
  public NodeDisruptionPolicySpecAction buildLastAction() {
    return this.actions.get(actions.size() - 1).build();
  }
  
  public NodeDisruptionPolicySpecAction buildMatchingAction(Predicate<NodeDisruptionPolicySpecActionBuilder> predicate) {
      for (NodeDisruptionPolicySpecActionBuilder item : actions) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  protected void copyInstance(NodeDisruptionPolicySpecSSHKey instance) {
    instance = instance != null ? instance : new NodeDisruptionPolicySpecSSHKey();
    if (instance != null) {
        this.withActions(instance.getActions());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public ActionsNested<A> editAction(int index) {
    if (actions.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "actions"));
    }
    return this.setNewActionLike(index, this.buildAction(index));
  }
  
  public ActionsNested<A> editFirstAction() {
    if (actions.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "actions"));
    }
    return this.setNewActionLike(0, this.buildAction(0));
  }
  
  public ActionsNested<A> editLastAction() {
    int index = actions.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "actions"));
    }
    return this.setNewActionLike(index, this.buildAction(index));
  }
  
  public ActionsNested<A> editMatchingAction(Predicate<NodeDisruptionPolicySpecActionBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < actions.size();i++) {
      if (predicate.test(actions.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "actions"));
    }
    return this.setNewActionLike(index, this.buildAction(index));
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
    NodeDisruptionPolicySpecSSHKeyFluent that = (NodeDisruptionPolicySpecSSHKeyFluent) o;
    if (!(Objects.equals(actions, that.actions))) {
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
  
  public boolean hasActions() {
    return this.actions != null && !(this.actions.isEmpty());
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasMatchingAction(Predicate<NodeDisruptionPolicySpecActionBuilder> predicate) {
      for (NodeDisruptionPolicySpecActionBuilder item : actions) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public int hashCode() {
    return Objects.hash(actions, additionalProperties);
  }
  
  public A removeAllFromActions(Collection<NodeDisruptionPolicySpecAction> items) {
    if (this.actions == null) {
      return (A) this;
    }
    for (NodeDisruptionPolicySpecAction item : items) {
        NodeDisruptionPolicySpecActionBuilder builder = new NodeDisruptionPolicySpecActionBuilder(item);
        _visitables.get("actions").remove(builder);
        this.actions.remove(builder);
    }
    return (A) this;
  }
  
  public A removeFromActions(NodeDisruptionPolicySpecAction... items) {
    if (this.actions == null) {
      return (A) this;
    }
    for (NodeDisruptionPolicySpecAction item : items) {
        NodeDisruptionPolicySpecActionBuilder builder = new NodeDisruptionPolicySpecActionBuilder(item);
        _visitables.get("actions").remove(builder);
        this.actions.remove(builder);
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
  
  public A removeMatchingFromActions(Predicate<NodeDisruptionPolicySpecActionBuilder> predicate) {
    if (actions == null) {
      return (A) this;
    }
    Iterator<NodeDisruptionPolicySpecActionBuilder> each = actions.iterator();
    List visitables = _visitables.get("actions");
    while (each.hasNext()) {
        NodeDisruptionPolicySpecActionBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public ActionsNested<A> setNewActionLike(int index,NodeDisruptionPolicySpecAction item) {
    return new ActionsNested(index, item);
  }
  
  public A setToActions(int index,NodeDisruptionPolicySpecAction item) {
    if (this.actions == null) {
      this.actions = new ArrayList();
    }
    NodeDisruptionPolicySpecActionBuilder builder = new NodeDisruptionPolicySpecActionBuilder(item);
    if (index < 0 || index >= actions.size()) {
        _visitables.get("actions").add(builder);
        actions.add(builder);
    } else {
        _visitables.get("actions").add(builder);
        actions.set(index, builder);
    }
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(actions == null) && !(actions.isEmpty())) {
        sb.append("actions:");
        sb.append(actions);
        sb.append(",");
    }
    if (!(additionalProperties == null) && !(additionalProperties.isEmpty())) {
        sb.append("additionalProperties:");
        sb.append(additionalProperties);
    }
    sb.append("}");
    return sb.toString();
  }
  
  public A withActions(List<NodeDisruptionPolicySpecAction> actions) {
    if (this.actions != null) {
      this._visitables.get("actions").clear();
    }
    if (actions != null) {
        this.actions = new ArrayList();
        for (NodeDisruptionPolicySpecAction item : actions) {
          this.addToActions(item);
        }
    } else {
      this.actions = null;
    }
    return (A) this;
  }
  
  public A withActions(NodeDisruptionPolicySpecAction... actions) {
    if (this.actions != null) {
        this.actions.clear();
        _visitables.remove("actions");
    }
    if (actions != null) {
      for (NodeDisruptionPolicySpecAction item : actions) {
        this.addToActions(item);
      }
    }
    return (A) this;
  }
  
  public <K,V>A withAdditionalProperties(Map<String,Object> additionalProperties) {
    if (additionalProperties == null) {
      this.additionalProperties = null;
    } else {
      this.additionalProperties = new LinkedHashMap(additionalProperties);
    }
    return (A) this;
  }
  public class ActionsNested<N> extends NodeDisruptionPolicySpecActionFluent<ActionsNested<N>> implements Nested<N>{
  
    NodeDisruptionPolicySpecActionBuilder builder;
    int index;
  
    ActionsNested(int index,NodeDisruptionPolicySpecAction item) {
      this.index = index;
      this.builder = new NodeDisruptionPolicySpecActionBuilder(this, item);
    }
  
    public N and() {
      return (N) NodeDisruptionPolicySpecSSHKeyFluent.this.setToActions(index, builder.build());
    }
    
    public N endAction() {
      return and();
    }
    
  }
}