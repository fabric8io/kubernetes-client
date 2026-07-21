package io.fabric8.knative.sources.v1beta1;

import io.fabric8.knative.bindings.v1beta1.KafkaNetSpec;
import io.fabric8.knative.bindings.v1beta1.KafkaNetSpecBuilder;
import io.fabric8.knative.bindings.v1beta1.KafkaNetSpecFluent;
import io.fabric8.knative.duck.v1.CloudEventOverrides;
import io.fabric8.knative.duck.v1.CloudEventOverridesBuilder;
import io.fabric8.knative.duck.v1.CloudEventOverridesFluent;
import io.fabric8.knative.duck.v1.DeliverySpec;
import io.fabric8.knative.duck.v1.DeliverySpecBuilder;
import io.fabric8.knative.duck.v1.DeliverySpecFluent;
import io.fabric8.knative.duck.v1.Destination;
import io.fabric8.knative.duck.v1.DestinationBuilder;
import io.fabric8.knative.duck.v1.DestinationFluent;
import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import java.lang.Integer;
import java.lang.Object;
import java.lang.String;
import java.lang.StringBuilder;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collection;
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
public class KafkaSourceSpecFluent<A extends io.fabric8.knative.sources.v1beta1.KafkaSourceSpecFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private List<String> bootstrapServers = new ArrayList<String>();
  private CloudEventOverridesBuilder ceOverrides;
  private String consumerGroup;
  private Integer consumers;
  private DeliverySpecBuilder delivery;
  private String initialOffset;
  private KafkaNetSpecBuilder net;
  private String ordering;
  private DestinationBuilder sink;
  private List<String> topics = new ArrayList<String>();

  public KafkaSourceSpecFluent() {
  }
  
  public KafkaSourceSpecFluent(KafkaSourceSpec instance) {
    this.copyInstance(instance);
  }

  public A addAllToBootstrapServers(Collection<String> items) {
    if (this.bootstrapServers == null) {
      this.bootstrapServers = new ArrayList();
    }
    for (String item : items) {
      this.bootstrapServers.add(item);
    }
    return (A) this;
  }
  
  public A addAllToTopics(Collection<String> items) {
    if (this.topics == null) {
      this.topics = new ArrayList();
    }
    for (String item : items) {
      this.topics.add(item);
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
  
  public A addToBootstrapServers(String... items) {
    if (this.bootstrapServers == null) {
      this.bootstrapServers = new ArrayList();
    }
    for (String item : items) {
      this.bootstrapServers.add(item);
    }
    return (A) this;
  }
  
  public A addToBootstrapServers(int index,String item) {
    if (this.bootstrapServers == null) {
      this.bootstrapServers = new ArrayList();
    }
    this.bootstrapServers.add(index, item);
    return (A) this;
  }
  
  public A addToTopics(String... items) {
    if (this.topics == null) {
      this.topics = new ArrayList();
    }
    for (String item : items) {
      this.topics.add(item);
    }
    return (A) this;
  }
  
  public A addToTopics(int index,String item) {
    if (this.topics == null) {
      this.topics = new ArrayList();
    }
    this.topics.add(index, item);
    return (A) this;
  }
  
  public CloudEventOverrides buildCeOverrides() {
    return this.ceOverrides != null ? this.ceOverrides.build() : null;
  }
  
  public DeliverySpec buildDelivery() {
    return this.delivery != null ? this.delivery.build() : null;
  }
  
  public KafkaNetSpec buildNet() {
    return this.net != null ? this.net.build() : null;
  }
  
  public Destination buildSink() {
    return this.sink != null ? this.sink.build() : null;
  }
  
  protected void copyInstance(KafkaSourceSpec instance) {
    instance = instance != null ? instance : new KafkaSourceSpec();
    if (instance != null) {
        this.withBootstrapServers(instance.getBootstrapServers());
        this.withCeOverrides(instance.getCeOverrides());
        this.withConsumerGroup(instance.getConsumerGroup());
        this.withConsumers(instance.getConsumers());
        this.withDelivery(instance.getDelivery());
        this.withInitialOffset(instance.getInitialOffset());
        this.withNet(instance.getNet());
        this.withOrdering(instance.getOrdering());
        this.withSink(instance.getSink());
        this.withTopics(instance.getTopics());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public CeOverridesNested<A> editCeOverrides() {
    return this.withNewCeOverridesLike(Optional.ofNullable(this.buildCeOverrides()).orElse(null));
  }
  
  public DeliveryNested<A> editDelivery() {
    return this.withNewDeliveryLike(Optional.ofNullable(this.buildDelivery()).orElse(null));
  }
  
  public NetNested<A> editNet() {
    return this.withNewNetLike(Optional.ofNullable(this.buildNet()).orElse(null));
  }
  
  public CeOverridesNested<A> editOrNewCeOverrides() {
    return this.withNewCeOverridesLike(Optional.ofNullable(this.buildCeOverrides()).orElse(new CloudEventOverridesBuilder().build()));
  }
  
  public CeOverridesNested<A> editOrNewCeOverridesLike(CloudEventOverrides item) {
    return this.withNewCeOverridesLike(Optional.ofNullable(this.buildCeOverrides()).orElse(item));
  }
  
  public DeliveryNested<A> editOrNewDelivery() {
    return this.withNewDeliveryLike(Optional.ofNullable(this.buildDelivery()).orElse(new DeliverySpecBuilder().build()));
  }
  
  public DeliveryNested<A> editOrNewDeliveryLike(DeliverySpec item) {
    return this.withNewDeliveryLike(Optional.ofNullable(this.buildDelivery()).orElse(item));
  }
  
  public NetNested<A> editOrNewNet() {
    return this.withNewNetLike(Optional.ofNullable(this.buildNet()).orElse(new KafkaNetSpecBuilder().build()));
  }
  
  public NetNested<A> editOrNewNetLike(KafkaNetSpec item) {
    return this.withNewNetLike(Optional.ofNullable(this.buildNet()).orElse(item));
  }
  
  public SinkNested<A> editOrNewSink() {
    return this.withNewSinkLike(Optional.ofNullable(this.buildSink()).orElse(new DestinationBuilder().build()));
  }
  
  public SinkNested<A> editOrNewSinkLike(Destination item) {
    return this.withNewSinkLike(Optional.ofNullable(this.buildSink()).orElse(item));
  }
  
  public SinkNested<A> editSink() {
    return this.withNewSinkLike(Optional.ofNullable(this.buildSink()).orElse(null));
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
    KafkaSourceSpecFluent that = (KafkaSourceSpecFluent) o;
    if (!(Objects.equals(bootstrapServers, that.bootstrapServers))) {
      return false;
    }
    if (!(Objects.equals(ceOverrides, that.ceOverrides))) {
      return false;
    }
    if (!(Objects.equals(consumerGroup, that.consumerGroup))) {
      return false;
    }
    if (!(Objects.equals(consumers, that.consumers))) {
      return false;
    }
    if (!(Objects.equals(delivery, that.delivery))) {
      return false;
    }
    if (!(Objects.equals(initialOffset, that.initialOffset))) {
      return false;
    }
    if (!(Objects.equals(net, that.net))) {
      return false;
    }
    if (!(Objects.equals(ordering, that.ordering))) {
      return false;
    }
    if (!(Objects.equals(sink, that.sink))) {
      return false;
    }
    if (!(Objects.equals(topics, that.topics))) {
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
  
  public String getBootstrapServer(int index) {
    return this.bootstrapServers.get(index);
  }
  
  public List<String> getBootstrapServers() {
    return this.bootstrapServers;
  }
  
  public String getConsumerGroup() {
    return this.consumerGroup;
  }
  
  public Integer getConsumers() {
    return this.consumers;
  }
  
  public String getFirstBootstrapServer() {
    return this.bootstrapServers.get(0);
  }
  
  public String getFirstTopic() {
    return this.topics.get(0);
  }
  
  public String getInitialOffset() {
    return this.initialOffset;
  }
  
  public String getLastBootstrapServer() {
    return this.bootstrapServers.get(bootstrapServers.size() - 1);
  }
  
  public String getLastTopic() {
    return this.topics.get(topics.size() - 1);
  }
  
  public String getMatchingBootstrapServer(Predicate<String> predicate) {
      for (String item : bootstrapServers) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public String getMatchingTopic(Predicate<String> predicate) {
      for (String item : topics) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public String getOrdering() {
    return this.ordering;
  }
  
  public String getTopic(int index) {
    return this.topics.get(index);
  }
  
  public List<String> getTopics() {
    return this.topics;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasBootstrapServers() {
    return this.bootstrapServers != null && !(this.bootstrapServers.isEmpty());
  }
  
  public boolean hasCeOverrides() {
    return this.ceOverrides != null;
  }
  
  public boolean hasConsumerGroup() {
    return this.consumerGroup != null;
  }
  
  public boolean hasConsumers() {
    return this.consumers != null;
  }
  
  public boolean hasDelivery() {
    return this.delivery != null;
  }
  
  public boolean hasInitialOffset() {
    return this.initialOffset != null;
  }
  
  public boolean hasMatchingBootstrapServer(Predicate<String> predicate) {
      for (String item : bootstrapServers) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingTopic(Predicate<String> predicate) {
      for (String item : topics) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasNet() {
    return this.net != null;
  }
  
  public boolean hasOrdering() {
    return this.ordering != null;
  }
  
  public boolean hasSink() {
    return this.sink != null;
  }
  
  public boolean hasTopics() {
    return this.topics != null && !(this.topics.isEmpty());
  }
  
  public int hashCode() {
    return Objects.hash(bootstrapServers, ceOverrides, consumerGroup, consumers, delivery, initialOffset, net, ordering, sink, topics, additionalProperties);
  }
  
  public A removeAllFromBootstrapServers(Collection<String> items) {
    if (this.bootstrapServers == null) {
      return (A) this;
    }
    for (String item : items) {
      this.bootstrapServers.remove(item);
    }
    return (A) this;
  }
  
  public A removeAllFromTopics(Collection<String> items) {
    if (this.topics == null) {
      return (A) this;
    }
    for (String item : items) {
      this.topics.remove(item);
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
  
  public A removeFromBootstrapServers(String... items) {
    if (this.bootstrapServers == null) {
      return (A) this;
    }
    for (String item : items) {
      this.bootstrapServers.remove(item);
    }
    return (A) this;
  }
  
  public A removeFromTopics(String... items) {
    if (this.topics == null) {
      return (A) this;
    }
    for (String item : items) {
      this.topics.remove(item);
    }
    return (A) this;
  }
  
  public A setToBootstrapServers(int index,String item) {
    if (this.bootstrapServers == null) {
      this.bootstrapServers = new ArrayList();
    }
    this.bootstrapServers.set(index, item);
    return (A) this;
  }
  
  public A setToTopics(int index,String item) {
    if (this.topics == null) {
      this.topics = new ArrayList();
    }
    this.topics.set(index, item);
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(bootstrapServers == null) && !(bootstrapServers.isEmpty())) {
        sb.append("bootstrapServers:");
        sb.append(bootstrapServers);
        sb.append(",");
    }
    if (!(ceOverrides == null)) {
        sb.append("ceOverrides:");
        sb.append(ceOverrides);
        sb.append(",");
    }
    if (!(consumerGroup == null)) {
        sb.append("consumerGroup:");
        sb.append(consumerGroup);
        sb.append(",");
    }
    if (!(consumers == null)) {
        sb.append("consumers:");
        sb.append(consumers);
        sb.append(",");
    }
    if (!(delivery == null)) {
        sb.append("delivery:");
        sb.append(delivery);
        sb.append(",");
    }
    if (!(initialOffset == null)) {
        sb.append("initialOffset:");
        sb.append(initialOffset);
        sb.append(",");
    }
    if (!(net == null)) {
        sb.append("net:");
        sb.append(net);
        sb.append(",");
    }
    if (!(ordering == null)) {
        sb.append("ordering:");
        sb.append(ordering);
        sb.append(",");
    }
    if (!(sink == null)) {
        sb.append("sink:");
        sb.append(sink);
        sb.append(",");
    }
    if (!(topics == null) && !(topics.isEmpty())) {
        sb.append("topics:");
        sb.append(topics);
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
  
  public A withBootstrapServers(List<String> bootstrapServers) {
    if (bootstrapServers != null) {
        this.bootstrapServers = new ArrayList();
        for (String item : bootstrapServers) {
          this.addToBootstrapServers(item);
        }
    } else {
      this.bootstrapServers = null;
    }
    return (A) this;
  }
  
  public A withBootstrapServers(String... bootstrapServers) {
    if (this.bootstrapServers != null) {
        this.bootstrapServers.clear();
        _visitables.remove("bootstrapServers");
    }
    if (bootstrapServers != null) {
      for (String item : bootstrapServers) {
        this.addToBootstrapServers(item);
      }
    }
    return (A) this;
  }
  
  public A withCeOverrides(CloudEventOverrides ceOverrides) {
    this._visitables.remove("ceOverrides");
    if (ceOverrides != null) {
        this.ceOverrides = new CloudEventOverridesBuilder(ceOverrides);
        this._visitables.get("ceOverrides").add(this.ceOverrides);
    } else {
        this.ceOverrides = null;
        this._visitables.get("ceOverrides").remove(this.ceOverrides);
    }
    return (A) this;
  }
  
  public A withConsumerGroup(String consumerGroup) {
    this.consumerGroup = consumerGroup;
    return (A) this;
  }
  
  public A withConsumers(Integer consumers) {
    this.consumers = consumers;
    return (A) this;
  }
  
  public A withDelivery(DeliverySpec delivery) {
    this._visitables.remove("delivery");
    if (delivery != null) {
        this.delivery = new DeliverySpecBuilder(delivery);
        this._visitables.get("delivery").add(this.delivery);
    } else {
        this.delivery = null;
        this._visitables.get("delivery").remove(this.delivery);
    }
    return (A) this;
  }
  
  public A withInitialOffset(String initialOffset) {
    this.initialOffset = initialOffset;
    return (A) this;
  }
  
  public A withNet(KafkaNetSpec net) {
    this._visitables.remove("net");
    if (net != null) {
        this.net = new KafkaNetSpecBuilder(net);
        this._visitables.get("net").add(this.net);
    } else {
        this.net = null;
        this._visitables.get("net").remove(this.net);
    }
    return (A) this;
  }
  
  public CeOverridesNested<A> withNewCeOverrides() {
    return new CeOverridesNested(null);
  }
  
  public CeOverridesNested<A> withNewCeOverridesLike(CloudEventOverrides item) {
    return new CeOverridesNested(item);
  }
  
  public DeliveryNested<A> withNewDelivery() {
    return new DeliveryNested(null);
  }
  
  public DeliveryNested<A> withNewDeliveryLike(DeliverySpec item) {
    return new DeliveryNested(item);
  }
  
  public NetNested<A> withNewNet() {
    return new NetNested(null);
  }
  
  public NetNested<A> withNewNetLike(KafkaNetSpec item) {
    return new NetNested(item);
  }
  
  public SinkNested<A> withNewSink() {
    return new SinkNested(null);
  }
  
  public SinkNested<A> withNewSinkLike(Destination item) {
    return new SinkNested(item);
  }
  
  public A withOrdering(String ordering) {
    this.ordering = ordering;
    return (A) this;
  }
  
  public A withSink(Destination sink) {
    this._visitables.remove("sink");
    if (sink != null) {
        this.sink = new DestinationBuilder(sink);
        this._visitables.get("sink").add(this.sink);
    } else {
        this.sink = null;
        this._visitables.get("sink").remove(this.sink);
    }
    return (A) this;
  }
  
  public A withTopics(List<String> topics) {
    if (topics != null) {
        this.topics = new ArrayList();
        for (String item : topics) {
          this.addToTopics(item);
        }
    } else {
      this.topics = null;
    }
    return (A) this;
  }
  
  public A withTopics(String... topics) {
    if (this.topics != null) {
        this.topics.clear();
        _visitables.remove("topics");
    }
    if (topics != null) {
      for (String item : topics) {
        this.addToTopics(item);
      }
    }
    return (A) this;
  }
  public class CeOverridesNested<N> extends CloudEventOverridesFluent<CeOverridesNested<N>> implements Nested<N>{
  
    CloudEventOverridesBuilder builder;
  
    CeOverridesNested(CloudEventOverrides item) {
      this.builder = new CloudEventOverridesBuilder(this, item);
    }
  
    public N and() {
      return (N) KafkaSourceSpecFluent.this.withCeOverrides(builder.build());
    }
    
    public N endCeOverrides() {
      return and();
    }
    
  }
  public class DeliveryNested<N> extends DeliverySpecFluent<DeliveryNested<N>> implements Nested<N>{
  
    DeliverySpecBuilder builder;
  
    DeliveryNested(DeliverySpec item) {
      this.builder = new DeliverySpecBuilder(this, item);
    }
  
    public N and() {
      return (N) KafkaSourceSpecFluent.this.withDelivery(builder.build());
    }
    
    public N endDelivery() {
      return and();
    }
    
  }
  public class NetNested<N> extends KafkaNetSpecFluent<NetNested<N>> implements Nested<N>{
  
    KafkaNetSpecBuilder builder;
  
    NetNested(KafkaNetSpec item) {
      this.builder = new KafkaNetSpecBuilder(this, item);
    }
  
    public N and() {
      return (N) KafkaSourceSpecFluent.this.withNet(builder.build());
    }
    
    public N endNet() {
      return and();
    }
    
  }
  public class SinkNested<N> extends DestinationFluent<SinkNested<N>> implements Nested<N>{
  
    DestinationBuilder builder;
  
    SinkNested(Destination item) {
      this.builder = new DestinationBuilder(this, item);
    }
  
    public N and() {
      return (N) KafkaSourceSpecFluent.this.withSink(builder.build());
    }
    
    public N endSink() {
      return and();
    }
    
  }
}