
package io.fabric8.istio.api.api.networking.v1alpha3;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
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
    "caCertificates",
    "caCrl",
    "cipherSuites",
    "credentialName",
    "httpsRedirect",
    "maxProtocolVersion",
    "minProtocolVersion",
    "mode",
    "privateKey",
    "serverCertificate",
    "subjectAltNames",
    "verifyCertificateHash",
    "verifyCertificateSpki"
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
public class ServerTLSSettings implements Editable<ServerTLSSettingsBuilder> , KubernetesResource
{

    @JsonProperty("caCertificates")
    private String caCertificates;
    @JsonProperty("caCrl")
    private String caCrl;
    @JsonProperty("cipherSuites")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> cipherSuites = new ArrayList<>();
    @JsonProperty("credentialName")
    private String credentialName;
    @JsonProperty("httpsRedirect")
    private Boolean httpsRedirect;
    @JsonProperty("maxProtocolVersion")
    private ServerTLSSettingsTLSProtocol maxProtocolVersion;
    @JsonProperty("minProtocolVersion")
    private ServerTLSSettingsTLSProtocol minProtocolVersion;
    @JsonProperty("mode")
    private ServerTLSSettingsTLSmode mode;
    @JsonProperty("privateKey")
    private String privateKey;
    @JsonProperty("serverCertificate")
    private String serverCertificate;
    @JsonProperty("subjectAltNames")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> subjectAltNames = new ArrayList<>();
    @JsonProperty("verifyCertificateHash")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> verifyCertificateHash = new ArrayList<>();
    @JsonProperty("verifyCertificateSpki")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> verifyCertificateSpki = new ArrayList<>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public ServerTLSSettings() {
    }

    public ServerTLSSettings(String caCertificates, String caCrl, List<String> cipherSuites, String credentialName, Boolean httpsRedirect, ServerTLSSettingsTLSProtocol maxProtocolVersion, ServerTLSSettingsTLSProtocol minProtocolVersion, ServerTLSSettingsTLSmode mode, String privateKey, String serverCertificate, List<String> subjectAltNames, List<String> verifyCertificateHash, List<String> verifyCertificateSpki) {
        super();
        this.caCertificates = caCertificates;
        this.caCrl = caCrl;
        this.cipherSuites = cipherSuites;
        this.credentialName = credentialName;
        this.httpsRedirect = httpsRedirect;
        this.maxProtocolVersion = maxProtocolVersion;
        this.minProtocolVersion = minProtocolVersion;
        this.mode = mode;
        this.privateKey = privateKey;
        this.serverCertificate = serverCertificate;
        this.subjectAltNames = subjectAltNames;
        this.verifyCertificateHash = verifyCertificateHash;
        this.verifyCertificateSpki = verifyCertificateSpki;
    }

    @JsonProperty("caCertificates")
    public String getCaCertificates() {
        return caCertificates;
    }

    @JsonProperty("caCertificates")
    public void setCaCertificates(String caCertificates) {
        this.caCertificates = caCertificates;
    }

    @JsonProperty("caCrl")
    public String getCaCrl() {
        return caCrl;
    }

    @JsonProperty("caCrl")
    public void setCaCrl(String caCrl) {
        this.caCrl = caCrl;
    }

    @JsonProperty("cipherSuites")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getCipherSuites() {
        return cipherSuites;
    }

    @JsonProperty("cipherSuites")
    public void setCipherSuites(List<String> cipherSuites) {
        this.cipherSuites = cipherSuites;
    }

    @JsonProperty("credentialName")
    public String getCredentialName() {
        return credentialName;
    }

    @JsonProperty("credentialName")
    public void setCredentialName(String credentialName) {
        this.credentialName = credentialName;
    }

    @JsonProperty("httpsRedirect")
    public Boolean getHttpsRedirect() {
        return httpsRedirect;
    }

    @JsonProperty("httpsRedirect")
    public void setHttpsRedirect(Boolean httpsRedirect) {
        this.httpsRedirect = httpsRedirect;
    }

    @JsonProperty("maxProtocolVersion")
    public ServerTLSSettingsTLSProtocol getMaxProtocolVersion() {
        return maxProtocolVersion;
    }

    @JsonProperty("maxProtocolVersion")
    public void setMaxProtocolVersion(ServerTLSSettingsTLSProtocol maxProtocolVersion) {
        this.maxProtocolVersion = maxProtocolVersion;
    }

    @JsonProperty("minProtocolVersion")
    public ServerTLSSettingsTLSProtocol getMinProtocolVersion() {
        return minProtocolVersion;
    }

    @JsonProperty("minProtocolVersion")
    public void setMinProtocolVersion(ServerTLSSettingsTLSProtocol minProtocolVersion) {
        this.minProtocolVersion = minProtocolVersion;
    }

    @JsonProperty("mode")
    public ServerTLSSettingsTLSmode getMode() {
        return mode;
    }

    @JsonProperty("mode")
    public void setMode(ServerTLSSettingsTLSmode mode) {
        this.mode = mode;
    }

    @JsonProperty("privateKey")
    public String getPrivateKey() {
        return privateKey;
    }

    @JsonProperty("privateKey")
    public void setPrivateKey(String privateKey) {
        this.privateKey = privateKey;
    }

    @JsonProperty("serverCertificate")
    public String getServerCertificate() {
        return serverCertificate;
    }

    @JsonProperty("serverCertificate")
    public void setServerCertificate(String serverCertificate) {
        this.serverCertificate = serverCertificate;
    }

    @JsonProperty("subjectAltNames")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getSubjectAltNames() {
        return subjectAltNames;
    }

    @JsonProperty("subjectAltNames")
    public void setSubjectAltNames(List<String> subjectAltNames) {
        this.subjectAltNames = subjectAltNames;
    }

    @JsonProperty("verifyCertificateHash")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getVerifyCertificateHash() {
        return verifyCertificateHash;
    }

    @JsonProperty("verifyCertificateHash")
    public void setVerifyCertificateHash(List<String> verifyCertificateHash) {
        this.verifyCertificateHash = verifyCertificateHash;
    }

    @JsonProperty("verifyCertificateSpki")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getVerifyCertificateSpki() {
        return verifyCertificateSpki;
    }

    @JsonProperty("verifyCertificateSpki")
    public void setVerifyCertificateSpki(List<String> verifyCertificateSpki) {
        this.verifyCertificateSpki = verifyCertificateSpki;
    }

    @JsonIgnore
    public ServerTLSSettingsBuilder edit() {
        return new ServerTLSSettingsBuilder(this);
    }

    @JsonIgnore
    public ServerTLSSettingsBuilder toBuilder() {
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
