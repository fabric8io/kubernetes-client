package io.fabric8.openshift.api.model.monitoring.v1alpha1;

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
public class SlackActionFluent<A extends io.fabric8.openshift.api.model.monitoring.v1alpha1.SlackActionFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private SlackConfirmationFieldBuilder confirm;
  private String name;
  private String style;
  private String text;
  private String type;
  private String url;
  private String value;

  public SlackActionFluent() {
  }
  
  public SlackActionFluent(SlackAction instance) {
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
  
  public SlackConfirmationField buildConfirm() {
    return this.confirm != null ? this.confirm.build() : null;
  }
  
  protected void copyInstance(SlackAction instance) {
    instance = instance != null ? instance : new SlackAction();
    if (instance != null) {
        this.withConfirm(instance.getConfirm());
        this.withName(instance.getName());
        this.withStyle(instance.getStyle());
        this.withText(instance.getText());
        this.withType(instance.getType());
        this.withUrl(instance.getUrl());
        this.withValue(instance.getValue());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public ConfirmNested<A> editConfirm() {
    return this.withNewConfirmLike(Optional.ofNullable(this.buildConfirm()).orElse(null));
  }
  
  public ConfirmNested<A> editOrNewConfirm() {
    return this.withNewConfirmLike(Optional.ofNullable(this.buildConfirm()).orElse(new SlackConfirmationFieldBuilder().build()));
  }
  
  public ConfirmNested<A> editOrNewConfirmLike(SlackConfirmationField item) {
    return this.withNewConfirmLike(Optional.ofNullable(this.buildConfirm()).orElse(item));
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
    SlackActionFluent that = (SlackActionFluent) o;
    if (!(Objects.equals(confirm, that.confirm))) {
      return false;
    }
    if (!(Objects.equals(name, that.name))) {
      return false;
    }
    if (!(Objects.equals(style, that.style))) {
      return false;
    }
    if (!(Objects.equals(text, that.text))) {
      return false;
    }
    if (!(Objects.equals(type, that.type))) {
      return false;
    }
    if (!(Objects.equals(url, that.url))) {
      return false;
    }
    if (!(Objects.equals(value, that.value))) {
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
  
  public String getName() {
    return this.name;
  }
  
  public String getStyle() {
    return this.style;
  }
  
  public String getText() {
    return this.text;
  }
  
  public String getType() {
    return this.type;
  }
  
  public String getUrl() {
    return this.url;
  }
  
  public String getValue() {
    return this.value;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasConfirm() {
    return this.confirm != null;
  }
  
  public boolean hasName() {
    return this.name != null;
  }
  
  public boolean hasStyle() {
    return this.style != null;
  }
  
  public boolean hasText() {
    return this.text != null;
  }
  
  public boolean hasType() {
    return this.type != null;
  }
  
  public boolean hasUrl() {
    return this.url != null;
  }
  
  public boolean hasValue() {
    return this.value != null;
  }
  
  public int hashCode() {
    return Objects.hash(confirm, name, style, text, type, url, value, additionalProperties);
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
    if (!(confirm == null)) {
        sb.append("confirm:");
        sb.append(confirm);
        sb.append(",");
    }
    if (!(name == null)) {
        sb.append("name:");
        sb.append(name);
        sb.append(",");
    }
    if (!(style == null)) {
        sb.append("style:");
        sb.append(style);
        sb.append(",");
    }
    if (!(text == null)) {
        sb.append("text:");
        sb.append(text);
        sb.append(",");
    }
    if (!(type == null)) {
        sb.append("type:");
        sb.append(type);
        sb.append(",");
    }
    if (!(url == null)) {
        sb.append("url:");
        sb.append(url);
        sb.append(",");
    }
    if (!(value == null)) {
        sb.append("value:");
        sb.append(value);
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
  
  public A withConfirm(SlackConfirmationField confirm) {
    this._visitables.remove("confirm");
    if (confirm != null) {
        this.confirm = new SlackConfirmationFieldBuilder(confirm);
        this._visitables.get("confirm").add(this.confirm);
    } else {
        this.confirm = null;
        this._visitables.get("confirm").remove(this.confirm);
    }
    return (A) this;
  }
  
  public A withName(String name) {
    this.name = name;
    return (A) this;
  }
  
  public ConfirmNested<A> withNewConfirm() {
    return new ConfirmNested(null);
  }
  
  public A withNewConfirm(String dismissText,String okText,String text,String title) {
    return (A) this.withConfirm(new SlackConfirmationField(dismissText, okText, text, title));
  }
  
  public ConfirmNested<A> withNewConfirmLike(SlackConfirmationField item) {
    return new ConfirmNested(item);
  }
  
  public A withStyle(String style) {
    this.style = style;
    return (A) this;
  }
  
  public A withText(String text) {
    this.text = text;
    return (A) this;
  }
  
  public A withType(String type) {
    this.type = type;
    return (A) this;
  }
  
  public A withUrl(String url) {
    this.url = url;
    return (A) this;
  }
  
  public A withValue(String value) {
    this.value = value;
    return (A) this;
  }
  public class ConfirmNested<N> extends SlackConfirmationFieldFluent<ConfirmNested<N>> implements Nested<N>{
  
    SlackConfirmationFieldBuilder builder;
  
    ConfirmNested(SlackConfirmationField item) {
      this.builder = new SlackConfirmationFieldBuilder(this, item);
    }
  
    public N and() {
      return (N) SlackActionFluent.this.withConfirm(builder.build());
    }
    
    public N endConfirm() {
      return and();
    }
    
  }
}