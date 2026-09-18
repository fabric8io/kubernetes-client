
package io.fabric8.openshift.api.model.operatorhub.packages.v1;

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
import io.fabric8.openshift.api.model.operatorhub.v1alpha1.APIServiceDefinitions;
import io.fabric8.openshift.api.model.operatorhub.v1alpha1.CustomResourceDefinitions;
import io.fabric8.openshift.api.model.operatorhub.v1alpha1.InstallMode;
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;

/**
 * CSVDescription defines a description of a CSV
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "annotations",
    "apiservicedefinitions",
    "customresourcedefinitions",
    "description",
    "displayName",
    "icon",
    "installModes",
    "keywords",
    "links",
    "maintainers",
    "maturity",
    "minKubeVersion",
    "nativeApis",
    "provider",
    "relatedImages",
    "version"
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
public class CSVDescription implements Editable<CSVDescriptionBuilder>, KubernetesResource
{

    @JsonProperty("annotations")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Map<String, String> annotations = new LinkedHashMap<>();
    @JsonProperty("apiservicedefinitions")
    private APIServiceDefinitions apiservicedefinitions;
    @JsonProperty("customresourcedefinitions")
    private CustomResourceDefinitions customresourcedefinitions;
    @JsonProperty("description")
    private String description;
    @JsonProperty("displayName")
    private String displayName;
    @JsonProperty("icon")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<Icon> icon = new ArrayList<>();
    @JsonProperty("installModes")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<InstallMode> installModes = new ArrayList<>();
    @JsonProperty("keywords")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> keywords = new ArrayList<>();
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
    @JsonProperty("nativeApis")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<GroupVersionKind> nativeApis = new ArrayList<>();
    @JsonProperty("provider")
    private AppLink provider;
    @JsonProperty("relatedImages")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> relatedImages = new ArrayList<>();
    @JsonProperty("version")
    private String version;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public CSVDescription() {
    }

    public CSVDescription(Map<String, String> annotations, APIServiceDefinitions apiservicedefinitions, CustomResourceDefinitions customresourcedefinitions, String description, String displayName, List<Icon> icon, List<InstallMode> installModes, List<String> keywords, List<AppLink> links, List<Maintainer> maintainers, String maturity, String minKubeVersion, List<GroupVersionKind> nativeApis, AppLink provider, List<String> relatedImages, String version) {
        super();
        this.annotations = annotations;
        this.apiservicedefinitions = apiservicedefinitions;
        this.customresourcedefinitions = customresourcedefinitions;
        this.description = description;
        this.displayName = displayName;
        this.icon = icon;
        this.installModes = installModes;
        this.keywords = keywords;
        this.links = links;
        this.maintainers = maintainers;
        this.maturity = maturity;
        this.minKubeVersion = minKubeVersion;
        this.nativeApis = nativeApis;
        this.provider = provider;
        this.relatedImages = relatedImages;
        this.version = version;
    }

    /**
     * CSVDescription defines a description of a CSV
     */
    @JsonProperty("annotations")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public Map<String, String> getAnnotations() {
        return annotations;
    }

    /**
     * CSVDescription defines a description of a CSV
     */
    @JsonProperty("annotations")
    public void setAnnotations(Map<String, String> annotations) {
        this.annotations = annotations;
    }

    /**
     * CSVDescription defines a description of a CSV
     */
    @JsonProperty("apiservicedefinitions")
    public APIServiceDefinitions getApiservicedefinitions() {
        return apiservicedefinitions;
    }

    /**
     * CSVDescription defines a description of a CSV
     */
    @JsonProperty("apiservicedefinitions")
    public void setApiservicedefinitions(APIServiceDefinitions apiservicedefinitions) {
        this.apiservicedefinitions = apiservicedefinitions;
    }

    /**
     * CSVDescription defines a description of a CSV
     */
    @JsonProperty("customresourcedefinitions")
    public CustomResourceDefinitions getCustomresourcedefinitions() {
        return customresourcedefinitions;
    }

    /**
     * CSVDescription defines a description of a CSV
     */
    @JsonProperty("customresourcedefinitions")
    public void setCustomresourcedefinitions(CustomResourceDefinitions customresourcedefinitions) {
        this.customresourcedefinitions = customresourcedefinitions;
    }

    /**
     * LongDescription is the CSV's description
     */
    @JsonProperty("description")
    public String getDescription() {
        return description;
    }

    /**
     * LongDescription is the CSV's description
     */
    @JsonProperty("description")
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * DisplayName is the CSV's display name
     */
    @JsonProperty("displayName")
    public String getDisplayName() {
        return displayName;
    }

    /**
     * DisplayName is the CSV's display name
     */
    @JsonProperty("displayName")
    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    /**
     * Icon is the CSV's base64 encoded icon
     */
    @JsonProperty("icon")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<Icon> getIcon() {
        return icon;
    }

    /**
     * Icon is the CSV's base64 encoded icon
     */
    @JsonProperty("icon")
    public void setIcon(List<Icon> icon) {
        this.icon = icon;
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
     * CSVDescription defines a description of a CSV
     */
    @JsonProperty("keywords")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getKeywords() {
        return keywords;
    }

    /**
     * CSVDescription defines a description of a CSV
     */
    @JsonProperty("keywords")
    public void setKeywords(List<String> keywords) {
        this.keywords = keywords;
    }

    /**
     * CSVDescription defines a description of a CSV
     */
    @JsonProperty("links")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<AppLink> getLinks() {
        return links;
    }

    /**
     * CSVDescription defines a description of a CSV
     */
    @JsonProperty("links")
    public void setLinks(List<AppLink> links) {
        this.links = links;
    }

    /**
     * CSVDescription defines a description of a CSV
     */
    @JsonProperty("maintainers")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<Maintainer> getMaintainers() {
        return maintainers;
    }

    /**
     * CSVDescription defines a description of a CSV
     */
    @JsonProperty("maintainers")
    public void setMaintainers(List<Maintainer> maintainers) {
        this.maintainers = maintainers;
    }

    /**
     * CSVDescription defines a description of a CSV
     */
    @JsonProperty("maturity")
    public String getMaturity() {
        return maturity;
    }

    /**
     * CSVDescription defines a description of a CSV
     */
    @JsonProperty("maturity")
    public void setMaturity(String maturity) {
        this.maturity = maturity;
    }

    /**
     * Minimum Kubernetes version for operator installation
     */
    @JsonProperty("minKubeVersion")
    public String getMinKubeVersion() {
        return minKubeVersion;
    }

    /**
     * Minimum Kubernetes version for operator installation
     */
    @JsonProperty("minKubeVersion")
    public void setMinKubeVersion(String minKubeVersion) {
        this.minKubeVersion = minKubeVersion;
    }

    /**
     * CSVDescription defines a description of a CSV
     */
    @JsonProperty("nativeApis")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<GroupVersionKind> getNativeApis() {
        return nativeApis;
    }

    /**
     * CSVDescription defines a description of a CSV
     */
    @JsonProperty("nativeApis")
    public void setNativeApis(List<GroupVersionKind> nativeApis) {
        this.nativeApis = nativeApis;
    }

    /**
     * CSVDescription defines a description of a CSV
     */
    @JsonProperty("provider")
    public AppLink getProvider() {
        return provider;
    }

    /**
     * CSVDescription defines a description of a CSV
     */
    @JsonProperty("provider")
    public void setProvider(AppLink provider) {
        this.provider = provider;
    }

    /**
     * List of related images
     */
    @JsonProperty("relatedImages")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getRelatedImages() {
        return relatedImages;
    }

    /**
     * List of related images
     */
    @JsonProperty("relatedImages")
    public void setRelatedImages(List<String> relatedImages) {
        this.relatedImages = relatedImages;
    }

    /**
     * CSVDescription defines a description of a CSV
     */
    @JsonProperty("version")
    public String getVersion() {
        return version;
    }

    /**
     * CSVDescription defines a description of a CSV
     */
    @JsonProperty("version")
    public void setVersion(String version) {
        this.version = version;
    }

    @JsonIgnore
    public CSVDescriptionBuilder edit() {
        return new CSVDescriptionBuilder(this);
    }

    @JsonIgnore
    public CSVDescriptionBuilder toBuilder() {
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
        if (!(o instanceof CSVDescription)) {
            return false;
        }
        CSVDescription other = (CSVDescription) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$annotations = this.getAnnotations();
        Object other$annotations = other.getAnnotations();
        if (this$annotations == null ? other$annotations != null : !this$annotations.equals(other$annotations)) {
            return false;
        }
        Object this$apiservicedefinitions = this.getApiservicedefinitions();
        Object other$apiservicedefinitions = other.getApiservicedefinitions();
        if (this$apiservicedefinitions == null ? other$apiservicedefinitions != null : !this$apiservicedefinitions.equals(other$apiservicedefinitions)) {
            return false;
        }
        Object this$customresourcedefinitions = this.getCustomresourcedefinitions();
        Object other$customresourcedefinitions = other.getCustomresourcedefinitions();
        if (this$customresourcedefinitions == null ? other$customresourcedefinitions != null : !this$customresourcedefinitions.equals(other$customresourcedefinitions)) {
            return false;
        }
        Object this$description = this.getDescription();
        Object other$description = other.getDescription();
        if (this$description == null ? other$description != null : !this$description.equals(other$description)) {
            return false;
        }
        Object this$displayName = this.getDisplayName();
        Object other$displayName = other.getDisplayName();
        if (this$displayName == null ? other$displayName != null : !this$displayName.equals(other$displayName)) {
            return false;
        }
        Object this$icon = this.getIcon();
        Object other$icon = other.getIcon();
        if (this$icon == null ? other$icon != null : !this$icon.equals(other$icon)) {
            return false;
        }
        Object this$installModes = this.getInstallModes();
        Object other$installModes = other.getInstallModes();
        if (this$installModes == null ? other$installModes != null : !this$installModes.equals(other$installModes)) {
            return false;
        }
        Object this$keywords = this.getKeywords();
        Object other$keywords = other.getKeywords();
        if (this$keywords == null ? other$keywords != null : !this$keywords.equals(other$keywords)) {
            return false;
        }
        Object this$links = this.getLinks();
        Object other$links = other.getLinks();
        if (this$links == null ? other$links != null : !this$links.equals(other$links)) {
            return false;
        }
        Object this$maintainers = this.getMaintainers();
        Object other$maintainers = other.getMaintainers();
        if (this$maintainers == null ? other$maintainers != null : !this$maintainers.equals(other$maintainers)) {
            return false;
        }
        Object this$maturity = this.getMaturity();
        Object other$maturity = other.getMaturity();
        if (this$maturity == null ? other$maturity != null : !this$maturity.equals(other$maturity)) {
            return false;
        }
        Object this$minKubeVersion = this.getMinKubeVersion();
        Object other$minKubeVersion = other.getMinKubeVersion();
        if (this$minKubeVersion == null ? other$minKubeVersion != null : !this$minKubeVersion.equals(other$minKubeVersion)) {
            return false;
        }
        Object this$nativeApis = this.getNativeApis();
        Object other$nativeApis = other.getNativeApis();
        if (this$nativeApis == null ? other$nativeApis != null : !this$nativeApis.equals(other$nativeApis)) {
            return false;
        }
        Object this$provider = this.getProvider();
        Object other$provider = other.getProvider();
        if (this$provider == null ? other$provider != null : !this$provider.equals(other$provider)) {
            return false;
        }
        Object this$relatedImages = this.getRelatedImages();
        Object other$relatedImages = other.getRelatedImages();
        if (this$relatedImages == null ? other$relatedImages != null : !this$relatedImages.equals(other$relatedImages)) {
            return false;
        }
        Object this$version = this.getVersion();
        Object other$version = other.getVersion();
        if (this$version == null ? other$version != null : !this$version.equals(other$version)) {
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
        return other instanceof CSVDescription;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $annotations = this.getAnnotations();
        result = result * prime + ($annotations == null ? 43 : $annotations.hashCode());
        Object $apiservicedefinitions = this.getApiservicedefinitions();
        result = result * prime + ($apiservicedefinitions == null ? 43 : $apiservicedefinitions.hashCode());
        Object $customresourcedefinitions = this.getCustomresourcedefinitions();
        result = result * prime + ($customresourcedefinitions == null ? 43 : $customresourcedefinitions.hashCode());
        Object $description = this.getDescription();
        result = result * prime + ($description == null ? 43 : $description.hashCode());
        Object $displayName = this.getDisplayName();
        result = result * prime + ($displayName == null ? 43 : $displayName.hashCode());
        Object $icon = this.getIcon();
        result = result * prime + ($icon == null ? 43 : $icon.hashCode());
        Object $installModes = this.getInstallModes();
        result = result * prime + ($installModes == null ? 43 : $installModes.hashCode());
        Object $keywords = this.getKeywords();
        result = result * prime + ($keywords == null ? 43 : $keywords.hashCode());
        Object $links = this.getLinks();
        result = result * prime + ($links == null ? 43 : $links.hashCode());
        Object $maintainers = this.getMaintainers();
        result = result * prime + ($maintainers == null ? 43 : $maintainers.hashCode());
        Object $maturity = this.getMaturity();
        result = result * prime + ($maturity == null ? 43 : $maturity.hashCode());
        Object $minKubeVersion = this.getMinKubeVersion();
        result = result * prime + ($minKubeVersion == null ? 43 : $minKubeVersion.hashCode());
        Object $nativeApis = this.getNativeApis();
        result = result * prime + ($nativeApis == null ? 43 : $nativeApis.hashCode());
        Object $provider = this.getProvider();
        result = result * prime + ($provider == null ? 43 : $provider.hashCode());
        Object $relatedImages = this.getRelatedImages();
        result = result * prime + ($relatedImages == null ? 43 : $relatedImages.hashCode());
        Object $version = this.getVersion();
        result = result * prime + ($version == null ? 43 : $version.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "CSVDescription(" + "annotations=" + this.getAnnotations() + ", apiservicedefinitions=" + this.getApiservicedefinitions() + ", customresourcedefinitions=" + this.getCustomresourcedefinitions() + ", description=" + this.getDescription() + ", displayName=" + this.getDisplayName() + ", icon=" + this.getIcon() + ", installModes=" + this.getInstallModes() + ", keywords=" + this.getKeywords() + ", links=" + this.getLinks() + ", maintainers=" + this.getMaintainers() + ", maturity=" + this.getMaturity() + ", minKubeVersion=" + this.getMinKubeVersion() + ", nativeApis=" + this.getNativeApis() + ", provider=" + this.getProvider() + ", relatedImages=" + this.getRelatedImages() + ", version=" + this.getVersion() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
