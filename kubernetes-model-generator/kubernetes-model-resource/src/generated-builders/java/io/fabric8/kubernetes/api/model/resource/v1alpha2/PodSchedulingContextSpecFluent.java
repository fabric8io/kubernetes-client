package io.fabric8.kubernetes.api.model.resource.v1alpha2;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import java.lang.Object;
import java.lang.String;
import java.lang.StringBuilder;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Predicate;

/**
 * Generated
 */
@SuppressWarnings("unchecked")
public class PodSchedulingContextSpecFluent<A extends io.fabric8.kubernetes.api.model.resource.v1alpha2.PodSchedulingContextSpecFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private List<String> potentialNodes = new ArrayList<String>();
  private String selectedNode;

  public PodSchedulingContextSpecFluent() {
  }
  
  public PodSchedulingContextSpecFluent(PodSchedulingContextSpec instance) {
    this.copyInstance(instance);
  }

  public A addAllToPotentialNodes(Collection<String> items) {
    if (this.potentialNodes == null) {
      this.potentialNodes = new ArrayList();
    }
    for (String item : items) {
      this.potentialNodes.add(item);
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
  
  public A addToPotentialNodes(String... items) {
    if (this.potentialNodes == null) {
      this.potentialNodes = new ArrayList();
    }
    for (String item : items) {
      this.potentialNodes.add(item);
    }
    return (A) this;
  }
  
  public A addToPotentialNodes(int index,String item) {
    if (this.potentialNodes == null) {
      this.potentialNodes = new ArrayList();
    }
    this.potentialNodes.add(index, item);
    return (A) this;
  }
  
  protected void copyInstance(PodSchedulingContextSpec instance) {
    instance = instance != null ? instance : new PodSchedulingContextSpec();
    if (instance != null) {
        this.withPotentialNodes(instance.getPotentialNodes());
        this.withSelectedNode(instance.getSelectedNode());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
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
    PodSchedulingContextSpecFluent that = (PodSchedulingContextSpecFluent) o;
    if (!(Objects.equals(potentialNodes, that.potentialNodes))) {
      return false;
    }
    if (!(Objects.equals(selectedNode, that.selectedNode))) {
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
  
  public String getFirstPotentialNode() {
    return this.potentialNodes.get(0);
  }
  
  public String getLastPotentialNode() {
    return this.potentialNodes.get(potentialNodes.size() - 1);
  }
  
  public String getMatchingPotentialNode(Predicate<String> predicate) {
      for (String item : potentialNodes) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public String getPotentialNode(int index) {
    return this.potentialNodes.get(index);
  }
  
  public List<String> getPotentialNodes() {
    return this.potentialNodes;
  }
  
  public String getSelectedNode() {
    return this.selectedNode;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasMatchingPotentialNode(Predicate<String> predicate) {
      for (String item : potentialNodes) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasPotentialNodes() {
    return this.potentialNodes != null && !(this.potentialNodes.isEmpty());
  }
  
  public boolean hasSelectedNode() {
    return this.selectedNode != null;
  }
  
  public int hashCode() {
    return Objects.hash(potentialNodes, selectedNode, additionalProperties);
  }
  
  public A removeAllFromPotentialNodes(Collection<String> items) {
    if (this.potentialNodes == null) {
      return (A) this;
    }
    for (String item : items) {
      this.potentialNodes.remove(item);
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
  
  public A removeFromPotentialNodes(String... items) {
    if (this.potentialNodes == null) {
      return (A) this;
    }
    for (String item : items) {
      this.potentialNodes.remove(item);
    }
    return (A) this;
  }
  
  public A setToPotentialNodes(int index,String item) {
    if (this.potentialNodes == null) {
      this.potentialNodes = new ArrayList();
    }
    this.potentialNodes.set(index, item);
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(potentialNodes == null) && !(potentialNodes.isEmpty())) {
        sb.append("potentialNodes:");
        sb.append(potentialNodes);
        sb.append(",");
    }
    if (!(selectedNode == null)) {
        sb.append("selectedNode:");
        sb.append(selectedNode);
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
  
  public A withPotentialNodes(List<String> potentialNodes) {
    if (potentialNodes != null) {
        this.potentialNodes = new ArrayList();
        for (String item : potentialNodes) {
          this.addToPotentialNodes(item);
        }
    } else {
      this.potentialNodes = null;
    }
    return (A) this;
  }
  
  public A withPotentialNodes(String... potentialNodes) {
    if (this.potentialNodes != null) {
        this.potentialNodes.clear();
        _visitables.remove("potentialNodes");
    }
    if (potentialNodes != null) {
      for (String item : potentialNodes) {
        this.addToPotentialNodes(item);
      }
    }
    return (A) this;
  }
  
  public A withSelectedNode(String selectedNode) {
    this.selectedNode = selectedNode;
    return (A) this;
  }
  
}