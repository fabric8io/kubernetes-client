package io.fabric8.istio.api.extensions.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class WasmPluginListBuilder extends WasmPluginListFluent<WasmPluginListBuilder> implements VisitableBuilder<WasmPluginList,WasmPluginListBuilder>{

  WasmPluginListFluent<?> fluent;

  public WasmPluginListBuilder() {
    this(new WasmPluginList());
  }
  
  public WasmPluginListBuilder(WasmPluginListFluent<?> fluent) {
    this(fluent, new WasmPluginList());
  }
  
  public WasmPluginListBuilder(WasmPluginList instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public WasmPluginListBuilder(WasmPluginListFluent<?> fluent,WasmPluginList instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public WasmPluginList build() {
    WasmPluginList buildable = new WasmPluginList(fluent.getApiVersion(), fluent.buildItems(), fluent.getKind(), fluent.getMetadata());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}