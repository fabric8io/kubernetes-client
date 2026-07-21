package io.fabric8.istio.api.api.extensions.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class WasmPluginTrafficSelectorBuilder extends WasmPluginTrafficSelectorFluent<WasmPluginTrafficSelectorBuilder> implements VisitableBuilder<WasmPluginTrafficSelector,WasmPluginTrafficSelectorBuilder>{

  WasmPluginTrafficSelectorFluent<?> fluent;

  public WasmPluginTrafficSelectorBuilder() {
    this(new WasmPluginTrafficSelector());
  }
  
  public WasmPluginTrafficSelectorBuilder(WasmPluginTrafficSelectorFluent<?> fluent) {
    this(fluent, new WasmPluginTrafficSelector());
  }
  
  public WasmPluginTrafficSelectorBuilder(WasmPluginTrafficSelector instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public WasmPluginTrafficSelectorBuilder(WasmPluginTrafficSelectorFluent<?> fluent,WasmPluginTrafficSelector instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public WasmPluginTrafficSelector build() {
    WasmPluginTrafficSelector buildable = new WasmPluginTrafficSelector(fluent.getMode(), fluent.buildPorts());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}