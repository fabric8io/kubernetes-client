package io.fabric8.openshift.api.model.monitoring.v1beta1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
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
public class SlackConfirmationFieldFluent<A extends io.fabric8.openshift.api.model.monitoring.v1beta1.SlackConfirmationFieldFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String dismissText;
  private String okText;
  private String text;
  private String title;

  public SlackConfirmationFieldFluent() {
  }
  
  public SlackConfirmationFieldFluent(SlackConfirmationField instance) {
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
  
  protected void copyInstance(SlackConfirmationField instance) {
    instance = instance != null ? instance : new SlackConfirmationField();
    if (instance != null) {
        this.withDismissText(instance.getDismissText());
        this.withOkText(instance.getOkText());
        this.withText(instance.getText());
        this.withTitle(instance.getTitle());
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
    SlackConfirmationFieldFluent that = (SlackConfirmationFieldFluent) o;
    if (!(Objects.equals(dismissText, that.dismissText))) {
      return false;
    }
    if (!(Objects.equals(okText, that.okText))) {
      return false;
    }
    if (!(Objects.equals(text, that.text))) {
      return false;
    }
    if (!(Objects.equals(title, that.title))) {
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
  
  public String getDismissText() {
    return this.dismissText;
  }
  
  public String getOkText() {
    return this.okText;
  }
  
  public String getText() {
    return this.text;
  }
  
  public String getTitle() {
    return this.title;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasDismissText() {
    return this.dismissText != null;
  }
  
  public boolean hasOkText() {
    return this.okText != null;
  }
  
  public boolean hasText() {
    return this.text != null;
  }
  
  public boolean hasTitle() {
    return this.title != null;
  }
  
  public int hashCode() {
    return Objects.hash(dismissText, okText, text, title, additionalProperties);
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
    if (!(dismissText == null)) {
        sb.append("dismissText:");
        sb.append(dismissText);
        sb.append(",");
    }
    if (!(okText == null)) {
        sb.append("okText:");
        sb.append(okText);
        sb.append(",");
    }
    if (!(text == null)) {
        sb.append("text:");
        sb.append(text);
        sb.append(",");
    }
    if (!(title == null)) {
        sb.append("title:");
        sb.append(title);
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
  
  public A withDismissText(String dismissText) {
    this.dismissText = dismissText;
    return (A) this;
  }
  
  public A withOkText(String okText) {
    this.okText = okText;
    return (A) this;
  }
  
  public A withText(String text) {
    this.text = text;
    return (A) this;
  }
  
  public A withTitle(String title) {
    this.title = title;
    return (A) this;
  }
  
}