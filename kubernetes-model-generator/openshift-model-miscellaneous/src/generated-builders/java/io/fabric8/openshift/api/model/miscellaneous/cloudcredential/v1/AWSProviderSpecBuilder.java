package io.fabric8.openshift.api.model.miscellaneous.cloudcredential.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class AWSProviderSpecBuilder extends AWSProviderSpecFluent<AWSProviderSpecBuilder> implements VisitableBuilder<AWSProviderSpec,AWSProviderSpecBuilder>{

  AWSProviderSpecFluent<?> fluent;

  public AWSProviderSpecBuilder() {
    this(new AWSProviderSpec());
  }
  
  public AWSProviderSpecBuilder(AWSProviderSpecFluent<?> fluent) {
    this(fluent, new AWSProviderSpec());
  }
  
  public AWSProviderSpecBuilder(AWSProviderSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public AWSProviderSpecBuilder(AWSProviderSpecFluent<?> fluent,AWSProviderSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public AWSProviderSpec build() {
    AWSProviderSpec buildable = new AWSProviderSpec(fluent.getApiVersion(), fluent.getKind(), fluent.buildStatementEntries(), fluent.getStsIAMRoleARN());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}