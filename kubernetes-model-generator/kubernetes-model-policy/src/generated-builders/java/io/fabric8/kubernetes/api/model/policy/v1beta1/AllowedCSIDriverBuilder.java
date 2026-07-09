package io.fabric8.kubernetes.api.model.policy.v1beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class AllowedCSIDriverBuilder extends AllowedCSIDriverFluent<AllowedCSIDriverBuilder> implements VisitableBuilder<AllowedCSIDriver,AllowedCSIDriverBuilder>{

  AllowedCSIDriverFluent<?> fluent;

  public AllowedCSIDriverBuilder() {
    this(new AllowedCSIDriver());
  }
  
  public AllowedCSIDriverBuilder(AllowedCSIDriverFluent<?> fluent) {
    this(fluent, new AllowedCSIDriver());
  }
  
  public AllowedCSIDriverBuilder(AllowedCSIDriver instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public AllowedCSIDriverBuilder(AllowedCSIDriverFluent<?> fluent,AllowedCSIDriver instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public AllowedCSIDriver build() {
    AllowedCSIDriver buildable = new AllowedCSIDriver(fluent.getName());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}