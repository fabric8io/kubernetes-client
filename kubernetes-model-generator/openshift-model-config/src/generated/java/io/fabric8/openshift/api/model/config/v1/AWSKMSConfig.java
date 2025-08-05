
package io.fabric8.openshift.api.model.config.v1;

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
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * AWSKMSConfig defines the KMS config specific to AWS KMS provider
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "keyARN",
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
    @BuildableReference(io.fabric8.kubernetes.api.model.ObjectReference.class),
    @BuildableReference(LocalObjectReference.class),
    @BuildableReference(PersistentVolumeClaim.class),
    @BuildableReference(EnvVar.class),
    @BuildableReference(ContainerPort.class),
    @BuildableReference(Volume.class),
    @BuildableReference(VolumeMount.class)
})
@Generated("io.fabric8.kubernetes.schema.generator.model.ModelGenerator")
public class AWSKMSConfig implements Editable<AWSKMSConfigBuilder>, KubernetesResource
{

    @JsonProperty("keyARN")
    private String keyARN;
    @JsonProperty("region")
    private String region;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public AWSKMSConfig() {
    }

    public AWSKMSConfig(String keyARN, String region) {
        super();
        this.keyARN = keyARN;
        this.region = region;
    }

    /**
     * keyARN specifies the Amazon Resource Name (ARN) of the AWS KMS key used for encryption. The value must adhere to the format `arn:aws:kms:&lt;region&gt;:&lt;account_id&gt;:key/&lt;key_id&gt;`, where: - `&lt;region&gt;` is the AWS region consisting of lowercase letters and hyphens followed by a number. - `&lt;account_id&gt;` is a 12-digit numeric identifier for the AWS account. - `&lt;key_id&gt;` is a unique identifier for the KMS key, consisting of lowercase hexadecimal characters and hyphens.
     */
    @JsonProperty("keyARN")
    public String getKeyARN() {
        return keyARN;
    }

    /**
     * keyARN specifies the Amazon Resource Name (ARN) of the AWS KMS key used for encryption. The value must adhere to the format `arn:aws:kms:&lt;region&gt;:&lt;account_id&gt;:key/&lt;key_id&gt;`, where: - `&lt;region&gt;` is the AWS region consisting of lowercase letters and hyphens followed by a number. - `&lt;account_id&gt;` is a 12-digit numeric identifier for the AWS account. - `&lt;key_id&gt;` is a unique identifier for the KMS key, consisting of lowercase hexadecimal characters and hyphens.
     */
    @JsonProperty("keyARN")
    public void setKeyARN(String keyARN) {
        this.keyARN = keyARN;
    }

    /**
     * region specifies the AWS region where the KMS instance exists, and follows the format `&lt;region-prefix&gt;-&lt;region-name&gt;-&lt;number&gt;`, e.g.: `us-east-1`. Only lowercase letters and hyphens followed by numbers are allowed.
     */
    @JsonProperty("region")
    public String getRegion() {
        return region;
    }

    /**
     * region specifies the AWS region where the KMS instance exists, and follows the format `&lt;region-prefix&gt;-&lt;region-name&gt;-&lt;number&gt;`, e.g.: `us-east-1`. Only lowercase letters and hyphens followed by numbers are allowed.
     */
    @JsonProperty("region")
    public void setRegion(String region) {
        this.region = region;
    }

    @JsonIgnore
    public AWSKMSConfigBuilder edit() {
        return new AWSKMSConfigBuilder(this);
    }

    @JsonIgnore
    public AWSKMSConfigBuilder toBuilder() {
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
