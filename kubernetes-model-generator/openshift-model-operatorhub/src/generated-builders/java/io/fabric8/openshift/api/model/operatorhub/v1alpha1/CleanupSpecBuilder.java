package io.fabric8.openshift.api.model.operatorhub.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class CleanupSpecBuilder extends CleanupSpecFluent<CleanupSpecBuilder> implements VisitableBuilder<CleanupSpec,CleanupSpecBuilder>{

  CleanupSpecFluent<?> fluent;

  public CleanupSpecBuilder() {
    this(new CleanupSpec());
  }
  
  public CleanupSpecBuilder(CleanupSpecFluent<?> fluent) {
    this(fluent, new CleanupSpec());
  }
  
  public CleanupSpecBuilder(CleanupSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public CleanupSpecBuilder(CleanupSpecFluent<?> fluent,CleanupSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public CleanupSpec build() {
    CleanupSpec buildable = new CleanupSpec(fluent.getEnabled());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}