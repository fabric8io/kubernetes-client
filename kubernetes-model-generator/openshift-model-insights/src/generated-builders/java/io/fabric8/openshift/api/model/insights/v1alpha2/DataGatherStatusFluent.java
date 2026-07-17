package io.fabric8.openshift.api.model.insights.v1alpha2;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import io.fabric8.kubernetes.api.model.Condition;
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
import java.util.Optional;
import java.util.function.Predicate;

/**
 * Generated
 */
@SuppressWarnings("unchecked")
public class DataGatherStatusFluent<A extends io.fabric8.openshift.api.model.insights.v1alpha2.DataGatherStatusFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private List<Condition> conditions = new ArrayList<Condition>();
  private String finishTime;
  private ArrayList<GathererStatusBuilder> gatherers = new ArrayList<GathererStatusBuilder>();
  private InsightsReportBuilder insightsReport;
  private String insightsRequestID;
  private ArrayList<ObjectReferenceBuilder> relatedObjects = new ArrayList<ObjectReferenceBuilder>();
  private String startTime;

  public DataGatherStatusFluent() {
  }
  
  public DataGatherStatusFluent(DataGatherStatus instance) {
    this.copyInstance(instance);
  }

  public A addAllToConditions(Collection<Condition> items) {
    if (this.conditions == null) {
      this.conditions = new ArrayList();
    }
    for (Condition item : items) {
      this.conditions.add(item);
    }
    return (A) this;
  }
  
  public A addAllToGatherers(Collection<GathererStatus> items) {
    if (this.gatherers == null) {
      this.gatherers = new ArrayList();
    }
    for (GathererStatus item : items) {
        GathererStatusBuilder builder = new GathererStatusBuilder(item);
        _visitables.get("gatherers").add(builder);
        this.gatherers.add(builder);
    }
    return (A) this;
  }
  
  public A addAllToRelatedObjects(Collection<ObjectReference> items) {
    if (this.relatedObjects == null) {
      this.relatedObjects = new ArrayList();
    }
    for (ObjectReference item : items) {
        ObjectReferenceBuilder builder = new ObjectReferenceBuilder(item);
        _visitables.get("relatedObjects").add(builder);
        this.relatedObjects.add(builder);
    }
    return (A) this;
  }
  
  public GatherersNested<A> addNewGatherer() {
    return new GatherersNested(-1, null);
  }
  
  public GatherersNested<A> addNewGathererLike(GathererStatus item) {
    return new GatherersNested(-1, item);
  }
  
  public RelatedObjectsNested<A> addNewRelatedObject() {
    return new RelatedObjectsNested(-1, null);
  }
  
  public A addNewRelatedObject(String group,String name,String namespace,String resource) {
    return (A) this.addToRelatedObjects(new ObjectReference(group, name, namespace, resource));
  }
  
  public RelatedObjectsNested<A> addNewRelatedObjectLike(ObjectReference item) {
    return new RelatedObjectsNested(-1, item);
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
  
  public A addToConditions(Condition... items) {
    if (this.conditions == null) {
      this.conditions = new ArrayList();
    }
    for (Condition item : items) {
      this.conditions.add(item);
    }
    return (A) this;
  }
  
  public A addToConditions(int index,Condition item) {
    if (this.conditions == null) {
      this.conditions = new ArrayList();
    }
    this.conditions.add(index, item);
    return (A) this;
  }
  
  public A addToGatherers(GathererStatus... items) {
    if (this.gatherers == null) {
      this.gatherers = new ArrayList();
    }
    for (GathererStatus item : items) {
        GathererStatusBuilder builder = new GathererStatusBuilder(item);
        _visitables.get("gatherers").add(builder);
        this.gatherers.add(builder);
    }
    return (A) this;
  }
  
  public A addToGatherers(int index,GathererStatus item) {
    if (this.gatherers == null) {
      this.gatherers = new ArrayList();
    }
    GathererStatusBuilder builder = new GathererStatusBuilder(item);
    if (index < 0 || index >= gatherers.size()) {
        _visitables.get("gatherers").add(builder);
        gatherers.add(builder);
    } else {
        _visitables.get("gatherers").add(builder);
        gatherers.add(index, builder);
    }
    return (A) this;
  }
  
  public A addToRelatedObjects(ObjectReference... items) {
    if (this.relatedObjects == null) {
      this.relatedObjects = new ArrayList();
    }
    for (ObjectReference item : items) {
        ObjectReferenceBuilder builder = new ObjectReferenceBuilder(item);
        _visitables.get("relatedObjects").add(builder);
        this.relatedObjects.add(builder);
    }
    return (A) this;
  }
  
  public A addToRelatedObjects(int index,ObjectReference item) {
    if (this.relatedObjects == null) {
      this.relatedObjects = new ArrayList();
    }
    ObjectReferenceBuilder builder = new ObjectReferenceBuilder(item);
    if (index < 0 || index >= relatedObjects.size()) {
        _visitables.get("relatedObjects").add(builder);
        relatedObjects.add(builder);
    } else {
        _visitables.get("relatedObjects").add(builder);
        relatedObjects.add(index, builder);
    }
    return (A) this;
  }
  
  public GathererStatus buildFirstGatherer() {
    return this.gatherers.get(0).build();
  }
  
  public ObjectReference buildFirstRelatedObject() {
    return this.relatedObjects.get(0).build();
  }
  
  public GathererStatus buildGatherer(int index) {
    return this.gatherers.get(index).build();
  }
  
  public List<GathererStatus> buildGatherers() {
    return this.gatherers != null ? build(gatherers) : null;
  }
  
  public InsightsReport buildInsightsReport() {
    return this.insightsReport != null ? this.insightsReport.build() : null;
  }
  
  public GathererStatus buildLastGatherer() {
    return this.gatherers.get(gatherers.size() - 1).build();
  }
  
  public ObjectReference buildLastRelatedObject() {
    return this.relatedObjects.get(relatedObjects.size() - 1).build();
  }
  
  public GathererStatus buildMatchingGatherer(Predicate<GathererStatusBuilder> predicate) {
      for (GathererStatusBuilder item : gatherers) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public ObjectReference buildMatchingRelatedObject(Predicate<ObjectReferenceBuilder> predicate) {
      for (ObjectReferenceBuilder item : relatedObjects) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public ObjectReference buildRelatedObject(int index) {
    return this.relatedObjects.get(index).build();
  }
  
  public List<ObjectReference> buildRelatedObjects() {
    return this.relatedObjects != null ? build(relatedObjects) : null;
  }
  
  protected void copyInstance(DataGatherStatus instance) {
    instance = instance != null ? instance : new DataGatherStatus();
    if (instance != null) {
        this.withConditions(instance.getConditions());
        this.withFinishTime(instance.getFinishTime());
        this.withGatherers(instance.getGatherers());
        this.withInsightsReport(instance.getInsightsReport());
        this.withInsightsRequestID(instance.getInsightsRequestID());
        this.withRelatedObjects(instance.getRelatedObjects());
        this.withStartTime(instance.getStartTime());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public GatherersNested<A> editFirstGatherer() {
    if (gatherers.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "gatherers"));
    }
    return this.setNewGathererLike(0, this.buildGatherer(0));
  }
  
  public RelatedObjectsNested<A> editFirstRelatedObject() {
    if (relatedObjects.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "relatedObjects"));
    }
    return this.setNewRelatedObjectLike(0, this.buildRelatedObject(0));
  }
  
  public GatherersNested<A> editGatherer(int index) {
    if (gatherers.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "gatherers"));
    }
    return this.setNewGathererLike(index, this.buildGatherer(index));
  }
  
  public InsightsReportNested<A> editInsightsReport() {
    return this.withNewInsightsReportLike(Optional.ofNullable(this.buildInsightsReport()).orElse(null));
  }
  
  public GatherersNested<A> editLastGatherer() {
    int index = gatherers.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "gatherers"));
    }
    return this.setNewGathererLike(index, this.buildGatherer(index));
  }
  
  public RelatedObjectsNested<A> editLastRelatedObject() {
    int index = relatedObjects.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "relatedObjects"));
    }
    return this.setNewRelatedObjectLike(index, this.buildRelatedObject(index));
  }
  
  public GatherersNested<A> editMatchingGatherer(Predicate<GathererStatusBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < gatherers.size();i++) {
      if (predicate.test(gatherers.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "gatherers"));
    }
    return this.setNewGathererLike(index, this.buildGatherer(index));
  }
  
  public RelatedObjectsNested<A> editMatchingRelatedObject(Predicate<ObjectReferenceBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < relatedObjects.size();i++) {
      if (predicate.test(relatedObjects.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "relatedObjects"));
    }
    return this.setNewRelatedObjectLike(index, this.buildRelatedObject(index));
  }
  
  public InsightsReportNested<A> editOrNewInsightsReport() {
    return this.withNewInsightsReportLike(Optional.ofNullable(this.buildInsightsReport()).orElse(new InsightsReportBuilder().build()));
  }
  
  public InsightsReportNested<A> editOrNewInsightsReportLike(InsightsReport item) {
    return this.withNewInsightsReportLike(Optional.ofNullable(this.buildInsightsReport()).orElse(item));
  }
  
  public RelatedObjectsNested<A> editRelatedObject(int index) {
    if (relatedObjects.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "relatedObjects"));
    }
    return this.setNewRelatedObjectLike(index, this.buildRelatedObject(index));
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
    DataGatherStatusFluent that = (DataGatherStatusFluent) o;
    if (!(Objects.equals(conditions, that.conditions))) {
      return false;
    }
    if (!(Objects.equals(finishTime, that.finishTime))) {
      return false;
    }
    if (!(Objects.equals(gatherers, that.gatherers))) {
      return false;
    }
    if (!(Objects.equals(insightsReport, that.insightsReport))) {
      return false;
    }
    if (!(Objects.equals(insightsRequestID, that.insightsRequestID))) {
      return false;
    }
    if (!(Objects.equals(relatedObjects, that.relatedObjects))) {
      return false;
    }
    if (!(Objects.equals(startTime, that.startTime))) {
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
  
  public Condition getCondition(int index) {
    return this.conditions.get(index);
  }
  
  public List<Condition> getConditions() {
    return this.conditions;
  }
  
  public String getFinishTime() {
    return this.finishTime;
  }
  
  public Condition getFirstCondition() {
    return this.conditions.get(0);
  }
  
  public String getInsightsRequestID() {
    return this.insightsRequestID;
  }
  
  public Condition getLastCondition() {
    return this.conditions.get(conditions.size() - 1);
  }
  
  public Condition getMatchingCondition(Predicate<Condition> predicate) {
      for (Condition item : conditions) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public String getStartTime() {
    return this.startTime;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasConditions() {
    return this.conditions != null && !(this.conditions.isEmpty());
  }
  
  public boolean hasFinishTime() {
    return this.finishTime != null;
  }
  
  public boolean hasGatherers() {
    return this.gatherers != null && !(this.gatherers.isEmpty());
  }
  
  public boolean hasInsightsReport() {
    return this.insightsReport != null;
  }
  
  public boolean hasInsightsRequestID() {
    return this.insightsRequestID != null;
  }
  
  public boolean hasMatchingCondition(Predicate<Condition> predicate) {
      for (Condition item : conditions) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingGatherer(Predicate<GathererStatusBuilder> predicate) {
      for (GathererStatusBuilder item : gatherers) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingRelatedObject(Predicate<ObjectReferenceBuilder> predicate) {
      for (ObjectReferenceBuilder item : relatedObjects) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasRelatedObjects() {
    return this.relatedObjects != null && !(this.relatedObjects.isEmpty());
  }
  
  public boolean hasStartTime() {
    return this.startTime != null;
  }
  
  public int hashCode() {
    return Objects.hash(conditions, finishTime, gatherers, insightsReport, insightsRequestID, relatedObjects, startTime, additionalProperties);
  }
  
  public A removeAllFromConditions(Collection<Condition> items) {
    if (this.conditions == null) {
      return (A) this;
    }
    for (Condition item : items) {
      this.conditions.remove(item);
    }
    return (A) this;
  }
  
  public A removeAllFromGatherers(Collection<GathererStatus> items) {
    if (this.gatherers == null) {
      return (A) this;
    }
    for (GathererStatus item : items) {
        GathererStatusBuilder builder = new GathererStatusBuilder(item);
        _visitables.get("gatherers").remove(builder);
        this.gatherers.remove(builder);
    }
    return (A) this;
  }
  
  public A removeAllFromRelatedObjects(Collection<ObjectReference> items) {
    if (this.relatedObjects == null) {
      return (A) this;
    }
    for (ObjectReference item : items) {
        ObjectReferenceBuilder builder = new ObjectReferenceBuilder(item);
        _visitables.get("relatedObjects").remove(builder);
        this.relatedObjects.remove(builder);
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
  
  public A removeFromConditions(Condition... items) {
    if (this.conditions == null) {
      return (A) this;
    }
    for (Condition item : items) {
      this.conditions.remove(item);
    }
    return (A) this;
  }
  
  public A removeFromGatherers(GathererStatus... items) {
    if (this.gatherers == null) {
      return (A) this;
    }
    for (GathererStatus item : items) {
        GathererStatusBuilder builder = new GathererStatusBuilder(item);
        _visitables.get("gatherers").remove(builder);
        this.gatherers.remove(builder);
    }
    return (A) this;
  }
  
  public A removeFromRelatedObjects(ObjectReference... items) {
    if (this.relatedObjects == null) {
      return (A) this;
    }
    for (ObjectReference item : items) {
        ObjectReferenceBuilder builder = new ObjectReferenceBuilder(item);
        _visitables.get("relatedObjects").remove(builder);
        this.relatedObjects.remove(builder);
    }
    return (A) this;
  }
  
  public A removeMatchingFromGatherers(Predicate<GathererStatusBuilder> predicate) {
    if (gatherers == null) {
      return (A) this;
    }
    Iterator<GathererStatusBuilder> each = gatherers.iterator();
    List visitables = _visitables.get("gatherers");
    while (each.hasNext()) {
        GathererStatusBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public A removeMatchingFromRelatedObjects(Predicate<ObjectReferenceBuilder> predicate) {
    if (relatedObjects == null) {
      return (A) this;
    }
    Iterator<ObjectReferenceBuilder> each = relatedObjects.iterator();
    List visitables = _visitables.get("relatedObjects");
    while (each.hasNext()) {
        ObjectReferenceBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public GatherersNested<A> setNewGathererLike(int index,GathererStatus item) {
    return new GatherersNested(index, item);
  }
  
  public RelatedObjectsNested<A> setNewRelatedObjectLike(int index,ObjectReference item) {
    return new RelatedObjectsNested(index, item);
  }
  
  public A setToConditions(int index,Condition item) {
    if (this.conditions == null) {
      this.conditions = new ArrayList();
    }
    this.conditions.set(index, item);
    return (A) this;
  }
  
  public A setToGatherers(int index,GathererStatus item) {
    if (this.gatherers == null) {
      this.gatherers = new ArrayList();
    }
    GathererStatusBuilder builder = new GathererStatusBuilder(item);
    if (index < 0 || index >= gatherers.size()) {
        _visitables.get("gatherers").add(builder);
        gatherers.add(builder);
    } else {
        _visitables.get("gatherers").add(builder);
        gatherers.set(index, builder);
    }
    return (A) this;
  }
  
  public A setToRelatedObjects(int index,ObjectReference item) {
    if (this.relatedObjects == null) {
      this.relatedObjects = new ArrayList();
    }
    ObjectReferenceBuilder builder = new ObjectReferenceBuilder(item);
    if (index < 0 || index >= relatedObjects.size()) {
        _visitables.get("relatedObjects").add(builder);
        relatedObjects.add(builder);
    } else {
        _visitables.get("relatedObjects").add(builder);
        relatedObjects.set(index, builder);
    }
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(conditions == null) && !(conditions.isEmpty())) {
        sb.append("conditions:");
        sb.append(conditions);
        sb.append(",");
    }
    if (!(finishTime == null)) {
        sb.append("finishTime:");
        sb.append(finishTime);
        sb.append(",");
    }
    if (!(gatherers == null) && !(gatherers.isEmpty())) {
        sb.append("gatherers:");
        sb.append(gatherers);
        sb.append(",");
    }
    if (!(insightsReport == null)) {
        sb.append("insightsReport:");
        sb.append(insightsReport);
        sb.append(",");
    }
    if (!(insightsRequestID == null)) {
        sb.append("insightsRequestID:");
        sb.append(insightsRequestID);
        sb.append(",");
    }
    if (!(relatedObjects == null) && !(relatedObjects.isEmpty())) {
        sb.append("relatedObjects:");
        sb.append(relatedObjects);
        sb.append(",");
    }
    if (!(startTime == null)) {
        sb.append("startTime:");
        sb.append(startTime);
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
  
  public A withConditions(List<Condition> conditions) {
    if (conditions != null) {
        this.conditions = new ArrayList();
        for (Condition item : conditions) {
          this.addToConditions(item);
        }
    } else {
      this.conditions = null;
    }
    return (A) this;
  }
  
  public A withConditions(Condition... conditions) {
    if (this.conditions != null) {
        this.conditions.clear();
        _visitables.remove("conditions");
    }
    if (conditions != null) {
      for (Condition item : conditions) {
        this.addToConditions(item);
      }
    }
    return (A) this;
  }
  
  public A withFinishTime(String finishTime) {
    this.finishTime = finishTime;
    return (A) this;
  }
  
  public A withGatherers(List<GathererStatus> gatherers) {
    if (this.gatherers != null) {
      this._visitables.get("gatherers").clear();
    }
    if (gatherers != null) {
        this.gatherers = new ArrayList();
        for (GathererStatus item : gatherers) {
          this.addToGatherers(item);
        }
    } else {
      this.gatherers = null;
    }
    return (A) this;
  }
  
  public A withGatherers(GathererStatus... gatherers) {
    if (this.gatherers != null) {
        this.gatherers.clear();
        _visitables.remove("gatherers");
    }
    if (gatherers != null) {
      for (GathererStatus item : gatherers) {
        this.addToGatherers(item);
      }
    }
    return (A) this;
  }
  
  public A withInsightsReport(InsightsReport insightsReport) {
    this._visitables.remove("insightsReport");
    if (insightsReport != null) {
        this.insightsReport = new InsightsReportBuilder(insightsReport);
        this._visitables.get("insightsReport").add(this.insightsReport);
    } else {
        this.insightsReport = null;
        this._visitables.get("insightsReport").remove(this.insightsReport);
    }
    return (A) this;
  }
  
  public A withInsightsRequestID(String insightsRequestID) {
    this.insightsRequestID = insightsRequestID;
    return (A) this;
  }
  
  public InsightsReportNested<A> withNewInsightsReport() {
    return new InsightsReportNested(null);
  }
  
  public InsightsReportNested<A> withNewInsightsReportLike(InsightsReport item) {
    return new InsightsReportNested(item);
  }
  
  public A withRelatedObjects(List<ObjectReference> relatedObjects) {
    if (this.relatedObjects != null) {
      this._visitables.get("relatedObjects").clear();
    }
    if (relatedObjects != null) {
        this.relatedObjects = new ArrayList();
        for (ObjectReference item : relatedObjects) {
          this.addToRelatedObjects(item);
        }
    } else {
      this.relatedObjects = null;
    }
    return (A) this;
  }
  
  public A withRelatedObjects(ObjectReference... relatedObjects) {
    if (this.relatedObjects != null) {
        this.relatedObjects.clear();
        _visitables.remove("relatedObjects");
    }
    if (relatedObjects != null) {
      for (ObjectReference item : relatedObjects) {
        this.addToRelatedObjects(item);
      }
    }
    return (A) this;
  }
  
  public A withStartTime(String startTime) {
    this.startTime = startTime;
    return (A) this;
  }
  public class GatherersNested<N> extends GathererStatusFluent<GatherersNested<N>> implements Nested<N>{
  
    GathererStatusBuilder builder;
    int index;
  
    GatherersNested(int index,GathererStatus item) {
      this.index = index;
      this.builder = new GathererStatusBuilder(this, item);
    }
  
    public N and() {
      return (N) DataGatherStatusFluent.this.setToGatherers(index, builder.build());
    }
    
    public N endGatherer() {
      return and();
    }
    
  }
  public class InsightsReportNested<N> extends InsightsReportFluent<InsightsReportNested<N>> implements Nested<N>{
  
    InsightsReportBuilder builder;
  
    InsightsReportNested(InsightsReport item) {
      this.builder = new InsightsReportBuilder(this, item);
    }
  
    public N and() {
      return (N) DataGatherStatusFluent.this.withInsightsReport(builder.build());
    }
    
    public N endInsightsReport() {
      return and();
    }
    
  }
  public class RelatedObjectsNested<N> extends ObjectReferenceFluent<RelatedObjectsNested<N>> implements Nested<N>{
  
    ObjectReferenceBuilder builder;
    int index;
  
    RelatedObjectsNested(int index,ObjectReference item) {
      this.index = index;
      this.builder = new ObjectReferenceBuilder(this, item);
    }
  
    public N and() {
      return (N) DataGatherStatusFluent.this.setToRelatedObjects(index, builder.build());
    }
    
    public N endRelatedObject() {
      return and();
    }
    
  }
}