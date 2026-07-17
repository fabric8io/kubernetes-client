package io.fabric8.openshift.api.model.operator.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ConsoleProvidersBuilder extends ConsoleProvidersFluent<ConsoleProvidersBuilder> implements VisitableBuilder<ConsoleProviders,ConsoleProvidersBuilder>{

  ConsoleProvidersFluent<?> fluent;

  public ConsoleProvidersBuilder() {
    this(new ConsoleProviders());
  }
  
  public ConsoleProvidersBuilder(ConsoleProvidersFluent<?> fluent) {
    this(fluent, new ConsoleProviders());
  }
  
  public ConsoleProvidersBuilder(ConsoleProviders instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ConsoleProvidersBuilder(ConsoleProvidersFluent<?> fluent,ConsoleProviders instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ConsoleProviders build() {
    ConsoleProviders buildable = new ConsoleProviders(fluent.buildStatuspage());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}