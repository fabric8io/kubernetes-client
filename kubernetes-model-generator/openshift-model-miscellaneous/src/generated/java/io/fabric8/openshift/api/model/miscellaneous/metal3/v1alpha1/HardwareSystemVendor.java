
package io.fabric8.openshift.api.model.miscellaneous.metal3.v1alpha1;

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
import io.fabric8.kubernetes.api.model.PersistentVolumeClaim;
import io.fabric8.kubernetes.api.model.PodTemplateSpec;
import io.fabric8.kubernetes.api.model.ResourceRequirements;
import io.fabric8.kubernetes.api.model.Volume;
import io.fabric8.kubernetes.api.model.VolumeMount;
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;

/**
 * HardwareSystemVendor stores details about the whole hardware system.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "manufacturer",
    "productName",
    "serialNumber"
})
@Buildable(editableEnabled = false, validationEnabled = false, generateBuilderPackage = false, lazyCollectionInitEnabled = false, builderPackage = "io.fabric8.kubernetes.api.builder", refs = {
    @BuildableReference(ObjectMeta.class),
    @BuildableReference(LabelSelector.class),
    @BuildableReference(Container.class),
    @BuildableReference(PodTemplateSpec.class),
    @BuildableReference(ResourceRequirements.class),
    @BuildableReference(IntOrString.class),
    @BuildableReference(io.fabric8.kubernetes.api.model.ObjectReference.class),
    @BuildableReference(LocalObjectReference.class),
    @BuildableReference(PersistentVolumeClaim.class),
    @BuildableReference(EnvVar.class),
    @BuildableReference(ContainerPort.class),
    @BuildableReference(Volume.class),
    @BuildableReference(VolumeMount.class)
})
@Generated("io.fabric8.kubernetes.schema.generator.model.ModelGenerator")
public class HardwareSystemVendor implements Editable<HardwareSystemVendorBuilder>, KubernetesResource
{

    @JsonProperty("manufacturer")
    private String manufacturer;
    @JsonProperty("productName")
    private String productName;
    @JsonProperty("serialNumber")
    private String serialNumber;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public HardwareSystemVendor() {
    }

    public HardwareSystemVendor(String manufacturer, String productName, String serialNumber) {
        super();
        this.manufacturer = manufacturer;
        this.productName = productName;
        this.serialNumber = serialNumber;
    }

    /**
     * HardwareSystemVendor stores details about the whole hardware system.
     */
    @JsonProperty("manufacturer")
    public String getManufacturer() {
        return manufacturer;
    }

    /**
     * HardwareSystemVendor stores details about the whole hardware system.
     */
    @JsonProperty("manufacturer")
    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    /**
     * HardwareSystemVendor stores details about the whole hardware system.
     */
    @JsonProperty("productName")
    public String getProductName() {
        return productName;
    }

    /**
     * HardwareSystemVendor stores details about the whole hardware system.
     */
    @JsonProperty("productName")
    public void setProductName(String productName) {
        this.productName = productName;
    }

    /**
     * HardwareSystemVendor stores details about the whole hardware system.
     */
    @JsonProperty("serialNumber")
    public String getSerialNumber() {
        return serialNumber;
    }

    /**
     * HardwareSystemVendor stores details about the whole hardware system.
     */
    @JsonProperty("serialNumber")
    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    @JsonIgnore
    public HardwareSystemVendorBuilder edit() {
        return new HardwareSystemVendorBuilder(this);
    }

    @JsonIgnore
    public HardwareSystemVendorBuilder toBuilder() {
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
        if (!(o instanceof HardwareSystemVendor)) {
            return false;
        }
        HardwareSystemVendor other = (HardwareSystemVendor) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$manufacturer = this.getManufacturer();
        Object other$manufacturer = other.getManufacturer();
        if (this$manufacturer == null ? other$manufacturer != null : !this$manufacturer.equals(other$manufacturer)) {
            return false;
        }
        Object this$productName = this.getProductName();
        Object other$productName = other.getProductName();
        if (this$productName == null ? other$productName != null : !this$productName.equals(other$productName)) {
            return false;
        }
        Object this$serialNumber = this.getSerialNumber();
        Object other$serialNumber = other.getSerialNumber();
        if (this$serialNumber == null ? other$serialNumber != null : !this$serialNumber.equals(other$serialNumber)) {
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
        return other instanceof HardwareSystemVendor;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $manufacturer = this.getManufacturer();
        result = result * prime + ($manufacturer == null ? 43 : $manufacturer.hashCode());
        Object $productName = this.getProductName();
        result = result * prime + ($productName == null ? 43 : $productName.hashCode());
        Object $serialNumber = this.getSerialNumber();
        result = result * prime + ($serialNumber == null ? 43 : $serialNumber.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "HardwareSystemVendor(" + "manufacturer=" + this.getManufacturer() + ", productName=" + this.getProductName() + ", serialNumber=" + this.getSerialNumber() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
