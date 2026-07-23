package io.fabric8.openshift.api.model.config.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class InfrastructureBuilder extends InfrastructureFluent<InfrastructureBuilder> implements VisitableBuilder<Infrastructure,InfrastructureBuilder>{

  InfrastructureFluent<?> fluent;

  public InfrastructureBuilder() {
    this(new Infrastructure());
  }
  
  public InfrastructureBuilder(InfrastructureFluent<?> fluent) {
    this(fluent, new Infrastructure());
  }
  
  public InfrastructureBuilder(Infrastructure instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public InfrastructureBuilder(InfrastructureFluent<?> fluent,Infrastructure instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public Infrastructure build() {
    Infrastructure buildable = new Infrastructure(fluent.getApiVersion(), fluent.getKind(), fluent.buildMetadata(), fluent.buildSpec(), fluent.buildStatus());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}