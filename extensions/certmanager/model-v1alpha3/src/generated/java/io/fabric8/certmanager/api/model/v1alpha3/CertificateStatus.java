
package io.fabric8.certmanager.api.model.v1alpha3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
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
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "apiVersion",
    "kind",
    "metadata",
    "conditions",
    "lastFailureTime",
    "nextPrivateKeySecretName",
    "notAfter",
    "notBefore",
    "renewalTime",
    "revision"
})
@ToString
@EqualsAndHashCode
@Setter
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
public class CertificateStatus implements KubernetesResource
{

    @JsonProperty("conditions")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<CertificateCondition> conditions = new ArrayList<CertificateCondition>();
    @JsonProperty("lastFailureTime")
    private java.lang.String lastFailureTime;
    @JsonProperty("nextPrivateKeySecretName")
    private String nextPrivateKeySecretName;
    @JsonProperty("notAfter")
    private java.lang.String notAfter;
    @JsonProperty("notBefore")
    private java.lang.String notBefore;
    @JsonProperty("renewalTime")
    private java.lang.String renewalTime;
    @JsonProperty("revision")
    private Integer revision;
    @JsonIgnore
    private Map<java.lang.String, Object> additionalProperties = new HashMap<java.lang.String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public CertificateStatus() {
    }

    /**
     * 
     * @param renewalTime
     * @param notAfter
     * @param nextPrivateKeySecretName
     * @param lastFailureTime
     * @param conditions
     * @param notBefore
     * @param revision
     */
    public CertificateStatus(List<CertificateCondition> conditions, java.lang.String lastFailureTime, String nextPrivateKeySecretName, java.lang.String notAfter, java.lang.String notBefore, java.lang.String renewalTime, Integer revision) {
        super();
        this.conditions = conditions;
        this.lastFailureTime = lastFailureTime;
        this.nextPrivateKeySecretName = nextPrivateKeySecretName;
        this.notAfter = notAfter;
        this.notBefore = notBefore;
        this.renewalTime = renewalTime;
        this.revision = revision;
    }

    @JsonProperty("conditions")
    public List<CertificateCondition> getConditions() {
        return conditions;
    }

    @JsonProperty("conditions")
    public void setConditions(List<CertificateCondition> conditions) {
        this.conditions = conditions;
    }

    @JsonProperty("lastFailureTime")
    public java.lang.String getLastFailureTime() {
        return lastFailureTime;
    }

    @JsonProperty("lastFailureTime")
    public void setLastFailureTime(java.lang.String lastFailureTime) {
        this.lastFailureTime = lastFailureTime;
    }

    @JsonProperty("nextPrivateKeySecretName")
    public String getNextPrivateKeySecretName() {
        return nextPrivateKeySecretName;
    }

    @JsonProperty("nextPrivateKeySecretName")
    public void setNextPrivateKeySecretName(String nextPrivateKeySecretName) {
        this.nextPrivateKeySecretName = nextPrivateKeySecretName;
    }

    @JsonProperty("notAfter")
    public java.lang.String getNotAfter() {
        return notAfter;
    }

    @JsonProperty("notAfter")
    public void setNotAfter(java.lang.String notAfter) {
        this.notAfter = notAfter;
    }

    @JsonProperty("notBefore")
    public java.lang.String getNotBefore() {
        return notBefore;
    }

    @JsonProperty("notBefore")
    public void setNotBefore(java.lang.String notBefore) {
        this.notBefore = notBefore;
    }

    @JsonProperty("renewalTime")
    public java.lang.String getRenewalTime() {
        return renewalTime;
    }

    @JsonProperty("renewalTime")
    public void setRenewalTime(java.lang.String renewalTime) {
        this.renewalTime = renewalTime;
    }

    @JsonProperty("revision")
    public Integer getRevision() {
        return revision;
    }

    @JsonProperty("revision")
    public void setRevision(Integer revision) {
        this.revision = revision;
    }

    @JsonAnyGetter
    public Map<java.lang.String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(java.lang.String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
