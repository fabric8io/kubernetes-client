package io.fabric8.openshift.api.model.console.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ConsoleExternalLogLinkSpecBuilder extends ConsoleExternalLogLinkSpecFluent<ConsoleExternalLogLinkSpecBuilder> implements VisitableBuilder<ConsoleExternalLogLinkSpec,ConsoleExternalLogLinkSpecBuilder>{

  ConsoleExternalLogLinkSpecFluent<?> fluent;

  public ConsoleExternalLogLinkSpecBuilder() {
    this(new ConsoleExternalLogLinkSpec());
  }
  
  public ConsoleExternalLogLinkSpecBuilder(ConsoleExternalLogLinkSpecFluent<?> fluent) {
    this(fluent, new ConsoleExternalLogLinkSpec());
  }
  
  public ConsoleExternalLogLinkSpecBuilder(ConsoleExternalLogLinkSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ConsoleExternalLogLinkSpecBuilder(ConsoleExternalLogLinkSpecFluent<?> fluent,ConsoleExternalLogLinkSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ConsoleExternalLogLinkSpec build() {
    ConsoleExternalLogLinkSpec buildable = new ConsoleExternalLogLinkSpec(fluent.getHrefTemplate(), fluent.getNamespaceFilter(), fluent.getText());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}