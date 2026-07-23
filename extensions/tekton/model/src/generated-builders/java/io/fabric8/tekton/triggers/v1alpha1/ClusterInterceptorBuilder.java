package io.fabric8.tekton.triggers.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ClusterInterceptorBuilder extends ClusterInterceptorFluent<ClusterInterceptorBuilder> implements VisitableBuilder<ClusterInterceptor,ClusterInterceptorBuilder>{

  ClusterInterceptorFluent<?> fluent;

  public ClusterInterceptorBuilder() {
    this(new ClusterInterceptor());
  }
  
  public ClusterInterceptorBuilder(ClusterInterceptorFluent<?> fluent) {
    this(fluent, new ClusterInterceptor());
  }
  
  public ClusterInterceptorBuilder(ClusterInterceptor instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ClusterInterceptorBuilder(ClusterInterceptorFluent<?> fluent,ClusterInterceptor instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ClusterInterceptor build() {
    ClusterInterceptor buildable = new ClusterInterceptor(fluent.getApiVersion(), fluent.getKind(), fluent.buildMetadata(), fluent.buildSpec(), fluent.buildStatus());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}