package io.fabric8.certmanager.api.model.acme.v1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import java.lang.Object;
import java.lang.String;
import java.lang.StringBuilder;
import java.lang.SuppressWarnings;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

/**
 * Generated
 */
@SuppressWarnings("unchecked")
public class ACMEChallengeSolverDNS01Fluent<A extends io.fabric8.certmanager.api.model.acme.v1.ACMEChallengeSolverDNS01Fluent<A>> extends BaseFluent<A>{

  private ACMEIssuerDNS01ProviderAcmeDNSBuilder acmeDNS;
  private Map<String,Object> additionalProperties;
  private ACMEIssuerDNS01ProviderAkamaiBuilder akamai;
  private ACMEIssuerDNS01ProviderAzureDNSBuilder azureDNS;
  private ACMEIssuerDNS01ProviderCloudDNSBuilder cloudDNS;
  private ACMEIssuerDNS01ProviderCloudflareBuilder cloudflare;
  private String cnameStrategy;
  private ACMEIssuerDNS01ProviderDigitalOceanBuilder digitalocean;
  private ACMEIssuerDNS01ProviderRFC2136Builder rfc2136;
  private ACMEIssuerDNS01ProviderRoute53Builder route53;
  private ACMEIssuerDNS01ProviderWebhookBuilder webhook;

  public ACMEChallengeSolverDNS01Fluent() {
  }
  
  public ACMEChallengeSolverDNS01Fluent(ACMEChallengeSolverDNS01 instance) {
    this.copyInstance(instance);
  }

  public A addToAdditionalProperties(Map<String,Object> map) {
    if (this.additionalProperties == null && map != null) {
      this.additionalProperties = new LinkedHashMap();
    }
    if (map != null) {
      this.additionalProperties.putAll(map);
    }
    return (A) this;
  }
  
  public A addToAdditionalProperties(String key,Object value) {
    if (this.additionalProperties == null && key != null && value != null) {
      this.additionalProperties = new LinkedHashMap();
    }
    if (key != null && value != null) {
      this.additionalProperties.put(key, value);
    }
    return (A) this;
  }
  
  public ACMEIssuerDNS01ProviderAcmeDNS buildAcmeDNS() {
    return this.acmeDNS != null ? this.acmeDNS.build() : null;
  }
  
  public ACMEIssuerDNS01ProviderAkamai buildAkamai() {
    return this.akamai != null ? this.akamai.build() : null;
  }
  
  public ACMEIssuerDNS01ProviderAzureDNS buildAzureDNS() {
    return this.azureDNS != null ? this.azureDNS.build() : null;
  }
  
  public ACMEIssuerDNS01ProviderCloudDNS buildCloudDNS() {
    return this.cloudDNS != null ? this.cloudDNS.build() : null;
  }
  
  public ACMEIssuerDNS01ProviderCloudflare buildCloudflare() {
    return this.cloudflare != null ? this.cloudflare.build() : null;
  }
  
  public ACMEIssuerDNS01ProviderDigitalOcean buildDigitalocean() {
    return this.digitalocean != null ? this.digitalocean.build() : null;
  }
  
  public ACMEIssuerDNS01ProviderRFC2136 buildRfc2136() {
    return this.rfc2136 != null ? this.rfc2136.build() : null;
  }
  
  public ACMEIssuerDNS01ProviderRoute53 buildRoute53() {
    return this.route53 != null ? this.route53.build() : null;
  }
  
  public ACMEIssuerDNS01ProviderWebhook buildWebhook() {
    return this.webhook != null ? this.webhook.build() : null;
  }
  
  protected void copyInstance(ACMEChallengeSolverDNS01 instance) {
    instance = instance != null ? instance : new ACMEChallengeSolverDNS01();
    if (instance != null) {
        this.withAcmeDNS(instance.getAcmeDNS());
        this.withAkamai(instance.getAkamai());
        this.withAzureDNS(instance.getAzureDNS());
        this.withCloudDNS(instance.getCloudDNS());
        this.withCloudflare(instance.getCloudflare());
        this.withCnameStrategy(instance.getCnameStrategy());
        this.withDigitalocean(instance.getDigitalocean());
        this.withRfc2136(instance.getRfc2136());
        this.withRoute53(instance.getRoute53());
        this.withWebhook(instance.getWebhook());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public AcmeDNSNested<A> editAcmeDNS() {
    return this.withNewAcmeDNSLike(Optional.ofNullable(this.buildAcmeDNS()).orElse(null));
  }
  
  public AkamaiNested<A> editAkamai() {
    return this.withNewAkamaiLike(Optional.ofNullable(this.buildAkamai()).orElse(null));
  }
  
  public AzureDNSNested<A> editAzureDNS() {
    return this.withNewAzureDNSLike(Optional.ofNullable(this.buildAzureDNS()).orElse(null));
  }
  
  public CloudDNSNested<A> editCloudDNS() {
    return this.withNewCloudDNSLike(Optional.ofNullable(this.buildCloudDNS()).orElse(null));
  }
  
  public CloudflareNested<A> editCloudflare() {
    return this.withNewCloudflareLike(Optional.ofNullable(this.buildCloudflare()).orElse(null));
  }
  
  public DigitaloceanNested<A> editDigitalocean() {
    return this.withNewDigitaloceanLike(Optional.ofNullable(this.buildDigitalocean()).orElse(null));
  }
  
  public AcmeDNSNested<A> editOrNewAcmeDNS() {
    return this.withNewAcmeDNSLike(Optional.ofNullable(this.buildAcmeDNS()).orElse(new ACMEIssuerDNS01ProviderAcmeDNSBuilder().build()));
  }
  
  public AcmeDNSNested<A> editOrNewAcmeDNSLike(ACMEIssuerDNS01ProviderAcmeDNS item) {
    return this.withNewAcmeDNSLike(Optional.ofNullable(this.buildAcmeDNS()).orElse(item));
  }
  
  public AkamaiNested<A> editOrNewAkamai() {
    return this.withNewAkamaiLike(Optional.ofNullable(this.buildAkamai()).orElse(new ACMEIssuerDNS01ProviderAkamaiBuilder().build()));
  }
  
  public AkamaiNested<A> editOrNewAkamaiLike(ACMEIssuerDNS01ProviderAkamai item) {
    return this.withNewAkamaiLike(Optional.ofNullable(this.buildAkamai()).orElse(item));
  }
  
  public AzureDNSNested<A> editOrNewAzureDNS() {
    return this.withNewAzureDNSLike(Optional.ofNullable(this.buildAzureDNS()).orElse(new ACMEIssuerDNS01ProviderAzureDNSBuilder().build()));
  }
  
  public AzureDNSNested<A> editOrNewAzureDNSLike(ACMEIssuerDNS01ProviderAzureDNS item) {
    return this.withNewAzureDNSLike(Optional.ofNullable(this.buildAzureDNS()).orElse(item));
  }
  
  public CloudDNSNested<A> editOrNewCloudDNS() {
    return this.withNewCloudDNSLike(Optional.ofNullable(this.buildCloudDNS()).orElse(new ACMEIssuerDNS01ProviderCloudDNSBuilder().build()));
  }
  
  public CloudDNSNested<A> editOrNewCloudDNSLike(ACMEIssuerDNS01ProviderCloudDNS item) {
    return this.withNewCloudDNSLike(Optional.ofNullable(this.buildCloudDNS()).orElse(item));
  }
  
  public CloudflareNested<A> editOrNewCloudflare() {
    return this.withNewCloudflareLike(Optional.ofNullable(this.buildCloudflare()).orElse(new ACMEIssuerDNS01ProviderCloudflareBuilder().build()));
  }
  
  public CloudflareNested<A> editOrNewCloudflareLike(ACMEIssuerDNS01ProviderCloudflare item) {
    return this.withNewCloudflareLike(Optional.ofNullable(this.buildCloudflare()).orElse(item));
  }
  
  public DigitaloceanNested<A> editOrNewDigitalocean() {
    return this.withNewDigitaloceanLike(Optional.ofNullable(this.buildDigitalocean()).orElse(new ACMEIssuerDNS01ProviderDigitalOceanBuilder().build()));
  }
  
  public DigitaloceanNested<A> editOrNewDigitaloceanLike(ACMEIssuerDNS01ProviderDigitalOcean item) {
    return this.withNewDigitaloceanLike(Optional.ofNullable(this.buildDigitalocean()).orElse(item));
  }
  
  public Rfc2136Nested<A> editOrNewRfc2136() {
    return this.withNewRfc2136Like(Optional.ofNullable(this.buildRfc2136()).orElse(new ACMEIssuerDNS01ProviderRFC2136Builder().build()));
  }
  
  public Rfc2136Nested<A> editOrNewRfc2136Like(ACMEIssuerDNS01ProviderRFC2136 item) {
    return this.withNewRfc2136Like(Optional.ofNullable(this.buildRfc2136()).orElse(item));
  }
  
  public Route53Nested<A> editOrNewRoute53() {
    return this.withNewRoute53Like(Optional.ofNullable(this.buildRoute53()).orElse(new ACMEIssuerDNS01ProviderRoute53Builder().build()));
  }
  
  public Route53Nested<A> editOrNewRoute53Like(ACMEIssuerDNS01ProviderRoute53 item) {
    return this.withNewRoute53Like(Optional.ofNullable(this.buildRoute53()).orElse(item));
  }
  
  public WebhookNested<A> editOrNewWebhook() {
    return this.withNewWebhookLike(Optional.ofNullable(this.buildWebhook()).orElse(new ACMEIssuerDNS01ProviderWebhookBuilder().build()));
  }
  
  public WebhookNested<A> editOrNewWebhookLike(ACMEIssuerDNS01ProviderWebhook item) {
    return this.withNewWebhookLike(Optional.ofNullable(this.buildWebhook()).orElse(item));
  }
  
  public Rfc2136Nested<A> editRfc2136() {
    return this.withNewRfc2136Like(Optional.ofNullable(this.buildRfc2136()).orElse(null));
  }
  
  public Route53Nested<A> editRoute53() {
    return this.withNewRoute53Like(Optional.ofNullable(this.buildRoute53()).orElse(null));
  }
  
  public WebhookNested<A> editWebhook() {
    return this.withNewWebhookLike(Optional.ofNullable(this.buildWebhook()).orElse(null));
  }
  
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || this.getClass() != o.getClass()) {
      return false;
    }
    if (!(super.equals(o))) {
      return false;
    }
    ACMEChallengeSolverDNS01Fluent that = (ACMEChallengeSolverDNS01Fluent) o;
    if (!(Objects.equals(acmeDNS, that.acmeDNS))) {
      return false;
    }
    if (!(Objects.equals(akamai, that.akamai))) {
      return false;
    }
    if (!(Objects.equals(azureDNS, that.azureDNS))) {
      return false;
    }
    if (!(Objects.equals(cloudDNS, that.cloudDNS))) {
      return false;
    }
    if (!(Objects.equals(cloudflare, that.cloudflare))) {
      return false;
    }
    if (!(Objects.equals(cnameStrategy, that.cnameStrategy))) {
      return false;
    }
    if (!(Objects.equals(digitalocean, that.digitalocean))) {
      return false;
    }
    if (!(Objects.equals(rfc2136, that.rfc2136))) {
      return false;
    }
    if (!(Objects.equals(route53, that.route53))) {
      return false;
    }
    if (!(Objects.equals(webhook, that.webhook))) {
      return false;
    }
    if (!(Objects.equals(additionalProperties, that.additionalProperties))) {
      return false;
    }
    return true;
  }
  
  public Map<String,Object> getAdditionalProperties() {
    return this.additionalProperties;
  }
  
  public String getCnameStrategy() {
    return this.cnameStrategy;
  }
  
  public boolean hasAcmeDNS() {
    return this.acmeDNS != null;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasAkamai() {
    return this.akamai != null;
  }
  
  public boolean hasAzureDNS() {
    return this.azureDNS != null;
  }
  
  public boolean hasCloudDNS() {
    return this.cloudDNS != null;
  }
  
  public boolean hasCloudflare() {
    return this.cloudflare != null;
  }
  
  public boolean hasCnameStrategy() {
    return this.cnameStrategy != null;
  }
  
  public boolean hasDigitalocean() {
    return this.digitalocean != null;
  }
  
  public boolean hasRfc2136() {
    return this.rfc2136 != null;
  }
  
  public boolean hasRoute53() {
    return this.route53 != null;
  }
  
  public boolean hasWebhook() {
    return this.webhook != null;
  }
  
  public int hashCode() {
    return Objects.hash(acmeDNS, akamai, azureDNS, cloudDNS, cloudflare, cnameStrategy, digitalocean, rfc2136, route53, webhook, additionalProperties);
  }
  
  public A removeFromAdditionalProperties(String key) {
    if (this.additionalProperties == null) {
      return (A) this;
    }
    if (key != null && this.additionalProperties != null) {
      this.additionalProperties.remove(key);
    }
    return (A) this;
  }
  
  public A removeFromAdditionalProperties(Map<String,Object> map) {
    if (this.additionalProperties == null) {
      return (A) this;
    }
    if (map != null) {
      for (Object key : map.keySet()) {
        if (this.additionalProperties != null) {
          this.additionalProperties.remove(key);
        }
      }
    }
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(acmeDNS == null)) {
        sb.append("acmeDNS:");
        sb.append(acmeDNS);
        sb.append(",");
    }
    if (!(akamai == null)) {
        sb.append("akamai:");
        sb.append(akamai);
        sb.append(",");
    }
    if (!(azureDNS == null)) {
        sb.append("azureDNS:");
        sb.append(azureDNS);
        sb.append(",");
    }
    if (!(cloudDNS == null)) {
        sb.append("cloudDNS:");
        sb.append(cloudDNS);
        sb.append(",");
    }
    if (!(cloudflare == null)) {
        sb.append("cloudflare:");
        sb.append(cloudflare);
        sb.append(",");
    }
    if (!(cnameStrategy == null)) {
        sb.append("cnameStrategy:");
        sb.append(cnameStrategy);
        sb.append(",");
    }
    if (!(digitalocean == null)) {
        sb.append("digitalocean:");
        sb.append(digitalocean);
        sb.append(",");
    }
    if (!(rfc2136 == null)) {
        sb.append("rfc2136:");
        sb.append(rfc2136);
        sb.append(",");
    }
    if (!(route53 == null)) {
        sb.append("route53:");
        sb.append(route53);
        sb.append(",");
    }
    if (!(webhook == null)) {
        sb.append("webhook:");
        sb.append(webhook);
        sb.append(",");
    }
    if (!(additionalProperties == null) && !(additionalProperties.isEmpty())) {
        sb.append("additionalProperties:");
        sb.append(additionalProperties);
    }
    sb.append("}");
    return sb.toString();
  }
  
  public A withAcmeDNS(ACMEIssuerDNS01ProviderAcmeDNS acmeDNS) {
    this._visitables.remove("acmeDNS");
    if (acmeDNS != null) {
        this.acmeDNS = new ACMEIssuerDNS01ProviderAcmeDNSBuilder(acmeDNS);
        this._visitables.get("acmeDNS").add(this.acmeDNS);
    } else {
        this.acmeDNS = null;
        this._visitables.get("acmeDNS").remove(this.acmeDNS);
    }
    return (A) this;
  }
  
  public <K,V>A withAdditionalProperties(Map<String,Object> additionalProperties) {
    if (additionalProperties == null) {
      this.additionalProperties = null;
    } else {
      this.additionalProperties = new LinkedHashMap(additionalProperties);
    }
    return (A) this;
  }
  
  public A withAkamai(ACMEIssuerDNS01ProviderAkamai akamai) {
    this._visitables.remove("akamai");
    if (akamai != null) {
        this.akamai = new ACMEIssuerDNS01ProviderAkamaiBuilder(akamai);
        this._visitables.get("akamai").add(this.akamai);
    } else {
        this.akamai = null;
        this._visitables.get("akamai").remove(this.akamai);
    }
    return (A) this;
  }
  
  public A withAzureDNS(ACMEIssuerDNS01ProviderAzureDNS azureDNS) {
    this._visitables.remove("azureDNS");
    if (azureDNS != null) {
        this.azureDNS = new ACMEIssuerDNS01ProviderAzureDNSBuilder(azureDNS);
        this._visitables.get("azureDNS").add(this.azureDNS);
    } else {
        this.azureDNS = null;
        this._visitables.get("azureDNS").remove(this.azureDNS);
    }
    return (A) this;
  }
  
  public A withCloudDNS(ACMEIssuerDNS01ProviderCloudDNS cloudDNS) {
    this._visitables.remove("cloudDNS");
    if (cloudDNS != null) {
        this.cloudDNS = new ACMEIssuerDNS01ProviderCloudDNSBuilder(cloudDNS);
        this._visitables.get("cloudDNS").add(this.cloudDNS);
    } else {
        this.cloudDNS = null;
        this._visitables.get("cloudDNS").remove(this.cloudDNS);
    }
    return (A) this;
  }
  
  public A withCloudflare(ACMEIssuerDNS01ProviderCloudflare cloudflare) {
    this._visitables.remove("cloudflare");
    if (cloudflare != null) {
        this.cloudflare = new ACMEIssuerDNS01ProviderCloudflareBuilder(cloudflare);
        this._visitables.get("cloudflare").add(this.cloudflare);
    } else {
        this.cloudflare = null;
        this._visitables.get("cloudflare").remove(this.cloudflare);
    }
    return (A) this;
  }
  
  public A withCnameStrategy(String cnameStrategy) {
    this.cnameStrategy = cnameStrategy;
    return (A) this;
  }
  
  public A withDigitalocean(ACMEIssuerDNS01ProviderDigitalOcean digitalocean) {
    this._visitables.remove("digitalocean");
    if (digitalocean != null) {
        this.digitalocean = new ACMEIssuerDNS01ProviderDigitalOceanBuilder(digitalocean);
        this._visitables.get("digitalocean").add(this.digitalocean);
    } else {
        this.digitalocean = null;
        this._visitables.get("digitalocean").remove(this.digitalocean);
    }
    return (A) this;
  }
  
  public AcmeDNSNested<A> withNewAcmeDNS() {
    return new AcmeDNSNested(null);
  }
  
  public AcmeDNSNested<A> withNewAcmeDNSLike(ACMEIssuerDNS01ProviderAcmeDNS item) {
    return new AcmeDNSNested(item);
  }
  
  public AkamaiNested<A> withNewAkamai() {
    return new AkamaiNested(null);
  }
  
  public AkamaiNested<A> withNewAkamaiLike(ACMEIssuerDNS01ProviderAkamai item) {
    return new AkamaiNested(item);
  }
  
  public AzureDNSNested<A> withNewAzureDNS() {
    return new AzureDNSNested(null);
  }
  
  public AzureDNSNested<A> withNewAzureDNSLike(ACMEIssuerDNS01ProviderAzureDNS item) {
    return new AzureDNSNested(item);
  }
  
  public CloudDNSNested<A> withNewCloudDNS() {
    return new CloudDNSNested(null);
  }
  
  public CloudDNSNested<A> withNewCloudDNSLike(ACMEIssuerDNS01ProviderCloudDNS item) {
    return new CloudDNSNested(item);
  }
  
  public CloudflareNested<A> withNewCloudflare() {
    return new CloudflareNested(null);
  }
  
  public CloudflareNested<A> withNewCloudflareLike(ACMEIssuerDNS01ProviderCloudflare item) {
    return new CloudflareNested(item);
  }
  
  public DigitaloceanNested<A> withNewDigitalocean() {
    return new DigitaloceanNested(null);
  }
  
  public DigitaloceanNested<A> withNewDigitaloceanLike(ACMEIssuerDNS01ProviderDigitalOcean item) {
    return new DigitaloceanNested(item);
  }
  
  public Rfc2136Nested<A> withNewRfc2136() {
    return new Rfc2136Nested(null);
  }
  
  public Rfc2136Nested<A> withNewRfc2136Like(ACMEIssuerDNS01ProviderRFC2136 item) {
    return new Rfc2136Nested(item);
  }
  
  public Route53Nested<A> withNewRoute53() {
    return new Route53Nested(null);
  }
  
  public Route53Nested<A> withNewRoute53Like(ACMEIssuerDNS01ProviderRoute53 item) {
    return new Route53Nested(item);
  }
  
  public WebhookNested<A> withNewWebhook() {
    return new WebhookNested(null);
  }
  
  public WebhookNested<A> withNewWebhookLike(ACMEIssuerDNS01ProviderWebhook item) {
    return new WebhookNested(item);
  }
  
  public A withRfc2136(ACMEIssuerDNS01ProviderRFC2136 rfc2136) {
    this._visitables.remove("rfc2136");
    if (rfc2136 != null) {
        this.rfc2136 = new ACMEIssuerDNS01ProviderRFC2136Builder(rfc2136);
        this._visitables.get("rfc2136").add(this.rfc2136);
    } else {
        this.rfc2136 = null;
        this._visitables.get("rfc2136").remove(this.rfc2136);
    }
    return (A) this;
  }
  
  public A withRoute53(ACMEIssuerDNS01ProviderRoute53 route53) {
    this._visitables.remove("route53");
    if (route53 != null) {
        this.route53 = new ACMEIssuerDNS01ProviderRoute53Builder(route53);
        this._visitables.get("route53").add(this.route53);
    } else {
        this.route53 = null;
        this._visitables.get("route53").remove(this.route53);
    }
    return (A) this;
  }
  
  public A withWebhook(ACMEIssuerDNS01ProviderWebhook webhook) {
    this._visitables.remove("webhook");
    if (webhook != null) {
        this.webhook = new ACMEIssuerDNS01ProviderWebhookBuilder(webhook);
        this._visitables.get("webhook").add(this.webhook);
    } else {
        this.webhook = null;
        this._visitables.get("webhook").remove(this.webhook);
    }
    return (A) this;
  }
  public class AcmeDNSNested<N> extends ACMEIssuerDNS01ProviderAcmeDNSFluent<AcmeDNSNested<N>> implements Nested<N>{
  
    ACMEIssuerDNS01ProviderAcmeDNSBuilder builder;
  
    AcmeDNSNested(ACMEIssuerDNS01ProviderAcmeDNS item) {
      this.builder = new ACMEIssuerDNS01ProviderAcmeDNSBuilder(this, item);
    }
  
    public N and() {
      return (N) ACMEChallengeSolverDNS01Fluent.this.withAcmeDNS(builder.build());
    }
    
    public N endAcmeDNS() {
      return and();
    }
    
  }
  public class AkamaiNested<N> extends ACMEIssuerDNS01ProviderAkamaiFluent<AkamaiNested<N>> implements Nested<N>{
  
    ACMEIssuerDNS01ProviderAkamaiBuilder builder;
  
    AkamaiNested(ACMEIssuerDNS01ProviderAkamai item) {
      this.builder = new ACMEIssuerDNS01ProviderAkamaiBuilder(this, item);
    }
  
    public N and() {
      return (N) ACMEChallengeSolverDNS01Fluent.this.withAkamai(builder.build());
    }
    
    public N endAkamai() {
      return and();
    }
    
  }
  public class AzureDNSNested<N> extends ACMEIssuerDNS01ProviderAzureDNSFluent<AzureDNSNested<N>> implements Nested<N>{
  
    ACMEIssuerDNS01ProviderAzureDNSBuilder builder;
  
    AzureDNSNested(ACMEIssuerDNS01ProviderAzureDNS item) {
      this.builder = new ACMEIssuerDNS01ProviderAzureDNSBuilder(this, item);
    }
  
    public N and() {
      return (N) ACMEChallengeSolverDNS01Fluent.this.withAzureDNS(builder.build());
    }
    
    public N endAzureDNS() {
      return and();
    }
    
  }
  public class CloudDNSNested<N> extends ACMEIssuerDNS01ProviderCloudDNSFluent<CloudDNSNested<N>> implements Nested<N>{
  
    ACMEIssuerDNS01ProviderCloudDNSBuilder builder;
  
    CloudDNSNested(ACMEIssuerDNS01ProviderCloudDNS item) {
      this.builder = new ACMEIssuerDNS01ProviderCloudDNSBuilder(this, item);
    }
  
    public N and() {
      return (N) ACMEChallengeSolverDNS01Fluent.this.withCloudDNS(builder.build());
    }
    
    public N endCloudDNS() {
      return and();
    }
    
  }
  public class CloudflareNested<N> extends ACMEIssuerDNS01ProviderCloudflareFluent<CloudflareNested<N>> implements Nested<N>{
  
    ACMEIssuerDNS01ProviderCloudflareBuilder builder;
  
    CloudflareNested(ACMEIssuerDNS01ProviderCloudflare item) {
      this.builder = new ACMEIssuerDNS01ProviderCloudflareBuilder(this, item);
    }
  
    public N and() {
      return (N) ACMEChallengeSolverDNS01Fluent.this.withCloudflare(builder.build());
    }
    
    public N endCloudflare() {
      return and();
    }
    
  }
  public class DigitaloceanNested<N> extends ACMEIssuerDNS01ProviderDigitalOceanFluent<DigitaloceanNested<N>> implements Nested<N>{
  
    ACMEIssuerDNS01ProviderDigitalOceanBuilder builder;
  
    DigitaloceanNested(ACMEIssuerDNS01ProviderDigitalOcean item) {
      this.builder = new ACMEIssuerDNS01ProviderDigitalOceanBuilder(this, item);
    }
  
    public N and() {
      return (N) ACMEChallengeSolverDNS01Fluent.this.withDigitalocean(builder.build());
    }
    
    public N endDigitalocean() {
      return and();
    }
    
  }
  public class Rfc2136Nested<N> extends ACMEIssuerDNS01ProviderRFC2136Fluent<Rfc2136Nested<N>> implements Nested<N>{
  
    ACMEIssuerDNS01ProviderRFC2136Builder builder;
  
    Rfc2136Nested(ACMEIssuerDNS01ProviderRFC2136 item) {
      this.builder = new ACMEIssuerDNS01ProviderRFC2136Builder(this, item);
    }
  
    public N and() {
      return (N) ACMEChallengeSolverDNS01Fluent.this.withRfc2136(builder.build());
    }
    
    public N endRfc2136() {
      return and();
    }
    
  }
  public class Route53Nested<N> extends ACMEIssuerDNS01ProviderRoute53Fluent<Route53Nested<N>> implements Nested<N>{
  
    ACMEIssuerDNS01ProviderRoute53Builder builder;
  
    Route53Nested(ACMEIssuerDNS01ProviderRoute53 item) {
      this.builder = new ACMEIssuerDNS01ProviderRoute53Builder(this, item);
    }
  
    public N and() {
      return (N) ACMEChallengeSolverDNS01Fluent.this.withRoute53(builder.build());
    }
    
    public N endRoute53() {
      return and();
    }
    
  }
  public class WebhookNested<N> extends ACMEIssuerDNS01ProviderWebhookFluent<WebhookNested<N>> implements Nested<N>{
  
    ACMEIssuerDNS01ProviderWebhookBuilder builder;
  
    WebhookNested(ACMEIssuerDNS01ProviderWebhook item) {
      this.builder = new ACMEIssuerDNS01ProviderWebhookBuilder(this, item);
    }
  
    public N and() {
      return (N) ACMEChallengeSolverDNS01Fluent.this.withWebhook(builder.build());
    }
    
    public N endWebhook() {
      return and();
    }
    
  }
}