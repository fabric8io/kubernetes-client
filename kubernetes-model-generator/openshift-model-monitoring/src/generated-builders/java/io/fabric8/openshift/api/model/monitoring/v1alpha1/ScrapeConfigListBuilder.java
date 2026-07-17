package io.fabric8.openshift.api.model.monitoring.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ScrapeConfigListBuilder extends ScrapeConfigListFluent<ScrapeConfigListBuilder> implements VisitableBuilder<ScrapeConfigList,ScrapeConfigListBuilder>{

  ScrapeConfigListFluent<?> fluent;

  public ScrapeConfigListBuilder() {
    this(new ScrapeConfigList());
  }
  
  public ScrapeConfigListBuilder(ScrapeConfigListFluent<?> fluent) {
    this(fluent, new ScrapeConfigList());
  }
  
  public ScrapeConfigListBuilder(ScrapeConfigList instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ScrapeConfigListBuilder(ScrapeConfigListFluent<?> fluent,ScrapeConfigList instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ScrapeConfigList build() {
    ScrapeConfigList buildable = new ScrapeConfigList(fluent.getApiVersion(), fluent.buildItems(), fluent.getKind(), fluent.getMetadata());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}