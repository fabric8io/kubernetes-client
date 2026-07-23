package io.fabric8.openshift.api.model.operator.v1;

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
public class MachineManagerFluent<A extends io.fabric8.openshift.api.model.operator.v1.MachineManagerFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String apiGroup;
  private String resource;
  private MachineManagerSelectorBuilder selection;

  public MachineManagerFluent() {
  }
  
  public MachineManagerFluent(MachineManager instance) {
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
  
  public MachineManagerSelector buildSelection() {
    return this.selection != null ? this.selection.build() : null;
  }
  
  protected void copyInstance(MachineManager instance) {
    instance = instance != null ? instance : new MachineManager();
    if (instance != null) {
        this.withApiGroup(instance.getApiGroup());
        this.withResource(instance.getResource());
        this.withSelection(instance.getSelection());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public SelectionNested<A> editOrNewSelection() {
    return this.withNewSelectionLike(Optional.ofNullable(this.buildSelection()).orElse(new MachineManagerSelectorBuilder().build()));
  }
  
  public SelectionNested<A> editOrNewSelectionLike(MachineManagerSelector item) {
    return this.withNewSelectionLike(Optional.ofNullable(this.buildSelection()).orElse(item));
  }
  
  public SelectionNested<A> editSelection() {
    return this.withNewSelectionLike(Optional.ofNullable(this.buildSelection()).orElse(null));
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
    MachineManagerFluent that = (MachineManagerFluent) o;
    if (!(Objects.equals(apiGroup, that.apiGroup))) {
      return false;
    }
    if (!(Objects.equals(resource, that.resource))) {
      return false;
    }
    if (!(Objects.equals(selection, that.selection))) {
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
  
  public String getApiGroup() {
    return this.apiGroup;
  }
  
  public String getResource() {
    return this.resource;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasApiGroup() {
    return this.apiGroup != null;
  }
  
  public boolean hasResource() {
    return this.resource != null;
  }
  
  public boolean hasSelection() {
    return this.selection != null;
  }
  
  public int hashCode() {
    return Objects.hash(apiGroup, resource, selection, additionalProperties);
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
    if (!(apiGroup == null)) {
        sb.append("apiGroup:");
        sb.append(apiGroup);
        sb.append(",");
    }
    if (!(resource == null)) {
        sb.append("resource:");
        sb.append(resource);
        sb.append(",");
    }
    if (!(selection == null)) {
        sb.append("selection:");
        sb.append(selection);
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
  
  public A withApiGroup(String apiGroup) {
    this.apiGroup = apiGroup;
    return (A) this;
  }
  
  public SelectionNested<A> withNewSelection() {
    return new SelectionNested(null);
  }
  
  public SelectionNested<A> withNewSelectionLike(MachineManagerSelector item) {
    return new SelectionNested(item);
  }
  
  public A withResource(String resource) {
    this.resource = resource;
    return (A) this;
  }
  
  public A withSelection(MachineManagerSelector selection) {
    this._visitables.remove("selection");
    if (selection != null) {
        this.selection = new MachineManagerSelectorBuilder(selection);
        this._visitables.get("selection").add(this.selection);
    } else {
        this.selection = null;
        this._visitables.get("selection").remove(this.selection);
    }
    return (A) this;
  }
  public class SelectionNested<N> extends MachineManagerSelectorFluent<SelectionNested<N>> implements Nested<N>{
  
    MachineManagerSelectorBuilder builder;
  
    SelectionNested(MachineManagerSelector item) {
      this.builder = new MachineManagerSelectorBuilder(this, item);
    }
  
    public N and() {
      return (N) MachineManagerFluent.this.withSelection(builder.build());
    }
    
    public N endSelection() {
      return and();
    }
    
  }
}