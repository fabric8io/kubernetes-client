
package io.fabric8.openshift.api.model.miscellaneous.metal3.v1alpha1;

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

/**
 * BMCDetails contains the information necessary to communicate with the bare metal controller module on host.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "address",
    "credentialsName",
    "disableCertificateVerification"
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
public class BMCDetails implements Editable<BMCDetailsBuilder>, KubernetesResource
{

    @JsonProperty("address")
    private String address;
    @JsonProperty("credentialsName")
    private String credentialsName;
    @JsonProperty("disableCertificateVerification")
    private Boolean disableCertificateVerification;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public BMCDetails() {
    }

    public BMCDetails(String address, String credentialsName, Boolean disableCertificateVerification) {
        super();
        this.address = address;
        this.credentialsName = credentialsName;
        this.disableCertificateVerification = disableCertificateVerification;
    }

    /**
     * Address holds the URL for accessing the controller on the network. The scheme part designates the driver to use with the host.
     */
    @JsonProperty("address")
    public String getAddress() {
        return address;
    }

    /**
     * Address holds the URL for accessing the controller on the network. The scheme part designates the driver to use with the host.
     */
    @JsonProperty("address")
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * The name of the secret containing the BMC credentials (requires keys "username" and "password").
     */
    @JsonProperty("credentialsName")
    public String getCredentialsName() {
        return credentialsName;
    }

    /**
     * The name of the secret containing the BMC credentials (requires keys "username" and "password").
     */
    @JsonProperty("credentialsName")
    public void setCredentialsName(String credentialsName) {
        this.credentialsName = credentialsName;
    }

    /**
     * DisableCertificateVerification disables verification of server certificates when using HTTPS to connect to the BMC. This is required when the server certificate is self-signed, but is insecure because it allows a man-in-the-middle to intercept the connection.
     */
    @JsonProperty("disableCertificateVerification")
    public Boolean getDisableCertificateVerification() {
        return disableCertificateVerification;
    }

    /**
     * DisableCertificateVerification disables verification of server certificates when using HTTPS to connect to the BMC. This is required when the server certificate is self-signed, but is insecure because it allows a man-in-the-middle to intercept the connection.
     */
    @JsonProperty("disableCertificateVerification")
    public void setDisableCertificateVerification(Boolean disableCertificateVerification) {
        this.disableCertificateVerification = disableCertificateVerification;
    }

    @JsonIgnore
    public BMCDetailsBuilder edit() {
        return new BMCDetailsBuilder(this);
    }

    @JsonIgnore
    public BMCDetailsBuilder toBuilder() {
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
        if (!(o instanceof BMCDetails)) {
            return false;
        }
        BMCDetails other = (BMCDetails) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$address = this.getAddress();
        Object other$address = other.getAddress();
        if (this$address == null ? other$address != null : !this$address.equals(other$address)) {
            return false;
        }
        Object this$credentialsName = this.getCredentialsName();
        Object other$credentialsName = other.getCredentialsName();
        if (this$credentialsName == null ? other$credentialsName != null : !this$credentialsName.equals(other$credentialsName)) {
            return false;
        }
        Object this$disableCertificateVerification = this.getDisableCertificateVerification();
        Object other$disableCertificateVerification = other.getDisableCertificateVerification();
        if (this$disableCertificateVerification == null ? other$disableCertificateVerification != null : !this$disableCertificateVerification.equals(other$disableCertificateVerification)) {
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
        return other instanceof BMCDetails;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $address = this.getAddress();
        result = result * prime + ($address == null ? 43 : $address.hashCode());
        Object $credentialsName = this.getCredentialsName();
        result = result * prime + ($credentialsName == null ? 43 : $credentialsName.hashCode());
        Object $disableCertificateVerification = this.getDisableCertificateVerification();
        result = result * prime + ($disableCertificateVerification == null ? 43 : $disableCertificateVerification.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "BMCDetails(" + "address=" + this.getAddress() + ", credentialsName=" + this.getCredentialsName() + ", disableCertificateVerification=" + this.getDisableCertificateVerification() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
