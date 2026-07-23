package io.fabric8.openshift.api.model.operatorhub.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class RegistryServiceStatusBuilder extends RegistryServiceStatusFluent<RegistryServiceStatusBuilder> implements VisitableBuilder<RegistryServiceStatus,RegistryServiceStatusBuilder>{

  RegistryServiceStatusFluent<?> fluent;

  public RegistryServiceStatusBuilder() {
    this(new RegistryServiceStatus());
  }
  
  public RegistryServiceStatusBuilder(RegistryServiceStatusFluent<?> fluent) {
    this(fluent, new RegistryServiceStatus());
  }
  
  public RegistryServiceStatusBuilder(RegistryServiceStatus instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public RegistryServiceStatusBuilder(RegistryServiceStatusFluent<?> fluent,RegistryServiceStatus instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public RegistryServiceStatus build() {
    RegistryServiceStatus buildable = new RegistryServiceStatus(fluent.getCreatedAt(), fluent.getPort(), fluent.getProtocol(), fluent.getServiceName(), fluent.getServiceNamespace());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}