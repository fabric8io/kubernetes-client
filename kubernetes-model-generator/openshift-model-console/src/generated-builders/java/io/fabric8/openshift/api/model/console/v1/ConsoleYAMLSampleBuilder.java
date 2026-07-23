package io.fabric8.openshift.api.model.console.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ConsoleYAMLSampleBuilder extends ConsoleYAMLSampleFluent<ConsoleYAMLSampleBuilder> implements VisitableBuilder<ConsoleYAMLSample,ConsoleYAMLSampleBuilder>{

  ConsoleYAMLSampleFluent<?> fluent;

  public ConsoleYAMLSampleBuilder() {
    this(new ConsoleYAMLSample());
  }
  
  public ConsoleYAMLSampleBuilder(ConsoleYAMLSampleFluent<?> fluent) {
    this(fluent, new ConsoleYAMLSample());
  }
  
  public ConsoleYAMLSampleBuilder(ConsoleYAMLSample instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ConsoleYAMLSampleBuilder(ConsoleYAMLSampleFluent<?> fluent,ConsoleYAMLSample instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ConsoleYAMLSample build() {
    ConsoleYAMLSample buildable = new ConsoleYAMLSample(fluent.getApiVersion(), fluent.getKind(), fluent.buildMetadata(), fluent.buildSpec());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}