package io.fabric8.istio.api.extensions.v1alpha1;

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
    WasmPlugin buildable = new WasmPlugin(fluent.getApiVersion(), fluent.getKind(), fluent.buildMetadata(), fluent.buildSpec(), fluent.buildStatus());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}