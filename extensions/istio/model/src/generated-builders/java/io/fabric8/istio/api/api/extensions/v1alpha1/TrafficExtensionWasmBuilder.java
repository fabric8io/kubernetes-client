package io.fabric8.istio.api.api.extensions.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class TrafficExtensionWasmBuilder extends TrafficExtensionWasmFluent<TrafficExtensionWasmBuilder> implements VisitableBuilder<TrafficExtensionWasm,TrafficExtensionWasmBuilder>{

  TrafficExtensionWasmFluent<?> fluent;

  public TrafficExtensionWasmBuilder() {
    this(new TrafficExtensionWasm());
  }
  
  public TrafficExtensionWasmBuilder(TrafficExtensionWasmFluent<?> fluent) {
    this(fluent, new TrafficExtensionWasm());
  }
  
  public TrafficExtensionWasmBuilder(TrafficExtensionWasm instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public TrafficExtensionWasmBuilder(TrafficExtensionWasmFluent<?> fluent,TrafficExtensionWasm instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public TrafficExtensionWasm build() {
    TrafficExtensionWasm buildable = new TrafficExtensionWasm(fluent.buildWasm());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}