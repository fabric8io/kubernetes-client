
package io.fabric8.knative.internal.networking.v1alpha1;

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
import io.fabric8.kubernetes.api.model.HasMetadata;
import io.fabric8.kubernetes.api.model.IntOrString;
import io.fabric8.kubernetes.api.model.LabelSelector;
import io.fabric8.kubernetes.api.model.LocalObjectReference;
import io.fabric8.kubernetes.api.model.Namespaced;
import io.fabric8.kubernetes.api.model.ObjectMeta;
import io.fabric8.kubernetes.api.model.ObjectReference;
import io.fabric8.kubernetes.api.model.PersistentVolumeClaim;
import io.fabric8.kubernetes.api.model.PodTemplateSpec;
import io.fabric8.kubernetes.api.model.ResourceRequirements;
import io.fabric8.kubernetes.api.model.Volume;
import io.fabric8.kubernetes.api.model.VolumeMount;
import io.fabric8.kubernetes.model.annotation.Group;
import io.fabric8.kubernetes.model.annotation.Version;
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;
import io.sundr.transform.annotations.TemplateTransformation;
import io.sundr.transform.annotations.TemplateTransformations;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * Certificate is responsible for provisioning a SSL certificate for the given hosts. It is a Knative abstraction for various SSL certificate provisioning solutions (such as cert-manager or self-signed SSL certificate).
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "apiVersion",
    "kind",
    "metadata",
    "spec",
    "status"
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
@TemplateTransformations({
    @TemplateTransformation(value = "/manifest.vm", outputPath = "META-INF/services/io.fabric8.kubernetes.api.model.KubernetesResource", gather = true)
})
@Version("v1alpha1")
@Group("networking.internal.knative.dev")
@Generated("io.fabric8.kubernetes.schema.generator.model.ModelGenerator")
public class Certificate implements Editable<CertificateBuilder>, HasMetadata, Namespaced
{

    @JsonProperty("apiVersion")
    private String apiVersion = "networking.internal.knative.dev/v1alpha1";
    @JsonProperty("kind")
    private String kind = "Certificate";
    @JsonProperty("metadata")
    private ObjectMeta metadata;
    @JsonProperty("spec")
    private CertificateSpec spec;
    @JsonProperty("status")
    private CertificateStatus status;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public Certificate() {
    }

    public Certificate(String apiVersion, String kind, ObjectMeta metadata, CertificateSpec spec, CertificateStatus status) {
        super();
        this.apiVersion = apiVersion;
        this.kind = kind;
        this.metadata = metadata;
        this.spec = spec;
        this.status = status;
    }

    /**
     * APIVersion defines the versioned schema of this representation of an object. Servers should convert recognized schemas to the latest internal value, and may reject unrecognized values. More info: https://git.k8s.io/community/contributors/devel/sig-architecture/api-conventions.md#resources
     */
    @JsonProperty("apiVersion")
    public String getApiVersion() {
        return apiVersion;
    }

    /**
     * APIVersion defines the versioned schema of this representation of an object. Servers should convert recognized schemas to the latest internal value, and may reject unrecognized values. More info: https://git.k8s.io/community/contributors/devel/sig-architecture/api-conventions.md#resources
     */
    @JsonProperty("apiVersion")
    public void setApiVersion(String apiVersion) {
        this.apiVersion = apiVersion;
    }

    /**
     * Kind is a string value representing the REST resource this object represents. Servers may infer this from the endpoint the client submits requests to. Cannot be updated. In CamelCase. More info: https://git.k8s.io/community/contributors/devel/sig-architecture/api-conventions.md#types-kinds
     */
    @JsonProperty("kind")
    public String getKind() {
        return kind;
    }

    /**
     * Kind is a string value representing the REST resource this object represents. Servers may infer this from the endpoint the client submits requests to. Cannot be updated. In CamelCase. More info: https://git.k8s.io/community/contributors/devel/sig-architecture/api-conventions.md#types-kinds
     */
    @JsonProperty("kind")
    public void setKind(String kind) {
        this.kind = kind;
    }

    /**
     * Certificate is responsible for provisioning a SSL certificate for the given hosts. It is a Knative abstraction for various SSL certificate provisioning solutions (such as cert-manager or self-signed SSL certificate).
     */
    @JsonProperty("metadata")
    public ObjectMeta getMetadata() {
        return metadata;
    }

    /**
     * Certificate is responsible for provisioning a SSL certificate for the given hosts. It is a Knative abstraction for various SSL certificate provisioning solutions (such as cert-manager or self-signed SSL certificate).
     */
    @JsonProperty("metadata")
    public void setMetadata(ObjectMeta metadata) {
        this.metadata = metadata;
    }

    /**
     * Certificate is responsible for provisioning a SSL certificate for the given hosts. It is a Knative abstraction for various SSL certificate provisioning solutions (such as cert-manager or self-signed SSL certificate).
     */
    @JsonProperty("spec")
    public CertificateSpec getSpec() {
        return spec;
    }

    /**
     * Certificate is responsible for provisioning a SSL certificate for the given hosts. It is a Knative abstraction for various SSL certificate provisioning solutions (such as cert-manager or self-signed SSL certificate).
     */
    @JsonProperty("spec")
    public void setSpec(CertificateSpec spec) {
        this.spec = spec;
    }

    /**
     * Certificate is responsible for provisioning a SSL certificate for the given hosts. It is a Knative abstraction for various SSL certificate provisioning solutions (such as cert-manager or self-signed SSL certificate).
     */
    @JsonProperty("status")
    public CertificateStatus getStatus() {
        return status;
    }

    /**
     * Certificate is responsible for provisioning a SSL certificate for the given hosts. It is a Knative abstraction for various SSL certificate provisioning solutions (such as cert-manager or self-signed SSL certificate).
     */
    @JsonProperty("status")
    public void setStatus(CertificateStatus status) {
        this.status = status;
    }

    @JsonIgnore
    public CertificateBuilder edit() {
        return new CertificateBuilder(this);
    }

    @JsonIgnore
    public CertificateBuilder toBuilder() {
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
