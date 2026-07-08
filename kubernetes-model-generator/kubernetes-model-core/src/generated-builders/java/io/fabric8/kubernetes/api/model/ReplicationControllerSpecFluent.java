package io.fabric8.kubernetes.api.model;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import java.lang.Integer;
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
public class ReplicationControllerSpecFluent<A extends io.fabric8.kubernetes.api.model.ReplicationControllerSpecFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private Integer minReadySeconds;
  private Integer replicas;
  private Map<String,String> selector;
  private PodTemplateSpecBuilder template;

  public ReplicationControllerSpecFluent() {
  }
  
  public ReplicationControllerSpecFluent(ReplicationControllerSpec instance) {
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
  
  public A addToSelector(Map<String,String> map) {
    if (this.selector == null && map != null) {
      this.selector = new LinkedHashMap();
    }
    if (map != null) {
      this.selector.putAll(map);
    }
    return (A) this;
  }
  
  public A addToSelector(String key,String value) {
    if (this.selector == null && key != null && value != null) {
      this.selector = new LinkedHashMap();
    }
    if (key != null && value != null) {
      this.selector.put(key, value);
    }
    return (A) this;
  }
  
  public PodTemplateSpec buildTemplate() {
    return this.template != null ? this.template.build() : null;
  }
  
  protected void copyInstance(ReplicationControllerSpec instance) {
    instance = instance != null ? instance : new ReplicationControllerSpec();
    if (instance != null) {
        this.withMinReadySeconds(instance.getMinReadySeconds());
        this.withReplicas(instance.getReplicas());
        this.withSelector(instance.getSelector());
        this.withTemplate(instance.getTemplate());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public TemplateNested<A> editOrNewTemplate() {
    return this.withNewTemplateLike(Optional.ofNullable(this.buildTemplate()).orElse(new PodTemplateSpecBuilder().build()));
  }
  
  public TemplateNested<A> editOrNewTemplateLike(PodTemplateSpec item) {
    return this.withNewTemplateLike(Optional.ofNullable(this.buildTemplate()).orElse(item));
  }
  
  public TemplateNested<A> editTemplate() {
    return this.withNewTemplateLike(Optional.ofNullable(this.buildTemplate()).orElse(null));
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
    ReplicationControllerSpecFluent that = (ReplicationControllerSpecFluent) o;
    if (!(Objects.equals(minReadySeconds, that.minReadySeconds))) {
      return false;
    }
    if (!(Objects.equals(replicas, that.replicas))) {
      return false;
    }
    if (!(Objects.equals(selector, that.selector))) {
      return false;
    }
    if (!(Objects.equals(template, that.template))) {
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
  
  public Integer getMinReadySeconds() {
    return this.minReadySeconds;
  }
  
  public Integer getReplicas() {
    return this.replicas;
  }
  
  public Map<String,String> getSelector() {
    return this.selector;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasMinReadySeconds() {
    return this.minReadySeconds != null;
  }
  
  public boolean hasReplicas() {
    return this.replicas != null;
  }
  
  public boolean hasSelector() {
    return this.selector != null;
  }
  
  public boolean hasTemplate() {
    return this.template != null;
  }
  
  public int hashCode() {
    return Objects.hash(minReadySeconds, replicas, selector, template, additionalProperties);
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
  
  public A removeFromSelector(String key) {
    if (this.selector == null) {
      return (A) this;
    }
    if (key != null && this.selector != null) {
      this.selector.remove(key);
    }
    return (A) this;
  }
  
  public A removeFromSelector(Map<String,String> map) {
    if (this.selector == null) {
      return (A) this;
    }
    if (map != null) {
      for (Object key : map.keySet()) {
        if (this.selector != null) {
          this.selector.remove(key);
        }
      }
    }
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(minReadySeconds == null)) {
        sb.append("minReadySeconds:");
        sb.append(minReadySeconds);
        sb.append(",");
    }
    if (!(replicas == null)) {
        sb.append("replicas:");
        sb.append(replicas);
        sb.append(",");
    }
    if (!(selector == null) && !(selector.isEmpty())) {
        sb.append("selector:");
        sb.append(selector);
        sb.append(",");
    }
    if (!(template == null)) {
        sb.append("template:");
        sb.append(template);
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
  
  public A withMinReadySeconds(Integer minReadySeconds) {
    this.minReadySeconds = minReadySeconds;
    return (A) this;
  }
  
  public TemplateNested<A> withNewTemplate() {
    return new TemplateNested(null);
  }
  
  public TemplateNested<A> withNewTemplateLike(PodTemplateSpec item) {
    return new TemplateNested(item);
  }
  
  public A withReplicas(Integer replicas) {
    this.replicas = replicas;
    return (A) this;
  }
  
  public <K,V>A withSelector(Map<String,String> selector) {
    if (selector == null) {
      this.selector = null;
    } else {
      this.selector = new LinkedHashMap(selector);
    }
    return (A) this;
  }
  
  public A withTemplate(PodTemplateSpec template) {
    this._visitables.remove("template");
    if (template != null) {
        this.template = new PodTemplateSpecBuilder(template);
        this._visitables.get("template").add(this.template);
    } else {
        this.template = null;
        this._visitables.get("template").remove(this.template);
    }
    return (A) this;
  }
  public class TemplateNested<N> extends PodTemplateSpecFluent<TemplateNested<N>> implements Nested<N>{
  
    PodTemplateSpecBuilder builder;
  
    TemplateNested(PodTemplateSpec item) {
      this.builder = new PodTemplateSpecBuilder(this, item);
    }
  
    public N and() {
      return (N) ReplicationControllerSpecFluent.this.withTemplate(builder.build());
    }
    
    public N endTemplate() {
      return and();
    }
    
  }
}