
package io.fabric8.camel.api.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.fabric8.camelk.v1.Artifact;
import io.fabric8.camelk.v1.Build;
import io.fabric8.camelk.v1.BuildCondition;
import io.fabric8.camelk.v1.BuildList;
import io.fabric8.camelk.v1.BuildSpec;
import io.fabric8.camelk.v1.BuildStatus;
import io.fabric8.camelk.v1.BuildahTask;
import io.fabric8.camelk.v1.BuilderTask;
import io.fabric8.camelk.v1.CamelArtifact;
import io.fabric8.camelk.v1.CamelArtifactDependency;
import io.fabric8.camelk.v1.CamelArtifactExclusion;
import io.fabric8.camelk.v1.CamelCatalog;
import io.fabric8.camelk.v1.CamelCatalogList;
import io.fabric8.camelk.v1.CamelCatalogSpec;
import io.fabric8.camelk.v1.CamelCatalogStatus;
import io.fabric8.camelk.v1.CamelLoader;
import io.fabric8.camelk.v1.CamelScheme;
import io.fabric8.camelk.v1.CamelSchemeScope;
import io.fabric8.camelk.v1.Capability;
import io.fabric8.camelk.v1.ConfigurationSpec;
import io.fabric8.camelk.v1.Failure;
import io.fabric8.camelk.v1.FailureRecovery;
import io.fabric8.camelk.v1.Integration;
import io.fabric8.camelk.v1.IntegrationCondition;
import io.fabric8.camelk.v1.IntegrationKit;
import io.fabric8.camelk.v1.IntegrationKitCondition;
import io.fabric8.camelk.v1.IntegrationKitList;
import io.fabric8.camelk.v1.IntegrationKitSpec;
import io.fabric8.camelk.v1.IntegrationKitStatus;
import io.fabric8.camelk.v1.IntegrationList;
import io.fabric8.camelk.v1.IntegrationPlatform;
import io.fabric8.camelk.v1.IntegrationPlatformBuildSpec;
import io.fabric8.camelk.v1.IntegrationPlatformCondition;
import io.fabric8.camelk.v1.IntegrationPlatformKameletRepositorySpec;
import io.fabric8.camelk.v1.IntegrationPlatformKameletSpec;
import io.fabric8.camelk.v1.IntegrationPlatformList;
import io.fabric8.camelk.v1.IntegrationPlatformResourcesSpec;
import io.fabric8.camelk.v1.IntegrationPlatformSpec;
import io.fabric8.camelk.v1.IntegrationPlatformStatus;
import io.fabric8.camelk.v1.IntegrationSpec;
import io.fabric8.camelk.v1.IntegrationStatus;
import io.fabric8.camelk.v1.KanikoTask;
import io.fabric8.camelk.v1.KanikoTaskCache;
import io.fabric8.camelk.v1.MavenArtifact;
import io.fabric8.camelk.v1.MavenBuildSpec;
import io.fabric8.camelk.v1.MavenSpec;
import io.fabric8.camelk.v1.PodSpec;
import io.fabric8.camelk.v1.PodSpecTemplate;
import io.fabric8.camelk.v1.RegistrySpec;
import io.fabric8.camelk.v1.Repository;
import io.fabric8.camelk.v1.RepositoryPolicy;
import io.fabric8.camelk.v1.ResourceSpec;
import io.fabric8.camelk.v1.RuntimeSpec;
import io.fabric8.camelk.v1.S2iTask;
import io.fabric8.camelk.v1.SourceSpec;
import io.fabric8.camelk.v1.SpectrumTask;
import io.fabric8.camelk.v1.Task;
import io.fabric8.camelk.v1.TraitSpec;
import io.fabric8.camelk.v1.ValueSource;
import io.fabric8.kubernetes.api.model.Container;
import io.fabric8.kubernetes.api.model.ContainerPort;
import io.fabric8.kubernetes.api.model.EnvVar;
import io.fabric8.kubernetes.api.model.IntOrString;
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
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "apiVersion",
    "kind",
    "metadata",
    "github_com_apache_camel-k_pkg_apis_camel_v1_Artifact",
    "github_com_apache_camel-k_pkg_apis_camel_v1_Build",
    "github_com_apache_camel-k_pkg_apis_camel_v1_BuildCondition",
    "github_com_apache_camel-k_pkg_apis_camel_v1_BuildList",
    "github_com_apache_camel-k_pkg_apis_camel_v1_BuildSpec",
    "github_com_apache_camel-k_pkg_apis_camel_v1_BuildStatus",
    "github_com_apache_camel-k_pkg_apis_camel_v1_BuildahTask",
    "github_com_apache_camel-k_pkg_apis_camel_v1_BuilderTask",
    "github_com_apache_camel-k_pkg_apis_camel_v1_CamelArtifact",
    "github_com_apache_camel-k_pkg_apis_camel_v1_CamelArtifactDependency",
    "github_com_apache_camel-k_pkg_apis_camel_v1_CamelArtifactExclusion",
    "github_com_apache_camel-k_pkg_apis_camel_v1_CamelCatalog",
    "github_com_apache_camel-k_pkg_apis_camel_v1_CamelCatalogList",
    "github_com_apache_camel-k_pkg_apis_camel_v1_CamelCatalogSpec",
    "github_com_apache_camel-k_pkg_apis_camel_v1_CamelCatalogStatus",
    "github_com_apache_camel-k_pkg_apis_camel_v1_CamelLoader",
    "github_com_apache_camel-k_pkg_apis_camel_v1_CamelScheme",
    "github_com_apache_camel-k_pkg_apis_camel_v1_CamelSchemeScope",
    "github_com_apache_camel-k_pkg_apis_camel_v1_Capability",
    "github_com_apache_camel-k_pkg_apis_camel_v1_ConfigurationSpec",
    "github_com_apache_camel-k_pkg_apis_camel_v1_Failure",
    "github_com_apache_camel-k_pkg_apis_camel_v1_FailureRecovery",
    "github_com_apache_camel-k_pkg_apis_camel_v1_Integration",
    "github_com_apache_camel-k_pkg_apis_camel_v1_IntegrationCondition",
    "github_com_apache_camel-k_pkg_apis_camel_v1_IntegrationKit",
    "github_com_apache_camel-k_pkg_apis_camel_v1_IntegrationKitCondition",
    "github_com_apache_camel-k_pkg_apis_camel_v1_IntegrationKitList",
    "github_com_apache_camel-k_pkg_apis_camel_v1_IntegrationKitSpec",
    "github_com_apache_camel-k_pkg_apis_camel_v1_IntegrationKitStatus",
    "github_com_apache_camel-k_pkg_apis_camel_v1_IntegrationList",
    "github_com_apache_camel-k_pkg_apis_camel_v1_IntegrationPlatform",
    "github_com_apache_camel-k_pkg_apis_camel_v1_IntegrationPlatformBuildSpec",
    "github_com_apache_camel-k_pkg_apis_camel_v1_IntegrationPlatformCondition",
    "github_com_apache_camel-k_pkg_apis_camel_v1_IntegrationPlatformKameletRepositorySpec",
    "github_com_apache_camel-k_pkg_apis_camel_v1_IntegrationPlatformKameletSpec",
    "github_com_apache_camel-k_pkg_apis_camel_v1_IntegrationPlatformList",
    "github_com_apache_camel-k_pkg_apis_camel_v1_IntegrationPlatformResourcesSpec",
    "github_com_apache_camel-k_pkg_apis_camel_v1_IntegrationPlatformSpec",
    "github_com_apache_camel-k_pkg_apis_camel_v1_IntegrationPlatformStatus",
    "github_com_apache_camel-k_pkg_apis_camel_v1_IntegrationSpec",
    "github_com_apache_camel-k_pkg_apis_camel_v1_IntegrationStatus",
    "github_com_apache_camel-k_pkg_apis_camel_v1_KanikoTask",
    "github_com_apache_camel-k_pkg_apis_camel_v1_KanikoTaskCache",
    "github_com_apache_camel-k_pkg_apis_camel_v1_MavenArtifact",
    "github_com_apache_camel-k_pkg_apis_camel_v1_MavenBuildSpec",
    "github_com_apache_camel-k_pkg_apis_camel_v1_MavenSpec",
    "github_com_apache_camel-k_pkg_apis_camel_v1_PodSpec",
    "github_com_apache_camel-k_pkg_apis_camel_v1_PodSpecTemplate",
    "github_com_apache_camel-k_pkg_apis_camel_v1_RegistrySpec",
    "github_com_apache_camel-k_pkg_apis_camel_v1_Repository",
    "github_com_apache_camel-k_pkg_apis_camel_v1_RepositoryPolicy",
    "github_com_apache_camel-k_pkg_apis_camel_v1_ResourceSpec",
    "github_com_apache_camel-k_pkg_apis_camel_v1_RuntimeSpec",
    "github_com_apache_camel-k_pkg_apis_camel_v1_S2iTask",
    "github_com_apache_camel-k_pkg_apis_camel_v1_SourceSpec",
    "github_com_apache_camel-k_pkg_apis_camel_v1_SpectrumTask",
    "github_com_apache_camel-k_pkg_apis_camel_v1_Task",
    "github_com_apache_camel-k_pkg_apis_camel_v1_TraitSpec",
    "github_com_apache_camel-k_pkg_apis_camel_v1_ValueSource"
})
@ToString
@EqualsAndHashCode
@Setter
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
public class CamelKSchemaV1 {

    @JsonProperty("github_com_apache_camel-k_pkg_apis_camel_v1_Artifact")
    private Artifact githubComApacheCamelKPkgApisCamelV1Artifact;
    @JsonProperty("github_com_apache_camel-k_pkg_apis_camel_v1_Build")
    private Build githubComApacheCamelKPkgApisCamelV1Build;
    @JsonProperty("github_com_apache_camel-k_pkg_apis_camel_v1_BuildCondition")
    private BuildCondition githubComApacheCamelKPkgApisCamelV1BuildCondition;
    @JsonProperty("github_com_apache_camel-k_pkg_apis_camel_v1_BuildList")
    private BuildList githubComApacheCamelKPkgApisCamelV1BuildList;
    @JsonProperty("github_com_apache_camel-k_pkg_apis_camel_v1_BuildSpec")
    private BuildSpec githubComApacheCamelKPkgApisCamelV1BuildSpec;
    @JsonProperty("github_com_apache_camel-k_pkg_apis_camel_v1_BuildStatus")
    private BuildStatus githubComApacheCamelKPkgApisCamelV1BuildStatus;
    @JsonProperty("github_com_apache_camel-k_pkg_apis_camel_v1_BuildahTask")
    private BuildahTask githubComApacheCamelKPkgApisCamelV1BuildahTask;
    @JsonProperty("github_com_apache_camel-k_pkg_apis_camel_v1_BuilderTask")
    private BuilderTask githubComApacheCamelKPkgApisCamelV1BuilderTask;
    @JsonProperty("github_com_apache_camel-k_pkg_apis_camel_v1_CamelArtifact")
    private CamelArtifact githubComApacheCamelKPkgApisCamelV1CamelArtifact;
    @JsonProperty("github_com_apache_camel-k_pkg_apis_camel_v1_CamelArtifactDependency")
    private CamelArtifactDependency githubComApacheCamelKPkgApisCamelV1CamelArtifactDependency;
    @JsonProperty("github_com_apache_camel-k_pkg_apis_camel_v1_CamelArtifactExclusion")
    private CamelArtifactExclusion githubComApacheCamelKPkgApisCamelV1CamelArtifactExclusion;
    @JsonProperty("github_com_apache_camel-k_pkg_apis_camel_v1_CamelCatalog")
    private CamelCatalog githubComApacheCamelKPkgApisCamelV1CamelCatalog;
    @JsonProperty("github_com_apache_camel-k_pkg_apis_camel_v1_CamelCatalogList")
    private CamelCatalogList githubComApacheCamelKPkgApisCamelV1CamelCatalogList;
    @JsonProperty("github_com_apache_camel-k_pkg_apis_camel_v1_CamelCatalogSpec")
    private CamelCatalogSpec githubComApacheCamelKPkgApisCamelV1CamelCatalogSpec;
    @JsonProperty("github_com_apache_camel-k_pkg_apis_camel_v1_CamelCatalogStatus")
    private CamelCatalogStatus githubComApacheCamelKPkgApisCamelV1CamelCatalogStatus;
    @JsonProperty("github_com_apache_camel-k_pkg_apis_camel_v1_CamelLoader")
    private CamelLoader githubComApacheCamelKPkgApisCamelV1CamelLoader;
    @JsonProperty("github_com_apache_camel-k_pkg_apis_camel_v1_CamelScheme")
    private CamelScheme githubComApacheCamelKPkgApisCamelV1CamelScheme;
    @JsonProperty("github_com_apache_camel-k_pkg_apis_camel_v1_CamelSchemeScope")
    private CamelSchemeScope githubComApacheCamelKPkgApisCamelV1CamelSchemeScope;
    @JsonProperty("github_com_apache_camel-k_pkg_apis_camel_v1_Capability")
    private Capability githubComApacheCamelKPkgApisCamelV1Capability;
    @JsonProperty("github_com_apache_camel-k_pkg_apis_camel_v1_ConfigurationSpec")
    private ConfigurationSpec githubComApacheCamelKPkgApisCamelV1ConfigurationSpec;
    @JsonProperty("github_com_apache_camel-k_pkg_apis_camel_v1_Failure")
    private Failure githubComApacheCamelKPkgApisCamelV1Failure;
    @JsonProperty("github_com_apache_camel-k_pkg_apis_camel_v1_FailureRecovery")
    private FailureRecovery githubComApacheCamelKPkgApisCamelV1FailureRecovery;
    @JsonProperty("github_com_apache_camel-k_pkg_apis_camel_v1_Integration")
    private Integration githubComApacheCamelKPkgApisCamelV1Integration;
    @JsonProperty("github_com_apache_camel-k_pkg_apis_camel_v1_IntegrationCondition")
    private IntegrationCondition githubComApacheCamelKPkgApisCamelV1IntegrationCondition;
    @JsonProperty("github_com_apache_camel-k_pkg_apis_camel_v1_IntegrationKit")
    private IntegrationKit githubComApacheCamelKPkgApisCamelV1IntegrationKit;
    @JsonProperty("github_com_apache_camel-k_pkg_apis_camel_v1_IntegrationKitCondition")
    private IntegrationKitCondition githubComApacheCamelKPkgApisCamelV1IntegrationKitCondition;
    @JsonProperty("github_com_apache_camel-k_pkg_apis_camel_v1_IntegrationKitList")
    private IntegrationKitList githubComApacheCamelKPkgApisCamelV1IntegrationKitList;
    @JsonProperty("github_com_apache_camel-k_pkg_apis_camel_v1_IntegrationKitSpec")
    private IntegrationKitSpec githubComApacheCamelKPkgApisCamelV1IntegrationKitSpec;
    @JsonProperty("github_com_apache_camel-k_pkg_apis_camel_v1_IntegrationKitStatus")
    private IntegrationKitStatus githubComApacheCamelKPkgApisCamelV1IntegrationKitStatus;
    @JsonProperty("github_com_apache_camel-k_pkg_apis_camel_v1_IntegrationList")
    private IntegrationList githubComApacheCamelKPkgApisCamelV1IntegrationList;
    @JsonProperty("github_com_apache_camel-k_pkg_apis_camel_v1_IntegrationPlatform")
    private IntegrationPlatform githubComApacheCamelKPkgApisCamelV1IntegrationPlatform;
    @JsonProperty("github_com_apache_camel-k_pkg_apis_camel_v1_IntegrationPlatformBuildSpec")
    private IntegrationPlatformBuildSpec githubComApacheCamelKPkgApisCamelV1IntegrationPlatformBuildSpec;
    @JsonProperty("github_com_apache_camel-k_pkg_apis_camel_v1_IntegrationPlatformCondition")
    private IntegrationPlatformCondition githubComApacheCamelKPkgApisCamelV1IntegrationPlatformCondition;
    @JsonProperty("github_com_apache_camel-k_pkg_apis_camel_v1_IntegrationPlatformKameletRepositorySpec")
    private IntegrationPlatformKameletRepositorySpec githubComApacheCamelKPkgApisCamelV1IntegrationPlatformKameletRepositorySpec;
    @JsonProperty("github_com_apache_camel-k_pkg_apis_camel_v1_IntegrationPlatformKameletSpec")
    private IntegrationPlatformKameletSpec githubComApacheCamelKPkgApisCamelV1IntegrationPlatformKameletSpec;
    @JsonProperty("github_com_apache_camel-k_pkg_apis_camel_v1_IntegrationPlatformList")
    private IntegrationPlatformList githubComApacheCamelKPkgApisCamelV1IntegrationPlatformList;
    @JsonProperty("github_com_apache_camel-k_pkg_apis_camel_v1_IntegrationPlatformResourcesSpec")
    private IntegrationPlatformResourcesSpec githubComApacheCamelKPkgApisCamelV1IntegrationPlatformResourcesSpec;
    @JsonProperty("github_com_apache_camel-k_pkg_apis_camel_v1_IntegrationPlatformSpec")
    private IntegrationPlatformSpec githubComApacheCamelKPkgApisCamelV1IntegrationPlatformSpec;
    @JsonProperty("github_com_apache_camel-k_pkg_apis_camel_v1_IntegrationPlatformStatus")
    private IntegrationPlatformStatus githubComApacheCamelKPkgApisCamelV1IntegrationPlatformStatus;
    @JsonProperty("github_com_apache_camel-k_pkg_apis_camel_v1_IntegrationSpec")
    private IntegrationSpec githubComApacheCamelKPkgApisCamelV1IntegrationSpec;
    @JsonProperty("github_com_apache_camel-k_pkg_apis_camel_v1_IntegrationStatus")
    private IntegrationStatus githubComApacheCamelKPkgApisCamelV1IntegrationStatus;
    @JsonProperty("github_com_apache_camel-k_pkg_apis_camel_v1_KanikoTask")
    private KanikoTask githubComApacheCamelKPkgApisCamelV1KanikoTask;
    @JsonProperty("github_com_apache_camel-k_pkg_apis_camel_v1_KanikoTaskCache")
    private KanikoTaskCache githubComApacheCamelKPkgApisCamelV1KanikoTaskCache;
    @JsonProperty("github_com_apache_camel-k_pkg_apis_camel_v1_MavenArtifact")
    private MavenArtifact githubComApacheCamelKPkgApisCamelV1MavenArtifact;
    @JsonProperty("github_com_apache_camel-k_pkg_apis_camel_v1_MavenBuildSpec")
    private MavenBuildSpec githubComApacheCamelKPkgApisCamelV1MavenBuildSpec;
    @JsonProperty("github_com_apache_camel-k_pkg_apis_camel_v1_MavenSpec")
    private MavenSpec githubComApacheCamelKPkgApisCamelV1MavenSpec;
    @JsonProperty("github_com_apache_camel-k_pkg_apis_camel_v1_PodSpec")
    private PodSpec githubComApacheCamelKPkgApisCamelV1PodSpec;
    @JsonProperty("github_com_apache_camel-k_pkg_apis_camel_v1_PodSpecTemplate")
    private PodSpecTemplate githubComApacheCamelKPkgApisCamelV1PodSpecTemplate;
    @JsonProperty("github_com_apache_camel-k_pkg_apis_camel_v1_RegistrySpec")
    private RegistrySpec githubComApacheCamelKPkgApisCamelV1RegistrySpec;
    @JsonProperty("github_com_apache_camel-k_pkg_apis_camel_v1_Repository")
    private Repository githubComApacheCamelKPkgApisCamelV1Repository;
    @JsonProperty("github_com_apache_camel-k_pkg_apis_camel_v1_RepositoryPolicy")
    private RepositoryPolicy githubComApacheCamelKPkgApisCamelV1RepositoryPolicy;
    @JsonProperty("github_com_apache_camel-k_pkg_apis_camel_v1_ResourceSpec")
    private ResourceSpec githubComApacheCamelKPkgApisCamelV1ResourceSpec;
    @JsonProperty("github_com_apache_camel-k_pkg_apis_camel_v1_RuntimeSpec")
    private RuntimeSpec githubComApacheCamelKPkgApisCamelV1RuntimeSpec;
    @JsonProperty("github_com_apache_camel-k_pkg_apis_camel_v1_S2iTask")
    private S2iTask githubComApacheCamelKPkgApisCamelV1S2iTask;
    @JsonProperty("github_com_apache_camel-k_pkg_apis_camel_v1_SourceSpec")
    private SourceSpec githubComApacheCamelKPkgApisCamelV1SourceSpec;
    @JsonProperty("github_com_apache_camel-k_pkg_apis_camel_v1_SpectrumTask")
    private SpectrumTask githubComApacheCamelKPkgApisCamelV1SpectrumTask;
    @JsonProperty("github_com_apache_camel-k_pkg_apis_camel_v1_Task")
    private Task githubComApacheCamelKPkgApisCamelV1Task;
    @JsonProperty("github_com_apache_camel-k_pkg_apis_camel_v1_TraitSpec")
    private TraitSpec githubComApacheCamelKPkgApisCamelV1TraitSpec;
    @JsonProperty("github_com_apache_camel-k_pkg_apis_camel_v1_ValueSource")
    private ValueSource githubComApacheCamelKPkgApisCamelV1ValueSource;

    /**
     * No args constructor for use in serialization
     * 
     */
    public CamelKSchemaV1() {
    }

    /**
     * 
     * @param githubComApacheCamelKPkgApisCamelV1BuildStatus
     * @param githubComApacheCamelKPkgApisCamelV1IntegrationStatus
     * @param githubComApacheCamelKPkgApisCamelV1IntegrationKitList
     * @param githubComApacheCamelKPkgApisCamelV1BuildahTask
     * @param githubComApacheCamelKPkgApisCamelV1CamelCatalogList
     * @param githubComApacheCamelKPkgApisCamelV1PodSpec
     * @param githubComApacheCamelKPkgApisCamelV1RuntimeSpec
     * @param githubComApacheCamelKPkgApisCamelV1RepositoryPolicy
     * @param githubComApacheCamelKPkgApisCamelV1MavenBuildSpec
     * @param githubComApacheCamelKPkgApisCamelV1IntegrationPlatform
     * @param githubComApacheCamelKPkgApisCamelV1CamelArtifactDependency
     * @param githubComApacheCamelKPkgApisCamelV1IntegrationKit
     * @param githubComApacheCamelKPkgApisCamelV1BuildCondition
     * @param githubComApacheCamelKPkgApisCamelV1CamelSchemeScope
     * @param githubComApacheCamelKPkgApisCamelV1Task
     * @param githubComApacheCamelKPkgApisCamelV1IntegrationPlatformStatus
     * @param githubComApacheCamelKPkgApisCamelV1PodSpecTemplate
     * @param githubComApacheCamelKPkgApisCamelV1CamelCatalogSpec
     * @param githubComApacheCamelKPkgApisCamelV1IntegrationPlatformKameletRepositorySpec
     * @param githubComApacheCamelKPkgApisCamelV1SpectrumTask
     * @param githubComApacheCamelKPkgApisCamelV1IntegrationSpec
     * @param githubComApacheCamelKPkgApisCamelV1IntegrationPlatformList
     * @param githubComApacheCamelKPkgApisCamelV1Repository
     * @param githubComApacheCamelKPkgApisCamelV1IntegrationKitCondition
     * @param githubComApacheCamelKPkgApisCamelV1KanikoTaskCache
     * @param githubComApacheCamelKPkgApisCamelV1IntegrationCondition
     * @param githubComApacheCamelKPkgApisCamelV1Failure
     * @param githubComApacheCamelKPkgApisCamelV1BuildSpec
     * @param githubComApacheCamelKPkgApisCamelV1KanikoTask
     * @param githubComApacheCamelKPkgApisCamelV1IntegrationPlatformBuildSpec
     * @param githubComApacheCamelKPkgApisCamelV1IntegrationPlatformCondition
     * @param githubComApacheCamelKPkgApisCamelV1CamelCatalogStatus
     * @param githubComApacheCamelKPkgApisCamelV1IntegrationList
     * @param githubComApacheCamelKPkgApisCamelV1IntegrationPlatformKameletSpec
     * @param githubComApacheCamelKPkgApisCamelV1IntegrationPlatformSpec
     * @param githubComApacheCamelKPkgApisCamelV1ConfigurationSpec
     * @param githubComApacheCamelKPkgApisCamelV1FailureRecovery
     * @param githubComApacheCamelKPkgApisCamelV1IntegrationKitStatus
     * @param githubComApacheCamelKPkgApisCamelV1Integration
     * @param githubComApacheCamelKPkgApisCamelV1Capability
     * @param githubComApacheCamelKPkgApisCamelV1BuildList
     * @param githubComApacheCamelKPkgApisCamelV1TraitSpec
     * @param githubComApacheCamelKPkgApisCamelV1CamelCatalog
     * @param githubComApacheCamelKPkgApisCamelV1CamelLoader
     * @param githubComApacheCamelKPkgApisCamelV1CamelScheme
     * @param githubComApacheCamelKPkgApisCamelV1MavenArtifact
     * @param githubComApacheCamelKPkgApisCamelV1CamelArtifactExclusion
     * @param githubComApacheCamelKPkgApisCamelV1IntegrationKitSpec
     * @param githubComApacheCamelKPkgApisCamelV1RegistrySpec
     * @param githubComApacheCamelKPkgApisCamelV1ResourceSpec
     * @param githubComApacheCamelKPkgApisCamelV1ValueSource
     * @param githubComApacheCamelKPkgApisCamelV1Artifact
     * @param githubComApacheCamelKPkgApisCamelV1IntegrationPlatformResourcesSpec
     * @param githubComApacheCamelKPkgApisCamelV1Build
     * @param githubComApacheCamelKPkgApisCamelV1MavenSpec
     * @param githubComApacheCamelKPkgApisCamelV1S2iTask
     * @param githubComApacheCamelKPkgApisCamelV1SourceSpec
     * @param githubComApacheCamelKPkgApisCamelV1BuilderTask
     * @param githubComApacheCamelKPkgApisCamelV1CamelArtifact
     */
    public CamelKSchemaV1(Artifact githubComApacheCamelKPkgApisCamelV1Artifact, Build githubComApacheCamelKPkgApisCamelV1Build, BuildCondition githubComApacheCamelKPkgApisCamelV1BuildCondition, BuildList githubComApacheCamelKPkgApisCamelV1BuildList, BuildSpec githubComApacheCamelKPkgApisCamelV1BuildSpec, BuildStatus githubComApacheCamelKPkgApisCamelV1BuildStatus, BuildahTask githubComApacheCamelKPkgApisCamelV1BuildahTask, BuilderTask githubComApacheCamelKPkgApisCamelV1BuilderTask, CamelArtifact githubComApacheCamelKPkgApisCamelV1CamelArtifact, CamelArtifactDependency githubComApacheCamelKPkgApisCamelV1CamelArtifactDependency, CamelArtifactExclusion githubComApacheCamelKPkgApisCamelV1CamelArtifactExclusion, CamelCatalog githubComApacheCamelKPkgApisCamelV1CamelCatalog, CamelCatalogList githubComApacheCamelKPkgApisCamelV1CamelCatalogList, CamelCatalogSpec githubComApacheCamelKPkgApisCamelV1CamelCatalogSpec, CamelCatalogStatus githubComApacheCamelKPkgApisCamelV1CamelCatalogStatus, CamelLoader githubComApacheCamelKPkgApisCamelV1CamelLoader, CamelScheme githubComApacheCamelKPkgApisCamelV1CamelScheme, CamelSchemeScope githubComApacheCamelKPkgApisCamelV1CamelSchemeScope, Capability githubComApacheCamelKPkgApisCamelV1Capability, ConfigurationSpec githubComApacheCamelKPkgApisCamelV1ConfigurationSpec, Failure githubComApacheCamelKPkgApisCamelV1Failure, FailureRecovery githubComApacheCamelKPkgApisCamelV1FailureRecovery, Integration githubComApacheCamelKPkgApisCamelV1Integration, IntegrationCondition githubComApacheCamelKPkgApisCamelV1IntegrationCondition, IntegrationKit githubComApacheCamelKPkgApisCamelV1IntegrationKit, IntegrationKitCondition githubComApacheCamelKPkgApisCamelV1IntegrationKitCondition, IntegrationKitList githubComApacheCamelKPkgApisCamelV1IntegrationKitList, IntegrationKitSpec githubComApacheCamelKPkgApisCamelV1IntegrationKitSpec, IntegrationKitStatus githubComApacheCamelKPkgApisCamelV1IntegrationKitStatus, IntegrationList githubComApacheCamelKPkgApisCamelV1IntegrationList, IntegrationPlatform githubComApacheCamelKPkgApisCamelV1IntegrationPlatform, IntegrationPlatformBuildSpec githubComApacheCamelKPkgApisCamelV1IntegrationPlatformBuildSpec, IntegrationPlatformCondition githubComApacheCamelKPkgApisCamelV1IntegrationPlatformCondition, IntegrationPlatformKameletRepositorySpec githubComApacheCamelKPkgApisCamelV1IntegrationPlatformKameletRepositorySpec, IntegrationPlatformKameletSpec githubComApacheCamelKPkgApisCamelV1IntegrationPlatformKameletSpec, IntegrationPlatformList githubComApacheCamelKPkgApisCamelV1IntegrationPlatformList, IntegrationPlatformResourcesSpec githubComApacheCamelKPkgApisCamelV1IntegrationPlatformResourcesSpec, IntegrationPlatformSpec githubComApacheCamelKPkgApisCamelV1IntegrationPlatformSpec, IntegrationPlatformStatus githubComApacheCamelKPkgApisCamelV1IntegrationPlatformStatus, IntegrationSpec githubComApacheCamelKPkgApisCamelV1IntegrationSpec, IntegrationStatus githubComApacheCamelKPkgApisCamelV1IntegrationStatus, KanikoTask githubComApacheCamelKPkgApisCamelV1KanikoTask, KanikoTaskCache githubComApacheCamelKPkgApisCamelV1KanikoTaskCache, MavenArtifact githubComApacheCamelKPkgApisCamelV1MavenArtifact, MavenBuildSpec githubComApacheCamelKPkgApisCamelV1MavenBuildSpec, MavenSpec githubComApacheCamelKPkgApisCamelV1MavenSpec, PodSpec githubComApacheCamelKPkgApisCamelV1PodSpec, PodSpecTemplate githubComApacheCamelKPkgApisCamelV1PodSpecTemplate, RegistrySpec githubComApacheCamelKPkgApisCamelV1RegistrySpec, Repository githubComApacheCamelKPkgApisCamelV1Repository, RepositoryPolicy githubComApacheCamelKPkgApisCamelV1RepositoryPolicy, ResourceSpec githubComApacheCamelKPkgApisCamelV1ResourceSpec, RuntimeSpec githubComApacheCamelKPkgApisCamelV1RuntimeSpec, S2iTask githubComApacheCamelKPkgApisCamelV1S2iTask, SourceSpec githubComApacheCamelKPkgApisCamelV1SourceSpec, SpectrumTask githubComApacheCamelKPkgApisCamelV1SpectrumTask, Task githubComApacheCamelKPkgApisCamelV1Task, TraitSpec githubComApacheCamelKPkgApisCamelV1TraitSpec, ValueSource githubComApacheCamelKPkgApisCamelV1ValueSource) {
        super();
        this.githubComApacheCamelKPkgApisCamelV1Artifact = githubComApacheCamelKPkgApisCamelV1Artifact;
        this.githubComApacheCamelKPkgApisCamelV1Build = githubComApacheCamelKPkgApisCamelV1Build;
        this.githubComApacheCamelKPkgApisCamelV1BuildCondition = githubComApacheCamelKPkgApisCamelV1BuildCondition;
        this.githubComApacheCamelKPkgApisCamelV1BuildList = githubComApacheCamelKPkgApisCamelV1BuildList;
        this.githubComApacheCamelKPkgApisCamelV1BuildSpec = githubComApacheCamelKPkgApisCamelV1BuildSpec;
        this.githubComApacheCamelKPkgApisCamelV1BuildStatus = githubComApacheCamelKPkgApisCamelV1BuildStatus;
        this.githubComApacheCamelKPkgApisCamelV1BuildahTask = githubComApacheCamelKPkgApisCamelV1BuildahTask;
        this.githubComApacheCamelKPkgApisCamelV1BuilderTask = githubComApacheCamelKPkgApisCamelV1BuilderTask;
        this.githubComApacheCamelKPkgApisCamelV1CamelArtifact = githubComApacheCamelKPkgApisCamelV1CamelArtifact;
        this.githubComApacheCamelKPkgApisCamelV1CamelArtifactDependency = githubComApacheCamelKPkgApisCamelV1CamelArtifactDependency;
        this.githubComApacheCamelKPkgApisCamelV1CamelArtifactExclusion = githubComApacheCamelKPkgApisCamelV1CamelArtifactExclusion;
        this.githubComApacheCamelKPkgApisCamelV1CamelCatalog = githubComApacheCamelKPkgApisCamelV1CamelCatalog;
        this.githubComApacheCamelKPkgApisCamelV1CamelCatalogList = githubComApacheCamelKPkgApisCamelV1CamelCatalogList;
        this.githubComApacheCamelKPkgApisCamelV1CamelCatalogSpec = githubComApacheCamelKPkgApisCamelV1CamelCatalogSpec;
        this.githubComApacheCamelKPkgApisCamelV1CamelCatalogStatus = githubComApacheCamelKPkgApisCamelV1CamelCatalogStatus;
        this.githubComApacheCamelKPkgApisCamelV1CamelLoader = githubComApacheCamelKPkgApisCamelV1CamelLoader;
        this.githubComApacheCamelKPkgApisCamelV1CamelScheme = githubComApacheCamelKPkgApisCamelV1CamelScheme;
        this.githubComApacheCamelKPkgApisCamelV1CamelSchemeScope = githubComApacheCamelKPkgApisCamelV1CamelSchemeScope;
        this.githubComApacheCamelKPkgApisCamelV1Capability = githubComApacheCamelKPkgApisCamelV1Capability;
        this.githubComApacheCamelKPkgApisCamelV1ConfigurationSpec = githubComApacheCamelKPkgApisCamelV1ConfigurationSpec;
        this.githubComApacheCamelKPkgApisCamelV1Failure = githubComApacheCamelKPkgApisCamelV1Failure;
        this.githubComApacheCamelKPkgApisCamelV1FailureRecovery = githubComApacheCamelKPkgApisCamelV1FailureRecovery;
        this.githubComApacheCamelKPkgApisCamelV1Integration = githubComApacheCamelKPkgApisCamelV1Integration;
        this.githubComApacheCamelKPkgApisCamelV1IntegrationCondition = githubComApacheCamelKPkgApisCamelV1IntegrationCondition;
        this.githubComApacheCamelKPkgApisCamelV1IntegrationKit = githubComApacheCamelKPkgApisCamelV1IntegrationKit;
        this.githubComApacheCamelKPkgApisCamelV1IntegrationKitCondition = githubComApacheCamelKPkgApisCamelV1IntegrationKitCondition;
        this.githubComApacheCamelKPkgApisCamelV1IntegrationKitList = githubComApacheCamelKPkgApisCamelV1IntegrationKitList;
        this.githubComApacheCamelKPkgApisCamelV1IntegrationKitSpec = githubComApacheCamelKPkgApisCamelV1IntegrationKitSpec;
        this.githubComApacheCamelKPkgApisCamelV1IntegrationKitStatus = githubComApacheCamelKPkgApisCamelV1IntegrationKitStatus;
        this.githubComApacheCamelKPkgApisCamelV1IntegrationList = githubComApacheCamelKPkgApisCamelV1IntegrationList;
        this.githubComApacheCamelKPkgApisCamelV1IntegrationPlatform = githubComApacheCamelKPkgApisCamelV1IntegrationPlatform;
        this.githubComApacheCamelKPkgApisCamelV1IntegrationPlatformBuildSpec = githubComApacheCamelKPkgApisCamelV1IntegrationPlatformBuildSpec;
        this.githubComApacheCamelKPkgApisCamelV1IntegrationPlatformCondition = githubComApacheCamelKPkgApisCamelV1IntegrationPlatformCondition;
        this.githubComApacheCamelKPkgApisCamelV1IntegrationPlatformKameletRepositorySpec = githubComApacheCamelKPkgApisCamelV1IntegrationPlatformKameletRepositorySpec;
        this.githubComApacheCamelKPkgApisCamelV1IntegrationPlatformKameletSpec = githubComApacheCamelKPkgApisCamelV1IntegrationPlatformKameletSpec;
        this.githubComApacheCamelKPkgApisCamelV1IntegrationPlatformList = githubComApacheCamelKPkgApisCamelV1IntegrationPlatformList;
        this.githubComApacheCamelKPkgApisCamelV1IntegrationPlatformResourcesSpec = githubComApacheCamelKPkgApisCamelV1IntegrationPlatformResourcesSpec;
        this.githubComApacheCamelKPkgApisCamelV1IntegrationPlatformSpec = githubComApacheCamelKPkgApisCamelV1IntegrationPlatformSpec;
        this.githubComApacheCamelKPkgApisCamelV1IntegrationPlatformStatus = githubComApacheCamelKPkgApisCamelV1IntegrationPlatformStatus;
        this.githubComApacheCamelKPkgApisCamelV1IntegrationSpec = githubComApacheCamelKPkgApisCamelV1IntegrationSpec;
        this.githubComApacheCamelKPkgApisCamelV1IntegrationStatus = githubComApacheCamelKPkgApisCamelV1IntegrationStatus;
        this.githubComApacheCamelKPkgApisCamelV1KanikoTask = githubComApacheCamelKPkgApisCamelV1KanikoTask;
        this.githubComApacheCamelKPkgApisCamelV1KanikoTaskCache = githubComApacheCamelKPkgApisCamelV1KanikoTaskCache;
        this.githubComApacheCamelKPkgApisCamelV1MavenArtifact = githubComApacheCamelKPkgApisCamelV1MavenArtifact;
        this.githubComApacheCamelKPkgApisCamelV1MavenBuildSpec = githubComApacheCamelKPkgApisCamelV1MavenBuildSpec;
        this.githubComApacheCamelKPkgApisCamelV1MavenSpec = githubComApacheCamelKPkgApisCamelV1MavenSpec;
        this.githubComApacheCamelKPkgApisCamelV1PodSpec = githubComApacheCamelKPkgApisCamelV1PodSpec;
        this.githubComApacheCamelKPkgApisCamelV1PodSpecTemplate = githubComApacheCamelKPkgApisCamelV1PodSpecTemplate;
        this.githubComApacheCamelKPkgApisCamelV1RegistrySpec = githubComApacheCamelKPkgApisCamelV1RegistrySpec;
        this.githubComApacheCamelKPkgApisCamelV1Repository = githubComApacheCamelKPkgApisCamelV1Repository;
        this.githubComApacheCamelKPkgApisCamelV1RepositoryPolicy = githubComApacheCamelKPkgApisCamelV1RepositoryPolicy;
        this.githubComApacheCamelKPkgApisCamelV1ResourceSpec = githubComApacheCamelKPkgApisCamelV1ResourceSpec;
        this.githubComApacheCamelKPkgApisCamelV1RuntimeSpec = githubComApacheCamelKPkgApisCamelV1RuntimeSpec;
        this.githubComApacheCamelKPkgApisCamelV1S2iTask = githubComApacheCamelKPkgApisCamelV1S2iTask;
        this.githubComApacheCamelKPkgApisCamelV1SourceSpec = githubComApacheCamelKPkgApisCamelV1SourceSpec;
        this.githubComApacheCamelKPkgApisCamelV1SpectrumTask = githubComApacheCamelKPkgApisCamelV1SpectrumTask;
        this.githubComApacheCamelKPkgApisCamelV1Task = githubComApacheCamelKPkgApisCamelV1Task;
        this.githubComApacheCamelKPkgApisCamelV1TraitSpec = githubComApacheCamelKPkgApisCamelV1TraitSpec;
        this.githubComApacheCamelKPkgApisCamelV1ValueSource = githubComApacheCamelKPkgApisCamelV1ValueSource;
    }

    @JsonProperty("github_com_apache_camel-k_pkg_apis_camel_v1_Artifact")
    public Artifact getGithubComApacheCamelKPkgApisCamelV1Artifact() {
        return githubComApacheCamelKPkgApisCamelV1Artifact;
    }

    @JsonProperty("github_com_apache_camel-k_pkg_apis_camel_v1_Artifact")
    public void setGithubComApacheCamelKPkgApisCamelV1Artifact(Artifact githubComApacheCamelKPkgApisCamelV1Artifact) {
        this.githubComApacheCamelKPkgApisCamelV1Artifact = githubComApacheCamelKPkgApisCamelV1Artifact;
    }

    @JsonProperty("github_com_apache_camel-k_pkg_apis_camel_v1_Build")
    public Build getGithubComApacheCamelKPkgApisCamelV1Build() {
        return githubComApacheCamelKPkgApisCamelV1Build;
    }

    @JsonProperty("github_com_apache_camel-k_pkg_apis_camel_v1_Build")
    public void setGithubComApacheCamelKPkgApisCamelV1Build(Build githubComApacheCamelKPkgApisCamelV1Build) {
        this.githubComApacheCamelKPkgApisCamelV1Build = githubComApacheCamelKPkgApisCamelV1Build;
    }

    @JsonProperty("github_com_apache_camel-k_pkg_apis_camel_v1_BuildCondition")
    public BuildCondition getGithubComApacheCamelKPkgApisCamelV1BuildCondition() {
        return githubComApacheCamelKPkgApisCamelV1BuildCondition;
    }

    @JsonProperty("github_com_apache_camel-k_pkg_apis_camel_v1_BuildCondition")
    public void setGithubComApacheCamelKPkgApisCamelV1BuildCondition(BuildCondition githubComApacheCamelKPkgApisCamelV1BuildCondition) {
        this.githubComApacheCamelKPkgApisCamelV1BuildCondition = githubComApacheCamelKPkgApisCamelV1BuildCondition;
    }

    @JsonProperty("github_com_apache_camel-k_pkg_apis_camel_v1_BuildList")
    public BuildList getGithubComApacheCamelKPkgApisCamelV1BuildList() {
        return githubComApacheCamelKPkgApisCamelV1BuildList;
    }

    @JsonProperty("github_com_apache_camel-k_pkg_apis_camel_v1_BuildList")
    public void setGithubComApacheCamelKPkgApisCamelV1BuildList(BuildList githubComApacheCamelKPkgApisCamelV1BuildList) {
        this.githubComApacheCamelKPkgApisCamelV1BuildList = githubComApacheCamelKPkgApisCamelV1BuildList;
    }

    @JsonProperty("github_com_apache_camel-k_pkg_apis_camel_v1_BuildSpec")
    public BuildSpec getGithubComApacheCamelKPkgApisCamelV1BuildSpec() {
        return githubComApacheCamelKPkgApisCamelV1BuildSpec;
    }

    @JsonProperty("github_com_apache_camel-k_pkg_apis_camel_v1_BuildSpec")
    public void setGithubComApacheCamelKPkgApisCamelV1BuildSpec(BuildSpec githubComApacheCamelKPkgApisCamelV1BuildSpec) {
        this.githubComApacheCamelKPkgApisCamelV1BuildSpec = githubComApacheCamelKPkgApisCamelV1BuildSpec;
    }

    @JsonProperty("github_com_apache_camel-k_pkg_apis_camel_v1_BuildStatus")
    public BuildStatus getGithubComApacheCamelKPkgApisCamelV1BuildStatus() {
        return githubComApacheCamelKPkgApisCamelV1BuildStatus;
    }

    @JsonProperty("github_com_apache_camel-k_pkg_apis_camel_v1_BuildStatus")
    public void setGithubComApacheCamelKPkgApisCamelV1BuildStatus(BuildStatus githubComApacheCamelKPkgApisCamelV1BuildStatus) {
        this.githubComApacheCamelKPkgApisCamelV1BuildStatus = githubComApacheCamelKPkgApisCamelV1BuildStatus;
    }

    @JsonProperty("github_com_apache_camel-k_pkg_apis_camel_v1_BuildahTask")
    public BuildahTask getGithubComApacheCamelKPkgApisCamelV1BuildahTask() {
        return githubComApacheCamelKPkgApisCamelV1BuildahTask;
    }

    @JsonProperty("github_com_apache_camel-k_pkg_apis_camel_v1_BuildahTask")
    public void setGithubComApacheCamelKPkgApisCamelV1BuildahTask(BuildahTask githubComApacheCamelKPkgApisCamelV1BuildahTask) {
        this.githubComApacheCamelKPkgApisCamelV1BuildahTask = githubComApacheCamelKPkgApisCamelV1BuildahTask;
    }

    @JsonProperty("github_com_apache_camel-k_pkg_apis_camel_v1_BuilderTask")
    public BuilderTask getGithubComApacheCamelKPkgApisCamelV1BuilderTask() {
        return githubComApacheCamelKPkgApisCamelV1BuilderTask;
    }

    @JsonProperty("github_com_apache_camel-k_pkg_apis_camel_v1_BuilderTask")
    public void setGithubComApacheCamelKPkgApisCamelV1BuilderTask(BuilderTask githubComApacheCamelKPkgApisCamelV1BuilderTask) {
        this.githubComApacheCamelKPkgApisCamelV1BuilderTask = githubComApacheCamelKPkgApisCamelV1BuilderTask;
    }

    @JsonProperty("github_com_apache_camel-k_pkg_apis_camel_v1_CamelArtifact")
    public CamelArtifact getGithubComApacheCamelKPkgApisCamelV1CamelArtifact() {
        return githubComApacheCamelKPkgApisCamelV1CamelArtifact;
    }

    @JsonProperty("github_com_apache_camel-k_pkg_apis_camel_v1_CamelArtifact")
    public void setGithubComApacheCamelKPkgApisCamelV1CamelArtifact(CamelArtifact githubComApacheCamelKPkgApisCamelV1CamelArtifact) {
        this.githubComApacheCamelKPkgApisCamelV1CamelArtifact = githubComApacheCamelKPkgApisCamelV1CamelArtifact;
    }

    @JsonProperty("github_com_apache_camel-k_pkg_apis_camel_v1_CamelArtifactDependency")
    public CamelArtifactDependency getGithubComApacheCamelKPkgApisCamelV1CamelArtifactDependency() {
        return githubComApacheCamelKPkgApisCamelV1CamelArtifactDependency;
    }

    @JsonProperty("github_com_apache_camel-k_pkg_apis_camel_v1_CamelArtifactDependency")
    public void setGithubComApacheCamelKPkgApisCamelV1CamelArtifactDependency(CamelArtifactDependency githubComApacheCamelKPkgApisCamelV1CamelArtifactDependency) {
        this.githubComApacheCamelKPkgApisCamelV1CamelArtifactDependency = githubComApacheCamelKPkgApisCamelV1CamelArtifactDependency;
    }

    @JsonProperty("github_com_apache_camel-k_pkg_apis_camel_v1_CamelArtifactExclusion")
    public CamelArtifactExclusion getGithubComApacheCamelKPkgApisCamelV1CamelArtifactExclusion() {
        return githubComApacheCamelKPkgApisCamelV1CamelArtifactExclusion;
    }

    @JsonProperty("github_com_apache_camel-k_pkg_apis_camel_v1_CamelArtifactExclusion")
    public void setGithubComApacheCamelKPkgApisCamelV1CamelArtifactExclusion(CamelArtifactExclusion githubComApacheCamelKPkgApisCamelV1CamelArtifactExclusion) {
        this.githubComApacheCamelKPkgApisCamelV1CamelArtifactExclusion = githubComApacheCamelKPkgApisCamelV1CamelArtifactExclusion;
    }

    @JsonProperty("github_com_apache_camel-k_pkg_apis_camel_v1_CamelCatalog")
    public CamelCatalog getGithubComApacheCamelKPkgApisCamelV1CamelCatalog() {
        return githubComApacheCamelKPkgApisCamelV1CamelCatalog;
    }

    @JsonProperty("github_com_apache_camel-k_pkg_apis_camel_v1_CamelCatalog")
    public void setGithubComApacheCamelKPkgApisCamelV1CamelCatalog(CamelCatalog githubComApacheCamelKPkgApisCamelV1CamelCatalog) {
        this.githubComApacheCamelKPkgApisCamelV1CamelCatalog = githubComApacheCamelKPkgApisCamelV1CamelCatalog;
    }

    @JsonProperty("github_com_apache_camel-k_pkg_apis_camel_v1_CamelCatalogList")
    public CamelCatalogList getGithubComApacheCamelKPkgApisCamelV1CamelCatalogList() {
        return githubComApacheCamelKPkgApisCamelV1CamelCatalogList;
    }

    @JsonProperty("github_com_apache_camel-k_pkg_apis_camel_v1_CamelCatalogList")
    public void setGithubComApacheCamelKPkgApisCamelV1CamelCatalogList(CamelCatalogList githubComApacheCamelKPkgApisCamelV1CamelCatalogList) {
        this.githubComApacheCamelKPkgApisCamelV1CamelCatalogList = githubComApacheCamelKPkgApisCamelV1CamelCatalogList;
    }

    @JsonProperty("github_com_apache_camel-k_pkg_apis_camel_v1_CamelCatalogSpec")
    public CamelCatalogSpec getGithubComApacheCamelKPkgApisCamelV1CamelCatalogSpec() {
        return githubComApacheCamelKPkgApisCamelV1CamelCatalogSpec;
    }

    @JsonProperty("github_com_apache_camel-k_pkg_apis_camel_v1_CamelCatalogSpec")
    public void setGithubComApacheCamelKPkgApisCamelV1CamelCatalogSpec(CamelCatalogSpec githubComApacheCamelKPkgApisCamelV1CamelCatalogSpec) {
        this.githubComApacheCamelKPkgApisCamelV1CamelCatalogSpec = githubComApacheCamelKPkgApisCamelV1CamelCatalogSpec;
    }

    @JsonProperty("github_com_apache_camel-k_pkg_apis_camel_v1_CamelCatalogStatus")
    public CamelCatalogStatus getGithubComApacheCamelKPkgApisCamelV1CamelCatalogStatus() {
        return githubComApacheCamelKPkgApisCamelV1CamelCatalogStatus;
    }

    @JsonProperty("github_com_apache_camel-k_pkg_apis_camel_v1_CamelCatalogStatus")
    public void setGithubComApacheCamelKPkgApisCamelV1CamelCatalogStatus(CamelCatalogStatus githubComApacheCamelKPkgApisCamelV1CamelCatalogStatus) {
        this.githubComApacheCamelKPkgApisCamelV1CamelCatalogStatus = githubComApacheCamelKPkgApisCamelV1CamelCatalogStatus;
    }

    @JsonProperty("github_com_apache_camel-k_pkg_apis_camel_v1_CamelLoader")
    public CamelLoader getGithubComApacheCamelKPkgApisCamelV1CamelLoader() {
        return githubComApacheCamelKPkgApisCamelV1CamelLoader;
    }

    @JsonProperty("github_com_apache_camel-k_pkg_apis_camel_v1_CamelLoader")
    public void setGithubComApacheCamelKPkgApisCamelV1CamelLoader(CamelLoader githubComApacheCamelKPkgApisCamelV1CamelLoader) {
        this.githubComApacheCamelKPkgApisCamelV1CamelLoader = githubComApacheCamelKPkgApisCamelV1CamelLoader;
    }

    @JsonProperty("github_com_apache_camel-k_pkg_apis_camel_v1_CamelScheme")
    public CamelScheme getGithubComApacheCamelKPkgApisCamelV1CamelScheme() {
        return githubComApacheCamelKPkgApisCamelV1CamelScheme;
    }

    @JsonProperty("github_com_apache_camel-k_pkg_apis_camel_v1_CamelScheme")
    public void setGithubComApacheCamelKPkgApisCamelV1CamelScheme(CamelScheme githubComApacheCamelKPkgApisCamelV1CamelScheme) {
        this.githubComApacheCamelKPkgApisCamelV1CamelScheme = githubComApacheCamelKPkgApisCamelV1CamelScheme;
    }

    @JsonProperty("github_com_apache_camel-k_pkg_apis_camel_v1_CamelSchemeScope")
    public CamelSchemeScope getGithubComApacheCamelKPkgApisCamelV1CamelSchemeScope() {
        return githubComApacheCamelKPkgApisCamelV1CamelSchemeScope;
    }

    @JsonProperty("github_com_apache_camel-k_pkg_apis_camel_v1_CamelSchemeScope")
    public void setGithubComApacheCamelKPkgApisCamelV1CamelSchemeScope(CamelSchemeScope githubComApacheCamelKPkgApisCamelV1CamelSchemeScope) {
        this.githubComApacheCamelKPkgApisCamelV1CamelSchemeScope = githubComApacheCamelKPkgApisCamelV1CamelSchemeScope;
    }

    @JsonProperty("github_com_apache_camel-k_pkg_apis_camel_v1_Capability")
    public Capability getGithubComApacheCamelKPkgApisCamelV1Capability() {
        return githubComApacheCamelKPkgApisCamelV1Capability;
    }

    @JsonProperty("github_com_apache_camel-k_pkg_apis_camel_v1_Capability")
    public void setGithubComApacheCamelKPkgApisCamelV1Capability(Capability githubComApacheCamelKPkgApisCamelV1Capability) {
        this.githubComApacheCamelKPkgApisCamelV1Capability = githubComApacheCamelKPkgApisCamelV1Capability;
    }

    @JsonProperty("github_com_apache_camel-k_pkg_apis_camel_v1_ConfigurationSpec")
    public ConfigurationSpec getGithubComApacheCamelKPkgApisCamelV1ConfigurationSpec() {
        return githubComApacheCamelKPkgApisCamelV1ConfigurationSpec;
    }

    @JsonProperty("github_com_apache_camel-k_pkg_apis_camel_v1_ConfigurationSpec")
    public void setGithubComApacheCamelKPkgApisCamelV1ConfigurationSpec(ConfigurationSpec githubComApacheCamelKPkgApisCamelV1ConfigurationSpec) {
        this.githubComApacheCamelKPkgApisCamelV1ConfigurationSpec = githubComApacheCamelKPkgApisCamelV1ConfigurationSpec;
    }

    @JsonProperty("github_com_apache_camel-k_pkg_apis_camel_v1_Failure")
    public Failure getGithubComApacheCamelKPkgApisCamelV1Failure() {
        return githubComApacheCamelKPkgApisCamelV1Failure;
    }

    @JsonProperty("github_com_apache_camel-k_pkg_apis_camel_v1_Failure")
    public void setGithubComApacheCamelKPkgApisCamelV1Failure(Failure githubComApacheCamelKPkgApisCamelV1Failure) {
        this.githubComApacheCamelKPkgApisCamelV1Failure = githubComApacheCamelKPkgApisCamelV1Failure;
    }

    @JsonProperty("github_com_apache_camel-k_pkg_apis_camel_v1_FailureRecovery")
    public FailureRecovery getGithubComApacheCamelKPkgApisCamelV1FailureRecovery() {
        return githubComApacheCamelKPkgApisCamelV1FailureRecovery;
    }

    @JsonProperty("github_com_apache_camel-k_pkg_apis_camel_v1_FailureRecovery")
    public void setGithubComApacheCamelKPkgApisCamelV1FailureRecovery(FailureRecovery githubComApacheCamelKPkgApisCamelV1FailureRecovery) {
        this.githubComApacheCamelKPkgApisCamelV1FailureRecovery = githubComApacheCamelKPkgApisCamelV1FailureRecovery;
    }

    @JsonProperty("github_com_apache_camel-k_pkg_apis_camel_v1_Integration")
    public Integration getGithubComApacheCamelKPkgApisCamelV1Integration() {
        return githubComApacheCamelKPkgApisCamelV1Integration;
    }

    @JsonProperty("github_com_apache_camel-k_pkg_apis_camel_v1_Integration")
    public void setGithubComApacheCamelKPkgApisCamelV1Integration(Integration githubComApacheCamelKPkgApisCamelV1Integration) {
        this.githubComApacheCamelKPkgApisCamelV1Integration = githubComApacheCamelKPkgApisCamelV1Integration;
    }

    @JsonProperty("github_com_apache_camel-k_pkg_apis_camel_v1_IntegrationCondition")
    public IntegrationCondition getGithubComApacheCamelKPkgApisCamelV1IntegrationCondition() {
        return githubComApacheCamelKPkgApisCamelV1IntegrationCondition;
    }

    @JsonProperty("github_com_apache_camel-k_pkg_apis_camel_v1_IntegrationCondition")
    public void setGithubComApacheCamelKPkgApisCamelV1IntegrationCondition(IntegrationCondition githubComApacheCamelKPkgApisCamelV1IntegrationCondition) {
        this.githubComApacheCamelKPkgApisCamelV1IntegrationCondition = githubComApacheCamelKPkgApisCamelV1IntegrationCondition;
    }

    @JsonProperty("github_com_apache_camel-k_pkg_apis_camel_v1_IntegrationKit")
    public IntegrationKit getGithubComApacheCamelKPkgApisCamelV1IntegrationKit() {
        return githubComApacheCamelKPkgApisCamelV1IntegrationKit;
    }

    @JsonProperty("github_com_apache_camel-k_pkg_apis_camel_v1_IntegrationKit")
    public void setGithubComApacheCamelKPkgApisCamelV1IntegrationKit(IntegrationKit githubComApacheCamelKPkgApisCamelV1IntegrationKit) {
        this.githubComApacheCamelKPkgApisCamelV1IntegrationKit = githubComApacheCamelKPkgApisCamelV1IntegrationKit;
    }

    @JsonProperty("github_com_apache_camel-k_pkg_apis_camel_v1_IntegrationKitCondition")
    public IntegrationKitCondition getGithubComApacheCamelKPkgApisCamelV1IntegrationKitCondition() {
        return githubComApacheCamelKPkgApisCamelV1IntegrationKitCondition;
    }

    @JsonProperty("github_com_apache_camel-k_pkg_apis_camel_v1_IntegrationKitCondition")
    public void setGithubComApacheCamelKPkgApisCamelV1IntegrationKitCondition(IntegrationKitCondition githubComApacheCamelKPkgApisCamelV1IntegrationKitCondition) {
        this.githubComApacheCamelKPkgApisCamelV1IntegrationKitCondition = githubComApacheCamelKPkgApisCamelV1IntegrationKitCondition;
    }

    @JsonProperty("github_com_apache_camel-k_pkg_apis_camel_v1_IntegrationKitList")
    public IntegrationKitList getGithubComApacheCamelKPkgApisCamelV1IntegrationKitList() {
        return githubComApacheCamelKPkgApisCamelV1IntegrationKitList;
    }

    @JsonProperty("github_com_apache_camel-k_pkg_apis_camel_v1_IntegrationKitList")
    public void setGithubComApacheCamelKPkgApisCamelV1IntegrationKitList(IntegrationKitList githubComApacheCamelKPkgApisCamelV1IntegrationKitList) {
        this.githubComApacheCamelKPkgApisCamelV1IntegrationKitList = githubComApacheCamelKPkgApisCamelV1IntegrationKitList;
    }

    @JsonProperty("github_com_apache_camel-k_pkg_apis_camel_v1_IntegrationKitSpec")
    public IntegrationKitSpec getGithubComApacheCamelKPkgApisCamelV1IntegrationKitSpec() {
        return githubComApacheCamelKPkgApisCamelV1IntegrationKitSpec;
    }

    @JsonProperty("github_com_apache_camel-k_pkg_apis_camel_v1_IntegrationKitSpec")
    public void setGithubComApacheCamelKPkgApisCamelV1IntegrationKitSpec(IntegrationKitSpec githubComApacheCamelKPkgApisCamelV1IntegrationKitSpec) {
        this.githubComApacheCamelKPkgApisCamelV1IntegrationKitSpec = githubComApacheCamelKPkgApisCamelV1IntegrationKitSpec;
    }

    @JsonProperty("github_com_apache_camel-k_pkg_apis_camel_v1_IntegrationKitStatus")
    public IntegrationKitStatus getGithubComApacheCamelKPkgApisCamelV1IntegrationKitStatus() {
        return githubComApacheCamelKPkgApisCamelV1IntegrationKitStatus;
    }

    @JsonProperty("github_com_apache_camel-k_pkg_apis_camel_v1_IntegrationKitStatus")
    public void setGithubComApacheCamelKPkgApisCamelV1IntegrationKitStatus(IntegrationKitStatus githubComApacheCamelKPkgApisCamelV1IntegrationKitStatus) {
        this.githubComApacheCamelKPkgApisCamelV1IntegrationKitStatus = githubComApacheCamelKPkgApisCamelV1IntegrationKitStatus;
    }

    @JsonProperty("github_com_apache_camel-k_pkg_apis_camel_v1_IntegrationList")
    public IntegrationList getGithubComApacheCamelKPkgApisCamelV1IntegrationList() {
        return githubComApacheCamelKPkgApisCamelV1IntegrationList;
    }

    @JsonProperty("github_com_apache_camel-k_pkg_apis_camel_v1_IntegrationList")
    public void setGithubComApacheCamelKPkgApisCamelV1IntegrationList(IntegrationList githubComApacheCamelKPkgApisCamelV1IntegrationList) {
        this.githubComApacheCamelKPkgApisCamelV1IntegrationList = githubComApacheCamelKPkgApisCamelV1IntegrationList;
    }

    @JsonProperty("github_com_apache_camel-k_pkg_apis_camel_v1_IntegrationPlatform")
    public IntegrationPlatform getGithubComApacheCamelKPkgApisCamelV1IntegrationPlatform() {
        return githubComApacheCamelKPkgApisCamelV1IntegrationPlatform;
    }

    @JsonProperty("github_com_apache_camel-k_pkg_apis_camel_v1_IntegrationPlatform")
    public void setGithubComApacheCamelKPkgApisCamelV1IntegrationPlatform(IntegrationPlatform githubComApacheCamelKPkgApisCamelV1IntegrationPlatform) {
        this.githubComApacheCamelKPkgApisCamelV1IntegrationPlatform = githubComApacheCamelKPkgApisCamelV1IntegrationPlatform;
    }

    @JsonProperty("github_com_apache_camel-k_pkg_apis_camel_v1_IntegrationPlatformBuildSpec")
    public IntegrationPlatformBuildSpec getGithubComApacheCamelKPkgApisCamelV1IntegrationPlatformBuildSpec() {
        return githubComApacheCamelKPkgApisCamelV1IntegrationPlatformBuildSpec;
    }

    @JsonProperty("github_com_apache_camel-k_pkg_apis_camel_v1_IntegrationPlatformBuildSpec")
    public void setGithubComApacheCamelKPkgApisCamelV1IntegrationPlatformBuildSpec(IntegrationPlatformBuildSpec githubComApacheCamelKPkgApisCamelV1IntegrationPlatformBuildSpec) {
        this.githubComApacheCamelKPkgApisCamelV1IntegrationPlatformBuildSpec = githubComApacheCamelKPkgApisCamelV1IntegrationPlatformBuildSpec;
    }

    @JsonProperty("github_com_apache_camel-k_pkg_apis_camel_v1_IntegrationPlatformCondition")
    public IntegrationPlatformCondition getGithubComApacheCamelKPkgApisCamelV1IntegrationPlatformCondition() {
        return githubComApacheCamelKPkgApisCamelV1IntegrationPlatformCondition;
    }

    @JsonProperty("github_com_apache_camel-k_pkg_apis_camel_v1_IntegrationPlatformCondition")
    public void setGithubComApacheCamelKPkgApisCamelV1IntegrationPlatformCondition(IntegrationPlatformCondition githubComApacheCamelKPkgApisCamelV1IntegrationPlatformCondition) {
        this.githubComApacheCamelKPkgApisCamelV1IntegrationPlatformCondition = githubComApacheCamelKPkgApisCamelV1IntegrationPlatformCondition;
    }

    @JsonProperty("github_com_apache_camel-k_pkg_apis_camel_v1_IntegrationPlatformKameletRepositorySpec")
    public IntegrationPlatformKameletRepositorySpec getGithubComApacheCamelKPkgApisCamelV1IntegrationPlatformKameletRepositorySpec() {
        return githubComApacheCamelKPkgApisCamelV1IntegrationPlatformKameletRepositorySpec;
    }

    @JsonProperty("github_com_apache_camel-k_pkg_apis_camel_v1_IntegrationPlatformKameletRepositorySpec")
    public void setGithubComApacheCamelKPkgApisCamelV1IntegrationPlatformKameletRepositorySpec(IntegrationPlatformKameletRepositorySpec githubComApacheCamelKPkgApisCamelV1IntegrationPlatformKameletRepositorySpec) {
        this.githubComApacheCamelKPkgApisCamelV1IntegrationPlatformKameletRepositorySpec = githubComApacheCamelKPkgApisCamelV1IntegrationPlatformKameletRepositorySpec;
    }

    @JsonProperty("github_com_apache_camel-k_pkg_apis_camel_v1_IntegrationPlatformKameletSpec")
    public IntegrationPlatformKameletSpec getGithubComApacheCamelKPkgApisCamelV1IntegrationPlatformKameletSpec() {
        return githubComApacheCamelKPkgApisCamelV1IntegrationPlatformKameletSpec;
    }

    @JsonProperty("github_com_apache_camel-k_pkg_apis_camel_v1_IntegrationPlatformKameletSpec")
    public void setGithubComApacheCamelKPkgApisCamelV1IntegrationPlatformKameletSpec(IntegrationPlatformKameletSpec githubComApacheCamelKPkgApisCamelV1IntegrationPlatformKameletSpec) {
        this.githubComApacheCamelKPkgApisCamelV1IntegrationPlatformKameletSpec = githubComApacheCamelKPkgApisCamelV1IntegrationPlatformKameletSpec;
    }

    @JsonProperty("github_com_apache_camel-k_pkg_apis_camel_v1_IntegrationPlatformList")
    public IntegrationPlatformList getGithubComApacheCamelKPkgApisCamelV1IntegrationPlatformList() {
        return githubComApacheCamelKPkgApisCamelV1IntegrationPlatformList;
    }

    @JsonProperty("github_com_apache_camel-k_pkg_apis_camel_v1_IntegrationPlatformList")
    public void setGithubComApacheCamelKPkgApisCamelV1IntegrationPlatformList(IntegrationPlatformList githubComApacheCamelKPkgApisCamelV1IntegrationPlatformList) {
        this.githubComApacheCamelKPkgApisCamelV1IntegrationPlatformList = githubComApacheCamelKPkgApisCamelV1IntegrationPlatformList;
    }

    @JsonProperty("github_com_apache_camel-k_pkg_apis_camel_v1_IntegrationPlatformResourcesSpec")
    public IntegrationPlatformResourcesSpec getGithubComApacheCamelKPkgApisCamelV1IntegrationPlatformResourcesSpec() {
        return githubComApacheCamelKPkgApisCamelV1IntegrationPlatformResourcesSpec;
    }

    @JsonProperty("github_com_apache_camel-k_pkg_apis_camel_v1_IntegrationPlatformResourcesSpec")
    public void setGithubComApacheCamelKPkgApisCamelV1IntegrationPlatformResourcesSpec(IntegrationPlatformResourcesSpec githubComApacheCamelKPkgApisCamelV1IntegrationPlatformResourcesSpec) {
        this.githubComApacheCamelKPkgApisCamelV1IntegrationPlatformResourcesSpec = githubComApacheCamelKPkgApisCamelV1IntegrationPlatformResourcesSpec;
    }

    @JsonProperty("github_com_apache_camel-k_pkg_apis_camel_v1_IntegrationPlatformSpec")
    public IntegrationPlatformSpec getGithubComApacheCamelKPkgApisCamelV1IntegrationPlatformSpec() {
        return githubComApacheCamelKPkgApisCamelV1IntegrationPlatformSpec;
    }

    @JsonProperty("github_com_apache_camel-k_pkg_apis_camel_v1_IntegrationPlatformSpec")
    public void setGithubComApacheCamelKPkgApisCamelV1IntegrationPlatformSpec(IntegrationPlatformSpec githubComApacheCamelKPkgApisCamelV1IntegrationPlatformSpec) {
        this.githubComApacheCamelKPkgApisCamelV1IntegrationPlatformSpec = githubComApacheCamelKPkgApisCamelV1IntegrationPlatformSpec;
    }

    @JsonProperty("github_com_apache_camel-k_pkg_apis_camel_v1_IntegrationPlatformStatus")
    public IntegrationPlatformStatus getGithubComApacheCamelKPkgApisCamelV1IntegrationPlatformStatus() {
        return githubComApacheCamelKPkgApisCamelV1IntegrationPlatformStatus;
    }

    @JsonProperty("github_com_apache_camel-k_pkg_apis_camel_v1_IntegrationPlatformStatus")
    public void setGithubComApacheCamelKPkgApisCamelV1IntegrationPlatformStatus(IntegrationPlatformStatus githubComApacheCamelKPkgApisCamelV1IntegrationPlatformStatus) {
        this.githubComApacheCamelKPkgApisCamelV1IntegrationPlatformStatus = githubComApacheCamelKPkgApisCamelV1IntegrationPlatformStatus;
    }

    @JsonProperty("github_com_apache_camel-k_pkg_apis_camel_v1_IntegrationSpec")
    public IntegrationSpec getGithubComApacheCamelKPkgApisCamelV1IntegrationSpec() {
        return githubComApacheCamelKPkgApisCamelV1IntegrationSpec;
    }

    @JsonProperty("github_com_apache_camel-k_pkg_apis_camel_v1_IntegrationSpec")
    public void setGithubComApacheCamelKPkgApisCamelV1IntegrationSpec(IntegrationSpec githubComApacheCamelKPkgApisCamelV1IntegrationSpec) {
        this.githubComApacheCamelKPkgApisCamelV1IntegrationSpec = githubComApacheCamelKPkgApisCamelV1IntegrationSpec;
    }

    @JsonProperty("github_com_apache_camel-k_pkg_apis_camel_v1_IntegrationStatus")
    public IntegrationStatus getGithubComApacheCamelKPkgApisCamelV1IntegrationStatus() {
        return githubComApacheCamelKPkgApisCamelV1IntegrationStatus;
    }

    @JsonProperty("github_com_apache_camel-k_pkg_apis_camel_v1_IntegrationStatus")
    public void setGithubComApacheCamelKPkgApisCamelV1IntegrationStatus(IntegrationStatus githubComApacheCamelKPkgApisCamelV1IntegrationStatus) {
        this.githubComApacheCamelKPkgApisCamelV1IntegrationStatus = githubComApacheCamelKPkgApisCamelV1IntegrationStatus;
    }

    @JsonProperty("github_com_apache_camel-k_pkg_apis_camel_v1_KanikoTask")
    public KanikoTask getGithubComApacheCamelKPkgApisCamelV1KanikoTask() {
        return githubComApacheCamelKPkgApisCamelV1KanikoTask;
    }

    @JsonProperty("github_com_apache_camel-k_pkg_apis_camel_v1_KanikoTask")
    public void setGithubComApacheCamelKPkgApisCamelV1KanikoTask(KanikoTask githubComApacheCamelKPkgApisCamelV1KanikoTask) {
        this.githubComApacheCamelKPkgApisCamelV1KanikoTask = githubComApacheCamelKPkgApisCamelV1KanikoTask;
    }

    @JsonProperty("github_com_apache_camel-k_pkg_apis_camel_v1_KanikoTaskCache")
    public KanikoTaskCache getGithubComApacheCamelKPkgApisCamelV1KanikoTaskCache() {
        return githubComApacheCamelKPkgApisCamelV1KanikoTaskCache;
    }

    @JsonProperty("github_com_apache_camel-k_pkg_apis_camel_v1_KanikoTaskCache")
    public void setGithubComApacheCamelKPkgApisCamelV1KanikoTaskCache(KanikoTaskCache githubComApacheCamelKPkgApisCamelV1KanikoTaskCache) {
        this.githubComApacheCamelKPkgApisCamelV1KanikoTaskCache = githubComApacheCamelKPkgApisCamelV1KanikoTaskCache;
    }

    @JsonProperty("github_com_apache_camel-k_pkg_apis_camel_v1_MavenArtifact")
    public MavenArtifact getGithubComApacheCamelKPkgApisCamelV1MavenArtifact() {
        return githubComApacheCamelKPkgApisCamelV1MavenArtifact;
    }

    @JsonProperty("github_com_apache_camel-k_pkg_apis_camel_v1_MavenArtifact")
    public void setGithubComApacheCamelKPkgApisCamelV1MavenArtifact(MavenArtifact githubComApacheCamelKPkgApisCamelV1MavenArtifact) {
        this.githubComApacheCamelKPkgApisCamelV1MavenArtifact = githubComApacheCamelKPkgApisCamelV1MavenArtifact;
    }

    @JsonProperty("github_com_apache_camel-k_pkg_apis_camel_v1_MavenBuildSpec")
    public MavenBuildSpec getGithubComApacheCamelKPkgApisCamelV1MavenBuildSpec() {
        return githubComApacheCamelKPkgApisCamelV1MavenBuildSpec;
    }

    @JsonProperty("github_com_apache_camel-k_pkg_apis_camel_v1_MavenBuildSpec")
    public void setGithubComApacheCamelKPkgApisCamelV1MavenBuildSpec(MavenBuildSpec githubComApacheCamelKPkgApisCamelV1MavenBuildSpec) {
        this.githubComApacheCamelKPkgApisCamelV1MavenBuildSpec = githubComApacheCamelKPkgApisCamelV1MavenBuildSpec;
    }

    @JsonProperty("github_com_apache_camel-k_pkg_apis_camel_v1_MavenSpec")
    public MavenSpec getGithubComApacheCamelKPkgApisCamelV1MavenSpec() {
        return githubComApacheCamelKPkgApisCamelV1MavenSpec;
    }

    @JsonProperty("github_com_apache_camel-k_pkg_apis_camel_v1_MavenSpec")
    public void setGithubComApacheCamelKPkgApisCamelV1MavenSpec(MavenSpec githubComApacheCamelKPkgApisCamelV1MavenSpec) {
        this.githubComApacheCamelKPkgApisCamelV1MavenSpec = githubComApacheCamelKPkgApisCamelV1MavenSpec;
    }

    @JsonProperty("github_com_apache_camel-k_pkg_apis_camel_v1_PodSpec")
    public PodSpec getGithubComApacheCamelKPkgApisCamelV1PodSpec() {
        return githubComApacheCamelKPkgApisCamelV1PodSpec;
    }

    @JsonProperty("github_com_apache_camel-k_pkg_apis_camel_v1_PodSpec")
    public void setGithubComApacheCamelKPkgApisCamelV1PodSpec(PodSpec githubComApacheCamelKPkgApisCamelV1PodSpec) {
        this.githubComApacheCamelKPkgApisCamelV1PodSpec = githubComApacheCamelKPkgApisCamelV1PodSpec;
    }

    @JsonProperty("github_com_apache_camel-k_pkg_apis_camel_v1_PodSpecTemplate")
    public PodSpecTemplate getGithubComApacheCamelKPkgApisCamelV1PodSpecTemplate() {
        return githubComApacheCamelKPkgApisCamelV1PodSpecTemplate;
    }

    @JsonProperty("github_com_apache_camel-k_pkg_apis_camel_v1_PodSpecTemplate")
    public void setGithubComApacheCamelKPkgApisCamelV1PodSpecTemplate(PodSpecTemplate githubComApacheCamelKPkgApisCamelV1PodSpecTemplate) {
        this.githubComApacheCamelKPkgApisCamelV1PodSpecTemplate = githubComApacheCamelKPkgApisCamelV1PodSpecTemplate;
    }

    @JsonProperty("github_com_apache_camel-k_pkg_apis_camel_v1_RegistrySpec")
    public RegistrySpec getGithubComApacheCamelKPkgApisCamelV1RegistrySpec() {
        return githubComApacheCamelKPkgApisCamelV1RegistrySpec;
    }

    @JsonProperty("github_com_apache_camel-k_pkg_apis_camel_v1_RegistrySpec")
    public void setGithubComApacheCamelKPkgApisCamelV1RegistrySpec(RegistrySpec githubComApacheCamelKPkgApisCamelV1RegistrySpec) {
        this.githubComApacheCamelKPkgApisCamelV1RegistrySpec = githubComApacheCamelKPkgApisCamelV1RegistrySpec;
    }

    @JsonProperty("github_com_apache_camel-k_pkg_apis_camel_v1_Repository")
    public Repository getGithubComApacheCamelKPkgApisCamelV1Repository() {
        return githubComApacheCamelKPkgApisCamelV1Repository;
    }

    @JsonProperty("github_com_apache_camel-k_pkg_apis_camel_v1_Repository")
    public void setGithubComApacheCamelKPkgApisCamelV1Repository(Repository githubComApacheCamelKPkgApisCamelV1Repository) {
        this.githubComApacheCamelKPkgApisCamelV1Repository = githubComApacheCamelKPkgApisCamelV1Repository;
    }

    @JsonProperty("github_com_apache_camel-k_pkg_apis_camel_v1_RepositoryPolicy")
    public RepositoryPolicy getGithubComApacheCamelKPkgApisCamelV1RepositoryPolicy() {
        return githubComApacheCamelKPkgApisCamelV1RepositoryPolicy;
    }

    @JsonProperty("github_com_apache_camel-k_pkg_apis_camel_v1_RepositoryPolicy")
    public void setGithubComApacheCamelKPkgApisCamelV1RepositoryPolicy(RepositoryPolicy githubComApacheCamelKPkgApisCamelV1RepositoryPolicy) {
        this.githubComApacheCamelKPkgApisCamelV1RepositoryPolicy = githubComApacheCamelKPkgApisCamelV1RepositoryPolicy;
    }

    @JsonProperty("github_com_apache_camel-k_pkg_apis_camel_v1_ResourceSpec")
    public ResourceSpec getGithubComApacheCamelKPkgApisCamelV1ResourceSpec() {
        return githubComApacheCamelKPkgApisCamelV1ResourceSpec;
    }

    @JsonProperty("github_com_apache_camel-k_pkg_apis_camel_v1_ResourceSpec")
    public void setGithubComApacheCamelKPkgApisCamelV1ResourceSpec(ResourceSpec githubComApacheCamelKPkgApisCamelV1ResourceSpec) {
        this.githubComApacheCamelKPkgApisCamelV1ResourceSpec = githubComApacheCamelKPkgApisCamelV1ResourceSpec;
    }

    @JsonProperty("github_com_apache_camel-k_pkg_apis_camel_v1_RuntimeSpec")
    public RuntimeSpec getGithubComApacheCamelKPkgApisCamelV1RuntimeSpec() {
        return githubComApacheCamelKPkgApisCamelV1RuntimeSpec;
    }

    @JsonProperty("github_com_apache_camel-k_pkg_apis_camel_v1_RuntimeSpec")
    public void setGithubComApacheCamelKPkgApisCamelV1RuntimeSpec(RuntimeSpec githubComApacheCamelKPkgApisCamelV1RuntimeSpec) {
        this.githubComApacheCamelKPkgApisCamelV1RuntimeSpec = githubComApacheCamelKPkgApisCamelV1RuntimeSpec;
    }

    @JsonProperty("github_com_apache_camel-k_pkg_apis_camel_v1_S2iTask")
    public S2iTask getGithubComApacheCamelKPkgApisCamelV1S2iTask() {
        return githubComApacheCamelKPkgApisCamelV1S2iTask;
    }

    @JsonProperty("github_com_apache_camel-k_pkg_apis_camel_v1_S2iTask")
    public void setGithubComApacheCamelKPkgApisCamelV1S2iTask(S2iTask githubComApacheCamelKPkgApisCamelV1S2iTask) {
        this.githubComApacheCamelKPkgApisCamelV1S2iTask = githubComApacheCamelKPkgApisCamelV1S2iTask;
    }

    @JsonProperty("github_com_apache_camel-k_pkg_apis_camel_v1_SourceSpec")
    public SourceSpec getGithubComApacheCamelKPkgApisCamelV1SourceSpec() {
        return githubComApacheCamelKPkgApisCamelV1SourceSpec;
    }

    @JsonProperty("github_com_apache_camel-k_pkg_apis_camel_v1_SourceSpec")
    public void setGithubComApacheCamelKPkgApisCamelV1SourceSpec(SourceSpec githubComApacheCamelKPkgApisCamelV1SourceSpec) {
        this.githubComApacheCamelKPkgApisCamelV1SourceSpec = githubComApacheCamelKPkgApisCamelV1SourceSpec;
    }

    @JsonProperty("github_com_apache_camel-k_pkg_apis_camel_v1_SpectrumTask")
    public SpectrumTask getGithubComApacheCamelKPkgApisCamelV1SpectrumTask() {
        return githubComApacheCamelKPkgApisCamelV1SpectrumTask;
    }

    @JsonProperty("github_com_apache_camel-k_pkg_apis_camel_v1_SpectrumTask")
    public void setGithubComApacheCamelKPkgApisCamelV1SpectrumTask(SpectrumTask githubComApacheCamelKPkgApisCamelV1SpectrumTask) {
        this.githubComApacheCamelKPkgApisCamelV1SpectrumTask = githubComApacheCamelKPkgApisCamelV1SpectrumTask;
    }

    @JsonProperty("github_com_apache_camel-k_pkg_apis_camel_v1_Task")
    public Task getGithubComApacheCamelKPkgApisCamelV1Task() {
        return githubComApacheCamelKPkgApisCamelV1Task;
    }

    @JsonProperty("github_com_apache_camel-k_pkg_apis_camel_v1_Task")
    public void setGithubComApacheCamelKPkgApisCamelV1Task(Task githubComApacheCamelKPkgApisCamelV1Task) {
        this.githubComApacheCamelKPkgApisCamelV1Task = githubComApacheCamelKPkgApisCamelV1Task;
    }

    @JsonProperty("github_com_apache_camel-k_pkg_apis_camel_v1_TraitSpec")
    public TraitSpec getGithubComApacheCamelKPkgApisCamelV1TraitSpec() {
        return githubComApacheCamelKPkgApisCamelV1TraitSpec;
    }

    @JsonProperty("github_com_apache_camel-k_pkg_apis_camel_v1_TraitSpec")
    public void setGithubComApacheCamelKPkgApisCamelV1TraitSpec(TraitSpec githubComApacheCamelKPkgApisCamelV1TraitSpec) {
        this.githubComApacheCamelKPkgApisCamelV1TraitSpec = githubComApacheCamelKPkgApisCamelV1TraitSpec;
    }

    @JsonProperty("github_com_apache_camel-k_pkg_apis_camel_v1_ValueSource")
    public ValueSource getGithubComApacheCamelKPkgApisCamelV1ValueSource() {
        return githubComApacheCamelKPkgApisCamelV1ValueSource;
    }

    @JsonProperty("github_com_apache_camel-k_pkg_apis_camel_v1_ValueSource")
    public void setGithubComApacheCamelKPkgApisCamelV1ValueSource(ValueSource githubComApacheCamelKPkgApisCamelV1ValueSource) {
        this.githubComApacheCamelKPkgApisCamelV1ValueSource = githubComApacheCamelKPkgApisCamelV1ValueSource;
    }

}
