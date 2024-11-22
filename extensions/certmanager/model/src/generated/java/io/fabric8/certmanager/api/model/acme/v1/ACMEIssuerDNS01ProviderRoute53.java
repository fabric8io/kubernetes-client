
package io.fabric8.certmanager.api.model.acme.v1;

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
import io.fabric8.certmanager.api.model.meta.v1.SecretKeySelector;
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
    "accessKeyID",
    "accessKeyIDSecretRef",
    "auth",
    "hostedZoneID",
    "region",
    "role",
    "secretAccessKeySecretRef"
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
public class ACMEIssuerDNS01ProviderRoute53 implements Editable<ACMEIssuerDNS01ProviderRoute53Builder> , KubernetesResource
{

    @JsonProperty("accessKeyID")
    private String accessKeyID;
    @JsonProperty("accessKeyIDSecretRef")
    private SecretKeySelector accessKeyIDSecretRef;
    @JsonProperty("auth")
    private Route53Auth auth;
    @JsonProperty("hostedZoneID")
    private String hostedZoneID;
    @JsonProperty("region")
    private String region;
    @JsonProperty("role")
    private String role;
    @JsonProperty("secretAccessKeySecretRef")
    private SecretKeySelector secretAccessKeySecretRef;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public ACMEIssuerDNS01ProviderRoute53() {
    }

    public ACMEIssuerDNS01ProviderRoute53(String accessKeyID, SecretKeySelector accessKeyIDSecretRef, Route53Auth auth, String hostedZoneID, String region, String role, SecretKeySelector secretAccessKeySecretRef) {
        super();
        this.accessKeyID = accessKeyID;
        this.accessKeyIDSecretRef = accessKeyIDSecretRef;
        this.auth = auth;
        this.hostedZoneID = hostedZoneID;
        this.region = region;
        this.role = role;
        this.secretAccessKeySecretRef = secretAccessKeySecretRef;
    }

    @JsonProperty("accessKeyID")
    public String getAccessKeyID() {
        return accessKeyID;
    }

    @JsonProperty("accessKeyID")
    public void setAccessKeyID(String accessKeyID) {
        this.accessKeyID = accessKeyID;
    }

    @JsonProperty("accessKeyIDSecretRef")
    public SecretKeySelector getAccessKeyIDSecretRef() {
        return accessKeyIDSecretRef;
    }

    @JsonProperty("accessKeyIDSecretRef")
    public void setAccessKeyIDSecretRef(SecretKeySelector accessKeyIDSecretRef) {
        this.accessKeyIDSecretRef = accessKeyIDSecretRef;
    }

    @JsonProperty("auth")
    public Route53Auth getAuth() {
        return auth;
    }

    @JsonProperty("auth")
    public void setAuth(Route53Auth auth) {
        this.auth = auth;
    }

    @JsonProperty("hostedZoneID")
    public String getHostedZoneID() {
        return hostedZoneID;
    }

    @JsonProperty("hostedZoneID")
    public void setHostedZoneID(String hostedZoneID) {
        this.hostedZoneID = hostedZoneID;
    }

    @JsonProperty("region")
    public String getRegion() {
        return region;
    }

    @JsonProperty("region")
    public void setRegion(String region) {
        this.region = region;
    }

    @JsonProperty("role")
    public String getRole() {
        return role;
    }

    @JsonProperty("role")
    public void setRole(String role) {
        this.role = role;
    }

    @JsonProperty("secretAccessKeySecretRef")
    public SecretKeySelector getSecretAccessKeySecretRef() {
        return secretAccessKeySecretRef;
    }

    @JsonProperty("secretAccessKeySecretRef")
    public void setSecretAccessKeySecretRef(SecretKeySelector secretAccessKeySecretRef) {
        this.secretAccessKeySecretRef = secretAccessKeySecretRef;
    }

    @JsonIgnore
    public ACMEIssuerDNS01ProviderRoute53Builder edit() {
        return new ACMEIssuerDNS01ProviderRoute53Builder(this);
    }

    @JsonIgnore
    public ACMEIssuerDNS01ProviderRoute53Builder toBuilder() {
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
