
package io.fabric8.openshift.api.model.hive.aws.v1;

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
 * EC2RootVolume defines the storage for an ec2 instance.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "iops",
    "kmsKeyARN",
    "size",
    "type"
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
public class EC2RootVolume implements Editable<EC2RootVolumeBuilder>, KubernetesResource
{

    @JsonProperty("iops")
    private Integer iops;
    @JsonProperty("kmsKeyARN")
    private String kmsKeyARN;
    @JsonProperty("size")
    private Integer size;
    @JsonProperty("type")
    private String type;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public EC2RootVolume() {
    }

    public EC2RootVolume(Integer iops, String kmsKeyARN, Integer size, String type) {
        super();
        this.iops = iops;
        this.kmsKeyARN = kmsKeyARN;
        this.size = size;
        this.type = type;
    }

    /**
     * IOPS defines the iops for the storage.
     */
    @JsonProperty("iops")
    public Integer getIops() {
        return iops;
    }

    /**
     * IOPS defines the iops for the storage.
     */
    @JsonProperty("iops")
    public void setIops(Integer iops) {
        this.iops = iops;
    }

    /**
     * The KMS key that will be used to encrypt the EBS volume. If no key is provided the default KMS key for the account will be used. https://docs.aws.amazon.com/AWSEC2/latest/APIReference/API_GetEbsDefaultKmsKeyId.html
     */
    @JsonProperty("kmsKeyARN")
    public String getKmsKeyARN() {
        return kmsKeyARN;
    }

    /**
     * The KMS key that will be used to encrypt the EBS volume. If no key is provided the default KMS key for the account will be used. https://docs.aws.amazon.com/AWSEC2/latest/APIReference/API_GetEbsDefaultKmsKeyId.html
     */
    @JsonProperty("kmsKeyARN")
    public void setKmsKeyARN(String kmsKeyARN) {
        this.kmsKeyARN = kmsKeyARN;
    }

    /**
     * Size defines the size of the storage.
     */
    @JsonProperty("size")
    public Integer getSize() {
        return size;
    }

    /**
     * Size defines the size of the storage.
     */
    @JsonProperty("size")
    public void setSize(Integer size) {
        this.size = size;
    }

    /**
     * Type defines the type of the storage.
     */
    @JsonProperty("type")
    public String getType() {
        return type;
    }

    /**
     * Type defines the type of the storage.
     */
    @JsonProperty("type")
    public void setType(String type) {
        this.type = type;
    }

    @JsonIgnore
    public EC2RootVolumeBuilder edit() {
        return new EC2RootVolumeBuilder(this);
    }

    @JsonIgnore
    public EC2RootVolumeBuilder toBuilder() {
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
