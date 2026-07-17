package io.fabric8.openshift.api.model.config.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class PolicyMatchExactRepositoryBuilder extends PolicyMatchExactRepositoryFluent<PolicyMatchExactRepositoryBuilder> implements VisitableBuilder<PolicyMatchExactRepository,PolicyMatchExactRepositoryBuilder>{

  PolicyMatchExactRepositoryFluent<?> fluent;

  public PolicyMatchExactRepositoryBuilder() {
    this(new PolicyMatchExactRepository());
  }
  
  public PolicyMatchExactRepositoryBuilder(PolicyMatchExactRepositoryFluent<?> fluent) {
    this(fluent, new PolicyMatchExactRepository());
  }
  
  public PolicyMatchExactRepositoryBuilder(PolicyMatchExactRepository instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public PolicyMatchExactRepositoryBuilder(PolicyMatchExactRepositoryFluent<?> fluent,PolicyMatchExactRepository instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public PolicyMatchExactRepository build() {
    PolicyMatchExactRepository buildable = new PolicyMatchExactRepository(fluent.getRepository());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}