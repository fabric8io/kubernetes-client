
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
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

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

}
