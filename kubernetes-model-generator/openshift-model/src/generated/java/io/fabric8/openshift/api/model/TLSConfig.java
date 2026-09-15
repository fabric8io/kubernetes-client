
package io.fabric8.openshift.api.model;

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
import io.fabric8.kubernetes.api.model.ObjectMeta;
import io.fabric8.kubernetes.api.model.ObjectReference;
import io.fabric8.kubernetes.api.model.PersistentVolumeClaim;
import io.fabric8.kubernetes.api.model.PodTemplateSpec;
import io.fabric8.kubernetes.api.model.ResourceRequirements;
import io.fabric8.kubernetes.api.model.Volume;
import io.fabric8.kubernetes.api.model.VolumeMount;
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;

/**
 * TLSConfig defines config used to secure a route and provide termination
 */
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
public class TLSConfig implements Editable<TLSConfigBuilder>, KubernetesResource
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

    /**
     * caCertificate provides the cert authority certificate contents
     */
    @JsonProperty("caCertificate")
    public String getCaCertificate() {
        return caCertificate;
    }

    /**
     * caCertificate provides the cert authority certificate contents
     */
    @JsonProperty("caCertificate")
    public void setCaCertificate(String caCertificate) {
        this.caCertificate = caCertificate;
    }

    /**
     * certificate provides certificate contents. This should be a single serving certificate, not a certificate chain. Do not include a CA certificate.
     */
    @JsonProperty("certificate")
    public String getCertificate() {
        return certificate;
    }

    /**
     * certificate provides certificate contents. This should be a single serving certificate, not a certificate chain. Do not include a CA certificate.
     */
    @JsonProperty("certificate")
    public void setCertificate(String certificate) {
        this.certificate = certificate;
    }

    /**
     * destinationCACertificate provides the contents of the ca certificate of the final destination.  When using reencrypt termination this file should be provided in order to have routers use it for health checks on the secure connection. If this field is not specified, the router may provide its own destination CA and perform hostname validation using the short service name (service.namespace.svc), which allows infrastructure generated certificates to automatically verify.
     */
    @JsonProperty("destinationCACertificate")
    public String getDestinationCACertificate() {
        return destinationCACertificate;
    }

    /**
     * destinationCACertificate provides the contents of the ca certificate of the final destination.  When using reencrypt termination this file should be provided in order to have routers use it for health checks on the secure connection. If this field is not specified, the router may provide its own destination CA and perform hostname validation using the short service name (service.namespace.svc), which allows infrastructure generated certificates to automatically verify.
     */
    @JsonProperty("destinationCACertificate")
    public void setDestinationCACertificate(String destinationCACertificate) {
        this.destinationCACertificate = destinationCACertificate;
    }

    /**
     * TLSConfig defines config used to secure a route and provide termination
     */
    @JsonProperty("externalCertificate")
    public LocalObjectReference getExternalCertificate() {
        return externalCertificate;
    }

    /**
     * TLSConfig defines config used to secure a route and provide termination
     */
    @JsonProperty("externalCertificate")
    public void setExternalCertificate(LocalObjectReference externalCertificate) {
        this.externalCertificate = externalCertificate;
    }

    /**
     * insecureEdgeTerminationPolicy indicates the desired behavior for insecure connections to a route. While each router may make its own decisions on which ports to expose, this is normally port 80.<br><p> <br><p> If a route does not specify insecureEdgeTerminationPolicy, then the default behavior is "None".<br><p> <br><p> &#42; Allow - traffic is sent to the server on the insecure port (edge/reencrypt terminations only).<br><p> <br><p> &#42; None - no traffic is allowed on the insecure port (default).<br><p> <br><p> &#42; Redirect - clients are redirected to the secure port.
     */
    @JsonProperty("insecureEdgeTerminationPolicy")
    public String getInsecureEdgeTerminationPolicy() {
        return insecureEdgeTerminationPolicy;
    }

    /**
     * insecureEdgeTerminationPolicy indicates the desired behavior for insecure connections to a route. While each router may make its own decisions on which ports to expose, this is normally port 80.<br><p> <br><p> If a route does not specify insecureEdgeTerminationPolicy, then the default behavior is "None".<br><p> <br><p> &#42; Allow - traffic is sent to the server on the insecure port (edge/reencrypt terminations only).<br><p> <br><p> &#42; None - no traffic is allowed on the insecure port (default).<br><p> <br><p> &#42; Redirect - clients are redirected to the secure port.
     */
    @JsonProperty("insecureEdgeTerminationPolicy")
    public void setInsecureEdgeTerminationPolicy(String insecureEdgeTerminationPolicy) {
        this.insecureEdgeTerminationPolicy = insecureEdgeTerminationPolicy;
    }

    /**
     * key provides key file contents
     */
    @JsonProperty("key")
    public String getKey() {
        return key;
    }

    /**
     * key provides key file contents
     */
    @JsonProperty("key")
    public void setKey(String key) {
        this.key = key;
    }

    /**
     * termination indicates termination type.<br><p> <br><p> &#42; edge - TLS termination is done by the router and http is used to communicate with the backend (default) &#42; passthrough - Traffic is sent straight to the destination without the router providing TLS termination &#42; reencrypt - TLS termination is done by the router and https is used to communicate with the backend<br><p> <br><p> Note: passthrough termination is incompatible with httpHeader actions
     */
    @JsonProperty("termination")
    public String getTermination() {
        return termination;
    }

    /**
     * termination indicates termination type.<br><p> <br><p> &#42; edge - TLS termination is done by the router and http is used to communicate with the backend (default) &#42; passthrough - Traffic is sent straight to the destination without the router providing TLS termination &#42; reencrypt - TLS termination is done by the router and https is used to communicate with the backend<br><p> <br><p> Note: passthrough termination is incompatible with httpHeader actions
     */
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
    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof TLSConfig)) {
            return false;
        }
        TLSConfig other = (TLSConfig) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$caCertificate = this.getCaCertificate();
        Object other$caCertificate = other.getCaCertificate();
        if (this$caCertificate == null ? other$caCertificate != null : !this$caCertificate.equals(other$caCertificate)) {
            return false;
        }
        Object this$certificate = this.getCertificate();
        Object other$certificate = other.getCertificate();
        if (this$certificate == null ? other$certificate != null : !this$certificate.equals(other$certificate)) {
            return false;
        }
        Object this$destinationCACertificate = this.getDestinationCACertificate();
        Object other$destinationCACertificate = other.getDestinationCACertificate();
        if (this$destinationCACertificate == null ? other$destinationCACertificate != null : !this$destinationCACertificate.equals(other$destinationCACertificate)) {
            return false;
        }
        Object this$externalCertificate = this.getExternalCertificate();
        Object other$externalCertificate = other.getExternalCertificate();
        if (this$externalCertificate == null ? other$externalCertificate != null : !this$externalCertificate.equals(other$externalCertificate)) {
            return false;
        }
        Object this$insecureEdgeTerminationPolicy = this.getInsecureEdgeTerminationPolicy();
        Object other$insecureEdgeTerminationPolicy = other.getInsecureEdgeTerminationPolicy();
        if (this$insecureEdgeTerminationPolicy == null ? other$insecureEdgeTerminationPolicy != null : !this$insecureEdgeTerminationPolicy.equals(other$insecureEdgeTerminationPolicy)) {
            return false;
        }
        Object this$key = this.getKey();
        Object other$key = other.getKey();
        if (this$key == null ? other$key != null : !this$key.equals(other$key)) {
            return false;
        }
        Object this$termination = this.getTermination();
        Object other$termination = other.getTermination();
        if (this$termination == null ? other$termination != null : !this$termination.equals(other$termination)) {
            return false;
        }
        Object this$additionalProperties = this.getAdditionalProperties();
        Object other$additionalProperties = other.getAdditionalProperties();
        if (this$additionalProperties == null ? other$additionalProperties != null : !this$additionalProperties.equals(other$additionalProperties)) {
            return false;
        }
        return true;
    }

    protected boolean canEqual(Object other) {
        return other instanceof TLSConfig;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $caCertificate = this.getCaCertificate();
        result = result * prime + ($caCertificate == null ? 43 : $caCertificate.hashCode());
        Object $certificate = this.getCertificate();
        result = result * prime + ($certificate == null ? 43 : $certificate.hashCode());
        Object $destinationCACertificate = this.getDestinationCACertificate();
        result = result * prime + ($destinationCACertificate == null ? 43 : $destinationCACertificate.hashCode());
        Object $externalCertificate = this.getExternalCertificate();
        result = result * prime + ($externalCertificate == null ? 43 : $externalCertificate.hashCode());
        Object $insecureEdgeTerminationPolicy = this.getInsecureEdgeTerminationPolicy();
        result = result * prime + ($insecureEdgeTerminationPolicy == null ? 43 : $insecureEdgeTerminationPolicy.hashCode());
        Object $key = this.getKey();
        result = result * prime + ($key == null ? 43 : $key.hashCode());
        Object $termination = this.getTermination();
        result = result * prime + ($termination == null ? 43 : $termination.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "TLSConfig(" + "caCertificate=" + this.getCaCertificate() + ", certificate=" + this.getCertificate() + ", destinationCACertificate=" + this.getDestinationCACertificate() + ", externalCertificate=" + this.getExternalCertificate() + ", insecureEdgeTerminationPolicy=" + this.getInsecureEdgeTerminationPolicy() + ", key=" + this.getKey() + ", termination=" + this.getTermination() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
