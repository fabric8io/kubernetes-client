package io.fabric8.openshift.api.model.config.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ConsoleSpecBuilder extends ConsoleSpecFluent<ConsoleSpecBuilder> implements VisitableBuilder<ConsoleSpec,ConsoleSpecBuilder>{

  ConsoleSpecFluent<?> fluent;

  public ConsoleSpecBuilder() {
    this(new ConsoleSpec());
  }
  
  public ConsoleSpecBuilder(ConsoleSpecFluent<?> fluent) {
    this(fluent, new ConsoleSpec());
  }
  
  public ConsoleSpecBuilder(ConsoleSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ConsoleSpecBuilder(ConsoleSpecFluent<?> fluent,ConsoleSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ConsoleSpec build() {
    ConsoleSpec buildable = new ConsoleSpec(fluent.buildAuthentication());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}