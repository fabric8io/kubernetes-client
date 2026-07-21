package io.fabric8.chaosmesh.v1alpha1;

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
public class PodSelectorSpecFluent<A extends io.fabric8.chaosmesh.v1alpha1.PodSelectorSpecFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private Map<String,String> annotationSelectors;
  private Map<String,String> fieldSelectors;
  private Map<String,String> labelSelectors;
  private List<String> namespaces = new ArrayList<String>();
  private Map<String,String> nodeSelectors;
  private List<String> nodes = new ArrayList<String>();
  private List<String> podPhaseSelectors = new ArrayList<String>();
  private Map<String,List<String>> pods;

  public PodSelectorSpecFluent() {
  }
  
  public PodSelectorSpecFluent(PodSelectorSpec instance) {
    this.copyInstance(instance);
  }

  public A addAllToNamespaces(Collection<String> items) {
    if (this.namespaces == null) {
      this.namespaces = new ArrayList();
    }
    for (String item : items) {
      this.namespaces.add(item);
    }
    return (A) this;
  }
  
  public A addAllToNodes(Collection<String> items) {
    if (this.nodes == null) {
      this.nodes = new ArrayList();
    }
    for (String item : items) {
      this.nodes.add(item);
    }
    return (A) this;
  }
  
  public A addAllToPodPhaseSelectors(Collection<String> items) {
    if (this.podPhaseSelectors == null) {
      this.podPhaseSelectors = new ArrayList();
    }
    for (String item : items) {
      this.podPhaseSelectors.add(item);
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
  
  public A addToAnnotationSelectors(Map<String,String> map) {
    if (this.annotationSelectors == null && map != null) {
      this.annotationSelectors = new LinkedHashMap();
    }
    if (map != null) {
      this.annotationSelectors.putAll(map);
    }
    return (A) this;
  }
  
  public A addToAnnotationSelectors(String key,String value) {
    if (this.annotationSelectors == null && key != null && value != null) {
      this.annotationSelectors = new LinkedHashMap();
    }
    if (key != null && value != null) {
      this.annotationSelectors.put(key, value);
    }
    return (A) this;
  }
  
  public A addToFieldSelectors(Map<String,String> map) {
    if (this.fieldSelectors == null && map != null) {
      this.fieldSelectors = new LinkedHashMap();
    }
    if (map != null) {
      this.fieldSelectors.putAll(map);
    }
    return (A) this;
  }
  
  public A addToFieldSelectors(String key,String value) {
    if (this.fieldSelectors == null && key != null && value != null) {
      this.fieldSelectors = new LinkedHashMap();
    }
    if (key != null && value != null) {
      this.fieldSelectors.put(key, value);
    }
    return (A) this;
  }
  
  public A addToLabelSelectors(Map<String,String> map) {
    if (this.labelSelectors == null && map != null) {
      this.labelSelectors = new LinkedHashMap();
    }
    if (map != null) {
      this.labelSelectors.putAll(map);
    }
    return (A) this;
  }
  
  public A addToLabelSelectors(String key,String value) {
    if (this.labelSelectors == null && key != null && value != null) {
      this.labelSelectors = new LinkedHashMap();
    }
    if (key != null && value != null) {
      this.labelSelectors.put(key, value);
    }
    return (A) this;
  }
  
  public A addToNamespaces(String... items) {
    if (this.namespaces == null) {
      this.namespaces = new ArrayList();
    }
    for (String item : items) {
      this.namespaces.add(item);
    }
    return (A) this;
  }
  
  public A addToNamespaces(int index,String item) {
    if (this.namespaces == null) {
      this.namespaces = new ArrayList();
    }
    this.namespaces.add(index, item);
    return (A) this;
  }
  
  public A addToNodeSelectors(Map<String,String> map) {
    if (this.nodeSelectors == null && map != null) {
      this.nodeSelectors = new LinkedHashMap();
    }
    if (map != null) {
      this.nodeSelectors.putAll(map);
    }
    return (A) this;
  }
  
  public A addToNodeSelectors(String key,String value) {
    if (this.nodeSelectors == null && key != null && value != null) {
      this.nodeSelectors = new LinkedHashMap();
    }
    if (key != null && value != null) {
      this.nodeSelectors.put(key, value);
    }
    return (A) this;
  }
  
  public A addToNodes(String... items) {
    if (this.nodes == null) {
      this.nodes = new ArrayList();
    }
    for (String item : items) {
      this.nodes.add(item);
    }
    return (A) this;
  }
  
  public A addToNodes(int index,String item) {
    if (this.nodes == null) {
      this.nodes = new ArrayList();
    }
    this.nodes.add(index, item);
    return (A) this;
  }
  
  public A addToPodPhaseSelectors(String... items) {
    if (this.podPhaseSelectors == null) {
      this.podPhaseSelectors = new ArrayList();
    }
    for (String item : items) {
      this.podPhaseSelectors.add(item);
    }
    return (A) this;
  }
  
  public A addToPodPhaseSelectors(int index,String item) {
    if (this.podPhaseSelectors == null) {
      this.podPhaseSelectors = new ArrayList();
    }
    this.podPhaseSelectors.add(index, item);
    return (A) this;
  }
  
  public A addToPods(Map<String,List<String>> map) {
    if (this.pods == null && map != null) {
      this.pods = new LinkedHashMap();
    }
    if (map != null) {
      this.pods.putAll(map);
    }
    return (A) this;
  }
  
  public A addToPods(String key,List<String> value) {
    if (this.pods == null && key != null && value != null) {
      this.pods = new LinkedHashMap();
    }
    if (key != null && value != null) {
      this.pods.put(key, value);
    }
    return (A) this;
  }
  
  protected void copyInstance(PodSelectorSpec instance) {
    instance = instance != null ? instance : new PodSelectorSpec();
    if (instance != null) {
        this.withAnnotationSelectors(instance.getAnnotationSelectors());
        this.withFieldSelectors(instance.getFieldSelectors());
        this.withLabelSelectors(instance.getLabelSelectors());
        this.withNamespaces(instance.getNamespaces());
        this.withNodeSelectors(instance.getNodeSelectors());
        this.withNodes(instance.getNodes());
        this.withPodPhaseSelectors(instance.getPodPhaseSelectors());
        this.withPods(instance.getPods());
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
    PodSelectorSpecFluent that = (PodSelectorSpecFluent) o;
    if (!(Objects.equals(annotationSelectors, that.annotationSelectors))) {
      return false;
    }
    if (!(Objects.equals(fieldSelectors, that.fieldSelectors))) {
      return false;
    }
    if (!(Objects.equals(labelSelectors, that.labelSelectors))) {
      return false;
    }
    if (!(Objects.equals(namespaces, that.namespaces))) {
      return false;
    }
    if (!(Objects.equals(nodeSelectors, that.nodeSelectors))) {
      return false;
    }
    if (!(Objects.equals(nodes, that.nodes))) {
      return false;
    }
    if (!(Objects.equals(podPhaseSelectors, that.podPhaseSelectors))) {
      return false;
    }
    if (!(Objects.equals(pods, that.pods))) {
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
  
  public Map<String,String> getAnnotationSelectors() {
    return this.annotationSelectors;
  }
  
  public Map<String,String> getFieldSelectors() {
    return this.fieldSelectors;
  }
  
  public String getFirstNamespace() {
    return this.namespaces.get(0);
  }
  
  public String getFirstNode() {
    return this.nodes.get(0);
  }
  
  public String getFirstPodPhaseSelector() {
    return this.podPhaseSelectors.get(0);
  }
  
  public Map<String,String> getLabelSelectors() {
    return this.labelSelectors;
  }
  
  public String getLastNamespace() {
    return this.namespaces.get(namespaces.size() - 1);
  }
  
  public String getLastNode() {
    return this.nodes.get(nodes.size() - 1);
  }
  
  public String getLastPodPhaseSelector() {
    return this.podPhaseSelectors.get(podPhaseSelectors.size() - 1);
  }
  
  public String getMatchingNamespace(Predicate<String> predicate) {
      for (String item : namespaces) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public String getMatchingNode(Predicate<String> predicate) {
      for (String item : nodes) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public String getMatchingPodPhaseSelector(Predicate<String> predicate) {
      for (String item : podPhaseSelectors) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public String getNamespace(int index) {
    return this.namespaces.get(index);
  }
  
  public List<String> getNamespaces() {
    return this.namespaces;
  }
  
  public String getNode(int index) {
    return this.nodes.get(index);
  }
  
  public Map<String,String> getNodeSelectors() {
    return this.nodeSelectors;
  }
  
  public List<String> getNodes() {
    return this.nodes;
  }
  
  public String getPodPhaseSelector(int index) {
    return this.podPhaseSelectors.get(index);
  }
  
  public List<String> getPodPhaseSelectors() {
    return this.podPhaseSelectors;
  }
  
  public Map<String,List<String>> getPods() {
    return this.pods;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasAnnotationSelectors() {
    return this.annotationSelectors != null;
  }
  
  public boolean hasFieldSelectors() {
    return this.fieldSelectors != null;
  }
  
  public boolean hasLabelSelectors() {
    return this.labelSelectors != null;
  }
  
  public boolean hasMatchingNamespace(Predicate<String> predicate) {
      for (String item : namespaces) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingNode(Predicate<String> predicate) {
      for (String item : nodes) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingPodPhaseSelector(Predicate<String> predicate) {
      for (String item : podPhaseSelectors) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasNamespaces() {
    return this.namespaces != null && !(this.namespaces.isEmpty());
  }
  
  public boolean hasNodeSelectors() {
    return this.nodeSelectors != null;
  }
  
  public boolean hasNodes() {
    return this.nodes != null && !(this.nodes.isEmpty());
  }
  
  public boolean hasPodPhaseSelectors() {
    return this.podPhaseSelectors != null && !(this.podPhaseSelectors.isEmpty());
  }
  
  public boolean hasPods() {
    return this.pods != null;
  }
  
  public int hashCode() {
    return Objects.hash(annotationSelectors, fieldSelectors, labelSelectors, namespaces, nodeSelectors, nodes, podPhaseSelectors, pods, additionalProperties);
  }
  
  public A removeAllFromNamespaces(Collection<String> items) {
    if (this.namespaces == null) {
      return (A) this;
    }
    for (String item : items) {
      this.namespaces.remove(item);
    }
    return (A) this;
  }
  
  public A removeAllFromNodes(Collection<String> items) {
    if (this.nodes == null) {
      return (A) this;
    }
    for (String item : items) {
      this.nodes.remove(item);
    }
    return (A) this;
  }
  
  public A removeAllFromPodPhaseSelectors(Collection<String> items) {
    if (this.podPhaseSelectors == null) {
      return (A) this;
    }
    for (String item : items) {
      this.podPhaseSelectors.remove(item);
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
  
  public A removeFromAnnotationSelectors(String key) {
    if (this.annotationSelectors == null) {
      return (A) this;
    }
    if (key != null && this.annotationSelectors != null) {
      this.annotationSelectors.remove(key);
    }
    return (A) this;
  }
  
  public A removeFromAnnotationSelectors(Map<String,String> map) {
    if (this.annotationSelectors == null) {
      return (A) this;
    }
    if (map != null) {
      for (Object key : map.keySet()) {
        if (this.annotationSelectors != null) {
          this.annotationSelectors.remove(key);
        }
      }
    }
    return (A) this;
  }
  
  public A removeFromFieldSelectors(String key) {
    if (this.fieldSelectors == null) {
      return (A) this;
    }
    if (key != null && this.fieldSelectors != null) {
      this.fieldSelectors.remove(key);
    }
    return (A) this;
  }
  
  public A removeFromFieldSelectors(Map<String,String> map) {
    if (this.fieldSelectors == null) {
      return (A) this;
    }
    if (map != null) {
      for (Object key : map.keySet()) {
        if (this.fieldSelectors != null) {
          this.fieldSelectors.remove(key);
        }
      }
    }
    return (A) this;
  }
  
  public A removeFromLabelSelectors(String key) {
    if (this.labelSelectors == null) {
      return (A) this;
    }
    if (key != null && this.labelSelectors != null) {
      this.labelSelectors.remove(key);
    }
    return (A) this;
  }
  
  public A removeFromLabelSelectors(Map<String,String> map) {
    if (this.labelSelectors == null) {
      return (A) this;
    }
    if (map != null) {
      for (Object key : map.keySet()) {
        if (this.labelSelectors != null) {
          this.labelSelectors.remove(key);
        }
      }
    }
    return (A) this;
  }
  
  public A removeFromNamespaces(String... items) {
    if (this.namespaces == null) {
      return (A) this;
    }
    for (String item : items) {
      this.namespaces.remove(item);
    }
    return (A) this;
  }
  
  public A removeFromNodeSelectors(String key) {
    if (this.nodeSelectors == null) {
      return (A) this;
    }
    if (key != null && this.nodeSelectors != null) {
      this.nodeSelectors.remove(key);
    }
    return (A) this;
  }
  
  public A removeFromNodeSelectors(Map<String,String> map) {
    if (this.nodeSelectors == null) {
      return (A) this;
    }
    if (map != null) {
      for (Object key : map.keySet()) {
        if (this.nodeSelectors != null) {
          this.nodeSelectors.remove(key);
        }
      }
    }
    return (A) this;
  }
  
  public A removeFromNodes(String... items) {
    if (this.nodes == null) {
      return (A) this;
    }
    for (String item : items) {
      this.nodes.remove(item);
    }
    return (A) this;
  }
  
  public A removeFromPodPhaseSelectors(String... items) {
    if (this.podPhaseSelectors == null) {
      return (A) this;
    }
    for (String item : items) {
      this.podPhaseSelectors.remove(item);
    }
    return (A) this;
  }
  
  public A removeFromPods(String key) {
    if (this.pods == null) {
      return (A) this;
    }
    if (key != null && this.pods != null) {
      this.pods.remove(key);
    }
    return (A) this;
  }
  
  public A removeFromPods(Map<String,List<String>> map) {
    if (this.pods == null) {
      return (A) this;
    }
    if (map != null) {
      for (Object key : map.keySet()) {
        if (this.pods != null) {
          this.pods.remove(key);
        }
      }
    }
    return (A) this;
  }
  
  public A setToNamespaces(int index,String item) {
    if (this.namespaces == null) {
      this.namespaces = new ArrayList();
    }
    this.namespaces.set(index, item);
    return (A) this;
  }
  
  public A setToNodes(int index,String item) {
    if (this.nodes == null) {
      this.nodes = new ArrayList();
    }
    this.nodes.set(index, item);
    return (A) this;
  }
  
  public A setToPodPhaseSelectors(int index,String item) {
    if (this.podPhaseSelectors == null) {
      this.podPhaseSelectors = new ArrayList();
    }
    this.podPhaseSelectors.set(index, item);
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(annotationSelectors == null) && !(annotationSelectors.isEmpty())) {
        sb.append("annotationSelectors:");
        sb.append(annotationSelectors);
        sb.append(",");
    }
    if (!(fieldSelectors == null) && !(fieldSelectors.isEmpty())) {
        sb.append("fieldSelectors:");
        sb.append(fieldSelectors);
        sb.append(",");
    }
    if (!(labelSelectors == null) && !(labelSelectors.isEmpty())) {
        sb.append("labelSelectors:");
        sb.append(labelSelectors);
        sb.append(",");
    }
    if (!(namespaces == null) && !(namespaces.isEmpty())) {
        sb.append("namespaces:");
        sb.append(namespaces);
        sb.append(",");
    }
    if (!(nodeSelectors == null) && !(nodeSelectors.isEmpty())) {
        sb.append("nodeSelectors:");
        sb.append(nodeSelectors);
        sb.append(",");
    }
    if (!(nodes == null) && !(nodes.isEmpty())) {
        sb.append("nodes:");
        sb.append(nodes);
        sb.append(",");
    }
    if (!(podPhaseSelectors == null) && !(podPhaseSelectors.isEmpty())) {
        sb.append("podPhaseSelectors:");
        sb.append(podPhaseSelectors);
        sb.append(",");
    }
    if (!(pods == null) && !(pods.isEmpty())) {
        sb.append("pods:");
        sb.append(pods);
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
  
  public <K,V>A withAnnotationSelectors(Map<String,String> annotationSelectors) {
    if (annotationSelectors == null) {
      this.annotationSelectors = null;
    } else {
      this.annotationSelectors = new LinkedHashMap(annotationSelectors);
    }
    return (A) this;
  }
  
  public <K,V>A withFieldSelectors(Map<String,String> fieldSelectors) {
    if (fieldSelectors == null) {
      this.fieldSelectors = null;
    } else {
      this.fieldSelectors = new LinkedHashMap(fieldSelectors);
    }
    return (A) this;
  }
  
  public <K,V>A withLabelSelectors(Map<String,String> labelSelectors) {
    if (labelSelectors == null) {
      this.labelSelectors = null;
    } else {
      this.labelSelectors = new LinkedHashMap(labelSelectors);
    }
    return (A) this;
  }
  
  public A withNamespaces(List<String> namespaces) {
    if (namespaces != null) {
        this.namespaces = new ArrayList();
        for (String item : namespaces) {
          this.addToNamespaces(item);
        }
    } else {
      this.namespaces = null;
    }
    return (A) this;
  }
  
  public A withNamespaces(String... namespaces) {
    if (this.namespaces != null) {
        this.namespaces.clear();
        _visitables.remove("namespaces");
    }
    if (namespaces != null) {
      for (String item : namespaces) {
        this.addToNamespaces(item);
      }
    }
    return (A) this;
  }
  
  public <K,V>A withNodeSelectors(Map<String,String> nodeSelectors) {
    if (nodeSelectors == null) {
      this.nodeSelectors = null;
    } else {
      this.nodeSelectors = new LinkedHashMap(nodeSelectors);
    }
    return (A) this;
  }
  
  public A withNodes(List<String> nodes) {
    if (nodes != null) {
        this.nodes = new ArrayList();
        for (String item : nodes) {
          this.addToNodes(item);
        }
    } else {
      this.nodes = null;
    }
    return (A) this;
  }
  
  public A withNodes(String... nodes) {
    if (this.nodes != null) {
        this.nodes.clear();
        _visitables.remove("nodes");
    }
    if (nodes != null) {
      for (String item : nodes) {
        this.addToNodes(item);
      }
    }
    return (A) this;
  }
  
  public A withPodPhaseSelectors(List<String> podPhaseSelectors) {
    if (podPhaseSelectors != null) {
        this.podPhaseSelectors = new ArrayList();
        for (String item : podPhaseSelectors) {
          this.addToPodPhaseSelectors(item);
        }
    } else {
      this.podPhaseSelectors = null;
    }
    return (A) this;
  }
  
  public A withPodPhaseSelectors(String... podPhaseSelectors) {
    if (this.podPhaseSelectors != null) {
        this.podPhaseSelectors.clear();
        _visitables.remove("podPhaseSelectors");
    }
    if (podPhaseSelectors != null) {
      for (String item : podPhaseSelectors) {
        this.addToPodPhaseSelectors(item);
      }
    }
    return (A) this;
  }
  
  public <K,V>A withPods(Map<String,List<String>> pods) {
    if (pods == null) {
      this.pods = null;
    } else {
      this.pods = new LinkedHashMap(pods);
    }
    return (A) this;
  }
  
}