package io.fabric8.tekton.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class EmbeddedRunSpecBuilder extends EmbeddedRunSpecFluent<EmbeddedRunSpecBuilder> implements VisitableBuilder<EmbeddedRunSpec,EmbeddedRunSpecBuilder>{

  EmbeddedRunSpecFluent<?> fluent;

  public EmbeddedRunSpecBuilder() {
    this(new EmbeddedRunSpec());
  }
  
  public EmbeddedRunSpecBuilder(EmbeddedRunSpecFluent<?> fluent) {
    this(fluent, new EmbeddedRunSpec());
  }
  
  public EmbeddedRunSpecBuilder(EmbeddedRunSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public EmbeddedRunSpecBuilder(EmbeddedRunSpecFluent<?> fluent,EmbeddedRunSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public EmbeddedRunSpec build() {
    EmbeddedRunSpec buildable = new EmbeddedRunSpec(fluent.getApiVersion(), fluent.getKind(), fluent.buildMetadata(), fluent.getSpec());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}