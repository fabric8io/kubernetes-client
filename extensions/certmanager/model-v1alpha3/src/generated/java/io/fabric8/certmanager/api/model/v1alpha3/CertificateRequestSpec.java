
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
    "isCA",
    "issuerRef",
    "usages"
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
public class CertificateRequestSpec implements KubernetesResource
{

    @JsonProperty("csr")
    private String csr;
    @JsonProperty("duration")
    private Duration duration;
    @JsonProperty("isCA")
    private Boolean isCA;
    @JsonProperty("issuerRef")
    private io.fabric8.certmanager.api.model.meta.v1.ObjectReference issuerRef;
    @JsonProperty("usages")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> usages = new ArrayList<String>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public CertificateRequestSpec() {
    }

    /**
     * 
     * @param duration
     * @param csr
     * @param isCA
     * @param issuerRef
     * @param usages
     */
    public CertificateRequestSpec(String csr, Duration duration, Boolean isCA, io.fabric8.certmanager.api.model.meta.v1.ObjectReference issuerRef, List<String> usages) {
        super();
        this.csr = csr;
        this.duration = duration;
        this.isCA = isCA;
        this.issuerRef = issuerRef;
        this.usages = usages;
    }

    @JsonProperty("csr")
    public String getCsr() {
        return csr;
    }

    @JsonProperty("csr")
    public void setCsr(String csr) {
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

    @JsonProperty("usages")
    public List<String> getUsages() {
        return usages;
    }

    @JsonProperty("usages")
    public void setUsages(List<String> usages) {
        this.usages = usages;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
