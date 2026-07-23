package io.fabric8.openshift.api.model.miscellaneous.metal3.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class FirmwareSchemaListBuilder extends FirmwareSchemaListFluent<FirmwareSchemaListBuilder> implements VisitableBuilder<FirmwareSchemaList,FirmwareSchemaListBuilder>{

  FirmwareSchemaListFluent<?> fluent;

  public FirmwareSchemaListBuilder() {
    this(new FirmwareSchemaList());
  }
  
  public FirmwareSchemaListBuilder(FirmwareSchemaListFluent<?> fluent) {
    this(fluent, new FirmwareSchemaList());
  }
  
  public FirmwareSchemaListBuilder(FirmwareSchemaList instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public FirmwareSchemaListBuilder(FirmwareSchemaListFluent<?> fluent,FirmwareSchemaList instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public FirmwareSchemaList build() {
    FirmwareSchemaList buildable = new FirmwareSchemaList(fluent.getApiVersion(), fluent.buildItems(), fluent.getKind(), fluent.getMetadata());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}