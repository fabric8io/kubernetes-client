
package io.fabric8.kubernetes.api.model.kustomize.v1beta1;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.fabric8.kubernetes.api.model.KubernetesResource;
import io.sundr.builder.annotations.Buildable;
import lombok.EqualsAndHashCode;
import lombok.Setter;
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
@Setter
@Accessors(prefix = {
    "_",
    ""
})
@Buildable(editableEnabled = false, validationEnabled = false, generateBuilderPackage = true, lazyCollectionInitEnabled = false, builderPackage = "io.fabric8.kubernetes.api.builder")
@Generated("jsonschema2pojo")
public class Kustomization implements KubernetesResource
{

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("apiVersion")
    private java.lang.String apiVersion;
    @JsonProperty("bases")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<java.lang.String> bases = new ArrayList<java.lang.String>();
    @JsonProperty("buildMetadata")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<java.lang.String> buildMetadata = new ArrayList<java.lang.String>();
    @JsonProperty("commonAnnotations")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Map<String, String> commonAnnotations = new LinkedHashMap<String, String>();
    @JsonProperty("commonLabels")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Map<String, String> commonLabels = new LinkedHashMap<String, String>();
    @JsonProperty("components")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<java.lang.String> components = new ArrayList<java.lang.String>();
    @JsonProperty("configMapGenerator")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<ConfigMapArgs> configMapGenerator = new ArrayList<ConfigMapArgs>();
    @JsonProperty("configurations")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<java.lang.String> configurations = new ArrayList<java.lang.String>();
    @JsonProperty("crds")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<java.lang.String> crds = new ArrayList<java.lang.String>();
    @JsonProperty("generatorOptions")
    private GeneratorOptions generatorOptions;
    @JsonProperty("generators")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<java.lang.String> generators = new ArrayList<java.lang.String>();
    @JsonProperty("helmChartInflationGenerator")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<HelmChartArgs> helmChartInflationGenerator = new ArrayList<HelmChartArgs>();
    @JsonProperty("helmCharts")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<HelmChart> helmCharts = new ArrayList<HelmChart>();
    @JsonProperty("helmGlobals")
    private HelmGlobals helmGlobals;
    @JsonProperty("imageTags")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<Image> imageTags = new ArrayList<Image>();
    @JsonProperty("images")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<Image> images = new ArrayList<Image>();
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("kind")
    private java.lang.String kind = "Kustomization";
    @JsonProperty("labels")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<Label> labels = new ArrayList<Label>();
    @JsonProperty("metadata")
    private ObjectMeta metadata;
    @JsonProperty("namePrefix")
    private java.lang.String namePrefix;
    @JsonProperty("nameSuffix")
    private java.lang.String nameSuffix;
    @JsonProperty("namespace")
    private java.lang.String namespace;
    @JsonProperty("openapi")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Map<String, String> openapi = new LinkedHashMap<String, String>();
    @JsonProperty("patches")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<Patch> patches = new ArrayList<Patch>();
    @JsonProperty("patchesJson6902")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<Patch> patchesJson6902 = new ArrayList<Patch>();
    @JsonProperty("patchesStrategicMerge")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<java.lang.String> patchesStrategicMerge = new ArrayList<java.lang.String>();
    @JsonProperty("replacements")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<ReplacementField> replacements = new ArrayList<ReplacementField>();
    @JsonProperty("replicas")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<Replica> replicas = new ArrayList<Replica>();
    @JsonProperty("resources")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<java.lang.String> resources = new ArrayList<java.lang.String>();
    @JsonProperty("secretGenerator")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<SecretArgs> secretGenerator = new ArrayList<SecretArgs>();
    @JsonProperty("sortOptions")
    private SortOptions sortOptions;
    @JsonProperty("transformers")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<java.lang.String> transformers = new ArrayList<java.lang.String>();
    @JsonProperty("validators")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<java.lang.String> validators = new ArrayList<java.lang.String>();
    @JsonProperty("vars")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<Var> vars = new ArrayList<Var>();
    @JsonIgnore
    private Map<java.lang.String, Object> additionalProperties = new LinkedHashMap<java.lang.String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public Kustomization() {
    }

    public Kustomization(java.lang.String apiVersion, List<java.lang.String> bases, List<java.lang.String> buildMetadata, Map<String, String> commonAnnotations, Map<String, String> commonLabels, List<java.lang.String> components, List<ConfigMapArgs> configMapGenerator, List<java.lang.String> configurations, List<java.lang.String> crds, GeneratorOptions generatorOptions, List<java.lang.String> generators, List<HelmChartArgs> helmChartInflationGenerator, List<HelmChart> helmCharts, HelmGlobals helmGlobals, List<Image> imageTags, List<Image> images, java.lang.String kind, List<Label> labels, ObjectMeta metadata, java.lang.String namePrefix, java.lang.String nameSuffix, java.lang.String namespace, Map<String, String> openapi, List<Patch> patches, List<Patch> patchesJson6902, List<java.lang.String> patchesStrategicMerge, List<ReplacementField> replacements, List<Replica> replicas, List<java.lang.String> resources, List<SecretArgs> secretGenerator, SortOptions sortOptions, List<java.lang.String> transformers, List<java.lang.String> validators, List<Var> vars) {
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

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("apiVersion")
    public java.lang.String getApiVersion() {
        return apiVersion;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("apiVersion")
    public void setApiVersion(java.lang.String apiVersion) {
        this.apiVersion = apiVersion;
    }

    @JsonProperty("bases")
    public List<java.lang.String> getBases() {
        return bases;
    }

    @JsonProperty("bases")
    public void setBases(List<java.lang.String> bases) {
        this.bases = bases;
    }

    @JsonProperty("buildMetadata")
    public List<java.lang.String> getBuildMetadata() {
        return buildMetadata;
    }

    @JsonProperty("buildMetadata")
    public void setBuildMetadata(List<java.lang.String> buildMetadata) {
        this.buildMetadata = buildMetadata;
    }

    @JsonProperty("commonAnnotations")
    public Map<String, String> getCommonAnnotations() {
        return commonAnnotations;
    }

    @JsonProperty("commonAnnotations")
    public void setCommonAnnotations(Map<String, String> commonAnnotations) {
        this.commonAnnotations = commonAnnotations;
    }

    @JsonProperty("commonLabels")
    public Map<String, String> getCommonLabels() {
        return commonLabels;
    }

    @JsonProperty("commonLabels")
    public void setCommonLabels(Map<String, String> commonLabels) {
        this.commonLabels = commonLabels;
    }

    @JsonProperty("components")
    public List<java.lang.String> getComponents() {
        return components;
    }

    @JsonProperty("components")
    public void setComponents(List<java.lang.String> components) {
        this.components = components;
    }

    @JsonProperty("configMapGenerator")
    public List<ConfigMapArgs> getConfigMapGenerator() {
        return configMapGenerator;
    }

    @JsonProperty("configMapGenerator")
    public void setConfigMapGenerator(List<ConfigMapArgs> configMapGenerator) {
        this.configMapGenerator = configMapGenerator;
    }

    @JsonProperty("configurations")
    public List<java.lang.String> getConfigurations() {
        return configurations;
    }

    @JsonProperty("configurations")
    public void setConfigurations(List<java.lang.String> configurations) {
        this.configurations = configurations;
    }

    @JsonProperty("crds")
    public List<java.lang.String> getCrds() {
        return crds;
    }

    @JsonProperty("crds")
    public void setCrds(List<java.lang.String> crds) {
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
    public List<java.lang.String> getGenerators() {
        return generators;
    }

    @JsonProperty("generators")
    public void setGenerators(List<java.lang.String> generators) {
        this.generators = generators;
    }

    @JsonProperty("helmChartInflationGenerator")
    public List<HelmChartArgs> getHelmChartInflationGenerator() {
        return helmChartInflationGenerator;
    }

    @JsonProperty("helmChartInflationGenerator")
    public void setHelmChartInflationGenerator(List<HelmChartArgs> helmChartInflationGenerator) {
        this.helmChartInflationGenerator = helmChartInflationGenerator;
    }

    @JsonProperty("helmCharts")
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
    public List<Image> getImageTags() {
        return imageTags;
    }

    @JsonProperty("imageTags")
    public void setImageTags(List<Image> imageTags) {
        this.imageTags = imageTags;
    }

    @JsonProperty("images")
    public List<Image> getImages() {
        return images;
    }

    @JsonProperty("images")
    public void setImages(List<Image> images) {
        this.images = images;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("kind")
    public java.lang.String getKind() {
        return kind;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("kind")
    public void setKind(java.lang.String kind) {
        this.kind = kind;
    }

    @JsonProperty("labels")
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
    public java.lang.String getNamePrefix() {
        return namePrefix;
    }

    @JsonProperty("namePrefix")
    public void setNamePrefix(java.lang.String namePrefix) {
        this.namePrefix = namePrefix;
    }

    @JsonProperty("nameSuffix")
    public java.lang.String getNameSuffix() {
        return nameSuffix;
    }

    @JsonProperty("nameSuffix")
    public void setNameSuffix(java.lang.String nameSuffix) {
        this.nameSuffix = nameSuffix;
    }

    @JsonProperty("namespace")
    public java.lang.String getNamespace() {
        return namespace;
    }

    @JsonProperty("namespace")
    public void setNamespace(java.lang.String namespace) {
        this.namespace = namespace;
    }

    @JsonProperty("openapi")
    public Map<String, String> getOpenapi() {
        return openapi;
    }

    @JsonProperty("openapi")
    public void setOpenapi(Map<String, String> openapi) {
        this.openapi = openapi;
    }

    @JsonProperty("patches")
    public List<Patch> getPatches() {
        return patches;
    }

    @JsonProperty("patches")
    public void setPatches(List<Patch> patches) {
        this.patches = patches;
    }

    @JsonProperty("patchesJson6902")
    public List<Patch> getPatchesJson6902() {
        return patchesJson6902;
    }

    @JsonProperty("patchesJson6902")
    public void setPatchesJson6902(List<Patch> patchesJson6902) {
        this.patchesJson6902 = patchesJson6902;
    }

    @JsonProperty("patchesStrategicMerge")
    public List<java.lang.String> getPatchesStrategicMerge() {
        return patchesStrategicMerge;
    }

    @JsonProperty("patchesStrategicMerge")
    public void setPatchesStrategicMerge(List<java.lang.String> patchesStrategicMerge) {
        this.patchesStrategicMerge = patchesStrategicMerge;
    }

    @JsonProperty("replacements")
    public List<ReplacementField> getReplacements() {
        return replacements;
    }

    @JsonProperty("replacements")
    public void setReplacements(List<ReplacementField> replacements) {
        this.replacements = replacements;
    }

    @JsonProperty("replicas")
    public List<Replica> getReplicas() {
        return replicas;
    }

    @JsonProperty("replicas")
    public void setReplicas(List<Replica> replicas) {
        this.replicas = replicas;
    }

    @JsonProperty("resources")
    public List<java.lang.String> getResources() {
        return resources;
    }

    @JsonProperty("resources")
    public void setResources(List<java.lang.String> resources) {
        this.resources = resources;
    }

    @JsonProperty("secretGenerator")
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
    public List<java.lang.String> getTransformers() {
        return transformers;
    }

    @JsonProperty("transformers")
    public void setTransformers(List<java.lang.String> transformers) {
        this.transformers = transformers;
    }

    @JsonProperty("validators")
    public List<java.lang.String> getValidators() {
        return validators;
    }

    @JsonProperty("validators")
    public void setValidators(List<java.lang.String> validators) {
        this.validators = validators;
    }

    @JsonProperty("vars")
    public List<Var> getVars() {
        return vars;
    }

    @JsonProperty("vars")
    public void setVars(List<Var> vars) {
        this.vars = vars;
    }

    @JsonAnyGetter
    public Map<java.lang.String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(java.lang.String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
