package io.fabric8.tekton.v1beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class EmbeddedCustomRunSpecBuilder extends EmbeddedCustomRunSpecFluent<EmbeddedCustomRunSpecBuilder> implements VisitableBuilder<EmbeddedCustomRunSpec,EmbeddedCustomRunSpecBuilder>{

  EmbeddedCustomRunSpecFluent<?> fluent;

  public EmbeddedCustomRunSpecBuilder() {
    this(new EmbeddedCustomRunSpec());
  }
  
  public EmbeddedCustomRunSpecBuilder(EmbeddedCustomRunSpecFluent<?> fluent) {
    this(fluent, new EmbeddedCustomRunSpec());
  }
  
  public EmbeddedCustomRunSpecBuilder(EmbeddedCustomRunSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public EmbeddedCustomRunSpecBuilder(EmbeddedCustomRunSpecFluent<?> fluent,EmbeddedCustomRunSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public EmbeddedCustomRunSpec build() {
    EmbeddedCustomRunSpec buildable = new EmbeddedCustomRunSpec(fluent.getApiVersion(), fluent.getKind(), fluent.buildMetadata(), fluent.getSpec());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}