
package io.fabric8.openshift.api.model.operatorhub.v1alpha1;

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
import io.fabric8.kubernetes.api.model.Container;
import io.fabric8.kubernetes.api.model.GroupVersionKind;
import io.fabric8.kubernetes.api.model.IntOrString;
import io.fabric8.kubernetes.api.model.KubernetesResource;
import io.fabric8.kubernetes.api.model.LocalObjectReference;
import io.fabric8.kubernetes.api.model.ObjectMeta;
import io.fabric8.kubernetes.api.model.ObjectReference;
import io.fabric8.kubernetes.api.model.PersistentVolumeClaim;
import io.fabric8.kubernetes.api.model.PodTemplateSpec;
import io.fabric8.kubernetes.api.model.ResourceRequirements;
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
@Setter
@Accessors(prefix = {
    "_",
    ""
})
@Buildable(editableEnabled = false, validationEnabled = false, generateBuilderPackage = false, lazyCollectionInitEnabled = false, builderPackage = "io.fabric8.kubernetes.api.builder", refs = {
    @BuildableReference(ObjectMeta.class),
    @BuildableReference(io.fabric8.kubernetes.api.model.LabelSelector.class),
    @BuildableReference(Container.class),
    @BuildableReference(PodTemplateSpec.class),
    @BuildableReference(ResourceRequirements.class),
    @BuildableReference(IntOrString.class),
    @BuildableReference(ObjectReference.class),
    @BuildableReference(LocalObjectReference.class),
    @BuildableReference(PersistentVolumeClaim.class)
})
@Generated("jsonschema2pojo")
public class ClusterServiceVersionSpec implements KubernetesResource
{

    @JsonProperty("annotations")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Map<String, String> annotations = new LinkedHashMap<String, String>();
    @JsonProperty("apiservicedefinitions")
    private APIServiceDefinitions apiservicedefinitions;
    @JsonProperty("cleanup")
    private CleanupSpec cleanup;
    @JsonProperty("customresourcedefinitions")
    private CustomResourceDefinitions customresourcedefinitions;
    @JsonProperty("description")
    private java.lang.String description;
    @JsonProperty("displayName")
    private java.lang.String displayName;
    @JsonProperty("icon")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<Icon> icon = new ArrayList<Icon>();
    @JsonProperty("install")
    private NamedInstallStrategy install;
    @JsonProperty("installModes")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<InstallMode> installModes = new ArrayList<InstallMode>();
    @JsonProperty("keywords")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<java.lang.String> keywords = new ArrayList<java.lang.String>();
    @JsonProperty("labels")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Map<String, String> labels = new LinkedHashMap<String, String>();
    @JsonProperty("links")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<AppLink> links = new ArrayList<AppLink>();
    @JsonProperty("maintainers")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<Maintainer> maintainers = new ArrayList<Maintainer>();
    @JsonProperty("maturity")
    private java.lang.String maturity;
    @JsonProperty("minKubeVersion")
    private java.lang.String minKubeVersion;
    @JsonProperty("nativeAPIs")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<GroupVersionKind> nativeAPIs = new ArrayList<GroupVersionKind>();
    @JsonProperty("provider")
    private AppLink provider;
    @JsonProperty("relatedImages")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<RelatedImage> relatedImages = new ArrayList<RelatedImage>();
    @JsonProperty("replaces")
    private java.lang.String replaces;
    @JsonProperty("selector")
    private io.fabric8.kubernetes.api.model.LabelSelector selector;
    @JsonProperty("skips")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<java.lang.String> skips = new ArrayList<java.lang.String>();
    @JsonProperty("version")
    private java.lang.String version;
    @JsonProperty("webhookdefinitions")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<WebhookDescription> webhookdefinitions = new ArrayList<WebhookDescription>();
    @JsonIgnore
    private Map<java.lang.String, Object> additionalProperties = new LinkedHashMap<java.lang.String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public ClusterServiceVersionSpec() {
    }

    public ClusterServiceVersionSpec(Map<String, String> annotations, APIServiceDefinitions apiservicedefinitions, CleanupSpec cleanup, CustomResourceDefinitions customresourcedefinitions, java.lang.String description, java.lang.String displayName, List<Icon> icon, NamedInstallStrategy install, List<InstallMode> installModes, List<java.lang.String> keywords, Map<String, String> labels, List<AppLink> links, List<Maintainer> maintainers, java.lang.String maturity, java.lang.String minKubeVersion, List<GroupVersionKind> nativeAPIs, AppLink provider, List<RelatedImage> relatedImages, java.lang.String replaces, io.fabric8.kubernetes.api.model.LabelSelector selector, List<java.lang.String> skips, java.lang.String version, List<WebhookDescription> webhookdefinitions) {
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

    @JsonProperty("annotations")
    public Map<String, String> getAnnotations() {
        return annotations;
    }

    @JsonProperty("annotations")
    public void setAnnotations(Map<String, String> annotations) {
        this.annotations = annotations;
    }

    @JsonProperty("apiservicedefinitions")
    public APIServiceDefinitions getApiservicedefinitions() {
        return apiservicedefinitions;
    }

    @JsonProperty("apiservicedefinitions")
    public void setApiservicedefinitions(APIServiceDefinitions apiservicedefinitions) {
        this.apiservicedefinitions = apiservicedefinitions;
    }

    @JsonProperty("cleanup")
    public CleanupSpec getCleanup() {
        return cleanup;
    }

    @JsonProperty("cleanup")
    public void setCleanup(CleanupSpec cleanup) {
        this.cleanup = cleanup;
    }

    @JsonProperty("customresourcedefinitions")
    public CustomResourceDefinitions getCustomresourcedefinitions() {
        return customresourcedefinitions;
    }

    @JsonProperty("customresourcedefinitions")
    public void setCustomresourcedefinitions(CustomResourceDefinitions customresourcedefinitions) {
        this.customresourcedefinitions = customresourcedefinitions;
    }

    @JsonProperty("description")
    public java.lang.String getDescription() {
        return description;
    }

    @JsonProperty("description")
    public void setDescription(java.lang.String description) {
        this.description = description;
    }

    @JsonProperty("displayName")
    public java.lang.String getDisplayName() {
        return displayName;
    }

    @JsonProperty("displayName")
    public void setDisplayName(java.lang.String displayName) {
        this.displayName = displayName;
    }

    @JsonProperty("icon")
    public List<Icon> getIcon() {
        return icon;
    }

    @JsonProperty("icon")
    public void setIcon(List<Icon> icon) {
        this.icon = icon;
    }

    @JsonProperty("install")
    public NamedInstallStrategy getInstall() {
        return install;
    }

    @JsonProperty("install")
    public void setInstall(NamedInstallStrategy install) {
        this.install = install;
    }

    @JsonProperty("installModes")
    public List<InstallMode> getInstallModes() {
        return installModes;
    }

    @JsonProperty("installModes")
    public void setInstallModes(List<InstallMode> installModes) {
        this.installModes = installModes;
    }

    @JsonProperty("keywords")
    public List<java.lang.String> getKeywords() {
        return keywords;
    }

    @JsonProperty("keywords")
    public void setKeywords(List<java.lang.String> keywords) {
        this.keywords = keywords;
    }

    @JsonProperty("labels")
    public Map<String, String> getLabels() {
        return labels;
    }

    @JsonProperty("labels")
    public void setLabels(Map<String, String> labels) {
        this.labels = labels;
    }

    @JsonProperty("links")
    public List<AppLink> getLinks() {
        return links;
    }

    @JsonProperty("links")
    public void setLinks(List<AppLink> links) {
        this.links = links;
    }

    @JsonProperty("maintainers")
    public List<Maintainer> getMaintainers() {
        return maintainers;
    }

    @JsonProperty("maintainers")
    public void setMaintainers(List<Maintainer> maintainers) {
        this.maintainers = maintainers;
    }

    @JsonProperty("maturity")
    public java.lang.String getMaturity() {
        return maturity;
    }

    @JsonProperty("maturity")
    public void setMaturity(java.lang.String maturity) {
        this.maturity = maturity;
    }

    @JsonProperty("minKubeVersion")
    public java.lang.String getMinKubeVersion() {
        return minKubeVersion;
    }

    @JsonProperty("minKubeVersion")
    public void setMinKubeVersion(java.lang.String minKubeVersion) {
        this.minKubeVersion = minKubeVersion;
    }

    @JsonProperty("nativeAPIs")
    public List<GroupVersionKind> getNativeAPIs() {
        return nativeAPIs;
    }

    @JsonProperty("nativeAPIs")
    public void setNativeAPIs(List<GroupVersionKind> nativeAPIs) {
        this.nativeAPIs = nativeAPIs;
    }

    @JsonProperty("provider")
    public AppLink getProvider() {
        return provider;
    }

    @JsonProperty("provider")
    public void setProvider(AppLink provider) {
        this.provider = provider;
    }

    @JsonProperty("relatedImages")
    public List<RelatedImage> getRelatedImages() {
        return relatedImages;
    }

    @JsonProperty("relatedImages")
    public void setRelatedImages(List<RelatedImage> relatedImages) {
        this.relatedImages = relatedImages;
    }

    @JsonProperty("replaces")
    public java.lang.String getReplaces() {
        return replaces;
    }

    @JsonProperty("replaces")
    public void setReplaces(java.lang.String replaces) {
        this.replaces = replaces;
    }

    @JsonProperty("selector")
    public io.fabric8.kubernetes.api.model.LabelSelector getSelector() {
        return selector;
    }

    @JsonProperty("selector")
    public void setSelector(io.fabric8.kubernetes.api.model.LabelSelector selector) {
        this.selector = selector;
    }

    @JsonProperty("skips")
    public List<java.lang.String> getSkips() {
        return skips;
    }

    @JsonProperty("skips")
    public void setSkips(List<java.lang.String> skips) {
        this.skips = skips;
    }

    @JsonProperty("version")
    public java.lang.String getVersion() {
        return version;
    }

    @JsonProperty("version")
    public void setVersion(java.lang.String version) {
        this.version = version;
    }

    @JsonProperty("webhookdefinitions")
    public List<WebhookDescription> getWebhookdefinitions() {
        return webhookdefinitions;
    }

    @JsonProperty("webhookdefinitions")
    public void setWebhookdefinitions(List<WebhookDescription> webhookdefinitions) {
        this.webhookdefinitions = webhookdefinitions;
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
