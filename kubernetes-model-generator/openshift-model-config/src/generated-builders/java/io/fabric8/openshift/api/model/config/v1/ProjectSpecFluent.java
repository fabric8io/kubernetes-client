package io.fabric8.openshift.api.model.config.v1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
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
public class ProjectSpecFluent<A extends io.fabric8.openshift.api.model.config.v1.ProjectSpecFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String projectRequestMessage;
  private TemplateReferenceBuilder projectRequestTemplate;

  public ProjectSpecFluent() {
  }
  
  public ProjectSpecFluent(ProjectSpec instance) {
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
  
  public TemplateReference buildProjectRequestTemplate() {
    return this.projectRequestTemplate != null ? this.projectRequestTemplate.build() : null;
  }
  
  protected void copyInstance(ProjectSpec instance) {
    instance = instance != null ? instance : new ProjectSpec();
    if (instance != null) {
        this.withProjectRequestMessage(instance.getProjectRequestMessage());
        this.withProjectRequestTemplate(instance.getProjectRequestTemplate());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public ProjectRequestTemplateNested<A> editOrNewProjectRequestTemplate() {
    return this.withNewProjectRequestTemplateLike(Optional.ofNullable(this.buildProjectRequestTemplate()).orElse(new TemplateReferenceBuilder().build()));
  }
  
  public ProjectRequestTemplateNested<A> editOrNewProjectRequestTemplateLike(TemplateReference item) {
    return this.withNewProjectRequestTemplateLike(Optional.ofNullable(this.buildProjectRequestTemplate()).orElse(item));
  }
  
  public ProjectRequestTemplateNested<A> editProjectRequestTemplate() {
    return this.withNewProjectRequestTemplateLike(Optional.ofNullable(this.buildProjectRequestTemplate()).orElse(null));
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
    ProjectSpecFluent that = (ProjectSpecFluent) o;
    if (!(Objects.equals(projectRequestMessage, that.projectRequestMessage))) {
      return false;
    }
    if (!(Objects.equals(projectRequestTemplate, that.projectRequestTemplate))) {
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
  
  public String getProjectRequestMessage() {
    return this.projectRequestMessage;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasProjectRequestMessage() {
    return this.projectRequestMessage != null;
  }
  
  public boolean hasProjectRequestTemplate() {
    return this.projectRequestTemplate != null;
  }
  
  public int hashCode() {
    return Objects.hash(projectRequestMessage, projectRequestTemplate, additionalProperties);
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
    if (!(projectRequestMessage == null)) {
        sb.append("projectRequestMessage:");
        sb.append(projectRequestMessage);
        sb.append(",");
    }
    if (!(projectRequestTemplate == null)) {
        sb.append("projectRequestTemplate:");
        sb.append(projectRequestTemplate);
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
  
  public ProjectRequestTemplateNested<A> withNewProjectRequestTemplate() {
    return new ProjectRequestTemplateNested(null);
  }
  
  public A withNewProjectRequestTemplate(String name) {
    return (A) this.withProjectRequestTemplate(new TemplateReference(name));
  }
  
  public ProjectRequestTemplateNested<A> withNewProjectRequestTemplateLike(TemplateReference item) {
    return new ProjectRequestTemplateNested(item);
  }
  
  public A withProjectRequestMessage(String projectRequestMessage) {
    this.projectRequestMessage = projectRequestMessage;
    return (A) this;
  }
  
  public A withProjectRequestTemplate(TemplateReference projectRequestTemplate) {
    this._visitables.remove("projectRequestTemplate");
    if (projectRequestTemplate != null) {
        this.projectRequestTemplate = new TemplateReferenceBuilder(projectRequestTemplate);
        this._visitables.get("projectRequestTemplate").add(this.projectRequestTemplate);
    } else {
        this.projectRequestTemplate = null;
        this._visitables.get("projectRequestTemplate").remove(this.projectRequestTemplate);
    }
    return (A) this;
  }
  public class ProjectRequestTemplateNested<N> extends TemplateReferenceFluent<ProjectRequestTemplateNested<N>> implements Nested<N>{
  
    TemplateReferenceBuilder builder;
  
    ProjectRequestTemplateNested(TemplateReference item) {
      this.builder = new TemplateReferenceBuilder(this, item);
    }
  
    public N and() {
      return (N) ProjectSpecFluent.this.withProjectRequestTemplate(builder.build());
    }
    
    public N endProjectRequestTemplate() {
      return and();
    }
    
  }
}