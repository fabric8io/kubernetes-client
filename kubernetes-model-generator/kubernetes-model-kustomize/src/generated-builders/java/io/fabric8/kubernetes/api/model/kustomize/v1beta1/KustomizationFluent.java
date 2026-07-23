package io.fabric8.kubernetes.api.model.kustomize.v1beta1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import io.fabric8.kubernetes.api.model.ObjectMeta;
import io.fabric8.kubernetes.api.model.ObjectMetaBuilder;
import io.fabric8.kubernetes.api.model.ObjectMetaFluent;
import java.lang.Long;
import java.lang.Object;
import java.lang.RuntimeException;
import java.lang.String;
import java.lang.StringBuilder;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Predicate;

/**
 * Generated
 */
@SuppressWarnings("unchecked")
public class KustomizationFluent<A extends io.fabric8.kubernetes.api.model.kustomize.v1beta1.KustomizationFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String apiVersion;
  private List<String> bases = new ArrayList<String>();
  private List<String> buildMetadata = new ArrayList<String>();
  private Map<String,String> commonAnnotations;
  private Map<String,String> commonLabels;
  private List<String> components = new ArrayList<String>();
  private ArrayList<ConfigMapArgsBuilder> configMapGenerator = new ArrayList<ConfigMapArgsBuilder>();
  private List<String> configurations = new ArrayList<String>();
  private List<String> crds = new ArrayList<String>();
  private GeneratorOptionsBuilder generatorOptions;
  private List<String> generators = new ArrayList<String>();
  private ArrayList<HelmChartArgsBuilder> helmChartInflationGenerator = new ArrayList<HelmChartArgsBuilder>();
  private ArrayList<HelmChartBuilder> helmCharts = new ArrayList<HelmChartBuilder>();
  private HelmGlobalsBuilder helmGlobals;
  private ArrayList<ImageBuilder> imageTags = new ArrayList<ImageBuilder>();
  private ArrayList<ImageBuilder> images = new ArrayList<ImageBuilder>();
  private String kind;
  private ArrayList<LabelBuilder> labels = new ArrayList<LabelBuilder>();
  private ObjectMetaBuilder metadata;
  private String namePrefix;
  private String nameSuffix;
  private String namespace;
  private Map<String,String> openapi;
  private ArrayList<PatchBuilder> patches = new ArrayList<PatchBuilder>();
  private ArrayList<PatchBuilder> patchesJson6902 = new ArrayList<PatchBuilder>();
  private List<String> patchesStrategicMerge = new ArrayList<String>();
  private ArrayList<ReplacementFieldBuilder> replacements = new ArrayList<ReplacementFieldBuilder>();
  private ArrayList<ReplicaBuilder> replicas = new ArrayList<ReplicaBuilder>();
  private List<String> resources = new ArrayList<String>();
  private ArrayList<SecretArgsBuilder> secretGenerator = new ArrayList<SecretArgsBuilder>();
  private SortOptionsBuilder sortOptions;
  private List<String> transformers = new ArrayList<String>();
  private List<String> validators = new ArrayList<String>();
  private ArrayList<VarBuilder> vars = new ArrayList<VarBuilder>();

  public KustomizationFluent() {
  }
  
  public KustomizationFluent(Kustomization instance) {
    this.copyInstance(instance);
  }

  public A addAllToBases(Collection<String> items) {
    if (this.bases == null) {
      this.bases = new ArrayList();
    }
    for (String item : items) {
      this.bases.add(item);
    }
    return (A) this;
  }
  
  public A addAllToBuildMetadata(Collection<String> items) {
    if (this.buildMetadata == null) {
      this.buildMetadata = new ArrayList();
    }
    for (String item : items) {
      this.buildMetadata.add(item);
    }
    return (A) this;
  }
  
  public A addAllToComponents(Collection<String> items) {
    if (this.components == null) {
      this.components = new ArrayList();
    }
    for (String item : items) {
      this.components.add(item);
    }
    return (A) this;
  }
  
  public A addAllToConfigMapGenerator(Collection<ConfigMapArgs> items) {
    if (this.configMapGenerator == null) {
      this.configMapGenerator = new ArrayList();
    }
    for (ConfigMapArgs item : items) {
        ConfigMapArgsBuilder builder = new ConfigMapArgsBuilder(item);
        _visitables.get("configMapGenerator").add(builder);
        this.configMapGenerator.add(builder);
    }
    return (A) this;
  }
  
  public A addAllToConfigurations(Collection<String> items) {
    if (this.configurations == null) {
      this.configurations = new ArrayList();
    }
    for (String item : items) {
      this.configurations.add(item);
    }
    return (A) this;
  }
  
  public A addAllToCrds(Collection<String> items) {
    if (this.crds == null) {
      this.crds = new ArrayList();
    }
    for (String item : items) {
      this.crds.add(item);
    }
    return (A) this;
  }
  
  public A addAllToGenerators(Collection<String> items) {
    if (this.generators == null) {
      this.generators = new ArrayList();
    }
    for (String item : items) {
      this.generators.add(item);
    }
    return (A) this;
  }
  
  public A addAllToHelmChartInflationGenerator(Collection<HelmChartArgs> items) {
    if (this.helmChartInflationGenerator == null) {
      this.helmChartInflationGenerator = new ArrayList();
    }
    for (HelmChartArgs item : items) {
        HelmChartArgsBuilder builder = new HelmChartArgsBuilder(item);
        _visitables.get("helmChartInflationGenerator").add(builder);
        this.helmChartInflationGenerator.add(builder);
    }
    return (A) this;
  }
  
  public A addAllToHelmCharts(Collection<HelmChart> items) {
    if (this.helmCharts == null) {
      this.helmCharts = new ArrayList();
    }
    for (HelmChart item : items) {
        HelmChartBuilder builder = new HelmChartBuilder(item);
        _visitables.get("helmCharts").add(builder);
        this.helmCharts.add(builder);
    }
    return (A) this;
  }
  
  public A addAllToImageTags(Collection<Image> items) {
    if (this.imageTags == null) {
      this.imageTags = new ArrayList();
    }
    for (Image item : items) {
        ImageBuilder builder = new ImageBuilder(item);
        _visitables.get("imageTags").add(builder);
        this.imageTags.add(builder);
    }
    return (A) this;
  }
  
  public A addAllToImages(Collection<Image> items) {
    if (this.images == null) {
      this.images = new ArrayList();
    }
    for (Image item : items) {
        ImageBuilder builder = new ImageBuilder(item);
        _visitables.get("images").add(builder);
        this.images.add(builder);
    }
    return (A) this;
  }
  
  public A addAllToLabels(Collection<Label> items) {
    if (this.labels == null) {
      this.labels = new ArrayList();
    }
    for (Label item : items) {
        LabelBuilder builder = new LabelBuilder(item);
        _visitables.get("labels").add(builder);
        this.labels.add(builder);
    }
    return (A) this;
  }
  
  public A addAllToPatches(Collection<Patch> items) {
    if (this.patches == null) {
      this.patches = new ArrayList();
    }
    for (Patch item : items) {
        PatchBuilder builder = new PatchBuilder(item);
        _visitables.get("patches").add(builder);
        this.patches.add(builder);
    }
    return (A) this;
  }
  
  public A addAllToPatchesJson6902(Collection<Patch> items) {
    if (this.patchesJson6902 == null) {
      this.patchesJson6902 = new ArrayList();
    }
    for (Patch item : items) {
        PatchBuilder builder = new PatchBuilder(item);
        _visitables.get("patchesJson6902").add(builder);
        this.patchesJson6902.add(builder);
    }
    return (A) this;
  }
  
  public A addAllToPatchesStrategicMerge(Collection<String> items) {
    if (this.patchesStrategicMerge == null) {
      this.patchesStrategicMerge = new ArrayList();
    }
    for (String item : items) {
      this.patchesStrategicMerge.add(item);
    }
    return (A) this;
  }
  
  public A addAllToReplacements(Collection<ReplacementField> items) {
    if (this.replacements == null) {
      this.replacements = new ArrayList();
    }
    for (ReplacementField item : items) {
        ReplacementFieldBuilder builder = new ReplacementFieldBuilder(item);
        _visitables.get("replacements").add(builder);
        this.replacements.add(builder);
    }
    return (A) this;
  }
  
  public A addAllToReplicas(Collection<Replica> items) {
    if (this.replicas == null) {
      this.replicas = new ArrayList();
    }
    for (Replica item : items) {
        ReplicaBuilder builder = new ReplicaBuilder(item);
        _visitables.get("replicas").add(builder);
        this.replicas.add(builder);
    }
    return (A) this;
  }
  
  public A addAllToResources(Collection<String> items) {
    if (this.resources == null) {
      this.resources = new ArrayList();
    }
    for (String item : items) {
      this.resources.add(item);
    }
    return (A) this;
  }
  
  public A addAllToSecretGenerator(Collection<SecretArgs> items) {
    if (this.secretGenerator == null) {
      this.secretGenerator = new ArrayList();
    }
    for (SecretArgs item : items) {
        SecretArgsBuilder builder = new SecretArgsBuilder(item);
        _visitables.get("secretGenerator").add(builder);
        this.secretGenerator.add(builder);
    }
    return (A) this;
  }
  
  public A addAllToTransformers(Collection<String> items) {
    if (this.transformers == null) {
      this.transformers = new ArrayList();
    }
    for (String item : items) {
      this.transformers.add(item);
    }
    return (A) this;
  }
  
  public A addAllToValidators(Collection<String> items) {
    if (this.validators == null) {
      this.validators = new ArrayList();
    }
    for (String item : items) {
      this.validators.add(item);
    }
    return (A) this;
  }
  
  public A addAllToVars(Collection<Var> items) {
    if (this.vars == null) {
      this.vars = new ArrayList();
    }
    for (Var item : items) {
        VarBuilder builder = new VarBuilder(item);
        _visitables.get("vars").add(builder);
        this.vars.add(builder);
    }
    return (A) this;
  }
  
  public ConfigMapGeneratorNested<A> addNewConfigMapGenerator() {
    return new ConfigMapGeneratorNested(-1, null);
  }
  
  public ConfigMapGeneratorNested<A> addNewConfigMapGeneratorLike(ConfigMapArgs item) {
    return new ConfigMapGeneratorNested(-1, item);
  }
  
  public HelmChartsNested<A> addNewHelmChart() {
    return new HelmChartsNested(-1, null);
  }
  
  public HelmChartInflationGeneratorNested<A> addNewHelmChartInflationGenerator() {
    return new HelmChartInflationGeneratorNested(-1, null);
  }
  
  public HelmChartInflationGeneratorNested<A> addNewHelmChartInflationGeneratorLike(HelmChartArgs item) {
    return new HelmChartInflationGeneratorNested(-1, item);
  }
  
  public HelmChartsNested<A> addNewHelmChartLike(HelmChart item) {
    return new HelmChartsNested(-1, item);
  }
  
  public ImagesNested<A> addNewImage() {
    return new ImagesNested(-1, null);
  }
  
  public A addNewImage(String digest,String name,String newName,String newTag,String tagSuffix) {
    return (A) this.addToImages(new Image(digest, name, newName, newTag, tagSuffix));
  }
  
  public ImagesNested<A> addNewImageLike(Image item) {
    return new ImagesNested(-1, item);
  }
  
  public ImageTagsNested<A> addNewImageTag() {
    return new ImageTagsNested(-1, null);
  }
  
  public A addNewImageTag(String digest,String name,String newName,String newTag,String tagSuffix) {
    return (A) this.addToImageTags(new Image(digest, name, newName, newTag, tagSuffix));
  }
  
  public ImageTagsNested<A> addNewImageTagLike(Image item) {
    return new ImageTagsNested(-1, item);
  }
  
  public LabelsNested<A> addNewLabel() {
    return new LabelsNested(-1, null);
  }
  
  public LabelsNested<A> addNewLabelLike(Label item) {
    return new LabelsNested(-1, item);
  }
  
  public PatchesNested<A> addNewPatch() {
    return new PatchesNested(-1, null);
  }
  
  public PatchesNested<A> addNewPatchLike(Patch item) {
    return new PatchesNested(-1, item);
  }
  
  public PatchesJson6902Nested<A> addNewPatchesJson6902() {
    return new PatchesJson6902Nested(-1, null);
  }
  
  public PatchesJson6902Nested<A> addNewPatchesJson6902Like(Patch item) {
    return new PatchesJson6902Nested(-1, item);
  }
  
  public ReplacementsNested<A> addNewReplacement() {
    return new ReplacementsNested(-1, null);
  }
  
  public ReplacementsNested<A> addNewReplacementLike(ReplacementField item) {
    return new ReplacementsNested(-1, item);
  }
  
  public ReplicasNested<A> addNewReplica() {
    return new ReplicasNested(-1, null);
  }
  
  public A addNewReplica(Long count,String name) {
    return (A) this.addToReplicas(new Replica(count, name));
  }
  
  public ReplicasNested<A> addNewReplicaLike(Replica item) {
    return new ReplicasNested(-1, item);
  }
  
  public SecretGeneratorNested<A> addNewSecretGenerator() {
    return new SecretGeneratorNested(-1, null);
  }
  
  public SecretGeneratorNested<A> addNewSecretGeneratorLike(SecretArgs item) {
    return new SecretGeneratorNested(-1, item);
  }
  
  public VarsNested<A> addNewVar() {
    return new VarsNested(-1, null);
  }
  
  public VarsNested<A> addNewVarLike(Var item) {
    return new VarsNested(-1, item);
  }
  
  public A addToAdditionalProperties(Map<String,Object> map) {
    if (this.additionalProperties == null && map != null) {
      this.additionalProperties = new LinkedHashMap();
    }
    if (map != null) {
      this.additionalProperties.putAll(map);
    }
    return (A) this;
  }
  
  public A addToAdditionalProperties(String key,Object value) {
    if (this.additionalProperties == null && key != null && value != null) {
      this.additionalProperties = new LinkedHashMap();
    }
    if (key != null && value != null) {
      this.additionalProperties.put(key, value);
    }
    return (A) this;
  }
  
  public A addToBases(String... items) {
    if (this.bases == null) {
      this.bases = new ArrayList();
    }
    for (String item : items) {
      this.bases.add(item);
    }
    return (A) this;
  }
  
  public A addToBases(int index,String item) {
    if (this.bases == null) {
      this.bases = new ArrayList();
    }
    this.bases.add(index, item);
    return (A) this;
  }
  
  public A addToBuildMetadata(String... items) {
    if (this.buildMetadata == null) {
      this.buildMetadata = new ArrayList();
    }
    for (String item : items) {
      this.buildMetadata.add(item);
    }
    return (A) this;
  }
  
  public A addToBuildMetadata(int index,String item) {
    if (this.buildMetadata == null) {
      this.buildMetadata = new ArrayList();
    }
    this.buildMetadata.add(index, item);
    return (A) this;
  }
  
  public A addToCommonAnnotations(Map<String,String> map) {
    if (this.commonAnnotations == null && map != null) {
      this.commonAnnotations = new LinkedHashMap();
    }
    if (map != null) {
      this.commonAnnotations.putAll(map);
    }
    return (A) this;
  }
  
  public A addToCommonAnnotations(String key,String value) {
    if (this.commonAnnotations == null && key != null && value != null) {
      this.commonAnnotations = new LinkedHashMap();
    }
    if (key != null && value != null) {
      this.commonAnnotations.put(key, value);
    }
    return (A) this;
  }
  
  public A addToCommonLabels(Map<String,String> map) {
    if (this.commonLabels == null && map != null) {
      this.commonLabels = new LinkedHashMap();
    }
    if (map != null) {
      this.commonLabels.putAll(map);
    }
    return (A) this;
  }
  
  public A addToCommonLabels(String key,String value) {
    if (this.commonLabels == null && key != null && value != null) {
      this.commonLabels = new LinkedHashMap();
    }
    if (key != null && value != null) {
      this.commonLabels.put(key, value);
    }
    return (A) this;
  }
  
  public A addToComponents(String... items) {
    if (this.components == null) {
      this.components = new ArrayList();
    }
    for (String item : items) {
      this.components.add(item);
    }
    return (A) this;
  }
  
  public A addToComponents(int index,String item) {
    if (this.components == null) {
      this.components = new ArrayList();
    }
    this.components.add(index, item);
    return (A) this;
  }
  
  public A addToConfigMapGenerator(ConfigMapArgs... items) {
    if (this.configMapGenerator == null) {
      this.configMapGenerator = new ArrayList();
    }
    for (ConfigMapArgs item : items) {
        ConfigMapArgsBuilder builder = new ConfigMapArgsBuilder(item);
        _visitables.get("configMapGenerator").add(builder);
        this.configMapGenerator.add(builder);
    }
    return (A) this;
  }
  
  public A addToConfigMapGenerator(int index,ConfigMapArgs item) {
    if (this.configMapGenerator == null) {
      this.configMapGenerator = new ArrayList();
    }
    ConfigMapArgsBuilder builder = new ConfigMapArgsBuilder(item);
    if (index < 0 || index >= configMapGenerator.size()) {
        _visitables.get("configMapGenerator").add(builder);
        configMapGenerator.add(builder);
    } else {
        _visitables.get("configMapGenerator").add(builder);
        configMapGenerator.add(index, builder);
    }
    return (A) this;
  }
  
  public A addToConfigurations(String... items) {
    if (this.configurations == null) {
      this.configurations = new ArrayList();
    }
    for (String item : items) {
      this.configurations.add(item);
    }
    return (A) this;
  }
  
  public A addToConfigurations(int index,String item) {
    if (this.configurations == null) {
      this.configurations = new ArrayList();
    }
    this.configurations.add(index, item);
    return (A) this;
  }
  
  public A addToCrds(String... items) {
    if (this.crds == null) {
      this.crds = new ArrayList();
    }
    for (String item : items) {
      this.crds.add(item);
    }
    return (A) this;
  }
  
  public A addToCrds(int index,String item) {
    if (this.crds == null) {
      this.crds = new ArrayList();
    }
    this.crds.add(index, item);
    return (A) this;
  }
  
  public A addToGenerators(String... items) {
    if (this.generators == null) {
      this.generators = new ArrayList();
    }
    for (String item : items) {
      this.generators.add(item);
    }
    return (A) this;
  }
  
  public A addToGenerators(int index,String item) {
    if (this.generators == null) {
      this.generators = new ArrayList();
    }
    this.generators.add(index, item);
    return (A) this;
  }
  
  public A addToHelmChartInflationGenerator(HelmChartArgs... items) {
    if (this.helmChartInflationGenerator == null) {
      this.helmChartInflationGenerator = new ArrayList();
    }
    for (HelmChartArgs item : items) {
        HelmChartArgsBuilder builder = new HelmChartArgsBuilder(item);
        _visitables.get("helmChartInflationGenerator").add(builder);
        this.helmChartInflationGenerator.add(builder);
    }
    return (A) this;
  }
  
  public A addToHelmChartInflationGenerator(int index,HelmChartArgs item) {
    if (this.helmChartInflationGenerator == null) {
      this.helmChartInflationGenerator = new ArrayList();
    }
    HelmChartArgsBuilder builder = new HelmChartArgsBuilder(item);
    if (index < 0 || index >= helmChartInflationGenerator.size()) {
        _visitables.get("helmChartInflationGenerator").add(builder);
        helmChartInflationGenerator.add(builder);
    } else {
        _visitables.get("helmChartInflationGenerator").add(builder);
        helmChartInflationGenerator.add(index, builder);
    }
    return (A) this;
  }
  
  public A addToHelmCharts(HelmChart... items) {
    if (this.helmCharts == null) {
      this.helmCharts = new ArrayList();
    }
    for (HelmChart item : items) {
        HelmChartBuilder builder = new HelmChartBuilder(item);
        _visitables.get("helmCharts").add(builder);
        this.helmCharts.add(builder);
    }
    return (A) this;
  }
  
  public A addToHelmCharts(int index,HelmChart item) {
    if (this.helmCharts == null) {
      this.helmCharts = new ArrayList();
    }
    HelmChartBuilder builder = new HelmChartBuilder(item);
    if (index < 0 || index >= helmCharts.size()) {
        _visitables.get("helmCharts").add(builder);
        helmCharts.add(builder);
    } else {
        _visitables.get("helmCharts").add(builder);
        helmCharts.add(index, builder);
    }
    return (A) this;
  }
  
  public A addToImageTags(Image... items) {
    if (this.imageTags == null) {
      this.imageTags = new ArrayList();
    }
    for (Image item : items) {
        ImageBuilder builder = new ImageBuilder(item);
        _visitables.get("imageTags").add(builder);
        this.imageTags.add(builder);
    }
    return (A) this;
  }
  
  public A addToImageTags(int index,Image item) {
    if (this.imageTags == null) {
      this.imageTags = new ArrayList();
    }
    ImageBuilder builder = new ImageBuilder(item);
    if (index < 0 || index >= imageTags.size()) {
        _visitables.get("imageTags").add(builder);
        imageTags.add(builder);
    } else {
        _visitables.get("imageTags").add(builder);
        imageTags.add(index, builder);
    }
    return (A) this;
  }
  
  public A addToImages(Image... items) {
    if (this.images == null) {
      this.images = new ArrayList();
    }
    for (Image item : items) {
        ImageBuilder builder = new ImageBuilder(item);
        _visitables.get("images").add(builder);
        this.images.add(builder);
    }
    return (A) this;
  }
  
  public A addToImages(int index,Image item) {
    if (this.images == null) {
      this.images = new ArrayList();
    }
    ImageBuilder builder = new ImageBuilder(item);
    if (index < 0 || index >= images.size()) {
        _visitables.get("images").add(builder);
        images.add(builder);
    } else {
        _visitables.get("images").add(builder);
        images.add(index, builder);
    }
    return (A) this;
  }
  
  public A addToLabels(Label... items) {
    if (this.labels == null) {
      this.labels = new ArrayList();
    }
    for (Label item : items) {
        LabelBuilder builder = new LabelBuilder(item);
        _visitables.get("labels").add(builder);
        this.labels.add(builder);
    }
    return (A) this;
  }
  
  public A addToLabels(int index,Label item) {
    if (this.labels == null) {
      this.labels = new ArrayList();
    }
    LabelBuilder builder = new LabelBuilder(item);
    if (index < 0 || index >= labels.size()) {
        _visitables.get("labels").add(builder);
        labels.add(builder);
    } else {
        _visitables.get("labels").add(builder);
        labels.add(index, builder);
    }
    return (A) this;
  }
  
  public A addToOpenapi(Map<String,String> map) {
    if (this.openapi == null && map != null) {
      this.openapi = new LinkedHashMap();
    }
    if (map != null) {
      this.openapi.putAll(map);
    }
    return (A) this;
  }
  
  public A addToOpenapi(String key,String value) {
    if (this.openapi == null && key != null && value != null) {
      this.openapi = new LinkedHashMap();
    }
    if (key != null && value != null) {
      this.openapi.put(key, value);
    }
    return (A) this;
  }
  
  public A addToPatches(Patch... items) {
    if (this.patches == null) {
      this.patches = new ArrayList();
    }
    for (Patch item : items) {
        PatchBuilder builder = new PatchBuilder(item);
        _visitables.get("patches").add(builder);
        this.patches.add(builder);
    }
    return (A) this;
  }
  
  public A addToPatches(int index,Patch item) {
    if (this.patches == null) {
      this.patches = new ArrayList();
    }
    PatchBuilder builder = new PatchBuilder(item);
    if (index < 0 || index >= patches.size()) {
        _visitables.get("patches").add(builder);
        patches.add(builder);
    } else {
        _visitables.get("patches").add(builder);
        patches.add(index, builder);
    }
    return (A) this;
  }
  
  public A addToPatchesJson6902(Patch... items) {
    if (this.patchesJson6902 == null) {
      this.patchesJson6902 = new ArrayList();
    }
    for (Patch item : items) {
        PatchBuilder builder = new PatchBuilder(item);
        _visitables.get("patchesJson6902").add(builder);
        this.patchesJson6902.add(builder);
    }
    return (A) this;
  }
  
  public A addToPatchesJson6902(int index,Patch item) {
    if (this.patchesJson6902 == null) {
      this.patchesJson6902 = new ArrayList();
    }
    PatchBuilder builder = new PatchBuilder(item);
    if (index < 0 || index >= patchesJson6902.size()) {
        _visitables.get("patchesJson6902").add(builder);
        patchesJson6902.add(builder);
    } else {
        _visitables.get("patchesJson6902").add(builder);
        patchesJson6902.add(index, builder);
    }
    return (A) this;
  }
  
  public A addToPatchesStrategicMerge(String... items) {
    if (this.patchesStrategicMerge == null) {
      this.patchesStrategicMerge = new ArrayList();
    }
    for (String item : items) {
      this.patchesStrategicMerge.add(item);
    }
    return (A) this;
  }
  
  public A addToPatchesStrategicMerge(int index,String item) {
    if (this.patchesStrategicMerge == null) {
      this.patchesStrategicMerge = new ArrayList();
    }
    this.patchesStrategicMerge.add(index, item);
    return (A) this;
  }
  
  public A addToReplacements(ReplacementField... items) {
    if (this.replacements == null) {
      this.replacements = new ArrayList();
    }
    for (ReplacementField item : items) {
        ReplacementFieldBuilder builder = new ReplacementFieldBuilder(item);
        _visitables.get("replacements").add(builder);
        this.replacements.add(builder);
    }
    return (A) this;
  }
  
  public A addToReplacements(int index,ReplacementField item) {
    if (this.replacements == null) {
      this.replacements = new ArrayList();
    }
    ReplacementFieldBuilder builder = new ReplacementFieldBuilder(item);
    if (index < 0 || index >= replacements.size()) {
        _visitables.get("replacements").add(builder);
        replacements.add(builder);
    } else {
        _visitables.get("replacements").add(builder);
        replacements.add(index, builder);
    }
    return (A) this;
  }
  
  public A addToReplicas(Replica... items) {
    if (this.replicas == null) {
      this.replicas = new ArrayList();
    }
    for (Replica item : items) {
        ReplicaBuilder builder = new ReplicaBuilder(item);
        _visitables.get("replicas").add(builder);
        this.replicas.add(builder);
    }
    return (A) this;
  }
  
  public A addToReplicas(int index,Replica item) {
    if (this.replicas == null) {
      this.replicas = new ArrayList();
    }
    ReplicaBuilder builder = new ReplicaBuilder(item);
    if (index < 0 || index >= replicas.size()) {
        _visitables.get("replicas").add(builder);
        replicas.add(builder);
    } else {
        _visitables.get("replicas").add(builder);
        replicas.add(index, builder);
    }
    return (A) this;
  }
  
  public A addToResources(String... items) {
    if (this.resources == null) {
      this.resources = new ArrayList();
    }
    for (String item : items) {
      this.resources.add(item);
    }
    return (A) this;
  }
  
  public A addToResources(int index,String item) {
    if (this.resources == null) {
      this.resources = new ArrayList();
    }
    this.resources.add(index, item);
    return (A) this;
  }
  
  public A addToSecretGenerator(SecretArgs... items) {
    if (this.secretGenerator == null) {
      this.secretGenerator = new ArrayList();
    }
    for (SecretArgs item : items) {
        SecretArgsBuilder builder = new SecretArgsBuilder(item);
        _visitables.get("secretGenerator").add(builder);
        this.secretGenerator.add(builder);
    }
    return (A) this;
  }
  
  public A addToSecretGenerator(int index,SecretArgs item) {
    if (this.secretGenerator == null) {
      this.secretGenerator = new ArrayList();
    }
    SecretArgsBuilder builder = new SecretArgsBuilder(item);
    if (index < 0 || index >= secretGenerator.size()) {
        _visitables.get("secretGenerator").add(builder);
        secretGenerator.add(builder);
    } else {
        _visitables.get("secretGenerator").add(builder);
        secretGenerator.add(index, builder);
    }
    return (A) this;
  }
  
  public A addToTransformers(String... items) {
    if (this.transformers == null) {
      this.transformers = new ArrayList();
    }
    for (String item : items) {
      this.transformers.add(item);
    }
    return (A) this;
  }
  
  public A addToTransformers(int index,String item) {
    if (this.transformers == null) {
      this.transformers = new ArrayList();
    }
    this.transformers.add(index, item);
    return (A) this;
  }
  
  public A addToValidators(String... items) {
    if (this.validators == null) {
      this.validators = new ArrayList();
    }
    for (String item : items) {
      this.validators.add(item);
    }
    return (A) this;
  }
  
  public A addToValidators(int index,String item) {
    if (this.validators == null) {
      this.validators = new ArrayList();
    }
    this.validators.add(index, item);
    return (A) this;
  }
  
  public A addToVars(Var... items) {
    if (this.vars == null) {
      this.vars = new ArrayList();
    }
    for (Var item : items) {
        VarBuilder builder = new VarBuilder(item);
        _visitables.get("vars").add(builder);
        this.vars.add(builder);
    }
    return (A) this;
  }
  
  public A addToVars(int index,Var item) {
    if (this.vars == null) {
      this.vars = new ArrayList();
    }
    VarBuilder builder = new VarBuilder(item);
    if (index < 0 || index >= vars.size()) {
        _visitables.get("vars").add(builder);
        vars.add(builder);
    } else {
        _visitables.get("vars").add(builder);
        vars.add(index, builder);
    }
    return (A) this;
  }
  
  public List<ConfigMapArgs> buildConfigMapGenerator() {
    return this.configMapGenerator != null ? build(configMapGenerator) : null;
  }
  
  public ConfigMapArgs buildConfigMapGenerator(int index) {
    return this.configMapGenerator.get(index).build();
  }
  
  public ConfigMapArgs buildFirstConfigMapGenerator() {
    return this.configMapGenerator.get(0).build();
  }
  
  public HelmChart buildFirstHelmChart() {
    return this.helmCharts.get(0).build();
  }
  
  public HelmChartArgs buildFirstHelmChartInflationGenerator() {
    return this.helmChartInflationGenerator.get(0).build();
  }
  
  public Image buildFirstImage() {
    return this.images.get(0).build();
  }
  
  public Image buildFirstImageTag() {
    return this.imageTags.get(0).build();
  }
  
  public Label buildFirstLabel() {
    return this.labels.get(0).build();
  }
  
  public Patch buildFirstPatch() {
    return this.patches.get(0).build();
  }
  
  public Patch buildFirstPatchesJson6902() {
    return this.patchesJson6902.get(0).build();
  }
  
  public ReplacementField buildFirstReplacement() {
    return this.replacements.get(0).build();
  }
  
  public Replica buildFirstReplica() {
    return this.replicas.get(0).build();
  }
  
  public SecretArgs buildFirstSecretGenerator() {
    return this.secretGenerator.get(0).build();
  }
  
  public Var buildFirstVar() {
    return this.vars.get(0).build();
  }
  
  public GeneratorOptions buildGeneratorOptions() {
    return this.generatorOptions != null ? this.generatorOptions.build() : null;
  }
  
  public HelmChart buildHelmChart(int index) {
    return this.helmCharts.get(index).build();
  }
  
  public List<HelmChartArgs> buildHelmChartInflationGenerator() {
    return this.helmChartInflationGenerator != null ? build(helmChartInflationGenerator) : null;
  }
  
  public HelmChartArgs buildHelmChartInflationGenerator(int index) {
    return this.helmChartInflationGenerator.get(index).build();
  }
  
  public List<HelmChart> buildHelmCharts() {
    return this.helmCharts != null ? build(helmCharts) : null;
  }
  
  public HelmGlobals buildHelmGlobals() {
    return this.helmGlobals != null ? this.helmGlobals.build() : null;
  }
  
  public Image buildImage(int index) {
    return this.images.get(index).build();
  }
  
  public Image buildImageTag(int index) {
    return this.imageTags.get(index).build();
  }
  
  public List<Image> buildImageTags() {
    return this.imageTags != null ? build(imageTags) : null;
  }
  
  public List<Image> buildImages() {
    return this.images != null ? build(images) : null;
  }
  
  public Label buildLabel(int index) {
    return this.labels.get(index).build();
  }
  
  public List<Label> buildLabels() {
    return this.labels != null ? build(labels) : null;
  }
  
  public ConfigMapArgs buildLastConfigMapGenerator() {
    return this.configMapGenerator.get(configMapGenerator.size() - 1).build();
  }
  
  public HelmChart buildLastHelmChart() {
    return this.helmCharts.get(helmCharts.size() - 1).build();
  }
  
  public HelmChartArgs buildLastHelmChartInflationGenerator() {
    return this.helmChartInflationGenerator.get(helmChartInflationGenerator.size() - 1).build();
  }
  
  public Image buildLastImage() {
    return this.images.get(images.size() - 1).build();
  }
  
  public Image buildLastImageTag() {
    return this.imageTags.get(imageTags.size() - 1).build();
  }
  
  public Label buildLastLabel() {
    return this.labels.get(labels.size() - 1).build();
  }
  
  public Patch buildLastPatch() {
    return this.patches.get(patches.size() - 1).build();
  }
  
  public Patch buildLastPatchesJson6902() {
    return this.patchesJson6902.get(patchesJson6902.size() - 1).build();
  }
  
  public ReplacementField buildLastReplacement() {
    return this.replacements.get(replacements.size() - 1).build();
  }
  
  public Replica buildLastReplica() {
    return this.replicas.get(replicas.size() - 1).build();
  }
  
  public SecretArgs buildLastSecretGenerator() {
    return this.secretGenerator.get(secretGenerator.size() - 1).build();
  }
  
  public Var buildLastVar() {
    return this.vars.get(vars.size() - 1).build();
  }
  
  public ConfigMapArgs buildMatchingConfigMapGenerator(Predicate<ConfigMapArgsBuilder> predicate) {
      for (ConfigMapArgsBuilder item : configMapGenerator) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public HelmChart buildMatchingHelmChart(Predicate<HelmChartBuilder> predicate) {
      for (HelmChartBuilder item : helmCharts) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public HelmChartArgs buildMatchingHelmChartInflationGenerator(Predicate<HelmChartArgsBuilder> predicate) {
      for (HelmChartArgsBuilder item : helmChartInflationGenerator) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public Image buildMatchingImage(Predicate<ImageBuilder> predicate) {
      for (ImageBuilder item : images) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public Image buildMatchingImageTag(Predicate<ImageBuilder> predicate) {
      for (ImageBuilder item : imageTags) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public Label buildMatchingLabel(Predicate<LabelBuilder> predicate) {
      for (LabelBuilder item : labels) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public Patch buildMatchingPatch(Predicate<PatchBuilder> predicate) {
      for (PatchBuilder item : patches) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public Patch buildMatchingPatchesJson6902(Predicate<PatchBuilder> predicate) {
      for (PatchBuilder item : patchesJson6902) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public ReplacementField buildMatchingReplacement(Predicate<ReplacementFieldBuilder> predicate) {
      for (ReplacementFieldBuilder item : replacements) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public Replica buildMatchingReplica(Predicate<ReplicaBuilder> predicate) {
      for (ReplicaBuilder item : replicas) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public SecretArgs buildMatchingSecretGenerator(Predicate<SecretArgsBuilder> predicate) {
      for (SecretArgsBuilder item : secretGenerator) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public Var buildMatchingVar(Predicate<VarBuilder> predicate) {
      for (VarBuilder item : vars) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public ObjectMeta buildMetadata() {
    return this.metadata != null ? this.metadata.build() : null;
  }
  
  public Patch buildPatch(int index) {
    return this.patches.get(index).build();
  }
  
  public List<Patch> buildPatches() {
    return this.patches != null ? build(patches) : null;
  }
  
  public List<Patch> buildPatchesJson6902() {
    return this.patchesJson6902 != null ? build(patchesJson6902) : null;
  }
  
  public Patch buildPatchesJson6902(int index) {
    return this.patchesJson6902.get(index).build();
  }
  
  public ReplacementField buildReplacement(int index) {
    return this.replacements.get(index).build();
  }
  
  public List<ReplacementField> buildReplacements() {
    return this.replacements != null ? build(replacements) : null;
  }
  
  public Replica buildReplica(int index) {
    return this.replicas.get(index).build();
  }
  
  public List<Replica> buildReplicas() {
    return this.replicas != null ? build(replicas) : null;
  }
  
  public List<SecretArgs> buildSecretGenerator() {
    return this.secretGenerator != null ? build(secretGenerator) : null;
  }
  
  public SecretArgs buildSecretGenerator(int index) {
    return this.secretGenerator.get(index).build();
  }
  
  public SortOptions buildSortOptions() {
    return this.sortOptions != null ? this.sortOptions.build() : null;
  }
  
  public Var buildVar(int index) {
    return this.vars.get(index).build();
  }
  
  public List<Var> buildVars() {
    return this.vars != null ? build(vars) : null;
  }
  
  protected void copyInstance(Kustomization instance) {
    instance = instance != null ? instance : new Kustomization();
    if (instance != null) {
        this.withApiVersion(instance.getApiVersion());
        this.withBases(instance.getBases());
        this.withBuildMetadata(instance.getBuildMetadata());
        this.withCommonAnnotations(instance.getCommonAnnotations());
        this.withCommonLabels(instance.getCommonLabels());
        this.withComponents(instance.getComponents());
        this.withConfigMapGenerator(instance.getConfigMapGenerator());
        this.withConfigurations(instance.getConfigurations());
        this.withCrds(instance.getCrds());
        this.withGeneratorOptions(instance.getGeneratorOptions());
        this.withGenerators(instance.getGenerators());
        this.withHelmChartInflationGenerator(instance.getHelmChartInflationGenerator());
        this.withHelmCharts(instance.getHelmCharts());
        this.withHelmGlobals(instance.getHelmGlobals());
        this.withImageTags(instance.getImageTags());
        this.withImages(instance.getImages());
        this.withKind(instance.getKind());
        this.withLabels(instance.getLabels());
        this.withMetadata(instance.getMetadata());
        this.withNamePrefix(instance.getNamePrefix());
        this.withNameSuffix(instance.getNameSuffix());
        this.withNamespace(instance.getNamespace());
        this.withOpenapi(instance.getOpenapi());
        this.withPatches(instance.getPatches());
        this.withPatchesJson6902(instance.getPatchesJson6902());
        this.withPatchesStrategicMerge(instance.getPatchesStrategicMerge());
        this.withReplacements(instance.getReplacements());
        this.withReplicas(instance.getReplicas());
        this.withResources(instance.getResources());
        this.withSecretGenerator(instance.getSecretGenerator());
        this.withSortOptions(instance.getSortOptions());
        this.withTransformers(instance.getTransformers());
        this.withValidators(instance.getValidators());
        this.withVars(instance.getVars());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public ConfigMapGeneratorNested<A> editConfigMapGenerator(int index) {
    if (configMapGenerator.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "configMapGenerator"));
    }
    return this.setNewConfigMapGeneratorLike(index, this.buildConfigMapGenerator(index));
  }
  
  public ConfigMapGeneratorNested<A> editFirstConfigMapGenerator() {
    if (configMapGenerator.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "configMapGenerator"));
    }
    return this.setNewConfigMapGeneratorLike(0, this.buildConfigMapGenerator(0));
  }
  
  public HelmChartsNested<A> editFirstHelmChart() {
    if (helmCharts.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "helmCharts"));
    }
    return this.setNewHelmChartLike(0, this.buildHelmChart(0));
  }
  
  public HelmChartInflationGeneratorNested<A> editFirstHelmChartInflationGenerator() {
    if (helmChartInflationGenerator.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "helmChartInflationGenerator"));
    }
    return this.setNewHelmChartInflationGeneratorLike(0, this.buildHelmChartInflationGenerator(0));
  }
  
  public ImagesNested<A> editFirstImage() {
    if (images.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "images"));
    }
    return this.setNewImageLike(0, this.buildImage(0));
  }
  
  public ImageTagsNested<A> editFirstImageTag() {
    if (imageTags.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "imageTags"));
    }
    return this.setNewImageTagLike(0, this.buildImageTag(0));
  }
  
  public LabelsNested<A> editFirstLabel() {
    if (labels.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "labels"));
    }
    return this.setNewLabelLike(0, this.buildLabel(0));
  }
  
  public PatchesNested<A> editFirstPatch() {
    if (patches.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "patches"));
    }
    return this.setNewPatchLike(0, this.buildPatch(0));
  }
  
  public PatchesJson6902Nested<A> editFirstPatchesJson6902() {
    if (patchesJson6902.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "patchesJson6902"));
    }
    return this.setNewPatchesJson6902Like(0, this.buildPatchesJson6902(0));
  }
  
  public ReplacementsNested<A> editFirstReplacement() {
    if (replacements.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "replacements"));
    }
    return this.setNewReplacementLike(0, this.buildReplacement(0));
  }
  
  public ReplicasNested<A> editFirstReplica() {
    if (replicas.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "replicas"));
    }
    return this.setNewReplicaLike(0, this.buildReplica(0));
  }
  
  public SecretGeneratorNested<A> editFirstSecretGenerator() {
    if (secretGenerator.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "secretGenerator"));
    }
    return this.setNewSecretGeneratorLike(0, this.buildSecretGenerator(0));
  }
  
  public VarsNested<A> editFirstVar() {
    if (vars.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "vars"));
    }
    return this.setNewVarLike(0, this.buildVar(0));
  }
  
  public GeneratorOptionsNested<A> editGeneratorOptions() {
    return this.withNewGeneratorOptionsLike(Optional.ofNullable(this.buildGeneratorOptions()).orElse(null));
  }
  
  public HelmChartsNested<A> editHelmChart(int index) {
    if (helmCharts.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "helmCharts"));
    }
    return this.setNewHelmChartLike(index, this.buildHelmChart(index));
  }
  
  public HelmChartInflationGeneratorNested<A> editHelmChartInflationGenerator(int index) {
    if (helmChartInflationGenerator.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "helmChartInflationGenerator"));
    }
    return this.setNewHelmChartInflationGeneratorLike(index, this.buildHelmChartInflationGenerator(index));
  }
  
  public HelmGlobalsNested<A> editHelmGlobals() {
    return this.withNewHelmGlobalsLike(Optional.ofNullable(this.buildHelmGlobals()).orElse(null));
  }
  
  public ImagesNested<A> editImage(int index) {
    if (images.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "images"));
    }
    return this.setNewImageLike(index, this.buildImage(index));
  }
  
  public ImageTagsNested<A> editImageTag(int index) {
    if (imageTags.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "imageTags"));
    }
    return this.setNewImageTagLike(index, this.buildImageTag(index));
  }
  
  public LabelsNested<A> editLabel(int index) {
    if (labels.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "labels"));
    }
    return this.setNewLabelLike(index, this.buildLabel(index));
  }
  
  public ConfigMapGeneratorNested<A> editLastConfigMapGenerator() {
    int index = configMapGenerator.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "configMapGenerator"));
    }
    return this.setNewConfigMapGeneratorLike(index, this.buildConfigMapGenerator(index));
  }
  
  public HelmChartsNested<A> editLastHelmChart() {
    int index = helmCharts.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "helmCharts"));
    }
    return this.setNewHelmChartLike(index, this.buildHelmChart(index));
  }
  
  public HelmChartInflationGeneratorNested<A> editLastHelmChartInflationGenerator() {
    int index = helmChartInflationGenerator.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "helmChartInflationGenerator"));
    }
    return this.setNewHelmChartInflationGeneratorLike(index, this.buildHelmChartInflationGenerator(index));
  }
  
  public ImagesNested<A> editLastImage() {
    int index = images.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "images"));
    }
    return this.setNewImageLike(index, this.buildImage(index));
  }
  
  public ImageTagsNested<A> editLastImageTag() {
    int index = imageTags.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "imageTags"));
    }
    return this.setNewImageTagLike(index, this.buildImageTag(index));
  }
  
  public LabelsNested<A> editLastLabel() {
    int index = labels.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "labels"));
    }
    return this.setNewLabelLike(index, this.buildLabel(index));
  }
  
  public PatchesNested<A> editLastPatch() {
    int index = patches.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "patches"));
    }
    return this.setNewPatchLike(index, this.buildPatch(index));
  }
  
  public PatchesJson6902Nested<A> editLastPatchesJson6902() {
    int index = patchesJson6902.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "patchesJson6902"));
    }
    return this.setNewPatchesJson6902Like(index, this.buildPatchesJson6902(index));
  }
  
  public ReplacementsNested<A> editLastReplacement() {
    int index = replacements.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "replacements"));
    }
    return this.setNewReplacementLike(index, this.buildReplacement(index));
  }
  
  public ReplicasNested<A> editLastReplica() {
    int index = replicas.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "replicas"));
    }
    return this.setNewReplicaLike(index, this.buildReplica(index));
  }
  
  public SecretGeneratorNested<A> editLastSecretGenerator() {
    int index = secretGenerator.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "secretGenerator"));
    }
    return this.setNewSecretGeneratorLike(index, this.buildSecretGenerator(index));
  }
  
  public VarsNested<A> editLastVar() {
    int index = vars.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "vars"));
    }
    return this.setNewVarLike(index, this.buildVar(index));
  }
  
  public ConfigMapGeneratorNested<A> editMatchingConfigMapGenerator(Predicate<ConfigMapArgsBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < configMapGenerator.size();i++) {
      if (predicate.test(configMapGenerator.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "configMapGenerator"));
    }
    return this.setNewConfigMapGeneratorLike(index, this.buildConfigMapGenerator(index));
  }
  
  public HelmChartsNested<A> editMatchingHelmChart(Predicate<HelmChartBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < helmCharts.size();i++) {
      if (predicate.test(helmCharts.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "helmCharts"));
    }
    return this.setNewHelmChartLike(index, this.buildHelmChart(index));
  }
  
  public HelmChartInflationGeneratorNested<A> editMatchingHelmChartInflationGenerator(Predicate<HelmChartArgsBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < helmChartInflationGenerator.size();i++) {
      if (predicate.test(helmChartInflationGenerator.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "helmChartInflationGenerator"));
    }
    return this.setNewHelmChartInflationGeneratorLike(index, this.buildHelmChartInflationGenerator(index));
  }
  
  public ImagesNested<A> editMatchingImage(Predicate<ImageBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < images.size();i++) {
      if (predicate.test(images.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "images"));
    }
    return this.setNewImageLike(index, this.buildImage(index));
  }
  
  public ImageTagsNested<A> editMatchingImageTag(Predicate<ImageBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < imageTags.size();i++) {
      if (predicate.test(imageTags.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "imageTags"));
    }
    return this.setNewImageTagLike(index, this.buildImageTag(index));
  }
  
  public LabelsNested<A> editMatchingLabel(Predicate<LabelBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < labels.size();i++) {
      if (predicate.test(labels.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "labels"));
    }
    return this.setNewLabelLike(index, this.buildLabel(index));
  }
  
  public PatchesNested<A> editMatchingPatch(Predicate<PatchBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < patches.size();i++) {
      if (predicate.test(patches.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "patches"));
    }
    return this.setNewPatchLike(index, this.buildPatch(index));
  }
  
  public PatchesJson6902Nested<A> editMatchingPatchesJson6902(Predicate<PatchBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < patchesJson6902.size();i++) {
      if (predicate.test(patchesJson6902.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "patchesJson6902"));
    }
    return this.setNewPatchesJson6902Like(index, this.buildPatchesJson6902(index));
  }
  
  public ReplacementsNested<A> editMatchingReplacement(Predicate<ReplacementFieldBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < replacements.size();i++) {
      if (predicate.test(replacements.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "replacements"));
    }
    return this.setNewReplacementLike(index, this.buildReplacement(index));
  }
  
  public ReplicasNested<A> editMatchingReplica(Predicate<ReplicaBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < replicas.size();i++) {
      if (predicate.test(replicas.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "replicas"));
    }
    return this.setNewReplicaLike(index, this.buildReplica(index));
  }
  
  public SecretGeneratorNested<A> editMatchingSecretGenerator(Predicate<SecretArgsBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < secretGenerator.size();i++) {
      if (predicate.test(secretGenerator.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "secretGenerator"));
    }
    return this.setNewSecretGeneratorLike(index, this.buildSecretGenerator(index));
  }
  
  public VarsNested<A> editMatchingVar(Predicate<VarBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < vars.size();i++) {
      if (predicate.test(vars.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "vars"));
    }
    return this.setNewVarLike(index, this.buildVar(index));
  }
  
  public MetadataNested<A> editMetadata() {
    return this.withNewMetadataLike(Optional.ofNullable(this.buildMetadata()).orElse(null));
  }
  
  public GeneratorOptionsNested<A> editOrNewGeneratorOptions() {
    return this.withNewGeneratorOptionsLike(Optional.ofNullable(this.buildGeneratorOptions()).orElse(new GeneratorOptionsBuilder().build()));
  }
  
  public GeneratorOptionsNested<A> editOrNewGeneratorOptionsLike(GeneratorOptions item) {
    return this.withNewGeneratorOptionsLike(Optional.ofNullable(this.buildGeneratorOptions()).orElse(item));
  }
  
  public HelmGlobalsNested<A> editOrNewHelmGlobals() {
    return this.withNewHelmGlobalsLike(Optional.ofNullable(this.buildHelmGlobals()).orElse(new HelmGlobalsBuilder().build()));
  }
  
  public HelmGlobalsNested<A> editOrNewHelmGlobalsLike(HelmGlobals item) {
    return this.withNewHelmGlobalsLike(Optional.ofNullable(this.buildHelmGlobals()).orElse(item));
  }
  
  public MetadataNested<A> editOrNewMetadata() {
    return this.withNewMetadataLike(Optional.ofNullable(this.buildMetadata()).orElse(new ObjectMetaBuilder().build()));
  }
  
  public MetadataNested<A> editOrNewMetadataLike(ObjectMeta item) {
    return this.withNewMetadataLike(Optional.ofNullable(this.buildMetadata()).orElse(item));
  }
  
  public SortOptionsNested<A> editOrNewSortOptions() {
    return this.withNewSortOptionsLike(Optional.ofNullable(this.buildSortOptions()).orElse(new SortOptionsBuilder().build()));
  }
  
  public SortOptionsNested<A> editOrNewSortOptionsLike(SortOptions item) {
    return this.withNewSortOptionsLike(Optional.ofNullable(this.buildSortOptions()).orElse(item));
  }
  
  public PatchesNested<A> editPatch(int index) {
    if (patches.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "patches"));
    }
    return this.setNewPatchLike(index, this.buildPatch(index));
  }
  
  public PatchesJson6902Nested<A> editPatchesJson6902(int index) {
    if (patchesJson6902.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "patchesJson6902"));
    }
    return this.setNewPatchesJson6902Like(index, this.buildPatchesJson6902(index));
  }
  
  public ReplacementsNested<A> editReplacement(int index) {
    if (replacements.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "replacements"));
    }
    return this.setNewReplacementLike(index, this.buildReplacement(index));
  }
  
  public ReplicasNested<A> editReplica(int index) {
    if (replicas.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "replicas"));
    }
    return this.setNewReplicaLike(index, this.buildReplica(index));
  }
  
  public SecretGeneratorNested<A> editSecretGenerator(int index) {
    if (secretGenerator.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "secretGenerator"));
    }
    return this.setNewSecretGeneratorLike(index, this.buildSecretGenerator(index));
  }
  
  public SortOptionsNested<A> editSortOptions() {
    return this.withNewSortOptionsLike(Optional.ofNullable(this.buildSortOptions()).orElse(null));
  }
  
  public VarsNested<A> editVar(int index) {
    if (vars.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "vars"));
    }
    return this.setNewVarLike(index, this.buildVar(index));
  }
  
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || this.getClass() != o.getClass()) {
      return false;
    }
    if (!(super.equals(o))) {
      return false;
    }
    KustomizationFluent that = (KustomizationFluent) o;
    if (!(Objects.equals(apiVersion, that.apiVersion))) {
      return false;
    }
    if (!(Objects.equals(bases, that.bases))) {
      return false;
    }
    if (!(Objects.equals(buildMetadata, that.buildMetadata))) {
      return false;
    }
    if (!(Objects.equals(commonAnnotations, that.commonAnnotations))) {
      return false;
    }
    if (!(Objects.equals(commonLabels, that.commonLabels))) {
      return false;
    }
    if (!(Objects.equals(components, that.components))) {
      return false;
    }
    if (!(Objects.equals(configMapGenerator, that.configMapGenerator))) {
      return false;
    }
    if (!(Objects.equals(configurations, that.configurations))) {
      return false;
    }
    if (!(Objects.equals(crds, that.crds))) {
      return false;
    }
    if (!(Objects.equals(generatorOptions, that.generatorOptions))) {
      return false;
    }
    if (!(Objects.equals(generators, that.generators))) {
      return false;
    }
    if (!(Objects.equals(helmChartInflationGenerator, that.helmChartInflationGenerator))) {
      return false;
    }
    if (!(Objects.equals(helmCharts, that.helmCharts))) {
      return false;
    }
    if (!(Objects.equals(helmGlobals, that.helmGlobals))) {
      return false;
    }
    if (!(Objects.equals(imageTags, that.imageTags))) {
      return false;
    }
    if (!(Objects.equals(images, that.images))) {
      return false;
    }
    if (!(Objects.equals(kind, that.kind))) {
      return false;
    }
    if (!(Objects.equals(labels, that.labels))) {
      return false;
    }
    if (!(Objects.equals(metadata, that.metadata))) {
      return false;
    }
    if (!(Objects.equals(namePrefix, that.namePrefix))) {
      return false;
    }
    if (!(Objects.equals(nameSuffix, that.nameSuffix))) {
      return false;
    }
    if (!(Objects.equals(namespace, that.namespace))) {
      return false;
    }
    if (!(Objects.equals(openapi, that.openapi))) {
      return false;
    }
    if (!(Objects.equals(patches, that.patches))) {
      return false;
    }
    if (!(Objects.equals(patchesJson6902, that.patchesJson6902))) {
      return false;
    }
    if (!(Objects.equals(patchesStrategicMerge, that.patchesStrategicMerge))) {
      return false;
    }
    if (!(Objects.equals(replacements, that.replacements))) {
      return false;
    }
    if (!(Objects.equals(replicas, that.replicas))) {
      return false;
    }
    if (!(Objects.equals(resources, that.resources))) {
      return false;
    }
    if (!(Objects.equals(secretGenerator, that.secretGenerator))) {
      return false;
    }
    if (!(Objects.equals(sortOptions, that.sortOptions))) {
      return false;
    }
    if (!(Objects.equals(transformers, that.transformers))) {
      return false;
    }
    if (!(Objects.equals(validators, that.validators))) {
      return false;
    }
    if (!(Objects.equals(vars, that.vars))) {
      return false;
    }
    if (!(Objects.equals(additionalProperties, that.additionalProperties))) {
      return false;
    }
    return true;
  }
  
  public Map<String,Object> getAdditionalProperties() {
    return this.additionalProperties;
  }
  
  public String getApiVersion() {
    return this.apiVersion;
  }
  
  public List<String> getBases() {
    return this.bases;
  }
  
  public String getBasis(int index) {
    return this.bases.get(index);
  }
  
  public List<String> getBuildMetadata() {
    return this.buildMetadata;
  }
  
  public String getBuildMetadatum(int index) {
    return this.buildMetadata.get(index);
  }
  
  public Map<String,String> getCommonAnnotations() {
    return this.commonAnnotations;
  }
  
  public Map<String,String> getCommonLabels() {
    return this.commonLabels;
  }
  
  public String getComponent(int index) {
    return this.components.get(index);
  }
  
  public List<String> getComponents() {
    return this.components;
  }
  
  public String getConfiguration(int index) {
    return this.configurations.get(index);
  }
  
  public List<String> getConfigurations() {
    return this.configurations;
  }
  
  public String getCrd(int index) {
    return this.crds.get(index);
  }
  
  public List<String> getCrds() {
    return this.crds;
  }
  
  public String getFirstBasis() {
    return this.bases.get(0);
  }
  
  public String getFirstBuildMetadatum() {
    return this.buildMetadata.get(0);
  }
  
  public String getFirstComponent() {
    return this.components.get(0);
  }
  
  public String getFirstConfiguration() {
    return this.configurations.get(0);
  }
  
  public String getFirstCrd() {
    return this.crds.get(0);
  }
  
  public String getFirstGenerator() {
    return this.generators.get(0);
  }
  
  public String getFirstPatchesStrategicMerge() {
    return this.patchesStrategicMerge.get(0);
  }
  
  public String getFirstResource() {
    return this.resources.get(0);
  }
  
  public String getFirstTransformer() {
    return this.transformers.get(0);
  }
  
  public String getFirstValidator() {
    return this.validators.get(0);
  }
  
  public String getGenerator(int index) {
    return this.generators.get(index);
  }
  
  public List<String> getGenerators() {
    return this.generators;
  }
  
  public String getKind() {
    return this.kind;
  }
  
  public String getLastBasis() {
    return this.bases.get(bases.size() - 1);
  }
  
  public String getLastBuildMetadatum() {
    return this.buildMetadata.get(buildMetadata.size() - 1);
  }
  
  public String getLastComponent() {
    return this.components.get(components.size() - 1);
  }
  
  public String getLastConfiguration() {
    return this.configurations.get(configurations.size() - 1);
  }
  
  public String getLastCrd() {
    return this.crds.get(crds.size() - 1);
  }
  
  public String getLastGenerator() {
    return this.generators.get(generators.size() - 1);
  }
  
  public String getLastPatchesStrategicMerge() {
    return this.patchesStrategicMerge.get(patchesStrategicMerge.size() - 1);
  }
  
  public String getLastResource() {
    return this.resources.get(resources.size() - 1);
  }
  
  public String getLastTransformer() {
    return this.transformers.get(transformers.size() - 1);
  }
  
  public String getLastValidator() {
    return this.validators.get(validators.size() - 1);
  }
  
  public String getMatchingBasis(Predicate<String> predicate) {
      for (String item : bases) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public String getMatchingBuildMetadatum(Predicate<String> predicate) {
      for (String item : buildMetadata) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public String getMatchingComponent(Predicate<String> predicate) {
      for (String item : components) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public String getMatchingConfiguration(Predicate<String> predicate) {
      for (String item : configurations) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public String getMatchingCrd(Predicate<String> predicate) {
      for (String item : crds) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public String getMatchingGenerator(Predicate<String> predicate) {
      for (String item : generators) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public String getMatchingPatchesStrategicMerge(Predicate<String> predicate) {
      for (String item : patchesStrategicMerge) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public String getMatchingResource(Predicate<String> predicate) {
      for (String item : resources) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public String getMatchingTransformer(Predicate<String> predicate) {
      for (String item : transformers) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public String getMatchingValidator(Predicate<String> predicate) {
      for (String item : validators) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public String getNamePrefix() {
    return this.namePrefix;
  }
  
  public String getNameSuffix() {
    return this.nameSuffix;
  }
  
  public String getNamespace() {
    return this.namespace;
  }
  
  public Map<String,String> getOpenapi() {
    return this.openapi;
  }
  
  public List<String> getPatchesStrategicMerge() {
    return this.patchesStrategicMerge;
  }
  
  public String getPatchesStrategicMerge(int index) {
    return this.patchesStrategicMerge.get(index);
  }
  
  public String getResource(int index) {
    return this.resources.get(index);
  }
  
  public List<String> getResources() {
    return this.resources;
  }
  
  public String getTransformer(int index) {
    return this.transformers.get(index);
  }
  
  public List<String> getTransformers() {
    return this.transformers;
  }
  
  public String getValidator(int index) {
    return this.validators.get(index);
  }
  
  public List<String> getValidators() {
    return this.validators;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasApiVersion() {
    return this.apiVersion != null;
  }
  
  public boolean hasBases() {
    return this.bases != null && !(this.bases.isEmpty());
  }
  
  public boolean hasBuildMetadata() {
    return this.buildMetadata != null && !(this.buildMetadata.isEmpty());
  }
  
  public boolean hasCommonAnnotations() {
    return this.commonAnnotations != null;
  }
  
  public boolean hasCommonLabels() {
    return this.commonLabels != null;
  }
  
  public boolean hasComponents() {
    return this.components != null && !(this.components.isEmpty());
  }
  
  public boolean hasConfigMapGenerator() {
    return this.configMapGenerator != null && !(this.configMapGenerator.isEmpty());
  }
  
  public boolean hasConfigurations() {
    return this.configurations != null && !(this.configurations.isEmpty());
  }
  
  public boolean hasCrds() {
    return this.crds != null && !(this.crds.isEmpty());
  }
  
  public boolean hasGeneratorOptions() {
    return this.generatorOptions != null;
  }
  
  public boolean hasGenerators() {
    return this.generators != null && !(this.generators.isEmpty());
  }
  
  public boolean hasHelmChartInflationGenerator() {
    return this.helmChartInflationGenerator != null && !(this.helmChartInflationGenerator.isEmpty());
  }
  
  public boolean hasHelmCharts() {
    return this.helmCharts != null && !(this.helmCharts.isEmpty());
  }
  
  public boolean hasHelmGlobals() {
    return this.helmGlobals != null;
  }
  
  public boolean hasImageTags() {
    return this.imageTags != null && !(this.imageTags.isEmpty());
  }
  
  public boolean hasImages() {
    return this.images != null && !(this.images.isEmpty());
  }
  
  public boolean hasKind() {
    return this.kind != null;
  }
  
  public boolean hasLabels() {
    return this.labels != null && !(this.labels.isEmpty());
  }
  
  public boolean hasMatchingBasis(Predicate<String> predicate) {
      for (String item : bases) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingBuildMetadatum(Predicate<String> predicate) {
      for (String item : buildMetadata) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingComponent(Predicate<String> predicate) {
      for (String item : components) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingConfigMapGenerator(Predicate<ConfigMapArgsBuilder> predicate) {
      for (ConfigMapArgsBuilder item : configMapGenerator) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingConfiguration(Predicate<String> predicate) {
      for (String item : configurations) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingCrd(Predicate<String> predicate) {
      for (String item : crds) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingGenerator(Predicate<String> predicate) {
      for (String item : generators) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingHelmChart(Predicate<HelmChartBuilder> predicate) {
      for (HelmChartBuilder item : helmCharts) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingHelmChartInflationGenerator(Predicate<HelmChartArgsBuilder> predicate) {
      for (HelmChartArgsBuilder item : helmChartInflationGenerator) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingImage(Predicate<ImageBuilder> predicate) {
      for (ImageBuilder item : images) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingImageTag(Predicate<ImageBuilder> predicate) {
      for (ImageBuilder item : imageTags) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingLabel(Predicate<LabelBuilder> predicate) {
      for (LabelBuilder item : labels) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingPatch(Predicate<PatchBuilder> predicate) {
      for (PatchBuilder item : patches) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingPatchesJson6902(Predicate<PatchBuilder> predicate) {
      for (PatchBuilder item : patchesJson6902) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingPatchesStrategicMerge(Predicate<String> predicate) {
      for (String item : patchesStrategicMerge) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingReplacement(Predicate<ReplacementFieldBuilder> predicate) {
      for (ReplacementFieldBuilder item : replacements) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingReplica(Predicate<ReplicaBuilder> predicate) {
      for (ReplicaBuilder item : replicas) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingResource(Predicate<String> predicate) {
      for (String item : resources) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingSecretGenerator(Predicate<SecretArgsBuilder> predicate) {
      for (SecretArgsBuilder item : secretGenerator) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingTransformer(Predicate<String> predicate) {
      for (String item : transformers) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingValidator(Predicate<String> predicate) {
      for (String item : validators) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingVar(Predicate<VarBuilder> predicate) {
      for (VarBuilder item : vars) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMetadata() {
    return this.metadata != null;
  }
  
  public boolean hasNamePrefix() {
    return this.namePrefix != null;
  }
  
  public boolean hasNameSuffix() {
    return this.nameSuffix != null;
  }
  
  public boolean hasNamespace() {
    return this.namespace != null;
  }
  
  public boolean hasOpenapi() {
    return this.openapi != null;
  }
  
  public boolean hasPatches() {
    return this.patches != null && !(this.patches.isEmpty());
  }
  
  public boolean hasPatchesJson6902() {
    return this.patchesJson6902 != null && !(this.patchesJson6902.isEmpty());
  }
  
  public boolean hasPatchesStrategicMerge() {
    return this.patchesStrategicMerge != null && !(this.patchesStrategicMerge.isEmpty());
  }
  
  public boolean hasReplacements() {
    return this.replacements != null && !(this.replacements.isEmpty());
  }
  
  public boolean hasReplicas() {
    return this.replicas != null && !(this.replicas.isEmpty());
  }
  
  public boolean hasResources() {
    return this.resources != null && !(this.resources.isEmpty());
  }
  
  public boolean hasSecretGenerator() {
    return this.secretGenerator != null && !(this.secretGenerator.isEmpty());
  }
  
  public boolean hasSortOptions() {
    return this.sortOptions != null;
  }
  
  public boolean hasTransformers() {
    return this.transformers != null && !(this.transformers.isEmpty());
  }
  
  public boolean hasValidators() {
    return this.validators != null && !(this.validators.isEmpty());
  }
  
  public boolean hasVars() {
    return this.vars != null && !(this.vars.isEmpty());
  }
  
  public int hashCode() {
    return Objects.hash(apiVersion, bases, buildMetadata, commonAnnotations, commonLabels, components, configMapGenerator, configurations, crds, generatorOptions, generators, helmChartInflationGenerator, helmCharts, helmGlobals, imageTags, images, kind, labels, metadata, namePrefix, nameSuffix, namespace, openapi, patches, patchesJson6902, patchesStrategicMerge, replacements, replicas, resources, secretGenerator, sortOptions, transformers, validators, vars, additionalProperties);
  }
  
  public A removeAllFromBases(Collection<String> items) {
    if (this.bases == null) {
      return (A) this;
    }
    for (String item : items) {
      this.bases.remove(item);
    }
    return (A) this;
  }
  
  public A removeAllFromBuildMetadata(Collection<String> items) {
    if (this.buildMetadata == null) {
      return (A) this;
    }
    for (String item : items) {
      this.buildMetadata.remove(item);
    }
    return (A) this;
  }
  
  public A removeAllFromComponents(Collection<String> items) {
    if (this.components == null) {
      return (A) this;
    }
    for (String item : items) {
      this.components.remove(item);
    }
    return (A) this;
  }
  
  public A removeAllFromConfigMapGenerator(Collection<ConfigMapArgs> items) {
    if (this.configMapGenerator == null) {
      return (A) this;
    }
    for (ConfigMapArgs item : items) {
        ConfigMapArgsBuilder builder = new ConfigMapArgsBuilder(item);
        _visitables.get("configMapGenerator").remove(builder);
        this.configMapGenerator.remove(builder);
    }
    return (A) this;
  }
  
  public A removeAllFromConfigurations(Collection<String> items) {
    if (this.configurations == null) {
      return (A) this;
    }
    for (String item : items) {
      this.configurations.remove(item);
    }
    return (A) this;
  }
  
  public A removeAllFromCrds(Collection<String> items) {
    if (this.crds == null) {
      return (A) this;
    }
    for (String item : items) {
      this.crds.remove(item);
    }
    return (A) this;
  }
  
  public A removeAllFromGenerators(Collection<String> items) {
    if (this.generators == null) {
      return (A) this;
    }
    for (String item : items) {
      this.generators.remove(item);
    }
    return (A) this;
  }
  
  public A removeAllFromHelmChartInflationGenerator(Collection<HelmChartArgs> items) {
    if (this.helmChartInflationGenerator == null) {
      return (A) this;
    }
    for (HelmChartArgs item : items) {
        HelmChartArgsBuilder builder = new HelmChartArgsBuilder(item);
        _visitables.get("helmChartInflationGenerator").remove(builder);
        this.helmChartInflationGenerator.remove(builder);
    }
    return (A) this;
  }
  
  public A removeAllFromHelmCharts(Collection<HelmChart> items) {
    if (this.helmCharts == null) {
      return (A) this;
    }
    for (HelmChart item : items) {
        HelmChartBuilder builder = new HelmChartBuilder(item);
        _visitables.get("helmCharts").remove(builder);
        this.helmCharts.remove(builder);
    }
    return (A) this;
  }
  
  public A removeAllFromImageTags(Collection<Image> items) {
    if (this.imageTags == null) {
      return (A) this;
    }
    for (Image item : items) {
        ImageBuilder builder = new ImageBuilder(item);
        _visitables.get("imageTags").remove(builder);
        this.imageTags.remove(builder);
    }
    return (A) this;
  }
  
  public A removeAllFromImages(Collection<Image> items) {
    if (this.images == null) {
      return (A) this;
    }
    for (Image item : items) {
        ImageBuilder builder = new ImageBuilder(item);
        _visitables.get("images").remove(builder);
        this.images.remove(builder);
    }
    return (A) this;
  }
  
  public A removeAllFromLabels(Collection<Label> items) {
    if (this.labels == null) {
      return (A) this;
    }
    for (Label item : items) {
        LabelBuilder builder = new LabelBuilder(item);
        _visitables.get("labels").remove(builder);
        this.labels.remove(builder);
    }
    return (A) this;
  }
  
  public A removeAllFromPatches(Collection<Patch> items) {
    if (this.patches == null) {
      return (A) this;
    }
    for (Patch item : items) {
        PatchBuilder builder = new PatchBuilder(item);
        _visitables.get("patches").remove(builder);
        this.patches.remove(builder);
    }
    return (A) this;
  }
  
  public A removeAllFromPatchesJson6902(Collection<Patch> items) {
    if (this.patchesJson6902 == null) {
      return (A) this;
    }
    for (Patch item : items) {
        PatchBuilder builder = new PatchBuilder(item);
        _visitables.get("patchesJson6902").remove(builder);
        this.patchesJson6902.remove(builder);
    }
    return (A) this;
  }
  
  public A removeAllFromPatchesStrategicMerge(Collection<String> items) {
    if (this.patchesStrategicMerge == null) {
      return (A) this;
    }
    for (String item : items) {
      this.patchesStrategicMerge.remove(item);
    }
    return (A) this;
  }
  
  public A removeAllFromReplacements(Collection<ReplacementField> items) {
    if (this.replacements == null) {
      return (A) this;
    }
    for (ReplacementField item : items) {
        ReplacementFieldBuilder builder = new ReplacementFieldBuilder(item);
        _visitables.get("replacements").remove(builder);
        this.replacements.remove(builder);
    }
    return (A) this;
  }
  
  public A removeAllFromReplicas(Collection<Replica> items) {
    if (this.replicas == null) {
      return (A) this;
    }
    for (Replica item : items) {
        ReplicaBuilder builder = new ReplicaBuilder(item);
        _visitables.get("replicas").remove(builder);
        this.replicas.remove(builder);
    }
    return (A) this;
  }
  
  public A removeAllFromResources(Collection<String> items) {
    if (this.resources == null) {
      return (A) this;
    }
    for (String item : items) {
      this.resources.remove(item);
    }
    return (A) this;
  }
  
  public A removeAllFromSecretGenerator(Collection<SecretArgs> items) {
    if (this.secretGenerator == null) {
      return (A) this;
    }
    for (SecretArgs item : items) {
        SecretArgsBuilder builder = new SecretArgsBuilder(item);
        _visitables.get("secretGenerator").remove(builder);
        this.secretGenerator.remove(builder);
    }
    return (A) this;
  }
  
  public A removeAllFromTransformers(Collection<String> items) {
    if (this.transformers == null) {
      return (A) this;
    }
    for (String item : items) {
      this.transformers.remove(item);
    }
    return (A) this;
  }
  
  public A removeAllFromValidators(Collection<String> items) {
    if (this.validators == null) {
      return (A) this;
    }
    for (String item : items) {
      this.validators.remove(item);
    }
    return (A) this;
  }
  
  public A removeAllFromVars(Collection<Var> items) {
    if (this.vars == null) {
      return (A) this;
    }
    for (Var item : items) {
        VarBuilder builder = new VarBuilder(item);
        _visitables.get("vars").remove(builder);
        this.vars.remove(builder);
    }
    return (A) this;
  }
  
  public A removeFromAdditionalProperties(String key) {
    if (this.additionalProperties == null) {
      return (A) this;
    }
    if (key != null && this.additionalProperties != null) {
      this.additionalProperties.remove(key);
    }
    return (A) this;
  }
  
  public A removeFromAdditionalProperties(Map<String,Object> map) {
    if (this.additionalProperties == null) {
      return (A) this;
    }
    if (map != null) {
      for (Object key : map.keySet()) {
        if (this.additionalProperties != null) {
          this.additionalProperties.remove(key);
        }
      }
    }
    return (A) this;
  }
  
  public A removeFromBases(String... items) {
    if (this.bases == null) {
      return (A) this;
    }
    for (String item : items) {
      this.bases.remove(item);
    }
    return (A) this;
  }
  
  public A removeFromBuildMetadata(String... items) {
    if (this.buildMetadata == null) {
      return (A) this;
    }
    for (String item : items) {
      this.buildMetadata.remove(item);
    }
    return (A) this;
  }
  
  public A removeFromCommonAnnotations(String key) {
    if (this.commonAnnotations == null) {
      return (A) this;
    }
    if (key != null && this.commonAnnotations != null) {
      this.commonAnnotations.remove(key);
    }
    return (A) this;
  }
  
  public A removeFromCommonAnnotations(Map<String,String> map) {
    if (this.commonAnnotations == null) {
      return (A) this;
    }
    if (map != null) {
      for (Object key : map.keySet()) {
        if (this.commonAnnotations != null) {
          this.commonAnnotations.remove(key);
        }
      }
    }
    return (A) this;
  }
  
  public A removeFromCommonLabels(String key) {
    if (this.commonLabels == null) {
      return (A) this;
    }
    if (key != null && this.commonLabels != null) {
      this.commonLabels.remove(key);
    }
    return (A) this;
  }
  
  public A removeFromCommonLabels(Map<String,String> map) {
    if (this.commonLabels == null) {
      return (A) this;
    }
    if (map != null) {
      for (Object key : map.keySet()) {
        if (this.commonLabels != null) {
          this.commonLabels.remove(key);
        }
      }
    }
    return (A) this;
  }
  
  public A removeFromComponents(String... items) {
    if (this.components == null) {
      return (A) this;
    }
    for (String item : items) {
      this.components.remove(item);
    }
    return (A) this;
  }
  
  public A removeFromConfigMapGenerator(ConfigMapArgs... items) {
    if (this.configMapGenerator == null) {
      return (A) this;
    }
    for (ConfigMapArgs item : items) {
        ConfigMapArgsBuilder builder = new ConfigMapArgsBuilder(item);
        _visitables.get("configMapGenerator").remove(builder);
        this.configMapGenerator.remove(builder);
    }
    return (A) this;
  }
  
  public A removeFromConfigurations(String... items) {
    if (this.configurations == null) {
      return (A) this;
    }
    for (String item : items) {
      this.configurations.remove(item);
    }
    return (A) this;
  }
  
  public A removeFromCrds(String... items) {
    if (this.crds == null) {
      return (A) this;
    }
    for (String item : items) {
      this.crds.remove(item);
    }
    return (A) this;
  }
  
  public A removeFromGenerators(String... items) {
    if (this.generators == null) {
      return (A) this;
    }
    for (String item : items) {
      this.generators.remove(item);
    }
    return (A) this;
  }
  
  public A removeFromHelmChartInflationGenerator(HelmChartArgs... items) {
    if (this.helmChartInflationGenerator == null) {
      return (A) this;
    }
    for (HelmChartArgs item : items) {
        HelmChartArgsBuilder builder = new HelmChartArgsBuilder(item);
        _visitables.get("helmChartInflationGenerator").remove(builder);
        this.helmChartInflationGenerator.remove(builder);
    }
    return (A) this;
  }
  
  public A removeFromHelmCharts(HelmChart... items) {
    if (this.helmCharts == null) {
      return (A) this;
    }
    for (HelmChart item : items) {
        HelmChartBuilder builder = new HelmChartBuilder(item);
        _visitables.get("helmCharts").remove(builder);
        this.helmCharts.remove(builder);
    }
    return (A) this;
  }
  
  public A removeFromImageTags(Image... items) {
    if (this.imageTags == null) {
      return (A) this;
    }
    for (Image item : items) {
        ImageBuilder builder = new ImageBuilder(item);
        _visitables.get("imageTags").remove(builder);
        this.imageTags.remove(builder);
    }
    return (A) this;
  }
  
  public A removeFromImages(Image... items) {
    if (this.images == null) {
      return (A) this;
    }
    for (Image item : items) {
        ImageBuilder builder = new ImageBuilder(item);
        _visitables.get("images").remove(builder);
        this.images.remove(builder);
    }
    return (A) this;
  }
  
  public A removeFromLabels(Label... items) {
    if (this.labels == null) {
      return (A) this;
    }
    for (Label item : items) {
        LabelBuilder builder = new LabelBuilder(item);
        _visitables.get("labels").remove(builder);
        this.labels.remove(builder);
    }
    return (A) this;
  }
  
  public A removeFromOpenapi(String key) {
    if (this.openapi == null) {
      return (A) this;
    }
    if (key != null && this.openapi != null) {
      this.openapi.remove(key);
    }
    return (A) this;
  }
  
  public A removeFromOpenapi(Map<String,String> map) {
    if (this.openapi == null) {
      return (A) this;
    }
    if (map != null) {
      for (Object key : map.keySet()) {
        if (this.openapi != null) {
          this.openapi.remove(key);
        }
      }
    }
    return (A) this;
  }
  
  public A removeFromPatches(Patch... items) {
    if (this.patches == null) {
      return (A) this;
    }
    for (Patch item : items) {
        PatchBuilder builder = new PatchBuilder(item);
        _visitables.get("patches").remove(builder);
        this.patches.remove(builder);
    }
    return (A) this;
  }
  
  public A removeFromPatchesJson6902(Patch... items) {
    if (this.patchesJson6902 == null) {
      return (A) this;
    }
    for (Patch item : items) {
        PatchBuilder builder = new PatchBuilder(item);
        _visitables.get("patchesJson6902").remove(builder);
        this.patchesJson6902.remove(builder);
    }
    return (A) this;
  }
  
  public A removeFromPatchesStrategicMerge(String... items) {
    if (this.patchesStrategicMerge == null) {
      return (A) this;
    }
    for (String item : items) {
      this.patchesStrategicMerge.remove(item);
    }
    return (A) this;
  }
  
  public A removeFromReplacements(ReplacementField... items) {
    if (this.replacements == null) {
      return (A) this;
    }
    for (ReplacementField item : items) {
        ReplacementFieldBuilder builder = new ReplacementFieldBuilder(item);
        _visitables.get("replacements").remove(builder);
        this.replacements.remove(builder);
    }
    return (A) this;
  }
  
  public A removeFromReplicas(Replica... items) {
    if (this.replicas == null) {
      return (A) this;
    }
    for (Replica item : items) {
        ReplicaBuilder builder = new ReplicaBuilder(item);
        _visitables.get("replicas").remove(builder);
        this.replicas.remove(builder);
    }
    return (A) this;
  }
  
  public A removeFromResources(String... items) {
    if (this.resources == null) {
      return (A) this;
    }
    for (String item : items) {
      this.resources.remove(item);
    }
    return (A) this;
  }
  
  public A removeFromSecretGenerator(SecretArgs... items) {
    if (this.secretGenerator == null) {
      return (A) this;
    }
    for (SecretArgs item : items) {
        SecretArgsBuilder builder = new SecretArgsBuilder(item);
        _visitables.get("secretGenerator").remove(builder);
        this.secretGenerator.remove(builder);
    }
    return (A) this;
  }
  
  public A removeFromTransformers(String... items) {
    if (this.transformers == null) {
      return (A) this;
    }
    for (String item : items) {
      this.transformers.remove(item);
    }
    return (A) this;
  }
  
  public A removeFromValidators(String... items) {
    if (this.validators == null) {
      return (A) this;
    }
    for (String item : items) {
      this.validators.remove(item);
    }
    return (A) this;
  }
  
  public A removeFromVars(Var... items) {
    if (this.vars == null) {
      return (A) this;
    }
    for (Var item : items) {
        VarBuilder builder = new VarBuilder(item);
        _visitables.get("vars").remove(builder);
        this.vars.remove(builder);
    }
    return (A) this;
  }
  
  public A removeMatchingFromConfigMapGenerator(Predicate<ConfigMapArgsBuilder> predicate) {
    if (configMapGenerator == null) {
      return (A) this;
    }
    Iterator<ConfigMapArgsBuilder> each = configMapGenerator.iterator();
    List visitables = _visitables.get("configMapGenerator");
    while (each.hasNext()) {
        ConfigMapArgsBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public A removeMatchingFromHelmChartInflationGenerator(Predicate<HelmChartArgsBuilder> predicate) {
    if (helmChartInflationGenerator == null) {
      return (A) this;
    }
    Iterator<HelmChartArgsBuilder> each = helmChartInflationGenerator.iterator();
    List visitables = _visitables.get("helmChartInflationGenerator");
    while (each.hasNext()) {
        HelmChartArgsBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public A removeMatchingFromHelmCharts(Predicate<HelmChartBuilder> predicate) {
    if (helmCharts == null) {
      return (A) this;
    }
    Iterator<HelmChartBuilder> each = helmCharts.iterator();
    List visitables = _visitables.get("helmCharts");
    while (each.hasNext()) {
        HelmChartBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public A removeMatchingFromImageTags(Predicate<ImageBuilder> predicate) {
    if (imageTags == null) {
      return (A) this;
    }
    Iterator<ImageBuilder> each = imageTags.iterator();
    List visitables = _visitables.get("imageTags");
    while (each.hasNext()) {
        ImageBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public A removeMatchingFromImages(Predicate<ImageBuilder> predicate) {
    if (images == null) {
      return (A) this;
    }
    Iterator<ImageBuilder> each = images.iterator();
    List visitables = _visitables.get("images");
    while (each.hasNext()) {
        ImageBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public A removeMatchingFromLabels(Predicate<LabelBuilder> predicate) {
    if (labels == null) {
      return (A) this;
    }
    Iterator<LabelBuilder> each = labels.iterator();
    List visitables = _visitables.get("labels");
    while (each.hasNext()) {
        LabelBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public A removeMatchingFromPatches(Predicate<PatchBuilder> predicate) {
    if (patches == null) {
      return (A) this;
    }
    Iterator<PatchBuilder> each = patches.iterator();
    List visitables = _visitables.get("patches");
    while (each.hasNext()) {
        PatchBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public A removeMatchingFromPatchesJson6902(Predicate<PatchBuilder> predicate) {
    if (patchesJson6902 == null) {
      return (A) this;
    }
    Iterator<PatchBuilder> each = patchesJson6902.iterator();
    List visitables = _visitables.get("patchesJson6902");
    while (each.hasNext()) {
        PatchBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public A removeMatchingFromReplacements(Predicate<ReplacementFieldBuilder> predicate) {
    if (replacements == null) {
      return (A) this;
    }
    Iterator<ReplacementFieldBuilder> each = replacements.iterator();
    List visitables = _visitables.get("replacements");
    while (each.hasNext()) {
        ReplacementFieldBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public A removeMatchingFromReplicas(Predicate<ReplicaBuilder> predicate) {
    if (replicas == null) {
      return (A) this;
    }
    Iterator<ReplicaBuilder> each = replicas.iterator();
    List visitables = _visitables.get("replicas");
    while (each.hasNext()) {
        ReplicaBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public A removeMatchingFromSecretGenerator(Predicate<SecretArgsBuilder> predicate) {
    if (secretGenerator == null) {
      return (A) this;
    }
    Iterator<SecretArgsBuilder> each = secretGenerator.iterator();
    List visitables = _visitables.get("secretGenerator");
    while (each.hasNext()) {
        SecretArgsBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public A removeMatchingFromVars(Predicate<VarBuilder> predicate) {
    if (vars == null) {
      return (A) this;
    }
    Iterator<VarBuilder> each = vars.iterator();
    List visitables = _visitables.get("vars");
    while (each.hasNext()) {
        VarBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public ConfigMapGeneratorNested<A> setNewConfigMapGeneratorLike(int index,ConfigMapArgs item) {
    return new ConfigMapGeneratorNested(index, item);
  }
  
  public HelmChartInflationGeneratorNested<A> setNewHelmChartInflationGeneratorLike(int index,HelmChartArgs item) {
    return new HelmChartInflationGeneratorNested(index, item);
  }
  
  public HelmChartsNested<A> setNewHelmChartLike(int index,HelmChart item) {
    return new HelmChartsNested(index, item);
  }
  
  public ImagesNested<A> setNewImageLike(int index,Image item) {
    return new ImagesNested(index, item);
  }
  
  public ImageTagsNested<A> setNewImageTagLike(int index,Image item) {
    return new ImageTagsNested(index, item);
  }
  
  public LabelsNested<A> setNewLabelLike(int index,Label item) {
    return new LabelsNested(index, item);
  }
  
  public PatchesNested<A> setNewPatchLike(int index,Patch item) {
    return new PatchesNested(index, item);
  }
  
  public PatchesJson6902Nested<A> setNewPatchesJson6902Like(int index,Patch item) {
    return new PatchesJson6902Nested(index, item);
  }
  
  public ReplacementsNested<A> setNewReplacementLike(int index,ReplacementField item) {
    return new ReplacementsNested(index, item);
  }
  
  public ReplicasNested<A> setNewReplicaLike(int index,Replica item) {
    return new ReplicasNested(index, item);
  }
  
  public SecretGeneratorNested<A> setNewSecretGeneratorLike(int index,SecretArgs item) {
    return new SecretGeneratorNested(index, item);
  }
  
  public VarsNested<A> setNewVarLike(int index,Var item) {
    return new VarsNested(index, item);
  }
  
  public A setToBases(int index,String item) {
    if (this.bases == null) {
      this.bases = new ArrayList();
    }
    this.bases.set(index, item);
    return (A) this;
  }
  
  public A setToBuildMetadata(int index,String item) {
    if (this.buildMetadata == null) {
      this.buildMetadata = new ArrayList();
    }
    this.buildMetadata.set(index, item);
    return (A) this;
  }
  
  public A setToComponents(int index,String item) {
    if (this.components == null) {
      this.components = new ArrayList();
    }
    this.components.set(index, item);
    return (A) this;
  }
  
  public A setToConfigMapGenerator(int index,ConfigMapArgs item) {
    if (this.configMapGenerator == null) {
      this.configMapGenerator = new ArrayList();
    }
    ConfigMapArgsBuilder builder = new ConfigMapArgsBuilder(item);
    if (index < 0 || index >= configMapGenerator.size()) {
        _visitables.get("configMapGenerator").add(builder);
        configMapGenerator.add(builder);
    } else {
        _visitables.get("configMapGenerator").add(builder);
        configMapGenerator.set(index, builder);
    }
    return (A) this;
  }
  
  public A setToConfigurations(int index,String item) {
    if (this.configurations == null) {
      this.configurations = new ArrayList();
    }
    this.configurations.set(index, item);
    return (A) this;
  }
  
  public A setToCrds(int index,String item) {
    if (this.crds == null) {
      this.crds = new ArrayList();
    }
    this.crds.set(index, item);
    return (A) this;
  }
  
  public A setToGenerators(int index,String item) {
    if (this.generators == null) {
      this.generators = new ArrayList();
    }
    this.generators.set(index, item);
    return (A) this;
  }
  
  public A setToHelmChartInflationGenerator(int index,HelmChartArgs item) {
    if (this.helmChartInflationGenerator == null) {
      this.helmChartInflationGenerator = new ArrayList();
    }
    HelmChartArgsBuilder builder = new HelmChartArgsBuilder(item);
    if (index < 0 || index >= helmChartInflationGenerator.size()) {
        _visitables.get("helmChartInflationGenerator").add(builder);
        helmChartInflationGenerator.add(builder);
    } else {
        _visitables.get("helmChartInflationGenerator").add(builder);
        helmChartInflationGenerator.set(index, builder);
    }
    return (A) this;
  }
  
  public A setToHelmCharts(int index,HelmChart item) {
    if (this.helmCharts == null) {
      this.helmCharts = new ArrayList();
    }
    HelmChartBuilder builder = new HelmChartBuilder(item);
    if (index < 0 || index >= helmCharts.size()) {
        _visitables.get("helmCharts").add(builder);
        helmCharts.add(builder);
    } else {
        _visitables.get("helmCharts").add(builder);
        helmCharts.set(index, builder);
    }
    return (A) this;
  }
  
  public A setToImageTags(int index,Image item) {
    if (this.imageTags == null) {
      this.imageTags = new ArrayList();
    }
    ImageBuilder builder = new ImageBuilder(item);
    if (index < 0 || index >= imageTags.size()) {
        _visitables.get("imageTags").add(builder);
        imageTags.add(builder);
    } else {
        _visitables.get("imageTags").add(builder);
        imageTags.set(index, builder);
    }
    return (A) this;
  }
  
  public A setToImages(int index,Image item) {
    if (this.images == null) {
      this.images = new ArrayList();
    }
    ImageBuilder builder = new ImageBuilder(item);
    if (index < 0 || index >= images.size()) {
        _visitables.get("images").add(builder);
        images.add(builder);
    } else {
        _visitables.get("images").add(builder);
        images.set(index, builder);
    }
    return (A) this;
  }
  
  public A setToLabels(int index,Label item) {
    if (this.labels == null) {
      this.labels = new ArrayList();
    }
    LabelBuilder builder = new LabelBuilder(item);
    if (index < 0 || index >= labels.size()) {
        _visitables.get("labels").add(builder);
        labels.add(builder);
    } else {
        _visitables.get("labels").add(builder);
        labels.set(index, builder);
    }
    return (A) this;
  }
  
  public A setToPatches(int index,Patch item) {
    if (this.patches == null) {
      this.patches = new ArrayList();
    }
    PatchBuilder builder = new PatchBuilder(item);
    if (index < 0 || index >= patches.size()) {
        _visitables.get("patches").add(builder);
        patches.add(builder);
    } else {
        _visitables.get("patches").add(builder);
        patches.set(index, builder);
    }
    return (A) this;
  }
  
  public A setToPatchesJson6902(int index,Patch item) {
    if (this.patchesJson6902 == null) {
      this.patchesJson6902 = new ArrayList();
    }
    PatchBuilder builder = new PatchBuilder(item);
    if (index < 0 || index >= patchesJson6902.size()) {
        _visitables.get("patchesJson6902").add(builder);
        patchesJson6902.add(builder);
    } else {
        _visitables.get("patchesJson6902").add(builder);
        patchesJson6902.set(index, builder);
    }
    return (A) this;
  }
  
  public A setToPatchesStrategicMerge(int index,String item) {
    if (this.patchesStrategicMerge == null) {
      this.patchesStrategicMerge = new ArrayList();
    }
    this.patchesStrategicMerge.set(index, item);
    return (A) this;
  }
  
  public A setToReplacements(int index,ReplacementField item) {
    if (this.replacements == null) {
      this.replacements = new ArrayList();
    }
    ReplacementFieldBuilder builder = new ReplacementFieldBuilder(item);
    if (index < 0 || index >= replacements.size()) {
        _visitables.get("replacements").add(builder);
        replacements.add(builder);
    } else {
        _visitables.get("replacements").add(builder);
        replacements.set(index, builder);
    }
    return (A) this;
  }
  
  public A setToReplicas(int index,Replica item) {
    if (this.replicas == null) {
      this.replicas = new ArrayList();
    }
    ReplicaBuilder builder = new ReplicaBuilder(item);
    if (index < 0 || index >= replicas.size()) {
        _visitables.get("replicas").add(builder);
        replicas.add(builder);
    } else {
        _visitables.get("replicas").add(builder);
        replicas.set(index, builder);
    }
    return (A) this;
  }
  
  public A setToResources(int index,String item) {
    if (this.resources == null) {
      this.resources = new ArrayList();
    }
    this.resources.set(index, item);
    return (A) this;
  }
  
  public A setToSecretGenerator(int index,SecretArgs item) {
    if (this.secretGenerator == null) {
      this.secretGenerator = new ArrayList();
    }
    SecretArgsBuilder builder = new SecretArgsBuilder(item);
    if (index < 0 || index >= secretGenerator.size()) {
        _visitables.get("secretGenerator").add(builder);
        secretGenerator.add(builder);
    } else {
        _visitables.get("secretGenerator").add(builder);
        secretGenerator.set(index, builder);
    }
    return (A) this;
  }
  
  public A setToTransformers(int index,String item) {
    if (this.transformers == null) {
      this.transformers = new ArrayList();
    }
    this.transformers.set(index, item);
    return (A) this;
  }
  
  public A setToValidators(int index,String item) {
    if (this.validators == null) {
      this.validators = new ArrayList();
    }
    this.validators.set(index, item);
    return (A) this;
  }
  
  public A setToVars(int index,Var item) {
    if (this.vars == null) {
      this.vars = new ArrayList();
    }
    VarBuilder builder = new VarBuilder(item);
    if (index < 0 || index >= vars.size()) {
        _visitables.get("vars").add(builder);
        vars.add(builder);
    } else {
        _visitables.get("vars").add(builder);
        vars.set(index, builder);
    }
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(apiVersion == null)) {
        sb.append("apiVersion:");
        sb.append(apiVersion);
        sb.append(",");
    }
    if (!(bases == null) && !(bases.isEmpty())) {
        sb.append("bases:");
        sb.append(bases);
        sb.append(",");
    }
    if (!(buildMetadata == null) && !(buildMetadata.isEmpty())) {
        sb.append("buildMetadata:");
        sb.append(buildMetadata);
        sb.append(",");
    }
    if (!(commonAnnotations == null) && !(commonAnnotations.isEmpty())) {
        sb.append("commonAnnotations:");
        sb.append(commonAnnotations);
        sb.append(",");
    }
    if (!(commonLabels == null) && !(commonLabels.isEmpty())) {
        sb.append("commonLabels:");
        sb.append(commonLabels);
        sb.append(",");
    }
    if (!(components == null) && !(components.isEmpty())) {
        sb.append("components:");
        sb.append(components);
        sb.append(",");
    }
    if (!(configMapGenerator == null) && !(configMapGenerator.isEmpty())) {
        sb.append("configMapGenerator:");
        sb.append(configMapGenerator);
        sb.append(",");
    }
    if (!(configurations == null) && !(configurations.isEmpty())) {
        sb.append("configurations:");
        sb.append(configurations);
        sb.append(",");
    }
    if (!(crds == null) && !(crds.isEmpty())) {
        sb.append("crds:");
        sb.append(crds);
        sb.append(",");
    }
    if (!(generatorOptions == null)) {
        sb.append("generatorOptions:");
        sb.append(generatorOptions);
        sb.append(",");
    }
    if (!(generators == null) && !(generators.isEmpty())) {
        sb.append("generators:");
        sb.append(generators);
        sb.append(",");
    }
    if (!(helmChartInflationGenerator == null) && !(helmChartInflationGenerator.isEmpty())) {
        sb.append("helmChartInflationGenerator:");
        sb.append(helmChartInflationGenerator);
        sb.append(",");
    }
    if (!(helmCharts == null) && !(helmCharts.isEmpty())) {
        sb.append("helmCharts:");
        sb.append(helmCharts);
        sb.append(",");
    }
    if (!(helmGlobals == null)) {
        sb.append("helmGlobals:");
        sb.append(helmGlobals);
        sb.append(",");
    }
    if (!(imageTags == null) && !(imageTags.isEmpty())) {
        sb.append("imageTags:");
        sb.append(imageTags);
        sb.append(",");
    }
    if (!(images == null) && !(images.isEmpty())) {
        sb.append("images:");
        sb.append(images);
        sb.append(",");
    }
    if (!(kind == null)) {
        sb.append("kind:");
        sb.append(kind);
        sb.append(",");
    }
    if (!(labels == null) && !(labels.isEmpty())) {
        sb.append("labels:");
        sb.append(labels);
        sb.append(",");
    }
    if (!(metadata == null)) {
        sb.append("metadata:");
        sb.append(metadata);
        sb.append(",");
    }
    if (!(namePrefix == null)) {
        sb.append("namePrefix:");
        sb.append(namePrefix);
        sb.append(",");
    }
    if (!(nameSuffix == null)) {
        sb.append("nameSuffix:");
        sb.append(nameSuffix);
        sb.append(",");
    }
    if (!(namespace == null)) {
        sb.append("namespace:");
        sb.append(namespace);
        sb.append(",");
    }
    if (!(openapi == null) && !(openapi.isEmpty())) {
        sb.append("openapi:");
        sb.append(openapi);
        sb.append(",");
    }
    if (!(patches == null) && !(patches.isEmpty())) {
        sb.append("patches:");
        sb.append(patches);
        sb.append(",");
    }
    if (!(patchesJson6902 == null) && !(patchesJson6902.isEmpty())) {
        sb.append("patchesJson6902:");
        sb.append(patchesJson6902);
        sb.append(",");
    }
    if (!(patchesStrategicMerge == null) && !(patchesStrategicMerge.isEmpty())) {
        sb.append("patchesStrategicMerge:");
        sb.append(patchesStrategicMerge);
        sb.append(",");
    }
    if (!(replacements == null) && !(replacements.isEmpty())) {
        sb.append("replacements:");
        sb.append(replacements);
        sb.append(",");
    }
    if (!(replicas == null) && !(replicas.isEmpty())) {
        sb.append("replicas:");
        sb.append(replicas);
        sb.append(",");
    }
    if (!(resources == null) && !(resources.isEmpty())) {
        sb.append("resources:");
        sb.append(resources);
        sb.append(",");
    }
    if (!(secretGenerator == null) && !(secretGenerator.isEmpty())) {
        sb.append("secretGenerator:");
        sb.append(secretGenerator);
        sb.append(",");
    }
    if (!(sortOptions == null)) {
        sb.append("sortOptions:");
        sb.append(sortOptions);
        sb.append(",");
    }
    if (!(transformers == null) && !(transformers.isEmpty())) {
        sb.append("transformers:");
        sb.append(transformers);
        sb.append(",");
    }
    if (!(validators == null) && !(validators.isEmpty())) {
        sb.append("validators:");
        sb.append(validators);
        sb.append(",");
    }
    if (!(vars == null) && !(vars.isEmpty())) {
        sb.append("vars:");
        sb.append(vars);
        sb.append(",");
    }
    if (!(additionalProperties == null) && !(additionalProperties.isEmpty())) {
        sb.append("additionalProperties:");
        sb.append(additionalProperties);
    }
    sb.append("}");
    return sb.toString();
  }
  
  public <K,V>A withAdditionalProperties(Map<String,Object> additionalProperties) {
    if (additionalProperties == null) {
      this.additionalProperties = null;
    } else {
      this.additionalProperties = new LinkedHashMap(additionalProperties);
    }
    return (A) this;
  }
  
  public A withApiVersion(String apiVersion) {
    this.apiVersion = apiVersion;
    return (A) this;
  }
  
  public A withBases(List<String> bases) {
    if (bases != null) {
        this.bases = new ArrayList();
        for (String item : bases) {
          this.addToBases(item);
        }
    } else {
      this.bases = null;
    }
    return (A) this;
  }
  
  public A withBases(String... bases) {
    if (this.bases != null) {
        this.bases.clear();
        _visitables.remove("bases");
    }
    if (bases != null) {
      for (String item : bases) {
        this.addToBases(item);
      }
    }
    return (A) this;
  }
  
  public A withBuildMetadata(List<String> buildMetadata) {
    if (buildMetadata != null) {
        this.buildMetadata = new ArrayList();
        for (String item : buildMetadata) {
          this.addToBuildMetadata(item);
        }
    } else {
      this.buildMetadata = null;
    }
    return (A) this;
  }
  
  public A withBuildMetadata(String... buildMetadata) {
    if (this.buildMetadata != null) {
        this.buildMetadata.clear();
        _visitables.remove("buildMetadata");
    }
    if (buildMetadata != null) {
      for (String item : buildMetadata) {
        this.addToBuildMetadata(item);
      }
    }
    return (A) this;
  }
  
  public <K,V>A withCommonAnnotations(Map<String,String> commonAnnotations) {
    if (commonAnnotations == null) {
      this.commonAnnotations = null;
    } else {
      this.commonAnnotations = new LinkedHashMap(commonAnnotations);
    }
    return (A) this;
  }
  
  public <K,V>A withCommonLabels(Map<String,String> commonLabels) {
    if (commonLabels == null) {
      this.commonLabels = null;
    } else {
      this.commonLabels = new LinkedHashMap(commonLabels);
    }
    return (A) this;
  }
  
  public A withComponents(List<String> components) {
    if (components != null) {
        this.components = new ArrayList();
        for (String item : components) {
          this.addToComponents(item);
        }
    } else {
      this.components = null;
    }
    return (A) this;
  }
  
  public A withComponents(String... components) {
    if (this.components != null) {
        this.components.clear();
        _visitables.remove("components");
    }
    if (components != null) {
      for (String item : components) {
        this.addToComponents(item);
      }
    }
    return (A) this;
  }
  
  public A withConfigMapGenerator(List<ConfigMapArgs> configMapGenerator) {
    if (this.configMapGenerator != null) {
      this._visitables.get("configMapGenerator").clear();
    }
    if (configMapGenerator != null) {
        this.configMapGenerator = new ArrayList();
        for (ConfigMapArgs item : configMapGenerator) {
          this.addToConfigMapGenerator(item);
        }
    } else {
      this.configMapGenerator = null;
    }
    return (A) this;
  }
  
  public A withConfigMapGenerator(ConfigMapArgs... configMapGenerator) {
    if (this.configMapGenerator != null) {
        this.configMapGenerator.clear();
        _visitables.remove("configMapGenerator");
    }
    if (configMapGenerator != null) {
      for (ConfigMapArgs item : configMapGenerator) {
        this.addToConfigMapGenerator(item);
      }
    }
    return (A) this;
  }
  
  public A withConfigurations(List<String> configurations) {
    if (configurations != null) {
        this.configurations = new ArrayList();
        for (String item : configurations) {
          this.addToConfigurations(item);
        }
    } else {
      this.configurations = null;
    }
    return (A) this;
  }
  
  public A withConfigurations(String... configurations) {
    if (this.configurations != null) {
        this.configurations.clear();
        _visitables.remove("configurations");
    }
    if (configurations != null) {
      for (String item : configurations) {
        this.addToConfigurations(item);
      }
    }
    return (A) this;
  }
  
  public A withCrds(List<String> crds) {
    if (crds != null) {
        this.crds = new ArrayList();
        for (String item : crds) {
          this.addToCrds(item);
        }
    } else {
      this.crds = null;
    }
    return (A) this;
  }
  
  public A withCrds(String... crds) {
    if (this.crds != null) {
        this.crds.clear();
        _visitables.remove("crds");
    }
    if (crds != null) {
      for (String item : crds) {
        this.addToCrds(item);
      }
    }
    return (A) this;
  }
  
  public A withGeneratorOptions(GeneratorOptions generatorOptions) {
    this._visitables.remove("generatorOptions");
    if (generatorOptions != null) {
        this.generatorOptions = new GeneratorOptionsBuilder(generatorOptions);
        this._visitables.get("generatorOptions").add(this.generatorOptions);
    } else {
        this.generatorOptions = null;
        this._visitables.get("generatorOptions").remove(this.generatorOptions);
    }
    return (A) this;
  }
  
  public A withGenerators(List<String> generators) {
    if (generators != null) {
        this.generators = new ArrayList();
        for (String item : generators) {
          this.addToGenerators(item);
        }
    } else {
      this.generators = null;
    }
    return (A) this;
  }
  
  public A withGenerators(String... generators) {
    if (this.generators != null) {
        this.generators.clear();
        _visitables.remove("generators");
    }
    if (generators != null) {
      for (String item : generators) {
        this.addToGenerators(item);
      }
    }
    return (A) this;
  }
  
  public A withHelmChartInflationGenerator(List<HelmChartArgs> helmChartInflationGenerator) {
    if (this.helmChartInflationGenerator != null) {
      this._visitables.get("helmChartInflationGenerator").clear();
    }
    if (helmChartInflationGenerator != null) {
        this.helmChartInflationGenerator = new ArrayList();
        for (HelmChartArgs item : helmChartInflationGenerator) {
          this.addToHelmChartInflationGenerator(item);
        }
    } else {
      this.helmChartInflationGenerator = null;
    }
    return (A) this;
  }
  
  public A withHelmChartInflationGenerator(HelmChartArgs... helmChartInflationGenerator) {
    if (this.helmChartInflationGenerator != null) {
        this.helmChartInflationGenerator.clear();
        _visitables.remove("helmChartInflationGenerator");
    }
    if (helmChartInflationGenerator != null) {
      for (HelmChartArgs item : helmChartInflationGenerator) {
        this.addToHelmChartInflationGenerator(item);
      }
    }
    return (A) this;
  }
  
  public A withHelmCharts(List<HelmChart> helmCharts) {
    if (this.helmCharts != null) {
      this._visitables.get("helmCharts").clear();
    }
    if (helmCharts != null) {
        this.helmCharts = new ArrayList();
        for (HelmChart item : helmCharts) {
          this.addToHelmCharts(item);
        }
    } else {
      this.helmCharts = null;
    }
    return (A) this;
  }
  
  public A withHelmCharts(HelmChart... helmCharts) {
    if (this.helmCharts != null) {
        this.helmCharts.clear();
        _visitables.remove("helmCharts");
    }
    if (helmCharts != null) {
      for (HelmChart item : helmCharts) {
        this.addToHelmCharts(item);
      }
    }
    return (A) this;
  }
  
  public A withHelmGlobals(HelmGlobals helmGlobals) {
    this._visitables.remove("helmGlobals");
    if (helmGlobals != null) {
        this.helmGlobals = new HelmGlobalsBuilder(helmGlobals);
        this._visitables.get("helmGlobals").add(this.helmGlobals);
    } else {
        this.helmGlobals = null;
        this._visitables.get("helmGlobals").remove(this.helmGlobals);
    }
    return (A) this;
  }
  
  public A withImageTags(List<Image> imageTags) {
    if (this.imageTags != null) {
      this._visitables.get("imageTags").clear();
    }
    if (imageTags != null) {
        this.imageTags = new ArrayList();
        for (Image item : imageTags) {
          this.addToImageTags(item);
        }
    } else {
      this.imageTags = null;
    }
    return (A) this;
  }
  
  public A withImageTags(Image... imageTags) {
    if (this.imageTags != null) {
        this.imageTags.clear();
        _visitables.remove("imageTags");
    }
    if (imageTags != null) {
      for (Image item : imageTags) {
        this.addToImageTags(item);
      }
    }
    return (A) this;
  }
  
  public A withImages(List<Image> images) {
    if (this.images != null) {
      this._visitables.get("images").clear();
    }
    if (images != null) {
        this.images = new ArrayList();
        for (Image item : images) {
          this.addToImages(item);
        }
    } else {
      this.images = null;
    }
    return (A) this;
  }
  
  public A withImages(Image... images) {
    if (this.images != null) {
        this.images.clear();
        _visitables.remove("images");
    }
    if (images != null) {
      for (Image item : images) {
        this.addToImages(item);
      }
    }
    return (A) this;
  }
  
  public A withKind(String kind) {
    this.kind = kind;
    return (A) this;
  }
  
  public A withLabels(List<Label> labels) {
    if (this.labels != null) {
      this._visitables.get("labels").clear();
    }
    if (labels != null) {
        this.labels = new ArrayList();
        for (Label item : labels) {
          this.addToLabels(item);
        }
    } else {
      this.labels = null;
    }
    return (A) this;
  }
  
  public A withLabels(Label... labels) {
    if (this.labels != null) {
        this.labels.clear();
        _visitables.remove("labels");
    }
    if (labels != null) {
      for (Label item : labels) {
        this.addToLabels(item);
      }
    }
    return (A) this;
  }
  
  public A withMetadata(ObjectMeta metadata) {
    this._visitables.remove("metadata");
    if (metadata != null) {
        this.metadata = new ObjectMetaBuilder(metadata);
        this._visitables.get("metadata").add(this.metadata);
    } else {
        this.metadata = null;
        this._visitables.get("metadata").remove(this.metadata);
    }
    return (A) this;
  }
  
  public A withNamePrefix(String namePrefix) {
    this.namePrefix = namePrefix;
    return (A) this;
  }
  
  public A withNameSuffix(String nameSuffix) {
    this.nameSuffix = nameSuffix;
    return (A) this;
  }
  
  public A withNamespace(String namespace) {
    this.namespace = namespace;
    return (A) this;
  }
  
  public GeneratorOptionsNested<A> withNewGeneratorOptions() {
    return new GeneratorOptionsNested(null);
  }
  
  public GeneratorOptionsNested<A> withNewGeneratorOptionsLike(GeneratorOptions item) {
    return new GeneratorOptionsNested(item);
  }
  
  public HelmGlobalsNested<A> withNewHelmGlobals() {
    return new HelmGlobalsNested(null);
  }
  
  public A withNewHelmGlobals(String chartHome,String configHome) {
    return (A) this.withHelmGlobals(new HelmGlobals(chartHome, configHome));
  }
  
  public HelmGlobalsNested<A> withNewHelmGlobalsLike(HelmGlobals item) {
    return new HelmGlobalsNested(item);
  }
  
  public MetadataNested<A> withNewMetadata() {
    return new MetadataNested(null);
  }
  
  public MetadataNested<A> withNewMetadataLike(ObjectMeta item) {
    return new MetadataNested(item);
  }
  
  public SortOptionsNested<A> withNewSortOptions() {
    return new SortOptionsNested(null);
  }
  
  public SortOptionsNested<A> withNewSortOptionsLike(SortOptions item) {
    return new SortOptionsNested(item);
  }
  
  public <K,V>A withOpenapi(Map<String,String> openapi) {
    if (openapi == null) {
      this.openapi = null;
    } else {
      this.openapi = new LinkedHashMap(openapi);
    }
    return (A) this;
  }
  
  public A withPatches(List<Patch> patches) {
    if (this.patches != null) {
      this._visitables.get("patches").clear();
    }
    if (patches != null) {
        this.patches = new ArrayList();
        for (Patch item : patches) {
          this.addToPatches(item);
        }
    } else {
      this.patches = null;
    }
    return (A) this;
  }
  
  public A withPatches(Patch... patches) {
    if (this.patches != null) {
        this.patches.clear();
        _visitables.remove("patches");
    }
    if (patches != null) {
      for (Patch item : patches) {
        this.addToPatches(item);
      }
    }
    return (A) this;
  }
  
  public A withPatchesJson6902(List<Patch> patchesJson6902) {
    if (this.patchesJson6902 != null) {
      this._visitables.get("patchesJson6902").clear();
    }
    if (patchesJson6902 != null) {
        this.patchesJson6902 = new ArrayList();
        for (Patch item : patchesJson6902) {
          this.addToPatchesJson6902(item);
        }
    } else {
      this.patchesJson6902 = null;
    }
    return (A) this;
  }
  
  public A withPatchesJson6902(Patch... patchesJson6902) {
    if (this.patchesJson6902 != null) {
        this.patchesJson6902.clear();
        _visitables.remove("patchesJson6902");
    }
    if (patchesJson6902 != null) {
      for (Patch item : patchesJson6902) {
        this.addToPatchesJson6902(item);
      }
    }
    return (A) this;
  }
  
  public A withPatchesStrategicMerge(List<String> patchesStrategicMerge) {
    if (patchesStrategicMerge != null) {
        this.patchesStrategicMerge = new ArrayList();
        for (String item : patchesStrategicMerge) {
          this.addToPatchesStrategicMerge(item);
        }
    } else {
      this.patchesStrategicMerge = null;
    }
    return (A) this;
  }
  
  public A withPatchesStrategicMerge(String... patchesStrategicMerge) {
    if (this.patchesStrategicMerge != null) {
        this.patchesStrategicMerge.clear();
        _visitables.remove("patchesStrategicMerge");
    }
    if (patchesStrategicMerge != null) {
      for (String item : patchesStrategicMerge) {
        this.addToPatchesStrategicMerge(item);
      }
    }
    return (A) this;
  }
  
  public A withReplacements(List<ReplacementField> replacements) {
    if (this.replacements != null) {
      this._visitables.get("replacements").clear();
    }
    if (replacements != null) {
        this.replacements = new ArrayList();
        for (ReplacementField item : replacements) {
          this.addToReplacements(item);
        }
    } else {
      this.replacements = null;
    }
    return (A) this;
  }
  
  public A withReplacements(ReplacementField... replacements) {
    if (this.replacements != null) {
        this.replacements.clear();
        _visitables.remove("replacements");
    }
    if (replacements != null) {
      for (ReplacementField item : replacements) {
        this.addToReplacements(item);
      }
    }
    return (A) this;
  }
  
  public A withReplicas(List<Replica> replicas) {
    if (this.replicas != null) {
      this._visitables.get("replicas").clear();
    }
    if (replicas != null) {
        this.replicas = new ArrayList();
        for (Replica item : replicas) {
          this.addToReplicas(item);
        }
    } else {
      this.replicas = null;
    }
    return (A) this;
  }
  
  public A withReplicas(Replica... replicas) {
    if (this.replicas != null) {
        this.replicas.clear();
        _visitables.remove("replicas");
    }
    if (replicas != null) {
      for (Replica item : replicas) {
        this.addToReplicas(item);
      }
    }
    return (A) this;
  }
  
  public A withResources(List<String> resources) {
    if (resources != null) {
        this.resources = new ArrayList();
        for (String item : resources) {
          this.addToResources(item);
        }
    } else {
      this.resources = null;
    }
    return (A) this;
  }
  
  public A withResources(String... resources) {
    if (this.resources != null) {
        this.resources.clear();
        _visitables.remove("resources");
    }
    if (resources != null) {
      for (String item : resources) {
        this.addToResources(item);
      }
    }
    return (A) this;
  }
  
  public A withSecretGenerator(List<SecretArgs> secretGenerator) {
    if (this.secretGenerator != null) {
      this._visitables.get("secretGenerator").clear();
    }
    if (secretGenerator != null) {
        this.secretGenerator = new ArrayList();
        for (SecretArgs item : secretGenerator) {
          this.addToSecretGenerator(item);
        }
    } else {
      this.secretGenerator = null;
    }
    return (A) this;
  }
  
  public A withSecretGenerator(SecretArgs... secretGenerator) {
    if (this.secretGenerator != null) {
        this.secretGenerator.clear();
        _visitables.remove("secretGenerator");
    }
    if (secretGenerator != null) {
      for (SecretArgs item : secretGenerator) {
        this.addToSecretGenerator(item);
      }
    }
    return (A) this;
  }
  
  public A withSortOptions(SortOptions sortOptions) {
    this._visitables.remove("sortOptions");
    if (sortOptions != null) {
        this.sortOptions = new SortOptionsBuilder(sortOptions);
        this._visitables.get("sortOptions").add(this.sortOptions);
    } else {
        this.sortOptions = null;
        this._visitables.get("sortOptions").remove(this.sortOptions);
    }
    return (A) this;
  }
  
  public A withTransformers(List<String> transformers) {
    if (transformers != null) {
        this.transformers = new ArrayList();
        for (String item : transformers) {
          this.addToTransformers(item);
        }
    } else {
      this.transformers = null;
    }
    return (A) this;
  }
  
  public A withTransformers(String... transformers) {
    if (this.transformers != null) {
        this.transformers.clear();
        _visitables.remove("transformers");
    }
    if (transformers != null) {
      for (String item : transformers) {
        this.addToTransformers(item);
      }
    }
    return (A) this;
  }
  
  public A withValidators(List<String> validators) {
    if (validators != null) {
        this.validators = new ArrayList();
        for (String item : validators) {
          this.addToValidators(item);
        }
    } else {
      this.validators = null;
    }
    return (A) this;
  }
  
  public A withValidators(String... validators) {
    if (this.validators != null) {
        this.validators.clear();
        _visitables.remove("validators");
    }
    if (validators != null) {
      for (String item : validators) {
        this.addToValidators(item);
      }
    }
    return (A) this;
  }
  
  public A withVars(List<Var> vars) {
    if (this.vars != null) {
      this._visitables.get("vars").clear();
    }
    if (vars != null) {
        this.vars = new ArrayList();
        for (Var item : vars) {
          this.addToVars(item);
        }
    } else {
      this.vars = null;
    }
    return (A) this;
  }
  
  public A withVars(Var... vars) {
    if (this.vars != null) {
        this.vars.clear();
        _visitables.remove("vars");
    }
    if (vars != null) {
      for (Var item : vars) {
        this.addToVars(item);
      }
    }
    return (A) this;
  }
  public class ConfigMapGeneratorNested<N> extends ConfigMapArgsFluent<ConfigMapGeneratorNested<N>> implements Nested<N>{
  
    ConfigMapArgsBuilder builder;
    int index;
  
    ConfigMapGeneratorNested(int index,ConfigMapArgs item) {
      this.index = index;
      this.builder = new ConfigMapArgsBuilder(this, item);
    }
  
    public N and() {
      return (N) KustomizationFluent.this.setToConfigMapGenerator(index, builder.build());
    }
    
    public N endConfigMapGenerator() {
      return and();
    }
    
  }
  public class GeneratorOptionsNested<N> extends GeneratorOptionsFluent<GeneratorOptionsNested<N>> implements Nested<N>{
  
    GeneratorOptionsBuilder builder;
  
    GeneratorOptionsNested(GeneratorOptions item) {
      this.builder = new GeneratorOptionsBuilder(this, item);
    }
  
    public N and() {
      return (N) KustomizationFluent.this.withGeneratorOptions(builder.build());
    }
    
    public N endGeneratorOptions() {
      return and();
    }
    
  }
  public class HelmChartInflationGeneratorNested<N> extends HelmChartArgsFluent<HelmChartInflationGeneratorNested<N>> implements Nested<N>{
  
    HelmChartArgsBuilder builder;
    int index;
  
    HelmChartInflationGeneratorNested(int index,HelmChartArgs item) {
      this.index = index;
      this.builder = new HelmChartArgsBuilder(this, item);
    }
  
    public N and() {
      return (N) KustomizationFluent.this.setToHelmChartInflationGenerator(index, builder.build());
    }
    
    public N endHelmChartInflationGenerator() {
      return and();
    }
    
  }
  public class HelmChartsNested<N> extends HelmChartFluent<HelmChartsNested<N>> implements Nested<N>{
  
    HelmChartBuilder builder;
    int index;
  
    HelmChartsNested(int index,HelmChart item) {
      this.index = index;
      this.builder = new HelmChartBuilder(this, item);
    }
  
    public N and() {
      return (N) KustomizationFluent.this.setToHelmCharts(index, builder.build());
    }
    
    public N endHelmChart() {
      return and();
    }
    
  }
  public class HelmGlobalsNested<N> extends HelmGlobalsFluent<HelmGlobalsNested<N>> implements Nested<N>{
  
    HelmGlobalsBuilder builder;
  
    HelmGlobalsNested(HelmGlobals item) {
      this.builder = new HelmGlobalsBuilder(this, item);
    }
  
    public N and() {
      return (N) KustomizationFluent.this.withHelmGlobals(builder.build());
    }
    
    public N endHelmGlobals() {
      return and();
    }
    
  }
  public class ImageTagsNested<N> extends ImageFluent<ImageTagsNested<N>> implements Nested<N>{
  
    ImageBuilder builder;
    int index;
  
    ImageTagsNested(int index,Image item) {
      this.index = index;
      this.builder = new ImageBuilder(this, item);
    }
  
    public N and() {
      return (N) KustomizationFluent.this.setToImageTags(index, builder.build());
    }
    
    public N endImageTag() {
      return and();
    }
    
  }
  public class ImagesNested<N> extends ImageFluent<ImagesNested<N>> implements Nested<N>{
  
    ImageBuilder builder;
    int index;
  
    ImagesNested(int index,Image item) {
      this.index = index;
      this.builder = new ImageBuilder(this, item);
    }
  
    public N and() {
      return (N) KustomizationFluent.this.setToImages(index, builder.build());
    }
    
    public N endImage() {
      return and();
    }
    
  }
  public class LabelsNested<N> extends LabelFluent<LabelsNested<N>> implements Nested<N>{
  
    LabelBuilder builder;
    int index;
  
    LabelsNested(int index,Label item) {
      this.index = index;
      this.builder = new LabelBuilder(this, item);
    }
  
    public N and() {
      return (N) KustomizationFluent.this.setToLabels(index, builder.build());
    }
    
    public N endLabel() {
      return and();
    }
    
  }
  public class MetadataNested<N> extends ObjectMetaFluent<MetadataNested<N>> implements Nested<N>{
  
    ObjectMetaBuilder builder;
  
    MetadataNested(ObjectMeta item) {
      this.builder = new ObjectMetaBuilder(this, item);
    }
  
    public N and() {
      return (N) KustomizationFluent.this.withMetadata(builder.build());
    }
    
    public N endMetadata() {
      return and();
    }
    
  }
  public class PatchesJson6902Nested<N> extends PatchFluent<PatchesJson6902Nested<N>> implements Nested<N>{
  
    PatchBuilder builder;
    int index;
  
    PatchesJson6902Nested(int index,Patch item) {
      this.index = index;
      this.builder = new PatchBuilder(this, item);
    }
  
    public N and() {
      return (N) KustomizationFluent.this.setToPatchesJson6902(index, builder.build());
    }
    
    public N endPatchesJson6902() {
      return and();
    }
    
  }
  public class PatchesNested<N> extends PatchFluent<PatchesNested<N>> implements Nested<N>{
  
    PatchBuilder builder;
    int index;
  
    PatchesNested(int index,Patch item) {
      this.index = index;
      this.builder = new PatchBuilder(this, item);
    }
  
    public N and() {
      return (N) KustomizationFluent.this.setToPatches(index, builder.build());
    }
    
    public N endPatch() {
      return and();
    }
    
  }
  public class ReplacementsNested<N> extends ReplacementFieldFluent<ReplacementsNested<N>> implements Nested<N>{
  
    ReplacementFieldBuilder builder;
    int index;
  
    ReplacementsNested(int index,ReplacementField item) {
      this.index = index;
      this.builder = new ReplacementFieldBuilder(this, item);
    }
  
    public N and() {
      return (N) KustomizationFluent.this.setToReplacements(index, builder.build());
    }
    
    public N endReplacement() {
      return and();
    }
    
  }
  public class ReplicasNested<N> extends ReplicaFluent<ReplicasNested<N>> implements Nested<N>{
  
    ReplicaBuilder builder;
    int index;
  
    ReplicasNested(int index,Replica item) {
      this.index = index;
      this.builder = new ReplicaBuilder(this, item);
    }
  
    public N and() {
      return (N) KustomizationFluent.this.setToReplicas(index, builder.build());
    }
    
    public N endReplica() {
      return and();
    }
    
  }
  public class SecretGeneratorNested<N> extends SecretArgsFluent<SecretGeneratorNested<N>> implements Nested<N>{
  
    SecretArgsBuilder builder;
    int index;
  
    SecretGeneratorNested(int index,SecretArgs item) {
      this.index = index;
      this.builder = new SecretArgsBuilder(this, item);
    }
  
    public N and() {
      return (N) KustomizationFluent.this.setToSecretGenerator(index, builder.build());
    }
    
    public N endSecretGenerator() {
      return and();
    }
    
  }
  public class SortOptionsNested<N> extends SortOptionsFluent<SortOptionsNested<N>> implements Nested<N>{
  
    SortOptionsBuilder builder;
  
    SortOptionsNested(SortOptions item) {
      this.builder = new SortOptionsBuilder(this, item);
    }
  
    public N and() {
      return (N) KustomizationFluent.this.withSortOptions(builder.build());
    }
    
    public N endSortOptions() {
      return and();
    }
    
  }
  public class VarsNested<N> extends VarFluent<VarsNested<N>> implements Nested<N>{
  
    VarBuilder builder;
    int index;
  
    VarsNested(int index,Var item) {
      this.index = index;
      this.builder = new VarBuilder(this, item);
    }
  
    public N and() {
      return (N) KustomizationFluent.this.setToVars(index, builder.build());
    }
    
    public N endVar() {
      return and();
    }
    
  }
}