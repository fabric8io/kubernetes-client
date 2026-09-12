
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

@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "lastPrivateKeyHash",
    "lastRegisteredEmail",
    "uri"
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
public class ACMEIssuerStatus implements Editable<ACMEIssuerStatusBuilder>, KubernetesResource
{

    @JsonProperty("lastPrivateKeyHash")
    private String lastPrivateKeyHash;
    @JsonProperty("lastRegisteredEmail")
    private String lastRegisteredEmail;
    @JsonProperty("uri")
    private String uri;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public ACMEIssuerStatus() {
    }

    public ACMEIssuerStatus(String lastPrivateKeyHash, String lastRegisteredEmail, String uri) {
        super();
        this.lastPrivateKeyHash = lastPrivateKeyHash;
        this.lastRegisteredEmail = lastRegisteredEmail;
        this.uri = uri;
    }

    /**
     * LastPrivateKeyHash is a hash of the private key associated with the latest registered ACME account, in order to track changes made to registered account associated with the Issuer
     */
    @JsonProperty("lastPrivateKeyHash")
    public String getLastPrivateKeyHash() {
        return lastPrivateKeyHash;
    }

    /**
     * LastPrivateKeyHash is a hash of the private key associated with the latest registered ACME account, in order to track changes made to registered account associated with the Issuer
     */
    @JsonProperty("lastPrivateKeyHash")
    public void setLastPrivateKeyHash(String lastPrivateKeyHash) {
        this.lastPrivateKeyHash = lastPrivateKeyHash;
    }

    /**
     * LastRegisteredEmail is the email associated with the latest registered ACME account, in order to track changes made to registered account associated with the  Issuer
     */
    @JsonProperty("lastRegisteredEmail")
    public String getLastRegisteredEmail() {
        return lastRegisteredEmail;
    }

    /**
     * LastRegisteredEmail is the email associated with the latest registered ACME account, in order to track changes made to registered account associated with the  Issuer
     */
    @JsonProperty("lastRegisteredEmail")
    public void setLastRegisteredEmail(String lastRegisteredEmail) {
        this.lastRegisteredEmail = lastRegisteredEmail;
    }

    /**
     * URI is the unique account identifier, which can also be used to retrieve account details from the CA
     */
    @JsonProperty("uri")
    public String getUri() {
        return uri;
    }

    /**
     * URI is the unique account identifier, which can also be used to retrieve account details from the CA
     */
    @JsonProperty("uri")
    public void setUri(String uri) {
        this.uri = uri;
    }

    @JsonIgnore
    public ACMEIssuerStatusBuilder edit() {
        return new ACMEIssuerStatusBuilder(this);
    }

    @JsonIgnore
    public ACMEIssuerStatusBuilder toBuilder() {
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
        if (!(o instanceof ACMEIssuerStatus)) {
            return false;
        }
        ACMEIssuerStatus other = (ACMEIssuerStatus) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$lastPrivateKeyHash = this.getLastPrivateKeyHash();
        Object other$lastPrivateKeyHash = other.getLastPrivateKeyHash();
        if (this$lastPrivateKeyHash == null ? other$lastPrivateKeyHash != null : !this$lastPrivateKeyHash.equals(other$lastPrivateKeyHash)) {
            return false;
        }
        Object this$lastRegisteredEmail = this.getLastRegisteredEmail();
        Object other$lastRegisteredEmail = other.getLastRegisteredEmail();
        if (this$lastRegisteredEmail == null ? other$lastRegisteredEmail != null : !this$lastRegisteredEmail.equals(other$lastRegisteredEmail)) {
            return false;
        }
        Object this$uri = this.getUri();
        Object other$uri = other.getUri();
        if (this$uri == null ? other$uri != null : !this$uri.equals(other$uri)) {
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
        return other instanceof ACMEIssuerStatus;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $lastPrivateKeyHash = this.getLastPrivateKeyHash();
        result = result * prime + ($lastPrivateKeyHash == null ? 43 : $lastPrivateKeyHash.hashCode());
        Object $lastRegisteredEmail = this.getLastRegisteredEmail();
        result = result * prime + ($lastRegisteredEmail == null ? 43 : $lastRegisteredEmail.hashCode());
        Object $uri = this.getUri();
        result = result * prime + ($uri == null ? 43 : $uri.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "ACMEIssuerStatus(" + "lastPrivateKeyHash=" + this.getLastPrivateKeyHash() + ", lastRegisteredEmail=" + this.getLastRegisteredEmail() + ", uri=" + this.getUri() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
