package io.fabric8.openshift.api.model.miscellaneous.metal3.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class FirmwareSchemaBuilder extends FirmwareSchemaFluent<FirmwareSchemaBuilder> implements VisitableBuilder<FirmwareSchema,FirmwareSchemaBuilder>{

  FirmwareSchemaFluent<?> fluent;

  public FirmwareSchemaBuilder() {
    this(new FirmwareSchema());
  }
  
  public FirmwareSchemaBuilder(FirmwareSchemaFluent<?> fluent) {
    this(fluent, new FirmwareSchema());
  }
  
  public FirmwareSchemaBuilder(FirmwareSchema instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public FirmwareSchemaBuilder(FirmwareSchemaFluent<?> fluent,FirmwareSchema instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public FirmwareSchema build() {
    FirmwareSchema buildable = new FirmwareSchema(fluent.getApiVersion(), fluent.getKind(), fluent.buildMetadata(), fluent.buildSpec());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}