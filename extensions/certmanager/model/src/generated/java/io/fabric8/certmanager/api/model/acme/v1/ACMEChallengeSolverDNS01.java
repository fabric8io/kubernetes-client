
package io.fabric8.certmanager.api.model.acme.v1;

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
 * Used to configure a DNS01 challenge provider to be used when solving DNS01 challenges. Only one DNS provider may be configured per solver.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "acmeDNS",
    "akamai",
    "azureDNS",
    "cloudDNS",
    "cloudflare",
    "cnameStrategy",
    "digitalocean",
    "rfc2136",
    "route53",
    "webhook"
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
public class ACMEChallengeSolverDNS01 implements Editable<ACMEChallengeSolverDNS01Builder>, KubernetesResource
{

    @JsonProperty("acmeDNS")
    private ACMEIssuerDNS01ProviderAcmeDNS acmeDNS;
    @JsonProperty("akamai")
    private ACMEIssuerDNS01ProviderAkamai akamai;
    @JsonProperty("azureDNS")
    private ACMEIssuerDNS01ProviderAzureDNS azureDNS;
    @JsonProperty("cloudDNS")
    private ACMEIssuerDNS01ProviderCloudDNS cloudDNS;
    @JsonProperty("cloudflare")
    private ACMEIssuerDNS01ProviderCloudflare cloudflare;
    @JsonProperty("cnameStrategy")
    private String cnameStrategy;
    @JsonProperty("digitalocean")
    private ACMEIssuerDNS01ProviderDigitalOcean digitalocean;
    @JsonProperty("rfc2136")
    private ACMEIssuerDNS01ProviderRFC2136 rfc2136;
    @JsonProperty("route53")
    private ACMEIssuerDNS01ProviderRoute53 route53;
    @JsonProperty("webhook")
    private ACMEIssuerDNS01ProviderWebhook webhook;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public ACMEChallengeSolverDNS01() {
    }

    public ACMEChallengeSolverDNS01(ACMEIssuerDNS01ProviderAcmeDNS acmeDNS, ACMEIssuerDNS01ProviderAkamai akamai, ACMEIssuerDNS01ProviderAzureDNS azureDNS, ACMEIssuerDNS01ProviderCloudDNS cloudDNS, ACMEIssuerDNS01ProviderCloudflare cloudflare, String cnameStrategy, ACMEIssuerDNS01ProviderDigitalOcean digitalocean, ACMEIssuerDNS01ProviderRFC2136 rfc2136, ACMEIssuerDNS01ProviderRoute53 route53, ACMEIssuerDNS01ProviderWebhook webhook) {
        super();
        this.acmeDNS = acmeDNS;
        this.akamai = akamai;
        this.azureDNS = azureDNS;
        this.cloudDNS = cloudDNS;
        this.cloudflare = cloudflare;
        this.cnameStrategy = cnameStrategy;
        this.digitalocean = digitalocean;
        this.rfc2136 = rfc2136;
        this.route53 = route53;
        this.webhook = webhook;
    }

    /**
     * Used to configure a DNS01 challenge provider to be used when solving DNS01 challenges. Only one DNS provider may be configured per solver.
     */
    @JsonProperty("acmeDNS")
    public ACMEIssuerDNS01ProviderAcmeDNS getAcmeDNS() {
        return acmeDNS;
    }

    /**
     * Used to configure a DNS01 challenge provider to be used when solving DNS01 challenges. Only one DNS provider may be configured per solver.
     */
    @JsonProperty("acmeDNS")
    public void setAcmeDNS(ACMEIssuerDNS01ProviderAcmeDNS acmeDNS) {
        this.acmeDNS = acmeDNS;
    }

    /**
     * Used to configure a DNS01 challenge provider to be used when solving DNS01 challenges. Only one DNS provider may be configured per solver.
     */
    @JsonProperty("akamai")
    public ACMEIssuerDNS01ProviderAkamai getAkamai() {
        return akamai;
    }

    /**
     * Used to configure a DNS01 challenge provider to be used when solving DNS01 challenges. Only one DNS provider may be configured per solver.
     */
    @JsonProperty("akamai")
    public void setAkamai(ACMEIssuerDNS01ProviderAkamai akamai) {
        this.akamai = akamai;
    }

    /**
     * Used to configure a DNS01 challenge provider to be used when solving DNS01 challenges. Only one DNS provider may be configured per solver.
     */
    @JsonProperty("azureDNS")
    public ACMEIssuerDNS01ProviderAzureDNS getAzureDNS() {
        return azureDNS;
    }

    /**
     * Used to configure a DNS01 challenge provider to be used when solving DNS01 challenges. Only one DNS provider may be configured per solver.
     */
    @JsonProperty("azureDNS")
    public void setAzureDNS(ACMEIssuerDNS01ProviderAzureDNS azureDNS) {
        this.azureDNS = azureDNS;
    }

    /**
     * Used to configure a DNS01 challenge provider to be used when solving DNS01 challenges. Only one DNS provider may be configured per solver.
     */
    @JsonProperty("cloudDNS")
    public ACMEIssuerDNS01ProviderCloudDNS getCloudDNS() {
        return cloudDNS;
    }

    /**
     * Used to configure a DNS01 challenge provider to be used when solving DNS01 challenges. Only one DNS provider may be configured per solver.
     */
    @JsonProperty("cloudDNS")
    public void setCloudDNS(ACMEIssuerDNS01ProviderCloudDNS cloudDNS) {
        this.cloudDNS = cloudDNS;
    }

    /**
     * Used to configure a DNS01 challenge provider to be used when solving DNS01 challenges. Only one DNS provider may be configured per solver.
     */
    @JsonProperty("cloudflare")
    public ACMEIssuerDNS01ProviderCloudflare getCloudflare() {
        return cloudflare;
    }

    /**
     * Used to configure a DNS01 challenge provider to be used when solving DNS01 challenges. Only one DNS provider may be configured per solver.
     */
    @JsonProperty("cloudflare")
    public void setCloudflare(ACMEIssuerDNS01ProviderCloudflare cloudflare) {
        this.cloudflare = cloudflare;
    }

    /**
     * CNAMEStrategy configures how the DNS01 provider should handle CNAME records when found in DNS zones.
     */
    @JsonProperty("cnameStrategy")
    public String getCnameStrategy() {
        return cnameStrategy;
    }

    /**
     * CNAMEStrategy configures how the DNS01 provider should handle CNAME records when found in DNS zones.
     */
    @JsonProperty("cnameStrategy")
    public void setCnameStrategy(String cnameStrategy) {
        this.cnameStrategy = cnameStrategy;
    }

    /**
     * Used to configure a DNS01 challenge provider to be used when solving DNS01 challenges. Only one DNS provider may be configured per solver.
     */
    @JsonProperty("digitalocean")
    public ACMEIssuerDNS01ProviderDigitalOcean getDigitalocean() {
        return digitalocean;
    }

    /**
     * Used to configure a DNS01 challenge provider to be used when solving DNS01 challenges. Only one DNS provider may be configured per solver.
     */
    @JsonProperty("digitalocean")
    public void setDigitalocean(ACMEIssuerDNS01ProviderDigitalOcean digitalocean) {
        this.digitalocean = digitalocean;
    }

    /**
     * Used to configure a DNS01 challenge provider to be used when solving DNS01 challenges. Only one DNS provider may be configured per solver.
     */
    @JsonProperty("rfc2136")
    public ACMEIssuerDNS01ProviderRFC2136 getRfc2136() {
        return rfc2136;
    }

    /**
     * Used to configure a DNS01 challenge provider to be used when solving DNS01 challenges. Only one DNS provider may be configured per solver.
     */
    @JsonProperty("rfc2136")
    public void setRfc2136(ACMEIssuerDNS01ProviderRFC2136 rfc2136) {
        this.rfc2136 = rfc2136;
    }

    /**
     * Used to configure a DNS01 challenge provider to be used when solving DNS01 challenges. Only one DNS provider may be configured per solver.
     */
    @JsonProperty("route53")
    public ACMEIssuerDNS01ProviderRoute53 getRoute53() {
        return route53;
    }

    /**
     * Used to configure a DNS01 challenge provider to be used when solving DNS01 challenges. Only one DNS provider may be configured per solver.
     */
    @JsonProperty("route53")
    public void setRoute53(ACMEIssuerDNS01ProviderRoute53 route53) {
        this.route53 = route53;
    }

    /**
     * Used to configure a DNS01 challenge provider to be used when solving DNS01 challenges. Only one DNS provider may be configured per solver.
     */
    @JsonProperty("webhook")
    public ACMEIssuerDNS01ProviderWebhook getWebhook() {
        return webhook;
    }

    /**
     * Used to configure a DNS01 challenge provider to be used when solving DNS01 challenges. Only one DNS provider may be configured per solver.
     */
    @JsonProperty("webhook")
    public void setWebhook(ACMEIssuerDNS01ProviderWebhook webhook) {
        this.webhook = webhook;
    }

    @JsonIgnore
    public ACMEChallengeSolverDNS01Builder edit() {
        return new ACMEChallengeSolverDNS01Builder(this);
    }

    @JsonIgnore
    public ACMEChallengeSolverDNS01Builder toBuilder() {
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
