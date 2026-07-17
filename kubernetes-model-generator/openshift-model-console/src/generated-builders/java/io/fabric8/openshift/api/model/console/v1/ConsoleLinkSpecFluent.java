package io.fabric8.openshift.api.model.console.v1;

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
public class ConsoleLinkSpecFluent<A extends io.fabric8.openshift.api.model.console.v1.ConsoleLinkSpecFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private ApplicationMenuSpecBuilder applicationMenu;
  private String href;
  private String location;
  private NamespaceDashboardSpecBuilder namespaceDashboard;
  private String text;

  public ConsoleLinkSpecFluent() {
  }
  
  public ConsoleLinkSpecFluent(ConsoleLinkSpec instance) {
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
  
  public ApplicationMenuSpec buildApplicationMenu() {
    return this.applicationMenu != null ? this.applicationMenu.build() : null;
  }
  
  public NamespaceDashboardSpec buildNamespaceDashboard() {
    return this.namespaceDashboard != null ? this.namespaceDashboard.build() : null;
  }
  
  protected void copyInstance(ConsoleLinkSpec instance) {
    instance = instance != null ? instance : new ConsoleLinkSpec();
    if (instance != null) {
        this.withApplicationMenu(instance.getApplicationMenu());
        this.withHref(instance.getHref());
        this.withLocation(instance.getLocation());
        this.withNamespaceDashboard(instance.getNamespaceDashboard());
        this.withText(instance.getText());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public ApplicationMenuNested<A> editApplicationMenu() {
    return this.withNewApplicationMenuLike(Optional.ofNullable(this.buildApplicationMenu()).orElse(null));
  }
  
  public NamespaceDashboardNested<A> editNamespaceDashboard() {
    return this.withNewNamespaceDashboardLike(Optional.ofNullable(this.buildNamespaceDashboard()).orElse(null));
  }
  
  public ApplicationMenuNested<A> editOrNewApplicationMenu() {
    return this.withNewApplicationMenuLike(Optional.ofNullable(this.buildApplicationMenu()).orElse(new ApplicationMenuSpecBuilder().build()));
  }
  
  public ApplicationMenuNested<A> editOrNewApplicationMenuLike(ApplicationMenuSpec item) {
    return this.withNewApplicationMenuLike(Optional.ofNullable(this.buildApplicationMenu()).orElse(item));
  }
  
  public NamespaceDashboardNested<A> editOrNewNamespaceDashboard() {
    return this.withNewNamespaceDashboardLike(Optional.ofNullable(this.buildNamespaceDashboard()).orElse(new NamespaceDashboardSpecBuilder().build()));
  }
  
  public NamespaceDashboardNested<A> editOrNewNamespaceDashboardLike(NamespaceDashboardSpec item) {
    return this.withNewNamespaceDashboardLike(Optional.ofNullable(this.buildNamespaceDashboard()).orElse(item));
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
    ConsoleLinkSpecFluent that = (ConsoleLinkSpecFluent) o;
    if (!(Objects.equals(applicationMenu, that.applicationMenu))) {
      return false;
    }
    if (!(Objects.equals(href, that.href))) {
      return false;
    }
    if (!(Objects.equals(location, that.location))) {
      return false;
    }
    if (!(Objects.equals(namespaceDashboard, that.namespaceDashboard))) {
      return false;
    }
    if (!(Objects.equals(text, that.text))) {
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
  
  public String getHref() {
    return this.href;
  }
  
  public String getLocation() {
    return this.location;
  }
  
  public String getText() {
    return this.text;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasApplicationMenu() {
    return this.applicationMenu != null;
  }
  
  public boolean hasHref() {
    return this.href != null;
  }
  
  public boolean hasLocation() {
    return this.location != null;
  }
  
  public boolean hasNamespaceDashboard() {
    return this.namespaceDashboard != null;
  }
  
  public boolean hasText() {
    return this.text != null;
  }
  
  public int hashCode() {
    return Objects.hash(applicationMenu, href, location, namespaceDashboard, text, additionalProperties);
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
    if (!(applicationMenu == null)) {
        sb.append("applicationMenu:");
        sb.append(applicationMenu);
        sb.append(",");
    }
    if (!(href == null)) {
        sb.append("href:");
        sb.append(href);
        sb.append(",");
    }
    if (!(location == null)) {
        sb.append("location:");
        sb.append(location);
        sb.append(",");
    }
    if (!(namespaceDashboard == null)) {
        sb.append("namespaceDashboard:");
        sb.append(namespaceDashboard);
        sb.append(",");
    }
    if (!(text == null)) {
        sb.append("text:");
        sb.append(text);
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
  
  public A withApplicationMenu(ApplicationMenuSpec applicationMenu) {
    this._visitables.remove("applicationMenu");
    if (applicationMenu != null) {
        this.applicationMenu = new ApplicationMenuSpecBuilder(applicationMenu);
        this._visitables.get("applicationMenu").add(this.applicationMenu);
    } else {
        this.applicationMenu = null;
        this._visitables.get("applicationMenu").remove(this.applicationMenu);
    }
    return (A) this;
  }
  
  public A withHref(String href) {
    this.href = href;
    return (A) this;
  }
  
  public A withLocation(String location) {
    this.location = location;
    return (A) this;
  }
  
  public A withNamespaceDashboard(NamespaceDashboardSpec namespaceDashboard) {
    this._visitables.remove("namespaceDashboard");
    if (namespaceDashboard != null) {
        this.namespaceDashboard = new NamespaceDashboardSpecBuilder(namespaceDashboard);
        this._visitables.get("namespaceDashboard").add(this.namespaceDashboard);
    } else {
        this.namespaceDashboard = null;
        this._visitables.get("namespaceDashboard").remove(this.namespaceDashboard);
    }
    return (A) this;
  }
  
  public ApplicationMenuNested<A> withNewApplicationMenu() {
    return new ApplicationMenuNested(null);
  }
  
  public A withNewApplicationMenu(String imageURL,String section) {
    return (A) this.withApplicationMenu(new ApplicationMenuSpec(imageURL, section));
  }
  
  public ApplicationMenuNested<A> withNewApplicationMenuLike(ApplicationMenuSpec item) {
    return new ApplicationMenuNested(item);
  }
  
  public NamespaceDashboardNested<A> withNewNamespaceDashboard() {
    return new NamespaceDashboardNested(null);
  }
  
  public NamespaceDashboardNested<A> withNewNamespaceDashboardLike(NamespaceDashboardSpec item) {
    return new NamespaceDashboardNested(item);
  }
  
  public A withText(String text) {
    this.text = text;
    return (A) this;
  }
  public class ApplicationMenuNested<N> extends ApplicationMenuSpecFluent<ApplicationMenuNested<N>> implements Nested<N>{
  
    ApplicationMenuSpecBuilder builder;
  
    ApplicationMenuNested(ApplicationMenuSpec item) {
      this.builder = new ApplicationMenuSpecBuilder(this, item);
    }
  
    public N and() {
      return (N) ConsoleLinkSpecFluent.this.withApplicationMenu(builder.build());
    }
    
    public N endApplicationMenu() {
      return and();
    }
    
  }
  public class NamespaceDashboardNested<N> extends NamespaceDashboardSpecFluent<NamespaceDashboardNested<N>> implements Nested<N>{
  
    NamespaceDashboardSpecBuilder builder;
  
    NamespaceDashboardNested(NamespaceDashboardSpec item) {
      this.builder = new NamespaceDashboardSpecBuilder(this, item);
    }
  
    public N and() {
      return (N) ConsoleLinkSpecFluent.this.withNamespaceDashboard(builder.build());
    }
    
    public N endNamespaceDashboard() {
      return and();
    }
    
  }
}