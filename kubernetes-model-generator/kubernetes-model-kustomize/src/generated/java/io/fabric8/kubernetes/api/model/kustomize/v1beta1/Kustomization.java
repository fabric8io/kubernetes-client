
package io.fabric8.kubernetes.api.model.kustomize.v1beta1;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.processing.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.fabric8.kubernetes.api.builder.Editable;
import io.fabric8.kubernetes.api.model.Container;
import io.fabric8.kubernetes.api.model.ContainerPort;
import io.fabric8.kubernetes.api.model.EnvVar;
import io.fabric8.kubernetes.api.model.IntOrString;
import io.fabric8.kubernetes.api.model.KubernetesResource;
import io.fabric8.kubernetes.api.model.LabelSelector;
import io.fabric8.kubernetes.api.model.LocalObjectReference;
import io.fabric8.kubernetes.api.model.ObjectMeta;
import io.fabric8.kubernetes.api.model.ObjectReference;
import io.fabric8.kubernetes.api.model.PersistentVolumeClaim;
import io.fabric8.kubernetes.api.model.PodTemplateSpec;
import io.fabric8.kubernetes.api.model.ResourceRequirements;
import io.fabric8.kubernetes.api.model.Volume;
import io.fabric8.kubernetes.api.model.VolumeMount;
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "apiVersion",
    "kind",
    "metadata",
    "bases",
    "buildMetadata",
    "commonAnnotations",
    "commonLabels",
    "components",
    "configMapGenerator",
    "configurations",
    "crds",
    "generatorOptions",
    "generators",
    "helmChartInflationGenerator",
    "helmCharts",
    "helmGlobals",
    "imageTags",
    "images",
    "labels",
    "namePrefix",
    "nameSuffix",
    "namespace",
    "openapi",
    "patches",
    "patchesJson6902",
    "patchesStrategicMerge",
    "replacements",
    "replicas",
    "resources",
    "secretGenerator",
    "sortOptions",
    "transformers",
    "validators",
    "vars"
})
@ToString
@EqualsAndHashCode
@Accessors(prefix = {
    "_",
    ""
})
@Buildable(editableEnabled = false, validationEnabled = false, generateBuilderPackage = false, lazyCollectionInitEnabled = false, builderPackage = "io.fabric8.kubernetes.api.builder", refs = {
    @BuildableReference(ObjectMeta.class),
    @BuildableReference(LabelSelector.class),
    @BuildableReference(Container.class),
    @BuildableReference(PodTemplateSpec.class),
    @BuildableReference(ResourceRequirements.class),
    @BuildableReference(IntOrString.class),
    @BuildableReference(ObjectReference.class),
    @BuildableReference(LocalObjectReference.class),
    @BuildableReference(PersistentVolumeClaim.class),
    @BuildableReference(EnvVar.class),
    @BuildableReference(ContainerPort.class),
    @BuildableReference(Volume.class),
    @BuildableReference(VolumeMount.class)
})
@Generated("io.fabric8.kubernetes.schema.generator.model.ModelGenerator")
public class Kustomization implements Editable<KustomizationBuilder>, KubernetesResource
{

    @JsonProperty("apiVersion")
    private String apiVersion;
    @JsonProperty("bases")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> bases = new ArrayList<>();
    @JsonProperty("buildMetadata")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> buildMetadata = new ArrayList<>();
    @JsonProperty("commonAnnotations")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Map<String, String> commonAnnotations = new LinkedHashMap<>();
    @JsonProperty("commonLabels")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Map<String, String> commonLabels = new LinkedHashMap<>();
    @JsonProperty("components")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> components = new ArrayList<>();
    @JsonProperty("configMapGenerator")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<ConfigMapArgs> configMapGenerator = new ArrayList<>();
    @JsonProperty("configurations")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> configurations = new ArrayList<>();
    @JsonProperty("crds")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> crds = new ArrayList<>();
    @JsonProperty("generatorOptions")
    private GeneratorOptions generatorOptions;
    @JsonProperty("generators")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> generators = new ArrayList<>();
    @JsonProperty("helmChartInflationGenerator")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<HelmChartArgs> helmChartInflationGenerator = new ArrayList<>();
    @JsonProperty("helmCharts")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<HelmChart> helmCharts = new ArrayList<>();
    @JsonProperty("helmGlobals")
    private HelmGlobals helmGlobals;
    @JsonProperty("imageTags")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<Image> imageTags = new ArrayList<>();
    @JsonProperty("images")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<Image> images = new ArrayList<>();
    @JsonProperty("kind")
    private String kind;
    @JsonProperty("labels")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<Label> labels = new ArrayList<>();
    @JsonProperty("metadata")
    private ObjectMeta metadata;
    @JsonProperty("namePrefix")
    private String namePrefix;
    @JsonProperty("nameSuffix")
    private String nameSuffix;
    @JsonProperty("namespace")
    private String namespace;
    @JsonProperty("openapi")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Map<String, String> openapi = new LinkedHashMap<>();
    @JsonProperty("patches")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<Patch> patches = new ArrayList<>();
    @JsonProperty("patchesJson6902")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<Patch> patchesJson6902 = new ArrayList<>();
    @JsonProperty("patchesStrategicMerge")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> patchesStrategicMerge = new ArrayList<>();
    @JsonProperty("replacements")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<ReplacementField> replacements = new ArrayList<>();
    @JsonProperty("replicas")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<Replica> replicas = new ArrayList<>();
    @JsonProperty("resources")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> resources = new ArrayList<>();
    @JsonProperty("secretGenerator")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<SecretArgs> secretGenerator = new ArrayList<>();
    @JsonProperty("sortOptions")
    private SortOptions sortOptions;
    @JsonProperty("transformers")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> transformers = new ArrayList<>();
    @JsonProperty("validators")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> validators = new ArrayList<>();
    @JsonProperty("vars")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<Var> vars = new ArrayList<>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public Kustomization() {
    }

    public Kustomization(String apiVersion, List<String> bases, List<String> buildMetadata, Map<String, String> commonAnnotations, Map<String, String> commonLabels, List<String> components, List<ConfigMapArgs> configMapGenerator, List<String> configurations, List<String> crds, GeneratorOptions generatorOptions, List<String> generators, List<HelmChartArgs> helmChartInflationGenerator, List<HelmChart> helmCharts, HelmGlobals helmGlobals, List<Image> imageTags, List<Image> images, String kind, List<Label> labels, ObjectMeta metadata, String namePrefix, String nameSuffix, String namespace, Map<String, String> openapi, List<Patch> patches, List<Patch> patchesJson6902, List<String> patchesStrategicMerge, List<ReplacementField> replacements, List<Replica> replicas, List<String> resources, List<SecretArgs> secretGenerator, SortOptions sortOptions, List<String> transformers, List<String> validators, List<Var> vars) {
        super();
        this.apiVersion = apiVersion;
        this.bases = bases;
        this.buildMetadata = buildMetadata;
        this.commonAnnotations = commonAnnotations;
        this.commonLabels = commonLabels;
        this.components = components;
        this.configMapGenerator = configMapGenerator;
        this.configurations = configurations;
        this.crds = crds;
        this.generatorOptions = generatorOptions;
        this.generators = generators;
        this.helmChartInflationGenerator = helmChartInflationGenerator;
        this.helmCharts = helmCharts;
        this.helmGlobals = helmGlobals;
        this.imageTags = imageTags;
        this.images = images;
        this.kind = kind;
        this.labels = labels;
        this.metadata = metadata;
        this.namePrefix = namePrefix;
        this.nameSuffix = nameSuffix;
        this.namespace = namespace;
        this.openapi = openapi;
        this.patches = patches;
        this.patchesJson6902 = patchesJson6902;
        this.patchesStrategicMerge = patchesStrategicMerge;
        this.replacements = replacements;
        this.replicas = replicas;
        this.resources = resources;
        this.secretGenerator = secretGenerator;
        this.sortOptions = sortOptions;
        this.transformers = transformers;
        this.validators = validators;
        this.vars = vars;
    }

    @JsonProperty("apiVersion")
    public String getApiVersion() {
        return apiVersion;
    }

    @JsonProperty("apiVersion")
    public void setApiVersion(String apiVersion) {
        this.apiVersion = apiVersion;
    }

    @JsonProperty("bases")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getBases() {
        return bases;
    }

    @JsonProperty("bases")
    public void setBases(List<String> bases) {
        this.bases = bases;
    }

    @JsonProperty("buildMetadata")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getBuildMetadata() {
        return buildMetadata;
    }

    @JsonProperty("buildMetadata")
    public void setBuildMetadata(List<String> buildMetadata) {
        this.buildMetadata = buildMetadata;
    }

    @JsonProperty("commonAnnotations")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public Map<String, String> getCommonAnnotations() {
        return commonAnnotations;
    }

    @JsonProperty("commonAnnotations")
    public void setCommonAnnotations(Map<String, String> commonAnnotations) {
        this.commonAnnotations = commonAnnotations;
    }

    @JsonProperty("commonLabels")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public Map<String, String> getCommonLabels() {
        return commonLabels;
    }

    @JsonProperty("commonLabels")
    public void setCommonLabels(Map<String, String> commonLabels) {
        this.commonLabels = commonLabels;
    }

    @JsonProperty("components")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getComponents() {
        return components;
    }

    @JsonProperty("components")
    public void setComponents(List<String> components) {
        this.components = components;
    }

    @JsonProperty("configMapGenerator")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<ConfigMapArgs> getConfigMapGenerator() {
        return configMapGenerator;
    }

    @JsonProperty("configMapGenerator")
    public void setConfigMapGenerator(List<ConfigMapArgs> configMapGenerator) {
        this.configMapGenerator = configMapGenerator;
    }

    @JsonProperty("configurations")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getConfigurations() {
        return configurations;
    }

    @JsonProperty("configurations")
    public void setConfigurations(List<String> configurations) {
        this.configurations = configurations;
    }

    @JsonProperty("crds")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getCrds() {
        return crds;
    }

    @JsonProperty("crds")
    public void setCrds(List<String> crds) {
        this.crds = crds;
    }

    @JsonProperty("generatorOptions")
    public GeneratorOptions getGeneratorOptions() {
        return generatorOptions;
    }

    @JsonProperty("generatorOptions")
    public void setGeneratorOptions(GeneratorOptions generatorOptions) {
        this.generatorOptions = generatorOptions;
    }

    @JsonProperty("generators")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getGenerators() {
        return generators;
    }

    @JsonProperty("generators")
    public void setGenerators(List<String> generators) {
        this.generators = generators;
    }

    @JsonProperty("helmChartInflationGenerator")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<HelmChartArgs> getHelmChartInflationGenerator() {
        return helmChartInflationGenerator;
    }

    @JsonProperty("helmChartInflationGenerator")
    public void setHelmChartInflationGenerator(List<HelmChartArgs> helmChartInflationGenerator) {
        this.helmChartInflationGenerator = helmChartInflationGenerator;
    }

    @JsonProperty("helmCharts")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<HelmChart> getHelmCharts() {
        return helmCharts;
    }

    @JsonProperty("helmCharts")
    public void setHelmCharts(List<HelmChart> helmCharts) {
        this.helmCharts = helmCharts;
    }

    @JsonProperty("helmGlobals")
    public HelmGlobals getHelmGlobals() {
        return helmGlobals;
    }

    @JsonProperty("helmGlobals")
    public void setHelmGlobals(HelmGlobals helmGlobals) {
        this.helmGlobals = helmGlobals;
    }

    @JsonProperty("imageTags")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<Image> getImageTags() {
        return imageTags;
    }

    @JsonProperty("imageTags")
    public void setImageTags(List<Image> imageTags) {
        this.imageTags = imageTags;
    }

    @JsonProperty("images")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<Image> getImages() {
        return images;
    }

    @JsonProperty("images")
    public void setImages(List<Image> images) {
        this.images = images;
    }

    @JsonProperty("kind")
    public String getKind() {
        return kind;
    }

    @JsonProperty("kind")
    public void setKind(String kind) {
        this.kind = kind;
    }

    @JsonProperty("labels")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<Label> getLabels() {
        return labels;
    }

    @JsonProperty("labels")
    public void setLabels(List<Label> labels) {
        this.labels = labels;
    }

    @JsonProperty("metadata")
    public ObjectMeta getMetadata() {
        return metadata;
    }

    @JsonProperty("metadata")
    public void setMetadata(ObjectMeta metadata) {
        this.metadata = metadata;
    }

    @JsonProperty("namePrefix")
    public String getNamePrefix() {
        return namePrefix;
    }

    @JsonProperty("namePrefix")
    public void setNamePrefix(String namePrefix) {
        this.namePrefix = namePrefix;
    }

    @JsonProperty("nameSuffix")
    public String getNameSuffix() {
        return nameSuffix;
    }

    @JsonProperty("nameSuffix")
    public void setNameSuffix(String nameSuffix) {
        this.nameSuffix = nameSuffix;
    }

    @JsonProperty("namespace")
    public String getNamespace() {
        return namespace;
    }

    @JsonProperty("namespace")
    public void setNamespace(String namespace) {
        this.namespace = namespace;
    }

    @JsonProperty("openapi")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public Map<String, String> getOpenapi() {
        return openapi;
    }

    @JsonProperty("openapi")
    public void setOpenapi(Map<String, String> openapi) {
        this.openapi = openapi;
    }

    @JsonProperty("patches")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<Patch> getPatches() {
        return patches;
    }

    @JsonProperty("patches")
    public void setPatches(List<Patch> patches) {
        this.patches = patches;
    }

    @JsonProperty("patchesJson6902")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<Patch> getPatchesJson6902() {
        return patchesJson6902;
    }

    @JsonProperty("patchesJson6902")
    public void setPatchesJson6902(List<Patch> patchesJson6902) {
        this.patchesJson6902 = patchesJson6902;
    }

    @JsonProperty("patchesStrategicMerge")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getPatchesStrategicMerge() {
        return patchesStrategicMerge;
    }

    @JsonProperty("patchesStrategicMerge")
    public void setPatchesStrategicMerge(List<String> patchesStrategicMerge) {
        this.patchesStrategicMerge = patchesStrategicMerge;
    }

    @JsonProperty("replacements")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<ReplacementField> getReplacements() {
        return replacements;
    }

    @JsonProperty("replacements")
    public void setReplacements(List<ReplacementField> replacements) {
        this.replacements = replacements;
    }

    @JsonProperty("replicas")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<Replica> getReplicas() {
        return replicas;
    }

    @JsonProperty("replicas")
    public void setReplicas(List<Replica> replicas) {
        this.replicas = replicas;
    }

    @JsonProperty("resources")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getResources() {
        return resources;
    }

    @JsonProperty("resources")
    public void setResources(List<String> resources) {
        this.resources = resources;
    }

    @JsonProperty("secretGenerator")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<SecretArgs> getSecretGenerator() {
        return secretGenerator;
    }

    @JsonProperty("secretGenerator")
    public void setSecretGenerator(List<SecretArgs> secretGenerator) {
        this.secretGenerator = secretGenerator;
    }

    @JsonProperty("sortOptions")
    public SortOptions getSortOptions() {
        return sortOptions;
    }

    @JsonProperty("sortOptions")
    public void setSortOptions(SortOptions sortOptions) {
        this.sortOptions = sortOptions;
    }

    @JsonProperty("transformers")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getTransformers() {
        return transformers;
    }

    @JsonProperty("transformers")
    public void setTransformers(List<String> transformers) {
        this.transformers = transformers;
    }

    @JsonProperty("validators")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getValidators() {
        return validators;
    }

    @JsonProperty("validators")
    public void setValidators(List<String> validators) {
        this.validators = validators;
    }

    @JsonProperty("vars")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<Var> getVars() {
        return vars;
    }

    @JsonProperty("vars")
    public void setVars(List<Var> vars) {
        this.vars = vars;
    }

    @JsonIgnore
    public KustomizationBuilder edit() {
        return new KustomizationBuilder(this);
    }

    @JsonIgnore
    public KustomizationBuilder toBuilder() {
        return edit();
    }

    @JsonAnyGetter
    @JsonIgnore
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    public void setAdditionalProperties(Map<String, Object> additionalProperties) {
        this.additionalProperties = additionalProperties;
    }

}
