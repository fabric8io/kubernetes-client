package io.fabric8.openshift.api.model;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import io.fabric8.kubernetes.api.model.LabelSelector;
import io.fabric8.kubernetes.api.model.LabelSelectorBuilder;
import io.fabric8.kubernetes.api.model.LabelSelectorFluent;
import java.lang.Object;
import java.lang.String;
import java.lang.StringBuilder;
import java.lang.SuppressWarnings;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

/**
 * Generated
 */
@SuppressWarnings("unchecked")
public class ClusterResourceQuotaSelectorFluent<A extends io.fabric8.openshift.api.model.ClusterResourceQuotaSelectorFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private Map<String,String> annotations;
  private LabelSelectorBuilder labels;

  public ClusterResourceQuotaSelectorFluent() {
  }
  
  public ClusterResourceQuotaSelectorFluent(ClusterResourceQuotaSelector instance) {
    this.copyInstance(instance);
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
  
  public LabelSelector buildLabels() {
    return this.labels != null ? this.labels.build() : null;
  }
  
  protected void copyInstance(ClusterResourceQuotaSelector instance) {
    instance = instance != null ? instance : new ClusterResourceQuotaSelector();
    if (instance != null) {
        this.withAnnotations(instance.getAnnotations());
        this.withLabels(instance.getLabels());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public LabelsNested<A> editLabels() {
    return this.withNewLabelsLike(Optional.ofNullable(this.buildLabels()).orElse(null));
  }
  
  public LabelsNested<A> editOrNewLabels() {
    return this.withNewLabelsLike(Optional.ofNullable(this.buildLabels()).orElse(new LabelSelectorBuilder().build()));
  }
  
  public LabelsNested<A> editOrNewLabelsLike(LabelSelector item) {
    return this.withNewLabelsLike(Optional.ofNullable(this.buildLabels()).orElse(item));
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
    ClusterResourceQuotaSelectorFluent that = (ClusterResourceQuotaSelectorFluent) o;
    if (!(Objects.equals(annotations, that.annotations))) {
      return false;
    }
    if (!(Objects.equals(labels, that.labels))) {
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
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasAnnotations() {
    return this.annotations != null;
  }
  
  public boolean hasLabels() {
    return this.labels != null;
  }
  
  public int hashCode() {
    return Objects.hash(annotations, labels, additionalProperties);
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
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(annotations == null) && !(annotations.isEmpty())) {
        sb.append("annotations:");
        sb.append(annotations);
        sb.append(",");
    }
    if (!(labels == null)) {
        sb.append("labels:");
        sb.append(labels);
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
  
  public A withLabels(LabelSelector labels) {
    this._visitables.remove("labels");
    if (labels != null) {
        this.labels = new LabelSelectorBuilder(labels);
        this._visitables.get("labels").add(this.labels);
    } else {
        this.labels = null;
        this._visitables.get("labels").remove(this.labels);
    }
    return (A) this;
  }
  
  public LabelsNested<A> withNewLabels() {
    return new LabelsNested(null);
  }
  
  public LabelsNested<A> withNewLabelsLike(LabelSelector item) {
    return new LabelsNested(item);
  }
  public class LabelsNested<N> extends LabelSelectorFluent<LabelsNested<N>> implements Nested<N>{
  
    LabelSelectorBuilder builder;
  
    LabelsNested(LabelSelector item) {
      this.builder = new LabelSelectorBuilder(this, item);
    }
  
    public N and() {
      return (N) ClusterResourceQuotaSelectorFluent.this.withLabels(builder.build());
    }
    
    public N endLabels() {
      return and();
    }
    
  }
}