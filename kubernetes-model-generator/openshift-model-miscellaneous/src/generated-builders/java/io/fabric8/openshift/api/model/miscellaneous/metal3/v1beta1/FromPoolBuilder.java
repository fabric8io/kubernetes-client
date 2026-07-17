package io.fabric8.openshift.api.model.miscellaneous.metal3.v1beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class FromPoolBuilder extends FromPoolFluent<FromPoolBuilder> implements VisitableBuilder<FromPool,FromPoolBuilder>{

  FromPoolFluent<?> fluent;

  public FromPoolBuilder() {
    this(new FromPool());
  }
  
  public FromPoolBuilder(FromPoolFluent<?> fluent) {
    this(fluent, new FromPool());
  }
  
  public FromPoolBuilder(FromPool instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public FromPoolBuilder(FromPoolFluent<?> fluent,FromPool instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public FromPool build() {
    FromPool buildable = new FromPool(fluent.getApiGroup(), fluent.getKey(), fluent.getKind(), fluent.getName());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}