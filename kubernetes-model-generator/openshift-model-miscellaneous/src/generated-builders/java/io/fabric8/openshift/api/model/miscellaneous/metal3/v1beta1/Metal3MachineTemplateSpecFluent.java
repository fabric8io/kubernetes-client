package io.fabric8.openshift.api.model.miscellaneous.metal3.v1beta1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import java.lang.Boolean;
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
public class Metal3MachineTemplateSpecFluent<A extends io.fabric8.openshift.api.model.miscellaneous.metal3.v1beta1.Metal3MachineTemplateSpecFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private Boolean nodeReuse;
  private Metal3MachineTemplateResourceBuilder template;

  public Metal3MachineTemplateSpecFluent() {
  }
  
  public Metal3MachineTemplateSpecFluent(Metal3MachineTemplateSpec instance) {
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
  
  public Metal3MachineTemplateResource buildTemplate() {
    return this.template != null ? this.template.build() : null;
  }
  
  protected void copyInstance(Metal3MachineTemplateSpec instance) {
    instance = instance != null ? instance : new Metal3MachineTemplateSpec();
    if (instance != null) {
        this.withNodeReuse(instance.getNodeReuse());
        this.withTemplate(instance.getTemplate());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public TemplateNested<A> editOrNewTemplate() {
    return this.withNewTemplateLike(Optional.ofNullable(this.buildTemplate()).orElse(new Metal3MachineTemplateResourceBuilder().build()));
  }
  
  public TemplateNested<A> editOrNewTemplateLike(Metal3MachineTemplateResource item) {
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
    Metal3MachineTemplateSpecFluent that = (Metal3MachineTemplateSpecFluent) o;
    if (!(Objects.equals(nodeReuse, that.nodeReuse))) {
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
  
  public Boolean getNodeReuse() {
    return this.nodeReuse;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasNodeReuse() {
    return this.nodeReuse != null;
  }
  
  public boolean hasTemplate() {
    return this.template != null;
  }
  
  public int hashCode() {
    return Objects.hash(nodeReuse, template, additionalProperties);
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
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(nodeReuse == null)) {
        sb.append("nodeReuse:");
        sb.append(nodeReuse);
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
  
  public TemplateNested<A> withNewTemplate() {
    return new TemplateNested(null);
  }
  
  public TemplateNested<A> withNewTemplateLike(Metal3MachineTemplateResource item) {
    return new TemplateNested(item);
  }
  
  public A withNodeReuse() {
    return withNodeReuse(true);
  }
  
  public A withNodeReuse(Boolean nodeReuse) {
    this.nodeReuse = nodeReuse;
    return (A) this;
  }
  
  public A withTemplate(Metal3MachineTemplateResource template) {
    this._visitables.remove("template");
    if (template != null) {
        this.template = new Metal3MachineTemplateResourceBuilder(template);
        this._visitables.get("template").add(this.template);
    } else {
        this.template = null;
        this._visitables.get("template").remove(this.template);
    }
    return (A) this;
  }
  public class TemplateNested<N> extends Metal3MachineTemplateResourceFluent<TemplateNested<N>> implements Nested<N>{
  
    Metal3MachineTemplateResourceBuilder builder;
  
    TemplateNested(Metal3MachineTemplateResource item) {
      this.builder = new Metal3MachineTemplateResourceBuilder(this, item);
    }
  
    public N and() {
      return (N) Metal3MachineTemplateSpecFluent.this.withTemplate(builder.build());
    }
    
    public N endTemplate() {
      return and();
    }
    
  }
}