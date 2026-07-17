package io.fabric8.openshift.api.model.console.v1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.model.TypeMeta;
import java.lang.Boolean;
import java.lang.Object;
import java.lang.String;
import java.lang.StringBuilder;
import java.lang.SuppressWarnings;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

/**
 * Generated
 */
@SuppressWarnings("unchecked")
public class ConsoleYAMLSampleSpecFluent<A extends io.fabric8.openshift.api.model.console.v1.ConsoleYAMLSampleSpecFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String description;
  private Boolean snippet;
  private TypeMeta targetResource;
  private String title;
  private String yaml;

  public ConsoleYAMLSampleSpecFluent() {
  }
  
  public ConsoleYAMLSampleSpecFluent(ConsoleYAMLSampleSpec instance) {
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
  
  protected void copyInstance(ConsoleYAMLSampleSpec instance) {
    instance = instance != null ? instance : new ConsoleYAMLSampleSpec();
    if (instance != null) {
        this.withDescription(instance.getDescription());
        this.withSnippet(instance.getSnippet());
        this.withTargetResource(instance.getTargetResource());
        this.withTitle(instance.getTitle());
        this.withYaml(instance.getYaml());
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
    ConsoleYAMLSampleSpecFluent that = (ConsoleYAMLSampleSpecFluent) o;
    if (!(Objects.equals(description, that.description))) {
      return false;
    }
    if (!(Objects.equals(snippet, that.snippet))) {
      return false;
    }
    if (!(Objects.equals(targetResource, that.targetResource))) {
      return false;
    }
    if (!(Objects.equals(title, that.title))) {
      return false;
    }
    if (!(Objects.equals(yaml, that.yaml))) {
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
  
  public String getDescription() {
    return this.description;
  }
  
  public Boolean getSnippet() {
    return this.snippet;
  }
  
  public TypeMeta getTargetResource() {
    return this.targetResource;
  }
  
  public String getTitle() {
    return this.title;
  }
  
  public String getYaml() {
    return this.yaml;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasDescription() {
    return this.description != null;
  }
  
  public boolean hasSnippet() {
    return this.snippet != null;
  }
  
  public boolean hasTargetResource() {
    return this.targetResource != null;
  }
  
  public boolean hasTitle() {
    return this.title != null;
  }
  
  public boolean hasYaml() {
    return this.yaml != null;
  }
  
  public int hashCode() {
    return Objects.hash(description, snippet, targetResource, title, yaml, additionalProperties);
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
    if (!(description == null)) {
        sb.append("description:");
        sb.append(description);
        sb.append(",");
    }
    if (!(snippet == null)) {
        sb.append("snippet:");
        sb.append(snippet);
        sb.append(",");
    }
    if (!(targetResource == null)) {
        sb.append("targetResource:");
        sb.append(targetResource);
        sb.append(",");
    }
    if (!(title == null)) {
        sb.append("title:");
        sb.append(title);
        sb.append(",");
    }
    if (!(yaml == null)) {
        sb.append("yaml:");
        sb.append(yaml);
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
  
  public A withDescription(String description) {
    this.description = description;
    return (A) this;
  }
  
  public A withNewTargetResource(String apiVersion,String kind) {
    return (A) this.withTargetResource(new TypeMeta(apiVersion, kind));
  }
  
  public A withSnippet() {
    return withSnippet(true);
  }
  
  public A withSnippet(Boolean snippet) {
    this.snippet = snippet;
    return (A) this;
  }
  
  public A withTargetResource(TypeMeta targetResource) {
    this.targetResource = targetResource;
    return (A) this;
  }
  
  public A withTitle(String title) {
    this.title = title;
    return (A) this;
  }
  
  public A withYaml(String yaml) {
    this.yaml = yaml;
    return (A) this;
  }
  
}