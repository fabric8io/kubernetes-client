package io.fabric8.openclustermanagement.api.model.observability.v1beta2;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class UIConfigBuilder extends UIConfigFluent<UIConfigBuilder> implements VisitableBuilder<UIConfig,UIConfigBuilder>{

  UIConfigFluent<?> fluent;

  public UIConfigBuilder() {
    this(new UIConfig());
  }
  
  public UIConfigBuilder(UIConfigFluent<?> fluent) {
    this(fluent, new UIConfig());
  }
  
  public UIConfigBuilder(UIConfig instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public UIConfigBuilder(UIConfigFluent<?> fluent,UIConfig instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public UIConfig build() {
    UIConfig buildable = new UIConfig(fluent.getEnabled());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}