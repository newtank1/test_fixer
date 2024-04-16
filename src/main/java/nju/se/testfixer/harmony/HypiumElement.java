package nju.se.testfixer.harmony;

import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
public class HypiumElement {
        private Map<String, String> attributes;

        private List<Integer> bounds;

        private List<HypiumElement> children;

        private String hierarchy;
        private String label;
        private String node_id;
        private String path;
}
