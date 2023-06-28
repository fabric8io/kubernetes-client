
package io.fabric8.certmanager.api.model.v1alpha2;

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
import io.fabric8.kubernetes.api.model.Container;
import io.fabric8.kubernetes.api.model.ContainerPort;
import io.fabric8.kubernetes.api.model.Duration;
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
    "csr",
    "duration",
    "extra",
    "groups",
    "isCA",
    "issuerRef",
    "uid",
    "usages",
    "username"
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
    @BuildableReference(io.fabric8.kubernetes.api.model.ObjectReference.class),
    @BuildableReference(LocalObjectReference.class),
    @BuildableReference(PersistentVolumeClaim.class),
    @BuildableReference(EnvVar.class),
    @BuildableReference(ContainerPort.class),
    @BuildableReference(Volume.class),
    @BuildableReference(VolumeMount.class)
})
@Generated("jsonschema2pojo")
public class CertificateRequestSpec implements KubernetesResource
{

    @JsonProperty("csr")
    private java.lang.String csr;
    @JsonProperty("duration")
    private Duration duration;
    @JsonProperty("extra")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Map<String, List<String>> extra = new LinkedHashMap<String, List<String>>();
    @JsonProperty("groups")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<java.lang.String> groups = new ArrayList<java.lang.String>();
    @JsonProperty("isCA")
    private Boolean isCA;
    @JsonProperty("issuerRef")
    private io.fabric8.certmanager.api.model.meta.v1.ObjectReference issuerRef;
    @JsonProperty("uid")
    private java.lang.String uid;
    @JsonProperty("usages")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<java.lang.String> usages = new ArrayList<java.lang.String>();
    @JsonProperty("username")
    private java.lang.String username;
    @JsonIgnore
    private Map<java.lang.String, Object> additionalProperties = new LinkedHashMap<java.lang.String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public CertificateRequestSpec() {
    }

    public CertificateRequestSpec(java.lang.String csr, Duration duration, Map<String, List<String>> extra, List<java.lang.String> groups, Boolean isCA, io.fabric8.certmanager.api.model.meta.v1.ObjectReference issuerRef, java.lang.String uid, List<java.lang.String> usages, java.lang.String username) {
        super();
        this.csr = csr;
        this.duration = duration;
        this.extra = extra;
        this.groups = groups;
        this.isCA = isCA;
        this.issuerRef = issuerRef;
        this.uid = uid;
        this.usages = usages;
        this.username = username;
    }

    @JsonProperty("csr")
    public java.lang.String getCsr() {
        return csr;
    }

    @JsonProperty("csr")
    public void setCsr(java.lang.String csr) {
        this.csr = csr;
    }

    @JsonProperty("duration")
    public Duration getDuration() {
        return duration;
    }

    @JsonProperty("duration")
    public void setDuration(Duration duration) {
        this.duration = duration;
    }

    @JsonProperty("extra")
    public Map<String, List<String>> getExtra() {
        return extra;
    }

    @JsonProperty("extra")
    public void setExtra(Map<String, List<String>> extra) {
        this.extra = extra;
    }

    @JsonProperty("groups")
    public List<java.lang.String> getGroups() {
        return groups;
    }

    @JsonProperty("groups")
    public void setGroups(List<java.lang.String> groups) {
        this.groups = groups;
    }

    @JsonProperty("isCA")
    public Boolean getIsCA() {
        return isCA;
    }

    @JsonProperty("isCA")
    public void setIsCA(Boolean isCA) {
        this.isCA = isCA;
    }

    @JsonProperty("issuerRef")
    public io.fabric8.certmanager.api.model.meta.v1.ObjectReference getIssuerRef() {
        return issuerRef;
    }

    @JsonProperty("issuerRef")
    public void setIssuerRef(io.fabric8.certmanager.api.model.meta.v1.ObjectReference issuerRef) {
        this.issuerRef = issuerRef;
    }

    @JsonProperty("uid")
    public java.lang.String getUid() {
        return uid;
    }

    @JsonProperty("uid")
    public void setUid(java.lang.String uid) {
        this.uid = uid;
    }

    @JsonProperty("usages")
    public List<java.lang.String> getUsages() {
        return usages;
    }

    @JsonProperty("usages")
    public void setUsages(List<java.lang.String> usages) {
        this.usages = usages;
    }

    @JsonProperty("username")
    public java.lang.String getUsername() {
        return username;
    }

    @JsonProperty("username")
    public void setUsername(java.lang.String username) {
        this.username = username;
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
