package io.fabric8.openshift.api.model.miscellaneous.metal3.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class RebootAnnotationArgumentsBuilder extends RebootAnnotationArgumentsFluent<RebootAnnotationArgumentsBuilder> implements VisitableBuilder<RebootAnnotationArguments,RebootAnnotationArgumentsBuilder>{

  RebootAnnotationArgumentsFluent<?> fluent;

  public RebootAnnotationArgumentsBuilder() {
    this(new RebootAnnotationArguments());
  }
  
  public RebootAnnotationArgumentsBuilder(RebootAnnotationArgumentsFluent<?> fluent) {
    this(fluent, new RebootAnnotationArguments());
  }
  
  public RebootAnnotationArgumentsBuilder(RebootAnnotationArguments instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public RebootAnnotationArgumentsBuilder(RebootAnnotationArgumentsFluent<?> fluent,RebootAnnotationArguments instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public RebootAnnotationArguments build() {
    RebootAnnotationArguments buildable = new RebootAnnotationArguments(fluent.getForce(), fluent.getMode());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}