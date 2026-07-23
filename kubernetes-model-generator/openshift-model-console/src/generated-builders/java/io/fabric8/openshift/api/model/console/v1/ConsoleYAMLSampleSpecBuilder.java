package io.fabric8.openshift.api.model.console.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ConsoleYAMLSampleSpecBuilder extends ConsoleYAMLSampleSpecFluent<ConsoleYAMLSampleSpecBuilder> implements VisitableBuilder<ConsoleYAMLSampleSpec,ConsoleYAMLSampleSpecBuilder>{

  ConsoleYAMLSampleSpecFluent<?> fluent;

  public ConsoleYAMLSampleSpecBuilder() {
    this(new ConsoleYAMLSampleSpec());
  }
  
  public ConsoleYAMLSampleSpecBuilder(ConsoleYAMLSampleSpecFluent<?> fluent) {
    this(fluent, new ConsoleYAMLSampleSpec());
  }
  
  public ConsoleYAMLSampleSpecBuilder(ConsoleYAMLSampleSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ConsoleYAMLSampleSpecBuilder(ConsoleYAMLSampleSpecFluent<?> fluent,ConsoleYAMLSampleSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ConsoleYAMLSampleSpec build() {
    ConsoleYAMLSampleSpec buildable = new ConsoleYAMLSampleSpec(fluent.getDescription(), fluent.getSnippet(), fluent.getTargetResource(), fluent.getTitle(), fluent.getYaml());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}