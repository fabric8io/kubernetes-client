package io.fabric8.openshift.api.model.machineconfiguration.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class MachineConfigNodeBuilder extends MachineConfigNodeFluent<MachineConfigNodeBuilder> implements VisitableBuilder<MachineConfigNode,MachineConfigNodeBuilder>{

  MachineConfigNodeFluent<?> fluent;

  public MachineConfigNodeBuilder() {
    this(new MachineConfigNode());
  }
  
  public MachineConfigNodeBuilder(MachineConfigNodeFluent<?> fluent) {
    this(fluent, new MachineConfigNode());
  }
  
  public MachineConfigNodeBuilder(MachineConfigNode instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public MachineConfigNodeBuilder(MachineConfigNodeFluent<?> fluent,MachineConfigNode instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public MachineConfigNode build() {
    MachineConfigNode buildable = new MachineConfigNode(fluent.getApiVersion(), fluent.getKind(), fluent.buildMetadata(), fluent.buildSpec(), fluent.buildStatus());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}