
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
import io.fabric8.kubernetes.api.builder.Editable;
import io.fabric8.kubernetes.api.model.Container;
import io.fabric8.kubernetes.api.model.ContainerPort;
import io.fabric8.kubernetes.api.model.EnvVar;
import io.fabric8.kubernetes.api.model.IntOrString;
import io.fabric8.kubernetes.api.model.KubernetesResource;
import io.fabric8.kubernetes.api.model.LabelSelector;
import io.fabric8.kubernetes.api.model.LocalObjectReference;
import io.fabric8.kubernetes.api.model.ObjectMeta;
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
import tools.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(using = tools.jackson.databind.ValueDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "additionalCORSAllowedOrigins",
    "audit",
    "clientCA",
    "encryption",
    "servingCerts",
    "tlsAdherence",
    "tlsSecurityProfile"
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
    @BuildableReference(io.fabric8.kubernetes.api.model.ObjectReference.class),
    @BuildableReference(LocalObjectReference.class),
    @BuildableReference(PersistentVolumeClaim.class),
    @BuildableReference(EnvVar.class),
    @BuildableReference(ContainerPort.class),
    @BuildableReference(Volume.class),
    @BuildableReference(VolumeMount.class)
})
@Generated("io.fabric8.kubernetes.schema.generator.model.ModelGenerator")
public class APIServerSpec implements Editable<APIServerSpecBuilder>, KubernetesResource
{

    @JsonProperty("additionalCORSAllowedOrigins")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> additionalCORSAllowedOrigins = new ArrayList<>();
    @JsonProperty("audit")
    private Audit audit;
    @JsonProperty("clientCA")
    private ConfigMapNameReference clientCA;
    @JsonProperty("encryption")
    private APIServerEncryption encryption;
    @JsonProperty("servingCerts")
    private APIServerServingCerts servingCerts;
    @JsonProperty("tlsAdherence")
    private String tlsAdherence;
    @JsonProperty("tlsSecurityProfile")
    private TLSSecurityProfile tlsSecurityProfile;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public APIServerSpec() {
    }

    public APIServerSpec(List<String> additionalCORSAllowedOrigins, Audit audit, ConfigMapNameReference clientCA, APIServerEncryption encryption, APIServerServingCerts servingCerts, String tlsAdherence, TLSSecurityProfile tlsSecurityProfile) {
        super();
        this.additionalCORSAllowedOrigins = additionalCORSAllowedOrigins;
        this.audit = audit;
        this.clientCA = clientCA;
        this.encryption = encryption;
        this.servingCerts = servingCerts;
        this.tlsAdherence = tlsAdherence;
        this.tlsSecurityProfile = tlsSecurityProfile;
    }

    /**
     * additionalCORSAllowedOrigins lists additional, user-defined regular expressions describing hosts for which the API server allows access using the CORS headers. This may be needed to access the API and the integrated OAuth server from JavaScript applications. The values are regular expressions that correspond to the Golang regular expression language.
     */
    @JsonProperty("additionalCORSAllowedOrigins")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getAdditionalCORSAllowedOrigins() {
        return additionalCORSAllowedOrigins;
    }

    /**
     * additionalCORSAllowedOrigins lists additional, user-defined regular expressions describing hosts for which the API server allows access using the CORS headers. This may be needed to access the API and the integrated OAuth server from JavaScript applications. The values are regular expressions that correspond to the Golang regular expression language.
     */
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

    /**
     * tlsAdherence controls if components in the cluster adhere to the TLS security profile configured on this APIServer resource.<br><p> <br><p> Valid values are "LegacyAdheringComponentsOnly" and "StrictAllComponents".<br><p> <br><p> When set to "LegacyAdheringComponentsOnly", components that already honor the cluster-wide TLS profile continue to do so. Components that do not already honor it continue to use their individual TLS configurations.<br><p> <br><p> When set to "StrictAllComponents", all components must honor the configured TLS profile unless they have a component-specific TLS configuration that overrides it. This mode is recommended for security-conscious deployments and is required for certain compliance frameworks.<br><p> <br><p> Note: Some components such as Kubelet and IngressController have their own dedicated TLS configuration mechanisms via KubeletConfig and IngressController CRs respectively. When these component-specific TLS configurations are set, they take precedence over the cluster-wide tlsSecurityProfile. When not set, these components fall back to the cluster-wide default.<br><p> <br><p> Components that encounter an unknown value for tlsAdherence should treat it as "StrictAllComponents" and log a warning to ensure forward compatibility while defaulting to the more secure behavior.<br><p> <br><p> This field is optional. When omitted, this means the user has no opinion and the platform is left to choose reasonable defaults. These defaults are subject to change over time. The current default is LegacyAdheringComponentsOnly.<br><p> <br><p> Once set, this field may be changed to a different value, but may not be removed.
     */
    @JsonProperty("tlsAdherence")
    public String getTlsAdherence() {
        return tlsAdherence;
    }

    /**
     * tlsAdherence controls if components in the cluster adhere to the TLS security profile configured on this APIServer resource.<br><p> <br><p> Valid values are "LegacyAdheringComponentsOnly" and "StrictAllComponents".<br><p> <br><p> When set to "LegacyAdheringComponentsOnly", components that already honor the cluster-wide TLS profile continue to do so. Components that do not already honor it continue to use their individual TLS configurations.<br><p> <br><p> When set to "StrictAllComponents", all components must honor the configured TLS profile unless they have a component-specific TLS configuration that overrides it. This mode is recommended for security-conscious deployments and is required for certain compliance frameworks.<br><p> <br><p> Note: Some components such as Kubelet and IngressController have their own dedicated TLS configuration mechanisms via KubeletConfig and IngressController CRs respectively. When these component-specific TLS configurations are set, they take precedence over the cluster-wide tlsSecurityProfile. When not set, these components fall back to the cluster-wide default.<br><p> <br><p> Components that encounter an unknown value for tlsAdherence should treat it as "StrictAllComponents" and log a warning to ensure forward compatibility while defaulting to the more secure behavior.<br><p> <br><p> This field is optional. When omitted, this means the user has no opinion and the platform is left to choose reasonable defaults. These defaults are subject to change over time. The current default is LegacyAdheringComponentsOnly.<br><p> <br><p> Once set, this field may be changed to a different value, but may not be removed.
     */
    @JsonProperty("tlsAdherence")
    public void setTlsAdherence(String tlsAdherence) {
        this.tlsAdherence = tlsAdherence;
    }

    @JsonProperty("tlsSecurityProfile")
    public TLSSecurityProfile getTlsSecurityProfile() {
        return tlsSecurityProfile;
    }

    @JsonProperty("tlsSecurityProfile")
    public void setTlsSecurityProfile(TLSSecurityProfile tlsSecurityProfile) {
        this.tlsSecurityProfile = tlsSecurityProfile;
    }

    @JsonIgnore
    public APIServerSpecBuilder edit() {
        return new APIServerSpecBuilder(this);
    }

    @JsonIgnore
    public APIServerSpecBuilder toBuilder() {
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
