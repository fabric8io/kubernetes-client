package io.fabric8.openclustermanagement.api.model.policy.v1;

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
public class PolicyStatusFluent<A extends io.fabric8.openclustermanagement.api.model.policy.v1.PolicyStatusFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String compliant;
  private ArrayList<DetailsPerTemplateBuilder> details = new ArrayList<DetailsPerTemplateBuilder>();
  private ArrayList<PlacementBuilder> placement = new ArrayList<PlacementBuilder>();
  private ArrayList<CompliancePerClusterStatusBuilder> status = new ArrayList<CompliancePerClusterStatusBuilder>();

  public PolicyStatusFluent() {
  }
  
  public PolicyStatusFluent(PolicyStatus instance) {
    this.copyInstance(instance);
  }

  public A addAllToDetails(Collection<DetailsPerTemplate> items) {
    if (this.details == null) {
      this.details = new ArrayList();
    }
    for (DetailsPerTemplate item : items) {
        DetailsPerTemplateBuilder builder = new DetailsPerTemplateBuilder(item);
        _visitables.get("details").add(builder);
        this.details.add(builder);
    }
    return (A) this;
  }
  
  public A addAllToPlacement(Collection<Placement> items) {
    if (this.placement == null) {
      this.placement = new ArrayList();
    }
    for (Placement item : items) {
        PlacementBuilder builder = new PlacementBuilder(item);
        _visitables.get("placement").add(builder);
        this.placement.add(builder);
    }
    return (A) this;
  }
  
  public A addAllToStatus(Collection<CompliancePerClusterStatus> items) {
    if (this.status == null) {
      this.status = new ArrayList();
    }
    for (CompliancePerClusterStatus item : items) {
        CompliancePerClusterStatusBuilder builder = new CompliancePerClusterStatusBuilder(item);
        _visitables.get("status").add(builder);
        this.status.add(builder);
    }
    return (A) this;
  }
  
  public DetailsNested<A> addNewDetail() {
    return new DetailsNested(-1, null);
  }
  
  public DetailsNested<A> addNewDetailLike(DetailsPerTemplate item) {
    return new DetailsNested(-1, item);
  }
  
  public PlacementNested<A> addNewPlacement() {
    return new PlacementNested(-1, null);
  }
  
  public PlacementNested<A> addNewPlacementLike(Placement item) {
    return new PlacementNested(-1, item);
  }
  
  public StatusNested<A> addNewStatus() {
    return new StatusNested(-1, null);
  }
  
  public A addNewStatus(String clustername,String clusternamespace,String compliant) {
    return (A) this.addToStatus(new CompliancePerClusterStatus(clustername, clusternamespace, compliant));
  }
  
  public StatusNested<A> addNewStatusLike(CompliancePerClusterStatus item) {
    return new StatusNested(-1, item);
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
  
  public A addToDetails(DetailsPerTemplate... items) {
    if (this.details == null) {
      this.details = new ArrayList();
    }
    for (DetailsPerTemplate item : items) {
        DetailsPerTemplateBuilder builder = new DetailsPerTemplateBuilder(item);
        _visitables.get("details").add(builder);
        this.details.add(builder);
    }
    return (A) this;
  }
  
  public A addToDetails(int index,DetailsPerTemplate item) {
    if (this.details == null) {
      this.details = new ArrayList();
    }
    DetailsPerTemplateBuilder builder = new DetailsPerTemplateBuilder(item);
    if (index < 0 || index >= details.size()) {
        _visitables.get("details").add(builder);
        details.add(builder);
    } else {
        _visitables.get("details").add(builder);
        details.add(index, builder);
    }
    return (A) this;
  }
  
  public A addToPlacement(Placement... items) {
    if (this.placement == null) {
      this.placement = new ArrayList();
    }
    for (Placement item : items) {
        PlacementBuilder builder = new PlacementBuilder(item);
        _visitables.get("placement").add(builder);
        this.placement.add(builder);
    }
    return (A) this;
  }
  
  public A addToPlacement(int index,Placement item) {
    if (this.placement == null) {
      this.placement = new ArrayList();
    }
    PlacementBuilder builder = new PlacementBuilder(item);
    if (index < 0 || index >= placement.size()) {
        _visitables.get("placement").add(builder);
        placement.add(builder);
    } else {
        _visitables.get("placement").add(builder);
        placement.add(index, builder);
    }
    return (A) this;
  }
  
  public A addToStatus(CompliancePerClusterStatus... items) {
    if (this.status == null) {
      this.status = new ArrayList();
    }
    for (CompliancePerClusterStatus item : items) {
        CompliancePerClusterStatusBuilder builder = new CompliancePerClusterStatusBuilder(item);
        _visitables.get("status").add(builder);
        this.status.add(builder);
    }
    return (A) this;
  }
  
  public A addToStatus(int index,CompliancePerClusterStatus item) {
    if (this.status == null) {
      this.status = new ArrayList();
    }
    CompliancePerClusterStatusBuilder builder = new CompliancePerClusterStatusBuilder(item);
    if (index < 0 || index >= status.size()) {
        _visitables.get("status").add(builder);
        status.add(builder);
    } else {
        _visitables.get("status").add(builder);
        status.add(index, builder);
    }
    return (A) this;
  }
  
  public DetailsPerTemplate buildDetail(int index) {
    return this.details.get(index).build();
  }
  
  public List<DetailsPerTemplate> buildDetails() {
    return this.details != null ? build(details) : null;
  }
  
  public DetailsPerTemplate buildFirstDetail() {
    return this.details.get(0).build();
  }
  
  public Placement buildFirstPlacement() {
    return this.placement.get(0).build();
  }
  
  public CompliancePerClusterStatus buildFirstStatus() {
    return this.status.get(0).build();
  }
  
  public DetailsPerTemplate buildLastDetail() {
    return this.details.get(details.size() - 1).build();
  }
  
  public Placement buildLastPlacement() {
    return this.placement.get(placement.size() - 1).build();
  }
  
  public CompliancePerClusterStatus buildLastStatus() {
    return this.status.get(status.size() - 1).build();
  }
  
  public DetailsPerTemplate buildMatchingDetail(Predicate<DetailsPerTemplateBuilder> predicate) {
      for (DetailsPerTemplateBuilder item : details) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public Placement buildMatchingPlacement(Predicate<PlacementBuilder> predicate) {
      for (PlacementBuilder item : placement) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public CompliancePerClusterStatus buildMatchingStatus(Predicate<CompliancePerClusterStatusBuilder> predicate) {
      for (CompliancePerClusterStatusBuilder item : status) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public List<Placement> buildPlacement() {
    return this.placement != null ? build(placement) : null;
  }
  
  public Placement buildPlacement(int index) {
    return this.placement.get(index).build();
  }
  
  public List<CompliancePerClusterStatus> buildStatus() {
    return this.status != null ? build(status) : null;
  }
  
  public CompliancePerClusterStatus buildStatus(int index) {
    return this.status.get(index).build();
  }
  
  protected void copyInstance(PolicyStatus instance) {
    instance = instance != null ? instance : new PolicyStatus();
    if (instance != null) {
        this.withCompliant(instance.getCompliant());
        this.withDetails(instance.getDetails());
        this.withPlacement(instance.getPlacement());
        this.withStatus(instance.getStatus());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public DetailsNested<A> editDetail(int index) {
    if (details.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "details"));
    }
    return this.setNewDetailLike(index, this.buildDetail(index));
  }
  
  public DetailsNested<A> editFirstDetail() {
    if (details.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "details"));
    }
    return this.setNewDetailLike(0, this.buildDetail(0));
  }
  
  public PlacementNested<A> editFirstPlacement() {
    if (placement.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "placement"));
    }
    return this.setNewPlacementLike(0, this.buildPlacement(0));
  }
  
  public StatusNested<A> editFirstStatus() {
    if (status.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "status"));
    }
    return this.setNewStatusLike(0, this.buildStatus(0));
  }
  
  public DetailsNested<A> editLastDetail() {
    int index = details.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "details"));
    }
    return this.setNewDetailLike(index, this.buildDetail(index));
  }
  
  public PlacementNested<A> editLastPlacement() {
    int index = placement.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "placement"));
    }
    return this.setNewPlacementLike(index, this.buildPlacement(index));
  }
  
  public StatusNested<A> editLastStatus() {
    int index = status.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "status"));
    }
    return this.setNewStatusLike(index, this.buildStatus(index));
  }
  
  public DetailsNested<A> editMatchingDetail(Predicate<DetailsPerTemplateBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < details.size();i++) {
      if (predicate.test(details.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "details"));
    }
    return this.setNewDetailLike(index, this.buildDetail(index));
  }
  
  public PlacementNested<A> editMatchingPlacement(Predicate<PlacementBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < placement.size();i++) {
      if (predicate.test(placement.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "placement"));
    }
    return this.setNewPlacementLike(index, this.buildPlacement(index));
  }
  
  public StatusNested<A> editMatchingStatus(Predicate<CompliancePerClusterStatusBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < status.size();i++) {
      if (predicate.test(status.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "status"));
    }
    return this.setNewStatusLike(index, this.buildStatus(index));
  }
  
  public PlacementNested<A> editPlacement(int index) {
    if (placement.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "placement"));
    }
    return this.setNewPlacementLike(index, this.buildPlacement(index));
  }
  
  public StatusNested<A> editStatus(int index) {
    if (status.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "status"));
    }
    return this.setNewStatusLike(index, this.buildStatus(index));
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
    PolicyStatusFluent that = (PolicyStatusFluent) o;
    if (!(Objects.equals(compliant, that.compliant))) {
      return false;
    }
    if (!(Objects.equals(details, that.details))) {
      return false;
    }
    if (!(Objects.equals(placement, that.placement))) {
      return false;
    }
    if (!(Objects.equals(status, that.status))) {
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
  
  public String getCompliant() {
    return this.compliant;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasCompliant() {
    return this.compliant != null;
  }
  
  public boolean hasDetails() {
    return this.details != null && !(this.details.isEmpty());
  }
  
  public boolean hasMatchingDetail(Predicate<DetailsPerTemplateBuilder> predicate) {
      for (DetailsPerTemplateBuilder item : details) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingPlacement(Predicate<PlacementBuilder> predicate) {
      for (PlacementBuilder item : placement) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingStatus(Predicate<CompliancePerClusterStatusBuilder> predicate) {
      for (CompliancePerClusterStatusBuilder item : status) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasPlacement() {
    return this.placement != null && !(this.placement.isEmpty());
  }
  
  public boolean hasStatus() {
    return this.status != null && !(this.status.isEmpty());
  }
  
  public int hashCode() {
    return Objects.hash(compliant, details, placement, status, additionalProperties);
  }
  
  public A removeAllFromDetails(Collection<DetailsPerTemplate> items) {
    if (this.details == null) {
      return (A) this;
    }
    for (DetailsPerTemplate item : items) {
        DetailsPerTemplateBuilder builder = new DetailsPerTemplateBuilder(item);
        _visitables.get("details").remove(builder);
        this.details.remove(builder);
    }
    return (A) this;
  }
  
  public A removeAllFromPlacement(Collection<Placement> items) {
    if (this.placement == null) {
      return (A) this;
    }
    for (Placement item : items) {
        PlacementBuilder builder = new PlacementBuilder(item);
        _visitables.get("placement").remove(builder);
        this.placement.remove(builder);
    }
    return (A) this;
  }
  
  public A removeAllFromStatus(Collection<CompliancePerClusterStatus> items) {
    if (this.status == null) {
      return (A) this;
    }
    for (CompliancePerClusterStatus item : items) {
        CompliancePerClusterStatusBuilder builder = new CompliancePerClusterStatusBuilder(item);
        _visitables.get("status").remove(builder);
        this.status.remove(builder);
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
  
  public A removeFromDetails(DetailsPerTemplate... items) {
    if (this.details == null) {
      return (A) this;
    }
    for (DetailsPerTemplate item : items) {
        DetailsPerTemplateBuilder builder = new DetailsPerTemplateBuilder(item);
        _visitables.get("details").remove(builder);
        this.details.remove(builder);
    }
    return (A) this;
  }
  
  public A removeFromPlacement(Placement... items) {
    if (this.placement == null) {
      return (A) this;
    }
    for (Placement item : items) {
        PlacementBuilder builder = new PlacementBuilder(item);
        _visitables.get("placement").remove(builder);
        this.placement.remove(builder);
    }
    return (A) this;
  }
  
  public A removeFromStatus(CompliancePerClusterStatus... items) {
    if (this.status == null) {
      return (A) this;
    }
    for (CompliancePerClusterStatus item : items) {
        CompliancePerClusterStatusBuilder builder = new CompliancePerClusterStatusBuilder(item);
        _visitables.get("status").remove(builder);
        this.status.remove(builder);
    }
    return (A) this;
  }
  
  public A removeMatchingFromDetails(Predicate<DetailsPerTemplateBuilder> predicate) {
    if (details == null) {
      return (A) this;
    }
    Iterator<DetailsPerTemplateBuilder> each = details.iterator();
    List visitables = _visitables.get("details");
    while (each.hasNext()) {
        DetailsPerTemplateBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public A removeMatchingFromPlacement(Predicate<PlacementBuilder> predicate) {
    if (placement == null) {
      return (A) this;
    }
    Iterator<PlacementBuilder> each = placement.iterator();
    List visitables = _visitables.get("placement");
    while (each.hasNext()) {
        PlacementBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public A removeMatchingFromStatus(Predicate<CompliancePerClusterStatusBuilder> predicate) {
    if (status == null) {
      return (A) this;
    }
    Iterator<CompliancePerClusterStatusBuilder> each = status.iterator();
    List visitables = _visitables.get("status");
    while (each.hasNext()) {
        CompliancePerClusterStatusBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public DetailsNested<A> setNewDetailLike(int index,DetailsPerTemplate item) {
    return new DetailsNested(index, item);
  }
  
  public PlacementNested<A> setNewPlacementLike(int index,Placement item) {
    return new PlacementNested(index, item);
  }
  
  public StatusNested<A> setNewStatusLike(int index,CompliancePerClusterStatus item) {
    return new StatusNested(index, item);
  }
  
  public A setToDetails(int index,DetailsPerTemplate item) {
    if (this.details == null) {
      this.details = new ArrayList();
    }
    DetailsPerTemplateBuilder builder = new DetailsPerTemplateBuilder(item);
    if (index < 0 || index >= details.size()) {
        _visitables.get("details").add(builder);
        details.add(builder);
    } else {
        _visitables.get("details").add(builder);
        details.set(index, builder);
    }
    return (A) this;
  }
  
  public A setToPlacement(int index,Placement item) {
    if (this.placement == null) {
      this.placement = new ArrayList();
    }
    PlacementBuilder builder = new PlacementBuilder(item);
    if (index < 0 || index >= placement.size()) {
        _visitables.get("placement").add(builder);
        placement.add(builder);
    } else {
        _visitables.get("placement").add(builder);
        placement.set(index, builder);
    }
    return (A) this;
  }
  
  public A setToStatus(int index,CompliancePerClusterStatus item) {
    if (this.status == null) {
      this.status = new ArrayList();
    }
    CompliancePerClusterStatusBuilder builder = new CompliancePerClusterStatusBuilder(item);
    if (index < 0 || index >= status.size()) {
        _visitables.get("status").add(builder);
        status.add(builder);
    } else {
        _visitables.get("status").add(builder);
        status.set(index, builder);
    }
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(compliant == null)) {
        sb.append("compliant:");
        sb.append(compliant);
        sb.append(",");
    }
    if (!(details == null) && !(details.isEmpty())) {
        sb.append("details:");
        sb.append(details);
        sb.append(",");
    }
    if (!(placement == null) && !(placement.isEmpty())) {
        sb.append("placement:");
        sb.append(placement);
        sb.append(",");
    }
    if (!(status == null) && !(status.isEmpty())) {
        sb.append("status:");
        sb.append(status);
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
  
  public A withCompliant(String compliant) {
    this.compliant = compliant;
    return (A) this;
  }
  
  public A withDetails(List<DetailsPerTemplate> details) {
    if (this.details != null) {
      this._visitables.get("details").clear();
    }
    if (details != null) {
        this.details = new ArrayList();
        for (DetailsPerTemplate item : details) {
          this.addToDetails(item);
        }
    } else {
      this.details = null;
    }
    return (A) this;
  }
  
  public A withDetails(DetailsPerTemplate... details) {
    if (this.details != null) {
        this.details.clear();
        _visitables.remove("details");
    }
    if (details != null) {
      for (DetailsPerTemplate item : details) {
        this.addToDetails(item);
      }
    }
    return (A) this;
  }
  
  public A withPlacement(List<Placement> placement) {
    if (this.placement != null) {
      this._visitables.get("placement").clear();
    }
    if (placement != null) {
        this.placement = new ArrayList();
        for (Placement item : placement) {
          this.addToPlacement(item);
        }
    } else {
      this.placement = null;
    }
    return (A) this;
  }
  
  public A withPlacement(Placement... placement) {
    if (this.placement != null) {
        this.placement.clear();
        _visitables.remove("placement");
    }
    if (placement != null) {
      for (Placement item : placement) {
        this.addToPlacement(item);
      }
    }
    return (A) this;
  }
  
  public A withStatus(List<CompliancePerClusterStatus> status) {
    if (this.status != null) {
      this._visitables.get("status").clear();
    }
    if (status != null) {
        this.status = new ArrayList();
        for (CompliancePerClusterStatus item : status) {
          this.addToStatus(item);
        }
    } else {
      this.status = null;
    }
    return (A) this;
  }
  
  public A withStatus(CompliancePerClusterStatus... status) {
    if (this.status != null) {
        this.status.clear();
        _visitables.remove("status");
    }
    if (status != null) {
      for (CompliancePerClusterStatus item : status) {
        this.addToStatus(item);
      }
    }
    return (A) this;
  }
  public class DetailsNested<N> extends DetailsPerTemplateFluent<DetailsNested<N>> implements Nested<N>{
  
    DetailsPerTemplateBuilder builder;
    int index;
  
    DetailsNested(int index,DetailsPerTemplate item) {
      this.index = index;
      this.builder = new DetailsPerTemplateBuilder(this, item);
    }
  
    public N and() {
      return (N) PolicyStatusFluent.this.setToDetails(index, builder.build());
    }
    
    public N endDetail() {
      return and();
    }
    
  }
  public class PlacementNested<N> extends PlacementFluent<PlacementNested<N>> implements Nested<N>{
  
    PlacementBuilder builder;
    int index;
  
    PlacementNested(int index,Placement item) {
      this.index = index;
      this.builder = new PlacementBuilder(this, item);
    }
  
    public N and() {
      return (N) PolicyStatusFluent.this.setToPlacement(index, builder.build());
    }
    
    public N endPlacement() {
      return and();
    }
    
  }
  public class StatusNested<N> extends CompliancePerClusterStatusFluent<StatusNested<N>> implements Nested<N>{
  
    CompliancePerClusterStatusBuilder builder;
    int index;
  
    StatusNested(int index,CompliancePerClusterStatus item) {
      this.index = index;
      this.builder = new CompliancePerClusterStatusBuilder(this, item);
    }
  
    public N and() {
      return (N) PolicyStatusFluent.this.setToStatus(index, builder.build());
    }
    
    public N endStatus() {
      return and();
    }
    
  }
}