
package io.fabric8.certmanager.api.model.acme.v1;

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
import io.fabric8.certmanager.api.model.meta.v1.SecretKeySelector;
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

/**
 * ACMEExternalAccountBinding is a reference to a CA external account of the ACME server.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "keyAlgorithm",
    "keyID",
    "keySecretRef"
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
public class ACMEExternalAccountBinding implements Editable<ACMEExternalAccountBindingBuilder>, KubernetesResource
{

    @JsonProperty("keyAlgorithm")
    private String keyAlgorithm;
    @JsonProperty("keyID")
    private String keyID;
    @JsonProperty("keySecretRef")
    private SecretKeySelector keySecretRef;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public ACMEExternalAccountBinding() {
    }

    public ACMEExternalAccountBinding(String keyAlgorithm, String keyID, SecretKeySelector keySecretRef) {
        super();
        this.keyAlgorithm = keyAlgorithm;
        this.keyID = keyID;
        this.keySecretRef = keySecretRef;
    }

    /**
     * Deprecated: keyAlgorithm field exists for historical compatibility reasons and should not be used. The algorithm is now hardcoded to HS256 in golang/x/crypto/acme.
     */
    @JsonProperty("keyAlgorithm")
    public String getKeyAlgorithm() {
        return keyAlgorithm;
    }

    /**
     * Deprecated: keyAlgorithm field exists for historical compatibility reasons and should not be used. The algorithm is now hardcoded to HS256 in golang/x/crypto/acme.
     */
    @JsonProperty("keyAlgorithm")
    public void setKeyAlgorithm(String keyAlgorithm) {
        this.keyAlgorithm = keyAlgorithm;
    }

    /**
     * keyID is the ID of the CA key that the External Account is bound to.
     */
    @JsonProperty("keyID")
    public String getKeyID() {
        return keyID;
    }

    /**
     * keyID is the ID of the CA key that the External Account is bound to.
     */
    @JsonProperty("keyID")
    public void setKeyID(String keyID) {
        this.keyID = keyID;
    }

    /**
     * ACMEExternalAccountBinding is a reference to a CA external account of the ACME server.
     */
    @JsonProperty("keySecretRef")
    public SecretKeySelector getKeySecretRef() {
        return keySecretRef;
    }

    /**
     * ACMEExternalAccountBinding is a reference to a CA external account of the ACME server.
     */
    @JsonProperty("keySecretRef")
    public void setKeySecretRef(SecretKeySelector keySecretRef) {
        this.keySecretRef = keySecretRef;
    }

    @JsonIgnore
    public ACMEExternalAccountBindingBuilder edit() {
        return new ACMEExternalAccountBindingBuilder(this);
    }

    @JsonIgnore
    public ACMEExternalAccountBindingBuilder toBuilder() {
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
        if (!(o instanceof ACMEExternalAccountBinding)) {
            return false;
        }
        ACMEExternalAccountBinding other = (ACMEExternalAccountBinding) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$keyAlgorithm = this.getKeyAlgorithm();
        Object other$keyAlgorithm = other.getKeyAlgorithm();
        if (this$keyAlgorithm == null ? other$keyAlgorithm != null : !this$keyAlgorithm.equals(other$keyAlgorithm)) {
            return false;
        }
        Object this$keyID = this.getKeyID();
        Object other$keyID = other.getKeyID();
        if (this$keyID == null ? other$keyID != null : !this$keyID.equals(other$keyID)) {
            return false;
        }
        Object this$keySecretRef = this.getKeySecretRef();
        Object other$keySecretRef = other.getKeySecretRef();
        if (this$keySecretRef == null ? other$keySecretRef != null : !this$keySecretRef.equals(other$keySecretRef)) {
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
        return other instanceof ACMEExternalAccountBinding;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $keyAlgorithm = this.getKeyAlgorithm();
        result = result * prime + ($keyAlgorithm == null ? 43 : $keyAlgorithm.hashCode());
        Object $keyID = this.getKeyID();
        result = result * prime + ($keyID == null ? 43 : $keyID.hashCode());
        Object $keySecretRef = this.getKeySecretRef();
        result = result * prime + ($keySecretRef == null ? 43 : $keySecretRef.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "ACMEExternalAccountBinding(" + "keyAlgorithm=" + this.getKeyAlgorithm() + ", keyID=" + this.getKeyID() + ", keySecretRef=" + this.getKeySecretRef() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
