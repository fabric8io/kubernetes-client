package io.fabric8.openshift.api.model.operator.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ThemeBuilder extends ThemeFluent<ThemeBuilder> implements VisitableBuilder<Theme,ThemeBuilder>{

  ThemeFluent<?> fluent;

  public ThemeBuilder() {
    this(new Theme());
  }
  
  public ThemeBuilder(ThemeFluent<?> fluent) {
    this(fluent, new Theme());
  }
  
  public ThemeBuilder(Theme instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ThemeBuilder(ThemeFluent<?> fluent,Theme instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public Theme build() {
    Theme buildable = new Theme(fluent.getMode(), fluent.buildSource());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}