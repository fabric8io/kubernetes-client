package io.fabric8.openclustermanagement.api.model.apps.v1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import io.fabric8.kubernetes.api.model.ConfigMap;
import io.fabric8.kubernetes.api.model.Secret;
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
public class SubscriberItemFluent<A extends io.fabric8.openclustermanagement.api.model.apps.v1.SubscriberItemFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private ChannelBuilder channel;
  private ConfigMap channelConfigMap;
  private Secret channelSecret;
  private ChannelBuilder secondaryChannel;
  private ConfigMap secondaryChannelConfigMap;
  private Secret secondaryChannelSecret;
  private SubscriptionBuilder subscription;
  private ConfigMap subscriptionConfigMap;

  public SubscriberItemFluent() {
  }
  
  public SubscriberItemFluent(SubscriberItem instance) {
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
  
  public Channel buildChannel() {
    return this.channel != null ? this.channel.build() : null;
  }
  
  public Channel buildSecondaryChannel() {
    return this.secondaryChannel != null ? this.secondaryChannel.build() : null;
  }
  
  public Subscription buildSubscription() {
    return this.subscription != null ? this.subscription.build() : null;
  }
  
  protected void copyInstance(SubscriberItem instance) {
    instance = instance != null ? instance : new SubscriberItem();
    if (instance != null) {
        this.withChannel(instance.getChannel());
        this.withChannelConfigMap(instance.getChannelConfigMap());
        this.withChannelSecret(instance.getChannelSecret());
        this.withSecondaryChannel(instance.getSecondaryChannel());
        this.withSecondaryChannelConfigMap(instance.getSecondaryChannelConfigMap());
        this.withSecondaryChannelSecret(instance.getSecondaryChannelSecret());
        this.withSubscription(instance.getSubscription());
        this.withSubscriptionConfigMap(instance.getSubscriptionConfigMap());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public ChannelNested<A> editChannel() {
    return this.withNewChannelLike(Optional.ofNullable(this.buildChannel()).orElse(null));
  }
  
  public ChannelNested<A> editOrNewChannel() {
    return this.withNewChannelLike(Optional.ofNullable(this.buildChannel()).orElse(new ChannelBuilder().build()));
  }
  
  public ChannelNested<A> editOrNewChannelLike(Channel item) {
    return this.withNewChannelLike(Optional.ofNullable(this.buildChannel()).orElse(item));
  }
  
  public SecondaryChannelNested<A> editOrNewSecondaryChannel() {
    return this.withNewSecondaryChannelLike(Optional.ofNullable(this.buildSecondaryChannel()).orElse(new ChannelBuilder().build()));
  }
  
  public SecondaryChannelNested<A> editOrNewSecondaryChannelLike(Channel item) {
    return this.withNewSecondaryChannelLike(Optional.ofNullable(this.buildSecondaryChannel()).orElse(item));
  }
  
  public SubscriptionNested<A> editOrNewSubscription() {
    return this.withNewSubscriptionLike(Optional.ofNullable(this.buildSubscription()).orElse(new SubscriptionBuilder().build()));
  }
  
  public SubscriptionNested<A> editOrNewSubscriptionLike(Subscription item) {
    return this.withNewSubscriptionLike(Optional.ofNullable(this.buildSubscription()).orElse(item));
  }
  
  public SecondaryChannelNested<A> editSecondaryChannel() {
    return this.withNewSecondaryChannelLike(Optional.ofNullable(this.buildSecondaryChannel()).orElse(null));
  }
  
  public SubscriptionNested<A> editSubscription() {
    return this.withNewSubscriptionLike(Optional.ofNullable(this.buildSubscription()).orElse(null));
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
    SubscriberItemFluent that = (SubscriberItemFluent) o;
    if (!(Objects.equals(channel, that.channel))) {
      return false;
    }
    if (!(Objects.equals(channelConfigMap, that.channelConfigMap))) {
      return false;
    }
    if (!(Objects.equals(channelSecret, that.channelSecret))) {
      return false;
    }
    if (!(Objects.equals(secondaryChannel, that.secondaryChannel))) {
      return false;
    }
    if (!(Objects.equals(secondaryChannelConfigMap, that.secondaryChannelConfigMap))) {
      return false;
    }
    if (!(Objects.equals(secondaryChannelSecret, that.secondaryChannelSecret))) {
      return false;
    }
    if (!(Objects.equals(subscription, that.subscription))) {
      return false;
    }
    if (!(Objects.equals(subscriptionConfigMap, that.subscriptionConfigMap))) {
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
  
  public ConfigMap getChannelConfigMap() {
    return this.channelConfigMap;
  }
  
  public Secret getChannelSecret() {
    return this.channelSecret;
  }
  
  public ConfigMap getSecondaryChannelConfigMap() {
    return this.secondaryChannelConfigMap;
  }
  
  public Secret getSecondaryChannelSecret() {
    return this.secondaryChannelSecret;
  }
  
  public ConfigMap getSubscriptionConfigMap() {
    return this.subscriptionConfigMap;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasChannel() {
    return this.channel != null;
  }
  
  public boolean hasChannelConfigMap() {
    return this.channelConfigMap != null;
  }
  
  public boolean hasChannelSecret() {
    return this.channelSecret != null;
  }
  
  public boolean hasSecondaryChannel() {
    return this.secondaryChannel != null;
  }
  
  public boolean hasSecondaryChannelConfigMap() {
    return this.secondaryChannelConfigMap != null;
  }
  
  public boolean hasSecondaryChannelSecret() {
    return this.secondaryChannelSecret != null;
  }
  
  public boolean hasSubscription() {
    return this.subscription != null;
  }
  
  public boolean hasSubscriptionConfigMap() {
    return this.subscriptionConfigMap != null;
  }
  
  public int hashCode() {
    return Objects.hash(channel, channelConfigMap, channelSecret, secondaryChannel, secondaryChannelConfigMap, secondaryChannelSecret, subscription, subscriptionConfigMap, additionalProperties);
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
    if (!(channel == null)) {
        sb.append("channel:");
        sb.append(channel);
        sb.append(",");
    }
    if (!(channelConfigMap == null)) {
        sb.append("channelConfigMap:");
        sb.append(channelConfigMap);
        sb.append(",");
    }
    if (!(channelSecret == null)) {
        sb.append("channelSecret:");
        sb.append(channelSecret);
        sb.append(",");
    }
    if (!(secondaryChannel == null)) {
        sb.append("secondaryChannel:");
        sb.append(secondaryChannel);
        sb.append(",");
    }
    if (!(secondaryChannelConfigMap == null)) {
        sb.append("secondaryChannelConfigMap:");
        sb.append(secondaryChannelConfigMap);
        sb.append(",");
    }
    if (!(secondaryChannelSecret == null)) {
        sb.append("secondaryChannelSecret:");
        sb.append(secondaryChannelSecret);
        sb.append(",");
    }
    if (!(subscription == null)) {
        sb.append("subscription:");
        sb.append(subscription);
        sb.append(",");
    }
    if (!(subscriptionConfigMap == null)) {
        sb.append("subscriptionConfigMap:");
        sb.append(subscriptionConfigMap);
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
  
  public A withChannel(Channel channel) {
    this._visitables.remove("channel");
    if (channel != null) {
        this.channel = new ChannelBuilder(channel);
        this._visitables.get("channel").add(this.channel);
    } else {
        this.channel = null;
        this._visitables.get("channel").remove(this.channel);
    }
    return (A) this;
  }
  
  public A withChannelConfigMap(ConfigMap channelConfigMap) {
    this.channelConfigMap = channelConfigMap;
    return (A) this;
  }
  
  public A withChannelSecret(Secret channelSecret) {
    this.channelSecret = channelSecret;
    return (A) this;
  }
  
  public ChannelNested<A> withNewChannel() {
    return new ChannelNested(null);
  }
  
  public ChannelNested<A> withNewChannelLike(Channel item) {
    return new ChannelNested(item);
  }
  
  public SecondaryChannelNested<A> withNewSecondaryChannel() {
    return new SecondaryChannelNested(null);
  }
  
  public SecondaryChannelNested<A> withNewSecondaryChannelLike(Channel item) {
    return new SecondaryChannelNested(item);
  }
  
  public SubscriptionNested<A> withNewSubscription() {
    return new SubscriptionNested(null);
  }
  
  public SubscriptionNested<A> withNewSubscriptionLike(Subscription item) {
    return new SubscriptionNested(item);
  }
  
  public A withSecondaryChannel(Channel secondaryChannel) {
    this._visitables.remove("secondaryChannel");
    if (secondaryChannel != null) {
        this.secondaryChannel = new ChannelBuilder(secondaryChannel);
        this._visitables.get("secondaryChannel").add(this.secondaryChannel);
    } else {
        this.secondaryChannel = null;
        this._visitables.get("secondaryChannel").remove(this.secondaryChannel);
    }
    return (A) this;
  }
  
  public A withSecondaryChannelConfigMap(ConfigMap secondaryChannelConfigMap) {
    this.secondaryChannelConfigMap = secondaryChannelConfigMap;
    return (A) this;
  }
  
  public A withSecondaryChannelSecret(Secret secondaryChannelSecret) {
    this.secondaryChannelSecret = secondaryChannelSecret;
    return (A) this;
  }
  
  public A withSubscription(Subscription subscription) {
    this._visitables.remove("subscription");
    if (subscription != null) {
        this.subscription = new SubscriptionBuilder(subscription);
        this._visitables.get("subscription").add(this.subscription);
    } else {
        this.subscription = null;
        this._visitables.get("subscription").remove(this.subscription);
    }
    return (A) this;
  }
  
  public A withSubscriptionConfigMap(ConfigMap subscriptionConfigMap) {
    this.subscriptionConfigMap = subscriptionConfigMap;
    return (A) this;
  }
  public class ChannelNested<N> extends ChannelFluent<ChannelNested<N>> implements Nested<N>{
  
    ChannelBuilder builder;
  
    ChannelNested(Channel item) {
      this.builder = new ChannelBuilder(this, item);
    }
  
    public N and() {
      return (N) SubscriberItemFluent.this.withChannel(builder.build());
    }
    
    public N endChannel() {
      return and();
    }
    
  }
  public class SecondaryChannelNested<N> extends ChannelFluent<SecondaryChannelNested<N>> implements Nested<N>{
  
    ChannelBuilder builder;
  
    SecondaryChannelNested(Channel item) {
      this.builder = new ChannelBuilder(this, item);
    }
  
    public N and() {
      return (N) SubscriberItemFluent.this.withSecondaryChannel(builder.build());
    }
    
    public N endSecondaryChannel() {
      return and();
    }
    
  }
  public class SubscriptionNested<N> extends SubscriptionFluent<SubscriptionNested<N>> implements Nested<N>{
  
    SubscriptionBuilder builder;
  
    SubscriptionNested(Subscription item) {
      this.builder = new SubscriptionBuilder(this, item);
    }
  
    public N and() {
      return (N) SubscriberItemFluent.this.withSubscription(builder.build());
    }
    
    public N endSubscription() {
      return and();
    }
    
  }
}