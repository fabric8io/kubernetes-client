package io.fabric8.volcano.api.model.scheduling.v1beta1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import io.fabric8.kubernetes.api.model.Condition;
import io.fabric8.kubernetes.api.model.Quantity;
import java.lang.Integer;
import java.lang.Object;
import java.lang.String;
import java.lang.StringBuilder;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collection;
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
public class NamespaceQueueStatusFluent<A extends io.fabric8.volcano.api.model.scheduling.v1beta1.NamespaceQueueStatusFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private Map<String,Quantity> allocated;
  private Integer completed;
  private List<Condition> conditions = new ArrayList<Condition>();
  private Integer inqueue;
  private Integer pending;
  private ReservationBuilder reservation;
  private Integer running;
  private String state;
  private Integer unknown;

  public NamespaceQueueStatusFluent() {
  }
  
  public NamespaceQueueStatusFluent(NamespaceQueueStatus instance) {
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
  
  public A addToAllocated(Map<String,Quantity> map) {
    if (this.allocated == null && map != null) {
      this.allocated = new LinkedHashMap();
    }
    if (map != null) {
      this.allocated.putAll(map);
    }
    return (A) this;
  }
  
  public A addToAllocated(String key,Quantity value) {
    if (this.allocated == null && key != null && value != null) {
      this.allocated = new LinkedHashMap();
    }
    if (key != null && value != null) {
      this.allocated.put(key, value);
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
  
  public Reservation buildReservation() {
    return this.reservation != null ? this.reservation.build() : null;
  }
  
  protected void copyInstance(NamespaceQueueStatus instance) {
    instance = instance != null ? instance : new NamespaceQueueStatus();
    if (instance != null) {
        this.withAllocated(instance.getAllocated());
        this.withCompleted(instance.getCompleted());
        this.withConditions(instance.getConditions());
        this.withInqueue(instance.getInqueue());
        this.withPending(instance.getPending());
        this.withReservation(instance.getReservation());
        this.withRunning(instance.getRunning());
        this.withState(instance.getState());
        this.withUnknown(instance.getUnknown());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public ReservationNested<A> editOrNewReservation() {
    return this.withNewReservationLike(Optional.ofNullable(this.buildReservation()).orElse(new ReservationBuilder().build()));
  }
  
  public ReservationNested<A> editOrNewReservationLike(Reservation item) {
    return this.withNewReservationLike(Optional.ofNullable(this.buildReservation()).orElse(item));
  }
  
  public ReservationNested<A> editReservation() {
    return this.withNewReservationLike(Optional.ofNullable(this.buildReservation()).orElse(null));
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
    NamespaceQueueStatusFluent that = (NamespaceQueueStatusFluent) o;
    if (!(Objects.equals(allocated, that.allocated))) {
      return false;
    }
    if (!(Objects.equals(completed, that.completed))) {
      return false;
    }
    if (!(Objects.equals(conditions, that.conditions))) {
      return false;
    }
    if (!(Objects.equals(inqueue, that.inqueue))) {
      return false;
    }
    if (!(Objects.equals(pending, that.pending))) {
      return false;
    }
    if (!(Objects.equals(reservation, that.reservation))) {
      return false;
    }
    if (!(Objects.equals(running, that.running))) {
      return false;
    }
    if (!(Objects.equals(state, that.state))) {
      return false;
    }
    if (!(Objects.equals(unknown, that.unknown))) {
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
  
  public Map<String,Quantity> getAllocated() {
    return this.allocated;
  }
  
  public Integer getCompleted() {
    return this.completed;
  }
  
  public Condition getCondition(int index) {
    return this.conditions.get(index);
  }
  
  public List<Condition> getConditions() {
    return this.conditions;
  }
  
  public Condition getFirstCondition() {
    return this.conditions.get(0);
  }
  
  public Integer getInqueue() {
    return this.inqueue;
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
  
  public Integer getPending() {
    return this.pending;
  }
  
  public Integer getRunning() {
    return this.running;
  }
  
  public String getState() {
    return this.state;
  }
  
  public Integer getUnknown() {
    return this.unknown;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasAllocated() {
    return this.allocated != null;
  }
  
  public boolean hasCompleted() {
    return this.completed != null;
  }
  
  public boolean hasConditions() {
    return this.conditions != null && !(this.conditions.isEmpty());
  }
  
  public boolean hasInqueue() {
    return this.inqueue != null;
  }
  
  public boolean hasMatchingCondition(Predicate<Condition> predicate) {
      for (Condition item : conditions) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasPending() {
    return this.pending != null;
  }
  
  public boolean hasReservation() {
    return this.reservation != null;
  }
  
  public boolean hasRunning() {
    return this.running != null;
  }
  
  public boolean hasState() {
    return this.state != null;
  }
  
  public boolean hasUnknown() {
    return this.unknown != null;
  }
  
  public int hashCode() {
    return Objects.hash(allocated, completed, conditions, inqueue, pending, reservation, running, state, unknown, additionalProperties);
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
  
  public A removeFromAllocated(String key) {
    if (this.allocated == null) {
      return (A) this;
    }
    if (key != null && this.allocated != null) {
      this.allocated.remove(key);
    }
    return (A) this;
  }
  
  public A removeFromAllocated(Map<String,Quantity> map) {
    if (this.allocated == null) {
      return (A) this;
    }
    if (map != null) {
      for (Object key : map.keySet()) {
        if (this.allocated != null) {
          this.allocated.remove(key);
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
  
  public A setToConditions(int index,Condition item) {
    if (this.conditions == null) {
      this.conditions = new ArrayList();
    }
    this.conditions.set(index, item);
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(allocated == null) && !(allocated.isEmpty())) {
        sb.append("allocated:");
        sb.append(allocated);
        sb.append(",");
    }
    if (!(completed == null)) {
        sb.append("completed:");
        sb.append(completed);
        sb.append(",");
    }
    if (!(conditions == null) && !(conditions.isEmpty())) {
        sb.append("conditions:");
        sb.append(conditions);
        sb.append(",");
    }
    if (!(inqueue == null)) {
        sb.append("inqueue:");
        sb.append(inqueue);
        sb.append(",");
    }
    if (!(pending == null)) {
        sb.append("pending:");
        sb.append(pending);
        sb.append(",");
    }
    if (!(reservation == null)) {
        sb.append("reservation:");
        sb.append(reservation);
        sb.append(",");
    }
    if (!(running == null)) {
        sb.append("running:");
        sb.append(running);
        sb.append(",");
    }
    if (!(state == null)) {
        sb.append("state:");
        sb.append(state);
        sb.append(",");
    }
    if (!(unknown == null)) {
        sb.append("unknown:");
        sb.append(unknown);
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
  
  public <K,V>A withAllocated(Map<String,Quantity> allocated) {
    if (allocated == null) {
      this.allocated = null;
    } else {
      this.allocated = new LinkedHashMap(allocated);
    }
    return (A) this;
  }
  
  public A withCompleted(Integer completed) {
    this.completed = completed;
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
  
  public A withInqueue(Integer inqueue) {
    this.inqueue = inqueue;
    return (A) this;
  }
  
  public ReservationNested<A> withNewReservation() {
    return new ReservationNested(null);
  }
  
  public ReservationNested<A> withNewReservationLike(Reservation item) {
    return new ReservationNested(item);
  }
  
  public A withPending(Integer pending) {
    this.pending = pending;
    return (A) this;
  }
  
  public A withReservation(Reservation reservation) {
    this._visitables.remove("reservation");
    if (reservation != null) {
        this.reservation = new ReservationBuilder(reservation);
        this._visitables.get("reservation").add(this.reservation);
    } else {
        this.reservation = null;
        this._visitables.get("reservation").remove(this.reservation);
    }
    return (A) this;
  }
  
  public A withRunning(Integer running) {
    this.running = running;
    return (A) this;
  }
  
  public A withState(String state) {
    this.state = state;
    return (A) this;
  }
  
  public A withUnknown(Integer unknown) {
    this.unknown = unknown;
    return (A) this;
  }
  public class ReservationNested<N> extends ReservationFluent<ReservationNested<N>> implements Nested<N>{
  
    ReservationBuilder builder;
  
    ReservationNested(Reservation item) {
      this.builder = new ReservationBuilder(this, item);
    }
  
    public N and() {
      return (N) NamespaceQueueStatusFluent.this.withReservation(builder.build());
    }
    
    public N endReservation() {
      return and();
    }
    
  }
}