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
public class ConsoleNotificationSpecFluent<A extends io.fabric8.openshift.api.model.console.v1.ConsoleNotificationSpecFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String backgroundColor;
  private String color;
  private LinkBuilder link;
  private String location;
  private String text;

  public ConsoleNotificationSpecFluent() {
  }
  
  public ConsoleNotificationSpecFluent(ConsoleNotificationSpec instance) {
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
  
  public Link buildLink() {
    return this.link != null ? this.link.build() : null;
  }
  
  protected void copyInstance(ConsoleNotificationSpec instance) {
    instance = instance != null ? instance : new ConsoleNotificationSpec();
    if (instance != null) {
        this.withBackgroundColor(instance.getBackgroundColor());
        this.withColor(instance.getColor());
        this.withLink(instance.getLink());
        this.withLocation(instance.getLocation());
        this.withText(instance.getText());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public LinkNested<A> editLink() {
    return this.withNewLinkLike(Optional.ofNullable(this.buildLink()).orElse(null));
  }
  
  public LinkNested<A> editOrNewLink() {
    return this.withNewLinkLike(Optional.ofNullable(this.buildLink()).orElse(new LinkBuilder().build()));
  }
  
  public LinkNested<A> editOrNewLinkLike(Link item) {
    return this.withNewLinkLike(Optional.ofNullable(this.buildLink()).orElse(item));
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
    ConsoleNotificationSpecFluent that = (ConsoleNotificationSpecFluent) o;
    if (!(Objects.equals(backgroundColor, that.backgroundColor))) {
      return false;
    }
    if (!(Objects.equals(color, that.color))) {
      return false;
    }
    if (!(Objects.equals(link, that.link))) {
      return false;
    }
    if (!(Objects.equals(location, that.location))) {
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
  
  public String getBackgroundColor() {
    return this.backgroundColor;
  }
  
  public String getColor() {
    return this.color;
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
  
  public boolean hasBackgroundColor() {
    return this.backgroundColor != null;
  }
  
  public boolean hasColor() {
    return this.color != null;
  }
  
  public boolean hasLink() {
    return this.link != null;
  }
  
  public boolean hasLocation() {
    return this.location != null;
  }
  
  public boolean hasText() {
    return this.text != null;
  }
  
  public int hashCode() {
    return Objects.hash(backgroundColor, color, link, location, text, additionalProperties);
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
    if (!(backgroundColor == null)) {
        sb.append("backgroundColor:");
        sb.append(backgroundColor);
        sb.append(",");
    }
    if (!(color == null)) {
        sb.append("color:");
        sb.append(color);
        sb.append(",");
    }
    if (!(link == null)) {
        sb.append("link:");
        sb.append(link);
        sb.append(",");
    }
    if (!(location == null)) {
        sb.append("location:");
        sb.append(location);
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
  
  public A withBackgroundColor(String backgroundColor) {
    this.backgroundColor = backgroundColor;
    return (A) this;
  }
  
  public A withColor(String color) {
    this.color = color;
    return (A) this;
  }
  
  public A withLink(Link link) {
    this._visitables.remove("link");
    if (link != null) {
        this.link = new LinkBuilder(link);
        this._visitables.get("link").add(this.link);
    } else {
        this.link = null;
        this._visitables.get("link").remove(this.link);
    }
    return (A) this;
  }
  
  public A withLocation(String location) {
    this.location = location;
    return (A) this;
  }
  
  public LinkNested<A> withNewLink() {
    return new LinkNested(null);
  }
  
  public A withNewLink(String href,String text) {
    return (A) this.withLink(new Link(href, text));
  }
  
  public LinkNested<A> withNewLinkLike(Link item) {
    return new LinkNested(item);
  }
  
  public A withText(String text) {
    this.text = text;
    return (A) this;
  }
  public class LinkNested<N> extends LinkFluent<LinkNested<N>> implements Nested<N>{
  
    LinkBuilder builder;
  
    LinkNested(Link item) {
      this.builder = new LinkBuilder(this, item);
    }
  
    public N and() {
      return (N) ConsoleNotificationSpecFluent.this.withLink(builder.build());
    }
    
    public N endLink() {
      return and();
    }
    
  }
}