package io.fabric8.openshift.api.model.miscellaneous.metal3.v1beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class FromPoolAnnotationBuilder extends FromPoolAnnotationFluent<FromPoolAnnotationBuilder> implements VisitableBuilder<FromPoolAnnotation,FromPoolAnnotationBuilder>{

  FromPoolAnnotationFluent<?> fluent;

  public FromPoolAnnotationBuilder() {
    this(new FromPoolAnnotation());
  }
  
  public FromPoolAnnotationBuilder(FromPoolAnnotationFluent<?> fluent) {
    this(fluent, new FromPoolAnnotation());
  }
  
  public FromPoolAnnotationBuilder(FromPoolAnnotation instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public FromPoolAnnotationBuilder(FromPoolAnnotationFluent<?> fluent,FromPoolAnnotation instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public FromPoolAnnotation build() {
    FromPoolAnnotation buildable = new FromPoolAnnotation(fluent.getAnnotation(), fluent.getObject());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}