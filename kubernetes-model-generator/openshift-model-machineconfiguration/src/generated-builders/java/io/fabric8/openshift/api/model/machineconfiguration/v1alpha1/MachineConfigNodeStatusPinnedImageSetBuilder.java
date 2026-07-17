package io.fabric8.openshift.api.model.machineconfiguration.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class MachineConfigNodeStatusPinnedImageSetBuilder extends MachineConfigNodeStatusPinnedImageSetFluent<MachineConfigNodeStatusPinnedImageSetBuilder> implements VisitableBuilder<MachineConfigNodeStatusPinnedImageSet,MachineConfigNodeStatusPinnedImageSetBuilder>{

  MachineConfigNodeStatusPinnedImageSetFluent<?> fluent;

  public MachineConfigNodeStatusPinnedImageSetBuilder() {
    this(new MachineConfigNodeStatusPinnedImageSet());
  }
  
  public MachineConfigNodeStatusPinnedImageSetBuilder(MachineConfigNodeStatusPinnedImageSetFluent<?> fluent) {
    this(fluent, new MachineConfigNodeStatusPinnedImageSet());
  }
  
  public MachineConfigNodeStatusPinnedImageSetBuilder(MachineConfigNodeStatusPinnedImageSet instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public MachineConfigNodeStatusPinnedImageSetBuilder(MachineConfigNodeStatusPinnedImageSetFluent<?> fluent,MachineConfigNodeStatusPinnedImageSet instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public MachineConfigNodeStatusPinnedImageSet build() {
    MachineConfigNodeStatusPinnedImageSet buildable = new MachineConfigNodeStatusPinnedImageSet(fluent.getCurrentGeneration(), fluent.getDesiredGeneration(), fluent.getLastFailedGeneration(), fluent.getLastFailedGenerationError(), fluent.getName());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}