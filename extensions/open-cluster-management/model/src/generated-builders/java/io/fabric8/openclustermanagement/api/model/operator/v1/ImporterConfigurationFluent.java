package io.fabric8.openclustermanagement.api.model.operator.v1;

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
public class ImporterConfigurationFluent<A extends io.fabric8.openclustermanagement.api.model.operator.v1.ImporterConfigurationFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private List<String> renderers = new ArrayList<String>();

  public ImporterConfigurationFluent() {
  }
  
  public ImporterConfigurationFluent(ImporterConfiguration instance) {
    this.copyInstance(instance);
  }

  public A addAllToRenderers(Collection<String> items) {
    if (this.renderers == null) {
      this.renderers = new ArrayList();
    }
    for (String item : items) {
      this.renderers.add(item);
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
  
  public A addToRenderers(String... items) {
    if (this.renderers == null) {
      this.renderers = new ArrayList();
    }
    for (String item : items) {
      this.renderers.add(item);
    }
    return (A) this;
  }
  
  public A addToRenderers(int index,String item) {
    if (this.renderers == null) {
      this.renderers = new ArrayList();
    }
    this.renderers.add(index, item);
    return (A) this;
  }
  
  protected void copyInstance(ImporterConfiguration instance) {
    instance = instance != null ? instance : new ImporterConfiguration();
    if (instance != null) {
        this.withRenderers(instance.getRenderers());
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
    ImporterConfigurationFluent that = (ImporterConfigurationFluent) o;
    if (!(Objects.equals(renderers, that.renderers))) {
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
  
  public String getFirstRenderer() {
    return this.renderers.get(0);
  }
  
  public String getLastRenderer() {
    return this.renderers.get(renderers.size() - 1);
  }
  
  public String getMatchingRenderer(Predicate<String> predicate) {
      for (String item : renderers) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public String getRenderer(int index) {
    return this.renderers.get(index);
  }
  
  public List<String> getRenderers() {
    return this.renderers;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasMatchingRenderer(Predicate<String> predicate) {
      for (String item : renderers) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasRenderers() {
    return this.renderers != null && !(this.renderers.isEmpty());
  }
  
  public int hashCode() {
    return Objects.hash(renderers, additionalProperties);
  }
  
  public A removeAllFromRenderers(Collection<String> items) {
    if (this.renderers == null) {
      return (A) this;
    }
    for (String item : items) {
      this.renderers.remove(item);
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
  
  public A removeFromRenderers(String... items) {
    if (this.renderers == null) {
      return (A) this;
    }
    for (String item : items) {
      this.renderers.remove(item);
    }
    return (A) this;
  }
  
  public A setToRenderers(int index,String item) {
    if (this.renderers == null) {
      this.renderers = new ArrayList();
    }
    this.renderers.set(index, item);
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(renderers == null) && !(renderers.isEmpty())) {
        sb.append("renderers:");
        sb.append(renderers);
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
  
  public A withRenderers(List<String> renderers) {
    if (renderers != null) {
        this.renderers = new ArrayList();
        for (String item : renderers) {
          this.addToRenderers(item);
        }
    } else {
      this.renderers = null;
    }
    return (A) this;
  }
  
  public A withRenderers(String... renderers) {
    if (this.renderers != null) {
        this.renderers.clear();
        _visitables.remove("renderers");
    }
    if (renderers != null) {
      for (String item : renderers) {
        this.addToRenderers(item);
      }
    }
    return (A) this;
  }
  
}