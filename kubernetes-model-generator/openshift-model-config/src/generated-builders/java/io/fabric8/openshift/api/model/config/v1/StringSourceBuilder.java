package io.fabric8.openshift.api.model.config.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class StringSourceBuilder extends StringSourceFluent<StringSourceBuilder> implements VisitableBuilder<StringSource,StringSourceBuilder>{

  StringSourceFluent<?> fluent;

  public StringSourceBuilder() {
    this(new StringSource());
  }
  
  public StringSourceBuilder(StringSourceFluent<?> fluent) {
    this(fluent, new StringSource());
  }
  
  public StringSourceBuilder(StringSource instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public StringSourceBuilder(StringSourceFluent<?> fluent,StringSource instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public StringSource build() {
    StringSource buildable = new StringSource(fluent.getEnv(), fluent.getFile(), fluent.getKeyFile(), fluent.getValue());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}