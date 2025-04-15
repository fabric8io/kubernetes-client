
package io.fabric8.openshift.api.model.config.v1;

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
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * ServingInfo holds information about serving web pages
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "bindAddress",
    "bindNetwork",
    "certFile",
    "cipherSuites",
    "clientCA",
    "keyFile",
    "minTLSVersion",
    "namedCertificates"
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
public class ServingInfo implements Editable<ServingInfoBuilder>, KubernetesResource
{

    @JsonProperty("bindAddress")
    private String bindAddress;
    @JsonProperty("bindNetwork")
    private String bindNetwork;
    @JsonProperty("certFile")
    private String certFile;
    @JsonProperty("cipherSuites")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> cipherSuites = new ArrayList<>();
    @JsonProperty("clientCA")
    private String clientCA;
    @JsonProperty("keyFile")
    private String keyFile;
    @JsonProperty("minTLSVersion")
    private String minTLSVersion;
    @JsonProperty("namedCertificates")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<NamedCertificate> namedCertificates = new ArrayList<>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public ServingInfo() {
    }

    public ServingInfo(String bindAddress, String bindNetwork, String certFile, List<String> cipherSuites, String clientCA, String keyFile, String minTLSVersion, List<NamedCertificate> namedCertificates) {
        super();
        this.bindAddress = bindAddress;
        this.bindNetwork = bindNetwork;
        this.certFile = certFile;
        this.cipherSuites = cipherSuites;
        this.clientCA = clientCA;
        this.keyFile = keyFile;
        this.minTLSVersion = minTLSVersion;
        this.namedCertificates = namedCertificates;
    }

    /**
     * BindAddress is the ip:port to serve on
     */
    @JsonProperty("bindAddress")
    public String getBindAddress() {
        return bindAddress;
    }

    /**
     * BindAddress is the ip:port to serve on
     */
    @JsonProperty("bindAddress")
    public void setBindAddress(String bindAddress) {
        this.bindAddress = bindAddress;
    }

    /**
     * BindNetwork is the type of network to bind to - defaults to "tcp4", accepts "tcp", "tcp4", and "tcp6"
     */
    @JsonProperty("bindNetwork")
    public String getBindNetwork() {
        return bindNetwork;
    }

    /**
     * BindNetwork is the type of network to bind to - defaults to "tcp4", accepts "tcp", "tcp4", and "tcp6"
     */
    @JsonProperty("bindNetwork")
    public void setBindNetwork(String bindNetwork) {
        this.bindNetwork = bindNetwork;
    }

    /**
     * CertFile is a file containing a PEM-encoded certificate
     */
    @JsonProperty("certFile")
    public String getCertFile() {
        return certFile;
    }

    /**
     * CertFile is a file containing a PEM-encoded certificate
     */
    @JsonProperty("certFile")
    public void setCertFile(String certFile) {
        this.certFile = certFile;
    }

    /**
     * CipherSuites contains an overridden list of ciphers for the server to support. Values must match cipher suite IDs from https://golang.org/pkg/crypto/tls/#pkg-constants
     */
    @JsonProperty("cipherSuites")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getCipherSuites() {
        return cipherSuites;
    }

    /**
     * CipherSuites contains an overridden list of ciphers for the server to support. Values must match cipher suite IDs from https://golang.org/pkg/crypto/tls/#pkg-constants
     */
    @JsonProperty("cipherSuites")
    public void setCipherSuites(List<String> cipherSuites) {
        this.cipherSuites = cipherSuites;
    }

    /**
     * ClientCA is the certificate bundle for all the signers that you'll recognize for incoming client certificates
     */
    @JsonProperty("clientCA")
    public String getClientCA() {
        return clientCA;
    }

    /**
     * ClientCA is the certificate bundle for all the signers that you'll recognize for incoming client certificates
     */
    @JsonProperty("clientCA")
    public void setClientCA(String clientCA) {
        this.clientCA = clientCA;
    }

    /**
     * KeyFile is a file containing a PEM-encoded private key for the certificate specified by CertFile
     */
    @JsonProperty("keyFile")
    public String getKeyFile() {
        return keyFile;
    }

    /**
     * KeyFile is a file containing a PEM-encoded private key for the certificate specified by CertFile
     */
    @JsonProperty("keyFile")
    public void setKeyFile(String keyFile) {
        this.keyFile = keyFile;
    }

    /**
     * MinTLSVersion is the minimum TLS version supported. Values must match version names from https://golang.org/pkg/crypto/tls/#pkg-constants
     */
    @JsonProperty("minTLSVersion")
    public String getMinTLSVersion() {
        return minTLSVersion;
    }

    /**
     * MinTLSVersion is the minimum TLS version supported. Values must match version names from https://golang.org/pkg/crypto/tls/#pkg-constants
     */
    @JsonProperty("minTLSVersion")
    public void setMinTLSVersion(String minTLSVersion) {
        this.minTLSVersion = minTLSVersion;
    }

    /**
     * NamedCertificates is a list of certificates to use to secure requests to specific hostnames
     */
    @JsonProperty("namedCertificates")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<NamedCertificate> getNamedCertificates() {
        return namedCertificates;
    }

    /**
     * NamedCertificates is a list of certificates to use to secure requests to specific hostnames
     */
    @JsonProperty("namedCertificates")
    public void setNamedCertificates(List<NamedCertificate> namedCertificates) {
        this.namedCertificates = namedCertificates;
    }

    @JsonIgnore
    public ServingInfoBuilder edit() {
        return new ServingInfoBuilder(this);
    }

    @JsonIgnore
    public ServingInfoBuilder toBuilder() {
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
