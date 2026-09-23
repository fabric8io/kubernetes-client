package io.fabric8.openshift.api.model.config.v1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import java.lang.Boolean;
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
public class UpdateFluent<A extends io.fabric8.openshift.api.model.config.v1.UpdateFluent<A>> extends BaseFluent<A>{

  private ArrayList<AcceptRiskBuilder> acceptRisks = new ArrayList<AcceptRiskBuilder>();
  private Map<String,Object> additionalProperties;
  private String architecture;
  private Boolean force;
  private String image;
  private String mode;
  private String version;

  public UpdateFluent() {
  }
  
  public UpdateFluent(Update instance) {
    this.copyInstance(instance);
  }

  public A addAllToAcceptRisks(Collection<AcceptRisk> items) {
    if (this.acceptRisks == null) {
      this.acceptRisks = new ArrayList();
    }
    for (AcceptRisk item : items) {
        AcceptRiskBuilder builder = new AcceptRiskBuilder(item);
        _visitables.get("acceptRisks").add(builder);
        this.acceptRisks.add(builder);
    }
    return (A) this;
  }
  
  public AcceptRisksNested<A> addNewAcceptRisk() {
    return new AcceptRisksNested(-1, null);
  }
  
  public A addNewAcceptRisk(String name) {
    return (A) this.addToAcceptRisks(new AcceptRisk(name));
  }
  
  public AcceptRisksNested<A> addNewAcceptRiskLike(AcceptRisk item) {
    return new AcceptRisksNested(-1, item);
  }
  
  public A addToAcceptRisks(AcceptRisk... items) {
    if (this.acceptRisks == null) {
      this.acceptRisks = new ArrayList();
    }
    for (AcceptRisk item : items) {
        AcceptRiskBuilder builder = new AcceptRiskBuilder(item);
        _visitables.get("acceptRisks").add(builder);
        this.acceptRisks.add(builder);
    }
    return (A) this;
  }
  
  public A addToAcceptRisks(int index,AcceptRisk item) {
    if (this.acceptRisks == null) {
      this.acceptRisks = new ArrayList();
    }
    AcceptRiskBuilder builder = new AcceptRiskBuilder(item);
    if (index < 0 || index >= acceptRisks.size()) {
        _visitables.get("acceptRisks").add(builder);
        acceptRisks.add(builder);
    } else {
        _visitables.get("acceptRisks").add(builder);
        acceptRisks.add(index, builder);
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
  
  public AcceptRisk buildAcceptRisk(int index) {
    return this.acceptRisks.get(index).build();
  }
  
  public List<AcceptRisk> buildAcceptRisks() {
    return this.acceptRisks != null ? build(acceptRisks) : null;
  }
  
  public AcceptRisk buildFirstAcceptRisk() {
    return this.acceptRisks.get(0).build();
  }
  
  public AcceptRisk buildLastAcceptRisk() {
    return this.acceptRisks.get(acceptRisks.size() - 1).build();
  }
  
  public AcceptRisk buildMatchingAcceptRisk(Predicate<AcceptRiskBuilder> predicate) {
      for (AcceptRiskBuilder item : acceptRisks) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  protected void copyInstance(Update instance) {
    instance = instance != null ? instance : new Update();
    if (instance != null) {
        this.withAcceptRisks(instance.getAcceptRisks());
        this.withArchitecture(instance.getArchitecture());
        this.withForce(instance.getForce());
        this.withImage(instance.getImage());
        this.withMode(instance.getMode());
        this.withVersion(instance.getVersion());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public AcceptRisksNested<A> editAcceptRisk(int index) {
    if (acceptRisks.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "acceptRisks"));
    }
    return this.setNewAcceptRiskLike(index, this.buildAcceptRisk(index));
  }
  
  public AcceptRisksNested<A> editFirstAcceptRisk() {
    if (acceptRisks.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "acceptRisks"));
    }
    return this.setNewAcceptRiskLike(0, this.buildAcceptRisk(0));
  }
  
  public AcceptRisksNested<A> editLastAcceptRisk() {
    int index = acceptRisks.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "acceptRisks"));
    }
    return this.setNewAcceptRiskLike(index, this.buildAcceptRisk(index));
  }
  
  public AcceptRisksNested<A> editMatchingAcceptRisk(Predicate<AcceptRiskBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < acceptRisks.size();i++) {
      if (predicate.test(acceptRisks.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "acceptRisks"));
    }
    return this.setNewAcceptRiskLike(index, this.buildAcceptRisk(index));
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
    UpdateFluent that = (UpdateFluent) o;
    if (!(Objects.equals(acceptRisks, that.acceptRisks))) {
      return false;
    }
    if (!(Objects.equals(architecture, that.architecture))) {
      return false;
    }
    if (!(Objects.equals(force, that.force))) {
      return false;
    }
    if (!(Objects.equals(image, that.image))) {
      return false;
    }
    if (!(Objects.equals(mode, that.mode))) {
      return false;
    }
    if (!(Objects.equals(version, that.version))) {
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
  
  public String getArchitecture() {
    return this.architecture;
  }
  
  public Boolean getForce() {
    return this.force;
  }
  
  public String getImage() {
    return this.image;
  }
  
  public String getMode() {
    return this.mode;
  }
  
  public String getVersion() {
    return this.version;
  }
  
  public boolean hasAcceptRisks() {
    return this.acceptRisks != null && !(this.acceptRisks.isEmpty());
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasArchitecture() {
    return this.architecture != null;
  }
  
  public boolean hasForce() {
    return this.force != null;
  }
  
  public boolean hasImage() {
    return this.image != null;
  }
  
  public boolean hasMatchingAcceptRisk(Predicate<AcceptRiskBuilder> predicate) {
      for (AcceptRiskBuilder item : acceptRisks) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMode() {
    return this.mode != null;
  }
  
  public boolean hasVersion() {
    return this.version != null;
  }
  
  public int hashCode() {
    return Objects.hash(acceptRisks, architecture, force, image, mode, version, additionalProperties);
  }
  
  public A removeAllFromAcceptRisks(Collection<AcceptRisk> items) {
    if (this.acceptRisks == null) {
      return (A) this;
    }
    for (AcceptRisk item : items) {
        AcceptRiskBuilder builder = new AcceptRiskBuilder(item);
        _visitables.get("acceptRisks").remove(builder);
        this.acceptRisks.remove(builder);
    }
    return (A) this;
  }
  
  public A removeFromAcceptRisks(AcceptRisk... items) {
    if (this.acceptRisks == null) {
      return (A) this;
    }
    for (AcceptRisk item : items) {
        AcceptRiskBuilder builder = new AcceptRiskBuilder(item);
        _visitables.get("acceptRisks").remove(builder);
        this.acceptRisks.remove(builder);
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
  
  public A removeMatchingFromAcceptRisks(Predicate<AcceptRiskBuilder> predicate) {
    if (acceptRisks == null) {
      return (A) this;
    }
    Iterator<AcceptRiskBuilder> each = acceptRisks.iterator();
    List visitables = _visitables.get("acceptRisks");
    while (each.hasNext()) {
        AcceptRiskBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public AcceptRisksNested<A> setNewAcceptRiskLike(int index,AcceptRisk item) {
    return new AcceptRisksNested(index, item);
  }
  
  public A setToAcceptRisks(int index,AcceptRisk item) {
    if (this.acceptRisks == null) {
      this.acceptRisks = new ArrayList();
    }
    AcceptRiskBuilder builder = new AcceptRiskBuilder(item);
    if (index < 0 || index >= acceptRisks.size()) {
        _visitables.get("acceptRisks").add(builder);
        acceptRisks.add(builder);
    } else {
        _visitables.get("acceptRisks").add(builder);
        acceptRisks.set(index, builder);
    }
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(acceptRisks == null) && !(acceptRisks.isEmpty())) {
        sb.append("acceptRisks:");
        sb.append(acceptRisks);
        sb.append(",");
    }
    if (!(architecture == null)) {
        sb.append("architecture:");
        sb.append(architecture);
        sb.append(",");
    }
    if (!(force == null)) {
        sb.append("force:");
        sb.append(force);
        sb.append(",");
    }
    if (!(image == null)) {
        sb.append("image:");
        sb.append(image);
        sb.append(",");
    }
    if (!(mode == null)) {
        sb.append("mode:");
        sb.append(mode);
        sb.append(",");
    }
    if (!(version == null)) {
        sb.append("version:");
        sb.append(version);
        sb.append(",");
    }
    if (!(additionalProperties == null) && !(additionalProperties.isEmpty())) {
        sb.append("additionalProperties:");
        sb.append(additionalProperties);
    }
    sb.append("}");
    return sb.toString();
  }
  
  public A withAcceptRisks(List<AcceptRisk> acceptRisks) {
    if (this.acceptRisks != null) {
      this._visitables.get("acceptRisks").clear();
    }
    if (acceptRisks != null) {
        this.acceptRisks = new ArrayList();
        for (AcceptRisk item : acceptRisks) {
          this.addToAcceptRisks(item);
        }
    } else {
      this.acceptRisks = null;
    }
    return (A) this;
  }
  
  public A withAcceptRisks(AcceptRisk... acceptRisks) {
    if (this.acceptRisks != null) {
        this.acceptRisks.clear();
        _visitables.remove("acceptRisks");
    }
    if (acceptRisks != null) {
      for (AcceptRisk item : acceptRisks) {
        this.addToAcceptRisks(item);
      }
    }
    return (A) this;
  }
  
  public <K,V>A withAdditionalProperties(Map<String,Object> additionalProperties) {
    if (additionalProperties == null) {
      this.additionalProperties = null;
    } else {
      this.additionalProperties = new LinkedHashMap(additionalProperties);
    }
    return (A) this;
  }
  
  public A withArchitecture(String architecture) {
    this.architecture = architecture;
    return (A) this;
  }
  
  public A withForce() {
    return withForce(true);
  }
  
  public A withForce(Boolean force) {
    this.force = force;
    return (A) this;
  }
  
  public A withImage(String image) {
    this.image = image;
    return (A) this;
  }
  
  public A withMode(String mode) {
    this.mode = mode;
    return (A) this;
  }
  
  public A withVersion(String version) {
    this.version = version;
    return (A) this;
  }
  public class AcceptRisksNested<N> extends AcceptRiskFluent<AcceptRisksNested<N>> implements Nested<N>{
  
    AcceptRiskBuilder builder;
    int index;
  
    AcceptRisksNested(int index,AcceptRisk item) {
      this.index = index;
      this.builder = new AcceptRiskBuilder(this, item);
    }
  
    public N and() {
      return (N) UpdateFluent.this.setToAcceptRisks(index, builder.build());
    }
    
    public N endAcceptRisk() {
      return and();
    }
    
  }
}