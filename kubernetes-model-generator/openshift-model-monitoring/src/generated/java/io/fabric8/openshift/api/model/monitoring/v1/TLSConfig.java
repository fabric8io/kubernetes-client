
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
import io.fabric8.kubernetes.api.model.SecretKeySelector;
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
    "ca",
    "caFile",
    "cert",
    "certFile",
    "insecureSkipVerify",
    "keyFile",
    "keySecret",
    "maxVersion",
    "minVersion",
    "serverName"
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
public class TLSConfig implements Editable<TLSConfigBuilder> , KubernetesResource
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
    @JsonProperty("maxVersion")
    private String maxVersion;
    @JsonProperty("minVersion")
    private String minVersion;
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

    public TLSConfig(SecretOrConfigMap ca, String caFile, SecretOrConfigMap cert, String certFile, Boolean insecureSkipVerify, String keyFile, SecretKeySelector keySecret, String maxVersion, String minVersion, String serverName) {
        super();
        this.ca = ca;
        this.caFile = caFile;
        this.cert = cert;
        this.certFile = certFile;
        this.insecureSkipVerify = insecureSkipVerify;
        this.keyFile = keyFile;
        this.keySecret = keySecret;
        this.maxVersion = maxVersion;
        this.minVersion = minVersion;
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

    @JsonProperty("serverName")
    public String getServerName() {
        return serverName;
    }

    @JsonProperty("serverName")
    public void setServerName(String serverName) {
        this.serverName = serverName;
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
