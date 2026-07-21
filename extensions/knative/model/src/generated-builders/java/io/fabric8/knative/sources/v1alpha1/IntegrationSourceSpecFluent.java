package io.fabric8.knative.sources.v1alpha1;

import io.fabric8.knative.duck.v1.CloudEventOverrides;
import io.fabric8.knative.duck.v1.CloudEventOverridesBuilder;
import io.fabric8.knative.duck.v1.CloudEventOverridesFluent;
import io.fabric8.knative.duck.v1.Destination;
import io.fabric8.knative.duck.v1.DestinationBuilder;
import io.fabric8.knative.duck.v1.DestinationFluent;
import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import io.fabric8.kubernetes.api.model.PodTemplateSpec;
import io.fabric8.kubernetes.api.model.PodTemplateSpecBuilder;
import io.fabric8.kubernetes.api.model.PodTemplateSpecFluent;
import java.lang.Integer;
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
public class IntegrationSourceSpecFluent<A extends io.fabric8.knative.sources.v1alpha1.IntegrationSourceSpecFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private AwsBuilder aws;
  private CloudEventOverridesBuilder ceOverrides;
  private DestinationBuilder sink;
  private PodTemplateSpecBuilder template;
  private TimerBuilder timer;

  public IntegrationSourceSpecFluent() {
  }
  
  public IntegrationSourceSpecFluent(IntegrationSourceSpec instance) {
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
  
  public Aws buildAws() {
    return this.aws != null ? this.aws.build() : null;
  }
  
  public CloudEventOverrides buildCeOverrides() {
    return this.ceOverrides != null ? this.ceOverrides.build() : null;
  }
  
  public Destination buildSink() {
    return this.sink != null ? this.sink.build() : null;
  }
  
  public PodTemplateSpec buildTemplate() {
    return this.template != null ? this.template.build() : null;
  }
  
  public Timer buildTimer() {
    return this.timer != null ? this.timer.build() : null;
  }
  
  protected void copyInstance(IntegrationSourceSpec instance) {
    instance = instance != null ? instance : new IntegrationSourceSpec();
    if (instance != null) {
        this.withAws(instance.getAws());
        this.withCeOverrides(instance.getCeOverrides());
        this.withSink(instance.getSink());
        this.withTemplate(instance.getTemplate());
        this.withTimer(instance.getTimer());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public AwsNested<A> editAws() {
    return this.withNewAwsLike(Optional.ofNullable(this.buildAws()).orElse(null));
  }
  
  public CeOverridesNested<A> editCeOverrides() {
    return this.withNewCeOverridesLike(Optional.ofNullable(this.buildCeOverrides()).orElse(null));
  }
  
  public AwsNested<A> editOrNewAws() {
    return this.withNewAwsLike(Optional.ofNullable(this.buildAws()).orElse(new AwsBuilder().build()));
  }
  
  public AwsNested<A> editOrNewAwsLike(Aws item) {
    return this.withNewAwsLike(Optional.ofNullable(this.buildAws()).orElse(item));
  }
  
  public CeOverridesNested<A> editOrNewCeOverrides() {
    return this.withNewCeOverridesLike(Optional.ofNullable(this.buildCeOverrides()).orElse(new CloudEventOverridesBuilder().build()));
  }
  
  public CeOverridesNested<A> editOrNewCeOverridesLike(CloudEventOverrides item) {
    return this.withNewCeOverridesLike(Optional.ofNullable(this.buildCeOverrides()).orElse(item));
  }
  
  public SinkNested<A> editOrNewSink() {
    return this.withNewSinkLike(Optional.ofNullable(this.buildSink()).orElse(new DestinationBuilder().build()));
  }
  
  public SinkNested<A> editOrNewSinkLike(Destination item) {
    return this.withNewSinkLike(Optional.ofNullable(this.buildSink()).orElse(item));
  }
  
  public TemplateNested<A> editOrNewTemplate() {
    return this.withNewTemplateLike(Optional.ofNullable(this.buildTemplate()).orElse(new PodTemplateSpecBuilder().build()));
  }
  
  public TemplateNested<A> editOrNewTemplateLike(PodTemplateSpec item) {
    return this.withNewTemplateLike(Optional.ofNullable(this.buildTemplate()).orElse(item));
  }
  
  public TimerNested<A> editOrNewTimer() {
    return this.withNewTimerLike(Optional.ofNullable(this.buildTimer()).orElse(new TimerBuilder().build()));
  }
  
  public TimerNested<A> editOrNewTimerLike(Timer item) {
    return this.withNewTimerLike(Optional.ofNullable(this.buildTimer()).orElse(item));
  }
  
  public SinkNested<A> editSink() {
    return this.withNewSinkLike(Optional.ofNullable(this.buildSink()).orElse(null));
  }
  
  public TemplateNested<A> editTemplate() {
    return this.withNewTemplateLike(Optional.ofNullable(this.buildTemplate()).orElse(null));
  }
  
  public TimerNested<A> editTimer() {
    return this.withNewTimerLike(Optional.ofNullable(this.buildTimer()).orElse(null));
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
    IntegrationSourceSpecFluent that = (IntegrationSourceSpecFluent) o;
    if (!(Objects.equals(aws, that.aws))) {
      return false;
    }
    if (!(Objects.equals(ceOverrides, that.ceOverrides))) {
      return false;
    }
    if (!(Objects.equals(sink, that.sink))) {
      return false;
    }
    if (!(Objects.equals(template, that.template))) {
      return false;
    }
    if (!(Objects.equals(timer, that.timer))) {
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
  
  public boolean hasAws() {
    return this.aws != null;
  }
  
  public boolean hasCeOverrides() {
    return this.ceOverrides != null;
  }
  
  public boolean hasSink() {
    return this.sink != null;
  }
  
  public boolean hasTemplate() {
    return this.template != null;
  }
  
  public boolean hasTimer() {
    return this.timer != null;
  }
  
  public int hashCode() {
    return Objects.hash(aws, ceOverrides, sink, template, timer, additionalProperties);
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
    if (!(aws == null)) {
        sb.append("aws:");
        sb.append(aws);
        sb.append(",");
    }
    if (!(ceOverrides == null)) {
        sb.append("ceOverrides:");
        sb.append(ceOverrides);
        sb.append(",");
    }
    if (!(sink == null)) {
        sb.append("sink:");
        sb.append(sink);
        sb.append(",");
    }
    if (!(template == null)) {
        sb.append("template:");
        sb.append(template);
        sb.append(",");
    }
    if (!(timer == null)) {
        sb.append("timer:");
        sb.append(timer);
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
  
  public A withAws(Aws aws) {
    this._visitables.remove("aws");
    if (aws != null) {
        this.aws = new AwsBuilder(aws);
        this._visitables.get("aws").add(this.aws);
    } else {
        this.aws = null;
        this._visitables.get("aws").remove(this.aws);
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
  
  public AwsNested<A> withNewAws() {
    return new AwsNested(null);
  }
  
  public AwsNested<A> withNewAwsLike(Aws item) {
    return new AwsNested(item);
  }
  
  public CeOverridesNested<A> withNewCeOverrides() {
    return new CeOverridesNested(null);
  }
  
  public CeOverridesNested<A> withNewCeOverridesLike(CloudEventOverrides item) {
    return new CeOverridesNested(item);
  }
  
  public SinkNested<A> withNewSink() {
    return new SinkNested(null);
  }
  
  public SinkNested<A> withNewSinkLike(Destination item) {
    return new SinkNested(item);
  }
  
  public TemplateNested<A> withNewTemplate() {
    return new TemplateNested(null);
  }
  
  public TemplateNested<A> withNewTemplateLike(PodTemplateSpec item) {
    return new TemplateNested(item);
  }
  
  public TimerNested<A> withNewTimer() {
    return new TimerNested(null);
  }
  
  public A withNewTimer(String contentType,String message,Integer period,Integer repeatCount) {
    return (A) this.withTimer(new Timer(contentType, message, period, repeatCount));
  }
  
  public TimerNested<A> withNewTimerLike(Timer item) {
    return new TimerNested(item);
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
  
  public A withTemplate(PodTemplateSpec template) {
    this._visitables.remove("template");
    if (template != null) {
        this.template = new PodTemplateSpecBuilder(template);
        this._visitables.get("template").add(this.template);
    } else {
        this.template = null;
        this._visitables.get("template").remove(this.template);
    }
    return (A) this;
  }
  
  public A withTimer(Timer timer) {
    this._visitables.remove("timer");
    if (timer != null) {
        this.timer = new TimerBuilder(timer);
        this._visitables.get("timer").add(this.timer);
    } else {
        this.timer = null;
        this._visitables.get("timer").remove(this.timer);
    }
    return (A) this;
  }
  public class AwsNested<N> extends AwsFluent<AwsNested<N>> implements Nested<N>{
  
    AwsBuilder builder;
  
    AwsNested(Aws item) {
      this.builder = new AwsBuilder(this, item);
    }
  
    public N and() {
      return (N) IntegrationSourceSpecFluent.this.withAws(builder.build());
    }
    
    public N endAws() {
      return and();
    }
    
  }
  public class CeOverridesNested<N> extends CloudEventOverridesFluent<CeOverridesNested<N>> implements Nested<N>{
  
    CloudEventOverridesBuilder builder;
  
    CeOverridesNested(CloudEventOverrides item) {
      this.builder = new CloudEventOverridesBuilder(this, item);
    }
  
    public N and() {
      return (N) IntegrationSourceSpecFluent.this.withCeOverrides(builder.build());
    }
    
    public N endCeOverrides() {
      return and();
    }
    
  }
  public class SinkNested<N> extends DestinationFluent<SinkNested<N>> implements Nested<N>{
  
    DestinationBuilder builder;
  
    SinkNested(Destination item) {
      this.builder = new DestinationBuilder(this, item);
    }
  
    public N and() {
      return (N) IntegrationSourceSpecFluent.this.withSink(builder.build());
    }
    
    public N endSink() {
      return and();
    }
    
  }
  public class TemplateNested<N> extends PodTemplateSpecFluent<TemplateNested<N>> implements Nested<N>{
  
    PodTemplateSpecBuilder builder;
  
    TemplateNested(PodTemplateSpec item) {
      this.builder = new PodTemplateSpecBuilder(this, item);
    }
  
    public N and() {
      return (N) IntegrationSourceSpecFluent.this.withTemplate(builder.build());
    }
    
    public N endTemplate() {
      return and();
    }
    
  }
  public class TimerNested<N> extends TimerFluent<TimerNested<N>> implements Nested<N>{
  
    TimerBuilder builder;
  
    TimerNested(Timer item) {
      this.builder = new TimerBuilder(this, item);
    }
  
    public N and() {
      return (N) IntegrationSourceSpecFluent.this.withTimer(builder.build());
    }
    
    public N endTimer() {
      return and();
    }
    
  }
}