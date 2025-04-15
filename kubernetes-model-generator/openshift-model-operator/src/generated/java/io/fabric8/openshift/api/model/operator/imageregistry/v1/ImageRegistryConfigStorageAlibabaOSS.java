
package io.fabric8.openshift.api.model.operator.imageregistry.v1;

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
 * ImageRegistryConfigStorageAlibabaOSS holds Alibaba Cloud OSS configuration. Configures the registry to use Alibaba Cloud Object Storage Service for backend storage. More about oss, you can look at the [official documentation](https://www.alibabacloud.com/help/product/31815.htm)
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "bucket",
    "encryption",
    "endpointAccessibility",
    "region"
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
public class ImageRegistryConfigStorageAlibabaOSS implements Editable<ImageRegistryConfigStorageAlibabaOSSBuilder>, KubernetesResource
{

    @JsonProperty("bucket")
    private String bucket;
    @JsonProperty("encryption")
    private EncryptionAlibaba encryption;
    @JsonProperty("endpointAccessibility")
    private String endpointAccessibility;
    @JsonProperty("region")
    private String region;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public ImageRegistryConfigStorageAlibabaOSS() {
    }

    public ImageRegistryConfigStorageAlibabaOSS(String bucket, EncryptionAlibaba encryption, String endpointAccessibility, String region) {
        super();
        this.bucket = bucket;
        this.encryption = encryption;
        this.endpointAccessibility = endpointAccessibility;
        this.region = region;
    }

    /**
     * Bucket is the bucket name in which you want to store the registry's data. About Bucket naming, more details you can look at the [official documentation](https://www.alibabacloud.com/help/doc-detail/257087.htm) Empty value means no opinion and the platform chooses the a default, which is subject to change over time. Currently the default will be autogenerated in the form of &lt;clusterid&gt;-image-registry-&lt;region&gt;-&lt;random string 27 chars&gt;
     */
    @JsonProperty("bucket")
    public String getBucket() {
        return bucket;
    }

    /**
     * Bucket is the bucket name in which you want to store the registry's data. About Bucket naming, more details you can look at the [official documentation](https://www.alibabacloud.com/help/doc-detail/257087.htm) Empty value means no opinion and the platform chooses the a default, which is subject to change over time. Currently the default will be autogenerated in the form of &lt;clusterid&gt;-image-registry-&lt;region&gt;-&lt;random string 27 chars&gt;
     */
    @JsonProperty("bucket")
    public void setBucket(String bucket) {
        this.bucket = bucket;
    }

    /**
     * ImageRegistryConfigStorageAlibabaOSS holds Alibaba Cloud OSS configuration. Configures the registry to use Alibaba Cloud Object Storage Service for backend storage. More about oss, you can look at the [official documentation](https://www.alibabacloud.com/help/product/31815.htm)
     */
    @JsonProperty("encryption")
    public EncryptionAlibaba getEncryption() {
        return encryption;
    }

    /**
     * ImageRegistryConfigStorageAlibabaOSS holds Alibaba Cloud OSS configuration. Configures the registry to use Alibaba Cloud Object Storage Service for backend storage. More about oss, you can look at the [official documentation](https://www.alibabacloud.com/help/product/31815.htm)
     */
    @JsonProperty("encryption")
    public void setEncryption(EncryptionAlibaba encryption) {
        this.encryption = encryption;
    }

    /**
     * EndpointAccessibility specifies whether the registry use the OSS VPC internal endpoint Empty value means no opinion and the platform chooses the a default, which is subject to change over time. Currently the default is `Internal`.
     */
    @JsonProperty("endpointAccessibility")
    public String getEndpointAccessibility() {
        return endpointAccessibility;
    }

    /**
     * EndpointAccessibility specifies whether the registry use the OSS VPC internal endpoint Empty value means no opinion and the platform chooses the a default, which is subject to change over time. Currently the default is `Internal`.
     */
    @JsonProperty("endpointAccessibility")
    public void setEndpointAccessibility(String endpointAccessibility) {
        this.endpointAccessibility = endpointAccessibility;
    }

    /**
     * Region is the Alibaba Cloud Region in which your bucket exists. For a list of regions, you can look at the [official documentation](https://www.alibabacloud.com/help/doc-detail/31837.html). Empty value means no opinion and the platform chooses the a default, which is subject to change over time. Currently the default will be based on the installed Alibaba Cloud Region.
     */
    @JsonProperty("region")
    public String getRegion() {
        return region;
    }

    /**
     * Region is the Alibaba Cloud Region in which your bucket exists. For a list of regions, you can look at the [official documentation](https://www.alibabacloud.com/help/doc-detail/31837.html). Empty value means no opinion and the platform chooses the a default, which is subject to change over time. Currently the default will be based on the installed Alibaba Cloud Region.
     */
    @JsonProperty("region")
    public void setRegion(String region) {
        this.region = region;
    }

    @JsonIgnore
    public ImageRegistryConfigStorageAlibabaOSSBuilder edit() {
        return new ImageRegistryConfigStorageAlibabaOSSBuilder(this);
    }

    @JsonIgnore
    public ImageRegistryConfigStorageAlibabaOSSBuilder toBuilder() {
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
