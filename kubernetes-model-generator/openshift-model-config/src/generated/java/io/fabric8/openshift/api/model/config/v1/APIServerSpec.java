
package io.fabric8.openshift.api.model.config.v1;

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
    "additionalCORSAllowedOrigins",
    "audit",
    "clientCA",
    "encryption",
    "servingCerts",
    "tlsSecurityProfile"
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
public class APIServerSpec implements KubernetesResource
{

    @JsonProperty("additionalCORSAllowedOrigins")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> additionalCORSAllowedOrigins = new ArrayList<String>();
    @JsonProperty("audit")
    private Audit audit;
    @JsonProperty("clientCA")
    private ConfigMapNameReference clientCA;
    @JsonProperty("encryption")
    private APIServerEncryption encryption;
    @JsonProperty("servingCerts")
    private APIServerServingCerts servingCerts;
    @JsonProperty("tlsSecurityProfile")
    private TLSSecurityProfile tlsSecurityProfile;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public APIServerSpec() {
    }

    public APIServerSpec(List<String> additionalCORSAllowedOrigins, Audit audit, ConfigMapNameReference clientCA, APIServerEncryption encryption, APIServerServingCerts servingCerts, TLSSecurityProfile tlsSecurityProfile) {
        super();
        this.additionalCORSAllowedOrigins = additionalCORSAllowedOrigins;
        this.audit = audit;
        this.clientCA = clientCA;
        this.encryption = encryption;
        this.servingCerts = servingCerts;
        this.tlsSecurityProfile = tlsSecurityProfile;
    }

    @JsonProperty("additionalCORSAllowedOrigins")
    public List<String> getAdditionalCORSAllowedOrigins() {
        return additionalCORSAllowedOrigins;
    }

    @JsonProperty("additionalCORSAllowedOrigins")
    public void setAdditionalCORSAllowedOrigins(List<String> additionalCORSAllowedOrigins) {
        this.additionalCORSAllowedOrigins = additionalCORSAllowedOrigins;
    }

    @JsonProperty("audit")
    public Audit getAudit() {
        return audit;
    }

    @JsonProperty("audit")
    public void setAudit(Audit audit) {
        this.audit = audit;
    }

    @JsonProperty("clientCA")
    public ConfigMapNameReference getClientCA() {
        return clientCA;
    }

    @JsonProperty("clientCA")
    public void setClientCA(ConfigMapNameReference clientCA) {
        this.clientCA = clientCA;
    }

    @JsonProperty("encryption")
    public APIServerEncryption getEncryption() {
        return encryption;
    }

    @JsonProperty("encryption")
    public void setEncryption(APIServerEncryption encryption) {
        this.encryption = encryption;
    }

    @JsonProperty("servingCerts")
    public APIServerServingCerts getServingCerts() {
        return servingCerts;
    }

    @JsonProperty("servingCerts")
    public void setServingCerts(APIServerServingCerts servingCerts) {
        this.servingCerts = servingCerts;
    }

    @JsonProperty("tlsSecurityProfile")
    public TLSSecurityProfile getTlsSecurityProfile() {
        return tlsSecurityProfile;
    }

    @JsonProperty("tlsSecurityProfile")
    public void setTlsSecurityProfile(TLSSecurityProfile tlsSecurityProfile) {
        this.tlsSecurityProfile = tlsSecurityProfile;
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
