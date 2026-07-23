package io.fabric8.chaosmesh.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class JVMChaosListBuilder extends JVMChaosListFluent<JVMChaosListBuilder> implements VisitableBuilder<JVMChaosList,JVMChaosListBuilder>{

  JVMChaosListFluent<?> fluent;

  public JVMChaosListBuilder() {
    this(new JVMChaosList());
  }
  
  public JVMChaosListBuilder(JVMChaosListFluent<?> fluent) {
    this(fluent, new JVMChaosList());
  }
  
  public JVMChaosListBuilder(JVMChaosList instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public JVMChaosListBuilder(JVMChaosListFluent<?> fluent,JVMChaosList instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public JVMChaosList build() {
    JVMChaosList buildable = new JVMChaosList(fluent.getApiVersion(), fluent.buildItems(), fluent.getKind(), fluent.getMetadata());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}