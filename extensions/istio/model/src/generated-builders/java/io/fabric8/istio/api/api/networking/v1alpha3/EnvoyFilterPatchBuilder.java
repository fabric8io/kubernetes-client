package io.fabric8.istio.api.api.networking.v1alpha3;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class EnvoyFilterPatchBuilder extends EnvoyFilterPatchFluent<EnvoyFilterPatchBuilder> implements VisitableBuilder<EnvoyFilterPatch,EnvoyFilterPatchBuilder>{

  EnvoyFilterPatchFluent<?> fluent;

  public EnvoyFilterPatchBuilder() {
    this(new EnvoyFilterPatch());
  }
  
  public EnvoyFilterPatchBuilder(EnvoyFilterPatchFluent<?> fluent) {
    this(fluent, new EnvoyFilterPatch());
  }
  
  public EnvoyFilterPatchBuilder(EnvoyFilterPatch instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public EnvoyFilterPatchBuilder(EnvoyFilterPatchFluent<?> fluent,EnvoyFilterPatch instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public EnvoyFilterPatch build() {
    EnvoyFilterPatch buildable = new EnvoyFilterPatch(fluent.getFilterClass(), fluent.getOperation(), fluent.getValue());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}