package io.fabric8.java.generator.benchmark;

import java.io.File;
import java.util.concurrent.TimeUnit;

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
        null,
        null,
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
