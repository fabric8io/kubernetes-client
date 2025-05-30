
package io.fabric8.openshift.api.model.operatorhub.v1alpha1;

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
import io.fabric8.kubernetes.api.model.GroupVersionKind;
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

/**
 * ClusterServiceVersionSpec declarations tell OLM how to install an operator that can manage apps for a given version.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "annotations",
    "apiservicedefinitions",
    "cleanup",
    "customresourcedefinitions",
    "description",
    "displayName",
    "icon",
    "install",
    "installModes",
    "keywords",
    "labels",
    "links",
    "maintainers",
    "maturity",
    "minKubeVersion",
    "nativeAPIs",
    "provider",
    "relatedImages",
    "replaces",
    "selector",
    "skips",
    "version",
    "webhookdefinitions"
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
public class ClusterServiceVersionSpec implements Editable<ClusterServiceVersionSpecBuilder>, KubernetesResource
{

    @JsonProperty("annotations")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Map<String, String> annotations = new LinkedHashMap<>();
    @JsonProperty("apiservicedefinitions")
    private APIServiceDefinitions apiservicedefinitions;
    @JsonProperty("cleanup")
    private CleanupSpec cleanup;
    @JsonProperty("customresourcedefinitions")
    private CustomResourceDefinitions customresourcedefinitions;
    @JsonProperty("description")
    private String description;
    @JsonProperty("displayName")
    private String displayName;
    @JsonProperty("icon")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<Icon> icon = new ArrayList<>();
    @JsonProperty("install")
    private NamedInstallStrategy install;
    @JsonProperty("installModes")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<InstallMode> installModes = new ArrayList<>();
    @JsonProperty("keywords")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> keywords = new ArrayList<>();
    @JsonProperty("labels")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Map<String, String> labels = new LinkedHashMap<>();
    @JsonProperty("links")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<AppLink> links = new ArrayList<>();
    @JsonProperty("maintainers")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<Maintainer> maintainers = new ArrayList<>();
    @JsonProperty("maturity")
    private String maturity;
    @JsonProperty("minKubeVersion")
    private String minKubeVersion;
    @JsonProperty("nativeAPIs")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<GroupVersionKind> nativeAPIs = new ArrayList<>();
    @JsonProperty("provider")
    private AppLink provider;
    @JsonProperty("relatedImages")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<RelatedImage> relatedImages = new ArrayList<>();
    @JsonProperty("replaces")
    private String replaces;
    @JsonProperty("selector")
    private LabelSelector selector;
    @JsonProperty("skips")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> skips = new ArrayList<>();
    @JsonProperty("version")
    private String version;
    @JsonProperty("webhookdefinitions")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<WebhookDescription> webhookdefinitions = new ArrayList<>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public ClusterServiceVersionSpec() {
    }

    public ClusterServiceVersionSpec(Map<String, String> annotations, APIServiceDefinitions apiservicedefinitions, CleanupSpec cleanup, CustomResourceDefinitions customresourcedefinitions, String description, String displayName, List<Icon> icon, NamedInstallStrategy install, List<InstallMode> installModes, List<String> keywords, Map<String, String> labels, List<AppLink> links, List<Maintainer> maintainers, String maturity, String minKubeVersion, List<GroupVersionKind> nativeAPIs, AppLink provider, List<RelatedImage> relatedImages, String replaces, LabelSelector selector, List<String> skips, String version, List<WebhookDescription> webhookdefinitions) {
        super();
        this.annotations = annotations;
        this.apiservicedefinitions = apiservicedefinitions;
        this.cleanup = cleanup;
        this.customresourcedefinitions = customresourcedefinitions;
        this.description = description;
        this.displayName = displayName;
        this.icon = icon;
        this.install = install;
        this.installModes = installModes;
        this.keywords = keywords;
        this.labels = labels;
        this.links = links;
        this.maintainers = maintainers;
        this.maturity = maturity;
        this.minKubeVersion = minKubeVersion;
        this.nativeAPIs = nativeAPIs;
        this.provider = provider;
        this.relatedImages = relatedImages;
        this.replaces = replaces;
        this.selector = selector;
        this.skips = skips;
        this.version = version;
        this.webhookdefinitions = webhookdefinitions;
    }

    /**
     * Annotations is an unstructured key value map stored with a resource that may be set by external tools to store and retrieve arbitrary metadata.
     */
    @JsonProperty("annotations")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public Map<String, String> getAnnotations() {
        return annotations;
    }

    /**
     * Annotations is an unstructured key value map stored with a resource that may be set by external tools to store and retrieve arbitrary metadata.
     */
    @JsonProperty("annotations")
    public void setAnnotations(Map<String, String> annotations) {
        this.annotations = annotations;
    }

    /**
     * ClusterServiceVersionSpec declarations tell OLM how to install an operator that can manage apps for a given version.
     */
    @JsonProperty("apiservicedefinitions")
    public APIServiceDefinitions getApiservicedefinitions() {
        return apiservicedefinitions;
    }

    /**
     * ClusterServiceVersionSpec declarations tell OLM how to install an operator that can manage apps for a given version.
     */
    @JsonProperty("apiservicedefinitions")
    public void setApiservicedefinitions(APIServiceDefinitions apiservicedefinitions) {
        this.apiservicedefinitions = apiservicedefinitions;
    }

    /**
     * ClusterServiceVersionSpec declarations tell OLM how to install an operator that can manage apps for a given version.
     */
    @JsonProperty("cleanup")
    public CleanupSpec getCleanup() {
        return cleanup;
    }

    /**
     * ClusterServiceVersionSpec declarations tell OLM how to install an operator that can manage apps for a given version.
     */
    @JsonProperty("cleanup")
    public void setCleanup(CleanupSpec cleanup) {
        this.cleanup = cleanup;
    }

    /**
     * ClusterServiceVersionSpec declarations tell OLM how to install an operator that can manage apps for a given version.
     */
    @JsonProperty("customresourcedefinitions")
    public CustomResourceDefinitions getCustomresourcedefinitions() {
        return customresourcedefinitions;
    }

    /**
     * ClusterServiceVersionSpec declarations tell OLM how to install an operator that can manage apps for a given version.
     */
    @JsonProperty("customresourcedefinitions")
    public void setCustomresourcedefinitions(CustomResourceDefinitions customresourcedefinitions) {
        this.customresourcedefinitions = customresourcedefinitions;
    }

    /**
     * Description of the operator. Can include the features, limitations or use-cases of the operator.
     */
    @JsonProperty("description")
    public String getDescription() {
        return description;
    }

    /**
     * Description of the operator. Can include the features, limitations or use-cases of the operator.
     */
    @JsonProperty("description")
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * The name of the operator in display format.
     */
    @JsonProperty("displayName")
    public String getDisplayName() {
        return displayName;
    }

    /**
     * The name of the operator in display format.
     */
    @JsonProperty("displayName")
    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    /**
     * The icon for this operator.
     */
    @JsonProperty("icon")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<Icon> getIcon() {
        return icon;
    }

    /**
     * The icon for this operator.
     */
    @JsonProperty("icon")
    public void setIcon(List<Icon> icon) {
        this.icon = icon;
    }

    /**
     * ClusterServiceVersionSpec declarations tell OLM how to install an operator that can manage apps for a given version.
     */
    @JsonProperty("install")
    public NamedInstallStrategy getInstall() {
        return install;
    }

    /**
     * ClusterServiceVersionSpec declarations tell OLM how to install an operator that can manage apps for a given version.
     */
    @JsonProperty("install")
    public void setInstall(NamedInstallStrategy install) {
        this.install = install;
    }

    /**
     * InstallModes specify supported installation types
     */
    @JsonProperty("installModes")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<InstallMode> getInstallModes() {
        return installModes;
    }

    /**
     * InstallModes specify supported installation types
     */
    @JsonProperty("installModes")
    public void setInstallModes(List<InstallMode> installModes) {
        this.installModes = installModes;
    }

    /**
     * A list of keywords describing the operator.
     */
    @JsonProperty("keywords")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getKeywords() {
        return keywords;
    }

    /**
     * A list of keywords describing the operator.
     */
    @JsonProperty("keywords")
    public void setKeywords(List<String> keywords) {
        this.keywords = keywords;
    }

    /**
     * Map of string keys and values that can be used to organize and categorize (scope and select) objects.
     */
    @JsonProperty("labels")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public Map<String, String> getLabels() {
        return labels;
    }

    /**
     * Map of string keys and values that can be used to organize and categorize (scope and select) objects.
     */
    @JsonProperty("labels")
    public void setLabels(Map<String, String> labels) {
        this.labels = labels;
    }

    /**
     * A list of links related to the operator.
     */
    @JsonProperty("links")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<AppLink> getLinks() {
        return links;
    }

    /**
     * A list of links related to the operator.
     */
    @JsonProperty("links")
    public void setLinks(List<AppLink> links) {
        this.links = links;
    }

    /**
     * A list of organizational entities maintaining the operator.
     */
    @JsonProperty("maintainers")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<Maintainer> getMaintainers() {
        return maintainers;
    }

    /**
     * A list of organizational entities maintaining the operator.
     */
    @JsonProperty("maintainers")
    public void setMaintainers(List<Maintainer> maintainers) {
        this.maintainers = maintainers;
    }

    /**
     * ClusterServiceVersionSpec declarations tell OLM how to install an operator that can manage apps for a given version.
     */
    @JsonProperty("maturity")
    public String getMaturity() {
        return maturity;
    }

    /**
     * ClusterServiceVersionSpec declarations tell OLM how to install an operator that can manage apps for a given version.
     */
    @JsonProperty("maturity")
    public void setMaturity(String maturity) {
        this.maturity = maturity;
    }

    /**
     * ClusterServiceVersionSpec declarations tell OLM how to install an operator that can manage apps for a given version.
     */
    @JsonProperty("minKubeVersion")
    public String getMinKubeVersion() {
        return minKubeVersion;
    }

    /**
     * ClusterServiceVersionSpec declarations tell OLM how to install an operator that can manage apps for a given version.
     */
    @JsonProperty("minKubeVersion")
    public void setMinKubeVersion(String minKubeVersion) {
        this.minKubeVersion = minKubeVersion;
    }

    /**
     * ClusterServiceVersionSpec declarations tell OLM how to install an operator that can manage apps for a given version.
     */
    @JsonProperty("nativeAPIs")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<GroupVersionKind> getNativeAPIs() {
        return nativeAPIs;
    }

    /**
     * ClusterServiceVersionSpec declarations tell OLM how to install an operator that can manage apps for a given version.
     */
    @JsonProperty("nativeAPIs")
    public void setNativeAPIs(List<GroupVersionKind> nativeAPIs) {
        this.nativeAPIs = nativeAPIs;
    }

    /**
     * ClusterServiceVersionSpec declarations tell OLM how to install an operator that can manage apps for a given version.
     */
    @JsonProperty("provider")
    public AppLink getProvider() {
        return provider;
    }

    /**
     * ClusterServiceVersionSpec declarations tell OLM how to install an operator that can manage apps for a given version.
     */
    @JsonProperty("provider")
    public void setProvider(AppLink provider) {
        this.provider = provider;
    }

    /**
     * List any related images, or other container images that your Operator might require to perform their functions. This list should also include operand images as well. All image references should be specified by digest (SHA) and not by tag. This field is only used during catalog creation and plays no part in cluster runtime.
     */
    @JsonProperty("relatedImages")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<RelatedImage> getRelatedImages() {
        return relatedImages;
    }

    /**
     * List any related images, or other container images that your Operator might require to perform their functions. This list should also include operand images as well. All image references should be specified by digest (SHA) and not by tag. This field is only used during catalog creation and plays no part in cluster runtime.
     */
    @JsonProperty("relatedImages")
    public void setRelatedImages(List<RelatedImage> relatedImages) {
        this.relatedImages = relatedImages;
    }

    /**
     * The name of a CSV this one replaces. Should match the `metadata.Name` field of the old CSV.
     */
    @JsonProperty("replaces")
    public String getReplaces() {
        return replaces;
    }

    /**
     * The name of a CSV this one replaces. Should match the `metadata.Name` field of the old CSV.
     */
    @JsonProperty("replaces")
    public void setReplaces(String replaces) {
        this.replaces = replaces;
    }

    /**
     * ClusterServiceVersionSpec declarations tell OLM how to install an operator that can manage apps for a given version.
     */
    @JsonProperty("selector")
    public LabelSelector getSelector() {
        return selector;
    }

    /**
     * ClusterServiceVersionSpec declarations tell OLM how to install an operator that can manage apps for a given version.
     */
    @JsonProperty("selector")
    public void setSelector(LabelSelector selector) {
        this.selector = selector;
    }

    /**
     * The name(s) of one or more CSV(s) that should be skipped in the upgrade graph. Should match the `metadata.Name` field of the CSV that should be skipped. This field is only used during catalog creation and plays no part in cluster runtime.
     */
    @JsonProperty("skips")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getSkips() {
        return skips;
    }

    /**
     * The name(s) of one or more CSV(s) that should be skipped in the upgrade graph. Should match the `metadata.Name` field of the CSV that should be skipped. This field is only used during catalog creation and plays no part in cluster runtime.
     */
    @JsonProperty("skips")
    public void setSkips(List<String> skips) {
        this.skips = skips;
    }

    /**
     * ClusterServiceVersionSpec declarations tell OLM how to install an operator that can manage apps for a given version.
     */
    @JsonProperty("version")
    public String getVersion() {
        return version;
    }

    /**
     * ClusterServiceVersionSpec declarations tell OLM how to install an operator that can manage apps for a given version.
     */
    @JsonProperty("version")
    public void setVersion(String version) {
        this.version = version;
    }

    /**
     * ClusterServiceVersionSpec declarations tell OLM how to install an operator that can manage apps for a given version.
     */
    @JsonProperty("webhookdefinitions")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<WebhookDescription> getWebhookdefinitions() {
        return webhookdefinitions;
    }

    /**
     * ClusterServiceVersionSpec declarations tell OLM how to install an operator that can manage apps for a given version.
     */
    @JsonProperty("webhookdefinitions")
    public void setWebhookdefinitions(List<WebhookDescription> webhookdefinitions) {
        this.webhookdefinitions = webhookdefinitions;
    }

    @JsonIgnore
    public ClusterServiceVersionSpecBuilder edit() {
        return new ClusterServiceVersionSpecBuilder(this);
    }

    @JsonIgnore
    public ClusterServiceVersionSpecBuilder toBuilder() {
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
