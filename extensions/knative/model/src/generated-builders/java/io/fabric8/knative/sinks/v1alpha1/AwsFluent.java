package io.fabric8.knative.sinks.v1alpha1;

import io.fabric8.knative.eventing.pkg.apis.common.integration.v1alpha1.AWSS3;
import io.fabric8.knative.eventing.pkg.apis.common.integration.v1alpha1.AWSS3Builder;
import io.fabric8.knative.eventing.pkg.apis.common.integration.v1alpha1.AWSS3Fluent;
import io.fabric8.knative.eventing.pkg.apis.common.integration.v1alpha1.AWSSNS;
import io.fabric8.knative.eventing.pkg.apis.common.integration.v1alpha1.AWSSNSBuilder;
import io.fabric8.knative.eventing.pkg.apis.common.integration.v1alpha1.AWSSNSFluent;
import io.fabric8.knative.eventing.pkg.apis.common.integration.v1alpha1.AWSSQS;
import io.fabric8.knative.eventing.pkg.apis.common.integration.v1alpha1.AWSSQSBuilder;
import io.fabric8.knative.eventing.pkg.apis.common.integration.v1alpha1.AWSSQSFluent;
import io.fabric8.knative.eventing.pkg.apis.common.integration.v1alpha1.Auth;
import io.fabric8.knative.eventing.pkg.apis.common.integration.v1alpha1.AuthBuilder;
import io.fabric8.knative.eventing.pkg.apis.common.integration.v1alpha1.AuthFluent;
import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
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
public class AwsFluent<A extends io.fabric8.knative.sinks.v1alpha1.AwsFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private AuthBuilder auth;
  private AWSS3Builder s3;
  private AWSSNSBuilder sns;
  private AWSSQSBuilder sqs;

  public AwsFluent() {
  }
  
  public AwsFluent(Aws instance) {
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
  
  public Auth buildAuth() {
    return this.auth != null ? this.auth.build() : null;
  }
  
  public AWSS3 buildS3() {
    return this.s3 != null ? this.s3.build() : null;
  }
  
  public AWSSNS buildSns() {
    return this.sns != null ? this.sns.build() : null;
  }
  
  public AWSSQS buildSqs() {
    return this.sqs != null ? this.sqs.build() : null;
  }
  
  protected void copyInstance(Aws instance) {
    instance = instance != null ? instance : new Aws();
    if (instance != null) {
        this.withAuth(instance.getAuth());
        this.withS3(instance.getS3());
        this.withSns(instance.getSns());
        this.withSqs(instance.getSqs());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public AuthNested<A> editAuth() {
    return this.withNewAuthLike(Optional.ofNullable(this.buildAuth()).orElse(null));
  }
  
  public AuthNested<A> editOrNewAuth() {
    return this.withNewAuthLike(Optional.ofNullable(this.buildAuth()).orElse(new AuthBuilder().build()));
  }
  
  public AuthNested<A> editOrNewAuthLike(Auth item) {
    return this.withNewAuthLike(Optional.ofNullable(this.buildAuth()).orElse(item));
  }
  
  public S3Nested<A> editOrNewS3() {
    return this.withNewS3Like(Optional.ofNullable(this.buildS3()).orElse(new AWSS3Builder().build()));
  }
  
  public S3Nested<A> editOrNewS3Like(AWSS3 item) {
    return this.withNewS3Like(Optional.ofNullable(this.buildS3()).orElse(item));
  }
  
  public SnsNested<A> editOrNewSns() {
    return this.withNewSnsLike(Optional.ofNullable(this.buildSns()).orElse(new AWSSNSBuilder().build()));
  }
  
  public SnsNested<A> editOrNewSnsLike(AWSSNS item) {
    return this.withNewSnsLike(Optional.ofNullable(this.buildSns()).orElse(item));
  }
  
  public SqsNested<A> editOrNewSqs() {
    return this.withNewSqsLike(Optional.ofNullable(this.buildSqs()).orElse(new AWSSQSBuilder().build()));
  }
  
  public SqsNested<A> editOrNewSqsLike(AWSSQS item) {
    return this.withNewSqsLike(Optional.ofNullable(this.buildSqs()).orElse(item));
  }
  
  public S3Nested<A> editS3() {
    return this.withNewS3Like(Optional.ofNullable(this.buildS3()).orElse(null));
  }
  
  public SnsNested<A> editSns() {
    return this.withNewSnsLike(Optional.ofNullable(this.buildSns()).orElse(null));
  }
  
  public SqsNested<A> editSqs() {
    return this.withNewSqsLike(Optional.ofNullable(this.buildSqs()).orElse(null));
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
    AwsFluent that = (AwsFluent) o;
    if (!(Objects.equals(auth, that.auth))) {
      return false;
    }
    if (!(Objects.equals(s3, that.s3))) {
      return false;
    }
    if (!(Objects.equals(sns, that.sns))) {
      return false;
    }
    if (!(Objects.equals(sqs, that.sqs))) {
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
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasAuth() {
    return this.auth != null;
  }
  
  public boolean hasS3() {
    return this.s3 != null;
  }
  
  public boolean hasSns() {
    return this.sns != null;
  }
  
  public boolean hasSqs() {
    return this.sqs != null;
  }
  
  public int hashCode() {
    return Objects.hash(auth, s3, sns, sqs, additionalProperties);
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
    if (!(auth == null)) {
        sb.append("auth:");
        sb.append(auth);
        sb.append(",");
    }
    if (!(s3 == null)) {
        sb.append("s3:");
        sb.append(s3);
        sb.append(",");
    }
    if (!(sns == null)) {
        sb.append("sns:");
        sb.append(sns);
        sb.append(",");
    }
    if (!(sqs == null)) {
        sb.append("sqs:");
        sb.append(sqs);
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
  
  public A withAuth(Auth auth) {
    this._visitables.remove("auth");
    if (auth != null) {
        this.auth = new AuthBuilder(auth);
        this._visitables.get("auth").add(this.auth);
    } else {
        this.auth = null;
        this._visitables.get("auth").remove(this.auth);
    }
    return (A) this;
  }
  
  public AuthNested<A> withNewAuth() {
    return new AuthNested(null);
  }
  
  public AuthNested<A> withNewAuthLike(Auth item) {
    return new AuthNested(item);
  }
  
  public S3Nested<A> withNewS3() {
    return new S3Nested(null);
  }
  
  public S3Nested<A> withNewS3Like(AWSS3 item) {
    return new S3Nested(item);
  }
  
  public SnsNested<A> withNewSns() {
    return new SnsNested(null);
  }
  
  public A withNewSns(String arn,Boolean autoCreateTopic,Boolean overrideEndpoint,String region,String uriEndpointOverride) {
    return (A) this.withSns(new AWSSNS(arn, autoCreateTopic, overrideEndpoint, region, uriEndpointOverride));
  }
  
  public SnsNested<A> withNewSnsLike(AWSSNS item) {
    return new SnsNested(item);
  }
  
  public SqsNested<A> withNewSqs() {
    return new SqsNested(null);
  }
  
  public SqsNested<A> withNewSqsLike(AWSSQS item) {
    return new SqsNested(item);
  }
  
  public A withS3(AWSS3 s3) {
    this._visitables.remove("s3");
    if (s3 != null) {
        this.s3 = new AWSS3Builder(s3);
        this._visitables.get("s3").add(this.s3);
    } else {
        this.s3 = null;
        this._visitables.get("s3").remove(this.s3);
    }
    return (A) this;
  }
  
  public A withSns(AWSSNS sns) {
    this._visitables.remove("sns");
    if (sns != null) {
        this.sns = new AWSSNSBuilder(sns);
        this._visitables.get("sns").add(this.sns);
    } else {
        this.sns = null;
        this._visitables.get("sns").remove(this.sns);
    }
    return (A) this;
  }
  
  public A withSqs(AWSSQS sqs) {
    this._visitables.remove("sqs");
    if (sqs != null) {
        this.sqs = new AWSSQSBuilder(sqs);
        this._visitables.get("sqs").add(this.sqs);
    } else {
        this.sqs = null;
        this._visitables.get("sqs").remove(this.sqs);
    }
    return (A) this;
  }
  public class AuthNested<N> extends AuthFluent<AuthNested<N>> implements Nested<N>{
  
    AuthBuilder builder;
  
    AuthNested(Auth item) {
      this.builder = new AuthBuilder(this, item);
    }
  
    public N and() {
      return (N) AwsFluent.this.withAuth(builder.build());
    }
    
    public N endAuth() {
      return and();
    }
    
  }
  public class S3Nested<N> extends AWSS3Fluent<S3Nested<N>> implements Nested<N>{
  
    AWSS3Builder builder;
  
    S3Nested(AWSS3 item) {
      this.builder = new AWSS3Builder(this, item);
    }
  
    public N and() {
      return (N) AwsFluent.this.withS3(builder.build());
    }
    
    public N endS3() {
      return and();
    }
    
  }
  public class SnsNested<N> extends AWSSNSFluent<SnsNested<N>> implements Nested<N>{
  
    AWSSNSBuilder builder;
  
    SnsNested(AWSSNS item) {
      this.builder = new AWSSNSBuilder(this, item);
    }
  
    public N and() {
      return (N) AwsFluent.this.withSns(builder.build());
    }
    
    public N endSns() {
      return and();
    }
    
  }
  public class SqsNested<N> extends AWSSQSFluent<SqsNested<N>> implements Nested<N>{
  
    AWSSQSBuilder builder;
  
    SqsNested(AWSSQS item) {
      this.builder = new AWSSQSBuilder(this, item);
    }
  
    public N and() {
      return (N) AwsFluent.this.withSqs(builder.build());
    }
    
    public N endSqs() {
      return and();
    }
    
  }
}