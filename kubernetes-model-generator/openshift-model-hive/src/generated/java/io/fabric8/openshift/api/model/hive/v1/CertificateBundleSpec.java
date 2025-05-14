
package io.fabric8.openshift.api.model.hive.v1;

import java.util.LinkedHashMap;
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
 * CertificateBundleSpec specifies a certificate bundle associated with a cluster deployment
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "certificateSecretRef",
    "generate",
    "name"
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
public class CertificateBundleSpec implements Editable<CertificateBundleSpecBuilder>, KubernetesResource
{

    @JsonProperty("certificateSecretRef")
    private LocalObjectReference certificateSecretRef;
    @JsonProperty("generate")
    private Boolean generate;
    @JsonProperty("name")
    private String name;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public CertificateBundleSpec() {
    }

    public CertificateBundleSpec(LocalObjectReference certificateSecretRef, Boolean generate, String name) {
        super();
        this.certificateSecretRef = certificateSecretRef;
        this.generate = generate;
        this.name = name;
    }

    /**
     * CertificateBundleSpec specifies a certificate bundle associated with a cluster deployment
     */
    @JsonProperty("certificateSecretRef")
    public LocalObjectReference getCertificateSecretRef() {
        return certificateSecretRef;
    }

    /**
     * CertificateBundleSpec specifies a certificate bundle associated with a cluster deployment
     */
    @JsonProperty("certificateSecretRef")
    public void setCertificateSecretRef(LocalObjectReference certificateSecretRef) {
        this.certificateSecretRef = certificateSecretRef;
    }

    /**
     * Generate indicates whether this bundle should have real certificates generated for it.
     */
    @JsonProperty("generate")
    public Boolean getGenerate() {
        return generate;
    }

    /**
     * Generate indicates whether this bundle should have real certificates generated for it.
     */
    @JsonProperty("generate")
    public void setGenerate(Boolean generate) {
        this.generate = generate;
    }

    /**
     * Name is an identifier that must be unique within the bundle and must be referenced by an ingress or by the control plane serving certs
     */
    @JsonProperty("name")
    public String getName() {
        return name;
    }

    /**
     * Name is an identifier that must be unique within the bundle and must be referenced by an ingress or by the control plane serving certs
     */
    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonIgnore
    public CertificateBundleSpecBuilder edit() {
        return new CertificateBundleSpecBuilder(this);
    }

    @JsonIgnore
    public CertificateBundleSpecBuilder toBuilder() {
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
