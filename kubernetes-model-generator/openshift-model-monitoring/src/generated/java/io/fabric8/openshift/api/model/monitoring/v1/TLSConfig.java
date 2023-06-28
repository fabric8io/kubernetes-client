
package io.fabric8.openshift.api.model.monitoring.v1;

import java.util.LinkedHashMap;
import java.util.Map;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.fabric8.kubernetes.api.model.Container;
import io.fabric8.kubernetes.api.model.IntOrString;
import io.fabric8.kubernetes.api.model.KubernetesResource;
import io.fabric8.kubernetes.api.model.LabelSelector;
import io.fabric8.kubernetes.api.model.LocalObjectReference;
import io.fabric8.kubernetes.api.model.ObjectMeta;
import io.fabric8.kubernetes.api.model.ObjectReference;
import io.fabric8.kubernetes.api.model.PersistentVolumeClaim;
import io.fabric8.kubernetes.api.model.PodTemplateSpec;
import io.fabric8.kubernetes.api.model.ResourceRequirements;
import io.fabric8.kubernetes.api.model.SecretKeySelector;
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;
import lombok.EqualsAndHashCode;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "apiVersion",
    "kind",
    "metadata",
    "ca",
    "caFile",
    "cert",
    "certFile",
    "insecureSkipVerify",
    "keyFile",
    "keySecret",
    "serverName"
})
@ToString
@EqualsAndHashCode
@Setter
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
    @BuildableReference(PersistentVolumeClaim.class)
})
@Generated("jsonschema2pojo")
public class TLSConfig implements KubernetesResource
{

    @JsonProperty("ca")
    private SecretOrConfigMap ca;
    @JsonProperty("caFile")
    private String caFile;
    @JsonProperty("cert")
    private SecretOrConfigMap cert;
    @JsonProperty("certFile")
    private String certFile;
    @JsonProperty("insecureSkipVerify")
    private Boolean insecureSkipVerify;
    @JsonProperty("keyFile")
    private String keyFile;
    @JsonProperty("keySecret")
    private SecretKeySelector keySecret;
    @JsonProperty("serverName")
    private String serverName;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public TLSConfig() {
    }

    public TLSConfig(SecretOrConfigMap ca, String caFile, SecretOrConfigMap cert, String certFile, Boolean insecureSkipVerify, String keyFile, SecretKeySelector keySecret, String serverName) {
        super();
        this.ca = ca;
        this.caFile = caFile;
        this.cert = cert;
        this.certFile = certFile;
        this.insecureSkipVerify = insecureSkipVerify;
        this.keyFile = keyFile;
        this.keySecret = keySecret;
        this.serverName = serverName;
    }

    @JsonProperty("ca")
    public SecretOrConfigMap getCa() {
        return ca;
    }

    @JsonProperty("ca")
    public void setCa(SecretOrConfigMap ca) {
        this.ca = ca;
    }

    @JsonProperty("caFile")
    public String getCaFile() {
        return caFile;
    }

    @JsonProperty("caFile")
    public void setCaFile(String caFile) {
        this.caFile = caFile;
    }

    @JsonProperty("cert")
    public SecretOrConfigMap getCert() {
        return cert;
    }

    @JsonProperty("cert")
    public void setCert(SecretOrConfigMap cert) {
        this.cert = cert;
    }

    @JsonProperty("certFile")
    public String getCertFile() {
        return certFile;
    }

    @JsonProperty("certFile")
    public void setCertFile(String certFile) {
        this.certFile = certFile;
    }

    @JsonProperty("insecureSkipVerify")
    public Boolean getInsecureSkipVerify() {
        return insecureSkipVerify;
    }

    @JsonProperty("insecureSkipVerify")
    public void setInsecureSkipVerify(Boolean insecureSkipVerify) {
        this.insecureSkipVerify = insecureSkipVerify;
    }

    @JsonProperty("keyFile")
    public String getKeyFile() {
        return keyFile;
    }

    @JsonProperty("keyFile")
    public void setKeyFile(String keyFile) {
        this.keyFile = keyFile;
    }

    @JsonProperty("keySecret")
    public SecretKeySelector getKeySecret() {
        return keySecret;
    }

    @JsonProperty("keySecret")
    public void setKeySecret(SecretKeySelector keySecret) {
        this.keySecret = keySecret;
    }

    @JsonProperty("serverName")
    public String getServerName() {
        return serverName;
    }

    @JsonProperty("serverName")
    public void setServerName(String serverName) {
        this.serverName = serverName;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
