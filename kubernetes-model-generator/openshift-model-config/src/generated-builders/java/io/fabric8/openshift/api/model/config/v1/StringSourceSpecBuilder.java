package io.fabric8.openshift.api.model.config.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class StringSourceSpecBuilder extends StringSourceSpecFluent<StringSourceSpecBuilder> implements VisitableBuilder<StringSourceSpec,StringSourceSpecBuilder>{

  StringSourceSpecFluent<?> fluent;

  public StringSourceSpecBuilder() {
    this(new StringSourceSpec());
  }
  
  public StringSourceSpecBuilder(StringSourceSpecFluent<?> fluent) {
    this(fluent, new StringSourceSpec());
  }
  
  public StringSourceSpecBuilder(StringSourceSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public StringSourceSpecBuilder(StringSourceSpecFluent<?> fluent,StringSourceSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public StringSourceSpec build() {
    StringSourceSpec buildable = new StringSourceSpec(fluent.getEnv(), fluent.getFile(), fluent.getKeyFile(), fluent.getValue());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}