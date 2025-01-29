
package io.fabric8.certmanager.api.model.v1;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Generated;
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
 * CertificateStatus defines the observed state of Certificate
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "conditions",
    "failedIssuanceAttempts",
    "lastFailureTime",
    "nextPrivateKeySecretName",
    "notAfter",
    "notBefore",
    "renewalTime",
    "revision"
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
public class CertificateStatus implements Editable<CertificateStatusBuilder>, KubernetesResource
{

    @JsonProperty("conditions")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<CertificateCondition> conditions = new ArrayList<>();
    @JsonProperty("failedIssuanceAttempts")
    private Integer failedIssuanceAttempts;
    @JsonProperty("lastFailureTime")
    private String lastFailureTime;
    @JsonProperty("nextPrivateKeySecretName")
    private String nextPrivateKeySecretName;
    @JsonProperty("notAfter")
    private String notAfter;
    @JsonProperty("notBefore")
    private String notBefore;
    @JsonProperty("renewalTime")
    private String renewalTime;
    @JsonProperty("revision")
    private Integer revision;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public CertificateStatus() {
    }

    public CertificateStatus(List<CertificateCondition> conditions, Integer failedIssuanceAttempts, String lastFailureTime, String nextPrivateKeySecretName, String notAfter, String notBefore, String renewalTime, Integer revision) {
        super();
        this.conditions = conditions;
        this.failedIssuanceAttempts = failedIssuanceAttempts;
        this.lastFailureTime = lastFailureTime;
        this.nextPrivateKeySecretName = nextPrivateKeySecretName;
        this.notAfter = notAfter;
        this.notBefore = notBefore;
        this.renewalTime = renewalTime;
        this.revision = revision;
    }

    /**
     * List of status conditions to indicate the status of certificates. Known condition types are `Ready` and `Issuing`.
     */
    @JsonProperty("conditions")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<CertificateCondition> getConditions() {
        return conditions;
    }

    /**
     * List of status conditions to indicate the status of certificates. Known condition types are `Ready` and `Issuing`.
     */
    @JsonProperty("conditions")
    public void setConditions(List<CertificateCondition> conditions) {
        this.conditions = conditions;
    }

    /**
     * The number of continuous failed issuance attempts up till now. This field gets removed (if set) on a successful issuance and gets set to 1 if unset and an issuance has failed. If an issuance has failed, the delay till the next issuance will be calculated using formula time.Hour &#42; 2 ^ (failedIssuanceAttempts - 1).
     */
    @JsonProperty("failedIssuanceAttempts")
    public Integer getFailedIssuanceAttempts() {
        return failedIssuanceAttempts;
    }

    /**
     * The number of continuous failed issuance attempts up till now. This field gets removed (if set) on a successful issuance and gets set to 1 if unset and an issuance has failed. If an issuance has failed, the delay till the next issuance will be calculated using formula time.Hour &#42; 2 ^ (failedIssuanceAttempts - 1).
     */
    @JsonProperty("failedIssuanceAttempts")
    public void setFailedIssuanceAttempts(Integer failedIssuanceAttempts) {
        this.failedIssuanceAttempts = failedIssuanceAttempts;
    }

    /**
     * CertificateStatus defines the observed state of Certificate
     */
    @JsonProperty("lastFailureTime")
    public String getLastFailureTime() {
        return lastFailureTime;
    }

    /**
     * CertificateStatus defines the observed state of Certificate
     */
    @JsonProperty("lastFailureTime")
    public void setLastFailureTime(String lastFailureTime) {
        this.lastFailureTime = lastFailureTime;
    }

    /**
     * The name of the Secret resource containing the private key to be used for the next certificate iteration. The keymanager controller will automatically set this field if the `Issuing` condition is set to `True`. It will automatically unset this field when the Issuing condition is not set or False.
     */
    @JsonProperty("nextPrivateKeySecretName")
    public String getNextPrivateKeySecretName() {
        return nextPrivateKeySecretName;
    }

    /**
     * The name of the Secret resource containing the private key to be used for the next certificate iteration. The keymanager controller will automatically set this field if the `Issuing` condition is set to `True`. It will automatically unset this field when the Issuing condition is not set or False.
     */
    @JsonProperty("nextPrivateKeySecretName")
    public void setNextPrivateKeySecretName(String nextPrivateKeySecretName) {
        this.nextPrivateKeySecretName = nextPrivateKeySecretName;
    }

    /**
     * CertificateStatus defines the observed state of Certificate
     */
    @JsonProperty("notAfter")
    public String getNotAfter() {
        return notAfter;
    }

    /**
     * CertificateStatus defines the observed state of Certificate
     */
    @JsonProperty("notAfter")
    public void setNotAfter(String notAfter) {
        this.notAfter = notAfter;
    }

    /**
     * CertificateStatus defines the observed state of Certificate
     */
    @JsonProperty("notBefore")
    public String getNotBefore() {
        return notBefore;
    }

    /**
     * CertificateStatus defines the observed state of Certificate
     */
    @JsonProperty("notBefore")
    public void setNotBefore(String notBefore) {
        this.notBefore = notBefore;
    }

    /**
     * CertificateStatus defines the observed state of Certificate
     */
    @JsonProperty("renewalTime")
    public String getRenewalTime() {
        return renewalTime;
    }

    /**
     * CertificateStatus defines the observed state of Certificate
     */
    @JsonProperty("renewalTime")
    public void setRenewalTime(String renewalTime) {
        this.renewalTime = renewalTime;
    }

    /**
     * The current 'revision' of the certificate as issued.<br><p> <br><p> When a CertificateRequest resource is created, it will have the `cert-manager.io/certificate-revision` set to one greater than the current value of this field.<br><p> <br><p> Upon issuance, this field will be set to the value of the annotation on the CertificateRequest resource used to issue the certificate.<br><p> <br><p> Persisting the value on the CertificateRequest resource allows the certificates controller to know whether a request is part of an old issuance or if it is part of the ongoing revision's issuance by checking if the revision value in the annotation is greater than this field.
     */
    @JsonProperty("revision")
    public Integer getRevision() {
        return revision;
    }

    /**
     * The current 'revision' of the certificate as issued.<br><p> <br><p> When a CertificateRequest resource is created, it will have the `cert-manager.io/certificate-revision` set to one greater than the current value of this field.<br><p> <br><p> Upon issuance, this field will be set to the value of the annotation on the CertificateRequest resource used to issue the certificate.<br><p> <br><p> Persisting the value on the CertificateRequest resource allows the certificates controller to know whether a request is part of an old issuance or if it is part of the ongoing revision's issuance by checking if the revision value in the annotation is greater than this field.
     */
    @JsonProperty("revision")
    public void setRevision(Integer revision) {
        this.revision = revision;
    }

    @JsonIgnore
    public CertificateStatusBuilder edit() {
        return new CertificateStatusBuilder(this);
    }

    @JsonIgnore
    public CertificateStatusBuilder toBuilder() {
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
