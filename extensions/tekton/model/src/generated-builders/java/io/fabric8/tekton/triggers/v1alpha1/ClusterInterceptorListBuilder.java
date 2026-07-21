package io.fabric8.tekton.triggers.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ClusterInterceptorListBuilder extends ClusterInterceptorListFluent<ClusterInterceptorListBuilder> implements VisitableBuilder<ClusterInterceptorList,ClusterInterceptorListBuilder>{

  ClusterInterceptorListFluent<?> fluent;

  public ClusterInterceptorListBuilder() {
    this(new ClusterInterceptorList());
  }
  
  public ClusterInterceptorListBuilder(ClusterInterceptorListFluent<?> fluent) {
    this(fluent, new ClusterInterceptorList());
  }
  
  public ClusterInterceptorListBuilder(ClusterInterceptorList instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ClusterInterceptorListBuilder(ClusterInterceptorListFluent<?> fluent,ClusterInterceptorList instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ClusterInterceptorList build() {
    ClusterInterceptorList buildable = new ClusterInterceptorList(fluent.getApiVersion(), fluent.buildItems(), fluent.getKind(), fluent.getMetadata());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}