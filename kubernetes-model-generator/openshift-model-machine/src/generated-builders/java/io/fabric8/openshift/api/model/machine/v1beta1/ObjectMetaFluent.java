package io.fabric8.openshift.api.model.machine.v1beta1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.model.OwnerReference;
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
public class ObjectMetaFluent<A extends io.fabric8.openshift.api.model.machine.v1beta1.ObjectMetaFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private Map<String,String> annotations;
  private String generateName;
  private Map<String,String> labels;
  private String name;
  private String namespace;
  private List<OwnerReference> ownerReferences = new ArrayList<OwnerReference>();

  public ObjectMetaFluent() {
  }
  
  public ObjectMetaFluent(ObjectMeta instance) {
    this.copyInstance(instance);
  }

  public A addAllToOwnerReferences(Collection<OwnerReference> items) {
    if (this.ownerReferences == null) {
      this.ownerReferences = new ArrayList();
    }
    for (OwnerReference item : items) {
      this.ownerReferences.add(item);
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
  
  public A addToAnnotations(Map<String,String> map) {
    if (this.annotations == null && map != null) {
      this.annotations = new LinkedHashMap();
    }
    if (map != null) {
      this.annotations.putAll(map);
    }
    return (A) this;
  }
  
  public A addToAnnotations(String key,String value) {
    if (this.annotations == null && key != null && value != null) {
      this.annotations = new LinkedHashMap();
    }
    if (key != null && value != null) {
      this.annotations.put(key, value);
    }
    return (A) this;
  }
  
  public A addToLabels(Map<String,String> map) {
    if (this.labels == null && map != null) {
      this.labels = new LinkedHashMap();
    }
    if (map != null) {
      this.labels.putAll(map);
    }
    return (A) this;
  }
  
  public A addToLabels(String key,String value) {
    if (this.labels == null && key != null && value != null) {
      this.labels = new LinkedHashMap();
    }
    if (key != null && value != null) {
      this.labels.put(key, value);
    }
    return (A) this;
  }
  
  public A addToOwnerReferences(OwnerReference... items) {
    if (this.ownerReferences == null) {
      this.ownerReferences = new ArrayList();
    }
    for (OwnerReference item : items) {
      this.ownerReferences.add(item);
    }
    return (A) this;
  }
  
  public A addToOwnerReferences(int index,OwnerReference item) {
    if (this.ownerReferences == null) {
      this.ownerReferences = new ArrayList();
    }
    this.ownerReferences.add(index, item);
    return (A) this;
  }
  
  protected void copyInstance(ObjectMeta instance) {
    instance = instance != null ? instance : new ObjectMeta();
    if (instance != null) {
        this.withAnnotations(instance.getAnnotations());
        this.withGenerateName(instance.getGenerateName());
        this.withLabels(instance.getLabels());
        this.withName(instance.getName());
        this.withNamespace(instance.getNamespace());
        this.withOwnerReferences(instance.getOwnerReferences());
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
    ObjectMetaFluent that = (ObjectMetaFluent) o;
    if (!(Objects.equals(annotations, that.annotations))) {
      return false;
    }
    if (!(Objects.equals(generateName, that.generateName))) {
      return false;
    }
    if (!(Objects.equals(labels, that.labels))) {
      return false;
    }
    if (!(Objects.equals(name, that.name))) {
      return false;
    }
    if (!(Objects.equals(namespace, that.namespace))) {
      return false;
    }
    if (!(Objects.equals(ownerReferences, that.ownerReferences))) {
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
  
  public Map<String,String> getAnnotations() {
    return this.annotations;
  }
  
  public OwnerReference getFirstOwnerReference() {
    return this.ownerReferences.get(0);
  }
  
  public String getGenerateName() {
    return this.generateName;
  }
  
  public Map<String,String> getLabels() {
    return this.labels;
  }
  
  public OwnerReference getLastOwnerReference() {
    return this.ownerReferences.get(ownerReferences.size() - 1);
  }
  
  public OwnerReference getMatchingOwnerReference(Predicate<OwnerReference> predicate) {
      for (OwnerReference item : ownerReferences) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public String getName() {
    return this.name;
  }
  
  public String getNamespace() {
    return this.namespace;
  }
  
  public OwnerReference getOwnerReference(int index) {
    return this.ownerReferences.get(index);
  }
  
  public List<OwnerReference> getOwnerReferences() {
    return this.ownerReferences;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasAnnotations() {
    return this.annotations != null;
  }
  
  public boolean hasGenerateName() {
    return this.generateName != null;
  }
  
  public boolean hasLabels() {
    return this.labels != null;
  }
  
  public boolean hasMatchingOwnerReference(Predicate<OwnerReference> predicate) {
      for (OwnerReference item : ownerReferences) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasName() {
    return this.name != null;
  }
  
  public boolean hasNamespace() {
    return this.namespace != null;
  }
  
  public boolean hasOwnerReferences() {
    return this.ownerReferences != null && !(this.ownerReferences.isEmpty());
  }
  
  public int hashCode() {
    return Objects.hash(annotations, generateName, labels, name, namespace, ownerReferences, additionalProperties);
  }
  
  public A removeAllFromOwnerReferences(Collection<OwnerReference> items) {
    if (this.ownerReferences == null) {
      return (A) this;
    }
    for (OwnerReference item : items) {
      this.ownerReferences.remove(item);
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
  
  public A removeFromAnnotations(String key) {
    if (this.annotations == null) {
      return (A) this;
    }
    if (key != null && this.annotations != null) {
      this.annotations.remove(key);
    }
    return (A) this;
  }
  
  public A removeFromAnnotations(Map<String,String> map) {
    if (this.annotations == null) {
      return (A) this;
    }
    if (map != null) {
      for (Object key : map.keySet()) {
        if (this.annotations != null) {
          this.annotations.remove(key);
        }
      }
    }
    return (A) this;
  }
  
  public A removeFromLabels(String key) {
    if (this.labels == null) {
      return (A) this;
    }
    if (key != null && this.labels != null) {
      this.labels.remove(key);
    }
    return (A) this;
  }
  
  public A removeFromLabels(Map<String,String> map) {
    if (this.labels == null) {
      return (A) this;
    }
    if (map != null) {
      for (Object key : map.keySet()) {
        if (this.labels != null) {
          this.labels.remove(key);
        }
      }
    }
    return (A) this;
  }
  
  public A removeFromOwnerReferences(OwnerReference... items) {
    if (this.ownerReferences == null) {
      return (A) this;
    }
    for (OwnerReference item : items) {
      this.ownerReferences.remove(item);
    }
    return (A) this;
  }
  
  public A setToOwnerReferences(int index,OwnerReference item) {
    if (this.ownerReferences == null) {
      this.ownerReferences = new ArrayList();
    }
    this.ownerReferences.set(index, item);
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(annotations == null) && !(annotations.isEmpty())) {
        sb.append("annotations:");
        sb.append(annotations);
        sb.append(",");
    }
    if (!(generateName == null)) {
        sb.append("generateName:");
        sb.append(generateName);
        sb.append(",");
    }
    if (!(labels == null) && !(labels.isEmpty())) {
        sb.append("labels:");
        sb.append(labels);
        sb.append(",");
    }
    if (!(name == null)) {
        sb.append("name:");
        sb.append(name);
        sb.append(",");
    }
    if (!(namespace == null)) {
        sb.append("namespace:");
        sb.append(namespace);
        sb.append(",");
    }
    if (!(ownerReferences == null) && !(ownerReferences.isEmpty())) {
        sb.append("ownerReferences:");
        sb.append(ownerReferences);
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
  
  public <K,V>A withAnnotations(Map<String,String> annotations) {
    if (annotations == null) {
      this.annotations = null;
    } else {
      this.annotations = new LinkedHashMap(annotations);
    }
    return (A) this;
  }
  
  public A withGenerateName(String generateName) {
    this.generateName = generateName;
    return (A) this;
  }
  
  public <K,V>A withLabels(Map<String,String> labels) {
    if (labels == null) {
      this.labels = null;
    } else {
      this.labels = new LinkedHashMap(labels);
    }
    return (A) this;
  }
  
  public A withName(String name) {
    this.name = name;
    return (A) this;
  }
  
  public A withNamespace(String namespace) {
    this.namespace = namespace;
    return (A) this;
  }
  
  public A withOwnerReferences(List<OwnerReference> ownerReferences) {
    if (ownerReferences != null) {
        this.ownerReferences = new ArrayList();
        for (OwnerReference item : ownerReferences) {
          this.addToOwnerReferences(item);
        }
    } else {
      this.ownerReferences = null;
    }
    return (A) this;
  }
  
  public A withOwnerReferences(OwnerReference... ownerReferences) {
    if (this.ownerReferences != null) {
        this.ownerReferences.clear();
        _visitables.remove("ownerReferences");
    }
    if (ownerReferences != null) {
      for (OwnerReference item : ownerReferences) {
        this.addToOwnerReferences(item);
      }
    }
    return (A) this;
  }
  
}