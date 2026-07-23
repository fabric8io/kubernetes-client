package io.fabric8.openshift.api.model.monitoring.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ScrapeClassBuilder extends ScrapeClassFluent<ScrapeClassBuilder> implements VisitableBuilder<ScrapeClass,ScrapeClassBuilder>{

  ScrapeClassFluent<?> fluent;

  public ScrapeClassBuilder() {
    this(new ScrapeClass());
  }
  
  public ScrapeClassBuilder(ScrapeClassFluent<?> fluent) {
    this(fluent, new ScrapeClass());
  }
  
  public ScrapeClassBuilder(ScrapeClass instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ScrapeClassBuilder(ScrapeClassFluent<?> fluent,ScrapeClass instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ScrapeClass build() {
    ScrapeClass buildable = new ScrapeClass(fluent.buildAttachMetadata(), fluent.buildAuthorization(), fluent.getDefault(), fluent.getFallbackScrapeProtocol(), fluent.buildMetricRelabelings(), fluent.getName(), fluent.buildRelabelings(), fluent.buildTlsConfig());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}