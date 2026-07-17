package io.fabric8.openshift.api.model.console.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ConsoleLinkSpecBuilder extends ConsoleLinkSpecFluent<ConsoleLinkSpecBuilder> implements VisitableBuilder<ConsoleLinkSpec,ConsoleLinkSpecBuilder>{

  ConsoleLinkSpecFluent<?> fluent;

  public ConsoleLinkSpecBuilder() {
    this(new ConsoleLinkSpec());
  }
  
  public ConsoleLinkSpecBuilder(ConsoleLinkSpecFluent<?> fluent) {
    this(fluent, new ConsoleLinkSpec());
  }
  
  public ConsoleLinkSpecBuilder(ConsoleLinkSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ConsoleLinkSpecBuilder(ConsoleLinkSpecFluent<?> fluent,ConsoleLinkSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ConsoleLinkSpec build() {
    ConsoleLinkSpec buildable = new ConsoleLinkSpec(fluent.buildApplicationMenu(), fluent.getHref(), fluent.getLocation(), fluent.buildNamespaceDashboard(), fluent.getText());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}