
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
 * FrontendTLSValidation holds configuration information that can be used to validate the frontend initiating the TLS connection
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "caCertificateRefs",
    "mode"
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
public class FrontendTLSValidation implements Editable<FrontendTLSValidationBuilder>, KubernetesResource
{

    @JsonProperty("caCertificateRefs")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<ObjectReference> caCertificateRefs = new ArrayList<>();
    @JsonProperty("mode")
    private String mode;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public FrontendTLSValidation() {
    }

    public FrontendTLSValidation(List<ObjectReference> caCertificateRefs, String mode) {
        super();
        this.caCertificateRefs = caCertificateRefs;
        this.mode = mode;
    }

    /**
     * CACertificateRefs contains one or more references to Kubernetes objects that contain TLS certificates of the Certificate Authorities that can be used as a trust anchor to validate the certificates presented by the client.<br><p> <br><p> A single CA certificate reference to a Kubernetes ConfigMap has "Core" support. Implementations MAY choose to support attaching multiple CA certificates to a Listener, but this behavior is implementation-specific.<br><p> <br><p> Support: Core - A single reference to a Kubernetes ConfigMap with the CA certificate in a key named `ca.crt`.<br><p> <br><p> Support: Implementation-specific (More than one certificate in a ConfigMap with different keys or more than one reference, or other kinds of resources).<br><p> <br><p> References to a resource in a different namespace are invalid UNLESS there is a ReferenceGrant in the target namespace that allows the certificate to be attached. If a ReferenceGrant does not allow this reference, the "ResolvedRefs" condition MUST be set to False for this listener with the "RefNotPermitted" reason.
     */
    @JsonProperty("caCertificateRefs")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<ObjectReference> getCaCertificateRefs() {
        return caCertificateRefs;
    }

    /**
     * CACertificateRefs contains one or more references to Kubernetes objects that contain TLS certificates of the Certificate Authorities that can be used as a trust anchor to validate the certificates presented by the client.<br><p> <br><p> A single CA certificate reference to a Kubernetes ConfigMap has "Core" support. Implementations MAY choose to support attaching multiple CA certificates to a Listener, but this behavior is implementation-specific.<br><p> <br><p> Support: Core - A single reference to a Kubernetes ConfigMap with the CA certificate in a key named `ca.crt`.<br><p> <br><p> Support: Implementation-specific (More than one certificate in a ConfigMap with different keys or more than one reference, or other kinds of resources).<br><p> <br><p> References to a resource in a different namespace are invalid UNLESS there is a ReferenceGrant in the target namespace that allows the certificate to be attached. If a ReferenceGrant does not allow this reference, the "ResolvedRefs" condition MUST be set to False for this listener with the "RefNotPermitted" reason.
     */
    @JsonProperty("caCertificateRefs")
    public void setCaCertificateRefs(List<ObjectReference> caCertificateRefs) {
        this.caCertificateRefs = caCertificateRefs;
    }

    /**
     * FrontendValidationMode defines the mode for validating the client certificate. There are two possible modes:<br><p> <br><p> - AllowValidOnly: In this mode, the gateway will accept connections only if<br><p>   the client presents a valid certificate. This certificate must successfully<br><p>   pass validation against the CA certificates specified in `CACertificateRefs`.<br><p> - AllowInsecureFallback: In this mode, the gateway will accept connections<br><p>   even if the client certificate is not presented or fails verification.<br><p> <br><p>   This approach delegates client authorization to the backend and introduce<br><p>   a significant security risk. It should be used in testing environments or<br><p>   on a temporary basis in non-testing environments.<br><p> <br><p> Defaults to AllowValidOnly.<br><p> <br><p> Support: Core
     */
    @JsonProperty("mode")
    public String getMode() {
        return mode;
    }

    /**
     * FrontendValidationMode defines the mode for validating the client certificate. There are two possible modes:<br><p> <br><p> - AllowValidOnly: In this mode, the gateway will accept connections only if<br><p>   the client presents a valid certificate. This certificate must successfully<br><p>   pass validation against the CA certificates specified in `CACertificateRefs`.<br><p> - AllowInsecureFallback: In this mode, the gateway will accept connections<br><p>   even if the client certificate is not presented or fails verification.<br><p> <br><p>   This approach delegates client authorization to the backend and introduce<br><p>   a significant security risk. It should be used in testing environments or<br><p>   on a temporary basis in non-testing environments.<br><p> <br><p> Defaults to AllowValidOnly.<br><p> <br><p> Support: Core
     */
    @JsonProperty("mode")
    public void setMode(String mode) {
        this.mode = mode;
    }

    @JsonIgnore
    public FrontendTLSValidationBuilder edit() {
        return new FrontendTLSValidationBuilder(this);
    }

    @JsonIgnore
    public FrontendTLSValidationBuilder toBuilder() {
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
