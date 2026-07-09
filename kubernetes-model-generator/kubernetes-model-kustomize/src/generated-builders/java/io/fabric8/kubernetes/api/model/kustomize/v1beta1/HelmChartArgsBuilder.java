package io.fabric8.kubernetes.api.model.kustomize.v1beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class HelmChartArgsBuilder extends HelmChartArgsFluent<HelmChartArgsBuilder> implements VisitableBuilder<HelmChartArgs,HelmChartArgsBuilder>{

  HelmChartArgsFluent<?> fluent;

  public HelmChartArgsBuilder() {
    this(new HelmChartArgs());
  }
  
  public HelmChartArgsBuilder(HelmChartArgsFluent<?> fluent) {
    this(fluent, new HelmChartArgs());
  }
  
  public HelmChartArgsBuilder(HelmChartArgs instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public HelmChartArgsBuilder(HelmChartArgsFluent<?> fluent,HelmChartArgs instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public HelmChartArgs build() {
    HelmChartArgs buildable = new HelmChartArgs(fluent.getChartHome(), fluent.getChartName(), fluent.getChartRepoName(), fluent.getChartRepoUrl(), fluent.getChartVersion(), fluent.getExtraArgs(), fluent.getHelmBin(), fluent.getHelmHome(), fluent.getReleaseName(), fluent.getReleaseNamespace(), fluent.getValues(), fluent.getValuesLocal(), fluent.getValuesMerge());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}