
package io.fabric8.openshift.api.model.operator.v1;

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
import io.fabric8.openshift.api.model.config.v1.ConfigMapFileReference;
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;

/**
 * ConsoleCustomization defines a list of optional configuration for the console UI. Ensure that Logos and CustomLogoFile cannot be set at the same time.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "addPage",
    "brand",
    "capabilities",
    "customLogoFile",
    "customProductName",
    "developerCatalog",
    "documentationBaseURL",
    "logos",
    "perspectives",
    "projectAccess",
    "quickStarts"
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
public class ConsoleCustomization implements Editable<ConsoleCustomizationBuilder>, KubernetesResource
{

    @JsonProperty("addPage")
    private AddPage addPage;
    @JsonProperty("brand")
    private String brand;
    @JsonProperty("capabilities")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<Capability> capabilities = new ArrayList<>();
    @JsonProperty("customLogoFile")
    private ConfigMapFileReference customLogoFile;
    @JsonProperty("customProductName")
    private String customProductName;
    @JsonProperty("developerCatalog")
    private DeveloperConsoleCatalogCustomization developerCatalog;
    @JsonProperty("documentationBaseURL")
    private String documentationBaseURL;
    @JsonProperty("logos")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<Logo> logos = new ArrayList<>();
    @JsonProperty("perspectives")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<Perspective> perspectives = new ArrayList<>();
    @JsonProperty("projectAccess")
    private ProjectAccess projectAccess;
    @JsonProperty("quickStarts")
    private QuickStarts quickStarts;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public ConsoleCustomization() {
    }

    public ConsoleCustomization(AddPage addPage, String brand, List<Capability> capabilities, ConfigMapFileReference customLogoFile, String customProductName, DeveloperConsoleCatalogCustomization developerCatalog, String documentationBaseURL, List<Logo> logos, List<Perspective> perspectives, ProjectAccess projectAccess, QuickStarts quickStarts) {
        super();
        this.addPage = addPage;
        this.brand = brand;
        this.capabilities = capabilities;
        this.customLogoFile = customLogoFile;
        this.customProductName = customProductName;
        this.developerCatalog = developerCatalog;
        this.documentationBaseURL = documentationBaseURL;
        this.logos = logos;
        this.perspectives = perspectives;
        this.projectAccess = projectAccess;
        this.quickStarts = quickStarts;
    }

    /**
     * ConsoleCustomization defines a list of optional configuration for the console UI. Ensure that Logos and CustomLogoFile cannot be set at the same time.
     */
    @JsonProperty("addPage")
    public AddPage getAddPage() {
        return addPage;
    }

    /**
     * ConsoleCustomization defines a list of optional configuration for the console UI. Ensure that Logos and CustomLogoFile cannot be set at the same time.
     */
    @JsonProperty("addPage")
    public void setAddPage(AddPage addPage) {
        this.addPage = addPage;
    }

    /**
     * brand is the default branding of the web console which can be overridden by providing the brand field.  There is a limited set of specific brand options. This field controls elements of the console such as the logo. Invalid value will prevent a console rollout.
     */
    @JsonProperty("brand")
    public String getBrand() {
        return brand;
    }

    /**
     * brand is the default branding of the web console which can be overridden by providing the brand field.  There is a limited set of specific brand options. This field controls elements of the console such as the logo. Invalid value will prevent a console rollout.
     */
    @JsonProperty("brand")
    public void setBrand(String brand) {
        this.brand = brand;
    }

    /**
     * capabilities defines an array of capabilities that can be interacted with in the console UI. Each capability defines a visual state that can be interacted with the console to render in the UI. Available capabilities are LightspeedButton and GettingStartedBanner. Each of the available capabilities may appear only once in the list.
     */
    @JsonProperty("capabilities")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<Capability> getCapabilities() {
        return capabilities;
    }

    /**
     * capabilities defines an array of capabilities that can be interacted with in the console UI. Each capability defines a visual state that can be interacted with the console to render in the UI. Available capabilities are LightspeedButton and GettingStartedBanner. Each of the available capabilities may appear only once in the list.
     */
    @JsonProperty("capabilities")
    public void setCapabilities(List<Capability> capabilities) {
        this.capabilities = capabilities;
    }

    /**
     * ConsoleCustomization defines a list of optional configuration for the console UI. Ensure that Logos and CustomLogoFile cannot be set at the same time.
     */
    @JsonProperty("customLogoFile")
    public ConfigMapFileReference getCustomLogoFile() {
        return customLogoFile;
    }

    /**
     * ConsoleCustomization defines a list of optional configuration for the console UI. Ensure that Logos and CustomLogoFile cannot be set at the same time.
     */
    @JsonProperty("customLogoFile")
    public void setCustomLogoFile(ConfigMapFileReference customLogoFile) {
        this.customLogoFile = customLogoFile;
    }

    /**
     * customProductName is the name that will be displayed in page titles, logo alt text, and the about dialog instead of the normal OpenShift product name.
     */
    @JsonProperty("customProductName")
    public String getCustomProductName() {
        return customProductName;
    }

    /**
     * customProductName is the name that will be displayed in page titles, logo alt text, and the about dialog instead of the normal OpenShift product name.
     */
    @JsonProperty("customProductName")
    public void setCustomProductName(String customProductName) {
        this.customProductName = customProductName;
    }

    /**
     * ConsoleCustomization defines a list of optional configuration for the console UI. Ensure that Logos and CustomLogoFile cannot be set at the same time.
     */
    @JsonProperty("developerCatalog")
    public DeveloperConsoleCatalogCustomization getDeveloperCatalog() {
        return developerCatalog;
    }

    /**
     * ConsoleCustomization defines a list of optional configuration for the console UI. Ensure that Logos and CustomLogoFile cannot be set at the same time.
     */
    @JsonProperty("developerCatalog")
    public void setDeveloperCatalog(DeveloperConsoleCatalogCustomization developerCatalog) {
        this.developerCatalog = developerCatalog;
    }

    /**
     * documentationBaseURL links to external documentation are shown in various sections of the web console.  Providing documentationBaseURL will override the default documentation URL. Invalid value will prevent a console rollout.
     */
    @JsonProperty("documentationBaseURL")
    public String getDocumentationBaseURL() {
        return documentationBaseURL;
    }

    /**
     * documentationBaseURL links to external documentation are shown in various sections of the web console.  Providing documentationBaseURL will override the default documentation URL. Invalid value will prevent a console rollout.
     */
    @JsonProperty("documentationBaseURL")
    public void setDocumentationBaseURL(String documentationBaseURL) {
        this.documentationBaseURL = documentationBaseURL;
    }

    /**
     * logos is used to replace the OpenShift Masthead and Favicon logos in the console UI with custom logos. logos is an optional field that allows a list of logos. Only one of logos or customLogoFile can be set at a time. If logos is set, customLogoFile must be unset. When specified, there must be at least one entry and no more than 2 entries. Each type must appear only once in the list.
     */
    @JsonProperty("logos")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<Logo> getLogos() {
        return logos;
    }

    /**
     * logos is used to replace the OpenShift Masthead and Favicon logos in the console UI with custom logos. logos is an optional field that allows a list of logos. Only one of logos or customLogoFile can be set at a time. If logos is set, customLogoFile must be unset. When specified, there must be at least one entry and no more than 2 entries. Each type must appear only once in the list.
     */
    @JsonProperty("logos")
    public void setLogos(List<Logo> logos) {
        this.logos = logos;
    }

    /**
     * perspectives allows enabling/disabling of perspective(s) that user can see in the Perspective switcher dropdown.
     */
    @JsonProperty("perspectives")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<Perspective> getPerspectives() {
        return perspectives;
    }

    /**
     * perspectives allows enabling/disabling of perspective(s) that user can see in the Perspective switcher dropdown.
     */
    @JsonProperty("perspectives")
    public void setPerspectives(List<Perspective> perspectives) {
        this.perspectives = perspectives;
    }

    /**
     * ConsoleCustomization defines a list of optional configuration for the console UI. Ensure that Logos and CustomLogoFile cannot be set at the same time.
     */
    @JsonProperty("projectAccess")
    public ProjectAccess getProjectAccess() {
        return projectAccess;
    }

    /**
     * ConsoleCustomization defines a list of optional configuration for the console UI. Ensure that Logos and CustomLogoFile cannot be set at the same time.
     */
    @JsonProperty("projectAccess")
    public void setProjectAccess(ProjectAccess projectAccess) {
        this.projectAccess = projectAccess;
    }

    /**
     * ConsoleCustomization defines a list of optional configuration for the console UI. Ensure that Logos and CustomLogoFile cannot be set at the same time.
     */
    @JsonProperty("quickStarts")
    public QuickStarts getQuickStarts() {
        return quickStarts;
    }

    /**
     * ConsoleCustomization defines a list of optional configuration for the console UI. Ensure that Logos and CustomLogoFile cannot be set at the same time.
     */
    @JsonProperty("quickStarts")
    public void setQuickStarts(QuickStarts quickStarts) {
        this.quickStarts = quickStarts;
    }

    @JsonIgnore
    public ConsoleCustomizationBuilder edit() {
        return new ConsoleCustomizationBuilder(this);
    }

    @JsonIgnore
    public ConsoleCustomizationBuilder toBuilder() {
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
        if (!(o instanceof ConsoleCustomization)) {
            return false;
        }
        ConsoleCustomization other = (ConsoleCustomization) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$addPage = this.getAddPage();
        Object other$addPage = other.getAddPage();
        if (this$addPage == null ? other$addPage != null : !this$addPage.equals(other$addPage)) {
            return false;
        }
        Object this$brand = this.getBrand();
        Object other$brand = other.getBrand();
        if (this$brand == null ? other$brand != null : !this$brand.equals(other$brand)) {
            return false;
        }
        Object this$capabilities = this.getCapabilities();
        Object other$capabilities = other.getCapabilities();
        if (this$capabilities == null ? other$capabilities != null : !this$capabilities.equals(other$capabilities)) {
            return false;
        }
        Object this$customLogoFile = this.getCustomLogoFile();
        Object other$customLogoFile = other.getCustomLogoFile();
        if (this$customLogoFile == null ? other$customLogoFile != null : !this$customLogoFile.equals(other$customLogoFile)) {
            return false;
        }
        Object this$customProductName = this.getCustomProductName();
        Object other$customProductName = other.getCustomProductName();
        if (this$customProductName == null ? other$customProductName != null : !this$customProductName.equals(other$customProductName)) {
            return false;
        }
        Object this$developerCatalog = this.getDeveloperCatalog();
        Object other$developerCatalog = other.getDeveloperCatalog();
        if (this$developerCatalog == null ? other$developerCatalog != null : !this$developerCatalog.equals(other$developerCatalog)) {
            return false;
        }
        Object this$documentationBaseURL = this.getDocumentationBaseURL();
        Object other$documentationBaseURL = other.getDocumentationBaseURL();
        if (this$documentationBaseURL == null ? other$documentationBaseURL != null : !this$documentationBaseURL.equals(other$documentationBaseURL)) {
            return false;
        }
        Object this$logos = this.getLogos();
        Object other$logos = other.getLogos();
        if (this$logos == null ? other$logos != null : !this$logos.equals(other$logos)) {
            return false;
        }
        Object this$perspectives = this.getPerspectives();
        Object other$perspectives = other.getPerspectives();
        if (this$perspectives == null ? other$perspectives != null : !this$perspectives.equals(other$perspectives)) {
            return false;
        }
        Object this$projectAccess = this.getProjectAccess();
        Object other$projectAccess = other.getProjectAccess();
        if (this$projectAccess == null ? other$projectAccess != null : !this$projectAccess.equals(other$projectAccess)) {
            return false;
        }
        Object this$quickStarts = this.getQuickStarts();
        Object other$quickStarts = other.getQuickStarts();
        if (this$quickStarts == null ? other$quickStarts != null : !this$quickStarts.equals(other$quickStarts)) {
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
        return other instanceof ConsoleCustomization;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $addPage = this.getAddPage();
        result = result * prime + ($addPage == null ? 43 : $addPage.hashCode());
        Object $brand = this.getBrand();
        result = result * prime + ($brand == null ? 43 : $brand.hashCode());
        Object $capabilities = this.getCapabilities();
        result = result * prime + ($capabilities == null ? 43 : $capabilities.hashCode());
        Object $customLogoFile = this.getCustomLogoFile();
        result = result * prime + ($customLogoFile == null ? 43 : $customLogoFile.hashCode());
        Object $customProductName = this.getCustomProductName();
        result = result * prime + ($customProductName == null ? 43 : $customProductName.hashCode());
        Object $developerCatalog = this.getDeveloperCatalog();
        result = result * prime + ($developerCatalog == null ? 43 : $developerCatalog.hashCode());
        Object $documentationBaseURL = this.getDocumentationBaseURL();
        result = result * prime + ($documentationBaseURL == null ? 43 : $documentationBaseURL.hashCode());
        Object $logos = this.getLogos();
        result = result * prime + ($logos == null ? 43 : $logos.hashCode());
        Object $perspectives = this.getPerspectives();
        result = result * prime + ($perspectives == null ? 43 : $perspectives.hashCode());
        Object $projectAccess = this.getProjectAccess();
        result = result * prime + ($projectAccess == null ? 43 : $projectAccess.hashCode());
        Object $quickStarts = this.getQuickStarts();
        result = result * prime + ($quickStarts == null ? 43 : $quickStarts.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "ConsoleCustomization(" + "addPage=" + this.getAddPage() + ", brand=" + this.getBrand() + ", capabilities=" + this.getCapabilities() + ", customLogoFile=" + this.getCustomLogoFile() + ", customProductName=" + this.getCustomProductName() + ", developerCatalog=" + this.getDeveloperCatalog() + ", documentationBaseURL=" + this.getDocumentationBaseURL() + ", logos=" + this.getLogos() + ", perspectives=" + this.getPerspectives() + ", projectAccess=" + this.getProjectAccess() + ", quickStarts=" + this.getQuickStarts() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
