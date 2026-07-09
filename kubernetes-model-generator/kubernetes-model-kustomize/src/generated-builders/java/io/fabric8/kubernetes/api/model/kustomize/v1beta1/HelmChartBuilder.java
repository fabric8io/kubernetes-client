package io.fabric8.kubernetes.api.model.kustomize.v1beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class HelmChartBuilder extends HelmChartFluent<HelmChartBuilder> implements VisitableBuilder<HelmChart,HelmChartBuilder>{

  HelmChartFluent<?> fluent;

  public HelmChartBuilder() {
    this(new HelmChart());
  }
  
  public HelmChartBuilder(HelmChartFluent<?> fluent) {
    this(fluent, new HelmChart());
  }
  
  public HelmChartBuilder(HelmChart instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public HelmChartBuilder(HelmChartFluent<?> fluent,HelmChart instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public HelmChart build() {
    HelmChart buildable = new HelmChart(fluent.getAdditionalValuesFiles(), fluent.getApiVersions(), fluent.getDebug(), fluent.getDevel(), fluent.getIncludeCRDs(), fluent.getKubeVersion(), fluent.getName(), fluent.getNameTemplate(), fluent.getNamespace(), fluent.getReleaseName(), fluent.getRepo(), fluent.getSkipHooks(), fluent.getSkipTests(), fluent.getValuesFile(), fluent.getValuesInline(), fluent.getValuesMerge(), fluent.getVersion());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}