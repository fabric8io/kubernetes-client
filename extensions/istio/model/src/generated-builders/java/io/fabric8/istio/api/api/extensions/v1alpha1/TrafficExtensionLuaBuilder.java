package io.fabric8.istio.api.api.extensions.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class TrafficExtensionLuaBuilder extends TrafficExtensionLuaFluent<TrafficExtensionLuaBuilder> implements VisitableBuilder<TrafficExtensionLua,TrafficExtensionLuaBuilder>{

  TrafficExtensionLuaFluent<?> fluent;

  public TrafficExtensionLuaBuilder() {
    this(new TrafficExtensionLua());
  }
  
  public TrafficExtensionLuaBuilder(TrafficExtensionLuaFluent<?> fluent) {
    this(fluent, new TrafficExtensionLua());
  }
  
  public TrafficExtensionLuaBuilder(TrafficExtensionLua instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public TrafficExtensionLuaBuilder(TrafficExtensionLuaFluent<?> fluent,TrafficExtensionLua instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public TrafficExtensionLua build() {
    TrafficExtensionLua buildable = new TrafficExtensionLua(fluent.buildLua());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}