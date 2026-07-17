package io.fabric8.openshift.api.model.miscellaneous.metal3.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class FirmwareSchemaSpecBuilder extends FirmwareSchemaSpecFluent<FirmwareSchemaSpecBuilder> implements VisitableBuilder<FirmwareSchemaSpec,FirmwareSchemaSpecBuilder>{

  FirmwareSchemaSpecFluent<?> fluent;

  public FirmwareSchemaSpecBuilder() {
    this(new FirmwareSchemaSpec());
  }
  
  public FirmwareSchemaSpecBuilder(FirmwareSchemaSpecFluent<?> fluent) {
    this(fluent, new FirmwareSchemaSpec());
  }
  
  public FirmwareSchemaSpecBuilder(FirmwareSchemaSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public FirmwareSchemaSpecBuilder(FirmwareSchemaSpecFluent<?> fluent,FirmwareSchemaSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public FirmwareSchemaSpec build() {
    FirmwareSchemaSpec buildable = new FirmwareSchemaSpec(fluent.getHardwareModel(), fluent.getHardwareVendor(), fluent.getSchema());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}