package io.fabric8.openshift.api.model.miscellaneous.metal3.v1beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class Metal3MachineBuilder extends Metal3MachineFluent<Metal3MachineBuilder> implements VisitableBuilder<Metal3Machine,Metal3MachineBuilder>{

  Metal3MachineFluent<?> fluent;

  public Metal3MachineBuilder() {
    this(new Metal3Machine());
  }
  
  public Metal3MachineBuilder(Metal3MachineFluent<?> fluent) {
    this(fluent, new Metal3Machine());
  }
  
  public Metal3MachineBuilder(Metal3Machine instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public Metal3MachineBuilder(Metal3MachineFluent<?> fluent,Metal3Machine instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public Metal3Machine build() {
    Metal3Machine buildable = new Metal3Machine(fluent.getApiVersion(), fluent.getKind(), fluent.buildMetadata(), fluent.buildSpec(), fluent.buildStatus());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}