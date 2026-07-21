package io.fabric8.istio.api.api.extensions.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class WasmConfigBuilder extends WasmConfigFluent<WasmConfigBuilder> implements VisitableBuilder<WasmConfig,WasmConfigBuilder>{

  WasmConfigFluent<?> fluent;

  public WasmConfigBuilder() {
    this(new WasmConfig());
  }
  
  public WasmConfigBuilder(WasmConfigFluent<?> fluent) {
    this(fluent, new WasmConfig());
  }
  
  public WasmConfigBuilder(WasmConfig instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public WasmConfigBuilder(WasmConfigFluent<?> fluent,WasmConfig instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public WasmConfig build() {
    WasmConfig buildable = new WasmConfig(fluent.getFailStrategy(), fluent.getImagePullPolicy(), fluent.getImagePullSecret(), fluent.getPluginConfig(), fluent.getPluginName(), fluent.getSha256(), fluent.getType(), fluent.getUrl(), fluent.getVerificationKey(), fluent.buildVmConfig());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}