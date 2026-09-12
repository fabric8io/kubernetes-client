
package io.fabric8.openshift.api.model.machine.v1beta1;

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

/**
 * Image is a mirror of azure sdk compute.ImageReference
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "offer",
    "publisher",
    "resourceID",
    "sku",
    "type",
    "version"
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

    @JsonProperty("offer")
    private String offer;
    @JsonProperty("publisher")
    private String publisher;
    @JsonProperty("resourceID")
    private String resourceID;
    @JsonProperty("sku")
    private String sku;
    @JsonProperty("type")
    private String type;
    @JsonProperty("version")
    private String version;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public Image() {
    }

    public Image(String offer, String publisher, String resourceID, String sku, String type, String version) {
        super();
        this.offer = offer;
        this.publisher = publisher;
        this.resourceID = resourceID;
        this.sku = sku;
        this.type = type;
        this.version = version;
    }

    /**
     * offer specifies the name of a group of related images created by the publisher. For example, UbuntuServer, WindowsServer
     */
    @JsonProperty("offer")
    public String getOffer() {
        return offer;
    }

    /**
     * offer specifies the name of a group of related images created by the publisher. For example, UbuntuServer, WindowsServer
     */
    @JsonProperty("offer")
    public void setOffer(String offer) {
        this.offer = offer;
    }

    /**
     * publisher is the name of the organization that created the image
     */
    @JsonProperty("publisher")
    public String getPublisher() {
        return publisher;
    }

    /**
     * publisher is the name of the organization that created the image
     */
    @JsonProperty("publisher")
    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    /**
     * resourceID specifies an image to use by ID
     */
    @JsonProperty("resourceID")
    public String getResourceID() {
        return resourceID;
    }

    /**
     * resourceID specifies an image to use by ID
     */
    @JsonProperty("resourceID")
    public void setResourceID(String resourceID) {
        this.resourceID = resourceID;
    }

    /**
     * sku specifies an instance of an offer, such as a major release of a distribution. For example, 18.04-LTS, 2019-Datacenter
     */
    @JsonProperty("sku")
    public String getSku() {
        return sku;
    }

    /**
     * sku specifies an instance of an offer, such as a major release of a distribution. For example, 18.04-LTS, 2019-Datacenter
     */
    @JsonProperty("sku")
    public void setSku(String sku) {
        this.sku = sku;
    }

    /**
     * type identifies the source of the image and related information, such as purchase plans. Valid values are "ID", "MarketplaceWithPlan", "MarketplaceNoPlan", and omitted, which means no opinion and the platform chooses a good default which may change over time. Currently that default is "MarketplaceNoPlan" if publisher data is supplied, or "ID" if not. For more information about purchase plans, see: https://docs.microsoft.com/en-us/azure/virtual-machines/linux/cli-ps-findimage#check-the-purchase-plan-information
     */
    @JsonProperty("type")
    public String getType() {
        return type;
    }

    /**
     * type identifies the source of the image and related information, such as purchase plans. Valid values are "ID", "MarketplaceWithPlan", "MarketplaceNoPlan", and omitted, which means no opinion and the platform chooses a good default which may change over time. Currently that default is "MarketplaceNoPlan" if publisher data is supplied, or "ID" if not. For more information about purchase plans, see: https://docs.microsoft.com/en-us/azure/virtual-machines/linux/cli-ps-findimage#check-the-purchase-plan-information
     */
    @JsonProperty("type")
    public void setType(String type) {
        this.type = type;
    }

    /**
     * version specifies the version of an image sku. The allowed formats are Major.Minor.Build or 'latest'. Major, Minor, and Build are decimal numbers. Specify 'latest' to use the latest version of an image available at deploy time. Even if you use 'latest', the VM image will not automatically update after deploy time even if a new version becomes available.
     */
    @JsonProperty("version")
    public String getVersion() {
        return version;
    }

    /**
     * version specifies the version of an image sku. The allowed formats are Major.Minor.Build or 'latest'. Major, Minor, and Build are decimal numbers. Specify 'latest' to use the latest version of an image available at deploy time. Even if you use 'latest', the VM image will not automatically update after deploy time even if a new version becomes available.
     */
    @JsonProperty("version")
    public void setVersion(String version) {
        this.version = version;
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
    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof Image)) {
            return false;
        }
        Image other = (Image) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$offer = this.getOffer();
        Object other$offer = other.getOffer();
        if (this$offer == null ? other$offer != null : !this$offer.equals(other$offer)) {
            return false;
        }
        Object this$publisher = this.getPublisher();
        Object other$publisher = other.getPublisher();
        if (this$publisher == null ? other$publisher != null : !this$publisher.equals(other$publisher)) {
            return false;
        }
        Object this$resourceID = this.getResourceID();
        Object other$resourceID = other.getResourceID();
        if (this$resourceID == null ? other$resourceID != null : !this$resourceID.equals(other$resourceID)) {
            return false;
        }
        Object this$sku = this.getSku();
        Object other$sku = other.getSku();
        if (this$sku == null ? other$sku != null : !this$sku.equals(other$sku)) {
            return false;
        }
        Object this$type = this.getType();
        Object other$type = other.getType();
        if (this$type == null ? other$type != null : !this$type.equals(other$type)) {
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
        return other instanceof Image;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $offer = this.getOffer();
        result = result * prime + ($offer == null ? 43 : $offer.hashCode());
        Object $publisher = this.getPublisher();
        result = result * prime + ($publisher == null ? 43 : $publisher.hashCode());
        Object $resourceID = this.getResourceID();
        result = result * prime + ($resourceID == null ? 43 : $resourceID.hashCode());
        Object $sku = this.getSku();
        result = result * prime + ($sku == null ? 43 : $sku.hashCode());
        Object $type = this.getType();
        result = result * prime + ($type == null ? 43 : $type.hashCode());
        Object $version = this.getVersion();
        result = result * prime + ($version == null ? 43 : $version.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "Image(" + "offer=" + this.getOffer() + ", publisher=" + this.getPublisher() + ", resourceID=" + this.getResourceID() + ", sku=" + this.getSku() + ", type=" + this.getType() + ", version=" + this.getVersion() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
