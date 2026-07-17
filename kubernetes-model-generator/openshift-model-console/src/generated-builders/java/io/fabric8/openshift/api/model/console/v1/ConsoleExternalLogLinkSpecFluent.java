package io.fabric8.openshift.api.model.console.v1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
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
public class ConsoleExternalLogLinkSpecFluent<A extends io.fabric8.openshift.api.model.console.v1.ConsoleExternalLogLinkSpecFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String hrefTemplate;
  private String namespaceFilter;
  private String text;

  public ConsoleExternalLogLinkSpecFluent() {
  }
  
  public ConsoleExternalLogLinkSpecFluent(ConsoleExternalLogLinkSpec instance) {
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
  
  protected void copyInstance(ConsoleExternalLogLinkSpec instance) {
    instance = instance != null ? instance : new ConsoleExternalLogLinkSpec();
    if (instance != null) {
        this.withHrefTemplate(instance.getHrefTemplate());
        this.withNamespaceFilter(instance.getNamespaceFilter());
        this.withText(instance.getText());
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
    ConsoleExternalLogLinkSpecFluent that = (ConsoleExternalLogLinkSpecFluent) o;
    if (!(Objects.equals(hrefTemplate, that.hrefTemplate))) {
      return false;
    }
    if (!(Objects.equals(namespaceFilter, that.namespaceFilter))) {
      return false;
    }
    if (!(Objects.equals(text, that.text))) {
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
  
  public String getHrefTemplate() {
    return this.hrefTemplate;
  }
  
  public String getNamespaceFilter() {
    return this.namespaceFilter;
  }
  
  public String getText() {
    return this.text;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasHrefTemplate() {
    return this.hrefTemplate != null;
  }
  
  public boolean hasNamespaceFilter() {
    return this.namespaceFilter != null;
  }
  
  public boolean hasText() {
    return this.text != null;
  }
  
  public int hashCode() {
    return Objects.hash(hrefTemplate, namespaceFilter, text, additionalProperties);
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
    if (!(hrefTemplate == null)) {
        sb.append("hrefTemplate:");
        sb.append(hrefTemplate);
        sb.append(",");
    }
    if (!(namespaceFilter == null)) {
        sb.append("namespaceFilter:");
        sb.append(namespaceFilter);
        sb.append(",");
    }
    if (!(text == null)) {
        sb.append("text:");
        sb.append(text);
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
  
  public A withHrefTemplate(String hrefTemplate) {
    this.hrefTemplate = hrefTemplate;
    return (A) this;
  }
  
  public A withNamespaceFilter(String namespaceFilter) {
    this.namespaceFilter = namespaceFilter;
    return (A) this;
  }
  
  public A withText(String text) {
    this.text = text;
    return (A) this;
  }
  
}