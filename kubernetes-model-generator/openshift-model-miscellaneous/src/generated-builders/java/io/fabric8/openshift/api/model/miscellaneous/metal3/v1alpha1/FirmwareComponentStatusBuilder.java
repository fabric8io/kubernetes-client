package io.fabric8.openshift.api.model.miscellaneous.metal3.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class FirmwareComponentStatusBuilder extends FirmwareComponentStatusFluent<FirmwareComponentStatusBuilder> implements VisitableBuilder<FirmwareComponentStatus,FirmwareComponentStatusBuilder>{

  FirmwareComponentStatusFluent<?> fluent;

  public FirmwareComponentStatusBuilder() {
    this(new FirmwareComponentStatus());
  }
  
  public FirmwareComponentStatusBuilder(FirmwareComponentStatusFluent<?> fluent) {
    this(fluent, new FirmwareComponentStatus());
  }
  
  public FirmwareComponentStatusBuilder(FirmwareComponentStatus instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public FirmwareComponentStatusBuilder(FirmwareComponentStatusFluent<?> fluent,FirmwareComponentStatus instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public FirmwareComponentStatus build() {
    FirmwareComponentStatus buildable = new FirmwareComponentStatus(fluent.getComponent(), fluent.getCurrentVersion(), fluent.getInitialVersion(), fluent.getLastVersionFlashed(), fluent.getUpdatedAt());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}