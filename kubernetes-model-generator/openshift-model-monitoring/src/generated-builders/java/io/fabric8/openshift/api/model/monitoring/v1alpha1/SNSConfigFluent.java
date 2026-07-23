package io.fabric8.openshift.api.model.monitoring.v1alpha1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import io.fabric8.openshift.api.model.monitoring.v1.Sigv4;
import io.fabric8.openshift.api.model.monitoring.v1.Sigv4Builder;
import io.fabric8.openshift.api.model.monitoring.v1.Sigv4Fluent;
import java.lang.Boolean;
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
public class SNSConfigFluent<A extends io.fabric8.openshift.api.model.monitoring.v1alpha1.SNSConfigFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String apiURL;
  private Map<String,String> attributes;
  private HTTPConfigBuilder httpConfig;
  private String message;
  private String phoneNumber;
  private Boolean sendResolved;
  private Sigv4Builder sigv4;
  private String subject;
  private String targetARN;
  private String topicARN;

  public SNSConfigFluent() {
  }
  
  public SNSConfigFluent(SNSConfig instance) {
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
  
  public A addToAttributes(Map<String,String> map) {
    if (this.attributes == null && map != null) {
      this.attributes = new LinkedHashMap();
    }
    if (map != null) {
      this.attributes.putAll(map);
    }
    return (A) this;
  }
  
  public A addToAttributes(String key,String value) {
    if (this.attributes == null && key != null && value != null) {
      this.attributes = new LinkedHashMap();
    }
    if (key != null && value != null) {
      this.attributes.put(key, value);
    }
    return (A) this;
  }
  
  public HTTPConfig buildHttpConfig() {
    return this.httpConfig != null ? this.httpConfig.build() : null;
  }
  
  public Sigv4 buildSigv4() {
    return this.sigv4 != null ? this.sigv4.build() : null;
  }
  
  protected void copyInstance(SNSConfig instance) {
    instance = instance != null ? instance : new SNSConfig();
    if (instance != null) {
        this.withApiURL(instance.getApiURL());
        this.withAttributes(instance.getAttributes());
        this.withHttpConfig(instance.getHttpConfig());
        this.withMessage(instance.getMessage());
        this.withPhoneNumber(instance.getPhoneNumber());
        this.withSendResolved(instance.getSendResolved());
        this.withSigv4(instance.getSigv4());
        this.withSubject(instance.getSubject());
        this.withTargetARN(instance.getTargetARN());
        this.withTopicARN(instance.getTopicARN());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public HttpConfigNested<A> editHttpConfig() {
    return this.withNewHttpConfigLike(Optional.ofNullable(this.buildHttpConfig()).orElse(null));
  }
  
  public HttpConfigNested<A> editOrNewHttpConfig() {
    return this.withNewHttpConfigLike(Optional.ofNullable(this.buildHttpConfig()).orElse(new HTTPConfigBuilder().build()));
  }
  
  public HttpConfigNested<A> editOrNewHttpConfigLike(HTTPConfig item) {
    return this.withNewHttpConfigLike(Optional.ofNullable(this.buildHttpConfig()).orElse(item));
  }
  
  public Sigv4Nested<A> editOrNewSigv4() {
    return this.withNewSigv4Like(Optional.ofNullable(this.buildSigv4()).orElse(new Sigv4Builder().build()));
  }
  
  public Sigv4Nested<A> editOrNewSigv4Like(Sigv4 item) {
    return this.withNewSigv4Like(Optional.ofNullable(this.buildSigv4()).orElse(item));
  }
  
  public Sigv4Nested<A> editSigv4() {
    return this.withNewSigv4Like(Optional.ofNullable(this.buildSigv4()).orElse(null));
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
    SNSConfigFluent that = (SNSConfigFluent) o;
    if (!(Objects.equals(apiURL, that.apiURL))) {
      return false;
    }
    if (!(Objects.equals(attributes, that.attributes))) {
      return false;
    }
    if (!(Objects.equals(httpConfig, that.httpConfig))) {
      return false;
    }
    if (!(Objects.equals(message, that.message))) {
      return false;
    }
    if (!(Objects.equals(phoneNumber, that.phoneNumber))) {
      return false;
    }
    if (!(Objects.equals(sendResolved, that.sendResolved))) {
      return false;
    }
    if (!(Objects.equals(sigv4, that.sigv4))) {
      return false;
    }
    if (!(Objects.equals(subject, that.subject))) {
      return false;
    }
    if (!(Objects.equals(targetARN, that.targetARN))) {
      return false;
    }
    if (!(Objects.equals(topicARN, that.topicARN))) {
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
  
  public String getApiURL() {
    return this.apiURL;
  }
  
  public Map<String,String> getAttributes() {
    return this.attributes;
  }
  
  public String getMessage() {
    return this.message;
  }
  
  public String getPhoneNumber() {
    return this.phoneNumber;
  }
  
  public Boolean getSendResolved() {
    return this.sendResolved;
  }
  
  public String getSubject() {
    return this.subject;
  }
  
  public String getTargetARN() {
    return this.targetARN;
  }
  
  public String getTopicARN() {
    return this.topicARN;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasApiURL() {
    return this.apiURL != null;
  }
  
  public boolean hasAttributes() {
    return this.attributes != null;
  }
  
  public boolean hasHttpConfig() {
    return this.httpConfig != null;
  }
  
  public boolean hasMessage() {
    return this.message != null;
  }
  
  public boolean hasPhoneNumber() {
    return this.phoneNumber != null;
  }
  
  public boolean hasSendResolved() {
    return this.sendResolved != null;
  }
  
  public boolean hasSigv4() {
    return this.sigv4 != null;
  }
  
  public boolean hasSubject() {
    return this.subject != null;
  }
  
  public boolean hasTargetARN() {
    return this.targetARN != null;
  }
  
  public boolean hasTopicARN() {
    return this.topicARN != null;
  }
  
  public int hashCode() {
    return Objects.hash(apiURL, attributes, httpConfig, message, phoneNumber, sendResolved, sigv4, subject, targetARN, topicARN, additionalProperties);
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
  
  public A removeFromAttributes(String key) {
    if (this.attributes == null) {
      return (A) this;
    }
    if (key != null && this.attributes != null) {
      this.attributes.remove(key);
    }
    return (A) this;
  }
  
  public A removeFromAttributes(Map<String,String> map) {
    if (this.attributes == null) {
      return (A) this;
    }
    if (map != null) {
      for (Object key : map.keySet()) {
        if (this.attributes != null) {
          this.attributes.remove(key);
        }
      }
    }
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(apiURL == null)) {
        sb.append("apiURL:");
        sb.append(apiURL);
        sb.append(",");
    }
    if (!(attributes == null) && !(attributes.isEmpty())) {
        sb.append("attributes:");
        sb.append(attributes);
        sb.append(",");
    }
    if (!(httpConfig == null)) {
        sb.append("httpConfig:");
        sb.append(httpConfig);
        sb.append(",");
    }
    if (!(message == null)) {
        sb.append("message:");
        sb.append(message);
        sb.append(",");
    }
    if (!(phoneNumber == null)) {
        sb.append("phoneNumber:");
        sb.append(phoneNumber);
        sb.append(",");
    }
    if (!(sendResolved == null)) {
        sb.append("sendResolved:");
        sb.append(sendResolved);
        sb.append(",");
    }
    if (!(sigv4 == null)) {
        sb.append("sigv4:");
        sb.append(sigv4);
        sb.append(",");
    }
    if (!(subject == null)) {
        sb.append("subject:");
        sb.append(subject);
        sb.append(",");
    }
    if (!(targetARN == null)) {
        sb.append("targetARN:");
        sb.append(targetARN);
        sb.append(",");
    }
    if (!(topicARN == null)) {
        sb.append("topicARN:");
        sb.append(topicARN);
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
  
  public A withApiURL(String apiURL) {
    this.apiURL = apiURL;
    return (A) this;
  }
  
  public <K,V>A withAttributes(Map<String,String> attributes) {
    if (attributes == null) {
      this.attributes = null;
    } else {
      this.attributes = new LinkedHashMap(attributes);
    }
    return (A) this;
  }
  
  public A withHttpConfig(HTTPConfig httpConfig) {
    this._visitables.remove("httpConfig");
    if (httpConfig != null) {
        this.httpConfig = new HTTPConfigBuilder(httpConfig);
        this._visitables.get("httpConfig").add(this.httpConfig);
    } else {
        this.httpConfig = null;
        this._visitables.get("httpConfig").remove(this.httpConfig);
    }
    return (A) this;
  }
  
  public A withMessage(String message) {
    this.message = message;
    return (A) this;
  }
  
  public HttpConfigNested<A> withNewHttpConfig() {
    return new HttpConfigNested(null);
  }
  
  public HttpConfigNested<A> withNewHttpConfigLike(HTTPConfig item) {
    return new HttpConfigNested(item);
  }
  
  public Sigv4Nested<A> withNewSigv4() {
    return new Sigv4Nested(null);
  }
  
  public Sigv4Nested<A> withNewSigv4Like(Sigv4 item) {
    return new Sigv4Nested(item);
  }
  
  public A withPhoneNumber(String phoneNumber) {
    this.phoneNumber = phoneNumber;
    return (A) this;
  }
  
  public A withSendResolved() {
    return withSendResolved(true);
  }
  
  public A withSendResolved(Boolean sendResolved) {
    this.sendResolved = sendResolved;
    return (A) this;
  }
  
  public A withSigv4(Sigv4 sigv4) {
    this._visitables.remove("sigv4");
    if (sigv4 != null) {
        this.sigv4 = new Sigv4Builder(sigv4);
        this._visitables.get("sigv4").add(this.sigv4);
    } else {
        this.sigv4 = null;
        this._visitables.get("sigv4").remove(this.sigv4);
    }
    return (A) this;
  }
  
  public A withSubject(String subject) {
    this.subject = subject;
    return (A) this;
  }
  
  public A withTargetARN(String targetARN) {
    this.targetARN = targetARN;
    return (A) this;
  }
  
  public A withTopicARN(String topicARN) {
    this.topicARN = topicARN;
    return (A) this;
  }
  public class HttpConfigNested<N> extends HTTPConfigFluent<HttpConfigNested<N>> implements Nested<N>{
  
    HTTPConfigBuilder builder;
  
    HttpConfigNested(HTTPConfig item) {
      this.builder = new HTTPConfigBuilder(this, item);
    }
  
    public N and() {
      return (N) SNSConfigFluent.this.withHttpConfig(builder.build());
    }
    
    public N endHttpConfig() {
      return and();
    }
    
  }
  public class Sigv4Nested<N> extends Sigv4Fluent<Sigv4Nested<N>> implements Nested<N>{
  
    Sigv4Builder builder;
  
    Sigv4Nested(Sigv4 item) {
      this.builder = new Sigv4Builder(this, item);
    }
  
    public N and() {
      return (N) SNSConfigFluent.this.withSigv4(builder.build());
    }
    
    public N endSigv4() {
      return and();
    }
    
  }
}