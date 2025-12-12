
package io.fabric8.kubernetes.api.model.clusterapi.v1beta1;

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
 * Image defines information about the image to use for VM creation. There are three ways to specify an image: by ID, Marketplace Image or SharedImageGallery One of ID, SharedImage or Marketplace should be set.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "computeGallery",
    "id",
    "marketplace",
    "sharedGallery"
})
@ToString
@EqualsAndHashCode
@Accessors(prefix = {
    "_",
    ""
})
@Buildable(editableEnabled = false, validationEnabled = false, generateBuilderPackage = false, lazyCollectionInitEnabled = false, builderPackage = "io.fabric8.kubernetes.api.builder", refs = {
    @BuildableReference(io.fabric8.kubernetes.api.model.ObjectMeta.class),
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
public class Image implements Editable<ImageBuilder>, KubernetesResource
{

    @JsonProperty("computeGallery")
    private AzureComputeGalleryImage computeGallery;
    @JsonProperty("id")
    private String id;
    @JsonProperty("marketplace")
    private AzureMarketplaceImage marketplace;
    @JsonProperty("sharedGallery")
    private AzureSharedGalleryImage sharedGallery;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public Image() {
    }

    public Image(AzureComputeGalleryImage computeGallery, String id, AzureMarketplaceImage marketplace, AzureSharedGalleryImage sharedGallery) {
        super();
        this.computeGallery = computeGallery;
        this.id = id;
        this.marketplace = marketplace;
        this.sharedGallery = sharedGallery;
    }

    /**
     * Image defines information about the image to use for VM creation. There are three ways to specify an image: by ID, Marketplace Image or SharedImageGallery One of ID, SharedImage or Marketplace should be set.
     */
    @JsonProperty("computeGallery")
    public AzureComputeGalleryImage getComputeGallery() {
        return computeGallery;
    }

    /**
     * Image defines information about the image to use for VM creation. There are three ways to specify an image: by ID, Marketplace Image or SharedImageGallery One of ID, SharedImage or Marketplace should be set.
     */
    @JsonProperty("computeGallery")
    public void setComputeGallery(AzureComputeGalleryImage computeGallery) {
        this.computeGallery = computeGallery;
    }

    /**
     * ID specifies an image to use by ID
     */
    @JsonProperty("id")
    public String getId() {
        return id;
    }

    /**
     * ID specifies an image to use by ID
     */
    @JsonProperty("id")
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Image defines information about the image to use for VM creation. There are three ways to specify an image: by ID, Marketplace Image or SharedImageGallery One of ID, SharedImage or Marketplace should be set.
     */
    @JsonProperty("marketplace")
    public AzureMarketplaceImage getMarketplace() {
        return marketplace;
    }

    /**
     * Image defines information about the image to use for VM creation. There are three ways to specify an image: by ID, Marketplace Image or SharedImageGallery One of ID, SharedImage or Marketplace should be set.
     */
    @JsonProperty("marketplace")
    public void setMarketplace(AzureMarketplaceImage marketplace) {
        this.marketplace = marketplace;
    }

    /**
     * Image defines information about the image to use for VM creation. There are three ways to specify an image: by ID, Marketplace Image or SharedImageGallery One of ID, SharedImage or Marketplace should be set.
     */
    @JsonProperty("sharedGallery")
    public AzureSharedGalleryImage getSharedGallery() {
        return sharedGallery;
    }

    /**
     * Image defines information about the image to use for VM creation. There are three ways to specify an image: by ID, Marketplace Image or SharedImageGallery One of ID, SharedImage or Marketplace should be set.
     */
    @JsonProperty("sharedGallery")
    public void setSharedGallery(AzureSharedGalleryImage sharedGallery) {
        this.sharedGallery = sharedGallery;
    }

    @JsonIgnore
    public ImageBuilder edit() {
        return new ImageBuilder(this);
    }

    @JsonIgnore
    public ImageBuilder toBuilder() {
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
