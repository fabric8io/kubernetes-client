
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
 * AzureMarketplaceImage defines an image in the Azure Marketplace to use for VM creation.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "offer",
    "publisher",
    "sku",
    "thirdPartyImage",
    "version"
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
public class AzureMarketplaceImage implements Editable<AzureMarketplaceImageBuilder>, KubernetesResource
{

    @JsonProperty("offer")
    private String offer;
    @JsonProperty("publisher")
    private String publisher;
    @JsonProperty("sku")
    private String sku;
    @JsonProperty("thirdPartyImage")
    private Boolean thirdPartyImage;
    @JsonProperty("version")
    private String version;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public AzureMarketplaceImage() {
    }

    public AzureMarketplaceImage(String offer, String publisher, String sku, Boolean thirdPartyImage, String version) {
        super();
        this.offer = offer;
        this.publisher = publisher;
        this.sku = sku;
        this.thirdPartyImage = thirdPartyImage;
        this.version = version;
    }

    /**
     * Offer specifies the name of a group of related images created by the publisher. For example, UbuntuServer, WindowsServer
     */
    @JsonProperty("offer")
    public String getOffer() {
        return offer;
    }

    /**
     * Offer specifies the name of a group of related images created by the publisher. For example, UbuntuServer, WindowsServer
     */
    @JsonProperty("offer")
    public void setOffer(String offer) {
        this.offer = offer;
    }

    /**
     * Publisher is the name of the organization that created the image
     */
    @JsonProperty("publisher")
    public String getPublisher() {
        return publisher;
    }

    /**
     * Publisher is the name of the organization that created the image
     */
    @JsonProperty("publisher")
    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    /**
     * SKU specifies an instance of an offer, such as a major release of a distribution. For example, 18.04-LTS, 2019-Datacenter
     */
    @JsonProperty("sku")
    public String getSku() {
        return sku;
    }

    /**
     * SKU specifies an instance of an offer, such as a major release of a distribution. For example, 18.04-LTS, 2019-Datacenter
     */
    @JsonProperty("sku")
    public void setSku(String sku) {
        this.sku = sku;
    }

    /**
     * ThirdPartyImage indicates the image is published by a third party publisher and a Plan will be generated for it.
     */
    @JsonProperty("thirdPartyImage")
    public Boolean getThirdPartyImage() {
        return thirdPartyImage;
    }

    /**
     * ThirdPartyImage indicates the image is published by a third party publisher and a Plan will be generated for it.
     */
    @JsonProperty("thirdPartyImage")
    public void setThirdPartyImage(Boolean thirdPartyImage) {
        this.thirdPartyImage = thirdPartyImage;
    }

    /**
     * Version specifies the version of an image sku. The allowed formats are Major.Minor.Build or 'latest'. Major, Minor, and Build are decimal numbers. Specify 'latest' to use the latest version of an image available at deploy time. Even if you use 'latest', the VM image will not automatically update after deploy time even if a new version becomes available.
     */
    @JsonProperty("version")
    public String getVersion() {
        return version;
    }

    /**
     * Version specifies the version of an image sku. The allowed formats are Major.Minor.Build or 'latest'. Major, Minor, and Build are decimal numbers. Specify 'latest' to use the latest version of an image available at deploy time. Even if you use 'latest', the VM image will not automatically update after deploy time even if a new version becomes available.
     */
    @JsonProperty("version")
    public void setVersion(String version) {
        this.version = version;
    }

    @JsonIgnore
    public AzureMarketplaceImageBuilder edit() {
        return new AzureMarketplaceImageBuilder(this);
    }

    @JsonIgnore
    public AzureMarketplaceImageBuilder toBuilder() {
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
