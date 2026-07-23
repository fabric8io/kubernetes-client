package io.fabric8.istio.api.api.extensions.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class LuaConfigBuilder extends LuaConfigFluent<LuaConfigBuilder> implements VisitableBuilder<LuaConfig,LuaConfigBuilder>{

  LuaConfigFluent<?> fluent;

  public LuaConfigBuilder() {
    this(new LuaConfig());
  }
  
  public LuaConfigBuilder(LuaConfigFluent<?> fluent) {
    this(fluent, new LuaConfig());
  }
  
  public LuaConfigBuilder(LuaConfig instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public LuaConfigBuilder(LuaConfigFluent<?> fluent,LuaConfig instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public LuaConfig build() {
    LuaConfig buildable = new LuaConfig(fluent.getInlineCode());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}