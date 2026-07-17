package io.fabric8.openshift.api.model.operator.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class OperatorSpecBuilder extends OperatorSpecFluent<OperatorSpecBuilder> implements VisitableBuilder<OperatorSpec,OperatorSpecBuilder>{

  OperatorSpecFluent<?> fluent;

  public OperatorSpecBuilder() {
    this(new OperatorSpec());
  }
  
  public OperatorSpecBuilder(OperatorSpecFluent<?> fluent) {
    this(fluent, new OperatorSpec());
  }
  
  public OperatorSpecBuilder(OperatorSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public OperatorSpecBuilder(OperatorSpecFluent<?> fluent,OperatorSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public OperatorSpec build() {
    OperatorSpec buildable = new OperatorSpec(fluent.getImagePullPolicy(), fluent.getImagePullSpec(), fluent.buildLogging(), fluent.getManagementState(), fluent.getVersion());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}