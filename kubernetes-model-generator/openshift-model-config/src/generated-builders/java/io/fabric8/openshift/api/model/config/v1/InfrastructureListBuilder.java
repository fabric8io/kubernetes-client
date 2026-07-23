package io.fabric8.openshift.api.model.config.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class InfrastructureListBuilder extends InfrastructureListFluent<InfrastructureListBuilder> implements VisitableBuilder<InfrastructureList,InfrastructureListBuilder>{

  InfrastructureListFluent<?> fluent;

  public InfrastructureListBuilder() {
    this(new InfrastructureList());
  }
  
  public InfrastructureListBuilder(InfrastructureListFluent<?> fluent) {
    this(fluent, new InfrastructureList());
  }
  
  public InfrastructureListBuilder(InfrastructureList instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public InfrastructureListBuilder(InfrastructureListFluent<?> fluent,InfrastructureList instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public InfrastructureList build() {
    InfrastructureList buildable = new InfrastructureList(fluent.getApiVersion(), fluent.buildItems(), fluent.getKind(), fluent.getMetadata());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}