package io.fabric8.openshift.api.model.machine.v1beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class EBSBlockDeviceSpecBuilder extends EBSBlockDeviceSpecFluent<EBSBlockDeviceSpecBuilder> implements VisitableBuilder<EBSBlockDeviceSpec,EBSBlockDeviceSpecBuilder>{

  EBSBlockDeviceSpecFluent<?> fluent;

  public EBSBlockDeviceSpecBuilder() {
    this(new EBSBlockDeviceSpec());
  }
  
  public EBSBlockDeviceSpecBuilder(EBSBlockDeviceSpecFluent<?> fluent) {
    this(fluent, new EBSBlockDeviceSpec());
  }
  
  public EBSBlockDeviceSpecBuilder(EBSBlockDeviceSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public EBSBlockDeviceSpecBuilder(EBSBlockDeviceSpecFluent<?> fluent,EBSBlockDeviceSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public EBSBlockDeviceSpec build() {
    EBSBlockDeviceSpec buildable = new EBSBlockDeviceSpec(fluent.getDeleteOnTermination(), fluent.getEncrypted(), fluent.getIops(), fluent.buildKmsKey(), fluent.getVolumeSize(), fluent.getVolumeType());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}