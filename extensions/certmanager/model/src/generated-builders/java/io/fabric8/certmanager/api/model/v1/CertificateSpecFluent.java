package io.fabric8.certmanager.api.model.v1;

import io.fabric8.certmanager.api.model.meta.v1.IssuerReference;
import io.fabric8.certmanager.api.model.meta.v1.IssuerReferenceBuilder;
import io.fabric8.certmanager.api.model.meta.v1.IssuerReferenceFluent;
import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import io.fabric8.kubernetes.api.model.Duration;
import java.lang.Boolean;
import java.lang.Integer;
import java.lang.Object;
import java.lang.RuntimeException;
import java.lang.String;
import java.lang.StringBuilder;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Predicate;

/**
 * Generated
 */
@SuppressWarnings("unchecked")
public class CertificateSpecFluent<A extends io.fabric8.certmanager.api.model.v1.CertificateSpecFluent<A>> extends BaseFluent<A>{

  private ArrayList<CertificateAdditionalOutputFormatBuilder> additionalOutputFormats = new ArrayList<CertificateAdditionalOutputFormatBuilder>();
  private Map<String,Object> additionalProperties;
  private String commonName;
  private List<String> dnsNames = new ArrayList<String>();
  private Duration duration;
  private List<String> emailAddresses = new ArrayList<String>();
  private Boolean encodeUsagesInRequest;
  private List<String> ipAddresses = new ArrayList<String>();
  private Boolean isCA;
  private IssuerReferenceBuilder issuerRef;
  private CertificateKeystoresBuilder keystores;
  private String literalSubject;
  private NameConstraintsBuilder nameConstraints;
  private ArrayList<OtherNameBuilder> otherNames = new ArrayList<OtherNameBuilder>();
  private CertificatePrivateKeyBuilder privateKey;
  private Duration renewBefore;
  private Integer renewBeforePercentage;
  private Integer revisionHistoryLimit;
  private String secretName;
  private CertificateSecretTemplateBuilder secretTemplate;
  private String signatureAlgorithm;
  private X509SubjectBuilder subject;
  private List<String> uris = new ArrayList<String>();
  private List<String> usages = new ArrayList<String>();

  public CertificateSpecFluent() {
  }
  
  public CertificateSpecFluent(CertificateSpec instance) {
    this.copyInstance(instance);
  }

  public A addAllToAdditionalOutputFormats(Collection<CertificateAdditionalOutputFormat> items) {
    if (this.additionalOutputFormats == null) {
      this.additionalOutputFormats = new ArrayList();
    }
    for (CertificateAdditionalOutputFormat item : items) {
        CertificateAdditionalOutputFormatBuilder builder = new CertificateAdditionalOutputFormatBuilder(item);
        _visitables.get("additionalOutputFormats").add(builder);
        this.additionalOutputFormats.add(builder);
    }
    return (A) this;
  }
  
  public A addAllToDnsNames(Collection<String> items) {
    if (this.dnsNames == null) {
      this.dnsNames = new ArrayList();
    }
    for (String item : items) {
      this.dnsNames.add(item);
    }
    return (A) this;
  }
  
  public A addAllToEmailAddresses(Collection<String> items) {
    if (this.emailAddresses == null) {
      this.emailAddresses = new ArrayList();
    }
    for (String item : items) {
      this.emailAddresses.add(item);
    }
    return (A) this;
  }
  
  public A addAllToIpAddresses(Collection<String> items) {
    if (this.ipAddresses == null) {
      this.ipAddresses = new ArrayList();
    }
    for (String item : items) {
      this.ipAddresses.add(item);
    }
    return (A) this;
  }
  
  public A addAllToOtherNames(Collection<OtherName> items) {
    if (this.otherNames == null) {
      this.otherNames = new ArrayList();
    }
    for (OtherName item : items) {
        OtherNameBuilder builder = new OtherNameBuilder(item);
        _visitables.get("otherNames").add(builder);
        this.otherNames.add(builder);
    }
    return (A) this;
  }
  
  public A addAllToUris(Collection<String> items) {
    if (this.uris == null) {
      this.uris = new ArrayList();
    }
    for (String item : items) {
      this.uris.add(item);
    }
    return (A) this;
  }
  
  public A addAllToUsages(Collection<String> items) {
    if (this.usages == null) {
      this.usages = new ArrayList();
    }
    for (String item : items) {
      this.usages.add(item);
    }
    return (A) this;
  }
  
  public AdditionalOutputFormatsNested<A> addNewAdditionalOutputFormat() {
    return new AdditionalOutputFormatsNested(-1, null);
  }
  
  public A addNewAdditionalOutputFormat(String type) {
    return (A) this.addToAdditionalOutputFormats(new CertificateAdditionalOutputFormat(type));
  }
  
  public AdditionalOutputFormatsNested<A> addNewAdditionalOutputFormatLike(CertificateAdditionalOutputFormat item) {
    return new AdditionalOutputFormatsNested(-1, item);
  }
  
  public OtherNamesNested<A> addNewOtherName() {
    return new OtherNamesNested(-1, null);
  }
  
  public A addNewOtherName(String oid,String utf8Value) {
    return (A) this.addToOtherNames(new OtherName(oid, utf8Value));
  }
  
  public OtherNamesNested<A> addNewOtherNameLike(OtherName item) {
    return new OtherNamesNested(-1, item);
  }
  
  public A addToAdditionalOutputFormats(CertificateAdditionalOutputFormat... items) {
    if (this.additionalOutputFormats == null) {
      this.additionalOutputFormats = new ArrayList();
    }
    for (CertificateAdditionalOutputFormat item : items) {
        CertificateAdditionalOutputFormatBuilder builder = new CertificateAdditionalOutputFormatBuilder(item);
        _visitables.get("additionalOutputFormats").add(builder);
        this.additionalOutputFormats.add(builder);
    }
    return (A) this;
  }
  
  public A addToAdditionalOutputFormats(int index,CertificateAdditionalOutputFormat item) {
    if (this.additionalOutputFormats == null) {
      this.additionalOutputFormats = new ArrayList();
    }
    CertificateAdditionalOutputFormatBuilder builder = new CertificateAdditionalOutputFormatBuilder(item);
    if (index < 0 || index >= additionalOutputFormats.size()) {
        _visitables.get("additionalOutputFormats").add(builder);
        additionalOutputFormats.add(builder);
    } else {
        _visitables.get("additionalOutputFormats").add(builder);
        additionalOutputFormats.add(index, builder);
    }
    return (A) this;
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
  
  public A addToDnsNames(String... items) {
    if (this.dnsNames == null) {
      this.dnsNames = new ArrayList();
    }
    for (String item : items) {
      this.dnsNames.add(item);
    }
    return (A) this;
  }
  
  public A addToDnsNames(int index,String item) {
    if (this.dnsNames == null) {
      this.dnsNames = new ArrayList();
    }
    this.dnsNames.add(index, item);
    return (A) this;
  }
  
  public A addToEmailAddresses(String... items) {
    if (this.emailAddresses == null) {
      this.emailAddresses = new ArrayList();
    }
    for (String item : items) {
      this.emailAddresses.add(item);
    }
    return (A) this;
  }
  
  public A addToEmailAddresses(int index,String item) {
    if (this.emailAddresses == null) {
      this.emailAddresses = new ArrayList();
    }
    this.emailAddresses.add(index, item);
    return (A) this;
  }
  
  public A addToIpAddresses(String... items) {
    if (this.ipAddresses == null) {
      this.ipAddresses = new ArrayList();
    }
    for (String item : items) {
      this.ipAddresses.add(item);
    }
    return (A) this;
  }
  
  public A addToIpAddresses(int index,String item) {
    if (this.ipAddresses == null) {
      this.ipAddresses = new ArrayList();
    }
    this.ipAddresses.add(index, item);
    return (A) this;
  }
  
  public A addToOtherNames(OtherName... items) {
    if (this.otherNames == null) {
      this.otherNames = new ArrayList();
    }
    for (OtherName item : items) {
        OtherNameBuilder builder = new OtherNameBuilder(item);
        _visitables.get("otherNames").add(builder);
        this.otherNames.add(builder);
    }
    return (A) this;
  }
  
  public A addToOtherNames(int index,OtherName item) {
    if (this.otherNames == null) {
      this.otherNames = new ArrayList();
    }
    OtherNameBuilder builder = new OtherNameBuilder(item);
    if (index < 0 || index >= otherNames.size()) {
        _visitables.get("otherNames").add(builder);
        otherNames.add(builder);
    } else {
        _visitables.get("otherNames").add(builder);
        otherNames.add(index, builder);
    }
    return (A) this;
  }
  
  public A addToUris(String... items) {
    if (this.uris == null) {
      this.uris = new ArrayList();
    }
    for (String item : items) {
      this.uris.add(item);
    }
    return (A) this;
  }
  
  public A addToUris(int index,String item) {
    if (this.uris == null) {
      this.uris = new ArrayList();
    }
    this.uris.add(index, item);
    return (A) this;
  }
  
  public A addToUsages(String... items) {
    if (this.usages == null) {
      this.usages = new ArrayList();
    }
    for (String item : items) {
      this.usages.add(item);
    }
    return (A) this;
  }
  
  public A addToUsages(int index,String item) {
    if (this.usages == null) {
      this.usages = new ArrayList();
    }
    this.usages.add(index, item);
    return (A) this;
  }
  
  public CertificateAdditionalOutputFormat buildAdditionalOutputFormat(int index) {
    return this.additionalOutputFormats.get(index).build();
  }
  
  public List<CertificateAdditionalOutputFormat> buildAdditionalOutputFormats() {
    return this.additionalOutputFormats != null ? build(additionalOutputFormats) : null;
  }
  
  public CertificateAdditionalOutputFormat buildFirstAdditionalOutputFormat() {
    return this.additionalOutputFormats.get(0).build();
  }
  
  public OtherName buildFirstOtherName() {
    return this.otherNames.get(0).build();
  }
  
  public IssuerReference buildIssuerRef() {
    return this.issuerRef != null ? this.issuerRef.build() : null;
  }
  
  public CertificateKeystores buildKeystores() {
    return this.keystores != null ? this.keystores.build() : null;
  }
  
  public CertificateAdditionalOutputFormat buildLastAdditionalOutputFormat() {
    return this.additionalOutputFormats.get(additionalOutputFormats.size() - 1).build();
  }
  
  public OtherName buildLastOtherName() {
    return this.otherNames.get(otherNames.size() - 1).build();
  }
  
  public CertificateAdditionalOutputFormat buildMatchingAdditionalOutputFormat(Predicate<CertificateAdditionalOutputFormatBuilder> predicate) {
      for (CertificateAdditionalOutputFormatBuilder item : additionalOutputFormats) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public OtherName buildMatchingOtherName(Predicate<OtherNameBuilder> predicate) {
      for (OtherNameBuilder item : otherNames) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public NameConstraints buildNameConstraints() {
    return this.nameConstraints != null ? this.nameConstraints.build() : null;
  }
  
  public OtherName buildOtherName(int index) {
    return this.otherNames.get(index).build();
  }
  
  public List<OtherName> buildOtherNames() {
    return this.otherNames != null ? build(otherNames) : null;
  }
  
  public CertificatePrivateKey buildPrivateKey() {
    return this.privateKey != null ? this.privateKey.build() : null;
  }
  
  public CertificateSecretTemplate buildSecretTemplate() {
    return this.secretTemplate != null ? this.secretTemplate.build() : null;
  }
  
  public X509Subject buildSubject() {
    return this.subject != null ? this.subject.build() : null;
  }
  
  protected void copyInstance(CertificateSpec instance) {
    instance = instance != null ? instance : new CertificateSpec();
    if (instance != null) {
        this.withAdditionalOutputFormats(instance.getAdditionalOutputFormats());
        this.withCommonName(instance.getCommonName());
        this.withDnsNames(instance.getDnsNames());
        this.withDuration(instance.getDuration());
        this.withEmailAddresses(instance.getEmailAddresses());
        this.withEncodeUsagesInRequest(instance.getEncodeUsagesInRequest());
        this.withIpAddresses(instance.getIpAddresses());
        this.withIsCA(instance.getIsCA());
        this.withIssuerRef(instance.getIssuerRef());
        this.withKeystores(instance.getKeystores());
        this.withLiteralSubject(instance.getLiteralSubject());
        this.withNameConstraints(instance.getNameConstraints());
        this.withOtherNames(instance.getOtherNames());
        this.withPrivateKey(instance.getPrivateKey());
        this.withRenewBefore(instance.getRenewBefore());
        this.withRenewBeforePercentage(instance.getRenewBeforePercentage());
        this.withRevisionHistoryLimit(instance.getRevisionHistoryLimit());
        this.withSecretName(instance.getSecretName());
        this.withSecretTemplate(instance.getSecretTemplate());
        this.withSignatureAlgorithm(instance.getSignatureAlgorithm());
        this.withSubject(instance.getSubject());
        this.withUris(instance.getUris());
        this.withUsages(instance.getUsages());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public AdditionalOutputFormatsNested<A> editAdditionalOutputFormat(int index) {
    if (additionalOutputFormats.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "additionalOutputFormats"));
    }
    return this.setNewAdditionalOutputFormatLike(index, this.buildAdditionalOutputFormat(index));
  }
  
  public AdditionalOutputFormatsNested<A> editFirstAdditionalOutputFormat() {
    if (additionalOutputFormats.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "additionalOutputFormats"));
    }
    return this.setNewAdditionalOutputFormatLike(0, this.buildAdditionalOutputFormat(0));
  }
  
  public OtherNamesNested<A> editFirstOtherName() {
    if (otherNames.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "otherNames"));
    }
    return this.setNewOtherNameLike(0, this.buildOtherName(0));
  }
  
  public IssuerRefNested<A> editIssuerRef() {
    return this.withNewIssuerRefLike(Optional.ofNullable(this.buildIssuerRef()).orElse(null));
  }
  
  public KeystoresNested<A> editKeystores() {
    return this.withNewKeystoresLike(Optional.ofNullable(this.buildKeystores()).orElse(null));
  }
  
  public AdditionalOutputFormatsNested<A> editLastAdditionalOutputFormat() {
    int index = additionalOutputFormats.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "additionalOutputFormats"));
    }
    return this.setNewAdditionalOutputFormatLike(index, this.buildAdditionalOutputFormat(index));
  }
  
  public OtherNamesNested<A> editLastOtherName() {
    int index = otherNames.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "otherNames"));
    }
    return this.setNewOtherNameLike(index, this.buildOtherName(index));
  }
  
  public AdditionalOutputFormatsNested<A> editMatchingAdditionalOutputFormat(Predicate<CertificateAdditionalOutputFormatBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < additionalOutputFormats.size();i++) {
      if (predicate.test(additionalOutputFormats.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "additionalOutputFormats"));
    }
    return this.setNewAdditionalOutputFormatLike(index, this.buildAdditionalOutputFormat(index));
  }
  
  public OtherNamesNested<A> editMatchingOtherName(Predicate<OtherNameBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < otherNames.size();i++) {
      if (predicate.test(otherNames.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "otherNames"));
    }
    return this.setNewOtherNameLike(index, this.buildOtherName(index));
  }
  
  public NameConstraintsNested<A> editNameConstraints() {
    return this.withNewNameConstraintsLike(Optional.ofNullable(this.buildNameConstraints()).orElse(null));
  }
  
  public IssuerRefNested<A> editOrNewIssuerRef() {
    return this.withNewIssuerRefLike(Optional.ofNullable(this.buildIssuerRef()).orElse(new IssuerReferenceBuilder().build()));
  }
  
  public IssuerRefNested<A> editOrNewIssuerRefLike(IssuerReference item) {
    return this.withNewIssuerRefLike(Optional.ofNullable(this.buildIssuerRef()).orElse(item));
  }
  
  public KeystoresNested<A> editOrNewKeystores() {
    return this.withNewKeystoresLike(Optional.ofNullable(this.buildKeystores()).orElse(new CertificateKeystoresBuilder().build()));
  }
  
  public KeystoresNested<A> editOrNewKeystoresLike(CertificateKeystores item) {
    return this.withNewKeystoresLike(Optional.ofNullable(this.buildKeystores()).orElse(item));
  }
  
  public NameConstraintsNested<A> editOrNewNameConstraints() {
    return this.withNewNameConstraintsLike(Optional.ofNullable(this.buildNameConstraints()).orElse(new NameConstraintsBuilder().build()));
  }
  
  public NameConstraintsNested<A> editOrNewNameConstraintsLike(NameConstraints item) {
    return this.withNewNameConstraintsLike(Optional.ofNullable(this.buildNameConstraints()).orElse(item));
  }
  
  public PrivateKeyNested<A> editOrNewPrivateKey() {
    return this.withNewPrivateKeyLike(Optional.ofNullable(this.buildPrivateKey()).orElse(new CertificatePrivateKeyBuilder().build()));
  }
  
  public PrivateKeyNested<A> editOrNewPrivateKeyLike(CertificatePrivateKey item) {
    return this.withNewPrivateKeyLike(Optional.ofNullable(this.buildPrivateKey()).orElse(item));
  }
  
  public SecretTemplateNested<A> editOrNewSecretTemplate() {
    return this.withNewSecretTemplateLike(Optional.ofNullable(this.buildSecretTemplate()).orElse(new CertificateSecretTemplateBuilder().build()));
  }
  
  public SecretTemplateNested<A> editOrNewSecretTemplateLike(CertificateSecretTemplate item) {
    return this.withNewSecretTemplateLike(Optional.ofNullable(this.buildSecretTemplate()).orElse(item));
  }
  
  public SubjectNested<A> editOrNewSubject() {
    return this.withNewSubjectLike(Optional.ofNullable(this.buildSubject()).orElse(new X509SubjectBuilder().build()));
  }
  
  public SubjectNested<A> editOrNewSubjectLike(X509Subject item) {
    return this.withNewSubjectLike(Optional.ofNullable(this.buildSubject()).orElse(item));
  }
  
  public OtherNamesNested<A> editOtherName(int index) {
    if (otherNames.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "otherNames"));
    }
    return this.setNewOtherNameLike(index, this.buildOtherName(index));
  }
  
  public PrivateKeyNested<A> editPrivateKey() {
    return this.withNewPrivateKeyLike(Optional.ofNullable(this.buildPrivateKey()).orElse(null));
  }
  
  public SecretTemplateNested<A> editSecretTemplate() {
    return this.withNewSecretTemplateLike(Optional.ofNullable(this.buildSecretTemplate()).orElse(null));
  }
  
  public SubjectNested<A> editSubject() {
    return this.withNewSubjectLike(Optional.ofNullable(this.buildSubject()).orElse(null));
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
    CertificateSpecFluent that = (CertificateSpecFluent) o;
    if (!(Objects.equals(additionalOutputFormats, that.additionalOutputFormats))) {
      return false;
    }
    if (!(Objects.equals(commonName, that.commonName))) {
      return false;
    }
    if (!(Objects.equals(dnsNames, that.dnsNames))) {
      return false;
    }
    if (!(Objects.equals(duration, that.duration))) {
      return false;
    }
    if (!(Objects.equals(emailAddresses, that.emailAddresses))) {
      return false;
    }
    if (!(Objects.equals(encodeUsagesInRequest, that.encodeUsagesInRequest))) {
      return false;
    }
    if (!(Objects.equals(ipAddresses, that.ipAddresses))) {
      return false;
    }
    if (!(Objects.equals(isCA, that.isCA))) {
      return false;
    }
    if (!(Objects.equals(issuerRef, that.issuerRef))) {
      return false;
    }
    if (!(Objects.equals(keystores, that.keystores))) {
      return false;
    }
    if (!(Objects.equals(literalSubject, that.literalSubject))) {
      return false;
    }
    if (!(Objects.equals(nameConstraints, that.nameConstraints))) {
      return false;
    }
    if (!(Objects.equals(otherNames, that.otherNames))) {
      return false;
    }
    if (!(Objects.equals(privateKey, that.privateKey))) {
      return false;
    }
    if (!(Objects.equals(renewBefore, that.renewBefore))) {
      return false;
    }
    if (!(Objects.equals(renewBeforePercentage, that.renewBeforePercentage))) {
      return false;
    }
    if (!(Objects.equals(revisionHistoryLimit, that.revisionHistoryLimit))) {
      return false;
    }
    if (!(Objects.equals(secretName, that.secretName))) {
      return false;
    }
    if (!(Objects.equals(secretTemplate, that.secretTemplate))) {
      return false;
    }
    if (!(Objects.equals(signatureAlgorithm, that.signatureAlgorithm))) {
      return false;
    }
    if (!(Objects.equals(subject, that.subject))) {
      return false;
    }
    if (!(Objects.equals(uris, that.uris))) {
      return false;
    }
    if (!(Objects.equals(usages, that.usages))) {
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
  
  public String getCommonName() {
    return this.commonName;
  }
  
  public String getDnsName(int index) {
    return this.dnsNames.get(index);
  }
  
  public List<String> getDnsNames() {
    return this.dnsNames;
  }
  
  public Duration getDuration() {
    return this.duration;
  }
  
  public String getEmailAddress(int index) {
    return this.emailAddresses.get(index);
  }
  
  public List<String> getEmailAddresses() {
    return this.emailAddresses;
  }
  
  public Boolean getEncodeUsagesInRequest() {
    return this.encodeUsagesInRequest;
  }
  
  public String getFirstDnsName() {
    return this.dnsNames.get(0);
  }
  
  public String getFirstEmailAddress() {
    return this.emailAddresses.get(0);
  }
  
  public String getFirstIpAddress() {
    return this.ipAddresses.get(0);
  }
  
  public String getFirstUri() {
    return this.uris.get(0);
  }
  
  public String getFirstUsage() {
    return this.usages.get(0);
  }
  
  public String getIpAddress(int index) {
    return this.ipAddresses.get(index);
  }
  
  public List<String> getIpAddresses() {
    return this.ipAddresses;
  }
  
  public Boolean getIsCA() {
    return this.isCA;
  }
  
  public String getLastDnsName() {
    return this.dnsNames.get(dnsNames.size() - 1);
  }
  
  public String getLastEmailAddress() {
    return this.emailAddresses.get(emailAddresses.size() - 1);
  }
  
  public String getLastIpAddress() {
    return this.ipAddresses.get(ipAddresses.size() - 1);
  }
  
  public String getLastUri() {
    return this.uris.get(uris.size() - 1);
  }
  
  public String getLastUsage() {
    return this.usages.get(usages.size() - 1);
  }
  
  public String getLiteralSubject() {
    return this.literalSubject;
  }
  
  public String getMatchingDnsName(Predicate<String> predicate) {
      for (String item : dnsNames) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public String getMatchingEmailAddress(Predicate<String> predicate) {
      for (String item : emailAddresses) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public String getMatchingIpAddress(Predicate<String> predicate) {
      for (String item : ipAddresses) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public String getMatchingUri(Predicate<String> predicate) {
      for (String item : uris) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public String getMatchingUsage(Predicate<String> predicate) {
      for (String item : usages) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public Duration getRenewBefore() {
    return this.renewBefore;
  }
  
  public Integer getRenewBeforePercentage() {
    return this.renewBeforePercentage;
  }
  
  public Integer getRevisionHistoryLimit() {
    return this.revisionHistoryLimit;
  }
  
  public String getSecretName() {
    return this.secretName;
  }
  
  public String getSignatureAlgorithm() {
    return this.signatureAlgorithm;
  }
  
  public String getUri(int index) {
    return this.uris.get(index);
  }
  
  public List<String> getUris() {
    return this.uris;
  }
  
  public String getUsage(int index) {
    return this.usages.get(index);
  }
  
  public List<String> getUsages() {
    return this.usages;
  }
  
  public boolean hasAdditionalOutputFormats() {
    return this.additionalOutputFormats != null && !(this.additionalOutputFormats.isEmpty());
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasCommonName() {
    return this.commonName != null;
  }
  
  public boolean hasDnsNames() {
    return this.dnsNames != null && !(this.dnsNames.isEmpty());
  }
  
  public boolean hasDuration() {
    return this.duration != null;
  }
  
  public boolean hasEmailAddresses() {
    return this.emailAddresses != null && !(this.emailAddresses.isEmpty());
  }
  
  public boolean hasEncodeUsagesInRequest() {
    return this.encodeUsagesInRequest != null;
  }
  
  public boolean hasIpAddresses() {
    return this.ipAddresses != null && !(this.ipAddresses.isEmpty());
  }
  
  public boolean hasIsCA() {
    return this.isCA != null;
  }
  
  public boolean hasIssuerRef() {
    return this.issuerRef != null;
  }
  
  public boolean hasKeystores() {
    return this.keystores != null;
  }
  
  public boolean hasLiteralSubject() {
    return this.literalSubject != null;
  }
  
  public boolean hasMatchingAdditionalOutputFormat(Predicate<CertificateAdditionalOutputFormatBuilder> predicate) {
      for (CertificateAdditionalOutputFormatBuilder item : additionalOutputFormats) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingDnsName(Predicate<String> predicate) {
      for (String item : dnsNames) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingEmailAddress(Predicate<String> predicate) {
      for (String item : emailAddresses) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingIpAddress(Predicate<String> predicate) {
      for (String item : ipAddresses) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingOtherName(Predicate<OtherNameBuilder> predicate) {
      for (OtherNameBuilder item : otherNames) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingUri(Predicate<String> predicate) {
      for (String item : uris) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingUsage(Predicate<String> predicate) {
      for (String item : usages) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasNameConstraints() {
    return this.nameConstraints != null;
  }
  
  public boolean hasOtherNames() {
    return this.otherNames != null && !(this.otherNames.isEmpty());
  }
  
  public boolean hasPrivateKey() {
    return this.privateKey != null;
  }
  
  public boolean hasRenewBefore() {
    return this.renewBefore != null;
  }
  
  public boolean hasRenewBeforePercentage() {
    return this.renewBeforePercentage != null;
  }
  
  public boolean hasRevisionHistoryLimit() {
    return this.revisionHistoryLimit != null;
  }
  
  public boolean hasSecretName() {
    return this.secretName != null;
  }
  
  public boolean hasSecretTemplate() {
    return this.secretTemplate != null;
  }
  
  public boolean hasSignatureAlgorithm() {
    return this.signatureAlgorithm != null;
  }
  
  public boolean hasSubject() {
    return this.subject != null;
  }
  
  public boolean hasUris() {
    return this.uris != null && !(this.uris.isEmpty());
  }
  
  public boolean hasUsages() {
    return this.usages != null && !(this.usages.isEmpty());
  }
  
  public int hashCode() {
    return Objects.hash(additionalOutputFormats, commonName, dnsNames, duration, emailAddresses, encodeUsagesInRequest, ipAddresses, isCA, issuerRef, keystores, literalSubject, nameConstraints, otherNames, privateKey, renewBefore, renewBeforePercentage, revisionHistoryLimit, secretName, secretTemplate, signatureAlgorithm, subject, uris, usages, additionalProperties);
  }
  
  public A removeAllFromAdditionalOutputFormats(Collection<CertificateAdditionalOutputFormat> items) {
    if (this.additionalOutputFormats == null) {
      return (A) this;
    }
    for (CertificateAdditionalOutputFormat item : items) {
        CertificateAdditionalOutputFormatBuilder builder = new CertificateAdditionalOutputFormatBuilder(item);
        _visitables.get("additionalOutputFormats").remove(builder);
        this.additionalOutputFormats.remove(builder);
    }
    return (A) this;
  }
  
  public A removeAllFromDnsNames(Collection<String> items) {
    if (this.dnsNames == null) {
      return (A) this;
    }
    for (String item : items) {
      this.dnsNames.remove(item);
    }
    return (A) this;
  }
  
  public A removeAllFromEmailAddresses(Collection<String> items) {
    if (this.emailAddresses == null) {
      return (A) this;
    }
    for (String item : items) {
      this.emailAddresses.remove(item);
    }
    return (A) this;
  }
  
  public A removeAllFromIpAddresses(Collection<String> items) {
    if (this.ipAddresses == null) {
      return (A) this;
    }
    for (String item : items) {
      this.ipAddresses.remove(item);
    }
    return (A) this;
  }
  
  public A removeAllFromOtherNames(Collection<OtherName> items) {
    if (this.otherNames == null) {
      return (A) this;
    }
    for (OtherName item : items) {
        OtherNameBuilder builder = new OtherNameBuilder(item);
        _visitables.get("otherNames").remove(builder);
        this.otherNames.remove(builder);
    }
    return (A) this;
  }
  
  public A removeAllFromUris(Collection<String> items) {
    if (this.uris == null) {
      return (A) this;
    }
    for (String item : items) {
      this.uris.remove(item);
    }
    return (A) this;
  }
  
  public A removeAllFromUsages(Collection<String> items) {
    if (this.usages == null) {
      return (A) this;
    }
    for (String item : items) {
      this.usages.remove(item);
    }
    return (A) this;
  }
  
  public A removeFromAdditionalOutputFormats(CertificateAdditionalOutputFormat... items) {
    if (this.additionalOutputFormats == null) {
      return (A) this;
    }
    for (CertificateAdditionalOutputFormat item : items) {
        CertificateAdditionalOutputFormatBuilder builder = new CertificateAdditionalOutputFormatBuilder(item);
        _visitables.get("additionalOutputFormats").remove(builder);
        this.additionalOutputFormats.remove(builder);
    }
    return (A) this;
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
  
  public A removeFromDnsNames(String... items) {
    if (this.dnsNames == null) {
      return (A) this;
    }
    for (String item : items) {
      this.dnsNames.remove(item);
    }
    return (A) this;
  }
  
  public A removeFromEmailAddresses(String... items) {
    if (this.emailAddresses == null) {
      return (A) this;
    }
    for (String item : items) {
      this.emailAddresses.remove(item);
    }
    return (A) this;
  }
  
  public A removeFromIpAddresses(String... items) {
    if (this.ipAddresses == null) {
      return (A) this;
    }
    for (String item : items) {
      this.ipAddresses.remove(item);
    }
    return (A) this;
  }
  
  public A removeFromOtherNames(OtherName... items) {
    if (this.otherNames == null) {
      return (A) this;
    }
    for (OtherName item : items) {
        OtherNameBuilder builder = new OtherNameBuilder(item);
        _visitables.get("otherNames").remove(builder);
        this.otherNames.remove(builder);
    }
    return (A) this;
  }
  
  public A removeFromUris(String... items) {
    if (this.uris == null) {
      return (A) this;
    }
    for (String item : items) {
      this.uris.remove(item);
    }
    return (A) this;
  }
  
  public A removeFromUsages(String... items) {
    if (this.usages == null) {
      return (A) this;
    }
    for (String item : items) {
      this.usages.remove(item);
    }
    return (A) this;
  }
  
  public A removeMatchingFromAdditionalOutputFormats(Predicate<CertificateAdditionalOutputFormatBuilder> predicate) {
    if (additionalOutputFormats == null) {
      return (A) this;
    }
    Iterator<CertificateAdditionalOutputFormatBuilder> each = additionalOutputFormats.iterator();
    List visitables = _visitables.get("additionalOutputFormats");
    while (each.hasNext()) {
        CertificateAdditionalOutputFormatBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public A removeMatchingFromOtherNames(Predicate<OtherNameBuilder> predicate) {
    if (otherNames == null) {
      return (A) this;
    }
    Iterator<OtherNameBuilder> each = otherNames.iterator();
    List visitables = _visitables.get("otherNames");
    while (each.hasNext()) {
        OtherNameBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public AdditionalOutputFormatsNested<A> setNewAdditionalOutputFormatLike(int index,CertificateAdditionalOutputFormat item) {
    return new AdditionalOutputFormatsNested(index, item);
  }
  
  public OtherNamesNested<A> setNewOtherNameLike(int index,OtherName item) {
    return new OtherNamesNested(index, item);
  }
  
  public A setToAdditionalOutputFormats(int index,CertificateAdditionalOutputFormat item) {
    if (this.additionalOutputFormats == null) {
      this.additionalOutputFormats = new ArrayList();
    }
    CertificateAdditionalOutputFormatBuilder builder = new CertificateAdditionalOutputFormatBuilder(item);
    if (index < 0 || index >= additionalOutputFormats.size()) {
        _visitables.get("additionalOutputFormats").add(builder);
        additionalOutputFormats.add(builder);
    } else {
        _visitables.get("additionalOutputFormats").add(builder);
        additionalOutputFormats.set(index, builder);
    }
    return (A) this;
  }
  
  public A setToDnsNames(int index,String item) {
    if (this.dnsNames == null) {
      this.dnsNames = new ArrayList();
    }
    this.dnsNames.set(index, item);
    return (A) this;
  }
  
  public A setToEmailAddresses(int index,String item) {
    if (this.emailAddresses == null) {
      this.emailAddresses = new ArrayList();
    }
    this.emailAddresses.set(index, item);
    return (A) this;
  }
  
  public A setToIpAddresses(int index,String item) {
    if (this.ipAddresses == null) {
      this.ipAddresses = new ArrayList();
    }
    this.ipAddresses.set(index, item);
    return (A) this;
  }
  
  public A setToOtherNames(int index,OtherName item) {
    if (this.otherNames == null) {
      this.otherNames = new ArrayList();
    }
    OtherNameBuilder builder = new OtherNameBuilder(item);
    if (index < 0 || index >= otherNames.size()) {
        _visitables.get("otherNames").add(builder);
        otherNames.add(builder);
    } else {
        _visitables.get("otherNames").add(builder);
        otherNames.set(index, builder);
    }
    return (A) this;
  }
  
  public A setToUris(int index,String item) {
    if (this.uris == null) {
      this.uris = new ArrayList();
    }
    this.uris.set(index, item);
    return (A) this;
  }
  
  public A setToUsages(int index,String item) {
    if (this.usages == null) {
      this.usages = new ArrayList();
    }
    this.usages.set(index, item);
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(additionalOutputFormats == null) && !(additionalOutputFormats.isEmpty())) {
        sb.append("additionalOutputFormats:");
        sb.append(additionalOutputFormats);
        sb.append(",");
    }
    if (!(commonName == null)) {
        sb.append("commonName:");
        sb.append(commonName);
        sb.append(",");
    }
    if (!(dnsNames == null) && !(dnsNames.isEmpty())) {
        sb.append("dnsNames:");
        sb.append(dnsNames);
        sb.append(",");
    }
    if (!(duration == null)) {
        sb.append("duration:");
        sb.append(duration);
        sb.append(",");
    }
    if (!(emailAddresses == null) && !(emailAddresses.isEmpty())) {
        sb.append("emailAddresses:");
        sb.append(emailAddresses);
        sb.append(",");
    }
    if (!(encodeUsagesInRequest == null)) {
        sb.append("encodeUsagesInRequest:");
        sb.append(encodeUsagesInRequest);
        sb.append(",");
    }
    if (!(ipAddresses == null) && !(ipAddresses.isEmpty())) {
        sb.append("ipAddresses:");
        sb.append(ipAddresses);
        sb.append(",");
    }
    if (!(isCA == null)) {
        sb.append("isCA:");
        sb.append(isCA);
        sb.append(",");
    }
    if (!(issuerRef == null)) {
        sb.append("issuerRef:");
        sb.append(issuerRef);
        sb.append(",");
    }
    if (!(keystores == null)) {
        sb.append("keystores:");
        sb.append(keystores);
        sb.append(",");
    }
    if (!(literalSubject == null)) {
        sb.append("literalSubject:");
        sb.append(literalSubject);
        sb.append(",");
    }
    if (!(nameConstraints == null)) {
        sb.append("nameConstraints:");
        sb.append(nameConstraints);
        sb.append(",");
    }
    if (!(otherNames == null) && !(otherNames.isEmpty())) {
        sb.append("otherNames:");
        sb.append(otherNames);
        sb.append(",");
    }
    if (!(privateKey == null)) {
        sb.append("privateKey:");
        sb.append(privateKey);
        sb.append(",");
    }
    if (!(renewBefore == null)) {
        sb.append("renewBefore:");
        sb.append(renewBefore);
        sb.append(",");
    }
    if (!(renewBeforePercentage == null)) {
        sb.append("renewBeforePercentage:");
        sb.append(renewBeforePercentage);
        sb.append(",");
    }
    if (!(revisionHistoryLimit == null)) {
        sb.append("revisionHistoryLimit:");
        sb.append(revisionHistoryLimit);
        sb.append(",");
    }
    if (!(secretName == null)) {
        sb.append("secretName:");
        sb.append(secretName);
        sb.append(",");
    }
    if (!(secretTemplate == null)) {
        sb.append("secretTemplate:");
        sb.append(secretTemplate);
        sb.append(",");
    }
    if (!(signatureAlgorithm == null)) {
        sb.append("signatureAlgorithm:");
        sb.append(signatureAlgorithm);
        sb.append(",");
    }
    if (!(subject == null)) {
        sb.append("subject:");
        sb.append(subject);
        sb.append(",");
    }
    if (!(uris == null) && !(uris.isEmpty())) {
        sb.append("uris:");
        sb.append(uris);
        sb.append(",");
    }
    if (!(usages == null) && !(usages.isEmpty())) {
        sb.append("usages:");
        sb.append(usages);
        sb.append(",");
    }
    if (!(additionalProperties == null) && !(additionalProperties.isEmpty())) {
        sb.append("additionalProperties:");
        sb.append(additionalProperties);
    }
    sb.append("}");
    return sb.toString();
  }
  
  public A withAdditionalOutputFormats(List<CertificateAdditionalOutputFormat> additionalOutputFormats) {
    if (this.additionalOutputFormats != null) {
      this._visitables.get("additionalOutputFormats").clear();
    }
    if (additionalOutputFormats != null) {
        this.additionalOutputFormats = new ArrayList();
        for (CertificateAdditionalOutputFormat item : additionalOutputFormats) {
          this.addToAdditionalOutputFormats(item);
        }
    } else {
      this.additionalOutputFormats = null;
    }
    return (A) this;
  }
  
  public A withAdditionalOutputFormats(CertificateAdditionalOutputFormat... additionalOutputFormats) {
    if (this.additionalOutputFormats != null) {
        this.additionalOutputFormats.clear();
        _visitables.remove("additionalOutputFormats");
    }
    if (additionalOutputFormats != null) {
      for (CertificateAdditionalOutputFormat item : additionalOutputFormats) {
        this.addToAdditionalOutputFormats(item);
      }
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
  
  public A withCommonName(String commonName) {
    this.commonName = commonName;
    return (A) this;
  }
  
  public A withDnsNames(List<String> dnsNames) {
    if (dnsNames != null) {
        this.dnsNames = new ArrayList();
        for (String item : dnsNames) {
          this.addToDnsNames(item);
        }
    } else {
      this.dnsNames = null;
    }
    return (A) this;
  }
  
  public A withDnsNames(String... dnsNames) {
    if (this.dnsNames != null) {
        this.dnsNames.clear();
        _visitables.remove("dnsNames");
    }
    if (dnsNames != null) {
      for (String item : dnsNames) {
        this.addToDnsNames(item);
      }
    }
    return (A) this;
  }
  
  public A withDuration(Duration duration) {
    this.duration = duration;
    return (A) this;
  }
  
  public A withEmailAddresses(List<String> emailAddresses) {
    if (emailAddresses != null) {
        this.emailAddresses = new ArrayList();
        for (String item : emailAddresses) {
          this.addToEmailAddresses(item);
        }
    } else {
      this.emailAddresses = null;
    }
    return (A) this;
  }
  
  public A withEmailAddresses(String... emailAddresses) {
    if (this.emailAddresses != null) {
        this.emailAddresses.clear();
        _visitables.remove("emailAddresses");
    }
    if (emailAddresses != null) {
      for (String item : emailAddresses) {
        this.addToEmailAddresses(item);
      }
    }
    return (A) this;
  }
  
  public A withEncodeUsagesInRequest() {
    return withEncodeUsagesInRequest(true);
  }
  
  public A withEncodeUsagesInRequest(Boolean encodeUsagesInRequest) {
    this.encodeUsagesInRequest = encodeUsagesInRequest;
    return (A) this;
  }
  
  public A withIpAddresses(List<String> ipAddresses) {
    if (ipAddresses != null) {
        this.ipAddresses = new ArrayList();
        for (String item : ipAddresses) {
          this.addToIpAddresses(item);
        }
    } else {
      this.ipAddresses = null;
    }
    return (A) this;
  }
  
  public A withIpAddresses(String... ipAddresses) {
    if (this.ipAddresses != null) {
        this.ipAddresses.clear();
        _visitables.remove("ipAddresses");
    }
    if (ipAddresses != null) {
      for (String item : ipAddresses) {
        this.addToIpAddresses(item);
      }
    }
    return (A) this;
  }
  
  public A withIsCA() {
    return withIsCA(true);
  }
  
  public A withIsCA(Boolean isCA) {
    this.isCA = isCA;
    return (A) this;
  }
  
  public A withIssuerRef(IssuerReference issuerRef) {
    this._visitables.remove("issuerRef");
    if (issuerRef != null) {
        this.issuerRef = new IssuerReferenceBuilder(issuerRef);
        this._visitables.get("issuerRef").add(this.issuerRef);
    } else {
        this.issuerRef = null;
        this._visitables.get("issuerRef").remove(this.issuerRef);
    }
    return (A) this;
  }
  
  public A withKeystores(CertificateKeystores keystores) {
    this._visitables.remove("keystores");
    if (keystores != null) {
        this.keystores = new CertificateKeystoresBuilder(keystores);
        this._visitables.get("keystores").add(this.keystores);
    } else {
        this.keystores = null;
        this._visitables.get("keystores").remove(this.keystores);
    }
    return (A) this;
  }
  
  public A withLiteralSubject(String literalSubject) {
    this.literalSubject = literalSubject;
    return (A) this;
  }
  
  public A withNameConstraints(NameConstraints nameConstraints) {
    this._visitables.remove("nameConstraints");
    if (nameConstraints != null) {
        this.nameConstraints = new NameConstraintsBuilder(nameConstraints);
        this._visitables.get("nameConstraints").add(this.nameConstraints);
    } else {
        this.nameConstraints = null;
        this._visitables.get("nameConstraints").remove(this.nameConstraints);
    }
    return (A) this;
  }
  
  public IssuerRefNested<A> withNewIssuerRef() {
    return new IssuerRefNested(null);
  }
  
  public A withNewIssuerRef(String group,String kind,String name) {
    return (A) this.withIssuerRef(new IssuerReference(group, kind, name));
  }
  
  public IssuerRefNested<A> withNewIssuerRefLike(IssuerReference item) {
    return new IssuerRefNested(item);
  }
  
  public KeystoresNested<A> withNewKeystores() {
    return new KeystoresNested(null);
  }
  
  public KeystoresNested<A> withNewKeystoresLike(CertificateKeystores item) {
    return new KeystoresNested(item);
  }
  
  public NameConstraintsNested<A> withNewNameConstraints() {
    return new NameConstraintsNested(null);
  }
  
  public NameConstraintsNested<A> withNewNameConstraintsLike(NameConstraints item) {
    return new NameConstraintsNested(item);
  }
  
  public PrivateKeyNested<A> withNewPrivateKey() {
    return new PrivateKeyNested(null);
  }
  
  public A withNewPrivateKey(String algorithm,String encoding,String rotationPolicy,Integer size) {
    return (A) this.withPrivateKey(new CertificatePrivateKey(algorithm, encoding, rotationPolicy, size));
  }
  
  public PrivateKeyNested<A> withNewPrivateKeyLike(CertificatePrivateKey item) {
    return new PrivateKeyNested(item);
  }
  
  public SecretTemplateNested<A> withNewSecretTemplate() {
    return new SecretTemplateNested(null);
  }
  
  public SecretTemplateNested<A> withNewSecretTemplateLike(CertificateSecretTemplate item) {
    return new SecretTemplateNested(item);
  }
  
  public SubjectNested<A> withNewSubject() {
    return new SubjectNested(null);
  }
  
  public SubjectNested<A> withNewSubjectLike(X509Subject item) {
    return new SubjectNested(item);
  }
  
  public A withOtherNames(List<OtherName> otherNames) {
    if (this.otherNames != null) {
      this._visitables.get("otherNames").clear();
    }
    if (otherNames != null) {
        this.otherNames = new ArrayList();
        for (OtherName item : otherNames) {
          this.addToOtherNames(item);
        }
    } else {
      this.otherNames = null;
    }
    return (A) this;
  }
  
  public A withOtherNames(OtherName... otherNames) {
    if (this.otherNames != null) {
        this.otherNames.clear();
        _visitables.remove("otherNames");
    }
    if (otherNames != null) {
      for (OtherName item : otherNames) {
        this.addToOtherNames(item);
      }
    }
    return (A) this;
  }
  
  public A withPrivateKey(CertificatePrivateKey privateKey) {
    this._visitables.remove("privateKey");
    if (privateKey != null) {
        this.privateKey = new CertificatePrivateKeyBuilder(privateKey);
        this._visitables.get("privateKey").add(this.privateKey);
    } else {
        this.privateKey = null;
        this._visitables.get("privateKey").remove(this.privateKey);
    }
    return (A) this;
  }
  
  public A withRenewBefore(Duration renewBefore) {
    this.renewBefore = renewBefore;
    return (A) this;
  }
  
  public A withRenewBeforePercentage(Integer renewBeforePercentage) {
    this.renewBeforePercentage = renewBeforePercentage;
    return (A) this;
  }
  
  public A withRevisionHistoryLimit(Integer revisionHistoryLimit) {
    this.revisionHistoryLimit = revisionHistoryLimit;
    return (A) this;
  }
  
  public A withSecretName(String secretName) {
    this.secretName = secretName;
    return (A) this;
  }
  
  public A withSecretTemplate(CertificateSecretTemplate secretTemplate) {
    this._visitables.remove("secretTemplate");
    if (secretTemplate != null) {
        this.secretTemplate = new CertificateSecretTemplateBuilder(secretTemplate);
        this._visitables.get("secretTemplate").add(this.secretTemplate);
    } else {
        this.secretTemplate = null;
        this._visitables.get("secretTemplate").remove(this.secretTemplate);
    }
    return (A) this;
  }
  
  public A withSignatureAlgorithm(String signatureAlgorithm) {
    this.signatureAlgorithm = signatureAlgorithm;
    return (A) this;
  }
  
  public A withSubject(X509Subject subject) {
    this._visitables.remove("subject");
    if (subject != null) {
        this.subject = new X509SubjectBuilder(subject);
        this._visitables.get("subject").add(this.subject);
    } else {
        this.subject = null;
        this._visitables.get("subject").remove(this.subject);
    }
    return (A) this;
  }
  
  public A withUris(List<String> uris) {
    if (uris != null) {
        this.uris = new ArrayList();
        for (String item : uris) {
          this.addToUris(item);
        }
    } else {
      this.uris = null;
    }
    return (A) this;
  }
  
  public A withUris(String... uris) {
    if (this.uris != null) {
        this.uris.clear();
        _visitables.remove("uris");
    }
    if (uris != null) {
      for (String item : uris) {
        this.addToUris(item);
      }
    }
    return (A) this;
  }
  
  public A withUsages(List<String> usages) {
    if (usages != null) {
        this.usages = new ArrayList();
        for (String item : usages) {
          this.addToUsages(item);
        }
    } else {
      this.usages = null;
    }
    return (A) this;
  }
  
  public A withUsages(String... usages) {
    if (this.usages != null) {
        this.usages.clear();
        _visitables.remove("usages");
    }
    if (usages != null) {
      for (String item : usages) {
        this.addToUsages(item);
      }
    }
    return (A) this;
  }
  public class AdditionalOutputFormatsNested<N> extends CertificateAdditionalOutputFormatFluent<AdditionalOutputFormatsNested<N>> implements Nested<N>{
  
    CertificateAdditionalOutputFormatBuilder builder;
    int index;
  
    AdditionalOutputFormatsNested(int index,CertificateAdditionalOutputFormat item) {
      this.index = index;
      this.builder = new CertificateAdditionalOutputFormatBuilder(this, item);
    }
  
    public N and() {
      return (N) CertificateSpecFluent.this.setToAdditionalOutputFormats(index, builder.build());
    }
    
    public N endAdditionalOutputFormat() {
      return and();
    }
    
  }
  public class IssuerRefNested<N> extends IssuerReferenceFluent<IssuerRefNested<N>> implements Nested<N>{
  
    IssuerReferenceBuilder builder;
  
    IssuerRefNested(IssuerReference item) {
      this.builder = new IssuerReferenceBuilder(this, item);
    }
  
    public N and() {
      return (N) CertificateSpecFluent.this.withIssuerRef(builder.build());
    }
    
    public N endIssuerRef() {
      return and();
    }
    
  }
  public class KeystoresNested<N> extends CertificateKeystoresFluent<KeystoresNested<N>> implements Nested<N>{
  
    CertificateKeystoresBuilder builder;
  
    KeystoresNested(CertificateKeystores item) {
      this.builder = new CertificateKeystoresBuilder(this, item);
    }
  
    public N and() {
      return (N) CertificateSpecFluent.this.withKeystores(builder.build());
    }
    
    public N endKeystores() {
      return and();
    }
    
  }
  public class NameConstraintsNested<N> extends NameConstraintsFluent<NameConstraintsNested<N>> implements Nested<N>{
  
    NameConstraintsBuilder builder;
  
    NameConstraintsNested(NameConstraints item) {
      this.builder = new NameConstraintsBuilder(this, item);
    }
  
    public N and() {
      return (N) CertificateSpecFluent.this.withNameConstraints(builder.build());
    }
    
    public N endNameConstraints() {
      return and();
    }
    
  }
  public class OtherNamesNested<N> extends OtherNameFluent<OtherNamesNested<N>> implements Nested<N>{
  
    OtherNameBuilder builder;
    int index;
  
    OtherNamesNested(int index,OtherName item) {
      this.index = index;
      this.builder = new OtherNameBuilder(this, item);
    }
  
    public N and() {
      return (N) CertificateSpecFluent.this.setToOtherNames(index, builder.build());
    }
    
    public N endOtherName() {
      return and();
    }
    
  }
  public class PrivateKeyNested<N> extends CertificatePrivateKeyFluent<PrivateKeyNested<N>> implements Nested<N>{
  
    CertificatePrivateKeyBuilder builder;
  
    PrivateKeyNested(CertificatePrivateKey item) {
      this.builder = new CertificatePrivateKeyBuilder(this, item);
    }
  
    public N and() {
      return (N) CertificateSpecFluent.this.withPrivateKey(builder.build());
    }
    
    public N endPrivateKey() {
      return and();
    }
    
  }
  public class SecretTemplateNested<N> extends CertificateSecretTemplateFluent<SecretTemplateNested<N>> implements Nested<N>{
  
    CertificateSecretTemplateBuilder builder;
  
    SecretTemplateNested(CertificateSecretTemplate item) {
      this.builder = new CertificateSecretTemplateBuilder(this, item);
    }
  
    public N and() {
      return (N) CertificateSpecFluent.this.withSecretTemplate(builder.build());
    }
    
    public N endSecretTemplate() {
      return and();
    }
    
  }
  public class SubjectNested<N> extends X509SubjectFluent<SubjectNested<N>> implements Nested<N>{
  
    X509SubjectBuilder builder;
  
    SubjectNested(X509Subject item) {
      this.builder = new X509SubjectBuilder(this, item);
    }
  
    public N and() {
      return (N) CertificateSpecFluent.this.withSubject(builder.build());
    }
    
    public N endSubject() {
      return and();
    }
    
  }
}