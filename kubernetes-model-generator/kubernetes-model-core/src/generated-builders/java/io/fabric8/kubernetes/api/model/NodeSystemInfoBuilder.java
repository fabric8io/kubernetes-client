package io.fabric8.kubernetes.api.model;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class NodeSystemInfoBuilder extends NodeSystemInfoFluent<NodeSystemInfoBuilder> implements VisitableBuilder<NodeSystemInfo,NodeSystemInfoBuilder>{

  NodeSystemInfoFluent<?> fluent;

  public NodeSystemInfoBuilder() {
    this(new NodeSystemInfo());
  }
  
  public NodeSystemInfoBuilder(NodeSystemInfoFluent<?> fluent) {
    this(fluent, new NodeSystemInfo());
  }
  
  public NodeSystemInfoBuilder(NodeSystemInfo instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public NodeSystemInfoBuilder(NodeSystemInfoFluent<?> fluent,NodeSystemInfo instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public NodeSystemInfo build() {
    NodeSystemInfo buildable = new NodeSystemInfo(fluent.getArchitecture(), fluent.getBootID(), fluent.getContainerRuntimeVersion(), fluent.getKernelVersion(), fluent.getKubeProxyVersion(), fluent.getKubeletVersion(), fluent.getMachineID(), fluent.getOperatingSystem(), fluent.getOsImage(), fluent.buildSwap(), fluent.getSystemUUID());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}