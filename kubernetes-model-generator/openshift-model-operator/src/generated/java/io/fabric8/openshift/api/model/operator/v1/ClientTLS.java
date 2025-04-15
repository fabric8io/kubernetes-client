
package io.fabric8.openshift.api.model.operator.v1;

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
import io.fabric8.kubernetes.api.model.LocalObjectReference;
import io.fabric8.kubernetes.api.model.ObjectMeta;
import io.fabric8.kubernetes.api.model.ObjectReference;
import io.fabric8.kubernetes.api.model.PersistentVolumeClaim;
import io.fabric8.kubernetes.api.model.PodTemplateSpec;
import io.fabric8.kubernetes.api.model.ResourceRequirements;
import io.fabric8.kubernetes.api.model.Volume;
import io.fabric8.kubernetes.api.model.VolumeMount;
import io.fabric8.openshift.api.model.config.v1.ConfigMapNameReference;
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * ClientTLS specifies TLS configuration to enable client-to-server authentication, which can be used for mutual TLS.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "allowedSubjectPatterns",
    "clientCA",
    "clientCertificatePolicy"
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
public class ClientTLS implements Editable<ClientTLSBuilder>, KubernetesResource
{

    @JsonProperty("allowedSubjectPatterns")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> allowedSubjectPatterns = new ArrayList<>();
    @JsonProperty("clientCA")
    private ConfigMapNameReference clientCA;
    @JsonProperty("clientCertificatePolicy")
    private String clientCertificatePolicy;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public ClientTLS() {
    }

    public ClientTLS(List<String> allowedSubjectPatterns, ConfigMapNameReference clientCA, String clientCertificatePolicy) {
        super();
        this.allowedSubjectPatterns = allowedSubjectPatterns;
        this.clientCA = clientCA;
        this.clientCertificatePolicy = clientCertificatePolicy;
    }

    /**
     * allowedSubjectPatterns specifies a list of regular expressions that should be matched against the distinguished name on a valid client certificate to filter requests.  The regular expressions must use PCRE syntax.  If this list is empty, no filtering is performed.  If the list is nonempty, then at least one pattern must match a client certificate's distinguished name or else the ingress controller rejects the certificate and denies the connection.
     */
    @JsonProperty("allowedSubjectPatterns")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getAllowedSubjectPatterns() {
        return allowedSubjectPatterns;
    }

    /**
     * allowedSubjectPatterns specifies a list of regular expressions that should be matched against the distinguished name on a valid client certificate to filter requests.  The regular expressions must use PCRE syntax.  If this list is empty, no filtering is performed.  If the list is nonempty, then at least one pattern must match a client certificate's distinguished name or else the ingress controller rejects the certificate and denies the connection.
     */
    @JsonProperty("allowedSubjectPatterns")
    public void setAllowedSubjectPatterns(List<String> allowedSubjectPatterns) {
        this.allowedSubjectPatterns = allowedSubjectPatterns;
    }

    /**
     * ClientTLS specifies TLS configuration to enable client-to-server authentication, which can be used for mutual TLS.
     */
    @JsonProperty("clientCA")
    public ConfigMapNameReference getClientCA() {
        return clientCA;
    }

    /**
     * ClientTLS specifies TLS configuration to enable client-to-server authentication, which can be used for mutual TLS.
     */
    @JsonProperty("clientCA")
    public void setClientCA(ConfigMapNameReference clientCA) {
        this.clientCA = clientCA;
    }

    /**
     * clientCertificatePolicy specifies whether the ingress controller requires clients to provide certificates.  This field accepts the values "Required" or "Optional".<br><p> <br><p> Note that the ingress controller only checks client certificates for edge-terminated and reencrypt TLS routes; it cannot check certificates for cleartext HTTP or passthrough TLS routes.
     */
    @JsonProperty("clientCertificatePolicy")
    public String getClientCertificatePolicy() {
        return clientCertificatePolicy;
    }

    /**
     * clientCertificatePolicy specifies whether the ingress controller requires clients to provide certificates.  This field accepts the values "Required" or "Optional".<br><p> <br><p> Note that the ingress controller only checks client certificates for edge-terminated and reencrypt TLS routes; it cannot check certificates for cleartext HTTP or passthrough TLS routes.
     */
    @JsonProperty("clientCertificatePolicy")
    public void setClientCertificatePolicy(String clientCertificatePolicy) {
        this.clientCertificatePolicy = clientCertificatePolicy;
    }

    @JsonIgnore
    public ClientTLSBuilder edit() {
        return new ClientTLSBuilder(this);
    }

    @JsonIgnore
    public ClientTLSBuilder toBuilder() {
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
