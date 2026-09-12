
package io.fabric8.openshift.api.model.hive.azure.v1;

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

/**
 * OSImage is the image to use for the OS of a machine.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "offer",
    "publisher",
    "sku",
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
public class OSImage implements Editable<OSImageBuilder>, KubernetesResource
{

    @JsonProperty("offer")
    private String offer;
    @JsonProperty("publisher")
    private String publisher;
    @JsonProperty("sku")
    private String sku;
    @JsonProperty("version")
    private String version;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public OSImage() {
    }

    public OSImage(String offer, String publisher, String sku, String version) {
        super();
        this.offer = offer;
        this.publisher = publisher;
        this.sku = sku;
        this.version = version;
    }

    /**
     * Offer is the offer of the image.
     */
    @JsonProperty("offer")
    public String getOffer() {
        return offer;
    }

    /**
     * Offer is the offer of the image.
     */
    @JsonProperty("offer")
    public void setOffer(String offer) {
        this.offer = offer;
    }

    /**
     * Publisher is the publisher of the image.
     */
    @JsonProperty("publisher")
    public String getPublisher() {
        return publisher;
    }

    /**
     * Publisher is the publisher of the image.
     */
    @JsonProperty("publisher")
    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    /**
     * SKU is the SKU of the image.
     */
    @JsonProperty("sku")
    public String getSku() {
        return sku;
    }

    /**
     * SKU is the SKU of the image.
     */
    @JsonProperty("sku")
    public void setSku(String sku) {
        this.sku = sku;
    }

    /**
     * Version is the version of the image.
     */
    @JsonProperty("version")
    public String getVersion() {
        return version;
    }

    /**
     * Version is the version of the image.
     */
    @JsonProperty("version")
    public void setVersion(String version) {
        this.version = version;
    }

    @JsonIgnore
    public OSImageBuilder edit() {
        return new OSImageBuilder(this);
    }

    @JsonIgnore
    public OSImageBuilder toBuilder() {
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
        if (!(o instanceof OSImage)) {
            return false;
        }
        OSImage other = (OSImage) o;
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
        Object this$sku = this.getSku();
        Object other$sku = other.getSku();
        if (this$sku == null ? other$sku != null : !this$sku.equals(other$sku)) {
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
        return other instanceof OSImage;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $offer = this.getOffer();
        result = result * prime + ($offer == null ? 43 : $offer.hashCode());
        Object $publisher = this.getPublisher();
        result = result * prime + ($publisher == null ? 43 : $publisher.hashCode());
        Object $sku = this.getSku();
        result = result * prime + ($sku == null ? 43 : $sku.hashCode());
        Object $version = this.getVersion();
        result = result * prime + ($version == null ? 43 : $version.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "OSImage(" + "offer=" + this.getOffer() + ", publisher=" + this.getPublisher() + ", sku=" + this.getSku() + ", version=" + this.getVersion() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
