
package io.fabric8.openshift.api.model.monitoring.v1beta1;

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
import io.fabric8.kubernetes.api.model.IntOrString;
import io.fabric8.kubernetes.api.model.KubernetesResource;
import io.fabric8.kubernetes.api.model.LabelSelector;
import io.fabric8.kubernetes.api.model.LocalObjectReference;
import io.fabric8.kubernetes.api.model.ObjectMeta;
import io.fabric8.kubernetes.api.model.ObjectReference;
import io.fabric8.kubernetes.api.model.PersistentVolumeClaim;
import io.fabric8.kubernetes.api.model.PodTemplateSpec;
import io.fabric8.kubernetes.api.model.ResourceRequirements;
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "ca",
    "cert",
    "insecureSkipVerify",
    "keySecret",
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
    @BuildableReference(PersistentVolumeClaim.class)
})
@Generated("jsonschema2pojo")
public class AlertmanagerConfigSpecRWCHCTlsConfig_2 implements Editable<AlertmanagerConfigSpecRWCHCTlsConfig_2Builder> , KubernetesResource
{

    @JsonProperty("ca")
    private AlertmanagerConfigSpecRWCHCTCCa_2 ca;
    @JsonProperty("cert")
    private AlertmanagerConfigSpecRWCHCTCCert_2 cert;
    @JsonProperty("insecureSkipVerify")
    private Boolean insecureSkipVerify;
    @JsonProperty("keySecret")
    private AlertmanagerConfigSpecRWCHCTCKeySecret_2 keySecret;
    @JsonProperty("serverName")
    private String serverName;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public AlertmanagerConfigSpecRWCHCTlsConfig_2() {
    }

    public AlertmanagerConfigSpecRWCHCTlsConfig_2(AlertmanagerConfigSpecRWCHCTCCa_2 ca, AlertmanagerConfigSpecRWCHCTCCert_2 cert, Boolean insecureSkipVerify, AlertmanagerConfigSpecRWCHCTCKeySecret_2 keySecret, String serverName) {
        super();
        this.ca = ca;
        this.cert = cert;
        this.insecureSkipVerify = insecureSkipVerify;
        this.keySecret = keySecret;
        this.serverName = serverName;
    }

    @JsonProperty("ca")
    public AlertmanagerConfigSpecRWCHCTCCa_2 getCa() {
        return ca;
    }

    @JsonProperty("ca")
    public void setCa(AlertmanagerConfigSpecRWCHCTCCa_2 ca) {
        this.ca = ca;
    }

    @JsonProperty("cert")
    public AlertmanagerConfigSpecRWCHCTCCert_2 getCert() {
        return cert;
    }

    @JsonProperty("cert")
    public void setCert(AlertmanagerConfigSpecRWCHCTCCert_2 cert) {
        this.cert = cert;
    }

    @JsonProperty("insecureSkipVerify")
    public Boolean getInsecureSkipVerify() {
        return insecureSkipVerify;
    }

    @JsonProperty("insecureSkipVerify")
    public void setInsecureSkipVerify(Boolean insecureSkipVerify) {
        this.insecureSkipVerify = insecureSkipVerify;
    }

    @JsonProperty("keySecret")
    public AlertmanagerConfigSpecRWCHCTCKeySecret_2 getKeySecret() {
        return keySecret;
    }

    @JsonProperty("keySecret")
    public void setKeySecret(AlertmanagerConfigSpecRWCHCTCKeySecret_2 keySecret) {
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

    @JsonIgnore
    public AlertmanagerConfigSpecRWCHCTlsConfig_2Builder edit() {
        return new AlertmanagerConfigSpecRWCHCTlsConfig_2Builder(this);
    }

    @JsonIgnore
    public AlertmanagerConfigSpecRWCHCTlsConfig_2Builder toBuilder() {
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
