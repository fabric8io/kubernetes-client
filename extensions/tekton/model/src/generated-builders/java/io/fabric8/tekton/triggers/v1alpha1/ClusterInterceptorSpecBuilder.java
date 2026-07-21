package io.fabric8.tekton.triggers.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ClusterInterceptorSpecBuilder extends ClusterInterceptorSpecFluent<ClusterInterceptorSpecBuilder> implements VisitableBuilder<ClusterInterceptorSpec,ClusterInterceptorSpecBuilder>{

  ClusterInterceptorSpecFluent<?> fluent;

  public ClusterInterceptorSpecBuilder() {
    this(new ClusterInterceptorSpec());
  }
  
  public ClusterInterceptorSpecBuilder(ClusterInterceptorSpecFluent<?> fluent) {
    this(fluent, new ClusterInterceptorSpec());
  }
  
  public ClusterInterceptorSpecBuilder(ClusterInterceptorSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ClusterInterceptorSpecBuilder(ClusterInterceptorSpecFluent<?> fluent,ClusterInterceptorSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ClusterInterceptorSpec build() {
    ClusterInterceptorSpec buildable = new ClusterInterceptorSpec(fluent.buildClientConfig());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}