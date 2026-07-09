package io.fabric8.kubernetes.api.model.kustomize.v1beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class KustomizationBuilder extends KustomizationFluent<KustomizationBuilder> implements VisitableBuilder<Kustomization,KustomizationBuilder>{

  KustomizationFluent<?> fluent;

  public KustomizationBuilder() {
    this(new Kustomization());
  }
  
  public KustomizationBuilder(KustomizationFluent<?> fluent) {
    this(fluent, new Kustomization());
  }
  
  public KustomizationBuilder(Kustomization instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public KustomizationBuilder(KustomizationFluent<?> fluent,Kustomization instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public Kustomization build() {
    Kustomization buildable = new Kustomization(fluent.getApiVersion(), fluent.getBases(), fluent.getBuildMetadata(), fluent.getCommonAnnotations(), fluent.getCommonLabels(), fluent.getComponents(), fluent.buildConfigMapGenerator(), fluent.getConfigurations(), fluent.getCrds(), fluent.buildGeneratorOptions(), fluent.getGenerators(), fluent.buildHelmChartInflationGenerator(), fluent.buildHelmCharts(), fluent.buildHelmGlobals(), fluent.buildImageTags(), fluent.buildImages(), fluent.getKind(), fluent.buildLabels(), fluent.buildMetadata(), fluent.getNamePrefix(), fluent.getNameSuffix(), fluent.getNamespace(), fluent.getOpenapi(), fluent.buildPatches(), fluent.buildPatchesJson6902(), fluent.getPatchesStrategicMerge(), fluent.buildReplacements(), fluent.buildReplicas(), fluent.getResources(), fluent.buildSecretGenerator(), fluent.buildSortOptions(), fluent.getTransformers(), fluent.getValidators(), fluent.buildVars());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}