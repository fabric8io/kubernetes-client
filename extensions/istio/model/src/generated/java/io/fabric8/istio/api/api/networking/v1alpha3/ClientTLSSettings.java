
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
    "clientCertificate",
    "credentialName",
    "insecureSkipVerify",
    "mode",
    "privateKey",
    "sni",
    "subjectAltNames"
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
public class ClientTLSSettings implements Editable<ClientTLSSettingsBuilder> , KubernetesResource
{

    @JsonProperty("caCertificates")
    private String caCertificates;
    @JsonProperty("caCrl")
    private String caCrl;
    @JsonProperty("clientCertificate")
    private String clientCertificate;
    @JsonProperty("credentialName")
    private String credentialName;
    @JsonProperty("insecureSkipVerify")
    private Boolean insecureSkipVerify;
    @JsonProperty("mode")
    private ClientTLSSettingsTLSmode mode;
    @JsonProperty("privateKey")
    private String privateKey;
    @JsonProperty("sni")
    private String sni;
    @JsonProperty("subjectAltNames")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> subjectAltNames = new ArrayList<>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public ClientTLSSettings() {
    }

    public ClientTLSSettings(String caCertificates, String caCrl, String clientCertificate, String credentialName, Boolean insecureSkipVerify, ClientTLSSettingsTLSmode mode, String privateKey, String sni, List<String> subjectAltNames) {
        super();
        this.caCertificates = caCertificates;
        this.caCrl = caCrl;
        this.clientCertificate = clientCertificate;
        this.credentialName = credentialName;
        this.insecureSkipVerify = insecureSkipVerify;
        this.mode = mode;
        this.privateKey = privateKey;
        this.sni = sni;
        this.subjectAltNames = subjectAltNames;
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

    @JsonProperty("clientCertificate")
    public String getClientCertificate() {
        return clientCertificate;
    }

    @JsonProperty("clientCertificate")
    public void setClientCertificate(String clientCertificate) {
        this.clientCertificate = clientCertificate;
    }

    @JsonProperty("credentialName")
    public String getCredentialName() {
        return credentialName;
    }

    @JsonProperty("credentialName")
    public void setCredentialName(String credentialName) {
        this.credentialName = credentialName;
    }

    @JsonProperty("insecureSkipVerify")
    public Boolean getInsecureSkipVerify() {
        return insecureSkipVerify;
    }

    @JsonProperty("insecureSkipVerify")
    public void setInsecureSkipVerify(Boolean insecureSkipVerify) {
        this.insecureSkipVerify = insecureSkipVerify;
    }

    @JsonProperty("mode")
    public ClientTLSSettingsTLSmode getMode() {
        return mode;
    }

    @JsonProperty("mode")
    public void setMode(ClientTLSSettingsTLSmode mode) {
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

    @JsonProperty("sni")
    public String getSni() {
        return sni;
    }

    @JsonProperty("sni")
    public void setSni(String sni) {
        this.sni = sni;
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

    @JsonIgnore
    public ClientTLSSettingsBuilder edit() {
        return new ClientTLSSettingsBuilder(this);
    }

    @JsonIgnore
    public ClientTLSSettingsBuilder toBuilder() {
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
