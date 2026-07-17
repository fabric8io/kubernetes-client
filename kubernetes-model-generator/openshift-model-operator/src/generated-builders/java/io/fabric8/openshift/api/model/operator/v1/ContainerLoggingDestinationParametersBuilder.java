package io.fabric8.openshift.api.model.operator.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ContainerLoggingDestinationParametersBuilder extends ContainerLoggingDestinationParametersFluent<ContainerLoggingDestinationParametersBuilder> implements VisitableBuilder<ContainerLoggingDestinationParameters,ContainerLoggingDestinationParametersBuilder>{

  ContainerLoggingDestinationParametersFluent<?> fluent;

  public ContainerLoggingDestinationParametersBuilder() {
    this(new ContainerLoggingDestinationParameters());
  }
  
  public ContainerLoggingDestinationParametersBuilder(ContainerLoggingDestinationParametersFluent<?> fluent) {
    this(fluent, new ContainerLoggingDestinationParameters());
  }
  
  public ContainerLoggingDestinationParametersBuilder(ContainerLoggingDestinationParameters instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ContainerLoggingDestinationParametersBuilder(ContainerLoggingDestinationParametersFluent<?> fluent,ContainerLoggingDestinationParameters instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ContainerLoggingDestinationParameters build() {
    ContainerLoggingDestinationParameters buildable = new ContainerLoggingDestinationParameters(fluent.getMaxLength());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}