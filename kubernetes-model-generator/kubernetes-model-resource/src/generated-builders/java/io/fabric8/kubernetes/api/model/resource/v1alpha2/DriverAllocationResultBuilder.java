package io.fabric8.kubernetes.api.model.resource.v1alpha2;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class DriverAllocationResultBuilder extends DriverAllocationResultFluent<DriverAllocationResultBuilder> implements VisitableBuilder<DriverAllocationResult,DriverAllocationResultBuilder>{

  DriverAllocationResultFluent<?> fluent;

  public DriverAllocationResultBuilder() {
    this(new DriverAllocationResult());
  }
  
  public DriverAllocationResultBuilder(DriverAllocationResultFluent<?> fluent) {
    this(fluent, new DriverAllocationResult());
  }
  
  public DriverAllocationResultBuilder(DriverAllocationResult instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public DriverAllocationResultBuilder(DriverAllocationResultFluent<?> fluent,DriverAllocationResult instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public DriverAllocationResult build() {
    DriverAllocationResult buildable = new DriverAllocationResult(fluent.buildNamedResources(), fluent.getVendorRequestParameters());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}