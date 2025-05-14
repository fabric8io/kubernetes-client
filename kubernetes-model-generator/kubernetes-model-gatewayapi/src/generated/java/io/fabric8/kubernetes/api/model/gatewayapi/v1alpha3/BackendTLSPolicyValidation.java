
package io.fabric8.kubernetes.api.model.gatewayapi.v1alpha3;

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

/**
 * BackendTLSPolicyValidation contains backend TLS validation configuration.
 */
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

    /**
     * CACertificateRefs contains one or more references to Kubernetes objects that contain a PEM-encoded TLS CA certificate bundle, which is used to validate a TLS handshake between the Gateway and backend Pod.<br><p> <br><p> If CACertificateRefs is empty or unspecified, then WellKnownCACertificates must be specified. Only one of CACertificateRefs or WellKnownCACertificates may be specified, not both. If CACertifcateRefs is empty or unspecified, the configuration for WellKnownCACertificates MUST be honored instead if supported by the implementation.<br><p> <br><p> References to a resource in a different namespace are invalid for the moment, although we will revisit this in the future.<br><p> <br><p> A single CACertificateRef to a Kubernetes ConfigMap kind has "Core" support. Implementations MAY choose to support attaching multiple certificates to a backend, but this behavior is implementation-specific.<br><p> <br><p> Support: Core - An optional single reference to a Kubernetes ConfigMap, with the CA certificate in a key named `ca.crt`.<br><p> <br><p> Support: Implementation-specific (More than one reference, or other kinds of resources).
     */
    @JsonProperty("caCertificateRefs")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<LocalObjectReference> getCaCertificateRefs() {
        return caCertificateRefs;
    }

    /**
     * CACertificateRefs contains one or more references to Kubernetes objects that contain a PEM-encoded TLS CA certificate bundle, which is used to validate a TLS handshake between the Gateway and backend Pod.<br><p> <br><p> If CACertificateRefs is empty or unspecified, then WellKnownCACertificates must be specified. Only one of CACertificateRefs or WellKnownCACertificates may be specified, not both. If CACertifcateRefs is empty or unspecified, the configuration for WellKnownCACertificates MUST be honored instead if supported by the implementation.<br><p> <br><p> References to a resource in a different namespace are invalid for the moment, although we will revisit this in the future.<br><p> <br><p> A single CACertificateRef to a Kubernetes ConfigMap kind has "Core" support. Implementations MAY choose to support attaching multiple certificates to a backend, but this behavior is implementation-specific.<br><p> <br><p> Support: Core - An optional single reference to a Kubernetes ConfigMap, with the CA certificate in a key named `ca.crt`.<br><p> <br><p> Support: Implementation-specific (More than one reference, or other kinds of resources).
     */
    @JsonProperty("caCertificateRefs")
    public void setCaCertificateRefs(List<LocalObjectReference> caCertificateRefs) {
        this.caCertificateRefs = caCertificateRefs;
    }

    /**
     * Hostname is used for two purposes in the connection between Gateways and backends:<br><p> <br><p> 1. Hostname MUST be used as the SNI to connect to the backend (RFC 6066). 2. If SubjectAltNames is not specified, Hostname MUST be used for<br><p>    authentication and MUST match the certificate served by the matching<br><p>    backend.<br><p> <br><p> Support: Core
     */
    @JsonProperty("hostname")
    public String getHostname() {
        return hostname;
    }

    /**
     * Hostname is used for two purposes in the connection between Gateways and backends:<br><p> <br><p> 1. Hostname MUST be used as the SNI to connect to the backend (RFC 6066). 2. If SubjectAltNames is not specified, Hostname MUST be used for<br><p>    authentication and MUST match the certificate served by the matching<br><p>    backend.<br><p> <br><p> Support: Core
     */
    @JsonProperty("hostname")
    public void setHostname(String hostname) {
        this.hostname = hostname;
    }

    /**
     * SubjectAltNames contains one or more Subject Alternative Names. When specified, the certificate served from the backend MUST have at least one Subject Alternate Name matching one of the specified SubjectAltNames.<br><p> <br><p> Support: Core
     */
    @JsonProperty("subjectAltNames")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<SubjectAltName> getSubjectAltNames() {
        return subjectAltNames;
    }

    /**
     * SubjectAltNames contains one or more Subject Alternative Names. When specified, the certificate served from the backend MUST have at least one Subject Alternate Name matching one of the specified SubjectAltNames.<br><p> <br><p> Support: Core
     */
    @JsonProperty("subjectAltNames")
    public void setSubjectAltNames(List<SubjectAltName> subjectAltNames) {
        this.subjectAltNames = subjectAltNames;
    }

    /**
     * WellKnownCACertificates specifies whether system CA certificates may be used in the TLS handshake between the gateway and backend pod.<br><p> <br><p> If WellKnownCACertificates is unspecified or empty (""), then CACertificateRefs must be specified with at least one entry for a valid configuration. Only one of CACertificateRefs or WellKnownCACertificates may be specified, not both. If an implementation does not support the WellKnownCACertificates field or the value supplied is not supported, the Status Conditions on the Policy MUST be updated to include an Accepted: False Condition with Reason: Invalid.<br><p> <br><p> Support: Implementation-specific
     */
    @JsonProperty("wellKnownCACertificates")
    public String getWellKnownCACertificates() {
        return wellKnownCACertificates;
    }

    /**
     * WellKnownCACertificates specifies whether system CA certificates may be used in the TLS handshake between the gateway and backend pod.<br><p> <br><p> If WellKnownCACertificates is unspecified or empty (""), then CACertificateRefs must be specified with at least one entry for a valid configuration. Only one of CACertificateRefs or WellKnownCACertificates may be specified, not both. If an implementation does not support the WellKnownCACertificates field or the value supplied is not supported, the Status Conditions on the Policy MUST be updated to include an Accepted: False Condition with Reason: Invalid.<br><p> <br><p> Support: Implementation-specific
     */
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
