
package io.fabric8.istio.api.api.networking.v1alpha3;

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
 * TLSCertificate describes the server's TLS certificate.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "caCertificates",
    "privateKey",
    "serverCertificate"
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
public class ServerTLSSettingsTLSCertificate implements Editable<ServerTLSSettingsTLSCertificateBuilder>, KubernetesResource
{

    @JsonProperty("caCertificates")
    private String caCertificates;
    @JsonProperty("privateKey")
    private String privateKey;
    @JsonProperty("serverCertificate")
    private String serverCertificate;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public ServerTLSSettingsTLSCertificate() {
    }

    public ServerTLSSettingsTLSCertificate(String caCertificates, String privateKey, String serverCertificate) {
        super();
        this.caCertificates = caCertificates;
        this.privateKey = privateKey;
        this.serverCertificate = serverCertificate;
    }

    /**
     * REQUIRED if mode is `MUTUAL` or `OPTIONAL_MUTUAL`. The path to a file containing certificate authority certificates to use in verifying a presented client side certificate.
     */
    @JsonProperty("caCertificates")
    public String getCaCertificates() {
        return caCertificates;
    }

    /**
     * REQUIRED if mode is `MUTUAL` or `OPTIONAL_MUTUAL`. The path to a file containing certificate authority certificates to use in verifying a presented client side certificate.
     */
    @JsonProperty("caCertificates")
    public void setCaCertificates(String caCertificates) {
        this.caCertificates = caCertificates;
    }

    /**
     * REQUIRED if mode is `SIMPLE` or `MUTUAL`. The path to the file holding the server's private key.
     */
    @JsonProperty("privateKey")
    public String getPrivateKey() {
        return privateKey;
    }

    /**
     * REQUIRED if mode is `SIMPLE` or `MUTUAL`. The path to the file holding the server's private key.
     */
    @JsonProperty("privateKey")
    public void setPrivateKey(String privateKey) {
        this.privateKey = privateKey;
    }

    /**
     * REQUIRED if mode is `SIMPLE` or `MUTUAL`. The path to the file holding the server-side TLS certificate to use.
     */
    @JsonProperty("serverCertificate")
    public String getServerCertificate() {
        return serverCertificate;
    }

    /**
     * REQUIRED if mode is `SIMPLE` or `MUTUAL`. The path to the file holding the server-side TLS certificate to use.
     */
    @JsonProperty("serverCertificate")
    public void setServerCertificate(String serverCertificate) {
        this.serverCertificate = serverCertificate;
    }

    @JsonIgnore
    public ServerTLSSettingsTLSCertificateBuilder edit() {
        return new ServerTLSSettingsTLSCertificateBuilder(this);
    }

    @JsonIgnore
    public ServerTLSSettingsTLSCertificateBuilder toBuilder() {
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
