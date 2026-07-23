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
public class AWSSQSFluent<A extends io.fabric8.knative.eventing.pkg.apis.common.integration.v1alpha1.AWSSQSFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String arn;
  private Boolean autoCreateQueue;
  private Integer delay;
  private Boolean deleteAfterRead;
  private Boolean greedy;
  private String host;
  private Integer maxMessagesPerPoll;
  private Boolean overrideEndpoint;
  private String protocol;
  private String queueURL;
  private String region;
  private String uriEndpointOverride;
  private Integer visibilityTimeout;
  private Integer waitTimeSeconds;

  public AWSSQSFluent() {
  }
  
  public AWSSQSFluent(AWSSQS instance) {
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
  
  protected void copyInstance(AWSSQS instance) {
    instance = instance != null ? instance : new AWSSQS();
    if (instance != null) {
        this.withArn(instance.getArn());
        this.withAutoCreateQueue(instance.getAutoCreateQueue());
        this.withDelay(instance.getDelay());
        this.withDeleteAfterRead(instance.getDeleteAfterRead());
        this.withGreedy(instance.getGreedy());
        this.withHost(instance.getHost());
        this.withMaxMessagesPerPoll(instance.getMaxMessagesPerPoll());
        this.withOverrideEndpoint(instance.getOverrideEndpoint());
        this.withProtocol(instance.getProtocol());
        this.withQueueURL(instance.getQueueURL());
        this.withRegion(instance.getRegion());
        this.withUriEndpointOverride(instance.getUriEndpointOverride());
        this.withVisibilityTimeout(instance.getVisibilityTimeout());
        this.withWaitTimeSeconds(instance.getWaitTimeSeconds());
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
    AWSSQSFluent that = (AWSSQSFluent) o;
    if (!(Objects.equals(arn, that.arn))) {
      return false;
    }
    if (!(Objects.equals(autoCreateQueue, that.autoCreateQueue))) {
      return false;
    }
    if (!(Objects.equals(delay, that.delay))) {
      return false;
    }
    if (!(Objects.equals(deleteAfterRead, that.deleteAfterRead))) {
      return false;
    }
    if (!(Objects.equals(greedy, that.greedy))) {
      return false;
    }
    if (!(Objects.equals(host, that.host))) {
      return false;
    }
    if (!(Objects.equals(maxMessagesPerPoll, that.maxMessagesPerPoll))) {
      return false;
    }
    if (!(Objects.equals(overrideEndpoint, that.overrideEndpoint))) {
      return false;
    }
    if (!(Objects.equals(protocol, that.protocol))) {
      return false;
    }
    if (!(Objects.equals(queueURL, that.queueURL))) {
      return false;
    }
    if (!(Objects.equals(region, that.region))) {
      return false;
    }
    if (!(Objects.equals(uriEndpointOverride, that.uriEndpointOverride))) {
      return false;
    }
    if (!(Objects.equals(visibilityTimeout, that.visibilityTimeout))) {
      return false;
    }
    if (!(Objects.equals(waitTimeSeconds, that.waitTimeSeconds))) {
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
  
  public Boolean getAutoCreateQueue() {
    return this.autoCreateQueue;
  }
  
  public Integer getDelay() {
    return this.delay;
  }
  
  public Boolean getDeleteAfterRead() {
    return this.deleteAfterRead;
  }
  
  public Boolean getGreedy() {
    return this.greedy;
  }
  
  public String getHost() {
    return this.host;
  }
  
  public Integer getMaxMessagesPerPoll() {
    return this.maxMessagesPerPoll;
  }
  
  public Boolean getOverrideEndpoint() {
    return this.overrideEndpoint;
  }
  
  public String getProtocol() {
    return this.protocol;
  }
  
  public String getQueueURL() {
    return this.queueURL;
  }
  
  public String getRegion() {
    return this.region;
  }
  
  public String getUriEndpointOverride() {
    return this.uriEndpointOverride;
  }
  
  public Integer getVisibilityTimeout() {
    return this.visibilityTimeout;
  }
  
  public Integer getWaitTimeSeconds() {
    return this.waitTimeSeconds;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasArn() {
    return this.arn != null;
  }
  
  public boolean hasAutoCreateQueue() {
    return this.autoCreateQueue != null;
  }
  
  public boolean hasDelay() {
    return this.delay != null;
  }
  
  public boolean hasDeleteAfterRead() {
    return this.deleteAfterRead != null;
  }
  
  public boolean hasGreedy() {
    return this.greedy != null;
  }
  
  public boolean hasHost() {
    return this.host != null;
  }
  
  public boolean hasMaxMessagesPerPoll() {
    return this.maxMessagesPerPoll != null;
  }
  
  public boolean hasOverrideEndpoint() {
    return this.overrideEndpoint != null;
  }
  
  public boolean hasProtocol() {
    return this.protocol != null;
  }
  
  public boolean hasQueueURL() {
    return this.queueURL != null;
  }
  
  public boolean hasRegion() {
    return this.region != null;
  }
  
  public boolean hasUriEndpointOverride() {
    return this.uriEndpointOverride != null;
  }
  
  public boolean hasVisibilityTimeout() {
    return this.visibilityTimeout != null;
  }
  
  public boolean hasWaitTimeSeconds() {
    return this.waitTimeSeconds != null;
  }
  
  public int hashCode() {
    return Objects.hash(arn, autoCreateQueue, delay, deleteAfterRead, greedy, host, maxMessagesPerPoll, overrideEndpoint, protocol, queueURL, region, uriEndpointOverride, visibilityTimeout, waitTimeSeconds, additionalProperties);
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
    if (!(autoCreateQueue == null)) {
        sb.append("autoCreateQueue:");
        sb.append(autoCreateQueue);
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
    if (!(greedy == null)) {
        sb.append("greedy:");
        sb.append(greedy);
        sb.append(",");
    }
    if (!(host == null)) {
        sb.append("host:");
        sb.append(host);
        sb.append(",");
    }
    if (!(maxMessagesPerPoll == null)) {
        sb.append("maxMessagesPerPoll:");
        sb.append(maxMessagesPerPoll);
        sb.append(",");
    }
    if (!(overrideEndpoint == null)) {
        sb.append("overrideEndpoint:");
        sb.append(overrideEndpoint);
        sb.append(",");
    }
    if (!(protocol == null)) {
        sb.append("protocol:");
        sb.append(protocol);
        sb.append(",");
    }
    if (!(queueURL == null)) {
        sb.append("queueURL:");
        sb.append(queueURL);
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
    if (!(visibilityTimeout == null)) {
        sb.append("visibilityTimeout:");
        sb.append(visibilityTimeout);
        sb.append(",");
    }
    if (!(waitTimeSeconds == null)) {
        sb.append("waitTimeSeconds:");
        sb.append(waitTimeSeconds);
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
  
  public A withAutoCreateQueue() {
    return withAutoCreateQueue(true);
  }
  
  public A withAutoCreateQueue(Boolean autoCreateQueue) {
    this.autoCreateQueue = autoCreateQueue;
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
  
  public A withGreedy() {
    return withGreedy(true);
  }
  
  public A withGreedy(Boolean greedy) {
    this.greedy = greedy;
    return (A) this;
  }
  
  public A withHost(String host) {
    this.host = host;
    return (A) this;
  }
  
  public A withMaxMessagesPerPoll(Integer maxMessagesPerPoll) {
    this.maxMessagesPerPoll = maxMessagesPerPoll;
    return (A) this;
  }
  
  public A withOverrideEndpoint() {
    return withOverrideEndpoint(true);
  }
  
  public A withOverrideEndpoint(Boolean overrideEndpoint) {
    this.overrideEndpoint = overrideEndpoint;
    return (A) this;
  }
  
  public A withProtocol(String protocol) {
    this.protocol = protocol;
    return (A) this;
  }
  
  public A withQueueURL(String queueURL) {
    this.queueURL = queueURL;
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
  
  public A withVisibilityTimeout(Integer visibilityTimeout) {
    this.visibilityTimeout = visibilityTimeout;
    return (A) this;
  }
  
  public A withWaitTimeSeconds(Integer waitTimeSeconds) {
    this.waitTimeSeconds = waitTimeSeconds;
    return (A) this;
  }
  
}