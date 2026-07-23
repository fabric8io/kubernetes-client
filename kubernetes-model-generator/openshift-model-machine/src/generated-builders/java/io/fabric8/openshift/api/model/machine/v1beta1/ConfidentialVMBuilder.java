package io.fabric8.openshift.api.model.machine.v1beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ConfidentialVMBuilder extends ConfidentialVMFluent<ConfidentialVMBuilder> implements VisitableBuilder<ConfidentialVM,ConfidentialVMBuilder>{

  ConfidentialVMFluent<?> fluent;

  public ConfidentialVMBuilder() {
    this(new ConfidentialVM());
  }
  
  public ConfidentialVMBuilder(ConfidentialVMFluent<?> fluent) {
    this(fluent, new ConfidentialVM());
  }
  
  public ConfidentialVMBuilder(ConfidentialVM instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ConfidentialVMBuilder(ConfidentialVMFluent<?> fluent,ConfidentialVM instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ConfidentialVM build() {
    ConfidentialVM buildable = new ConfidentialVM(fluent.buildUefiSettings());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}