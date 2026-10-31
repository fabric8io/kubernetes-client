package io.fabric8.openshift.api.model.machineconfiguration.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class MachineConfigNodeStatusInternalReleaseImageBuilder extends MachineConfigNodeStatusInternalReleaseImageFluent<MachineConfigNodeStatusInternalReleaseImageBuilder> implements VisitableBuilder<MachineConfigNodeStatusInternalReleaseImage,MachineConfigNodeStatusInternalReleaseImageBuilder>{

  MachineConfigNodeStatusInternalReleaseImageFluent<?> fluent;

  public MachineConfigNodeStatusInternalReleaseImageBuilder() {
    this(new MachineConfigNodeStatusInternalReleaseImage());
  }
  
  public MachineConfigNodeStatusInternalReleaseImageBuilder(MachineConfigNodeStatusInternalReleaseImageFluent<?> fluent) {
    this(fluent, new MachineConfigNodeStatusInternalReleaseImage());
  }
  
  public MachineConfigNodeStatusInternalReleaseImageBuilder(MachineConfigNodeStatusInternalReleaseImage instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public MachineConfigNodeStatusInternalReleaseImageBuilder(MachineConfigNodeStatusInternalReleaseImageFluent<?> fluent,MachineConfigNodeStatusInternalReleaseImage instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public MachineConfigNodeStatusInternalReleaseImage build() {
    MachineConfigNodeStatusInternalReleaseImage buildable = new MachineConfigNodeStatusInternalReleaseImage(fluent.buildReleases());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}