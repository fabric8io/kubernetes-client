package io.fabric8.istio.api.api.security.v1beta1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import java.lang.Boolean;
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
import java.util.function.Predicate;

/**
 * Generated
 */
@SuppressWarnings("unchecked")
public class JWTRuleFluent<A extends io.fabric8.istio.api.api.security.v1beta1.JWTRuleFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private List<String> audiences = new ArrayList<String>();
  private Boolean forwardOriginalToken;
  private List<String> fromCookies = new ArrayList<String>();
  private ArrayList<JWTHeaderBuilder> fromHeaders = new ArrayList<JWTHeaderBuilder>();
  private List<String> fromParams = new ArrayList<String>();
  private String issuer;
  private String jwks;
  private String jwksUri;
  private ArrayList<ClaimToHeaderBuilder> outputClaimToHeaders = new ArrayList<ClaimToHeaderBuilder>();
  private String outputPayloadToHeader;
  private List<String> spaceDelimitedClaims = new ArrayList<String>();
  private String timeout;

  public JWTRuleFluent() {
  }
  
  public JWTRuleFluent(JWTRule instance) {
    this.copyInstance(instance);
  }

  public A addAllToAudiences(Collection<String> items) {
    if (this.audiences == null) {
      this.audiences = new ArrayList();
    }
    for (String item : items) {
      this.audiences.add(item);
    }
    return (A) this;
  }
  
  public A addAllToFromCookies(Collection<String> items) {
    if (this.fromCookies == null) {
      this.fromCookies = new ArrayList();
    }
    for (String item : items) {
      this.fromCookies.add(item);
    }
    return (A) this;
  }
  
  public A addAllToFromHeaders(Collection<JWTHeader> items) {
    if (this.fromHeaders == null) {
      this.fromHeaders = new ArrayList();
    }
    for (JWTHeader item : items) {
        JWTHeaderBuilder builder = new JWTHeaderBuilder(item);
        _visitables.get("fromHeaders").add(builder);
        this.fromHeaders.add(builder);
    }
    return (A) this;
  }
  
  public A addAllToFromParams(Collection<String> items) {
    if (this.fromParams == null) {
      this.fromParams = new ArrayList();
    }
    for (String item : items) {
      this.fromParams.add(item);
    }
    return (A) this;
  }
  
  public A addAllToOutputClaimToHeaders(Collection<ClaimToHeader> items) {
    if (this.outputClaimToHeaders == null) {
      this.outputClaimToHeaders = new ArrayList();
    }
    for (ClaimToHeader item : items) {
        ClaimToHeaderBuilder builder = new ClaimToHeaderBuilder(item);
        _visitables.get("outputClaimToHeaders").add(builder);
        this.outputClaimToHeaders.add(builder);
    }
    return (A) this;
  }
  
  public A addAllToSpaceDelimitedClaims(Collection<String> items) {
    if (this.spaceDelimitedClaims == null) {
      this.spaceDelimitedClaims = new ArrayList();
    }
    for (String item : items) {
      this.spaceDelimitedClaims.add(item);
    }
    return (A) this;
  }
  
  public FromHeadersNested<A> addNewFromHeader() {
    return new FromHeadersNested(-1, null);
  }
  
  public A addNewFromHeader(String name,String prefix) {
    return (A) this.addToFromHeaders(new JWTHeader(name, prefix));
  }
  
  public FromHeadersNested<A> addNewFromHeaderLike(JWTHeader item) {
    return new FromHeadersNested(-1, item);
  }
  
  public OutputClaimToHeadersNested<A> addNewOutputClaimToHeader() {
    return new OutputClaimToHeadersNested(-1, null);
  }
  
  public A addNewOutputClaimToHeader(String claim,String header) {
    return (A) this.addToOutputClaimToHeaders(new ClaimToHeader(claim, header));
  }
  
  public OutputClaimToHeadersNested<A> addNewOutputClaimToHeaderLike(ClaimToHeader item) {
    return new OutputClaimToHeadersNested(-1, item);
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
  
  public A addToAudiences(String... items) {
    if (this.audiences == null) {
      this.audiences = new ArrayList();
    }
    for (String item : items) {
      this.audiences.add(item);
    }
    return (A) this;
  }
  
  public A addToAudiences(int index,String item) {
    if (this.audiences == null) {
      this.audiences = new ArrayList();
    }
    this.audiences.add(index, item);
    return (A) this;
  }
  
  public A addToFromCookies(String... items) {
    if (this.fromCookies == null) {
      this.fromCookies = new ArrayList();
    }
    for (String item : items) {
      this.fromCookies.add(item);
    }
    return (A) this;
  }
  
  public A addToFromCookies(int index,String item) {
    if (this.fromCookies == null) {
      this.fromCookies = new ArrayList();
    }
    this.fromCookies.add(index, item);
    return (A) this;
  }
  
  public A addToFromHeaders(JWTHeader... items) {
    if (this.fromHeaders == null) {
      this.fromHeaders = new ArrayList();
    }
    for (JWTHeader item : items) {
        JWTHeaderBuilder builder = new JWTHeaderBuilder(item);
        _visitables.get("fromHeaders").add(builder);
        this.fromHeaders.add(builder);
    }
    return (A) this;
  }
  
  public A addToFromHeaders(int index,JWTHeader item) {
    if (this.fromHeaders == null) {
      this.fromHeaders = new ArrayList();
    }
    JWTHeaderBuilder builder = new JWTHeaderBuilder(item);
    if (index < 0 || index >= fromHeaders.size()) {
        _visitables.get("fromHeaders").add(builder);
        fromHeaders.add(builder);
    } else {
        _visitables.get("fromHeaders").add(builder);
        fromHeaders.add(index, builder);
    }
    return (A) this;
  }
  
  public A addToFromParams(String... items) {
    if (this.fromParams == null) {
      this.fromParams = new ArrayList();
    }
    for (String item : items) {
      this.fromParams.add(item);
    }
    return (A) this;
  }
  
  public A addToFromParams(int index,String item) {
    if (this.fromParams == null) {
      this.fromParams = new ArrayList();
    }
    this.fromParams.add(index, item);
    return (A) this;
  }
  
  public A addToOutputClaimToHeaders(ClaimToHeader... items) {
    if (this.outputClaimToHeaders == null) {
      this.outputClaimToHeaders = new ArrayList();
    }
    for (ClaimToHeader item : items) {
        ClaimToHeaderBuilder builder = new ClaimToHeaderBuilder(item);
        _visitables.get("outputClaimToHeaders").add(builder);
        this.outputClaimToHeaders.add(builder);
    }
    return (A) this;
  }
  
  public A addToOutputClaimToHeaders(int index,ClaimToHeader item) {
    if (this.outputClaimToHeaders == null) {
      this.outputClaimToHeaders = new ArrayList();
    }
    ClaimToHeaderBuilder builder = new ClaimToHeaderBuilder(item);
    if (index < 0 || index >= outputClaimToHeaders.size()) {
        _visitables.get("outputClaimToHeaders").add(builder);
        outputClaimToHeaders.add(builder);
    } else {
        _visitables.get("outputClaimToHeaders").add(builder);
        outputClaimToHeaders.add(index, builder);
    }
    return (A) this;
  }
  
  public A addToSpaceDelimitedClaims(String... items) {
    if (this.spaceDelimitedClaims == null) {
      this.spaceDelimitedClaims = new ArrayList();
    }
    for (String item : items) {
      this.spaceDelimitedClaims.add(item);
    }
    return (A) this;
  }
  
  public A addToSpaceDelimitedClaims(int index,String item) {
    if (this.spaceDelimitedClaims == null) {
      this.spaceDelimitedClaims = new ArrayList();
    }
    this.spaceDelimitedClaims.add(index, item);
    return (A) this;
  }
  
  public JWTHeader buildFirstFromHeader() {
    return this.fromHeaders.get(0).build();
  }
  
  public ClaimToHeader buildFirstOutputClaimToHeader() {
    return this.outputClaimToHeaders.get(0).build();
  }
  
  public JWTHeader buildFromHeader(int index) {
    return this.fromHeaders.get(index).build();
  }
  
  public List<JWTHeader> buildFromHeaders() {
    return this.fromHeaders != null ? build(fromHeaders) : null;
  }
  
  public JWTHeader buildLastFromHeader() {
    return this.fromHeaders.get(fromHeaders.size() - 1).build();
  }
  
  public ClaimToHeader buildLastOutputClaimToHeader() {
    return this.outputClaimToHeaders.get(outputClaimToHeaders.size() - 1).build();
  }
  
  public JWTHeader buildMatchingFromHeader(Predicate<JWTHeaderBuilder> predicate) {
      for (JWTHeaderBuilder item : fromHeaders) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public ClaimToHeader buildMatchingOutputClaimToHeader(Predicate<ClaimToHeaderBuilder> predicate) {
      for (ClaimToHeaderBuilder item : outputClaimToHeaders) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public ClaimToHeader buildOutputClaimToHeader(int index) {
    return this.outputClaimToHeaders.get(index).build();
  }
  
  public List<ClaimToHeader> buildOutputClaimToHeaders() {
    return this.outputClaimToHeaders != null ? build(outputClaimToHeaders) : null;
  }
  
  protected void copyInstance(JWTRule instance) {
    instance = instance != null ? instance : new JWTRule();
    if (instance != null) {
        this.withAudiences(instance.getAudiences());
        this.withForwardOriginalToken(instance.getForwardOriginalToken());
        this.withFromCookies(instance.getFromCookies());
        this.withFromHeaders(instance.getFromHeaders());
        this.withFromParams(instance.getFromParams());
        this.withIssuer(instance.getIssuer());
        this.withJwks(instance.getJwks());
        this.withJwksUri(instance.getJwksUri());
        this.withOutputClaimToHeaders(instance.getOutputClaimToHeaders());
        this.withOutputPayloadToHeader(instance.getOutputPayloadToHeader());
        this.withSpaceDelimitedClaims(instance.getSpaceDelimitedClaims());
        this.withTimeout(instance.getTimeout());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public FromHeadersNested<A> editFirstFromHeader() {
    if (fromHeaders.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "fromHeaders"));
    }
    return this.setNewFromHeaderLike(0, this.buildFromHeader(0));
  }
  
  public OutputClaimToHeadersNested<A> editFirstOutputClaimToHeader() {
    if (outputClaimToHeaders.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "outputClaimToHeaders"));
    }
    return this.setNewOutputClaimToHeaderLike(0, this.buildOutputClaimToHeader(0));
  }
  
  public FromHeadersNested<A> editFromHeader(int index) {
    if (fromHeaders.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "fromHeaders"));
    }
    return this.setNewFromHeaderLike(index, this.buildFromHeader(index));
  }
  
  public FromHeadersNested<A> editLastFromHeader() {
    int index = fromHeaders.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "fromHeaders"));
    }
    return this.setNewFromHeaderLike(index, this.buildFromHeader(index));
  }
  
  public OutputClaimToHeadersNested<A> editLastOutputClaimToHeader() {
    int index = outputClaimToHeaders.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "outputClaimToHeaders"));
    }
    return this.setNewOutputClaimToHeaderLike(index, this.buildOutputClaimToHeader(index));
  }
  
  public FromHeadersNested<A> editMatchingFromHeader(Predicate<JWTHeaderBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < fromHeaders.size();i++) {
      if (predicate.test(fromHeaders.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "fromHeaders"));
    }
    return this.setNewFromHeaderLike(index, this.buildFromHeader(index));
  }
  
  public OutputClaimToHeadersNested<A> editMatchingOutputClaimToHeader(Predicate<ClaimToHeaderBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < outputClaimToHeaders.size();i++) {
      if (predicate.test(outputClaimToHeaders.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "outputClaimToHeaders"));
    }
    return this.setNewOutputClaimToHeaderLike(index, this.buildOutputClaimToHeader(index));
  }
  
  public OutputClaimToHeadersNested<A> editOutputClaimToHeader(int index) {
    if (outputClaimToHeaders.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "outputClaimToHeaders"));
    }
    return this.setNewOutputClaimToHeaderLike(index, this.buildOutputClaimToHeader(index));
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
    JWTRuleFluent that = (JWTRuleFluent) o;
    if (!(Objects.equals(audiences, that.audiences))) {
      return false;
    }
    if (!(Objects.equals(forwardOriginalToken, that.forwardOriginalToken))) {
      return false;
    }
    if (!(Objects.equals(fromCookies, that.fromCookies))) {
      return false;
    }
    if (!(Objects.equals(fromHeaders, that.fromHeaders))) {
      return false;
    }
    if (!(Objects.equals(fromParams, that.fromParams))) {
      return false;
    }
    if (!(Objects.equals(issuer, that.issuer))) {
      return false;
    }
    if (!(Objects.equals(jwks, that.jwks))) {
      return false;
    }
    if (!(Objects.equals(jwksUri, that.jwksUri))) {
      return false;
    }
    if (!(Objects.equals(outputClaimToHeaders, that.outputClaimToHeaders))) {
      return false;
    }
    if (!(Objects.equals(outputPayloadToHeader, that.outputPayloadToHeader))) {
      return false;
    }
    if (!(Objects.equals(spaceDelimitedClaims, that.spaceDelimitedClaims))) {
      return false;
    }
    if (!(Objects.equals(timeout, that.timeout))) {
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
  
  public String getAudience(int index) {
    return this.audiences.get(index);
  }
  
  public List<String> getAudiences() {
    return this.audiences;
  }
  
  public String getFirstAudience() {
    return this.audiences.get(0);
  }
  
  public String getFirstFromCooky() {
    return this.fromCookies.get(0);
  }
  
  public String getFirstFromParam() {
    return this.fromParams.get(0);
  }
  
  public String getFirstSpaceDelimitedClaim() {
    return this.spaceDelimitedClaims.get(0);
  }
  
  public Boolean getForwardOriginalToken() {
    return this.forwardOriginalToken;
  }
  
  public List<String> getFromCookies() {
    return this.fromCookies;
  }
  
  public String getFromCooky(int index) {
    return this.fromCookies.get(index);
  }
  
  public String getFromParam(int index) {
    return this.fromParams.get(index);
  }
  
  public List<String> getFromParams() {
    return this.fromParams;
  }
  
  public String getIssuer() {
    return this.issuer;
  }
  
  public String getJwks() {
    return this.jwks;
  }
  
  public String getJwksUri() {
    return this.jwksUri;
  }
  
  public String getLastAudience() {
    return this.audiences.get(audiences.size() - 1);
  }
  
  public String getLastFromCooky() {
    return this.fromCookies.get(fromCookies.size() - 1);
  }
  
  public String getLastFromParam() {
    return this.fromParams.get(fromParams.size() - 1);
  }
  
  public String getLastSpaceDelimitedClaim() {
    return this.spaceDelimitedClaims.get(spaceDelimitedClaims.size() - 1);
  }
  
  public String getMatchingAudience(Predicate<String> predicate) {
      for (String item : audiences) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public String getMatchingFromCooky(Predicate<String> predicate) {
      for (String item : fromCookies) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public String getMatchingFromParam(Predicate<String> predicate) {
      for (String item : fromParams) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public String getMatchingSpaceDelimitedClaim(Predicate<String> predicate) {
      for (String item : spaceDelimitedClaims) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public String getOutputPayloadToHeader() {
    return this.outputPayloadToHeader;
  }
  
  public String getSpaceDelimitedClaim(int index) {
    return this.spaceDelimitedClaims.get(index);
  }
  
  public List<String> getSpaceDelimitedClaims() {
    return this.spaceDelimitedClaims;
  }
  
  public String getTimeout() {
    return this.timeout;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasAudiences() {
    return this.audiences != null && !(this.audiences.isEmpty());
  }
  
  public boolean hasForwardOriginalToken() {
    return this.forwardOriginalToken != null;
  }
  
  public boolean hasFromCookies() {
    return this.fromCookies != null && !(this.fromCookies.isEmpty());
  }
  
  public boolean hasFromHeaders() {
    return this.fromHeaders != null && !(this.fromHeaders.isEmpty());
  }
  
  public boolean hasFromParams() {
    return this.fromParams != null && !(this.fromParams.isEmpty());
  }
  
  public boolean hasIssuer() {
    return this.issuer != null;
  }
  
  public boolean hasJwks() {
    return this.jwks != null;
  }
  
  public boolean hasJwksUri() {
    return this.jwksUri != null;
  }
  
  public boolean hasMatchingAudience(Predicate<String> predicate) {
      for (String item : audiences) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingFromCooky(Predicate<String> predicate) {
      for (String item : fromCookies) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingFromHeader(Predicate<JWTHeaderBuilder> predicate) {
      for (JWTHeaderBuilder item : fromHeaders) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingFromParam(Predicate<String> predicate) {
      for (String item : fromParams) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingOutputClaimToHeader(Predicate<ClaimToHeaderBuilder> predicate) {
      for (ClaimToHeaderBuilder item : outputClaimToHeaders) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingSpaceDelimitedClaim(Predicate<String> predicate) {
      for (String item : spaceDelimitedClaims) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasOutputClaimToHeaders() {
    return this.outputClaimToHeaders != null && !(this.outputClaimToHeaders.isEmpty());
  }
  
  public boolean hasOutputPayloadToHeader() {
    return this.outputPayloadToHeader != null;
  }
  
  public boolean hasSpaceDelimitedClaims() {
    return this.spaceDelimitedClaims != null && !(this.spaceDelimitedClaims.isEmpty());
  }
  
  public boolean hasTimeout() {
    return this.timeout != null;
  }
  
  public int hashCode() {
    return Objects.hash(audiences, forwardOriginalToken, fromCookies, fromHeaders, fromParams, issuer, jwks, jwksUri, outputClaimToHeaders, outputPayloadToHeader, spaceDelimitedClaims, timeout, additionalProperties);
  }
  
  public A removeAllFromAudiences(Collection<String> items) {
    if (this.audiences == null) {
      return (A) this;
    }
    for (String item : items) {
      this.audiences.remove(item);
    }
    return (A) this;
  }
  
  public A removeAllFromFromCookies(Collection<String> items) {
    if (this.fromCookies == null) {
      return (A) this;
    }
    for (String item : items) {
      this.fromCookies.remove(item);
    }
    return (A) this;
  }
  
  public A removeAllFromFromHeaders(Collection<JWTHeader> items) {
    if (this.fromHeaders == null) {
      return (A) this;
    }
    for (JWTHeader item : items) {
        JWTHeaderBuilder builder = new JWTHeaderBuilder(item);
        _visitables.get("fromHeaders").remove(builder);
        this.fromHeaders.remove(builder);
    }
    return (A) this;
  }
  
  public A removeAllFromFromParams(Collection<String> items) {
    if (this.fromParams == null) {
      return (A) this;
    }
    for (String item : items) {
      this.fromParams.remove(item);
    }
    return (A) this;
  }
  
  public A removeAllFromOutputClaimToHeaders(Collection<ClaimToHeader> items) {
    if (this.outputClaimToHeaders == null) {
      return (A) this;
    }
    for (ClaimToHeader item : items) {
        ClaimToHeaderBuilder builder = new ClaimToHeaderBuilder(item);
        _visitables.get("outputClaimToHeaders").remove(builder);
        this.outputClaimToHeaders.remove(builder);
    }
    return (A) this;
  }
  
  public A removeAllFromSpaceDelimitedClaims(Collection<String> items) {
    if (this.spaceDelimitedClaims == null) {
      return (A) this;
    }
    for (String item : items) {
      this.spaceDelimitedClaims.remove(item);
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
  
  public A removeFromAudiences(String... items) {
    if (this.audiences == null) {
      return (A) this;
    }
    for (String item : items) {
      this.audiences.remove(item);
    }
    return (A) this;
  }
  
  public A removeFromFromCookies(String... items) {
    if (this.fromCookies == null) {
      return (A) this;
    }
    for (String item : items) {
      this.fromCookies.remove(item);
    }
    return (A) this;
  }
  
  public A removeFromFromHeaders(JWTHeader... items) {
    if (this.fromHeaders == null) {
      return (A) this;
    }
    for (JWTHeader item : items) {
        JWTHeaderBuilder builder = new JWTHeaderBuilder(item);
        _visitables.get("fromHeaders").remove(builder);
        this.fromHeaders.remove(builder);
    }
    return (A) this;
  }
  
  public A removeFromFromParams(String... items) {
    if (this.fromParams == null) {
      return (A) this;
    }
    for (String item : items) {
      this.fromParams.remove(item);
    }
    return (A) this;
  }
  
  public A removeFromOutputClaimToHeaders(ClaimToHeader... items) {
    if (this.outputClaimToHeaders == null) {
      return (A) this;
    }
    for (ClaimToHeader item : items) {
        ClaimToHeaderBuilder builder = new ClaimToHeaderBuilder(item);
        _visitables.get("outputClaimToHeaders").remove(builder);
        this.outputClaimToHeaders.remove(builder);
    }
    return (A) this;
  }
  
  public A removeFromSpaceDelimitedClaims(String... items) {
    if (this.spaceDelimitedClaims == null) {
      return (A) this;
    }
    for (String item : items) {
      this.spaceDelimitedClaims.remove(item);
    }
    return (A) this;
  }
  
  public A removeMatchingFromFromHeaders(Predicate<JWTHeaderBuilder> predicate) {
    if (fromHeaders == null) {
      return (A) this;
    }
    Iterator<JWTHeaderBuilder> each = fromHeaders.iterator();
    List visitables = _visitables.get("fromHeaders");
    while (each.hasNext()) {
        JWTHeaderBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public A removeMatchingFromOutputClaimToHeaders(Predicate<ClaimToHeaderBuilder> predicate) {
    if (outputClaimToHeaders == null) {
      return (A) this;
    }
    Iterator<ClaimToHeaderBuilder> each = outputClaimToHeaders.iterator();
    List visitables = _visitables.get("outputClaimToHeaders");
    while (each.hasNext()) {
        ClaimToHeaderBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public FromHeadersNested<A> setNewFromHeaderLike(int index,JWTHeader item) {
    return new FromHeadersNested(index, item);
  }
  
  public OutputClaimToHeadersNested<A> setNewOutputClaimToHeaderLike(int index,ClaimToHeader item) {
    return new OutputClaimToHeadersNested(index, item);
  }
  
  public A setToAudiences(int index,String item) {
    if (this.audiences == null) {
      this.audiences = new ArrayList();
    }
    this.audiences.set(index, item);
    return (A) this;
  }
  
  public A setToFromCookies(int index,String item) {
    if (this.fromCookies == null) {
      this.fromCookies = new ArrayList();
    }
    this.fromCookies.set(index, item);
    return (A) this;
  }
  
  public A setToFromHeaders(int index,JWTHeader item) {
    if (this.fromHeaders == null) {
      this.fromHeaders = new ArrayList();
    }
    JWTHeaderBuilder builder = new JWTHeaderBuilder(item);
    if (index < 0 || index >= fromHeaders.size()) {
        _visitables.get("fromHeaders").add(builder);
        fromHeaders.add(builder);
    } else {
        _visitables.get("fromHeaders").add(builder);
        fromHeaders.set(index, builder);
    }
    return (A) this;
  }
  
  public A setToFromParams(int index,String item) {
    if (this.fromParams == null) {
      this.fromParams = new ArrayList();
    }
    this.fromParams.set(index, item);
    return (A) this;
  }
  
  public A setToOutputClaimToHeaders(int index,ClaimToHeader item) {
    if (this.outputClaimToHeaders == null) {
      this.outputClaimToHeaders = new ArrayList();
    }
    ClaimToHeaderBuilder builder = new ClaimToHeaderBuilder(item);
    if (index < 0 || index >= outputClaimToHeaders.size()) {
        _visitables.get("outputClaimToHeaders").add(builder);
        outputClaimToHeaders.add(builder);
    } else {
        _visitables.get("outputClaimToHeaders").add(builder);
        outputClaimToHeaders.set(index, builder);
    }
    return (A) this;
  }
  
  public A setToSpaceDelimitedClaims(int index,String item) {
    if (this.spaceDelimitedClaims == null) {
      this.spaceDelimitedClaims = new ArrayList();
    }
    this.spaceDelimitedClaims.set(index, item);
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(audiences == null) && !(audiences.isEmpty())) {
        sb.append("audiences:");
        sb.append(audiences);
        sb.append(",");
    }
    if (!(forwardOriginalToken == null)) {
        sb.append("forwardOriginalToken:");
        sb.append(forwardOriginalToken);
        sb.append(",");
    }
    if (!(fromCookies == null) && !(fromCookies.isEmpty())) {
        sb.append("fromCookies:");
        sb.append(fromCookies);
        sb.append(",");
    }
    if (!(fromHeaders == null) && !(fromHeaders.isEmpty())) {
        sb.append("fromHeaders:");
        sb.append(fromHeaders);
        sb.append(",");
    }
    if (!(fromParams == null) && !(fromParams.isEmpty())) {
        sb.append("fromParams:");
        sb.append(fromParams);
        sb.append(",");
    }
    if (!(issuer == null)) {
        sb.append("issuer:");
        sb.append(issuer);
        sb.append(",");
    }
    if (!(jwks == null)) {
        sb.append("jwks:");
        sb.append(jwks);
        sb.append(",");
    }
    if (!(jwksUri == null)) {
        sb.append("jwksUri:");
        sb.append(jwksUri);
        sb.append(",");
    }
    if (!(outputClaimToHeaders == null) && !(outputClaimToHeaders.isEmpty())) {
        sb.append("outputClaimToHeaders:");
        sb.append(outputClaimToHeaders);
        sb.append(",");
    }
    if (!(outputPayloadToHeader == null)) {
        sb.append("outputPayloadToHeader:");
        sb.append(outputPayloadToHeader);
        sb.append(",");
    }
    if (!(spaceDelimitedClaims == null) && !(spaceDelimitedClaims.isEmpty())) {
        sb.append("spaceDelimitedClaims:");
        sb.append(spaceDelimitedClaims);
        sb.append(",");
    }
    if (!(timeout == null)) {
        sb.append("timeout:");
        sb.append(timeout);
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
  
  public A withAudiences(List<String> audiences) {
    if (audiences != null) {
        this.audiences = new ArrayList();
        for (String item : audiences) {
          this.addToAudiences(item);
        }
    } else {
      this.audiences = null;
    }
    return (A) this;
  }
  
  public A withAudiences(String... audiences) {
    if (this.audiences != null) {
        this.audiences.clear();
        _visitables.remove("audiences");
    }
    if (audiences != null) {
      for (String item : audiences) {
        this.addToAudiences(item);
      }
    }
    return (A) this;
  }
  
  public A withForwardOriginalToken() {
    return withForwardOriginalToken(true);
  }
  
  public A withForwardOriginalToken(Boolean forwardOriginalToken) {
    this.forwardOriginalToken = forwardOriginalToken;
    return (A) this;
  }
  
  public A withFromCookies(List<String> fromCookies) {
    if (fromCookies != null) {
        this.fromCookies = new ArrayList();
        for (String item : fromCookies) {
          this.addToFromCookies(item);
        }
    } else {
      this.fromCookies = null;
    }
    return (A) this;
  }
  
  public A withFromCookies(String... fromCookies) {
    if (this.fromCookies != null) {
        this.fromCookies.clear();
        _visitables.remove("fromCookies");
    }
    if (fromCookies != null) {
      for (String item : fromCookies) {
        this.addToFromCookies(item);
      }
    }
    return (A) this;
  }
  
  public A withFromHeaders(List<JWTHeader> fromHeaders) {
    if (this.fromHeaders != null) {
      this._visitables.get("fromHeaders").clear();
    }
    if (fromHeaders != null) {
        this.fromHeaders = new ArrayList();
        for (JWTHeader item : fromHeaders) {
          this.addToFromHeaders(item);
        }
    } else {
      this.fromHeaders = null;
    }
    return (A) this;
  }
  
  public A withFromHeaders(JWTHeader... fromHeaders) {
    if (this.fromHeaders != null) {
        this.fromHeaders.clear();
        _visitables.remove("fromHeaders");
    }
    if (fromHeaders != null) {
      for (JWTHeader item : fromHeaders) {
        this.addToFromHeaders(item);
      }
    }
    return (A) this;
  }
  
  public A withFromParams(List<String> fromParams) {
    if (fromParams != null) {
        this.fromParams = new ArrayList();
        for (String item : fromParams) {
          this.addToFromParams(item);
        }
    } else {
      this.fromParams = null;
    }
    return (A) this;
  }
  
  public A withFromParams(String... fromParams) {
    if (this.fromParams != null) {
        this.fromParams.clear();
        _visitables.remove("fromParams");
    }
    if (fromParams != null) {
      for (String item : fromParams) {
        this.addToFromParams(item);
      }
    }
    return (A) this;
  }
  
  public A withIssuer(String issuer) {
    this.issuer = issuer;
    return (A) this;
  }
  
  public A withJwks(String jwks) {
    this.jwks = jwks;
    return (A) this;
  }
  
  public A withJwksUri(String jwksUri) {
    this.jwksUri = jwksUri;
    return (A) this;
  }
  
  public A withOutputClaimToHeaders(List<ClaimToHeader> outputClaimToHeaders) {
    if (this.outputClaimToHeaders != null) {
      this._visitables.get("outputClaimToHeaders").clear();
    }
    if (outputClaimToHeaders != null) {
        this.outputClaimToHeaders = new ArrayList();
        for (ClaimToHeader item : outputClaimToHeaders) {
          this.addToOutputClaimToHeaders(item);
        }
    } else {
      this.outputClaimToHeaders = null;
    }
    return (A) this;
  }
  
  public A withOutputClaimToHeaders(ClaimToHeader... outputClaimToHeaders) {
    if (this.outputClaimToHeaders != null) {
        this.outputClaimToHeaders.clear();
        _visitables.remove("outputClaimToHeaders");
    }
    if (outputClaimToHeaders != null) {
      for (ClaimToHeader item : outputClaimToHeaders) {
        this.addToOutputClaimToHeaders(item);
      }
    }
    return (A) this;
  }
  
  public A withOutputPayloadToHeader(String outputPayloadToHeader) {
    this.outputPayloadToHeader = outputPayloadToHeader;
    return (A) this;
  }
  
  public A withSpaceDelimitedClaims(List<String> spaceDelimitedClaims) {
    if (spaceDelimitedClaims != null) {
        this.spaceDelimitedClaims = new ArrayList();
        for (String item : spaceDelimitedClaims) {
          this.addToSpaceDelimitedClaims(item);
        }
    } else {
      this.spaceDelimitedClaims = null;
    }
    return (A) this;
  }
  
  public A withSpaceDelimitedClaims(String... spaceDelimitedClaims) {
    if (this.spaceDelimitedClaims != null) {
        this.spaceDelimitedClaims.clear();
        _visitables.remove("spaceDelimitedClaims");
    }
    if (spaceDelimitedClaims != null) {
      for (String item : spaceDelimitedClaims) {
        this.addToSpaceDelimitedClaims(item);
      }
    }
    return (A) this;
  }
  
  public A withTimeout(String timeout) {
    this.timeout = timeout;
    return (A) this;
  }
  public class FromHeadersNested<N> extends JWTHeaderFluent<FromHeadersNested<N>> implements Nested<N>{
  
    JWTHeaderBuilder builder;
    int index;
  
    FromHeadersNested(int index,JWTHeader item) {
      this.index = index;
      this.builder = new JWTHeaderBuilder(this, item);
    }
  
    public N and() {
      return (N) JWTRuleFluent.this.setToFromHeaders(index, builder.build());
    }
    
    public N endFromHeader() {
      return and();
    }
    
  }
  public class OutputClaimToHeadersNested<N> extends ClaimToHeaderFluent<OutputClaimToHeadersNested<N>> implements Nested<N>{
  
    ClaimToHeaderBuilder builder;
    int index;
  
    OutputClaimToHeadersNested(int index,ClaimToHeader item) {
      this.index = index;
      this.builder = new ClaimToHeaderBuilder(this, item);
    }
  
    public N and() {
      return (N) JWTRuleFluent.this.setToOutputClaimToHeaders(index, builder.build());
    }
    
    public N endOutputClaimToHeader() {
      return and();
    }
    
  }
}