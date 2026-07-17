package io.fabric8.openshift.api.model.operator.network.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class OperatorPKISpecBuilder extends OperatorPKISpecFluent<OperatorPKISpecBuilder> implements VisitableBuilder<OperatorPKISpec,OperatorPKISpecBuilder>{

  OperatorPKISpecFluent<?> fluent;

  public OperatorPKISpecBuilder() {
    this(new OperatorPKISpec());
  }
  
  public OperatorPKISpecBuilder(OperatorPKISpecFluent<?> fluent) {
    this(fluent, new OperatorPKISpec());
  }
  
  public OperatorPKISpecBuilder(OperatorPKISpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public OperatorPKISpecBuilder(OperatorPKISpecFluent<?> fluent,OperatorPKISpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public OperatorPKISpec build() {
    OperatorPKISpec buildable = new OperatorPKISpec(fluent.buildTargetCert());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}