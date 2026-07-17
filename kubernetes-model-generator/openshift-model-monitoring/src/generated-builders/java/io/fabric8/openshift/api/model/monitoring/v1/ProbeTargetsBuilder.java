package io.fabric8.openshift.api.model.monitoring.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ProbeTargetsBuilder extends ProbeTargetsFluent<ProbeTargetsBuilder> implements VisitableBuilder<ProbeTargets,ProbeTargetsBuilder>{

  ProbeTargetsFluent<?> fluent;

  public ProbeTargetsBuilder() {
    this(new ProbeTargets());
  }
  
  public ProbeTargetsBuilder(ProbeTargetsFluent<?> fluent) {
    this(fluent, new ProbeTargets());
  }
  
  public ProbeTargetsBuilder(ProbeTargets instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ProbeTargetsBuilder(ProbeTargetsFluent<?> fluent,ProbeTargets instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ProbeTargets build() {
    ProbeTargets buildable = new ProbeTargets(fluent.buildIngress(), fluent.buildStaticConfig());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}