package io.fabric8.istio.api.api.networking.v1alpha3;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class EnvoyFilterEnvoyConfigObjectPatchBuilder extends EnvoyFilterEnvoyConfigObjectPatchFluent<EnvoyFilterEnvoyConfigObjectPatchBuilder> implements VisitableBuilder<EnvoyFilterEnvoyConfigObjectPatch,EnvoyFilterEnvoyConfigObjectPatchBuilder>{

  EnvoyFilterEnvoyConfigObjectPatchFluent<?> fluent;

  public EnvoyFilterEnvoyConfigObjectPatchBuilder() {
    this(new EnvoyFilterEnvoyConfigObjectPatch());
  }
  
  public EnvoyFilterEnvoyConfigObjectPatchBuilder(EnvoyFilterEnvoyConfigObjectPatchFluent<?> fluent) {
    this(fluent, new EnvoyFilterEnvoyConfigObjectPatch());
  }
  
  public EnvoyFilterEnvoyConfigObjectPatchBuilder(EnvoyFilterEnvoyConfigObjectPatch instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public EnvoyFilterEnvoyConfigObjectPatchBuilder(EnvoyFilterEnvoyConfigObjectPatchFluent<?> fluent,EnvoyFilterEnvoyConfigObjectPatch instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public EnvoyFilterEnvoyConfigObjectPatch build() {
    EnvoyFilterEnvoyConfigObjectPatch buildable = new EnvoyFilterEnvoyConfigObjectPatch(fluent.getApplyTo(), fluent.buildMatch(), fluent.buildPatch());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}