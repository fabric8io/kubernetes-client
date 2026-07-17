package io.fabric8.openshift.api.model.miscellaneous.cloudcredential.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class OpenStackProviderStatusBuilder extends OpenStackProviderStatusFluent<OpenStackProviderStatusBuilder> implements VisitableBuilder<OpenStackProviderStatus,OpenStackProviderStatusBuilder>{

  OpenStackProviderStatusFluent<?> fluent;

  public OpenStackProviderStatusBuilder() {
    this(new OpenStackProviderStatus());
  }
  
  public OpenStackProviderStatusBuilder(OpenStackProviderStatusFluent<?> fluent) {
    this(fluent, new OpenStackProviderStatus());
  }
  
  public OpenStackProviderStatusBuilder(OpenStackProviderStatus instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public OpenStackProviderStatusBuilder(OpenStackProviderStatusFluent<?> fluent,OpenStackProviderStatus instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public OpenStackProviderStatus build() {
    OpenStackProviderStatus buildable = new OpenStackProviderStatus(fluent.getApiVersion(), fluent.getKind());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}