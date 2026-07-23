package io.fabric8.openshift.api.model.insights.v1alpha2;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class InsightsReportBuilder extends InsightsReportFluent<InsightsReportBuilder> implements VisitableBuilder<InsightsReport,InsightsReportBuilder>{

  InsightsReportFluent<?> fluent;

  public InsightsReportBuilder() {
    this(new InsightsReport());
  }
  
  public InsightsReportBuilder(InsightsReportFluent<?> fluent) {
    this(fluent, new InsightsReport());
  }
  
  public InsightsReportBuilder(InsightsReport instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public InsightsReportBuilder(InsightsReportFluent<?> fluent,InsightsReport instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public InsightsReport build() {
    InsightsReport buildable = new InsightsReport(fluent.getDownloadedTime(), fluent.buildHealthChecks(), fluent.getUri());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}