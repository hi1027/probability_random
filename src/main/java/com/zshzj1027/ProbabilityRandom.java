package com.zshzj1027;

import org.apache.commons.math3.distribution.EnumeratedIntegerDistribution;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ProbabilityRandom {
    public static void main(String[] args) {
        //产生的数字
        int[] numsToGenerate = new int[]{1, 2, 3, 4, 5};
        //概率分布 加起来等于1
        double[] discreteProbabilities = new double[]{0.1, 0.3, 0.3, 0.2, 0.1};

        EnumeratedIntegerDistribution distribution =
                new EnumeratedIntegerDistribution(numsToGenerate, discreteProbabilities);

        int numSamples = 100;
        int[] samples = distribution.sample(numSamples);
        String[] strings = Arrays.stream(samples).mapToObj(String::valueOf).toArray(String[]::new);
        List<String> strings1 = Arrays.asList(strings);
        Map<String, Long> collect = strings1.stream().collect(Collectors.groupingBy(i -> i, Collectors.counting()));
        collect.forEach((k, v) -> System.out.println(k + "--" + v));
    }
}

