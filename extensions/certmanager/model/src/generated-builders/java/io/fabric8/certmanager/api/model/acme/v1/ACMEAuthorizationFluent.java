package io.fabric8.certmanager.api.model.acme.v1;

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
public class ACMEAuthorizationFluent<A extends io.fabric8.certmanager.api.model.acme.v1.ACMEAuthorizationFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private ArrayList<ACMEChallengeBuilder> challenges = new ArrayList<ACMEChallengeBuilder>();
  private String identifier;
  private String initialState;
  private String url;
  private Boolean wildcard;

  public ACMEAuthorizationFluent() {
  }
  
  public ACMEAuthorizationFluent(ACMEAuthorization instance) {
    this.copyInstance(instance);
  }

  public A addAllToChallenges(Collection<ACMEChallenge> items) {
    if (this.challenges == null) {
      this.challenges = new ArrayList();
    }
    for (ACMEChallenge item : items) {
        ACMEChallengeBuilder builder = new ACMEChallengeBuilder(item);
        _visitables.get("challenges").add(builder);
        this.challenges.add(builder);
    }
    return (A) this;
  }
  
  public ChallengesNested<A> addNewChallenge() {
    return new ChallengesNested(-1, null);
  }
  
  public A addNewChallenge(String token,String type,String url) {
    return (A) this.addToChallenges(new ACMEChallenge(token, type, url));
  }
  
  public ChallengesNested<A> addNewChallengeLike(ACMEChallenge item) {
    return new ChallengesNested(-1, item);
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
  
  public A addToChallenges(ACMEChallenge... items) {
    if (this.challenges == null) {
      this.challenges = new ArrayList();
    }
    for (ACMEChallenge item : items) {
        ACMEChallengeBuilder builder = new ACMEChallengeBuilder(item);
        _visitables.get("challenges").add(builder);
        this.challenges.add(builder);
    }
    return (A) this;
  }
  
  public A addToChallenges(int index,ACMEChallenge item) {
    if (this.challenges == null) {
      this.challenges = new ArrayList();
    }
    ACMEChallengeBuilder builder = new ACMEChallengeBuilder(item);
    if (index < 0 || index >= challenges.size()) {
        _visitables.get("challenges").add(builder);
        challenges.add(builder);
    } else {
        _visitables.get("challenges").add(builder);
        challenges.add(index, builder);
    }
    return (A) this;
  }
  
  public ACMEChallenge buildChallenge(int index) {
    return this.challenges.get(index).build();
  }
  
  public List<ACMEChallenge> buildChallenges() {
    return this.challenges != null ? build(challenges) : null;
  }
  
  public ACMEChallenge buildFirstChallenge() {
    return this.challenges.get(0).build();
  }
  
  public ACMEChallenge buildLastChallenge() {
    return this.challenges.get(challenges.size() - 1).build();
  }
  
  public ACMEChallenge buildMatchingChallenge(Predicate<ACMEChallengeBuilder> predicate) {
      for (ACMEChallengeBuilder item : challenges) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  protected void copyInstance(ACMEAuthorization instance) {
    instance = instance != null ? instance : new ACMEAuthorization();
    if (instance != null) {
        this.withChallenges(instance.getChallenges());
        this.withIdentifier(instance.getIdentifier());
        this.withInitialState(instance.getInitialState());
        this.withUrl(instance.getUrl());
        this.withWildcard(instance.getWildcard());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public ChallengesNested<A> editChallenge(int index) {
    if (challenges.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "challenges"));
    }
    return this.setNewChallengeLike(index, this.buildChallenge(index));
  }
  
  public ChallengesNested<A> editFirstChallenge() {
    if (challenges.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "challenges"));
    }
    return this.setNewChallengeLike(0, this.buildChallenge(0));
  }
  
  public ChallengesNested<A> editLastChallenge() {
    int index = challenges.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "challenges"));
    }
    return this.setNewChallengeLike(index, this.buildChallenge(index));
  }
  
  public ChallengesNested<A> editMatchingChallenge(Predicate<ACMEChallengeBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < challenges.size();i++) {
      if (predicate.test(challenges.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "challenges"));
    }
    return this.setNewChallengeLike(index, this.buildChallenge(index));
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
    ACMEAuthorizationFluent that = (ACMEAuthorizationFluent) o;
    if (!(Objects.equals(challenges, that.challenges))) {
      return false;
    }
    if (!(Objects.equals(identifier, that.identifier))) {
      return false;
    }
    if (!(Objects.equals(initialState, that.initialState))) {
      return false;
    }
    if (!(Objects.equals(url, that.url))) {
      return false;
    }
    if (!(Objects.equals(wildcard, that.wildcard))) {
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
  
  public String getIdentifier() {
    return this.identifier;
  }
  
  public String getInitialState() {
    return this.initialState;
  }
  
  public String getUrl() {
    return this.url;
  }
  
  public Boolean getWildcard() {
    return this.wildcard;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasChallenges() {
    return this.challenges != null && !(this.challenges.isEmpty());
  }
  
  public boolean hasIdentifier() {
    return this.identifier != null;
  }
  
  public boolean hasInitialState() {
    return this.initialState != null;
  }
  
  public boolean hasMatchingChallenge(Predicate<ACMEChallengeBuilder> predicate) {
      for (ACMEChallengeBuilder item : challenges) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasUrl() {
    return this.url != null;
  }
  
  public boolean hasWildcard() {
    return this.wildcard != null;
  }
  
  public int hashCode() {
    return Objects.hash(challenges, identifier, initialState, url, wildcard, additionalProperties);
  }
  
  public A removeAllFromChallenges(Collection<ACMEChallenge> items) {
    if (this.challenges == null) {
      return (A) this;
    }
    for (ACMEChallenge item : items) {
        ACMEChallengeBuilder builder = new ACMEChallengeBuilder(item);
        _visitables.get("challenges").remove(builder);
        this.challenges.remove(builder);
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
  
  public A removeFromChallenges(ACMEChallenge... items) {
    if (this.challenges == null) {
      return (A) this;
    }
    for (ACMEChallenge item : items) {
        ACMEChallengeBuilder builder = new ACMEChallengeBuilder(item);
        _visitables.get("challenges").remove(builder);
        this.challenges.remove(builder);
    }
    return (A) this;
  }
  
  public A removeMatchingFromChallenges(Predicate<ACMEChallengeBuilder> predicate) {
    if (challenges == null) {
      return (A) this;
    }
    Iterator<ACMEChallengeBuilder> each = challenges.iterator();
    List visitables = _visitables.get("challenges");
    while (each.hasNext()) {
        ACMEChallengeBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public ChallengesNested<A> setNewChallengeLike(int index,ACMEChallenge item) {
    return new ChallengesNested(index, item);
  }
  
  public A setToChallenges(int index,ACMEChallenge item) {
    if (this.challenges == null) {
      this.challenges = new ArrayList();
    }
    ACMEChallengeBuilder builder = new ACMEChallengeBuilder(item);
    if (index < 0 || index >= challenges.size()) {
        _visitables.get("challenges").add(builder);
        challenges.add(builder);
    } else {
        _visitables.get("challenges").add(builder);
        challenges.set(index, builder);
    }
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(challenges == null) && !(challenges.isEmpty())) {
        sb.append("challenges:");
        sb.append(challenges);
        sb.append(",");
    }
    if (!(identifier == null)) {
        sb.append("identifier:");
        sb.append(identifier);
        sb.append(",");
    }
    if (!(initialState == null)) {
        sb.append("initialState:");
        sb.append(initialState);
        sb.append(",");
    }
    if (!(url == null)) {
        sb.append("url:");
        sb.append(url);
        sb.append(",");
    }
    if (!(wildcard == null)) {
        sb.append("wildcard:");
        sb.append(wildcard);
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
  
  public A withChallenges(List<ACMEChallenge> challenges) {
    if (this.challenges != null) {
      this._visitables.get("challenges").clear();
    }
    if (challenges != null) {
        this.challenges = new ArrayList();
        for (ACMEChallenge item : challenges) {
          this.addToChallenges(item);
        }
    } else {
      this.challenges = null;
    }
    return (A) this;
  }
  
  public A withChallenges(ACMEChallenge... challenges) {
    if (this.challenges != null) {
        this.challenges.clear();
        _visitables.remove("challenges");
    }
    if (challenges != null) {
      for (ACMEChallenge item : challenges) {
        this.addToChallenges(item);
      }
    }
    return (A) this;
  }
  
  public A withIdentifier(String identifier) {
    this.identifier = identifier;
    return (A) this;
  }
  
  public A withInitialState(String initialState) {
    this.initialState = initialState;
    return (A) this;
  }
  
  public A withUrl(String url) {
    this.url = url;
    return (A) this;
  }
  
  public A withWildcard() {
    return withWildcard(true);
  }
  
  public A withWildcard(Boolean wildcard) {
    this.wildcard = wildcard;
    return (A) this;
  }
  public class ChallengesNested<N> extends ACMEChallengeFluent<ChallengesNested<N>> implements Nested<N>{
  
    ACMEChallengeBuilder builder;
    int index;
  
    ChallengesNested(int index,ACMEChallenge item) {
      this.index = index;
      this.builder = new ACMEChallengeBuilder(this, item);
    }
  
    public N and() {
      return (N) ACMEAuthorizationFluent.this.setToChallenges(index, builder.build());
    }
    
    public N endChallenge() {
      return and();
    }
    
  }
}