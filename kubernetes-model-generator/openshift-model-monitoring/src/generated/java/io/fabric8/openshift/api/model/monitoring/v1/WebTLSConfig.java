
package io.fabric8.openshift.api.model.monitoring.v1;

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
    "cert",
    "cipherSuites",
    "clientAuthType",
    "client_ca",
    "curvePreferences",
    "keySecret",
    "maxVersion",
    "minVersion",
    "preferServerCipherSuites"
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
public class WebTLSConfig implements KubernetesResource
{

    @JsonProperty("cert")
    private SecretOrConfigMap cert;
    @JsonProperty("cipherSuites")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> cipherSuites = new ArrayList<String>();
    @JsonProperty("clientAuthType")
    private String clientAuthType;
    @JsonProperty("client_ca")
    private SecretOrConfigMap clientCa;
    @JsonProperty("curvePreferences")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> curvePreferences = new ArrayList<String>();
    @JsonProperty("keySecret")
    private SecretKeySelector keySecret;
    @JsonProperty("maxVersion")
    private String maxVersion;
    @JsonProperty("minVersion")
    private String minVersion;
    @JsonProperty("preferServerCipherSuites")
    private Boolean preferServerCipherSuites;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public WebTLSConfig() {
    }

    public WebTLSConfig(SecretOrConfigMap cert, List<String> cipherSuites, String clientAuthType, SecretOrConfigMap clientCa, List<String> curvePreferences, SecretKeySelector keySecret, String maxVersion, String minVersion, Boolean preferServerCipherSuites) {
        super();
        this.cert = cert;
        this.cipherSuites = cipherSuites;
        this.clientAuthType = clientAuthType;
        this.clientCa = clientCa;
        this.curvePreferences = curvePreferences;
        this.keySecret = keySecret;
        this.maxVersion = maxVersion;
        this.minVersion = minVersion;
        this.preferServerCipherSuites = preferServerCipherSuites;
    }

    @JsonProperty("cert")
    public SecretOrConfigMap getCert() {
        return cert;
    }

    @JsonProperty("cert")
    public void setCert(SecretOrConfigMap cert) {
        this.cert = cert;
    }

    @JsonProperty("cipherSuites")
    public List<String> getCipherSuites() {
        return cipherSuites;
    }

    @JsonProperty("cipherSuites")
    public void setCipherSuites(List<String> cipherSuites) {
        this.cipherSuites = cipherSuites;
    }

    @JsonProperty("clientAuthType")
    public String getClientAuthType() {
        return clientAuthType;
    }

    @JsonProperty("clientAuthType")
    public void setClientAuthType(String clientAuthType) {
        this.clientAuthType = clientAuthType;
    }

    @JsonProperty("client_ca")
    public SecretOrConfigMap getClientCa() {
        return clientCa;
    }

    @JsonProperty("client_ca")
    public void setClientCa(SecretOrConfigMap clientCa) {
        this.clientCa = clientCa;
    }

    @JsonProperty("curvePreferences")
    public List<String> getCurvePreferences() {
        return curvePreferences;
    }

    @JsonProperty("curvePreferences")
    public void setCurvePreferences(List<String> curvePreferences) {
        this.curvePreferences = curvePreferences;
    }

    @JsonProperty("keySecret")
    public SecretKeySelector getKeySecret() {
        return keySecret;
    }

    @JsonProperty("keySecret")
    public void setKeySecret(SecretKeySelector keySecret) {
        this.keySecret = keySecret;
    }

    @JsonProperty("maxVersion")
    public String getMaxVersion() {
        return maxVersion;
    }

    @JsonProperty("maxVersion")
    public void setMaxVersion(String maxVersion) {
        this.maxVersion = maxVersion;
    }

    @JsonProperty("minVersion")
    public String getMinVersion() {
        return minVersion;
    }

    @JsonProperty("minVersion")
    public void setMinVersion(String minVersion) {
        this.minVersion = minVersion;
    }

    @JsonProperty("preferServerCipherSuites")
    public Boolean getPreferServerCipherSuites() {
        return preferServerCipherSuites;
    }

    @JsonProperty("preferServerCipherSuites")
    public void setPreferServerCipherSuites(Boolean preferServerCipherSuites) {
        this.preferServerCipherSuites = preferServerCipherSuites;
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
