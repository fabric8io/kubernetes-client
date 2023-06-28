
package io.fabric8.openshift.api.model.miscellaneous.imageregistry.operator.v1;

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
import io.fabric8.kubernetes.api.model.Duration;
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
    "baseURL",
    "duration",
    "keypairID",
    "privateKey"
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
public class ImageRegistryConfigStorageS3CloudFront implements KubernetesResource
{

    @JsonProperty("baseURL")
    private String baseURL;
    @JsonProperty("duration")
    private Duration duration;
    @JsonProperty("keypairID")
    private String keypairID;
    @JsonProperty("privateKey")
    private SecretKeySelector privateKey;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public ImageRegistryConfigStorageS3CloudFront() {
    }

    public ImageRegistryConfigStorageS3CloudFront(String baseURL, Duration duration, String keypairID, SecretKeySelector privateKey) {
        super();
        this.baseURL = baseURL;
        this.duration = duration;
        this.keypairID = keypairID;
        this.privateKey = privateKey;
    }

    @JsonProperty("baseURL")
    public String getBaseURL() {
        return baseURL;
    }

    @JsonProperty("baseURL")
    public void setBaseURL(String baseURL) {
        this.baseURL = baseURL;
    }

    @JsonProperty("duration")
    public Duration getDuration() {
        return duration;
    }

    @JsonProperty("duration")
    public void setDuration(Duration duration) {
        this.duration = duration;
    }

    @JsonProperty("keypairID")
    public String getKeypairID() {
        return keypairID;
    }

    @JsonProperty("keypairID")
    public void setKeypairID(String keypairID) {
        this.keypairID = keypairID;
    }

    @JsonProperty("privateKey")
    public SecretKeySelector getPrivateKey() {
        return privateKey;
    }

    @JsonProperty("privateKey")
    public void setPrivateKey(SecretKeySelector privateKey) {
        this.privateKey = privateKey;
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
