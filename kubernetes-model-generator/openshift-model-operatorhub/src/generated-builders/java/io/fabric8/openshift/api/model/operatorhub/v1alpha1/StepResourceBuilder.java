package io.fabric8.openshift.api.model.operatorhub.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class StepResourceBuilder extends StepResourceFluent<StepResourceBuilder> implements VisitableBuilder<StepResource,StepResourceBuilder>{

  StepResourceFluent<?> fluent;

  public StepResourceBuilder() {
    this(new StepResource());
  }
  
  public StepResourceBuilder(StepResourceFluent<?> fluent) {
    this(fluent, new StepResource());
  }
  
  public StepResourceBuilder(StepResource instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public StepResourceBuilder(StepResourceFluent<?> fluent,StepResource instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public StepResource build() {
    StepResource buildable = new StepResource(fluent.getGroup(), fluent.getKind(), fluent.getManifest(), fluent.getName(), fluent.getSourceName(), fluent.getSourceNamespace(), fluent.getVersion());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}