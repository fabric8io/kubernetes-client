package io.fabric8.kubernetes.api.model;

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
    ObjectMeta buildable = new ObjectMeta(fluent.getAnnotations(), fluent.getCreationTimestamp(), fluent.getDeletionGracePeriodSeconds(), fluent.getDeletionTimestamp(), fluent.getFinalizers(), fluent.getGenerateName(), fluent.getGeneration(), fluent.getLabels(), fluent.buildManagedFields(), fluent.getName(), fluent.getNamespace(), fluent.buildOwnerReferences(), fluent.getResourceVersion(), fluent.getSelfLink(), fluent.getUid());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}