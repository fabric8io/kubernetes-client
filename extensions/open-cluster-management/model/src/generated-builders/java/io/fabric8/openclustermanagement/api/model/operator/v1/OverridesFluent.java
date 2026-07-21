package io.fabric8.openclustermanagement.api.model.operator.v1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import java.lang.Object;
import java.lang.RuntimeException;
import java.lang.String;
import java.lang.StringBuilder;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Predicate;

/**
 * Generated
 */
@SuppressWarnings("unchecked")
public class OverridesFluent<A extends io.fabric8.openclustermanagement.api.model.operator.v1.OverridesFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private ArrayList<ComponentConfigBuilder> components = new ArrayList<ComponentConfigBuilder>();
  private String imagePullPolicy;

  public OverridesFluent() {
  }
  
  public OverridesFluent(Overrides instance) {
    this.copyInstance(instance);
  }

  public A addAllToComponents(Collection<ComponentConfig> items) {
    if (this.components == null) {
      this.components = new ArrayList();
    }
    for (ComponentConfig item : items) {
        ComponentConfigBuilder builder = new ComponentConfigBuilder(item);
        _visitables.get("components").add(builder);
        this.components.add(builder);
    }
    return (A) this;
  }
  
  public ComponentsNested<A> addNewComponent() {
    return new ComponentsNested(-1, null);
  }
  
  public ComponentsNested<A> addNewComponentLike(ComponentConfig item) {
    return new ComponentsNested(-1, item);
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
  
  public A addToComponents(ComponentConfig... items) {
    if (this.components == null) {
      this.components = new ArrayList();
    }
    for (ComponentConfig item : items) {
        ComponentConfigBuilder builder = new ComponentConfigBuilder(item);
        _visitables.get("components").add(builder);
        this.components.add(builder);
    }
    return (A) this;
  }
  
  public A addToComponents(int index,ComponentConfig item) {
    if (this.components == null) {
      this.components = new ArrayList();
    }
    ComponentConfigBuilder builder = new ComponentConfigBuilder(item);
    if (index < 0 || index >= components.size()) {
        _visitables.get("components").add(builder);
        components.add(builder);
    } else {
        _visitables.get("components").add(builder);
        components.add(index, builder);
    }
    return (A) this;
  }
  
  public ComponentConfig buildComponent(int index) {
    return this.components.get(index).build();
  }
  
  public List<ComponentConfig> buildComponents() {
    return this.components != null ? build(components) : null;
  }
  
  public ComponentConfig buildFirstComponent() {
    return this.components.get(0).build();
  }
  
  public ComponentConfig buildLastComponent() {
    return this.components.get(components.size() - 1).build();
  }
  
  public ComponentConfig buildMatchingComponent(Predicate<ComponentConfigBuilder> predicate) {
      for (ComponentConfigBuilder item : components) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  protected void copyInstance(Overrides instance) {
    instance = instance != null ? instance : new Overrides();
    if (instance != null) {
        this.withComponents(instance.getComponents());
        this.withImagePullPolicy(instance.getImagePullPolicy());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public ComponentsNested<A> editComponent(int index) {
    if (components.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "components"));
    }
    return this.setNewComponentLike(index, this.buildComponent(index));
  }
  
  public ComponentsNested<A> editFirstComponent() {
    if (components.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "components"));
    }
    return this.setNewComponentLike(0, this.buildComponent(0));
  }
  
  public ComponentsNested<A> editLastComponent() {
    int index = components.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "components"));
    }
    return this.setNewComponentLike(index, this.buildComponent(index));
  }
  
  public ComponentsNested<A> editMatchingComponent(Predicate<ComponentConfigBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < components.size();i++) {
      if (predicate.test(components.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "components"));
    }
    return this.setNewComponentLike(index, this.buildComponent(index));
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
    OverridesFluent that = (OverridesFluent) o;
    if (!(Objects.equals(components, that.components))) {
      return false;
    }
    if (!(Objects.equals(imagePullPolicy, that.imagePullPolicy))) {
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
  
  public String getImagePullPolicy() {
    return this.imagePullPolicy;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasComponents() {
    return this.components != null && !(this.components.isEmpty());
  }
  
  public boolean hasImagePullPolicy() {
    return this.imagePullPolicy != null;
  }
  
  public boolean hasMatchingComponent(Predicate<ComponentConfigBuilder> predicate) {
      for (ComponentConfigBuilder item : components) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public int hashCode() {
    return Objects.hash(components, imagePullPolicy, additionalProperties);
  }
  
  public A removeAllFromComponents(Collection<ComponentConfig> items) {
    if (this.components == null) {
      return (A) this;
    }
    for (ComponentConfig item : items) {
        ComponentConfigBuilder builder = new ComponentConfigBuilder(item);
        _visitables.get("components").remove(builder);
        this.components.remove(builder);
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
  
  public A removeFromComponents(ComponentConfig... items) {
    if (this.components == null) {
      return (A) this;
    }
    for (ComponentConfig item : items) {
        ComponentConfigBuilder builder = new ComponentConfigBuilder(item);
        _visitables.get("components").remove(builder);
        this.components.remove(builder);
    }
    return (A) this;
  }
  
  public A removeMatchingFromComponents(Predicate<ComponentConfigBuilder> predicate) {
    if (components == null) {
      return (A) this;
    }
    Iterator<ComponentConfigBuilder> each = components.iterator();
    List visitables = _visitables.get("components");
    while (each.hasNext()) {
        ComponentConfigBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public ComponentsNested<A> setNewComponentLike(int index,ComponentConfig item) {
    return new ComponentsNested(index, item);
  }
  
  public A setToComponents(int index,ComponentConfig item) {
    if (this.components == null) {
      this.components = new ArrayList();
    }
    ComponentConfigBuilder builder = new ComponentConfigBuilder(item);
    if (index < 0 || index >= components.size()) {
        _visitables.get("components").add(builder);
        components.add(builder);
    } else {
        _visitables.get("components").add(builder);
        components.set(index, builder);
    }
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(components == null) && !(components.isEmpty())) {
        sb.append("components:");
        sb.append(components);
        sb.append(",");
    }
    if (!(imagePullPolicy == null)) {
        sb.append("imagePullPolicy:");
        sb.append(imagePullPolicy);
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
  
  public A withComponents(List<ComponentConfig> components) {
    if (this.components != null) {
      this._visitables.get("components").clear();
    }
    if (components != null) {
        this.components = new ArrayList();
        for (ComponentConfig item : components) {
          this.addToComponents(item);
        }
    } else {
      this.components = null;
    }
    return (A) this;
  }
  
  public A withComponents(ComponentConfig... components) {
    if (this.components != null) {
        this.components.clear();
        _visitables.remove("components");
    }
    if (components != null) {
      for (ComponentConfig item : components) {
        this.addToComponents(item);
      }
    }
    return (A) this;
  }
  
  public A withImagePullPolicy(String imagePullPolicy) {
    this.imagePullPolicy = imagePullPolicy;
    return (A) this;
  }
  public class ComponentsNested<N> extends ComponentConfigFluent<ComponentsNested<N>> implements Nested<N>{
  
    ComponentConfigBuilder builder;
    int index;
  
    ComponentsNested(int index,ComponentConfig item) {
      this.index = index;
      this.builder = new ComponentConfigBuilder(this, item);
    }
  
    public N and() {
      return (N) OverridesFluent.this.setToComponents(index, builder.build());
    }
    
    public N endComponent() {
      return and();
    }
    
  }
}