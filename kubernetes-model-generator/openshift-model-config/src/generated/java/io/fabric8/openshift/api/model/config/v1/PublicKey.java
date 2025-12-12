
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
 * PublicKey defines the root of trust based on a sigstore public key.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "keyData",
    "rekorKeyData"
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
public class PublicKey implements Editable<PublicKeyBuilder>, KubernetesResource
{

    @JsonProperty("keyData")
    private String keyData;
    @JsonProperty("rekorKeyData")
    private String rekorKeyData;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public PublicKey() {
    }

    public PublicKey(String keyData, String rekorKeyData) {
        super();
        this.keyData = keyData;
        this.rekorKeyData = rekorKeyData;
    }

    /**
     * keyData is a required field contains inline base64-encoded data for the PEM format public key. keyData must be at most 8192 characters.
     */
    @JsonProperty("keyData")
    public String getKeyData() {
        return keyData;
    }

    /**
     * keyData is a required field contains inline base64-encoded data for the PEM format public key. keyData must be at most 8192 characters.
     */
    @JsonProperty("keyData")
    public void setKeyData(String keyData) {
        this.keyData = keyData;
    }

    /**
     * rekorKeyData is an optional field contains inline base64-encoded data for the PEM format from the Rekor public key. rekorKeyData must be at most 8192 characters.
     */
    @JsonProperty("rekorKeyData")
    public String getRekorKeyData() {
        return rekorKeyData;
    }

    /**
     * rekorKeyData is an optional field contains inline base64-encoded data for the PEM format from the Rekor public key. rekorKeyData must be at most 8192 characters.
     */
    @JsonProperty("rekorKeyData")
    public void setRekorKeyData(String rekorKeyData) {
        this.rekorKeyData = rekorKeyData;
    }

    @JsonIgnore
    public PublicKeyBuilder edit() {
        return new PublicKeyBuilder(this);
    }

    @JsonIgnore
    public PublicKeyBuilder toBuilder() {
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
