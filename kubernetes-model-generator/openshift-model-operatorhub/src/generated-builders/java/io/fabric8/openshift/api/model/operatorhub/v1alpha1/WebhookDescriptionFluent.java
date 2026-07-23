package io.fabric8.openshift.api.model.operatorhub.v1alpha1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import io.fabric8.kubernetes.api.model.IntOrString;
import io.fabric8.kubernetes.api.model.IntOrStringBuilder;
import io.fabric8.kubernetes.api.model.IntOrStringFluent;
import io.fabric8.kubernetes.api.model.LabelSelector;
import io.fabric8.kubernetes.api.model.LabelSelectorBuilder;
import io.fabric8.kubernetes.api.model.LabelSelectorFluent;
import io.fabric8.kubernetes.api.model.admissionregistration.v1.RuleWithOperations;
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
public class WebhookDescriptionFluent<A extends io.fabric8.openshift.api.model.operatorhub.v1alpha1.WebhookDescriptionFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private List<String> admissionReviewVersions = new ArrayList<String>();
  private Integer containerPort;
  private List<String> conversionCRDs = new ArrayList<String>();
  private String deploymentName;
  private String failurePolicy;
  private String generateName;
  private String matchPolicy;
  private LabelSelectorBuilder objectSelector;
  private String reinvocationPolicy;
  private List<RuleWithOperations> rules = new ArrayList<RuleWithOperations>();
  private String sideEffects;
  private IntOrStringBuilder targetPort;
  private Integer timeoutSeconds;
  private String type;
  private String webhookPath;

  public WebhookDescriptionFluent() {
  }
  
  public WebhookDescriptionFluent(WebhookDescription instance) {
    this.copyInstance(instance);
  }

  public A addAllToAdmissionReviewVersions(Collection<String> items) {
    if (this.admissionReviewVersions == null) {
      this.admissionReviewVersions = new ArrayList();
    }
    for (String item : items) {
      this.admissionReviewVersions.add(item);
    }
    return (A) this;
  }
  
  public A addAllToConversionCRDs(Collection<String> items) {
    if (this.conversionCRDs == null) {
      this.conversionCRDs = new ArrayList();
    }
    for (String item : items) {
      this.conversionCRDs.add(item);
    }
    return (A) this;
  }
  
  public A addAllToRules(Collection<RuleWithOperations> items) {
    if (this.rules == null) {
      this.rules = new ArrayList();
    }
    for (RuleWithOperations item : items) {
      this.rules.add(item);
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
  
  public A addToAdmissionReviewVersions(String... items) {
    if (this.admissionReviewVersions == null) {
      this.admissionReviewVersions = new ArrayList();
    }
    for (String item : items) {
      this.admissionReviewVersions.add(item);
    }
    return (A) this;
  }
  
  public A addToAdmissionReviewVersions(int index,String item) {
    if (this.admissionReviewVersions == null) {
      this.admissionReviewVersions = new ArrayList();
    }
    this.admissionReviewVersions.add(index, item);
    return (A) this;
  }
  
  public A addToConversionCRDs(String... items) {
    if (this.conversionCRDs == null) {
      this.conversionCRDs = new ArrayList();
    }
    for (String item : items) {
      this.conversionCRDs.add(item);
    }
    return (A) this;
  }
  
  public A addToConversionCRDs(int index,String item) {
    if (this.conversionCRDs == null) {
      this.conversionCRDs = new ArrayList();
    }
    this.conversionCRDs.add(index, item);
    return (A) this;
  }
  
  public A addToRules(RuleWithOperations... items) {
    if (this.rules == null) {
      this.rules = new ArrayList();
    }
    for (RuleWithOperations item : items) {
      this.rules.add(item);
    }
    return (A) this;
  }
  
  public A addToRules(int index,RuleWithOperations item) {
    if (this.rules == null) {
      this.rules = new ArrayList();
    }
    this.rules.add(index, item);
    return (A) this;
  }
  
  public LabelSelector buildObjectSelector() {
    return this.objectSelector != null ? this.objectSelector.build() : null;
  }
  
  public IntOrString buildTargetPort() {
    return this.targetPort != null ? this.targetPort.build() : null;
  }
  
  protected void copyInstance(WebhookDescription instance) {
    instance = instance != null ? instance : new WebhookDescription();
    if (instance != null) {
        this.withAdmissionReviewVersions(instance.getAdmissionReviewVersions());
        this.withContainerPort(instance.getContainerPort());
        this.withConversionCRDs(instance.getConversionCRDs());
        this.withDeploymentName(instance.getDeploymentName());
        this.withFailurePolicy(instance.getFailurePolicy());
        this.withGenerateName(instance.getGenerateName());
        this.withMatchPolicy(instance.getMatchPolicy());
        this.withObjectSelector(instance.getObjectSelector());
        this.withReinvocationPolicy(instance.getReinvocationPolicy());
        this.withRules(instance.getRules());
        this.withSideEffects(instance.getSideEffects());
        this.withTargetPort(instance.getTargetPort());
        this.withTimeoutSeconds(instance.getTimeoutSeconds());
        this.withType(instance.getType());
        this.withWebhookPath(instance.getWebhookPath());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public ObjectSelectorNested<A> editObjectSelector() {
    return this.withNewObjectSelectorLike(Optional.ofNullable(this.buildObjectSelector()).orElse(null));
  }
  
  public ObjectSelectorNested<A> editOrNewObjectSelector() {
    return this.withNewObjectSelectorLike(Optional.ofNullable(this.buildObjectSelector()).orElse(new LabelSelectorBuilder().build()));
  }
  
  public ObjectSelectorNested<A> editOrNewObjectSelectorLike(LabelSelector item) {
    return this.withNewObjectSelectorLike(Optional.ofNullable(this.buildObjectSelector()).orElse(item));
  }
  
  public TargetPortNested<A> editOrNewTargetPort() {
    return this.withNewTargetPortLike(Optional.ofNullable(this.buildTargetPort()).orElse(new IntOrStringBuilder().build()));
  }
  
  public TargetPortNested<A> editOrNewTargetPortLike(IntOrString item) {
    return this.withNewTargetPortLike(Optional.ofNullable(this.buildTargetPort()).orElse(item));
  }
  
  public TargetPortNested<A> editTargetPort() {
    return this.withNewTargetPortLike(Optional.ofNullable(this.buildTargetPort()).orElse(null));
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
    WebhookDescriptionFluent that = (WebhookDescriptionFluent) o;
    if (!(Objects.equals(admissionReviewVersions, that.admissionReviewVersions))) {
      return false;
    }
    if (!(Objects.equals(containerPort, that.containerPort))) {
      return false;
    }
    if (!(Objects.equals(conversionCRDs, that.conversionCRDs))) {
      return false;
    }
    if (!(Objects.equals(deploymentName, that.deploymentName))) {
      return false;
    }
    if (!(Objects.equals(failurePolicy, that.failurePolicy))) {
      return false;
    }
    if (!(Objects.equals(generateName, that.generateName))) {
      return false;
    }
    if (!(Objects.equals(matchPolicy, that.matchPolicy))) {
      return false;
    }
    if (!(Objects.equals(objectSelector, that.objectSelector))) {
      return false;
    }
    if (!(Objects.equals(reinvocationPolicy, that.reinvocationPolicy))) {
      return false;
    }
    if (!(Objects.equals(rules, that.rules))) {
      return false;
    }
    if (!(Objects.equals(sideEffects, that.sideEffects))) {
      return false;
    }
    if (!(Objects.equals(targetPort, that.targetPort))) {
      return false;
    }
    if (!(Objects.equals(timeoutSeconds, that.timeoutSeconds))) {
      return false;
    }
    if (!(Objects.equals(type, that.type))) {
      return false;
    }
    if (!(Objects.equals(webhookPath, that.webhookPath))) {
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
  
  public String getAdmissionReviewVersion(int index) {
    return this.admissionReviewVersions.get(index);
  }
  
  public List<String> getAdmissionReviewVersions() {
    return this.admissionReviewVersions;
  }
  
  public Integer getContainerPort() {
    return this.containerPort;
  }
  
  public String getConversionCRD(int index) {
    return this.conversionCRDs.get(index);
  }
  
  public List<String> getConversionCRDs() {
    return this.conversionCRDs;
  }
  
  public String getDeploymentName() {
    return this.deploymentName;
  }
  
  public String getFailurePolicy() {
    return this.failurePolicy;
  }
  
  public String getFirstAdmissionReviewVersion() {
    return this.admissionReviewVersions.get(0);
  }
  
  public String getFirstConversionCRD() {
    return this.conversionCRDs.get(0);
  }
  
  public RuleWithOperations getFirstRule() {
    return this.rules.get(0);
  }
  
  public String getGenerateName() {
    return this.generateName;
  }
  
  public String getLastAdmissionReviewVersion() {
    return this.admissionReviewVersions.get(admissionReviewVersions.size() - 1);
  }
  
  public String getLastConversionCRD() {
    return this.conversionCRDs.get(conversionCRDs.size() - 1);
  }
  
  public RuleWithOperations getLastRule() {
    return this.rules.get(rules.size() - 1);
  }
  
  public String getMatchPolicy() {
    return this.matchPolicy;
  }
  
  public String getMatchingAdmissionReviewVersion(Predicate<String> predicate) {
      for (String item : admissionReviewVersions) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public String getMatchingConversionCRD(Predicate<String> predicate) {
      for (String item : conversionCRDs) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public RuleWithOperations getMatchingRule(Predicate<RuleWithOperations> predicate) {
      for (RuleWithOperations item : rules) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public String getReinvocationPolicy() {
    return this.reinvocationPolicy;
  }
  
  public RuleWithOperations getRule(int index) {
    return this.rules.get(index);
  }
  
  public List<RuleWithOperations> getRules() {
    return this.rules;
  }
  
  public String getSideEffects() {
    return this.sideEffects;
  }
  
  public Integer getTimeoutSeconds() {
    return this.timeoutSeconds;
  }
  
  public String getType() {
    return this.type;
  }
  
  public String getWebhookPath() {
    return this.webhookPath;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasAdmissionReviewVersions() {
    return this.admissionReviewVersions != null && !(this.admissionReviewVersions.isEmpty());
  }
  
  public boolean hasContainerPort() {
    return this.containerPort != null;
  }
  
  public boolean hasConversionCRDs() {
    return this.conversionCRDs != null && !(this.conversionCRDs.isEmpty());
  }
  
  public boolean hasDeploymentName() {
    return this.deploymentName != null;
  }
  
  public boolean hasFailurePolicy() {
    return this.failurePolicy != null;
  }
  
  public boolean hasGenerateName() {
    return this.generateName != null;
  }
  
  public boolean hasMatchPolicy() {
    return this.matchPolicy != null;
  }
  
  public boolean hasMatchingAdmissionReviewVersion(Predicate<String> predicate) {
      for (String item : admissionReviewVersions) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingConversionCRD(Predicate<String> predicate) {
      for (String item : conversionCRDs) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingRule(Predicate<RuleWithOperations> predicate) {
      for (RuleWithOperations item : rules) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasObjectSelector() {
    return this.objectSelector != null;
  }
  
  public boolean hasReinvocationPolicy() {
    return this.reinvocationPolicy != null;
  }
  
  public boolean hasRules() {
    return this.rules != null && !(this.rules.isEmpty());
  }
  
  public boolean hasSideEffects() {
    return this.sideEffects != null;
  }
  
  public boolean hasTargetPort() {
    return this.targetPort != null;
  }
  
  public boolean hasTimeoutSeconds() {
    return this.timeoutSeconds != null;
  }
  
  public boolean hasType() {
    return this.type != null;
  }
  
  public boolean hasWebhookPath() {
    return this.webhookPath != null;
  }
  
  public int hashCode() {
    return Objects.hash(admissionReviewVersions, containerPort, conversionCRDs, deploymentName, failurePolicy, generateName, matchPolicy, objectSelector, reinvocationPolicy, rules, sideEffects, targetPort, timeoutSeconds, type, webhookPath, additionalProperties);
  }
  
  public A removeAllFromAdmissionReviewVersions(Collection<String> items) {
    if (this.admissionReviewVersions == null) {
      return (A) this;
    }
    for (String item : items) {
      this.admissionReviewVersions.remove(item);
    }
    return (A) this;
  }
  
  public A removeAllFromConversionCRDs(Collection<String> items) {
    if (this.conversionCRDs == null) {
      return (A) this;
    }
    for (String item : items) {
      this.conversionCRDs.remove(item);
    }
    return (A) this;
  }
  
  public A removeAllFromRules(Collection<RuleWithOperations> items) {
    if (this.rules == null) {
      return (A) this;
    }
    for (RuleWithOperations item : items) {
      this.rules.remove(item);
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
  
  public A removeFromAdmissionReviewVersions(String... items) {
    if (this.admissionReviewVersions == null) {
      return (A) this;
    }
    for (String item : items) {
      this.admissionReviewVersions.remove(item);
    }
    return (A) this;
  }
  
  public A removeFromConversionCRDs(String... items) {
    if (this.conversionCRDs == null) {
      return (A) this;
    }
    for (String item : items) {
      this.conversionCRDs.remove(item);
    }
    return (A) this;
  }
  
  public A removeFromRules(RuleWithOperations... items) {
    if (this.rules == null) {
      return (A) this;
    }
    for (RuleWithOperations item : items) {
      this.rules.remove(item);
    }
    return (A) this;
  }
  
  public A setToAdmissionReviewVersions(int index,String item) {
    if (this.admissionReviewVersions == null) {
      this.admissionReviewVersions = new ArrayList();
    }
    this.admissionReviewVersions.set(index, item);
    return (A) this;
  }
  
  public A setToConversionCRDs(int index,String item) {
    if (this.conversionCRDs == null) {
      this.conversionCRDs = new ArrayList();
    }
    this.conversionCRDs.set(index, item);
    return (A) this;
  }
  
  public A setToRules(int index,RuleWithOperations item) {
    if (this.rules == null) {
      this.rules = new ArrayList();
    }
    this.rules.set(index, item);
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(admissionReviewVersions == null) && !(admissionReviewVersions.isEmpty())) {
        sb.append("admissionReviewVersions:");
        sb.append(admissionReviewVersions);
        sb.append(",");
    }
    if (!(containerPort == null)) {
        sb.append("containerPort:");
        sb.append(containerPort);
        sb.append(",");
    }
    if (!(conversionCRDs == null) && !(conversionCRDs.isEmpty())) {
        sb.append("conversionCRDs:");
        sb.append(conversionCRDs);
        sb.append(",");
    }
    if (!(deploymentName == null)) {
        sb.append("deploymentName:");
        sb.append(deploymentName);
        sb.append(",");
    }
    if (!(failurePolicy == null)) {
        sb.append("failurePolicy:");
        sb.append(failurePolicy);
        sb.append(",");
    }
    if (!(generateName == null)) {
        sb.append("generateName:");
        sb.append(generateName);
        sb.append(",");
    }
    if (!(matchPolicy == null)) {
        sb.append("matchPolicy:");
        sb.append(matchPolicy);
        sb.append(",");
    }
    if (!(objectSelector == null)) {
        sb.append("objectSelector:");
        sb.append(objectSelector);
        sb.append(",");
    }
    if (!(reinvocationPolicy == null)) {
        sb.append("reinvocationPolicy:");
        sb.append(reinvocationPolicy);
        sb.append(",");
    }
    if (!(rules == null) && !(rules.isEmpty())) {
        sb.append("rules:");
        sb.append(rules);
        sb.append(",");
    }
    if (!(sideEffects == null)) {
        sb.append("sideEffects:");
        sb.append(sideEffects);
        sb.append(",");
    }
    if (!(targetPort == null)) {
        sb.append("targetPort:");
        sb.append(targetPort);
        sb.append(",");
    }
    if (!(timeoutSeconds == null)) {
        sb.append("timeoutSeconds:");
        sb.append(timeoutSeconds);
        sb.append(",");
    }
    if (!(type == null)) {
        sb.append("type:");
        sb.append(type);
        sb.append(",");
    }
    if (!(webhookPath == null)) {
        sb.append("webhookPath:");
        sb.append(webhookPath);
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
  
  public A withAdmissionReviewVersions(List<String> admissionReviewVersions) {
    if (admissionReviewVersions != null) {
        this.admissionReviewVersions = new ArrayList();
        for (String item : admissionReviewVersions) {
          this.addToAdmissionReviewVersions(item);
        }
    } else {
      this.admissionReviewVersions = null;
    }
    return (A) this;
  }
  
  public A withAdmissionReviewVersions(String... admissionReviewVersions) {
    if (this.admissionReviewVersions != null) {
        this.admissionReviewVersions.clear();
        _visitables.remove("admissionReviewVersions");
    }
    if (admissionReviewVersions != null) {
      for (String item : admissionReviewVersions) {
        this.addToAdmissionReviewVersions(item);
      }
    }
    return (A) this;
  }
  
  public A withContainerPort(Integer containerPort) {
    this.containerPort = containerPort;
    return (A) this;
  }
  
  public A withConversionCRDs(List<String> conversionCRDs) {
    if (conversionCRDs != null) {
        this.conversionCRDs = new ArrayList();
        for (String item : conversionCRDs) {
          this.addToConversionCRDs(item);
        }
    } else {
      this.conversionCRDs = null;
    }
    return (A) this;
  }
  
  public A withConversionCRDs(String... conversionCRDs) {
    if (this.conversionCRDs != null) {
        this.conversionCRDs.clear();
        _visitables.remove("conversionCRDs");
    }
    if (conversionCRDs != null) {
      for (String item : conversionCRDs) {
        this.addToConversionCRDs(item);
      }
    }
    return (A) this;
  }
  
  public A withDeploymentName(String deploymentName) {
    this.deploymentName = deploymentName;
    return (A) this;
  }
  
  public A withFailurePolicy(String failurePolicy) {
    this.failurePolicy = failurePolicy;
    return (A) this;
  }
  
  public A withGenerateName(String generateName) {
    this.generateName = generateName;
    return (A) this;
  }
  
  public A withMatchPolicy(String matchPolicy) {
    this.matchPolicy = matchPolicy;
    return (A) this;
  }
  
  public ObjectSelectorNested<A> withNewObjectSelector() {
    return new ObjectSelectorNested(null);
  }
  
  public ObjectSelectorNested<A> withNewObjectSelectorLike(LabelSelector item) {
    return new ObjectSelectorNested(item);
  }
  
  public TargetPortNested<A> withNewTargetPort() {
    return new TargetPortNested(null);
  }
  
  public A withNewTargetPort(Object value) {
    return (A) this.withTargetPort(new IntOrString(value));
  }
  
  public TargetPortNested<A> withNewTargetPortLike(IntOrString item) {
    return new TargetPortNested(item);
  }
  
  public A withObjectSelector(LabelSelector objectSelector) {
    this._visitables.remove("objectSelector");
    if (objectSelector != null) {
        this.objectSelector = new LabelSelectorBuilder(objectSelector);
        this._visitables.get("objectSelector").add(this.objectSelector);
    } else {
        this.objectSelector = null;
        this._visitables.get("objectSelector").remove(this.objectSelector);
    }
    return (A) this;
  }
  
  public A withReinvocationPolicy(String reinvocationPolicy) {
    this.reinvocationPolicy = reinvocationPolicy;
    return (A) this;
  }
  
  public A withRules(List<RuleWithOperations> rules) {
    if (rules != null) {
        this.rules = new ArrayList();
        for (RuleWithOperations item : rules) {
          this.addToRules(item);
        }
    } else {
      this.rules = null;
    }
    return (A) this;
  }
  
  public A withRules(RuleWithOperations... rules) {
    if (this.rules != null) {
        this.rules.clear();
        _visitables.remove("rules");
    }
    if (rules != null) {
      for (RuleWithOperations item : rules) {
        this.addToRules(item);
      }
    }
    return (A) this;
  }
  
  public A withSideEffects(String sideEffects) {
    this.sideEffects = sideEffects;
    return (A) this;
  }
  
  public A withTargetPort(IntOrString targetPort) {
    this._visitables.remove("targetPort");
    if (targetPort != null) {
        this.targetPort = new IntOrStringBuilder(targetPort);
        this._visitables.get("targetPort").add(this.targetPort);
    } else {
        this.targetPort = null;
        this._visitables.get("targetPort").remove(this.targetPort);
    }
    return (A) this;
  }
  
  public A withTimeoutSeconds(Integer timeoutSeconds) {
    this.timeoutSeconds = timeoutSeconds;
    return (A) this;
  }
  
  public A withType(String type) {
    this.type = type;
    return (A) this;
  }
  
  public A withWebhookPath(String webhookPath) {
    this.webhookPath = webhookPath;
    return (A) this;
  }
  public class ObjectSelectorNested<N> extends LabelSelectorFluent<ObjectSelectorNested<N>> implements Nested<N>{
  
    LabelSelectorBuilder builder;
  
    ObjectSelectorNested(LabelSelector item) {
      this.builder = new LabelSelectorBuilder(this, item);
    }
  
    public N and() {
      return (N) WebhookDescriptionFluent.this.withObjectSelector(builder.build());
    }
    
    public N endObjectSelector() {
      return and();
    }
    
  }
  public class TargetPortNested<N> extends IntOrStringFluent<TargetPortNested<N>> implements Nested<N>{
  
    IntOrStringBuilder builder;
  
    TargetPortNested(IntOrString item) {
      this.builder = new IntOrStringBuilder(this, item);
    }
  
    public N and() {
      return (N) WebhookDescriptionFluent.this.withTargetPort(builder.build());
    }
    
    public N endTargetPort() {
      return and();
    }
    
  }
}