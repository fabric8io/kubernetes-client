package io.fabric8.istio.api.api.extensions.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class WasmPluginBuilder extends WasmPluginFluent<WasmPluginBuilder> implements VisitableBuilder<WasmPlugin,WasmPluginBuilder>{

  WasmPluginFluent<?> fluent;

  public WasmPluginBuilder() {
    this(new WasmPlugin());
  }
  
  public WasmPluginBuilder(WasmPluginFluent<?> fluent) {
    this(fluent, new WasmPlugin());
  }
  
  public WasmPluginBuilder(WasmPlugin instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public WasmPluginBuilder(WasmPluginFluent<?> fluent,WasmPlugin instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public WasmPlugin build() {
    WasmPlugin buildable = new WasmPlugin(fluent.getFailStrategy(), fluent.getImagePullPolicy(), fluent.getImagePullSecret(), fluent.buildMatch(), fluent.getPhase(), fluent.getPluginConfig(), fluent.getPluginName(), fluent.getPriority(), fluent.buildSelector(), fluent.getSha256(), fluent.buildTargetRef(), fluent.buildTargetRefs(), fluent.getType(), fluent.getUrl(), fluent.getVerificationKey(), fluent.buildVmConfig());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}