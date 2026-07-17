package io.fabric8.openshift.api.model.console.v1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import java.lang.Object;
import java.lang.RuntimeException;
import java.lang.String;
import java.lang.StringBuilder;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Predicate;

/**
 * Generated
 */
@SuppressWarnings("unchecked")
public class ConsoleCLIDownloadSpecFluent<A extends io.fabric8.openshift.api.model.console.v1.ConsoleCLIDownloadSpecFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String description;
  private String displayName;
  private ArrayList<CLIDownloadLinkBuilder> links = new ArrayList<CLIDownloadLinkBuilder>();

  public ConsoleCLIDownloadSpecFluent() {
  }
  
  public ConsoleCLIDownloadSpecFluent(ConsoleCLIDownloadSpec instance) {
    this.copyInstance(instance);
  }

  public A addAllToLinks(Collection<CLIDownloadLink> items) {
    if (this.links == null) {
      this.links = new ArrayList();
    }
    for (CLIDownloadLink item : items) {
        CLIDownloadLinkBuilder builder = new CLIDownloadLinkBuilder(item);
        _visitables.get("links").add(builder);
        this.links.add(builder);
    }
    return (A) this;
  }
  
  public LinksNested<A> addNewLink() {
    return new LinksNested(-1, null);
  }
  
  public A addNewLink(String href,String text) {
    return (A) this.addToLinks(new CLIDownloadLink(href, text));
  }
  
  public LinksNested<A> addNewLinkLike(CLIDownloadLink item) {
    return new LinksNested(-1, item);
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
  
  public A addToLinks(CLIDownloadLink... items) {
    if (this.links == null) {
      this.links = new ArrayList();
    }
    for (CLIDownloadLink item : items) {
        CLIDownloadLinkBuilder builder = new CLIDownloadLinkBuilder(item);
        _visitables.get("links").add(builder);
        this.links.add(builder);
    }
    return (A) this;
  }
  
  public A addToLinks(int index,CLIDownloadLink item) {
    if (this.links == null) {
      this.links = new ArrayList();
    }
    CLIDownloadLinkBuilder builder = new CLIDownloadLinkBuilder(item);
    if (index < 0 || index >= links.size()) {
        _visitables.get("links").add(builder);
        links.add(builder);
    } else {
        _visitables.get("links").add(builder);
        links.add(index, builder);
    }
    return (A) this;
  }
  
  public CLIDownloadLink buildFirstLink() {
    return this.links.get(0).build();
  }
  
  public CLIDownloadLink buildLastLink() {
    return this.links.get(links.size() - 1).build();
  }
  
  public CLIDownloadLink buildLink(int index) {
    return this.links.get(index).build();
  }
  
  public List<CLIDownloadLink> buildLinks() {
    return this.links != null ? build(links) : null;
  }
  
  public CLIDownloadLink buildMatchingLink(Predicate<CLIDownloadLinkBuilder> predicate) {
      for (CLIDownloadLinkBuilder item : links) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  protected void copyInstance(ConsoleCLIDownloadSpec instance) {
    instance = instance != null ? instance : new ConsoleCLIDownloadSpec();
    if (instance != null) {
        this.withDescription(instance.getDescription());
        this.withDisplayName(instance.getDisplayName());
        this.withLinks(instance.getLinks());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public LinksNested<A> editFirstLink() {
    if (links.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "links"));
    }
    return this.setNewLinkLike(0, this.buildLink(0));
  }
  
  public LinksNested<A> editLastLink() {
    int index = links.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "links"));
    }
    return this.setNewLinkLike(index, this.buildLink(index));
  }
  
  public LinksNested<A> editLink(int index) {
    if (links.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "links"));
    }
    return this.setNewLinkLike(index, this.buildLink(index));
  }
  
  public LinksNested<A> editMatchingLink(Predicate<CLIDownloadLinkBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < links.size();i++) {
      if (predicate.test(links.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "links"));
    }
    return this.setNewLinkLike(index, this.buildLink(index));
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
    ConsoleCLIDownloadSpecFluent that = (ConsoleCLIDownloadSpecFluent) o;
    if (!(Objects.equals(description, that.description))) {
      return false;
    }
    if (!(Objects.equals(displayName, that.displayName))) {
      return false;
    }
    if (!(Objects.equals(links, that.links))) {
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
  
  public String getDescription() {
    return this.description;
  }
  
  public String getDisplayName() {
    return this.displayName;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasDescription() {
    return this.description != null;
  }
  
  public boolean hasDisplayName() {
    return this.displayName != null;
  }
  
  public boolean hasLinks() {
    return this.links != null && !(this.links.isEmpty());
  }
  
  public boolean hasMatchingLink(Predicate<CLIDownloadLinkBuilder> predicate) {
      for (CLIDownloadLinkBuilder item : links) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public int hashCode() {
    return Objects.hash(description, displayName, links, additionalProperties);
  }
  
  public A removeAllFromLinks(Collection<CLIDownloadLink> items) {
    if (this.links == null) {
      return (A) this;
    }
    for (CLIDownloadLink item : items) {
        CLIDownloadLinkBuilder builder = new CLIDownloadLinkBuilder(item);
        _visitables.get("links").remove(builder);
        this.links.remove(builder);
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
  
  public A removeFromLinks(CLIDownloadLink... items) {
    if (this.links == null) {
      return (A) this;
    }
    for (CLIDownloadLink item : items) {
        CLIDownloadLinkBuilder builder = new CLIDownloadLinkBuilder(item);
        _visitables.get("links").remove(builder);
        this.links.remove(builder);
    }
    return (A) this;
  }
  
  public A removeMatchingFromLinks(Predicate<CLIDownloadLinkBuilder> predicate) {
    if (links == null) {
      return (A) this;
    }
    Iterator<CLIDownloadLinkBuilder> each = links.iterator();
    List visitables = _visitables.get("links");
    while (each.hasNext()) {
        CLIDownloadLinkBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public LinksNested<A> setNewLinkLike(int index,CLIDownloadLink item) {
    return new LinksNested(index, item);
  }
  
  public A setToLinks(int index,CLIDownloadLink item) {
    if (this.links == null) {
      this.links = new ArrayList();
    }
    CLIDownloadLinkBuilder builder = new CLIDownloadLinkBuilder(item);
    if (index < 0 || index >= links.size()) {
        _visitables.get("links").add(builder);
        links.add(builder);
    } else {
        _visitables.get("links").add(builder);
        links.set(index, builder);
    }
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(description == null)) {
        sb.append("description:");
        sb.append(description);
        sb.append(",");
    }
    if (!(displayName == null)) {
        sb.append("displayName:");
        sb.append(displayName);
        sb.append(",");
    }
    if (!(links == null) && !(links.isEmpty())) {
        sb.append("links:");
        sb.append(links);
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
  
  public A withDescription(String description) {
    this.description = description;
    return (A) this;
  }
  
  public A withDisplayName(String displayName) {
    this.displayName = displayName;
    return (A) this;
  }
  
  public A withLinks(List<CLIDownloadLink> links) {
    if (this.links != null) {
      this._visitables.get("links").clear();
    }
    if (links != null) {
        this.links = new ArrayList();
        for (CLIDownloadLink item : links) {
          this.addToLinks(item);
        }
    } else {
      this.links = null;
    }
    return (A) this;
  }
  
  public A withLinks(CLIDownloadLink... links) {
    if (this.links != null) {
        this.links.clear();
        _visitables.remove("links");
    }
    if (links != null) {
      for (CLIDownloadLink item : links) {
        this.addToLinks(item);
      }
    }
    return (A) this;
  }
  public class LinksNested<N> extends CLIDownloadLinkFluent<LinksNested<N>> implements Nested<N>{
  
    CLIDownloadLinkBuilder builder;
    int index;
  
    LinksNested(int index,CLIDownloadLink item) {
      this.index = index;
      this.builder = new CLIDownloadLinkBuilder(this, item);
    }
  
    public N and() {
      return (N) ConsoleCLIDownloadSpecFluent.this.setToLinks(index, builder.build());
    }
    
    public N endLink() {
      return and();
    }
    
  }
}