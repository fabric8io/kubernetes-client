
package io.fabric8.openshift.api.model.installer.v1;

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

/**
 * Credential stores the information about a baremetal host's management controller.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "address",
    "certificateVerification",
    "hostName",
    "password",
    "username"
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
public class Credential implements Editable<CredentialBuilder>, KubernetesResource
{

    @JsonProperty("address")
    private String address;
    @JsonProperty("certificateVerification")
    private String certificateVerification;
    @JsonProperty("hostName")
    private String hostName;
    @JsonProperty("password")
    private String password;
    @JsonProperty("username")
    private String username;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public Credential() {
    }

    public Credential(String address, String certificateVerification, String hostName, String password, String username) {
        super();
        this.address = address;
        this.certificateVerification = certificateVerification;
        this.hostName = hostName;
        this.password = password;
        this.username = username;
    }

    /**
     * Credential stores the information about a baremetal host's management controller.
     */
    @JsonProperty("address")
    public String getAddress() {
        return address;
    }

    /**
     * Credential stores the information about a baremetal host's management controller.
     */
    @JsonProperty("address")
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * CertificateVerification Defines whether ssl certificate verification is required or not. If omitted, the platform chooses a default, that default is enabled.
     */
    @JsonProperty("certificateVerification")
    public String getCertificateVerification() {
        return certificateVerification;
    }

    /**
     * CertificateVerification Defines whether ssl certificate verification is required or not. If omitted, the platform chooses a default, that default is enabled.
     */
    @JsonProperty("certificateVerification")
    public void setCertificateVerification(String certificateVerification) {
        this.certificateVerification = certificateVerification;
    }

    /**
     * Credential stores the information about a baremetal host's management controller.
     */
    @JsonProperty("hostName")
    public String getHostName() {
        return hostName;
    }

    /**
     * Credential stores the information about a baremetal host's management controller.
     */
    @JsonProperty("hostName")
    public void setHostName(String hostName) {
        this.hostName = hostName;
    }

    /**
     * Credential stores the information about a baremetal host's management controller.
     */
    @JsonProperty("password")
    public String getPassword() {
        return password;
    }

    /**
     * Credential stores the information about a baremetal host's management controller.
     */
    @JsonProperty("password")
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Credential stores the information about a baremetal host's management controller.
     */
    @JsonProperty("username")
    public String getUsername() {
        return username;
    }

    /**
     * Credential stores the information about a baremetal host's management controller.
     */
    @JsonProperty("username")
    public void setUsername(String username) {
        this.username = username;
    }

    @JsonIgnore
    public CredentialBuilder edit() {
        return new CredentialBuilder(this);
    }

    @JsonIgnore
    public CredentialBuilder toBuilder() {
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
        if (!(o instanceof Credential)) {
            return false;
        }
        Credential other = (Credential) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$address = this.getAddress();
        Object other$address = other.getAddress();
        if (this$address == null ? other$address != null : !this$address.equals(other$address)) {
            return false;
        }
        Object this$certificateVerification = this.getCertificateVerification();
        Object other$certificateVerification = other.getCertificateVerification();
        if (this$certificateVerification == null ? other$certificateVerification != null : !this$certificateVerification.equals(other$certificateVerification)) {
            return false;
        }
        Object this$hostName = this.getHostName();
        Object other$hostName = other.getHostName();
        if (this$hostName == null ? other$hostName != null : !this$hostName.equals(other$hostName)) {
            return false;
        }
        Object this$password = this.getPassword();
        Object other$password = other.getPassword();
        if (this$password == null ? other$password != null : !this$password.equals(other$password)) {
            return false;
        }
        Object this$username = this.getUsername();
        Object other$username = other.getUsername();
        if (this$username == null ? other$username != null : !this$username.equals(other$username)) {
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
        return other instanceof Credential;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $address = this.getAddress();
        result = result * prime + ($address == null ? 43 : $address.hashCode());
        Object $certificateVerification = this.getCertificateVerification();
        result = result * prime + ($certificateVerification == null ? 43 : $certificateVerification.hashCode());
        Object $hostName = this.getHostName();
        result = result * prime + ($hostName == null ? 43 : $hostName.hashCode());
        Object $password = this.getPassword();
        result = result * prime + ($password == null ? 43 : $password.hashCode());
        Object $username = this.getUsername();
        result = result * prime + ($username == null ? 43 : $username.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "Credential(" + "address=" + this.getAddress() + ", certificateVerification=" + this.getCertificateVerification() + ", hostName=" + this.getHostName() + ", password=" + this.getPassword() + ", username=" + this.getUsername() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
