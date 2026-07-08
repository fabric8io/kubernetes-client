package io.fabric8.kubernetes.api.model;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ObjectFieldSelectorBuilder extends ObjectFieldSelectorFluent<ObjectFieldSelectorBuilder> implements VisitableBuilder<ObjectFieldSelector,ObjectFieldSelectorBuilder>{

  ObjectFieldSelectorFluent<?> fluent;

  public ObjectFieldSelectorBuilder() {
    this(new ObjectFieldSelector());
  }
  
  public ObjectFieldSelectorBuilder(ObjectFieldSelectorFluent<?> fluent) {
    this(fluent, new ObjectFieldSelector());
  }
  
  public ObjectFieldSelectorBuilder(ObjectFieldSelector instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ObjectFieldSelectorBuilder(ObjectFieldSelectorFluent<?> fluent,ObjectFieldSelector instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ObjectFieldSelector build() {
    ObjectFieldSelector buildable = new ObjectFieldSelector(fluent.getApiVersion(), fluent.getFieldPath());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}