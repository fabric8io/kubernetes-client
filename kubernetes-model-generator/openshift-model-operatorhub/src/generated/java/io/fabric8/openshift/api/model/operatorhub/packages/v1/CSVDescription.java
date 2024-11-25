
package io.fabric8.openshift.api.model.operatorhub.packages.v1;

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
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

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
     * 
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

    @JsonProperty("annotations")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
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

    @JsonProperty("customresourcedefinitions")
    public CustomResourceDefinitions getCustomresourcedefinitions() {
        return customresourcedefinitions;
    }

    @JsonProperty("customresourcedefinitions")
    public void setCustomresourcedefinitions(CustomResourceDefinitions customresourcedefinitions) {
        this.customresourcedefinitions = customresourcedefinitions;
    }

    @JsonProperty("description")
    public String getDescription() {
        return description;
    }

    @JsonProperty("description")
    public void setDescription(String description) {
        this.description = description;
    }

    @JsonProperty("displayName")
    public String getDisplayName() {
        return displayName;
    }

    @JsonProperty("displayName")
    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    @JsonProperty("icon")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<Icon> getIcon() {
        return icon;
    }

    @JsonProperty("icon")
    public void setIcon(List<Icon> icon) {
        this.icon = icon;
    }

    @JsonProperty("installModes")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<InstallMode> getInstallModes() {
        return installModes;
    }

    @JsonProperty("installModes")
    public void setInstallModes(List<InstallMode> installModes) {
        this.installModes = installModes;
    }

    @JsonProperty("keywords")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getKeywords() {
        return keywords;
    }

    @JsonProperty("keywords")
    public void setKeywords(List<String> keywords) {
        this.keywords = keywords;
    }

    @JsonProperty("links")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<AppLink> getLinks() {
        return links;
    }

    @JsonProperty("links")
    public void setLinks(List<AppLink> links) {
        this.links = links;
    }

    @JsonProperty("maintainers")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<Maintainer> getMaintainers() {
        return maintainers;
    }

    @JsonProperty("maintainers")
    public void setMaintainers(List<Maintainer> maintainers) {
        this.maintainers = maintainers;
    }

    @JsonProperty("maturity")
    public String getMaturity() {
        return maturity;
    }

    @JsonProperty("maturity")
    public void setMaturity(String maturity) {
        this.maturity = maturity;
    }

    @JsonProperty("minKubeVersion")
    public String getMinKubeVersion() {
        return minKubeVersion;
    }

    @JsonProperty("minKubeVersion")
    public void setMinKubeVersion(String minKubeVersion) {
        this.minKubeVersion = minKubeVersion;
    }

    @JsonProperty("nativeApis")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<GroupVersionKind> getNativeApis() {
        return nativeApis;
    }

    @JsonProperty("nativeApis")
    public void setNativeApis(List<GroupVersionKind> nativeApis) {
        this.nativeApis = nativeApis;
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
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getRelatedImages() {
        return relatedImages;
    }

    @JsonProperty("relatedImages")
    public void setRelatedImages(List<String> relatedImages) {
        this.relatedImages = relatedImages;
    }

    @JsonProperty("version")
    public String getVersion() {
        return version;
    }

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
