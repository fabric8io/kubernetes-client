
package io.fabric8.openshift.api.model.machine.v1;

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
import io.fabric8.kubernetes.api.builder.Editable;
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
import lombok.ToString;
import lombok.experimental.Accessors;

@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "Category",
    "DiskEncryption",
    "DiskPreservation",
    "KMSKeyID",
    "Name",
    "PerformanceLevel",
    "Size",
    "SnapshotID"
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
    @BuildableReference(PersistentVolumeClaim.class)
})
@Generated("jsonschema2pojo")
public class DataDiskProperties implements Editable<DataDiskPropertiesBuilder> , KubernetesResource
{

    @JsonProperty("Category")
    private String category;
    @JsonProperty("DiskEncryption")
    private String diskEncryption;
    @JsonProperty("DiskPreservation")
    private String diskPreservation;
    @JsonProperty("KMSKeyID")
    private String kMSKeyID;
    @JsonProperty("Name")
    private String name;
    @JsonProperty("PerformanceLevel")
    private String performanceLevel;
    @JsonProperty("Size")
    private Long size;
    @JsonProperty("SnapshotID")
    private String snapshotID;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public DataDiskProperties() {
    }

    public DataDiskProperties(String category, String diskEncryption, String diskPreservation, String kMSKeyID, String name, String performanceLevel, Long size, String snapshotID) {
        super();
        this.category = category;
        this.diskEncryption = diskEncryption;
        this.diskPreservation = diskPreservation;
        this.kMSKeyID = kMSKeyID;
        this.name = name;
        this.performanceLevel = performanceLevel;
        this.size = size;
        this.snapshotID = snapshotID;
    }

    @JsonProperty("Category")
    public String getCategory() {
        return category;
    }

    @JsonProperty("Category")
    public void setCategory(String category) {
        this.category = category;
    }

    @JsonProperty("DiskEncryption")
    public String getDiskEncryption() {
        return diskEncryption;
    }

    @JsonProperty("DiskEncryption")
    public void setDiskEncryption(String diskEncryption) {
        this.diskEncryption = diskEncryption;
    }

    @JsonProperty("DiskPreservation")
    public String getDiskPreservation() {
        return diskPreservation;
    }

    @JsonProperty("DiskPreservation")
    public void setDiskPreservation(String diskPreservation) {
        this.diskPreservation = diskPreservation;
    }

    @JsonProperty("KMSKeyID")
    public String getKMSKeyID() {
        return kMSKeyID;
    }

    @JsonProperty("KMSKeyID")
    public void setKMSKeyID(String kMSKeyID) {
        this.kMSKeyID = kMSKeyID;
    }

    @JsonProperty("Name")
    public String getName() {
        return name;
    }

    @JsonProperty("Name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("PerformanceLevel")
    public String getPerformanceLevel() {
        return performanceLevel;
    }

    @JsonProperty("PerformanceLevel")
    public void setPerformanceLevel(String performanceLevel) {
        this.performanceLevel = performanceLevel;
    }

    @JsonProperty("Size")
    public Long getSize() {
        return size;
    }

    @JsonProperty("Size")
    public void setSize(Long size) {
        this.size = size;
    }

    @JsonProperty("SnapshotID")
    public String getSnapshotID() {
        return snapshotID;
    }

    @JsonProperty("SnapshotID")
    public void setSnapshotID(String snapshotID) {
        this.snapshotID = snapshotID;
    }

    @JsonIgnore
    public DataDiskPropertiesBuilder edit() {
        return new DataDiskPropertiesBuilder(this);
    }

    @JsonIgnore
    public DataDiskPropertiesBuilder toBuilder() {
        return edit();
    }

    @JsonAnyGetter
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
