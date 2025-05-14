
package io.fabric8.openshift.api.model.machine.v1;

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
 * SystemDiskProperties contains the information regarding the system disk including performance, size, name, and category
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "category",
    "name",
    "performanceLevel",
    "size"
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
public class SystemDiskProperties implements Editable<SystemDiskPropertiesBuilder>, KubernetesResource
{

    @JsonProperty("category")
    private String category;
    @JsonProperty("name")
    private String name;
    @JsonProperty("performanceLevel")
    private String performanceLevel;
    @JsonProperty("size")
    private Long size;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public SystemDiskProperties() {
    }

    public SystemDiskProperties(String category, String name, String performanceLevel, Long size) {
        super();
        this.category = category;
        this.name = name;
        this.performanceLevel = performanceLevel;
        this.size = size;
    }

    /**
     * Category is the category of the system disk. Valid values: cloud_essd: ESSD. When the parameter is set to this value, you can use the SystemDisk.PerformanceLevel parameter to specify the performance level of the disk. cloud_efficiency: ultra disk. cloud_ssd: standard SSD. cloud: basic disk. Empty value means no opinion and the platform chooses the a default, which is subject to change over time. Currently for non-I/O optimized instances of retired instance types, the default is `cloud`. Currently for other instances, the default is `cloud_efficiency`.
     */
    @JsonProperty("category")
    public String getCategory() {
        return category;
    }

    /**
     * Category is the category of the system disk. Valid values: cloud_essd: ESSD. When the parameter is set to this value, you can use the SystemDisk.PerformanceLevel parameter to specify the performance level of the disk. cloud_efficiency: ultra disk. cloud_ssd: standard SSD. cloud: basic disk. Empty value means no opinion and the platform chooses the a default, which is subject to change over time. Currently for non-I/O optimized instances of retired instance types, the default is `cloud`. Currently for other instances, the default is `cloud_efficiency`.
     */
    @JsonProperty("category")
    public void setCategory(String category) {
        this.category = category;
    }

    /**
     * Name is the name of the system disk. If the name is specified the name must be 2 to 128 characters in length. It must start with a letter and cannot start with http:// or https://. It can contain letters, digits, colons (:), underscores (_), and hyphens (-). Empty value means the platform chooses a default, which is subject to change over time. Currently the default is `""`.
     */
    @JsonProperty("name")
    public String getName() {
        return name;
    }

    /**
     * Name is the name of the system disk. If the name is specified the name must be 2 to 128 characters in length. It must start with a letter and cannot start with http:// or https://. It can contain letters, digits, colons (:), underscores (_), and hyphens (-). Empty value means the platform chooses a default, which is subject to change over time. Currently the default is `""`.
     */
    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    /**
     * PerformanceLevel is the performance level of the ESSD used as the system disk. Valid values:<br><p> <br><p> PL0: A single ESSD can deliver up to 10,000 random read/write IOPS. PL1: A single ESSD can deliver up to 50,000 random read/write IOPS. PL2: A single ESSD can deliver up to 100,000 random read/write IOPS. PL3: A single ESSD can deliver up to 1,000,000 random read/write IOPS. Empty value means no opinion and the platform chooses a default, which is subject to change over time. Currently the default is `PL1`. For more information about ESSD performance levels, see ESSDs.
     */
    @JsonProperty("performanceLevel")
    public String getPerformanceLevel() {
        return performanceLevel;
    }

    /**
     * PerformanceLevel is the performance level of the ESSD used as the system disk. Valid values:<br><p> <br><p> PL0: A single ESSD can deliver up to 10,000 random read/write IOPS. PL1: A single ESSD can deliver up to 50,000 random read/write IOPS. PL2: A single ESSD can deliver up to 100,000 random read/write IOPS. PL3: A single ESSD can deliver up to 1,000,000 random read/write IOPS. Empty value means no opinion and the platform chooses a default, which is subject to change over time. Currently the default is `PL1`. For more information about ESSD performance levels, see ESSDs.
     */
    @JsonProperty("performanceLevel")
    public void setPerformanceLevel(String performanceLevel) {
        this.performanceLevel = performanceLevel;
    }

    /**
     * Size is the size of the system disk. Unit: GiB. Valid values: 20 to 500. The value must be at least 20 and greater than or equal to the size of the image. Empty value means the platform chooses a default, which is subject to change over time. Currently the default is `40` or the size of the image depending on whichever is greater.
     */
    @JsonProperty("size")
    public Long getSize() {
        return size;
    }

    /**
     * Size is the size of the system disk. Unit: GiB. Valid values: 20 to 500. The value must be at least 20 and greater than or equal to the size of the image. Empty value means the platform chooses a default, which is subject to change over time. Currently the default is `40` or the size of the image depending on whichever is greater.
     */
    @JsonProperty("size")
    public void setSize(Long size) {
        this.size = size;
    }

    @JsonIgnore
    public SystemDiskPropertiesBuilder edit() {
        return new SystemDiskPropertiesBuilder(this);
    }

    @JsonIgnore
    public SystemDiskPropertiesBuilder toBuilder() {
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
