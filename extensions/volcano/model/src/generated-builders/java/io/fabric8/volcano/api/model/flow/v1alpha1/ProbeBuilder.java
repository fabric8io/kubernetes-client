package io.fabric8.volcano.api.model.flow.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ProbeBuilder extends ProbeFluent<ProbeBuilder> implements VisitableBuilder<Probe,ProbeBuilder>{

  ProbeFluent<?> fluent;

  public ProbeBuilder() {
    this(new Probe());
  }
  
  public ProbeBuilder(ProbeFluent<?> fluent) {
    this(fluent, new Probe());
  }
  
  public ProbeBuilder(Probe instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ProbeBuilder(ProbeFluent<?> fluent,Probe instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public Probe build() {
    Probe buildable = new Probe(fluent.buildHttpGetList(), fluent.buildTaskStatusList(), fluent.buildTcpSocketList());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}