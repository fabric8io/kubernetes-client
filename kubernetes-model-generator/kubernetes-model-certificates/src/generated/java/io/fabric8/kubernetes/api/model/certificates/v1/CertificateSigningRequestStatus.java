
package io.fabric8.kubernetes.api.model.certificates.v1;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
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
 * CertificateSigningRequestStatus contains conditions used to indicate approved/denied/failed status of the request, and the issued certificate.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "certificate",
    "conditions"
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
public class CertificateSigningRequestStatus implements Editable<CertificateSigningRequestStatusBuilder>, KubernetesResource
{

    @JsonProperty("certificate")
    private String certificate;
    @JsonProperty("conditions")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<CertificateSigningRequestCondition> conditions = new ArrayList<>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public CertificateSigningRequestStatus() {
    }

    public CertificateSigningRequestStatus(String certificate, List<CertificateSigningRequestCondition> conditions) {
        super();
        this.certificate = certificate;
        this.conditions = conditions;
    }

    /**
     * certificate is populated with an issued certificate by the signer after an Approved condition is present. This field is set via the /status subresource. Once populated, this field is immutable.<br><p> <br><p> If the certificate signing request is denied, a condition of type "Denied" is added and this field remains empty. If the signer cannot issue the certificate, a condition of type "Failed" is added and this field remains empty.<br><p> <br><p> Validation requirements:<br><p>  1. certificate must contain one or more PEM blocks.<br><p>  2. All PEM blocks must have the "CERTIFICATE" label, contain no headers, and the encoded data<br><p>   must be a BER-encoded ASN.1 Certificate structure as described in section 4 of RFC5280.<br><p>  3. Non-PEM content may appear before or after the "CERTIFICATE" PEM blocks and is unvalidated,<br><p>   to allow for explanatory text as described in section 5.2 of RFC7468.<br><p> <br><p> If more than one PEM block is present, and the definition of the requested spec.signerName does not indicate otherwise, the first block is the issued certificate, and subsequent blocks should be treated as intermediate certificates and presented in TLS handshakes.<br><p> <br><p> The certificate is encoded in PEM format.<br><p> <br><p> When serialized as JSON or YAML, the data is additionally base64-encoded, so it consists of:<br><p> <br><p>     base64(<br><p>     -----BEGIN CERTIFICATE-----<br><p>     ...<br><p>     -----END CERTIFICATE-----<br><p>     )
     */
    @JsonProperty("certificate")
    public String getCertificate() {
        return certificate;
    }

    /**
     * certificate is populated with an issued certificate by the signer after an Approved condition is present. This field is set via the /status subresource. Once populated, this field is immutable.<br><p> <br><p> If the certificate signing request is denied, a condition of type "Denied" is added and this field remains empty. If the signer cannot issue the certificate, a condition of type "Failed" is added and this field remains empty.<br><p> <br><p> Validation requirements:<br><p>  1. certificate must contain one or more PEM blocks.<br><p>  2. All PEM blocks must have the "CERTIFICATE" label, contain no headers, and the encoded data<br><p>   must be a BER-encoded ASN.1 Certificate structure as described in section 4 of RFC5280.<br><p>  3. Non-PEM content may appear before or after the "CERTIFICATE" PEM blocks and is unvalidated,<br><p>   to allow for explanatory text as described in section 5.2 of RFC7468.<br><p> <br><p> If more than one PEM block is present, and the definition of the requested spec.signerName does not indicate otherwise, the first block is the issued certificate, and subsequent blocks should be treated as intermediate certificates and presented in TLS handshakes.<br><p> <br><p> The certificate is encoded in PEM format.<br><p> <br><p> When serialized as JSON or YAML, the data is additionally base64-encoded, so it consists of:<br><p> <br><p>     base64(<br><p>     -----BEGIN CERTIFICATE-----<br><p>     ...<br><p>     -----END CERTIFICATE-----<br><p>     )
     */
    @JsonProperty("certificate")
    public void setCertificate(String certificate) {
        this.certificate = certificate;
    }

    /**
     * conditions applied to the request. Known conditions are "Approved", "Denied", and "Failed".
     */
    @JsonProperty("conditions")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<CertificateSigningRequestCondition> getConditions() {
        return conditions;
    }

    /**
     * conditions applied to the request. Known conditions are "Approved", "Denied", and "Failed".
     */
    @JsonProperty("conditions")
    public void setConditions(List<CertificateSigningRequestCondition> conditions) {
        this.conditions = conditions;
    }

    @JsonIgnore
    public CertificateSigningRequestStatusBuilder edit() {
        return new CertificateSigningRequestStatusBuilder(this);
    }

    @JsonIgnore
    public CertificateSigningRequestStatusBuilder toBuilder() {
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
