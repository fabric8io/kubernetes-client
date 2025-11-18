
package io.fabric8.kubernetes.api.model.gatewayapi.v1;

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
 * ListenerTLSConfig describes a TLS configuration for a listener.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "certificateRefs",
    "mode",
    "options"
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
    @BuildableReference(io.fabric8.kubernetes.api.model.ObjectReference.class),
    @BuildableReference(io.fabric8.kubernetes.api.model.LocalObjectReference.class),
    @BuildableReference(PersistentVolumeClaim.class),
    @BuildableReference(EnvVar.class),
    @BuildableReference(ContainerPort.class),
    @BuildableReference(Volume.class),
    @BuildableReference(VolumeMount.class)
})
@Generated("io.fabric8.kubernetes.schema.generator.model.ModelGenerator")
public class ListenerTLSConfig implements Editable<ListenerTLSConfigBuilder>, KubernetesResource
{

    @JsonProperty("certificateRefs")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<SecretObjectReference> certificateRefs = new ArrayList<>();
    @JsonProperty("mode")
    private String mode;
    @JsonProperty("options")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Map<String, String> options = new LinkedHashMap<>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public ListenerTLSConfig() {
    }

    public ListenerTLSConfig(List<SecretObjectReference> certificateRefs, String mode, Map<String, String> options) {
        super();
        this.certificateRefs = certificateRefs;
        this.mode = mode;
        this.options = options;
    }

    /**
     * CertificateRefs contains a series of references to Kubernetes objects that contains TLS certificates and private keys. These certificates are used to establish a TLS handshake for requests that match the hostname of the associated listener.<br><p> <br><p> A single CertificateRef to a Kubernetes Secret has "Core" support. Implementations MAY choose to support attaching multiple certificates to a Listener, but this behavior is implementation-specific.<br><p> <br><p> References to a resource in different namespace are invalid UNLESS there is a ReferenceGrant in the target namespace that allows the certificate to be attached. If a ReferenceGrant does not allow this reference, the "ResolvedRefs" condition MUST be set to False for this listener with the "RefNotPermitted" reason.<br><p> <br><p> This field is required to have at least one element when the mode is set to "Terminate" (default) and is optional otherwise.<br><p> <br><p> CertificateRefs can reference to standard Kubernetes resources, i.e. Secret, or implementation-specific custom resources.<br><p> <br><p> Support: Core - A single reference to a Kubernetes Secret of type kubernetes.io/tls<br><p> <br><p> Support: Implementation-specific (More than one reference or other resource types)
     */
    @JsonProperty("certificateRefs")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<SecretObjectReference> getCertificateRefs() {
        return certificateRefs;
    }

    /**
     * CertificateRefs contains a series of references to Kubernetes objects that contains TLS certificates and private keys. These certificates are used to establish a TLS handshake for requests that match the hostname of the associated listener.<br><p> <br><p> A single CertificateRef to a Kubernetes Secret has "Core" support. Implementations MAY choose to support attaching multiple certificates to a Listener, but this behavior is implementation-specific.<br><p> <br><p> References to a resource in different namespace are invalid UNLESS there is a ReferenceGrant in the target namespace that allows the certificate to be attached. If a ReferenceGrant does not allow this reference, the "ResolvedRefs" condition MUST be set to False for this listener with the "RefNotPermitted" reason.<br><p> <br><p> This field is required to have at least one element when the mode is set to "Terminate" (default) and is optional otherwise.<br><p> <br><p> CertificateRefs can reference to standard Kubernetes resources, i.e. Secret, or implementation-specific custom resources.<br><p> <br><p> Support: Core - A single reference to a Kubernetes Secret of type kubernetes.io/tls<br><p> <br><p> Support: Implementation-specific (More than one reference or other resource types)
     */
    @JsonProperty("certificateRefs")
    public void setCertificateRefs(List<SecretObjectReference> certificateRefs) {
        this.certificateRefs = certificateRefs;
    }

    /**
     * Mode defines the TLS behavior for the TLS session initiated by the client. There are two possible modes:<br><p> <br><p> - Terminate: The TLS session between the downstream client and the<br><p>   Gateway is terminated at the Gateway. This mode requires certificates<br><p>   to be specified in some way, such as populating the certificateRefs<br><p>   field.<br><p> - Passthrough: The TLS session is NOT terminated by the Gateway. This<br><p>   implies that the Gateway can't decipher the TLS stream except for<br><p>   the ClientHello message of the TLS protocol. The certificateRefs field<br><p>   is ignored in this mode.<br><p> <br><p> Support: Core
     */
    @JsonProperty("mode")
    public String getMode() {
        return mode;
    }

    /**
     * Mode defines the TLS behavior for the TLS session initiated by the client. There are two possible modes:<br><p> <br><p> - Terminate: The TLS session between the downstream client and the<br><p>   Gateway is terminated at the Gateway. This mode requires certificates<br><p>   to be specified in some way, such as populating the certificateRefs<br><p>   field.<br><p> - Passthrough: The TLS session is NOT terminated by the Gateway. This<br><p>   implies that the Gateway can't decipher the TLS stream except for<br><p>   the ClientHello message of the TLS protocol. The certificateRefs field<br><p>   is ignored in this mode.<br><p> <br><p> Support: Core
     */
    @JsonProperty("mode")
    public void setMode(String mode) {
        this.mode = mode;
    }

    /**
     * Options are a list of key/value pairs to enable extended TLS configuration for each implementation. For example, configuring the minimum TLS version or supported cipher suites.<br><p> <br><p> A set of common keys MAY be defined by the API in the future. To avoid any ambiguity, implementation-specific definitions MUST use domain-prefixed names, such as `example.com/my-custom-option`. Un-prefixed names are reserved for key names defined by Gateway API.<br><p> <br><p> Support: Implementation-specific
     */
    @JsonProperty("options")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public Map<String, String> getOptions() {
        return options;
    }

    /**
     * Options are a list of key/value pairs to enable extended TLS configuration for each implementation. For example, configuring the minimum TLS version or supported cipher suites.<br><p> <br><p> A set of common keys MAY be defined by the API in the future. To avoid any ambiguity, implementation-specific definitions MUST use domain-prefixed names, such as `example.com/my-custom-option`. Un-prefixed names are reserved for key names defined by Gateway API.<br><p> <br><p> Support: Implementation-specific
     */
    @JsonProperty("options")
    public void setOptions(Map<String, String> options) {
        this.options = options;
    }

    @JsonIgnore
    public ListenerTLSConfigBuilder edit() {
        return new ListenerTLSConfigBuilder(this);
    }

    @JsonIgnore
    public ListenerTLSConfigBuilder toBuilder() {
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
