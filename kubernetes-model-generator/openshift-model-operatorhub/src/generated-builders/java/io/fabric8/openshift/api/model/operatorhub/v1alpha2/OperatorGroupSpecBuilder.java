package io.fabric8.openshift.api.model.operatorhub.v1alpha2;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class OperatorGroupSpecBuilder extends OperatorGroupSpecFluent<OperatorGroupSpecBuilder> implements VisitableBuilder<OperatorGroupSpec,OperatorGroupSpecBuilder>{

  OperatorGroupSpecFluent<?> fluent;

  public OperatorGroupSpecBuilder() {
    this(new OperatorGroupSpec());
  }
  
  public OperatorGroupSpecBuilder(OperatorGroupSpecFluent<?> fluent) {
    this(fluent, new OperatorGroupSpec());
  }
  
  public OperatorGroupSpecBuilder(OperatorGroupSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public OperatorGroupSpecBuilder(OperatorGroupSpecFluent<?> fluent,OperatorGroupSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public OperatorGroupSpec build() {
    OperatorGroupSpec buildable = new OperatorGroupSpec(fluent.buildSelector(), fluent.getServiceAccountName(), fluent.getStaticProvidedAPIs(), fluent.getTargetNamespaces());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}