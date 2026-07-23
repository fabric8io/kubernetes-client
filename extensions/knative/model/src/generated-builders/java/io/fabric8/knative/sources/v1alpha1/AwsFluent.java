package io.fabric8.knative.sources.v1alpha1;

import io.fabric8.knative.eventing.pkg.apis.common.integration.v1alpha1.AWSDDBStreams;
import io.fabric8.knative.eventing.pkg.apis.common.integration.v1alpha1.AWSDDBStreamsBuilder;
import io.fabric8.knative.eventing.pkg.apis.common.integration.v1alpha1.AWSDDBStreamsFluent;
import io.fabric8.knative.eventing.pkg.apis.common.integration.v1alpha1.AWSS3;
import io.fabric8.knative.eventing.pkg.apis.common.integration.v1alpha1.AWSS3Builder;
import io.fabric8.knative.eventing.pkg.apis.common.integration.v1alpha1.AWSS3Fluent;
import io.fabric8.knative.eventing.pkg.apis.common.integration.v1alpha1.AWSSQS;
import io.fabric8.knative.eventing.pkg.apis.common.integration.v1alpha1.AWSSQSBuilder;
import io.fabric8.knative.eventing.pkg.apis.common.integration.v1alpha1.AWSSQSFluent;
import io.fabric8.knative.eventing.pkg.apis.common.integration.v1alpha1.Auth;
import io.fabric8.knative.eventing.pkg.apis.common.integration.v1alpha1.AuthBuilder;
import io.fabric8.knative.eventing.pkg.apis.common.integration.v1alpha1.AuthFluent;
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
public class AwsFluent<A extends io.fabric8.knative.sources.v1alpha1.AwsFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private AuthBuilder auth;
  private AWSDDBStreamsBuilder ddbStreams;
  private AWSS3Builder s3;
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
  
  public AWSDDBStreams buildDdbStreams() {
    return this.ddbStreams != null ? this.ddbStreams.build() : null;
  }
  
  public AWSS3 buildS3() {
    return this.s3 != null ? this.s3.build() : null;
  }
  
  public AWSSQS buildSqs() {
    return this.sqs != null ? this.sqs.build() : null;
  }
  
  protected void copyInstance(Aws instance) {
    instance = instance != null ? instance : new Aws();
    if (instance != null) {
        this.withAuth(instance.getAuth());
        this.withDdbStreams(instance.getDdbStreams());
        this.withS3(instance.getS3());
        this.withSqs(instance.getSqs());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public AuthNested<A> editAuth() {
    return this.withNewAuthLike(Optional.ofNullable(this.buildAuth()).orElse(null));
  }
  
  public DdbStreamsNested<A> editDdbStreams() {
    return this.withNewDdbStreamsLike(Optional.ofNullable(this.buildDdbStreams()).orElse(null));
  }
  
  public AuthNested<A> editOrNewAuth() {
    return this.withNewAuthLike(Optional.ofNullable(this.buildAuth()).orElse(new AuthBuilder().build()));
  }
  
  public AuthNested<A> editOrNewAuthLike(Auth item) {
    return this.withNewAuthLike(Optional.ofNullable(this.buildAuth()).orElse(item));
  }
  
  public DdbStreamsNested<A> editOrNewDdbStreams() {
    return this.withNewDdbStreamsLike(Optional.ofNullable(this.buildDdbStreams()).orElse(new AWSDDBStreamsBuilder().build()));
  }
  
  public DdbStreamsNested<A> editOrNewDdbStreamsLike(AWSDDBStreams item) {
    return this.withNewDdbStreamsLike(Optional.ofNullable(this.buildDdbStreams()).orElse(item));
  }
  
  public S3Nested<A> editOrNewS3() {
    return this.withNewS3Like(Optional.ofNullable(this.buildS3()).orElse(new AWSS3Builder().build()));
  }
  
  public S3Nested<A> editOrNewS3Like(AWSS3 item) {
    return this.withNewS3Like(Optional.ofNullable(this.buildS3()).orElse(item));
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
    if (!(Objects.equals(ddbStreams, that.ddbStreams))) {
      return false;
    }
    if (!(Objects.equals(s3, that.s3))) {
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
  
  public boolean hasDdbStreams() {
    return this.ddbStreams != null;
  }
  
  public boolean hasS3() {
    return this.s3 != null;
  }
  
  public boolean hasSqs() {
    return this.sqs != null;
  }
  
  public int hashCode() {
    return Objects.hash(auth, ddbStreams, s3, sqs, additionalProperties);
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
    if (!(ddbStreams == null)) {
        sb.append("ddbStreams:");
        sb.append(ddbStreams);
        sb.append(",");
    }
    if (!(s3 == null)) {
        sb.append("s3:");
        sb.append(s3);
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
  
  public A withDdbStreams(AWSDDBStreams ddbStreams) {
    this._visitables.remove("ddbStreams");
    if (ddbStreams != null) {
        this.ddbStreams = new AWSDDBStreamsBuilder(ddbStreams);
        this._visitables.get("ddbStreams").add(this.ddbStreams);
    } else {
        this.ddbStreams = null;
        this._visitables.get("ddbStreams").remove(this.ddbStreams);
    }
    return (A) this;
  }
  
  public AuthNested<A> withNewAuth() {
    return new AuthNested(null);
  }
  
  public AuthNested<A> withNewAuthLike(Auth item) {
    return new AuthNested(item);
  }
  
  public DdbStreamsNested<A> withNewDdbStreams() {
    return new DdbStreamsNested(null);
  }
  
  public DdbStreamsNested<A> withNewDdbStreamsLike(AWSDDBStreams item) {
    return new DdbStreamsNested(item);
  }
  
  public S3Nested<A> withNewS3() {
    return new S3Nested(null);
  }
  
  public S3Nested<A> withNewS3Like(AWSS3 item) {
    return new S3Nested(item);
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
  public class DdbStreamsNested<N> extends AWSDDBStreamsFluent<DdbStreamsNested<N>> implements Nested<N>{
  
    AWSDDBStreamsBuilder builder;
  
    DdbStreamsNested(AWSDDBStreams item) {
      this.builder = new AWSDDBStreamsBuilder(this, item);
    }
  
    public N and() {
      return (N) AwsFluent.this.withDdbStreams(builder.build());
    }
    
    public N endDdbStreams() {
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