package io.fabric8.openshift.api.model.console.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ConsoleSampleSpecBuilder extends ConsoleSampleSpecFluent<ConsoleSampleSpecBuilder> implements VisitableBuilder<ConsoleSampleSpec,ConsoleSampleSpecBuilder>{

  ConsoleSampleSpecFluent<?> fluent;

  public ConsoleSampleSpecBuilder() {
    this(new ConsoleSampleSpec());
  }
  
  public ConsoleSampleSpecBuilder(ConsoleSampleSpecFluent<?> fluent) {
    this(fluent, new ConsoleSampleSpec());
  }
  
  public ConsoleSampleSpecBuilder(ConsoleSampleSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ConsoleSampleSpecBuilder(ConsoleSampleSpecFluent<?> fluent,ConsoleSampleSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ConsoleSampleSpec build() {
    ConsoleSampleSpec buildable = new ConsoleSampleSpec(fluent.getAbstract(), fluent.getDescription(), fluent.getIcon(), fluent.getProvider(), fluent.buildSource(), fluent.getTags(), fluent.getTitle(), fluent.getType());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}