
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
import io.fabric8.kubernetes.api.model.SecretKeySelector;
import io.fabric8.kubernetes.api.model.Volume;
import io.fabric8.kubernetes.api.model.VolumeMount;
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * ImageRegistryConfigStorageS3CloudFront holds the configuration to use Amazon Cloudfront as the storage middleware in a registry. https://docs.docker.com/registry/configuration/#cloudfront
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "baseURL",
    "duration",
    "keypairID",
    "privateKey"
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
public class ImageRegistryConfigStorageS3CloudFront implements Editable<ImageRegistryConfigStorageS3CloudFrontBuilder>, KubernetesResource
{

    @JsonProperty("baseURL")
    private String baseURL;
    @JsonProperty("duration")
    private String duration;
    @JsonProperty("keypairID")
    private String keypairID;
    @JsonProperty("privateKey")
    private SecretKeySelector privateKey;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public ImageRegistryConfigStorageS3CloudFront() {
    }

    public ImageRegistryConfigStorageS3CloudFront(String baseURL, String duration, String keypairID, SecretKeySelector privateKey) {
        super();
        this.baseURL = baseURL;
        this.duration = duration;
        this.keypairID = keypairID;
        this.privateKey = privateKey;
    }

    /**
     * baseURL contains the SCHEME://HOST[/PATH] at which Cloudfront is served.
     */
    @JsonProperty("baseURL")
    public String getBaseURL() {
        return baseURL;
    }

    /**
     * baseURL contains the SCHEME://HOST[/PATH] at which Cloudfront is served.
     */
    @JsonProperty("baseURL")
    public void setBaseURL(String baseURL) {
        this.baseURL = baseURL;
    }

    /**
     * ImageRegistryConfigStorageS3CloudFront holds the configuration to use Amazon Cloudfront as the storage middleware in a registry. https://docs.docker.com/registry/configuration/#cloudfront
     */
    @JsonProperty("duration")
    public String getDuration() {
        return duration;
    }

    /**
     * ImageRegistryConfigStorageS3CloudFront holds the configuration to use Amazon Cloudfront as the storage middleware in a registry. https://docs.docker.com/registry/configuration/#cloudfront
     */
    @JsonProperty("duration")
    public void setDuration(String duration) {
        this.duration = duration;
    }

    /**
     * keypairID is key pair ID provided by AWS.
     */
    @JsonProperty("keypairID")
    public String getKeypairID() {
        return keypairID;
    }

    /**
     * keypairID is key pair ID provided by AWS.
     */
    @JsonProperty("keypairID")
    public void setKeypairID(String keypairID) {
        this.keypairID = keypairID;
    }

    /**
     * ImageRegistryConfigStorageS3CloudFront holds the configuration to use Amazon Cloudfront as the storage middleware in a registry. https://docs.docker.com/registry/configuration/#cloudfront
     */
    @JsonProperty("privateKey")
    public SecretKeySelector getPrivateKey() {
        return privateKey;
    }

    /**
     * ImageRegistryConfigStorageS3CloudFront holds the configuration to use Amazon Cloudfront as the storage middleware in a registry. https://docs.docker.com/registry/configuration/#cloudfront
     */
    @JsonProperty("privateKey")
    public void setPrivateKey(SecretKeySelector privateKey) {
        this.privateKey = privateKey;
    }

    @JsonIgnore
    public ImageRegistryConfigStorageS3CloudFrontBuilder edit() {
        return new ImageRegistryConfigStorageS3CloudFrontBuilder(this);
    }

    @JsonIgnore
    public ImageRegistryConfigStorageS3CloudFrontBuilder toBuilder() {
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
