package io.fabric8.kubernetes.client.utils.informers;

public enum EventType {
  ADDITION,

  UPDATION,

  DELETION,

  ERROR;

  public static EventType getByType(String type) {
    if (type != null && type.length() > 0) {
      for (EventType eventType : EventType.values()) {
        if (eventType.name().equalsIgnoreCase(type)) {
          return eventType;
        }
      }
    }
    return null;
  }
}
