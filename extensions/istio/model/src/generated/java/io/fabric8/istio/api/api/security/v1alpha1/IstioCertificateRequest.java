
package io.fabric8.istio.api.api.security.v1alpha1;

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
 * Certificate request message. The authentication should be based on: 1. Bearer tokens carried in the side channel; 2. Client-side certificate via Mutual TLS handshake. Note: the service implementation is REQUIRED to verify the authenticated caller is authorize to all SANs in the CSR. The server side may overwrite any requested certificate field based on its policies.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "metadata",
    "csr",
    "validityDuration"
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
public class IstioCertificateRequest implements Editable<IstioCertificateRequestBuilder>, KubernetesResource
{

    @JsonProperty("csr")
    private String csr;
    @JsonProperty("metadata")
    @JsonDeserialize(using = io.fabric8.kubernetes.internal.KubernetesDeserializer.class)
    private Object metadata;
    @JsonProperty("validityDuration")
    private Long validityDuration;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public IstioCertificateRequest() {
    }

    public IstioCertificateRequest(String csr, Object metadata, Long validityDuration) {
        super();
        this.csr = csr;
        this.metadata = metadata;
        this.validityDuration = validityDuration;
    }

    /**
     * PEM-encoded certificate request. The public key in the CSR is used to generate the certificate, and other fields in the generated certificate may be overwritten by the CA.
     */
    @JsonProperty("csr")
    public String getCsr() {
        return csr;
    }

    /**
     * PEM-encoded certificate request. The public key in the CSR is used to generate the certificate, and other fields in the generated certificate may be overwritten by the CA.
     */
    @JsonProperty("csr")
    public void setCsr(String csr) {
        this.csr = csr;
    }

    /**
     * Certificate request message. The authentication should be based on: 1. Bearer tokens carried in the side channel; 2. Client-side certificate via Mutual TLS handshake. Note: the service implementation is REQUIRED to verify the authenticated caller is authorize to all SANs in the CSR. The server side may overwrite any requested certificate field based on its policies.
     */
    @JsonProperty("metadata")
    public Object getMetadata() {
        return metadata;
    }

    /**
     * Certificate request message. The authentication should be based on: 1. Bearer tokens carried in the side channel; 2. Client-side certificate via Mutual TLS handshake. Note: the service implementation is REQUIRED to verify the authenticated caller is authorize to all SANs in the CSR. The server side may overwrite any requested certificate field based on its policies.
     */
    @JsonProperty("metadata")
    @JsonDeserialize(using = io.fabric8.kubernetes.internal.KubernetesDeserializer.class)
    public void setMetadata(Object metadata) {
        this.metadata = metadata;
    }

    /**
     * Optional: requested certificate validity period, in seconds.
     */
    @JsonProperty("validityDuration")
    public Long getValidityDuration() {
        return validityDuration;
    }

    /**
     * Optional: requested certificate validity period, in seconds.
     */
    @JsonProperty("validityDuration")
    public void setValidityDuration(Long validityDuration) {
        this.validityDuration = validityDuration;
    }

    @JsonIgnore
    public IstioCertificateRequestBuilder edit() {
        return new IstioCertificateRequestBuilder(this);
    }

    @JsonIgnore
    public IstioCertificateRequestBuilder toBuilder() {
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
