
package io.fabric8.certmanager.api.model.v1;

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
 * CertificateRequestStatus defines the observed state of CertificateRequest and resulting signed certificate.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "ca",
    "certificate",
    "conditions",
    "failureTime"
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
public class CertificateRequestStatus implements Editable<CertificateRequestStatusBuilder>, KubernetesResource
{

    @JsonProperty("ca")
    private String ca;
    @JsonProperty("certificate")
    private String certificate;
    @JsonProperty("conditions")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<CertificateRequestCondition> conditions = new ArrayList<>();
    @JsonProperty("failureTime")
    private String failureTime;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public CertificateRequestStatus() {
    }

    public CertificateRequestStatus(String ca, String certificate, List<CertificateRequestCondition> conditions, String failureTime) {
        super();
        this.ca = ca;
        this.certificate = certificate;
        this.conditions = conditions;
        this.failureTime = failureTime;
    }

    /**
     * The PEM encoded X.509 certificate of the signer, also known as the CA (Certificate Authority). This is set on a best-effort basis by different issuers. If not set, the CA is assumed to be unknown/not available.
     */
    @JsonProperty("ca")
    public String getCa() {
        return ca;
    }

    /**
     * The PEM encoded X.509 certificate of the signer, also known as the CA (Certificate Authority). This is set on a best-effort basis by different issuers. If not set, the CA is assumed to be unknown/not available.
     */
    @JsonProperty("ca")
    public void setCa(String ca) {
        this.ca = ca;
    }

    /**
     * The PEM encoded X.509 certificate resulting from the certificate signing request. If not set, the CertificateRequest has either not been completed or has failed. More information on failure can be found by checking the `conditions` field.
     */
    @JsonProperty("certificate")
    public String getCertificate() {
        return certificate;
    }

    /**
     * The PEM encoded X.509 certificate resulting from the certificate signing request. If not set, the CertificateRequest has either not been completed or has failed. More information on failure can be found by checking the `conditions` field.
     */
    @JsonProperty("certificate")
    public void setCertificate(String certificate) {
        this.certificate = certificate;
    }

    /**
     * List of status conditions to indicate the status of a CertificateRequest. Known condition types are `Ready`, `InvalidRequest`, `Approved` and `Denied`.
     */
    @JsonProperty("conditions")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<CertificateRequestCondition> getConditions() {
        return conditions;
    }

    /**
     * List of status conditions to indicate the status of a CertificateRequest. Known condition types are `Ready`, `InvalidRequest`, `Approved` and `Denied`.
     */
    @JsonProperty("conditions")
    public void setConditions(List<CertificateRequestCondition> conditions) {
        this.conditions = conditions;
    }

    /**
     * CertificateRequestStatus defines the observed state of CertificateRequest and resulting signed certificate.
     */
    @JsonProperty("failureTime")
    public String getFailureTime() {
        return failureTime;
    }

    /**
     * CertificateRequestStatus defines the observed state of CertificateRequest and resulting signed certificate.
     */
    @JsonProperty("failureTime")
    public void setFailureTime(String failureTime) {
        this.failureTime = failureTime;
    }

    @JsonIgnore
    public CertificateRequestStatusBuilder edit() {
        return new CertificateRequestStatusBuilder(this);
    }

    @JsonIgnore
    public CertificateRequestStatusBuilder toBuilder() {
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
