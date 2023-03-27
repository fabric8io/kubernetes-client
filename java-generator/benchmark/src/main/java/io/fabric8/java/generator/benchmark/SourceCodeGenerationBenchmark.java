/**
 * Copyright (C) 2015 Red Hat, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.fabric8.java.generator.benchmark;

import io.fabric8.java.generator.Config;
import io.fabric8.java.generator.FileJavaGenerator;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Measurement;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.annotations.Warmup;
import org.openjdk.jmh.infra.Blackhole;

import java.io.File;
import java.util.concurrent.TimeUnit;

@State(Scope.Benchmark)
@Warmup(iterations = 5)
@Measurement(iterations = 10)
@OutputTimeUnit(TimeUnit.SECONDS)
@Fork(2)
public class SourceCodeGenerationBenchmark {

  private FileJavaGenerator generator;

  @Setup
  public void setup() {
    final Config config = new Config(
        null,
        null,
        true,
        null);

    File source = new File("src/main/resources/kserve.yaml");
    generator = new FileJavaGenerator(config, source);
  }

  @Benchmark
  @BenchmarkMode(Mode.Throughput)
  public void benchmark(Blackhole bh) {
    File outputDirectory = new File("target/generated");
    generator.run(outputDirectory);
    bh.consume(outputDirectory);
  }
}
