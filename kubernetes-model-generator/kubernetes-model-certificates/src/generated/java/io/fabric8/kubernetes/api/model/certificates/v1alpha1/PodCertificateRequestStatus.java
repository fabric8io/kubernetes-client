
package io.fabric8.kubernetes.api.model.certificates.v1alpha1;

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
import io.fabric8.kubernetes.api.model.Condition;
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
 * PodCertificateRequestStatus describes the status of the request, and holds the certificate data if the request is issued.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "beginRefreshAt",
    "certificateChain",
    "conditions",
    "notAfter",
    "notBefore"
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
public class PodCertificateRequestStatus implements Editable<PodCertificateRequestStatusBuilder>, KubernetesResource
{

    @JsonProperty("beginRefreshAt")
    private String beginRefreshAt;
    @JsonProperty("certificateChain")
    private String certificateChain;
    @JsonProperty("conditions")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<Condition> conditions = new ArrayList<>();
    @JsonProperty("notAfter")
    private String notAfter;
    @JsonProperty("notBefore")
    private String notBefore;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public PodCertificateRequestStatus() {
    }

    public PodCertificateRequestStatus(String beginRefreshAt, String certificateChain, List<Condition> conditions, String notAfter, String notBefore) {
        super();
        this.beginRefreshAt = beginRefreshAt;
        this.certificateChain = certificateChain;
        this.conditions = conditions;
        this.notAfter = notAfter;
        this.notBefore = notBefore;
    }

    /**
     * PodCertificateRequestStatus describes the status of the request, and holds the certificate data if the request is issued.
     */
    @JsonProperty("beginRefreshAt")
    public String getBeginRefreshAt() {
        return beginRefreshAt;
    }

    /**
     * PodCertificateRequestStatus describes the status of the request, and holds the certificate data if the request is issued.
     */
    @JsonProperty("beginRefreshAt")
    public void setBeginRefreshAt(String beginRefreshAt) {
        this.beginRefreshAt = beginRefreshAt;
    }

    /**
     * certificateChain is populated with an issued certificate by the signer. This field is set via the /status subresource. Once populated, this field is immutable.<br><p> <br><p> If the certificate signing request is denied, a condition of type "Denied" is added and this field remains empty. If the signer cannot issue the certificate, a condition of type "Failed" is added and this field remains empty.<br><p> <br><p> Validation requirements:<br><p>  1. certificateChain must consist of one or more PEM-formatted certificates.<br><p>  2. Each entry must be a valid PEM-wrapped, DER-encoded ASN.1 Certificate as<br><p>     described in section 4 of RFC5280.<br><p> <br><p> If more than one block is present, and the definition of the requested spec.signerName does not indicate otherwise, the first block is the issued certificate, and subsequent blocks should be treated as intermediate certificates and presented in TLS handshakes.  When projecting the chain into a pod volume, kubelet will drop any data in-between the PEM blocks, as well as any PEM block headers.
     */
    @JsonProperty("certificateChain")
    public String getCertificateChain() {
        return certificateChain;
    }

    /**
     * certificateChain is populated with an issued certificate by the signer. This field is set via the /status subresource. Once populated, this field is immutable.<br><p> <br><p> If the certificate signing request is denied, a condition of type "Denied" is added and this field remains empty. If the signer cannot issue the certificate, a condition of type "Failed" is added and this field remains empty.<br><p> <br><p> Validation requirements:<br><p>  1. certificateChain must consist of one or more PEM-formatted certificates.<br><p>  2. Each entry must be a valid PEM-wrapped, DER-encoded ASN.1 Certificate as<br><p>     described in section 4 of RFC5280.<br><p> <br><p> If more than one block is present, and the definition of the requested spec.signerName does not indicate otherwise, the first block is the issued certificate, and subsequent blocks should be treated as intermediate certificates and presented in TLS handshakes.  When projecting the chain into a pod volume, kubelet will drop any data in-between the PEM blocks, as well as any PEM block headers.
     */
    @JsonProperty("certificateChain")
    public void setCertificateChain(String certificateChain) {
        this.certificateChain = certificateChain;
    }

    /**
     * conditions applied to the request.<br><p> <br><p> The types "Issued", "Denied", and "Failed" have special handling.  At most one of these conditions may be present, and they must have status "True".<br><p> <br><p> If the request is denied with `Reason=UnsupportedKeyType`, the signer may suggest a key type that will work in the message field.
     */
    @JsonProperty("conditions")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<Condition> getConditions() {
        return conditions;
    }

    /**
     * conditions applied to the request.<br><p> <br><p> The types "Issued", "Denied", and "Failed" have special handling.  At most one of these conditions may be present, and they must have status "True".<br><p> <br><p> If the request is denied with `Reason=UnsupportedKeyType`, the signer may suggest a key type that will work in the message field.
     */
    @JsonProperty("conditions")
    public void setConditions(List<Condition> conditions) {
        this.conditions = conditions;
    }

    /**
     * PodCertificateRequestStatus describes the status of the request, and holds the certificate data if the request is issued.
     */
    @JsonProperty("notAfter")
    public String getNotAfter() {
        return notAfter;
    }

    /**
     * PodCertificateRequestStatus describes the status of the request, and holds the certificate data if the request is issued.
     */
    @JsonProperty("notAfter")
    public void setNotAfter(String notAfter) {
        this.notAfter = notAfter;
    }

    /**
     * PodCertificateRequestStatus describes the status of the request, and holds the certificate data if the request is issued.
     */
    @JsonProperty("notBefore")
    public String getNotBefore() {
        return notBefore;
    }

    /**
     * PodCertificateRequestStatus describes the status of the request, and holds the certificate data if the request is issued.
     */
    @JsonProperty("notBefore")
    public void setNotBefore(String notBefore) {
        this.notBefore = notBefore;
    }

    @JsonIgnore
    public PodCertificateRequestStatusBuilder edit() {
        return new PodCertificateRequestStatusBuilder(this);
    }

    @JsonIgnore
    public PodCertificateRequestStatusBuilder toBuilder() {
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
