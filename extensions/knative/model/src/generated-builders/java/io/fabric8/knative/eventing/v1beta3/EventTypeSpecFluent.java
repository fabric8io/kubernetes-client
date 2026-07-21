package io.fabric8.knative.eventing.v1beta3;

import io.fabric8.knative.duck.v1.KReference;
import io.fabric8.knative.duck.v1.KReferenceBuilder;
import io.fabric8.knative.duck.v1.KReferenceFluent;
import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import java.lang.Boolean;
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
import java.util.Optional;
import java.util.function.Predicate;

/**
 * Generated
 */
@SuppressWarnings("unchecked")
public class EventTypeSpecFluent<A extends io.fabric8.knative.eventing.v1beta3.EventTypeSpecFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private ArrayList<EventAttributeDefinitionBuilder> attributes = new ArrayList<EventAttributeDefinitionBuilder>();
  private String description;
  private KReferenceBuilder reference;

  public EventTypeSpecFluent() {
  }
  
  public EventTypeSpecFluent(EventTypeSpec instance) {
    this.copyInstance(instance);
  }

  public A addAllToAttributes(Collection<EventAttributeDefinition> items) {
    if (this.attributes == null) {
      this.attributes = new ArrayList();
    }
    for (EventAttributeDefinition item : items) {
        EventAttributeDefinitionBuilder builder = new EventAttributeDefinitionBuilder(item);
        _visitables.get("attributes").add(builder);
        this.attributes.add(builder);
    }
    return (A) this;
  }
  
  public AttributesNested<A> addNewAttribute() {
    return new AttributesNested(-1, null);
  }
  
  public A addNewAttribute(String name,Boolean required,String value) {
    return (A) this.addToAttributes(new EventAttributeDefinition(name, required, value));
  }
  
  public AttributesNested<A> addNewAttributeLike(EventAttributeDefinition item) {
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
  
  public A addToAttributes(EventAttributeDefinition... items) {
    if (this.attributes == null) {
      this.attributes = new ArrayList();
    }
    for (EventAttributeDefinition item : items) {
        EventAttributeDefinitionBuilder builder = new EventAttributeDefinitionBuilder(item);
        _visitables.get("attributes").add(builder);
        this.attributes.add(builder);
    }
    return (A) this;
  }
  
  public A addToAttributes(int index,EventAttributeDefinition item) {
    if (this.attributes == null) {
      this.attributes = new ArrayList();
    }
    EventAttributeDefinitionBuilder builder = new EventAttributeDefinitionBuilder(item);
    if (index < 0 || index >= attributes.size()) {
        _visitables.get("attributes").add(builder);
        attributes.add(builder);
    } else {
        _visitables.get("attributes").add(builder);
        attributes.add(index, builder);
    }
    return (A) this;
  }
  
  public EventAttributeDefinition buildAttribute(int index) {
    return this.attributes.get(index).build();
  }
  
  public List<EventAttributeDefinition> buildAttributes() {
    return this.attributes != null ? build(attributes) : null;
  }
  
  public EventAttributeDefinition buildFirstAttribute() {
    return this.attributes.get(0).build();
  }
  
  public EventAttributeDefinition buildLastAttribute() {
    return this.attributes.get(attributes.size() - 1).build();
  }
  
  public EventAttributeDefinition buildMatchingAttribute(Predicate<EventAttributeDefinitionBuilder> predicate) {
      for (EventAttributeDefinitionBuilder item : attributes) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public KReference buildReference() {
    return this.reference != null ? this.reference.build() : null;
  }
  
  protected void copyInstance(EventTypeSpec instance) {
    instance = instance != null ? instance : new EventTypeSpec();
    if (instance != null) {
        this.withAttributes(instance.getAttributes());
        this.withDescription(instance.getDescription());
        this.withReference(instance.getReference());
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
  
  public AttributesNested<A> editMatchingAttribute(Predicate<EventAttributeDefinitionBuilder> predicate) {
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
  
  public ReferenceNested<A> editOrNewReference() {
    return this.withNewReferenceLike(Optional.ofNullable(this.buildReference()).orElse(new KReferenceBuilder().build()));
  }
  
  public ReferenceNested<A> editOrNewReferenceLike(KReference item) {
    return this.withNewReferenceLike(Optional.ofNullable(this.buildReference()).orElse(item));
  }
  
  public ReferenceNested<A> editReference() {
    return this.withNewReferenceLike(Optional.ofNullable(this.buildReference()).orElse(null));
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
    EventTypeSpecFluent that = (EventTypeSpecFluent) o;
    if (!(Objects.equals(attributes, that.attributes))) {
      return false;
    }
    if (!(Objects.equals(description, that.description))) {
      return false;
    }
    if (!(Objects.equals(reference, that.reference))) {
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
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasAttributes() {
    return this.attributes != null && !(this.attributes.isEmpty());
  }
  
  public boolean hasDescription() {
    return this.description != null;
  }
  
  public boolean hasMatchingAttribute(Predicate<EventAttributeDefinitionBuilder> predicate) {
      for (EventAttributeDefinitionBuilder item : attributes) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasReference() {
    return this.reference != null;
  }
  
  public int hashCode() {
    return Objects.hash(attributes, description, reference, additionalProperties);
  }
  
  public A removeAllFromAttributes(Collection<EventAttributeDefinition> items) {
    if (this.attributes == null) {
      return (A) this;
    }
    for (EventAttributeDefinition item : items) {
        EventAttributeDefinitionBuilder builder = new EventAttributeDefinitionBuilder(item);
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
  
  public A removeFromAttributes(EventAttributeDefinition... items) {
    if (this.attributes == null) {
      return (A) this;
    }
    for (EventAttributeDefinition item : items) {
        EventAttributeDefinitionBuilder builder = new EventAttributeDefinitionBuilder(item);
        _visitables.get("attributes").remove(builder);
        this.attributes.remove(builder);
    }
    return (A) this;
  }
  
  public A removeMatchingFromAttributes(Predicate<EventAttributeDefinitionBuilder> predicate) {
    if (attributes == null) {
      return (A) this;
    }
    Iterator<EventAttributeDefinitionBuilder> each = attributes.iterator();
    List visitables = _visitables.get("attributes");
    while (each.hasNext()) {
        EventAttributeDefinitionBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public AttributesNested<A> setNewAttributeLike(int index,EventAttributeDefinition item) {
    return new AttributesNested(index, item);
  }
  
  public A setToAttributes(int index,EventAttributeDefinition item) {
    if (this.attributes == null) {
      this.attributes = new ArrayList();
    }
    EventAttributeDefinitionBuilder builder = new EventAttributeDefinitionBuilder(item);
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
    if (!(description == null)) {
        sb.append("description:");
        sb.append(description);
        sb.append(",");
    }
    if (!(reference == null)) {
        sb.append("reference:");
        sb.append(reference);
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
  
  public A withAttributes(List<EventAttributeDefinition> attributes) {
    if (this.attributes != null) {
      this._visitables.get("attributes").clear();
    }
    if (attributes != null) {
        this.attributes = new ArrayList();
        for (EventAttributeDefinition item : attributes) {
          this.addToAttributes(item);
        }
    } else {
      this.attributes = null;
    }
    return (A) this;
  }
  
  public A withAttributes(EventAttributeDefinition... attributes) {
    if (this.attributes != null) {
        this.attributes.clear();
        _visitables.remove("attributes");
    }
    if (attributes != null) {
      for (EventAttributeDefinition item : attributes) {
        this.addToAttributes(item);
      }
    }
    return (A) this;
  }
  
  public A withDescription(String description) {
    this.description = description;
    return (A) this;
  }
  
  public ReferenceNested<A> withNewReference() {
    return new ReferenceNested(null);
  }
  
  public ReferenceNested<A> withNewReferenceLike(KReference item) {
    return new ReferenceNested(item);
  }
  
  public A withReference(KReference reference) {
    this._visitables.remove("reference");
    if (reference != null) {
        this.reference = new KReferenceBuilder(reference);
        this._visitables.get("reference").add(this.reference);
    } else {
        this.reference = null;
        this._visitables.get("reference").remove(this.reference);
    }
    return (A) this;
  }
  public class AttributesNested<N> extends EventAttributeDefinitionFluent<AttributesNested<N>> implements Nested<N>{
  
    EventAttributeDefinitionBuilder builder;
    int index;
  
    AttributesNested(int index,EventAttributeDefinition item) {
      this.index = index;
      this.builder = new EventAttributeDefinitionBuilder(this, item);
    }
  
    public N and() {
      return (N) EventTypeSpecFluent.this.setToAttributes(index, builder.build());
    }
    
    public N endAttribute() {
      return and();
    }
    
  }
  public class ReferenceNested<N> extends KReferenceFluent<ReferenceNested<N>> implements Nested<N>{
  
    KReferenceBuilder builder;
  
    ReferenceNested(KReference item) {
      this.builder = new KReferenceBuilder(this, item);
    }
  
    public N and() {
      return (N) EventTypeSpecFluent.this.withReference(builder.build());
    }
    
    public N endReference() {
      return and();
    }
    
  }
}