
package io.fabric8.openshift.api.model;

import java.util.LinkedHashMap;
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

@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "caCertificate",
    "certificate",
    "destinationCACertificate",
    "externalCertificate",
    "insecureEdgeTerminationPolicy",
    "key",
    "termination"
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
public class TLSConfig implements Editable<TLSConfigBuilder> , KubernetesResource
{

    @JsonProperty("caCertificate")
    private String caCertificate;
    @JsonProperty("certificate")
    private String certificate;
    @JsonProperty("destinationCACertificate")
    private String destinationCACertificate;
    @JsonProperty("externalCertificate")
    private LocalObjectReference externalCertificate;
    @JsonProperty("insecureEdgeTerminationPolicy")
    private String insecureEdgeTerminationPolicy;
    @JsonProperty("key")
    private String key;
    @JsonProperty("termination")
    private String termination;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public TLSConfig() {
    }

    public TLSConfig(String caCertificate, String certificate, String destinationCACertificate, LocalObjectReference externalCertificate, String insecureEdgeTerminationPolicy, String key, String termination) {
        super();
        this.caCertificate = caCertificate;
        this.certificate = certificate;
        this.destinationCACertificate = destinationCACertificate;
        this.externalCertificate = externalCertificate;
        this.insecureEdgeTerminationPolicy = insecureEdgeTerminationPolicy;
        this.key = key;
        this.termination = termination;
    }

    @JsonProperty("caCertificate")
    public String getCaCertificate() {
        return caCertificate;
    }

    @JsonProperty("caCertificate")
    public void setCaCertificate(String caCertificate) {
        this.caCertificate = caCertificate;
    }

    @JsonProperty("certificate")
    public String getCertificate() {
        return certificate;
    }

    @JsonProperty("certificate")
    public void setCertificate(String certificate) {
        this.certificate = certificate;
    }

    @JsonProperty("destinationCACertificate")
    public String getDestinationCACertificate() {
        return destinationCACertificate;
    }

    @JsonProperty("destinationCACertificate")
    public void setDestinationCACertificate(String destinationCACertificate) {
        this.destinationCACertificate = destinationCACertificate;
    }

    @JsonProperty("externalCertificate")
    public LocalObjectReference getExternalCertificate() {
        return externalCertificate;
    }

    @JsonProperty("externalCertificate")
    public void setExternalCertificate(LocalObjectReference externalCertificate) {
        this.externalCertificate = externalCertificate;
    }

    @JsonProperty("insecureEdgeTerminationPolicy")
    public String getInsecureEdgeTerminationPolicy() {
        return insecureEdgeTerminationPolicy;
    }

    @JsonProperty("insecureEdgeTerminationPolicy")
    public void setInsecureEdgeTerminationPolicy(String insecureEdgeTerminationPolicy) {
        this.insecureEdgeTerminationPolicy = insecureEdgeTerminationPolicy;
    }

    @JsonProperty("key")
    public String getKey() {
        return key;
    }

    @JsonProperty("key")
    public void setKey(String key) {
        this.key = key;
    }

    @JsonProperty("termination")
    public String getTermination() {
        return termination;
    }

    @JsonProperty("termination")
    public void setTermination(String termination) {
        this.termination = termination;
    }

    @JsonIgnore
    public TLSConfigBuilder edit() {
        return new TLSConfigBuilder(this);
    }

    @JsonIgnore
    public TLSConfigBuilder toBuilder() {
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
