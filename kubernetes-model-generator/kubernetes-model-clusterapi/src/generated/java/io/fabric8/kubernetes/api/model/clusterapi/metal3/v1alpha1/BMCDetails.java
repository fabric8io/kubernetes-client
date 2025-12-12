
package io.fabric8.kubernetes.api.model.clusterapi.metal3.v1alpha1;

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
 * BMCDetails contains the information necessary to communicate with the bare metal controller module on host.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "address",
    "credentialsName",
    "disableCertificateVerification"
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

}
