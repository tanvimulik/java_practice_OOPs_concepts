package stream;

import java.util.*;
import java.util.stream.*;

public class SignalProcessing {

    public static void main(String[] args) {

        // Sample input signal
        List<Double> signal = Arrays.asList(0.2, 0.7, 1.5, 3.2, 4.8, 2.5, 0.4, 4.0);

        double lowerThreshold = 0.5;
        double upperThreshold = 4.5;

        // Step 1 + 2 + 3 → FILTER + MULTIPLY using Stream
        List<Double> processedSignal = signal.stream()
                .filter(v -> v >= lowerThreshold && v <= upperThreshold) // filtering
                .map(v -> v * 2) // multiplying
                .collect(Collectors.toList()); // collect into list

        // Print processed signal
        System.out.println("Processed Signal: " + processedSignal);

        // Step 4 → Find MIN
        Optional<Double> min = processedSignal.stream()
                .min(Double::compare);

        // Step 5 → Find MAX
        Optional<Double> max = processedSignal.stream()
                .max(Double::compare);

        // Display results
        if (min.isPresent() && max.isPresent()) {
            System.out.println("Minimum Amplitude: " + min.get());
            System.out.println("Maximum Amplitude: " + max.get());
        } else {
            System.out.println("No valid signal values after filtering.");
        }
    }
}
