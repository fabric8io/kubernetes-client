package io.fabric8.openshift.api.model.operatorhub.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class DependentStatusBuilder extends DependentStatusFluent<DependentStatusBuilder> implements VisitableBuilder<DependentStatus,DependentStatusBuilder>{

  DependentStatusFluent<?> fluent;

  public DependentStatusBuilder() {
    this(new DependentStatus());
  }
  
  public DependentStatusBuilder(DependentStatusFluent<?> fluent) {
    this(fluent, new DependentStatus());
  }
  
  public DependentStatusBuilder(DependentStatus instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public DependentStatusBuilder(DependentStatusFluent<?> fluent,DependentStatus instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public DependentStatus build() {
    DependentStatus buildable = new DependentStatus(fluent.getGroup(), fluent.getKind(), fluent.getMessage(), fluent.getStatus(), fluent.getUuid(), fluent.getVersion());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}