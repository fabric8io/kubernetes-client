package io.fabric8.openshift.api.model.miscellaneous.cloudcredential.v1;

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
public class AccessPolicyFluent<A extends io.fabric8.openshift.api.model.miscellaneous.cloudcredential.v1.AccessPolicyFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private ArrayList<ResourceAttributeBuilder> attributes = new ArrayList<ResourceAttributeBuilder>();
  private List<String> roles = new ArrayList<String>();

  public AccessPolicyFluent() {
  }
  
  public AccessPolicyFluent(AccessPolicy instance) {
    this.copyInstance(instance);
  }

  public A addAllToAttributes(Collection<ResourceAttribute> items) {
    if (this.attributes == null) {
      this.attributes = new ArrayList();
    }
    for (ResourceAttribute item : items) {
        ResourceAttributeBuilder builder = new ResourceAttributeBuilder(item);
        _visitables.get("attributes").add(builder);
        this.attributes.add(builder);
    }
    return (A) this;
  }
  
  public A addAllToRoles(Collection<String> items) {
    if (this.roles == null) {
      this.roles = new ArrayList();
    }
    for (String item : items) {
      this.roles.add(item);
    }
    return (A) this;
  }
  
  public AttributesNested<A> addNewAttribute() {
    return new AttributesNested(-1, null);
  }
  
  public A addNewAttribute(String name,String operator,String value) {
    return (A) this.addToAttributes(new ResourceAttribute(name, operator, value));
  }
  
  public AttributesNested<A> addNewAttributeLike(ResourceAttribute item) {
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
  
  public A addToAttributes(ResourceAttribute... items) {
    if (this.attributes == null) {
      this.attributes = new ArrayList();
    }
    for (ResourceAttribute item : items) {
        ResourceAttributeBuilder builder = new ResourceAttributeBuilder(item);
        _visitables.get("attributes").add(builder);
        this.attributes.add(builder);
    }
    return (A) this;
  }
  
  public A addToAttributes(int index,ResourceAttribute item) {
    if (this.attributes == null) {
      this.attributes = new ArrayList();
    }
    ResourceAttributeBuilder builder = new ResourceAttributeBuilder(item);
    if (index < 0 || index >= attributes.size()) {
        _visitables.get("attributes").add(builder);
        attributes.add(builder);
    } else {
        _visitables.get("attributes").add(builder);
        attributes.add(index, builder);
    }
    return (A) this;
  }
  
  public A addToRoles(String... items) {
    if (this.roles == null) {
      this.roles = new ArrayList();
    }
    for (String item : items) {
      this.roles.add(item);
    }
    return (A) this;
  }
  
  public A addToRoles(int index,String item) {
    if (this.roles == null) {
      this.roles = new ArrayList();
    }
    this.roles.add(index, item);
    return (A) this;
  }
  
  public ResourceAttribute buildAttribute(int index) {
    return this.attributes.get(index).build();
  }
  
  public List<ResourceAttribute> buildAttributes() {
    return this.attributes != null ? build(attributes) : null;
  }
  
  public ResourceAttribute buildFirstAttribute() {
    return this.attributes.get(0).build();
  }
  
  public ResourceAttribute buildLastAttribute() {
    return this.attributes.get(attributes.size() - 1).build();
  }
  
  public ResourceAttribute buildMatchingAttribute(Predicate<ResourceAttributeBuilder> predicate) {
      for (ResourceAttributeBuilder item : attributes) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  protected void copyInstance(AccessPolicy instance) {
    instance = instance != null ? instance : new AccessPolicy();
    if (instance != null) {
        this.withAttributes(instance.getAttributes());
        this.withRoles(instance.getRoles());
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
  
  public AttributesNested<A> editMatchingAttribute(Predicate<ResourceAttributeBuilder> predicate) {
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
    AccessPolicyFluent that = (AccessPolicyFluent) o;
    if (!(Objects.equals(attributes, that.attributes))) {
      return false;
    }
    if (!(Objects.equals(roles, that.roles))) {
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
  
  public String getFirstRole() {
    return this.roles.get(0);
  }
  
  public String getLastRole() {
    return this.roles.get(roles.size() - 1);
  }
  
  public String getMatchingRole(Predicate<String> predicate) {
      for (String item : roles) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public String getRole(int index) {
    return this.roles.get(index);
  }
  
  public List<String> getRoles() {
    return this.roles;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasAttributes() {
    return this.attributes != null && !(this.attributes.isEmpty());
  }
  
  public boolean hasMatchingAttribute(Predicate<ResourceAttributeBuilder> predicate) {
      for (ResourceAttributeBuilder item : attributes) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingRole(Predicate<String> predicate) {
      for (String item : roles) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasRoles() {
    return this.roles != null && !(this.roles.isEmpty());
  }
  
  public int hashCode() {
    return Objects.hash(attributes, roles, additionalProperties);
  }
  
  public A removeAllFromAttributes(Collection<ResourceAttribute> items) {
    if (this.attributes == null) {
      return (A) this;
    }
    for (ResourceAttribute item : items) {
        ResourceAttributeBuilder builder = new ResourceAttributeBuilder(item);
        _visitables.get("attributes").remove(builder);
        this.attributes.remove(builder);
    }
    return (A) this;
  }
  
  public A removeAllFromRoles(Collection<String> items) {
    if (this.roles == null) {
      return (A) this;
    }
    for (String item : items) {
      this.roles.remove(item);
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
  
  public A removeFromAttributes(ResourceAttribute... items) {
    if (this.attributes == null) {
      return (A) this;
    }
    for (ResourceAttribute item : items) {
        ResourceAttributeBuilder builder = new ResourceAttributeBuilder(item);
        _visitables.get("attributes").remove(builder);
        this.attributes.remove(builder);
    }
    return (A) this;
  }
  
  public A removeFromRoles(String... items) {
    if (this.roles == null) {
      return (A) this;
    }
    for (String item : items) {
      this.roles.remove(item);
    }
    return (A) this;
  }
  
  public A removeMatchingFromAttributes(Predicate<ResourceAttributeBuilder> predicate) {
    if (attributes == null) {
      return (A) this;
    }
    Iterator<ResourceAttributeBuilder> each = attributes.iterator();
    List visitables = _visitables.get("attributes");
    while (each.hasNext()) {
        ResourceAttributeBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public AttributesNested<A> setNewAttributeLike(int index,ResourceAttribute item) {
    return new AttributesNested(index, item);
  }
  
  public A setToAttributes(int index,ResourceAttribute item) {
    if (this.attributes == null) {
      this.attributes = new ArrayList();
    }
    ResourceAttributeBuilder builder = new ResourceAttributeBuilder(item);
    if (index < 0 || index >= attributes.size()) {
        _visitables.get("attributes").add(builder);
        attributes.add(builder);
    } else {
        _visitables.get("attributes").add(builder);
        attributes.set(index, builder);
    }
    return (A) this;
  }
  
  public A setToRoles(int index,String item) {
    if (this.roles == null) {
      this.roles = new ArrayList();
    }
    this.roles.set(index, item);
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
    if (!(roles == null) && !(roles.isEmpty())) {
        sb.append("roles:");
        sb.append(roles);
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
  
  public A withAttributes(List<ResourceAttribute> attributes) {
    if (this.attributes != null) {
      this._visitables.get("attributes").clear();
    }
    if (attributes != null) {
        this.attributes = new ArrayList();
        for (ResourceAttribute item : attributes) {
          this.addToAttributes(item);
        }
    } else {
      this.attributes = null;
    }
    return (A) this;
  }
  
  public A withAttributes(ResourceAttribute... attributes) {
    if (this.attributes != null) {
        this.attributes.clear();
        _visitables.remove("attributes");
    }
    if (attributes != null) {
      for (ResourceAttribute item : attributes) {
        this.addToAttributes(item);
      }
    }
    return (A) this;
  }
  
  public A withRoles(List<String> roles) {
    if (roles != null) {
        this.roles = new ArrayList();
        for (String item : roles) {
          this.addToRoles(item);
        }
    } else {
      this.roles = null;
    }
    return (A) this;
  }
  
  public A withRoles(String... roles) {
    if (this.roles != null) {
        this.roles.clear();
        _visitables.remove("roles");
    }
    if (roles != null) {
      for (String item : roles) {
        this.addToRoles(item);
      }
    }
    return (A) this;
  }
  public class AttributesNested<N> extends ResourceAttributeFluent<AttributesNested<N>> implements Nested<N>{
  
    ResourceAttributeBuilder builder;
    int index;
  
    AttributesNested(int index,ResourceAttribute item) {
      this.index = index;
      this.builder = new ResourceAttributeBuilder(this, item);
    }
  
    public N and() {
      return (N) AccessPolicyFluent.this.setToAttributes(index, builder.build());
    }
    
    public N endAttribute() {
      return and();
    }
    
  }
}