package io.fabric8.openshift.api.model.console.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ConsoleCLIDownloadListBuilder extends ConsoleCLIDownloadListFluent<ConsoleCLIDownloadListBuilder> implements VisitableBuilder<ConsoleCLIDownloadList,ConsoleCLIDownloadListBuilder>{

  ConsoleCLIDownloadListFluent<?> fluent;

  public ConsoleCLIDownloadListBuilder() {
    this(new ConsoleCLIDownloadList());
  }
  
  public ConsoleCLIDownloadListBuilder(ConsoleCLIDownloadListFluent<?> fluent) {
    this(fluent, new ConsoleCLIDownloadList());
  }
  
  public ConsoleCLIDownloadListBuilder(ConsoleCLIDownloadList instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ConsoleCLIDownloadListBuilder(ConsoleCLIDownloadListFluent<?> fluent,ConsoleCLIDownloadList instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ConsoleCLIDownloadList build() {
    ConsoleCLIDownloadList buildable = new ConsoleCLIDownloadList(fluent.getApiVersion(), fluent.buildItems(), fluent.getKind(), fluent.getMetadata());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}