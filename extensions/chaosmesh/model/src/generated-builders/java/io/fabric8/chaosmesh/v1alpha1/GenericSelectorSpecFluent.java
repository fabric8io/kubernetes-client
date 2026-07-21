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
public class GenericSelectorSpecFluent<A extends io.fabric8.chaosmesh.v1alpha1.GenericSelectorSpecFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private Map<String,String> annotationSelectors;
  private Map<String,String> fieldSelectors;
  private Map<String,String> labelSelectors;
  private List<String> namespaces = new ArrayList<String>();

  public GenericSelectorSpecFluent() {
  }
  
  public GenericSelectorSpecFluent(GenericSelectorSpec instance) {
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
  
  protected void copyInstance(GenericSelectorSpec instance) {
    instance = instance != null ? instance : new GenericSelectorSpec();
    if (instance != null) {
        this.withAnnotationSelectors(instance.getAnnotationSelectors());
        this.withFieldSelectors(instance.getFieldSelectors());
        this.withLabelSelectors(instance.getLabelSelectors());
        this.withNamespaces(instance.getNamespaces());
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
    GenericSelectorSpecFluent that = (GenericSelectorSpecFluent) o;
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
  
  public Map<String,String> getLabelSelectors() {
    return this.labelSelectors;
  }
  
  public String getLastNamespace() {
    return this.namespaces.get(namespaces.size() - 1);
  }
  
  public String getMatchingNamespace(Predicate<String> predicate) {
      for (String item : namespaces) {
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
  
  public boolean hasNamespaces() {
    return this.namespaces != null && !(this.namespaces.isEmpty());
  }
  
  public int hashCode() {
    return Objects.hash(annotationSelectors, fieldSelectors, labelSelectors, namespaces, additionalProperties);
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
  
  public A setToNamespaces(int index,String item) {
    if (this.namespaces == null) {
      this.namespaces = new ArrayList();
    }
    this.namespaces.set(index, item);
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
  
}