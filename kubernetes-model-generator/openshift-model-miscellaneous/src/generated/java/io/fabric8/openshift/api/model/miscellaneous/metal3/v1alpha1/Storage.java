
package io.fabric8.openshift.api.model.miscellaneous.metal3.v1alpha1;

import java.util.LinkedHashMap;
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
    "hctl",
    "model",
    "name",
    "rotational",
    "serialNumber",
    "sizeBytes",
    "type",
    "vendor",
    "wwn",
    "wwnVendorExtension",
    "wwnWithExtension"
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
public class Storage implements KubernetesResource
{

    @JsonProperty("hctl")
    private String hctl;
    @JsonProperty("model")
    private String model;
    @JsonProperty("name")
    private String name;
    @JsonProperty("rotational")
    private Boolean rotational;
    @JsonProperty("serialNumber")
    private String serialNumber;
    @JsonProperty("sizeBytes")
    private Long sizeBytes;
    @JsonProperty("type")
    private String type;
    @JsonProperty("vendor")
    private String vendor;
    @JsonProperty("wwn")
    private String wwn;
    @JsonProperty("wwnVendorExtension")
    private String wwnVendorExtension;
    @JsonProperty("wwnWithExtension")
    private String wwnWithExtension;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public Storage() {
    }

    public Storage(String hctl, String model, String name, Boolean rotational, String serialNumber, Long sizeBytes, String type, String vendor, String wwn, String wwnVendorExtension, String wwnWithExtension) {
        super();
        this.hctl = hctl;
        this.model = model;
        this.name = name;
        this.rotational = rotational;
        this.serialNumber = serialNumber;
        this.sizeBytes = sizeBytes;
        this.type = type;
        this.vendor = vendor;
        this.wwn = wwn;
        this.wwnVendorExtension = wwnVendorExtension;
        this.wwnWithExtension = wwnWithExtension;
    }

    @JsonProperty("hctl")
    public String getHctl() {
        return hctl;
    }

    @JsonProperty("hctl")
    public void setHctl(String hctl) {
        this.hctl = hctl;
    }

    @JsonProperty("model")
    public String getModel() {
        return model;
    }

    @JsonProperty("model")
    public void setModel(String model) {
        this.model = model;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("rotational")
    public Boolean getRotational() {
        return rotational;
    }

    @JsonProperty("rotational")
    public void setRotational(Boolean rotational) {
        this.rotational = rotational;
    }

    @JsonProperty("serialNumber")
    public String getSerialNumber() {
        return serialNumber;
    }

    @JsonProperty("serialNumber")
    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    @JsonProperty("sizeBytes")
    public Long getSizeBytes() {
        return sizeBytes;
    }

    @JsonProperty("sizeBytes")
    public void setSizeBytes(Long sizeBytes) {
        this.sizeBytes = sizeBytes;
    }

    @JsonProperty("type")
    public String getType() {
        return type;
    }

    @JsonProperty("type")
    public void setType(String type) {
        this.type = type;
    }

    @JsonProperty("vendor")
    public String getVendor() {
        return vendor;
    }

    @JsonProperty("vendor")
    public void setVendor(String vendor) {
        this.vendor = vendor;
    }

    @JsonProperty("wwn")
    public String getWwn() {
        return wwn;
    }

    @JsonProperty("wwn")
    public void setWwn(String wwn) {
        this.wwn = wwn;
    }

    @JsonProperty("wwnVendorExtension")
    public String getWwnVendorExtension() {
        return wwnVendorExtension;
    }

    @JsonProperty("wwnVendorExtension")
    public void setWwnVendorExtension(String wwnVendorExtension) {
        this.wwnVendorExtension = wwnVendorExtension;
    }

    @JsonProperty("wwnWithExtension")
    public String getWwnWithExtension() {
        return wwnWithExtension;
    }

    @JsonProperty("wwnWithExtension")
    public void setWwnWithExtension(String wwnWithExtension) {
        this.wwnWithExtension = wwnWithExtension;
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
