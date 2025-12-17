
package io.fabric8.openshift.api.model.miscellaneous.clusterapi.infrastructure.v1beta1;

import java.util.LinkedHashMap;
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
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * AzureComputeGalleryImage defines an image in the Azure Compute Gallery to use for VM creation.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "gallery",
    "name",
    "plan",
    "resourceGroup",
    "subscriptionID",
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
public class AzureComputeGalleryImage implements Editable<AzureComputeGalleryImageBuilder>, KubernetesResource
{

    @JsonProperty("gallery")
    private String gallery;
    @JsonProperty("name")
    private String name;
    @JsonProperty("plan")
    private ImagePlan plan;
    @JsonProperty("resourceGroup")
    private String resourceGroup;
    @JsonProperty("subscriptionID")
    private String subscriptionID;
    @JsonProperty("version")
    private String version;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public AzureComputeGalleryImage() {
    }

    public AzureComputeGalleryImage(String gallery, String name, ImagePlan plan, String resourceGroup, String subscriptionID, String version) {
        super();
        this.gallery = gallery;
        this.name = name;
        this.plan = plan;
        this.resourceGroup = resourceGroup;
        this.subscriptionID = subscriptionID;
        this.version = version;
    }

    /**
     * Gallery specifies the name of the compute image gallery that contains the image
     */
    @JsonProperty("gallery")
    public String getGallery() {
        return gallery;
    }

    /**
     * Gallery specifies the name of the compute image gallery that contains the image
     */
    @JsonProperty("gallery")
    public void setGallery(String gallery) {
        this.gallery = gallery;
    }

    /**
     * Name is the name of the image
     */
    @JsonProperty("name")
    public String getName() {
        return name;
    }

    /**
     * Name is the name of the image
     */
    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    /**
     * AzureComputeGalleryImage defines an image in the Azure Compute Gallery to use for VM creation.
     */
    @JsonProperty("plan")
    public ImagePlan getPlan() {
        return plan;
    }

    /**
     * AzureComputeGalleryImage defines an image in the Azure Compute Gallery to use for VM creation.
     */
    @JsonProperty("plan")
    public void setPlan(ImagePlan plan) {
        this.plan = plan;
    }

    /**
     * ResourceGroup specifies the resource group containing the private compute gallery.
     */
    @JsonProperty("resourceGroup")
    public String getResourceGroup() {
        return resourceGroup;
    }

    /**
     * ResourceGroup specifies the resource group containing the private compute gallery.
     */
    @JsonProperty("resourceGroup")
    public void setResourceGroup(String resourceGroup) {
        this.resourceGroup = resourceGroup;
    }

    /**
     * SubscriptionID is the identifier of the subscription that contains the private compute gallery.
     */
    @JsonProperty("subscriptionID")
    public String getSubscriptionID() {
        return subscriptionID;
    }

    /**
     * SubscriptionID is the identifier of the subscription that contains the private compute gallery.
     */
    @JsonProperty("subscriptionID")
    public void setSubscriptionID(String subscriptionID) {
        this.subscriptionID = subscriptionID;
    }

    /**
     * Version specifies the version of the marketplace image. The allowed formats are Major.Minor.Build or 'latest'. Major, Minor, and Build are decimal numbers. Specify 'latest' to use the latest version of an image available at deploy time. Even if you use 'latest', the VM image will not automatically update after deploy time even if a new version becomes available.
     */
    @JsonProperty("version")
    public String getVersion() {
        return version;
    }

    /**
     * Version specifies the version of the marketplace image. The allowed formats are Major.Minor.Build or 'latest'. Major, Minor, and Build are decimal numbers. Specify 'latest' to use the latest version of an image available at deploy time. Even if you use 'latest', the VM image will not automatically update after deploy time even if a new version becomes available.
     */
    @JsonProperty("version")
    public void setVersion(String version) {
        this.version = version;
    }

    @JsonIgnore
    public AzureComputeGalleryImageBuilder edit() {
        return new AzureComputeGalleryImageBuilder(this);
    }

    @JsonIgnore
    public AzureComputeGalleryImageBuilder toBuilder() {
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
