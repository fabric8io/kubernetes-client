package io.fabric8.openshift.api.model;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import io.fabric8.kubernetes.api.model.ObjectMeta;
import io.fabric8.kubernetes.api.model.ObjectMetaBuilder;
import io.fabric8.kubernetes.api.model.ObjectMetaFluent;
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
public class ImageSignatureFluent<A extends io.fabric8.openshift.api.model.ImageSignatureFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String apiVersion;
  private ArrayList<SignatureConditionBuilder> conditions = new ArrayList<SignatureConditionBuilder>();
  private String content;
  private String created;
  private String imageIdentity;
  private SignatureIssuerBuilder issuedBy;
  private SignatureSubjectBuilder issuedTo;
  private String kind;
  private ObjectMetaBuilder metadata;
  private Map<String,String> signedClaims;
  private String type;

  public ImageSignatureFluent() {
  }
  
  public ImageSignatureFluent(ImageSignature instance) {
    this.copyInstance(instance);
  }

  public A addAllToConditions(Collection<SignatureCondition> items) {
    if (this.conditions == null) {
      this.conditions = new ArrayList();
    }
    for (SignatureCondition item : items) {
        SignatureConditionBuilder builder = new SignatureConditionBuilder(item);
        _visitables.get("conditions").add(builder);
        this.conditions.add(builder);
    }
    return (A) this;
  }
  
  public ConditionsNested<A> addNewCondition() {
    return new ConditionsNested(-1, null);
  }
  
  public ConditionsNested<A> addNewConditionLike(SignatureCondition item) {
    return new ConditionsNested(-1, item);
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
  
  public A addToConditions(SignatureCondition... items) {
    if (this.conditions == null) {
      this.conditions = new ArrayList();
    }
    for (SignatureCondition item : items) {
        SignatureConditionBuilder builder = new SignatureConditionBuilder(item);
        _visitables.get("conditions").add(builder);
        this.conditions.add(builder);
    }
    return (A) this;
  }
  
  public A addToConditions(int index,SignatureCondition item) {
    if (this.conditions == null) {
      this.conditions = new ArrayList();
    }
    SignatureConditionBuilder builder = new SignatureConditionBuilder(item);
    if (index < 0 || index >= conditions.size()) {
        _visitables.get("conditions").add(builder);
        conditions.add(builder);
    } else {
        _visitables.get("conditions").add(builder);
        conditions.add(index, builder);
    }
    return (A) this;
  }
  
  public A addToSignedClaims(Map<String,String> map) {
    if (this.signedClaims == null && map != null) {
      this.signedClaims = new LinkedHashMap();
    }
    if (map != null) {
      this.signedClaims.putAll(map);
    }
    return (A) this;
  }
  
  public A addToSignedClaims(String key,String value) {
    if (this.signedClaims == null && key != null && value != null) {
      this.signedClaims = new LinkedHashMap();
    }
    if (key != null && value != null) {
      this.signedClaims.put(key, value);
    }
    return (A) this;
  }
  
  public SignatureCondition buildCondition(int index) {
    return this.conditions.get(index).build();
  }
  
  public List<SignatureCondition> buildConditions() {
    return this.conditions != null ? build(conditions) : null;
  }
  
  public SignatureCondition buildFirstCondition() {
    return this.conditions.get(0).build();
  }
  
  public SignatureIssuer buildIssuedBy() {
    return this.issuedBy != null ? this.issuedBy.build() : null;
  }
  
  public SignatureSubject buildIssuedTo() {
    return this.issuedTo != null ? this.issuedTo.build() : null;
  }
  
  public SignatureCondition buildLastCondition() {
    return this.conditions.get(conditions.size() - 1).build();
  }
  
  public SignatureCondition buildMatchingCondition(Predicate<SignatureConditionBuilder> predicate) {
      for (SignatureConditionBuilder item : conditions) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public ObjectMeta buildMetadata() {
    return this.metadata != null ? this.metadata.build() : null;
  }
  
  protected void copyInstance(ImageSignature instance) {
    instance = instance != null ? instance : new ImageSignature();
    if (instance != null) {
        this.withApiVersion(instance.getApiVersion());
        this.withConditions(instance.getConditions());
        this.withContent(instance.getContent());
        this.withCreated(instance.getCreated());
        this.withImageIdentity(instance.getImageIdentity());
        this.withIssuedBy(instance.getIssuedBy());
        this.withIssuedTo(instance.getIssuedTo());
        this.withKind(instance.getKind());
        this.withMetadata(instance.getMetadata());
        this.withSignedClaims(instance.getSignedClaims());
        this.withType(instance.getType());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public ConditionsNested<A> editCondition(int index) {
    if (conditions.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "conditions"));
    }
    return this.setNewConditionLike(index, this.buildCondition(index));
  }
  
  public ConditionsNested<A> editFirstCondition() {
    if (conditions.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "conditions"));
    }
    return this.setNewConditionLike(0, this.buildCondition(0));
  }
  
  public IssuedByNested<A> editIssuedBy() {
    return this.withNewIssuedByLike(Optional.ofNullable(this.buildIssuedBy()).orElse(null));
  }
  
  public IssuedToNested<A> editIssuedTo() {
    return this.withNewIssuedToLike(Optional.ofNullable(this.buildIssuedTo()).orElse(null));
  }
  
  public ConditionsNested<A> editLastCondition() {
    int index = conditions.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "conditions"));
    }
    return this.setNewConditionLike(index, this.buildCondition(index));
  }
  
  public ConditionsNested<A> editMatchingCondition(Predicate<SignatureConditionBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < conditions.size();i++) {
      if (predicate.test(conditions.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "conditions"));
    }
    return this.setNewConditionLike(index, this.buildCondition(index));
  }
  
  public MetadataNested<A> editMetadata() {
    return this.withNewMetadataLike(Optional.ofNullable(this.buildMetadata()).orElse(null));
  }
  
  public IssuedByNested<A> editOrNewIssuedBy() {
    return this.withNewIssuedByLike(Optional.ofNullable(this.buildIssuedBy()).orElse(new SignatureIssuerBuilder().build()));
  }
  
  public IssuedByNested<A> editOrNewIssuedByLike(SignatureIssuer item) {
    return this.withNewIssuedByLike(Optional.ofNullable(this.buildIssuedBy()).orElse(item));
  }
  
  public IssuedToNested<A> editOrNewIssuedTo() {
    return this.withNewIssuedToLike(Optional.ofNullable(this.buildIssuedTo()).orElse(new SignatureSubjectBuilder().build()));
  }
  
  public IssuedToNested<A> editOrNewIssuedToLike(SignatureSubject item) {
    return this.withNewIssuedToLike(Optional.ofNullable(this.buildIssuedTo()).orElse(item));
  }
  
  public MetadataNested<A> editOrNewMetadata() {
    return this.withNewMetadataLike(Optional.ofNullable(this.buildMetadata()).orElse(new ObjectMetaBuilder().build()));
  }
  
  public MetadataNested<A> editOrNewMetadataLike(ObjectMeta item) {
    return this.withNewMetadataLike(Optional.ofNullable(this.buildMetadata()).orElse(item));
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
    ImageSignatureFluent that = (ImageSignatureFluent) o;
    if (!(Objects.equals(apiVersion, that.apiVersion))) {
      return false;
    }
    if (!(Objects.equals(conditions, that.conditions))) {
      return false;
    }
    if (!(Objects.equals(content, that.content))) {
      return false;
    }
    if (!(Objects.equals(created, that.created))) {
      return false;
    }
    if (!(Objects.equals(imageIdentity, that.imageIdentity))) {
      return false;
    }
    if (!(Objects.equals(issuedBy, that.issuedBy))) {
      return false;
    }
    if (!(Objects.equals(issuedTo, that.issuedTo))) {
      return false;
    }
    if (!(Objects.equals(kind, that.kind))) {
      return false;
    }
    if (!(Objects.equals(metadata, that.metadata))) {
      return false;
    }
    if (!(Objects.equals(signedClaims, that.signedClaims))) {
      return false;
    }
    if (!(Objects.equals(type, that.type))) {
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
  
  public String getApiVersion() {
    return this.apiVersion;
  }
  
  public String getContent() {
    return this.content;
  }
  
  public String getCreated() {
    return this.created;
  }
  
  public String getImageIdentity() {
    return this.imageIdentity;
  }
  
  public String getKind() {
    return this.kind;
  }
  
  public Map<String,String> getSignedClaims() {
    return this.signedClaims;
  }
  
  public String getType() {
    return this.type;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasApiVersion() {
    return this.apiVersion != null;
  }
  
  public boolean hasConditions() {
    return this.conditions != null && !(this.conditions.isEmpty());
  }
  
  public boolean hasContent() {
    return this.content != null;
  }
  
  public boolean hasCreated() {
    return this.created != null;
  }
  
  public boolean hasImageIdentity() {
    return this.imageIdentity != null;
  }
  
  public boolean hasIssuedBy() {
    return this.issuedBy != null;
  }
  
  public boolean hasIssuedTo() {
    return this.issuedTo != null;
  }
  
  public boolean hasKind() {
    return this.kind != null;
  }
  
  public boolean hasMatchingCondition(Predicate<SignatureConditionBuilder> predicate) {
      for (SignatureConditionBuilder item : conditions) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMetadata() {
    return this.metadata != null;
  }
  
  public boolean hasSignedClaims() {
    return this.signedClaims != null;
  }
  
  public boolean hasType() {
    return this.type != null;
  }
  
  public int hashCode() {
    return Objects.hash(apiVersion, conditions, content, created, imageIdentity, issuedBy, issuedTo, kind, metadata, signedClaims, type, additionalProperties);
  }
  
  public A removeAllFromConditions(Collection<SignatureCondition> items) {
    if (this.conditions == null) {
      return (A) this;
    }
    for (SignatureCondition item : items) {
        SignatureConditionBuilder builder = new SignatureConditionBuilder(item);
        _visitables.get("conditions").remove(builder);
        this.conditions.remove(builder);
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
  
  public A removeFromConditions(SignatureCondition... items) {
    if (this.conditions == null) {
      return (A) this;
    }
    for (SignatureCondition item : items) {
        SignatureConditionBuilder builder = new SignatureConditionBuilder(item);
        _visitables.get("conditions").remove(builder);
        this.conditions.remove(builder);
    }
    return (A) this;
  }
  
  public A removeFromSignedClaims(String key) {
    if (this.signedClaims == null) {
      return (A) this;
    }
    if (key != null && this.signedClaims != null) {
      this.signedClaims.remove(key);
    }
    return (A) this;
  }
  
  public A removeFromSignedClaims(Map<String,String> map) {
    if (this.signedClaims == null) {
      return (A) this;
    }
    if (map != null) {
      for (Object key : map.keySet()) {
        if (this.signedClaims != null) {
          this.signedClaims.remove(key);
        }
      }
    }
    return (A) this;
  }
  
  public A removeMatchingFromConditions(Predicate<SignatureConditionBuilder> predicate) {
    if (conditions == null) {
      return (A) this;
    }
    Iterator<SignatureConditionBuilder> each = conditions.iterator();
    List visitables = _visitables.get("conditions");
    while (each.hasNext()) {
        SignatureConditionBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public ConditionsNested<A> setNewConditionLike(int index,SignatureCondition item) {
    return new ConditionsNested(index, item);
  }
  
  public A setToConditions(int index,SignatureCondition item) {
    if (this.conditions == null) {
      this.conditions = new ArrayList();
    }
    SignatureConditionBuilder builder = new SignatureConditionBuilder(item);
    if (index < 0 || index >= conditions.size()) {
        _visitables.get("conditions").add(builder);
        conditions.add(builder);
    } else {
        _visitables.get("conditions").add(builder);
        conditions.set(index, builder);
    }
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(apiVersion == null)) {
        sb.append("apiVersion:");
        sb.append(apiVersion);
        sb.append(",");
    }
    if (!(conditions == null) && !(conditions.isEmpty())) {
        sb.append("conditions:");
        sb.append(conditions);
        sb.append(",");
    }
    if (!(content == null)) {
        sb.append("content:");
        sb.append(content);
        sb.append(",");
    }
    if (!(created == null)) {
        sb.append("created:");
        sb.append(created);
        sb.append(",");
    }
    if (!(imageIdentity == null)) {
        sb.append("imageIdentity:");
        sb.append(imageIdentity);
        sb.append(",");
    }
    if (!(issuedBy == null)) {
        sb.append("issuedBy:");
        sb.append(issuedBy);
        sb.append(",");
    }
    if (!(issuedTo == null)) {
        sb.append("issuedTo:");
        sb.append(issuedTo);
        sb.append(",");
    }
    if (!(kind == null)) {
        sb.append("kind:");
        sb.append(kind);
        sb.append(",");
    }
    if (!(metadata == null)) {
        sb.append("metadata:");
        sb.append(metadata);
        sb.append(",");
    }
    if (!(signedClaims == null) && !(signedClaims.isEmpty())) {
        sb.append("signedClaims:");
        sb.append(signedClaims);
        sb.append(",");
    }
    if (!(type == null)) {
        sb.append("type:");
        sb.append(type);
        sb.append(",");
    }
    if (!(additionalProperties == null) && !(additionalProperties.isEmpty())) {
        sb.append("additionalProperties:");
        sb.append(additionalProperties);
    }
    sb.append("}");
    return sb.toString();
  }
  
  public <K,V>A withAdditionalProperties(Map<String,Object> additionalProperties) {
    if (additionalProperties == null) {
      this.additionalProperties = null;
    } else {
      this.additionalProperties = new LinkedHashMap(additionalProperties);
    }
    return (A) this;
  }
  
  public A withApiVersion(String apiVersion) {
    this.apiVersion = apiVersion;
    return (A) this;
  }
  
  public A withConditions(List<SignatureCondition> conditions) {
    if (this.conditions != null) {
      this._visitables.get("conditions").clear();
    }
    if (conditions != null) {
        this.conditions = new ArrayList();
        for (SignatureCondition item : conditions) {
          this.addToConditions(item);
        }
    } else {
      this.conditions = null;
    }
    return (A) this;
  }
  
  public A withConditions(SignatureCondition... conditions) {
    if (this.conditions != null) {
        this.conditions.clear();
        _visitables.remove("conditions");
    }
    if (conditions != null) {
      for (SignatureCondition item : conditions) {
        this.addToConditions(item);
      }
    }
    return (A) this;
  }
  
  public A withContent(String content) {
    this.content = content;
    return (A) this;
  }
  
  public A withCreated(String created) {
    this.created = created;
    return (A) this;
  }
  
  public A withImageIdentity(String imageIdentity) {
    this.imageIdentity = imageIdentity;
    return (A) this;
  }
  
  public A withIssuedBy(SignatureIssuer issuedBy) {
    this._visitables.remove("issuedBy");
    if (issuedBy != null) {
        this.issuedBy = new SignatureIssuerBuilder(issuedBy);
        this._visitables.get("issuedBy").add(this.issuedBy);
    } else {
        this.issuedBy = null;
        this._visitables.get("issuedBy").remove(this.issuedBy);
    }
    return (A) this;
  }
  
  public A withIssuedTo(SignatureSubject issuedTo) {
    this._visitables.remove("issuedTo");
    if (issuedTo != null) {
        this.issuedTo = new SignatureSubjectBuilder(issuedTo);
        this._visitables.get("issuedTo").add(this.issuedTo);
    } else {
        this.issuedTo = null;
        this._visitables.get("issuedTo").remove(this.issuedTo);
    }
    return (A) this;
  }
  
  public A withKind(String kind) {
    this.kind = kind;
    return (A) this;
  }
  
  public A withMetadata(ObjectMeta metadata) {
    this._visitables.remove("metadata");
    if (metadata != null) {
        this.metadata = new ObjectMetaBuilder(metadata);
        this._visitables.get("metadata").add(this.metadata);
    } else {
        this.metadata = null;
        this._visitables.get("metadata").remove(this.metadata);
    }
    return (A) this;
  }
  
  public IssuedByNested<A> withNewIssuedBy() {
    return new IssuedByNested(null);
  }
  
  public A withNewIssuedBy(String commonName,String organization) {
    return (A) this.withIssuedBy(new SignatureIssuer(commonName, organization));
  }
  
  public IssuedByNested<A> withNewIssuedByLike(SignatureIssuer item) {
    return new IssuedByNested(item);
  }
  
  public IssuedToNested<A> withNewIssuedTo() {
    return new IssuedToNested(null);
  }
  
  public A withNewIssuedTo(String commonName,String organization,String publicKeyID) {
    return (A) this.withIssuedTo(new SignatureSubject(commonName, organization, publicKeyID));
  }
  
  public IssuedToNested<A> withNewIssuedToLike(SignatureSubject item) {
    return new IssuedToNested(item);
  }
  
  public MetadataNested<A> withNewMetadata() {
    return new MetadataNested(null);
  }
  
  public MetadataNested<A> withNewMetadataLike(ObjectMeta item) {
    return new MetadataNested(item);
  }
  
  public <K,V>A withSignedClaims(Map<String,String> signedClaims) {
    if (signedClaims == null) {
      this.signedClaims = null;
    } else {
      this.signedClaims = new LinkedHashMap(signedClaims);
    }
    return (A) this;
  }
  
  public A withType(String type) {
    this.type = type;
    return (A) this;
  }
  public class ConditionsNested<N> extends SignatureConditionFluent<ConditionsNested<N>> implements Nested<N>{
  
    SignatureConditionBuilder builder;
    int index;
  
    ConditionsNested(int index,SignatureCondition item) {
      this.index = index;
      this.builder = new SignatureConditionBuilder(this, item);
    }
  
    public N and() {
      return (N) ImageSignatureFluent.this.setToConditions(index, builder.build());
    }
    
    public N endCondition() {
      return and();
    }
    
  }
  public class IssuedByNested<N> extends SignatureIssuerFluent<IssuedByNested<N>> implements Nested<N>{
  
    SignatureIssuerBuilder builder;
  
    IssuedByNested(SignatureIssuer item) {
      this.builder = new SignatureIssuerBuilder(this, item);
    }
  
    public N and() {
      return (N) ImageSignatureFluent.this.withIssuedBy(builder.build());
    }
    
    public N endIssuedBy() {
      return and();
    }
    
  }
  public class IssuedToNested<N> extends SignatureSubjectFluent<IssuedToNested<N>> implements Nested<N>{
  
    SignatureSubjectBuilder builder;
  
    IssuedToNested(SignatureSubject item) {
      this.builder = new SignatureSubjectBuilder(this, item);
    }
  
    public N and() {
      return (N) ImageSignatureFluent.this.withIssuedTo(builder.build());
    }
    
    public N endIssuedTo() {
      return and();
    }
    
  }
  public class MetadataNested<N> extends ObjectMetaFluent<MetadataNested<N>> implements Nested<N>{
  
    ObjectMetaBuilder builder;
  
    MetadataNested(ObjectMeta item) {
      this.builder = new ObjectMetaBuilder(this, item);
    }
  
    public N and() {
      return (N) ImageSignatureFluent.this.withMetadata(builder.build());
    }
    
    public N endMetadata() {
      return and();
    }
    
  }
}