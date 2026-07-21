package io.fabric8.tekton.triggers.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class InterceptorListBuilder extends InterceptorListFluent<InterceptorListBuilder> implements VisitableBuilder<InterceptorList,InterceptorListBuilder>{

  InterceptorListFluent<?> fluent;

  public InterceptorListBuilder() {
    this(new InterceptorList());
  }
  
  public InterceptorListBuilder(InterceptorListFluent<?> fluent) {
    this(fluent, new InterceptorList());
  }
  
  public InterceptorListBuilder(InterceptorList instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public InterceptorListBuilder(InterceptorListFluent<?> fluent,InterceptorList instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public InterceptorList build() {
    InterceptorList buildable = new InterceptorList(fluent.getApiVersion(), fluent.buildItems(), fluent.getKind(), fluent.getMetadata());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}