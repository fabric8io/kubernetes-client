package io.fabric8.openshift.api.model.miscellaneous.metal3.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class DetachedAnnotationArgumentsBuilder extends DetachedAnnotationArgumentsFluent<DetachedAnnotationArgumentsBuilder> implements VisitableBuilder<DetachedAnnotationArguments,DetachedAnnotationArgumentsBuilder>{

  DetachedAnnotationArgumentsFluent<?> fluent;

  public DetachedAnnotationArgumentsBuilder() {
    this(new DetachedAnnotationArguments());
  }
  
  public DetachedAnnotationArgumentsBuilder(DetachedAnnotationArgumentsFluent<?> fluent) {
    this(fluent, new DetachedAnnotationArguments());
  }
  
  public DetachedAnnotationArgumentsBuilder(DetachedAnnotationArguments instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public DetachedAnnotationArgumentsBuilder(DetachedAnnotationArgumentsFluent<?> fluent,DetachedAnnotationArguments instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public DetachedAnnotationArguments build() {
    DetachedAnnotationArguments buildable = new DetachedAnnotationArguments(fluent.getDeleteAction(), fluent.getForce());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}