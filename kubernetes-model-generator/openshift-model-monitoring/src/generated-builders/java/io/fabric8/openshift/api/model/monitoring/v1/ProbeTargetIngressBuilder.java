package io.fabric8.openshift.api.model.monitoring.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ProbeTargetIngressBuilder extends ProbeTargetIngressFluent<ProbeTargetIngressBuilder> implements VisitableBuilder<ProbeTargetIngress,ProbeTargetIngressBuilder>{

  ProbeTargetIngressFluent<?> fluent;

  public ProbeTargetIngressBuilder() {
    this(new ProbeTargetIngress());
  }
  
  public ProbeTargetIngressBuilder(ProbeTargetIngressFluent<?> fluent) {
    this(fluent, new ProbeTargetIngress());
  }
  
  public ProbeTargetIngressBuilder(ProbeTargetIngress instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ProbeTargetIngressBuilder(ProbeTargetIngressFluent<?> fluent,ProbeTargetIngress instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ProbeTargetIngress build() {
    ProbeTargetIngress buildable = new ProbeTargetIngress(fluent.buildNamespaceSelector(), fluent.buildRelabelingConfigs(), fluent.buildSelector());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}