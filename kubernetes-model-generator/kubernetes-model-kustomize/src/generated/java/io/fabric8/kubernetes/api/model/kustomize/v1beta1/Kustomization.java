
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
    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof Kustomization)) {
            return false;
        }
        Kustomization other = (Kustomization) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$apiVersion = this.getApiVersion();
        Object other$apiVersion = other.getApiVersion();
        if (this$apiVersion == null ? other$apiVersion != null : !this$apiVersion.equals(other$apiVersion)) {
            return false;
        }
        Object this$bases = this.getBases();
        Object other$bases = other.getBases();
        if (this$bases == null ? other$bases != null : !this$bases.equals(other$bases)) {
            return false;
        }
        Object this$buildMetadata = this.getBuildMetadata();
        Object other$buildMetadata = other.getBuildMetadata();
        if (this$buildMetadata == null ? other$buildMetadata != null : !this$buildMetadata.equals(other$buildMetadata)) {
            return false;
        }
        Object this$commonAnnotations = this.getCommonAnnotations();
        Object other$commonAnnotations = other.getCommonAnnotations();
        if (this$commonAnnotations == null ? other$commonAnnotations != null : !this$commonAnnotations.equals(other$commonAnnotations)) {
            return false;
        }
        Object this$commonLabels = this.getCommonLabels();
        Object other$commonLabels = other.getCommonLabels();
        if (this$commonLabels == null ? other$commonLabels != null : !this$commonLabels.equals(other$commonLabels)) {
            return false;
        }
        Object this$components = this.getComponents();
        Object other$components = other.getComponents();
        if (this$components == null ? other$components != null : !this$components.equals(other$components)) {
            return false;
        }
        Object this$configMapGenerator = this.getConfigMapGenerator();
        Object other$configMapGenerator = other.getConfigMapGenerator();
        if (this$configMapGenerator == null ? other$configMapGenerator != null : !this$configMapGenerator.equals(other$configMapGenerator)) {
            return false;
        }
        Object this$configurations = this.getConfigurations();
        Object other$configurations = other.getConfigurations();
        if (this$configurations == null ? other$configurations != null : !this$configurations.equals(other$configurations)) {
            return false;
        }
        Object this$crds = this.getCrds();
        Object other$crds = other.getCrds();
        if (this$crds == null ? other$crds != null : !this$crds.equals(other$crds)) {
            return false;
        }
        Object this$generatorOptions = this.getGeneratorOptions();
        Object other$generatorOptions = other.getGeneratorOptions();
        if (this$generatorOptions == null ? other$generatorOptions != null : !this$generatorOptions.equals(other$generatorOptions)) {
            return false;
        }
        Object this$generators = this.getGenerators();
        Object other$generators = other.getGenerators();
        if (this$generators == null ? other$generators != null : !this$generators.equals(other$generators)) {
            return false;
        }
        Object this$helmChartInflationGenerator = this.getHelmChartInflationGenerator();
        Object other$helmChartInflationGenerator = other.getHelmChartInflationGenerator();
        if (this$helmChartInflationGenerator == null ? other$helmChartInflationGenerator != null : !this$helmChartInflationGenerator.equals(other$helmChartInflationGenerator)) {
            return false;
        }
        Object this$helmCharts = this.getHelmCharts();
        Object other$helmCharts = other.getHelmCharts();
        if (this$helmCharts == null ? other$helmCharts != null : !this$helmCharts.equals(other$helmCharts)) {
            return false;
        }
        Object this$helmGlobals = this.getHelmGlobals();
        Object other$helmGlobals = other.getHelmGlobals();
        if (this$helmGlobals == null ? other$helmGlobals != null : !this$helmGlobals.equals(other$helmGlobals)) {
            return false;
        }
        Object this$imageTags = this.getImageTags();
        Object other$imageTags = other.getImageTags();
        if (this$imageTags == null ? other$imageTags != null : !this$imageTags.equals(other$imageTags)) {
            return false;
        }
        Object this$images = this.getImages();
        Object other$images = other.getImages();
        if (this$images == null ? other$images != null : !this$images.equals(other$images)) {
            return false;
        }
        Object this$kind = this.getKind();
        Object other$kind = other.getKind();
        if (this$kind == null ? other$kind != null : !this$kind.equals(other$kind)) {
            return false;
        }
        Object this$labels = this.getLabels();
        Object other$labels = other.getLabels();
        if (this$labels == null ? other$labels != null : !this$labels.equals(other$labels)) {
            return false;
        }
        Object this$metadata = this.getMetadata();
        Object other$metadata = other.getMetadata();
        if (this$metadata == null ? other$metadata != null : !this$metadata.equals(other$metadata)) {
            return false;
        }
        Object this$namePrefix = this.getNamePrefix();
        Object other$namePrefix = other.getNamePrefix();
        if (this$namePrefix == null ? other$namePrefix != null : !this$namePrefix.equals(other$namePrefix)) {
            return false;
        }
        Object this$nameSuffix = this.getNameSuffix();
        Object other$nameSuffix = other.getNameSuffix();
        if (this$nameSuffix == null ? other$nameSuffix != null : !this$nameSuffix.equals(other$nameSuffix)) {
            return false;
        }
        Object this$namespace = this.getNamespace();
        Object other$namespace = other.getNamespace();
        if (this$namespace == null ? other$namespace != null : !this$namespace.equals(other$namespace)) {
            return false;
        }
        Object this$openapi = this.getOpenapi();
        Object other$openapi = other.getOpenapi();
        if (this$openapi == null ? other$openapi != null : !this$openapi.equals(other$openapi)) {
            return false;
        }
        Object this$patches = this.getPatches();
        Object other$patches = other.getPatches();
        if (this$patches == null ? other$patches != null : !this$patches.equals(other$patches)) {
            return false;
        }
        Object this$patchesJson6902 = this.getPatchesJson6902();
        Object other$patchesJson6902 = other.getPatchesJson6902();
        if (this$patchesJson6902 == null ? other$patchesJson6902 != null : !this$patchesJson6902.equals(other$patchesJson6902)) {
            return false;
        }
        Object this$patchesStrategicMerge = this.getPatchesStrategicMerge();
        Object other$patchesStrategicMerge = other.getPatchesStrategicMerge();
        if (this$patchesStrategicMerge == null ? other$patchesStrategicMerge != null : !this$patchesStrategicMerge.equals(other$patchesStrategicMerge)) {
            return false;
        }
        Object this$replacements = this.getReplacements();
        Object other$replacements = other.getReplacements();
        if (this$replacements == null ? other$replacements != null : !this$replacements.equals(other$replacements)) {
            return false;
        }
        Object this$replicas = this.getReplicas();
        Object other$replicas = other.getReplicas();
        if (this$replicas == null ? other$replicas != null : !this$replicas.equals(other$replicas)) {
            return false;
        }
        Object this$resources = this.getResources();
        Object other$resources = other.getResources();
        if (this$resources == null ? other$resources != null : !this$resources.equals(other$resources)) {
            return false;
        }
        Object this$secretGenerator = this.getSecretGenerator();
        Object other$secretGenerator = other.getSecretGenerator();
        if (this$secretGenerator == null ? other$secretGenerator != null : !this$secretGenerator.equals(other$secretGenerator)) {
            return false;
        }
        Object this$sortOptions = this.getSortOptions();
        Object other$sortOptions = other.getSortOptions();
        if (this$sortOptions == null ? other$sortOptions != null : !this$sortOptions.equals(other$sortOptions)) {
            return false;
        }
        Object this$transformers = this.getTransformers();
        Object other$transformers = other.getTransformers();
        if (this$transformers == null ? other$transformers != null : !this$transformers.equals(other$transformers)) {
            return false;
        }
        Object this$validators = this.getValidators();
        Object other$validators = other.getValidators();
        if (this$validators == null ? other$validators != null : !this$validators.equals(other$validators)) {
            return false;
        }
        Object this$vars = this.getVars();
        Object other$vars = other.getVars();
        if (this$vars == null ? other$vars != null : !this$vars.equals(other$vars)) {
            return false;
        }
        Object this$additionalProperties = this.getAdditionalProperties();
        Object other$additionalProperties = other.getAdditionalProperties();
        if (this$additionalProperties == null ? other$additionalProperties != null : !this$additionalProperties.equals(other$additionalProperties)) {
            return false;
        }
        return true;
    }

    protected boolean canEqual(Object other) {
        return other instanceof Kustomization;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $apiVersion = this.getApiVersion();
        result = result * prime + ($apiVersion == null ? 43 : $apiVersion.hashCode());
        Object $bases = this.getBases();
        result = result * prime + ($bases == null ? 43 : $bases.hashCode());
        Object $buildMetadata = this.getBuildMetadata();
        result = result * prime + ($buildMetadata == null ? 43 : $buildMetadata.hashCode());
        Object $commonAnnotations = this.getCommonAnnotations();
        result = result * prime + ($commonAnnotations == null ? 43 : $commonAnnotations.hashCode());
        Object $commonLabels = this.getCommonLabels();
        result = result * prime + ($commonLabels == null ? 43 : $commonLabels.hashCode());
        Object $components = this.getComponents();
        result = result * prime + ($components == null ? 43 : $components.hashCode());
        Object $configMapGenerator = this.getConfigMapGenerator();
        result = result * prime + ($configMapGenerator == null ? 43 : $configMapGenerator.hashCode());
        Object $configurations = this.getConfigurations();
        result = result * prime + ($configurations == null ? 43 : $configurations.hashCode());
        Object $crds = this.getCrds();
        result = result * prime + ($crds == null ? 43 : $crds.hashCode());
        Object $generatorOptions = this.getGeneratorOptions();
        result = result * prime + ($generatorOptions == null ? 43 : $generatorOptions.hashCode());
        Object $generators = this.getGenerators();
        result = result * prime + ($generators == null ? 43 : $generators.hashCode());
        Object $helmChartInflationGenerator = this.getHelmChartInflationGenerator();
        result = result * prime + ($helmChartInflationGenerator == null ? 43 : $helmChartInflationGenerator.hashCode());
        Object $helmCharts = this.getHelmCharts();
        result = result * prime + ($helmCharts == null ? 43 : $helmCharts.hashCode());
        Object $helmGlobals = this.getHelmGlobals();
        result = result * prime + ($helmGlobals == null ? 43 : $helmGlobals.hashCode());
        Object $imageTags = this.getImageTags();
        result = result * prime + ($imageTags == null ? 43 : $imageTags.hashCode());
        Object $images = this.getImages();
        result = result * prime + ($images == null ? 43 : $images.hashCode());
        Object $kind = this.getKind();
        result = result * prime + ($kind == null ? 43 : $kind.hashCode());
        Object $labels = this.getLabels();
        result = result * prime + ($labels == null ? 43 : $labels.hashCode());
        Object $metadata = this.getMetadata();
        result = result * prime + ($metadata == null ? 43 : $metadata.hashCode());
        Object $namePrefix = this.getNamePrefix();
        result = result * prime + ($namePrefix == null ? 43 : $namePrefix.hashCode());
        Object $nameSuffix = this.getNameSuffix();
        result = result * prime + ($nameSuffix == null ? 43 : $nameSuffix.hashCode());
        Object $namespace = this.getNamespace();
        result = result * prime + ($namespace == null ? 43 : $namespace.hashCode());
        Object $openapi = this.getOpenapi();
        result = result * prime + ($openapi == null ? 43 : $openapi.hashCode());
        Object $patches = this.getPatches();
        result = result * prime + ($patches == null ? 43 : $patches.hashCode());
        Object $patchesJson6902 = this.getPatchesJson6902();
        result = result * prime + ($patchesJson6902 == null ? 43 : $patchesJson6902.hashCode());
        Object $patchesStrategicMerge = this.getPatchesStrategicMerge();
        result = result * prime + ($patchesStrategicMerge == null ? 43 : $patchesStrategicMerge.hashCode());
        Object $replacements = this.getReplacements();
        result = result * prime + ($replacements == null ? 43 : $replacements.hashCode());
        Object $replicas = this.getReplicas();
        result = result * prime + ($replicas == null ? 43 : $replicas.hashCode());
        Object $resources = this.getResources();
        result = result * prime + ($resources == null ? 43 : $resources.hashCode());
        Object $secretGenerator = this.getSecretGenerator();
        result = result * prime + ($secretGenerator == null ? 43 : $secretGenerator.hashCode());
        Object $sortOptions = this.getSortOptions();
        result = result * prime + ($sortOptions == null ? 43 : $sortOptions.hashCode());
        Object $transformers = this.getTransformers();
        result = result * prime + ($transformers == null ? 43 : $transformers.hashCode());
        Object $validators = this.getValidators();
        result = result * prime + ($validators == null ? 43 : $validators.hashCode());
        Object $vars = this.getVars();
        result = result * prime + ($vars == null ? 43 : $vars.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "Kustomization(" + "apiVersion=" + this.getApiVersion() + ", bases=" + this.getBases() + ", buildMetadata=" + this.getBuildMetadata() + ", commonAnnotations=" + this.getCommonAnnotations() + ", commonLabels=" + this.getCommonLabels() + ", components=" + this.getComponents() + ", configMapGenerator=" + this.getConfigMapGenerator() + ", configurations=" + this.getConfigurations() + ", crds=" + this.getCrds() + ", generatorOptions=" + this.getGeneratorOptions() + ", generators=" + this.getGenerators() + ", helmChartInflationGenerator=" + this.getHelmChartInflationGenerator() + ", helmCharts=" + this.getHelmCharts() + ", helmGlobals=" + this.getHelmGlobals() + ", imageTags=" + this.getImageTags() + ", images=" + this.getImages() + ", kind=" + this.getKind() + ", labels=" + this.getLabels() + ", metadata=" + this.getMetadata() + ", namePrefix=" + this.getNamePrefix() + ", nameSuffix=" + this.getNameSuffix() + ", namespace=" + this.getNamespace() + ", openapi=" + this.getOpenapi() + ", patches=" + this.getPatches() + ", patchesJson6902=" + this.getPatchesJson6902() + ", patchesStrategicMerge=" + this.getPatchesStrategicMerge() + ", replacements=" + this.getReplacements() + ", replicas=" + this.getReplicas() + ", resources=" + this.getResources() + ", secretGenerator=" + this.getSecretGenerator() + ", sortOptions=" + this.getSortOptions() + ", transformers=" + this.getTransformers() + ", validators=" + this.getValidators() + ", vars=" + this.getVars() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
