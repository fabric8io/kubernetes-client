package io.fabric8.openshift.api.model.operator.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ServiceCABuilder extends ServiceCAFluent<ServiceCABuilder> implements VisitableBuilder<ServiceCA,ServiceCABuilder>{

  ServiceCAFluent<?> fluent;

  public ServiceCABuilder() {
    this(new ServiceCA());
  }
  
  public ServiceCABuilder(ServiceCAFluent<?> fluent) {
    this(fluent, new ServiceCA());
  }
  
  public ServiceCABuilder(ServiceCA instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ServiceCABuilder(ServiceCAFluent<?> fluent,ServiceCA instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ServiceCA build() {
    ServiceCA buildable = new ServiceCA(fluent.getApiVersion(), fluent.getKind(), fluent.buildMetadata(), fluent.buildSpec(), fluent.buildStatus());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}