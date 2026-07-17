package io.fabric8.openshift.api.model.machine.v1beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ObjectMetaBuilder extends ObjectMetaFluent<ObjectMetaBuilder> implements VisitableBuilder<ObjectMeta,ObjectMetaBuilder>{

  ObjectMetaFluent<?> fluent;

  public ObjectMetaBuilder() {
    this(new ObjectMeta());
  }
  
  public ObjectMetaBuilder(ObjectMetaFluent<?> fluent) {
    this(fluent, new ObjectMeta());
  }
  
  public ObjectMetaBuilder(ObjectMeta instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ObjectMetaBuilder(ObjectMetaFluent<?> fluent,ObjectMeta instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ObjectMeta build() {
    ObjectMeta buildable = new ObjectMeta(fluent.getAnnotations(), fluent.getGenerateName(), fluent.getLabels(), fluent.getName(), fluent.getNamespace(), fluent.getOwnerReferences());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}