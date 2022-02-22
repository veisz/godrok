package hu.godrok.model.domain;

import java.util.List;
import java.util.stream.Collectors;

public class DataParser {

    public List<Integer> parse(List<String> lines) {
       return lines.stream()
               .map(Integer::valueOf)
               .collect(Collectors.toList());
    }
}
