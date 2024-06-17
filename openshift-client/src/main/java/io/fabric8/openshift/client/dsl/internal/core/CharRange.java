package io.fabric8.openshift.client.dsl.internal.core;

final class CharRange {
  private final char start;
  private final char end;

  private CharRange(char start, char end) {
    this.start = start;
    this.end = end;
  }

  public char start() {
    return start;
  }

  public char end() {
    return end;
  }

  public static Builder builder() {
    return new Builder();
  }

  public static class Builder {
    private char start;
    private char end;

    Builder() {}

    public Builder withStart(char start) {
      this.start = start;
      return this;
    }

    public Builder withEnd(char end) {
      this.end = end;
      return this;
    }

    public CharRange build() {
      return new CharRange(start, end);
    }
  }
}
