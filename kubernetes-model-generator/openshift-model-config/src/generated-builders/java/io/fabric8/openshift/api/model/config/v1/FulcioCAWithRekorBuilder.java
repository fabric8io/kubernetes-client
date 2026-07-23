package io.fabric8.openshift.api.model.config.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class FulcioCAWithRekorBuilder extends FulcioCAWithRekorFluent<FulcioCAWithRekorBuilder> implements VisitableBuilder<FulcioCAWithRekor,FulcioCAWithRekorBuilder>{

  FulcioCAWithRekorFluent<?> fluent;

  public FulcioCAWithRekorBuilder() {
    this(new FulcioCAWithRekor());
  }
  
  public FulcioCAWithRekorBuilder(FulcioCAWithRekorFluent<?> fluent) {
    this(fluent, new FulcioCAWithRekor());
  }
  
  public FulcioCAWithRekorBuilder(FulcioCAWithRekor instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public FulcioCAWithRekorBuilder(FulcioCAWithRekorFluent<?> fluent,FulcioCAWithRekor instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public FulcioCAWithRekor build() {
    FulcioCAWithRekor buildable = new FulcioCAWithRekor(fluent.getFulcioCAData(), fluent.buildFulcioSubject(), fluent.getRekorKeyData());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}