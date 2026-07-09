package io.fabric8.kubernetes.api.model.resource.v1alpha2;

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
public class NamedResourcesInstanceFluent<A extends io.fabric8.kubernetes.api.model.resource.v1alpha2.NamedResourcesInstanceFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private ArrayList<NamedResourcesAttributeBuilder> attributes = new ArrayList<NamedResourcesAttributeBuilder>();
  private String name;

  public NamedResourcesInstanceFluent() {
  }
  
  public NamedResourcesInstanceFluent(NamedResourcesInstance instance) {
    this.copyInstance(instance);
  }

  public A addAllToAttributes(Collection<NamedResourcesAttribute> items) {
    if (this.attributes == null) {
      this.attributes = new ArrayList();
    }
    for (NamedResourcesAttribute item : items) {
        NamedResourcesAttributeBuilder builder = new NamedResourcesAttributeBuilder(item);
        _visitables.get("attributes").add(builder);
        this.attributes.add(builder);
    }
    return (A) this;
  }
  
  public AttributesNested<A> addNewAttribute() {
    return new AttributesNested(-1, null);
  }
  
  public AttributesNested<A> addNewAttributeLike(NamedResourcesAttribute item) {
    return new AttributesNested(-1, item);
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
  
  public A addToAttributes(NamedResourcesAttribute... items) {
    if (this.attributes == null) {
      this.attributes = new ArrayList();
    }
    for (NamedResourcesAttribute item : items) {
        NamedResourcesAttributeBuilder builder = new NamedResourcesAttributeBuilder(item);
        _visitables.get("attributes").add(builder);
        this.attributes.add(builder);
    }
    return (A) this;
  }
  
  public A addToAttributes(int index,NamedResourcesAttribute item) {
    if (this.attributes == null) {
      this.attributes = new ArrayList();
    }
    NamedResourcesAttributeBuilder builder = new NamedResourcesAttributeBuilder(item);
    if (index < 0 || index >= attributes.size()) {
        _visitables.get("attributes").add(builder);
        attributes.add(builder);
    } else {
        _visitables.get("attributes").add(builder);
        attributes.add(index, builder);
    }
    return (A) this;
  }
  
  public NamedResourcesAttribute buildAttribute(int index) {
    return this.attributes.get(index).build();
  }
  
  public List<NamedResourcesAttribute> buildAttributes() {
    return this.attributes != null ? build(attributes) : null;
  }
  
  public NamedResourcesAttribute buildFirstAttribute() {
    return this.attributes.get(0).build();
  }
  
  public NamedResourcesAttribute buildLastAttribute() {
    return this.attributes.get(attributes.size() - 1).build();
  }
  
  public NamedResourcesAttribute buildMatchingAttribute(Predicate<NamedResourcesAttributeBuilder> predicate) {
      for (NamedResourcesAttributeBuilder item : attributes) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  protected void copyInstance(NamedResourcesInstance instance) {
    instance = instance != null ? instance : new NamedResourcesInstance();
    if (instance != null) {
        this.withAttributes(instance.getAttributes());
        this.withName(instance.getName());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public AttributesNested<A> editAttribute(int index) {
    if (attributes.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "attributes"));
    }
    return this.setNewAttributeLike(index, this.buildAttribute(index));
  }
  
  public AttributesNested<A> editFirstAttribute() {
    if (attributes.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "attributes"));
    }
    return this.setNewAttributeLike(0, this.buildAttribute(0));
  }
  
  public AttributesNested<A> editLastAttribute() {
    int index = attributes.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "attributes"));
    }
    return this.setNewAttributeLike(index, this.buildAttribute(index));
  }
  
  public AttributesNested<A> editMatchingAttribute(Predicate<NamedResourcesAttributeBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < attributes.size();i++) {
      if (predicate.test(attributes.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "attributes"));
    }
    return this.setNewAttributeLike(index, this.buildAttribute(index));
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
    NamedResourcesInstanceFluent that = (NamedResourcesInstanceFluent) o;
    if (!(Objects.equals(attributes, that.attributes))) {
      return false;
    }
    if (!(Objects.equals(name, that.name))) {
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
  
  public String getName() {
    return this.name;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasAttributes() {
    return this.attributes != null && !(this.attributes.isEmpty());
  }
  
  public boolean hasMatchingAttribute(Predicate<NamedResourcesAttributeBuilder> predicate) {
      for (NamedResourcesAttributeBuilder item : attributes) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasName() {
    return this.name != null;
  }
  
  public int hashCode() {
    return Objects.hash(attributes, name, additionalProperties);
  }
  
  public A removeAllFromAttributes(Collection<NamedResourcesAttribute> items) {
    if (this.attributes == null) {
      return (A) this;
    }
    for (NamedResourcesAttribute item : items) {
        NamedResourcesAttributeBuilder builder = new NamedResourcesAttributeBuilder(item);
        _visitables.get("attributes").remove(builder);
        this.attributes.remove(builder);
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
  
  public A removeFromAttributes(NamedResourcesAttribute... items) {
    if (this.attributes == null) {
      return (A) this;
    }
    for (NamedResourcesAttribute item : items) {
        NamedResourcesAttributeBuilder builder = new NamedResourcesAttributeBuilder(item);
        _visitables.get("attributes").remove(builder);
        this.attributes.remove(builder);
    }
    return (A) this;
  }
  
  public A removeMatchingFromAttributes(Predicate<NamedResourcesAttributeBuilder> predicate) {
    if (attributes == null) {
      return (A) this;
    }
    Iterator<NamedResourcesAttributeBuilder> each = attributes.iterator();
    List visitables = _visitables.get("attributes");
    while (each.hasNext()) {
        NamedResourcesAttributeBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public AttributesNested<A> setNewAttributeLike(int index,NamedResourcesAttribute item) {
    return new AttributesNested(index, item);
  }
  
  public A setToAttributes(int index,NamedResourcesAttribute item) {
    if (this.attributes == null) {
      this.attributes = new ArrayList();
    }
    NamedResourcesAttributeBuilder builder = new NamedResourcesAttributeBuilder(item);
    if (index < 0 || index >= attributes.size()) {
        _visitables.get("attributes").add(builder);
        attributes.add(builder);
    } else {
        _visitables.get("attributes").add(builder);
        attributes.set(index, builder);
    }
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(attributes == null) && !(attributes.isEmpty())) {
        sb.append("attributes:");
        sb.append(attributes);
        sb.append(",");
    }
    if (!(name == null)) {
        sb.append("name:");
        sb.append(name);
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
  
  public A withAttributes(List<NamedResourcesAttribute> attributes) {
    if (this.attributes != null) {
      this._visitables.get("attributes").clear();
    }
    if (attributes != null) {
        this.attributes = new ArrayList();
        for (NamedResourcesAttribute item : attributes) {
          this.addToAttributes(item);
        }
    } else {
      this.attributes = null;
    }
    return (A) this;
  }
  
  public A withAttributes(NamedResourcesAttribute... attributes) {
    if (this.attributes != null) {
        this.attributes.clear();
        _visitables.remove("attributes");
    }
    if (attributes != null) {
      for (NamedResourcesAttribute item : attributes) {
        this.addToAttributes(item);
      }
    }
    return (A) this;
  }
  
  public A withName(String name) {
    this.name = name;
    return (A) this;
  }
  public class AttributesNested<N> extends NamedResourcesAttributeFluent<AttributesNested<N>> implements Nested<N>{
  
    NamedResourcesAttributeBuilder builder;
    int index;
  
    AttributesNested(int index,NamedResourcesAttribute item) {
      this.index = index;
      this.builder = new NamedResourcesAttributeBuilder(this, item);
    }
  
    public N and() {
      return (N) NamedResourcesInstanceFluent.this.setToAttributes(index, builder.build());
    }
    
    public N endAttribute() {
      return and();
    }
    
  }
}