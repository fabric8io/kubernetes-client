package io.fabric8.openshift.api.model.console.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ConsoleCLIDownloadSpecBuilder extends ConsoleCLIDownloadSpecFluent<ConsoleCLIDownloadSpecBuilder> implements VisitableBuilder<ConsoleCLIDownloadSpec,ConsoleCLIDownloadSpecBuilder>{

  ConsoleCLIDownloadSpecFluent<?> fluent;

  public ConsoleCLIDownloadSpecBuilder() {
    this(new ConsoleCLIDownloadSpec());
  }
  
  public ConsoleCLIDownloadSpecBuilder(ConsoleCLIDownloadSpecFluent<?> fluent) {
    this(fluent, new ConsoleCLIDownloadSpec());
  }
  
  public ConsoleCLIDownloadSpecBuilder(ConsoleCLIDownloadSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ConsoleCLIDownloadSpecBuilder(ConsoleCLIDownloadSpecFluent<?> fluent,ConsoleCLIDownloadSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ConsoleCLIDownloadSpec build() {
    ConsoleCLIDownloadSpec buildable = new ConsoleCLIDownloadSpec(fluent.getDescription(), fluent.getDisplayName(), fluent.buildLinks());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}