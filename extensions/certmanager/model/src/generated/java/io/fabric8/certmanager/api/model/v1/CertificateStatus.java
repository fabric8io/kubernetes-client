
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
        if (!(o instanceof CertificateStatus)) {
            return false;
        }
        CertificateStatus other = (CertificateStatus) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$conditions = this.getConditions();
        Object other$conditions = other.getConditions();
        if (this$conditions == null ? other$conditions != null : !this$conditions.equals(other$conditions)) {
            return false;
        }
        Object this$failedIssuanceAttempts = this.getFailedIssuanceAttempts();
        Object other$failedIssuanceAttempts = other.getFailedIssuanceAttempts();
        if (this$failedIssuanceAttempts == null ? other$failedIssuanceAttempts != null : !this$failedIssuanceAttempts.equals(other$failedIssuanceAttempts)) {
            return false;
        }
        Object this$lastFailureTime = this.getLastFailureTime();
        Object other$lastFailureTime = other.getLastFailureTime();
        if (this$lastFailureTime == null ? other$lastFailureTime != null : !this$lastFailureTime.equals(other$lastFailureTime)) {
            return false;
        }
        Object this$nextPrivateKeySecretName = this.getNextPrivateKeySecretName();
        Object other$nextPrivateKeySecretName = other.getNextPrivateKeySecretName();
        if (this$nextPrivateKeySecretName == null ? other$nextPrivateKeySecretName != null : !this$nextPrivateKeySecretName.equals(other$nextPrivateKeySecretName)) {
            return false;
        }
        Object this$notAfter = this.getNotAfter();
        Object other$notAfter = other.getNotAfter();
        if (this$notAfter == null ? other$notAfter != null : !this$notAfter.equals(other$notAfter)) {
            return false;
        }
        Object this$notBefore = this.getNotBefore();
        Object other$notBefore = other.getNotBefore();
        if (this$notBefore == null ? other$notBefore != null : !this$notBefore.equals(other$notBefore)) {
            return false;
        }
        Object this$renewalTime = this.getRenewalTime();
        Object other$renewalTime = other.getRenewalTime();
        if (this$renewalTime == null ? other$renewalTime != null : !this$renewalTime.equals(other$renewalTime)) {
            return false;
        }
        Object this$revision = this.getRevision();
        Object other$revision = other.getRevision();
        if (this$revision == null ? other$revision != null : !this$revision.equals(other$revision)) {
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
        return other instanceof CertificateStatus;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $conditions = this.getConditions();
        result = result * prime + ($conditions == null ? 43 : $conditions.hashCode());
        Object $failedIssuanceAttempts = this.getFailedIssuanceAttempts();
        result = result * prime + ($failedIssuanceAttempts == null ? 43 : $failedIssuanceAttempts.hashCode());
        Object $lastFailureTime = this.getLastFailureTime();
        result = result * prime + ($lastFailureTime == null ? 43 : $lastFailureTime.hashCode());
        Object $nextPrivateKeySecretName = this.getNextPrivateKeySecretName();
        result = result * prime + ($nextPrivateKeySecretName == null ? 43 : $nextPrivateKeySecretName.hashCode());
        Object $notAfter = this.getNotAfter();
        result = result * prime + ($notAfter == null ? 43 : $notAfter.hashCode());
        Object $notBefore = this.getNotBefore();
        result = result * prime + ($notBefore == null ? 43 : $notBefore.hashCode());
        Object $renewalTime = this.getRenewalTime();
        result = result * prime + ($renewalTime == null ? 43 : $renewalTime.hashCode());
        Object $revision = this.getRevision();
        result = result * prime + ($revision == null ? 43 : $revision.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "CertificateStatus(" + "conditions=" + this.getConditions() + ", failedIssuanceAttempts=" + this.getFailedIssuanceAttempts() + ", lastFailureTime=" + this.getLastFailureTime() + ", nextPrivateKeySecretName=" + this.getNextPrivateKeySecretName() + ", notAfter=" + this.getNotAfter() + ", notBefore=" + this.getNotBefore() + ", renewalTime=" + this.getRenewalTime() + ", revision=" + this.getRevision() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
