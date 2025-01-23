
package io.fabric8.kubernetes.api.model.gatewayapi.v1alpha3;

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
import io.fabric8.kubernetes.api.model.ObjectMeta;
import io.fabric8.kubernetes.api.model.ObjectReference;
import io.fabric8.kubernetes.api.model.PersistentVolumeClaim;
import io.fabric8.kubernetes.api.model.PodTemplateSpec;
import io.fabric8.kubernetes.api.model.ResourceRequirements;
import io.fabric8.kubernetes.api.model.Volume;
import io.fabric8.kubernetes.api.model.VolumeMount;
import io.fabric8.kubernetes.api.model.gatewayapi.v1.LocalObjectReference;
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "caCertificateRefs",
    "hostname",
    "subjectAltNames",
    "wellKnownCACertificates"
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
    @BuildableReference(io.fabric8.kubernetes.api.model.LocalObjectReference.class),
    @BuildableReference(PersistentVolumeClaim.class),
    @BuildableReference(EnvVar.class),
    @BuildableReference(ContainerPort.class),
    @BuildableReference(Volume.class),
    @BuildableReference(VolumeMount.class)
})
@Generated("io.fabric8.kubernetes.schema.generator.model.ModelGenerator")
public class BackendTLSPolicyValidation implements Editable<BackendTLSPolicyValidationBuilder>, KubernetesResource
{

    @JsonProperty("caCertificateRefs")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<LocalObjectReference> caCertificateRefs = new ArrayList<>();
    @JsonProperty("hostname")
    private String hostname;
    @JsonProperty("subjectAltNames")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<SubjectAltName> subjectAltNames = new ArrayList<>();
    @JsonProperty("wellKnownCACertificates")
    private String wellKnownCACertificates;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public BackendTLSPolicyValidation() {
    }

    public BackendTLSPolicyValidation(List<LocalObjectReference> caCertificateRefs, String hostname, List<SubjectAltName> subjectAltNames, String wellKnownCACertificates) {
        super();
        this.caCertificateRefs = caCertificateRefs;
        this.hostname = hostname;
        this.subjectAltNames = subjectAltNames;
        this.wellKnownCACertificates = wellKnownCACertificates;
    }

    @JsonProperty("caCertificateRefs")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<LocalObjectReference> getCaCertificateRefs() {
        return caCertificateRefs;
    }

    @JsonProperty("caCertificateRefs")
    public void setCaCertificateRefs(List<LocalObjectReference> caCertificateRefs) {
        this.caCertificateRefs = caCertificateRefs;
    }

    @JsonProperty("hostname")
    public String getHostname() {
        return hostname;
    }

    @JsonProperty("hostname")
    public void setHostname(String hostname) {
        this.hostname = hostname;
    }

    @JsonProperty("subjectAltNames")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<SubjectAltName> getSubjectAltNames() {
        return subjectAltNames;
    }

    @JsonProperty("subjectAltNames")
    public void setSubjectAltNames(List<SubjectAltName> subjectAltNames) {
        this.subjectAltNames = subjectAltNames;
    }

    @JsonProperty("wellKnownCACertificates")
    public String getWellKnownCACertificates() {
        return wellKnownCACertificates;
    }

    @JsonProperty("wellKnownCACertificates")
    public void setWellKnownCACertificates(String wellKnownCACertificates) {
        this.wellKnownCACertificates = wellKnownCACertificates;
    }

    @JsonIgnore
    public BackendTLSPolicyValidationBuilder edit() {
        return new BackendTLSPolicyValidationBuilder(this);
    }

    @JsonIgnore
    public BackendTLSPolicyValidationBuilder toBuilder() {
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
