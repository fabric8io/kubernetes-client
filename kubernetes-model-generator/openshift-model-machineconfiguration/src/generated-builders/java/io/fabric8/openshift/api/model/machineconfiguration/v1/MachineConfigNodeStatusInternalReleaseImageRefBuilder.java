package io.fabric8.openshift.api.model.machineconfiguration.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class MachineConfigNodeStatusInternalReleaseImageRefBuilder extends MachineConfigNodeStatusInternalReleaseImageRefFluent<MachineConfigNodeStatusInternalReleaseImageRefBuilder> implements VisitableBuilder<MachineConfigNodeStatusInternalReleaseImageRef,MachineConfigNodeStatusInternalReleaseImageRefBuilder>{

  MachineConfigNodeStatusInternalReleaseImageRefFluent<?> fluent;

  public MachineConfigNodeStatusInternalReleaseImageRefBuilder() {
    this(new MachineConfigNodeStatusInternalReleaseImageRef());
  }
  
  public MachineConfigNodeStatusInternalReleaseImageRefBuilder(MachineConfigNodeStatusInternalReleaseImageRefFluent<?> fluent) {
    this(fluent, new MachineConfigNodeStatusInternalReleaseImageRef());
  }
  
  public MachineConfigNodeStatusInternalReleaseImageRefBuilder(MachineConfigNodeStatusInternalReleaseImageRef instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public MachineConfigNodeStatusInternalReleaseImageRefBuilder(MachineConfigNodeStatusInternalReleaseImageRefFluent<?> fluent,MachineConfigNodeStatusInternalReleaseImageRef instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public MachineConfigNodeStatusInternalReleaseImageRef build() {
    MachineConfigNodeStatusInternalReleaseImageRef buildable = new MachineConfigNodeStatusInternalReleaseImageRef(fluent.getConditions(), fluent.getImage(), fluent.getName());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}