package io.fabric8.openshift.api.model.console.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ConsoleCLIDownloadBuilder extends ConsoleCLIDownloadFluent<ConsoleCLIDownloadBuilder> implements VisitableBuilder<ConsoleCLIDownload,ConsoleCLIDownloadBuilder>{

  ConsoleCLIDownloadFluent<?> fluent;

  public ConsoleCLIDownloadBuilder() {
    this(new ConsoleCLIDownload());
  }
  
  public ConsoleCLIDownloadBuilder(ConsoleCLIDownloadFluent<?> fluent) {
    this(fluent, new ConsoleCLIDownload());
  }
  
  public ConsoleCLIDownloadBuilder(ConsoleCLIDownload instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ConsoleCLIDownloadBuilder(ConsoleCLIDownloadFluent<?> fluent,ConsoleCLIDownload instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ConsoleCLIDownload build() {
    ConsoleCLIDownload buildable = new ConsoleCLIDownload(fluent.getApiVersion(), fluent.getKind(), fluent.buildMetadata(), fluent.buildSpec());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}