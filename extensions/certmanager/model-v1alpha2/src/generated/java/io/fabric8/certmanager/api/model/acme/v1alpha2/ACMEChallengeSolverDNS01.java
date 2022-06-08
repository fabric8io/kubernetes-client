
package io.fabric8.certmanager.api.model.acme.v1alpha2;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
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
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "apiVersion",
    "kind",
    "metadata",
    "acmedns",
    "akamai",
    "azuredns",
    "clouddns",
    "cloudflare",
    "cnameStrategy",
    "digitalocean",
    "rfc2136",
    "route53",
    "webhook"
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
    @BuildableReference(PersistentVolumeClaim.class),
    @BuildableReference(EnvVar.class),
    @BuildableReference(ContainerPort.class),
    @BuildableReference(Volume.class),
    @BuildableReference(VolumeMount.class)
})
public class ACMEChallengeSolverDNS01 implements KubernetesResource
{

    @JsonProperty("acmedns")
    private ACMEIssuerDNS01ProviderAcmeDNS acmedns;
    @JsonProperty("akamai")
    private ACMEIssuerDNS01ProviderAkamai akamai;
    @JsonProperty("azuredns")
    private ACMEIssuerDNS01ProviderAzureDNS azuredns;
    @JsonProperty("clouddns")
    private ACMEIssuerDNS01ProviderCloudDNS clouddns;
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
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public ACMEChallengeSolverDNS01() {
    }

    /**
     * 
     * @param route53
     * @param webhook
     * @param acmedns
     * @param cnameStrategy
     * @param akamai
     * @param clouddns
     * @param cloudflare
     * @param digitalocean
     * @param azuredns
     * @param rfc2136
     */
    public ACMEChallengeSolverDNS01(ACMEIssuerDNS01ProviderAcmeDNS acmedns, ACMEIssuerDNS01ProviderAkamai akamai, ACMEIssuerDNS01ProviderAzureDNS azuredns, ACMEIssuerDNS01ProviderCloudDNS clouddns, ACMEIssuerDNS01ProviderCloudflare cloudflare, String cnameStrategy, ACMEIssuerDNS01ProviderDigitalOcean digitalocean, ACMEIssuerDNS01ProviderRFC2136 rfc2136, ACMEIssuerDNS01ProviderRoute53 route53, ACMEIssuerDNS01ProviderWebhook webhook) {
        super();
        this.acmedns = acmedns;
        this.akamai = akamai;
        this.azuredns = azuredns;
        this.clouddns = clouddns;
        this.cloudflare = cloudflare;
        this.cnameStrategy = cnameStrategy;
        this.digitalocean = digitalocean;
        this.rfc2136 = rfc2136;
        this.route53 = route53;
        this.webhook = webhook;
    }

    @JsonProperty("acmedns")
    public ACMEIssuerDNS01ProviderAcmeDNS getAcmedns() {
        return acmedns;
    }

    @JsonProperty("acmedns")
    public void setAcmedns(ACMEIssuerDNS01ProviderAcmeDNS acmedns) {
        this.acmedns = acmedns;
    }

    @JsonProperty("akamai")
    public ACMEIssuerDNS01ProviderAkamai getAkamai() {
        return akamai;
    }

    @JsonProperty("akamai")
    public void setAkamai(ACMEIssuerDNS01ProviderAkamai akamai) {
        this.akamai = akamai;
    }

    @JsonProperty("azuredns")
    public ACMEIssuerDNS01ProviderAzureDNS getAzuredns() {
        return azuredns;
    }

    @JsonProperty("azuredns")
    public void setAzuredns(ACMEIssuerDNS01ProviderAzureDNS azuredns) {
        this.azuredns = azuredns;
    }

    @JsonProperty("clouddns")
    public ACMEIssuerDNS01ProviderCloudDNS getClouddns() {
        return clouddns;
    }

    @JsonProperty("clouddns")
    public void setClouddns(ACMEIssuerDNS01ProviderCloudDNS clouddns) {
        this.clouddns = clouddns;
    }

    @JsonProperty("cloudflare")
    public ACMEIssuerDNS01ProviderCloudflare getCloudflare() {
        return cloudflare;
    }

    @JsonProperty("cloudflare")
    public void setCloudflare(ACMEIssuerDNS01ProviderCloudflare cloudflare) {
        this.cloudflare = cloudflare;
    }

    @JsonProperty("cnameStrategy")
    public String getCnameStrategy() {
        return cnameStrategy;
    }

    @JsonProperty("cnameStrategy")
    public void setCnameStrategy(String cnameStrategy) {
        this.cnameStrategy = cnameStrategy;
    }

    @JsonProperty("digitalocean")
    public ACMEIssuerDNS01ProviderDigitalOcean getDigitalocean() {
        return digitalocean;
    }

    @JsonProperty("digitalocean")
    public void setDigitalocean(ACMEIssuerDNS01ProviderDigitalOcean digitalocean) {
        this.digitalocean = digitalocean;
    }

    @JsonProperty("rfc2136")
    public ACMEIssuerDNS01ProviderRFC2136 getRfc2136() {
        return rfc2136;
    }

    @JsonProperty("rfc2136")
    public void setRfc2136(ACMEIssuerDNS01ProviderRFC2136 rfc2136) {
        this.rfc2136 = rfc2136;
    }

    @JsonProperty("route53")
    public ACMEIssuerDNS01ProviderRoute53 getRoute53() {
        return route53;
    }

    @JsonProperty("route53")
    public void setRoute53(ACMEIssuerDNS01ProviderRoute53 route53) {
        this.route53 = route53;
    }

    @JsonProperty("webhook")
    public ACMEIssuerDNS01ProviderWebhook getWebhook() {
        return webhook;
    }

    @JsonProperty("webhook")
    public void setWebhook(ACMEIssuerDNS01ProviderWebhook webhook) {
        this.webhook = webhook;
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
