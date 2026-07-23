package io.fabric8.openshift.api.model.operator.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ReloadServiceBuilder extends ReloadServiceFluent<ReloadServiceBuilder> implements VisitableBuilder<ReloadService,ReloadServiceBuilder>{

  ReloadServiceFluent<?> fluent;

  public ReloadServiceBuilder() {
    this(new ReloadService());
  }
  
  public ReloadServiceBuilder(ReloadServiceFluent<?> fluent) {
    this(fluent, new ReloadService());
  }
  
  public ReloadServiceBuilder(ReloadService instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ReloadServiceBuilder(ReloadServiceFluent<?> fluent,ReloadService instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ReloadService build() {
    ReloadService buildable = new ReloadService(fluent.getServiceName());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}