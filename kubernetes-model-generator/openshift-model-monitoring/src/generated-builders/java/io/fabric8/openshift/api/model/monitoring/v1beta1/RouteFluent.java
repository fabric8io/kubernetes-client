package io.fabric8.openshift.api.model.monitoring.v1beta1;

import com.fasterxml.jackson.databind.JsonNode;
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
public class RouteFluent<A extends io.fabric8.openshift.api.model.monitoring.v1beta1.RouteFluent<A>> extends BaseFluent<A>{

  private Boolean _continue;
  private List<String> activeTimeIntervals = new ArrayList<String>();
  private Map<String,Object> additionalProperties;
  private List<String> groupBy = new ArrayList<String>();
  private String groupInterval;
  private String groupWait;
  private ArrayList<MatcherBuilder> matchers = new ArrayList<MatcherBuilder>();
  private List<String> muteTimeIntervals = new ArrayList<String>();
  private String receiver;
  private String repeatInterval;
  private List<JsonNode> routes = new ArrayList<JsonNode>();

  public RouteFluent() {
  }
  
  public RouteFluent(Route instance) {
    this.copyInstance(instance);
  }

  public A addAllToActiveTimeIntervals(Collection<String> items) {
    if (this.activeTimeIntervals == null) {
      this.activeTimeIntervals = new ArrayList();
    }
    for (String item : items) {
      this.activeTimeIntervals.add(item);
    }
    return (A) this;
  }
  
  public A addAllToGroupBy(Collection<String> items) {
    if (this.groupBy == null) {
      this.groupBy = new ArrayList();
    }
    for (String item : items) {
      this.groupBy.add(item);
    }
    return (A) this;
  }
  
  public A addAllToMatchers(Collection<Matcher> items) {
    if (this.matchers == null) {
      this.matchers = new ArrayList();
    }
    for (Matcher item : items) {
        MatcherBuilder builder = new MatcherBuilder(item);
        _visitables.get("matchers").add(builder);
        this.matchers.add(builder);
    }
    return (A) this;
  }
  
  public A addAllToMuteTimeIntervals(Collection<String> items) {
    if (this.muteTimeIntervals == null) {
      this.muteTimeIntervals = new ArrayList();
    }
    for (String item : items) {
      this.muteTimeIntervals.add(item);
    }
    return (A) this;
  }
  
  public A addAllToRoutes(Collection<JsonNode> items) {
    if (this.routes == null) {
      this.routes = new ArrayList();
    }
    for (JsonNode item : items) {
      this.routes.add(item);
    }
    return (A) this;
  }
  
  public MatchersNested<A> addNewMatcher() {
    return new MatchersNested(-1, null);
  }
  
  public A addNewMatcher(String matchType,String name,String value) {
    return (A) this.addToMatchers(new Matcher(matchType, name, value));
  }
  
  public MatchersNested<A> addNewMatcherLike(Matcher item) {
    return new MatchersNested(-1, item);
  }
  
  public A addToActiveTimeIntervals(String... items) {
    if (this.activeTimeIntervals == null) {
      this.activeTimeIntervals = new ArrayList();
    }
    for (String item : items) {
      this.activeTimeIntervals.add(item);
    }
    return (A) this;
  }
  
  public A addToActiveTimeIntervals(int index,String item) {
    if (this.activeTimeIntervals == null) {
      this.activeTimeIntervals = new ArrayList();
    }
    this.activeTimeIntervals.add(index, item);
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
  
  public A addToGroupBy(String... items) {
    if (this.groupBy == null) {
      this.groupBy = new ArrayList();
    }
    for (String item : items) {
      this.groupBy.add(item);
    }
    return (A) this;
  }
  
  public A addToGroupBy(int index,String item) {
    if (this.groupBy == null) {
      this.groupBy = new ArrayList();
    }
    this.groupBy.add(index, item);
    return (A) this;
  }
  
  public A addToMatchers(Matcher... items) {
    if (this.matchers == null) {
      this.matchers = new ArrayList();
    }
    for (Matcher item : items) {
        MatcherBuilder builder = new MatcherBuilder(item);
        _visitables.get("matchers").add(builder);
        this.matchers.add(builder);
    }
    return (A) this;
  }
  
  public A addToMatchers(int index,Matcher item) {
    if (this.matchers == null) {
      this.matchers = new ArrayList();
    }
    MatcherBuilder builder = new MatcherBuilder(item);
    if (index < 0 || index >= matchers.size()) {
        _visitables.get("matchers").add(builder);
        matchers.add(builder);
    } else {
        _visitables.get("matchers").add(builder);
        matchers.add(index, builder);
    }
    return (A) this;
  }
  
  public A addToMuteTimeIntervals(String... items) {
    if (this.muteTimeIntervals == null) {
      this.muteTimeIntervals = new ArrayList();
    }
    for (String item : items) {
      this.muteTimeIntervals.add(item);
    }
    return (A) this;
  }
  
  public A addToMuteTimeIntervals(int index,String item) {
    if (this.muteTimeIntervals == null) {
      this.muteTimeIntervals = new ArrayList();
    }
    this.muteTimeIntervals.add(index, item);
    return (A) this;
  }
  
  public A addToRoutes(JsonNode... items) {
    if (this.routes == null) {
      this.routes = new ArrayList();
    }
    for (JsonNode item : items) {
      this.routes.add(item);
    }
    return (A) this;
  }
  
  public A addToRoutes(int index,JsonNode item) {
    if (this.routes == null) {
      this.routes = new ArrayList();
    }
    this.routes.add(index, item);
    return (A) this;
  }
  
  public Matcher buildFirstMatcher() {
    return this.matchers.get(0).build();
  }
  
  public Matcher buildLastMatcher() {
    return this.matchers.get(matchers.size() - 1).build();
  }
  
  public Matcher buildMatcher(int index) {
    return this.matchers.get(index).build();
  }
  
  public List<Matcher> buildMatchers() {
    return this.matchers != null ? build(matchers) : null;
  }
  
  public Matcher buildMatchingMatcher(Predicate<MatcherBuilder> predicate) {
      for (MatcherBuilder item : matchers) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  protected void copyInstance(Route instance) {
    instance = instance != null ? instance : new Route();
    if (instance != null) {
        this.withActiveTimeIntervals(instance.getActiveTimeIntervals());
        this.withContinue(instance.getContinue());
        this.withGroupBy(instance.getGroupBy());
        this.withGroupInterval(instance.getGroupInterval());
        this.withGroupWait(instance.getGroupWait());
        this.withMatchers(instance.getMatchers());
        this.withMuteTimeIntervals(instance.getMuteTimeIntervals());
        this.withReceiver(instance.getReceiver());
        this.withRepeatInterval(instance.getRepeatInterval());
        this.withRoutes(instance.getRoutes());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public MatchersNested<A> editFirstMatcher() {
    if (matchers.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "matchers"));
    }
    return this.setNewMatcherLike(0, this.buildMatcher(0));
  }
  
  public MatchersNested<A> editLastMatcher() {
    int index = matchers.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "matchers"));
    }
    return this.setNewMatcherLike(index, this.buildMatcher(index));
  }
  
  public MatchersNested<A> editMatcher(int index) {
    if (matchers.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "matchers"));
    }
    return this.setNewMatcherLike(index, this.buildMatcher(index));
  }
  
  public MatchersNested<A> editMatchingMatcher(Predicate<MatcherBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < matchers.size();i++) {
      if (predicate.test(matchers.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "matchers"));
    }
    return this.setNewMatcherLike(index, this.buildMatcher(index));
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
    RouteFluent that = (RouteFluent) o;
    if (!(Objects.equals(activeTimeIntervals, that.activeTimeIntervals))) {
      return false;
    }
    if (!(Objects.equals(_continue, that._continue))) {
      return false;
    }
    if (!(Objects.equals(groupBy, that.groupBy))) {
      return false;
    }
    if (!(Objects.equals(groupInterval, that.groupInterval))) {
      return false;
    }
    if (!(Objects.equals(groupWait, that.groupWait))) {
      return false;
    }
    if (!(Objects.equals(matchers, that.matchers))) {
      return false;
    }
    if (!(Objects.equals(muteTimeIntervals, that.muteTimeIntervals))) {
      return false;
    }
    if (!(Objects.equals(receiver, that.receiver))) {
      return false;
    }
    if (!(Objects.equals(repeatInterval, that.repeatInterval))) {
      return false;
    }
    if (!(Objects.equals(routes, that.routes))) {
      return false;
    }
    if (!(Objects.equals(additionalProperties, that.additionalProperties))) {
      return false;
    }
    return true;
  }
  
  public String getActiveTimeInterval(int index) {
    return this.activeTimeIntervals.get(index);
  }
  
  public List<String> getActiveTimeIntervals() {
    return this.activeTimeIntervals;
  }
  
  public Map<String,Object> getAdditionalProperties() {
    return this.additionalProperties;
  }
  
  public Boolean getContinue() {
    return this._continue;
  }
  
  public String getFirstActiveTimeInterval() {
    return this.activeTimeIntervals.get(0);
  }
  
  public String getFirstGroupBy() {
    return this.groupBy.get(0);
  }
  
  public String getFirstMuteTimeInterval() {
    return this.muteTimeIntervals.get(0);
  }
  
  public JsonNode getFirstRoute() {
    return this.routes.get(0);
  }
  
  public List<String> getGroupBy() {
    return this.groupBy;
  }
  
  public String getGroupBy(int index) {
    return this.groupBy.get(index);
  }
  
  public String getGroupInterval() {
    return this.groupInterval;
  }
  
  public String getGroupWait() {
    return this.groupWait;
  }
  
  public String getLastActiveTimeInterval() {
    return this.activeTimeIntervals.get(activeTimeIntervals.size() - 1);
  }
  
  public String getLastGroupBy() {
    return this.groupBy.get(groupBy.size() - 1);
  }
  
  public String getLastMuteTimeInterval() {
    return this.muteTimeIntervals.get(muteTimeIntervals.size() - 1);
  }
  
  public JsonNode getLastRoute() {
    return this.routes.get(routes.size() - 1);
  }
  
  public String getMatchingActiveTimeInterval(Predicate<String> predicate) {
      for (String item : activeTimeIntervals) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public String getMatchingGroupBy(Predicate<String> predicate) {
      for (String item : groupBy) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public String getMatchingMuteTimeInterval(Predicate<String> predicate) {
      for (String item : muteTimeIntervals) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public JsonNode getMatchingRoute(Predicate<JsonNode> predicate) {
      for (JsonNode item : routes) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public String getMuteTimeInterval(int index) {
    return this.muteTimeIntervals.get(index);
  }
  
  public List<String> getMuteTimeIntervals() {
    return this.muteTimeIntervals;
  }
  
  public String getReceiver() {
    return this.receiver;
  }
  
  public String getRepeatInterval() {
    return this.repeatInterval;
  }
  
  public JsonNode getRoute(int index) {
    return this.routes.get(index);
  }
  
  public List<JsonNode> getRoutes() {
    return this.routes;
  }
  
  public boolean hasActiveTimeIntervals() {
    return this.activeTimeIntervals != null && !(this.activeTimeIntervals.isEmpty());
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasContinue() {
    return this._continue != null;
  }
  
  public boolean hasGroupBy() {
    return this.groupBy != null && !(this.groupBy.isEmpty());
  }
  
  public boolean hasGroupInterval() {
    return this.groupInterval != null;
  }
  
  public boolean hasGroupWait() {
    return this.groupWait != null;
  }
  
  public boolean hasMatchers() {
    return this.matchers != null && !(this.matchers.isEmpty());
  }
  
  public boolean hasMatchingActiveTimeInterval(Predicate<String> predicate) {
      for (String item : activeTimeIntervals) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingGroupBy(Predicate<String> predicate) {
      for (String item : groupBy) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingMatcher(Predicate<MatcherBuilder> predicate) {
      for (MatcherBuilder item : matchers) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingMuteTimeInterval(Predicate<String> predicate) {
      for (String item : muteTimeIntervals) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingRoute(Predicate<JsonNode> predicate) {
      for (JsonNode item : routes) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMuteTimeIntervals() {
    return this.muteTimeIntervals != null && !(this.muteTimeIntervals.isEmpty());
  }
  
  public boolean hasReceiver() {
    return this.receiver != null;
  }
  
  public boolean hasRepeatInterval() {
    return this.repeatInterval != null;
  }
  
  public boolean hasRoutes() {
    return this.routes != null && !(this.routes.isEmpty());
  }
  
  public int hashCode() {
    return Objects.hash(activeTimeIntervals, _continue, groupBy, groupInterval, groupWait, matchers, muteTimeIntervals, receiver, repeatInterval, routes, additionalProperties);
  }
  
  public A removeAllFromActiveTimeIntervals(Collection<String> items) {
    if (this.activeTimeIntervals == null) {
      return (A) this;
    }
    for (String item : items) {
      this.activeTimeIntervals.remove(item);
    }
    return (A) this;
  }
  
  public A removeAllFromGroupBy(Collection<String> items) {
    if (this.groupBy == null) {
      return (A) this;
    }
    for (String item : items) {
      this.groupBy.remove(item);
    }
    return (A) this;
  }
  
  public A removeAllFromMatchers(Collection<Matcher> items) {
    if (this.matchers == null) {
      return (A) this;
    }
    for (Matcher item : items) {
        MatcherBuilder builder = new MatcherBuilder(item);
        _visitables.get("matchers").remove(builder);
        this.matchers.remove(builder);
    }
    return (A) this;
  }
  
  public A removeAllFromMuteTimeIntervals(Collection<String> items) {
    if (this.muteTimeIntervals == null) {
      return (A) this;
    }
    for (String item : items) {
      this.muteTimeIntervals.remove(item);
    }
    return (A) this;
  }
  
  public A removeAllFromRoutes(Collection<JsonNode> items) {
    if (this.routes == null) {
      return (A) this;
    }
    for (JsonNode item : items) {
      this.routes.remove(item);
    }
    return (A) this;
  }
  
  public A removeFromActiveTimeIntervals(String... items) {
    if (this.activeTimeIntervals == null) {
      return (A) this;
    }
    for (String item : items) {
      this.activeTimeIntervals.remove(item);
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
  
  public A removeFromGroupBy(String... items) {
    if (this.groupBy == null) {
      return (A) this;
    }
    for (String item : items) {
      this.groupBy.remove(item);
    }
    return (A) this;
  }
  
  public A removeFromMatchers(Matcher... items) {
    if (this.matchers == null) {
      return (A) this;
    }
    for (Matcher item : items) {
        MatcherBuilder builder = new MatcherBuilder(item);
        _visitables.get("matchers").remove(builder);
        this.matchers.remove(builder);
    }
    return (A) this;
  }
  
  public A removeFromMuteTimeIntervals(String... items) {
    if (this.muteTimeIntervals == null) {
      return (A) this;
    }
    for (String item : items) {
      this.muteTimeIntervals.remove(item);
    }
    return (A) this;
  }
  
  public A removeFromRoutes(JsonNode... items) {
    if (this.routes == null) {
      return (A) this;
    }
    for (JsonNode item : items) {
      this.routes.remove(item);
    }
    return (A) this;
  }
  
  public A removeMatchingFromMatchers(Predicate<MatcherBuilder> predicate) {
    if (matchers == null) {
      return (A) this;
    }
    Iterator<MatcherBuilder> each = matchers.iterator();
    List visitables = _visitables.get("matchers");
    while (each.hasNext()) {
        MatcherBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public MatchersNested<A> setNewMatcherLike(int index,Matcher item) {
    return new MatchersNested(index, item);
  }
  
  public A setToActiveTimeIntervals(int index,String item) {
    if (this.activeTimeIntervals == null) {
      this.activeTimeIntervals = new ArrayList();
    }
    this.activeTimeIntervals.set(index, item);
    return (A) this;
  }
  
  public A setToGroupBy(int index,String item) {
    if (this.groupBy == null) {
      this.groupBy = new ArrayList();
    }
    this.groupBy.set(index, item);
    return (A) this;
  }
  
  public A setToMatchers(int index,Matcher item) {
    if (this.matchers == null) {
      this.matchers = new ArrayList();
    }
    MatcherBuilder builder = new MatcherBuilder(item);
    if (index < 0 || index >= matchers.size()) {
        _visitables.get("matchers").add(builder);
        matchers.add(builder);
    } else {
        _visitables.get("matchers").add(builder);
        matchers.set(index, builder);
    }
    return (A) this;
  }
  
  public A setToMuteTimeIntervals(int index,String item) {
    if (this.muteTimeIntervals == null) {
      this.muteTimeIntervals = new ArrayList();
    }
    this.muteTimeIntervals.set(index, item);
    return (A) this;
  }
  
  public A setToRoutes(int index,JsonNode item) {
    if (this.routes == null) {
      this.routes = new ArrayList();
    }
    this.routes.set(index, item);
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(activeTimeIntervals == null) && !(activeTimeIntervals.isEmpty())) {
        sb.append("activeTimeIntervals:");
        sb.append(activeTimeIntervals);
        sb.append(",");
    }
    if (!(_continue == null)) {
        sb.append("_continue:");
        sb.append(_continue);
        sb.append(",");
    }
    if (!(groupBy == null) && !(groupBy.isEmpty())) {
        sb.append("groupBy:");
        sb.append(groupBy);
        sb.append(",");
    }
    if (!(groupInterval == null)) {
        sb.append("groupInterval:");
        sb.append(groupInterval);
        sb.append(",");
    }
    if (!(groupWait == null)) {
        sb.append("groupWait:");
        sb.append(groupWait);
        sb.append(",");
    }
    if (!(matchers == null) && !(matchers.isEmpty())) {
        sb.append("matchers:");
        sb.append(matchers);
        sb.append(",");
    }
    if (!(muteTimeIntervals == null) && !(muteTimeIntervals.isEmpty())) {
        sb.append("muteTimeIntervals:");
        sb.append(muteTimeIntervals);
        sb.append(",");
    }
    if (!(receiver == null)) {
        sb.append("receiver:");
        sb.append(receiver);
        sb.append(",");
    }
    if (!(repeatInterval == null)) {
        sb.append("repeatInterval:");
        sb.append(repeatInterval);
        sb.append(",");
    }
    if (!(routes == null) && !(routes.isEmpty())) {
        sb.append("routes:");
        sb.append(routes);
        sb.append(",");
    }
    if (!(additionalProperties == null) && !(additionalProperties.isEmpty())) {
        sb.append("additionalProperties:");
        sb.append(additionalProperties);
    }
    sb.append("}");
    return sb.toString();
  }
  
  public A withActiveTimeIntervals(List<String> activeTimeIntervals) {
    if (activeTimeIntervals != null) {
        this.activeTimeIntervals = new ArrayList();
        for (String item : activeTimeIntervals) {
          this.addToActiveTimeIntervals(item);
        }
    } else {
      this.activeTimeIntervals = null;
    }
    return (A) this;
  }
  
  public A withActiveTimeIntervals(String... activeTimeIntervals) {
    if (this.activeTimeIntervals != null) {
        this.activeTimeIntervals.clear();
        _visitables.remove("activeTimeIntervals");
    }
    if (activeTimeIntervals != null) {
      for (String item : activeTimeIntervals) {
        this.addToActiveTimeIntervals(item);
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
  
  public A withContinue() {
    return withContinue(true);
  }
  
  public A withContinue(Boolean _continue) {
    this._continue = _continue;
    return (A) this;
  }
  
  public A withGroupBy(List<String> groupBy) {
    if (groupBy != null) {
        this.groupBy = new ArrayList();
        for (String item : groupBy) {
          this.addToGroupBy(item);
        }
    } else {
      this.groupBy = null;
    }
    return (A) this;
  }
  
  public A withGroupBy(String... groupBy) {
    if (this.groupBy != null) {
        this.groupBy.clear();
        _visitables.remove("groupBy");
    }
    if (groupBy != null) {
      for (String item : groupBy) {
        this.addToGroupBy(item);
      }
    }
    return (A) this;
  }
  
  public A withGroupInterval(String groupInterval) {
    this.groupInterval = groupInterval;
    return (A) this;
  }
  
  public A withGroupWait(String groupWait) {
    this.groupWait = groupWait;
    return (A) this;
  }
  
  public A withMatchers(List<Matcher> matchers) {
    if (this.matchers != null) {
      this._visitables.get("matchers").clear();
    }
    if (matchers != null) {
        this.matchers = new ArrayList();
        for (Matcher item : matchers) {
          this.addToMatchers(item);
        }
    } else {
      this.matchers = null;
    }
    return (A) this;
  }
  
  public A withMatchers(Matcher... matchers) {
    if (this.matchers != null) {
        this.matchers.clear();
        _visitables.remove("matchers");
    }
    if (matchers != null) {
      for (Matcher item : matchers) {
        this.addToMatchers(item);
      }
    }
    return (A) this;
  }
  
  public A withMuteTimeIntervals(List<String> muteTimeIntervals) {
    if (muteTimeIntervals != null) {
        this.muteTimeIntervals = new ArrayList();
        for (String item : muteTimeIntervals) {
          this.addToMuteTimeIntervals(item);
        }
    } else {
      this.muteTimeIntervals = null;
    }
    return (A) this;
  }
  
  public A withMuteTimeIntervals(String... muteTimeIntervals) {
    if (this.muteTimeIntervals != null) {
        this.muteTimeIntervals.clear();
        _visitables.remove("muteTimeIntervals");
    }
    if (muteTimeIntervals != null) {
      for (String item : muteTimeIntervals) {
        this.addToMuteTimeIntervals(item);
      }
    }
    return (A) this;
  }
  
  public A withReceiver(String receiver) {
    this.receiver = receiver;
    return (A) this;
  }
  
  public A withRepeatInterval(String repeatInterval) {
    this.repeatInterval = repeatInterval;
    return (A) this;
  }
  
  public A withRoutes(List<JsonNode> routes) {
    if (routes != null) {
        this.routes = new ArrayList();
        for (JsonNode item : routes) {
          this.addToRoutes(item);
        }
    } else {
      this.routes = null;
    }
    return (A) this;
  }
  
  public A withRoutes(JsonNode... routes) {
    if (this.routes != null) {
        this.routes.clear();
        _visitables.remove("routes");
    }
    if (routes != null) {
      for (JsonNode item : routes) {
        this.addToRoutes(item);
      }
    }
    return (A) this;
  }
  public class MatchersNested<N> extends MatcherFluent<MatchersNested<N>> implements Nested<N>{
  
    MatcherBuilder builder;
    int index;
  
    MatchersNested(int index,Matcher item) {
      this.index = index;
      this.builder = new MatcherBuilder(this, item);
    }
  
    public N and() {
      return (N) RouteFluent.this.setToMatchers(index, builder.build());
    }
    
    public N endMatcher() {
      return and();
    }
    
  }
}