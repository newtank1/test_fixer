package nju.se.testfixer.harmony;

import com.google.gson.Gson;
import nju.se.testfixer.similarity.NodeComparator;
import nju.se.testfixer.similarity.node.Node;
import nju.se.testfixer.similarity.node.parser.JSONParser;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Map;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        Gson gson = new Gson();
        FileReader fileReader = new FileReader("response_副本.json");
        HypiumResponse hypiumResponse = gson.fromJson(fileReader, HypiumResponse.class);
        System.out.println(hypiumResponse);
        JSONParser jsonParser = new JSONParser();
        Node node1 = jsonParser.parseJSON(hypiumResponse.getData().getData());
        Node node2 = jsonParser.parseJSON(hypiumResponse.getData().getData());
        Map<Node, Node> nodeNodeMap = new NodeComparator().matchElements(node1, node2, 5);
        System.out.println(nodeNodeMap);
        System.out.println(node1);
//        List<Node> nodeList = NodeUtils.flatNodes(node).stream().filter(node1 -> StringUtils.isNoneBlank(node1.getTextContent())).collect(Collectors.toList());
//        System.out.println(nodeList);

    }
}
