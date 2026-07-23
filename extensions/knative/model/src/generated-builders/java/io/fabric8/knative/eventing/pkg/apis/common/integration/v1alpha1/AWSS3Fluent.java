package io.fabric8.knative.eventing.pkg.apis.common.integration.v1alpha1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import java.lang.Boolean;
import java.lang.Integer;
import java.lang.Object;
import java.lang.String;
import java.lang.StringBuilder;
import java.lang.SuppressWarnings;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

/**
 * Generated
 */
@SuppressWarnings("unchecked")
public class AWSS3Fluent<A extends io.fabric8.knative.eventing.pkg.apis.common.integration.v1alpha1.AWSS3Fluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String arn;
  private Boolean autoCreateBucket;
  private Integer delay;
  private Boolean deleteAfterRead;
  private String destinationBucket;
  private String destinationBucketPrefix;
  private String destinationBucketSuffix;
  private Boolean forcePathStyle;
  private Boolean ignoreBody;
  private Integer maxMessagesPerPoll;
  private Boolean moveAfterRead;
  private Boolean overrideEndpoint;
  private String prefix;
  private String region;
  private String uriEndpointOverride;

  public AWSS3Fluent() {
  }
  
  public AWSS3Fluent(AWSS3 instance) {
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
  
  protected void copyInstance(AWSS3 instance) {
    instance = instance != null ? instance : new AWSS3();
    if (instance != null) {
        this.withArn(instance.getArn());
        this.withAutoCreateBucket(instance.getAutoCreateBucket());
        this.withDelay(instance.getDelay());
        this.withDeleteAfterRead(instance.getDeleteAfterRead());
        this.withDestinationBucket(instance.getDestinationBucket());
        this.withDestinationBucketPrefix(instance.getDestinationBucketPrefix());
        this.withDestinationBucketSuffix(instance.getDestinationBucketSuffix());
        this.withForcePathStyle(instance.getForcePathStyle());
        this.withIgnoreBody(instance.getIgnoreBody());
        this.withMaxMessagesPerPoll(instance.getMaxMessagesPerPoll());
        this.withMoveAfterRead(instance.getMoveAfterRead());
        this.withOverrideEndpoint(instance.getOverrideEndpoint());
        this.withPrefix(instance.getPrefix());
        this.withRegion(instance.getRegion());
        this.withUriEndpointOverride(instance.getUriEndpointOverride());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
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
    AWSS3Fluent that = (AWSS3Fluent) o;
    if (!(Objects.equals(arn, that.arn))) {
      return false;
    }
    if (!(Objects.equals(autoCreateBucket, that.autoCreateBucket))) {
      return false;
    }
    if (!(Objects.equals(delay, that.delay))) {
      return false;
    }
    if (!(Objects.equals(deleteAfterRead, that.deleteAfterRead))) {
      return false;
    }
    if (!(Objects.equals(destinationBucket, that.destinationBucket))) {
      return false;
    }
    if (!(Objects.equals(destinationBucketPrefix, that.destinationBucketPrefix))) {
      return false;
    }
    if (!(Objects.equals(destinationBucketSuffix, that.destinationBucketSuffix))) {
      return false;
    }
    if (!(Objects.equals(forcePathStyle, that.forcePathStyle))) {
      return false;
    }
    if (!(Objects.equals(ignoreBody, that.ignoreBody))) {
      return false;
    }
    if (!(Objects.equals(maxMessagesPerPoll, that.maxMessagesPerPoll))) {
      return false;
    }
    if (!(Objects.equals(moveAfterRead, that.moveAfterRead))) {
      return false;
    }
    if (!(Objects.equals(overrideEndpoint, that.overrideEndpoint))) {
      return false;
    }
    if (!(Objects.equals(prefix, that.prefix))) {
      return false;
    }
    if (!(Objects.equals(region, that.region))) {
      return false;
    }
    if (!(Objects.equals(uriEndpointOverride, that.uriEndpointOverride))) {
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
  
  public String getArn() {
    return this.arn;
  }
  
  public Boolean getAutoCreateBucket() {
    return this.autoCreateBucket;
  }
  
  public Integer getDelay() {
    return this.delay;
  }
  
  public Boolean getDeleteAfterRead() {
    return this.deleteAfterRead;
  }
  
  public String getDestinationBucket() {
    return this.destinationBucket;
  }
  
  public String getDestinationBucketPrefix() {
    return this.destinationBucketPrefix;
  }
  
  public String getDestinationBucketSuffix() {
    return this.destinationBucketSuffix;
  }
  
  public Boolean getForcePathStyle() {
    return this.forcePathStyle;
  }
  
  public Boolean getIgnoreBody() {
    return this.ignoreBody;
  }
  
  public Integer getMaxMessagesPerPoll() {
    return this.maxMessagesPerPoll;
  }
  
  public Boolean getMoveAfterRead() {
    return this.moveAfterRead;
  }
  
  public Boolean getOverrideEndpoint() {
    return this.overrideEndpoint;
  }
  
  public String getPrefix() {
    return this.prefix;
  }
  
  public String getRegion() {
    return this.region;
  }
  
  public String getUriEndpointOverride() {
    return this.uriEndpointOverride;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasArn() {
    return this.arn != null;
  }
  
  public boolean hasAutoCreateBucket() {
    return this.autoCreateBucket != null;
  }
  
  public boolean hasDelay() {
    return this.delay != null;
  }
  
  public boolean hasDeleteAfterRead() {
    return this.deleteAfterRead != null;
  }
  
  public boolean hasDestinationBucket() {
    return this.destinationBucket != null;
  }
  
  public boolean hasDestinationBucketPrefix() {
    return this.destinationBucketPrefix != null;
  }
  
  public boolean hasDestinationBucketSuffix() {
    return this.destinationBucketSuffix != null;
  }
  
  public boolean hasForcePathStyle() {
    return this.forcePathStyle != null;
  }
  
  public boolean hasIgnoreBody() {
    return this.ignoreBody != null;
  }
  
  public boolean hasMaxMessagesPerPoll() {
    return this.maxMessagesPerPoll != null;
  }
  
  public boolean hasMoveAfterRead() {
    return this.moveAfterRead != null;
  }
  
  public boolean hasOverrideEndpoint() {
    return this.overrideEndpoint != null;
  }
  
  public boolean hasPrefix() {
    return this.prefix != null;
  }
  
  public boolean hasRegion() {
    return this.region != null;
  }
  
  public boolean hasUriEndpointOverride() {
    return this.uriEndpointOverride != null;
  }
  
  public int hashCode() {
    return Objects.hash(arn, autoCreateBucket, delay, deleteAfterRead, destinationBucket, destinationBucketPrefix, destinationBucketSuffix, forcePathStyle, ignoreBody, maxMessagesPerPoll, moveAfterRead, overrideEndpoint, prefix, region, uriEndpointOverride, additionalProperties);
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
    if (!(arn == null)) {
        sb.append("arn:");
        sb.append(arn);
        sb.append(",");
    }
    if (!(autoCreateBucket == null)) {
        sb.append("autoCreateBucket:");
        sb.append(autoCreateBucket);
        sb.append(",");
    }
    if (!(delay == null)) {
        sb.append("delay:");
        sb.append(delay);
        sb.append(",");
    }
    if (!(deleteAfterRead == null)) {
        sb.append("deleteAfterRead:");
        sb.append(deleteAfterRead);
        sb.append(",");
    }
    if (!(destinationBucket == null)) {
        sb.append("destinationBucket:");
        sb.append(destinationBucket);
        sb.append(",");
    }
    if (!(destinationBucketPrefix == null)) {
        sb.append("destinationBucketPrefix:");
        sb.append(destinationBucketPrefix);
        sb.append(",");
    }
    if (!(destinationBucketSuffix == null)) {
        sb.append("destinationBucketSuffix:");
        sb.append(destinationBucketSuffix);
        sb.append(",");
    }
    if (!(forcePathStyle == null)) {
        sb.append("forcePathStyle:");
        sb.append(forcePathStyle);
        sb.append(",");
    }
    if (!(ignoreBody == null)) {
        sb.append("ignoreBody:");
        sb.append(ignoreBody);
        sb.append(",");
    }
    if (!(maxMessagesPerPoll == null)) {
        sb.append("maxMessagesPerPoll:");
        sb.append(maxMessagesPerPoll);
        sb.append(",");
    }
    if (!(moveAfterRead == null)) {
        sb.append("moveAfterRead:");
        sb.append(moveAfterRead);
        sb.append(",");
    }
    if (!(overrideEndpoint == null)) {
        sb.append("overrideEndpoint:");
        sb.append(overrideEndpoint);
        sb.append(",");
    }
    if (!(prefix == null)) {
        sb.append("prefix:");
        sb.append(prefix);
        sb.append(",");
    }
    if (!(region == null)) {
        sb.append("region:");
        sb.append(region);
        sb.append(",");
    }
    if (!(uriEndpointOverride == null)) {
        sb.append("uriEndpointOverride:");
        sb.append(uriEndpointOverride);
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
  
  public A withArn(String arn) {
    this.arn = arn;
    return (A) this;
  }
  
  public A withAutoCreateBucket() {
    return withAutoCreateBucket(true);
  }
  
  public A withAutoCreateBucket(Boolean autoCreateBucket) {
    this.autoCreateBucket = autoCreateBucket;
    return (A) this;
  }
  
  public A withDelay(Integer delay) {
    this.delay = delay;
    return (A) this;
  }
  
  public A withDeleteAfterRead() {
    return withDeleteAfterRead(true);
  }
  
  public A withDeleteAfterRead(Boolean deleteAfterRead) {
    this.deleteAfterRead = deleteAfterRead;
    return (A) this;
  }
  
  public A withDestinationBucket(String destinationBucket) {
    this.destinationBucket = destinationBucket;
    return (A) this;
  }
  
  public A withDestinationBucketPrefix(String destinationBucketPrefix) {
    this.destinationBucketPrefix = destinationBucketPrefix;
    return (A) this;
  }
  
  public A withDestinationBucketSuffix(String destinationBucketSuffix) {
    this.destinationBucketSuffix = destinationBucketSuffix;
    return (A) this;
  }
  
  public A withForcePathStyle() {
    return withForcePathStyle(true);
  }
  
  public A withForcePathStyle(Boolean forcePathStyle) {
    this.forcePathStyle = forcePathStyle;
    return (A) this;
  }
  
  public A withIgnoreBody() {
    return withIgnoreBody(true);
  }
  
  public A withIgnoreBody(Boolean ignoreBody) {
    this.ignoreBody = ignoreBody;
    return (A) this;
  }
  
  public A withMaxMessagesPerPoll(Integer maxMessagesPerPoll) {
    this.maxMessagesPerPoll = maxMessagesPerPoll;
    return (A) this;
  }
  
  public A withMoveAfterRead() {
    return withMoveAfterRead(true);
  }
  
  public A withMoveAfterRead(Boolean moveAfterRead) {
    this.moveAfterRead = moveAfterRead;
    return (A) this;
  }
  
  public A withOverrideEndpoint() {
    return withOverrideEndpoint(true);
  }
  
  public A withOverrideEndpoint(Boolean overrideEndpoint) {
    this.overrideEndpoint = overrideEndpoint;
    return (A) this;
  }
  
  public A withPrefix(String prefix) {
    this.prefix = prefix;
    return (A) this;
  }
  
  public A withRegion(String region) {
    this.region = region;
    return (A) this;
  }
  
  public A withUriEndpointOverride(String uriEndpointOverride) {
    this.uriEndpointOverride = uriEndpointOverride;
    return (A) this;
  }
  
}