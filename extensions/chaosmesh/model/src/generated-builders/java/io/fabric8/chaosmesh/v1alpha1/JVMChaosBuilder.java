package io.fabric8.chaosmesh.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class JVMChaosBuilder extends JVMChaosFluent<JVMChaosBuilder> implements VisitableBuilder<JVMChaos,JVMChaosBuilder>{

  JVMChaosFluent<?> fluent;

  public JVMChaosBuilder() {
    this(new JVMChaos());
  }
  
  public JVMChaosBuilder(JVMChaosFluent<?> fluent) {
    this(fluent, new JVMChaos());
  }
  
  public JVMChaosBuilder(JVMChaos instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public JVMChaosBuilder(JVMChaosFluent<?> fluent,JVMChaos instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public JVMChaos build() {
    JVMChaos buildable = new JVMChaos(fluent.getApiVersion(), fluent.getKind(), fluent.buildMetadata(), fluent.buildSpec(), fluent.buildStatus());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}