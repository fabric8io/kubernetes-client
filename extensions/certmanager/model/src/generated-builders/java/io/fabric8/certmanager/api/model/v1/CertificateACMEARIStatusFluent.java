package io.fabric8.certmanager.api.model.v1;

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
public class CertificateACMEARIStatusFluent<A extends io.fabric8.certmanager.api.model.v1.CertificateACMEARIStatusFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String explanationURL;
  private String lastChecked;
  private String lastError;
  private String nextCheck;
  private ACMERenewalWindowBuilder suggestedWindow;

  public CertificateACMEARIStatusFluent() {
  }
  
  public CertificateACMEARIStatusFluent(CertificateACMEARIStatus instance) {
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
  
  public ACMERenewalWindow buildSuggestedWindow() {
    return this.suggestedWindow != null ? this.suggestedWindow.build() : null;
  }
  
  protected void copyInstance(CertificateACMEARIStatus instance) {
    instance = instance != null ? instance : new CertificateACMEARIStatus();
    if (instance != null) {
        this.withExplanationURL(instance.getExplanationURL());
        this.withLastChecked(instance.getLastChecked());
        this.withLastError(instance.getLastError());
        this.withNextCheck(instance.getNextCheck());
        this.withSuggestedWindow(instance.getSuggestedWindow());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public SuggestedWindowNested<A> editOrNewSuggestedWindow() {
    return this.withNewSuggestedWindowLike(Optional.ofNullable(this.buildSuggestedWindow()).orElse(new ACMERenewalWindowBuilder().build()));
  }
  
  public SuggestedWindowNested<A> editOrNewSuggestedWindowLike(ACMERenewalWindow item) {
    return this.withNewSuggestedWindowLike(Optional.ofNullable(this.buildSuggestedWindow()).orElse(item));
  }
  
  public SuggestedWindowNested<A> editSuggestedWindow() {
    return this.withNewSuggestedWindowLike(Optional.ofNullable(this.buildSuggestedWindow()).orElse(null));
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
    CertificateACMEARIStatusFluent that = (CertificateACMEARIStatusFluent) o;
    if (!(Objects.equals(explanationURL, that.explanationURL))) {
      return false;
    }
    if (!(Objects.equals(lastChecked, that.lastChecked))) {
      return false;
    }
    if (!(Objects.equals(lastError, that.lastError))) {
      return false;
    }
    if (!(Objects.equals(nextCheck, that.nextCheck))) {
      return false;
    }
    if (!(Objects.equals(suggestedWindow, that.suggestedWindow))) {
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
  
  public String getExplanationURL() {
    return this.explanationURL;
  }
  
  public String getLastChecked() {
    return this.lastChecked;
  }
  
  public String getLastError() {
    return this.lastError;
  }
  
  public String getNextCheck() {
    return this.nextCheck;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasExplanationURL() {
    return this.explanationURL != null;
  }
  
  public boolean hasLastChecked() {
    return this.lastChecked != null;
  }
  
  public boolean hasLastError() {
    return this.lastError != null;
  }
  
  public boolean hasNextCheck() {
    return this.nextCheck != null;
  }
  
  public boolean hasSuggestedWindow() {
    return this.suggestedWindow != null;
  }
  
  public int hashCode() {
    return Objects.hash(explanationURL, lastChecked, lastError, nextCheck, suggestedWindow, additionalProperties);
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
    if (!(explanationURL == null)) {
        sb.append("explanationURL:");
        sb.append(explanationURL);
        sb.append(",");
    }
    if (!(lastChecked == null)) {
        sb.append("lastChecked:");
        sb.append(lastChecked);
        sb.append(",");
    }
    if (!(lastError == null)) {
        sb.append("lastError:");
        sb.append(lastError);
        sb.append(",");
    }
    if (!(nextCheck == null)) {
        sb.append("nextCheck:");
        sb.append(nextCheck);
        sb.append(",");
    }
    if (!(suggestedWindow == null)) {
        sb.append("suggestedWindow:");
        sb.append(suggestedWindow);
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
  
  public A withExplanationURL(String explanationURL) {
    this.explanationURL = explanationURL;
    return (A) this;
  }
  
  public A withLastChecked(String lastChecked) {
    this.lastChecked = lastChecked;
    return (A) this;
  }
  
  public A withLastError(String lastError) {
    this.lastError = lastError;
    return (A) this;
  }
  
  public SuggestedWindowNested<A> withNewSuggestedWindow() {
    return new SuggestedWindowNested(null);
  }
  
  public A withNewSuggestedWindow(String end,String start) {
    return (A) this.withSuggestedWindow(new ACMERenewalWindow(end, start));
  }
  
  public SuggestedWindowNested<A> withNewSuggestedWindowLike(ACMERenewalWindow item) {
    return new SuggestedWindowNested(item);
  }
  
  public A withNextCheck(String nextCheck) {
    this.nextCheck = nextCheck;
    return (A) this;
  }
  
  public A withSuggestedWindow(ACMERenewalWindow suggestedWindow) {
    this._visitables.remove("suggestedWindow");
    if (suggestedWindow != null) {
        this.suggestedWindow = new ACMERenewalWindowBuilder(suggestedWindow);
        this._visitables.get("suggestedWindow").add(this.suggestedWindow);
    } else {
        this.suggestedWindow = null;
        this._visitables.get("suggestedWindow").remove(this.suggestedWindow);
    }
    return (A) this;
  }
  public class SuggestedWindowNested<N> extends ACMERenewalWindowFluent<SuggestedWindowNested<N>> implements Nested<N>{
  
    ACMERenewalWindowBuilder builder;
  
    SuggestedWindowNested(ACMERenewalWindow item) {
      this.builder = new ACMERenewalWindowBuilder(this, item);
    }
  
    public N and() {
      return (N) CertificateACMEARIStatusFluent.this.withSuggestedWindow(builder.build());
    }
    
    public N endSuggestedWindow() {
      return and();
    }
    
  }
}