package io.fabric8.openshift.api.model.machine.v1beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class VSphereMachineProviderSpecBuilder extends VSphereMachineProviderSpecFluent<VSphereMachineProviderSpecBuilder> implements VisitableBuilder<VSphereMachineProviderSpec,VSphereMachineProviderSpecBuilder>{

  VSphereMachineProviderSpecFluent<?> fluent;

  public VSphereMachineProviderSpecBuilder() {
    this(new VSphereMachineProviderSpec());
  }
  
  public VSphereMachineProviderSpecBuilder(VSphereMachineProviderSpecFluent<?> fluent) {
    this(fluent, new VSphereMachineProviderSpec());
  }
  
  public VSphereMachineProviderSpecBuilder(VSphereMachineProviderSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public VSphereMachineProviderSpecBuilder(VSphereMachineProviderSpecFluent<?> fluent,VSphereMachineProviderSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public VSphereMachineProviderSpec build() {
    VSphereMachineProviderSpec buildable = new VSphereMachineProviderSpec(fluent.getApiVersion(), fluent.getCloneMode(), fluent.buildCredentialsSecret(), fluent.buildDataDisks(), fluent.getDiskGiB(), fluent.getKind(), fluent.getMemoryMiB(), fluent.buildMetadata(), fluent.buildNetwork(), fluent.getNumCPUs(), fluent.getNumCoresPerSocket(), fluent.getSnapshot(), fluent.getTagIDs(), fluent.getTemplate(), fluent.buildUserDataSecret(), fluent.buildWorkspace());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}