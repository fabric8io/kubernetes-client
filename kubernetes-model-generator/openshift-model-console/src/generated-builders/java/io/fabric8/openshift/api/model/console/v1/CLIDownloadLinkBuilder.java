package io.fabric8.openshift.api.model.console.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class CLIDownloadLinkBuilder extends CLIDownloadLinkFluent<CLIDownloadLinkBuilder> implements VisitableBuilder<CLIDownloadLink,CLIDownloadLinkBuilder>{

  CLIDownloadLinkFluent<?> fluent;

  public CLIDownloadLinkBuilder() {
    this(new CLIDownloadLink());
  }
  
  public CLIDownloadLinkBuilder(CLIDownloadLinkFluent<?> fluent) {
    this(fluent, new CLIDownloadLink());
  }
  
  public CLIDownloadLinkBuilder(CLIDownloadLink instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public CLIDownloadLinkBuilder(CLIDownloadLinkFluent<?> fluent,CLIDownloadLink instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public CLIDownloadLink build() {
    CLIDownloadLink buildable = new CLIDownloadLink(fluent.getHref(), fluent.getText());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}