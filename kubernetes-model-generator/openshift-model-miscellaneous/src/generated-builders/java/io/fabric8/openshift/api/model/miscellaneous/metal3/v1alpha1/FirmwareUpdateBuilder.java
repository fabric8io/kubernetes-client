package io.fabric8.openshift.api.model.miscellaneous.metal3.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class FirmwareUpdateBuilder extends FirmwareUpdateFluent<FirmwareUpdateBuilder> implements VisitableBuilder<FirmwareUpdate,FirmwareUpdateBuilder>{

  FirmwareUpdateFluent<?> fluent;

  public FirmwareUpdateBuilder() {
    this(new FirmwareUpdate());
  }
  
  public FirmwareUpdateBuilder(FirmwareUpdateFluent<?> fluent) {
    this(fluent, new FirmwareUpdate());
  }
  
  public FirmwareUpdateBuilder(FirmwareUpdate instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public FirmwareUpdateBuilder(FirmwareUpdateFluent<?> fluent,FirmwareUpdate instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public FirmwareUpdate build() {
    FirmwareUpdate buildable = new FirmwareUpdate(fluent.getComponent(), fluent.getUrl());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}