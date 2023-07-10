
package io.fabric8.openshift.api.model.operator.v1;

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
import io.fabric8.kubernetes.api.model.IntOrString;
import io.fabric8.kubernetes.api.model.KubernetesResource;
import io.fabric8.kubernetes.api.model.LabelSelector;
import io.fabric8.kubernetes.api.model.LocalObjectReference;
import io.fabric8.kubernetes.api.model.ObjectMeta;
import io.fabric8.kubernetes.api.model.ObjectReference;
import io.fabric8.kubernetes.api.model.PersistentVolumeClaim;
import io.fabric8.kubernetes.api.model.PodTemplateSpec;
import io.fabric8.kubernetes.api.model.ResourceRequirements;
import io.fabric8.openshift.api.model.config.v1.ConfigMapFileReference;
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
    "addPage",
    "brand",
    "customLogoFile",
    "customProductName",
    "developerCatalog",
    "documentationBaseURL",
    "perspectives",
    "projectAccess",
    "quickStarts"
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
    @BuildableReference(PersistentVolumeClaim.class)
})
@Generated("jsonschema2pojo")
public class ConsoleCustomization implements KubernetesResource
{

    @JsonProperty("addPage")
    private AddPage addPage;
    @JsonProperty("brand")
    private String brand;
    @JsonProperty("customLogoFile")
    private ConfigMapFileReference customLogoFile;
    @JsonProperty("customProductName")
    private String customProductName;
    @JsonProperty("developerCatalog")
    private DeveloperConsoleCatalogCustomization developerCatalog;
    @JsonProperty("documentationBaseURL")
    private String documentationBaseURL;
    @JsonProperty("perspectives")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<Perspective> perspectives = new ArrayList<Perspective>();
    @JsonProperty("projectAccess")
    private ProjectAccess projectAccess;
    @JsonProperty("quickStarts")
    private QuickStarts quickStarts;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public ConsoleCustomization() {
    }

    public ConsoleCustomization(AddPage addPage, String brand, ConfigMapFileReference customLogoFile, String customProductName, DeveloperConsoleCatalogCustomization developerCatalog, String documentationBaseURL, List<Perspective> perspectives, ProjectAccess projectAccess, QuickStarts quickStarts) {
        super();
        this.addPage = addPage;
        this.brand = brand;
        this.customLogoFile = customLogoFile;
        this.customProductName = customProductName;
        this.developerCatalog = developerCatalog;
        this.documentationBaseURL = documentationBaseURL;
        this.perspectives = perspectives;
        this.projectAccess = projectAccess;
        this.quickStarts = quickStarts;
    }

    @JsonProperty("addPage")
    public AddPage getAddPage() {
        return addPage;
    }

    @JsonProperty("addPage")
    public void setAddPage(AddPage addPage) {
        this.addPage = addPage;
    }

    @JsonProperty("brand")
    public String getBrand() {
        return brand;
    }

    @JsonProperty("brand")
    public void setBrand(String brand) {
        this.brand = brand;
    }

    @JsonProperty("customLogoFile")
    public ConfigMapFileReference getCustomLogoFile() {
        return customLogoFile;
    }

    @JsonProperty("customLogoFile")
    public void setCustomLogoFile(ConfigMapFileReference customLogoFile) {
        this.customLogoFile = customLogoFile;
    }

    @JsonProperty("customProductName")
    public String getCustomProductName() {
        return customProductName;
    }

    @JsonProperty("customProductName")
    public void setCustomProductName(String customProductName) {
        this.customProductName = customProductName;
    }

    @JsonProperty("developerCatalog")
    public DeveloperConsoleCatalogCustomization getDeveloperCatalog() {
        return developerCatalog;
    }

    @JsonProperty("developerCatalog")
    public void setDeveloperCatalog(DeveloperConsoleCatalogCustomization developerCatalog) {
        this.developerCatalog = developerCatalog;
    }

    @JsonProperty("documentationBaseURL")
    public String getDocumentationBaseURL() {
        return documentationBaseURL;
    }

    @JsonProperty("documentationBaseURL")
    public void setDocumentationBaseURL(String documentationBaseURL) {
        this.documentationBaseURL = documentationBaseURL;
    }

    @JsonProperty("perspectives")
    public List<Perspective> getPerspectives() {
        return perspectives;
    }

    @JsonProperty("perspectives")
    public void setPerspectives(List<Perspective> perspectives) {
        this.perspectives = perspectives;
    }

    @JsonProperty("projectAccess")
    public ProjectAccess getProjectAccess() {
        return projectAccess;
    }

    @JsonProperty("projectAccess")
    public void setProjectAccess(ProjectAccess projectAccess) {
        this.projectAccess = projectAccess;
    }

    @JsonProperty("quickStarts")
    public QuickStarts getQuickStarts() {
        return quickStarts;
    }

    @JsonProperty("quickStarts")
    public void setQuickStarts(QuickStarts quickStarts) {
        this.quickStarts = quickStarts;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
