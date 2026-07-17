package io.fabric8.openshift.api.model.miscellaneous.metal3.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class FirmwareBuilder extends FirmwareFluent<FirmwareBuilder> implements VisitableBuilder<Firmware,FirmwareBuilder>{

  FirmwareFluent<?> fluent;

  public FirmwareBuilder() {
    this(new Firmware());
  }
  
  public FirmwareBuilder(FirmwareFluent<?> fluent) {
    this(fluent, new Firmware());
  }
  
  public FirmwareBuilder(Firmware instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public FirmwareBuilder(FirmwareFluent<?> fluent,Firmware instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public Firmware build() {
    Firmware buildable = new Firmware(fluent.buildBios());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}