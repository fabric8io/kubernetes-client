package io.fabric8.openshift.api.model.miscellaneous.cloudcredential.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class AWSProviderStatusBuilder extends AWSProviderStatusFluent<AWSProviderStatusBuilder> implements VisitableBuilder<AWSProviderStatus,AWSProviderStatusBuilder>{

  AWSProviderStatusFluent<?> fluent;

  public AWSProviderStatusBuilder() {
    this(new AWSProviderStatus());
  }
  
  public AWSProviderStatusBuilder(AWSProviderStatusFluent<?> fluent) {
    this(fluent, new AWSProviderStatus());
  }
  
  public AWSProviderStatusBuilder(AWSProviderStatus instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public AWSProviderStatusBuilder(AWSProviderStatusFluent<?> fluent,AWSProviderStatus instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public AWSProviderStatus build() {
    AWSProviderStatus buildable = new AWSProviderStatus(fluent.getApiVersion(), fluent.getKind(), fluent.getPolicy(), fluent.getUser());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}